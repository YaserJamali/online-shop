package com.hmaitech.onlineshop.controller;

import com.hmaitech.onlineshop.model.dto.BaseDto;
import com.hmaitech.onlineshop.model.entity.BaseEntity;
import com.hmaitech.onlineshop.model.mapper.BaseAbstractMapper;
import com.hmaitech.onlineshop.service.BaseAbstractService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Transactional(readOnly = true)
@Validated
@Slf4j
public abstract class BaseAbstractController<E extends BaseEntity, D extends BaseDto> {
    //    , S extends BaseAbstractService<E, ?>, M extends BaseAbstractMapper<D, E>

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseAbstractController.class);

    @Autowired
    private BaseAbstractService<E, ? extends JpaRepository<E, Long>> service;


    @Autowired
    private BaseAbstractMapper<D, E> mapper;


    @PostMapping("/save")
    @Transactional
    public D save(@Valid @RequestBody D d) {
//        LOGGER.info("SAVE Method Called");
//        LOGGER.info("Parameter Of The Save Method Called: "+d);
        service.save(mapper.dtoToEntity(d));
        return d;
    }

    @PutMapping("/update")
    @Transactional
    public D update(@Valid @RequestBody D d) {
//        LOGGER.info("UPDATE Method Called");
//        LOGGER.info("Parameter Of The UPDATE Method Called: "+d);
        service.update(mapper.dtoToEntity(d));
        return d;
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public D findById(@PathVariable Long id) {
        return mapper.entityToDto(service.findById(id));
    }

    @GetMapping("/find")
    public List<D> findAll() {
        return mapper.dtoToEntity(service.findAll());
    }


    @GetMapping("/find/{example}")
    public List<D> findByExample(@PathVariable D example) {
        return mapper.dtoToEntity(service.findByExample(mapper.dtoToEntity(example)));
    }

}
