import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import "./c1-style.css";
import AuthService from "../../Pages/Users/services/auth.service";
import { resources } from "../../appConstants";

import Criteria11 from "./ViewHOD/CriteriaView-1/cV11/c11.js";
import Criteria12 from "./ViewHOD/CriteriaView-1/cV12/c12.js";
import Criteria13 from "./ViewHOD/CriteriaView-1/cV13/c13.js";
import Criteria14 from "./ViewHOD/CriteriaView-1/cV14/c14.js";

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

function CriteriaAuthzehod1() {
  // state variables
  const [screenStatus11, setScreenStatus11] = useState(false);
  const [screenStatus12, setScreenStatus12] = useState(false);
  const [screenStatus13, setScreenStatus13] = useState(false);
  const [screenStatus14, setScreenStatus14] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState("");
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
      resources.APPLICATION_URL + "deanRejectRecord?institutionType=autonomous",
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
        "criteria1submittoprincipal?collegeId=" +
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
    <div className="c1-container">
      {/* Criteria Heading */}
      <div className="c1-heading-container">
        <h1 className="c1-heading-style">Curricular Aspects(150)</h1>
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 1.1 */}
      <div className="c1x-container">
        <div className="c1x-subContainer">
          <h1
            onClick={() => setScreenStatus11(!screenStatus11)}
            className="c1x-heading-style"
          >
            1.1: Curriculum Design and Development(50)
          </h1>
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
            1.2: Academic Flexibility(30)
          </h1>
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
            1.3: Curriculum Enrichment (40)
          </h1>
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
        </div>
      </div>
      {screenStatus14 ? <Criteria14 /> : null}

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

export default CriteriaAuthzehod1;
