import React, { useState , useEffect } from "react";
import { toast } from "react-toastify";
import "./AcademicInfo-style.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import { resources } from "../../../../appConstants";

// Alert custom messages start
const successMessage = (message) => {
  toast.success(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "success1",
    className: "success",
  });
};
const errorMessage = (message) => {
  toast.error(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "error1",
    className: "error",
  });
};
// End here

function AccademicInfo() {
  const [valuead11, setValuead11] = useState("");
  const [valuead12, setValuead12] = useState("");
  const [valuead13, setValuead13] = useState("");

  const [valuead21, setValuead21] = useState("");
  const [valuead22, setValuead22] = useState("");
  const [valuead23, setValuead23] = useState("");
  const [valuead24, setValuead24] = useState("");

  const [valuead31, setValuead31] = useState("");
  const [valuead32, setValuead32] = useState("");
  const [valuead33, setValuead33] = useState("");
  const [valuead34, setValuead34] = useState("");

  const [valuead41, setValuead41] = useState("");
  const [valuead42, setValuead42] = useState("");
  const [valuead43, setValuead43] = useState("");
  const [valuead44, setValuead44] = useState("");

  const [valuead1, setValuead1] = useState("");
  const [valuead2, setValuead2] = useState("");
  const [valuead3, setValuead3] = useState("");
  const [valuead4, setValuead4] = useState("");
  const [valuead5, setValuead5] = useState("");
  const [valuead6, setValuead6] = useState("");
  const [valuead7, setValuead7] = useState("");
  const [valuead8, setValuead8] = useState("");
  const [valuead9, setValuead9] = useState("");
  const [valuead10, setValuead10] = useState("");
  const [valuead111, setValuead111] = useState("");

  const [valueat11, setValueat11] = useState("");
  const [valueat12, setValueat12] = useState("");
  const [valueat13, setValueat13] = useState("");
  const [valueat14, setValueat14] = useState("");
  const [valueat15, setValueat15] = useState("");
  const [valueat16, setValueat16] = useState("");
  const [valueat17, setValueat17] = useState("");
  const [valueat18, setValueat18] = useState("");
  const [valueat19, setValueat19] = useState("");
  const [valueat110, setValueat110] = useState("");

  const [valueat21, setValueat21] = useState("");
  const [valueat22, setValueat22] = useState("");
  const [valueat23, setValueat23] = useState("");
  const [valueat24, setValueat24] = useState("");
  const [valueat25, setValueat25] = useState("");
  const [valueat26, setValueat26] = useState("");
  const [valueat27, setValueat27] = useState("");
  const [valueat28, setValueat28] = useState("");
  const [valueat29, setValueat29] = useState("");
  const [valueat210, setValueat210] = useState("");

  const [valueat31, setValueat31] = useState("");
  const [valueat32, setValueat32] = useState("");
  const [valueat33, setValueat33] = useState("");
  const [valueat34, setValueat34] = useState("");
  const [valueat35, setValueat35] = useState("");
  const [valueat36, setValueat36] = useState("");
  const [valueat37, setValueat37] = useState("");
  const [valueat38, setValueat38] = useState("");
  const [valueat39, setValueat39] = useState("");
  const [valueat310, setValueat310] = useState("");

  const [valueat41, setValueat41] = useState("");
  const [valueat42, setValueat42] = useState("");
  const [valueat43, setValueat43] = useState("");
  const [valueat44, setValueat44] = useState("");
  const [valueat45, setValueat45] = useState("");
  const [valueat46, setValueat46] = useState("");
  const [valueat47, setValueat47] = useState("");
  const [valueat48, setValueat48] = useState("");
  const [valueat49, setValueat49] = useState("");
  const [valueat410, setValueat410] = useState("");

  const [valueat51, setValueat51] = useState("");
  const [valueat52, setValueat52] = useState("");
  const [valueat53, setValueat53] = useState("");
  const [valueat54, setValueat54] = useState("");
  const [valueat55, setValueat55] = useState("");
  const [valueat56, setValueat56] = useState("");
  const [valueat57, setValueat57] = useState("");
  const [valueat58, setValueat58] = useState("");
  const [valueat59, setValueat59] = useState("");
  const [valueat510, setValueat510] = useState("");

  const [valueat61, setValueat61] = useState("");
  const [valueat62, setValueat62] = useState("");
  const [valueat63, setValueat63] = useState("");
  const [valueat64, setValueat64] = useState("");
  const [valueat65, setValueat65] = useState("");
  const [valueat66, setValueat66] = useState("");
  const [valueat67, setValueat67] = useState("");
  const [valueat68, setValueat68] = useState("");
  const [valueat69, setValueat69] = useState("");
  const [valueat610, setValueat610] = useState("");

  const [valueat71, setValueat71] = useState("");
  const [valueat72, setValueat72] = useState("");
  const [valueat73, setValueat73] = useState("");
  const [valueat74, setValueat74] = useState("");
  const [valueat75, setValueat75] = useState("");
  const [valueat76, setValueat76] = useState("");
  const [valueat77, setValueat77] = useState("");
  const [valueat78, setValueat78] = useState("");
  const [valueat79, setValueat79] = useState("");
  const [valueat710, setValueat710] = useState("");

  const [valueat81, setValueat81] = useState("");
  const [valueat82, setValueat82] = useState("");
  const [valueat83, setValueat83] = useState("");
  const [valueat84, setValueat84] = useState("");
  const [valueat85, setValueat85] = useState("");
  const [valueat86, setValueat86] = useState("");
  const [valueat87, setValueat87] = useState("");
  const [valueat88, setValueat88] = useState("");
  const [valueat89, setValueat89] = useState("");
  const [valueat810, setValueat810] = useState("");

  const [valueat91, setValueat91] = useState("");
  const [valueat92, setValueat92] = useState("");
  const [valueat93, setValueat93] = useState("");
  const [valueat94, setValueat94] = useState("");
  const [valueat95, setValueat95] = useState("");
  const [valueat96, setValueat96] = useState("");
  const [valueat97, setValueat97] = useState("");
  const [valueat98, setValueat98] = useState("");
  const [valueat99, setValueat99] = useState("");
  const [valueat910, setValueat910] = useState("");

  const [valueat101, setValueat101] = useState("");
  const [valueat102, setValueat102] = useState("");
  const [valueat103, setValueat103] = useState("");
  const [valueat104, setValueat104] = useState("");
  const [valueat105, setValueat105] = useState("");
  const [valueat106, setValueat106] = useState("");
  const [valueat107, setValueat107] = useState("");
  const [valueat108, setValueat108] = useState("");
  const [valueat109, setValueat109] = useState("");
  const [valueat1010, setValueat1010] = useState("");

  const [valueat111, setValueat111] = useState("");
  const [valueat112, setValueat112] = useState("");
  const [valueat113, setValueat113] = useState("");
  const [valueat114, setValueat114] = useState("");
  const [valueat115, setValueat115] = useState("");
  const [valueat116, setValueat116] = useState("");
  const [valueat117, setValueat117] = useState("");
  const [valueat118, setValueat118] = useState("");
  const [valueat119, setValueat119] = useState("");
  const [valueat1110, setValueat1110] = useState("");

  const [valueat121, setValueat121] = useState("");
  const [valueat122, setValueat122] = useState("");
  const [valueat123, setValueat123] = useState("");
  const [valueat124, setValueat124] = useState("");
  const [valueat125, setValueat125] = useState("");
  const [valueat126, setValueat126] = useState("");
  const [valueat127, setValueat127] = useState("");
  const [valueat128, setValueat128] = useState("");
  const [valueat129, setValueat129] = useState("");
  const [valueat1210, setValueat1210] = useState("");

  const [valueatnt11, setValueatnt11] = useState("");
  const [valueatnt12, setValueatnt12] = useState("");
  const [valueatnt13, setValueatnt13] = useState("");
  const [valueatnt14, setValueatnt14] = useState("");

  const [valueatnt21, setValueatnt21] = useState("");
  const [valueatnt22, setValueatnt22] = useState("");
  const [valueatnt23, setValueatnt23] = useState("");
  const [valueatnt24, setValueatnt24] = useState("");

  const [valueatnt31, setValueatnt31] = useState("");
  const [valueatnt32, setValueatnt32] = useState("");
  const [valueatnt33, setValueatnt33] = useState("");
  const [valueatnt34, setValueatnt34] = useState("");

  const [valueatnt41, setValueatnt41] = useState("");
  const [valueatnt42, setValueatnt42] = useState("");
  const [valueatnt43, setValueatnt43] = useState("");
  const [valueatnt44, setValueatnt44] = useState("");

  const [valueatt11, setValueatt11] = useState("");
  const [valueatt12, setValueatt12] = useState("");
  const [valueatt13, setValueatt13] = useState("");
  const [valueatt14, setValueatt14] = useState("");

  const [valueatt21, setValueatt21] = useState("");
  const [valueatt22, setValueatt22] = useState("");
  const [valueatt23, setValueatt23] = useState("");
  const [valueatt24, setValueatt24] = useState("");

  const [valueatt31, setValueatt31] = useState("");
  const [valueatt32, setValueatt32] = useState("");
  const [valueatt33, setValueatt33] = useState("");
  const [valueatt34, setValueatt34] = useState("");

  const [valueatt41, setValueatt41] = useState("");
  const [valueatt42, setValueatt42] = useState("");
  const [valueatt43, setValueatt43] = useState("");
  const [valueatt44, setValueatt44] = useState("");

  const [valueatq11, setValueatq11] = useState("");
  const [valueatq12, setValueatq12] = useState("");
  const [valueatq13, setValueatq13] = useState("");
  const [valueatq14, setValueatq14] = useState("");
  const [valueatq15, setValueatq15] = useState("");
  const [valueatq16, setValueatq16] = useState("");
  const [valueatq17, setValueatq17] = useState("");
  const [valueatq18, setValueatq18] = useState("");
  const [valueatq19, setValueatq19] = useState("");
  const [valueatq110, setValueatq110] = useState("");
  const [valueatq111, setValueatq111] = useState("");
  const [valueatq112, setValueatq112] = useState("");

  const [valueatq21, setValueatq21] = useState("");
  const [valueatq22, setValueatq22] = useState("");
  const [valueatq23, setValueatq23] = useState("");
  const [valueatq24, setValueatq24] = useState("");
  const [valueatq25, setValueatq25] = useState("");
  const [valueatq26, setValueatq26] = useState("");
  const [valueatq27, setValueatq27] = useState("");
  const [valueatq28, setValueatq28] = useState("");
  const [valueatq29, setValueatq29] = useState("");
  const [valueatq210, setValueatq210] = useState("");
  const [valueatq211, setValueatq211] = useState("");
  const [valueatq212, setValueatq212] = useState("");

  const [valueatq31, setValueatq31] = useState("");
  const [valueatq32, setValueatq32] = useState("");
  const [valueatq33, setValueatq33] = useState("");
  const [valueatq34, setValueatq34] = useState("");
  const [valueatq35, setValueatq35] = useState("");
  const [valueatq36, setValueatq36] = useState("");
  const [valueatq37, setValueatq37] = useState("");
  const [valueatq38, setValueatq38] = useState("");
  const [valueatq39, setValueatq39] = useState("");
  const [valueatq310, setValueatq310] = useState("");
  const [valueatq311, setValueatq311] = useState("");
  const [valueatq312, setValueatq312] = useState("");

  const [valueatq41, setValueatq41] = useState("");
  const [valueatq42, setValueatq42] = useState("");
  const [valueatq43, setValueatq43] = useState("");
  const [valueatq44, setValueatq44] = useState("");
  const [valueatq45, setValueatq45] = useState("");
  const [valueatq46, setValueatq46] = useState("");
  const [valueatq47, setValueatq47] = useState("");
  const [valueatq48, setValueatq48] = useState("");
  const [valueatq49, setValueatq49] = useState("");
  const [valueatq410, setValueatq410] = useState("");
  const [valueatq411, setValueatq411] = useState("");
  const [valueatq412, setValueatq412] = useState("");

  const [valueatg1, setValueatg1] = useState("");
  const [valueatg2, setValueatg2] = useState("");
  const [valueatg3, setValueatg3] = useState("");
  const [valueatg4, setValueatg4] = useState("");

  const [valueatg21, setValueatg21] = useState("");
  const [valueatg22, setValueatg22] = useState("");
  const [valueatg23, setValueatg23] = useState("");
  const [valueatg24, setValueatg24] = useState("");

  const [valueatg31, setValueatg31] = useState("");
  const [valueatg32, setValueatg32] = useState("");
  const [valueatg33, setValueatg33] = useState("");
  const [valueatg34, setValueatg34] = useState("");

  const [valueatc11, setValueatc11] = useState("");
  const [valueatc12, setValueatc12] = useState("");
  const [valueatc13, setValueatc13] = useState("");
  const [valueatc14, setValueatc14] = useState("");

  const [valueas11, setValueas11] = useState("");
  const [valueas12, setValueas12] = useState("");
  const [valueas13, setValueas13] = useState("");
  const [valueas14, setValueas14] = useState("");
  const [valueas15, setValueas15] = useState("");

  const [valueas21, setValueas21] = useState("");
  const [valueas22, setValueas22] = useState("");
  const [valueas23, setValueas23] = useState("");
  const [valueas24, setValueas24] = useState("");
  const [valueas25, setValueas25] = useState("");

  const [valueas31, setValueas31] = useState("");
  const [valueas32, setValueas32] = useState("");
  const [valueas33, setValueas33] = useState("");
  const [valueas34, setValueas34] = useState("");
  const [valueas35, setValueas35] = useState("");

  const [valueas41, setValueas41] = useState("");
  const [valueas42, setValueas42] = useState("");
  const [valueas43, setValueas43] = useState("");
  const [valueas44, setValueas44] = useState("");
  const [valueas45, setValueas45] = useState("");

  const [valueas51, setValueas51] = useState("");
  const [valueas52, setValueas52] = useState("");
  const [valueas53, setValueas53] = useState("");
  const [valueas54, setValueas54] = useState("");
  const [valueas55, setValueas55] = useState("");

  const [valueas61, setValueas61] = useState("");
  const [valueas62, setValueas62] = useState("");
  const [valueas63, setValueas63] = useState("");
  const [valueas64, setValueas64] = useState("");
  const [valueas65, setValueas65] = useState("");

  const [valueas71, setValueas71] = useState("");
  const [valueas72, setValueas72] = useState("");
  const [valueas73, setValueas73] = useState("");
  const [valueas74, setValueas74] = useState("");
  const [valueas75, setValueas75] = useState("");

  const [valueas81, setValueas81] = useState("");
  const [valueas82, setValueas82] = useState("");
  const [valueas83, setValueas83] = useState("");
  const [valueas84, setValueas84] = useState("");
  const [valueas85, setValueas85] = useState("");

  const [valueas91, setValueas91] = useState("");
  const [valueas92, setValueas92] = useState("");
  const [valueas93, setValueas93] = useState("");
  const [valueas94, setValueas94] = useState("");
  const [valueas95, setValueas95] = useState("");

  const [valueu1, setValueu1] = useState("");
  const [valueu2, setValueu2] = useState("");

  // const [valueaa11, setValueaa11] = useState("");
  // const [valueaa12, setValueaa12] = useState("");
  // const [valueaa13, setValueaa13] = useState("");
  // const [valueaa14, setValueaa14] = useState("");

  // const [valueaa21, setValueaa21] = useState("");
  // const [valueaa22, setValueaa22] = useState("");
  // const [valueaa23, setValueaa23] = useState("");
  // const [valueaa24, setValueaa24] = useState("");

  // const [valueaa31, setValueaa31] = useState("");
  // const [valueaa32, setValueaa32] = useState("");
  // const [valueaa33, setValueaa33] = useState("");
  // const [valueaa34, setValueaa34] = useState("");

  // const [valueaa41, setValueaa41] = useState("");
  // const [valueaa42, setValueaa42] = useState("");
  // const [valueaa43, setValueaa43] = useState("");
  // const [valueaa44, setValueaa44] = useState("");

  // const [valueaa51, setValueaa51] = useState("");
  // const [valueaa52, setValueaa52] = useState("");
  // const [valueaa53, setValueaa53] = useState("");
  // const [valueaa54, setValueaa54] = useState("");

  // const [valueaa61, setValueaa61] = useState("");
  // const [valueaa62, setValueaa62] = useState("");
  // const [valueaa63, setValueaa63] = useState("");
  // const [valueaa64, setValueaa64] = useState("");

  // const [valueaa71, setValueaa71] = useState("");
  // const [valueaa72, setValueaa72] = useState("");
  // const [valueaa73, setValueaa73] = useState("");
  // const [valueaa74, setValueaa74] = useState("");

  // const [valueaa81, setValueaa81] = useState("");
  // const [valueaa82, setValueaa82] = useState("");
  // const [valueaa83, setValueaa83] = useState("");
  // const [valueaa84, setValueaa84] = useState("");

  // const [valueaa91, setValueaa91] = useState("");
  // const [valueaa92, setValueaa92] = useState("");
  // const [valueaa93, setValueaa93] = useState("");
  // const [valueaa94, setValueaa94] = useState("");

  // const [valueaa101, setValueaa101] = useState("");
  // const [valueaa102, setValueaa102] = useState("");
  // const [valueaa103, setValueaa103] = useState("");
  // const [valueaa104, setValueaa104] = useState("");

  // const [valueaa111, setValueaa111] = useState("");
  // const [valueaa112, setValueaa112] = useState("");
  // const [valueaa113, setValueaa113] = useState("");
  // const [valueaa114, setValueaa114] = useState("");

  // const [valueaa121, setValueaa121] = useState("");
  // const [valueaa122, setValueaa122] = useState("");
  // const [valueaa123, setValueaa123] = useState("");
  // const [valueaa124, setValueaa124] = useState("");

  // const [valueaa131, setValueaa131] = useState("");
  // const [valueaa132, setValueaa132] = useState("");
  // const [valueaa133, setValueaa133] = useState("");
  // const [valueaa134, setValueaa134] = useState("");

  // const [valueaa141, setValueaa141] = useState("");
  // const [valueaa142, setValueaa142] = useState("");
  // const [valueaa143, setValueaa143] = useState("");
  // const [valueaa144, setValueaa144] = useState("");

  // const [valueaa151, setValueaa151] = useState("");
  // const [valueaa152, setValueaa152] = useState("");
  // const [valueaa153, setValueaa153] = useState("");
  // const [valueaa154, setValueaa154] = useState("");

  // const [valueaa161, setValueaa161] = useState("");
  // const [valueaa162, setValueaa162] = useState("");
  // const [valueaa163, setValueaa163] = useState("");
  // const [valueaa164, setValueaa164] = useState("");
  // const [valueaa165, setValueaa165] = useState("");

  const [valuei11, setValuei11] = useState("");
  const [valuei12, setValuei12] = useState("");
  const [valuei13, setValuei13] = useState("");
  const [valuei14, setValuei14] = useState("");
  const [valuei15, setValuei15] = useState("");

  const [valuei21, setValuei21] = useState("");
  const [valuei22, setValuei22] = useState("");
  const [valuei23, setValuei23] = useState("");
  const [valuei24, setValuei24] = useState("");
  const [valuei25, setValuei25] = useState("");

  const [valuei31, setValuei31] = useState("");
  const [valuei32, setValuei32] = useState("");
  const [valuei33, setValuei33] = useState("");
  const [valuei34, setValuei34] = useState("");
  const [valuei35, setValuei35] = useState("");

  const [valued11, setValued11] = useState("");
  const [valued12, setValued12] = useState("");
  const [valued13, setValued13] = useState("");
  const [valued14, setValued14] = useState("");
  const [valued15, setValued15] = useState("");


  console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
let instituteType = AuthService.getCurrentUser().instituteType;
console.log("instituteType=======>" + instituteType);
const collegeId = AuthService.getCurrentUser().collegeId;
console.log("eamcetCode==========>" + collegeId);
const d = new Date();
let currYear = d.getFullYear();
console.log("var ==>" + currYear);
let fYear = parseInt(currYear) - 1 + "-" + currYear;
console.log("current year==" + fYear);


  // get data
  const financialYear="2021-2022";
  useEffect(
    () => fetch('http://localhost:8080/api/v1/getallacademicdata?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));

          //
          setValuead11(data[0].auniversityAffiliated[0] ? data[0].auniversityAffiliated[0].inputa1t1 : "");
          setValuead12(data[0].auniversityAffiliated[0] ? data[0].auniversityAffiliated[0].inputa1t2 : "");
          setValuead13(data[0].auniversityAffiliated[0] ? data[0].auniversityAffiliated[0].inputa1t3 : "");

          setValuead21(data[0].auniversityAffiliated1[0] ? data[0].auniversityAffiliated[0].inputa2t1 : "");
          setValuead22(data[0].auniversityAffiliated1[0] ? data[0].auniversityAffiliated[0].inputa2t2 : "");
          setValuead23(data[0].auniversityAffiliated1[0] ? data[0].auniversityAffiliated[0].inputa2t3 : "");
          setValuead24(data[0].auniversityAffiliated1[0] ? data[0].auniversityAffiliated1[0].inputa2t4 : "");

          setValuead31(data[0].auniversityAffiliated1[1] ? data[0].auniversityAffiliated1[1].inputa2t1 : "");
          setValuead32(data[0].auniversityAffiliated1[1] ? data[0].auniversityAffiliated1[1].inputa2t2 : "");
          setValuead33(data[0].auniversityAffiliated1[1] ? data[0].auniversityAffiliated1[1].inputa2t3 : "");
          setValuead34(data[0].auniversityAffiliated1[1] ? data[0].auniversityAffiliated1[1].inputa2t4 : "");

          setValuead41(data[0].auniversityAffiliated1[2] ? data[0].auniversityAffiliated1[2].inputa2t1 : "");
          setValuead42(data[0].auniversityAffiliated1[2] ? data[0].auniversityAffiliated1[2].inputa2t2 : "");
          setValuead43(data[0].auniversityAffiliated1[2] ? data[0].auniversityAffiliated1[2].inputa2t3 : "");
          setValuead44(data[0].auniversityAffiliated1[2] ? data[0].auniversityAffiliated1[2].inputa2t4 : "");

          setValuead1(data[0].universityColleges[0] ? data[0].universityColleges[0].inputa3t1 : "");
          setValuead2(data[0].universityColleges[0] ? data[0].universityColleges[0].inputa3t2 : "");
          setValuead3(data[0].universityColleges[0] ? data[0].universityColleges[0].inputa3t3 : "");
          setValuead4(data[0].universityColleges[0] ? data[0].universityColleges[0].inputa3t4 : "");
          setValuead5(data[0].universityColleges[0] ? data[0].universityColleges[0].inputa3t5 : "");
          setValuead6(data[0].universityColleges[0] ? data[0].universityColleges[0].inputa3t6 : "");
          setValuead7(data[0].universityColleges[0] ? data[0].universityColleges[0].inputa3t7 : "");
          setValuead8(data[0].universityColleges[0] ? data[0].universityColleges[0].inputa3t8 : "");
          setValuead9(data[0].universityColleges[0] ? data[0].universityColleges[0].inputa3t9 : "");
          setValuead10(data[0].universityColleges[0] ? data[0].universityColleges[0].inputa3t10 : "");
          setValuead111(data[0].universityColleges[0] ? data[0].universityColleges[0].inputa3t11 : "");

          //
          setValueatq11(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat11 : "");
          setValueatq12(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat12 : "");
          setValueatq13(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat13 : "");
          setValueatq14(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat14 : "");
          setValueatq15(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat15 : "");
          setValueatq16(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat16 : "");
          setValueatq17(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat17 : "");
          setValueatq18(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat18 : "");
          setValueatq19(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat19 : "");
          setValueatq110(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat10 : "");
          setValueatq111(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat111 : "");
          setValueatq112(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat112 : "");

          setValueatq21(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat11 : "");
          setValueatq22(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat12 : "");
          setValueatq23(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat13 : "");
          setValueatq24(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat14 : "");
          setValueatq25(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat15 : "");
          setValueatq26(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat16 : "");
          setValueatq27(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat17 : "");
          setValueatq28(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat18 : "");
          setValueatq29(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat19 : "");
          setValueatq210(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat10 : "");
          setValueatq211(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat111 : "");
          setValueatq212(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat112 : "");

          setValueatq31(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat11 : "");
          setValueatq32(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat12 : "");
          setValueatq33(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputa1t3 : "");
          setValueatq34(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat14 : "");
          setValueatq35(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat15 : "");
          setValueatq36(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat16 : "");
          setValueatq37(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat17 : "");
          setValueatq38(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat18 : "");
          setValueatq39(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat19 : "");
          setValueatq310(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat10 : "");
          setValueatq311(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat111 : "");
          setValueatq312(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat112 : "");

          setValueatq41(data[0].academicinstitution[3] ? data[0].academicinstitution[3].inputat11 : "");
          setValueatq42(data[0].academicinstitution[3] ? data[0].academicinstitution[3].inputat12 : "");
          setValueatq43(data[0].academicinstitution[3] ? data[0].academicinstitution[3].inputat13 : "");
          setValueatq44(data[0].academicinstitution[3] ? data[0].academicinstitution[3].inputat14 : "");
          setValueatq45(data[0].academicinstitution[3] ? data[0].academicinstitution[3].inputat15 : "");
          setValueatq46(data[0].academicinstitution[3] ? data[0].academicinstitution[3].inputat16 : "");
          setValueatq47(data[0].academicinstitution[3] ? data[0].academicinstitution[3].inputat17 : "");
          setValueatq48(data[0].academicinstitution[3] ? data[0].academicinstitution[3].inputat18 : "");
          setValueatq49(data[0].academicinstitution[3] ? data[0].academicinstitution[3].inputat19 : "");
          setValueatq410(data[0].academicinstitution[3] ? data[0].academicinstitution[3].inputat10 : "");
          setValueatq411(data[0].academicinstitution[3] ? data[0].academicinstitution[3].inputat111 : "");
          setValueatq412(data[0].academicinstitution[3] ? data[0].academicinstitution[3].inputat112 : "");

          setValueatnt11(data[0].nonTeachingStaff[0] ? data[0].nonTeachingStaff[0].inputatnt11 : "");
          setValueatnt12(data[0].nonTeachingStaff[0] ? data[0].nonTeachingStaff[0].inputatnt12 : "");
          setValueatnt13(data[0].nonTeachingStaff[0] ? data[0].nonTeachingStaff[0].inputatnt13 : "");
          setValueatnt14(data[0].nonTeachingStaff[0] ? data[0].nonTeachingStaff[0].inputatnt14 : "");

          setValueatnt21(data[0].nonTeachingStaff[1] ? data[0].nonTeachingStaff[1].inputatnt11 : "");
          setValueatnt22(data[0].nonTeachingStaff[1] ? data[0].nonTeachingStaff[1].inputatnt12 : "");
          setValueatnt23(data[0].nonTeachingStaff[1] ? data[0].nonTeachingStaff[1].inputatnt13 : "");
          setValueatnt24(data[0].nonTeachingStaff[1] ? data[0].nonTeachingStaff[1].inputatnt14 : "");

           setValueatnt31(data[0].nonTeachingStaff[2] ? data[0].nonTeachingStaff[2].inputatnt11 : "");
          setValueatnt32(data[0].nonTeachingStaff[2] ? data[0].nonTeachingStaff[2].inputatnt12 : "");
          setValueatnt33(data[0].nonTeachingStaff[2] ? data[0].nonTeachingStaff[2].inputatnt13 : "");
          setValueatnt34(data[0].nonTeachingStaff[2] ? data[0].nonTeachingStaff[2].inputatnt14 : "");

          setValueatnt41(data[0].nonTeachingStaff[3] ? data[0].nonTeachingStaff[3].inputatnt11 : "");
          setValueatnt42(data[0].nonTeachingStaff[3] ? data[0].nonTeachingStaff[3].inputatnt12 : "");
          setValueatnt43(data[0].nonTeachingStaff[3] ? data[0].nonTeachingStaff[3].inputatnt13 : "");
          setValueatnt44(data[0].nonTeachingStaff[3] ? data[0].nonTeachingStaff[3].inputatnt14 : "");


          setValueatt11(data[0].technicalStaff[0] ? data[0].technicalStaff[0].inputatt15 : "");
          setValueatt12(data[0].technicalStaff[0] ? data[0].technicalStaff[0].inputatt16 : "");
          setValueatt13(data[0].technicalStaff[0] ? data[0].technicalStaff[0].inputatt17 : "");
          setValueatt14(data[0].technicalStaff[0] ? data[0].technicalStaff[0].inputatt18 : "");

          setValueatt21(data[0].technicalStaff[1] ? data[0].technicalStaff[1].inputatt15 : "");
          setValueatt22(data[0].technicalStaff[1] ? data[0].technicalStaff[1].inputatt16 : "");
          setValueatt23(data[0].technicalStaff[1] ? data[0].technicalStaff[1].inputatt17 : "");
          setValueatt24(data[0].technicalStaff[1] ? data[0].technicalStaff[1].inputatt18 : "");

          setValueatt31(data[0].technicalStaff[2] ? data[0].technicalStaff[2].inputatt15 : "");
          setValueatt32(data[0].technicalStaff[2] ? data[0].technicalStaff[2].inputatt16 : "");
          setValueatt33(data[0].technicalStaff[2] ? data[0].technicalStaff[2].inputatt17 : "");
          setValueatt34(data[0].technicalStaff[2] ? data[0].technicalStaff[2].inputatt18 : "");

          setValueatt41(data[0].technicalStaff[3] ? data[0].technicalStaff[3].inputatt15 : "");
          setValueatt42(data[0].technicalStaff[3] ? data[0].technicalStaff[3].inputatt16 : "");
          setValueatt43(data[0].technicalStaff[3] ? data[0].technicalStaff[3].inputatt17 : "");
          setValueatt44(data[0].technicalStaff[3] ? data[0].technicalStaff[3].inputatt18 : "");

          //
          setValueat11(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq11 : "");
          setValueat12(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq12 : "");
          setValueat13(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq13 : "");
          setValueat14(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq14 : "");
          setValueat15(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq15 : "");
          setValueat16(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq16 : "");
          setValueat17(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq17 : "");
          setValueat18(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq18 : "");
          setValueat19(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq19 : "");
          setValueat110(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq110 : "");

          setValueat21(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq11 : "");
          setValueat22(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq12 : "");
          setValueat23(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq13 : "");
          setValueat24(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq14 : "");
          setValueat25(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq15 : "");
          setValueat26(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq16 : "");
          setValueat27(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq17 : "");
          setValueat28(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq18 : "");
          setValueat29(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq19 : "");
          setValueat210(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq110 : "");

          setValueat31(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq11 : "");
          setValueat32(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq12 : "");
          setValueat33(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq13 : "");
          setValueat34(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq14 : "");
          setValueat35(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq15 : "");
          setValueat36(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq16 : "");
          setValueat37(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq17 : "");
          setValueat38(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq18 : "");
          setValueat39(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq19 : "");
          setValueat310(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq110 : "");

          setValueat41(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq11 : "");
          setValueat42(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq12 : "");
          setValueat43(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq13 : "");
          setValueat44(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq14 : "");
          setValueat45(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq15 : "");
          setValueat46(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq16 : "");
          setValueat47(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq17 : "");
          setValueat48(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq18 : "");
          setValueat49(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq19 : "");
          setValueat410(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq110 : "");

          setValueat51(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq51 : "");
          setValueat52(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq52 : "");
          setValueat53(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq53 : "");
          setValueat54(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq54 : "");
          setValueat55(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq55 : "");
          setValueat56(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq56 : "");
          setValueat57(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq57 : "");
          setValueat58(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq58 : "");
          setValueat59(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq59 : "");
          setValueat510(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq510 : "");

          setValueat61(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq51 : "");
          setValueat62(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq52 : "");
          setValueat63(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq53 : "");
          setValueat64(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq54 : "");
          setValueat65(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq55 : "");
          setValueat66(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq56 : "");
          setValueat67(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq57 : "");
          setValueat68(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq58 : "");
          setValueat69(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq59 : "");
          setValueat610(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq510 : "");

          setValueat71(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq51 : "");
          setValueat72(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq52 : "");
          setValueat73(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq53 : "");
          setValueat74(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq54 : "");
          setValueat75(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq55 : "");
          setValueat76(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq56 : "");
          setValueat77(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq57 : "");
          setValueat78(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq58 : "");
          setValueat79(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq59 : "");
          setValueat710(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq510 : "");

          setValueat81(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq51 : "");
          setValueat82(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq52 : "");
          setValueat83(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq53 : "");
          setValueat84(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq54 : "");
          setValueat85(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq55 : "");
          setValueat86(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq56 : "");
          setValueat87(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq57 : "");
          setValueat88(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq58 : "");
          setValueat89(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq59 : "");
          setValueat810(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq510 : "");

          setValueat91(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq91 : "");
          setValueat92(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq92 : "");
          setValueat93(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq93 : "");
          setValueat94(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq94 : "");
          setValueat95(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq95 : "");
          setValueat96(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq96 : "");
          setValueat97(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq97 : "");
          setValueat98(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq98 : "");
          setValueat99(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq99 : "");
          setValueat910(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq910 : "");

          setValueat101(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq91 : "");
          setValueat102(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq92 : "");
          setValueat103(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq93 : "");
          setValueat104(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq94 : "");
          setValueat105(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq95 : "");
          setValueat106(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq96 : "");
          setValueat107(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq97 : "");
          setValueat108(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq98 : "");
          setValueat109(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq99 : "");
          setValueat1010(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq910 : "");

          setValueat111(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq91 : "");
          setValueat112(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq92 : "");
          setValueat113(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq93 : "");
          setValueat114(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq94 : "");
          setValueat115(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq95 : "");
          setValueat116(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq96 : "");
          setValueat117(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq97 : "");
          setValueat118(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq98 : "");
          setValueat119(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq99 : "");
          setValueat1110(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq910 : "");

          setValueat121(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq91 : "");
          setValueat122(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq92 : "");
          setValueat123(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq93 : "");
          setValueat124(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq94 : "");
          setValueat125(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq95 : "");
          setValueat126(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq96 : "");
          setValueat127(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq97 : "");
          setValueat128(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq98 : "");
          setValueat129(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq99 : "");
          setValueat1210(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq910 : "");

          //
          setValueatg1(data[0].academiciansAppointed[0] ? data[0].academiciansAppointed[0].inputaa1t1 : "");
          setValueatg2(data[0].academiciansAppointed[0] ? data[0].academiciansAppointed[0].inputaa1t2 : "");
          setValueatg3(data[0].academiciansAppointed[0] ? data[0].academiciansAppointed[0].inputaa1t3 : "");
          setValueatg4(data[0].academiciansAppointed[0] ? data[0].academiciansAppointed[0].inputaa1t4 : "");

          setValueatg21(data[0].academiciansAppointed[1] ? data[0].academiciansAppointed[1].inputaa1t1 : "");
          setValueatg22(data[0].academiciansAppointed[1] ? data[0].academiciansAppointed[1].inputaa1t2 : "");
          setValueatg23(data[0].academiciansAppointed[1] ? data[0].academiciansAppointed[1].inputaa1t3 : "");
          setValueatg24(data[0].academiciansAppointed[1] ? data[0].academiciansAppointed[1].inputaa1t4 : "");

          setValueatg31(data[0].academiciansAppointed[2] ? data[0].academiciansAppointed[1].inputaa1t1 : "");
          setValueatg32(data[0].academiciansAppointed[2] ? data[0].academiciansAppointed[1].inputaa1t2 : "");
          setValueatg33(data[0].academiciansAppointed[2] ? data[0].academiciansAppointed[1].inputaa1t3 : "");
          setValueatg34(data[0].academiciansAppointed[2] ? data[0].academiciansAppointed[1].inputaa1t4 : "");

          //
          setValueatc11(data[0].institutedUniversity[0] ? data[0].institutedUniversity[0].inputiut1 : "");
          setValueatc12(data[0].institutedUniversity[0] ? data[0].institutedUniversity[0].inputiut2 : "");
          setValueatc13(data[0].institutedUniversity[0] ? data[0].institutedUniversity[0].inputiut3 : "");
          setValueatc14(data[0].institutedUniversity[0] ? data[0].institutedUniversity[0].inputiut4 : "");

          //

          setValueas11(data[0].academicstudentsEnrolled[0] ? data[0].academicstudentsEnrolled[0].inputas11 : "");
          setValueas12(data[0].academicstudentsEnrolled[0] ? data[0].academicstudentsEnrolled[0].inputas12 : "");
          setValueas13(data[0].academicstudentsEnrolled[0] ? data[0].academicstudentsEnrolled[0].inputas13 : "");
          setValueas14(data[0].academicstudentsEnrolled[0] ? data[0].academicstudentsEnrolled[0].inputas14 : "");
          setValueas15(data[0].academicstudentsEnrolled[0] ? data[0].academicstudentsEnrolled[0].inputas15 : "");

          setValueas21(data[0].academicstudentsEnrolled[1] ? data[0].academicstudentsEnrolled[1].inputas11 : "");
          setValueas22(data[0].academicstudentsEnrolled[1] ? data[0].academicstudentsEnrolled[1].inputas12 : "");
          setValueas23(data[0].academicstudentsEnrolled[1] ? data[0].academicstudentsEnrolled[1].inputas13 : "");
          setValueas24(data[0].academicstudentsEnrolled[1] ? data[0].academicstudentsEnrolled[1].inputas14 : "");
          setValueas25(data[0].academicstudentsEnrolled[1] ? data[0].academicstudentsEnrolled[1].inputas15 : "");

          setValueas31(data[0].academicstudentsEnrolled[2] ? data[0].academicstudentsEnrolled[2].inputas11 : "");
          setValueas32(data[0].academicstudentsEnrolled[2] ? data[0].academicstudentsEnrolled[2].inputas12 : "");
          setValueas33(data[0].academicstudentsEnrolled[2] ? data[0].academicstudentsEnrolled[2].inputas13 : "");
          setValueas34(data[0].academicstudentsEnrolled[2] ? data[0].academicstudentsEnrolled[2].inputas14 : "");
          setValueas35(data[0].academicstudentsEnrolled[2] ? data[0].academicstudentsEnrolled[2].inputas15 : "");

          setValueas41(data[0].academicstudentsEnrolled[3] ? data[0].academicstudentsEnrolled[3].inputas11 : "");
          setValueas42(data[0].academicstudentsEnrolled[3] ? data[0].academicstudentsEnrolled[3].inputas12 : "");
          setValueas43(data[0].academicstudentsEnrolled[3] ? data[0].academicstudentsEnrolled[3].inputas13 : "");
          setValueas44(data[0].academicstudentsEnrolled[3] ? data[0].academicstudentsEnrolled[3].inputas14 : "");
          setValueas45(data[0].academicstudentsEnrolled[3] ? data[0].academicstudentsEnrolled[3].inputas15 : "");

          setValueas51(data[0].academicstudentsEnrolled[4] ? data[0].academicstudentsEnrolled[4].inputas11 : "");
          setValueas52(data[0].academicstudentsEnrolled[4] ? data[0].academicstudentsEnrolled[4].inputas12 : "");
          setValueas53(data[0].academicstudentsEnrolled[4] ? data[0].academicstudentsEnrolled[4].inputas13 : "");
          setValueas54(data[0].academicstudentsEnrolled[4] ? data[0].academicstudentsEnrolled[4].inputas14 : "");
          setValueas55(data[0].academicstudentsEnrolled[4] ? data[0].academicstudentsEnrolled[4].inputas15 : "");

          setValueas61(data[0].academicstudentsEnrolled[5] ? data[0].academicstudentsEnrolled[5].inputas11 : "");
          setValueas62(data[0].academicstudentsEnrolled[5] ? data[0].academicstudentsEnrolled[5].inputas12 : "");
          setValueas63(data[0].academicstudentsEnrolled[5] ? data[0].academicstudentsEnrolled[5].inputas13 : "");
          setValueas64(data[0].academicstudentsEnrolled[5] ? data[0].academicstudentsEnrolled[5].inputas14 : "");
          setValueas65(data[0].academicstudentsEnrolled[5] ? data[0].academicstudentsEnrolled[5].inputas15 : "");

          setValueas71(data[0].academicstudentsEnrolled[6] ? data[0].academicstudentsEnrolled[6].inputas11 : "");
          setValueas72(data[0].academicstudentsEnrolled[6] ? data[0].academicstudentsEnrolled[6].inputas12 : "");
          setValueas73(data[0].academicstudentsEnrolled[6] ? data[0].academicstudentsEnrolled[6].inputas13 : "");
          setValueas74(data[0].academicstudentsEnrolled[6] ? data[0].academicstudentsEnrolled[6].inputas14 : "");
          setValueas75(data[0].academicstudentsEnrolled[6] ? data[0].academicstudentsEnrolled[6].inputas15 : "");

          setValueas81(data[0].academicstudentsEnrolled[7] ? data[0].academicstudentsEnrolled[7].inputas11 : "");
          setValueas82(data[0].academicstudentsEnrolled[7] ? data[0].academicstudentsEnrolled[7].inputas12 : "");
          setValueas83(data[0].academicstudentsEnrolled[7] ? data[0].academicstudentsEnrolled[7].inputas13 : "");
          setValueas84(data[0].academicstudentsEnrolled[7] ? data[0].academicstudentsEnrolled[7].inputas14 : "");
          setValueas85(data[0].academicstudentsEnrolled[7] ? data[0].academicstudentsEnrolled[7].inputas15 : "");

          setValueas91(data[0].academicstudentsEnrolled[8] ? data[0].academicstudentsEnrolled[8].inputas11 : "");
          setValueas92(data[0].academicstudentsEnrolled[8] ? data[0].academicstudentsEnrolled[8].inputas12 : "");
          setValueas93(data[0].academicstudentsEnrolled[8] ? data[0].academicstudentsEnrolled[8].inputas13 : "");
          setValueas94(data[0].academicstudentsEnrolled[8] ? data[0].academicstudentsEnrolled[8].inputas14 : "");
          setValueas95(data[0].academicstudentsEnrolled[8] ? data[0].academicstudentsEnrolled[8].inputas15 : "");

          //

          setValueu1(data[0].integratedProgrammes[0] ? data[0].integratedProgrammes[0].inputult8 : "");
          setValueu2(data[0].integratedProgrammes[0] ? data[0].integratedProgrammes[0].inputult9 : "");


          setValuei11(data[0].integratedProgrammes[0] ? data[0].integratedProgrammes[0].inputult2 : "");
          setValuei12(data[0].integratedProgrammes[0] ? data[0].integratedProgrammes[0].inputult3 : "");
          setValuei13(data[0].integratedProgrammes[0] ? data[0].integratedProgrammes[0].inputult4 : "");
          setValuei14(data[0].integratedProgrammes[0] ? data[0].integratedProgrammes[0].inputult5 : "");
          setValuei15(data[0].integratedProgrammes[0] ? data[0].integratedProgrammes[0].inputult6 : "");

          setValuei21(data[0].integratedProgrammes[1] ? data[0].integratedProgrammes[1].inputult2 : "");
          setValuei22(data[0].integratedProgrammes[1] ? data[0].integratedProgrammes[1].inputult3 : "");
          setValuei23(data[0].integratedProgrammes[1] ? data[0].integratedProgrammes[1].inputult4 : "");
          setValuei24(data[0].integratedProgrammes[1] ? data[0].integratedProgrammes[1].inputult5 : "");
          setValuei25(data[0].integratedProgrammes[1] ? data[0].integratedProgrammes[1].inputult6 : "");

          setValuei31(data[0].integratedProgrammes[2] ? data[0].integratedProgrammes[2].inputult2 : "");
          setValuei32(data[0].integratedProgrammes[2] ? data[0].integratedProgrammes[2].inputult3 : "");
          setValuei33(data[0].integratedProgrammes[2] ? data[0].integratedProgrammes[2].inputult4 : "");
          setValuei34(data[0].integratedProgrammes[2] ? data[0].integratedProgrammes[2].inputult5 : "");
          setValuei35(data[0].integratedProgrammes[2] ? data[0].integratedProgrammes[2].inputult6 : "");


          //
          setValued11(data[0].humanResourceDevelopment[0] ? data[0].humanResourceDevelopment[0].inputrdt1 : "");
          setValued12(data[0].humanResourceDevelopment[0] ? data[0].humanResourceDevelopment[0].inputrdt2 : "");
          setValued13(data[0].humanResourceDevelopment[0] ? data[0].humanResourceDevelopment[0].inputrdt3 : "");
          setValued14(data[0].humanResourceDevelopment[0] ? data[0].humanResourceDevelopment[0].inputrdt4 : "");
          setValued15(data[0].humanResourceDevelopment[0] ? data[0].humanResourceDevelopment[0].inputrdt5 : "");

         
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ), []
  );

  // sending data to db with AP
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

   


    auniversityAffiliated:[
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputa1t1: valuead11,
        inputa1t2: valuead12,
        inputa1t3: valuead13,

      }
    ],

    auniversityAffiliated1: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputa2t1: valuead21,
        inputa2t2: valuead22,
        inputa2t3: valuead23,
        inputa2t4: valuead24,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:202,
        inputa2t1: valuead31,
        inputa2t2: valuead32,
        inputa2t3: valuead33,
        inputa2t4: valuead34,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:203,
        inputa2t1: valuead41,
        inputa2t2: valuead42,
        inputa2t3: valuead43,
        inputa2t4: valuead44,
      },
    ],

    universityColleges:[
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
    inputa3t1: valuead1,
    inputa3t2: valuead2,
    inputa3t3: valuead3,
    inputa3t4: valuead4,
    inputa3t5: valuead5,
    inputa3t6: valuead6,
    inputa3t7: valuead7,
    inputa3t8: valuead8,
    inputa3t9: valuead9,
    inputa3t10: valuead10,
    inputa3t11: valuead111,
      },
    ],

    academicinstitution: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputat11: valueatq11,
        inputat12: valueatq12,
        inputat13: valueatq13,
        inputat14: valueatq14,
        inputat15: valueatq15,
        inputat16: valueatq16,
        inputat17: valueatq17,
        inputat18: valueatq18,
        inputat19: valueatq19,
        inputat10: valueatq110,
        inputat111: valueatq111,
        inputat112: valueatq112,

       
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:202,
        inputat11: valueatq21,
        inputat12: valueatq22,
        inputat13: valueatq23,
        inputat14: valueatq24,
        inputat15: valueatq25,
        inputat16: valueatq26,
        inputat17: valueatq27,
        inputat18: valueatq28,
        inputat19: valueatq29,
        inputat10: valueatq210,
        inputat111: valueatq211,
        inputat112: valueatq212,

      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:203,
        inputat11: valueatq31,
        inputat12: valueatq32,
        inputat13: valueatq33,
        inputat14: valueatq34,
        inputat15: valueatq35,
        inputat16: valueatq36,
        inputat17: valueatq37,
        inputat18: valueatq38,
        inputat19: valueatq39,
        inputat10: valueatq310,
        inputat111: valueatq311,
        inputat112: valueatq312,

       
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:204,
        inputat11: valueatq41,
        inputat12: valueatq42,
        inputat13: valueatq43,
        inputat14: valueatq44,
        inputat15: valueatq45,
        inputat16: valueatq46,
        inputat17: valueatq47,
        inputat18: valueatq48,
        inputat19: valueatq49,
        inputat10: valueatq410,
        inputat111: valueatq411,
        inputat112: valueatq412,

      },
    ],

    
    nonTeachingStaff:[
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputatnt11: valueatnt11,
        inputatnt12: valueatnt12,
        inputatnt13: valueatnt13,
        inputatnt14: valueatnt14,
      },
     
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:202,
        inputatnt11: valueatnt21,
        inputatnt12: valueatnt22,
        inputatnt13: valueatnt23,
        inputatnt14: valueatnt24,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:203,
        inputatnt11: valueatnt31,
        inputatnt12: valueatnt32,
        inputatnt13: valueatnt33,
        inputatnt14: valueatnt34,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:204,
        inputatnt11: valueatnt41,
        inputatnt12: valueatnt42,
        inputatnt13: valueatnt43,
        inputatnt14: valueatnt44,
      },
      
     
    ],

    
    
    technicalStaff:[
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputatt15: valueatt11,
        inputatt16: valueatt12,
        inputatt17: valueatt13,
        inputatt18: valueatt14,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:202,
        inputatt15: valueatt21,
        inputatt16: valueatt22,
        inputatt17: valueatt23,
        inputatt18: valueatt24,
      },

      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:203,
        inputatt15: valueatt31,
        inputatt16: valueatt32,
        inputatt17: valueatt33,
        inputatt18: valueatt34,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:204,
        inputatt15: valueatt41,
        inputatt16: valueatt42,
        inputatt17: valueatt43,
        inputatt18: valueatt44,
      },
    ],

    
    academicPerminentTeachers: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputatq11: valueat11,
        inputatq12: valueat12,
        inputatq13: valueat13,
        inputatq14: valueat14,
        inputatq15: valueat15,
        inputatq16: valueat16,
        inputatq17: valueat17,
        inputatq18: valueat18,
        inputatq19: valueat19,
        inputatq110: valueat110,


      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:202,
      inputatq11: valueat21,
        inputatq12: valueat22,
        inputatq13: valueat23,
        inputatq14: valueat24,
        inputatq15: valueat25,
        inputatq16: valueat26,
        inputatq17: valueat27,
        inputatq18: valueat28,
        inputatq19: valueat29,
        inputatq110: valueat210,
      },

      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:203,
        inputatq11: valueat31,
        inputatq12: valueat32,
        inputatq13: valueat33,
        inputatq14: valueat34,
        inputatq15: valueat35,
        inputatq16: valueat36,
        inputatq17: valueat37,
        inputatq18: valueat38,
        inputatq19: valueat39,
        inputatq110: valueat310,
      },

      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:204,
        inputatq11: valueat41,
        inputatq12: valueat42,
        inputatq13: valueat43,
        inputatq14: valueat44,
        inputatq15: valueat45,
        inputatq16: valueat46,
        inputatq17: valueat47,
        inputatq18: valueat48,
        inputatq19: valueat49,
        inputatq110: valueat410,
      },

      
    ],


    academicTemporaryTeachers:[
      
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

          uniqueKey1:201,
        inputatq51: valueat51,
        inputatq52: valueat52,
        inputatq53: valueat53,
        inputatq54: valueat54,
        inputatq55: valueat55,
        inputatq56: valueat56,
        inputatq57: valueat57,
        inputatq58: valueat58,
        inputatq59: valueat59,
        inputatq510: valueat510,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:202,
        inputatq51: valueat61,
        inputatq52: valueat62,
        inputatq53: valueat63,
        inputatq54: valueat64,
        inputatq55: valueat65,
        inputatq56: valueat66,
        inputatq57: valueat67,
        inputatq58: valueat68,
        inputatq59: valueat69,
        inputatq510: valueat610,
    },

    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

      uniqueKey1:203,
      inputatq51: valueat71,
      inputatq52: valueat72,
      inputatq53: valueat73,
      inputatq54: valueat74,
      inputatq55: valueat75,
      inputatq56: valueat76,
      inputatq57: valueat77,
      inputatq58: valueat78,
      inputatq59: valueat79,
      inputatq510: valueat710,

  },

  {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    uniqueKey1:204,
    inputatq51: valueat81,
        inputatq52: valueat82,
        inputatq53: valueat83,
        inputatq54: valueat84,
        inputatq55: valueat85,
        inputatq56: valueat86,
        inputatq57: valueat87,
        inputatq58: valueat88,
        inputatq59: valueat89,
        inputatq510: valueat810,

},
    ],


    academicParttimeTeacheres:[
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputatq91: valueat91,
        inputatq92: valueat92,
        inputatq93: valueat93,
        inputatq94: valueat94,
        inputatq95: valueat95,
        inputatq96: valueat96,
        inputatq97: valueat97,
        inputatq98: valueat98,
        inputatq99: valueat99,
        inputatq910: valueat910,

      },

      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:202,
        inputatq91: valueat101,
        inputatq92: valueat102,
        inputatq93: valueat103,
        inputatq94: valueat104,
        inputatq95: valueat105,
        inputatq96: valueat106,
        inputatq97: valueat107,
        inputatq98: valueat108,
        inputatq99: valueat109,
        inputatq910: valueat1010,

      },

      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:203,
        inputatq91: valueat111,
        inputatq92: valueat112,
        inputatq93: valueat113,
        inputatq94: valueat114,
        inputatq95: valueat115,
        inputatq96: valueat116,
        inputatq97: valueat117,
        inputatq98: valueat118,
        inputatq99: valueat119,
        inputatq910: valueat1110,

      },

      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:204,
        inputatq91: valueat121,
        inputatq92: valueat122,
        inputatq93: valueat123,
        inputatq94: valueat124,
        inputatq95: valueat125,
        inputatq96: valueat126,
        inputatq97: valueat127,
        inputatq98: valueat128,
        inputatq99: valueat129,
        inputatq910: valueat1210,

      },
    ],
  
    academiciansAppointed: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputaa1t1: valueatg1,
        inputaa1t2: valueatg2,
        inputaa1t3: valueatg3,
        inputaa1t4: valueatg4,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:202,
        inputaa1t1: valueatg21,
        inputaa1t2: valueatg22,
        inputaa1t3: valueatg23,
        inputaa1t4: valueatg24,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:203,
        inputaa1t1: valueatg31,
        inputaa1t2: valueatg32,
        inputaa1t3: valueatg33,
        inputaa1t4: valueatg34,
      },
    ],
    institutedUniversity: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputiut1: valueatc11,
        inputiut2: valueatc12,
        inputiut3: valueatc13,
        inputiut4: valueatc14,
      },
    ],
    academicstudentsEnrolled: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputas11: valueas11,
        inputas12: valueas12,
        inputas13: valueas13,
        inputas14: valueas14,
        inputas15: valueas15,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:202,
        inputas11: valueas21,
        inputas12: valueas22,
        inputas13: valueas23,
        inputas14: valueas24,
        inputas15: valueas25,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:203,
        inputas11: valueas31,
        inputas12: valueas32,
        inputas13: valueas33,
        inputas14: valueas34,
        inputas15: valueas35,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:204,
        inputas11: valueas41,
        inputas12: valueas42,
        inputas13: valueas43,
        inputas14: valueas44,
        inputas15: valueas45,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:205,
        inputas11: valueas51,
        inputas12: valueas52,
        inputas13: valueas53,
        inputas14: valueas54,
        inputas15: valueas55,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:206,
        inputas11: valueas61,
        inputas12: valueas62,
        inputas13: valueas63,
        inputas14: valueas64,
        inputas15: valueas65,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:207,
        inputas11: valueas71,
        inputas12: valueas72,
        inputas13: valueas73,
        inputas14: valueas74,
        inputas15: valueas75,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:208,
        inputas11: valueas81,
        inputas12: valueas82,
        inputas13: valueas83,
        inputas14: valueas84,
        inputas15: valueas85,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:209,
        inputas11: valueas91,
        inputas12: valueas92,
        inputas13: valueas93,
        inputas14: valueas94,
        inputas15: valueas95,
      },
    ],

    integratedProgrammes: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,

        inputult7: valueu1,
        inputult8: valueu2,


        inputult2: valuei11,
        inputult3: valuei12,
        inputult4: valuei13,
        inputult5: valuei14,
        inputult6: valuei15,

        
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:202,
        inputult2: valuei21,
        inputult3: valuei22,
        inputult4: valuei23,
        inputult5: valuei24,
        inputult6: valuei25,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:203,
        inputult2: valuei31,
        inputult3: valuei32,
        inputult4: valuei33,
        inputult5: valuei34,
        inputult6: valuei35,
      },
    ],
    humanResourceDevelopment: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputrdt1: valued11,
        inputrdt2: valued12,
        inputrdt3: valued13,
        inputrdt4: valued14,
        inputrdt5: valued15,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const basicData = new FormData();
  
    basicData.append("ssrData", jsonBlob(inputDataList));

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(resources.APPLICATION_URL+"academicdata", filesFetchMethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Saved Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
  }

  return (
    <div className="main-container">
      <h1 className="main-heading-style">Academic Information</h1>
      <div className="eachTable-container">
        <form>
          <h6>
            Institutions affiliated to the University (Not applicable for
            private and deemed to be Universities)
          </h6>
          <table>
            <tr>
              <th>College Type</th>
              <th>Number of colleges with permanent affiliation</th>
              <th>Number of colleges with temporary affiliation</th>
            </tr>
            <tr>
              <td>
                <input readonly
                  type="text"
                  id="ad11"
                  value={valuead11}
                  onChange={(e) => setValuead11(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ad12"
                  value={valuead12}
                  onChange={(e) => setValuead12(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ad13"
                  value={valuead13}
                  onChange={(e) => setValuead13(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <table>
            <tr>
              <th style={{ width: "35%" }}>Type of Colleges</th>
              <th>Permanent</th>
              <th>Temporary</th>
              <th>Total</th>
            </tr>
            <tr>
              <th>Education/Teachers Training</th>
              <td>
                <input readonly
                  type="text"
                  id="ad21"
                  value={valuead21}
                  onChange={(e) => setValuead21(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ad22"
                  value={valuead22}
                  onChange={(e) => setValuead22(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ad23"
                  value={valuead23}
                  onChange={(e) => setValuead23(e.target.value)}
                />
              </td>
              <td style={{ width: "12%" }}>
                <input readonly
                  type="text"
                  id="ad24"
                  value={valuead24}
                  onChange={(e) => setValuead24(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Business administration /Commerce /Management /Finance</th>
              <td>
                <input readonly
                  type="text"
                  id="ad31"
                  value={valuead31}
                  onChange={(e) => setValuead31(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ad32"
                  value={valuead32}
                  onChange={(e) => setValuead32(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ad33"
                  value={valuead33}
                  onChange={(e) => setValuead33(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ad34"
                  value={valuead34}
                  onChange={(e) => setValuead34(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Universal/ Common to all Disciplines</th>
              <td>
                <input readonly
                  type="text"
                  id="ad41"
                  value={valuead41}
                  onChange={(e) => setValuead41(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ad42"
                  value={valuead42}
                  onChange={(e) => setValuead42(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ad43"
                  value={valuead43}
                  onChange={(e) => setValuead43(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ad44"
                  value={valuead44}
                  onChange={(e) => setValuead44(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1">
            Furnish the Details of Number of Colleges under the University
          </label>
          <table>
            <tr>
              <th>Constituent Colleges</th>
              <td>
                <input readonly
                  type="text"
                  id="ad1"
                  value={valuead1}
                  onChange={(e) => setValuead1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Constituent Colleges</th>
              <td>
                <input readonly
                  type="text"
                  id="ad2"
                  value={valuead2}
                  onChange={(e) => setValuead2(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>College Under 2(f)</th>
              <td>
                <input readonly
                  type="text"
                  id="ad3"
                  value={valuead3}
                  onChange={(e) => setValuead3(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Collge Under 2(f) and 12B</th>
              <td>
                <input readonly
                  type="text"
                  id="ad4"
                  value={valuead4}
                  onChange={(e) => setValuead4(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>NAAC Accredited Colleges</th>
              <td>
                <input readonly
                  type="text"
                  id="ad5"
                  value={valuead5}
                  onChange={(e) => setValuead5(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Colleges with Potential for Excellence (UGC)</th>
              <td>
                <input readonly
                  type="text"
                  id="ad6"
                  value={valuead6}
                  onChange={(e) => setValuead6(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Autonomous Colleges</th>
              <td>
                <input readonly
                  type="text"
                  id="ad7"
                  value={valuead7}
                  onChange={(e) => setValuead7(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>College with Postgraduate Departments</th>
              <td>
                <input readonly
                  type="text"
                  id="ad8"
                  value={valuead8}
                  onChange={(e) => setValuead8(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Colleges with Research Departments</th>
              <td>
                <input readonly
                  type="text"
                  id="ad9"
                  value={valuead9}
                  onChange={(e) => setValuead9(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>University Recognized Research Institutes/Centres</th>
              <td>
                <input readonly
                  type="text"
                  id="ad10"
                  value={valuead10}
                  onChange={(e) => setValuead10(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <table>
            <tr>
              <th>
                Does the University Offer any Programmes Recognized by any other
                Statutory Regulatory authority (SRA)
              </th>
              <td>
                {" "}
                <input readonly
                  type="radio"
                  id="ad111"
                  name="opion1"
                  value={valuead111}
                  onChange={(e) => setValuead111(e.target.value)}
                />
                Yes
              </td>
              <td>
                <input readonly
                  type="radio"
                  id="ad111"
                  name="opion1"
                  value={valuead111}
                  onChange={(e) => setValuead111(e.target.value)}
                />
                No
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1">
            Details of the Number of Teaching & Non-Teaching Staff in the
            University
          </label>
          <label htmlFor="academicInfo-t1">Teaching Faculty</label>
          <table>
            <tr>
              <th colspan="13">Designation</th>
            </tr>
            <tr>
              <th
                rowspan="2"
                style={{ width: "13%", textAlign: "center" }}
              ></th>
              <th colspan="4">Professor</th>
              <th colspan="4">Associate Proffessor</th>
              <th colspan="4">Assistant Professor</th>
            </tr>
            <tr className="academic-font">
              <td>Male</td>
              <td>Female</td>
              <td>Others</td>
              <td>Total</td>
              <td>Male</td>
              <td>Female</td>
              <td>Others</td>
              <td>Total</td>
              <td>Male</td>
              <td>Female</td>
              <td>Others</td>
              <td>Total</td>
            </tr>
            <tr>
              <th>Sanctioned</th>
              <td>
                <input readonly
                  type="text"
                  id="atq11"
                  value={valueatq11}
                  onChange={(e) => setValueatq11(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq12"
                  value={valueatq12}
                  onChange={(e) => setValueatq12(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq13"
                  value={valueatq13}
                  onChange={(e) => setValueatq13(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq14"
                  value={valueatq14}
                  onChange={(e) => setValueatq14(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq15"
                  value={valueatq15}
                  onChange={(e) => setValueatq15(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq16"
                  value={valueatq16}
                  onChange={(e) => setValueatq16(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq17"
                  value={valueatq17}
                  onChange={(e) => setValueatq17(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq18"
                  value={valueatq18}
                  onChange={(e) => setValueatq18(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq19"
                  value={valueatq19}
                  onChange={(e) => setValueatq19(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq110"
                  value={valueatq110}
                  onChange={(e) => setValueatq110(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq111"
                  value={valueatq111}
                  onChange={(e) => setValueatq111(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq112"
                  value={valueatq112}
                  onChange={(e) => setValueatq112(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Recruited</th>
              <td>
                <input readonly
                  type="text"
                  id="atq21"
                  value={valueatq21}
                  onChange={(e) => setValueatq21(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  value={valueatq22}
                  id="atq22"
                  onChange={(e) => setValueatq22(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq23"
                  value={valueatq23}
                  onChange={(e) => setValueatq23(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq24"
                  value={valueatq24}
                  onChange={(e) => setValueatq24(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq25"  
                  value={valueatq25}
                  onChange={(e) => setValueatq25(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq26"
                  value={valueatq26}
                  onChange={(e) => setValueatq26(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq27"
                  value={valueatq27}
                  onChange={(e) => setValueatq27(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq28"
                  value={valueatq28}
                  onChange={(e) => setValueatq28(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq29"
                  value={valueatq29}
                  onChange={(e) => setValueatq29(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq210"
                  value={valueatq210}
                  onChange={(e) => setValueatq210(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq211"
                  value={valueatq211}
                  onChange={(e) => setValueatq211(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq212"
                  value={valueatq212}
                  onChange={(e) => setValueatq212(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input readonly
                  type="text"
                  id="atq31"
                  value={valueatq31}
                  onChange={(e) => setValueatq31(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq32"
                  value={valueatq32}
                  onChange={(e) => setValueatq32(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq33"
                  value={valueatq33}
                  onChange={(e) => setValueatq33(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq34"
                  value={valueatq34}
                  onChange={(e) => setValueatq34(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq35"
                  value={valueatq35}
                  onChange={(e) => setValueatq35(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq36"
                  value={valueatq36}
                  onChange={(e) => setValueatq36(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq37"
                  value={valueatq37}
                  onChange={(e) => setValueatq37(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq38"
                  value={valueatq38}
                  onChange={(e) => setValueatq38(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq39"
                  value={valueatq39}
                  onChange={(e) => setValueatq39(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq310"
                  value={valueatq310}
                  onChange={(e) => setValueatq310(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq311"
                  value={valueatq311}
                  onChange={(e) => setValueatq311(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq312"
                  value={valueatq312}
                  onChange={(e) => setValueatq312(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Contractual</th>
              <td>
                <input readonly
                  type="text"
                  id="atq41"
                  value={valueatq41}
                  onChange={(e) => setValueatq41(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq42"
                  value={valueatq42}
                  onChange={(e) => setValueatq42(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq43"
                  value={valueatq43}
                  onChange={(e) => setValueatq43(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq44"
                  
                  value={valueatq44}
                  onChange={(e) => setValueatq44(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq45"
                  value={valueatq45}
                  onChange={(e) => setValueatq45(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq46"
                  value={valueatq46}
                  onChange={(e) => setValueatq46(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  value={valueatq47}
                  id="atq47"
                  onChange={(e) => setValueatq47(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq48"
                  value={valueatq48}
                  onChange={(e) => setValueatq48(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq49"
                  value={valueatq49}
                  onChange={(e) => setValueatq49(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq410"
                  value={valueatq410}
                  onChange={(e) => setValueatq410(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  value={valueatq411}
                  id="atq411"
                  onChange={(e) => setValueatq411(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq412"
                  value={valueatq412}
                  onChange={(e) => setValueatq412(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1">Teaching Staff</label>
          <table>
            <tr>
              <th style={{ width: "30%" }}></th>
              <th>Male</th>
              <th>Female</th>
              <th>Others</th>
              <th>Total</th>
            </tr>
            <tr>
              <th>Sanctioned</th>
              <td>
                <input readonly
                  type="text"
                  id="atnt11"
                  value={valueatnt11}
                  onChange={(e) => setValueatnt11(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atnt12"
                  value={valueatnt12}
                  onChange={(e) => setValueatnt12(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atnt13"
                  value={valueatnt13}
                  onChange={(e) => setValueatnt13(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atnt14"
                  value={valueatnt14}
                  onChange={(e) => setValueatnt14(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Recruited</th>
              <td>
                <input readonly
                  type="text"
                  id="atnt21"
                  value={valueatnt21}
                  onChange={(e) => setValueatnt21(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atnt22"
                  value={valueatnt22}
                  onChange={(e) => setValueatnt22(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atnt23"
                  value={valueatnt23}
                  onChange={(e) => setValueatnt23(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atnt24"
                  value={valueatnt24}
                  onChange={(e) => setValueatnt24(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input readonly
                  type="text"
                  id="atnt31"
                  value={valueatnt31}
                  onChange={(e) => setValueatnt31(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atnt32"
                  value={valueatnt32}
                  onChange={(e) => setValueatnt32(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atnt33"
                  value={valueatnt33}
                  onChange={(e) => setValueatnt33(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atnt34"
                  value={valueatnt34}
                  onChange={(e) => setValueatnt34(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Contractual</th>
              <td>
                <input readonly
                  type="text"
                  id="atnt41"
                  value={valueatnt41}
                  onChange={(e) => setValueatnt41(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atnt43"
                  value={valueatnt43}
                  onChange={(e) => setValueatnt42(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atnt43"
                  value={valueatnt43}
                  onChange={(e) => setValueatnt43(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atnt44"
                  value={valueatnt44}
                  onChange={(e) => setValueatnt44(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1">Non-Technical Staff</label>
          <table>
            <tr>
              <th></th>
              <th>Male</th>
              <th>Female</th>
              <th>Others</th>
              <th>Total</th>
            </tr>
            <tr>
              <th>Sanctioned</th>
              <td>
                <input readonly
                  type="text"
                  id="att11"
                  value={valueatt11}
                  onChange={(e) => setValueatt11(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="att12"
                  value={valueatt12}
                  onChange={(e) => setValueatt12(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="att13"
                  value={valueatt13}
                  onChange={(e) => setValueatt13(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="att14"
                  value={valueatt14}
                  onChange={(e) => setValueatt14(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Recruited</th>
              <td>
                <input readonly
                  type="text"
                  id="att21"
                  value={valueatt21}
                  onChange={(e) => setValueatt21(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="att22"
                  value={valueatt22}
                  onChange={(e) => setValueatt22(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="att23"
                  value={valueatt23}
                  onChange={(e) => setValueatt23(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="att24"
                  value={valueatt24}
                  onChange={(e) => setValueatt24(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input readonly
                  type="text"
                  id="att31"
                  value={valueatt31}
                  onChange={(e) => setValueatt31(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="att32"
                  value={valueatt32}
                  onChange={(e) => setValueatt32(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="att33"
                  value={valueatt33}
                  onChange={(e) => setValueatt33(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="att34"
                  value={valueatt34}
                  onChange={(e) => setValueatt34(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Contractual</th>
              <td>
                <input readonly
                  type="text"
                  id="att41"
                  value={valueatt41}
                  onChange={(e) => setValueatt41(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="att42"
                  value={valueatt42}
                  onChange={(e) => setValueatt42(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="att43"
                  value={valueatt43}
                  onChange={(e) => setValueatt43(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="att44"
                  value={valueatt44}
                  onChange={(e) => setValueatt44(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1">
            Qualification Details of the Teaching Staff
          </label>
          <table>
            <tr>
              <th colspan="11">Permanent Teachers</th>
            </tr>
            <tr>
              <th rowspan="2" style={{ width: "13%" }}>
                Highest Qualification
              </th>
              <th colspan="3">Professor</th>
              <th colspan="3">Associate Proffessor</th>
              <th colspan="3">Assistant Professor</th>
              <th rowspan="2">Total</th>
            </tr>
            <tr className="academic-font">
              <td>Male</td>
              <td>Female</td>
              <td>Others</td>
              <td>Male</td>
              <td>Female</td>
              <td>Others</td>
              <td>Male</td>
              <td>Female</td>
              <td>Others</td>
            </tr>
            <tr>
              <th>D.sc/D.Litt</th>
              <td>
                <input readonly
                  type="text"
                  id="at11"
                  value={valueat11}
                  onChange={(e) => setValueat11(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at12"
                  value={valueat12}
                  onChange={(e) => setValueat12(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at13"
                  value={valueat13}
                  onChange={(e) => setValueat13(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at14"
                  value={valueat14}

                  onChange={(e) => setValueat14(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at15"
                  value={valueat15}

                  onChange={(e) => setValueat15(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at16"
                  value={valueat16}

                  onChange={(e) => setValueat16(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at17"
                  value={valueat17}

                  onChange={(e) => setValueat17(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at18"
                  value={valueat18}

                  onChange={(e) => setValueat18(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at19"
                  value={valueat19}

                  onChange={(e) => setValueat19(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at110"
                  value={valueat110}

                  onChange={(e) => setValueat110(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Ph.D.</th>
              <td>
                <input readonly
                  type="text"
                  id="at21"
                  value={valueat21}

                  onChange={(e) => setValueat21(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at22"
                  value={valueat22}

                  onChange={(e) => setValueat22(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at23"
                  value={valueat23}
                  onChange={(e) => setValueat23(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at24"
                  value={valueat24}
                  onChange={(e) => setValueat24(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at25"
                  value={valueat25}
                  onChange={(e) => setValueat25(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at26"
                  value={valueat26}
                  onChange={(e) => setValueat26(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at27"
                  value={valueat27}
                  onChange={(e) => setValueat27(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at28"
                  value={valueat28}
                  onChange={(e) => setValueat28(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at29"
                  value={valueat29}
                  onChange={(e) => setValueat29(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at210"
                  value={valueat210}
                  onChange={(e) => setValueat210(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>M.Phil.</th>
              <td>
                <input readonly
                  type="text"
                  id="at31"
                  value={valueat31}
                  onChange={(e) => setValueat31(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at32"
                  value={valueat32}
                  onChange={(e) => setValueat32(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at33"
                  value={valueat33}
                  onChange={(e) => setValueat33(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at34"
                  value={valueat34}
                  onChange={(e) => setValueat34(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at35"
                  value={valueat35}
                  onChange={(e) => setValueat35(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at36"
                  value={valueat36}
                  onChange={(e) => setValueat36(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at37"
                  value={valueat37}
                  onChange={(e) => setValueat37(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at38"
                  value={valueat38}
                  onChange={(e) => setValueat38(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at39"
                  value={valueat39}
                  onChange={(e) => setValueat39(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at310"
                  value={valueat310}
                  onChange={(e) => setValueat310(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG</th>
              <td>
                <input readonly
                  type="text"
                  id="at41"
                  value={valueat41}
                  onChange={(e) => setValueat41(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at42"
                  value={valueat42}
                  onChange={(e) => setValueat42(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at43"
                  value={valueat43}
                  onChange={(e) => setValueat43(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at44"
                  value={valueat44}
                  onChange={(e) => setValueat44(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at45"
                  value={valueat45}
                  onChange={(e) => setValueat45(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at46"
                  value={valueat46}
                  onChange={(e) => setValueat46(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at47"
                  value={valueat47}
                  onChange={(e) => setValueat47(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at48"
                  value={valueat48}
                  onChange={(e) => setValueat48(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at49"
                  value={valueat49}
                  onChange={(e) => setValueat49(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at410"
                  value={valueat410}
                  onChange={(e) => setValueat410(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <table>
            <tr>
              <th colspan="11">Temporary Teachers</th>
            </tr>
            <tr>
              <th rowspan="2" style={{ width: "13%" }}>
                Highest Qualification
              </th>
              <th colspan="3">Professor</th>
              <th colspan="3">Associate Professor</th>
              <th colspan="3">Assistant Professor</th>
              <th rowspan="2">Total</th>
            </tr>
            <tr className="academic-font">
              <th>Male</th>
              <th>Female</th>
              <th>Others</th>
              <th>Male</th>
              <th>Female</th>
              <th>Others</th>
              <th>Male</th>
              <th>Female</th>
              <th>Others</th>
            </tr>
            <tr>
              <th>D.sc/D.Litt</th>
              <td>
                <input readonly
                  type="text"
                  id="at51"
                  value={valueat51}
                  onChange={(e) => setValueat51(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at52"
                  value={valueat52}
                  onChange={(e) => setValueat52(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at53"
                  value={valueat53}
                  onChange={(e) => setValueat53(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at54"
                  value={valueat54}
                  onChange={(e) => setValueat54(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at55"
                  value={valueat55}
                  onChange={(e) => setValueat55(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at56"
                  value={valueat56}
                  onChange={(e) => setValueat56(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at57"
                  value={valueat57}
                  onChange={(e) => setValueat57(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at58"
                  value={valueat58}
                  onChange={(e) => setValueat58(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at59"
                  value={valueat59}
                  onChange={(e) => setValueat59(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at510"
                  value={valueat510}
                  onChange={(e) => setValueat510(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Ph.D.</th>
              <td>
                <input readonly
                  type="text"
                  id="at61"
                  value={valueat61}
                  onChange={(e) => setValueat61(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at62"
                  value={valueat62}
                  onChange={(e) => setValueat62(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at63"
                  value={valueat63}
                  onChange={(e) => setValueat63(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at64"
                  value={valueat64}
                  onChange={(e) => setValueat64(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at65"
                  value={valueat65}
                  onChange={(e) => setValueat65(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at66"
                  value={valueat66}
                  onChange={(e) => setValueat66(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at67"
                  value={valueat67}
                  onChange={(e) => setValueat67(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at68"
                  value={valueat68}
                  onChange={(e) => setValueat68(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at69"
                  value={valueat69}
                  onChange={(e) => setValueat69(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at610"
                  value={valueat610}
                  onChange={(e) => setValueat610(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>M.Phil.</th>
              <td>
                <input readonly
                  type="text"
                  id="at71"
                  value={valueat71}
                  onChange={(e) => setValueat71(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at72"
                  value={valueat72}
                  onChange={(e) => setValueat72(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at73"
                  value={valueat73}
                  onChange={(e) => setValueat73(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at74"
                  value={valueat74}
                  onChange={(e) => setValueat74(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at75"
                  value={valueat75}
                  onChange={(e) => setValueat75(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at76"
                  value={valueat76}
                  onChange={(e) => setValueat76(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at77"
                  value={valueat77}
                  onChange={(e) => setValueat77(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq8"
                  value={valueat78}
                  onChange={(e) => setValueat78(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at79"
                  value={valueat79}
                  onChange={(e) => setValueat79(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at710"
                  value={valueat710}
                  onChange={(e) => setValueat710(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG</th>
              <td>
                <input readonly
                  type="text"
                  id="at81"
                  value={valueat81}
                  onChange={(e) => setValueat81(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at82"
                  value={valueat82}
                  onChange={(e) => setValueat82(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at83"
                  value={valueat83}
                  onChange={(e) => setValueat83(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at84"
                  value={valueat84}
                  onChange={(e) => setValueat84(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at85"
                  value={valueat85}
                  onChange={(e) => setValueat85(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at86"
                  value={valueat86}
                  onChange={(e) => setValueat86(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at87"
                  value={valueat87}
                  onChange={(e) => setValueat87(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at88"
                  value={valueat88}
                  onChange={(e) => setValueat88(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at89"
                  value={valueat89}
                  onChange={(e) => setValueat89(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at810"
                  value={valueat810}
                  onChange={(e) => setValueat810(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <table>
            <tr>
              <th colspan="11">Part Time Teachers</th>
            </tr>
            <tr>
              <th rowspan="2" style={{ width: "13%" }}>
                Highest Qualification
              </th>
              <th colspan="3">Professor</th>
              <th colspan="3">Associate Professor</th>
              <th colspan="3">Assistant Professor</th>
              <th rowspan="2">Total</th>
            </tr>
            <tr className="academic-font">
              <th>Male</th>
              <th>Female</th>
              <th>Others</th>
              <th>Male</th>
              <th>Female</th>
              <th>Others</th>
              <th>Male</th>
              <th>Female</th>
              <th>Others</th>
            </tr>
            <tr>
              <th>D.sc/D.Litt</th>
              <td>
                <input readonly
                  type="text"
                  id="at92"
                  value={valueat92}
                  onChange={(e) => setValueat91(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at92"
                  value={valueat92}
                  onChange={(e) => setValueat92(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at93"
                  value={valueat93}
                  onChange={(e) => setValueat93(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at94"
                  value={valueat94}
                  onChange={(e) => setValueat94(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at95"
                  value={valueat95}
                  onChange={(e) => setValueat95(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at96"
                  value={valueat96}
                  onChange={(e) => setValueat96(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at97"
                  value={valueat97}
                  onChange={(e) => setValueat97(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at98"
                  value={valueat98}
                  onChange={(e) => setValueat98(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at99"
                  value={valueat99}
                  onChange={(e) => setValueat99(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at910"
                  value={valueat910}
                  onChange={(e) => setValueat910(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Ph.D.</th>
              <td>
                <input readonly
                  type="text"
                  id="at101"
                  value={valueat101}
                  onChange={(e) => setValueat101(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at102"
                  value={valueat102}
                  onChange={(e) => setValueat102(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at103"
                  value={valueat103}
                  onChange={(e) => setValueat103(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at104"
                  value={valueat104}
                  onChange={(e) => setValueat104(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at105"
                  value={valueat105}
                  onChange={(e) => setValueat105(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at106"
                  value={valueat106}
                  onChange={(e) => setValueat106(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at107"
                  value={valueat107}
                  onChange={(e) => setValueat107(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at108"
                  value={valueat108}
                  onChange={(e) => setValueat108(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at109"
                  value={valueat109}
                  onChange={(e) => setValueat109(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at110"
                  value={valueat110}
                  onChange={(e) => setValueat110(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th> M.Phil.</th>
              <td>
                <input readonly
                  type="text"
                  id="at111"
                  value={valueat111}
                  onChange={(e) => setValueat111(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at112"
                 
                  value={valueat112}
                  onChange={(e) => setValueat112(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at113"
                  value={valueat113}
                  onChange={(e) => setValueat113(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at114"
                  value={valueat114}
                  onChange={(e) => setValueat114(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at115"
                  value={valueat115}
                  onChange={(e) => setValueat115(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atq116"
                  value={valueat116}
                  onChange={(e) => setValueatq116(e.target.value)}
                />
              </td> 
              <td>
                <input readonly
                  type="text"
                  id="at117"
                  value={valueat117}
                  onChange={(e) => setValueat117(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at118"
                  value={valueat118}
                  onChange={(e) => setValueat118(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at119"
                  value={valueat119}
                  onChange={(e) => setValueat119(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at1110"
                  value={valueat1110}
                  onChange={(e) => setValueat1110(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG</th>
               <td>
                <input readonly
                  type="text"
                  id="atq121"
                  value={valueat121}

                  onChange={(e) => setValueat121(e.target.value)}
                />
              </td> 
              <td>
                <input readonly
                  type="text"
                  id="at122"
                  value={valueat122}
                  onChange={(e) => setValueat122(e.target.value)}
                />
              </td>
           <td>
                <input readonly
                  type="text"
                  id="atq123"
                  value={valueat123}
                  onChange={(e) => setValueat123(e.target.value)}
                />
              </td> 
              <td>
                <input readonly
                  type="text"
                  id="at124"
                  value={valueat124}
                  onChange={(e) => setValueat124(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at125"
                  value={valueat125}
                  onChange={(e) => setValueat125(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at126"
                  value={valueat126}
                  onChange={(e) => setValueat126(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at127"
                  value={valueat127}
                  onChange={(e) => setValueat127(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at128"
                  value={valueat128}
                  onChange={(e) => setValueat128(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at129"
                  value={valueat129}
                  onChange={(e) => setValueat129(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="at1210"
                  value={valueat1210}
                  onChange={(e) => setValueat1210(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1">
            Distinguished Academicians Appointed
          </label>
          <table>
            <tr>
              <th></th>
              <th>Male</th>
              <th>Female</th>
              <th>Others</th>
              <th>Total</th>
            </tr>
            <tr>
              <th>Emeritus Professor</th>
              <td>
                <input readonly
                  type="text"
                  id="atg1"
                  value={valueatg1}
                  onChange={(e) => setValueatg1(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atg2"
                  value={valueatg2}
                  onChange={(e) => setValueatg2(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atg3"
                  value={valueatg3}
                  onChange={(e) => setValueatg3(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atg4"
                  value={valueatg4}
                  onChange={(e) => setValueatg4(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Adjunct Professor</th>
              <td>
                <input readonly
                  type="text"
                  id="atg21"
                  value={valueatg21}
                  onChange={(e) => setValueatg21(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atg22"
                  value={valueatg22}
                  onChange={(e) => setValueatg22(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atg23"
                  value={valueatg23}
                  onChange={(e) => setValueatg23(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atg24"
                  value={valueatg24}
                  onChange={(e) => setValueatg24(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Visiting Professor</th>
              <td>
                <input readonly
                  type="text"
                  id="atg31"
                  value={valueatg31}
                  onChange={(e) => setValueatg31(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atg32"
                  value={valueatg32}
                  onChange={(e) => setValueatg32(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atg33"
                  value={valueatg33}
                  onChange={(e) => setValueatg33(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atg34"
                  value={valueatg34}
                  onChange={(e) => setValueatg34(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1">
            Chairs Instituted by the University
          </label>
          <table>
            <tr>
              <th>SI.No</th>
              <th>Name of the Department</th>
              <th>Name of the Chair</th>
              <th>Name of the Sponsor Organisation/Agency</th>
            </tr>
            <tr>
              <td>
                <input readonly
                  type="text"
                  id="atc11"
                  value={valueatc11}
                  onChange={(e) => setValueatc11(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atc12"
                  value={valueatc12}
                  onChange={(e) => setValueatc12(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atc13"
                  value={valueatc13}
                  onChange={(e) => setValueatc13(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="atc14"
                  value={valueatc14}
                  onChange={(e) => setValueatc14(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1">
            Provide the following details of students Enrolled in the University
            during the Current Academic Year
          </label>
          <table>
            <tr>
              <th colspan="2" style={{ width: "18%" }}>
                Programme
              </th>
              <th>From the State where University is Located</th>
              <th>From Other States of India</th>
              <th>NRI Students</th>
              <th>Foreign Students</th>
              <th>Total</th>
            </tr>
            <tr>
              <th rowspan="4" style={{ width: "12%" }}>
                PG
              </th>
            </tr>
            <tr>
              <td style={{ width: "12%" }}>Male</td>
              <td>
                <input readonly
                  type="text"
                  id="as11"
                  value={valueas11}
                  onChange={(e) => setValueas11(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as12"
                  value={valueas12}
                  onChange={(e) => setValueas12(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as13"
                  value={valueas13}
                  onChange={(e) => setValueas13(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as14"
                  value={valueas14}
                  onChange={(e) => setValueas14(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as15"
                  value={valueas15}
                  onChange={(e) => setValueas15(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input readonly
                  type="text"
                  id="as21"
                  value={valueas21}
                  onChange={(e) => setValueas21(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as22"
                  value={valueas22}
                  onChange={(e) => setValueas22(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as23"
                  value={valueas23}
                  onChange={(e) => setValueas23(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as24"
                  value={valueas24}
                  onChange={(e) => setValueas24(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as25"
                  value={valueas25}
                  onChange={(e) => setValueas25(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input readonly
                  type="text"
                  id="as31"
          
                  value={valueas31}
                  onChange={(e) => setValueas31(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as32"
                  value={valueas32}
                  onChange={(e) => setValueas32(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as33"
                  value={valueas33}
                  onChange={(e) => setValueas33(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as34"
                  value={valueas34}
                  onChange={(e) => setValueas34(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as35"
                  value={valueas35}
                  onChange={(e) => setValueas35(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th rowspan="4">UG</th>
            </tr>
            <tr>
              <td>Male</td>
              <td>
                <input readonly
                  type="text"
                  id="as41"
                  value={valueas41}
                  onChange={(e) => setValueas41(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as42"
                  value={valueas42}
                  onChange={(e) => setValueas42(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as43"
                  value={valueas43}
                  onChange={(e) => setValueas43(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as44"
          
                  value={valueas44}
                  onChange={(e) => setValueas44(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as45"
                  value={valueas45}
                  onChange={(e) => setValueas45(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input readonly
                  type="text"
                  id="as51"
                  value={valueas51}
                  onChange={(e) => setValueas51(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as52"
                  value={valueas52}
                  onChange={(e) => setValueas52(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as53"
                  value={valueas53}
                  onChange={(e) => setValueas53(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as54"
                  value={valueas54}
                  onChange={(e) => setValueas54(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as55"
                  value={valueas55}
                  onChange={(e) => setValueas55(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input readonly
                  type="text"
                  id="as61"
                  value={valueas61}
                  onChange={(e) => setValueas61(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as62"
                  value={valueas62}
                  onChange={(e) => setValueas62(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as63"
                  value={valueas63}
                  onChange={(e) => setValueas63(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as64"
                  value={valueas64}
                  onChange={(e) => setValueas64(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as65"
                  value={valueas65}
                  onChange={(e) => setValueas65(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th rowspan="4">PG Diploma recognized by statutory authority</th>
            </tr>
            <tr>
              <td>Male</td>
              <td>
                <input readonly
                  type="text"
                  id="as71"
                  value={valueas71}
                  onChange={(e) => setValueas71(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as72"
                  value={valueas72}
                  onChange={(e) => setValueas72(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as73"
                  value={valueas73}
                  onChange={(e) => setValueas73(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as74"
                  value={valueas74}
                  onChange={(e) => setValueas74(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as75"
                  value={valueas75}
                  onChange={(e) => setValueas75(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input readonly
                  type="text"
                  id="as81"
                  value={valueas81}
                  onChange={(e) => setValueas81(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as82"
                  value={valueas82}
                  onChange={(e) => setValueas82(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as83"
                  value={valueas83}
                  onChange={(e) => setValueas83(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as84"
                  value={valueas84}
                  onChange={(e) => setValueas84(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as85"
                  value={valueas85}
                  onChange={(e) => setValueas85(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input readonly
                  type="text"
                  id="as91"
                  value={valueas91}
                  onChange={(e) => setValueas91(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as92"
                  value={valueas92}
                  onChange={(e) => setValueas92(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as93"
                  value={valueas93}
                  onChange={(e) => setValueas93(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as94"
                  value={valueas94}
                  onChange={(e) => setValueas94(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="as95"
                  value={valueas95}
                  onChange={(e) => setValueas95(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <table>
            <tr>
              <th>Does the university offer any integrated programmes?</th>
              <td>
                <input readonly
                  type="radio"
                  value="Yes"
                  id="u1"
                  name="opion2"
                  onChange={(e) => setValueu1(e.target.value)}
                />
                Yes
              </td>
              <td>
                <input readonly
                  type="radio"
                  value="No"
                  id="u1"
                  name="opion2"
                  onChange={(e) => setValueu1(e.target.value)}
                />
                No
              </td>
            </tr>
            <tr>
              <td>Total number of integrated programmes</td>
              <td>
                <input readonly
                  rowspan="2"
                  type="text"
                  id="u2"
                value={valueu2}
                  onChange={(e) => setValueu2(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <table>
            <tr>
              <th>Integrated Programmes</th>
              <th>From the state where the university is located</th>
              <th>From other states of India</th>
              <th>NRI Students</th>
              <th>Foreign Students</th>
              <th>Total</th>
            </tr>
            <tr>
              <td>Male</td>
              <td>
                <input readonly
                  type="text"
                  id="i11"
                  value={valuei11}
                  onChange={(e) => setValuei11(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="i12"
                  value={valuei12}
                  onChange={(e) => setValuei12(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="i13"
                  value={valuei13}
                  onChange={(e) => setValuei13(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="i14"
                  value={valuei14}
                  onChange={(e) => setValuei14(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="i15"
                  value={valuei15}
                  onChange={(e) => setValuei15(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input readonly
                  type="text"
                  id="i21"
                  value={valuei21}
                  onChange={(e) => setValuei21(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="i22"
                  value={valuei22}
                  onChange={(e) => setValuei22(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="i23"
                  value={valuei23}
                  onChange={(e) => setValuei23(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="i24"
                  value={valuei24}
                  onChange={(e) => setValuei24(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="i25"
                  value={valuei25}
                  onChange={(e) => setValuei25(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input readonly
                  type="text"
                  id="i31"
                  value={valuei31}
                  onChange={(e) => setValuei31(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="i32"
                  value={valuei32}
                  onChange={(e) => setValuei32(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="i33"
                  value={valuei33}
                  onChange={(e) => setValuei33(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="i34"
                  value={valuei34}
                  onChange={(e) => setValuei34(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="i35"
                  value={valuei35}
                  onChange={(e) => setValuei35(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <table>
            <label htmlFor="academicInfo-t1">
              Details of programmes under the UGC Human Resource Development
              Centre,If applicable
            </label>
            <tr>
              <td>Year of Establishment</td>
              <td>
                <input readonly
                  type="text"
                  id="d11"
                  value={valued11}
                  onChange={(e) => setValued11(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Number of UGC Orientation Programmes</td>
              <td>
                <input readonly
                  type="text"
                  id="d12"
                  value={valued12}
                  onChange={(e) => setValued12(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Number of UGC Refresher Course</td>
              <td>
                <input readonly
                  type="text"
                  id="d13"
                  value={valued13}
                  onChange={(e) => setValued13(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Number of University own Programmes</td>
              <td>
                <input readonly
                  type="text"
                  id="d14"
                  value={valued14}
                  onChange={(e) => setValued14(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>
                Total Number of Programmes Conducted (during the last five
                years)
              </td>
              <td>
                <input readonly
                  type="text"
                  id="d15"
                  value={valued15}
                  onChange={(e) => setValued15(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="c11x-button-container" style={{ paddingBottom: "30px" }}>
        <button onClick={onClickingSave} className="c11x-button-style">
          Authorize
        </button>
        <button onClick={onClickingSave} className="c11x-button-style">
          Reject
        </button>
      </div>
    </div>
  );
}

export default AccademicInfo;
<></>