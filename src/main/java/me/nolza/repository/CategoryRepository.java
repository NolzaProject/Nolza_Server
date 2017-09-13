package me.nolza.repository;

import me.nolza.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gain on 2017. 8. 7..
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
