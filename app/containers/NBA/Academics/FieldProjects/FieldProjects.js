import React, { useState } from "react";
import { toast } from "react-toastify";
import "./FieldProjects.css";
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

export default function FieldProjects() {
  const [filedProjects, setFieldProjects] = useState({
    programCode: "",
    programName: "",
    department: "",
    school: "",
    student: "",
    Relevantdocument: "",
    undertaking: "",
  });
  // file upload
  const [valueep22, setValueep22] = useState();

  const {
    programCode,
    programName,
    department,
    school,
    student,
    Relevantdocument,
    undertaking,
  } = filedProjects;

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

  const inputFieldProjectsDataList = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    fieldorResearchProjectsInternships: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputfrit1: programCode,
        inputfrit2: programName,
        inputfrit3: department,
        inputfrit4: school,
        inputfrit5: student,
        inputfrit6: Relevantdocument,
        inputfrit7: undertaking,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingFieldProject(e) {
    e.preventDefault();
    console.log(JSON.stringify(inputFieldProjectsDataList));
    const patentForm = new FormData();
    patentForm.append("fieldInternsobj", jsonBlob(inputFieldProjectsDataList));
    patentForm.append("fieldInternsFiles", valueep22, "ep22-" + valueep22.name);

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: patentForm,
    };
    fetch(
      "http://localhost:8080/api/v1/fieldResearchData",
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

  const handleChangefieldProject = (e) => {
    setFieldProjects({
      ...filedProjects,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div className="field-container">
      <h1 className="field-heading-style">
        Field projects / Research projects / Internships
      </h1>
      <div className="field-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Program Code
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  id=""
                  name="programCode"
                  value={programCode}
                  onChange={handleChangefieldProject}
                />
              </td>
            </tr>
            <tr>
              <th>Programme name</th>
              <td>
                <input
                  type="text"
                  id=""
                  name="programName"
                  value={programName}
                  onChange={handleChangefieldProject}
                />
              </td>
            </tr>
            <tr>
              <th>Department</th>
              <td>
                <input
                  type="text"
                  id=""
                  name="department"
                  value={department}
                  onChange={handleChangefieldProject}
                />
              </td>
            </tr>
            <tr>
              <th>Schools Name</th>
              <td>
                <input
                  type="text"
                  id=""
                  name="school"
                  value={school}
                  onChange={handleChangefieldProject}
                />
              </td>
            </tr>
            <tr>
              <th>Total No.of the students</th>
              <td>
                <input
                  type="number"
                  id=""
                  name="student"
                  value={student}
                  onChange={handleChangefieldProject}
                />
              </td>
            </tr>

            <tr>
              <th>
                Total No.of Students undertaking Field
                Projects/Internships/students
              </th>
              <td>
                <input
                  type="number"
                  id=""
                  name="undertaking"
                  value={undertaking}
                  onChange={handleChangefieldProject}
                />
              </td>
            </tr>

            <tr>
              <th>Link to the relevant document</th>

              <td>
                <input
                  type="text"
                  id=""
                  name="Relevantdocument"
                  value={Relevantdocument}
                  onChange={handleChangefieldProject}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "50%" }}>Upload the Document</th>
              <td>
                <input
                  type="file"
                  id=""
                  onChange={(e) => {
                    setValueep22(e.target.files[0]);
                  }}
                />
              </td>
            </tr>
          </table>
          <div className="filedprojects-button-container">
            <button
              className="filedprojects-button-style"
              onClick={onClickingFieldProject}
            >
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
