package me.nolza.repository;

import me.nolza.domain.CategoryMission;
import me.nolza.domain.CategoryMissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gain on 2017. 8. 9..
 */
@Repository
public interface CategoryMissionRepository extends JpaRepository<CategoryMission, CategoryMissionId> {

    @Query("SELECT cm FROM CategoryMission cm WHERE cm.categoryId = :categoryId")
    List<CategoryMission> findByCategoryId(@Param("categoryId")Long categoryId);
}