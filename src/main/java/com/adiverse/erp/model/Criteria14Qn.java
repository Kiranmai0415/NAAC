package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria14Qn")
public class Criteria14Qn implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
	 	
	 	@Column(name = "responseValue141")
	    private String response141;
		
		@Column(name = "input141t1")
	    private String input141t1;
		
	
		@Column(name = "input141t2")
	    private String input141t2;
		
		@Column(name = "responseValue142")
	    private String response142;
		
		@Column(name = "input142t1")
	    private String input142t1;
		
	
		@Column(name = "input142t2")
	    private String input142t2;
		

		@Column(name = "input141")
	    private String input141;

		 @Column(name = "criteria14status")
		    private String criteria14status;

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

		public String getResponse141() {
			return response141;
		}

		public void setResponse141(String response141) {
			this.response141 = response141;
		}

		public String getInput141t1() {
			return input141t1;
		}

		public void setInput141t1(String input141t1) {
			this.input141t1 = input141t1;
		}

		public String getInput141t2() {
			return input141t2;
		}

		public void setInput141t2(String input141t2) {
			this.input141t2 = input141t2;
		}

		public String getResponse142() {
			return response142;
		}

		public void setResponse142(String response142) {
			this.response142 = response142;
		}

		public String getInput142t1() {
			return input142t1;
		}

		public void setInput142t1(String input142t1) {
			this.input142t1 = input142t1;
		}

		public String getInput142t2() {
			return input142t2;
		}

		public void setInput142t2(String input142t2) {
			this.input142t2 = input142t2;
		}

		public String getInput141() {
			return input141;
		}

		public void setInput141(String input141) {
			this.input141 = input141;
		}

		public String getCriteria14status() {
			return criteria14status;
		}

		public void setCriteria14status(String criteria14status) {
			this.criteria14status = criteria14status;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteria14status, criteriaId, input141, input141t1, input141t2, input142t1, input142t2,
					response141, response142, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria14Qn other = (Criteria14Qn) obj;
			return Objects.equals(criteria14status, other.criteria14status)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input141, other.input141)
					&& Objects.equals(input141t1, other.input141t1) && Objects.equals(input141t2, other.input141t2)
					&& Objects.equals(input142t1, other.input142t1) && Objects.equals(input142t2, other.input142t2)
					&& Objects.equals(response141, other.response141) && Objects.equals(response142, other.response142)
					&& uniqueKey1 == other.uniqueKey1;
		}

		
				
}

