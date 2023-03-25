import React, { useState, useEffect } from 'react';
import { toast } from "react-toastify";
import './c3-style.css';
import { resources } from '../../appConstants';
import AuthService from '../../Pages/Users/services/auth.service';

import Criteria31 from '../Authorize HOD/ViewHOD/CriteriaView-3/cV31/c31';
import Criteria32 from '../Authorize HOD/ViewHOD/CriteriaView-3/cV32/c32';
import Criteria33 from '../Authorize HOD/ViewHOD/CriteriaView-3/cV33/c33';
import Criteria34 from '../Authorize HOD/ViewHOD/CriteriaView-3/cV34/c34';
import Criteria35 from '../Authorize HOD/ViewHOD/CriteriaView-3/cV35/c35';
import Criteria36 from '../Authorize HOD/ViewHOD/CriteriaView-3/cV36/c36';
import Criteria37 from '../Authorize HOD/ViewHOD/CriteriaView-3/cV37/c37';

import {
  AssignPopup3,
  AssignPopup31,
  AssignPopup32,
  AssignPopup33,
  AssignPopup34,
  AssignPopup35,
  AssignPopup36,
  AssignPopup37,
} from './assignPopup3.js';

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

function Criteria3() {
  // state variables
  const [screenStatus31, setScreenStatus31] = useState(false);
  const [screenStatus32, setScreenStatus32] = useState(false);
  const [screenStatus33, setScreenStatus33] = useState(false);
  const [screenStatus34, setScreenStatus34] = useState(false);
  const [screenStatus35, setScreenStatus35] = useState(false);
  const [screenStatus36, setScreenStatus36] = useState(false);
  const [screenStatus37, setScreenStatus37] = useState(false);
  const [assignStatus3, setAssignStatus3] = useState(false);
  const [assignStatus31, setAssignStatus31] = useState(false);
  const [assignStatus32, setAssignStatus32] = useState(false);
  const [assignStatus33, setAssignStatus33] = useState(false);
  const [assignStatus34, setAssignStatus34] = useState(false);
  const [assignStatus35, setAssignStatus35] = useState(false);
  const [assignStatus36, setAssignStatus36] = useState(false);
  const [assignStatus37, setAssignStatus37] = useState(false);
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
    programmerId:"Criteria3",
    principalStatus: "A",
  };
  const rejectContent = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
    assignedTo: "keerthanakr555@gmail.com",
    assignedBy: email,
    role:role,
    principalComments: rejectReasonComments,
    principalStatus: "R",
    programmerId:"Criteria3"
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
    <div className="c3-container">
      {/* Criteria Heading */}
      <div className="c3-heading-container">
        <h1 className="c3-heading-style">
          Research, Innovations and Extensions (110)
        </h1>
        {/* <button
          onClick={() => setAssignStatus3(true)}
          className="cx-assign-button-style"
        >
          Assign
        </button> */}
        <AssignPopup3
          isAssign3Clicked={assignStatus3}
          setIsAssign3Clicked={setAssignStatus3}
        />
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 3.1 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus31(!screenStatus31)}
            className="c3x-heading-style"
          >
            3.1- Resource Mobilization for Research (10)
          </h1>
          {/* <button
            onClick={() => setAssignStatus31(true)}
            className="c3x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup31
            isAssign31Clicked={assignStatus31}
            setIsAssign31Clicked={setAssignStatus31}
          />
        </div>
      </div>
      {screenStatus31 ? <Criteria31 /> : null}

      {/* Key Indicator: 3.2 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus32(!screenStatus32)}
            className="c3x-heading-style"
          >
            3.2- Innovation Ecosystem (15)
          </h1>
          {/* <button
            onClick={() => setAssignStatus32(true)}
            className="c3x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup32
            isAssign32Clicked={assignStatus32}
            setIsAssign32Clicked={setAssignStatus32}
          />
        </div>
      </div>
      {screenStatus32 ? <Criteria32 /> : null}

      {/* Key Indicator: 3.3 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus33(!screenStatus33)}
            className="c3x-heading-style"
          >
           3.3- Research Publication and Awards (25)
          </h1>
          {/* <button
            onClick={() => setAssignStatus33(true)}
            className="c3x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup33
            isAssign33Clicked={assignStatus33}
            setIsAssign33Clicked={setAssignStatus33}
          />
        </div>
      </div>
      {screenStatus33 ? <Criteria33 /> : null}

      {/* Key Indicator: 3.4 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus34(!screenStatus34)}
            className="c3x-heading-style"
          >
           3.4- Extension Activities (40)
          </h1>
          {/* <button
            onClick={() => setAssignStatus34(true)}
            className="c3x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup34
            isAssign34Clicked={assignStatus34}
            setIsAssign34Clicked={setAssignStatus34}
          />
        </div>
      </div>
      {screenStatus34 ? <Criteria34 /> : null}

      {/* Key Indicator: 3.5 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus35(!screenStatus35)}
            className="c3x-heading-style"
          >
           3.5 - Collaboration (20)
          </h1>
          {/* <button
            onClick={() => setAssignStatus35(true)}
            className="c3x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup35
            isAssign35Clicked={assignStatus35}
            setIsAssign35Clicked={setAssignStatus35}
          />
        </div>
      </div>
      {screenStatus35 ? <Criteria35 /> : null}

      {/* Key Indicator: 3.6 */}
      {/* <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus36(!screenStatus36)}
            className="c3x-heading-style"
          >
            3.6: Extension Activities ()
          </h1> */}
          {/* <button
            onClick={() => setAssignStatus36(true)}
            className="c3x-assign-button-style"
          >
            Assign
          </button> */}
          {/* <AssignPopup36
            isAssign36Clicked={assignStatus36}
            setIsAssign36Clicked={setAssignStatus36}
          />
        </div> */}
      {/* </div>
      {screenStatus36 ? <Criteria36 /> : null} */}

      {/* Key Indicator: 3.7 */}
      {/* <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus37(!screenStatus37)}
            className="c3x-heading-style"
          >
            3.7: Collaboration
          </h1> */}
          {/* <button
            onClick={() => setAssignStatus37(true)}
            className="c3x-assign-button-style"
          >
            Assign
          </button> */}
          {/* <AssignPopup37
            isAssign37Clicked={assignStatus37}
            setIsAssign37Clicked={setAssignStatus37}
          />
        </div>
      </div>
      {screenStatus37 ? <Criteria37 /> : null} */}
      
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

export default Criteria3;
