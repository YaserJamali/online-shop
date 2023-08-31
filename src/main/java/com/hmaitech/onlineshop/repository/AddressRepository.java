package com.hmaitech.onlineshop.repository;

import com.hmaitech.onlineshop.model.entity.AddressEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("addressRepository")
public interface AddressRepository extends BaseRepository<AddressEntity, Long> {
}
