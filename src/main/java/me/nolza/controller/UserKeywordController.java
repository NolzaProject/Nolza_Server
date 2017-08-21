package me.nolza.controller;

import me.nolza.controller.model.request.UserKeywordRequest;
import me.nolza.controller.model.response.NolzaApiResponse;
import me.nolza.service.custom.UserKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gain on 2017. 8. 21..
 */
@RestController
@RequestMapping(value = "/api/v1/uk")
public class UserKeywordController {
    @Autowired
    private UserKeywordService userKeywordService;

    @PostMapping()
    public NolzaApiResponse createUserKeyword(@RequestBody UserKeywordRequest userKeywordRequest){
        this.userKeywordService.createUserKeyword(userKeywordRequest);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @PostMapping("/delete")
    public NolzaApiResponse deleteCategoryMission(@RequestBody UserKeywordRequest userKeywordRequest){
         this.userKeywordService.deleteUserKeyword(userKeywordRequest);
         return new NolzaApiResponse(NolzaApiResponse.OK);
    }
}
