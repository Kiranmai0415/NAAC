package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="criteria24Qn")
public class Criteria24Qn implements Serializable
{
	
private static final long serialVersionUID = 4920532919687126600L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;

	
	
	@Column(name = "responseValue241")
    private String response241;

	@Column(name = "responseValue242")
    private String response242;
	
	 @Column(name = "input2421")
	 private String input2421;
	

	@Column(name = "responseValue243")
    private String response243;
	
	 @Column(name = "input2431t1")
	 private String input2431t1;
	 
	 @Column(name = "input2431t2")
	 private String input2431t2;
	 

	    @Column(name = "responseValue244")
	    private String response244;
	    
	    @Column(name = "criteria24status")
	    private String criteria24status;

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

		public String getResponse241() {
			return response241;
		}

		public void setResponse241(String response241) {
			this.response241 = response241;
		}

		public String getResponse242() {
			return response242;
		}

		public void setResponse242(String response242) {
			this.response242 = response242;
		}

		public String getInput2421() {
			return input2421;
		}

		public void setInput2421(String input2421) {
			this.input2421 = input2421;
		}

		public String getResponse243() {
			return response243;
		}

		public void setResponse243(String response243) {
			this.response243 = response243;
		}

		public String getInput2431t1() {
			return input2431t1;
		}

		public void setInput2431t1(String input2431t1) {
			this.input2431t1 = input2431t1;
		}

		public String getInput2431t2() {
			return input2431t2;
		}

		public void setInput2431t2(String input2431t2) {
			this.input2431t2 = input2431t2;
		}

		public String getResponse244() {
			return response244;
		}

		public void setResponse244(String response244) {
			this.response244 = response244;
		}

		public String getCriteria24status() {
			return criteria24status;
		}

		public void setCriteria24status(String criteria24status) {
			this.criteria24status = criteria24status;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteria24status, criteriaId, input2421, input2431t1, input2431t2, response241,
					response242, response243, response244, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria24Qn other = (Criteria24Qn) obj;
			return Objects.equals(criteria24status, other.criteria24status)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2421, other.input2421)
					&& Objects.equals(input2431t1, other.input2431t1) && Objects.equals(input2431t2, other.input2431t2)
					&& Objects.equals(response241, other.response241) && Objects.equals(response242, other.response242)
					&& Objects.equals(response243, other.response243) && Objects.equals(response244, other.response244)
					&& uniqueKey1 == other.uniqueKey1;
		}

		
		
}

