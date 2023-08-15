package com.hmaitech.onlineshop.service;

import com.hmaitech.onlineshop.model.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseAbstractService<E extends BaseEntity, R extends JpaRepository<E, Long>> {

    @Autowired
    private R repository;




    public E save(E entity) {
        return repository.save(entity);
    }

    public E update(E entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public E findById(Long id) {
        return repository.findById(id).get();
    }

    public List<E> findAll() {

        return repository.findAll();
    }

    public List<E> findByExample(E entity) {

        return repository.findAll(Example.of(entity));
    }
}
