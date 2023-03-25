import React, { useState } from 'react';
import './c52-style.css';
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
function Help521(props) {
  return props.isHelp521Clicked ? (
    <div className="c52x-help-mainContainer">
      <div className="c52x-help-subContainer">
        <h1 className="c52x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c52x-help-para-style">
          Percentage per year
          <span style={{ fontWeight: 'bold' }}>=(</span>Total number of students
          qualifying in state,national,international level exams
          <span style={{ fontWeight: 'bold' }}>) /</span>
          <span style={{ fontWeight: 'bold' }}>(</span>Number of students
          appeared for the state,national,international level exams
          <span style={{ fontWeight: 'bold' }}>) /</span>*100
        </p>
        <p className="c52x-help-para-style">
          Average
          <span style={{ fontWeight: 'bold' }}>(</span> ΣPercentage per year
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>

        <button
          className="c52x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp521Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help522(props) {
  return props.isHelp522Clicked ? (
    <div className="c52x-help-mainContainer">
      <div className="c52x-help-subContainer">
        <h1 className="c52x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c52x-help-para-style">
          Percentage per year
          <span style={{ fontWeight: 'bold' }}>(</span>Number of Outgoing
          Students placed
          <span style={{ fontWeight: 'bold' }}>) /</span>
          <span style={{ fontWeight: 'bold' }}>(</span> Number of Outgoing
          students
          <span style={{ fontWeight: 'bold' }}>) /</span>*100
        </p>
        <p className="c52x-help-para-style">
          Average
          <span style={{ fontWeight: 'bold' }}>=(</span> ΣPercentage per year
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>

        <button
          className="c52x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp522Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help523(props) {
  return props.isHelp523Clicked ? (
    <div className="c52x-help-mainContainer">
      <div className="c52x-help-subContainer">
        <h1 className="c52x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c52x-help-para-style">
          Percentage per year<span style={{ fontWeight: 'bold' }}>=</span>
          <span style={{ fontWeight: 'bold' }}>((</span>Total number of Outgoing
          students progressing to higher education
          <span style={{ fontWeight: 'bold' }}>) /</span>
          <span style={{ fontWeight: 'bold' }}>(</span>Total Number of final
          year students
          <span style={{ fontWeight: 'bold' }}>) )</span>*100
        </p>
        <button
          className="c52x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp523Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria52() {
  // state variables
   // getfile data with API
   function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
 //help buttom
  const [isOpen, setIsopen] = useState(false)
  const [isOpen3, setIsopen3] = useState(false)
  const [isOpen2,setIsopen2] = useState(false)
  const handleHelpOpen = (e) => {
    e.preventDefault(),
    setIsopen(true)
  }
  const handleHelpClose = () => {
    setIsopen(false)
  }
  const handleHelpOpen3 = (e) => {
    e.preventDefault(),
    setIsopen3(true)
  }
  const handleHelpClose3 = () => {
    setIsopen3(false)
  }
  const handleHelpOpen2 =(e)=>{
    e.preventDefault();
    setIsopen2(true)
  } 
  const handleHelpClose2 = (e)=>{
    setIsopen2(false)
  }

  const [value5211t1, setValue5211t1] = useState();
  const [value5211t2, setValue5211t2] = useState();
  const [value5211t3, setValue5211t3] = useState();
  const [value5211t4, setValue5211t4] = useState();
  const [value5211t5, setValue5211t5] = useState();
  const [value5211t6, setValue5211t6] = useState();
  const [value5211t7, setValue5211t7] = useState();
  const [value5211t8, setValue5211t8] = useState();
  const [value5211t9, setValue5211t9] = useState();
  const [value5211t10, setValue5211t10] = useState();

  const [value5211t11, setValue5211t11] = useState();
  const [value5211t12, setValue5211t12] = useState();
  const [value5211t13, setValue5211t13] = useState();
  const [value5211t14, setValue5211t14] = useState();
  const [value5211t15, setValue5211t15] = useState();
  const [value5211t16, setValue5211t16] = useState();
  const [value5211t17, setValue5211t17] = useState();
  const [value5211t18, setValue5211t18] = useState();
  const [value5211t19, setValue5211t19] = useState();
  const [value5211t20, setValue5211t20] = useState();

  const [value5221t11, setValue5221t11] = useState();
  const [value5221t12, setValue5221t12] = useState();
  const [value5221t13, setValue5221t13] = useState();
  const [value5221t14, setValue5221t14] = useState();
  const [value5221t15, setValue5221t15] = useState();
  const [value5221t16, setValue5221t16] = useState();
  const [value5221t17, setValue5221t17] = useState();
  const [value5221t18, setValue5221t18] = useState();
  const [value5221t19, setValue5221t19] = useState();
  const [value5221t20, setValue5221t20] = useState();

  
  


  const [value5231t1, setValue5231t1] = useState();
  const [value5231t2, setValue5231t2] = useState();
  const [value5231t3, setValue5231t3] = useState();
  const [value5231t4, setValue5231t4] = useState();
  const [value5231t5, setValue5231t5] = useState();
  const [value5231t6, setValue5231t6] = useState();
  const [value5231t7, setValue5231t7] = useState();
  const [value5231t8, setValue5231t8] = useState();
  const [value5231t9, setValue5231t9] = useState();
  const [value5231t10, setValue5231t10] = useState();

  const [pathValue5212f1, setPathValue5212f1] = useState('');
  const [pathValue5212f2, setPathValue5212f2] = useState('');
  const [pathValue5212f3, setPathValue5212f3] = useState('');

  const [value5212f1, setValue5212f1] = useState([]);
  const [value5212f2, setValue5212f2] = useState([]);
  const [value5212f3, setValue5212f3] = useState([]);

  const [pathValue5221f1, setPathValue5221f1] = useState('');
  const [pathValue5221f2, setPathValue5221f2] = useState('');
  const [pathValue5221f3, setPathValue5221f3] = useState('');
  const [value5221f1, setValue5221f1] = useState([]);
  const [value5221f2, setValue5221f2] = useState([]);
  const [value5221f3, setValue5221f3] = useState([]);

  const [pathValue5231f1, setPathValue5231f1] = useState('');
  const [pathValue5231f2, setPathValue5231f2] = useState('');
  const [pathValue5231f3, setPathValue5231f3] = useState('');
  const [value5231f1, setValue5231f1] = useState([]);
  const [value5231f2, setValue5231f2] = useState([]);
  const [value5231f3, setValue5231f3] = useState([]);

  const [responseButtonStatus521, setResponseButtonStatus521] = useState(false);
  const [responseButtonStatus522, setResponseButtonStatus522] = useState(false);
  const [responseButtonStatus523, setResponseButtonStatus523] = useState(false);

  const [responseValue521, setResponseValue521] = useState('');
  const [responseValue522, setResponseValue522] = useState('');
  const [responseValue523, setResponseValue523] = useState('');

  const [help521Status, setHelp521Status] = useState(false);
  const [help522Status, setHelp522Status] = useState(false);
  const [help523Status, setHelp523Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');

  const [value5221t1, setValue5221t1] = useState();
  const [value5221t2, setValue5221t2] = useState();
  const [value5221t3, setValue5221t3] = useState();
  const [value5221t4, setValue5221t4] = useState();
  const [value5221t5, setValue5221t5] = useState();
  const [value5221t6, setValue5221t6] = useState();
  const [value5221t7, setValue5221t7] = useState();
  const [value5221t8, setValue5221t8] = useState();
  const [value5221t9, setValue5221t9] = useState();
  const [value5221t10, setValue5221t10] = useState();


  // response button functionality
  function onClickingViewResponse521() {
    if (
      value5211t6 === ''
      || value5211t7 === ''
      || value5211t8 === ''
      || value5211t9 === ''
      || value5211t10 === ''
      || value5211t16 === ''
      || value5211t17 === ''
      || value5211t18 === ''
      || value5211t19 === ''
      || value5211t20 === ''
      || value5211t6 === undefined
      || value5211t7 === undefined
      || value5211t8 === undefined
      || value5211t9 === undefined
      || value5211t10 === undefined
      || value5211t16 === undefined
      || value5211t17 === undefined
      || value5211t18 === undefined
      || value5211t19 === undefined
      || value5211t20 === undefined
    ) {
      setResponseValue521('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value5211t6, 10)) === false
      || Number.isInteger(parseInt(value5211t7, 10)) === false
      || Number.isInteger(parseInt(value5211t8, 10)) === false
      || Number.isInteger(parseInt(value5211t9, 10)) === false
      || Number.isInteger(parseInt(value5211t10, 10)) === false
      || Number.isInteger(parseInt(value5211t16, 10)) === false
      || Number.isInteger(parseInt(value5211t17, 10)) === false
      || Number.isInteger(parseInt(value5211t18, 10)) === false
      || Number.isInteger(parseInt(value5211t19, 10)) === false
      || Number.isInteger(parseInt(value5211t20, 10)) === false
    ) {
      setResponseValue521('Input should be an Integer');
    } else if (
      value5211t6 !== ''
      && value5211t7 !== ''
      && value5211t8 !== ''
      && value5211t9 !== ''
      && value5211t10 !== ''
      && value5211t16 !== ''
      && value5211t17 !== ''
      && value5211t18 !== ''
      && value5211t19 !== ''
      && value5211t20 !== ''
    ) {
      setResponseValue521(
        ((value5211t6 / value5211t16) * 100
          + (value5211t7 / value5211t17) * 100
          + (value5211t8 / value5211t18) * 100
          + (value5211t9 / value5211t19) * 100
          + (value5211t10 / value5211t20) * 100)
          / 5
      );
    }
  }

  function onClickingViewResponse522() {
    if (value5221t1 === '' || value5221t2 === '') {
      setResponseValue522('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value5221t1, 10)) === false
      || Number.isInteger(parseInt(value5221t2, 10)) === false
    ) {
      setResponseValue522('Input should be an Integer');
    } else if (value5221t1 !== '' && value5221t2 !== '') {
      setResponseValue522(
        (parseInt(value5221t1, 10) / parseInt(value5221t2, 10)) * 100
      );
    }
  }
  function onClickingViewResponse523() {
    if (
      value5231t6 === ''
      || value5231t7 === ''
      || value5231t8 === ''
      || value5231t9 === ''
      || value5231t10 === ''
      || value5231t6 === undefined
      || value5231t7 === undefined
      || value5231t8 === undefined
      || value5231t9 === undefined
      || value5231t10 === undefined
    ) {
      setResponseValue523('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value5231t6, 10)) === false
      || Number.isInteger(parseInt(value5231t7, 10)) === false
      || Number.isInteger(parseInt(value5231t8, 10)) === false
      || Number.isInteger(parseInt(value5231t9, 10)) === false
      || Number.isInteger(parseInt(value5231t10, 10)) === false
    ) {
      setResponseValue523('Input should be an Integer');
    } else if (
      value5231t6 !== ''
      && value5231t7 !== ''
      && value5231t8 !== ''
      && value5231t9 !== ''
      && value5231t10 !== ''
    ) {
      setResponseValue523(
        ((value5231t6)
          + (value5231t7)
          + (value5231t8)
          + (value5231t9)
          + (value5231t10) * 100)
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
    criteria52Qn: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
      response521: responseValue521,
      response522: responseValue522,
      response523: responseValue523,
      criteria52status:"save"
      },
    ],
      yearTable5211: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201, input5211y: value5211t1, input5211v: value5211t6 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202,input5211y: value5211t2, input5211v: value5211t7 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203, input5211y: value5211t3, input5211v: value5211t8 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204,input5211y: value5211t4, input5211v: value5211t9 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205,input5211y: value5211t5, input5211v: value5211t10 },
      ],

      // yearTable52112: [
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 201, input52112y: value5211t11, input52112v: value5211t16 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 202, input52112y: value5211t12, input52112v: value5211t17 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 203, input52112y: value5211t13, input52112v: value5211t18 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 204,input52112y: value5211t14, input52112v: value5211t19 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 205, input52112y: value5211t15, input52112v: value5211t20 },
      // ],
      universityYearTable5221: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201, input5221y: value5221t1, input5221v: value5221t6 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202, input5221y: value5221t2, input5221v: value5221t7 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203, input5221y: value5221t3, input5221v: value5221t8 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204, input5221y: value5221t4, input5221v: value5221t9 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205, input5221y: value5221t5, input5221v: value5221t10 },
      ],
      // universityYearTable52212: [
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 201, input52212y: value5221t11, input52212v: value5221t16 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1 : 202, input52212y: value5221t12, input52212v: value5221t17 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 203, input52212y: value5221t13, input52212v: value5221t18 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 204, input52212y: value5221t14, input52212v: value5221t19 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 205, input52212y: value5221t15, input52212v: value5221t20 },
      // ],
      // yearTable5231: [
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 201,input5231y: value5231t1, input5231v: value5231t6 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 202, input5231y: value5231t2, input5231v: value5231t7 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 203, input5231y: value5231t3, input5231v: value5231t8 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 204, input5231y: value5231t4, input5231v: value5231t9 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 205, input5231y: value5231t5, input5231v: value5231t10 },
      // ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form52Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form52Data.append('criteria5Fieldinfo', jsonBlob(inputDataList));
    if (pathValue5212f1 !== '') {
      form52Data.append(
        'uploadfile5',
        value5212f1,
        'f5212f1-' + value5212f1.name
      );
    }
    if (pathValue5212f2 !== '') {
      form52Data.append(
        'uploadfile5',
        value5212f2,
        'f5212f2-' + value5212f2.name
      );
    }
    if (pathValue5212f3 !== '') {
      form52Data.append(
        'uploadfile5',
        value5212f3,
        'f5212f3-' + value5212f3.name
      );
    }

    if (pathValue5221f1 !== '') {
      form52Data.append(
        'uploadfile5',
        value5221f1,
        'f5221f1-' + value5221f1.name
      );
    }
    if (pathValue5221f2 !== '') {
      form52Data.append(
        'uploadfile5',
        value5221f2,
        'f5221f2-' + value5221f2.name
      );
    }
    if (pathValue5221f3 !== '') {
      form52Data.append(
        'uploadfile5',
        value5221f3,
        'f5221f3-' + value5221f3.name
      );
    }
    if (pathValue5231f1 !== '') {
      form52Data.append(
        'uploadfile5',
        value5231f1,
        'f5231f1-' + value5231f1.name
      );
    }
    if (pathValue5231f2 !== '') {
      form52Data.append(
        'uploadfile5',
        value5231f2,
        'f5231f2-' + value5231f2.name
      );
    }
    if (pathValue5231f3 !== '') {
      form52Data.append(
        'uploadfile5',
        value5231f3,
        'f5231f3-' + value5231f3.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form52Data,
    }
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
    <div className="c52-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c52x-colorIndicator-container">
        <p className="c52x-QlcolorIndicator-circle-style"></p>
        <span className="c52x-colorIndicator-span-style">Qualitative</span>
        <p className="c52x-QtcolorIndicator-circle-style"></p>
        <span className="c52x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c52x-weightage-heading-style">
            Key Indicator Weightage: 30
          </h1>
        </div>
      </div>

      {/* Key Indicator: 5.2.1 */}
      <div className="c52x-eachInputField-container">
        <div className="c52x-weightage-container">
          <h1 className="c52x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c52x-container">
            <div className="c52x-heading_Help-container">
              <h1 className="c52x-heading-style">
                <span className="c52x-span-style">5.2.1: </span>
                Percentage of placement of outgoing students during the last five years
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
                >(Total number of outgoing students placed) / ((1.2 Total number of outgoing final year students)−(5.2.2.1 Total 𝑝𝑟𝑜𝑔𝑟𝑒𝑠𝑠𝑒𝑑 𝑡𝑜 ℎ𝑖𝑔ℎ𝑒𝑟 𝑒𝑑𝑢𝑐𝑎𝑡𝑖𝑜𝑛)) * 100</HelpButton>
            </div>
            <div className="c52x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus521(!responseButtonStatus521); onClickingViewResponse521();
                }}
                className="c52x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus521 ? (
                <p className="c51x-responseResult-style">{responseValue521}</p>
              ) : null}
            </div>
          </div>
          <div className="c52xx-container">
            <h1 className="c52x-heading-style">
              <span className="c52x-span-style">5.2.1.1 </span>
           Number of outgoing students placed year wise during the last five years
            </h1>
            <table className="c52x-Qt-table-style">
              <tr>
                <th className="c52x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue5211t1(e.target.value)}
                      id="5211-t1"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t1}
                    />
                    {value5211t1 === '' ? (
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
                      onChange={(e) => setValue5211t2(e.target.value)}
                      id="5211-t2"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t2}
                    />
                    {value5211t2 === '' ? (
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
                      onChange={(e) => setValue5211t3(e.target.value)}
                      id="5211-t3"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t3}
                    />
                    {value5211t3 === '' ? (
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
                      onChange={(e) => setValue5211t4(e.target.value)}
                      id="5211-t4"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t4}
                    />
                    {value5211t4 === '' ? (
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
                      onChange={(e) => setValue5211t5(e.target.value)}
                      id="5211-t5"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t5}
                    />
                    {value5211t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c52x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => { setValue5211t6(e.target.value); onClickingViewResponse521(); }}
                      id="5211-t6"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t6}
                    />
                    {value5211t6 === '' ? (
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
                      onChange={(e) => { setValue5211t7(e.target.value); onClickingViewResponse521(); }}
                      id="5211-t7"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t7}
                    />
                    {value5211t7 === '' ? (
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
                      onChange={(e) => { setValue5211t8(e.target.value); onClickingViewResponse521(); }}
                      id="5211-t8"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t8}
                    />
                    {value5211t8 === '' ? (
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
                      onChange={(e) => { setValue5211t9(e.target.value); onClickingViewResponse521(); }}
                      id="5211-t9"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t9}
                    />
                    {value5211t9 === '' ? (
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
                      onChange={(e) => { setValue5211t10(e.target.value); onClickingViewResponse521(); }}
                      id="5211-t10"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t10}
                    />
                    {value5211t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
           
           
            <table className="c52x-table-style">
              <tr>
                <th className="c52x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c52x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c52x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c52x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Upload supporting data for student/alumni</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5212f1(e.target.files[0]);
                      setPathValue5212f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5212-f1"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5212f1 === '' ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                             <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5212f1("");
                      document.getElementById("5212-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5212f2(e.target.files[0]);
                      setPathValue5212f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5212-f2"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5212f2 === '' ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                           <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5212f2("");
                      document.getElementById("5212-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Number of students qualifying in state/ national/
                  international level examinations during the last five years(Data Template)</td>
                <td>
                <a href={downloadFile("un5.2.1.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5212f3(e.target.files[0]);
                      setPathValue5212f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5212-f3"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5212f3 === '' ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                           <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5212f3("");
                      document.getElementById("5212-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 5.2.2 */}
      <div className="c52x-eachInputField-container">
        <div className="c52x-weightage-container">
          <h1 className="c52x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c52x-container">
            <div className="c52x-heading_Help-container">
              <h1 className="c52x-heading-style">
                <span className="c52x-span-style">5.2.2: </span>
                Average percentage of placement of outgoing students during the
                last five years
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
                ><h1>(Total Number of outgoing students progressing to higher education) / ((1.2 Total final year outgoing students)−(5.2.1.1:𝑇𝑜𝑡𝑎𝑙 𝑛𝑢𝑚𝑏𝑒𝑟 𝑜𝑓 Students placed)) * 100</h1></HelpButton>
            </div>
            <div className="c52x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus522(!responseButtonStatus522); onClickingViewResponse522();
                }}
                className="c52x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus522 ? (
                <p className="c51x-responseResult-style">{responseValue522}</p>
              ) : null}
            </div>
          </div>
          <div className="c52xx-container">
            <h1 className="c52x-heading-style">
              <span className="c52x-span-style">5.2.2.1 </span>
            Number of outgoing students progressing to higher education
            </h1>
            {/* <table className="c52x-Qt-table-style">
              <tr>
                <th className="c52x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue5221t1(e.target.value)}
                      id="5221-t1"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t1}
                    />
                    {value5221t1 === '' ? (
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
                      onChange={(e) => setValue5221t2(e.target.value)}
                      id="5221-t2"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t2}
                    />
                    {value5221t2 === '' ? (
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
                      onChange={(e) => setValue5221t3(e.target.value)}
                      id="5221-t3"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t3}
                    />
                    {value5221t3 === '' ? (
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
                      onChange={(e) => setValue5221t4(e.target.value)}
                      id="5221-t4"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t4}
                    />
                    {value5221t4 === '' ? (
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
                      onChange={(e) => setValue5221t5(e.target.value)}
                      id="5221-t5"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t5}
                    />
                    {value5221t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c52x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => { setValue5221t6(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t6"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t6}
                    />
                    {value5221t6 === '' ? (
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
                      onChange={(e) => { setValue5221t7(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t7"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t7}
                    />
                    {value5221t7 === '' ? (
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
                      onChange={(e) => { setValue5221t8(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t8"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t8}
                    />
                    {value5221t8 === '' ? (
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
                      onChange={(e) => { setValue5221t9(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t9"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t9}
                    />
                    {value5221t9 === '' ? (
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
                      onChange={(e) => { setValue5221t10(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t10"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t10}
                    />
                    {value5221t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> 

            {/* <table className="c52x-Qt-table-style">
              <tr>
                <th className="c52x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue5221t11(e.target.value)}
                      id="5221-t11"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t11}
                    />
                    {value5221t11 === '' ? (
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
                      onChange={(e) => setValue5221t12(e.target.value)}
                      id="5221-t12"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t12}
                    />
                    {value5221t12 === '' ? (
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
                      onChange={(e) => setValue5221t13(e.target.value)}
                      id="5221-t13"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t13}
                    />
                    {value5221t13 === '' ? (
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
                      onChange={(e) => setValue5221t14(e.target.value)}
                      id="5221-t14"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t14}
                    />
                    {value5221t14 === '' ? (
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
                      onChange={(e) => setValue5221t15(e.target.value)}
                      id="5221-t15"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t15}
                    />
                    {value5221t15 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c52x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => { setValue5221t16(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t16"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t16}
                    />
                    {value5221t16 === '' ? (
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
                      onChange={(e) => { setValue5221t17(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t17"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t17}
                    />
                    {value5221t17 === '' ? (
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
                      onChange={(e) => { setValue5221t18(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t18"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t18}
                    />
                    {value5221t18 === '' ? (
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
                      onChange={(e) => { setValue5221t19(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t19"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t19}
                    />
                    {value5221t19 === '' ? (
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
                      onChange={(e) => { setValue5221t20(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t20"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t20}
                    />
                    {value5221t20 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> */}
            <table className="c52x-table-style">
              <tr>
                <th className="c52x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c52x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c52x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c52x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Self attested list of students placed</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5221f1(e.target.files[0]);
                      setPathValue5221f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5221-f1"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5221f1 === '' ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                           <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5221f1("");
                      document.getElementById("5221-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5221f2(e.target.files[0]);
                      setPathValue5221f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5221-f2"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5221f2 === '' ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5221f2("");
                      document.getElementById("5221-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Details of student placement during the last five years(Data Template)</td>
                <td>
                <a href={downloadFile("un5.2.2.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5221f3(e.target.files[0]);
                      setPathValue5221f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5221-f3"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5221f3 === '' ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                           <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5221f3("");
                      document.getElementById("5221-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 5.2.3 */}
      <div className="c52x-eachInputField-container">
        <div className="c52x-weightage-container">
          <h1 className="c52x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c53x-container">
            <div className="c53x-heading_Help-container">
              <h1 className="c53x-heading-style">
                <span className="c53x-span-style">5.2.3: </span>
                Percentage of students qualifying in state/National/International level 
              Examination during last five years (eg. SLET, NET, UPSC etc)
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
                ><h1>(Number of students qualifying in state/National/International level Examination) / ( 1.2 Total final year−outgoing students ) * 100</h1></HelpButton>
            </div>
            <div className="c52x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus523(!responseButtonStatus523); onClickingViewResponse523();
                }}
                className="c52x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus523 ? (
                <p className="c52x-responseResult-style">{responseValue523}</p>
              ) : null}
            </div>
          </div>
          <div className="c52xx-container">
            <h1 className="c52xx-Heading-style">
              <span className="c52xx-span-style">5.2.3.1: </span>
           Number of students qualifying in state/National/International 
             level Examination during last five years (eg. SLET, NET, UPSC etc)

            </h1>
            {/* <table className="c52x-Qt-table-style">
              <tr>
                <th className="c52x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue5231t1(e.target.value)}
                      id="5231-t1"
                      className="c52x-input-style"
                      type="number"
                      value={value5231t1}
                    />
                    {value5231t1 === '' ? (
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
                      onChange={(e) => setValue5231t2(e.target.value)}
                      id="5231-t2"
                      className="c52x-input-style"
                      type="number"
                      value={value5231t2}
                    />
                    {value5231t2 === '' ? (
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
                      onChange={(e) => setValue5231t3(e.target.value)}
                      id="5231-t3"
                      className="c52x-input-style"
                      type="number"
                      value={value5231t3}
                    />
                    {value5231t3 === '' ? (
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
                      onChange={(e) => setValue5231t4(e.target.value)}
                      id="5231-t4"
                      className="c52x-input-style"
                      type="number"
                      value={value5231t4}
                    />
                    {value5231t4 === '' ? (
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
                      onChange={(e) => setValue5231t5(e.target.value)}
                      id="5231-t5"
                      className="c52x-input-style"
                      type="number"
                      value={value5231t5}
                    />
                    {value5231t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c52x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => { setValue5231t6(e.target.value); onClickingViewResponse523(); }}
                      id="5231-t6"
                      className="c52x-input-style"
                      type="number"
                      value={value5231t6}
                    />
                    {value5231t6 === '' ? (
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
                      onChange={(e) => { setValue5231t7(e.target.value); onClickingViewResponse523(); }}
                      id="5231-t7"
                      className="c52x-input-style"
                      type="number"
                      value={value5231t7}
                    />
                    {value5231t7 === '' ? (
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
                      onChange={(e) => { setValue5231t8(e.target.value); onClickingViewResponse523(); }}
                      id="5231-t8"
                      className="c52x-input-style"
                      type="number"
                      value={value5231t8}
                    />
                    {value5231t8 === '' ? (
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
                      onChange={(e) => { setValue5231t9(e.target.value); onClickingViewResponse523(); }}
                      id="5231-t9"
                      className="c52x-input-style"
                      type="number"
                      value={value5231t9}
                    />
                    {value5231t9 === '' ? (
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
                      onChange={(e) => { setValue5231t10(e.target.value); onClickingViewResponse523(); }}
                      id="5231-t10"
                      className="c52x-input-style"
                      type="number"
                      value={value5231t10}
                    />
                    {value5231t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> */}
            <table className="c52x-table-style">
              <tr>
                <th className="c52x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c52x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c52x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c52x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Upload supporting data for student/alumni</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5231f1(e.target.files[0]);
                      setPathValue5231f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5231-f1"
                    type="file"
                    className="c53-fileButton-style"
                  />
                  {pathValue5231f1 === '' ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                             <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5231f1("");
                      document.getElementById("5231-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5231f2(e.target.files[0]);
                      setPathValue5231f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5231-f2"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5231f2 === '' ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                               <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5231f2("");
                      document.getElementById("5231-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                Details of student progression to higher education (Data Template)
                </td>
                <td>
                <a href={downloadFile("un5.2.3.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5231f3(e.target.files[0]);
                      setPathValue5231f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5231-f3"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5231f3 === '' ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                               <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5231f3("");
                      document.getElementById("5231-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      <div className="c52x-button-container">
        <button onClick={onClickingSave} className="c52x-button-style">Save</button>
      </div>
    </div>
  );
}

export default Criteria52;
