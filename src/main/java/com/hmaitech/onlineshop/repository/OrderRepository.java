package com.hmaitech.onlineshop.repository;

import com.hmaitech.onlineshop.model.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("orderRepository")
public interface OrderRepository extends BaseRepository<OrderEntity, Long> {
}
