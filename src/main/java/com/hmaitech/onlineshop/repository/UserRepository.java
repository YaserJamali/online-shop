package com.hmaitech.onlineshop.repository;

import com.hmaitech.onlineshop.model.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("userRepository")
public interface UserRepository extends BaseRepository<User, Long> {
}
