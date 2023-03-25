import React, { useState } from 'react';
import './c42-style.css';
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

function Help421(props) {
  return props.isHelp421Clicked ? (
    <div className="c42x-help-mainContainer">
      <div className="c42x-help-subContainer">
        <h1 className="c42x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c42x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c42x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp421Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help422(props) {
  return props.isHelp422Clicked ? (
    <div className="c42x-help-mainContainer">
      <div className="c42x-help-subContainer">
        <h1 className="c42x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c42x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c42x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp422Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help423(props) {
  return props.isHelp423Clicked ? (
    <div className="c42x-help-mainContainer">
      <div className="c42x-help-subContainer">
        <h1 className="c42x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c42x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c42x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp423Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help424(props) {
  return props.isHelp424Clicked ? (
    <div className="c42x-help-mainContainer">
      <div className="c42x-help-subContainer">
        <h1 className="c42x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c42x-help-para-style"><span style={{ fontWeight: 'bold' }}>(</span>
        Number of teachers and students using library per day <span style={{ fontWeight: 'bold' }}> / </span>
        Total number of teachers and students<span style={{ fontWeight: 'bold' }}>) * </span>100
        </p>
        <button
          className="c42x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp424Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Criteria42() {


  
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


  const [value421t1, setValue421t1] = useState();
  const [value421f1, setValue421f1] = useState('');
  const [pathValue421f1, setPathValue421f1] = useState('');
  const [value421f2, setValue421f2] = useState('');
  const [pathValue421f2, setPathValue421f2] = useState('');

  const [responseValue421, setResponseValue421] = useState('');
  const [help421Status, setHelp421Status] = useState(false);

  const [value422t1, setValue422t1] = useState();
  const [value422f1, setValue422f1] = useState('');
  const [pathValue422f1, setPathValue422f1] = useState('');
  const [value422f2, setValue422f2] = useState('');
  const [pathValue422f2, setPathValue422f2] = useState('');
  const [responseButtonStatus422, setResponseButtonStatus422] = useState(false);
  const [responseValue422, setResponseValue422] = useState('');
  const [help422Status, setHelp422Status] = useState(false);

  const [value4221t6, setValue4221t6] = useState();
  const [value4221t7, setValue4221t7] = useState();
  const [value4221t8, setValue4221t8] = useState();
  const [value4221t9, setValue4221t9] = useState();
  const [value4221t10, setValue4221t10] = useState();
  const [value4231t6, setValue4231t6] = useState();
  const [value4231t7, setValue4231t7] = useState();
  const [value4231t8, setValue4231t8] = useState();
  const [value4231t9, setValue4231t9] = useState();
  const [value4231t10, setValue4231t10] = useState();
  const [value4231f1, setValue4231f1] = useState('');
  const [pathValue4231f1, setPathValue4231f1] = useState('');
  const [value4231f2, setValue4231f2] = useState('');
  const [pathValue4231f2, setPathValue4231f2] = useState('');
  const [value4231f3, setValue4231f3] = useState('');
  const [pathValue4231f3, setPathValue4231f3] = useState('');
  const [responseButtonStatus423, setResponseButtonStatus423] = useState(false);
  const [responseValue423, setResponseValue423] = useState('');
  const [help423Status, setHelp423Status] = useState(false);

  const [value4241t1, setValue4241t1] = useState();
  const [value4241t2, setValue4241t2] = useState();
  const [value4241f1, setValue4241f1] = useState('');
  const [pathValue4241f1, setPathValue4241f1] = useState('');
  const [value4241f2, setValue4241f2] = useState('');
  const [pathValue4241f2, setPathValue4241f2] = useState('');
  const [responseButtonStatus424, setResponseButtonStatus424] = useState(false);
  const [responseValue424, setResponseValue424] = useState('');
  const [help424Status, setHelp424Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');

  const [value4231t1, setValue4231t1] = useState();
  const [value4231t2, setValue4231t2] = useState();
  const [value4231t3, setValue4231t3] = useState();
  const [value4231t4, setValue4231t4] = useState();
  const [value4231t5, setValue4231t5] = useState();

  const [value42211t1, setValue42211t1] = useState();
  const [value42211t2, setValue42211t2] = useState();
  const [value42211t3, setValue42211t3] = useState();
  const [value42211t4, setValue42211t4] = useState();
  const [value42211t5, setValue42211t5] = useState();

  const [value4141t1, setValue4141t1] = useState();
  const [value4141t2, setValue4141t2] = useState();
  const [value4141t3, setValue4141t3] = useState();
  const [value4141t4, setValue4141t4] = useState();
  const [value4141t5, setValue4141t5] = useState();

  const [value4221t1, setValue4221t1] = useState();
  const [value4221t2, setValue4221t2] = useState();
  const [value4221t3, setValue4221t3] = useState();
  const [value4221t4, setValue4221t4] = useState();
  const [value4221t5, setValue4221t5] = useState();
  // function onClickingViewResponse422(e) {
  //   if (value422t1 === '') {
  //     setResponseValue422('Please select any option');
  //   } else {
  //     setResponseValue422(e.target.value);
  //   }
  // }
  function onClickingViewResponse422() {
    if (
      value4221t6 === ''
      || value4221t7 === ''
      || value4221t8 === ''
      || value4221t9 === ''
      || value4221t10 === ''
      || value4221t6 === undefined
      || value4221t7 === undefined
      || value4221t8 === undefined
      || value4221t9 === undefined
      || value4221t10 === undefined
    ) {
      setResponseValue251('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value4221t6, 10)) === false
      || Number.isInteger(parseInt(value4221t7, 10)) === false
      || Number.isInteger(parseInt(value4221t8, 10)) === false
      || Number.isInteger(parseInt(value4221t9, 10)) === false
      || Number.isInteger(parseInt(value4221t10, 10)) === false
    ) {
      setResponseValue251('Input should be an Integer');
    } else if (
      value4221t6 !== ''
      && value4221t7 !== ''
      && value4221t8 !== ''
      && value4221t9 !== ''
      && value4221t10 !== ''
    ) {
      setResponseValue251(
       ( parseInt(value4221t6, 10)
          + parseInt(value4221t7, 10)
          + parseInt(value4221t8, 10)
          + parseInt(value4221t9, 10)
          + parseInt(value4221t10, 10))*100
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
    criteria42Ql: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
        input421t1: value421t1,
        response421: responseValue421
       },
      ],
      criteria42Qn: [
        { 
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
          uniqueKey1: 201,
      input422t1: value422t1,
      response422: responseValue422,
      input4241t1: value4241t1,
      input4241t2: value4241t2,
      response424: responseValue424,
      criteria42status:"save"
        },
      ],
      yearTable4231: [
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 201, input4231y: value4231t1, input4231v: value4231t6 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 202, input4231y: value4231t2, input4231v: value4231t7 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 203, input4231y: value4231t3, input4231v: value4231t8 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 204,  input4231y: value4231t4, input4231v: value4231t9 },
         {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 205, input4231y: value4231t5, input4231v: value4231t10 },
      ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form42Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form42Data.append('criteria4Fieldinfo', jsonBlob(inputDataList));
    if (pathValue421f1 !== '') {
      form42Data.append('uploadfile4', value421f1, 'f421f1-' + value421f1.name);
    }
    if (pathValue421f2 !== '') {
      form42Data.append('uploadfile4', value421f2, 'f421f2-' + value421f2.name);
    }
    if (pathValue422f1 !== '') {
      form42Data.append('uploadfile4', value422f1, 'f422f1-' + value422f1.name);
    }
    if (pathValue422f2 !== '') {
      form42Data.append('uploadfile4', value422f2, 'f422f2-' + value422f2.name);
    }
    if (pathValue4231f1 !== '') {
      form42Data.append(
        'uploadfile4',
        value4231f1,
        'f4231f1-' + value4231f1.name
      );
    }
    if (pathValue4231f2 !== '') {
      form42Data.append(
        'uploadfile4',
        value4231f2,
        'f4231f2-' + value4231f2.name
      );
    }
    if (pathValue4231f3 !== '') {
      form42Data.append(
        'uploadfile4',
        value4231f3,
        'f4231f3-' + value4231f3.name
      );
    }
    if (pathValue4241f1 !== '') {
      form42Data.append(
        'uploadfile4',
        value4241f1,
        'f4241f1-' + value4241f1.name
      );
    }
    if (pathValue4241f2 !== '') {
      form42Data.append(
        'uploadfile4',
        value4241f2,
        'f4241f2-' + value4241f2.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form42Data,
    };
    fetch(
      resources.APPLICATION_URL+'criteria4upload',
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
    <div className="c42-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c42x-colorIndicator-container">
        <p className="c42x-QlcolorIndicator-circle-style"></p>
        <span className="c42x-colorIndicator-span-style">Qualitative</span>
        <p className="c42x-QtcolorIndicator-circle-style"></p>
        <span className="c42x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c42x-weightage-heading-style">
            Key Indicator Weightage: 20
          </h1>
        </div>
      </div>

      {/* Key Indicator: 4.2.1 */}
      <div className="c42x-eachInputField-container">
        <div className="c42x-weightage-container">
          <h1 className="c42x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c42x-Ql-label-textarea-container">
            <div className="c42x-heading_Help-container">
              <h1 className="c42x-heading-style">
                <span className="c42x-span-style">4.2.1: </span>
                Library is automated with digital facilities using Integrated Library Management System (ILMS), adequate subscription to e-resources and journals are made. The library is optimally used by the faculty and students
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp421Status(true);
                }}
                className="c42x-helpButton-style"
              >
                Help
              </button>
              <Help421
                isHelp421Clicked={help421Status}
                setIsHelp421Clicked={setHelp421Status}
              />
            </div>
            <label htmlFor="421-t1" className="c42x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue421t1(e.target.value);
                setResponseValue421(e.target.value);
              }}
              value={value421t1}
              rows={10}
              className="c42x-textarea-style"
              id="421-t1"
            ></textarea>
            {value421t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c42x-Ql-table-style">
            <tr>
              <th className="c42x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c42x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c42x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c42x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c42x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c42x-Ql-tableBorders-style"></td>
              <td className="c42x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue421f1(e.target.files[0]);
                    setPathValue421f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="421-f1"
                  type="file"
                  className="c42-fileButton-style"
                />
                {pathValue421f1 === '' ? null : (
                  <div className="c42-fileButtons-container">
                    <button className="c42-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue421f1("");
                      document.getElementById("421-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c42x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue421f2(e.target.files[0]);
                    setPathValue421f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="421-f2"
                  type="file"
                  className="c42-fileButton-style"
                />
                {pathValue421f2 === '' ? null : (
                  <div className="c42-fileButtons-container">
                    <button className="c42-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue421f2("");
                      document.getElementById("421-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c42x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 4.2.2 */}
       <div className="c42x-eachInputField-container">
        <div className="c42x-weightage-container">
          <h1 className="c42x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c42x-container">
            <div className="c42x-heading_Help-container">
              <div>
                <h1 className="c42x-heading-style">
                  <span className="c42x-span-style">4.2.2: </span>
                  Percentage expenditure for purchase of books/ e-books and
                  subscription to journals/e-journals during the last five years (INR in
                  Lakhs)

                </h1>
                <h1 className="c42x-heading-style">
                  <span className="c42x-span-style">4.2.2.1: </span>
                  Annual expenditure for purchase of books and journals yearwise during the last five years (INR in lakhs)
                </h1>
             
              </div>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp422Status(true);
                }}
                className="c42x-helpButton-style"
              >
                Help
              </button>
              <Help422
                isHelp422Clicked={help422Status}
                setIsHelp422Clicked={setHelp422Status}
              />
            </div>
            <div className="c42x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus422(!responseButtonStatus422);
                  onClickingViewResponse422();
                }}
                className="c42x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus422 ? (
                <p className="c42x-responseResult-style">{responseValue422}</p>
              ) : null}
            </div>
          </div>
          <table className="c41x-Qt-table-style">
              <tr>
                <th className="c41x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue4221t1(e.target.value)}
                      id="4221-t1"
                      className="c41x-input-style"
                      type="text"
                      value={value42211t1}
                    />
                    {value4141t1 === '' ? (
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
                      onChange={(e) => setValue4221t2(e.target.value)}
                      id="4221-t2"
                      className="c41x-input-style"
                      type="text"
                      value={value4221t2}
                    />
                    {value4221t2 === '' ? (
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
                      onChange={(e) => setValue4221t3(e.target.value)}
                      id="4221-t3"
                      className="c41x-input-style"
                      type="text"
                      value={value4221t3}
                    />
                    {value4221t3 === '' ? (
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
                      onChange={(e) => setValue4221t4(e.target.value)}
                      id="4221-t4"
                      className="c41x-input-style"
                      type="text"
                      value={value4221t4}
                    />
                    {value4221t4 === '' ? (
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
                      onChange={(e) => setValue4221t5(e.target.value)}
                      id="4221-t5"
                      className="c41x-input-style"
                      type="text"
                      value={value4221t5}
                    />
                    {value4221t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c41x-horizontalTable-heading-style">
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
                        setValue4221t6(e.target.value);
                        onClickingViewResponse414();
                      }}
                      id="4221-t6"
                      className="c41x-input-style"
                      type="text"
                      value={value4221t6}
                    />
                    {value4221t6 === '' ? (
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
                        setValue4221t7(e.target.value);
                        onClickingViewResponse422();
                      }}
                      id="4221-t7"
                      className="c41x-input-style"
                      type="text"
                      value={value4221t7}
                    />
                    {value4221t7 === '' ? (
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
                        setValue4221t8(e.target.value);
                        onClickingViewResponse422();
                      }}
                      id="4221-t8"
                      className="c41x-input-style"
                      type="text"
                      value={value4221t8}
                    />
                    {value4221t8 === '' ? (
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
                        setValue4221t9(e.target.value);
                        onClickingViewResponse422();
                      }}
                      id="4141-t9"
                      className="c41x-input-style"
                      type="text"
                      value={value4221t9}
                    />
                    {value4221t9 === '' ? (
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
                        setValue4221t10(e.target.value);
                        onClickingViewResponse422();
                      }}
                      id="4221-t10"
                      className="c41x-input-style"
                      type="text"
                      value={value4221t10}
                    />
                    {value4221t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> 
          <table className="c42x-table-style">
            <tr>
              <th className="c42x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c42x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c42x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c42x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Upload any additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue422f1(e.target.files[0]);
                    setPathValue422f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="422-f1"
                  type="file"
                  className="c42-fileButton-style"
                />
                {pathValue422f1 === '' ? null : (
                  <div className="c42-fileButtons-container">
                    <button className="c42-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue422f1("");
                      document.getElementById("422-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c42x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Details of subscriptions like e-journals, e-books ,
                e-ShodhSindhu, Shodhganga Membership etc
              </td>
              <td>
                <a href={downloadFile("un4.2.2.xlsx")} target="_blank">
                    View Template</a>
                </td>
                <td>
                <input
                  onChange={(e) => {
                    setValue422f2(e.target.files[0]);
                    setPathValue422f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="422-f2"
                  type="file"
                  className="c42-fileButton-style"
                />
                {pathValue422f2 === '' ? null : (
                  <div className="c42-fileButtons-container">
                    <button className="c42-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue422f2("");
                      document.getElementById("422-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c42x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div> 

     

      <div className="c42x-button-container">
        <button className="c42x-button-style" onClick={onClickingSave}>
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria42;
