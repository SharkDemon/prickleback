package com.simco.prickleback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name="reference_data")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ReferenceData {

    public static final String ADJECTIVES = "ADJ";
    public static final String NOUNS = "NOUN";
    public static final String COLORS = "COLOR";

    @Id private Integer id;

    @Column(name="ref_type")
    private String type;

    @Column(name="ref_value")
    private String value;

}
