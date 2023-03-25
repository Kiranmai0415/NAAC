import React, { useState } from 'react';
import Criteria61 from './c61/c61.js';
import Criteria62 from './c62/c62.js';
import Criteria63 from './c63/c63.js';
import Criteria64 from './c64/c64.js';
import Criteria65 from './c65/c65.js';
import './c6-style.css';
import AuthService from '../../../Pages/Users/services/auth.service.js';
import {toast} from "react-toastify";
import {
  AssignPopup6,
  AssignPopup61,
  AssignPopup62,
  AssignPopup63,
  AssignPopup64,
  AssignPopup65,
} from './assignPopup6.js';

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
function Criteria6() {
  // state variables
  const [screenStatus61, setScreenStatus61] = useState(false);
  const [screenStatus62, setScreenStatus62] = useState(false);
  const [screenStatus63, setScreenStatus63] = useState(false);
  const [screenStatus64, setScreenStatus64] = useState(false);
  const [screenStatus65, setScreenStatus65] = useState(false);
  const [assignStatus6, setAssignStatus6] = useState(false);
  const [assignStatus61, setAssignStatus61] = useState(false);
  const [assignStatus62, setAssignStatus62] = useState(false);
  const [assignStatus63, setAssignStatus63] = useState(false);
  const [assignStatus64, setAssignStatus64] = useState(false);
  const [assignStatus65, setAssignStatus65] = useState(false);

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
    const criteria6upload = new FormData();
    //console.log(JSON.stringify(inputDataList));
    //criteria6upload.append("uploadfile6", jsonBlob(inputDataList));

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: criteria6upload,
    };
    fetch(
      'http://localhost:8080/api/v1/criteria6submit?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType, filesFetchMethod) .then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Inserted Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }



  // rendering DOM
  return (
    <div className="c6-container">
      {/* Criteria Heading */}
      <div className="c6-heading-container">
        <h1 className="c6-heading-style">
        Governance, Leadership and Management (100)
        </h1>
        {/* <button
          onClick={() => setAssignStatus6(true)}
          className="cx-assign-button-style"
        >
          Assign
        </button> */}
        <AssignPopup6
          isAssign6Clicked={assignStatus6}
          setIsAssign6Clicked={setAssignStatus6}
        />
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 6.1 */}
      <div className="c6x-container">
        <div className="c6x-subContainer">
          <h1
            onClick={() => setScreenStatus61(!screenStatus61)}
            className="c6x-heading-style"
          >
            6.1 Institutional Vision and Leadership (15)
          </h1>
          {/* <button
            onClick={() => setAssignStatus61(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup61
            isAssign61Clicked={assignStatus61}
            setIsAssign61Clicked={setAssignStatus61}
          />
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
            6.2 Strategy Development and Deployment (10)
          </h1>
          {/* <button
            onClick={() => setAssignStatus62(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup62
            isAssign62Clicked={assignStatus62}
            setIsAssign62Clicked={setAssignStatus62}
          />
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
           6.3 Faculty Empowerment Strategies (30)

          </h1>
          {/* <button
            onClick={() => setAssignStatus63(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup63
            isAssign63Clicked={assignStatus63}
            setIsAssign63Clicked={setAssignStatus63}
          />
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
           6.4 Financial Management and Resource Mobilization (15)
          </h1>
          {/* <button
            onClick={() => setAssignStatus64(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup64
            isAssign64Clicked={assignStatus64}
            setIsAssign64Clicked={setAssignStatus64}
          />
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
           6.5 Internal Quality Assurance System (35)
          </h1>
          {/* <button
            onClick={() => setAssignStatus65(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup65
            isAssign65Clicked={assignStatus65}
            setIsAssign65Clicked={setAssignStatus65}
          />
        </div>
      </div>
      {screenStatus65 ? <Criteria65 /> : null}
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

export default Criteria6;
