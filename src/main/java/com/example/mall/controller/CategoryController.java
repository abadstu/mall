package com.example.mall.controller;

import com.example.mall.MallApplication;
import com.example.mall.common.ApiRestResponse;
import com.example.mall.common.Constant;
import com.example.mall.exception.MallExceptionEnum;
import com.example.mall.model.pojo.Category;
import com.example.mall.model.pojo.User;
import com.example.mall.model.request.AddCategoryReq;
import com.example.mall.model.request.UpdateCategoryReq;
import com.example.mall.model.vo.CategoryVO;
import com.example.mall.service.CategoryService;
import com.example.mall.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * 目录Controller
 */
@Controller
public class CategoryController {
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;

    /**
     * 后台添加目录
     */
    @ApiOperation("后台添加目录")
    @PostMapping("admin/category/add")
    @ResponseBody
    public ApiRestResponse addCategory(HttpSession session, @Valid @RequestBody AddCategoryReq addCategoryReq){

        User currentUser = (User) session.getAttribute(Constant.MALL_USER);
        if(currentUser == null){
            return ApiRestResponse.error(MallExceptionEnum.NEED_LOGIN);
        }
        //校验是否是管理员
        boolean adminRole = userService.checkAdminRole(currentUser);
        if(adminRole){
            //是管理员，执行操作
            categoryService.add(addCategoryReq);
            return ApiRestResponse.success();

        }else {
            return ApiRestResponse.error(MallExceptionEnum.NEED_ADMIN);
        }


    }

    @ApiOperation("后台添加更新目录")
    @PostMapping("admin/category/update")
    @ResponseBody
    public ApiRestResponse updateCategory(@Valid @RequestBody UpdateCategoryReq updateCategoryReq, HttpSession session){

        User currentUser = (User) session.getAttribute(Constant.MALL_USER);
        if(currentUser == null){
            return ApiRestResponse.error(MallExceptionEnum.NEED_LOGIN);
        }
        //校验是否是管理员
        boolean adminRole = userService.checkAdminRole(currentUser);
        if(adminRole){
            //是管理员，执行操作
            Category category = new Category();
            BeanUtils.copyProperties(updateCategoryReq,category);
            categoryService.update(category);
            return ApiRestResponse.success();

        }else {
            return ApiRestResponse.error(MallExceptionEnum.NEED_ADMIN);
        }
    }

    @ApiOperation("后台删除目录")
    @PostMapping("admin/category/delete")
    @ResponseBody
    public ApiRestResponse deleteCategory(@RequestParam Integer id){
        categoryService.delete(id);
        return ApiRestResponse.success();
    }
    @ApiOperation("后台目录列表")
    @GetMapping("admin/category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize){

        PageInfo pageInfo = categoryService.listForAdmin(pageNum,pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("前台目录列表")
    @GetMapping("category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForCustomer(){

        List<CategoryVO> categoryVOS = categoryService.listCategoryForCustomer(0);
        return ApiRestResponse.success(categoryVOS);
    }
}
