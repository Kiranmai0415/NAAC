import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./RevenueCorporate.css";
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

export default function RevenueCorporate() {
  const [not, setNot] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [title, setTitle] = useState("");
  const [agency, setAgency] = useState("");
  const [year, setYear] = useState("");
  const [revenue, setRevenue] = useState("");
  const [trainees, setTrainees] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallRevenueCorpTraindata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setNot(data[0].revenueCorporateTraining[0].inputrctt1);
              setDepartment(data[0].revenueCorporateTraining[0].inputrctt2);
              setSchool(data[0].revenueCorporateTraining[0].inputrctt3);
              setTitle(data[0].revenueCorporateTraining[0].inputrctt4);
              setAgency(data[0].revenueCorporateTraining[0].inputrctt5);
              setYear(data[0].revenueCorporateTraining[0].inputrctt6);
              setRevenue(data[0].revenueCorporateTraining[0].inputrctt7);
              setTrainees(data[0].revenueCorporateTraining[0].inputrctt8);
              // setValueep22(
              //   data[0].RevenueCorporateTrainingFileUpload[0]
              //     .revenueCorpoTrainingFilePath
              // );
              setPathValueep22(
                data[0].revenueCorporateTrainingFileUpload[0]
                  .revenueCorpoTrainingFileName
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

  const inputRevenueCorporate = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    revenueCorporateTraining: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        inputrctt1: not,
        inputrctt2: department,
        inputrctt3: school,
        inputrctt4: title,
        inputrctt5: agency,
        inputrctt6: year,
        inputrctt7: revenue,
        inputrctt8: trainees,
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
    <div className="revenue-container">
      <h1 className="revenue-heading-style">Revenue (Corporate Training)</h1>
      <div className="revenue-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Names of the teacher-consultants/corporate trainers
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input   readOnly
                  type="text"
                  name="not"
                  value={not}
                  onChange={(e) => setNot(e.target.value)}
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
              <th>Title of the corporate training program</th>
              <td>
                <input   readOnly
                  type="text"
                  name="title"
                  value={title}
                  onChange={(e) => setTitle(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Agency seeking training with contact details</th>
              <td>
                <input   readOnly
                  type="text"
                  name="agency"
                  value={agency}
                  onChange={(e) => setAgency(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Year</th>
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
              <th>Revenue generated (amount in lakhs)</th>
              <td>
                <input   readOnly
                  type="text"
                  name="revenue"
                  value={revenue}
                  onChange={(e) => setRevenue(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Number of trainees</th>
              <td>
                <input   readOnly
                  type="text"
                  name="trainees"
                  value={trainees}
                  onChange={(e) => setTrainees(e.target.value)}
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
