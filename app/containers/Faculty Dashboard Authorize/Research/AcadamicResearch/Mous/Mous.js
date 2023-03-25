import React, { useEffect, useState } from "react";

import { toast } from "react-toastify";
import "./Mous.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import MousAuthorize from "./MousAuthorize";
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

export default function Mous() {
  const [institution, setInstitution] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [collaboration, setCollaboration] = useState("");
  const [year, setYear] = useState("");
  const [duration, setDuration] = useState("");
  const [activities, setActivities] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallmousdata").then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setInstitution(data[0].mous[0].inputmt1);
            setDepartment(data[0].mous[0].inputmt2);
            setSchool(data[0].mous[0].inputmt3);
            setCollaboration(data[0].mous[0].inputmt4);
            setYear(data[0].mous[0].inputmt5);
            setDuration(data[0].mous[0].inputmt6);
            setActivities(data[0].mous[0].inputmt7);

            setValueep22(data[0].mousFileUpload[0].mousFilePath);
            setPathValueep22(data[0].mousFileUpload[0].mousFileName);
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
  const inputMous = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    mous: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputmt1: institution,
        inputmt2: department,
        inputmt3: school,
        inputmt4: collaboration,
        inputmt5: year,
        inputmt6: duration,
        inputmt7: activities,
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
    <div className="mous-container">
      <h1 className="mous-heading-style">MoUs</h1>
      <div className="mous-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <span style={{ color: "red" }}>*</span>
            <tr>
              <th>
                Name of the Organization/ Institution/ Industry with whom MoU is
                signed (U) Organization with which MoU is signed (AU)
                Organization with which MoU is signed (AF)
              </th>
              <td>
                <input
                  type="text"
                  name="institution"
                  value={institution}
                  onChange={(e) => setInstitution(e.target.value)}
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
              <th>
                Name of the institution/ industry/ corporate house (AU) Name of
                the collaborating agency / institution / industry / corporate
                house with whom the MoU / collaboration / linkage is made, with
                contact details (AF)
              </th>
              <td>
                <input
                  type="text"
                  name="collaboration"
                  value={collaboration}
                  onChange={(e) => setCollaboration(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Year of signing MoU (U & AU) Year of signing MoU / collaboration
                / linkage (AF)
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
              <th>
                Duration of MoU (U&AU) Duration of MoU / collaboration / linkage
                (AF)
              </th>
              <td>
                <input
                  type="text"
                  name="duration"
                  value={duration}
                  onChange={(e) => setDuration(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>List the actual activities under each MOU year wise</th>
              <td>
                <input
                  type="text"
                  name="activities"
                  value={activities}
                  onChange={(e) => setActivities(e.target.value)}
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
        <MousAuthorize />
      </div>
    </div>
  );
}
