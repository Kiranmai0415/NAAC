import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./Patents.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import PatentsAuthorize from "./PatentsAuthorize";
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
    nirfID: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    patents: [
      {
        nirfID: {
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
             setPathValueep22(data[0].patentsFileUpload[0].patentsFileName);
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    [calling]
  );

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
                  type="text"
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
                  type="text"
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
                  type="text"
                  name="currentYear"
                  value={currentYear}
                  onChange={(e) => setCurrentYear(e.target.value)}
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
        <PatentsAuthorize />
      </div>
    </div>
  );
}
