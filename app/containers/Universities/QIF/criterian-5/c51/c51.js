import React, { useEffect, useState } from 'react';
import './c51-style.css';
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
function Help511(props) {
  return props.isHelp511Clicked ? (
    <div className="c51x-help-mainContainer">
      <div className="c51x-help-subContainer">
        <h1 className="c51x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c51x-help-para-style">
          Percentage per year
          <span style={{ fontWeight: 'bold' }}>(</span>Number of Students
          benifited by scholarships and freeships by government
          <span style={{ fontWeight: 'bold' }}>) /</span>
          <span style={{ fontWeight: 'bold' }}>(</span> Number of students
          <span style={{ fontWeight: 'bold' }}>) /</span>*100
        </p>
        <p className="c51x-help-para-style">
          Average
          <span style={{ fontWeight: 'bold' }}>=(</span> ΣPercentage per year
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>
        <button
          className="c51x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp511Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help512(props) {
  return props.isHelp512Clicked ? (
    <div className="c51x-help-mainContainer">
      <div className="c51x-help-subContainer">
        <h1 className="c51x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c51x-help-para-style">
          Percentage per year<span style={{ fontWeight: 'bold' }}>=</span>
          <span style={{ fontWeight: 'bold' }}>(</span>Total number of students
          benifited by scholarships and freeships besides government
          <span style={{ fontWeight: 'bold' }}>) /</span>
          <span style={{ fontWeight: 'bold' }}>(</span> Number of students
          <span style={{ fontWeight: 'bold' }}>) </span>*100
        </p>
        <p className="c51x-help-para-style">
          Average percentage<span style={{ fontWeight: 'bold' }}>=</span>
          <span style={{ fontWeight: 'bold' }}>(</span> ΣPercentage per year
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>
        <button
          className="c51x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp512Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help513(props) {
  return props.isHelp513Clicked ? (
    <div className="c51x-help-mainContainer">
      <div className="c51x-help-subContainer">
        <h1 className="c51x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c51x-help-para-style">
          Average percentage
        </p>
        <button
          className="c51x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp513Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help514(props) {
  return props.isHelp514Clicked ? (
    <div className="c51x-help-mainContainer">
      <div className="c51x-help-subContainer">
        <h1 className="c51x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c51x-help-para-style">
        Data Requirement: <br/>
Upload the institutional grievance redressal policy document with
reference to prevention of sexual harassment (Internal Complaints
Committee) and anti-ragging committee, constitution of various
committees for addressing the issues, minutes of the meetings of the
committees, number of cases received and redressed.
        </p>
        <button
          className="c51x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp514Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria51() {

  // getfile data with API
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
 //help buttom
  const [isOpen, setIsopen] = useState(false)
  const [isOpen2,setIsopen2] = useState(false)
  const [isOpen3, setIsopen3] = useState(false)
  const [isOpen4,setIsopen4] = useState(false)
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

  const handleHelpOpen4 =(e)=>{
    e.preventDefault();
    setIsopen4(true)
  } 
  const handleHelpClose4= (e)=>{
    setIsopen4(false)
  }


  // state variables

  const [value5111t1, setValue5111t1] = useState();
  const [value5111t2, setValue5111t2] = useState();
  const [value5111t3, setValue5111t3] = useState();
  const [value5111t4, setValue5111t4] = useState();
  const [value5111t5, setValue5111t5] = useState();
  const [value5111t6, setValue5111t6] = useState();
  const [value5111t7, setValue5111t7] = useState();
  const [value5111t8, setValue5111t8] = useState();
  const [value5111t9, setValue5111t9] = useState();
  
  const [value5111t10, setValue5111t10] = useState();
  const [value5111t11, setValue5111t11] = useState();
  const [value5111t12, setValue5111t12] = useState();
  const [value5111t13, setValue5111t13] = useState();
  const [value5111t14, setValue5111t14] = useState();
  const [value5111t15, setValue5111t15] = useState();
  const [value5111t16, setValue5111t16] = useState();
  const [value5111t17, setValue5111t17] = useState();
  const [value5111t18, setValue5111t18] = useState();
  const [value5111t19, setValue5111t19] = useState();
  const [value5111t20, setValue5111t20] = useState();

  const [value5121t1, setValue5121t1] = useState();
  const [value5121t2, setValue5121t2] = useState();
  const [value5121t3, setValue5121t3] = useState();
  const [value5121t4, setValue5121t4] = useState();
  const [value5121t5, setValue5121t5] = useState();
  const [value5121t6, setValue5121t6] = useState();
  const [value5121t7, setValue5121t7] = useState();
  const [value5121t8, setValue5121t8] = useState();
  const [value5121t9, setValue5121t9] = useState();
  const [value5121t10, setValue5121t10] = useState();
  const [value5121t11, setValue5121t11] = useState();
  const [value5121t12, setValue5121t12] = useState();
  const [value5121t13, setValue5121t13] = useState();
  const [value5121t14, setValue5121t14] = useState();
  const [value5121t15, setValue5121t15] = useState();
  const [value5121t16, setValue5121t16] = useState();
  const [value5121t17, setValue5121t17] = useState();
  const [value5121t18, setValue5121t18] = useState();
  const [value5121t19, setValue5121t19] = useState();
  const [value5121t20, setValue5121t20] = useState();

  const [value5121f1, setValue5121f1] = useState([]);
  const [value5121f2, setValue5121f2] = useState([]);
  const [pathValue5121f1, setPathValue5121f1] = useState('');
  const [pathValue5121f2, setPathValue5121f2] = useState('');

  const [value513t1, setValue513t1] = useState();
  const [value513f1, setValue513f1] = useState([]);
  const [value513f2, setValue513f2] = useState([]);
  const [value513f3, setValue513f3] = useState([]);
  const [pathValue513f1, setPathValue513f1] = useState('');
  const [pathValue513f2, setPathValue513f2] = useState('');
  const [pathValue513f3, setPathValue513f3] = useState('');

  const [value5141t1, setValue5141t1] = useState();
  const [value5141t2, setValue5141t2] = useState();
  const [value5141t3, setValue5141t3] = useState();
  const [value5141t4, setValue5141t4] = useState();
  const [value5141t5, setValue5141t5] = useState();
  const [value5141t6, setValue5141t6] = useState();
  const [value5141t7, setValue5141t7] = useState();
  const [value5141t8, setValue5141t8] = useState();
  const [value5141t9, setValue5141t9] = useState();
  const [value5141t10, setValue5141t10] = useState();
  const [value5141t11, setValue5141t11] = useState();
  const [value5141t12, setValue5141t12] = useState();
  const [value5141t13, setValue5141t13] = useState();
  const [value5141t14, setValue5141t14] = useState();
  const [value5141t15, setValue5141t15] = useState();
  const [value5141t16, setValue5141t16] = useState();
  const [value5141t17, setValue5141t17] = useState();
  const [value5141t18, setValue5141t18] = useState();
  const [value5141t19, setValue5141t19] = useState();
  const [value5141t20, setValue5141t20] = useState();

  const [pathValue5111f1, setPathValue5111f1] = useState('');
  const [pathValue5111f2, setPathValue5111f2] = useState('');
  const [pathValue5111f3, setPathValue5111f3] = useState('');
  const [pathValue5111f4, setPathValue5111f4] = useState('');
  const [value5111f1, setValue5111f1] = useState([]);
  const [value5111f2, setValue5111f2] = useState([]);
  const [value5111f3, setValue5111f3] = useState([]);
  const [value5111f4, setValue5111f4] = useState([]);

  const [pathValue5141f1, setPathValue5141f1] = useState('');
  const [pathValue5141f2, setPathValue5141f2] = useState('');
  const [pathValue5141f3, setPathValue5141f3] = useState('');
  const [pathValue5141f4, setPathValue5141f4] = useState('');

  const [pathValue514f1, setPathValue514f1] = useState('');
  const [pathValue514f2, setPathValue514f2] = useState('');
  const [pathValue514f3, setPathValue514f3] = useState('');
  const [value514f1, setValue514f1] = useState([]);
  const [value514f2, setValue514f2] = useState([]);
  const [value514f3, setValue514f3] = useState([]);
  const [value514t1, setValue514t1] = useState();

  const [responseButtonStatus511, setResponseButtonStatus511] = useState(false);
  const [responseButtonStatus512, setResponseButtonStatus512] = useState(false);
  const [responseButtonStatus513, setResponseButtonStatus513] = useState(false);
  const [responseButtonStatus514, setResponseButtonStatus514] = useState(false);

  const [responseValue511, setResponseValue511] = useState('');
  const [responseValue512, setResponseValue512] = useState('');
  const [responseValue513, setResponseValue513] = useState('');
  const [responseValue514, setResponseValue514] = useState('');

  const [help511Status, setHelp511Status] = useState(false);
  const [help512Status, setHelp512Status] = useState(false);
  const [help513Status, setHelp513Status] = useState(false);
  const [help514Status, setHelp514Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');
  const [viewResponseValue511, setViewResponseValue511] = useState('');

  const [value513t2, setValue513t2] = useState();
  const [value513t3, setValue513t3] = useState();
  const [value513t4, setValue513t4] = useState();
  const [value513t5, setValue513t5] = useState();

  const [viewResponseValue513, setViewResponseValue513] = useState();

  useEffect(()=>
  fetch('https://localhost:8080/api/v1/viewResponseValue511?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
    (response)=> response.json()
    .then((data)=>{
      console.log("response value is from backend==>" +JSON.stringify(data));
      setViewResponseValue511(data);

    })
    .catch((error)=>{
      console.log(error('Error:',error))
    })
  ),
  []);
  // response button functionality
  function onClickingViewResponse511() {
    if (
      value5111t6 === ''
      || value5111t7 === ''
      || value5111t8 === ''
      || value5111t9 === ''
      || value5111t10 === ''
      ||viewResponseValue511 === ''
      // || value5111t16 === ''
      // || value5111t17 === ''
      // || value5111t18 === ''
      // || value5111t19 === ''
      // || value5111t20 === ''
      || value5111t6 === undefined
      || value5111t7 === undefined
      || value5111t8 === undefined
      || value5111t9 === undefined
      || value5111t10 === undefined
      || viewResponseValue511 === undefined
      // || value5111t17 === undefined
      // || value5111t18 === undefined
      // || value5111t19 === undefined
      // || value5111t20 === undefined
    ) {
      setResponseButtonStatus511('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value5111t6, 10)) === false
      || Number.isInteger(parseInt(value5111t7, 10)) === false
      || Number.isInteger(parseInt(value5111t8, 10)) === false
      || Number.isInteger(parseInt(value5111t9, 10)) === false
      || Number.isInteger(parseInt(value5111t10, 10)) === false
      || Number.isInteger(parseInt(viewResponseValue511, 10)) === false
      // || Number.isInteger(parseInt(value5111t17, 10)) === false
      // || Number.isInteger(parseInt(value5111t18, 10)) === false
      // || Number.isInteger(parseInt(value5111t19, 10)) === false
      // || Number.isInteger(parseInt(value5111t20, 10)) === false
    ) {
      setResponseButtonStatus511('Input should be an Integer');
    } else if (
      value5111t6 !== ''
      && value5111t7 !== ''
      && value5111t8 !== ''
      && value5111t9 !== ''
      && value5111t10 !== ''
      && viewResponseValue511 !== ''
      // && value5111t17 !== ''
      // && value5111t18 !== ''
      // && value5111t19 !== ''
      // && value5111t20 !== ''
    ) {
      setResponseButtonStatus511(
      ( ( parseInt(value5111t6, 10)
          + parseInt(value5111t7, 10)
          + parseInt(value5111t8, 10)
          + parseInt(value5111t9, 10)
          + parseInt(value5111t10, 10))/viewResponseValue511)*100
        
         
      );
    }
  }

  function onClickingViewResponse512() {
    if (
      value5121t6 === ''
      || value5121t7 === ''
      || value5121t8 === ''
      || value5121t9 === ''
      || value5121t10 === ''
      || value5121t16 === ''
      || value5121t17 === ''
      || value5121t18 === ''
      || value5121t19 === ''
      || value5121t20 === ''
      || value5121t6 === undefined
      || value5121t7 === undefined
      || value5121t8 === undefined
      || value5121t9 === undefined
      || value5121t10 === undefined
      || value5121t16 === undefined
      || value5121t17 === undefined
      || value5121t18 === undefined
      || value5121t19 === undefined
      || value5121t20 === undefined
    ) {
      setResponseValue512('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value5121t6, 10)) === false
      || Number.isInteger(parseInt(value5121t7, 10)) === false
      || Number.isInteger(parseInt(value5121t8, 10)) === false
      || Number.isInteger(parseInt(value5121t9, 10)) === false
      || Number.isInteger(parseInt(value5121t10, 10)) === false
      || Number.isInteger(parseInt(value5121t16, 10)) === false
      || Number.isInteger(parseInt(value5121t17, 10)) === false
      || Number.isInteger(parseInt(value5121t18, 10)) === false
      || Number.isInteger(parseInt(value5121t19, 10)) === false
      || Number.isInteger(parseInt(value5121t20, 10)) === false
    ) {
      setResponseValue512('Input should be an Integer');
    } else if (
      value5121t6 !== ''
      && value5121t7 !== ''
      && value5121t8 !== ''
      && value5121t9 !== ''
      && value5121t10 !== ''
      && value5121t16 !== ''
      && value5121t17 !== ''
      && value5121t18 !== ''
      && value5121t19 !== ''
      && value5121t20 !== ''
    ) {
      setResponseValue512(
        ((value5121t6 / value5121t16) * 100
            + (value5121t7 / value5121t17) * 100
            + (value5121t8 / value5121t18) * 100
            + (value5121t9 / value5121t19) * 100
            + (value5121t10 / value5121t20) * 100)
            / 5
      );
    }
  }

  useEffect(()=>
  fetch('https://localhost:8080/api/v1/viewResponseValue513?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
    (response)=> response.json()
    .then((data)=>{
      console.log("response value is from backend==>" +JSON.stringify(data));
      setViewResponseValue513(data);

    })
    .catch((error)=>{
      console.log(error('Error:',error))
    })
  ),
  []);
  function onClickingViewResponse513() {
    console.log("responseValue263")
    if (value513t1 === "" ||  value513t2 === "" || value513t3 === "" || value513t24 === ""  ||value513t5 === "")  {
      setResponseValue513("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value513t1, 10)) === false ||
      Number.isInteger(parseInt(value513t2, 10)) === false ||
      Number.isInteger(parseInt(value513t3, 10)) === false ||
      Number.isInteger(parseInt(value513t4, 10)) === false ||
      Number.isInteger(parseInt(value513t5, 10)) === false 
    ) {
      setResponseValue513("Input should be an Integer");
    } else if (value513t1 !== ""
     && value513t2 !== ""
     && value513t3 !== ""
     && value513t4 !== ""
     && value513t5 !== ""
     ) {
      setResponseValue513(
        ((parseInt(value513t1, 10)+
        parseInt(value513t2, 10)+
        parseInt(value513t3, 10)+
        parseInt(value513t4, 10)+
        parseInt(value513t5, 10))
         / parseInt(viewResponseValue513, 10)) * 100
      );
    }
  }

  function onClickingViewResponse514() {
    if (value514t1 === '' || value514t1 === undefined || value514t1 === null) {
      setResponseValue514('Please select any option');
    } else {
      setResponseValue514(value514t1);
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
    criteria51Qn: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
      input513t1: value513t1,
      input514t1: value514t1,
      response511: responseValue511,
      response512: responseValue512,
      response514: responseValue514,
      response513: responseValue513,
      criteria51status:"save"
      },
    ],
   
      yearTable5111: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,input5111y: value5111t11, input5111v: value5111t16 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202,input5111y: value5111t12, input5111v: value5111t17 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 203, input5111y: value5111t13, input5111v: value5111t18 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 204, input5111y: value5111t14, input5111v: value5111t19 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 205,input5111y: value5111t15, input5111v: value5111t20 },
      ],

      // yearTable51112: [
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 201, input51112y: value5111t11, input51112v: value5111t16 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 202,input51112y: value5111t12, input51112v: value5111t17 },
      //    {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //    uniqueKey1: 203,input51112y: value5111t13, input51112v: value5111t18 },
      //    {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //    uniqueKey1: 204, input51112y: value5111t14, input51112v: value5111t19 },
      //    {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //    uniqueKey1: 205, input51112y: value5111t15, input51112v: value5111t20 },
      // // ],
      // yearTable5121: [
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 201, input5121y: value5121t1, input5121v: value5121t6 },
      //    {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //    uniqueKey1: 202,input5121y: value5121t2, input5121v: value5121t7 },
      //    {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //    uniqueKey1: 203, input5121y: value5121t3, input5121v: value5121t8 },
      //    {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //    uniqueKey1: 204, input5121y: value5121t4, input5121v: value5121t9 },
      //    {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //    uniqueKey1: 205, input5121y: value5121t5, input5121v: value5121t10 },
      // ],
      // yearTable51212: [
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 201, input51212y: value5121t1, input51212v: value5121t6 },
      //    {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //    uniqueKey1: 202, input51212y: value5121t2, input51212v: value5121t7 },
      //    {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //    uniqueKey1: 203, input51212y: value5121t3, input51212v: value5121t8 },
      //    {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //    uniqueKey1: 204, input51212y: value5121t4, input51212v: value5121t9 },
      //    {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //    uniqueKey1: 205, input51212y: value5121t5, input51212v: value5121t10 },
      // ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form51Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form51Data.append('criteria5Fieldinfo', jsonBlob(inputDataList));

    if (pathValue513f1 !== '') {
      form51Data.append('uploadfile5', value513f1, 'f513f1-' + value513f1.name);
    }
    if (pathValue513f2 !== '') {
      form51Data.append('uploadfile5', value513f2, 'f513f2-' + value513f2.name);
    }
    if (pathValue513f3 !== '') {
      form51Data.append('uploadfile5', value513f3, 'f513f3-' + value513f3.name);
    }
    if (pathValue5111f1 !== '') {
      form51Data.append(
        'uploadfile5',
        value5111f1,
        'f5111f1-' + value5111f1.name
      );
    }
    if (pathValue5111f2 !== '') {
      form51Data.append(
        'uploadfile5',
        value5111f2,
        'f5111f2-' + value5111f2.name
      );
    }
    if (pathValue5111f3 !== '') {
      form51Data.append(
        'uploadfile5',
        value5111f3,
        'f5111f3-' + value5111f3.name
      );
    }
    if (pathValue5111f4 !== '') {
      form51Data.append(
        'uploadfile5',
        value5111f4,
        'f5111f4-' + value5111f4.name
      );
    }
    if (pathValue5121f1 !== '') {
      form51Data.append(
        'uploadfile5',
        value5121f1,
        'f5121f1-' + value5121f1.name
      );
    }
    if (pathValue5121f2 !== '') {
      form51Data.append(
        'uploadfile5',
        value5121f2,
        'f5121f2-' + value5121f2.name
      );
    }
    if (pathValue514f1 !== '') {
      form51Data.append(
        'uploadfile5',
        value514f1,
        'f514f1-' + value514f1.name
      );
    }
    if (pathValue514f2 !== '') {
      form51Data.append(
        'uploadfile5',
        value514f2,
        'f514f2-' + value514f2.name
      );
    }
    if (pathValue514f3 !== '') {
      form51Data.append(
        'uploadfile5',
        value514f3,
        'f514f3-' + value514f3.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form51Data,
    };
    fetch(
      resources.APPLICATION_URL+'criteria5upload',
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
  // rendering dom
  return (
    <div className="c51-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c51x-colorIndicator-container">
        <p className="c51x-QlcolorIndicator-circle-style"></p>
        <span className="c51x-colorIndicator-span-style">Qualitative</span>
        <p className="c51x-QtcolorIndicator-circle-style"></p>
        <span className="c51x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c51x-weightage-heading-style">
            Key Indicator Weightage: 30
          </h1>
        </div>
      </div>

      {/* Key Indicator: 5.1.1 */}
      <div className="c51x-eachInputField-container">
        <div className="c51x-weightage-container">
          <h1 className="c51x-weightage-heading-style">Weightage: 6</h1>
        </div>
        <form>
          <div className="c51x-container">
            <div className="c51x-heading_Help-container">
              <h1 className="c51x-heading-style">
                <span className="c51x-span-style">5.1.1: </span>
                Average percentage of students benefited by scholarships and
                freeships provided by the Government and non-government bodies,
              industries, individuals, philanthropists during the last five
              years 
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
                title='Formula: '
                >Total number of students benefited by scholarships
                and freeships by institution,
                government and non-government agencies
                1.1 Total number of students on rolls
                X 100
                </HelpButton>
            </div>
            <div className="c51x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus511(!responseButtonStatus511);
                  onClickingViewResponse511();
                }}
                className="c51x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus511 ? (
                <p className="c51x-responseResult-style">{responseValue511}</p>
              ) : null}
            </div>
          </div>
          <div className="c51xx-container">
            <h1 className="c51x-heading-style">
              <span className="c51x-span-style">5.1.1.1 </span>
              Number of students benefited by scholarships and free ships
              provided by the institution, Government and non-government bodies,
              industries, individuals, philanthropists during the last five
              years (other than students receiving scholarships under the
              government schemes for reserved categories)
            </h1>
            <table className="c51x-Qt-table-style">
              <tr>
                <th className="c51x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue5111t1(e.target.value)}
                      id="5111-t1"
                      className="c51x-input-style"
                      type="number"
                      value={value5111t1}
                    />
                    {value5111t1 === '' ? (
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
                      onChange={(e) => setValue5111t2(e.target.value)}
                      id="5111-t2"
                      className="c51x-input-style"
                      type="number"
                      value={value5111t2}
                    />
                    {value5111t2 === '' ? (
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
                      onChange={(e) => setValue5111t3(e.target.value)}
                      id="5111-t3"
                      className="c51x-input-style"
                      type="number"
                      value={value5111t3}
                    />
                    {value5111t3 === '' ? (
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
                      onChange={(e) => setValue5111t4(e.target.value)}
                      id="5111-t4"
                      className="c51x-input-style"
                      type="number"
                      value={value5111t4}
                    />
                    {value5111t4 === '' ? (
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
                      onChange={(e) => setValue5111t5(e.target.value)}
                      id="5111-t5"
                      className="c51x-input-style"
                      type="number"
                      value={value5111t5}
                    />
                    {value5111t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c51x-horizontalTable-heading-style">Number</th>
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
                        setValue5111t6(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t6"
                      className="c51x-input-style"
                      type="number"
                      value={value5111t6}
                    />
                    {value5111t6 === '' ? (
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
                        setValue5111t7(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t7"
                      className="c51x-input-style"
                      type="number"
                      value={value5111t7}
                    />
                    {value5111t7 === '' ? (
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
                        setValue5111t8(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t8"
                      className="c51x-input-style"
                      type="number"
                      value={value5111t8}
                    />
                    {value5111t8 === '' ? (
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
                        setValue5111t9(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t9"
                      className="c51x-input-style"
                      type="number"
                      value={value5111t9}
                    />
                    {value5111t9 === '' ? (
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
                        setValue5111t10(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t10"
                      className="c51x-input-style"
                      type="number"
                      value={value5111t10}
                    />
                    {value5111t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <table className="c51x-table-style">
              <tr>
                <th className="c51x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c51x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c51x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c51x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                  upload self attested letter with the list of students
                  sanctioned scholarships
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5111f1(e.target.files[0]);
                      setPathValue5111f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5111-f1"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5111f1 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5111f1("");
                      document.getElementById("5111-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5111f2(e.target.files[0]);
                      setPathValue5111f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5111-f2"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5111f2 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5111f2("");
                      document.getElementById("5111-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td> Average percentage of students benefited by scholarships and
                  freeships provided by the Government during the last five
                  years</td>
                <td>
                <a href={downloadFile("un5.1.1.xlsx")} target="_blank">
                    View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5111f3(e.target.files[0]);
                      setPathValue5111f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5111-f3"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5111f3 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5111f3("");
                      document.getElementById("5111-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 5.1.2 */}
      <div className="c51x-eachInputField-container">
        <div className="c51x-weightage-container">
          <h1 className="c51x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c51x-container">
            <div className="c51x-heading_Help-container">
              <h1 className="c51x-heading-style">
                <span className="c51x-span-style">5.1.2: </span>
                Efforts taken by the institution to provide career counseling 
including e-counseling and guidance for competitive examinations 
during the last five years
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
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            <div className="c51x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp512Status(true);
                }}
                className="c51x-helpButton-style"
              >
                Help
              </button>
              <Help512
                isHelp512Clicked={help512Status}
                setIsHelp512Clicked={setHelp512Status}
              />
            </div>
         
          </div>
          <div className="c51xx-container">
        
            <table className="c51x-table-style">
              <tr>
                <th className="c51x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c51x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c51x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c51x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5121f1(e.target.files[0]);
                      setPathValue5121f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5121-f1"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5121f1 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5121f1("");
                      document.getElementById("5121-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                Provide the link for additional information
                </td>
                <td>
                <a href={downloadFile("un5.1.3.xlsx")} target="_blank">
                    View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5121f2(e.target.files[0]);
                      setPathValue5121f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5121-f2"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5121f2 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5121f2("");
                      document.getElementById("5121-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 5.1.3 */}
      <div className="c51x-eachInputField-container">
        <div className="c51x-weightage-container">
          <h1 className="c51x-weightage-heading-style">Weightage: 8</h1>
        </div>
        <form>
          <div className="c51x-container">
            <div className="c51x-heading_Help-container">
              <div>
                <h1 className="c51x-heading-style">
                  <span className="c51x-span-style">5.1.3: </span>
                  Following Capacity development and skills enhancement
                  initiatives are undertaken by institiution
                </h1>
                <p className="c51x-para-style">
                  1.Soft skills
                  <br />
                  2.Language and communication skills
                  <br />
                  3.Life skills (Yoga, physical fitness, health and hygiene)
                  <br />
                  4.Awareness of trends in technology
                </p>
                <div className="c51x-radio-container" style={{width:"100%"}}>
                  <div className="c51x-radio-subContainer" style={{width:"45%"}}>
                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue513t1(e.target.value)}
                        value="option a"
                        name="513-t1"
                        type="radio"
                      />
                      <label className="c51x-radioLabel-style" for="513-t1">
                        A. All of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue513t2(e.target.value)}
                        value="option b"
                        name="513-t2"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="513-t1">
                        B. Any three of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue513t3(e.target.value)}
                        value="option c"
                        name="513-t3"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="513-t1">
                        C. Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c51x-radio-subContainer">
                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue513t4(e.target.value)}
                        value="option d"
                        name="513-t4"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="513-t1">
                        D. Any one of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue513t5(e.target.value)}
                        value="option e"
                        name="513-t5"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="513-t1">
                        E. None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen3}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen3}
                handleClose={handleHelpClose3}
              />
            </div>
            <div className="c31x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus513(!responseButtonStatus513);
                  onClickingViewResponse513();
                }}
                className="c31x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus513 ? (
                <p className="c31x-responseResult-style">{responseValue513}</p>
              ) : null}
            </div>
          </div>
          <table className="c51x-table-style">
            <tr>
              <th className="c51x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c51x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c51x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c51x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Link to Institutional website</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue513f1(e.target.files[0]);
                    setPathValue513f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="513-f1"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue513f1 === '' ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue513f1("");
                      document.getElementById("513-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue513f2(e.target.files[0]);
                    setPathValue513f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="513-f2"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue513f2 === '' ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue513f2("");
                      document.getElementById("513-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Details of capability development and schemes</td>
              <td>
              <a href={downloadFile("un5.1.4.xlsx")} target="_blank">
                  View Template</a>
              </td>
              <td>
                <input
                  onChange={(e) => {
                    setValue513f3(e.target.files[0]);
                    setPathValue513f3(e.target.value);
                    showFilePreview(e);
                  }}
                  id="513-f3"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue513f3 === '' ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue513f3("");
                      document.getElementById("513-f3").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 5.1.4 */}
      <div className="c51x-eachInputField-container">
        <div className="c51x-weightage-container">
          <h1 className="c51x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c51x-container">
            <div className="c51x-heading_Help-container">
              <div>
                <h1 className="c51x-heading-style">
                  <span className="c51x-span-style">5.1.4: </span>
                  The Institution adopts the following for redressal of student
grievances including sexual harassment and ragging cases
                </h1>
                <p className="c51x-para-style">
                  1. Implementation of guidelines of statutory/regulatory bodies
                  <br />
                  2. Organisation wide awareness and undertakings on policies
                  with zero tolerance
                  <br />
                  3. Mechanisms for submission of online/offline students’
                  grievances
                  <br />
                  4. Timely redressal of the grievances through appropriate
                  committees
                </p>
                <div className="c51x-radio-container" style={{width:"120%"}}>
                  <div className="c51x-radio-subContainer" style={{width:"45%"}}>
                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="514-t1">
                        A. All of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="514-t1">
                        B. Any three of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />
                      <label className="c51x-radioLabel-style" for="514-t1">
                        C. Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c51x-radio-subContainer">
                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="514-t1">
                        D. Any one of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="514-t1">
                        E. None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen4}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen4}
                handleClose={handleHelpClose4}
                title='Upload the specific document as per description '
                ></HelpButton>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus514(!responseButtonStatus514);
                  onClickingViewResponse514();
                }}
                className="c51x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus514 ? (
                <p className="c51x-responseResult-style">{responseValue514}</p>
              ) : null}
            </div>
          </div>
          <table className="c51x-table-style">
            <tr>
              <th className="c51x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c51x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c51x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c51x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>
                Minutes of the meetings of student redressal committee,
                prevention of sexual harassment committee and Anti Ragging
                committee
              </td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue514f1(e.target.files[0]);
                    setPathValue514f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="514-f1"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue514f1 === '' ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue514f1("");
                      document.getElementById("514-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Upload any additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue514f2(e.target.files[0]);
                    setPathValue514f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="514-f2"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue514f2 === '' ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue514f2("");
                      document.getElementById("514-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Details of student grievances including sexual harassment and
                ragging cases
              </td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue514f3(e.target.files[0]);
                    setPathValue514f3(e.target.value);
                    showFilePreview(e);
                  }}
                  id="514-f3"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue514f3 === '' ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue514f3("");
                      document.getElementById("514-f3").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      <div className="c51x-button-container">
        <button onClick={onClickingSave} className="c51x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria51;
