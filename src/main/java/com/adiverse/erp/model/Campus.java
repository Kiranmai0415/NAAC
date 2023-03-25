package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="campus")
public class Campus implements Serializable
{
	private static final long serialVersionUID = -2231411273570309611L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name="campustype")
	private String inputbtl11;
	
	@Column(name="campusaddress")
	private String inputbtl12;
	
	@Column(name="campuslocation")
	private String inputbtl13;
	
	@Column(name="campusareainacres")
	private String inputbtl14;
	
	@Column(name="builtupareainsqmts")
	private String inputbtl15;
	
    @Column(name="campus_programmesoffered")
	private String inputbtl16;
	
	@Column(name="campus_establishmentdate")
	private String inputbtl17;
	
	@Column(name="dateof_recognition")
	private String inputbtl18;
	
	

	

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public long getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(long uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getInputbtl11() {
		if(inputbtl11 !=null) {
		return inputbtl11;
	}else {
		return "";
	}
	}

	public void setInputbtl11(String inputbtl11) {
		this.inputbtl11 = inputbtl11;
	}

	public String getInputbtl12() {
		if(inputbtl12 !=null) {
		return inputbtl12;
	}else {
		return "";
	}
	}

	public void setInputbtl12(String inputbtl12) {
		this.inputbtl12 = inputbtl12;
	}



	public String getInputbtl13() {
		if(inputbtl13 !=null) {
		return inputbtl13;
	}else {
		return "";
	}
	}

	public void setInputbtl13(String inputbtl13) {
		this.inputbtl13 = inputbtl13;
	}

	public String getInputbtl14() {
		if(inputbtl14 !=null) {
		return inputbtl14;
	}else {
		return "";
	}
	}

	public void setInputbtl14(String inputbtl14) {
		this.inputbtl14 = inputbtl14;
	}

	public String getInputbtl15() {
		if(inputbtl15 !=null) {
		return inputbtl15;
	}else {
		return "";
	}
	}

	public void setInputbtl15(String inputbtl15) {
		this.inputbtl15 = inputbtl15;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getInputbtl17() {
		if(inputbtl17 !=null) {
		return inputbtl17;
	}else {
		return "";
	}
	}

	public void setInputbtl17(String inputbtl17) {
		this.inputbtl17 = inputbtl17;
	}

	public String getInputbtl18() {
		if(inputbtl18 !=null) {
		return inputbtl18;
	}else {
		return "";
	}
	}

	public void setInputbtl18(String inputbtl18) {
		this.inputbtl18 = inputbtl18;
	}

	public String getInputbtl16() {
		if(inputbtl16 !=null) {
		return inputbtl16;
	}else {
		return "";
	}
	}

	public void setInputbtl16(String inputbtl16) {
		this.inputbtl16 = inputbtl16;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputbtl11, inputbtl12, inputbtl13, inputbtl14, inputbtl15, inputbtl16,
				inputbtl17, inputbtl18, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campus other = (Campus) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputbtl11, other.inputbtl11)
				&& Objects.equals(inputbtl12, other.inputbtl12) && Objects.equals(inputbtl13, other.inputbtl13)
				&& Objects.equals(inputbtl14, other.inputbtl14) && Objects.equals(inputbtl15, other.inputbtl15)
				&& Objects.equals(inputbtl16, other.inputbtl16) && Objects.equals(inputbtl17, other.inputbtl17)
				&& Objects.equals(inputbtl18, other.inputbtl18) && uniqueKey1 == other.uniqueKey1;
	}

	
	
	

}
