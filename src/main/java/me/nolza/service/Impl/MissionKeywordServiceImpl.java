package me.nolza.service.Impl;

import me.nolza.controller.model.request.MissionKeywordRequest;
import me.nolza.domain.Keyword;
import me.nolza.domain.MissionKeyword;
import me.nolza.domain.MissionKeywordId;
import me.nolza.repository.MissionKeywordRepository;
import me.nolza.service.custom.MissionKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gain on 2017. 8. 21..
 */
@Service
public class MissionKeywordServiceImpl implements MissionKeywordService {

    @Autowired
    private MissionKeywordRepository missionKeywordRepository;

    @Override
    public void createMissionKeyword(MissionKeywordRequest missionKeywordRequest) {
        List<Long> keywordIds = missionKeywordRequest.getKeywordIds();

        for(Long keywordId : keywordIds){
            MissionKeyword missionKeyword = new MissionKeyword();
            missionKeyword.setMissionId(missionKeywordRequest.getMissionId());
            missionKeyword.setKeywordId(keywordId);

            this.missionKeywordRepository.save(missionKeyword);
        }
    }

    @Override
    public void deleteMissionKeyword(MissionKeywordRequest missionKeywordRequest) {
        List<Long> keywordIds = missionKeywordRequest.getKeywordIds();

        for(Long keywordId : keywordIds){
            MissionKeywordId missionKeywordId = new MissionKeywordId();
            missionKeywordId.setMissionId(missionKeywordId.getMissionId());
            missionKeywordId.setKeywordId(keywordId);

            this.missionKeywordRepository.delete(missionKeywordId);
        }
    }
}
