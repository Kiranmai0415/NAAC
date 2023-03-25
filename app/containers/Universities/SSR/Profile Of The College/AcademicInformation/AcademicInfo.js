import { FormControl, FormControlLabel,RadioGroup,Radio } from "@material-ui/core";
import React, { useState } from "react";
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

  // const [valueatnt51, setValueatnt51] = useState("");
  // const [valueatnt52, setValueatnt52] = useState("");
  // const [valueatnt53, setValueatnt53] = useState("");
  // const [valueatnt54, setValueatnt54] = useState("");

  // const [valueatnt61, setValueatnt61] = useState("");
  // const [valueatnt62, setValueatnt62] = useState("");
  // const [valueatnt63, setValueatnt63] = useState("");
  // const [valueatnt64, setValueatnt64] = useState("");

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

  const financialYear="2021-2022";
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
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

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

      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

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

      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

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

      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

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
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputaa1t1: valueatg1,
        inputaa1t2: valueatg2,
        inputaa1t3: valueatg3,
        inputaa1t4: valueatg4,
      },
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:202,
        inputaa1t1: valueatg21,
        inputaa1t2: valueatg22,
        inputaa1t3: valueatg23,
        inputaa1t4: valueatg24,
      },
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:203,
        inputaa1t1: valueatg31,
        inputaa1t2: valueatg32,
        inputaa1t3: valueatg33,
        inputaa1t4: valueatg34,
      },
    ],
    institutedUniversity: [
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputiut1: valueatc11,
        inputiut2: valueatc12,
        inputiut3: valueatc13,
        inputiut4: valueatc14,
      },
    ],
    academicstudentsEnrolled: [
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputas11: valueas11,
        inputas12: valueas12,
        inputas13: valueas13,
        inputas14: valueas14,
        inputas15: valueas15,
      },
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:202,
        inputas11: valueas21,
        inputas12: valueas22,
        inputas13: valueas23,
        inputas14: valueas24,
        inputas15: valueas25,
      },
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:203,
        inputas11: valueas31,
        inputas12: valueas32,
        inputas13: valueas33,
        inputas14: valueas34,
        inputas15: valueas35,
      },
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:204,
        inputas11: valueas41,
        inputas12: valueas42,
        inputas13: valueas43,
        inputas14: valueas44,
        inputas15: valueas45,
      },
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:205,
        inputas11: valueas51,
        inputas12: valueas52,
        inputas13: valueas53,
        inputas14: valueas54,
        inputas15: valueas55,
      },
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:206,
        inputas11: valueas61,
        inputas12: valueas62,
        inputas13: valueas63,
        inputas14: valueas64,
        inputas15: valueas65,
      },
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:207,
        inputas11: valueas71,
        inputas12: valueas72,
        inputas13: valueas73,
        inputas14: valueas74,
        inputas15: valueas75,
      },
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:208,
        inputas11: valueas81,
        inputas12: valueas82,
        inputas13: valueas83,
        inputas14: valueas84,
        inputas15: valueas85,
      },
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:209,
        inputas11: valueas91,
        inputas12: valueas92,
        inputas13: valueas93,
        inputas14: valueas94,
        inputas15: valueas95,
      },
    ],
    integratedProgrammes: [

      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputult2: valuei11,
        inputult3: valuei12,
        inputult4: valuei13,
        inputult5: valuei14,
        inputult6: valuei15,

        inputult7: valueu1,
        inputult8: valueu2,
      },
            {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:202,
        inputult2: valuei21,
        inputult3: valuei22,
        inputult4: valuei23,
        inputult5: valuei24,
        inputult6: valuei25,
      },
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:203,
        inputult2: valuei31,
        inputult3: valuei32,
        inputult4: valuei33,
        inputult5: valuei34,
        inputult6: valuei35,
      },
    ],
    humanResourceDevelopment: [
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

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
   console.log(JSON.stringify(inputDataList));
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
            <tr style={{textAlign : 'center'}}>
              <th>College Type</th>
              <th>Number of colleges with permanent affiliation</th>
              <th>Number of colleges with temporary affiliation</th>
            </tr>
            <tr>
              <td>
                <input
                  type="text"
                  id="ad11"
                  onChange={(e) => setValuead11(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ad12"
                  onChange={(e) => setValuead12(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ad13"
                  onChange={(e) => setValuead13(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <table>
            <tr style={{textAlign : 'center'}}>
              <th></th>
              <th>Type of Colleges</th>
              <th>Permanent</th>
              <th>Temporary</th>
              <th>Total</th>
            </tr>
            <tr>
              <th>Education/Teachers Training</th>
              <td>
                <input
                  type="text"
                  id="ad21"
                  onChange={(e) => setValuead21(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ad22"
                  onChange={(e) => setValuead22(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ad23"
                  onChange={(e) => setValuead23(e.target.value)}
                />
              </td>
              <td style={{ width: "12%" }}>
                <input
                  type="number"
                  id="ad24"
                  onChange={(e) => setValuead24(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Business administration /Commerce /Management /Finance</th>
              <td>
                <input
                  type="text"
                  id="ad31"
                  onChange={(e) => setValuead31(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ad32"
                  onChange={(e) => setValuead32(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ad33"
                  onChange={(e) => setValuead33(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ad34"
                  onChange={(e) => setValuead34(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Universal/ Common to all Disciplines</th>
              <td>
                <input
                  type="text"
                  id="ad41"
                  onChange={(e) => setValuead41(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ad42"
                  onChange={(e) => setValuead42(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ad43"
                  onChange={(e) => setValuead43(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ad44"
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
                <input
                  type="text"
                  id="ad1"
                  onChange={(e) => setValuead1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Constituent Colleges</th>
              <td>
                <input
                  type="text"
                  id="ad2"
                  onChange={(e) => setValuead2(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>College Under 2(f)</th>
              <td>
                <input
                  type="text"
                  id="ad3"
                  onChange={(e) => setValuead3(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Collge Under 2(f) and 12B</th>
              <td>
                <input
                  type="text"
                  id="ad4"
                  onChange={(e) => setValuead4(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>NAAC Accredited Colleges</th>
              <td>
                <input
                  type="text"
                  id="ad5"
                  onChange={(e) => setValuead5(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Colleges with Potential for Excellence (UGC)</th>
              <td>
                <input
                  type="text"
                  id="ad6"
                  onChange={(e) => setValuead6(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Autonomous Colleges</th>
              <td>
                <input
                  type="text"
                  id="ad7"
                  onChange={(e) => setValuead7(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>College with Postgraduate Departments</th>
              <td>
                <input
                  type="text"
                  id="ad8"
                  onChange={(e) => setValuead8(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Colleges with Research Departments</th>
              <td>
                <input
                  type="text"
                  id="ad9"
                  onChange={(e) => setValuead9(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>University Recognized Research Institutes/Centres</th>
              <td>
                <input
                  type="text"
                  id="ad10"
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
              <FormControl>
                 <RadioGroup name="radio-buttons-group" >
                   <FormControlLabel value="Yes"
                     onChange={(e) => setValuead111(e.target.value)} 
                      control={<Radio />} label="Yes" />
                   <FormControlLabel value="No"
                     onChange={(e) => setValuead111(e.target.value)} 
                      control={<Radio />} label="No" />
                  </RadioGroup>
             </FormControl>
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
                <input
                  type="number"
                  id="atq11"
                  onChange={(e) => setValueatq11(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq12"
                  onChange={(e) => setValueatq12(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq13"
                  onChange={(e) => setValueatq13(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq14"
                  onChange={(e) => setValueatq14(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq15"
                  onChange={(e) => setValueatq15(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq16"
                  onChange={(e) => setValueatq16(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq17"
                  onChange={(e) => setValueatq17(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq18"
                  onChange={(e) => setValueatq18(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq19"
                  onChange={(e) => setValueatq19(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq110"
                  onChange={(e) => setValueatq110(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq111"
                  onChange={(e) => setValueatq111(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq112"
                  onChange={(e) => setValueatq112(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Recruited</th>
              <td>
                <input
                  type="number"
                  id="atq21"
                  onChange={(e) => setValueatq21(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq22"
                  onChange={(e) => setValueatq22(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq23"
                  onChange={(e) => setValueatq23(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq24"
                  onChange={(e) => setValueatq24(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq25"
                  onChange={(e) => setValueatq25(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq26"
                  onChange={(e) => setValueatq26(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq27"
                  onChange={(e) => setValueatq27(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq28"
                  onChange={(e) => setValueatq28(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq29"
                  onChange={(e) => setValueatq29(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq210"
                  onChange={(e) => setValueatq210(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq211"
                  onChange={(e) => setValueatq211(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq212"
                  onChange={(e) => setValueatq212(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input
                  type="number"
                  id="atq31"
                  onChange={(e) => setValueatq31(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq32"
                  onChange={(e) => setValueatq32(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq33"
                  onChange={(e) => setValueatq33(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq34"
                  onChange={(e) => setValueatq34(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq35"
                  onChange={(e) => setValueatq35(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq36"
                  onChange={(e) => setValueatq36(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq37"
                  onChange={(e) => setValueatq37(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq38"
                  onChange={(e) => setValueatq38(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq39"
                  onChange={(e) => setValueatq39(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq310"
                  onChange={(e) => setValueatq310(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq311"
                  onChange={(e) => setValueatq311(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq312"
                  onChange={(e) => setValueatq312(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Contractual</th>
              <td>
                <input
                  type="number"
                  id="atq41"
                  onChange={(e) => setValueatq41(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq42"
                  onChange={(e) => setValueatq42(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq43"
                  onChange={(e) => setValueatq43(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq44"
                  onChange={(e) => setValueatq44(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq45"
                  onChange={(e) => setValueatq45(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq46"
                  onChange={(e) => setValueatq46(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq47"
                  onChange={(e) => setValueatq47(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq48"
                  onChange={(e) => setValueatq48(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq49"
                  onChange={(e) => setValueatq49(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq410"
                  onChange={(e) => setValueatq410(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq411"
                  onChange={(e) => setValueatq411(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq412"
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
                <input
                  type="number"
                  id="atnt11"
                  onChange={(e) => setValueatnt11(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt12"
                  onChange={(e) => setValueatnt12(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt13"
                  onChange={(e) => setValueatnt13(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt14"
                  onChange={(e) => setValueatnt14(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Recruited</th>
              <td>
                <input
                  type="number"
                  id="atnt21"
                  onChange={(e) => setValueatnt21(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt22"
                  onChange={(e) => setValueatnt22(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt23"
                  onChange={(e) => setValueatnt23(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt24"
                  onChange={(e) => setValueatnt24(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input
                  type="number"
                  id="atnt31"
                  onChange={(e) => setValueatnt31(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt32"
                  onChange={(e) => setValueatnt32(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt33"
                  onChange={(e) => setValueatnt33(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt34"
                  onChange={(e) => setValueatnt34(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Contractual</th>
              <td>
                <input
                  type="number"
                  id="atnt41"
                  onChange={(e) => setValueatnt41(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt42"
                  onChange={(e) => setValueatnt42(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt43"
                  onChange={(e) => setValueatnt43(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt44"
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
                <input
                  type="number"
                  id="att11"
                  onChange={(e) => setValueatt11(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att12"
                  onChange={(e) => setValueatt12(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att13"
                  onChange={(e) => setValueatt13(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att14"
                  onChange={(e) => setValueatt14(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Recruited</th>
              <td>
                <input
                  type="number"
                  id="att21"
                  onChange={(e) => setValueatt21(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att22"
                  onChange={(e) => setValueatt22(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att23"
                  onChange={(e) => setValueatt23(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att24"
                  onChange={(e) => setValueatt24(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input
                  type="number"
                  id="att31"
                  onChange={(e) => setValueatt31(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att32"
                  onChange={(e) => setValueatt32(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att33"
                  onChange={(e) => setValueatt33(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att34"
                  onChange={(e) => setValueatt34(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Contractual</th>
              <td>
                <input
                  type="number"
                  id="att41"
                  onChange={(e) => setValueatt41(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att42"
                  onChange={(e) => setValueatt42(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att43"
                  onChange={(e) => setValueatt43(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att44"
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
                <input
                  type="number"
                  id="at11"
                  onChange={(e) => setValueat11(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at12"
                  onChange={(e) => setValueat12(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at13"
                  onChange={(e) => setValueat13(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at14"
                  onChange={(e) => setValueat14(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at15"
                  onChange={(e) => setValueat15(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at16"
                  onChange={(e) => setValueat16(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at17"
                  onChange={(e) => setValueat17(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at18"
                  onChange={(e) => setValueat18(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at19"
                  onChange={(e) => setValueat19(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at110"
                  onChange={(e) => setValueat110(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Ph.D.</th>
              <td>
                <input
                  type="number"
                  id="at21"
                  onChange={(e) => setValueat21(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at22"
                  onChange={(e) => setValueat22(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at23"
                  onChange={(e) => setValueat23(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at24"
                  onChange={(e) => setValueat24(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at25"
                  onChange={(e) => setValueat25(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at26"
                  onChange={(e) => setValueat26(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at27"
                  onChange={(e) => setValueat27(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at28"
                  onChange={(e) => setValueat28(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at29"
                  onChange={(e) => setValueat29(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at210"
                  onChange={(e) => setValueat210(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>M.Phil.</th>
              <td>
                <input
                  type="number"
                  id="at31"
                  onChange={(e) => setValueat31(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at32"
                  onChange={(e) => setValueat32(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at33"
                  onChange={(e) => setValueat33(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at34"
                  onChange={(e) => setValueat34(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at35"
                  onChange={(e) => setValueat35(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at36"
                  onChange={(e) => setValueat36(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at37"
                  onChange={(e) => setValueat37(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at38"
                  onChange={(e) => setValueat38(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at39"
                  onChange={(e) => setValueat39(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at310"
                  onChange={(e) => setValueat310(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG</th>
              <td>
                <input
                  type="number"
                  id="at41"
                  onChange={(e) => setValueat41(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at42"
                  onChange={(e) => setValueat42(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at43"
                  onChange={(e) => setValueat43(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at44"
                  onChange={(e) => setValueat44(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at45"
                  onChange={(e) => setValueat45(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at46"
                  onChange={(e) => setValueat46(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at47"
                  onChange={(e) => setValueat47(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at48"
                  onChange={(e) => setValueat48(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at49"
                  onChange={(e) => setValueat49(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at410"
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
                <input
                  type="number"
                  id="at51"
                  onChange={(e) => setValueat51(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at52"
                  onChange={(e) => setValueat52(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at53"
                  onChange={(e) => setValueat53(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at54"
                  onChange={(e) => setValueat54(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at55"
                  onChange={(e) => setValueat55(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at56"
                  onChange={(e) => setValueat56(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at57"
                  onChange={(e) => setValueat57(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at58"
                  onChange={(e) => setValueat58(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at59"
                  onChange={(e) => setValueat59(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at510"
                  onChange={(e) => setValueat510(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Ph.D.</th>
              <td>
                <input
                  type="number"
                  id="at61"
                  onChange={(e) => setValueat61(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at62"
                  onChange={(e) => setValueat62(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at63"
                  onChange={(e) => setValueat63(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at64"
                  onChange={(e) => setValueat64(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at65"
                  onChange={(e) => setValueat65(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at66"
                  onChange={(e) => setValueat66(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at67"
                  onChange={(e) => setValueat67(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at68"
                  onChange={(e) => setValueat68(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at69"
                  onChange={(e) => setValueat69(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at610"
                  onChange={(e) => setValueat610(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>M.Phil.</th>
              <td>
                <input
                  type="number"
                  id="at71"
                  onChange={(e) => setValueat71(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at72"
                  onChange={(e) => setValueat72(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at73"
                  onChange={(e) => setValueat73(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at74"
                  onChange={(e) => setValueat74(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at75"
                  onChange={(e) => setValueat75(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at76"
                  onChange={(e) => setValueat76(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at77"
                  onChange={(e) => setValueat77(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq8"
                  onChange={(e) => setValueat78(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at79"
                  onChange={(e) => setValueat79(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at710"
                  onChange={(e) => setValueat710(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG</th>
              <td>
                <input
                  type="number"
                  id="at81"
                  onChange={(e) => setValueat81(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at82"
                  onChange={(e) => setValueat82(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at83"
                  onChange={(e) => setValueat83(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at84"
                  onChange={(e) => setValueat84(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at85"
                  onChange={(e) => setValueat85(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at86"
                  onChange={(e) => setValueat86(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at87"
                  onChange={(e) => setValueat87(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at88"
                  onChange={(e) => setValueat88(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at89"
                  onChange={(e) => setValueat89(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at810"
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
                <input
                  type="number"
                  id="at91"
                  onChange={(e) => setValueat91(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at92"
                  onChange={(e) => setValueat92(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at93"
                  onChange={(e) => setValueat93(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at94"
                  onChange={(e) => setValueat94(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at95"
                  onChange={(e) => setValueat95(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at96"
                  onChange={(e) => setValueat96(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at97"
                  onChange={(e) => setValueat97(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at98"
                  onChange={(e) => setValueat98(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at99"
                  onChange={(e) => setValueat99(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at910"
                  onChange={(e) => setValueat910(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Ph.D.</th>
              <td>
                <input
                  type="number"
                  id="at101"
                  onChange={(e) => setValueat101(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at102"
                  onChange={(e) => setValueat102(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at103"
                  onChange={(e) => setValueat103(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at104"
                  onChange={(e) => setValueat104(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at105"
                  onChange={(e) => setValueat105(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at106"
                  onChange={(e) => setValueat106(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at107"
                  onChange={(e) => setValueat107(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at108"
                  onChange={(e) => setValueat108(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at109"
                  onChange={(e) => setValueat109(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at110"
                  onChange={(e) => setValueat1010(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th> M.Phil.</th>
              <td>
                <input
                  type="number"
                  id="at111"
                  onChange={(e) => setValueat111(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at112"
                  onChange={(e) => setValueat112(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at113"
                  onChange={(e) => setValueat113(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at114"
                  onChange={(e) => setValueat114(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at115"
                  onChange={(e) => setValueat115(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq116"
                  onChange={(e) => setValueat116(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at117"
                  onChange={(e) => setValueat117(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at118"
                  onChange={(e) => setValueat118(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at119"
                  onChange={(e) => setValueat119(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at1110"
                  onChange={(e) => setValueat1110(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG</th>
              <td>
                <input
                  type="number"
                  id="atq121"
                  onChange={(e) => setValueat121(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at122"
                  onChange={(e) => setValueat122(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq123"
                  onChange={(e) => setValueat123(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at124"
                  onChange={(e) => setValueat124(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at125"
                  onChange={(e) => setValueat125(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at126"
                  onChange={(e) => setValueat126(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at127"
                  onChange={(e) => setValueat127(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at128"
                  onChange={(e) => setValueat128(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at129"
                  onChange={(e) => setValueat129(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at1210"
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
                <input
                  type="number"
                  id="atg1"
                  onChange={(e) => setValueatg1(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atg2"
                  onChange={(e) => setValueatg2(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atg3"
                  onChange={(e) => setValueatg3(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atg4"
                  onChange={(e) => setValueatg4(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Adjunct Professor</th>
              <td>
                <input
                  type="number"
                  id="atg21"
                  onChange={(e) => setValueatg21(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atg22"
                  onChange={(e) => setValueatg22(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atg23"
                  onChange={(e) => setValueatg23(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atg24"
                  onChange={(e) => setValueatg24(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Visiting Professor</th>
              <td>
                <input
                  type="number"
                  id="atg31"
                  onChange={(e) => setValueatg31(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atg32"
                  onChange={(e) => setValueatg32(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atg33"
                  onChange={(e) => setValueatg33(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atg34"
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
                <input
                  type="number"
                  id="atc11"
                  onChange={(e) => setValueatc11(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="atc12"
                  onChange={(e) => setValueatc12(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="atc13"
                  onChange={(e) => setValueatc13(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="atc14"
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
                <input
                  type="number"
                  id="as11"
                  onChange={(e) => setValueas11(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as12"
                  onChange={(e) => setValueas12(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as13"
                  onChange={(e) => setValueas13(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as14"
                  onChange={(e) => setValueas14(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as15"
                  onChange={(e) => setValueas15(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  type="number"
                  id="as21"
                  onChange={(e) => setValueas21(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as22"
                  onChange={(e) => setValueas22(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as23"
                  onChange={(e) => setValueas23(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as24"
                  onChange={(e) => setValueas24(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as25"
                  onChange={(e) => setValueas25(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  type="number"
                  id="as31"
                  onChange={(e) => setValueas31(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as32"
                  onChange={(e) => setValueas32(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as33"
                  onChange={(e) => setValueas33(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as34"
                  onChange={(e) => setValueas34(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as35"
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
                  type="number"
                  id="as41"
                  onChange={(e) => setValueas41(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as42"
                  onChange={(e) => setValueas42(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as43"
                  onChange={(e) => setValueas43(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as44"
                  onChange={(e) => setValueas44(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as45"
                  onChange={(e) => setValueas45(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  type="number"
                  id="as51"
                  onChange={(e) => setValueas51(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as52"
                  onChange={(e) => setValueas52(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as53"
                  onChange={(e) => setValueas53(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as54"
                  onChange={(e) => setValueas54(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as55"
                  onChange={(e) => setValueas55(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  type="number"
                  id="as61"
                  onChange={(e) => setValueas61(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as62"
                  onChange={(e) => setValueas62(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as63"
                  onChange={(e) => setValueas63(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as64"
                  onChange={(e) => setValueas64(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as65"
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
                <input
                  type="number"
                  id="as71"
                  onChange={(e) => setValueas71(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as72"
                  onChange={(e) => setValueas72(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as73"
                  onChange={(e) => setValueas73(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as74"
                  onChange={(e) => setValueas74(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as75"
                  onChange={(e) => setValueas75(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  type="number"
                  id="as81"
                  onChange={(e) => setValueas81(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as82"
                  onChange={(e) => setValueas82(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as83"
                  onChange={(e) => setValueas83(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as84"
                  onChange={(e) => setValueas84(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as85"
                  onChange={(e) => setValueas85(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  type="number"
                  id="as91"
                  onChange={(e) => setValueas91(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as92"
                  onChange={(e) => setValueas92(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as93"
                  onChange={(e) => setValueas93(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as94"
                  onChange={(e) => setValueas94(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="as95"
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
              <FormControl>
                 <RadioGroup name="radio-buttons-group" >
                   <FormControlLabel value="Yes"
                     onChange={(e) => setValueu1(e.target.value)} 
                      control={<Radio />} label="Yes" />
                   <FormControlLabel value="No"
                     onChange={(e) => setValueu1(e.target.value)} 
                      control={<Radio />} label="No" />
                  </RadioGroup>
             </FormControl>
              </td>
            </tr>
            <tr>
              <td>Total number of integrated programmes</td>
              <td>
                <input
                  rowspan="2"
                  type="number"
                  id="u2"
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
                <input
                  type="number"
                  id="i11"
                  onChange={(e) => setValuei11(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="i12"
                  onChange={(e) => setValuei12(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="i13"
                  onChange={(e) => setValuei13(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="i14"
                  onChange={(e) => setValuei14(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="i15"
                  onChange={(e) => setValuei15(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  type="number"
                  id="i21"
                  onChange={(e) => setValuei21(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="i22"
                  onChange={(e) => setValuei22(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="i23"
                  onChange={(e) => setValuei23(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="i24"
                  onChange={(e) => setValuei24(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="i25"
                  onChange={(e) => setValuei25(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  type="number"
                  id="i31"
                  onChange={(e) => setValuei31(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="i32"
                  onChange={(e) => setValuei32(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="i33"
                  onChange={(e) => setValuei33(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="i34"
                  onChange={(e) => setValuei34(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="i35"
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
                <input
                  type="number"
                  id="d11"
                  onChange={(e) => setValued11(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Number of UGC Orientation Programmes</td>
              <td>
                <input
                  type="number"
                  id="d12"
                  onChange={(e) => setValued12(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Number of UGC Refresher Course</td>
              <td>
                <input
                  type="number"
                  id="d13"
                  onChange={(e) => setValued13(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Number of University own Programmes</td>
              <td>
                <input
                  type="number"
                  id="d14"
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
                <input
                  type="number"
                  id="d15"
                  onChange={(e) => setValued15(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="c11x-button-container" style={{ paddingBottom: "30px" }}>
        <button onClick={onClickingSave} className="c11x-button-style">
          Submit
        </button>
      </div>
    </div>
  );
}

export default AccademicInfo;
