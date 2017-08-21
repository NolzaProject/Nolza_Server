package me.nolza.repository;

import me.nolza.domain.MissionKeyword;
import me.nolza.domain.MissionKeywordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gain on 2017. 8. 19..
 */
@Repository
public interface MissionKeywordRepository extends JpaRepository<MissionKeyword, MissionKeywordId> {
    @Query("SELECT mk FROM MissionKeyword mk WHERE mk.keywordId = :keywordId")
    List<MissionKeyword> findByKeywordId(@Param("keywordId")Long keywordId);

}
