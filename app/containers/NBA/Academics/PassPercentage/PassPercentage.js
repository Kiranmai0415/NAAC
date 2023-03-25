import React, { useState } from "react";
import "./PassPercentage.css";
import { toast } from "react-toastify";
import AuthService from "../../../Pages/Users/services/auth.service";

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
export default function PassPercentage() {
  const [passPercentage, setPassPercentage] = useState({
    program: "",
    pname: "",
    department: "",
    school: "",
    number: "",
    numberofstd: "",
    year: "",
    totalNumStu: "",
    totalNumFullStu: "",
    totalNumPartStu: "",
    phdFullStudents: "",
    phdPartStudents: "",
  });

  // file upload
  const [valueep22, setValueep22] = useState();

  const {
    program,
    pname,
    department,
    school,
    number,
    numberofstd,
    year,
    totalNumStu,
    totalNumFullStu,
    totalNumPartStu,
    phdPartStudents,
    phdFullStudents,
  } = passPercentage;

  console.log("object====>" + JSON.stringify(AuthService.getCurrentUser()));
  let instituteType = AuthService.getCurrentUser().instituteType;
  console.log("instituteType====>" + instituteType);
  const d = new Date();
  let currYear = d.getFullYear();
  console.log("var====>" + currYear);
  let fYear = parseInt(currYear) - 1 + "-" + currYear;
  console.log("current year==" + fYear);
  const collegeId = AuthService.getCurrentUser().collegeId;
  console.log("collegeId==========>" + collegeId);

  const inputPassPercentage = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    passPercentofStudents: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputpst1: program,
        inputpst2: pname,
        inputpst3: department,
        inputpst4: school,
        inputpst5: number,
        inputpst6: numberofstd,
        inputpst7: year,

        inputpst8: totalNumStu,
        inputpst9: totalNumFullStu,
        inputpst10: totalNumPartStu,
        inputpst11: phdFullStudents,
        inputpst12: phdPartStudents,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingPassPercentage(e) {
    e.preventDefault();
    const basicData = new FormData();
    basicData.append("passPercentobj", jsonBlob(inputPassPercentage));
    basicData.append("passPercentFiles", valueep22, "ep22-" + valueep22.name);

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(
      "http://localhost:8080/api/v1/passPercentData",
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

  const handleChangePassPercentage = (e) => {
    setPassPercentage({
      ...passPercentage,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div className="passpercentage-container">
      <h1 className="passpercentage-heading-style">
        PassPercentage % of students
      </h1>
      <div className="passpercentage-eachTable-container">
        <form>
          <table>
            <tr>
              <th className="BI-table1-headings">
                Program Code
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="program"
                  value={program}
                  onChange={handleChangePassPercentage}
                />
              </td>
            </tr>
            <tr>
              <th>Program Name</th>
              <td>
                <input
                  type="text"
                  name="pname"
                  value={pname}
                  onChange={handleChangePassPercentage}
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
                  onChange={handleChangePassPercentage}
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
                  onChange={handleChangePassPercentage}
                />
              </td>
            </tr>

            <tr>
              <th> Total No.of Students</th>
              <td>
                <input
                  type="number"
                  name="totalNumStu"
                  value={totalNumStu}
                  onChange={handleChangePassPercentage}
                />
              </td>
            </tr>

            <tr>
              <th> Total No.of Full time Students</th>
              <td>
                <input
                  type="number"
                  name="totalNumFullStu"
                  value={totalNumFullStu}
                  onChange={handleChangePassPercentage}
                />
              </td>
            </tr>

            <tr>
              <th> Total No.of Part time Students</th>
              <td>
                <input
                  type="number"
                  name="totalNumPartStu"
                  value={totalNumPartStu}
                  onChange={handleChangePassPercentage}
                />
              </td>
            </tr>

            <tr>
              <th>
                No.of Full Time Ph.D Students Graduated/Awarded (Included
                Integrated Ph.D)
              </th>
              <td>
                <input
                  type="number"
                  name="phdFullStudents"
                  value={phdFullStudents}
                  onChange={handleChangePassPercentage}
                />
              </td>
            </tr>
            <tr>
              <th>
                No.of Part Time Ph.D Students Graduated/Awarded (Included
                Integrated Ph.D)
              </th>
              <td>
                <input
                  type="number"
                  name="phdPartStudents"
                  value={phdPartStudents}
                  onChange={handleChangePassPercentage}
                />
              </td>
            </tr>

            <tr>
              <th>
                Total number of final year students who passed the examination
                conducted by Institution
              </th>
              <td>
                <input
                  type="number"
                  name="number"
                  value={number}
                  onChange={handleChangePassPercentage}
                />
              </td>
            </tr>
            <tr>
              <th>
                Total number of final year students who attended the examination
                conducted by Institution.
              </th>
              <td>
                <input
                  type="number"
                  name="numberofstd"
                  value={numberofstd}
                  onChange={handleChangePassPercentage}
                />
              </td>
            </tr>

            <tr>
              <th>Year (AF)</th>
              <td>
                <input
                  type="number"
                  name="year"
                  value={year}
                  onChange={handleChangePassPercentage}
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
          <div className="PassPercentage-button-container">
            <button
              className="PassPercentage-button-style"
              onClick={onClickingPassPercentage}
            >
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
