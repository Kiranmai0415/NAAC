import React, { useState, useEffect } from 'react';
import './c44-style.css';
import AuthService from '../../../../Pages/Users/services/auth.service';
import { toast } from 'react-toastify';
import { Button } from '@mui/material';
import { resources } from '../../../../appConstants';
import { HelpButton } from '../../../../../reusableComponents/model/Help';

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
function Help441(props) {
  return props.isHelp441Clicked ? (
    <div className="c44x-help-mainContainer">
      <div className="c44x-help-subContainer">
        <h1 className="c44x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c44x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>Expenditure incurred on  maintenance of
            physical facilities and academic support facilities excluding salary component
          <span style={{ fontWeight: 'bold' }}> / </span>Total expenditure
          excluding salary component.
          <span style={{ fontWeight: 'bold' }}>) * </span>100
        </p>
        <p className="44x-help-para-style">Average Percentage
          <span style={{ fontWeight: 'bold' }}>=(</span> ΣPercentage per year
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>
        <button
          className="c44x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp441Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help442(props) {
  return props.isHelp442Clicked ? (
    <div className="c44x-help-mainContainer">
      <div className="c44x-help-subContainer">
        <h1 className="c44x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c44x-help-para-style">
        Describe policy details of systems and procedures for maintaining and utilizing physical, academic and support
         facilities on the website within a minimum of 500 word and maximum of 1000 words
        </p>
        <button
          className="c44x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp442Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Criteria44() {
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
  const [value4411t1, setValue4411t1] = useState();
  const [value4411t2, setValue4411t2] = useState();
  const [value4411t3, setValue4411t3] = useState();
  const [value4411t4, setValue4411t4] = useState();
  const [value4411t5, setValue4411t5] = useState();
  const [value4411t6, setValue4411t6] = useState();
  const [value4411t7, setValue4411t7] = useState();
  const [value4411t8, setValue4411t8] = useState();
  const [value4411t9, setValue4411t9] = useState();
  const [value4411t10, setValue4411t10] = useState();
  const [value4411t11, setValue4411t11] = useState();
  const [value4411t12, setValue4411t12] = useState();
  const [value4411t13, setValue4411t13] = useState();
  const [value4411t14, setValue4411t14] = useState();
  const [value4411t15, setValue4411t15] = useState();
  const [value4411t16, setValue4411t16] = useState();
  const [value4411t17, setValue4411t17] = useState();
  const [value4411t18, setValue4411t18] = useState();
  const [value4411t19, setValue4411t19] = useState();
  const [value4411t20, setValue4411t20] = useState();

  const [value4411f1, setValue4411f1] = useState('');
  const [pathValue4411f1, setPathValue4411f1] = useState('');
  const [value4411f2, setValue4411f2] = useState('');
  const [pathValue4411f2, setPathValue4411f2] = useState('');
  const [value4411f3, setValue4411f3] = useState('');
  const [pathValue4411f3, setPathValue4411f3] = useState('');
  const [responseButtonStatus441, setResponseButtonStatus441] = useState(false);
  const [responseValue441, setResponseValue441] = useState('');
  const [help441Status, setHelp441Status] = useState(false);

  const [value442t1, setValue442t1] = useState();
  const [value442f1, setValue442f1] = useState('');
  const [pathValue442f1, setPathValue442f1] = useState('');
  const [value442f2, setValue442f2] = useState('');
  const [pathValue442f2, setPathValue442f2] = useState('');
  const [responseButtonStatus442, setResponseButtonStatus442] = useState(false);
  const [responseValue442, setResponseValue442] = useState('');
  const [help442Status, setHelp442Status] = useState(false);

  
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
  const filePath =resources.APPLICATION_URL+"download" + fileName;
  return filePath;
}
//get data api
// const financialYear='2021-2022';
  useEffect(
    () => fetch(resources.APPLICATION_URL+'criteria4getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));

          setValue442t1(data[0].criteria44Ql[0].input442t1);

          setValue4411t1(data[0].yearTable4411[0] ? data[0].yearTable4411[0].input4411y: "");
          setValue4411t2(data[0].yearTable4411[1] ? data[0].yearTable4411[1].input4411y: "");
          setValue4411t3(data[0].yearTable4411[2] ? data[0].yearTable4411[2].input4411y: "");
          setValue4411t4(data[0].yearTable4411[3] ? data[0].yearTable4411[3].input4411y: "");
          setValue4411t5(data[0].yearTable4411[4] ? data[0].yearTable4411[4].input4411y: "");
          setValue4411t6(data[0].yearTable4411[0] ? data[0].yearTable4411[0].input4411y: "");
          setValue4411t7(data[0].yearTable4411[1] ? data[0].yearTable4411[1].input4411y: "");
          setValue4411t8(data[0].yearTable4411[2] ? data[0].yearTable4411[2].input4411y: "");
          setValue4411t9(data[0].yearTable4411[3] ? data[0].yearTable4411[3].input4411y: "");
          setValue4411t10(data[0].yearTable4411[4] ? data[0].yearTable4411[4].input4411y: "");

          setValue4411t11(data[0].yearTable44112[0] ? data[0].yearTable44112[0].input44112y:"");
          setValue4411t12(data[0].yearTable44112[1] ? data[0].yearTable44112[1].input44112y:"");
          setValue4411t13(data[0].yearTable44112[2] ? data[0].yearTable44112[2].input44112y:"");
          setValue4411t14(data[0].yearTable44112[3] ? data[0].yearTable44112[3].input44112y:"");
          setValue4411t15(data[0].yearTable44112[4] ? data[0].yearTable44112[4].input44112y:"");
          setValue4411t16(data[0].yearTable44112[0] ? data[0].yearTable44112[0].input44112y:"");
          setValue4411t17(data[0].yearTable44112[1] ? data[0].yearTable44112[1].input44112y:"");
          setValue4411t18(data[0].yearTable44112[2] ? data[0].yearTable44112[2].input44112y:"");
          setValue4411t19(data[0].yearTable44112[3] ? data[0].yearTable44112[3].input44112y:"");
          setValue4411t20(data[0].yearTable44112[4] ? data[0].yearTable44112[4].input44112y:"");

          setValue4411f1(data[0].criteria4FileUpload[0] ? data[0].criteria4FileUpload[0].criteria4FileName:"");
          setValue4411f2(data[0].criteria4FileUpload[1] ? data[0].criteria4FileUpload[1].criteria4FileName:"");
          setValue4411f3(data[0].criteria4FileUpload[0] ? data[0].criteria4FileUpload[0].criteria4FileName:"");
          setValue442f1(data[0].criteria4FileUpload[1] ? data[0].criteria4FileUpload[1].criteria4FileName:"");
          setValue442f2(data[0].criteria4FileUpload[0] ? data[0].criteria4FileUpload[0].criteria4FileName:"");
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ),
    []
  );

 

  function onClickingViewResponse441() {
    if (
      value4411t6 === ''
          || value4411t7 === ''
          || value4411t8 === ''
          || value4411t9 === ''
          || value4411t10 === ''
          || value4411t16 === ''
          || value4411t17 === ''
          || value4411t18 === ''
          || value4411t19 === ''
          || value4411t20 === ''
          || value4411t6 === undefined
          || value4411t7 === undefined
          || value4411t8 === undefined
          || value4411t9 === undefined
          || value4411t10 === undefined
          || value4411t16 === undefined
          || value4411t17 === undefined
          || value4411t18 === undefined
          || value4411t19 === undefined
          || value4411t20 === undefined
    ) {
      setResponseValue441('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value4411t6, 10)) === false
          || Number.isInteger(parseInt(value4411t7, 10)) === false
          || Number.isInteger(parseInt(value4411t8, 10)) === false
          || Number.isInteger(parseInt(value4411t9, 10)) === false
          || Number.isInteger(parseInt(value4411t10, 10)) === false
          || Number.isInteger(parseInt(value4411t16, 10)) === false
          || Number.isInteger(parseInt(value4411t17, 10)) === false
          || Number.isInteger(parseInt(value4411t18, 10)) === false
          || Number.isInteger(parseInt(value4411t19, 10)) === false
          || Number.isInteger(parseInt(value4411t20, 10)) === false
    ) {
      setResponseValue441('Input should be an Integer');
    } else if (
      value4411t6 !== ''
          && value4411t7 !== ''
          && value4411t8 !== ''
          && value4411t9 !== ''
          && value4411t10 !== ''
          && value4411t16 !== ''
          && value4411t17 !== ''
          && value4411t18 !== ''
          && value4411t19 !== ''
          && value4411t20 !== ''
    ) {
      setResponseValue441(((((value4411t6 / value4411t16) * 100)
           + ((value4411t7 / value4411t17) * 100)
           + ((value4411t8 / value4411t18) * 100)
          + ((value4411t9 / value4411t19) * 100)
          + ((value4411t10 / value4411t20) * 100)) / 5));
    }
  }

 // sending data to db with API

 


 const inputDataList = {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
  criteria44Ql: [
    { 
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      uniqueKey1: 201,
      input442t1: value442t1,
      response442: responseValue442,
      response441: responseValue441, 
    },
  ],
 
    yearTable4411: [
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
       uniqueKey1: 201,input4411y: value4411t1, input4411v: value4411t6 },
       {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
       uniqueKey1: 202,input4411y: value4411t2, input4411v: value4411t7 },
       {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
       uniqueKey1: 203,input4411y: value4411t3, input4411v: value4411t8 },
       {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
       uniqueKey1: 204,input4411y: value4411t4, input4411v: value4411t9 },
       {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
       uniqueKey1: 205,input4411y: value4411t5, input4411v: value4411t10 },
    ],
    yearTable44112: [
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
       uniqueKey1: 201,input44112y: value4411t11, input44112v: value4411t16 },
       {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
       uniqueKey1: 202,input44112y: value4411t12, input44112v: value4411t17 },
       {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
       uniqueKey1: 203,input44112y: value4411t13, input44112v: value4411t18 },
       {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
       uniqueKey1: 204,input44112y: value4411t14, input44112v: value4411t19 },
       {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
       uniqueKey1: 205,input44112y: value4411t15, input44112v: value4411t20 },
    ],
};

function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: 'application/json',
  });
}

function onClickingSave() {
  const form44Data = new FormData();

  form44Data.append('criteria4Fieldinfo', jsonBlob(inputDataList));
  if (pathValue4411f1 !== '') {
    form44Data.append('uploadfile4', value4411f1, 'f4411f1-' + value4411f1.name);
  }
  if (pathValue4411f2 !== '') {
    form44Data.append('uploadfile4', value4411f2, 'f4411f2-' + value4411f2.name);
  }
  if (pathValue4411f3 !== '') {
    form44Data.append('uploadfile4', value4411f3, 'f4411f3-' + value4411f3.name);
  }
  if (pathValue442f1 !== '') {
    form44Data.append('uploadfile4', value442f1, 'f442f1-' + value442f1.name);
  }
  if (pathValue442f2 !== '') {
    form44Data.append('uploadfile4', value442f2, 'f442f2-' + value442f2.name);
  }

  const filesFetchMethod = {
    method: 'POST',
    headers: { Accept: 'application/json ,text/plain' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: form44Data,
  };
  fetch(
    resources.APPLICATION_URL+'criteria4upload',
    filesFetchMethod
  ).then((response) => {
    console.log(response);
    if (response.ok) {
      successMessage("Saved Successfully");
    } else if (response.status >= 400) {
      errorMessage("Got the Error Please retry after sometime");
    }
  });
}


  return (
    <div className="c44-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c44x-colorIndicator-container">
        <p className="c44x-QlcolorIndicator-circle-style"></p>
        <span className="c44x-colorIndicator-span-style">Qualitative</span>
        <p className="c44x-QtcolorIndicator-circle-style"></p>
        <span className="c44x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c44x-weightage-heading-style">
            Key Indicator Weightage: 20
          </h1>
        </div>
      </div>

      {/* Key Indicator: 4.4.1 */}
      <div className="c44x-eachInputField-container">
        <div className="c44x-weightage-container">
          <h1 className="c44x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c44x-container">
            <div className="c44x-heading_Help-container">
              <h1 className="c44x-heading-style">
                <span className="c44x-span-style">4.4.1: </span>
                Percentage expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component during the last five years
              </h1>
              <button
                onClick={handleHelpOpen2}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen2}
                handleClose={handleHelpClose2}
                title='formula'
                ><h1>(Total expenditure on maintenance of physical and academic support facilities excluding salary component) / (3.1 Total expenditure excluding salary component) * 100 </h1></HelpButton>
            </div>
            <div className="c44x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus441(!responseButtonStatus441); onClickingViewResponse441();
                }}
                className="c44x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus441 ? (
                <p className="c44x-responseResult-style">{responseValue441}</p>
              ) : null}
            </div>
          </div>
          <div className="c44xx-container">
            <h1 className="c44xx-Heading-style">
              <span className="c44xx-span-style">4.4.1.1: </span>
              Expenditure incurred on maintenance of physical facilities and
              academic support facilities excluding salary component year wise
              during the last five years (INR in lakhs)
            </h1>

            <table className="c44x-Qt-table-style">
              <tr>
                <th className="c44x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue4411t1(e.target.value)}
                      id="4411-t1"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t1}
                    />
                    {value4411t1 === '' ? (
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
                      onChange={(e) => setValue4411t2(e.target.value)}
                      id="4411-t2"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t2}
                    />
                    {value4411t2 === '' ? (
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
                      onChange={(e) => setValue4411t3(e.target.value)}
                      id="4411-t3"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t3}
                    />
                    {value4411t3 === '' ? (
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
                      onChange={(e) => setValue4411t4(e.target.value)}
                      id="4411-t4"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t4}
                    />
                    {value4411t4 === '' ? (
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
                      onChange={(e) => setValue4411t5(e.target.value)}
                      id="4411-t5"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t5}
                    />
                    {value4411t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c44x-horizontalTable-heading-style">
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
                      onChange={(e) => { setValue4411t6(e.target.value); onClickingViewResponse441(); }}
                      id="4411-t6"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t6}
                    />
                    {value4411t6 === '' ? (
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
                      onChange={(e) => { setValue4411t7(e.target.value); onClickingViewResponse441(); }}
                      id="4411-t7"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t7}
                    />
                    {value4411t7 === '' ? (
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
                      onChange={(e) => { setValue4411t8(e.target.value); onClickingViewResponse441(); }}
                      id="4411-t8"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t8}
                    />
                    {value4411t8 === '' ? (
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
                      onChange={(e) => { setValue4411t9(e.target.value); onClickingViewResponse441(); }}
                      id="4411-t9"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t9}
                    />
                    {value4411t9 === '' ? (
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
                      onChange={(e) => { setValue4411t10(e.target.value); onClickingViewResponse441(); }}
                      id="4411-t10"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t10}
                    />
                    {value4411t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            {/* <table className="c44x-Qt-table-style">
              <tr>
                <th className="c44x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue4411t11(e.target.value)}
                      id="4411-t11"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t11}
                    />
                    {value4411t11 === '' ? (
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
                      onChange={(e) => setValue4411t12(e.target.value)}
                      id="4411-t12"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t12}
                    />
                    {value4411t12 === '' ? (
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
                      onChange={(e) => setValue4411t13(e.target.value)}
                      id="4411-t13"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t13}
                    />
                    {value4411t13 === '' ? (
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
                      onChange={(e) => setValue4411t14(e.target.value)}
                      id="4411-t14"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t14}
                    />
                    {value4411t14 === '' ? (
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
                      onChange={(e) => setValue4411t15(e.target.value)}
                      id="4411-t15"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t15}
                    />
                    {value4411t15 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c44x-horizontalTable-heading-style">
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
                      onChange={(e) => { setValue4411t16(e.target.value); onClickingViewResponse441(); }}
                      id="4411-t16"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t16}
                    />
                    {value4411t16 === '' ? (
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
                      onChange={(e) => { setValue4411t17(e.target.value); onClickingViewResponse441(); }}
                      id="4411-t17"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t17}
                    />
                    {value4411t17 === '' ? (
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
                      onChange={(e) => { setValue4411t18(e.target.value); onClickingViewResponse441(); }}
                      id="4411-t18"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t18}
                    />
                    {value4411t18 === '' ? (
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
                      onChange={(e) => { setValue4411t19(e.target.value); onClickingViewResponse441(); }}
                      id="4411-t19"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t19}
                    />
                    {value4411t19 === '' ? (
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
                      onChange={(e) => { setValue4411t20(e.target.value); onClickingViewResponse441(); }}
                      id="4411-t20"
                      className="c44x-input-style"
                      type="text"
                      value={value4411t20}
                    />
                    {value4411t20 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> */}

            <table className="c44x-table-style">
              <tr>
                <th className="c44x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c44x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c44x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c44x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                {/* <a href={downloadFile(value4411f1)} target="_blank">view</a> */}
                <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="4411-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue4411f1(e.target.files[0]);
                    setPathValue4411f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue4411f1}
              {pathValue4411f1 === "" ? null : (
                <div className="c44-fileButtons-container">
                  <button
                    className="c44-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc441f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c44-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue4411f1("");
                      document.getElementById("4411-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c44x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Audited statements of accounts</td>
                <td></td>
                <td>
                {/* <a href={downloadFile(value4411f2)} target="_blank">view</a> */}
                <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="4411-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue4411f2(e.target.files[0]);
                    setPathValue4411f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue4411f2}
              {pathValue4411f2 === "" ? null : (
                <div className="c44-fileButtons-container">
                  <button
                    className="c44-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc441f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c44-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue4411f2("");
                      document.getElementById("4411-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c44x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Details about assigned budget and expenditure on physical
                  facilities and academic facilities
                </td>
                <td>
                  <a href="http://localhost:8080/api/v1/download/criteria4.1.4&4.4.1.xlsx">View Template</a>
                </td>
                <td>
                {/* <a href={downloadFile(value4411f3)} target="_blank">view</a> */}
                <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="4411-f3"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue4411f3(e.target.files[0]);
                    setPathValue4411f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue4411f3}
              {pathValue4411f3 === "" ? null : (
                <div className="c44-fileButtons-container">
                  <button
                    className="c44-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc441f3}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c44-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue4411f3("");
                      document.getElementById("4411-f3").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c44x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 4.4.2 */}
      <div className="c44x-eachInputField-container">
        <div className="c44x-weightage-container">
          <h1 className="c44x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c44x-Ql-label-textarea-container">
            <div className="c44x-heading_Help-container">
              <h1 className="c44x-heading-style">
                <span className="c44x-span-style">4.4.2: </span>
                There are established systems and procedures for maintaining and utilising physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc
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
            <label htmlFor="442-t1" className="c44x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue442t1(e.target.value);
                setResponseValue442(e.target.value);
              }}
              value={value442t1}
              rows={10}
              className="c44x-textarea-style"
              id="442-t1"
            ></textarea>
            {value442t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c44x-Ql-table-style">
            <tr>
              <th className="c44x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c44x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c44x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c44x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c44x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c44x-Ql-tableBorders-style"></td>
              <td className="c44x-Ql-tableBorders-style">
              {/* <a href={downloadFile(value442f1)} target="_blank">view</a> */}
              <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="442-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue442f1(e.target.files[0]);
                    setPathValue442f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue442f1}
              {pathValue442f1 === "" ? null : (
                <div className="c44-fileButtons-container">
                  <button
                    className="c44-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc442f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c44-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue442f1("");
                      document.getElementById("442-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c44x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
              {/* <a href={downloadFile(value442f2)} target="_blank">view</a> */}
              <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="442-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue442f2(e.target.files[0]);
                    setPathValue442f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue442f2}
              {pathValue442f2 === "" ? null : (
                <div className="c44-fileButtons-container">
                  <button
                    className="c44-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc441f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c44-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue442f2("");
                      document.getElementById("442-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c44x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
      <div className="c44x-button-container">
        <button onClick={onClickingSave} className="c44x-button-style">
         Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria44;
