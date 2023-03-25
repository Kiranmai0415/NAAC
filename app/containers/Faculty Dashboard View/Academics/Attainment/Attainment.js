import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./Attainment.css";
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

export default function Attainment() {
  const [faculty, setFaculty] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [outcomes, setOutcomes] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallattainmentsdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setFaculty(data[0].attainments[0].inputat1);
              setDepartment(data[0].attainments[0].inputat2);
              setSchool(data[0].attainments[0].inputat3);
              setOutcomes(data[0].attainments[0].inputat4);
              setValueep22(
                data[0].attainmentsFileUpload[0].attainmentsFilePath
              );
              setPathValueep22(
                data[0].attainmentsFileUpload[0].attainmentsFileName
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

  const inputCentricMethod = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    attainments: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputat1: faculty,
        inputat2: department,
        inputat3: school,
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
    <div className="attainment-main-container">
      <h1 className="attainment-main-heading-style">Attainments</h1>
      <div className="attainment-eachTable-container">
        <form>
          <table>
            <tr>
              <th className="BI-table1-headings">
                Upload the Attainment Sheet
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
           
                   <a href={downloadFile(pathValueep22)}>View File</a>
              </td>
            </tr>
            <tr>
              <th>Name of the Faculty</th>
              <td>
                <input   readOnly
              
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
                <input   readOnly
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
                <input   readOnly
                  type="text"
                  name="school"
                  value={school}
                  onChange={(e) => setSchool(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Attainment of programme outcomes and course outcomes are evaluated by the institution</th>
              <td>
              <input   readOnly
                  type="text"
                  name="outcomes"
                  value={outcomes}
                  onChange={(e) => setOutcomes(e.target.value)}
                />
              </td>
            </tr>
          </table>

         
        </form>
      </div>
    </div>
  );
}
