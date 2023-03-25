import React, { useState, useEffect } from "react";
import "./c41-style.css";
import AuthService from "../../../../../Pages/Users/services/auth.service";

import { HelpButton } from "../../../../../../reusableComponents/model/Help";
import { resources } from "../../../../../appConstants";

// Help buttons functionality
function Help411(props) {
  return props.isHelp411Clicked ? (
    <div className="c41x-help-mainContainer">
      <div className="c41x-help-subContainer">
        <h1 className="c41x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c41x-help-para-style">
          Describe the adequacy of facilities for teaching –learning as per the
          minimum specified requirement by statutory bodies within a maximum of
          500 words
        </p>
        <button
          className="c41x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp411Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help412(props) {
  return props.isHelp412Clicked ? (
    <div className="c41x-help-mainContainer">
      <div className="c41x-help-subContainer">
        <h1 className="c41x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c41x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span>
          Describe the adequacy facilities for cultural activities, yoga, games
          (indoor, outdoor) and sports which include specification about
          area/size, year of establishment and user rate within minimum of 500
          characters and maximum of 500 words
        </p>
        <button
          className="c41x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp412Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help413(props) {
  return props.isHelp413Clicked ? (
    <div className="c41x-help-mainContainer">
      <div className="c41x-help-subContainer">
        <h1 className="c41x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c41x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span>Number of
          classrooms/seminor halls with ICT facilities
          <span style={{ fontWeight: "bold" }}> / </span>Total number of
          classrooms/seminor halls in the institution
          <span style={{ fontWeight: "bold" }}>) * </span>100
        </p>
        <button
          className="c41x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp413Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help414(props) {
  return props.isHelp414Clicked ? (
    <div className="c41x-help-mainContainer">
      <div className="c41x-help-subContainer">
        <h1 className="c41x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c41x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span>Expenditure for
          infrastructure augmentation, excluding salary
          <span style={{ fontWeight: "bold" }}> / </span>Total expenditure
          excluding salary
          <span style={{ fontWeight: "bold" }}>) * </span>100
        </p>
        <p className="c24x-help-para-style">
          Average percentage
          <span style={{ fontWeight: "bold" }}>=(</span> ΣPercentage per year
          <span style={{ fontWeight: "bold" }}>) /</span> 5
        </p>
        <button
          className="c41x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp414Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Physical Facilities

function Criteria41() {
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
  const [value411t1, setValue411t1] = useState();
  const [value411f1, setValue411f1] = useState("");
  const [pathValue411f1, setPathValue411f1] = useState("");
  const [value411f2, setValue411f2] = useState("");
  const [pathValue411f2, setPathValue411f2] = useState("");

  const [responseValue411, setResponseValue411] = useState("");
  const [help411Status, setHelp411Status] = useState(false);

  const [value412t1, setValue412t1] = useState();
  const [value412f1, setValue412f1] = useState("");
  const [pathValue412f1, setPathValue412f1] = useState("");
  const [value412f2, setValue412f2] = useState("");
  const [pathValue412f2, setPathValue412f2] = useState("");
  const [value412f3, setValue412f3] = useState("");
  const [pathValue412f3, setPathValue412f3] = useState("");

  const [responseValue412, setResponseValue412] = useState("");
  const [help412Status, setHelp412Status] = useState(false);

  const [value4131t1, setValue4131t1] = useState();
  const [value4131t2, setValue4131t2] = useState();
  const [value4131f1, setValue4131f1] = useState("");
  const [pathValue4131f1, setPathValue4131f1] = useState("");
  const [value4131f2, setValue4131f2] = useState("");
  const [pathValue4131f2, setPathValue4131f2] = useState("");
  const [value4131f3, setValue4131f3] = useState("");
  const [pathValue4131f3, setPathValue4131f3] = useState("");

  const [responseButtonStatus413, setResponseButtonStatus413] = useState(false);
  const [responseValue413, setResponseValue413] = useState("");
  const [help413Status, setHelp413Status] = useState(false);

  const [value4141t1, setValue4141t1] = useState();
  const [value4141t2, setValue4141t2] = useState();
  const [value4141t3, setValue4141t3] = useState();
  const [value4141t4, setValue4141t4] = useState();
  const [value4141t5, setValue4141t5] = useState();
  const [value4141t6, setValue4141t6] = useState();
  const [value4141t7, setValue4141t7] = useState();
  const [value4141t8, setValue4141t8] = useState();
  const [value4141t9, setValue4141t9] = useState();
  const [value4141t10, setValue4141t10] = useState();

  const [value4141t11, setValue4141t11] = useState();
  const [value4141t12, setValue4141t12] = useState();
  const [value4141t13, setValue4141t13] = useState();
  const [value4141t14, setValue4141t14] = useState();
  const [value4141t15, setValue4141t15] = useState();
  const [value4141t16, setValue4141t16] = useState();
  const [value4141t17, setValue4141t17] = useState();
  const [value4141t18, setValue4141t18] = useState();
  const [value4141t19, setValue4141t19] = useState();
  const [value4141t20, setValue4141t20] = useState();

  const [value4141f1, setValue4141f1] = useState("");
  const [pathValue4141f1, setPathValue4141f1] = useState("");
  const [value4141f2, setValue4141f2] = useState("");
  const [pathValue4141f2, setPathValue4141f2] = useState("");
  const [value4141f3, setValue4141f3] = useState("");
  const [pathValue4141f3, setPathValue4141f3] = useState("");
  const [responseButtonStatus414, setResponseButtonStatus414] = useState(false);
  const [responseValue414, setResponseValue414] = useState("");
  const [help414Status, setHelp414Status] = useState(false);

  // response button functionality
  function onClickingViewResponse413() {
    if (value4131t1 === "" || value4131t2 === "") {
      setResponseValue413("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value4131t1, 10)) === false ||
      Number.isInteger(parseInt(value4131t2, 10)) === false
    ) {
      setResponseValue413("Input should be an Integer");
    } else if (value4131t1 !== "" && value4131t2 !== "") {
      setResponseValue413(
        (parseInt(value4131t1, 10) / parseInt(value4131t2, 10)) * 100
      );
    }
  }

  function onClickingViewResponse414() {
    if (
      value4141t6 === "" ||
      value4141t7 === "" ||
      value4141t8 === "" ||
      value4141t9 === "" ||
      value4141t10 === "" ||
      value4141t16 === "" ||
      value4141t17 === "" ||
      value4141t18 === "" ||
      value4141t19 === "" ||
      value4141t20 === "" ||
      value4141t6 === undefined ||
      value4141t7 === undefined ||
      value4141t8 === undefined ||
      value4141t9 === undefined ||
      value4141t10 === undefined ||
      value4141t16 === undefined ||
      value4141t17 === undefined ||
      value4141t18 === undefined ||
      value4141t19 === undefined ||
      value4141t20 === undefined
    ) {
      setResponseValue414("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value4141t6, 10)) === false ||
      Number.isInteger(parseInt(value4141t7, 10)) === false ||
      Number.isInteger(parseInt(value4141t8, 10)) === false ||
      Number.isInteger(parseInt(value4141t9, 10)) === false ||
      Number.isInteger(parseInt(value4141t10, 10)) === false ||
      Number.isInteger(parseInt(value4141t16, 10)) === false ||
      Number.isInteger(parseInt(value4141t17, 10)) === false ||
      Number.isInteger(parseInt(value4141t18, 10)) === false ||
      Number.isInteger(parseInt(value4141t19, 10)) === false ||
      Number.isInteger(parseInt(value4141t20, 10)) === false
    ) {
      setResponseValue414("Input should be an Integer");
    } else if (
      value4141t6 !== "" &&
      value4141t7 !== "" &&
      value4141t8 !== "" &&
      value4141t9 !== "" &&
      value4141t10 !== "" &&
      value4141t16 !== "" &&
      value4141t17 !== "" &&
      value4141t18 !== "" &&
      value4141t19 !== "" &&
      value4141t20 !== ""
    ) {
      setResponseValue414(
        ((value4141t6 / value4141t16) * 100 +
          (value4141t7 / value4141t17) * 100 +
          (value4141t8 / value4141t18) * 100 +
          (value4141t9 / value4141t19) * 100 +
          (value4141t10 / value4141t20) * 100) /
          5
      );
    }
  }

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
  


  const financialYear = "2021-2022";
  function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
  }

  // sending data to db with API

  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria4getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            setValue411t1(data[0].criteria41Ql[0] ? data[0].criteria41Ql[0].input411t1 : "");
            setValue412t1(data[0].criteria41Ql[0] ? data[0].criteria41Ql[0].input412t1 : "");
            setValue4131t1(data[0].criteria41Ql[0] ? data[0].criteria41Ql[0].input413t1 : "");
            // setValue4131t1(data[0].criteria41Ql[0].input4131t2);

            setValue4141t1(data[0].yearTable4141[0] ? data[0].yearTable4141[0].input4141y : "");
            setValue4141t2(data[0].yearTable4141[1] ? data[0].yearTable4141[1].input4141y : "");
            setValue4141t3(data[0].yearTable4141[2] ? data[0].yearTable4141[2].input4141y : "");
            setValue4141t4(data[0].yearTable4141[3] ? data[0].yearTable4141[3].input4141y : "");
            setValue4141t5(data[0].yearTable4141[4] ? data[0].yearTable4141[4].input4141y : "");
            setValue4141t6(data[0].yearTable4141[0] ? data[0].yearTable4141[0].input4141v : "");
            setValue4141t7(data[0].yearTable4141[1] ? data[0].yearTable4141[1].input4141v : "");
            setValue4141t8(data[0].yearTable4141[2] ? data[0].yearTable4141[2].input4141v : "");
            setValue4141t9(data[0].yearTable4141[3] ? data[0].yearTable4141[3].input4141v : "");
            setValue4141t10(data[0].yearTable4141[4] ? data[0].yearTable4141[4].input4141v : "");

            setValue4141t11(data[0].yearTable41412[0] ? data[0].yearTable41412[0].input41412y : "");
            setValue4141t12(data[0].yearTable41412[1] ? data[0].yearTable41412[1].input41412y : "");
            setValue4141t13(data[0].yearTable41412[2] ? data[0].yearTable41412[2].input41412y : "");
            setValue4141t14(data[0].yearTable41412[3] ? data[0].yearTable41412[3].input41412y : "");
            setValue4141t15(data[0].yearTable41412[4] ? data[0].yearTable41412[4].input41412y : "");
            setValue4141t16(data[0].yearTable41412[0] ? data[0].yearTable41412[0].input41412v : "");
            setValue4141t17(data[0].yearTable41412[1] ? data[0].yearTable41412[1].input41412v : "");
            setValue4141t18(data[0].yearTable41412[2] ? data[0].yearTable41412[2].input41412v : "");
            setValue4141t19(data[0].yearTable41412[3] ? data[0].yearTable41412[3].input41412v : "");
            setValue4141t20(data[0].yearTable41412[4] ? data[0].yearTable41412[4].input41412v : "");

            setValue411f1(data[0].criteria4FileUpload[0] ? data[0].criteria4FileUpload[0].criteria4FileName : "");
            setValue411f2(data[0].criteria4FileUpload[1] ? data[0].criteria4FileUpload[1].criteria4FileName : "");
            setValue412f1(data[0].criteria4FileUpload[2] ? data[0].criteria4FileUpload[2].criteria4FileName : "");
            setValue412f2(data[0].criteria4FileUpload[3] ? data[0].criteria4FileUpload[3].criteria4FileName : "");
            setValue412f3(data[0].criteria4FileUpload[4] ? data[0].criteria4FileUpload[4].criteria4FileName : "");
            setValue4131f1(data[0].criteria4FileUpload[5] ? data[0].criteria4FileUpload[5].criteria4FileName : "");
            setValue4131f2(data[0].criteria4FileUpload[6] ? data[0].criteria4FileUpload[6].criteria4FileName : "");
            setValue4131f3(data[0].criteria4FileUpload[7] ? data[0].criteria4FileUpload[7].criteria4FileName : "");
            setValue4141f1(data[0].criteria4FileUpload[8] ? data[0].criteria4FileUpload[8].criteria4FileName : "");
            setValue4141f2(data[0].criteria4FileUpload[9] ? data[0].criteria4FileUpload[9].criteria4FileName : "");
            setValue4141f3(data[0].criteria4FileUpload[10] ? data[0].criteria4FileUpload[10].criteria4FileName : "");
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );

  // sending data to db with API

  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    criteria41Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input411t1: value411t1,
        response411: responseValue411,
        input412t1: value412t1,
        response412: responseValue412,
        input413t1: value4131t1,
        response413: responseValue413,
      },
    ],

    yearTable4141: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input4141y: value4141t1,
        input4141v: value4141t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input4141y: value4141t2,
        input4141v: value4141t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input4141y: value4141t3,
        input4141v: value4141t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input4141y: value4141t4,
        input4141v: value4141t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input4141y: value4141t5,
        input4141v: value4141t10,
      },
    ],
    yearTable41412: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input41412y: value4141t11,
        input41412v: value4141t16,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input41412y: value4141t12,
        input41412v: value4141t17,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input41412y: value4141t13,
        input41412v: value4141t18,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input41412y: value4141t14,
        input41412v: value4141t19,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input41412y: value4141t15,
        input41412v: value4141t20,
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
    <div className="c41-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c41x-colorIndicator-container">
        <p className="c41x-QlcolorIndicator-circle-style"></p>
        <span className="c41x-colorIndicator-span-style">Qualitative</span>
        <p className="c41x-QtcolorIndicator-circle-style"></p>
        <span className="c41x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c41x-weightage-heading-style">
            Key Indicator Weightage: 30
          </h1>
        </div>
      </div>

      {/* Key Indicator: 4.1.1 */}
      <div className="c41x-eachInputField-container">
        <div className="c41x-weightage-container">
          <h1 className="c41x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c41x-Ql-label-textarea-container">
            <div className="c41x-heading_Help-container">
              <h1 className="c41x-heading-style">
                <span className="c41x-span-style">4.1.1: </span>
                The institution has adequate infrastructure facilities for<br/>
a. teaching - learning. viz., classrooms, laboratories,<br/>
b. ICT enabled facilities such as smart classes, LMS etc.<br/>
c. Facilities for cultural and sports activities , yoga centre, games (indoor and outdoor) gymnasium, auditorium etc.
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
            <label htmlFor="411-t1" className="c41x-label-style">
              Response:
            </label>
            <textarea
              readOnly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue411t1(e.target.value);
                setResponseValue411(e.target.value);
              }}
              value={value411t1}
              rows={10}
              className="c41x-textarea-style"
              id="411-t1"
            ></textarea>
            {value411t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c41x-Ql-table-style">
            <tr>
              <th className="c41x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c41x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c41x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c41x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c41x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c41x-Ql-tableBorders-style"></td>
              <td className="c41x-Ql-tableBorders-style">
                <a href={downloadFile(value411f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c41x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
                <a href={downloadFile(value411f2)} target="_blank">
                  view
                </a>
              </td>
              <td className="c41x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 4.1.2 */}
      {/* <div className="c41x-eachInputField-container">
        <div className="c41x-weightage-container">
          <h1 className="c41x-weightage-heading-style">Weightage: 4</h1>
        </div>
        <form>
          <div className="c41x-Ql-label-textarea-container">
            <div className="c41x-heading_Help-container">
              <h1 className="c41x-heading-style">
                <span className="c41x-span-style">4.1.2: </span>
                The institution has adequate facilities for cultural activities,
                yoga, games and sports (indoor & outdoor); (gymnasium, yoga
                centre, auditorium, etc.,)
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp412Status(true);
                }}
                className="c41x-helpButton-style"
              >
                Help
              </button>
              <Help412
                isHelp412Clicked={help412Status}
                setIsHelp412Clicked={setHelp412Status}
              />
            </div>
            <label htmlFor="412-t1" className="c41x-label-style">
              Response:
            </label>
            <textarea
              readOnly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue412t1(e.target.value);
                setResponseValue412(e.target.value);
              }}
              value={value412t1}
              rows={10}
              className="c41x-textarea-style"
              id="412-t1"
            ></textarea>
            {value412t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c41x-Ql-table-style">
            <tr>
              <th className="c41x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c41x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c41x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c41x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c41x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c41x-Ql-tableBorders-style"></td>
              <td className="c41x-Ql-tableBorders-style">
                <a href={downloadFile(value412f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c41x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Geotagged pictures</td>
              <td></td>
              <td>
                <a href={downloadFile(value412f2)} target="_blank">
                  view
                </a>
              </td>
              <td className="c41x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
                <a href={downloadFile(value412f3)} target="_blank">
                  view
                </a>
              </td>
              <td className="c41x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div> */}

      {/* Key Indicator: 4.1.3 */}
      {/* <div className="c41x-eachInputField-container">
        <div className="c41x-weightage-container">
          <h1 className="c41x-weightage-heading-style">Weightage: 4</h1>
        </div>
        <form>
          <div className="c41x-Ql-label-textarea-container">
            <div className="c41x-heading_Help-container">
              <h1 className="c41x-heading-style">
                <span className="c41x-span-style">4.1.3: </span>
                Availability of general campus facilities and overall ambience
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp413Status(true);
                }}
                className="c41x-helpButton-style"
              >
                Help
              </button>
              <Help413
                isHelp413Clicked={help413Status}
                setIsHelp413Clicked={setHelp413Status}
              />
            </div>
            <label htmlFor="4131-t1" className="c41x-label-style">
              Response:
            </label>
            <textarea
              readOnly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue4131t1(e.target.value);
                setResponseValue413(e.target.value);
              }}
              value={value4131t1}
              rows={10}
              className="c41x-textarea-style"
              id="4131-t1"
            ></textarea>
            {value4131t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c41x-Ql-table-style">
            <tr>
              <th className="c41x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c41x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c41x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c41x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c41x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c41x-Ql-tableBorders-style"></td>
              <td className="c41x-Ql-tableBorders-style">
                <input
                  readOnly
                  onChange={(e) => {
                    setValue4131f1(e.target.files[0]);
                    setPathValue4131f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="4131-f1"
                  type="file"
                  className="c41-fileButton-style"
                />
                {pathValue4131f1 === "" ? null : (
                  <div className="c41-fileButtons-container">
                    <button className="c41-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue4131f1("");
                        document.getElementById("4131-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
              </td>
              <td className="c41x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Provide the link for additional information</td>
              <td></td>
              <td>
                <input
                  readOnly
                  onChange={(e) => {
                    setValue4131f2(e.target.files[0]);
                    setPathValue4131f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="4131-f2"
                  type="file"
                  className="c41-fileButton-style"
                />
                {pathValue4131f2 === "" ? null : (
                  <div className="c41-fileButtons-container">
                    <button className="c41-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue4131f2("");
                        document.getElementById("4131-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
              </td>
              <td className="c41x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
                <input
                  readOnly
                  onChange={(e) => {
                    setValue4131f3(e.target.files[0]);
                    setPathValue4131f3(e.target.value);
                    showFilePreview(e);
                  }}
                  id="4131-f3"
                  type="file"
                  className="c41-fileButton-style"
                />
                {pathValue4131f3 === "" ? null : (
                  <div className="c41-fileButtons-container">
                    <button className="c41-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue4131f3("");
                        document.getElementById("4131-f3").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
              </td>
              <td className="c41x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div> */}

      {/* Key Indicator: 4.1.4 */}
      <div className="c41x-eachInputField-container">
        <div className="c41x-weightage-container">
          <h1 className="c41x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c41x-container">
            <div className="c41x-heading_Help-container">
              <h1 className="c41x-heading-style">
                <span className="c41x-span-style">4.1.4: </span>
                Percentage of expenditure excluding salary, for infrastructure development and augmentation during the last five years (INR in Lakhs)
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
                title='formula'
                ><h1>(Total expenditure for purchase of books,ebooks and subscriptions) / (3.1 Total expenditure excluding salary ) * 100</h1></HelpButton>
            </div>
            <div className="c41x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus414(!responseButtonStatus414);
                  onClickingViewResponse414();
                }}
                className="c41x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus414 ? (
                <p className="c41x-responseResult-style">{responseValue414}</p>
              ) : null}
            </div>
          </div>
          <div className="c41xx-container">
            <h1 className="c41xx-Heading-style">
              <span className="c41xx-span-style">4.1.4.1: </span>
              Expenditure for infrastructure augmentation, excluding salary
              year-wise during last five years (INR in lakhs)
            </h1>

            <table className="c41x-Qt-table-style">
              <tr>
                <th className="c41x-horizontalTable-heading-style">Year</th>
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
                      onChange={(e) => setValue4141t1(e.target.value)}
                      id="4141-t1"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t1}
                    />
                    {value4141t1 === "" ? (
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
                      onChange={(e) => setValue4141t2(e.target.value)}
                      id="4141-t2"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t2}
                    />
                    {value4141t2 === "" ? (
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
                      onChange={(e) => setValue4141t3(e.target.value)}
                      id="4141-t3"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t3}
                    />
                    {value4141t3 === "" ? (
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
                      onChange={(e) => setValue4141t4(e.target.value)}
                      id="4141-t4"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t4}
                    />
                    {value4141t4 === "" ? (
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
                      onChange={(e) => setValue4141t5(e.target.value)}
                      id="4141-t5"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t5}
                    />
                    {value4141t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c41x-horizontalTable-heading-style">
                  INR in lakhs
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
                        setValue4141t6(e.target.value);
                        onClickingViewResponse414();
                      }}
                      id="4141-t6"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t6}
                    />
                    {value4141t6 === "" ? (
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
                        setValue4141t7(e.target.value);
                        onClickingViewResponse414();
                      }}
                      id="4141-t7"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t7}
                    />
                    {value4141t7 === "" ? (
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
                        setValue4141t8(e.target.value);
                        onClickingViewResponse414();
                      }}
                      id="4141-t8"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t8}
                    />
                    {value4141t8 === "" ? (
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
                        setValue4141t9(e.target.value);
                        onClickingViewResponse414();
                      }}
                      id="4141-t9"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t9}
                    />
                    {value4141t9 === "" ? (
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
                        setValue4141t10(e.target.value);
                        onClickingViewResponse414();
                      }}
                      id="4141-t10"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t10}
                    />
                    {value4141t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
{/* 
            <table className="c41x-Qt-table-style">
              <tr>
                <th className="c41x-horizontalTable-heading-style">Year</th>
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
                      onChange={(e) => setValue4141t11(e.target.value)}
                      id="4141-t11"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t11}
                    />
                    {value4141t11 === "" ? (
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
                      onChange={(e) => setValue4141t12(e.target.value)}
                      id="4141-t12"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t12}
                    />
                    {value4141t12 === "" ? (
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
                      onChange={(e) => setValue4141t13(e.target.value)}
                      id="4141-t13"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t13}
                    />
                    {value4141t13 === "" ? (
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
                      onChange={(e) => setValue4141t14(e.target.value)}
                      id="4141-t14"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t14}
                    />
                    {value4141t14 === "" ? (
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
                      onChange={(e) => setValue4141t15(e.target.value)}
                      id="4141-t15"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t15}
                    />
                    {value4141t15 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c41x-horizontalTable-heading-style">
                  INR in lakhs
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
                        setValue4141t16(e.target.value);
                        onClickingViewResponse414();
                      }}
                      id="4141-t16"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t16}
                    />
                    {value4141t16 === "" ? (
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
                        setValue4141t17(e.target.value);
                        onClickingViewResponse414();
                      }}
                      id="4141-t17"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t17}
                    />
                    {value4141t17 === "" ? (
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
                        setValue4141t18(e.target.value);
                        onClickingViewResponse414();
                      }}
                      id="4141-t18"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t18}
                    />
                    {value4141t18 === "" ? (
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
                        setValue4141t19(e.target.value);
                        onClickingViewResponse414();
                      }}
                      id="4141-t19"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t19}
                    />
                    {value4141t19 === "" ? (
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
                        setValue4141t20(e.target.value);
                        onClickingViewResponse414();
                      }}
                      id="4141-t20"
                      className="c41x-input-style"
                      type="text"
                      value={value4141t20}
                    />
                    {value4141t20 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> */}

            <table className="c41x-table-style">
              <tr>
                <th className="c41x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c41x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c41x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c41x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <a href={downloadFile(value4141f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c41x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload audited utilization statements</td>
                <td></td>
                <td>
                  <a href={downloadFile(value4141f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c41x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Upload Details of Expenditure, excluding salary during the
                  last five years
                </td>
                <td>
                <a href={downloadFile("un4.1.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <a href={downloadFile(value4141f3)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c41x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Criteria41;
