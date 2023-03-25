import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./Patents.css";

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

export default function Patents() {
  const [not, setNot] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [pno, setPno] = useState("");
  const [title, setTitle] = useState("");
  const [yoaward, setYoaward] = useState("");
  const [currentYear, setCurrentYear] = useState("");
  const [earning, setEarning] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [calling, setCalling] = useState("");
  const [pathValueep22, setPathValueep22] = useState("");
  const [pathValueep22Display, setPathValueep22Display] = useState("");

  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

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

  const inputPatentsDataList = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    patents: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputppt1: not,
        inputppt2: department,
        inputppt3: school,
        inputppt4: pno,
        inputppt5: title,
        inputppt6: yoaward,
        inputppt7: currentYear,
        inputppt8: earning,
      },
    ],
  };

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallpatentsdata").then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setNot(data[0].patents[0].inputppt1);
            setDepartment(data[0].patents[0].inputppt2);
            setSchool(data[0].patents[0].inputppt3);
            setPno(data[0].patents[0].inputppt4);
            setTitle(data[0].patents[0].inputppt5);
            setYoaward(data[0].patents[0].inputppt6);
            setCurrentYear(data[0].patents[0].inputppt7);
            setEarning(data[0].patents[0].inputppt8);
            setValueep22(data[0].patentsFileUpload[0].patentsFilePath);
            setPathValueep22Display(data[0].patentsFileUpload[0].patentsFileName);
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    [calling]
  );

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }




  function onClickingPatents(e) {
    e.preventDefault();

    const patentForm = new FormData();
    console.log(JSON.stringify(inputPatentsDataList));
    patentForm.append("patents", jsonBlob(inputPatentsDataList));
     if (pathValueep22 !== "") {
    patentForm.append("patentsFiles", valueep22, "ep22-" + valueep22.name);
     }

    const patentsDataMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: patentForm,
    };
    fetch("http://localhost:8080/api/v1/patentsData", patentsDataMethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Record is Inserted Successfully");
          setCalling("success");
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
    <div className="patents-container">
      <h1 className="patents-heading-style">Patents</h1>
      <div className="patents-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the Teacher
                <span style={{ color: "red" }}>*</span>
              </th>
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
              <th>Patent Number</th>
              <td>
                <input
                  type="text"
                  name="pno"
                  value={pno}
                  onChange={(e) => setPno(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Title of the patent</th>
              <td>
                <input
                  type="text"
                  name="title"
                  value={title}
                  onChange={(e) => setTitle(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Earning From patent(in lakhs)</th>
              <td>
                <input
                  type="number"
                  name="earning"
                  value={earning}
                  onChange={(e) => setEarning(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Year of Award / publish of patent</th>
              <td>
                <input
                  type="number"
                  name="yoaward"
                  value={yoaward}
                  onChange={(e) => setYoaward(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Year </th>
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

          <div className="patents-button-container">
            <button
              className="patents-button-style"
              onClick={onClickingPatents}
            >
              Modify
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
