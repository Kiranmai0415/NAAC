import React, { useState, useEffect } from 'react';
import './c31-style.css';
import { HelpButton } from "../../../../../reusableComponents/model/Help";
import { resources } from "../../../../appConstants";
import {toast} from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
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
function Help311(props) {
  return props.isHelp311Clicked ? (
    <div className="c31x-help-mainContainer">
      <div className="c31x-help-subContainer">
        <h1 className="c31x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c31x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum     
          500 words.
        </p>
        <button
          className="c31x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp311Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help312(props) {
  return props.isHelp312Clicked ? (
    <div className="c31x-help-mainContainer">
      <div className="c31x-help-subContainer">
        <h1 className="c31x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c31x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>The total amount of seed
          money provided by institution to its teachers for research in the last
          five years
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>
        <button
          className="c31x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp312Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help313(props) {
  return props.isHelp313Clicked ? (
    <div className="c31x-help-mainContainer">
      <div className="c31x-help-subContainer">
        <h1 className="c31x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c31x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>Total number of teachers
          who received national/ international fellowship/ financial support by
          various agencies for advanced studies/ research during the last five
          years<span style={{ fontWeight: 'bold' }}> / </span>Total number of
          full time teachers during the last five years
          <span style={{ fontWeight: 'bold' }}>) * </span>100
        </p>
        <button
          className="c31x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp313Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria31() {
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
  const [value311t1, setValue311t1] = useState();
  const [value311f1, setValue311f1] = useState('');
  const [pathValue311f1, setPathValue311f1] = useState('');
  const [value311f2, setValue311f2] = useState('');
  const [pathValue311f2, setPathValue311f2] = useState('');
  const [value311f3, setValue311f3] = useState('');
  const [pathValue311f3, setPathValue311f3] = useState('');

  const [value3121t1, setValue3121t1] = useState();
  const [value3121t2, setValue3121t2] = useState();
  const [value3121t3, setValue3121t3] = useState();
  const [value3121t4, setValue3121t4] = useState();
  const [value3121t5, setValue3121t5] = useState();
  const [value3121t6, setValue3121t6] = useState();
  const [value3121t7, setValue3121t7] = useState();
  const [value3121t8, setValue3121t8] = useState();
  const [value3121t9, setValue3121t9] = useState();
  const [value3121t10, setValue3121t10] = useState();
  const [value3121f1, setValue3121f1] = useState();
  const [pathValue3121f1, setPathValue3121f1] = useState('');
  const [value3121f2, setValue3121f2] = useState();
  const [pathValue3121f2, setPathValue3121f2] = useState('');
  const [value3121f3, setValue3121f3] = useState();
  const [pathValue3121f3, setPathValue3121f3] = useState('');
  const [value3121f4, setValue3121f4] = useState();
  const [pathValue3121f4, setPathValue3121f4] = useState('');

  const [value3131t1, setValue3131t1] = useState();
  const [value3131t2, setValue3131t2] = useState();
  const [value3131t3, setValue3131t3] = useState();
  const [value3131t4, setValue3131t4] = useState();
  const [value3131t5, setValue3131t5] = useState();
  const [value3131t6, setValue3131t6] = useState();
  const [value3131t7, setValue3131t7] = useState();
  const [value3131t8, setValue3131t8] = useState();
  const [value3131t9, setValue3131t9] = useState();
  const [value3131t10, setValue3131t10] = useState();
  const [value3131t11, setValue3131t11] = useState();
  const [value3131f1, setValue3131f1] = useState();
  const [pathValue3131f1, setPathValue3131f1] = useState('');
  const [value3131f2, setValue3131f2] = useState();
  const [pathValue3131f2, setPathValue3131f2] = useState('');
  const [value3131f3, setValue3131f3] = useState();
  const [pathValue3131f3, setPathValue3131f3] = useState('');
  const [help311Status, setHelp311Status] = useState(false);
  const [help312Status, setHelp312Status] = useState(false);
  const [help313Status, setHelp313Status] = useState(false);
  const [responseButtonStatus312, setResponseButtonStatus312] = useState(false);
  const [responseButtonStatus313, setResponseButtonStatus313] = useState(false);
  const [responseValue311, setResponseValue311] = useState();
  const [responseValue312, setResponseValue312] = useState();
  const [responseValue313, setResponseValue313] = useState();

  const [gradeScale311, setGradeScale311] = useState('');
  const [gradePoints311, setGradePoints311] = useState();
  const [gradePointsClickStatus311, setGradePointsClickStatus311] = useState(false);

  const [gradeScale312, setGradeScale312] = useState('');
  const [gradePoints312, setGradePoints312] = useState();
  const [gradeScaleClickStatus312, setGradeScaleClickStatus312] = useState(false);
  const [gradePointsClickStatus312, setGradePointsClickStatus312] = useState(false);

  const [gradeScale313, setGradeScale313] = useState('');
  const [gradePoints313, setGradePoints313] = useState();
  const [gradeScaleClickStatus313, setGradeScaleClickStatus313] = useState(false);
  const [gradePointsClickStatus313, setGradePointsClickStatus313] = useState(false);

  const [KIweightedGrade31ClickStatus, setKIweightedGrade31ClickStatus] = useState('');
  const [KIweightedGrade31, setKIweightedGrade31] = useState('');
  const [
    KIgradePointAverage31ClickStatus,
    setKIgradePointAverage31ClickStatus,
  ] = useState('');
  const [KIgradePointAverage31, setKIgradePointAverage31] = useState('');

  
// get data api

// const financialYear="2021-2022";
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
          console.log("data for criteria3 " + JSON.stringify(data));
         
          setValue311t1(data[0].criteria31Ql[0] ? data[0].criteria31Ql[0].input311t1 : "");
          setValue3131t11(data[0].criteria31Qn[0] ? data[0].criteria31Qn[0].input3131t11 : "");
          
          // setResponseValue111(data[0].criteria1FieldInfoQl[1].response111);
          // setResponseValue112(data[0].criteria1FieldInfoQn[2].response112);
          // setResponseValue113(data[0].criteria1FieldInfoQn[3].response113);

          setValue3131t1(data[0].yearTable3131[0] ? data[0].yearTable3131[0].input3131y : "");
          setValue3131t2(data[0].yearTable3131[1] ? data[0].yearTable3131[1].input3131y : "");
          setValue3131t3(data[0].yearTable3131[2] ? data[0].yearTable3131[2].input3131y : "");
          setValue3131t4(data[0].yearTable3131[3] ? data[0].yearTable3131[3].input3131y : "");
          setValue3131t5(data[0].yearTable3131[4] ? data[0].yearTable3131[4].input3131y : "");
          setValue3131t6(data[0].yearTable3131[0] ? data[0].yearTable3131[0].input3131v : "");
          setValue3131t7(data[0].yearTable3131[1] ? data[0].yearTable3131[1].input3131v : "");
          setValue3131t8(data[0].yearTable3131[2] ? data[0].yearTable3131[2].input3131v : "");
          setValue3131t9(data[0].yearTable3131[3] ? data[0].yearTable3131[3].input3131v : "");
          setValue3131t10(data[0].yearTable3131[4] ? data[0].yearTable3131[4].input3131v : "");
          setValue3121t1(data[0].yearTable3121[0] ? data[0].yearTable3121[0].input3121y : "");
          setValue3121t2(data[0].yearTable3121[1] ? data[0].yearTable3121[1].input3121y : "");
          setValue3121t3(data[0].yearTable3121[2] ? data[0].yearTable3121[2].input3121y : "");
          setValue3121t4(data[0].yearTable3121[3] ? data[0].yearTable3121[3].input3121y : "");
          setValue3121t5(data[0].yearTable3121[4] ? data[0].yearTable3121[4].input3121y : "");
          setValue3121t6(data[0].yearTable3121[0] ? data[0].yearTable3121[0].input3121v : "");
          setValue3121t7(data[0].yearTable3121[1] ? data[0].yearTable3121[1].input3121v : "");
          setValue3121t8(data[0].yearTable3121[2] ? data[0].yearTable3121[2].input3121v : "");
          setValue3121t9(data[0].yearTable3121[3] ? data[0].yearTable3121[3].input3121v : "");
          setValue3121t10(data[0].yearTable3121[4] ? data[0].yearTable3121[4].input3121v : "");
          setValue311f1(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
          setValue311f2(data[0].criteria3FileUpload[1] ? data[0].criteria3FileUpload[1].criteria3FileName : "");
          setValue311f3(data[0].criteria3FileUpload[2] ? data[0].criteria3FileUpload[2].criteria3FileName : "");
          setValue3121f1(data[0].criteria3FileUpload[3] ? data[0].criteria3FileUpload[3].criteria3FileName : "");
          setValue3121f2(data[0].criteria3FileUpload[4] ? data[0].criteria3FileUpload[4].criteria3FileName : "");
          setValue3121f3(data[0].criteria3FileUpload[5] ? data[0].criteria3FileUpload[5].criteria3FileName : "");
          setValue3121f4(data[0].criteria3FileUpload[6] ? data[0].criteria3FileUpload[6].criteria3FileName : "");
          setValue3131f1(data[0].criteria3FileUpload[7] ? data[0].criteria3FileUpload[7].criteria3FileName : "");
          setValue3131f2(data[0].criteria3FileUpload[8] ? data[0].criteria3FileUpload[8].criteria3FileName : "");
          setValue3131f3(data[0].criteria3FileUpload[9] ? data[0].criteria3FileUpload[9].criteria3FileName : "");
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ),
    []
  );

   // getfile data with API

function downloadFile(fileName) {
  const filePath = "http://localhost:8080/api/v1/download/" + fileName;
  return filePath;
}
  // response button functionality
  function onClickingViewResponse312() {
    if (
      value3121t6 === ''
      || value3121t7 === ''
      || value3121t8 === ''
      || value3121t9 === ''
      || value3121t10 === ''
      || value3121t6 === undefined
      || value3121t7 === undefined
      || value3121t8 === undefined
      || value3121t9 === undefined
      || value3121t10 === undefined
    ) {
      setResponseValue312('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3121t6, 10)) === false
      || Number.isInteger(parseInt(value3121t7, 10)) === false
      || Number.isInteger(parseInt(value3121t8, 10)) === false
      || Number.isInteger(parseInt(value3121t9, 10)) === false
      || Number.isInteger(parseInt(value3121t10, 10)) === false
    ) {
      setResponseValue312('Input should be an Integer');
    } else if (
      value3121t6 !== ''
      && value3121t7 !== ''
      && value3121t8 !== ''
      && value3121t9 !== ''
      && value3121t10 !== ''
    ) {
      setResponseValue312(
        (parseInt(value3121t6, 10)
          + parseInt(value3121t7, 10)
          + parseInt(value3121t8, 10)
          + parseInt(value3121t9, 10)
          + parseInt(value3121t10, 10))
          / 5
      );
    }
  }

  function onClickingViewResponse313() {
    if (
      value3131t6 === ''
      || value3131t7 === ''
      || value3131t8 === ''
      || value3131t9 === ''
      || value3131t10 === ''
      || value3131t11 === ''
      || value3131t6 === undefined
      || value3131t7 === undefined
      || value3131t8 === undefined
      || value3131t9 === undefined
      || value3131t10 === undefined
      || value3131t11 === undefined
    ) {
      setResponseValue313('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3131t6, 10)) === false
      || Number.isInteger(parseInt(value3131t7, 10)) === false
      || Number.isInteger(parseInt(value3131t8, 10)) === false
      || Number.isInteger(parseInt(value3131t9, 10)) === false
      || Number.isInteger(parseInt(value3131t10, 10)) === false
      || Number.isInteger(parseInt(value3131t11, 10)) === false
    ) {
      setResponseValue313('Input should be an Integer');
    } else if (
      value3131t6 !== ''
      && value3131t7 !== ''
      && value3131t8 !== ''
      && value3131t9 !== ''
      && value3131t10 !== ''
      && value3131t11 !== ''
    ) {
      setResponseValue313(
        ((parseInt(value3131t6, 10)
          + parseInt(value3131t7, 10)
          + parseInt(value3131t8, 10)
          + parseInt(value3131t9, 10)
          + parseInt(value3131t10, 10))
          / parseInt(value3131t11, 10))
          * 100
      );
    }
    console.log(responseValue313);
  }

   

  // sending data to db with API
 
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
    criteria31Ql:[
      {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType  },
      uniqueKey1: 1,
      input311t1: value311t1,
      response311: responseValue311,
      criteria31status:"save"
    },
  ],

  criteria31Qn: [
      {
     criteriaId: {  collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType  },
      uniqueKey1: 1,
        input3131t11: value3131t11,
        response312: responseValue312,
        response313: responseValue313,
      },
    ],
    yearTable3121: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 1, input3121y: value3121t1, input3121v: value3121t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 2, input3121y: value3121t2, input3121v: value3121t7
      },
      {
        criteriaId: {  collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 3, input3121y: value3121t3, input3121v: value3121t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 4, input3121y: value3121t4, input3121v: value3121t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 5, input3121y: value3121t5, input3121v: value3121t10
      },
    ],
    yearTable3131: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 1, input3131y: value3131t1, input3131v: value3131t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 2, input3131y: value3131t2, input3131v: value3131t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 3, input3131y: value3131t3, input3131v: value3131t8
      },
      {
        criteriaId: {  collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 4, input3131y: value3131t4, input3131v: value3131t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 5, input3131y: value3131t5, input3131v: value3131t10
      },
    ],

    // yearTable3131: [
    //   {  input3131y: value3131t1, input3131v: value3131t6 },
    //   { input3131y: value3131t2, input3131v: value3131t7 },
    //   { input3131y: value3131t3, input3131v: value3131t8 },
    //   { input3131y: value3131t4, input3131v: value3131t9 },
    //   { input3131y: value3131t5, input3131v: value3131t10 },
    // ],
  };

 
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form31Data = new FormData();

    // form31Data.append('criteria3FieldinfoQn', jsonBlob(inputDataListQn));
    console.log("data is ==>" + JSON.stringify(inputDataList));
    form31Data.append('criteria3Fieldinfo', jsonBlob(inputDataList));
    if (pathValue311f1 !== '') {
      form31Data.append('uploadfile3', value311f1, 'f311f1-' + value311f1.name);
    }
    if (pathValue311f2 !== '') {
      form31Data.append('uploadfile3', value311f2, 'f311f2-' + value311f2.name);
    }
    if (pathValue311f3 !== '') {
      form31Data.append('uploadfile3', value311f3, 'f311f3-' + value311f3.name);
    }

    if (pathValue3121f1 !== '') {
      form31Data.append(
        'uploadfile3',
        value3121f1,
        'f3121f1-' + value3121f1.name
      );
    }
    if (pathValue3121f2 !== '') {
      form31Data.append(
        'uploadfile3',
        value3121f2,
        'f3121f2-' + value3121f2.name
      );
    }
    if (pathValue3121f3 !== '') {
      form31Data.append(
        'uploadfile3',
        value3121f3,
        'f3121f3-' + value3121f3.name
      );
    }
    if (pathValue3121f4 !== '') {
      form31Data.append(
        'uploadfile3',
        value3121f4,
        'f3121f4-' + value3121f4.name
      );
    }

    if (pathValue3131f1 !== '') {
      form31Data.append(
        'uploadfile3',
        value3131f1,
        'f3131f1-' + value3131f1.name
      );
    }
    if (pathValue3131f2 !== '') {
      form31Data.append(
        'uploadfile3',
        value3131f2,
        'f3131f2-' + value3131f2.name
      );
    }
    if (pathValue3131f3 !== '') {
      form31Data.append(
        'uploadfile3',
        value3131f3,
        'f3131f3-' + value3131f3.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form31Data,
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
  
  // rendering DOM
  return (
    <div className="c31-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c31x-colorIndicator-container">
        <p className="c31x-QlcolorIndicator-circle-style"></p>
        <span className="c31x-colorIndicator-span-style">Qualitative</span>
        <p className="c31x-QtcolorIndicator-circle-style"></p>
        <span className="c31x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c31x-weightage-heading-style">
            Key Indicator Weightage: 20
          </h1>
        </div>
      </div>
      {/* Key Indicator: 3.1.1 */}
      <div className="c31x-eachInputField-container">
        <div className="c31x-weightage-container">
          <h1 className="c31x-weightage-heading-style">Weightage: 6</h1>
        </div>
        <form>
          <div className="c31x-Ql-label-textarea-container">
            <div className="c31x-heading_Help-container">
              <h1 className="c31x-heading-style">
                <span className="c31x-span-style">3.1.1: </span>
                The institution?s research facilities are frequently updated and there is well defined policy for promotion of research which is uploaded on the institutional website and implemented
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
            <label htmlFor="311-t1" className="c31x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue311t1(e.target.value);
                setResponseValue311(e.target.value);
              }}
              value={value311t1}
              rows={10}
              className="c31x-textarea-style"
              id="311-t1"
            ></textarea>
            {value311t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c31x-Ql-table-style">
            <tr>
              <th className="c31x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c31x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c31x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c31x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c31x-Ql-tableBorders-style">
                Any additional information
              </td>
              <td className="c31x-Ql-tableBorders-style"></td>
              <td className="c31x-Ql-tableBorders-style">
                {/* <input
                  onChange={(e) => {
                    setValue311f1(e.target.files[0]);
                    setPathValue311f1(e.target.value);
                  }}
                  id="311-f1"
                  type="file"
                  className="c31-fileButton-style"
                />
                {pathValue311f1 === '' ? null : (
                  <div className="c31-fileButtons-container">
                    <button className="c31-viewFileButton-style">View</button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue311f1("");
                      document.getElementById("311-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                <a href={downloadFile(value311f1)} target="_blank">View File</a>
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
                    setValue311f1(e.target.files[0]);
                    setPathValue311f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue311f1}
              {pathValue311f1 === "" ? null : (
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
                      setPathValue311f1("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c31x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c31x-Ql-tableBorders-style">
                Minutes of the Governing Council/ Syndicate/ Board of Management
                related to research promotion policy adoption
              </td>
              <td className="c31x-Ql-tableBorders-style">
              {/* <a href={downloadFile("au3.1.1.xlsx")} target="_blank">
                  View Template
                </a> */}
              </td>
              <td className="c31x-Ql-tableBorders-style">
                {/* <input
                  onChange={(e) => {
                    setValue311f2(e.target.files[0]);
                    setPathValue311f2(e.target.value);
                    console.log(pathValue311f2);
                  }}
                  id="311-f2"
                  type="file"
                  className="c31-fileButton-style"
                />
                {pathValue311f2 === '' ? null : (
                  <div className="c31-fileButtons-container">
                    <button className="c31-viewFileButton-style">
                      View File
                    </button>

                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue311f2("");
                      document.getElementById("311-f2").value="" }} >
                       Reset                     
                     </button>


                  </div>
                )}
                <a href={downloadFile(value311f2)} target="_blank">View File</a>
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
                    setValue311f2(e.target.files[0]);
                    setPathValue311f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue311f2}
              {pathValue311f2 === "" ? null : (
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
                      setPathValue311f2("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c31x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c31x-Ql-tableBorders-style">
                URL of Policy document on promotion of research uploaded on
                website
              </td>
              <td className="c31x-Ql-tableBorders-style"></td>
              <td className="c31x-Ql-tableBorders-style">
                {/* <input
                  onChange={(e) => {
                    setValue311f3(e.target.files[0]);
                    setPathValue311f3(e.target.value);
                  }}
                  id="311-f3"
                  type="file"
                  className="c31-fileButton-style"
                />
                {pathValue311f3 === '' ? null : (
                  <div className="c31-fileButtons-container">
                    <button className="c31-viewFileButton-style">
                      View File
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue311f3("");
                      document.getElementById("311-f3").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                <a href={downloadFile(value311f3)} target="_blank">View File</a>
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
                    setValue311f3(e.target.files[0]);
                    setPathValue311f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue311f3}
              {pathValue311f3 === "" ? null : (
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
                      setPathValue311f3("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c31x-Ql-tableBorders-style">pdf</td>
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
              setGradeScale311(e.target.value);
              console.log(gradeScale311);
            }}
          />

          <div className="c31x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus311(true);
                qlMetricGradePointsCalculator(
                  gradeScale311,
                  setGradePoints311,
                  6
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
            {gradePointsClickStatus311 ? (
              <p className="c31x-responseResult-style">{gradePoints311}</p>
            ) : null}
          </div>
        </div> */}
      </div>
      {/* Key Indicator: 3.1.2 */}
      <div className="c31x-eachInputField-container">
        <div className="c31x-weightage-container">
          <h1 className="c31x-weightage-heading-style">Weightage: 8</h1>
        </div>
        <form>
          <div className="c31x-container">
            <div className="c31x-heading_Help-container">
              <h1 className="c31x-heading-style">
                <span className="c31x-span-style">3.1.2: </span>
                The institution provides seed money to its teachers for research
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
            <div className="c31x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus312(!responseButtonStatus312);
                  onClickingViewResponse312();
                }}
                className="c31x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus312 ? (
                <p className="c31x-responseResult-style">{responseValue312}</p>
              ) : null}
            </div>
          </div>
          <div className="c31xx-container">
            <h1 className="c31xx-Heading-style">
              <span className="c31xx-span-style">3.1.2.1: </span>
              The amount of seed money provided by institution to its teachers
              for research year wise during last five years (INR in lakhs)
            </h1>

            <table className="c31x-Qt-table-style">
              <tr>
                <th className="c31x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3121t1(e.target.value)}
                      id="3121-t1"
                      className="c31x-input-style"
                      type="text"
                      value={value3121t1}
                    />
                    {value3121t1 === '' ? (
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
                      onChange={(e) => setValue3121t2(e.target.value)}
                      id="3121-t2"
                      className="c31x-input-style"
                      type="text"
                      value={value3121t2}
                    />
                    {value3121t2 === '' ? (
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
                      onChange={(e) => setValue3121t3(e.target.value)}
                      id="3121-t3"
                      className="c31x-input-style"
                      type="text"
                      value={value3121t3}
                    />
                    {value3121t3 === '' ? (
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
                      onChange={(e) => setValue3121t4(e.target.value)}
                      id="3121-t4"
                      className="c31x-input-style"
                      type="text"
                      value={value3121t4}
                    />
                    {value3121t4 === '' ? (
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
                      onChange={(e) => setValue3121t5(e.target.value)}
                      id="3121-t5"
                      className="c31x-input-style"
                      type="text"
                      value={value3121t5}
                    />
                    {value3121t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c31x-horizontalTable-heading-style">
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
                        setValue3121t6(e.target.value);
                        onClickingViewResponse312();
                      }}
                      id="3121-t6"
                      className="c31x-input-style"
                      type="text"
                      value={value3121t6}
                    />
                    {value3121t6 === '' ? (
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
                        setValue3121t7(e.target.value);
                        onClickingViewResponse312();
                      }}
                      id="3121-t7"
                      className="c31x-input-style"
                      type="text"
                      value={value3121t7}
                    />
                    {value3121t7 === '' ? (
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
                        setValue3121t8(e.target.value);
                        onClickingViewResponse312();
                      }}
                      id="3121-t8"
                      className="c31x-input-style"
                      type="text"
                      value={value3121t8}
                    />
                    {value3121t8 === '' ? (
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
                        setValue3121t9(e.target.value);
                        onClickingViewResponse312();
                      }}
                      id="3121-t9"
                      className="c31x-input-style"
                      type="text"
                      value={value3121t9}
                    />
                    {value3121t9 === '' ? (
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
                        setValue3121t10(e.target.value);
                        onClickingViewResponse312();
                      }}
                      id="3121-t10"
                      className="c31x-input-style"
                      type="text"
                      value={value3121t10}
                    />
                    {value3121t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c31x-table-style">
              <tr>
                <th className="c31x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c31x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c31x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c31x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3121f1(e.target.files[0]);
                      setPathValue3121f1(e.target.value);
                    }}
                    id="3121-f1"
                    type="file"
                    className="c31-fileButton-style"
                  />
                  {pathValue3121f1 === '' ? null : (
                    <div className="c31-fileButtons-container">
                      <button className="c31-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3121f1("");
                      document.getElementById("3121-f1").value="" }} >
                       Reset                     
                     </button>

                    </div>
                  )}
                  <a href={downloadFile(value3121f1)} target="_blank">View File</a>
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
                    setValue3121f1(e.target.files[0]);
                    setPathValue3121f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3121f1}
              {pathValue3121f1 === "" ? null : (
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
                      setPpathValue3121f1("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Minutes of the relevant bodies of the Institution</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3121f2(e.target.files[0]);
                      setPathValue3121f2(e.target.value);
                    }}
                    id="3121-f2"
                    type="file"
                    className="c31-fileButton-style"
                  />
                  {pathValue3121f2 === '' ? null : (
                    <div className="c31-fileButtons-container">
                      <button className="c31-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3121f2("");
                      document.getElementById("3121-f2").value="" }} >
                       Reset                     
                     </button>

                    </div>
                  )}
                  <a href={downloadFile(value3121f2)} target="_blank">View File</a>
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
                    setValue3121f2(e.target.files[0]);
                      setPathValue3121f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3121f2}
              {pathValue3121f2 === "" ? null : (
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
                      setPathValue3121f2("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Budget and expenditure statements signed by the Finance
                  Officer indicating seed money provided and utilized
                </td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3121f3(e.target.files[0]);
                      setPathValue3121f3(e.target.value);
                    }}
                    id="3121-f3"
                    type="file"
                    className="c31-fileButton-style"
                  />
                  {pathValue3121f3 === '' ? null : (
                    <div className="c31-fileButtons-container">
                      <button className="c31-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3121f3("");
                      document.getElementById("3121-f3").value="" }} >
                       Reset                     
                     </button>

                    </div>
                  )}
                  <a href={downloadFile(value3121f3)} target="_blank">View File</a>
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
                    setValue3121f3(e.target.files[0]);
                      setPathValue3121f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3121f3}
              {pathValue3121f3 === "" ? null : (
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
                      setPathValue3121f3("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List of teachers receiving grant and details of grant received
                  (Data Template)
                </td>
                <td>
                <a href={downloadFile("au3.1.2.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3121f4(e.target.files[0]);
                      setPathValue3121f4(e.target.value);
                    }}
                    id="3121-f4"
                    type="file"
                    className="c31-fileButton-style"
                  />
                  {pathValue3121f4 === '' ? null : (
                    <div className="c31-fileButtons-container">
                      <button className="c31-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3121f4("");
                      document.getElementById("3121-f4").value="" }} >
                       Reset                     
                     </button>

                    </div>
                  )}
                  <a href={downloadFile(value3121f4)} target="_blank">View File</a>
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
                    setValue3121f4(e.target.files[0]);
                    setPathValue3121f4(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3121f4}
              {pathValue3121f4 === "" ? null : (
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
                      setPathValue3121f4("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c31x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus312(true);
                setGradeScale312(numberMetricGradeCalculator(responseValue312));
                console.log(gradeScale312);
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

            {gradeScaleClickStatus312 ? (
              <p className="c31x-responseResult-style">
                {numberMetricGradeCalculator(responseValue312)}
              </p>
            ) : null}
          </div>
          <div className="c31x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus312(true);
                setGradePoints312(
                  numberMetricGradeCalculator(responseValue312)
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
            {gradePointsClickStatus312 ? (
              <p className="c31x-responseResult-style">
                {metricGradePointsCalculator(gradeScale312, 8)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>
      {/* Key Indicator: 3.1.3 */}
      <div className="c31x-eachInputField-container">
        <div className="c31x-weightage-container">
          <h1 className="c31x-weightage-heading-style">Weightage: 6</h1>
        </div>
        <form>
          <div className="c31x-container">
            <div className="c31x-heading_Help-container">
              <h1 className="c31x-heading-style">
                <span className="c31x-span-style">3.1.3: </span>
                Percentage of teachers receiving national/ international fellowship/financial support by various agencies for advanced studies/ research during the last five years
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
                ><h1>(Total number of teachers who received national/international fellowship/ financial support by variousagencies for advanced studies/research during the last five years)/(Total number of full time teachers during the last five years) * 100</h1></HelpButton>
            </div>
            <div className="c31x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus313(!responseButtonStatus313);
                  onClickingViewResponse313();
                }}
                className="c31x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus313 ? (
                <p className="c31x-responseResult-style">{responseValue313}</p>
              ) : null}
            </div>
          </div>
          <div className="c31xx-container">
            <h1 className="c31xx-Heading-style">
              <span className="c31xx-span-style">3.1.3.1: </span>
              The number of teachers awarded national/ international fellowship
              for advanced studies/ research year wise during last five years
            </h1>

            <table className="c31x-Qt-table-style">
              <tr>
                <th className="c31x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3131t1(e.target.value)}
                      id="3131-t1"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t1}
                    />
                    {value3131t1 === '' ? (
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
                      onChange={(e) => setValue3131t2(e.target.value)}
                      id="3131-t2"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t2}
                    />
                    {value3131t2 === '' ? (
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
                      onChange={(e) => setValue3131t3(e.target.value)}
                      id="3131-t3"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t3}
                    />
                    {value3131t3 === '' ? (
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
                      onChange={(e) => setValue3131t4(e.target.value)}
                      id="3131-t4"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t4}
                    />
                    {value3131t4 === '' ? (
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
                      onChange={(e) => setValue3131t5(e.target.value)}
                      id="3131-t5"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t5}
                    />
                    {value3131t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c31x-horizontalTable-heading-style">
                  Number of teachers
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
                        setValue3131t6(e.target.value);
                        onClickingViewResponse313();
                      }}
                      id="3131-t6"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t6}
                    />
                    {value3131t6 === '' ? (
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
                        setValue3131t7(e.target.value);
                        onClickingViewResponse313();
                      }}
                      id="3131-t7"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t7}
                    />
                    {value3131t7 === '' ? (
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
                        setValue3131t8(e.target.value);
                        onClickingViewResponse313();
                      }}
                      id="3131-t8"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t8}
                    />
                    {value3131t8 === '' ? (
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
                        setValue3131t9(e.target.value);
                        onClickingViewResponse313();
                      }}
                      id="3131-t9"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t9}
                    />
                    {value3131t9 === '' ? (
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
                        setValue3131t10(e.target.value);
                        onClickingViewResponse313();
                      }}
                      id="3131-t10"
                      className="c31x-input-style"
                      type="text"
                      value={value3131t10}
                    />
                    {value3131t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <div className="c31xx-label-textInput-container">
              <label className="c31xx-Heading-style">
                Total number of full time teachers during the last five years
              </label>
              <input
                onChange={(e) => {
                  setValue3131t11(e.target.value);
                  onClickingViewResponse313();
                }}
                id="3131-t11"
                style={{ marginLeft: '8%' }}
                type="text"
                value={value3131t11}
              />
              {value3131t11 === '' ? <p style={{ color: 'red' }}>*</p> : null}
            </div>

            <table className="c31x-table-style">
              <tr>
                <th className="c31x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c31x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c31x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c31x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3131f1(e.target.files[0]);
                      setPathValue3131f1(e.target.value);
                    }}
                    id="3131-f1"
                    type="file"
                    className="c31-fileButton-style"
                  />
                  {pathValue3131f1 === '' ? null : (
                    <div className="c31-fileButtons-container">
                      <button className="c31-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3131f1("");
                      document.getElementById("3131-f1").value="" }} >
                       Reset                     
                     </button>

                    </div>
                  )}
                  <a href={downloadFile(value3131f1)} target="_blank">View File</a>
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
                    setValue3131f1(e.target.files[0]);
                      setPathValue3131f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3131f1}
              {pathValue3131f1 === "" ? null : (
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
                      setPathValue3131f1("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>e-copies of the award letters of the teachers</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3131f2(e.target.files[0]);
                      setPathValue3131f2(e.target.value);
                    }}
                    id="3131-f2"
                    type="file"
                    className="c31-fileButton-style"
                  />
                  {pathValue3131f2 === '' ? null : (
                    <div className="c31-fileButtons-container">
                      <button className="c31-viewFileButton-style">
                        View File
                      </button>
                      
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3131f2("");
                      document.getElementById("3131-f2").value="" }} >
                       Reset                     
                     </button>

                    </div>
                  )}
                  <a href={downloadFile(value3131f2)} target="_blank">View File</a>
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
                    setValue3131f2(e.target.files[0]);
                      setPathValue3131f2(e.target.value)
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3131f2}
              {pathValue3131f2 === "" ? null : (
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
                      setPathValue3131f2("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List of teachers and their international fellowship details
                  (Data Template)
                </td>
                <td>
                <a href={downloadFile("au3.1.3.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                 {/* <input
                    onChange={(e) => {
                      setValue3131f3(e.target.files[0]);
                      setPathValue3131f3(e.target.value);
                    }}
                    id="3131-f3"
                    type="file"
                    className="c31-fileButton-style"
                  />
                  {pathValue3131f3 === '' ? null : (
                    <div className="c31-fileButtons-container">
                      <button className="c31-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3131f3("");
                      document.getElementById("3131-f3").value="" }} >
                       Reset                     
                     </button>

                    </div>
                  )}
                   <a href={downloadFile(value3131f3)} target="_blank">View File</a>
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
                    setValue3131f3(e.target.files[0]);
                    setPathValue3131f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3131f3}
              {pathValue3131f3 === "" ? null : (
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
                      setPathValue3131f3("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c31x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus313(true);
                setGradeScale313(numberMetricGradeCalculator(responseValue313));
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

            {gradeScaleClickStatus313 ? (
              <p className="c31x-responseResult-style">
                {numberMetricGradeCalculator(responseValue313)}
              </p>
            ) : null}
          </div>
          <div className="c31x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus313(true);
                setGradeScale313(numberMetricGradeCalculator(responseValue313));
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
            {gradePointsClickStatus313 ? (
              <p className="c31x-responseResult-style">
                {metricGradePointsCalculator(gradeScale313, 8)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>

      <div className="c31x-button-container">
        <button onClick={onClickingSave} className="c31x-button-style">
          Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria31;
