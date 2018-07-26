package com.stud.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

 
	@Entity
	@Table(name = "subject")
	public class Subject implements Serializable{
		private static final long serialVersionUID = 1L;
	 
	    @Id
	    @Column(name = "subjectid")
	    private long subjectid;
	 
	    @Column(name = "name")
	    private String name;
	     
	     
	    @ManyToMany(mappedBy="subjects",cascade = CascadeType.ALL)
	    private List<StudManytoMany> students = new ArrayList<StudManytoMany>();
	     
	    public Subject(){
	         
	    }
	     
	    public Subject(long subjectid,String name){
	    	this.subjectid=subjectid;
	        this.name = name;
	    }
	 
	    
		public long getSubjectid() {
			return subjectid;
		}

		public void setSubjectid(long subjectid) {
			this.subjectid = subjectid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<StudManytoMany> getStudents() {
			return students;
		}

		public void setStudents(List<StudManytoMany> students) {
			this.students = students;
		}
		
		@Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + (int) (subjectid ^ (subjectid >>> 32));
	        result = prime * result + ((name == null) ? 0 : name.hashCode());
	        return result;
	    }
	 
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (!(obj instanceof Subject))
	            return false;
	        Subject other = (Subject) obj;
	        if (subjectid != other.subjectid)
	            return false;
	        if (name == null) {
	            if (other.name != null)
	                return false;
	        } else if (!name.equals(other.name))
	            return false;
	        return true;
	    }

		@Override
	    public String toString() {
	        return "Subject [id=" + subjectid + ", name=" + name + "]";
	    }
	 
	}
