package com.ias.project.calculatorapi.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class TechHour {

    private final UUID id;
    private final String idTech;
    private final String idService;
    private final LocalDateTime horaInicial;
    private final LocalDateTime horaFinal;
    private final long horas;
//    private final long nocturnas;
//    private final long dominicales;

    public TechHour(UUID id, String idTech, String idService, LocalDateTime horaInicial, LocalDateTime horaFinal, long horas) {
        this.id = id;
        this.idTech = idTech;
        this.idService = idService;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.horas = horas;
//        this.nocturnas = nocturnas;
//        this.dominicales = dominicales;
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

    public long getHoras() {
        return horas;
    }

//    public long getNocturnas() {
//        return nocturnas;
//    }
//
//    public long getDominicales() {
//        return dominicales;
//    }
}
