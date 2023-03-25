import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./Professional.css";
import AuthService from "../../../Pages/Users/services/auth.service";
import ProfessionalAuthorize from "./ProfessionalAuthorize";
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

export default function Professional() {
  const [year, setYear] = useState("");
  const [dates, setDates] = useState("");
  const [titleoftheprofessional, setTitleoftheProfession] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [noofparticipants, setNoofparticipants] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch(
        "http://localhost:8080/api/v1/getallprofessionalDevelopmentdata"
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setYear(data[0].professionalDevelopmentProgrammes[0].inputpdt1);
            setDates(data[0].professionalDevelopmentProgrammes[0].inputpdt2);
            setTitleoftheProfession(
              data[0].professionalDevelopmentProgrammes[0].inputpdt3
            );
            setDepartment(
              data[0].professionalDevelopmentProgrammes[0].inputpdt4
            );
            setSchool(data[0].professionalDevelopmentProgrammes[0].inputpdt5);
            setNoofparticipants(
              data[0].professionalDevelopmentProgrammes[0].inputpdt6
            );
            setValueep22(
              data[0].professionalDevelopmentProgrammesFileUpload[0]
                .professionalDevelopmentProgmFilePath
            );
            setPathValueep22(
              data[0].professionalDevelopmentProgrammesFileUpload[0]
                .professionalDevelopmentProgmFileName
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
  const inputProfessional = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    professionalDevelopmentProgrammes: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputpdt1: year,
        inputpdt2: dates,
        inputpdt3: titleoftheprofessional,
        inputpdt4: department,
        inputpdt5: school,
        inputpdt6: noofparticipants,
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
    <div>
      <div className="professional-container">
        <h1 className="professional-heading-style">
          Number of professional development / administrative training
          Programmes
        </h1>
        <div className="professional-eachTable-container">
          <form>
            <table>
              <tr>
                <th className="BI-table1-headings">
                  Year
                  <span style={{ color: "red" }}>*</span>
                </th>
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
                <th>Dates (from-to) (DD-MM-YYYY)</th>
                <td>
                  <input
                    type="date"
                    name="dates"
                    value={dates}
                    onChange={(e) => setDates(e.target.value)}
                  />
                </td>
              </tr>
              <tr>
                <th>
                  Title of the professional/ administrative development program
                  organized for the teaching staff/ non-teaching staff
                </th>
                <td>
                  <input
                    type="text"
                    name="titleoftheprofessional"
                    value={titleoftheprofessional}
                    onChange={(e) => setTitleoftheProfession(e.target.value)}
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
                <th>No. of participants</th>
                <td>
                  <input
                    type="number"
                    name="noofparticipants"
                    value={noofparticipants}
                    onChange={(e) => setNoofparticipants(e.target.value)}
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
          <ProfessionalAuthorize />
        </div>
      </div>
    </div>
  );
}
