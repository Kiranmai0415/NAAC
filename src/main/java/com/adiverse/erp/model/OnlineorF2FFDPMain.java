package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="online_f2f_fdp_main")
public class OnlineorF2FFDPMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    private CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<OnlineorF2FFDP> onlineorF2FFDP;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<OnlineorF2FFDPFileUpload> onlineorF2FFDPFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<OnlineorF2FFDP> getOnlineorF2FFDP() {
		return onlineorF2FFDP;
	}

	public void setOnlineorF2FFDP(List<OnlineorF2FFDP> onlineorF2FFDP) {
		this.onlineorF2FFDP = onlineorF2FFDP;
	}

	public List<OnlineorF2FFDPFileUpload> getOnlineorF2FFDPFileUpload() {
		return onlineorF2FFDPFileUpload;
	}

	public void setOnlineorF2FFDPFileUpload(List<OnlineorF2FFDPFileUpload> onlineorF2FFDPFileUpload) {
		this.onlineorF2FFDPFileUpload = onlineorF2FFDPFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, onlineorF2FFDP, onlineorF2FFDPFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OnlineorF2FFDPMain other = (OnlineorF2FFDPMain) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(onlineorF2FFDP, other.onlineorF2FFDP)
				&& Objects.equals(onlineorF2FFDPFileUpload, other.onlineorF2FFDPFileUpload);
	}

	
    
}
