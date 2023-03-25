import React, { useState, useEffect } from "react";
import "./c54-style.css";
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
function Help541(props) {
  return props.isHelp541Clicked ? (
    <div className="c54x-help-mainContainer">
      <div className="c54x-help-subContainer">
        <h1 className="c54x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c54x-help-para-style">
          Describe contribution of alumni association to the institution within
          a maximum of 500 words
        </p>
        <button
          className="c54x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp541Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria54() {
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
  const [value541t1, setValue541t1] = useState();
  const [value542t1, setValue542t1] = useState();

  const [pathValue541f1, setPathValue541f1] = useState("");
  const [value541f1, setValue541f1] = useState([]);
  const [pathValue541f2, setPathValue541f2] = useState("");
  const [value541f2, setValue541f2] = useState([]);
  const [pathValue542f1, setPathValue542f1] = useState("");
  const [value542f1, setValue542f1] = useState([]);
  const [responseButtonStatus542, setResponseButtonStatus542] = useState(false);
  const [responseValue541, setResponseValue541] = useState("");
  const [responseValue542, setResponseValue542] = useState("");
  const [help541Status, setHelp541Status] = useState(false);
  const [help542Status, setHelp542Status] = useState(false);
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
        resources.APPLICATION_URL+'criteria5getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType, ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            setValue541t1(data[0].criteria54Ql[0]?data[0].criteria54Ql[0].input541t1:"");

            setValue541f1(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");
            setValue541f2(data[0].criteria5FileUpload[1]?data[0].criteria5FileUpload[1].criteria5FileName:"");
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

    criteria54Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 101,
        input541t1: value541t1,
        response541: responseValue541,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form54Data = new FormData();

    form54Data.append("criteria5Fieldinfo", jsonBlob(inputDataList));
    if (pathValue541f1 !== "") {
      form54Data.append("uploadfile5", value541f1, "f541f1-" + value541f1.name);
    }
    if (pathValue541f2 !== "") {
      form54Data.append("uploadfile5", value541f2, "f541f2-" + value541f2.name);
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form54Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria5upload",
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
  // rendering dom
  return (
    <div className="c54-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c54x-colorIndicator-container">
        <p className="c54x-QlcolorIndicator-circle-style"></p>
        <span className="c54x-colorIndicator-span-style">Qualitative</span>
        <p className="c54x-QtcolorIndicator-circle-style"></p>
        <span className="c54x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c54x-weightage-heading-style">
            Key Indicator Weightage: 10
          </h1>
        </div>
      </div>

      {/* Key Indicator: 5.4.1 */}
      <div className="c54x-eachInputField-container">
        <div className="c54x-weightage-container">
          <h1 className="c54x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c54x-container">
            <div className="c54x-heading_Help-container">
              <h1 className="c54x-heading-style">
                <span className="c54x-span-style">5.4.1: </span>
                The Alumni Association/Chapters (registered and
                functional)contributes significantly to the development of the
                institution through financial and other support services
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c54x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Write description in a maximum of 500 wordsercentage'
               ></HelpButton>
            </div>
            <label htmlFor="541-t1" className="c54x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue541t1(e.target.value);
                setResponseValue541(e.target.value);
              }}
              value={value541t1}
              rows={10}
              className="c54x-textarea-style"
              id="541-t1"
            ></textarea>
            {value541t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>
          <div className="c54xx-container">
            <table className="c54x-table-style">
              <tr>
                <th className="c54x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c54x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c54x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c54x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Paste link for Additional Information</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue541f1(e.target.files[0]);
                      setPathValue541f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="541-f1"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue541f1 === "" ? null : (
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
                          setPathValue541f1("");
                          document.getElementById("541-f1").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c54x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any Additional Information</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue541f2(e.target.files[0]);
                      setPathValue541f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="541-f2"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue541f2 === "" ? null : (
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
                          setPathValue541f2("");
                          document.getElementById("541-f2").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value541f2)} target="_blank">View File</a>
                   */}
                </td>
                <td className="c54x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Criteria54;
