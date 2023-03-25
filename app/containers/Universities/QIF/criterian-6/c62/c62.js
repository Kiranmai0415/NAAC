import React, { useState } from 'react';
import './c62-style.css';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';

import { HelpButton } from "../../../../../reusableComponents/model/Help";
import { resources } from "../../../../appConstants";
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
  // const [value622t2, setValue622t2] = useState();
  // const [value622t3, setValue622t3] = useState();
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
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');
  const [responseButtonStatus622, setResponseButtonStatus622] = useState("");


  // sending data to db with API
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



  const financialYear="2021-2022";
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
    criteria62Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
      input621t1: value621t1,
      response621: responseValue621,
      input622t1: value622t1,
      response622: responseValue622,
      criteria62status:"save"
    },
    ],
    criteria62Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
      input623t1: value623t1,
      response623: responseValue623,
      
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
    console.log(JSON.stringify(inputDataList));

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
    if (value623t1 === '' || value623t1 === undefined || value623t1 === null) {
      setResponseValue623('Please select any option');
    } else {
      setResponseValue623(value623t1);
    }
  }

  function onClickingViewResponse622() {
    if (value622t1 === '' || value622t1 === undefined || value622t1 === null) {
      setResponseValue622('Please select any option');
    } else {
      setResponseValue622(value622t1);
    }
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
          <h1 className="c62x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c62x-Ql-label-textarea-container">
            <div className="c62x-heading_Help-container">
              <h1 className="c62x-heading-style">
                <span className="c62x-span-style">6.2.1: </span>
                The institutional perspective plan is effectively deployed and function of the Institutional bodies are effective and efficient as visible from policies, administrative set-up, appointment, service rules, procedures etc.
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
                <input
                  onChange={(e) => {
                    setValue621f1(e.target.files[0]);
                    setPathValue621f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="621-f1"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue621f1 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue621f1("");
                      document.getElementById("621-f1").value="" }} >
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
                <input
                  onChange={(e) => {
                    setValue621f2(e.target.files[0]);
                    setPathValue621f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="621-f2"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue621f2 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue621f2("");
                      document.getElementById("621-f2").value="" }} >
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
                <input
                  onChange={(e) => {
                    setValue621f3(e.target.files[0]);
                    setPathValue621f3(e.target.value);
                    showFilePreview(e);
                  }}
                  id="621-f3"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue621f3 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue621f3("");
                      document.getElementById("621-f3").value="" }} >
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
          <h1 className="c62x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c62x-Ql-label-textarea-container">
            <div className="c62x-heading_Help-container">
              <h1 className="c62x-heading-style">
                <span className="c62x-span-style">6.2.2: </span>
                The institutional perspective plan is effectively deployed and function of the Institutional bodies are effective and efficient as visible from policies, administrative set-up, appointment, service rules, procedures etc.
              </h1>
              </div>
              <div>
              <p className="c65x-para-style">
              1. Administration including complaint management
                  <br />
                  2. Finance and Accounts
                  <br />
                  3. Student Admission and Support
                  <br />

                  4. Examinations
                  
                </p>
                <div className="c65x-radio-container" style={{width:"100%"}}>
                  <div className="c65x-radio-subContainer" style={{width:"45%"}}>
                    <div className="c65x-eachRadio-container">
                    <input name="653options" id="653-t3" type="radio" 
                      onChange={(e) => { setValue653t1(e.target.value); }} 
                       value="Any 5 or All of the above"/>

                      <label className="c65x-radioLabel-style" for="653-t1">
                      Any 5 or All of the above
                      </label>
                    </div>

                    <div className="c65x-eachRadio-container">
                    <input name="653options" id="653-t3" type="radio" 
                      onChange={(e) => { setValue653t1(e.target.value); }} 
                      value="Any 4 or All of the above"/>

                      <label className="c65x-radioLabel-style" for="653-t1">
                      Any 4 or All of the above
                      </label>
                    </div>

                    <div className="c65x-eachRadio-container">
                    <input name="653options" id="653-t3" type="radio" 
                      onChange={(e) => { setValue653t1(e.target.value); }}
                       value="Any 3 or All of the above"/>

                      <label className="c65x-radioLabel-style" for="653-t1">
                      Any 3 or All of the above
                      </label>
                    </div>
                  </div>

                  <div className="c65x-radio-subContainer">
                    <div className="c65x-eachRadio-container">
                    <input name="653options" id="653-t3" type="radio" 
                      onChange={(e) => { setValue653t1(e.target.value); }} 
                      value="Any 2 or All of the above"/>

                      <label className="c65x-radioLabel-style" for="653-t1">
                      Any 2 or All of the above
                      </label>
                    </div>

                    <div className="c65x-eachRadio-container">
                      <input name="653options" id="653-t3" type="radio" 
                      onChange={(e) => { setValue653t1(e.target.value); }}
                       value="Any 1 or All of the above"/>
                      <label className="c65x-radioLabel-style" for="653-t3">
                      Any 1 or All of the above
                      </label>
                    </div>
                  </div>
                </div>


                <button
                onClick={handleHelpOpen2}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen2}
                handleClose={handleHelpClose2}
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
       
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus622(!responseButtonStatus622);
                  onClickingViewResponse622();
                }}
                className="c62x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus622 ? (
                <p className="c62x-responseResult-style">{responseValue622}</p>
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
                <input
                  onChange={(e) => {
                    setValue622f1(e.target.files[0]);
                    setPathValue622f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="622-f1"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue622f1 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue622f1("");
                      document.getElementById("622-f1").value="" }} >
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
                <input
                  onChange={(e) => {
                    setValue622f2(e.target.files[0]);
                    setPathValue622f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="622-f2"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue622f2 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue622f2("");
                      document.getElementById("622-f2").value="" }} >
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
              <td><a href={downloadFile("un6.2.2.xlsx")} target="_blank">view template </a></td>
              <td className="c62x-Ql-tableBorders-style">

              </td>
              <td className="c62x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue622f3(e.target.files[0]);
                    setPathValue622f3(e.target.value);
                    showFilePreview(e);
                  }}
                  id="622-f3"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue622f3 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue622f3("");
                      document.getElementById("622-f3").value="" }} >
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
      {/* <div className="c62x-eachInputField-container">
        <div className="c62x-weightage-container">
          <h1 className="c62x-weightage-heading-style">Weightage: 4</h1>
        </div>
        <form>
          <div className="c62x-container">
            <div className="c62x-heading_Help-container">
              <div>
                <h1 className="c62x-heading-style">
                  <span className="c34x-span-style">6.2.3: </span>
                  Implementation of e-governance in areas of operation
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
                      <input name="623options" id="623-t1" type="radio"
                       onChange={(e) => { setValue623t1(e.target.value); }} 
                       value="All of the above"/>

                      <label className="c62x-radioLabel-style" for="623-t1">
                        All of the above
                      </label>
                    </div>

                    <div className="c62x-eachRadio-container">
                      <input name="623options" id="623-t1" type="radio" 
                      onChange={(e) => { setValue623t1(e.target.value); }} 
                      value="Any three of the above"/>

                      <label className="c62x-radioLabel-style" for="623-t1">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c62x-eachRadio-container">
                      <input name="623options" id="623-t1" type="radio"
                       onChange={(e) => { setValue623t1(e.target.value); }} 
                       value="Any two of the above"/>

                      <label className="c62x-radioLabel-style" for="623-t1">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c62x-radio-subContainer">
                    <div className="c62x-eachRadio-container">
                      <input name="623options" id="623-t1" type="radio" 
                      onChange={(e) => { setValue623t1(e.target.value); }} 
                      value="Any one of the above"/>

                      <label className="c62x-radioLabel-style" for="623-t1">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c62x-eachRadio-container">
                      <input name="623options" id="623-t1" type="radio" onChange={(e) => { setValue623t1(e.target.value); }} value="None of the above"/>

                      <label className="c62x-radioLabel-style" for="623-t1">
                        None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp623Status(true);
                }}
                className="c62x-helpButton-style"
              >
                Help
              </button>
              <Help623
                isHelp623Clicked={help623Status}
                setIsHelp623Clicked={setHelp623Status}
              />
            </div>
            <div className="c62x-response-container">
              <button
                onClick={onClickingViewResponse623}
                className="c62x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus623 ? (
                <p className="c62x-responseResult-style">{responseValue623}</p>
              ) : null}
            </div>
          </div>
          <table className="c62x-table-style">
            <tr>
              <th className="c62x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c62x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c62x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c62x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>ERP (Enterprise Resource Planning) Document</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => { setValue623f1(e.target.files[0]); setPathValue623f1(e.target.value); }}
                  id="623-f1"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue623f1 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                      View File
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue623f1("");
                      document.getElementById("623-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c62x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Screen shots of user interfaces</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue623f2(e.target.files[0]);
                    setPathValue623f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="623-f2"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue623f2 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue623f2("");
                      document.getElementById("623-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c62x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue623f3(e.target.files[0]);
                    setPathValue623f3(e.target.value);
                  }}
                  id="623-f3"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue623f3 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                      View File
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue623f3("");
                      document.getElementById("623-f3").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c62x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Details of implementation of e-governance in area of operation
              </td>
              <td>
                <a href="http://localhost:8080/api/v1/download/criteria6.2.3.xlsx">View Template</a>
              </td>
              <td>
                <input
                  onChange={(e) => {
                    setValue623f4(e.target.files[0]);
                    setPathValue623f4(e.target.value);
                  }}
                  id="623-f4"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue623f4 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                      View File
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue623f4("");
                      document.getElementById("623-f4").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c62x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div> */}

      <div className="c62x-button-container">
        <button className="c62x-button-style" onClick={onClickingSave}>Save</button>
      </div>
    </div>
  );
}

export default Criteria62;
