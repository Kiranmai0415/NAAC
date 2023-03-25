import React, { useState } from 'react';
import { toast } from "react-toastify";

import "./Extramural.css";

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

export default function Extramural() {
  // const [extramural, setExtramural] = useState(
  //   {
  //     scheme: "",
  //     principal: "",
  //     agency: "",
  //     department: "",
  //     award: "",
  //     funds: "",
  //     duration: "",
  //     document: "",
  //     typeGov: ""

  //   });

  const inputExtramural = {

  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingExtramural(e) {
    e.preventDefault();
    const basicData = new FormData();

    basicData.append("ssrData", jsonBlob(inputExtramural));
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

  // const handleChangeExtramural = (e) => {
  //   setExtramural({
  //     ...extramural,
  //     [e.target.name]: e.target.value
  //   });
  // };

  // const {
  //   scheme, principal, agency, department, award, typeGov, funds, duration, document
  // } = extramural;

  return (
    <div className='extramural-container' >
      <h1 className="extramural-heading-style">Extramural funding for Research (Gov/Non-Gov) </h1>
      <div className="extramural-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">Name of the Scheme/Project/ Endowments/ Chairs(U)
                {/* <span style={{ color: "red" }}>*</span> */}
              </th>
              <td>
                <input   readOnly
                  type="text"
                  name="scheme"
                  value={scheme}
                  onChange={handleChangeExtramural}
                />
              </td>
            </tr>
            <tr>
              <th>Name of the Principal Investigator/ Co Investigator (if applicable)</th>
              <td>
                <input   readOnly
                  type="text"
                  name="principal"
                  value={principal}
                  onChange={handleChangeExtramural}
                />
              </td>
            </tr>
            <tr>
              <th>Name of the Funding agency</th>
              <td>
                <input   readOnly
                  type="text"
                  name="agency"
                  value={agency}
                  onChange={handleChangeExtramural}
                />
              </td>
            </tr>
            <tr>
              <th>Type (Government/Non-Government)</th>
              <td>
                <input   readOnly
                  type="text"
                  name="typeGov"
                  value={typeGov}
                  onChange={handleChangeExtramural}
                />
              </td>
            </tr>
            <tr>
              <th>Department of Principal Investigator/ Co Investigator</th>
              <td>
                <input   readOnly
                  type="text"
                  name="department"
                  value={department}
                  onChange={handleChangeExtramural}
                />
              </td>
            </tr>
            <tr>
              <th>Year of Award</th>
              <td>
                <input   readOnly
                  type="text"
                  name="award"
                  value={award}
                  onChange={handleChangeExtramural}
                />
              </td>
            </tr>
            <tr>
              <th>Funds provided (INR in lakhs) </th>
              <td>
                <input   readOnly
                  type="text"
                  name="funds"
                  value={funds}
                  onChange={handleChangeExtramural}
                />
              </td>
            </tr>
            <tr>
              <th>Duration of the project</th>
              <td>
                <input   readOnly
                  type="text"
                  name="duration"
                  value={duration}
                  onChange={handleChangeExtramural}

                />
              </td>
            </tr>
            <tr>
              <th>Upload the Document</th>
              <td>
                <input   readOnly
                  type="file"
                  name="document"
                  value={document}
                  onChange={handleChangeExtramural}
                />
              </td>
            </tr>
          </table>
          <div className="extramural-button-container">
            <button className="extramural-button-style" onClick={onClickingExtramural}>
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
