package com.adiverse.erp.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;


@Repository
public interface Criteria1Repository extends JpaRepository<Criteria1_FieldInfo, CriteriaPrimaryKey>
{
//	@Transactional
//	public int insertWithQuery(Person person) {
//	    entityManager.insertYearTable1321("INSERT INTO yeartable1321 (id, first_name, last_name) VALUES (?,?,?)")
//	      .setParameter(1, person.getId())
//	      .setParameter(2, person.getFirstName())
//	      .setParameter(3, person.getLastName())
//	      .executeUpdate();
//	}

//	@Transactional
//	@Modifying
//	@Query(value="insert into YearTable1321 (year,value_added,unique_key1,collegeId,financialYear,typeofInstitution) values (?,?,?,?,?,?)",nativeQuery = true)
//	int  insertYearTable1321( String value1, String value2,String value3,String value4,String value5,String value6);
	
// cr1 main table insert	
		@Transactional
		@Modifying
		@Query(value="insert into criteria1_fieldinfo (college_id,financial_year,typeof_institution) values (?,?,?)",nativeQuery = true)
		int  insertCriteria1Main( String value1, String value2,String value3);
// 1321 table U,Au insert	
		@Transactional
		@Modifying
		@Query(value="insert into yeartable1321 (year,value_added,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery = true)
		int  insertYearTable1321( String value1, int value2,int value3,String value4,String value5,String value6);
// 1321 table U,Au update	
		@Transactional
		@Modifying
		@Query(value="update yeartable1321  set value_added =?1 where unique_key1 =?2 ",nativeQuery=true)
		int updateYearTable1321Au(int finalValue, long uk);
//1.2.1.1 AF insert	
		@Transactional
		@Modifying
		@Query(value="insert into criteria12Qn (input1211t1,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?)",nativeQuery = true)
		int  insertCriteria12Qn( int value1,int value3,String value4,String value5,String value6 );
// 1.2.1.1 Af update	
		@Transactional
		@Modifying
		@Query(value="update criteria12Qn  set input1211t1 =?1  where unique_key1 =?2 ",nativeQuery=true)
		int updateCriteria12Qn(int courses,long uk);
	
	
//2) 1331 table U,Au Insert	
	@Transactional
	@Modifying
	@Query(value="insert into yeartable1331 (year,added_courses,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery = true)
	int  insertYearTable1331( String value1, String value2,int value3,String value4,String value5,String value6);
//1331 table U,Au Update
	@Transactional
	@Modifying
	@Query(value="update yeartable1331  set added_courses =?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateYearTable1331(BigDecimal courses, long uk);
//1221 table Af Insert
	@Transactional
	@Modifying
	@Query(value="insert into affiliated_yeartable1221 (year,subject,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery = true)
	int  insertAffiliatedYrTable1221( String value1, String value2,int value3,String value4,String value5,String value6);
//1221 table Af Update
	@Transactional
	@Modifying
	@Query(value="update affiliated_yeartable1221  set subject =?1 where unique_key1 =?2 ",nativeQuery=true)
	int updateAffiliatedYrTable1221(BigDecimal finalValue2, long uk);

//3)1341 tx U,Au Insert
	@Transactional
	@Modifying
	@Query(value="insert into criteria13Qn (input1341t1,input1341t2,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery = true)
	int  insertCriteria13Qn( String value1,String value3,int value2,String value4,String value5,String val6 );
// 1341 tx U,Au Update
	@Transactional
	@Modifying
	@Query(value="update criteria13Qn  set input1341t1 =?1,input1341t2=?2 where unique_key1 =?3 ",nativeQuery=true)
	int updateCriteria13Qn(BigDecimal finalValue, BigDecimal finalValue2,long uk);
//1321 Af
	@Transactional
	@Modifying
	@Query(value="insert into criteria13Qn (input1321t11,input1321t12,unique_key1,college_id,financial_year,typeof_institution) values (?,?,?,?,?,?)",nativeQuery = true)
	int  insertCriteria13QnAf( String value1,String value2,int value3,String value4,String value5,String val6 );
// 1341 tx U,Au Update
	@Transactional
	@Modifying
	@Query(value="update criteria13Qn  set input1321t11 =?1,input1321t12=?2 where unique_key1 =?3 ",nativeQuery=true)
	int updateCriteria13QnAf(BigDecimal Value1,BigDecimal Value2, long uk);
	
	
//	@Transactional
//	@Modifying
//	@Query("update yeartable1321 y set y.value_added = y.value_added + ?1  where y.uniqueKey1 ='1' ")
//	int updateYearTable1321(String courses);
	
//	@Transactional
//	@Modifying
//	@Query(value="insert into YearTable1331 (year,added_courses) values (?,?)",nativeQuery = true)
//	int  insertYearTable1331( String value1, String value2);
	
//	@Transactional
//	@Modifying
//	@Query("insert into YearTable1321 (input1321y,input1321v,uniqueKey1,collegeId,financialYear,typeofInstitution) "
//			+ "select inputvat5,inputvat1 from ValueAddedCourses ")
//	int  insertYearTable1321( String value1, String value2,String value3,String value4,String value5,String value6);
//	
	
	
	
//	@Transactional
//	@Modifying
//	@Query("insert into yeartable1321 (year,value_added,uniqueKey,college_id,financial_year,typeof_institution) values (?1,?2,?3,?4,?5,?6) ")
//	int  insertYearTable1321( String value1, String value2,String value3,String value4, String value5, String value6);
	
	
	
//	@Transactional
//	@Modifying
//	@Query("insert into yeartable1321 (year,value_added,uniqueKey,college_id,financial_year,typeof_institution) values (?1,?2,?3,?4,?5,?6) ")
//	int insertYearTable1321(String v1,String v2, String v3,String v4,String v5,String v6);

	
	
//1. Au,U 132  
	
//	@Transactional
//	@Modifying
//	@Query("insert into  YearTable1321  (year , value_added ,uniqueKey1 "
//			+ "college_id,financial_year,typeof_institution) values (?1,?2,?3,?4,?5,?6) ")
//	int insertYearTable1321a(String year, String value,String uniquekey1, String collegeId, String fYear, String institution);
	
//	
//	@Transactional
//	@Modifying
//	@Query("insert into  YearTable1331  set y.input1331y =?1,  y.input1331v =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId=?3 and y.criteriaId.financialYear=?4 and y.criteriaId.typeofInstitution=?5 ")
//	int insertYearTable1331(String year, String value, String collegeId, String fYear, String institution);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("insert into Criteria1_FieldInfoQn  set y.input1341t1 =?1,  where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId=?2 and y.criteriaId.financialYear=?3 and y.criteriaId.typeofInstitution=?4 ")
//	int insertCriteria1_FieldInfoQn1(String noofstudents,  String collegeId, String fYear, String institution);
	
//// 1.af 121
//	@Transactional
//	@Modifying
//	@Query("update Criteria1_FieldInfoQn y set y.input1211t1 = y.input1211t1 + ?1  where y.uniqueKey1 ='1' ")
//	int updateCriteria1_FieldInfoQn(String courses);
//	
//	
////2. Au,U 133
//	@Transactional
//	@Modifying
//	@Query("update YearTable1331 y set y.input1331y =?1, y.input1331v = ?2 where y.uniqueKey1 ='1'  ")
//	int updateYearTable1331(String year,String value );
//	
////2.Af 122	
//	@Transactional
//	@Modifying
//	@Query("update Affiliated_YearTable1221 y set y.input1221y =?1, y.input1221v = ?2 where y.uniqueKey1 ='1' ")
//	int updateAffiliated_YearTable1221(String year,String value );
//	
//	
////3.Au,U 134	
//	
//	@Transactional
//	@Modifying
//	@Query("update Criteria1_FieldInfoQn y set y.input1341t1 =?1 where y.uniqueKey1 ='1' ")
//	int updateCriteria1_FieldInfoQn1(String noofStud );
//	
//	
////3.Af 132 
//	
//	@Transactional
//	@Modifying
//	@Query("update Criteria1_FieldInfoQn y set y.input1321t11 =?1 where y.uniqueKey1 ='1' ")
//	int updateCriteria1_FieldInfoQn2(String year);
//	
//	
//	@Transactional
//	@Modifying
//	@Query("update YearTable1331 y set y.input1331y =?1, y.input1331v = ?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='universitry' ")
//	int updateYearTable1331u(String year,String value);
//	
//	@Transactional
//	@Modifying
//	@Query("update Criteria1_FieldInfoQn y set y.input1341t1 =?1, y.input1341t2 =?2 where y.uniqueKey1 ='1' "
//			+ "and y.criteriaId.collegeId='1' and y.criteriaId.financialYear='2021-2022' and y.criteriaId.typeofInstitution='universitry' ")
//	int updateCriteria1_FieldInfoQnu(String noofStud,String totalno);
//	
//	
}

