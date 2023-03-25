import React, { useState } from 'react';
import { toast } from "react-toastify";

import "./Grants.css";

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

export default function Grants() {
  const [grants, setGrants] = useState({
    nameofscheme: "",
    principal: "",
    department: "",
    schoolname: "",
    fundingagency: "",
    govt: "",
    department1: "",
    yearofaward: "",
    funds: "",
    duration: "",
    document: ""

  });
  const {
    nameofscheme, principal, department, schoolname, fundingagency, govt, department1, yearofaward, funds, duration, document
  } = grants;

  const inputgrants = {

    criteriaId: {
      collegeId: 1,
      financialYear: "2021-22",
      typeofInstitution: "Autonomous"
    },

    uniqueKey1: 1,
    inputgrt1: nameofscheme,
    inputgrt2: principal,
    inputgrt3: department,
    inputgrt4: schoolname,
    inputgrt5: fundingagency,
    inputgrt6: govt,
    inputgrt7: department1,
    inputgrt8: yearofaward,
    inputgrt9: funds,
    inputgrt10: duration

  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingGrants(e) {
    e.preventDefault();
    const basicData = new FormData();

    basicData.append("ssrData", jsonBlob(inputgrants));
    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
          "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch("http://localhost:8080/api/v1/academicdata", filesFetchMethod).then(
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

  const handleChangeGrants = (e) => {
    setGrants({
      ...grants,
      [e.target.name]: e.target.value
    });
  };

  return (
    <div className='Grants-container' >
      <h1 className="Grants-heading-style">Grants - Research Projects</h1>
      <div className="Grants-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">Name of the Scheme/Project/ Endowments/ Chairs
(U)*

              {/* <span style={{ color: "red" }}>*</span> */}
              </th>
              <td>
                <input
                  type="text"
                  id=""
                  name="nameofscheme"
                  value={nameofscheme}
                  onChange={handleChangeGrants}

                />
              </td>
            </tr>
            <tr>
              <th>Name of the Principal Investigator/ Co Investigator (if applicable)</th>
              <td>
                <input
                  type="text"
                  id=""
                  name="principal"
                  value={principal}
                  onChange={handleChangeGrants}
                />
              </td>
            </tr>
            <tr>
              <th>Department</th>
              <td>
                <input
                  type="text"
                  id=""
                  name="department"
                  value={department}
                  onChange={handleChangeGrants}
                />
              </td>
            </tr>
            <tr>
              <th>Schools Name</th>
              <td>
                <input
                  type="text"
                  id=""
                  name="schoolname"
                  value={schoolname}
                  onChange={handleChangeGrants}
                />
              </td>
            </tr>
            <tr>
              <th>Name of the Funding agency</th>
              <td>
                <input
                  type="text"
                  id=""
                  name="fundingagency"
                  value={fundingagency}
                  onChange={handleChangeGrants}
                />
              </td>
            </tr>
            <tr>
              <th>Type (Government/Non-Government)</th>
              <td>
                <input
                  type="text"
                  id=""
                  name="govt"
                  value={govt}
                  onChange={handleChangeGrants}
                />
              </td>
            </tr>
            <tr>
              <th>Department of Principal Investigator/ Co Investigator</th>
              <td>
                <input
                  type="text"
                  id=""
                  name="department1"
                  value={department1}
                  onChange={handleChangeGrants}
                />
              </td>
            </tr>
            <tr>
              <th tyle={{ width: "50%" }}>Year of Awardt</th>
              <td>
                <input
                  type="file"
                  id=""
                  name="yearofaward"
                  value={yearofaward}
                  onChange={handleChangeGrants}
                />
              </td>
            </tr>
            <tr>
              <th tyle={{ width: "50%" }}>Funds provided (INR in lakhs)</th>
              <td>
                <input
                  type="file"
                  id=""
                  name="funds"
                  value={funds}
                  onChange={handleChangeGrants}
                />
              </td>
            </tr>
            <tr>
              <th tyle={{ width: "50%" }}>Duration of the project</th>
              <td>
                <input
                  type="file"
                  id=""
                  name="duration"
                  value={duration}
                  onChange={handleChangeGrants}
                />
              </td>
            </tr>
            <tr>
              <th tyle={{ width: "50%" }}>Upload the Document</th>
              <td>
                <input
                  type="file"
                  id=""
                  name="document"
                  value={document}
                  onChange={handleChangeGrants}
                />
              </td>
            </tr>
          </table>
          <div className="grants-button-container">
            <button className="grants-button-style" onClick={onClickingGrants}>
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
