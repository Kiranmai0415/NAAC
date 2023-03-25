import React, { useState } from "react";

import { toast } from "react-toastify";
import "./Hindex.css";
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

export default function Hindex() {
  const [hIndex, sethIndex] = useState({
    faculty: "",
    department: "",
    school: "",
    scholar: "",
    scopus: "",
  });

  // file upload
  // const [valueep22, setValueep22] = useState();

  const { faculty, department, school, scholar, scopus } = hIndex;

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

  const inputhIndex = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    // hindex: [
    //   {
    //     criteriaId: {
    //      collegeId:collegeId ,
    //       financialYear: "2021-22",
    //       typeofInstitution: "Autonohindex"
    //     },

    uniqueKey1: 1,
    inputhit1: faculty,
    inputhit2: department,
    inputhit3: school,
    inputhit4: scholar,
    inputhit5: scopus,
    //   }
    // ]
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onhIndex(e) {
    e.preventDefault();
    console.log(JSON.stringify(inputhIndex));
    const basicData = new FormData();
    basicData.append("hindexobj", jsonBlob(inputhIndex));

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };

    fetch(resources.APPLICATION_URL+"hindexdata", filesFetchMethod).then(
      (response) => {
        
        if (response.ok) {
          successMessage("Record is Inserted Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
  }

  const hIndexHandleChange = (e) => {
    sethIndex({
      ...hIndex,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div className="hindex-container">
      <h1 className="hindex-heading-style">h-Index </h1>
      <div className="hindex-eachTable-container">
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
              <th>Number of Google Scholor h-Index </th>
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
              <th>Number of Scopus h-Index</th>
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
          <div className="hindex-button-container">
            <button className="hindex-button-style" onClick={onhIndex}>
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
