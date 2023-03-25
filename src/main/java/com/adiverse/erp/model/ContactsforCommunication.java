package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts_for_Communication")
public class ContactsforCommunication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name = "unique_key1")
	private long uniqueKey1;

	@Column(name = "Contacts_Designation")
	private String inputbtc1;

	@Column(name = "Contacts_Name")
	private String inputbtc2;

	@Column(name = "telephone_code")
	private String inputbtc3;

	@Column(name = "contacts_mobile")
	private String inputbtc4;

	@Column(name = "contacts_fax")
	private String inputbtc5;

	@Column(name = "contacts_email")
	private String inputbtc6;

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

	public String getInputbtc1() {
		if(inputbtc1 !=null) {
		return inputbtc1;
	}else {
		return "";
	}
	}

	public void setInputbtc1(String inputbtc1) {
		this.inputbtc1 = inputbtc1;
	}

	public String getInputbtc2() {
		if(inputbtc2 !=null) {
		
		return inputbtc2;
	}else {
		return "";
	}
	}

	public void setInputbtc2(String inputbtc2) {
		this.inputbtc2 = inputbtc2;
	}

	public String getInputbtc3() {
		if(inputbtc3 !=null) {
		return inputbtc3;
	}else {
		return "";
	}
	}

	public void setInputbtc3(String inputbtc3) {
		this.inputbtc3 = inputbtc3;
	}

	public String getInputbtc4() {
		if(inputbtc4 !=null) {
		return inputbtc4;
	}else {
		return "";
	}
	}

	public void setInputbtc4(String inputbtc4) {
		this.inputbtc4 = inputbtc4;
	}

	public String getInputbtc5() {
		if(inputbtc5 !=null) {
		return inputbtc5;
	}else {
		return "";
	}
	}

	public void setInputbtc5(String inputbtc5) {
		this.inputbtc5 = inputbtc5;
	}

	public String getInputbtc6() {
		if(inputbtc6 !=null) {
		return inputbtc6;
	}else {
		return "";
	}
	}

	public void setInputbtc6(String inputbtc6) {
		this.inputbtc6 = inputbtc6;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputbtc1, inputbtc2, inputbtc3, inputbtc4, inputbtc5, inputbtc6, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactsforCommunication other = (ContactsforCommunication) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputbtc1, other.inputbtc1)
				&& Objects.equals(inputbtc2, other.inputbtc2) && Objects.equals(inputbtc3, other.inputbtc3)
				&& Objects.equals(inputbtc4, other.inputbtc4) && Objects.equals(inputbtc5, other.inputbtc5)
				&& Objects.equals(inputbtc6, other.inputbtc6) && uniqueKey1 == other.uniqueKey1;
	}

}
