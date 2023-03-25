package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professional_development_programmes_fileupload")
public class ProfessionalDevelopmentProgrammesFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	    @Column(name = "professional_development_progm_file_name")
		private String professionalDevelopmentProgmFileName;
		
		@Column(name = "professional_development_progm_file_path")
		private String professionalDevelopmentProgmFilePath;
		
		@Column(name = "professional_development_progm_file_type")
		private String professionalDevelopmentProgmFileType;

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

		public String getProfessionalDevelopmentProgmFileName() {
			if (professionalDevelopmentProgmFileName!=null) {
				return professionalDevelopmentProgmFileName;
			}
			else {
				return "";
			}
			
		}

		public void setProfessionalDevelopmentProgmFileName(String professionalDevelopmentProgmFileName) {
			this.professionalDevelopmentProgmFileName = professionalDevelopmentProgmFileName;
		}

		public String getProfessionalDevelopmentProgmFilePath() {
			if (professionalDevelopmentProgmFilePath!=null) {
				return professionalDevelopmentProgmFilePath;
			}
			else {
				return "";
			}
			
		}

		public void setProfessionalDevelopmentProgmFilePath(String professionalDevelopmentProgmFilePath) {
			this.professionalDevelopmentProgmFilePath = professionalDevelopmentProgmFilePath;
		}

		public String getProfessionalDevelopmentProgmFileType() {
			if (professionalDevelopmentProgmFileType!=null) {
				return professionalDevelopmentProgmFileType;
			}
			else {
				return "";
			}
			
		}

		public void setProfessionalDevelopmentProgmFileType(String professionalDevelopmentProgmFileType) {
			this.professionalDevelopmentProgmFileType = professionalDevelopmentProgmFileType;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, professionalDevelopmentProgmFileName, professionalDevelopmentProgmFilePath,
					professionalDevelopmentProgmFileType, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ProfessionalDevelopmentProgrammesFileUpload other = (ProfessionalDevelopmentProgrammesFileUpload) obj;
			return Objects.equals(criteriaId, other.criteriaId)
					&& Objects.equals(professionalDevelopmentProgmFileName, other.professionalDevelopmentProgmFileName)
					&& Objects.equals(professionalDevelopmentProgmFilePath, other.professionalDevelopmentProgmFilePath)
					&& Objects.equals(professionalDevelopmentProgmFileType, other.professionalDevelopmentProgmFileType)
					&& Objects.equals(uniqueKey1, other.uniqueKey1);
		}

		
}
