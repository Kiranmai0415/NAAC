import React, { useState } from 'react';
import Criteria71 from './cV71/c71.js';
import Criteria72 from './cV72/c72.js';
import Criteria73 from './cV73/c73.js';
import {toast} from "react-toastify";
import './c7-style.css';
import AuthService from '../../../Pages/Users/services/auth.service.js';
import {
  AssignPopup7,
  AssignPopup71,
  AssignPopup72,
  AssignPopup73,
} from './assignPopup7.js';

function Criteria3() {
  // state variables
  const [screenStatus71, setScreenStatus71] = useState(false);
  const [screenStatus72, setScreenStatus72] = useState(false);
  const [screenStatus73, setScreenStatus73] = useState(false);

  // const [assignStatus7, setAssignStatus7] = useState(false);
  // const [assignStatus71, setAssignStatus71] = useState(false);
  // const [assignStatus72, setAssignStatus72] = useState(false);
  // const [assignStatus73, setAssignStatus73] = useState(false);


  
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
  fetch("http://localhost:8080/api/v1/criteria7submit?collegeId="+collegeId+"&financialYear="+fYear+"&typeofInstitution="+instituteType, filesFetchMethod).then(
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
    <div className="c7-container">
      {/* Criteria Heading */}
      <div className="c7-heading-container">
        <h1 className="c7-heading-style">
          Institutional Values and Best Practices (100)
        </h1>
        {/* <button
          onClick={() => setAssignStatus7(true)}
          className="cx-assign-button-style"
        >
          Assign
        </button>
        <AssignPopup7
          isAssign7Clicked={assignStatus7}
          setIsAssign7Clicked={setAssignStatus7}
        /> */}
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 7.1 */}
      <div className="c7x-container">
        <div className="c7x-subContainer">
          <h1
            onClick={() => setScreenStatus71(!screenStatus71)}
            className="c7x-heading-style"
          >
            7.1: Institutional Values and Social Responsibilities (50)
          </h1>
          {/* <button
            onClick={() => setAssignStatus71(true)}
            className="c7x-assign-button-style"
          >
            Assign
          </button>
          <AssignPopup71
            isAssign71Clicked={assignStatus71}
            setIsAssign71Clicked={setAssignStatus71}
          /> */}
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
            7.2: Best Practices (30)
          </h1>
          {/* <button
            onClick={() => setAssignStatus72(true)}
            className="c7x-assign-button-style"
          >
            Assign
          </button>
          <AssignPopup72
            isAssign72Clicked={assignStatus72}
            setIsAssign72Clicked={setAssignStatus72}
          /> */}
        </div>
      </div>
      {screenStatus72 ? <Criteria72 /> : null}

      {/* Key Indicator: 7.3 */}
      {/* <div className="c7x-container">
        <div className="c7x-subContainer">
          <h1
            onClick={() => setScreenStatus73(!screenStatus73)}
            className="c7x-heading-style"
          >
            7.3: Institutional Distinctiveness (20)
          </h1> */}
          {/* <button
            onClick={() => setAssignStatus73(true)}
            className="c7x-assign-button-style"
          >
            Assign
          </button>
          <AssignPopup73
            isAssign73Clicked={assignStatus73}
            setIsAssign73Clicked={setAssignStatus73}
          /> */}
        {/* </div>
      </div> */}
      {/* {screenStatus73 ? <Criteria73 /> : null} */}
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
