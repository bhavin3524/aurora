package com.phoenix.repository.mysqlrepo.CategoryDao;

import com.phoenix.model.CategoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryMaster, Long> {
}
