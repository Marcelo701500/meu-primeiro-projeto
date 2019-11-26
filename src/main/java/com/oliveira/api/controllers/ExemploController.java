package com.oliveira.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveira.api.dtos.EmpresaDto;
import com.oliveira.api.responses.Response;

@RestController
@RequestMapping("/api/empresas")
public class ExemploController {

	@GetMapping (value="{nome}")
	public String exemplo(@PathVariable("nome") String nome) {
		return "Olá " + nome;
	}
	
//	@PostMapping
//	public ResponseEntity<EmpresaDto> cadastrar(@RequestBody EmpresaDto empresaDto) {
//		empresaDto.setId(1L);
//		return ResponseEntity.ok(empresaDto);
//	}
	
//	@PostMapping
//	public ResponseEntity<Response<EmpresaDto>> cadastrar(@RequestBody EmpresaDto empresaDto) {
//		Response<EmpresaDto> response = new Response<EmpresaDto>();
//		
//		empresaDto.setId(1L);
//		response.setData(empresaDto);
//		
//		return ResponseEntity.ok(response);
//	}
	
	@PostMapping
	public ResponseEntity<Response<EmpresaDto>> cadastrar(@Valid @RequestBody EmpresaDto empresaDto,
			BindingResult result) {
		Response<EmpresaDto> response = new Response<EmpresaDto>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		empresaDto.setId(1L);
		response.setData(empresaDto);
		
		return ResponseEntity.ok(response);
	}	
	
} 
