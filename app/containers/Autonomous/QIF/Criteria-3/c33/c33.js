import React, { useState } from 'react';
import './c33-style.css';
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
function Help331(props) {
  return props.isHelp331Clicked ? (
    <div className="c33x-help-mainContainer">
      <div className="c33x-help-subContainer">
        <h1 className="c33x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c33x-help-para-style">
          Write description in maximum of 500 words
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
          How is Response calculated ?
        </h1>
        <p className="c33x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>
          Total number of workshops/seminars conducted on Research Methodology,
          Intellectual Property Rights (IPR) and entrepreneurship and skills
          development year wise during last five years
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
  const [value331t1, setValue331t1] = useState();
  const [value331f1, setValue331f1] = useState('');
  const [pathValue331f1, setPathValue331f1] = useState('');
  const [value331f2, setValue331f2] = useState();
  const [pathValue331f2, setPathValue331f2] = useState('');
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
  const [value3321f1, setValue3321f1] = useState('');
  const [pathValue3321f1, setPathValue3321f1] = useState('');
  const [value3321f2, setValue3321f2] = useState('');
  const [pathValue3321f2, setPathValue3321f2] = useState('');
  const [value3321f3, setValue3321f3] = useState('');
  const [pathValue3321f3, setPathValue3321f3] = useState('');
  const [responseButtonStatus332, setResponseButtonStatus332] = useState(false);
  const [responseValue331, setResponseValue331] = useState('');
  const [responseValue332, setResponseValue332] = useState('');
  const [help332Status, setHelp332Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');

  // response button functionality
  function onClickingViewResponse332() {
    if (
      value3321t6 === ''
      || value3321t7 === ''
      || value3321t8 === ''
      || value3321t9 === ''
      || value3321t10 === ''
      || value3321t6 === undefined
      || value3321t7 === undefined
      || value3321t8 === undefined
      || value3321t9 === undefined
      || value3321t10 === undefined
    ) {
      setResponseValue332('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3321t6, 10)) === false
      || Number.isInteger(parseInt(value3321t7, 10)) === false
      || Number.isInteger(parseInt(value3321t8, 10)) === false
      || Number.isInteger(parseInt(value3321t9, 10)) === false
      || Number.isInteger(parseInt(value3321t10, 10)) === false
    ) {
      setResponseValue332('Input should be an Integer');
    } else if (
      value3321t6 !== ''
      && value3321t7 !== ''
      && value3321t8 !== ''
      && value3321t9 !== ''
      && value3321t10 !== ''
    ) {
      setResponseValue332(
        parseInt(value3321t6, 10)
          + parseInt(value3321t7, 10)
          + parseInt(value3321t8, 10)
          + parseInt(value3321t9, 10)
          + parseInt(value3321t10, 10)
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
    criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
    criteria33Ql: [
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType},
        uniqueKey1: 1,
        input331t1: value331t1,
        response331: responseValue331,
      },
    ],
    criteria33Qn: [
      {
        criteriaId: {collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType},
        uniqueKey1: 1,
        response332: responseValue332,
        criteria33status:"save"
      },
    ],
    yearTable3321: [
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType},
         uniqueKey1: 1, input3321y: value3321t1, input3321v: value3321t6
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 2, input3321y: value3321t2, input3321v: value3321t7
      },
      {
        criteriaId: {collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType},
         uniqueKey1: 3, input3321y: value3321t3, input3321v: value3321t8
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType},
         uniqueKey1: 4, input3321y: value3321t4, input3321v: value3321t9
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 5, input3321y: value3321t5, input3321v: value3321t10
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
    console.log(JSON.stringify(inputDataList));

    form33Data.append('criteria3Fieldinfo', jsonBlob(inputDataList));
    if (pathValue331f1 !== '') {
      form33Data.append('uploadfile3', value331f1, 'f331f1-' + value331f1.name);
    }
    if (pathValue331f2 !== '') {
      form33Data.append('uploadfile3', value331f2, 'f331f2-' + value331f2.name);
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
    if (pathValue3321f3 !== '') {
      form33Data.append(
        'uploadfile3',
        value3321f3,
        'f3321f3-' + value3321f3.name
      );
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
            Key Indicator Weightage: 10
          </h1>
        </div>
      </div>

      {/* Key Indicator: 3.3.1 */}
      <div className="c33x-eachInputField-container">
        <div className="c33x-weightage-container">
          <h1 className="c33x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c33x-Ql-label-textarea-container">
            <div className="c33x-heading_Help-container">
              <h1 className="c33x-heading-style">
                <span className="c33x-span-style">3.3.1: </span>
                Institution has created an ecosystem for innovations, Indian Knowledge System (IKS),including awareness about IPR, establishment of IPR cell, Incubation centre and other initiatives for the creation and transfer of knowledge/technology and the outcome of the same are evident
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
            <label htmlFor="331-t1" className="c33x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue331t1(e.target.value);
                setResponseValue331(e.target.value);
              }}
              value={value331t1}
              rows={10}
              className="c33x-textarea-style"
              id="331-t1"
            ></textarea>
            {value331t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c33x-Ql-table-style">
            <tr>
              <th className="c33x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c33x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c33x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c33x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c33x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c33x-Ql-tableBorders-style"></td>
              <td className="c33x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue331f1(e.target.files[0]);
                    setPathValue331f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="331-f1"
                  type="file"
                  className="c33-fileButton-style"
                  accept='.pdf'
                />
                {pathValue331f1 === '' ? null : (
                  <div className="c33-fileButtons-container">
                    <button className="c33-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>

                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue331f1("");
                      document.getElementById("331-f1").value="" }} >
                      Reset
                    </button>

                  </div>
                )}
              </td>
              <td className="c33x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue331f2(e.target.files[0]);
                    setPathValue331f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="331-f2"
                  type="file"
                  className="c33-fileButton-style"
                  accept='.pdf'
                />
                {pathValue331f2 === '' ? null : (
                  <div className="c33-fileButtons-container">
                    <button className="c33-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>

                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue331f2("");
                      document.getElementById("3231-f2").value="" }} >
                      Reset
                    </button>

                  </div>
                )}
              </td>
              <td className="c32x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 3.3.2 */}
      {/* <div className="c33x-eachInputField-container">
        <div className="c33x-weightage-container">
          <h1 className="c33x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c33x-container">
            <div className="c33x-heading_Help-container">
              <h1 className="c33x-heading-style">
                <span className="c33x-span-style">3.3.2: </span>
                Number of workshops/seminars conducted on Research methodology,
                Intellectual Property Rights (IPR),entrepreneurship, skill
                development during the last five years
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp332Status(true);
                }}
                className="c33x-helpButton-style"
              >
                Help
              </button>
              <Help332
                isHelp332Clicked={help332Status}
                setIsHelp332Clicked={setHelp332Status}
              />
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
              Total number of workshops/seminars conducted on Research
              methodology, Intellectual Property Rights (IPR),entrepreneurship,
              skill development year-wise during the last five years
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
                      type="number"
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
                      type="number"
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
                      type="number"
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
                      type="number"
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
                      type="number"
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
                      onChange={(e) => {
                        setValue3321t6(e.target.value);
                        onClickingViewResponse332();
                      }}
                      id="3321-t6"
                      className="c33x-input-style"
                      type="number"
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
                      onChange={(e) => {
                        setValue3321t7(e.target.value);
                        onClickingViewResponse332();
                      }}
                      id="3321-t7"
                      className="c33x-input-style"
                      type="number"
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
                      onChange={(e) => {
                        setValue3321t8(e.target.value);
                        onClickingViewResponse332();
                      }}
                      id="3321-t8"
                      className="c33x-input-style"
                      type="number"
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
                      onChange={(e) => {
                        setValue3321t9(e.target.value);
                        onClickingViewResponse332();
                      }}
                      id="3321-t9"
                      className="c33x-input-style"
                      type="number"
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
                      onChange={(e) => {
                        setValue3321t10(e.target.value);
                        onClickingViewResponse332();
                      }}
                      id="3321-t10"
                      className="c33x-input-style"
                      type="number"
                      value={value3321t10}
                    />
                    {value3321t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

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
                <td>Report of the event</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3321f1(e.target.files[0]);
                      setPathValue3321f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3321-f1"
                    type="file"
                    className="c33-fileButton-style"
                    accept='.pdf'
                  />
                  {pathValue3321f1 === '' ? null : (
                    <div className="c33-fileButtons-container">
                      <button className="c33-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3321f1("");
                      document.getElementById("3321-f1").value="" }} >
                      Reset
                    </button>

                    </div>
                  )}
                </td>
                <td className="c33x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3321f2(e.target.files[0]);
                      setPathValue3321f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3321-f2"
                    type="file"
                    className="c33-fileButton-style"
                    accept='.pdf'
                  />
                  {pathValue3321f2 === '' ? null : (
                    <div className="c33-fileButtons-container">
                      <button className="c33-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3321f2("");
                      document.getElementById("3321-f2").value="" }} >
                      Reset
                    </button>

                    </div>
                  )}
                </td>
                <td className="c33x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>List of workshops/seminars during last 5 years</td>
                <td>
                  <a href="http://localhost:8080/api/v1/download/criteria3.3.2.xlsx">View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3321f3(e.target.files[0]);
                      setPathValue3321f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3321-f3"
                    type="file"
                    className="c33-fileButton-style"
                    accept='.pdf'
                  />
                  {pathValue3321f3 === '' ? null : (
                    <div className="c33-fileButtons-container">
                      <button className="c33-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3321f3("");
                      document.getElementById("3321-f3").value="" }} >
                      Reset
                    </button>

                    </div>
                  )}
                </td>
                <td className="c33x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div> */}

      <div className="c33x-button-container">
        <button onClick={onClickingSave} className="c33x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria33;
