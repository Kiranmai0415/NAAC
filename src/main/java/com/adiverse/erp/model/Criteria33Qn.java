package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria33Qn")
public class Criteria33Qn implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
		
	 	@Column(name = "responseValue332")
	    private String response332;
	 	
		@Column(name = "input3321t11")
	    private String input3321t11;

	 	
	 	@Column(name = "responseValue333")
	    private String response333;

	 	
	 	@Column(name = "responseValue331")
	    private String response331;
		
	 	@Column(name = "criteria33status")
	    private String criteria33status;


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


		public String getResponse332() {
			if(response332 !=null) {
			return response332;
		}else {
			return "";
		}
		}


		public void setResponse332(String response332) {
			this.response332 = response332;
		}


		public String getResponse333() {
			if(response333 !=null) {
			return response333;
		}else {
			return "";
		}
		}


		public void setResponse333(String response333) {
			this.response333 = response333;
		}


		public String getCriteria33status() {
			return criteria33status;
		}


		public void setCriteria33status(String criteria33status) {
			this.criteria33status = criteria33status;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		public String getResponse331() {
			return response331;
		}


		public void setResponse331(String response331) {
			this.response331 = response331;
		}


		public String getInput3321t11() {
			if(input3321t11 !=null) {
			return input3321t11;
		}else {
			return "";
		}
		}


		public void setInput3321t11(String input3321t11) {
			this.input3321t11 = input3321t11;
		}


		@Override
		public int hashCode() {
			return Objects.hash(criteria33status, criteriaId, input3321t11, response331, response332, response333,
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
			Criteria33Qn other = (Criteria33Qn) obj;
			return Objects.equals(criteria33status, other.criteria33status)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3321t11, other.input3321t11)
					&& Objects.equals(response331, other.response331) && Objects.equals(response332, other.response332)
					&& Objects.equals(response333, other.response333) && uniqueKey1 == other.uniqueKey1;
		}



		

		
		
		
}
