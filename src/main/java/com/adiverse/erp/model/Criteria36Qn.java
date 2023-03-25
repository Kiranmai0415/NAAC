package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria36Qn")
public class Criteria36Qn implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
	

	 	@Column(name = "responseValue362")
	    private String response362;
	 	
	 	@Column(name = "responseValue363")
	    private String response363;
	 	
		@Column(name = "responseValue364")
	    private String response364;
		
		
		@Column(name = "criteria36status")
	    private String criteria36status;

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

		public String getResponse362() {
			if(response362 !=null) {
			return response362;
		}else {
			return "";
		}
		}

		public void setResponse362(String response362) {
			this.response362 = response362;
		}

		public String getResponse363() {
			if(response363 !=null) {
			return response363;
		}else {
			return "";
		}
		}

		public void setResponse363(String response363) {
			this.response363 = response363;
		}

		public String getResponse364() {
			if(response364 !=null) {
			return response364;
		}else {
			return "";
		}
		}

		public void setResponse364(String response364) {
			this.response364 = response364;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public String getCriteria36status() {
			return criteria36status;
		}

		public void setCriteria36status(String criteria36status) {
			this.criteria36status = criteria36status;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteria36status, criteriaId, response362, response363, response364, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria36Qn other = (Criteria36Qn) obj;
			return Objects.equals(criteria36status, other.criteria36status)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(response362, other.response362)
					&& Objects.equals(response363, other.response363) && Objects.equals(response364, other.response364)
					&& uniqueKey1 == other.uniqueKey1;
		}

		
}
