import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./PercentageFullTimeTeacher.css";
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

export default function PercentageFullTimeTeacher() {
  const [teacher, setTeacher] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [qualification, setQualification] = useState("");
  const [yoq, setYoq] = useState("");
  const [industry, setindustry] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [pathValueep22Display, setPathValueep22Display] = useState("");

  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");
  const [currentYear, setCurrentYear] = useState("");
  const [experience, setExperience] = useState("");
  


  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallftTeachPhddata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setTeacher(data[0].fullTimeTeacherswithPhd[0].inputpht1);
              setDepartment(data[0].fullTimeTeacherswithPhd[0].inputpht2);
              setSchool(data[0].fullTimeTeacherswithPhd[0].inputpht3);
              setQualification(data[0].fullTimeTeacherswithPhd[0].inputpht4);
              setYoq(data[0].fullTimeTeacherswithPhd[0].inputpht5);
              setCurrentYear(data[0].fullTimeTeacherswithPhd[0].inputpht6);
              setExperience(data[0].fullTimeTeacherswithPhd[0].inputpht7);
              setindustry(data[0].fullTimeTeacherswithPhd[0].inputpht8);
              setValueep22(
                data[0].fullTimeTeachersPhdFileUpload[0]
                  .ftTeachPhdFilePath
              );
              setPathValueep22Display(
                data[0].fullTimeTeachersPhdFileUpload[0]
                  .ftTeachPhdFileName
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

  const inputPercentageoffulltime = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    fullTimeTeacherswithPhd: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputpht1: teacher,
        inputpht2: department,
        inputpht3: school,
        inputpht4: qualification,
        inputpht5: yoq,
        inputpht6: currentYear,
        inputpht7: experience,
        inputpht8: industry,
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


  function onClickingPercentageoffulltime(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(inputPercentageoffulltime);
    if (pathValueep22 !== "") {
      console.log(pathValueep22);
      basicData.append("ftTeachPhdFiles", valueep22, "ep22-" + valueep22.name);
    }
    basicData.append("ftTeachPhd", jsonBlob(inputPercentageoffulltime));
    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch("http://localhost:8080/api/v1/ftTeachPhdData", filesFetchMethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Record is Inserted Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
  }

  // function onClickingPercentageoffulltime(e) {
  //   e.preventDefault();
  //   const basicData = new FormData();
  //   basicData.append("financeSupportTeach", jsonBlob(inputFinancialSupport));
  //   if (pathValueep22 !== "") {
  //     basicData.append(
  //       "financeSuppTeachFiles",
  //       valueep22,
  //       "ep22-" + valueep22.name
  //     );
  //   }
  // }

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
    <div className="percentageoffulltime-container">
      <h1 className="percentageoffulltime-heading-style">
        % of Fulltime Teachers with Ph.D
      </h1>
      <div className="percentageoffulltimeeachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of full time teacher with Ph.D./D.M/M.Ch./D.N.B
                Superspeciality/D.Sc./D’Lit.
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
              <th>Year</th>
              <td>
                <input
                  type="number"
                  name="currentYear"
                  value={currentYear}
                  onChange={(e) => setCurrentYear(e.target.value)}
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
              <th>Total Teaching Experience In Years</th>
              <td>
                <input
                  type="number"
                  name="experience"
                  value={experience}
                  onChange={(e) => setExperience(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Total Industry Experience In Years</th>
              <td>
                <input
                  type="number"
                  name="industry"
                  value={industry}
                  onChange={(e) => setindustry(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Qualification (Ph.D./D.M/M.Ch./D.N.B Super
                speciality/D.Sc./D’Lit.)
              </th>
              <td>
                <input
                  type="text"
                  name="qualification"
                  value={qualification}
                  onChange={(e) => setQualification(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Year of obtaining the qualification</th>
              <td>
                <input
                  type="number"
                  name="yoq"
                  value={yoq}
                  onChange={(e) => setYoq(e.target.value)}
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
          <div className="phd-button-container">
            <button
              className="phd-button-style"
              onClick={onClickingPercentageoffulltime}
            >
              Modify
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
