package me.nolza.service.custom;

import me.nolza.controller.model.request.CategoryRequest;
import me.nolza.controller.model.response.CategoryResponse;

import java.util.List;

/**
 * Created by gain on 2017. 8. 7..
 */
public interface CategoryService  {
    List<CategoryResponse> getCategoryList();
    void createCategory(CategoryRequest categoryRequest);
    void deleteCategory(Long id);
}
