import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import "./c1-style.css";
import { resources } from "../../appConstants";
import AuthService from "../../Pages/Users/services/auth.service";

import Criteria11 from "../Authorize HOD/ViewHOD/CriteriaView-1/cV11/c11";
import Criteria12 from "../Authorize HOD/ViewHOD/CriteriaView-1/cV12/c12";
import Criteria13 from "../Authorize HOD/ViewHOD/CriteriaView-1/cV13/c13";
import Criteria14 from "../Authorize HOD/ViewHOD/CriteriaView-1/cV14/c14";

import {
  AssignPopup1,
  AssignPopup11,
  AssignPopup12,
  AssignPopup13,
  AssignPopup14,
} from "./assignPopup1.js";

// Alert custom messages start
const successMessage = (message) => {
  toast.success(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "success1",
  });
};
const errorMessage = (message) => {
  toast.error(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "error1",
  });
};

function Criteria1() {
  // state variables
  const [screenStatus11, setScreenStatus11] = useState(false);
  const [screenStatus12, setScreenStatus12] = useState(false);
  const [screenStatus13, setScreenStatus13] = useState(false);
  const [screenStatus14, setScreenStatus14] = useState(false);
  const [assignStatus1, setAssignStatus1] = useState(false);
  const [assignStatus11, setAssignStatus11] = useState(false);
  const [assignStatus12, setAssignStatus12] = useState(false);
  const [assignStatus13, setAssignStatus13] = useState(false);
  const [assignStatus14, setAssignStatus14] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState("");
  const [principalComments, setPrincipalComments] = useState(null);
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  const [isreject,setreject]= useState(false);
  const [isdisabled,setdisabled]= useState(false);
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




  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'getTrackingInfo?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log("data for tracking info " + JSON.stringify(data));
            if (data[0]) {
              setPrincipalComments(data[0].principalComments);
            }
          })
          .catch((error) => {
            console.error("Error:", error);
            errorMessage("Got the Error Please try after sometime");
          })
      ),
    []
  );

  let role = null;
  let email = null;
  // eslint-disable-next-line prefer-destructuring
  role = AuthService.getCurrentUser().roles[0];
  email = AuthService.getCurrentUser().email;
  const authorizeContent = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    assignedTo: "keerthanakr555@gmail.com",
    principalStatus: "A",
    role:role,
    programmerId:"Criteria1"
  };
  const rejectContent = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    assignedTo: "keerthanakr555@gmail.com",
    role:role,
    principalComments: rejectReasonComments,
    principalStatus: "R",
    programmerId:"Criteria1"
  };
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }
  function onConfirmingReject() {
    console.log("Rejected");
    const rejectAPImethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(rejectContent),
    };
    fetch(resources.APPLICATION_URL + "principalRejectEmail", rejectAPImethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Record is Rejected Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
  }
  function onClickingSaveSendingTexts() {
    console.log("Assigned");
    const authorizeAPImethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(authorizeContent),
    };
    fetch(
      resources.APPLICATION_URL
        + "principalAuthorizedEmail",
      authorizeAPImethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record Authorized Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }

  // rendering DOM
  return (
    <div className="c1-container">
      {/* Criteria Heading */}
      <div className="c1-heading-container">
        <h1 className="c1-heading-style">Curricular Aspects (100)</h1>
        {/* <button
          onClick={() => setAssignStatus1(true)}
          className="cx-assign-button-style"
        >
          Assign
        </button> */}
        <AssignPopup1
          isAssign1Clicked={assignStatus1}
          setIsAssign1Clicked={setAssignStatus1}
        />
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 1.1 */}
      <div className="c1x-container">
        <div className="c1x-subContainer">
          <h1
            onClick={() => setScreenStatus11(!screenStatus11)}
            className="c1x-heading-style"
          >
            1.1: Curriculum Design and Development (20)
          </h1>
          {/* <button
            onClick={() => setAssignStatus11(true)}
            className="c1x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup11
            isAssign11Clicked={assignStatus11}
            setIsAssign11Clicked={setAssignStatus11}
          />
        </div>
      </div>
      {screenStatus11 ? <Criteria11 /> : null}

      {/* Key Indicator: 1.2 */}
      <div className="c1x-container">
        <div className="c1x-subContainer">
          <h1
            onClick={() => setScreenStatus12(!screenStatus12)}
            className="c1x-heading-style"
          >
            1.2: Academic Flexibility (30)
          </h1>
          {/* <button
            onClick={() => setAssignStatus12(true)}
            className="c1x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup12
            isAssign12Clicked={assignStatus12}
            setIsAssign12Clicked={setAssignStatus12}
          />
        </div>
      </div>
      {screenStatus12 ? <Criteria12 /> : null}

      {/* Key Indicator: 1.3 */}
      <div className="c1x-container">
        <div className="c1x-subContainer">
          <h1
            onClick={() => setScreenStatus13(!screenStatus13)}
            className="c1x-heading-style"
          >
            1.3: Curriculum Enrichment (30)
          </h1>
          {/* <button
            onClick={() => setAssignStatus13(true)}
            className="c1x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup13
            isAssign13Clicked={assignStatus13}
            setIsAssign13Clicked={setAssignStatus13}
          />
        </div>
      </div>
      {screenStatus13 ? <Criteria13 /> : null}

      {/* Key Indicator: 1.4 */}
      <div className="c1x-container">
        <div className="c1x-subContainer">
          <h1
            onClick={() => setScreenStatus14(!screenStatus14)}
            className="c1x-heading-style"
          >
            1.4: Feedback System (20)
          </h1>
          {/* <button
            onClick={() => setAssignStatus14(true)}
            className="c1x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup14
            isAssign14Clicked={assignStatus14}
            setIsAssign14Clicked={setAssignStatus14}
          />
        </div>
      </div>
      {screenStatus14 ? <Criteria14 /> : null}

    
      <div className="c31x-button-container">
        <button
         type='button'
         disabled = {isdisabled}
          onClick={() => {
            onClickingSaveSendingTexts();
            setreject(true);
            setdisabled(true);
          }}
          className="c31x-button-style"
          style={{ color: "white", backgroundColor: "green" }}
        >
          Authorize
        </button>

        <button
         type='button'
         disabled={isreject}
          onClick={() => {
            setRejectButtonClickStatus(true);
            setreject(true);
            setdisabled(true);
            console.log('hgh')
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
              onClick={() => {setRejectButtonClickStatus(false);
                setreject(false);
                setdisabled(false);
              }}
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
              onClick={() => {
                setRejectButtonClickStatus(false);
                onConfirmingReject();
                setreject(true);
                setdisabled(true);
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
    </div>
  );
}

export default Criteria1;
