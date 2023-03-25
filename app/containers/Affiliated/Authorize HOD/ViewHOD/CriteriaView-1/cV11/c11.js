import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import "./c11-style.css";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import { resources } from "../../../../../appConstants";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
// Help buttons functionality
function Help111(props) {
  return props.isHelp111Clicked ? (
    <div className="c11x-help-mainContainer">
      <div className="c11x-help-subContainer">
        <h1 className="c11x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c11x-help-para-style">
          Write description in a maximum of 500 words.
        </p>
        <button
          className="c11x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp111Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria11() {
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
  const [value111t1, setValue111t1] = useState();
  const [pathValue111f1, setPathValue111f1] = useState("");
  const [value111f1, setValue111f1] = useState([]);
  const [value111f2, setValue111f2] = useState([]);
  const [pathValue111f2, setPathValue111f2] = useState("");
  const [responseValue111, setResponseValue111] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");
  const [help111Status, setHelp111Status] = useState(false);

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
  const financialYear = "2021-2022";
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }
  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria1getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            setValue111t1(data[0].criteria11Ql[0]?data[0].criteria11Ql[0].input111t1:"");

            setValue111f1(data[0].criteria1FileUpload[0]?data[0].criteria1FileUpload[0].criteria1FileName:"");
            setValue111f2(data[0].criteria1FileUpload[1]?data[0].criteria1FileUpload[1].criteria1FileName:"");

            // setResponseValue111(daValue11ta[0].criteria1FieldInfoQl[1].response111);
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

    criteria11Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 101,
        input111t1: value111t1,
        response111: responseValue111,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    console.log(value111t1);
    const form11Data = new FormData();

    form11Data.append("criteria1Fieldinfo", jsonBlob(inputDataList));
    if (pathValue111f1 !== "") {
      form11Data.append("uploadfile1", value111f1, "f111f1-" + value111f1.name);
    }
    if (pathValue111f2 !== "") {
      form11Data.append("uploadfile1", value111f2, "f111f2-" + value111f2.name);
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form11Data,
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

  // remove file functionality

  const ref = React.useRef();
  function removeAll(e) {
    e.preventDefault();
    e.target.value = null;
    setValue111f1([]);
    setPathValue111f1("");
    ref.current.value = "";
    console.log("working");
    //  $(".c11-fileButton-style").value=""
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
    <div className="c11-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c11x-colorIndicator-container">
        <p className="c11x-QlcolorIndicator-circle-style"></p>
        <span className="c11x-colorIndicator-span-style">Qualitative</span>
        <p className="c11x-QtcolorIndicator-circle-style"></p>
        <span className="c11x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c11x-weightage-heading-style">
            Key Indicator Weightage: 100
          </h1>
        </div>
      </div>

      {/* Key Indicator: 1.1.1 */}
      <div className="c11x-eachInputField-container">
        <div className="c11x-weightage-container">
          <h1 className="c11x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c11x-Ql-label-textarea-container">
            <div className="c11x-heading_Help-container">
              <h1 className="c11x-heading-style">
                <span className="c11x-span-style">1.1.1: </span>
                The Institution ensures effective curriculum planning and
                delivery through a well-planned and documented process including
                Academic calendar and conduct of continuous internal Assessment
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c12x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <label htmlFor="111-t1" className="c11x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue111t1(e.target.value);
                setResponseValue111(e.target.value);
              }}
              value={value111t1}
              rows={10}
              className="c11x-textarea-style"
              id="111-t1"
            ></textarea>
            {value111t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c11x-Ql-table-style">
            <tr>
              <th className="c11x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c11x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c11x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c11x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c11x-Ql-tableBorders-style">
                Any additional information
              </td>
              <td className="c11x-Ql-tableBorders-style"></td>
              <td className="c11x-Ql-tableBorders-style">
                 <input readOnly
                  onChange={(e) => {
                    setValue111f1(e.target.files[0]);
                    setPathValue111f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="111-f1"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue111f1 === "" ? null : (
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
                        setPathValue111f1("");
                        document.getElementById("111-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value111f1)} target="_blank">View File</a> */}
              </td>
              <td className="c11x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c11x-Ql-tableBorders-style">
                Link for Additional Information
              </td>
              <td></td>
              <td className="c11x-Ql-tableBorders-style">
                 <input readOnly
                  onChange={(e) => {
                    setValue111f2(e.target.files[0]);
                    setPathValue111f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="111-f2"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue111f2 === "" ? null : (
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
                        setPathValue111f2("");
                        document.getElementById("111-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value111f2)} target="_blank">View File</a> */}
              </td>
              <td className="c11x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  );
}

export default Criteria11;
