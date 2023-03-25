import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./NoOfWorkshop.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
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

export default function NoOfWorkshop() {
  const [year, setYear] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [workshop, setWorkshop] = useState("");
  const [participants, setParticipants] = useState("");
  const [dateFrom, setDateFrom] = useState("");
  const [dateTo, setDateTo] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallWorkshopsdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setYear(data[0].numberofWorkshopsorSeminars[0].inputwt1);
              setDepartment(data[0].numberofWorkshopsorSeminars[0].inputwt2);
              setSchool(data[0].numberofWorkshopsorSeminars[0].inputwt3);
              setWorkshop(data[0].numberofWorkshopsorSeminars[0].inputwt4);
              setParticipants(data[0].numberofWorkshopsorSeminars[0].inputwt5);
              setDateFrom(data[0].numberofWorkshopsorSeminars[0].inputwt6);
              setDateTo(data[0].numberofWorkshopsorSeminars[0].inputwt7);

              setValueep22(
                data[0].numberofWorkshopsorSeminarsFileUpload[0]
                  .noofWorkshopsSeminorsFilePath
              );
              setPathValueep22(
                data[0].numberofWorkshopsorSeminarsFileUpload[0]
                  .noofWorkshopsSeminorsFileName
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

  const inputWorkshopsandSeminars = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    numberofWorkshopsorSeminars: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputwt1: year,
        inputwt2: department,
        inputwt3: school,
        inputwt4: workshop,
        inputwt5: participants,
        inputwt6: dateFrom,
        inputwt7: dateTo,
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
    <div className="noofworkshop-main-container">
      <h1 className="noofworkshop-main-heading-style">
        Number of workshops/seminars
      </h1>
      <div className="noofworkshop-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Year
                <span style={{ color: "red" }}>*</span>
              </th>
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
              <th>Name of the workshop/ seminar</th>
              <td>
                <input   readOnly
                  type="text"
                  name="workshop"
                  value={workshop}
                  onChange={(e) => setWorkshop(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Number of Participants</th>
              <td>
                <input   readOnly
                  type="text"
                  name="participants"
                  value={participants}
                  onChange={(e) => setParticipants(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Date From</th>
              <td>
                <input   readOnly
                  type="text"
                  name="dateFrom"
                  value={dateFrom}
                  onChange={(e) => setDateFrom(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Date To</th>
              <td>
                <input   readOnly
                  type="text"
                  name="dateTo"
                  value={dateTo}
                  onChange={(e) => setDateTo(e.target.value)}
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
