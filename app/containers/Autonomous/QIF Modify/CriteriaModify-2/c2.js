import React, { useState } from 'react';
import Criteria21 from './cV21/c21';
import Criteria22 from './cV22/c22';
import Criteria23 from './cV23/c23';
import Criteria24 from './cV24/c24';
import Criteria25 from './cV25/c25';
import Criteria26 from './cV26/c26';
import Criteria27 from './cV27/c27';
import { toast } from "react-toastify";
import './c2-style.css';
import AuthService from '../../../Pages/Users/services/auth.service';

function CriteriaView2() {
  // state variables
  const [screenStatus21, setScreenStatus21] = useState(false);
  const [screenStatus22, setScreenStatus22] = useState(false);
  const [screenStatus23, setScreenStatus23] = useState(false);
  const [screenStatus24, setScreenStatus24] = useState(false);
  const [screenStatus25, setScreenStatus25] = useState(false);
  const [screenStatus26, setScreenStatus26] = useState(false);
  const [screenStatus27, setScreenStatus27] = useState(false);



  
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


  // const financialYear="2021-2022";

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
    fetch('http://localhost:8080/api/v1/criteria2submit?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,filesFetchMethod ).then(
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
    <div className="c2-container">
      {/* Criteria Heading */}
      <div className="c2-heading-container">
        <h1 className="c2-heading-style">
        Criteria2 : Teaching-Learning and Evaluation (300)

        </h1>
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 2.1 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus21(!screenStatus21)}
            className="c2x-heading-style"
          >
            2.1: Student Enrolment and Profile (20)

          </h1>
        </div>
      </div>
      {screenStatus21 ? <Criteria21 /> : null}

      {/* Key Indicator: 2.2 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus22(!screenStatus22)}
            className="c2x-heading-style"
          >
            2.2:  Catering to Student Diversity (30)

          </h1>
        </div>
      </div>
      {screenStatus22 ? <Criteria22 /> : null}

      {/* Key Indicator: 2.3 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus23(!screenStatus23)}
            className="c2x-heading-style"
          >
            2.3: Teaching - Learning Process (50)
          </h1>
        </div>
      </div>
      {screenStatus23 ? <Criteria23 /> : null}

      {/* Key Indicator: 2.4 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus24(!screenStatus24)}
            className="c2x-heading-style"
          >
            2.4: Teacher Profile and Quality (50)

          </h1>
        </div>
      </div>
      {screenStatus24 ? <Criteria24 /> : null}

      {/* Key Indicator: 2.5 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus25(!screenStatus25)}
            className="c2x-heading-style"
          >
            2.5:  Evaluation Process and Reforms (50)
          </h1>
        </div>
      </div>
      {screenStatus25 ? <Criteria25 /> : null}

      {/* Key Indicator: 2.6 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus26(!screenStatus26)}
            className="c2x-heading-style"
          >
            2.6: Student Performance and Learning Outcomes (50)
          </h1>
        </div>
      </div>
      {screenStatus26 ? <Criteria26 /> : null}

      {/* Key Indicator: 2.7 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus27(!screenStatus27)}
            className="c2x-heading-style"
          >
            2.7: Student Satisfaction Survey (50)

          </h1>
        </div>
      </div>
      {screenStatus27 ? <Criteria27 /> : null}
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

export default CriteriaView2;
