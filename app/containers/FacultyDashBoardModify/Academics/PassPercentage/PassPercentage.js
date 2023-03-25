import React, { useEffect, useState } from "react";
import "./PassPercentage.css";
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
export default function PassPercentage() {
  const [program, setPrograme] = useState("");
  const [pname, setPname] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [number, setNumber] = useState("");
  const [numberofstd, setNumberofstd] = useState("");
  const [year, setYear] = useState("");
  // file upload
  

  const [totalNumStu, settotalNumStu] = useState("");
  const [totalNumFullStu, settotalNumFullStu] = useState("");
  const [totalNumPartStu, settotalNumPartStu] = useState("");
  const [phdFullStudents, setphdFullStudents] = useState("");
  const [phdPartStudents, settotalphdPartStudents] = useState("");

  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [pathValueep22Display, setPathValueep22Display] = useState("");

  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallPassPercentdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setPrograme(data[0].passPercentofStudents[0].inputpst1);
              setPname(data[0].passPercentofStudents[0].inputpst2);
              setDepartment(data[0].passPercentofStudents[0].inputpst3);
              setSchool(data[0].passPercentofStudents[0].inputpst4);
              setNumber(data[0].passPercentofStudents[0].inputpst5);
              setNumberofstd(data[0].passPercentofStudents[0].inputpst6);
              setYear(data[0].passPercentofStudents[0].inputpst7);
              settotalNumStu(data[0].passPercentofStudents[0].inputpst8);
              settotalNumFullStu(data[0].passPercentofStudents[0].inputpst9);
              settotalNumPartStu(data[0].passPercentofStudents[0].inputpst10);
              setphdFullStudents(data[0].passPercentofStudents[0].inputpst11);
              settotalphdPartStudents(data[0].passPercentofStudents[0].inputpst12);
              setValueep22(
                data[0].passPercentofStudentsFileUpload[0]
                  .passPercentofStudentFilePath
              );
              setPathValueep22Display(
                data[0].passPercentofStudentsFileUpload[0]
                  .passPercentofStudentFileName
              );
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    []
  );

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

  const inputPassPercentage = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    passPercentofStudents: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputpst1: program,
        inputpst2: pname,
        inputpst3: department,
        inputpst4: school,
        inputpst5: number,
        inputpst6: numberofstd,
        inputpst7: year,
        inputpst8: totalNumStu,
        inputpst9: totalNumFullStu,
        inputpst10: totalNumPartStu,
        inputpst11: phdFullStudents,
        inputpst12: phdPartStudents,
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

  function onClickingPassPercentage(e) {
    e.preventDefault();
    const basicData = new FormData();
    
    if (pathValueep22 !== "") {
      console.log("path is",pathValueep22);

      basicData.append("passPercentFiles", valueep22, "ep22-" + valueep22.name);
    }
    basicData.append("passPercentobj", jsonBlob(inputPassPercentage));

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
      "http://localhost:8080/api/v1/passPercentData",
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
    <div className="passpercentage-container">
      <h1 className="passpercentage-heading-style">
        PassPercentage % of students
      </h1>
      <div className="passpercentage-eachTable-container">
        <form>
          <table>
            <tr>
              <th className="BI-table1-headings">
                Program Code
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="program"
                  value={program}
                  onChange={(e) => setPrograme(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Program Name</th>
              <td>
                <input
                  type="text"
                  name="pname"
                  value={pname}
                  onChange={(e) => setPname(e.target.value)}
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
              <th>School Name</th>
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
              <th> Total No.of Students</th>
              <td>
                <input
                  type="number"
                  name="totalNumStu"
                  value={totalNumStu}
                  onChange={(e) => settotalNumStu(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th> Total No.of Full time Students</th>
              <td>
                <input
                  type="number"
                  name="totalNumFullStu"
                  value={totalNumFullStu}
                  onChange={(e) => settotalNumFullStu(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th> Total No.of Part time Students</th>
              <td>
                <input
                  type="number"
                  name="totalNumPartStu"
                  value={totalNumPartStu}
                  onChange={(e) => settotalNumPartStu(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>
                No.of Full Time Ph.D Students Graduated/Awarded (Included
                Integrated Ph.D)
              </th>
              <td>
                <input
                  type="number"
                  name="phdFullStudents"
                  value={phdFullStudents}
                  onChange={(e) => setphdFullStudents(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                No.Of Part Time Ph.D Students Graduated/Awarded (Included
                Integrated Ph.D)
              </th>
              <td>
                <input
                  type="number"
                  name="phdPartStudents"
                  value={phdPartStudents}
                  onChange={(e) => settotalphdPartStudents(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>
                Total number of final year students who passed the examination
                conducted by Institution
              </th>
              <td>
                <input
                  type="number"
                  name="number"
                  value={number}
                  onChange={(e) => setNumber(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Total number of final year students who attended the examination
                conducted by Institution.
              </th>
              <td>
                <input
                  type="number"
                  name="numberofstd"
                  value={numberofstd}
                  onChange={(e) => setNumberofstd(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Year (AF)</th>
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
          <div className="PassPercentage-button-container">
            <button
              className="PassPercentage-button-style"
              onClick={onClickingPassPercentage}
            >
              Modify
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
