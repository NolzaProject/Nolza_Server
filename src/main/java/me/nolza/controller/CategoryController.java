package me.nolza.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.HttpMethod;
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
@Api(description = "카테고리 API")
@RestController
@RequestMapping(value = "/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "파라미터 없음", notes = "전체 카테고리를 가져옵니다.")
    @RequestMapping(method = RequestMethod.GET, value = "")
    public NolzaApiResponse<List<CategoryResponse>> getCategories(){
        List<CategoryResponse> categoryResponses = this.categoryService.getCategories();
        return new NolzaApiResponse<>(categoryResponses);
    }


    @ApiOperation(value = "", notes = "카테고리를 생성합니다.")
    @RequestMapping(method = RequestMethod.POST)
    public NolzaApiResponse createCategory(@Valid @RequestBody CategoryRequest categoryRequest){
        this.categoryService.createCategory(categoryRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @ApiOperation(value = "카테고리 Id", notes = "Id에 해당하는 카테고리를 삭제합니다.")
    @RequestMapping(value = "/{Id}", method = RequestMethod.DELETE)
    public NolzaApiResponse deleteCategory(@PathVariable Long Id){
        this.categoryService.deleteCategory(Id);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }
}
