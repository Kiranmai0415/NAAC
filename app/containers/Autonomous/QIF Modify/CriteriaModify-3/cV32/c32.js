import React, { useState, useEffect } from 'react';
import './c32-style.css';
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
function Help321(props) {
  return props.isHelp321Clicked ? (
    <div className="c32x-help-mainContainer">
      <div className="c32x-help-subContainer">
        <h1 className="c32x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c32x-help-para-style">
          Total Grants from Government and non-governmental agencies for
          research projects , endowments, Chairs in the institution during the
          last five years (INR in Lakhs)
        </p>
        <button
          className="c32x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp321Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help322(props) {
  return props.isHelp322Clicked ? (
    <div className="c32x-help-mainContainer">
      <div className="c32x-help-subContainer">
        <h1 className="c32x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c32x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>
          Number of teachers having research projects during the last five years
          <span style={{ fontWeight: 'bold' }}> /</span>Total number teachers{' '}
          <span style={{ fontWeight: 'bold' }}>) *</span>100
        </p>
        <button
          className="c32x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp322Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help323(props) {
  return props.isHelp323Clicked ? (
    <div className="c32x-help-mainContainer">
      <div className="c32x-help-subContainer">
        <h1 className="c32x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c32x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>Total number of teachers
          as research guides
          <span style={{ fontWeight: 'bold' }}> / </span>Total number of full
          time teachers
          <span style={{ fontWeight: 'bold' }}>) * </span>100
        </p>
        <button
          className="c32x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp323Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help324(props) {
  return props.isHelp324Clicked ? (
    <div className="c32x-help-mainContainer">
      <div className="c32x-help-subContainer">
        <h1 className="c32x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c32x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>
          Number of departments having Research projects funded by government
          and non-government agencies during the last five years
          <span style={{ fontWeight: 'bold' }}> / </span>Total number of
          departments
          <span style={{ fontWeight: 'bold' }}>) * </span>100
        </p>
        <p className="c24x-help-para-style">
          Percentage per year
          <span style={{ fontWeight: 'bold' }}>= (</span> ΣPercentage per year
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>
        <button
          className="c32x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp324Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// // Promotion of Research and Facilities
function Criteria32() {
  // getfile data with API
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
 //help buttom
  const [isOpen, setIsopen] = useState(false)
  const [isOpen2,setIsopen2] = useState(false)
  const [isOpen3,setIsopen3] = useState(false)
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
  const handleHelpOpen3 =(e)=>{
    e.preventDefault();
    setIsopen3(true)
  } 
  const handleHelpClose3 = (e)=>{
    setIsopen3(false)
  }
  //   // state variables
  const [value3211t1, setValue3211t1] = useState();
  const [value3211t2, setValue3211t2] = useState();
  const [value3211t3, setValue3211t3] = useState();
  const [value3211t4, setValue3211t4] = useState();
  const [value3211t5, setValue3211t5] = useState();
  const [value3211t6, setValue3211t6] = useState();
  const [value3211t7, setValue3211t7] = useState();
  const [value3211t8, setValue3211t8] = useState();
  const [value3211t9, setValue3211t9] = useState();
  const [value3211t10, setValue3211t10] = useState();
  const [value3221t11, setValue3221t11] = useState();
  const [value3211f1, setValue3211f1] = useState();
  const [pathValue3211f1, setPathValue3211f1] = useState('');
  const [value3211f2, setValue3211f2] = useState();
  const [pathValue3211f2, setPathValue3211f2] = useState('');
  const [responseButtonStatus321, setResponseButtonStatus321] = useState(false);
  const [responseValue321, setResponseValue321] = useState('');
  const [help321Status, setHelp321Status] = useState(false);

  const [value3221t1, setValue3221t1] = useState();
  const [value3221t2, setValue3221t2] = useState();
  const [value3221t3, setValue3221t3] = useState();
  const [value3221t4, setValue3221t4] = useState();
  const [value3221t5, setValue3221t5] = useState();
  const [value3221t6, setValue3221t6] = useState();
  const [value3221t7, setValue3221t7] = useState();
  const [value3221t8, setValue3221t8] = useState();
  const [value3221t9, setValue3221t9] = useState();
  const [value3221t10, setValue3221t10] = useState();

  const [value3221f1, setValue3221f1] = useState('');
  const [pathValue3221f1, setPathValue3221f1] = useState('');
  const [value3221f2, setValue3221f2] = useState('');
  const [pathValue3221f2, setPathValue3221f2] = useState('');

  const [responseButtonStatus322, setResponseButtonStatus322] = useState(false);
  const [responseValue322, setResponseValue322] = useState('');
  const [help322Status, setHelp322Status] = useState(false);

  const [value3231t1, setValue3231t1] = useState();
  const [value3231t2, setValue3231t2] = useState();
  const [value3231f1, setValue3231f1] = useState();
  const [pathValue3231f1, setPathValue3231f1] = useState('');
  const [value3231f2, setValue3231f2] = useState('');
  const [pathValue3231f2, setPathValue3231f2] = useState('');
  const [value3231f3, setValue3231f3] = useState();
  const [pathValue3231f3, setPathValue3231f3] = useState('');
  const [responseButtonStatus323, setResponseButtonStatus323] = useState(false);
  const [responseValue323, setResponseValue323] = useState('');
  const [help323Status, setHelp323Status] = useState(false);

  const [value3241t1, setValue3241t1] = useState();
  const [value3241t2, setValue3241t2] = useState();
  const [value3241t3, setValue3241t3] = useState();
  const [value3241t4, setValue3241t4] = useState();
  const [value3241t5, setValue3241t5] = useState();
  const [value3241t6, setValue3241t6] = useState();
  const [value3241t7, setValue3241t7] = useState();
  const [value3241t8, setValue3241t8] = useState();
  const [value3241t9, setValue3241t9] = useState();
  const [value3241t10, setValue3241t10] = useState();
  const [value3241t11, setValue3241t11] = useState();
  const [value3241t12, setValue3241t12] = useState();
  const [value3241t13, setValue3241t13] = useState();
  const [value3241t14, setValue3241t14] = useState();
  const [value3241t15, setValue3241t15] = useState();
  const [value3241t16, setValue3241t16] = useState();
  const [value3241t17, setValue3241t17] = useState();
  const [value3241t18, setValue3241t18] = useState();
  const [value3241t19, setValue3241t19] = useState();
  const [value3241t20, setValue3241t20] = useState();
  const [value3241f1, setValue3241f1] = useState('');
  const [pathValue3241f1, setPathValue3241f1] = useState('');
  const [value3241f2, setValue3241f2] = useState('');
  const [pathValue3241f2, setPathValue3241f2] = useState('');
  const [value3241f3, setValue3241f3] = useState('');
  const [pathValue3241f3, setPathValue3241f3] = useState('');
  const [value3241f4, setValue3241f4] = useState('');
  const [pathValue3241f4, setPathValue3241f4] = useState('');
  const [responseButtonStatus324, setResponseButtonStatus324] = useState(false);
  const [responseValue324, setResponseValue324] = useState('');
  const [help324Status, setHelp324Status] = useState(false);

  const [gradeScale321, setGradeScale321] = useState('');
  const [gradePoints321, setGradePoints321] = useState();
  const [gradeScaleClickStatus321, setGradeScaleClickStatus321] = useState(false);
  const [gradePointsClickStatus321, setGradePointsClickStatus321] = useState(false);

  const [gradeScale322, setGradeScale322] = useState('');
  const [gradePoints322, setGradePoints322] = useState();
  const [gradeScaleClickStatus322, setGradeScaleClickStatus322] = useState(false);
  const [gradePointsClickStatus322, setGradePointsClickStatus322] = useState(false);

  const [gradeScale323, setGradeScale323] = useState('');
  const [gradePoints323, setGradePoints323] = useState();
  const [gradeScaleClickStatus323, setGradeScaleClickStatus323] = useState(false);
  const [gradePointsClickStatus323, setGradePointsClickStatus323] = useState(false);

  const [gradeScale324, setGradeScale324] = useState('');
  const [gradePoints324, setGradePoints324] = useState();
  const [gradeScaleClickStatus324, setGradeScaleClickStatus324] = useState(false);
  const [gradePointsClickStatus324, setGradePointsClickStatus324] = useState(false);



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
    () => fetch(resources.APPLICATION_URL+'criteria3getallfiles?collegeId='+collegeId+'&financialYear='+ fYear +'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          setValue3231t1(data[0].criteria32Qn[0] ? data[0].criteria32Qn[0].input3231t1 : "");
          setValue3231t2(data[0].criteria32Qn[0] ? data[0].criteria32Qn[0].input3231t2 : "");
          setValue3221t11(data[0].criteria32Qn[0] ? data[0].criteria32Qn[0].input3221t11 : "");

          // setResponseValue111(data[0].criteria1FieldInfoQl[1].response111);
          // setResponseValue112(data[0].criteria1FieldInfoQn[2].response112);
          // setResponseValue113(data[0].criteria1FieldInfoQn[3].response113);

          setValue3211t1(data[0].yearTable3211[0] ? data[0].yearTable3211[0].input3211y : "");
          setValue3211t2(data[0].yearTable3211[1] ? data[0].yearTable3211[1].input3211y : "");
          setValue3211t3(data[0].yearTable3211[2] ? data[0].yearTable3211[2].input3211y : "");
          setValue3211t4(data[0].yearTable3211[3] ? data[0].yearTable3211[3].input3211y : "");
          setValue3211t5(data[0].yearTable3211[4] ? data[0].yearTable3211[4].input3211y : "");
          setValue3211t6(data[0].yearTable3211[0] ? data[0].yearTable3211[0].input3211v : "");
          setValue3211t7(data[0].yearTable3211[1] ? data[0].yearTable3211[1].input3211v : "");
          setValue3211t8(data[0].yearTable3211[2] ? data[0].yearTable3211[2].input3211v : "");
          setValue3211t9(data[0].yearTable3211[3] ? data[0].yearTable3211[3].input3211v : "");
          setValue3211t10(data[0].yearTable3211[4] ? data[0].yearTable3211[4].input3211v : "");
          setValue3221t1(data[0].yearTable3221[0] ? data[0].yearTable3221[0].input3221y : "");
          setValue3221t2(data[0].yearTable3221[1] ? data[0].yearTable3221[1].input3221y : "");
          setValue3221t3(data[0].yearTable3221[2] ? data[0].yearTable3221[2].input3221y : "");
          setValue3221t4(data[0].yearTable3221[3] ? data[0].yearTable3221[3].input3221y : "");
          setValue3221t5(data[0].yearTable3221[4] ? data[0].yearTable3221[4].input3221y : "");
          setValue3221t6(data[0].yearTable3221[0] ? data[0].yearTable3221[0].input3221v : "");
          setValue3221t7(data[0].yearTable3221[1] ? data[0].yearTable3221[1].input3221v : "");
          setValue3221t8(data[0].yearTable3221[2] ? data[0].yearTable3221[2].input3221v : "");
          setValue3221t9(data[0].yearTable3221[3] ? data[0].yearTable3221[3].input3221v : "");
          setValue3221t10(data[0].yearTable3221[4] ? data[0].yearTable3221[4].input3221v : "");
          setValue3241t1(data[0].yearTable3241[0] ? data[0].yearTable3241[0].input3241y : "");
          setValue3241t2(data[0].yearTable3241[1] ? data[0].yearTable3241[1].input3241y : "");
          setValue3241t3(data[0].yearTable3241[2] ? data[0].yearTable3241[2].input3241y : "");
          setValue3241t4(data[0].yearTable3241[3] ? data[0].yearTable3241[3].input3241y : "");
          setValue3241t5(data[0].yearTable3241[4] ? data[0].yearTable3241[4].input3241y : "");
          setValue3241t6(data[0].yearTable3241[0] ? data[0].yearTable3241[0].input3241v : "");
          setValue3241t7(data[0].yearTable3241[1] ? data[0].yearTable3241[1].input3241v : "");
          setValue3241t8(data[0].yearTable3241[2] ? data[0].yearTable3241[2].input3241v : "");
          setValue3241t9(data[0].yearTable3241[3] ? data[0].yearTable3241[3].input3241v : "");
          setValue3241t10(data[0].yearTable3241[4] ? data[0].yearTable3241[4].input3241v : "");
          setValue3241t11(data[0].yearTable3241[0] ? data[0].yearTable3241[0].input3241y : '');
          setValue3241t12(data[0].yearTable3241[1] ? data[0].yearTable3241[1].input3241y : "");
          setValue3241t13(data[0].yearTable3241[2] ? data[0].yearTable3241[2].input3241y : "");
          setValue3241t14(data[0].yearTable3241[3] ? data[0].yearTable3241[3].input3241y : "");
          setValue3241t15(data[0].yearTable3241[4] ? data[0].yearTable3241[4].input3241y : "");
          setValue3241t16(data[0].yearTable3241[0] ? data[0].yearTable3241[0].input3241v : "");
          setValue3241t17(data[0].yearTable3241[1] ? data[0].yearTable3241[1].input3241v : "");
          setValue3241t18(data[0].yearTable3241[2] ? data[0].yearTable3241[2].input3241v : "");
          setValue3241t19(data[0].yearTable3241[3] ? data[0].yearTable3241[3].input3241v : "");
          setValue3241t20(data[0].yearTable3241[4] ? data[0].yearTable3241[4].input3241v : "");
          // setValue3211f1(data[0].criteria3FileUpload[0].criteria3FileName);
          // setValue3211f2(data[0].criteria3FileUpload[0].criteria3FileName);
          // setValue3221f1(data[0].criteria3FileUpload[0].criteria3FileName);
          // setValue3221f2(data[0].criteria3FileUpload[0].criteria3FileName);
          // setValue3231f1(data[0].criteria3FileUpload[0].criteria3FileName);
          // setValue3231f2(data[0].criteria3FileUpload[0].criteria3FileName);
          // setValue3231f3(data[0].criteria3FileUpload[0].criteria3FileName);
          // setValue3241f1(data[0].criteria3FileUpload[0].criteria3FileName);
          // setValue3241f2(data[0].criteria3FileUpload[0].criteria3FileName);
          // setValue3241f2(data[0].criteria3FileUpload[0].criteria3FileName);
          // setValue3241f3(data[0].criteria3FileUpload[0].criteria3FileName);
          // setValue3241f4(data[0].criteria3FileUpload[0].criteria3FileName);
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ),
    []
  );
  // response button functionality
  function onClickingViewResponse321() {
    if (
      value3211t6 === ''
      || value3211t7 === ''
      || value3211t8 === ''
      || value3211t9 === ''
      || value3211t10 === ''
      || value3211t6 === undefined
      || value3211t7 === undefined
      || value3211t8 === undefined
      || value3211t9 === undefined
      || value3211t10 === undefined
    ) {
      setResponseValue321('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3211t6, 10)) === false
      || Number.isInteger(parseInt(value3211t7, 10)) === false
      || Number.isInteger(parseInt(value3211t8, 10)) === false
      || Number.isInteger(parseInt(value3211t9, 10)) === false
      || Number.isInteger(parseInt(value3211t10, 10)) === false
    ) {
      setResponseValue321('Input should be an Integer');
    } else if (
      value3211t6 !== ''
      && value3211t7 !== ''
      && value3211t8 !== ''
      && value3211t9 !== ''
      && value3211t10 !== ''
    ) {
      setResponseValue321(
        parseInt(value3211t6, 10)
          + parseInt(value3211t7, 10)
          + parseInt(value3211t8, 10)
          + parseInt(value3211t9, 10)
          + parseInt(value3211t10, 10)
      );
    }
  }
  function onClickingViewResponse322() {
    if (
      value3221t6 === ''
      || value3221t7 === ''
      || value3221t8 === ''
      || value3221t9 === ''
      || value3221t10 === ''
      || value3221t6 === undefined
      || value3221t7 === undefined
      || value3221t8 === undefined
      || value3221t9 === undefined
      || value3221t10 === undefined
      || value3221t11 === undefined
    ) {
      setResponseValue322('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3221t6, 10)) === false
      || Number.isInteger(parseInt(value3221t7, 10)) === false
      || Number.isInteger(parseInt(value3221t8, 10)) === false
      || Number.isInteger(parseInt(value3221t9, 10)) === false
      || Number.isInteger(parseInt(value3221t10, 10)) === false
      || Number.isInteger(parseInt(value3221t11, 10)) === false
    ) {
      setResponseValue322('Input should be an Integer');
    } else if (
      value3221t6 !== ''
      && value3221t7 !== ''
      && value3221t8 !== ''
      && value3221t9 !== ''
      && value3221t10 !== ''
      && value3221t11 !== ''
    ) {
      setResponseValue322(
        ((parseInt(value3221t6, 10)
          + parseInt(value3221t7, 10)
          + parseInt(value3221t8, 10)
          + parseInt(value3221t9, 10)
          + parseInt(value3221t10, 10))
          / parseInt(value3221t11, 10))
          * 100
      );
    }
  }
  function onClickingViewResponse323() {
    if (
      value3231t1 === ''
      || value3231t2 === ''
      || value3231t1 === undefined
      || value3231t2 === undefined
    ) {
      setResponseValue323('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3231t1, 10)) === false
      || Number.isInteger(parseInt(value3231t2, 10)) === false
    ) {
      setResponseValue323('Input should be an Integer');
    } else if (value3231t1 !== '' && value3231t2 !== '') {
      setResponseValue323(
        (parseInt(value3231t1, 10) / parseInt(value3231t2, 10)) * 100
      );
    }
    console.log(responseValue323);
  }
  function onClickingViewResponse324() {
    if (
      value3241t6 === ''
      || value3241t7 === ''
      || value3241t8 === ''
      || value3241t9 === ''
      || value3241t10 === ''
      || value3241t16 === ''
      || value3241t17 === ''
      || value3241t18 === ''
      || value3241t19 === ''
      || value3241t20 === ''
      || value3241t6 === undefined
      || value3241t7 === undefined
      || value3241t8 === undefined
      || value3241t9 === undefined
      || value3241t10 === undefined
      || value3241t16 === undefined
      || value3241t17 === undefined
      || value3241t18 === undefined
      || value3241t19 === undefined
      || value3241t20 === undefined
    ) {
      setResponseValue324('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3241t6, 10)) === false
      || Number.isInteger(parseInt(value3241t7, 10)) === false
      || Number.isInteger(parseInt(value3241t8, 10)) === false
      || Number.isInteger(parseInt(value3241t9, 10)) === false
      || Number.isInteger(parseInt(value3241t10, 10)) === false
      || Number.isInteger(parseInt(value3241t16, 10)) === false
      || Number.isInteger(parseInt(value3241t17, 10)) === false
      || Number.isInteger(parseInt(value3241t18, 10)) === false
      || Number.isInteger(parseInt(value3241t19, 10)) === false
      || Number.isInteger(parseInt(value3241t20, 10)) === false
    ) {
      setResponseValue324('Input should be an Integer');
    } else if (
      value3241t6 !== ''
      && value3241t7 !== ''
      && value3241t8 !== ''
      && value3241t9 !== ''
      && value3241t10 !== ''
      && value3241t16 !== ''
      && value3241t17 !== ''
      && value3241t18 !== ''
      && value3241t19 !== ''
      && value3241t20 !== ''
    ) {
      setResponseValue324(
        ((value3241t6 / value3241t16) * 100
          + (value3241t7 / value3241t17) * 100
          + (value3241t8 / value3241t18) * 100
          + (value3241t9 / value3241t19) * 100
          + (value3241t10 / value3241t20) * 100)
          / 5
      );
    }
  }



   // sending data to db with API
  
   const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
    criteria32Qn: [
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
        uniqueKey1: 1,
        input3221t11: value3221t11,
        input3231t1: value3231t1,
        input3231t2: value3231t2,

        response321: responseValue321,
        response322: responseValue322,
        response323: responseValue323,
        response324: responseValue324,
        criteria32status:"save"
      },
    ],
    yearTable3211: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType},
         uniqueKey1: 1, input3211y: value3211t1, input3211v: value3211t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 2, input3211y: value3211t2, input3211v: value3211t7
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType},
         uniqueKey1: 3, input3211y: value3211t3, input3211v: value3211t8
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 4, input3211y: value3211t4, input3211v: value3211t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType},
         uniqueKey1: 5, input3211y: value3211t5, input3211v: value3211t10
      },
    ],
    yearTable3221: [
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType},
         uniqueKey1: 1, input3221y: value3221t1, input3221v: value3221t6
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 2, input3221y: value3221t2, input3221v: value3221t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType},
         uniqueKey1: 3, input3221y: value3221t3, input3221v: value3221t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType},
         uniqueKey1: 4, input3221y: value3221t4, input3221v: value3221t9
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 5, input3221y: value3221t5, input3221v: value3221t10
      },
    ],
    yearTable3241: [
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
        
        uniqueKey1: 1, input3241y: value3241t1, input3241v: value3241t6
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType},
         uniqueKey1: 2, input3241y: value3241t2, input3241v: value3241t7
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 3, input3241y: value3241t3, input3241v: value3241t8
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 4, input3241y: value3241t4, input3241v: value3241t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 5, input3241y: value3241t5, input3241v: value3241t10
      },
    ],
    yearTable32412: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 1, input32412y: value3241t11, input32412v: value3241t16
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 2, input32412y: value3241t12, input32412v: value3241t17
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType},
         uniqueKey1: 3, input32412y: value3241t13, input32412v: value3241t18
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType},
         uniqueKey1: 4, input32412y: value3241t14, input32412v: value3241t19
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution:instituteType },
         uniqueKey1: 5, input32412y: value3241t15, input32412v: value3241t20
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form32Data = new FormData();

    form32Data.append('criteria3Fieldinfo', jsonBlob(inputDataList));
    if (pathValue3211f1 !== '') {
      form32Data.append(
        'uploadfile3',
        value3211f1,
        'f3211f1-' + value3211f1.name
      );
    }
    if (pathValue3211f2 !== '') {
      form32Data.append(
        'uploadfile3',
        value3211f2,
        'f3211f2-' + value3211f2.name
      );
    }
    if (pathValue3221f1 !== '') {
      form32Data.append(
        'uploadfile3',
        value3221f1,
        'f3221f1-' + value3221f1.name
      );
    }
    if (pathValue3221f2 !== '') {
      form32Data.append(
        'uploadfile3',
        value3221f2,
        'f3221f2-' + value3221f2.name
      );
    }
    if (pathValue3231f1 !== '') {
      form32Data.append(
        'uploadfile3',
        value3231f1,
        'f3231f1-' + value3231f1.name
      );
    }
    if (pathValue3231f2 !== '') {
      form32Data.append(
        'uploadfile3',
        value3231f2,
        'f3231f2-' + value3231f2.name
      );
    }
    if (pathValue3231f3 !== '') {
      form32Data.append(
        'uploadfile3',
        value3231f3,
        'f3231f3-' + value3231f3.name
      );
    }
    if (pathValue3241f1 !== '') {
      form32Data.append(
        'uploadfile3',
        value3241f1,
        'f3241f1-' + value3241f1.name
      );
    }
    if (pathValue3241f2 !== '') {
      form32Data.append(
        'uploadfile3',
        value3241f2,
        'f3241f2-' + value3241f2.name
      );
    }
    if (pathValue3241f3 !== '') {
      form32Data.append(
        'uploadfile3',
        value3241f3,
        'f3241f3-' + value3241f3.name
      );
    }
    if (pathValue3241f4 !== '') {
      form32Data.append(
        'uploadfile3',
        value3241f4,
        'f3241f4-' + value3241f4.name
      );
    }
    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form32Data,
    };
    fetch(
      'http://localhost:8080/api/v1/criteria3upload',
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

  //   // rendering DOM
  return (
    <div className="c32-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c32x-colorIndicator-container">
        <p className="c32x-QlcolorIndicator-circle-style"></p>
        <span className="c32x-colorIndicator-span-style">Qualitative</span>
        <p className="c32x-QtcolorIndicator-circle-style"></p>
        <span className="c32x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c32x-weightage-heading-style">
            Key Indicator Weightage: 10
          </h1>
        </div>
      </div>

      {/* Key Indicator: 3.2.1 */}
      <div className="c32x-eachInputField-container">
        <div className="c32x-weightage-container">
          <h1 className="c32x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c32x-container">
            <div className="c32x-heading_Help-container">
              <h1 className="c32x-heading-style">
                <span className="c32x-span-style">3.2.1: </span>
                Research funding received by the institution and its faculties through Government and non-government sources such as industry, corporate houses, international bodies for research project, endowment research chairs during the last five years
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
            <div className="c32x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus321(!responseButtonStatus321);
                  onClickingViewResponse321();
                }}
                className="c32x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus321 ? (
                <p className="c32x-responseResult-style">{responseValue321}</p>
              ) : null}
            </div>
          </div>
          <div className="c32xx-container">
            <h1 className="c32xx-Heading-style">
              <span className="c32xx-span-style">3.2.2.1: </span>
              Total Grants from Government and non-governmental agencies for
              research projects , endowments, Chairs in the institution during
              the last five years (INR in Lakhs)
            </h1>

            {/* <table className="c32x-Qt-table-style">
              <tr>
                <th className="c32x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3211t1(e.target.value)}
                      id="3211-t1"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t1}
                    />
                    {value3211t1 === '' ? (
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
                      onChange={(e) => setValue3211t2(e.target.value)}
                      id="3211-t2"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t2}
                    />
                    {value3211t2 === '' ? (
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
                      onChange={(e) => setValue3211t3(e.target.value)}
                      id="3211-t3"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t3}
                    />
                    {value3211t3 === '' ? (
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
                      onChange={(e) => setValue3211t4(e.target.value)}
                      id="3211-t4"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t4}
                    />
                    {value3211t4 === '' ? (
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
                      onChange={(e) => setValue3211t5(e.target.value)}
                      id="3211-t5"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t5}
                    />
                    {value3211t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c32x-horizontalTable-heading-style">
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
                      onChange={(e) => {
                        setValue3211t6(e.target.value);
                        onClickingViewResponse321();
                      }}
                      id="3211-t6"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t6}
                    />
                    {value3211t6 === '' ? (
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
                      onChange={(e) => {
                        setValue3211t7(e.target.value);
                        onClickingViewResponse321();
                      }}
                      id="3211-t7"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t7}
                    />
                    {value3211t7 === '' ? (
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
                      onChange={(e) => {
                        setValue3211t8(e.target.value);
                        onClickingViewResponse321();
                      }}
                      id="3211-t8"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t8}
                    />
                    {value3211t8 === '' ? (
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
                      onChange={(e) => {
                        setValue3211t9(e.target.value);
                        onClickingViewResponse321();
                      }}
                      id="3211-t9"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t9}
                    />
                    {value3211t9 === '' ? (
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
                      onChange={(e) => {
                        setValue3211t10(e.target.value);
                        onClickingViewResponse321();
                      }}
                      id="3211-t10"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t10}
                    />
                    {value3211t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> */}

            <table className="c32x-Qt-table-style">
              <tr>
                <th className="c32x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c32x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c32x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c32x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td className="c32x-Qt-tableBorders-style">
                  Any additional information
                </td>
                <td className="c32x-Qt-tableBorders-style"></td>
                <td className="c32x-Qt-tableBorders-style">
                  {/* <input
                    onChange={(e) => {
                      setValue3211f1(e.target.files[0]);
                      setPathValue3211f1(e.target.value);
                    }}
                    id="3211-f1"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3211f1 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3211f1("");
                      document.getElementById("3211-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3211f1)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                
                 
      <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="3211-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3211f1(e.target.files[0]);
                    setPathValue3211f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3211f1}
              {pathValue3211f1 === "" ? null : (
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
                      setPathValue3211f1("");
                      document.getElementById("3211-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td className="c32x-Qt-tableBorders-style">
                  e-copies of the grant award letters for research projects
                  sponsored by non-government
                </td>
                <td>
                <a href={downloadFile("au3.2.1.xlsx")} target="_blank">View Template</a>
                </td>
                {/* <td className="c32x-Qt-tableBorders-style">
                  <input
                    onChange={(e) => {
                      setValue3211f2(e.target.files[0]);
                      setPathValue3211f2(e.target.value);
                    }}
                    id="3211-f2"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3211f2 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3211f2("");
                      document.getElementById("3211-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3211f2)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                <td>
      <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="3211-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3211f2(e.target.files[0]);
                      setPathValue3211f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3211f2}
              {pathValue3211f2 === "" ? null : (
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
                      setPathValue3211f2("");
                      document.getElementById("3211-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c32x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus321(true);
                setGradeScale321(numberMetricGradeCalculator(responseValue321));
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

            {gradeScaleClickStatus321 ? (
              <p className="c32x-responseResult-style">
                {numberMetricGradeCalculator(responseValue321)}
              </p>
            ) : null}
          </div>
          <div className="c32x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus321(true);
                setGradeScale321(numberMetricGradeCalculator(responseValue321));
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
            {gradePointsClickStatus321 ? (
              <p className="c32x-responseResult-style">
                {metricGradePointsCalculator(gradeScale321, 2)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>

      {/* Key Indicator: 3.2.2 */}
      <div className="c32x-eachInputField-container">
        <div className="c32x-weightage-container">
          <h1 className="c32x-weightage-heading-style">Weightage: 2</h1>
        </div>
        <form>
          <div className="c32x-container">
            <div className="c32x-heading_Help-container">
              <h1 className="c32x-heading-style">
                <span className="c32x-span-style">3.2.2: </span>
                Percentage of teachers having research projects during the last five years
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
                ><h1>(Total number of teachers having research projects𝑑𝑢𝑟𝑖𝑛𝑔 𝑡ℎ𝑒 𝑙𝑎𝑠𝑡 𝑓𝑖𝑣𝑒 year)/(Total 𝑛umber of full time teachers during the la𝑠𝑡 five year) *100</h1></HelpButton>
            </div>
            <div className="c32x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus322(!responseButtonStatus322);
                  onClickingViewResponse322();
                }}
                className="c32x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus322 ? (
                <p className="c32x-responseResult-style">{responseValue322}</p>
              ) : null}
            </div>
          </div>
          <div className="c32xx-container">
            <h1 className="c32xx-Heading-style">
              <span className="c32xx-span-style">3.2.2.1: </span>
              Number of teachers having research projects during the last five
              years
            </h1>

            <table className="c32x-Qt-table-style">
              <tr>
                <th className="c32x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3221t1(e.target.value)}
                      id="3221-t1"
                      className="c32x-input-style"
                      type="text"
                      value={value3221t1}
                    />
                    {value3221t1 === '' ? (
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
                      onChange={(e) => setValue3221t2(e.target.value)}
                      id="3221-t2"
                      className="c32x-input-style"
                      type="text"
                      value={value3221t2}
                    />
                    {value3221t2 === '' ? (
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
                      onChange={(e) => setValue3221t3(e.target.value)}
                      id="3221-t3"
                      className="c32x-input-style"
                      type="text"
                      value={value3221t3}
                    />
                    {value3221t3 === '' ? (
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
                      onChange={(e) => setValue3221t4(e.target.value)}
                      id="3221-t4"
                      className="c32x-input-style"
                      type="text"
                      value={value3221t4}
                    />
                    {value3221t4 === '' ? (
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
                      onChange={(e) => setValue3221t5(e.target.value)}
                      id="3221-t5"
                      className="c32x-input-style"
                      type="text"
                      value={value3221t5}
                    />
                    {value3221t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c32x-horizontalTable-heading-style">
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
                      onChange={(e) => setValue3221t6(e.target.value)}
                      id="3221-t6"
                      className="c32x-input-style"
                      type="text"
                      value={value3221t6}
                    />
                    {value3221t6 === '' ? (
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
                      onChange={(e) => setValue3221t7(e.target.value)}
                      id="3221-t7"
                      className="c32x-input-style"
                      type="text"
                      value={value3221t7}
                    />
                    {value3221t7 === '' ? (
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
                      onChange={(e) => setValue3221t8(e.target.value)}
                      id="3221-t8"
                      className="c32x-input-style"
                      type="text"
                      value={value3221t8}
                    />
                    {value3221t8 === '' ? (
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
                      onChange={(e) => setValue3221t9(e.target.value)}
                      id="3221-t9"
                      className="c32x-input-style"
                      type="text"
                      value={value3221t9}
                    />
                    {value3221t9 === '' ? (
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
                      onChange={(e) => setValue3221t10(e.target.value)}
                      id="3221-t10"
                      className="c32x-input-style"
                      type="text"
                      value={value3221t10}
                    />
                    {value3221t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <h1 className="c32xx-Heading-style">
              Percentage of teachers having research projects
            
            <input
              onChange={(e) => setValue3221t11(e.target.value)}
              id="3221-t11"
              style={{width:"25%" , marginLeft: '14%' }}
              type="number"
            /> 
           </h1>
            <table className="c32x-table-style">
              <tr>
                <th className="c32x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c32x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c32x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c32x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>

              <tr>
                <td>Names of teachers having research projects</td>
                <td></td>
                {/* <td> */}
                  {/* <input
                    onChange={(e) => {
                      setValue3221f1(e.target.files[0]);
                      setPathValue3221f1(e.target.value);
                    }}
                    id="3221-f1"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3221f1 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3221f1("");
                      document.getElementById("3221-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3221f1)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                <td>
      <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3221f1(e.target.files[0]);
                    setPathValue3221f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3221f1}
              {pathValue3221f1 === "" ? null : (
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
                      setPathValue3221f1("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>

              <tr>
                <td>Link for additional information</td>
                <td>
                <a href={downloadFile("au3.2.2.xlsx")} target="_blank">View Template</a>
                </td>
                {/* <td>
                  <input
                    onChange={(e) => {
                      setValue3221f2(e.target.files[0]);
                      setPathValue3221f2(e.target.value);
                    }}
                    id="3221-f2"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3221f2 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3221f2("");
                      document.getElementById("3221-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3221f2)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                <td>
      <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3221f2(e.target.files[0]);
                      setPathValue3221f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3221f2}
              {pathValue3221f2 === "" ? null : (
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
                      setPathValue3221f2("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c32x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus322(true);
                setGradeScale322(
                  percentagesMetricGradeCalculator(responseValue322)
                );
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

            {gradeScaleClickStatus322 ? (
              <p className="c32x-responseResult-style">
                {percentagesMetricGradeCalculator(responseValue322)}
              </p>
            ) : null}
          </div>
          <div className="c32x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus322(true);
                setGradeScale322(
                  percentagesMetricGradeCalculator(responseValue322)
                );
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
            {gradePointsClickStatus322 ? (
              <p className="c32x-responseResult-style">
                {metricGradePointsCalculator(gradeScale322, 2)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>

      {/* Key Indicator: 3.2.3 */}
      <div className="c32x-eachInputField-container">
        <div className="c32x-weightage-container">
          <h1 className="c32x-weightage-heading-style">Weightage: 3</h1>
        </div>
        <form>
          <div className="c32x-container">
            <div className="c32x-heading_Help-container">
              <h1 className="c32x-heading-style">
                <span className="c32x-span-style">3.2.3: </span>
                Percentage of teachers recognised as research guides as in the latest completed academic year
              </h1>
              <button
                onClick={handleHelpOpen3}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen3}
                handleClose={handleHelpClose3}
                title='formula'
                ><h1>(Total number of teachers having research projects𝑑𝑢𝑟𝑖𝑛𝑔 𝑡ℎ𝑒 𝑙𝑎𝑠𝑡 𝑓𝑖𝑣𝑒 year)/(Total 𝑛umber of full time teachers during the la𝑠𝑡 five year) * 100</h1></HelpButton>
            </div>
            <div className="c32x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus323(!responseButtonStatus323);
                  onClickingViewResponse323();
                }}
                className="c32x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus323 ? (
                <p className="c32x-responseResult-style">{responseValue323}</p>
              ) : null}
            </div>
          </div>
          <div className="c32xx-container">
            <h1 className="c32xx-Heading-style">
              <span className="c32xx-span-style">3.2.3.1: </span>
             Number of teachers recognised as research guides as in the 
latest completed academic year: 
              <input
                onChange={(e) => {
                  setValue3231t1(e.target.value);
                  onClickingViewResponse323();
                }}
                id="3231-t1"
                style={{width:"25%" , marginLeft: '13%' }}
                type="number"
                value={value3231t1}
              />
            </h1>

            {/* <div className="c32xx-label-textInput-container">
              <label className="c32xx-Heading-style">
                Total number of full time teachers during the last five years
              </label>
              <input
                onChange={(e) => {
                  setValue3231t2(e.target.value);
                  onClickingViewResponse323();
                }}
                id="3231-t2"
                style={{width:"25%" , marginLeft: '12%' }}
                type="number"
                value={value3231t2}
              />
            </div> */}

            <table className="c32x-table-style">
              <tr>
                <th className="c32x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th clashelpsName="c32x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c32x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c32x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                  Upload copies of the letter of the university recognizing
                  faculty as research guides
                </td>
                <td>
                <a href={downloadFile("au3.2.3.xlsx")} target="_blank">View Template</a>
                </td>
                {/* <td>
                  <input
                    onChange={(e) => {
                      setValue3231f1(e.target.files[0]);
                      setPathValue3231f1(e.target.value);
                    }}
                    id="3231-f1"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3231f1 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3231f1("");
                      document.getElementById("3231-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3231f1)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                <td>
      <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3231f1(e.target.files[0]);
                    setPathValue3231f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3231f1}
              {pathValue3231f1 === "" ? null : (
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
                      setPathValue3231f1("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                {/* <td>
                  <input
                    onChange={(e) => {
                      setValue3231f2(e.target.files[0]);
                      setPathValue3231f2(e.target.value);
                    }}
                    id="3231-f2"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3231f2 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3231f2("");
                      document.getElementById("3231-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                   <a href={downloadFile(value3231f2)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> 
                </td> */}
                <td>
      <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3231f2(e.target.files[0]);
                    setPathValue3231f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3231f2}
              {pathValue3231f2 === "" ? null : (
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
                      setPathValue3231f2("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Link for additional information</td>
                <td></td>
                {/* <td> */}
                  {/* <input
                    onChange={(e) => {
                      setValue3231f3(e.target.files[0]);
                      setPathValue3231f3(e.target.value);
                    }}
                    id="3231-f3"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3231f3 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3231f3("");
                      document.getElementById("3231-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3231f3)} target="_blank">View File</a>
                </td> */}
                <td>
      <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3231f3(e.target.files[0]);
                    setPathValue3231f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3231f3}
              {pathValue3231f3 === "" ? null : (
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
                      setPathValue3231f3("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c32x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus323(true);
                setGradeScale323(
                  percentagesMetricGradeCalculator(responseValue323)
                );
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

            {gradeScaleClickStatus323 ? (
              <p className="c32x-responseResult-style">
                {percentagesMetricGradeCalculator(responseValue323)}
              </p>
            ) : null}
          </div>
          <div className="c32x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus323(true);
                setGradeScale323(
                  percentagesMetricGradeCalculator(responseValue323)
                );
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
            {gradePointsClickStatus323 ? (
              <p className="c32x-responseResult-style">
                {metricGradePointsCalculator(gradeScale323, 3)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>

      {/* Key Indicator: 3.2.4 */}
      {/* <div className="c32x-eachInputField-container">
        <div className="c32x-weightage-container">
          <h1 className="c32x-weightage-heading-style">Weightage: 3</h1>
        </div>
        <form>
          <div className="c32x-container">
            <div className="c32x-heading_Help-container">
              <h1 className="c32x-heading-style">
                <span className="c32x-span-style">3.2.4: </span>
                Average percentage of departments having Research projects
                funded by government and non-government agencies during the last
                five years
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp324Status(true);
                }}
                className="c32x-helpButton-style"
              >
                Help
              </button>
              <Help324
                isHelp324Clicked={help324Status}
                setIsHelp324Clicked={setHelp324Status}
              />
            </div>
            <div className="c32x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus324(!responseButtonStatus324);
                  onClickingViewResponse324();
                }}
                className="c32x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus324 ? (
                <p className="c32x-responseResult-style">{responseValue324}</p>
              ) : null}
            </div>
          </div>
          <div className="c32xx-container">
            <h1 className="c32xx-Heading-style">
              <span className="c32xx-span-style">3.2.4.1: </span>
              Number of departments having Research projects funded by
              government and non-government agencies during the last five years
            </h1>

            <table className="c32x-Qt-table-style">
              <tr>
                <th className="c32x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3241t1(e.target.value)}
                      id="3241-t1"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t1}
                    />
                    {value3241t1 === '' ? (
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
                      onChange={(e) => setValue3241t2(e.target.value)}
                      id="3241-t2"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t2}
                    />
                    {value3241t2 === '' ? (
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
                      onChange={(e) => setValue3241t3(e.target.value)}
                      id="3241-t3"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t3}
                    />
                    {value3241t3 === '' ? (
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
                      onChange={(e) => setValue3241t4(e.target.value)}
                      id="3241-t4"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t4}
                    />
                    {value3241t4 === '' ? (
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
                      onChange={(e) => setValue3241t5(e.target.value)}
                      id="3241-t5"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t5}
                    />
                    {value3241t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c32x-horizontalTable-heading-style">
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
                      onChange={(e) => setValue3241t6(e.target.value)}
                      id="3241-t6"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t6}
                    />
                    {value3241t6 === '' ? (
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
                      onChange={(e) => setValue3241t7(e.target.value)}
                      id="3241-t7"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t7}
                    />
                    {value3241t7 === '' ? (
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
                      onChange={(e) => setValue3241t8(e.target.value)}
                      id="3241-t8"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t8}
                    />
                    {value3241t8 === '' ? (
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
                      onChange={(e) => setValue3241t9(e.target.value)}
                      id="3241-t9"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t9}
                    />
                    {value3241t9 === '' ? (
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
                      onChange={(e) => setValue3241t10(e.target.value)}
                      id="3241-t10"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t10}
                    />
                    {value3241t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <table className="c32x-Qt-table-style">
              <tr>
                <th className="c32x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3241t11(e.target.value)}
                      id="3241-t11"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t11}
                    />
                    {value3241t11 === '' ? (
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
                      onChange={(e) => setValue3241t12(e.target.value)}
                      id="3241-t12"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t12}
                    />
                    {value3241t12 === '' ? (
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
                      onChange={(e) => setValue3241t13(e.target.value)}
                      id="3241-t13"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t13}
                    />
                    {value3241t13 === '' ? (
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
                      onChange={(e) => setValue3241t14(e.target.value)}
                      id="3241-t14"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t14}
                    />
                    {value3241t14 === '' ? (
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
                      onChange={(e) => setValue3241t15(e.target.value)}
                      id="3241-t15"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t15}
                    />
                    {value3241t15 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c32x-horizontalTable-heading-style">
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
                      onChange={(e) => setValue3241t16(e.target.value)}
                      id="3241-t16"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t16}
                    />
                    {value3241t16 === '' ? (
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
                      onChange={(e) => setValue3241t17(e.target.value)}
                      id="3241-t17"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t17}
                    />
                    {value3241t17 === '' ? (
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
                      onChange={(e) => setValue3241t18(e.target.value)}
                      id="3241-t18"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t18}
                    />
                    {value3241t18 === '' ? (
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
                      onChange={(e) => setValue3241t19(e.target.value)}
                      id="3241-t19"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t19}
                    />
                    {value3241t19 === '' ? (
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
                      onChange={(e) => setValue3241t20(e.target.value)}
                      id="3241-t20"
                      className="c32x-input-style"
                      type="text"
                      value={value3241t20}
                    />
                    {value3241t20 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c32x-table-style">
              <tr>
                <th className="c32x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c32x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c32x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c32x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>List of research projects and funding details </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3241f1(e.target.files[0]);
                      setPathValue3241f1(e.target.value);
                    }}
                    id="3241-f1"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3241f1 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3241f1("");
                      document.getElementById("3241-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3241f1)} target="_blank">View File</a>
                   <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div>
                </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3241f2(e.target.files[0]);
                      setPathValue3241f2(e.target.value);
                    }}
                    id="3241-f2"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3241f2 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3241f2("");
                      document.getElementById("3241-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3241f2)} target="_blank">View File</a>
                   <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div>
                </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Supporting document from Funding Agency</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3241f3(e.target.files[0]);
                      setPathValue3241f3(e.target.value);
                    }}
                    id="3241-f3"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3241f3 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3241f3("");
                      document.getElementById("3241-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3241f3)} target="_blank">View File</a>
                   <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div>
                </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Paste link to funding agency website</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3241f4(e.target.files[0]);
                      setPathValue3241f4(e.target.value);
                    }}
                    id="3241-f4"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3241f4 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3241f4("");
                      document.getElementById("3241-f4").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3241f4)} target="_blank">View File</a>
                   <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div>
                </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div> */}


      <div className="c32x-button-container">
        <button onClick={onClickingSave} className="c32x-button-style">
          Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria32;
