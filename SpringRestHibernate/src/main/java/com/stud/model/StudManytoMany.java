package com.stud.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "studentmany")
public class StudManytoMany implements Serializable{
	private static final long serialVersionUID = 1L;
 
    @Id
    @Column(name = "studentid")
    private long studentid;
 
    @Column(name = "firstname")
    private String firstname;
 
    @Column(name = "lastname")
    private String lastname;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "studentsubject", 
        joinColumns = { @JoinColumn(name = "studentid", referencedColumnName = "studentid") }, 
        inverseJoinColumns = { @JoinColumn(name = "subjectid" ,referencedColumnName = "subjectid") })
    private List<Subject> subjects = new ArrayList<Subject>();
 
    public StudManytoMany() {
    }
 
    public StudManytoMany(long studentid,String firstname, String lastname) {
    	this.studentid=studentid;
        this.firstname = firstname;
        this.lastname = lastname;
    }
 

 
    
	public long getStudentid() {
		return studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (studentid ^ (studentid >>> 32));
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof StudManytoMany))
            return false;
        StudManytoMany other = (StudManytoMany) obj;
        if (studentid != other.studentid)
            return false;
        return true;
    }

	@Override
    public String toString() {
        return "StudManytoMany [id=" + studentid + ", firstName=" + firstname + ", lastName="
                + lastname + "]";
    }
 
}