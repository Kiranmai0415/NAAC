import React, { useState, useEffect } from 'react';
import { toast } from "react-toastify";
import './c6-style.css';
import AuthService from '../../Pages/Users/services/auth.service';
import { resources } from '../../appConstants';

import Criteria61 from '../Authorize HOD/ViewHOD/CriteriaView-6/cV61/c61';
import Criteria62 from '../Authorize HOD/ViewHOD/CriteriaView-6/cV62/c62';
import Criteria63 from '../Authorize HOD/ViewHOD/CriteriaView-6/cV63/c63';
import Criteria64 from '../Authorize HOD/ViewHOD/CriteriaView-6/cV64/c64';
import Criteria65 from '../Authorize HOD/ViewHOD/CriteriaView-6/cV65/c65';

import {
  AssignPopup6,
  AssignPopup61,
  AssignPopup62,
  AssignPopup63,
  AssignPopup64,
  AssignPopup65,
} from './assignPopup6.js';

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

function Criteria6() {
  // state variables
  const [screenStatus61, setScreenStatus61] = useState(false);
  const [screenStatus62, setScreenStatus62] = useState(false);
  const [screenStatus63, setScreenStatus63] = useState(false);
  const [screenStatus64, setScreenStatus64] = useState(false);
  const [screenStatus65, setScreenStatus65] = useState(false);
  const [assignStatus6, setAssignStatus6] = useState(false);
  const [assignStatus61, setAssignStatus61] = useState(false);
  const [assignStatus62, setAssignStatus62] = useState(false);
  const [assignStatus63, setAssignStatus63] = useState(false);
  const [assignStatus64, setAssignStatus64] = useState(false);
  const [assignStatus65, setAssignStatus65] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState('');
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
    assignedBy: email,
    role:role,
    programmerId:"Criteria6",
    principalStatus: "A",
  };
  const rejectContent = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
    assignedTo: "keerthanakr555@gmail.com",
    assignedBy: email,
    role:role,
    principalComments: rejectReasonComments,
    principalStatus: "R",
    programmerId:"Criteria6"
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
      resources.APPLICATION_URL + "principalAuthorizedEmail",
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
    <div className="c6-container">
      {/* Criteria Heading */}
      <div className="c6-heading-container">
        <h1 className="c6-heading-style">
        Governance, Leadership and Management (100)
        </h1>
        {/* <button
          onClick={() => setAssignStatus6(true)}
          className="cx-assign-button-style"
        >
          Assign
        </button> */}
        <AssignPopup6
          isAssign6Clicked={assignStatus6}
          setIsAssign6Clicked={setAssignStatus6}
        />
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 6.1 */}
      <div className="c6x-container">
        <div className="c6x-subContainer">
          <h1
            onClick={() => setScreenStatus61(!screenStatus61)}
            className="c6x-heading-style"
          >
            6.1: Institutional Vision and Leadership (15)
          </h1>
          {/* <button
            onClick={() => setAssignStatus61(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup61
            isAssign61Clicked={assignStatus61}
            setIsAssign61Clicked={setAssignStatus61}
          />
        </div>
      </div>
      {screenStatus61 ? <Criteria61 /> : null}

      {/* Key Indicator: 6.2 */}
      <div className="c6x-container">
        <div className="c6x-subContainer">
          <h1
            onClick={() => setScreenStatus62(!screenStatus62)}
            className="c6x-heading-style"
          >
            6.2:Strategy Development and Deployment (12)
          </h1>
          {/* <button
            onClick={() => setAssignStatus62(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup62
            isAssign62Clicked={assignStatus62}
            setIsAssign62Clicked={setAssignStatus62}
          />
        </div>
      </div>
      {screenStatus62 ? <Criteria62 /> : null}

      {/* Key Indicator: 6.3 */}
      <div className="c6x-container">
        <div className="c6x-subContainer">
          <h1
            onClick={() => setScreenStatus63(!screenStatus63)}
            className="c6x-heading-style"
          >
            6.3: Faculty Empowerment Strategies (33)
          </h1>
          {/* <button
            onClick={() => setAssignStatus63(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup63
            isAssign63Clicked={assignStatus63}
            setIsAssign63Clicked={setAssignStatus63}
          />
        </div>
      </div>
      {screenStatus63 ? <Criteria63 /> : null}

      {/* Key Indicator: 6.4 */}
      <div className="c6x-container">
        <div className="c6x-subContainer">
          <h1
            onClick={() => setScreenStatus64(!screenStatus64)}
            className="c6x-heading-style"
          >
            6.4: Financial Management and Resource Mobilization (10)
          </h1>
          {/* <button
            onClick={() => setAssignStatus64(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup64
            isAssign64Clicked={assignStatus64}
            setIsAssign64Clicked={setAssignStatus64}
          />
        </div>
      </div>
      {screenStatus64 ? <Criteria64 /> : null}

      {/* Key Indicator: 6.5 */}
      <div className="c6x-container">
        <div className="c6x-subContainer">
          <h1
            onClick={() => setScreenStatus65(!screenStatus65)}
            className="c6x-heading-style"
          >
            6.5: Internal Quality Assurance System (IQAS) (30)
          </h1>
          {/* <button
            onClick={() => setAssignStatus65(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup65
            isAssign65Clicked={assignStatus65}
            setIsAssign65Clicked={setAssignStatus65}
          />
        </div>
      </div>
      {screenStatus65 ? <Criteria65 /> : null}
     
   
      <div className="c31x-button-container">
        <button
        type='button'
        disabled={isdisabled}
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
                setdisabled(false);}}
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

export default Criteria6;
