import React, { useState } from 'react';
import Criteria11 from './c11/c11.js';
import Criteria12 from './c12/c12.js';
import Criteria13 from './c13/c13.js';
import Criteria14 from './c14/c14.js';
import './c1-style.css';
import AuthService from '../../../Pages/Users/services/auth.service.js';
import {toast} from "react-toastify";
import {
  AssignPopup1,
  AssignPopup11,
  AssignPopup12,
  AssignPopup13,
  AssignPopup14,
} from './assignPopup1.js';


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

function Criterian1() {
  // state variables
  const [screenStatus11, setScreenStatus11] = useState(false);
  const [screenStatus12, setScreenStatus12] = useState(false);
  const [screenStatus13, setScreenStatus13] = useState(false);
  const [screenStatus14, setScreenStatus14] = useState(false);
  const [assignStatus1, setAssignStatus1] = useState(false);
  const [assignStatus11, setAssignStatus11] = useState(false);
  const [assignStatus12, setAssignStatus12] = useState(false);
  const [assignStatus13, setAssignStatus13] = useState(false);
  const [assignStatus14, setAssignStatus14] = useState(false);


  
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
    fetch("http://localhost:8080/api/v1/criteria1submit?collegeId="+collegeId+"&financialYear="+fYear+"&typeofInstitution="+instituteType, filesFetchMethod).then(
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
    <div className="c1-container">
      {/* Criteria Heading */}
      <div className="c1-heading-container">
        <h1 className="c1-heading-style">
        Curricular Aspects (150)
        </h1>
        {/* <button
          onClick={() => setAssignStatus1(true)}
          className="cx-assign-button-style"
        >
          Assign
        </button> */}
        <AssignPopup1
          isAssign1Clicked={assignStatus1}
          setIsAssign1Clicked={setAssignStatus1}
        />
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 1.1 */}
      <div className="c1x-container">
        <div className="c1x-subContainer">
          <h1
            onClick={() => setScreenStatus11(!screenStatus11)}
            className="c1x-heading-style"
          >
            1.1: Curriculum Design and Development (50)
          </h1>
          {/* <button
            onClick={() => setAssignStatus11(true)}
            className="c1x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup11
            isAssign11Clicked={assignStatus11}
            setIsAssign11Clicked={setAssignStatus11}
          />
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
            1.2: Academic Flexibility (30)
          </h1>
          {/* <button
            onClick={() => setAssignStatus12(true)}
            className="c1x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup12
            isAssign12Clicked={assignStatus12}
            setIsAssign12Clicked={setAssignStatus12}
          />
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
            1.3: Curriculum Enrichment (50)
          </h1>
          {/* <button
            onClick={() => setAssignStatus13(true)}
            className="c1x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup13
            isAssign13Clicked={assignStatus13}
            setIsAssign13Clicked={setAssignStatus13}
          />
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
          {/* <button
            onClick={() => setAssignStatus14(true)}
            className="c1x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup14
            isAssign14Clicked={assignStatus14}
            setIsAssign14Clicked={setAssignStatus14}
          />
        </div>
      </div>
      {screenStatus14 ? <Criteria14 /> : null}
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
            Submit
          </button>
        </div>
    </div>
  );
}

export default Criterian1;
