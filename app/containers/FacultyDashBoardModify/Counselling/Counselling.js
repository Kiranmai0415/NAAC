import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./Counselling.css";
import AuthService from "../../Pages/Users/services/auth.service";
import { resources } from "../../appConstants";

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

export default function Counselling() {
  const [year, setYear] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [noofstudents, setNoofstudents] = useState("");
  const [nooffaculty, setNooffaculty] = useState("");
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState();
  const [pathValueep22Display, setPathValueep22Display] = useState("");

  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallstudentMentorData").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setYear(data[0].studentMentorRatio[0].inputsmt1);
              setDepartment(data[0].studentMentorRatio[0].inputsmt2);
              setSchool(data[0].studentMentorRatio[0].inputsmt3);
              setNoofstudents(data[0].studentMentorRatio[0].inputsmt4);
              setNooffaculty(data[0].studentMentorRatio[0].inputsmt5);
              setValueep22(
                data[0].studentMentorRatioFileUppload[0].studentMentorFilePath
              );
              setPathValueep22Display(
                data[0].studentMentorRatioFileUppload[0]
                  .studentMentorFileName
              );
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    []
  );

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

  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }


  console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
  let instituteType = AuthService.getCurrentUser().instituteType;
  console.log("instituteType=======>" + instituteType);
  const collegeId = AuthService.getCurrentUser().collegeId;
  console.log("collegeId==========>" + collegeId);
  const d = new Date();
  let currYear = d.getFullYear();
  console.log("var ==>" + currYear);
  let fYear = parseInt(currYear) - 1 + "-" + currYear;
  console.log("current year==" + fYear);

  const inputStudentMentor = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    studentMentorRatio: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputsmt1: year,
        inputsmt2: department,
        inputsmt3: school,
        inputsmt4: noofstudents,
        inputsmt5: nooffaculty,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingStudentMentor(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(JSON.stringify(inputStudentMentor));
    basicData.append("studentMentorobj", jsonBlob(inputStudentMentor));

    if (pathValueep22 !== "") {
      basicData.append( "studentMentoruploadfile",valueep22,  "ep22-" + valueep22.name
      );
    }
   

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
      "http://localhost:8080/api/v1/studentMentorData",
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

  return (
    <div className="Counselling-main-container">
      <h1 className="Counselling-main-heading-style">Student - Mentor Ratio</h1>
      <div className="Counselling-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Year
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="number"
                  name="year"
                  value={year}
                  onChange={(e) => setYear(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th className="BI-table1-headings">
                Department
                <span style={{ color: "red" }}>*</span>
              </th>
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
              <th className="BI-table1-headings">
                Schools Name
                <span style={{ color: "red" }}>*</span>
              </th>
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
              <th>No.of Students to Mentors</th>
              <td>
                <input
                  type="number"
                  name="noofstudents"
                  value={noofstudents}
                  onChange={(e) => setNoofstudents(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Total No. of Mentors</th>
              <td>
                <input
                  type="number"
                  name="nooffaculty"
                  value={nooffaculty}
                  onChange={(e) => setNooffaculty(e.target.value)}
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
                    setPathValueep22(e.target.value);
                    showFilePreview(e);
                  }}
                  accept="./pdf"
                />

                {pathValueep22Display === "" ? null : (
                  <div className="c12-fileButtons-container">
                     <a target="_openfile" href={downloadFile(pathValueep22Display)}>{pathValueep22Display}
                     </a>
                    {/* <button className="c12-viewFileButton-style">
                    </button>
                       */}
                      
                    
                    <button className="removeFileButton-style">
                      Remove File
                    </button>
                    {/* <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValueep22("");
                        document.getElementById("ep22").value = "";
                      }}
                    >
                      Remove File
                    </button> */}
                  </div>
                )}
              </td>
            </tr>
          </table>
          <div className="Counselling-button-container">
            <button
              className="Counselling-button-style"
              onClick={onClickingStudentMentor}
            >
             Modify
            </button>
          </div>
        </form>
    
      </div>
    </div>
  );
}
