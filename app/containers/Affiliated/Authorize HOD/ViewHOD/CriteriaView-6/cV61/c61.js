import React, { useState, useEffect } from "react";
import "./c61-style.css";
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

// Help buttons functionality
function Help611(props) {
  return props.isHelp611Clicked ? (
    <div className="c61x-help-mainContainer">
      <div className="c61x-help-subContainer">
        <h1 className="c61x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c61x-help-para-style">
          Describe the vision and mission statement of the institution on the
          nature of governance, perspective plans and participation of the
          teachers in the decision making bodies of the institution within a
          maximum of 500 words..
        </p>
        <button
          className="c61x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp611Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria61() {
    // /this is Help button 
    const [isOpen, setIsopen] = useState(false)
    const handleHelpOpen = (e) => {
      e.preventDefault(),
      setIsopen(true)
    }
    const handleHelpClose = () => {
      setIsopen(false)
    }
  // state variables
  const [value611t1, setValue611t1] = useState();
  const [responseValue611, setResponseValue611] = useState("");

  const [value611f1, setValue611f1] = useState();
  const [pathValue611f1, setPathValue611f1] = useState("");

  const [value611f2, setValue611f2] = useState();
  const [pathValue611f2, setPathValue611f2] = useState("");

  const [help611Status, setHelp611Status] = useState(false);
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
        resources.APPLICATION_URL+'criteria6getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            setValue611t1(data[0].criteria61Ql[0]?data[0].criteria61Ql[0].input611t1:"");

            setValue611f1(data[0].criteria6FileUpload[0]?data[0].criteria6FileUpload[0].criteria6FileName:"");
            setValue611f2(data[0].criteria6FileUpload[1]?data[0].criteria6FileUpload[1].criteria6FileName:"");
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

    criteria61Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 101,
        input611t1: value611t1,
        response611: responseValue611,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form61Data = new FormData();

    form61Data.append("criteria6Fieldinfo", jsonBlob(inputDataList));
    if (pathValue611f1 !== "") {
      form61Data.append("uploadfile6", value611f1, "f611f1-" + value611f1.name);
    }
    if (pathValue611f2 !== "") {
      form61Data.append("uploadfile6", value611f2, "f611f2-" + value611f2.name);
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form61Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria6upload",
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
    <div className="c61-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c61x-colorIndicator-container">
        <p className="c61x-QlcolorIndicator-circle-style"></p>
        <span className="c61x-colorIndicator-span-style">Qualitative</span>
        <p className="c61x-QtcolorIndicator-circle-style"></p>
        <span className="c61x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c61x-weightage-heading-style">
            Key Indicator Weightage: 15
          </h1>
        </div>
      </div>

      {/* Key Indicator: 6.1.1 */}
      <div className="c61x-eachInputField-container">
        <div className="c61x-weightage-container">
          <h1 className="c61x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c61x-Ql-label-textarea-container">
            <div className="c61x-heading_Help-container">
              <h1 className="c61x-heading-style">
                <span className="c61x-span-style">6.1.1: </span>
                The governance and leadership is in accordance with vision and mission of the institution and it is visible in various institutional practices such as decentralization 
                and participation in the institutional governance  The governance of the institution is reflective of an effective
                leadership in tune with the vision and mission of the
                Institution.
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c61x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Write description in a maximum of 500 wordsercentage'
               ></HelpButton>
            </div>
            <label htmlFor="611-t1" className="c61x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue611t1(e.target.value);
                setResponseValue611(e.target.value);
              }}
              value={value611t1}
              rows={10}
              className="c61x-textarea-style"
              id="611-t1"
            ></textarea>
            {value611t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c61x-Ql-table-style">
            <tr>
              <th className="c61x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c61x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c61x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c61x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c61x-Ql-tableBorders-style">
                Paste link for additional Information
              </td>
              <td className="c61x-Ql-tableBorders-style"></td>
              <td className="c61x-Ql-tableBorders-style">
                <input
                  readOnly
                  onChange={(e) => {
                    setValue611f1(e.target.files[0]);
                    setPathValue611f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="611-f1"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue611f1 === "" ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue611f1("");
                        document.getElementById("611-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value611f1)} target="_blank">View File</a> */}
              </td>
              <td className="c61x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c61x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c61x-Ql-tableBorders-style"></td>
              <td className="c61x-Ql-tableBorders-style">
                <input
                  readOnly
                  onChange={(e) => {
                    setValue611f2(e.target.files[0]);
                    setPathValue611f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="611-f2"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue611f2 === "" ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue611f2("");
                        document.getElementById("611-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value611f2)} target="_blank">View File</a> */}
              </td>
              <td className="c61x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  );
}

export default Criteria61;
