import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import "./c13-style.css";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import { resources } from "../../../../../appConstants";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
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
            props.setIsHelp132Clicked(false);
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
   // /this is Help button 
   const [isOpen, setIsopen] = useState(false)
   const handleHelpOpen = (e) => {
     e.preventDefault(),
     setIsopen(true)
   }
   const handleHelpClose = () => {
     setIsopen(false)
   }
  // state variable
  const [value131t1, setValue131t1] = useState("");
  const [pathValue131f1, setPathValue131f1] = useState("");
  const [pathValue131f2, setPathValue131f2] = useState("");

  const [value131f1, setValue131f1] = useState([]);
  const [value131f2, setValue131f2] = useState([]);

  const [pathValue1321f1, setPathValue1321f1] = useState("");
  const [pathValue1321f2, setPathValue1321f2] = useState("");
  const [pathValue1321f3, setPathValue1321f3] = useState("");

  const [value132t1, setValue132t1] = useState("");
  const [value1321t1, setValue1321t1] = useState("");

  const [value1321f1, setValue1321f1] = useState([]);
  const [value1321f2, setValue1321f2] = useState([]);

  const [responseButtonStatus132, setResponseButtonStatus132] = useState(false);
  const [responseValue131, setResponseValue131] = useState("");
  const [responseValue132, setResponseValue132] = useState("");
  const [help131Status, setHelp131Status] = useState(false);
  const [help132Status, setHelp132Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

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

  // get data  with API
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }

  // get api data
  const financialYear = "2021-2022";
  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria1getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            setValue131t1(data[0].criteria13Ql[0]?data[0].criteria13Ql[0].input131t1:"");
            setResponseValue131(data[0].criteria13Ql[0]?data[0].criteria13Ql[0].response131:"");

            setValue132t1(data[0].criteria13Ql[0]?data[0].criteria13Ql[0].input132t1:"");
            setValue1321t1(data[0].criteria13Ql[0]?data[0].criteria13Ql[0].input132t2:"");
            setResponseValue132(data[0].criteria13Ql[0]?data[0].criteria13Ql[0].response132:"");

            setValue1321f1(data[0].criteria1FileUpload[0]?data[0].criteria1FileUpload[0].criteria1FileName:"");
            setValue1321f2(data[0].criteria1FileUpload[1]?data[0].criteria1FileUpload[0].criteria1FileName:"");
            setValue131f1(data[0].criteria1FileUpload[2]?data[0].criteria1FileUpload[0].criteria1FileName:"");
            setValue131f2(data[0].criteria1FileUpload[3]?data[0].criteria1FileUpload[0].criteria1FileName:"");
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );

  // sending data to db with API

  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    criteria13Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 101,
        input131t1: value131t1,
        response131: responseValue131,
        input132t1: value132t1,
        input132t2: value1321t1,
        response132: responseValue132,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form13Data = new FormData();

    form13Data.append("criteria1Fieldinfo", jsonBlob(inputDataList));
    if (pathValue131f1 !== "") {
      form13Data.append("uploadfile1", value131f1, "f131f1-" + value131f1.name);
    }
    if (pathValue131f2 !== "") {
      form13Data.append("uploadfile1", value131f2, "f131f2-" + value131f2.name);
    }
    if (pathValue1321f1 !== "") {
      form13Data.append(
        "uploadfile1",
        value1321f1,
        "f1321f1-" + value1321f1.name
      );
    }

    if (pathValue1321f2 !== "") {
      form13Data.append(
        "uploadfile1",
        value1321f2,
        "f1321f2-" + value1321f2.name
      );
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form13Data,
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

  // response button functionality

  function onClickingViewResponse132() {
    if (value132t1 === "" || value1321t1 === "") {
      setResponseValue132("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value132t1, 10)) === false ||
      Number.isInteger(parseInt(value1321t1, 10)) === false
    ) {
      setResponseValue132("Input should be an Integer");
    } else if (value132t1 !== "" && value1321t1 !== "") {
      setResponseValue132(
        (parseInt(value132t1, 10) / parseInt(value1321t1, 10)) * 100
      );
    }
  }
  function showFilePreview(e) {
    const selectedFile = e.target.files[0];
    if (selectedFile) {
      const fileReader = new FileReader();
      fileReader.readAsDataURL(selectedFile);
      fileReader.addEventListener("load", (event) => {
        setFilePreviewSrc111f1(event.target.result);
      });
    }
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
            Key Indicator Weightage: 30
          </h1>
        </div>
      </div>

      {/* Key Indicator: 1.3.1 */}
      <div className="c13x-eachInputField-container">
        <div className="c13x-weightage-container">
          <h1 className="c13x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c13x-Ql-label-textarea-container">
            <div className="c13x-heading_Help-container">
              <h1 className="c13x-heading-style">
                <span className="c13x-span-style">1.3.1: </span>
                Institution integrates crosscutting issues relevant to
                Professional Ethics ,Gender, Human Values ,Environment and
                Sustainability into the Curriculum
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c13x-helpButton-style"
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
            <textarea readonly
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
                <input
                  readOnly
                  onChange={(e) => {
                    setValue131f1(e.target.files[0]);
                    setPathValue131f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="131-f1"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue131f1 === "" ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue131f1("");
                        document.getElementById("131-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value131f1)} target="_blank">View File</a> */}
              </td>
              <td className="c13x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c13x-Ql-tableBorders-style">
                Provide Link for Additional information
              </td>
              <td></td>
              <td className="c13x-Ql-tableBorders-style">
                <input
                  readOnly
                  onChange={(e) => {
                    setValue131f2(e.target.files[0]);
                    setPathValue131f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="131-f2"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue131f2 === "" ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue131f2("");
                        document.getElementById("131-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value131f2)} target="_blank">View File</a> */}
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
                Percentage of students undertaking field projects/ internships /
                student projects (Data for the latest completed academic year).
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c13x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='percentage'
                ><h1>((Number of students undertaking project work/field work / internships)/(Total numberof students during the latest completed academic year)) * 100</h1></HelpButton>
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
              <span className="c13xx-span-style">
                1.3.2.1: Number of students undertaking field projects /
                internships / student projects
                <input
                  readOnly
                  onChange={(e) => setValue132t1(e.target.value)}
                  id="132-t1"
                  style={{ width: "20%", marginLeft: "4%" }}
                  type="number"
                />
              </span>
            </h1>
            <h1 className="c13xx-Heading-style">
              <span className="c13xx-span-style">
                1.3.2.1: Total number of students
                <input
                  readOnly
                  onChange={(e) => setValue1321t1(e.target.value)}
                  id="1321-t1"
                  style={{ width: "20%", marginLeft: "438PX" }}
                  type="number"
                />
              </span>
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
                <td>Institutional data in the prescribed format</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue1321f1(e.target.files[0]);
                      setPathValue1321f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="1321-f1"
                    type="file"
                    className="c62-fileButton-style"
                  />
                  {pathValue1321f1 === "" ? null : (
                    <div className="c62-fileButtons-container">
                      <button className="c62-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue1321f1("");
                          document.getElementById("1321-f1").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value1321f1)} target="_blank">View File</a> */}
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload supporting document</td>
                <td>
                  <a
                    target="_blank"
                    href={downloadFile("criteria1.3.4.xlsx")}
                  >
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue1321f2(e.target.files[0]);
                      setPathValue1321f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="1321-f2"
                    type="file"
                    className="c62-fileButton-style"
                  />
                  {pathValue1321f2 === "" ? null : (
                    <div className="c62-fileButtons-container">
                      <button className="c62-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue1321f2("");
                          document.getElementById("1321-f2").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value1321f2)} target="_blank">View File</a>
                   */}
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Criteria13;
