import React, { useState } from 'react';
import './c36-style.css';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import { resources } from '../../../../appConstants';
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

function Help361(props) {
  return props.isHelp361Clicked ? (
    <div className="c36x-help-mainContainer">
      <div className="c36x-help-subContainer">
        <h1 className="c36x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c36x-help-para-style">
          Describe the impact of extension activities in sensitising students to
          social issues and holistic development within a maximum of 500 words
        </p>
        <button
          className="c36x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp361Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help362(props) {
  return props.isHelp362Clicked ? (
    <div className="c36x-help-mainContainer">
      <div className="c36x-help-subContainer">
        <h1 className="c36x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c36x-help-para-style">
          Total number of awards and recognition received for extension
          activities from Government /recognised bodies year wise during last
          five years
        </p>
        <button
          className="c36x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp362Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help363(props) {
  return props.isHelp363Clicked ? (
    <div className="c36x-help-mainContainer">
      <div className="c36x-help-subContainer">
        <h1 className="c36x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c36x-help-para-style">
          Number of extension and outreach programs conducted by the institution
          including those through NSS/NCC, Government and Government recognised
          bodies during the last five years.
        </p>
        <button
          className="c36x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp363Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help364(props) {
  return props.isHelp364Clicked ? (
    <div className="c36x-help-mainContainer">
      <div className="c36x-help-subContainer">
        <h1 className="c36x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c11x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>
          Total number of students participating in extension activities with
          Government Organisations, Non-Government Organisations and Programmes
          such as Swachh Bharat, Aids Awareness, Gender Issue, etc. year wise
          during last five years
          <span style={{ fontWeight: 'bold' }}> / </span>Total number of
          students
          <span style={{ fontWeight: 'bold' }}>) * </span>100
        </p>
        <p className="c24x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span> ΣPercentage per year
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>
        <button
          className="c36x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp364Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Criteria36() {
  const [value361t1, setValue361t1] = useState();

  const [value361f1, setValue361f1] = useState('');
  const [pathValue361f1, setPathValue361f1] = useState('');
  const [value361f2, setValue361f2] = useState('');
  const [pathValue361f2, setPathValue361f2] = useState('');
  const [responseValue361, setResponseValue361] = useState('');
  const [help361Status, setHelp361Status] = useState(false);

  const [value3621t1, setValue3621t1] = useState();
  const [value3621t2, setValue3621t2] = useState();
  const [value3621t3, setValue3621t3] = useState();
  const [value3621t4, setValue3621t4] = useState();
  const [value3621t5, setValue3621t5] = useState();
  const [value3621t6, setValue3621t6] = useState();
  const [value3621t7, setValue3621t7] = useState();
  const [value3621t8, setValue3621t8] = useState();
  const [value3621t9, setValue3621t9] = useState();
  const [value3621t10, setValue3621t10] = useState();
  const [value3621f1, setValue3621f1] = useState('');
  const [pathValue3621f1, setPathValue3621f1] = useState('');
  const [value3621f2, setValue3621f2] = useState('');
  const [pathValue3621f2, setPathValue3621f2] = useState('');
  const [value3621f3, setValue3621f3] = useState('');
  const [pathValue3621f3, setPathValue3621f3] = useState('');
  const [responseButtonStatus362, setResponseButtonStatus362] = useState(false);
  const [responseValue362, setResponseValue362] = useState('');
  const [help362Status, setHelp362Status] = useState(false);

  const [value3631t1, setValue3631t1] = useState();
  const [value3631t2, setValue3631t2] = useState();
  const [value3631t3, setValue3631t3] = useState();
  const [value3631t4, setValue3631t4] = useState();
  const [value3631t5, setValue3631t5] = useState();
  const [value3631t6, setValue3631t6] = useState();
  const [value3631t7, setValue3631t7] = useState();
  const [value3631t8, setValue3631t8] = useState();
  const [value3631t9, setValue3631t9] = useState();
  const [value3631t10, setValue3631t10] = useState();
  const [value3631f1, setValue3631f1] = useState('');
  const [pathValue3631f1, setPathValue3631f1] = useState('');
  const [value3631f2, setValue3631f2] = useState('');
  const [pathValue3631f2, setPathValue3631f2] = useState('');
  const [value3631f3, setValue3631f3] = useState('');
  const [pathValue3631f3, setPathValue3631f3] = useState('');
  const [responseButtonStatus363, setResponseButtonStatus363] = useState(false);
  const [responseValue363, setResponseValue363] = useState('');
  const [help363Status, setHelp363Status] = useState(false);

  const [value3641t1, setValue3641t1] = useState();
  const [value3641t2, setValue3641t2] = useState();
  const [value3641t3, setValue3641t3] = useState();
  const [value3641t4, setValue3641t4] = useState();
  const [value3641t5, setValue3641t5] = useState();
  const [value3641t6, setValue3641t6] = useState();
  const [value3641t7, setValue3641t7] = useState();
  const [value3641t8, setValue3641t8] = useState();
  const [value3641t9, setValue3641t9] = useState();
  const [value3641t10, setValue3641t10] = useState();
  const [value3641t11, setValue3641t11] = useState();
  const [value3641t12, setValue3641t12] = useState();
  const [value3641t13, setValue3641t13] = useState();
  const [value3641t14, setValue3641t14] = useState();
  const [value3641t15, setValue3641t15] = useState();
  const [value3641t16, setValue3641t16] = useState();
  const [value3641t17, setValue3641t17] = useState();
  const [value3641t18, setValue3641t18] = useState();
  const [value3641t19, setValue3641t19] = useState();
  const [value3641t20, setValue3641t20] = useState();
  const [value3641f1, setValue3641f1] = useState('');
  const [pathValue3641f1, setPathValue3641f1] = useState('');
  const [value3641f2, setValue3641f2] = useState('');
  const [pathValue3641f2, setPathValue3641f2] = useState('');
  const [value3641f3, setValue3641f3] = useState('');
  const [pathValue3641f3, setPathValue3641f3] = useState('');
  const [responseButtonStatus364, setResponseButtonStatus364] = useState(false);
  const [responseValue364, setResponseValue364] = useState('');
  const [help364Status, setHelp364Status] = useState(false);

  const [gradeScale361, setGradeScale361] = useState('');
  const [gradePoints361, setGradePoints361] = useState();
  const [gradePointsClickStatus361, setGradePointsClickStatus361] = useState(false);

  const [gradeScale362, setGradeScale362] = useState('');
  const [gradePoints362, setGradePoints362] = useState();
  const [gradeScaleClickStatus362, setGradeScaleClickStatus362] = useState(false);
  const [gradePointsClickStatus362, setGradePointsClickStatus362] = useState(false);

  const [gradeScale363, setGradeScale363] = useState('');
  const [gradePoints363, setGradePoints363] = useState();
  const [gradeScaleClickStatus363, setGradeScaleClickStatus363] = useState(false);
  const [gradePointsClickStatus363, setGradePointsClickStatus363] = useState(false);

  const [gradeScale364, setGradeScale364] = useState('');
  const [gradePoints364, setGradePoints364] = useState();
  const [gradeScaleClickStatus364, setGradeScaleClickStatus364] = useState(false);
  const [gradePointsClickStatus364, setGradePointsClickStatus364] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');
  function numberMetricGradeCalculator(responseValue) {
    let numberMetricGrade;
    if (responseValue === undefined || responseValue === '') {
      numberMetricGrade = 'Required fields are not filled';
      console.log(responseValue);
    } else if (Number.isInteger(parseInt(responseValue, 10)) === false) {
      numberMetricGrade = responseValue;
    } else if (responseValue >= 100) {
      numberMetricGrade = 4;
    } else if (responseValue >= 80 && responseValue < 100) {
      numberMetricGrade = 3;
    } else if (responseValue >= 60 && responseValue <= 80) {
      numberMetricGrade = 2;
    } else if (responseValue >= 20 && responseValue <= 60) {
      numberMetricGrade = 1;
    } else if (responseValue >= 0 && responseValue <= 20) {
      numberMetricGrade = 0;
    }
    return numberMetricGrade;
  }
  function metricGradePointsCalculator(gradeScale, metricWeightage) {
    if (Number.isInteger(parseInt(gradeScale, 10)) === false) {
      return 'Required fields are not filled';
    }
    return gradeScale * metricWeightage;
  }

  function qlMetricGradePointsCalculator(
    gradeScale,
    setGradePoints,
    metricWeightage
  ) {
    if (gradeScale === undefined || gradeScale === '') {
      setGradePoints('Enter Grade Scale');
    } else {
      setGradePoints(gradeScale * metricWeightage);
    }
  }

  function onClickingViewResponse362() {
    if (
      value3621t6 === ''
      || value3621t7 === ''
      || value3621t8 === ''
      || value3621t9 === ''
      || value3621t10 === ''
      || value3621t6 === undefined
      || value3621t7 === undefined
      || value3621t8 === undefined
      || value3621t9 === undefined
      || value3621t10 === undefined
    ) {
      setResponseValue362('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3621t6, 10)) === false
      || Number.isInteger(parseInt(value3621t7, 10)) === false
      || Number.isInteger(parseInt(value3621t8, 10)) === false
      || Number.isInteger(parseInt(value3621t9, 10)) === false
      || Number.isInteger(parseInt(value3621t10, 10)) === false
    ) {
      setResponseValue362('Input should be an Integer');
    } else if (
      value3621t6 !== ''
      && value3621t7 !== ''
      && value3621t8 !== ''
      && value3621t9 !== ''
      && value3621t10 !== ''
    ) {
      setResponseValue362(
        parseInt(value3621t6, 10)
          + parseInt(value3621t7, 10)
          + parseInt(value3621t8, 10)
          + parseInt(value3621t9, 10)
          + parseInt(value3621t10, 10)
      );
    }
  }
  function onClickingViewResponse363() {
    if (
      value3631t6 === ''
      || value3631t7 === ''
      || value3631t8 === ''
      || value3631t9 === ''
      || value3631t10 === ''
      || value3631t6 === undefined
      || value3631t7 === undefined
      || value3631t8 === undefined
      || value3631t9 === undefined
      || value3631t10 === undefined
    ) {
      setResponseValue363('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3631t6, 10)) === false
      || Number.isInteger(parseInt(value3631t7, 10)) === false
      || Number.isInteger(parseInt(value3631t8, 10)) === false
      || Number.isInteger(parseInt(value3631t9, 10)) === false
      || Number.isInteger(parseInt(value3631t10, 10)) === false
    ) {
      setResponseValue362('Input should be an Integer');
    } else if (
      value3631t6 !== ''
      && value3631t7 !== ''
      && value3631t8 !== ''
      && value3631t9 !== ''
      && value3631t10 !== ''
    ) {
      setResponseValue363(
        parseInt(value3631t6, 10)
          + parseInt(value3631t7, 10)
          + parseInt(value3631t8, 10)
          + parseInt(value3631t9, 10)
          + parseInt(value3631t10, 10)
      );
    }
  }
  function onClickingViewResponse364() {
    if (
      value3641t6 === ''
      || value3641t7 === ''
      || value3641t8 === ''
      || value3641t9 === ''
      || value3641t10 === ''
      || value3641t16 === ''
      || value3641t17 === ''
      || value3641t18 === ''
      || value3641t19 === ''
      || value3641t20 === ''
      || value3641t6 === undefined
      || value3641t7 === undefined
      || value3641t8 === undefined
      || value3641t9 === undefined
      || value3641t10 === undefined
      || value3641t16 === undefined
      || value3641t17 === undefined
      || value3641t18 === undefined
      || value3641t19 === undefined
      || value3641t20 === undefined
    ) {
      setResponseValue364('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3641t6, 10)) === false
      || Number.isInteger(parseInt(value3641t7, 10)) === false
      || Number.isInteger(parseInt(value3641t8, 10)) === false
      || Number.isInteger(parseInt(value3641t9, 10)) === false
      || Number.isInteger(parseInt(value3641t10, 10)) === false
      || Number.isInteger(parseInt(value3641t16, 10)) === false
      || Number.isInteger(parseInt(value3641t17, 10)) === false
      || Number.isInteger(parseInt(value3641t18, 10)) === false
      || Number.isInteger(parseInt(value3641t19, 10)) === false
      || Number.isInteger(parseInt(value3641t20, 10)) === false
    ) {
      setResponseValue364('Input should be an Integer');
    } else if (
      value3641t6 !== ''
      && value3641t7 !== ''
      && value3641t8 !== ''
      && value3641t9 !== ''
      && value3641t10 !== ''
      && value3641t16 !== ''
      && value3641t17 !== ''
      && value3641t18 !== ''
      && value3641t19 !== ''
      && value3641t20 !== ''
    ) {
      setResponseValue364(
        ((value3641t6 / value3641t16) * 100
          + (value3641t7 / value3641t17) * 100
          + (value3641t8 / value3641t18) * 100
          + (value3641t9 / value3641t19) * 100
          + (value3641t10 / value3641t20) * 100)
          / 5
      );
    }
  }

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

  // sending data to db with API
  const financialYear="2021-2022";
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
    criteria36Ql: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
      uniqueKey1: 101,
        input361t1: value361t1,
     // response361: 
        
      },
    ],
    criteria36Qn: [
      {  
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
      uniqueKey1: 101,
        response362: responseValue362,
        response363: responseValue363,
        response364: responseValue364,
        criteria36status:"save"
      },
    ],
    yearTable3621: [
      {  
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
      uniqueKey1: 101, input3621y: value3621t1, input3621v: value3621t6 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
      uniqueKey1: 102, input3621y: value3621t2, input3621v: value3621t7 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
      uniqueKey1: 103, input3621y: value3621t3, input3621v: value3621t8 },
      {  
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
      uniqueKey1: 104, input3621y: value3621t4, input3621v: value3621t9 },
      {  
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
      uniqueKey1: 105, input3621y: value3621t5, input3621v: value3621t10 },
    ],

    yearTable3631: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 101, input3631y: value3631t1, input3631v: value3631t6 },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 102, input3631y: value3631t2, input3631v: value3631t7 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 103, input3631y: value3631t3, input3631v: value3631t8 },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 104, input3631y: value3631t4, input3631v: value3631t9 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 105, input3631y: value3631t5, input3631v: value3631t10 },
    ],

    yearTable3641: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 101, input3641y: value3641t1, input3641v: value3641t6 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 102, input3641y: value3641t2, input3641v: value3641t7 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 103, input3641y: value3641t3, input3641v: value3641t8 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 104, input3641y: value3641t4, input3641v: value3641t9 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 105, input3641y: value3641t5, input3641v: value3641t10 },
    ],

    yearTable36412: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 101, input36412y: value3641t11, input36412v: value3641t16 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 102, input36412y: value3641t12, input36412v: value3641t17 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 103, input36412y: value3641t13, input36412v: value3641t18 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 104, input36412y: value3641t14, input36412v: value3641t19 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 105, input36412y: value3641t15, input36412v: value3641t20 },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form36Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form36Data.append('criteria3Fieldinfo', jsonBlob(inputDataList));
    if (pathValue361f1 !== '') {
      form36Data.append('uploadfile3', value361f1, 'f361f1-' + value361f1.name);
    }
    if (pathValue3621f1 !== '') {
      form36Data.append(
        'uploadfile3',
        value3621f1,
        'f3621f1-' + value3621f1.name
      );
    }
    if (pathValue3621f2 !== '') {
      form36Data.append(
        'uploadfile3',
        value3621f2,
        'f3621f2-' + value3621f2.name
      );
    }
    if (pathValue3621f3 !== '') {
      form36Data.append(
        'uploadfile3',
        value3621f3,
        'f3621f3-' + value3621f3.name
      );
    }
    if (pathValue3631f1 !== '') {
      form36Data.append(
        'uploadfile3',
        value3631f1,
        'f3631f1-' + value3631f1.name
      );
    }
    if (pathValue3631f2 !== '') {
      form36Data.append(
        'uploadfile3',
        value3631f2,
        'f3631f2-' + value3631f2.name
      );
    }
    if (pathValue3631f3 !== '') {
      form36Data.append(
        'uploadfile3',
        value3631f3,
        'f3631f3-' + value3631f3.name
      );
    }
    if (pathValue3641f1 !== '') {
      form36Data.append(
        'uploadfile3',
        value3641f1,
        'f3641f1-' + value3641f1.name
      );
    }
    if (pathValue3641f2 !== '') {
      form36Data.append(
        'uploadfile3',
        value3641f2,
        'f3641f2-' + value3641f2.name
      );
    }
    if (pathValue3641f3 !== '') {
      form36Data.append(
        'uploadfile3',
        value3641f3,
        'f3641f3-' + value3641f3.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form36Data,
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
   function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
  return (
    <div className="c36-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c36x-colorIndicator-container">
        <p className="c36x-QlcolorIndicator-circle-style"></p>
        <span className="c36x-colorIndicator-span-style">Qualitative</span>
        <p className="c36x-QtcolorIndicator-circle-style"></p>
        <span className="c36x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c36x-weightage-heading-style">
            Key Indicator Weightage: 50
          </h1>
        </div>
      </div>

      {/* Key Indicator: 3.6.1 */}
      <div className="c36x-eachInputField-container">
        <div className="c36x-weightage-container">
          <h1 className="c36x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c36x-Ql-label-textarea-container">
            <div className="c36x-heading_Help-container">
              <h1 className="c36x-heading-style">
                <span className="c36x-span-style">3.6.1: </span>
                Extension activities are carried out in the neighbourhood
                community, sensitising students to social issues, for their
                holistic development, and impact thereof during the last five
                years
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp361Status(true);
                }}
                className="c36x-helpButton-style"
              >
                Help
              </button>
              <Help361
                isHelp311Clicked={help361Status}
                setIsHelp361Clicked={setHelp361Status}
              />
            </div>
            <label htmlFor="361-t1" className="c36x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue361t1(e.target.value);
                setResponseValue361(e.target.value);
              }}
              value={value361t1}
              rows={10}
              className="c36x-textarea-style"
              id="361-t1"
            ></textarea>
            {value361t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c36x-Ql-table-style">
            <tr>
              <th className="c36x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c36x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c36x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c36x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c36x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c36x-Ql-tableBorders-style"></td>
              <td className="c36x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue361f1(e.target.files[0]);
                    setPathValue361f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="361-f1"
                  type="file"
                  className="c36-fileButton-style"
                />
                {pathValue361f1 === '' ? null : (
                  <div className="c36-fileButtons-container">
                    <button className="c36-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue361f1("");
                      document.getElementById("361-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c36x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue361f2(e.target.files[0]);
                    setPathValue361f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="361-f2"
                  type="file"
                  className="c36-fileButton-style"
                />
                {pathValue361f2 === '' ? null : (
                  <div className="c36-fileButtons-container">
                    <button className="c36-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue361f2("");
                      document.getElementById("361-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c36x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
        {/* <div
          style={{
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-start',
            alignItems: 'center',
          }}
        >
          <label style={{ width: '15%', color: 'black', fontWeight: '500' }}>
            Grade Scale
          </label>
          <input
            style={{
              marginLeft: '2%',
              borderColor: 'grey',
              borderWidth: '1px',
              borderLeft: '0',
              borderRight: '0',
              borderTop: '0',
              width: '20%',
            }}
            type="text"
            onChange={(e) => {
              setGradeScale361(e.target.value);
              console.log(gradeScale361);
            }}
          />

          <div className="c36x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus361(true);
                qlMetricGradePointsCalculator(
                  gradeScale361,
                  setGradePoints361,
                  10
                );
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginLeft: '2%',
              }}
            >
              Weighted Grade Points
            </button>
            {gradePointsClickStatus361 ? (
              <p className="c36x-responseResult-style">{gradePoints361}</p>
            ) : null}
          </div>
        </div> */}
      </div>

      {/* Key Indicator: 3.6.2 */}
      <div className="c36x-eachInputField-container">
        <div className="c36x-weightage-container">
          <h1 className="c36x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c36x-container">
            <div className="c36x-heading_Help-container">
              <h1 className="c36x-heading-style">
                <span className="c36x-span-style">3.6.2: </span>
                Number of awards and recognition received by the Institution,
                its teachers and students for extension activities from
                Government / Government recognised bodies during last five years
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp362Status(true);
                }}
                className="c36x-helpButton-style"
              >
                Help
              </button>
              <Help362
                isHelp362Clicked={help362Status}
                setIsHelp362Clicked={setHelp362Status}
              />
            </div>
            <div className="c36x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus362(!responseButtonStatus362);
                  onClickingViewResponse362();
                }}
                className="c36x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus362 ? (
                <p className="c36x-responseResult-style">{responseValue362}</p>
              ) : null}
            </div>
          </div>
          <div className="c36xx-container">
            <h1 className="c36xx-Heading-style">
              <span className="c36xx-span-style">3.6.2.1: </span>
              Total number of awards and recognition received for extension
              activities from Government/ Government recognised bodies year-wise
              during the last five years
            </h1>

            <table className="c36x-Qt-table-style">
              <tr>
                <th className="c36x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3621t1(e.target.value)}
                      id="3621-t1"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t1}
                    />
                    {value3621t1 === '' ? (
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
                      onChange={(e) => setValue3621t2(e.target.value)}
                      id="3621-t2"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t2}
                    />
                    {value3621t2 === '' ? (
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
                      onChange={(e) => setValue3621t3(e.target.value)}
                      id="3621-t3"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t3}
                    />
                    {value3621t3 === '' ? (
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
                      onChange={(e) => setValue3621t4(e.target.value)}
                      id="3621-t4"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t4}
                    />
                    {value3621t4 === '' ? (
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
                      onChange={(e) => setValue3621t5(e.target.value)}
                      id="3621-t5"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t5}
                    />
                    {value3621t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c36x-horizontalTable-heading-style">
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
                      onChange={(e) => setValue3621t6(e.target.value)}
                      id="3621-t6"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t6}
                    />
                    {value3621t6 === '' ? (
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
                      onChange={(e) => setValue3621t7(e.target.value)}
                      id="3621-t7"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t7}
                    />
                    {value3621t7 === '' ? (
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
                      onChange={(e) => setValue3621t8(e.target.value)}
                      id="3621-t8"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t8}
                    />
                    {value3621t8 === '' ? (
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
                      onChange={(e) => setValue3621t9(e.target.value)}
                      id="3621-t9"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t9}
                    />
                    {value3621t9 === '' ? (
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
                      onChange={(e) => setValue3621t10(e.target.value)}
                      id="3621-t10"
                      className="c36x-input-style"
                      type="text"
                      value={value3621t10}
                    />
                    {value3621t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c36x-table-style">
              <tr>
                <th className="c36x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c36x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c36x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c36x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3621f1(e.target.files[0]);
                      setPathValue3621f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3621-f1"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3621f1 === '' ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3621f1("");
                      document.getElementById("3621-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Number of awards for extension activities in last 5 year
                </td>
                <td>
                  <a href={downloadFile("criteria3.6.2.xlsx")}>View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3621f2(e.target.files[0]);
                      setPathValue3621f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3621-f2"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3621f2 === '' ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3621f2("");
                      document.getElementById("3621-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>e-copy of the award letters</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3621f3(e.target.files[0]);
                      setPathValue3621f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3621-f3"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3621f3 === '' ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3621f3("");
                      document.getElementById("3621-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c36x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus362(true);
                setGradeScale362(numberMetricGradeCalculator(responseValue362));
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

            {gradeScaleClickStatus362 ? (
              <p className="c36x-responseResult-style">
                {numberMetricGradeCalculator(responseValue362)}
              </p>
            ) : null}
          </div>
          <div className="c36x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus362(true);
                setGradeScale362(numberMetricGradeCalculator(responseValue362));
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
            {gradePointsClickStatus362 ? (
              <p className="c36x-responseResult-style">
                {metricGradePointsCalculator(gradeScale362, 15)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>

      {/* Key Indicator: 3.6.3 */}
      <div className="c36x-eachInputField-container">
        <div className="c36x-weightage-container">
          <h1 className="c36x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c36x-container">
            <div className="c36x-heading_Help-container">
              <h1 className="c36x-heading-style">
                <span className="c36x-span-style">3.6.3: </span>
                Number of extension and outreach programs conducted by the
                institution through NSS/NCC, Government and Government
                recognised bodies during the last five years
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp363Status(true);
                }}
                className="c36x-helpButton-style"
              >
                Help
              </button>
              <Help363
                isHelp363Clicked={help363Status}
                setIsHelp363Clicked={setHelp363Status}
              />
            </div>
            <div className="c36x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus363(!responseButtonStatus363);
                  onClickingViewResponse363();
                }}
                className="c36x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus363 ? (
                <p className="c36x-responseResult-style">{responseValue363}</p>
              ) : null}
            </div>
          </div>
          <div className="c36xx-container">
            <h1 className="c36xx-Heading-style">
              <span className="c36xx-span-style">3.6.3.1: </span>
              Number of extension and outreach programs conducted by the
              institution through NSS/NCC, Government and Government recognised
              bodies during the last five years
            </h1>

            <table className="c36x-Qt-table-style">
              <tr>
                <th className="c36x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3631t1(e.target.value)}
                      id="3631-t1"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t1}
                    />
                    {value3631t1 === '' ? (
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
                      onChange={(e) => setValue3631t2(e.target.value)}
                      id="3631-t2"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t2}
                    />
                    {value3631t2 === '' ? (
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
                      onChange={(e) => setValue3631t3(e.target.value)}
                      id="3631-t3"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t3}
                    />
                    {value3631t3 === '' ? (
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
                      onChange={(e) => setValue3631t4(e.target.value)}
                      id="3631-t4"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t4}
                    />
                    {value3631t4 === '' ? (
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
                      onChange={(e) => setValue3631t5(e.target.value)}
                      id="3631-t5"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t5}
                    />
                    {value3631t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c36x-horizontalTable-heading-style">
                  Number of programs
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
                      onChange={(e) => setValue3631t6(e.target.value)}
                      id="3631-t6"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t6}
                    />
                    {value3631t6 === '' ? (
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
                      onChange={(e) => setValue3631t7(e.target.value)}
                      id="3631-t7"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t7}
                    />
                    {value3631t7 === '' ? (
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
                      onChange={(e) => setValue3631t8(e.target.value)}
                      id="3631-t8"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t8}
                    />
                    {value3631t8 === '' ? (
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
                      onChange={(e) => setValue3631t9(e.target.value)}
                      id="3631-t9"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t9}
                    />
                    {value3631t9 === '' ? (
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
                      onChange={(e) => setValue3631t10(e.target.value)}
                      id="3631-t10"
                      className="c36x-input-style"
                      type="text"
                      value={value3631t10}
                    />
                    {value3631t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c36x-table-style">
              <tr>
                <th className="c36x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c36x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c36x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c36x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Reports of the event organized</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3631f1(e.target.files[0]);
                      setPathValue3631f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3631-f1"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3631f1 === '' ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3631f1("");
                      document.getElementById("3631-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3631f2(e.target.files[0]);
                      setPathValue3631f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3631-f2"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3631f2 === '' ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3631f2("");
                      document.getElementById("3631-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Number of extension and outreach Programmes conducted with
                  industry, community etc for the last five years
                </td>
                <td>
                  <a href={downloadFile("criteria3.6.3.xlsx")}>View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3631f3(e.target.files[0]);
                      setPathValue3631f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3631-f3"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3631f3 === '' ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3631f3("");
                      document.getElementById("3631-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c36x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus363(true);
                setGradeScale363(numberMetricGradeCalculator(responseValue363));
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

            {gradeScaleClickStatus363 ? (
              <p className="c36x-responseResult-style">
                {numberMetricGradeCalculator(responseValue363)}
              </p>
            ) : null}
          </div>
          <div className="c36x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus363(true);
                setGradeScale363(numberMetricGradeCalculator(responseValue363));
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
            {gradePointsClickStatus363 ? (
              <p className="c36x-responseResult-style">
                {metricGradePointsCalculator(gradeScale363, 10)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>

      {/* Key Indicator: 3.6.4 */}
      <div className="c36x-eachInputField-container">
        <div className="c36x-weightage-container">
          <h1 className="c36x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c36x-container">
            <div className="c36x-heading_Help-container">
              <h1 className="c36x-heading-style">
                <span className="c36x-span-style">3.6.4: </span>
                Average percentage of students participating in extension
                activities listed at 3.6.3 above during the last five years
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp364Status(true);
                }}
                className="c36x-helpButton-style"
              >
                Help
              </button>
              <Help364
                isHelp364Clicked={help364Status}
                setIsHelp364Clicked={setHelp364Status}
              />
            </div>
            <div className="c36x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus364(!responseButtonStatus364);
                  onClickingViewResponse364;
                }}
                className="c36x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus364 ? (
                <p className="c36x-responseResult-style">{responseValue364}</p>
              ) : null}
            </div>
          </div>
          <div className="c36xx-container">
            <h1 className="c36xx-Heading-style">
              <span className="c36xx-span-style">3.6.4.1: </span>
              Total number of students participating in extension activities
              listed at 3.6.3 above year-wise during the last five years.
            </h1>

            <table className="c36x-Qt-table-style">
              <tr>
                <th className="c36x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3641t1(e.target.value)}
                      id="3641-t1"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t1}
                    />
                    {value3641t1 === '' ? (
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
                      onChange={(e) => setValue3641t2(e.target.value)}
                      id="3641-t2"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t2}
                    />
                    {value3641t2 === '' ? (
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
                      onChange={(e) => setValue3641t3(e.target.value)}
                      id="3641-t3"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t3}
                    />
                    {value3641t3 === '' ? (
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
                      onChange={(e) => setValue3641t4(e.target.value)}
                      id="3641-t4"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t4}
                    />
                    {value3641t4 === '' ? (
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
                      onChange={(e) => setValue3641t5(e.target.value)}
                      id="3641-t5"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t5}
                    />
                    {value3641t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c36x-horizontalTable-heading-style">
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
                      onChange={(e) => setValue3641t6(e.target.value)}
                      id="3641-t6"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t6}
                    />
                    {value3641t6 === '' ? (
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
                      onChange={(e) => setValue3641t7(e.target.value)}
                      id="3641-t7"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t7}
                    />
                    {value3641t7 === '' ? (
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
                      onChange={(e) => setValue3641t8(e.target.value)}
                      id="3641-t8"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t8}
                    />
                    {value3641t8 === '' ? (
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
                      onChange={(e) => setValue3641t9(e.target.value)}
                      id="3641-t9"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t9}
                    />
                    {value3641t9 === '' ? (
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
                      onChange={(e) => setValue3641t10(e.target.value)}
                      id="3641-t10"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t10}
                    />
                    {value3641t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c36x-Qt-table-style">
              <tr>
                <th className="c36x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3641t11(e.target.value)}
                      id="3641-t11"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t11}
                    />
                    {value3641t11 === '' ? (
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
                      onChange={(e) => setValue3641t12(e.target.value)}
                      id="3641-t12"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t12}
                    />
                    {value3641t12 === '' ? (
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
                      onChange={(e) => setValue3641t13(e.target.value)}
                      id="3641-t13"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t13}
                    />
                    {value3641t13 === '' ? (
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
                      onChange={(e) => setValue3641t14(e.target.value)}
                      id="3641-t14"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t14}
                    />
                    {value3641t14 === '' ? (
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
                      onChange={(e) => setValue3641t15(e.target.value)}
                      id="3641-t15"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t15}
                    />
                    {value3641t15 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c36x-horizontalTable-heading-style">
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
                      onChange={(e) => setValue3641t16(e.target.value)}
                      id="3641-t16"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t16}
                    />
                    {value3641t16 === '' ? (
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
                      onChange={(e) => setValue3641t17(e.target.value)}
                      id="3641-t17"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t17}
                    />
                    {value3641t17 === '' ? (
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
                      onChange={(e) => setValue3641t18(e.target.value)}
                      id="3641-t18"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t18}
                    />
                    {value3641t18 === '' ? (
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
                      onChange={(e) => setValue3641t19(e.target.value)}
                      id="3641-t19"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t19}
                    />
                    {value3641t19 === '' ? (
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
                      onChange={(e) => setValue3641t20(e.target.value)}
                      id="3641-t20"
                      className="c36x-input-style"
                      type="text"
                      value={value3641t20}
                    />
                    {value3641t20 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c36x-table-style">
              <tr>
                <th className="c36x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c36x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c36x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c36x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Reports of the event</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3641f1(e.target.files[0]);
                      setPathValue3641f1(e.target.value);
                    }}
                    id="3641-f1"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3641f1 === '' ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3641f1("");
                      document.getElementById("3641-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3641f2(e.target.files[0]);
                      setPathValue3641f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3641-f2"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3641f2 === '' ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3641f2("");
                      document.getElementById("3641-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Average percentage of students participating in extension
                  activities with Govt or NGO etc
                </td>
                <td>
                  <a href={downloadFile("criteria3.6.4.xlsx")}>View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3641f3(e.target.files[0]);
                      setPathValue3641f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3641-f3"
                    type="file"
                    className="c36-fileButton-style"
                  />
                  {pathValue3641f3 === '' ? null : (
                    <div className="c36-fileButtons-container">
                      <button className="c36-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3641f3("");
                      document.getElementById("3641-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c36x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c36x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus364(true);
                setGradeScale364(numberMetricGradeCalculator(responseValue364));
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

            {gradeScaleClickStatus364 ? (
              <p className="c36x-responseResult-style">
                {numberMetricGradeCalculator(responseValue364)}
              </p>
            ) : null}
          </div>
          <div className="c36x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus364(true);
                setGradeScale364(numberMetricGradeCalculator(responseValue364));
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
            {gradePointsClickStatus364 ? (
              <p className="c36x-responseResult-style">
                {metricGradePointsCalculator(gradeScale364, 15)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>

      <div className="c36x-button-container">
        <button onClick={onClickingSave} className="c36x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria36;
