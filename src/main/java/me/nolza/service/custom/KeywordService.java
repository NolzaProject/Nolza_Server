package me.nolza.service.custom;

import me.nolza.domain.Keyword;

import java.util.List;

/**
 * Created by gain on 2017. 8. 19..
 */
public interface KeywordService{
    void createKeyword(String keyword);
    void deleteKeyword(Long Id);
    List<Keyword> getKeywordList();
}
