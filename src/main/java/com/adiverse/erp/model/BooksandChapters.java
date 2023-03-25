package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books_and_chapters")
public class BooksandChapters implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
     private CriteriaPrimaryKey criteriaId;
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="unique_key1")
	private long uniqueKey1;
    
    @Column(name = "nameofthe_teacher")
	private String inputbct1;
    
    @Column(name = "department")
	private String inputbct2;
    
    @Column(name = "schools_name")
	private String inputbct3;
    
    @Column(name = "titleof_book_chapters_published")
	private String inputbct4;
    
    @Column(name = "titleofthe_paper")
	private String inputbct5;
    
    @Column(name = "titleof_proceedingsofthe_conference")
	private String inputbct6;
    
    @Column(name = "yearof_publication")
	private String inputbct7;
    
    @Column(name = "isbn_issn_noof_proceedings")
	private String inputbct8;
    
    @Column(name = "nameof_publisher")
	private String inputbct9;
    
    @Column(name = "whether_atpublish_affil_wassame")
	private String inputbct10;
    
    @Column(name = "nameofthe_conference")
	private String inputbct11;
    
    @Column(name = "national_international")
	private String inputbct12;

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

	public String getInputbct1() {
		if(inputbct1 !=null) {
		return inputbct1;
	}else {
		return "";
	}
	}

	public void setInputbct1(String inputbct1) {
		this.inputbct1 = inputbct1;
	}

	public String getInputbct2() {
		if(inputbct2 !=null) {
		return inputbct2;
	}else {
		return "";
	}
	}

	public void setInputbct2(String inputbct2) {
		this.inputbct2 = inputbct2;
	}

	public String getInputbct3() {
		if(inputbct3 !=null) {
		return inputbct3;
	}else {
		return "";
	}
	}

	public void setInputbct3(String inputbct3) {
		this.inputbct3 = inputbct3;
	}

	public String getInputbct4() {
		if(inputbct4 !=null) {
		return inputbct4;
	}else {
		return "";
	}
	}

	public void setInputbct4(String inputbct4) {
		this.inputbct4 = inputbct4;
	}

	public String getInputbct5() {
		if(inputbct5 !=null) {
		return inputbct5;
	}else {
		return "";
	}
	}

	public void setInputbct5(String inputbct5) {
		this.inputbct5 = inputbct5;
	}

	public String getInputbct6() {
		if(inputbct6 !=null) {
		return inputbct6;
	}else {
		return "";
	}
	}

	public void setInputbct6(String inputbct6) {
		this.inputbct6 = inputbct6;
	}

	public String getInputbct8() {
		if(inputbct8 !=null) {
		return inputbct8;
	}else {
		return "";
	}
	}

	public void setInputbct8(String inputbct8) {
		this.inputbct8 = inputbct8;
	}

	public String getInputbct9() {
		if(inputbct9 !=null) {
		return inputbct9;
	}else {
		return "";
	}
	}

	public void setInputbct9(String inputbct9) {
		this.inputbct9 = inputbct9;
	}

	public String getInputbct10() {
		if(inputbct10 !=null) {
		return inputbct10;
	}else{
		return "";
	}
	}
		
	

	public void setInputbct10(String inputbct10) {
		this.inputbct10 = inputbct10;
	}

	public String getInputbct11() {
		if(inputbct11 !=null) {
		return inputbct11;
	}else {
		return "";
	}
	}

	public void setInputbct11(String inputbct11) {
		this.inputbct11 = inputbct11;
	}

	public String getInputbct12() {
		if(inputbct12 !=null) {
		return inputbct12;
	}else {
		return "";
	}
	}

	public void setInputbct12(String inputbct12) {
		this.inputbct12 = inputbct12;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getInputbct7() {
		if(inputbct7 !=null) {
		return inputbct7;
	}else {
		return "";
	}
	}

	public void setInputbct7(String inputbct7) {
		this.inputbct7 = inputbct7;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputbct1, inputbct10, inputbct11, inputbct12, inputbct2, inputbct3, inputbct4,
				inputbct5, inputbct6, inputbct7, inputbct8, inputbct9, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BooksandChapters other = (BooksandChapters) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputbct1, other.inputbct1)
				&& Objects.equals(inputbct10, other.inputbct10) && Objects.equals(inputbct11, other.inputbct11)
				&& Objects.equals(inputbct12, other.inputbct12) && Objects.equals(inputbct2, other.inputbct2)
				&& Objects.equals(inputbct3, other.inputbct3) && Objects.equals(inputbct4, other.inputbct4)
				&& Objects.equals(inputbct5, other.inputbct5) && Objects.equals(inputbct6, other.inputbct6)
				&& Objects.equals(inputbct7, other.inputbct7) && Objects.equals(inputbct8, other.inputbct8)
				&& Objects.equals(inputbct9, other.inputbct9) && uniqueKey1 == other.uniqueKey1;
	}
}
