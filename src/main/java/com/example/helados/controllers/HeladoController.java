package com.example.helados.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helados.entity.Helado;
import com.example.helados.services.HeladoService;


@RestController
@RequestMapping("helado")
public class HeladoController {
	
	@Autowired
	private HeladoService heladoService;
	
	@PostMapping
	private ResponseEntity<Helado> guardarHelado (@RequestBody Helado helado){
		
		try {
			Helado heladoGuardado = heladoService.createHelado(helado);
			return ResponseEntity.created(new URI("/helado/"+heladoGuardado.getIdHelado())).body(heladoGuardado);
			
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@GetMapping
	private ResponseEntity<List<Helado>> listarTodosLosHelados(){
		return ResponseEntity.ok(heladoService.getAllHelado());
	}
	
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Helado>> listarHelado (@PathVariable("id") Long id){
		return ResponseEntity.ok(heladoService.findByIdHelado(id));
	}
	
	@PutMapping(value = "{id}")
	private ResponseEntity<Helado> updateHelado (@RequestBody Helado helado, @PathVariable("id") Long id){
		
		try {
			Helado heladoGuardado = heladoService.createHelado(helado);
			
			return ResponseEntity.created(new URI("/helado/"+heladoGuardado.getIdHelado())).body(heladoGuardado);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping("/{id}")
	private String deleteCuenta (@PathVariable Long  id) {
		try {
			heladoService.deleteByIdHelado(id);
			return "Elemento eliminado correctamente";
			
		} catch (Exception e) {
			System.out.println(e);
			return "Error al eliminar el helado: " + e;
		}
	}
	
	
	

}
