import React, { useEffect, useState } from "react";
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
  const [seedname, setSeedname] = useState("");
  const [amount, setAmount] = useState("");
  const [year, setYear] = useState("");
  const [policy, setPolicy] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallseeddata").then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setSeedname(data[0].seedMoney[0].inputsmt1);
            setDepartment(data[0].seedMoney[0].inputsmt2);
            setSchool(data[0].seedMoney[0].inputsmt3);
            setAmount(data[0].seedMoney[0].inputsmt4);
            setYear(data[0].seedMoney[0].inputsmt5);
            setPolicy(data[0].seedMoney[0].inputsmt6);
            setValueep22(data[0].SeedMoneyFileUpload[0].seedMoneyFilePath);
            setPathValueep22(data[0].SeedMoneyFileUpload[0].seedMoneyFileName);
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );

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

  function showFilePreview(e) {
    const selectedFile = e.target.files[0];
    if (selectedFile) {
      const fileReader = new FileReader();
      fileReader.readAsDataURL(selectedFile);
      fileReader.addEventListener("load", (event) => {
        setFilePreviewSrc111f1(event.target.result);
      });
    }
  }

  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }

  return (
    <div className="main-container">
      <h1 className="main-heading-style">SEED MONEY</h1>
      <div className="eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the teacher provided with seed money
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input   readOnly
                  type="text"
                  name="seedname"
                  value={seedname}
                  onChange={(e) => setSeedname(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Department</th>
              <td>
                <input   readOnly
                  type="text"
                  name="department"
                  value={department}
                  onChange={(e) => setDepartment(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Schools Name</th>
              <td>
                <input   readOnly
                  type="text"
                  name="school"
                  value={school}
                  onChange={(e) => setSchool(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>The amount of seed money (INR in Lakhs)</th>
              <td>
                <input   readOnly
                  type="text"
                  name="amount"
                  value={amount}
                  onChange={(e) => setAmount(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Year of receiving?</th>
              <td>
                <input   readOnly
                  type="text"
                  name="year"
                  value={year}
                  onChange={(e) => setYear(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Link to the policy document for Sanction of seed money / grants
                for research from the institution?
              </th>
              <td>
                <input   readOnly
                  type="text"
                  name="policy"
                  value={policy}
                  onChange={(e) => setPolicy(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "50%" }}>Upload the Document</th>
              <td>
              <a href={downloadFile(pathValueep22)}>View File</a>
              </td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  );
}
