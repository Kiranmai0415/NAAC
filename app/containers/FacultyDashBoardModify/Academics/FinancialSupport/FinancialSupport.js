import React, { useEffect, useState } from "react";
import "./FinancialSupport.css";
import { toast } from "react-toastify";
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
export default function FinancialSupport() {
  const [year, setYear] = useState("");
  const [not, setNot] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [conference, setConference] = useState("");
  const [professional, setProfessional] = useState("");
  const [support, setSupport] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [pathValueep22Display, setPathValueep22Display] = useState("");


  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallfinanceSuppTeachdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setYear(data[0].financialSupportToTeachers[0].inputfst1);
              setNot(data[0].financialSupportToTeachers[0].inputfst2);
              setDepartment(data[0].financialSupportToTeachers[0].inputfst3);
              setSchool(data[0].financialSupportToTeachers[0].inputfst4);
              setConference(data[0].financialSupportToTeachers[0].inputfst5);
              setProfessional(data[0].financialSupportToTeachers[0].inputfst6);
              setSupport(data[0].financialSupportToTeachers[0].inputfst7);
              setValueep22(
                data[0].financialSupportToTeachersFileUpload[0]
                  .financeSupTeachFilePath
              );
              setPathValueep22Display(
                data[0].financialSupportToTeachersFileUpload[0]
                  .financeSupTeachFileName
              );
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    []
  );

  console.log(filePreviewSrc111f1);
  console.log("object====>" + JSON.stringify(AuthService.getCurrentUser()));
  let instituteType = AuthService.getCurrentUser().instituteType;
  console.log("instituteType====>" + instituteType);
  const d = new Date();
  let currYear = d.getFullYear();
  console.log("var====>" + currYear);
  let fYear = parseInt(currYear) - 1 + "-" + currYear;
  console.log("current year==" + fYear);
  const collegeId = AuthService.getCurrentUser().collegeId;
  console.log("collegeId==========>" + collegeId);

  const inputFinancialSupport = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    financialSupportToTeachers: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputfst1: year,
        inputfst2: not,
        inputfst3: department,
        inputfst4: school,
        inputfst5: conference,
        inputfst6: professional,
        inputfst7: support,
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


  function onClickingFinancialSupport(e) {
    e.preventDefault();
    const basicData = new FormData();
    basicData.append("financeSupportTeach", jsonBlob(inputFinancialSupport));
    if (pathValueep22 !== "") {
      console.log("path is",pathValueep22);
      basicData.append( "financeSuppTeachFiles", valueep22, "ep22-" + valueep22.name);
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
    fetch(
      "http://localhost:8080/api/v1/financeSuppTeachData",
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

  return (
    <div className="financialSupport-container">
      <h1 className="financialSupport-heading-style">
        {" "}
        Financial support to Teachers
      </h1>
      <div className="financialSupport-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Year
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="number"
                  name="year"
                  value={year}
                  onChange={(e) => setYear(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Name of the teacher</th>
              <td>
                <input
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
                  name="school"
                  value={school}
                  onChange={(e) => setSchool(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Name of conference/ workshop attended for which financial
                support provided
              </th>
              <td>
                <input
                  type="text"
                  name="conference"
                  value={conference}
                  onChange={(e) => setConference(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Name of the professional body for which membership fee provided
              </th>
              <td>
                <input
                  type="text"
                  name="professional"
                  value={professional}
                  onChange={(e) => setProfessional(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Amount of support (in INR)Comments</th>
              <td>
                <input
                  type="text"
                  name="support"
                  value={support}
                  onChange={(e) => setSupport(e.target.value)}
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
          <div className="financialSupport-button-container">
            <button
              className="financialSupport-button-style"
              onClick={onClickingFinancialSupport}
            >
              Modify
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
