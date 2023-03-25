import React, { useState } from 'react';
import './c64-style.css';
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
function Help641(props) {
  return props.isHelp641Clicked ? (
    <div className="c64x-help-mainContainer">
      <div className="c64x-help-subContainer">
        <h1 className="c64x-help-heading-style">
        Institution conducts internal and external financial audits regularly
        </h1>
        <p className="c64x-help-para-style">
          Enumerate the  various internal and extenal financial audits carried out during the last five years with the mechanism for settling audit objections within a maximum of 500 words.
        </p>
        <button
          className="c64x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp641Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria64() {
  // help button
  const [isOpen, setIsopen] = useState(false)
  const handleHelpOpen = (e) => {
    e.preventDefault(),
    setIsopen(true)
  }
  const handleHelpClose = () => {
    setIsopen(false)
  }
  // state variables
  const [value641t1, setValue641t1] = useState();

  const [value641f1, setValue641f1] = useState();
  const [pathValue641f1, setPathValue641f1] = useState('');
  const [value641f2, setValue641f2] = useState();
  const [pathValue641f2, setPathValue641f2] = useState('');
  const [responseValue641, setResponseValue641] = useState('');
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');
  const [help641Status, setHelp641Status] = useState(false);


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
    criteria64Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 4,
      
      criteria64status:"save"
    },
    ],

    criteria64Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 4,
      input641t1: value641t1,
      response641: responseValue641,
      
    },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form64Data = new FormData();

    form64Data.append('criteria6Fieldinfo', jsonBlob(inputDataList));
    if (pathValue641f1 !== '') {
      form64Data.append('uploadfile6', value641f1, 'f641f1-' + value641f1.name);
    }
    if (pathValue641f2 !== '') {
      form64Data.append('uploadfile6', value641f2, 'f641f2-' + value641f2.name);
    }
console.log(JSON.stringify(inputDataList));
    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form64Data,
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
    <div className="c64-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c64x-colorIndicator-container">
        <p className="c64x-QlcolorIndicator-circle-style"></p>
        <span className="c64x-colorIndicator-span-style">Qualitative</span>
        <p className="c64x-QtcolorIndicator-circle-style"></p>
        <span className="c64x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c64x-weightage-heading-style">
            Key Indicator Weightage: 10
          </h1>
        </div>
      </div>

      {/* Key Indicator: 6.4.1 */}
      <div className="c64x-eachInputField-container">
        <div className="c64x-weightage-container">
          <h1 className="c64x-weightage-heading-style">Weightage:15</h1>
        </div>
        <form>
          <div className="c64x-Ql-label-textarea-container">
            <div className="c64x-heading_Help-container">
              <h1 className="c64x-heading-style">
                <span className="c64x-span-style">6.4.1: </span>
                Institution has strategies for mobilization and optimal utilization of resources and funds from various 
                sources (government/ non-government organizations) and it conducts financial audits regularly (internal and external)
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c14x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
              isOpen={isOpen}
              handleClose={handleHelpClose}
              title='Write description in a maximum of 500 words'></HelpButton>
            </div>
            <label htmlFor="641-t1" className="c41x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue641t1(e.target.value);
                setResponseValue641(e.target.value);
              }}
              value={value641t1}
              rows={10}
              className="c64x-textarea-style"
              id="641-t1"
            ></textarea>
            {value641t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c64x-Ql-table-style">
            <tr>
              <th className="c64x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c64x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c64x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c64x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c64x-Ql-tableBorders-style">
                Strategic Plan and deployment documents on the website
              </td>
              <td className="c64x-Ql-tableBorders-style"></td>
              <td className="c64x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue641f1(e.target.files[0]);
                    setPathValue641f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="641-f1"
                  type="file"
                  className="c64-fileButton-style"
                />
                {pathValue641f1 === '' ? null : (
                  <div className="c64-fileButtons-container">
                    <button className="c64-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue641f1("");
                      document.getElementById("641-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c64x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c64x-Ql-tableBorders-style">
                Paste link for additional Information
              </td>
              <td className="c64x-Ql-tableBorders-style"></td>
              <td className="c64x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue641f2(e.target.files[0]);
                    setPathValue641f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="641-f2"
                  type="file"
                  className="c64-fileButton-style"
                />
                {pathValue641f2 === '' ? null : (
                  <div className="c64-fileButtons-container">
                    <button className="c64-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue641f2("");
                      document.getElementById("641-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c64x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      <div className="c64x-button-container">
        <button className="c64x-button-style" onClick={onClickingSave}>Save</button>
      </div>
    </div>
  );
}

export default Criteria64;
