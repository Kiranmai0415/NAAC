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
@Table(name ="research_papers_published")


public class ResearchPapersPublished implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private CriteriaPrimaryKey criteriaId;
		
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="unique_key1")
		private long uniqueKey1;
	    
	    
	    @Column(name="titleof_paper")
		private String inputrp1;
	    
	    @Column(name="nameofthe_authors")
		private String inputrp2;
	    
	    @Column(name="dept")
		private String inputrp3;
	    
	    @Column(name="schools_name")
		private String inputrp4;
	    
	    @Column(name="department_ofthe_teacher")
		private String inputrp5;
	    
	    @Column(name="nameof_journal")
		private String inputrp6;
	    
	    @Column(name="yearof_publication")
		private String inputrp7;
	    
	    @Column(name="issn_number")
		private String inputrp8;
	    
	    @Column(name="linkto_websiteofthe_journal")
		private String inputrp9;
	    
	    @Column(name="linkto_article_paper_abstractofthe_article")
		private String inputrp10;
	    
	    @Column(name="isit_listedin_ugc_carelist_r_n")
	    private String inputrp11;

	    @Column(name="curr_year")
	    private String inputrp12;

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

		public String getInputrp1() {
			if (inputrp1!=null) {
				return inputrp1;
			}
			else {
				return "";
			}
			
		}

		public void setInputrp1(String inputrp1) {
			this.inputrp1 = inputrp1;
		}

		public String getInputrp2() {
			if (inputrp2!=null) {
				return inputrp2;
			}
			else {
				return "";
			}
			
		}

		public void setInputrp2(String inputrp2) {
			this.inputrp2 = inputrp2;
		}

		public String getInputrp3() {
			if (inputrp3!=null) {
				return inputrp3;
			}
			else {
				return "";
			}
			
		}

		public void setInputrp3(String inputrp3) {
			this.inputrp3 = inputrp3;
		}

		public String getInputrp4() {
			if (inputrp4!=null) {
				return inputrp4;
			}
			else {
				return "";
			}
			
		}

		public void setInputrp4(String inputrp4) {
			this.inputrp4 = inputrp4;
		}

		public String getInputrp5() {
			if (inputrp5!=null) {
				return inputrp5;
			}
			else {
				return "";
			}
			
		}

		public void setInputrp5(String inputrp5) {
			this.inputrp5 = inputrp5;
		}

		public String getInputrp6() {
			if (inputrp6!=null) {
				return inputrp6;
			}
			else {
				return "";
			}
		}

		public void setInputrp6(String inputrp6) {
			this.inputrp6 = inputrp6;
		}

		public String getInputrp7() {
			if (inputrp7!=null) {
				return inputrp7;
			}
			else {
				return "";
			}
		}

		public void setInputrp7(String inputrp7) {
			this.inputrp7 = inputrp7;
		}

		public String getInputrp8() {
			if (inputrp8!=null) {
				return inputrp8;
			}
			else {
				return "";
			}
		}

		public void setInputrp8(String inputrp8) {
			this.inputrp8 = inputrp8;
		}

		public String getInputrp9() {
			if (inputrp9!=null) {
				return inputrp9;
			}
			else {
				return "";
			}
		}

		public void setInputrp9(String inputrp9) {
			this.inputrp9 = inputrp9;
		}

		public String getInputrp10() {
			if (inputrp10!=null) {
				return inputrp10;
			}
			else {
				return "";
			}
		}

		public void setInputrp10(String inputrp10) {
			this.inputrp10 = inputrp10;
		}

		public String getInputrp11() {
			if (inputrp11!=null) {
				return inputrp11;
			}
			else {
				return "";
			}
		}

		public void setInputrp11(String inputrp11) {
			this.inputrp11 = inputrp11;
		}

		public String getInputrp12() {
			if (inputrp12!=null) {
				return inputrp12;
			}
			else {
				return "";
			}
		}

		public void setInputrp12(String inputrp12) {
			this.inputrp12 = inputrp12;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, inputrp1, inputrp10, inputrp11, inputrp12, inputrp2, inputrp3, inputrp4,
					inputrp5, inputrp6, inputrp7, inputrp8, inputrp9, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ResearchPapersPublished other = (ResearchPapersPublished) obj;
			return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputrp1, other.inputrp1)
					&& Objects.equals(inputrp10, other.inputrp10) && Objects.equals(inputrp11, other.inputrp11)
					&& Objects.equals(inputrp12, other.inputrp12) && Objects.equals(inputrp2, other.inputrp2)
					&& Objects.equals(inputrp3, other.inputrp3) && Objects.equals(inputrp4, other.inputrp4)
					&& Objects.equals(inputrp5, other.inputrp5) && Objects.equals(inputrp6, other.inputrp6)
					&& Objects.equals(inputrp7, other.inputrp7) && Objects.equals(inputrp8, other.inputrp8)
					&& Objects.equals(inputrp9, other.inputrp9) && uniqueKey1 == other.uniqueKey1;
		}
	    
	    
	    
	    
	    
	    
	    
	    
}
