package com.ias.project.calculatorapi.model;

import com.ias.project.calculatorapi.commons.Validate;

import java.util.UUID;

public class ReadTechByIdInput {

    private final UUID id;

    public ReadTechByIdInput(UUID id){
        Validate.checkNotNull(id);
        this.id=id;
    }
}
