package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria37Qn")
public class Criteria37Qn implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;

	 	@Column(name = "responseValue371")
	    private String response371;
	 	
		@Column(name = "responseValue372")
	    private String response372;
		
		
		@Column(name = "criteria37status")
	    private String criteria37status;


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


		public String getResponse371() {
			if(response371 !=null) {
			return response371;
		}else {
			return "";
		}
		}


		public void setResponse371(String response371) {
			this.response371 = response371;
		}


		public String getResponse372() {
			if(response372 !=null) {
			return response372;
		}else {
			return "";
		}
			
		}


		public void setResponse372(String response372) {
			this.response372 = response372;
		}


		public String getCriteria37status() {
			return criteria37status;
		}


		public void setCriteria37status(String criteria37status) {
			this.criteria37status = criteria37status;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		@Override
		public int hashCode() {
			return Objects.hash(criteria37status, criteriaId, response371, response372, uniqueKey1);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria37Qn other = (Criteria37Qn) obj;
			return Objects.equals(criteria37status, other.criteria37status)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(response371, other.response371)
					&& Objects.equals(response372, other.response372) && uniqueKey1 == other.uniqueKey1;
		}
		

		
	 	
				
}
