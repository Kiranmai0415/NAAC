import React, { useState, useEffect } from 'react';
import './c62-style.css';
import {toast} from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import { HelpButton } from "../../../../../reusableComponents/model/Help";
import { resources } from "../../../../appConstants";
import { Button } from '@mui/material';

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


// Help buttons functionality
function Help621(props) {
  return props.isHelp621Clicked ? (
    <div className="c62x-help-mainContainer">
      <div className="c62x-help-subContainer">
        <h1 className="c62x-help-heading-style">
          The institutional Strategic/ Perspective plan is effectively deployed
        </h1>
        <p className="c62x-help-para-style">
          Describe one activity successfully implemented based on the strategic
          plan within a maximum of 500 words
        </p>
        <button
          className="c62x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp621Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help622(props) {
  return props.isHelp622Clicked ? (
    <div className="c62x-help-mainContainer">
      <div className="c62x-help-subContainer">
        <h1 className="c62x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c62x-help-para-style">
          <span style={{ fontWeight: 'bold' }}></span>
          <span style={{ fontWeight: 'bold' }}></span>
          Describe the Organogram of the Institution within a maximum of 500 words.
        </p>
        <button
          className="c62x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp622Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help623(props) {
  return props.isHelp623Clicked ? (
    <div className="c62x-help-mainContainer">
      <div className="c62x-help-subContainer">
        <h1 className="c62x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c62x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>The total amount of seed
          money provided by institution to its teachers for research in the last
          five years
          <span style={{ fontWeight: 'bold' }}>) /</span>
        </p>
        <button
          className="c62x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp623Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria62() {
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
  // state variables
  const [value621t1, setValue621t1] = useState();
  const [value621f1, setValue621f1] = useState();
  const [pathValue621f1, setPathValue621f1] = useState('');

  const [value621f2, setValue621f2] = useState();
  const [pathValue621f2, setPathValue621f2] = useState('');
  const [value621f3, setValue621f3] = useState();
  const [pathValue621f3, setPathValue621f3] = useState('');
  const [responseValue621, setResponseValue621] = useState('');

  const [value622t1, setValue622t1] = useState();
  const [value622t2, setValue622t2] = useState();
  const [value622t3, setValue622t3] = useState();
  const [value622f1, setValue622f1] = useState('');
  const [pathValue622f1, setPathValue622f1] = useState('');
  const [value622f2, setValue622f2] = useState('');
  const [pathValue622f2, setPathValue622f2] = useState('');
  const [value622f3, setValue622f3] = useState('');
  const [pathValue622f3, setPathValue622f3] = useState('');
  const [responseValue622, setResponseValue622] = useState('');

  const [value623t1, setValue623t1] = useState();
  const [value623f1, setValue623f1] = useState('');
  const [pathValue623f1, setPathValue623f1] = useState('');
  const [value623f2, setValue623f2] = useState('');
  const [pathValue623f2, setPathValue623f2] = useState('');
  const [value623f3, setValue623f3] = useState('');
  const [pathValue623f3, setPathValue623f3] = useState('');
  const [value623f4, setValue623f4] = useState('');
  const [pathValue623f4, setPathValue623f4] = useState('');
  const [responseButtonStatus623, setResponseButtonStatus623] = useState(false);
  const [responseValue623, setResponseValue623] = useState('');

  const [help621Status, setHelp621Status] = useState(false);
  const [help622Status, setHelp622Status] = useState(false);
  const [help623Status, setHelp623Status] = useState(false);

  // get call
  const financialYear="2021-2022";
  
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
  useEffect(
    () => fetch(resources.APPLICATION_URL+'criteria6getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));

          setValue621t1(data[0].criteria62Ql[0] ? data[0].criteria62Ql[0].input621t1 : "");
          setValue622t1(data[0].criteria62Ql[0] ? data[0].criteria62Ql[0].input622t1 : "");
          
          setValue623t1(data[0].criteria62Qn[0] ? data[0].criteria62Qn[0].input623t1 : "");

          setValue621f1(data[0].criteria1FileUpload[0] ? data[0].criteria1FileUpload[0].criteria6FileName : "");
          setValue621f2(data[0].criteria1FileUpload[0] ? data[0].criteria1FileUpload[0].criteria6FileName : "");
          setValue621f3(data[0].criteria1FileUpload[0] ? data[0].criteria1FileUpload[0].criteria6FileName : "");
          setValue622f1(data[0].criteria1FileUpload[0] ? data[0].criteria1FileUpload[0].criteria6FileName : "");
          setValue622f2(data[0].criteria1FileUpload[0] ? data[0].criteria1FileUpload[0].criteria6FileName : "");
          setValue622f3(data[0].criteria1FileUpload[0] ? data[0].criteria1FileUpload[0].criteria6FileName : "");
          setValue623f1(data[0].criteria1FileUpload[0] ? data[0].criteria1FileUpload[0].criteria6FileName : "");
          setValue623f2(data[0].criteria1FileUpload[0] ? data[0].criteria1FileUpload[0].criteria6FileName : "");
          setValue623f3(data[0].criteria1FileUpload[0] ? data[0].criteria1FileUpload[0].criteria6FileName : "");
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ), []
  );


   // sending data to db with API
  
   const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
    criteria62Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType},
        uniqueKey1: 1,
      input621t1: value621t1,
      response621: responseValue621,
      input622t1: value622t1,
      response622: responseValue622,
    },
    ],
    criteria62Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
        uniqueKey1: 1,
      input623t1: value623t1,
      response623: responseValue623,
      criteria62status:"save"
    },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form62Data = new FormData();

    form62Data.append('criteria6Fieldinfo', jsonBlob(inputDataList));
    if (pathValue621f1 !== '') {
      form62Data.append('uploadfile6', value621f1, 'f621f1-' + value621f1.name);
    }
    if (pathValue621f2 !== '') {
      form62Data.append('uploadfile6', value621f2, 'f621f2-' + value621f2.name);
    }
    if (pathValue621f3 !== '') {
      form62Data.append('uploadfile6', value621f3, 'f621f3-' + value621f3.name);
    }
    if (pathValue622f1 !== '') {
      form62Data.append('uploadfile6', value622f1, 'f622f1-' + value622f1.name);
    }
    if (pathValue622f2 !== '') {
      form62Data.append('uploadfile6', value622f2, 'f622f2-' + value622f2.name);
    }
    if (pathValue622f3 !== '') {
      form62Data.append('uploadfile6', value622f3, 'f622f3-' + value622f3.name);
    }
    if (pathValue623f1 !== '') {
      form62Data.append('uploadfile6', value623f1, 'f623f1-' + value623f1.name);
    }
    if (pathValue623f2 !== '') {
      form62Data.append('uploadfile6', value623f2, 'f623f2-' + value623f2.name);
    }
    if (pathValue623f3 !== '') {
      form62Data.append('uploadfile6', value623f3, 'f623f3-' + value623f3.name);
    }
    if (pathValue623f4 !== '') {
      form62Data.append('uploadfile6', value623f4, 'f623f4-' + value623f4.name);
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form62Data,
    };
    fetch(
      resources.APPLICATION_URL+'criteria6upload',
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

  function onClickingViewResponse623(e) {
    e.preventDefault();
    setResponseButtonStatus623(!responseButtonStatus623);
    if (value623t1 === '') {
      setResponseValue623('Please select any option');
    } else {
      setResponseValue623(e.target.value);
    }
  }

  // rendering DOM

function downloadFile(fileName) {
  const filePath = "http://localhost:8080/api/v1/download/" + fileName;
  return filePath;
}


  // rendering DOM
  return (
    <div className="c62-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c62x-colorIndicator-container">
        <p className="c62x-QlcolorIndicator-circle-style"></p>
        <span className="c62x-colorIndicator-span-style">Qualitative</span>
        <p className="c62x-QtcolorIndicator-circle-style"></p>
        <span className="c62x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c62x-weightage-heading-style">
            Key Indicator Weightage: 10
          </h1>
        </div>
      </div>

      {/* Key Indicator: 6.2.1 */}
      <div className="c62x-eachInputField-container">
        <div className="c62x-weightage-container">
          <h1 className="c62x-weightage-heading-style">Weightage: 2</h1>
        </div>
        <form>
          <div className="c62x-Ql-label-textarea-container">
            <div className="c62x-heading_Help-container">
              <h1 className="c62x-heading-style">
                <span className="c62x-span-style">6.2.1: </span>
                The institutional perspective plan is effectively deployed and functioning of the institutional bodies is effective and efficient as visible from policies, administrative setup, appointment, service rules, and procedures, etc.
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c62x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <label htmlFor="621-t1" className="c61x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue621t1(e.target.value);
                setResponseValue621(e.target.value);
              }}
              value={value621t1}
              rows={10}
              className="c62x-textarea-style"
              id="621-t1"
            ></textarea>
            {value621t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c62x-Ql-table-style">
            <tr>
              <th className="c62x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c62x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c62x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c62x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Strategic Plan and deployment documents on the website
              </td>
              <td className="c62x-Ql-tableBorders-style"></td>
              <td className="c62x-Ql-tableBorders-style">
                {/* <input
                  onChange={(e) => {
                    setValue621f1(e.target.files[0]);
                    setPathValue621f1(e.target.value);
                  }}
                  id="621-f1"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue621f1 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                      View File
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue621f1("");
                      document.getElementById("621-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                 <a href={downloadFile(value621f1)} target="_blank">View File</a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
                   <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="621-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue621f1(e.target.files[0]);
                    setPathValue621f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue621f1}
              {pathValue621f1 === "" ? null : (
                <div className="c62-fileButtons-container">
                  <button
                    className="c62-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc621f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c62-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue621f1("");
                      document.getElementById("621-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Paste link for additional Information
              </td>
              <td className="c62x-Ql-tableBorders-style"></td>
              <td className="c62x-Ql-tableBorders-style">
                {/* <input
                  onChange={(e) => {
                    setValue621f2(e.target.files[0]);
                    setPathValue621f2(e.target.value);
                  }}
                  id="621-f2"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue621f2 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                      View File
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue621f2("");
                      document.getElementById("621-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                <a href={downloadFile(value621f2)} target="_blank">View File</a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                   <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="621-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue621f2(e.target.files[0]);
                    setPathValue621f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue621f2}
              {pathValue621f2 === "" ? null : (
                <div className="c62-fileButtons-container">
                  <button
                    className="c62-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc621f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c62-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue621f2("");
                      document.getElementById("621-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c62x-Ql-tableBorders-style">
              </td>
              <td className="c62x-Ql-tableBorders-style">
                {/* <input
                  onChange={(e) => {
                    setValue621f3(e.target.files[0]);
                    setPathValue621f3(e.target.value);
                  }}
                  id="621-f3"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue621f3 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                      View File
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue621f3("");
                      document.getElementById("621-f3").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                <a href={downloadFile(value621f2)} target="_blank">View File</a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                   <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="621-f3"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue621f3(e.target.files[0]);
                    setPathValue621f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue621f3}
              {pathValue621f3 === "" ? null : (
                <div className="c62-fileButtons-container">
                  <button
                    className="c62-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc621f3}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c62-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue621f3("");
                      document.getElementById("621-f3").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 6.2.2 */}
      <div className="c62x-eachInputField-container">
        <div className="c62x-weightage-container">
          <h1 className="c62x-weightage-heading-style">Weightage: 4</h1>
        </div>
        <form>
          <div className="c62x-Ql-label-textarea-container">
            <div className="c62x-heading_Help-container">
              <h1 className="c62x-heading-style">
                <span className="c62x-span-style">6.2.2: </span>
Institution implements e-governance in its operations
6.2.2.1 e-governance is implemented covering the following areas of operations:
              </h1>

              <p className="c62x-para-style">
                  1. Administration
                  <br />
                  2. Finance and Accounts
                  <br />
                  3. Student Admission and Support
                  <br />
                  4. Examination
                </p>
                <div className="c62x-radio-container" style={{width:"180%"}}>
                  <div className="c62x-radio-subContainer" style={{width:"45%"}}>
                    <div className="c62x-eachRadio-container">
                      <input name="623options" id="623-t1" type="radio" onChange={(e) => { setValue622t1(e.target.value); }} value="All of the above"/>

                      <label className="c62x-radioLabel-style" for="623-t1">
                        All of the above
                      </label>
                    </div>

                    <div className="c62x-eachRadio-container">
                      <input name="623options" id="623-t2" type="radio" onChange={(e) => { setValue622t2(e.target.value); }} value="Any three of the above"/>

                      <label className="c62x-radioLabel-style" for="623-t2">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c62x-eachRadio-container">
                      <input name="623options" id="623-t3" type="radio" onChange={(e) => { setValue622t3(e.target.value); }} value="Any two of the above"/>

                      <label className="c62x-radioLabel-style" for="623-t3">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c62x-radio-subContainer">
                    <div className="c62x-eachRadio-container">
                      <input name="623options" id="623-t4" type="radio" onChange={(e) => { setValue622t4(e.target.value); }} value="Any one of the above"/>

                      <label className="c62x-radioLabel-style" for="623-t4">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c62x-eachRadio-container">
                      <input name="623options" id="623-t5" type="radio" onChange={(e) => { setValue622t5(e.target.value); }} value="None of the above"/>

                      <label className="c62x-radioLabel-style" for="623-t5">
                        None of the above
                      </label>
                    </div>
                  </div>
                </div>


                <button
                onClick={handleHelpOpen2}
                className="c62x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen2}
                handleClose={handleHelpClose2}
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            <label htmlFor="622-t1" className="c62x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue622t1(e.target.value);
              }}
              value={value622t1}
              rows={10}
              className="c62x-textarea-style"
              id="622-t1"
            ></textarea>
            {value622t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c62x-Ql-table-style">
            <tr>
              <th className="c62x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c62x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c62x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c62x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Paste link for additional Information
              </td>
              <td className="c62x-Ql-tableBorders-style"></td>
              <td className="c62x-Ql-tableBorders-style">
                {/* <input
                  onChange={(e) => {
                    setValue622f1(e.target.value);
                    setPathValue622f1(e.target.value);
                  }}
                  id="622-f1"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue622f1 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                      View File
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue622f1("");
                      document.getElementById("622-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                <a href={downloadFile(value622f1)} target="_blank">View File</a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                   <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="622-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue622f1(e.target.files[0]);
                    setPathValue622f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue622f1}
              {pathValue622f1 === "" ? null : (
                <div className="c62-fileButtons-container">
                  <button
                    className="c62-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc622f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c62-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue622f1("");
                      document.getElementById("622-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Link to Organogram of the Institution webpage
              </td>
              <td className="c62x-Ql-tableBorders-style">
              </td>
              <td className="c62x-Ql-tableBorders-style">
                {/* <input
                  onChange={(e) => {
                    setValue622f2(e.target.value);
                    setPathValue622f2(e.target.value);
                  }}
                  id="622-f2"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue622f2 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                      View File
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue622f2("");
                      document.getElementById("622-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                <a href={downloadFile(value622f2)} target="_blank">View File</a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                   <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="622-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue622f2(e.target.files[0]);
                    setPathValue622f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue622f2}
              {pathValue622f2 === "" ? null : (
                <div className="c62-fileButtons-container">
                  <button
                    className="c62-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc622f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c62-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue622f2("");
                      document.getElementById("622-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c62x-Ql-tableBorders-style">
              </td>
              <td className="c62x-Ql-tableBorders-style">
                {/* <input
                  onChange={(e) => {
                    setValue622f3(e.target.value);
                    setPathValue622f3(e.target.value);
                  }}
                  id="622-f3"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue622f3 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                      View File
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue622f3("");
                      document.getElementById("622-f3").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                <a href={downloadFile(value622f3)} target="_blank">View File</a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                   <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="622-f3"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue622f3(e.target.files[0]);
                    setPathValue622f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue622f3}
              {pathValue622f3 === "" ? null : (
                <div className="c62-fileButtons-container">
                  <button
                    className="c62-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc622f3}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c62-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue622f3("");
                      document.getElementById("622-f3").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 6.2.3 */}

      <div className="c62x-button-container">
        <button onClick={onClickingSave} className="c62x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria62;
