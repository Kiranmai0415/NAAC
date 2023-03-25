import React, { useState,useEffect } from "react";
import { toast } from "react-toastify";
import AuthService from "../../../../Pages/Users/services/auth.service";
import "./EvaluativeReport-style.css";

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
  //  const financialYear="2021-2022";
   useEffect(
    () => fetch('http://localhost:8080/api/v1/getallevaluation?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));
          setInputValuet1(data[0].evaluativeReport[0] ? data[0].evaluativeReport[0].valuet1 : "");
          setInputValuet2(data[0].evaluativeReport[0] ? data[0].evaluativeReport[0].valuet2 : "");
          setInputValuet3(data[0].evaluativeReport[0] ? data[0].evaluativeReport[0].valuet3 : "");
          setInputValuet4(data[0].evaluativeReport[0] ? data[0].evaluativeReport[0].valuet4 : "");
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ), []
  );

 // sending data to db with API
 const inputDataList = {
  criteriaId: {
    collegeId:collegeId,
    financialYear:fYear ,
    typeofInstitution: instituteType,
  },
  evaluativeReport: [
    { 
      criteriaId: {
        collegeId:collegeId,
        financialYear:fYear ,
        typeofInstitution: instituteType,
      },
      uniqueKey1:1,
      valuet1: inputValuet1,
      valuet2: inputValuet2,
      valuet3: inputValuet3,
      valuet4: inputValuet4
   }
  ],
};

  

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave(e) {
    e.preventDefault();
    const form1Data = new FormData();

    form1Data.append("evaluationData", jsonBlob(inputDataList));

    if (pathValuef1 !== "") {
      form1Data.append("evaluationuploadfile", valuef1, "ff1-" + valuef1.name);
    }
    if (pathValuef2 !== "") {
      form1Data.append("evaluationuploadfile", valuef2, "ff2-" + valuef2.name);
    }
    if (pathValuef3 !== "") {
      form1Data.append("evaluationuploadfile", valuef3, "ff3-" + valuef3.name);
    }
    if (pathValuef4 !== "") {
      form1Data.append("evaluationuploadfile", valuef4, "ff4-" + valuef4.name);
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form1Data,
    };
    fetch("http://localhost:8080/api/v1/evaluationdata", filesFetchMethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Record is Inserte  d Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
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
                <input readOnly
                  type="text"
                  id="t1"
                  onChange={(e) => setInputValuet1(e.target.value)}
                  value={inputValuet1}
                />
              </td>
              <td>
                <input readOnly
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
                <input readOnly
                  type="text"
                  id="t2"
                  onChange={(e) => setInputValuet2(e.target.value)}
                  value={inputValuet2}
                />
              </td>
              <td>
                <input readOnly
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
                <input readOnly
                  type="text"
                  id="t3"
                  onChange={(e) => setInputValuet3(e.target.value)}
                  value={inputValuet3}
                />
              </td>
              <td>
                <input readOnly
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
                <input readOnly
                  type="text"
                  id="t4"
                  onChange={(e) => setInputValuet4(e.target.value)}
                  value={inputValuet4}
                />
              </td>
              <td>
                <input readOnly
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
        </form>
      </div>
    </div>
  );
}

export default EvaluativeReport;
