package com.hmaitech.onlineshop.repository;

import com.hmaitech.onlineshop.model.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("categoryRepository")
public interface CategoryRepository extends BaseRepository<CategoryEntity, Long> {
}
