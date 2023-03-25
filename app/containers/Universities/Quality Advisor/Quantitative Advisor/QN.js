import React, { useState } from "react";
import { toast } from "react-toastify";
import { resources } from "../../../appConstants";
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
  const [dataValue112, setDataValue112] = useState("");
  const [dataValue113, setDataValue113] = useState("");
  const [dataValue121, setDataValue121] = useState("");
  const [dataValue122, setDataValue122] = useState("");
  const [dataValue132, setDataValue132] = useState("");
  const [dataValue133, setDataValue133] = useState("");
  const [dataValue134, setDataValue134] = useState("");
  const [dataValue141, setDataValue141] = useState("");
  const [dataValue142, setDataValue142] = useState("");

  const [dataValue211, setDataValue211] = useState("");
  const [dataValue212, setDataValue212] = useState("");
  const [dataValue222, setDataValue222] = useState("");
  const [dataValue233, setDataValue233] = useState("");
  const [dataValue241, setDataValue241] = useState("");
  const [dataValue242, setDataValue242] = useState("");
  const [dataValue243, setDataValue243] = useState("");
  const [dataValue251, setDataValue251] = useState("");
  const [dataValue252, setDataValue252] = useState("");
  const [dataValue263, setDataValue263] = useState("");
  const [dataValue271, setDataValue271] = useState("");

  const [dataValue312, setDataValue312] = useState("");
  const [dataValue313, setDataValue313] = useState("");
  const [dataValue321, setDataValue321] = useState("");
  const [dataValue322, setDataValue322] = useState("");
  const [dataValue323, setDataValue323] = useState("");
  const [dataValue324, setDataValue324] = useState("");
  const [dataValue332, setDataValue332] = useState("");
  const [dataValue341, setDataValue341] = useState("");
  const [dataValue342, setDataValue342] = useState("");
  const [dataValue343, setDataValue343] = useState("");
  const [dataValue344, setDataValue344] = useState("");
  const [dataValue345, setDataValue345] = useState("");
  const [dataValue346, setDataValue346] = useState("");
  const [dataValue351, setDataValue351] = useState("");
  const [dataValue352, setDataValue352] = useState("");
  const [dataValue362, setDataValue362] = useState("");
  const [dataValue363, setDataValue363] = useState("");
  const [dataValue364, setDataValue364] = useState("");
  const [dataValue371, setDataValue371] = useState("");
  const [dataValue372, setDataValue372] = useState("");

  const [dataValue413, setDataValue413] = useState("");
  const [dataValue414, setDataValue414] = useState("");
  const [dataValue422, setDataValue422] = useState("");
  const [dataValue423, setDataValue423] = useState("");
  const [dataValue424, setDataValue424] = useState("");
  const [dataValue432, setDataValue432] = useState("");
  const [dataValue433, setDataValue433] = useState("");
  const [dataValue434, setDataValue434] = useState("");
  const [dataValue441, setDataValue441] = useState("");

  const [dataValue511, setDataValue511] = useState("");
  const [dataValue512, setDataValue512] = useState("");
  const [dataValue513, setDataValue513] = useState("");
  const [dataValue514, setDataValue514] = useState("");
  const [dataValue515, setDataValue515] = useState("");
  const [dataValue521, setDataValue521] = useState("");
  const [dataValue522, setDataValue522] = useState("");
  const [dataValue523, setDataValue523] = useState("");
  const [dataValue531, setDataValue531] = useState("");
  const [dataValue533, setDataValue533] = useState("");
  const [dataValue542, setDataValue542] = useState("");

  const [dataValue623, setDataValue623] = useState("");
  const [dataValue632, setDataValue632] = useState("");
  const [dataValue633, setDataValue633] = useState("");
  const [dataValue634, setDataValue634] = useState("");
  const [dataValue642, setDataValue642] = useState("");
  const [dataValue653, setDataValue653] = useState("");

  const [dataValue712, setDataValue712] = useState("");
  const [dataValue714, setDataValue714] = useState("");
  const [dataValue715, setDataValue715] = useState("");
  const [dataValue716, setDataValue716] = useState("");
  const [dataValue717, setDataValue717] = useState("");
  const [dataValue7110, setDataValue7110] = useState("");

  const qnweightage112 = 20;
  const qnkiWeightage112 = 30;
  const qnweightage113 = 10;
  const qnweightage121 = 20;
  const qnweightage122 = 20;
  const qnkiWeightage121 = 40;
  const qnweightage132 = 10;
  const qnweightage133 = 10;
  const qnweightage134 = 10;
  const qnkiWeightage132 = 30;
  const qnweightage141 = 10;
  const qnweightage142 = 10;
  const qnkiWeightage141 = 20;
  const qncriteria1 = 120;

  const qnweightage211 = 10;
  const qnweightage212 = 10;
  const qnkiWeightage211 = 20;
  const qnweightage222 = 15;
  const qnkiWeightage222 = 15;
  const qnweightage233 = 10;
  const qnkiWeightage233 = 10;
  const qnweightage241 = 15;
  const qnweightage242 = 20;
  const qnweightage243 = 15;
  const qnkiWeightage241 = 50;
  const qnweightage251 = 20;
  const qnweightage252 = 15;
  const qnkiWeightage251 = 35;
  const qnweightage263 = 20;
  const qnkiWeightage263 = 20;
  const qnweightage271 = 50;
  const qnkiWeightage271 = 50;
  const qncriteria2 = 200;

  const qnweightage312 = 8;
  const qnweightage313 = 6;
  const qnkiWeightage312 = 14;
  const qnweightage321 = 2;
  const qnweightage322 = 2;
  const qnweightage323 = 3;
  const qnweightage324 = 3;
  const qnkiWeightage321 = 10;
  const qnweightage332 = 5;
  const qnkiWeightage332 = 5;
  const qnweightage341 = 5;
  const qnweightage342 = 5;
  const qnweightage343 = 5;
  const qnweightage344 = 5;
  const qnweightage345 = 5;
  const qnweightage346 = 5;
  const qnkiWeightage341 = 30;
  const qnweightage351 = 5;
  const qnweightage352 = 5;
  const qnkiWeightage351 = 10;
  const qnweightage362 = 10;
  const qnweightage363 = 15;
  const qnweightage364 = 15;
  const qnkiWeightage362 = 40;
  const qnweightage371 = 10;
  const qnweightage372 = 10;
  const qnkiWeightage371 = 20;
  const qncriteria3 = 200;

  const qnweightage413 = 10;
  const qnweightage414 = 10;
  const qnkiWeightage413 = 20;
  const qnweightage422 = 5;
  const qnweightage423 = 10;
  const qnweightage424 = 10;
  const qnkiWeightage422 = 25;
  const qnweightage432 = 8;
  const qnweightage433 = 8;
  const qnweightage434 = 4;
  const qnkiWeightage432 = 20;
  const qnweightage441 = 10;
  const qnkiWeightage441 = 10;
  const qncriteria4 = 75;

  const qnweightage511 = 6;
  const qnweightage512 = 5;
  const qnweightage513 = 8;
  const qnweightage514 = 6;
  const qnweightage515 = 5;
  const qnkiWeightage511 = 30;
  const qnweightage521 = 10;
  const qnweightage522 = 10;
  const qnweightage523 = 10;
  const qnkiWeightage521 = 30;
  const qnweightage531 = 10;
  const qnweightage533 = 10;
  const qnkiWeightage531 = 20;
  const qnweightage542 = 5;
  const qnkiWeightage542 = 5;
  const qncriteria5 = 85;

  const qnweightage623 = 4;
  const qnkiWeightage623 = 4;
  const qnweightage632 = 8;
  const qnweightage633 = 8;
  const qnweightage634 = 10;
  const qnkiWeightage632 = 26;
  const qnweightage642 = 10;
  const qnkiWeightage642 = 10;
  const qnweightage653 = 10;
  const qnkiWeightage653 = 10;
  const qncriteria6 = 50;

  const qnweightage712 = 5;
  const qnweightage714 = 4;
  const qnweightage715 = 4;
  const qnweightage716 = 5;
  const qnweightage717 = 4;
  const qnweightage7110 = 5;
  const qnkiWeightage712 = 27;
  const qncriteria7 = 27;

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
      qnweightage112 * metricGradeScale(dataValue112)
      + qnweightage113 * metricGradeScale(dataValue113)
      + qnweightage121 * metricGradeScale(dataValue121)
      + qnweightage122 * metricGradeScale(dataValue122)
      + qnweightage132 * metricGradeScale(dataValue132)
      + qnweightage133 * metricGradeScale(dataValue133)
      + qnweightage134 * metricGradeScale(dataValue134)
      + qnweightage141 * metricGradeScale(dataValue141)
      + qnweightage142 * metricGradeScale(dataValue142)
    );
  }
  function criteria2Value() {
    return (
      qnweightage211 * metricGradeScale(dataValue211)
      + qnweightage212 * metricGradeScale(dataValue212)
      + qnweightage222 * metricGradeScale(dataValue222)
      + qnweightage233 * metricGradeScale(dataValue233)
      + qnweightage241 * metricGradeScale(dataValue241)
      + qnweightage242 * metricGradeScale(dataValue242)
      + qnweightage243 * metricGradeScale(dataValue243)
      + qnweightage251 * metricGradeScale(dataValue251)
      + qnweightage252 * metricGradeScale(dataValue252)
      + qnweightage263 * metricGradeScale(dataValue263)
      + qnweightage271 * metricGradeScale(dataValue271)
    );
  }
  function criteria3Value() {
    return (
      qnweightage312 * metricGradeScale(dataValue312)
      + qnweightage313 * metricGradeScale(dataValue313)
      + qnweightage321 * metricGradeScale(dataValue321)
      + qnweightage322 * metricGradeScale(dataValue322)
      + qnweightage323 * metricGradeScale(dataValue323)
      + qnweightage324 * metricGradeScale(dataValue324)
      + qnweightage332 * metricGradeScale(dataValue332)
      + qnweightage341 * metricGradeScale(dataValue341)
      + qnweightage342 * metricGradeScale(dataValue342)
      + qnweightage343 * metricGradeScale(dataValue343)
      + qnweightage344 * metricGradeScale(dataValue344)
      + qnweightage345 * metricGradeScale(dataValue345)
      + qnweightage346 * metricGradeScale(dataValue346)
      + qnweightage351 * metricGradeScale(dataValue351)
      + qnweightage352 * metricGradeScale(dataValue352)
      + qnweightage362 * metricGradeScale(dataValue362)
      + qnweightage363 * metricGradeScale(dataValue363)
      + qnweightage364 * metricGradeScale(dataValue364)
      + qnweightage371 * metricGradeScale(dataValue371)
      + qnweightage372 * metricGradeScale(dataValue372)
    );
  }
  function criteria4Value() {
    return (
      qnweightage413 * metricGradeScale(dataValue413)
      + qnweightage414 * metricGradeScale(dataValue414)
      + qnweightage422 * metricGradeScale(dataValue422)
      + qnweightage423 * metricGradeScale(dataValue423)
      + qnweightage424 * metricGradeScale(dataValue424)
      + qnweightage432 * metricGradeScale(dataValue432)
      + qnweightage433 * metricGradeScale(dataValue433)
      + qnweightage434 * metricGradeScale(dataValue434)
      + qnweightage441 * metricGradeScale(dataValue441)
    );
  }
  function criteria5Value() {
    return (
      qnweightage511 * metricGradeScale(dataValue511)
      + qnweightage512 * metricGradeScale(dataValue512)
      + qnweightage513 * metricGradeScale(dataValue513)
      + qnweightage514 * metricGradeScale(dataValue514)
      + qnweightage515 * metricGradeScale(dataValue515)
      + qnweightage521 * metricGradeScale(dataValue521)
      + qnweightage522 * metricGradeScale(dataValue522)
      + qnweightage523 * metricGradeScale(dataValue523)
      + qnweightage531 * metricGradeScale(dataValue531)
      + qnweightage533 * metricGradeScale(dataValue533)
      + qnweightage542 * metricGradeScale(dataValue542)
    );
  }
  function criteria6Value() {
    return (
      qnweightage623 * metricGradeScale(dataValue623)
      + qnweightage632 * metricGradeScale(dataValue632)
      + qnweightage633 * metricGradeScale(dataValue633)
      + qnweightage634 * metricGradeScale(dataValue634)
      + qnweightage642 * metricGradeScale(dataValue642)
      + qnweightage653 * metricGradeScale(dataValue653)
    );
  }
  function criteria7Value() {
    return (
      qnweightage712 * metricGradeScale(dataValue712)
      + qnweightage714 * metricGradeScale(dataValue714)
      + qnweightage715 * metricGradeScale(dataValue715)
      + qnweightage716 * metricGradeScale(dataValue716)
      + qnweightage717 * metricGradeScale(dataValue717)
      + qnweightage7110 * metricGradeScale(dataValue7110)
    );
  }

  const criteriaQn1Weightage = criteria1Value();
  const criteriaQn1Grade = parseFloat(criteriaQn1Weightage / qncriteria1).toFixed(
    2
  );
  const criteriaQn11Value = qnweightage112 * metricGradeScale(dataValue112)
    + qnweightage113 * metricGradeScale(dataValue113);
  const criteriaQn12Value = qnweightage121 * metricGradeScale(dataValue121)
    + qnweightage122 * metricGradeScale(dataValue122);
  const criteriaQn13Value = qnweightage132 * metricGradeScale(dataValue132)
    + qnweightage133 * metricGradeScale(dataValue133)
    + qnweightage134 * metricGradeScale(dataValue134);
  const criteriaQn14Value = qnweightage141 * metricGradeScale(dataValue141)
    + qnweightage142 * metricGradeScale(dataValue142);

  const criteriaQn2Weightage = criteria2Value();
  const criteriaQn2Grade = parseFloat(criteriaQn2Weightage / qncriteria2).toFixed(
    2
  );
  const criteriaQn21Value = qnweightage211 * metricGradeScale(dataValue211)
    + qnweightage212 * metricGradeScale(dataValue212);
  const criteriaQn22Value = qnweightage222 * metricGradeScale(dataValue222);
  const criteriaQn23Value = qnweightage233 * metricGradeScale(dataValue233);
  const criteriaQn24Value = qnweightage241 * metricGradeScale(dataValue241)
    + qnweightage242 * metricGradeScale(dataValue242)
    + qnweightage243 * metricGradeScale(dataValue243);
  const criteriaQn25Value = qnweightage251 * metricGradeScale(dataValue251)
    + qnweightage252 * metricGradeScale(dataValue252);
  const criteriaQn26Value = qnweightage263 * metricGradeScale(dataValue263);
  const criteriaQn27Value = qnweightage271 * metricGradeScale(dataValue271);

  const criteriaQn3Weightage = criteria3Value();
  const criteriaQn3Grade = parseFloat(criteriaQn3Weightage / qncriteria3).toFixed(
    2
  );
  const criteriaQn31Value = qnweightage312 * metricGradeScale(dataValue312)
    + qnweightage313 * metricGradeScale(dataValue313);
  const criteriaQn32Value = qnweightage321 * metricGradeScale(dataValue321)
    + qnweightage322 * metricGradeScale(dataValue322)
    + qnweightage323 * metricGradeScale(dataValue323)
    + qnweightage324 * metricGradeScale(dataValue324);
  const criteriaQn33Value = qnweightage332 * metricGradeScale(dataValue332);
  const criteriaQn34Value = qnweightage341 * metricGradeScale(dataValue341)
    + qnweightage342 * metricGradeScale(dataValue342)
    + qnweightage343 * metricGradeScale(dataValue343)
    + qnweightage344 * metricGradeScale(dataValue344)
    + qnweightage345 * metricGradeScale(dataValue345)
    + qnweightage346 * metricGradeScale(dataValue346);
  const criteriaQn35Value = qnweightage351 * metricGradeScale(dataValue351)
    + qnweightage352 * metricGradeScale(dataValue352);
  const criteriaQn36Value = qnweightage362 * metricGradeScale(dataValue362)
    + qnweightage363 * metricGradeScale(dataValue363)
    + qnweightage364 * metricGradeScale(dataValue364);
  const criteriaQn37Value = qnweightage371 * metricGradeScale(dataValue371)
    + qnweightage372 * metricGradeScale(dataValue372);

  const criteriaQn4Weightage = criteria4Value();
  const criteriaQn4Grade = parseFloat(criteriaQn4Weightage / qncriteria4).toFixed(
    2
  );
  const criteriaQn41Value = qnweightage413 * metricGradeScale(dataValue413)
    + qnweightage414 * metricGradeScale(dataValue414);
  const criteriaQn42Value = qnweightage422 * metricGradeScale(dataValue422)
    + qnweightage423 * metricGradeScale(dataValue423)
    + qnweightage424 * metricGradeScale(dataValue424);
  const criteriaQn43Value = qnweightage432 * metricGradeScale(dataValue432)
    + qnweightage433 * metricGradeScale(dataValue433)
    + qnweightage434 * metricGradeScale(dataValue434);
  const criteriaQn44Value = qnweightage441 * metricGradeScale(dataValue441);

  const criteriaQn5Weightage = criteria5Value();
  const criteriaQn5Grade = parseFloat(criteriaQn5Weightage / qncriteria5).toFixed(
    2
  );
  const criteriaQn51Value = qnweightage511 * metricGradeScale(dataValue511)
    + qnweightage512 * metricGradeScale(dataValue512)
    + qnweightage513 * metricGradeScale(dataValue513)
    + qnweightage514 * metricGradeScale(dataValue514)
    + qnweightage515 * metricGradeScale(dataValue515);
  const criteriaQn52Value = qnweightage521 * metricGradeScale(dataValue521)
    + qnweightage522 * metricGradeScale(dataValue522)
    + qnweightage523 * metricGradeScale(dataValue523);
  const criteriaQn53Value = qnweightage531 * metricGradeScale(dataValue531)
    + qnweightage533 * metricGradeScale(dataValue533);
  const criteriaQn54Value = qnweightage542 * metricGradeScale(dataValue542);

  const criteriaQn6Weightage = criteria6Value();
  const criteriaQn6Grade = parseFloat(criteriaQn6Weightage / qncriteria6).toFixed(
    2
  );
  const criteriaQn62Value = qnweightage623 * metricGradeScale(dataValue623);
  const criteriaQn63Value = qnweightage632 * metricGradeScale(dataValue632)
    + qnweightage633 * metricGradeScale(dataValue633)
    + qnweightage634 * metricGradeScale(dataValue634);
  const criteriaQn64Value = qnweightage642 * metricGradeScale(dataValue642);
  const criteriaQn65Value = qnweightage653 * metricGradeScale(dataValue653);

  const criteriaQn7Weightage = criteria7Value();
  const criteriaQn7Grade = parseFloat(criteriaQn7Weightage / qncriteria7).toFixed(
    2
  );
  const criteriaQn71Value = qnweightage712 * metricGradeScale(dataValue712)
    + qnweightage714 * metricGradeScale(dataValue714)
    + qnweightage715 * metricGradeScale(dataValue715)
    + qnweightage716 * metricGradeScale(dataValue716)
    + qnweightage717 * metricGradeScale(dataValue717)
    + qnweightage7110 * metricGradeScale(dataValue7110);

  const inputDataList = {
    criteriaId: {
      collegeId: "1",
      financialYear: "2021-2022",
      typeofInstitution: " university",
    },
    quantitativeDataList: [
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 73,
        qntt8: commentBox
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 1,
        qntt7: dataValue112,
        qntt6: "" + metricGradeScale(dataValue112),
        qntt5: "" + qnweightage112 * metricGradeScale(dataValue112),
        qntt4: parseFloat(criteriaQn11Value / qnkiWeightage112).toFixed(2),
        qntt3: criteriaQn1Grade,
        qntt2: "" + criteriaQn1Weightage,
        qntt1: "" + criteriaQn11Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 2,
        qntt7: dataValue113,
        qntt6: "" + metricGradeScale(dataValue113),
        qntt5: "" + qnweightage113 * metricGradeScale(dataValue113),
        qntt4: parseFloat(criteriaQn11Value / qnkiWeightage112).toFixed(2),
        qntt3: criteriaQn1Grade,
        qntt2: "" + criteriaQn1Weightage,
        qntt1: "" + criteriaQn11Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 3,
        qntt7: dataValue121,
        qntt6: "" + metricGradeScale(dataValue121),
        qntt5: "" + qnweightage121 * metricGradeScale(dataValue121),
        qntt4: parseFloat(criteriaQn12Value / qnkiWeightage121).toFixed(2),
        qntt3: criteriaQn1Grade,
        qntt2: "" + criteriaQn1Weightage,
        qntt1: "" + criteriaQn12Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 4,
        qntt7: dataValue122,
        qntt6: "" + metricGradeScale(dataValue122),
        qntt5: "" + qnweightage122 * metricGradeScale(dataValue122),
        qntt4: parseFloat(criteriaQn12Value / qnkiWeightage121).toFixed(2),
        qntt3: criteriaQn1Grade,
        qntt2: "" + criteriaQn1Weightage,
        qntt1: "" + criteriaQn12Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 5,
        qntt7: dataValue132,
        qntt6: "" + metricGradeScale(dataValue132),
        qntt5: "" + qnweightage132 * metricGradeScale(dataValue132),
        qntt4: parseFloat(criteriaQn13Value / qnkiWeightage132).toFixed(2),
        qntt3: criteriaQn1Grade,
        qntt2: "" + criteriaQn1Weightage,
        qntt1: "" + criteriaQn13Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 6,
        qntt7: dataValue133,
        qntt6: "" + metricGradeScale(dataValue133),
        qntt5: "" + qnweightage133 * metricGradeScale(dataValue133),
        qntt4: parseFloat(criteriaQn13Value / qnkiWeightage132).toFixed(2),
        qntt3: criteriaQn1Grade,
        qntt2: "" + criteriaQn1Weightage,
        qntt1: "" + criteriaQn13Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 7,
        qntt7: dataValue134,
        qntt6: "" + metricGradeScale(dataValue134),
        qntt5: "" + qnweightage134 * metricGradeScale(dataValue134),
        qntt4: parseFloat(criteriaQn13Value / qnkiWeightage132).toFixed(2),
        qntt3: criteriaQn1Grade,
        qntt2: "" + criteriaQn1Weightage,
        qntt1: "" + criteriaQn13Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 8,
        qntt7: dataValue141,
        qntt6: "" + metricGradeScale(dataValue141),
        qntt5: "" + qnweightage141 * metricGradeScale(dataValue141),
        qntt4: parseFloat(criteriaQn14Value / qnkiWeightage141).toFixed(2),
        qntt3: criteriaQn1Grade,
        qntt2: "" + criteriaQn1Weightage,
        qntt1: "" + criteriaQn14Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 9,
        qntt7: dataValue142,
        qntt6: "" + metricGradeScale(dataValue142),
        qntt5: "" + qnweightage142 * metricGradeScale(dataValue142),
        qntt4: parseFloat(criteriaQn14Value / qnkiWeightage141).toFixed(2),
        qntt3: criteriaQn1Grade,
        qntt2: "" + criteriaQn1Weightage,
        qntt1: "" + criteriaQn14Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 10,
        qntt7: dataValue211,
        qntt6: "" + metricGradeScale(dataValue211),
        qntt5: "" + qnweightage211 * metricGradeScale(dataValue211),
        qntt4: parseFloat(criteriaQn21Value / qnkiWeightage211).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn21Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 11,
        qntt7: dataValue212,
        qntt6: "" + metricGradeScale(dataValue212),
        qntt5: "" + qnweightage211 * metricGradeScale(dataValue212),
        qntt4: parseFloat(criteriaQn21Value / qnkiWeightage211).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn21Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 12,
        qntt7: dataValue222,
        qntt6: "" + metricGradeScale(dataValue222),
        qntt5: "" + qnweightage222 * metricGradeScale(dataValue222),
        qntt4: parseFloat(criteriaQn22Value / qnkiWeightage222).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn22Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 13,
        qntt7: dataValue233,
        qntt6: "" + metricGradeScale(dataValue233),
        qntt5: "" + qnweightage233 * metricGradeScale(dataValue233),
        qntt4: parseFloat(criteriaQn23Value / qnkiWeightage233).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn23Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 14,
        qntt7: dataValue241,
        qntt6: "" + metricGradeScale(dataValue241),
        qntt5: "" + qnweightage241 * metricGradeScale(dataValue241),
        qntt4: parseFloat(criteriaQn24Value / qnkiWeightage241).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn24Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 15,
        qntt7: dataValue242,
        qntt6: "" + metricGradeScale(dataValue242),
        qntt5: "" + qnweightage242 * metricGradeScale(dataValue242),
        qntt4: parseFloat(criteriaQn24Value / qnkiWeightage241).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn24Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 16,
        qntt7: dataValue243,
        qntt6: "" + metricGradeScale(dataValue243),
        qntt5: "" + qnweightage243 * metricGradeScale(dataValue243),
        qntt4: parseFloat(criteriaQn24Value / qnkiWeightage241).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn24Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 17,
        qntt7: dataValue251,
        qntt6: "" + metricGradeScale(dataValue251),
        qntt5: "" + qnweightage251 * metricGradeScale(dataValue251),
        qntt4: parseFloat(criteriaQn25Value / qnkiWeightage251).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn25Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 18,
        qntt7: dataValue252,
        qntt6: "" + metricGradeScale(dataValue252),
        qntt5: "" + qnweightage252 * metricGradeScale(dataValue252),
        qntt4: parseFloat(criteriaQn25Value / qnkiWeightage251).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn25Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 19,
        qntt7: dataValue263,
        qntt6: "" + metricGradeScale(dataValue263),
        qntt5: "" + qnweightage263 * metricGradeScale(dataValue263),
        qntt4: parseFloat(criteriaQn26Value / qnkiWeightage263).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn26Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 20,
        qntt7: dataValue271,
        qntt6: "" + metricGradeScale(dataValue271),
        qntt5: "" + qnweightage271 * metricGradeScale(dataValue271),
        qntt4: parseFloat(criteriaQn27Value / qnkiWeightage271).toFixed(2),
        qntt3: criteriaQn2Grade,
        qntt2: "" + criteriaQn2Weightage,
        qntt1: "" + criteriaQn27Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 21,
        qntt7: dataValue312,
        qntt6: "" + metricGradeScale(dataValue312),
        qntt5: "" + qnweightage312 * metricGradeScale(dataValue312),
        qntt4: parseFloat(criteriaQn31Value / qnkiWeightage312).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn31Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 22,
        qntt7: dataValue313,
        qntt6: "" + metricGradeScale(dataValue313),
        qntt5: "" + qnweightage313 * metricGradeScale(dataValue313),
        qntt4: parseFloat(criteriaQn31Value / qnkiWeightage312).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn31Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 23,
        qntt7: dataValue321,
        qntt6: "" + metricGradeScale(dataValue321),
        qntt5: "" + qnweightage321 * metricGradeScale(dataValue321),
        qntt4: parseFloat(criteriaQn32Value / qnkiWeightage321).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn32Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 24,
        qntt7: dataValue322,
        qntt6: "" + metricGradeScale(dataValue322),
        qntt5: "" + qnweightage321 * metricGradeScale(dataValue322),
        qntt4: parseFloat(criteriaQn32Value / qnkiWeightage321).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn32Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 25,
        qntt7: dataValue323,
        qntt6: "" + metricGradeScale(dataValue323),
        qntt5: "" + qnweightage323 * metricGradeScale(dataValue323),
        qntt4: parseFloat(criteriaQn32Value / qnkiWeightage321).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn32Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 26,
        qntt7: dataValue324,
        qntt6: "" + metricGradeScale(dataValue324),
        qntt5: "" + qnweightage324 * metricGradeScale(dataValue324),
        qntt4: parseFloat(criteriaQn32Value / qnkiWeightage321).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn32Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 27,
        qntt7: dataValue332,
        qntt6: "" + metricGradeScale(dataValue332),
        qntt5: "" + qnweightage332 * metricGradeScale(dataValue332),
        qntt4: parseFloat(criteriaQn33Value / qnkiWeightage332).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn33Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 28,
        qntt7: dataValue341,
        qntt6: "" + metricGradeScale(dataValue341),
        qntt5: "" + qnweightage341 * metricGradeScale(dataValue341),
        qntt4: parseFloat(criteriaQn34Value / qnkiWeightage341).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn34Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 29,
        qntt7: dataValue342,
        qntt6: "" + metricGradeScale(dataValue342),
        qntt5: "" + qnweightage342 * metricGradeScale(dataValue342),
        qntt4: parseFloat(criteriaQn34Value / qnkiWeightage341).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn34Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 30,
        qntt7: dataValue343,
        qntt6: "" + metricGradeScale(dataValue343),
        qntt5: "" + qnweightage343 * metricGradeScale(dataValue343),
        qntt4: parseFloat(criteriaQn34Value / qnkiWeightage341).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn34Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 31,
        qntt7: dataValue344,
        qntt6: "" + metricGradeScale(dataValue344),
        qntt5: "" + qnweightage344 * metricGradeScale(dataValue344),
        qntt4: parseFloat(criteriaQn34Value / qnkiWeightage341).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn34Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 32,
        qntt7: dataValue345,
        qntt6: "" + metricGradeScale(dataValue345),
        qntt5: "" + qnweightage345 * metricGradeScale(dataValue345),
        qntt4: parseFloat(criteriaQn34Value / qnkiWeightage341).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn34Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 33,
        qntt7: dataValue346,
        qntt6: "" + metricGradeScale(dataValue346),
        qntt5: "" + qnweightage346 * metricGradeScale(dataValue346),
        qntt4: parseFloat(criteriaQn34Value / qnkiWeightage341).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn34Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 34,
        qntt7: dataValue351,
        qntt6: "" + metricGradeScale(dataValue351),
        qntt5: "" + qnweightage351 * metricGradeScale(dataValue351),
        qntt4: parseFloat(criteriaQn35Value / qnkiWeightage351).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn35Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 35,
        qntt7: dataValue352,
        qntt6: "" + metricGradeScale(dataValue352),
        qntt5: "" + qnweightage352 * metricGradeScale(dataValue352),
        qntt4: parseFloat(criteriaQn35Value / qnkiWeightage351).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn35Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 36,
        qntt7: dataValue362,
        qntt6: "" + metricGradeScale(dataValue362),
        qntt5: "" + qnweightage362 * metricGradeScale(dataValue362),
        qntt4: parseFloat(criteriaQn36Value / qnkiWeightage362).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn36Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 37,
        qntt7: dataValue363,
        qntt6: "" + metricGradeScale(dataValue363),
        qntt5: "" + qnweightage363 * metricGradeScale(dataValue363),
        qntt4: parseFloat(criteriaQn36Value / qnkiWeightage362).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn36Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 38,
        qntt7: dataValue364,
        qntt6: "" + metricGradeScale(dataValue364),
        qntt5: "" + qnweightage364 * metricGradeScale(dataValue364),
        qntt4: parseFloat(criteriaQn36Value / qnkiWeightage362).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn36Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 39,
        qntt7: dataValue371,
        qntt6: "" + metricGradeScale(dataValue371),
        qntt5: "" + qnweightage371 * metricGradeScale(dataValue371),
        qntt4: parseFloat(criteriaQn37Value / qnkiWeightage371).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn37Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 40,
        qntt7: dataValue372,
        qntt6: "" + metricGradeScale(dataValue372),
        qntt5: "" + qnweightage371 * metricGradeScale(dataValue372),
        qntt4: parseFloat(criteriaQn37Value / qnkiWeightage371).toFixed(2),
        qntt3: criteriaQn3Grade,
        qntt2: "" + criteriaQn3Weightage,
        qntt1: "" + criteriaQn37Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 41,
        qntt7: dataValue413,
        qntt6: "" + metricGradeScale(dataValue413),
        qntt5: "" + qnweightage413 * metricGradeScale(dataValue413),
        qntt4: parseFloat(criteriaQn41Value / qnkiWeightage413).toFixed(2),
        qntt3: criteriaQn4Grade,
        qntt2: "" + criteriaQn4Weightage,
        qntt1: "" + criteriaQn41Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 42,
        qntt7: dataValue414,
        qntt6: "" + metricGradeScale(dataValue414),
        qntt5: "" + qnweightage414 * metricGradeScale(dataValue414),
        qntt4: parseFloat(criteriaQn41Value / qnkiWeightage413).toFixed(2),
        qntt3: criteriaQn4Grade,
        qntt2: "" + criteriaQn4Weightage,
        qntt1: "" + criteriaQn41Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 43,
        qntt7: dataValue422,
        qntt6: "" + metricGradeScale(dataValue422),
        qntt5: "" + qnweightage422 * metricGradeScale(dataValue422),
        qntt4: parseFloat(criteriaQn42Value / qnkiWeightage422).toFixed(2),
        qntt3: criteriaQn4Grade,
        qntt2: "" + criteriaQn4Weightage,
        qntt1: "" + criteriaQn42Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 44,
        qntt7: dataValue423,
        qntt6: "" + metricGradeScale(dataValue423),
        qntt5: "" + qnweightage423 * metricGradeScale(dataValue423),
        qntt4: parseFloat(criteriaQn42Value / qnkiWeightage422).toFixed(2),
        qntt3: criteriaQn4Grade,
        qntt2: "" + criteriaQn4Weightage,
        qntt1: "" + criteriaQn42Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 45,
        qntt7: dataValue424,
        qntt6: "" + metricGradeScale(dataValue424),
        qntt5: "" + qnweightage424 * metricGradeScale(dataValue424),
        qntt4: parseFloat(criteriaQn42Value / qnkiWeightage422).toFixed(2),
        qntt3: criteriaQn4Grade,
        qntt2: "" + criteriaQn4Weightage,
        qntt1: "" + criteriaQn42Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 46,
        qntt7: dataValue432,
        qntt6: "" + metricGradeScale(dataValue432),
        qntt5: "" + qnweightage432 * metricGradeScale(dataValue432),
        qntt4: parseFloat(criteriaQn43Value / qnkiWeightage432).toFixed(2),
        qntt3: criteriaQn4Grade,
        qntt2: "" + criteriaQn4Weightage,
        qntt1: "" + criteriaQn43Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 47,
        qntt7: dataValue433,
        qntt6: "" + metricGradeScale(dataValue433),
        qntt5: "" + qnweightage433 * metricGradeScale(dataValue433),
        qntt4: parseFloat(criteriaQn43Value / qnkiWeightage432).toFixed(2),
        qntt3: criteriaQn4Grade,
        qntt2: "" + criteriaQn4Weightage,
        qntt1: "" + criteriaQn43Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 48,
        qntt7: dataValue434,
        qntt6: "" + metricGradeScale(dataValue434),
        qntt5: "" + qnweightage434 * metricGradeScale(dataValue434),
        qntt4: parseFloat(criteriaQn43Value / qnkiWeightage432).toFixed(2),
        qntt3: criteriaQn4Grade,
        qntt2: "" + criteriaQn4Weightage,
        qntt1: "" + criteriaQn43Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 49,
        qntt7: dataValue441,
        qntt6: "" + metricGradeScale(dataValue441),
        qntt5: "" + qnweightage441 * metricGradeScale(dataValue441),
        qntt4: parseFloat(criteriaQn44Value / qnkiWeightage441).toFixed(2),
        qntt3: criteriaQn4Grade,
        qntt2: "" + criteriaQn4Weightage,
        qntt1: "" + criteriaQn44Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 50,
        qntt7: dataValue511,
        qntt6: "" + metricGradeScale(dataValue511),
        qntt5: "" + qnweightage511 * metricGradeScale(dataValue511),
        qntt4: parseFloat(criteriaQn51Value / qnkiWeightage511).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn51Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 51,
        qntt7: dataValue512,
        qntt6: "" + metricGradeScale(dataValue512),
        qntt5: "" + qnweightage512 * metricGradeScale(dataValue512),
        qntt4: parseFloat(criteriaQn51Value / qnkiWeightage511).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn51Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 52,
        qntt7: dataValue513,
        qntt6: "" + metricGradeScale(dataValue513),
        qntt5: "" + qnweightage513 * metricGradeScale(dataValue513),
        qntt4: parseFloat(criteriaQn51Value / qnkiWeightage511).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn51Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 53,
        qntt7: dataValue514,
        qntt6: "" + metricGradeScale(dataValue514),
        qntt5: "" + qnweightage514 * metricGradeScale(dataValue514),
        qntt4: parseFloat(criteriaQn51Value / qnkiWeightage511).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn51Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 54,
        qntt7: dataValue515,
        qntt6: "" + metricGradeScale(dataValue515),
        qntt5: "" + qnweightage515 * metricGradeScale(dataValue515),
        qntt4: parseFloat(criteriaQn51Value / qnkiWeightage511).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn51Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 55,
        qntt7: dataValue521,
        qntt6: "" + metricGradeScale(dataValue521),
        qntt5: "" + qnweightage521 * metricGradeScale(dataValue521),
        qntt4: parseFloat(criteriaQn52Value / qnkiWeightage521).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn52Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 56,
        qntt7: dataValue522,
        qntt6: "" + metricGradeScale(dataValue522),
        qntt5: "" + qnweightage522 * metricGradeScale(dataValue522),
        qntt4: parseFloat(criteriaQn52Value / qnkiWeightage521).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn52Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 57,
        qntt7: dataValue523,
        qntt6: "" + metricGradeScale(dataValue523),
        qntt5: "" + qnweightage523 * metricGradeScale(dataValue523),
        qntt4: parseFloat(criteriaQn52Value / qnkiWeightage521).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn52Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 58,
        qntt7: dataValue531,
        qntt6: "" + metricGradeScale(dataValue531),
        qntt5: "" + qnweightage531 * metricGradeScale(dataValue531),
        qntt4: parseFloat(criteriaQn53Value / qnkiWeightage531).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn53Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 59,
        qntt7: dataValue533,
        qntt6: "" + metricGradeScale(dataValue533),
        qntt5: "" + qnweightage533 * metricGradeScale(dataValue533),
        qntt4: parseFloat(criteriaQn53Value / qnkiWeightage531).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn53Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 60,
        qntt7: dataValue542,
        qntt6: "" + metricGradeScale(dataValue542),
        qntt5: "" + qnweightage542 * metricGradeScale(dataValue542),
        qntt4: parseFloat(criteriaQn54Value / qnkiWeightage542).toFixed(2),
        qntt3: criteriaQn5Grade,
        qntt2: "" + criteriaQn5Weightage,
        qntt1: "" + criteriaQn54Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 61,
        qntt7: dataValue623,
        qntt6: "" + metricGradeScale(dataValue623),
        qntt5: "" + qnweightage623 * metricGradeScale(dataValue623),
        qntt4: parseFloat(criteriaQn62Value / qnkiWeightage623).toFixed(2),
        qntt3: criteriaQn6Grade,
        qntt2: "" + criteriaQn6Weightage,
        qntt1: "" + criteriaQn62Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 62,
        qntt7: dataValue632,
        qntt6: "" + metricGradeScale(dataValue632),
        qntt5: "" + qnweightage632 * metricGradeScale(dataValue632),
        qntt4: parseFloat(criteriaQn63Value / qnkiWeightage632).toFixed(2),
        qntt3: criteriaQn6Grade,
        qntt2: "" + criteriaQn6Weightage,
        qntt1: "" + criteriaQn63Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 63,
        qntt7: dataValue633,
        qntt6: "" + metricGradeScale(dataValue633),
        qntt5: "" + qnweightage633 * metricGradeScale(dataValue633),
        qntt4: parseFloat(criteriaQn63Value / qnkiWeightage632).toFixed(2),
        qntt3: criteriaQn6Grade,
        qntt2: "" + criteriaQn6Weightage,
        qntt1: "" + criteriaQn63Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 64,
        qntt7: dataValue634,
        qntt6: "" + metricGradeScale(dataValue634),
        qntt5: "" + qnweightage634 * metricGradeScale(dataValue634),
        qntt4: parseFloat(criteriaQn63Value / qnkiWeightage632).toFixed(2),
        qntt3: criteriaQn6Grade,
        qntt2: "" + criteriaQn6Weightage,
        qntt1: "" + criteriaQn63Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 65,
        qntt7: dataValue642,
        qntt6: "" + metricGradeScale(dataValue642),
        qntt5: "" + qnweightage642 * metricGradeScale(dataValue642),
        qntt4: parseFloat(criteriaQn64Value / qnkiWeightage642).toFixed(2),
        qntt3: criteriaQn6Grade,
        qntt2: "" + criteriaQn6Weightage,
        qntt1: "" + criteriaQn64Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 66,
        qntt7: dataValue653,
        qntt6: "" + metricGradeScale(dataValue653),
        qntt5: "" + qnweightage653 * metricGradeScale(dataValue653),
        qntt4: parseFloat(criteriaQn65Value / qnkiWeightage653).toFixed(2),
        qntt3: criteriaQn6Grade,
        qntt2: "" + criteriaQn6Weightage,
        qntt1: "" + criteriaQn65Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 67,
        qntt7: dataValue712,
        qntt6: "" + metricGradeScale(dataValue712),
        qntt5: "" + qnweightage712 * metricGradeScale(dataValue712),
        qntt4: parseFloat(criteriaQn71Value / qnkiWeightage712).toFixed(2),
        qntt3: criteriaQn7Grade,
        qntt2: "" + criteriaQn7Weightage,
        qntt1: "" + criteriaQn71Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 68,
        qntt7: dataValue714,
        qntt6: "" + metricGradeScale(dataValue714),
        qntt5: "" + qnweightage714 * metricGradeScale(dataValue714),
        qntt4: parseFloat(criteriaQn71Value / qnkiWeightage712).toFixed(2),
        qntt3: criteriaQn7Grade,
        qntt2: "" + criteriaQn7Weightage,
        qntt1: "" + criteriaQn71Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 69,
        qntt7: dataValue715,
        qntt6: "" + metricGradeScale(dataValue715),
        qntt5: "" + qnweightage714 * metricGradeScale(dataValue715),
        qntt4: parseFloat(criteriaQn71Value / qnkiWeightage712).toFixed(2),
        qntt3: criteriaQn7Grade,
        qntt2: "" + criteriaQn7Weightage,
        qntt1: "" + criteriaQn71Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 70,
        qntt7: dataValue716,
        qntt6: "" + metricGradeScale(dataValue716),
        qntt5: "" + qnweightage716 * metricGradeScale(dataValue716),
        qntt4: parseFloat(criteriaQn71Value / qnkiWeightage712).toFixed(2),
        qntt3: criteriaQn7Grade,
        qntt2: "" + criteriaQn7Weightage,
        qntt1: "" + criteriaQn71Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 71,
        qntt7: dataValue717,
        qntt6: "" + metricGradeScale(dataValue717),
        qntt5: "" + qnweightage717 * metricGradeScale(dataValue717),
        qntt4: parseFloat(criteriaQn71Value / qnkiWeightage712).toFixed(2),
        qntt3: criteriaQn7Grade,
        qntt2: "" + criteriaQn7Weightage,
        qntt1: "" + criteriaQn71Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 72,

        qntt7: dataValue7110,
        qntt6: "" + metricGradeScale(dataValue7110),
        qntt5: "" + qnweightage7110 * metricGradeScale(dataValue7110),
        qntt4: parseFloat(criteriaQn71Value / qnkiWeightage712).toFixed(2),
        qntt3: criteriaQn7Grade,
        qntt2: "" + criteriaQn7Weightage,
        qntt1: "" + criteriaQn71Value,
      },
    ],
    quantitativeCriterionWiseList: [
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 1,
        criterionWiseGrade: criteriaQn1Grade,
        criterionWiseWeighted: criteriaQn1Weightage,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 2,
        criterionWiseGrade: criteriaQn2Grade,
        criterionWiseWeighted: criteriaQn2Weightage,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 3,
        criterionWiseGrade: criteriaQn3Grade,
        criterionWiseWeighted: criteriaQn3Weightage,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 4,
        criterionWiseGrade: criteriaQn4Grade,
        criterionWiseWeighted: criteriaQn4Weightage,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 5,
        criterionWiseGrade: criteriaQn5Grade,
        criterionWiseWeighted: criteriaQn5Weightage,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 6,
        criterionWiseGrade: criteriaQn6Grade,
        criterionWiseWeighted: criteriaQn6Weightage,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 7,
        criterionWiseGrade: criteriaQn7Grade,
        criterionWiseWeighted: criteriaQn7Weightage,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 8,
        kiwisetotal: criteriaQn11Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 9,
        kiwisetotal: criteriaQn12Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 10,
        kiwisetotal: criteriaQn13Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 11,
        kiwisetotal: criteriaQn14Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 12,
        kiwisetotal: criteriaQn21Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 13,
        kiwisetotal: criteriaQn22Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 14,
        kiwisetotal: criteriaQn23Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 15,
        kiwisetotal: criteriaQn24Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 16,
        kiwisetotal: criteriaQn25Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 17,
        kiwisetotal: criteriaQn26Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 18,
        kiwisetotal: criteriaQn27Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 19,
        kiwisetotal: criteriaQn31Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 20,
        kiwisetotal: criteriaQn32Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 21,
        kiwisetotal: criteriaQn33Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 22,
        kiwisetotal: criteriaQn34Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 23,
        kiwisetotal: criteriaQn35Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 24,
        kiwisetotal: criteriaQn36Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 25,
        kiwisetotal: criteriaQn37Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 26,
        kiwisetotal: criteriaQn41Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 27,
        kiwisetotal: criteriaQn42Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 28,
        kiwisetotal: criteriaQn43Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 29,
        kiwisetotal: criteriaQn44Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 30,
        kiwisetotal: criteriaQn51Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 31,
        kiwisetotal: criteriaQn52Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 32,
        kiwisetotal: criteriaQn53Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 33,
        kiwisetotal: criteriaQn54Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 34,
        kiwisetotal: criteriaQn62Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 35,
        kiwisetotal: criteriaQn63Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 36,
        kiwisetotal: criteriaQn64Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 37,
        kiwisetotal: criteriaQn65Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 38,
        kiwisetotal: criteriaQn71Value,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    if (dataValue112 !== ""
      && dataValue113 !== ""
      && dataValue121 !== ""
      && dataValue122 !== ""
      && dataValue132 !== ""
      && dataValue133 !== ""
      && dataValue134 !== ""
      && dataValue141 !== ""
      && dataValue142 !== ""
      && dataValue211 !== ""
      && dataValue212 !== ""
      && dataValue222 !== ""
      && dataValue233 !== ""
      && dataValue241 !== ""
      && dataValue242 !== ""
      && dataValue243 !== ""
      && dataValue251 !== ""
      && dataValue252 !== ""
      && dataValue263 !== ""
      && dataValue271 !== ""
      && dataValue312 !== ""
      && dataValue313 !== ""
      && dataValue321 !== ""
      && dataValue322 !== ""
      && dataValue323 !== ""
      && dataValue324 !== ""
      && dataValue332 !== ""
      && dataValue341 !== ""
      && dataValue342 !== ""
      && dataValue343 !== ""
      && dataValue344 !== ""
      && dataValue345 !== ""
      && dataValue346 !== ""
      && dataValue351 !== ""
      && dataValue352 !== ""
      && dataValue362 !== ""
      && dataValue363 !== ""
      && dataValue364 !== ""
      && dataValue371 !== ""
      && dataValue372 !== ""
      && dataValue413 !== ""
      && dataValue414 !== ""
      && dataValue422 !== ""
      && dataValue423 !== ""
      && dataValue424 !== ""
      && dataValue432 !== ""
      && dataValue433 !== ""
      && dataValue434 !== ""
      && dataValue441 !== ""
      && dataValue511 !== ""
      && dataValue512 !== ""
      && dataValue513 !== ""
      && dataValue514 !== ""
      && dataValue515 !== ""
      && dataValue521 !== ""
      && dataValue522 !== ""
      && dataValue523 !== ""
      && dataValue531 !== ""
      && dataValue533 !== ""
      && dataValue542 !== ""
      && dataValue623 !== ""
      && dataValue632 !== ""
      && dataValue633 !== ""
      && dataValue634 !== ""
      && dataValue642 !== ""
      && dataValue653 !== ""
      && dataValue7110 !== ""
      && dataValue712 !== ""
      && dataValue714 !== ""
      && dataValue715 !== ""
      && dataValue716 !== ""
      && dataValue717 !== ""
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
        "http://localhost:8080/api/v1/saveQualitativeQuantitaveData",
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
          <tr style={{ textAlign: "center", }}>
            <th style={{ width: "10px", fontFamily: "sans-serif", fontSize: "medium" }}>S.No</th>
            <th style={{ width: "10px", fontFamily: "sans-serif", fontSize: "medium" }}>Metric No.</th>
            <th style={{ width: "10px", fontFamily: "sans-serif", fontSize: "medium" }}>Quality</th>
            <th style={{ width: "300px", fontFamily: "sans-serif", fontSize: "medium" }}>Description</th>
            <th style={{ width: "30px", fontFamily: "sans-serif", fontSize: "medium" }}>Weight</th>
            <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>Key Indicator (W)</th>
            <th style={{ width: "80px", fontFamily: "sans-serif", fontSize: "medium" }}>Criteria(W)</th>
            <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>
              {/* ADVV - 2 (Adiverse data validation) Response */}
              ADVV - 2
            </th>
            <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>Metric Grade scale (0-4)</th>
            <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>
              Metric wise weighted Grade points
            </th>
            <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>KI wise Weighted Grade</th>
            <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>KI wise Grade Point Average</th>
            <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>Criteria (W)</th>
            <th style={{ width: "50px", fontFamily: "sans-serif", fontSize: "medium" }}>
              Criteria wise Grade Point Average
            </th>
          </tr>
          <tr>
            <td>1.</td>
            <td>1.2.1</td>
            <td>QN</td>
            <td>
              Percentage of new courses introduced out of the total number of courses across all programmes offered during the last five years
            </td>
            <td>{qnweightage112}</td>
            <td rowspan="2">{qnkiWeightage112}</td>
            <td rowspan="9">{qncriteria1}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue112}
                value={dataValue112}
                onChange={(e) => {
                  setDataValue112(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue112)}</p>
            </td>
            <td>
              <p>{qnweightage112 * metricGradeScale(dataValue112)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn11Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn11Value / qnkiWeightage112).toFixed(2)}</p>
            </td>
            <td rowSpan="9">
              <p>{criteriaQn1Weightage}</p>
            </td>
            <td rowSpan="9">
              <p>{criteriaQn1Grade}</p>
            </td>
          </tr>
          <tr>
            <td>2.</td>
            <td>1.3.2</td>
            <td>QN</td>
            <td>
              Number of certificate / value-added courses / Diploma Programme/ online courses of MOOCS / SWAYAM / e_Pathshala/ NPTEL etc. where the students of the institution have enrolled and successfully completed
            </td>
            <td>{qnweightage113}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue113}
                value={dataValue113}
                onChange={(e) => {
                  setDataValue113(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue113)}</p>
            </td>
            <td>
              <p>{qnweightage113 * metricGradeScale(dataValue113)}</p>
            </td>
          </tr>
          <tr>
            <td>3.</td>
            <td>1.3.3</td>
            <td>QN</td>
            <td>
              Percentage of Programmes that have components of field projects / research projects / internships during last five years
            </td>
            <td>{qnweightage121}</td>
            <td rowspan="2">{qnkiWeightage121}</td>
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
          </tr>
          <tr>
            <td>4.</td>
            <td>1.4.1</td>
            <td>QN</td>
            <td>
              Structured feedback for curriculum and its transactions is regularly obtained from stakeholders like Students, Teachers, Employers, Alumni, Academic peers etc., and Feedback processes of the institution may be classified as follows:
              A. Feedback collected, analysed, action taken & communicated to relevant body and feedback hosted on the institutional website
              B. Feedback collected, analysed, action has been taken and communicated to the relevant body
              C. Feedback collected and analysed
              D. Feedback collected
              E. Feedback not collected
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
            <td>5.</td>
            <td>2.1.1</td>
            <td>QN</td>
            <td>
              Enrollment Percentage
            </td>
            <td>{qnweightage132}</td>
            <td rowspan="3">{qnkiWeightage132}</td>
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
            <td rowSpan="3">
              <p>{criteriaQn13Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteriaQn13Value / qnkiWeightage132).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>6.</td>
            <td>2.1.2</td>
            <td>QN</td>
            <td>
              Percentage of seats filled against reserved categories (SC, ST, OBC, etc.) as per applicable reservation policy for the first year admission year-wise during the last five years
            </td>
            <td>{qnweightage133}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue133}
                value={dataValue133}
                onChange={(e) => {
                  setDataValue133(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue133)}</p>
            </td>
            <td>
              <p>{qnweightage133 * metricGradeScale(dataValue133)}</p>
            </td>
          </tr>
          <tr>
            <td>7.</td>
            <td>2.2.2</td>
            <td>QN</td>
            <td>
              Student - Full time teacher ratio (Data for the latest completed academic year)
            </td>
            <td>{qnweightage134}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue134}
                value={dataValue134}
                onChange={(e) => {
                  setDataValue134(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue134)}</p>
            </td>
            <td>
              <p>{qnweightage134 * metricGradeScale(dataValue134)}</p>
            </td>
          </tr>
          <tr>
            <td>8.</td>
            <td>2.4.1</td>
            <td>QN</td>
            <td>
              Percentage of full time teachers appointed against the number of sanctioned posts during the last five years
            </td>
            <td>{qnweightage141}</td>
            <td rowspan="2">{qnkiWeightage141}</td>
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
            <td rowSpan="2">
              <p>{criteriaQn14Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn14Value / qnkiWeightage141).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>9.</td>
            <td>2.4.2</td>
            <td>QN</td>
            <td>
              Percentage of full time teachers with Ph.D./D.M/M.Ch./D.N.B/ Superspeciality/L.L.D/D.S.C/D.Litt. during the last five years            </td>
            <td>{qnweightage142}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue142}
                value={dataValue142}
                onChange={(e) => {
                  setDataValue142(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue142)}</p>
            </td>
            <td>
              <p>{qnweightage142 * metricGradeScale(dataValue142)}</p>
            </td>
          </tr>
          <tr>
            <td>10.</td>
            <td>2.4.3</td>
            <td>QN</td>
            <td>Average teaching experience of full time teachers (Data to be provided only for the latest completed academic year, in number of years)</td>
            <td>{qnweightage211}</td>
            <td rowspan="2">{qnkiWeightage211}</td>
            <td rowspan="11">{qncriteria2}</td>
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
            <td rowSpan="11">
              <p>{criteriaQn2Weightage}</p>
            </td>
            <td rowSpan="11">
              <p>{criteriaQn2Grade}</p>
            </td>
          </tr>
          <tr>
            <td>11.</td>
            <td>2.5.1</td>
            <td>QN</td>
            <td>
              Average number of days from the date of last semester-end/ year- end examination till the last date of declaration of results year-wise during the last five years            </td>
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
            <td>12.</td>
            <td>2.5.2</td>
            <td>QN</td>
            <td>
              Percentage of student complaints/grievances about evaluation against total number of students appeared in the examinations during the last five years
            </td>
            <td>{qnweightage222}</td>
            <td>{qnkiWeightage222}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue222}
                value={dataValue222}
                onChange={(e) => {
                  setDataValue222(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue222)}</p>
            </td>
            <td>
              <p>{qnweightage222 * metricGradeScale(dataValue222)}</p>
            </td>
            <td>
              <p>{criteriaQn22Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn22Value / qnkiWeightage222).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>13.</td>
            <td>2.5.3</td>
            <td>QN</td>
            <td>
              Status of automation of Examination division along with approved Examination Manual/ordinance
              A. 100% automation of entire division & implementation of Examination Management System (EMS)
              B. Only student registration, Hall ticket issue & Result Processing
              C. Only student registration and result processing
              D. Only result processing
              E. Only manual methodology
            </td>
            <td>{qnweightage233}</td>
            <td>{qnkiWeightage233}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue233}
                value={dataValue233}
                onChange={(e) => {
                  setDataValue233(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue233)}</p>
            </td>
            <td>
              <p>{qnweightage233 * metricGradeScale(dataValue233)}</p>
            </td>
            <td>
              <p>{criteriaQn23Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn23Value / qnkiWeightage233).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>14.</td>
            <td>2.6.2</td>
            <td>QN</td>
            <td>
              Pass percentage of students (excluding backlog students) (Data to be provided only for the latest completed academic year)
            </td>
            <td>{qnweightage241}</td>
            <td rowspan="3">{qnkiWeightage241}</td>
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
            <td rowSpan="3">
              <p>{criteriaQn24Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteriaQn24Value / qnkiWeightage241).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>15.</td>
            <td>2.7.1</td>
            <td>QN</td>
            <td>
              {" "}
              Online Student Satisfaction Survey regarding the teaching-learning process.
              ( Online survey to be conducted)
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
            <td>16.</td>
            <td>3.1.2</td>
            <td>QN</td>
            <td>
              The institution provides seed money to its teachers for research (average per year; INR in Lakhs)
            </td>
            <td>{qnweightage243}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue243}
                value={dataValue243}
                onChange={(e) => {
                  setDataValue243(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue243)}</p>
            </td>
            <td>
              <p>{qnweightage243 * metricGradeScale(dataValue243)}</p>
            </td>
          </tr>
          <tr>
            <td>17.</td>
            <td>3.1.3</td>
            <td>QN</td>
            <td>
              Percentage of teachers receiving national/ international fellowship/financial support by various agencies for advanced studies/ research during the last five years
            </td>
            <td>{qnweightage251}</td>
            <td rowspan="2">{qnkiWeightage251}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue251}
                value={dataValue251}
                onChange={(e) => {
                  setDataValue251(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue251)}</p>
            </td>
            <td>
              <p>{qnweightage251 * metricGradeScale(dataValue251)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn25Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn25Value / qnkiWeightage251).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>18.</td>
            <td>3.1.4</td>
            <td>QN</td>
            <td>
              Percentage of JRFs, SRFs among the enrolled PhD scholars in the institution during the last five years
            </td>
            <td>{qnweightage252}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue252}
                value={dataValue252}
                onChange={(e) => {
                  setDataValue252(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue252)}</p>
            </td>
            <td>
              <p>{qnweightage252 * metricGradeScale(dataValue252)}</p>
            </td>
          </tr>
          <tr>
            <td>19.</td>
            <td>3.2.1</td>
            <td>QN</td>
            <td>
              Research funding received by the institution and its faculties through Government and non-government sources such as industry, corporate houses, international bodies for research project, Endowment Research Chairs during the last five years (INR in Lakhs)
            </td>
            <td>{qnweightage263}</td>
            <td>{qnkiWeightage263}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue263}
                value={dataValue263}
                onChange={(e) => {
                  setDataValue263(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue263)}</p>
            </td>
            <td>
              <p>{qnweightage263 * metricGradeScale(dataValue263)}</p>
            </td>
            <td>
              <p>{criteriaQn26Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn26Value / qnkiWeightage263).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>20.</td>
            <td>3.2.2</td>
            <td>QN</td>
            <td>
              Number of research projects per teacher funded by government, non-government , industry, corporate houses, international bodies during the last five years
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
            <td>21.</td>
            <td>3.3.2</td>
            <td>QN</td>
            <td>
              Number of awards received for research/innovations by the institution/teachers/research scholars/students during the last five years            </td>
            <td>{qnweightage312}</td>
            <td rowspan="2">{qnkiWeightage312}</td>
            <td rowspan="20">{qncriteria3}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue312}
                value={dataValue312}
                onChange={(e) => {
                  setDataValue312(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue312)}</p>
            </td>
            <td>
              <p>{qnweightage312 * metricGradeScale(dataValue312)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn31Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn31Value / qnkiWeightage312).toFixed(2)}</p>
            </td>
            <td rowSpan="20">
              <p>{criteriaQn3Weightage}</p>
            </td>
            <td rowSpan="20">
              <p>{criteriaQn3Grade}</p>
            </td>
          </tr>
          <tr>
            <td>22.</td>
            <td>3.4.1</td>
            <td>QN</td>
            <td>
              The institution ensures implementation of its stated Code of Ethics for research
              3.4.1.1The institution has a stated Code of Ethics for research and the implementation of which is ensured through the following:
              1. Inclusion of research ethics in the research methodology course work
              2. Presence of institutional Ethics committees (Animal, chemical,bio-ethics etc.,)
              3. Plagiarism check
              4. Research Advisory Committee
              Options:
              A. All of the above
              B. Any 3 of the above
              C. Any 2 of the above
              D. Any 1 of the above
              E. None of the above(Opt any one)
            </td>
            <td>{qnweightage313}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue313}
                value={dataValue313}
                onChange={(e) => {
                  setDataValue313(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue313)}</p>
            </td>
            <td>
              <p>{qnweightage313 * metricGradeScale(dataValue313)}</p>
            </td>
          </tr>
          <tr>
            <td>23.</td>
            <td>3.4.2</td>
            <td>QN</td>
            <td>
              Number of Patents awarded during the last five years
            </td>
            <td>{qnweightage321}</td>
            <td rowspan="4">{qnkiWeightage321}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue321}
                value={dataValue321}
                onChange={(e) => {
                  setDataValue321(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue321)}</p>
            </td>
            <td>
              <p>{qnweightage321 * metricGradeScale(dataValue321)}</p>
            </td>
            <td rowSpan="4">
              <p>{criteriaQn32Value}</p>
            </td>
            <td rowSpan="4">
              <p>{parseFloat(criteriaQn32Value / qnkiWeightage321).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>24.</td>
            <td>3.4.3</td>
            <td>QN</td>
            <td>
              Number of Ph.Ds awarded per recognized guide during the last five years
            </td>
            <td>{qnweightage322}</td>
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
          </tr>
          <tr>
            <td>25.</td>
            <td>3.4.4</td>
            <td>QN</td>
            <td>Number of research papers published per teacher in the Journals as notified on UGC CARE list during the last five years</td>
            <td>{qnweightage323}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue323}
                value={dataValue323}
                onChange={(e) => {
                  setDataValue323(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue323)}</p>
            </td>
            <td>
              <p>{qnweightage323 * metricGradeScale(dataValue323)}</p>
            </td>
          </tr>
          <tr>
            <td>26.</td>
            <td>3.4.5</td>
            <td>QN</td>
            <td>
              Number of books and chapters in edited volumes published per teacher during the last five years
            </td>
            <td>{qnweightage324}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue324}
                value={dataValue324}
                onChange={(e) => {
                  setDataValue324(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue324)}</p>
            </td>
            <td>
              <p>{qnweightage324 * metricGradeScale(dataValue324)}</p>
            </td>
          </tr>
          <tr>
            <td>27.</td>
            <td>3.4.6</td>
            <td>QN</td>
            <td>
              E-content is developed by teachers :
              1. For e-PG-Pathshala
              2. For CEC (Undergraduate)
              3. For SWAYAM
              4. For other MOOCs platforms
              5. Any other Government Initiatives
              6. For Institutional LMS
              Options:
              A. Any 4 or more of the above
              B. Any 3 of the above
              C. Any 2 of the above
              D. Any 1 of the above
              E. None of the above
            </td>
            <td>{qnweightage332}</td>
            <td>{qnkiWeightage332}</td>
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
            <td>
              <p>{criteriaQn33Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn33Value / qnkiWeightage332).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>28.</td>
            <td>3.4.7</td>
            <td>QN</td>
            <td>
              Bibliometrics of the publications during the last five years based on average Citation Index in Scopus/ Web of Science/PubMed
              Data to be provided for the last five years:
              ? Title of the paper
              ? Name of the author
              ? Title of the journal
              ? Year of publication
              ? Citation Index
            </td>
            <td>{qnweightage341}</td>
            <td rowspan="6">{qnkiWeightage341}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue341}
                value={dataValue341}
                onChange={(e) => {
                  setDataValue341(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue341)}</p>
            </td>
            <td>
              <p>{qnweightage341 * metricGradeScale(dataValue341)}</p>
            </td>
            <td rowSpan="6">
              <p>{criteriaQn34Value}</p>
            </td>
            <td rowSpan="6">
              <p>{parseFloat(criteriaQn34Value / qnkiWeightage341).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>29.</td>
            <td>3.4.8</td>
            <td>QN</td>
            <td>
              Bibliometrics of the publications during the last five years based on Scopus/ Web of Science – h-Index of the University
              Data to be provided for the last five years:
              ? Title of the paper
              ? Name of the author
              ? Title of the journal
              ? Year of publication
              ? H index
            </td>
            <td>{qnweightage342}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue342}
                value={dataValue342}
                onChange={(e) => {
                  setDataValue342(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue342)}</p>
            </td>
            <td>
              <p>{qnweightage342 * metricGradeScale(dataValue342)}</p>
            </td>
          </tr>
          <tr>
            <td>30.</td>
            <td>3.5.1</td>
            <td>QN</td>
            <td>
              Revenue generated from consultancy and corporate training during the last five years (INR in Lakhs)
            </td>
            <td>{qnweightage343}</td>
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
          </tr>
          <tr>
            <td>31.</td>
            <td>3.6.2</td>
            <td>QN</td>
            <td>
              Number of extension and outreach programs conducted through organized forums by the institution during the last five years
            </td>
            <td>{qnweightage343}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue344}
                value={dataValue344}
                onChange={(e) => {
                  setDataValue344(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue344)}</p>
            </td>
            <td>
              <p>{qnweightage343 * metricGradeScale(dataValue344)}</p>
            </td>
          </tr>
          <tr>
            <td>32.</td>
            <td>3.7.1</td>
            <td>QN</td>
            <td>
              Number of functional MoUs /linkage with institutions/ industries in India and abroad for internship, on-the-job training, project work, student / faculty exchange and collaborative research during the last five years
            </td>
            <td>{qnweightage345}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue345}
                value={dataValue345}
                onChange={(e) => {
                  setDataValue345(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue345)}</p>
            </td>
            <td>
              <p>{qnweightage345 * metricGradeScale(dataValue345)}</p>
            </td>
          </tr>
          <tr>
            <td>33.</td>
            <td>4.1.2</td>
            <td>QN</td>
            <td>
              Percentage of expenditure excluding salary, for infrastructure development and augmentation during the last five years (INR in Lakhs)
            </td>
            <td>{qnweightage346}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue346}
                value={dataValue346}
                onChange={(e) => {
                  setDataValue346(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue346)}</p>
            </td>
            <td>
              <p>{qnweightage346 * metricGradeScale(dataValue346)}</p>
            </td>
          </tr>
          <tr>
            <td>34.</td>
            <td>4.2.2</td>
            <td>QN</td>
            <td>
              Percentage expenditure for purchase of books/ e-books and subscription to journals/e-journals during the last five years (INR in Lakhs)
            </td>
            <td>{qnweightage351}</td>
            <td rowspan="2">{qnkiWeightage351}</td>
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
            <td rowSpan="2">
              <p>{criteriaQn35Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn35Value / qnkiWeightage351).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>35.</td>
            <td>4.3.2</td>
            <td>QN</td>
            <td>
              Student - Computer ratio (Data to be provided only for the latest completed academic year)
            </td>
            <td>{qnweightage352}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue352}
                value={dataValue352}
                onChange={(e) => {
                  setDataValue352(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue352)}</p>
            </td>
            <td>
              <p>{qnweightage352 * metricGradeScale(dataValue352)}</p>
            </td>
          </tr>
          <tr>
            <td>36.</td>
            <td>4.3.3</td>
            <td>QN</td>
            <td>
              Institution has the following Facilities for e-content and other resource development
              1. Audio visual center, mixing equipment, editing facilities and Media Studio
              2. Lecture Capturing System(LCS)
              3. Central Instrumentation Centre
              4. Animal House
              5. Museum
              6. Business Lab
              7. Research/statistical database
              8. Moot court
              9. Theatre
              10. Art Gallery
              11. Any other facility to support research
              Options:
              A. Any 7 or more of the above
              B. Any 6 of the above
              C. Any 5 of the above
              D. Any 3-4 of the above
              E. Any 2 or below
            </td>
            <td>{qnweightage362}</td>
            <td rowspan="3">{qnkiWeightage362}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue362}
                value={dataValue362}
                onChange={(e) => {
                  setDataValue362(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue362)}</p>
            </td>
            <td>
              <p>{qnweightage362 * metricGradeScale(dataValue362)}</p>
            </td>
            <td rowSpan="3">
              <p>{criteriaQn36Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteriaQn36Value / qnkiWeightage362).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>37.</td>
            <td>4.4.1</td>
            <td>QN</td>
            <td>
              Percentage expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component during the last five years
            </td>
            <td>{qnweightage363}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue363}
                value={dataValue363}
                onChange={(e) => {
                  setDataValue363(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue363)}</p>
            </td>
            <td>
              <p>{qnweightage363 * metricGradeScale(dataValue363)}</p>
            </td>
          </tr>
          <tr>
            <td>38.</td>
            <td>5.1.1</td>
            <td>QN</td>
            <td>
              Percentage of students benefited by scholarships and freeships provided by the institution, Government and non-government bodies, industries, individuals, philanthropists during the last five years
            </td>
            <td>{qnweightage364}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue364}
                value={dataValue364}
                onChange={(e) => {
                  setDataValue364(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue364)}</p>
            </td>
            <td>
              <p>{qnweightage364 * metricGradeScale(dataValue364)}</p>
            </td>
          </tr>
          <tr>
            <td>39.</td>
            <td>5.1.3</td>
            <td>QN</td>
            <td>
              Following Capacity development and skills enhancement initiatives are undertaken by the institution for: 1. Soft skills 2. Language and communication skills 3. Life skills (Yoga, physical fitness, health and hygiene, self-employment and entrepreneurial skills) 4. Awareness of trends in technology
              Options:
              A. All of the above
              B. Any 3 of the above
              C. Any 2 of the above
              D. Any1of the above
              E. None of the above
            </td>
            <td>{qnweightage371}</td>
            <td rowspan="2">{qnkiWeightage371}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue371}
                value={dataValue371}
                onChange={(e) => {
                  setDataValue371(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue371)}</p>
            </td>
            <td>
              <p>{qnweightage371 * metricGradeScale(dataValue371)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn37Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn37Value / qnkiWeightage371).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>40.</td>
            <td>5.1.4</td>
            <td>QN</td>
            <td>
              The Institution adopts the following for redressal of student grievances including sexual harassment and ragging cases
              1. Implementation of guidelines of statutory/regulatory bodies
              2. Organisation-wide awareness and undertakings on policies with zero tolerance
              3. Mechanisms for submission of online/offline students’ grievances
              4. Timely redressal of the grievances through appropriate committees
              A. All of the above
              B. Any 3 of the above
              C. Any 2 of the above
              D. Any1 of the above
              E. None of the above
            </td>
            <td>{qnweightage372}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue372}
                value={dataValue372}
                onChange={(e) => {
                  setDataValue372(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue372)}</p>
            </td>
            <td>
              <p>{qnweightage372 * metricGradeScale(dataValue372)}</p>
            </td>
          </tr>
          <tr>
            <td>41.</td>
            <td>5.2.1</td>
            <td>QN</td>
            <td>
              Percentage of placement of outgoing students during the last five years)
            </td>
            <td>{qnweightage413}</td>
            <td rowspan="2">{qnkiWeightage413}</td>
            <td rowspan="9">{qncriteria4}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue413}
                value={dataValue413}
                onChange={(e) => {
                  setDataValue413(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue413)}</p>
            </td>
            <td>
              <p>{qnweightage413 * metricGradeScale(dataValue413)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteriaQn41Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteriaQn41Value / qnkiWeightage413).toFixed(2)}</p>
            </td>
            <td rowSpan="9">
              <p>{criteriaQn4Weightage}</p>
            </td>
            <td rowSpan="9">
              <p>{criteriaQn4Grade}</p>
            </td>
          </tr>
          <tr>
            <td>42.</td>
            <td>5.2.2</td>
            <td>QN</td>
            <td>
              Percentage of graduated students who have progressed to higher education year-wise during last five years
            </td>
            <td>{qnweightage414}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue414}
                value={dataValue414}
                onChange={(e) => {
                  setDataValue414(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue414)}</p>
            </td>
            <td>
              <p>{qnweightage414 * metricGradeScale(dataValue414)}</p>
            </td>
          </tr>
          <tr>
            <td>43.</td>
            <td>5.2.3</td>
            <td>QN</td>
            <td>
              Percentage of students qualifying in state/National/International level Examination during last five years (eg. SLET, NET, UPSC etc)
            </td>
            <td>{qnweightage422}</td>
            <td rowspan="3">{qnkiWeightage422}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue422}
                value={dataValue422}
                onChange={(e) => {
                  setDataValue422(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue422)}</p>
            </td>
            <td>
              <p>{qnweightage422 * metricGradeScale(dataValue422)}</p>
            </td>
            <td rowSpan="3">
              <p>{criteriaQn42Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteriaQn42Value / qnkiWeightage422).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>44.</td>
            <td>5.3.1</td>
            <td>QN</td>
            <td>
              Number of awards/medals won by students for outstanding performance in sports/cultural activities at inter-university/state/national/international events (award for a team event should be counted as one) during the last five years
            </td>
            <td>{qnweightage423}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue423}
                value={dataValue423}
                onChange={(e) => {
                  setDataValue423(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue423)}</p>
            </td>
            <td>
              <p>{qnweightage423 * metricGradeScale(dataValue423)}</p>
            </td>
          </tr>
          <tr>
            <td>45.</td>
            <td>5.3.3</td>
            <td>QN</td>
            <td>
              The institution conducts /organizes following activities
              1. Sports competitions/events
              2.Cultural competitions/events
              3. Technical fest/academic fests
              4. Any other events through active clubs and forums
              Options:
              A. All four of the above
              B. Any three of the above
              C. Any two of the above
              D. Any one of the above
              E. None of the above
            </td>
            <td>{qnweightage424}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue424}
                value={dataValue424}
                onChange={(e) => {
                  setDataValue424(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue424)}</p>
            </td>
            <td>
              <p>{qnweightage424 * metricGradeScale(dataValue424)}</p>
            </td>
          </tr>
          <tr>
            <td>46.</td>
            <td>5.4.1</td>
            <td>QN</td>
            <td>
              Alumni contribution during the last five years (INR in lakhs)to the University through registered Alumni Association
            </td>
            <td>{qnweightage432}</td>
            <td rowspan="3">{qnkiWeightage432}</td>
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
            <td rowSpan="3">
              <p>{criteriaQn43Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteriaQn43Value / qnkiWeightage432).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>47.</td>
            <td>6.2.2</td>
            <td>QN</td>
            <td>Institution Implements e-governance in its operations
              6.2.2.1 e-governance is implemented covering the following areas of operations:
              1. Administration including complaint management
              2. Finance and Accounts
              3. Student Admission and Support
              4. Examinations
              Options:
              A. All of the above
              B. Any3 of the above
              C. Any2 of the above
              D. Any1 of the above
              E. None of the above</td>
            <td>{qnweightage433}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue433}
                value={dataValue433}
                onChange={(e) => {
                  setDataValue433(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue433)}</p>
            </td>
            <td>
              <p>{qnweightage433 * metricGradeScale(dataValue433)}</p>
            </td>
          </tr>
          <tr>
            <td>48.</td>
            <td>6.3.2</td>
            <td>QN</td>
            <td>
              Percentage of teachers provided with financial support to attend conferences/workshops and towards membership fee of professional bodies during the last five years            </td>
            <td>{qnweightage434}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue434}
                value={dataValue434}
                onChange={(e) => {
                  setDataValue434(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue434)}</p>
            </td>
            <td>
              <p>{qnweightage434 * metricGradeScale(dataValue434)}</p>
            </td>
          </tr>
          <tr>
            <td>49.</td>
            <td>6.3.3</td>
            <td>QN</td>
            <td>
              Percentage of teachers undergoing online/ face-to-face Faculty Development Programmes (FDP)/ Management Development Programs (MDP) during the last five years
              (Professional Development Programmes, Orientation/Induction Programmes, Refresher Course, Short Term Course )
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
            <td>50.</td>
            <td>6.4.2</td>
            <td>QN</td>
            <td>
              Funds / Grants received from government bodies/non government and philanthropists during the last five years for development and maintenance of infrastructure (not covered under Criteria III and V ) (INR in Lakhs)
            </td>
            <td>{qnweightage511}</td>
            <td rowspan="5">{qnkiWeightage511}</td>
            <td rowspan="11">{qncriteria5}</td>
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
            <td rowSpan="5">
              <p>{criteriaQn51Value}</p>
            </td>
            <td rowSpan="5">
              <p>{parseFloat(criteriaQn51Value / qnkiWeightage511).toFixed(2)}</p>
            </td>
            <td rowSpan="11">
              <p>{criteriaQn5Weightage}</p>
            </td>
            <td rowSpan="11">
              <p>{criteriaQn5Grade}</p>
            </td>
          </tr>
          <tr>
            <td>51.</td>
            <td>6.5.2</td>
            <td>QN</td>
            <td>
              Institution has adopted the following for Quality assurance:
              1. Academic and Administrative Audit (AAA) and follow up action taken
              2.Conferences, Seminars, Workshops on quality conducted
              3. Collaborative quality initiatives with other institution(s)
              4.Orientation programme on quality issues for teachers and students
              5. Participation in NIRF and other recognized ranking like Shanghai Ranking, QS Ranking Times Ranking etc
              6.Any other quality audit recognized by state, national or international agencies
              Options:
              A. Any 5 or more of the above
              B. Any4 of the above
              C. Any3 of the above
              D. Any2 of the above
              E. Any1of the above
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
            <td>52.</td>
            <td>7.1.10</td>
            <td>QN</td>
            <td>
              The Institution has a prescribed code of conduct for students, teachers, administrators and other staff and conducts periodic programmes in this regard.
              1. The institutional Code of Conduct principles are displayed on the website
              2. There is a committee to monitor adherence to the institutional Code of Conduct principles
              3. Institution organizes professional ethics programmes for students,
              teachers, administrators and other staff
              4. Annual awareness programmes on Code of Conduct are organized
              Options:
              A. All of the above
              B. Any3 of the above
              C. Any2 of the above
              D. Any1of the above
              E. None of the above
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
            <td>53.</td>
            <td>7.1.2</td>
            <td>QN</td>
            <td>
              The Institution has facilities for alternate sources of energy and energy conservation measures
              1. Solar energy
              2. Biogas plant
              3. Wheeling to the Grid
              4. Sensor-based energy conservation
              5. Use of LED bulbs/ power efficient equipment
              6. Wind will or any other clean green energy
              Options:
              A. Any 4 or more of the above
              B. Any3 of the above
              C. Any2 of the above
              D. Any1of the above
              E. None of the above
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
            <td>54.</td>
            <td>7.1.4</td>
            <td>QN</td>
            <td>
              Water conservation facilities available in the Institution:
              1. Rainwater harvesting
              2. Borewell /Open well recharge
              3. Construction of tanks and bunds
              4. Wastewater recycling
              5. Maintenance of water bodies and distribution system in the campus
              Options:
              A. Any 4 or all of the above
              B. Any3 of the above
              C. Any2 of the above
              D. Any1of the above
              E. None of the above
            </td>
            <td>{qnweightage515}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue515}
                value={dataValue515}
                onChange={(e) => {
                  setDataValue515(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue515)}</p>
            </td>
            <td>
              <p>{qnweightage515 * metricGradeScale(dataValue515)}</p>
            </td>
          </tr>
          <tr>
            <td>55.</td>
            <td>7.1.6</td>
            <td>QN</td>
            <td>
              Quality audits on environment and energy are regularly undertaken by the institution
              7.1.6.1.The institutional environment and energy initiatives are confirmed through the following
              1.Green audit /Environment audit
              2. Energy audit
              3.Clean and green campus initiatives
              4. Beyond the campus environmental promotion and sustainability activities
              Options:
              A. All of the above
              B. Any3 of the above
              C. Any2 of the above
              D. Any1of the above
              E. None of the above
            </td>
            <td>{qnweightage521}</td>
            <td rowspan="3">{qnkiWeightage521}</td>
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
            <td rowSpan="3">
              <p>{criteriaQn52Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteriaQn52Value / qnkiWeightage521).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>56.</td>
            <td>5.2.2</td>
            <td>QN</td>
            <td>
              Percentage of student progression to higher education (previous
              graduating batch).
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
            <td>57.</td>
            <td>5.2.3</td>
            <td>QN</td>
            <td>
              Average percentage of students qualifying in state/national/
              international level examinations during the last five years (eg:
              IIT-JAM/CLAT/ NET/SLET/GATE/ GMAT/CAT/GRE/ TOEFL/ Civil
              Services/State government examinations, etc.)
            </td>
            <td>{qnweightage523}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue523}
                value={dataValue523}
                onChange={(e) => {
                  setDataValue523(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue523)}</p>
            </td>
            <td>
              <p>{qnweightage523 * metricGradeScale(dataValue523)}</p>
            </td>
          </tr>
          <tr>
            <td>58.</td>
            <td>5.3.1</td>
            <td>QN</td>
            <td>
              Number of awards/medals for outstanding performance in
              sports/cultural activities at inter-university / state /national /
              international events (award for a team event should be counted as
              one) during the last five years.
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
            <td>59.</td>
            <td>5.3.3</td>
            <td>QN</td>
            <td>
              Average number of sports and cultural events / competitions
              organised by the institution per year.
            </td>
            <td>{qnweightage533}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue533}
                value={dataValue533}
                onChange={(e) => {
                  setDataValue533(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue533)}</p>
            </td>
            <td>
              <p>{qnweightage533 * metricGradeScale(dataValue533)}</p>
            </td>
          </tr>
          <tr>
            <td>60.</td>
            <td>5.4.2</td>
            <td>QN</td>
            <td>
              Presence of an active Student Council & representation of students
              on academic & administrative bodies/committees of the institution.
            </td>
            <td>{qnweightage542}</td>
            <td>{qnkiWeightage542}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue542}
                value={dataValue542}
                onChange={(e) => {
                  setDataValue542(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue542)}</p>
            </td>
            <td>
              <p>{qnweightage542 * metricGradeScale(dataValue542)}</p>
            </td>
            <td>
              <p>{criteriaQn54Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn54Value / qnkiWeightage542).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>61.</td>
            <td>6.2.3</td>
            <td>QN</td>
            <td>Implementation of e-governance in areas of operation.</td>
            <td>{qnweightage623}</td>
            <td>{qnkiWeightage623}</td>
            <td rowspan="6">{qncriteria6}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue623}
                value={dataValue623}
                onChange={(e) => {
                  setDataValue623(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue623)}</p>
            </td>
            <td>
              <p>{qnweightage623 * metricGradeScale(dataValue623)}</p>
            </td>
            <td>
              <p>{criteriaQn62Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn62Value / qnkiWeightage623).toFixed(2)}</p>
            </td>
            <td rowSpan="6">
              <p>{criteriaQn6Weightage}</p>
            </td>
            <td rowSpan="6">
              <p>{criteriaQn6Grade}</p>
            </td>
          </tr>
          <tr>
            <td>62.</td>
            <td>6.3.2</td>
            <td>QN</td>
            <td>
              Average percentage of teachers provided with financial support to
              attend conferences / workshops and towards membership fee of
              professional bodies during the last five years.
            </td>
            <td>{qnweightage632}</td>
            <td rowspan="3">{qnkiWeightage632}</td>
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
            <td rowSpan="3">
              <p>{criteriaQn63Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteriaQn63Value / qnkiWeightage632).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>63.</td>
            <td>6.3.3</td>
            <td>QN</td>
            <td>
              Average number of professional development / administrative
              training Programmes organized by the institution for teaching and
              non-teaching staff during the last five years.
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
            <td>64.</td>
            <td>6.3.4</td>
            <td>QN</td>
            <td>
              The institution provides seed money to its teachers for research.
            </td>
            <td>{qnweightage634}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue634}
                value={dataValue634}
                onChange={(e) => {
                  setDataValue634(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue634)}</p>
            </td>
            <td>
              <p>{qnweightage634 * metricGradeScale(dataValue634)}</p>
            </td>
          </tr>
          <tr>
            <td>65.</td>
            <td>6.4.2</td>
            <td>QN</td>
            <td>
              Funds / Grants received from non-government bodies, individuals,
              philanthropists during the last five years (not covered in
              Criterion III and V) (INR in Lakhs).
            </td>
            <td>{qnweightage642}</td>
            <td>{qnkiWeightage642}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue642}
                value={dataValue642}
                onChange={(e) => {
                  setDataValue642(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue642)}</p>
            </td>
            <td>
              <p>{qnweightage642 * metricGradeScale(dataValue642)}</p>
            </td>
            <td>
              <p>{criteriaQn64Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn64Value / qnkiWeightage642).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>66.</td>
            <td>6.5.3</td>
            <td>QN</td>
            <td>Quality assurance initiatives of the institution include</td>
            <td>{qnweightage653}</td>
            <td>{qnkiWeightage653}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue653}
                value={dataValue653}
                onChange={(e) => {
                  setDataValue653(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue653)}</p>
            </td>
            <td>
              <p>{qnweightage653 * metricGradeScale(dataValue653)}</p>
            </td>
            <td>
              <p>{criteriaQn65Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteriaQn65Value / qnkiWeightage653).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>67.</td>
            <td>7.1.2</td>
            <td>QN</td>
            <td>
              The Institution has facilities for alternate sources of energy and
              energy conservation measures.
            </td>
            <td>{qnweightage712}</td>
            <td rowspan="6">{qnkiWeightage712}</td>
            <td rowspan="6">{qncriteria7}</td>
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
            <td rowSpan="6">
              <p>{criteriaQn71Value}</p>
            </td>
            <td rowSpan="6">
              <p>{parseFloat(criteriaQn71Value / qnkiWeightage712).toFixed(2)}</p>
            </td>
            <td rowSpan="6">
              <p>{criteriaQn7Weightage}</p>
            </td>
            <td rowSpan="6">
              <p>{criteriaQn7Grade}</p>
            </td>
          </tr>
          <tr>
            <td>68.</td>
            <td>7.1.4</td>
            <td>QN</td>
            <td>Water conservation facilities available in the Institution.</td>
            <td>{qnweightage714}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue714}
                value={dataValue714}
                onChange={(e) => {
                  setDataValue714(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue714)}</p>
            </td>
            <td>
              <p>{qnweightage714 * metricGradeScale(dataValue714)}</p>
            </td>
          </tr>
          <tr>
            <td>69.</td>
            <td>7.1.5</td>
            <td>QN</td>
            <td>Green campus initiatives include.</td>
            <td>{qnweightage715}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue715}
                value={dataValue715}
                onChange={(e) => {
                  setDataValue715(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue715)}</p>
            </td>
            <td>
              <p>{qnweightage715 * metricGradeScale(dataValue715)}</p>
            </td>
          </tr>
          <tr>
            <td>70.</td>
            <td>7.1.6</td>
            <td>QN</td>
            <td>
              Quality audits on environment and energy are regularly undertaken
              by the Institution and any awards received for such green campus
              initiatives.
            </td>
            <td>{qnweightage716}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue716}
                value={dataValue716}
                onChange={(e) => {
                  setDataValue716(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue716)}</p>
            </td>
            <td>
              <p>{qnweightage716 * metricGradeScale(dataValue716)}</p>
            </td>
          </tr>
          <tr>
            <td>71.</td>
            <td>7.1.7</td>
            <td>QN</td>
            <td>
              The Institution has disabled-friendly, barrier free environment.
            </td>
            <td>{qnweightage717}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue717}
                value={dataValue717}
                onChange={(e) => {
                  setDataValue717(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue717)}</p>
            </td>
            <td>
              <p>{qnweightage717 * metricGradeScale(dataValue717)}</p>
            </td>
          </tr>
          <tr>
            <td>72.</td>
            <td>7.1.10</td>
            <td>QN</td>
            <td>
              The Institution has a prescribed code of conduct for students,
              teachers, administrators and other staff and conducts periodic
              programmes in this regard.
            </td>
            <td>{qnweightage7110}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue7110}
                value={dataValue7110}
                onChange={(e) => {
                  setDataValue7110(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{metricGradeScale(dataValue7110)}</p>
            </td>
            <td>
              <p>{qnweightage7110 * metricGradeScale(dataValue7110)}</p>
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
