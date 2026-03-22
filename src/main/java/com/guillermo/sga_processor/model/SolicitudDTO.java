package com.guillermo.sga_processor.model;

import java.time.LocalDateTime;

public class SolicitudDTO {

    private String contrata; // D - 3
    private String cliente; // E - 4
    private int sot; // F - 5
    private String direccion; // G - 6

    private LocalDateTime fechaRegistro; // I - 8
    private int dilacion; // J - 9

    private String estadoAgenda; // K - 10
    private LocalDateTime fechaProgramacion; // P - 15

    private String tipoTrabajo; // AF - 31
    private String tipoServicio; // AL - 37
    private String estadoSot; // AN - 39

    private String plano; // AO - 40
    private int cintillo; // AP - 41
    private String tipoEstadoSot; //AU - 46

    private String departamento; // AW - 48
    private String provincia; // AV - 47
    private String distrito; // AX - 49

    private int numTipoTranajo; // BA - 52
    private String descriopcionTrabajo; // BC - 54

    private String region; // BV - 73
    private String bucket; // CH - 85
    private String Tecnologia; // CN - 91

    // futuros
    /*private String codTipoOrden;
    private String desTipoOrden;
    private String codSubtipoOrden;
    private String desSubtipoOrden;*/
}
