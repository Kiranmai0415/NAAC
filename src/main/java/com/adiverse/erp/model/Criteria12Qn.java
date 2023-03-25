package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria12Qn")
public class Criteria12Qn implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
	 	
	 	@Column(name = "responseValue121")
	    private String response121;
	 	
		@Column(name = "responseValue122")
	    private String response122;
		
		@Column(name = "input1211t1")
	    private String input1211t1;
		
	
		
		@Column(name = "input1212t1")
	    private String input1212t1;
		
		
		@Column(name = "input1221t1")
	    private String input1221t1;
		
		@Column(name = "input1221t2")
	    private String input1221t2;
		

		@Column(name = "criteria12status")
	    private String criteria12status;


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


		public String getResponse121() {
			if(response121 !=null) {
			return response121;
		}else {
			return "";
		}
		}


		public void setResponse121(String response121) {
			this.response121 = response121;
		}


		public String getResponse122() {
			if(response122 !=null) {
			return response122;
		}else {
			return "";
		}
		}


		public void setResponse122(String response122) {
			this.response122 = response122;
		}


		public String getInput1211t1() {
			if(input1211t1 !=null) {
			return input1211t1;
		}else {
			return "";
		}
		}


		public void setInput1211t1(String input1211t1) {
			this.input1211t1 = input1211t1;
		}


		public String getInput1212t1() {
			if(input1212t1 !=null) {
			return input1212t1;
		}else {
			return "";
		}
		}


		public void setInput1212t1(String input1212t1) {
			this.input1212t1 = input1212t1;
		}


		public String getInput1221t1() {
			if(input1221t1 !=null) {
			return input1221t1;
		}else {
			return "";
		}
		}


		public void setInput1221t1(String input1221t1) {
			this.input1221t1 = input1221t1;
		}


		public String getInput1221t2() {
			if(input1221t2 !=null) {
			return input1221t2;
		}else {
			return "";
		}
		}


		public void setInput1221t2(String input1221t2) {
			this.input1221t2 = input1221t2;
		}


		public String getCriteria12status() {
			return criteria12status;
		}


		public void setCriteria12status(String criteria12status) {
			this.criteria12status = criteria12status;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		@Override
		public int hashCode() {
			return Objects.hash(criteria12status, criteriaId, input1211t1, input1212t1, input1221t1, input1221t2,
					response121, response122, uniqueKey1);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria12Qn other = (Criteria12Qn) obj;
			return Objects.equals(criteria12status, other.criteria12status)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input1211t1, other.input1211t1)
					&& Objects.equals(input1212t1, other.input1212t1) && Objects.equals(input1221t1, other.input1221t1)
					&& Objects.equals(input1221t2, other.input1221t2) && Objects.equals(response121, other.response121)
					&& Objects.equals(response122, other.response122) && uniqueKey1 == other.uniqueKey1;
		}
		
	
}
