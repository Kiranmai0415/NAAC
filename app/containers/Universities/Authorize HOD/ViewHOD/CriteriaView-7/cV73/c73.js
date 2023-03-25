import React, { useState, useEffect } from "react";
import "./c73-style.css";
import AuthService from "../../../../../Pages/Users/services/auth.service";

import { HelpButton } from "../../../../../../reusableComponents/model/Help";
import { resources } from "../../../../../appConstants";

function Help731(props) {
  return props.isHelp731Clicked ? (
    <div className="c72x-help-mainContainer">
      <div className="c72x-help-subContainer">
        <h1 className="c72x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c72x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c72x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp731Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Criteria73() {
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
  const [value731t1, setValue731t1] = useState();
  const [value731f1, setValue731f1] = useState("");
  const [pathValue731f1, setPathValue731f1] = useState("");
  const [value731f2, setValue731f2] = useState("");
  const [pathValue731f2, setPathValue731f2] = useState("");
  const [responseValue731, setResponseValue731] = useState("");
  const [help731Status, setHelp731Status] = useState(false);

  // get data  with API
  function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
  }
  //get data api
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
  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria7getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then((response) => response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setValue731t1(data[0].criteria73Ql[0] ? data[0].criteria73Ql[0].input731t1 : "");

            setValue731f1(data[0].criteria7FileUpload[0] ? data[0].criteria7FileUpload[0].criteria7FileName : "");
            setValue731f2(data[0].criteria7FileUpload[0] ? data[0].criteria7FileUpload[0].criteria7FileName : "");
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

    criteria73Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input731t1: value731t1,
        response731: responseValue731,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form73Data = new FormData();

    form73Data.append("criteria7Fieldinfo", jsonBlob(inputDataList));
    if (pathValue731f1 !== "") {
      form73Data.append("uploadfile7", value731f1, "f731f1-" + value731f1.name);
    }
    if (pathValue731f2 !== "") {
      form73Data.append("uploadfile7", value731f2, "f731f2-" + value731f2.name);
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form73Data,
    };
    fetch(
      "http://localhost:8080/api/v1/criteria7upload",
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

  // rendering DOM
  return (
    <div className="c73-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c73x-colorIndicator-container">
        <p className="c73x-QlcolorIndicator-circle-style"></p>
        <span className="c73x-colorIndicator-span-style">Qualitative</span>
        <p className="c73x-QtcolorIndicator-circle-style"></p>
        <span className="c73x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c73x-weightage-heading-style">
            Key Indicator Weightage: 20
          </h1>
        </div>
      </div>

      {/* Key Indicator: 7.3.1 */}
      <div className="c73x-eachInputField-container">
        <div className="c73x-weightage-container">
          <h1 className="c73x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c73x-Ql-label-textarea-container">
            <div className="c73x-heading_Help-container">
              <h1 className="c73x-heading-style">
                <span className="c73x-span-style">7.3.1: </span>
                Portray the performance of the Institution in one area
                distinctive to its priority and thrust within 1000 words
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
            <label htmlFor="731-t1" className="c73x-label-style">
              Response:
            </label>
            <textarea
              readOnly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue731t1(e.target.value);
                setResponseValue731(e.target.value);
              }}
              value={value731t1}
              rows={10}
              className="c73x-textarea-style"
              id="731-t1"
            ></textarea>
            {value731t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c73x-Ql-table-style">
            <tr>
              <th className="c73x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c73x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c73x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c73x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c73x-Ql-tableBorders-style">
                Appropriate web in the Institutional website
              </td>
              <td className="c73x-Ql-tableBorders-style"></td>
              <td className="c73x-Ql-tableBorders-style">
                <a href={downloadFile(value731f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c73x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c73x-Ql-tableBorders-style">
                Any other relevant information
              </td>
              <td className="c73x-Ql-tableBorders-style"></td>
              <td className="c73x-Ql-tableBorders-style">
                <a href={downloadFile(value731f2)} target="_blank">
                  view
                </a>
              </td>
              <td className="c73x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  );
}

export default Criteria73;
