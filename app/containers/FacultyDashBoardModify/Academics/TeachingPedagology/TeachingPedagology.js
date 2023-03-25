import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./TeachingPedagology.css";
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

const mode = [
  { id: "1", data: "Collaborative Learning " },
  { id: "2", data: "Flipped Learning" },
  { id: "3", data: "Active Learning" },
  { id: "4", data: "Context-based Learning" },
  { id: "5", data: "Cooperative Learning" },
  { id: "6", data: "Problem-based Learning " },
  { id: "7", data: "Spaced Learning" },
  { id: "8", data: "Crossover Learning - Experiencing learning" },
  { id: "9", data: "Inquiry-based Learning" },
  { id: "10", data: "Project Based Learning" },
  { id: "11", data: "Visual, Auditory, and Kinesthetic Learning" },
  { id: "12", data: "Gamification Learning" },
  { id: "13", data: "Rewarding Learner Participation" },
  { id: "14", data: "Discussion" },
  { id: "15", data: "Case Study" },
  { id: "16", data: "Concept Map" },
  { id: "17", data: "Mind Map" },
  { id: "18", data: "Retrieval Practice" },
  { id: "19", data: "Computational Thinking" },
  { id: "20", data: "Thoughtful Questions" },
  { id: "21", data: "Virtual Class" },
  { id: "22", data: "Virtual lab" },
];

export default function TeachingPedagology() {
  const [name, setName] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [method, setMethod] = useState("");
  const [Teachers, setTeachers] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallpedagologydata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setName(data[0].inputtpt1);
              setDepartment(data[0].inputtpt2);
              setSchool(data[0].inputtpt3);
              setMethod(data[0].inputtpt4);
              setTeachers(data[0].inputtpt5);
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    []
  );

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

  const inputTeachingPedagology = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    uniqueKey1: 1,
    inputtpt1: name,
    inputtpt2: department,
    inputtpt3: school,
    inputtpt4: method,
    inputtpt5: Teachers,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingTeachingPedagology(e) {
    e.preventDefault();
    const basicData = new FormData();
    // basicData.append("PedagologyFiles", valueep22, "ep22-" + valueep22.name);
    basicData.append("pedagologyobj", jsonBlob(inputTeachingPedagology));
    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch("http://localhost:8080/api/v1/pedagologydata", filesFetchMethod).then(
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

  // const [ug3Acadamic2, setUg3Acadamic2] = useState("");

  return (
    <div className="Pedagology-main-container">
      <h1 className="Pedagology-main-heading-style">Teaching Pedagology</h1>
      <div className="Pedagology-eachTable-container">
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
              <th>Type of Learning</th>
              <td>
                <input
                  placeholder="Select"
                  id="ug"
                  list="mode"
                  name="method"
                  value={method}
                  onChange={(e) => setMethod(e.target.value)}
                />
                <datalist id="mode">
                  {mode.map((eachValue) => (
                    <option
                      key={eachValue.id}
                      onChange={(e) => setMethod(e.target.value)}
                    >
                      {eachValue.data}
                    </option>
                  ))}
                </datalist>
              </td>
            </tr>

            <tr>
              <th>
                Teachers use ICT enabled tools including online resources for
                effective teaching and learning process
              </th>
              <td>
                <input
                  type="text"
                  name="Teachers"
                  value={Teachers}
                  onChange={(e) => setTeachers(e.target.value)}
                />
              </td>
            </tr>
          </table>

          <div className="Pedagology-button-container">
            <button
              className="Pedagology-button-style"
              onClick={onClickingTeachingPedagology}
            >
              Modify
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
