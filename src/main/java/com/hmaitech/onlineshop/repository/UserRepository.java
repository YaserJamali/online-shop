package com.hmaitech.onlineshop.repository;

import com.hmaitech.onlineshop.model.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@Qualifier("userRepository")
public interface UserRepository extends BaseRepository<User, Long>, JpaSpecificationExecutor<User> {


    Optional<User> findByEmail(String email);

}
