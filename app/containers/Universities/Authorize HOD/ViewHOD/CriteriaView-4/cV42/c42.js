import React, { useState, useEffect } from "react";
import "./c42-style.css";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
import { resources } from "../../../../../appConstants";
function Help421(props) {
  return props.isHelp421Clicked ? (
    <div className="c42x-help-mainContainer">
      <div className="c42x-help-subContainer">
        <h1 className="c42x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c42x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c42x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp421Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help422(props) {
  return props.isHelp422Clicked ? (
    <div className="c42x-help-mainContainer">
      <div className="c42x-help-subContainer">
        <h1 className="c42x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c42x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c42x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp422Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help423(props) {
  return props.isHelp423Clicked ? (
    <div className="c42x-help-mainContainer">
      <div className="c42x-help-subContainer">
        <h1 className="c42x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c42x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c42x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp423Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help424(props) {
  return props.isHelp424Clicked ? (
    <div className="c42x-help-mainContainer">
      <div className="c42x-help-subContainer">
        <h1 className="c42x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c42x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c42x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp424Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Criteria42() {
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
  const [value421t1, setValue421t1] = useState();
  const [value421f1, setValue421f1] = useState("");
  const [pathValue421f1, setPathValue421f1] = useState("");
  const [value421f2, setValue421f2] = useState("");
  const [pathValue421f2, setPathValue421f2] = useState("");

  const [responseValue421, setResponseValue421] = useState("");
  const [help421Status, setHelp421Status] = useState(false);

  const [value422t1, setValue422t1] = useState();
  const [value422f1, setValue422f1] = useState("");
  const [pathValue422f1, setPathValue422f1] = useState("");
  const [value422f2, setValue422f2] = useState("");
  const [pathValue422f2, setPathValue422f2] = useState("");
  const [responseButtonStatus422, setResponseButtonStatus422] = useState(false);
  const [responseValue422, setResponseValue422] = useState("");
  const [help422Status, setHelp422Status] = useState(false);

  const [value4231t1, setValue4231t1] = useState();
  const [value4231t2, setValue4231t2] = useState();
  const [value4231t3, setValue4231t3] = useState();
  const [value4231t4, setValue4231t4] = useState();
  const [value4231t5, setValue4231t5] = useState();
  const [value4231t6, setValue4231t6] = useState();
  const [value4231t7, setValue4231t7] = useState();
  const [value4231t8, setValue4231t8] = useState();
  const [value4231t9, setValue4231t9] = useState();
  const [value4231t10, setValue4231t10] = useState();
  const [value4231f1, setValue4231f1] = useState("");
  const [pathValue4231f1, setPathValue4231f1] = useState("");
  const [value4231f2, setValue4231f2] = useState("");
  const [pathValue4231f2, setPathValue4231f2] = useState("");
  const [value4231f3, setValue4231f3] = useState("");
  const [pathValue4231f3, setPathValue4231f3] = useState("");
  const [responseButtonStatus423, setResponseButtonStatus423] = useState(false);
  const [responseValue423, setResponseValue423] = useState("");
  const [help423Status, setHelp423Status] = useState(false);

  const [value4241t1, setValue4241t1] = useState();
  const [value4241t2, setValue4241t2] = useState();
  const [value4241f1, setValue4241f1] = useState("");
  const [pathValue4241f1, setPathValue4241f1] = useState("");
  const [value4241f2, setValue4241f2] = useState("");
  const [pathValue4241f2, setPathValue4241f2] = useState("");
  const [responseButtonStatus424, setResponseButtonStatus424] = useState(false);
  const [responseValue424, setResponseValue424] = useState("");
  const [help424Status, setHelp424Status] = useState(false);


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
        resources.APPLICATION_URL+'criteria4getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            setValue421t1(data[0].criteria42Ql[0] ? data[0].criteria42Ql[0].input421t1 : "");
            setValue422t1(data[0].criteria42Qn[0] ? data[0].criteria42Qn[0].input422t1 : "");
            setValue4241t1(data[0].criteria42Qn[0] ? data[0].criteria42Qn[0].input4241t1 : "");
            setValue4241t2(data[0].criteria42Qn[0] ? data[0].criteria42Qn[0].input4241t2 : "");

            setValue4231t1(data[0].criteria42Qn[0] ? data[0].criteria42Qn[0].input4231y : "");
            setValue4231t2(data[0].yearTable4231[1] ? data[0].criteria42Qn[1].input4231y : "");
            setValue4231t3(data[0].yearTable4231[2] ? data[0].criteria42Qn[2].input4231y : "");
            setValue4231t4(data[0].yearTable4231[3] ? data[0].criteria42Qn[3].input4231y : "");
            setValue4231t5(data[0].yearTable4231[4] ? data[0].criteria42Qn[4].input4231y : "");
            setValue4231t6(data[0].yearTable4231[0] ? data[0].criteria42Qn[0].input4231v : "");
            setValue4231t7(data[0].yearTable4231[1] ? data[0].criteria42Qn[1].input4231v : "");
            setValue4231t8(data[0].yearTable4231[2] ? data[0].criteria42Qn[2].input4231v : "");
            setValue4231t9(data[0].yearTable4231[3] ? data[0].criteria42Qn[3].input4231v : "");
            setValue4231t10(data[0].yearTable4231[4] ? data[0].criteria42Qn[4].input4231v : "");

            setValue421f1(data[0].criteria4FileUpload[0] ? data[0].criteria4FileUpload[0].criteria4FileName : "");
            setValue421f2(data[0].criteria4FileUpload[1] ? data[0].criteria4FileUpload[1].criteria4FileName : "");
            setValue422f1(data[0].criteria4FileUpload[2] ? data[0].criteria4FileUpload[2].criteria4FileName : "");
            setValue422f2(data[0].criteria4FileUpload[3] ? data[0].criteria4FileUpload[3].criteria4FileName : "");
            setValue4231f1(data[0].criteria4FileUpload[4] ? data[0].criteria4FileUpload[4].criteria4FileName : "");
            setValue4231f2(data[0].criteria4FileUpload[5] ? data[0].criteria4FileUpload[5].criteria4FileName : "");
            setValue4231f3(data[0].criteria4FileUpload[6] ? data[0].criteria4FileUpload[6].criteria4FileName : "");
            setValue4241f1(data[0].criteria4FileUpload[7] ? data[0].criteria4FileUpload[7].criteria4FileName : "");
            setValue4241f2(data[0].criteria4FileUpload[8] ? data[0].criteria4FileUpload[8].criteria4FileName : "");
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );

  function onClickingViewResponse422(e) {
    if (value422t1 === "") {
      setResponseValue422("Please select any option");
    } else {
      setResponseValue422(e.target.value);
    }
  }
  function onClickingViewResponse423(e) {
    if (
      value4231t6 === "" ||
      value4231t7 === "" ||
      value4231t8 === "" ||
      value4231t9 === "" ||
      value4231t10 === "" ||
      value4231t6 === undefined ||
      value4231t7 === undefined ||
      value4231t8 === undefined ||
      value4231t9 === undefined ||
      value4231t10 === undefined
    ) {
      setResponseValue423("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value4231t6, 10)) === false ||
      Number.isInteger(parseInt(value4231t7, 10)) === false ||
      Number.isInteger(parseInt(value4231t8, 10)) === false ||
      Number.isInteger(parseInt(value4231t9, 10)) === false ||
      Number.isInteger(parseInt(value4231t10, 10)) === false
    ) {
      setResponseValue423("Input should be an Integer");
    } else if (
      value4231t6 !== "" &&
      value4231t7 !== "" &&
      value4231t8 !== "" &&
      value4231t9 !== "" &&
      value4231t10 !== ""
    ) {
      setResponseValue423(
        parseInt(value4231t6, 10) +
          parseInt(value4231t7, 10) +
          parseInt(value4231t8, 10) +
          parseInt(value4231t9, 10) +
          parseInt(value4231t10, 10)
      );
    }
  }
  function onClickingViewResponse424() {
    if (value4241t1 === "" || value4241t2 === "") {
      setResponseValue424("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value4241t1, 10)) === false ||
      Number.isInteger(parseInt(value4241t2, 10)) === false
    ) {
      setResponseValue424("Input should be an Integer");
    } else if (value4241t1 !== "" && value4241t2 !== "") {
      setResponseValue423(
        parseInt(value4241t1, 10) + parseInt(value4241t2, 10)
      );
    }
  }

  // sending data to db with API

  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    criteria42Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input421t1: value421t1,
        response421: responseValue421,
      },
    ],
    criteria42Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input422t1: value422t1,
        response422: responseValue422,
        input4241t1: value4241t1,
        input4241t2: value4241t2,
        response424: responseValue424,
      },
    ],
    yearTable4231: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input4231y: value4231t1,
        input4231v: value4231t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input4231y: value4231t2,
        input4231v: value4231t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input4231y: value4231t3,
        input4231v: value4231t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input4231y: value4231t4,
        input4231v: value4231t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input4231y: value4231t5,
        input4231v: value4231t10,
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
    <div className="c42-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c42x-colorIndicator-container">
        <p className="c42x-QlcolorIndicator-circle-style"></p>
        <span className="c42x-colorIndicator-span-style">Qualitative</span>
        <p className="c42x-QtcolorIndicator-circle-style"></p>
        <span className="c42x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c42x-weightage-heading-style">
            Key Indicator Weightage: 20
          </h1>
        </div>
      </div>

      {/* Key Indicator: 4.2.1 */}
      <div className="c42x-eachInputField-container">
        <div className="c42x-weightage-container">
          <h1 className="c42x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c42x-Ql-label-textarea-container">
            <div className="c42x-heading_Help-container">
              <h1 className="c42x-heading-style">
                <span className="c42x-span-style">4.2.1: </span>
                Library is automated with digital facilities using Integrated Library Management System (ILMS), adequate subscription to e-resources and journals are made. The library is optimally used by the faculty and students
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
            <label htmlFor="421-t1" className="c42x-label-style">
              Response:
            </label>
            <textarea
              readOnly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue421t1(e.target.value);
                setResponseValue421(e.target.value);
              }}
              value={value421t1}
              rows={10}
              className="c42x-textarea-style"
              id="421-t1"
            ></textarea>
            {value421t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c42x-Ql-table-style">
            <tr>
              <th className="c42x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c42x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c42x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c42x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c42x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c42x-Ql-tableBorders-style"></td>
              <td className="c42x-Ql-tableBorders-style">
                <a href={downloadFile(value421f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c42x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
                <a href={downloadFile(value421f2)} target="_blank">
                  view
                </a>
              </td>
              <td className="c42x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 4.2.2 */}
      {/* <div className="c42x-eachInputField-container">
        <div className="c42x-weightage-container">
          <h1 className="c42x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c42x-container">
            <div className="c42x-heading_Help-container">
              <div>
                <h1 className="c42x-heading-style">
                  <span className="c42x-span-style">4.2.2: </span>
                  Institution has access to the following:
                </h1>
                <p className="c34x-para-style">
                  1. e-journals
                  <br />
                  2. e-ShodhSindhu
                  <br />
                  3. Shodhganga Membership
                  <br />
                  4. e-books
                  <br />
                  5. Databases
                  <br />
                  6. Remote access to e-resources
                </p>
                <div className="c42x-radio-container">
                  <div className="c42x-radio-subContainer">
                    <div className="c42x-eachRadio-container">
                      <input
                        readOnly
                        name="422options"
                        id="422-t1"
                        type="radio"
                        onChange={(e) => {
                          setValue422t1(e.target.value);
                        }}
                        value="All the four of the above"
                      />

                      <label className="c42x-radioLabel-style" for="422-t1">
                        All of the above
                      </label>
                    </div>

                    <div className="c42x-eachRadio-container">
                      <input
                        readOnly
                        name="422options"
                        id="422-t2"
                        type="radio"
                        onChange={(e) => {
                          setValue422t1(e.target.value);
                        }}
                        value="Any three of the above"
                      />

                      <label className="c42x-radioLabel-style" for="422-t2">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c42x-eachRadio-container">
                      <input
                        readOnly
                        name="422options"
                        id="422-t3"
                        type="radio"
                        onChange={(e) => {
                          setValue422t1(e.target.value);
                        }}
                        value="Any two of the above"
                      />

                      <label className="c42x-radioLabel-style" for="422-t3">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c42x-radio-subContainer">
                    <div className="c42x-eachRadio-container">
                      <input
                        readOnly
                        name="422options"
                        id="422-t4"
                        type="radio"
                        onChange={(e) => {
                          setValue422t1(e.target.value);
                        }}
                        value="Any one of the above"
                      />

                      <label className="c42x-radioLabel-style" for="422-t4">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c42x-eachRadio-container">
                      <input
                        readOnly
                        name="422options"
                        id="422-t5"
                        type="radio"
                        onChange={(e) => {
                          setValue422t1(e.target.value);
                        }}
                        value="None of the above"
                      />

                      <label className="c42x-radioLabel-style" for="422-t5">
                        None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp422Status(true);
                }}
                className="c42x-helpButton-style"
              >
                Help
              </button>
              <Help422
                isHelp422Clicked={help422Status}
                setIsHelp422Clicked={setHelp422Status}
              />
            </div>
            <div className="c42x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus422(!responseButtonStatus422);
                  onClickingViewResponse422();
                }}
                className="c42x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus422 ? (
                <p className="c42x-responseResult-style">{responseValue422}</p>
              ) : null}
            </div>
          </div>
          <table className="c42x-table-style">
            <tr>
              <th className="c42x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c42x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c42x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c42x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Upload any additional information</td>
              <td></td>
              <td>
                <a href={downloadFile(value422f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c42x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Details of subscriptions like e-journals, e-books ,
                e-ShodhSindhu, Shodhganga Membership etc
              </td>
              <td>
                {" "}
                <a href="http://localhost:8080/api/v1/download/criteria4.2.2&4.2.3.xlsx">
                  View Template
                </a>
              </td>
              <td>
                <a href={downloadFile(value422f2)} target="_blank">
                  view
                </a>
              </td>
              <td className="c42x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div> */}

      {/* Key Indicator: 4.2.3 */}
      <div className="c42x-eachInputField-container">
        <div className="c42x-weightage-container">
          <h1 className="c42x-weightage-heading-style">Weightage:5</h1>
        </div>
        <form>
          <div className="c42x-container">
            <div className="c42x-heading_Help-container">
              <h1 className="c42x-heading-style">
                <span className="c42x-span-style">4.2.3: </span>
                Percentage expenditure for purchase of books/ e-books and subscription to journals/e-journals during the last five years (INR in Lakhs)
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
                ><h1>(Total expenditure for purchase of books,ebooks and subscriptions) / ( 3.1 Total expenditure excluding salary ) * 100</h1></HelpButton>
            </div>
            <div className="c42x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus423(!responseButtonStatus423);
                  onClickingViewResponse423();
                }}
                className="c42x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus423 ? (
                <p className="c42x-responseResult-style">{responseValue423}</p>
              ) : null}
            </div>
          </div>
          <div className="c42xx-container">
            <h1 className="c42xx-Heading-style">
              <span className="c42xx-span-style">4.2.3.1: </span>
              Annual expenditure of purchase of books/e-books and subscription
              to journals/e- journals year wise during last five years (INR in
              Lakhs)
            </h1>

            <table className="c42x-Qt-table-style">
              <tr>
                <th className="c42x-horizontalTable-heading-style">Year</th>
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
                      onChange={(e) => setValue4231t1(e.target.value)}
                      id="4231-t1"
                      className="c42x-input-style"
                      type="text"
                      value={value4231t1}
                    />
                    {value4231t1 === "" ? (
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
                      onChange={(e) => setValue4231t2(e.target.value)}
                      id="4231-t2"
                      className="c42x-input-style"
                      type="text"
                      value={value4231t2}
                    />
                    {value4231t2 === "" ? (
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
                      onChange={(e) => setValue4231t3(e.target.value)}
                      id="4231-t3"
                      className="c42x-input-style"
                      type="text"
                      value={value4231t3}
                    />
                    {value4231t3 === "" ? (
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
                      onChange={(e) => setValue4231t4(e.target.value)}
                      id="4231-t4"
                      className="c42x-input-style"
                      type="text"
                      value={value4231t4}
                    />
                    {value4231t4 === "" ? (
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
                      onChange={(e) => setValue4231t5(e.target.value)}
                      id="4231-t5"
                      className="c42x-input-style"
                      type="text"
                      value={value4231t5}
                    />
                    {value4231t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c42x-horizontalTable-heading-style">
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
                        setValue4231t6(e.target.value);
                        onClickingViewResponse423();
                      }}
                      id="4231-t6"
                      className="c42x-input-style"
                      type="text"
                      value={value4231t6}
                    />
                    {value4231t6 === "" ? (
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
                        setValue4231t7(e.target.value);
                        onClickingViewResponse423();
                      }}
                      id="4231-t7"
                      className="c42x-input-style"
                      type="text"
                      value={value4231t7}
                    />
                    {value4231t7 === "" ? (
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
                        setValue4231t8(e.target.value);
                        onClickingViewResponse423();
                      }}
                      id="4231-t8"
                      className="c42x-input-style"
                      type="text"
                      value={value4231t8}
                    />
                    {value4231t8 === "" ? (
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
                        setValue4231t9(e.target.value);
                        onClickingViewResponse423();
                      }}
                      id="4231-t9"
                      className="c42x-input-style"
                      type="text"
                      value={value4231t9}
                    />
                    {value4231t9 === "" ? (
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
                        setValue4231t10(e.target.value);
                        onClickingViewResponse423();
                      }}
                      id="4231-t10"
                      className="c42x-input-style"
                      type="text"
                      value={value4231t10}
                    />
                    {value4231t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c42x-table-style">
              <tr>
                <th className="c42x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c42x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c42x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c42x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <a href={downloadFile(value4231f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c42x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Audited statements of accounts </td>
                <td></td>
                <td>
                  <a href={downloadFile(value4231f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c42x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Details of annual expenditure for purchase of and subscription
                  to journals/e-journals during the last five years(Data
                  Template)
                </td>
                <td>
                <a href={downloadFile("au4.2.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <a href={downloadFile(value4231f3)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c42x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 4.2.4 */}
      {/* <div className="c42x-eachInputField-container">
        <div className="c42x-weightage-container">
          <h1 className="c42x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c42x-container">
            <div className="c42x-heading_Help-container">
              <h1 className="c42x-heading-style">
                <span className="c42x-span-style">4.2.4: </span>
                Percentage per day usage of library by teachers and students (
                foot falls and login data for online access)(data provided only
                for the latest completed academic year)
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp424Status(true);
                }}
                className="c42x-helpButton-style"
              >
                Help
              </button>
              <Help424
                isHelp424Clicked={help424Status}
                setIsHelp424Clicked={setHelp424Status}
              />
            </div>
            <div className="c42x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus424(!responseButtonStatus424);
                  onClickingViewResponse424();
                }}
                className="c42x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus424 ? (
                <p className="c42x-responseResult-style">{responseValue424}</p>
              ) : null}
            </div>
          </div>
          <div className="c42xx-container">
            <h1 className="c42xx-Heading-style">
              <span className="c42xx-span-style">4.2.4.1: </span>
              Number of teachers and students using library per day over last
              one year
            </h1>
            <input
              readOnly
              onChange={(e) => setValue4241t1(e.target.value)}
              id="4241-t1"
              value={value4241t1}
              style={{ marginLeft: "4%" }}
              type="number"
            />
            <h1 className="c42xx-Heading-style">
              <span className="c42xx-span-style">4.2.4.2: </span>
              Total number of teachers and students
            </h1>
            <input
              readOnly
              onChange={(e) => setValue4241t2(e.target.value)}
              id="4241-t2"
              value={value4241t2}
              style={{ marginLeft: "4%" }}
              type="number"
            />

            <table className="c42x-table-style">
              <tr>
                <th className="c42x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c42x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c42x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c42x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue4241f1(e.target.files[0]);
                      setPathValue4241f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="4241-f1"
                    type="file"
                    className="c42-fileButton-style"
                  />
                  {pathValue4241f1 === "" ? null : (
                    <div className="c42-fileButtons-container">
                      <button className="c42-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue4241f1("");
                          document.getElementById("4241-f1").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c42x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Details of library usage by teachers and students</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue4241f2(e.target.files[0]);
                      setPathValue4241f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="4241-f2"
                    type="file"
                    className="c42-fileButton-style"
                  />
                  {pathValue4241f2 === "" ? null : (
                    <div className="c42-fileButtons-container">
                      <button className="c42-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue4241f2("");
                          document.getElementById("4241-f2").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c42x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div> */}

    </div>
  );
}

export default Criteria42;
