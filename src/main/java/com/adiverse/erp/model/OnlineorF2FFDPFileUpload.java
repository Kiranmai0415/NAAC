package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "online_f2f_fdp_fileupload")
public class OnlineorF2FFDPFileUpload implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "online_f2f_fdp_file_name")
	private String onlineF2fFdpFileName;
	
	@Column(name = "online_f2f_fdp_file_path")
	private String onlineF2fFdpFilePath;
	
	@Column(name = "online_f2f_fdp_file_type")
	private String onlineF2fFdpFileType;

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

	public String getOnlineF2fFdpFileName() {
		if (onlineF2fFdpFileName!=null) {
			return onlineF2fFdpFileName;
		}
		else {
			return "";
		}
		
	}

	public void setOnlineF2fFdpFileName(String onlineF2fFdpFileName) {
		this.onlineF2fFdpFileName = onlineF2fFdpFileName;
	}

	public String getOnlineF2fFdpFilePath() {
		if (onlineF2fFdpFilePath!=null) {
			return onlineF2fFdpFilePath;
		}
		else {
			return "";
		}
		
	}

	public void setOnlineF2fFdpFilePath(String onlineF2fFdpFilePath) {
		this.onlineF2fFdpFilePath = onlineF2fFdpFilePath;
	}

	public String getOnlineF2fFdpFileType() {
		if (onlineF2fFdpFileType!=null) {
			return onlineF2fFdpFileType;
		}
		else {
			return "";
		}
	}

	public void setOnlineF2fFdpFileType(String onlineF2fFdpFileType) {
		this.onlineF2fFdpFileType = onlineF2fFdpFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, onlineF2fFdpFileName, onlineF2fFdpFilePath, onlineF2fFdpFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OnlineorF2FFDPFileUpload other = (OnlineorF2FFDPFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(onlineF2fFdpFileName, other.onlineF2fFdpFileName)
				&& Objects.equals(onlineF2fFdpFilePath, other.onlineF2fFdpFilePath)
				&& Objects.equals(onlineF2fFdpFileType, other.onlineF2fFdpFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	

}
