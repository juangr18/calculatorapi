package com.ias.project.calculatorapi.model;

import com.ias.project.calculatorapi.commons.Validate;

import java.util.UUID;

public class DeleteTechInput {

    private final UUID techID;

    public DeleteTechInput(UUID techID) {
        Validate.checkNotNull(techID);
        this.techID = techID;
    }

    public UUID getTechID() {
        return techID;
    }
}
