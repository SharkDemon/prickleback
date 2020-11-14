package com.simco.prickleback.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Band {

    private Person lead;
    private Person rhythm;
    private Person bassist;
    private Person drummer;

    private String nameAdjective;
    private String nameNoun;
    private City hometown;
    private String color;

    public String getName() {
        return String.format("%s %s", nameAdjective, nameNoun);
    }

}
