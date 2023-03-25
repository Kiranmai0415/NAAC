import React, { useState } from 'react';
import './c35-style.css';
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

function Help351(props) {
  return props.isHelp351Clicked ? (
    <div className="c35x-help-mainContainer">
      <div className="c35x-help-subContainer">
        <h1 className="c35x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c35x-help-para-style">
          Total amount generated from consultancy and corporate training year
          wise during last five years (INR in lakhs)
        </p>
        <button
          className="c35x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp351Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help352(props) {
  return props.isHelp352Clicked ? (
    <div className="c35x-help-mainContainer">
      <div className="c35x-help-subContainer">
        <h1 className="c35x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c35x-help-para-style">
          Total amount spent on developing facilities, training teachers and
          staff for undertaking consultancy during the last five years. Data
          Requirement for last five years: (As per Data Template)
          <br />
          • Facility developed and amount spent
          <br />
          • Training programmes for teachers for undertaking consultancy
          <br />
          • Training programmes for staff for supporting consultancy activities.
          <br />
          • Total expenditure on training teachers and staff for consultancy{' '}
          <br />
        </p>
        <button
          className="c35x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp352Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Criteria35() {

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


  const [value3511f1, setValue3511f1] = useState('');
  const [pathValue3511f1, setPathValue3511f1] = useState('');
  const [value3511f2, setValue3511f2] = useState('');
  const [pathValue3511f2, setPathValue3511f2] = useState('');
  const [value3511f3, setValue3511f3] = useState('');
  const [pathValue3511f3, setPathValue3511f3] = useState('');
  const [value3511f4, setValue3511f4] = useState('');
  const [pathValue3511f4, setPathValue3511f4] = useState('');
  const [responseButtonStatus351, setResponseButtonStatus351] = useState(false);
  const [responseValue351, setResponseValue351] = useState('');
  const [help351Status, setHelp351Status] = useState(false);

  const [value3521t1, setValue3521t1] = useState();
  const [value3521t2, setValue3521t2] = useState();
  const [value3521t3, setValue3521t3] = useState();
  const [value3521t4, setValue3521t4] = useState();
  const [value3521t5, setValue3521t5] = useState();
  const [value3521t6, setValue3521t6] = useState();
  const [value3521t7, setValue3521t7] = useState();
  const [value3521t8, setValue3521t8] = useState();
  const [value3521t9, setValue3521t9] = useState();
  const [value3521t10, setValue3521t10] = useState();
  const [value3521f1, setValue3521f1] = useState('');
  const [pathValue3521f1, setPathValue3521f1] = useState('');
  const [value3521f2, setValue3521f2] = useState('');
  const [pathValue3521f2, setPathValue3521f2] = useState('');
  const [value3521f3, setValue3521f3] = useState('');
  const [pathValue3521f3, setPathValue3521f3] = useState('');
  const [value3521f4, setValue3521f4] = useState('');
  const [pathValue3521f4, setPathValue3521f4] = useState('');
  const [responseButtonStatus352, setResponseButtonStatus352] = useState(false);
  const [responseValue352, setResponseValue352] = useState('');
  const [help352Status, setHelp352Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');

// response functionality

  function onClickingViewResponse352() {
    if (
      value3521t6 === ''
      || value3521t7 === ''
      || value3521t8 === ''
      || value3521t9 === ''
      || value3521t10 === ''
      || value3521t6 === undefined
      || value3521t7 === undefined
      || value3521t8 === undefined
      || value3521t9 === undefined
      || value3521t10 === undefined
    ) {
      setResponseValue352('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3521t6, 10)) === false
      || Number.isInteger(parseInt(value3521t7, 10)) === false
      || Number.isInteger(parseInt(value3521t8, 10)) === false
      || Number.isInteger(parseInt(value3521t9, 10)) === false
      || Number.isInteger(parseInt(value3521t10, 10)) === false
    ) {
      setResponseValue352('Input should be an Integer');
    } else if (
      value3521t6 !== ''
      && value3521t7 !== ''
      && value3521t8 !== ''
      && value3521t9 !== ''
      && value3521t10 !== ''
    ) {
      setResponseValue352(
        parseInt(value3521t6, 10)
          + parseInt(value3521t7, 10)
          + parseInt(value3521t8, 10)
          + parseInt(value3521t9, 10)
          + parseInt(value3521t10, 10)
      );
    }
  }

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
  criteria35Ql: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
      // response351: responseValue351,
      response352: responseValue352,
    
      },
    ],

    criteria35Qn: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
    
      criteria35status:"save"
      },
    ],
      yearTable3521: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,input3521y: value3521t1, input3521v: value3521t6 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202,input3521y: value3521t2, input3521v: value3521t7 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203,input3521y: value3521t3, input3521v: value3521t8 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204,input3521y: value3521t4, input3521v: value3521t9 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205,input3521y: value3521t5, input3521v: value3521t10 },
      ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form35Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form35Data.append('criteria3Fieldinfo', jsonBlob(inputDataList));
    if (pathValue3511f1 !== '') {
      form35Data.append(
        'uploadfile3',
        value3511f1,
        'f3511f1-' + value3511f1.name
      );
    }
    if (pathValue3511f2 !== '') {
      form35Data.append(
        'uploadfile3',
        value3511f2,
        'f3511f2-' + value3511f2.name
      );
    }
    if (pathValue3511f3 !== '') {
      form35Data.append(
        'uploadfile3',
        value3511f3,
        'f3511f3-' + value3511f3.name
      );
    }
    if (pathValue3511f4 !== '') {
      form35Data.append(
        'uploadfile3',
        value3511f4,
        'f3511f4-' + value3511f4.name
      );
    }
    if (pathValue3521f1 !== '') {
      form35Data.append(
        'uploadfile3',
        value3521f1,
        'f3521f1-' + value3521f1.name
      );
    }
    if (pathValue3521f2 !== '') {
      form35Data.append(
        'uploadfile3',
        value3521f2,
        'f3521f2-' + value3521f2.name
      );
    }
    if (pathValue3521f3 !== '') {
      form35Data.append(
        'uploadfile3',
        value3521f3,
        'f3521f3-' + value3521f3.name
      );
    }
    if (pathValue3521f4 !== '') {
      form35Data.append(
        'uploadfile3',
        value3521f4,
        'f3521f4-' + value3521f4.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form35Data,
    };
    fetch(
      resources.APPLICATION_URL+'criteria3upload',
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
    <div className="c35-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c35x-colorIndicator-container">
        <p className="c35x-QlcolorIndicator-circle-style"></p>
        <span className="c35x-colorIndicator-span-style">Qualitative</span>
        <p className="c35x-QtcolorIndicator-circle-style"></p>
        <span className="c35x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c35x-weightage-heading-style">
            Key Indicator Weightage: 10
          </h1>
        </div>
      </div>

      {/* Key Indicator: 3.5.1 */}
      <div className="c35x-eachInputField-container">
        <div className="c35x-weightage-container">
          <h1 className="c35x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c35x-container">
            <div className="c35x-heading_Help-container">
              <h1 className="c35x-heading-style">
                <span className="c35x-span-style">3.5.1: </span>
                Revenue generated from consultancy and corporate training during the last five years (INR in Lakhs)              </h1>
              
                <button
                onClick={handleHelpOpen}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
          </div>
          <div className="c35xx-container">
          
            <h1 className="c35xx-Heading-style">
              <span className="c35xx-span-style">3.5.1.1: </span>
              Total amount generated from consultancy and corporate training year-wise during the last five years (INR in lakhs)
            </h1>

            <table className="c35x-Qt-table-style">
              <tr>
                <th className="c35x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3521t1(e.target.value)}
                      id="3521-t1"
                      className="c35x-input-style"
                      type="number"
                      value={value3521t1}
                    />
                    {value3521t1 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3521t2(e.target.value)}
                      id="3521-t2"
                      className="c35x-input-style"
                      type="number"
                      value={value3521t2}
                    />
                    {value3521t2 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3521t3(e.target.value)}
                      id="3521-t3"
                      className="c35x-input-style"
                      type="number"
                      value={value3521t3}
                    />
                    {value3521t3 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3521t4(e.target.value)}
                      id="3521-t4"
                      className="c35x-input-style"
                      type="number"
                      value={value3521t4}
                    />
                    {value3521t4 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3521t5(e.target.value)}
                      id="3521-t5"
                      className="c35x-input-style"
                      type="number"
                      value={value3521t5}
                    />
                    {value3521t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c35x-horizontalTable-heading-style">
                  INR in lakhs
                </th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3521t6(e.target.value)}
                      id="3521-t6"
                      className="c35x-input-style"
                      type="number"
                      value={value3521t6}
                    />
                    {value3521t6 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3521t7(e.target.value)}
                      id="3521-t7"
                      className="c35x-input-style"
                      type="number"
                      value={value3521t7}
                    />
                    {value3521t7 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3521t8(e.target.value)}
                      id="3521-t8"
                      className="c35x-input-style"
                      type="number"
                      value={value3521t8}
                    />
                    {value3521t8 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3521t9(e.target.value)}
                      id="3521-t9"
                      className="c35x-input-style"
                      type="number"
                      value={value3521t9}
                    />
                    {value3521t9 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3521t10(e.target.value)}
                      id="3521-t10"
                      className="c35x-input-style"
                      type="number"
                      value={value3521t10}
                    />
                    {value3521t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c35x-table-style">
              <tr>
                <th className="c35x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c35x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c35x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c35x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                Audited statement/s of accounts indicating the revenue generated through consultancy
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3521f1(e.target.files[0]);
                      setPathValue3521f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3521-f1"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3521f1 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3521f1("");
                      document.getElementById("3521-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                Any additional information
                </td>
                <td>
                <a href={downloadFile("un3.5.1.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3521f2(e.target.files[0]);
                      setPathValue3521f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3521-f2"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3521f2 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3521f2("");
                      document.getElementById("3521-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Provide the List of consultants and revenue generated by them (Data Template)</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3521f3(e.target.files[0]);
                      setPathValue3521f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3521-f3"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3521f3 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3521f3("");
                      document.getElementById("3521-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List of facilities and staff available for undertaking
                  consultancy
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3521f4(e.target.files[0]);
                      setPathValue3521f4(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3521-f4"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3521f4 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3521f4("");
                      document.getElementById("3521-f4").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
            {/* <table className="c35x-table-style">
              <tr>
                <th className="c35x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c35x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c35x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c35x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                Upload minutes of the Governing Council/ Syndicate/Board of
Management related to the Consultancy policy
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3511f1(e.target.files[0]);
                      setPathValue3511f1(e.target.value);
                      showFilePreview(e);
                      
                    }}
                    id="3511-f1"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3511f1 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3511f1("");
                      document.getElementById("3511-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload the soft copy of the Consultancy Policy</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3511f2(e.target.files[0]);
                      setPathValue3511f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3511-f2"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3511f2 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3511f2("");
                      document.getElementById("3511-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3511f3(e.target.files[0]);
                      setPathValue3511f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3511-f3"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3511f3 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3511f3("");
                      document.getElementById("3511-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Provide the URL of the consultancy policy document</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3511f4(e.target.files[0]);
                      setPathValue3511f4(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3511-f4"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3511f4 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3511f4("");
                      document.getElementById("3511-f4").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table> */}
        </form>
      </div>

      {/* Key Indicator: 3.5.1 */}
      {/* <div className="c35x-eachInputField-container">
         <div className="c35x-weightage-container">
          <h1 className="c35x-weightage-heading-style">Weightage: 5</h1>
        </div> 
         <form> 
         <div className="c35x-container">
            <div className="c35x-heading_Help-container">
              <h1 className="c35x-heading-style">
                <span className="c35x-span-style">3.5.2: </span>
                Revenue generated from consultancy and corporate training during the
last five years (INR in Lakhs)
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp352Status(true);
                }}
                className="c35x-helpButton-style"
              >
                Help
              </button>
              <Help352
                isHelp352Clicked={help352Status}
                setIsHelp352Clicked={setHelp352Status}
              />
            </div>
            <div className="c35x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus352(!responseButtonStatus352);
                  onClickingViewResponse352();
                }}
                className="c35x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus352 ? (
                <p className="c35x-responseResult-style">{responseValue352}</p>
              ) : null}
            </div>
          </div> 
        
         </form> 

        {/* <div>
          <div className="c35x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus352(true);
                setGradeScale352(numberMetricGradeCalculator(responseValue352));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Grade Scale
            </button>

            {gradeScaleClickStatus352 ? (
              <p className="c35x-responseResult-style">
                {numberMetricGradeCalculator(responseValue352)}
              </p>
            ) : null}
          </div>
          <div className="c35x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus352(true);
                setGradeScale352(numberMetricGradeCalculator(responseValue352));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Weighted Grade Points
            </button>
            {gradePointsClickStatus352 ? (
              <p className="c35x-responseResult-style">
                {metricGradePointsCalculator(gradeScale352, 5)}
              </p>
            ) : null}
          </div>
        </div> 
       </div> */}

      <div className="c35x-button-container">
        <button onClick={onClickingSave} className="c35x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria35;
