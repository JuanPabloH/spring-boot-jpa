package net.guides.sptingboot2.springboot2jpaexample.springboot2jpaexample.controller;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.sptingboot2.springboot2jpaexample.springboot2jpaexample.exception.ResourceNotFoundException;
import net.guides.sptingboot2.springboot2jpaexample.springboot2jpaexample.model.Person;
import net.guides.sptingboot2.springboot2jpaexample.springboot2jpaexample.repository.PersonRepository;

@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
    private PersonRepository personRepository;
	
	/**
	 * Obtiene todas los registros de la tabla persons
	 * */
	@GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
	

	/**
	 * Obtiene el registro de la tabla persons que coincida con el id de parametro de entrada
	 * */
	
	@GetMapping("/persons/{id}")
    public ResponseEntity < Person > getPersonById(@PathVariable(value = "id") Long personId)
    throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
            .orElseThrow(() -> new ResourceNotFoundException("person not found for this id :: " + personId));
        return ResponseEntity.ok().body(person);
    }
	
	/**
	 * Agrega un registro a la tabla persons, el nuevo registro tendra el valor del objeto Person que recibe
	 * como parametro 
	 * */
	@PostMapping("/persons")
    public Person createPerson(@Valid @RequestBody Person person) {
        return personRepository.save(person);
    }
	
	
	/**
	 * Modifica el registro de la tabla persons que coincida con el id que recibe como parametro y le 
	 * asigna el valor de personDetails que recibe como parametro
	 * */
    @PutMapping("/persons/{id}")
    public ResponseEntity < Person > updatePerson(@PathVariable(value = "id") Long personId,
        @Valid @RequestBody Person personsDetails) throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
            .orElseThrow(() -> new ResourceNotFoundException("person not found for this id :: " + personId));
        person.setName(personsDetails.getName());
        person.setHeight(personsDetails.getHeight());
        person.setMass(personsDetails.getMass());
        person.setHair_color(personsDetails.getHair_color());
        person.setSkin_color(personsDetails.getSkin_color());
        person.setEye_color(personsDetails.getEye_color());
        person.setBirth_year(personsDetails.getBirth_year());
        person.setGender(personsDetails.getGender());
        person.setHomeworld(personsDetails.getHomeworld());
        
        final Person updatedPerson = personRepository.save(person);
        return ResponseEntity.ok(updatedPerson);
    }
    
    /**
     * Elimina el registro de la tabla persons que concida con el id que recibe como parametro de entrada
     * */
    @DeleteMapping("/persons/{id}")
    public Map < String, Boolean > deletePerson(@PathVariable(value = "id") Long personId)
    throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
            .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

        personRepository.delete(person);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
