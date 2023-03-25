package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "collaborations_linkages_fileupload")
public class CollaborationsLinkagesFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 public CriteriaPrimaryKey criteriaId;
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
    
	    @Column(name = "collaborations_linkages_file_name")
		private String collaborationsLinkagesFileName;
		
		@Column(name = "collaborations_linkages_file_path")
		private String collaborationsLinkagesFilePath;
		
		@Column(name = "collaborations_linkages_file_type")
		private String collaborationsLinkagesFileType;

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

		public String getCollaborationsLinkagesFileName() {
			return collaborationsLinkagesFileName;
		}

		public void setCollaborationsLinkagesFileName(String collaborationsLinkagesFileName) {
			this.collaborationsLinkagesFileName = collaborationsLinkagesFileName;
		}

		public String getCollaborationsLinkagesFilePath() {
			return collaborationsLinkagesFilePath;
		}

		public void setCollaborationsLinkagesFilePath(String collaborationsLinkagesFilePath) {
			this.collaborationsLinkagesFilePath = collaborationsLinkagesFilePath;
		}

		public String getCollaborationsLinkagesFileType() {
			return collaborationsLinkagesFileType;
		}

		public void setCollaborationsLinkagesFileType(String collaborationsLinkagesFileType) {
			this.collaborationsLinkagesFileType = collaborationsLinkagesFileType;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(collaborationsLinkagesFileName, collaborationsLinkagesFilePath,
					collaborationsLinkagesFileType, criteriaId, uniqueKey1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CollaborationsLinkagesFileUpload other = (CollaborationsLinkagesFileUpload) obj;
			return Objects.equals(collaborationsLinkagesFileName, other.collaborationsLinkagesFileName)
					&& Objects.equals(collaborationsLinkagesFilePath, other.collaborationsLinkagesFilePath)
					&& Objects.equals(collaborationsLinkagesFileType, other.collaborationsLinkagesFileType)
					&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(uniqueKey1, other.uniqueKey1);
		}

		
		
}
