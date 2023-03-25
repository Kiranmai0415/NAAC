//package com.adiverse.erp.model;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name ="criteria3Qn_fieldinfo")
//public class Criteria3_FieldInfoQn implements Serializable {
//	
//	private static final long serialVersionUID = 1L;
//
//
//	private CriteriaPrimaryKey criteriaId;
//	
//	@Id
//    @Column(name="unique_key1")
//	private long uniqueKey1;
//	
//	
//	@Column(name = "input3131t11")
//    private String input3131t11; 
//	
////	@Column(name = "responseValue312")
////    private String response312;
//	
//	@Column(name = "input3111t1")
//    private String input3111t1;       
//	@Column(name = "responseValue311")
//    private String response311;
//	
////	
////	@Column(name = "responseValue313")
////    private String response313;
//	
////	@Column(name = "responseValue314")
////    private String response314;
////	@Column(name = "input3141t11")
////    private String input3141t11;    
////	@Column(name = "responseValue315")
////    private String response315;
////	@Column(name = "responseValue316")
////    private String response316;
////	@Column(name = "responseValue3161")
////    private String response3161;
////	
//	
//	@Column(name = "responseValue321")
//    private String response321;
//	@Column(name = "responseValue322")
//    private String response322;
//	
//	@Column(name = "input3221t11")
//    private String input3221t11;
//	
//	@Column(name = "responseValue323")
//    private String response323;
//	@Column(name = "input3231t1")
//    private String input3231t1;
//	
//	@Column(name = "input3231t2")
//    private String input3231t2;
//	@Column(name = "input3232t3")
//    private String input3232t3;
//	
//	@Column(name = "responseValue324")
//    private String response324;
//	
//	@Column(name = "responseValue332")
//    private String response332;
//
//	@Column(name = "responseValue333")
//    private String response333;
//	
//	@Column(name = "responseValue341")
//    private String response341;
//	@Column(name = "input341t1")
//    private String input341t1;
//	@Column(name = "responseValue342")
//    private String response342;
//	@Column(name = "input3421t1")
//    private String input3421t1;
//	
//	@Column(name = "input3422t1")
//    private String input3422t1;
//	
//	@Column(name = "responseValue343")
//    private String response343;
//	
//	@Column(name = "input343t1")
//    private String input343t1;
//	
//	@Column(name = "responseValue344")
//    private String response344;
//	
//	@Column(name = "input3441t1")
//    private String input3441t1;
//	
//	@Column(name = "input3442t1")
//    private String input3442t1;
//	
//	@Column(name = "input3232t2")
//    private String input3232t2;
//	
//	@Column(name = "responseValue345")
//    private String response345;
//	
//	@Column(name = "input3451t1")
//    private String input3451t1;
//	
//	@Column(name = "input3451t2")
//    private String input3451t2;
//	
//	@Column(name = "input3452t1")
//    private String input3452t1;
//	
//	@Column(name = "responseValue346")
//    private String response346;
//	@Column(name = "input3461t1")
//    private String input3461t1;
//	@Column(name = "input3461t2")
//    private String input3461t2;
//	
//	@Column(name = "responseValue347")
//    private String response347;
//	
//	@Column(name = "responseValue348")
//    private String response348;
//	@Column(name = "responseValue349")
//    private String response349;
//	
//	@Column(name = "input351t1")
//    private String input351t1;
//	
//	@Column(name = "responseValue351")
//    private String response351;
//	
//	
//	@Column(name = "responseValue352")
//    private String response352;
//	
//	@Column(name = "responseValue362")
//    private String response362;
//	@Column(name = "responseValue363")
//    private String response363;
//	@Column(name = "responseValue364")
//    private String response364;
//	
//	
//	@Column(name = "responseValue371")
//    private String response371;
//	@Column(name = "responseValue372")
//    private String response372;
//	
//	@Column(name = "input3311t1")
//    private String input3311t1;
//	
//	@Column(name = "input332t1")
//    private String input332t1;
//	
//	@Column(name = "input3491t1")
//    private String input3491t1;
//	
//	@Column(name = "input3491t2")
//    private String input3491t2;
//	
//	
//	@Column(name = "input3481t1")
//    private String input3481t1;
//	@Column(name = "input3481t2")
//    private String input3481t2;
//	
//	@Column(name = "input3482t1")
//    private String input3482t1;
//	@Column(name = "input3482t2")
//    private String input3482t2;
//	
//	
//	
//	  
//	public CriteriaPrimaryKey getCriteriaId() {
//		return criteriaId;
//	}
//	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
//		this.criteriaId = criteriaId;
//	}
//	public long getUniqueKey1() {
//		return uniqueKey1;
//	}
//	public void setUniqueKey1(long uniqueKey1) {
//		this.uniqueKey1 = uniqueKey1;
//	}
//	public String getInput3131t11() {
//		return input3131t11;
//	}
//	public void setInput3131t11(String input3131t11) {
//		this.input3131t11 = input3131t11;
//	}
//	public String getResponse312() {
//		return response312;
//	}
//	public void setResponse312(String response312) {
//		this.response312 = response312;
//	}
//	public String getInput3111t1() {
//		return input3111t1;
//	}
//	public void setInput3111t1(String input3111t1) {
//		this.input3111t1 = input3111t1;
//	}
//	public String getResponse311() {
//		return response311;
//	}
//	public void setResponse311(String response311) {
//		this.response311 = response311;
//	}
//	public String getResponse313() {
//		return response313;
//	}
//	public void setResponse313(String response313) {
//		this.response313 = response313;
//	}
//	public String getResponse314() {
//		return response314;
//	}
//	public void setResponse314(String response314) {
//		this.response314 = response314;
//	}
//	public String getInput3141t11() {
//		return input3141t11;
//	}
//	public void setInput3141t11(String input3141t11) {
//		this.input3141t11 = input3141t11;
//	}
//	public String getResponse315() {
//		return response315;
//	}
//	public void setResponse315(String response315) {
//		this.response315 = response315;
//	}
//	public String getResponse316() {
//		return response316;
//	}
//	public void setResponse316(String response316) {
//		this.response316 = response316;
//	}
//	public String getResponse3161() {
//		return response3161;
//	}
//	public void setResponse3161(String response3161) {
//		this.response3161 = response3161;
//	}
//	public String getResponse321() {
//		return response321;
//	}
//	public void setResponse321(String response321) {
//		this.response321 = response321;
//	}
//	public String getResponse322() {
//		return response322;
//	}
//	public void setResponse322(String response322) {
//		this.response322 = response322;
//	}
//	public String getInput3221t11() {
//		return input3221t11;
//	}
//	public void setInput3221t11(String input3221t11) {
//		this.input3221t11 = input3221t11;
//	}
//	public String getResponse323() {
//		return response323;
//	}
//	public void setResponse323(String response323) {
//		this.response323 = response323;
//	}
//	public String getInput3231t1() {
//		return input3231t1;
//	}
//	public void setInput3231t1(String input3231t1) {
//		this.input3231t1 = input3231t1;
//	}
//	public String getInput3231t2() {
//		return input3231t2;
//	}
//	public void setInput3231t2(String input3231t2) {
//		this.input3231t2 = input3231t2;
//	}
//	public String getInput3232t3() {
//		return input3232t3;
//	}
//	public void setInput3232t3(String input3232t3) {
//		this.input3232t3 = input3232t3;
//	}
//	public String getResponse324() {
//		return response324;
//	}
//	public void setResponse324(String response324) {
//		this.response324 = response324;
//	}
//	public String getResponse332() {
//		return response332;
//	}
//	public void setResponse332(String response332) {
//		this.response332 = response332;
//	}
//	public String getResponse333() {
//		return response333;
//	}
//	public void setResponse333(String response333) {
//		this.response333 = response333;
//	}
//	public String getResponse341() {
//		return response341;
//	}
//	public void setResponse341(String response341) {
//		this.response341 = response341;
//	}
//	public String getInput341t1() {
//		return input341t1;
//	}
//	public void setInput341t1(String input341t1) {
//		this.input341t1 = input341t1;
//	}
//	public String getResponse342() {
//		return response342;
//	}
//	public void setResponse342(String response342) {
//		this.response342 = response342;
//	}
//	public String getInput3421t1() {
//		return input3421t1;
//	}
//	public void setInput3421t1(String input3421t1) {
//		this.input3421t1 = input3421t1;
//	}
//	public String getInput3422t1() {
//		return input3422t1;
//	}
//	public void setInput3422t1(String input3422t1) {
//		this.input3422t1 = input3422t1;
//	}
//	public String getResponse343() {
//		return response343;
//	}
//	public void setResponse343(String response343) {
//		this.response343 = response343;
//	}
//	public String getInput343t1() {
//		return input343t1;
//	}
//	public void setInput343t1(String input343t1) {
//		this.input343t1 = input343t1;
//	}
//	public String getResponse344() {
//		return response344;
//	}
//	public void setResponse344(String response344) {
//		this.response344 = response344;
//	}
//	public String getInput3441t1() {
//		return input3441t1;
//	}
//	public void setInput3441t1(String input3441t1) {
//		this.input3441t1 = input3441t1;
//	}
//	public String getInput3442t1() {
//		return input3442t1;
//	}
//	public void setInput3442t1(String input3442t1) {
//		this.input3442t1 = input3442t1;
//	}
//	public String getInput3232t2() {
//		return input3232t2;
//	}
//	public void setInput3232t2(String input3232t2) {
//		this.input3232t2 = input3232t2;
//	}
//	public String getResponse345() {
//		return response345;
//	}
//	public void setResponse345(String response345) {
//		this.response345 = response345;
//	}
//	public String getInput3451t1() {
//		return input3451t1;
//	}
//	public void setInput3451t1(String input3451t1) {
//		this.input3451t1 = input3451t1;
//	}
//	public String getInput3451t2() {
//		return input3451t2;
//	}
//	public void setInput3451t2(String input3451t2) {
//		this.input3451t2 = input3451t2;
//	}
//	public String getInput3452t1() {
//		return input3452t1;
//	}
//	public void setInput3452t1(String input3452t1) {
//		this.input3452t1 = input3452t1;
//	}
//	public String getResponse346() {
//		return response346;
//	}
//	public void setResponse346(String response346) {
//		this.response346 = response346;
//	}
//	public String getInput3461t1() {
//		return input3461t1;
//	}
//	public void setInput3461t1(String input3461t1) {
//		this.input3461t1 = input3461t1;
//	}
//	public String getInput3461t2() {
//		return input3461t2;
//	}
//	public void setInput3461t2(String input3461t2) {
//		this.input3461t2 = input3461t2;
//	}
//	public String getResponse347() {
//		return response347;
//	}
//	public void setResponse347(String response347) {
//		this.response347 = response347;
//	}
//	public String getResponse348() {
//		return response348;
//	}
//	public void setResponse348(String response348) {
//		this.response348 = response348;
//	}
//	public String getResponse349() {
//		return response349;
//	}
//	public void setResponse349(String response349) {
//		this.response349 = response349;
//	}
//	public String getInput351t1() {
//		return input351t1;
//	}
//	public void setInput351t1(String input351t1) {
//		this.input351t1 = input351t1;
//	}
//	public String getResponse351() {
//		return response351;
//	}
//	public void setResponse351(String response351) {
//		this.response351 = response351;
//	}
//	public String getResponse352() {
//		return response352;
//	}
//	public void setResponse352(String response352) {
//		this.response352 = response352;
//	}
//	public String getResponse362() {
//		return response362;
//	}
//	public void setResponse362(String response362) {
//		this.response362 = response362;
//	}
//	public String getResponse363() {
//		return response363;
//	}
//	public void setResponse363(String response363) {
//		this.response363 = response363;
//	}
//	public String getResponse364() {
//		return response364;
//	}
//	public void setResponse364(String response364) {
//		this.response364 = response364;
//	}
//	public String getResponse371() {
//		return response371;
//	}
//	public void setResponse371(String response371) {
//		this.response371 = response371;
//	}
//	public String getResponse372() {
//		return response372;
//	}
//	public void setResponse372(String response372) {
//		this.response372 = response372;
//	}
//	public String getInput3311t1() {
//		return input3311t1;
//	}
//	public void setInput3311t1(String input3311t1) {
//		this.input3311t1 = input3311t1;
//	}
//	public String getInput332t1() {
//		return input332t1;
//	}
//	public void setInput332t1(String input332t1) {
//		this.input332t1 = input332t1;
//	}
//	public String getInput3491t1() {
//		return input3491t1;
//	}
//	public void setInput3491t1(String input3491t1) {
//		this.input3491t1 = input3491t1;
//	}
//	public String getInput3491t2() {
//		return input3491t2;
//	}
//	public void setInput3491t2(String input3491t2) {
//		this.input3491t2 = input3491t2;
//	}
//	public String getInput3481t1() {
//		return input3481t1;
//	}
//	public void setInput3481t1(String input3481t1) {
//		this.input3481t1 = input3481t1;
//	}
//	public String getInput3481t2() {
//		return input3481t2;
//	}
//	public void setInput3481t2(String input3481t2) {
//		this.input3481t2 = input3481t2;
//	}
//	public String getInput3482t1() {
//		return input3482t1;
//	}
//	public void setInput3482t1(String input3482t1) {
//		this.input3482t1 = input3482t1;
//	}
//	public String getInput3482t2() {
//		return input3482t2;
//	}
//	public void setInput3482t2(String input3482t2) {
//		this.input3482t2 = input3482t2;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(criteriaId, input3111t1, input3131t11, input3141t11, input3221t11, input3231t1, input3231t2,
//				input3232t2, input3232t3, input3311t1, input332t1, input341t1, input3421t1, input3422t1, input343t1,
//				input3441t1, input3442t1, input3451t1, input3451t2, input3452t1, input3461t1, input3461t2, input3481t1,
//				input3481t2, input3482t1, input3482t2, input3491t1, input3491t2, input351t1, response311, response312,
//				response313, response314, response315, response316, response3161, response321, response322, response323,
//				response324, response332, response333, response341, response342, response343, response344, response345,
//				response346, response347, response348, response349, response351, response352, response362, response363,
//				response364, response371, response372, uniqueKey1);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Criteria3_FieldInfoQn other = (Criteria3_FieldInfoQn) obj;
//		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3111t1, other.input3111t1)
//				&& Objects.equals(input3131t11, other.input3131t11) && Objects.equals(input3141t11, other.input3141t11)
//				&& Objects.equals(input3221t11, other.input3221t11) && Objects.equals(input3231t1, other.input3231t1)
//				&& Objects.equals(input3231t2, other.input3231t2) && Objects.equals(input3232t2, other.input3232t2)
//				&& Objects.equals(input3232t3, other.input3232t3) && Objects.equals(input3311t1, other.input3311t1)
//				&& Objects.equals(input332t1, other.input332t1) && Objects.equals(input341t1, other.input341t1)
//				&& Objects.equals(input3421t1, other.input3421t1) && Objects.equals(input3422t1, other.input3422t1)
//				&& Objects.equals(input343t1, other.input343t1) && Objects.equals(input3441t1, other.input3441t1)
//				&& Objects.equals(input3442t1, other.input3442t1) && Objects.equals(input3451t1, other.input3451t1)
//				&& Objects.equals(input3451t2, other.input3451t2) && Objects.equals(input3452t1, other.input3452t1)
//				&& Objects.equals(input3461t1, other.input3461t1) && Objects.equals(input3461t2, other.input3461t2)
//				&& Objects.equals(input3481t1, other.input3481t1) && Objects.equals(input3481t2, other.input3481t2)
//				&& Objects.equals(input3482t1, other.input3482t1) && Objects.equals(input3482t2, other.input3482t2)
//				&& Objects.equals(input3491t1, other.input3491t1) && Objects.equals(input3491t2, other.input3491t2)
//				&& Objects.equals(input351t1, other.input351t1) && Objects.equals(response311, other.response311)
//				&& Objects.equals(response312, other.response312) && Objects.equals(response313, other.response313)
//				&& Objects.equals(response314, other.response314) && Objects.equals(response315, other.response315)
//				&& Objects.equals(response316, other.response316) && Objects.equals(response3161, other.response3161)
//				&& Objects.equals(response321, other.response321) && Objects.equals(response322, other.response322)
//				&& Objects.equals(response323, other.response323) && Objects.equals(response324, other.response324)
//				&& Objects.equals(response332, other.response332) && Objects.equals(response333, other.response333)
//				&& Objects.equals(response341, other.response341) && Objects.equals(response342, other.response342)
//				&& Objects.equals(response343, other.response343) && Objects.equals(response344, other.response344)
//				&& Objects.equals(response345, other.response345) && Objects.equals(response346, other.response346)
//				&& Objects.equals(response347, other.response347) && Objects.equals(response348, other.response348)
//				&& Objects.equals(response349, other.response349) && Objects.equals(response351, other.response351)
//				&& Objects.equals(response352, other.response352) && Objects.equals(response362, other.response362)
//				&& Objects.equals(response363, other.response363) && Objects.equals(response364, other.response364)
//				&& Objects.equals(response371, other.response371) && Objects.equals(response372, other.response372)
//				&& uniqueKey1 == other.uniqueKey1;
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
