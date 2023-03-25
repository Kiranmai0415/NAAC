import React, { useState, useEffect } from "react";
import "./c31-style.css";
import { toast } from "react-toastify";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
import { resources } from "../../../../../appConstants";

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

// Help buttons functionality
function Help311(props) {
  return props.isHelp311Clicked ? (
    <div className="c31x-help-mainContainer">
      <div className="c31x-help-subContainer">
        <h1 className="c31x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c31x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c31x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp311Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help312(props) {
  return props.isHelp312Clicked ? (
    <div className="c31x-help-mainContainer">
      <div className="c31x-help-subContainer">
        <h1 className="c31x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c31x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span>The total amount of seed
          money provided by institution to its teachers for research in the last
          five years
          <span style={{ fontWeight: "bold" }}>) /</span> 5
        </p>
        <button
          className="c31x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp312Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help313(props) {
  return props.isHelp313Clicked ? (
    <div className="c31x-help-mainContainer">
      <div className="c31x-help-subContainer">
        <h1 className="c31x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c31x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span>Total number of teachers
          who received national/ international fellowship/ financial support by
          various agencies for advanced studies/ research during the last five
          years<span style={{ fontWeight: "bold" }}> / </span>Total number of
          full time teachers during the last five years
          <span style={{ fontWeight: "bold" }}>) * </span>100
        </p>
        <button
          className="c31x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp313Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help314(props) {
  return props.isHelp314Clicked ? (
    <div className="c31x-help-mainContainer">
      <div className="c31x-help-subContainer">
        <h1 className="c31x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c31x-help-para-style">
          Data for the last five years: (As per Data Template)
          <br />
          1.Name of the Research fellow
          <br />
          2.Year of enrolment
          <br />
          3.Duration of fellowship
          <br />
          4.Type of the fellowship
          <br />
          5.Granting agency
          <br />
        </p>
        <button
          className="c31x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp313Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help315(props) {
  return props.isHelp315Clicked ? (
    <div className="c31x-help-mainContainer">
      <div className="c31x-help-subContainer">
        <h1 className="c31x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c31x-help-para-style">
          Data Requirements:
          <br />
          1.Name of the facility
          <br />
          2.Year of establishment
          <br />
          3.Geo-tagged pictures
          <br />
        </p>
        <button
          className="c31x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp313Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help316(props) {
  return props.isHelp316Clicked ? (
    <div className="c31x-help-mainContainer">
      <div className="c31x-help-subContainer">
        <h1 className="c31x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c31x-help-para-style">
          <span style={{ fontWeight: "bold" }}> (</span>
          Number of departments with UGC - SAP, CAS,DST - FIST, DBT, ICSSR and
          other similar recognitions
          <span style={{ fontWeight: "bold" }}> /</span>
          Total number of departments offering academic programmes
          <span style={{ fontWeight: "bold" }}>) *</span>
        </p>
        <button
          className="c31x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp316Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria31() {
   // getfile data with API
   function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
 //help buttom
  const [isOpen, setIsopen] = useState(false)
  const [isOpen3, setIsopen3] = useState(false)
  const [isOpen4, setIsopen4] = useState(false)
  const [isOpen5, setIsopen5] = useState(false)
  const [isOpen6, setIsopen6] = useState(false)
  const [isOpen7, setIsopen7] = useState(false)
  const [isOpen2,setIsopen2] = useState(false)
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
  const handleHelpClose4 = () => {
    setIsopen4(false)
  }
  const handleHelpOpen4 = (e) => {
    e.preventDefault(),
    setIsopen4(true)
  }
  const handleHelpClose5 = () => {
    setIsopen5(false)
  }
  const handleHelpOpen5 = (e) => {
    e.preventDefault(),
    setIsopen5(true)
  }
  const handleHelpClose3= () => {
    setIsopen3(false)
  }
  const handleHelpOpen2 =(e)=>{
    e.preventDefault();
    setIsopen2(true)
  } 
  const handleHelpClose2 = (e)=>{
    setIsopen2(false)
  }
  // state variables
  const [value311t1, setValue311t1] = useState();
  const [value311f1, setValue311f1] = useState("");
  const [pathValue311f1, setPathValue311f1] = useState("");
  const [value311f2, setValue311f2] = useState("");
  const [pathValue311f2, setPathValue311f2] = useState("");
  const [value311f3, setValue311f3] = useState("");
  const [pathValue311f3, setPathValue311f3] = useState("");

  const [value3121t1, setValue3121t1] = useState();
  const [value3121t2, setValue3121t2] = useState();
  const [value3121t3, setValue3121t3] = useState();
  const [value3121t4, setValue3121t4] = useState();
  const [value3121t5, setValue3121t5] = useState();
  const [value3121t6, setValue3121t6] = useState();
  const [value3121t7, setValue3121t7] = useState();
  const [value3121t8, setValue3121t8] = useState();
  const [value3121t9, setValue3121t9] = useState();
  const [value3121t10, setValue3121t10] = useState();
  const [value3121f1, setValue3121f1] = useState();
  const [pathValue3121f1, setPathValue3121f1] = useState("");
  const [value3121f2, setValue3121f2] = useState();
  const [pathValue3121f2, setPathValue3121f2] = useState("");
  const [value3121f3, setValue3121f3] = useState();
  const [pathValue3121f3, setPathValue3121f3] = useState("");
  const [value3121f4, setValue3121f4] = useState();
  const [pathValue3121f4, setPathValue3121f4] = useState("");

  const [value3131t1, setValue3131t1] = useState();
  const [value3131t2, setValue3131t2] = useState();
  const [value3131t3, setValue3131t3] = useState();
  const [value3131t4, setValue3131t4] = useState();
  const [value3131t5, setValue3131t5] = useState();
  const [value3131t6, setValue3131t6] = useState();
  const [value3131t7, setValue3131t7] = useState();
  const [value3131t8, setValue3131t8] = useState();
  const [value3131t9, setValue3131t9] = useState();
  const [value3131t10, setValue3131t10] = useState();
  const [value3131t11, setValue3131t11] = useState();
  const [value3131f1, setValue3131f1] = useState();
  const [pathValue3131f1, setPathValue3131f1] = useState("");
  const [value3131f2, setValue3131f2] = useState();
  const [pathValue3131f2, setPathValue3131f2] = useState("");
  const [value3131f3, setValue3131f3] = useState();
  const [pathValue3131f3, setPathValue3131f3] = useState("");

  const [value3141t1, setValue3141t1] = useState();
  const [value3141t2, setValue3141t2] = useState();
  const [value3141t3, setValue3141t3] = useState();
  const [value3141t4, setValue3141t4] = useState();
  const [value3141t5, setValue3141t5] = useState();
  const [value3141t6, setValue3141t6] = useState();
  const [value3141t7, setValue3141t7] = useState();
  const [value3141t8, setValue3141t8] = useState();
  const [value3141t9, setValue3141t9] = useState();
  const [value3141t10, setValue3141t10] = useState();

  const [value315t1, setValue315t1] = useState();
  const [value3161t1, setValue3161t1] = useState();
  const [value3161t2, setValue3161t2] = useState();

  const [value3141f1, setValue3141f1] = useState("");
  const [pathValue3141f1, setPathValue3141f1] = useState("");
  const [value3141f2, setValue3141f2] = useState("");
  const [pathValue3141f2, setPathValue3141f2] = useState("");
  const [value315f1, setValue315f1] = useState("");
  const [pathValue315f1, setPathValue315f1] = useState("");
  const [value315f2, setValue315f2] = useState("");
  const [pathValue315f2, setPathValue315f2] = useState("");
  const [value315f3, setValue315f3] = useState("");
  const [pathValue315f3, setPathValue315f3] = useState("");
  const [value3161f1, setValue3161f1] = useState("");
  const [pathValue3161f1, setPathValue3161f1] = useState("");
  const [value3161f2, setValue3161f2] = useState("");
  const [pathValue3161f2, setPathValue3161f2] = useState("");
  const [value3161f3, setValue3161f3] = useState("");
  const [pathValue3161f3, setPathValue3161f3] = useState("");

  const [help311Status, setHelp311Status] = useState(false);
  const [help312Status, setHelp312Status] = useState(false);
  const [help313Status, setHelp313Status] = useState(false);
  const [help314Status, setHelp314Status] = useState(false);
  const [help315Status, setHelp315Status] = useState(false);
  const [help316Status, setHelp316Status] = useState(false);
  const [responseButtonStatus312, setResponseButtonStatus312] = useState(false);
  const [responseButtonStatus313, setResponseButtonStatus313] = useState(false);
  const [responseButtonStatus314, setResponseButtonStatus314] = useState(false);
  const [responseButtonStatus315, setResponseButtonStatus315] = useState(false);
  const [responseButtonStatus316, setResponseButtonStatus316] = useState(false);
  const [responseValue311, setResponseValue311] = useState();
  const [responseValue312, setResponseValue312] = useState();
  const [responseValue313, setResponseValue313] = useState();
  const [responseValue314, setResponseValue314] = useState();
  const [responseValue315, setResponseValue315] = useState();
  const [responseValue316, setResponseValue316] = useState();

  // response button functionality
  function onClickingViewResponse315() {
    if (value315t1 === "" || value315t1 === undefined || value315t1 === null) {
      setResponseValue315("Please select any option");
    } else {
      setResponseValue315(value315t1);
    }
  }

  function onClickingViewResponse312() {
    if (
      value3121t6 === "" ||
      value3121t7 === "" ||
      value3121t8 === "" ||
      value3121t9 === "" ||
      value3121t10 === "" ||
      value3121t6 === undefined ||
      value3121t7 === undefined ||
      value3121t8 === undefined ||
      value3121t9 === undefined ||
      value3121t10 === undefined
    ) {
      setResponseValue312("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value3121t6, 10)) === false ||
      Number.isInteger(parseInt(value3121t7, 10)) === false ||
      Number.isInteger(parseInt(value3121t8, 10)) === false ||
      Number.isInteger(parseInt(value3121t9, 10)) === false ||
      Number.isInteger(parseInt(value3121t10, 10)) === false
    ) {
      setResponseValue312("Input should be an Integer");
    } else if (
      value3121t6 !== "" &&
      value3121t7 !== "" &&
      value3121t8 !== "" &&
      value3121t9 !== "" &&
      value3121t10 !== ""
    ) {
      setResponseValue312(
        (parseInt(value3121t6, 10) +
          parseInt(value3121t7, 10) +
          parseInt(value3121t8, 10) +
          parseInt(value3121t9, 10) +
          parseInt(value3121t10, 10)) /
          5
      );
    }
  }

  function onClickingViewResponse313() {
    if (
      value3131t6 === "" ||
      value3131t7 === "" ||
      value3131t8 === "" ||
      value3131t9 === "" ||
      value3131t10 === "" ||
      value3131t11 === "" ||
      value3131t6 === undefined ||
      value3131t7 === undefined ||
      value3131t8 === undefined ||
      value3131t9 === undefined ||
      value3131t10 === undefined ||
      value3131t11 === undefined
    ) {
      setResponseValue313("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value3131t6, 10)) === false ||
      Number.isInteger(parseInt(value3131t7, 10)) === false ||
      Number.isInteger(parseInt(value3131t8, 10)) === false ||
      Number.isInteger(parseInt(value3131t9, 10)) === false ||
      Number.isInteger(parseInt(value3131t10, 10)) === false ||
      Number.isInteger(parseInt(value3131t11, 10)) === false
    ) {
      setResponseValue313("Input should be an Integer");
    } else if (
      value3131t6 !== "" &&
      value3131t7 !== "" &&
      value3131t8 !== "" &&
      value3131t9 !== "" &&
      value3131t10 !== "" &&
      value3131t11 !== ""
    ) {
      setResponseValue313(
        ((parseInt(value3131t6, 10) +
          parseInt(value3131t7, 10) +
          parseInt(value3131t8, 10) +
          parseInt(value3131t9, 10) +
          parseInt(value3131t10, 10)) /
          parseInt(value3131t11, 10)) *
          100
      );
    }
    console.log(responseValue313);
  }

  function onClickingViewResponse314() {
    if (
      value3141t6 === "" ||
      value3141t7 === "" ||
      value3141t8 === "" ||
      value3141t9 === "" ||
      value3141t10 === "" ||
      value3141t6 === undefined ||
      value3141t7 === undefined ||
      value3141t8 === undefined ||
      value3141t9 === undefined ||
      value3141t10 === undefined
    ) {
      setResponseValue314("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value3141t6, 10)) === false ||
      Number.isInteger(parseInt(value3141t7, 10)) === false ||
      Number.isInteger(parseInt(value3141t8, 10)) === false ||
      Number.isInteger(parseInt(value3141t9, 10)) === false ||
      Number.isInteger(parseInt(value3141t10, 10)) === false
    ) {
      setResponseValue314("Input should be an Integer");
    } else if (
      value3141t6 !== "" &&
      value3141t7 !== "" &&
      value3141t8 !== "" &&
      value3141t9 !== "" &&
      value3141t10 !== ""
    ) {
      setResponseValue314(
        parseInt(value3141t6, 10) +
          parseInt(value3141t7, 10) +
          parseInt(value3141t8, 10) +
          parseInt(value3141t9, 10) +
          parseInt(value3141t10, 10)
      );
    }
  }

  function onClickingViewResponse316() {
    if (
      value3161t1 === "" ||
      value3161t2 === "" ||
      value3161t1 === undefined ||
      value3161t2 === undefined
    ) {
      setResponseValue316("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value3161t1, 10)) === false ||
      Number.isInteger(parseInt(value3161t2, 10)) === false
    ) {
      setResponseValue316("Input should be an Integer");
    } else if (value3161t1 !== "" && value3161t2 !== "") {
      setResponseValue316(
        parseInt(value3161t1, 10) / parseInt(value3161t2, 10)
      );
    }
  }

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


  // getfile data with API
  const financialYear = "2021-2022";
  function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
  }
  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria3getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setValue311t1(data[0].criteria31Ql[0] ? data[0].criteria31Ql[0].input311t1 :"");
            setValue3131t11(data[0].criteria31Ql[0] ? data[0].criteria31Ql[0].input3131t1 : "");

            setValue315t1(data[0].criteria31Qn[0] ? data[0].criteria31Qn[0].input315t1 : "");
            setValue3161t1(data[0].criteria31Qn[0] ? data[0].criteria31Qn[0].input3161t1 : "");
            setValue3161t2(data[0].criteria31Qn[0] ? data[0].criteria31Qn[0].input3162t1 : "");

            // setResponseValue111(data[0].criteria1FieldInfoQl[1].response111);
            // setResponseValue112(data[0].criteria1FieldInfoQn[2].response112);
            // setResponseValue113(data[0].criteria1FieldInfoQn[3].response113);

            setValue3121t1(data[0].yearTable3121[0] ? data[0].yearTable3121[0].input3121y : "");
            setValue3121t2(data[0].yearTable3121[0] ? data[0].yearTable3121[0].input3121y : "");
            setValue3121t3(data[0].yearTable3121[2] ? data[0].yearTable3121[2].input3121y : "");
            setValue3121t4(data[0].yearTable3121[3] ? data[0].yearTable3121[3].input3121y : "");
            setValue3121t5(data[0].yearTable3121[4] ? data[0].yearTable3121[4].input3121y : "");
            setValue3121t6(data[0].yearTable3121[0] ? data[0].yearTable3121[0].input3121v : "");
            setValue3121t7(data[0].yearTable3121[1] ? data[0].yearTable3121[1].input3121v : "");
            setValue3121t8(data[0].yearTable3121[2] ? data[0].yearTable3121[2].input3121v  : "");
            setValue3121t9(data[0].yearTable3121[3] ? data[0].yearTable3121[3].input3121v : "");
            setValue3121t10(data[0].yearTable3121[4] ? data[0].yearTable3121[4].input3121v : "");

            setValue3131t1(data[0].yearTable3131[0] ? data[0].yearTable3131[0].input3131y : "");
            setValue3131t2(data[0].yearTable3131[1] ? data[0].yearTable3131[1].input3131y : "");
            setValue3131t3(data[0].yearTable3131[2] ? data[0].yearTable3131[2].input3131y : "");
            setValue3131t4(data[0].yearTable3131[3] ? data[0].yearTable3131[3].input3131y : "");
            setValue3131t5(data[0].yearTable3131[4] ? data[0].yearTable3131[4].input3131y : "");
            setValue3131t6(data[0].yearTable3131[0] ? data[0].yearTable3131[0].input3131v : "");
            setValue3131t7(data[0].yearTable3131[1] ? data[0].yearTable3131[1].input3131v : "");
            setValue3131t8(data[0].yearTable3131[2] ? data[0].yearTable3131[2].input3131v : "");
            setValue3131t9(data[0].yearTable3131[3] ? data[0].yearTable3131[3].input3131v : "");
            setValue3131t10(data[0].yearTable3131[4] ? data[0].yearTable3131[4].input3131v : "");

            setValue3141t1(data[0].universityYearTable3141[0] ? data[0].universityYearTable3141[0].input3141y : "");
            setValue3141t2(data[0].universityYearTable3141[1] ? data[0].universityYearTable3141[1].input3141y : "");
            setValue3141t3(data[0].universityYearTable3141[2] ? data[0].universityYearTable3141[2].input3141y : "");
            setValue3141t4(data[0].universityYearTable3141[3] ? data[0].universityYearTable3141[3].input3141y : "");
            setValue3141t5(data[0].universityYearTable3141[4] ? data[0].universityYearTable3141[4].input3141y : "");
            setValue3141t6(data[0].universityYearTable3141[0] ? data[0].universityYearTable3141[0].input3141v : "");
            setValue3141t7(data[0].universityYearTable3141[1] ? data[0].universityYearTable3141[1].input3141v : "");
            setValue3141t8(data[0].universityYearTable3141[2] ? data[0].universityYearTable3141[2].input3141v : "");
            setValue3141t9(data[0].universityYearTable3141[3] ? data[0].universityYearTable3141[3].input3141v : "");
            setValue3141t10(data[0].universityYearTable3141[4] ? data[0].universityYearTable3141[4].input3141v : "");

            setValue311f1(data[0].criteria3FileUpload[0].criteria3FileName);
            setValue311f2(data[0].criteria3FileUpload[1].criteria3FileName);
            setValue311f3(data[0].criteria3FileUpload[1].criteria3FileName);
            setValue3121f1(data[0].criteria3FileUpload[3].criteria3FileName);
            setValue3121f2(data[0].criteria3FileUpload[4].criteria3FileName);
            setValue3121f3(data[0].criteria3FileUpload[4].criteria3FileName);
            setValue3121f4(data[0].criteria3FileUpload[4].criteria3FileName);
            setValue3131f1(data[0].criteria3FileUpload[5].criteria3FileName);
            setValue3131f2(data[0].criteria3FileUpload[6].criteria3FileName);
            setValue3131f3(data[0].criteria3FileUpload[6].criteria3FileName);
            setValue3141f1(data[0].criteria3FileUpload[7].criteria3FileName);
            setValue3141f2(data[0].criteria3FileUpload[8].criteria3FileName);
            setValue315f1(data[0].criteria3FileUpload[6].criteria3FileName);
            setValue315f2(data[0].criteria3FileUpload[6].criteria3FileName);
            setValue315f3(data[0].criteria3FileUpload[6].criteria3FileName);
            setValue3161f1(data[0].criteria3FileUpload[6].criteria3FileName);
            setValue3161f2(data[0].criteria3FileUpload[6].criteria3FileName);
            setValue3161f3(data[0].criteria3FileUpload[6].criteria3FileName);
          })
          .catch((error) => {
            console.error("Error:", error);
            errorMessage("Got the Error Please try after sometime");
          })
      ),
    []
  );

  // sending data to db with API
  

  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    criteria31Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input311t1: value311t1,
        input3131t1: value3131t11,
        response311: responseValue311,
      },
    ],

    criteria31Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input315t1: value315t1,
        input3161t1: value3161t1,
        input3162t1: value3161t2,
        response312: responseValue312,
        response313: responseValue313,
      },
    ],
    yearTable3121: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input3121y: value3121t1,
        input3121v: value3121t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input3121y: value3121t2,
        input3121v: value3121t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input3121y: value3121t3,
        input3121v: value3121t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input3121y: value3121t4,
        input3121v: value3121t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input3121y: value3121t5,
        input3121v: value3121t10,
      },
    ],

    yearTable3131: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input3131y: value3131t1,
        input3131v: value3131t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input3131y: value3131t2,
        input3131v: value3131t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input3131y: value3131t3,
        input3131v: value3131t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input3131y: value3131t4,
        input3131v: value3131t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input3131y: value3131t5,
        input3131v: value3131t10,
      },
    ],
    universityYearTable3141: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input3141y: value3141t1,
        input3141v: value3141t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input3141y: value3141t2,
        input3141v: value3141t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input3141y: value3141t3,
        input3141v: value3141t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input3141y: value3141t4,
        input3141v: value3141t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input3141y: value3141t5,
        input3141v: value3141t10,
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
    <div className="c31-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c31x-colorIndicator-container">
        <p className="c31x-QlcolorIndicator-circle-style"></p>
        <span className="c31x-colorIndicator-span-style">Qualitative</span>
        <p className="c31x-QtcolorIndicator-circle-style"></p>
        <span className="c31x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c31x-weightage-heading-style">
            Key Indicator Weightage: 20
          </h1>
        </div>
      </div>
      {/* Key Indicator: 3.1.1 */}
      <div className="c31x-eachInputField-container">
        <div className="c31x-weightage-container">
          <h1 className="c31x-weightage-heading-style">Weightage: 2</h1>
        </div>
        <form>
          <div className="c31x-Ql-label-textarea-container">
            <div className="c31x-heading_Help-container">
              <h1 className="c31x-heading-style">
                <span className="c31x-span-style">3.1.1: </span>
                The institution?s Research facilities are frequently updated and there is a well defined policy for promotion of research which is uploaded on the institutional website and implemented
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
            <label htmlFor="311-t1" className="c31x-label-style">
              Response:
            </label>
            <textarea
              readOnly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue311t1(e.target.value);
                setResponseValue311(e.target.value);
              }}
              value={value311t1}
              rows={10}
              className="c31x-textarea-style"
              id="311-t1"
            ></textarea>
            {value311t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c31x-Ql-table-style">
            <tr>
              <th className="c31x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c31x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c31x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c31x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c31x-Ql-tableBorders-style">
              Upload any additional information
              </td>
              <td className="c31x-Ql-tableBorders-style"></td>
              <td className="c31x-Ql-tableBorders-style">
                <a href={downloadFile(value311f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c31x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c31x-Ql-tableBorders-style">
              Provide links as Additional Information
              </td>
              <td className="c31x-Ql-tableBorders-style">
                
                  {/* View Template
                </a> */}
              </td>
              <td className="c31x-Ql-tableBorders-style">
              <a target="_blank" href={pathValue311f2}>
                  view
                </a>
              </td>
              <td className="c31x-Ql-tableBorders-style">pdf</td>
            </tr>
           
          </table>
        </form>
      </div>

      {/* Key Indicator: 3.1.2 */}
      <div className="c31x-eachInputField-container">
        <div className="c31x-weightage-container">
          <h1 className="c31x-weightage-heading-style">Weightage: 3</h1>
        </div>
        <form>
          <div className="c31x-container">
            <div className="c31x-heading_Help-container">
              <h1 className="c31x-heading-style">
                <span className="c31x-span-style">3.1.2: </span>
                The institution provides seed money to its teachers for research (average per year; INR in Lakhs)
              </h1>
              <button
                onClick={handleHelpOpen2}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen2}
                handleClose={handleHelpClose}
                title='formula'
                ><h1>(?????????? ???????????? ???? ???????? ??????????) / 5</h1></HelpButton>
            </div>
            <div className="c31x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus312(!responseButtonStatus312);
                  onClickingViewResponse312();
                }}
                className="c31x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus312 ? (
                <p className="c31x-responseResult-style">{responseValue312}</p>
              ) : null}
            </div>
          </div>
          <div className="c31xx-container">
            <h1 className="c31xx-Heading-style">
              <span className="c31xx-span-style">3.1.2.1: </span>
              Amount of seed money provided by institution to its faculty year- wise during the last five years(INR in lakhs)
            </h1>

            <table className="c31x-Qt-table-style">
              <tr>
                <th className="c31x-horizontalTable-heading-style">Year</th>
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
                      onChange={(e) => setValue3121t1(e.target.value)}
                      id="3121-t1"
                      className="c31x-input-style"
                      type="number"
                      value={value3121t1}
                    />
                    {value3121t1 === "" ? (
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
                      onChange={(e) => setValue3121t2(e.target.value)}
                      id="3121-t2"
                      className="c31x-input-style"
                      type="number"
                      value={value3121t2}
                    />
                    {value3121t2 === "" ? (
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
                      onChange={(e) => setValue3121t3(e.target.value)}
                      id="3121-t3"
                      className="c31x-input-style"
                      type="number"
                      value={value3121t3}
                    />
                    {value3121t3 === "" ? (
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
                      onChange={(e) => setValue3121t4(e.target.value)}
                      id="3121-t4"
                      className="c31x-input-style"
                      type="number"
                      value={value3121t4}
                    />
                    {value3121t4 === "" ? (
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
                      onChange={(e) => setValue3121t5(e.target.value)}
                      id="3121-t5"
                      className="c31x-input-style"
                      type="number"
                      value={value3121t5}
                    />
                    {value3121t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c31x-horizontalTable-heading-style">
                 Sanctioned
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
                      onChange={(e) => {
                        setValue3121t6(e.target.value);
                        onClickingViewResponse312();
                      }}
                      id="3121-t6"
                      className="c31x-input-style"
                      type="number"
                      value={value3121t6}
                    />
                    {value3121t6 === "" ? (
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
                        setValue3121t7(e.target.value);
                        onClickingViewResponse312();
                      }}
                      id="3121-t7"
                      className="c31x-input-style"
                      type="number"
                      value={value3121t7}
                    />
                    {value3121t7 === "" ? (
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
                        setValue3121t8(e.target.value);
                        onClickingViewResponse312();
                      }}
                      id="3121-t8"
                      className="c31x-input-style"
                      type="number"
                      value={value3121t8}
                    />
                    {value3121t8 === "" ? (
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
                        setValue3121t9(e.target.value);
                        onClickingViewResponse312();
                      }}
                      id="3121-t9"
                      className="c31x-input-style"
                      type="number"
                      value={value3121t9}
                    />
                    {value3121t9 === "" ? (
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
                        setValue3121t10(e.target.value);
                        onClickingViewResponse312();
                      }}
                      id="3121-t10"
                      className="c31x-input-style"
                      type="number"
                      value={value3121t10}
                    />
                    {value3121t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c31x-table-style">
              <tr>
                <th className="c31x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c31x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c31x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c31x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Institutional data in the prescribed format (data template)</td>
                <td></td>
                <td>
                  <a href={downloadFile(value3121f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>List of faculty who have been provided with seed money for research along with the title of the project, duration and amount year-wise.</td>
                <td></td>
                <td>
                  <a href={downloadFile(value3121f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                Sanction letters of seed money to the teachers is mandatory
                </td>
                <td></td>
                <td>
                  <a href={downloadFile(value3121f3)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                Audited Income-Expenditure statement highlighting the expenditure towards seed money endorsed by the Finance Officer
                </td>
                <td>
                  <a href={downloadFile("un3.1.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <a href={downloadFile(value3121f4)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
      {/* Key Indicator: 3.1.3 */}
      <div className="c31x-eachInputField-container">
        <div className="c31x-weightage-container">
          <h1 className="c31x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c31x-container">
            <div className="c31x-heading_Help-container">
              <h1 className="c31x-heading-style">
                <span className="c31x-span-style">3.1.3: </span>
                Percentage of teachers receiving national/ international fellowship/financial support by various agencies for advanced studies/ research during the last five years
              </h1>
              <button
                onClick={handleHelpOpen3}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen3}
                handleClose={handleHelpClose3}
                title='formula'
                ><h1>(Total number of teachers who received national/international fellowship/ financial support by variousagencies for advanced studies/research during the last five years) /( (2.2 Total number of full time teachers (without repeat count) )) * 100</h1></HelpButton>
            </div>
            <div className="c31x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus313(!responseButtonStatus313);
                  onClickingViewResponse313();
                }}
                className="c31x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus313 ? (
                <p className="c31x-responseResult-style">{responseValue313}</p>
              ) : null}
            </div>
          </div>
          <div className="c31xx-container">
            <h1 className="c31xx-Heading-style">
              <span className="c31xx-span-style">3.1.3.1: </span>
              Number of teachers who received national/ international fellowship/financial support from various agencies, for advanced studies / research; year-wise during the last five years
            </h1>

            <table className="c31x-Qt-table-style">
              <tr>
                <th className="c31x-horizontalTable-heading-style">Year</th>
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
                      onChange={(e) => setValue3131t1(e.target.value)}
                      id="3131-t1"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t1}
                    />
                    {value3131t1 === "" ? (
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
                      onChange={(e) => setValue3131t2(e.target.value)}
                      id="3131-t2"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t2}
                    />
                    {value3131t2 === "" ? (
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
                      onChange={(e) => setValue3131t3(e.target.value)}
                      id="3131-t3"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t3}
                    />
                    {value3131t3 === "" ? (
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
                      onChange={(e) => setValue3131t4(e.target.value)}
                      id="3131-t4"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t4}
                    />
                    {value3131t4 === "" ? (
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
                      onChange={(e) => setValue3131t5(e.target.value)}
                      id="3131-t5"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t5}
                    />
                    {value3131t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c31x-horizontalTable-heading-style">
                  Number of teachers
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
                      onChange={(e) => {
                        setValue3131t6(e.target.value);
                        onClickingViewResponse313();
                      }}
                      id="3131-t6"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t6}
                    />
                    {value3131t6 === "" ? (
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
                        setValue3131t7(e.target.value);
                        onClickingViewResponse313();
                      }}
                      id="3131-t7"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t7}
                    />
                    {value3131t7 === "" ? (
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
                        setValue3131t8(e.target.value);
                        onClickingViewResponse313();
                      }}
                      id="3131-t8"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t8}
                    />
                    {value3131t8 === "" ? (
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
                        setValue3131t9(e.target.value);
                        onClickingViewResponse313();
                      }}
                      id="3131-t9"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t9}
                    />
                    {value3131t9 === "" ? (
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
                        setValue3131t10(e.target.value);
                        onClickingViewResponse313();
                      }}
                      id="3131-t10"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t10}
                    />
                    {value3131t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <div className="c31xx-label-textInput-container">
              <label className="c31xx-Heading-style">
                Total number of full time teachers during the last five years
              </label>
              <input
                readOnly
                onChange={(e) => {
                  setValue3131t11(e.target.value);
                  onClickingViewResponse313();
                }}
                id="3131-t11"
                style={{ marginLeft: "4%" }}
                type="text"
                value={value3131t11}
              />
              {value3131t11 === "" ? <p style={{ color: "red" }}>*</p> : null}
            </div>

            <table className="c31x-table-style">
              <tr>
                <th className="c31x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c31x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c31x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c31x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Institutional data in the prescribed format (data template)</td>
                <td></td>
                <td>
                  <a href={downloadFile(value3131f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>E-copies of the award letters of the teachers.</td>
                <td></td>
                <td>
                  <a href={downloadFile(value3131f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                List of teachers who have received the awards along with the nature of award, the awarding agency etc.
                </td>
                <td>
                <a href={downloadFile("un3.1.3.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <a href={downloadFile(value3131f3)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

{/* 3.1.4 */}
      <div className="c31x-eachInputField-container">
        <div className="c31x-weightage-container">
          <h1 className="c31x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c31x-container">
            <div className="c31x-heading_Help-container">
              <h1 className="c31x-heading-style">
                <span className="c31x-span-style">3.1.4: </span>
                Percentage of JRFs, SRFs among the enrolled PhD scholars in the institution during the last five years
              </h1>
              <button
                onClick={handleHelpOpen4}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen4}
                handleClose={handleHelpClose4}
                title='formula'
                ><h1>(?????????? ????.??????+?????? ???????????? ???????? ???????? ??????????)/(????.???? ??h?? ????h?????????? ???????????????? ???????????? ???????? ???????? ??????????) * 100</h1></HelpButton>
            </div>
            <div className="c31x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus314(!responseButtonStatus314);
                  onClickingViewResponse314();
                }}
                className="c31x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus314 ? (
                <p className="c31x-responseResult-style">{responseValue314}</p>
              ) : null}
            </div>
          </div>
          <div className="c31xx-container">
            <h1 className="c31xx-Heading-style">
              <span className="c31xx-span-style">3.1.4.1: </span>
              The Number of JRFs, SRFs among the enrolled PhD scholars in the institution during the last five years
<input></input>
</h1>
            <h1 className="c31xx-Heading-style">
              <span className="c31xx-span-style">3.1.4.1: </span>
              Number of PhD Scholars enrolled during last five years
              <input></input>
</h1>
            

            <table className="c31x-table-style">
              <tr>
                <th className="c31x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c31x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c31x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c31x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Institutional data in the prescribed format (data template)</td>
                <td><a href={downloadFile("un3.1.4.xlsx")} target="_blank">view Template </a></td>
                <td>
                  <a href={downloadFile(value3141f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                List of JRFs, SRFs, Post Doctoral Fellows, Research Associates and other research fellows along with the details of the funding agency is to be provided
                </td>
                <td></td>
                <td>
                  <a href={downloadFile(value3141f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                E copies of fellowship award letters (mandatory)              
                  </td>
                <td></td>
                <td>
                  <a href={downloadFile(value3141f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 3.1.5 */}
      <div className="c31x-eachInputField-container">
        <div className="c31x-weightage-container">
          <h1 className="c31x-weightage-heading-style">Weightage: 3</h1>
        </div>
        <form>
          <div className="c31x-container">
            <div className="c31x-heading_Help-container">
              <div>
                <h1 className="c31x-heading-style">
                  <span className="c31x-span-style">3.1.5: </span>
                  Institution has the following facilities to support research:
                </h1>
                <p className="c31x-para-style">
                  1. Central Instrumentation Centre
                  <br />
                  2. Animal House/Green House
                  <br />
                  3. Museum
                  <br />
                  5. Business Lab
                  <br />
                  6. Research/Statistical Databases
                  <br />
                  7. Mootcourt
                  <br />
                  8. Theatre
                  <br />
                  9. Art Gallery
                  <br />
                  10. Any other facility to support research.
                </p>
                <div className="c31x-radio-container">
                  <div className="c31x-radio-subContainer">
                    <div className="c31x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue315t1(e.target.value)}
                        value="option a"
                        name="315-t1"
                        type="radio"
                      />

                      <label className="c31x-radioLabel-style" for="315-t1">
                        A. Any 4 or more of the above
                      </label>
                    </div>

                    <div className="c31x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue315t1(e.target.value)}
                        value="option b"
                        name="315-t1"
                        type="radio"
                      />

                      <label className="c31x-radioLabel-style" for="315-t2">
                        B. Any 3 of the above
                      </label>
                    </div>

                    <div className="c31x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue315t1(e.target.value)}
                        value="option c"
                        name="315-t1"
                        type="radio"
                      />

                      <label className="c31x-radioLabel-style" for="315-t3">
                        C. Any 2 of the above
                      </label>
                    </div>
                  </div>

                  <div className="c31x-radio-subContainer">
                    <div className="c31x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue315t1(e.target.value)}
                        value="option d"
                        name="315-t1"
                        type="radio"
                      />

                      <label className="c31x-radioLabel-style" for="315-t1">
                        D. Any 1 of the above
                      </label>
                    </div>

                    <div className="c31x-eachRadio-container">
                      <input
                        readOnly
                        onChange={(e) => setValue315t1(e.target.value)}
                        value="option e"
                        name="315-t1"
                        type="radio"
                      />

                      <label className="c31x-radioLabel-style" for="315-t1">
                        E. None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen5}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen5}
                handleClose={handleHelpClose5}
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <div className="c31x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus315(!responseButtonStatus315);
                  onClickingViewResponse315();
                }}
                className="c31x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus315 ? (
                <p className="c31x-responseResult-style">{responseValue315}</p>
              ) : null}
            </div>
          </div>
          <table className="c31x-table-style">
            <tr>
              <th className="c31x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c31x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c31x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c31x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Provide the link of videos and geo-tagged photographs </td>
              <td></td>
              <td>
                <a href={downloadFile(value315f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c31x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Upload the list of facilities provided by the university and
                their year/s of establishment{" "}
              </td>
              <td></td>
              <td>
                <a href={downloadFile(value315f2)} target="_blank">
                  view
                </a>
              </td>
              <td className="c31x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Upload any additional information </td>
              <td></td>
              <td>
                <a href={downloadFile(value315f3)} target="_blank">
                  view
                </a>
              </td>
              <td className="c31x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 3.1.6 */}
      <div className="c31x-eachInputField-container">
        <div className="c31x-weightage-container">
          <h1 className="c31x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c31x-container">
            <div className="c31x-heading_Help-container">
              <h1 className="c31x-heading-style">
                <span className="c31x-span-style">3.1.6: </span>
                Percentage of departments with UGC-SAP, CAS, DST-FIST, DBT,
                ICSSR and other recognitions by national and international
                agencies (Data for the latest completed academic year)
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
            <div className="c31x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus316(!responseButtonStatus316);
                  onClickingViewResponse316();
                }}
                className="c31x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus316 ? (
                <p className="c31x-responseResult-style">{responseValue316}</p>
              ) : null}
            </div>
          </div>
          <div className="c31xx-container">
            <h1 className="c31xx-Heading-style">
              <span className="c31xx-span-style">3.1.6.1: </span>
              The Number of departments with UGC-SAP, CAS, DST-FIST , DBT, ICSSR
              and other similar recognitions by national and international
              agencies
              <input
                readOnly
                onChange={(e) => setValue3161t1(e.target.value)}
                id="3161-t1"
                style={{ marginLeft: "4%" }}
                type="text"
              />
            </h1>
            <h1 className="c31xx-Heading-style">
              <span className="c31xx-span-style">3.1.6.1: </span>
              Total number of departments offering academic programmes
              <input
                readOnly
                onChange={(e) => setValue3161t2(e.target.value)}
                id="3161-t2"
                style={{ marginLeft: "4%" }}
                type="text"
              />
            </h1>

            <table className="c31x-table-style">
              <tr>
                <th className="c31x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c31x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c31x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c31x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <a href={downloadFile(value3161f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Criteria31;
