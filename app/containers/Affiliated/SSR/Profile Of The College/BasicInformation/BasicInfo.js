import { FormControl, FormControlLabel,RadioGroup,Radio, FormLabel } from "@material-ui/core";
import React, { useState,useEffect } from "react";
import { toast } from "react-toastify";
import "./BasicInfo-style.css";
import AuthService from "../../../../Pages/Users/services/auth.service";

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

function BasicInfo() {
  const [valuebt1, setValuebt1] = useState("");
  const [valuebt2, setValuebt2] = useState("");
  const [valuebt3, setValuebt3] = useState("");
  const [valuebt4, setValuebt4] = useState("");
  const [valuebt5, setValuebt5] = useState("");
  const [valuebt6, setValuebt6] = useState("");

  const [valuebtc2, setValuebtc2] = useState("");
  const [valuebtc3, setValuebtc3] = useState("");
  const [valuebtc4, setValuebtc4] = useState("");
  const [valuebtc5, setValuebtc5] = useState("");
  const [valuebtc6, setValuebtc6] = useState("");

  const [valuebtc21, setValuebtc21] = useState("");
  const [valuebtc31, setValuebtc31] = useState("");
  const [valuebtc41, setValuebtc41] = useState("");
  const [valuebtc51, setValuebtc51] = useState("");
  const [valuebtc61, setValuebtc61] = useState("");

  const [valuebtc22, setValuebtc22] = useState("");
  const [valuebtc32, setValuebtc32] = useState("");
  const [valuebtc42, setValuebtc42] = useState("");
  const [valuebtc52, setValuebtc52] = useState("");
  const [valuebtc62, setValuebtc62] = useState("");

  const [valuebti1, setValuebti1] = useState("");
  const [valuebti11, setValuebti11] = useState("");
  const [valuebti12, setValuebti12] = useState("");

  const [valuebtr11, setValuebtr11] = useState("");
  const [valuebtr12, setValuebtr12] = useState("");
  const [valuebtr13, setValuebtr13] = useState("");
  const [valuebtr14, setValuebtr14] = useState("");
  const [valuebtr15, setValuebtr15] = useState("");
  const [valuebtr16, setValuebtr16] = useState("");
  const [valuebtr17, setValuebtr17] = useState("");
  const [valuebtr18, setValuebtr18] = useState("");

  const [valuebtd11, setValuebtd11] = useState("");
  const [valuebtd12, setValuebtd12] = useState("");
  const [valuebtd13, setValuebtd13] = useState("");
  const [valuebtd14, setValuebtd14] = useState("");
  const [valuebtd15, setValuebtd15] = useState("");

  const [valuebtd21, setValuebtd21] = useState("");
  const [valuebtd22, setValuebtd22] = useState("");
  const [valuebtd23, setValuebtd23] = useState("");
  const [valuebtd24, setValuebtd24] = useState("");
  const [valuebtd25, setValuebtd25] = useState("");

  const [valuebtd31, setValuebtd31] = useState("");
  const [valuebtd32, setValuebtd32] = useState("");
  const [valuebtd33, setValuebtd33] = useState("");
  const [valuebtd34, setValuebtd34] = useState("");
  const [valuebtd35, setValuebtd35] = useState("");

  const [valuebtd41, setValuebtd41] = useState("");
  const [valuebtd42, setValuebtd42] = useState("");
  const [valuebtd43, setValuebtd43] = useState("");
  const [valuebtd44, setValuebtd44] = useState("");
  const [valuebtd45, setValuebtd45] = useState("");

  const [valuebtu11, setValuebtu11] = useState("");
  const [valuebtu12, setValuebtu12] = useState("");

  const [valuebtc11, setValuebtc11] = useState("");
  const [valuebtc12, setValuebtc12] = useState("");
  const [valuebtc13, setValuebtc13] = useState("");
  const [valuebtc14, setValuebtc14] = useState("");
  const [valuebtc15, setValuebtc15] = useState("");
  const [valuebtc16, setValuebtc16] = useState("");

  const [valuebtl1, setValuebtl1] = useState("");
  const [valuebtl2, setValuebtl2] = useState("");
  const [valuebtl3, setValuebtl3] = useState("");

  const [valuebtp11, setValuebtp11] = useState("");
  const [valuebtp12, setValuebtp12] = useState("");
  const [valuebtp13, setValuebtp13] = useState("");
  const [valuebtp14, setValuebtp14] = useState("");
  const [valuebtp15, setValuebtp15] = useState("");
  const [valuebtp16, setValuebtp16] = useState("");
  const [valuebtp17, setValuebtp17] = useState("");
  const [valuebtp18, setValuebtp18] = useState("");
  const [valuebtp19, setValuebtp19] = useState("");
  const [valuebtp20, setValuebtp20] = useState("");
  const [valuebtp21, setValuebtp21] = useState("");
  const [valuebtp22, setValuebtp22] = useState("");
  const [valuebtp23, setValuebtp23] = useState("");
  const [valuebtp24, setValuebtp24] = useState("");

  const [valuebtp31, setValuebtp31] = useState("");
  const [valuebtp32, setValuebtp32] = useState("");
  const [valuebtp33, setValuebtp33] = useState("");
  const [valuebtp34, setValuebtp34] = useState("");
  const [valuebtp41, setValuebtp41] = useState("");
  const [valuebtp42, setValuebtp42] = useState("");
  const [valuebtp43, setValuebtp43] = useState("");
  const [valuebtp44, setValuebtp44] = useState("");
  const [valuebtp51, setValuebtp51] = useState("");
  const [valuebtp52, setValuebtp52] = useState("");
  const [valuebtp53, setValuebtp53] = useState("");
  const [valuebtp54, setValuebtp54] = useState("");

  const [valueat11, setValueat11] = useState("");
  const [valueat12, setValueat12] = useState("");
  const [valueat13, setValueat13] = useState("");
  const [valueat14, setValueat14] = useState("");
  const [valueat15, setValueat15] = useState("");
  const [valueat16, setValueat16] = useState("");
  const [valueat17, setValueat17] = useState("");
  const [valueat18, setValueat18] = useState("");

  const [valueat21, setValueat21] = useState("");
  const [valueat22, setValueat22] = useState("");
  const [valueat23, setValueat23] = useState("");
  const [valueat24, setValueat24] = useState("");
  const [valueat25, setValueat25] = useState("");
  const [valueat26, setValueat26] = useState("");
  const [valueat27, setValueat27] = useState("");
  const [valueat28, setValueat28] = useState("");

  const [valueat31, setValueat31] = useState("");
  const [valueat32, setValueat32] = useState("");
  const [valueat33, setValueat33] = useState("");
  const [valueat34, setValueat34] = useState("");
  const [valueat35, setValueat35] = useState("");
  const [valueat36, setValueat36] = useState("");
  const [valueat37, setValueat37] = useState("");
  const [valueat38, setValueat38] = useState("");

  const [valueat41, setValueat41] = useState("");
  const [valueat42, setValueat42] = useState("");
  const [valueat43, setValueat43] = useState("");
  const [valueat44, setValueat44] = useState("");
  const [valueat45, setValueat45] = useState("");
  const [valueat46, setValueat46] = useState("");
  const [valueat47, setValueat47] = useState("");
  const [valueat48, setValueat48] = useState("");

  const [valueat51, setValueat51] = useState("");
  const [valueat52, setValueat52] = useState("");
  const [valueat53, setValueat53] = useState("");
  const [valueat54, setValueat54] = useState("");
  const [valueat55, setValueat55] = useState("");
  const [valueat56, setValueat56] = useState("");
  const [valueat57, setValueat57] = useState("");
  const [valueat58, setValueat58] = useState("");

  const [valueat61, setValueat61] = useState("");
  const [valueat62, setValueat62] = useState("");
  const [valueat63, setValueat63] = useState("");
  const [valueat64, setValueat64] = useState("");
  const [valueat65, setValueat65] = useState("");
  const [valueat66, setValueat66] = useState("");
  const [valueat67, setValueat67] = useState("");
  const [valueat68, setValueat68] = useState("");

  const [valueatq11, setValueatq11] = useState("");
  const [valueatq12, setValueatq12] = useState("");
  const [valueatq13, setValueatq13] = useState("");
  const [valueatq14, setValueatq14] = useState("");
  const [valueatq15, setValueatq15] = useState("");
  const [valueatq16, setValueatq16] = useState("");
  const [valueatq17, setValueatq17] = useState("");

  const [valueatq21, setValueatq21] = useState("");
  const [valueatq22, setValueatq22] = useState("");
  const [valueatq23, setValueatq23] = useState("");
  const [valueatq24, setValueatq24] = useState("");
  const [valueatq25, setValueatq25] = useState("");
  const [valueatq26, setValueatq26] = useState("");
  const [valueatq27, setValueatq27] = useState("");

  const [valueatq31, setValueatq31] = useState("");
  const [valueatq32, setValueatq32] = useState("");
  const [valueatq33, setValueatq33] = useState("");
  const [valueatq34, setValueatq34] = useState("");
  const [valueatq35, setValueatq35] = useState("");
  const [valueatq36, setValueatq36] = useState("");
  const [valueatq37, setValueatq37] = useState("");

  const [valueatq41, setValueatq41] = useState("");
  const [valueatq42, setValueatq42] = useState("");
  const [valueatq43, setValueatq43] = useState("");
  const [valueatq44, setValueatq44] = useState("");
  const [valueatq45, setValueatq45] = useState("");
  const [valueatq46, setValueatq46] = useState("");
  const [valueatq47, setValueatq47] = useState("");

  const [valueatq51, setValueatq51] = useState("");
  const [valueatq52, setValueatq52] = useState("");
  const [valueatq53, setValueatq53] = useState("");
  const [valueatq54, setValueatq54] = useState("");
  const [valueatq55, setValueatq55] = useState("");
  const [valueatq56, setValueatq56] = useState("");
  const [valueatq57, setValueatq57] = useState("");

  const [valueatq61, setValueatq61] = useState("");
  const [valueatq62, setValueatq62] = useState("");
  const [valueatq63, setValueatq63] = useState("");
  const [valueatq64, setValueatq64] = useState("");
  const [valueatq65, setValueatq65] = useState("");
  const [valueatq66, setValueatq66] = useState("");
  const [valueatq67, setValueatq67] = useState("");

  const [valueatq71, setValueatq71] = useState("");
  const [valueatq72, setValueatq72] = useState("");
  const [valueatq73, setValueatq73] = useState("");
  const [valueatq74, setValueatq74] = useState("");
  const [valueatq75, setValueatq75] = useState("");
  const [valueatq76, setValueatq76] = useState("");
  const [valueatq77, setValueatq77] = useState("");

  const [valueatq81, setValueatq81] = useState("");
  const [valueatq82, setValueatq82] = useState("");
  const [valueatq83, setValueatq83] = useState("");
  const [valueatq84, setValueatq84] = useState("");
  const [valueatq85, setValueatq85] = useState("");
  const [valueatq86, setValueatq86] = useState("");
  const [valueatq87, setValueatq87] = useState("");

  const [valueatq91, setValueatq91] = useState("");
  const [valueatq92, setValueatq92] = useState("");
  const [valueatq93, setValueatq93] = useState("");
  const [valueatq94, setValueatq94] = useState("");
  const [valueatq95, setValueatq95] = useState("");
  const [valueatq96, setValueatq96] = useState("");
  const [valueatq97, setValueatq97] = useState("");

  const [valueatq101, setValueatq101] = useState("");
  const [valueatq102, setValueatq102] = useState("");
  const [valueatq103, setValueatq103] = useState("");
  const [valueatq104, setValueatq104] = useState("");
  const [valueatq105, setValueatq105] = useState("");
  const [valueatq106, setValueatq106] = useState("");
  const [valueatq107, setValueatq107] = useState("");

  const [valueatq111, setValueatq111] = useState("");
  const [valueatq112, setValueatq112] = useState("");
  const [valueatq113, setValueatq113] = useState("");
  const [valueatq114, setValueatq114] = useState("");
  const [valueatq115, setValueatq115] = useState("");
  const [valueatq116, setValueatq116] = useState("");
  const [valueatq117, setValueatq117] = useState("");

  const [valueatq121, setValueatq121] = useState("");
  const [valueatq122, setValueatq122] = useState("");
  const [valueatq123, setValueatq123] = useState("");
  const [valueatq124, setValueatq124] = useState("");
  const [valueatq125, setValueatq125] = useState("");
  const [valueatq126, setValueatq126] = useState("");
  const [valueatq127, setValueatq127] = useState("");

  const [valueatq131, setValueatq131] = useState("");
  const [valueatq132, setValueatq132] = useState("");
  const [valueatq133, setValueatq133] = useState("");
  const [valueatq134, setValueatq134] = useState("");
  const [valueatq135, setValueatq135] = useState("");
  const [valueatq136, setValueatq136] = useState("");
  const [valueatq137, setValueatq137] = useState("");

  const [valueatq141, setValueatq141] = useState("");
  const [valueatq142, setValueatq142] = useState("");
  const [valueatq143, setValueatq143] = useState("");
  const [valueatq144, setValueatq144] = useState("");
  const [valueatq145, setValueatq145] = useState("");
  const [valueatq146, setValueatq146] = useState("");
  const [valueatq147, setValueatq147] = useState("");

  const [valueatq151, setValueatq151] = useState("");
  const [valueatq152, setValueatq152] = useState("");
  const [valueatq153, setValueatq153] = useState("");
  const [valueatq154, setValueatq154] = useState("");
  const [valueatq155, setValueatq155] = useState("");
  const [valueatq156, setValueatq156] = useState("");
  const [valueatq157, setValueatq157] = useState("");

  // const [valueatq161, setValueatq161] = useState("");
  // const [valueatq162, setValueatq162] = useState("");
  // const [valueatq163, setValueatq163] = useState("");
  // const [valueatq164, setValueatq164] = useState("");
  // const [valueatq165, setValueatq165] = useState("");
  // const [valueatq166, setValueatq166] = useState("");
  // const [valueatq167, setValueatq167] = useState("");

  const [valueatg1, setValueatg1] = useState("");

  const [valueatg11, setValueatg11] = useState("");
  const [valueatg12, setValueatg12] = useState("");
  const [valueatg13, setValueatg13] = useState("");
  const [valueatg14, setValueatg14] = useState("");
  const [valueatg15, setValueatg15] = useState("");
  const [valueatg16, setValueatg16] = useState("");
  const [valueatg17, setValueatg17] = useState("");
  const [valueatg18, setValueatg18] = useState("");

  const [valueatg21, setValueatg21] = useState("");
  const [valueatg22, setValueatg22] = useState("");
  const [valueatg23, setValueatg23] = useState("");
  const [valueatg24, setValueatg24] = useState("");
  const [valueatg25, setValueatg25] = useState("");
  const [valueatg26, setValueatg26] = useState("");
  const [valueatg27, setValueatg27] = useState("");
  const [valueatg28, setValueatg28] = useState("");

  const [valueatg31, setValueatg31] = useState("");
  const [valueatg32, setValueatg32] = useState("");
  const [valueatg33, setValueatg33] = useState("");
  const [valueatg34, setValueatg34] = useState("");
  const [valueatg35, setValueatg35] = useState("");
  const [valueatg36, setValueatg36] = useState("");
  const [valueatg37, setValueatg37] = useState("");
  const [valueatg38, setValueatg38] = useState("");

  const [valueatg41, setValueatg41] = useState("");
  const [valueatg42, setValueatg42] = useState("");
  const [valueatg43, setValueatg43] = useState("");
  const [valueatg44, setValueatg44] = useState("");
  const [valueatg45, setValueatg45] = useState("");
  const [valueatg46, setValueatg46] = useState("");
  const [valueatg47, setValueatg47] = useState("");
  const [valueatg48, setValueatg48] = useState("");

  const [valueatg51, setValueatg51] = useState("");
  const [valueatg52, setValueatg52] = useState("");
  const [valueatg53, setValueatg53] = useState("");
  const [valueatg54, setValueatg54] = useState("");
  const [valueatg55, setValueatg55] = useState("");
  const [valueatg56, setValueatg56] = useState("");
  const [valueatg57, setValueatg57] = useState("");
  const [valueatg58, setValueatg58] = useState("");

  const [valuebtpp11, setValuebtpp11] = useState("");
  const [valuebtpp12, setValuebtpp12] = useState("");
  const [valuebtpp13, setValuebtpp13] = useState("");
  const [valuebtpp14, setValuebtpp14] = useState("");
  const [valuebtpp15, setValuebtpp15] = useState("");

  const [valuebtpp21, setValuebtpp21] = useState("");
  const [valuebtpp22, setValuebtpp22] = useState("");
  const [valuebtpp23, setValuebtpp23] = useState("");
  const [valuebtpp24, setValuebtpp24] = useState("");
  const [valuebtpp25, setValuebtpp25] = useState("");

  const [valuebtpp31, setValuebtpp31] = useState("");
  const [valuebtpp32, setValuebtpp32] = useState("");
  const [valuebtpp33, setValuebtpp33] = useState("");
  const [valuebtpp34, setValuebtpp34] = useState("");
  const [valuebtpp35, setValuebtpp35] = useState("");

  const [valuebtpp41, setValuebtpp41] = useState("");
  const [valuebtpp42, setValuebtpp42] = useState("");
  const [valuebtpp43, setValuebtpp43] = useState("");
  const [valuebtpp44, setValuebtpp44] = useState("");
  const [valuebtpp45, setValuebtpp45] = useState("");

  const [valuebtpp51, setValuebtpp51] = useState("");
  const [valuebtpp52, setValuebtpp52] = useState("");
  const [valuebtpp53, setValuebtpp53] = useState("");
  const [valuebtpp54, setValuebtpp54] = useState("");
  const [valuebtpp55, setValuebtpp55] = useState("");

  const [valuebtpp61, setValuebtpp61] = useState("");
  const [valuebtpp62, setValuebtpp62] = useState("");
  const [valuebtpp63, setValuebtpp63] = useState("");

  const [valuebtda1, setValuebtda1] = useState("");
  const [valuebtda2, setValuebtda2] = useState("");
  const [valuebtda3, setValuebtda3] = useState("");
  const [valuebtda4, setValuebtda4] = useState("");
  const [valuebtda5, setValuebtda5] = useState("");
  const [valuebtda6, setValuebtda6] = useState("");
  const [valuebtda7, setValuebtda7] = useState("");
  const [valuebtda8, setValuebtda8] = useState("");
  const [valuebtda9, setValuebtda9] = useState("");

  const [valuebtdr1, setValuebtdr1] = useState("");
  const [valuebtdr2, setValuebtdr2] = useState("");
  const [valuebtdr3, setValuebtdr3] = useState("");
  const [valuebtdr4, setValuebtdr4] = useState("");

   





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


  
  // sending data to db with API
  const financialYear="2021-2022";
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType,
      inputatg1: valueatg1
    },

   
    basicProfile: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:101,
        inputbt1: valuebt1,
        inputbt2: valuebt2,
        inputbt3: valuebt3,
        inputbt4: valuebt4,
        inputbt5: valuebt5,
        inputbt6: valuebt6,        
      },
    ],
    contactsforCommunication:[
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:101,
        inputbtc2: valuebtc2,
        inputbtc3: valuebtc3,
        inputbtc4: valuebtc4,
        inputbtc5: valuebtc5,
        inputbtc6: valuebtc6,
    },
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

      uniqueKey1:102,
      inputbtc2: valuebtc21,
      inputbtc3: valuebtc31,
      inputbtc4: valuebtc41,
      inputbtc5: valuebtc51,
      inputbtc6: valuebtc61,
  },
  {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    uniqueKey1:103,
    inputbtc2: valuebtc22,
    inputbtc3: valuebtc32,
    inputbtc4: valuebtc42,
    inputbtc5: valuebtc52,
    inputbtc6: valuebtc62,
}
  ],
    affiliatedStatus: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

      uniqueKey1:101,
        inputst1: valuebti1,
        inputst2: valuebti11,
        inputst3: valuebti12,
        inputst4: valuebtr11,
        inputst5: valuebtr12,
        inputst6: valuebtr13,
        inputst7: valuebtr14,
        inputst8: valuebtu11,
        inputst11: valuebtu12,
        inputst12: valuebtc11,
        inputst13: valuebtc12,
        inputst14: valuebtc13,
        inputst15: valuebtc14,
        inputst16: valuebtc15,
        inputst17: valuebtc16,
      }
    ],
    
    detailsofUgcRecognition:[
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:101,
        inputst9: valuebtr15,
       inputst10:valuebtr16,

    },
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

      uniqueKey1:102,
      inputst9: valuebtr17,
      inputst10: valuebtr18,

  },

  ],


  affiliatedCampus:[
    {
     
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:101,
        inputst18: valuebtl1,
        inputst19: valuebtl2,
        inputst20: valuebtl3,

    },


  ],

    recognition: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:101,
        inputbtd15: valuebtd11,
        inputbtd11: valuebtd12,
        inputbtd12: valuebtd13,
        inputbtd13: valuebtd14,
        inputbtd14: valuebtd15,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:102,
        inputbtd15: valuebtd21,
        inputbtd11: valuebtd22,
        inputbtd12: valuebtd23,
        inputbtd13: valuebtd24,
        inputbtd14: valuebtd25,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:103,
        inputbtd15: valuebtd31,
        inputbtd11: valuebtd32,
        inputbtd12: valuebtd33,
        inputbtd13: valuebtd34,
        inputbtd14: valuebtd35,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:104,
        inputbtd15: valuebtd41,
        inputbtd11: valuebtd42,
        inputbtd12: valuebtd43,
        inputbtd13: valuebtd44,
        inputbtd14: valuebtd45,
      },
    ],
    academicinformation: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:101,
        inputad1: valuebtp11,
        inputad11: valuebtp12,
        inputad12: valuebtp13,
        inputad13: valuebtp14,
        inputad14: valuebtp15,
        inputad15: valuebtp16,
        inputad16: valuebtp17,
        inputad17: valuebtp18,
      },
    ],

    affiliatedProgrammes: [
      {    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

      uniqueKey1:101,
        inputpt1: valuebtp19,
        inputpt2: valuebtp20,
      },
    ],
    
    affiliatedDepartment: [
      {    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

      uniqueKey1:101,
        inputdt2: valuebtp21,
        inputdt3: valuebtp22,
        inputdt4: valuebtp23,
        inputdt5: valuebtp24,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:102,
        inputdt2: valuebtp31,
        inputdt3: valuebtp32,
        inputdt4: valuebtp33,
        inputdt5: valuebtp34,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:103,
        inputdt2: valuebtp41,
        inputdt3: valuebtp42,
        inputdt4: valuebtp43,
        inputdt5: valuebtp44,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:104,
        inputdt2: valuebtp51,
        inputdt3: valuebtp52,
        inputdt4: valuebtp53,
        inputdt5: valuebtp54,
      },
    ],
    
    affiliatedInstitution: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

      uniqueKey1:101,
      inputatt1: valueat11,
      inputatt2: valueat12,
      inputatt3: valueat13,
      inputatt4: valueat14,
      inputatt5: valueat15,
      inputatt6: valueat16,
      inputatt7: valueat17,
      inputatt8: valueat18,
       
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:102,
        inputatt1: valueat21,
        inputatt2: valueat22,
        inputatt3: valueat23,
        inputatt4: valueat24,
        inputatt5: valueat25,
        inputatt6: valueat26,
        inputatt7: valueat27,
        inputatt8: valueat28,
      
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:103,
      inputatt1: valueat31,
      inputatt2: valueat32,
      inputatt3: valueat33,
      inputatt4: valueat34,
      inputatt5: valueat35,
      inputatt6: valueat36,
      inputatt7: valueat37,
      inputatt8: valueat38,
       
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:104,
      inputatt1: valueat41,
      inputatt2: valueat42,
      inputatt3: valueat43,
      inputatt4: valueat44,
      inputatt5: valueat45,
      inputatt6: valueat46,
      inputatt7: valueat47,
      inputatt8: valueat48,
       
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:105,
        inputatt1: valueat51,
        inputatt2: valueat52,
        inputatt3: valueat53,
        inputatt4: valueat54,
        inputatt5: valueat55,
        inputatt6: valueat56,
        inputatt7: valueat57,
        inputatt8: valueat58,
      
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:106,
      inputatt1: valueat61,
      inputatt2: valueat62,
      inputatt3: valueat63,
      inputatt4: valueat64,
      inputatt5: valueat65,
      inputatt6: valueat66,
      inputatt7: valueat67,
      inputatt8: valueat68,
    
      },
 
    ],
    affiliatedTeachingstaff:[
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:101,
        inputats1:valueatq11,
        inputats2:valueatq12,
        inputats3:valueatq13,
        inputats4:valueatq14,
        inputats5:valueatq15,
        inputats6:valueatq16,
        inputats7:valueatq17,
        },
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         
          uniqueKey1:102,
          inputats1:valueatq21,
          inputats2:valueatq22,
          inputats3:valueatq23,
          inputats4:valueatq24,
          inputats5:valueatq25,
          inputats6:valueatq26,
          inputats7:valueatq27,
        
        },
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

          uniqueKey1:103,
        inputats1:valueatq31,
        inputats2:valueatq32,
        inputats3:valueatq33,
        inputats4:valueatq34,
        inputats5:valueatq35,
        inputats6:valueatq36,
        inputats7:valueatq37,
        
        },
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         
          uniqueKey1:104,
        inputats1:valueatq41,
        inputats2:valueatq42,
        inputats3:valueatq43,
        inputats4:valueatq44,
        inputats5:valueatq45,
        inputats6:valueatq46,
        inputats7:valueatq47,
        
        },
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         
          uniqueKey1:105,
        inputats1:valueatq51,
        inputats2:valueatq52,
        inputats3:valueatq53,
        inputats4:valueatq54,
        inputats5:valueatq55,
        inputats6:valueatq56,
        inputats7:valueatq57,
        
        },
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         
          uniqueKey1:106,
        inputats1:valueatq61,
        inputats2:valueatq62,
        inputats3:valueatq63,
        inputats4:valueatq64,
        inputats5:valueatq65,
        inputats6:valueatq66,
        inputats7:valueatq67,
        
        },
         {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         
          uniqueKey1:107,
        inputats1:valueatq71,
        inputats2:valueatq72,
        inputats3:valueatq73,
        inputats4:valueatq74,
        inputats5:valueatq75,
        inputats6:valueatq76,
        inputats7:valueatq77,
        
        },
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

          uniqueKey1:108,
        inputats1:valueatq81,
        inputats2:valueatq82,
        inputats3:valueatq83,
        inputats4:valueatq84,
        inputats5:valueatq85,
        inputats6:valueatq86,
        inputats7:valueatq87,
        
        },
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

          uniqueKey1:109,
        inputats1:valueatq91,
        inputats2:valueatq92,
        inputats3:valueatq93,
        inputats4:valueatq94,
        inputats5:valueatq95,
        inputats6:valueatq96,
        inputats7:valueatq97,
        
        },
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

          uniqueKey1:110,
        inputats1:valueatq101,
        inputats2:valueatq102,
        inputats3:valueatq103,
        inputats4:valueatq104,
        inputats5:valueatq105,
        inputats6:valueatq106,
        inputats7:valueatq107,
        
        },
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         
          uniqueKey1:111,
          inputats1:valueatq111,
          inputats2:valueatq112,
          inputats3:valueatq113,
          inputats4:valueatq114,
          inputats5:valueatq115,
          inputats6:valueatq116,
          inputats7:valueatq117,
        
        },
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         
          uniqueKey1:112,
          inputats1:valueatq121,
          inputats2:valueatq122,
          inputats3:valueatq123,
          inputats4:valueatq124,
          inputats5:valueatq125,
          inputats6:valueatq126,
          inputats7:valueatq127,
        },
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

          uniqueKey1:113,
          inputats1:valueatq131,
          inputats2:valueatq132,
          inputats3:valueatq133,
          inputats4:valueatq134,
          inputats5:valueatq135,
          inputats6:valueatq136,
          inputats7:valueatq137,
        },
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         
          uniqueKey1:114,
          inputats1:valueatq141,
          inputats2:valueatq142,
          inputats3:valueatq143,
          inputats4:valueatq144,
          inputats5:valueatq145,
          inputats6:valueatq146,
          inputats7:valueatq147,
        },
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         
          uniqueKey1:115,
          inputats1:valueatq151,
          inputats2:valueatq152,
          inputats3:valueatq153,
          inputats4:valueatq154,
          inputats5:valueatq155,
          inputats6:valueatq156,
          inputats7:valueatq157,

        },
],

affiliatedAdmittstudents: [
  {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    uniqueKey1:101,
    inputat1: valueatg11,
    inputat2: valueatg12,
    inputat3: valueatg13,
    inputat4: valueatg14,
    inputat5: valueatg15,
    inputat6: valueatg16,
    inputat7: valueatg17,
    inputat8: valueatg18,
  },
  {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    uniqueKey1:102,
    inputat1: valueatg21,
    inputat2: valueatg22,
    inputat3: valueatg23,
    inputat4: valueatg24,
    inputat5: valueatg25,
    inputat6: valueatg26,
    inputat7: valueatg27,
    inputat8: valueatg28,
  },
  {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    uniqueKey1:103,
    inputat1: valueatg31,
    inputat2: valueatg32,
    inputat3: valueatg33,
    inputat4: valueatg34,
    inputat5: valueatg35,
    inputat6: valueatg36,
    inputat7: valueatg37,
    inputat8: valueatg38,
  },
  {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    uniqueKey1:104,
    inputat1: valueatg41,
    inputat2: valueatg42,
    inputat3: valueatg43,
    inputat4: valueatg44,
    inputat5: valueatg45,
    inputat6: valueatg46,
    inputat7: valueatg47,
    inputat8: valueatg48,
  },
  {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    uniqueKey1:105,
    inputat1: valueatg51,
    inputat2: valueatg52,
    inputat3: valueatg53,
    inputat4: valueatg54,
    inputat5: valueatg55,
    inputat6: valueatg56,
    inputat7: valueatg57,
    inputat8: valueatg58,
  },
],
    affiliatedEnrollment: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:101,
        inputet2: valuebtpp11,
        inputet3: valuebtpp12,
        inputet4: valuebtpp13,
        inputet5: valuebtpp14,
        inputet6: valuebtpp15,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:102,
        inputet2: valuebtpp21,
        inputet3: valuebtpp22,
        inputet4: valuebtpp23,
        inputet5: valuebtpp24,
        inputet6: valuebtpp25,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:103,
        inputet2: valuebtpp31,
        inputet3: valuebtpp32,
        inputet4: valuebtpp33,
        inputet5: valuebtpp34,
        inputet6: valuebtpp35,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:104,
        inputet2: valuebtpp41,
        inputet3: valuebtpp42,
        inputet4: valuebtpp43,
        inputet5: valuebtpp44,
        inputet6: valuebtpp45,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:105,
        inputet2: valuebtpp51,
        inputet3: valuebtpp52,
        inputet4: valuebtpp53,
        inputet5: valuebtpp54,
        inputet6: valuebtpp55,
      },
    ],
    affiliatedEducation: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:101,
        inputct1: valuebtpp61,
        inputct2: valuebtpp62,
        inputct3: valuebtpp63,
      },
    ],
    affiliatedAccrediation: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:101,
        inputat1: valuebtda1,
        inputat2: valuebtda2,
        inputat3: valuebtda3,
        inputat4: valuebtda4,
        inputat5: valuebtda5,
        inputat6: valuebtda6,
        inputat7: valuebtda7,
        inputat8: valuebtda8,


        // inputat9: valuebtda9,

        // inputat10: valuebtdr1,
        // inputat11: valuebtdr2,
        // inputat12: valuebtdr3,
        // inputat13: valuebtdr4,
      },
    ],
    affiliatedAnnualQuality: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1:101,
         inputat9: valuebtda9,
         inputat10: valuebtdr1,
         inputat11: valuebtdr2,
         inputat12: valuebtdr3,
         inputat13: valuebtdr4,
      },
    ],

  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave(e) {
    e.preventDefault();  
    console.log(JSON.stringify(inputDataList));
    const basicData = new FormData();

    basicData.append("ssrData", jsonBlob(inputDataList));
    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

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

  // rendering DOM
  return (
    <div className="main-container">
      <h1 className="main-heading-style">Profile of the College</h1>
      <div className="eachTable-container">
        <label htmlFor="basicInfo-t2" style={{ fontWeight: "bold" }}>
          1.Basic Information
        </label>
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th colSpan="2">1.Name and Address of the College</th>
            </tr>
            <tr>
              <th className="BI-table1-headings">Name</th>
              <td>
                <input
                  type="text"
                  id="bt1"
                  onChange={(e) => setValuebt1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Address</th>
              <td>
                <input
                  type="text"
                  id="bt2"
                  onChange={(e) => setValuebt2(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>City</th>
              <td>
                <input
                  type="text"
                  id="bt3"
                  onChange={(e) => setValuebt3(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>State</th>
              <td>
                <input
                  type="text"
                  id="bt4"
                  onChange={(e) => setValuebt4(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Pin</th>
              <td>
                <input
                  type="number"
                  id="bt5"
                  onChange={(e) => setValuebt5(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Website</th>
              <td>
                <input
                  type="text"
                  id="bt6"
                  onChange={(e) => setValuebt6(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t2" style={{ fontWeight: "bold" }}>
            2.Contacts for Communication
          </label>
          <table id="basicInfo-t2">
            <tr>
              <th style={{ width: "20%" }}>Designation</th>
              <th style={{ width: "20%" }}>Name</th>
              <th style={{ width: "15%" }}>Telephone with STD with code</th>
              <th style={{ width: "20%" }}>Mobile</th>
              <th style={{ width: "10%" }}>Fax</th>
              <th style={{ width: "20%" }}>e-mail</th>
            </tr>
            <tr>
              <td>Principal</td>
              <td>
                <input
                  id="btc2"
                  onChange={(e) => setValuebtc2(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  id="btc3"
                  onChange={(e) => setValuebtc3(e.target.value)}
                  type="number"
                />
              </td>
              <td>
                <input
                  id="btc4"
                  onChange={(e) => setValuebtc4(e.target.value)}
                  type="number"
                />
              </td>
              <td>
                <input
                  id="btc5"
                  onChange={(e) => setValuebtc5(e.target.value)}
                  type="number"
                />
              </td>
              <td>
                <input
                  id="btc6"
                  onChange={(e) => setValuebtc6(e.target.value)}
                  type="text"
                />
              </td>
            </tr>
            <tr>
              <td>Vice Principal</td>
              <td>
                <input
                  id="btc2"
                  onChange={(e) => setValuebtc21(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  id="btc3"
                  onChange={(e) => setValuebtc31(e.target.value)}
                  type="number"
                />
              </td>
              <td>
                <input
                  id="btc4"
                  onChange={(e) => setValuebtc41(e.target.value)}
                  type="number"
                />
              </td>
              <td>
                <input
                  id="btc5"
                  onChange={(e) => setValuebtc51(e.target.value)}
                  type="number"
                />
              </td>
              <td>
                <input
                  id="btc6"
                  onChange={(e) => setValuebtc61(e.target.value)}
                  type="text"
                />
              </td>
            </tr>
            <tr>
              <td>IQAC Co-ordinator</td>
              <td>
                <input
                  id="btc2"
                  onChange={(e) => setValuebtc22(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  id="btc3"
                  onChange={(e) => setValuebtc32(e.target.value)}
                  type="number"
                />
              </td>
              <td>
                <input
                  id="btc4"
                  onChange={(e) => setValuebtc42(e.target.value)}
                  type="number"
                />
              </td>
              <td>
                <input
                  id="btc5"
                  onChange={(e) => setValuebtc52(e.target.value)}
                  type="number"
                />
              </td>
              <td>
                <input
                  id="btc6"
                  onChange={(e) => setValuebtc62(e.target.value)}
                  type="text"
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label style={{ fontWeight: "500" }}>
            3. Status of the Institution: Affiliated College constituent College
            Any other (specify)
          
          <input
            type="text"
            style={{ width: "20%", marginLeft: "300px" }}
            id="bti1"
            value={valuebti1}
            onChange={(e) => setValuebti1(e.target.value)}
          />
          </label>
        </form>
      </div>
      <div className="eachTable-container">
        {/* <form>
          <label htmlFor="basicInfo-t4" style={{ fontWeight: "600" }}>
            4.Type of Institution:
          </label>
          <p
            style={{ fontWeight: "600" }}
            // id="bti11"
            // onChange={(e) => setValuebti11(e.target.value)}
          >
            By Gender
          </p>
          <label>i.For Men</label>
          <input
            type="radio"
            name="opion1"
            id="bti11"
            style={{ paddingRight: "0px" }}
            value={valuebti1}
            onChange={(e) => setValuebti11(e.target.value)}
          />
          <label>ii. For Women</label>
          <input type="radio"
           id="bti11"
           name="opion1"
           value={valuebti1}
            onChange={(e) => setValuebti11(e.target.value)}
           />
          <label>iii.Co-education </label>
          <input type="radio"
           id="bti11"
           name="opion1"
           value={valuebti1}
           onChange={(e) => setValuebti11(e.target.value)}
           />
          <p
            style={{ fontWeight: "600" }}
            id="bti12"
            onChange={(e) => setValuebti12(e.target.value)}
          >
            By Shift
          </p>
          <label>i. Regular</label>
          <input type="radio" 
           name="opion2"
           id="bti12"
          value={valuebti12}
          onChange={(e) => setValuebti12(e.target.value)}
           />
          <label>ii. Day</label>
          <input type="radio"
           id="bti12"
           name="opion2"
           value={valuebti12}
           onChange={(e) => setValuebti12(e.target.value)}
           />
          <label>iii. Evening </label>
          <input type="radio"
          id="bti12"
           name="opion2"
           value={valuebti12}
           onChange={(e) => setValuebti12(e.target.value)}
           />
        </form> */}
       <FormControl>
          <p>4.Type of Institution:</p> <br/>
          <p style={{ fontWeight: "600",marginLeft:"3%" }}>  By Gender</p>
          <RadioGroup style={{marginLeft:"3%"}} name="radio-buttons-group">
               <FormControlLabel value="For Men " 
                onChange={(e) => setValuebti11(e.target.value)}
               control={<Radio />} label="For Men " /> 

               <FormControlLabel value="For Women "
                onChange={(e) => setValuebti11(e.target.value)}
               control={<Radio />} label="For Women " />

               <FormControlLabel value="Co-Education "
                onChange={(e) => setValuebti11(e.target.value)}
                 control={<Radio />} label="Co-Education " /> 
            </RadioGroup>

          <p style={{ fontWeight: "600" , marginLeft:"3%"}}>By Shift</p>
            <RadioGroup style={{marginLeft:"3%"}} name="radio-buttons-group">
               <FormControlLabel value="Regular"
                onChange={(e) => setValuebti12(e.target.value)}
               control={<Radio />} label="i.Regular " /> 

               <FormControlLabel value="Day"
                onChange={(e) => setValuebti12(e.target.value)}
               control={<Radio />} label="ii.Day " />

               <FormControlLabel value="Evening "
                onChange={(e) => setValuebti12(e.target.value)}
                 control={<Radio />} label="iii.Evening " /> 
            </RadioGroup>
        </FormControl>

      </div>
      <div className="eachTable-container">
        {/* <form>
          <label htmlFor="basicInfo-t4" style={{ fontWeight: "600" }}>
            5. It is a recognized minority institution?
          </label>
          <br></br>
          <label htmlFor="basicInfo-t4">Yes</label>
          <input
            type="radio"
            name="opion3"
            text="Yes"
            id="btr11"
            value={valuebtr11}
            onChange={(e) => setValuebtr11(e.target.value)}
          />
          <label htmlFor="basicInfo-t4">No</label>
          <input
            type="radio"
            name="opion3"
            text="No"
            id="btr11"
            value={valuebtr11}
            onChange={(e) => setValuebtr11(e.target.value)}
          />
        </form> */}

         <FormControl>
          <p> 5.It is a recognized minority institution?</p>
           <RadioGroup name="radio-buttons-group">
              <FormControlLabel value="Yes"  onChange={(e) => setValuebtr11(e.target.value)} control={<Radio />} label="Yes" />
               <FormControlLabel value="No"  onChange={(e) => setValuebtr11(e.target.value)} control={<Radio />} label="No" />
           </RadioGroup>
          </FormControl>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t4" style={{ fontWeight: "600" }}>
            6. Source of funding: Government Grant-in-aid Self-finacing Any
            other
         
          <input
            type="text"
            style={{ width: "20%", marginLeft: "360px" }}
            id="btr12"
            onChange={(e) => setValuebtr12(e.target.value)}
          />
           </label>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t4" style={{ fontWeight: "600" }}>
            7. a. Date of establishment of the college: (dd/mm/yyyy)
          <input
            type="date"
            style={{ width: "20%", marginLeft: "470px" }}
            id="btr13"
            onChange={(e) => setValuebtr13(e.target.value)}
          />
          </label>
          <br></br>
          <label htmlFor="basicInfo-t4">
            b. University to which the college is affiliated / or which governs
            the college (If it is a constituent college)
          <input
            type="text"
            style={{ width: "20%", marginLeft: "900px" }}
            id="btr14"
            onChange={(e) => setValuebtr14(e.target.value)}
          />
          </label>
          <br></br>
          <label htmlFor="basicInfo-t4">c. Details of UGC recognition:</label>
          <table>
            <tr>
              <th>Under Section</th>
              <th>Date, Month & Year (dd-mm-yyyy)</th>
              <th>Remarks(If any)</th>
            </tr>
            <tr>
              <td>i. 2(f)</td>
              <td>
                <input
                  type="date"
                  id="btr15"
                  onChange={(e) => setValuebtr15(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="btr16"
                  onChange={(e) => setValuebtr16(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>ii. 12(B)</td>
              <td>
                <input
                  type="date"
                  id="btr17"
                  onChange={(e) => setValuebtr17(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="btr18"
                  onChange={(e) => setValuebtr18(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <label htmlFor="basicInfo-t4">
            Details of recognition/approval by statutory/ regulatory bodies like
            AICTE,NCTE,MCI,DIC,PCI, RCI etc (other than UGC).
          </label>
          <table>
            <tr>
              <th>Statutory Regulatory Authority</th>
              <th>
                Recognition/Approval details Institution/Department Programme
              </th>
              <th>Day, Month and Uear (dd-mm-yyyy)</th>
              <th>Validity</th>
              <th>Remarks</th>
            </tr>
            <tr>
              <td>
                i.
                <input
                  type="text"
                  id="btd11"
                  style={{marginLeft:"1%", width:"90%"}}
                  onChange={(e) => setValuebtd11(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="btd12"
                  onChange={(e) => setValuebtd12(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="date"
                  id="btd13"
                  onChange={(e) => setValuebtd13(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="date"
                  id="btd14"
                  onChange={(e) => setValuebtd14(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="btd15"
                  onChange={(e) => setValuebtd15(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <td>
                ii.
                <input
                  type="text"
                  id="btd21"
                  style={{marginLeft:"1%", width:"90%"}}
                  onChange={(e) => setValuebtd21(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="btd22"
                  onChange={(e) => setValuebtd22(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="date"
                  id="btd23"
                  onChange={(e) => setValuebtd23(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="date"
                  id="btd24"
                  onChange={(e) => setValuebtd24(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="btd25"
                  onChange={(e) => setValuebtd25(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>
                iii.
                <input
                  type="text"
                  id="btd31"
                  style={{marginLeft:"1%", width:"87%"}}
                  onChange={(e) => setValuebtd31(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="btd32"
                  onChange={(e) => setValuebtd32(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="date"
                  id="btd33"
                  onChange={(e) => setValuebtd33(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="date"
                  id="btd34"
                  onChange={(e) => setValuebtd34(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="btd35"
                  onChange={(e) => setValuebtd35(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>
                iv.
                <input
                  type="text"
                  id="btd41"
                  style={{marginLeft:"1%", width:"87%"}}
                  onChange={(e) => setValuebtd41(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="btd42"
                  onChange={(e) => setValuebtd42(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="date"
                  id="btd43"
                  onChange={(e) => setValuebtd43(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="date"
                  id="btd44"
                  onChange={(e) => setValuebtd44(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="btd45"
                  onChange={(e) => setValuebtd45(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      {/* <div className="eachTable-container">
        <label style={{ fontWeight: "600" }}>
          8. Does the affiliating university Act provide for conferment of
          autonomy (as recognized by the UGC), on its affiliated colleges?
        </label>
        <label>Yes</label>
        <input
          type="radio"
          name="opion4"
          id="btu11"
          value={valuebtu11}
          onChange={(e) => setValuebtu11(e.target.value)}
        />
        <label>No</label>
        <input
          type="radio"
          name="opion4"
          value={valuebtu11}
          id="btu11"
          onChange={(e) => setValuebtu11(e.target.value)}
        />
        <p>
          If yes, has the College applied for availing the autonomous status?
        </p>
        <label>Yes</label>
        <input
          type="radio"
          name="opion5"
          id="btu12"
          value={valuebtu12}
          onChange={(e) => setValuebtu12(e.target.value)}
        />
        <label>No</label>
        <input
          type="radio"
          name="opion5"
          value={valuebtu12}
          id="btu12"
          onChange={(e) => setValuebtu12(e.target.value)}
        />
      </div> */}

      <div className="eachTable-container">
        <p>8. Does the affiliating university Act provide for conferment of
          autonomy (as recognized by the UGC), on its affiliated colleges?</p>
          <FormControl>
            <RadioGroup
                name="radio-buttons-group" >
                <FormControlLabel value="Yes" onChange={(e) => setValuebtu11(e.target.value)} control={<Radio />} label="Yes" />
                <FormControlLabel value="No" onChange={(e) => setValuebtu11(e.target.value)} control={<Radio />} label="No" /> 
           </RadioGroup> 
                <p style={{marginLeft:"3%"}}>If yes, has the College applied for availing the autonomous status?</p>
            <RadioGroup
                name="radio-buttons-group" style={{marginLeft:"3%"}} >
                <FormControlLabel value="Yes" onChange={(e) => setValuebtu12(e.target.value)} control={<Radio />} label="Yes" /> 
                <FormControlLabel value="No" onChange={(e) => setValuebtu12(e.target.value)} control={<Radio />} label="No" />
           </RadioGroup>
               
           
          </FormControl>
      </div>

      <div className="eachTable-container">
       
        <p style={{ fontWeight: "600" }}>9. Is the college recognized</p>
       
          a. by UGC as a College with Potential for Excellence (CPE)?
        
        {/* <input
          type="radio"
          name="opion6"
          id="btc11"
          value={valuebtc11}
          onChange={(e) => setValuebtc11(e.target.value)}
        /> Yes
        <input
          type="radio"
          name="opion6"
          value={valuebtc11}
          id="btc11"
          onChange={(e) => setValuebtc11(e.target.value)}
        />No
        </label> */}
           <FormControl>
          <RadioGroup name="radio-buttons-group" >
          <FormControlLabel value="Yes"
           onChange={(e) => setValuebtc11(e.target.value)}
           control={<Radio />} label="Yes" />

         <FormControlLabel value="No" 
          onChange={(e) => setValuebtc11(e.target.value)}
          control={<Radio />} label="No" />
         </RadioGroup>
       </FormControl>

       <label style={{ marginLeft:"3%" }}>
          If yes, date of recognition:....(dd/mm/yyyy) 
          <input
          type="date"
          style={{ width: "20%" ,marginLeft:"300px"}}
          id="btc12"
          onChange={(e) => setValuebtc12(e.target.value)}
        />
        </label>
       <FormControl style={{ marginLeft:"3%" }}>
          <RadioGroup name="radio-buttons-group" >
             <FormControlLabel value="Yes"
              onChange={(e) => setValuebtc13(e.target.value)}
              control={<Radio />} label="Yes" />

            <FormControlLabel value="No" 
               onChange={(e) => setValuebtc13(e.target.value)}
               control={<Radio />} label="No" />
          </RadioGroup>
       </FormControl>

        <p style={{ marginLeft:"3%" }}>
          b. For its performance by any other governmental agency?</p>
          <FormControl style={{ marginLeft:"3%" }} >
          <RadioGroup name="radio-buttons-group" >
             <FormControlLabel value="Yes"
              onChange={(e) => setValuebtc14(e.target.value)}
              control={<Radio />} label="Yes" />

            <FormControlLabel value="No"
               onChange={(e) => setValuebtc14(e.target.value)}
               control={<Radio />} label="No" />
          </RadioGroup>
       </FormControl>
        
        
        <label style={{ marginLeft:"3%" }}>If yes, Name of the agency.....
        <input
          type="text"
          style={{ width: "20%" , marginLeft:"390px" }}
          id="btc15"
          value={valuebtc15}
          onChange={(e) => setValuebtc15(e.target.value)}
        />
        </label><br/>

        <label style={{ marginLeft:"3%" }}>Date of recognition.....(dd/mm/yyyy)
        <input
          type="date"
          style={{ width: "20%" , marginLeft:"340px"}}
          id="btc16"
          value={valuebtc16}
          onChange={(e) => setValuebtc16(e.target.value)}
        />
        </label>
      </div>


      <div className="eachTable-container">
        <form>
          <label style={{ fontWeight: "600" }}>
            10. Location of the campus and area in sq.mts:
          </label>
          <table>
            <tr>
              <th>Location *</th>
              <td>
                <input
                  type="text"
                  id="btl1"
                  onChange={(e) => setValuebtl1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Campus area in sq.mts.</th>
              <td>
                <input
                  type="number"
                  id="btl2"
                  onChange={(e) => setValuebtl2(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Built up area in sq.mts.</th>
              <td>
                <input
                  type="number"
                  id="btl3"
                  onChange={(e) => setValuebtl3(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <p>
            (* Urban, Semi-urban, Rural, Tribal, Hilly Area, Any others specify)
          </p>
        </form>
      </div>
      <div className="eachTable-container">
        <p style={{ fontWeight: "600" }}>
          11. Details of programmes offered by the college(Give data for current
          academic year)
        </p>
        <table>
          <tr>
            <th>SI.No.</th>
            <th>Programme Level</th>
            <th>Name of the Programme/ Course</th>
            <th>Duration</th>
            <th>Entry Qulaification</th>
            <th>Medium of instruction</th>
            <th>Sanctioned/ approved Student strength</th>
            <th>No. of students admitted</th>
          </tr>
          <tr>
            <td>
              <input
                type="number"
                id="btp11"
                onChange={(e) => setValuebtp11(e.target.value)}
              />
            </td>
            <td>
              <select
                name="Programme"
                id="btp12"
                onChange={(e) => setValuebtp12(e.target.value)}
              >
                <option value="Under-Graduate">Under-Graduate</option>
                <option value="Post-Graduate">Post-Graduate</option>
                <option value="Intermediate Programmes PG">
                  Intermediate Programmes PG
                </option>
                <option value="Ph.D.">Ph.D.</option>
                <option value="M.Phil.">M.Phil.</option>
                <option value="Certificate courses">Certificate courses</option>
                <option value="UG Diploma">UG Diploma</option>
                <option value="PG Diploma">PG Diploma</option>
                <option value="Any Other (specify and provide details)">
                  Any Other (specify and provide details)
                </option>
              </select>
            </td>
            <td>
              <input
                type="text"
                id="btp13"
                onChange={(e) => setValuebtp13(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp14"
                onChange={(e) => setValuebtp14(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp15"
                onChange={(e) => setValuebtp15(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp16"
                onChange={(e) => setValuebtp16(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp17"
                onChange={(e) => setValuebtp17(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="btp18"
                onChange={(e) => setValuebtp18(e.target.value)}
              />
            </td>
          </tr>
        </table>
      </div>
      <div className="eachTable-container">
        <p style={{ fontWeight: "600" }}>
          12. Please fill in the following details if applicable:
        </p>
        <table>
          <tr>
            <th rowspan="3">Number of programs</th>
          </tr>
          <tr>
            <td>Self-financed programmes offered</td>
            <td>New Programmes introduced during the last five years</td>
          </tr>
          <td>
            <input
              type="number"
              id="btp19"
              onChange={(e) => setValuebtp19(e.target.value)}
            />
          </td>
          <td>
            <input
              type="number"
              id="btp20"
              onChange={(e) => setValuebtp20(e.target.value)}
            />
          </td>
        </table>
      </div>
      <div className="eachTable-container">
        <p style={{ fontWeight: "600" }}>
          13.List the Departments: (respond if applicable only and do not list
          facilities like Library, Physical Education as departments, unless
          they are also offering academic degree awarding programmes. similarly,
          do not list the departments offering common compulsory subjects for
          all the programmes. like english, regional languages etc..)
        </p>
        <table>
          <tr>
            <th>Faculty</th>
            <th>Departments (eg Physics,Botany,History etc.)</th>
            <th>UG</th>
            <th>PG</th>
            <th>Research</th>
          </tr>
          <tr>
            <td>Science</td>
            <td>
              <input
                type="text"
                id="btp21"
                onChange={(e) => setValuebtp21(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp22"
                onChange={(e) => setValuebtp22(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp23"
                onChange={(e) => setValuebtp23(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp24"
                onChange={(e) => setValuebtp24(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>Arts</td>
            <td>
              <input
                type="text"
                id="btp31"
                onChange={(e) => setValuebtp31(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp32"
                onChange={(e) => setValuebtp32(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp33"
                onChange={(e) => setValuebtp33(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp34"
                onChange={(e) => setValuebtp34(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>Commerce</td>
            <td>
              <input
                type="text"
                id="btp41"
                onChange={(e) => setValuebtp41(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp42"
                onChange={(e) => setValuebtp42(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp43"
                onChange={(e) => setValuebtp43(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp44"
                onChange={(e) => setValuebtp44(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>Any other (Specify) :</td>
            <td>
              <input
                type="text"
                id="btp51"
                onChange={(e) => setValuebtp51(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp52"
                onChange={(e) => setValuebtp52(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp53"
                onChange={(e) => setValuebtp53(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="btp54"
                onChange={(e) => setValuebtp54(e.target.value)}
              />
            </td>
          </tr>
        </table>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1" style={{ fontWeight: "600" }}>
            14.Number of teaching and non-teaching positions in the Institution
          </label>
          <br />
          <lable htmlFor="academicInfo-t1">Teaching Faculty</lable>
          <table>
            <tr>
              <th rowspan="2" style={{ width: "16%" }}>
                Positions
              </th>
              <th colspan="2">Professor</th>
              <th colspan="2">Associate Professor</th>
              <th colspan="2">Assistant Professor</th>
              <th rowspan="2">Non-teaching staff</th>
              <th rowspan="2">Teaching staff</th>
            </tr>
            <tr className="academic-font">
              <td>Male</td>
              <td>Female</td>
              <td>Male</td>
              <td>Female</td>
              <td>Male</td>
              <td>Female</td>
            </tr>
            <tr>
              <th>Sanctioned by the UGC/ University/ State Government</th>
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
                  id="at15"
                  onChange={(e) => setValueat17(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="at16"
                  onChange={(e) => setValueat18(e.target.value)}
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
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="academicInfo-t1" style={{ fontWeight: "600" }}>
            15. Qualification of the teaching staff:
          </label>
          <br />
          <lable htmlFor="academicInfo-t1">Teaching Faculty</lable>
          <table>
            <tr>
              <th rowspan="2" style={{ width: "16%" }}>
                Highest Qualification
              </th>
              <th colspan="2">Professor</th>
              <th colspan="2">Associate Professor</th>
              <th colspan="2">Assistant Professor</th>
              <th rowspan="2">Total</th>
            </tr>
            <tr className="academic-font">
              <td>Male</td>
              <td>Female</td>
              <td>Male</td>
              <td>Female</td>
              <td>Male</td>
              <td>Female</td>
            </tr>
            <tr>
              <th>Permanent teachers</th>
              <td>
                <input
                  type="number"
                  style={{ height: "100%" }}
                  id="atq11"
                  value={valueatq11}
                  onChange={(e) => setValueatq11(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq12"
                  value={valueatq12}
                  onChange={(e) => setValueatq12(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq13"
                  value={valueatq13}
                  onChange={(e) => setValueatq13(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq14"
                  value={valueatq14}
                  onChange={(e) => setValueatq14(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq15"
                  value={valueatq15}
                  onChange={(e) => setValueatq15(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq16"
                  value={valueatq16}
                  onChange={(e) => setValueatq16(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq17"
                  value={valueatq17}
                  onChange={(e) => setValueatq17(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>D.Sc./D.Litt.</th>
              <td>
                <input
                  type="number"
                  id="atq21"
                  value={valueatq21}
                  onChange={(e) => setValueatq21(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq22"
                  value={valueatq22}
                  onChange={(e) => setValueatq22(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq23"
                  value={valueatq23}
                  onChange={(e) => setValueatq23(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq24"
                  value={valueatq24}
                  onChange={(e) => setValueatq24(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq25"
                  value={valueatq25}
                  onChange={(e) => setValueatq25(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq26"
                  value={valueatq26}
                  onChange={(e) => setValueatq26(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq27"
                  value={valueatq27}
                  onChange={(e) => setValueatq27(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Ph.D.</th>
              <td>
                <input
                  type="number"
                  id="atq31"
                  value={valueatq31}
                  onChange={(e) => setValueatq31(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq32"
                  value={valueatq32}
                  onChange={(e) => setValueatq32(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq33"
                  value={valueatq33}
                  onChange={(e) => setValueatq33(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq34"
                  value={valueatq34}
                  onChange={(e) => setValueatq34(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq35"
                  value={valueatq35}
                  onChange={(e) => setValueatq35(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq36"
                  value={valueatq36}
                  onChange={(e) => setValueatq36(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq37"
                  value={valueatq37}
                  
                  onChange={(e) => setValueatq37(e.target.value)}
                />
              </td>
            </tr>
            {/* <tr>
              <th>
                Sanctioned by the Management/ Society/ or other Authorised Body
              </th>
              <td>
                <input
                  type="text"
                  id="atq41"
                  value={valueatq41}

                  onChange={(e) => setValueatq41(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="atq42"
                  value={valueatq42}
                  
                  onChange={(e) => setValueatq42(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="atq43"
                  value={valueatq43}
                  onChange={(e) => setValueatq43(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="atq44"
                  value={valueatq44}
                  onChange={(e) => setValueatq44(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="atq45"
                  value={valueatq45}
                  onChange={(e) => setValueatq45(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="atq46"
                  value={valueatq46}
                  onChange={(e) => setValueatq46(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="atq47"
                  value={valueatq47}
                  onChange={(e) => setValueatq47(e.target.value)}
                />
              </td>
            </tr> */}
            <tr>
              <th>M.Phil</th>
              <td>
                <input
                  type="number"
                  id="atq51"
                  value={valueatq41}
                  onChange={(e) => setValueatq41(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq52"
                   value={valueatq42}
                  onChange={(e) => setValueatq42(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq53"
                  value={valueatq43}
                  onChange={(e) => setValueatq43(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq54"
                  value={valueatq44}
                  onChange={(e) => setValueatq44(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq55"
                  value={valueatq45}
                  onChange={(e) => setValueatq45(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq56"
                  value={valueatq46}
                  onChange={(e) => setValueatq46(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq57"
                  value={valueatq47}
                  onChange={(e) => setValueatq47(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG</th>
              <td>
                <input
                  type="number"
                  id="atq61"
                  value={valueatq51}
                  onChange={(e) => setValueatq51(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq62"
                  value={valueatq52}
                  onChange={(e) => setValueatq52(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq63"
                  value={valueatq53}
                  onChange={(e) => setValueatq53(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq64"
                  value={valueatq54}
                  onChange={(e) => setValueatq54(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq65"
                  value={valueatq55}
                  onChange={(e) => setValueatq55(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq66"
                  value={valueatq56}
                  onChange={(e) => setValueatq56(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq67"
                  value={valueatq57}
                  onChange={(e) => setValueatq57(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Temporary teachers</th>
              <td>
                <input
                  type="number"
                  id="atq71"
                  value={valueatq61}
                  onChange={(e) => setValueatq61(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq72"
                  value={valueatq62}
                  onChange={(e) => setValueatq62(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq73"
                  value={valueatq63}
                  onChange={(e) => setValueatq63(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq74"
                  value={valueatq64}
                  onChange={(e) => setValueatq64(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq75"
                  value={valueatq65}
                  onChange={(e) => setValueatq65(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq76"
                  value={valueatq66}
                  onChange={(e) => setValueatq66(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq77"
                  value={valueatq67}
                  onChange={(e) => setValueatq67(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>DSc./D.Litt.</th>
              <td>
                <input
                  type="number"
                  value={valueatq71}
                  id="atq81"
                  onChange={(e) => setValueatq71(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq82"
                  value={valueatq72}
                  onChange={(e) => setValueatq72(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq83"
                  value={valueatq73}
                  onChange={(e) => setValueatq73(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq84"
                  value={valueatq74}
                  onChange={(e) => setValueatq74(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq85"
                  value={valueatq75}
                  onChange={(e) => setValueatq75(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq86"
                  value={valueatq76}
                  onChange={(e) => setValueatq76(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq87"
                  value={valueatq77}
                  onChange={(e) => setValueatq77(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Ph.D.</th>
              <td>
                <input
                  type="number"
                  id="atq91"
                  value={valueatq81}
                  onChange={(e) => setValueatq81(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq92"
                  value={valueatq82}
                  onChange={(e) => setValueatq82(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq93"
                  value={valueatq83}
                  onChange={(e) => setValueatq83(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq94"
                  value={valueatq84}
                  onChange={(e) => setValueatq84(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq95"
                  value={valueatq85}
                  onChange={(e) => setValueatq85(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq96"
                  value={valueatq86}
                  onChange={(e) => setValueatq86(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq97"
                  value={valueatq87}
                  onChange={(e) => setValueatq87(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>M.Phil.</th>
              <td>
                <input
                  type="number"
                  id="atq101"
                  value={valueatq91}
                  onChange={(e) => setValueatq91(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq102"
                  value={valueatq92}
                  onChange={(e) => setValueatq92(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq103"
                  value={valueatq93}
                  onChange={(e) => setValueatq93(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq104"
                  value={valueatq94}
                  onChange={(e) => setValueatq94(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq105"
                  value={valueatq95}
                  onChange={(e) => setValueatq95(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq106"
                  value={valueatq96}
                  onChange={(e) => setValueatq96(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  value={valueatq97}
                  id="atq107"
                  onChange={(e) => setValueatq97(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG</th>
              <td>
                <input
                  type="number"
                  id="atq111"
                  value={valueatq101}
                  onChange={(e) => setValueatq101(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq112"
                  value={valueatq102}
                  onChange={(e) => setValueatq102(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq113"
                  value={valueatq103}
                  onChange={(e) => setValueatq103(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq114"
                  value={valueatq104}
                  onChange={(e) => setValueatq104(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  value={valueatq105}
                  id="atq115"
                  onChange={(e) => setValueatq105(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  value={valueatq106}
                  id="atq116"
                  onChange={(e) => setValueatq106(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq117"
                  value={valueatq107}
                  onChange={(e) => setValueatq107(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Part-time teachers</th>
              <td>
                <input
                  type="number"
                  id="atq121"
                  value={valueatq111}
                  onChange={(e) => setValueatq111(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq122"
                  value={valueatq112}
                  onChange={(e) => setValueatq112(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq123"
                  value={valueatq113}
                  onChange={(e) => setValueatq113(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq124"
                  value={valueatq114}
                  onChange={(e) => setValueatq114(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq125"
                  value={valueatq115}
                  onChange={(e) => setValueatq115(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq126"
                  value={valueatq116}
                  onChange={(e) => setValueatq116(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq127"
                  value={valueatq117}
                  onChange={(e) => setValueatq117(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>D.Sc./D.Litt.</th>
              <td>
                <input
                  type="number"
                  id="atq131"
                  value={valueatq121}
                  onChange={(e) => setValueatq121(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq132"
                  value={valueatq122}
                  onChange={(e) => setValueatq122(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq133"
                  value={valueatq123}
                  onChange={(e) => setValueatq123(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq134"
                  value={valueatq124}
                  onChange={(e) => setValueatq124(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq135"
                  value={valueatq125}
                  onChange={(e) => setValueatq125(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq136"
                  value={valueatq126}
                  onChange={(e) => setValueatq126(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq137"
                  value={valueatq127}
                  onChange={(e) => setValueatq127(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Ph.D.</th>
              <td>
                <input
                  type="number"
                  id="atq141"
                  value={valueatq131}
                  onChange={(e) => setValueatq131(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq142"
                  value={valueatq132}
                  onChange={(e) => setValueatq132(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq143"
                  value={valueatq133}
                  onChange={(e) => setValueatq133(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq144"
                  value={valueatq134}
                  onChange={(e) => setValueatq134(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq145"
                  value={valueatq135}
                  onChange={(e) => setValueatq135(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq146"
                  value={valueatq136}
                  onChange={(e) => setValueatq136(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq147"
                  value={valueatq137}
                  onChange={(e) => setValueatq137(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>M.Phil</th>
              <td>
                <input
                  type="number"
                  value={valueatq141}
                  id="atq151"
                  onChange={(e) => setValueatq141(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq152"
                  value={valueatq142}
                  onChange={(e) => setValueatq142(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq153"
                  value={valueatq143}
                  onChange={(e) => setValueatq143(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq154"
                  value={valueatq144}
                  onChange={(e) => setValueatq144(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq155"
                  value={valueatq145}
                  onChange={(e) => setValueatq145(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq156"
                  value={valueatq146}
                  onChange={(e) => setValueatq146(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq157"
                  value={valueatq147}
                  onChange={(e) => setValueatq147(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG</th>
              <td>
                <input
                  type="number"
                  id="atq161"
                  value={valueatq151}
                  onChange={(e) => setValueatq151(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq162"
                  value={valueatq152}
                  onChange={(e) => setValueatq152(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq163"
                  value={valueatq153}
                  onChange={(e) => setValueatq153(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq164"
                  value={valueatq154}
                  onChange={(e) => setValueatq154(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq165"
                  value={valueatq155}
                  onChange={(e) => setValueatq155(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq166"
                  value={valueatq156}
                  onChange={(e) => setValueatq156(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="atq167"
                  value={valueatq157}
                  onChange={(e) => setValueatq157(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <label htmlFor="academicInfo-t1" style={{ fontWeight: "600" }}>
          16.Number of Visiting Faculty/Guest Faculty engages with the College:
        
        <input
          type="number"
          id="atg1"
          style={{ width:"20%",marginLeft:"200px"}}
          onChange={(e) => setValueatg1(e.target.value)}
        />
        </label>
      </div>
      <div className="eachTable-container">
        <label htmlFor="academicInfo-t1" style={{ fontWeight: "600" }}>
          17. Furnish the number of the students admitted to the college during
          the last four academic years.
        </label>
        <table>
          <tr>
            <th rowspan="2" style={{ width: "16%" }}>
              Categories
            </th>
            <th colspan="2">Year 1</th>
            <th colspan="2">Year 2</th>
            <th colspan="2">Year 3</th>
            <th colspan="2">Year 4</th>
          </tr>
          <tr className="academic-font">
            <td>Male</td>
            <td>Female</td>
            <td>Male</td>
            <td>Female</td>
            <td>Male</td>
            <td>Female</td>
            <td>Male</td>
            <td>Female</td>
          </tr>
          <tr>
            <th>SC</th>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="atg11"
                onChange={(e) => setValueatg11(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg12"
                onChange={(e) => setValueatg12(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg13"
                onChange={(e) => setValueatg13(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg14"
                onChange={(e) => setValueatg14(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg15"
                onChange={(e) => setValueatg15(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg16"
                onChange={(e) => setValueatg16(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg17"
                onChange={(e) => setValueatg17(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg18"
                onChange={(e) => setValueatg18(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th>ST</th>
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
            <td>
              <input
                type="number"
                id="atg25"
                onChange={(e) => setValueatg25(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg26"
                onChange={(e) => setValueatg26(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg27"
                onChange={(e) => setValueatg27(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg28"
                onChange={(e) => setValueatg28(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th>OBC</th>
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
            <td>
              <input
                type="number"
                id="atg35"
                onChange={(e) => setValueatg35(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg36"
                onChange={(e) => setValueatg36(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg37"
                onChange={(e) => setValueatg37(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg38"
                onChange={(e) => setValueatg38(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th>General</th>
            <td>
              <input
                type="number"
                id="atg41"
                onChange={(e) => setValueatg41(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg42"
                onChange={(e) => setValueatg42(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg43"
                onChange={(e) => setValueatg43(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg44"
                onChange={(e) => setValueatg44(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg45"
                onChange={(e) => setValueatg45(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg46"
                onChange={(e) => setValueatg46(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg47"
                onChange={(e) => setValueatg47(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg48"
                onChange={(e) => setValueatg48(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th>Others</th>
            <td>
              <input
                type="number"
                id="atg51"
                onChange={(e) => setValueatg51(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg52"
                onChange={(e) => setValueatg52(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg53"
                onChange={(e) => setValueatg53(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg54"
                onChange={(e) => setValueatg54(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg55"
                onChange={(e) => setValueatg55(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg56"
                onChange={(e) => setValueatg56(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg57"
                onChange={(e) => setValueatg57(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="atg58"
                onChange={(e) => setValueatg58(e.target.value)}
              />
            </td>
          </tr>
        </table>
      </div>
      <div className="eachTable-container">
        <label htmlFor="academicInfo-t1" style={{ fontWeight: "600" }}>
          18. Details on students enrollment in the college during the current
          academic year.
        </label>
        <table>
          <tr>
            <th>Type of Students</th>
            <th>UG</th>
            <th>PG</th>
            <th>M.Phil.</th>
            <th>Ph.D.</th>
            <th>Total</th>
          </tr>
          <tr>
            <td>Students from the same state where the collge is located</td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp11"
                onChange={(e) => setValuebtpp11(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp12"
                onChange={(e) => setValuebtpp12(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp13"
                onChange={(e) => setValuebtpp13(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp14"
                onChange={(e) => setValuebtpp14(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp15"
                onChange={(e) => setValuebtpp15(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>Students from other states of India</td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp21"
                onChange={(e) => setValuebtpp21(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp22"
                onChange={(e) => setValuebtpp22(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp23"
                onChange={(e) => setValuebtpp23(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp24"
                onChange={(e) => setValuebtpp24(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp25"
                onChange={(e) => setValuebtpp25(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>NRI Students</td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp31"
                onChange={(e) => setValuebtpp31(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp32"
                onChange={(e) => setValuebtpp32(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp33"
                onChange={(e) => setValuebtpp33(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp34"
                onChange={(e) => setValuebtpp34(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp35"
                onChange={(e) => setValuebtpp35(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>Foreign Students</td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp41"
                onChange={(e) => setValuebtpp41(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp42"
                onChange={(e) => setValuebtpp42(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp43"
                onChange={(e) => setValuebtpp43(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp44"
                onChange={(e) => setValuebtpp44(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp45"
                onChange={(e) => setValuebtpp45(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>Total</td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp51"
                onChange={(e) => setValuebtpp51(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp52"
                onChange={(e) => setValuebtpp52(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp53"
                onChange={(e) => setValuebtpp53(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp54"
                onChange={(e) => setValuebtpp54(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                style={{ height: "100%" }}
                id="btpp55"
                onChange={(e) => setValuebtpp55(e.target.value)}
              />
            </td>
          </tr>
        </table>
      </div>
      <div className="eachTable-container">
        <label htmlFor="academicInfo-t1" style={{ fontWeight: "600" }}>
          19. Please fill in the following details if applicable:
        </label>
        <table>
          <tr>
            <th>Unit Cost of Education</th>
            <th>Including Salary Component</th>
            <th>Excluding Salary Component</th>
          </tr>
          <tr>
            <td>
              <input
                type="text"
                style={{ height: "100%" }}
                id="btpp61"
                onChange={(e) => setValuebtpp61(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                style={{ height: "100%" }}
                id="btpp62"
                onChange={(e) => setValuebtpp62(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                style={{ height: "100%" }}
                id="btpp63"
                onChange={(e) => setValuebtpp63(e.target.value)}
              />
            </td>
          </tr>
        </table>
      </div>
      <div className="eachTable-container">
        <label htmlFor="academicInfo-t1" style={{ fontWeight: "600" }}>
          20. Date of accreditation * (applicable for Cycle 2, Cycle 3, Cycle 4
          and re-assessment only)
        </label>
        <br></br>
        <div style={{ display: "flex" }}>
          <label htmlFor="academicInfo-t1">Cycle 1:</label> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
          <input
            type="date"
            style={{ width: "30%" }}
            id="btda1"
            onChange={(e) => setValuebtda1(e.target.value)}
          /> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
          <label htmlFor="academicInfo-t1">Accreditation Outcome/Result: </label>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input
            type="text"
            style={{ width: "30%" }}
            id="btda2"
            onChange={(e) => setValuebtda2(e.target.value)}
          />
        </div>
        <br></br>
        <div>
          <label htmlFor="academicInfo-t1">Cycle 2: </label> &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
          <input
            type="date"
            style={{ width: "30%" }}
            id="btda3"
            onChange={(e) => setValuebtda3(e.target.value)}
          /> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
          <label htmlFor="academicInfo-t1">Accreditation Outcome/Result: </label>&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input
            type="text"
            style={{ width: "30%" }}
            id="btda4"
            onChange={(e) => setValuebtda4(e.target.value)}
          />
        </div>
        <br></br>
        <div>
          <label htmlFor="academicInfo-t1">Cycle 3: </label> &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
          <input
            type="date"
            style={{ width: "30%" }}
            id="btda5"
            onChange={(e) => setValuebtda5(e.target.value)}
          />&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
        
          <label htmlFor="academicInfo-t1">Accreditation Outcome/Result: </label>&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
          <input
            type="text"
            style={{ width: "30%" }}
            id="btda6"
            onChange={(e) => setValuebtda6(e.target.value)}
          />
        </div>
        <br></br>
        <div>
          <label htmlFor="academicInfo-t1">Cycle 4: </label> &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
          <input
            type="date"
            style={{ width: "30%" }}
            id="btda7"
            onChange={(e) => setValuebtda7(e.target.value)}
          /> &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <label htmlFor="academicInfo-t1">Accreditation Outcome/Result: </label> &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
          <input
            type="text"
            style={{ width: "30%" }}
            id="btda8"
            onChange={(e) => setValuebtda8(e.target.value)}
          />
        </div>
      </div>
      <div className="eachTable-container">
        <label htmlFor="academicInfo-t1">
          21. Date of establishment of Internal Quality Assurance Reports (AQAR)
          to NAAC
        </label>
        <br></br>
        <div>
          <label>IQAC: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input
            type="date"
            style={{ width: "30%" , marginLeft:"27px" }}
            id="btda9"
            onChange={(e) => setValuebtda9(e.target.value)}
          />
          </label>
        </div>
      </div>
      <div className="eachTable-container">
        <label htmlFor="academicInfo-t1">
          22. Details regarding submission of Annual Quality Assurance Reports
          to NAAC
        </label> 
        <br></br>
        <div>
          <label>AQAR (i)</label>   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input
            type="date"
            style={{ width: "30%" }}
            id="btdr1"
            onChange={(e) => setValuebtdr1(e.target.value)}
          />
          <br></br>
          <br></br>
        </div>
        <div>
          <label>AQAR (ii)</label>  &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input
            type="date"
            style={{ width: "30%" }}
            id="btdr2"
            onChange={(e) => setValuebtdr2(e.target.value)}
          />
        </div>
        <br></br>
          
        <div>
          <label>AQAR (iii)</label>  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input
            type="date"
            style={{ width: "30%" }}
            id="btdr3"
            onChange={(e) => setValuebtdr3(e.target.value)}
          />
        </div>
        <br></br>
        <div>
          <label>AQAR (iv)</label>  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input
            type="date"
            style={{ width: "30%" }}
            id="btdr4"
            onChange={(e) => setValuebtdr4(e.target.value)}
          />
        </div>
      </div>
      <div className="c11x-button-container" style={{ paddingBottom: "30px" }}>
        <button onClick={onClickingSave} className="c11x-button-style">
          Submit
        </button>
      </div>
    </div>
  );
}

export default BasicInfo;
