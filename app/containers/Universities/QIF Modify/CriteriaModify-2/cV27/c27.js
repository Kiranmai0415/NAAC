import React, { useState,useEffect } from 'react';
import './c27-style.css';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import { resources } from '../../../../appConstants';
import { Button } from '@mui/material';
import { HelpButton } from '../../../../../reusableComponents/model/Help';

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
// End here

// Help buttons functionality
function Help271(props) {
  return props.isHelp271Clicked ? (
    <div className="c27x-help-mainContainer">
      <div className="c27x-help-subContainer">
        <h1 className="c27x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c27x-help-para-style">
          Data Requirements: (As per Data Template) • Name/ Class/ Gender
          <br></br>
          • Student Id number/ Aadhar Id number
          <br />
          • Mobile number
          <br />
          • Email id
          <br />
          • Degree Programme
        </p>
        <button
          className="c27x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp271Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria27() {
  // getfile data with API
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
 //help buttom
  const [isOpen, setIsopen] = useState(false)
  const [isOpen2,setIsopen2] = useState(false)
  const handleHelpOpen = (e) => {
    e.preventDefault(),
    setIsopen(true)
  }
  const handleHelpClose = () => {
    setIsopen(false)
  }
  const handleHelpOpen2 =(e)=>{
    e.preventDefault();
    setIsopen2(true)
  } 
  const handleHelpClose2 = (e)=>{
    setIsopen2(false)
  }
  const [help271Status, setHelp271Status] = useState(false);
  const [pathValue271f1, setPathValue271f1] = useState('');
  const [pathValue271f2, setPathValue271f2] = useState('');
  const [value271f1, setValue271f1] = useState([]);
  const [value271f2, setValue271f2] = useState([]);
  const [responseValue271, setResponseValue271] = useState('');

  
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



  // getfile data with API

  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }
  //get data api 
  const financialYear="2021-2022";
  useEffect(
    () => fetch(resources.APPLICATION_URL+'criteria2getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          
          // setResponseValue111(data[0].criteria1FieldInfoQl[1].response111);
          // setResponseValue112(data[0].criteria1FieldInfoQn[2].response112);
          // setResponseValue113(data[0].criteria1FieldInfoQn[3].response113);
  
          setValue271f1(data[0].criteria2FileUpload[0] ? data[0].criteria2FileUpload[0].criteria2FileName : "");
          setValue271f2(data[0].criteria2FileUpload[1] ? data[0].criteria2FileUpload[1].criteria2FileName : ""); 
  
        })
        .catch((error) => {
          console.error("Error:", error);
          errorMessage("Got the Error Please try after sometime");
        })
    ),
    []
  );

  
  // sending data to db with API
  
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
    criteria27Ql: [
     { 
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      uniqueKey1: 201, response271: responseValue271
      },
     ],
 };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form27Data = new FormData();

    form27Data.append('criteria2Fieldinfo', jsonBlob(inputDataList));
    if (pathValue271f1 !== '') {
      form27Data.append('uploadfile2', value271f1, 'f271f1-' + value271f1.name);
    }
    if (pathValue271f2 !== '') {
      form27Data.append('uploadfile2', value271f2, 'f271f2-' + value271f2.name);
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form27Data,
    };
    fetch(
      resources.APPLICATION_URL+'criteria2upload',
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
    <div className="c27-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c27x-colorIndicator-container">
        <p className="c27x-QlcolorIndicator-circle-style"></p>
        <span className="c27x-colorIndicator-span-style">Qualitative</span>
        <p className="c27x-QtcolorIndicator-circle-style"></p>
        <span className="c27x-colorIndicator-span-style">Quantitative</span>
      </div>

      {/* Key Indicator: 2.7.1 */}
      <div className="c27x-eachInputField-container">
        <div className="c27x-weightage-container">
          <h1 className="c27x-weightage-heading-style">Weightage: 30</h1>
        </div>
        <form>
          <div className="c27x-container">
            <div className="c27x-heading_Help-container">
              <h1 className="c27x-heading-style">
                <span className="c27x-span-style">2.7.1: </span>
                Online Student Satisfaction Survey regarding the teaching-learning process.
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
          </div>
          <div className="c27xx-container">
            <table className="c27x-table-style">
              <tr>
                <th className="c27x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c27x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c27x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c27x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                {/* <a href={downloadFile(value271f1)} target="_blank">view</a> */}
                <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="271-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue271f1(e.target.files[0]);
                    setPathValue271f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue271f1}
              {pathValue271f1 === "" ? null : (
                <div className="c27-fileButtons-container">
                  <button
                    className="c27-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc271f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c27-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue271f1("");
                      document.getElementById("271-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c27x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Upload database of all currently enrolled students(Data
                  Template)
                </td>
                <td>
                <a href={downloadFile("un2.7.1.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                {/* <a href={downloadFile(value271f2)} target="_blank">view</a> */}
                <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="271-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue271f2(e.target.files[0]);
                    setPathValue271f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue271f2}
              {pathValue271f2 === "" ? null : (
                <div className="c27-fileButtons-container">
                  <button
                    className="c27-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc271f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c27-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue271f2("");
                      document.getElementById("271-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c27x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
      <div className="c27x-button-container">
        <button onClick={onClickingSave} className="c27x-button-style">
         Save
        </button>
      </div>
    </div>
  );
}

export default Criteria27;
