package me.nolza.controller;

import me.nolza.controller.model.response.NolzaApiResponse;
import me.nolza.domain.Keyword;
import me.nolza.service.custom.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by gain on 2017. 8. 19..
 */
@RestController
@RequestMapping(value = "api/v1/keyword")
public class KeywordController {

    @Autowired
    private KeywordService keywordService;

    @GetMapping()
    public NolzaApiResponse createKeyword(@RequestParam String keyword){
        this.keywordService.createKeyword(keyword);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @GetMapping("/delete/{Id}")
    public NolzaApiResponse deleteKeyword(@PathVariable Long Id){
        this.keywordService.deleteKeyword(Id);
        return new NolzaApiResponse(NolzaApiResponse.OK);
    }

    @GetMapping("/list")
    public NolzaApiResponse<List<Keyword>> getKeywordList(){
        List<Keyword> keywordList = this.keywordService.getKeywordList();
        return new NolzaApiResponse<>(keywordList);
    }

}
