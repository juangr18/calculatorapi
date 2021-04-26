package com.ias.project.calculatorapi.model;

import com.ias.project.calculatorapi.commons.Validate;
import com.ias.project.calculatorapi.domain.Tech;

public class DeleteTechOutput {
    private final Tech tech;

    public DeleteTechOutput(Tech tech) {
        Validate.checkNotNull(tech);
        this.tech = tech;
    }

    public Tech getTech() {
        return tech;
    }
}
