import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import { resources } from "../../appConstants.js";
import AuthService from "../../Pages/Users/services/auth.service";
import "./c6-style.css";

import Criteria61 from "../Authorize HOD/ViewHOD/CriteriaView-6/cV61/c61.js";
import Criteria62 from "../Authorize HOD/ViewHOD/CriteriaView-6/cV62/c62.js";
import Criteria63 from "../Authorize HOD/ViewHOD/CriteriaView-6/cV63/c63.js";
import Criteria64 from "../Authorize HOD/ViewHOD/CriteriaView-6/cV64/c64.js";
import Criteria65 from "../Authorize HOD/ViewHOD/CriteriaView-6/cV65/c65.js";

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

function CriteriaAuthoze6() {
  // state variables
  const [screenStatus61, setScreenStatus61] = useState(false);
  const [screenStatus62, setScreenStatus62] = useState(false);
  const [screenStatus63, setScreenStatus63] = useState(false);
  const [screenStatus64, setScreenStatus64] = useState(false);
  const [screenStatus65, setScreenStatus65] = useState(false);
  const [principalComments, setPrincipalComments] = useState(null);
  const [isDisabled, setDisabled] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState("");
 const [isReject,setReject]=useState(false);
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
    programmerId: "Criteria6",
    principalStatus: "A",
  };
  const rejectContent = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    assignedTo: "deepak.adiversetech@gmail.com",
    assignedBy: email,
    principalComments: rejectReasonComments,
    principalStatus: "R",
    programmerId: "Criteria6",
  };
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }
  function onConfirmingReject() {
    console.log("Rejected");
    setDisabled(true);
    setReject(true);
    const rejectAPImethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(rejectContent),
    };
    fetch(
      resources.APPLICATION_URL +
        'principalRejectEmail',
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
    setDisabled(true);
    setReject(true);
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
  //     resources.APPLICATION_URL +
  //       "deanAuthorizedEmail?institutionType=autonomous",
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
    <div className="c6-container">
      {/* Criteria Heading */}
      <div className="c6-heading-container">
        <h1 className="c6-heading-style">
          Governance, Leadership and Management
        </h1>
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 6.1 */}
      <div className="c6x-container">
        <div className="c6x-subContainer">
          <h1
            onClick={() => setScreenStatus61(!screenStatus61)}
            className="c6x-heading-style"
          >
            6.1: Institutional Vision and Leadership
          </h1>
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
            6.2:Strategy Development and Deployment
          </h1>
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
            6.3: Faculty Empowerment Strategies
          </h1>
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
            6.4: Financial Management and Resource Mobilization
          </h1>
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
            6.5: Internal Quality Assurance System (IQAS)
          </h1>
        </div>
      </div>
      {screenStatus65 ? <Criteria65 /> : null}

      <div className="c31x-button-container">
        <button
         type = "button"
         disabled={isDisabled}
          onClick={() => {
            onClickingSaveSendingTexts();
          }}
          className="c31x-button-style"
          style={{ color: "white", backgroundColor: "green" }}
        >
          Authorize
        </button>

        <button
        type="button"
        disabled={isReject}
          onClick={() => {
            setReject(true);
            setDisabled(true);
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
              onClick={() => {setRejectButtonClickStatus(false);
              setReject(false);
            setDisabled(false);}}
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

export default CriteriaAuthoze6;
