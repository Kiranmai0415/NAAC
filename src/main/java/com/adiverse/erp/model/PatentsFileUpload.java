package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patents_fileupload")
public class PatentsFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private CriteriaPrimaryKey criteriaId;
		
	    @Id
	    @Column(name="unique_key1")
		private String uniqueKey1;
	    
	    @Column(name = "patents_file_name")
		private String patentsFileName;
		
		@Column(name = "patents_file_path")
		private String patentsFilePath;
		
		@Column(name = "patents_file_type")
		private String patentsFileType;

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

		public String getPatentsFileName() {
			return patentsFileName;
		}

		public void setPatentsFileName(String patentsFileName) {
			this.patentsFileName = patentsFileName;
		}

		public String getPatentsFilePath() {
			return patentsFilePath;
		}

		public void setPatentsFilePath(String patentsFilePath) {
			this.patentsFilePath = patentsFilePath;
		}

		public String getPatentsFileType() {
			return patentsFileType;
		}

		public void setPatentsFileType(String patentsFileType) {
			this.patentsFileType = patentsFileType;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, patentsFileName, patentsFilePath, patentsFileType, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PatentsFileUpload other = (PatentsFileUpload) obj;
			return Objects.equals(criteriaId, other.criteriaId)
					&& Objects.equals(patentsFileName, other.patentsFileName)
					&& Objects.equals(patentsFilePath, other.patentsFilePath)
					&& Objects.equals(patentsFileType, other.patentsFileType)
					&& Objects.equals(uniqueKey1, other.uniqueKey1);
		}

		
		

}
