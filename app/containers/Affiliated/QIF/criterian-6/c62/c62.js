import React, { useState } from 'react';
import './c62-style.css';
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
function Help621(props) {
  return props.isHelp621Clicked ? (
    <div className="c62x-help-mainContainer">
      <div className="c62x-help-subContainer">
        <h1 className="c62x-help-heading-style">
          The institutional Strategic/ Perspective plan is effectively deployed
        </h1>
        <p className="c62x-help-para-style">
          Describe one activity successfully implemented based on the strategic
          plan within a maximum of 500 words
        </p>
        <button
          className="c62x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp621Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help622(props) {
  return props.isHelp622Clicked ? (
    <div className="c62x-help-mainContainer">
      <div className="c62x-help-subContainer">
        <h1 className="c62x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c62x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>The total amount of seed
          money provided by institution to its teachers for research in the last
          five years
          <span style={{ fontWeight: 'bold' }}>) /</span>
        </p>
        <button
          className="c62x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp622Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria62() {
// help button
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
  const [value621t1, setValue621t1] = useState();
  const [value621f1, setValue621f1] = useState();
  const [pathValue621f1, setPathValue621f1] = useState('');

  const [value621f2, setValue621f2] = useState();
  const [pathValue621f2, setPathValue621f2] = useState('');
  const [value621f3, setValue621f3] = useState();
  const [pathValue621f3, setPathValue621f3] = useState('');
  const [responseValue621, setResponseValue621] = useState('');

  const [value622t1, setValue622t1] = useState();
  const [value622f1, setValue622f1] = useState('');
  const [pathValue622f1, setPathValue622f1] = useState('');
  const [value622f2, setValue622f2] = useState('');
  const [pathValue622f2, setPathValue622f2] = useState('');
  const [value622f3, setValue622f3] = useState('');
  const [pathValue622f3, setPathValue622f3] = useState('');
  const [value622f4, setValue622f4] = useState('');
  const [pathValue622f4, setPathValue622f4] = useState('');
  const [responseButtonStatus622, setResponseButtonStatus622] = useState(false);
  const [responseValue622, setResponseValue622] = useState('');

  const [help621Status, setHelp621Status] = useState(false);
  const [help622Status, setHelp622Status] = useState(false);
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


  // sending data to db with API
  const financialYear="2021-2022";
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
    criteria62Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 101,
      input621t1: value621t1,
      input622t1: value622t1,
      response622: responseValue622,
      response621: responseValue621,
      criteria62status:"save"
    },
    ],
    // criteria6FieldInfoQn: [
    //   {
    //     criteriaId: { collegeId: '1', financialYear:financialYear, typeofInstitution: "financialYear" },
    //     uniqueKey1: 101,
    //   input622t1: value622t1,
    //   response622: responseValue622,
    // },
    // ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form62Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form62Data.append('criteria6Fieldinfo', jsonBlob(inputDataList));

    if (pathValue621f1 !== '') {
      form62Data.append('uploadfile6', value621f1, 'f621f1-' + value621f1.name);
    }
    
    if (pathValue621f2 !== '') {
      form62Data.append('uploadfile6', value621f2, 'f621f2-' + value621f2.name);
    }

    if (pathValue621f3 !== '') {
      form62Data.append('uploadfile6', value621f3, 'f621f3-' + value621f3.name);
    }
    // if (pathValue622f1 !== '') {
    //   form62Data.append('uploadfile6', value622f1, 'f622f1-' + value622f1.name);
    // }
    if (pathValue622f2 !== '') {
      form62Data.append('uploadfile6', value622f2, 'f622f2-' + value622f2.name);
    }
    if (pathValue622f3 !== '') {
      form62Data.append('uploadfile6', value622f3, 'f622f3-' + value622f3.name);
    }
    if (pathValue622f4 !== '') {
      form62Data.append('uploadfile6', value622f4, 'f622f4-' + value622f4.name);
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form62Data,
    };
    fetch(
      resources.APPLICATION_URL+'criteria6upload',
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

  function onClickingViewResponse622(e) {
    e.preventDefault();
    setResponseButtonStatus622(!responseButtonStatus622);
    if (value622t1 === '') {
      setResponseValue622('Please select any option');
    } else {
      setResponseValue622(e.target.value);
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
  // rendering DOM
  return (
    <div className="c62-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c62x-colorIndicator-container">
        <p className="c62x-QlcolorIndicator-circle-style"></p>
        <span className="c62x-colorIndicator-span-style">Qualitative</span>
        <p className="c62x-QtcolorIndicator-circle-style"></p>
        <span className="c62x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c62x-weightage-heading-style">
            Key Indicator Weightage: 12
          </h1>
        </div>
      </div>

      {/* Key Indicator: 6.2.1 */}
      <div className="c62x-eachInputField-container">
        <div className="c62x-weightage-container">
          <h1 className="c62x-weightage-heading-style">Weightage: 8</h1>
        </div>
        <form>
          <div className="c62x-Ql-label-textarea-container">
            <div className="c62x-heading_Help-container">
              <h1 className="c62x-heading-style">
                <span className="c62x-span-style">6.2.1: </span>
                The functioning of the institutional bodies is effective and
                 efficient as visible from policies, administrative setup, appointment and service rules, procedures, deployment of institutional Strategic/ perspective/development plan etc
              </h1>
               <button
                onClick={handleHelpOpen}
                className="c62x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
              isOpen={isOpen}
              handleClose={handleHelpClose}
              title='Write description in a maximum of 500 words'></HelpButton>
            </div>
            <label htmlFor="621-t1" className="c61x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue621t1(e.target.value);
                setResponseValue621(e.target.value);
              }}
              value={value621t1}
              rows={10}
              className="c62x-textarea-style"
              id="621-t1"
            ></textarea>
            {value621t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c62x-Ql-table-style">
            <tr>
              <th className="c62x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c62x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c62x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c62x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Strategic Plan and deployment documents on the website
              </td>
              <td className="c62x-Ql-tableBorders-style"></td>
              <td className="c62x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue621f1(e.target.files[0]);
                    setPathValue621f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="621-f1"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue621f1 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue621f1("");
                      document.getElementById("621-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Paste link for additional Information
              </td>
              <td className="c62x-Ql-tableBorders-style"></td>
              <td className="c62x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue621f2(e.target.files[0]);
                    setPathValue621f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="621-f2"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue621f2 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue621f2("");
                      document.getElementById("621-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c62x-Ql-tableBorders-style">
                {/* <a>View Template</a> */}
              </td>
              <td className="c62x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue621f3(e.target.files[0]);
                    setPathValue621f3(e.target.value);
                    showFilePreview(e);
                  }}
                  id="621-f3"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue621f3 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue621f3("");
                      document.getElementById("621-f3").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 6.2.2 */}
      <div className="c62x-eachInputField-container">
        <div className="c62x-weightage-container">
          <h1 className="c62x-weightage-heading-style">Weightage: 4</h1>
        </div>
        <form>
          <div className="c62x-container">
            <div className="c62x-heading_Help-container">
              <div>
                <h1 className="c62x-heading-style">
                  <span className="c34x-span-style">6.2.2: </span>
                  Implementation of e-governance in areas of operation
                </h1>
                <p className="c62x-para-style">
                  1. Administration
                  <br />
                  2. Finance and Accounts
                  <br />
                  3. Student Admission and Support
                  <br />
                  4. Examination
                </p>
                <div className="c62x-radio-container" style={{width:"180%"}}>
                  <div className="c62x-radio-subContainer"  style={{width:"45%"}}>
                    <div className="c62x-eachRadio-container">
                      <input name="622options" id="622-t1" type="radio" onChange={(e) => { setValue622t1(e.target.value); }} value="All of the above"/>

                      <label className="c62x-radioLabel-style" for="622-t1">
                        All of the above
                      </label>
                    </div>

                    <div className="c62x-eachRadio-container">
                      <input name="622options" id="622-t1" type="radio" onChange={(e) => { setValue622t1(e.target.value); }} value="Any three of the above"/>

                      <label className="c62x-radioLabel-style" for="622-t2">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c62x-eachRadio-container">
                      <input name="622options" id="622-t1" type="radio" onChange={(e) => { setValue622t1(e.target.value); }} value="Any two of the above"/>

                      <label className="c62x-radioLabel-style" for="622-t3">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c62x-radio-subContainer">
                    <div className="c62x-eachRadio-container">
                      <input name="622options" id="622-t1" type="radio" onChange={(e) => { setValue622t1(e.target.value); }} value="Any one of the above"/>

                      <label className="c62x-radioLabel-style" for="622-t4">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c62x-eachRadio-container">
                      <input name="622options" id="622-t1" type="radio" onChange={(e) => { setValue622t1(e.target.value); }} value="None of the above"/>

                      <label className="c62x-radioLabel-style" for="622-t5">
                        None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen2}
                className="c62x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
              isOpen={isOpen2}
              handleClose={handleHelpClose2}
              title='file description'></HelpButton>
            </div>
            <div className="c62x-response-container">
              <button
                onClick={onClickingViewResponse622}
                className="c62x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus622 ? (
                <p className="c62x-responseResult-style">{responseValue622}</p>
              ) : null}
            </div>
          </div>
          <table className="c62x-table-style">
            <tr>
              <th className="c62x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c62x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c62x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c62x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>ERP (Enterprise Resource Planning) Document</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => { setValue622f1(e.target.value); setPathValue622f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="622-f1"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue622f1 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue622f1("");
                      document.getElementById("622-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c62x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Screen shots of user interfaces</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue622f2(e.target.files[0]);
                    setPathValue622f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="622-f2"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue622f2 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue622f2("");
                      document.getElementById("622-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c62x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue622f3(e.target.files[0]);
                    setPathValue622f3(e.target.value);
                    showFilePreview(e);
                  }}
                  id="622-f3"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue622f3 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue622f3("");
                      document.getElementById("622-f3").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c62x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Details of implementation of e-governance in area of operation
              </td>
              <td>
                {/* <a href="http://localhost:8080/api/v1/download/criteria6.2.3.xlsx">View Template</a> */}
              </td>
              <td>
                <input
                  onChange={(e) => {
                    setValue622f4(e.target.files[0]);
                    setPathValue622f4(e.target.value);
                    showFilePreview(e);
                  }}
                  id="622-f4"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue622f4 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue622f4("");
                      document.getElementById("622-f4").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c62x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      <div className="c62x-button-container">
        <button className="c62x-button-style" onClick={onClickingSave}>Save</button>
      </div>
    </div>
  );
}

export default Criteria62;
