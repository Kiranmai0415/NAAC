import React, { useState, useEffect } from "react";
import "./c35-style.css";
import { toast } from "react-toastify";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import { resources } from "../../../../../appConstants";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
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
// End here

function Help351(props) {
  return props.isHelp351Clicked ? (
    <div className="c35x-help-mainContainer">
      <div className="c35x-help-subContainer">
        <h1 className="c35x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c35x-help-para-style">
          Number of extension and outreach programs conducted by the institution
          including those through NSS/NCC, Government and Government recognised
          bodies during the last five years.
        </p>
        <button
          className="c35x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp351Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Criteria35() {
  // /this is Help button 
  const [isOpen, setIsopen] = useState(false)
  const handleHelpOpen = (e) => {
    e.preventDefault(),
    setIsopen(true)
  }
  const handleHelpClose = () => {
    setIsopen(false)
  }
   // getfile data with API
   function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
  const [value3511t1, setValue3511t1] = useState();
  const [value3511t2, setValue3511t2] = useState();
  const [value3511t3, setValue3511t3] = useState();
  const [value3511t4, setValue3511t4] = useState();
  const [value3511t5, setValue3511t5] = useState();
  const [value3511t6, setValue3511t6] = useState();
  const [value3511t7, setValue3511t7] = useState();
  const [value3511t8, setValue3511t8] = useState();
  const [value3511t9, setValue3511t9] = useState();
  const [value3511t10, setValue3511t10] = useState();
  const [value3511f1, setValue3511f1] = useState("");
  const [pathValue3511f1, setPathValue3511f1] = useState("");
  const [value3511f2, setValue3511f2] = useState("");
  const [pathValue3511f2, setPathValue3511f2] = useState("");
  const [value3511f3, setValue3511f3] = useState("");
  const [pathValue3511f3, setPathValue3511f3] = useState("");
  const [responseButtonStatus351, setResponseButtonStatus351] = useState(false);
  const [responseValue351, setResponseValue351] = useState("");
  const [help351Status, setHelp351Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");


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
  const financialYear = "2021-2022";
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }

  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria3getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            // setResponseValue111(data[0].criteria1FieldInfoQl[1].response111);
            // setResponseValue112(data[0].criteria1FieldInfoQn[2].response112);
            // setResponseValue113(data[0].criteria1FieldInfoQn[3].response113);
            setValue3511t1(data[0].yearTable3511[0]?data[0].yearTable3511[0].input3511y:"");
            setValue3511t2(data[0].yearTable3511[1]?data[0].yearTable3511[1].input3511y:"");
            setValue3511t3(data[0].yearTable3511[2]?data[0].yearTable3511[2].input3511y:"");
            setValue3511t4(data[0].yearTable3511[3]?data[0].yearTable3511[3].input3511y:"");
            setValue3511t5(data[0].yearTable3511[4]?data[0].yearTable3511[4].input3511y:"");
            setValue3511t6(data[0].yearTable3511[0]?data[0].yearTable3511[0].input3511v:"");
            setValue3511t7(data[0].yearTable3511[1]?data[0].yearTable3511[1].input3511v:"");
            setValue3511t8(data[0].yearTable3511[2]?data[0].yearTable3511[2].input3511v:"");
            setValue3511t9(data[0].yearTable3511[3]?data[0].yearTable3511[3].input3511v:"");
            setValue3511t10(data[0].yearTable3511[4]?data[0].yearTable3511[4].input3511v:"");

            setValue3511f1(data[0].criteria3FileUpload[0]?data[0].criteria3FileUpload[0].criteria3FileName:"");
            setValue3511f2(data[0].criteria3FileUpload[1]?data[0].criteria3FileUpload[1].criteria3FileName:"");
            setValue3511f3(data[0].criteria3FileUpload[2]?data[0].criteria3FileUpload[2].criteria3FileName:"");
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

    criteria35Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 101,
        response351: responseValue351,
      },
    ],
    yearTable3511: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 101,
        input3511y: value3511t1,
        input3511v: value3511t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 102,
        input3511y: value3511t2,
        input3511v: value3511t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 103,
        input3511y: value3511t3,
        input3511v: value3511t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 104,
        input3511y: value3511t4,
        input3511v: value3511t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 105,
        input3511y: value3511t5,
        input3511v: value3511t10,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form35Data = new FormData();

    form35Data.append("criteria3Fieldinfo", jsonBlob(inputDataList));

    if (pathValue3511f1 !== "") {
      form35Data.append(
        "uploadfile3",
        value3511f1,
        "f3311f2-" + value3511f1.name
      );
    }
    if (pathValue3511f2 !== "") {
      form35Data.append(
        "uploadfile3",
        value3511f2,
        "f3321f1-" + value3511f2.name
      );
    }
    if (pathValue3511f3 !== "") {
      form35Data.append(
        "uploadfile3",
        value3511f3,
        "f3321f2-" + value3511f3.name
      );
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form35Data,
    };
    fetch(
      resources.APPLICATION_URL+"api/v1/criteria3upload",
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
  function onClickingViewResponse351() {
    if (
      value3511t6 === "" ||
      value3511t7 === "" ||
      value3511t8 === "" ||
      value3511t9 === "" ||
      value3511t10 === "" ||
      value3511t6 === undefined ||
      value3511t7 === undefined ||
      value3511t8 === undefined ||
      value3511t9 === undefined ||
      value3511t10 === undefined
    ) {
      setResponseValue351("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value3511t6, 10)) === false ||
      Number.isInteger(parseInt(value3511t7, 10)) === false ||
      Number.isInteger(parseInt(value3511t8, 10)) === false ||
      Number.isInteger(parseInt(value3511t9, 10)) === false ||
      Number.isInteger(parseInt(value3511t10, 10)) === false
    ) {
      setResponseValue351("Input should be an Integer");
    } else if (
      value3511t6 !== "" &&
      value3511t7 !== "" &&
      value3511t8 !== "" &&
      value3511t9 !== "" &&
      value3511t10 !== ""
    ) {
      setResponseValue351(
        parseInt(value3511t6, 10) +
          parseInt(value3511t7, 10) +
          parseInt(value3511t8, 10) +
          parseInt(value3511t9, 10) +
          parseInt(value3511t10, 10)
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

  return (
    <div className="c35-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c35x-colorIndicator-container">
        <p className="c35x-QlcolorIndicator-circle-style"></p>
        <span className="c35x-colorIndicator-span-style">Qualitative</span>
        <p className="c35x-QtcolorIndicator-circle-style"></p>
        <span className="c35x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c35x-weightage-heading-style">
            Key Indicator Weightage: 20
          </h1>
        </div>
      </div>

      {/* Key Indicator: 3.5.1 */}
      <div className="c35x-eachInputField-container">
        <div className="c35x-weightage-container">
          <h1 className="c35x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c35x-container">
            <div className="c35x-heading_Help-container">
              <h1 className="c35x-heading-style">
                <span className="c35x-span-style">3.5.1: </span>
                The number of MoUs, collaborations/linkages for Faculty 
              exchange, Student exchange, Internship, Field project, On-thejob training, research and other academic activities during the last 
                five years
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c31x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='file description'
                ></HelpButton>
            </div>
            <div className="c35x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus351(!responseButtonStatus351);
                  onClickingViewResponse351();
                }}
                className="c35x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus351 ? (
                <p className="c35x-responseResult-style">{responseValue351}</p>
              ) : null}
            </div>
          </div>
          <div className="c35xx-container">
            <h1 className="c35xx-Heading-style">
              <span className="c35xx-span-style">3.5.1.1: </span>
              Number of extension and outreach programs conducted by the
              institution through NSS/NCC, Government and Government recognised
              bodies during the last five years
            </h1>

            {/* <table className="c35x-Qt-table-style">
              <tr>
                <th className="c35x-horizontalTable-heading-style">Year</th>
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
                      onChange={(e) => setValue3511t1(e.target.value)}
                      id="3511-t1"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t1}
                    />
                    {value3511t1 === "" ? (
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
                      onChange={(e) => setValue3511t2(e.target.value)}
                      id="3511-t2"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t2}
                    />
                    {value3511t2 === "" ? (
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
                      onChange={(e) => setValue3511t3(e.target.value)}
                      id="3511-t3"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t3}
                    />
                    {value3511t3 === "" ? (
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
                      onChange={(e) => setValue3511t4(e.target.value)}
                      id="3511-t4"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t4}
                    />
                    {value3511t4 === "" ? (
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
                      onChange={(e) => setValue3511t5(e.target.value)}
                      id="3511-t5"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t5}
                    />
                    {value3511t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c35x-horizontalTable-heading-style">
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
                      onChange={(e) => setValue3511t6(e.target.value)}
                      id="3511-t6"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t6}
                    />
                    {value3511t6 === "" ? (
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
                      onChange={(e) => setValue3511t7(e.target.value)}
                      id="3511-t7"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t7}
                    />
                    {value3511t7 === "" ? (
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
                      onChange={(e) => setValue3511t8(e.target.value)}
                      id="3511-t8"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t8}
                    />
                    {value3511t8 === "" ? (
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
                      onChange={(e) => setValue3511t9(e.target.value)}
                      id="3511-t9"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t9}
                    />
                    {value3511t9 === "" ? (
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
                      onChange={(e) => setValue3511t10(e.target.value)}
                      id="3511-t10"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t10}
                    />
                    {value3511t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> */}

            <table className="c35x-table-style">
              <tr>
                <th className="c35x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c35x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c35x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c35x-Qt-verticalTable-heading4-style">
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
                      setValue3511f1(e.target.files[0]);
                      setPathValue3511f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3511-f1"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue3511f1 === "" ? null : (
                    <div className="c27-fileButtons-container">
                      <button className="c27-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue3511f1("");
                          document.getElementById("3511-f1").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value3511f1)} target="_blank">View File</a> */}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3511f2(e.target.files[0]);
                      setPathValue3511f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3511-f2"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue3511f2 === "" ? null : (
                    <div className="c27-fileButtons-container">
                      <button className="c27-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue3511f2("");
                          document.getElementById("3511-f2").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value3511f2)} target="_blank">View File</a> */}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Number of extension and outreach Programmes conducted with
                  industry, community etc for the last five years
                </td>
                <td>
                  <a href={downloadFile("criteria3.6.3.xlsx")}>
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3511f3(e.target.files[0]);
                      setPathValue3511f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3511-f3"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue3511f3 === "" ? null : (
                    <div className="c27-fileButtons-container">
                      <button className="c27-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue3511f3("");
                          document.getElementById("3511-f3").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value3511f3)} target="_blank">View File</a> */}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Criteria35;
