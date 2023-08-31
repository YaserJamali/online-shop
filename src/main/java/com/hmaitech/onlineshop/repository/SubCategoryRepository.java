package com.hmaitech.onlineshop.repository;

import com.hmaitech.onlineshop.model.entity.SubCategoryEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("subCategoryRepository")
public interface SubCategoryRepository extends BaseRepository<SubCategoryEntity, Long> {
}
