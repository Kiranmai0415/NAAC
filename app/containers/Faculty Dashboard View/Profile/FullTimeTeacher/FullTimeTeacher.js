import React, { useEffect, useState } from "react";
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
  const [teacher, setTeacher] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [qualification, setQualification] = useState("");
  const [year, setYear] = useState("");
  const [recognize, setRecognize] = useState("");
  const [id, setId] = useState("");
  const [email, setEmail] = useState("");
  const [gender, setGender] = useState("");
  const [designation, setDesignation] = useState("");
  const [date, setDate] = useState("");
  const [appointment, setAppointment] = useState("");
  const [depart, setDepart] = useState("");
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");


  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallFullspldata").then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setTeacher(data[0].fullTimeTeacherswithSpecialization[0].inputftt1);
            setDepartment(
              data[0].fullTimeTeacherswithSpecialization[0].inputftt2
            );
            setSchool(data[0].fullTimeTeacherswithSpecialization[0].inputftt3);
            setQualification(
              data[0].fullTimeTeacherswithSpecialization[0].inputftt4
            );
            setYear(data[0].fullTimeTeacherswithSpecialization[0].inputftt5);
            setRecognize(
              data[0].fullTimeTeacherswithSpecialization[0].inputftt6
            );
            setId(data[0].fullTimeTeacherswithSpecialization[0].inputftt7);
            setEmail(data[0].fullTimeTeacherswithSpecialization[0].inputftt8);
            setGender(data[0].fullTimeTeacherswithSpecialization[0].inputftt9);
            setDesignation(
              data[0].fullTimeTeacherswithSpecialization[0].inputftt10
            );
            setDate(data[0].fullTimeTeacherswithSpecialization[0].inputftt11);
            setAppointment(
              data[0].fullTimeTeacherswithSpecialization[0].inputftt12
            );
            setDepart(data[0].fullTimeTeacherswithSpecialization[0].inputftt13);
            setValueep22(
              data[0].fullTimeTeacherswithSpecializationFileUpload[0]
                .fulltimeTeacherswithSpecFilePath
            );
            setPathValueep22(
              data[0].fullTimeTeacherswithSpecializationFileUpload[0].fulltimeTeacherswithSpecFileName
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

  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }





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
                Qualification (Ph.D./D.M/M.Ch./D.N.B Super-
                speciality/D.Sc./D’Lit.)
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
              <th>Year of obtaining the qualification (U)</th>
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
                Whether recognized as research Guide for Ph.D./D.M/M.Ch./D.N.B
                Superspeciality/D.Sc./D’Lit. (AU)
              </th>
              <td>
                <input   readOnly
                
                  type="text"
                  name="recognize"
                  value={recognize}
                  onChange={(e) => setRecognize(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>ID number/Aadhar number (not mandatory) (AF)</th>
              <td>
                <input   readOnly
  
                  type="text"
                  name="id"
                  value={id}
                  onChange={(e) => setId(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Email (AF)</th>
              <td>
                <input
                  readOnly
                  type="text"
                  name="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Gender (AF)</th>
              <td>
                <input
                  readOnly
                  type="text"
                  name="gender"
                  value={gender}
                  onChange={(e) => setGender(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Designation (AF)</th>
              <td>
                <input
                  readOnly
                  type="text"
                  name="designation"
                  value={designation}
                  onChange={(e) => setDesignation(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Date of joining institution (AF)</th>
              <td>
                <input
                  readOnly
                  type="text"
                  name="date"
                  value={date}
                  onChange={(e) => setDate(e.target.value)}
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
                  readOnly
                  type="text"
                  name="appointment"
                  value={appointment}
                  onChange={(e) => setAppointment(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Name of the Department(AF)</th>
              <td>
                <input
                  readOnly
                  type="text"
                  name="depart"
                  value={depart}
                  onChange={(e) => setDepart(e.target.value)}
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
          {/* <div className="fulltime-button-container">
            <button className='fulltime-button-style' onClick={onClickingFulltime}>
              Submit
            </button>
          </div> */}
        </form>
      </div>
    </div>
  );
}
