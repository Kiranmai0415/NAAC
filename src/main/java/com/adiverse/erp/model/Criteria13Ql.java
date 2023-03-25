package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria13Ql")
public class Criteria13Ql implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
	 	
	 	
	 	@Column(name = "input131t1")
	    private String input131t1;
		
		@Column(name = "responseValue131")
	    private String response131;
		
		@Column(name = "responseValue132")
	    private String response132;
		
		@Column(name = "input132t1")
	    private String input132t1;
		
		@Column(name = "input132t2")
	    private String input132t2;
		
		@Column(name = "criteria13status")
	    private String criteria13status;

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

		public String getInput131t1() {
			if(input131t1 !=null) {
			return input131t1;
		}else {
			return "";
		}
		}

		public void setInput131t1(String input131t1) {
			this.input131t1 = input131t1;
		}

		public String getResponse131() {
			if(response131 !=null) {
			return response131;
		}else {
			return "";
		}
		}

		public void setResponse131(String response131) {
			this.response131 = response131;
		}

		public String getResponse132() {
			if(response132 !=null) {
			return response132;
		}else {
			return "";
		}
		}

		public void setResponse132(String response132) {
			this.response132 = response132;
		}

		public String getInput132t1() {
			if(input132t1 !=null) {
			return input132t1;
		}else {
			return "";
		}
		}

		public void setInput132t1(String input132t1) {
			this.input132t1 = input132t1;
		}

		public String getInput132t2() {
			if(input132t2 !=null) {
			return input132t2;
		}else {
			return "";
		}
		}

		public void setInput132t2(String input132t2) {
			this.input132t2 = input132t2;
		}

		public String getCriteria13status() {
			return criteria13status;
		}

		public void setCriteria13status(String criteria13status) {
			this.criteria13status = criteria13status;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteria13status, criteriaId, input131t1, input132t1, input132t2, response131,
					response132, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria13Ql other = (Criteria13Ql) obj;
			return Objects.equals(criteria13status, other.criteria13status)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input131t1, other.input131t1)
					&& Objects.equals(input132t1, other.input132t1) && Objects.equals(input132t2, other.input132t2)
					&& Objects.equals(response131, other.response131) && Objects.equals(response132, other.response132)
					&& uniqueKey1 == other.uniqueKey1;
		}


		
}
