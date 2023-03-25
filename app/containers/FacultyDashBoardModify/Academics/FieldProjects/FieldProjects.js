import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./FieldProjects.css";
import AuthService from "../../../Pages/Users/services/auth.service";
import { resources } from "../../../appConstants";
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
  const [programCode, setProgramcode] = useState("");
  const [programName, setProgramname] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [student, setStudent] = useState("");
  const [Relevantdocument, setRelevantdocument] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [pathValueep22Display, setPathValueep22Display] = useState("");

  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");
  const [undertaking, setundertaking] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallFieldInternsdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setProgramcode(
                data[0].fieldorResearchProjectsInternships[0].inputfrit1
              );
              setProgramname(
                data[0].fieldorResearchProjectsInternships[0].inputfrit2
              );
              setDepartment(
                data[0].fieldorResearchProjectsInternships[0].inputfrit3
              );
              setSchool(
                data[0].fieldorResearchProjectsInternships[0].inputfrit4
              );
              setStudent(
                data[0].fieldorResearchProjectsInternships[0].inputfrit5
              );
              setRelevantdocument(
                data[0].fieldorResearchProjectsInternships[0].inputfrit6
              );
              setundertaking(
                data[0].fieldorResearchProjectsInternships[0].inputfrit7
              );
              setValueep22(
                data[0].fieldorResearchProjectsInternshipsFileUpload[0]
                  .fieldResearchProjInternsFilePath
              );
              setPathValueep22Display(
                  data[0].fieldorResearchProjectsInternshipsFileUpload[0]
                    .fieldResearchProjInternsFileName
                );
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    []
  );
  console.log|(filePreviewSrc111f1);
  console.log(valueep22);
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

  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }

  function onClickingFieldProject(e) {
    e.preventDefault();
    console.log(JSON.stringify(inputFieldProjectsDataList));
    const patentForm = new FormData();
    if(pathValueep22 !== ""){
      console.log("path is",pathValueep22);
      patentForm.append("fieldInternsFiles", valueep22, "ep22-" + valueep22.name);

    }
    patentForm.append("fieldInternsobj", jsonBlob(inputFieldProjectsDataList));

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

  function showFilePreview(e) {
    const selectedFile = e.target.files[0];
    if (selectedFile) {
      const fileReader = new FileReader();
      fileReader.readAsDataURL(selectedFile);
      fileReader.addEventListener("load", (event) => {
        setFilePreviewSrc111f1(event.target.result);
      });
    }
  }

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
                  onChange={(e) => setProgramcode(e.target.value)}
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
                  onChange={(e) => setProgramname(e.target.value)}
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
                  onChange={(e) => setDepartment(e.target.value)}
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
                  onChange={(e) => setSchool(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th> Total No.of the students</th>
              <td>
                <input
                  type="number"
                  id=""
                  name="student"
                  value={student}
                  onChange={(e) => setStudent(e.target.value)}
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
                  onChange={(e) => setundertaking(e.target.value)}
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
                  onChange={(e) => setRelevantdocument(e.target.value)}
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
                    setPathValueep22(e.target.value);
                    showFilePreview(e);
                  }}
                />
                {pathValueep22Display === "" ? null : (
                  <div className="fileButtons-container">
                    <button className="viewFileButton-style">
                      <a target="_openfile" href={downloadFile(pathValueep22Display)}>{pathValueep22Display}
                      </a>
                    </button>
                    <button className="removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )}
              </td>
            </tr>
          </table>
          <div className="filedprojects-button-container">
            <button
              className="filedprojects-button-style"
              onClick={onClickingFieldProject}
            >
              Modify
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
