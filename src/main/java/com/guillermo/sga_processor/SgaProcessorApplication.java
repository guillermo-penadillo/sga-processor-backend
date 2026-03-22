package com.guillermo.sga_processor;

import org.apache.poi.util.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SgaProcessorApplication {

	public static void main(String[] args) {

		SpringApplication.run(SgaProcessorApplication.class, args);

		// Establecer el límite a, por ejemplo, 150MB o 200MB
		IOUtils.setByteArrayMaxOverride(150_000_000);
	}

}
