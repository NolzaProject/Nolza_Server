package me.nolza.service.Impl;

import me.nolza.domain.Keyword;
import me.nolza.repository.KeywordRepository;
import me.nolza.service.custom.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gain on 2017. 8. 19..
 */
@Service
public class KeywordServiceImpl implements KeywordService {

    @Autowired
    private KeywordRepository keywordRepository;

    @Override
    public void createKeyword(String keyword) {
        Keyword kw = new Keyword();
        kw.setKeyword(keyword);
        this.keywordRepository.save(kw);
    }

    @Override
    public void deleteKeyword(Long Id) {
        this.keywordRepository.delete(Id);
    }

    @Override
    public List<Keyword> getKeywordList() {
        List<Keyword> keywordList = this.keywordRepository.findAll();
        return keywordList;
    }
}
