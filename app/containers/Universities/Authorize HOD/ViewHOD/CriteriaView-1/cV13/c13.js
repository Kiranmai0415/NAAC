import React, { useState, useEffect } from "react";
import "./c13-style.css";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
import { resources } from "../../../../../appConstants";
// Help buttons functionality
function Help131(props) {
  return props.isHelp131Clicked ? (
    <div className="c13x-help-mainContainer">
      <div className="c13x-help-subContainer">
        <h1 className="c13x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c13x-help-para-style">
          Justify that the college satisfies the metric Describe it in maximum
          500 words.
        </p>
        <button
          className="c13x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp131Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help132(props) {
  return props.isHelp132Clicked ? (
    <div className="c13x-help-mainContainer">
      <div className="c13x-help-subContainer">
        <h1 className="c13x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c13x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span>The total amount of seed
          money provided by institution to its teachers for research in the last
          five years
          <span style={{ fontWeight: "bold" }}>) /</span> 5
        </p>
        <button
          className="c13x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp132Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help133(props) {
  return props.isHelp133Clicked ? (
    <div className="c13x-help-mainContainer">
      <div className="c13x-help-subContainer">
        <h1 className="c13x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c13x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span>Number of students
          enrolled in subject related Certificate or Add-on programs year wise
          during last five years<span style={{ fontWeight: "bold" }}> / </span>
          Total number of Students
          <span style={{ fontWeight: "bold" }}>) * </span>100
        </p>
        <p className="c13x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span> Average percentage
          <span style={{ fontWeight: "bold" }}> = </span>Σpercentage per year
          <span style={{ fontWeight: "bold" }}>) / </span>5
        </p>
        <button
          className="c13x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp133Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help134(props) {
  return props.isHelp134Clicked ? (
    <div className="c13x-help-mainContainer">
      <div className="c13x-help-subContainer">
        <h1 className="c13x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c13x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span> Number of students
          undertaking field projects / internships / student projects
          <span style={{ fontWeight: "bold" }}> /</span> Total number of
          students
          <span style={{ fontWeight: "bold" }}>)*</span>100
        </p>
        <button
          className="c13x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp134Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
// Promotion of Research and Facilities
function Criteria13() {
   // getfile data with API
   function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
 //help buttom
  const [isOpen, setIsopen] = useState(false)
  const [isOpen3, setIsopen3] = useState(false)
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
  const handleHelpClose3 = () => {
    setIsopen3(false)
  }
  const handleHelpOpen2 =(e)=>{
    e.preventDefault();
    setIsopen2(true)
  } 
  const handleHelpClose2 = (e)=>{
    setIsopen2(false)
  }
  // state variable
  const [value131t1, setValue131t1] = useState();
  const [pathValue131f1, setPathValue131f1] = useState("");
  const [pathValue131f2, setPathValue131f2] = useState("");

  const [value131f1, setValue131f1] = useState([]);
  const [value131f2, setValue131f2] = useState([]);

  const [value1321t1, setValue1321t1] = useState();
  const [value1321t2, setValue1321t2] = useState();
  const [value1321t3, setValue1321t3] = useState();
  const [value1321t4, setValue1321t4] = useState();
  const [value1321t5, setValue1321t5] = useState();
  const [value1321t6, setValue1321t6] = useState();
  const [value1321t7, setValue1321t7] = useState();
  const [value1321t8, setValue1321t8] = useState();
  const [value1321t9, setValue1321t9] = useState();
  const [value1321t10, setValue1321t10] = useState();

  const [pathValue1321f1, setPathValue1321f1] = useState("");
  const [pathValue1321f2, setPathValue1321f2] = useState("");
  const [pathValue1321f3, setPathValue1321f3] = useState("");

  const [value1321f1, setValue1321f1] = useState([]);
  const [value1321f2, setValue1321f2] = useState([]);
  const [value1321f3, setValue1321f3] = useState([]);

  const [value1331t1, setValue1331t1] = useState();
  const [value1331t2, setValue1331t2] = useState();
  const [value1331t3, setValue1331t3] = useState();
  const [value1331t4, setValue1331t4] = useState();
  const [value1331t5, setValue1331t5] = useState();
  const [value1331t6, setValue1331t6] = useState();
  const [value1331t7, setValue1331t7] = useState();
  const [value1331t8, setValue1331t8] = useState();
  const [value1331t9, setValue1331t9] = useState();
  const [value1331t10, setValue1331t10] = useState();
  const [value1331t11, setValue1331t11] = useState();
  const [value1331t12, setValue1331t12] = useState();
  const [value1331t13, setValue1331t13] = useState();
  const [value1331t14, setValue1331t14] = useState();
  const [value1331t15, setValue1331t15] = useState();
  const [value1331t16, setValue1331t16] = useState();
  const [value1331t17, setValue1331t17] = useState();
  const [value1331t18, setValue1331t18] = useState();
  const [value1331t19, setValue1331t19] = useState();
  const [value1331t20, setValue1331t20] = useState();

  const [pathValue1331f1, setPathValue1331f1] = useState("");
  const [pathValue1331f2, setPathValue1331f2] = useState("");

  const [value1331f1, setValue1331f1] = useState([]);
  const [value1331f2, setValue1331f2] = useState([]);
  const [value134t1, setValue134t1] = useState();
  const [value1341t1, setValue1341t1] = useState();
  const [pathValue1341f1, setPathValue1341f1] = useState("");
  const [pathValue1341f2, setPathValue1341f2] = useState("");

  const [value1341f1, setValue1341f1] = useState([]);
  const [value1341f2, setValue1341f2] = useState([]);
  const [value1341f3, setValue1341f3] = useState([]);

  const [responseButtonStatus132, setResponseButtonStatus132] = useState(false);
  const [responseButtonStatus133, setResponseButtonStatus133] = useState(false);
  const [responseButtonStatus134, setResponseButtonStatus134] = useState(false);
  const [responseValue131, setResponseValue131] = useState("");
  const [responseValue132, setResponseValue132] = useState("");
  const [responseValue133, setResponseValue133] = useState("");
  const [responseValue134, setResponseValue134] = useState("");
  const [help131Status, setHelp131Status] = useState(false);
  const [help132Status, setHelp132Status] = useState(false);
  const [help133Status, setHelp133Status] = useState(false);
  const [help134Status, setHelp134Status] = useState(false);

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

  //get data api
  const financialYear = "2021-2022";
  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria1getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then((response) =>(response) =>
        response
          .json()
          .then((data) => {
            console.log("13 data is " + JSON.stringify(data));

            setValue131t1(data[0].criteria13Ql[0].input131t1);
            setResponseValue131(data[0].criteria13Ql[0].response131);
            setValue134t1(data[0].criteria13Qn[0].input1341t1);
            setValue1341t1(data[0].criteria13Qn[0].input1341t2);
            setResponseValue132(data[0].criteria13Qn[0].response132);
            setResponseValue133(data[0].criteria13Qn[0].response133);
            setResponseValue134(data[0].criteria13Qn[0].response134);

            setValue1321t1(data[0].yearTable1321[0].input1321y);
            setValue1321t2(data[0].yearTable1321[1].input1321y);
            setValue1321t3(data[0].yearTable1321[2].input1321y);
            setValue1321t4(data[0].yearTable1321[3].input1321y);
            setValue1321t5(data[0].yearTable1321[4].input1321y);
            setValue1321t6(data[0].yearTable1321[0].input1321v);
            setValue1321t7(data[0].yearTable1321[1].input1321v);
            setValue1321t8(data[0].yearTable1321[2].input1321v);
            setValue1321t9(data[0].yearTable1321[3].input1321v);
            setValue1321t10(data[0].yearTable1321[4].input1321v);

            setValue1331t1(data[0].yearTable1331[0].input1331y);
            setValue1331t2(data[0].yearTable1331[1].input1331y);
            setValue1331t3(data[0].yearTable1331[2].input1331y);
            setValue1331t4(data[0].yearTable1331[3].input1331y);
            setValue1331t5(data[0].yearTable1331[4].input1331y);
            setValue1331t6(data[0].yearTable1331[0].input1331v);
            setValue1331t7(data[0].yearTable1331[1].input1331v);
            setValue1331t8(data[0].yearTable1331[2].input1331v);
            setValue1331t9(data[0].yearTable1331[3].input1331v);
            setValue1331t10(data[0].yearTable1331[4].input1331v);

            setValue1331t11(data[0].yearTable13312[0].input13312y);
            setValue1331t12(data[0].yearTable13312[1].input13312y);
            setValue1331t13(data[0].yearTable13312[2].input13312y);
            setValue1331t14(data[0].yearTable13312[3].input13312y);
            setValue1331t15(data[0].yearTable13312[4].input13312y);
            setValue1331t16(data[0].yearTable13312[0].input13312v);
            setValue1331t17(data[0].yearTable13312[1].input13312v);
            setValue1331t18(data[0].yearTable13312[2].input13312v);
            setValue1331t19(data[0].yearTable13312[3].input13312v);
            setValue1331t20(data[0].yearTable13312[4].input13312v);

            setValue131f1(data[0].criteria1FileUpload[1].criteria1FileName);
            setValue131f2(data[0].criteria1FileUpload[1].criteria1FileName);
            setValue1321f1(data[0].criteria1FileUpload[1].criteria1FileName);
            setValue1321f2(data[0].criteria1FileUpload[1].criteria1FileName);
            setValue1321f3(data[0].criteria1FileUpload[1].criteria1FileName);
            setValue1331f1(data[0].criteria1FileUpload[1].criteria1FileName);
            setValue1331f2(data[0].criteria1FileUpload[1].criteria1FileName);
            setValue1341f1(data[0].criteria1FileUpload[1].criteria1FileName);
            setValue1341f2(data[0].criteria1FileUpload[1].criteria1FileName);
            setValue1341f3(data[0].criteria1FileUpload[1].criteria1FileName);
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );

  // response button functionality

  function onClickingViewResponse132() {
    if (
      value1321t6 === "" ||
      value1321t7 === "" ||
      value1321t8 === "" ||
      value1321t9 === "" ||
      value1321t10 === "" ||
      value1321t6 === undefined ||
      value1321t7 === undefined ||
      value1321t8 === undefined ||
      value1321t9 === undefined ||
      value1321t10 === undefined
    ) {
      setResponseValue132("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value1321t6, 10)) === false ||
      Number.isInteger(parseInt(value1321t7, 10)) === false ||
      Number.isInteger(parseInt(value1321t8, 10)) === false ||
      Number.isInteger(parseInt(value1321t9, 10)) === false ||
      Number.isInteger(parseInt(value1321t10, 10)) === false
    ) {
      setResponseValue132("Input should be an Integer");
    } else if (
      value1321t6 !== "" &&
      value1321t7 !== "" &&
      value1321t8 !== "" &&
      value1321t9 !== "" &&
      value1321t10 !== ""
    ) {
      setResponseValue132(
        parseInt(value1321t6, 10) +
          parseInt(value1321t7, 10) +
          parseInt(value1321t8, 10) +
          parseInt(value1321t9, 10) +
          parseInt(value1321t10, 10)
      );
    }
  }

  function onClickingViewResponse133() {
    if (
      value1331t6 === "" ||
      value1331t7 === "" ||
      value1331t8 === "" ||
      value1331t9 === "" ||
      value1331t10 === "" ||
      value1331t16 === "" ||
      value1331t17 === "" ||
      value1331t18 === "" ||
      value1331t19 === "" ||
      value1331t20 === "" ||
      value1331t6 === undefined ||
      value1331t7 === undefined ||
      value1331t8 === undefined ||
      value1331t9 === undefined ||
      value1331t10 === undefined ||
      value1331t16 === undefined ||
      value1331t17 === undefined ||
      value1331t18 === undefined ||
      value1331t19 === undefined ||
      value1331t20 === undefined
    ) {
      setResponseValue133("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value1331t6, 10)) === false ||
      Number.isInteger(parseInt(value1331t7, 10)) === false ||
      Number.isInteger(parseInt(value1331t8, 10)) === false ||
      Number.isInteger(parseInt(value1331t9, 10)) === false ||
      Number.isInteger(parseInt(value1331t10, 10)) === false ||
      Number.isInteger(parseInt(value1331t16, 10)) === false ||
      Number.isInteger(parseInt(value1331t17, 10)) === false ||
      Number.isInteger(parseInt(value1331t18, 10)) === false ||
      Number.isInteger(parseInt(value1331t19, 10)) === false ||
      Number.isInteger(parseInt(value1331t20, 10)) === false
    ) {
      setResponseValue133("Input should be an Integer");
    } else if (
      value1331t6 !== "" &&
      value1331t7 !== "" &&
      value1331t8 !== "" &&
      value1331t9 !== "" &&
      value1331t10 !== "" &&
      value1331t16 !== "" &&
      value1331t17 !== "" &&
      value1331t18 !== "" &&
      value1331t19 !== "" &&
      value1331t20 !== ""
    ) {
      setResponseValue133(
        ((value1331t6 / value1331t16) * 100 +
          (value1331t6 / value1331t16) * 100 +
          (value1331t6 / value1331t16) * 100 +
          (value1331t6 / value1331t16) * 100 +
          (value1331t6 / value1331t16) * 100) /
          5
      );
    }
  }

  function onClickingViewResponse134() {
    if (value134t1 === "" || value1341t1 === "") {
      setResponseValue134("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value134t1, 10)) === false ||
      Number.isInteger(parseInt(value1341t1, 10)) === false
    ) {
      setResponseValue134("Input should be an Integer");
    } else if (value134t1 !== "" && value1341t1 !== "") {
      setResponseValue134(
        (parseInt(value134t1, 10) / parseInt(value1341t1, 10)) * 100
      );
    }
  }

  
  

  // sending data to db with API

  function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
  }
  // sending data to db with API

  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    criteria13Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input131t1: value131t1,
        response131: responseValue131,
      },
    ],
    criteria13Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input1341t1: value134t1,
        input1341t2: value1341t1,
        response132: responseValue132,
        response133: responseValue133,
        response134: responseValue134,
      },
    ],

    yearTable1321: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input1321y: value1321t1,
        input1321v: value1321t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input1321y: value1321t2,
        input1321v: value1321t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input1321y: value1321t3,
        input1321v: value1321t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input1321y: value1321t4,
        input1321v: value1321t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input1321y: value1321t5,
        input1321v: value1321t10,
      },
    ],
    yearTable1331: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input1331y: value1331t1,
        input1331v: value1331t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input1331y: value1331t2,
        input1331v: value1331t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input1331y: value1331t3,
        input1331v: value1331t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input1331y: value1331t4,
        input1331v: value1331t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input1331y: value1331t5,
        input1331v: value1331t10,
      },
    ],
    yearTable13312: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input13312y: value1331t11,
        input13312v: value1331t16,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input13312y: value1331t12,
        input13312v: value1331t17,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input13312y: value1331t13,
        input13312v: value1331t18,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input13312y: value1331t14,
        input13312v: value1331t19,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input13312y: value1331t15,
        input13312v: value1331t20,
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
    <div className="c13-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c13x-colorIndicator-container">
        <p className="c13x-QlcolorIndicator-circle-style"></p>
        <span className="c13x-colorIndicator-span-style">Qualitative</span>
        <p className="c13x-QtcolorIndicator-circle-style"></p>
        <span className="c13x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c13x-weightage-heading-style">
            Key Indicator Weightage: 50
          </h1>
        </div>
      </div>

      {/* Key Indicator: 1.3.1 */}
      <div className="c13x-eachInputField-container">
        <div className="c13x-weightage-container">
          <h1 className="c13x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c13x-Ql-label-textarea-container">
            <div className="c13x-heading_Help-container">
              <h1 className="c13x-heading-style">
                <span className="c13x-span-style">1.3.1: </span>
                Institution integrates cross-cutting issues relevant to Professional Ethics, Gender, Human Values, Environment & Sustainability and other value framework enshrined in Sustainable Development goals and National Education Policy-2020 into the Curriculum
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
            <label htmlFor="131-t1" className="c13x-label-style">
              Response:
            </label>
            <textarea
              readOnly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue131t1(e.target.value);
                setResponseValue131(e.target.value);
              }}
              value={value131t1}
              rows={10}
              className="c13x-textarea-style"
              id="131-t1"
            ></textarea>
            {value131t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c13x-Ql-table-style">
            <tr>
              <th className="c13x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c13x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c13x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c13x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c13x-Ql-tableBorders-style">
                Any additional information
              </td>
              <td className="c13x-Ql-tableBorders-style"></td>
              <td className="c13x-Ql-tableBorders-style">
                <a href={downloadFile(value131f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c13x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c13x-Ql-tableBorders-style">
              Provide Link for Additional information
              </td>
              <td></td>
              <td className="c13x-Ql-tableBorders-style">
                <a href={downloadFile(value131f2)} target="_blank">
                  view
                </a>
              </td>
              <td className="c13x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 1.3.2 */}
      <div className="c13x-eachInputField-container">
        <div className="c13x-weightage-container">
          <h1 className="c13x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c13x-container">
            <div className="c13x-heading_Help-container">
              <h1 className="c13x-heading-style">
                <span className="c13x-span-style">1.3.2: </span>
                Number of certificate / value-added courses / Diploma Programme/ online courses of MOOCS / SWAYAM / e_Pathshala/ NPTEL etc. where the students of the institution have enrolled and successfully completed
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
            <div className="c13x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus132(!responseButtonStatus132);
                  onClickingViewResponse132();
                }}
                className="c13x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus132 ? (
                <p className="c13x-responseResult-style">{responseValue132}</p>
              ) : null}
            </div>
          </div>
          <div className="c13xx-container">
            <h1 className="c13xx-Heading-style">
              <span className="c13xx-span-style">1.3.2.1: </span>
              How many certificate/value added courses/Diploma Programme/ online courses of MOOCS/SWAYAM/e Pathshala/ NPTEL etc (without repeat count) where the students of the institution have enrolled and successfully completed.
            <input></input>
            </h1>

            {/* <table className="c13x-Qt-table-style">
              <tr>
                <th className="c13x-horizontalTable-heading-style">Year</th>
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
                      onChange={(e) => setValue1321t1(e.target.value)}
                      id="1321-t1"
                      className="c13x-input-style"
                      type="text"
                      value={value1321t1}
                    />
                    {value1321t1 === "" ? (
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
                      onChange={(e) => setValue1321t2(e.target.value)}
                      id="1321-t2"
                      className="c13x-input-style"
                      type="text"
                      value={value1321t2}
                    />
                    {value1321t2 === "" ? (
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
                      onChange={(e) => setValue1321t3(e.target.value)}
                      id="1321-t3"
                      className="c13x-input-style"
                      type="text"
                      value={value1321t3}
                    />
                    {value1321t3 === "" ? (
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
                      onChange={(e) => setValue1321t4(e.target.value)}
                      id="1321-t4"
                      className="c13x-input-style"
                      type="text"
                      value={value1321t4}
                    />
                    {value1321t4 === "" ? (
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
                      onChange={(e) => setValue1321t5(e.target.value)}
                      id="1321-t5"
                      className="c13x-input-style"
                      type="text"
                      value={value1321t5}
                    />
                    {value1321t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c13x-horizontalTable-heading-style">Number</th>
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
                        setValue1321t6(e.target.value);
                        onClickingViewResponse132();
                      }}
                      id="1321-t6"
                      className="c13x-input-style"
                      type="text"
                      value={value1321t6}
                    />
                    {value1321t6 === "" ? (
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
                        setValue1321t7(e.target.value);
                        onClickingViewResponse132();
                      }}
                      id="1321-t7"
                      className="c13x-input-style"
                      type="text"
                      value={value1321t7}
                    />
                    {value1321t7 === "" ? (
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
                        setValue1321t8(e.target.value);
                        onClickingViewResponse132();
                      }}
                      id="1321-t8"
                      className="c13x-input-style"
                      type="text"
                      value={value1321t8}
                    />
                    {value1321t8 === "" ? (
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
                        setValue1321t9(e.target.value);
                        onClickingViewResponse132();
                      }}
                      id="1321-t9"
                      className="c13x-input-style"
                      type="text"
                      value={value1321t9}
                    />
                    {value1321t9 === "" ? (
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
                        setValue1321t10(e.target.value);
                        onClickingViewResponse132();
                      }}
                      id="1321-t10"
                      className="c13x-input-style"
                      type="text"
                      value={value1321t10}
                    />
                    {value1321t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> */}

            <table className="c13x-table-style">
              <tr>
                <th className="c13x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c13x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c13x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c13x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Institutional data in the prescribed format (data template) </td>
                <td></td>
                <td>
                  <a href={downloadFile(value1321f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                Institutional programme brochure/notice for Certificate/Value added programs with course modules and outcomes                </td>
                <td></td>
                <td>
                  <a href={downloadFile(value1321f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>List of students and the attendance sheet for the above mentioned programs</td>
                <td>
                <a href={downloadFile("un1.3.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <a href={downloadFile(value1321f3)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Evidence of course completion, like course completion certificate etc.</td>
                <td>
                <a href={downloadFile("un1.3.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <a href={downloadFile(value1321f3)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 1.3.3 */}
      <div className="c13x-eachInputField-container">
        <div className="c13x-weightage-container">
          <h1 className="c13x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c13x-container">
            <div className="c13x-heading_Help-container">
              <h1 className="c13x-heading-style">
                <span className="c13x-span-style">1.3.3: </span>
                Percentage of Programmes that have components of field projects / research projects / internships during last five years              </h1>
              
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
                >(𝐓𝐨𝐭𝐚𝐥 𝐍𝐮𝐦𝐛𝐞𝐫 𝐨𝐟 𝐏𝐫𝐨𝐠𝐫𝐚𝐦𝐬 𝐭𝐡𝐚𝐭 𝐡𝐚𝐯𝐞 𝐜𝐨𝐦𝐩𝐨𝐧𝐞𝐧𝐭𝐬 𝐨𝐟 𝐟𝐢𝐞𝐥𝐝 𝐩𝐫𝐨𝐣𝐞𝐜𝐭𝐬 / 𝐫𝐞𝐬𝐞𝐚𝐫𝐜𝐡 𝐩𝐫𝐨𝐣𝐞𝐜𝐭𝐬 𝐢𝐧𝐭𝐞𝐫𝐧𝐬𝐡𝐢𝐩𝐬 𝐝𝐮𝐫𝐢𝐧𝐠 𝐭𝐡𝐞 𝐥𝐚𝐬𝐭 𝐟𝐢𝐯𝐞 𝐲𝐞𝐚𝐫𝐬 ) /( 𝐓𝐨𝐭𝐚𝐥 𝐍𝐮𝐦𝐛𝐞𝐫 𝐨𝐟 𝐏𝐫𝐨𝐠𝐫𝐚𝐦𝐬 𝐨𝐟𝐟𝐞𝐫𝐞𝐝 𝐝𝐮𝐫𝐢𝐧𝐠 𝐭𝐡𝐞 𝐥𝐚𝐬𝐭 𝐟𝐢𝐯𝐞 𝐲𝐞𝐚𝐫𝐬) * 100</HelpButton>
            </div>
            <div className="c13x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus133(!responseButtonStatus133);
                  onClickingViewResponse133();
                }}
                className="c13x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus133 ? (
                <p className="c13x-responseResult-style">{responseValue133}</p>
              ) : null}
            </div>
          </div>
          <div className="c13xx-container">
            <h1 className="c13xx-Heading-style">
              <span className="c13xx-span-style">1.3.3.1: </span>
              Number of programmes that have components of field projects/research projects/internships (without repeat count) during last five years            <input></input>
            </h1>
           
            <h1 className="c13xx-Heading-style">
              <span className="c13xx-span-style">1.3.3.2: </span>
              Number of programmes offered (without repeat count) during last five years     
                     <input></input>
            </h1>

            

            <table className="c13x-table-style">
              <tr>
                <th className="c13x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c13x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c13x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c13x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Institutional data in the prescribed format (data template)</td>
                <td></td>
                <td>
                  <a href={downloadFile(value1331f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Program and course contents having element of field projects / research projects / internships as approved by BOS</td>
                <td>
                <a href={downloadFile("un1.3.3.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <a href={downloadFile(value1331f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Sample Internship completion letter provided by host institutions</td>
                <td>
                <a href={downloadFile("un1.3.3.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <a href={downloadFile(value1331f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Sample Evaluated project report/field work report submitted by the students</td>
                <td>
                <a href={downloadFile("un1.3.3.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <a href={downloadFile(value1331f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 1.3.4 */}
      {/* <div className="c13x-eachInputField-container">
        <div className="c13x-weightage-container">
          <h1 className="c13x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c13x-container">
            <div className="c13x-heading_Help-container">
              <h1 className="c13x-heading-style">
                <span className="c13x-span-style">1.3.4: </span>
                Percentage of students undertaking field projects/ internships /
                student projects (Data for the latest completed academic year).
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp134Status(true);
                }}
                className="c13x-helpButton-style"
              >
                Help
              </button>
              <Help134
                isHelp134Clicked={help134Status}
                setIsHelp134Clicked={setHelp134Status}
              />
            </div>
            <div className="c13x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus134(!responseButtonStatus134);
                  onClickingViewResponse134();
                }}
                className="c13x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus134 ? (
                <p className="c13x-responseResult-style">{responseValue134}</p>
              ) : null}
            </div>
          </div>
          <div className="c13xx-container">
            <h1 className="c13xx-Heading-style">
              <span className="c13xx-span-style">1.3.4.1: </span>
              Number of students undertaking field projects / internships /
              student projects
            </h1>
            <input
              readOnly
              onChange={(e) => setValue134t1(e.target.value)}
              id="134-t1"
              style={{ marginLeft: "4%" }}
              type="text"
              vaue={value134t1}
            />
            <h1 className="c13xx-Heading-style">
              <span className="c13xx-span-style">1.3.4.1: </span>
              Total number of students
            </h1>
            <input
              readOnly
              onChange={(e) => setValue1341t1(e.target.value)}
              id="1341-t1"
              style={{ marginLeft: "4%" }}
              type="text"
              value={value1341t1}
            />
            <table className="c13x-table-style">
              <tr>
                <th className="c13x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c13x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c13x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c13x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information </td>
                <td></td>
                <td>
                  <a href={downloadFile(value1341f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List of programs and number of students undertaking field
                  projects / internships / student projects (Data Template)
                </td>
                <td>
                  <a
                    target="_blank"
                    href="http://localhost:8080/api/v1/download/criteria1.3.4.xlsx"
                  >
                    View Template
                  </a>
                </td>
                <td>
                  <a href={downloadFile(value1341f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div> */}
    </div>
  );
}

export default Criteria13;
