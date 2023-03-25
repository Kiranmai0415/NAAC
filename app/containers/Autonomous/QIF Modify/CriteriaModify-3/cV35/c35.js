import React, { useState, useEffect } from 'react';
import './c35-style.css';

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
          staff for undertaking consultancy during the last five years
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
  const [value3511t1, setValue3511t1] = useState();
  const [value3511t2, setValue3511t2] = useState();
  const [value3511t3, setValue3511t3] = useState();
  const [value3511t4, setValue3511t4] = useState();
  const [value3511t5, setValue3511t5] = useState();
  const [value3511t6, setValue3511t6] = useState();
  const [value3511t7, setValue3511t7] = useState();
  const [value3511t8, setValue3511t8] = useState();
  const [value3511t9, setValue3511t9] = useState();
  const [value3511t10, setValue3511t10] = useState();
  const [value3511f1, setValue3511f1] = useState('');
  const [pathValue3511f1, setPathValue3511f1] = useState('');
  const [value3511f2, setValue3511f2] = useState('');
  const [pathValue3511f2, setPathValue3511f2] = useState('');
  const [value3511f3, setValue3511f3] = useState('');
  const [pathValue3511f3, setPathValue3511f3] = useState('');
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

  const [gradeScale351, setGradeScale351] = useState('');
  const [gradePoints351, setGradePoints351] = useState();
  const [gradeScaleClickStatus351, setGradeScaleClickStatus351] = useState(false);
  const [gradePointsClickStatus351, setGradePointsClickStatus351] = useState(false);

  const [gradeScale352, setGradeScale352] = useState('');
  const [gradePoints352, setGradePoints352] = useState();
  const [gradeScaleClickStatus352, setGradeScaleClickStatus352] = useState(false);
  const [gradePointsClickStatus352, setGradePointsClickStatus352] = useState(false);

  //get data
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
    () => fetch(resources.APPLICATION_URL+'criteria3getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));
          // setResponseValue111(data[0].criteria35Ql[1].response111);
          // setResponseValue112(data[0].criteria35Ql[2].response112);
          // setResponseValue113(data[0].criteria35Ql[3].response113);

          setValue3511t1(data[0].yearTable3511[0] ? data[0].yearTable3511[0].input3511y : "");
          setValue3511t2(data[0].yearTable3511[1] ? data[0].yearTable3511[1].input3511y : "");
          setValue3511t3(data[0].yearTable3511[2] ? data[0].yearTable3511[2].input3511y : "");
          setValue3511t4(data[0].yearTable3511[3] ? data[0].yearTable3511[3].input3511y : "");
          setValue3511t5(data[0].yearTable3511[4] ? data[0].yearTable3511[4].input3511y : "");
          setValue3511t6(data[0].yearTable3511[0] ? data[0].yearTable3511[0].input3511v : "");
          setValue3511t7(data[0].yearTable3511[1] ? data[0].yearTable3511[1].input3511v : "");
          setValue3511t8(data[0].yearTable3511[2] ? data[0].yearTable3511[2].input3511v : "");
          setValue3511t9(data[0].yearTable3511[3] ? data[0].yearTable3511[3].input3511v : "");
          setValue3511t10(data[0].yearTable3511[4] ? data[0].yearTable3511[4].input3511v : "");

          setValue3521t1(data[0].yearTable3521[0] ? data[0].yearTable3521[0].input3521y : "");
          setValue3521t2(data[0].yearTable3521[1] ? data[0].yearTable3521[1].input3521y : "");
          setValue3521t3(data[0].yearTable3521[2] ? data[0].yearTable3521[2].input3521y : "");
          setValue3521t4(data[0].yearTable3521[3] ? data[0].yearTable3521[3].input3521y : "");
          setValue3521t5(data[0].yearTable3521[4] ? data[0].yearTable3521[4].input3521y : "");
          setValue3521t6(data[0].yearTable3521[0] ? data[0].yearTable3521[0].input3521v : "");
          setValue3521t7(data[0].yearTable3521[1] ? data[0].yearTable3521[1].input3521v : "");
          setValue3521t8(data[0].yearTable3521[2] ? data[0].yearTable3521[2].input3521v : "");
          setValue3521t9(data[0].yearTable3521[3] ? data[0].yearTable3521[3].input3521v : "");
          setValue3521t10(data[0].yearTable3521[4] ? data[0].yearTable3521[4].input3521v : "");

          setValue3511f1(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
          setValue3511f2(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
          setValue3511f3(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
          setValue3521f1(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
          setValue3521f2(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
          setValue3521f3(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
          setValue3521f4(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ),
    []
  );


  
  function onClickingViewResponse351() {
    if (
      value3511t6 === ''
      || value3511t7 === ''
      || value3511t8 === ''
      || value3511t9 === ''
      || value3511t10 === ''
      || value3511t6 === undefined
      || value3511t7 === undefined
      || value3511t8 === undefined
      || value3511t9 === undefined
      || value3511t10 === undefined
    ) {
      setResponseValue351('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3511t6, 10)) === false
      || Number.isInteger(parseInt(value3511t7, 10)) === false
      || Number.isInteger(parseInt(value3511t8, 10)) === false
      || Number.isInteger(parseInt(value3511t9, 10)) === false
      || Number.isInteger(parseInt(value3511t10, 10)) === false
    ) {
      setResponseValue351('Input should be an Integer');
    } else if (
      value3511t6 !== ''
      && value3511t7 !== ''
      && value3511t8 !== ''
      && value3511t9 !== ''
      && value3511t10 !== ''
    ) {
      setResponseValue351(
        parseInt(value3511t6, 10)
          + parseInt(value3511t7, 10)
          + parseInt(value3511t8, 10)
          + parseInt(value3511t9, 10)
          + parseInt(value3511t10, 10)
      );
    }
  }
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
 
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
    criteria35Ql: [
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
        uniqueKey1:1,
        response351: responseValue351,
        response352: responseValue352,
        criteria35status:"save"
      },
    ],
    yearTable3511: [
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 1, input3511y: value3511t1, input3511v: value3511t6
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType},
         uniqueKey1: 2, input3511y: value3511t2, input3511v: value3511t7
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 3, input3511y: value3511t3, input3511v: value3511t8
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 4, input3511y: value3511t4, input3511v: value3511t9
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType},
         uniqueKey1: 5, input3511y: value3511t5, input3511v: value3511t10
      },
    ],

    yearTable3521: [
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType},
         uniqueKey1: 1, input3521y: value3521t1, input3521v: value3521t6
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 2, input3521y: value3521t2, input3521v: value3521t7
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 3, input3521y: value3521t3, input3521v: value3521t8
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType},
         uniqueKey1: 4, input3521y: value3521t4, input3521v: value3521t9
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 5, input3521y: value3521t5, input3521v: value3521t10
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form35Data = new FormData();

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

  // getfile data with API

function downloadFile(fileName) {
  const filePath = "http://localhost:8080/api/v1/download/" + fileName;
  return filePath;
}


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
          <h1 className="c35x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c35x-container">
            <div className="c35x-heading_Help-container">
              <h1 className="c35x-heading-style">
                <span className="c35x-span-style">3.5.1: </span>
                Revenue generated from consultancy and corporate training during the last five years
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
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            <div className="c35x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus351(!responseButtonStatus351);
                  onClickingViewResponse351();
                }}
                className="c35x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus351 ? (
                <p className="c35x-responseResult-style">{responseValue351}</p>
              ) : null}
            </div>
          </div>
          <div className="c35xx-container">
            <h1 className="c35xx-Heading-style">
              <span className="c35xx-span-style">3.5.1.1: </span>
              Total amount generated from consultancy and corporate training
              year-wise during the last five years (INR in lakhs)
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
                      onChange={(e) => setValue3511t1(e.target.value)}
                      id="3511-t1"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t1}
                    />
                    {value3511t1 === '' ? (
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
                      onChange={(e) => setValue3511t2(e.target.value)}
                      id="3511-t2"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t2}
                    />
                    {value3511t2 === '' ? (
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
                      onChange={(e) => setValue3511t3(e.target.value)}
                      id="3511-t3"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t3}
                    />
                    {value3511t3 === '' ? (
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
                      onChange={(e) => setValue3511t4(e.target.value)}
                      id="3511-t4"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t4}
                    />
                    {value3511t4 === '' ? (
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
                      onChange={(e) => setValue3511t5(e.target.value)}
                      id="3511-t5"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t5}
                    />
                    {value3511t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c35x-horizontalTable-heading-style">
                  Number
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
                      onChange={(e) => setValue3511t6(e.target.value)}
                      id="3511-t6"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t6}
                    />
                    {value3511t6 === '' ? (
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
                      onChange={(e) => setValue3511t7(e.target.value)}
                      id="3511-t7"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t7}
                    />
                    {value3511t7 === '' ? (
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
                      onChange={(e) => setValue3511t8(e.target.value)}
                      id="3511-t8"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t8}
                    />
                    {value3511t8 === '' ? (
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
                      onChange={(e) => setValue3511t9(e.target.value)}
                      id="3511-t9"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t9}
                    />
                    {value3511t9 === '' ? (
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
                      onChange={(e) => setValue3511t10(e.target.value)}
                      id="3511-t10"
                      className="c35x-input-style"
                      type="text"
                      value={value3511t10}
                    />
                    {value3511t10 === '' ? (
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
                  Audited statements of accounts indicating the revenue
                  generated through consultancy and corporate training
                </td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3511f1(e.target.files[0]);
                      setPathValue3511f1(e.target.value);
                    }}
                    id="3511-f1"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3511f1 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3511f1("");
                      document.getElementById("3511-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3511f1)} target="_blank">View File</a>
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
                id="3511-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3511f1(e.target.files[0]);
                    setPathValue3511f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3511f1}
              {pathValue3511f1 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3511f1("");
                      document.getElementById("3511-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3511f2(e.target.files[0]);
                      setPathValue3511f2(e.target.value);
                    }}
                    id="3511-f2"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3511f2 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3511f2("");
                      document.getElementById("3511-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3511f2)} target="_blank">View File</a>
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
                id="3511-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3511f2(e.target.files[0]);
                    setPathValue3511f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3511f2}
              {pathValue3511f2 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3511f2("");
                      document.getElementById("3511-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>List of consultants and revenue generated by them</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3511f3(e.target.files[0]);
                      setPathValue3511f3(e.target.value);
                    }}
                    id="3511-f3"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3511f3 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3511f3("");
                      document.getElementById("3511-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3511f3)} target="_blank">View File</a> */}
                  
                  <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="3511-f3"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3511f3(e.target.files[0]);
                    setPathValue3511f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3511f3}
              {pathValue3511f3 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3511f3("");
                      document.getElementById("3511-f3").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c35x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus351(true);
                setGradeScale351(numberMetricGradeCalculator(responseValue351));
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

            {gradeScaleClickStatus351 ? (
              <p className="c35x-responseResult-style">
                {numberMetricGradeCalculator(responseValue351)}
              </p>
            ) : null}
          </div>
          <div className="c35x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus351(true);
                setGradeScale351(numberMetricGradeCalculator(responseValue351));
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
            {gradePointsClickStatus351 ? (
              <p className="c35x-responseResult-style">
                {metricGradePointsCalculator(gradeScale351, 5)}
              </p>
            ) : null}
          </div>
        </div> */}
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
                Total amount spent on developing facilities, training teachers
                and staff for undertaking consultancy during the last five years
                (INR in Lakhs).
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
          <div className="c35xx-container">
            <h1 className="c35xx-Heading-style">
              <span className="c35xx-span-style">3.5.2.1: </span>
              Total amount spent on developing facilities, training teachers and
              staff for undertaking consultancy during the last five years (INR
              in Lakhs)
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                  Number
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                  Audited statements of accounts indicating the expenditure
                  incurred on developing facilities and training teachers and
                  staff for undertaking consultancy
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3521f1(e.target.files[0]);
                      setPathValue3521f1(e.target.value);
                    }}
                    id="3521-f1"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3521f1 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3521f1("");
                      document.getElementById("3521-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3521f1)} target="_blank">View File</a>
                  <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div>
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List of training programmes, teachers and staff trained for
                  undertaking consultancy
                </td>
                <td>
                  <a href="http://localhost:8080/api/v1/download/criteria3.5.2.xlsx">View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3521f2(e.target.files[0]);
                      setPathValue3521f2(e.target.value);
                    }}
                    id="3521-f2"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3521f2 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3521f2("");
                      document.getElementById("3521-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3521f2)} target="_blank">View File</a>
                  <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div>
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3521f3(e.target.files[0]);
                      setPathValue3521f3(e.target.value);
                    }}
                    id="3521-f3"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3521f3 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3521f3("");
                      document.getElementById("3521-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3521f3)} target="_blank">View File</a>
                  <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div>
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
                    }}
                    id="3521-f4"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3521f4 === '' ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3521f4("");
                      document.getElementById("3521-f4").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                   <a href={downloadFile(value3521f2)} target="_blank">View File</a>
                  <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div>
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>

        <div>
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
          Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria35;
