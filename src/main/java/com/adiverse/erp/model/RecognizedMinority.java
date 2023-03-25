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
@Table(name="Recognized_Minority")
public class RecognizedMinority implements Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
		
		@Column(name="recogized_minority")
		private String inputbtr1;
		
		@Column(name="specify_minority")
		private String inputbtr2;
		
		@Column(name="religious")
		private String inputbtr3;
		
		@Column(name="linguistic")
		private String inputbtr4;
		
		@Column(name="any_other")
		private String inputbtr5;
		
		public static long getSerialversionuid() {
			return serialVersionUID;
		}


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

		public String getInputbtr1() {
			if (inputbtr1!=null) {
				return inputbtr1;
			}
			else {
				return "";
			}
			
		}

		public void setInputbtr1(String inputbtr1) {
			this.inputbtr1 = inputbtr1;
		}

		public String getInputbtr2() {
			if (inputbtr2!=null) {
				return inputbtr2;
			}
			else {
				return "";
			}
		}

		public void setInputbtr2(String inputbtr2) {
			this.inputbtr2 = inputbtr2;
		}

		public String getInputbtr3() {
			if (inputbtr3!=null) {
				return inputbtr3;
			}
			else {
				return "";
			}
		}

		public void setInputbtr3(String inputbtr3) {
			this.inputbtr3 = inputbtr3;
		}

		public String getInputbtr4() {
			if (inputbtr4!=null) {
				return inputbtr4;
			}
			else {
				return "";
			}
		}

		public void setInputbtr4(String inputbtr4) {
			this.inputbtr4 = inputbtr4;
		}

		public String getInputbtr5() {
			if (inputbtr5!=null) {
				return inputbtr5;
			}
			else {
				return "";
			}
		}

		public void setInputbtr5(String inputbtr5) {
			this.inputbtr5 = inputbtr5;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, inputbtr1, inputbtr2, inputbtr3, inputbtr4, inputbtr5, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RecognizedMinority other = (RecognizedMinority) obj;
			return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputbtr1, other.inputbtr1)
					&& Objects.equals(inputbtr2, other.inputbtr2) && Objects.equals(inputbtr3, other.inputbtr3)
					&& Objects.equals(inputbtr4, other.inputbtr4) && Objects.equals(inputbtr5, other.inputbtr5)
					&& uniqueKey1 == other.uniqueKey1;
		}

		
			   
		
	
		
}

		
		





