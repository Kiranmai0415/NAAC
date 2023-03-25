import React, { useState, useEffect } from "react";
import "./c42-style.css";
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

function Criteria42() {
    // /this is Help button 
    const [isOpen, setIsopen] = useState(false)
    const handleHelpOpen = (e) => {
      e.preventDefault(),
      setIsopen(true)
    }
    const handleHelpClose = () => {
      setIsopen(false)
    }
  const [value421t1, setValue421t1] = useState();
  const [value421f1, setValue421f1] = useState("");
  const [pathValue421f1, setPathValue421f1] = useState("");
  const [value421f2, setValue421f2] = useState("");
  const [pathValue421f2, setPathValue421f2] = useState("");

  const [responseValue421, setResponseValue421] = useState("");
  const [help421Status, setHelp421Status] = useState(false);
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
        resources.APPLICATION_URL+'criteria4getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            setValue421t1(data[0].criteria42Ql[0]?data[0].criteria42Ql[0].input421t1:"");

            setValue421f1(data[0].criteria4FileUpload[0]?data[0].criteria4FileUpload[0].criteria4FileName:"");
            setValue421f2(data[0].criteria4FileUpload[1]?data[0].criteria4FileUpload[1].criteria4FileName:"");
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

    criteria42Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 101,
        input421t1: value421t1,
        response421: responseValue421,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form42Data = new FormData();

    form42Data.append("criteria4Fieldinfo", jsonBlob(inputDataList));
    if (pathValue421f1 !== "") {
      form42Data.append("uploadfile4", value421f1, "f421f1-" + value421f1.name);
    }
    if (pathValue421f2 !== "") {
      form42Data.append("uploadfile4", value421f2, "f421f2-" + value421f2.name);
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form42Data,
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
          <h1 className="c42x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c42x-Ql-label-textarea-container">
            <div className="c42x-heading_Help-container">
              <h1 className="c42x-heading-style">
                <span className="c42x-span-style">4.2.1: </span>
                Library is automated using Integrated Library Management System
                (ILMS)
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c42x-helpButton-style"
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
            <textarea readonly
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
                <input
                  readOnly
                  onChange={(e) => {
                    setValue421f1(e.target.files[0]);
                    setPathValue421f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="421-f1"
                  className="c27-fileButton-style"
                  type="file"
                />
                {pathValue421f1 === "" ? null : (
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
                        setPathValue421f1("");
                        document.getElementById("421-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value421f1)} target="_blank">View File</a> */}
              </td>
              <td className="c42x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
                <input
                  readOnly
                  onChange={(e) => {
                    setValue421f2(e.target.files[0]);
                    setPathValue421f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="421-f2"
                  className="c27-fileButton-style"
                  type="file"
                />
                {pathValue421f2 === "" ? null : (
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
                        setPathValue421f2("");
                        document.getElementById("421-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value421f2)} target="_blank">View File</a> */}
              </td>
              <td className="c42x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  );
}

export default Criteria42;
