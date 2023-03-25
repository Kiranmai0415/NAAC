import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./FellowShip.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import FellowshipsAuthorize from "./FellowshipsAuthorize";
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
export default function Fellowship() {
  const [teacher, setTeacher] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [award, setAward] = useState("");
  const [year, setYear] = useState("");
  const [agency, setAgency] = useState("");
  const [link, setLink] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallfellowshipdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setTeacher(data[0].fellowship[0].inputft1);
              setDepartment(data[0].fellowship[0].inputft2);
              setSchool(data[0].fellowship[0].inputft3);
              setAward(data[0].fellowship[0].inputft4);
              setYear(data[0].fellowship[0].inputft5);
              setAgency(data[0].fellowship[0].inputft6);
              setLink(data[0].fellowship[0].inputft7);
              setValueep22(data[0].fellowshipFileUpload[0].fellowshipFilePath);
              setPathValueep22(data[0].fellowshipFileUpload[0].fellowshipFileName);
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
  const inputFellowship = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    fellowship: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        inputft1: teacher,
        inputft2: department,
        inputft3: school,
        inputft4: award,
        inputft5: year,
        inputft6: agency,
        inputft7: link,
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
    <div className="FellowShip-container">
      <h1 className="FellowShip-heading-style">Fellowship</h1>
      <div className="FellowShip-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the teacher awarded national/ international
                fellowship/financial support
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="teacher"
                  value={teacher}
                  onChange={(e) => setTeacher(e.target.value)}
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
              <th>Name of the award/fellowship</th>
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
              <th>Year of Award</th>
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
              <th>Awarding Agency</th>
              <td>
                <input
                  type="text"
                  name="agency"
                  value={agency}
                  onChange={(e) => setAgency(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Link to certificates (University)</th>
              <td>
                <input
                  type="text"
                  name="link"
                  value={link}
                  onChange={(e) => setLink(e.target.value)}
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
        <FellowshipsAuthorize />
      </div>
    </div>
  );
}
