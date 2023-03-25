import React, { useEffect, useState } from "react";

import { toast } from "react-toastify";
import "./Hindex.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
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
  const [faculty, setFaculty] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [scholar, setScholar] = useState("");
  const [scopus, setScopus] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallhindexdata").then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setFaculty(data[0].inputhit1);
            setDepartment(data[0].inputhit2);
            setSchool(data[0].inputhit3);
            setScholar(data[0].inputhit4);
            setScopus(data[0].inputhit5);
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );

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

    hindexobj: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputhit1: faculty,
        inputhit2: department,
        inputhit3: school,
        inputhit4: scholar,
        inputhit5: scopus,
      },
    ],
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

    fetch("http://localhost:8080/api/v1/hindexdata", filesFetchMethod).then(
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
                  onChange={(e) => setFaculty(e.target.value)}
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
                  onChange={(e) => setDepartment(e.target.value)}
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
                  onChange={(e) => setSchool(e.target.value)}
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
                  onChange={(e) => setScholar(e.target.value)}
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
                  onChange={(e) => setScopus(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <div className="hindex-button-container">
            <button className="hindex-button-style" onClick={onhIndex}>
              Modify
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
