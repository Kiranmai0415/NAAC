package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booksand_chapters_fileupload")
public class BooksandChaptersFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
    
    @Column(name = "booksand_chapters_file_name")
	private String booksandchaptersFileName;
	
	@Column(name = "booksand_chapters_file_path")
	private String booksandchaptersFilePath;
	
	@Column(name = "booksand_chapters_file_type")
	private String booksandchaptersFileType;

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

	public String getBooksandchaptersFileName() {
		return booksandchaptersFileName;
	}

	public void setBooksandchaptersFileName(String booksandchaptersFileName) {
		this.booksandchaptersFileName = booksandchaptersFileName;
	}

	public String getBooksandchaptersFilePath() {
		return booksandchaptersFilePath;
	}

	public void setBooksandchaptersFilePath(String booksandchaptersFilePath) {
		this.booksandchaptersFilePath = booksandchaptersFilePath;
	}

	public String getBooksandchaptersFileType() {
		return booksandchaptersFileType;
	}

	public void setBooksandchaptersFileType(String booksandchaptersFileType) {
		this.booksandchaptersFileType = booksandchaptersFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(booksandchaptersFileName, booksandchaptersFilePath, booksandchaptersFileType, criteriaId,
				uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BooksandChaptersFileUpload other = (BooksandChaptersFileUpload) obj;
		return Objects.equals(booksandchaptersFileName, other.booksandchaptersFileName)
				&& Objects.equals(booksandchaptersFilePath, other.booksandchaptersFilePath)
				&& Objects.equals(booksandchaptersFileType, other.booksandchaptersFileType)
				&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(uniqueKey1, other.uniqueKey1);
	}
	
	
	
	
	

}
