package me.nolza.repository;

import me.nolza.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gain on 2017. 8. 7..
 */
@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

}
