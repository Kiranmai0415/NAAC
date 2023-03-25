import React, { useState } from "react";
import { toast } from "react-toastify";
import "./Econtent.css";
import AuthService from "../../../Pages/Users/services/auth.service";

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
  const [econtent, setEcontent] = useState({
    name: "",
    department: "",
    school: "",
    name1: "",
    platform: "",
    date: "",
    link: "",
    list: "",
    provide: "",
  });

  // file upload
  const [valueep22, setValueep22] = useState();

  const {
    name,
    name1,
    platform,
    date,
    link,
    list,
    provide,
    department,
    school,
  } = econtent;

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

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingEcontent(e) {
    e.preventDefault();
    const basicData = new FormData();
    basicData.append("eContentFiles", valueep22, "ep22-" + valueep22.name);
    basicData.append("eContentobj", jsonBlob(inputEcontent));
    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch("http://localhost:8080/api/v1/eContentData", filesFetchMethod).then(
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

  const handleChangeEcontent = (e) => {
    setEcontent({
      ...econtent,
      [e.target.name]: e.target.value,
    });
  };

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
                <input
                  type="text"
                  name="name"
                  value={name}
                  onChange={handleChangeEcontent}
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
                  onChange={handleChangeEcontent}
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
                  onChange={handleChangeEcontent}
                />
              </td>
            </tr>

            <tr>
              <th>Name of the module developed</th>
              <td>
                <input
                  type="text"
                  name="name1"
                  value={name1}
                  onChange={handleChangeEcontent}
                />
              </td>
            </tr>
            <tr>
              <th>Platform on which module is developed</th>
              <td>
                <input
                  type="text"
                  name="platform"
                  value={platform}
                  onChange={handleChangeEcontent}
                />
              </td>
            </tr>
            <tr>
              <th>Date of launching e content</th>
              <td>
                <input
                  type="date"
                  name="date"
                  value={date}
                  onChange={handleChangeEcontent}
                />
              </td>
            </tr>

            <tr>
              <th>
                Link to the relevant document and facility available in the
                institution
              </th>
              <td>
                <input
                  type="text"
                  name="link"
                  value={link}
                  onChange={handleChangeEcontent}
                />
              </td>
            </tr>

            <tr>
              <th>List of the e-content development facility available</th>
              <td>
                <input
                  type="text"
                  name="list"
                  value={list}
                  onChange={handleChangeEcontent}
                />
              </td>
            </tr>

            <tr>
              <th>
                Provide link to videos of the media centre and recording
                facility
              </th>

              <td>
                <input
                  type="text"
                  name="provide"
                  value={provide}
                  onChange={handleChangeEcontent}
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
                  }}
                />
              </td>
            </tr>
          </table>

          <div className="econtent-button-container">
            <button
              className="econtent-button-style"
              onClick={onClickingEcontent}
            >
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
