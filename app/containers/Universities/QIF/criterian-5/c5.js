import React, { useState } from 'react';
import Criteria51 from './c51/c51.js';
import Criteria52 from './c52/c52.js';
import Criteria53 from './c53/c53.js';
import Criteria54 from './c54/c54.js';
import './c5-style.css';
import {toast} from "react-toastify";
import AuthService from '../../../Pages/Users/services/auth.service.js';
import {
  AssignPopup5,
  AssignPopup51,
  AssignPopup52,
  AssignPopup53,
  AssignPopup54,
} from './assignPopup5.js';

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

function Criteria5() {
  // state variables
  const [screenStatus51, setScreenStatus51] = useState(false);
  const [screenStatus52, setScreenStatus52] = useState(false);
  const [screenStatus53, setScreenStatus53] = useState(false);
  const [screenStatus54, setScreenStatus54] = useState(false);
  const [assignStatus5, setAssignStatus5] = useState(false);
  const [assignStatus51, setAssignStatus51] = useState(false);
  const [assignStatus52, setAssignStatus52] = useState(false);
  const [assignStatus53, setAssignStatus53] = useState(false);
  const [assignStatus54, setAssignStatus54] = useState(false);


  const financialYear="2021-2022";
  
  function onClickingSave() {
    const criteria5upload = new FormData();
  
    //criteria5upload.append("uploadfile5", jsonBlob(inputDataList));

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
      body: criteria5upload,
    };
    fetch("http://localhost:8080/api/v1/criteria5submit?collegeId="+collegeId+"&financialYear="+fYear+"&typeofInstitution="+instituteType, filesFetchMethod).then(
      (response) => {
        
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
    <div className="c5-container">
      {/* Criteria Heading */}
      <div className="c5-heading-container">
        <h1 className="c5-heading-style">Student Support and Progression (100)</h1>
        {/* <button
          onClick={() => setAssignStatus5(true)}
          className="cx-assign-button-style"
        >
          Assign
        </button> */}
        <AssignPopup5
          isAssign5Clicked={assignStatus5}
          setIsAssign5Clicked={setAssignStatus5}
        />
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
          {/* <button
            onClick={() => setAssignStatus51(true)}
            className="c5x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup51
            isAssign51Clicked={assignStatus51}
            setIsAssign51Clicked={setAssignStatus51}
          />
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
          {/* <button
            onClick={() => setAssignStatus52(true)}
            className="c5x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup52
            isAssign52Clicked={assignStatus52}
            setIsAssign52Clicked={setAssignStatus52}
          />
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
          {/* <button
            onClick={() => setAssignStatus53(true)}
            className="c5x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup53
            isAssign53Clicked={assignStatus53}
            setIsAssign53Clicked={setAssignStatus53}
          />
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
          {/* <button
            onClick={() => setAssignStatus54(true)}
            className="c5x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup54
            isAssign54Clicked={assignStatus54}
            setIsAssign54Clicked={setAssignStatus54}
          />
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
            Submit
          </button>
        </div>
    </div>
  );
}

export default Criteria5;
