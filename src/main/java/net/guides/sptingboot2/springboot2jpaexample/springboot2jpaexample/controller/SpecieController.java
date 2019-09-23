package net.guides.sptingboot2.springboot2jpaexample.springboot2jpaexample.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.sptingboot2.springboot2jpaexample.springboot2jpaexample.exception.ResourceNotFoundException;
import net.guides.sptingboot2.springboot2jpaexample.springboot2jpaexample.model.Specie;
import net.guides.sptingboot2.springboot2jpaexample.springboot2jpaexample.repository.SpecieRepository;

@RestController
@RequestMapping("/api")
public class SpecieController {
	
	@Autowired
    private SpecieRepository specieRepository;
	
	/**
	 * Obtiene todas los registros de la tabla species
	 * */
	@GetMapping("/species")
    public List<Specie> getAllSpecies() {
        return specieRepository.findAll();
    }
	
	/**
	 * Obtiene el registro de la tabla species que coincida con el id de parametro de entrada
	 * */
	
	@GetMapping("/species/{id}")
    public ResponseEntity < Specie > getSpecieById(@PathVariable(value = "id") Long specieId)
    throws ResourceNotFoundException {
		Specie specie = specieRepository.findById(specieId)
            .orElseThrow(() -> new ResourceNotFoundException("specie not found for this id :: " + specieId));
        return ResponseEntity.ok().body(specie);
    }
	
	/**
	 * Agrega un registro a la tabla species, el nuevo registro tendra el valor del objeto Specie que recibe
	 * como parametro 
	 * */
	@PostMapping("/species")
    public Specie createspecie(@Valid @RequestBody Specie specie) {
        return specieRepository.save(specie);
    }
	
	/**
	 * Modifica el registro de la tabla species que coincida con el id que recibe como parametro y le 
	 * asigna el valor de specieDetails que recibe como parametro
	 * */
    @PutMapping("/species/{id}")
    public ResponseEntity < Specie > updateSpecie(@PathVariable(value = "id") Long specieId,
        @Valid @RequestBody Specie speciesDetails) throws ResourceNotFoundException {
    	Specie specie = specieRepository.findById(specieId)
            .orElseThrow(() -> new ResourceNotFoundException("specie not found for this id :: " + specieId));
        specie.setName(speciesDetails.getName());
        specie.setClassification(speciesDetails.getClassification());
        specie.setDesignation(speciesDetails.getClassification());
        specie.setAverage_height(speciesDetails.getAverage_height());
        specie.setSkin_colors(speciesDetails.getSkin_colors());
        specie.setHair_colors(speciesDetails.getHair_colors());
        specie.setEye_colors(speciesDetails.getEye_colors());
        specie.setAverage_lifespan(specie.getAverage_lifespan());
        specie.setHomeworld(specie.getHomeworld());
        specie.setLanguage(speciesDetails.getLanguage());
        
        final Specie updatedspecie = specieRepository.save(specie);
        return ResponseEntity.ok(updatedspecie);
    }
    
    
    /**
     * Elimina el registro de la tabla species que concida con el id que recibe como parametro de entrada
     * */
    @DeleteMapping("/species/{id}")
    public Map < String, Boolean > deleteSpecie(@PathVariable(value = "id") Long specieId)
    throws ResourceNotFoundException {
    	Specie specie = specieRepository.findById(specieId)
            .orElseThrow(() -> new ResourceNotFoundException("specie not found for this id :: " + specieId));

        specieRepository.delete(specie);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	

}
