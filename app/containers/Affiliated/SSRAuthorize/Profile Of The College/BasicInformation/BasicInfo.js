import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import "./BasicInfo-style.css";
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
  
  const [principalComments, setPrincipalComments] = useState(null);
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState("");


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

  // get call
  const financialYear = "2021-2022";
  useEffect(
    () =>
      fetch(
        'http://localhost:8080/api/v1/getallacademicdata?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            //
            setValuebt1(data[0].basicProfile?data[0].basicProfile[0][0].inputbt1:"");
            setValuebt2(data[0].basicProfile?data[0].basicProfile[0][0].inputbt2:"");
            setValuebt3(data[0].basicProfile?data[0].basicProfile[0][0].inputbt3:"");
            setValuebt4(data[0].basicProfile?data[0].basicProfile[0][0].inputbt4:"");
            setValuebt5(data[0].basicProfile?data[0].basicProfile[0][0].inputbt5:"");
            setValuebt6(data[0].basicProfile?data[0].basicProfile[0][0].inputbt6:"");
  
            setValuebtc2(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc2:"");
            setValuebtc3(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc3:"");
            setValuebtc4(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc4:"");
            setValuebtc5(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc5:"");
            setValuebtc6(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc6:"");
  
            setValuebtc21(data[0].contactsforCommunication[1]?data[0].contactsforCommunication[1].inputbtc2:"");
            setValuebtc31(data[0].contactsforCommunication[1]?data[0].contactsforCommunication[1].inputbtc3:"");
            setValuebtc41(data[0].contactsforCommunication[1]?data[0].contactsforCommunication[1].inputbtc4:"");
            setValuebtc51(data[0].contactsforCommunication[1]?data[0].contactsforCommunication[1].inputbtc5:"");
            setValuebtc61(data[0].contactsforCommunication[1]?data[0].contactsforCommunication[1].inputbtc6:"");
  
            setValuebtc22(data[0].contactsforCommunication[2]?data[0].contactsforCommunication[2].inputbtc2:"");
            setValuebtc32(data[0].contactsforCommunication[2]?data[0].contactsforCommunication[2].inputbtc3:"");
            setValuebtc42(data[0].contactsforCommunication[2]?data[0].contactsforCommunication[2].inputbtc4:"");
            setValuebtc52(data[0].contactsforCommunication[2]?data[0].contactsforCommunication[2].inputbtc5:"");
            setValuebtc62(data[0].contactsforCommunication[2]?data[0].contactsforCommunication[2].inputbtc6:"");
  
            setValuebti1(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst1:"");
            setValuebti11(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst2:"");
            setValuebti12(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst3:"");
            setValuebtr11(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst4:"");
          setValuebtr12(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst5:"");
            setValuebtr13(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst6:"");
            setValuebtr14(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst17:"");
  
            setValuebtr15(data[0].detailsofUgcRecognition[0]?data[0].detailsofUgcRecognition[0].inputst9:"");
            setValuebtr16(data[0].detailsofUgcRecognition[0]?data[0].detailsofUgcRecognition[0].inputst10:"");
  
            setValuebtr17(data[0].detailsofUgcRecognition[1]?data[0].detailsofUgcRecognition[1].inputst9:"");
            setValuebtr18(data[0].detailsofUgcRecognition[1]?data[0].detailsofUgcRecognition[1].inputst10:"");
  
  
  
            setValuebtu11(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst8:"");
            setValuebtu12(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst11:"");
  
            setValuebtc11(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst12:"");
            setValuebtc12(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst13:"");
            setValuebtc13(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst14:"");
            setValuebtc14(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst15:"");
            setValuebtc15(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst16:"");
            setValuebtc16(data[0].affiliatedStatus[0]?data[0].affiliatedStatus[0].inputst17:"");
  
            setValuebtl1(data[0].affiliatedCampus[0]?data[0].affiliatedCampus[0].inputst18:"");
            setValuebtl2(data[0].affiliatedCampus[0]?data[0].affiliatedCampus[0].inputst19:"");
            setValuebtl3(data[0].affiliatedCampus[0]?data[0].affiliatedCampus[0].inputst20:"");
  
           
  
            //
  
            setValuebtd11(data[0].recognition[0]?data[0].recognition[0].inputbtd15:"");
            setValuebtd12(data[0].recognition[0]?data[0].recognition[0].inputbtd11:"");
            setValuebtd13(data[0].recognition[0]?data[0].recognition[0].inputbtd12:"");
            setValuebtd14(data[0].recognition[0]?data[0].recognition[0].inputbtd13:"");
            setValuebtd15(data[0].recognition[0]?data[0].recognition[0].inputbtd14:"");
  
            setValuebtd21(data[0].recognition[1]?data[0].recognition[1].inputbtd15:"");
            setValuebtd22(data[0].recognition[1]?data[0].recognition[1].inputbtd11:"");
            setValuebtd23(data[0].recognition[1]?data[0].recognition[1].inputbtd12:"");
            setValuebtd24(data[0].recognition[1]?data[0].recognition[1].inputbtd13:"");
            setValuebtd25(data[0].recognition[1]?data[0].recognition[1].inputbtd14:"");
  
            setValuebtd31(data[0].recognition[2]?data[0].recognition[2].inputbtd15:"");
            setValuebtd32(data[0].recognition[2]?data[0].recognition[2].inputbtd11:"");
            setValuebtd33(data[0].recognition[2]?data[0].recognition[2].inputbtd12:"");
            setValuebtd34(data[0].recognition[2]?data[0].recognition[2].inputbtd13:"");
            setValuebtd35(data[0].recognition[2]?data[0].recognition[2].inputbtd14:"");
  
            setValuebtd41(data[0].recognition[3]?data[0].recognition[3].inputbtd15:"");
            setValuebtd42(data[0].recognition[3]?data[0].recognition[3].inputbtd11:"");
            setValuebtd43(data[0].recognition[3]?data[0].recognition[3].inputbtd12:"");
            setValuebtd44(data[0].recognition[3]?data[0].recognition[3].inputbtd13:"");
            setValuebtd45(data[0].recognition[3]?data[0].recognition[3].inputbtd14:"");
  
            // setValuebtr11(data[0].inputbtr11);
            // setValuebtr12(data[0].inputbtr12);
            // setValuebtr13(data[0].inputbtr13);
            // setValuebtr14(data[0].inputbtr14);
            // setValuebtr15(data[0].inputbtr15);
            // setValuebtr16(data[0].inputbtr16);
            // setValuebtr16(data[0].inputbtr17);
  
            setValuebtp11(data[0].academicinformation[0]?data[0].academicinformation[0].inputad1:"");
            setValuebtp12(data[0].academicinformation[0]?data[0].academicinformation[0].inputad11:"");
            setValuebtp13(data[0].academicinformation[0]?data[0].academicinformation[0].inputad12:"");
            setValuebtp14(data[0].academicinformation[0]?data[0].academicinformation[0].inputad13:"");
            setValuebtp15(data[0].academicinformation[0]?data[0].academicinformation[0].inputad14:"");
            setValuebtp16(data[0].academicinformation[0]?data[0].academicinformation[0].inputad15:"");
            setValuebtp17(data[0].academicinformation[0]?data[0].academicinformation[0].inputad16:"");
            setValuebtp18(data[0].academicinformation[0]?data[0].academicinformation[0].inputad17:"");
  
            //
            setValuebtp19(data[0].affiliatedProgrammes[0]?data[0].affiliatedProgrammes[0].inputpt1:"");
            setValuebtp20(data[0].affiliatedProgrammes[0]?data[0].affiliatedProgrammes[0].inputpt2:"");
  
            //
            setValuebtp21(data[0].affiliatedDepartment[0]?data[0].affiliatedDepartment[0].inputdt2:"");
            setValuebtp22(data[0].affiliatedDepartment[0]?data[0].affiliatedDepartment[0].inputdt3:"");
            setValuebtp23(data[0].affiliatedDepartment[0]?data[0].affiliatedDepartment[0].inputdt4:"");
            setValuebtp24(data[0].affiliatedDepartment[0]?data[0].affiliatedDepartment[0].inputdt5:"");
  
            setValuebtp31(data[0].affiliatedDepartment[1]?data[0].affiliatedDepartment[1].inputdt2:"");
            setValuebtp32(data[0].affiliatedDepartment[1]?data[0].affiliatedDepartment[1].inputdt3:"");
            setValuebtp33(data[0].affiliatedDepartment[1]?data[0].affiliatedDepartment[1].inputdt4:"");
            setValuebtp34(data[0].affiliatedDepartment[1]?data[0].affiliatedDepartment[1].inputdt5:"");
  
            setValuebtp41(data[0].affiliatedDepartment[2]?data[0].affiliatedDepartment[2].inputdt2:"");
            setValuebtp42(data[0].affiliatedDepartment[2]?data[0].affiliatedDepartment[2].inputdt3:"");
            setValuebtp43(data[0].affiliatedDepartment[2]?data[0].affiliatedDepartment[2].inputdt4:"");
            setValuebtp44(data[0].affiliatedDepartment[2]?data[0].affiliatedDepartment[2].inputdt5:"");
  
            setValuebtp51(data[0].affiliatedDepartment[3]?data[0].affiliatedDepartment[3].inputdt2:"");
            setValuebtp52(data[0].affiliatedDepartment[3]?data[0].affiliatedDepartment[3].inputdt3:"");
            setValuebtp53(data[0].affiliatedDepartment[3]?data[0].affiliatedDepartment[3].inputdt4:"");
            setValuebtp54(data[0].affiliatedDepartment[3]?data[0].affiliatedDepartment[3].inputdt5:"");
  
            //
            setValueat11(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt1:"");
            setValueat12(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt2:"");
            setValueat13(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt3:"");
            setValueat14(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt4:"");
            setValueat15(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt5:"");
            setValueat16(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt6:"");
            setValueat17(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt7:"");
            setValueat18(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt8:"");
          
            setValueat21(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt1:"");
            setValueat22(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt2:"");
            setValueat23(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt3:"");
            setValueat24(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt4:"");
            setValueat25(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt5:"");
            setValueat26(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt6:"");
            setValueat27(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt7:"");
            setValueat28(data[0].affiliatedInstitution[0]?data[0].affiliatedInstitution[0].inputatt8:"");
  
  
            setValueat31(data[0].affiliatedInstitution[2]?data[0].affiliatedInstitution[2].inputatt1:"");
            setValueat32(data[0].affiliatedInstitution[2]?data[0].affiliatedInstitution[2].inputatt2:"");
            setValueat33(data[0].affiliatedInstitution[2]?data[0].affiliatedInstitution[2].inputatt3:"");
            setValueat34(data[0].affiliatedInstitution[2]?data[0].affiliatedInstitution[2].inputatt4:"");
            setValueat35(data[0].affiliatedInstitution[2]?data[0].affiliatedInstitution[2].inputatt5:"");
            setValueat36(data[0].affiliatedInstitution[2]?data[0].affiliatedInstitution[2].inputatt6:"");
            setValueat37(data[0].affiliatedInstitution[2]?data[0].affiliatedInstitution[2].inputatt7:"");
            setValueat38(data[0].affiliatedInstitution[2]?data[0].affiliatedInstitution[2].inputatt8:"");
  
            setValueat41(data[0].affiliatedInstitution[3]?data[0].affiliatedInstitution[3].inputatt1:"");
            setValueat42(data[0].affiliatedInstitution[3]?data[0].affiliatedInstitution[3].inputatt2:"");
            setValueat43(data[0].affiliatedInstitution[3]?data[0].affiliatedInstitution[3].inputatt3:"");
            setValueat44(data[0].affiliatedInstitution[3]?data[0].affiliatedInstitution[3].inputatt4:"");
            setValueat45(data[0].affiliatedInstitution[3]?data[0].affiliatedInstitution[3].inputatt5:"");
            setValueat46(data[0].affiliatedInstitution[3]?data[0].affiliatedInstitution[3].inputatt6:"");
            setValueat47(data[0].affiliatedInstitution[3]?data[0].affiliatedInstitution[3].inputatt7:"");
            setValueat48(data[0].affiliatedInstitution[3]?data[0].affiliatedInstitution[3].inputatt8:"");
  
            setValueat51(data[0].affiliatedInstitution[4]?data[0].affiliatedInstitution[4].inputatt1:"");
            setValueat52(data[0].affiliatedInstitution[4]?data[0].affiliatedInstitution[4].inputatt2:"");
            setValueat53(data[0].affiliatedInstitution[4]?data[0].affiliatedInstitution[4].inputatt3:"");
            setValueat54(data[0].affiliatedInstitution[4]?data[0].affiliatedInstitution[4].inputatt4:"");
            setValueat55(data[0].affiliatedInstitution[4]?data[0].affiliatedInstitution[4].inputatt5:"");
            setValueat56(data[0].affiliatedInstitution[4]?data[0].affiliatedInstitution[4].inputatt6:"");
            setValueat57(data[0].affiliatedInstitution[4]?data[0].affiliatedInstitution[4].inputatt7:"");
            setValueat58(data[0].affiliatedInstitution[4]?data[0].affiliatedInstitution[4].inputatt8:"");
  
            setValueat61(data[0].affiliatedInstitution[5]?data[0].affiliatedInstitution[5].inputatt1:"");
            setValueat62(data[0].affiliatedInstitution[5]?data[0].affiliatedInstitution[5].inputatt2:"");
            setValueat63(data[0].affiliatedInstitution[5]?data[0].affiliatedInstitution[5].inputatt3:"");
            setValueat64(data[0].affiliatedInstitution[5]?data[0].affiliatedInstitution[5].inputatt4:"");
            setValueat65(data[0].affiliatedInstitution[5]?data[0].affiliatedInstitution[5].inputatt5:"");
            setValueat66(data[0].affiliatedInstitution[5]?data[0].affiliatedInstitution[5].inputatt6:"");
            setValueat67(data[0].affiliatedInstitution[5]?data[0].affiliatedInstitution[5].inputatt7:"");
            setValueat68(data[0].affiliatedInstitution[5]?data[0].affiliatedInstitution[5].inputatt8:"");
            
            
            setValueatg1(data[0].inputatg1?data[0].inputatg1:"");
  
  
            setValueatq11(data[0].affiliatedTeachingstaff[0]?data[0].affiliatedTeachingstaff[0].inputats1:"");
            setValueatq12(data[0].affiliatedTeachingstaff[0]?data[0].affiliatedTeachingstaff[0].inputats2:"");
            setValueatq13(data[0].affiliatedTeachingstaff[0]?data[0].affiliatedTeachingstaff[0].inputats3:"");
            setValueatq14(data[0].affiliatedTeachingstaff[0]?data[0].affiliatedTeachingstaff[0].inputats4:"");
            setValueatq15(data[0].affiliatedTeachingstaff[0]?data[0].affiliatedTeachingstaff[0].inputats5:"");
            setValueatq16(data[0].affiliatedTeachingstaff[0]?data[0].affiliatedTeachingstaff[0].inputats6:"");
            setValueatq17(data[0].affiliatedTeachingstaff[0]?data[0].affiliatedTeachingstaff[0].inputats7:"");
  
            
            setValueatq21(data[0].affiliatedTeachingstaff[1]?data[0].affiliatedTeachingstaff[1].inputats1:"");
            setValueatq22(data[0].affiliatedTeachingstaff[1]?data[0].affiliatedTeachingstaff[1].inputats2:"");
            setValueatq23(data[0].affiliatedTeachingstaff[1]?data[0].affiliatedTeachingstaff[1].inputats3:"");
            setValueatq24(data[0].affiliatedTeachingstaff[1]?data[0].affiliatedTeachingstaff[1].inputats4:"");
            setValueatq25(data[0].affiliatedTeachingstaff[1]?data[0].affiliatedTeachingstaff[1].inputats5:"");
            setValueatq26(data[0].affiliatedTeachingstaff[1]?data[0].affiliatedTeachingstaff[1].inputats6:"");
            setValueatq27(data[0].affiliatedTeachingstaff[1]?data[0].affiliatedTeachingstaff[1].inputats7:"");
  
            
  
           
            setValueatq31(data[0].affiliatedTeachingstaff[2]?data[0].affiliatedTeachingstaff[2].inputats1:"");
            setValueatq32(data[0].affiliatedTeachingstaff[2]?data[0].affiliatedTeachingstaff[2].inputats2:"");
            setValueatq33(data[0].affiliatedTeachingstaff[2]?data[0].affiliatedTeachingstaff[2].inputats3:"");
            setValueatq34(data[0].affiliatedTeachingstaff[2]?data[0].affiliatedTeachingstaff[2].inputats4:"");
            setValueatq35(data[0].affiliatedTeachingstaff[2]?data[0].affiliatedTeachingstaff[2].inputats5:"");
            setValueatq36(data[0].affiliatedTeachingstaff[2]?data[0].affiliatedTeachingstaff[2].inputats6:"");
            setValueatq37(data[0].affiliatedTeachingstaff[2]?data[0].affiliatedTeachingstaff[2].inputats7:"");
  
  
           
  
            setValueatq41(data[0].affiliatedTeachingstaff[3]?data[0].affiliatedTeachingstaff[3].inputats1:"");
            setValueatq42(data[0].affiliatedTeachingstaff[3]?data[0].affiliatedTeachingstaff[3].inputats2:"");
            setValueatq43(data[0].affiliatedTeachingstaff[3]?data[0].affiliatedTeachingstaff[3].inputats3:"");
            setValueatq44(data[0].affiliatedTeachingstaff[3]?data[0].affiliatedTeachingstaff[3].inputats4:"");
            setValueatq45(data[0].affiliatedTeachingstaff[3]?data[0].affiliatedTeachingstaff[3].inputats5:"");
            setValueatq46(data[0].affiliatedTeachingstaff[3]?data[0].affiliatedTeachingstaff[3].inputats6:"");
            setValueatq47(data[0].affiliatedTeachingstaff[3]?data[0].affiliatedTeachingstaff[3].inputats7:"");
  
  
  
            
  
            setValueatq51(data[0].affiliatedTeachingstaff[4]?data[0].affiliatedTeachingstaff[4].inputats1:"");
            setValueatq52(data[0].affiliatedTeachingstaff[4]?data[0].affiliatedTeachingstaff[4].inputats2:"");
            setValueatq53(data[0].affiliatedTeachingstaff[4]?data[0].affiliatedTeachingstaff[4].inputats3:"");
            setValueatq54(data[0].affiliatedTeachingstaff[4]?data[0].affiliatedTeachingstaff[4].inputats4:"");
            setValueatq55(data[0].affiliatedTeachingstaff[4]?data[0].affiliatedTeachingstaff[4].inputats5:"");
            setValueatq56(data[0].affiliatedTeachingstaff[4]?data[0].affiliatedTeachingstaff[4].inputats6:"");
            setValueatq57(data[0].affiliatedTeachingstaff[4]?data[0].affiliatedTeachingstaff[4].inputats7:"");
  
  
            
            setValueatq61(data[0].affiliatedTeachingstaff[5]?data[0].affiliatedTeachingstaff[5].inputats1:"");
            setValueatq62(data[0].affiliatedTeachingstaff[5]?data[0].affiliatedTeachingstaff[5].inputats2:"");
            setValueatq63(data[0].affiliatedTeachingstaff[5]?data[0].affiliatedTeachingstaff[5].inputats3:"");
            setValueatq64(data[0].affiliatedTeachingstaff[5]?data[0].affiliatedTeachingstaff[5].inputats4:"");
            setValueatq65(data[0].affiliatedTeachingstaff[5]?data[0].affiliatedTeachingstaff[5].inputats5:"");
            setValueatq66(data[0].affiliatedTeachingstaff[5]?data[0].affiliatedTeachingstaff[5].inputats6:"");
            setValueatq67(data[0].affiliatedTeachingstaff[5]?data[0].affiliatedTeachingstaff[5].inputats7:"");
  
            setValueatq71(data[0].affiliatedTeachingstaff[6]?data[0].affiliatedTeachingstaff[6].inputats1:"");
            setValueatq72(data[0].affiliatedTeachingstaff[6]?data[0].affiliatedTeachingstaff[6].inputats2:"");
            setValueatq73(data[0].affiliatedTeachingstaff[6]?data[0].affiliatedTeachingstaff[6].inputats3:"");
            setValueatq74(data[0].affiliatedTeachingstaff[6]?data[0].affiliatedTeachingstaff[6].inputats4:"");
            setValueatq75(data[0].affiliatedTeachingstaff[6]?data[0].affiliatedTeachingstaff[6].inputats5:"");
            setValueatq76(data[0].affiliatedTeachingstaff[6]?data[0].affiliatedTeachingstaff[6].inputats6:"");
            setValueatq77(data[0].affiliatedTeachingstaff[6]?data[0].affiliatedTeachingstaff[6].inputats7:"");
  
            setValueatq81(data[0].affiliatedTeachingstaff[7]?data[0].affiliatedTeachingstaff[7].inputats1:"");
            setValueatq82(data[0].affiliatedTeachingstaff[7]?data[0].affiliatedTeachingstaff[7].inputats2:"");
            setValueatq83(data[0].affiliatedTeachingstaff[7]?data[0].affiliatedTeachingstaff[7].inputats3:"");
            setValueatq84(data[0].affiliatedTeachingstaff[7]?data[0].affiliatedTeachingstaff[7].inputats4:"");
            setValueatq85(data[0].affiliatedTeachingstaff[7]?data[0].affiliatedTeachingstaff[7].inputats5:"");
            setValueatq86(data[0].affiliatedTeachingstaff[7]?data[0].affiliatedTeachingstaff[7].inputats6:"");
            setValueatq87(data[0].affiliatedTeachingstaff[7]?data[0].affiliatedTeachingstaff[7].inputats7:"");
  
            setValueatq91(data[0].affiliatedTeachingstaff[8]?data[0].affiliatedTeachingstaff[8].inputats1:"");
            setValueatq92(data[0].affiliatedTeachingstaff[8]?data[0].affiliatedTeachingstaff[8].inputats2:"");
            setValueatq93(data[0].affiliatedTeachingstaff[8]?data[0].affiliatedTeachingstaff[8].inputats3:"");
            setValueatq94(data[0].affiliatedTeachingstaff[8]?data[0].affiliatedTeachingstaff[8].inputats4:"");
            setValueatq95(data[0].affiliatedTeachingstaff[8]?data[0].affiliatedTeachingstaff[8].inputats5:"");
            setValueatq96(data[0].affiliatedTeachingstaff[8]?data[0].affiliatedTeachingstaff[8].inputats6:"");
            setValueatq97(data[0].affiliatedTeachingstaff[8]?data[0].affiliatedTeachingstaff[8].inputats7:"");
  
            setValueatq101(data[0].affiliatedTeachingstaff[9]?data[0].affiliatedTeachingstaff[9].inputats1:"");
            setValueatq102(data[0].affiliatedTeachingstaff[9]?data[0].affiliatedTeachingstaff[9].inputats2:"");
            setValueatq103(data[0].affiliatedTeachingstaff[9]?data[0].affiliatedTeachingstaff[9].inputats3:"");
            setValueatq104(data[0].affiliatedTeachingstaff[9]?data[0].affiliatedTeachingstaff[9].inputats4:"");
            setValueatq105(data[0].affiliatedTeachingstaff[9]?data[0].affiliatedTeachingstaff[9].inputats5:"");
            setValueatq106(data[0].affiliatedTeachingstaff[9]?data[0].affiliatedTeachingstaff[9].inputats6:"");
            setValueatq107(data[0].affiliatedTeachingstaff[9]?data[0].affiliatedTeachingstaff[9].inputats7:"");
          
            setValueatq111(data[0].affiliatedTeachingstaff[10]?data[0].affiliatedTeachingstaff[10].inputats1:"");
            setValueatq112(data[0].affiliatedTeachingstaff[10]?data[0].affiliatedTeachingstaff[10].inputats2:"");
            setValueatq113(data[0].affiliatedTeachingstaff[10]?data[0].affiliatedTeachingstaff[10].inputats3:"");
            setValueatq114(data[0].affiliatedTeachingstaff[10]?data[0].affiliatedTeachingstaff[10].inputats4:"");
            setValueatq115(data[0].affiliatedTeachingstaff[10]?data[0].affiliatedTeachingstaff[10].inputats5:"");
            setValueatq116(data[0].affiliatedTeachingstaff[10]?data[0].affiliatedTeachingstaff[10].inputats6:"");
            setValueatq117(data[0].affiliatedTeachingstaff[10]?data[0].affiliatedTeachingstaff[10].inputats7:"");
  
            setValueatq121(data[0].affiliatedTeachingstaff[11]?data[0].affiliatedTeachingstaff[11].inputats1:"");
            setValueatq122(data[0].affiliatedTeachingstaff[11]?data[0].affiliatedTeachingstaff[11].inputats2:"");
            setValueatq123(data[0].affiliatedTeachingstaff[11]?data[0].affiliatedTeachingstaff[11].inputats3:"");
            setValueatq124(data[0].affiliatedTeachingstaff[11]?data[0].affiliatedTeachingstaff[11].inputats4:"");
            setValueatq125(data[0].affiliatedTeachingstaff[11]?data[0].affiliatedTeachingstaff[11].inputats5:"");
            setValueatq126(data[0].affiliatedTeachingstaff[11]?data[0].affiliatedTeachingstaff[11].inputats6:"");
            setValueatq127(data[0].affiliatedTeachingstaff[11]?data[0].affiliatedTeachingstaff[11].inputats7:"");
  
            setValueatq131(data[0].affiliatedTeachingstaff[12]?data[0].affiliatedTeachingstaff[12].inputats1:"");
            setValueatq132(data[0].affiliatedTeachingstaff[12]?data[0].affiliatedTeachingstaff[12].inputats2:"");
            setValueatq133(data[0].affiliatedTeachingstaff[12]?data[0].affiliatedTeachingstaff[12].inputats3:"");
            setValueatq134(data[0].affiliatedTeachingstaff[12]?data[0].affiliatedTeachingstaff[12].inputats4:"");
            setValueatq135(data[0].affiliatedTeachingstaff[12]?data[0].affiliatedTeachingstaff[12].inputats5:"");
            setValueatq136(data[0].affiliatedTeachingstaff[12]?data[0].affiliatedTeachingstaff[12].inputats6:"");
            setValueatq137(data[0].affiliatedTeachingstaff[12]?data[0].affiliatedTeachingstaff[12].inputats7:"");
  
  
            setValueatq141(data[0].affiliatedTeachingstaff[13]?data[0].affiliatedTeachingstaff[13].inputats1:"");
            setValueatq142(data[0].affiliatedTeachingstaff[13]?data[0].affiliatedTeachingstaff[13].inputats2:"");
            setValueatq143(data[0].affiliatedTeachingstaff[13]?data[0].affiliatedTeachingstaff[13].inputats3:"");
            setValueatq144(data[0].affiliatedTeachingstaff[13]?data[0].affiliatedTeachingstaff[13].inputats4:"");
            setValueatq145(data[0].affiliatedTeachingstaff[13]?data[0].affiliatedTeachingstaff[13].inputats5:"");
            setValueatq146(data[0].affiliatedTeachingstaff[13]?data[0].affiliatedTeachingstaff[13].inputats6:"");
            setValueatq147(data[0].affiliatedTeachingstaff[13]?data[0].affiliatedTeachingstaff[13].inputats7:"");
  
            setValueatq151(data[0].affiliatedTeachingstaff[14]?data[0].affiliatedTeachingstaff[14].inputats1:"");
            setValueatq152(data[0].affiliatedTeachingstaff[14]?data[0].affiliatedTeachingstaff[14].inputats2:"");
            setValueatq153(data[0].affiliatedTeachingstaff[14]?data[0].affiliatedTeachingstaff[14].inputats3:"");
            setValueatq154(data[0].affiliatedTeachingstaff[14]?data[0].affiliatedTeachingstaff[14].inputats4:"");
            setValueatq155(data[0].affiliatedTeachingstaff[14]?data[0].affiliatedTeachingstaff[14].inputats5:"");
            setValueatq156(data[0].affiliatedTeachingstaff[14]?data[0].affiliatedTeachingstaff[14].inputats6:"");
            setValueatq157(data[0].affiliatedTeachingstaff[14]?data[0].affiliatedTeachingstaff[14].inputats7:"");
  
           
            
  
            //
            setValueatg11(data[0].affiliatedAdmittstudents[0]?data[0].affiliatedAdmittstudents[0].inputat1:"");
            setValueatg12(data[0].affiliatedAdmittstudents[0]?data[0].affiliatedAdmittstudents[0].inputat2:"");
            setValueatg13(data[0].affiliatedAdmittstudents[0]?data[0].affiliatedAdmittstudents[0].inputat3:"");
            setValueatg14(data[0].affiliatedAdmittstudents[0]?data[0].affiliatedAdmittstudents[0].inputat4:"");
            setValueatg15(data[0].affiliatedAdmittstudents[0]?data[0].affiliatedAdmittstudents[0].inputat5:"");
            setValueatg16(data[0].affiliatedAdmittstudents[0]?data[0].affiliatedAdmittstudents[0].inputat6:"");
            setValueatg17(data[0].affiliatedAdmittstudents[0]?data[0].affiliatedAdmittstudents[0].inputat7:"");
            setValueatg18(data[0].affiliatedAdmittstudents[0]?data[0].affiliatedAdmittstudents[0].inputat8:"");
  
            setValueatg21(data[0].affiliatedAdmittstudents[1]?data[0].affiliatedAdmittstudents[1].inputat1:"");
            setValueatg22(data[0].affiliatedAdmittstudents[1]?data[0].affiliatedAdmittstudents[1].inputat2:"");
            setValueatg23(data[0].affiliatedAdmittstudents[1]?data[0].affiliatedAdmittstudents[1].inputat3:"");
            setValueatg24(data[0].affiliatedAdmittstudents[1]?data[0].affiliatedAdmittstudents[1].inputat4:"");
            setValueatg25(data[0].affiliatedAdmittstudents[1]?data[0].affiliatedAdmittstudents[1].inputat5:"");
            setValueatg26(data[0].affiliatedAdmittstudents[1]?data[0].affiliatedAdmittstudents[1].inputat6:"");
            setValueatg27(data[0].affiliatedAdmittstudents[1]?data[0].affiliatedAdmittstudents[1].inputat7:"");
            setValueatg28(data[0].affiliatedAdmittstudents[1]?data[0].affiliatedAdmittstudents[1].inputat8:"");
  
            setValueatg31(data[0].affiliatedAdmittstudents[2]?data[0].affiliatedAdmittstudents[2].inputat1:"");
            setValueatg32(data[0].affiliatedAdmittstudents[2]?data[0].affiliatedAdmittstudents[2].inputat2:"");
            setValueatg33(data[0].affiliatedAdmittstudents[2]?data[0].affiliatedAdmittstudents[2].inputat3:"");
            setValueatg34(data[0].affiliatedAdmittstudents[2]?data[0].affiliatedAdmittstudents[2].inputat4:"");
            setValueatg35(data[0].affiliatedAdmittstudents[2]?data[0].affiliatedAdmittstudents[2].inputat5:"");
            setValueatg36(data[0].affiliatedAdmittstudents[2]?data[0].affiliatedAdmittstudents[2].inputat6:"");
            setValueatg37(data[0].affiliatedAdmittstudents[2]?data[0].affiliatedAdmittstudents[2].inputat7:"");
            setValueatg38(data[0].affiliatedAdmittstudents[2]?data[0].affiliatedAdmittstudents[2].inputat8:"");
  
            setValueatg41(data[0].affiliatedAdmittstudents[3]?data[0].affiliatedAdmittstudents[3].inputat1:"");
            setValueatg42(data[0].affiliatedAdmittstudents[3]?data[0].affiliatedAdmittstudents[3].inputat2:"");
            setValueatg43(data[0].affiliatedAdmittstudents[3]?data[0].affiliatedAdmittstudents[3].inputat3:"");
            setValueatg44(data[0].affiliatedAdmittstudents[3]?data[0].affiliatedAdmittstudents[3].inputat4:"");
            setValueatg45(data[0].affiliatedAdmittstudents[3]?data[0].affiliatedAdmittstudents[3].inputat5:"");
            setValueatg46(data[0].affiliatedAdmittstudents[3]?data[0].affiliatedAdmittstudents[3].inputat6:"");
            setValueatg47(data[0].affiliatedAdmittstudents[3]?data[0].affiliatedAdmittstudents[3].inputat7:"");
            setValueatg48(data[0].affiliatedAdmittstudents[3]?data[0].affiliatedAdmittstudents[3].inputat8:"");
  
            setValueatg51(data[0].affiliatedAdmittstudents[4]?data[0].affiliatedAdmittstudents[4].inputat1:"");
            setValueatg52(data[0].affiliatedAdmittstudents[4]?data[0].affiliatedAdmittstudents[4].inputat2:"");
            setValueatg53(data[0].affiliatedAdmittstudents[4]?data[0].affiliatedAdmittstudents[4].inputat3:"");
            setValueatg54(data[0].affiliatedAdmittstudents[4]?data[0].affiliatedAdmittstudents[4].inputat4:"");
            setValueatg55(data[0].affiliatedAdmittstudents[4]?data[0].affiliatedAdmittstudents[4].inputat5:"");
            setValueatg56(data[0].affiliatedAdmittstudents[4]?data[0].affiliatedAdmittstudents[4].inputat6:"");
            setValueatg57(data[0].affiliatedAdmittstudents[4]?data[0].affiliatedAdmittstudents[4].inputat7:"");
            setValueatg58(data[0].affiliatedAdmittstudents[4]?data[0].affiliatedAdmittstudents[4].inputat8:"");
  
            //
  
            setValuebtpp11(data[0].affiliatedEnrollment[0]?data[0].affiliatedEnrollment[0].inputet2:"");
            setValuebtpp12(data[0].affiliatedEnrollment[0]?data[0].affiliatedEnrollment[0].inputet3:"");
            setValuebtpp13(data[0].affiliatedEnrollment[0]?data[0].affiliatedEnrollment[0].inputet4:"");
            setValuebtpp14(data[0].affiliatedEnrollment[0]?data[0].affiliatedEnrollment[0].inputet5:"");
            setValuebtpp15(data[0].affiliatedEnrollment[0]?data[0].affiliatedEnrollment[0].inputet6:"");
  
            setValuebtpp21(data[0].affiliatedEnrollment[1]?data[0].affiliatedEnrollment[1].inputet2:"");
            setValuebtpp22(data[0].affiliatedEnrollment[1]?data[0].affiliatedEnrollment[1].inputet3:"");
            setValuebtpp23(data[0].affiliatedEnrollment[1]?data[0].affiliatedEnrollment[1].inputet4:"");
            setValuebtpp24(data[0].affiliatedEnrollment[1]?data[0].affiliatedEnrollment[1].inputet5:"");
            setValuebtpp25(data[0].affiliatedEnrollment[1]?data[0].affiliatedEnrollment[1].inputet6:"");
  
            setValuebtpp31(data[0].affiliatedEnrollment[2]?data[0].affiliatedEnrollment[2].inputet2:"");
            setValuebtpp32(data[0].affiliatedEnrollment[2]?data[0].affiliatedEnrollment[2].inputet3:"");
            setValuebtpp33(data[0].affiliatedEnrollment[2]?data[0].affiliatedEnrollment[2].inputet4:"");
            setValuebtpp34(data[0].affiliatedEnrollment[2]?data[0].affiliatedEnrollment[2].inputet5:"");
            setValuebtpp35(data[0].affiliatedEnrollment[2]?data[0].affiliatedEnrollment[2].inputet6:"");
  
            setValuebtpp41(data[0].affiliatedEnrollment[3]?data[0].affiliatedEnrollment[3].inputet2:"");
            setValuebtpp42(data[0].affiliatedEnrollment[3]?data[0].affiliatedEnrollment[3].inputet3:"");
            setValuebtpp43(data[0].affiliatedEnrollment[3]?data[0].affiliatedEnrollment[3].inputet4:"");
            setValuebtpp44(data[0].affiliatedEnrollment[3]?data[0].affiliatedEnrollment[3].inputet5:"");
            setValuebtpp45(data[0].affiliatedEnrollment[3]?data[0].affiliatedEnrollment[3].inputet6:"");
  
            setValuebtpp51(data[0].affiliatedEnrollment[4]?data[0].affiliatedEnrollment[4].inputet2:"");
            setValuebtpp52(data[0].affiliatedEnrollment[4]?data[0].affiliatedEnrollment[4].inputet3:"");
            setValuebtpp53(data[0].affiliatedEnrollment[4]?data[0].affiliatedEnrollment[4].inputet4:"");
            setValuebtpp54(data[0].affiliatedEnrollment[4]?data[0].affiliatedEnrollment[4].inputet5:"");
            setValuebtpp55(data[0].affiliatedEnrollment[4]?data[0].affiliatedEnrollment[4].inputet6:"");
  
            //
            setValuebtpp61(data[0].affiliatedEducation[0]?data[0].affiliatedEducation[0].inputct1:"");
            setValuebtpp62(data[0].affiliatedEducation[0]?data[0].affiliatedEducation[0].inputct2:"");
            setValuebtpp63(data[0].affiliatedEducation[0]?data[0].affiliatedEducation[0].inputct3:"");
  
            //
            setValuebtda1(data[0].affiliatedAccrediation[0]?data[0].affiliatedAccrediation[0].inputat1:"");
            setValuebtda2(data[0].affiliatedAccrediation[0]?data[0].affiliatedAccrediation[0].inputat2:"");
            setValuebtda3(data[0].affiliatedAccrediation[0]?data[0].affiliatedAccrediation[0].inputat3:"");
            setValuebtda4(data[0].affiliatedAccrediation[0]?data[0].affiliatedAccrediation[0].inputat4:"");
            setValuebtda5(data[0].affiliatedAccrediation[0]?data[0].affiliatedAccrediation[0].inputat5:"");
            setValuebtda6(data[0].affiliatedAccrediation[0]?data[0].affiliatedAccrediation[0].inputat6:"");
            setValuebtda7(data[0].affiliatedAccrediation[0]?data[0].affiliatedAccrediation[0].inputat7:"");
            setValuebtda8(data[0].affiliatedAccrediation[0]?data[0].affiliatedAccrediation[0].inputat8:"");
  
  
            setValuebtda9(data[0].affiliatedAnnualQuality[0]?data[0].affiliatedAnnualQuality[0].inputat9:"");
            setValuebtdr1(data[0].affiliatedAnnualQuality[0]?data[0].affiliatedAnnualQuality[0].inputat10:"");
            setValuebtdr2(data[0].affiliatedAnnualQuality[0]?data[0].affiliatedAnnualQuality[0].inputat11:"");
            setValuebtdr3(data[0].affiliatedAnnualQuality[0]?data[0].affiliatedAnnualQuality[0].inputat12:"");
            setValuebtdr4(data[0].affiliatedAnnualQuality[0]?data[0].affiliatedAnnualQuality[0].inputat13:"");
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );

  // sending data to db with API
  let role = null;
  let email = null;
  // eslint-disable-next-line prefer-destructuring, no-undef
  role = AuthService.getCurrentUser().roles[0];
  // eslint-disable-next-line no-undef
  email = AuthService.getCurrentUser().email;
  const finacialyear = "2021-2022";
  const authorize = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    assignedTo: email,
    assignedBy: email,
    principalComments: "",
    role,
    deanStatus: "A",
    programmerId: "basicinfo",
  };

  const rejectContent = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    assignedTo: "anamita1996@gmail.com",
    assignedBy: email,
    deanStatus: "R",
    deanComments: rejectReasonComments,
    programmerId: "basicinfo",
  };
  // eslint-disable-next-line no-redeclare
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }
  function getAuthorizeBasicinfo() {
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
        + 'academicdatasubmittoprincipalgetallacademicdata?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
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
  function getRejectBasicinfo() {
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
        + 'academicdataDeanRejectRecord?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
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
                  readonly
                  type="text"
                  id="bt1"
                  value={valuebt1}
                  onChange={(e) => setValuebt1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Address</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="bt2"
                  value={valuebt2}
                  onChange={(e) => setValuebt2(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>City</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="bt3"
                  value={valuebt3}
                  onChange={(e) => setValuebt3(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>State</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="bt4"
                  value={valuebt4}
                  onChange={(e) => setValuebt4(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Pin</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="bt5"
                  value={valuebt5}
                  onChange={(e) => setValuebt5(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Website</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="bt6"
                  value={valuebt6}
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
                  readonly
                  id="btc2"
                  value={valuebtc2}
                  onChange={(e) => setValuebtc2(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc3"
                  value={valuebtc3}
                  onChange={(e) => setValuebtc3(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc4"
                  value={valuebtc4}
                  onChange={(e) => setValuebtc4(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc5"
                  value={valuebtc5}
                  onChange={(e) => setValuebtc5(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc6"
                  value={valuebtc6}
                  onChange={(e) => setValuebtc6(e.target.value)}
                  type="text"
                />
              </td>
            </tr>
            <tr>
              <td>Vice Principal</td>
              <td>
                <input
                  readonly
                  id="btc2"
                  value={valuebtc21}
                  onChange={(e) => setValuebtc21(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc3"
                  value={valuebtc31}
                  onChange={(e) => setValuebtc31(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc4"
                  value={valuebtc41}
                  onChange={(e) => setValuebtc41(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc5"
                  value={valuebtc51}
                  onChange={(e) => setValuebtc51(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc6"
                  value={valuebtc61}
                  onChange={(e) => setValuebtc61(e.target.value)}
                  type="text"
                />
              </td>
            </tr>
            <tr>
              <td>IQAC Co-ordinator</td>
              <td>
                <input
                  readonly
                  id="btc2"
                  value={valuebtc22}
                  onChange={(e) => setValuebtc22(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc3"
                  value={valuebtc32}
                  onChange={(e) => setValuebtc32(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc4"
                  value={valuebtc42}
                  onChange={(e) => setValuebtc42(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc5"
                  value={valuebtc52}
                  onChange={(e) => setValuebtc52(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc6"
                  value={valuebtc62}
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
          </label>
          <input
            readonly
            type="text"
            style={{ width: "20%", marginLeft: "20px" }}
            id="bti1"
            value={valuebti1}
            onChange={(e) => setValuebti1(e.target.value)}
          />
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t4" style={{ fontWeight: "600" }}>
            4.Type of Institution:
          </label>
          <p
            style={{ fontWeight: "600" }}
            // id="bti11"
            // value={valuebti11}
            // onChange={(e) => setValuebti11(e.target.value)}
          >
            By Gender
          </p>
          <label>i.For Men</label>
          <input
            readonly
            type="radio"
            name="opion1"
            id="bti11"
            value={valuebti11}
            onChange={(e) => setValuebti11(e.target.value)}
            style={{ paddingRight: "0px" }}
          />
          <label>ii. For Women</label>
          <input
            readonly
            type="radio"
            name="opion1"
            id="bti11"
            value={valuebti11}
            onChange={(e) => setValuebti11(e.target.value)}
          />
          <label>iii.Co-education </label>
          <input
            readonly
            type="radio"
            name="opion1"
            id="bti11"
            value={valuebti11}
            onChange={(e) => setValuebti11(e.target.value)}
          />
          <p
            style={{ fontWeight: "600" }}
            id="bti12"
            // value={valuebti12}
            // onChange={(e) => setValuebti12(e.target.value)}
          >
            By Shift
          </p>
          <label>i. Regular</label>
          <input
            readonly
            type="radio"
            name="opion2"
            id="bti12"
            value={valuebti12}
            onChange={(e) => setValuebti12(e.target.value)}
          />
          <label>ii. Day</label>
          <input
            readonly
            type="radio"
            name="opion2"
            id="bti12"
            value={valuebti12}
            onChange={(e) => setValuebti12(e.target.value)}
          />
          <label>iii. Evening </label>
          <input
            readonly
            type="radio"
            name="opion2"
            id="bti12"
            value={valuebti12}
            onChange={(e) => setValuebti12(e.target.value)}
          />
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t4" style={{ fontWeight: "600" }}>
            5. It is a recognized minority institution?
          </label>
          <br></br>
          <label htmlFor="basicInfo-t4">Yes</label>
          <input
            readonly
            type="radio"
            name="opion3"
            value={valuebtr11}
            text="Yes"
            id="btr11"
            onChange={(e) => setValuebtr11(e.target.value)}
          />
          <label htmlFor="basicInfo-t4">No</label>
          <input
            readonly
            type="radio"
            name="opion3"
            value={valuebtr11}
            text="No"
            id="btr11"
            onChange={(e) => setValuebtr11(e.target.value)}
          />
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t4" style={{ fontWeight: "600" }}>
            6. Source of funding: Government Grant-in-aid Self-finacing Any
            other
          </label>
          <input
            readonly
            type="text"
            style={{ width: "20%", marginLeft: "20px" }}
            id="btr12"
            value={valuebtr12}
            onChange={(e) => setValuebtr12(e.target.value)}
          />
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t4" style={{ fontWeight: "600" }}>
            7. a. Date of establishment of the college: (dd/mm/yyyy)
          </label>
          <input
            readonly
            type="date"
            style={{ width: "20%", marginLeft: "20px" }}
            id="btr13"
            value={valuebtr13}
            onChange={(e) => setValuebtr13(e.target.value)}
          />
          <br></br>
          <label htmlFor="basicInfo-t4">
            b. University to which the college is affiliated / or which governs
            the college (If it is a constituent college)
          </label>
          <input
            readonly
            type="text"
            style={{ width: "20%", marginLeft: "20px" }}
            id="btr14"
            value={valuebtr14}
            onChange={(e) => setValuebtr14(e.target.value)}
          />
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
                  readonly
                  type="text"
                  id="btr15"
                  value={valuebtr15}
                  onChange={(e) => setValuebtr15(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btr16"
                  value={valuebtr16}
                  onChange={(e) => setValuebtr16(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>ii. 12(B)</td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btr17"
                  value={valuebtr17}
                  onChange={(e) => setValuebtr17(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btr18"
                  value={valuebtr18}
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
                  readonly
                  type="text"
                  id="btd11"
                  value={valuebtd11}
                  onChange={(e) => setValuebtd11(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd12"
                  value={valuebtd12}
                  onChange={(e) => setValuebtd12(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd13"
                  value={valuebtd13}
                  onChange={(e) => setValuebtd13(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd14"
                  value={valuebtd14}
                  onChange={(e) => setValuebtd14(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd15"
                  value={valuebtd15}
                  onChange={(e) => setValuebtd15(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <td>
                ii.
                <input
                  readonly
                  type="text"
                  id="btd21"
                  value={valuebtd21}
                  onChange={(e) => setValuebtd21(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd22"
                  value={valuebtd22}
                  onChange={(e) => setValuebtd22(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd23"
                  value={valuebtd23}
                  onChange={(e) => setValuebtd23(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd24"
                  value={valuebtd24}
                  onChange={(e) => setValuebtd24(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd25"
                  value={valuebtd25}
                  onChange={(e) => setValuebtd25(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>
                iii.
                <input
                  readonly
                  type="text"
                  id="btd31"
                  value={valuebtd31}
                  onChange={(e) => setValuebtd31(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd32"
                  value={valuebtd32}
                  onChange={(e) => setValuebtd32(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd33"
                  value={valuebtd33}
                  onChange={(e) => setValuebtd33(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd34"
                  value={valuebtd34}
                  onChange={(e) => setValuebtd34(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd35"
                  value={valuebtd35}
                  onChange={(e) => setValuebtd35(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>
                iv.
                <input
                  readonly
                  type="text"
                  id="btd41"
                  value={valuebtd41}
                  onChange={(e) => setValuebtd41(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd42"
                  value={valuebtd42}
                  onChange={(e) => setValuebtd42(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd43"
                  value={valuebtd43}
                  onChange={(e) => setValuebtd43(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd44"
                  value={valuebtd44}
                  onChange={(e) => setValuebtd44(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd45"
                  value={valuebtd45}
                  onChange={(e) => setValuebtd45(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <label style={{ fontWeight: "600" }}>
          8. Does the affiliating university Act provide for conferment of
          autonomy (as recognized by the UGC), on its affiliated colleges?
        </label>
        <label>Yes</label>
        <input
          readonly
          type="radio"
          name="opion4"
          id="btu11"
          value={valuebtu11}
          onChange={(e) => setValuebtu11(e.target.value)}
        />
        <label>No</label>
        <input
          readonly
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
          readonly
          type="radio"
          name="opion5"
          id="btu12"
          value={valuebtu12}
          onChange={(e) => setValuebtu12(e.target.value)}
        />
        <label>No</label>
        <input
          readonly
          type="radio"
          name="opion5"
          value={valuebtu12}
          id="btu12"
          onChange={(e) => setValuebtu12(e.target.value)}
        />
      </div>
      <div className="eachTable-container">
        <p style={{ fontWeight: "600" }}>9. Is the college recognized</p>
        <label>
          a. by UGC as a College with Potential for Excellence (CPE)?
          <input
            readonly
            type="radio"
            name="opion6"
            id="btc11"
            value={valuebtc11}
            onChange={(e) => setValuebtc11(e.target.value)}
          />{" "}
          Yes
          <input
            readonly
            type="radio"
            name="opion6"
            value={valuebtc11}
            id="btc11"
            onChange={(e) => setValuebtc11(e.target.value)}
          />
          No
        </label>
        <label style={{ fontWeight: "600" }}>
          If yes, date of recognition:....(dd/mm/yyyy)
        </label>
        <input
          readonly
          type="date"
          style={{ width: "20%" }}
          id="btc12"
          value={valuebtc12}
          onChange={(e) => setValuebtc12(e.target.value)}
        />
        <label>Yes</label>
        <input
          readonly
          type="radio"
          name="opion7"
          id="btc13"
          value={valuebtc13}
          onChange={(e) => setValuebtc13(e.target.value)}
        />
        <label>No</label>
        <input
          readonly
          type="radio"
          name="opion7"
          value={valuebtc13}
          id="btc13"
          onChange={(e) => setValuebtc13(e.target.value)}
        />
        <label style={{ fontWeight: "600" }}>
          b. For its performance by any other governmental agency?
        </label>
        <label>Yes</label>
        <input
          readonly
          type="radio"
          name="opion8"
          id="btc14"
          value={valuebtc14}
          onChange={(e) => setValuebtc14(e.target.value)}
        />
        <label>No</label>
        <input
          readonly
          type="radio"
          name="opion8"
          value={valuebtc14}
          id="btc14"
          onChange={(e) => setValuebtc14(e.target.value)}
        />
        <label>If yes, Name of the agency.....</label>
        <input
          readonly
          type="text"
          style={{ width: "20%" }}
          id="btc15"
          value={valuebtc15}
          onChange={(e) => setValuebtc15(e.target.value)}
        />
        <label>Date of recognition.....(dd/mm/yyyy)</label>
        <input
          readonly
          type="date"
          style={{ width: "20%" }}
          id="btc16"
          value={valuebtc16}
          onChange={(e) => setValuebtc16(e.target.value)}
        />
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
                  readonly
                  type="text"
                  id="btl1"
                  value={valuebtl1}
                  onChange={(e) => setValuebtl1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Campus area in sq.mts.</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="btl2"
                  value={valuebtl2}
                  onChange={(e) => setValuebtl2(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Built up area in sq.mts.</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="btl3"
                  value={valuebtl3}
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
                readonly
                type="text"
                id="btp11"
                value={valuebtp11}
                onChange={(e) => setValuebtp11(e.target.value)}
              />
            </td>
            <td>
              <select
                name="Programme"
                id="btp12"
                value={valuebtp12}
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
                readonly
                type="text"
                id="btp13"
                value={valuebtp13}
                onChange={(e) => setValuebtp13(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp14"
                value={valuebtp14}
                onChange={(e) => setValuebtp14(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp15"
                value={valuebtp15}
                onChange={(e) => setValuebtp15(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp16"
                value={valuebtp16}
                onChange={(e) => setValuebtp16(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp17"
                value={valuebtp17}
                onChange={(e) => setValuebtp17(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp18"
                value={valuebtp18}
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
              readonly
              type="text"
              id="btp19"
              value={valuebtp19}
              onChange={(e) => setValuebtp19(e.target.value)}
            />
          </td>
          <td>
            <input
              readonly
              type="text"
              id="btp20"
              value={valuebtp20}
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
          all the programmes.)
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
                readonly
                type="text"
                id="btp21"
                value={valuebtp21}
                onChange={(e) => setValuebtp21(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp22"
                value={valuebtp22}
                onChange={(e) => setValuebtp22(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp23"
                value={valuebtp23}
                onChange={(e) => setValuebtp23(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp24"
                value={valuebtp24}
                onChange={(e) => setValuebtp24(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>Arts</td>
            <td>
              <input
                readonly
                type="text"
                id="btp31"
                value={valuebtp31}
                onChange={(e) => setValuebtp31(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp32"
                value={valuebtp32}
                onChange={(e) => setValuebtp32(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp33"
                value={valuebtp33}
                onChange={(e) => setValuebtp33(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp34"
                value={valuebtp34}
                onChange={(e) => setValuebtp34(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>Commerce</td>
            <td>
              <input
                readonly
                type="text"
                id="btp41"
                value={valuebtp41}
                onChange={(e) => setValuebtp41(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp42"
                value={valuebtp42}
                onChange={(e) => setValuebtp42(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp43"
                value={valuebtp43}
                onChange={(e) => setValuebtp43(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp44"
                value={valuebtp44}
                onChange={(e) => setValuebtp44(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>Any other (Specify) :</td>
            <td>
              <input
                readonly
                type="text"
                id="btp51"
                value={valuebtp51}
                onChange={(e) => setValuebtp51(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp52"
                value={valuebtp52}
                onChange={(e) => setValuebtp52(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp53"
                value={valuebtp53}
                onChange={(e) => setValuebtp53(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="btp54"
                value={valuebtp54}
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
                  readonly
                  type="text"
                  style={{ height: "100%" }}
                  id="at11"
                  value={valueat11}
                  onChange={(e) => setValueat11(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at12"
                  value={valueat12}
                  onChange={(e) => setValueat12(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at13"
                  value={valueat13}
                  onChange={(e) => setValueat13(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at14"
                  value={valueat14}
                  onChange={(e) => setValueat14(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at15"
                  value={valueat15}
                  onChange={(e) => setValueat15(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at16"
                  value={valueat16}
                  onChange={(e) => setValueat16(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at15"
                  value={valueat15}
                  onChange={(e) => setValueat17(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at16"
                  value={valueat16}
                  onChange={(e) => setValueat18(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Recruited</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="at21"
                  value={valueat21}
                  onChange={(e) => setValueat21(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at22"
                  value={valueat22}
                  onChange={(e) => setValueat22(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at23"
                  value={valueat23}
                  onChange={(e) => setValueat23(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at24"
                  value={valueat24}
                  onChange={(e) => setValueat24(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at25"
                  value={valueat25}
                  onChange={(e) => setValueat25(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at26"
                  value={valueat26}
                  onChange={(e) => setValueat26(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at27"
                  value={valueat27}
                  onChange={(e) => setValueat27(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at28"
                  value={valueat28}
                  onChange={(e) => setValueat28(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="at31"
                  value={valueat31}
                  onChange={(e) => setValueat31(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at32"
                  value={valueat32}
                  onChange={(e) => setValueat32(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at33"
                  value={valueat33}
                  onChange={(e) => setValueat33(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  value={valueat34}
                  id="at34"
                  onChange={(e) => setValueat34(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at35"
                  value={valueat35}
                  onChange={(e) => setValueat35(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at36"
                  value={valueat36}
                  onChange={(e) => setValueat36(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at37"
                  value={valueat37}
                  onChange={(e) => setValueat37(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at38"
                  value={valueat38}
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
                  readonly
                  type="text"
                  id="at41"
                  value={valueat41}
                  onChange={(e) => setValueat41(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at42"
                  value={valueat42}
                  onChange={(e) => setValueat42(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at43"
                  value={valueat43}
                  onChange={(e) => setValueat43(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at44"
                  value={valueat44}
                  onChange={(e) => setValueat44(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at45"
                  value={valueat45}
                  onChange={(e) => setValueat45(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at46"
                  value={valueat46}
                  onChange={(e) => setValueat46(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at47"
                  value={valueat47}
                  onChange={(e) => setValueat47(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at48"
                  value={valueat48}
                  onChange={(e) => setValueat48(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Recruited</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="at51"
                  value={valueat51}
                  onChange={(e) => setValueat51(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at52"
                  value={valueat52}
                  onChange={(e) => setValueat52(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at53"
                  value={valueat53}
                  onChange={(e) => setValueat53(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at54"
                  value={valueat54}
                  onChange={(e) => setValueat54(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at55"
                  value={valueat55}
                  onChange={(e) => setValueat55(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at56"
                  value={valueat56}
                  onChange={(e) => setValueat56(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at57"
                  value={valueat57}
                  onChange={(e) => setValueat57(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  value={valueat58}
                  id="at58"
                  onChange={(e) => setValueat58(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Yet to Recruit</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="at61"
                  value={valueat61}
                  onChange={(e) => setValueat61(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at62"
                  value={valueat62}
                  onChange={(e) => setValueat62(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at63"
                  value={valueat63}
                  onChange={(e) => setValueat63(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at64"
                  value={valueat64}
                  onChange={(e) => setValueat64(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at65"
                  value={valueat65}
                  onChange={(e) => setValueat65(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at66"
                  value={valueat66}
                  onChange={(e) => setValueat66(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at67"
                  value={valueat67}
                  onChange={(e) => setValueat67(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="at68"
                  value={valueat68}
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
                  readonly
                  type="text"
                  style={{ height: "100%" }}
                  id="atq11"
                  value={valueatq11}
                  onChange={(e) => setValueatq11(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq12"
                  value={valueatq12}
                  onChange={(e) => setValueatq12(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq13"
                  value={valueatq13}
                  onChange={(e) => setValueatq13(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq14"
                  value={valueatq14}
                  onChange={(e) => setValueatq14(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq15"
                  value={valueatq15}
                  onChange={(e) => setValueatq15(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq16"
                  value={valueatq16}
                  onChange={(e) => setValueatq16(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
                  readonly
                  type="text"
                  id="atq21"
                  value={valueatq21}
                  onChange={(e) => setValueatq21(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq22"
                  value={valueatq22}
                  onChange={(e) => setValueatq22(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq23"
                  value={valueatq23}
                  onChange={(e) => setValueatq23(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq24"
                  value={valueatq24}
                  onChange={(e) => setValueatq24(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq25"
                  value={valueatq25}
                  onChange={(e) => setValueatq25(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq26"
                  value={valueatq26}
                  onChange={(e) => setValueatq26(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
                  readonly
                  type="text"
                  id="atq31"
                  value={valueatq31}
                  onChange={(e) => setValueatq31(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq32"
                  value={valueatq32}
                  onChange={(e) => setValueatq32(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq33"
                  value={valueatq33}
                  onChange={(e) => setValueatq33(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq34"
                  value={valueatq34}
                  onChange={(e) => setValueatq34(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq35"
                  value={valueatq35}
                  onChange={(e) => setValueatq35(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq36"
                  value={valueatq36}
                  onChange={(e) => setValueatq36(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
                  readonly
                  type="text"
                  id="atq51"
                  value={valueatq41}
                  onChange={(e) => setValueatq41(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq52"
                  value={valueatq42}
                  onChange={(e) => setValueatq42(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq53"
                  value={valueatq43}
                  onChange={(e) => setValueatq43(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq54"
                  value={valueatq44}
                  onChange={(e) => setValueatq44(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq55"
                  value={valueatq45}
                  onChange={(e) => setValueatq45(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq56"
                  value={valueatq46}
                  onChange={(e) => setValueatq46(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
                  readonly
                  type="text"
                  id="atq61"
                  value={valueatq51}
                  onChange={(e) => setValueatq51(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq62"
                  value={valueatq52}
                  onChange={(e) => setValueatq52(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq63"
                  value={valueatq53}
                  onChange={(e) => setValueatq53(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq64"
                  value={valueatq54}
                  onChange={(e) => setValueatq54(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq65"
                  value={valueatq55}
                  onChange={(e) => setValueatq55(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq66"
                  value={valueatq56}
                  onChange={(e) => setValueatq56(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
                  readonly
                  type="text"
                  id="atq71"
                  value={valueatq61}
                  onChange={(e) => setValueatq61(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq72"
                  value={valueatq62}
                  onChange={(e) => setValueatq62(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq73"
                  value={valueatq63}
                  onChange={(e) => setValueatq63(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq74"
                  value={valueatq64}
                  onChange={(e) => setValueatq64(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq75"
                  value={valueatq65}
                  onChange={(e) => setValueatq65(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq76"
                  value={valueatq66}
                  onChange={(e) => setValueatq66(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
                  readonly
                  type="text"
                  value={valueatq71}
                  id="atq81"
                  onChange={(e) => setValueatq71(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq82"
                  value={valueatq72}
                  onChange={(e) => setValueatq72(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq83"
                  value={valueatq73}
                  onChange={(e) => setValueatq73(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq84"
                  value={valueatq74}
                  onChange={(e) => setValueatq74(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq85"
                  value={valueatq75}
                  onChange={(e) => setValueatq75(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq86"
                  value={valueatq76}
                  onChange={(e) => setValueatq76(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
                  readonly
                  type="text"
                  id="atq91"
                  value={valueatq81}
                  onChange={(e) => setValueatq81(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq92"
                  value={valueatq82}
                  onChange={(e) => setValueatq82(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq93"
                  value={valueatq83}
                  onChange={(e) => setValueatq83(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq94"
                  value={valueatq84}
                  onChange={(e) => setValueatq84(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq95"
                  value={valueatq85}
                  onChange={(e) => setValueatq85(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq96"
                  value={valueatq86}
                  onChange={(e) => setValueatq86(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
                  readonly
                  type="text"
                  id="atq101"
                  value={valueatq91}
                  onChange={(e) => setValueatq91(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq102"
                  value={valueatq92}
                  onChange={(e) => setValueatq92(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq103"
                  value={valueatq93}
                  onChange={(e) => setValueatq93(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq104"
                  value={valueatq94}
                  onChange={(e) => setValueatq94(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq105"
                  value={valueatq95}
                  onChange={(e) => setValueatq95(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq106"
                  value={valueatq96}
                  onChange={(e) => setValueatq96(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
                  readonly
                  type="text"
                  id="atq111"
                  value={valueatq101}
                  onChange={(e) => setValueatq101(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq112"
                  value={valueatq102}
                  onChange={(e) => setValueatq102(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq113"
                  value={valueatq103}
                  onChange={(e) => setValueatq103(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq114"
                  value={valueatq104}
                  onChange={(e) => setValueatq104(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  value={valueatq105}
                  id="atq115"
                  onChange={(e) => setValueatq105(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  value={valueatq106}
                  id="atq116"
                  onChange={(e) => setValueatq106(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
                  readonly
                  type="text"
                  id="atq121"
                  value={valueatq111}
                  onChange={(e) => setValueatq111(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq122"
                  value={valueatq112}
                  onChange={(e) => setValueatq112(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq123"
                  value={valueatq113}
                  onChange={(e) => setValueatq113(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq124"
                  value={valueatq114}
                  onChange={(e) => setValueatq114(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq125"
                  value={valueatq115}
                  onChange={(e) => setValueatq115(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq126"
                  value={valueatq116}
                  onChange={(e) => setValueatq116(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
                  readonly
                  type="text"
                  id="atq131"
                  value={valueatq121}
                  onChange={(e) => setValueatq121(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq132"
                  value={valueatq122}
                  onChange={(e) => setValueatq122(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq133"
                  value={valueatq123}
                  onChange={(e) => setValueatq123(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq134"
                  value={valueatq124}
                  onChange={(e) => setValueatq124(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq135"
                  value={valueatq125}
                  onChange={(e) => setValueatq125(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq136"
                  value={valueatq126}
                  onChange={(e) => setValueatq126(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
                  readonly
                  type="text"
                  id="atq141"
                  value={valueatq131}
                  onChange={(e) => setValueatq131(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq142"
                  value={valueatq132}
                  onChange={(e) => setValueatq132(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq143"
                  value={valueatq133}
                  onChange={(e) => setValueatq133(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq144"
                  value={valueatq134}
                  onChange={(e) => setValueatq134(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq145"
                  value={valueatq135}
                  onChange={(e) => setValueatq135(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq146"
                  value={valueatq136}
                  onChange={(e) => setValueatq136(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
                  readonly
                  type="text"
                  value={valueatq141}
                  id="atq151"
                  onChange={(e) => setValueatq141(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq152"
                  value={valueatq142}
                  onChange={(e) => setValueatq142(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq153"
                  value={valueatq143}
                  onChange={(e) => setValueatq143(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq154"
                  value={valueatq144}
                  onChange={(e) => setValueatq144(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq155"
                  value={valueatq145}
                  onChange={(e) => setValueatq145(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq156"
                  value={valueatq146}
                  onChange={(e) => setValueatq146(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
                  readonly
                  type="text"
                  id="atq161"
                  value={valueatq151}
                  onChange={(e) => setValueatq151(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq162"
                  value={valueatq152}
                  onChange={(e) => setValueatq152(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq163"
                  value={valueatq153}
                  onChange={(e) => setValueatq153(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq164"
                  value={valueatq154}
                  onChange={(e) => setValueatq154(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq165"
                  value={valueatq155}
                  onChange={(e) => setValueatq155(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="atq166"
                  value={valueatq156}
                  onChange={(e) => setValueatq156(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
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
        </label>
        <input
          readonly
          type="text"
          id="atg1"
          value={valueatg1}
          onChange={(e) => setValueatg1(e.target.value)}
        />
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
                readonly
                type="text"
                style={{ height: "100%" }}
                id="atg11"
                value={valueatg11}
                onChange={(e) => setValueatg11(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg12"
                value={valueatg12}
                onChange={(e) => setValueatg12(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg13"
                value={valueatg13}
                onChange={(e) => setValueatg13(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg14"
                value={valueatg14}
                onChange={(e) => setValueatg14(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg15"
                value={valueatg15}
                onChange={(e) => setValueatg15(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg16"
                value={valueatg16}
                onChange={(e) => setValueatg16(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg17"
                value={valueatg17}
                onChange={(e) => setValueatg17(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg18"
                value={valueatg18}
                onChange={(e) => setValueatg18(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th>ST</th>
            <td>
              <input
                readonly
                type="text"
                id="atg21"
                value={valueatg21}
                onChange={(e) => setValueatg21(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg22"
                value={valueatg22}
                onChange={(e) => setValueatg22(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg23"
                value={valueatg23}
                onChange={(e) => setValueatg23(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg24"
                value={valueatg24}
                onChange={(e) => setValueatg24(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg25"
                value={valueatg25}
                onChange={(e) => setValueatg25(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg26"
                value={valueatg26}
                onChange={(e) => setValueatg26(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg27"
                value={valueatg27}
                onChange={(e) => setValueatg27(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg28"
                value={valueatg28}
                onChange={(e) => setValueatg28(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th>OBC</th>
            <td>
              <input
                readonly
                type="text"
                id="atg31"
                value={valueatg31}
                onChange={(e) => setValueatg31(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg32"
                value={valueatg32}
                onChange={(e) => setValueatg32(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg33"
                value={valueatg33}
                onChange={(e) => setValueatg33(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg34"
                value={valueatg34}
                onChange={(e) => setValueatg34(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg35"
                value={valueatg35}
                onChange={(e) => setValueatg35(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg36"
                value={valueatg36}
                onChange={(e) => setValueatg36(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg37"
                value={valueatg37}
                onChange={(e) => setValueatg37(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg38"
                value={valueatg38}
                onChange={(e) => setValueatg38(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th>General</th>
            <td>
              <input
                readonly
                type="text"
                id="atg41"
                value={valueatg41}
                onChange={(e) => setValueatg41(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg42"
                value={valueatg42}
                onChange={(e) => setValueatg42(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg43"
                value={valueatg43}
                onChange={(e) => setValueatg43(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg44"
                value={valueatg44}
                onChange={(e) => setValueatg44(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg45"
                value={valueatg45}
                onChange={(e) => setValueatg45(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg46"
                value={valueatg46}
                onChange={(e) => setValueatg46(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg47"
                value={valueatg47}
                onChange={(e) => setValueatg47(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg48"
                value={valueatg48}
                onChange={(e) => setValueatg48(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th>Others</th>
            <td>
              <input
                readonly
                type="text"
                id="atg51"
                value={valueatg51}
                onChange={(e) => setValueatg51(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg52"
                value={valueatg52}
                onChange={(e) => setValueatg52(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg53"
                value={valueatg53}
                onChange={(e) => setValueatg53(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg54"
                value={valueatg54}
                onChange={(e) => setValueatg54(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg55"
                value={valueatg55}
                onChange={(e) => setValueatg55(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg56"
                value={valueatg56}
                onChange={(e) => setValueatg56(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg57"
                value={valueatg57}
                onChange={(e) => setValueatg57(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                id="atg58"
                value={valueatg58}
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
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp11"
                value={valuebtpp11}
                onChange={(e) => setValuebtpp11(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp12"
                value={valuebtpp12}
                onChange={(e) => setValuebtpp12(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp13"
                value={valuebtpp13}
                onChange={(e) => setValuebtpp13(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp14"
                value={valuebtpp14}
                onChange={(e) => setValuebtpp14(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp15"
                value={valuebtpp15}
                onChange={(e) => setValuebtpp15(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>Students from other states of India</td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp21"
                value={valuebtpp21}
                onChange={(e) => setValuebtpp21(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp22"
                value={valuebtpp22}
                onChange={(e) => setValuebtpp22(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp23"
                value={valuebtpp23}
                onChange={(e) => setValuebtpp23(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp24"
                value={valuebtpp24}
                onChange={(e) => setValuebtpp24(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp25"
                value={valuebtpp25}
                onChange={(e) => setValuebtpp25(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>NRI Students</td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp31"
                value={valuebtpp31}
                onChange={(e) => setValuebtpp31(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp32"
                value={valuebtpp32}
                onChange={(e) => setValuebtpp32(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp33"
                value={valuebtpp33}
                onChange={(e) => setValuebtpp33(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp34"
                value={valuebtpp34}
                onChange={(e) => setValuebtpp34(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp35"
                value={valuebtpp35}
                onChange={(e) => setValuebtpp35(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>Foreign Students</td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp41"
                value={valuebtpp41}
                onChange={(e) => setValuebtpp41(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp42"
                value={valuebtpp42}
                onChange={(e) => setValuebtpp42(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp43"
                value={valuebtpp43}
                onChange={(e) => setValuebtpp43(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp44"
                value={valuebtpp44}
                onChange={(e) => setValuebtpp44(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp45"
                value={valuebtpp45}
                onChange={(e) => setValuebtpp45(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>Total</td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp51"
                value={valuebtpp51}
                onChange={(e) => setValuebtpp51(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp52"
                value={valuebtpp52}
                onChange={(e) => setValuebtpp52(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp53"
                value={valuebtpp53}
                onChange={(e) => setValuebtpp53(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp54"
                value={valuebtpp54}
                onChange={(e) => setValuebtpp54(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp55"
                value={valuebtpp55}
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
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp61"
                value={valuebtpp61}
                onChange={(e) => setValuebtpp61(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp62"
                value={valuebtpp62}
                onChange={(e) => setValuebtpp62(e.target.value)}
              />
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ height: "100%" }}
                id="btpp63"
                value={valuebtpp63}
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
          <label htmlFor="academicInfo-t1">Cycle 1:</label> &nbsp; &nbsp; &nbsp;
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input
            readonly
            type="date"
            style={{ width: "30%" }}
            id="btda1"
            value={valuebtda1}
            onChange={(e) => setValuebtda1(e.target.value)}
          />{" "}
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <label htmlFor="academicInfo-t1">
            Accreditation Outcome/Result:{" "}
          </label>
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input
            readonly
            type="text"
            style={{ width: "30%" }}
            id="btda2"
            value={valuebtda2}
            onChange={(e) => setValuebtda2(e.target.value)}
          />
        </div>
        <br></br>
        <div>
          <label htmlFor="academicInfo-t1">Cycle 2: </label> &nbsp;&nbsp; &nbsp;
          &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
          <input
            readonly
            type="date"
            style={{ width: "30%" }}
            id="btda3"
            value={valuebtda3}
            onChange={(e) => setValuebtda3(e.target.value)}
          />{" "}
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <label htmlFor="academicInfo-t1">
            Accreditation Outcome/Result:{" "}
          </label>
          &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input
            readonly
            type="text"
            style={{ width: "30%" }}
            id="btda4"
            value={valuebtda4}
            onChange={(e) => setValuebtda4(e.target.value)}
          />
        </div>
        <br></br>
        <div>
          <label htmlFor="academicInfo-t1">Cycle 3: </label> &nbsp;&nbsp; &nbsp;
          &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
          <input
            readonly
            type="date"
            style={{ width: "30%" }}
            id="btda5"
            value={valuebtda5}
            onChange={(e) => setValuebtda5(e.target.value)}
          />
          &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <label htmlFor="academicInfo-t1">
            Accreditation Outcome/Result:{" "}
          </label>
          &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
          <input
            readonly
            type="text"
            style={{ width: "30%" }}
            id="btda6"
            value={valuebtda6}
            onChange={(e) => setValuebtda6(e.target.value)}
          />
        </div>
        <br></br>
        <div>
          <label htmlFor="academicInfo-t1">Cycle 4: </label> &nbsp;&nbsp; &nbsp;
          &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
          <input
            readonly
            type="date"
            style={{ width: "30%" }}
            id="btda7"
            value={valuebtda7}
            onChange={(e) => setValuebtda7(e.target.value)}
          />{" "}
          &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <label htmlFor="academicInfo-t1">
            Accreditation Outcome/Result:{" "}
          </label>{" "}
          &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
          <input
            readonly
            type="text"
            style={{ width: "30%" }}
            id="btda8"
            value={valuebtda8}
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
          <label>IQAC</label>: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input
            readonly
            type="date"
            style={{ width: "30%" }}
            id="btda9"
            value={valuebtda9}
            onChange={(e) => setValuebtda9(e.target.value)}
          />
        </div>
      </div>
      <div className="eachTable-container">
        <label htmlFor="academicInfo-t1">
          22. Details regarding submission of Annual Quality Assurance Reports
          to NAAC
        </label>
        <br></br>
        <div>
          <label>AQAR (i)</label> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          &nbsp;
          <input
            readonly
            type="date"
            style={{ width: "30%" }}
            id="btdr1"
            value={valuebtdr1}
            onChange={(e) => setValuebtdr1(e.target.value)}
          />
          <br></br>
          <br></br>
        </div>
        <div>
          <label>AQAR (ii)</label> &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          &nbsp;
          <input
            readonly
            type="date"
            style={{ width: "30%" }}
            id="btdr2"
            value={valuebtdr2}
            onChange={(e) => setValuebtdr2(e.target.value)}
          />
        </div>
        <br></br>

        <div>
          <label>AQAR (iii)</label> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input
            readonly
            type="date"
            style={{ width: "30%" }}
            id="btdr3"
            value={valuebtdr3}
            onChange={(e) => setValuebtdr3(e.target.value)}
          />
        </div>
        <br></br>
        <div>
          <label>AQAR (iv)</label> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input
            readonly
            type="date"
            style={{ width: "30%" }}
            id="btdr4"
            value={valuebtdr4}
            onChange={(e) => setValuebtdr4(e.target.value)}
          />
        </div>
      </div>
      <div className="c11x-button-container" style={{ paddingBottom: "30px" }}>
        <div>Principal Comments : {principalComments}</div>
        <div className="c31x-button-container">
          <button
            onClick={(e) => {
              getAuthorizeBasicinfo(e);
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
                  getRejectBasicinfo(e);
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
    </div>
  );
}

export default BasicInfo;
<></>;
