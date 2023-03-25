import React, { useState } from "react";
import { toast } from "react-toastify";
import { resources } from "../../../appConstants";
import AuthService from "../../../Pages/Users/services/auth.service";
import "./QN-style.css";

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

function QN() {
  const [commentBox, setCommentBox] = useState("");
  const [dataValue121, setDataValue121] = useState("");
  const [dataValue122, setDataValue122] = useState("");
  const [dataValue132, setDataValue132] = useState("");
  const [dataValue141, setDataValue141] = useState("");

  const [dataValue211, setDataValue211] = useState("");
  const [dataValue212, setDataValue212] = useState("");
  const [dataValue221, setDataValue221] = useState("");
  const [dataValue241, setDataValue241] = useState("");
  const [dataValue242, setDataValue242] = useState("");
  const [dataValue262, setDataValue262] = useState("");
  const [dataValue271, setDataValue271] = useState("");

  const [dataValue311, setDataValue311] = useState("");
  const [dataValue322, setDataValue322] = useState("");
  const [dataValue331, setDataValue331] = useState("");
  const [dataValue332, setDataValue332] = useState("");
  const [dataValue343, setDataValue343] = useState("");
  const [dataValue351, setDataValue351] = useState("");

  const [dataValue412, setDataValue412] = useState("");
  const [dataValue432, setDataValue432] = useState("");
  const [dataValue441, setDataValue441] = useState("");

  const [dataValue511, setDataValue511] = useState("");
  const [dataValue512, setDataValue512] = useState("");
  const [dataValue513, setDataValue513] = useState("");
  const [dataValue514, setDataValue514] = useState("");
  const [dataValue521, setDataValue521] = useState("");
  const [dataValue522, setDataValue522] = useState("");
  const [dataValue531, setDataValue531] = useState("");
  const [dataValue532, setDataValue532] = useState("");

  const [dataValue622, setDataValue622] = useState("");
  const [dataValue632, setDataValue632] = useState("");
  const [dataValue633, setDataValue633] = useState("");
  const [dataValue652, setDataValue652] = useState("");

  const [dataValue712, setDataValue712] = useState("");
  const [dataValue713, setDataValue713] = useState("");

  const qnweightage121 = 15;
  const qnweightage122 = 15;
  const qnkiWeightage121 = 30;
  const qnweightage132 = 10;
  const qnkiWeightage132 = 20;
  const qnweightage141 = 20;
  const qnkiWeightage141 = 20;
  const qncriteria1 = 70;

  const qnweightage211 = 20;
  const qnweightage212 = 20;
  const qnkiWeightage211 = 40;
  const qnweightage221 = 40;
  const qnkiWeightage221 = 40;
  const qnweightage241 = 15;
  const qnweightage242 = 25;
  const qnkiWeightage241 = 40;
  const qnweightage262 = 45;
  const qnkiWeightage262 = 45;
  const qnweightage271 = 60;
  const qnkiWeightage271 = 60;
  const qncriteria2 = 225;

  const qnweightage311 = 10;
  const qnkiWeightage311 = 10;
  const qnweightage322 = 5;
  const qnkiWeightage322 = 5;
  const qnweightage331 = 10;
  const qnweightage332 = 15;
  const qnkiWeightage331 = 25;
  const qnweightage343 = 20;
  const qnkiWeightage343 = 20;
  const qnweightage351 = 20;
  const qnkiWeightage351 = 20;
  const qncriteria3 = 80;

  const qnweightage412 = 10;
  const qnkiWeightage412 = 10;
  const qnweightage432 = 10;
  const qnkiWeightage432 = 10;
  const qnweightage441 = 20;
  const qnkiWeightage441 = 20;
  const qncriteria4 = 40;

  const qnweightage511 = 20;
  const qnweightage512 = 10;
  const qnweightage513 = 10;
  const qnweightage514 = 10;
  const qnkiWeightage511 = 50;
  const qnweightage521 = 20;
  const qnweightage522 = 10;
  const qnkiWeightage521 = 30;
  const qnweightage531 = 25;
  const qnweightage532 = 25;
  const qnkiWeightage531 = 50;
  const qncriteria5 = 130;

  const qnweightage622 = 4;
  const qnkiWeightage622 = 4;
  const qnweightage632 = 12;
  const qnweightage633 = 15;
  const qnkiWeightage632 = 27;
  const qnweightage652 = 15;
  const qnkiWeightage652 = 15;
  const qncriteria6 = 46;

  const qnweightage712 = 20;
  const qnweightage713 = 10;
  const qnkiWeightage712 = 30;
  const qncriteria7 = 30;

  const grades = [
    { id: "GRADE1", grade: "0" },
    { id: "GRADE2", grade: "1" },
    { id: "GRADE3", grade: "2" },
    { id: "GRADE4", grade: "3" },
    { id: "GRADE5", grade: "4" },
  ];

  function metricGradeScale(dataValue) {
    if (
      (dataValue >= 0 + "%" && dataValue <= 20 + "%")
      || (dataValue >= 0 && dataValue < 20)
      || dataValue === "E. None of the above"
      || dataValue === "E"
    ) {
      return 0;
    }
    if (
      (dataValue >= 21 + "%" && dataValue <= 40 + "%")
      || dataValue === "D. Any one of the above"
      || dataValue === "D"
      || (dataValue >= 20 && dataValue < 60)
    ) {
      return 1;
    }
    if (
      (dataValue >= 41 + "%" && dataValue <= 60 + "%")
      || (dataValue >= 60 && dataValue < 80)
      || dataValue === "C. Any two of the above"
      || dataValue === "C"
    ) {
      return 2;
    }
    if (
      (dataValue >= 61 + "%" && dataValue <= 80 + "%")
      || dataValue === "B. Any three of the above"
      || dataValue === "B"
      || (dataValue >= 80 && dataValue < 100)
    ) {
      return 3;
    }
    if (
      dataValue >= 81 + "%"
      || dataValue === "A. All of the above"
      || dataValue === "A"
      || dataValue >= 100
    ) {
      return 4;
    }
    return "";
  }
  function criteria1Value() {
    return (
      qnweightage121 * metricGradeScale(dataValue121)
      + qnweightage122 * metricGradeScale(dataValue122)
      + qnweightage132 * metricGradeScale(dataValue132)
      + qnweightage141 * metricGradeScale(dataValue141)
    );
  }
  function criteria2Value() {
    return (
      qnweightage211 * metricGradeScale(dataValue211)
      + qnweightage212 * metricGradeScale(dataValue212)
      + qnweightage221 * metricGradeScale(dataValue221)
      + qnweightage241 * metricGradeScale(dataValue241)
      + qnweightage242 * metricGradeScale(dataValue242)
      + qnweightage262 * metricGradeScale(dataValue262)
      + qnweightage271 * metricGradeScale(dataValue271)
    );
  }
  function criteria3Value() {
    return (
      qnweightage311 * metricGradeScale(dataValue311)
      + qnweightage322 * metricGradeScale(dataValue322)
      + qnweightage331 * metricGradeScale(dataValue331)
      + qnweightage332 * metricGradeScale(dataValue332)
      + qnweightage343 * metricGradeScale(dataValue343)
      + qnweightage351 * metricGradeScale(dataValue351)
    );
  }
  function criteria4Value() {
    return (
      qnweightage412 * metricGradeScale(dataValue412)
      + qnweightage432 * metricGradeScale(dataValue432)
      + qnweightage441 * metricGradeScale(dataValue441)
    );
  }
  function criteria5Value() {
    return (
      qnweightage511 * metricGradeScale(dataValue511)
      + qnweightage512 * metricGradeScale(dataValue512)
      + qnweightage513 * metricGradeScale(dataValue513)
      + qnweightage514 * metricGradeScale(dataValue514)
      + qnweightage521 * metricGradeScale(dataValue521)
      + qnweightage522 * metricGradeScale(dataValue522)
      + qnweightage531 * metricGradeScale(dataValue531)
      + qnweightage532 * metricGradeScale(dataValue532)
    );
  }
  function criteria6Value() {
    return (
      qnweightage622 * metricGradeScale(dataValue622)
      + qnweightage632 * metricGradeScale(dataValue632)
      + qnweightage633 * metricGradeScale(dataValue633)
      + qnweightage652 * metricGradeScale(dataValue652)
    );
  }
  function criteria7Value() {
    return (
      qnweightage712 * metricGradeScale(dataValue712)
      + qnweightage713 * metricGradeScale(dataValue713)
    );
  }

  const criteriaQn1Weightage = criteria1Value();
  const criteriaQn1Grade = parseFloat(criteriaQn1Weightage / qncriteria1).toFixed(
    2
  );
  const criteriaQn12Value = qnweightage121 * metricGradeScale(dataValue121)
    + qnweightage122 * metricGradeScale(dataValue122);
  const criteriaQn13Value = qnweightage132 * metricGradeScale(dataValue132);
  const criteriaQn14Value = qnweightage141 * metricGradeScale(dataValue141);

  const criteriaQn2Weightage = criteria2Value();
  const criteriaQn2Grade = parseFloat(criteriaQn2Weightage / qncriteria2).toFixed(
    2
  );
  const criteriaQn21Value = qnweightage211 * metricGradeScale(dataValue211)
    + qnweightage212 * metricGradeScale(dataValue212);
  const criteriaQn22Value = qnweightage221 * metricGradeScale(dataValue221);
  const criteriaQn24Value = qnweightage241 * metricGradeScale(dataValue241)
    + qnweightage242 * metricGradeScale(dataValue242);
  const criteriaQn26Value = qnweightage262 * metricGradeScale(dataValue262);
  const criteriaQn27Value = qnweightage271 * metricGradeScale(dataValue271);

  const criteriaQn3Weightage = criteria3Value();
  const criteriaQn3Grade = parseFloat(criteriaQn3Weightage / qncriteria3).toFixed(2);
  const criteriaQn31Value = qnweightage311 * metricGradeScale(dataValue311);
  const criteriaQn32Value = qnweightage322 * metricGradeScale(dataValue322);
  const criteriaQn33Value = (qnweightage331 * metricGradeScale(dataValue331) + qnweightage332 * metricGradeScale(dataValue332));
  const criteriaQn34Value = qnweightage343 * metricGradeScale(dataValue343);
  const criteriaQn35Value = qnweightage351 * metricGradeScale(dataValue351);

  const criteriaQn4Weightage = criteria4Value();
  const criteriaQn4Grade = parseFloat(criteriaQn4Weightage / qncriteria4).toFixed(2);
  const criteriaQn41Value = qnweightage412 * metricGradeScale(dataValue412);
  const criteriaQn43Value = qnweightage432 * metricGradeScale(dataValue432);
  const criteriaQn44Value = qnweightage441 * metricGradeScale(dataValue441);

  const criteriaQn5Weightage = criteria5Value();
  const criteriaQn5Grade = parseFloat(criteriaQn5Weightage / qncriteria5).toFixed(2);
  const criteriaQn51Value = qnweightage511 * metricGradeScale(dataValue511) + qnweightage512 * metricGradeScale(dataValue512) + qnweightage513 * metricGradeScale(dataValue513) + qnweightage514 * metricGradeScale(dataValue514);
  const criteriaQn52Value = qnweightage521 * metricGradeScale(dataValue521) + qnweightage522 * metricGradeScale(dataValue522);
  const criteriaQn53Value = qnweightage531 * metricGradeScale(dataValue531) + qnweightage532 * metricGradeScale(dataValue532);

  const criteriaQn6Weightage = criteria6Value();
  const criteriaQn6Grade = parseFloat(criteriaQn6Weightage / qncriteria6).toFixed(2);
  const criteriaQn62Value = qnweightage622 * metricGradeScale(dataValue622);
  const criteriaQn63Value = qnweightage632 * metricGradeScale(dataValue632) + qnweightage633 * metricGradeScale(dataValue633);
  const criteriaQn65Value = qnweightage652 * metricGradeScale(dataValue652);

  const criteriaQn7Weightage = criteria7Value();
  const criteriaQn7Grade = parseFloat(criteriaQn7Weightage / qncriteria7).toFixed(2);
  const criteriaQn71Value = qnweightage712 * metricGradeScale(dataValue712) + qnweightage713 * metricGradeScale(dataValue713);

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
    qntt8: commentBox,
    quantitativeDataList: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:101,
        qntt7: dataValue121,
        qntt6: "" + metricGradeScale(dataValue121),
        qntt5: "" + qnweightage121 * metricGradeScale(dataValue121),
        qntt4: parseFloat(criteriaQn12Value / qnkiWeightage121).toFixed(2),
        qntt3: criteriaQn1Grade,
        qntt2: "" + criteriaQn1Weightage,
        qntt1: "" + criteriaQn12Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:102,
        qntt7: dataValue122,
        qntt6: "" + metricGradeScale(dataValue122),
        qntt5: "" + qnweightage122 * metricGradeScale(dataValue122),
        qntt4: parseFloat(criteriaQn12Value / qnkiWeightage121).toFixed(2),
        qntt3: criteriaQn1Grade,
        qntt2: "" + criteriaQn1Weightage,
        qntt1: "" + criteriaQn12Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:103,
        qntt7: dataValue132,
        qntt6: "" + metricGradeScale(dataValue132),
        qntt5: "" + qnweightage132 * metricGradeScale(dataValue132),
        qntt4: parseFloat(criteriaQn13Value / qnkiWeightage132).toFixed(2),
        qntt3: criteriaQn1Grade,
        qntt2: "" + criteriaQn1Weightage,
        qntt1: "" + criteriaQn13Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:104,
        qntt7: dataValue141,
        qntt6: "" + metricGradeScale(dataValue141),
        qntt5: "" + qnweightage141 * metricGradeScale(dataValue141),
        qntt4: parseFloat(criteriaQn14Value / qnkiWeightage141).toFixed(2),
        qntt3: criteriaQn1Grade,
        qntt2: "" + criteriaQn1Weightage,
        qntt1: "" + criteriaQn14Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:105,
        qntt7: dataValue211,
        qntt6: "" + metricGradeScale(dataValue211),
        qntt5: "" + qnweightage211 * metricGradeScale(dataValue211),
        qntt4: parseFloat(criteriaQn21Value / qnkiWeightage211).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn21Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:106,
        qntt7: dataValue212,
        qntt6: "" + metricGradeScale(dataValue212),
        qntt5: "" + qnweightage211 * metricGradeScale(dataValue212),
        qntt4: parseFloat(criteriaQn21Value / qnkiWeightage211).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn21Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:107,
        qntt7: dataValue221,
        qntt6: "" + metricGradeScale(dataValue221),
        qntt5: "" + qnweightage221 * metricGradeScale(dataValue221),
        qntt4: parseFloat(criteriaQn22Value / qnkiWeightage221).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn22Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:108,
        qntt7: dataValue241,
        qntt6: "" + metricGradeScale(dataValue241),
        qntt5: "" + qnweightage241 * metricGradeScale(dataValue241),
        qntt4: parseFloat(criteriaQn24Value / qnkiWeightage241).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn24Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:109,
        qntt7: dataValue242,
        qntt6: "" + metricGradeScale(dataValue242),
        qntt5: "" + qnweightage242 * metricGradeScale(dataValue242),
        qntt4: parseFloat(criteriaQn24Value / qnkiWeightage241).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn24Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:110,
        qntt7: dataValue262,
        qntt6: "" + metricGradeScale(dataValue262),
        qntt5: "" + qnweightage262 * metricGradeScale(dataValue262),
        qntt4: parseFloat(criteriaQn26Value / qnkiWeightage262).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn26Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:111,
        qntt7: dataValue271,
        qntt6: "" + metricGradeScale(dataValue271),
        qntt5: "" + qnweightage271 * metricGradeScale(dataValue271),
        qntt4: parseFloat(criteriaQn27Value / qnkiWeightage271).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn27Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:112,
        qntt7: dataValue311,
        qntt6: "" + metricGradeScale(dataValue311),
        qntt5: "" + qnweightage311 * metricGradeScale(dataValue311),
        qntt4: parseFloat(criteriaQn31Value / qnkiWeightage311).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn31Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:113,
        qntt7: dataValue322,
        qntt6: "" + metricGradeScale(dataValue322),
        qntt5: "" + qnweightage322 * metricGradeScale(dataValue322),
        qntt4: parseFloat(criteriaQn32Value / qnkiWeightage322).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn32Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:114,
        qntt7: dataValue331,
        qntt6: "" + metricGradeScale(dataValue331),
        qntt5: "" + qnweightage331 * metricGradeScale(dataValue331),
        qntt4: parseFloat(criteriaQn32Value / qnkiWeightage331).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn33Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:115,
        qntt7: dataValue332,
        qntt6: "" + metricGradeScale(dataValue332),
        qntt5: "" + qnweightage332 * metricGradeScale(dataValue332),
        qntt4: parseFloat(criteriaQn33Value / qnkiWeightage331).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn33Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:116,
        qntt7: dataValue343,
        qntt6: "" + metricGradeScale(dataValue343),
        qntt5: "" + qnweightage343 * metricGradeScale(dataValue343),
        qntt4: parseFloat(criteriaQn34Value / qnkiWeightage343).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn34Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:117,
        qntt7: dataValue351,
        qntt6: "" + metricGradeScale(dataValue351),
        qntt5: "" + qnweightage351 * metricGradeScale(dataValue351),
        qntt4: parseFloat(criteriaQn35Value / qnkiWeightage351).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn35Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:118,
        qntt7: dataValue412,
        qntt6: "" + metricGradeScale(dataValue412),
        qntt5: "" + qnweightage412 * metricGradeScale(dataValue412),
        qntt4: parseFloat(criteriaQn41Value / qnkiWeightage412).toFixed(2),
        qntt3: criteriaQn4Grade,
        qntt2: "" + criteriaQn4Weightage,
        qntt1: "" + criteriaQn41Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:119,
        qntt7: dataValue432,
        qntt6: "" + metricGradeScale(dataValue432),
        qntt5: "" + qnweightage432 * metricGradeScale(dataValue432),
        qntt4: parseFloat(criteriaQn43Value / qnkiWeightage432).toFixed(2),
        qntt3: criteriaQn4Grade,
        qntt2: "" + criteriaQn4Weightage,
        qntt1: "" + criteriaQn43Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:120,
        qntt7: dataValue441,
        qntt6: "" + metricGradeScale(dataValue441),
        qntt5: "" + qnweightage441 * metricGradeScale(dataValue441),
        qntt4: parseFloat(criteriaQn44Value / qnkiWeightage441).toFixed(2),
        qntt3: criteriaQn4Grade,
        qntt2: "" + criteriaQn4Weightage,
        qntt1: "" + criteriaQn44Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:121,
        qntt7: dataValue511,
        qntt6: "" + metricGradeScale(dataValue511),
        qntt5: "" + qnweightage511 * metricGradeScale(dataValue511),
        qntt4: parseFloat(criteriaQn51Value / qnkiWeightage511).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn51Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:122,
        qntt7: dataValue512,
        qntt6: "" + metricGradeScale(dataValue512),
        qntt5: "" + qnweightage512 * metricGradeScale(dataValue512),
        qntt4: parseFloat(criteriaQn51Value / qnkiWeightage511).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn51Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:123,
        qntt7: dataValue513,
        qntt6: "" + metricGradeScale(dataValue513),
        qntt5: "" + qnweightage513 * metricGradeScale(dataValue513),
        qntt4: parseFloat(criteriaQn51Value / qnkiWeightage511).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn51Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:124,
        qntt7: dataValue514,
        qntt6: "" + metricGradeScale(dataValue514),
        qntt5: "" + qnweightage514 * metricGradeScale(dataValue514),
        qntt4: parseFloat(criteriaQn51Value / qnkiWeightage511).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn51Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:125,
        qntt7: dataValue521,
        qntt6: "" + metricGradeScale(dataValue521),
        qntt5: "" + qnweightage521 * metricGradeScale(dataValue521),
        qntt4: parseFloat(criteriaQn52Value / qnkiWeightage521).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn52Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:126,
        qntt7: dataValue522,
        qntt6: "" + metricGradeScale(dataValue522),
        qntt5: "" + qnweightage522 * metricGradeScale(dataValue522),
        qntt4: parseFloat(criteriaQn52Value / qnkiWeightage521).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn52Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:127,
        qntt7: dataValue531,
        qntt6: "" + metricGradeScale(dataValue531),
        qntt5: "" + qnweightage531 * metricGradeScale(dataValue531),
        qntt4: parseFloat(criteriaQn53Value / qnkiWeightage531).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn53Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:128,
        qntt7: dataValue532,
        qntt6: "" + metricGradeScale(dataValue532),
        qntt5: "" + qnweightage532 * metricGradeScale(dataValue532),
        qntt4: parseFloat(criteriaQn53Value / qnkiWeightage531).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn53Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:129,
        qntt7: dataValue622,
        qntt6: "" + metricGradeScale(dataValue622),
        qntt5: "" + qnweightage622 * metricGradeScale(dataValue622),
        qntt4: parseFloat(criteriaQn62Value / qnkiWeightage622).toFixed(2),
        qntt3: criteriaQn6Grade,
        qntt2: "" + criteriaQn6Weightage,
        qntt1: "" + criteriaQn62Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:130,
        qntt7: dataValue632,
        qntt6: "" + metricGradeScale(dataValue632),
        qntt5: "" + qnweightage632 * metricGradeScale(dataValue632),
        qntt4: parseFloat(criteriaQn63Value / qnkiWeightage632).toFixed(2),
        qntt3: criteriaQn6Grade,
        qntt2: "" + criteriaQn6Weightage,
        qntt1: "" + criteriaQn63Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:131,
        qntt7: dataValue633,
        qntt6: "" + metricGradeScale(dataValue633),
        qntt5: "" + qnweightage633 * metricGradeScale(dataValue633),
        qntt4: parseFloat(criteriaQn63Value / qnkiWeightage632).toFixed(2),
        qntt3: criteriaQn6Grade,
        qntt2: "" + criteriaQn6Weightage,
        qntt1: "" + criteriaQn63Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:132,
        qntt7: dataValue652,
        qntt6: "" + metricGradeScale(dataValue652),
        qntt5: "" + qnweightage652 * metricGradeScale(dataValue652),
        qntt4: parseFloat(criteriaQn65Value / qnkiWeightage652).toFixed(2),
        qntt3: criteriaQn6Grade,
        qntt2: "" + criteriaQn6Weightage,
        qntt1: "" + criteriaQn65Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:133,
        qntt7: dataValue712,
        qntt6: "" + metricGradeScale(dataValue712),
        qntt5: "" + qnweightage712 * metricGradeScale(dataValue712),
        qntt4: parseFloat(criteriaQn71Value / qnkiWeightage712).toFixed(2),
        qntt3: criteriaQn7Grade,
        qntt2: "" + criteriaQn7Weightage,
        qntt1: "" + criteriaQn71Value,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1:134,
        qntt7: dataValue713,
        qntt6: "" + metricGradeScale(dataValue713),
        qntt5: "" + qnweightage713 * metricGradeScale(dataValue713),
        qntt4: parseFloat(criteriaQn71Value / qnkiWeightage712).toFixed(2),
        qntt3: criteriaQn7Grade,
        qntt2: "" + criteriaQn7Weightage,
        qntt1: "" + criteriaQn71Value,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    if (dataValue121 !== ""
       && dataValue122 !== ""
       && dataValue132 !== ""
       && dataValue141 !== ""
       && dataValue211 !== ""
       && dataValue212 !== ""
       && dataValue221 !== ""
       && dataValue241 !== ""
       && dataValue242 !== ""
       && dataValue262 !== ""
       && dataValue271 !== ""
       && dataValue311 !== ""
       && dataValue322 !== ""
       && dataValue331 !== ""
       && dataValue332 !== ""
       && dataValue343 !== ""
       && dataValue351 !== ""
       && dataValue432 !== ""
       && dataValue412 !== ""
       && dataValue432 !== ""
       && dataValue441 !== ""
       && dataValue511 !== ""
       && dataValue512 !== ""
       && dataValue513 !== ""
       && dataValue514 !== ""
       && dataValue521 !== ""
       && dataValue522 !== ""
       && dataValue531 !== ""
       && dataValue532 !== ""
       && dataValue622 !== ""
       && dataValue632 !== ""
       && dataValue633 !== ""
       && dataValue652 !== ""
       && dataValue712 !== ""
       && dataValue713 !== ""
    ) {
      console.log("insert data is =>" + JSON.stringify(inputDataList));
      const qnData = new FormData();
      qnData.append("qualitativeQuantitativeInfo", jsonBlob(inputDataList));
      const filesFetchMethod = {
        method: "POST",
        headers: { Accept: "application/json ,text/plain" },
        authorization:
          "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
        body: qnData,
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
                Metric Weighted Grade
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
            <td>1.2.1</td>
            <td>QN</td>
            <td>
              Number of Add on /Certificate/Value added programs offered during
              the last five years
            </td>
            <td>{qnweightage121}</td>
            <td rowspan="2">{qnkiWeightage121}</td>
            <td rowspan="4">{qncriteria1}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue121}
                value={dataValue121}
                onChange={(e) => {
                  setDataValue121(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue121)}</p>
            </td>
            <td>
              <p>{qnweightage121 * metricGradeScale(dataValue121)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn12Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn12Value / qnkiWeightage121).toFixed(2)}</p>
            </td>
            <td rowSpan="4">
              <p>{criteriaQn1Weightage}</p>
            </td>
            <td rowSpan="4">
              <p>{criteriaQn1Grade}</p>
            </td>
          </tr>
          <tr>
            <td>2.</td>
            <td>1.2.2</td>
            <td>QN</td>
            <td>
              Percentage of students enrolled in Certificate/ Add-on/Value added
              programs as against the total number of students during the last five
              years
            </td>
            <td>{qnweightage122}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue122}
                value={dataValue122}
                onChange={(e) => {
                  setDataValue122(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue122)}</p>
            </td>
            <td>
              <p>{qnweightage122 * metricGradeScale(dataValue122)}</p>
            </td>
          </tr>
          <tr>
            <td>3.</td>
            <td>1.3.2</td>
            <td>QN</td>
            <td>
              Percentage of students undertaking project work/field work/
              internships (Data for the latest completed academic year)
            </td>
            <td>{qnweightage132}</td>
            <td>{qnkiWeightage132}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue132}
                value={dataValue132}
                onChange={(e) => {
                  setDataValue132(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue132)}</p>
            </td>
            <td>
              <p>{qnweightage132 * metricGradeScale(dataValue132)}</p>
            </td>
            <td>
              <p>{criteriaQn13Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn13Value / qnkiWeightage132).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>4.</td>
            <td>1.4.1</td>
            <td>QN</td>
            <td>
              Institution obtains feedback on the academic performance and
              ambience of the institution from various stakeholders, such as
              Students, Teachers, Employers, Alumni etc. and action taken report on
              the feedback is made available on institutional website (Yes or No)
            </td>
            <td>{qnweightage141}</td>
            <td>{qnkiWeightage141}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue141}
                value={dataValue141}
                onChange={(e) => {
                  setDataValue141(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue141)}</p>
            </td>
            <td>
              <p>{qnweightage141 * metricGradeScale(dataValue141)}</p>
            </td>
            <td>
              <p>{criteriaQn14Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn14Value / qnkiWeightage141).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>5.</td>
            <td>2.1.1</td>
            <td>QN</td>
            <td>Enrolment percentage </td>
            <td>{qnweightage211}</td>
            <td rowspan="2">{qnkiWeightage211}</td>
            <td rowspan="7">{qncriteria2}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue211}
                value={dataValue211}
                onChange={(e) => {
                  setDataValue211(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue211)}</p>
            </td>
            <td>
              <p>{qnweightage211 * metricGradeScale(dataValue211)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn21Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn21Value / qnkiWeightage211).toFixed(2)}</p>
            </td>
            <td rowSpan="7">
              <p>{criteriaQn2Weightage}</p>
            </td>
            <td rowSpan="7">
              <p>{criteriaQn2Grade}</p>
            </td>
          </tr>
          <tr>
            <td>6.</td>
            <td>2.1.2</td>
            <td>QN</td>
            <td>
              Percentage of seats filled against seats reserved for various categories
              (SC, ST, OBC, Divyangjan, etc. as per applicable reservation policy
              during the last five years
              (Exclusive of supernumerary seats)
            </td>
            <td>{qnweightage212}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue212}
                value={dataValue212}
                onChange={(e) => {
                  setDataValue212(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue212)}</p>
            </td>
            <td>
              <p>{qnweightage212 * metricGradeScale(dataValue212)}</p>
            </td>
          </tr>
          <tr>
            <td>7.</td>
            <td>2.2.1</td>
            <td>QN</td>
            <td>
              Student – Full time Teacher Ratio
              (Data for the latest completed academic year)
            </td>
            <td>{qnweightage221}</td>
            <td>{qnkiWeightage221}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue221}
                value={dataValue221}
                onChange={(e) => {
                  setDataValue221(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue221)}</p>
            </td>
            <td>
              <p>{qnweightage221 * metricGradeScale(dataValue221)}</p>
            </td>
            <td>
              <p>{criteriaQn22Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn22Value / qnkiWeightage221).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>8.</td>
            <td>2.4.1</td>
            <td>QN</td>
            <td>
              Percentage of full-time teachers against sanctioned posts during the
              last five years
            </td>
            <td>{qnweightage241}</td>
            <td rowspan="2">{qnkiWeightage241}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue241}
                value={dataValue241}
                onChange={(e) => {
                  setDataValue241(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue241)}</p>
            </td>
            <td>
              <p>{qnweightage241 * metricGradeScale(dataValue241)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn24Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn24Value / qnkiWeightage241).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>9.</td>
            <td>2.4.2</td>
            <td>QN</td>
            <td>
              Percentage of full time teachers with NET/SET/SLET/ Ph. D. / D.M. /
              M.Ch. / D.N.B Superspeciality / D.Sc. / D.Litt. during the last five
              years (consider only highest degree for count)
            </td>
            <td>{qnweightage242}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue242}
                value={dataValue242}
                onChange={(e) => {
                  setDataValue242(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue242)}</p>
            </td>
            <td>
              <p>{qnweightage242 * metricGradeScale(dataValue242)}</p>
            </td>
          </tr>
          <tr>
            <td>10.</td>
            <td>2.6.2</td>
            <td>QN</td>
            <td>
              Pass percentage of Students during last five years
            </td>
            <td>{qnweightage262}</td>
            <td>{qnkiWeightage262}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue262}
                value={dataValue262}
                onChange={(e) => {
                  setDataValue262(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue262)}</p>
            </td>
            <td>
              <p>{qnweightage262 * metricGradeScale(dataValue262)}</p>
            </td>
            <td>
              <p>{criteriaQn26Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn26Value / qnkiWeightage262).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>11.</td>
            <td>2.7.1</td>
            <td>QN</td>
            <td>
              Online student satisfaction survey regarding to teaching learning process.
              (Online survey to be conducted)
            </td>
            <td>{qnweightage271}</td>
            <td>{qnkiWeightage271}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue271}
                value={dataValue271}
                onChange={(e) => {
                  setDataValue271(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue271)}</p>
            </td>
            <td>
              <p>{qnweightage271 * metricGradeScale(dataValue271)}</p>
            </td>
            <td>
              <p>{criteriaQn27Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn27Value / qnkiWeightage271).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>12.</td>
            <td>3.1.1</td>
            <td>QN</td>
            <td>
              Grants received from Government and non-governmental agencies for
              research projects / endowments in the institution during the last five
              years (INR in Lakhs)
            </td>
            <td>{qnweightage311}</td>
            <td>{qnkiWeightage311}</td>
            <td rowspan="6">{qncriteria3}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue311}
                value={dataValue311}
                onChange={(e) => {
                  setDataValue311(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue311)}</p>
            </td>
            <td>
              <p>{qnweightage311 * metricGradeScale(dataValue311)}</p>
            </td>
            <td>
              <p>{criteriaQn31Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn31Value / qnkiWeightage311).toFixed(2)}</p>
            </td>
            <td rowSpan="6">
              <p>{criteriaQn3Weightage}</p>
            </td>
            <td rowSpan="6">
              <p>{criteriaQn3Grade}</p>
            </td>
          </tr>
          <tr>
            <td>13.</td>
            <td>3.2.2</td>
            <td>QN</td>
            <td>
              Number of workshops/seminars/conferences including on Research
              Methodology, Intellectual Property Rights (IPR) and
              entrepreneurship conducted during the last five years
            </td>
            <td>{qnweightage322}</td>
            <td>{qnkiWeightage322}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue322}
                value={dataValue322}
                onChange={(e) => {
                  setDataValue322(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue322)}</p>
            </td>
            <td>
              <p>{qnweightage322 * metricGradeScale(dataValue322)}</p>
            </td>
            <td>
              <p>{criteriaQn32Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn32Value / qnkiWeightage322).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>14.</td>
            <td>3.3.1</td>
            <td>QN</td>
            <td>
              Number of research papers published per teacher in the Journals
              notified on UGC care list during the last five years
            </td>
            <td>{qnweightage331}</td>
            <td rowSpan="2">{qnkiWeightage331}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue331}
                value={dataValue331}
                onChange={(e) => {
                  setDataValue331(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue331)}</p>
            </td>
            <td>
              <p>{qnweightage331 * metricGradeScale(dataValue331)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn33Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn33Value / qnkiWeightage331).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>15.</td>
            <td>3.3.2</td>
            <td>QN</td>
            <td>
              Number of books and chapters in edited volumes/books published
              and papers published in national/ international conference
              proceedings per teacher during last five years
            </td>
            <td>{qnweightage332}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue332}
                value={dataValue332}
                onChange={(e) => {
                  setDataValue332(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue332)}</p>
            </td>
            <td>
              <p>{qnweightage332 * metricGradeScale(dataValue332)}</p>
            </td>
          </tr>
          <tr>
            <td>16.</td>
            <td>3.4.3</td>
            <td>QN</td>
            <td>
              Number of extension and outreach programs conducted by the
              institution through NSS/NCC/Red cross/YRC etc., (including the
              programmes such as Swachh Bharat, AIDS awareness, Gender
              issues etc. and/or those organised in collaboration with industry,
              community and NGOs) during the last five years
            </td>
            <td>{qnweightage343}</td>
            <td>{qnkiWeightage343}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue343}
                value={dataValue343}
                onChange={(e) => {
                  setDataValue343(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue343)}</p>
            </td>
            <td>
              <p>{qnweightage343 * metricGradeScale(dataValue343)}</p>
            </td>
            <td>
              <p>{criteriaQn34Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn34Value / qnkiWeightage343).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>17.</td>
            <td>3.5.1</td>
            <td>QN</td>
            <td>
              The number of MoUs, collaborations/linkages for Faculty
              exchange, Student exchange, Internship, Field trip, On-the- job
              training, research and other academic activities during the last
              five years
            </td>
            <td>{qnweightage351}</td>
            <td>{qnkiWeightage351}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue351}
                value={dataValue351}
                onChange={(e) => {
                  setDataValue351(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue351)}</p>
            </td>
            <td>
              <p>{qnweightage351 * metricGradeScale(dataValue351)}</p>
            </td>
            <td>
              <p>{criteriaQn35Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn35Value / qnkiWeightage351).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>18.</td>
            <td>4.1.2</td>
            <td>QN</td>
            <td>
              Percentage of expenditure, excluding salary for infrastructure
              augmentation during last five years (INR in Lakhs)
            </td>
            <td>{qnweightage412}</td>
            <td>{qnkiWeightage412}</td>
            <td rowspan="3">{qncriteria4}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue412}
                value={dataValue412}
                onChange={(e) => {
                  setDataValue412(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue412)}</p>
            </td>
            <td>
              <p>{qnweightage412 * metricGradeScale(dataValue412)}</p>
            </td>
            <td>
              <p>{criteriaQn41Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn41Value / qnkiWeightage412).toFixed(2)}</p>
            </td>
            <td rowSpan="3">
              <p>{criteriaQn4Weightage}</p>
            </td>
            <td rowSpan="3">
              <p>{criteriaQn4Grade}</p>
            </td>
          </tr>
          <tr>
            <td>19.</td>
            <td>4.3.2</td>
            <td>QN</td>
            <td>
              Student – Computer ratio (Data for the latest completed academic year)
            </td>
            <td>{qnweightage432}</td>
            <td>{qnkiWeightage432}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue432}
                value={dataValue432}
                onChange={(e) => {
                  setDataValue432(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue432)}</p>
            </td>
            <td>
              <p>{qnweightage432 * metricGradeScale(dataValue432)}</p>
            </td>
            <td>
              <p>{criteriaQn43Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn43Value / qnkiWeightage432).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>20.</td>
            <td>4.4.1</td>
            <td>QN</td>
            <td>
              Percentage of expenditure incurred on maintenance of infrastructure
              (physical and academic support facilities) excluding salary component
              during the last five years (INR in Lakhs)
            </td>
            <td>{qnweightage441}</td>
            <td>{qnkiWeightage441}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue441}
                value={dataValue441}
                onChange={(e) => {
                  setDataValue441(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue441)}</p>
            </td>
            <td>
              <p>{qnweightage441 * metricGradeScale(dataValue441)}</p>
            </td>
            <td>
              <p>{criteriaQn44Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn44Value / qnkiWeightage441).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>21.</td>
            <td>5.1.1</td>
            <td>QN</td>
            <td>
              Percentage of students benefited by scholarships and freeships provided
              by the Government and Non-Government agencies during last five years
            </td>
            <td>{qnweightage511}</td>
            <td rowspan="4">{qnkiWeightage511}</td>
            <td rowspan="8">{qncriteria5}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue511}
                value={dataValue511}
                onChange={(e) => {
                  setDataValue511(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue511)}</p>
            </td>
            <td>
              <p>{qnweightage511 * metricGradeScale(dataValue511)}</p>
            </td>
            <td rowSpan="4">
              <p>{criteriaQn51Value}</p>
            </td>
            <td rowSpan="4">
              <p>{parseFloat(criteriaQn51Value / qnkiWeightage511).toFixed(2)}</p>
            </td>
            <td rowSpan="8">
              <p>{criteriaQn5Weightage}</p>
            </td>
            <td rowSpan="8">
              <p>{criteriaQn5Grade}</p>
            </td>
          </tr>
          <tr>
            <td>22.</td>
            <td>5.1.2</td>
            <td>QN</td>
            <td>
              Capacity building and skills enhancement initiatives taken by the
              institution include the following
              1. Soft skills
              2. Language and communication skills
              3. Life skills (Yoga, physical fitness, health and hygiene)
              4. ICT/computing skills
            </td>
            <td>{qnweightage512}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue512}
                value={dataValue512}
                onChange={(e) => {
                  setDataValue512(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue512)}</p>
            </td>
            <td>
              <p>{qnweightage512 * metricGradeScale(dataValue512)}</p>
            </td>
          </tr>
          <tr>
            <td>23.</td>
            <td>5.1.3</td>
            <td>QN</td>
            <td>
              Average percentage of students benefited by career counseling and
              guidance for competitive examinations as offered by the
              Institution during the last five years.
            </td>
            <td>{qnweightage513}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue513}
                value={dataValue513}
                onChange={(e) => {
                  setDataValue513(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue513)}</p>
            </td>
            <td>
              <p>{qnweightage513 * metricGradeScale(dataValue513)}</p>
            </td>
          </tr>
          <tr>
            <td>24.</td>
            <td>5.1.4</td>
            <td>QN</td>
            <td>
              The Institution has a transparent mechanism for timely redressal of
              student grievances including sexual harassment and ragging cases
              1. Implementation of guidelines of statutory/regulatory bodies
              2. Organisation wide awareness and undertakings on policies with zero
              tolerance
              3. Mechanisms for submission of online/offline students’ grievances
              4. Timely redressal of the grievances through appropriate committees
            </td>
            <td>{qnweightage514}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue514}
                value={dataValue514}
                onChange={(e) => {
                  setDataValue514(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue514)}</p>
            </td>
            <td>
              <p>{qnweightage514 * metricGradeScale(dataValue514)}</p>
            </td>
          </tr>
          <tr>
            <td>25.</td>
            <td>5.2.1</td>
            <td>QN</td>
            <td>
              Percentage of placement of outgoing students and students progressing to higher
              education during the last five years
            </td>
            <td>{qnweightage521}</td>
            <td rowspan="2">{qnkiWeightage521}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue521}
                value={dataValue521}
                onChange={(e) => {
                  setDataValue521(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue521)}</p>
            </td>
            <td>
              <p>{qnweightage521 * metricGradeScale(dataValue521)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn52Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn52Value / qnkiWeightage521).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>26.</td>
            <td>5.2.2</td>
            <td>QN</td>
            <td>
              Percentage of students qualifying in state/national/ international level
              examinations during the last five years (eg: JAM/CLAT/GATE/ GMAT/ CAT/
              GRE/ TOEFL/ Civil Services/State government examinations)
            </td>
            <td>{qnweightage522}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue522}
                value={dataValue522}
                onChange={(e) => {
                  setDataValue522(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue522)}</p>
            </td>
            <td>
              <p>{qnweightage522 * metricGradeScale(dataValue522)}</p>
            </td>
          </tr>
          <tr>
            <td>27.</td>
            <td>5.3.1</td>
            <td>QN</td>
            <td>
              Number of awards/medals for outstanding performance in sports/
              cultural activities at University / state/ national / international level
              (award for a team event should be counted as one) during the last five
              years
            </td>
            <td>{qnweightage531}</td>
            <td rowspan="2">{qnkiWeightage531}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue531}
                value={dataValue531}
                onChange={(e) => {
                  setDataValue531(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue531)}</p>
            </td>
            <td>
              <p>{qnweightage531 * metricGradeScale(dataValue531)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn53Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn53Value / qnkiWeightage531).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>28.</td>
            <td>5.3.2</td>
            <td>QN</td>
            <td>
              Average number of sports and cultural programs in which students of the
              Institution participated during last five years (organised by the
              institution/other institutions)
            </td>
            <td>{qnweightage532}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue532}
                value={dataValue532}
                onChange={(e) => {
                  setDataValue532(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue532)}</p>
            </td>
            <td>
              <p>{qnweightage532 * metricGradeScale(dataValue532)}</p>
            </td>
          </tr>
          <tr>
            <td>29.</td>
            <td>6.2.2</td>
            <td>QN</td>
            <td>
              Implementation of e-governance in areas of operation
              1. Administration
              2. Finance and Accounts
              3. Student Admission and Support
              4. Examination
            </td>
            <td>{qnweightage622}</td>
            <td>{qnkiWeightage622}</td>
            <td rowspan="4">{qncriteria6}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue622}
                value={dataValue622}
                onChange={(e) => {
                  setDataValue622(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue622)}</p>
            </td>
            <td>
              <p>{qnweightage622 * metricGradeScale(dataValue622)}</p>
            </td>
            <td>
              <p>{criteriaQn62Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn62Value / qnkiWeightage622).toFixed(2)}</p>
            </td>
            <td rowSpan="4">
              <p>{criteriaQn6Weightage}</p>
            </td>
            <td rowSpan="4">
              <p>{criteriaQn6Grade}</p>
            </td>
          </tr>
          <tr>
            <td>30.</td>
            <td>6.3.2</td>
            <td>QN</td>
            <td>
              Percentage of teachers provided with financial support to attend
              conferences/workshops and towards membership fee of professional
              bodies during the last five years
            </td>
            <td>{qnweightage632}</td>
            <td rowspan="2">{qnkiWeightage632}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue632}
                value={dataValue632}
                onChange={(e) => {
                  setDataValue632(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue632)}</p>
            </td>
            <td>
              <p>{qnweightage632 * metricGradeScale(dataValue632)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn63Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn63Value / qnkiWeightage632).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>31.</td>
            <td>6.3.3</td>
            <td>QN</td>
            <td>
              Percentage of teaching and non-teaching staff participating in
              Faculty development Programmes (FDP), professional development
              /administrative training programs during the last five years
            </td>
            <td>{qnweightage633}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue633}
                value={dataValue633}
                onChange={(e) => {
                  setDataValue633(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue633)}</p>
            </td>
            <td>
              <p>{qnweightage633 * metricGradeScale(dataValue633)}</p>
            </td>
          </tr>
          <tr>
            <td>32.</td>
            <td>6.5.2</td>
            <td>QN</td>
            <td>
              Quality assurance initiatives of the institution include:
              1. Regular meeting of Internal Quality Assurance Cell
              (IQAC); Feedback collected, analysed and used for
              improvements
              2. Collaborative quality initiatives with other institution(s)/
              membership of international networks
              3. Participation in NIRF
              4. any other quality audit/accreditation recognized by state,
              national or international agencies such as NAAC, NBA,
              ISO Certification etc
            </td>
            <td>{qnweightage652}</td>
            <td>{qnkiWeightage652}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue652}
                value={dataValue652}
                onChange={(e) => {
                  setDataValue652(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue652)}</p>
            </td>
            <td>
              <p>{qnweightage652 * metricGradeScale(dataValue652)}</p>
            </td>
            <td>
              <p>{criteriaQn65Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn65Value / qnkiWeightage652).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>33.</td>
            <td>7.1.2</td>
            <td>QN</td>
            <td>
              The Institution has facilities and initiatives for
              1. Alternate sources of energy and energy conservation
              measures
              2. Management of the various types of degradable and non-degradable waste
              3. Water conservation
              4. Green campus initiatives
              5. Disabled-friendly, barrier free environment
            </td>
            <td>{qnweightage712}</td>
            <td rowspan="2">{qnkiWeightage712}</td>
            <td rowspan="2">{qncriteria7}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue712}
                value={dataValue712}
                onChange={(e) => {
                  setDataValue712(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue712)}</p>
            </td>
            <td>
              <p>{qnweightage712 * metricGradeScale(dataValue712)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn71Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn71Value / qnkiWeightage712).toFixed(2)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn7Weightage}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn7Grade}</p>
            </td>
          </tr>
          <tr>
            <td>34.</td>
            <td>7.1.4</td>
            <td>QN</td>
            <td>
              Quality audits on environment and energy regularly undertaken by the Institution.
              The institutional environment and energy initiatives are confirmed
              through the following
              1. Green audit / Environment audit
              2. Energy audit
              3. Clean and green campus initiatives
              4. Beyond the campus environmental promotion activities
            </td>
            <td>{qnweightage713}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue713}
                value={dataValue713}
                onChange={(e) => {
                  setDataValue713(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue713)}</p>
            </td>
            <td>
              <p>{qnweightage713 * metricGradeScale(dataValue713)}</p>
            </td>
          </tr>
        </table>
        <div>
          <p htmlFor="comment">Comments:</p>
          <textarea
            id="comment"
            rows="6"
            cols="210"
            onChange={(e) => setCommentBox(e.target.value)}
            placeholder="Describe in maximum 500 words"
          ></textarea>
        </div>
        <div className="qn-button-container">
          <button className="qn-button-style" onClick={onClickingSave}>
            Save
          </button>
        </div>
      </div>
    </div>
  );
}
export default QN;
