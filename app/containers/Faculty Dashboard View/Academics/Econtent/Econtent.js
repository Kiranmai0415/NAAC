import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./Econtent.css";
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

export default function Econtent() {
  const [name, setName] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [name1, setName1] = useState("");
  const [platform, setPlatform] = useState("");
  const [date, setDate] = useState("");
  const [link, setLink] = useState("");
  const [list, setList] = useState("");
  const [provide, setProvide] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallEContentdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setName(data[0].eContentDevelopedByTeacher[0].inputect1);
              setDepartment(data[0].eContentDevelopedByTeacher[0].inputect2);
              setSchool(data[0].eContentDevelopedByTeacher[0].inputect3);
              setName1(data[0].eContentDevelopedByTeacher[0].inputect4);
              setPlatform(data[0].eContentDevelopedByTeacher[0].inputect5);
              setDate(data[0].eContentDevelopedByTeacher[0].inputect6);
              setLink(data[0].eContentDevelopedByTeacher[0].inputect7);
              setList(data[0].eContentDevelopedByTeacher[0].inputect8);
              setProvide(
                data[0].eContentDevelopedByTeacherFileUpload[0].inputect9
              );
              setValueep22(
                data[0].eContentDevelopedByTeacherFileUpload[0]
                  .econtentDevelopedbyTeacherFilePath
              );
              setPathValueep22(
                data[0].eContentDevelopedByTeacherFileUpload[0]
                  .econtentDevelopedbyTeacherFileName
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
  const inputEcontent = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    eContentDevelopedByTeacher: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        inputect1: name,
        inputect2: department,
        inputect3: school,
        inputect4: name1,
        inputect5: platform,
        inputect6: date,
        inputect7: link,
        inputect8: list,
        inputect9: provide,
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

  //file Upload
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }

  return (
    <div className="econtent-main-container">
      <h1 className="econtent-main-heading-style">
        E-content is developed by teacher
      </h1>
      <div className="econtent-eachTable-container">
        <form>
          <table>
            <tr>
              <th className="BI-table1-headings">
                Name of the teacher
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input   readOnly
                  type="text"
                  name="name"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
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
              <th>Name of the module developed</th>
              <td>
                <input   readOnly
                  type="text"
                  name="name1"
                  value={name1}
                  onChange={(e) => setName1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Platform on which module is developed</th>
              <td>
                <input   readOnly
                  type="text"
                  name="platform"
                  value={platform}
                  onChange={(e) => setPlatform(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Date of launching e content</th>
              <td>
                <input   readOnly
                  type="text"
                  name="date"
                  value={date}
                  onChange={(e) => setDate(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>
                Link to the relevant document and facility available in the
                institution
              </th>
              <td>
                <input   readOnly
                  type="text"
                  name="link"
                  value={link}
                  onChange={(e) => setLink(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>List of the e-content development facility available</th>
              <td>
                <input   readOnly
                  type="text"
                  name="list"
                  value={list}
                  onChange={(e) => setList(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>
                Provide link to videos of the media centre and recording
                facility
              </th>

              <td>
                <input   readOnly
                  type="text"
                  name="provide"
                  value={provide}
                  onChange={(e) => setProvide(e.target.value)}
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
