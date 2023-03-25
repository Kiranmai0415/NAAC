package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria62Ql")
public class Criteria62Ql implements Serializable {
	
	private static final long serialVersionUID = 384884159595539439L;


	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "responseValue621")
    private String response621;	
	
	@Column(name = "input621t1")
    private String input621t1;
	
	
	@Column(name = "responseValu622")
	   private String response622;
	
	  @Column(name = "input622t1")
	   private String input622t1;
	  

	  @Column(name = "criteria62status")
	    private String criteria62status;



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


		public String getResponse621() {
			if(response621 !=null) {
			return response621;
		}else {
			return "";
		}
		}


		public void setResponse621(String response621) {
			this.response621 = response621;
		}


		public String getInput621t1() {
			if(input621t1 !=null) {
			return input621t1;
		}else {
			return "";
		}
		}


		public void setInput621t1(String input621t1) {
			this.input621t1 = input621t1;
		}


		public String getResponse622() {
			if(response622 !=null) {
			return response622;
		}else {
			return "";
		}
		}


		public void setResponse622(String response622) {
			this.response622 = response622;
		}


		public String getInput622t1() {
			if(input622t1 !=null) {
			return input622t1;
		}else {
			return "";
		}
		}


		public void setInput622t1(String input622t1) {
			this.input622t1 = input622t1;
		}


		

		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		public String getCriteria62status() {
			return criteria62status;
		}


		public void setCriteria62status(String criteria62status) {
			this.criteria62status = criteria62status;
		}


		@Override
		public int hashCode() {
			return Objects.hash(criteria62status, criteriaId, input621t1, input622t1, response621, response622,
					uniqueKey1);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria62Ql other = (Criteria62Ql) obj;
			return Objects.equals(criteria62status, other.criteria62status)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input621t1, other.input621t1)
					&& Objects.equals(input622t1, other.input622t1) && Objects.equals(response621, other.response621)
					&& Objects.equals(response622, other.response622) && uniqueKey1 == other.uniqueKey1;
		}


		

	
}
