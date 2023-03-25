import React, { useEffect, useState } from "react";
import "./Online.css";
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
export default function Online() {
  const [year, setYear] = useState("");
  const [not, setNot] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [duration, setDuration] = useState("");
  const [duration1, setDuration1] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [pathValueep22Display, setPathValueep22Display] = useState("");

  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallOnlineF2FFDPdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setYear(data[0].onlineorF2FFDP[0].inputfdpt1);
              setNot(data[0].onlineorF2FFDP[0].inputfdpt2);
              setDepartment(data[0].onlineorF2FFDP[0].inputfdpt3);
              setSchool(data[0].onlineorF2FFDP[0].inputfdpt4);
              setDuration(data[0].onlineorF2FFDP[0].inputfdpt5);
              setDuration1(data[0].onlineorF2FFDP[0].inputfdpt6);
              setValueep22(
                data[0].onlineorF2FFDPFileUpload[0].onlineF2fFdpFilePath
              );
              setPathValueep22Display(
                data[0].onlineorF2FFDPFileUpload[0].onlineF2fFdpFileName
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

  const inputFacetoface = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    onlineorF2FFDP: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputfdpt1: year,
        inputfdpt2: not,
        inputfdpt3: department,
        inputfdpt4: school,
        inputfdpt5: duration,
        inputfdpt6: duration1,
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


  function onClickingFacetoface(e) {
    e.preventDefault();
    const basicData = new FormData();
    basicData.append("onlineF2FFDPobj", jsonBlob(inputFacetoface));
    if (pathValueep22 !== "") {
      console.log("path is",pathValueep22);
      basicData.append(
        "onlineF2FFDPFiles",
        valueep22,
        "ep22-" + valueep22.name
      );
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
      "http://localhost:8080/api/v1/onlineF2FFDPData",
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

  const FaceHandleChange = (e) => {
    setFacetoface({
      ...facetoface,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div className="online-main-container">
      <h1 className="online-main-heading-style">
        {" "}
        Online/ face-to-face Faculty Development Programmes (FDP)
      </h1>
      <div className="online-eachTable-container">
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
              <th>Name of teacher who attended the program</th>
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
              <th>Duration (from)</th>
              <td>
                <input
                  type="date"
                  name="duration"
                  value={duration}
                  onChange={(e) => setDuration(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Duration (to) (DD-MM-YYYY)</th>
              <td>
                <input
                  type="date"
                  name="duration1"
                  value={duration1}
                  onChange={(e) => setDuration1(e.target.value)}
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
          <div className="online-button-container">
            <button
              className="online-button-style"
              onClick={onClickingFacetoface}
            >
               Modify
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
