package me.nolza.repository;

import me.nolza.domain.UserKeyword;
import me.nolza.domain.UserKeywordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gain on 2017. 8. 19..
 */
@Repository
public interface UserKeywordRepository extends JpaRepository<UserKeyword, UserKeywordId> {
}
