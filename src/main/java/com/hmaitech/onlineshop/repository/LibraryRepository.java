package com.hmaitech.onlineshop.repository;

import com.hmaitech.onlineshop.model.entity.Library;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Qualifier("libraryRepository")
public interface LibraryRepository extends BaseRepository<Library, Long> {

}
