package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name ="evaluative_report")

public class Evaluativereportofthedepartment implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	  public CriteriaPrimaryKey criteriaId;

	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
  
	
	
	@Column(name="nameof_the_autonomous_college")
    private String nameofTheAutonomousCollege;
	
	@Column(name="nameof_the_department")
    private String nameofTheDepartment;
	
	@Column(name="dist")
    private String dist;
	
	@Column(name="state")
    private String state;
	
	@Column(name="total_numberof_departments_inthe_institution")
    private String totalNumberofDepartmentsIntheInstitution;

	public long getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(long uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getNameofTheAutonomousCollege() {
		return nameofTheAutonomousCollege;
	}

	public void setNameofTheAutonomousCollege(String nameofTheAutonomousCollege) {
		this.nameofTheAutonomousCollege = nameofTheAutonomousCollege;
	}

	public String getNameofTheDepartment() {
		return nameofTheDepartment;
	}

	public void setNameofTheDepartment(String nameofTheDepartment) {
		this.nameofTheDepartment = nameofTheDepartment;
	}

	public String getDist() {
		if(dist !=null) {
		return dist;
	}else {
		return "";
				}
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getState() {
		if(state !=null) {
			return state;
		}else {
			return "";
					}
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTotalNumberofDepartmentsIntheInstitution() {
		if(totalNumberofDepartmentsIntheInstitution !=null) {
			return totalNumberofDepartmentsIntheInstitution;
		}else {
			return "";
					}
	}

	public void setTotalNumberofDepartmentsIntheInstitution(String totalNumberofDepartmentsIntheInstitution) {
		this.totalNumberofDepartmentsIntheInstitution = totalNumberofDepartmentsIntheInstitution;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, dist, nameofTheAutonomousCollege, nameofTheDepartment, state,
				totalNumberofDepartmentsIntheInstitution, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evaluativereportofthedepartment other = (Evaluativereportofthedepartment) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(dist, other.dist)
				&& Objects.equals(nameofTheAutonomousCollege, other.nameofTheAutonomousCollege)
				&& Objects.equals(nameofTheDepartment, other.nameofTheDepartment) && Objects.equals(state, other.state)
				&& Objects.equals(totalNumberofDepartmentsIntheInstitution,
						other.totalNumberofDepartmentsIntheInstitution)
				&& uniqueKey1 == other.uniqueKey1;
	}


		

		
	}
	


