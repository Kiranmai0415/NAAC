package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lowagie.text.Chunk;


@Entity
@Table(name ="criteria34Qn")
public class Criteria34Qn implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
	
	 	@Column(name = "responseValue342")
	    private String response342;
	 	
		@Column(name = "input342t1")
	    private String input342t1;
		
		@Column(name = "input342t2")
	    private String input342t2;
		
		
		@Column(name = "input3422t1")
	    private String input3422t1;
		
		@Column(name = "responseValue343")
	    private String response343;
		
		@Column(name = "input343t1")
	    private String input343t1;
		
		@Column(name = "responseValue344")
	    private String response344;
		
		@Column(name = "responseValue345")
	    private String response345;
		
		@Column(name = "input3451t1")
	    private String input3451t1;
		
		@Column(name = "input3451t2")
	    private String input3451t2;
		

		@Column(name = "input3452t1")
	    private String input3452t1;
		
		@Column(name = "responseValue346")
	    private String response346;
		
		@Column(name = "input3461t1")
	    private String input3461t1;
		
		@Column(name = "input3461t2")
	    private String input3461t2;
		
		
		@Column(name = "responseValue347")
	    private String response347;
		
		@Column(name = "responseValue348")
	    private String response348;
		
		@Column(name = "input3481t1")
	    private String input348t1;
		
		@Column(name = "input348t2")
	    private String input348t2;
		
		@Column(name = "input3482t1")
	    private String input3482t1;
		
		@Column(name = "input3482t2")
	    private String input3482t2;
		
		@Column(name = "input3441t1")
	    private String input3441t1;
		
		@Column(name = "input3441t2")
	    private String input3441t2;
		
		@Column(name = "criteria34status")
	    private String criteria34status;

		public CriteriaPrimaryKey getCriteriaId() {
			return criteriaId;
		}

		public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
			this.criteriaId = criteriaId;
		}

		public String getInput342t2() {
			return input342t2;
		}

		public void setInput342t2(String input342t2) {
			this.input342t2 = input342t2;
		}

		public long getUniqueKey1() {
			return uniqueKey1;
		}

		public void setUniqueKey1(long uniqueKey1) {
			this.uniqueKey1 = uniqueKey1;
		}

		public String getResponse342() {
			if(response342 !=null) {
			return response342;
		}else {
			return "";
		}
		}

		public void setResponse342(String response342) {
			
			this.response342 = response342;
		}

		public String getInput342t1() {
			if(input342t1 !=null) {
			return input342t1;
		}else {
			return "";
		}
		}

		public void setInput342t1(String input342t1) {
			this.input342t1 = input342t1;
		}

		public String getInput3422t1() {
			if(input3422t1 !=null) {
			return input3422t1;
		}else {
			return "";
		}
		}

		public void setInput3422t1(String input3422t1) {
			this.input3422t1 = input3422t1;
		}

		public String getResponse343() {
			if(response343 !=null) {
			return response343;
		}else {
			return "";
		}
		}

		public void setResponse343(String response343) {
			this.response343 = response343;
		}

		public String getInput343t1() {
			if(input343t1 !=null) {
			return input343t1;
		}else {
			return "";
		}
		}

		public void setInput343t1(String input343t1) {
			this.input343t1 = input343t1;
		}

		public String getResponse344() {
			if(response344 !=null) {
			return response344;
		}else {
			return "";
		}
		}

		public void setResponse344(String response344) {
			this.response344 = response344;
		}

		public String getResponse345() {
			if(response345 !=null) {
			return response345;
		}else {
			return "";
		}
		}

		public void setResponse345(String response345) {
			this.response345 = response345;
		}

		public String getInput3451t1() {
			if(input3451t1 !=null) {
			return input3451t1;
		}else {
			return "";
		}
		}

		public void setInput3451t1(String input3451t1) {
			this.input3451t1 = input3451t1;
		}

		public String getInput3451t2() {
			if(input3451t2 !=null) {
			return input3451t2;
		}else {
			return "";
		}
		}

		public void setInput3451t2(String input3451t2) {
			this.input3451t2 = input3451t2;
		}

		public String getInput3452t1() {
			if(input3452t1 !=null) {
			return input3452t1;
		}else {
			return "";
		}
		}

		public void setInput3452t1(String input3452t1) {
			this.input3452t1 = input3452t1;
		}

		public String getResponse346() {
			if(response346 !=null) {
			return response346;
		}else {
			return "";
		}
		}

		public void setResponse346(String response346) {
			this.response346 = response346;
		}

		public String getInput3461t1() {
			if(input3461t1 !=null) {
			
			return input3461t1;
		}else {
			return "";
		}
		}

		public void setInput3461t1(String input3461t1) {
			this.input3461t1 = input3461t1;
		}

		public String getInput3461t2() {
			if(input3461t2 !=null) {
			return input3461t2;
		}else {
			return "";
		}
		}

		public void setInput3461t2(String input3461t2) {
			this.input3461t2 = input3461t2;
		}

		public String getResponse347() {
			if(response347 !=null) {
			return response347;
		}else {
			return "";
		}
		}

		public void setResponse347(String response347) {
			this.response347 = response347;
		}

		public String getResponse348() {
			if(response348 !=null) {
			return response348;
		}else {
		
				return "";
			}
			}
		

		public void setResponse348(String response348) {
			this.response348 = response348;
		}

		public String getInput348t1() {
			if(input348t1 !=null) {
			return input348t1;
		}else {
			return "";
		}
		}

		public void setInput348t1(String input348t1) {
			this.input348t1 = input348t1;
		}

		public String getInput348t2() {
			if(input348t2 !=null) {
			return input348t2;
		}else {
			return "";
		}
		}

		public void setInput348t2(String input348t2) {
			this.input348t2 = input348t2;
		}

		public String getInput3482t1() {
			if(input3482t1 !=null) {
			return input3482t1;
		}else {
			return "";
		}
		}

		public void setInput3482t1(String input3482t1) {
			this.input3482t1 = input3482t1;
		}

		public String getInput3482t2() {
			if(input3482t2 !=null) {
			return input3482t2;
		}else {
			return "";
		}
		}

		public void setInput3482t2(String input3482t2) {
			this.input3482t2 = input3482t2;
		}

		public String getInput3441t1() {
			if(input3441t1 !=null) {
			return input3441t1;
		}else {
			return "";
		}
		}

		public void setInput3441t1(String input3441t1) {
			this.input3441t1 = input3441t1;
		}

		public String getInput3441t2() {
			if(input3441t2 !=null) {
			return input3441t2;
		}else {
			return "";
		}
		}

		public void setInput3441t2(String input3441t2) {
			this.input3441t2 = input3441t2;
		}

		public String getCriteria34status() {
			return criteria34status;
		}

		public void setCriteria34status(String criteria34status) {
			this.criteria34status = criteria34status;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteria34status, criteriaId, input3422t1, input342t1, input342t2, input343t1,
					input3441t1, input3441t2, input3451t1, input3451t2, input3452t1, input3461t1, input3461t2,
					input3482t1, input3482t2, input348t1, input348t2, response342, response343, response344,
					response345, response346, response347, response348, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria34Qn other = (Criteria34Qn) obj;
			return Objects.equals(criteria34status, other.criteria34status)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3422t1, other.input3422t1)
					&& Objects.equals(input342t1, other.input342t1) && Objects.equals(input342t2, other.input342t2)
					&& Objects.equals(input343t1, other.input343t1) && Objects.equals(input3441t1, other.input3441t1)
					&& Objects.equals(input3441t2, other.input3441t2) && Objects.equals(input3451t1, other.input3451t1)
					&& Objects.equals(input3451t2, other.input3451t2) && Objects.equals(input3452t1, other.input3452t1)
					&& Objects.equals(input3461t1, other.input3461t1) && Objects.equals(input3461t2, other.input3461t2)
					&& Objects.equals(input3482t1, other.input3482t1) && Objects.equals(input3482t2, other.input3482t2)
					&& Objects.equals(input348t1, other.input348t1) && Objects.equals(input348t2, other.input348t2)
					&& Objects.equals(response342, other.response342) && Objects.equals(response343, other.response343)
					&& Objects.equals(response344, other.response344) && Objects.equals(response345, other.response345)
					&& Objects.equals(response346, other.response346) && Objects.equals(response347, other.response347)
					&& Objects.equals(response348, other.response348) && uniqueKey1 == other.uniqueKey1;
		}
		
	
}
