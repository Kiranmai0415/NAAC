package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria13Qn")
public class Criteria13Qn implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
	 	
	 	@Column(name = "responseValue132")
	    private String responseValue132;
		
		@Column(name = "input1321t11")
	    private String input1321t11;
		
		@Column(name = "input1321t12")
	    private String input1321t12;
//		
		@Column(name = "responseValue133")
	    private String response133;
		
		@Column(name = "input1331t21")
	    private String input1331t21;
		

		@Column(name = "input1331t22")
	    private String input1331t22;
		
		@Column(name = "responseValue134")
	    private String response134;
		
		
//		@Column(name = "input134t1")
//	    private String input134t1;
		
		@Column(name = "input1341t1")
	    private String input1341t1;
		
		//extra
		@Column(name = "input1341t2")
	    private String input1341t2;
		
		@Column(name = "input1321")
	    private String input1321;
		
		@Column(name = "input133t1")
	    private String input133t1;
		
		@Column(name = "input133t2")
	    private String input133t2;

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

		public String getResponseValue132() {
			return responseValue132;
		}

		public void setResponseValue132(String responseValue132) {
			this.responseValue132 = responseValue132;
		}

		public String getInput1321t11() {
			return input1321t11;
		}

		public void setInput1321t11(String input1321t11) {
			this.input1321t11 = input1321t11;
		}

		public String getInput1321t12() {
			return input1321t12;
		}

		public void setInput1321t12(String input1321t12) {
			this.input1321t12 = input1321t12;
		}

		public String getResponse133() {
			return response133;
		}

		public void setResponse133(String response133) {
			this.response133 = response133;
		}

		public String getInput1331t21() {
			return input1331t21;
		}

		public void setInput1331t21(String input1331t21) {
			this.input1331t21 = input1331t21;
		}

		public String getInput1331t22() {
			return input1331t22;
		}

		public void setInput1331t22(String input1331t22) {
			this.input1331t22 = input1331t22;
		}

		public String getResponse134() {
			return response134;
		}

		public void setResponse134(String response134) {
			this.response134 = response134;
		}

		public String getInput1341t1() {
			return input1341t1;
		}

		public void setInput1341t1(String input1341t1) {
			this.input1341t1 = input1341t1;
		}

		public String getInput1341t2() {
			return input1341t2;
		}

		public void setInput1341t2(String input1341t2) {
			this.input1341t2 = input1341t2;
		}

		public String getInput1321() {
			return input1321;
		}

		public void setInput1321(String input1321) {
			this.input1321 = input1321;
		}

		public String getInput133t1() {
			return input133t1;
		}

		public void setInput133t1(String input133t1) {
			this.input133t1 = input133t1;
		}

		public String getInput133t2() {
			return input133t2;
		}

		public void setInput133t2(String input133t2) {
			this.input133t2 = input133t2;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, input1321, input1321t11, input1321t12, input1331t21, input1331t22,
					input133t1, input133t2, input1341t1, input1341t2, response133, response134, responseValue132,
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
			Criteria13Qn other = (Criteria13Qn) obj;
			return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input1321, other.input1321)
					&& Objects.equals(input1321t11, other.input1321t11)
					&& Objects.equals(input1321t12, other.input1321t12)
					&& Objects.equals(input1331t21, other.input1331t21)
					&& Objects.equals(input1331t22, other.input1331t22) && Objects.equals(input133t1, other.input133t1)
					&& Objects.equals(input133t2, other.input133t2) && Objects.equals(input1341t1, other.input1341t1)
					&& Objects.equals(input1341t2, other.input1341t2) && Objects.equals(response133, other.response133)
					&& Objects.equals(response134, other.response134)
					&& Objects.equals(responseValue132, other.responseValue132) && uniqueKey1 == other.uniqueKey1;
		}

	
		
				
}

