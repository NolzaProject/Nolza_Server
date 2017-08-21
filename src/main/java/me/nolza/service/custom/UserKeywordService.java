package me.nolza.service.custom;

import me.nolza.controller.model.request.UserKeywordRequest;

/**
 * Created by gain on 2017. 8. 21..
 */
public interface UserKeywordService {
    void createUserKeyword(UserKeywordRequest userKeywordRequest);
    void deleteUserKeyword(UserKeywordRequest userKeywordRequest);
}
