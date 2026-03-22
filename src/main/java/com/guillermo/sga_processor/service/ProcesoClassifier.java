package com.guillermo.sga_processor.service;

import com.guillermo.sga_processor.model.TipoProceso;
import org.springframework.stereotype.Service;

@Service
public class ProcesoClassifier {

    public TipoProceso clasificar(String tipoTrabajo) {

        //SI EL TIPO DE TRABAJO ES NULL, RETORNA COMO DESCONOCIDO
        if (tipoTrabajo == null) {
            return TipoProceso.DESCONOCIDO;
        }

        //CONVERTIMOS EL CONTENIDO DE LA VARIABLE "VALOR" EN MAYUSUCLAS
        String valor = tipoTrabajo.toUpperCase();

        //EL CONTENIDO DE LA VARIABLE VALOR DEFINE LA CLASIFICACION
        if (valor.contains("INSTALACION")) {
            return  TipoProceso.INSTALACION;
        }

        if (valor.contains("MANTENIMIENTO")) {
            return  TipoProceso.MANTENIMINETO;
        }

        if (valor.contains("POST")) {
            return  TipoProceso.POSTVENTA;
        }

        // SI NO RECONOCE, DEVUELVE DESCONOCIDO
        return TipoProceso.DESCONOCIDO;
    }


}

