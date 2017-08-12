package me.nolza.repository;

import me.nolza.domain.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gain on 2017. 8. 12..
 */
@Repository
public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    @Query("SELECT um FROM UserMission um WHERE um.userId = :userId")
    List<UserMission> findByUserId(@Param("userId") Long userId);
}
