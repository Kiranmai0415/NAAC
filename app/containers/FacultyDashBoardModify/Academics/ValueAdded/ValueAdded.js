import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./ValueAdded.css";
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

export default function Valueadded() {
  const [courseName, setCourseName] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [courseId, setCourseId] = useState("");
  const [yearOffering, setYearOffering] = useState("");
  const [sameYear, setSameYear] = useState("");
  const [courseDuration, setCourseDuration] = useState("");
  const [studentsEnrolled, setStudentsEnrolled] = useState("");
  const [courseComplted, setCourseComplted] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [pathValueep22Display, setPathValueep22Display] = useState("");

  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallValueAddCoursedata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setCourseName(data[0].valueAddedCourses[0].inputvat1);
              setDepartment(data[0].valueAddedCourses[0].inputvat2);
              setSchool(data[0].valueAddedCourses[0].inputvat3);
              setCourseId(data[0].valueAddedCourses[0].inputvat4);
              setYearOffering(data[0].valueAddedCourses[0].inputvat5);
              setSameYear(data[0].valueAddedCourses[0].inputvat6);
              setCourseDuration(data[0].valueAddedCourses[0].inputvat7);
              setStudentsEnrolled(data[0].valueAddedCourses[0].inputvat8);
              setCourseComplted(data[0].valueAddedCourses[0].inputvat9);
              setValueep22(
                data[0].valueAddedCoursesFileUpload[0].valueAddedCoursesFilePath
              );
              setPathValueep22Display(
                data[0].valueAddedCoursesFileUpload[0].valueAddedCoursesFileName
              );
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    []
  );

  console.log(filePreviewSrc111f1);
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

  const inputValueAdded = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    valueAddedCourses: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputvat1: courseName,
        inputvat2: department,
        inputvat3: school,
        inputvat4: courseId,
        inputvat5: yearOffering,
        inputvat6: sameYear,
        inputvat7: courseDuration,
        inputvat8: studentsEnrolled,
        inputvat9: courseComplted,
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

  function onClickingValueAdded(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(JSON.stringify(inputValueAdded));
    if(pathValueep22 !== ""){
      console.log("path is",pathValueep22);
      basicData.append("valueAddFiles", valueep22, "ep22-" + valueep22.name);
    }
    //basicData.append("valueAddFiles",  "ep22-" + valueep22.name);
    basicData.append("valueAddobj", jsonBlob(inputValueAdded));

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(
      "http://localhost:8080/api/v1/valueAddCourseData",
      filesFetchMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Inserted Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }

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

  // const handleChangeValueAdded = (e) => {
  //   setValueAdded({
  //     ...Valueadded,
  //     [e.target.name]: e.target.value,
  //   });
  // };

  return (
    <div className="valueadded-container">
      <h1 className="valueadded-heading-style">
        value-added courses & Enrolled Students
      </h1>
      <div className="valueadded-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the value added courses offered (with 30 or more contact
                hours)
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  // id="courseName"
                  name="courseName"
                  value={courseName}
                  onChange={(e) => setCourseName(e.target.value)}
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
                  // id="courseId"
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
                  // id="courseId"
                />
              </td>
            </tr>
            <tr>
              <th>Course Code (if any)</th>
              <td>
                <input
                  type="text"
                  name="courseId"
                  value={courseId}
                  onChange={(e) => setCourseId(e.target.value)}
                  // id="courseId"
                />
              </td>
            </tr>
            <tr>
              <th>Year of offering</th>
              <td>
                <input
                  type="number"
                  name="yearOffering"
                  value={yearOffering}
                  onChange={(e) => setYearOffering(e.target.value)}
                  id="YearOffering"
                />
              </td>
            </tr>
            <tr>
              <th>No. of times offered during the same year</th>

              <td>
                <input
                  type="number"
                  name="sameYear"
                  value={sameYear}
                  onChange={(e) => setSameYear(e.target.value)}
                  id="sameYear"
                />
              </td>
            </tr>
            <tr>
              <th>Duration of Course</th>
              <td>
                <input
                  type="text"
                  name="courseDuration"
                  value={courseDuration}
                  onChange={(e) => setCourseDuration(e.target.value)}
                  // id="courseDuration"
                />
              </td>
            </tr>
            <tr>
              <th>Number of students enrolled in the year</th>
              <td>
                <input
                  type="number"
                  name="studentsEnrolled"
                  value={studentsEnrolled}
                  onChange={(e) => setStudentsEnrolled(e.target.value)}
                  // id="studentsEnrolled"
                />
              </td>
            </tr>
            <tr>
              <th>Number of Students completing the course in the year</th>
              <td>
                <input
                  type="number"
                  name="courseComplted"
                  value={courseComplted}
                  onChange={(e) => setCourseComplted(e.target.value)}
                  // id="courseComplted"
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

          <div className="valueadded-button-container">
            <button
              className="valueadded-button-style"
              onClick={onClickingValueAdded}
            >
             Modify
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
