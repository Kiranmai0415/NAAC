package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "criteria3_fileupload")
public class Criteria3_FileUpload implements Serializable {

	   private static final long serialVersionUID = 1L;

	   
	    private CriteriaPrimaryKey criteriaId;
		
		@Id
		@Column(name="unique_key1")
		private String uniqueKey1;
		
		@Column(name = "criteria3_file_name")
		private String criteria3FileName;
		
		@Column(name = "criteria3_file_path")
		private String criteria3FilePath;
		
		@Column(name = "criteria3_file_type")
		private String criteria3FileType;
		

		

		public CriteriaPrimaryKey getCriteriaId() {
			return criteriaId;
		}

		public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
			this.criteriaId = criteriaId;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public String getCriteria3FileName() {
			return criteria3FileName;
		}

		public void setCriteria3FileName(String criteria3FileName) {
			this.criteria3FileName = criteria3FileName;
		}

		public String getCriteria3FilePath() {
			return criteria3FilePath;
		}

		public void setCriteria3FilePath(String criteria3FilePath) {
			this.criteria3FilePath = criteria3FilePath;
		}

		public String getCriteria3FileType() {
			return criteria3FileType;
		}

		public void setCriteria3FileType(String criteria3FileType) {
			this.criteria3FileType = criteria3FileType;
		}

		public String getUniqueKey1() {
			return uniqueKey1;
		}

		public void setUniqueKey1(String uniqueKey1) {
			this.uniqueKey1 = uniqueKey1;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteria3FileName, criteria3FilePath, criteria3FileType, criteriaId, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criteria3_FileUpload other = (Criteria3_FileUpload) obj;
			return Objects.equals(criteria3FileName, other.criteria3FileName)
					&& Objects.equals(criteria3FilePath, other.criteria3FilePath)
					&& Objects.equals(criteria3FileType, other.criteria3FileType)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(uniqueKey1, other.uniqueKey1);
		}

		
}