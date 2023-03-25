import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./AwardsandRecognition.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import AwardsandRecognitionAuthorize from "./AwardsandRecognitionAuthorize";
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

export default function AwardandRecogintion() {
  const [fname, setFname] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [award, setAward] = useState("");
  const [recognize, setRecognize] = useState("");
  const [year, setYear] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallAwardsRecogdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setFname(data[0].awardsandRecognition[0].inputart1);
              setDepartment(data[0].awardsandRecognition[0].inputart2);
              setSchool(data[0].awardsandRecognition[0].inputart3);
              setAward(data[0].awardsandRecognition[0].inputart4);
              setRecognize(data[0].awardsandRecognition[0].inputart5);
              setYear(data[0].awardsandRecognition[0].inputart6);
              setValueep22(
                data[0].awardsandRecognitionFileUpload[0].awardsRecogFilePath
              );
              setPathValueep22(
                data[0].awardsandRecognitionFileUpload[0].awardsRecogFileName
              );
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
  const inputAwardandRecogintion = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    awardsandRecognition: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputart1: fname,
        inputart2: department,
        inputart3: school,
        inputart4: award,
        inputart5: recognize,
        inputart6: year,
      },
    ],
  };

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


  return (
    <div className="Awards-container">
      <h1 className="Awards-heading-style">
        Awards and Recognition (Research)
      </h1>
      <div className="Awards-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the activity
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="fname"
                  value={fname}
                  onChange={(e) => setFname(e.target.value)}
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
              <th>Name of the Award/ recognition</th>
              <td>
                <input
                  type="text"
                  name="award"
                  value={award}
                  onChange={(e) => setAward(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Name of the Awarding government/ government recognized bodies
              </th>
              <td>
                <input
                  type="text"
                  name="recognize"
                  value={recognize}
                  onChange={(e) => setRecognize(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Year of award</th>
              <td>
                <input
                  type="text"
                  name="year"
                  value={year}
                  onChange={(e) => setYear(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "50%" }}>Upload the Document</th>
              <td>
              <a href={downloadFile(pathValueep22)}>View File</a>
              </td>
            </tr>
          </table>
        </form>
        <AwardsandRecognitionAuthorize />
      </div>
    </div>
  );
}
