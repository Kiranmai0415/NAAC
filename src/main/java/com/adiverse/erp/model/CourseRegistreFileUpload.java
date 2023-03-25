package com.adiverse.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courseRegistreFileUpload")
public class CourseRegistreFileUpload {
	

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long cmr_id;
	 

		@Column(name = "courseRegistre_name")
		private String courseRegistrename;
		
		@Column(name = "courseRegistre_path")
		private String courseRegistretFilepath;
		
		@Column(name = "courseRegistre_type")
		private String courseRegistreType;
		
		@Column(name = "courseRegistre_type1")
		private String courseRegistreType1;

		public long getCmr_id() {
			return cmr_id;
		}

		public void setCmr_id(long cmr_id) {
			this.cmr_id = cmr_id;
		}

		public String getCourseRegistrename() {
			return courseRegistrename;
		}

		public void setCourseRegistrename(String courseRegistrename) {
			this.courseRegistrename = courseRegistrename;
		}

		public String getCourseRegistretFilepath() {
			return courseRegistretFilepath;
		}

		public void setCourseRegistretFilepath(String courseRegistretFilepath) {
			this.courseRegistretFilepath = courseRegistretFilepath;
		}

		public String getCourseRegistreType() {
			return courseRegistreType;
		}

		public void setCourseRegistreType(String courseRegistreType) {
			this.courseRegistreType = courseRegistreType;
		}

		public String getCourseRegistreType1() {
			return courseRegistreType1;
		}

		public void setCourseRegistreType1(String courseRegistreType1) {
			this.courseRegistreType1 = courseRegistreType1;
		}


		
		
	
	

}
