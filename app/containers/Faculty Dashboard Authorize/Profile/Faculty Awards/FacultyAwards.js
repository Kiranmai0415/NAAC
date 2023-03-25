import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./FacultyAwards.css";
import AuthService from "../../../Pages/Users/services/auth.service";
import FacultyAwardsAuthorize from "./FacultyAwardsAuthorize";
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

export default function FacultyAwards() {
  const [awards, setAwards] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [pan, setPan] = useState("");
  const [designation, setDesignation] = useState("");
  const [incentives, setIncentives] = useState("");
  const [fellowship, setFellowship] = useState("");
  const [link, setLink] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");
  const [yearQ, setYearQ] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallFacultyAwardsdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setAwards(data[0].facultyAwards[0].inputfat1);
              setDepartment(data[0].facultyAwards[0].inputfat2);
              setSchool(data[0].facultyAwards[0].inputfat3);
              setPan(data[0].facultyAwards[0].inputfat4);
              setDesignation(data[0].facultyAwards[0].inputfat5);
              setIncentives(data[0].facultyAwards[0].inputfat6);
              setFellowship(data[0].facultyAwards[0].inputfat7);
              setLink(data[0].facultyAwards[0].inputfat8);
              setYearQ(data[0].facultyAwards[0].inputfat9);
              setValueep22(
                data[0].facultyAwardsFileUpload[0].facultyAwardsFilePath
              );
              setPathValueep22(
                data[0].facultyAwardsFileUpload[0].facultyAwardsFileName
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
  const inputFacultyAwards = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    facultyAwards: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputfat1: awards,
        inputfat2: department,
        inputfat3: school,
        inputfat4: pan,
        inputfat5: designation,
        inputfat6: incentives,
        inputfat7: fellowship,
        inputfat8: link,
        inputfat9: yearQ,
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
    <div className="facultyawards-container">
      <h1 className="facultyawards-heading-style">Faculty Awards</h1>
      <div className="facultyawardseachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of full time teachers receiving awards from state level,
                national level, international level
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input   readOnly
                  type="text"
                  name="awards"
                  value={awards}
                  onChange={(e) => setAwards(e.target.value)}
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
              <th>Year</th>
              <td>
                <input   readOnly
                  type="text"
                  name="yearQ"
                  value={yearQ}
                  onChange={(e) => setYearQ(e.target.value)}
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
              <th>PAN</th>
              <td>
                <input   readOnly
                  type="text"
                  name="pan"
                  value={pan}
                  onChange={(e) => setPan(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Designation</th>
              <td>
                <input   readOnly
                  type="text"
                  name="designation"
                  value={designation}
                  onChange={(e) => setDesignation(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Incentives/Type of the incentive given by the HEI in recognition
                of the award
              </th>
              <td>
                <input   readOnly
                  type="text"
                  name="incentives"
                  value={incentives}
                  onChange={(e) => setIncentives(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Name of the award, fellowship, received from Government or
                Government recognized bodies
              </th>
              <td>
                <input   readOnly
                  type="text"
                  name="fellowship"
                  value={fellowship}
                  onChange={(e) => setFellowship(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Link to the relevant documents</th>
              <td>
                <input   readOnly
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
        <FacultyAwardsAuthorize />
      </div>
    </div>
  );
}
