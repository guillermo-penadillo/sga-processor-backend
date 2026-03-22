package com.guillermo.sga_processor.service;

import com.guillermo.sga_processor.model.SolicitudRaw;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {

    DataFormatter formatter = new DataFormatter();

    public List<SolicitudRaw> parseExcel(MultipartFile file) {
        List<SolicitudRaw> solicitudes = new ArrayList<>();

        try (InputStream is = file.getInputStream();
             Workbook workbook = WorkbookFactory.create(is)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null) continue;

                SolicitudRaw solicitud = new SolicitudRaw();
                solicitud.setContrata(getCellValue(row.getCell(3), formatter));
                solicitud.setCliente(getCellValue(row.getCell(4), formatter));
                solicitud.setSot(getCellValue(row.getCell(5), formatter));
                solicitud.setDireccion(getCellValue(row.getCell(6), formatter));
                solicitud.setFechaRegistro(getCellValue(row.getCell(8), formatter));
                //solicitud.setDilacion(getCellValue(row.getCell(9),formatter ));
                String dilacionStr = getCellValue(row.getCell(9), formatter);
                if (!dilacionStr.isEmpty()) {
                    solicitud.setDilacion(
                            String.valueOf((int) Math.round(Double.parseDouble(dilacionStr)))
                    );
                }
                solicitud.setEstadoAgenda(getCellValue(row.getCell(10), formatter));
                solicitud.setFechaProgramacion(getCellValue(row.getCell(15), formatter));
                solicitud.setTipoTrabajo(getCellValue(row.getCell(31), formatter));
                solicitud.setTipoServicio(getCellValue(row.getCell(37), formatter));
                solicitud.setEstadoSot(getCellValue(row.getCell(39), formatter));
                solicitud.setPlano(getCellValue(row.getCell(40), formatter));
                solicitud.setCintillo(getCellValue(row.getCell(41), formatter));
                solicitud.setTipoEstadoSot(getCellValue(row.getCell(46), formatter));
                solicitud.setProvincia(getCellValue(row.getCell(47), formatter));
                solicitud.setDepartamento(getCellValue(row.getCell(48), formatter));
                solicitud.setDistrito(getCellValue(row.getCell(49), formatter));
                solicitud.setRegion(getCellValue(row.getCell(73), formatter));
                solicitud.setBucket(getCellValue(row.getCell(85), formatter));
                solicitud.setTecnologia(getCellValue(row.getCell(91), formatter5));

                solicitudes.add(solicitud);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error procesando Excel",e);
        }
        return solicitudes;
    }

    private String getCellValue(Cell cell, DataFormatter formatter) {
        if (cell == null) return "";
        return formatter.formatCellValue(cell).trim();
        /*switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();

            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getLocalDateTimeCellValue().toString();
                }
                return String.valueOf(cell.getNumericCellValue());
            case FORMULA:
                return cell.getCellFormula();

            default:
                return "";
        }*/
    }
}
