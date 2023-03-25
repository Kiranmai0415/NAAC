import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./CentricMethod.css";
import AuthService from "../../../Pages/Users/services/auth.service";

const centricMethods = [
  { id: "centric1", name: "ExperientialLearning" },
  { id: "centric2", name: "ParticipativeLearning" },
  { id: "centric3", name: "ProblemSolving" },
];
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

export default function CentricMethod() {
  const [name, setName] = useState("");
  const [course, setCourse] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [method, setMethod] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallcentricdata").then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setName(data[0].inputcmt1);
            setCourse(data[0].inputcmt2);
            setDepartment(data[0].inputcmt3);
            setSchool(data[0].inputcmt4);
            setMethod(data[0].inputcmt5);
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

  const inputCentricMethod = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    uniqueKey1: 1,
    inputcmt1: name,
    inputcmt2: course,
    inputcmt3: department,
    inputcmt4: school,
    inputcmt5: method,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingCentricMethods(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(JSON.stringify(inputCentricMethod));

    // basicData.append("CentricMethodFiles", valueep22, "ep22-" + valueep22.name);
    basicData.append("centricobj", jsonBlob(inputCentricMethod));

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch("http://localhost:8080/api/v1/centricdata", filesFetchMethod).then(
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
    <div className="CentricMethod-main-container">
      <h1 className="CentricMethod-main-heading-style">Centric Methods</h1>
      <div className="CentricMethod-eachTable-container">
        <form>
          <table>
            <tr>
              <th className="BI-table1-headings">
                Name of the Faculty
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="name"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Course Name</th>
              <td>
                <input
                  type="text"
                  name="course"
                  value={course}
                  onChange={(e) => setCourse(e.target.value)}
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
              <th>Centric Methods Type</th>
              <td>
                <input
                  type="text"
                  name="method"
                  list="centrics"
                  value={method}
                  onChange={(e) => setMethod(e.target.value)}
                />

                <datalist id="centrics">
                  {centricMethods.map((eachProgram) => (
                    <option
                      key={eachProgram.id}
                      onChange={(e) => setMethod(e.target.value)}
                    >
                      {eachProgram.name}
                    </option>
                  ))}
                </datalist>
              </td>
            </tr>
          </table>

          <div className="CentricMethod-button-container">
            <button
              className="CentricMethod-button-style"
              onClick={onClickingCentricMethods}
            >
              Modify
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
