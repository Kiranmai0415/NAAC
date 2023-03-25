import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";

import "./Consultancy.css";
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

function Consultancy() {
  const [nameTeacher, setNameteacher] = useState("");
  const [nameConsultancy, setNameConsultancy] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [contactDetails, setContactDetails] = useState("");
  const [year, setYear] = useState("");
  const [revenue, setRevenue] = useState("");
  // file upload
  const [valueep22, setValueep22] = useState();
   const [pathValueep22, setPathValueep22] = useState("");
   const [pathValueep22Display, setPathValueep22Display] = useState("");


  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getAllRevenueConsultData").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setNameteacher(data[0].revenueConsultancy[0].inputrct1);
              setNameConsultancy(data[0].revenueConsultancy[0].inputrct2);
              setDepartment(data[0].revenueConsultancy[0].inputrct3);
              setSchool(data[0].revenueConsultancy[0].inputrct4);
              setContactDetails(data[0].revenueConsultancy[0].inputrct5);
              setYear(data[0].revenueConsultancy[0].inputrct6);
              setRevenue(data[0].revenueConsultancy[0].inputrct7);

              setValueep22(
                data[0].revenueConsultancyFileUpload[0]
                  .revenueConsultancyFilePath
              );
              setPathValueep22Display(
                data[0].revenueConsultancyFileUpload[0]
                  .revenueConsultancyFileName
              );
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

  const inputConsultencyDataList = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    revenueConsultancy: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1: 1,
        inputrct1: nameTeacher,
        inputrct2: nameConsultancy,
        inputrct3: department,
        inputrct4: school,
        inputrct5: contactDetails,
        inputrct6: year,
        inputrct7: revenue,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }

  function onClickingConsultancy(e) {
    e.preventDefault();
    console.log(JSON.stringify(inputConsultencyDataList));
    const basicData = new FormData();
    // patentForm.append("patents", jsonBlob(inputPatentsDataList));

     if (pathValueep22 !== "") {
    basicData.append(
      "revenueConsultFiles",
      valueep22,
      "ep22-" + valueep22.name
    );
   }

    basicData.append("revenueConsultobj", jsonBlob(inputConsultencyDataList));
    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(
      resources.APPLICATION_URL+"revenueConsultData",
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
    <div className="consultancy-container">
      <h1 className="consultancy-heading-style">Consultancy</h1>
      <div className="consultancy-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the teacher consultant
                {/* <span style={{ color: "red" }}>*</span> */}
              </th>
              <td>
                <input
                  type="text"
                  name="nameTeacher"
                  value={nameTeacher}
                  onChange={(e) => setNameteacher(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Name of consultancy project</th>
              <td>
                <input
                  type="text"
                  name="nameConsultancy"
                  value={nameConsultancy}
                  onChange={(e) => setNameConsultancy(e.target.value)}
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
                  onChange={(e) => setDepartment(e.target.value)}
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
                  onChange={(e) => setSchool(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Consulting/Sponsoring agency with contact details</th>
              <td>
                <input
                  type="text"
                  name="contactDetails"
                  value={contactDetails}
                  onChange={(e) => setContactDetails(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Year</th>
              <td>
                <input
                  type="number"
                  name="year"
                  value={year}
                  onChange={(e) => setYear(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Revenue generated (INR in Lakhs)</th>
              <td>
                <input
                  type="number"
                  name="revenue"
                  value={revenue}
                  onChange={(e) => setRevenue(e.target.value)}
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
                    setPathValueep22(e.target.value);
                    showFilePreview(e);
                  }}
                />
                {pathValueep22Display === "" ? null : (
                  <div className="fileButtons-container">
                    <button className="viewFileButton-style">
                      <a target="_openfile" href={downloadFile(pathValueep22Display)}>{pathValueep22Display}
                   
                        
                      </a>
                    </button>
                    <button className="removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )}
              </td>
            </tr>
          </table>

          <div className="consultency-button-container">
            <button
              className="consultency-button-style"
              onClick={onClickingConsultancy}
            >
              Modify
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Consultancy;
