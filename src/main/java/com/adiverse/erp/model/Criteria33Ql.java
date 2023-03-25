package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria33Ql")
public class Criteria33Ql implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
	 	
	 	@Column(name = "input331t1")
	    private String input331t1;

	
	 

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

		

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public String getInput331t1() {
			if(input331t1 !=null) {
			return input331t1;
		}else {
			return "";
		}
		}

		public void setInput331t1(String input331t1) {
			this.input331t1 = input331t1;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, input331t1, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria33Ql other = (Criteria33Ql) obj;
			return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input331t1, other.input331t1)
					&& uniqueKey1 == other.uniqueKey1;
		}

		

	 	
	 	
		
		
		
}
