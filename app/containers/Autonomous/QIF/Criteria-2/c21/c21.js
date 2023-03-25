import React, { useState } from 'react';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import './c21-style.css';
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
function Help211(props) {
  return props.isHelp211Clicked ? (
    <div className="c21x-help-mainContainer">
      <div className="c21x-help-subContainer">
        <h1 className="c21x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c21x-help-para-style">
          percentage per year <span style={{ fontWeight: 'bold' }}>=</span>
          <span style={{ fontWeight: 'bold' }}>(</span> Number of students
          admitted<span style={{ fontWeight: 'bold' }}>/</span>
          Number of sanctioned seats{' '}
          <span style={{ fontWeight: 'bold' }}>) * </span>100
        </p>
        <p className="c21x-help-para-style">
          Average percentage per year{' '}
          <span style={{ fontWeight: 'bold' }}>=</span>
          Σpercentage per year<span style={{ fontWeight: 'bold' }}>/</span>5
        </p>
        <button
          className="c21x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp211Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help212(props) {
  return props.isHelp212Clicked ? (
    <div className="c21x-help-mainContainer">
      <div className="c21x-help-subContainer">
        <h1 className="c21x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c21x-help-para-style">
          percentage per year <span style={{ fontWeight: 'bold' }}>=</span>
          <span style={{ fontWeight: 'bold' }}>(</span> Number of actual
          students admitted from the reserved categories{' '}
          <span style={{ fontWeight: 'bold' }}>/</span>
          Number of seats earmarked for reserved category as per GOI or state
          Government rule<span style={{ fontWeight: 'bold' }}>)*</span>100
        </p>
        <p className="c21x-help-para-style">
          Average percentage <span style={{ fontWeight: 'bold' }}>=</span>
          Σpercentage per year<span style={{ fontWeight: 'bold' }}>/</span>5
        </p>
        <button
          className="c21x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp212Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria21() {
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

  const [value2111t1, setValue2111t1] = useState();
  const [value2111t2, setValue2111t2] = useState();
  const [value2111t3, setValue2111t3] = useState();
  const [value2111t4, setValue2111t4] = useState();
  const [value2111t5, setValue2111t5] = useState();
  const [value2111t6, setValue2111t6] = useState();
  const [value2111t7, setValue2111t7] = useState();
  const [value2111t8, setValue2111t8] = useState();
  const [value2111t9, setValue2111t9] = useState();
  const [value2111t10, setValue2111t10] = useState();
  const [value2112t1, setValue2112t1] = useState();
  const [value2112t2, setValue2112t2] = useState();
  const [value2112t3, setValue2112t3] = useState();
  const [value2112t4, setValue2112t4] = useState();
  const [value2112t5, setValue2112t5] = useState();
  const [value2112t6, setValue2112t6] = useState();
  const [value2112t7, setValue2112t7] = useState();
  const [value2112t8, setValue2112t8] = useState();
  const [value2112t9, setValue2112t9] = useState();
  const [value2112t10, setValue2112t10] = useState();
  const [value2112t11, setValue2112t11] = useState();
  const [pathValue2112f1, setPathValue2112f1] = useState('');
  const [pathValue2112f2, setPathValue2112f2] = useState('');
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');

  const [value2112f1, setValue2112f1] = useState([]);
  const [value2112f2, setValue2112f2] = useState([]);

  const [value2121t1, setValue2121t1] = useState();
  const [value2121t2, setValue2121t2] = useState();
  const [value2121t3, setValue2121t3] = useState();
  const [value2121t4, setValue2121t4] = useState();
  const [value2121t5, setValue2121t5] = useState();
  const [value2121t6, setValue2121t6] = useState();
  const [value2121t7, setValue2121t7] = useState();
  const [value2121t8, setValue2121t8] = useState();
  const [value2121t9, setValue2121t9] = useState();
  const [value2121t10, setValue2121t10] = useState();
  const [value2121t11, setValue2121t11] = useState();
  const [value2121t12, setValue2121t12] = useState();
  const [value2121t13, setValue2121t13] = useState();
  const [value2121t14, setValue2121t14] = useState();
  const [value2121t15, setValue2121t15] = useState();
  const [value2121t16, setValue2121t16] = useState();
  const [value2121t17, setValue2121t17] = useState();
  const [value2121t18, setValue2121t18] = useState();
  const [value2121t19, setValue2121t19] = useState();
  const [value2121t20, setValue2121t20] = useState();

  const [pathValue2121f1, setPathValue2121f1] = useState('');
  const [value2121f1, setValue2121f1] = useState([]);
  const [pathValue2121f2, setPathValue2121f2] = useState('');
  const [value2121f2, setValue2121f2] = useState([]);

  const [responseButtonStatus211, setResponseButtonStatus211] = useState(false);
  const [responseButtonStatus212, setResponseButtonStatus212] = useState(false);
  const [responseValue211, setResponseValue211] = useState('');
  const [responseValue212, setResponseValue212] = useState('');
  const [help211Status, setHelp211Status] = useState(false);
  const [help212Status, setHelp212Status] = useState(false);

  // response button functionality
  function onClickingViewResponse211() {
    if (
      value2111t6 === ''
      || value2111t7 === ''
      || value2111t8 === ''
      || value2111t9 === ''
      || value2111t10 === ''
      || value2112t6 === ''
      || value2112t7 === ''
      || value2112t8 === ''
      || value2112t9 === ''
      || value2112t10 === ''
      || value2111t6 === undefined
      || value2111t7 === undefined
      || value2111t8 === undefined
      || value2111t9 === undefined
      || value2111t10 === undefined
      || value2112t6 === undefined
      || value2112t7 === undefined
      || value2112t8 === undefined
      || value2112t9 === undefined
      || value2112t10 === undefined
    ) {
      setResponseValue211('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value2111t6, 10)) === false
      || Number.isInteger(parseInt(value2111t7, 10)) === false
      || Number.isInteger(parseInt(value2111t8, 10)) === false
      || Number.isInteger(parseInt(value2111t9, 10)) === false
      || Number.isInteger(parseInt(value2111t10, 10)) === false
      || Number.isInteger(parseInt(value2112t6, 10)) === false
      || Number.isInteger(parseInt(value2112t7, 10)) === false
      || Number.isInteger(parseInt(value2112t8, 10)) === false
      || Number.isInteger(parseInt(value2112t9, 10)) === false
      || Number.isInteger(parseInt(value2112t10, 10)) === false
    ) {
      setResponseValue211('Input should be an Integer');
    } else if (
      value2111t6 !== ''
      && value2111t7 !== ''
      && value2111t8 !== ''
      && value2111t9 !== ''
      && value2111t10 !== ''
      && value2112t6 !== ''
      && value2112t7 !== ''
      && value2112t8 !== ''
      && value2112t9 !== ''
      && value2112t10 !== ''
    ) {
      setResponseValue211(
        ((value2111t6 / value2112t6) * 100
          + (value2111t7 / value2112t7) * 100
          + (value2111t8 / value2112t8) * 100
          + (value2111t9 / value2112t9) * 100
          + (value2111t10 / value2112t10) * 100)
          / 5
      );
    }
  }

  function onClickingViewResponse212() {
    if (
      value2121t6 === ''
      || value2121t7 === ''
      || value2121t8 === ''
      || value2121t9 === ''
      || value2121t10 === ''
      || value2121t16 === ''
      || value2121t17 === ''
      || value2121t18 === ''
      || value2121t19 === ''
      || value2121t20 === ''
      || value2121t6 === undefined
      || value2121t7 === undefined
      || value2121t8 === undefined
      || value2121t9 === undefined
      || value2121t10 === undefined
      || value2121t16 === undefined
      || value2121t17 === undefined
      || value2121t18 === undefined
      || value2121t19 === undefined
      || value2121t20 === undefined
    ) {
      setResponseValue212('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value2121t6, 10)) === false
      || Number.isInteger(parseInt(value2121t7, 10)) === false
      || Number.isInteger(parseInt(value2121t8, 10)) === false
      || Number.isInteger(parseInt(value2121t9, 10)) === false
      || Number.isInteger(parseInt(value2121t10, 10)) === false
      || Number.isInteger(parseInt(value2121t16, 10)) === false
      || Number.isInteger(parseInt(value2121t17, 10)) === false
      || Number.isInteger(parseInt(value2121t18, 10)) === false
      || Number.isInteger(parseInt(value2121t19, 10)) === false
      || Number.isInteger(parseInt(value2121t20, 10)) === false
    ) {
      setResponseValue212('Input should be an Integer');
    } else if (
      value2121t6 !== ''
      && value2121t7 !== ''
      && value2121t8 !== ''
      && value2121t9 !== ''
      && value2121t10 !== ''
      && value2121t16 !== ''
      && value2121t17 !== ''
      && value2121t18 !== ''
      && value2121t19 !== ''
      && value2121t20 !== ''
    ) {
      setResponseValue212(
        ((value2121t6 / value2121t16) * 100
          + (value2121t7 / value2121t17) * 100
          + (value2121t8 / value2121t18) * 100
          + (value2121t9 / value2121t19) * 100
          + (value2121t10 / value2121t20) * 100)
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
  // const financialYear="2021-2022";
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
    criteria21Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
        uniqueKey1:1,
        response211: responseValue211,
        response212: responseValue212,
        criteria21status:"save"
      }
    ],
    yearTable2111: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
         uniqueKey1: 1, input2111y: value2111t1, input2111v: value2111t6
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 2, input2111y: value2111t2, input2111v: value2111t7
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 3, input2111y: value2111t3, input2111v: value2111t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 4, input2111y: value2111t4, input2111v: value2111t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 5, input2111y: value2111t5, input2111v: value2111t10
      },
    ],
    yearTable2112: [
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 1, input2112y: value2112t1, input2112v: value2112t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 2, input2112y: value2112t2, input2112v: value2112t7
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 3, input2112y: value2112t3, input2112v: value2112t8
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 4, input2112y: value2112t4, input2112v: value2112t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 5, input2112y: value2112t5, input2112v: value2112t10
      },
    ],
    yearTable2121: [
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 1, input2121y: value2121t1, input2121v: value2121t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 2, input2121y: value2121t2, input2121v: value2121t7
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 3, input2121y: value2121t3, input2121v: value2121t8
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 4, input2121y: value2121t4, input2121v: value2121t9
      },
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 5, input2121y: value2121t5, input2121v: value2121t10
      },
    ],
    yearTable21212: [
      { criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType }, uniqueKey1: 1,
      input21212y: value2121t11, input21212v: value2121t16 
    },
      { criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType}, uniqueKey1: 2,
      input21212y: value2121t12, input21212v: value2121t17 
    },
      { criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType }, uniqueKey1: 3,
      input21212y: value2121t13, input21212v: value2121t18 
    },
      { criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType}, uniqueKey1: 4,
       input21212y: value2121t14, input21212v: value2121t19 
      },
      { criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType }, uniqueKey1: 5,
      input21212y: value2121t15, input21212v: value2121t20 
    },
    ]
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form21Data = new FormData();
    console.log('data is ==>' + JSON.stringify(inputDataList));
    form21Data.append('criteria2Fieldinfo', jsonBlob(inputDataList));
    if (pathValue2112f1 !== '') {
      form21Data.append(
        'uploadfile2',
        value2112f1,
        'f2112f1-' + value2112f1.name
      );
    }
    if (pathValue2112f2 !== '') {
      form21Data.append(
        'uploadfile2',
        value2112f2,
        'f2112f2-' + value2112f2.name
      );
    }

    if (pathValue2121f1 !== '') {
      form21Data.append(
        'uploadfile2',
        value2121f1,
        'f2121f1-' + value2121f1.name
      );
    }
    if (pathValue2121f2 !== '') {
      form21Data.append(
        'uploadfile2',
        value2121f2,
        'f2121f2-' + value2121f2.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form21Data,
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

  // rendering DOM
  return (
    <div className="c21-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c21x-colorIndicator-container">
        <p className="c21x-QlcolorIndicator-circle-style"></p>
        <span className="c21x-colorIndicator-span-style">Qualitative</span>
        <p className="c21x-QtcolorIndicator-circle-style"></p>
        <span className="c21x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c21x-weightage-heading-style">
            Key Indicator Weightage: 20
          </h1>
        </div>
      </div>

      {/* Key Indicator: 2.1.1 */}
      <div className="c21x-eachInputField-container">
        <div className="c21x-weightage-container">
          <h1 className="c21x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c21x-container">
            <div className="c21x-heading_Help-container">
              <h1 className="c21x-heading-style">
                <span className="c21x-span-style">2.1.1: </span>
                Enrolment percentage
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c21x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='formula'
                >(Total number of seats filled yearwise)/(Total number of sanctioned seats yearwise) * 100</HelpButton>
            </div>
            <div className="c21x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus211(!responseButtonStatus211);
                  onClickingViewResponse211();
                }}
                className="c21x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus211 ? (
                <p className="c21x-responseResult-style">{responseValue211}</p>
              ) : null}
            </div>
          </div>
          <div className="c21xx-container">
            <h1 className="c21xx-Heading-style">
              <span className="c21xx-span-style">2.1.1.1: </span>
               Number of seats filled year wise during last five years(Only first year admissions to be considered)

            </h1>
            <table className="c21x-Qt-table-style">
              <tr>
                <th className="c21x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue2111t1(e.target.value)}
                      id="2111-t1"
                      className="c21x-input-style"
                      type="number"
                      value={value2111t1}
                    />
                    {value2111t1 === '' ? (
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
                      onChange={(e) => setValue2111t2(e.target.value)}
                      id="2111-t2"
                      className="c21x-input-style"
                      type="number"
                      value={value2111t2}
                    />
                    {value2111t2 === '' ? (
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
                      onChange={(e) => setValue2111t3(e.target.value)}
                      id="2111-t3"
                      className="c21x-input-style"
                      type="number"
                      value={value2111t3}
                    />
                    {value2111t3 === '' ? (
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
                      onChange={(e) => setValue2111t4(e.target.value)}
                      id="2111-t4"
                      className="c21x-input-style"
                      type="number"
                      value={value2111t4}
                    />
                    {value2111t4 === '' ? (
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
                      onChange={(e) => setValue2111t5(e.target.value)}
                      id="2111-t5"
                      className="c21x-input-style"
                      type="number"
                      value={value2111t5}
                    />
                    {value2111t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c21x-horizontalTable-heading-style">
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
                        setValue2111t6(e.target.value);
                        onClickingViewResponse211();
                      }}
                      id="2111-t6"
                      className="c21x-input-style"
                      type="number"
                      value={value2111t6}
                    />
                    {value2111t6 === '' ? (
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
                        setValue2111t7(e.target.value);
                        onClickingViewResponse211();
                      }}
                      id="2111-t7"
                      className="c21x-input-style"
                      type="number"
                      value={value2111t7}
                    />
                    {value2111t7 === '' ? (
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
                        setValue2111t8(e.target.value);
                        onClickingViewResponse211();
                      }}
                      id="2111-t8"
                      className="c21x-input-style"
                      type="number"
                      value={value2111t8}
                    />
                    {value2111t8 === '' ? (
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
                        setValue2111t9(e.target.value);
                        onClickingViewResponse211();
                      }}
                      id="2111-t9"
                      className="c21x-input-style"
                      type="number"
                      value={value2111t9}
                    />
                    {value2111t9 === '' ? (
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
                        setValue2111t10(e.target.value);
                        onClickingViewResponse211();
                      }}
                      id="2111-t10"
                      className="c21x-input-style"
                      type="number"
                      value={value2111t10}
                    />
                    {value2111t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <h1 className="c21xx-Heading-style">
              <span className="c21xx-span-style">2.1.1.2: </span>
              Number of sanctioned seats year wise during last five years
            </h1>
            <table className="c21x-Qt-table-style">
              <tr>
                <th className="c21x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue2112t1(e.target.value)}
                      id="2112-t1"
                      className="c21x-input-style"
                      type="number"
                      value={value2112t1}
                    />
                    {value2112t1 === '' ? (
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
                      onChange={(e) => setValue2112t2(e.target.value)}
                      id="2112-t2"
                      className="c21x-input-style"
                      type="number"
                      value={value2112t2}
                    />
                    {value2112t2 === '' ? (
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
                      onChange={(e) => setValue2112t3(e.target.value)}
                      id="2112-t3"
                      className="c21x-input-style"
                      type="number"
                      value={value2112t3}
                    />
                    {value2112t3 === '' ? (
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
                      onChange={(e) => setValue2112t4(e.target.value)}
                      id="2112-t4"
                      className="c21x-input-style"
                      type="number"
                      value={value2112t4}
                    />
                    {value2112t4 === '' ? (
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
                      onChange={(e) => setValue2112t5(e.target.value)}
                      id="2112-t5"
                      className="c21x-input-style"
                      type="number"
                      value={value2112t5}
                    />
                    {value2112t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c21x-horizontalTable-heading-style">
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
                        setValue2112t6(e.target.value);
                        onClickingViewResponse211();
                      }}
                      id="2112-t6"
                      className="c21x-input-style"
                      type="number"
                      value={value2112t6}
                    />
                    {value2112t6 === '' ? (
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
                        setValue2112t7(e.target.value);
                        onClickingViewResponse211();
                      }}
                      id="2112-t7"
                      className="c21x-input-style"
                      type="number"
                      value={value2112t7}
                    />
                    {value2112t7 === '' ? (
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
                        setValue2112t8(e.target.value);
                        onClickingViewResponse211();
                      }}
                      id="2112-t8"
                      className="c21x-input-style"
                      type="number"
                      value={value2112t8}
                    />
                    {value2112t8 === '' ? (
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
                        setValue2112t9(e.target.value);
                        onClickingViewResponse211();
                      }}
                      id="2112-t9"
                      className="c21x-input-style"
                      type="number"
                      value={value2112t9}
                    />
                    {value2112t9 === '' ? (
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
                        setValue2112t10(e.target.value);
                        onClickingViewResponse211();
                      }}
                      id="2112-t10"
                      className="c21x-input-style"
                      type="number"
                      value={value2112t10}
                    />
                    {value2112t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <table className="c21x-table-style">
              <tr>
                <th className="c21x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c21x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c21x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c21x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                Any additional information
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2112f1(e.target.files[0]);
                      setPathValue2112f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2112-f1"
                    className="c21-fileButton-style"
                    accept='.pdf'
                    type="file"
                  />
                  {pathValue2112f1 === '' ? null : (
                    <div className="c21-fileButtons-container">
                      <button className="c21-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2112f1("");
                      document.getElementById("2112-f1").value="" }} >
                      Reset
                    </button>

                    </div>
                  )}
                </td>
                <td className="c21x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Demand Ratio (Average of Last five years) based on Data
                  Template upload the documentAny</td>
                <td><a href={downloadFile("au2.1.1.xlsx")} target="_blank">View Template</a></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2112f2(e.target.files[0]);
                      setPathValue2112f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2112-f2"
                    className="c21-fileButton-style"
                    accept='.pdf'
                    type="file"
                  />
                  {pathValue2112f2 === '' ? null : (
                    <div className="c21-fileButtons-container">
                      <button className="c21-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2112f2("");
                      document.getElementById("2112-f2").value="" }} >
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

      {/* Key Indicator: 2.1.2 */}
      <div className="c21x-eachInputField-container">
        <div className="c21x-weightage-container">
          <h1 className="c21x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c21x-container">
            <div className="c21x-heading_Help-container">
              <h1 className="c21x-heading-style">
                <span className="c21x-span-style">2.1.2: </span>
                Percentage of seats filled against reserved categories (SC, ST, OBC etc.) as per applicable reservation policy for the first year admissionduring the last five years
              </h1>
              <button
                onClick={handleHelpOpen2}
                className="c21x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen2}
                handleClose={handleHelpClose2}
                title='formula'
                ><h1>(Total number of students admitted against the reserved categories) /(Total number of seats earmarked for reserved category as per GOI or State Government Rule) * 100</h1></HelpButton>
            </div>
            <div className="c21x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus212(!responseButtonStatus212);
                  onClickingViewResponse212();
                }}
                className="c21x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus212 ? (
                <p className="c21x-responseResult-style">{responseValue212}</p>
              ) : null}
            </div>
          </div>
          <div className="c21xx-container">
            <h1 className="c21xx-Heading-style">
              <span className="c21xx-span-style">2.1.2.1: </span>
              Number of actual students admitted from the reserved categories year wise during the last five years
            </h1>
            <table className="c21x-Qt-table-style">
              <tr>
                <th className="c21x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue2121t1(e.target.value)}
                      id="2121-t1"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t1}
                    />
                    {value2121t1 === '' ? (
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
                      onChange={(e) => setValue2121t2(e.target.value)}
                      id="2121-t2"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t2}
                    />
                    {value2121t2 === '' ? (
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
                      onChange={(e) => setValue2121t3(e.target.value)}
                      id="2121-t3"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t3}
                    />
                    {value2121t3 === '' ? (
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
                      onChange={(e) => setValue2121t4(e.target.value)}
                      id="2121-t4"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t4}
                    />
                    {value2121t4 === '' ? (
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
                        setValue2121t5(e.target.value);
                        onClickingViewResponse212();
                      }}
                      id="2121-t5"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t5}
                    />
                    {value2121t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c21x-horizontalTable-heading-style">
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
                        setValue2121t6(e.target.value);
                        onClickingViewResponse212();
                      }}
                      id="2121-t6"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t6}
                    />
                    {value2121t6 === '' ? (
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
                        setValue2121t7(e.target.value);
                        onClickingViewResponse212();
                      }}
                      id="2121-t7"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t7}
                    />
                    {value2121t7 === '' ? (
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
                        setValue2121t8(e.target.value);
                        onClickingViewResponse212();
                      }}
                      id="2121-t8"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t8}
                    />
                    {value2121t8 === '' ? (
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
                        setValue2121t9(e.target.value);
                        onClickingViewResponse212();
                      }}
                      id="2121-t9"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t9}
                    />
                    {value2121t9 === '' ? (
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
                        setValue2121t10(e.target.value);
                        onClickingViewResponse212();
                      }}
                      id="2121-t10"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t10}
                    />
                    {value2121t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <h1 className="c21xx-Heading-style">
              <span className="c21xx-span-style">2.1.2.2: </span>
               Number of seats earmarked for reserved category as per GoI/State Govt. rule year wise during the last five years
            </h1>
            <table className="c21x-Qt-table-style">
              <tr>
                <th className="c21x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue2121t11(e.target.value)}
                      id="2121-t11"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t11}
                    />
                    {value2121t11 === '' ? (
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
                      onChange={(e) => setValue2121t12(e.target.value)}
                      id="2121-t12"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t12}
                    />
                    {value2121t12 === '' ? (
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
                      onChange={(e) => setValue2121t13(e.target.value)}
                      id="2121-t13"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t13}
                    />
                    {value2121t13 === '' ? (
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
                      onChange={(e) => setValue2121t14(e.target.value)}
                      id="2121-t14"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t14}
                    />
                    {value2121t14 === '' ? (
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
                      onChange={(e) => setValue2121t15(e.target.value)}
                      id="2121-t15"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t15}
                    />
                    {value2121t15 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c21x-horizontalTable-heading-style">
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
                        setValue2121t16(e.target.value);
                        onClickingViewResponse212();
                      }}
                      id="2121-t16"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t16}
                    />
                    {value2121t16 === '' ? (
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
                        setValue2121t17(e.target.value);
                        onClickingViewResponse212();
                      }}
                      id="2121-t17"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t17}
                    />
                    {value2121t17 === '' ? (
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
                        setValue2121t18(e.target.value);
                        onClickingViewResponse212();
                      }}
                      id="2121-t18"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t18}
                    />
                    {value2121t18 === '' ? (
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
                        setValue2121t19(e.target.value);
                        onClickingViewResponse212();
                      }}
                      id="2121-t19"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t19}
                    />
                    {value2121t19 === '' ? (
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
                        setValue2121t20(e.target.value);
                        onClickingViewResponse212();
                      }}
                      id="2121-t20"
                      className="c21x-input-style"
                      type="number"
                      value={value2121t20}
                    />
                    {value2121t20 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <table className="c21x-table-style">
              <tr>
                <th className="c21x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c21x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c21x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c21x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td> Any Additional Information </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2121f1(e.target.files[0]);
                      setPathValue2121f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2121-f1"
                    className="c21-fileButton-style"
                    accept='.pdf'
                    type="file"
                  />
                  {pathValue2121f1 === '' ? null : (
                    <div className="c21-fileButtons-container">
                      <button className="c21-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2121f1("");
                      document.getElementById("2121-f1").value="" }} >
                      Reset
                    </button>

                    </div>
                  )}
                </td>
                <td className="c21x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Average percentage of seats filled against seats reserved</td>
                <td><a href={downloadFile("au2.1.2.xlsx")} target="_blank">View Template</a></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2121f2(e.target.files[0]);
                      setPathValue2121f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2121-f2"
                    className="c21-fileButton-style"
                    accept='.pdf'
                    type="file"
                  />
                  {pathValue2112f2 === '' ? null : (
                    <div className="c21-fileButtons-container">
                      <button className="c21-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2112f2("");
                      document.getElementById("2121-f2").value="" }} >
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
      <div className="c21x-button-container">
        <button onClick={onClickingSave} className="c21x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria21;
