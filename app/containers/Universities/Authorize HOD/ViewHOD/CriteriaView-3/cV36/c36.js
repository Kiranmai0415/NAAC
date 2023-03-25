import React, { useState, useEffect } from "react";
import "./c36-style.css";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
import { resources } from "../../../../../appConstants";
function Help361(props) {
  return props.isHelp361Clicked ? (
    <div className="c36x-help-mainContainer">
      <div className="c36x-help-subContainer">
        <h1 className="c36x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c36x-help-para-style">
          Describe the impact of extension activities in sensitising students to
          social issues and holistic development within a maximum of 500 words
        </p>
        <button
          className="c36x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp361Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help362(props) {
  return props.isHelp362Clicked ? (
    <div className="c36x-help-mainContainer">
      <div className="c36x-help-subContainer">
        <h1 className="c36x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c36x-help-para-style">
          Total number of awards and recognition received for extension
          activities from Government /recognised bodies year wise during last
          five years
        </p>
        <button
          className="c36x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp362Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help363(props) {
  return props.isHelp363Clicked ? (
    <div className="c36x-help-mainContainer">
      <div className="c36x-help-subContainer">
        <h1 className="c36x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c36x-help-para-style">
          Number of extension and outreach programs conducted by the institution
          including those through NSS/NCC, Government and Government recognised
          bodies during the last five years.
        </p>
        <button
          className="c36x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp363Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help364(props) {
  return props.isHelp364Clicked ? (
    <div className="c36x-help-mainContainer">
      <div className="c36x-help-subContainer">
        <h1 className="c36x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c11x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span>
          Total number of students participating in extension activities with
          Government Organisations, Non-Government Organisations and Programmes
          such as Swachh Bharat, Aids Awareness, Gender Issue, etc. year wise
          during last five years
          <span style={{ fontWeight: "bold" }}> / </span>Total number of
          students
          <span style={{ fontWeight: "bold" }}>) * </span>100
        </p>
        <p className="c24x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span> ΣPercentage per year
          <span style={{ fontWeight: "bold" }}>) /</span> 5
        </p>
        <button
          className="c36x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp364Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Criteria36() {
   // getfile data with API
   function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
 //help buttom
  const [isOpen, setIsopen] = useState(false)
  const [isOpen2,setIsopen2] = useState(false)
  const [isOpen3, setIsopen3] = useState(false)
  const [isOpen4,setIsopen4] = useState(false)
  const handleHelpOpen = (e) => {
    e.preventDefault(),
    setIsopen(true)
  }
  const handleHelpClose = () => {
    setIsopen(false)
  }
  const handleHelpOpen3 = (e) => {
    e.preventDefault(),
    setIsopen3(true)
  }
  const handleHelpClose3 = () => {
    setIsopen3(false)
  }
  const handleHelpOpen4 = (e) => {
    e.preventDefault(),
    setIsopen4(true)
  }
  const handleHelpClose4 = () => {
    setIsopen4(false)
  }
  const handleHelpOpen2 =(e)=>{
    e.preventDefault();
    setIsopen2(true)
  } 
  const handleHelpClose2 = (e)=>{
    setIsopen2(false)
  }
  const [value361t1, setValue361t1] = useState();

  const [value361f1, setValue361f1] = useState("");
  const [pathValue361f1, setPathValue361f1] = useState("");
  const [value361f2, setValue361f2] = useState("");
  const [pathValue361f2, setPathValue361f2] = useState("");
  const [responseValue361, setResponseValue361] = useState("");
  const [help361Status, setHelp361Status] = useState(false);

  const [value3621t1, setValue3621t1] = useState();
  const [value3621t2, setValue3621t2] = useState();
  const [value3621t3, setValue3621t3] = useState();
  const [value3621t4, setValue3621t4] = useState();
  const [value3621t5, setValue3621t5] = useState();
  const [value3621t6, setValue3621t6] = useState();
  const [value3621t7, setValue3621t7] = useState();
  const [value3621t8, setValue3621t8] = useState();
  const [value3621t9, setValue3621t9] = useState();
  const [value3621t10, setValue3621t10] = useState();
  const [value3621f1, setValue3621f1] = useState("");
  const [pathValue3621f1, setPathValue3621f1] = useState("");
  const [value3621f2, setValue3621f2] = useState("");
  const [pathValue3621f2, setPathValue3621f2] = useState("");
  const [value3621f3, setValue3621f3] = useState("");
  const [pathValue3621f3, setPathValue3621f3] = useState("");
  const [responseButtonStatus362, setResponseButtonStatus362] = useState(false);
  const [responseValue362, setResponseValue362] = useState("");
  const [help362Status, setHelp362Status] = useState(false);

  const [value3631t1, setValue3631t1] = useState();
  const [value3631t2, setValue3631t2] = useState();
  const [value3631t3, setValue3631t3] = useState();
  const [value3631t4, setValue3631t4] = useState();
  const [value3631t5, setValue3631t5] = useState();
  const [value3631t6, setValue3631t6] = useState();
  const [value3631t7, setValue3631t7] = useState();
  const [value3631t8, setValue3631t8] = useState();
  const [value3631t9, setValue3631t9] = useState();
  const [value3631t10, setValue3631t10] = useState();
  const [value3631f1, setValue3631f1] = useState("");
  const [pathValue3631f1, setPathValue3631f1] = useState("");
  const [value3631f2, setValue3631f2] = useState("");
  const [pathValue3631f2, setPathValue3631f2] = useState("");
  const [value3631f3, setValue3631f3] = useState("");
  const [pathValue3631f3, setPathValue3631f3] = useState("");
  const [responseButtonStatus363, setResponseButtonStatus363] = useState(false);
  const [responseValue363, setResponseValue363] = useState("");
  const [help363Status, setHelp363Status] = useState(false);

  const [value3641t1, setValue3641t1] = useState();
  const [value3641t2, setValue3641t2] = useState();
  const [value3641t3, setValue3641t3] = useState();
  const [value3641t4, setValue3641t4] = useState();
  const [value3641t5, setValue3641t5] = useState();
  const [value3641t6, setValue3641t6] = useState();
  const [value3641t7, setValue3641t7] = useState();
  const [value3641t8, setValue3641t8] = useState();
  const [value3641t9, setValue3641t9] = useState();
  const [value3641t10, setValue3641t10] = useState();
  const [value3641t11, setValue3641t11] = useState();
  const [value3641t12, setValue3641t12] = useState();
  const [value3641t13, setValue3641t13] = useState();
  const [value3641t14, setValue3641t14] = useState();
  const [value3641t15, setValue3641t15] = useState();
  const [value3641t16, setValue3641t16] = useState();
  const [value3641t17, setValue3641t17] = useState();
  const [value3641t18, setValue3641t18] = useState();
  const [value3641t19, setValue3641t19] = useState();
  const [value3641t20, setValue3641t20] = useState();
  const [value3641f1, setValue3641f1] = useState("");
  const [pathValue3641f1, setPathValue3641f1] = useState("");
  const [value3641f2, setValue3641f2] = useState("");
  const [pathValue3641f2, setPathValue3641f2] = useState("");
  const [value3641f3, setValue3641f3] = useState("");
  const [pathValue3641f3, setPathValue3641f3] = useState("");
  const [responseButtonStatus364, setResponseButtonStatus364] = useState(false);
  const [responseValue364, setResponseValue364] = useState("");
  const [help364Status, setHelp364Status] = useState(false);

  // getfile data with API

  function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
  }

  //get  data api
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
  

  const financialYear = "2021-2022";
  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria3getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setValue361t1(data[0].criteria36Ql[0] ? data[0].criteria36Ql[0].input361t1 : "");
            // setResponseValue111(data[0].criteria1FieldInfoQl[1].response111);
            // setResponseValue112(data[0].criteria1FieldInfoQn[2].response112);
            // setResponseValue113(data[0].criteria1FieldInfoQn[3].response113);

            setValue3621t1(data[0].yearTable3621[0] ? data[0].yearTable3621[0].input3621y : "");
            setValue3621t2(data[0].yearTable3621[1] ? data[0].yearTable3621[1].input3621y : "");
            setValue3621t3(data[0].yearTable3621[1] ? data[0].yearTable3621[1].input3621y : "");
            setValue3621t4(data[0].yearTable3621[3] ? data[0].yearTable3621[3].input3621y : "");
            setValue3621t5(data[0].yearTable3621[4] ? data[0].yearTable3621[4].input3621y : "");
            setValue3621t6(data[0].yearTable3621[0] ? data[0].yearTable3621[0].input3621v : "");
            setValue3621t7(data[0].yearTable3621[1] ? data[0].yearTable3621[1].input3621v : "");
            setValue3621t8(data[0].yearTable3621[2] ? data[0].yearTable3621[2].input3621v : "");
            setValue3621t9(data[0].yearTable3621[3] ? data[0].yearTable3621[3].input3621v : "");
            setValue3621t10(data[0].yearTable3621[4] ? data[0].yearTable3621[4].input3621v : "");

            setValue3631t1(data[0].yearTable3631[0] ? data[0].yearTable3631[0].input3631y : "");
            setValue3631t2(data[0].yearTable3631[1] ? data[0].yearTable3631[0].input3631y : "");
            setValue3631t3(data[0].yearTable3631[2] ? data[0].yearTable3631[0].input3631y : "");
            setValue3631t4(data[0].yearTable3631[3] ? data[0].yearTable3631[0].input3631y : "");
            setValue3631t5(data[0].yearTable3631[4] ? data[0].yearTable3631[0].input3631y : "");
            setValue3631t6(data[0].yearTable3631[0] ? data[0].yearTable3631[0].input3631v : "");
            setValue3631t7(data[0].yearTable3631[1] ? data[0].yearTable3631[0].input3631v : "");
            setValue3631t8(data[0].yearTable3631[2] ? data[0].yearTable3631[0].input3631v : "");
            setValue3631t9(data[0].yearTable3631[3] ? data[0].yearTable3631[0].input3631v : "");
            setValue3631t10(data[0].yearTable3631[4] ? data[0].yearTable3631[0].input3631v : "");

            setValue3641t1(data[0].yearTable3641[0] ? data[0].yearTable3641[0].input3641y : "");
            setValue3641t2(data[0].yearTable3641[1] ? data[0].yearTable3641[0].input3641y : "");
            setValue3641t3(data[0].yearTable3641[2] ? data[0].yearTable3641[0].input3641y : "");
            setValue3641t4(data[0].yearTable3641[3] ? data[0].yearTable3641[0].input3641y : "");
            setValue3641t5(data[0].yearTable3641[4] ? data[0].yearTable3641[0].input3641y : "");
            setValue3641t6(data[0].yearTable3641[0] ? data[0].yearTable3641[0].input3641v : "");
            setValue3641t7(data[0].yearTable3641[1] ? data[0].yearTable3641[0].input3641v : "");
            setValue3641t8(data[0].yearTable3641[2] ? data[0].yearTable3641[0].input3641v : "");
            setValue3641t9(data[0].yearTable3641[3] ? data[0].yearTable3641[0].input3641v : "");
            setValue3641t10(data[0].yearTable3641[4] ? data[0].yearTable3641[0].input3641v : "");

            setValue3641t11(data[0].yearTable36412[0] ? data[0].yearTable36412[0].input36412y : "");
            setValue3641t12(data[0].yearTable36412[1] ? data[0].yearTable36412[1].input36412y : "");
            setValue3641t13(data[0].yearTable36412[2] ? data[0].yearTable36412[2].input36412y : "");
            setValue3641t14(data[0].yearTable36412[3] ? data[0].yearTable36412[3].input36412y : "");
            setValue3641t15(data[0].yearTable36412[4] ? data[0].yearTable36412[4].input36412y : "");
            setValue3641t16(data[0].yearTable36412[0] ? data[0].yearTable36412[0].input36412v : "");
            setValue3641t17(data[0].yearTable36412[1] ? data[0].yearTable36412[1].input36412v : "");
            setValue3641t18(data[0].yearTable36412[2] ? data[0].yearTable36412[2].input36412v : "");
            setValue3641t19(data[0].yearTable36412[3] ? data[0].yearTable36412[3].input36412v : "");
            setValue3641t20(data[0].yearTable36412[4] ? data[0].yearTable36412[4].input36412v : "");

            setValue3631f1(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
            setValue3631f2(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
            setValue3631f3(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
            setValue3641f1(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
            setValue3641f2(data[0].criteria3FileUpload[0]? data[0].criteria3FileUpload[0].criteria3FileName : "");
            setValue3641f3(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );

  function onClickingViewResponse362() {
    if (
      value3621t6 === "" ||
      value3621t7 === "" ||
      value3621t8 === "" ||
      value3621t9 === "" ||
      value3621t10 === "" ||
      value3621t6 === undefined ||
      value3621t7 === undefined ||
      value3621t8 === undefined ||
      value3621t9 === undefined ||
      value3621t10 === undefined
    ) {
      setResponseValue362("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value3621t6, 10)) === false ||
      Number.isInteger(parseInt(value3621t7, 10)) === false ||
      Number.isInteger(parseInt(value3621t8, 10)) === false ||
      Number.isInteger(parseInt(value3621t9, 10)) === false ||
      Number.isInteger(parseInt(value3621t10, 10)) === false
    ) {
      setResponseValue362("Input should be an Integer");
    } else if (
      value3621t6 !== "" &&
      value3621t7 !== "" &&
      value3621t8 !== "" &&
      value3621t9 !== "" &&
      value3621t10 !== ""
    ) {
      setResponseValue362(
        parseInt(value3621t6, 10) +
          parseInt(value3621t7, 10) +
          parseInt(value3621t8, 10) +
          parseInt(value3621t9, 10) +
          parseInt(value3621t10, 10)
      );
    }
  }
  function onClickingViewResponse363() {
    if (
      value3631t6 === "" ||
      value3631t7 === "" ||
      value3631t8 === "" ||
      value3631t9 === "" ||
      value3631t10 === "" ||
      value3631t6 === undefined ||
      value3631t7 === undefined ||
      value3631t8 === undefined ||
      value3631t9 === undefined ||
      value3631t10 === undefined
    ) {
      setResponseValue363("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value3631t6, 10)) === false ||
      Number.isInteger(parseInt(value3631t7, 10)) === false ||
      Number.isInteger(parseInt(value3631t8, 10)) === false ||
      Number.isInteger(parseInt(value3631t9, 10)) === false ||
      Number.isInteger(parseInt(value3631t10, 10)) === false
    ) {
      setResponseValue362("Input should be an Integer");
    } else if (
      value3631t6 !== "" &&
      value3631t7 !== "" &&
      value3631t8 !== "" &&
      value3631t9 !== "" &&
      value3631t10 !== ""
    ) {
      setResponseValue363(
        parseInt(value3631t6, 10) +
          parseInt(value3631t7, 10) +
          parseInt(value3631t8, 10) +
          parseInt(value3631t9, 10) +
          parseInt(value3631t10, 10)
      );
    }
  }
  function onClickingViewResponse364() {
    if (
      value3641t6 === "" ||
      value3641t7 === "" ||
      value3641t8 === "" ||
      value3641t9 === "" ||
      value3641t10 === "" ||
      value3641t16 === "" ||
      value3641t17 === "" ||
      value3641t18 === "" ||
      value3641t19 === "" ||
      value3641t20 === "" ||
      value3641t6 === undefined ||
      value3641t7 === undefined ||
      value3641t8 === undefined ||
      value3641t9 === undefined ||
      value3641t10 === undefined ||
      value3641t16 === undefined ||
      value3641t17 === undefined ||
      value3641t18 === undefined ||
      value3641t19 === undefined ||
      value3641t20 === undefined
    ) {
      setResponseValue364("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value3641t6, 10)) === false ||
      Number.isInteger(parseInt(value3641t7, 10)) === false ||
      Number.isInteger(parseInt(value3641t8, 10)) === false ||
      Number.isInteger(parseInt(value3641t9, 10)) === false ||
      Number.isInteger(parseInt(value3641t10, 10)) === false ||
      Number.isInteger(parseInt(value3641t16, 10)) === false ||
      Number.isInteger(parseInt(value3641t17, 10)) === false ||
      Number.isInteger(parseInt(value3641t18, 10)) === false ||
      Number.isInteger(parseInt(value3641t19, 10)) === false ||
      Number.isInteger(parseInt(value3641t20, 10)) === false
    ) {
      setResponseValue364("Input should be an Integer");
    } else if (
      value3641t6 !== "" &&
      value3641t7 !== "" &&
      value3641t8 !== "" &&
      value3641t9 !== "" &&
      value3641t10 !== "" &&
      value3641t16 !== "" &&
      value3641t17 !== "" &&
      value3641t18 !== "" &&
      value3641t19 !== "" &&
      value3641t20 !== ""
    ) {
      setResponseValue364(
        ((value3641t6 / value3641t16) * 100 +
          (value3641t7 / value3641t17) * 100 +
          (value3641t8 / value3641t18) * 100 +
          (value3641t9 / value3641t19) * 100 +
          (value3641t10 / value3641t20) * 100) /
          5
      );
    }
  }

  // sending data to db with API

  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    criteria36Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input361t1: value361t1,
        response362: responseValue362,
        response363: responseValue363,
        response364: responseValue364,
      },
    ],
    yearTable3621: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input3621y: value3621t1,
        input3621v: value3621t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input3621y: value3621t2,
        input3621v: value3621t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input3621y: value3621t3,
        input3621v: value3621t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input3621y: value3621t4,
        input3621v: value3621t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input3621y: value3621t5,
        input3621v: value3621t10,
      },
    ],

    yearTable3631: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input3631y: value3631t1,
        input3631v: value3631t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input3631y: value3631t2,
        input3631v: value3631t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input3631y: value3631t3,
        input3631v: value3631t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input3631y: value3631t4,
        input3631v: value3631t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input3631y: value3631t5,
        input3631v: value3631t10,
      },
    ],

    yearTable3641: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input3641y: value3641t1,
        input3641v: value3641t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input3641y: value3641t2,
        input3641v: value3641t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input3641y: value3641t3,
        input3641v: value3641t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input3641y: value3641t4,
        input3641v: value3641t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input3641y: value3641t5,
        input3641v: value3641t10,
      },
    ],

    yearTable36412: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input36412y: value3641t11,
        input36412v: value3641t16,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input36412y: value3641t12,
        input36412v: value3641t17,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input36412y: value3641t13,
        input36412v: value3641t18,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input36412y: value3641t14,
        input36412v: value3641t19,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input36412y: value3641t15,
        input36412v: value3641t20,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  // rendering DOM

  return (
    <div className="c36-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c36x-colorIndicator-container">
        <p className="c36x-QlcolorIndicator-circle-style"></p>
        <span className="c36x-colorIndicator-span-style">Qualitative</span>
        <p className="c36x-QtcolorIndicator-circle-style"></p>
        <span className="c36x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c36x-weightage-heading-style">
            Key Indicator Weightage: 20
          </h1>
        </div>
      </div>

      {/* Key Indicator: 3.6.1 */}
      <div className="c36x-eachInputField-container">
        <div className="c36x-weightage-container">
          <h1 className="c36x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c36x-Ql-label-textarea-container">
            <div className="c36x-heading_Help-container">
              <h1 className="c36x-heading-style">
                <span className="c36x-span-style">3.6.1: </span>
                Extension activities in the neighborhood community in terms of impact and sensitizing the students to social issues and holistic development and awards received if any
(Showcase at least four case studies to the peer team)
                
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
            <label htmlFor="361-t1" className="c36x-label-style">
              Response:
            </label>
            <textarea
              readOnly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue361t1(e.target.value);
                setResponseValue361(e.target.value);
              }}
              value={value361t1}
              rows={10}
              className="c36x-textarea-style"
              id="361-t1"
            ></textarea>
            {value361t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c36x-Ql-table-style">
            <tr>
              <th className="c36x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c36x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c36x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c36x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c36x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c36x-Ql-tableBorders-style"></td>
              <td className="c36x-Ql-tableBorders-style">
                <input
                  readOnly
                  onChange={(e) => {
                    setValue361f1(e.target.files[0]);
                    setPathValue361f1(e.target.value);
                  }}
                  id="361-f1"
                  type="file"
                  className="c36-fileButton-style"
                />
                {pathValue361f1 === "" ? null : (
                  <div className="c36-fileButtons-container">
                    <button className="c36-viewFileButton-style">
                      View File
                    </button>
                    <button className="c36-removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )}
              </td>
              <td className="c36x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Provide link for additional information</td>
              <td></td>
              <td>
                <input
                  readOnly
                  onChange={(e) => {
                    setValue361f2(e.target.files[0]);
                    setPathValue361f2(e.target.value);
                  }}
                  id="361-f2"
                  type="file"
                  className="c36-fileButton-style"
                />
                {pathValue361f2 === "" ? null : (
                  <div className="c36-fileButtons-container">
                    <button className="c36-viewFileButton-style">
                      View File
                    </button>
                    <button className="c36-removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )}
              </td>
              <td className="c36x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
        {/* <div
          style={{
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-start',
            alignItems: 'center',
          }}
        >
          <label style={{ width: '15%', color: 'black', fontWeight: '500' }}>
            Grade Scale
          </label>
           <input readOnly
            style={{
              marginLeft: '2%',
              borderColor: 'grey',
              borderWidth: '1px',
              borderLeft: '0',
              borderRight: '0',
              borderTop: '0',
              width: '20%',
            }}
            type="text"
            onChange={(e) => {
              setGradeScale361(e.target.value);
              console.log(gradeScale361);
            }}
          />

          <div className="c36x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus361(true);
                qlMetricGradePointsCalculator(
                  gradeScale361,
                  setGradePoints361,
                  10
                );
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginLeft: '2%',
              }}
            >
              Weighted Grade Points
            </button>
            {gradePointsClickStatus361 ? (
              <p className="c36x-responseResult-style">{gradePoints361}</p>
            ) : null}
          </div>
        </div> */}
      </div>

      {/* Key Indicator: 3.6.2 */}
      <div className="c36x-eachInputField-container">
        <div className="c36x-weightage-container">
          <h1 className="c36x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c36x-container">
            <div className="c36x-heading_Help-container">
              <h1 className="c36x-heading-style">
                <span className="c36x-span-style">3.6.2: </span>
                Number of extension and outreach programs conducted through organized forums by the institution during the last five years
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
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            <div className="c36x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus362(!responseButtonStatus362);
                  onClickingViewResponse362();
                }}
                className="c36x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus362 ? (
                <p className="c36x-responseResult-style">{responseValue362}</p>
              ) : null}
            </div>
          </div>
          <div className="c36xx-container">
            <h1 className="c36xx-Heading-style">
              <span className="c36xx-span-style">3.6.2.1: </span>
              Number of extension and outreach programs conducted by the institution through organized forums like NSS/NCC during the last five years.
            </h1>

            <table className="c36x-Qt-table-style">
              <tr>
                <th className="c36x-horizontalTable-heading-style">Year</th>
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
                      onChange={(e) => setValue3621t1(e.target.value)}
                      id="3621-t1"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t1}
                    />
                    {value3621t1 === "" ? (
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
                      onChange={(e) => setValue3621t2(e.target.value)}
                      id="3621-t2"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t2}
                    />
                    {value3621t2 === "" ? (
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
                      onChange={(e) => setValue3621t3(e.target.value)}
                      id="3621-t3"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t3}
                    />
                    {value3621t3 === "" ? (
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
                      onChange={(e) => setValue3621t4(e.target.value)}
                      id="3621-t4"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t4}
                    />
                    {value3621t4 === "" ? (
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
                      onChange={(e) => setValue3621t5(e.target.value)}
                      id="3621-t5"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t5}
                    />
                    {value3621t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c36x-horizontalTable-heading-style">Number</th>
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
                      onChange={(e) => setValue3621t6(e.target.value)}
                      id="3621-t6"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t6}
                    />
                    {value3621t6 === "" ? (
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
                      onChange={(e) => setValue3621t7(e.target.value)}
                      id="3621-t7"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t7}
                    />
                    {value3621t7 === "" ? (
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
                      onChange={(e) => setValue3621t8(e.target.value)}
                      id="3621-t8"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t8}
                    />
                    {value3621t8 === "" ? (
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
                      onChange={(e) => setValue3621t9(e.target.value)}
                      id="3621-t9"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t9}
                    />
                    {value3621t9 === "" ? (
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
                      onChange={(e) => setValue3621t10(e.target.value)}
                      id="3621-t10"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t10}
                    />
                    {value3621t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c36x-table-style">
              <tr>
                <th className="c36x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c36x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c36x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c36x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Institutional data in the prescribed format (data template)</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3621f1(e.target.files[0]);
                      setPathValue3621f1(e.target.value);
                    }}
                    id="3621-f1"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3621f1 === "" ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                        View File
                      </button>
                      <button className="c36-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                Detailed list and report for each extension and outreach program to be made available, with specific mention of number of students participated and the details of the collaborating agency                </td>
                <td>
                <a href={downloadFile("un3.6.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3621f2(e.target.files[0]);
                      setPathValue3621f2(e.target.value);
                    }}
                    id="3621-f2"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3621f2 === "" ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                        View File
                      </button>
                      <button className="c36-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Geo-tagged Photographs and any other supporting document of relevance should have proper captions and dates</td>
                <td><a href={downloadFile("un3.6.2.xlsx")} target="_blank">view Template</a></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3621f3(e.target.files[0]);
                      setPathValue3621f3(e.target.value);
                    }}
                    id="3621-f3"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3621f3 === "" ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                        View File
                      </button>
                      <button className="c36-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c36x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus362(true);
                setGradeScale362(numberMetricGradeCalculator(responseValue362));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Grade Scale
            </button>

            {gradeScaleClickStatus362 ? (
              <p className="c36x-responseResult-style">
                {numberMetricGradeCalculator(responseValue362)}
              </p>
            ) : null}
          </div>
          <div className="c36x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus362(true);
                setGradeScale362(numberMetricGradeCalculator(responseValue362));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Weighted Grade Points
            </button>
            {gradePointsClickStatus362 ? (
              <p className="c36x-responseResult-style">
                {metricGradePointsCalculator(gradeScale362, 15)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>

      {/* Key Indicator: 3.6.3 */}
      {/* <div className="c36x-eachInputField-container">
        <div className="c36x-weightage-container">
          <h1 className="c36x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c36x-container">
            <div className="c36x-heading_Help-container">
              <h1 className="c36x-heading-style">
                <span className="c36x-span-style">3.6.3: </span>
                Number of extension and outreach programs conducted by the
                institution through NSS/NCC, Government and Government
                recognised bodies during the last five years
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
            <div className="c36x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus363(!responseButtonStatus363);
                  onClickingViewResponse363();
                }}
                className="c36x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus363 ? (
                <p className="c36x-responseResult-style">{responseValue363}</p>
              ) : null}
            </div>
          </div>
          <div className="c36xx-container">
            <h1 className="c36xx-Heading-style">
              <span className="c36xx-span-style">3.6.3.1: </span>
              Number of extension and outreach programs conducted by the
              institution through NSS/NCC, Government and Government recognised
              bodies during the last five years
            </h1>

            <table className="c36x-Qt-table-style">
              <tr>
                <th className="c36x-horizontalTable-heading-style">Year</th>
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
                      onChange={(e) => setValue3631t1(e.target.value)}
                      id="3631-t1"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t1}
                    />
                    {value3631t1 === "" ? (
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
                      onChange={(e) => setValue3631t2(e.target.value)}
                      id="3631-t2"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t2}
                    />
                    {value3631t2 === "" ? (
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
                      onChange={(e) => setValue3631t3(e.target.value)}
                      id="3631-t3"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t3}
                    />
                    {value3631t3 === "" ? (
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
                      onChange={(e) => setValue3631t4(e.target.value)}
                      id="3631-t4"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t4}
                    />
                    {value3631t4 === "" ? (
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
                      onChange={(e) => setValue3631t5(e.target.value)}
                      id="3631-t5"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t5}
                    />
                    {value3631t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c36x-horizontalTable-heading-style">
                  Number of programs
                </th>
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
                      onChange={(e) => setValue3631t6(e.target.value)}
                      id="3631-t6"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t6}
                    />
                    {value3631t6 === "" ? (
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
                      onChange={(e) => setValue3631t7(e.target.value)}
                      id="3631-t7"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t7}
                    />
                    {value3631t7 === "" ? (
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
                      onChange={(e) => setValue3631t8(e.target.value)}
                      id="3631-t8"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t8}
                    />
                    {value3631t8 === "" ? (
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
                      onChange={(e) => setValue3631t9(e.target.value)}
                      id="3631-t9"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t9}
                    />
                    {value3631t9 === "" ? (
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
                      onChange={(e) => setValue3631t10(e.target.value)}
                      id="3631-t10"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t10}
                    />
                    {value3631t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c36x-table-style">
              <tr>
                <th className="c36x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c36x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c36x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c36x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Reports of the event organized</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3631f1(e.target.files[0]);
                      setPathValue3631f1(e.target.value);
                    }}
                    id="3631-f1"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3631f1 === "" ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                        View File
                      </button>
                      <button className="c36-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3631f2(e.target.files[0]);
                      setPathValue3631f2(e.target.value);
                    }}
                    id="3631-f2"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3631f2 === "" ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                        View File
                      </button>
                      <button className="c36-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Number of extension and outreach Programmes conducted with
                  industry, community etc for the last five years
                </td>
                <td>
                <a href={downloadFile("un3.6.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3631f3(e.target.files[0]);
                      setPathValue3631f3(e.target.value);
                    }}
                    id="3631-f3"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3631f3 === "" ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                        View File
                      </button>
                      <button className="c36-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form> */}
        {/* <div>
          <div className="c36x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus363(true);
                setGradeScale363(numberMetricGradeCalculator(responseValue363));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Grade Scale
            </button>

            {gradeScaleClickStatus363 ? (
              <p className="c36x-responseResult-style">
                {numberMetricGradeCalculator(responseValue363)}
              </p>
            ) : null}
          </div>
          <div className="c36x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus363(true);
                setGradeScale363(numberMetricGradeCalculator(responseValue363));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Weighted Grade Points
            </button>
            {gradePointsClickStatus363 ? (
              <p className="c36x-responseResult-style">
                {metricGradePointsCalculator(gradeScale363, 10)}
              </p>
            ) : null}
          </div>
        </div> */}
      {/* </div> */}

      {/* Key Indicator: 3.6.4 */}
      {/* <div className="c36x-eachInputField-container">
        <div className="c36x-weightage-container">
          <h1 className="c36x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c36x-container">
            <div className="c36x-heading_Help-container">
              <h1 className="c36x-heading-style">
                <span className="c36x-span-style">3.6.4: </span>
                Average percentage of students participating in extension
                activities listed at 3.6.3 above during the last five years
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
            <div className="c36x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus364(!responseButtonStatus364);
                  onClickingViewResponse364;
                }}
                className="c36x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus364 ? (
                <p className="c36x-responseResult-style">{responseValue364}</p>
              ) : null}
            </div>
          </div>
          <div className="c36xx-container">
            <h1 className="c36xx-Heading-style">
              <span className="c36xx-span-style">3.6.4.1: </span>
              Total number of students participating in extension activities
              listed at 3.6.3 above year-wise during the last five years.
            </h1>

            <table className="c36x-Qt-table-style">
              <tr>
                <th className="c36x-horizontalTable-heading-style">Year</th>
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
                      onChange={(e) => setValue3641t1(e.target.value)}
                      id="3641-t1"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t1}
                    />
                    {value3641t1 === "" ? (
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
                      onChange={(e) => setValue3641t2(e.target.value)}
                      id="3641-t2"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t2}
                    />
                    {value3641t2 === "" ? (
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
                      onChange={(e) => setValue3641t3(e.target.value)}
                      id="3641-t3"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t3}
                    />
                    {value3641t3 === "" ? (
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
                      onChange={(e) => setValue3641t4(e.target.value)}
                      id="3641-t4"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t4}
                    />
                    {value3641t4 === "" ? (
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
                      onChange={(e) => setValue3641t5(e.target.value)}
                      id="3641-t5"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t5}
                    />
                    {value3641t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c36x-horizontalTable-heading-style">Number</th>
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
                      onChange={(e) => setValue3641t6(e.target.value)}
                      id="3641-t6"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t6}
                    />
                    {value3641t6 === "" ? (
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
                      onChange={(e) => setValue3641t7(e.target.value)}
                      id="3641-t7"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t7}
                    />
                    {value3641t7 === "" ? (
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
                      onChange={(e) => setValue3641t8(e.target.value)}
                      id="3641-t8"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t8}
                    />
                    {value3641t8 === "" ? (
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
                      onChange={(e) => setValue3641t9(e.target.value)}
                      id="3641-t9"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t9}
                    />
                    {value3641t9 === "" ? (
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
                      onChange={(e) => setValue3641t10(e.target.value)}
                      id="3641-t10"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t10}
                    />
                    {value3641t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c36x-Qt-table-style">
              <tr>
                <th className="c36x-horizontalTable-heading-style">Year</th>
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
                      onChange={(e) => setValue3641t11(e.target.value)}
                      id="3641-t11"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t11}
                    />
                    {value3641t11 === "" ? (
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
                      onChange={(e) => setValue3641t12(e.target.value)}
                      id="3641-t12"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t12}
                    />
                    {value3641t12 === "" ? (
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
                      onChange={(e) => setValue3641t13(e.target.value)}
                      id="3641-t13"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t13}
                    />
                    {value3641t13 === "" ? (
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
                      onChange={(e) => setValue3641t14(e.target.value)}
                      id="3641-t14"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t14}
                    />
                    {value3641t14 === "" ? (
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
                      onChange={(e) => setValue3641t15(e.target.value)}
                      id="3641-t15"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t15}
                    />
                    {value3641t15 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c36x-horizontalTable-heading-style">Number</th>
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
                      onChange={(e) => setValue3641t16(e.target.value)}
                      id="3641-t16"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t16}
                    />
                    {value3641t16 === "" ? (
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
                      onChange={(e) => setValue3641t17(e.target.value)}
                      id="3641-t17"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t17}
                    />
                    {value3641t17 === "" ? (
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
                      onChange={(e) => setValue3641t18(e.target.value)}
                      id="3641-t18"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t18}
                    />
                    {value3641t18 === "" ? (
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
                      onChange={(e) => setValue3641t19(e.target.value)}
                      id="3641-t19"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t19}
                    />
                    {value3641t19 === "" ? (
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
                      onChange={(e) => setValue3641t20(e.target.value)}
                      id="3641-t20"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t20}
                    />
                    {value3641t20 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c36x-table-style">
              <tr>
                <th className="c36x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c36x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c36x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c36x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Reports of the event</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3641f1(e.target.files[0]);
                      setPathValue3641f1(e.target.value);
                    }}
                    id="3641-f1"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3641f1 === "" ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                        View File
                      </button>
                      <button className="c36-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3641f2(e.target.files[0]);
                      setPathValue3641f2(e.target.value);
                    }}
                    id="3641-f2"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3641f2 === "" ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                        View File
                      </button>
                      <button className="c36-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Average percentage of students participating in extension
                  activities with Govt or NGO etc
                </td>
                <td>
                <a href={downloadFile("3.6.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3641f3(e.target.files[0]);
                      setPathValue3641f3(e.target.value);
                    }}
                    id="3641-f3"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3641f3 === "" ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                        View File
                      </button>
                      <button className="c36-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div> */}
    </div>
  );
}

export default Criteria36;
