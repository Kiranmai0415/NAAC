package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria11Qn")
public class Criteria11Qn implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
		
	 	@Column(name = "responseValue112")
	    private String response112;
		
		@Column(name = "input1121t1")
	    private String input1121t1;
		
		@Column(name = "input1122t1")
	    private String input1122t1;
		
		@Column(name = "responseValue113")
	    private String response113;
		
		@Column(name = "criteria11status")
	    private String criteria11status;

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

		public String getResponse112() {
			if(response112 !=null) {
			return response112;
		}else {
			return "";
		}
		}

		public void setResponse112(String response112) {
			this.response112 = response112;
		}

		public String getInput1121t1() {
			if(input1121t1 !=null) {
			return input1121t1;
		}else {
			return "";
		}
		}

		public void setInput1121t1(String input1121t1) {
			this.input1121t1 = input1121t1;
		}

		public String getInput1122t1() {
			if(input1122t1 !=null){
			return input1122t1;
		}else {
			return "";
		}
		}

		public void setInput1122t1(String input1122t1) {
			this.input1122t1 = input1122t1;
		}

		public String getResponse113() {
			if(response113 !=null) {
			return response113;
		}else {
			return "";
		}
		}

		public void setResponse113(String response113) {
			this.response113 = response113;
		}

		public String getCriteria11status() {
			return criteria11status;
		}

		public void setCriteria11status(String criteria11status) {
			this.criteria11status = criteria11status;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteria11status, criteriaId, input1121t1, input1122t1, response112, response113,
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
			Criteria11Qn other = (Criteria11Qn) obj;
			return Objects.equals(criteria11status, other.criteria11status)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input1121t1, other.input1121t1)
					&& Objects.equals(input1122t1, other.input1122t1) && Objects.equals(response112, other.response112)
					&& Objects.equals(response113, other.response113) && uniqueKey1 == other.uniqueKey1;
		}


		
	
}
