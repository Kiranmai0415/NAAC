import React, { useState } from 'react';
import './c53-style.css';
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
        Describe the Student Council and its activities for institutional
development and student welfare within a maximum of 500 words
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

function Help533(props) {
  return props.isHelp533Clicked ? (
    <div className="c53x-help-mainContainer">
      <div className="c53x-help-subContainer">
        <h1 className="c53x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c53x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>
          Number of sports and cultural events / competitions organised by the
          institution year - wise during the last five years
          <span style={{ fontWeight: 'bold' }}>)/</span>5
        </p>
        <button
          className="c53x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp533Clicked(false);
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

  const [pathValue5321f1, setPathValue5321f1] = useState('');
  const [value5321f1, setValue5321f1] = useState([]);
  const [pathValue5321f2, setPathValue5321f2] = useState('');
  const [value5321f2, setValue5321f2] = useState([]);

  const [value5331t1, setValue5331t1] = useState();
  const [value5331t2, setValue5331t2] = useState();
  const [value5331t3, setValue5331t3] = useState();
  const [value5331t4, setValue5331t4] = useState();
  const [value5331t5, setValue5331t5] = useState();
  const [value5331t6, setValue5331t6] = useState();
  const [value5331t7, setValue5331t7] = useState();
  const [value5331t8, setValue5331t8] = useState();
  const [value5331t9, setValue5331t9] = useState();
  const [value5331t10, setValue5331t10] = useState();

  const [pathValue5331f1, setPathValue5331f1] = useState('');
  const [pathValue5331f2, setPathValue5331f2] = useState('');
  const [pathValue5331f3, setPathValue5331f3] = useState('');
  const [value5331f1, setValue5331f1] = useState([]);
  const [value5331f2, setValue5331f2] = useState([]);
  const [value5331f3, setValue5331f3] = useState([]);

  const [responseButtonStatus531, setResponseButtonStatus531] = useState(false);
  const [responseButtonStatus533, setResponseButtonStatus533] = useState(false);

  const [responseValue531, setResponseValue531] = useState('');
  const [responseValue532, setResponseValue532] = useState('');
  const [responseValue533, setResponseValue533] = useState('');

  const [help531Status, setHelp531Status] = useState(false);
  const [help532Status, setHelp532Status] = useState(false);
  const [help533Status, setHelp533Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');

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

  function onClickingViewResponse533() {
    if (
      value5331t6 === ''
      || value5331t7 === ''
      || value5331t8 === ''
      || value5331t9 === ''
      || value5331t10 === ''
      || value5331t6 === undefined
      || value5331t7 === undefined
      || value5331t8 === undefined
      || value5331t9 === undefined
      || value5331t10 === undefined
    ) {
      setResponseValue533('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value5331t6, 10)) === false
      || Number.isInteger(parseInt(value5331t7, 10)) === false
      || Number.isInteger(parseInt(value5331t8, 10)) === false
      || Number.isInteger(parseInt(value5331t9, 10)) === false
      || Number.isInteger(parseInt(value5331t10, 10)) === false
    ) {
      setResponseValue533('Input should be an Integer');
    } else if (
      value5331t6 !== ''
      && value5331t7 !== ''
      && value5331t8 !== ''
      && value5331t9 !== ''
      && value5331t10 !== ''
    ) {
      setResponseValue533(
        (value5331t6 + value5331t7 + value5331t8 + value5331t9 + value5331t10)
          / 5
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
    criteria53Qn: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
      input532t1: value532t1,
      response531: responseValue531,
      response533: responseValue533,
      response532: responseValue532,
      criteria53status:"save"
    },
  ],
 
      yearTable5311: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201, input5311y: value5311t1, input5311v: value5311t6 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202,input5311y: value5311t2, input5311v: value5311t7 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203,input5311y: value5311t3, input5311v: value5311t8 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204,input5311y: value5311t4, input5311v: value5311t9 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205,input5311y: value5311t5, input5311v: value5311t10 },
      ],

      // yearTable5331: [
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 201, input5331y: value5331t1, input5331v: value5331t6 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 202,input5331y: value5331t2, input5331v: value5331t7 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 203, input5331y: value5331t3, input5331v: value5331t8 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 204, input5331y: value5331t4, input5331v: value5331t9 },
      //   {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      //   uniqueKey1: 205, input5331y: value5331t5, input5331v: value5331t10 },
      // ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form53Data = new FormData();
    console.log(JSON.stringify(inputDataList));

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

    if (pathValue5331f1 !== '') {
      form53Data.append(
        'uploadfile5',
        value5331f1,
        'f5331f1-' + value5331f1.name
      );
    }
    if (pathValue5331f2 !== '') {
      form53Data.append(
        'uploadfile5',
        value5331f2,
        'f5331f2-' + value5331f2.name
      );
    }
    if (pathValue5331f3 !== '') {
      form53Data.append(
        'uploadfile5',
        value5331f3,
        'f5331f3-' + value5331f3.name
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
            Key Indicator Weightage: 30
          </h1>
        </div>
      </div>
      {/* Key Indicator: 5.3.1 */}
      <div className="c53x-eachInputField-container">
        <div className="c53x-weightage-container">
          <h1 className="c53x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c53x-container">
            <div className="c53x-heading_Help-container">
              <h1 className="c53x-heading-style">
                <span className="c53x-span-style">5.3.1: </span>
                Number of awards/medals won by students for outstanding performance 
                in sports/cultural activities at inter-university/state/national/international 
              events (award for a team event should be counted as one) during the last 
               five years             
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
              Number of awards/medals won by students for outstanding 
             performance in sports/cultural activities at inter-university/state/ 
             national/international level (award for a team event should be counted as 
             one) year-wise during the last five years
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
                      type="number"
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
                      type="number"
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
                      type="number"
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
                      type="number"
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
                      type="number"
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
                      type="number"
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
                      type="number"
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
                      type="number"
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
                      type="number"
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
                      type="number"
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
                    className="c53-fileButton-style"
                  />
                  {pathValue5311f1 === '' ? null : (
                    <div className="c53-fileButtons-container">
                      <button className="c53-viewFileButton-style">
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
                    className="c53-fileButton-style"
                  />
                  {pathValue5311f2 === '' ? null : (
                    <div className="c53-fileButtons-container">
                      <button className="c53-viewFileButton-style">
                               <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5311f2("");
                      document.getElementById("5311-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
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
                <a href={downloadFile("un5.3.1.xlsx")} target="_blank">View Template</a>
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
                    className="c53-fileButton-style"
                  />
                  {pathValue5311f3 === '' ? null : (
                    <div className="c53-fileButtons-container">
                      <button className="c53-viewFileButton-style">
                               <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5311f3("");
                      document.getElementById("5311-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
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
          <h1 className="c53x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c53x-container">
            <div className="c53x-heading_Help-container">
              <h1 className="c53x-heading-style">
                <span className="c53x-span-style">5.3.2: </span>
                Presence of Student Council and its activities for institutional 
                    development and student welfare.              </h1>
                    <button
                onClick={handleHelpOpen2}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen2}
                handleClose={handleHelpClose2}
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <label htmlFor="532-t1" className="c26x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue532t1(e.target.value);
                setResponseValue532(e.target.value);
              }}
              value={value532t1}
              rows={10}
              className="c53x-textarea-style"
              id="532-t1"
            ></textarea>
            {value532t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>
          <div className="c53xx-container">
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
                <td>Paste link for Additional Information</td>
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
                    className="c53-fileButton-style"
                  />
                  {pathValue5321f1 === '' ? null : (
                    <div className="c53-fileButtons-container">
                      <button className="c53-viewFileButton-style">
                               <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5321f1("");
                      document.getElementById("5321-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c53x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any Additional Information</td>
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
                    className="c53-fileButton-style"
                  />
                  {pathValue5321f2 === '' ? null : (
                    <div className="c53-fileButtons-container">
                      <button className="c53-viewFileButton-style">
                               <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5321f2("");
                      document.getElementById("5321-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c53x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 5.3.3 */}
      <div className="c53x-eachInputField-container">
        <div className="c53x-weightage-container">
          <h1 className="c53x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c53x-container">
            <div className="c53x-heading_Help-container">
              <h1 className="c53x-heading-style">
                <span className="c53x-span-style">5.3.3: </span>
                The institution conducts /organizes following activities
                <p className="c51x-para-style">
                1. Sports competitions/events
                  <br />
                  2.Cultural competitions/events
                  <br />
                  3. Technical fest/academic fests
                  <br />
                  4. Any other events through active clubs and forums
                </p>


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
            <div className="c53x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus533(!responseButtonStatus533); onClickingViewResponse533();
                }}
                className="c53x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus533 ? (
                <p className="c53x-responseResult-style">{responseValue533}</p>
              ) : null}
            </div>
          </div>
          <div className="c53xx-container">
            {/* <h1 className="c53xx-Heading-style">
              <span className="c53xx-span-style">5.3.3.1: </span>
              Number of sports and cultural events / competitions organised by
              the institution year wise during last five years
            </h1> */}
            {/* <table className="c53x-Qt-table-style">
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
                      onChange={(e) => setValue5331t1(e.target.value)}
                      id="5331-t1"
                      className="c52x-input-style"
                      type="number"
                      value={value5331t1}
                    />
                    {value5331t1 === '' ? (
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
                      onChange={(e) => setValue5331t2(e.target.value)}
                      id="5331-t2"
                      className="c52x-input-style"
                      type="number"
                      value={value5331t2}
                    />
                    {value5331t2 === '' ? (
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
                      onChange={(e) => setValue5331t3(e.target.value)}
                      id="5331-t3"
                      className="c52x-input-style"
                      type="number"
                      value={value5331t3}
                    />
                    {value5331t3 === '' ? (
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
                      onChange={(e) => setValue5331t4(e.target.value)}
                      id="5331-t4"
                      className="c52x-input-style"
                      type="number"
                      value={value5331t4}
                    />
                    {value5331t4 === '' ? (
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
                      onChange={(e) => setValue5331t5(e.target.value)}
                      id="5331-t5"
                      className="c52x-input-style"
                      type="number"
                      value={value5331t5}
                    />
                    {value5331t5 === '' ? (
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
                      onChange={(e) => { setValue5331t6(e.target.value); onClickingViewResponse533(); }}
                      id="5331-t6"
                      className="c52x-input-style"
                      type="number"
                      value={value5331t6}
                    />
                    {value5331t6 === '' ? (
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
                      onChange={(e) => { setValue5331t7(e.target.value); onClickingViewResponse533(); }}
                      id="5331-t7"
                      className="c52x-input-style"
                      type="number"
                      value={value5331t7}
                    />
                    {value5331t7 === '' ? (
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
                      onChange={(e) => { setValue5331t8(e.target.value); onClickingViewResponse533(); }}
                      id="5331-t8"
                      className="c52x-input-style"
                      type="number"
                      value={value5331t8}
                    />
                    {value5331t8 === '' ? (
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
                      onChange={(e) => { setValue5331t9(e.target.value); onClickingViewResponse533(); }}
                      id="5331-t9"
                      className="c52x-input-style"
                      type="number"
                      value={value5331t9}
                    />
                    {value5331t9 === '' ? (
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
                      onChange={(e) => { setValue5331t10(e.target.value); onClickingViewResponse533(); }}
                      id="5331-t10"
                      className="c52x-input-style"
                      type="number"
                      value={value5331t10}
                    />
                    {value5331t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> */}
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
                      setValue5331f1(e.target.files[0]);
                      setPathValue5331f1(e.target.value);
                      showFilePreview(e);

                    }}
                    id="5331-f1"
                    type="file"
                    className="c53-fileButton-style"
                  />
                  {pathValue5331f1 === '' ? null : (
                    <div className="c53-fileButtons-container">
                      <button className="c53-viewFileButton-style">
                           <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5331f1("");
                      document.getElementById("5331-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c53x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5331f2(e.target.files[0]);
                      setPathValue5331f2(e.target.value);
                      showFilePreview(e);

                    }}
                    id="5331-f2"
                    type="file"
                    className="c53-fileButton-style"
                  />
                  {pathValue5331f2 === '' ? null : (
                    <div className="c53-fileButtons-container">
                      <button className="c53-viewFileButton-style">
                           <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5331f2("");
                      document.getElementById("5331-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c53x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Number of sports and cultural events / competitions organised
                  per year (Data Template)
                </td>
                <td>
                <a href={downloadFile("un5.3.3.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5331f3(e.target.files[0]);
                      setPathValue5331f3(e.target.value);
                      showFilePreview(e);

                    }}
                    id="5331-f3"
                    type="file"
                    className="c53-fileButton-style"
                  />
                  {pathValue5331f3 === '' ? null : (
                    <div className="c53-fileButtons-container">
                      <button className="c53-viewFileButton-style">
                           <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5331f3("");
                      document.getElementById("5331-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c53x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
      <div className="c53x-button-container">
        <button onClick={onClickingSave} className="c53x-button-style">Save</button>
      </div>
    </div>
  );
}

export default Criteria53;
