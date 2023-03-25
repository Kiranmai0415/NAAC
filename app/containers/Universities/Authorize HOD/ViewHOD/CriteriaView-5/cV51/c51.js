import React, { useState, useEffect } from "react";
import "./c51-style.css";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
import { resources } from "../../../../../appConstants";
// Help buttons functionality
function Help511(props) {
  return props.isHelp511Clicked ? (
    <div className="c51x-help-mainContainer">
      <div className="c51x-help-subContainer">
        <h1 className="c51x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c51x-help-para-style">
          Percentage per year
          <span style={{ fontWeight: "bold" }}>(</span>Number of Students
          benifited by scholarships and freeships by government
          <span style={{ fontWeight: "bold" }}>) /</span>
          <span style={{ fontWeight: "bold" }}>(</span> Number of students
          <span style={{ fontWeight: "bold" }}>) /</span>*100
        </p>
        <p className="c51x-help-para-style">
          Average
          <span style={{ fontWeight: "bold" }}>=(</span> ΣPercentage per year
          <span style={{ fontWeight: "bold" }}>) /</span> 5
        </p>
        <button
          className="c51x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp511Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help512(props) {
  return props.isHelp512Clicked ? (
    <div className="c51x-help-mainContainer">
      <div className="c51x-help-subContainer">
        <h1 className="c51x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c51x-help-para-style">
          Percentage per year<span style={{ fontWeight: "bold" }}>=</span>
          <span style={{ fontWeight: "bold" }}>(</span>Total number of students
          benifited by scholarships and freeships besides government
          <span style={{ fontWeight: "bold" }}>) /</span>
          <span style={{ fontWeight: "bold" }}>(</span> Number of students
          <span style={{ fontWeight: "bold" }}>) </span>*100
        </p>
        <p className="c51x-help-para-style">
          Average percentage<span style={{ fontWeight: "bold" }}>=</span>
          <span style={{ fontWeight: "bold" }}>(</span> ΣPercentage per year
          <span style={{ fontWeight: "bold" }}>) /</span> 5
        </p>
        <button
          className="c51x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp512Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help513(props) {
  return props.isHelp513Clicked ? (
    <div className="c51x-help-mainContainer">
      <div className="c51x-help-subContainer">
        <h1 className="c51x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c51x-help-para-style">Average percentage</p>
        <button
          className="c51x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp513Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help514(props) {
  return props.isHelp514Clicked ? (
    <div className="c51x-help-mainContainer">
      <div className="c51x-help-subContainer">
        <h1 className="c51x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c51x-help-para-style">Percentage per year</p>
        <button
          className="c51x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp514Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria51() {
  // state variables
// getfile data with API
function downloadFile(fileName) {
  const filePath = resources.APPLICATION_URL + "download/" + fileName;
  return filePath;
}
//help buttom
const [isOpen, setIsopen] = useState(false)
const [isOpen3, setIsopen3] = useState(false)
const [isOpen4, setIsopen4] = useState(false)
const [isOpen2,setIsopen2] = useState(false)
const handleHelpOpen = (e) => {
  e.preventDefault(),
  setIsopen(true)
}
const handleHelpClose = () => {
  setIsopen(false)
}
const handleHelpOpen2 = (e) => {
  e.preventDefault(),
  setIsopen2(true)
}
const handleHelpClose2 = () => {
  setIsopen2(false)
}
const handleHelpOpen3 = (e) => {
  e.preventDefault(),
  setIsopen3(true)
}
const handleHelpClose3 = () => {
  setIsopen3(false)
}
const handleHelpOpen4 =(e)=>{
  e.preventDefault();
  setIsopen4(true)
} 
const handleHelpClose4= (e)=>{
  setIsopen4(false)
}
  const [value5111t1, setValue5111t1] = useState();
  const [value5111t2, setValue5111t2] = useState();
  const [value5111t3, setValue5111t3] = useState();
  const [value5111t4, setValue5111t4] = useState();
  const [value5111t5, setValue5111t5] = useState();
  const [value5111t6, setValue5111t6] = useState();
  const [value5111t7, setValue5111t7] = useState();
  const [value5111t8, setValue5111t8] = useState();
  const [value5111t9, setValue5111t9] = useState();
  const [value5111t10, setValue5111t10] = useState();
  const [value5111t11, setValue5111t11] = useState();
  const [value5111t12, setValue5111t12] = useState();
  const [value5111t13, setValue5111t13] = useState();
  const [value5111t14, setValue5111t14] = useState();
  const [value5111t15, setValue5111t15] = useState();
  const [value5111t16, setValue5111t16] = useState();
  const [value5111t17, setValue5111t17] = useState();
  const [value5111t18, setValue5111t18] = useState();
  const [value5111t19, setValue5111t19] = useState();
  const [value5111t20, setValue5111t20] = useState();

  const [value5121t1, setValue5121t1] = useState();
  const [value5121t2, setValue5121t2] = useState();
  const [value5121t3, setValue5121t3] = useState();
  const [value5121t4, setValue5121t4] = useState();
  const [value5121t5, setValue5121t5] = useState();
  const [value5121t6, setValue5121t6] = useState();
  const [value5121t7, setValue5121t7] = useState();
  const [value5121t8, setValue5121t8] = useState();
  const [value5121t9, setValue5121t9] = useState();
  const [value5121t10, setValue5121t10] = useState();
  const [value5121t11, setValue5121t11] = useState();
  const [value5121t12, setValue5121t12] = useState();
  const [value5121t13, setValue5121t13] = useState();
  const [value5121t14, setValue5121t14] = useState();
  const [value5121t15, setValue5121t15] = useState();
  const [value5121t16, setValue5121t16] = useState();
  const [value5121t17, setValue5121t17] = useState();
  const [value5121t18, setValue5121t18] = useState();
  const [value5121t19, setValue5121t19] = useState();
  const [value5121t20, setValue5121t20] = useState();

  const [value513t1, setValue513t1] = useState();
  const [value513f1, setValue513f1] = useState([]);
  const [value513f2, setValue513f2] = useState([]);
  const [value513f3, setValue513f3] = useState([]);
  const [pathValue513f1, setPathValue513f1] = useState("");
  const [pathValue513f2, setPathValue513f2] = useState("");
  const [pathValue513f3, setPathValue513f3] = useState("");

  const [pathValue5111f1, setPathValue5111f1] = useState("");
  const [pathValue5111f2, setPathValue5111f2] = useState("");
  const [pathValue5111f3, setPathValue5111f3] = useState("");
  const [pathValue5111f4, setPathValue5111f4] = useState("");
  const [value5111f1, setValue5111f1] = useState([]);
  const [value5111f2, setValue5111f2] = useState([]);
  const [value5111f3, setValue5111f3] = useState([]);
  const [value5111f4, setValue5111f4] = useState([]);

  const [pathValue5121f1, setPathValue5121f1] = useState("");
  const [pathValue5121f2, setPathValue5121f2] = useState("");
  const [pathValue5121f3, setPathValue5121f3] = useState("");
  const [value5121f1, setValue5121f1] = useState([]);
  const [value5121f2, setValue5121f2] = useState([]);
  const [value5121f3, setValue5121f3] = useState([]);
  const [value514t1, setValue514t1] = useState();
  const [pathValue514f1, setPathValue514f1] = useState("");
  const [pathValue514f2, setPathValue514f2] = useState("");
  const [pathValue514f3, setPathValue514f3] = useState("");
  const [value514f1, setValue514f1] = useState([]);
  const [value514f2, setValue514f2] = useState([]);
  const [value514f3, setValue514f3] = useState([]);

  const [responseButtonStatus511, setResponseButtonStatus511] = useState(false);
  const [responseButtonStatus512, setResponseButtonStatus512] = useState(false);

  const [responseValue511, setResponseValue511] = useState("");
  const [responseValue512, setResponseValue512] = useState("");
  const [responseValue513, setResponseValue513] = useState("");
  const [responseValue514, setResponseValue514] = useState("");
  const [help511Status, setHelp511Status] = useState(false);
  const [help512Status, setHelp512Status] = useState(false);
  const [help513Status, setHelp513Status] = useState(false);
  const [help514Status, setHelp514Status] = useState(false);

  // getfile data with API
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


  
  function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
  }
  //get data api

  const financialYear = "2021-2022";
  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria5getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setValue513t1(data[0].criteria51Qn[0] ? data[0].criteria51Qn[0].input513t1 : "");
            setValue514t1(data[0].criteria51Qn[0] ? data[0].criteria51Qn[0].input514t1 : "");

            setValue5111t1(data[0].yearTable5111[0] ? data[0].yearTable5111[0].input5111y : "");
            setValue5111t2(data[0].yearTable5111[1] ? data[0].yearTable5111[1].input5111y : "");
            setValue5111t3(data[0].yearTable5111[2] ? data[0].yearTable5111[2].input5111y : "");
            setValue5111t4(data[0].yearTable5111[3] ? data[0].yearTable5111[3].input5111y : "");
            setValue5111t5(data[0].yearTable5111[4] ? data[0].yearTable5111[4].input5111y : "");
            setValue5111t6(data[0].yearTable5111[0] ? data[0].yearTable5111[0].input5111v : "");
            setValue5111t7(data[0].yearTable5111[1] ? data[0].yearTable5111[1].input5111v : "");
            setValue5111t8(data[0].yearTable5111[2] ? data[0].yearTable5111[2].input5111v : "");
            setValue5111t9(data[0].yearTable5111[3] ? data[0].yearTable5111[3].input5111v : "");
            setValue5111t10(data[0].yearTable5111[4] ? data[0].yearTable5111[4].input5111v : "");

            // setValue5111t11(data[0].yearTable51112[0] ? data[0].yearTable51112[0].input51112y : "");
            // setValue5111t12(data[0].yearTable51112[1] ? data[0].yearTable51112[1].input51112y : "");
            // setValue5111t13(data[0].yearTable51112[2] ? data[0].yearTable51112[2].input51112y : "");
            // setValue5111t14(data[0].yearTable51112[3] ? data[0].yearTable51112[3].input51112y : "");
            // setValue5111t15(data[0].yearTable51112[4] ? data[0].yearTable51112[4].input51112y : "");
            // setValue5111t16(data[0].yearTable51112[0] ? data[0].yearTable51112[0].input51112v : "");
            // setValue5111t17(data[0].yearTable51112[1] ? data[0].yearTable51112[1].input51112v : "");
            // setValue5111t18(data[0].yearTable51112[2] ? data[0].yearTable51112[2].input51112v : "");
            // setValue5111t19(data[0].yearTable51112[3] ? data[0].yearTable51112[3].input51112v : "");
            // setValue5111t20(data[0].yearTable51112[4] ? data[0].yearTable51112[4].input51112v : "");

            // setValue5121t1(data[0].yearTable5121[0] ? data[0].yearTable5121[0].input5121y : "");
            // setValue5121t2(data[0].yearTable5121[1] ? data[0].yearTable5121[1].input5121y : "");
            // setValue5121t3(data[0].yearTable5121[2] ? data[0].yearTable5121[2].input5121y : "");
            // setValue5121t4(data[0].yearTable5121[3] ? data[0].yearTable5121[3].input5121y : "");
            // setValue5121t5(data[0].yearTable5121[4] ? data[0].yearTable5121[4].input5121y : "");
            // setValue5121t6(data[0].yearTable5121[0] ? data[0].yearTable5121[0].input5121v : "");
            // setValue5121t7(data[0].yearTable5121[1] ? data[0].yearTable5121[1].input5121v : "");
            // setValue5121t8(data[0].yearTable5121[2] ? data[0].yearTable5121[2].input5121v : "");
            // setValue5121t9(data[0].yearTable5121[3] ? data[0].yearTable5121[3].input5121v : "");
            // setValue5121t10(data[0].yearTable5121[4] ? data[0].yearTable5121[4].input5121v : "");

            // setValue5121t11(data[0].yearTable51212[0] ? data[0].yearTable51212[0].input51212y : "");
            // setValue5121t12(data[0].yearTable51212[1] ? data[0].yearTable51212[1].input51212y : "");
            // setValue5121t13(data[0].yearTable51212[2] ? data[0].yearTable51212[2].input51212y : "");
            // setValue5121t14(data[0].yearTable51212[3] ? data[0].yearTable51212[3].input51212y : "");
            // setValue5121t15(data[0].yearTable51212[4] ? data[0].yearTable51212[4].input51212y : "");
            // setValue5121t16(data[0].yearTable51212[0] ? data[0].yearTable51212[0].input51212v : "");
            // setValue5121t17(data[0].yearTable51212[1] ? data[0].yearTable51212[1].input51212v : "");
            // setValue5121t18(data[0].yearTable51212[2] ? data[0].yearTable51212[2].input51212v : "");
            // setValue5121t19(data[0].yearTable51212[3] ? data[0].yearTable51212[3].input51212v : "");
            // setValue5121t20(data[0].yearTable51212[4] ? data[0].yearTable51212[4].input51212v : "");

            setValue513f1(data[0].criteria5FileUpload[0] ? data[0].criteria5FileUpload[0].criteria5FileName : "");
            setValue513f2(data[0].criteria5FileUpload[1] ? data[0].criteria5FileUpload[1].criteria5FileName : "");
            setValue513f3(data[0].criteria5FileUpload[2] ? data[0].criteria5FileUpload[2].criteria5FileName : "");
            setValue5111f1(data[0].criteria5FileUpload[3] ? data[0].criteria5FileUpload[3].criteria5FileName : "");
            setValue5111f2(data[0].criteria5FileUpload[4] ? data[0].criteria5FileUpload[4].criteria5FileName : "");
            setValue5111f3(data[0].criteria5FileUpload[5] ? data[0].criteria5FileUpload[5].criteria5FileName : "");
            setValue5111f3(data[0].criteria5FileUpload[5] ? data[0].criteria5FileUpload[5].criteria5FileName : "");
            setValue5111f4(data[0].criteria5FileUpload[6] ? data[0].criteria5FileUpload[6].criteria5FileName : "");
            setValue5121f1(data[0].criteria5FileUpload[7] ? data[0].criteria5FileUpload[7].criteria5FileName : "");
            setValue5121f2(data[0].criteria5FileUpload[8] ? data[0].criteria5FileUpload[8].criteria5FileName : "");
            setValue5121f3(data[0].criteria5FileUpload[9] ? data[0].criteria5FileUpload[9].criteria5FileName : "");
            setValue514f1(data[0].criteria5FileUpload[10] ? data[0].criteria5FileUpload[10].criteria5FileName : "");
            setValue514f2(data[0].criteria5FileUpload[11] ? data[0].criteria5FileUpload[11].criteria5FileName : "");
            setValue514f3(data[0].criteria5FileUpload[12] ? data[0].criteria5FileUpload[12].criteria5FileName : "");
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );
  // response button functionality
  function onClickingViewResponse511() {
    if (
      value5111t6 === "" ||
      value5111t7 === "" ||
      value5111t8 === "" ||
      value5111t9 === "" ||
      value5111t10 === "" ||
      value5111t16 === "" ||
      value5111t17 === "" ||
      value5111t18 === "" ||
      value5111t19 === "" ||
      value5111t20 === "" ||
      value5111t6 === undefined ||
      value5111t7 === undefined ||
      value5111t8 === undefined ||
      value5111t9 === undefined ||
      value5111t10 === undefined ||
      value5111t16 === undefined ||
      value5111t17 === undefined ||
      value5111t18 === undefined ||
      value5111t19 === undefined ||
      value5111t20 === undefined
    ) {
      setResponseValue511("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value5111t6, 10)) === false ||
      Number.isInteger(parseInt(value5111t7, 10)) === false ||
      Number.isInteger(parseInt(value5111t8, 10)) === false ||
      Number.isInteger(parseInt(value5111t9, 10)) === false ||
      Number.isInteger(parseInt(value5111t10, 10)) === false ||
      Number.isInteger(parseInt(value5111t16, 10)) === false ||
      Number.isInteger(parseInt(value5111t17, 10)) === false ||
      Number.isInteger(parseInt(value5111t18, 10)) === false ||
      Number.isInteger(parseInt(value5111t19, 10)) === false ||
      Number.isInteger(parseInt(value5111t20, 10)) === false
    ) {
      setResponseValue511("Input should be an Integer");
    } else if (
      value5111t6 !== "" &&
      value5111t7 !== "" &&
      value5111t8 !== "" &&
      value5111t9 !== "" &&
      value5111t10 !== "" &&
      value5111t16 !== "" &&
      value5111t17 !== "" &&
      value5111t18 !== "" &&
      value5111t19 !== "" &&
      value5111t20 !== ""
    ) {
      setResponseValue511(
        ((value5111t6 / value5111t16) * 100 +
          (value5111t7 / value5111t17) * 100 +
          (value5111t8 / value5111t18) * 100 +
          (value5111t9 / value5111t19) * 100 +
          (value5111t10 / value5111t20) * 100) /
          5
      );
    }
  }

  function onClickingViewResponse512() {
    if (
      value5121t6 === "" ||
      value5121t7 === "" ||
      value5121t8 === "" ||
      value5121t9 === "" ||
      value5121t10 === "" ||
      value5121t16 === "" ||
      value5121t17 === "" ||
      value5121t18 === "" ||
      value5121t19 === "" ||
      value5121t20 === "" ||
      value5121t6 === undefined ||
      value5121t7 === undefined ||
      value5121t8 === undefined ||
      value5121t9 === undefined ||
      value5121t10 === undefined ||
      value5121t16 === undefined ||
      value5121t17 === undefined ||
      value5121t18 === undefined ||
      value5121t19 === undefined ||
      value5121t20 === undefined
    ) {
      setResponseValue512("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value5121t6, 10)) === false ||
      Number.isInteger(parseInt(value5121t7, 10)) === false ||
      Number.isInteger(parseInt(value5121t8, 10)) === false ||
      Number.isInteger(parseInt(value5121t9, 10)) === false ||
      Number.isInteger(parseInt(value5121t10, 10)) === false ||
      Number.isInteger(parseInt(value5121t16, 10)) === false ||
      Number.isInteger(parseInt(value5121t17, 10)) === false ||
      Number.isInteger(parseInt(value5121t18, 10)) === false ||
      Number.isInteger(parseInt(value5121t19, 10)) === false ||
      Number.isInteger(parseInt(value5121t20, 10)) === false
    ) {
      setResponseValue512("Input should be an Integer");
    } else if (
      value5121t6 !== "" &&
      value5121t7 !== "" &&
      value5121t8 !== "" &&
      value5121t9 !== "" &&
      value5121t10 !== "" &&
      value5121t16 !== "" &&
      value5121t17 !== "" &&
      value5121t18 !== "" &&
      value5121t19 !== "" &&
      value5121t20 !== ""
    ) {
      setResponseValue512(
        setResponseValue512(
          ((value5121t6 / value5121t16) * 100 +
            (value5121t7 / value5121t17) * 100 +
            (value5121t8 / value5121t18) * 100 +
            (value5121t9 / value5121t19) * 100 +
            (value5121t10 / value5121t20) * 100) /
            5
        )
      );
    }
  }

  // sending data to db with API

  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    criteria51Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input513t1: value513t1,
        input514t1: value514t1,
        response511: responseValue511,
        response512: responseValue512,
        response514: responseValue514,
        response513: responseValue513,
      },
    ],

    yearTable5111: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input5111y: value5111t11,
        input5111v: value5111t16,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input5111y: value5111t12,
        input5111v: value5111t17,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input5111y: value5111t13,
        input5111v: value5111t18,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input5111y: value5111t14,
        input5111v: value5111t19,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input5111y: value5111t15,
        input5111v: value5111t20,
      },
    ],

    yearTable51112: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input51112y: value5111t11,
        input51112v: value5111t16,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input51112y: value5111t12,
        input51112v: value5111t17,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input51112y: value5111t13,
        input51112v: value5111t18,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input51112y: value5111t14,
        input51112v: value5111t19,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input51112y: value5111t15,
        input51112v: value5111t20,
      },
    ],
    yearTable5121: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input5121y: value5121t1,
        input5121v: value5121t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input5121y: value5121t2,
        input5121v: value5121t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input5121y: value5121t3,
        input5121v: value5121t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input5121y: value5121t4,
        input5121v: value5121t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input5121y: value5121t5,
        input5121v: value5121t10,
      },
    ],
    yearTable51212: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input51212y: value5121t1,
        input51212v: value5121t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input51212y: value5121t2,
        input51212v: value5121t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input51212y: value5121t3,
        input51212v: value5121t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input51212y: value5121t4,
        input51212v: value5121t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input51212y: value5121t5,
        input51212v: value5121t10,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  // rendering dom
  return (
    <div className="c51-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c51x-colorIndicator-container">
        <p className="c51x-QlcolorIndicator-circle-style"></p>
        <span className="c51x-colorIndicator-span-style">Qualitative</span>
        <p className="c51x-QtcolorIndicator-circle-style"></p>
        <span className="c51x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c51x-weightage-heading-style">
            Key Indicator Weightage: 30
          </h1>
        </div>
      </div>

      {/* Key Indicator: 5.1.1 */}
      <div className="c51x-eachInputField-container">
        <div className="c51x-weightage-container">
          <h1 className="c51x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c51x-container">
            <div className="c51x-heading_Help-container">
              <h1 className="c51x-heading-style">
                <span className="c51x-span-style">5.1.1: </span>
                Percentage of students benefited by scholarships and freeships 
                 provided by the institution, Government and non-government 
                bodies, industries, individuals, philanthropists during the last five 
                     years
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
                title='formula'
                ><h1>(Total number of students benefited by scholarships and freeships by institution,government and non-government agencies) /(1.1 Total number of students on rolls) * 100</h1></HelpButton>
            </div>
            <div className="c51x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus511(!responseButtonStatus511);
                  onClickingViewResponse511();
                }}
                className="c51x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus511 ? (
                <p className="c51x-responseResult-style">{responseValue511}</p>
              ) : null}
            </div>
          </div>
          <div className="c51xx-container">
            <h1 className="c51x-heading-style">
              <span className="c51x-span-style">5.1.1.1 </span>
               Number of students benefited by scholarships and freeships 
provided by the institution, Government and non-government bodies, 
industries, individuals, philanthropists year-wise during the last five 
years
            </h1>
            <table className="c51x-Qt-table-style">
              <tr>
                <th className="c51x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5111t1(e.target.value)}
                      id="5111-t1"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t1}
                    />
                    {value5111t1 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5111t2(e.target.value)}
                      id="5111-t2"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t2}
                    />
                    {value5111t2 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5111t3(e.target.value)}
                      id="5111-t3"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t3}
                    />
                    {value5111t3 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5111t4(e.target.value)}
                      id="5111-t4"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t4}
                    />
                    {value5111t4 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5111t5(e.target.value)}
                      id="5111-t5"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t5}
                    />
                    {value5111t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c51x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5111t6(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t6"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t6}
                    />
                    {value5111t6 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5111t7(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t7"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t7}
                    />
                    {value5111t7 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5111t8(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t8"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t8}
                    />
                    {value5111t8 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5111t9(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t9"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t9}
                    />
                    {value5111t9 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5111t10(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t10"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t10}
                    />
                    {value5111t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c51x-Qt-table-style">
              <tr>
                <th className="c51x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5111t11(e.target.value)}
                      id="5111-t11"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t11}
                    />
                    {value5111t11 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5111t12(e.target.value)}
                      id="5111-t12"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t12}
                    />
                    {value5111t12 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5111t13(e.target.value)}
                      id="5111-t13"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t13}
                    />
                    {value5111t13 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5111t14(e.target.value)}
                      id="5111-t14"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t14}
                    />
                    {value5111t14 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5111t15(e.target.value)}
                      id="5111-t15"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t15}
                    />
                    {value5111t15 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c51x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5111t16(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t16"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t16}
                    />
                    {value5111t16 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5111t17(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t17"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t17}
                    />
                    {value5111t17 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5111t18(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t18"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t18}
                    />
                    {value5111t18 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5111t19(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t19"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t19}
                    />
                    {value5111t19 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5111t20(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t20"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t20}
                    />
                    {value5111t20 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <table className="c51x-table-style">
              <tr>
                <th className="c51x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c51x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c51x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c51x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                  upload self attested letter with the list of students
                  sanctioned scholarships
                </td>
                <td></td>
                <td>
                  <a href={downloadFile(value5111f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <a href={downloadFile(value5111f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  {" "}
                  Average percentage of students benefited by scholarships and
                  freeships provided by the Government during the last five
                  years
                </td>
                <td>
                <a href={downloadFile("un5.1.1.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <a href={downloadFile(value5111f3)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 5.1.2 */}
      <div className="c51x-eachInputField-container">
        <div className="c51x-weightage-container">
          <h1 className="c51x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c51x-container">
            <div className="c51x-heading_Help-container">
              <h1 className="c51x-heading-style">
                <span className="c51x-span-style">5.1.2: </span>
                Efforts taken by the institution to provide career counseling 
                     including e-counseling and guidance for competitive examinations 
                    during the last five years
              </h1>
              <button
                onClick={handleHelpOpen2}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen2}
                handleClose={handleHelpClose2}
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <div className="c51x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus512(!responseButtonStatus512);
                  onClickingViewResponse512();
                }}
                className="c51x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus512 ? (
                <p className="c51x-responseResult-style">{responseValue512}</p>
              ) : null}
            </div>
          </div>
          <div className="c51xx-container">
            {/* <h1 className="c51x-heading-style">
              <span className="c51x-span-style">5.1.2.1 </span>
              Number of students benefited by scholarships and free ships
              provided by the institution, Government and non-government bodies,
              industries, individuals, philanthropists during the last five
              years (other than students receiving scholarships under the
              government schemes for reserved categories)
            </h1> */}
            {/* <table className="c51x-Qt-table-style">
              <tr>
                <th className="c51x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5121t1(e.target.value)}
                      id="5121-t1"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t1}
                    />
                    {value5121t1 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5121t2(e.target.value)}
                      id="5121-t2"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t2}
                    />
                    {value5121t2 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5121t3(e.target.value)}
                      id="5121-t3"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t3}
                    />
                    {value5121t3 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5121t4(e.target.value)}
                      id="5121-t4"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t4}
                    />
                    {value5121t4 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5121t5(e.target.value)}
                      id="5121-t5"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t5}
                    />
                    {value5121t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c51x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5121t6(e.target.value);
                        onClickingViewResponse512();
                      }}
                      id="5121-t6"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t6}
                    />
                    {value5121t6 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5121t7(e.target.value);
                        onClickingViewResponse512();
                      }}
                      id="5121-t7"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t7}
                    />
                    {value5121t7 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5121t8(e.target.value);
                        onClickingViewResponse512();
                      }}
                      id="5121-t8"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t8}
                    />
                    {value5121t8 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5121t9(e.target.value);
                        onClickingViewResponse512();
                      }}
                      id="5121-t9"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t9}
                    />
                    {value5121t9 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5121t10(e.target.value);
                        onClickingViewResponse512();
                      }}
                      id="5121-t10"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t10}
                    />
                    {value5121t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> */}
            <h1 className="c51x-heading-style">
              <span className="c51x-span-style">B. </span>
              Number of Sanctioned Posts
            </h1>
            <table className="c51x-Qt-table-style">
              <tr>
                <th className="c51x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5121t11(e.target.value)}
                      id="5121-t11"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t11}
                    />
                    {value5121t11 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5121t12(e.target.value)}
                      id="5121-t12"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t12}
                    />
                    {value5121t12 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5121t13(e.target.value)}
                      id="5121-t13"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t13}
                    />
                    {value5121t13 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5121t14(e.target.value)}
                      id="5121-t14"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t14}
                    />
                    {value5121t14 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue5121t15(e.target.value)}
                      id="5121-t15"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t15}
                    />
                    {value5121t15 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c51x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5121t16(e.target.value);
                        onClickingViewResponse512();
                      }}
                      id="5121-t16"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t16}
                    />
                    {value5121t16 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5121t17(e.target.value);
                        onClickingViewResponse512();
                      }}
                      id="5121-t17"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t17}
                    />
                    {value5121t17 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5121t18(e.target.value);
                        onClickingViewResponse512();
                      }}
                      id="5121-t18"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t18}
                    />
                    {value5121t18 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5121t19(e.target.value);
                        onClickingViewResponse512();
                      }}
                      id="5121-t19"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t19}
                    />
                    {value5121t19 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue5121t20(e.target.value);
                        onClickingViewResponse512();
                      }}
                      id="5121-t20"
                      className="c51x-input-style"
                      type="text"
                      value={value5121t20}
                    />
                    {value5121t20 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <table className="c51x-table-style">
              <tr>
                <th className="c51x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c51x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c51x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c51x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <a href={downloadFile(value5121f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Number of students benefited by scholarships and freeships
                  besides government schemes in last 5years
                </td>
                <td>
                <a href={downloadFile("un5.1.3.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <a href={downloadFile(value5121f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 5.1.3 */}
      <div className="c51x-eachInputField-container">
        <div className="c51x-weightage-container">
          <h1 className="c51x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c51x-container">
            <div className="c51x-heading_Help-container">
              <div>
                <h1 className="c51x-heading-style">
                  <span className="c51x-span-style">5.1.3: </span>
                  Following Capacity development and skills enhancement initiatives 
                  are undertaken by the institution for:
                </h1>
                <p className="c51x-para-style">
                  1.Soft skills
                  <br />
                  2.Language and communication skills
                  <br />
                  3.Life skills (Yoga, physical fitness, health and hygiene)
                  <br />
                  4.Awareness of trends in technology
                </p>
                <div className="c51x-radio-container">
                  <div className="c51x-radio-subContainer">
                    <div className="c51x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue513t1(e.target.value)}
                        value="option a"
                        name="513-t1"
                        type="radio"
                      />
                      <label className="c51x-radioLabel-style" for="513-t1">
                        A. All of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue513t1(e.target.value)}
                        value="option b"
                        name="513-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="513-t1">
                        B. Any three of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue513t1(e.target.value)}
                        value="option c"
                        name="513-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="513-t1">
                        C. Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c51x-radio-subContainer">
                    <div className="c51x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue513t1(e.target.value)}
                        value="option d"
                        name="513-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="513-t1">
                        D. Any one of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue513t1(e.target.value)}
                        value="option e"
                        name="513-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="513-t1">
                        E. None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen3}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen3}
                handleClose={handleHelpClose3}
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
          </div>
          <table className="c51x-table-style">
            <tr>
              <th className="c51x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c51x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c51x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c51x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Link to Institutional website</td>
              <td></td>
              <td>
                <a href={downloadFile(value513f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any additional information</td>
              <td></td>
              <td>
                <a href={downloadFile(value513f2)} target="_blank">
                  view
                </a>
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Details of capability development and schemes</td>
              <td>
              <a href={downloadFile("un5.1.4.xlsx")} target="_blank">
                  View Template
                </a>
              </td>
              <td>
                <a href={downloadFile(value513f3)} target="_blank">
                  view
                </a>
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 5.1.4 */}
      <div className="c51x-eachInputField-container">
        <div className="c51x-weightage-container">
          <h1 className="c51x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c51x-container">
            <div className="c51x-heading_Help-container">
              <div>
                <h1 className="c51x-heading-style">
                  <span className="c51x-span-style">5.1.4: </span>
                  The Institution adopts the following for redressal of student 
                   grievances including sexual harassment and ragging cases
                </h1>
                <p className="c51x-para-style">
                  1. Implementation of guidelines of statutory/regulatory bodies
                  <br />
                  2. Organisation wide awareness and undertakings on policies
                  with zero tolerance
                  <br />
                  3. Mechanisms for submission of online/offline students’
                  grievances
                  <br />
                  4. Timely redressal of the grievances through appropriate
                  committees
                </p>
                <div className="c51x-radio-container">
                  <div className="c51x-radio-subContainer">
                    <div className="c51x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="514-t1">
                        A. All of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="514-t1">
                        B. Any three of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="514-t1">
                        C. Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c51x-radio-subContainer">
                    <div className="c51x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="514-t1">
                        D. Any one of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="514-t1">
                        E. None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen4}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen4}
                handleClose={handleHelpClose4}
                title='Upload the specific document as per descriptio'
                ></HelpButton>
            </div>
          </div>
          <table className="c51x-table-style">
            <tr>
              <th className="c51x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c51x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c51x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c51x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>
                Minutes of the meetings of student redressal committee,
                prevention of sexual harassment committee and Anti Ragging
                committee
              </td>
              <td></td>
              <td>
                <a href={downloadFile(value514f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Upload any additional information</td>
              <td><a href={downloadFile("un5.1.4.xlsx")} target="_blank">view Template</a></td>
              <td>
                <a href={downloadFile(value514f2)} target="_blank">
                  view
                </a>
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Details of student grievances including sexual harassment and
                ragging cases
              </td>
              <td></td>
              <td>
                <a href={downloadFile(value514f3)} target="_blank">
                  view
                </a>
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  );
}

export default Criteria51;
