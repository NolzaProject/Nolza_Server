package me.nolza.service.Impl;

import lombok.extern.slf4j.Slf4j;
import me.nolza.controller.model.request.CategoryRequest;
import me.nolza.controller.model.response.CategoryResponse;
import me.nolza.domain.Category;
import me.nolza.repository.CategoryRepository;
import me.nolza.service.custom.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gain on 2017. 8. 7..
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getCategories(){
        List<Category> categories =  this.categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = new ArrayList<>();

        for(Category category : categories){
            CategoryResponse categoryResponse = new CategoryResponse();

            categoryResponse.setId(category.getId());
            categoryResponse.setTitle(category.getTitle());
            categoryResponse.setDescription(category.getDescription());

            categoryResponses.add(categoryResponse);
        }
        return categoryResponses;
    }

    @Override
    public void createCategory(CategoryRequest categoryRequest){
        Category category = new Category();
        category.setTitle(categoryRequest.getTitle());
        category.setDescription(categoryRequest.getDescription());
        this.categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long Id){
        this.categoryRepository.delete(Id);
    }
}
