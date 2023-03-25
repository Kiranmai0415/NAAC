package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria35Qn")
public class Criteria35Qn implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
	

		@Column(name = "responseValue351")
	    private String response351;
	
		
		
		@Column(name = "criteria35status")
	    private String criteria35status;

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


		public String getResponse351() {
			if(response351 !=null) {
			return response351;
		}else {
			return "";
		}
		}


		public void setResponse351(String response351) {
			this.response351 = response351;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		public String getCriteria35status() {
			return criteria35status;
		}


		public void setCriteria35status(String criteria35status) {
			this.criteria35status = criteria35status;
		}


		@Override
		public int hashCode() {
			return Objects.hash(criteria35status, criteriaId, response351, uniqueKey1);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria35Qn other = (Criteria35Qn) obj;
			return Objects.equals(criteria35status, other.criteria35status)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(response351, other.response351)
					&& uniqueKey1 == other.uniqueKey1;
		}


		
		
				
}
