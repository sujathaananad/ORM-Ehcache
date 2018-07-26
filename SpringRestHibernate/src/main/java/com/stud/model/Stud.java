package com.stud.model;
 

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.cache.annotation.Cacheable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name ="stud")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Stud implements Serializable{

	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "student_id")
    private long student_id;
 
    @Column(name = "first_name")
    private String first_name;
 
    @Column(name = "last_name")
    private String last_name;
 
    @Column(name = "section")
    private String section;
    
    @Column(name = "university_id")
    private long university_id;
    @JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="university_id", nullable = false,insertable=false,updatable=false)
    private University university;
  

   


    public Stud() {
    }
    public Stud(String first_name, String last_name, String section) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.section = section;
	}
	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getSection() {
        return section;
    }
 
    public void setSection(String section) {
        this.section = section;
    }
 
    public University getUniversity() {
        return university;
    }
 
    public void setUniversity(University university) {
        this.university = university;
    }

    
    
	public long getUniversity_id() {
		return university_id;
	}
	public void setUniversity_id(long university_id) {
		this.university_id = university_id;
	}
	@Override
	public String toString() {
		return "Stud [student_id=" + student_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", section=" + section + ", university=" + university + "]";
	}
 
	


    
 
}