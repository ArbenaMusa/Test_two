package com.ucx.testsparttwo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class BaseEntity<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;

}
