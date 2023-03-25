import React, { useState } from 'react';
import './c25-style.css';
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
function Help251(props) {
  return props.isHelp251Clicked ? (
    <div className="c25x-help-mainContainer">
      <div className="c25x-help-subContainer">
        <h1 className="c25x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c25x-help-para-style">
          Number of days from the date of last semester-end/ year- end
          examination till the declaration of results year wise during the last
          five years
        </p>
        <button
          className="c25x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp251Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help252(props) {
  return props.isHelp252Clicked ? (
    <div className="c25x-help-mainContainer">
      <div className="c25x-help-subContainer">
        <h1 className="c25x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c12x-help-para-style">
          Percentage per year<span style={{ fontWeight: 'bold' }}>=</span>
          <span style={{ fontWeight: 'bold' }}>(</span>Number of complaints or
          grievances about evaluation
          <span style={{ fontWeight: 'bold' }}>) /</span>
          <span style={{ fontWeight: 'bold' }}>(</span>Total number of students
          appeared for examinations
          <span style={{ fontWeight: 'bold' }}>) *</span>100
        </p>
        <p className="c13x-help-para-style">
          Average percentage<span style={{ fontWeight: 'bold' }}>=</span>
          <span style={{ fontWeight: 'bold' }}>(</span> ΣPercentage per year
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>
        <button
          className="c25x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp252Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help253(props) {
  return props.isHelp253Clicked ? (
    <div className="c25x-help-mainContainer">
      <div className="c25x-help-subContainer">
        <h1 className="c25x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c25x-help-para-style">
          Describe the examination reforms with reference to the following
          within a minimum of 500 words and maximum 1000 words.
          <br />
          • Examination procedures
          <br />
          • Processes integrating IT
          <br />• Continuous internal assessment system
        </p>
        <button
          className="c25x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp253Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help254(props) {
  return props.isHelp254Clicked ? (
    <div className="c25x-help-mainContainer">
      <div className="c25x-help-subContainer">
        <h1 className="c25x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c25x-help-para-style">
        (Opt any one)
        </p>
        <button
          className="c25x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp254Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria25() {

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

  const [value2511t1, setValue2511t1] = useState();
  const [value2511t2, setValue2511t2] = useState();
  const [value2511t3, setValue2511t3] = useState();
  const [value2511t4, setValue2511t4] = useState();
  const [value2511t5, setValue2511t5] = useState();
  const [value2511t6, setValue2511t6] = useState();
  const [value2511t7, setValue2511t7] = useState();
  const [value2511t8, setValue2511t8] = useState();
  const [value2511t9, setValue2511t9] = useState();
  const [value2511t10, setValue2511t10] = useState();

  const [pathValue2511f1, setPathValue2511f1] = useState('');
  const [value2511f1, setValue2511f1] = useState([]);
  const [pathValue2511f2, setPathValue2511f2] = useState('');
  const [value2511f2, setValue2511f2] = useState([]);

  const [value2521t1, setValue2521t1] = useState();
  const [value2521t2, setValue2521t2] = useState();
  const [value2521t3, setValue2521t3] = useState();
  const [value2521t4, setValue2521t4] = useState();
  const [value2521t5, setValue2521t5] = useState();
  const [value2521t6, setValue2521t6] = useState();
  const [value2521t7, setValue2521t7] = useState();
  const [value2521t8, setValue2521t8] = useState();
  const [value2521t9, setValue2521t9] = useState();
  const [value2521t10, setValue2521t10] = useState();
  const [value2521t11, setValue2521t11] = useState();
  const [value2521t12, setValue2521t12] = useState();
  const [value2521t13, setValue2521t13] = useState();
  const [value2521t14, setValue2521t14] = useState();
  const [value2521t15, setValue2521t15] = useState();
  const [value2521t16, setValue2521t16] = useState();
  const [value2521t17, setValue2521t17] = useState();
  const [value2521t18, setValue2521t18] = useState();
  const [value2521t19, setValue2521t19] = useState();
  const [value2521t20, setValue2521t20] = useState();
  const [pathValue2521f1, setPathValue2521f1] = useState('');
  const [pathValue2521f2, setPathValue2521f2] = useState('');
  const [value2521f1, setValue2521f1] = useState([]);
  const [value2521f2, setValue2521f2] = useState('');

  const [value253t1, setValue253t1] = useState();
  const [value253t2, setValue253t2] = useState();
  const [pathValue253f1, setPathValue253f1] = useState('');
  const [pathValue253f2, setPathValue253f2] = useState('');
  const [value253f1, setValue253f1] = useState([]);
  const [value253f2, setValue253f2] = useState([]);

  const [value254t1, setValue254t1] = useState();
  const [value254f1, setValue254f1] = useState();
  const [value254f2, setValue254f2] = useState();
  const [value254f3, setValue254f3] = useState();
  const [value254f4, setValue254f4] = useState();
  const [pathValue254f1, setPathValue254f1] = useState('');
  const [pathValue254f2, setPathValue254f2] = useState('');
  const [pathValue254f3, setPathValue254f3] = useState('');
  const [pathValue254f4, setPathValue254f4] = useState('');

  const [responseButtonStatus251, setResponseButtonStatus251] = useState(false);
  const [responseButtonStatus252, setResponseButtonStatus252] = useState(false);
  const [responseButtonStatus253, setResponseButtonStatus253] = useState(false);
  const [responseButtonStatus254, setResponseButtonStatus254] = useState(false);
  const [responseValue251, setResponseValue251] = useState('');
  const [responseValue252, setResponseValue252] = useState('');
  const [responseValue253, setResponseValue253] = useState('');
  const [responseValue254, setResponseValue254] = useState('');
  const [help251Status, setHelp251Status] = useState(false);
  const [help252Status, setHelp252Status] = useState(false);
  const [help253Status, setHelp253Status] = useState(false);
  const [help254Status, setHelp254Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');
  // response button functionality
  function onClickingViewResponse251() {
    if (
      value2511t6 === ''
      || value2511t7 === ''
      || value2511t8 === ''
      || value2511t9 === ''
      || value2511t10 === ''
      || value2511t6 === undefined
      || value2511t7 === undefined
      || value2511t8 === undefined
      || value2511t9 === undefined
      || value2511t10 === undefined
    ) {
      setResponseValue251('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value2511t6, 10)) === false
      || Number.isInteger(parseInt(value2511t7, 10)) === false
      || Number.isInteger(parseInt(value2511t8, 10)) === false
      || Number.isInteger(parseInt(value2511t9, 10)) === false
      || Number.isInteger(parseInt(value2511t10, 10)) === false
    ) {
      setResponseValue251('Input should be an Integer');
    } else if (
      value2511t6 !== ''
      && value2511t7 !== ''
      && value2511t8 !== ''
      && value2511t9 !== ''
      && value2511t10 !== ''
    ) {
      setResponseValue251(
        parseInt(value2511t6, 10)
          + parseInt(value2511t7, 10)
          + parseInt(value2511t8, 10)
          + parseInt(value2511t9, 10)
          + parseInt(value2511t10, 10)
      );
    }
  }

  function onClickingViewResponse252() {
    if (
      value2521t6 === ''
      || value2521t7 === ''
      || value2521t8 === ''
      || value2521t9 === ''
      || value2521t10 === ''
      || value2521t16 === ''
      || value2521t17 === ''
      || value2521t18 === ''
      || value2521t19 === ''
      || value2521t20 === ''
      || value2521t6 === undefined
      || value2521t7 === undefined
      || value2521t8 === undefined
      || value2521t9 === undefined
      || value2521t10 === undefined
      || value2521t16 === undefined
      || value2521t17 === undefined
      || value2521t18 === undefined
      || value2521t19 === undefined
      || value2521t20 === undefined
    ) {
      setResponseValue252('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value2521t6, 10)) === false
      || Number.isInteger(parseInt(value2521t7, 10)) === false
      || Number.isInteger(parseInt(value2521t8, 10)) === false
      || Number.isInteger(parseInt(value2521t9, 10)) === false
      || Number.isInteger(parseInt(value2521t10, 10)) === false
      || Number.isInteger(parseInt(value2521t16, 10)) === false
      || Number.isInteger(parseInt(value2521t17, 10)) === false
      || Number.isInteger(parseInt(value2521t18, 10)) === false
      || Number.isInteger(parseInt(value2521t19, 10)) === false
      || Number.isInteger(parseInt(value2521t20, 10)) === false
    ) {
      setResponseValue252('Input should be an Integer');
    } else if (
      value2521t6 !== ''
      && value2521t7 !== ''
      && value2521t8 !== ''
      && value2521t9 !== ''
      && value2521t10 !== ''
      && value2521t16 !== ''
      && value2521t17 !== ''
      && value2521t18 !== ''
      && value2521t19 !== ''
      && value2521t20 !== ''
    ) {
      setResponseValue252(
        
          ((value2521t6 / value2521t16) * 100
            + (value2521t7 / value2521t17) * 100
            + (value2521t8 / value2521t18) * 100
            + (value2521t9 / value2521t19) * 100
            + (value2521t10 / value2521t20) * 100)
            / 5
        
      );
    }
  }

  function onClickingViewResponse254() {
    if (value254t1 === '' || value254t1 === undefined || value254t1 === null) {
      setResponseValue254('Please select any option');
    } else {
      setResponseValue254(value254t1);
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
    criteria25Ql: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
        input253t1: value253t1,
        input254t1: value254t1,
        response253: responseValue253,
        response254: responseValue254,
      
       },
      ],
      criteria25Qn: [
          { 
            criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
            uniqueKey1: 201,
      response251: responseValue251,
      response252: responseValue252,
      criteria25status:"save"
    },
   ],
      yearTable2511: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 201,input2511y: value2511t1, input2511v: value2511t6 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 202,input2511y: value2511t2, input2511v: value2511t7 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 203,input2511y: value2511t3, input2511v: value2511t8 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 204,input2511y: value2511t4, input2511v: value2511t9 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 205,input2511y: value2511t5, input2511v: value2511t10 },
      ],
      yearTable2521: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 201, input2521y: value2521t1, input2521v: value2521t6 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 202, input2521y: value2521t2, input2521v: value2521t7 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 203,input2521y: value2521t3, input2521v: value2521t8 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 204,input2521y: value2521t4, input2521v: value2521t9 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 205,input2521y: value2521t5, input2521v: value2521t10 },
      ],
      yearTable25212: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 201,input25212y: value2521t1, input25212v: value2521t6 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 202,input25212y: value2521t2, input25212v: value2521t7 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 203,input25212y: value2521t3, input25212v: value2521t8 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 204,input25212y: value2521t4, input25212v: value2521t9 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 205,input25212y: value2521t5, input25212v: value2521t10 },
      ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form25Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form25Data.append('criteria2Fieldinfo', jsonBlob(inputDataList));
    if (pathValue2511f1 !== '') {
      form25Data.append(
        'uploadfile2',
        value2511f1,
        'f2511f1-' + value2511f1.name
      );
    }
    if (pathValue2511f2 !== '') {
      form25Data.append(
        'uploadfile2',
        value2511f2,
        'f2511f2-' + value2511f2.name
      );
    }
    if (pathValue2521f1 !== '') {
      form25Data.append(
        'uploadfile2',
        value2521f1,
        'f2521f1-' + value2521f1.name
      );
    }
    if (pathValue2521f2 !== '') {
      form25Data.append(
        'uploadfile2',
        value2521f1,
        'f2521f2-' + value2521f2.name
      );
    }
    if (pathValue253f1 !== '') {
      form25Data.append('uploadfile2', value253f1, 'f253f1-' + value253f1.name);
    }
    if (pathValue253f2 !== '') {
      form25Data.append('uploadfile2', value253f2, 'f253f2-' + value253f2.name);
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form25Data,
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
  // rendering dom
  return (
    <div className="c25-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c25x-colorIndicator-container">
        <p className="c25x-QlcolorIndicator-circle-style"></p>
        <span className="c25x-colorIndicator-span-style">Qualitative</span>
        <p className="c25x-QtcolorIndicator-circle-style"></p>
        <span className="c25x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c25x-weightage-heading-style">
            Key Indicator Weightage: 50
          </h1>
        </div>
      </div>
      {/* Key Indicator: 2.5.1 */}
      <div className="c25x-eachInputField-container">
        <div className="c25x-weightage-container">
          <h1 className="c25x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c25x-container">
            <div className="c25x-heading_Help-container">
              <h1 className="c25x-heading-style">
                <span className="c25x-span-style">2.5.1: </span>
                Average number of days from the date of last semester-end/ year- end 
                examination till the last date of declaration of results year-wise during 
                the last five years              </h1>
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
                >Total Number of days from the date of
                last semester − end/ year − end examination till the last date declaration of results
                5</HelpButton>
            </div>
            <div className="c25x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus251(!responseButtonStatus251);
                  onClickingViewResponse251();
                }}
                className="c25x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus251 ? (
                <p className="c21x-responseResult-style">{responseValue251}</p>
              ) : null}
            </div>
          </div>
          <div className="c25xx-container">
            <h1 className="c25xx-Heading-style">
              <span className="c25xx-span-style">2.5.1.1: </span>
              Number of days from the date of last semester-end/ year- end 
              examination till the last date declaration of results year-wise during the last five 
              years
            </h1>
            <table className="c25x-Qt-table-style">
              <tr>
                <th className="c25x-horizontalTable-heading-style">Assessment Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue2511t1(e.target.value)}
                      id="2511-t1"
                      className="c25x-input-style"
                      type="number"
                      value={value2511t1}
                    />
                    {value2511t1 === '' ? (
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
                      onChange={(e) => setValue2511t2(e.target.value)}
                      id="2511-t2"
                      className="c25x-input-style"
                      type="number"
                      value={value2511t2}
                    />
                    {value2511t2 === '' ? (
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
                      onChange={(e) => setValue2511t3(e.target.value)}
                      id="2511-t3"
                      className="c25x-input-style"
                      type="number"
                      value={value2511t3}
                    />
                    {value2511t3 === '' ? (
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
                      onChange={(e) => setValue2511t4(e.target.value)}
                      id="2511-t4"
                      className="c25x-input-style"
                      type="number"
                      value={value2511t4}
                    />
                    {value2511t4 === '' ? (
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
                      onChange={(e) => setValue2511t5(e.target.value)}
                      id="2511-t5"
                      className="c25x-input-style"
                      type="number"
                      value={value2511t5}
                    />
                    {value2511t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c25x-horizontalTable-heading-style">Number of days
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
                        setValue2511t6(e.target.value);
                        onClickingViewResponse251();
                      }}
                      id="2511-t6"
                      className="c25x-input-style"
                      type="number"
                      value={value2511t6}
                    />
                    {value2511t6 === '' ? (
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
                        setValue2511t7(e.target.value);
                        onClickingViewResponse251();
                      }}
                      id="2511-t7"
                      className="c25x-input-style"
                      type="number"
                      value={value2511t7}
                    />
                    {value2511t7 === '' ? (
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
                        setValue2511t8(e.target.value);
                        onClickingViewResponse251();
                      }}
                      id="2511-t8"
                      className="c25x-input-style"
                      type="number"
                      value={value2511t8}
                    />
                    {value2511t8 === '' ? (
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
                        setValue2511t9(e.target.value);
                        onClickingViewResponse251();
                      }}
                      id="2511-t9"
                      className="c25x-input-style"
                      type="number"
                      value={value2511t9}
                    />
                    {value2511t9 === '' ? (
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
                        setValue2511t10(e.target.value);
                        onClickingViewResponse251();
                      }}
                      id="2511-t10"
                      className="c25x-input-style"
                      type="number"
                      value={value2511t10}
                    />
                    {value2511t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <table className="c25x-table-style">
              <tr>
                <th className="c25x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c25x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c25x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c25x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Exam timetable released by the Controller of Examination</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2511f1(e.target.files[0]);
                      setPathValue2511f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2511-f1"
                    className="c25-fileButton-style"
                    type="file"
                  />
                  {pathValue2511f1 === '' ? null : (
                    <div className="c25-fileButtons-container">
                      <button className="c25-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2511f1("");
                      document.getElementById("2511-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c25x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                Result Sheet with date of publication
                </td>
                <td><a href={downloadFile("un2.5.1.xlsx")} target="_blank">View Template</a></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2511f2(e.target.files[0]);
                      setPathValue2511f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2511-f2"
                    className="c25-fileButton-style"
                    type="file"
                  />
                  {pathValue2511f2 === '' ? null : (
                    <div className="c25-fileButtons-container">
                      <button className="c25-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2511f2("");
                      document.getElementById("2511-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c25x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                Policy document on Declaration of results (if any)
                </td>
                <td><a href={downloadFile("un2.5.1.xlsx")} target="_blank">View Template</a></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2511f2(e.target.files[0]);
                      setPathValue2511f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2511-f2"
                    className="c25-fileButton-style"
                    type="file"
                  />
                  {pathValue2511f2 === '' ? null : (
                    <div className="c25-fileButtons-container">
                      <button className="c25-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2511f2("");
                      document.getElementById("2511-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c25x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 2.5.2 */}
      <div className="c25x-eachInputField-container">
        <div className="c25x-weightage-container">
          <h1 className="c25x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c25x-container">
            <div className="c25x-heading_Help-container">
              <h1 className="c25x-heading-style">
                <span className="c25x-span-style">2.5.2: </span>
                Percentage of student complaints/grievances about evaluation against 
              total number of students appeared in the examinations during the last 
              five  years             </h1>
              <button
                onClick={handleHelpOpen2}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen2}
                handleClose={handleHelpClose2}
                title='Formula:                '
                >Total Number of complaints or grievances
                about evaluation
                Total Number of students appeared
                in the examination
                X 100</HelpButton>
            </div>
            <div className="c25x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus252(!responseButtonStatus252);
                  onClickingViewResponse252();
                }}
                className="c25x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus252 ? (
                <p className="c25x-responseResult-style">{responseValue252}</p>
              ) : null}
            </div>
          </div>
          <div className="c25xx-container">
            <h1 className="c25xx-Heading-style">
              <span className="c25xx-span-style">2.5.2.1: </span>
              Number of complaints/grievances about evaluation year-wise 
              during the last five years
            </h1>
            <h1 className="c25xx-Heading-style">
              <span className="c25xx-span-style">2.5.2.2: </span>
              Total number of students appeared in the examinations year-wise 
                during the last five years

            </h1>
            <table className="c25x-Qt-table-style">
              <tr>
                <th className="c25x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue2521t1(e.target.value)}
                      id="2521-t1"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t1}
                    />
                    {value2521t1 === '' ? (
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
                      onChange={(e) => setValue2521t2(e.target.value)}
                      id="2521-t2"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t2}
                    />
                    {value2521t2 === '' ? (
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
                      onChange={(e) => setValue2521t3(e.target.value)}
                      id="2521-t3"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t3}
                    />
                    {value2521t3 === '' ? (
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
                      onChange={(e) => setValue2521t4(e.target.value)}
                      id="2521-t4"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t4}
                    />
                    {value2521t4 === '' ? (
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
                      onChange={(e) => setValue2521t5(e.target.value)}
                      id="2521-t5"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t5}
                    />
                    {value2521t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c25x-horizontalTable-heading-style">
                Number of complaints/grievances
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
                        setValue2521t6(e.target.value);
                        onClickingViewResponse252();
                      }}
                      id="2521-t6"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t6}
                    />
                    {value2521t6 === '' ? (
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
                        setValue2521t7(e.target.value);
                        onClickingViewResponse252();
                      }}
                      id="2521-t7"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t7}
                    />
                    {value2521t7 === '' ? (
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
                        setValue2521t8(e.target.value);
                        onClickingViewResponse252();
                      }}
                      id="2521-t8"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t8}
                    />
                    {value2521t8 === '' ? (
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
                        setValue2521t9(e.target.value);
                        onClickingViewResponse252();
                      }}
                      id="2521-t9"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t9}
                    />
                    {value2521t9 === '' ? (
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
                        setValue2521t10(e.target.value);
                        onClickingViewResponse252();
                      }}
                      id="2521-t10"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t10}
                    />
                    {value2521t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c25x-Qt-table-style">
              <tr>
                <th className="c25x-horizontalTable-heading-style">
                Number of students appeared in the examinations
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
                      onChange={(e) => setValue2521t11(e.target.value)}
                      id="2521-t11"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t11}
                    />
                    {value2521t11 === '' ? (
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
                      onChange={(e) => setValue2521t12(e.target.value)}
                      id="2521-t12"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t12}
                    />
                    {value2521t12 === '' ? (
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
                      onChange={(e) => setValue2521t13(e.target.value)}
                      id="2521-t13"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t13}
                    />
                    {value2521t13 === '' ? (
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
                      onChange={(e) => setValue2521t14(e.target.value)}
                      id="2521-t14"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t14}
                    />
                    {value2521t14 === '' ? (
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
                      onChange={(e) => setValue2521t15(e.target.value)}
                      id="2521-t15"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t15}
                    />
                    {value2521t15 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c25x-horizontalTable-heading-style">
                  Number of Students
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
                        setValue2521t16(e.target.value);
                        onClickingViewResponse252();
                      }}
                      id="2521-t16"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t16}
                    />
                    {value2521t16 === '' ? (
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
                        setValue2521t17(e.target.value);
                        onClickingViewResponse252();
                      }}
                      id="2521-t17"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t17}
                    />
                    {value2521t17 === '' ? (
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
                        setValue2521t18(e.target.value);
                        onClickingViewResponse252();
                      }}
                      id="2521-t18"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t18}
                    />
                    {value2521t18 === '' ? (
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
                        setValue2521t19(e.target.value);
                        onClickingViewResponse252();
                      }}
                      id="2521-t19"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t19}
                    />
                    {value2521t19 === '' ? (
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
                        setValue2521t20(e.target.value);
                        onClickingViewResponse252();
                      }}
                      id="2521-t20"
                      className="c25x-input-style"
                      type="number"
                      value={value2521t20}
                    />
                    {value2521t20 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <table className="c25x-table-style">
              <tr>
                <th className="c25x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c25x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c25x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c25x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2521f1(e.target.files[0]);
                      setPathValue2521f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2521-f1"
                    className="c25-fileButton-style"
                    type="file"
                  />
                  {pathValue2521f1 === '' ? null : (
                    <div className="c25-fileButtons-container">
                      <button className="c25-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2521f1("");
                      document.getElementById("2521-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c21x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Number of complaints and total number of students appeared
                  year wise
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2521f2(e.target.files[0]);
                      setPathValue2521f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2521-f2"
                    className="c25-fileButton-style"
                    type="file"
                  />
                  {pathValue2521f2 === '' ? null : (
                    <div className="c25-fileButtons-container">
                      <button className="c25-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2521f2("");
                      document.getElementById("2521-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c21x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 2.5.3
      <div className="c25x-eachInputField-container">
        <div className="c25x-weightage-container">
          <h1 className="c25x-weightage-heading-style">Weightage: 8</h1>
        </div>
        <form>
          <div className="c25x-container">
            <div className="c25x-heading_Help-container">
              <h1 className="c25x-heading-style">
                <span className="c25x-span-style">2.5.3: </span>
                IT integration and reforms in the examination procedures and
                processes including Continuous Internal Assessment (CIA) have
                brought in considerable improvement in Examination Management
                System (EMS) of the Institution.
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp253Status(true);
                }}
                className="c25x-helpButton-style"
              >
                Help
              </button>
              <Help253
                isHelp253Clicked={help253Status}
                setIsHelp253Clicked={setHelp253Status}
              />
            </div>
            <label htmlFor="253-t1" className="c25x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue253t1(e.target.value);
                setResponseValue253(e.target.value);
              }}
              value={value253t1}
              rows={10}
              className="c25x-textarea-style"
              id="253-t1"
            ></textarea>
            {value253t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c25x-table-style">
            <tr>
              <th className="c25x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c25x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c25x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c25x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Any additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue253f1(e.target.files[0]);
                    setPathValue253f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="253-f1"
                  className="c25-fileButton-style"
                  type="file"
                />
                {pathValue253f1 === '' ? null : (
                  <div className="c25-fileButtons-container">
                    <button className="c25-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue253f1("");
                      document.getElementById("253-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c25x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Link for Additional Information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue253f2(e.target.files[0]);
                    setPathValue253f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="253-f2"
                  className="c25-fileButton-style"
                  type="file"
                />
                {pathValue253f2 === '' ? null : (
                  <div className="c25-fileButtons-container">
                    <button className="c25-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue253f2("");
                      document.getElementById("253-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c25x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div> */}
      {/* Key Indicator: 2.5.3 */}
      <div className="c25x-eachInputField-container">
        <div className="c25x-weightage-container">
          <h1 className="c25x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c25x-container">
            <div className="c25x-heading_Help-container">
              <div>
                <h1 className="c25x-heading-style">
                  <span className="c25x-span-style">2.5.3: </span>
                  Status of automation of Examination division along with approved 
                  Examination Manual/ordinance
                  A. 100% automation of entire division & implementation of 
                  Examination Management System (EMS)
                  B. Only student registration, Hall ticket issue & Result Processing
                  C. Only student registration and result processing
                  D. Only result processing
                  E. Only manual methodology
                </h1>

                <div className="c25x-radio-container">
                  <div className="c25x-radio-subContainer">
                    <div className="c25x-eachRadio-container">
                      <input
                        onChange={(e) => {
                          setValue254t1(e.target.value);
                        }}
                        name="254options"
                        value="100% automation of entire division & implementation of
                        Examination Management System (EMS)"
                        id="254-t1"
                        type="radio"
                      />
                      <label className="c25x-radioLabel-style" for="254-t1">
                      A. 100% automation of entire division & implementation of
                         Examination Management System (EMS)
                      </label>
                    </div>

                    <div className="c25x-eachRadio-container">
                      <input
                        onChange={(e) => {
                          setValue254t1(e.target.value);
                        }}
                        name="254options"
                        value="Only student registration, Hall ticket issue & Result Processing"
                        id="254-t1"
                        type="radio"
                      />

                      <label className="c25x-radioLabel-style" for="254-t1">
                      B. Only student registration, Hall ticket issue & Result Processing
                      </label>
                    </div>

                    <div className="c25x-eachRadio-container">
                      <input
                        onChange={(e) => {
                          setValue254t1(e.target.value);
                        }}
                        name="254options"
                        value="Only student registration and result processing"
                        id="254-t1"
                        type="radio"
                      />

                      <label className="c25x-radioLabel-style" for="254-t1">
                      C. Only student registration and result processing
                      </label>
                    </div>
                  </div>

                  <div className="c25x-radio-subContainer">
                    <div className="c25x-eachRadio-container">
                      <input
                        onChange={(e) => {
                          setValue254t1(e.target.value);
                        }}
                        name="254options"
                        value="Only result processing"
                        id="254-t1"
                        type="radio"
                      />

                      <label className="c43x-radioLabel-style" for="254-t1">
                      D. Only result processing
                      </label>
                    </div>

                    <div className="c43x-eachRadio-container">
                      <input
                        onChange={(e) => {
                          setValue254t1(e.target.value);
                        }}
                        name="254options"
                        value="Only manual methodology"
                        id="254-t1"
                        type="radio"
                      />

                      <label className="c25x-radioLabel-style" for="254-t1">
                      E. Only manual methodology
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp254Status(true);
                }}
                className="c25x-helpButton-style"
              >
                Help
              </button>
              <Help254
                isHelp254Clicked={help254Status}
                setIsHelp254Clicked={setHelp254Status}
              />
            </div>
            <div className="c25x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus254(!responseButtonStatus254);
                  onClickingViewResponse254();
                }}
                className="c25x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus254 ? (
                <p className="c25x-responseResult-style">{responseValue254}</p>
              ) : null}
            </div>
          </div>
          <table className="c25x-table-style">
            <tr>
              <th className="c25x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c25x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c25x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c25x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Upload any additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue254f1(e.target.files[0]);
                    setPathValue254f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="254-f1"
                  type="file"
                  className="c25-fileButton-style"
                />
                {pathValue254f1 === '' ? null : (
                  <div className="c25-fileButtons-container">
                    <button className="c25-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue254f1("");
                      document.getElementById("254-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c25x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Institutional data in prescribed format</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue254f2(e.target.files[0]);
                    setPathValue254f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="254-f2"
                  type="file"
                  className="c25-fileButton-style"
                />
                {pathValue254f2 === '' ? null : (
                  <div className="c25-fileButtons-container">
                    <button className="c25-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue254f2("");
                      document.getElementById("254-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c25x-Qt-tableBorders-style">pdf</td>
            </tr>
            {/* <tr>
              <td>Institutional data in prescribed format</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue254f3(e.target.files[0]);
                    setPathValue254f3(e.target.value);
                    showFilePreview(e);
                  }}
                  id="254-f3"
                  type="file"
                  className="c25-fileButton-style"
                />
                {pathValue254f3 === '' ? null : (
                  <div className="c25-fileButtons-container">
                    <button className="c25-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue254f3("");
                      document.getElementById("254-f3").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c25x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Institutional data in prescribed format</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue254f4(e.target.files[0]);
                    setPathValue254f4(e.target.value);
                    showFilePreview(e);
                  }}
                  id="254-f4"
                  type="file"
                  className="c25-fileButton-style"
                />
                {pathValue254f4 === '' ? null : (
                  <div className="c25-fileButtons-container">
                    <button className="c25-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue254f4("");
                      document.getElementById("254-f4").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c25x-Qt-tableBorders-style">pdf</td>
            </tr> */}
          </table>
        </form>
      </div>

      <div className="c25x-button-container">
        <button onClick={onClickingSave} className="c25x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria25;
