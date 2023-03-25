import React, { useState, useEffect } from 'react';
import { toast } from "react-toastify";
import './c4-style.css';
import { resources } from "../../appConstants";
import AuthService from "../../Pages/Users/services/auth.service";

import Criteria41 from '../Authorize HOD/ViewHOD/CriteriaView-4/cV41/c41';
import Criteria42 from '../Authorize HOD/ViewHOD/CriteriaView-4/cV42/c42';
import Criteria43 from '../Authorize HOD/ViewHOD/CriteriaView-4/cV43/c43';
import Criteria44 from '../Authorize HOD/ViewHOD/CriteriaView-4/cV44/c44';




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


function Criteria4() {
  // state variables
  const [screenStatus41, setScreenStatus41] = useState(false);
  const [screenStatus42, setScreenStatus42] = useState(false);
  const [screenStatus43, setScreenStatus43] = useState(false);
  const [screenStatus44, setScreenStatus44] = useState(false);
  const [isreject,setreject]= useState(false);
  const [isdisabled,setdisabled]= useState(false);
  
  const [rejectReasonComments, setRejectReasonComments ] = useState('');
  const [principalComments, setPrincipalComments] = useState(null);
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  const financialYear="2021-2022";

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
    () => fetch('http://localhost:8080/api/v1/getTrackingInfo?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then((response) => response
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
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    
    assignedBy: email,
    programmerId:"Criteria4",
    principalStatus: "A",
  };
  const rejectContent = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    
    assignedBy: email,
    principalComments: rejectReasonComments,
    principalStatus: "R",
    programmerId:"Criteria4"
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
    fetch(resources.APPLICATION_URL + "principalRejectEmail?institutionType=universities", rejectAPImethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Record Rejected Successfully");
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


  return (
    <div className="c4-container">
      {/* Criteria Heading */}
      <div className="c4-heading-container">
        <h1 className="c4-heading-style">
          Infrastructure and Learning Resources(100)
        </h1>
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 4.1 */}
      <div className="c4x-container">
        <div className="c4x-subContainer">
          <h1
            onClick={() => setScreenStatus41(!screenStatus41)}
            className="c4x-heading-style"
          >
            4.1: Physical Facilities(30)
          </h1>
        </div>
      </div>
      {screenStatus41 ? <Criteria41 /> : null}

      {/* Key Indicator: 4.2 */}
      <div className="c4x-container">
        <div className="c4x-subContainer">
          <h1
            onClick={() => setScreenStatus42(!screenStatus42)}
            className="c4x-heading-style"
          >
            4.2: Library as a Learning Resource(20)
          </h1>
        </div>
      </div>
      {screenStatus42 ? <Criteria42 /> : null}

      {/* Key Indicator: 4.3 */}
      <div className="c4x-container">
        <div className="c4x-subContainer">
          <h1
            onClick={() => setScreenStatus43(!screenStatus43)}
            className="c4x-heading-style"
          >
            4.3: IT Infrastructure(30)
          </h1>
        </div>
      </div>
      {screenStatus43 ? <Criteria43 /> : null}

      {/* Key Indicator: 4.4 */}
      <div className="c4x-container">
        <div className="c4x-subContainer">
          <h1
            onClick={() => setScreenStatus44(!screenStatus44)}
            className="c4x-heading-style"
          >
            4.4: Maintenance of Campus Infrastructure(20)
          </h1>
        </div>
      </div>
      {screenStatus44 ? <Criteria44 /> : null}
      <div>Principal Comments : {principalComments}</div>
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
              onClick={() =>{ setRejectButtonClickStatus(false);
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
export default Criteria4;
