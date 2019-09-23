package net.guides.sptingboot2.springboot2jpaexample.springboot2jpaexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import net.guides.sptingboot2.springboot2jpaexample.springboot2jpaexample.model.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

}
