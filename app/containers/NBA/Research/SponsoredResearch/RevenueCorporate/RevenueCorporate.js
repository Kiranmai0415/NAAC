import React, { useState } from "react";
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
  const [revenueCorporate, setRevenueCorporate] = useState({
    not: "",
    department: "",
    school: "",
    title: "",
    agency: "",
    year: "",
    revenue: "",
    trainees: "",
  });
  // file upload
  const [valueep22, setValueep22] = useState();

  const { not, title, agency, year, revenue, trainees, department, school } =
    revenueCorporate;

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
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingRevenueCorporate(e) {
    e.preventDefault();
    const basicData = new FormData();

    basicData.append("revenueCorpTrainobj", jsonBlob(inputRevenueCorporate));
    basicData.append(
      "revenueCorpTrainFiles",
      valueep22,
      "ep22-" + valueep22.name
    );
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
      resources.APPLICATION_URL+"revenueCorpTrainingData",
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

  const CorporateHandleChange = (e) => {
    setRevenueCorporate({
      ...revenueCorporate,
      [e.target.name]: e.target.value,
    });
  };

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
                <input
                  type="text"
                  name="not"
                  value={not}
                  onChange={CorporateHandleChange}
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
                  onChange={CorporateHandleChange}
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
                  onChange={CorporateHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Title of the corporate training program</th>
              <td>
                <input
                  type="text"
                  name="title"
                  value={title}
                  onChange={CorporateHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Agency seeking training with contact details</th>
              <td>
                <input
                  type="text"
                  name="agency"
                  value={agency}
                  onChange={CorporateHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Year</th>
              <td>
                <input
                  type="number"
                  name="year"
                  value={year}
                  onChange={CorporateHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Revenue generated (amount in lakhs)</th>
              <td>
                <input
                  type="number"
                  name="revenue"
                  value={revenue}
                  onChange={CorporateHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Number of trainees</th>
              <td>
                <input
                  type="number"
                  name="trainees"
                  value={trainees}
                  onChange={CorporateHandleChange}
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
          <div className="revenue-button-container">
            <button
              className="revenue-button-style"
              onClick={onClickingRevenueCorporate}
            >
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
