package com.adiverse.erp.repository;
//import java.util.List;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;


@Repository
public interface Criteria2Repository extends JpaRepository<Criteria2_FieldInfo, CriteriaPrimaryKey>
{
	
// 2.3.1 U,Au,Af main insert	
	@Transactional
	@Modifying
	@Query(value="insert into criteria2_fieldinfo (college_id,financial_year,typeof_institution) values (?,?,?)",nativeQuery = true)
	int  insertCriteria2Main( String value1, String value2,String value3);
//2.3.1 U,Au,Af insert 	
	@Transactional
	@Modifying
	@Query( value="insert into criteria23Ql (input231t1,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?) ", nativeQuery=true)
	int insertCriteria23Ql(String value1, int value3,String value4,String value5,String value6);
//2.3.1 U,Au,Af update	
	@Transactional
	@Modifying
	@Query(value="update criteria23Ql  set input231t1=?1 where unique_key1=?2 ",nativeQuery=true)
	int updateCriteria23Ql(String val1, long uk );	
//	231 Au
	@Transactional
	@Modifying
	@Query(value="update criteria23Ql  set input231t1=?1 where unique_key1=?2 ",nativeQuery=true)
	int updateCriteria23QlAu(String val1, long uk );	
//2.3.2 U,Au, Insert
	@Transactional
	@Modifying
	@Query( value="insert into criteria23Ql (input232t1,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?) ", nativeQuery=true)
	int insertCriteria23Ql1(String value1, int value3,String value4,String value5,String value6);
//2.3.2 U,Au Update
	@Transactional
	@Modifying
	@Query(value="update criteria23Ql  set input232t1 =?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateCriteria23Ql1(String response, long uk );	
//2.3.3 U,AU Insert
	@Transactional
	@Modifying
	@Query( value="insert into criteria23Qn (input2331t1,input2331t2,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?) ", nativeQuery=true)
	int insertCriteria23Qn(String value1,String value2, int value3,String value4,String value5,String value6);
//2.3.3 U,Au Update
	@Transactional
	@Modifying
	@Query(value="update criteria23Qn  set input2331t1 =?1,input2331t2=?2 where unique_key1 =?3 ",nativeQuery=true)
	int updateCriteria23Qn(BigDecimal response,BigDecimal response1, long uk );	
//2421 U,Au,Af Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable2421 (year,fulltime_teachers,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery = true)
	int  insertYearTable2421( String value1, int value2,int value3,String value4,String value5,String value6);
//2421 U,Au,Af Update	
	@Transactional
	@Modifying
	@Query(value="update yeartable2421  set fulltime_teachers =?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable2421(int courses, long uk);
//2.4.3.1 U,Au Insert
	@Transactional
	@Modifying
	@Query( value="insert into criteria24Qn (input2431t1,input2431t2,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?) ", nativeQuery=true)
	int insertCriteria243Qn(String value1,int value2,int value3, String value4,String value5,String value6);
//2.4.3.1 U,Au Update
	@Transactional
	@Modifying
	@Query(value="update criteria24Qn  set input2431t1=?1,input2431t2=?2 where unique_key1 =?3 ",nativeQuery=true)
	int updateCriteria243Qn(BigDecimal finalValue1,int value2, long uk );	
//2441 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into universityyeartable2441 (year,Recognized_bodies,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery = true)
	int  insertYearTable2441( String value1, int value2,int value3,String value4,String value5,String value6);
//2441 U Update
	@Transactional
	@Modifying
	@Query(value="update universityyeartable2441  set Recognized_bodies =?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable2441(int value, long uk);	
//2.6.2 U,Au Insert
	@Transactional
	@Modifying
	@Query( value="insert into criteria26Ql (input262t1,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?) ", nativeQuery=true)
	int insertCriteria26Ql(String value1, int value2,String value3,String value4,String value5);
//2.6.2 U,Au Update
	@Transactional
	@Modifying
	@Query(value="update criteria26Ql  set input262t1=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateCriteria26Ql(String value1, long uk );
//2.6.3 U,Au Insert
	@Transactional
	@Modifying
	@Query( value="insert into criteria26Qn (input2631t1,input2632t1,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?) ", nativeQuery=true)
	int insertCriteria26Qn(String value1,String value2, int value3,String value4,String value5,String value6);
//2.6.3 U,Au Update
	@Transactional
	@Modifying
	@Query(value="update criteria26Qn  set input2631t1 =?1,input2632t1=?2 where unique_key1 =?3 ",nativeQuery=true)
	int updateCriteria26Qn(BigDecimal finalValue1,BigDecimal finalValue2, long uk );
	
// 2.6.2 Af Insert
	@Transactional
	@Modifying
	@Query( value="insert into criteria26Qn (input2622t2,input2621t1,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?) ", nativeQuery=true)
	int insertCriteria26QnAf(String value1,String value2, int value3,String value4,String value5,String value6);
//2.6.3 U,Au Update
	@Transactional
	@Modifying
	@Query(value="update criteria26Qn  set input2621t1 =?1,input2622t2=?2 where unique_key1 =?3 ",nativeQuery=true)
	int updateCriteria26QnAf(BigDecimal finalValue1,BigDecimal finalValue2, long uk );
	
	
	
////4.U,Au,Af	231
//	@Transactional
//	@Modifying
//	@Query("update Criteria2_FieldInfoQl y set y.response231 =?1 where y.uniqueKey1 ='1' ")
//	int updateCriteria2_FieldInfoQl1(String response );
//  
////5.AU,U 232	
//	@Transactional
//	@Modifying
//	@Query("update Criteria2_FieldInfoQl y set y.response232 =?1 where y.uniqueKey1 ='1' ")
//	int updateCriteria2_FieldInfoQl2(String response);
//	
////6.Au,U 233	
//	@Transactional
//	@Modifying
//	@Query("update Criteria2_FieldInfoQn y set y.input2331t1 =?1, y.input2331t2 =?2 where y.uniqueKey1 ='1' ")
//	int updateCriteria2_FieldInfoQn(String noofMentors,String noofStudents);
//	
////7.Au,U,Af 242	
//	@Transactional
//	@Modifying
//	@Query("update YearTable2421 y set y.input2421y =?1, y.input2421v =?2 where y.uniqueKey1 ='1' ")
//	int updateYearTable2421(String year,String value);
//	
//	@Transactional
//	@Modifying
//	@Query("insert into  Criteria2_FieldInfoQn y set y.input2431t1 =?1,  y.input2431t3 =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId=?3 and y.criteriaId.financialYear=?4 and y.criteriaId.typeofInstitution=?5 ")
//	int updateCriteria2_FieldInfoQn1(String experience, String noofteachers,String collegeId, String fYear, String institution);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("update Criteria2_FieldInfoQl y set y.response262 =?1 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='autonomous' ")
//	int updateCriteria2_FieldInfoQl3(String response);
//	
//	@Transactional
//	@Modifying
//	@Query("update Criteria2_FieldInfoQn y set y.input2631t1=?1,  y.input2632t1 =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='autonomous' ")
//	int updateCriteria2_FieldInfoQn3(String noofPassed,String noofAttended);
//	
//	
	
	
	
	
	
}

