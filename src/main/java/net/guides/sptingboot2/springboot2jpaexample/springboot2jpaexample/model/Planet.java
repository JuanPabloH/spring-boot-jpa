package net.guides.sptingboot2.springboot2jpaexample.springboot2jpaexample.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Planets")
public class Planet {
	private long id;
	private String name;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
	
    
    public Planet() {
		
	}


	public Planet(long id, String name, String rotation_period, String orbital_period, String diameter, String climate,
			String gravity, String terrain, String surface_water, String population) {
		this.id = id;
		this.name = name;
		this.rotation_period = rotation_period;
		this.orbital_period = orbital_period;
		this.diameter = diameter;
		this.climate = climate;
		this.gravity = gravity;
		this.terrain = terrain;
		this.surface_water = surface_water;
		this.population = population;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	@Column(name="name",nullable=false)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Column(name="rotation_period",nullable=false)
	public String getRotation_period() {
		return rotation_period;
	}


	public void setRotation_period(String rotation_period) {
		this.rotation_period = rotation_period;
	}

	@Column(name="orbital_period",nullable=false)
	public String getOrbital_period() {
		return orbital_period;
	}


	public void setOrbital_period(String orbital_period) {
		this.orbital_period = orbital_period;
	}

	@Column(name="diameter",nullable=false)
	public String getDiameter() {
		return diameter;
	}


	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}

	@Column(name="climate",nullable=false)
	public String getClimate() {
		return climate;
	}


	public void setClimate(String climate) {
		this.climate = climate;
	}

	@Column(name="gravity",nullable=false)
	public String getGravity() {
		return gravity;
	}


	public void setGravity(String gravity) {
		this.gravity = gravity;
	}

	@Column(name="terrain",nullable=false)
	public String getTerrain() {
		return terrain;
	}


	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	@Column(name="surface_water",nullable=false)
	public String getSurface_water() {
		return surface_water;
	}


	public void setSurface_water(String surface_water) {
		this.surface_water = surface_water;
	}

	@Column(name="population",nullable=false)
	public String getPopulation() {
		return population;
	}


	public void setPopulation(String population) {
		this.population = population;
	}
	
	
    

}
