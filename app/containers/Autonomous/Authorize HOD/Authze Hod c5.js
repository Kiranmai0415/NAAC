import React, { useState, useEffect } from 'react';
import { toast } from "react-toastify";
import './c5-style.css';
import AuthService from "../../Pages/Users/services/auth.service";

import Criteria51 from './ViewHOD/CriteriaView-5/cV51/c51.js';
import Criteria52 from './ViewHOD/CriteriaView-5/cV52/c52.js';
import Criteria53 from './ViewHOD/CriteriaView-5/cV53/c53.js';
import Criteria54 from './ViewHOD/CriteriaView-5/cV54/c54.js';
import { resources } from '../../appConstants.js';

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

function CriteriaAuthzeHod5() {
  // state variables
  const [screenStatus51, setScreenStatus51] = useState(false);
  const [screenStatus52, setScreenStatus52] = useState(false);
  const [screenStatus53, setScreenStatus53] = useState(false);
  const [screenStatus54, setScreenStatus54] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState('');
  const [principalComments, setPrincipalComments] = useState(null);
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);

  // const financialYear = "2021-2022";

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
        "criteria5submittoprincipal?collegeId=" +
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

  // rendering DOM
  return (
    <div className="c5-container">
      {/* Criteria Heading */}
      <div className="c5-heading-container">
        <h1 className="c5-heading-style">Student Support and Progression (100)
</h1>
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 5.1 */}
      <div className="c5x-container">
        <div className="c5x-subContainer">
          <h1
            onClick={() => setScreenStatus51(!screenStatus51)}
            className="c5x-heading-style"
          >
           5.1 Student Support (30)
          </h1>
        </div>
      </div>
      {screenStatus51 ? <Criteria51 /> : null}

      {/* Key Indicator: 5.2 */}
      <div className="c5x-container">
        <div className="c5x-subContainer">
          <h1
            onClick={() => setScreenStatus52(!screenStatus52)}
            className="c5x-heading-style"
          >
          5.2 Student Progression (30)
          </h1>
        </div>
      </div>
      {screenStatus52 ? <Criteria52 /> : null}

      {/* Key Indicator: 5.3 */}
      <div className="c5x-container">
        <div className="c5x-subContainer">
          <h1
            onClick={() => setScreenStatus53(!screenStatus53)}
            className="c5x-heading-style"
          >
           5.3 Student Participation and Activities (30)

          </h1>
        </div>
      </div>
      {screenStatus53 ? <Criteria53 /> : null}

      {/* Key Indicator: 5.4 */}
      <div className="c5x-container">
        <div className="c5x-subContainer">
          <h1
            onClick={() => setScreenStatus54(!screenStatus54)}
            className="c5x-heading-style"
          >
            5.4 Alumni Engagement (10)
          </h1>
        </div>
      </div>
      {screenStatus54 ? <Criteria54 /> : null}
      <div>Principal Comments : {principalComments}</div>
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

export default CriteriaAuthzeHod5;
