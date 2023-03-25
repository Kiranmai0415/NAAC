import React, { useState } from 'react';
import Criteria31 from './cV31/c31.js';
import Criteria32 from './cV32/c32.js';
import Criteria33 from './cV33/c33.js';
import Criteria34 from './cV34/c34.js';
import Criteria35 from './cV35/c35.js';
import Criteria36 from './cV36/c36.js';
import Criteria37 from './cV37/c37.js';
import {toast} from "react-toastify";

import AuthService from '../../../Pages/Users/services/auth.service.js';
import './c3-style.css';
import {
  AssignPopup3,
  AssignPopup31,
  AssignPopup32,
  AssignPopup33,
  AssignPopup34,
  AssignPopup35,
  AssignPopup36,
  AssignPopup37,
} from './assignPopup3.js';
import { resources } from '../../../appConstants.js';

function Criteria3() {
  // state variables
  const [screenStatus31, setScreenStatus31] = useState(false);
  const [screenStatus32, setScreenStatus32] = useState(false);
  const [screenStatus33, setScreenStatus33] = useState(false);
  const [screenStatus34, setScreenStatus34] = useState(false);
  const [screenStatus35, setScreenStatus35] = useState(false);
  const [screenStatus36, setScreenStatus36] = useState(false);
  const [screenStatus37, setScreenStatus37] = useState(false);
  const [assignStatus3, setAssignStatus3] = useState(false);
  const [assignStatus31, setAssignStatus31] = useState(false);
  const [assignStatus32, setAssignStatus32] = useState(false);
  const [assignStatus33, setAssignStatus33] = useState(false);
  const [assignStatus34, setAssignStatus34] = useState(false);
  const [assignStatus35, setAssignStatus35] = useState(false);
  const [assignStatus36, setAssignStatus36] = useState(false);
  const [assignStatus37, setAssignStatus37] = useState(false);

  
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

function onClickingSave() {
  const criteria1upload = new FormData();
  // console.log(JSON.stringify(inputDataList));
  // criteria1upload.append("uploadfile1", jsonBlob(inputDataList));

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

  const filesFetchMethod = {
    method: "POST",
    headers: { Accept: "application/json ,text/plain" },
    authorization:
      "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
    body: criteria1upload,
  };
  fetch(resources.APPLICATION_URL+"criteria3submit?collegeId="+collegeId+"&financialYear="+fYear+"&typeofInstitution="+instituteType, filesFetchMethod ).then(
    (response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Inserted Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    }
  );
}


  // rendering DOM
  return (
    <div className="c3-container">
      {/* Criteria Heading */}
      <div className="c3-heading-container">
        <h1 className="c3-heading-style">
          Research, Innovations and Extensions (110)
        </h1>
        {/* <button
          onClick={() => setAssignStatus3(true)}
          className="cx-assign-button-style"
        >
          Assign
        </button>
        <AssignPopup3
          isAssign3Clicked={assignStatus3}
          setIsAssign3Clicked={setAssignStatus3}
        /> */}
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 3.1 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus31(!screenStatus31)}
            className="c3x-heading-style"
          >
            3.1- Resource Mobilization for Research (10)
          </h1>
          {/* <button
            onClick={() => setAssignStatus31(true)}
            className="c3x-assign-button-style"
          >
            Assign
          </button>
          <AssignPopup31
            isAssign31Clicked={assignStatus31}
            setIsAssign31Clicked={setAssignStatus31}
          /> */}
        </div>
      </div>
      {screenStatus31 ? <Criteria31 /> : null}

      {/* Key Indicator: 3.2 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus32(!screenStatus32)}
            className="c3x-heading-style"
          >
            3.2- Innovation Ecosystem (15)
          </h1>
          {/* <button
            onClick={() => setAssignStatus32(true)}
            className="c3x-assign-button-style"
          >
            Assign
          </button>
          <AssignPopup32
            isAssign32Clicked={assignStatus32}
            setIsAssign32Clicked={setAssignStatus32}
          /> */}
        </div>
      </div>
      {screenStatus32 ? <Criteria32 /> : null}

      {/* Key Indicator: 3.3 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus33(!screenStatus33)}
            className="c3x-heading-style"
          >
            3.3- Research Publication and Awards (25)
          </h1>
          {/* <button
            onClick={() => setAssignStatus33(true)}
            className="c3x-assign-button-style"
          >
            Assign
          </button>
          <AssignPopup33
            isAssign33Clicked={assignStatus33}
            setIsAssign33Clicked={setAssignStatus33}
          /> */}
        </div>
      </div>
      {screenStatus33 ? <Criteria33 /> : null}

      {/* Key Indicator: 3.4 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus34(!screenStatus34)}
            className="c3x-heading-style"
          >
            3.4- Extension Activities (40)
          </h1>
          {/* <button
            onClick={() => setAssignStatus34(true)}
            className="c3x-assign-button-style"
          >
            Assign
          </button>
          <AssignPopup34
            isAssign34Clicked={assignStatus34}
            setIsAssign34Clicked={setAssignStatus34}
          /> */}
        </div>
      </div>
      {screenStatus34 ? <Criteria34 /> : null}

      {/* Key Indicator: 3.5 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus35(!screenStatus35)}
            className="c3x-heading-style"
          >
            3.5- Collaboration (20)
          </h1>
          {/* <button
            onClick={() => setAssignStatus35(true)}
            className="c3x-assign-button-style"
          >
            Assign
          </button>
          <AssignPopup35
            isAssign35Clicked={assignStatus35}
            setIsAssign35Clicked={setAssignStatus35}
          /> */}
        </div>
      </div>
      {screenStatus35 ? <Criteria35 /> : null}

      {/* Key Indicator: 3.6 */}
      {/* <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus36(!screenStatus36)}
            className="c3x-heading-style"
          >
            3.6: Extension Activities
          </h1> */}
          {/* <button
            onClick={() => setAssignStatus36(true)}
            className="c3x-assign-button-style"
          >
            Assign
          </button>
          <AssignPopup36
            isAssign36Clicked={assignStatus36}
            setIsAssign36Clicked={setAssignStatus36}
          /> */}
        {/* </div>
      </div>
      {screenStatus36 ? <Criteria36 /> : null} */}

      {/* Key Indicator: 3.7 */}
      {/* <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus37(!screenStatus37)}
            className="c3x-heading-style"
          >
            3.7: Collaboration
          </h1>
          {/* <button
            onClick={() => setAssignStatus37(true)}
            className="c3x-assign-button-style"
          >
            Assign
          </button>
          <AssignPopup37
            isAssign37Clicked={assignStatus37}
            setIsAssign37Clicked={setAssignStatus37}
          /> */}
        {/* </div>
      </div>
      {screenStatus37 ? <Criteria37 /> : null} */} 
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

export default Criteria3;
