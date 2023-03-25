import React, { useState,useEffect } from 'react';
import { toast } from "react-toastify";
import { resources } from '../../appConstants.js';

import './c7-style.css';
import AuthService from "../../Pages/Users/services/auth.service";

import Criteria71 from './ViewHOD/CriteriaView-7/cV71/c71.js';
import Criteria72 from './ViewHOD/CriteriaView-7/cV72/c72.js';
import Criteria73 from './ViewHOD/CriteriaView-7/cV73/c73.js';


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


function CriteriaAuthzeHod7() {
  // state variables
  const [screenStatus71, setScreenStatus71] = useState(false);
  const [screenStatus72, setScreenStatus72] = useState(false);
  const [screenStatus73, setScreenStatus73] = useState(false);
  const [rejectReasonComments, setRejectReasonComments ] = useState('');
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
        "criteria7submittoprincipal?collegeId=" +
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
    <div className="c7-container">
      {/* Criteria Heading */}
      <div className="c7-heading-container">
        <h1 className="c7-heading-style">
        Institutional Values and Best Practices (100)
        </h1>
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 7.1 */}
      <div className="c7x-container">
        <div className="c7x-subContainer">
          <h1
            onClick={() => setScreenStatus71(!screenStatus71)}
            className="c7x-heading-style"
          >
            7.1 Institutional Values and Social Responsibilities (50)
          </h1>
        </div>
      </div>
      {screenStatus71 ? <Criteria71 /> : null}

      {/* Key Indicator: 7.2 */}
      <div className="c7x-container">
        <div className="c7x-subContainer">
          <h1
            onClick={() => setScreenStatus72(!screenStatus72)}
            className="c7x-heading-style"
          >
        7.2 Best Practices (30) 
          </h1>
        </div>
      </div>
      {screenStatus72 ? <Criteria72 /> : null}

      {/* Key Indicator: 7.3 */}
      <div className="c7x-container">
        <div className="c7x-subContainer">
          <h1
            onClick={() => setScreenStatus73(!screenStatus73)}
            className="c7x-heading-style"
          >
            7.3 Institutional Distinctiveness (20)
          </h1>
        </div>
      </div>
      {screenStatus73 ? <Criteria73 /> : null}
    
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

export default CriteriaAuthzeHod7;
