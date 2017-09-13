package me.nolza.repository;

import me.nolza.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gain on 2017. 8. 7..
 */
@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    List<Mission> findByDescriptionContaining(String description);
}
