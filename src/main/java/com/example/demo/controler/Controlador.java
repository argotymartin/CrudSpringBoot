package com.example.demo.controler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.interfaceService.IpersonaService;
import com.example.demo.modelo.Persona;
import com.example.demo.util.Utileria;

@Controller
@RequestMapping
public class Controlador {
	@Autowired
	private IpersonaService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Persona>personas=service.listar();
		model.addAttribute("personas",personas);
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona",new Persona());
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Valid Persona p, Model model,@RequestParam("arlArchivoImagen") MultipartFile imagen_arl,@RequestParam("epsArchivoImagen") MultipartFile imagen_eps) {
		
		
		if(!imagen_arl.isEmpty()) {
			Path directorioImagenesArl = Paths.get("src//main//resources//static/arl");
			String rutaAbsolutaArl = directorioImagenesArl.toFile().getAbsolutePath();
			System.out.println("RUTA ABSOLUTA:"+rutaAbsolutaArl);
		
		try {
			
			byte[] byteImgArl = imagen_arl.getBytes();
			Path rutaCompleta = Paths.get(directorioImagenesArl + "//" + imagen_arl.getOriginalFilename());
			Files.write(rutaCompleta,byteImgArl);
			
			p.setPersona_arl_archivo(imagen_arl.getOriginalFilename());
			//p.setPersona_arl_ruta(directorioImagenesArl.toString()); asi graba src/main/resources/static/arl
			p.setPersona_arl_ruta("arl");
		}catch(IOException e){
			e.printStackTrace();
		}
		}
		
		
		if(!imagen_eps.isEmpty()) {
			Path directorioImagenesEps = Paths.get("src//main//resources//static/eps");
			String rutaAbsolutaEps = directorioImagenesEps.toFile().getAbsolutePath();
			System.out.println("RUTA ABSOLUTA:"+rutaAbsolutaEps);
		
		try {
			
			byte[] byteImgEps = imagen_eps.getBytes();
			Path rutaCompletaEps = Paths.get(directorioImagenesEps + "//" + imagen_eps.getOriginalFilename());
			Files.write(rutaCompletaEps,byteImgEps);
			p.setPersona_eps_archivo(imagen_eps.getOriginalFilename());
			p.setPersona_eps_ruta("eps");
			
			//p.setPersona_arl_ruta(directorioImagenesArl.toString()); asi graba src/main/resources/static/arl
		
			
		}catch(IOException e){
			e.printStackTrace();
		}
		}
		
		service.save(p);
		return "redirect:/listar";
	}
	
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id ,Model model) {
		java.util.Optional<Persona>persona=service.listarId(id);
		model.addAttribute("persona",persona);
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(Model model,@PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}
	
	@GetMapping("/imagen/{id}")
	public String imagen(@PathVariable int id ,Model model) {
		java.util.Optional<Persona>persona=service.listarId(id);
		model.addAttribute("persona",persona);
		return "imagen";
	}
	 
	
}
