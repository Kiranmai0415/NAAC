package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria36Ql")
public class Criteria36Ql implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;

	 	@Column(name = "responseValue361")
	    private String response361;
	 	
	 	@Column(name = "input361t1")
	    private String input361t1;
	 	
	 	@Column(name = "input361t2")
	    private String input361t2;
	 	
		
		


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


		public String getResponse361() {
			if(response361 !=null) {
			return response361;
		}else {
			return "";
		}
		}


		public void setResponse361(String response361) {
			this.response361 = response361;
		}


		public String getInput361t1() {
			if(input361t1 !=null) {
			return input361t1;
		}else {
			return "";
		}
		}


		public void setInput361t1(String input361t1) {
			this.input361t1 = input361t1;
		}


		public String getInput361t2() {
			if(input361t2 !=null) {
			return input361t2;
		}else {
			return "";
		}
		}


		public void setInput361t2(String input361t2) {
			this.input361t2 = input361t2;
		}


		

		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, input361t1, input361t2, response361, uniqueKey1);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria36Ql other = (Criteria36Ql) obj;
			return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input361t1, other.input361t1)
					&& Objects.equals(input361t2, other.input361t2) && Objects.equals(response361, other.response361)
					&& uniqueKey1 == other.uniqueKey1;
		}


		
				
}
