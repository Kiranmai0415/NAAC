import React, { useState } from "react";

import { toast } from "react-toastify";
import "./Mous.css";
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

export default function Mous() {
  const [mous, setMous] = useState({
    institution: "",
    department: "",
    school: "",
    collaboration: "",
    year: "",
    duration: "",
    activities: "",
  });

  // file upload
  const [valueep22, setValueep22] = useState();

  const {
    institution,
    department,
    school,
    collaboration,
    year,
    duration,
    activities,
  } = mous;

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

  const inputMous = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    mous: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputmt1: institution,
        inputmt2: department,
        inputmt3: school,
        inputmt4: collaboration,
        inputmt5: year,
        inputmt6: duration,
        inputmt7: activities,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingMous(e) {
    e.preventDefault();
    console.log(JSON.stringify(inputMous));
    const basicData = new FormData();
    basicData.append("mousFiles", valueep22, "ep22-" + valueep22.name);
    basicData.append("mous", jsonBlob(inputMous));

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };

    fetch(resources.APPLICATION_URL+"mousData", filesFetchMethod).then(
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

  const MousHandleChange = (e) => {
    setMous({
      ...mous,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div className="mous-container">
      <h1 className="mous-heading-style">MoUs</h1>
      <div className="mous-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            {/* <span style={{ color: "red" }}>*</span> */}
            <tr>
              <th>
                Name of the Organization/ Institution/ Industry with whom MoU is
                signed (U) Organization with which MoU is signed (AU)
                Organization with which MoU is signed (AF)
              </th>
              <td>
                <input
                  type="text"
                  name="institution"
                  value={institution}
                  onChange={MousHandleChange}
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
                  onChange={MousHandleChange}
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
                  onChange={MousHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>
                Name of the institution/ industry/ corporate house (AU) Name of
                the collaborating agency / institution / industry / corporate
                house with whom the MoU / collaboration / linkage is made, with
                contact details (AF)
              </th>
              <td>
                <input
                  type="text"
                  name="collaboration"
                  value={collaboration}
                  onChange={MousHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>
                Year of signing MoU (U & AU) Year of signing MoU / collaboration
                / linkage (AF)
              </th>
              <td>
                <input
                  type="number"
                  name="year"
                  value={year}
                  onChange={MousHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>
                Duration of MoU (U&AU) Duration of MoU / collaboration / linkage
                (AF)
              </th>
              <td>
                <input
                  type="text"
                  name="duration"
                  value={duration}
                  onChange={MousHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>List the actual activities under each MOU year wise</th>
              <td>
                <input
                  type="text"
                  name="activities"
                  value={activities}
                  onChange={MousHandleChange}
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
          <div className="mous-button-container">
            <button className="mous-button-style" onClick={onClickingMous}>
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
