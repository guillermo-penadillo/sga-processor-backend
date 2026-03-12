package com.guillermo.sga_processor.model;

import lombok.Data;

import java.util.Date;

@Data
public class Solicitud {

    private String codigo;
    private String estado;
    private String fechaCreacion;
    private String tipo;

}
