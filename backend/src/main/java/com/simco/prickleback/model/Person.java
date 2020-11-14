package com.simco.prickleback.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name="persons")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Person {

    public static final String ROLE_LEAD = "L";
    public static final String ROLE_DRUMMER = "D";
    public static final String ROLE_BASSIST = "B";
    public static final String ROLE_RHYTHM = "R";

    @Id private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="band_role")
    private String role;

    private String band;

    @Column(name="image_name")
    private String imageName;

    @Column(name="image_thumb_name")
    private String imageThumbName;

    private UUID uid;

    public String getDisplayValue() {
        return null == lastName ?
                firstName :
                    String.format("%s %s", firstName, lastName);
    }

}
