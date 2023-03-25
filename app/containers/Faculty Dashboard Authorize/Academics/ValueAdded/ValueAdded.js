import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./ValueAdded.css";
import ValueAddedAuthorize from "./ValueAddedAuthorize";
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
                data[0].valueAddedCoursesFileUpload[0].valueAddedCoursesFilePath);
                setPathValueep22(data[0].valueAddedCoursesFileUpload[0].valueAddedCoursesFileName
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

  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }

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
                  readOnly
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
                  readOnly
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
                  readOnly
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
                  readOnly
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
                  readOnly
                  type="text"
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
                  readOnly
                  type="text"
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
                  readOnly
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
                  readOnly
                  type="text"
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
                  readOnly
                  type="text"
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
              <a href={downloadFile(pathValueep22)}>View File</a>
              </td>
            </tr>
          </table>

          {/* <div className="valueadded-button-container">
            <button className="valueadded-button-style" onClick={onClickingValueAdded}>
              Submit
            </button>
          </div> */}
        </form>
        <ValueAddedAuthorize />
      </div>
    </div>
  );
}
