package com.ucx.testsparttwo.service;

import com.ucx.testsparttwo.entity.BaseEntity;
import com.ucx.testsparttwo.repository.BaseRepository;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class BaseService<T extends BaseEntity<U>,U> {
    @Autowired
    private BaseRepository<T,U> baseRepository;

    public T save(T t){
        if (t == null) {
            throw new IllegalArgumentException("Invalid argument: "+t);
        }
        return baseRepository.save(t);
    }

    public List<T> findAll(){
        return baseRepository.findAll();
    }

    public T findById(U u){
        if (u == null) {
            throw new IllegalArgumentException("Invalid argument: " + u);
        }
        Optional<T> optionalT = baseRepository.findById(u);

        return optionalT.orElse(null);

    }
    protected static <T> String[] getNullPropertyNames(T source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}