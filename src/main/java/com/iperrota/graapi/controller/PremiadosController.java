package com.iperrota.graapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.iperrota.graapi.services.PremiadosService;
import com.iperrota.graapi.model.Premiados;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@RestController
public class PremiadosController {
	
	 @GetMapping("/premiados")
	 public ResponseEntity<Object> getPremiados() {
		 
		 try {
			 PremiadosService ps = new PremiadosService();
			 
			 ArrayList<Premiados> minPremiados = ps.getMinPremiados();
			 ArrayList<Premiados> maxPremiados = ps.getMaxPremiados();
			 
			 return ResponseEntity.status(HttpStatus.OK).body(Map.of("max",maxPremiados,
					 												 "min",minPremiados));
		 } catch(Exception e) {
			 
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request Error");
		 }

	 }
	 
}
