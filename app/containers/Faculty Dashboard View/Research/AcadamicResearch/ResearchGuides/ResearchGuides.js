import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./ResearchGuides.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import { resources } from "../../../../appConstants";
const options = [
  { id: "OPT1", options: "Yes" },
  { id: "OPT2", options: "No" },
];

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

export default function ResearchGuides() {
  const [teacher, setTeacher] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [qualification, setQualification] = useState("");
  const [guide, setGuide] = useState("");
  const [year, setYear] = useState("");
  const [service, setService] = useState("");
  const [scholar, setScholor] = useState("");
  const [registration, setRegistration] = useState("");
  const [allotletter, setAllotletter] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
   const [pathValueep22, setPathValueep22] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallresearchguidesdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setTeacher(data[0].researchGuides[0].inputrgt1);
              setDepartment(data[0].researchGuides[0].inputrgt2);
              setSchool(data[0].researchGuides[0].inputrgt3);
              setQualification(data[0].researchGuides[0].inputrgt4);
              setGuide(data[0].researchGuides[0].inputrgt5);
              setYear(data[0].researchGuides[0].inputrgt6);
              setService(data[0].researchGuides[0].inputrgt7);
              setScholor(data[0].researchGuides[0].inputrgt8);
              setRegistration(data[0].researchGuides[0].inputrgt9);
              setAllotletter(data[0].researchGuides[0].inputrgt10);
              setValueep22(
                data[0].researchGuideFileUpload[0].researchGuideFilePath
              );
                setPathValueep22(
                  data[0].researchGuideFileUpload[0].researchGuideFileName
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

  const inputResearchGuides = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    researchGuides: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputrgt1: teacher,
        inputrgt2: department,
        inputrgt3: school,
        inputrgt4: qualification,
        inputrgt5: guide,
        inputrgt6: year,
        inputrgt7: service,
        inputrgt8: scholar,
        inputrgt9: registration,
        inputrgt10: allotletter,
      },
    ],
  };

  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }


  return (
    <div className="Research-container">
      <h1 className="Research-heading-style">Research Guides</h1>
      <div className="Research-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of full time teacher with Ph.D./D.M/M.Ch./D.N.B
                Superspeciality/D.Sc./D’Lit.
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input   readOnly
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
              <th>
                Qualification (Ph.D./D.M/M.Ch./D.N.B
                Superspeciality/D.Sc./D’Lit. ) and Year of obtaining
              </th>
              <td>
                <input   readOnly
                  type="text"
                  name="qualification"
                  value={qualification}
                  onChange={(e) => setQualification(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Whether recognised as research Guide for Ph.D./D.M/M.Ch./D.N.B
                Superspeciality/D.Sc./D’Lit.
              </th>
              <td>
                <input   readOnly
                  type="text"
                  name="guide"
                  value={guide}
                  onChange={(e) => setGuide(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Year of Recognition as Research Guide</th>
              <td>
                <input   readOnly
                  type="text"
                  name="year"
                  value={year}
                  onChange={(e) => setYear(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Is the teacher still serving in the institution/If not, last
                year of the service of Faculty in the Institution
              </th>
              <td>
                <input   readOnly
                  placeholder="Select Yes or No"
                  required="required"
                  className="nba-input-head"
                  id="naacYearH1id"
                  list="options"
                  name={service}
                  value={service}
                  onChange={(e) => setService(e.target.value)}
                />
                <datalist id="options">
                  {options.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => setService(e.target.value)}
                    >
                      {eachOptions.options}
                    </option>
                  ))}
                </datalist>
              </td>
            </tr>
            <tr>
              <th>Name of the Research scholar</th>
              <td>
                <input   readOnly
                  type="text"
                  name="scholar"
                  value={scholar}
                  onChange={(e) => setScholor(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Year of registration of the scholar</th>
              <td>
                <input   readOnly
                  type="text"
                  name="registration"
                  value={registration}
                  onChange={(e) => setRegistration(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Guide allotment letter web link to be provided</th>
              <td>
                <input   readOnly
                  type="text"
                  name="allotletter"
                  value={allotletter}
                  onChange={(e) => setAllotletter(e.target.value)}
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
      </div>
    </div>
  );
}
