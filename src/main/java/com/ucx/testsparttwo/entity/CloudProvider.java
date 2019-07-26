package com.ucx.testsparttwo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CloudProvider extends BaseEntity<Integer> {

    @Column(unique=true)
    private String name;
    private String location;

    @OneToMany(mappedBy = "cloudProvider", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Size(min = 1, message = "You must have at least one product")
    private List<Product> products;
}
