import React, { useState } from "react";
import { toast } from "react-toastify";
import { resources } from "../../../appConstants";
import "./QL-style.css";

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
  { id: "Select", grade: "Select" },
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

  // Criteria 22
  const [dataValue221, setDataValue221] = useState("");
  const [dataValueGrade221, setDataValueGrade221] = useState();

  // Criteria 23
  const [dataValue231, setDataValue231] = useState("");
  const [dataValueGrade231, setDataValueGrade231] = useState();
  const [dataValue232, setDataValue232] = useState("");
  const [dataValueGrade232, setDataValueGrade232] = useState();
  const [dataValue234, setDataValue234] = useState("");
  const [dataValueGrade234, setDataValueGrade234] = useState();

  // Criteria 25
  const [dataValue253, setDataValue253] = useState("");
  const [dataValueGrade253, setDataValueGrade253] = useState();

  // Criteria 26
  const [dataValue261, setDataValue261] = useState("");
  const [dataValueGrade261, setDataValueGrade261] = useState();
  const [dataValue262, setDataValue262] = useState("");
  const [dataValueGrade262, setDataValueGrade262] = useState();

  // Criteria 31
  const [dataValue311, setDataValue311] = useState("");
  const [dataValueGrade311, setDataValueGrade311] = useState();

  // Criteria 33
  const [dataValue331, setDataValue331] = useState("");
  const [dataValueGrade331, setDataValueGrade331] = useState();

  // Criteria 36
  const [dataValue361, setDataValue361] = useState("");
  const [dataValueGrade361, setDataValueGrade361] = useState();

  // Criteria 41
  const [dataValue411, setDataValue411] = useState("");
  const [dataValueGrade411, setDataValueGrade411] = useState();
  const [dataValue412, setDataValue412] = useState("");
  const [dataValueGrade412, setDataValueGrade412] = useState();

  // Criteria 42
  const [dataValue421, setDataValue421] = useState("");
  const [dataValueGrade421, setDataValueGrade421] = useState();

  // Criteria 43
  const [dataValue431, setDataValue431] = useState("");
  const [dataValueGrade431, setDataValueGrade431] = useState();

  // Criteria 44
  const [dataValue442, setDataValue442] = useState("");
  const [dataValueGrade442, setDataValueGrade442] = useState();

  // Criteria 53
  const [dataValue532, setDataValue532] = useState("");
  const [dataValueGrade532, setDataValueGrade532] = useState();

  // Criteria 54
  const [dataValue541, setDataValue541] = useState("");
  const [dataValueGrade541, setDataValueGrade541] = useState();

  // Criteria 61
  const [dataValue611, setDataValue611] = useState("");
  const [dataValueGrade611, setDataValueGrade611] = useState();
  const [dataValue612, setDataValue612] = useState("");
  const [dataValueGrade612, setDataValueGrade612] = useState();

  // Criteria 62
  const [dataValue621, setDataValue621] = useState("");
  const [dataValueGrade621, setDataValueGrade621] = useState();
  const [dataValue622, setDataValue622] = useState("");
  const [dataValueGrade622, setDataValueGrade622] = useState();

  // Criteria 63
  const [dataValue631, setDataValue631] = useState("");
  const [dataValueGrade631, setDataValueGrade631] = useState();

  // Criteria 64
  const [dataValue641, setDataValue641] = useState("");
  const [dataValueGrade641, setDataValueGrade641] = useState();
  const [dataValue643, setDataValue643] = useState("");
  const [dataValueGrade643, setDataValueGrade643] = useState();

  // Criteria 65
  const [dataValue651, setDataValue651] = useState("");
  const [dataValueGrade651, setDataValueGrade651] = useState();
  const [dataValue652, setDataValue652] = useState("");
  const [dataValueGrade652, setDataValueGrade652] = useState();

  // Criteria 71
  const [dataValue711, setDataValue711] = useState("");
  const [dataValueGrade711, setDataValueGrade711] = useState();
  const [dataValue713, setDataValue713] = useState("");
  const [dataValueGrade713, setDataValueGrade713] = useState();
  const [dataValue718, setDataValue718] = useState("");
  const [dataValueGrade718, setDataValueGrade718] = useState();
  const [dataValue719, setDataValue719] = useState("");
  const [dataValueGrade719, setDataValueGrade719] = useState();
  const [dataValue7111, setDataValue7111] = useState("");
  const [dataValueGrade7111, setDataValueGrade7111] = useState();

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

  const qlweightage221 = 15;
  const qlkiWeightage22 = 15;
  const qlweightage231 = 15;
  const qlweightage232 = 15;
  const qlweightage234 = 15;
  const qlkiWeightage23 = 40;
  const qlweightage253 = 15;
  const qlkiWeightage25 = 15;
  const qlweightage261 = 20;
  const qlweightage262 = 10;
  const qlkiWeightage26 = 30;
  const qlcriteria2 = 100;

  const qlweightage311 = 6;
  const qlkiWeightage31 = 6;
  const qlweightage331 = 5;
  const qlkiWeightage33 = 5;
  const qlweightage361 = 10;
  const qlkiWeightage36 = 10;
  const qlcriteria3 = 21;

  const qlweightage411 = 6;
  const qlweightage412 = 4;
  const qlkiWeightage41 = 10;
  const qlweightage421 = 5;
  const qlkiWeightage42 = 5;
  const qlweightage431 = 8;
  const qlkiWeightage43 = 8;
  const qlweightage442 = 10;
  const qlkiWeightage44 = 10;
  const qlcriteria4 = 33;

  const qlweightage532 = 10;
  const qlkiWeightage53 = 10;
  const qlweightage541 = 5;
  const qlkiWeightage54 = 5;
  const qlcriteria5 = 15;

  const qlweightage611 = 5;
  const qlweightage612 = 5;
  const qlkiWeightage61 = 10;
  const qlweightage621 = 2;
  const qlweightage622 = 4;
  const qlkiWeightage62 = 6;
  const qlweightage631 = 4;
  const qlkiWeightage63 = 4;
  const qlweightage641 = 4;
  const qlweightage643 = 6;
  const qlkiWeightage64 = 10;
  const qlweightage651 = 10;
  const qlweightage652 = 10;
  const qlkiWeightage65 = 20;
  const qlcriteria6 = 50;

  const qlweightage711 = 5;
  const qlweightage713 = 4;
  const qlweightage718 = 5;
  const qlweightage719 = 4;
  const qlweightage7111 = 5;
  const qlkiWeightage71 = 28;
  const qlweightage721 = 30;
  const qlkiWeightage72 = 30;
  const qlweightage731 = 20;
  const qlkiWeightage73 = 20;
  const qlcriteria7 = 88;

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
      qlweightage111 * metricGradeScale(dataValueGrade111) +
      qlweightage131 * metricGradeScale(dataValueGrade131)
    );
  }
  function qlcriteria2Value() {
    return (
      qlweightage221 * metricGradeScale(dataValueGrade221) +
      qlweightage231 * metricGradeScale(dataValueGrade231) +
      qlweightage232 * metricGradeScale(dataValueGrade232) +
      qlweightage234 * metricGradeScale(dataValueGrade234) +
      qlweightage253 * metricGradeScale(dataValueGrade253) +
      qlweightage261 * metricGradeScale(dataValueGrade261) +
      qlweightage262 * metricGradeScale(dataValueGrade262)
    );
  }
  function qlcriteria3Value() {
    return (
      qlweightage311 * metricGradeScale(dataValueGrade311) +
      qlweightage331 * metricGradeScale(dataValueGrade331) +
      qlweightage361 * metricGradeScale(dataValueGrade361)
    );
  }
  function qlcriteria4Value() {
    return (
      qlweightage411 * metricGradeScale(dataValueGrade411) +
      qlweightage412 * metricGradeScale(dataValueGrade412) +
      qlweightage421 * metricGradeScale(dataValueGrade421) +
      qlweightage431 * metricGradeScale(dataValueGrade431) +
      qlweightage442 * metricGradeScale(dataValueGrade442)
    );
  }
  function qlcriteria5Value() {
    return (
      qlweightage532 * metricGradeScale(dataValueGrade532) +
      qlweightage541 * metricGradeScale(dataValueGrade541)
    );
  }
  function qlcriteria6Value() {
    return (
      qlweightage611 * metricGradeScale(dataValueGrade611) +
      qlweightage612 * metricGradeScale(dataValueGrade612) +
      qlweightage621 * metricGradeScale(dataValueGrade621) +
      qlweightage622 * metricGradeScale(dataValueGrade622) +
      qlweightage631 * metricGradeScale(dataValueGrade631) +
      qlweightage641 * metricGradeScale(dataValueGrade641) +
      qlweightage643 * metricGradeScale(dataValueGrade643) +
      qlweightage651 * metricGradeScale(dataValueGrade651) +
      qlweightage652 * metricGradeScale(dataValueGrade652)
    );
  }
  function qlcriteria7Value() {
    return (
      qlweightage711 * metricGradeScale(dataValueGrade711) +
      qlweightage713 * metricGradeScale(dataValueGrade713) +
      qlweightage718 * metricGradeScale(dataValueGrade718) +
      qlweightage719 * metricGradeScale(dataValueGrade719) +
      qlweightage7111 * metricGradeScale(dataValueGrade7111) +
      qlweightage721 * metricGradeScale(dataValueGrade721) +
      qlweightage731 * metricGradeScale(dataValueGrade731)
    );
  }

  const criteriaQl1Weightage = qlcriteria1Value();
  const criteriaQl1Grade = parseFloat(
    criteriaQl1Weightage / qlcriteria1
  ).toFixed(2);
  const criteriaQl11Value =
    qlweightage111 * metricGradeScale(dataValueGrade111);
  const criteriaQl13Value =
    qlweightage131 * metricGradeScale(dataValueGrade131);

  const criteriaQl2Weightage = qlcriteria2Value();
  const criteriaQl2Grade = parseFloat(
    criteriaQl2Weightage / qlcriteria2
  ).toFixed(2);
  const criteriaQl22Value =
    qlweightage221 * metricGradeScale(dataValueGrade221);
  const criteriaQl23Value =
    qlweightage231 * metricGradeScale(dataValueGrade231) +
    qlweightage232 * metricGradeScale(dataValueGrade232) +
    qlweightage234 * metricGradeScale(dataValueGrade234);
  const criteriaQl25Value =
    qlweightage253 * metricGradeScale(dataValueGrade253);
  const criteriaQl26Value =
    qlweightage261 * metricGradeScale(dataValueGrade261) +
    qlweightage262 * metricGradeScale(dataValueGrade262);

  const criteriaQl3Weightage = qlcriteria3Value();
  const criteriaQl3Grade = parseFloat(
    criteriaQl3Weightage / qlcriteria3
  ).toFixed(2);
  const criteriaQl31Value =
    qlweightage311 * metricGradeScale(dataValueGrade311);
  const criteriaQl33Value =
    qlweightage331 * metricGradeScale(dataValueGrade331);
  const criteriaQl36Value =
    qlweightage361 * metricGradeScale(dataValueGrade361);

  const criteriaQl4Weightage = qlcriteria4Value();
  const criteriaQl4Grade = parseFloat(
    criteriaQl4Weightage / qlcriteria4
  ).toFixed(2);
  const criteriaQl41Value =
    qlweightage411 * metricGradeScale(dataValueGrade411) +
    qlweightage412 * metricGradeScale(dataValueGrade412);
  const criteriaQl42Value =
    qlweightage421 * metricGradeScale(dataValueGrade421);
  const criteriaQl43Value =
    qlweightage431 * metricGradeScale(dataValueGrade431);
  const criteriaQl44Value =
    qlweightage442 * metricGradeScale(dataValueGrade442);

  const criteriaQl5Weightage = qlcriteria5Value();
  const criteriaQl5Grade = parseFloat(
    criteriaQl5Weightage / qlcriteria5
  ).toFixed(2);
  const criteriaQl53Value =
    qlweightage532 * metricGradeScale(dataValueGrade532);
  const criteriaQl54Value =
    qlweightage541 * metricGradeScale(dataValueGrade541);

  const criteriaQl6Weightage = qlcriteria6Value();
  const criteriaQl6Grade = parseFloat(
    criteriaQl6Weightage / qlcriteria6
  ).toFixed(2);
  const criteriaQl61Value =
    qlweightage611 * metricGradeScale(dataValueGrade611) +
    qlweightage612 * metricGradeScale(dataValueGrade612);
  const criteriaQl62Value =
    qlweightage621 * metricGradeScale(dataValueGrade621) +
    qlweightage622 * metricGradeScale(dataValueGrade622);
  const criteriaQl63Value =
    qlweightage631 * metricGradeScale(dataValueGrade631);
  const criteriaQl64Value =
    qlweightage641 * metricGradeScale(dataValueGrade641) +
    qlweightage643 * metricGradeScale(dataValueGrade643);
  const criteriaQl65Value =
    qlweightage651 * metricGradeScale(dataValueGrade651) +
    qlweightage652 * metricGradeScale(dataValueGrade652);

  const criteriaQl7Weightage = qlcriteria7Value();
  const criteriaQl7Grade = parseFloat(
    criteriaQl7Weightage / qlcriteria7
  ).toFixed(2);
  const criteriaQl71Value =
    qlweightage711 * metricGradeScale(dataValueGrade711) +
    qlweightage713 * metricGradeScale(dataValueGrade713) +
    qlweightage718 * metricGradeScale(dataValueGrade718) +
    qlweightage719 * metricGradeScale(dataValueGrade719) +
    qlweightage7111 * metricGradeScale(dataValueGrade7111);
  const criteriaQl72Value =
    qlweightage721 * metricGradeScale(dataValueGrade721);
  const criteriaQl73Value =
    qlweightage731 * metricGradeScale(dataValueGrade731);

  const inputDataList = {
    criteriaId: {
      collegeId: "1",
      financialYear: "2021-2022",
      typeofInstitution: " university",
    },
    qualitative: [
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 36,
        qlit8: qlCommentBox,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 1,
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
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 2,
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
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 3,
        qlit7: dataValue221,
        qlit6: "" + dataValueGrade221,
        qlit5: "" + qlweightage221 * metricGradeScale(dataValueGrade221),
        qlit4: parseFloat(criteriaQl22Value / qlkiWeightage22).toFixed(2),
        qlit3: criteriaQl2Grade,
        qlit2: "" + criteriaQl2Weightage,
        qlit1: "" + criteriaQl22Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 4,
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
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 5,
        qlit7: dataValue232,
        qlit6: "" + dataValueGrade232,
        qlit5: "" + qlweightage232 * metricGradeScale(dataValueGrade232),
        qlit4: parseFloat(criteriaQl23Value / qlkiWeightage23).toFixed(2),
        qlit3: criteriaQl2Grade,
        qlit2: "" + criteriaQl2Weightage,
        qlit1: "" + criteriaQl23Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 6,
        qlit7: dataValue234,
        qlit6: "" + dataValueGrade234,
        qlit5: "" + qlweightage234 * metricGradeScale(dataValueGrade234),
        qlit4: parseFloat(criteriaQl23Value / qlkiWeightage23).toFixed(2),
        qlit3: criteriaQl2Grade,
        qlit2: "" + criteriaQl2Weightage,
        qlit1: "" + criteriaQl23Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 7,
        qlit7: dataValue253,
        qlit6: "" + dataValueGrade253,
        qlit5: "" + qlweightage253 * metricGradeScale(dataValueGrade253),
        qlit4: parseFloat(criteriaQl25Value / qlkiWeightage25).toFixed(2),
        qlit3: criteriaQl2Grade,
        qlit2: "" + criteriaQl2Weightage,
        qlit1: "" + criteriaQl25Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 8,
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
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 9,
        qlit7: dataValue262,
        qlit6: "" + dataValueGrade262,
        qlit5: "" + qlweightage262 * metricGradeScale(dataValueGrade262),
        qlit4: parseFloat(criteriaQl26Value / qlkiWeightage26).toFixed(2),
        qlit3: criteriaQl2Grade,
        qlit2: "" + criteriaQl2Weightage,
        qlit1: "" + criteriaQl26Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 10,
        qlit7: dataValue311,
        qlit6: "" + dataValueGrade311,
        qlit5: "" + qlweightage311 * metricGradeScale(dataValueGrade311),
        qlit4: parseFloat(criteriaQl31Value / qlkiWeightage31).toFixed(2),
        qlit3: criteriaQl3Grade,
        qlit2: "" + criteriaQl3Weightage,
        qlit1: "" + criteriaQl31Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 11,
        qlit7: dataValue331,
        qlit6: "" + dataValueGrade331,
        qlit5: "" + qlweightage331 * metricGradeScale(dataValueGrade331),
        qlit4: parseFloat(criteriaQl33Value / qlkiWeightage33).toFixed(2),
        qlit3: criteriaQl3Grade,
        qlit2: "" + criteriaQl3Weightage,
        qlit1: "" + criteriaQl33Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 12,
        qlit7: dataValue361,
        qlit6: "" + dataValueGrade361,
        qlit5: "" + qlweightage361 * metricGradeScale(dataValueGrade361),
        qlit4: parseFloat(criteriaQl36Value / qlkiWeightage36).toFixed(2),
        qlit3: criteriaQl3Grade,
        qlit2: "" + criteriaQl3Weightage,
        qlit1: "" + criteriaQl36Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 13,
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
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 14,
        qlit7: dataValue412,
        qlit6: "" + dataValueGrade412,
        qlit5: "" + qlweightage412 * metricGradeScale(dataValueGrade412),
        qlit4: parseFloat(criteriaQl41Value / qlkiWeightage41).toFixed(2),
        qlit3: criteriaQl4Grade,
        qlit2: "" + criteriaQl4Weightage,
        qlit1: "" + criteriaQl41Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 15,
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
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 16,
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
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 17,
        qlit7: dataValue442,
        qlit6: "" + dataValueGrade442,
        qlit5: "" + qlweightage442 * metricGradeScale(dataValueGrade442),
        qlit4: parseFloat(criteriaQl44Value / qlkiWeightage44).toFixed(2),
        qlit3: criteriaQl4Grade,
        qlit2: "" + criteriaQl4Weightage,
        qlit1: "" + criteriaQl44Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 18,
        qlit7: dataValue532,
        qlit6: "" + dataValueGrade532,
        qlit5: "" + qlweightage532 * metricGradeScale(dataValueGrade532),
        qlit4: parseFloat(criteriaQl53Value / qlkiWeightage53).toFixed(2),
        qlit3: criteriaQl5Grade,
        qlit2: "" + criteriaQl5Weightage,
        qlit1: "" + criteriaQl53Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 19,
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
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 20,
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
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 21,
        qlit7: dataValue612,
        qlit6: "" + dataValueGrade612,
        qlit5: "" + qlweightage612 * metricGradeScale(dataValueGrade612),
        qlit4: parseFloat(criteriaQl61Value / qlkiWeightage61).toFixed(2),
        qlit3: criteriaQl6Grade,
        qlit2: "" + criteriaQl6Weightage,
        qlit1: "" + criteriaQl61Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 22,
        qlit7: dataValue621,
        qlit6: "" + dataValueGrade621,
        qlit5: "" + qlweightage622 * metricGradeScale(dataValueGrade621),
        qlit4: parseFloat(criteriaQl62Value / qlkiWeightage62).toFixed(2),
        qlit3: criteriaQl6Grade,
        qlit2: "" + criteriaQl6Weightage,
        qlit1: "" + criteriaQl62Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 23,
        qlit7: dataValue622,
        qlit6: "" + dataValueGrade622,
        qlit5: "" + qlweightage622 * metricGradeScale(dataValueGrade622),
        qlit4: parseFloat(criteriaQl62Value / qlkiWeightage62).toFixed(2),
        qlit3: criteriaQl6Grade,
        qlit2: "" + criteriaQl6Weightage,
        qlit1: "" + criteriaQl62Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 24,
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
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 25,
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
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 26,
        qlit7: dataValue643,
        qlit6: "" + dataValueGrade643,
        qlit5: "" + qlweightage643 * metricGradeScale(dataValueGrade643),
        qlit4: parseFloat(criteriaQl64Value / qlkiWeightage64).toFixed(2),
        qlit3: criteriaQl6Grade,
        qlit2: "" + criteriaQl6Weightage,
        qlit1: "" + criteriaQl64Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 27,
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
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 28,
        qlit7: dataValue652,
        qlit6: "" + dataValueGrade652,
        qlit5: "" + qlweightage652 * metricGradeScale(dataValueGrade652),
        qlit4: parseFloat(criteriaQl65Value / qlkiWeightage65).toFixed(2),
        qlit3: criteriaQl6Grade,
        qlit2: "" + criteriaQl6Weightage,
        qlit1: "" + criteriaQl65Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 29,
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
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 30,
        qlit7: dataValue713,
        qlit6: "" + dataValueGrade713,
        qlit5: "" + qlweightage713 * metricGradeScale(dataValueGrade713),
        qlit4: parseFloat(criteriaQl71Value / qlkiWeightage71).toFixed(2),
        qlit3: criteriaQl7Grade,
        qlit2: "" + criteriaQl7Weightage,
        qlit1: "" + criteriaQl71Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 31,
        qlit7: dataValue718,
        qlit6: "" + dataValueGrade718,
        qlit5: "" + qlweightage718 * metricGradeScale(dataValueGrade718),
        qlit4: parseFloat(criteriaQl71Value / qlkiWeightage71).toFixed(2),
        qlit3: criteriaQl7Grade,
        qlit2: "" + criteriaQl7Weightage,
        qlit1: "" + criteriaQl71Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 32,
        qlit7: dataValue719,
        qlit6: "" + dataValueGrade719,
        qlit5: "" + qlweightage719 * metricGradeScale(dataValueGrade719),
        qlit4: parseFloat(criteriaQl71Value / qlkiWeightage71).toFixed(2),
        qlit3: criteriaQl7Grade,
        qlit2: "" + criteriaQl7Weightage,
        qlit1: "" + criteriaQl71Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 33,
        qlit7: dataValue7111,
        qlit6: "" + dataValueGrade7111,
        qlit5: "" + qlweightage7111 * metricGradeScale(dataValueGrade7111),
        qlit4: parseFloat(criteriaQl71Value / qlkiWeightage71).toFixed(2),
        qlit3: criteriaQl7Grade,
        qlit2: "" + criteriaQl7Weightage,
        qlit1: "" + criteriaQl71Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 34,
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
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 35,
        qlit7: dataValue731,
        qlit6: "" + dataValueGrade731,
        qlit5: "" + qlweightage731 * metricGradeScale(dataValueGrade731),
        qlit4: parseFloat(criteriaQl73Value / qlkiWeightage73).toFixed(2),
        qlit3: criteriaQl7Grade,
        qlit2: "" + criteriaQl7Weightage,
        qlit1: "" + criteriaQl73Value,
      },
    ],
    qualitativeCriterionWiseList: [
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 1,
        criterionWiseGrade: criteriaQl1Grade,
        criterionWiseWeighted: criteriaQl1Weightage,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 2,
        criterionWiseGrade: criteriaQl2Grade,
        criterionWiseWeighted: criteriaQl2Weightage,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 3,
        criterionWiseGrade: criteriaQl3Grade,
        criterionWiseWeighted: criteriaQl3Weightage,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 4,
        criterionWiseGrade: criteriaQl4Grade,
        criterionWiseWeighted: criteriaQl4Weightage,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 5,
        criterionWiseGrade: criteriaQl5Grade,
        criterionWiseWeighted: criteriaQl5Weightage,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 6,
        criterionWiseGrade: criteriaQl6Grade,
        criterionWiseWeighted: criteriaQl6Weightage,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 7,
        criterionWiseGrade: criteriaQl7Grade,
        criterionWiseWeighted: criteriaQl7Weightage,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 8,
        kiwisetotal: criteriaQl11Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 9,
        kiwisetotal: criteriaQl13Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 10,
        kiwisetotal: criteriaQl22Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 11,
        kiwisetotal: criteriaQl23Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 12,
        kiwisetotal: criteriaQl25Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 13,
        kiwisetotal: criteriaQl26Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 14,
        kiwisetotal: criteriaQl31Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 15,
        kiwisetotal: criteriaQl33Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 16,
        kiwisetotal: criteriaQl36Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 17,
        kiwisetotal: criteriaQl41Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 18,
        kiwisetotal: criteriaQl42Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 19,
        kiwisetotal: criteriaQl43Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 20,
        kiwisetotal: criteriaQl44Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 21,
        kiwisetotal: criteriaQl53Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 22,
        kiwisetotal: criteriaQl54Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 23,
        kiwisetotal: criteriaQl61Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 24,
        kiwisetotal: criteriaQl62Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 25,
        kiwisetotal: criteriaQl63Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 26,
        kiwisetotal: criteriaQl64Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 27,
        kiwisetotal: criteriaQl65Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 28,
        kiwisetotal: criteriaQl71Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 29,
        kiwisetotal: criteriaQl72Value,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: " university",
        },
        uniqueKey1: 30,
        kiwisetotal: criteriaQl73Value,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }
  function onClickingSave() {
    if (
      dataValue111 !== "" &&
      dataValue131 !== "" &&
      dataValue221 !== "" &&
      dataValue231 !== "" &&
      dataValue232 !== "" &&
      dataValue234 !== "" &&
      dataValue253 !== "" &&
      dataValue261 !== "" &&
      dataValue262 !== "" &&
      dataValue311 !== "" &&
      dataValue331 !== "" &&
      dataValue361 !== "" &&
      dataValue411 !== "" &&
      dataValue412 !== "" &&
      dataValue421 !== "" &&
      dataValue431 !== "" &&
      dataValue442 !== "" &&
      dataValue532 !== "" &&
      dataValue541 !== "" &&
      dataValue611 !== "" &&
      dataValue612 !== "" &&
      dataValue621 !== "" &&
      dataValue622 !== "" &&
      dataValue631 !== "" &&
      dataValue641 !== "" &&
      dataValue643 !== "" &&
      dataValue651 !== "" &&
      dataValue652 !== "" &&
      dataValue711 !== "" &&
      dataValue713 !== "" &&
      dataValue718 !== "" &&
      dataValue719 !== "" &&
      dataValue7111 !== "" &&
      dataValue721 !== "" &&
      dataValue731 !== "" &&
      dataValueGrade111 !== "" &&
      dataValueGrade131 !== "" &&
      dataValueGrade221 !== "" &&
      dataValueGrade231 !== "" &&
      dataValueGrade232 !== "" &&
      dataValueGrade234 !== "" &&
      dataValueGrade253 !== "" &&
      dataValueGrade261 !== "" &&
      dataValueGrade262 !== "" &&
      dataValueGrade311 !== "" &&
      dataValueGrade331 !== "" &&
      dataValueGrade361 !== "" &&
      dataValueGrade411 !== "" &&
      dataValueGrade412 !== "" &&
      dataValueGrade421 !== "" &&
      dataValueGrade431 !== "" &&
      dataValueGrade442 !== "" &&
      dataValueGrade532 !== "" &&
      dataValueGrade541 !== "" &&
      dataValueGrade611 !== "" &&
      dataValueGrade612 !== "" &&
      dataValueGrade621 !== "" &&
      dataValueGrade622 !== "" &&
      dataValueGrade631 !== "" &&
      dataValueGrade641 !== "" &&
      dataValueGrade643 !== "" &&
      dataValueGrade651 !== "" &&
      dataValueGrade652 !== "" &&
      dataValueGrade711 !== "" &&
      dataValueGrade713 !== "" &&
      dataValueGrade718 !== "" &&
      dataValueGrade719 !== "" &&
      dataValueGrade7111 !== "" &&
      dataValueGrade721 !== "" &&
      dataValueGrade731 !== ""
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
    <div>
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
              <td>QL</td>
              <td style={{ textAlign: 'center' }} >
                Curricula developed and implemented have relevance to the local,
                national, regional and global developmental needs which is
                reflected in Programme outcomes (POs), Programme Specific
                Outcomes(PSOs) and Course Outcomes(COs) of the Programmes
                offered by the Institution.
              </td>
              <td>{qlweightage111}</td>
              <td>{qlkiWeightage11}</td>
              <td rowspan="2">{qlcriteria1}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue111}
                onChange={(e) => {
                  setDataValue111(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade111"
                  name={dataValueGrade111}
                  onChange={(e) => {
                    setDataValueGrade111(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
              <td>
                <p>
                  {parseFloat(criteriaQl11Value / qlkiWeightage11).toFixed(2)}
                </p>
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
                Institution integrates crosscutting issues relevant to
                Professional Ethics ,Gender, Human Values ,Environment and
                Sustainability into the Curriculum.
              </td>
              <td>{qlweightage131}</td>
              <td>{qlkiWeightage13}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue131}
                onChange={(e) => {
                  setDataValue131(e.target.value);
                }}
              ></ input>
              </td>
              <td>
                <select
                  className="select"
                  id="dataValueGrade131"
                  name={dataValueGrade131}
                  onChange={(e) => {
                    setDataValueGrade131(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
              <td>{criteriaQl13Value}</td>
              <td>
                <p>
                  {parseFloat(criteriaQl13Value / qlkiWeightage11).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>3.</td>
              <td>2.2.1</td>
              <td>QL</td>
              <td>
                The institution assesses the learning levels of the students and
                organises special Programmes for advanced learners and slow
                learners
              </td>
              <td>{qlweightage221}</td>
              <td>{qlkiWeightage22}</td>
              <td rowspan="6">{qlcriteria2}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue221}
                onChange={(e) => {
                  setDataValue221(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade221"
                  name={dataValueGrade221}
                  onChange={(e) => {
                    setDataValueGrade221(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage221 * metricGradeScale(dataValueGrade221)}</p>
              </td>
              <td>
                <p>{criteriaQl22Value}</p>
              </td>
              <td>
                <p>
                  {parseFloat(criteriaQl22Value / qlkiWeightage22).toFixed(2)}
                </p>
              </td>
              <td rowSpan="7">
                <p>{criteriaQl2Weightage}</p>
              </td>
              <td rowSpan="7">
                <p>{criteriaQl2Grade}</p>
              </td>
            </tr>
            <tr>
              <td>4.</td>
              <td>2.3.1</td>
              <td>QL</td>
              <td>
                Student centric methods, such as experiential learning,
                participative learning and problem solving methodologies are
                used for enhancing learning experiences
              </td>
              <td>{qlweightage231}</td>
              <td rowspan="3">{qlkiWeightage23}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue231}
                onChange={(e) => {
                  setDataValue231(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade231"
                  name={dataValueGrade231}
                  onChange={(e) => {
                    setDataValueGrade231(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
              <td rowSpan="3">
                <p>{criteriaQl23Value}</p>
              </td>
              <td rowSpan="3">
                <p>
                  {parseFloat(criteriaQl23Value / qlkiWeightage23).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>5.</td>
              <td>2.3.2</td>
              <td>QL</td>
              <td>
                Teachers use ICT enabled tools including online resources for
                effective teaching and learning process.
              </td>
              <td>{qlweightage232}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue232}
                onChange={(e) => {
                  setDataValue232(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade232"
                  name={dataValueGrade232}
                  onChange={(e) => {
                    setDataValueGrade232(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage232 * metricGradeScale(dataValueGrade232)}</p>
              </td>
            </tr>
            <tr>
              <td>6.</td>
              <td>2.3.4</td>
              <td>QL</td>
              <td>
                Average percentage of full time teachers against sanctioned
                posts during the last five years
              </td>
              <td>{qlweightage234}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue234}
                onChange={(e) => {
                  setDataValue234(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade234"
                  name={dataValueGrade234}
                  onChange={(e) => {
                    setDataValueGrade234(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage234 * metricGradeScale(dataValueGrade234)}</p>
              </td>
            </tr>
            <tr>
              <td>7.</td>
              <td>2.5.3</td>
              <td>QL</td>
              <td>
                IT integration and reforms in the examination procedures and
                processes including Continuous Internal Assessment (CIA) have
                brought in considerable improvement in Examination Management
                System (EMS) of the Institution.
              </td>
              <td>{qlweightage253}</td>
              <td>{qlkiWeightage25}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue253}
                onChange={(e) => {
                  setDataValue253(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade253"
                  name={dataValueGrade253}
                  onChange={(e) => {
                    setDataValueGrade253(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage253 * metricGradeScale(dataValueGrade253)}</p>
              </td>
              <td>
                <p>{criteriaQl25Value}</p>
              </td>
              <td>
                <p>
                  {parseFloat(criteriaQl25Value / qlkiWeightage25).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>8.</td>
              <td>2.6.1</td>
              <td>QL</td>
              <td>
                Programme and course outcomes for all Programmes offered by the
                institution are stated and displayed on website and communicated
                to teachers and students.
              </td>
              <td>{qlweightage261}</td>
              <td rowspan="2">{qlkiWeightage26}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue261}
                onChange={(e) => {
                  setDataValue261(e.target.value);
                }}
              ></ input>
              </td>             
               <td>
                <select
                  className="select"
                  id="dataValueGrade261"
                  name={dataValueGrade261}
                  onChange={(e) => {
                    setDataValueGrade261(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
              <td rowspan="2">
                <p>{criteriaQl26Value}</p>
              </td>
              <td rowspan="2">
                <p>
                  {parseFloat(criteriaQl26Value / qlkiWeightage26).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>9.</td>
              <td>2.6.2</td>
              <td>QL</td>
              <td>
                Attainment of programme outcomes and course outcomes are
                evaluated by the institution.
              </td>
              <td>{qlweightage262}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue262}
                onChange={(e) => {
                  setDataValue262(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade262"
                  name={dataValueGrade262}
                  onChange={(e) => {
                    setDataValueGrade262(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage262 * metricGradeScale(dataValueGrade262)}</p>
              </td>
            </tr>
            <tr>
              <td>10.</td>
              <td>3.1.1</td>
              <td>QL</td>
              <td>
                The institution's Research facilities are frequently updated and
                there is a well defined policy for promotion of research which
                is uploaded on the institutional website and implemented.
              </td>
              <td>{qlweightage311}</td>
              <td>{qlkiWeightage31}</td>
              <td rowspan="3">{qlcriteria3}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue311}
                onChange={(e) => {
                  setDataValue311(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade311"
                  name={dataValueGrade311}
                  onChange={(e) => {
                    setDataValueGrade311(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage311 * metricGradeScale(dataValueGrade311)}</p>
              </td>
              <td>
                <p>{criteriaQl31Value}</p>
              </td>
              <td>
                <p>
                  {parseFloat(criteriaQl31Value / qlkiWeightage31).toFixed(2)}
                </p>
              </td>
              <td rowSpan="3">
                <p>{criteriaQl3Weightage}</p>
              </td>
              <td rowSpan="3">
                <p>{criteriaQl3Grade}</p>
              </td>
            </tr>
            <tr>
              <td>11.</td>
              <td>3.3.1</td>
              <td>QL</td>
              <td>
                Institution has created an eco system for innovations, creation
                and transfer of knowledge supported by dedicated centers for
                research, entrepreneurship, community orientation, Incubation
                etc.
              </td>
              <td>{qlweightage331}</td>
              <td>{qlkiWeightage33}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue331}
                onChange={(e) => {
                  setDataValue331(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade331"
                  name={dataValueGrade331}
                  onChange={(e) => {
                    setDataValueGrade331(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage331 * metricGradeScale(dataValueGrade331)}</p>
              </td>
              <td>
                <p>{criteriaQl33Value}</p>
              </td>
              <td>
                <p>
                  {parseFloat(criteriaQl33Value / qlkiWeightage33).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>12.</td>
              <td>3.6.1</td>
              <td>QL</td>
              <td>
                Extension activities are carried out in the neighbourhood
                community, sensitising students to social issues, for their
                holistic development, and impact thereof during the last five
                years.
              </td>
              <td>{qlweightage361}</td>
              <td>{qlkiWeightage36}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue361}
                onChange={(e) => {
                  setDataValue361(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade361"
                  name={dataValueGrade361}
                  onChange={(e) => {
                    setDataValueGrade361(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage361 * metricGradeScale(dataValueGrade361)}</p>
              </td>
              <td>
                <p>{criteriaQl36Value}</p>
              </td>
              <td>
                <p>
                  {parseFloat(criteriaQl36Value / qlkiWeightage36).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>13.</td>
              <td>4.1.1</td>
              <td>QL</td>
              <td>
                The Institution has adequate infrastructure and physical
                facilities for teaching- learning. viz., classrooms,
                laboratories, computing equipment etc.
              </td>
              <td>{qlweightage411}</td>
              <td rowspan="2">{qlkiWeightage41}</td>
              <td rowspan="5">{qlcriteria4}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue411}
                onChange={(e) => {
                  setDataValue411(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade411"
                  name={dataValueGrade411}
                  onChange={(e) => {
                    setDataValueGrade411(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
              <td rowSpan="2">
                <p>{criteriaQl41Value}</p>
              </td>
              <td rowSpan="2">
                <p>
                  {parseFloat(criteriaQl41Value / qlkiWeightage41).toFixed(2)}
                </p>
              </td>
              <td rowSpan="5">
                <p>{criteriaQl4Weightage}</p>
              </td>
              <td rowSpan="5">
                <p>{criteriaQl4Grade}</p>
              </td>
            </tr>
            <tr>
              <td>14.</td>
              <td>4.1.2</td>
              <td>QL</td>
              <td>
                The institution has adequate facilities for cultural activities,
                yoga, games and sports (indoor & outdoor); (gymnasium, yoga
                centre, auditorium, etc.,)
              </td>
              <td>{qlweightage412}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue412}
                onChange={(e) => {
                  setDataValue412(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade412"
                  name={dataValueGrade412}
                  onChange={(e) => {
                    setDataValueGrade412(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage412 * metricGradeScale(dataValueGrade412)}</p>
              </td>
            </tr>
            <tr>
              <td>15.</td>
              <td>4.2.1</td>
              <td>QL</td>
              <td>
                Library is automated using Integrated Library Management System
                (ILMS).
              </td>
              <td>{qlweightage421}</td>
              <td>{qlkiWeightage42}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue421}
                onChange={(e) => {
                  setDataValue421(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade421"
                  name={dataValueGrade421}
                  onChange={(e) => {
                    setDataValueGrade421(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
                <p>
                  {parseFloat(criteriaQl42Value / qlkiWeightage42).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>16.</td>
              <td>4.3.1</td>
              <td>QL</td>
              <td>
                Institution has an IT policy covering wi-fi, cyber security,
                etc., and allocated budget for updating its IT facilities.
              </td>
              <td>{qlweightage431}</td>
              <td>{qlkiWeightage43}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue431}
                onChange={(e) => {
                  setDataValue431(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade431"
                  name={dataValueGrade431}
                  onChange={(e) => {
                    setDataValueGrade431(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
                <p>
                  {parseFloat(criteriaQl43Value / qlkiWeightage43).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>17.</td>
              <td>4.4.2</td>
              <td>QL</td>
              <td>
                There are established systems and procedures for maintaining and
                utilizing physical, academic and support facilities -
                laboratory, library, sports complex, computers, classrooms etc.
              </td>
              <td>{qlweightage442}</td>
              <td>{qlkiWeightage44}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue442}
                onChange={(e) => {
                  setDataValue442(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade442"
                  name={dataValueGrade442}
                  onChange={(e) => {
                    setDataValueGrade442(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage442 * metricGradeScale(dataValueGrade442)}</p>
              </td>
              <td>
                <p>{criteriaQl44Value}</p>
              </td>
              <td>
                <p>
                  {parseFloat(criteriaQl44Value / qlkiWeightage44).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>18.</td>
              <td>5.3.2</td>
              <td>QL</td>
              <td>
                Presence of an active Student Council & representation of
                students on academic & administrative bodies/committees of the
                institution.
              </td>
              <td>{qlweightage532}</td>
              <td>{qlkiWeightage53}</td>
              <td rowspan="2">{qlcriteria5}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue532}
                onChange={(e) => {
                  setDataValue532(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade532"
                  name={dataValueGrade532}
                  onChange={(e) => {
                    setDataValueGrade532(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage532 * metricGradeScale(dataValueGrade532)}</p>
              </td>
              <td>
                <p>{criteriaQl53Value}</p>
              </td>
              <td>
                <p>
                  {parseFloat(criteriaQl53Value / qlkiWeightage53).toFixed(2)}
                </p>
              </td>
              <td rowSpan="2">
                <p>{criteriaQl5Weightage}</p>
              </td>
              <td rowSpan="2">
                <p>{criteriaQl5Grade}</p>
              </td>
            </tr>
            <tr>
              <td>19.</td>
              <td>5.4.1</td>
              <td>QL</td>
              <td>
                The Alumni Association/Chapters (registered and
                functional)contributes significantly to the development of the
                institution through financial and other support services.
              </td>
              <td>{qlweightage541}</td>
              <td>{qlkiWeightage54}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue541}
                onChange={(e) => {
                  setDataValue541(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade541"
                  name={dataValueGrade541}
                  onChange={(e) => {
                    setDataValueGrade541(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
                <p>
                  {parseFloat(criteriaQl54Value / qlkiWeightage54).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>20.</td>
              <td>6.1.1</td>
              <td>QL</td>
              <td>
                The governance of the institution is reflective of an effective
                leadership in tune with the vision and mission of the
                Institution.
              </td>
              <td>{qlweightage611}</td>
              <td rowspan="2">{qlkiWeightage61}</td>
              <td rowspan="9">{qlcriteria6}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue611}
                onChange={(e) => {
                  setDataValue611(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade611"
                  name={dataValueGrade611}
                  onChange={(e) => {
                    setDataValueGrade611(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
              <td rowspan="2">
                <p>{criteriaQl61Value}</p>
              </td>
              <td rowspan="2">
                <p>
                  {parseFloat(criteriaQl61Value / qlkiWeightage61).toFixed(2)}
                </p>
              </td>
              <td rowSpan="9">
                <p>{criteriaQl6Weightage}</p>
              </td>
              <td rowSpan="9">
                <p>{criteriaQl6Grade}</p>
              </td>
            </tr>
            <tr>
              <td>21.</td>
              <td>6.1.2</td>
              <td>QL</td>
              <td>
                The effective leadership is reflected in various institutional
                practices such as decentralization and participative management.
              </td>
              <td>{qlweightage612}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue612}
                onChange={(e) => {
                  setDataValue612(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade612"
                  name={dataValueGrade612}
                  onChange={(e) => {
                    setDataValueGrade612(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage612 * metricGradeScale(dataValueGrade612)}</p>
              </td>
            </tr>
            <tr>
              <td>22.</td>
              <td>6.2.1</td>
              <td>QL</td>
              <td>
                The institutional Strategic/ Perspective plan is effectively
                deployed.
              </td>
              <td>{qlweightage621}</td>
              <td rowspan="2">{qlkiWeightage62}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue621}
                onChange={(e) => {
                  setDataValue621(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade621"
                  name={dataValueGrade621}
                  onChange={(e) => {
                    setDataValueGrade621(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
              <td rowspan="2">
                <p>{criteriaQl62Value}</p>
              </td>
              <td rowspan="2">
                <p>
                  {parseFloat(criteriaQl62Value / qlkiWeightage62).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>23.</td>
              <td>6.2.2</td>
              <td>QL</td>
              <td>
                The functioning of the institutional bodies is effective and
                efficient as visible from policies, administrative setup
                appointment and service rules, procedures, etc.
              </td>
              <td>{qlweightage622}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue622}
                onChange={(e) => {
                  setDataValue622(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade622"
                  name={dataValueGrade622}
                  onChange={(e) => {
                    setDataValueGrade622(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage622 * metricGradeScale(dataValueGrade622)}</p>
              </td>
            </tr>
            <tr>
              <td>24.</td>
              <td>6.3.1</td>
              <td>QL</td>
              <td>
                The institution has effective welfare measures for teaching and
                non-teaching staff and avenues for career development/
                progression
              </td>
              <td>{qlweightage631}</td>
              <td>{qlkiWeightage63}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue631}
                onChange={(e) => {
                  setDataValue631(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade631"
                  name={dataValueGrade631}
                  onChange={(e) => {
                    setDataValueGrade631(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
                <p>
                  {parseFloat(criteriaQl63Value / qlkiWeightage63).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>25.</td>
              <td>6.4.1</td>
              <td>QL</td>
              <td>
                Institution conducts internal and external financial audits
                regularly
              </td>
              <td>{qlweightage641}</td>
              <td rowspan="2">{qlkiWeightage64}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue641}
                onChange={(e) => {
                  setDataValue641(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade641"
                  name={dataValueGrade641}
                  onChange={(e) => {
                    setDataValueGrade641(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
              <td rowspan="2">
                <p>{criteriaQl64Value}</p>
              </td>
              <td rowspan="2">
                <p>
                  {parseFloat(criteriaQl64Value / qlkiWeightage64).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>26.</td>
              <td>6.4.3</td>
              <td>QL</td>
              <td>
                Institutional strategies for mobilisation of funds and the
                optimal utilisation of resources.
              </td>
              <td>{qlweightage643}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue643}
                onChange={(e) => {
                  setDataValue643(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade643"
                  name={dataValueGrade643}
                  onChange={(e) => {
                    setDataValueGrade643(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage643 * metricGradeScale(dataValueGrade643)}</p>
              </td>
            </tr>
            <tr>
              <td>27.</td>
              <td>6.5.1</td>
              <td>QL</td>
              <td>
                Internal Quality Assurance Cell (IQAC) has contributed
                significantly for institutionalizing the quality assurance
                strategies and processes visible in terms of – Incremental
                improvements made for the preceding five years with regard to
                quality (in case of first cycle) Incremental improvements made
                for the preceding five years with regard to quality and post
                accreditation quality initiatives (second and subsequent
                cycles).
              </td>
              <td>{qlweightage651}</td>
              <td rowspan="2">{qlkiWeightage65}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue651}
                onChange={(e) => {
                  setDataValue651(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade651"
                  name={dataValueGrade651}
                  onChange={(e) => {
                    setDataValueGrade651(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
              <td rowspan="2">
                <p>{criteriaQl65Value}</p>
              </td>
              <td rowspan="2">
                <p>
                  {parseFloat(criteriaQl65Value / qlkiWeightage65).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>28.</td>
              <td>6.5.2</td>
              <td>QL</td>
              <td>
                The institution reviews its teaching learning process,
                structures & methodologies of operations and learning outcomes
                at periodic intervals through IQAC set up as per norms and
                recorded the incremental improvement in various activities ( For
                first cycle - Incremental improvements made for the preceding
                five years with regard to quality For second and subsequent
                cycles - Incremental improvements made for the preceding five
                years with regard to quality and post accreditation quality
                initiatives ).
              </td>
              <td>{qlweightage652}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue652}
                onChange={(e) => {
                  setDataValue652(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade652"
                  name={dataValueGrade652}
                  onChange={(e) => {
                    setDataValueGrade652(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage652 * metricGradeScale(dataValueGrade652)}</p>
              </td>
            </tr>
            <tr>
              <td>29.</td>
              <td>7.1.1</td>
              <td>QL</td>
              <td>
                Measures initiated by the Institution for the promotion of
                gender equity during the last five years.
              </td>
              <td>{qlweightage711}</td>
              <td rowspan="5">{qlkiWeightage71}</td>
              <td rowspan="7">{qlcriteria7}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue711}
                onChange={(e) => {
                  setDataValue711(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade711"
                  name={dataValueGrade711}
                  onChange={(e) => {
                    setDataValueGrade711(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
              <td rowspan="5">
                <p>{criteriaQl71Value}</p>
              </td>
              <td rowspan="5">
                <p>
                  {parseFloat(criteriaQl71Value / qlkiWeightage71).toFixed(2)}
                </p>
              </td>
              <td rowSpan="7">
                <p>{criteriaQl7Weightage}</p>
              </td>
              <td rowSpan="7">
                <p>{criteriaQl7Grade}</p>
              </td>
            </tr>
            <tr>
              <td>30.</td>
              <td>7.1.3</td>
              <td>QL</td>
              <td>
                Describe the facilities in the Institution for the management of
                the following types of degradable and non-degradable waste
                (within 500 words) Solid waste management Liquid waste
                management Biomedical waste management E-waste management Waste
                recycling system Hazardous chemicals and radioactive waste
                management.
              </td>
              <td>{qlweightage713}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue713}
                onChange={(e) => {
                  setDataValue713(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade713"
                  name={dataValueGrade713}
                  onChange={(e) => {
                    setDataValueGrade713(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage713 * metricGradeScale(dataValueGrade713)}</p>
              </td>
            </tr>
            <tr>
              <td>31.</td>
              <td>7.1.8</td>
              <td>QL</td>
              <td>
                Describe the Institutional efforts/initiatives in providing an
                inclusive environment i.e., tolerance and harmony towards
                cultural, regional, linguistic, communal socioeconomic and other
                diversities (within 500 words).
              </td>
              <td>{qlweightage718}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue718}
                onChange={(e) => {
                  setDataValue718(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade718"
                  name={dataValueGrade718}
                  onChange={(e) => {
                    setDataValueGrade718(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage718 * metricGradeScale(dataValueGrade718)}</p>
              </td>
            </tr>
            <tr>
              <td>32.</td>
              <td>7.1.9</td>
              <td>QL</td>
              <td>
                Sensitization of students and employees of the Institution to
                the constitutional obligations: values, rights, duties and
                responsibilities of citizens (within 500 words).
              </td>
              <td>{qlweightage719}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue719}
                onChange={(e) => {
                  setDataValue719(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade719"
                  name={dataValueGrade719}
                  onChange={(e) => {
                    setDataValueGrade719(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage719 * metricGradeScale(dataValueGrade719)}</p>
              </td>
            </tr>
            <tr>
              <td>33.</td>
              <td>7.1.11</td>
              <td>QL</td>
              <td>
                Institution celebrates / organizes national and international
                commemorative days, events and festivals (within 500 words).
              </td>
              <td>{qlweightage7111}</td>
              <td>
                < input
                  rows="10"
                  type="text"
                  value={dataValue7111}
                  onChange={(e) => {
                    setDataValue7111(e.target.value);
                  }}
                ></ input>
              </td>
              <td>
                <select
                  className="select"
                  id="dataValueGrade7111"
                  name={dataValueGrade7111}
                  onChange={(e) => {
                    setDataValueGrade7111(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
                      value={eachGrade.grade}
                    >
                      {eachGrade.grade}
                    </option>
                  ))}
                </select>
              </td>
              <td>
                <p>{qlweightage7111 * metricGradeScale(dataValueGrade7111)}</p>
              </td>
            </tr>
            <tr>
              <td>34.</td>
              <td>7.2.1</td>
              <td>QL</td>
              <td>
                Describe two best practices successfully implemented by the
                Institution as per NAAC format provided in the Manual.
              </td>
              <td>{qlweightage721}</td>
              <td>{qlkiWeightage72}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue721}
                onChange={(e) => {
                  setDataValue721(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade721"
                  name={dataValueGrade721}
                  onChange={(e) => {
                    setDataValueGrade721(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
                <p>
                  {parseFloat(criteriaQl72Value / qlkiWeightage72).toFixed(2)}
                </p>
              </td>
            </tr>
            <tr>
              <td>35.</td>
              <td>7.3.1</td>
              <td>QL</td>
              <td>
                Portray the performance of the Institution in one area
                distinctive to its priority and thrust within 1000 words.
              </td>
              <td>{qlweightage731}</td>
              <td>{qlkiWeightage73}</td>
              <td>              < input
                rows="10"
                type="text"
                value={dataValue731}
                onChange={(e) => {
                  setDataValue731(e.target.value);
                }}
              ></ input>
              </td>              <td>
                <select
                  className="select"
                  id="dataValueGrade731"
                  name={dataValueGrade731}
                  onChange={(e) => {
                    setDataValueGrade731(e.target.value);
                  }}
                >
                  {grades.map((eachGrade) => (
                    <option
                      id={eachGrade.grade}
                      key={eachGrade.id}
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
                <p>
                  {parseFloat(criteriaQl73Value / qlkiWeightage73).toFixed(2)}
                </p>
              </td>
            </tr>
          </table>
          <div>
            <p htmlFor="comment">Comments:</p>
            < input
              id="comment"
              rows="6"
              cols="210"
              onChange={(e) => setQlCommentBox(e.target.value)}
              placeholder="Describe in maximum 500 words"
            ></ input>
          </div>
          {/* <div className="ql-button-container">
          <button
            className="ql-button-style"
            onClick={onClickingSave}
          >
            Save
          </button>
        </div> */}
        </div>
        <div className="ql-button-container">
          <button className="ql-button-style" onClick={onClickingSave}>
            Save
          </button>
        </div>
      </div>
    </div>
  );
}
export default QL;
