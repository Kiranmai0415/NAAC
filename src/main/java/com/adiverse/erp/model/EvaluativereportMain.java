package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "evaluativereport_Main")

public class EvaluativereportMain implements Serializable {

	private static final long serialVersionUID = 7087082295931160059L;
    @EmbeddedId
	private CriteriaPrimaryKey criteriaId;



	@Column(name = "nameof_the_autonomous_college")
	private String nameofTheAutonomousCollege;

	@Column(name = "nameof_the_department")
	private String nameofTheDepartment;

	@Column(name = "dist")
	private String dist;

	@Column(name = "state")
	private String state;

	@Column(name = "total_numberof_departments_inthe_institution")
	private String totalNumberofDepartmentsIntheInstitution;

	@OneToMany(cascade = { CascadeType.PERSIST,CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	private List<Evaluativereportofthedepartment11> evaluativereportofthedepartment11;
	



	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getNameofTheAutonomousCollege() {
		return nameofTheAutonomousCollege;
	}

	public void setNameofTheAutonomousCollege(String nameofTheAutonomousCollege) {
		this.nameofTheAutonomousCollege = nameofTheAutonomousCollege;
	}

	public String getNameofTheDepartment() {
		return nameofTheDepartment;
	}

	public void setNameofTheDepartment(String nameofTheDepartment) {
		this.nameofTheDepartment = nameofTheDepartment;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTotalNumberofDepartmentsIntheInstitution() {
		return totalNumberofDepartmentsIntheInstitution;
	}

	public void setTotalNumberofDepartmentsIntheInstitution(String totalNumberofDepartmentsIntheInstitution) {
		this.totalNumberofDepartmentsIntheInstitution = totalNumberofDepartmentsIntheInstitution;
	}

	public List<Evaluativereportofthedepartment11> getEvaluativereportofthedepartment11() {
		return evaluativereportofthedepartment11;
	}

	public void setEvaluativereportofthedepartment11(
			List<Evaluativereportofthedepartment11> evaluativereportofthedepartment11) {
		this.evaluativereportofthedepartment11 = evaluativereportofthedepartment11;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, dist, evaluativereportofthedepartment11, nameofTheAutonomousCollege,
				nameofTheDepartment, state, totalNumberofDepartmentsIntheInstitution);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvaluativereportMain other = (EvaluativereportMain) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(dist, other.dist)
				&& Objects.equals(evaluativereportofthedepartment11, other.evaluativereportofthedepartment11)
				&& Objects.equals(nameofTheAutonomousCollege, other.nameofTheAutonomousCollege)
				&& Objects.equals(nameofTheDepartment, other.nameofTheDepartment) && Objects.equals(state, other.state)
				&& Objects.equals(totalNumberofDepartmentsIntheInstitution,
						other.totalNumberofDepartmentsIntheInstitution);
	}

	
}
