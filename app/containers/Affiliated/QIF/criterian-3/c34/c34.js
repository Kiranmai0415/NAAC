import React, { useState ,useEffect } from 'react';
import './c34-style.css';
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

function Help342(props) {
  return props.isHelp342Clicked ? (
    <div className="c34x-help-mainContainer">
      <div className="c34x-help-subContainer">
        <h1 className="c34x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c34x-help-para-style">
          Describe the impact of extension activities in sensitising students to
          social issues and holistic development within a maximum of 500 words
        </p>
        <button
          className="c34x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp342Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help343(props) {
  return props.isHelp343Clicked ? (
    <div className="c34x-help-mainContainer">
      <div className="c34x-help-subContainer">
        <h1 className="c34x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c34x-help-para-style">
          Number of extension and outreach programs conducted by the institution
          including those through NSS/NCC, Government and Government recognised
          bodies during the last five years.
        </p>
        <button
          className="c34x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp343Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// state variables
function Criteria34() {
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

      // /this is Help button 
      const [isOpen, setIsopen] = useState(false)
      const handleHelpOpen = (e) => {
        e.preventDefault(),
        setIsopen(true)
      }
      const handleHelpClose = () => {
        setIsopen(false)
      }
  const [value341t1, setValue341t1] = useState();

  const [value341f1, setValue341f1] = useState('');
  const [pathValue341f1, setPathValue341f1] = useState('');
  const [value341f2, setValue341f2] = useState('');
  const [pathValue341f2, setPathValue341f2] = useState('');
  const [responseValue341, setResponseValue341] = useState('');
  const [help341Status, setHelp341Status] = useState(false);
  const [pathValue3441f1, setPathValue3441f1] = useState('')
  const [pathValue3441f2, setPathValue3441f2] = useState('')
  const [pathValue3441f3, setPathValue3441f3] = useState('')
  const [value342t1, setValue342t1] = useState();

  const [value342f1, setValue342f1] = useState('');
  const [pathValue342f1, setPathValue342f1] = useState('');
  const [value342f2, setValue342f2] = useState('');
  const [pathValue342f2, setPathValue342f2] = useState('');
  const [responseValue342, setResponseValue342] = useState('');
  const [help342Status, setHelp342Status] = useState(false);

  const [value3431t1, setValue3431t1] = useState();
  const [value3431t2, setValue3431t2] = useState();
  const [value3431t3, setValue3431t3] = useState();
  const [value3431t4, setValue3431t4] = useState();
  const [value3431t5, setValue3431t5] = useState();
  const [value3431t6, setValue3431t6] = useState();
  const [value3431t7, setValue3431t7] = useState();
  const [value3431t8, setValue3431t8] = useState();
  const [value3431t9, setValue3431t9] = useState();
  const [value3431t10, setValue3431t10] = useState();
  const [value3431f1, setValue3431f1] = useState('');
  const [pathValue3431f1, setPathValue3431f1] = useState('');
  const [value3431f2, setValue3431f2] = useState('');
  const [pathValue3431f2, setPathValue3431f2] = useState('');
  const [value3431f3, setValue3431f3] = useState('');
  const [pathValue3431f3, setPathValue3431f3] = useState('');
  const [responseButtonStatus343, setResponseButtonStatus343] = useState(false);
  const [responseValue343, setResponseValue343] = useState('');
  const [help343Status, setHelp343Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');
  const [viewResponseValue, setViewResponseValue] = useState(0);

// response functionality
  function onClickingViewResponse343() {
    if (
      value3431t6 === ''
      || value3431t7 === ''
      || value3431t8 === ''
      || value3431t9 === ''
      || value3431t10 === ''
      || value3431t6 === undefined
      || value3431t7 === undefined
      || value3431t8 === undefined
      || value3431t9 === undefined
      || value3431t10 === undefined
    ) {
      setResponseValue343('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3431t6, 10)) === false
      || Number.isInteger(parseInt(value3431t7, 10)) === false
      || Number.isInteger(parseInt(value3431t8, 10)) === false
      || Number.isInteger(parseInt(value3431t9, 10)) === false
      || Number.isInteger(parseInt(value3431t10, 10)) === false
    ) {
      setResponseValue343('Input should be an Integer');
    } else if (
      value3431t6 !== ''
      && value3431t7 !== ''
      && value3431t8 !== ''
      && value3431t9 !== ''
      && value3431t10 !== ''
    ) {
      setResponseValue343(
     ( (parseInt(value3431t6, 10)+
     parseInt(value3431t7, 10)+
     parseInt(value3431t8, 10)+
     parseInt(value3431t9, 10)+
     parseInt(value3431t10, 10))/ viewResponseValue)*100
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
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
    criteria34Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
        uniqueKey1: 101,
        input341t1: value341t1,
        response341: responseValue341,
        
      },
    ],
    criteria34Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
        uniqueKey1: 101,
        input342t1: value342t1,
        response342: responseValue342,
        response343: responseValue343,
        criteria34status:"save"

      },
    ],
   

    yearTable3431: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 101, input3431y: value3431t1, input3431v: value3431t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 102, input3431y: value3431t2, input3431v: value3431t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 103, input3431y: value3431t3, input3431v: value3431t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 104, input3431y: value3431t4, input3431v: value3431t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
         uniqueKey1: 105, input3431y: value3431t5, input3431v: value3431t10
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form34Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form34Data.append('criteria3Fieldinfo', jsonBlob(inputDataList));
    if (pathValue341f1 !== '') {
      form34Data.append('uploadfile3', value341f1, 'f341f1-' + value341f1.name);
    }
    if (pathValue3431f1 !== '') {
      form34Data.append(
        'uploadfile3',
        value3431f1,
        'f3431f1-' + value3431f1.name
      );
    }
    if (pathValue3431f2 !== '') {
      form34Data.append(
        'uploadfile3',
        value3431f2,
        'f3431f2-' + value3431f2.name
      );
    }
    if (pathValue3431f3 !== '') {
      form34Data.append(
        'uploadfile3',
        value3431f3,
        'f3431f3-' + value3431f3.name
      );
    }
    if (pathValue3441f1 !== '') {
      form34Data.append(
        'uploadfile3',
        value3441f1,
        'f3441f1-' + value3441f1.name
      );
    }
    if (pathValue3441f2 !== '') {
      form34Data.append(
        'uploadfile3',
        value3441f2,
        'f3441f2-' + value3441f2.name
      );
    }
    if (pathValue3441f3 !== '') {
      form34Data.append(
        'uploadfile3',
        value3441f3,
        'f3441f3-' + value3441f3.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form34Data,
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
    <div className="c34-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c34x-colorIndicator-container">
        <p className="c34x-QlcolorIndicator-circle-style"></p>
        <span className="c34x-colorIndicator-span-style">Qualitative</span>
        <p className="c34x-QtcolorIndicator-circle-style"></p>
        <span className="c34x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c34x-weightage-heading-style">
            Key Indicator Weightage: 40
          </h1>
        </div>
      </div>

      {/* Key Indicator: 3.4.1 */}
      <div className="c34x-eachInputField-container">
        <div className="c34x-weightage-container">
          <h1 className="c34x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c34x-Ql-label-textarea-container">
            <div className="c34x-heading_Help-container">
              <h1 className="c34x-heading-style">
                <span className="c34x-span-style">3.4.1: </span>
                Extension activities are carried out in the neighbourhood
                community, sensitising students to social issues, for their
                holistic development, and impact thereof during the last five
                years
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c34x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
              isOpen={isOpen}
              handleClose={handleHelpClose}
              title='Write description in a maximum of 500 words'>
              </HelpButton>
            </div>
            <label htmlFor="341-t1" className="c34x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue341t1(e.target.value);
                setResponseValue341(e.target.value);
              }}
              value={value341t1}
              rows={10}
              className="c34x-textarea-style"
              id="341-t1"
            ></textarea>
            {value341t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c34x-Ql-table-style">
            <tr>
              <th className="c34x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c34x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c34x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c34x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c34x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c34x-Ql-tableBorders-style"></td>
              <td className="c34x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue341f1(e.target.files[0]);
                    setPathValue341f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="341-f1"
                  type="file"
                  className="c34-fileButton-style"
                />
                {pathValue341f1 === '' ? null : (
                  <div className="c34-fileButtons-container">
                    <button className="c34-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue341f1("");
                      document.getElementById("341-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c34x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue341f2(e.target.files[0]);
                    setPathValue341f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="341-f2"
                  type="file"
                  className="c34-fileButton-style"
                />
                {pathValue341f2 === '' ? null : (
                  <div className="c34-fileButtons-container">
                    <button className="c34-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue341f2("");
                      document.getElementById("341-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c34x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 3.4.2 */}
      <div className="c34x-eachInputField-container">
        <div className="c34x-weightage-container">
          <h1 className="c34x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c34x-Ql-label-textarea-container">
            <div className="c34x-heading_Help-container">
              <h1 className="c34x-heading-style">
                <span className="c34x-span-style">3.4.2: </span>
               Awards and recognitions received for Extension activities from 
               government / government recognised bodies
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c34x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
              isOpen={isOpen}
              handleClose={handleHelpClose}
              title='Write description in a maximum of 500 words'>
              </HelpButton>
            </div>
            <label htmlFor="342-t1" className="c34x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue342t1(e.target.value);
                setResponseValue342(e.target.value);
              }}
              value={value342t1}
              rows={10}
              className="c34x-textarea-style"
              id="341-t1"
            ></textarea>
            {value342t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c34x-Ql-table-style">
            <tr>
              <th className="c34x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c34x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c34x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c34x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c34x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c34x-Ql-tableBorders-style"></td>
              <td className="c34x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue342f1(e.target.files[0]);
                    setPathValue342f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="342-f1"
                  type="file"
                  className="c34-fileButton-style"
                />
                {pathValue342f1 === '' ? null : (
                  <div className="c34-fileButtons-container">
                    <button className="c34-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue342f1("");
                      document.getElementById("342-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c34x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue342f2(e.target.files[0]);
                    setPathValue342f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="342-f2"
                  type="file"
                  className="c34-fileButton-style"
                />
                {pathValue342f2 === '' ? null : (
                  <div className="c34-fileButtons-container">
                    <button className="c34-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue342f2("");
                      document.getElementById("342-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c34x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 3.4.3 */}
      <div className="c34x-eachInputField-container">
        <div className="c34x-weightage-container">
          <h1 className="c34x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c34x-container">
            <div className="c34x-heading_Help-container">
              <h1 className="c34x-heading-style">
                <span className="c34x-span-style">3.4.3: </span>
                Number of extension and outreach 
                Programmes conducted by the institution through NSS/ NCC/ Red Cross/ 
                YRC etc., (including the programmes such as Swachh Bharat, AIDS awareness, Gender issues etc. )and/or those organised in collaboration with industry, community 
                and NGOs during the last five years
              </h1>
              <button
                onClick={handleHelpOpen2}
                className="c34x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
              isOpen={isOpen2}
              handleClose={handleHelpClose2}
              title='file description'>
              </HelpButton>
            </div>
            <div className="c34x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus343(!responseButtonStatus343);
                  onClickingViewResponse343();
                }}
                className="c34x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus343 ? (
                <p className="c34x-responseResult-style">{responseValue343}</p>
              ) : null}
            </div>
          </div>
          <div className="c34xx-container">
            <h1 className="c34xx-Heading-style">
              <span className="c34xx-span-style">3.4.3.1: </span>
              Number of extension and outreach programs conducted by the
              institution through NSS/NCC, Government and Government recognised
              bodies during the last five years
            </h1>

            <table className="c34x-Qt-table-style">
              <tr>
                <th className="c34x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3431t1(e.target.value)}
                      id="3431-t1"
                      className="c34x-input-style"
                      type="number"
                      value={value3431t1}
                    />
                    {value3431t1 === '' ? (
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
                      onChange={(e) => setValue3431t2(e.target.value)}
                      id="3431-t2"
                      className="c34x-input-style"
                      type="number"
                      value={value3431t2}
                    />
                    {value3431t2 === '' ? (
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
                      onChange={(e) => setValue3431t3(e.target.value)}
                      id="3431-t3"
                      className="c34x-input-style"
                      type="number"
                      value={value3431t3}
                    />
                    {value3431t3 === '' ? (
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
                      onChange={(e) => setValue3431t4(e.target.value)}
                      id="3431-t4"
                      className="c34x-input-style"
                      type="number"
                      value={value3431t4}
                    />
                    {value3431t4 === '' ? (
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
                      onChange={(e) => setValue3431t5(e.target.value)}
                      id="3431-t5"
                      className="c34x-input-style"
                      type="number"
                      value={value3431t5}
                    />
                    {value3431t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c34x-horizontalTable-heading-style">
                  Number of programs
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
                      onChange={(e) => setValue3431t6(e.target.value)}
                      id="3431-t6"
                      className="c34x-input-style"
                      type="number"
                      value={value3431t6}
                    />
                    {value3431t6 === '' ? (
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
                      onChange={(e) => setValue3431t7(e.target.value)}
                      id="3431-t7"
                      className="c34x-input-style"
                      type="number"
                      value={value3431t7}
                    />
                    {value3431t7 === '' ? (
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
                      onChange={(e) => setValue3431t8(e.target.value)}
                      id="3431-t8"
                      className="c34x-input-style"
                      type="number"
                      value={value3431t8}
                    />
                    {value3431t8 === '' ? (
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
                      onChange={(e) => setValue3431t9(e.target.value)}
                      id="3431-t9"
                      className="c34x-input-style"
                      type="number"
                      value={value3431t9}
                    />
                    {value3431t9 === '' ? (
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
                      onChange={(e) => setValue3431t10(e.target.value)}
                      id="3431-t10"
                      className="c34x-input-style"
                      type="number"
                      value={value3431t10}
                    />
                    {value3431t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c34x-table-style">
              <tr>
                <th className="c34x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c34x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c34x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c34x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Reports of the event organized</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3431f1(e.target.files[0]);
                      setPathValue3431f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3431-f1"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3431f1 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3431f1("");
                      document.getElementById("3431-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3431f2(e.target.files[0]);
                      setPathValue3431f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3431-f2"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3431f2 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3431f2("");
                      document.getElementById("3431-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Number of extension and outreach Programmes conducted with
                  industry, community etc for the last five years
                </td>
                <td>
                <a href={downloadFile("af3.4.3.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3431f3(e.target.files[0]);
                      setPathValue3431f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3431-f3"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3431f3 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3431f3("");
                      document.getElementById("3431-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      <div className="c34x-button-container">
        <button onClick={onClickingSave} className="c34x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria34;
