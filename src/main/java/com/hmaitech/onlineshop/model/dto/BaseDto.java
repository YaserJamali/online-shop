package com.hmaitech.onlineshop.model.dto;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;


@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Component
public abstract class BaseDto  {

    private Long id;


    private Instant createDate;

    private Instant updateDate;


    private Boolean deleted = false;


    private Integer version;

}