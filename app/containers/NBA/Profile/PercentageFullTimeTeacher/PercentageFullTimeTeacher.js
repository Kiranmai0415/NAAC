import React, { useState } from "react";
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
  const [percentageoffulltime, setPercentageoffulltime] = useState({
    teacher: "",
    department: "",
    school: "",
    qualification: "",
    yoq: "",
    currentYear: "",
    experience: "",
    industry: "",
  });
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValue, setPathValue] = useState();
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  const {
    teacher,
    qualification,
    yoq,
    department,
    school,
    currentYear,
    experience,
    industry,
  } = percentageoffulltime;

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

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingPercentageoffulltime(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(JSON.stringify(inputPercentageoffulltime));
    basicData.append("ftTeachPhd", jsonBlob(inputPercentageoffulltime));
    if (pathValue !== "") {
      basicData.append("ftTeachPhdFiles", valueep22, "ep22-" + valueep22.name);
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
    fetch(resources.APPLICATION_URL+"ftTeachPhdData", filesFetchMethod).then(
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

  const PercentageHandleChange = (e) => {
    setPercentageoffulltime({
      ...percentageoffulltime,
      [e.target.name]: e.target.value,
    });
  };

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
                  onChange={PercentageHandleChange}
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
                  onChange={PercentageHandleChange}
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
                  onChange={PercentageHandleChange}
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
                  onChange={PercentageHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Total Teaching Experience IN YRS</th>
              <td>
                <input
                  type="number"
                  name="experience"
                  value={experience}
                  onChange={PercentageHandleChange}
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
                  onChange={PercentageHandleChange}
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
                  onChange={PercentageHandleChange}
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
                  onChange={PercentageHandleChange}
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
                    setPathValue(e.target.value);
                    showFilePreview(e);
                  }}
                  value={pathValue}
                  accept=".pdf"
                />
                {pathValue === "" ? null : (
                  <div className="c12-fileButtons-container">
                    {/* <button className="c12-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button> */}
                    {/* <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue("");
                        document.getElementById("ep22").value = "";
                      }}
                    >
                      Reset
                    </button> */}
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
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
