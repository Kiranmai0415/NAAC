import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import "./EvaluativeReport-style.css";

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

function EvaluativeReport() {
  const [valuet1, setValuet1] = useState("");
  const [valuet2, setValuet2] = useState("");
  const [valuet3, setValuet3] = useState("");
  const [valuet4, setValuet4] = useState("");
  const [valuef1, setValuef1] = useState();
  const [pathValuef1, setPathValuef1] = useState("");
  const [valuef2, setValuef2] = useState();
  const [pathValuef2, setPathValuef2] = useState("");
  const [valuef3, setValuef3] = useState();
  const [pathValuef3, setPathValuef3] = useState("");
  const [valuef4, setValuef4] = useState();
  const [pathValuef4, setPathValuef4] = useState("");
  const [principalComments, setPrincipalComments] = useState(null);
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState("");
  // get call

  useEffect(
    () => fetch(resources.APPLICATION_URL+"evaluativedata").then((response) => response
      .json()
      .then((data) => {
        console.log(JSON.stringify(data));
        setValuet1(data[0].evaluativeReport[0].valuet1);
        setValuet2(data[1].evaluativeReport[1].valuet1);
        setValuet3(data[2].evaluativeReport[2].valuet1);
        setValuet4(data[3].evaluativeReport[3].valuet1);
      })
      .catch((error) => {
        console.error("Error:", error);
      })
    ),
    []
  );

  // sending data to db with API

  const inputDataList = {
    inputt1: valuet1,
    inputt2: valuet2,
    inputt3: valuet3,
    inputt4: valuet4,
  };

  let role = null;
  let email = null;
  // eslint-disable-next-line prefer-destructuring, no-undef
  role = AuthService.getCurrentUser().roles[0];
  // eslint-disable-next-line no-undef
  email = AuthService.getCurrentUser().email;
  const finacialyear = "2021-2022";
  const authorize = {
    criteriaId: {
      collegeId: "1",
      financialYear: finacialyear,
      typeofInstitution: "affilated",
    },
    assignedTo: email,
    assignedBy: email,
    principalStatus: "A",
    programmerId:"EvaluativeReport"
  };

  const rejectContent = {
    criteriaId: {
      collegeId: "1",
      financialYear: finacialyear,
      typeofInstitution: "affilated",
    },
    assignedTo: "anamita1996@gmail.com",
    assignedBy: email,
    principalComments: rejectReasonComments,
    principalStatus: "R",
    programmerId:"EvaluativeReport"
  };
  // eslint-disable-next-line no-redeclare
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }
  function getAuthorizeEvaluativereport(e) {
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
      resources.APPLICATION_URL
        + "principalAuthorizedEmail",
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
  function getRejectEvaluativereport() {
    console.log("Assigned");
    const rejectAPImethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(rejectContent),
    };
    fetch(
      resources.APPLICATION_URL
        + "principalRejectEmail?institutionType=affilated",
      rejectAPImethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Rejected Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }

  return (
    <div className="main-container">
      <h1 className="main-heading-style">
        Evaluative report of the department
      </h1>
      <div style={{ padding: "2%" }}>
        <form>
          <table>
            <tr>
              <th>Department Name</th>
              <th>Upload Report </th>
            </tr>
            <tr>
              <td>
                <input
                  type="text"
                  id="t1"
                  onChange={(e) => setValuet1(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="file"
                  id="f1"
                  onChange={(e) => {
                    setValuef1(e.target.files[0]);
                    setPathValuef1(e.target.value);
                  }}
                />
              </td>
            </tr>
            <tr>
              <td>
                <input
                  type="text"
                  id="t2"
                  onChange={(e) => setValuet2(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="file"
                  id="f2"
                  onChange={(e) => {
                    setValuef2(e.target.files[0]);
                    setPathValuef2(e.target.value);
                  }}
                />
              </td>
            </tr>
            <tr>
              <td>
                <input
                  type="text"
                  id="t3"
                  onChange={(e) => setValuet3(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="file"
                  id="f3"
                  onChange={(e) => {
                    setValuef3(e.target.files[0]);
                    setPathValuef3(e.target.value);
                  }}
                />
              </td>
            </tr>
            <tr>
              <td>
                <input
                  type="text"
                  id="t4"
                  onChange={(e) => setValuet4(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="file"
                  id="f4"
                  onChange={(e) => {
                    setValuef4(e.target.files[0]);
                    setPathValuef4(e.target.value);
                  }}
                />
              </td>
            </tr>
          </table>
          <div className="a2-button-container">
            <div>Principal Comments : {principalComments}</div>
            <div className="c31x-button-container">
              <button
                onClick={(e) => {
                  getAuthorizeEvaluativereport(e);
                  e.preventDefault();
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
                      getRejectEvaluativereport(e);
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
        </form>
      </div>
    </div>
  );
}

export default EvaluativeReport;
