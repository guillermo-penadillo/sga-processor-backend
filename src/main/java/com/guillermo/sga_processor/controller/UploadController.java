package com.guillermo.sga_processor.controller;

import com.guillermo.sga_processor.model.SolicitudRaw;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.guillermo.sga_processor.service.ExcelService;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UploadController {

    private final ExcelService excelService;

    @PostMapping("/process")
    public List<SolicitudRaw> processFiles(
            @RequestParam("altas") MultipartFile altas,
            @RequestParam("mantos") MultipartFile mantos) {

        List<SolicitudRaw> listaAltas = excelService.parseExcel(altas);
        List<SolicitudRaw> listaMantos = excelService.parseExcel(mantos);

        return Stream.concat(listaAltas.stream(), listaMantos.stream()).toList();
    }

    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}
