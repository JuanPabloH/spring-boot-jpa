package net.guides.sptingboot2.springboot2jpaexample.springboot2jpaexample.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Species")
public class Specie {
	
	private long id;
	private String name;
    private String classification;
    private String designation;
    private String average_height;
    private String skin_colors;
    private String hair_colors;
    private String eye_colors;
    private String average_lifespan;
    private String homeworld;
    private String language;
    
    
	public Specie() {
	}


	public Specie(long id, String name, String classification, String designation, String average_height,
			String skin_colors, String hair_colors, String eye_colors, String average_lifespan, String homeworld,
			String language) {
		
		this.id = id;
		this.name = name;
		this.classification = classification;
		this.designation = designation;
		this.average_height = average_height;
		this.skin_colors = skin_colors;
		this.hair_colors = hair_colors;
		this.eye_colors = eye_colors;
		this.average_lifespan = average_lifespan;
		this.homeworld = homeworld;
		this.language = language;
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

	@Column(name="classification",nullable=false)
	public String getClassification() {
		return classification;
	}


	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Column(name="designation",nullable=false)
	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name="average_height",nullable=false)
	public String getAverage_height() {
		return average_height;
	}


	public void setAverage_height(String average_height) {
		this.average_height = average_height;
	}

	@Column(name="skin_colors",nullable=false)
	public String getSkin_colors() {
		return skin_colors;
	}


	public void setSkin_colors(String skin_colors) {
		this.skin_colors = skin_colors;
	}

	@Column(name="hair_colors",nullable=false)
	public String getHair_colors() {
		return hair_colors;
	}


	public void setHair_colors(String hair_colors) {
		this.hair_colors = hair_colors;
	}

	@Column(name="eye_colors",nullable=false)
	public String getEye_colors() {
		return eye_colors;
	}


	public void setEye_colors(String eye_colors) {
		this.eye_colors = eye_colors;
	}

	@Column(name="average_lifespan",nullable=false)
	public String getAverage_lifespan() {
		return average_lifespan;
	}


	public void setAverage_lifespan(String average_lifespan) {
		this.average_lifespan = average_lifespan;
	}

	@Column(name="homeworld",nullable=false)
	public String getHomeworld() {
		return homeworld;
	}


	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}

	@Column(name="language",nullable=false)
	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}
 
	
	

}
