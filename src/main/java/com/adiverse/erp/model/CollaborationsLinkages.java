package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "collaborations_linkages")
public class CollaborationsLinkages implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	
	    @Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
	    
	    @Column(name = "titleofthe_collabor_activities")
		private String inputclt1;
	    
	    @Column(name = "dept")
		private String inputclt2;
	    
	    @Column(name = "schools_name")
		private String inputclt3;
	    
	    @Column(name = "nameofthe_collabor_agency_contact_details")
		private String inputclt4;
	    
	    @Column(name = "nameofthe_participant")
		private String inputclt5;
	    
	    @Column(name = "yearof_collaboration")
		private String inputclt6;
	    
	    @Column(name = "duration")
		private String inputclt7;
	    
	    @Column(name = "natureofthe_activity")
		private String inputclt8;
	    
	    @Column(name = "linktothe_relevant_document")
		private String inputclt9;

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

		public String getInputclt1() {
			if(inputclt1 !=null) {
			return inputclt1;
		}else {
			return "";
		}
		}

		public void setInputclt1(String inputclt1) {
			this.inputclt1 = inputclt1;
		}

		public String getInputclt2() {
			if(inputclt2 !=null) {
			return inputclt2;
		}else {
			return "";
		}
		}

		public void setInputclt2(String inputclt2) {
			this.inputclt2 = inputclt2;
		}

		public String getInputclt3() {
			if(inputclt3 !=null) {
			return inputclt3;
		}else {
			return "";
		}
		}

		public void setInputclt3(String inputclt3) {
			this.inputclt3 = inputclt3;
		}

		public String getInputclt4() {
			if(inputclt4 !=null) {
			return inputclt4;
		}else {
			return "";
		}
		}

		public void setInputclt4(String inputclt4) {
			this.inputclt4 = inputclt4;
		}

		public String getInputclt5() {
			if(inputclt5 !=null) {
			return inputclt5;
		}else {
			return "";
		}
		}

		public void setInputclt5(String inputclt5) {
			this.inputclt5 = inputclt5;
		}

		public String getInputclt6() {
			if(inputclt6 !=null) {
			return inputclt6;
		}else {
			return "";
		}
		}

		public void setInputclt6(String inputclt6) {
			this.inputclt6 = inputclt6;
		}

		public String getInputclt7() {
			if(inputclt7 !=null) {
			return inputclt7;
		}else {
			return "";
		}
		}

		public void setInputclt7(String inputclt7) {
			this.inputclt7 = inputclt7;
		}

		public String getInputclt8() {
			if(inputclt8 !=null) {
			return inputclt8;
		}else {
			return "";
		}
		}

		public void setInputclt8(String inputclt8) {
			this.inputclt8 = inputclt8;
		}

		public String getInputclt9() {
			if(inputclt9 !=null) {
			return inputclt9;
		}else {
			return "";
		}
		}

		public void setInputclt9(String inputclt9) {
			this.inputclt9 = inputclt9;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, inputclt1, inputclt2, inputclt3, inputclt4, inputclt5, inputclt6, inputclt7,
					inputclt8, inputclt9, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CollaborationsLinkages other = (CollaborationsLinkages) obj;
			return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputclt1, other.inputclt1)
					&& Objects.equals(inputclt2, other.inputclt2) && Objects.equals(inputclt3, other.inputclt3)
					&& Objects.equals(inputclt4, other.inputclt4) && Objects.equals(inputclt5, other.inputclt5)
					&& Objects.equals(inputclt6, other.inputclt6) && Objects.equals(inputclt7, other.inputclt7)
					&& Objects.equals(inputclt8, other.inputclt8) && Objects.equals(inputclt9, other.inputclt9)
					&& uniqueKey1 == other.uniqueKey1;
		}

		
	  

	

}
