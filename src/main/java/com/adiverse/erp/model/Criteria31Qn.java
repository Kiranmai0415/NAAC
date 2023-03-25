package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria31Qn")
public class Criteria31Qn implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
		
	 	@Column(name = "responseValue312")
	    private String response312;
	

		@Column(name = "responseValue313")
	    private String response313;
		
		@Column(name = "input313t1")
	    private String input313t1;
		
		@Column(name = "responseValue314")
       private String response314;
	
		
	//	getInput314t1
		@Column(name = "Input314t1314")
	       private String Input314t1;
		
		
		@Column(name = "Input3141")
	       private String Input314t2;
		
		
		public String getInput314t2() {
			return Input314t2;
		}


		public void setInput314t2(String input314t2) {
			Input314t2 = input314t2;
		}


		public String getInput314t1() {
			return Input314t1;
		}


		public void setInput314t1(String input314t1) {
			Input314t1 = input314t1;
		}


		@Column(name = "responseValue315")
		private String response315;
		
		@Column(name = "input315t1")
	    private String input315t1;
		
		
	@Column(name = "responseValue316")
    private String response316;

	@Column(name = "input3161t1")
    private String input3161t1;
	
	
	@Column(name = "input3162t1")
    private String input3162t1;


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


	public String getResponse312() {
		if(response312 !=null) {
		return response312;
	}else {
		return "";
	}
	}


	public void setResponse312(String response312) {
		this.response312 = response312;
	}


	public String getResponse313() {
		if(response313 !=null) {
		return response313;
	}else {
		return "";
	}
	}


	public void setResponse313(String response313) {
		this.response313 = response313;
	}


	public String getInput313t1() {
		if(input313t1 !=null) {
		return input313t1;
	}else {
		return "";
	}
	}


	public void setInput313t1(String input313t1) {
		this.input313t1 = input313t1;
	}


	public String getResponse314() {
		if(response314 !=null) {
		return response314;
	}else {
		return "";
	}
	}


	public void setResponse314(String response314) {
		this.response314 = response314;
	}


	public String getResponse315() {
		if(response315 !=null) {
		return response315;
	}else {
		return "";
	}
	}


	public void setResponse315(String response315) {
		this.response315 = response315;
	}


	public String getInput315t1() {
		if(input315t1 !=null) {
		return input315t1;
	}else {
		return "";
	}
	}


	public void setInput315t1(String input315t1) {
		this.input315t1 = input315t1;
	}


	public String getResponse316() {
		if(response316 !=null) {
		return response316;
	}else {
		return "";
	}
	}


	public void setResponse316(String response316) {
		this.response316 = response316;
	}


	public String getInput3161t1() {
		if(input3161t1 !=null) {
		return input3161t1;
		}else {
			return "";
		}
		}


	public void setInput3161t1(String input3161t1) {
		this.input3161t1 = input3161t1;
	}


	public String getInput3162t1() {
		if(input3162t1 !=null) {
		
		return input3162t1;
	}else {
		return "";
	}
	}


	public void setInput3162t1(String input3162t1) {
		this.input3162t1 = input3162t1;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(Input314t1, Input314t2, criteriaId, input313t1, input315t1, input3161t1, input3162t1,
				response312, response313, response314, response315, response316, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria31Qn other = (Criteria31Qn) obj;
		return Objects.equals(Input314t1, other.Input314t1) && Objects.equals(Input314t2, other.Input314t2)
				&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input313t1, other.input313t1)
				&& Objects.equals(input315t1, other.input315t1) && Objects.equals(input3161t1, other.input3161t1)
				&& Objects.equals(input3162t1, other.input3162t1) && Objects.equals(response312, other.response312)
				&& Objects.equals(response313, other.response313) && Objects.equals(response314, other.response314)
				&& Objects.equals(response315, other.response315) && Objects.equals(response316, other.response316)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
			
}
