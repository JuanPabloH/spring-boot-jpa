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
import net.guides.sptingboot2.springboot2jpaexample.springboot2jpaexample.model.Planet;
import net.guides.sptingboot2.springboot2jpaexample.springboot2jpaexample.repository.PlanetRepository;

@RestController
@RequestMapping("/api")
public class PlanetController {
	
	@Autowired
    private PlanetRepository planetRepository;
	
	/**
	 * Obtiene todas los registros de la tabla plantes
	 * */
	@GetMapping("/planets")
    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }
	
	
	/**
	 * Obtiene el registro de la tabla planets que coincida con el id de parametro de entrada
	 * */
	@GetMapping("/planets/{id}")
    public ResponseEntity < Planet > getPlanetById(@PathVariable(value = "id") Long planetId)
    throws ResourceNotFoundException {
        Planet planet = planetRepository.findById(planetId)
            .orElseThrow(() -> new ResourceNotFoundException("planet not found for this id :: " + planetId));
        return ResponseEntity.ok().body(planet);
    }
	
	/**
	 * Agrega un registro a la tabla planets, el nuevo registro tendra el valor del objeto Planet que recibe
	 * como parametro 
	 * */
	
	@PostMapping("/planets")
    public Planet createPlanet(@Valid @RequestBody Planet planet) {
        return planetRepository.save(planet);
    }
	
	/**
	 * Modifica el registro de la tabla planets que coincida con el id que recibe como parametro y le 
	 * asigna el valor de planetDetails que recibe como parametro
	 * */
    @PutMapping("/planets/{id}")
    public ResponseEntity < Planet > updatePlanet(@PathVariable(value = "id") Long planetId,
        @Valid @RequestBody Planet planetsDetails) throws ResourceNotFoundException {
    	Planet planet = planetRepository.findById(planetId)
            .orElseThrow(() -> new ResourceNotFoundException("planet not found for this id :: " + planetId));
        planet.setName(planetsDetails.getName());
        planet.setRotation_period(planetsDetails.getRotation_period());
        planet.setOrbital_period(planetsDetails.getOrbital_period());
        planet.setDiameter(planetsDetails.getDiameter());
        planet.setClimate(planetsDetails.getClimate());
        planet.setGravity(planetsDetails.getGravity());
        planet.setTerrain(planetsDetails.getTerrain());
        planet.setSurface_water(planetsDetails.getSurface_water());
        planet.setPopulation(planetsDetails.getPopulation());
        
        final Planet updatedplanet = planetRepository.save(planet);
        return ResponseEntity.ok(updatedplanet);
    }
    
    /**
     * Elimina el registro de la tabla planets que concida con el id que recibe como parametro de entrada
     * */
    @DeleteMapping("/planets/{id}")
    public Map < String, Boolean > deletePlanet(@PathVariable(value = "id") Long planetId)
    throws ResourceNotFoundException {
    	Planet planet = planetRepository.findById(planetId)
            .orElseThrow(() -> new ResourceNotFoundException("planet not found for this id :: " + planetId));

        planetRepository.delete(planet);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



}
