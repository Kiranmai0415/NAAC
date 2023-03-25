import React, { useState } from "react";
import { toast } from "react-toastify";
import "./FullTimeTeacher.css";
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

export default function FullTimeTeacher() {
  const [fulltime, setFulltime] = useState({
    teacher: "",

    department: "",
    school: "",
    qualification: "",
    year: "",
    recognize: "",
    id: "",
    email: "",
    gender: "",
    designation: "",
    appointment: "",
    depart: "",
    document: "",
  });

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

  // file upload
  const [valueep22, setValueep22] = useState();

  const {
    teacher,
    department,
    school,
    qualification,
    year,
    recognize,
    id,
    email,
    gender,
    designation,
    date,
    appointment,
    depart,
  } = fulltime;

  const inputFulltime = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    fullTimeTeacherswithSpecialization: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputftt1: teacher,
        inputftt2: department,
        inputftt3: school,
        inputftt4: qualification,
        inputftt5: year,
        inputftt6: recognize,
        inputftt7: id,
        inputftt8: email,
        inputftt9: gender,
        inputftt10: designation,
        inputftt11: date,
        inputftt12: appointment,
        inputftt13: depart,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingFulltime(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(JSON.stringify(inputFulltime));
    basicData.append("splFiles", valueep22, "ep22-" + valueep22.name);
    basicData.append("splInfo", jsonBlob(inputFulltime));

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(resources.APPLICATION_URL+"fullsplData", filesFetchMethod).then(
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

  const FulltimeHandleChange = (e) => {
    setFulltime({
      ...fulltime,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div className="fulltime-container">
      <h1 className="fulltime-heading-style">
        Full time teachers with
        Ph.D./D.M/M.Ch./D.N.BSuperspeciality/D.Sc./D’Lit.
      </h1>
      <div className="fulltimeeachTable-container">
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
                  onChange={FulltimeHandleChange}
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
                  onChange={FulltimeHandleChange}
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
                  onChange={FulltimeHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>
                Qualification (Ph.D./D.M/M.Ch./D.N.B Super-
                speciality/D.Sc./D’Lit.)
              </th>
              <td>
                <input
                  type="text"
                  name="qualification"
                  value={qualification}
                  onChange={FulltimeHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Year of obtaining the qualification (U)</th>
              <td>
                <input
                  type="number"
                  name="year"
                  value={year}
                  onChange={FulltimeHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>
                Whether recognized as research Guide for Ph.D./D.M/M.Ch./D.N.B
                Superspeciality/D.Sc./D’Lit. (AU)
              </th>
              <td>
                <input
                  type="text"
                  name="recognize"
                  value={recognize}
                  onChange={FulltimeHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>ID number/Aadhar number (not mandatory) (AF)</th>
              <td>
                <input
                  type="number"
                  name="id"
                  value={id}
                  onChange={FulltimeHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Email (AF)</th>
              <td>
                <input
                  type="text"
                  name="email"
                  value={email}
                  onChange={FulltimeHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Gender (AF)</th>
              <td>
                <input
                  type="text"
                  name="gender"
                  value={gender}
                  onChange={FulltimeHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Designation (AF)</th>
              <td>
                <input
                  type="text"
                  name="designation"
                  value={designation}
                  onChange={FulltimeHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Date of joining institution (AF)</th>
              <td>
                <input
                  type="date"
                  name="date"
                  value={date}
                  onChange={FulltimeHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>
                Nature of appointment (Against Sanctioned post, temporary,
                permanent) (AF)
              </th>
              <td>
                <input
                  type="text"
                  name="appointment"
                  value={appointment}
                  onChange={FulltimeHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Name of the Department(AF)</th>
              <td>
                <input
                  type="text"
                  name="depart"
                  value={depart}
                  onChange={FulltimeHandleChange}
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
                  }}
                />
              </td>
            </tr>
          </table>
          <div className="fulltime-button-container">
            <button
              className="fulltime-button-style"
              onClick={onClickingFulltime}
            >
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
