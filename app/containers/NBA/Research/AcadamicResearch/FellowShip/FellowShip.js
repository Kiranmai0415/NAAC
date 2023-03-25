import React, { useState } from "react";
import { toast } from "react-toastify";
import "./FellowShip.css";
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
export default function Fellowship() {
  const [valueep22, setValueep22] = useState();
  const [fellowship, setFellowship] = useState({
    teacher: "",
    department: "",
    school: "",
    award: "",
    year: "",
    agency: "",
    link: "",
  });

  const { teacher, award, year, agency, link, department, school } = fellowship;

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

  const inputFellowship = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    fellowship: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        inputft1: teacher,
        inputft2: department,
        inputft3: school,
        inputft4: award,
        inputft5: year,
        inputft6: agency,
        inputft7: link,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingFellowship(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(JSON.stringify(inputFellowship));
    basicData.append("fellowship", jsonBlob(inputFellowship));
    basicData.append("fellowshipFiles", valueep22, "ep22-" + valueep22.name);
    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(resources.APPLICATION_URL+"fellowshipData", filesFetchMethod).then(
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

  const FellowHandleChange = (e) => {
    setFellowship({
      ...fellowship,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div className="FellowShip-container">
      <h1 className="FellowShip-heading-style">Fellowship</h1>
      <div className="FellowShip-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the teacher awarded national/ international
                fellowship/financial support
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="teacher"
                  value={teacher}
                  onChange={FellowHandleChange}
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
                  onChange={FellowHandleChange}
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
                  onChange={FellowHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Name of the award/fellowship</th>
              <td>
                <input
                  type="text"
                  name="award"
                  value={award}
                  onChange={FellowHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Year of Award</th>
              <td>
                <input
                  type="number"
                  name="year"
                  value={year}
                  onChange={FellowHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Awarding Agency</th>
              <td>
                <input
                  type="text"
                  name="agency"
                  value={agency}
                  onChange={FellowHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Link to certificates (University)</th>
              <td>
                <input
                  type="text"
                  name="link"
                  value={link}
                  onChange={FellowHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "50%" }}>Upload the Document</th>
              <td>
                <input
                  type="file"
                  id="ep22"
                  name="valueep22"
                  onChange={(e) => {
                    setValueep22(e.target.files[0]);
                  }}
                />
              </td>
            </tr>
          </table>
          <div className="fellowship-button-container">
            <button
              className="fellowship-button-style"
              onClick={onClickingFellowship}
            >
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
