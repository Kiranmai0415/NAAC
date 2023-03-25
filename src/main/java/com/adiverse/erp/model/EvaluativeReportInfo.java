//package com.adiverse.erp.model;
//
//import java.util.List;
//import java.util.Objects;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumns;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//@Entity
//@Table(name ="evaluative_report")
//
//public class EvaluativeReportInfo {
//
//	@EmbeddedId
//    public CriteriaPrimaryKey criteriaId;
//	
//	@Column(name="nameof_the_autonomous_college")
//    private String nameofTheAutonomousCollege;
//	
//	@Column(name="nameof_the_department")
//    private String nameofTheDepartment;
//	
//	@Column(name="dist")
//    private String dist;
//	
//	@Column(name="state")
//    private String state;
//	
//	@Column(name="total_numberof_departments_inthe_institution")
//    private String totalNumberofDepartmentsIntheInstitution;
//
//	// mapping
//	 @JoinColumns ({
//	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
//	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
//	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
//	    })
//		  private List<EvaluativeReportChild> evaluativereportofthedepartment;
//
//	public CriteriaPrimaryKey getCriteriaId() {
//		return criteriaId;
//	}
//
//	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
//		this.criteriaId = criteriaId;
//	}
//
//	public String getNameofTheAutonomousCollege() {
//		return nameofTheAutonomousCollege;
//	}
//
//	public void setNameofTheAutonomousCollege(String nameofTheAutonomousCollege) {
//		this.nameofTheAutonomousCollege = nameofTheAutonomousCollege;
//	}
//
//	public String getNameofTheDepartment() {
//		return nameofTheDepartment;
//	}
//
//	public void setNameofTheDepartment(String nameofTheDepartment) {
//		this.nameofTheDepartment = nameofTheDepartment;
//	}
//
//	public String getDist() {
//		return dist;
//	}
//
//	public void setDist(String dist) {
//		this.dist = dist;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//	public String getTotalNumberofDepartmentsIntheInstitution() {
//		return totalNumberofDepartmentsIntheInstitution;
//	}
//
//	public void setTotalNumberofDepartmentsIntheInstitution(String totalNumberofDepartmentsIntheInstitution) {
//		this.totalNumberofDepartmentsIntheInstitution = totalNumberofDepartmentsIntheInstitution;
//	}
//
//	public List<EvaluativeReportChild> getEvaluativereportofthedepartment() {
//		return evaluativereportofthedepartment;
//	}
//
//	public void setEvaluativereportofthedepartment(List<EvaluativeReportChild> evaluativereportofthedepartment) {
//		this.evaluativereportofthedepartment = evaluativereportofthedepartment;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(criteriaId, dist, evaluativereportofthedepartment, nameofTheAutonomousCollege,
//				nameofTheDepartment, state, totalNumberofDepartmentsIntheInstitution);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		EvaluativeReportInfo other = (EvaluativeReportInfo) obj;
//		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(dist, other.dist)
//				&& Objects.equals(evaluativereportofthedepartment, other.evaluativereportofthedepartment)
//				&& Objects.equals(nameofTheAutonomousCollege, other.nameofTheAutonomousCollege)
//				&& Objects.equals(nameofTheDepartment, other.nameofTheDepartment) && Objects.equals(state, other.state)
//				&& Objects.equals(totalNumberofDepartmentsIntheInstitution,
//						other.totalNumberofDepartmentsIntheInstitution);
//	}
//	 
//	 
//
//	
//}
//	
//
//
