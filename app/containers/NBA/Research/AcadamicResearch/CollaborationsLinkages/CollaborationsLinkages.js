import React, { useState } from "react";
import { toast } from "react-toastify";
import "./CollaborationsLinkages.css";
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

export default function CollaborationsLinkages() {

 
 
  
 
  
  const [collaborationsLinkages, setCollaborationsLinkages] = useState({
    nameMou: "",
    department: "",
    school: "",
    agency: "",
    participant: "",
    yos: "",
    duration: "",
    activity: "",
  });
  const [document1, setDocument1] = useState("");

  // file upload
  const [valueep22, setValueep22] = useState();

  const {
    nameMou,
    department,
    school,
    agency,
    participant,
    yos,
    duration,
    activity,
  } = collaborationsLinkages;

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

  const inputCollaborationLinkages = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    collaborationsLinkages: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputclt1: nameMou,
        inputclt2: department,
        inputclt3: school,
        inputclt4: agency,
        inputclt5: participant,
        inputclt6: yos,
        inputclt7: duration,
        inputclt8: activity,
        inputclt9: document1,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingCollaborationLinkages(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(JSON.stringify(inputCollaborationLinkages));
    basicData.append(
      "collaborationsFiles",
      valueep22,
      "ep22-" + valueep22.name
    );
    basicData.append("collaborationsobj", jsonBlob(inputCollaborationLinkages));

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
      resources.APPLICATION_URL+"collaborationData",
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

  const handleChangeCollaborationsLinkages = (e) => {
    setCollaborationsLinkages({
      ...collaborationsLinkages,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div className="collaborationLinkages-container">
      <h1 className="collaborationLinkages-heading-style">
        Collaborations / linkages
      </h1>
      <div className="collaborationLinkages-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Title of the collaborative activity (U & AU) Name of the MoU /
                Collaboration / linkage (AF)
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="nameMou"
                  value={nameMou}
                  onChange={handleChangeCollaborationsLinkages}
                />
              </td>
            </tr>
            <tr>
              <th className="BI-table1-headings">
                Department *<span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="department"
                  value={department}
                  onChange={handleChangeCollaborationsLinkages}
                />
              </td>
            </tr>
            <tr>
              <th className="BI-table1-headings">
                Schools Name
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="school"
                  value={school}
                  onChange={handleChangeCollaborationsLinkages}
                />
              </td>
            </tr>
            <tr>
              <th>
                Name of the collaborating agency with contact details (U & AU)
                Name of the collaborating agency / institution / industry /
                corporate house with whom the MoU / collaboration / linkage is
                made, with contact details (AF)
              </th>
              <td>
                <input
                  type="text"
                  name="agency"
                  value={agency}
                  onChange={handleChangeCollaborationsLinkages}
                />
              </td>
            </tr>
            <tr>
              <th>Name of the participant (U & AU)</th>
              <td>
                <input
                  type="text"
                  name="participant"
                  value={participant}
                  onChange={handleChangeCollaborationsLinkages}
                />
              </td>
            </tr>
            <tr>
              <th>
                Year of collaboration (U & AU) Year of signing MoU /
                collaboration / linkage (AF)
              </th>
              <td>
                <input
                  type="number"
                  name="yos"
                  value={yos}
                  onChange={handleChangeCollaborationsLinkages}
                />
              </td>
            </tr>
            <tr>
              <th>
                Duration (U & AU) Duration of MoU / collaboration / linkage (AF)
              </th>
              <td>
                <input
                  type="text"
                  name="duration"
                  value={duration}
                  onChange={handleChangeCollaborationsLinkages}
                />
              </td>
            </tr>

            <tr>
              <th>
                Nature of the activity (U & AU) List the actual activities under
                each MOU and web -links year-wise (AF)
              </th>
              <td>
                <input
                  type="text"
                  name="activity"
                  value={activity}
                  onChange={handleChangeCollaborationsLinkages}
                />
              </td>
            </tr>

            <tr>
              <th>Link to the relevant document</th>
              <td>
                <input
                  type="text"
                  name="document1"
                  value={document1}
                  onChange={(e) => setDocument1(e.target.value)}
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
          <div className="collaborationLinkages-button-container">
            <button
              className="collaborationLinkages-button-style"
              onClick={onClickingCollaborationLinkages}
            >
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
