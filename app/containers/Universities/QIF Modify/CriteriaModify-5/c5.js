import React, { useState } from 'react';
import Criteria51 from './cV51/c51.js';
import Criteria52 from './cV52/c52.js';
import Criteria53 from './cV53/c53.js';
import Criteria54 from './cV54/c54.js';
import {toast} from "react-toastify";
import './c5-style.css';
import AuthService from '../../../Pages/Users/services/auth.service.js';
import { resources } from '../../../appConstants.js';

function CriteriaView5() {
  // state variables
  const [screenStatus51, setScreenStatus51] = useState(false);
  const [screenStatus52, setScreenStatus52] = useState(false);
  const [screenStatus53, setScreenStatus53] = useState(false);
  const [screenStatus54, setScreenStatus54] = useState(false);

  
// Alert custom messages start
const successMessage = (message) => {
  toast.success(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "success1",
    className: "success"
  });
};
const errorMessage = (message) => {
  toast.error(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "error1",
    className: "error"
  });
};


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



function onClickingSave() {
  const criteria1upload = new FormData();
  // console.log(JSON.stringify(inputDataList));
  // criteria1upload.append("uploadfile1", jsonBlob(inputDataList));

  const filesFetchMethod = {
    method: "POST",
    headers: { Accept: "application/json ,text/plain" },
    authorization:
      "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
    body: criteria1upload,
  };
  fetch(resources.APPLICATION_URL+"criteria5submit?collegeId="+collegeId+"&financialYear="+fYear+"&typeofInstitution="+instituteType, filesFetchMethod).then(
    (response) => {
      console.log(response);
      if (response.ok) {
        successMessage("saved Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    }
  );
}


  // rendering DOM
  return (
    <div className="c5-container">
      {/* Criteria Heading */}
      <div className="c5-heading-container">
        <h1 className="c5-heading-style">Student Support and Progression(100)</h1>
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
            5.2 Student Progression (45)

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
            5.3 Student Participation and Activities (15)
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
      <div className="executive-es-button-container">
          <button
          style={{
            backgroundColor: "blue",
            color: "white",
            borderRadius: "15px",
            marginTop: "15px",
            float:'right'
          }}
            className="executive-es-button-style"
            onClick={onClickingSave}
          >
            Modify
          </button>
        </div>
    </div>
  );
}

export default CriteriaView5;
