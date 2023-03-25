import React, { useState, useEffect } from "react";
import "./c41-style.css";
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
// End here

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
            props.setIsHelp412Clicked(false);
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
  // state variables
  const [value411t1, setValue411t1] = useState();
  const [value411f1, setValue411f1] = useState("");
  const [pathValue411f1, setPathValue411f1] = useState("");
  const [value411f2, setValue411f2] = useState("");
  const [pathValue411f2, setPathValue411f2] = useState("");

  const [responseValue411, setResponseValue411] = useState("");
  const [help411Status, setHelp411Status] = useState(false);

  const [value4121t1, setValue4121t1] = useState();
  const [value4121t2, setValue4121t2] = useState();
  const [value4121t3, setValue4121t3] = useState();
  const [value4121t4, setValue4121t4] = useState();
  const [value4121t5, setValue4121t5] = useState();
  const [value4121t6, setValue4121t6] = useState();
  const [value4121t7, setValue4121t7] = useState();
  const [value4121t8, setValue4121t8] = useState();
  const [value4121t9, setValue4121t9] = useState();
  const [value4121t10, setValue4121t10] = useState();
  const [value4121t11, setValue4121t11] = useState();
  const [value4121t12, setValue4121t12] = useState();
  const [value4121t13, setValue4121t13] = useState();
  const [value4121t14, setValue4121t14] = useState();
  const [value4121t15, setValue4121t15] = useState();
  const [value4121t16, setValue4121t16] = useState();
  const [value4121t17, setValue4121t17] = useState();
  const [value4121t18, setValue4121t18] = useState();
  const [value4121t19, setValue4121t19] = useState();
  const [value4121t20, setValue4121t20] = useState();
  const [value4121f1, setValue4121f1] = useState("");
  const [pathValue4121f1, setPathValue4121f1] = useState("");
  const [value4121f2, setValue4121f2] = useState("");
  const [pathValue4121f2, setPathValue4121f2] = useState("");
  const [value4121f3, setValue4121f3] = useState("");
  const [pathValue4121f3, setPathValue4121f3] = useState("");
  const [responseButtonStatus412, setResponseButtonStatus412] = useState(false);
  const [responseValue412, setResponseValue412] = useState("");
  const [help412Status, setHelp412Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  // get data  with API
  const financialYear = "2021-2022";
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
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

  // get data to db with API

  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria4getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            setValue411t1(data[0].criteria41Ql[0]?data[0].criteria41Ql[0].input411t1:"");

            setValue4121t1(data[0].affiliatedYearTable4121[0]?data[0].affiliatedYearTable4121[0].input4121y:"");
            setValue4121t2(data[0].affiliatedYearTable4121[1]?data[0].affiliatedYearTable4121[1].input4121y:"");
            setValue4121t3(data[0].affiliatedYearTable4121[2]?data[0].affiliatedYearTable4121[2].input4121y:"");
            setValue4121t4(data[0].affiliatedYearTable4121[3]?data[0].affiliatedYearTable4121[3].input4121y:"");
            setValue4121t5(data[0].affiliatedYearTable4121[4]?data[0].affiliatedYearTable4121[4].input4121y:"");
            setValue4121t6(data[0].affiliatedYearTable4121[0]?data[0].affiliatedYearTable4121[0].input4121v:"");
            setValue4121t7(data[0].affiliatedYearTable4121[1]?data[0].affiliatedYearTable4121[1].input4121v:"");
            setValue4121t8(data[0].affiliatedYearTable4121[2]?data[0].affiliatedYearTable4121[2].input4121v:"");
            setValue4121t9(data[0].affiliatedYearTable4121[3]?data[0].affiliatedYearTable4121[3].input4121v:"");
            setValue4121t10(data[0].affiliatedYearTable4121[4]?data[0].affiliatedYearTable4121[4].input4121v:"");

            setValue4121t11(data[0].affiliatedYearTable41212[0]?data[0].affiliatedYearTable41212[0].input41212y:"");
            setValue4121t12(data[0].affiliatedYearTable41212[1]?data[0].affiliatedYearTable41212[1].input41212y:"");
            setValue4121t13(data[0].affiliatedYearTable41212[2]?data[0].affiliatedYearTable41212[2].input41212y:"");
            setValue4121t14(data[0].affiliatedYearTable41212[3]?data[0].affiliatedYearTable41212[3].input41212y:"");
            setValue4121t15(data[0].affiliatedYearTable41212[4]?data[0].affiliatedYearTable41212[4].input41212y:"");
            setValue4121t16(data[0].affiliatedYearTable41212[0]?data[0].affiliatedYearTable41212[0].input41212v:"");
            setValue4121t17(data[0].affiliatedYearTable41212[1]?data[0].affiliatedYearTable41212[1].input41212v:"");
            setValue4121t18(data[0].affiliatedYearTable41212[2]?data[0].affiliatedYearTable41212[2].input41212v:"");
            setValue4121t19(data[0].affiliatedYearTable41212[3]?data[0].affiliatedYearTable41212[3].input41212v:"");
            setValue4121t20(data[0].affiliatedYearTable41212[4]?data[0].affiliatedYearTable41212[4].input41212v:"");
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );

  // response button functionality

  function onClickingViewResponse412() {
    if (
      value4121t6 === "" ||
      value4121t7 === "" ||
      value4121t8 === "" ||
      value4121t9 === "" ||
      value4121t10 === "" ||
      value4121t16 === "" ||
      value4121t17 === "" ||
      value4121t18 === "" ||
      value4121t19 === "" ||
      value4121t20 === "" ||
      value4121t6 === undefined ||
      value4121t7 === undefined ||
      value4121t8 === undefined ||
      value4121t9 === undefined ||
      value4121t10 === undefined ||
      value4121t16 === undefined ||
      value4121t17 === undefined ||
      value4121t18 === undefined ||
      value4121t19 === undefined ||
      value4121t20 === undefined
    ) {
      setResponseValue412("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value4121t6, 10)) === false ||
      Number.isInteger(parseInt(value4121t7, 10)) === false ||
      Number.isInteger(parseInt(value4121t8, 10)) === false ||
      Number.isInteger(parseInt(value4121t9, 10)) === false ||
      Number.isInteger(parseInt(value4121t10, 10)) === false ||
      Number.isInteger(parseInt(value4121t16, 10)) === false ||
      Number.isInteger(parseInt(value4121t17, 10)) === false ||
      Number.isInteger(parseInt(value4121t18, 10)) === false ||
      Number.isInteger(parseInt(value4121t19, 10)) === false ||
      Number.isInteger(parseInt(value4121t20, 10)) === false
    ) {
      setResponseValue412("Input should be an Integer");
    } else if (
      value4121t6 !== "" &&
      value4121t7 !== "" &&
      value4121t8 !== "" &&
      value4121t9 !== "" &&
      value4121t10 !== "" &&
      value4121t16 !== "" &&
      value4121t17 !== "" &&
      value4121t18 !== "" &&
      value4121t19 !== "" &&
      value4121t20 !== ""
    ) {
      setResponseValue412(
        ((value4121t6 / value4121t16) * 100 +
          (value4121t7 / value4121t17) * 100 +
          (value4121t8 / value4121t18) * 100 +
          (value4121t9 / value4121t19) * 100 +
          (value4121t10 / value4121t20) * 100) /
          5
      );
    }
  }
  // sending data to db with API

  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    criteria41Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 101,
        input411t1: value411t1,
        response411: responseValue411,
        response412: responseValue412,
      },
    ],
    affiliatedYearTable4121: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 101,
        input4121y: value4121t1,
        input4121v: value4121t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 102,
        input4121y: value4121t2,
        input4121v: value4121t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 103,
        input4121y: value4121t3,
        input4121v: value4121t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 104,
        input4121y: value4121t4,
        input4121v: value4121t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 105,
        input4121y: value4121t5,
        input4121v: value4121t10,
      },
    ],
    affiliatedYearTable41212: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 101,
        input41212y: value4121t11,
        input41212v: value4121t16,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 102,
        input41212y: value4121t12,
        input41212v: value4121t17,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 103,
        input41212y: value4121t13,
        input41212v: value4121t18,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 104,
        input41212y: value4121t14,
        input41212v: value4121t19,
      },
      {        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 105,
        input41212y: value4121t15,
        input41212v: value4121t20,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form41Data = new FormData();

    form41Data.append("criteria4Fieldinfo", jsonBlob(inputDataList));
    if (pathValue411f1 !== "") {
      form41Data.append("uploadfile4", value411f1, "f411f1-" + value411f1.name);
    }
    if (pathValue411f2 !== "") {
      form41Data.append("uploadfile4", value411f2, "f411f2-" + value411f2.name);
    }

    if (pathValue4121f1 !== "") {
      form41Data.append(
        "uploadfile4",
        value4121f1,
        "f4121f1-" + value4121f1.name
      );
    }
    if (pathValue4121f2 !== "") {
      form41Data.append(
        "uploadfile4",
        value4121f2,
        "f4121f2-" + value4121f2.name
      );
    }
    if (pathValue4121f3 !== "") {
      form41Data.append(
        "uploadfile4",
        value4121f3,
        "f4121f3-" + value4121f3.name
      );
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form41Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria4upload",
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
                The Institution has adequate infrastructure and physical
                facilities for teaching- learning. viz., classrooms,
                laboratories, computing equipment etc.
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c41x-helpButton-style"
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
            <textarea readonly
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
                <input
                  readOnly
                  onChange={(e) => {
                    setValue411f1(e.target.files[0]);
                    setPathValue411f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="411-f1"
                  className="c27-fileButton-style"
                  type="file"
                />
                {pathValue411f1 === "" ? null : (
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
                        setPathValue411f1("");
                        document.getElementById("411-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value411f1)} target="_blank">View File</a> */}
              </td>
              <td className="c41x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
                <input
                  readOnly
                  onChange={(e) => {
                    setValue411f2(e.target.files[0]);
                    setPathValue411f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="411-f2"
                  className="c27-fileButton-style"
                  type="file"
                />
                {pathValue411f2 === "" ? null : (
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
                        setPathValue411f2("");
                        document.getElementById("411-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value411f2)} target="_blank">View File</a> */}
              </td>
              <td className="c41x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 4.1.2 */}
      <div className="c41x-eachInputField-container">
        <div className="c41x-weightage-container">
          <h1 className="c41x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c41x-container">
            <div className="c41x-heading_Help-container">
              <h1 className="c41x-heading-style">
                <span className="c41x-span-style">4.1.2: </span>
                Average percentage of expenditure for infrastructure
                augmentation excluding salary during the last five years (INR in
                Lakhs)
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c33x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='formula'
                ><h1>(Total Expenditure for infrastructure
                  augmentation, excluding salary)/(Total Expenditure excluding salary) * 100
                  </h1></HelpButton>
            </div>
            <div className="c41x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus412(!responseButtonStatus412);
                  onClickingViewResponse412();
                }}
                className="c41x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus412 ? (
                <p className="c41x-responseResult-style">{responseValue412}</p>
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
                      onChange={(e) => setValue4121t1(e.target.value)}
                      id="4121-t1"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t1}
                    />
                    {value4121t1 === "" ? (
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
                      onChange={(e) => setValue4121t2(e.target.value)}
                      id="4121-t2"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t2}
                    />
                    {value4121t2 === "" ? (
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
                      onChange={(e) => setValue4121t3(e.target.value)}
                      id="4121-t3"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t3}
                    />
                    {value4121t3 === "" ? (
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
                      onChange={(e) => setValue4121t4(e.target.value)}
                      id="4121-t4"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t4}
                    />
                    {value4121t4 === "" ? (
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
                      onChange={(e) => setValue4121t5(e.target.value)}
                      id="4121-t5"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t5}
                    />
                    {value4121t5 === "" ? (
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
                        setValue4121t6(e.target.value);
                        onClickingViewResponse412();
                      }}
                      id="4121-t6"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t6}
                    />
                    {value4121t6 === "" ? (
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
                        setValue4121t7(e.target.value);
                        onClickingViewResponse412();
                      }}
                      id="4121-t7"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t7}
                    />
                    {value4121t7 === "" ? (
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
                        setValue4121t8(e.target.value);
                        onClickingViewResponse412();
                      }}
                      id="4121-t8"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t8}
                    />
                    {value4121t8 === "" ? (
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
                        setValue4121t9(e.target.value);
                        onClickingViewResponse412();
                      }}
                      id="4121-t9"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t9}
                    />
                    {value4121t9 === "" ? (
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
                        setValue4121t10(e.target.value);
                        onClickingViewResponse412();
                      }}
                      id="4121-t10"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t10}
                    />
                    {value4121t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

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
                      onChange={(e) => setValue4121t11(e.target.value)}
                      id="4121-t11"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t11}
                    />
                    {value4121t11 === "" ? (
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
                      onChange={(e) => setValue4121t12(e.target.value)}
                      id="4121-t12"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t12}
                    />
                    {value4121t12 === "" ? (
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
                      onChange={(e) => setValue4121t13(e.target.value)}
                      id="4121-t13"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t13}
                    />
                    {value4121t13 === "" ? (
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
                      onChange={(e) => setValue4121t14(e.target.value)}
                      id="4121-t14"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t14}
                    />
                    {value4121t14 === "" ? (
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
                      onChange={(e) => setValue4121t15(e.target.value)}
                      id="4121-t15"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t15}
                    />
                    {value4121t15 === "" ? (
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
                        setValue4121t16(e.target.value);
                        onClickingViewResponse412();
                      }}
                      id="4121-t16"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t16}
                    />
                    {value4121t16 === "" ? (
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
                        setValue4121t17(e.target.value);
                        onClickingViewResponse412();
                      }}
                      id="4121-t17"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t17}
                    />
                    {value4121t17 === "" ? (
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
                        setValue4121t18(e.target.value);
                        onClickingViewResponse412();
                      }}
                      id="4121-t18"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t18}
                    />
                    {value4121t18 === "" ? (
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
                        setValue4121t19(e.target.value);
                        onClickingViewResponse412();
                      }}
                      id="4121-t19"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t19}
                    />
                    {value4121t19 === "" ? (
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
                        setValue4121t20(e.target.value);
                        onClickingViewResponse412();
                      }}
                      id="4121-t20"
                      className="c41x-input-style"
                      type="text"
                      value={value4121t20}
                    />
                    {value4121t20 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

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
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue4121f1(e.target.files[0]);
                      setPathValue4121f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="4121-f1"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue4121f1 === "" ? null : (
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
                          setPathValue4121f1("");
                          document.getElementById("4121-f1").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value4121f1)} target="_blank">View File</a> */}
                </td>
                <td className="c41x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload audited utilization statements</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue4121f2(e.target.files[0]);
                      setPathValue4121f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="4121-f2"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue4121f2 === "" ? null : (
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
                          setPathValue4121f2("");
                          document.getElementById("4121-f2").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value4121f2)} target="_blank">View File</a> */}
                </td>
                <td className="c41x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Upload Details of Expenditure, excluding salary during the
                  last five years
                </td>
                <td>
                <a href={downloadFile("af4.4.1.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue4121f3(e.target.files[0]);
                      setPathValue4121f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="4121-f3"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue4121f3 === "" ? null : (
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
                          setPathValue4121f3("");
                          document.getElementById("4121-f3").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value4121f3)} target="_blank">View File</a> */}
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
