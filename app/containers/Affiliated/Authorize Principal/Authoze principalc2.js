import React, { useState, useEffect } from 'react';
import { toast } from "react-toastify";
import './c2-style.css';
import { resources } from '../../appConstants';
import AuthService from '../../Pages/Users/services/auth.service';

import Criteria21 from '../Authorize HOD/ViewHOD/CriteriaView-2/cV21/c21';
import Criteria22 from '../Authorize HOD/ViewHOD/CriteriaView-2/cV22/c22';
import Criteria23 from '../Authorize HOD/ViewHOD/CriteriaView-2/cV23/c23';
import Criteria24 from '../Authorize HOD/ViewHOD/CriteriaView-2/cV24/c24';
import Criteria25 from '../Authorize HOD/ViewHOD/CriteriaView-2/cV25/c25';
import Criteria26 from '../Authorize HOD/ViewHOD/CriteriaView-2/cV26/c26';
import Criteria27 from '../Authorize HOD/ViewHOD/CriteriaView-2/cV27/c27';
import {
  AssignPopup2,
  AssignPopup21,
  AssignPopup22,
  AssignPopup23,
  AssignPopup24,
  AssignPopup25,
  AssignPopup26,
  AssignPopup27,
} from './assignPopup2.js';

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

function Criteria2() {
  // state variables
  const [screenStatus21, setScreenStatus21] = useState(false);
  const [screenStatus22, setScreenStatus22] = useState(false);
  const [screenStatus23, setScreenStatus23] = useState(false);
  const [screenStatus24, setScreenStatus24] = useState(false);
  const [screenStatus25, setScreenStatus25] = useState(false);
  const [screenStatus26, setScreenStatus26] = useState(false);
  const [screenStatus27, setScreenStatus27] = useState(false);
  const [assignStatus2, setAssignStatus2] = useState(false);
  const [assignStatus21, setAssignStatus21] = useState(false);
  const [assignStatus22, setAssignStatus22] = useState(false);
  const [assignStatus23, setAssignStatus23] = useState(false);
  const [assignStatus24, setAssignStatus24] = useState(false);
  const [assignStatus25, setAssignStatus25] = useState(false);
  const [assignStatus26, setAssignStatus26] = useState(false);
  const [assignStatus27, setAssignStatus27] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState('');
  const [principalComments, setPrincipalComments] = useState(null);
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
const [isreject,setreject]=useState(false);
const[isdisabeld,setdisabeld]=useState(false);


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
    () => fetch(
      resources.APPLICATION_URL+'getTrackingInfo?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
    ).then((response) => response
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
    principalStatus: "A",
    programmerId:"Criteria2",

   
  };
  const rejectContent = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    assignedTo: "keerthanakr555@gmail.com",
    assignedBy: email,
    role:role,
    principalComments: rejectReasonComments,
    principalStatus: "R",
    programmerId:"Criteria2"
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
    <div className="c2-container">
      {/* Criteria Heading */}
      <div className="c2-heading-container">
        <h1 className="c2-heading-style">
        Teaching Learning and Evaluation (350)
        </h1>
        {/* <button
          onClick={() => setAssignStatus2(true)}
          className="cx-assign-button-style"
        >
          Assign
        </button> */}
        <AssignPopup2
          isAssign2Clicked={assignStatus2}
          setIsAssign2Clicked={setAssignStatus2}
        />
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 2.1 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus21(!screenStatus21)}
            className="c2x-heading-style"
          >
            2.1: Student Enrolment and Profile (40)
          </h1>
          {/* <button
            onClick={() => setAssignStatus21(true)}
            className="c2x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup21
            isAssign21Clicked={assignStatus21}
            setIsAssign21Clicked={setAssignStatus21}
          />
        </div>
      </div>
      {screenStatus21 ? <Criteria21 /> : null}

      {/* Key Indicator: 2.2 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus22(!screenStatus22)}
            className="c2x-heading-style"
          >
            2.2:Student Teacher Ratio (40)
          </h1>
          {/* <button
            onClick={() => setAssignStatus22(true)}
            className="c2x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup22
            isAssign22Clicked={assignStatus22}
            setIsAssign22Clicked={setAssignStatus22}
          />
        </div>
      </div>
      {screenStatus22 ? <Criteria22 /> : null}

      {/* Key Indicator: 2.3 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus23(!screenStatus23)}
            className="c2x-heading-style"
          >
            2.3:Teaching-Learning Process (40)
          </h1>
          {/* <button
            onClick={() => setAssignStatus23(true)}
            className="c2x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup23
            isAssign23Clicked={assignStatus23}
            setIsAssign23Clicked={setAssignStatus23}
          />
        </div>
      </div>
      {screenStatus23 ? <Criteria23 /> : null}

      {/* Key Indicator: 2.4 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus24(!screenStatus24)}
            className="c2x-heading-style"
          >
            2.4: Teacher Profile and Quality (40)
          </h1>
          {/* <button
            onClick={() => setAssignStatus24(true)}
            className="c2x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup24
            isAssign24Clicked={assignStatus24}
            setIsAssign24Clicked={setAssignStatus24}
          />
        </div>
      </div>
      {screenStatus24 ? <Criteria24 /> : null}

      {/* Key Indicator: 2.5 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus25(!screenStatus25)}
            className="c2x-heading-style"
          >
            2.5: Evaluation Process and Reforms (40)
          </h1>
          {/* <button
            onClick={() => setAssignStatus25(true)}
            className="c2x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup25
            isAssign25Clicked={assignStatus25}
            setIsAssign25Clicked={setAssignStatus25}
          />
        </div>
      </div>
      {screenStatus25 ? <Criteria25 /> : null}

      {/* Key Indicator: 2.6 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus26(!screenStatus26)}
            className="c2x-heading-style"
          >
            2.6: Student Performance and Learning Outcomes (90)
          </h1>
          {/* <button
            onClick={() => setAssignStatus26(true)}
            className="c2x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup26
            isAssign26Clicked={assignStatus26}
            setIsAssign26Clicked={setAssignStatus26}
          />
        </div>
      </div>
      {screenStatus26 ? <Criteria26 /> : null}

      {/* Key Indicator: 2.7 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus27(!screenStatus27)}
            className="c2x-heading-style"
          >
            2.7: Student Satisfaction Survey (60)
          </h1>
          {/* <button
            onClick={() => setAssignStatus27(true)}
            className="c2x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup27
            isAssign27Clicked={assignStatus27}
            setIsAssign27Clicked={setAssignStatus27}
          />
        </div>
      </div>
      {screenStatus27 ? <Criteria27 /> : null}
      <div className="c31x-button-container">
        <button
        type='button'
        disabled={isdisabeld}
          onClick={() => {
            onClickingSaveSendingTexts();
            setdisabeld(true);
            setreject(true);
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
            setdisabeld(true);
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
            setdisabeld(false);
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
                setdisabeld(true);
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

export default Criteria2;
