package me.nolza.repository;

import me.nolza.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gain on 2017. 8. 19..
 */
@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long>{
}
