package com.stud.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 
@Entity
@Table(name = "university")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

@JsonAutoDetect
public class University  implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
   // @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "university_id")
    private long university_id;
 
    @Column(name = "name")
    private String name;
 
    @Column(name = "country")
    private String country;
    
//	@OneToMany(cascade=CascadeType.ALL,mappedBy="Stud")
	//@OneToMany(cascade=CascadeType.ALL,mappedBy="university")
	@OneToMany(fetch = FetchType.EAGER,targetEntity = Stud.class,mappedBy="university")
    private List<Stud> stud;
 
    public University() {
 
    }
 
   public List<Stud> getStud() {
		return stud;
	}

	public void setStud(List<Stud> stud) {
		this.stud = stud;
	}

	public University(String name, String country) {
        this.name = name;
        this.country = country;
    }
 
    public long getId() {
        return university_id;
    }
 
    public void setId(long id) {
        this.university_id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
 
    @Override
    public String toString() {
        return "University [id=" + university_id + ", name=" + name + ", country=" + country + "]";
    }
 
}