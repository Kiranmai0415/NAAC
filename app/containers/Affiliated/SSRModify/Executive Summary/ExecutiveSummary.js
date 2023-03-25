import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./Executive Summary-style.css";
import AuthService from '../../../Pages/Users/services/auth.service';

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

function ExecutiveSummary() {
  const [valuees1, setValuees1] = useState("");
  const [valuees2, setValuees2] = useState("");
  const [valuees3, setValuees3] = useState("");
  const [valuees4, setValuees4] = useState("");
  const [valuees5, setValuees5] = useState("");
  const [valuees6, setValuees6] = useState([]);
  const [pathValuees6, setPathValuees6] = useState("");
  const [valuees7, setValuees7] = useState("");
  const [valuees8, setValuees8] = useState("");
  const [valuees9, setValuees9] = useState("");
  const [valuees10, setValuees10] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');


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

 // get call
 const financialYear="2021-2022";
useEffect(
  () => fetch('http://localhost:8080/api/v1/getallexecutivedata?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,).then(
    (response) => response
      .json()
      .then((data) => {
        setValuees1(data[0].inputes1?data[0].inputes1:"");
        setValuees2(data[0].inputes1?data[0].inputes2:"");
        setValuees3(data[0].inputes1?data[0].inputes3:"");
        setValuees4(data[0].inputes1?data[0].inputes4:"");
        setValuees5(data[0].inputes1?data[0].inputes5:"");
        setValuees7(data[0].inputes1?data[0].inputes7:"");
        setValuees8(data[0].inputes1?data[0].inputes8:"");
        setValuees9(data[0].inputes1?data[0].inputes9:"");
        setValuees10(data[0].inputes1?data[0].inputes10:"");
      })
      .catch((error) => {
        console.error("Error:", error);
      })
  ),
  []
);

  // sending data to db with API
  
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
    uniqueKey1: 101,
    inputes1: valuees1,
    inputes2: valuees2,
    inputes3: valuees3,
    inputes4: valuees4,
    inputes5: valuees5,
    inputes7: valuees7,
    inputes8: valuees8,
    inputes9: valuees9,
    inputes10: valuees10,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave(e) {
    e.preventDefault();
    const executiveSummaryData = new FormData();

    executiveSummaryData.append("executiveSummary", jsonBlob(inputDataList));
    if (pathValuees6 !== "") {
      executiveSummaryData.append(
        "uploadexecutivefile",
        valuees6,
        "es6-" + valuees6.name
      );
    }
    console.log(inputDataList);
    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: executiveSummaryData,
    };
    fetch("http://localhost:8080/api/v1/executiveData", filesFetchMethod).then(
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
  function showFilePreview(e) {
    const selectedFile = e.target.files[0];
    if (selectedFile) {
      const fileReader = new FileReader();
      fileReader.readAsDataURL(selectedFile);
      fileReader.addEventListener('load', (event) => {
        setFilePreviewSrc111f1(event.target.result);
      });
    }
  }
  return (
    <div className="executive-main-container">
      <form>
        <div className="executive-heading">
          <h1>Executive Summary</h1>
        </div>

        <div className="executive-eachTable-container">
          <div style={{ margin: "10px" }}>
            <label htmlFor="es1">1.Introductory Note on the Institution</label>
            <textarea
              className="input-text"
              id="es1"
              rows="6"
              cols="95"
              placeholder="Describe in maximum 500 words"
              onChange={(e) => setValuees1(e.target.value)}
              value={valuees1}
            ></textarea>
            {valuees1.length === 500 ? (
              <p style={{ color: "red" }}>This is a required question</p>
            ) : null}
          </div>
          <div style={{ margin: "10px" }}>
            <label htmlFor="es2">Vision</label>
            <textarea
              className="input-text"
              id="es2"
              rows="6"
              cols="60"
              style={{ width: "100%" }}
              placeholder="Describe in maximum 350 words"
              onChange={(e) => setValuees2(e.target.value)}
              value={valuees2}
            ></textarea>
          </div>
          <div style={{ margin: "10px" }}>
            <label>Mission</label>
            <textarea
              className="input-text"
              id="es3"
              rows="6"
              cols="60"
              style={{ width: "100%" }}
              placeholder="Describe in maximum 350 words"
              onChange={(e) => setValuees3(e.target.value)}
              value={valuees3}
            ></textarea>
          </div>
          <div style={{ margin: "10px" }}>
            <label htmlFor="es4" style={{ marginRight: "10px" }}>
              Location
            </label>
            <input
              className="input-text"
              id="es4"
              type="text"
              style={{ width: "100%" }}
              placeholder="Location"
              onChange={(e) => setValuees4(e.target.value)}
              value={valuees4}
            />
          </div>
          <div style={{ margin: "10px" }}>
            <label htmlFor="es5" style={{ marginRight: "10px" }}>
              Type of the Institution
            </label>
            <input
              className="input-text"
              id="es5"
              type="text"
              style={{ width: "100%" }}
              onChange={(e) => setValuees5(e.target.value)}
              value={valuees5}
            />
          </div>
          <label htmlFor="es6" >
              File upload
            </label>
            <div className="executive-eachTable-container"style={{ margin: "10px" }}  >
          <Stack direction="row" alignItems="center" spacing={4}>
         <Button variant="contained" component="label">
             File Upload
               <input 
                className="input-text"
                id="es6" multiple type="file" accept='pdf'
                style={{ display: 'none' }}
                onChange={(e) => {
                setValuees6(e.target.files[0]);
                setPathValuees6(e.target.value);
                showFilePreview(e);
            }}
            />
           </Button>{pathValuees6}
           {pathValuees6 === "" ? null : (
              <div className="c21-fileButtons-container" >
                <button className="c21-viewFileButton-style" style={{height:"37px" , width:"70px"}}  >  
                <a target="_openfile" href={filePreviewSrc111f1}> View File</a></button>
                <button className="c11-removeFileButton-style" 
                  onClick={(e)=>{setPathValuees6("");
                  document.getElementById("es6").value="" }} style={{height:"37px" , width:"70px"}} >
                   Reset                     
                </button>
              </div>
            )}
            </Stack>
        </div>
        </div>
        <div className="executive-eachTable-container">
          <label htmlFor="es7">
            2.Criterion-wise Summary on the Institution
          </label>
          <textarea
            id="es7"
            className="input-text"
            rows="6"
            cols="42"
            placeholder="Describe in maximum 250 words"
            onChange={(e) => setValuees7(e.target.value)}
            value={valuees7}
          ></textarea>
        </div>
        <div className="executive-eachTable-container">
          <label htmlFor="es8">
            3.Brief note on the Strength Weakness Opportunities and
            Challenges(SWOC) in respect of the Institution
          </label>
          <textarea
            id="es8"
            className="input-text"
            rows="6"
            cols="120"
            placeholder="Describe in maximum 500 words"
            onChange={(e) => setValuees8(e.target.value)}
            value={valuees8}
          ></textarea>
        </div>
        <div className="executive-eachTable-container">
          <label htmlFor="es9">
            4.Any additional information about the Institution other than ones
            already stated.
          </label>
          <textarea
            id="es9"
            className="input-text"
            rows="6"
            cols="95"
            placeholder="Describe in maximum 500 words"
            onChange={(e) => setValuees9(e.target.value)}
            value={valuees9}
          ></textarea>
        </div>
        <div className="executive-eachTable-container">
          <label htmlFor="es10">
            5.Over all conclusive explication about the institution's
            functioning
          </label>
          <textarea
            id="es10"
            className="input-text"
            rows="6"
            cols="95"
            placeholder="Describe in maximum 500 words"
            onChange={(e) => setValuees10(e.target.value)}
            value={valuees10}
          ></textarea>
        </div>
        <div className="executive-es-button-container">
          <button
            className="executive-es-button-style"
            onClick={onClickingSave}
          >
            Modify
          </button>
        </div>
      </form>
    </div>
  );
}
export default ExecutiveSummary;
