import React, { useState,useEffect } from 'react';
import './c33-style.css';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import { HelpButton } from '../../../../../reusableComponents/model/Help';
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

function Help331(props) {
  return props.isHelp331Clicked ? (
    <div className="c33x-help-mainContainer">
      <div className="c33x-help-subContainer">
        <h1 className="c33x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c33x-help-para-style">
          Number of research papers in the Journals notified on UGC website
          during the last five years{' '}
          <span style={{ fontWeight: 'bold' }}> / </span>
          Average number of full time teachers during last five years
        </p>
        <button
          className="c33x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp331Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help332(props) {
  return props.isHelp332Clicked ? (
    <div className="c33x-help-mainContainer">
      <div className="c33x-help-subContainer">
        <h1 className="c33x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c33x-help-para-style">
          Total number of books and chapters in edited volumes / books
          published, and papers in national/international conference-proceedings
          year wise during last five years
          <span style={{ fontWeight: 'bold' }}> / </span>
          Average number of full time teachers during last five years
        </p>
        <button
          className="c33x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp332Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}


function Criteria33() {
   // /this is Help button 
   const [isOpen, setIsopen] = useState(false)
   const handleHelpOpen = (e) => {
     e.preventDefault(),
     setIsopen(true)
   }
   const handleHelpClose = () => {
     setIsopen(false)
   }
   const [isOpen2, setIsopen2] = useState(false)
   const handleHelpOpen2 = (e) => {
     e.preventDefault(),
     setIsopen2(true)
   }
   const handleHelpClose2 = () => {
     setIsopen2(false)
   }
  // state variables
   // getfile data with API
   function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }

  const [value3311t1, setValue3311t1] = useState();
  const [value3311t2, setValue3311t2] = useState();
  const [value3311t3, setValue3311t3] = useState();
  const [value3311t4, setValue3311t4] = useState();
  const [value3311t5, setValue3311t5] = useState();
  const [value3311t6, setValue3311t6] = useState();
  const [value3311t7, setValue3311t7] = useState();
  const [value3311t8, setValue3311t8] = useState();
  const [value3311t9, setValue3311t9] = useState();
  const [value3311t10, setValue3311t10] = useState();
  const [value3311t11, setValue3311t11] = useState();
  const [value3311f1, setValue3311f1] = useState('');
  const [pathValue3311f1, setPathValue3311f1] = useState('');
  const [value3311f2, setValue3311f2] = useState('');
  const [pathValue3311f2, setPathValue3311f2] = useState('');
  const [responseButtonStatus331, setResponseButtonStatus331] = useState(false);
  const [responseValue331, setResponseValue331] = useState('');
  const [help331Status, setHelp331Status] = useState(false);

  const [value3321t1, setValue3321t1] = useState();
  const [value3321t2, setValue3321t2] = useState();
  const [value3321t3, setValue3321t3] = useState();
  const [value3321t4, setValue3321t4] = useState();
  const [value3321t5, setValue3321t5] = useState();
  const [value3321t6, setValue3321t6] = useState();
  const [value3321t7, setValue3321t7] = useState();
  const [value3321t8, setValue3321t8] = useState();
  const [value3321t9, setValue3321t9] = useState();
  const [value3321t10, setValue3321t10] = useState();
  const [value3321t11, setValue3321t11] = useState('');
  const [value3321f1, setValue3321f1] = useState('');
  const [pathValue3321f1, setPathValue3321f1] = useState('');
  const [value3321f2, setValue3321f2] = useState('');
  const [pathValue3321f2, setPathValue3321f2] = useState('');
  const [responseButtonStatus332, setResponseButtonStatus332] = useState(false);
  const [responseValue332, setResponseValue332] = useState('');
  const [help332Status, setHelp332Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');

  // get data  with API
  const financialYear="2021-2022";
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
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

  useEffect(
    () => fetch(resources.APPLICATION_URL+'criteria3getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));
   
          setValue3311t11(data[0].criteria33Ql[0]?data[0].criteria33Ql[0].input331t1:"");
          setValue3321t11(data[0].criteria33Qn[0]?data[0].criteria33Ql[0].input3321t11:"");
          
          // setResponseValue111(data[0].criteria1FieldInfoQl[1].response111);
          // setResponseValue112(data[0].criteria1FieldInfoQn[2].response112);
          // setResponseValue113(data[0].criteria1FieldInfoQn[3].response113);

          setValue3311t1(data[0].affiliatedYearTable3311[0]?data[0].affiliatedYearTable3311[0].input3311y:"");
          setValue3311t2(data[0].affiliatedYearTable3311[1]?data[0].affiliatedYearTable3311[1].input3311y:"");
          setValue3311t3(data[0].affiliatedYearTable3311[2]?data[0].affiliatedYearTable3311[2].input3311y:"");
          setValue3311t4(data[0].affiliatedYearTable3311[3]?data[0].affiliatedYearTable3311[3].input3311y:"");
          setValue3311t5(data[0].affiliatedYearTable3311[4]?data[0].affiliatedYearTable3311[4].input3311y:"");
          setValue3311t6(data[0].affiliatedYearTable3311[0]?data[0].affiliatedYearTable3311[0].input3311v:"");
          setValue3311t7(data[0].affiliatedYearTable3311[1]?data[0].affiliatedYearTable3311[1].input3311v:"");
          setValue3311t8(data[0].affiliatedYearTable3311[2]?data[0].affiliatedYearTable3311[2].input3311v:"");
          setValue3311t9(data[0].affiliatedYearTable3311[3]?data[0].affiliatedYearTable3311[3].input3311v:"");
          setValue3311t10(data[0].affiliatedYearTable3311[4]?data[0].affiliatedYearTable3311[4].input3311v:"");

          setValue3321t1(data[0].yearTable3321[0]?data[0].yearTable3321[0].input3321y:"");
          setValue3321t2(data[0].yearTable3321[1]?data[0].yearTable3321[1].input3321y:"");
          setValue3321t3(data[0].yearTable3321[2]?data[0].yearTable3321[2].input3321y:"");
          setValue3321t4(data[0].yearTable3321[3]?data[0].yearTable3321[3].input3321y:"");
          setValue3321t5(data[0].yearTable3321[4]?data[0].yearTable3321[4].input3321y:"");
          setValue3321t6(data[0].yearTable3321[0]?data[0].yearTable3321[0].input3321v:"");
          setValue3321t7(data[0].yearTable3321[1]?data[0].yearTable3321[1].input3321v:"");
          setValue3321t8(data[0].yearTable3321[2]?data[0].yearTable3321[2].input3321v:"");
          setValue3321t9(data[0].yearTable3321[3]?data[0].yearTable3321[2].input3321v:"");
          setValue3321t10(data[0].yearTable3321[4]?data[0].yearTable3321[4].input3321v:"");

          setValue3321f1(data[0].criteria3FileUpload[0]?data[0].criteria3FileUpload[0].criteria3FileName:"");
          setValue3321f2(data[0].criteria3FileUpload[1]?data[0].criteria3FileUpload[1].criteria3FileName:"");
          setValue3311f1(data[0].criteria3FileUpload[2]?data[0].criteria3FileUpload[2].criteria3FileName:"");
          setValue3311f2(data[0].criteria3FileUpload[3]?data[0].criteria3FileUpload[3].criteria3FileName:"");
         
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ),
    []
  );

 
  // sending data to db with API
  
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
    criteria33Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
        uniqueKey1: 101,
        input3321t11: value3321t11,
        response332: responseValue332,
      },
    ],
    criteria33Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
        uniqueKey1: 101,
        
        input331t1: value3311t11,
        response331: responseValue331,
       
      },
    ],
    affiliatedYearTable3311: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 101, input3311y: value3311t1, input3311v: value3311t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 102, input3311y: value3311t2, input3311v: value3311t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 103, input3311y: value3311t3, input3311v: value3311t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 104, input3311y: value3311t4, input3311v: value3311t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 105, input3311y: value3311t5, input3311v: value3311t10
      },
    ],
    yearTable3321: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 101, input3321y: value3321t1, input3321v: value3321t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 102, input3321y: value3321t2, input3321v: value3321t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 103, input3321y: value3321t3, input3321v: value3321t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 104, input3321y: value3321t4, input3321v: value3321t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 105, input3321y: value3321t5, input3321v: value3321t10
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form33Data = new FormData();

    form33Data.append('criteria3Fieldinfo', jsonBlob(inputDataList));
    if (pathValue3311f1 !== '') {
      form33Data.append(
        'uploadfile3',
        value3311f1,
        'f3311f1-' + value3311f1.name
      );
    }
    if (pathValue3311f2 !== '') {
      form33Data.append(
        'uploadfile3',
        value3311f2,
        'f3311f2-' + value3311f2.name
      );
    }
    if (pathValue3321f1 !== '') {
      form33Data.append(
        'uploadfile3',
        value3321f1,
        'f3321f1-' + value3321f1.name
      );
    }
    if (pathValue3321f2 !== '') {
      form33Data.append(
        'uploadfile3',
        value3321f2,
        'f3321f2-' + value3321f2.name
      );
    }
    if (pathValue3321f2 !== '') {
      form33Data.append('uploadfile3', value336f2, 'f336f2-' + value336f2.name);
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form33Data,
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
  // response button functionalities

  function onClickingViewResponse331() {
    if (
      value3311t6 === ''
      || value3311t7 === ''
      || value3311t8 === ''
      || value3311t9 === ''
      || value3311t10 === ''
      || value3311t11 === ''
      || value3311t6 === undefined
      || value3311t7 === undefined
      || value3311t8 === undefined
      || value3311t9 === undefined
      || value3311t10 === undefined
      || value3311t11 === undefined
    ) {
      setResponseValue331('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3311t6, 10)) === false
      || Number.isInteger(parseInt(value3311t7, 10)) === false
      || Number.isInteger(parseInt(value3311t8, 10)) === false
      || Number.isInteger(parseInt(value3311t9, 10)) === false
      || Number.isInteger(parseInt(value3311t10, 10)) === false
      || Number.isInteger(parseInt(value3311t11, 10)) === false
    ) {
      setResponseValue331('Input should be an Integer');
    } else if (
      value3311t6 !== ''
      && value3311t7 !== ''
      && value3311t8 !== ''
      && value3311t9 !== ''
      && value3311t10 !== ''
      && value3311t11 !== ''
    ) {
      setResponseValue331(
        (parseInt(value3311t6, 10)
          + parseInt(value3311t7, 10)
          + parseInt(value3311t8, 10)
          + parseInt(value3311t9, 10)
          + parseInt(value3311t10, 10))
          / parseInt(value3311t11, 10)
      );
    }
  }
  function onClickingViewResponse332() {
    if (
      value3321t6 === ''
      || value3321t7 === ''
      || value3321t8 === ''
      || value3321t9 === ''
      || value3321t10 === ''
      || value3321t11 === ''
      || value3321t6 === undefined
      || value3321t7 === undefined
      || value3321t8 === undefined
      || value3321t9 === undefined
      || value3321t10 === undefined
      || value3321t11 === undefined
    ) {
      setResponseValue332('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3321t6, 10)) === false
      || Number.isInteger(parseInt(value3321t7, 10)) === false
      || Number.isInteger(parseInt(value3321t8, 10)) === false
      || Number.isInteger(parseInt(value3321t9, 10)) === false
      || Number.isInteger(parseInt(value3321t10, 10)) === false
      || Number.isInteger(parseInt(value3321t11, 10)) === false
    ) {
      setResponseValue332('Input should be an Integer');
    } else if (
      value3321t6 !== ''
      && value3321t7 !== ''
      && value3321t8 !== ''
      && value3321t9 !== ''
      && value3321t10 !== ''
      && value3321t11 !== ''
    ) {
      setResponseValue332(
        (parseInt(value3321t6, 10)
          + parseInt(value3321t7, 10)
          + parseInt(value3321t8, 10)
          + parseInt(value3321t9, 10)
          + parseInt(value3321t10, 10))
          / parseInt(value3321t11, 10)
      );
    }
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
    <div className="c33-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c33x-colorIndicator-container">
        <p className="c33x-QlcolorIndicator-circle-style"></p>
        <span className="c33x-colorIndicator-span-style">Qualitative</span>
        <p className="c33x-QtcolorIndicator-circle-style"></p>
        <span className="c33x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c33x-weightage-heading-style">
            Key Indicator Weightage: 25
          </h1>
        </div>
      </div>

      {/* Key Indicator: 3.3.1 */}
      <div className="c33x-eachInputField-container">
        <div className="c33x-weightage-container">
          <h1 className="c33x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c33x-container">
            <div className="c33x-heading_Help-container">
              <h1 className="c33x-heading-style">
                <span className="c33x-span-style">3.3.1: </span>
                Number of research papers per teachers in the Journals notified
                on UGC website during the last five years
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
                title='Total number of research papers in the Journals'
                >
                  <h1>(notified on UGC CARE / Number of full time teachers during the last five years (without repeat count))</h1>
                </HelpButton>
            </div>
            <div className="c33x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus331(!responseButtonStatus331);
                  onClickingViewResponse331();
                }}
                className="c33x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus331 ? (
                <p className="c33x-responseResult-style">{responseValue331}</p>
              ) : null}
            </div>
          </div>
          <div className="c33xx-container">
            <h1 className="c33xx-Heading-style">
              <span className="c33xx-span-style">3.3.1.1: </span>
              Number of research papers in the Journals notified on UGC website
              during the last five years
            </h1>

            <table className="c33x-Qt-table-style">
              <tr>
                <th className="c33x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3311t1(e.target.value)}
                      id="3311-t1"
                      className="c33x-input-style"
                      type="text"
                      value={value3311t1}
                    />
                    {value3311t1 === '' ? (
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
                      onChange={(e) => setValue3311t2(e.target.value)}
                      id="3311-t2"
                      className="c33x-input-style"
                      type="text"
                      value={value3311t2}
                    />
                    {value3311t2 === '' ? (
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
                      onChange={(e) => setValue3311t3(e.target.value)}
                      id="3311-t3"
                      className="c33x-input-style"
                      type="text"
                      value={value3311t3}
                    />
                    {value3311t3 === '' ? (
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
                      onChange={(e) => setValue3311t4(e.target.value)}
                      id="3311-t4"
                      className="c33x-input-style"
                      type="text"
                      value={value3311t4}
                    />
                    {value3311t4 === '' ? (
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
                      onChange={(e) => setValue3311t5(e.target.value)}
                      id="3311-t5"
                      className="c33x-input-style"
                      type="text"
                      value={value3311t5}
                    />
                    {value3311t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c33x-horizontalTable-heading-style">
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
                      onChange={(e) => setValue3311t6(e.target.value)}
                      id="3311-t6"
                      className="c33x-input-style"
                      type="text"
                      value={value3311t6}
                    />
                    {value3311t6 === '' ? (
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
                      onChange={(e) => setValue3311t7(e.target.value)}
                      id="3311-t7"
                      className="c33x-input-style"
                      type="text"
                      value={value3311t7}
                    />
                    {value3311t7 === '' ? (
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
                      onChange={(e) => setValue3311t8(e.target.value)}
                      id="3311-t8"
                      className="c33x-input-style"
                      type="text"
                      value={value3311t8}
                    />
                    {value3311t8 === '' ? (
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
                      onChange={(e) => setValue3311t9(e.target.value)}
                      id="3311-t9"
                      className="c33x-input-style"
                      type="text"
                      value={value3311t9}
                    />
                    {value3311t9 === '' ? (
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
                      onChange={(e) => setValue3311t10(e.target.value)}
                      id="3311-t10"
                      className="c33x-input-style"
                      type="text"
                      value={value3311t10}
                    />
                    {value3311t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            {/* <div className="c31xx-label-textInput-container">
              <label className="c31xx-Heading-style">
                Average number of full time teachers during the last five years
              </label>
              <input
                onChange={(e) => setValue3311t11(e.target.value)}
                id="3311-t11"
                style={{ marginLeft: '4%' }}
                type="text"
                value={value3311t11}
              />
              {value3311t11 === '' ? <p style={{ color: 'red' }}>*</p> : null}
            </div> */}

            <table className="c33x-table-style">
              <tr>
                <th className="c33x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c33x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c33x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c33x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                <input
                    onChange={(e) => {
                      setValue3311f1(e.target.files[0]);
                      setPathValue3311f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3311-f1"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue3311f1 === '' ? null : (
                    <div className="c27-fileButtons-container">
                      <button className="c27-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3311f1("");
                      document.getElementById("3311-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value3311f1)} target="_blank">View File</a>
                 */}
                </td>
                <td className="c33x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List of research papers by title, author, department, name and
                  year of publication
                </td>
                <td>
                <a href={downloadFile("af3.3.1.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                <input
                    onChange={(e) => {
                      setValue3311f2(e.target.files[0]);
                      setPathValue3311f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3311-f2"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue3311f2 === '' ? null : (
                    <div className="c27-fileButtons-container">
                      <button className="c27-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3311f2("");
                      document.getElementById("3311-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value3311f2)} target="_blank">View File</a> */}
                
                </td>
                <td className="c33x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 3.3.2 */}
      <div className="c33x-eachInputField-container">
        <div className="c33x-weightage-container">
          <h1 className="c33x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c33x-container">
            <div className="c33x-heading_Help-container">
              <h1 className="c33x-heading-style">
                <span className="c33x-span-style">3.3.2: </span>
                Total number of books and chapters in edited volumes/books published and papers in national/ international 
                conference proceedings year wise during last five years
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
                >
                  <h1>Total number of books and chapters in edited volumes/books published and papers in national/international conference proceedings / Number of full time teachers during the last five years (without repeat count)</h1>
                </HelpButton>
            </div>
            <div className="c33x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus332(!responseButtonStatus332);
                  onClickingViewResponse332();
                }}
                className="c33x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus332 ? (
                <p className="c33x-responseResult-style">{responseValue332}</p>
              ) : null}
            </div>
          </div>
          <div className="c33xx-container">
            <h1 className="c33xx-Heading-style">
              <span className="c33xx-span-style">3.3.2.1: </span>
              Total number of books and chapters in edited volumes/books
              published and papers in national/ international conference
              proceedings year-wise during last five years
            </h1>

            <table className="c33x-Qt-table-style">
              <tr>
                <th className="c33x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3321t1(e.target.value)}
                      id="3321-t1"
                      className="c33x-input-style"
                      type="text"
                      value={value3321t1}
                    />
                    {value3321t1 === '' ? (
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
                      onChange={(e) => setValue3321t2(e.target.value)}
                      id="3321-t2"
                      className="c33x-input-style"
                      type="text"
                      value={value3321t2}
                    />
                    {value3321t2 === '' ? (
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
                      onChange={(e) => setValue3321t3(e.target.value)}
                      id="3321-t3"
                      className="c33x-input-style"
                      type="text"
                      value={value3321t3}
                    />
                    {value3321t3 === '' ? (
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
                      onChange={(e) => setValue3321t4(e.target.value)}
                      id="3321-t4"
                      className="c33x-input-style"
                      type="text"
                      value={value3321t4}
                    />
                    {value3321t4 === '' ? (
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
                      onChange={(e) => setValue3321t5(e.target.value)}
                      id="3321-t5"
                      className="c33x-input-style"
                      type="text"
                      value={value3321t5}
                    />
                    {value3321t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c33x-horizontalTable-heading-style">
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
                      onChange={(e) => setValue3321t6(e.target.value)}
                      id="3321-t6"
                      className="c33x-input-style"
                      type="text"
                      value={value3321t6}
                    />
                    {value3321t6 === '' ? (
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
                      onChange={(e) => setValue3321t7(e.target.value)}
                      id="3321-t7"
                      className="c33x-input-style"
                      type="text"
                      value={value3321t7}
                    />
                    {value3321t7 === '' ? (
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
                      onChange={(e) => setValue3321t8(e.target.value)}
                      id="3321-t8"
                      className="c33x-input-style"
                      type="text"
                      value={value3321t8}
                    />
                    {value3321t8 === '' ? (
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
                      onChange={(e) => setValue3321t9(e.target.value)}
                      id="3321-t9"
                      className="c33x-input-style"
                      type="text"
                      value={value3321t9}
                    />
                    {value3321t9 === '' ? (
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
                      onChange={(e) => setValue3321t10(e.target.value)}
                      id="3321-t10"
                      className="c33x-input-style"
                      type="text"
                      value={value3321t10}
                    />
                    {value3321t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            {/* <div className="c33xx-label-textInput-container">
              <label className="c33xx-Heading-style">
                Average number of full time teachers during the last five years
              </label>
              <input
                onChange={(e) => setValue3321t11(e.target.value)}
                id="3321-t11"
                style={{ marginLeft: '4%' }}
                type="number"
                value={value3321t11}
              />
              {value3321t11 === '' ? <p style={{ color: 'red' }}>*</p> : null}
            </div> */}

            <table className="c33x-table-style">
              <tr>
                <th className="c33x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c33x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c33x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c33x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                <input
                    onChange={(e) => {
                      setValue3321f1(e.target.files[0]);
                      setPathValue3321f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3321-f1"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue3321f1 === '' ? null : (
                    <div className="c27-fileButtons-container">
                      <button className="c27-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3321f1("");
                      document.getElementById("3321-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value3321f1)} target="_blank">View File</a>
                 */}
                </td>
                <td className="c33x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List books and chapters in edited volumes / books published
                </td>
                <td>
                <a href={downloadFile("af3.3.2.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                <input
                    onChange={(e) => {
                      setValue3321f2(e.target.files[0]);
                      setPathValue3321f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3321-f2"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue3321f2 === '' ? null : (
                    <div className="c27-fileButtons-container">
                      <button className="c27-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3321f2("");
                      document.getElementById("3321-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value3321f2)} target="_blank">View File</a> */}
                
                </td>
                <td className="c33x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
      
      <div className="c33x-button-container">
        <button onClick={onClickingSave} className="c33x-button-style">
          Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria33;
