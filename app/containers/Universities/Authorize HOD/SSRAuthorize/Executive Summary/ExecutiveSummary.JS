import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./Executive Summary-style.css";
import { resources } from "../../../../appConstants";
import AuthService from "../../../../Pages/Users/services/auth.service";

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

function ExecutiveSummary() {
  const [valuees1, setValuees1] = useState("");
  const [valuees2, setValuees2] = useState("");
  const [valuees3, setValuees3] = useState("");
  const [valuees4, setValuees4] = useState("");
  const [valuees5, setValuees5] = useState("");
  const [valuees6, setValuees6] = useState([]);
  const [pathValuees6, setPathValuees6] = useState("");
  const [valuees7, setValuees7] = useState("");
  const [valuees8, setValuees8] = useState("");
  const [valuees9, setValuees9] = useState("");
  const [valuees10, setValuees10] = useState("");
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState("");
  const [principalComments, setPrincipalComments] = useState(null);

  console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
  let instituteType = AuthService.getCurrentUser().instituteType;
  console.log("instituteType=======>" + instituteType);
  const collegeId = AuthService.getCurrentUser().collegeId;
  console.log("eamcetCode==========>" + collegeId);
  const d = new Date();
  let currYear = d.getFullYear();
  console.log("var ==>" + currYear);
  let fYear = parseInt(currYear) - 1 + "-" + currYear;
  console.log("current year==" + fYear);
  

// get call
const financialYear="2021-2022";
useEffect(
  () => fetch('http://localhost:8080/api/v1/getallexecutivedata?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
    (response) => response
      .json()
      .then((data) => {
        setValuees1(data[0]?data[0].inputes1:"");
        setValuees2(data[0]?data[0].inputes2:"");
        setValuees3(data[0]?data[0].inputes3:"");
        setValuees4(data[0]?data[0].inputes4:"");
        setValuees5(data[0]?data[0].inputes5:"");
        setValuees7(data[0]?data[0].inputes7:"");
        setValuees8(data[0]?data[0].inputes8:"");
        setValuees9(data[0]?data[0].inputes9:"");
        setValuees10(data[0]?data[0].inputes10:"");
      })
      .catch((error) => {
        console.error("Error:", error);
      })
  ),
  []
);



let role = null;
let email = null;
// eslint-disable-next-line prefer-destructuring
role = AuthService.getCurrentUser().roles[0];
email = AuthService.getCurrentUser().email;
const finacialyear = "2021-2022";
const authorize = {
  criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

  assignedTo: "deepak.adiversetech@gmail.com",
  assignedBy: email,
  role:role,
  deanStatus: "A",
  programmerId: "executivesummary",
};

const rejectContent = {
  criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

  assignedTo: "deepak.adiversetech@gmail.com",
  assignedBy: email,
  role:role,
  deanStatus: "R",
  deanComments: rejectReasonComments,
  programmerId: "executivesummary",
};
// eslint-disable-next-line no-redeclare
function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: "application/json",
  });
}
function getAuthorizeExecutive(e) {
  e.preventDefault();
  console.log("Authorize IIQA");
  const authAPIMethod = {
    method: "POST",
    headers: { Accept: "application/json" },
    authorization:
      "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
    body: jsonBlob(authorize),
  };
  fetch(
    resources.APPLICATION_URL +
    'executiveDatasubmittoprincipal?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
    authAPIMethod
  ).then((response) => {
    console.log(response);
    if (response.ok) {
      successMessage("Record Authorized Successfully");
    } else if (response.status >= 400) {
      errorMessage("Got the Error Please retry after sometime");
    }
  });
}
function getRejectExecutive(e) {
  e.preventDefault();
  console.log("Assigned");
  const rejectAPImethod = {
    method: "POST",
    headers: { Accept: "application/json" },
    authorization:
      "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
    body: jsonBlob(rejectContent),
  };
  fetch(
    resources.APPLICATION_URL +
    'evaluativeReportDeanRejectRecord?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
    rejectAPImethod
  ).then((response) => {
    console.log(response);
    if (response.ok) {
      successMessage("Record is Rejected Successfully");
    } else if (response.status >= 400) {
      errorMessage("Got the Error Please retry after sometime");
    }
    window.location.reload(false);
  });
}
  return (
    <div className="executive-main-container">
      <form>
        <div className="executive-heading">
          <h1>Executive Summary</h1>
        </div>

        <div className="executive-eachTable-container">
          <div style={{ margin: "10px" }}>
            <label htmlFor="es1">1.Introductory Note on the Institution</label>
            <textarea
              className="input-text"
              id="es1"
              rows="6"
              cols="95"
              placeholder="Describe in maximum 500 words"
              onChange={(e) => setValuees1(e.target.value)}
              value={valuees1}
            ></textarea>
            {valuees1.length === 500 ? (
              <p style={{ color: "red" }}>This is a required question</p>
            ) : null}
          </div>
          <div style={{ margin: "10px" }}>
            <label htmlFor="es2">Vision</label>
            <textarea
              className="input-text"
              id="es2"
              rows="6"
              cols="60"
              style={{ width: "100%" }}
              placeholder="Describe in maximum 350 words"
              onChange={(e) => setValuees2(e.target.value)}
              value={valuees2}
            ></textarea>
          </div>
          <div style={{ margin: "10px" }}>
            <label>Mission</label>
            <textarea
              className="input-text"
              id="es3"
              rows="6"
              cols="60"
              style={{ width: "100%" }}
              placeholder="Describe in maximum 350 words"
              onChange={(e) => setValuees3(e.target.value)}
              value={valuees3}
            ></textarea>
          </div>
          <div style={{ margin: "10px" }}>
            <label htmlFor="es4" style={{ marginRight: "10px" }}>
              Location
            </label>
            <input readonly
              className="input-text"
              id="es4"
              type="text"
              style={{ width: "100%" }}
              placeholder="Location"
              onChange={(e) => setValuees4(e.target.value)}
              value={valuees4}
            />
          </div>
          <div style={{ margin: "10px" }}>
            <label htmlFor="es5" style={{ marginRight: "10px" }}>
              Type of the Institution
            </label>
            <input readonly
              className="input-text"
              id="es5"
              type="text"
              style={{ width: "100%" }}
              onChange={(e) => setValuees5(e.target.value)}
              value={valuees5}
            />
          </div>
          <div style={{ margin: "10px" }}>
            <label htmlFor="es6" style={{ marginRight: "10px" }}>
              File upload
            </label>
            <input readonly
              className="input-text"
              id="es6"
              type="file"
              onChange={(e) => {
                setValuees6(e.target.files[0]);
                setPathValuees6(e.target.value);
              }}
            />
            {pathValuees6 === "" ? null : (
              <div className="c21-fileButtons-container">
                <button className="c21-viewFileButton-style">View File</button>
                <button className="c21-removeFileButton-style">
                  Remove File
                </button>
              </div>
            )}
          </div>
        </div>
        <div className="executive-eachTable-container">
          <label htmlFor="es7">
            2.Criterion-wise Summary on the Institution
          </label>
          <textarea
            id="es7"
            className="input-text"
            rows="6"
            cols="42"
            placeholder="Describe in maximum 250 words"
            onChange={(e) => setValuees7(e.target.value)}
            value={valuees7}
          ></textarea>
        </div>
        <div className="executive-eachTable-container">
          <label htmlFor="es8">
            3.Brief note on the Strength Weakness Opportunities and
            Challenges(SWOC) in respect of the Institution
          </label>
          <textarea
            id="es8"
            className="input-text"
            rows="6"
            cols="120"
            placeholder="Describe in maximum 500 words"
            onChange={(e) => setValuees8(e.target.value)}
            value={valuees8}
          ></textarea>
        </div>
        <div className="executive-eachTable-container">
          <label htmlFor="es9">
            4.Any additional information about the Institution other than ones
            already stated.
          </label>
          <textarea
            id="es9"
            className="input-text"
            rows="6"
            cols="95"
            placeholder="Describe in maximum 500 words"
            onChange={(e) => setValuees9(e.target.value)}
            value={valuees9}
          ></textarea>
        </div>
        <div className="executive-eachTable-container">
          <label htmlFor="es10">
            5.Over all conclusive explication about the institution's
            functioning
          </label>
          <textarea
            id="es10"
            className="input-text"
            rows="6"
            cols="95"
            placeholder="Describe in maximum 500 words"
            onChange={(e) => setValuees10(e.target.value)}
            value={valuees10}
          ></textarea>
        </div>
      
        <div>Principal Comments : {principalComments}</div>
        <div className="c31x-button-container">
          <button
            onClick={(e) => {
              getAuthorizeExecutive(e);
            }}
            className="c31x-button-style"
            style={{ color: "white", backgroundColor: "green" }}
          >
            Authorize
          </button>

          <button
            onClick={(e) => {
              setRejectButtonClickStatus(true);
              e.preventDefault();
            }}
            className="c31x-button-style"
            style={{ color: "white", backgroundColor: "red" }}
          >
            Reject
          </button>
        </div>
        {rejectButtonClickStatus ? (
          <div style={{ marginLeft: "13%" }}>
            <h1>Reason for Rejection</h1>
            <textarea
              cols={110}
              rows={6}
              onChange={(e) => setRejectReasonComments(e.target.value)}
            ></textarea>
            <div>
              <button
                onClick={() => setRejectButtonClickStatus(false)}
                style={{
                  color: "black",
                  backgroundColor: "white",
                  borderRadius: "4px",
                  marginRight: "3%",
                  boxShadow:
                    "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
                }}
              >
                Cancel
              </button>
              <button
                onClick={(e) => {
                  setRejectButtonClickStatus(false);
                  getRejectExecutive(e);
                }}
                style={{
                  color: "black",
                  backgroundColor: "white",
                  borderRadius: "4px",
                  boxShadow:
                    "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
                }}
              >
                Confirm Reject
              </button>
            </div>
          </div>
        ) : null}
      </form>
    </div>
  );
}
export default ExecutiveSummary;
