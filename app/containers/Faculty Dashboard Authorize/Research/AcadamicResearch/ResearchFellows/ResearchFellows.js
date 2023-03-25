import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./ResearchFellows.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import ResearchFellowsAuthorize from "./ResearchFellowsAuthorize";
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

export default function ResearchFellows() {
  const [name, setName] = useState("");
  const [department, setDepartment] = useState("");
  const [schools, setSchools] = useState("");
  const [year, setYear] = useState("");
  const [duration, setDuration] = useState("");
  const [type, setType] = useState("");
  const [granting, setGranting] = useState("");
  const [qualifying, setQualifying] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getresearchfellowsdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setName(
                data[0].researchFellowsEnrolledinInstitution[0].inputrft1
              );
              setDepartment(
                data[0].researchFellowsEnrolledinInstitution[0].inputrft2
              );
              setSchools(
                data[0].researchFellowsEnrolledinInstitution[0].inputrft3
              );
              setYear(
                data[0].researchFellowsEnrolledinInstitution[0].inputrft4
              );
              setDuration(
                data[0].researchFellowsEnrolledinInstitution[0].inputrft5
              );
              setType(
                data[0].researchFellowsEnrolledinInstitution[0].inputrft6
              );
              setGranting(
                data[0].researchFellowsEnrolledinInstitution[0].inputrft7
              );
              setQualifying(
                data[0].researchFellowsEnrolledinInstitution[0].inputrft8
              );

              setValueep22(
                data[0].researchFellowsEnrolledinInstitutionFileUpload[0]
                  .researchFellowEnrolinInstituteFilePath
              );
              setPathValueep22(
                data[0].researchFellowsEnrolledinInstitutionFileUpload[0]
                  .researchFellowEnrolinInstituteFileName
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
  const inputResearchfellows = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    researchFellowsEnrolledinInstitution: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputrft1: name,
        inputrft2: department,
        inputrft3: schools,
        inputrft4: year,
        inputrft5: duration,
        inputrft6: type,
        inputrft7: granting,
        inputrft8: qualifying,
      },
    ],
  };

  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }

  return (
    <div className="Researchfellows-container">
      <h1 className="Researchfellows-heading-style">
        Research fellows enrolled in the institution
      </h1>
      <div className="Researchfellows-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the Research fellow Name
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
                  name="schools"
                  value={schools}
                  onChange={(e) => setSchools(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Year of enrollment</th>
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
              <th>Duration of fellowship</th>
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
              <th>Type of the fellowship</th>
              <td>
                <input
                  type="text"
                  name="type"
                  value={type}
                  onChange={(e) => setType(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "50%" }}>Granting agency</th>
              <td>
                <input
                  type="text"
                  name="granting"
                  value={granting}
                  onChange={(e) => setGranting(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th> Qualifying exam if any (NET, GATE, etc.)</th>
              <td>
                <input
                  type="text"
                  name="qualifying"
                  value={qualifying}
                  onChange={(e) => setQualifying(e.target.value)}
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
        <ResearchFellowsAuthorize />
      </div>
    </div>
  );
}
