import React, { useState, useEffect } from 'react';
import './c53-style.css';
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

// Help buttons functionality
function Help531(props) {
  return props.isHelp531Clicked ? (
    <div className="c53x-help-mainContainer">
      <div className="c53x-help-subContainer">
        <h1 className="c53x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c53x-help-para-style">
          Number of awards/medals for outstanding performance in sports/cultural
          activities at inter-university / state / national / international
          level.
        </p>
        <button
          className="c53x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp531Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help532(props) {
  return props.isHelp532Clicked ? (
    <div className="c53x-help-mainContainer">
      <div className="c53x-help-subContainer">
        <h1 className="c53x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c53x-help-para-style">
          Describe the Student Council activity and students role in academic &
          administrative bodies within a minimum of 500 characters and maximum
          of 500 words
        </p>
        <button
          className="c53x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp532Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria53() {
 // /this is Help button 
 const [isOpen, setIsopen] = useState(false)
 const handleHelpOpen = (e) => {
   e.preventDefault(),
   setIsopen(true)
 }
 const handleHelpClose = () => {
   setIsopen(false)
 }
 function downloadFile(fileName) {
  const filePath = resources.APPLICATION_URL + "download/" + fileName;
  return filePath;
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

  const [value5311t1, setValue5311t1] = useState();
  const [value5311t2, setValue5311t2] = useState();
  const [value5311t3, setValue5311t3] = useState();
  const [value5311t4, setValue5311t4] = useState();
  const [value5311t5, setValue5311t5] = useState();
  const [value5311t6, setValue5311t6] = useState();
  const [value5311t7, setValue5311t7] = useState();
  const [value5311t8, setValue5311t8] = useState();
  const [value5311t9, setValue5311t9] = useState();
  const [value5311t10, setValue5311t10] = useState();
  const [pathValue5311f1, setPathValue5311f1] = useState('');
  const [pathValue5311f2, setPathValue5311f2] = useState('');
  const [pathValue5311f3, setPathValue5311f3] = useState('');
  const [value5311f1, setValue5311f1] = useState([]);
  const [value5311f2, setValue5311f2] = useState([]);
  const [value5311f3, setValue5311f3] = useState([]);

  const [value532t1, setValue532t1] = useState();

  const [value5321t1, setValue5321t1] = useState();
  const [value5321t2, setValue5321t2] = useState();
  const [value5321t3, setValue5321t3] = useState();
  const [value5321t4, setValue5321t4] = useState();
  const [value5321t5, setValue5321t5] = useState();
  const [value5321t6, setValue5321t6] = useState();
  const [value5321t7, setValue5321t7] = useState();
  const [value5321t8, setValue5321t8] = useState();
  const [value5321t9, setValue5321t9] = useState();
  const [value5321t10, setValue5321t10] = useState();

  const [pathValue5321f1, setPathValue5321f1] = useState('');
  const [pathValue5321f2, setPathValue5321f2] = useState('');
  const [pathValue5321f3, setPathValue5321f3] = useState('');
  const [value5321f1, setValue5321f1] = useState([]);
  const [value5321f2, setValue5321f2] = useState([]);
  const [value5321f3, setValue5321f3] = useState([]);

  const [responseButtonStatus531, setResponseButtonStatus531] = useState(false);
  const [responseButtonStatus532, setResponseButtonStatus532] = useState(false);

  const [responseValue531, setResponseValue531] = useState('');
  const [responseValue532, setResponseValue532] = useState('');

  const [help531Status, setHelp531Status] = useState(false);
  const [help532Status, setHelp532Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');




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

   // get data  with API
   const financialYear ="2021-2022";
   function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
  }

  useEffect(
    () => fetch(resources.APPLICATION_URL+'criteria5getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));

          setValue5311t1(data[0].yearTable5311[0]?data[0].yearTable5311[0].input5311y:"");
          setValue5311t2(data[0].yearTable5311[1]?data[0].yearTable5311[1].input5311y:"");
          setValue5311t3(data[0].yearTable5311[2]?data[0].yearTable5311[2].input5311y:"");
          setValue5311t4(data[0].yearTable5311[3]?data[0].yearTable5311[3].input5311y:"");
          setValue5311t5(data[0].yearTable5311[4]?data[0].yearTable5311[4].input5311y:"");
          setValue5311t6(data[0].yearTable5311[0]?data[0].yearTable5311[0].input5311v:"");
          setValue5311t7(data[0].yearTable5311[1]?data[0].yearTable5311[1].input5311v:"");
          setValue5311t8(data[0].yearTable5311[2]?data[0].yearTable5311[2].input5311v:"");
          setValue5311t9(data[0].yearTable5311[3]?data[0].yearTable5311[3].input5311v:"");
          setValue5311t10(data[0].yearTable5311[4]?data[0].yearTable5311[4].input5311v:"");

          setValue5321t1(data[0].affiliatedYearTable5321[0]?data[0].affiliatedYearTable5321[0].input5321y:"");
          setValue5321t2(data[0].affiliatedYearTable5321[1]?data[0].affiliatedYearTable5321[1].input5321y:"");
          setValue5321t3(data[0].affiliatedYearTable5321[2]?data[0].affiliatedYearTable5321[2].input5321y:"");
          setValue5321t4(data[0].affiliatedYearTable5321[3]?data[0].affiliatedYearTable5321[3].input5321y:"");
          setValue5321t5(data[0].affiliatedYearTable5321[4]?data[0].affiliatedYearTable5321[4].input5321y:"");
          setValue5321t6(data[0].affiliatedYearTable5321[0]?data[0].affiliatedYearTable5321[0].input5321v:"");
          setValue5321t7(data[0].affiliatedYearTable5321[1]?data[0].affiliatedYearTable5321[1].input5321v:"");
          setValue5321t8(data[0].affiliatedYearTable5321[2]?data[0].affiliatedYearTable5321[2].input5321v:"");
          setValue5321t9(data[0].affiliatedYearTable5321[3]?data[0].affiliatedYearTable5321[3].input5321v:"");
          setValue5321t10(data[0].affiliatedYearTable5321[4]?data[0].affiliatedYearTable5321[4].input5321v:"");

          setValue5311f1(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");
          setValue5311f2(data[0].criteria5FileUpload[1]?data[0].criteria5FileUpload[1].criteria5FileName:"");
          setValue5311f3(data[0].criteria5FileUpload[2]?data[0].criteria5FileUpload[2].criteria5FileName:"");
          setValue5321f1(data[0].criteria5FileUpload[3]?data[0].criteria5FileUpload[3].criteria5FileName:"");
          setValue5321f2(data[0].criteria5FileUpload[4]?data[0].criteria5FileUpload[4].criteria5FileName:"");
          
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ), []
  );

  // response button functionality
  function onClickingViewResponse531() {
    if (
      value5311t6 === ''
      || value5311t7 === ''
      || value5311t8 === ''
      || value5311t9 === ''
      || value5311t10 === ''
      || value5311t6 === undefined
      || value5311t7 === undefined
      || value5311t8 === undefined
      || value5311t9 === undefined
      || value5311t10 === undefined
    ) {
      setResponseValue531('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value5311t6, 10)) === false
      || Number.isInteger(parseInt(value5311t7, 10)) === false
      || Number.isInteger(parseInt(value5311t8, 10)) === false
      || Number.isInteger(parseInt(value5311t9, 10)) === false
      || Number.isInteger(parseInt(value5311t10, 10)) === false
    ) {
      setResponseValue531('Input should be an Integer');
    } else if (
      value5311t6 !== ''
      && value5311t7 !== ''
      && value5311t8 !== ''
      && value5311t9 !== ''
      && value5311t10 !== ''
    ) {
      setResponseValue531(
        value5311t6 + value5311t7 + value5311t8 + value5311t9 + value5311t10
      );
    }
  }

  function onClickingViewResponse532() {
    if (
      value5321t6 === ''
      || value5321t7 === ''
      || value5321t8 === ''
      || value5321t9 === ''
      || value5321t10 === ''
      || value5321t6 === undefined
      || value5321t7 === undefined
      || value5321t8 === undefined
      || value5321t9 === undefined
      || value5321t10 === undefined
    ) {
      setResponseValue532('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value5321t6, 10)) === false
      || Number.isInteger(parseInt(value5321t7, 10)) === false
      || Number.isInteger(parseInt(value5321t8, 10)) === false
      || Number.isInteger(parseInt(value5321t9, 10)) === false
      || Number.isInteger(parseInt(value5321t10, 10)) === false
    ) {
      setResponseValue532('Input should be an Integer');
    } else if (
      value5321t6 !== ''
      && value5321t7 !== ''
      && value5321t8 !== ''
      && value5321t9 !== ''
      && value5321t10 !== ''
    ) {
      setResponseValue532(
        (value5321t6 + value5321t7 + value5321t8 + value5321t9 + value5321t10)
          / 5
      );
    }
  }
  // sending data to db with API
  
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
    // criteria5FieldInfoQl: [
    //   {
    //     criteriaId: { collegeId: '1', financialYear: financialYear, typeofInstitution: "affiliated" },
    //     uniqueKey1: 3,
    //   input532t1: value532t1,
    //   response532: responseValue532,
    // },
    // ],
   
    criteria53Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 101,
      response531: responseValue531,
      response532: responseValue532,
      criteria53status:"save"
    },
    ],
    yearTable5311: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 101, input5311y: value5311t1, input5311v: value5311t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 102, input5311y: value5311t2, input5311v: value5311t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 103, input5311y: value5311t3, input5311v: value5311t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 104, input5311y: value5311t4, input5311v: value5311t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 105, input5311y: value5311t5, input5311v: value5311t10
      },
    ],

    affiliatedYearTable5321: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 101, input5321y: value5321t1, input5321v: value5321t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 102, input5321y: value5321t2, input5321v: value5321t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 103, input5321y: value5321t3, input5321v: value5321t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 104, input5321y: value5321t4, input5321v: value5321t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 105, input5321y: value5321t5, input5321v: value5321t10
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form53Data = new FormData();

    form53Data.append('criteria5Fieldinfo', jsonBlob(inputDataList));
    if (pathValue5311f1 !== '') {
      form53Data.append(
        'uploadfile5',
        value5311f1,
        'f5311f1-' + value5311f1.name
      );
    }
    if (pathValue5311f2 !== '') {
      form53Data.append(
        'uploadfile5',
        value5311f2,
        'f5311f2-' + value5311f2.name
      );
    }
    if (pathValue5311f3 !== '') {
      form53Data.append(
        'uploadfile5',
        value5311f3,
        'f5311f3-' + value5311f3.name
      );
    }
    if (pathValue5321f1 !== '') {
      form53Data.append(
        'uploadfile5',
        value5321f1,
        'f5321f1-' + value5321f1.name
      );
    }
    if (pathValue5321f2 !== '') {
      form53Data.append(
        'uploadfile5',
        value5321f2,
        'f5321f2-' + value5321f2.name
      );
    }


    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form53Data,
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
    <div className="c53-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c53x-colorIndicator-container">
        <p className="c53x-QlcolorIndicator-circle-style"></p>
        <span className="c53x-colorIndicator-span-style">Qualitative</span>
        <p className="c53x-QtcolorIndicator-circle-style"></p>
        <span className="c53x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c53x-weightage-heading-style">
            Key Indicator Weightage: 45
          </h1>
        </div>
      </div>
      {/* Key Indicator: 5.3.1 */}
      <div className="c53x-eachInputField-container">
        <div className="c53x-weightage-container">
          <h1 className="c53x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c53x-container">
            <div className="c53x-heading_Help-container">
              <h1 className="c53x-heading-style">
                <span className="c53x-span-style">5.3.1: </span>
                Number of awards/medals for outstanding performance in
                sports/cultural activities at inter-university / state /national
                / international events (award for a team event should be counted
                as one) during the last five years
              </h1>
              <button
                onClick={handleHelpOpen}
              className="c53x-helpButton-style"
                >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='File Description'
                ></HelpButton>
            </div>
            <div className="c53x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus531(!responseButtonStatus531); onClickingViewResponse531();
                }}
                className="c53x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus531 ? (
                <p className="c53x-responseResult-style">{responseValue531}</p>
              ) : null}
            </div>
          </div>
          <div className="c53xx-container">
            <h1 className="c53xx-Heading-style">
              <span className="c53xx-span-style">5.3.1.1: </span>
              Number of awards/medals for outstanding performance in
              sports/cultural activities at inter-university / state / national
              / international level (award for a team event should be counted as
              one) year wise during last five years
            </h1>
            <table className="c53x-Qt-table-style">
              <tr>
                <th className="c53x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue5311t1(e.target.value)}
                      id="5311-t1"
                      className="c52x-input-style"
                      type="text"
                      value={value5311t1}
                    />
                    {value5311t1 === '' ? (
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
                      onChange={(e) => setValue5311t2(e.target.value)}
                      id="5311-t2"
                      className="c52x-input-style"
                      type="text"
                      value={value5311t2}
                    />
                    {value5311t2 === '' ? (
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
                      onChange={(e) => setValue5311t3(e.target.value)}
                      id="5311-t3"
                      className="c52x-input-style"
                      type="text"
                      value={value5311t3}
                    />
                    {value5311t3 === '' ? (
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
                      onChange={(e) => setValue5311t4(e.target.value)}
                      id="5311-t4"
                      className="c52x-input-style"
                      type="text"
                      value={value5311t4}
                    />
                    {value5311t4 === '' ? (
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
                      onChange={(e) => setValue5311t5(e.target.value)}
                      id="5311-t5"
                      className="c52x-input-style"
                      type="text"
                      value={value5311t5}
                    />
                    {value5311t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c53x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => { setValue5311t6(e.target.value); onClickingViewResponse531(); }}
                      id="5311-t6"
                      className="c52x-input-style"
                      type="text"
                      value={value5311t6}
                    />
                    {value5311t6 === '' ? (
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
                      onChange={(e) => { setValue5311t7(e.target.value); onClickingViewResponse531(); }}
                      id="5311-t7"
                      className="c52x-input-style"
                      type="text"
                      value={value5311t7}
                    />
                    {value5311t7 === '' ? (
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
                      onChange={(e) => { setValue5311t8(e.target.value); onClickingViewResponse531(); }}
                      id="5311-t8"
                      className="c52x-input-style"
                      type="text"
                      value={value5311t8}
                    />
                    {value5311t8 === '' ? (
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
                      onChange={(e) => { setValue5311t9(e.target.value); onClickingViewResponse531(); }}
                      id="5311-t9"
                      className="c52x-input-style"
                      type="text"
                      value={value5311t9}
                    />
                    {value5311t9 === '' ? (
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
                      onChange={(e) => { setValue5311t10(e.target.value); onClickingViewResponse531(); }}
                      id="5311-t10"
                      className="c52x-input-style"
                      type="text"
                      value={value5311t10}
                    />
                    {value5311t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <table className="c53x-table-style">
              <tr>
                <th className="c53x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c53x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c53x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c53x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>e-copies of award letters and certificates</td>
                <td></td>
                <td>
                <input
                    onChange={(e) => {
                      setValue5311f1(e.target.files[0]);
                      setPathValue5311f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5311-f1"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5311f1 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5311f1("");
                      document.getElementById("5311-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                 
                
                
                
                </td>
                <td className="c53x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                <input
                    onChange={(e) => {
                      setValue5311f2(e.target.files[0]);
                      setPathValue5311f2(e.target.value);
                      showFilePreview(e);

                    }}
                    id="5311-f2"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5311f2 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5311f2("");
                      document.getElementById("5311-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value5311f2)} target="_blank">View File</a>
                 */}
                </td>
                <td className="c53x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Number of awards/medals for outstanding performance in sports/
                  cultural activities at inter-university / state / national /
                  international level during the last five years(Data Template)
                </td>
                <td>
                <a href={downloadFile("af5.3.1.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                <input
                    onChange={(e) => {
                      setValue5311f3(e.target.files[0]);
                      setPathValue5311f3(e.target.value);
                      showFilePreview(e);

                    }}
                    id="5311-f3"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5311f3 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5311f3("");
                      document.getElementById("5311-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value5311f3)} target="_blank">View File</a> */}
                
                </td>
                <td className="c53x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 5.3.2 */}
      <div className="c53x-eachInputField-container">
        <div className="c53x-weightage-container">
          <h1 className="c53x-weightage-heading-style">Weightage: 25</h1>
        </div>
        <form>
          <div className="c53x-container">
            <div className="c53x-heading_Help-container">
              <h1 className="c53x-heading-style">
                <span className="c53x-span-style">5.3.2: </span>
                Average number of sports and cultural programs in which students of the Institution participated during last five years 
                (organised by the institution/other institutions)
              </h1>
              <button
                onClick={handleHelpOpen2}
              className="c53x-helpButton-style"
                >
                Help
              </button>
              <HelpButton
                isOpen={isOpen2}
                handleClose={handleHelpClose2}
                title='average'
                ><h1>(Total number of sports and cultural events/ competitions in which students of the Institution participated during the last five years / Number of years in the assessment period)</h1></HelpButton>
            </div>
            <div className="c53x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus532(!responseButtonStatus532); onClickingViewResponse532();
                }}
                className="c53x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus532 ? (
                <p className="c53x-responseResult-style">{responseValue532}</p>
              ) : null}
            </div>
          </div>
          <div className="c53xx-container">
            <h1 className="c53xx-Heading-style">
              <span className="c53xx-span-style">5.3.2.1: </span>
              Number of sports and cultural events / competitions organised by
              the institution year wise during last five years
            </h1>
            <table className="c53x-Qt-table-style">
              <tr>
                <th className="c53x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue5321t1(e.target.value)}
                      id="5321-t1"
                      className="c52x-input-style"
                      type="text"
                      value={value5321t1}
                    />
                    {value5321t1 === '' ? (
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
                      onChange={(e) => setValue5321t2(e.target.value)}
                      id="5321-t2"
                      className="c52x-input-style"
                      type="text"
                      value={value5321t2}
                    />
                    {value5321t2 === '' ? (
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
                      onChange={(e) => setValue5321t3(e.target.value)}
                      id="5321-t3"
                      className="c52x-input-style"
                      type="text"
                      value={value5321t3}
                    />
                    {value5321t3 === '' ? (
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
                      onChange={(e) => setValue5321t4(e.target.value)}
                      id="5321-t4"
                      className="c52x-input-style"
                      type="text"
                      value={value5321t4}
                    />
                    {value5321t4 === '' ? (
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
                      onChange={(e) => setValue5321t5(e.target.value)}
                      id="5321-t5"
                      className="c52x-input-style"
                      type="text"
                      value={value5321t5}
                    />
                    {value5321t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c53x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => { setValue5321t6(e.target.value); onClickingViewResponse532(); }}
                      id="5321-t6"
                      className="c52x-input-style"
                      type="text"
                      value={value5321t6}
                    />
                    {value5321t6 === '' ? (
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
                      onChange={(e) => { setValue5321t7(e.target.value); onClickingViewResponse532(); }}
                      id="5321-t7"
                      className="c52x-input-style"
                      type="text"
                      value={value5321t7}
                    />
                    {value5321t7 === '' ? (
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
                      onChange={(e) => { setValue5321t8(e.target.value); onClickingViewResponse532(); }}
                      id="5321-t8"
                      className="c52x-input-style"
                      type="text"
                      value={value5321t8}
                    />
                    {value5321t8 === '' ? (
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
                      onChange={(e) => { setValue5321t9(e.target.value); onClickingViewResponse532(); }}
                      id="5321-t9"
                      className="c52x-input-style"
                      type="text"
                      value={value5321t9}
                    />
                    {value5321t9 === '' ? (
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
                      onChange={(e) => { setValue5321t10(e.target.value); onClickingViewResponse532(); }}
                      id="5321-t10"
                      className="c52x-input-style"
                      type="text"
                      value={value5321t10}
                    />
                    {value5321t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <table className="c53x-table-style">
              <tr>
                <th className="c53x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c53x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c53x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c53x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Report of the event</td>
                <td></td>
                <td>
                <input
                    onChange={(e) => {
                      setValue5321f1(e.target.files[0]);
                      setPathValue5321f1(e.target.value);
                      showFilePreview(e);

                    }}
                    id="5321-f1"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5321f1 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5321f1("");
                      document.getElementById("5321-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value5321f1)} target="_blank">View File</a> */}
                
                </td>
                <td className="c53x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                <input
                    onChange={(e) => {
                      setValue5321f2(e.target.files[0]);
                      setPathValue5321f2(e.target.value);
                      showFilePreview(e);

                    }}
                    id="5321-f2"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5321f2 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5321f2("");
                      document.getElementById("5321-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value5321f2)} target="_blank">View File</a> */}
                
                </td>
                <td className="c53x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Number of sports and cultural events / competitions organised
                  per year (Data Template)
                </td>
                <td>
                <a href={downloadFile("af5.3.2.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                <input
                    onChange={(e) => {
                      setValue5321f3(e.target.files[0]);
                      setPathValue5321f3(e.target.value);
                      showFilePreview(e);

                    }}
                    id="5321-f3"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5321f3 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5321f3("");
                      document.getElementById("5321-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value5321f3)} target="_blank">View File</a>
                 */}
                </td>
                <td className="c53x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
      <div className="c53x-button-container">
        <button onClick={onClickingSave} className="c53x-button-style">Modify</button>
      </div>
    </div>
  );
}

export default Criteria53;
