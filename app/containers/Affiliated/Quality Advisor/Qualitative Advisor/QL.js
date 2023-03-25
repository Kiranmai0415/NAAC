import React, { useState } from "react";
import { toast } from "react-toastify";
import { resources } from "../../../appConstants";
import AuthService from "../../../Pages/Users/services/auth.service";
import './QL-style.css';

// Alert custom messages start
const successMessage = (message) => {
  toast.success(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "success1",
  });
};
const errorMessage = (message) => {
  toast.error(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "error1",
  });
};
// End here

const grades = [
  { id: "GRADE1", grade: "0" },
  { id: "GRADE2", grade: "1" },
  { id: "GRADE3", grade: "2" },
  { id: "GRADE4", grade: "3" },
  { id: "GRADE5", grade: "4" },
];

function QL() {
  const [qlCommentBox, setQlCommentBox] = useState("");
  // Criteria 11
  const [dataValue111, setDataValue111] = useState("");
  const [dataValueGrade111, setDataValueGrade111] = useState();

  // Criteria 13
  const [dataValue131, setDataValue131] = useState("");
  const [dataValueGrade131, setDataValueGrade131] = useState();

  // Criteria 23
  const [dataValue231, setDataValue231] = useState("");
  const [dataValueGrade231, setDataValueGrade231] = useState();

  // Criteria 25
  const [dataValue251, setDataValue251] = useState("");
  const [dataValueGrade251, setDataValueGrade251] = useState();

  // Criteria 26
  const [dataValue261, setDataValue261] = useState("");
  const [dataValueGrade261, setDataValueGrade261] = useState();

  // Criteria 32
  const [dataValue321, setDataValue321] = useState("");
  const [dataValueGrade321, setDataValueGrade321] = useState();

  // Criteria 34
  const [dataValue341, setDataValue341] = useState("");
  const [dataValueGrade341, setDataValueGrade341] = useState();
  const [dataValue342, setDataValue342] = useState("");
  const [dataValueGrade342, setDataValueGrade342] = useState();

  // Criteria 41
  const [dataValue411, setDataValue411] = useState("");
  const [dataValueGrade411, setDataValueGrade411] = useState();

  // Criteria 42
  const [dataValue421, setDataValue421] = useState("");
  const [dataValueGrade421, setDataValueGrade421] = useState();

  // Criteria 43
  const [dataValue431, setDataValue431] = useState("");
  const [dataValueGrade431, setDataValueGrade431] = useState();

  // Criteria 54
  const [dataValue541, setDataValue541] = useState("");
  const [dataValueGrade541, setDataValueGrade541] = useState();

  // Criteria 61
  const [dataValue611, setDataValue611] = useState("");
  const [dataValueGrade611, setDataValueGrade611] = useState();

  // Criteria 62
  const [dataValue621, setDataValue621] = useState("");
  const [dataValueGrade621, setDataValueGrade621] = useState();

  // Criteria 63
  const [dataValue631, setDataValue631] = useState("");
  const [dataValueGrade631, setDataValueGrade631] = useState();

  // Criteria 64
  const [dataValue641, setDataValue641] = useState("");
  const [dataValueGrade641, setDataValueGrade641] = useState();

  // Criteria 65
  const [dataValue651, setDataValue651] = useState("");
  const [dataValueGrade651, setDataValueGrade651] = useState();

  // Criteria 71
  const [dataValue711, setDataValue711] = useState("");
  const [dataValueGrade711, setDataValueGrade711] = useState();
  const [dataValue714, setDataValue714] = useState("");
  const [dataValueGrade714, setDataValueGrade714] = useState();

  // Criteria 72
  const [dataValue721, setDataValue721] = useState("");
  const [dataValueGrade721, setDataValueGrade721] = useState();

  // Criteria 73
  const [dataValue731, setDataValue731] = useState("");
  const [dataValueGrade731, setDataValueGrade731] = useState();

  const qlweightage111 = 20;
  const qlkiWeightage11 = 20;
  const qlweightage131 = 10;
  const qlkiWeightage13 = 10;
  const qlcriteria1 = 30;

  const qlweightage231 = 40;
  const qlkiWeightage23 = 40;
  const qlweightage251 = 40;
  const qlkiWeightage25 = 40;
  const qlweightage261 = 45;
  const qlkiWeightage26 = 45;
  const qlcriteria2 = 125;

  const qlweightage321 = 10;
  const qlkiWeightage32 = 10;
  const qlweightage341 = 10;
  const qlweightage342 = 10;
  const qlkiWeightage34 = 20;
  const qlcriteria3 = 30;

  const qlweightage411 = 20;
  const qlkiWeightage41 = 20;
  const qlweightage421 = 20;
  const qlkiWeightage42 = 20;
  const qlweightage431 = 20;
  const qlkiWeightage43 = 20;
  const qlcriteria4 = 60;

  const qlweightage541 = 10;
  const qlkiWeightage54 = 10;
  const qlcriteria5 = 10;

  const qlweightage611 = 10;
  const qlkiWeightage61 = 10;
  const qlweightage621 = 6;
  const qlkiWeightage62 = 6;
  const qlweightage631 = 8;
  const qlkiWeightage63 = 8;
  const qlweightage641 = 15;
  const qlkiWeightage64 = 15;
  const qlweightage651 = 15;
  const qlkiWeightage65 = 15;
  const qlcriteria6 = 54;

  const qlweightage711 = 10;
  const qlweightage714 = 10;
  const qlkiWeightage71 = 20;
  const qlweightage721 = 30;
  const qlkiWeightage72 = 30;
  const qlweightage731 = 20;
  const qlkiWeightage73 = 20;
  const qlcriteria7 = 60;

  const grades = [
    { id: "GRADE1", grade: "0" },
    { id: "GRADE2", grade: "1" },
    { id: "GRADE3", grade: "2" },
    { id: "GRADE4", grade: "3" },
    { id: "GRADE5", grade: "4" },
  ];

  function metricGradeScale(dataValue) {
    if (dataValue <= 0) {
      return 0;
    }
    if (dataValue <= 1) {
      return 1;
    }
    if (dataValue <= 2) {
      return 2;
    }
    if (dataValue <= 3) {
      return 3;
    }
    if (dataValue <= 4) {
      return 4;
    }
    return "";
  }
  function qlcriteria1Value() {
    return (
      qlweightage111 * metricGradeScale(dataValueGrade111)
      + qlweightage131 * metricGradeScale(dataValueGrade131)
    );
  }
  function qlcriteria2Value() {
    return (
      qlweightage231 * metricGradeScale(dataValueGrade231)
      + qlweightage251 * metricGradeScale(dataValueGrade251)
      + qlweightage261 * metricGradeScale(dataValueGrade261)
    );
  }
  function qlcriteria3Value() {
    return (
      qlweightage321 * metricGradeScale(dataValueGrade321)
       + qlweightage341 * metricGradeScale(dataValueGrade341)
       + qlweightage342 * metricGradeScale(dataValueGrade342)
    );
  }
  function qlcriteria4Value() {
    return (
      qlweightage411 * metricGradeScale(dataValueGrade411)
       + qlweightage421 * metricGradeScale(dataValueGrade421)
       + qlweightage431 * metricGradeScale(dataValueGrade431)
    );
  }
  function qlcriteria5Value() {
    return (
      qlweightage541 * metricGradeScale(dataValueGrade541)
    );
  }
  function qlcriteria6Value() {
    return (
      qlweightage611 * metricGradeScale(dataValueGrade611)
      + qlweightage621 * metricGradeScale(dataValueGrade621)
      + qlweightage631 * metricGradeScale(dataValueGrade631)
      + qlweightage641 * metricGradeScale(dataValueGrade641)
      + qlweightage651 * metricGradeScale(dataValueGrade651)
    );
  }
  function qlcriteria7Value() {
    return (
      qlweightage711 * metricGradeScale(dataValueGrade711)
      + qlweightage714 * metricGradeScale(dataValueGrade714)
      + qlweightage721 * metricGradeScale(dataValueGrade721)
      + qlweightage731 * metricGradeScale(dataValueGrade731)

    );
  }

  const criteriaQl1Weightage = qlcriteria1Value();
  const criteriaQl1Grade = parseFloat(criteriaQl1Weightage / qlcriteria1).toFixed(2);
  const criteriaQl11Value = qlweightage111 * metricGradeScale(dataValueGrade111);
  const criteriaQl13Value = qlweightage131 * metricGradeScale(dataValueGrade131);

  const criteriaQl2Weightage = qlcriteria2Value();
  const criteriaQl2Grade = parseFloat(criteriaQl2Weightage / qlcriteria1).toFixed(2);
  const criteriaQl23Value = (qlweightage231 * metricGradeScale(dataValueGrade231));
  const criteriaQl25Value = (qlweightage251 * metricGradeScale(dataValueGrade251));
  const criteriaQl26Value = (qlweightage261 * metricGradeScale(dataValueGrade261));

  const criteriaQl3Weightage = qlcriteria3Value();
  const criteriaQl3Grade = parseFloat(criteriaQl3Weightage / qlcriteria3).toFixed(2);
  const criteriaQl32Value = (qlweightage321 * metricGradeScale(dataValueGrade321));
  const criteriaQl34Value = (qlweightage341 * metricGradeScale(dataValueGrade341) + qlweightage342 * metricGradeScale(dataValueGrade342));

  const criteriaQl4Weightage = qlcriteria4Value();
  const criteriaQl4Grade = parseFloat(criteriaQl4Weightage / qlcriteria4).toFixed(2);
  const criteriaQl41Value = (qlweightage411 * metricGradeScale(dataValueGrade411));
  const criteriaQl42Value = (qlweightage421 * metricGradeScale(dataValueGrade421));
  const criteriaQl43Value = (qlweightage431 * metricGradeScale(dataValueGrade431));

  const criteriaQl5Weightage = qlcriteria5Value();
  const criteriaQl5Grade = parseFloat(criteriaQl5Weightage / qlcriteria5).toFixed(2);
  const criteriaQl54Value = (qlweightage541 * metricGradeScale(dataValueGrade541));

  const criteriaQl6Weightage = qlcriteria6Value();
  const criteriaQl6Grade = parseFloat(criteriaQl6Weightage / qlcriteria6).toFixed(2);
  const criteriaQl61Value = (qlweightage611 * metricGradeScale(dataValueGrade611));
  const criteriaQl62Value = (qlweightage621 * metricGradeScale(dataValueGrade621));
  const criteriaQl63Value = (qlweightage631 * metricGradeScale(dataValueGrade631));
  const criteriaQl64Value = (qlweightage641 * metricGradeScale(dataValueGrade641));
  const criteriaQl65Value = (qlweightage651 * metricGradeScale(dataValueGrade651));

  const criteriaQl7Weightage = qlcriteria7Value();
  const criteriaQl7Grade = parseFloat(criteriaQl7Weightage / qlcriteria7).toFixed(2);
  const criteriaQl71Value = (qlweightage711 * metricGradeScale(dataValueGrade711) + qlweightage714 * metricGradeScale(dataValueGrade714));
  const criteriaQl72Value = (qlweightage721 * metricGradeScale(dataValueGrade721));
  const criteriaQl73Value = (qlweightage731 * metricGradeScale(dataValueGrade731));

  console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
  let instituteType = AuthService.getCurrentUser().instituteType;
  const collegeId = AuthService.getCurrentUser().collegeId;
  const d = new Date();
  let currYear = d.getFullYear();
  let fYear = parseInt(currYear,10) - 1 + "-" + currYear;
  console.log("current year==" + fYear);
  
  const inputDataList = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    qlit8: qlCommentBox,
    qualitativeCriterionWiseList: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 101,
        criterionName: "criteria1",
        naacWeighted: qlcriteria1,
        criterionWiseWeighted: criteriaQl1Weightage,
        criterionWiseGrade: criteriaQl1Grade,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 102,
        criterionName: "criteria2",
        naacWeighted: qlcriteria2,
        criterionWiseWeighted: criteriaQl2Weightage,
        criterionWiseGrade: criteriaQl2Grade,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 103,
        criterionName: "criteria3",
        naacWeighted: qlcriteria3,
        criterionWiseWeighted: criteriaQl3Weightage,
        criterionWiseGrade: criteriaQl3Grade,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 104,
        criterionName: "criteria4",
        naacWeighted: qlcriteria4,
        criterionWiseWeighted: criteriaQl4Weightage,
        criterionWiseGrade: criteriaQl4Grade,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 105,
        criterionName: "criteria5",
        naacWeighted: qlcriteria5,
        criterionWiseWeighted: criteriaQl5Weightage,
        criterionWiseGrade: criteriaQl5Grade,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 106,
        criterionName: "criteria6",
        naacWeighted: qlcriteria6,
        criterionWiseWeighted: criteriaQl6Weightage,
        criterionWiseGrade: criteriaQl6Grade,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 107,
        criterionName: "criteria7",
        naacWeighted: qlcriteria7,
        criterionWiseWeighted: criteriaQl7Weightage,
        criterionWiseGrade: criteriaQl7Grade,
      },
    ],
    qualitative: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:101,
        qlit7: dataValue111,
        qlit6: "" + dataValueGrade111,
        qlit5: "" + qlweightage111 * metricGradeScale(dataValueGrade111),
        qlit4: parseFloat(criteriaQl11Value / qlkiWeightage11).toFixed(2),
        qlit3: criteriaQl1Grade,
        qlit2: "" + criteriaQl1Weightage,
        qlit1: "" + criteriaQl11Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:102,
        qlit7: dataValue131,
        qlit6: "" + dataValueGrade131,
        qlit5: "" + qlweightage131 * metricGradeScale(dataValueGrade131),
        qlit4: parseFloat(criteriaQl13Value / qlkiWeightage13).toFixed(2),
        qlit3: criteriaQl1Grade,
        qlit2: "" + criteriaQl1Weightage,
        qlit1: "" + criteriaQl13Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:103,
        qlit7: dataValue231,
        qlit6: "" + dataValueGrade231,
        qlit5: "" + qlweightage231 * metricGradeScale(dataValueGrade231),
        qlit4: parseFloat(criteriaQl23Value / qlkiWeightage23).toFixed(2),
        qlit3: criteriaQl2Grade,
        qlit2: "" + criteriaQl2Weightage,
        qlit1: "" + criteriaQl23Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:104,
        qlit7: dataValue251,
        qlit6: "" + dataValueGrade251,
        qlit5: "" + qlweightage251 * metricGradeScale(dataValueGrade251),
        qlit4: parseFloat(criteriaQl25Value / qlkiWeightage25).toFixed(2),
        qlit3: criteriaQl2Grade,
        qlit2: "" + criteriaQl2Weightage,
        qlit1: "" + criteriaQl25Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:105,
        qlit7: dataValue261,
        qlit6: "" + dataValueGrade261,
        qlit5: "" + qlweightage261 * metricGradeScale(dataValueGrade261),
        qlit4: parseFloat(criteriaQl26Value / qlkiWeightage26).toFixed(2),
        qlit3: criteriaQl2Grade,
        qlit2: "" + criteriaQl2Weightage,
        qlit1: "" + criteriaQl26Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:106,
        qlit7: dataValue321,
        qlit6: "" + dataValueGrade321,
        qlit5: "" + qlweightage321 * metricGradeScale(dataValueGrade321),
        qlit4: parseFloat(criteriaQl32Value / qlkiWeightage32).toFixed(2),
        qlit3: criteriaQl3Grade,
        qlit2: "" + criteriaQl3Weightage,
        qlit1: "" + criteriaQl32Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:107,
        qlit7: dataValue341,
        qlit6: "" + dataValueGrade341,
        qlit5: "" + qlweightage341 * metricGradeScale(dataValueGrade341),
        qlit4: parseFloat(criteriaQl34Value / qlkiWeightage34).toFixed(2),
        qlit3: criteriaQl3Grade,
        qlit2: "" + criteriaQl3Weightage,
        qlit1: "" + criteriaQl34Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:108,
        qlit7: dataValue342,
        qlit6: "" + dataValueGrade342,
        qlit5: "" + qlweightage342 * metricGradeScale(dataValueGrade342),
        qlit4: parseFloat(criteriaQl34Value / qlkiWeightage34).toFixed(2),
        qlit3: criteriaQl3Grade,
        qlit2: "" + criteriaQl3Weightage,
        qlit1: "" + criteriaQl34Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:109,
        qlit7: dataValue411,
        qlit6: "" + dataValueGrade411,
        qlit5: "" + qlweightage411 * metricGradeScale(dataValueGrade411),
        qlit4: parseFloat(criteriaQl41Value / qlkiWeightage41).toFixed(2),
        qlit3: criteriaQl4Grade,
        qlit2: "" + criteriaQl4Weightage,
        qlit1: "" + criteriaQl41Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:110,
        qlit7: dataValue421,
        qlit6: "" + dataValueGrade421,
        qlit5: "" + qlweightage421 * metricGradeScale(dataValueGrade421),
        qlit4: parseFloat(criteriaQl42Value / qlkiWeightage42).toFixed(2),
        qlit3: criteriaQl4Grade,
        qlit2: "" + criteriaQl4Weightage,
        qlit1: "" + criteriaQl42Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:111,
        qlit7: dataValue431,
        qlit6: "" + dataValueGrade431,
        qlit5: "" + qlweightage431 * metricGradeScale(dataValueGrade431),
        qlit4: parseFloat(criteriaQl43Value / qlkiWeightage43).toFixed(2),
        qlit3: criteriaQl4Grade,
        qlit2: "" + criteriaQl4Weightage,
        qlit1: "" + criteriaQl43Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:112,
        qlit7: dataValue541,
        qlit6: "" + dataValueGrade541,
        qlit5: "" + qlweightage541 * metricGradeScale(dataValueGrade541),
        qlit4: parseFloat(criteriaQl54Value / qlkiWeightage54).toFixed(2),
        qlit3: criteriaQl5Grade,
        qlit2: "" + criteriaQl5Weightage,
        qlit1: "" + criteriaQl54Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:113,
        qlit7: dataValue611,
        qlit6: "" + dataValueGrade611,
        qlit5: "" + qlweightage611 * metricGradeScale(dataValueGrade611),
        qlit4: parseFloat(criteriaQl61Value / qlkiWeightage61).toFixed(2),
        qlit3: criteriaQl6Grade,
        qlit2: "" + criteriaQl6Weightage,
        qlit1: "" + criteriaQl61Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:114,
        qlit7: dataValue621,
        qlit6: "" + dataValueGrade621,
        qlit5: "" + qlweightage621 * metricGradeScale(dataValueGrade621),
        qlit4: parseFloat(criteriaQl62Value / qlkiWeightage62).toFixed(2),
        qlit3: criteriaQl6Grade,
        qlit2: "" + criteriaQl6Weightage,
        qlit1: "" + criteriaQl62Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:115,
        qlit7: dataValue631,
        qlit6: "" + dataValueGrade631,
        qlit5: "" + qlweightage631 * metricGradeScale(dataValueGrade631),
        qlit4: parseFloat(criteriaQl63Value / qlkiWeightage63).toFixed(2),
        qlit3: criteriaQl6Grade,
        qlit2: "" + criteriaQl6Weightage,
        qlit1: "" + criteriaQl63Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:116,
        qlit7: dataValue641,
        qlit6: "" + dataValueGrade641,
        qlit5: "" + qlweightage641 * metricGradeScale(dataValueGrade641),
        qlit4: parseFloat(criteriaQl64Value / qlkiWeightage64).toFixed(2),
        qlit3: criteriaQl6Grade,
        qlit2: "" + criteriaQl6Weightage,
        qlit1: "" + criteriaQl64Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:117,
        qlit7: dataValue651,
        qlit6: "" + dataValueGrade651,
        qlit5: "" + qlweightage651 * metricGradeScale(dataValueGrade651),
        qlit4: parseFloat(criteriaQl65Value / qlkiWeightage65).toFixed(2),
        qlit3: criteriaQl6Grade,
        qlit2: "" + criteriaQl6Weightage,
        qlit1: "" + criteriaQl65Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:118,
        qlit7: dataValue711,
        qlit6: "" + dataValueGrade711,
        qlit5: "" + qlweightage711 * metricGradeScale(dataValueGrade711),
        qlit4: parseFloat(criteriaQl71Value / qlkiWeightage71).toFixed(2),
        qlit3: criteriaQl7Grade,
        qlit2: "" + criteriaQl7Weightage,
        qlit1: "" + criteriaQl71Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:119,
        qlit7: dataValue714,
        qlit6: "" + dataValueGrade714,
        qlit5: "" + qlweightage714 * metricGradeScale(dataValueGrade714),
        qlit4: parseFloat(criteriaQl71Value / qlkiWeightage71).toFixed(2),
        qlit3: criteriaQl7Grade,
        qlit2: "" + criteriaQl7Weightage,
        qlit1: "" + criteriaQl71Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:120,
        qlit7: dataValue721,
        qlit6: "" + dataValueGrade721,
        qlit5: "" + qlweightage721 * metricGradeScale(dataValueGrade721),
        qlit4: parseFloat(criteriaQl72Value / qlkiWeightage72).toFixed(2),
        qlit3: criteriaQl7Grade,
        qlit2: "" + criteriaQl7Weightage,
        qlit1: "" + criteriaQl72Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1:121,
        qlit7: dataValue731,
        qlit6: "" + dataValueGrade731,
        qlit5: "" + qlweightage731 * metricGradeScale(dataValueGrade731),
        qlit4: parseFloat(criteriaQl73Value / qlkiWeightage73).toFixed(2),
        qlit3: criteriaQl7Grade,
        qlit2: "" + criteriaQl7Weightage,
        qlit1: "" + criteriaQl73Value,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    if (dataValue111 !== ""
       && dataValue131 !== ""
       && dataValue231 !== ""
       && dataValue251 !== ""
       && dataValue261 !== ""
       && dataValue321 !== ""
       && dataValue341 !== ""
       && dataValue342 !== ""
       && dataValue411 !== ""
       && dataValue421 !== ""
       && dataValue431 !== ""
       && dataValue541 !== ""
       && dataValue611 !== ""
       && dataValue621 !== ""
       && dataValue631 !== ""
       && dataValue641 !== ""
       && dataValue651 !== ""
       && dataValue711 !== ""
       && dataValue721 !== ""
       && dataValue731 !== ""
       && dataValueGrade111 !== ""
       && dataValueGrade131 !== ""
       && dataValueGrade231 !== ""
       && dataValueGrade251 !== ""
       && dataValueGrade261 !== ""
       && dataValueGrade321 !== ""
       && dataValueGrade341 !== ""
       && dataValueGrade342 !== ""
       && dataValueGrade411 !== ""
       && dataValueGrade421 !== ""
       && dataValueGrade431 !== ""
       && dataValueGrade541 !== ""
       && dataValueGrade611 !== ""
       && dataValueGrade621 !== ""
       && dataValueGrade631 !== ""
       && dataValueGrade641 !== ""
       && dataValueGrade651 !== ""
       && dataValueGrade711 !== ""
       && dataValueGrade714 !== ""
       && dataValueGrade721 !== ""
       && dataValueGrade731 !== ""
    ) {
      console.log("insert data is =>" + JSON.stringify(inputDataList));
      const qlData = new FormData();
      qlData.append("qualitativeQuantitativeInfo", jsonBlob(inputDataList));
      const filesFetchMethod = {
        method: "POST",
        headers: { Accept: "application/json ,text/plain" },
        authorization:
          "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
        body: qlData,
      };
      fetch(
        resources.APPLICATION_URL+"saveQualitativeQuantitaveData",
        filesFetchMethod
      ).then((response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Record is Inserted Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      });
    } else {
      alert("Input fields are empty");
    }
  }

  return (
    <div className="main-container">
      <div className="eachTable-container">
        <table>
        <tr style={{ textAlign: "center",  }}>
              <th style={{ width: "10px", fontFamily: "sans-serif", fontSize: "medium" }}>S.No</th>
              <th style={{ width: "10px", fontFamily: "sans-serif", fontSize: "medium"  }}>Metric No.</th>
              <th style={{ width: "10px", fontFamily: "sans-serif", fontSize: "medium"  }}>Quality</th>
              <th style={{ width: "200px", fontFamily: "sans-serif", fontSize: "medium"  }}>Description</th>
              <th style={{ width: "30px", fontFamily: "sans-serif", fontSize: "medium"  }}>Weight</th>
              <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>Key Indicator(W)</th>
              <th style={{ width: "80px", fontFamily: "sans-serif", fontSize: "medium"  }}>Criteria(W)</th>
              <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium"  }}>
                {/* ADVV - 2 (Adiverse data validation) Response */}
                ADVV - 2
              </th>
              <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>Metric Grade scale (0-4)</th>
              <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>
               {/* Metric wise weighted Grade points */}
               Metric weighted Grade
              </th>
              <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>KI wise Weighted Grade</th>
              <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>KI wise Grade Point Average</th>
              <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>Criteria (W)</th>
              <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>
                {/* Criteria wise Grade Point Average */}
              Criteria Grade
              </th>
            </tr>
          <tr>
            <td>1.</td>
            <td>1.1.1</td>
            <td>QL</td>
            <td>
              The Institution ensures effective curriculum planning and delivery
              through a well-planned and documented process including Academic
              calendar and conduct of continuous internal Assessment
            </td>
            <td>{qlweightage111}</td>
            <td>{qlkiWeightage11}</td>
            <td rowspan="2">{qlcriteria1}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue111}
                onChange={(e) => {
                  setDataValue111(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade111'
                name={dataValueGrade111}
                onChange={(e) => { setDataValueGrade111(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage111 * metricGradeScale(dataValueGrade111)}</p>
            </td>
            <td>
              <p>{criteriaQl11Value}</p>
            </td>
            <td >
              <p>{parseFloat(criteriaQl11Value / qlkiWeightage11).toFixed(2)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQl1Weightage}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQl1Grade}</p>
            </td>
          </tr>
          <tr>
            <td>2.</td>
            <td>1.3.1</td>
            <td>QL</td>
            <td>
              Institution integrates crosscutting issues relevant to Professional
              Ethics, Gender, Human Values, Environment and Sustainability into
              the Curriculum
            </td>
            <td>{qlweightage131}</td>
            <td>{qlkiWeightage13}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue131}
                onChange={(e) => {
                  setDataValue131(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade131'
                name={dataValueGrade131}
                onChange={(e) => { setDataValueGrade131(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage131 * metricGradeScale(dataValueGrade131)}</p>
            </td>
            <td>
              {criteriaQl13Value}
            </td>
            <td>
              <p>{parseFloat(criteriaQl13Value / qlkiWeightage11).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>3.</td>
            <td>2.3.1</td>
            <td>QL</td>
            <td>
              Student centric methods, such as experiential learning, participative
              learning and problem solving methodologies are used for enhancing
              learning experiences using ICT tools
            </td>
            <td>{qlweightage231}</td>
            <td>{qlkiWeightage23}</td>
            <td rowspan="3">{qlcriteria2}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue231}
                onChange={(e) => {
                  setDataValue231(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade231'
                name={dataValueGrade231}
                onChange={(e) => { setDataValueGrade231(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage231 * metricGradeScale(dataValueGrade231)}</p>
            </td>
            <td>
              <p>{criteriaQl23Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl23Value / qlkiWeightage23).toFixed(2)}</p>
            </td>
            <td rowSpan="3">
              <p>{criteriaQl2Weightage}</p>
            </td>
            <td rowSpan="3">
              <p>{criteriaQl2Grade}</p>
            </td>
          </tr>
          <tr>
            <td>4.</td>
            <td>2.5.1</td>
            <td>QL</td>
            <td>
              Mechanism of internal/ external assessment is transparent and the
              grievance redressal system is time- bound and efficient
            </td>
            <td>{qlweightage251}</td>
            <td>{qlkiWeightage25}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue251}
                onChange={(e) => {
                  setDataValue251(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade251'
                name={dataValueGrade251}
                onChange={(e) => { setDataValueGrade251(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage251 * metricGradeScale(dataValueGrade251)}</p>
            </td>
            <td>
              <p>{criteriaQl25Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl25Value / qlkiWeightage25).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>5.</td>
            <td>2.6.1</td>
            <td>QL</td>
            <td>
              Programme Outcomes (POs) and Course Outcomes (COs) for all
              Programmes offered by the institution are stated and displayed on
              website and attainment of POs and COs are evaluated
            </td>
            <td>{qlweightage261}</td>
            <td>{qlkiWeightage26}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue261}
                onChange={(e) => {
                  setDataValue261(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade261'
                name={dataValueGrade261}
                onChange={(e) => { setDataValueGrade261(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage261 * metricGradeScale(dataValueGrade261)}</p>
            </td>
            <td>
              <p>{criteriaQl26Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl26Value / qlkiWeightage26).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>6.</td>
            <td>3.2.1</td>
            <td>QL</td>
            <td>
              Institution has created an ecosystem for innovations and has
              initiatives for creation and transfer of knowledge
              (patents filed, published, incubation center facilities in the HEI to be
              considered)
            </td>
            <td>{qlweightage321}</td>
            <td>{qlkiWeightage32}</td>
            <td rowspan="3">{qlcriteria3}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue321}
                onChange={(e) => {
                  setDataValue321(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade311'
                name={dataValueGrade321}
                onChange={(e) => { setDataValueGrade321(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage321 * metricGradeScale(dataValueGrade321)}</p>
            </td>
            <td>
              <p>{criteriaQl32Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl32Value / qlkiWeightage32).toFixed(2)}</p>
            </td>
            <td rowSpan="3">
              <p>{criteriaQl3Weightage}</p>
            </td>
            <td rowSpan="3">
              <p>{criteriaQl3Grade}</p>
            </td>
          </tr>
          <tr>
            <td>7.</td>
            <td>3.4.1</td>
            <td>QL</td>
            <td>
              Extension activities are carried out in the neighborhood
              community, sensitizing students to social issues, for their holistic
              development, and impact thereof during the last five years.
            </td>
            <td>{qlweightage341}</td>
            <td rowSpan="2">{qlkiWeightage34}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue341}
                onChange={(e) => {
                  setDataValue341(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade341'
                name={dataValueGrade341}
                onChange={(e) => { setDataValueGrade341(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage341 * metricGradeScale(dataValueGrade341)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQl34Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQl34Value / qlkiWeightage34).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>8.</td>
            <td>3.4.2</td>
            <td>QL</td>
            <td>
              Awards and recognitions received for extension activities from
              government / government recognised bodies
            </td>
            <td>{qlweightage342}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue342}
                onChange={(e) => {
                  setDataValue342(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade342'
                name={dataValueGrade342}
                onChange={(e) => { setDataValueGrade342(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage342 * metricGradeScale(dataValueGrade342)}</p>
            </td>
          </tr>
          <tr>
            <td>9.</td>
            <td>4.1.1</td>
            <td>QL</td>
            <td>
              Availability of adequate infrastructure and physical facilities viz.,
              classrooms, laboratories, ICT facilities, cultural activities,
              gymnasium, yoga centre etc. in the institution
            </td>
            <td>{qlweightage411}</td>
            <td>{qlkiWeightage41}</td>
            <td rowSpan="3">{qlcriteria4}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue411}
                onChange={(e) => {
                  setDataValue411(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade411'
                name={dataValueGrade411}
                onChange={(e) => { setDataValueGrade411(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage411 * metricGradeScale(dataValueGrade411)}</p>
            </td>
            <td>
              <p>{criteriaQl41Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl41Value / qlkiWeightage41).toFixed(2)}</p>
            </td>
            <td rowSpan="3">
              <p>{criteriaQl4Weightage}</p>
            </td>
            <td rowSpan="3">
              <p>{criteriaQl4Grade}</p>
            </td>
          </tr>
          <tr>
            <td>10.</td>
            <td>4.2.1</td>
            <td>QL</td>
            <td>
              Library is automated using Integrated Library Management
              System (ILMS), subscription to e-resources, amount spent on
              purchase of books, journals and per day usage of library
            </td>
            <td>{qlweightage421}</td>
            <td>{qlkiWeightage42}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue421}
                onChange={(e) => {
                  setDataValue421(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade421'
                name={dataValueGrade421}
                onChange={(e) => { setDataValueGrade421(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage421 * metricGradeScale(dataValueGrade421)}</p>
            </td>
            <td>
              <p>{criteriaQl42Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl42Value / qlkiWeightage42).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>11.</td>
            <td>4.3.1</td>
            <td>QL</td>
            <td>
              Institution frequently updates its IT facilities and provides
              sufficient bandwidth for internet connection
            </td>
            <td>{qlweightage431}</td>
            <td>{qlkiWeightage43}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue431}
                onChange={(e) => {
                  setDataValue431(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade431'
                name={dataValueGrade431}
                onChange={(e) => { setDataValueGrade431(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage431 * metricGradeScale(dataValueGrade431)}</p>
            </td>
            <td>
              <p>{criteriaQl43Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl43Value / qlkiWeightage43).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>12.</td>
            <td>5.4.1</td>
            <td>QL</td>
            <td>
              There is a registered Alumni Association that contributes significantly
              to the development of the institution through financial and/or other
              support services
            </td>
            <td>{qlweightage541}</td>
            <td>{qlkiWeightage54}</td>
            <td>{qlcriteria5}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue541}
                onChange={(e) => {
                  setDataValue541(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade541'
                name={dataValueGrade541}
                onChange={(e) => { setDataValueGrade541(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage541 * metricGradeScale(dataValueGrade541)}</p>
            </td>
            <td>
              <p>{criteriaQl54Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl54Value / qlkiWeightage54).toFixed(2)}</p>
            </td>
            <td>
              <p>{criteriaQl5Weightage}</p>
            </td>
            <td>
              <p>{criteriaQl5Grade}</p>
            </td>
          </tr>
          <tr>
            <td>13.</td>
            <td>6.1.1</td>
            <td>QL</td>
            <td>
              The governance and leadership is in accordance with vision and
              mission of the institution and it is visible in various institutional
              practices such as decentralization and participation in the
              institutional governance
            </td>
            <td>{qlweightage611}</td>
            <td>{qlkiWeightage61}</td>
            <td rowspan="5">{qlcriteria6}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue611}
                onChange={(e) => {
                  setDataValue611(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade611'
                name={dataValueGrade611}
                onChange={(e) => { setDataValueGrade611(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage611 * metricGradeScale(dataValueGrade611)}</p>
            </td>
            <td>
              <p>{criteriaQl61Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl61Value / qlkiWeightage61).toFixed(2)}</p>
            </td>
            <td rowSpan="5">
              <p>{criteriaQl6Weightage}</p>
            </td>
            <td rowSpan="5">
              <p>{criteriaQl6Grade}</p>
            </td>
          </tr>
          <tr>
            <td>14.</td>
            <td>6.2.1</td>
            <td>QL</td>
            <td>
              The functioning of the institutional bodies is effective and efficient
              as visible from policies, administrative setup, appointment and
              service rules, procedures, deployment of institutional Strategic/
              perspective/development plan etc
            </td>
            <td>{qlweightage621}</td>
            <td>{qlkiWeightage62}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue621}
                onChange={(e) => {
                  setDataValue621(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade621'
                name={dataValueGrade621}
                onChange={(e) => { setDataValueGrade621(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage621 * metricGradeScale(dataValueGrade621)}</p>
            </td>
            <td>
              <p>{criteriaQl62Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl62Value / qlkiWeightage62).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>15.</td>
            <td>6.3.1</td>
            <td>QL</td>
            <td>
              The institution has effective welfare measures and Performance
              Appraisal System for teaching and non-teaching staff
            </td>
            <td>{qlweightage631}</td>
            <td>{qlkiWeightage63}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue631}
                onChange={(e) => {
                  setDataValue631(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade631'
                name={dataValueGrade631}
                onChange={(e) => { setDataValueGrade631(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage631 * metricGradeScale(dataValueGrade631)}</p>
            </td>
            <td>
              <p>{criteriaQl63Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl63Value / qlkiWeightage63).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>16.</td>
            <td>6.4.1</td>
            <td>QL</td>
            <td>
              Institution has strategies for mobilization and optimal utilization of
              resources and funds from various sources (government/ non-government organizations) and it conducts financial audits
              regularly (internal and external)
            </td>
            <td>{qlweightage641}</td>
            <td>{qlkiWeightage64}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue641}
                onChange={(e) => {
                  setDataValue641(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade641'
                name={dataValueGrade641}
                onChange={(e) => { setDataValueGrade641(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage641 * metricGradeScale(dataValueGrade641)}</p>
            </td>
            <td>
              <p>{criteriaQl64Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl64Value / qlkiWeightage64).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>17.</td>
            <td>6.5.1</td>
            <td>QL</td>
            <td>
              Internal Quality Assurance Cell (IQAC) has contributed
              significantly for institutionalizing the quality assurance strategies
              and processes. It reviews teaching learning process, structures &
              methodologies of operations and learning outcomes at periodic
              intervals and records the incremental improvement in various
              activities
            </td>
            <td>{qlweightage651}</td>
            <td>{qlkiWeightage65}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue651}
                onChange={(e) => {
                  setDataValue651(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade651'
                name={dataValueGrade651}
                onChange={(e) => { setDataValueGrade651(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage651 * metricGradeScale(dataValueGrade651)}</p>
            </td>
            <td>
              <p>{criteriaQl65Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl65Value / qlkiWeightage65).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>18.</td>
            <td>7.1.1</td>
            <td>QL</td>
            <td>
              Measures initiated by the Institution for the promotion of gender
              equity and Institutional initiatives to celebrate / organize national
              and international commemorative days, events and festivals during
              the last five years
            </td>
            <td>{qlweightage711}</td>
            <td rowspan="2">{qlkiWeightage71}</td>
            <td rowspan="4">{qlcriteria7}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue711}
                onChange={(e) => {
                  setDataValue711(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade711'
                name={dataValueGrade711}
                onChange={(e) => { setDataValueGrade711(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage711 * metricGradeScale(dataValueGrade711)}</p>
            </td>
            <td rowspan="2">
              <p>{criteriaQl71Value}</p>
            </td>
            <td rowspan="2">
              <p>{parseFloat(criteriaQl71Value / qlkiWeightage71).toFixed(2)}</p>
            </td>
            <td rowSpan="4">
              <p>{criteriaQl7Weightage}</p>
            </td>
            <td rowSpan="4">
              <p>{criteriaQl7Grade}</p>
            </td>
          </tr>
          <tr>
            <td>19.</td>
            <td>7.1.4</td>
            <td>QL</td>
            <td>
              Describe the Institutional efforts/initiatives in providing an
              inclusive environment i.e., tolerance and harmony towards
              cultural, regional, linguistic, communal socioeconomic and
              Sensitization of students and employees to the constitutional
              obligations: values, rights, duties and responsibilities of citizens
            </td>
            <td>{qlweightage714}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue714}
                onChange={(e) => {
                  setDataValue714(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade714'
                name={dataValueGrade714}
                onChange={(e) => { setDataValueGrade714(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage714 * metricGradeScale(dataValueGrade714)}</p>
            </td>
          </tr>
          <tr>
            <td>20.</td>
            <td>7.2.1</td>
            <td>QL</td>
            <td>
              Describe two best practices successfully implemented by the
              Institution as per NAAC format provided in the Manual
            </td>
            <td>{qlweightage721}</td>
            <td>{qlkiWeightage72}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue721}
                onChange={(e) => {
                  setDataValue721(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade721'
                name={dataValueGrade721}
                onChange={(e) => { setDataValueGrade721(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage721 * metricGradeScale(dataValueGrade721)}</p>
            </td>
            <td>
              <p>{criteriaQl72Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl72Value / qlkiWeightage72).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>21.</td>
            <td>7.3.1</td>
            <td>QL</td>
            <td>
              Portray the performance of the Institution in one area distinctive
              to its priority and thrust within 1000 words
            </td>
            <td>{qlweightage731}</td>
            <td>{qlkiWeightage73}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue731}
                onChange={(e) => {
                  setDataValue731(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <select
                className="select"
                id='dataValueGrade731'
                name={dataValueGrade731}
                onChange={(e) => { setDataValueGrade731(e.target.value); }}
              >
                {grades.map(eachGrade => (
                  <option
                    id={eachGrade.grade}
                    key = {eachGrade.id}
                    value={eachGrade.grade}
                  >
                    {eachGrade.grade}
                  </option>
                ))}
              </select>
            </td>
            <td>
              <p>{qlweightage731 * metricGradeScale(dataValueGrade731)}</p>
            </td>
            <td>
              <p>{criteriaQl73Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQl73Value / qlkiWeightage73).toFixed(2)}</p>
            </td>
          </tr>
        </table>
        <div>
          <p htmlFor="comment">Comments:</p>
          <textarea
            id="comment"
            rows="6"
            cols="210"
            onChange={(e) => setQlCommentBox(e.target.value)}
            placeholder="Describe in maximum 500 words"
          ></textarea>
        </div>
        <div className="ql-button-container">
          <button
            className="ql-button-style"
            onClick={onClickingSave}
          >
            Save
          </button>
        </div>
      </div>
    </div>
  );
}
export default QL;
