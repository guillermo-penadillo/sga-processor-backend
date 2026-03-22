package com.guillermo.sga_processor.model;

import lombok.Data;
import org.springframework.http.StreamingHttpOutputMessage;

import java.time.LocalDateTime;

@Data
public class SolicitudRaw {

    private String contrata; // D - 3
    private String cliente; // E - 4
    private String sot; // F - 5
    private String direccion; // G - 6

    private String fechaRegistro; // I - 8
    private String dilacion; // J - 9

    private String estadoAgenda; // K - 10
    private String fechaProgramacion; // P - 15

    private String tipoTrabajo; // AF - 31
    private String tipoServicio; // AL - 37
    private String estadoSot; // AN - 39

    private String plano; // AO - 40
    private String cintillo; // AP - 41
    private String tipoEstadoSot; //AU - 46

    private String departamento; // AW - 48
    private String provincia; // AV - 47
    private String distrito; // AX - 49

    private String numTipoTrabajo; // BA - 52
    private String descripcionTrabajo; // BC - 54

    private String region; // BV - 73
    private String bucket; // CH - 85
    private String Tecnologia; // CN - 91

    // futuros
    /*private String codTipoOrden;
    private String desTipoOrden;
    private String codSubtipoOrden;
    private String desSubtipoOrden;*/


}
