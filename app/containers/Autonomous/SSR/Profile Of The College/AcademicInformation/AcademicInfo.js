import React, { useState } from "react";
import { toast } from "react-toastify";
import AuthService from "../../../../Pages/Users/services/auth.service";
import "./AcademicInfo-style.css";

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

  const [valueaa161, setValueaa161] = useState("");
  const [valueaa162, setValueaa162] = useState("");
  const [valueaa163, setValueaa163] = useState("");
  const [valueaa164, setValueaa164] = useState("");
  const [valueaa165, setValueaa165] = useState("");

  // sending data to db with API
  // const financialYear="2021-2022";
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

  const inputDataList = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    academicinformation: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputad11: valuead1,
        inputad12: valuead2,
        inputad13: valuead3,
        inputad14: valuead4,
        inputad15: valuead5,
        inputad16: valuead6,
        inputad17: valuead7,
      },
    ],
    detailsofVisitingFaculties: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputatg11: valueatg1,
        inputatg12: valueatg2,
        inputatg13: valueatg3,
        inputatg14: valueatg4,
      },
    ],

    technicalStaff: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputatt15: valueatt11,
        inputatt16: valueatt12,
        inputatt17: valueatt13,
        inputatt18: valueatt14,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        inputatt15: valueatt21,
        inputatt16: valueatt22,
        inputatt17: valueatt23,
        inputatt18: valueatt24,
      },

      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        inputatt15: valueatt31,
        inputatt16: valueatt32,
        inputatt17: valueatt33,
        inputatt18: valueatt34,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        inputatt15: valueatt41,
        inputatt16: valueatt42,
        inputatt17: valueatt43,
        inputatt18: valueatt44,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 5,
        inputatt15: valueatt51,
        inputatt16: valueatt52,
        inputatt17: valueatt53,
        inputatt18: valueatt54,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 6,
        inputatt15: valueatt61,
        inputatt16: valueatt62,
        inputatt17: valueatt63,
        inputatt18: valueatt64,
      },
    ],

    academicinstitution: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputat11: valueat11,
        inputat12: valueat12,
        inputat13: valueat13,
        inputat14: valueat14,
        inputat15: valueat15,
        inputat16: valueat16,
        inputat17: valueat17,
        inputat18: valueat18,
        inputat19: valueat19,
        inputat10: valueat110,
        inputat111: valueat111,
        inputat112: valueat112,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        inputat11: valueat21,
        inputat12: valueat22,
        inputat13: valueat23,
        inputat14: valueat25,
        inputat15: valueat25,
        inputat16: valueat26,
        inputat17: valueat27,
        inputat18: valueat28,
        inputat19: valueat29,
        inputat10: valueat210,
        inputat111: valueat211,
        inputat112: valueat212,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        inputat11: valueat31,
        inputat12: valueat32,
        inputat13: valueat33,
        inputat14: valueat34,
        inputat15: valueat35,
        inputat16: valueat36,
        inputat17: valueat37,
        inputat18: valueat38,
        inputat19: valueat39,
        inputat10: valueat310,
        inputat111: valueat311,
        inputat112: valueat312,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        inputat00: valueat4,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 5,
        inputat11: valueat41,
        inputat12: valueat42,
        inputat13: valueat43,
        inputat14: valueat44,
        inputat15: valueat45,
        inputat16: valueat46,
        inputat17: valueat47,
        inputat18: valueat48,
        inputat19: valueat49,
        inputat10: valueat410,
        inputat111: valueat411,
        inputat112: valueat412,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 6,
        inputat11: valueat51,
        inputat12: valueat52,
        inputat13: valueat53,
        inputat14: valueat54,
        inputat15: valueat55,
        inputat16: valueat56,
        inputat17: valueat57,
        inputat18: valueat58,
        inputat19: valueat59,
        inputat10: valueat510,
        inputat111: valueat511,
        inputat112: valueat512,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 7,
        inputat11: valueat61,
        inputat12: valueat62,
        inputat13: valueat63,
        inputat14: valueat64,
        inputat15: valueat65,
        inputat16: valueat66,
        inputat17: valueat67,
        inputat18: valueat68,
        inputat19: valueat69,
        inputat10: valueat610,
        inputat111: valueat611,
        inputat112: valueat612,
      },
    ],

    nonTeachingStaff: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputatnt11: valueatnt11,
        inputatnt12: valueatnt12,
        inputatnt13: valueatnt13,
        inputatnt14: valueatnt14,
      },

      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        inputatnt11: valueatnt21,
        inputatnt12: valueatnt22,
        inputatnt13: valueatnt23,
        inputatnt14: valueatnt24,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        inputatnt11: valueatnt31,
        inputatnt12: valueatnt32,
        inputatnt13: valueatnt33,
        inputatnt14: valueatnt34,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        inputatnt11: valueatnt41,
        inputatnt12: valueatnt42,
        inputatnt13: valueatnt43,
        inputatnt14: valueatnt44,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 5,
        inputatnt11: valueatnt51,
        inputatnt12: valueatnt52,
        inputatnt13: valueatnt53,
        inputatnt14: valueatnt54,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 6,
        inputatnt11: valueatnt61,
        inputatnt12: valueatnt62,
        inputatnt13: valueatnt63,
        inputatnt14: valueatnt64,
      },
    ],

    academicPerminentTeachers: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputatq11: valueatq11,
        inputatq12: valueatq12,
        inputatq13: valueatq13,
        inputatq14: valueatq14,
        inputatq15: valueatq15,
        inputatq16: valueatq16,
        inputatq17: valueatq17,
        inputatq18: valueatq18,
        inputatq19: valueatq19,
        inputatq110: valueatq110,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        inputatq11: valueatq21,
        inputatq12: valueatq22,
        inputatq13: valueatq23,
        inputatq14: valueatq24,
        inputatq15: valueatq25,
        inputatq16: valueatq26,
        inputatq17: valueatq27,
        inputatq18: valueatq28,
        inputatq19: valueatq29,
        inputatq110: valueatq210,
      },

      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        inputatq11: valueatq31,
        inputatq12: valueatq32,
        inputatq13: valueatq33,
        inputatq14: valueatq34,
        inputatq15: valueatq35,
        inputatq16: valueatq36,
        inputatq17: valueatq37,
        inputatq18: valueatq38,
        inputatq19: valueatq39,
        inputatq110: valueatq310,
      },

      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        inputatq11: valueatq41,
        inputatq12: valueatq42,
        inputatq13: valueatq43,
        inputatq14: valueatq44,
        inputatq15: valueatq45,
        inputatq16: valueatq46,
        inputatq17: valueatq47,
        inputatq18: valueatq48,
        inputatq19: valueatq49,
        inputatq110: valueatq410,
      },
    ],

    academicTemporaryTeachers: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputatq51: valueatq51,
        inputatq52: valueatq52,
        inputatq53: valueatq53,
        inputatq54: valueatq54,
        inputatq55: valueatq55,
        inputatq56: valueatq56,
        inputatq57: valueatq57,
        inputatq58: valueatq58,
        inputatq59: valueatq59,
        inputatq510: valueatq510,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        inputatq51: valueatq61,
        inputatq52: valueatq62,
        inputatq53: valueatq63,
        inputatq54: valueatq64,
        inputatq55: valueatq65,
        inputatq56: valueatq66,
        inputatq57: valueatq67,
        inputatq58: valueatq68,
        inputatq59: valueatq69,
        inputatq510: valueatq610,
      },

      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        inputatq51: valueatq71,
        inputatq52: valueatq72,
        inputatq53: valueatq73,
        inputatq54: valueatq74,
        inputatq55: valueatq75,
        inputatq56: valueatq76,
        inputatq57: valueatq77,
        inputatq58: valueatq78,
        inputatq59: valueatq79,
        inputatq510: valueatq710,
      },

      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        inputatq51: valueatq81,
        inputatq52: valueatq82,
        inputatq53: valueatq83,
        inputatq54: valueatq84,
        inputatq55: valueatq85,
        inputatq56: valueatq86,
        inputatq57: valueatq87,
        inputatq58: valueatq88,
        inputatq59: valueatq89,
        inputatq510: valueatq810,
      },
    ],

    academicParttimeTeacheres: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputatq91: valueatq91,
        inputatq92: valueatq92,
        inputatq93: valueatq93,
        inputatq94: valueatq94,
        inputatq95: valueatq95,
        inputatq96: valueatq96,
        inputatq97: valueatq97,
        inputatq98: valueatq98,
        inputatq99: valueatq99,
        inputatq910: valueatq910,
      },

      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        inputatq91: valueatq101,
        inputatq92: valueatq102,
        inputatq93: valueatq103,
        inputatq94: valueatq104,
        inputatq95: valueatq105,
        inputatq96: valueatq106,
        inputatq97: valueatq107,
        inputatq98: valueatq108,
        inputatq99: valueatq109,
        inputatq910: valueatq1010,
      },

      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        inputatq91: valueatq111,
        inputatq92: valueatq112,
        inputatq93: valueatq113,
        inputatq94: valueatq114,
        inputatq95: valueatq115,
        inputatq96: valueatq116,
        inputatq97: valueatq117,
        inputatq98: valueatq118,
        inputatq99: valueatq119,
        inputatq910: valueatq1110,
      },

      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        inputatq91: valueatq121,
        inputatq92: valueatq122,
        inputatq93: valueatq123,
        inputatq94: valueatq124,
        inputatq95: valueatq125,
        inputatq96: valueatq126,
        inputatq97: valueatq127,
        inputatq98: valueatq128,
        inputatq99: valueatq129,
        inputatq910: valueatq1210,
      },
    ],

    // academicTeachingStaff: [
    //   {
    //     criteriaId: {
    //       collegeId: "1",
    //       financialYear: financialYear,
    //       typeofInstitution: "autonomous",
    //     },
    //     uniqueKey1:1,
    //     // inputatq11: valueatq11,
    //     // inputatq12: valueatq12,
    //     // inputatq13: valueatq13,
    //     // inputatq14: valueatq14,
    //     // inputatq15: valueatq15,
    //     // inputatq16: valueatq16,
    //     // inputatq17: valueatq17,
    //     // inputatq18: valueatq18,
    //     // inputatq19: valueatq19,
    //     // inputatq110: valueatq110,
    //     // inputatq51: valueatq51,
    //     // inputatq52: valueatq52,
    //     // inputatq53: valueatq53,
    //     // inputatq54: valueatq54,
    //     // inputatq55: valueatq55,
    //     // inputatq56: valueatq56,
    //     // inputatq57: valueatq57,
    //     // inputatq58: valueatq58,
    //     // inputatq59: valueatq59,
    //     // inputatq510: valueatq510,

    //     inputatq31: valueatq51,
    //     inputatq32: valueatq52,
    //     inputatq33: valueatq53,
    //     inputatq34: valueatq54,
    //     inputatq35: valueatq55,
    //     inputatq36: valueatq56,
    //     inputatq37: valueatq57,
    //     inputatq38: valueatq58,
    //     inputatq39: valueatq59,
    //     inputatq310: valueatq510,
    //   },

    //   {
    //     criteriaId: {
    //       collegeId: "1",
    //       financialYear: financialYear,
    //       typeofInstitution: "autonomous",
    //     },
    //     uniqueKey1:2,
    //     // inputatq11: valueatq21,
    //     // inputatq12: valueatq22,
    //     // inputatq13: valueatq23,
    //     // inputatq14: valueatq24,
    //     // inputatq15: valueatq25,
    //     // inputatq16: valueatq26,
    //     // inputatq17: valueatq27,
    //     // inputatq18: valueatq28,
    //     // inputatq19: valueatq29,
    //     // inputatq110: valueatq210,
    //     // inputatq51: valueatq61,
    //     // inputatq52: valueatq62,
    //     // inputatq53: valueatq63,
    //     // inputatq54: valueatq64,
    //     // inputatq55: valueatq65,
    //     // inputatq56: valueatq66,
    //     // inputatq57: valueatq67,
    //     // inputatq58: valueatq68,
    //     // inputatq59: valueatq69,
    //     // inputatq510: valueatq610,

    //     inputatq31: valueatq61,
    //     inputatq32: valueatq62,
    //     inputatq33: valueatq63,
    //     inputatq34: valueatq64,
    //     inputatq35: valueatq65,
    //     inputatq36: valueatq66,
    //     inputatq37: valueatq67,
    //     inputatq38: valueatq68,
    //     inputatq39: valueatq69,
    //     inputatq310: valueatq610,
    //   },

    //   {
    //     criteriaId: {
    //       collegeId: "1",
    //       financialYear: financialYear,
    //       typeofInstitution: "autonomous",
    //     },
    //     uniqueKey1:3,
    //     // inputatq11: valueatq31,
    //     // inputatq12: valueatq32,
    //     // inputatq13: valueatq33,
    //     // inputatq14: valueatq34,
    //     // inputatq15: valueatq35,
    //     // inputatq16: valueatq36,
    //     // inputatq17: valueatq37,
    //     // inputatq18: valueatq38,
    //     // inputatq19: valueatq39,
    //     // inputatq110: valueatq310,
    //     // inputatq51: valueatq71,
    //     // inputatq52: valueatq72,
    //     // inputatq53: valueatq73,
    //     // inputatq54: valueatq74,
    //     // inputatq55: valueatq75,
    //     // inputatq56: valueatq76,
    //     // inputatq57: valueatq77,
    //     // inputatq58: valueatq78,
    //     // inputatq59: valueatq79,
    //     // inputatq510: valueatq710,

    //     inputatq91: valueatq91,
    //     inputatq92: valueatq92,
    //     inputatq93: valueatq93,
    //     inputatq94: valueatq94,
    //     inputatq95: valueatq95,
    //     inputatq96: valueatq96,
    //     inputatq97: valueatq97,
    //     inputatq98: valueatq98,
    //     inputatq99: valueatq99,
    //     inputatq910: valueatq910,
    //   },
    //   {
    //     criteriaId: {
    //       collegeId: "1",
    //       financialYear: financialYear,
    //       typeofInstitution: "autonomous",
    //     },
    //     uniqueKey1:4,
    //     // inputatq11: valueatq41,
    //     // inputatq12: valueatq42,
    //     // inputatq13: valueatq43,
    //     // inputatq14: valueatq44,
    //     // inputatq15: valueatq45,
    //     // inputatq16: valueatq46,
    //     // inputatq17: valueatq47,
    //     // inputatq18: valueatq48,
    //     // inputatq19: valueatq49,
    //     // inputatq110: valueatq410,
    //     // inputatq51: valueatq81,
    //     // inputatq52: valueatq82,
    //     // inputatq53: valueatq83,
    //     // inputatq54: valueatq84,
    //     // inputatq55: valueatq85,
    //     // inputatq56: valueatq86,
    //     // inputatq57: valueatq87,
    //     // inputatq58: valueatq88,
    //     // inputatq59: valueatq89,
    //     // inputatq510: valueatq810,

    //     inputatq31: valueatq81,
    //     inputatq32: valueatq82,
    //     inputatq33: valueatq83,
    //     inputatq34: valueatq84,
    //     inputatq35: valueatq85,
    //     inputatq36: valueatq86,
    //     inputatq37: valueatq87,
    //     inputatq38: valueatq88,
    //     inputatq39: valueatq89,
    //     inputatq310: valueatq810,
    //   },

    //   {
    //     criteriaId: {
    //       collegeId: "1",
    //       financialYear: financialYear,
    //       typeofInstitution: "autonomous",
    //     },
    //     uniqueKey1:6,
    //     inputatq11: valueatq12,
    //     inputatq12: valueatq22,
    //     inputatq13: valueatq32,
    //     inputatq14: valueatq42,
    //     inputatq15: valueatq52,
    //     inputatq16: valueatq62,
    //     inputatq17: valueatq72,
    //     inputatq18: valueatq82,
    //     inputatq19: valueatq92,
    //     inputatq20: valueatq102,
    //     inputatq21: valueatq112,
    //     inputatq22: valueatq122,
    //   },
    //   {
    //     criteriaId: {
    //       collegeId: "1",
    //       financialYear: financialYear,
    //       typeofInstitution: "autonomous",
    //     },
    //     uniqueKey1:7,
    //     inputatq11: valueatq13,
    //     inputatq12: valueatq23,
    //     inputatq13: valueatq33,
    //     inputatq14: valueatq43,
    //     inputatq15: valueatq53,
    //     inputatq16: valueatq63,
    //     inputatq17: valueatq73,
    //     inputatq18: valueatq83,
    //     inputatq19: valueatq93,
    //     inputatq20: valueatq103,
    //     inputatq21: valueatq113,
    //     inputatq22: valueatq123,
    //   },
    //   {
    //     criteriaId: {
    //       collegeId: "1",
    //       financialYear: financialYear,
    //       typeofInstitution: "autonomous",
    //     },
    //     uniqueKey1:8,
    //     inputatq11: valueatq14,
    //     inputatq12: valueatq24,
    //     inputatq13: valueatq34,
    //     inputatq14: valueatq44,
    //     inputatq15: valueatq54,
    //     inputatq16: valueatq64,
    //     inputatq17: valueatq74,
    //     inputatq18: valueatq84,
    //     inputatq19: valueatq94,
    //     inputatq20: valueatq104,
    //     inputatq21: valueatq114,
    //     inputatq22: valueatq124,
    //   },
    //   {
    //     criteriaId: {
    //       collegeId: "1",
    //       financialYear: financialYear,
    //       typeofInstitution: "autonomous",
    //     },
    //     uniqueKey1:9,
    //     inputatq11: valueatq15,
    //     inputatq12: valueatq25,
    //     inputatq13: valueatq35,
    //     inputatq14: valueatq45,
    //     inputatq15: valueatq55,
    //     inputatq16: valueatq65,
    //     inputatq17: valueatq75,
    //     inputatq18: valueatq85,
    //     inputatq19: valueatq95,
    //     inputatq20: valueatq105,
    //     inputatq21: valueatq115,
    //     inputatq22: valueatq125,
    //   },
    //   {
    //     criteriaId: {
    //       collegeId: "1",
    //       financialYear: financialYear,
    //       typeofInstitution: "autonomous",
    //     },
    //     uniqueKey1:10,
    //     inputatq11: valueatq16,
    //     inputatq12: valueatq26,
    //     inputatq13: valueatq36,
    //     inputatq14: valueatq46,
    //     inputatq15: valueatq56,
    //     inputatq16: valueatq66,
    //     inputatq17: valueatq76,
    //     inputatq18: valueatq86,
    //     inputatq19: valueatq96,
    //     inputatq20: valueatq106,
    //     inputatq21: valueatq116,
    //     inputatq22: valueatq126,
    //   },
    //   {
    //     criteriaId: {
    //       collegeId: "1",
    //       financialYear: financialYear,
    //       typeofInstitution: "autonomous",
    //     },
    //     uniqueKey1:11,
    //     inputatq11: valueatq17,
    //     inputatq12: valueatq27,
    //     inputatq13: valueatq37,
    //     inputatq14: valueatq47,
    //     inputatq15: valueatq57,
    //     inputatq16: valueatq67,
    //     inputatq17: valueatq77,
    //     inputatq18: valueatq87,
    //     inputatq19: valueatq97,
    //     inputatq20: valueatq107,
    //     inputatq21: valueatq117,
    //     inputatq22: valueatq127,
    //   },
    //   {
    //     criteriaId: {
    //       collegeId: "1",
    //       financialYear: financialYear,
    //       typeofInstitution: "autonomous",
    //     },
    //     uniqueKey1:12,
    //     inputatq11: valueatq18,
    //     inputatq12: valueatq28,
    //     inputatq13: valueatq38,
    //     inputatq14: valueatq48,
    //     inputatq15: valueatq58,
    //     inputatq16: valueatq68,
    //     inputatq17: valueatq78,
    //     inputatq18: valueatq88,
    //     inputatq19: valueatq98,
    //     inputatq20: valueatq108,
    //     inputatq21: valueatq118,
    //     inputatq22: valueatq128,
    //   },
    //   {
    //     criteriaId: {
    //       collegeId: "1",
    //       financialYear: financialYear,
    //       typeofInstitution: "autonomous",
    //     },
    //     uniqueKey1:13,
    //     inputatq11: valueatq19,
    //     inputatq12: valueatq29,
    //     inputatq13: valueatq39,
    //     inputatq14: valueatq49,
    //     inputatq15: valueatq59,
    //     inputatq16: valueatq69,
    //     inputatq17: valueatq79,
    //     inputatq18: valueatq89,
    //     inputatq19: valueatq99,
    //     inputatq20: valueatq109,
    //     inputatq21: valueatq119,
    //     inputatq22: valueatq129,
    //   },
    //   {
    //     criteriaId: {
    //       collegeId: "1",
    //       financialYear: financialYear,
    //       typeofInstitution: "autonomous",
    //     },
    //     uniqueKey1:14,
    //     inputatq11: valueatq110,
    //     inputatq12: valueatq210,
    //     inputatq13: valueatq310,
    //     inputatq14: valueatq410,
    //     inputatq15: valueatq510,
    //     inputatq16: valueatq610,
    //     inputatq17: valueatq710,
    //     inputatq18: valueatq810,
    //     inputatq19: valueatq910,
    //     inputatq20: valueatq1010,
    //     inputatq21: valueatq1110,
    //     inputatq22: valueatq1210,
    //   },
    // ],
    academicstudentsEnrolled: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputas11: valueas11,
        inputas12: valueas12,
        inputas13: valueas13,
        inputas14: valueas14,
        inputas15: valueas15,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        inputas11: valueas21,
        inputas12: valueas22,
        inputas13: valueas23,
        inputas14: valueas24,
        inputas15: valueas25,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        inputas11: valueas31,
        inputas12: valueas32,
        inputas13: valueas33,
        inputas14: valueas34,
        inputas15: valueas35,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        inputas11: valueas41,
        inputas12: valueas42,
        inputas13: valueas43,
        inputas14: valueas44,
        inputas15: valueas45,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 5,
        inputas11: valueas51,
        inputas12: valueas52,
        inputas13: valueas53,
        inputas14: valueas54,
        inputas15: valueas55,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 6,
        inputas11: valueas61,
        inputas12: valueas62,
        inputas13: valueas63,
        inputas14: valueas64,
        inputas15: valueas65,
      },
    ],
    academicstudentsAdmitted: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputaa11: valueaa11,
        inputaa12: valueaa12,
        inputaa13: valueaa13,
        inputaa14: valueaa14,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        inputaa11: valueaa21,
        inputaa12: valueaa22,
        inputaa13: valueaa23,
        inputaa14: valueaa24,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        inputaa11: valueaa31,
        inputaa12: valueaa32,
        inputaa13: valueaa33,
        inputaa14: valueaa34,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        inputaa11: valueaa41,
        inputaa12: valueaa42,
        inputaa13: valueaa43,
        inputaa14: valueaa44,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 5,
        inputaa11: valueaa51,
        inputaa12: valueaa52,
        inputaa13: valueaa53,
        inputaa14: valueaa54,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 6,
        inputaa11: valueaa61,
        inputaa12: valueaa62,
        inputaa13: valueaa63,
        inputaa14: valueaa64,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 7,
        inputaa11: valueaa71,
        inputaa12: valueaa72,
        inputaa13: valueaa73,
        inputaa14: valueaa74,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 8,
        inputaa11: valueaa81,
        inputaa12: valueaa82,
        inputaa13: valueaa83,
        inputaa14: valueaa84,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 9,
        inputaa11: valueaa91,
        inputaa12: valueaa92,
        inputaa13: valueaa93,
        inputaa14: valueaa94,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 10,
        inputaa11: valueaa101,
        inputaa12: valueaa102,
        inputaa13: valueaa103,
        inputaa14: valueaa104,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 11,
        inputaa11: valueaa111,
        inputaa12: valueaa112,
        inputaa13: valueaa113,
        inputaa14: valueaa114,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 12,
        inputaa11: valueaa121,
        inputaa12: valueaa122,
        inputaa13: valueaa123,
        inputaa14: valueaa124,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 13,
        inputaa11: valueaa131,
        inputaa12: valueaa132,
        inputaa13: valueaa133,
        inputaa14: valueaa134,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 14,
        inputaa11: valueaa141,
        inputaa12: valueaa142,
        inputaa13: valueaa143,
        inputaa14: valueaa144,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 15,
        inputaa11: valueaa151,
        inputaa12: valueaa152,
        inputaa13: valueaa153,
        inputaa14: valueaa154,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 16,
        // inputaa11: valueaa161,
        inputaa11: valueaa162,
        inputaa12: valueaa163,
        inputaa13: valueaa164,
        inputaa14: valueaa165,
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
    console.log(inputDataList);

    basicData.append("ssrData", jsonBlob(inputDataList));

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch("http://localhost:8080/api/v1/academicdata", filesFetchMethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Record is Inserted Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
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
                  type="text"
                  id="ad1"
                  onChange={(e) => setValuead1(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ad2"
                  onChange={(e) => setValuead2(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ad3"
                  onChange={(e) => setValuead3(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ad4"
                  onChange={(e) => setValuead4(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ad5"
                  onChange={(e) => setValuead5(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ad6"
                  onChange={(e) => setValuead6(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ad7"
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
                  type="number"
                  style={{ height: "100%" }}
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
            </tr>
            <tr>
              <th>Recruited</th>
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
              <td>
                <input
                  type="number"
                  id="at211"
                  onChange={(e) => setValueat211(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at212"
                  onChange={(e) => setValueat212(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
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
              <td>
                <input
                  type="number"
                  id="at311"
                  onChange={(e) => setValueat311(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at312"
                  onChange={(e) => setValueat312(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>On Contract</th>
              <td colspan="12">
                <input
                  type="number"
                  id="at4"
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
              <td>
                <input
                  type="number"
                  id="at411"
                  onChange={(e) => setValueat411(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at412"
                  onChange={(e) => setValueat412(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Recruited</th>
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
              <td>
                <input
                  type="number"
                  id="at511"
                  onChange={(e) => setValueat511(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at512"
                  onChange={(e) => setValueat512(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
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
              <td>
                <input
                  type="number"
                  id="at611"
                  onChange={(e) => setValueat611(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at612"
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
              <th>
                Sanctioned by the Management/ Society/ or other Authorised Body
              </th>
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
            <tr>
              <th>Recruited</th>
              <td>
                <input
                  type="number"
                  id="atnt51"
                  onChange={(e) => setValueatnt51(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt52"
                  onChange={(e) => setValueatnt52(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt53"
                  onChange={(e) => setValueatnt53(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt54"
                  onChange={(e) => setValueatnt54(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input
                  type="number"
                  id="atnt61"
                  onChange={(e) => setValueatnt61(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt62"
                  onChange={(e) => setValueatnt62(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt63"
                  onChange={(e) => setValueatnt63(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atnt64"
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
              <th>
                Sanctioned by the Management/ Society/ or other Authorised Body
              </th>
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
            <tr>
              <th>Recruit</th>
              <td>
                <input
                  type="number"
                  id="att51"
                  onChange={(e) => setValueatt51(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att52"
                  onChange={(e) => setValueatt52(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att53"
                  onChange={(e) => setValueatt53(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att54"
                  onChange={(e) => setValueatt54(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input
                  type="text"
                  id="att61"
                  onChange={(e) => setValueatt61(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att62"
                  onChange={(e) => setValueatt62(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att63"
                  onChange={(e) => setValueatt63(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="att64"
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
            </tr>
            <tr>
              <th>Ph.D.</th>
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
            </tr>
            <tr>
              <th>M.Phil.</th>
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
            </tr>
            <tr>
              <th>PG</th>
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
                  id="atq51"
                  onChange={(e) => setValueatq51(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq52"
                  onChange={(e) => setValueatq52(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq53"
                  onChange={(e) => setValueatq53(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq54"
                  onChange={(e) => setValueatq54(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq55"
                  onChange={(e) => setValueatq55(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq56"
                  onChange={(e) => setValueatq56(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq57"
                  onChange={(e) => setValueatq57(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq58"
                  onChange={(e) => setValueatq58(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq59"
                  onChange={(e) => setValueatq59(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq510"
                  onChange={(e) => setValueatq510(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Ph.D.</th>
              <td>
                <input
                  type="number"
                  id="atq61"
                  onChange={(e) => setValueatq61(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq62"
                  onChange={(e) => setValueatq62(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq63"
                  onChange={(e) => setValueatq63(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq64"
                  onChange={(e) => setValueatq64(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq65"
                  onChange={(e) => setValueatq65(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq66"
                  onChange={(e) => setValueatq66(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq67"
                  onChange={(e) => setValueatq67(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq68"
                  onChange={(e) => setValueatq68(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq69"
                  onChange={(e) => setValueatq69(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq610"
                  onChange={(e) => setValueatq610(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>M.Phil.</th>
              <td>
                <input
                  type="number"
                  id="atq71"
                  onChange={(e) => setValueatq71(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq72"
                  onChange={(e) => setValueatq72(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq73"
                  onChange={(e) => setValueatq73(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq74"
                  onChange={(e) => setValueatq74(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq75"
                  onChange={(e) => setValueatq75(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq76"
                  onChange={(e) => setValueatq76(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq77"
                  onChange={(e) => setValueatq77(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq78"
                  onChange={(e) => setValueatq78(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq79"
                  onChange={(e) => setValueatq79(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq710"
                  onChange={(e) => setValueatq710(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG</th>
              <td>
                <input
                  type="number"
                  id="atq81"
                  onChange={(e) => setValueatq81(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq82"
                  onChange={(e) => setValueatq82(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq83"
                  onChange={(e) => setValueatq83(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq84"
                  onChange={(e) => setValueatq84(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq85"
                  onChange={(e) => setValueatq85(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq86"
                  onChange={(e) => setValueatq86(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq87"
                  onChange={(e) => setValueatq87(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq88"
                  onChange={(e) => setValueatq88(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq89"
                  onChange={(e) => setValueatq89(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq810"
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
                  type="number"
                  id="atq91"
                  onChange={(e) => setValueatq91(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq92"
                  onChange={(e) => setValueatq92(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq93"
                  onChange={(e) => setValueatq93(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq94"
                  onChange={(e) => setValueatq94(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq95"
                  onChange={(e) => setValueatq95(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq96"
                  onChange={(e) => setValueatq96(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq97"
                  onChange={(e) => setValueatq97(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq98"
                  onChange={(e) => setValueatq98(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq99"
                  onChange={(e) => setValueatq99(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq910"
                  onChange={(e) => setValueatq910(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Ph.D.</th>
              <td>
                <input
                  type="number"
                  id="atq101"
                  onChange={(e) => setValueatq101(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq102"
                  onChange={(e) => setValueatq102(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq103"
                  onChange={(e) => setValueatq103(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq104"
                  onChange={(e) => setValueatq104(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq105"
                  onChange={(e) => setValueatq105(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq106"
                  onChange={(e) => setValueatq106(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq107"
                  onChange={(e) => setValueatq107(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq108"
                  onChange={(e) => setValueatq108(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq109"
                  onChange={(e) => setValueatq109(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq110"
                  onChange={(e) => setValueatq1010(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th> M.Phil.</th>
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
              <td>
                <input
                  type="number"
                  id="atq113"
                  onChange={(e) => setValueatq113(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq114"
                  onChange={(e) => setValueatq114(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq115"
                  onChange={(e) => setValueatq115(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq116"
                  onChange={(e) => setValueatq116(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq117"
                  onChange={(e) => setValueatq117(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq118"
                  onChange={(e) => setValueatq118(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq119"
                  onChange={(e) => setValueatq119(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq1110"
                  onChange={(e) => setValueatq1110(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG</th>
              <td>
                <input
                  type="number"
                  id="atq121"
                  onChange={(e) => setValueatq121(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq122"
                  onChange={(e) => setValueatq122(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq123"
                  onChange={(e) => setValueatq123(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq124"
                  onChange={(e) => setValueatq124(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq125"
                  onChange={(e) => setValueatq125(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq126"
                  onChange={(e) => setValueatq126(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq127"
                  onChange={(e) => setValueatq127(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq128"
                  onChange={(e) => setValueatq128(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq129"
                  onChange={(e) => setValueatq129(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq1210"
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
                  type="number"
                  id="aa11"
                  onChange={(e) => setValueaa11(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa12"
                  onChange={(e) => setValueaa12(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa13"
                  onChange={(e) => setValueaa13(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa14"
                  onChange={(e) => setValueaa14(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  type="number"
                  id="aa21"
                  onChange={(e) => setValueaa21(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa22"
                  onChange={(e) => setValueaa22(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa23"
                  onChange={(e) => setValueaa23(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa24"
                  onChange={(e) => setValueaa24(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  type="number"
                  id="aa31"
                  onChange={(e) => setValueaa31(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa32"
                  onChange={(e) => setValueaa32(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa33"
                  onChange={(e) => setValueaa33(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa34"
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
                  type="number"
                  id="aa41"
                  onChange={(e) => setValueaa41(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa42"
                  onChange={(e) => setValueaa42(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa43"
                  onChange={(e) => setValueaa43(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa44"
                  onChange={(e) => setValueaa44(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  type="number"
                  id="aa51"
                  onChange={(e) => setValueaa51(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa52"
                  onChange={(e) => setValueaa52(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa53"
                  onChange={(e) => setValueaa53(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa54"
                  onChange={(e) => setValueaa54(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  type="number"
                  id="aa61"
                  onChange={(e) => setValueaa61(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa62"
                  onChange={(e) => setValueaa62(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa63"
                  onChange={(e) => setValueaa63(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa64"
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
                  type="number"
                  id="aa71"
                  onChange={(e) => setValueaa71(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa72"
                  onChange={(e) => setValueaa72(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa73"
                  onChange={(e) => setValueaa73(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa74"
                  onChange={(e) => setValueaa74(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  type="number"
                  id="aa81"
                  onChange={(e) => setValueaa81(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa82"
                  onChange={(e) => setValueaa82(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa83"
                  onChange={(e) => setValueaa83(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa84"
                  onChange={(e) => setValueaa84(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  type="number"
                  id="aa91"
                  onChange={(e) => setValueaa91(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa92"
                  onChange={(e) => setValueaa92(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa93"
                  onChange={(e) => setValueaa93(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa94"
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
                  type="number"
                  id="aa101"
                  onChange={(e) => setValueaa101(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa102"
                  onChange={(e) => setValueaa102(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa103"
                  onChange={(e) => setValueaa103(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa104"
                  onChange={(e) => setValueaa104(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  type="number"
                  id="aa111"
                  onChange={(e) => setValueaa111(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa112"
                  onChange={(e) => setValueaa112(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa113"
                  onChange={(e) => setValueaa113(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa114"
                  onChange={(e) => setValueaa114(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  type="number"
                  id="aa121"
                  onChange={(e) => setValueaa121(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa122"
                  onChange={(e) => setValueaa122(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa123"
                  onChange={(e) => setValueaa123(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa124"
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
                  type="number"
                  id="aa131"
                  onChange={(e) => setValueaa131(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa132"
                  onChange={(e) => setValueaa132(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa133"
                  onChange={(e) => setValueaa133(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa134"
                  onChange={(e) => setValueaa134(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Female</td>
              <td>
                <input
                  type="number"
                  id="aa141"
                  onChange={(e) => setValueaa141(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa142"
                  onChange={(e) => setValueaa142(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa143"
                  onChange={(e) => setValueaa143(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa144"
                  onChange={(e) => setValueaa144(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Others</td>
              <td>
                <input
                  type="number"
                  id="aa151"
                  onChange={(e) => setValueaa151(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa152"
                  onChange={(e) => setValueaa152(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa153"
                  onChange={(e) => setValueaa153(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa154"
                  onChange={(e) => setValueaa154(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Total</th>
              <td>
                {/* <input
                  type="text"
                  id="aa161"
                  onChange={(e) => setValueaa161(e.target.value)}
                /> */}
              </td>
              <td>
                <input
                  type="number"
                  id="aa162"
                  onChange={(e) => setValueaa162(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa163"
                  onChange={(e) => setValueaa163(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa164"
                  onChange={(e) => setValueaa164(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="aa165"
                  onChange={(e) => setValueaa165(e.target.value)}
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

export default AcademicInfo;
