package me.nolza.controller;

import me.nolza.controller.model.request.CategoryRequest;
import me.nolza.controller.model.response.CategoryResponse;
import me.nolza.controller.model.response.NolzaApiResponse;
import me.nolza.service.custom.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by gain on 2017. 8. 7..
 */
@RestController
@RequestMapping(value = "/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public NolzaApiResponse<List<CategoryResponse>> getCategoryList(){
        List<CategoryResponse> categoryResponseList = this.categoryService.getCategoryList();
        return new NolzaApiResponse<>(categoryResponseList);
    }

    @PostMapping()
    public NolzaApiResponse createCategory(@Valid @RequestBody CategoryRequest categoryRequest){
        this.categoryService.createCategory(categoryRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @GetMapping("/delete/{Id}")
    public NolzaApiResponse deleteCategory(@PathVariable Long Id){
        this.categoryService.deleteCategory(Id);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }
}
