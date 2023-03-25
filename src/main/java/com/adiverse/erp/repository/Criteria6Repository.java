package com.adiverse.erp.repository;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adiverse.erp.model.Criteria6_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;


@Repository
public interface Criteria6Repository extends JpaRepository<Criteria6_FieldInfo, CriteriaPrimaryKey>
{
	
//Criteria6 Main Insert
	@Transactional
	@Modifying
	@Query(value="insert into criteria6_fieldinfo (college_id,financial_year,typeof_institution) values (?,?,?) ",nativeQuery=true)
	int  insertCriteria6FieldInfoMain( String value1, String value2,String value3);		
//6321 U,Au,Af Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable6321 (year,conferences_workshops,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable6321( String value1, int value2,long uk,String value4, String value5, String value6);
//6321 U,Au,Af Update
	@Transactional
	@Modifying
	@Query(value="update yeartable6321 set conferences_workshops=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable6321(int value, long uk);	
//6331 U,Au Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable6331 (year,development_administrative,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable6331( String value1, int value2,long uk,String value4, String value5, String value6);
//6331 U,Au Update
	@Transactional
	@Modifying
	@Query(value="update yeartable6331 set development_administrative=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable6331(int value, long uk);	
//6341 U,Au Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable6341 (year,development_programmes,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable6341( String value1, int value2,long uk,String value4, String value5, String value6);
//6341 U,Au Update
	@Transactional
	@Modifying
	@Query(value="update yeartable6341 set development_programmes=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable6341(int value, long uk);
//6331 Af Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable6331 (year,development_administrative,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable6331Af( String value1, int value2,long uk,String value4, String value5, String value6);
//6331 Af Update
	@Transactional
	@Modifying
	@Query(value="update yeartable6331 set development_administrative=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable6331Af(int value, long uk);	
 // Autonomous 
	
//	@Transactional
//	@Modifying
//	@Query("update YearTable6321 y set y.input6321y =?1, y.input6321v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='autonomous' ")
//	int updateYearTable6321(String year, String value);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("update YearTable6331 y set y.input6331y =?1, y.input6331v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='autonomous' ")
//	int updateYearTable6331(int year, String value);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("update YearTable6341 y set y.input6341y =?1, y.input6341v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='autonomous' ")
//	int updateYearTable6341(String year, String value);
//	
//	
// // University
//	
//	@Transactional
//	@Modifying
//	@Query("update YearTable6321 y set y.input6321y =?1, y.input6321v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
//	int updateYearTable6321u(String year, String value);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("update YearTable6331 y set y.input6331y =?1, y.input6331v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
//	int updateYearTable6331u(int year, String value);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("update YearTable6341 y set y.input6341y =?1, y.input6341v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
//	int updateYearTable6341u(String year, String value);
//	
//	
//	
//	
//	
//// Affiliated
//	
//	@Transactional
//	@Modifying
//	@Query("update YearTable6321 y set y.input6321y =?1, y.input6321v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='affiliated' ")
//	int updateYearTable6321a(String year, String value);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("update YearTable6331 y set y.input6331y =?1, y.input6331v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
//	int updateYearTable6331a(int year, String value);
//	
//	
	
	
}

