package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phd_awardedor_registered_fileupload")
public class PhdAwardedorRegisteredFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private CriteriaPrimaryKey criteriaId;
		
	    @Id
	    @Column(name="unique_key1")
		private String uniqueKey1;
	    
	   
	    @Column(name = "phdawarded_file_name")
		private String phdawardedFileName;
		
		@Column(name = "phdawarded_file_path")
		private String phdawardedFilePath;
		
		@Column(name = "phdawarded_file_type")
		private String phdawardedFileType;

		public CriteriaPrimaryKey getCriteriaId() {
			return criteriaId;
		}

		public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
			this.criteriaId = criteriaId;
		}

		public String getUniqueKey1() {
			return uniqueKey1;
		}

		public void setUniqueKey1(String uniqueKey1) {
			this.uniqueKey1 = uniqueKey1;
		}

		public String getPhdawardedFileName() {
			if (phdawardedFileName!=null) {
				return phdawardedFileName;
			}
			else {
				return "";
			}
			
		}

		public void setPhdawardedFileName(String phdawardedFileName) {
			this.phdawardedFileName = phdawardedFileName;
		}

		public String getPhdawardedFilePath() {
			if (phdawardedFilePath!=null) {
				return phdawardedFilePath;
			}
			else {
				return "";
			}
			
		}

		public void setPhdawardedFilePath(String phdawardedFilePath) {
			this.phdawardedFilePath = phdawardedFilePath;
		}

		public String getPhdawardedFileType() {
			if (phdawardedFileType!=null) {
				return phdawardedFileType;
			}
			else {
				return "";
			}
			
		}

		public void setPhdawardedFileType(String phdawardedFileType) {
			this.phdawardedFileType = phdawardedFileType;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, phdawardedFileName, phdawardedFilePath, phdawardedFileType, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PhdAwardedorRegisteredFileUpload other = (PhdAwardedorRegisteredFileUpload) obj;
			return Objects.equals(criteriaId, other.criteriaId)
					&& Objects.equals(phdawardedFileName, other.phdawardedFileName)
					&& Objects.equals(phdawardedFilePath, other.phdawardedFilePath)
					&& Objects.equals(phdawardedFileType, other.phdawardedFileType)
					&& Objects.equals(uniqueKey1, other.uniqueKey1);
		}
		
		
		
}
