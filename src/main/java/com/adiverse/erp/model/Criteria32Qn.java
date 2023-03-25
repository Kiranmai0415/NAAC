package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria32Qn")
public class Criteria32Qn implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
		

	 	@Column(name = "responseValue322")
	    private String response322;
		
		@Column(name = "input3221t11")
	    private String input3221t11;
		
		
		@Column(name = "responseValue323")
	    private String response323;
		
		@Column(name = "input3231t1")
	    private String input3231t1;
		
		@Column(name = "input3231t2")
	    private String input3231t2;
		
		@Column(name = "input3232t1")
	    private String input3232t1;
		
		@Column(name = "responseValue324")
	    private String response324;
		
		@Column(name = "criteria32status")
	    private String criteria32status;

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

		public String getResponse322() {
			if(response322 !=null) {
			return response322;
		}else {
			return "";
		}
		}

		public void setResponse322(String response322) {
			this.response322 = response322;
		}

		public String getInput3221t11() {
			if(input3221t11 !=null) {
			return input3221t11;
		}else {
			return "";
		}
		}

		public void setInput3221t11(String input3221t11) {
			this.input3221t11 = input3221t11;
		}

		public String getResponse323() {
			if(response323 !=null) {
			return response323;
		}else {
			return "";
		}
		}

		public void setResponse323(String response323) {
			this.response323 = response323;
		}

		public String getInput3231t1() {
			if(input3231t1 !=null) {
			return input3231t1;
		}else {
			return "";
		}
		}

		public void setInput3231t1(String input3231t1) {
			this.input3231t1 = input3231t1;
		}

		public String getInput3231t2() {
			if(input3231t2 !=null) {
			return input3231t2;
		}else {
			return "";
		}
		}

		public void setInput3231t2(String input3231t2) {
			this.input3231t2 = input3231t2;
		}

		public String getInput3232t1() {
			if(input3232t1 !=null) {
			return input3232t1;
		}else {
			return null;
		}
		}

		public void setInput3232t1(String input3232t1) {
			this.input3232t1 = input3232t1;
		}

		public String getResponse324() {
			if(response324 !=null) {
			return response324;
		}else {
			return "";
		}
		}

		public void setResponse324(String response324) {
			this.response324 = response324;
		}

		public String getCriteria32status() {
			return criteria32status;
		}

		public void setCriteria32status(String criteria32status) {
			this.criteria32status = criteria32status;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteria32status, criteriaId, input3221t11, input3231t1, input3231t2, input3232t1,
					response322, response323, response324, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria32Qn other = (Criteria32Qn) obj;
			return Objects.equals(criteria32status, other.criteria32status)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3221t11, other.input3221t11)
					&& Objects.equals(input3231t1, other.input3231t1) && Objects.equals(input3231t2, other.input3231t2)
					&& Objects.equals(input3232t1, other.input3232t1) && Objects.equals(response322, other.response322)
					&& Objects.equals(response323, other.response323) && Objects.equals(response324, other.response324)
					&& uniqueKey1 == other.uniqueKey1;
		}
				
}
