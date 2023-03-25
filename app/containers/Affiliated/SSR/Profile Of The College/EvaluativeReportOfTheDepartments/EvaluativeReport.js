import React, { useState } from "react";
import { toast } from "react-toastify";
import "./EvaluativeReport-style.css";
import AuthService from "../../../../Pages/Users/services/auth.service";


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
  const [valuet1, setValuet1] = useState("");
  const [valuet2, setValuet2] = useState("");
  const [valuet3, setValuet3] = useState("");
  const [valuet4, setValuet4] = useState("");
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



  // sending data to db with API

  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    inputt1: valuet1,
    inputt2: valuet2,
    inputt3: valuet3,
    inputt4: valuet4,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form1Data = new FormData();

    form1Data.append("criteria1Fieldinfo", jsonBlob(inputDataList));
    if (pathValuef1 !== "") {
      form1Data.append("uploadfile1", valuef1, "ff1-" + valuef1.name);
    }
    if (pathValuef2 !== "") {
      form1Data.append("uploadfile1", valuef2, "ff2-" + valuef2.name);
    }
    if (pathValuef3 !== "") {
      form1Data.append("uploadfile1", valuef3, "ff3-" + valuef3.name);
    }
    if (pathValuef4 !== "") {
      form1Data.append("uploadfile1", valuef4, "ff4-" + valuef4.name);
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form1Data,
    };
    fetch(
      "http://localhost:8080/api/v1/criteria4upload",
      filesFetchMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Inserted Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
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
                <input
                  type="text"
                  id="t1"
                  onChange={(e) => setValuet1(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="file"
                  id="f1"
                  onChange={(e) => {
                    setValuef1(e.target.files[0]);
                    setPathValuef1(e.target.value);
                  }}
                />
              </td>
            </tr>
            <tr>
              <td>
                <input
                  type="text"
                  id="t2"
                  onChange={(e) => setValuet2(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="file"
                  id="f2"
                  onChange={(e) => {
                    setValuef2(e.target.files[0]);
                    setPathValuef2(e.target.value);
                  }}
                />
              </td>
            </tr>
            <tr>
              <td>
                <input
                  type="text"
                  id="t3"
                  onChange={(e) => setValuet3(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="file"
                  id="f3"
                  onChange={(e) => {
                    setValuef3(e.target.files[0]);
                    setPathValuef3(e.target.value);
                  }}
                />
              </td>
            </tr>
            <tr>
              <td>
                <input
                  type="text"
                  id="t4"
                  onChange={(e) => setValuet4(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="file"
                  id="f4"
                  onChange={(e) => {
                    setValuef4(e.target.files[0]);
                    setPathValuef4(e.target.value);
                  }}
                />
              </td>
            </tr>
          </table>
          <div className="a2-button-container">
            <button className="a2-button-style" onClick={onClickingSave}>
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default EvaluativeReport;
