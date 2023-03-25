import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import AuthService from "../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../reusableComponents/model/Help";
import { resources } from "../../../../appConstants";

import "./c11-style.css";
import { Button } from "@mui/material";

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

// Help buttons functionality
function Help111(props) {
  return props.isHelp111Clicked ? (
    <div className="c11x-help-mainContainer">
      <div className="c11x-help-subContainer">
        <h1 className="c11x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c11x-help-para-style">
          Justify that the college satisfies the metric Describe it in maximum
          500 words.
        </p>
        <button
          className="c11x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp111Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help112(props) {
  return props.isHelp112Clicked ? (
    <div className="c11x-help-mainContainer">
      <div className="c11x-help-subContainer">
        <h1 className="c11x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c11x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span> Number of programs in
          which syllabus was revised during the last five years
          <span style={{ fontWeight: "bold" }}>) /</span>
          <span style={{ fontWeight: "bold" }}>(</span>
          Total number of programmes offered by the institution during last five
          years
          <span style={{ fontWeight: "bold" }}>)*</span> 100
        </p>
        <button
          className="c11x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp112Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help113(props) {
  return props.isHelp113Clicked ? (
    <div className="c11x-help-mainContainer">
      <div className="c11x-help-subContainer">
        <h1 className="c11x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c11x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span>Number of programmes in
          which syllabus was revised during the last five years
          <span style={{ fontWeight: "bold" }}> / </span>Total number of
          programmes offered by the institution during the last five years
          <span style={{ fontWeight: "bold" }}>) * </span>100
        </p>
        <p className="c24x-help-para-style">
          Average Percentage
          <span style={{ fontWeight: "bold" }}>=(</span> ΣPercentage per year
          <span style={{ fontWeight: "bold" }}>) /</span> 5
        </p>
        <button
          className="c11x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp113Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// const removeAll = () => {
//   setValue111f1()
//   setValue111f2()
// }

// Promotion of Research and Facilities
function Criteria11() {
  
 // getfile data with API
 function downloadFile(fileName) {
  const filePath = resources.APPLICATION_URL + "download/" + fileName;
  return filePath;
}
//help buttom
const [isOpen, setIsopen] = useState(false)
const [isOpen2,setIsopen2] = useState(false)
const handleHelpOpen = (e) => {
  e.preventDefault(),
  setIsopen(true)
}
const handleHelpClose = () => {
  setIsopen(false)
}
const handleHelpOpen2 =(e)=>{
  e.preventDefault();
  setIsopen2(true)
} 
const handleHelpClose2 = (e)=>{
  setIsopen2(false)
}
  // state variables
  const [value111t1, setValue111t1] = useState();
  const [pathValue111f1, setPathValue111f1] = useState("");
  const [value111f1, setValue111f1] = useState([]);
  const [value111f2, setValue111f2] = useState([]);
  const [pathValue111f2, setPathValue111f2] = useState("");

  const [value1121t1, setValue1121t1] = useState();
  const [value1122t1, setValue1122t1] = useState();
  const [pathValue1121f1, setPathValue1121f1] = useState("");
  const [value1121f1, setValue1121f1] = useState([]);
  const [pathValue1121f2, setPathValue1121f2] = useState("");
  const [value1121f2, setValue1121f2] = useState([]);
  const [pathValue1121f3, setPathValue1121f3] = useState("");
  const [value1121f3, setValue1121f3] = useState([]);
  const [pathValue1121f4, setPathValue1121f4] = useState("");
  const [value1121f4, setValue1121f4] = useState([]);

  const [value1131t1, setValue1131t1] = useState();
  const [value1131t2, setValue1131t2] = useState();
  const [value1131t3, setValue1131t3] = useState();
  const [value1131t4, setValue1131t4] = useState();
  const [value1131t5, setValue1131t5] = useState();
  const [value1131t6, setValue1131t6] = useState();
  const [value1131t7, setValue1131t7] = useState();
  const [value1131t8, setValue1131t8] = useState();
  const [value1131t9, setValue1131t9] = useState();
  const [value1131t10, setValue1131t10] = useState();
  const [value1131t11, setValue1131t11] = useState();
  const [value1131t12, setValue1131t12] = useState();
  const [value1131t13, setValue1131t13] = useState();
  const [value1131t14, setValue1131t14] = useState();
  const [value1131t15, setValue1131t15] = useState();
  const [value1131t16, setValue1131t16] = useState();
  const [value1131t17, setValue1131t17] = useState();
  const [value1131t18, setValue1131t18] = useState();
  const [value1131t19, setValue1131t19] = useState();
  const [value1131t20, setValue1131t20] = useState();
  const [pathValue1131f1, setPathValue1131f1] = useState("");
  const [value1131f1, setValue1131f1] = useState([]);
  const [pathValue1131f2, setPathValue1131f2] = useState("");
  const [value1131f2, setValue1131f2] = useState([]);
  const [pathValue1131f3, setPathValue1131f3] = useState("");
  const [value1131f3, setValue1131f3] = useState([]);
  const [pathValue1131f4, setPathValue1131f4] = useState("");
  const [value1131f4, setValue1131f4] = useState([]);
  const [pathValue1131f5, setPathValue1131f5] = useState("");
  const [value1131f5, setValue1131f5] = useState([]);

  const [responseButtonStatus112, setResponseButtonStatus112] = useState(false);
  const [responseButtonStatus113, setResponseButtonStatus113] = useState(false);
  // const [responseValue111, setResponseValue111] = useState("");
  const [responseValue112, setResponseValue112] = useState("");
  const [responseValue113, setResponseValue113] = useState("");
  const [help111Status, setHelp111Status] = useState(false);
  const [help112Status, setHelp112Status] = useState(false);
  const [help113Status, setHelp113Status] = useState(false);

  // get API
  const financialYear = "2021-2022";
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

  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria1getallfiles?collegeId=' + collegeId + '&financialYear=' +
        fYear +
        '&typeofInstitution=' + instituteType
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            setValue111t1(
              data[0].criteria11Ql[0] ? data[0].criteria11Ql[0].input111t1 : ""
            );
            // setResponseValue111(data[0].criteria11Ql[0].response111);

            setResponseValue112(
              data[0].criteria11Qn[0] ? data[0].criteria11Qn[0].response112 : ""
            );
            setResponseValue113(
              data[0].criteria11Qn[0] ? data[0].criteria11Qn[0].response113 : ""
            );

            setValue1121t1(
              data[0].criteria11Qn[0] ? data[0].criteria11Qn[0].input1121t1 : ""
            );
            setValue1122t1(
              data[0].criteria11Qn[0] ? data[0].criteria11Qn[0].input1122t1 : ""
            );

            setValue1131t1(
              data[0].yearTable1131[0]
                ? data[0].yearTable1131[0].input1131y
                : ""
            );
            setValue1131t6(
              data[0].yearTable1131[0]
                ? data[0].yearTable1131[0].input1131v
                : ""
            );

            setValue1131t2(
              data[0].yearTable1131[1]
                ? data[0].yearTable1131[1].input1131y
                : ""
            );
            setValue1131t7(
              data[0].yearTable1131[1]
                ? data[0].yearTable1131[1].input1131v
                : ""
            );

            setValue1131t3(
              data[0].yearTable1131[2]
                ? data[0].yearTable1131[2].input1131y
                : ""
            );
            setValue1131t8(
              data[0].yearTable1131[2]
                ? data[0].yearTable1131[2].input1131v
                : ""
            );

            setValue1131t4(
              data[0].yearTable1131[3]
                ? data[0].yearTable1131[3].input1131y
                : ""
            );
            setValue1131t9(
              data[0].yearTable1131[3]
                ? data[0].yearTable1131[3].input1131v
                : ""
            );

            setValue1131t5(
              data[0].yearTable1131[4]
                ? data[0].yearTable1131[4].input1131y
                : ""
            );
            setValue1131t10(
              data[0].yearTable1131[4]
                ? data[0].yearTable1131[4].input1131v
                : ""
            );

            setValue1131t11(
              data[0].yeartable11312[0]
                ? data[0].yeartable11312[0].input1132y
                : ""
            );
            setValue1131t16(
              data[0].yeartable11312[0]
                ? data[0].yeartable11312[0].input1132v
                : ""
            );

            setValue1131t12(
              data[0].yeartable11312[1]
                ? data[0].yeartable11312[1].input1132y
                : ""
            );
            setValue1131t17(
              data[0].yeartable11312[1]
                ? data[0].yeartable11312[1].input1132v
                : ""
            );

            setValue1131t13(
              data[0].yeartable11312[2]
                ? data[0].yeartable11312[2].input1132y
                : ""
            );
            setValue1131t18(
              data[0].yeartable11312[2]
                ? data[0].yeartable11312[2].input1132v
                : ""
            );

            setValue1131t14(
              data[0].yeartable11312[3]
                ? data[0].yeartable11312[3].input1132y
                : ""
            );
            setValue1131t19(
              data[0].yeartable11312[3]
                ? data[0].yeartable11312[3].input1132v
                : ""
            );

            setValue1131t15(
              data[0].yeartable11312[4]
                ? data[0].yeartable11312[4].input1132y
                : ""
            );
            setValue1131t20(
              data[0].yeartable11312[4]
                ? data[0].yeartable11312[4].input1132v
                : ""
            );

            // setValue111f1(data[0].criteria1FileUpload[0].criteria1FileName);
            // setValue111f2(data[0].criteria1FileUpload[1].criteria1FileName);
            // setValue1121f1(data[0].criteria1FileUpload[2].criteria1FileName);
            // setValue1121f2(data[0].criteria1FileUpload[3].criteria1FileName);
            // setValue1131f1(data[0].criteria1FileUpload[4].criteria1FileName);
            // setValue1131f2(data[0].criteria1FileUpload[5].criteria1FileName);
            // setValue1131f3(data[0].criteria1FileUpload[6].criteria1FileName);
            // setValue1131f4(data[0].criteria1FileUpload[7].criteria1FileName);
            // setValue1131f5(data[0].criteria1FileUpload[8].criteria1FileName);
          })
          .catch((error) => {
            console.error("Error:", error);
            errorMessage("Got the Error Please try after sometime");
          })
      ),
    []
  );
  // getfile data with API

  function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
  }
  // response button functionality
  function onClickingViewResponse112() {
    if (value1121t1 === "" || value1122t1 === "") {
      setResponseValue112("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value1121t1, 10)) === false
      || Number.isInteger(parseInt(value1122t1, 10)) === false
    ) {
      setResponseValue112("Input should be an Integer");
    } else if (value1121t1 !== "" && value1122t1 !== "") {
      setResponseValue112(
        (parseInt(value1121t1, 10) / parseInt(value1122t1, 10)) * 100
      );
    }
  }

  function onClickingViewResponse113() {
    if (
      value1131t6 === ""
      || value1131t7 === ""
      || value1131t8 === ""
      || value1131t9 === ""
      || value1131t10 === ""
      || value1131t16 === ""
      || value1131t17 === ""
      || value1131t18 === ""
      || value1131t19 === ""
      || value1131t20 === ""
      || value1131t6 === undefined
      || value1131t7 === undefined
      || value1131t8 === undefined
      || value1131t9 === undefined
      || value1131t10 === undefined
      || value1131t16 === undefined
      || value1131t17 === undefined
      || value1131t18 === undefined
      || value1131t19 === undefined
      || value1131t20 === undefined
    ) {
      setResponseValue113("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value1131t6, 10)) === false
      || Number.isInteger(parseInt(value1131t7, 10)) === false
      || Number.isInteger(parseInt(value1131t8, 10)) === false
      || Number.isInteger(parseInt(value1131t9, 10)) === false
      || Number.isInteger(parseInt(value1131t10, 10)) === false
      || Number.isInteger(parseInt(value1131t16, 10)) === false
      || Number.isInteger(parseInt(value1131t17, 10)) === false
      || Number.isInteger(parseInt(value1131t18, 10)) === false
      || Number.isInteger(parseInt(value1131t19, 10)) === false
      || Number.isInteger(parseInt(value1131t20, 10)) === false
    ) {
      setResponseValue113("Input should be an Integer");
    } else if (
      value1131t6 !== ""
      && value1131t7 !== ""
      && value1131t8 !== ""
      && value1131t9 !== ""
      && value1131t10 !== ""
      && value1131t16 !== ""
      && value1131t17 !== ""
      && value1131t18 !== ""
      && value1131t19 !== ""
      && value1131t20 !== ""
    ) {
      setResponseValue113(
        ((value1131t6 / value1131t16) * 100
          + (value1131t7 / value1131t17) * 100
          + (value1131t8 / value1131t18) * 100
          + (value1131t9 / value1131t19) * 100
          + (value1131t10 / value1131t20) * 100)
        / 5
      );
    }
  }



  // sending data to db with API

  const inputDataList = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    criteria11Ql: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input111t1: value111t1,
        // response111: responseValue111,
      },
    ],
    criteria11Qn: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input1121t1: value1121t1,
        input1122t1: value1122t1,
        response112: responseValue112,
        response113: responseValue113,
        criteria11status: "save",
      },
    ],
    yearTable1131: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input1131y: value1131t1,
        input1131v: value1131t6,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        input1131y: value1131t2,
        input1131v: value1131t7,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        input1131y: value1131t3,
        input1131v: value1131t8,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        input1131y: value1131t4,
        input1131v: value1131t9,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 5,
        input1131y: value1131t5,
        input1131v: value1131t10,
      },
    ],

    yearTable11312: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input11312y: value1131t11,
        input11312v: value1131t16,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        input11312y: value1131t12,
        input11312v: value1131t17,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        input11312y: value1131t13,
        input11312v: value1131t18,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        input11312y: value1131t14,
        input11312v: value1131t19,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 5,
        input11312y: value1131t15,
        input11312v: value1131t20,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form11Data = new FormData();
    console.log("inputDataList ==>" + JSON.stringify(inputDataList));
    form11Data.append("criteria1Fieldinfo", jsonBlob(inputDataList));
    if (pathValue111f1 !== "") {
      form11Data.append("uploadfile1", value111f1, "f111f1-" + value111f1.name);
    }
    if (pathValue111f2 !== "") {
      form11Data.append("uploadfile1", value111f2, "f111f2-" + value111f2.name);
    }
    if (pathValue1121f1 !== "") {
      form11Data.append(
        "uploadfile1",
        value1121f1,
        "f1121f1-" + value1121f1.name
      );
    }
    if (pathValue1121f2 !== "") {
      form11Data.append(
        "uploadfile1",
        value1121f2,
        "f1121f2-" + value1121f2.name
      );
    }
    if (pathValue1121f3 !== "") {
      form11Data.append(
        "uploadfile1",
        value1121f3,
        "f1121f3-" + value1121f3.name
      );
    }
    if (pathValue1131f1 !== "") {
      form11Data.append(
        "uploadfile1",
        value1131f1,
        "f1131f1-" + value1131f1.name
      );
    }
    if (pathValue1131f2 !== "") {
      form11Data.append(
        "uploadfile1",
        value1131f2,
        "f1131f2-" + value1131f2.name
      );
    }
    if (pathValue1131f3 !== "") {
      form11Data.append(
        "uploadfile1",
        value1131f3,
        "f1131f3-" + value1131f3.name
      );
    }
    if (pathValue1131f4 !== "") {
      form11Data.append(
        "uploadfile1",
        value1131f4,
        "f1131f4-" + value1131f4.name
      );
    }
    if (pathValue1131f5 !== "") {
      form11Data.append(
        "uploadfile1",
        value1131f5,
        "f1131f5-" + value1131f5.name
      );
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form11Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria1upload",
      filesFetchMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Inserted Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingModify() {
    const form11Data = new FormData();

    form11Data.append("criteria1Fieldinfo", jsonBlob(inputDataList));
    if (pathValue111f1 !== "") {
      form11Data.append("uploadfile1", value111f1, "f111f1-" + value111f1.name);
    }
    if (pathValue111f2 !== "") {
      form11Data.append("uploadfile1", value111f2, "f111f2-" + value111f2.name);
    }
    if (pathValue1121f1 !== "") {
      form11Data.append(
        "uploadfile1",
        value1121f1,
        "f1121f1-" + value1121f1.name
      );
    }
    if (pathValue1121f2 !== "") {
      form11Data.append(
        "uploadfile1",
        value1121f2,
        "f1121f2-" + value1121f2.name
      );
    }
    if (pathValue1121f3 !== "") {
      form11Data.append(
        "uploadfile1",
        value1121f3,
        "f1121f3-" + value1121f3.name
      );
    }
    if (pathValue1131f1 !== "") {
      form11Data.append(
        "uploadfile1",
        value1131f1,
        "f1131f1-" + value1131f1.name
      );
    }
    if (pathValue1131f2 !== "") {
      form11Data.append(
        "uploadfile1",
        value1131f2,
        "f1131f2-" + value1131f2.name
      );
    }
    if (pathValue1131f3 !== "") {
      form11Data.append(
        "uploadfile1",
        value1131f3,
        "f1131f3-" + value1131f3.name
      );
    }
    if (pathValue1131f4 !== "") {
      form11Data.append(
        "uploadfile1",
        value1131f4,
        "f1131f4-" + value1131f4.name
      );
    }
    if (pathValue1131f5 !== "") {
      form11Data.append(
        "uploadfile1",
        value1131f5,
        "f1131f5-" + value1131f5.name
      );
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form11Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria1upload",
      filesFetchMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Authorized Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }


  // rendering DOM
  return (
    <div className="c11-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c11x-colorIndicator-container">
        <p className="c11x-QlcolorIndicator-circle-style"></p>
        <span className="c11x-colorIndicator-span-style">Qualitative</span>
        <p className="c11x-QtcolorIndicator-circle-style"></p>
        <span className="c11x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c11x-weightage-heading-style">
            Key Indicator Weightage: 50
          </h1>
        </div>
      </div>

      {/* Key Indicator: 1.1.1 */}
      <div className="c11x-eachInputField-container">
        <div className="c11x-weightage-container">
          <h1 className="c11x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c11x-Ql-label-textarea-container">
            <div className="c11x-heading_Help-container">
              <h1 className="c11x-heading-style">
                <span className="c11x-span-style">1.1.1: </span>
                Curricula developed and implemented have relevance to the local,
                national, regional and global developmental needs which is
                reflected in Programme outcomes (POs), Programme Specific
                Outcomes(PSOs) and Course Outcomes(COs) of the Programmes
                offered by the Institution.
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Write description in a maximum of 500 words'
              ></HelpButton>
            </div>
            <label htmlFor="111-t1" className="c11x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue111t1(e.target.value);
                setResponseValue111(e.target.value);
              }}
              value={value111t1}
              rows={10}
              className="c11x-textarea-style"
              id="111-t1"
            ></textarea>
            {value111t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c11x-Ql-table-style">
            <tr>
              <th className="c11x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c11x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c11x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c11x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c11x-Ql-tableBorders-style">
                Any additional information
              </td>
              <td className="c11x-Ql-tableBorders-style">
                {/* <td className="c11x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue111f1(e.target.files[0]);
                    setPathValue111f1(e.target.value);
                  }}
                  id="111-f1"
                  type="file"
                  className="c11-fileButton-style"
                />
                {pathValue111f1 === "" ? null : (
                  <div className="c11-fileButtons-container">
                    <button className="c11-viewFileButton-style">
                      View File
                    </button>

                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue111f1("");
                      document.getElementById("111-f1").value="" }} >
                      Reset
                    </button>

                  </div>
                )}
                <a href={downloadFile(value111f1)} target="_blank">View File</a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 

              </td> */}
                <Button variant="contained" component="label">
                  File Upload
                  <input
                    className="input-text"

                    multiple
                    type="file"
                    id="111-f1"
                    accept="pdf"
                    style={{ display: "none" }}
                    onChange={(e) => {
                      setValue111f1(e.target.files[0]);
                      setPathValue111f1(e.target.value);
                      showFilePreview(e);
                    }}
                  />
                </Button>
                {pathValue111f1}
                {pathValue111f1 === "" ? null : (
                  <div className="c21-fileButtons-container">
                    <button
                      className="c21-viewFileButton-style"
                      style={{ height: "37px", width: "70px" }}
                    >
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPpathValue111f1("");
                        document.getElementById("111-f1").value = "";
                      }}
                      style={{ height: "37px", width: "70px" }}
                    >
                      Reset
                    </button>
                  </div>
                )}
              </td>
              <td className="c11x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c11x-Ql-tableBorders-style">
                Link for Additional Information
              </td>
              <td>
              {/* <td className="c11x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue111f2(e.target.files[0]);
                    setPathValue111f2(e.target.value);
                  }}
                  id="111-f2"
                  type="file"
                  className="c11-fileButton-style"
                />
                {pathValue111f2 === "" ? null : (
                  <div className="c11-fileButtons-container">
                    <button className="c11-viewFileButton-style">
                      View File
                    </button>

                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue111f2("");
                      document.getElementById("111-f2").value="" }} >
                      Reset
                    </button>

                  </div>
                )}
                <a href={downloadFile(value111f1)} target="_blank">View File</a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
              </td> */}
              <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"

                  multiple
                  type="file"
                  id="111-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue111f2(e.target.files[0]);
                    setPathValue111f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue111f2}
              {pathValue111f2 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue111f2("");
                      document.getElementById("111-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
            </td>
            <td className="c11x-Ql-tableBorders-style">pdf</td>
          </tr>
        </table>
      </form>
    </div>

      {/* Key Indicator: 1.1.2 */ }
      <div className="c11x-eachInputField-container">
        <div className="c11x-weightage-container">
          <h1 className="c11x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c11x-container">
            <div className="c11x-heading_Help-container">
              <h1 className="c11x-heading-style">
                <span className="c11x-span-style">1.1.2: </span>
                Percentage of Programmes where syllabus revision was carried out
                during the last five years.
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <label htmlFor="111-t1" className="c11x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue111t1(e.target.value);
                setResponseValue111(e.target.value);
              }}
              value={value111t1}
              rows={10}
              className="c11x-textarea-style"
              id="111-t1"
            ></textarea>
            {value111t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          
          </div>
          <div className="c11xx-container">
            
            <table className="c11x-table-style">
              <tr>
                <th className="c11x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c11x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c11x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c11x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td> Upload Additional information</td>
                <td></td>
               {/*  <td>
                  <input
                    onChange={(e) => {
                      setValue1121f1(e.target.files[0]);
                      setPathValue1121f1(e.target.value);
                    }}
                    id="1121-f1"
                    type="file"
                    className="c11-fileButton-style"
                  />
                  {pathValue1121f1 === "" ? null : (
                    <div className="c11-fileButtons-container">
                      <button className="c11-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue1121f1("");
                      document.getElementById("1121-f1").value="" }} >
                      Reset
                    </button>


                    </div>
                  )}
                  <a href={downloadFile(value111f1)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                <td>
                 <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                  id="1121-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue1121f1(e.target.files[0]);
                    setPathValue1121f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue1121f1}
              {pathValue1121f1 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPpathValue1121f1("");
                      document.getElementById("1121-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c11x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Provide Link for Additional information
</td>
                <td></td>
                {/* <td>
                  <input
                    onChange={(e) => {
                      setValue1121f2(e.target.files[0]);
                      setPathValue1121f2(e.target.value);
                    }}
                    id="1121-f2"
                    type="file"
                    className="c11-fileButton-style"
                  />
                  {pathValue1121f2 === "" ? null : (
                    <div className="c11-fileButtons-container">
                      <button className="c11-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue1121f2("");
                      document.getElementById("1121-f2").value="" }} >
                      Reset
                    </button>

                    </div>
                  )}
                  <a href={downloadFile(value111f1)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                <td>
                <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="1121-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue1121f2(e.target.files[0]);
                    setPathValue1121f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue1121f2}
              {pathValue1121f2 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPpathValue1121f2("");
                      document.getElementById("1121-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c11x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Details of program syllabus revision in last 5 years(Data
                  Template)
                </td>
                <td>
                  
                <a href={downloadFile("au1.1.xlsx")} target="_blank"> View Template
                  </a>
                </td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue1121f3(e.target.files[0]);
                      setPathValue1121f3(e.target.value);
                    }}
                    id="1121-f3"
                    type="file"
                    className="c11-fileButton-style"
                  />
                  {pathValue1121f3 === "" ? null : (
                    <div className="c11-fileButtons-container">
                      <button className="c11-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue1121f3("");
                      document.getElementById("1121-f3").value="" }} >
                      Reset
                    </button>

                    </div>
                  )}
                  <a href={downloadFile(value111f1)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                 <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="1121-f3"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue1121f3(e.target.files[0]);
                      setPathValue1121f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue1121f3}
              {pathValue1121f3 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPpathValue1121f3("");
                      document.getElementById("1121-f3").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c11x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      
      <div className="c11x-button-container">
        <button onClick={onClickingModify} className="c11x-button-style">
          Modify
        </button>
      </div>
    </div >
  );
}

export default Criteria11;
