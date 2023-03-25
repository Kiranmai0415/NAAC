import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import "./ExtendedProfile-style.css";
import AuthService from "../../../Pages/Users/services/auth.service";
import { resources } from "../../../appConstants";

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

function ExtendedProfile() {
  const [valueep11, setValueep11] = useState();
  const [valueep12, setValueep12] = useState();
  const [valueep13, setValueep13] = useState();
  const [valueep14, setValueep14] = useState();
  const [valueep15, setValueep15] = useState();

  const [valueep21, setValueep21] = useState();
  const [valueep22, setValueep22] = useState();
  const [valueep23, setValueep23] = useState();
  const [valueep24, setValueep24] = useState();
  const [valueep25, setValueep25] = useState();

  const [valueep31, setValueep31] = useState();
  const [valueep32, setValueep32] = useState();
  const [valueep33, setValueep33] = useState();
  const [valueep34, setValueep34] = useState();
  const [valueep35, setValueep35] = useState();

  const [valueep41, setValueep41] = useState();
  const [valueep42, setValueep42] = useState();
  const [valueep43, setValueep43] = useState();
  const [valueep44, setValueep44] = useState();
  const [valueep45, setValueep45] = useState();

  const [valueep51, setValueep51] = useState();
  const [valueep52, setValueep52] = useState();
  const [valueep53, setValueep53] = useState();
  const [valueep54, setValueep54] = useState();
  const [valueep55, setValueep55] = useState();

  const [valueep61, setValueep61] = useState();
  const [valueep62, setValueep62] = useState();
  const [valueep63, setValueep63] = useState();
  const [valueep64, setValueep64] = useState();
  const [valueep65, setValueep65] = useState();

  const [valueep71, setValueep71] = useState();
  const [valueep72, setValueep72] = useState();
  const [valueep73, setValueep73] = useState();
  const [valueep74, setValueep74] = useState();
  const [valueep75, setValueep75] = useState();

  const [valueep81, setValueep81] = useState();
  const [valueep82, setValueep82] = useState();
  const [valueep83, setValueep83] = useState();
  const [valueep84, setValueep84] = useState();
  const [valueep85, setValueep85] = useState();

  const [valueep91, setValueep91] = useState();
  const [valueep92, setValueep92] = useState();
  const [valueep93, setValueep93] = useState();
  const [valueep94, setValueep94] = useState();
  const [valueep95, setValueep95] = useState();

  const [valueep101, setValueep101] = useState();
  const [valueep102, setValueep102] = useState();
  const [valueep103, setValueep103] = useState();
  const [valueep104, setValueep104] = useState();
  const [valueep105, setValueep105] = useState();

  const [valueep111, setValueep111] = useState();
  const [valueep112, setValueep112] = useState();
  const [valueep113, setValueep113] = useState();
  const [valueep114, setValueep114] = useState();
  const [valueep115, setValueep115] = useState();

  const [valueep121, setValueep121] = useState();
  const [valueep122, setValueep122] = useState();
  const [valueep123, setValueep123] = useState();
  const [valueep124, setValueep124] = useState();
  const [valueep125, setValueep125] = useState();

  const [valueep131, setValueep131] = useState();
  const [valueep132, setValueep132] = useState();
  const [valueep133, setValueep133] = useState();
  const [valueep134, setValueep134] = useState();
  const [valueep135, setValueep135] = useState();

  const [valueep141, setValueep141] = useState();
  const [valueep142, setValueep142] = useState();
  const [valueep143, setValueep143] = useState();
  const [valueep144, setValueep144] = useState();
  const [valueep145, setValueep145] = useState();

  const [valueep151, setValueep151] = useState();
  const [valueep152, setValueep152] = useState();
  const [valueep153, setValueep153] = useState();
  const [valueep154, setValueep154] = useState();
  const [valueep155, setValueep155] = useState();

  const [valueep161, setValueep161] = useState();
  const [valueep162, setValueep162] = useState();
  const [valueep163, setValueep163] = useState();
  const [valueep164, setValueep164] = useState();
  const [valueep165, setValueep165] = useState();

  const [valueep171, setValueep171] = useState();
  const [valueep172, setValueep172] = useState();
  const [valueep173, setValueep173] = useState();
  const [valueep174, setValueep174] = useState();
  const [valueep175, setValueep175] = useState();

  const [valueep181, setValueep181] = useState();
  const [valueep182, setValueep182] = useState();
  const [valueep183, setValueep183] = useState();
  const [valueep184, setValueep184] = useState();
  const [valueep185, setValueep185] = useState();

  const [valueep191, setValueep191] = useState();
  const [valueep192, setValueep192] = useState();
  const [valueep193, setValueep193] = useState();
  const [valueep194, setValueep194] = useState();
  const [valueep195, setValueep195] = useState();

  const [valueep201, setValueep201] = useState();
  const [valueep202, setValueep202] = useState();
  const [valueep203, setValueep203] = useState();
  const [valueep204, setValueep204] = useState();
  const [valueep205, setValueep205] = useState();

  const [valueep211, setValueep211] = useState();
  const [valueep212, setValueep212] = useState();
  const [valueep213, setValueep213] = useState();
  const [valueep214, setValueep214] = useState();
  const [valueep215, setValueep215] = useState();

  const [valueep221, setValueep221] = useState();
  const [valueep222, setValueep222] = useState();
  const [valueep223, setValueep223] = useState();
  const [valueep224, setValueep224] = useState();
  const [valueep225, setValueep225] = useState();

  const [value43, setValue43] = useState();
  const [value44, setValue44] = useState();

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
  const financialYear="2021-2022";
  useEffect(
    () => fetch('http://localhost:8080/api/v1/getallextendeddata?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          setValueep11(data[0].epYeartable11[0] ? data[0].epYeartable11[0].input11y:"");
          setValueep21(data[0].epYeartable11[0] ? data[0].epYeartable11[0].input11v:"");
          setValueep12(data[0].epYeartable11[1] ? data[0].epYeartable11[1].input11y:"");
          setValueep22(data[0].epYeartable11[1] ? data[0].epYeartable11[1].input11v:"");
          setValueep13(data[0].epYeartable11[2] ? data[0].epYeartable11[2].input11y:"");
          setValueep23(data[0].epYeartable11[2] ? data[0].epYeartable11[2].input11v:"");
          setValueep14(data[0].epYeartable11[3] ? data[0].epYeartable11[3].input11y:"");
          setValueep24(data[0].epYeartable11[3] ? data[0].epYeartable11[3].input11v:"");
          setValueep15(data[0].epYeartable11[4] ? data[0].epYeartable11[4].input11y:"");
          setValueep25(data[0].epYeartable11[4] ? data[0].epYeartable11[4].input11v:"");

          setValueep31(data[0].epYeartable21[0] ? data[0].epYeartable21[0].input21y:"");
          setValueep41(data[0].epYeartable21[0] ? data[0].epYeartable21[0].input21v:"");
          setValueep32(data[0].epYeartable21[1] ? data[0].epYeartable21[1].input21y:"");
          setValueep42(data[0].epYeartable21[1] ? data[0].epYeartable21[1].input21v:"");
          setValueep33(data[0].epYeartable21[2] ? data[0].epYeartable21[2].input21y:"");
          setValueep43(data[0].epYeartable21[2] ? data[0].epYeartable21[2].input21v:"");
          setValueep34(data[0].epYeartable21[3] ? data[0].epYeartable21[3].input21y:"");
          setValueep44(data[0].epYeartable21[3] ? data[0].epYeartable21[3].input21v:"");
          setValueep35(data[0].epYeartable21[4] ? data[0].epYeartable21[4].input21y:"");
          setValueep45(data[0].epYeartable21[4] ? data[0].epYeartable21[4].input21v:"");

          setValueep51(data[0].epYeartable22[0] ? data[0].epYeartable22[0].input22y:"");
          setValueep61(data[0].epYeartable22[0] ? data[0].epYeartable22[0].input22v:"");
          setValueep52(data[0].epYeartable22[1] ? data[0].epYeartable22[1].input22y:"");
          setValueep62(data[0].epYeartable22[1] ? data[0].epYeartable22[1].input22v:"");
          setValueep53(data[0].epYeartable22[2] ? data[0].epYeartable22[2].input22y:"");
          setValueep63(data[0].epYeartable22[2] ? data[0].epYeartable22[2].input22v:"");
          setValueep54(data[0].epYeartable22[3] ? data[0].epYeartable22[3].input22y:"");
          setValueep64(data[0].epYeartable22[3] ? data[0].epYeartable22[3].input22v:"");
          setValueep55(data[0].epYeartable22[4] ? data[0].epYeartable22[4].input22y:"");
          setValueep65(data[0].epYeartable22[4] ? data[0].epYeartable22[4].input22v:"");

          setValueep71(data[0].epYeartable23[0] ? data[0].epYeartable23[0].input23y:"");
          setValueep81(data[0].epYeartable23[0] ? data[0].epYeartable23[0].input23v:"");
          setValueep72(data[0].epYeartable23[1] ? data[0].epYeartable23[1].input23y:"");
          setValueep82(data[0].epYeartable23[1] ? data[0].epYeartable23[1].input23v:"");
          setValueep73(data[0].epYeartable23[2] ? data[0].epYeartable23[2].input23y:"");
          setValueep83(data[0].epYeartable23[2] ? data[0].epYeartable23[2].input23v:"");
          setValueep74(data[0].epYeartable23[3] ? data[0].epYeartable23[3].input23y:"");
          setValueep84(data[0].epYeartable23[3] ? data[0].epYeartable23[3].input23v:"");
          setValueep75(data[0].epYeartable23[4] ? data[0].epYeartable23[4].input23y:"");
          setValueep85(data[0].epYeartable23[4] ? data[0].epYeartable23[4].input23v:"");

          setValueep91(data[0].epYeartable24[0] ? data[0].epYeartable24[0].input24y:"");
          setValueep101(data[0].epYeartable24[0] ? data[0].epYeartable24[0].input24v:"");
          setValueep92(data[0].epYeartable24[1] ? data[0].epYeartable24[1].input24y:"");
          setValueep102(data[0].epYeartable24[1] ? data[0].epYeartable24[1].input24v:"");
          setValueep93(data[0].epYeartable24[2] ? data[0].epYeartable24[2].input24y:"");
          setValueep103(data[0].epYeartable24[2] ? data[0].epYeartable24[2].input24v:"");
          setValueep94(data[0].epYeartable24[3] ? data[0].epYeartable24[3].input24y:"");
          setValueep104(data[0].epYeartable24[3] ? data[0].epYeartable24[3].input24v:"");
          setValueep95(data[0].epYeartable24[4] ? data[0].epYeartable24[4].input24y:"");
          setValueep105(data[0].epYeartable24[4] ? data[0].epYeartable24[4].input24v:"");

          setValueep111(data[0].epYeartable31[0] ? data[0].epYeartable31[0].input31y:"");
          setValueep121(data[0].epYeartable31[0] ? data[0].epYeartable31[0].input31v:"");
          setValueep112(data[0].epYeartable31[1] ? data[0].epYeartable31[1].input31y:"");
          setValueep122(data[0].epYeartable31[1] ? data[0].epYeartable31[1].input31v:"");
          setValueep113(data[0].epYeartable31[2] ? data[0].epYeartable31[2].input31y:"");
          setValueep123(data[0].epYeartable31[2] ? data[0].epYeartable31[2].input31v:"");
          setValueep114(data[0].epYeartable31[3] ? data[0].epYeartable31[3].input31y:"");
          setValueep124(data[0].epYeartable31[3] ? data[0].epYeartable31[3].input31v:"");
          setValueep115(data[0].epYeartable31[4] ? data[0].epYeartable31[4].input31y:"");
          setValueep125(data[0].epYeartable31[4] ? data[0].epYeartable31[4].input31v:"");

          setValueep131(data[0].epYeartable32[0] ? data[0].epYeartable32[0].input32y:"");
          setValueep141(data[0].epYeartable32[0] ? data[0].epYeartable32[0].input32v:"");
          setValueep132(data[0].epYeartable32[1] ? data[0].epYeartable32[1].input32y:"");
          setValueep142(data[0].epYeartable32[1] ? data[0].epYeartable32[1].input32v:"");
          setValueep133(data[0].epYeartable32[2] ? data[0].epYeartable32[2].input32y:"");
          setValueep143(data[0].epYeartable32[2] ? data[0].epYeartable32[2].input32v:"");
          setValueep134(data[0].epYeartable32[3] ? data[0].epYeartable32[3].input32y:"");
          setValueep144(data[0].epYeartable32[3] ? data[0].epYeartable32[3].input32v:"");
          setValueep135(data[0].epYeartable32[4] ? data[0].epYeartable32[4].input32y:"");
          setValueep145(data[0].epYeartable32[4] ? data[0].epYeartable32[4].input32v:"");

          setValueep151(data[0].epYeartable33[0] ? data[0].epYeartable33[0].input33y:"");
          setValueep161(data[0].epYeartable33[0] ? data[0].epYeartable33[0].input33v:"");
          setValueep152(data[0].epYeartable33[1] ? data[0].epYeartable33[1].input33y:"");
          setValueep162(data[0].epYeartable33[1] ? data[0].epYeartable33[1].input33v:"");
          setValueep153(data[0].epYeartable33[2] ? data[0].epYeartable33[2].input33y:"");
          setValueep163(data[0].epYeartable33[2] ? data[0].epYeartable33[2].input33v:"");
          setValueep154(data[0].epYeartable33[3] ? data[0].epYeartable33[3].input33y:"");
          setValueep164(data[0].epYeartable33[3] ? data[0].epYeartable33[3].input33v:"");
          setValueep155(data[0].epYeartable33[4] ? data[0].epYeartable33[4].input33y:"");
          setValueep165(data[0].epYeartable33[4] ? data[0].epYeartable33[4].input33v:"");

          setValueep171(data[0].epYeartable41[0] ? data[0].epYeartable41[0].input41y:"");
          setValueep181(data[0].epYeartable41[0] ? data[0].epYeartable41[0].input41v:"");
          setValueep172(data[0].epYeartable41[1] ? data[0].epYeartable41[1].input41y:"");
          setValueep182(data[0].epYeartable41[1] ? data[0].epYeartable41[1].input41v:"");
          setValueep173(data[0].epYeartable41[2] ? data[0].epYeartable41[2].input41y:"");
          setValueep183(data[0].epYeartable41[2] ? data[0].epYeartable41[2].input41v:"");
          setValueep174(data[0].epYeartable41[3] ? data[0].epYeartable41[3].input41y:"");
          setValueep184(data[0].epYeartable41[3] ? data[0].epYeartable41[3].input41v:"");
          setValueep175(data[0].epYeartable41[4] ? data[0].epYeartable41[4].input41y:"");
          setValueep185(data[0].epYeartable41[4] ? data[0].epYeartable41[4].input41v:"");

          setValueep191(data[0].epYeartable42[0] ? data[0].epYeartable42[0].input42y:"");
          setValueep201(data[0].epYeartable42[0] ? data[0].epYeartable42[0].input42v:"");
          setValueep192(data[0].epYeartable42[1] ? data[0].epYeartable42[1].input42y:"");
          setValueep202(data[0].epYeartable42[1] ? data[0].epYeartable42[1].input42v:"");
          setValueep193(data[0].epYeartable42[2] ? data[0].epYeartable42[2].input42y:"");
          setValueep203(data[0].epYeartable42[2] ? data[0].epYeartable42[2].input42v:"");
          setValueep194(data[0].epYeartable42[3] ? data[0].epYeartable42[3].input42y:"");
          setValueep204(data[0].epYeartable42[3] ? data[0].epYeartable42[3].input42v:"");
          setValueep195(data[0].epYeartable42[4] ? data[0].epYeartable42[4].input42y:"");
          setValueep205(data[0].epYeartable42[4] ? data[0].epYeartable42[4].input42v:"");

          setValue43(data[0] ? data[0].eTable43v:"");
          setValue44(data[0] ? data[0].eTable44v:"");

          setValueep211(data[0].epYeartable45[0] ? data[0].epYeartable45[0].input45y:"");
          setValueep221(data[0].epYeartable45[0] ? data[0].epYeartable45[0].input45v:"");
          setValueep212(data[0].epYeartable45[1] ? data[0].epYeartable45[1].input45y:"");
          setValueep222(data[0].epYeartable45[1] ? data[0].epYeartable45[1].input45v:"");
          setValueep213(data[0].epYeartable45[2] ? data[0].epYeartable45[2].input45y:"");
          setValueep223(data[0].epYeartable45[2] ? data[0].epYeartable45[2].input45v:"");
          setValueep214(data[0].epYeartable45[3] ? data[0].epYeartable45[3].input45y:"");
          setValueep224(data[0].epYeartable45[3] ? data[0].epYeartable45[3].input45v:"");
          setValueep215(data[0].epYeartable45[4] ? data[0].epYeartable45[4].input45y:"");
          setValueep225(data[0].epYeartable45[4] ? data[0].epYeartable45[4].input45v:"");
        })
        .catch((error) => {
          console.error("Error:", error);
        })
    ),
    []
  );

  
  


  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    eTable43v: value43,
    eTable44v: value44,
    eTable12v: "33",
    epYeartable11: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:201,
        input11y: valueep11, input11v: valueep21 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:202,
        input11y: valueep12, input11v: valueep22 },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:203,
        input11y: valueep13, input11v: valueep23 },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:204,
        input11y: valueep14, input11v: valueep24 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:205,
        input11y: valueep15, input11v: valueep25 },
      
    ],
    epYeartable21: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:201,
        input21y: valueep31, input21v: valueep41 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:202,
        input21y: valueep32, input21v: valueep42 },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:203,
        input21y: valueep33, input21v: valueep43 },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:204,
        input21y: valueep34, input21v: valueep44 },
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:205,
        input21y: valueep35, input21v: valueep45 },
    ],
    epYeartable22: [
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:201,
        input22y: valueep51, input22v: valueep61 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:202,
         input22y: valueep52, input22v: valueep62 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:203,
        input22y: valueep53, input22v: valueep63 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:204,
        input22y: valueep54, input22v: valueep64 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:205,
        input22y: valueep55, input22v: valueep65 },
    ],
    epYeartable23: [
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:201,
        input23y: valueep71, input23v: valueep81 },
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:202,
        input23y: valueep72, input23v: valueep82 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:203,
        input23y: valueep73, input23v: valueep83 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:204,
        input23y: valueep74, input23v: valueep84 },
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:205,
        input23y: valueep75, input23v: valueep85 },
    ],
    epYeartable24: [
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:201,
        input24y: valueep91, input24v: valueep101 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:202,
        input24y: valueep92, input24v: valueep102 },
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:203,
        input24y: valueep93, input24v: valueep103 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:204,
        input24y: valueep94, input24v: valueep104 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:205,
        input24y: valueep95, input24v: valueep105 },
    ],
    epYeartable31: [
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:201,
        input31y: valueep111, input31v: valueep121 },
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:202,
        input31y: valueep112, input31v: valueep122 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:203,
        input31y: valueep113, input31v: valueep123 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:204,
        input31y: valueep114, input31v: valueep124 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:205,
        input31y: valueep115, input31v: valueep125 },
    ],
    epYeartable32: [
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:201,
        input32y: valueep131, input32v: valueep141 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:202,
        input32y: valueep132, input32v: valueep142 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:203,
        input32y: valueep133, input32v: valueep143 },
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:204,
        input32y: valueep134, input32v: valueep144 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:205,
        input32y: valueep135, input32v: valueep145 },
    ],
    epYeartable33: [
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:201,
        input33y: valueep151, input33v: valueep161 },
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:202,
        input33y: valueep152, input33v: valueep162 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:203,
        input33y: valueep153, input33v: valueep163 },
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:204,
        input33y: valueep154, input33v: valueep164 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:205,
        input33y: valueep155, input33v: valueep165 },
    ],
    epYeartable41: [
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:201,
        input41y: valueep171, input41v: valueep181 },
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:202,
        input41y: valueep172, input41v: valueep182 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:203,
        input41y: valueep173, input41v: valueep183 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:204,
        input41y: valueep174, input41v: valueep184 },
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:205,
        input41y: valueep175, input41v: valueep185 },
    ],
    epYeartable42: [
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:201,
        input42y: valueep191, input42v: valueep201 },
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:202,
        input42y: valueep192, input42v: valueep202 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:203,
        input42y: valueep193, input42v: valueep203 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:204,
        input42y: valueep194, input42v: valueep204 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:205,
        input42y: valueep195, input42v: valueep205 },
    ],
    epYeartable45: [
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:201,
        input45y: valueep211, input45v: valueep221 },
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:202,
        input45y: valueep212, input45v: valueep222 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:203,
        input45y: valueep213, input45v: valueep223 },
      { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:204,
        input45y: valueep214, input45v: valueep224 },
      {
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

         uniqueKey1:205,
        input45y: valueep215, input45v: valueep225 },
    ],
  };
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const extendedData = new FormData();
    console.log(JSON.stringify(inputDataList));
    extendedData.append("extendedProfile", jsonBlob(inputDataList));

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: extendedData,
    };
    fetch(resources.APPLICATION_URL+"extendeddata", filesFetchMethod).then(
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
      <h1 className="main-heading-style">
        Extended Profile of the Autonomous College
      </h1>
      <div className="eachTable-container">
        <form>
          <label className="extended-profile">1. Programme:</label>
          <p htmlFor="11" style={{ margin: "1%" }}>
            1.1. Number of programmes offered year wise for last five years?{" "}
          </p>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="number"
                  id="ep11" value={valueep11}
                  onChange={(e) => setValueep11(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep12" value={valueep12}
                  onChange={(e) => setValueep12(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep13" value={valueep13}
                  onChange={(e) => setValueep13(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep14" value={valueep14}
                  onChange={(e) => setValueep14(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep15" value={valueep15}
                  onChange={(e) => setValueep15(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="number"
                  id="ep21" value={valueep21}
                  onChange={(e) => setValueep21(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep22" value={valueep22}
                  onChange={(e) => setValueep22(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep23" value={valueep23}
                  onChange={(e) => setValueep23(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep24" value={valueep24}
                  onChange={(e) => setValueep24(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep25" value={valueep25}
                  onChange={(e) => setValueep25(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label className="extended-profile">2. Student:</label>
          <p htmlFor="21" style={{ margin: "1%" }}>
            2.1. Number of students year wise during last five years
          </p>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="number"
                  id="ep31" value={valueep31}
                  onChange={(e) => setValueep31(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep32" value={valueep32}
                  onChange={(e) => setValueep32(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep33" value={valueep33}
                  onChange={(e) => setValueep33(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep34" value={valueep34}
                  onChange={(e) => setValueep34(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep35" value={valueep35}
                  onChange={(e) => setValueep35(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="number"
                  id="ep41" value={valueep41}
                  onChange={(e) => setValueep41(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep42" value={valueep42}
                  onChange={(e) => setValueep42(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep43" value={valueep43}
                  onChange={(e) => setValueep43(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep44" value={valueep44}
                  onChange={(e) => setValueep44(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep45" value={valueep45}
                  onChange={(e) => setValueep45(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
        <label htmlFor="22" style={{ margin: "1%" }}>
          2.2. Number of outgoing/ final year students year wise during last
          five years
        </label>
        <table>
          <tr>
            <th style={{ width: "12%" }}>Year</th>
            <td>
              <input
                type="number"
                id="ep51" value={valueep51}
                onChange={(e) => setValueep51(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep52" value={valueep52}
                onChange={(e) => setValueep52(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep53" value={valueep53}
                onChange={(e) => setValueep53(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep54" value={valueep54}
                onChange={(e) => setValueep54(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep55" value={valueep55}
                onChange={(e) => setValueep55(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th style={{ width: "12%" }}>Number</th>
            <td>
              <input
                type="number"
                id="ep61" value={valueep61}
                onChange={(e) => setValueep61(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep62" value={valueep62}
                onChange={(e) => setValueep62(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep63" value={valueep63}
                onChange={(e) => setValueep63(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep64" value={valueep64}
                onChange={(e) => setValueep64(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep65" value={valueep65}
                onChange={(e) => setValueep65(e.target.value)}
              />
            </td>
          </tr>
        </table>

        <label htmlFor="23" style={{ margin: "1%" }}>
          2.3. Number of students appeared in the examination conducted by the
          Institution, year wise during the last five years
        </label>
        <table>
          <tr>
            <th style={{ width: "12%" }}>Year</th>
            <td>
              <input
                type="number"
                id="ep71" value={valueep71}
                onChange={(e) => setValueep71(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep72" value={valueep72}
                onChange={(e) => setValueep72(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep73" value={valueep73}
                onChange={(e) => setValueep73(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep74" value={valueep74}
                onChange={(e) => setValueep74(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep75" value={valueep75}
                onChange={(e) => setValueep75(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th style={{ width: "12%" }}>Number</th>
            <td>
              <input
                type="number"
                id="ep81" value={valueep81}
                onChange={(e) => setValueep81(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep82" value={valueep82}
                onChange={(e) => setValueep82(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep83" value={valueep83}
                onChange={(e) => setValueep83(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep84" value={valueep84}
                onChange={(e) => setValueep84(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep85" value={valueep85}
                onChange={(e) => setValueep85(e.target.value)}
              />
            </td>
          </tr>
        </table>
        <label htmlFor="24" style={{ margin: "1%" }}>
          2.4. Number of revaluation applications year wise during last five
          years
        </label>
        <table>
          <tr>
            <th style={{ width: "12%" }}>Year</th>
            <td>
              <input
                type="number" value={valueep91}
                id="ep91"
                onChange={(e) => setValueep91(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number" value={valueep92}
                id="ep92"
                onChange={(e) => setValueep92(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep93" value={valueep93}
                onChange={(e) => setValueep93(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep94" value={valueep94}
                onChange={(e) => setValueep94(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep95" value={valueep95}
                onChange={(e) => setValueep95(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th style={{ width: "12%" }}>Number</th>
            <td>
              <input
                type="number"
                id="ep101" value={valueep101}
                onChange={(e) => setValueep101(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep102" value={valueep102}
                onChange={(e) => setValueep102(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep103" value={valueep103}
                onChange={(e) => setValueep103(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep104" value={valueep104}
                onChange={(e) => setValueep104(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep105" value={valueep105}
                onChange={(e) => setValueep105(e.target.value)}
              />
            </td>
          </tr>
        </table>
      </div>
      <div className="eachTable-container">
        <form>
          <label className="extended-profile">3. Academic</label>
          <p htmlFor="31" style={{ margin: "1%" }}>
            3.1. Number of courses in all programs year wise during last five
            years{" "}
          </p>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="number"
                  id="ep111" value={valueep111}
                  onChange={(e) => setValueep111(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep112" value={valueep112}
                  onChange={(e) => setValueep112(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep113" value={valueep113}
                  onChange={(e) => setValueep113(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep114" value={valueep114}
                  onChange={(e) => setValueep114(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep115" value={valueep115}
                  onChange={(e) => setValueep115(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="number"
                  id="ep121" value={valueep121}
                  onChange={(e) => setValueep121(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep122" value={valueep122}
                  onChange={(e) => setValueep122(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep123" value={valueep123}
                  onChange={(e) => setValueep123(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep124" value={valueep124}
                  onChange={(e) => setValueep124(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep125" value={valueep125}
                  onChange={(e) => setValueep125(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <label htmlFor="32" style={{ margin: "1%" }}>
            3.2. Number of fulltime teachers year wise during the last five
            years{" "}
          </label>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="number"
                  id="ep131" value={valueep131}
                  onChange={(e) => setValueep131(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep132" value={valueep132}
                  onChange={(e) => setValueep132(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep133" value={valueep133}
                  onChange={(e) => setValueep133(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep134" value={valueep134}
                  onChange={(e) => setValueep134(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep135" value={valueep135}
                  onChange={(e) => setValueep135(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="number"
                  id="ep141" value={valueep141}
                  onChange={(e) => setValueep141(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep142" value={valueep142}
                  onChange={(e) => setValueep142(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep143" value={valueep143}
                  onChange={(e) => setValueep143(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep144" value={valueep144}
                  onChange={(e) => setValueep144(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep145" value={valueep145}
                  onChange={(e) => setValueep145(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <label htmlFor="33" style={{ margin: "1%" }}>
            3.3. Number of sanctioned posts year wise during last five years{" "}
          </label>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="number"
                  id="ep151" value={valueep151}
                  onChange={(e) => setValueep151(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep152" value={valueep152}
                  onChange={(e) => setValueep152(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep153" value={valueep153}
                  onChange={(e) => setValueep153(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep154" value={valueep154}
                  onChange={(e) => setValueep154(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep155" value={valueep155}
                  onChange={(e) => setValueep155(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="number"
                  id="ep161" value={valueep161}
                  onChange={(e) => setValueep161(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep162" value={valueep162}
                  onChange={(e) => setValueep162(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep163" value={valueep163}
                  onChange={(e) => setValueep163(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep164" value={valueep164}
                  onChange={(e) => setValueep164(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep165" value={valueep165}
                  onChange={(e) => setValueep165(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label className="extended-profile">4. Institution:</label>
          <p htmlFor="41" style={{ margin: "1%" }}>
            4.1. Number of eligible applications received for admissions to all
            the programs year wise during last five years{" "}
          </p>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="number"
                  id="ep171" value={valueep171}
                  onChange={(e) => setValueep171(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep172" value={valueep172}
                  onChange={(e) => setValueep172(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep173" value={valueep173}
                  onChange={(e) => setValueep173(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep174" value={valueep174}
                  onChange={(e) => setValueep174(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep175" value={valueep175}
                  onChange={(e) => setValueep175(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="number"
                  id="ep181" value={valueep181}
                  onChange={(e) => setValueep181(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep182" value={valueep182}
                  onChange={(e) => setValueep182(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep183" value={valueep183}
                  onChange={(e) => setValueep183(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep184" value={valueep184}
                  onChange={(e) => setValueep184(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep185" value={valueep185}
                  onChange={(e) => setValueep185(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <label htmlFor="42" style={{ margin: "1%" }}>
            4.2. Number of seats earmarked for reserved category as per
            GOI/State Govt rule year wise during last five years{" "}
          </label>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="number"
                  id="ep191" value={valueep191}
                  onChange={(e) => setValueep191(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep192" value={valueep192}
                  onChange={(e) => setValueep192(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep193" value={valueep193}
                  onChange={(e) => setValueep193(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep194" value={valueep194}
                  onChange={(e) => setValueep194(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep195" value={valueep195}
                  onChange={(e) => setValueep195(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="number"
                  id="ep201" value={valueep201}
                  onChange={(e) => setValueep201(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep202" value={valueep202}
                  onChange={(e) => setValueep202(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep203" value={valueep203}
                  onChange={(e) => setValueep203(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep204" value={valueep204}
                  onChange={(e) => setValueep204(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep205" value={valueep205}
                  onChange={(e) => setValueep205(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <p htmlFor="43" style={{ margin: "1%" }}>
            4.3. Total number of classrooms and seminar halls:
          
          <input
            type="number"
            id="43"
            onChange={(e) => setValue43(e.target.value)}
            style={{ width: "30%" , marginLeft:"18.1%"  }}
            className="input-43"
            value={value43}
          />
           </p>
          <p htmlFor="44" style={{ margin: "1%" }}>
            4.4. Total number of computers in the campus for academic purpose:
           <input
            type="number"
            id="44"
            onChange={(e) => setValue44(e.target.value)}
            style={{ width: "30%" , marginLeft:"8%" }}
            className="input-43"
            value={value44}
          />
           </p>
          <br />
          <label style={{ margin: "1%", paddingTop: "10px" }}>
            4.5. Total Expenditure excluding salary year wise during last five
            years (INR in Lakhs)
          </label>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="number"
                  id="ep211" value={valueep211}
                  onChange={(e) => setValueep211(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep212" value={valueep212}
                  onChange={(e) => setValueep212(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep213" value={valueep213}
                  onChange={(e) => setValueep213(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep214" value={valueep214}
                  onChange={(e) => setValueep214(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep215" value={valueep215}
                  onChange={(e) => setValueep215(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="number"
                  id="ep221" value={valueep221}
                  onChange={(e) => setValueep221(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep222" value={valueep222}
                  onChange={(e) => setValueep222(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep223" value={valueep223}
                  onChange={(e) => setValueep223(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep224" value={valueep224}
                  onChange={(e) => setValueep224(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep225" value={valueep225}
                  onChange={(e) => setValueep225(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="c11x-button-container">
        <button onClick={onClickingSave} className="c11x-button-style" style={{marginBottom : "3%"}}>
          Modify
        </button>
      </div>
    </div>
  );
}
export default ExtendedProfile;
