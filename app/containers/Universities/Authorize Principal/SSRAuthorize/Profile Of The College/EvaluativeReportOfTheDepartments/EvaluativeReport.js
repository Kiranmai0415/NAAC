import React, { useState,useEffect } from "react";
import { toast } from "react-toastify";
import "./EvaluativeReport-style.css";
import { resources } from "../../../../../appConstants";
import AuthService from "../../../../../Pages/Users/services/auth.service";

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
  const [inputValuet1, setInputValuet1] = useState("");
  const [inputValuet2, setInputValuet2] = useState("");
  const [inputValuet3, setInputValuet3] = useState("");
  const [inputValuet4, setInputValuet4] = useState("");
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


   //get call
 
   useEffect(
    () => fetch('http://localhost:8080/api/v1/getallevaluation?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));
          setInputValuet1(data[0].evaluativeReport[0]?data[0].evaluativeReport[0].valuet1:"");
          setInputValuet2(data[0].evaluativeReport[0]?data[0].evaluativeReport[0].valuet2:"");
          setInputValuet3(data[0].evaluativeReport[0]?data[0].evaluativeReport[0].valuet3:"");
          setInputValuet4(data[0].evaluativeReport[0]?data[0].evaluativeReport[0].valuet4:"");
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ), []
  );
  


  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  
  let role = null;
  let email = null;
  // eslint-disable-next-line prefer-destructuring, no-undef
  role = AuthService.getCurrentUser().roles[0];
  // eslint-disable-next-line no-undef
  email = AuthService.getCurrentUser().email;
  const finacialyear = "2021-2022";
  const authorize = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
     },
    assignedTo: email,
    assignedBy: email,
    role:role,
    principalStatus: "A",
    programmerId:"EvaluativeReport"
  };

  const rejectContent = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
     },
    assignedTo: "anamita1996@gmail.com",
    assignedBy: email,
    role:role,
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
        + "principalRejectEmail",
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
                <input readonly
                  type="text"
                  id="t1"
                  onChange={(e) => setInputValuet1(e.target.value)}
                  value={inputValuet1}
                />
              </td>
              <td>
                <input readonly
                  type="file"
                  id="f1"
                  onChange={(e) => {
                    setValuef1(e.target.files[0]);
                    setPathValuef1(e.target.value);
                  }}
                />
                {pathValuef1 === "" ? null : (
                  <div className="c21-fileButtons-container">
                    <button className="c21-viewFileButton-style">
                      View File
                    </button>
                    <button className="c21-removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )}
              </td>
            </tr>
            <tr>
              <td>
                <input readonly
                  type="text"
                  id="t2"
                  onChange={(e) => setInputValuet2(e.target.value)}
                  value={inputValuet2}
                />
              </td>
              <td>
                <input readonly
                  type="file"
                  id="f2"
                  onChange={(e) => {
                    setValuef2(e.target.files[0]);
                    setPathValuef2(e.target.value);
                  }}
                />
                {pathValuef2 === "" ? null : (
                  <div className="c21-fileButtons-container">
                    <button className="c21-viewFileButton-style">
                      View File
                    </button>
                    <button className="c21-removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )}
              </td>
            </tr>
            <tr>
              <td>
                <input readonly
                  type="text"
                  id="t3"
                  onChange={(e) => setInputValuet3(e.target.value)}
                  value={inputValuet3}
                />
              </td>
              <td>
                <input readonly
                  type="file"
                  id="f3"
                  onChange={(e) => {
                    setValuef3(e.target.files[0]);
                    setPathValuef3(e.target.value);
                  }}
                />
                {pathValuef3 === "" ? null : (
                  <div className="c21-fileButtons-container">
                    <button className="c21-viewFileButton-style">
                      View File
                    </button>
                    <button className="c21-removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )}
              </td>
            </tr>
            <tr>
              <td>
                <input readonly
                  type="text"
                  id="t4"
                  onChange={(e) => setInputValuet4(e.target.value)}
                  value={inputValuet4}
                />
              </td>
              <td>
                <input readonly
                  type="file"
                  id="f4"
                  onChange={(e) => {
                    setValuef4(e.target.files[0]);
                    setPathValuef4(e.target.value);
                  }}
                />
                {pathValuef4 === "" ? null : (
                  <div className="c21-fileButtons-container">
                    <button className="c21-viewFileButton-style">
                      View File
                    </button>
                    <button className="c21-removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )}
              </td>
            </tr>
          </table>
          <div>Principal Comments : {principalComments}</div>
          <div className="c31x-button-container">
            <button
              onClick={(e) => {
                getAuthorizeEvaluativereport(e);
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
        </form>
      </div>
    </div>
  );
}

export default EvaluativeReport;
<></>
