package com.ias.project.calculatorapi.commons;


import java.sql.Date;
import java.time.LocalDateTime;

public class Validate {

    /**
     * Metodo que permite validar si el valor pasado como parametro es null.
     * @param value Parametro a validar si es igual a null
     */
    public static void checkNotNull(Object value) {
        if(value == null) {
            throw new IllegalArgumentException("Value is null.");
        }
    }

    /**
     * Metodo que permite verificar si es una fecha validad y del mismo modo,
     * comparar si la fecha final va despues de la inicial.
     * @param valueInit Fecha inicial pasada como parametro.
     * @param valueFinal Fecha final pasada como parametro.
     */
    public static void hourValidate(LocalDateTime valueInit, LocalDateTime valueFinal){

        if (valueInit.isAfter(valueFinal)) {
            throw new IllegalArgumentException("Date invalid.");
        }else if(valueInit.equals(valueFinal)){
            throw new IllegalArgumentException("Dates is equals");
        }
    }
}
