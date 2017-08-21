package me.nolza.service.Impl;

import me.nolza.controller.model.request.UserKeywordRequest;
import me.nolza.domain.UserKeyword;
import me.nolza.domain.UserKeywordId;
import me.nolza.repository.UserKeywordRepository;
import me.nolza.service.custom.UserKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gain on 2017. 8. 21..
 */
@Service
public class UserKeywordServiceImpl implements UserKeywordService {

    @Autowired
    private UserKeywordRepository userKeywordRepository;

    @Override
    public void createUserKeyword(UserKeywordRequest userKeywordRequest) {
        List<Long> keywordIds = userKeywordRequest.getKeywordIds();

        for(Long keywordId : keywordIds){
            UserKeyword userKeyword = new UserKeyword();
            userKeyword.setUserId(userKeywordRequest.getUserId());
            userKeyword.setKeywordId(keywordId);
            this.userKeywordRepository.save(userKeyword);
        }
    }

    @Override
    public void deleteUserKeyword(UserKeywordRequest userKeywordRequest) {
        List<Long> keywordIds = userKeywordRequest.getKeywordIds();

        for(Long keywordId : keywordIds){
            UserKeywordId userKeywordId = new UserKeywordId();
            userKeywordId.setUserId(userKeywordRequest.getUserId());
            userKeywordId.setKeywordId(keywordId);
            this.userKeywordRepository.delete(userKeywordId);
        }
    }
}
