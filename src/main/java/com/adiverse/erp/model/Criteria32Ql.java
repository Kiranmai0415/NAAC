package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria32Ql")
public class Criteria32Ql implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
		
		@Column(name = "responseValue321")
	    private String response321;
		
		@Column(name = "input321t1")
	    private String input321t1;

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

		public String getResponse321() {
			if(response321 !=null) {
			return response321;
		}else {
			return "";
		}
		}

		public void setResponse321(String response321) {
			this.response321 = response321;
		}

		public String getInput321t1() {
			if(input321t1 !=null) {
			return input321t1;
		}else {
			return "";
		}
		}

		public void setInput321t1(String input321t1) {
			this.input321t1 = input321t1;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, input321t1, response321, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria32Ql other = (Criteria32Ql) obj;
			return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input321t1, other.input321t1)
					&& Objects.equals(response321, other.response321) && uniqueKey1 == other.uniqueKey1;
		}


		
	 	
	 	
		
}
