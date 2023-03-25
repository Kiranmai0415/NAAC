import React, { useState ,useEffect} from 'react';
import './c32-style.css';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import { HelpButton } from '../../../../../reusableComponents/model/Help';
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
function Help321(props) {
  return props.isHelp321Clicked ? (
    <div className="c32x-help-mainContainer">
      <div className="c32x-help-subContainer">
        <h1 className="c32x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c32x-help-para-style">
          Write description in maximum of 500 words
        </p>
        <button
          className="c32x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp321Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help322(props) {
  return props.isHelp322Clicked ? (
    <div className="c32x-help-mainContainer">
      <div className="c32x-help-subContainer">
        <h1 className="c32x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c32x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>
          Total number of workshops/seminars conducted on Research Methodology,
          Intellectual Property Rights (IPR) and entrepreneurship and skills
          development year wise during last five years
        </p>
        <button
          className="c32x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp322Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Criteria32() {
      // /this is Help button 
      const [isOpen, setIsopen] = useState(false)
      const handleHelpOpen = (e) => {
        e.preventDefault(),
        setIsopen(true)
      }
      const handleHelpClose = () => {
        setIsopen(false)
      }
       // getfile data with API
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
  const [isOpen2,setIsopen2] = useState(false)
  const handleHelpOpen2 =(e)=>{
    e.preventDefault();
    setIsopen2(true)
  } 
  const handleHelpClose2 = (e)=>{
    setIsopen2(false)
  }

  // state variables
  const [value321t1, setValue321t1] = useState();
  const [value321f1, setValue321f1] = useState('');
  const [pathValue321f1, setPathValue321f1] = useState('');
  const [value321f2, setValue321f2] = useState();
  const [pathValue321f2, setPathValue321f2] = useState('');
  const [help321Status, setHelp321Status] = useState(false);

  const [value3221t1, setValue3221t1] = useState();
  const [value3221t2, setValue3221t2] = useState();
  const [value3221t3, setValue3221t3] = useState();
  const [value3221t4, setValue3221t4] = useState();
  const [value3221t5, setValue3221t5] = useState();
  const [value3221t6, setValue3221t6] = useState();
  const [value3221t7, setValue3221t7] = useState();
  const [value3221t8, setValue3221t8] = useState();
  const [value3221t9, setValue3221t9] = useState();
  const [value3221t10, setValue3221t10] = useState();
  const [value3221f1, setValue3221f1] = useState('');
  const [pathValue3221f1, setPathValue3221f1] = useState('');
  const [value3221f2, setValue3221f2] = useState('');
  const [pathValue3221f2, setPathValue3221f2] = useState('');
  const [value3221f3, setValue3221f3] = useState('');
  const [pathValue3221f3, setPathValue3221f3] = useState('');
  const [responseButtonStatus322, setResponseButtonStatus322] = useState(false);
  const [responseValue321, setResponseValue321] = useState('');
  const [responseValue322, setResponseValue322] = useState('');
  const [help322Status, setHelp322Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');
  const [viewResponseValue, setViewResponseValue] = useState(0);

  // response button functionality
  function onClickingViewResponse322() {
    if (
      value3221t6 === ''
      || value3221t7 === ''
      || value3221t8 === ''
      || value3221t9 === ''
      || value3221t10 === ''
      || value3221t6 === undefined
      || value3221t7 === undefined
      || value3221t8 === undefined
      || value3221t9 === undefined
      || value3221t10 === undefined
    ) {
      setResponseValue322('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3221t6, 10)) === false
      || Number.isInteger(parseInt(value3221t7, 10)) === false
      || Number.isInteger(parseInt(value3221t8, 10)) === false
      || Number.isInteger(parseInt(value3221t9, 10)) === false
      || Number.isInteger(parseInt(value3221t10, 10)) === false
    ) {
      setResponseValue322('Input should be an Integer');
    } else if (
      value3221t6 !== ''
      && value3221t7 !== ''
      && value3221t8 !== ''
      && value3221t9 !== ''
      && value3221t10 !== ''
    ) {
      setResponseValue322(
       (parseInt((value3221t6, 10)+
       parseInt(value3221t7, 10)+
       parseInt (value3221t8, 10)+
       parseInt (value3221t9, 10)+
       parseInt(value3221t10, 10))/ viewResponseValue)*100
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
 const financialYear="2021-2022";
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},     criteria32Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 101,
        input321t1: value321t1,
        response321: responseValue321,
      },
    ],
    criteria32Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 101,
        response322: responseValue322,
        criteria32status:"save"
      },
    ],
    yearTable3221: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 101, input3221y: value3221t1, input3221v: value3221t6
      },
      {

        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},       
          uniqueKey1: 102, input3221y: value3221t2, input3221v: value3221t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},       
           uniqueKey1: 103, input3221y: value3221t3, input3221v: value3221t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
          uniqueKey1: 104, input3221y: value3221t4, input3221v: value3221t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
          uniqueKey1: 105, input3221y: value3221t5, input3221v: value3221t10
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form32Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form32Data.append('criteria3Fieldinfo', jsonBlob(inputDataList));
    if (pathValue321f1 !== '') {
      form32Data.append('uploadfile3', value321f1, 'f321f1-' + value321f1.name);
    }
    if (pathValue321f2 !== '') {
      form32Data.append('uploadfile3', value321f2, 'f321f2-' + value321f2.name);
    }
    if (pathValue3221f1 !== '') {
      form32Data.append(
        'uploadfile3',
        value3221f1,
        'f3221f1-' + value3221f1.name
      );
    }
    if (pathValue3221f2 !== '') {
      form32Data.append(
        'uploadfile3',
        value3221f2,
        'f3221f2-' + value3221f2.name
      );
    }
    if (pathValue3221f3 !== '') {
      form32Data.append(
        'uploadfile3',
        value3221f3,
        'f3221f3-' + value3221f3.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form32Data,
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





  useEffect(
    () => fetch(resources.APPLICATION_URL+'viewResponseValue').then(
      (response) => response
        .json()
        .then((data) => {
          console.log("response value is from backend==>"+JSON.stringify(data));
          setViewResponseValue(data);
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ),
    []
  );

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
    <div className="c32-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c32x-colorIndicator-container">
        <p className="c32x-QlcolorIndicator-circle-style"></p>
        <span className="c32x-colorIndicator-span-style">Qualitative</span>
        <p className="c32x-QtcolorIndicator-circle-style"></p>
        <span className="c32x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c32x-weightage-heading-style">
            Key Indicator Weightage: 15
          </h1>
        </div>
      </div>

      {/* Key Indicator: 3.2.1 */}
      <div className="c32x-eachInputField-container">
        <div className="c32x-weightage-container">
          <h1 className="c32x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c32x-Ql-label-textarea-container">
            <div className="c32x-heading_Help-container">
              <h1 className="c32x-heading-style">
                <span className="c32x-span-style">3.2.1: </span>
                Institution has created an eco system for innovations, creation
                and transfer of knowledge supported by dedicated centers for
                research, entrepreneurship, community orientation, Incubation
                etc
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c32x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
              isOpen={isOpen}
              handleClose={handleHelpClose}
              title='Write description in a maximum of 500 words'>
              </HelpButton>
            </div>
            <label htmlFor="321-t1" className="c32x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue321t1(e.target.value);
                setResponseValue321(e.target.value);
              }}
              value={value321t1}
              rows={10}
              className="c32x-textarea-style"
              id="321-t1"
            ></textarea>
            {value321t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c32x-Ql-table-style">
            <tr>
              <th className="c32x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c32x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c32x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c32x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c32x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c32x-Ql-tableBorders-style"></td>
              <td className="c32x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue321f1(e.target.files[0]);
                    setPathValue321f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="321-f1"
                  type="file"
                  className="c32-fileButton-style"
                />
                {pathValue321f1 === '' ? null : (
                  <div className="c32-fileButtons-container">
                    <button className="c32-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue321f1("");
                      document.getElementById("321-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c32x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue321f2(e.target.files[0]);
                    setPathValue321f2(e.target.value);
                    showFilePreview(e);

                  }}
                  id="321-f2"
                  type="file"
                  className="c32-fileButton-style"
                />
                {pathValue321f2 === '' ? null : (
                  <div className="c32-fileButtons-container">
                    <button className="c32-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue321f2("");
                      document.getElementById("321-f2").value="" }} >
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

      {/* Key Indicator: 3.2.2 */}
      <div className="c32x-eachInputField-container">
        <div className="c32x-weightage-container">
          <h1 className="c32x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c32x-container">
            <div className="c32x-heading_Help-container">
              <h1 className="c32x-heading-style">
                <span className="c32x-span-style">3.2.2: </span>
                Number of workshops/seminars conducted on Research methodology,
                Intellectual Property Rights (IPR),entrepreneurship, skill
                development during the last five years
              </h1>
              <button
                onClick={handleHelpOpen2}
                className="c32x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
              isOpen={isOpen2}
              handleClose={handleHelpClose2}
              title='Upload supporting document'>
              </HelpButton>
            </div>
            <div className="c32x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus322(!responseButtonStatus322);
                  onClickingViewResponse322();
                }}
                className="c32x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus322 ? (
                <p className="c32x-responseResult-style">{responseValue322}</p>
              ) : null}
            </div>
          </div>
          <div className="c32xx-container">
            <h1 className="c32xx-Heading-style">
              <span className="c32xx-span-style">3.2.2.1: </span>
              Total number of workshops/seminars conducted on Research
              methodology, Intellectual Property Rights (IPR),entrepreneurship,
              skill development year-wise during the last five years
            </h1>

            <table className="c32x-Qt-table-style">
              <tr>
                <th className="c32x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3221t1(e.target.value)}
                      id="3221-t1"
                      className="c32x-input-style"
                      type="number"
                      value={value3221t1}
                    />
                    {value3221t1 === '' ? (
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
                      onChange={(e) => setValue3221t2(e.target.value)}
                      id="3221-t2"
                      className="c32x-input-style"
                      type="number"
                      value={value3221t2}
                    />
                    {value3221t2 === '' ? (
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
                      onChange={(e) => setValue3221t3(e.target.value)}
                      id="3221-t3"
                      className="c32x-input-style"
                      type="number"
                      value={value3221t3}
                    />
                    {value3221t3 === '' ? (
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
                      onChange={(e) => setValue3221t4(e.target.value)}
                      id="3221-t4"
                      className="c32x-input-style"
                      type="number"
                      value={value3221t4}
                    />
                    {value3221t4 === '' ? (
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
                      onChange={(e) => setValue3221t5(e.target.value)}
                      id="3221-t5"
                      className="c32x-input-style"
                      type="number"
                      value={value3221t5}
                    />
                    {value3221t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c32x-horizontalTable-heading-style">
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
                        setValue3221t6(e.target.value);
                        onClickingViewResponse322();
                      }}
                      id="3221-t6"
                      className="c32x-input-style"
                      type="number"
                      value={value3221t6}
                    />
                    {value3221t6 === '' ? (
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
                        setValue3221t7(e.target.value);
                        onClickingViewResponse322();
                      }}
                      id="3221-t7"
                      className="c32x-input-style"
                      type="number"
                      value={value3221t7}
                    />
                    {value3221t7 === '' ? (
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
                        setValue3221t8(e.target.value);
                        onClickingViewResponse322();
                      }}
                      id="3221-t8"
                      className="c32x-input-style"
                      type="number"
                      value={value3221t8}
                    />
                    {value3221t8 === '' ? (
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
                        setValue3221t9(e.target.value);
                        onClickingViewResponse322();
                      }}
                      id="3221-t9"
                      className="c32x-input-style"
                      type="number"
                      value={value3221t9}
                    />
                    {value3221t9 === '' ? (
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
                        setValue3221t10(e.target.value);
                        onClickingViewResponse322();
                      }}
                      id="3221-t10"
                      className="c32x-input-style"
                      type="number"
                      value={value3221t10}
                    />
                    {value3221t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c32x-table-style">
              <tr>
                <th className="c32x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c32x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c32x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c32x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Report of the event</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3221f1(e.target.files[0]);
                      setPathValue3221f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3221-f1"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3221f1 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3221f1("");
                      document.getElementById("3221-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3221f2(e.target.files[0]);
                      setPathValue3221f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3221-f2"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3221f2 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3221f2("");
                      document.getElementById("3221-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>List of workshops/seminars during last 5 years</td>
                <td>
                <a href={downloadFile("af3.2.2.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3221f3(e.target.files[0]);
                      setPathValue3221f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3221-f3"
                    type="file"
                    className="c32-fileButton-style"
                  />
                  {pathValue3221f3 === '' ? null : (
                    <div className="c32-fileButtons-container">
                      <button className="c32-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3221f3("");
                      document.getElementById("3221-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      <div className="c32x-button-container">
        <button onClick={onClickingSave} className="c32x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria32;
