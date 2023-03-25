package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria34Ql")
public class Criteria34Ql implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;

		
	 	@Column(name = "responseValue341")
	    private String response341;
	 	
		@Column(name = "input341t1")
	    private String input341t1;
		
	
		@Column(name = "responseValue349")
	    private String response349;
	 	
		@Column(name = "input3491t1")
	    private String input3491t1;
		
		@Column(name = "input3491t2")
	    private String input3491t2;

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

		public String getResponse341() {
			if(response341 !=null) {
			return response341;
		}else {
			return "";
		}
		}

		public void setResponse341(String response341) {
			this.response341 = response341;
		}

		public String getInput341t1() {
			if(input341t1 !=null) {
			return input341t1;
		}else {
			return "";
		}
		}

		public void setInput341t1(String input341t1) {
			this.input341t1 = input341t1;
		}

		public String getResponse349() {
			if(response349 !=null) {
			return response349;
		}else {
			return "";
		}
		}

		public void setResponse349(String response349) {
			this.response349 = response349;
		}

		public String getInput3491t1() {
			if(input3491t1 !=null) {
			return input3491t1;
		}else {
			return "";
		}
		}

		public void setInput3491t1(String input3491t1) {
			this.input3491t1 = input3491t1;
		}

		public String getInput3491t2() {
			if(input3491t2 !=null) {
			return input3491t2;
		}else {
			return "";
		}
		}

		public void setInput3491t2(String input3491t2) {
			this.input3491t2 = input3491t2;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, input341t1, input3491t1, input3491t2, response341, response349, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria34Ql other = (Criteria34Ql) obj;
			return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input341t1, other.input341t1)
					&& Objects.equals(input3491t1, other.input3491t1) && Objects.equals(input3491t2, other.input3491t2)
					&& Objects.equals(response341, other.response341) && Objects.equals(response349, other.response349)
					&& uniqueKey1 == other.uniqueKey1;
		}

		
		
		
}
