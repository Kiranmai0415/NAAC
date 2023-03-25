package com.adiverse.erp.model;



import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="basic_profile")
public class BasicProfile implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
		

		@Column(name="Name")
		private String inputbt1;
		
		@Column(name="Address")
		private String inputbt2;
		
		@Column(name="City")
		private String inputbt3;
		
		@Column(name="Pin")
		private String inputbt4;
		
		@Column(name="state_status")
		private String inputbt5;
		
		@Column(name="Website")
		private String inputbt6;

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

		public String getInputbt1() {
			if(inputbt1 !=null) {
			return inputbt1;
		}else {
			return "";
		}
		}

		public void setInputbt1(String inputbt1) {
			this.inputbt1 = inputbt1;
		}

		public String getInputbt2() {
			if(inputbt2 !=null) {
			return inputbt2;
		}else {
			return "";
		}
		}

		public void setInputbt2(String inputbt2) {
			this.inputbt2 = inputbt2;
		}

		public String getInputbt3() {
			if(inputbt3 !=null) {
			return inputbt3;
		}else {
			return "";
		}
		}

		public void setInputbt3(String inputbt3) {
			this.inputbt3 = inputbt3;
		}

		public String getInputbt4() {
			if(inputbt4 !=null) {
			return inputbt4;
		}else {
			return "";
		}
		}

		public void setInputbt4(String inputbt4) {
			this.inputbt4 = inputbt4;
		}

		public String getInputbt5() {
			if(inputbt5 !=null) {
			return inputbt5;
		}else {
			return "";
		}
		}

		public void setInputbt5(String inputbt5) {
			this.inputbt5 = inputbt5;
		}

		public String getInputbt6() {
			if(inputbt6 !=null) {
			return inputbt6;
		}else {
			return "";
		}
		}

		public void setInputbt6(String inputbt6) {
			this.inputbt6 = inputbt6;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, inputbt1, inputbt2, inputbt3, inputbt4, inputbt5, inputbt6, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BasicProfile other = (BasicProfile) obj;
			return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputbt1, other.inputbt1)
					&& Objects.equals(inputbt2, other.inputbt2) && Objects.equals(inputbt3, other.inputbt3)
					&& Objects.equals(inputbt4, other.inputbt4) && Objects.equals(inputbt5, other.inputbt5)
					&& Objects.equals(inputbt6, other.inputbt6) && uniqueKey1 == other.uniqueKey1;
		}

		
		
	
		
}

		
		





