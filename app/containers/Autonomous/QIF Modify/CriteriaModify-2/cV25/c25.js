import React, { useState, useEffect } from 'react';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import './c25-style.css';
import { HelpButton } from "../../../../../reusableComponents/model/Help";
import { resources } from "../../../../appConstants";
import { Button } from '@mui/material';

// Alert custom messages start
const successMessage = (message) => {
  toast.success(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "success1",
  });
};
const errorMessage = (message) => {
  toast.error(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "error1",
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
  // const [value253t2, setValue253t2] = useState();
  const [pathValue253f1, setPathValue253f1] = useState('');
  const [pathValue253f2, setPathValue253f2] = useState('');
  const [value253f1, setValue253f1] = useState([]);
  const [value253f2, setValue253f2] = useState([]);

  const [responseButtonStatus251, setResponseButtonStatus251] = useState(false);
  const [responseButtonStatus252, setResponseButtonStatus252] = useState(false);
  const [responseValue251, setResponseValue251] = useState('');
  const [responseValue252, setResponseValue252] = useState('');
  const [responseValue253, setResponseValue253] = useState('');
  const [help251Status, setHelp251Status] = useState(false);
  const [help252Status, setHelp252Status] = useState(false);
  const [help253Status, setHelp253Status] = useState(false);
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
  () => fetch('http://localhost:8080/api/v1/criteria2getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
    (response) => response
      .json()
      .then((data) => {
        console.log(JSON.stringify(data));

        setValue253t1(data[0].criteria25Ql[0] ? data[0].criteria25Ql[0].input253t1 : "");

        setResponseValue251(data[0].criteria25Qn[0] ? data[0].criteria25Qn[0].response251 : "");
        setResponseValue252(data[0].criteria25Qn[0] ? data[0].criteria25Qn[0].response252 : "");

        setValue2511t1(data[0].yearTable2511[0] ? data[0].yearTable2511[0].input2511y : "");
        setValue2511t2(data[0].yearTable2511[1] ? data[0].yearTable2511[1].input2511y : "");
        setValue2511t3(data[0].yearTable2511[2] ? data[0].yearTable2511[2].input2511y : "");
        setValue2511t4(data[0].yearTable2511[3] ? data[0].yearTable2511[3].input2511y : "");
        setValue2511t5(data[0].yearTable2511[4] ? data[0].yearTable2511[4].input2511y : "");
        setValue2511t6(data[0].yearTable2511[0] ? data[0].yearTable2511[0].input2511v : "");
        setValue2511t7(data[0].yearTable2511[1] ? data[0].yearTable2511[1].input2511v : "");
        setValue2511t8(data[0].yearTable2511[2] ? data[0].yearTable2511[2].input2511v : "");
        setValue2511t9(data[0].yearTable2511[3] ? data[0].yearTable2511[3].input2511v : "");
        setValue2511t10(data[0].yearTable2511[4] ? data[0].yearTable2511[4].input2511v : "");

        setValue2521t1(data[0].yearTable2521[0] ? data[0].yearTable2521[0].input2521y : "");
        setValue2521t2(data[0].yearTable2521[1] ? data[0].yearTable2521[1].input2521y : "");
        setValue2521t3(data[0].yearTable2521[2] ? data[0].yearTable2521[2].input2521y : "");
        setValue2521t4(data[0].yearTable2521[3] ? data[0].yearTable2521[3].input2521y : "");
        setValue2521t5(data[0].yearTable2521[4] ? data[0].yearTable2521[4].input2521y : "");
        setValue2521t6(data[0].yearTable2521[0] ? data[0].yearTable2521[0].input2521v : "");
        setValue2521t7(data[0].yearTable2521[1] ? data[0].yearTable2521[1].input2521v : "");
        setValue2521t8(data[0].yearTable2521[2] ? data[0].yearTable2521[2].input2521v : "");
        setValue2521t9(data[0].yearTable2521[3] ? data[0].yearTable2521[3].input2521v : "");
        setValue2521t10(data[0].yearTable2521[4] ? data[0].yearTable2521[4].input2521v : "");

        setValue2521t11(data[0].yearTable25212[0] ? data[0].yearTable25212[0].input25212y : "");
        setValue2521t12(data[0].yearTable25212[1] ? data[0].yearTable25212[1].input25212y : "");
        setValue2521t13(data[0].yearTable25212[2] ? data[0].yearTable25212[2].input25212y : "");
        setValue2521t14(data[0].yearTable25212[3] ? data[0].yearTable25212[3].input25212y : "");
        setValue2521t15(data[0].yearTable25212[4] ? data[0].yearTable25212[4].input25212y : "");
        setValue2521t16(data[0].yearTable25212[0] ? data[0].yearTable25212[0].input25212v : "");
        setValue2521t17(data[0].yearTable25212[1] ? data[0].yearTable25212[1].input25212v : "");
        setValue2521t18(data[0].yearTable25212[2] ? data[0].yearTable25212[2].input25212v : "");
        setValue2521t19(data[0].yearTable25212[3] ? data[0].yearTable25212[3].input25212v : "");
        setValue2521t20(data[0].yearTable25212[4] ? data[0].yearTable25212[4].input25212v : "");

        // setValue2511f1(data[0].criteria2FileUpload[0].criteria2FileName);
        // setValue2511f2(data[0].criteria2FileUpload[1].criteria2FileName);
        // setValue2521f1(data[0].criteria2FileUpload[2].criteria2FileName);
        // setValue2521f2(data[0].criteria2FileUpload[3].criteria2FileName);
        // setValue253f1(data[0].criteria2FileUpload[4].criteria2FileName);
        // setValue253f2(data[0].criteria2FileUpload[5].criteria2FileName);
      })
      .catch((error) => {
        console.error("Error:", error);
      })
  ),
  []
);
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
        setResponseValue252(
          ((value2521t6 / value2521t16) * 100
            + (value2521t7 / value2521t17) * 100
            + (value2521t8 / value2521t18) * 100
            + (value2521t9 / value2521t19) * 100
            + (value2521t10 / value2521t20) * 100)
            / 5
        )
      );
    }
  }


  // sending data to db with API
 
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
    criteria25Ql: [{
      criteriaId: {  collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      uniqueKey1: 1,
      input253t1: value253t1,
      response253: responseValue253,
     
    },
    ],
    criteria25Qn: [{
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      uniqueKey1: 1,
      response251: responseValue251,
      response252: responseValue252,
      criteria25status:"save"
    },
    ],
    yearTable2511: [
      {
        criteriaId: {  collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 1, input2511y: value2511t1, input2511v: value2511t6
      },
      {
        criteriaId: {  collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
         uniqueKey1: 2, input2511y: value2511t2, input2511v: value2511t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 3, input2511y: value2511t3, input2511v: value2511t8
      },
      {
        criteriaId: {  collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
         uniqueKey1: 4, input2511y: value2511t4, input2511v: value2511t9
      },
      {
        criteriaId: {  collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
         uniqueKey1: 5, input2511y: value2511t5, input2511v: value2511t10
      },
    ],
    yearTable2521: [
      {
        criteriaId: {  collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 1, input2521y: value2521t1, input2521v: value2521t6
      },
      {
        criteriaId: {  collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 2, input2521y: value2521t2, input2521v: value2521t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 3, input2521y: value2521t3, input2521v: value2521t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
         uniqueKey1: 4, input2521y: value2521t4, input2521v: value2521t9
      },
      {
        criteriaId: {  collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 5, input2521y: value2521t5, input2521v: value2521t10
      },
    ],
    yearTable25212: [
      {
        criteriaId: {  collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 1, input25212y: value2521t1, input25212v: value2521t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 2, input25212y: value2521t2, input25212v: value2521t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 3, input25212y: value2521t3, input25212v: value2521t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 4, input25212y: value2521t4, input25212v: value2521t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
         uniqueKey1: 5, input25212y: value2521t5, input25212v: value2521t10
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form25Data = new FormData();

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
 
// getfile data with API

function downloadFile(fileName) {
  const filePath = "http://localhost:8080/api/v1/download/" + fileName;
  return filePath;
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
          <h1 className="c25x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c25x-container">
            <div className="c25x-heading_Help-container">
              <h1 className="c25x-heading-style">
                <span className="c25x-span-style">2.5.1: </span>
                Average number of days from the date of last semester-end/ year end examination till the last date of declaration of results during the 
last five years
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
                ><h1>(Total Number of Days / Number of years in the assessment period)</h1></HelpButton>
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
              Number of days from the date of last semester-end/ year- end examination till the last date of declaration of results year wise during 
the last five years
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
                      onChange={(e) => setValue2511t1(e.target.value)}
                      id="2511-t1"
                      className="c25x-input-style"
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
                      value={value2511t5}
                    />
                    {value2511t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c25x-horizontalTable-heading-style">Number of days</th>
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                <td>Any additional information</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue2511f1(e.target.files[0]);
                      setPathValue2511f1(e.target.value);
                    }}
                    id="2511-f1"
                    className="c25-fileButton-style"
                    type="file"
                  />
                  {pathValue2511f1 === '' ? null : (
                    <div className="c25-fileButtons-container">
                      <button className="c25-viewFileButton-style">
                        View File
                      </button>
                      <button className="c25-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                  <a href={downloadFile(value2511f1)} target="_blank">View File</a>
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
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue2511f1(e.target.files[0]);
                    setPathValue2511f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue2511f1}
              {pathValue2511f1 === "" ? null : (
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
                      setPathValue2511f1("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c25x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List of Programmes and date of last semester and date of
                  declaration of result(data Template)
                </td>
                <td><a href={downloadFile("au2.4.1.xlsx")} target="_blank">View Template</a></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue2511f2(e.target.files[0]);
                      setPathValue2511f2(e.target.value);
                    }}
                    id="2511-f2"
                    className="c25-fileButton-style"
                    type="file"
                  />
                  {pathValue2511f2 === '' ? null : (
                    <div className="c25-fileButtons-container">
                      <button className="c25-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2511f2("");
                      document.getElementById("2411-f2").value="" }} >
                       Reset                     
                    </button>

                    </div>
                  )}
                  <a href={downloadFile(value2511f2)} target="_blank">View File</a>
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
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue2511f2(e.target.files[0]);
                      setPathValue2511f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue2511f2}
              {pathValue2511f2 === "" ? null : (
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
                      setPathValue2511f2("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
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
          <h1 className="c25x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c25x-container">
            <div className="c25x-heading_Help-container">
              <h1 className="c25x-heading-style">
                <span className="c25x-span-style">2.5.2: </span>
                Percentage of student complaints/grievances about evaluation 
against total number appeared in the examinations during the last 
five years
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
                title='percentage'
                ><h1>(Total number of complaints or grievanvesabout evaluation )/(Total number of students appeared in the examinations) * 100</h1></HelpButton>
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
              Number of complaints/grievances about evaluation year wise 
              during last five years
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      onChange={(e) => {
                        setValue2521t6(e.target.value);
                        onClickingViewResponse252();
                      }}
                      id="2521-t6"
                      className="c25x-input-style"
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
                      value={value2521t10}
                    />
                    {value2521t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <h1 className="c25xx-Heading-style">
              <span className="c25xx-span-style">2.5.2.2: </span>
              Number of students appeared in the examination conducted 
by the institution year wise during the last five years
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
                      onChange={(e) => setValue2521t11(e.target.value)}
                      id="2521-t11"
                      className="c25x-input-style"
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      onChange={(e) => {
                        setValue2521t16(e.target.value);
                        onClickingViewResponse252();
                      }}
                      id="2521-t16"
                      className="c25x-input-style"
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                      type="text"
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
                  {/* <input
                    onChange={(e) => {
                      setValue2521f1(e.target.files[0]);
                      setPathValue2521f1(e.target.value);
                    }}
                    id="2521-f1"
                    className="c25-fileButton-style"
                    type="file"
                  />
                  {pathValue2521f1 === '' ? null : (
                    <div className="c25-fileButtons-container">
                      <button className="c25-viewFileButton-style">
                        View File
                      </button>

                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2521f1("");
                      document.getElementById("2521-f1").value="" }} >
                       Reset                     
                    </button>

                    </div>
                  )}
                  <a href={downloadFile(value2521f1)} target="_blank">View File</a>
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
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue2521f1(e.target.files[0]);
                      setPathValue2521f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue2521f1}
              {pathValue2521f1 === "" ? null : (
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
                      setPathValue2521f1("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
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
                  {/* <input
                    onChange={(e) => {
                      setValue2521f2(e.target.files[0]);
                      setPathValue2521f2(e.target.value);
                    }}
                    id="2521-f2"
                    className="c25-fileButton-style"
                    type="file"
                  />
                  {pathValue2521f2 === '' ? null : (
                    <div className="c25-fileButtons-container">
                      <button className="c25-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2521f2("");
                      document.getElementById("2521-f2").value="" }} >
                       Reset                     
                    </button>

                    </div>
                  )}
                  <a href={downloadFile(value2521f2)} target="_blank">View File</a>
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
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue2521f2(e.target.files[0]);
                    setPathValue2521f2(e.target.value);;
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue2521f2}
              {pathValue2521f2 === "" ? null : (
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
                      setPathValue2521f2("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
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

      {/* Key Indicator: 2.5.3 */}
      <div className="c25x-eachInputField-container">
        <div className="c25x-weightage-container">
          <h1 className="c25x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c25x-container">
            <div className="c25x-heading_Help-container">
              <h1 className="c25x-heading-style">
                <span className="c25x-span-style">2.5.3: </span>
                IT integration and reforms in the examination procedures and 
processes including Continuous Internal Assessment 
(CIA)/Formative Assessment have brought in considerable 
improvement in Examination Management System (EMS) of the 
Institution

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
                title='Write description in a maximum of 500 words'
                ></HelpButton>
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
                {/* <input
                  onChange={(e) => {
                    setValue253f1(e.target.files[0]);
                    setPathValue253f1(e.target.value);
                  }}
                  id="253-f1"
                  className="c25-fileButton-style"
                  type="file"
                />
                {pathValue253f1 === '' ? null : (
                  <div className="c25-fileButtons-container">
                    <button className="c25-viewFileButton-style">
                      View File
                    </button>

                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue253f1("");
                      document.getElementById("253-f1").value="" }} >
                       Reset                     
                    </button>

                  </div>
                )}
                <a href={downloadFile(value253f1)} target="_blank">View File</a>
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
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue253f1(e.target.files[0]);
                    setPathValue253f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue253f1}
              {pathValue253f1 === "" ? null : (
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
                      setPathValue253f1("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
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
                {/* <input
                  onChange={(e) => {
                    setValue253f2(e.target.files[0]);
                    setPathValue253f2(e.target.value);
                  }}
                  id="253-f2"
                  className="c25-fileButton-style"
                  type="file"
                />
                {pathValue253f2 === '' ? null : (
                  <div className="c25-fileButtons-container">
                    <button className="c25-viewFileButton-style">
                      View File
                    </button>

                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue253f2("");
                      document.getElementById("253-f2").value="" }} >
                       Reset                     
                    </button>

                  </div>
                )}
                <a href={downloadFile(value253f2)} target="_blank">View File</a>
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
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue253f2(e.target.files[0]);
                    setPathValue253f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue253f2}
              {pathValue253f2 === "" ? null : (
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
                      setPathValue253f2("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c25x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
      <div className="c25x-button-container">
        <button onClick={onClickingSave} className="c25x-button-style">
          Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria25;
