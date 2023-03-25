package com.adiverse.erp.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;


@Repository
public interface Criteria3Repository extends JpaRepository<Criteria3_FieldInfo, CriteriaPrimaryKey>
{	
	
//Criteria3 Main Insert
	@Transactional
	@Modifying
	@Query(value="insert into criteria3_fieldinfo (college_id,financial_year,typeof_institution) values (?,?,?) ",nativeQuery=true)
	int  insertCriteria3FieldInfoMain( String value1, String value2,String value3);	
//3.1.2 U,Au Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable3121 (year,seed_money,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3121( String value1, String value2,long uk,String value4, String value5, String value6);
//3.1.2 U,Au Update	
	@Transactional
	@Modifying
	@Query(value="update yeartable3121 set seed_money=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3121(BigDecimal value, long uk);	
//3.1.4 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into universityyeartable3141 (year,JRF_SRF,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3141( String value1, int value2,long uk,String value4, String value5, String value6);	
//3.1.4 U Update
	@Transactional
	@Modifying
	@Query(value="update universityyeartable3141 set JRF_SRF=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3141(int value, long uk);
	
	// govt & non-govt
	
//3.2.31 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into universityyeartable3231 (year,research_projects,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3231( String value1, String value2,long uk,String value4, String value5, String value6);	
//3.2.11 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable3211 (year,grant12,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3211U( String value1, String value2,long uk,String value4, String value5, String value6);
//3.2.11 U update
	@Transactional
	@Modifying
	@Query(value="update yeartable3211 set grant12=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3211U(BigDecimal value, long uk);	
//3.2.2.1 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable3221 (year,research_projects,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3221U( String value1, String value2,long uk,String value4, String value5, String value6);
//3221 U Update
	@Transactional
	@Modifying
	@Query(value="update yeartable3221 set research_projects=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3221U(BigDecimal value, long uk);
//3.2.1 U Update
	@Transactional
	@Modifying
	@Query(value="update universityyeartable3231 set research_projects=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3231(BigDecimal value, long uk);	
	
//3.2.1.1 Au Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable3211 (year,grant12,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3211Au( String value1, String value2,long uk,String value4, String value5, String value6);	
//3.2.1 U Update
	@Transactional
	@Modifying
	@Query(value="update yeartable3211 set grant12=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3211Au(BigDecimal value, long uk);	
//3.2.1.1 Au Insert
	@Transactional
	@Modifying
	@Query(value="insert into affiliated_yeartable3111 (year,researchprojects,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3111Af( String value1, String value2,long uk,String value4, String value5, String value6);	
//3.2.1 U Update
	@Transactional
	@Modifying
	@Query(value="update affiliated_yeartable3111 set researchprojects=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3111Af(BigDecimal value, long uk);	
//3.3.2 U,Au insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable3321 (year,workshop,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3321( String value1, int value2,long uk,String value4, String value5, String value6);
//3.3.2 U,Au Update
	@Transactional
	@Modifying
	@Query(value="update yeartable3321 set workshop=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3321(int value, long uk);
//3.2.2 Af Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable3221 (year,research_projects,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3221( String value1, int value2,long uk,String value4, String value5, String value6);
//3.2.2 Af Update
	@Transactional
	@Modifying
	@Query(value="update yeartable3221 set research_projects=?1 where unique_key1=?2 ",nativeQuery=true)
	int updateYearTable3221(int value, long uk);	
//3.3.3 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into universityyeartable3331 (year,awards_recognitions,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3331( String value1, int value2,long uk,String value4, String value5, String value6);
//3.3.3 U Update
	@Transactional
	@Modifying
	@Query(value="update universityyeartable3331 set awards_recognitions=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3331(int value, long uk);
//3.4.3 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into universityyeartable3431 (year,published_awarded,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3431( String value1, int value2,long uk,String value4, String value5, String value6);
//3.4.3 U Update
	@Transactional
	@Modifying
	@Query(value="update universityyeartable3431 set published_awarded=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3431(int value, long uk);	
//3.4.4.1 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable3441 (year,books,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3441( String value1, int value2,long uk,String value4, String value5, String value6);
//3.4.4.1 U Update
	@Transactional
	@Modifying
	@Query(value="update yeartable3441 set books=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3441(int value, long uk);
//3.4.4.2 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into universityyeartable3442 (year,guides_during,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3442( String value1, int value2,long uk,String value4, String value5, String value6);
//3.4.4.2 U Update
	@Transactional
	@Modifying
	@Query(value="update universityyeartable3442 set guides_during=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3442(int value, long uk);	
//3.4.5.1 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into universityyeartable34512 (year,ugc_website,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3451( String value1, int value2,long uk,String value4, String value5, String value6);
//3.4.5.1 U Update
	@Transactional
	@Modifying
	@Query(value="update universityyeartable34512 set ugc_website=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3451(int value, long uk);
//3.4.3.1 Au Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable3431 (year,research_papers,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3431Au( String value1, int value2,long uk,String value4, String value5, String value6);
//3.4.3.1 Au Update
	@Transactional
	@Modifying
	@Query(value="update yeartable3431 set research_papers=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3431Au(int value, long uk);	
//3.3.1.1 Af Insert
	@Transactional
	@Modifying
	@Query(value="insert into affiliated_yeartable3311 (year,journals,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3311Af( String value1, int value2,long uk,String value4, String value5, String value6);
//3.3.1.1 Af Update
	@Transactional
	@Modifying
	@Query(value="update affiliated_yeartable3311 set journals=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3311Af(int value, long uk);
//3.4.6.1 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into universityyeartable3461 (year,books_chapters,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3461( String value1, int value2,long uk,String value4, String value5, String value6);
//3.4.6.1 U Update
	@Transactional
	@Modifying
	@Query(value="update universityyeartable3461 set books_chapters=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updatreYearTable3461(int value, long uk);	
//3.4.4.1 Au Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable3441 (year,books,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3441Au( String value1, int value2,long uk,String value4, String value5, String value6);
//3.4.4.1 Au Update
	@Transactional
	@Modifying
	@Query(value="update yeartable3441 set books=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updatreYearTable3441Au(int value, long uk);
//3.3.2.1 Af Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable3321 (year,workshop,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3321Af( String value1, int value2,long uk,String value4, String value5, String value6);
//3.3.2.1 Af Update
	@Transactional
	@Modifying
	@Query(value="update yeartable3321 set workshop=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3321Af(int value, long uk);	
//3.4.8.1 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into criteria34Qn (input3481t1,input348t2,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertCriteria3481U( String value1, String value2,long uk,String value4, String value5, String value6);
//3.4.8.1 U Update
	@Transactional
	@Modifying
	@Query(value="update criteria34Qn set input3481t1=?1,input348t2=?2 where unique_key1 =?3 ",nativeQuery=true)
	int updateCriteria3481U(BigDecimal value1,BigDecimal value2, long uk);	
//3.4.5.1 Au Insert
	@Transactional
	@Modifying
	@Query(value="insert into criteria34Qn (input3451t1,input3451t2,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertCriteria3451Au( String value1, String value2,long uk,String value4, String value5, String value6);
//3.4.5.1 Au Update
	@Transactional
	@Modifying
	@Query(value="update criteria34Qn set input3451t1=?1,input3451t2=?2 where unique_key1 =?3 ",nativeQuery=true)
	int updateCriteria3451Au(BigDecimal value1,BigDecimal value2, long uk);
//3.4.9.1 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into criteria34Ql (input3491t1,input3491t2,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertCriteria3491U( String value1, String value2,long uk,String value4, String value5, String value6);
//3.4.9.1 U Update
	@Transactional
	@Modifying
	@Query(value="update criteria34Ql set input3491t1=?1,input3491t2=?2 where unique_key1 =?3 ",nativeQuery=true)
	int updateCriteria3491U(BigDecimal value1,BigDecimal value2, long uk);	
//3.4.6.1 AU Insert
	@Transactional
	@Modifying
	@Query(value="insert into criteria34Qn (input3461t1,input3461t2,input3451t1,input3451t2,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?,?,?)",nativeQuery=true)
	int  insertCriteria3461AU( String value1, String value2, int value7, int value8,long uk,String value4, String value5, String value6);
//3.4.6.1 AU Update
	@Transactional
	@Modifying
	@Query(value="update criteria34Qn set input3461t1=?1,input3461t2=?2 where unique_key1 =?3 ",nativeQuery=true)
	int updateCriteria3461AU(BigDecimal value1,BigDecimal value2, long uk);
	
	
	
//	//3.4.6.1 AU Insert
//		@Transactional
//		@Modifying
//		@Query(value="insert into criteria34Qn (input3461t1,input3461t2,college_id,financial_year,typeof_institution) values (?,?,?,?,?)",nativeQuery=true)
//		int  insertCriteria3461AUniq( String value1, String value2,String value4, String value5, String value6);
//	//3.4.6.1 AU Update
//		@Transactional
//		@Modifying
//		@Query(value="update criteria34Qn set input3461t1=?1,input3461t2=?2 where unique_key1 =?3 ",nativeQuery=true)
//		int updateCriteria3461AUniq(BigDecimal value1,BigDecimal value2, long uk);
	
	
	
	
	
	
	
	
	
	
// 3521 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable3521 (year,amount_spent,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3521( String value1, String value2,long uk,String value4, String value5, String value6);
// 3521 U update
	@Transactional
	@Modifying
	@Query(value="update yeartable3521 set amount_spent=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3521(BigDecimal value, long uk);
//3521 corp Update
	@Transactional
	@Modifying
	@Query(value="update yeartable3521 set amount_spent=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3521Corp(BigDecimal value, long uk);
//3511 U Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable3511 (year,amount_generated,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3511( String value1, String value2,long uk,String value4, String value5, String value6);
// 3511 U update
	@Transactional
	@Modifying
	@Query(value="update yeartable3511 set amount_generated=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3511(BigDecimal value, long uk);
//3511 corp Update
	@Transactional
	@Modifying
	@Query(value="update yeartable3511 set amount_generated=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3511Corp(BigDecimal value, long uk);	
	
//3.7.1.1 U,Au,Af Insert
	@Transactional
	@Modifying
	@Query(value="insert into yeartable3711 (year,collaborative_activities,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery=true)
	int  insertYearTable3711( String value1, int value2,long uk,String value4, String value5, String value6);
//3.7.1.1 U,Au,Af Update
	@Transactional
	@Modifying
	@Query(value="update yeartable3711 set collaborative_activities=?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable3711(int value, long uk);		
//	@Transactional
//	@Modifying
//	@Query("insert into yeartable3121 (year,value_added,uniqueKey,college_id,financial_year,typeof_institution) values (?1,?2,?3,?4,?5,?6) ")
//	int  insertYearTable3121a( String value1, String value2,String value3,String value4, String value5, String value6);
	
 // Autonomous
	
//	@Transactional
//	@Modifying
//	@Query("update YearTable3121 y set y.input3121y =?1, y.input3121v = ?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='autonomous' ")
//	int updateYearTable3121(String year, String value);
//	
//	@Transactional
//	@Modifying
//	@Query("update YearTable3211 y set y.input3211y =?1, y.input3211v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='autonomous' ")
//	int updateYearTable3211(int year, double money);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("update YearTable3321 y set y.input3321y =?1, y.input3321v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='autonomous' ")
//	int updateYearTable3321(String year, String value);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("update YearTable3431 y set y.input3431y =?1, y.input3431v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='autonomous' ")
//	int updateYearTable3431(String year , String number);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("update YearTable3441 y set y.input3441y =?1, y.input3441v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId=?3 and y.criteriaId.financialYear=?4 and y.criteriaId.typeofInstitution=?5 ")
//	int updateYearTable3441(String year , String number);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("update Criteria3_FieldInfoQn y set y.input3451t1 =?1, y.input3452t1=?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='autonomous' ")
//	int updateCriteria3_FieldInfoQn(String t1,String t2);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("update Criteria3_FieldInfoQn y set y.input3461t1 =?1, y.input3461t2=?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='autonomous' ")
//	int updateCriteria3_FieldInfoQn1(String t1,String t2);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("update YearTable3511 y set y.input3511y =?1, y.input3511v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='autonomous' ")
//	int updateYearTable3511(String year , String number);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("update YearTable3711 y set y.input3711y =?1, y.input3711v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='autonomous' ")
//	int updateYearTable3711(int year , String number);
//	
//	
	
	/*
	
	
	// University
	
	@Transactional
	@Modifying
	@Query("update YearTable3121 y set y.input3121y =?1, y.input3121v = ?2 where y.uniqueKey1 ='1' "
			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
	int updateYearTable3121u(String year, String value);
	
	
	@Transactional
	@Modifying
	@Query("update YearTable3141 y set y.input3141y =?1, y.input3141v = ?2 where y.uniqueKey1 ='1' "
			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
	int updateYearTable3141u(String year, String value);
	
	
	@Transactional
	@Modifying
	@Query("update YearTable3211 y set y.input3211y =?1, y.input3211v =?2 where y.uniqueKey1 ='1' "
			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
	int updateYearTable3211u(int year, double money);
	
	@Transactional
	@Modifying
	@Query("update YearTable3221 y set y.input3221y =?1, y.input3221v =?2 where y.uniqueKey1 ='1' "
			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
	int updateYearTable3221u(String year, String value);
	
	
//	@Transactional
//	@Modifying
//	@Query("update YearTable3321 y set y.input3321y =?1, y.input3321v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
//	int updateYearTable3321u(String year, String value);
	
//	@Transactional
//	@Modifying
//	@Query("update YearTable3331 y set y.input3331y =?1, y.input3331v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
//	int updateYearTable3331u(String year, String value);
	
	
	@Transactional
	@Modifying
	@Query("update YearTable3431 y set y.input3431y =?1, y.input3431v =?2 where y.uniqueKey1 ='1' "
			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
	int updateYearTable3431u(String year, String value);
	
	
	@Transactional
	@Modifying
	@Query("update YearTable3441 y set y.input3441y =?1, y.input3441v =?2 where y.uniqueKey1 ='1' "
			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
	int updateYearTable3441u(String year, String value);
	
	@Transactional
	@Modifying
	@Query("update YearTable3451 y set y.input3451y =?1, y.input3451v =?2 where y.uniqueKey1 ='1' "
			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
	int updateYearTable3451u(String year, String value);
	
	
	@Transactional
	@Modifying
	@Query("update YearTable3461 y set y.input3461y =?1, y.input3461v =?2 where y.uniqueKey1 ='1' "
			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
	int updateYearTable3461u(String year, String value);
	
	
	
	
	
	
	
	
	
	
	@Transactional
	@Modifying
	@Query("update YearTable3521 y set y.input3521y =?1, y.input3521v =?2 where y.uniqueKey1 ='1' "
			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
	int updateYearTable3521u(String year, String value);
	
	
	@Transactional
	@Modifying
	@Query("update YearTable3711 y set y.input3711y =?1, y.input3711v =?2 where y.uniqueKey1 ='1' "
			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='university' ")
	int updateYearTable3711u(String year, String value);
	
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

