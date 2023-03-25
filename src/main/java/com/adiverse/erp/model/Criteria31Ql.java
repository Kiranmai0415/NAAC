package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria31Ql")
public class Criteria31Ql implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
		
		@Column(name = "responseValue311")
	    private String response311;
	 	
		@Column(name = "input311t1")
	    private String input311t1;
		
		@Column(name = "input3131t1")
	    private String input3131t1;
		
		@Column(name = "criteria31status")
	    private String criteria31status;

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

		public String getResponse311() {
			if(response311 !=null) {
			return response311;
		}else {
			return "";
		}
		}

		public void setResponse311(String response311) {
			this.response311 = response311;
		}

		public String getInput311t1() {
			if(input311t1 !=null) {
			return input311t1;
		}else {
			return "";
		}
		}

		public void setInput311t1(String input311t1) {
			this.input311t1 = input311t1;
		}

		public String getInput3131t1() {
			if(input3131t1 !=null) {
			return input3131t1;
		}else {
			return "";
		}
		}

		public void setInput3131t1(String input3131t1) {
			this.input3131t1 = input3131t1;
		}

		public String getCriteria31status() {
			return criteria31status;
		}

		public void setCriteria31status(String criteria31status) {
			this.criteria31status = criteria31status;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteria31status, criteriaId, input311t1, input3131t1, response311, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria31Ql other = (Criteria31Ql) obj;
			return Objects.equals(criteria31status, other.criteria31status)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input311t1, other.input311t1)
					&& Objects.equals(input3131t1, other.input3131t1) && Objects.equals(response311, other.response311)
					&& uniqueKey1 == other.uniqueKey1;
		}
		

				
		
}
