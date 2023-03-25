import React, { useState, useEffect } from 'react';
import './c32-style.css';
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
function Help321(props) {
  return props.isHelp321Clicked ? (
    <div className="c32x-help-mainContainer">
      <div className="c32x-help-subContainer">
        <h1 className="c32x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c32x-help-para-style">
          Data for the last five years:(As per Data Template)
          1.Name of the Project/ Endowments, Chairs<br />
          2.Name of the Principal Investigator<br />
          3.Department of Principal Investigator<br />
          4.Year of Award<br />
          5.Funds provided<br />
          6.Duration of the project<br />
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
          Datato be provided for the last five years:(As per Data Template)
          1.Name of the Project<br />
          2.Name of the Principal Investigator<br />
          3.Department of Principal Investigator<br />
          4.Year of Award<br />
          5.Funds provided<br />
          6.Duration of the project<br />
          7.Funding Agency<br />
          8.Total amount of funds received
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
          Number of research projects funded by government and non-government agencies during the last five years
          <span style={{ fontWeight: 'bold' }}> / </span>Number of full time teachers with research projectsworking in
          the institution during the last 5 years
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
  const [value3211f1, setValue3211f1] = useState();
  const [pathValue3211f1, setPathValue3211f1] = useState('');
  const [value3211f2, setValue3211f2] = useState();
  const [pathValue3211f2, setPathValue3211f2] = useState('');
  const [value3211f3, setValue3211f3] = useState();
  const [pathValue3211f3, setPathValue3211f3] = useState('');
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
  const [value3221f3, setValue3221f3] = useState('');
  const [pathValue3221f3, setPathValue3221f3] = useState('');

  const [responseButtonStatus322, setResponseButtonStatus322] = useState(false);
  const [responseValue322, setResponseValue322] = useState('');
  const [help322Status, setHelp322Status] = useState(false);

  const [value3231f1, setValue3231f1] = useState();
  const [pathValue3231f1, setPathValue3231f1] = useState('');
  const [value3231f2, setValue3231f2] = useState('');
  const [pathValue3231f2, setPathValue3231f2] = useState('');
  const [value3231f3, setValue3231f3] = useState();
  const [pathValue3231f3, setPathValue3231f3] = useState('');
  const [value3231f4, setValue3231f4] = useState();
  const [pathValue3231f4, setPathValue3231f4] = useState('');
  const [responseButtonStatus323, setResponseButtonStatus323] = useState(false);
  const [responseValue323, setResponseValue323] = useState('');
  const [help323Status, setHelp323Status] = useState(false);

  const [value3231t1, setValue3231t1] = useState();
  const [value3231t2, setValue3231t2] = useState();
  const [value3231t3, setValue3231t3] = useState();
  const [value3231t4, setValue3231t4] = useState();
  const [value3231t5, setValue3231t5] = useState();
  const [value3231t6, setValue3231t6] = useState();
  const [value3231t7, setValue3231t7] = useState();
  const [value3231t8, setValue3231t8] = useState();
  const [value3231t9, setValue3231t9] = useState();
  const [value3231t10, setValue3231t10] = useState();
  const [value3231t11, setValue3231t11] = useState();
  const [value3231t12, setValue3231t12] = useState();
  const [value3231t13, setValue3231t13] = useState();
  const [value3231t14, setValue3231t14] = useState();
  const [value3231t15, setValue3231t15] = useState();
  const [value3231t16, setValue3231t16] = useState();
  const [value3231t17, setValue3231t17] = useState();
  const [value3231t18, setValue3231t18] = useState();
  const [value3231t19, setValue3231t19] = useState();
  const [value3231t20, setValue3231t20] = useState();



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
    const filePath =resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }
  //get data api 
  const financialYear="2021-2022";

  useEffect(
    () => fetch(resources.APPLICATION_URL+'criteria3getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));
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

          setValue3231t1(data[0].universityYearTable3231[0] ? data[0].universityYearTable3231[0].input3231y : "");
          setValue3231t2(data[0].universityYearTable3231[1] ? data[0].universityYearTable3231[1].input3231y : "");
          setValue3231t3(data[0].universityYearTable3231[2] ? data[0].universityYearTable3231[2].input3231y : "");
          setValue3231t4(data[0].universityYearTable3231[3] ? data[0].universityYearTable3231[3].input3231y : "");
          setValue3231t5(data[0].universityYearTable3231[4] ? data[0].universityYearTable3231[4].input3231y : "");
          setValue3231t6(data[0].universityYearTable3231[0] ? data[0].universityYearTable3231[0].input3231v : "");
          setValue3231t7(data[0].universityYearTable3231[1] ? data[0].universityYearTable3231[1].input3231v : "");
          setValue3231t8(data[0].universityYearTable3231[2] ? data[0].universityYearTable3231[2].input3231v : "");
          setValue3231t9(data[0].universityYearTable3231[3] ? data[0].universityYearTable3231[3].input3231v : "");
          setValue3231t10(data[0].universityYearTable3231[4] ? data[0].universityYearTable3231[4].input3231v : "");


          setValue3231t11(data[0].universityYearTable3232[0] ? data[0].universityYearTable3232[0].input3232y : "");
          setValue3231t12(data[0].universityYearTable3232[1] ? data[0].universityYearTable3232[1].input3232y : "");
          setValue3231t13(data[0].universityYearTable3232[2] ? data[0].universityYearTable3232[2].input3232y : "");
          setValue3231t14(data[0].universityYearTable3232[3] ? data[0].universityYearTable3232[3].input3232y : "");
          setValue3231t15(data[0].universityYearTable3232[4] ? data[0].universityYearTable3232[4].input3232y : "");
          setValue3231t16(data[0].universityYearTable3232[0] ? data[0].universityYearTable3232[0].input3232v : "");
          setValue3231t17(data[0].universityYearTable3232[1] ? data[0].universityYearTable3232[1].input3232v : "");
          setValue3231t18(data[0].universityYearTable3232[2] ? data[0].universityYearTable3232[2].input3232v : "");
          setValue3231t19(data[0].universityYearTable3232[3] ? data[0].universityYearTable3232[3].input3232v : "");
          setValue3231t20(data[0].universityYearTable3232[4] ? data[0].universityYearTable3232[4].input3232v : "");

          setValue3211f1(data[0].criteria2FileUpload[0] ? data[0].criteria2FileUpload[0].criteria2FileName : "");
          setValue3211f2(data[0].criteria2FileUpload[1] ? data[0].criteria2FileUpload[1].criteria2FileName : "");
          setValue3211f3(data[0].criteria2FileUpload[2] ? data[0].criteria2FileUpload[2].criteria2FileName : "");
          setValue3211f1(data[0].criteria2FileUpload[3] ? data[0].criteria2FileUpload[3].criteria2FileName : "");
          setValue3211f2(data[0].criteria2FileUpload[4] ? data[0].criteria2FileUpload[4].criteria2FileName : "");
          setValue3211f3(data[0].criteria2FileUpload[5] ? data[0].criteria2FileUpload[5].criteria2FileName : "");
          setValue3231f1(data[0].criteria2FileUpload[6] ? data[0].criteria2FileUpload[6].criteria2FileName : "");
          setValue3231f2(data[0].criteria2FileUpload[7] ? data[0].criteria2FileUpload[7].criteria2FileName : "");
          setValue3231f3(data[0].criteria2FileUpload[8] ? data[0].criteria2FileUpload[8].criteria2FileName : "");
          setValue3231f4(data[0].criteria2FileUpload[9] ? data[0].criteria2FileUpload[9].criteria2FileName : "");
        })
        .catch((error) => {
          console.error("Error:", error);
          errorMessage("Got the Error Please try after sometime");
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
    ) {
      setResponseValue322('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3221t6, 10)) === false
      || Number.isInteger(parseInt(value3221t7, 10)) === false
      || Number.isInteger(parseInt(value3221t8, 10)) === false
      || Number.isInteger(parseInt(value3221t9, 10)) === false
      || Number.isInteger(parseInt(value3221t10, 10)) === false
    ) {
      setResponseValue322('Input should be an Integer');
    } else if (
      value3221t6 !== ''
      && value3221t7 !== ''
      && value3221t8 !== ''
      && value3221t9 !== ''
      && value3221t10 !== ''
    ) {
      setResponseValue322(
        ((parseInt(value3221t6, 10)
          + parseInt(value3221t7, 10)
          + parseInt(value3221t8, 10)
          + parseInt(value3221t9, 10)
          + parseInt(value3221t10, 10)))
      );
    }
  }

  function onClickingViewResponse323() {
    if (
      value3231t6 === ''
      || value3231t7 === ''
      || value3231t8 === ''
      || value3231t9 === ''
      || value3231t10 === ''
      || value3231t16 === ''
      || value3231t17 === ''
      || value3231t18 === ''
      || value3231t19 === ''
      || value3231t20 === ''
      || value3231t6 === undefined
      || value3231t7 === undefined
      || value3231t8 === undefined
      || value3231t9 === undefined
      || value3231t10 === undefined
      || value3231t16 === undefined
      || value3231t17 === undefined
      || value3231t18 === undefined
      || value3231t19 === undefined
      || value3231t20 === undefined
    ) {
      setResponseValue323('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3231t6, 10)) === false
      || Number.isInteger(parseInt(value3231t7, 10)) === false
      || Number.isInteger(parseInt(value3231t8, 10)) === false
      || Number.isInteger(parseInt(value3231t9, 10)) === false
      || Number.isInteger(parseInt(value3231t10, 10)) === false
      || Number.isInteger(parseInt(value3231t16, 10)) === false
      || Number.isInteger(parseInt(value3231t17, 10)) === false
      || Number.isInteger(parseInt(value3231t18, 10)) === false
      || Number.isInteger(parseInt(value3231t19, 10)) === false
      || Number.isInteger(parseInt(value3231t20, 10)) === false
    ) {
      setResponseValue323('Input should be an Integer');
    } else if (
      value3231t6 !== ''
      && value3231t7 !== ''
      && value3231t8 !== ''
      && value3231t9 !== ''
      && value3231t10 !== ''
      && value3231t16 !== ''
      && value3231t17 !== ''
      && value3231t18 !== ''
      && value3231t19 !== ''
      && value3231t20 !== ''
    ) {
      setResponseValue323(
        ((value3231t6)
          + (value3231t7)
          + (value3231t8)
          + (value3231t9)
          + (value3231t10))
        / ((value3231t16)
          + (value3231t17)
          + (value3231t18)
          + (value3231t19)
          + (value3231t20))
      );
    }
  }


  // sending data to db with API





  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
    criteria32Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
        response322: responseValue322,
        response323: responseValue323,
      },
    ],

    criteria32Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
        response321: responseValue321,
      },
    ],

      yearTable3211: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,input3211y: value3211t1, input3211v: value3211t6 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 202,input3211y: value3211t2, input3211v: value3211t7 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 203,input3211y: value3211t3, input3211v: value3211t8 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 204,input3211y: value3211t4, input3211v: value3211t9 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 205,input3211y: value3211t5, input3211v: value3211t10 },
      ],
      yearTable3221: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 201, input3221y: value3221t1, input3221v: value3221t6 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1:202,input3221y: value3221t2, input3221v: value3221t7 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 203,input3221y: value3221t3, input3221v: value3221t8 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 204,input3221y: value3221t4, input3221v: value3221t9 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 205,input3221y: value3221t5, input3221v: value3221t10 },
      ],
      universityYearTable3231: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 201, input3231y: value3231t1, input3231v: value3231t6 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 202,input3231y: value3231t2, input3231v: value3231t7 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 203, input3231y: value3231t3, input3231v: value3231t8 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 204, input3231y: value3231t4, input3231v: value3231t9 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 205, input3231y: value3231t5, input3231v: value3231t10 },
      ],
      universityYearTable3232: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 201, input3232y: value3231t11, input3232v: value3231t16 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 202, input3232y: value3231t12, input3232v: value3231t17 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 203, input3232y: value3231t13, input3232v: value3231t18 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 204, input3232y: value3231t14, input3232v: value3231t19 },
           {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
           uniqueKey1: 205, input3232y: value3231t15, input3232v: value3231t20 },
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
    if (pathValue3211f3 !== '') {
      form32Data.append(
        'uploadfile3',
        value3211f3,
        'f3211f3-' + value3211f3.name
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
    if (pathValue3221f3 !== '') {
      form32Data.append(
        'uploadfile3',
        value3221f3,
        'f3221f3-' + value3221f3.name
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
    if (pathValue3231f4 !== '') {
      form32Data.append(
        'uploadfile3',
        value3231f4,
        'f3231f4-' + value3231f4.name
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
                Research funding received by the institution and its faculties through Government and non-government sources such as industry, corporate houses, international bodies for research project, Endowment Research Chairs during the last five years (INR in Lakhs)
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
                title='Upload the specific document as per descriptio'
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
              <span className="c32xx-span-style">3.2.1.1: </span>
              Total Grants for Research funding received by the institution and its faculties through Government and non-government sources such as industry, corporate houses, international bodies for research project, Endowment Research Chairs during the last five years (INR in Lakhs)
              <input></input>
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
                Institutional data in the prescribed format (data template)
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
                      <button className="c32-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )} */}
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
                        setValue3211f1(e.target.files[0]);
                      setPathValue3211f1(e.target.value);
                        showFilePreview(e);
                      }}
                    />
                  </Button>
                  {pathValue3211f1}
                  {pathValue3211f1 === "" ? null : (
                    <div className="c32-fileButtons-container">
                      <button
                        className="c32-viewFileButton-style"
                        style={{ height: "37px", width: "70px" }}
                      >
                        <a target="_openfile" href={filePreviewSrc321f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c32-removeFileButton-style"
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
                List of Extramural funding received for research, Endowment Research Chairs received during the last five years along with the nature of award, the awarding agency and the amount.
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
                      <button className="c32-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )} */}
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
                    <div className="c32-fileButtons-container">
                      <button
                        className="c32-viewFileButton-style"
                        style={{ height: "37px", width: "70px" }}
                      >
                        <a target="_openfile" href={filePreviewSrc321f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c32-removeFileButton-style"
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
              <tr>
                <td className="c32x-Qt-tableBorders-style">
                  E-copies of the letters of award for research, endowments, Chairs sponsored by non- government sources
                </td>
                <td>
                  <a href="http://localhost:8080/api/v1/download/criteria3.2.1.xlsx">
                    View Template
                  </a>
                </td>
                 <td className="c32x-Qt-tableBorders-style">
                 {/*} <input
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
                      <button className="c32-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )} */}
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
                      setValue3211f2(e.target.files[0]);
                      setPathValue3211f2(e.target.value);
                      showFilePreview(e);
                    }}
                  />
                </Button>
                {pathValue3211f2}
                {pathValue3211f2 === "" ? null : (
                  <div className="c32-fileButtons-container">
                    <button
                      className="c32-viewFileButton-style"
                      style={{ height: "37px", width: "70px" }}
                    >
                      <a target="_openfile" href={filePreviewSrc321f2}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c32-removeFileButton-style"
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
            {/* <tr>
                <td className="c32x-Qt-tableBorders-style">
                Provide the List of project and grant details (Data Template as of 3.1.6)
                </td>
                <td>
                  <a href="http://localhost:8080/api/v1/download/criteria3.2.1.xlsx">
                    View Template
                  </a>
                </td>
                <td className="c32x-Qt-tableBorders-style">
                  <input
                    onChange={(e) => {
                      setValue3211f3(e.target.files[0]);
                      setPathValue3211f3(e.target.value);
                    }}
                    id="3211-f3"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3211f3 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                        View File
                      </button>
                      <button className="c32-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr> */}
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
      </div >

    {/* Key Indicator: 3.2.2 */ }
    < div className = "c32x-eachInputField-container" >
        <div className="c32x-weightage-container">
          <h1 className="c32x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c32x-container">
            <div className="c32x-heading_Help-container">
              <h1 className="c32x-heading-style">
                <span className="c32x-span-style">3.2.2: </span>
                Number of research projects per teacher funded by government, non-government , industry, corporate houses, international bodies during the last five years
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
                ><h1>(Total numberofresearchprojects funded by government and non-government ????????????????,?????????????????? h??????????,?????????????????????????? ???????????? during the last five years)/((2.2 Number of full time terachers (without repeat count) during the last five years))</h1></HelpButton>
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
              Number of research projects funded by government and non-government agencies during the last five years
            <input></input>
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
                <td>Institutional data in the prescribed format (data template merged with 3.2.1</td>
                <td></td>
                <td>
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
                      <button className="c32-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )} */}
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
                <div className="c32-fileButtons-container">
                  <button
                    className="c32-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc322f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c32-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3221f1("");
                      document.getElementById("3221-f1").value = "";
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
                <td>List of project titles with details of Principal Investigator, amount sanctioned and sanctioning agency etc.</td>
                <td>
                <a href={downloadFile("un3.2.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  {/* <input
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
                      <button className="c32-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )} */}
                     <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="3221-f2"
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
                <div className="c32-fileButtons-container">
                  <button
                    className="c32-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc322f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c32-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3221f2("");
                      document.getElementById("3221-f2").value = "";
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
                <td>E-copies of the grant award letters for research projects sponsored by government agencies. .</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3221f3(e.target.files[0]);
                      setPathValue3221f3(e.target.value);
                    }}
                    id="3221-f3"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3221f3 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                        View File
                      </button>
                      <button className="c32-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )} */}
   <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="3221-f3"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3221f3(e.target.files[0]);
                    setPathValue3221f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3221f3}
              {pathValue3221f3 === "" ? null : (
                <div className="c32-fileButtons-container">
                  <button
                    className="c32-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc321f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c32-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3221f3("");
                      document.getElementById("3221-f3").value = "";
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
      </div >

      {/* Key Indicator: 3.2.3 */}
      <div className="c32x-eachInputField-container">
        <div className="c32x-weightage-container">
          <h1 className="c32x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c32x-container">
            <div className="c32x-heading_Help-container">
              <h1 className="c32x-heading-style">
                <span className="c32x-span-style">3.2.3: </span>
                Number of research projects per teacher funded by government and
non-government agencies during the last five years
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
              Number of research projects funded by government and non-government agencies during the last five years
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
                      onChange={(e) => setValue3231t1(e.target.value)}
                      id="3231-t1"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t1}
                    />
                    {value3231t1 === '' ? (
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
                      onChange={(e) => setValue3231t2(e.target.value)}
                      id="3231-t2"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t2}
                    />
                    {value3231t2 === '' ? (
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
                      onChange={(e) => setValue3231t3(e.target.value)}
                      id="3231-t3"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t3}
                    />
                    {value3231t3 === '' ? (
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
                      onChange={(e) => setValue3231t4(e.target.value)}
                      id="3231-t4"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t4}
                    />
                    {value3231t4 === '' ? (
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
                      onChange={(e) => setValue3231t5(e.target.value)}
                      id="3231-t5"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t5}
                    />
                    {value3231t5 === '' ? (
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
                      onChange={(e) => setValue3231t6(e.target.value)}
                      id="3231-t6"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t6}
                    />
                    {value3231t6 === '' ? (
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
                      onChange={(e) => setValue3231t7(e.target.value)}
                      id="3231-t7"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t7}
                    />
                    {value3231t7 === '' ? (
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
                      onChange={(e) => setValue3231t8(e.target.value)}
                      id="3231-t8"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t8}
                    />
                    {value3231t8 === '' ? (
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
                      onChange={(e) => setValue3231t9(e.target.value)}
                      id="3231-t9"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t9}
                    />
                    {value3231t9 === '' ? (
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
                      onChange={(e) => setValue3231t10(e.target.value)}
                      id="3231-t10"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t10}
                    />
                    {value3231t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              </table>
              <h1 className="c32xx-Heading-style">
                <span className="c32xx-span-style">3.2.3.2: </span>
              Number of full time teachers with research projectsworking in the institution during the last 5 years
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
                      onChange={(e) => setValue3231t11(e.target.value)}
                      id="3231-t11"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t11}
                    />
                    {value3231t11 === '' ? (
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
                      onChange={(e) => setValue3231t12(e.target.value)}
                      id="3231-t12"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t12}
                    />
                    {value3231t12 === '' ? (
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
                      onChange={(e) => setValue3231t13(e.target.value)}
                      id="3231-t13"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t13}
                    />
                    {value3231t13 === '' ? (
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
                      onChange={(e) => setValue3231t14(e.target.value)}
                      id="3231-t14"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t14}
                    />
                    {value3231t14 === '' ? (
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
                      onChange={(e) => setValue3231t15(e.target.value)}
                      id="3231-t15"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t15}
                    />
                    {value3231t15 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c32x-horizontalTable-heading-style">
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
                      onChange={(e) => setValue3231t16(e.target.value)}
                      id="3231-t16"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t16}
                    />
                    {value3231t16 === '' ? (
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
                      onChange={(e) => setValue3231t17(e.target.value)}
                      id="3231-t17"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t17}
                    />
                    {value3231t17 === '' ? (
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
                      onChange={(e) => setValue3231t18(e.target.value)}
                      id="3231-t18"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t18}
                    />
                    {value3231t18 === '' ? (
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
                      onChange={(e) => setValue3231t19(e.target.value)}
                      id="3231-t19"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t19}
                    />
                    {value3231t19 === '' ? (
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
                      onChange={(e) => setValue3231t20(e.target.value)}
                      id="3231-t20"
                      className="c32x-input-style"
                      type="text"
                      value={value3231t20}
                    />
                    {value3231t20 === '' ? (
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
                <td>Provide the List of research projects and funding details (Data Templateas of 3.1.6)</td>
                <td></td>
                <td>
                  {/* <input
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
                      <button className="c32-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )} */}
                     <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="3221-f1"
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
                <div className="c32-fileButtons-container">
                  <button
                    className="c32-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc321f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c32-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3231f1("");
                      document.getElementById("3231-f1").value = "";
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
                <td>
                  {/* <input
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
                      <button className="c32-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )} */}
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
                <div className="c32-fileButtons-container">
                  <button
                    className="c32-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc323f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c32-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3231f2("");
                      document.getElementById("3231-f2").value = "";
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
                <td>Supporting document from the Funding Agency</td>
                <td></td>
                <td>
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
                      <button className="c32-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )} */}
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
                <div className="c32-fileButtons-container">
                  <button
                    className="c32-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc323f3}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c32-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3231f3("");
                      document.getElementById("3231-f3").value = "";
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
                <td>Provide the Link for the funding agency website</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3231f4(e.target.files[0]);
                      setPathValue3231f4(e.target.value);
                    }}
                    id="3231-f4"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3231f4 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                        View File
                      </button>
                      <button className="c32-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )} */}
                     <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="3231-f4"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3231f4(e.target.files[0]);
                      setPathValue3231f4(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3231f4}
              {pathValue3231f4 === "" ? null : (
                <div className="c32-fileButtons-container">
                  <button
                    className="c32-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc323f4}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c32-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3231f4("");
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
      </div >
    <div className="c32x-button-container">
      <button onClick={onClickingSave} className="c32x-button-style">
        Save
      </button>
    </div>
    </div >
  );
}

export default Criteria32;
