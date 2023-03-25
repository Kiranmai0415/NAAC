import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./CollaborationsLinkages.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import { resources } from "../../../../appConstants";
import { Link } from "react-router-dom";
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
  const [nameMou, setNamemou] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [agency, setAgency] = useState("");
  const [participant, setParticipant] = useState("");
  const [yos, setYos] = useState("");
  const [duration, setDuration] = useState("");
  const [activity, setActivity] = useState("");
  const [document1, setDocument1] = useState("");
  //const [link, setLink] = useState("");

  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [pathValueep22Display, setPathValueep22Display] = useState("");

  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallcollaborationLinkage").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setNamemou(data[0].collaborationsLinkages[0].inputclt1);
              setDepartment(data[0].collaborationsLinkages[0].inputclt2);
              setSchool(data[0].collaborationsLinkages[0].inputclt3);
              setAgency(data[0].collaborationsLinkages[0].inputclt4);
              setParticipant(data[0].collaborationsLinkages[0].inputclt5);
              setYos(data[0].collaborationsLinkages[0].inputclt6);
              setDuration(data[0].collaborationsLinkages[0].inputclt7);
              setActivity(data[0].collaborationsLinkages[0].inputclt8);
              setDocument1(data[0].collaborationsLinkages[0].inputclt9);
              setValueep22(
                data[0].collaborationsLinkagesFileUpload[0]
                  .collaborationsLinkagesFilePath
              );
              setPathValueep22Display(
                data[0].collaborationsLinkagesFileUpload[0]
                  .collaborationsLinkagesFileName
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
        inputclt9: document,
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



  function onClickingCollaborationLinkages(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(JSON.stringify(inputCollaborationLinkages));
if(pathValueep22 !== ""){
    basicData.append(
      "collaborationsFiles",
      valueep22,
      "ep22-" + valueep22.name
    );
    }
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
      "http://localhost:8080/api/v1/collaborationData",
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
    <div className="collaborationslinkages-container">
      <h1 className="collaborationslinkages-heading-style">
        Collaborations / linkages
      </h1>
      <div className="collaborationslinkages-eachTable-container">
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
                  onChange={(e) => setNamemou(e.target.value)}
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
                  onChange={(e) => setDepartment(e.target.value)}
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
                  onChange={(e) => setSchool(e.target.value)}
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
                  onChange={(e) => setAgency(e.target.value)}
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
                  onChange={(e) => setParticipant(e.target.value)}
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
                  onChange={(e) => setYos(e.target.value)}
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
                  onChange={(e) => setDuration(e.target.value)}
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
                  onChange={(e) => setActivity(e.target.value)}
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
                  o
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
          <div className="collaborationLinkages-button-container">
            <button
              className="collaborationLinkages-button-style"
              onClick={onClickingCollaborationLinkages}
            >
               Modify
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
