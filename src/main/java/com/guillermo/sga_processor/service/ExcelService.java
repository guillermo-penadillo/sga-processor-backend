package com.guillermo.sga_processor.service;

import com.guillermo.sga_processor.model.Solicitud;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {

    public List<Solicitud> parseExcel(MultipartFile file) {
        List<Solicitud> solicitudes = new ArrayList<>();

        try (InputStream is = file.getInputStream();
             Workbook workbook = WorkbookFactory.create(is)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null) continue;

                Solicitud solicitud = new Solicitud();
                solicitud.setCodigo(getCellValue(row.getCell(0)));
                solicitud.setEstado(getCellValue(row.getCell(1)));
                solicitud.setFechaCreacion(getCellValue(row.getCell(2)));
                solicitud.setTipo(getCellValue(row.getCell(3)));

                solicitudes.add(solicitud);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error procesando Excel",e);
        }
        return solicitudes;
    }

    private String getCellValue(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
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
        }
    }
}
