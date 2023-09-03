package com.hmaitech.onlineshop.controller;

import com.hmaitech.onlineshop.model.converter.BaseConverter;
import com.hmaitech.onlineshop.model.dto.BaseDto;
import com.hmaitech.onlineshop.model.entity.BaseEntity;
import com.hmaitech.onlineshop.service.BaseAbstractService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
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
    private BaseConverter<D, E> mapper;


    @PostMapping("/save")
    @Transactional
    public D save(@Valid @RequestBody D d) {

        service.save(mapper.convertEntity(d));
        return d;
    }

    @PutMapping("/update")
    @Transactional
    public D update(@Valid @RequestBody D d) {
//        LOGGER.info("UPDATE Method Called");
//        LOGGER.info("Parameter Of The UPDATE Method Called: "+d);
        service.update(mapper.convertEntity(d));
        return d;
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public D findById(@PathVariable Long id) {
        return mapper.convertDto(service.findById(id));
    }

    @GetMapping("/find")
    public List<D> findAll(@PathParam("pageNumber") int pageNumber,
                           @PathParam("pageSize") int pageSize) {
        return mapper.convertDto(service.findAll(pageNumber, pageSize));
    }


    @PostMapping("/find")
    public List<D> findByExample(@RequestBody D example) {
        return mapper.convertDto(service.findByExample(mapper.convertEntity(example)));
    }

}