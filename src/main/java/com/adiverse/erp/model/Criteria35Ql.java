package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria35Ql")
public class Criteria35Ql implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;

		
	 	@Column(name = "responseValue352")
	    private String response352;

	 	

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

		public String getResponse352() {
			if(response352 !=null) {
			return response352;
		}else {
			return "";
		}
		}

		public void setResponse352(String response352) {
			this.response352 = response352;
		}

		

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, response352, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria35Ql other = (Criteria35Ql) obj;
			return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(response352, other.response352)
					&& uniqueKey1 == other.uniqueKey1;
		}

		
	 	
}
