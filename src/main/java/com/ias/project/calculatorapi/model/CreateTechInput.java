package com.ias.project.calculatorapi.model;

import com.ias.project.calculatorapi.commons.Validate;

import java.time.LocalDateTime;

public class CreateTechInput {

    private String idTech;
    private String idService;
    private LocalDateTime horaInicial;
    private LocalDateTime horaFinal;

    public CreateTechInput(String idTech, String idService, LocalDateTime horaInicial, LocalDateTime horaFinal) {
        Validate.hourValidate(horaInicial,horaFinal);
        this.idTech = idTech;
        this.idService = idService;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }

    public String getIdTech() {
        return idTech;
    }

    public void setIdTech(String id) {
        this.idTech = id;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public LocalDateTime getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(LocalDateTime horaInicial) {
        this.horaInicial = horaInicial;
    }

    public LocalDateTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalDateTime horaFinal) {
        this.horaFinal = horaFinal;
    }
}
