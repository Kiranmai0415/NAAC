import React, { useState } from 'react';
import './c24-style.css';
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
function Help241(props) {
  return props.isHelp241Clicked ? (
    <div className="c24x-help-mainContainer">
      <div className="c24x-help-subContainer">
        <h1 className="c24x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c24x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>Number of full time
          teachers
          <span style={{ fontWeight: 'bold' }}>) /</span>
          <span style={{ fontWeight: 'bold' }}>(</span> Number of Sanctioned
          posts
          <span style={{ fontWeight: 'bold' }}>) /</span>*100
        </p>
        <p className="c24x-help-para-style">
          Average Percentage
          <span style={{ fontWeight: 'bold' }}>=(</span> ΣPercentage per year
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>
        <button
          className="c24x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp241Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help242(props) {
  return props.isHelp242Clicked ? (
    <div className="c24x-help-mainContainer">
      <div className="c24x-help-subContainer">
        <h1 className="c24x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c24x-help-para-style">
          Percentage per year<span style={{ fontWeight: 'bold' }}>=</span>
          <span style={{ fontWeight: 'bold' }}>(</span>Number of full time
          teachers with Ph.D./D.M/M.Ch./D.N.B Superspeciality/D.Sc./D’Lit. year
          wise during the last five years
          <span style={{ fontWeight: 'bold' }}>) /</span>
          <span style={{ fontWeight: 'bold' }}>(</span> Number of full time
          teachers
          <span style={{ fontWeight: 'bold' }}>) *</span>100
        </p>
        <p className="c24x-help-para-style">
          Average percentage<span style={{ fontWeight: 'bold' }}>=</span>
          <span style={{ fontWeight: 'bold' }}>(</span> ΣPercentage per year
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>
        <button
          className="c24x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp242Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help243(props) {
  return props.isHelp243Clicked ? (
    <div className="c24x-help-mainContainer">
      <div className="c24x-help-subContainer">
        <h1 className="c24x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c24x-help-para-style">
          Sum of total teaching experience of full time teachers in the same
          institution
          <span style={{ fontWeight: 'bold' }}> /</span> Number of full time
          teachers
        </p>
        <button
          className="c24x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp243Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria24() {

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


  
  // state variables

  const [value241t1, setValue241t1] = useState();
  const [value241t2, setValue241t2] = useState();
  const [value241t3, setValue241t3] = useState();
  const [value241t4, setValue241t4] = useState();
  const [value241t5, setValue241t5] = useState();
  const [value241t6, setValue241t6] = useState();
  const [value241t7, setValue241t7] = useState();
  const [value241t8, setValue241t8] = useState();
  const [value241t9, setValue241t9] = useState();
  const [value241t10, setValue241t10] = useState();
  const [value241t11, setValue241t11] = useState();
  const [value241t12, setValue241t12] = useState();
  const [value241t13, setValue241t13] = useState();
  const [value241t14, setValue241t14] = useState();
  const [value241t15, setValue241t15] = useState();
  const [value241t16, setValue241t16] = useState();
  const [value241t17, setValue241t17] = useState();
  const [value241t18, setValue241t18] = useState();
  const [value241t19, setValue241t19] = useState();
  const [value241t20, setValue241t20] = useState();
  const [value241t21, setValue241t21] = useState();
  const [pathValue241f1, setPathValue241f1] = useState('');
  const [pathValue241f2, setPathValue241f2] = useState('');
  const [pathValue241f3, setPathValue241f3] = useState('');

  const [value241f1, setValue241f1] = useState([]);
  const [value241f2, setValue241f2] = useState([]);
  const [value241f3, setValue241f3] = useState([]);

  const [value2421t1, setValue2421t1] = useState();
  const [value2421t2, setValue2421t2] = useState();
  const [value2421t3, setValue2421t3] = useState();
  const [value2421t4, setValue2421t4] = useState();
  const [value2421t5, setValue2421t5] = useState();
  const [value2421t6, setValue2421t6] = useState();
  const [value2421t7, setValue2421t7] = useState();
  const [value2421t8, setValue2421t8] = useState();
  const [value2421t9, setValue2421t9] = useState();
  const [value2421t10, setValue2421t10] = useState();
  const [value2421t11, setValue2421t11] = useState();
  const [value2421t12, setValue2421t12] = useState();
  const [value2421t13, setValue2421t13] = useState();
  const [value2421t14, setValue2421t14] = useState();
  const [value2421t15, setValue2421t15] = useState();
  const [value2421t16, setValue2421t16] = useState();
  const [value2421t17, setValue2421t17] = useState();
  const [value2421t18, setValue2421t18] = useState();
  const [value2421t19, setValue2421t19] = useState();
  const [value2421t20, setValue2421t20] = useState();
  const [value2421t21, setValue2421t21] = useState();
  const [pathValue2421f1, setPathValue2421f1] = useState('');
  const [pathValue2421f2, setPathValue2421f2] = useState('');
  const [value2421f1, setValue2421f1] = useState([]);
  const [value2421f2, setValue2421f2] = useState([]);

  const [value2431t1, setValue2431t1] = useState();
  const [value2431t2, setValue2431t2] = useState();

  const [pathValue2431f1, setPathValue2431f1] = useState('');
  const [pathValue2431f2, setPathValue2431f2] = useState('');

  const [value2431f1, setValue2431f1] = useState([]);
  const [value2431f2, setValue2431f2] = useState([]);

  const [responseButtonStatus241, setResponseButtonStatus241] = useState(false);
  const [responseButtonStatus242, setResponseButtonStatus242] = useState(false);
  const [responseButtonStatus243, setResponseButtonStatus243] = useState(false);
  const [responseValue241, setResponseValue241] = useState('');
  const [responseValue242, setResponseValue242] = useState('');
  const [responseValue243, setResponseValue243] = useState('');
  const [help241Status, setHelp241Status] = useState(false);
  const [help242Status, setHelp242Status] = useState(false);
  const [help243Status, setHelp243Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');

 const [value2411t1, setValue2411t1] = useState();


  // response button functionality
  function onClickingViewResponse241() {
    if (
      value241t6 === ''
      || value241t7 === ''
      || value241t8 === ''
      || value241t9 === ''
      || value241t10 === ''
      || value241t16 === ''
      || value241t17 === ''
      || value241t18 === ''
      || value241t19 === ''
      || value241t20 === ''
      || value241t6 === undefined
      || value241t7 === undefined
      || value241t8 === undefined
      || value241t9 === undefined
      || value241t10 === undefined
      || value241t16 === undefined
      || value241t17 === undefined
      || value241t18 === undefined
      || value241t19 === undefined
      || value241t20 === undefined
    ) {
      setResponseValue241('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value241t6, 10)) === false
      || Number.isInteger(parseInt(value241t7, 10)) === false
      || Number.isInteger(parseInt(value241t8, 10)) === false
      || Number.isInteger(parseInt(value241t9, 10)) === false
      || Number.isInteger(parseInt(value241t10, 10)) === false
      || Number.isInteger(parseInt(value241t16, 10)) === false
      || Number.isInteger(parseInt(value241t17, 10)) === false
      || Number.isInteger(parseInt(value241t18, 10)) === false
      || Number.isInteger(parseInt(value241t19, 10)) === false
      || Number.isInteger(parseInt(value241t20, 10)) === false
    ) {
      setResponseValue241('Input should be an Integer');
    } else if (
      value241t6 !== ''
      && value241t7 !== ''
      && value241t8 !== ''
      && value241t9 !== ''
      && value241t10 !== ''
      && value241t16 !== ''
      && value241t17 !== ''
      && value241t18 !== ''
      && value241t19 !== ''
      && value241t20 !== ''
    ) {
      setResponseValue241(
        ((value241t6 / value241t16) * 100
          + (value241t7 / value241t17) * 100
          + (value241t8 / value241t18) * 100
          + (value241t9 / value241t19) * 100
          + (value241t10 / value241t20) * 100)
          / 5
      );
    }
  }

  function onClickingViewResponse242() {
    if (
      value2421t6 === ''
      || value2421t7 === ''
      || value2421t8 === ''
      || value2421t9 === ''
      || value2421t10 === ''
      || value2421t16 === ''
      || value2421t17 === ''
      || value2421t18 === ''
      || value2421t19 === ''
      || value2421t20 === ''
      || value2421t6 === undefined
      || value2421t7 === undefined
      || value2421t8 === undefined
      || value2421t9 === undefined
      || value2421t10 === undefined
      || value2421t16 === undefined
      || value2421t17 === undefined
      || value2421t18 === undefined
      || value2421t19 === undefined
      || value2421t20 === undefined
    ) {
      setResponseValue242('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value2421t6, 10)) === false
      || Number.isInteger(parseInt(value2421t7, 10)) === false
      || Number.isInteger(parseInt(value2421t8, 10)) === false
      || Number.isInteger(parseInt(value2421t9, 10)) === false
      || Number.isInteger(parseInt(value2421t10, 10)) === false
      || Number.isInteger(parseInt(value2421t16, 10)) === false
      || Number.isInteger(parseInt(value2421t17, 10)) === false
      || Number.isInteger(parseInt(value2421t18, 10)) === false
      || Number.isInteger(parseInt(value2421t19, 10)) === false
      || Number.isInteger(parseInt(value2421t20, 10)) === false
    ) {
      setResponseValue242('Input should be an Integer');
    } else if (
      value2421t6 !== ''
      && value2421t7 !== ''
      && value2421t8 !== ''
      && value2421t9 !== ''
      && value2421t10 !== ''
      && value2421t16 !== ''
      && value2421t17 !== ''
      && value2421t18 !== ''
      && value2421t19 !== ''
      && value2421t20 !== ''
    ) {
      setResponseValue242(
      
          ((value2421t6 / value2421t16) * 100
            + (value2421t7 / value2421t17) * 100
            + (value2421t8 / value2421t18) * 100
            + (value2421t9 / value2421t19) * 100
            + (value2421t10 / value2421t20) * 100)
            / 5
        
      );
    }
  }

  function onClickingViewResponse243() {
    if (value2431t1 === '' || value2431t2 === '') {
      setResponseValue243('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value2431t1, 10)) === false
      || Number.isInteger(parseInt(value2431t2, 10)) === false
    ) {
      setResponseValue243('Input should be an Integer');
    } else if (value2431t1 !== '' && value2431t2 !== '') {
      setResponseValue243(
        parseInt(value2431t1, 10) / parseInt(value2431t2, 10)
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
    criteria24Qn: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
        input2431t1: value2431t1,
       input2431t2: value2431t2,
      // input2431t1: value2431t1,
      // input241t21: value241t21,
      // input2421t21: value2421t21,
      response241: responseValue241,
      response242: responseValue242,
      response243: responseValue243,
      response244: responseValue243,
      criteria24status:"save"
      },
    ],

      yearTable2411: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,input2411y: value241t1, input2411v: value241t6 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202,input2411y: value241t2, input2411v: value241t7 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203,input2411y: value241t3, input2411v: value241t8 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204,input2411y: value241t4, input2411v: value241t9 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205,input2411y: value241t5, input2411v: value241t10 },
      ],
      yearTable2412: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201, input2412y: value241t1, input2412v: value241t6 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202,input2412y: value241t2, input2412v: value241t7 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203,input2412y: value241t3, input2412v: value241t8 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204,input2412y: value241t4, input2412v: value241t9 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205,input2412y: value241t5, input2412v: value241t10 },
      ],
      yearTable2421: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,input2421y: value2421t1, input2421v: value2421t6 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202,input2421y: value2421t2, input2421v: value2421t7 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203,input2421y: value2421t3, input2421v: value2421t8 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204, input2421y: value2421t4, input2421v: value2421t9 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205,input2421y: value2421t5, input2421v: value2421t10 },
      ],
      yearTable24212: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,input24212y: value2421t1, input24212v: value2421t6 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202,input24212y: value2421t2, input24212v: value2421t7 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203,input24212y: value2421t3, input24212v: value2421t8 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204,input24212y: value2421t4, input24212v: value2421t9 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205,input24212y: value2421t5, input24212v: value2421t10 },
      ],
      // yearTable24411: [
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 201,input24411y: value2441t1, input24411v: value2441t6 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 202,input24411y: value2441t2, input24411v: value2441t7 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 203,input24411y: value2441t3, input24411v: value2441t8 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 204,input24411y: value2441t4, input24411v: value2441t9 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 205,input24411y: value2441t5, input24411v: value2441t10 },
      // ],
      // yearTable24412: [
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 201,input24412y: value2441t1, input24412v: value2441t6 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 202,input24412y: value2441t2, input24412v: value2441t7 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 203,input24412y: value2441t3, input24412v: value2441t8 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 204,input24412y: value2441t4, input24412v: value2441t9 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 205,input24412y: value2441t5, input24412v: value2441t10 },
      // ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form24Data = new FormData();
    console.log(JSON.stringify(inputDataList));
    form24Data.append('criteria2Fieldinfo', jsonBlob(inputDataList));
    if (pathValue241f1 !== '') {
      form24Data.append('uploadfile2', value241f1, 'f241f1-' + value241f1.name);
    }
    if (pathValue241f2 !== '') {
      form24Data.append('uploadfile2', value241f2, 'f241f2-' + value241f2.name);
    }
    if (pathValue241f3 !== '') {
      form24Data.append('uploadfile2', value241f3, 'f241f3-' + value241f3.name);
    }

    if (pathValue2421f1 !== '') {
      form24Data.append(
        'uploadfile2',
        value2421f1,
        'f2421f1-' + value2421f1.name
      );
    }
    if (pathValue2421f2 !== '') {
      form24Data.append(
        'uploadfile2',
        value2421f2,
        'f2421f2-' + value2421f2.name
      );
    }

    if (pathValue2431f1 !== '') {
      form24Data.append(
        'uploadfile2',
        value2431f1,
        'f2431f1-' + value2431f1.name
      );
    }
    if (pathValue2431f2 !== '') {
      form24Data.append(
        'uploadfile2',
        value2431f2,
        'f2431f2-' + value2431f2.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form24Data,
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
  return (
    <div className="c24-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c24x-colorIndicator-container">
        <p className="c24x-QlcolorIndicator-circle-style"></p>
        <span className="c24x-colorIndicator-span-style">Qualitative</span>
        <p className="c24x-QtcolorIndicator-circle-style"></p>
        <span className="c24x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c24x-weightage-heading-style">
            Key Indicator Weightage: 50
          </h1>
        </div>
      </div>

      {/* Key Indicator: 2.4.1 */}
      <div className="c24x-eachInputField-container">
        <div className="c24x-weightage-container">
          <h1 className="c24x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c24x-container">
            <div className="c24x-heading_Help-container">
              <h1 className="c24x-heading-style">
                <span className="c24x-span-style">2.4.1: </span>
                {/* Average number of days from the date of last semester-end/ year-
                end examination till the declaration of results year-wise during
                the last five years */}
             Percentage of full time teachers appointed against the number of sanctioned posts during the last five years         </h1>
             <button
                onClick={handleHelpOpen}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Formula:                '
                >(2.1)Number of full time teachers during last five years (𝑙𝑎𝑡𝑒𝑠𝑡 𝑐𝑜𝑚𝑝𝑙𝑒𝑡𝑒𝑑 𝑎𝑐𝑎𝑑𝑒𝑚𝑖𝑐 𝑦𝑒𝑎𝑟)
                𝐓𝐨𝐭𝐚𝐥 𝐍𝐮𝐦𝐛𝐞𝐫 𝐨𝐟 𝐬𝐚𝐧𝐜𝐭𝐢𝐨𝐧𝐞𝐝 𝐩𝐨𝐬𝐭𝐬
                X 100</HelpButton>
            </div>
            {/* <div className="c24x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus241(!responseButtonStatus241);
                  onClickingViewResponse241();
                }}
                className="c24x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus241 ? (
                <p className="c24x-responseResult-style">{responseValue241}</p>
              ) : null}
            </div> */}
          </div>
          <div className="c24xx-container">
            <h1 className="c24x-heading-style">
              <span className="c24x-span-style">2.4.1.1 </span>
              Total Number of Sanctioned posts during last five years
              <input
                onChange={(e) => setValue2411t1(e.target.value)}
                id="2411-t1"
                style={{ width:"25%" , marginLeft: "4.6%" }}
                type="number"
              />
            </h1>
      
            <table className="c24x-table-style">
              <tr>
                <th className="c24x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c24x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c24x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c24x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                Institutional data in the prescribed format (data template)
                </td>
                <td>
                <a href={downloadFile("un2.4.1.xlsx")} target="_blank">
                  View Template</a></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue241f1(e.target.files[0]);
                      setPathValue241f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="241-f1"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue241f1 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue241f1("");
                      document.getElementById("241-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Sanction letters indicating number of posts sanctioned by the competent authority (including Management sanctioned posts).</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue241f2(e.target.files[0]);
                      setPathValue241f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="241-f2"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue241f2 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue241f2("");
                      document.getElementById("241-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Any Additional Information
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue241f3(e.target.files[0]);
                      setPathValue241f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="241-f3"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue241f3 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue241f3("");
                      document.getElementById("241-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 2.4.2 */}
      <div className="c24x-eachInputField-container">
        <div className="c24x-weightage-container">
          <h1 className="c24x-weightage-heading-style">Weightage: 40</h1>
        </div>
        <form>
          <div className="c24x-container">
            <div className="c24x-heading_Help-container">
              <h1 className="c24x-heading-style">
                <span className="c24x-span-style">2.4.2: </span>
                Percentage of full time teachers with Ph.D./D.M/M.Ch./D.N.B/ 
                Superspeciality/L.L.D/D.S.C/D.Litt. during the last five years
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
                title='Formula:'
                >𝐍𝐮𝐦𝐛𝐞𝐫𝐨𝐟𝐟𝐮𝐥𝐥𝐭𝐢𝐦𝐞𝐭𝐞𝐚𝐜𝐡𝐞𝐫𝐬
                𝒘𝒊𝒕𝒉𝑷𝒉.𝑫./𝑫.𝑴/𝑴.𝑪𝒉./𝑫.𝑵.𝑩 𝑺𝒖𝒑𝒆𝒓𝒔𝒑𝒆𝒄𝒊𝒂𝒍𝒊𝒕𝒚/𝐿.𝐿.𝐷/𝐷.𝑆.𝐶/𝐷.𝐿𝑖𝑡𝑡
                (𝟐.𝟐) Number of Full−time teachers in the institutions
                X 100</HelpButton>
            </div>
            {/* <div className="c24x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus242(!responseButtonStatus242);
                  onClickingViewResponse242();
                }}
                className="c24x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus242 ? (
                <p className="c24x-responseResult-style">{responseValue242}</p>
              ) : null}
            </div> */}
          </div>
          <div className="c24xx-container">
            <h1 className="c24xx-Heading-style">
              <span className="c24xx-span-style">2.4.2.1: </span>
             Number of full time teachers with Ph.D./D.M/M.Ch./D.N.B/ 
            Superspeciality/L.L.D/D.S.C/D.Litt Superspecialit/ during the last five 
            years
            <input
                onChange={(e) => setValue2421t1(e.target.value)}
                id="2421-t1"
                style={{ width:"25%" , marginLeft: "4.6%" }}
                type="number"
              />
            </h1>
      
            <table className="c24x-table-style">
              <tr>
                <th className="c24x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c24x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c24x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c24x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Institutional data in the prescribed format (data template)</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2421f1(e.target.files[0]);
                      setPathValue2421f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2421-f1"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue2421f1 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2421f1("");
                      document.getElementById("2421-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>List of faculty having Ph.D./D.M/M.Ch./D.N. Superspeciality/ along with particulars of the degree awarding university, subject and the year of award per academic year.</td>
                <td><a href={downloadFile("un2.4.2.xlsx")} target="_blank">View Template</a></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2421f2(e.target.files[0]);
                      setPathValue2421f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2421-f2"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue2421f2 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2421f2("");
                      document.getElementById("2421-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Copies of Ph.D./D.M/M.Ch./D.N.B Superspeciality awarded by UGC recognized universities</td>
                <td><a href={downloadFile("un2.4.2.xlsx")} target="_blank">view Template</a></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2421f2(e.target.files[0]);
                      setPathValue2421f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2421-f2"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue2421f2 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2421f2("");
                      document.getElementById("2421-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any Additional Information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2421f2(e.target.files[0]);
                      setPathValue2421f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2421-f2"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue2421f2 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2421f2("");
                      document.getElementById("2421-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 2.4.3 */}
      <div className="c24x-eachInputField-container">
        <div className="c24x-weightage-container">
          <h1 className="c24x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c24x-container">
            <div className="c24x-heading_Help-container">
              <h1 className="c24x-heading-style">
                <span className="c24x-span-style">2.4.3: </span>
                Average teaching experience of full time teachers (Data to be provided 
              only for the latest completed academic year, in number of years)
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
                title='formula'
                ><h1>(Total teaching experience of full time teachers )/(2.1 Number of full time teachers (latest completed year))</h1></HelpButton>
            </div>
            {/* <div className="c24x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus243(!responseButtonStatus243);
                  onClickingViewResponse243();
                }}
                className="c24x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus243 ? (
                <p className="c24x-responseResult-style">{responseValue243}</p>
              ) : null}
            </div> */}
          </div>
          <div className="c24xx-container">
            <h1 className="c24xx-Heading-style">
              <span className="c24xx-span-style">2.4.3.1: </span>
              Average teaching experience of full time teachers (Data to be provided 
            only for the latest completed academic year, in number of years)
            <input
                onChange={(e) => setValue2431t1(e.target.value)}
                id="2431-t1"
                style={{ width:"25%" , marginLeft: "4.6%" }}
                type="number"
              />
            </h1>
          
            <table className="c24x-table-style">
              <tr>
                <th className="c24x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c24x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c24x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c24x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2431f1(e.target.files[0]);
                      setPathValue2431f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2431-f1"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue2431f1 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2431f1("");
                      document.getElementById("2431-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Provide Link for Additional Information</td>
                <a href={downloadFile("un2.4.3.xlsx")} target="_blank">View Template</a>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2431f2(e.target.files[0]);
                      setPathValue2431f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2431-f2"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue2431f2 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2431f2("");
                      document.getElementById("2431-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
     

    
      <div className="c24x-button-container">
        <button onClick={onClickingSave} className="c24x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria24;
