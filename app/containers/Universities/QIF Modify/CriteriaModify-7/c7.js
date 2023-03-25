import React, { useState } from 'react';
import Criteria71 from './cV71/c71.js';
import Criteria72 from './cV72/c72.js';
import Criteria73 from './cV73/c73.js';
import {toast} from "react-toastify";
import './c7-style.css';
import AuthService from '../../../Pages/Users/services/auth.service.js';
import { resources } from '../../../appConstants.js';


function CriteriaView7() {
  // state variables
  const [screenStatus71, setScreenStatus71] = useState(false);
  const [screenStatus72, setScreenStatus72] = useState(false);
  const [screenStatus73, setScreenStatus73] = useState(false);


  
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

  // sending data to db with API
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



const financialYear="2021-2022";

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
  fetch(resources.APPLICATION_URL+"criteria7submit?collegeId="+collegeId+"&financialYear="+fYear+"&typeofInstitution="+instituteType, filesFetchMethod).then(
    (response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Saved Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    }
  );
}


  

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

export default CriteriaView7;
