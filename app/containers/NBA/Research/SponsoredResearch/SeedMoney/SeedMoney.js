import React, { useState } from "react";
import { toast } from "react-toastify";
import "./SeedMoney.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import { resources } from "../../../../appConstants";

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

export default function Seedmoney() {
  const [seedMoney, setSeedMoney] = useState({
    seedname: "",
    department: "",
    school: "",
    amount: "",
    year: "",
    policy: "",
  });

  // file upload
  const [valueep22, setValueep22] = useState();

  const { seedname, amount, year, policy, department, school } = seedMoney;

  console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
  let instituteType = AuthService.getCurrentUser().instituteType;
  console.log("instituteType=======>" + instituteType);
  const d = new Date();
  let currYear = d.getFullYear();
  console.log("var ==>" + currYear);
  let fYear = parseInt(currYear) - 1 + "-" + currYear;
  console.log("current year==" + fYear);
  const collegeId = AuthService.getCurrentUser().collegeId;
  console.log("collegeId==========>" + collegeId);

  const inputSeedMoney = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    seedMoney: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputsmt1: seedname,
        inputsmt2: department,
        inputsmt3: school,
        inputsmt4: amount,
        inputsmt5: year,
        inputsmt6: policy,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSeedMoney(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(JSON.stringify(inputSeedMoney));
    basicData.append("seedMoneyFiles", valueep22, "ep22-" + valueep22.name);
    basicData.append("seedMoneyobj", jsonBlob(inputSeedMoney));

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(resources.APPLICATION_URL+"seedMoneyData", filesFetchMethod).then(
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

  const handleChange = (e) => {
    setSeedMoney({
      ...seedMoney,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div className="seedmoney-container">
      <h1 className="seedmoney-heading-style">SEED MONEY</h1>
      <div className="seedmoney-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the teacher provided with seed money
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="seedname"
                  value={seedname}
                  onChange={handleChange}
                />
              </td>
            </tr>

            <tr>
              <th>Department</th>
              <td>
                <input
                  type="text"
                  name="department"
                  value={department}
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Schools Name</th>
              <td>
                <input
                  type="text"
                  name="school"
                  value={school}
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <th>The amount of seed money (INR in Lakhs)</th>
              <td>
                <input
                  type="number"
                  name="amount"
                  value={amount}
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Year of receiving</th>
              <td>
                <input
                  type="number"
                  name="year"
                  value={year}
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <th>
                Link to the policy document for Sanction of seed money / grants
                for research from the institution?
              </th>
              <td>
                <input
                  type="text"
                  name="policy"
                  value={policy}
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "50%" }}>Upload the Document</th>
              <td>
                <input
                  type="file"
                  id="ep22"
                  onChange={(e) => {
                    setValueep22(e.target.files[0]);
                  }}
                />
              </td>
            </tr>
          </table>

          <div className="seedmoney-button-container">
            <button
              className="seedmoney-button-style"
              onClick={onClickingSeedMoney}
            >
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
