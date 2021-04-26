package com.ias.project.calculatorapi.model;

import com.ias.project.calculatorapi.commons.Validate;
import com.ias.project.calculatorapi.domain.Tech;

public class CreateTechOutput {
    private final Tech tech;

    public CreateTechOutput(Tech tech) {
        Validate.hourValidate(tech.getHoraInicial(),tech.getHoraFinal());
        this.tech = tech;
    }

    public Tech getTech() {
        return tech;
    }

    @Override
    public String toString() {
        return "CreateTechOutput{" +
                "tech=" + tech +
                '}';
    }
}
