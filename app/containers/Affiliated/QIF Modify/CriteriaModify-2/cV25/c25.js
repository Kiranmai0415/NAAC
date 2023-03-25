import React, { useState,useEffect } from 'react';
import { toast } from "react-toastify";
import './c25-style.css';
import AuthService from '../../../../Pages/Users/services/auth.service';
import { HelpButton } from '../../../../../reusableComponents/model/Help';
import { resources } from '../../../../appConstants';
// Help buttons functionality
function Help251(props) {
  return props.isHelp251Clicked ? (
    <div className="c25x-help-mainContainer">
      <div className="c25x-help-subContainer">
        <h1 className="c25x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c25x-help-para-style">
        Write description in a maximum of 500 words
        </p>
        <button
          className="c25x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp251Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria25() {
  // state variables
   // /this is Help button 
   const [isOpen, setIsopen] = useState(false)
   const handleHelpOpen = (e) => {
     e.preventDefault(),
     setIsopen(true)
   }
   const handleHelpClose = () => {
     setIsopen(false)
   }
  const [value251t1, setValue251t1] = useState();
  const [value251t2, setValue251t2] = useState();
  const [pathValue251f1, setPathValue251f1] = useState('');
  const [pathValue251f2, setPathValue251f2] = useState('');
  const [value251f1, setValue251f1] = useState([]);
  const [value251f2, setValue251f2] = useState([]);

  const [responseValue251, setResponseValue251] = useState('');
  const [help251Status, setHelp251Status] = useState(false);
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



  // get data  with API
  const financialYear="2021-2022";

  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }

  useEffect(
    () => fetch(resources.APPLICATION_URL+'criteria2getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,).then(
      (response) => response
        .json()
        .then((data) => {
          console.log("21 data is =>" + JSON.stringify(data));
          setValue251t1(data[0].criteria25Qn[0]?data[0].criteria25Qn[0].input251t1:"");
          setValue251f1(data[0].criteria2FileUpload[0]?data[0].criteria2FileUpload[0].criteria2FileName:"");
          setValue251f2(data[0].criteria2FileUpload[1]?data[0].criteria2FileUpload[1].criteria2FileName:"");
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

  criteria25Qn: [
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

      uniqueKey1: 101,
      input251t1: value251t1,
      response251: responseValue251 ,
      criteria25status:"save"
      },
  ],
  };

function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: 'application/json',
  });
}

function onClickingSave() {
  const form25Data = new FormData();

  form25Data.append('criteria2Fieldinfo', jsonBlob(inputDataList));

  if (pathValue251f1 !== '') {
    form25Data.append('uploadfile2', value251f1, 'f251f1-' + value251f1.name);
  }
  if (pathValue251f2 !== '') {
    form25Data.append('uploadfile2', value251f2, 'f251f2-' + value251f2.name);
  }

  const filesFetchMethod = {
    method: 'POST',
    headers: { Accept: 'application/json ,text/plain' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: form25Data,
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
    <div className="c25-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c25x-colorIndicator-container">
        <p className="c25x-QlcolorIndicator-circle-style"></p>
        <span className="c25x-colorIndicator-span-style">Qualitative</span>
        <p className="c25x-QtcolorIndicator-circle-style"></p>
        <span className="c25x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c25x-weightage-heading-style">
            Key Indicator Weightage: 40
          </h1>
        </div>
      </div>
      {/* Key Indicator: 2.5.1 */}
      <div className="c25x-eachInputField-container">
        <div className="c25x-weightage-container">
          <h1 className="c25x-weightage-heading-style">Weightage: 40</h1>
        </div>
        <form>
          <div className="c25x-container">
            <div className="c25x-heading_Help-container">
              <h1 className="c25x-heading-style">
                <span className="c25x-span-style">2.5.1: </span>
                Mechanism of internal/ external assessment is transparent and the 
grievance redressal system is time- bound and efficient.
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c25x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <label htmlFor="251-t1" className="c25x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue251t1(e.target.value);
                setResponseValue251(e.target.value);
              }}
              value={value251t1}
              rows={10}
              className="c25x-textarea-style"
              id="251-t1"
            ></textarea>
            {value251t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c25x-table-style">
            <tr>
              <th className="c25x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c25x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c25x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c25x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Any additional information</td>
              <td></td>
              <td>
              <input
                  onChange={(e) => {
                    setValue251f1(e.target.files[0]);
                    setPathValue251f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="251-f1"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue251f1 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue251f1("");
                      document.getElementById("251-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              {/* <a href={downloadFile(value251f1)} target="_blank">View File</a> */}
             
              </td>
              <td className="c25x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Link for Additional Information</td>
              <td></td>
              <td>
              <input
                  onChange={(e) => {
                    setValue251f2(e.target.files[0]);
                    setPathValue251f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="251-f2"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue251f2 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue251f2("");
                      document.getElementById("251-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              {/* <a href={downloadFile(value251f2)} target="_blank">View File</a> */}
              
              </td>
              <td className="c25x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
      <div className="c25x-button-container">
        <button onClick={onClickingSave} className="c25x-button-style">
          Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria25;
