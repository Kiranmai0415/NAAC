import React, { useState } from "react";
import { toast } from "react-toastify";
import "./ResearchFellows.css";
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

export default function ResearchFellows() {
  const [researchFellows, setResearchFellows] = useState({
    name: "",
    department: "",
    schools: "",
    year: "",
    duration: "",
    type: "",
    granting: "",
    qualifying: "",
  });

  // file upload
  const [valueep22, setValueep22] = useState();

  const {
    name,
    department,
    schools,
    year,
    duration,
    type,
    granting,
    qualifying,
  } = researchFellows;

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

  const inputResearchfellows = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    researchFellowsEnrolledinInstitution: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputrft1: name,
        inputrft2: department,
        inputrft3: schools,
        inputrft4: year,
        inputrft5: duration,
        inputrft6: type,
        inputrft7: granting,
        inputrft8: qualifying,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingResearchfellows(e) {
    e.preventDefault();
    console.log(JSON.stringify(inputResearchfellows));
    const reserachfellowsForm = new FormData();
    reserachfellowsForm.append(
      "reseachFellowsInfo",
      jsonBlob(inputResearchfellows)
    );
    reserachfellowsForm.append(
      "reseachFellowsFiles",
      valueep22,
      "ep22-" + valueep22.name
    );

    const researchfellowsDataMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: reserachfellowsForm,
    };
    fetch(
      resources.APPLICATION_URL+"researchfellowsData",
      researchfellowsDataMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Inserted Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }

  const handleChangeResearchFellows = (e) => {
    setResearchFellows({
      ...researchFellows,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div className="Researchfellows-container">
      <h1 className="Researchfellows-heading-style">
        Research fellows enrolled in the institution
      </h1>
      <div className="Researchfellows-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the Research fellow Name
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="name"
                  value={name}
                  onChange={handleChangeResearchFellows}
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
                  onChange={handleChangeResearchFellows}
                />
              </td>
            </tr>

            <tr>
              <th>Schools Name</th>
              <td>
                <input
                  type="text"
                  name="schools"
                  value={schools}
                  onChange={handleChangeResearchFellows}
                />
              </td>
            </tr>

            <tr>
              <th>Year of enrollment</th>
              <td>
                <input
                  type="number"
                  name="year"
                  value={year}
                  onChange={handleChangeResearchFellows}
                />
              </td>
            </tr>
            <tr>
              <th>Duration of fellowship</th>
              <td>
                <input
                  type="text"
                  name="duration"
                  value={duration}
                  onChange={handleChangeResearchFellows}
                />
              </td>
            </tr>
            <tr>
              <th>Type of the fellowship</th>
              <td>
                <input
                  type="text"
                  name="type"
                  value={type}
                  onChange={handleChangeResearchFellows}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "50%" }}>Granting agency</th>
              <td>
                <input
                  type="text"
                  name="granting"
                  value={granting}
                  onChange={handleChangeResearchFellows}
                />
              </td>
            </tr>

            <tr>
              <th> Qualifying exam if any (NET, GATE, etc.)</th>
              <td>
                <input
                  type="text"
                  name="qualifying"
                  value={qualifying}
                  onChange={handleChangeResearchFellows}
                />
              </td>
            </tr>

            <tr>
              <th style={{ width: "50%" }}>Upload the Document</th>
              <td>
                <input
                  type="file"
                  id="ep22"
                  onChange={(e) => {
                    setValueep22(e.target.files[0]);
                  }}
                />
              </td>
            </tr>
          </table>

          <div className="Researchfellows-button-container">
            <button
              className="Researchfellows-button-style"
              onClick={onClickingResearchfellows}
            >
            Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
