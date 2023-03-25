import React, { useState, useEffect } from 'react';
import { toast } from "react-toastify";
import { resources } from '../../appConstants.js';
import AuthService from '../../Pages/Users/services/auth.service.js';

import './c2-style.css';
import Criteria21 from './ViewHOD/CriteriaView-2/cV21/c21.js';
import Criteria22 from './ViewHOD/CriteriaView-2/cV22/c22.js';
import Criteria23 from './ViewHOD/CriteriaView-2/cV23/c23.js';
import Criteria24 from './ViewHOD/CriteriaView-2/cV24/c24.js';
import Criteria25 from './ViewHOD/CriteriaView-2/cV25/c25.js';
import Criteria26 from './ViewHOD/CriteriaView-2/cV26/c26.js';
import Criteria27 from './ViewHOD/CriteriaView-2/cV27/c27.js';




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


function CriteriaAuthzeHod2() {
  // state variables
  const [screenStatus21, setScreenStatus21] = useState(false);
  const [screenStatus22, setScreenStatus22] = useState(false);
  const [screenStatus23, setScreenStatus23] = useState(false);
  const [screenStatus24, setScreenStatus24] = useState(false);
  const [screenStatus25, setScreenStatus25] = useState(false);
  const [screenStatus26, setScreenStatus26] = useState(false);
  const [screenStatus27, setScreenStatus27] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState('');
  const [principalComments, setPrincipalComments] = useState(null);
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);

  // const financialYear="2021-2022";

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
        "http://localhost:8080/api/v1/getTrackingInfo?collegeId=" +
          collegeId +
          "&financialYear=" +
          fYear +
          "&typeofInstitution=" +
          instituteType
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
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    assignedTo: "deepak.adiversetech@gmail.com",
    assignedBy: email,
    deanComments: "",
    role:role,
    status: "A",
  };
  const rejectContent = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    assignedTo: "deepak.adiversetech@gmail.com",
    assignedBy: email,
    deanComments: rejectReasonComments,
    role:role,
    status: "R",
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
    fetch(
      resources.APPLICATION_URL +
        "deanRejectRecord?institutionType=" +
        instituteType,
      rejectAPImethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record Rejected Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
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
      resources.APPLICATION_URL +
        "criteria2submittoprincipal?collegeId=" +
        collegeId +
        "&financialYear=" +
        fYear +
        "&typeofInstitution=" +
        instituteType,
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

  // function onClickingSaveSendingTexts() {
  //   console.log("Assigned");
  //   const authorizeAPImethod = {
  //     method: "POST",
  //     headers: { Accept: "application/json" },
  //     authorization:
  //       "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
  //     body: jsonBlob(authorizeContent),
  //   };
  //   fetch(
  //     resources.APPLICATION_URL + "deanAuthorizedEmail?institutionType=autonomous",
  //     authorizeAPImethod
  //   ).then((response) => {
  //     console.log(response);
  //     if (response.ok) {
  //       successMessage("Record Authorized Successfully");
  //     } else if (response.status >= 400) {
  //       errorMessage("Got the Error Please retry after sometime");
  //     }
  //   });
  // }

  // rendering DOM
  return (
    <div className="c2-container">
      {/* Criteria Heading */}
      <div className="c2-heading-container">
        <h1 className="c2-heading-style">
        Teaching-Learning and Evaluation (300)
        </h1>
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 2.1 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus21(!screenStatus21)}
            className="c2x-heading-style"
          >
            2.1: Student Enrolment and Profile (20)

          </h1>
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
            2.2:  Catering to Student Diversity (30)

          </h1>
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
            2.3:Teaching - Learning Process (50)

          </h1>
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
            2.4: Teacher Profile and Quality (50)

          </h1>
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
            2.5: Evaluation Process and Reforms (50)
          </h1>
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
            2.6: Student Performance and Learning Outcomes (50)

          </h1>
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
            2.7: Student Satisfaction Survey (50)

          </h1>
        </div>
      </div>
      {screenStatus27 ? <Criteria27 /> : null}
      
      <div className="c31x-button-container">
        <button
          onClick={() => {
            onClickingSaveSendingTexts();
          }}
          className="c31x-button-style"
          style={{ color: "white", backgroundColor: "green" }}
        >
          Authorize
        </button>

        <button
          onClick={() => {
            setRejectButtonClickStatus(true);
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
              onClick={() => {
                setRejectButtonClickStatus(false);
                onConfirmingReject();
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

export default CriteriaAuthzeHod2;
