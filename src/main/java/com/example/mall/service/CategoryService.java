package com.example.mall.service;

import com.example.mall.model.pojo.Category;
import com.example.mall.model.request.AddCategoryReq;
import com.example.mall.model.vo.CategoryVO;
import com.github.pagehelper.PageInfo;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

/**
 * 分类目录Service
 */
public interface CategoryService {
    void add(AddCategoryReq addCategoryReq);

    void update(Category updateCategory);

    void delete(Integer id);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    List<CategoryVO> listCategoryForCustomer(Integer parentId);

}
