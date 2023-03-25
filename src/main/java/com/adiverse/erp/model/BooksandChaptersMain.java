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
@Table(name = "books_and_chapters_main")
public class BooksandChaptersMain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    public CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<BooksandChapters> booksandChapters;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<BooksandChaptersFileUpload> booksandChaptersFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<BooksandChapters> getBooksandChapters() {
		return booksandChapters;
	}

	public void setBooksandChapters(List<BooksandChapters> booksandChapters) {
		this.booksandChapters = booksandChapters;
	}

	public List<BooksandChaptersFileUpload> getBooksandChaptersFileUpload() {
		return booksandChaptersFileUpload;
	}

	public void setBooksandChaptersFileUpload(List<BooksandChaptersFileUpload> booksandChaptersFileUpload) {
		this.booksandChaptersFileUpload = booksandChaptersFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(booksandChapters, booksandChaptersFileUpload, criteriaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BooksandChaptersMain other = (BooksandChaptersMain) obj;
		return Objects.equals(booksandChapters, other.booksandChapters)
				&& Objects.equals(booksandChaptersFileUpload, other.booksandChaptersFileUpload)
				&& Objects.equals(criteriaId, other.criteriaId);
	}

	
}
