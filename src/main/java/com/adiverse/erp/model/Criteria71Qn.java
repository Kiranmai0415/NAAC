package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria71Qn")
public class Criteria71Qn implements Serializable
{
	
	private static final long serialVersionUID = 4708923488494526011L;


	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "responseValue712")
    private String response712;
	
	@Column(name = "input712t1")
    private String input712t1;
	
	@Column(name = "responseValue713")
    private String response713;

	@Column(name = "input713t1")
    private String input713t1;
	
	@Column(name = "responseValu714")
    private String response714;
	
	@Column(name = "input714t1")
    private String input714t1;
	
	@Column(name = "responseValue715")
    private String response715;
	
	@Column(name = "input715t1")
    private String input715t1;
	
	@Column(name = "responseValue716")
    private String response716;
	
	@Column(name = "input716t1")
    private String input716t1;
	
	@Column(name = "responseValue717")
    private String response717;
	
	@Column(name = "input717t1")
    private String input717t1;
	
	@Column(name = "responseValue7110")
    private String response7110;
	
	@Column(name = "input7110t1")
    private String input7110t1;

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

	public String getResponse712() {
		if(response712!=null) {
		return response712;
	}else {
		return "";
	}
	}

	public void setResponse712(String response712) {
		this.response712 = response712;
	}

	public String getInput712t1() {
		if(input712t1 !=null) {
		return input712t1;
	}else {
		return "";
	}
	}

	public void setInput712t1(String input712t1) {
		this.input712t1 = input712t1;
	}

	public String getResponse713() {
		if(response713 !=null) {
		return response713;
	}else {
		return "";
	}
	}

	public void setResponse713(String response713) {
		this.response713 = response713;
	}

	public String getInput713t1() {
		if(input713t1 !=null) {
		return input713t1;
	}else {
		return "";
	}
	}

	public void setInput713t1(String input713t1) {
		this.input713t1 = input713t1;
	}

	public String getResponse714() {
		if(response714 !=null) {
		return response714;
	}else {
		return "";
	}
	}

	public void setResponse714(String response714) {
		this.response714 = response714;
	}

	public String getInput714t1() {
		if(input714t1 !=null) {
		return input714t1;
	}else {
		return "";
	}
	}

	public void setInput714t1(String input714t1) {
		this.input714t1 = input714t1;
	}

	public String getResponse715() {
		if(response715 !=null ) {
		return response715;
	}else {
		return "";
	}
	}

	public void setResponse715(String response715) {
		this.response715 = response715;
	}

	public String getInput715t1() {
		if(input715t1 !=null) {
		return input715t1;
	}else {
		return "";
	}
	}

	public void setInput715t1(String input715t1) {
		this.input715t1 = input715t1;
	}

	public String getResponse716() {
		if(response716 !=null) {
		return response716;
	}else {
		return "";
	}
	}

	public void setResponse716(String response716) {
		this.response716 = response716;
	}

	public String getInput716t1() {
		if(input716t1 !=null) {
		return input716t1;
	}else {
		return "";
	}
	}

	public void setInput716t1(String input716t1) {
		this.input716t1 = input716t1;
	}

	public String getResponse717() {
		if(response717 !=null) {
		return response717;
	}else {
		return "";
	}
	}

	public void setResponse717(String response717) {
		this.response717 = response717;
	}

	public String getInput717t1() {
		if(input717t1 !=null) {
		return input717t1;
	}else{
		return "";
	}
	}
		
	

	public void setInput717t1(String input717t1) {
		this.input717t1 = input717t1;
	}

	public String getResponse7110() {
		if(response7110 !=null) {
		return response7110;
	}else {
		return "";
	}
	}

	public void setResponse7110(String response7110) {
		this.response7110 = response7110;
	}

	public String getInput7110t1() {
		return input7110t1;
	}

	public void setInput7110t1(String input7110t1) {
		this.input7110t1 = input7110t1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input7110t1, input712t1, input713t1, input714t1, input715t1, input716t1,
				input717t1, response7110, response712, response713, response714, response715, response716, response717,
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
		Criteria71Qn other = (Criteria71Qn) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input7110t1, other.input7110t1)
				&& Objects.equals(input712t1, other.input712t1) && Objects.equals(input713t1, other.input713t1)
				&& Objects.equals(input714t1, other.input714t1) && Objects.equals(input715t1, other.input715t1)
				&& Objects.equals(input716t1, other.input716t1) && Objects.equals(input717t1, other.input717t1)
				&& Objects.equals(response7110, other.response7110) && Objects.equals(response712, other.response712)
				&& Objects.equals(response713, other.response713) && Objects.equals(response714, other.response714)
				&& Objects.equals(response715, other.response715) && Objects.equals(response716, other.response716)
				&& Objects.equals(response717, other.response717) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
}
