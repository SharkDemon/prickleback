package com.simco.prickleback.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name="cities")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class City {

    @Id private Integer id;
    private String name;
    private String state;

    public String getDisplayValue() {
        return String.format("%s, %s", name, state);
    }

}
