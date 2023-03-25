import React, { useState } from "react";

import { toast } from "react-toastify";
import "./Citations.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import { resources } from "../../../../appConstants";

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

export default function Citations() {
  const [citations, setCitations] = useState({
    faculty: "",
    department: "",
    school: "",
    scholar: "",
    scopus: "",
  });

  // file upload
  // const [valueep22, setValueep22] = useState();

  const { faculty, department, school, scholar, scopus } = citations;

  console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
  let instituteType = AuthService.getCurrentUser().instituteType;
  console.log("instituteType=======>" + instituteType);
  const d = new Date();
  let currYear = d.getFullYear();
  console.log("var ==>" + currYear);
  let fYear = parseInt(currYear) - 1 + "-" + currYear;
  console.log("current year==" + fYear);
  const collegeId = AuthService.getCurrentUser().collegeId;
  console.log("collegeId==========>" + collegeId);

  const inputCitations = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    uniqueKey1: 1,
    inputct1: faculty,
    inputct2: department,
    inputct3: school,
    inputct4: scholar,
    inputct5: scopus,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onhIndex(e) {
    e.preventDefault();
    console.log(JSON.stringify(inputCitations));
    const basicData = new FormData();
    basicData.append("citationsobj", jsonBlob(inputCitations));

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };

    fetch(resources.APPLICATION_URL+"citationsdata", filesFetchMethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Record is Inserted Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
  }

  const hIndexHandleChange = (e) => {
    setCitations({
      ...citations,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div className="Citations-container">
      <h1 className="Citations-heading-style">Citations </h1>
      <div className="Citations-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <span style={{ color: "red" }}>*</span>
            <tr>
              <th>Name of the Faculty</th>
              <td>
                <input
                  type="text"
                  name="faculty"
                  value={faculty}
                  onChange={hIndexHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Department</th>
              <td>
                <input
                  type="text"
                  name="department"
                  value={department}
                  onChange={hIndexHandleChange}
                />
              </td>
            </tr>

            <tr>
              <th>Schools Name</th>
              <td>
                <input
                  type="text"
                  name="school"
                  value={school}
                  onChange={hIndexHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Number of Google scholar citation Index </th>
              <td>
                <input
                  type="number"
                  name="scholar"
                  value={scholar}
                  onChange={hIndexHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Number of Scopus citation Index</th>
              <td>
                <input
                  type="number"
                  name="scopus"
                  value={scopus}
                  onChange={hIndexHandleChange}
                />
              </td>
            </tr>
          </table>
          <div className="Citations-button-container">
            <button className="Citations-button-style" onClick={onhIndex}>
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
