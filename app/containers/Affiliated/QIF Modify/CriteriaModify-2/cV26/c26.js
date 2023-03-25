import React, { useState, useEffect } from 'react';
import { toast } from "react-toastify";
import './c26-style.css';
import AuthService from '../../../../Pages/Users/services/auth.service';
import { HelpButton } from '../../../../../reusableComponents/model/Help';
import { resources } from '../../../../appConstants';
// Help buttons functionality
function Help261(props) {
  return props.isHelp261Clicked ? (
    <div className="c26x-help-mainContainer">
      <div className="c26x-help-subContainer">
        <h1 className="c26x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c26x-help-para-style">
          Describe Course Outcomes(COs) for all courses and mechanism of
          communication within a maximum of 500 words.
        </p>
        <button
          className="c23x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp261Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help262(props) {
  return props.isHelp262Clicked ? (
    <div className="c26x-help-mainContainer">
      <div className="c26x-help-subContainer">
        <h1 className="c26x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c26x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>The Total number final
          year students who passed in the examination
          <span style={{ fontWeight: 'bold' }}>/</span>The total number of final
          year students who appeared for the examination
          <span style={{ fontWeight: 'bold' }}>) *</span> 100
        </p>
        <button
          className="c26x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp262Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria26() {
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
  const [isOpen2, setIsopen2] = useState(false)
  const handleHelpOpen2 = (e) => {
    e.preventDefault(),
    setIsopen2(true)
  }
  const handleHelpClose2 = () => {
    setIsopen2(false)
  }
  // state variables

  const [value261t1, setValue261t1] = useState();
  const [value262t1, setValue262t1] = useState();

  const [pathValue261f1, setPathValue261f1] = useState('');
  const [value261f1, setValue261f1] = useState([]);
  const [pathValue261f2, setPathValue261f2] = useState('');
  const [value261f2, setValue261f2] = useState([]);
  const [pathValue261f3, setPathValue261f3] = useState('');
  const [value261f3, setValue261f3] = useState([]);

  const [value2622t1, setValue2622t1] = useState();
  const [value2621t1, setValue2621t1] = useState();
  const [pathValue2622f1, setPathValue2622f1] = useState('');
  const [value2622f1, setValue2622f1] = useState([]);
  const [pathValue2622f2, setPathValue2622f2] = useState('');
  const [value2622f2, setValue2622f2] = useState([]);
  const [pathValue2622f3, setPathValue2622f3] = useState('');
  const [value2622f3, setValue2622f3] = useState([]);
  const [responseButtonStatus262, setResponseButtonStatus262] = useState(false);
  const [responseValue261, setResponseValue261] = useState('');
  const [responseValue262, setResponseValue262] = useState('');
  const [help261Status, setHelp261Status] = useState(false);
  const [help262Status, setHelp262Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');

  
 // Alert custom messages start
 const successMessage = (message) => {
  toast.success(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "success1",
    className: "success",
  });
};
const errorMessage = (message) => {
  toast.error(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "error1",
    className: "error",
  });
};



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
//get api data
   const financialYear="2021-2022";

useEffect(
  () => fetch(resources.APPLICATION_URL+'criteria2getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,).then(
    (response) => response
      .json()
      .then((data) => {
        console.log(JSON.stringify(data));

        setValue261t1(data[0].criteria26Ql[0]?data[0].criteria26Ql[0].input261t1:"");

            setValue2621t1(data[0].criteria26Qn[0]?data[0].criteria26Qn[0].input2621t1:"");
            setValue2622t1(data[0].criteria26Qn[0]?data[0].criteria26Qn[0].input2622t2:"");
        
      })
      .catch((error) => {
        console.error("Error:", error);
      })
  ),
  []
);

  // response button functionality
  function onClickingViewResponse262() {
    if (value2621t1 === '' || value2622t1 === '') {
      setResponseValue262('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value2621t1, 10)) === false
      || Number.isInteger(parseInt(value2622t1, 10)) === false
    ) {
      setResponseValue262('Input should be an Integer');
    } else if (value2621t1 !== '' && value2622t1 !== '') {
      setResponseValue262(
        (parseInt(value2621t1, 10) / parseInt(value2622t1, 10)) * 100
      );
    }
  }

  
 // sending data to db with API
 
 const inputDataList = {
  criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},      
  criteria26Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
        uniqueKey1: 101,
        input261t1: value261t1,
      response261: responseValue261,
    },
  ],
  criteria26Qn: [
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
      uniqueKey1: 101,
      input2621t1: value2621t1,
      input2622t2: value2622t1,
      response262: responseValue262,
      criteria26status:"save"
    },
  ],
};

function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: 'application/json',
  });
}

function onClickingSave() {
  const form26Data = new FormData();

  form26Data.append('criteria2Fieldinfo', jsonBlob(inputDataList));
  if (pathValue261f1 !== '') {
    form26Data.append('uploadfile2', value261f1, 'f261f1-' + value261f1.name);
  }
  if (pathValue261f2 !== '') {
    form26Data.append('uploadfile2', value261f2, 'f261f2-' + value261f2.name);
  }
  if (pathValue261f3 !== '') {
    form26Data.append('uploadfile2', value261f3, 'f261f3-' + value261f3.name);
  }
  if (pathValue2622f1 !== '') {
    form26Data.append(
      'uploadfile2',
      value2622f1,
      'f2622f1-' + value2622f1.name
    );
  }
  if (pathValue2622f2 !== '') {
    form26Data.append(
      'uploadfile2',
      value2622f2,
      'f2622f2-' + value2622f2.name
    );
  }
  if (pathValue2622f3 !== '') {
    form26Data.append(
      'uploadfile3',
      value2622f3,
      'f2622f3-' + value2622f3.name
    );
  }
  const filesFetchMethod = {
    method: 'POST',
    headers: { Accept: 'application/json ,text/plain' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: form26Data,
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

// get data  with API
function downloadFile(fileName) {
  const filePath = resources.APPLICATION_URL+"download/" + fileName;
  return filePath;
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
    <div className="c26-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c26x-colorIndicator-container">
        <p className="c26x-QlcolorIndicator-circle-style"></p>
        <span className="c26x-colorIndicator-span-style">Qualitative</span>
        <p className="c26x-QtcolorIndicator-circle-style"></p>
        <span className="c26x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c26x-weightage-heading-style">
            Key Indicator Weightage: 90
          </h1>
        </div>
      </div>
      {/* Key Indicator: 2.6.1 */}
      <div className="c26x-eachInputField-container">
        <div className="c26x-weightage-container">
          <h1 className="c26x-weightage-heading-style">Weightage: 25</h1>
        </div>
        <form>
          <div className="c26x-container">
            <div className="c26x-heading_Help-container">
              <h1 className="c26x-heading-style">
                <span className="c26x-span-style">2.6.1: </span>
                Programme Outcomes (POs) and Course Outcomes (COs) for all Programmes offered by the institution are stated and displayed
                 on website and attainment of POs and COs are evaluated
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c26x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <label htmlFor="263-t1" className="c26x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue261t1(e.target.value);
                setResponseValue261(e.target.value);
              }}
              value={value261t1}
              rows={10}
              className="c26x-textarea-style"
              id="261-t1"
            ></textarea>
            {value261t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>
          <div className="c26xx-container">
            <table className="c26x-table-style">
              <tr>
                <th className="c26x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c26x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c26x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c26x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue261f1(e.target.files[0]);
                      setPathValue261f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="261-f1"
                    className="c26-fileButton-style"
                    type="file"
                  />
                  {pathValue261f1 === '' ? null : (
                    <div className="c26-fileButtons-container">
                      <button className="c26-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue261f1("");
                      document.getElementById("261-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value261f1)} target="_blank">View File</a> */}
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Link for Additional Information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue261f2(e.target.files[0]);
                      setPathValue261f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="261-f2"
                    className="c26-fileButton-style"
                    type="file"
                  />
                  {pathValue261f2 === '' ? null : (
                    <div className="c26-fileButtons-container">
                      <button className="c26-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue261f2("");
                      document.getElementById("261-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                   {/* <a href={downloadFile(value261f2)} target="_blank">View File</a> */}
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload COs for all courses (exemplars from Glossary)</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue261f3(e.target.files[0]);
                      setPathValue261f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="261-f3"
                    className="c26-fileButton-style"
                    type="file"
                  />
                  {pathValue261f3 === '' ? null : (
                    <div className="c26-fileButtons-container">
                      <button className="c26-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue261f3("");
                      document.getElementById("261-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                   {/* <a href={downloadFile(value261f3)} target="_blank">View File</a> */}
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 2.6.2 */}
      <div className="c26x-eachInputField-container">
        <div className="c26x-weightage-container">
          <h1 className="c26x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c26x-container">
            <div className="c26x-heading_Help-container">
              <h1 className="c26x-heading-style">
                <span className="c26x-span-style">2.6.2: </span>
                Pass Percentage of students(Data for the latest completed
                academic year)
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
                ><h1>(Total number of final year students who passed the
                   university examinationTotal number of final year students who appeared for the university examination) * 100</h1></HelpButton>
            </div>
            <div className="c26x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus262(!responseButtonStatus262);
                  onClickingViewResponse262();
                }}
                className="c26x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus262 ? (
                <p className="c26x-responseResult-style">{responseValue262}</p>
              ) : null}
            </div>
          </div>
          <div className="c26xx-container">
            <h1 className="c26xx-Heading-style">
              <span className="c26xx-span-style">2.6.2.1: </span>
              Total number of final year students who passed the examination
              conducted by Institution.
            </h1>
            <input
              onChange={(e) => setValue2621t1(e.target.value)}
              id="2621-t1"
              style={{width:"25%" , marginLeft: '70%' }}
              type="number"
              value={value2621t1}
            />
            {/* <h1 className="c26xx-Heading-style">
              <span className="c26xx-span-style">2.6.2.2: </span>
              Total number of final year students who attended the examination
              conducted by Institution.
            </h1>
            <input
              onChange={(e) => setValue2622t1(e.target.value)}
              id="2622-t1"
              style={{ width:"25%" , marginLeft: '70%' }}
              type="number"
              value={value2622t1}
            /> */}
            <table className="c26x-table-style">
              <tr>
                <th className="c26x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c26x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c26x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c26x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                  Upload List of Programmes and number of students passed and
                  appeared in the final year examination(Data Template)
                </td>
                <td> <a href={downloadFile("af2.6.2.xlsx")} target="_blank">View Template</a></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2622f1(e.target.files[0]);
                      setPathValue2622f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2622-f1"
                    className="c26-fileButton-style"
                    type="file"
                  />
                  {pathValue2622f1 === '' ? null : (
                    <div className="c26-fileButtons-container">
                      <button className="c26-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2622f1("");
                      document.getElementById("2622-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                   {/* <a href={downloadFile(value2622f1)} target="_blank">View File</a> */}
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2622f2(e.target.files[0]);
                      setPathValue2622f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2622-f2"
                    className="c26-fileButton-style"
                    type="file"
                  />
                  {pathValue2622f2 === '' ? null : (
                    <div className="c26-fileButtons-container">
                      <button className="c26-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2622f2("");
                      document.getElementById("2622-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value2622f2)} target="_blank">View File</a> */}
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Paste link for annual report</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2622f3(e.target.files[0]);
                      setPathValue2622f3(e.target.value); showFilePreview(e);
                    }}
                    id="2622-f3"
                    className="c26-fileButton-style"
                    type="file"
                  />
                  {pathValue2622f3 === '' ? null : (
                    <div className="c26-fileButtons-container">
                      <button className="c26-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2622f3("");
                      document.getElementById("2622-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value2622f3)} target="_blank">View File</a> */}
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
      <div className="c26x-button-container">
        <button onClick={onClickingSave} className="c26x-button-style">
          Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria26;
