import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import ".//PhDAwarded.css";
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

export default function PhDAwarded() {
  const [scholor, setScholor] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [guide, setGuide] = useState("");
  const [thesis, setThesis] = useState("");
  const [yor, setYor] = useState("");
  const [phd, setPhd] = useState("");
  const [recognize, setRecognize] = useState("");
  const [guide1, setGuide1] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [pathValueep22Display, setPathValueep22Display] = useState("");

  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");
  const [currentYear, setCurrentYear] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallphdAwardsdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setScholor(data[0].phdAwardedorRegistered[0].inputphdt1);
              setDepartment(data[0].phdAwardedorRegistered[0].inputphdt2);
              setSchool(data[0].phdAwardedorRegistered[0].inputphdt3);
              setGuide(data[0].phdAwardedorRegistered[0].inputphdt4);
              setThesis(data[0].phdAwardedorRegistered[0].inputphdt5);
              setYor(data[0].phdAwardedorRegistered[0].inputphdt6);
              setPhd(data[0].phdAwardedorRegistered[0].inputphdt7);
              setRecognize(data[0].phdAwardedorRegistered[0].inputphdt8);
              setGuide1(data[0].phdAwardedorRegistered[0].inputphdt9);
              setCurrentYear(data[0].phdAwardedorRegistered[0].inputphdt10);

              setValueep22(
                data[0].phdAwardedorRegisteredFileUpload[0].phdawardedFilePath
              );
              setPathValueep22Display(
                data[0].phdAwardedorRegisteredFileUpload[0].phdawardedFileName
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
  const inputPhDAwards = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    phdAwardedorRegistered: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputphdt1: scholor,
        inputphdt2: department,
        inputphdt3: school,
        inputphdt4: guide,
        inputphdt5: thesis,
        inputphdt6: yor,
        inputphdt7: phd,
        inputphdt8: recognize,
        inputphdt9: guide1,
        inputphdt10: currentYear,
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




  function onClickingPhDAwards(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(JSON.stringify(inputPhDAwards));
    if(pathValueep22 !== ""){
      console.log(pathValueep22);
      basicData.append("phdFiles", valueep22, "ep22-" + valueep22.name);
  }
  basicData.append("phdInfo", jsonBlob(inputPhDAwards));


    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch("http://localhost:8080/api/v1/phdData", filesFetchMethod).then(
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
    <div className="phDAwarded-container">
      <h1 className="phDAwarded-heading-style">Ph. D awarded/Registered</h1>
      <div className="phDAwarded-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the PhD scholar
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="scholor"
                  value={scholor}
                  onChange={(e) => setScholor(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Name of the Department</th>
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
              <th>Name of the guide/s</th>
              <td>
                <input
                  type="text"
                  name="guide"
                  value={guide}
                  onChange={(e) => setGuide(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Title of the thesis</th>
              <td>
                <input
                  type="text"
                  name="thesis"
                  value={thesis}
                  onChange={(e) => setThesis(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Year of registration of the scholar</th>
              <td>
                <input
                  type="number"
                  name="yor"
                  value={yor}
                  onChange={(e) => setYor(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Year of PhD awarded</th>
              <td>
                <input
                  type="number"
                  name="phd"
                  value={phd}
                  onChange={(e) => setPhd(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>
                Whether recognised as a Research Guide for Ph.D./D.M/M.Ch./D.N.B
                Super speciality/D.Sc./D’Lit (YES/NO)
              </th>
              <td>
                <input
                  type="text"
                  name="recognize"
                  value={recognize}
                  onChange={(e) => setRecognize(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Year of Recognition as a research Guide</th>
              <td>
                <input
                  type="number"
                  name="guide1"
                  value={guide1}
                  onChange={(e) => setGuide1(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Upload the Document</th>
              <td>
                <input
                  type="file"
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
            <button className="phd-button-style" onClick={onClickingPhDAwards}>
            Modify
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
