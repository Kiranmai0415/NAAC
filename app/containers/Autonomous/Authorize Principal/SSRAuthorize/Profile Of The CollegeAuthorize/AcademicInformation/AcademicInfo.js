import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import "./AcademicInfo-style.css";
import { resources } from "../../../../../appConstants";
import AuthService from "../../../../../Pages/Users/services/auth.service";

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

function AcademicInfo() {
  const [valuead1, setValuead1] = useState("");
  const [valuead2, setValuead2] = useState("");
  const [valuead3, setValuead3] = useState("");
  const [valuead4, setValuead4] = useState("");
  const [valuead5, setValuead5] = useState("");
  const [valuead6, setValuead6] = useState("");
  const [valuead7, setValuead7] = useState("");

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
  const [valueat111, setValueat111] = useState("");
  const [valueat112, setValueat112] = useState("");

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
  const [valueat211, setValueat211] = useState("");
  const [valueat212, setValueat212] = useState("");

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
  const [valueat311, setValueat311] = useState("");
  const [valueat312, setValueat312] = useState("");
  // on contract
  const [valueat4, setValueat4] = useState("");

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
  const [valueat411, setValueat411] = useState("");
  const [valueat412, setValueat412] = useState("");

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
  const [valueat511, setValueat511] = useState("");
  const [valueat512, setValueat512] = useState("");

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
  const [valueat611, setValueat611] = useState("");
  const [valueat612, setValueat612] = useState("");

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

  const [valueatnt51, setValueatnt51] = useState("");
  const [valueatnt52, setValueatnt52] = useState("");
  const [valueatnt53, setValueatnt53] = useState("");
  const [valueatnt54, setValueatnt54] = useState("");

  const [valueatnt61, setValueatnt61] = useState("");
  const [valueatnt62, setValueatnt62] = useState("");
  const [valueatnt63, setValueatnt63] = useState("");
  const [valueatnt64, setValueatnt64] = useState("");

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

  const [valueatt51, setValueatt51] = useState("");
  const [valueatt52, setValueatt52] = useState("");
  const [valueatt53, setValueatt53] = useState("");
  const [valueatt54, setValueatt54] = useState("");

  const [valueatt61, setValueatt61] = useState("");
  const [valueatt62, setValueatt62] = useState("");
  const [valueatt63, setValueatt63] = useState("");
  const [valueatt64, setValueatt64] = useState("");

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

  const [valueatq51, setValueatq51] = useState("");
  const [valueatq52, setValueatq52] = useState("");
  const [valueatq53, setValueatq53] = useState("");
  const [valueatq54, setValueatq54] = useState("");
  const [valueatq55, setValueatq55] = useState("");
  const [valueatq56, setValueatq56] = useState("");
  const [valueatq57, setValueatq57] = useState("");
  const [valueatq58, setValueatq58] = useState("");
  const [valueatq59, setValueatq59] = useState("");
  const [valueatq510, setValueatq510] = useState("");

  const [valueatq61, setValueatq61] = useState("");
  const [valueatq62, setValueatq62] = useState("");
  const [valueatq63, setValueatq63] = useState("");
  const [valueatq64, setValueatq64] = useState("");
  const [valueatq65, setValueatq65] = useState("");
  const [valueatq66, setValueatq66] = useState("");
  const [valueatq67, setValueatq67] = useState("");
  const [valueatq68, setValueatq68] = useState("");
  const [valueatq69, setValueatq69] = useState("");
  const [valueatq610, setValueatq610] = useState("");

  const [valueatq71, setValueatq71] = useState("");

  const [valueatq72, setValueatq72] = useState("");
  const [valueatq73, setValueatq73] = useState("");
  const [valueatq74, setValueatq74] = useState("");
  const [valueatq75, setValueatq75] = useState("");
  const [valueatq76, setValueatq76] = useState("");
  const [valueatq77, setValueatq77] = useState("");
  const [valueatq78, setValueatq78] = useState("");
  const [valueatq79, setValueatq79] = useState("");
  const [valueatq710, setValueatq710] = useState("");

  const [valueatq81, setValueatq81] = useState("");
  const [valueatq82, setValueatq82] = useState("");
  const [valueatq83, setValueatq83] = useState("");
  const [valueatq84, setValueatq84] = useState("");
  const [valueatq85, setValueatq85] = useState("");
  const [valueatq86, setValueatq86] = useState("");
  const [valueatq87, setValueatq87] = useState("");
  const [valueatq88, setValueatq88] = useState("");
  const [valueatq89, setValueatq89] = useState("");
  const [valueatq810, setValueatq810] = useState("");

  const [valueatq91, setValueatq91] = useState("");
  const [valueatq92, setValueatq92] = useState("");
  const [valueatq93, setValueatq93] = useState("");
  const [valueatq94, setValueatq94] = useState("");
  const [valueatq95, setValueatq95] = useState("");
  const [valueatq96, setValueatq96] = useState("");
  const [valueatq97, setValueatq97] = useState("");
  const [valueatq98, setValueatq98] = useState("");
  const [valueatq99, setValueatq99] = useState("");
  const [valueatq910, setValueatq910] = useState("");

  const [valueatq101, setValueatq101] = useState("");
  const [valueatq102, setValueatq102] = useState("");
  const [valueatq103, setValueatq103] = useState("");
  const [valueatq104, setValueatq104] = useState("");
  const [valueatq105, setValueatq105] = useState("");
  const [valueatq106, setValueatq106] = useState("");
  const [valueatq107, setValueatq107] = useState("");
  const [valueatq108, setValueatq108] = useState("");
  const [valueatq109, setValueatq109] = useState("");
  const [valueatq1010, setValueatq1010] = useState("");

  const [valueatq111, setValueatq111] = useState("");
  const [valueatq112, setValueatq112] = useState("");
  const [valueatq113, setValueatq113] = useState("");
  const [valueatq114, setValueatq114] = useState("");
  const [valueatq115, setValueatq115] = useState("");
  const [valueatq116, setValueatq116] = useState("");
  const [valueatq117, setValueatq117] = useState("");
  const [valueatq118, setValueatq118] = useState("");
  const [valueatq119, setValueatq119] = useState("");
  const [valueatq1110, setValueatq1110] = useState("");

  const [valueatq121, setValueatq121] = useState("");
  const [valueatq122, setValueatq122] = useState("");
  const [valueatq123, setValueatq123] = useState("");
  const [valueatq124, setValueatq124] = useState("");
  const [valueatq125, setValueatq125] = useState("");
  const [valueatq126, setValueatq126] = useState("");
  const [valueatq127, setValueatq127] = useState("");
  const [valueatq128, setValueatq128] = useState("");
  const [valueatq129, setValueatq129] = useState("");
  const [valueatq1210, setValueatq1210] = useState("");

  const [valueatg1, setValueatg1] = useState("");
  const [valueatg2, setValueatg2] = useState("");
  const [valueatg3, setValueatg3] = useState("");
  const [valueatg4, setValueatg4] = useState("");

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

  const [valueaa11, setValueaa11] = useState("");
  const [valueaa12, setValueaa12] = useState("");
  const [valueaa13, setValueaa13] = useState("");
  const [valueaa14, setValueaa14] = useState("");

  const [valueaa21, setValueaa21] = useState("");
  const [valueaa22, setValueaa22] = useState("");
  const [valueaa23, setValueaa23] = useState("");
  const [valueaa24, setValueaa24] = useState("");

  const [valueaa31, setValueaa31] = useState("");
  const [valueaa32, setValueaa32] = useState("");
  const [valueaa33, setValueaa33] = useState("");
  const [valueaa34, setValueaa34] = useState("");

  const [valueaa41, setValueaa41] = useState("");
  const [valueaa42, setValueaa42] = useState("");
  const [valueaa43, setValueaa43] = useState("");
  const [valueaa44, setValueaa44] = useState("");

  const [valueaa51, setValueaa51] = useState("");
  const [valueaa52, setValueaa52] = useState("");
  const [valueaa53, setValueaa53] = useState("");
  const [valueaa54, setValueaa54] = useState("");

  const [valueaa61, setValueaa61] = useState("");
  const [valueaa62, setValueaa62] = useState("");
  const [valueaa63, setValueaa63] = useState("");
  const [valueaa64, setValueaa64] = useState("");

  const [valueaa71, setValueaa71] = useState("");
  const [valueaa72, setValueaa72] = useState("");
  const [valueaa73, setValueaa73] = useState("");
  const [valueaa74, setValueaa74] = useState("");

  const [valueaa81, setValueaa81] = useState("");
  const [valueaa82, setValueaa82] = useState("");
  const [valueaa83, setValueaa83] = useState("");
  const [valueaa84, setValueaa84] = useState("");

  const [valueaa91, setValueaa91] = useState("");
  const [valueaa92, setValueaa92] = useState("");
  const [valueaa93, setValueaa93] = useState("");
  const [valueaa94, setValueaa94] = useState("");

  const [valueaa101, setValueaa101] = useState("");
  const [valueaa102, setValueaa102] = useState("");
  const [valueaa103, setValueaa103] = useState("");
  const [valueaa104, setValueaa104] = useState("");

  const [valueaa111, setValueaa111] = useState("");
  const [valueaa112, setValueaa112] = useState("");
  const [valueaa113, setValueaa113] = useState("");
  const [valueaa114, setValueaa114] = useState("");

  const [valueaa121, setValueaa121] = useState("");
  const [valueaa122, setValueaa122] = useState("");
  const [valueaa123, setValueaa123] = useState("");
  const [valueaa124, setValueaa124] = useState("");

  const [valueaa131, setValueaa131] = useState("");
  const [valueaa132, setValueaa132] = useState("");
  const [valueaa133, setValueaa133] = useState("");
  const [valueaa134, setValueaa134] = useState("");

  const [valueaa141, setValueaa141] = useState("");
  const [valueaa142, setValueaa142] = useState("");
  const [valueaa143, setValueaa143] = useState("");
  const [valueaa144, setValueaa144] = useState("");

  const [valueaa151, setValueaa151] = useState("");
  const [valueaa152, setValueaa152] = useState("");
  const [valueaa153, setValueaa153] = useState("");
  const [valueaa154, setValueaa154] = useState("");

  // const [valueaa161, setValueaa161] = useState("");
  const [valueaa162, setValueaa162] = useState("");
  const [valueaa163, setValueaa163] = useState("");
  const [valueaa164, setValueaa164] = useState("");
  const [valueaa165, setValueaa165] = useState("");
  const [principalComments, setPrincipalComments] = useState(null);
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState("");

  // get call
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
  const financialYear = "2021-2022";
  useEffect(
    () => fetch(
      'http://localhost:8080/api/v1/getallacademicdata?collegeId='+collegeId+'&financialYear='
          + fYear
          + '&typeofInstitution='+instituteType
    ).then((response) => response
      .json()
      .then((data) => {
        console.log(JSON.stringify(data));
        setValuead1(data[0].academicinformation[0] ? data[0].academicinformation[0].inputad11 : "");
        setValuead2(data[0].academicinformation[0] ? data[0].academicinformation[0].inputad12 : "");
        setValuead3(data[0].academicinformation[0] ? data[0].academicinformation[0].inputad13 : "");
        setValuead4(data[0].academicinformation[0] ? data[0].academicinformation[0].inputad14 : "");
        setValuead5(data[0].academicinformation[0] ? data[0].academicinformation[0].inputad15 : "");
        setValuead6(data[0].academicinformation[0] ? data[0].academicinformation[0].inputad16 : "");
        setValuead7(data[0].academicinformation[0] ? data[0].academicinformation[0].inputad17 : "");

        setValueatg1(data[0].detailsofVisitingFaculties[0] ? data[0].detailsofVisitingFaculties[0].inputatg11 : "");
        setValueatg2(data[0].detailsofVisitingFaculties[0] ? data[0].detailsofVisitingFaculties[0].inputatg12 : "");
        setValueatg3(data[0].detailsofVisitingFaculties[0] ? data[0].detailsofVisitingFaculties[0].inputatg13 : "");
        setValueatg4(data[0].detailsofVisitingFaculties[0] ? data[0].detailsofVisitingFaculties[0].inputatg14 : "");

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

        setValueatnt51(data[0].nonTeachingStaff[4] ? data[0].nonTeachingStaff[4].inputatnt11 : "");
        setValueatnt52(data[0].nonTeachingStaff[4] ? data[0].nonTeachingStaff[4].inputatnt12 : "");
        setValueatnt53(data[0].nonTeachingStaff[4] ? data[0].nonTeachingStaff[4].inputatnt13 : "");
        setValueatnt54(data[0].nonTeachingStaff[4] ? data[0].nonTeachingStaff[4].inputatnt14 : "");

        setValueatnt61(data[0].nonTeachingStaff[4] ? data[0].nonTeachingStaff[4].inputatnt11 : "");
        setValueatnt62(data[0].nonTeachingStaff[4] ? data[0].nonTeachingStaff[4].inputatnt12 : "");
        setValueatnt63(data[0].nonTeachingStaff[4] ? data[0].nonTeachingStaff[4].inputatnt13 : "");
        setValueatnt64(data[0].nonTeachingStaff[4] ? data[0].nonTeachingStaff[4].inputatnt14 : "");

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

        setValueatt51(data[0].technicalStaff[4] ? data[0].technicalStaff[4].inputatt15 : "");
        setValueatt52(data[0].technicalStaff[4] ? data[0].technicalStaff[4].inputatt16 : "");
        setValueatt53(data[0].technicalStaff[4] ? data[0].technicalStaff[4].inputatt17 : "");
        setValueatt54(data[0].technicalStaff[4] ? data[0].technicalStaff[4].inputatt18 : "");

        setValueatt61(data[0].technicalStaff[5] ? data[0].technicalStaff[5].inputatt15 : "");
        setValueatt62(data[0].technicalStaff[5] ? data[0].technicalStaff[5].inputatt16 : "");
        setValueatt63(data[0].technicalStaff[5] ? data[0].technicalStaff[5].inputatt17 : "");
        setValueatt64(data[0].technicalStaff[5] ? data[0].technicalStaff[5].inputatt18 : "");

        setValueat11(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat11 : "");
        setValueat12(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat12 : "");
        setValueat13(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat13 : "");
        setValueat14(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat14 : "");
        setValueat15(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat15 : "");
        setValueat16(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat16 : "");
        setValueat17(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat17 : "");
        setValueat18(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat18 : "");
        setValueat19(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat19 : "");
        setValueat110(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat10 : "");
        setValueat111(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat111 : "");
        setValueat112(data[0].academicinstitution[0] ? data[0].academicinstitution[0].inputat112 : "");

        setValueat21(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat11 : "");
        setValueat22(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat12 : "");
        setValueat23(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat13 : "");
        setValueat24(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat14 : "");
        setValueat25(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat15 : "");
        setValueat26(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat16 : "");
        setValueat27(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat17 : "");
        setValueat28(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat18 : "");
        setValueat29(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat19 : "");
        setValueat210(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat10 : "");
        setValueat211(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat111 : "");
        setValueat212(data[0].academicinstitution[1] ? data[0].academicinstitution[1].inputat112 : "");

        setValueat31(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat11 : "");
        setValueat32(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat12 : "");
        setValueat33(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat13 : "");
        setValueat34(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat14 : "");
        setValueat35(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat15 : "");
        setValueat36(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat16 : "");
        setValueat37(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat17 : "");
        setValueat38(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat18 : "");
        setValueat39(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat19 : "");
        setValueat310(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat10 : "");
        setValueat311(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat111 : "");
        setValueat312(data[0].academicinstitution[2] ? data[0].academicinstitution[2].inputat112 : "");

        setValueat4(data[0].academicinstitution[3] ? data[0].academicinstitution[3].inputat00 : "");

        setValueat41(data[0].academicinstitution[4] ? data[0].academicinstitution[4].inputat11 : "");
        setValueat42(data[0].academicinstitution[4] ? data[0].academicinstitution[4].inputat12 : "");
        setValueat43(data[0].academicinstitution[4] ? data[0].academicinstitution[4].inputat13 : "");
        setValueat44(data[0].academicinstitution[4] ? data[0].academicinstitution[4].inputat14 : "");
        setValueat45(data[0].academicinstitution[4] ? data[0].academicinstitution[4].inputat15 : "");
        setValueat46(data[0].academicinstitution[4] ? data[0].academicinstitution[4].inputat16 : "");
        setValueat47(data[0].academicinstitution[4] ? data[0].academicinstitution[4].inputat17 : "");
        setValueat48(data[0].academicinstitution[4] ? data[0].academicinstitution[4].inputat18 : "");
        setValueat49(data[0].academicinstitution[4] ? data[0].academicinstitution[4].inputat19 : "");
        setValueat410(data[0].academicinstitution[4] ? data[0].academicinstitution[4].inputat10 : "");
        setValueat411(data[0].academicinstitution[4] ? data[0].academicinstitution[4].inputat111 : "");
        setValueat412(data[0].academicinstitution[4] ? data[0].academicinstitution[4].inputat112 : "");

        setValueat51(data[0].academicinstitution[5] ? data[0].academicinstitution[5].inputat11 : "");
        setValueat52(data[0].academicinstitution[5] ? data[0].academicinstitution[5].inputat12 : "");
        setValueat53(data[0].academicinstitution[5] ? data[0].academicinstitution[5].inputat13 : "");
        setValueat54(data[0].academicinstitution[5] ? data[0].academicinstitution[5].inputat14 : "");
        setValueat55(data[0].academicinstitution[5] ? data[0].academicinstitution[5].inputat15 : "");
        setValueat56(data[0].academicinstitution[5] ? data[0].academicinstitution[5].inputat16 : "");
        setValueat57(data[0].academicinstitution[5] ? data[0].academicinstitution[5].inputat17 : "");
        setValueat58(data[0].academicinstitution[5] ? data[0].academicinstitution[5].inputat18 : "");
        setValueat59(data[0].academicinstitution[5] ? data[0].academicinstitution[5].inputat19 : "");
        setValueat510(data[0].academicinstitution[5] ? data[0].academicinstitution[5].inputat10 : "");
        setValueat511(data[0].academicinstitution[5] ? data[0].academicinstitution[5].inputat111 : "");
        setValueat512(data[0].academicinstitution[5] ? data[0].academicinstitution[5].inputat112 : "");

        setValueat61(data[0].academicinstitution[6] ? data[0].academicinstitution[6].inputat11 : "");
        setValueat62(data[0].academicinstitution[6] ? data[0].academicinstitution[6].inputat12 : "");
        setValueat63(data[0].academicinstitution[6] ? data[0].academicinstitution[6].inputat13 : "");
        setValueat64(data[0].academicinstitution[6] ? data[0].academicinstitution[6].inputat14 : "");
        setValueat65(data[0].academicinstitution[6] ? data[0].academicinstitution[6].inputat15 : "");
        setValueat66(data[0].academicinstitution[6] ? data[0].academicinstitution[6].inputat16 : "");
        setValueat67(data[0].academicinstitution[6] ? data[0].academicinstitution[6].inputat17 : "");
        setValueat68(data[0].academicinstitution[6] ? data[0].academicinstitution[6].inputat18 : "");
        setValueat69(data[0].academicinstitution[6] ? data[0].academicinstitution[6].inputat19 : "");
        setValueat610(data[0].academicinstitution[6] ? data[0].academicinstitution[6].inputat10 : "");
        setValueat611(data[0].academicinstitution[6] ? data[0].academicinstitution[6].inputat111 : "");
        setValueat612(data[0].academicinstitution[6] ? data[0].academicinstitution[6].inputat112 : "");

        setValueatq11(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq11 : "");
        setValueatq12(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq12 : "");
        setValueatq13(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq13 : "");
        setValueatq14(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq14 : "");
        setValueatq15(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq15 : "");
        setValueatq16(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq16 : "");
        setValueatq17(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq17 : "");
        setValueatq18(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq18 : "");
        setValueatq19(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq19 : "");
        setValueatq110(data[0].academicPerminentTeachers[0] ? data[0].academicPerminentTeachers[0].inputatq110 : "");

        setValueatq21(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq11 : "");
        setValueatq22(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq12 : "");
        setValueatq23(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq13 : "");
        setValueatq24(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq14 : "");
        setValueatq25(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq15 : "");
        setValueatq26(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq16 : "");
        setValueatq27(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq17 : "");
        setValueatq28(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq18 : "");
        setValueatq29(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq19 : "");
        setValueatq210(data[0].academicPerminentTeachers[1] ? data[0].academicPerminentTeachers[1].inputatq110 : "");

        setValueatq31(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq11 : "");
        setValueatq32(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq12 : "");
        setValueatq33(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq13 : "");
        setValueatq34(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq14 : "");
        setValueatq35(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq15 : "");
        setValueatq36(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq16 : "");
        setValueatq37(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq17 : "");
        setValueatq38(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq18 : "");
        setValueatq39(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq19 : "");
        setValueatq310(data[0].academicPerminentTeachers[2] ? data[0].academicPerminentTeachers[2].inputatq110 : "");

        setValueatq41(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq11 : "");
        setValueatq42(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq12 : "");
        setValueatq43(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq13 : "");
        setValueatq44(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq14 : "");
        setValueatq45(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq15 : "");
        setValueatq46(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq16 : "");
        setValueatq47(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq17 : "");
        setValueatq48(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq18 : "");
        setValueatq49(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq19 : "");
        setValueatq410(data[0].academicPerminentTeachers[3] ? data[0].academicPerminentTeachers[3].inputatq110 : "");

        setValueatq51(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq51 : "");
        setValueatq52(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq52 : "");
        setValueatq53(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq53 : "");
        setValueatq54(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq54 : "");
        setValueatq55(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq55 : "");
        setValueatq56(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq56 : "");
        setValueatq57(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq57 : "");
        setValueatq58(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq58 : "");
        setValueatq59(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq59 : "");
        setValueatq510(data[0].academicTemporaryTeachers[0] ? data[0].academicTemporaryTeachers[0].inputatq510 : "");

        setValueatq61(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq51 : "");
        setValueatq62(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq52 : "");
        setValueatq63(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq53 : "");
        setValueatq64(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq54 : "");
        setValueatq65(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq55 : "");
        setValueatq66(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq56 : "");
        setValueatq67(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq57 : "");
        setValueatq68(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq58 : "");
        setValueatq69(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq59 : "");
        setValueatq610(data[0].academicTemporaryTeachers[1] ? data[0].academicTemporaryTeachers[1].inputatq510 : "");

        setValueatq71(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq51 : "");
        setValueatq72(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq52 : "");
        setValueatq73(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq53 : "");
        setValueatq74(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq54 : "");
        setValueatq75(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq55 : "");
        setValueatq76(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq56 : "");
        setValueatq77(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq57 : "");
        setValueatq78(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq58 : "");
        setValueatq79(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq59 : "");
        setValueatq710(data[0].academicTemporaryTeachers[2] ? data[0].academicTemporaryTeachers[2].inputatq510 : "");

        setValueatq81(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq51 : "");
        setValueatq82(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq52 : "");
        setValueatq83(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq53 : "");
        setValueatq84(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq54 : "");
        setValueatq85(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq55 : "");
        setValueatq86(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq56 : "");
        setValueatq87(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq57 : "");
        setValueatq88(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq58 : "");
        setValueatq89(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq59 : "");
        setValueatq810(data[0].academicTemporaryTeachers[3] ? data[0].academicTemporaryTeachers[3].inputatq510 : "");

        setValueatq91(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq91 : "");
        setValueatq93(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq92 : "");
        setValueatq93(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq93 : "");
        setValueatq94(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq94 : "");
        setValueatq95(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq95 : "");
        setValueatq96(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq96 : "");
        setValueatq97(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq97 : "");
        setValueatq98(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq98 : "");
        setValueatq99(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq99 : "");
        setValueatq910(data[0].academicParttimeTeacheres[0] ? data[0].academicParttimeTeacheres[0].inputatq910 : "");

        setValueatq101(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq91 : "");
        setValueatq102(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq92 : "");
        setValueatq103(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq93 : "");
        setValueatq104(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq94 : "");
        setValueatq105(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq95 : "");
        setValueatq106(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq96 : "");
        setValueatq107(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq97 : "");
        setValueatq108(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq98 : "");
        setValueatq109(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq99 : "");
        setValueatq1010(data[0].academicParttimeTeacheres[1] ? data[0].academicParttimeTeacheres[1].inputatq910 : "");

        setValueatq111(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq91 : "");
        setValueatq112(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq92 : "");
        setValueatq113(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq93 : "");
        setValueatq114(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq94 : "");
        setValueatq115(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq95 : "");
        setValueatq116(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq96 : "");
        setValueatq117(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq97 : "");
        setValueatq118(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq98 : "");
        setValueatq119(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq99 : "");
        setValueatq1110(data[0].academicParttimeTeacheres[2] ? data[0].academicParttimeTeacheres[2].inputatq910 : "");

        setValueatq121(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq91 : "");
        setValueatq122(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq92 : "");
        setValueatq123(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq93 : "");
        setValueatq124(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq94 : "");
        setValueatq125(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq95 : "");
        setValueatq126(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq96 : "");
        setValueatq127(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq97 : "");
        setValueatq128(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq98 : "");
        setValueatq129(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq99 : "");
        setValueatq1210(data[0].academicParttimeTeacheres[3] ? data[0].academicParttimeTeacheres[3].inputatq910 : "");

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
        ///
        setValueas61(data[0].academicstudentsEnrolled[5] ? data[0].academicstudentsEnrolled[5].inputas11 : "");
        setValueas62(data[0].academicstudentsEnrolled[5] ? data[0].academicstudentsEnrolled[5].inputas12 : "");
        setValueas63(data[0].academicstudentsEnrolled[5] ? data[0].academicstudentsEnrolled[5].inputas13 : "");
        setValueas64(data[0].academicstudentsEnrolled[5] ? data[0].academicstudentsEnrolled[5].inputas14 : "");
        setValueas65(data[0].academicstudentsEnrolled[5] ? data[0].academicstudentsEnrolled[5].inputas15 : "");

        setValueaa11(data[0].academicstudentsAdmitted[0] ? data[0].academicstudentsAdmitted[0].inputaa11 : "");
        setValueaa12(data[0].academicstudentsAdmitted[0] ? data[0].academicstudentsAdmitted[0].inputaa12 : "");
        setValueaa13(data[0].academicstudentsAdmitted[0] ? data[0].academicstudentsAdmitted[0].inputaa13 : "");
        setValueaa14(data[0].academicstudentsAdmitted[0] ? data[0].academicstudentsAdmitted[0].inputaa14 : "");

        setValueaa21(data[0].academicstudentsAdmitted[1] ? data[0].academicstudentsAdmitted[1].inputaa11 : "");
        setValueaa22(data[0].academicstudentsAdmitted[1] ? data[0].academicstudentsAdmitted[1].inputaa12 : "");
        setValueaa23(data[0].academicstudentsAdmitted[1] ? data[0].academicstudentsAdmitted[1].inputaa13 : "");
        setValueaa24(data[0].academicstudentsAdmitted[1] ? data[0].academicstudentsAdmitted[1].inputaa14 : "");

        setValueaa31(data[0].academicstudentsAdmitted[2] ? data[0].academicstudentsAdmitted[2].inputaa11 : "");
        setValueaa32(data[0].academicstudentsAdmitted[2] ? data[0].academicstudentsAdmitted[2].inputaa12 : "");
        setValueaa33(data[0].academicstudentsAdmitted[2] ? data[0].academicstudentsAdmitted[2].inputaa13 : "");
        setValueaa34(data[0].academicstudentsAdmitted[2] ? data[0].academicstudentsAdmitted[2].inputaa14 : "");

        setValueaa41(data[0].academicstudentsAdmitted[3] ? data[0].academicstudentsAdmitted[3].inputaa11 : "");
        setValueaa42(data[0].academicstudentsAdmitted[3] ? data[0].academicstudentsAdmitted[3].inputaa12 : "");
        setValueaa43(data[0].academicstudentsAdmitted[3] ? data[0].academicstudentsAdmitted[3].inputaa13 : "");
        setValueaa44(data[0].academicstudentsAdmitted[3] ? data[0].academicstudentsAdmitted[3].inputaa14 : "");

        setValueaa51(data[0].academicstudentsAdmitted[4] ? data[0].academicstudentsAdmitted[4].inputaa11 : "");
        setValueaa52(data[0].academicstudentsAdmitted[4] ? data[0].academicstudentsAdmitted[4].inputaa12 : "");
        setValueaa53(data[0].academicstudentsAdmitted[4] ? data[0].academicstudentsAdmitted[4].inputaa13 : "");
        setValueaa54(data[0].academicstudentsAdmitted[4] ? data[0].academicstudentsAdmitted[4].inputaa14 : "");

        setValueaa61(data[0].academicstudentsAdmitted[5] ? data[0].academicstudentsAdmitted[5].inputaa11 : "");
        setValueaa62(data[0].academicstudentsAdmitted[5] ? data[0].academicstudentsAdmitted[5].inputaa12 : "");
        setValueaa63(data[0].academicstudentsAdmitted[5] ? data[0].academicstudentsAdmitted[5].inputaa13 : "");
        setValueaa64(data[0].academicstudentsAdmitted[5] ? data[0].academicstudentsAdmitted[5].inputaa14 : "");

        setValueaa71(data[0].academicstudentsAdmitted[6] ? data[0].academicstudentsAdmitted[6].inputaa11 : "");
        setValueaa72(data[0].academicstudentsAdmitted[6] ? data[0].academicstudentsAdmitted[6].inputaa12 : "");
        setValueaa73(data[0].academicstudentsAdmitted[6] ? data[0].academicstudentsAdmitted[6].inputaa13 : "");
        setValueaa74(data[0].academicstudentsAdmitted[6] ? data[0].academicstudentsAdmitted[6].inputaa14 : "");

        setValueaa81(data[0].academicstudentsAdmitted[7] ? data[0].academicstudentsAdmitted[7].inputaa11 : "");
        setValueaa82(data[0].academicstudentsAdmitted[7] ? data[0].academicstudentsAdmitted[7].inputaa12 : "");
        setValueaa83(data[0].academicstudentsAdmitted[7] ? data[0].academicstudentsAdmitted[7].inputaa13 : "");
        setValueaa84(data[0].academicstudentsAdmitted[7] ? data[0].academicstudentsAdmitted[7].inputaa14 : "");

        setValueaa91(data[0].academicstudentsAdmitted[8] ? data[0].academicstudentsAdmitted[8].inputaa11 : "");
        setValueaa92(data[0].academicstudentsAdmitted[8] ? data[0].academicstudentsAdmitted[8].inputaa12 : "");
        setValueaa93(data[0].academicstudentsAdmitted[8] ? data[0].academicstudentsAdmitted[8].inputaa13 : "");
        setValueaa94(data[0].academicstudentsAdmitted[8] ? data[0].academicstudentsAdmitted[8].inputaa14 : "");

        setValueaa101(data[0].academicstudentsAdmitted[9] ? data[0].academicstudentsAdmitted[9].inputaa11 : "");
        setValueaa102(data[0].academicstudentsAdmitted[9] ? data[0].academicstudentsAdmitted[9].inputaa12 : "");
        setValueaa103(data[0].academicstudentsAdmitted[9] ? data[0].academicstudentsAdmitted[9].inputaa13 : "");
        setValueaa104(data[0].academicstudentsAdmitted[9] ? data[0].academicstudentsAdmitted[9].inputaa14 : "");

        setValueaa111(data[0].academicstudentsAdmitted[10] ? data[0].academicstudentsAdmitted[10].inputaa11 : "");
        setValueaa112(data[0].academicstudentsAdmitted[10] ? data[0].academicstudentsAdmitted[10].inputaa12 : "");
        setValueaa113(data[0].academicstudentsAdmitted[10] ? data[0].academicstudentsAdmitted[10].inputaa13 : "");
        setValueaa114(data[0].academicstudentsAdmitted[10] ? data[0].academicstudentsAdmitted[10].inputaa14 : "");

        setValueaa121(data[0].academicstudentsAdmitted[11] ? data[0].academicstudentsAdmitted[11].inputaa11 : "");
        setValueaa122(data[0].academicstudentsAdmitted[11] ? data[0].academicstudentsAdmitted[11].inputaa12 : "");
        setValueaa123(data[0].academicstudentsAdmitted[11] ? data[0].academicstudentsAdmitted[11].inputaa13 : "");
        setValueaa124(data[0].academicstudentsAdmitted[11] ? data[0].academicstudentsAdmitted[11].inputaa14 : "");

        setValueaa131(data[0].academicstudentsAdmitted[12] ? data[0].academicstudentsAdmitted[12].inputaa11 : "");
        setValueaa132(data[0].academicstudentsAdmitted[12] ? data[0].academicstudentsAdmitted[12].inputaa12 : "");
        setValueaa133(data[0].academicstudentsAdmitted[12] ? data[0].academicstudentsAdmitted[12].inputaa13 : "");
        setValueaa134(data[0].academicstudentsAdmitted[12] ? data[0].academicstudentsAdmitted[12].inputaa14 : "");

        setValueaa141(data[0].academicstudentsAdmitted[13] ? data[0].academicstudentsAdmitted[13].inputaa11 : "");
        setValueaa142(data[0].academicstudentsAdmitted[13] ? data[0].academicstudentsAdmitted[13].inputaa12 : "");
        setValueaa143(data[0].academicstudentsAdmitted[13] ? data[0].academicstudentsAdmitted[13].inputaa13 : "");
        setValueaa144(data[0].academicstudentsAdmitted[13] ? data[0].academicstudentsAdmitted[13].inputaa14 : "");

        setValueaa151(data[0].academicstudentsAdmitted[14] ? data[0].academicstudentsAdmitted[14].inputaa11 : "");
        setValueaa152(data[0].academicstudentsAdmitted[14] ? data[0].academicstudentsAdmitted[14].inputaa12 : "");
        setValueaa153(data[0].academicstudentsAdmitted[14] ? data[0].academicstudentsAdmitted[14].inputaa13 : "");
        setValueaa154(data[0].academicstudentsAdmitted[14] ? data[0].academicstudentsAdmitted[14].inputaa14 : "");

        // setValueaa161(data[0].academicstudentsAdmitted[15].inputaa11);
        setValueaa162(data[0].academicstudentsAdmitted[15] ? data[0].academicstudentsAdmitted[15].inputaa11 : "");
        setValueaa163(data[0].academicstudentsAdmitted[15] ? data[0].academicstudentsAdmitted[15].inputaa12 : "");
        setValueaa164(data[0].academicstudentsAdmitted[15] ? data[0].academicstudentsAdmitted[15].inputaa13 : "");
        setValueaa165(data[0].academicstudentsAdmitted[15] ? data[0].academicstudentsAdmitted[15].inputaa14 : "");
      })
      .catch((error) => {
        console.error("Error:", error);
      })
    ),
    []
  );

  let role = null;
  let email = null;
  // eslint-disable-next-line prefer-destructuring, no-undef
  role = AuthService.getCurrentUser().roles[0];
  // eslint-disable-next-line no-undef
  email = AuthService.getCurrentUser().email;
  const finacialyear = "2021-2022";
  const authorize = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    assignedTo: email,
    assignedBy: email,
    principalStatus: "A",
    programmerId:"AccademicInformation"
  };

  const rejectContent = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    assignedTo: "anamita1996@gmail.com",
    assignedBy: email,
    principalComments: rejectReasonComments,
    principalStatus: "R",
    programmerId:"AccademicInformation"
  };
  // eslint-disable-next-line no-redeclare
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }
  function getAuthorizeAcademicinfo() {
    console.log("Authorize IIQA");
    const authAPIMethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(authorize),
    };
    fetch(
      resources.APPLICATION_URL
        + "principalAuthorizedEmail",
      authAPIMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record Authorized Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }
  function getRejectAcademicinfo() {
    console.log("Assigned");
    const rejectAPImethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(rejectContent),
    };
    fetch(
      resources.APPLICATION_URL
        + 'principalRejectEmail?institutionType='+instituteType,
        
      rejectAPImethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Rejected Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }

  return (
    <div className="main-container">
      <h1 className="main-heading-style">Accademic Information</h1>
      <div className="eachTable-container">
        <form>
          <table>
            <tr>
              <th colspan="7">
                Details of the Programmes Offered by the College (Given Data for
                Current Academic year)
              </th>
            </tr>
            <tr>
              <td>Level of Programme</td>
              <td>Name of Programme/Course</td>
              <td>Duration of Months</td>
              <td>Entry Qualification</td>
              <td>Medium of Instruction</td>
              <td>Sanctioned Strength</td>
              <td>No. Of Students Admitted</td>
            </tr>
            <tr>
              <td>
                <input
                  readonly
                  type="text"
                  id="ad1"
                  value={valuead1}
                  onChange={(e) => setValuead1(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="ad2"
                  value={valuead2}
                  onChange={(e) => setValuead2(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="ad3"
                  value={valuead3}
                  onChange={(e) => setValuead3(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="ad4"
                  value={valuead4}
                  onChange={(e) => setValuead4(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="ad5"
                  value={valuead5}
                  onChange={(e) => setValuead5(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="ad6"
                  value={valuead6}
                  onChange={(e) => setValuead6(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="ad7"
                  value={valuead7}
                  onChange={(e) => setValuead7(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1">
            Details of Teaching & Non-Teaching Staff of Institution
          </label>
          <br />
          <lable htmlFor="academicInfo-t1">Teaching Faculty</lable>
          <table>
            <tr>
              <th rowspan="2" style={{ width: "16%" }}></th>
              <th colspan="4">Professor</th>
              <th colspan="4">Associate Professor</th>
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
              <th>Sanctioned by the UGC/ institution/ State Government</th>
              <td>
                <input
                  readonly
                  type="number"
                  style={{ height: "100%" }}
                  id="at11"
                  value={valueat11}
                  onChange={(e) => setValueat11(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at12"
                  value={valueat12}
                  onChange={(e) => setValueat12(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at13"
                  value={valueat13}
                  onChange={(e) => setValueat13(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at14"
                  value={valueat14}
                  onChange={(e) => setValueat14(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at15"
                  value={valueat15}
                  onChange={(e) => setValueat15(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at16"
                  value={valueat16}
                  onChange={(e) => setValueat16(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at17"
                  value={valueat17}
                  onChange={(e) => setValueat17(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at18"
                  value={valueat18}
                  onChange={(e) => setValueat18(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at19"
                  value={valueat19}
                  onChange={(e) => setValueat19(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at110"
                  value={valueat110}
                  onChange={(e) => setValueat110(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at111"
                  value={valueat111}
                  onChange={(e) => setValueat111(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at112"
                  value={valueat112}
                  onChange={(e) => setValueat112(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Recruited</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="at21"
                  value={valueat21}
                  onChange={(e) => setValueat21(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at22"
                  value={valueat22}
                  onChange={(e) => setValueat22(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at23"
                  value={valueat23}
                  onChange={(e) => setValueat23(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at24"
                  value={valueat24}
                  onChange={(e) => setValueat24(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at25"
                  value={valueat25}
                  onChange={(e) => setValueat25(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at26"
                  value={valueat26}
                  onChange={(e) => setValueat26(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at27"
                  value={valueat27}
                  onChange={(e) => setValueat27(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at28"
                  value={valueat28}
                  onChange={(e) => setValueat28(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at29"
                  value={valueat29}
                  onChange={(e) => setValueat29(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at210"
                  value={valueat210}
                  onChange={(e) => setValueat210(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at211"
                  value={valueat211}
                  onChange={(e) => setValueat211(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at212"
                  value={valueat212}
                  onChange={(e) => setValueat212(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="at31"
                  value={valueat31}
                  onChange={(e) => setValueat31(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at32"
                  value={valueat32}
                  onChange={(e) => setValueat32(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at33"
                  value={valueat33}
                  onChange={(e) => setValueat33(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at34"
                  value={valueat34}
                  onChange={(e) => setValueat34(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at35"
                  value={valueat35}
                  onChange={(e) => setValueat35(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at36"
                  value={valueat36}
                  onChange={(e) => setValueat36(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at37"
                  value={valueat37}
                  onChange={(e) => setValueat37(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at38"
                  value={valueat38}
                  onChange={(e) => setValueat38(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at39"
                  value={valueat39}
                  onChange={(e) => setValueat39(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at310"
                  value={valueat310}
                  onChange={(e) => setValueat310(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  value={valueat311}
                  id="at311"
                  onChange={(e) => setValueat311(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at312"
                  value={valueat312}
                  onChange={(e) => setValueat312(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>On Contract</th>
              <td colspan="12">
                <input
                  readonly
                  type="number"
                  id="at4"
                  value={valueat4}
                  onChange={(e) => setValueat4(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Sanctioned by the Management/ Society/ or other Authorised Body
              </th>
              <td>
                <input
                  readonly
                  type="number"
                  id="at41"
                  value={valueat41}
                  onChange={(e) => setValueat41(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at42"
                  value={valueat42}
                  onChange={(e) => setValueat42(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at43"
                  value={valueat43}
                  onChange={(e) => setValueat43(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at44"
                  value={valueat44}
                  onChange={(e) => setValueat44(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at45"
                  value={valueat45}
                  onChange={(e) => setValueat45(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at46"
                  value={valueat46}
                  onChange={(e) => setValueat46(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at47"
                  value={valueat47}
                  onChange={(e) => setValueat47(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at48"
                  value={valueat48}
                  onChange={(e) => setValueat48(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at49"
                  value={valueat49}
                  onChange={(e) => setValueat49(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at410"
                  value={valueat410}
                  onChange={(e) => setValueat410(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at411"
                  value={valueat411}
                  onChange={(e) => setValueat411(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at412"
                  value={valueat412}
                  onChange={(e) => setValueat412(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Recruited</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="at51"
                  value={valueat51}
                  onChange={(e) => setValueat51(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at52"
                  value={valueat52}
                  onChange={(e) => setValueat52(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at53"
                  value={valueat53}
                  onChange={(e) => setValueat53(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at54"
                  value={valueat54}
                  onChange={(e) => setValueat54(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at55"
                  value={valueat55}
                  onChange={(e) => setValueat55(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at56"
                  value={valueat56}
                  onChange={(e) => setValueat56(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at57"
                  value={valueat57}
                  onChange={(e) => setValueat57(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at58"
                  value={valueat58}
                  onChange={(e) => setValueat58(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at59"
                  value={valueat59}
                  onChange={(e) => setValueat59(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at510"
                  value={valueat510}
                  onChange={(e) => setValueat510(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at511"
                  value={valueat511}
                  onChange={(e) => setValueat511(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at512"
                  value={valueat512}
                  onChange={(e) => setValueat512(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="at61"
                  value={valueat61}
                  onChange={(e) => setValueat61(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at62"
                  value={valueat62}
                  onChange={(e) => setValueat62(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at63"
                  value={valueat63}
                  onChange={(e) => setValueat63(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at64"
                  value={valueat64}
                  onChange={(e) => setValueat64(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at65"
                  value={valueat65}
                  onChange={(e) => setValueat65(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at66"
                  value={valueat66}
                  onChange={(e) => setValueat66(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at67"
                  value={valueat67}
                  onChange={(e) => setValueat67(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at68"
                  value={valueat68}
                  onChange={(e) => setValueat68(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at69"
                  value={valueat69}
                  onChange={(e) => setValueat69(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at610"
                  value={valueat610}
                  onChange={(e) => setValueat610(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at611"
                  value={valueat611}
                  onChange={(e) => setValueat611(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="at612"
                  value={valueat612}
                  onChange={(e) => setValueat612(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1">Non-Teaching Staff</label>
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
                <input
                  readonly
                  type="number"
                  id="atnt11"
                  value={valueatnt11}
                  onChange={(e) => setValueatnt11(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt12"
                  value={valueatnt12}
                  onChange={(e) => setValueatnt12(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt13"
                  value={valueatnt13}
                  onChange={(e) => setValueatnt13(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt14"
                  value={valueatnt14}
                  onChange={(e) => setValueatnt14(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Recruited</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt21"
                  value={valueatnt21}
                  onChange={(e) => setValueatnt21(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt22"
                  value={valueatnt22}
                  onChange={(e) => setValueatnt22(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt23"
                  value={valueatnt23}
                  onChange={(e) => setValueatnt23(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt24"
                  value={valueatnt24}
                  onChange={(e) => setValueatnt24(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt31"
                  value={valueatnt31}
                  onChange={(e) => setValueatnt31(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt32"
                  value={valueatnt32}
                  onChange={(e) => setValueatnt32(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt33"
                  value={valueatnt33}
                  onChange={(e) => setValueatnt33(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt34"
                  value={valueatnt34}
                  onChange={(e) => setValueatnt34(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Sanctioned by the Management/ Society/ or other Authorised Body
              </th>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt41"
                  value={valueatnt41}
                  onChange={(e) => setValueatnt41(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  value={valueatnt42}
                  id="atnt42"
                  onChange={(e) => setValueatnt42(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt43"
                  value={valueatnt43}
                  onChange={(e) => setValueatnt43(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt44"
                  value={valueatnt44}
                  onChange={(e) => setValueatnt44(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Recruited</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt51"
                  value={valueatnt51}
                  onChange={(e) => setValueatnt51(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt52"
                  value={valueatnt52}
                  onChange={(e) => setValueatnt52(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt53"
                  value={valueatnt53}
                  onChange={(e) => setValueatnt53(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt54"
                  value={valueatnt54}
                  onChange={(e) => setValueatnt54(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt61"
                  value={valueatnt61}
                  onChange={(e) => setValueatnt61(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt62"
                  value={valueatnt62}
                  onChange={(e) => setValueatnt62(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt63"
                  value={valueatnt63}
                  onChange={(e) => setValueatnt63(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atnt64"
                  value={valueatnt64}
                  onChange={(e) => setValueatnt64(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1">Technical Staff</label>
          <table>
            <tr>
              <th></th>
              <th>Male</th>
              <th>Female</th>
              <th>Others</th>
              <th>Total</th>
            </tr>
            <tr>
              <th>Sanctioned by the UGC/ institution/ State Government</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="att11"
                  value={valueatt11}
                  onChange={(e) => setValueatt11(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att12"
                  value={valueatt12}
                  onChange={(e) => setValueatt12(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att13"
                  value={valueatt13}
                  onChange={(e) => setValueatt13(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att14"
                  value={valueatt14}
                  onChange={(e) => setValueatt14(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Recruited</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="att21"
                  value={valueatt21}
                  onChange={(e) => setValueatt21(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att22"
                  value={valueatt22}
                  onChange={(e) => setValueatt22(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att23"
                  value={valueatt23}
                  onChange={(e) => setValueatt23(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att24"
                  value={valueatt24}
                  onChange={(e) => setValueatt24(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="att31"
                  value={valueatt31}
                  onChange={(e) => setValueatt31(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att32"
                  value={valueatt32}
                  onChange={(e) => setValueatt32(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att33"
                  value={valueatt33}
                  onChange={(e) => setValueatt33(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att34"
                  value={valueatt34}
                  onChange={(e) => setValueatt34(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Sanctioned by the Management/ Society/ or other Authorised Body
              </th>
              <td>
                <input
                  readonly
                  type="number"
                  id="att41"
                  value={valueatt41}
                  onChange={(e) => setValueatt41(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att42"
                  value={valueatt42}
                  onChange={(e) => setValueatt42(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att43"
                  value={valueatt43}
                  onChange={(e) => setValueatt43(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att44"
                  value={valueatt44}
                  onChange={(e) => setValueatt44(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Recruit</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="att51"
                  value={valueatt51}
                  onChange={(e) => setValueatt51(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att52"
                  value={valueatt52}
                  onChange={(e) => setValueatt52(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att53"
                  value={valueatt53}
                  onChange={(e) => setValueatt53(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att54"
                  value={valueatt54}
                  onChange={(e) => setValueatt54(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="att61"
                  value={valueatt61}
                  onChange={(e) => setValueatt61(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att62"
                  value={valueatt62}
                  onChange={(e) => setValueatt62(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att63"
                  value={valueatt63}
                  onChange={(e) => setValueatt63(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="att64"
                  value={valueatt64}
                  onChange={(e) => setValueatt64(e.target.value)}
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
                <input
                  readonly
                  type="number"
                  id="atq11"
                  value={valueatq11}
                  onChange={(e) => setValueatq11(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq12"
                  value={valueatq12}
                  onChange={(e) => setValueatq12(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq13"
                  value={valueatq13}
                  onChange={(e) => setValueatq13(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq14"
                  value={valueatq14}
                  onChange={(e) => setValueatq14(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq15"
                  value={valueatq15}
                  onChange={(e) => setValueatq15(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq16"
                  value={valueatq16}
                  onChange={(e) => setValueatq16(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq17"
                  value={valueatq17}
                  onChange={(e) => setValueatq17(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq18"
                  value={valueatq18}
                  onChange={(e) => setValueatq18(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq19"
                  value={valueatq19}
                  onChange={(e) => setValueatq19(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq110"
                  value={valueatq110}
                  onChange={(e) => setValueatq110(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Ph.D.</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq21"
                  value={valueatq21}
                  onChange={(e) => setValueatq21(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq22"
                  value={valueatq22}
                  onChange={(e) => setValueatq22(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq23"
                  value={valueatq23}
                  onChange={(e) => setValueatq23(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq24"
                  value={valueatq24}
                  onChange={(e) => setValueatq24(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq25"
                  value={valueatq25}
                  onChange={(e) => setValueatq25(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq26"
                  value={valueatq26}
                  onChange={(e) => setValueatq26(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq27"
                  value={valueatq27}
                  onChange={(e) => setValueatq27(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq28"
                  value={valueatq28}
                  onChange={(e) => setValueatq28(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq29"
                  value={valueatq29}
                  onChange={(e) => setValueatq29(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq210"
                  value={valueatq210}
                  onChange={(e) => setValueatq210(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>M.Phil.</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq31"
                  value={valueatq31}
                  onChange={(e) => setValueatq31(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq32"
                  value={valueatq32}
                  onChange={(e) => setValueatq32(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq33"
                  value={valueatq33}
                  onChange={(e) => setValueatq33(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq34"
                  value={valueatq34}
                  onChange={(e) => setValueatq34(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq35"
                  value={valueatq35}
                  onChange={(e) => setValueatq35(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq36"
                  value={valueatq36}
                  onChange={(e) => setValueatq36(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  value={valueatq37}
                  id="atq37"
                  onChange={(e) => setValueatq37(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq38"
                  value={valueatq38}
                  onChange={(e) => setValueatq38(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq39"
                  value={valueatq39}
                  onChange={(e) => setValueatq39(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq310"
                  value={valueatq310}
                  onChange={(e) => setValueatq310(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq41"
                  value={valueatq41}
                  onChange={(e) => setValueatq41(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq42"
                  value={valueatq42}
                  onChange={(e) => setValueatq42(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq43"
                  value={valueatq43}
                  onChange={(e) => setValueatq43(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq44"
                  value={valueatq44}
                  onChange={(e) => setValueatq44(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq45"
                  value={valueatq45}
                  onChange={(e) => setValueatq45(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq46"
                  value={valueatq46}
                  onChange={(e) => setValueatq46(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq47"
                  value={valueatq47}
                  onChange={(e) => setValueatq47(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq48"
                  value={valueatq48}
                  onChange={(e) => setValueatq48(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq49"
                  value={valueatq49}
                  onChange={(e) => setValueatq49(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq410"
                  value={valueatq410}
                  onChange={(e) => setValueatq410(e.target.value)}
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
                <input
                  readonly
                  type="number"
                  id="atq51"
                  value={valueatq51}
                  onChange={(e) => setValueatq51(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  value={valueatq52}
                  id="atq52"
                  onChange={(e) => setValueatq52(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq53"
                  value={valueatq53}
                  onChange={(e) => setValueatq53(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq54"
                  value={valueatq54}
                  onChange={(e) => setValueatq54(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq55"
                  value={valueatq55}
                  onChange={(e) => setValueatq55(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq56"
                  value={valueatq56}
                  onChange={(e) => setValueatq56(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq57"
                  value={valueatq57}
                  onChange={(e) => setValueatq57(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq58"
                  value={valueatq58}
                  onChange={(e) => setValueatq58(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq59"
                  value={valueatq59}
                  onChange={(e) => setValueatq59(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq510"
                  value={valueatq510}
                  onChange={(e) => setValueatq510(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Ph.D.</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq61"
                  value={valueatq61}
                  onChange={(e) => setValueatq61(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq62"
                  value={valueatq62}
                  onChange={(e) => setValueatq62(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq63"
                  value={valueatq63}
                  onChange={(e) => setValueatq63(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq64"
                  value={valueatq64}
                  onChange={(e) => setValueatq64(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq65"
                  value={valueatq65}
                  onChange={(e) => setValueatq65(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq66"
                  value={valueatq66}
                  onChange={(e) => setValueatq66(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq67"
                  value={valueatq67}
                  onChange={(e) => setValueatq67(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq68"
                  value={valueatq68}
                  onChange={(e) => setValueatq68(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq69"
                  value={valueatq69}
                  onChange={(e) => setValueatq69(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq610"
                  value={valueatq610}
                  onChange={(e) => setValueatq610(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>M.Phil.</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq71"
                  value={valueatq71}
                  onChange={(e) => setValueatq71(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq72"
                  value={valueatq72}
                  onChange={(e) => setValueatq72(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq73"
                  value={valueatq73}
                  onChange={(e) => setValueatq73(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq74"
                  value={valueatq74}
                  onChange={(e) => setValueatq74(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq75"
                  value={valueatq75}
                  onChange={(e) => setValueatq75(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq76"
                  value={valueatq76}
                  onChange={(e) => setValueatq76(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq77"
                  value={valueatq77}
                  onChange={(e) => setValueatq77(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq78"
                  value={valueatq78}
                  onChange={(e) => setValueatq78(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq79"
                  value={valueatq79}
                  onChange={(e) => setValueatq79(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq710"
                  value={valueatq710}
                  onChange={(e) => setValueatq710(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq81"
                  value={valueatq81}
                  onChange={(e) => setValueatq81(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq82"
                  value={valueatq82}
                  onChange={(e) => setValueatq82(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq83"
                  value={valueatq83}
                  onChange={(e) => setValueatq83(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq84"
                  value={valueatq84}
                  onChange={(e) => setValueatq84(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq85"
                  value={valueatq85}
                  onChange={(e) => setValueatq85(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq86"
                  value={valueatq86}
                  onChange={(e) => setValueatq86(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq87"
                  value={valueatq87}
                  onChange={(e) => setValueatq87(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq88"
                  value={valueatq88}
                  onChange={(e) => setValueatq88(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq89"
                  value={valueatq89}
                  onChange={(e) => setValueatq89(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq810"
                  value={valueatq810}
                  onChange={(e) => setValueatq810(e.target.value)}
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
                <input
                  readonly
                  type="number"
                  id="atq91"
                  value={valueatq91}
                  onChange={(e) => setValueatq91(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq92"
                  value={valueatq92}
                  onChange={(e) => setValueatq92(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq93"
                  value={valueatq93}
                  onChange={(e) => setValueatq93(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq94"
                  value={valueatq94}
                  onChange={(e) => setValueatq94(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq95"
                  value={valueatq95}
                  onChange={(e) => setValueatq95(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq96"
                  value={valueatq96}
                  onChange={(e) => setValueatq96(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq97"
                  value={valueatq97}
                  onChange={(e) => setValueatq97(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq98"
                  value={valueatq98}
                  onChange={(e) => setValueatq98(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq99"
                  value={valueatq99}
                  onChange={(e) => setValueatq99(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq910"
                  value={valueatq910}
                  onChange={(e) => setValueatq910(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Ph.D.</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq101"
                  value={valueatq101}
                  onChange={(e) => setValueatq101(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq102"
                  value={valueatq102}
                  onChange={(e) => setValueatq102(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq103"
                  value={valueatq103}
                  onChange={(e) => setValueatq103(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq104"
                  value={valueatq104}
                  onChange={(e) => setValueatq104(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq105"
                  value={valueatq105}
                  onChange={(e) => setValueatq105(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq106"
                  value={valueatq106}
                  onChange={(e) => setValueatq106(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq107"
                  value={valueatq107}
                  onChange={(e) => setValueatq107(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq108"
                  value={valueatq108}
                  onChange={(e) => setValueatq108(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq109"
                  value={valueatq109}
                  onChange={(e) => setValueatq109(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq110"
                  value={valueatq110}
                  onChange={(e) => setValueatq110(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th> M.Phil.</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq111"
                  value={valueatq111}
                  onChange={(e) => setValueatq111(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq112"
                  value={valueatq112}
                  onChange={(e) => setValueatq112(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq113"
                  value={valueatq113}
                  onChange={(e) => setValueatq113(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq114"
                  value={valueatq114}
                  onChange={(e) => setValueatq114(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq115"
                  value={valueatq115}
                  onChange={(e) => setValueatq115(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq116"
                  value={valueatq116}
                  onChange={(e) => setValueatq116(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq117"
                  value={valueatq117}
                  onChange={(e) => setValueatq117(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq118"
                  value={valueatq118}
                  onChange={(e) => setValueatq118(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq119"
                  value={valueatq119}
                  onChange={(e) => setValueatq119(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq1110"
                  value={valueatq1110}
                  onChange={(e) => setValueatq1110(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq121"
                  value={valueatq121}
                  onChange={(e) => setValueatq121(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq122"
                  value={valueatq122}
                  onChange={(e) => setValueatq122(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq123"
                  value={valueatq123}
                  onChange={(e) => setValueatq123(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq124"
                  value={valueatq124}
                  onChange={(e) => setValueatq124(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq125"
                  value={valueatq125}
                  onChange={(e) => setValueatq125(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq126"
                  value={valueatq126}
                  onChange={(e) => setValueatq126(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq127"
                  value={valueatq127}
                  onChange={(e) => setValueatq127(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq128"
                  value={valueatq128}
                  onChange={(e) => setValueatq128(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq129"
                  value={valueatq129}
                  onChange={(e) => setValueatq129(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atq1210"
                  value={valueatq1210}
                  onChange={(e) => setValueatq1210(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1">
            Details of Visiting/ Guest Faculties:
          </label>
          <table>
            <tr>
              <th rowspan="2">
                Number of Visiting/ Guest Faculty engaged With the college
              </th>
              <th>Male</th>
              <th>Female</th>
              <th>Others</th>
              <th>Total</th>
            </tr>
            <tr>
              <td>
                <input
                  readonly
                  type="number"
                  id="atg1"
                  value={valueatg1}
                  onChange={(e) => setValueatg1(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atg2"
                  value={valueatg2}
                  onChange={(e) => setValueatg2(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atg3"
                  value={valueatg3}
                  onChange={(e) => setValueatg3(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="atg4"
                  value={valueatg4}
                  onChange={(e) => setValueatg4(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1">
            Provide the following details of students enrolled in the college
            during the current academic year
          </label>
          <table>
            <tr>
              <th colspan="2" style={{ width: "18%" }}>
                Programme
              </th>
              <th>From the State where College is Located</th>
              <th>From Other States of India</th>
              <th>NRI Students</th>
              <th>Foreign Students</th>
              <th>Total</th>
            </tr>
            <tr>
              <th rowspan="4">PG</th>
            </tr>
            <tr>
              <td>Male</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as11"
                  value={valueas11}
                  onChange={(e) => setValueas11(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as12"
                  value={valueas12}
                  onChange={(e) => setValueas12(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as13"
                  value={valueas13}
                  onChange={(e) => setValueas13(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  value={valueas14}
                  id="as14"
                  onChange={(e) => setValueas14(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as15"
                  value={valueas15}
                  onChange={(e) => setValueas15(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as21"
                  value={valueas21}
                  onChange={(e) => setValueas21(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as22"
                  value={valueas22}
                  onChange={(e) => setValueas22(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as23"
                  value={valueas23}
                  onChange={(e) => setValueas23(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as24"
                  value={valueas24}
                  onChange={(e) => setValueas24(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as25"
                  value={valueas25}
                  onChange={(e) => setValueas25(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as31"
                  value={valueas31}
                  onChange={(e) => setValueas31(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as32"
                  value={valueas32}
                  onChange={(e) => setValueas32(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as33"
                  value={valueas33}
                  onChange={(e) => setValueas33(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id=""
                  value={valueas34}
                  onChange={(e) => setValueas34(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
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
                <input
                  readonly
                  type="number"
                  id="as41"
                  value={valueas41}
                  onChange={(e) => setValueas41(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as42"
                  value={valueas42}
                  onChange={(e) => setValueas42(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as43"
                  value={valueas43}
                  onChange={(e) => setValueas43(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as44"
                  value={valueas44}
                  onChange={(e) => setValueas44(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as45"
                  value={valueas45}
                  onChange={(e) => setValueas45(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as51"
                  value={valueas51}
                  onChange={(e) => setValueas51(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as52"
                  value={valueas52}
                  onChange={(e) => setValueas52(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as53"
                  value={valueas53}
                  onChange={(e) => setValueas53(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as54"
                  value={valueas54}
                  onChange={(e) => setValueas54(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as55"
                  value={valueas55}
                  onChange={(e) => setValueas55(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as61"
                  value={valueas61}
                  onChange={(e) => setValueas61(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as62"
                  value={valueas62}
                  onChange={(e) => setValueas62(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as63"
                  value={valueas63}
                  onChange={(e) => setValueas63(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as64"
                  value={valueas64}
                  onChange={(e) => setValueas64(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="as65"
                  value={valueas65}
                  onChange={(e) => setValueas65(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1">
            Provide the following details of students admitted to the college
            during the last four academic year
          </label>
          <table>
            <tr>
              <th colspan="2" style={{ width: "18%" }}>
                Programme
              </th>
              <th>Year 1</th>
              <th>Year 2</th>
              <th>Year 3</th>
              <th>Year 4</th>
            </tr>
            <tr>
              <th rowspan="4" style={{ width: "12%" }}>
                SC
              </th>
            </tr>
            <tr>
              <td style={{ width: "12%" }}>Male</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa11"
                  value={valueaa11}
                  onChange={(e) => setValueaa11(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa12"
                  value={valueaa12}
                  onChange={(e) => setValueaa12(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa13"
                  value={valueaa13}
                  onChange={(e) => setValueaa13(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa14"
                  value={valueaa14}
                  onChange={(e) => setValueaa14(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa21"
                  value={valueaa21}
                  onChange={(e) => setValueaa21(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa22"
                  value={valueaa22}
                  onChange={(e) => setValueaa22(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa23"
                  value={valueaa23}
                  onChange={(e) => setValueaa23(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa24"
                  value={valueaa24}
                  onChange={(e) => setValueaa24(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa31"
                  value={valueaa31}
                  onChange={(e) => setValueaa31(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa32"
                  value={valueaa32}
                  onChange={(e) => setValueaa32(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa33"
                  value={valueaa33}
                  onChange={(e) => setValueaa33(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa34"
                  value={valueaa34}
                  onChange={(e) => setValueaa34(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th rowspan="4">ST</th>
            </tr>
            <tr>
              <td>Male</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa41"
                  value={valueaa41}
                  onChange={(e) => setValueaa41(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa42"
                  value={valueaa42}
                  onChange={(e) => setValueaa42(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa43"
                  value={valueaa43}
                  onChange={(e) => setValueaa43(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa44"
                  value={valueaa44}
                  onChange={(e) => setValueaa44(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa51"
                  value={valueaa51}
                  onChange={(e) => setValueaa51(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa52"
                  value={valueaa52}
                  onChange={(e) => setValueaa52(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa53"
                  value={valueaa53}
                  onChange={(e) => setValueaa53(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa54"
                  value={valueaa54}
                  onChange={(e) => setValueaa54(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa61"
                  value={valueaa61}
                  onChange={(e) => setValueaa61(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa62"
                  value={valueaa62}
                  onChange={(e) => setValueaa62(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa63"
                  value={valueaa63}
                  onChange={(e) => setValueaa63(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa64"
                  value={valueaa64}
                  onChange={(e) => setValueaa64(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th rowspan="4">OBC</th>
            </tr>
            <tr>
              <td>Male</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa71"
                  value={valueaa71}
                  onChange={(e) => setValueaa71(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  value={valueaa72}
                  id="aa72"
                  onChange={(e) => setValueaa72(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa73"
                  value={valueaa73}
                  onChange={(e) => setValueaa73(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa74"
                  value={valueaa74}
                  onChange={(e) => setValueaa74(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa81"
                  value={valueaa81}
                  onChange={(e) => setValueaa81(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa82"
                  value={valueaa82}
                  onChange={(e) => setValueaa82(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa83"
                  value={valueaa83}
                  onChange={(e) => setValueaa83(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa84"
                  value={valueaa84}
                  onChange={(e) => setValueaa84(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa91"
                  value={valueaa91}
                  onChange={(e) => setValueaa91(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa92"
                  value={valueaa92}
                  onChange={(e) => setValueaa92(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa93"
                  value={valueaa93}
                  onChange={(e) => setValueaa93(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa94"
                  value={valueaa94}
                  onChange={(e) => setValueaa94(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th rowspan="4">General</th>
            </tr>
            <tr>
              <td>Male</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa101"
                  value={valueaa101}
                  onChange={(e) => setValueaa101(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa102"
                  value={valueaa102}
                  onChange={(e) => setValueaa102(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa103"
                  value={valueaa103}
                  onChange={(e) => setValueaa103(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa104"
                  value={valueaa104}
                  onChange={(e) => setValueaa104(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa111"
                  value={valueaa111}
                  onChange={(e) => setValueaa111(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa112"
                  value={valueaa112}
                  onChange={(e) => setValueaa112(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa113"
                  value={valueaa113}
                  onChange={(e) => setValueaa113(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa114"
                  value={valueaa114}
                  onChange={(e) => setValueaa114(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa121"
                  value={valueaa121}
                  onChange={(e) => setValueaa121(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa122"
                  value={valueaa122}
                  onChange={(e) => setValueaa122(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa123"
                  value={valueaa123}
                  onChange={(e) => setValueaa123(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa124"
                  value={valueaa124}
                  onChange={(e) => setValueaa124(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th rowspan="4">Others</th>
            </tr>
            <tr>
              <td>Male</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa131"
                  value={valueaa131}
                  onChange={(e) => setValueaa131(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa132"
                  value={valueaa132}
                  onChange={(e) => setValueaa132(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa133"
                  value={valueaa133}
                  onChange={(e) => setValueaa133(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa134"
                  value={valueaa134}
                  onChange={(e) => setValueaa134(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa141"
                  value={valueaa141}
                  onChange={(e) => setValueaa141(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa142"
                  value={valueaa142}
                  onChange={(e) => setValueaa142(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa143"
                  value={valueaa143}
                  onChange={(e) => setValueaa143(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa144"
                  value={valueaa144}
                  onChange={(e) => setValueaa144(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa151"
                  value={valueaa151}
                  onChange={(e) => setValueaa151(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa152"
                  value={valueaa152}
                  onChange={(e) => setValueaa152(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa153"
                  value={valueaa153}
                  onChange={(e) => setValueaa153(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa154"
                  value={valueaa154}
                  onChange={(e) => setValueaa154(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Total</th>
              <td>
                {/* <input readonly
                  type="number"
                  id="aa161"
                  value={valueaa161}
                  onChange={(e) => setValueaa161(e.target.value)}
                /> */}
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa162"
                  value={valueaa162}
                  onChange={(e) => setValueaa162(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa163"
                  value={valueaa163}
                  onChange={(e) => setValueaa163(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa164"
                  value={valueaa164}
                  onChange={(e) => setValueaa164(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="aa165"
                  value={valueaa165}
                  onChange={(e) => setValueaa165(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div>Principal Comments : {principalComments}</div>
      <div className="c31x-button-container">
        <button
          onClick={(e) => {
            getAuthorizeAcademicinfo(e);
          }}
          className="c31x-button-style"
          style={{ color: "white", backgroundColor: "green" }}
        >
          Authorize
        </button>

        <button
          onClick={(e) => {
            setRejectButtonClickStatus(true);
            e.preventDefault();
          }}
          className="c31x-button-style"
          style={{ color: "white", backgroundColor: "red" }}
        >
          Reject
        </button>
      </div>
      {rejectButtonClickStatus ? (
        <div style={{ marginLeft: "13%" }}>
          <h1>Reason for Rejection</h1>
          <textarea
            cols={110}
            rows={6}
            onChange={(e) => setRejectReasonComments(e.target.value)}
          ></textarea>
          <div>
            <button
              onClick={() => setRejectButtonClickStatus(false)}
              style={{
                color: "black",
                backgroundColor: "white",
                borderRadius: "4px",
                marginRight: "3%",
                boxShadow:
                  "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
              }}
            >
              Cancel
            </button>
            <button
              onClick={(e) => {
                setRejectButtonClickStatus(false);
                getRejectAcademicinfo(e);
              }}
              style={{
                color: "black",
                backgroundColor: "white",
                borderRadius: "4px",
                boxShadow:
                  "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
              }}
            >
              Confirm Reject
            </button>
          </div>
        </div>
      ) : null}
    </div>
  );
}

export default AcademicInfo;
<></>;
