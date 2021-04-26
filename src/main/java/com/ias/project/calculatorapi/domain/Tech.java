package com.ias.project.calculatorapi.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Tech {
    private final UUID id;
    private final String idTech;
    private final String idService;
    private final LocalDateTime horaInicial;
    private final LocalDateTime horaFinal;

    public Tech(UUID id, String idTech, String idService, LocalDateTime horaInicial, LocalDateTime horaFinal) {
        this.id = id;
        this.idTech = idTech;
        this.idService = idService;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }

    public UUID getId() {
        return id;
    }

    public String getIdTech() {
        return idTech;
    }

    public String getIdService() {
        return idService;
    }

    public LocalDateTime getHoraInicial() {
        return horaInicial;
    }

    public LocalDateTime getHoraFinal() {
        return horaFinal;
    }

    @Override
    public String toString() {
        return "Tech{" +
                "id=" + id +
                ", idTech='" + idTech + '\'' +
                ", idService='" + idService + '\'' +
                ", horaInicial=" + horaInicial +
                ", horaFinal=" + horaFinal +
                '}';
    }
}