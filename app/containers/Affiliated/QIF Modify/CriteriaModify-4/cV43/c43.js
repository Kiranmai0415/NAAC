import React, { useState,useEffect } from 'react';
import './c43-style.css';
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

function Help431(props) {
  return props.isHelp431Clicked ? (
    <div className="c43x-help-mainContainer">
      <div className="c43x-help-subContainer">
        <h1 className="c43x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c43x-help-para-style">
          Describe IT facilities including Wi-Fi with date and nature of
          updation within a maximum of 500 words
        </p>
        <button
          className="c43x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp431Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help432(props) {
  return props.isHelp432Clicked ? (
    <div className="c43x-help-mainContainer">
      <div className="c43x-help-subContainer">
        <h1 className="c43x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c43x-help-para-style">
        Number of students: Number of computers
        </p>
        <button
          className="c43x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp432Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}


function Criteria43() {
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
  const [value431t1, setValue431t1] = useState();
  const [value431f1, setValue431f1] = useState('');
  const [pathValue431f1, setPathValue431f1] = useState('');
  const [pathValue431f2, setPathValue431f2] = useState('');
  const [value431f2, setValue431f2] = useState();
  const [responseValue431, setResponseValue431] = useState('');
  const [help431Status, setHelp431Status] = useState(false);

  const [value432t1, setValue432t1] = useState();
  const [value432t2, setValue432t2] = useState();
  const [value432f1, setValue432f1] = useState('');
  const [pathValue432f1, setPathValue432f1] = useState('');
  const [responseButtonStatus432, setResponseButtonStatus432] = useState(false);
  const [responseValue432, setResponseValue432] = useState('');
  const [help432Status, setHelp432Status] = useState(false);
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
 const financialYear="2021-2022";
 function downloadFile(fileName) {
  const filePath = "http://localhost:8080/api/v1/download/" + fileName;
  return filePath;
}
useEffect(
  () => fetch(resources.APPLICATION_URL+'criteria4getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,).then(
    (response) => response
      .json()
      .then((data) => {
        console.log(JSON.stringify(data));

        setValue431t1(data[0].criteria43Ql[0]?data[0].criteria43Ql[0].input431t1:"");
            setValue432t1(data[0].criteria43Qn[0]?data[0].criteria43Qn[0].input432t1:"");
            setValue432t2(data[0].criteria43Qn[0]?data[0].criteria43Qn[0].input432t2:"");

            setValue431f1(data[0].criteria4FileUpload[0]?data[0].criteria4FileUpload[0].criteria4FileName:"");
            setValue431f2(ddata[0].criteria4FileUpload[1]?data[0].criteria4FileUpload[1].criteria4FileName:"");
            setValue432f1(data[0].criteria4FileUpload[2]?data[0].criteria4FileUpload[2].criteria4FileName:"");
      })
      .catch((error) => {
        console.error("Error:", error);
      })
  ),
  []
);




// sending data to db with API
 
const inputDataList = {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
      criteria43Ql: [ 
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
          uniqueKey1: 101,
           input431t1: value431t1,
           response431: responseValue431, },
      ],
      criteria43Qn: [
        {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
          uniqueKey1: 101,
        input432t1: value432t1,
        input432t2: value432t2,
        response432: responseValue432,
        criteria43status:"save"
      },
      ],
};

function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: 'application/json',
  });
}

function onClickingSave() {
  const form43Data = new FormData();

  form43Data.append('criteria4Fieldinfo', jsonBlob(inputDataList));
  if (pathValue431f1 !== '') {
    form43Data.append('uploadfile4', value431f1, 'f431f1-' + value431f1.name);
  }
  if (pathValue431f2 !== '') {
    form43Data.append('uploadfile4', value431f2, 'f431f2-' + value431f2.name);
  }
  if (pathValue432f1 !== '') {
    form43Data.append('uploadfile4', value432f1, 'f432f1-' + value432f1.name);
  }

  const filesFetchMethod = {
    method: 'POST',
    headers: { Accept: 'application/json ,text/plain' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: form43Data,
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

 // response functionality
  function onClickingViewResponse432() {
    if (value432t1 === '' || value432t2 === '' || value432t1 === undefined || value432t2 === undefined) {
      setResponseValue432('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value432t1, 10)) === false
      || Number.isInteger(parseInt(value432t2, 10)) === false
    ) {
      setResponseValue432('Input should be an Integer');
    } else if (value432t1 !== '' && value432t2 !== '') {
      setResponseValue432(parseInt(value432t1, 10) / parseInt(value432t2, 10));
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
    <div className="c43-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c43x-colorIndicator-container">
        <p className="c43x-QlcolorIndicator-circle-style"></p>
        <span className="c43x-colorIndicator-span-style">Qualitative</span>
        <p className="c43x-QtcolorIndicator-circle-style"></p>
        <span className="c43x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c43x-weightage-heading-style">
            Key Indicator Weightage: 30
          </h1>
        </div>
      </div>

      {/* Key Indicator: 4.3.1 */}
      <div className="c43x-eachInputField-container">
        <div className="c43x-weightage-container">
          <h1 className="c43x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c43x-Ql-label-textarea-container">
            <div className="c43x-heading_Help-container">
              <h1 className="c43x-heading-style">
                <span className="c43x-span-style">4.3.1: </span>
                Institution has an IT policy covering wi-fi, cyber security,
                etc., and allocated budget for updating its IT facilities
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c43x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <label htmlFor="431-t1" className="c43x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue431t1(e.target.value);
                setResponseValue431(e.target.value);
              }}
              value={value431t1}
              rows={10}
              className="c43x-textarea-style"
              id="431-t1"
            ></textarea>
            {value431t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c43x-Ql-table-style">
            <tr>
              <th className="c43x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c43x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c43x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c43x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c43x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c43x-Ql-tableBorders-style"></td>
              <td className="c43x-Ql-tableBorders-style">
              <input
                    onChange={(e) => {
                      setValue431f1(e.target.files[0]);
                      setPathValue431f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="431-f1"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue431f1 === '' ? null : (
                    <div className="c27-fileButtons-container">
                      <button className="c27-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue431f1("");
                      document.getElementById("431-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value431f1)} target="_blank">View File</a> */}
              
              </td>
              <td className="c43x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
              <input
                    onChange={(e) => {
                      setValue431f2(e.target.files[0]);
                      setPathValue431f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="431-f2"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue431f2 === '' ? null : (
                    <div className="c27-fileButtons-container">
                      <button className="c27-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue431f2("");
                      document.getElementById("431-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                 
                 
              
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 4.3.2 */}
      <div className="c43x-eachInputField-container">
        <div className="c43x-weightage-container">
          <h1 className="c43x-weightage-heading-style">Weightage: 8</h1>
        </div>
        <form>
          <div className="c43x-container">
            <div className="c43x-heading_Help-container">
              <h1 className="c43x-heading-style">
                <span className="c43x-span-style">4.3.2: </span>
                Student - Computer ratio (Data for the latest completed academic
                year)
              </h1>
              <button
                onClick={handleHelpOpen2}
                className="c43x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen2}
                handleClose={handleHelpClose2}
                title='file description'
                ></HelpButton>
            </div>
            <div className="c43x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus432(!responseButtonStatus432);
                  onClickingViewResponse432();
                }}
                className="c43x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus432 ? (
                <p className="c43x-responseResult-style">{responseValue432}</p>
              ) : null}
            </div>
          </div>
          <div className="c43xx-container">
            <h1 className="c43xx-Heading-style">
            4.3.2.1. Number of computers available for students usage during the 
latest completed academic year:
              <input
                onChange={(e) => setValue432t1(e.target.value)}
                id="432-t1"
                style={{ width:"25%", marginLeft: '50%' }}
                type="number"
                value={value432t1}
              /></h1>
            {/* <h1 className="c43xx-Heading-style">
                Number of computers:
              <input
                onChange={(e) => setValue432t2(e.target.value)}
                id="432-t2"
                style={{ width:"25%", marginLeft: '48.3%' }}
                type="number"
                value={value432t2}

              /></h1> */}
          </div>

          <table className="c43x-table-style">
            <tr>
              <th className="c43x-Qt-verticalTable-heading1-style">
                  File Description
              </th>
              <th className="c43x-Qt-verticalTable-heading2-style">
                  File Template
              </th>
              <th className="c43x-Qt-verticalTable-heading3-style">
                  Documents upload
              </th>
              <th className="c43x-Qt-verticalTable-heading4-style">
                  File type and size
              </th>
            </tr>
            <tr>
              <td>Upload any additional information</td>
              <td></td>
              <td>
              <input
                    onChange={(e) => {
                      setValue432f1(e.target.files[0]);
                      setPathValue432f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="432-f1"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue432f1 === '' ? null : (
                    <div className="c27-fileButtons-container">
                      <button className="c27-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue432f1("");
                      document.getElementById("432-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value432f1)} target="_blank">View File</a> */}
              
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
      <div className="c43x-button-container">
        <button className="c43x-button-style" onClick={onClickingSave}>
          Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria43;
