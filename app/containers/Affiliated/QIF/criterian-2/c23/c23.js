import React, { useState } from 'react';
import './c23-style.css';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import { HelpButton } from '../../../../../reusableComponents/model/Help';
import { resources } from '../../../../appConstants';

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

// Help buttons functionality
function Help231(props) {
  return props.isHelp231Clicked ? (
    <div className="c23x-help-mainContainer">
      <div className="c23x-help-subContainer">
        <h1 className="c23x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c23x-help-para-style">
          Student centric methods, such as experiential learning, participative
          learning and problem solving methodologies are used for enhancing
          learning experiences Describe it in maximum 500 words.
        </p>
        <button
          className="c23x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp231Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria23() {
  // state variables
  const [value231t1, setValue231t1] = useState();
  const [pathValue231f1, setPathValue231f1] = useState('');
  const [value231f1, setValue231f1] = useState([]);
  const [pathValue231f2, setPathValue231f2] = useState('');
  const [value231f2, setValue231f2] = useState([]);

  const [responseValue231, setResponseValue231] = useState('');
  const [help231Status, setHelp231Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');



  // this is help button
const [isOpen, setIsopen] = useState(false)
const handleHelpOpen = (e) => {
e.preventDefault(),
setIsopen(true)
}
const handleHelpClose = () => {
setIsopen(false)
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
    criteria23Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
        uniqueKey1:101,
      input231t1: value231t1,
      response231: responseValue231,
      criteria23status:"save"
    },  
    ],
    };
   
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form23Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form23Data.append('criteria2Fieldinfo', jsonBlob(inputDataList));
    if (pathValue231f1 !== '') {
      form23Data.append('uploadfile2', value231f1, 'f231f1-' + value231f1.name);
    }
    if (pathValue231f2 !== '') {
      form23Data.append('uploadfile2', value231f2, 'f231f2-' + value231f2.name);
    }
   
    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form23Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria2upload",
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
  // rendering DOM
  return (
    <div className="c23-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c23x-colorIndicator-container">
        <p className="c23x-QlcolorIndicator-circle-style"></p>
        <span className="c23x-colorIndicator-span-style">Qualitative</span>
        <p className="c23x-QtcolorIndicator-circle-style"></p>
        <span className="c23x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c23x-weightage-heading-style">
            Key Indicator Weightage: 40
          </h1>
        </div>
      </div>

      {/* Key Indicator: 2.3.1 */}
      <div className="c23x-eachInputField-container">
        <div className="c23x-weightage-container">
          <h1 className="c23x-weightage-heading-style">Weightage: 40</h1>
        </div>
        <form>
          <div className="c23x-Ql-label-textarea-container">
            <div className="c23x-heading_Help-container">
              <h1 className="c23x-heading-style">
                <span className="c23x-span-style">2.3.1: </span>
                Student centric methods, such as experiential learning,
                participative learning and problem solving methodologies are
                used for enhancing learning experiences using ICT tools
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c23x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
              isOpen={isOpen}
              handleClose={handleHelpClose}
              title='Write description in a maximum of 500 words'>
              </HelpButton>
            </div>
            <label htmlFor="231-t1" className="c23x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue231t1(e.target.value);
                setResponseValue231(e.target.value);
              }}
              value={value231t1}
              rows={10}
              className="c23x-textarea-style"
              id="231-t1"
            ></textarea>
            {value231t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c23x-Ql-table-style">
            <tr>
              <th className="c23x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c23x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c23x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c23x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c23x-Ql-tableBorders-style">
                Any additional information
              </td>
              <td className="c23x-Ql-tableBorders-style"></td>
              <td className="c23x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue231f1(e.target.files[0]);
                    setPathValue231f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="231-f1"
                  className="c23-fileButton-style"
                  type="file"
                />
                {pathValue231f1 === '' ? null : (
                  <div className="c23-fileButtons-container">
                    <button className="c23-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue231f1("");
                      document.getElementById("231-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c23x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c23x-Ql-tableBorders-style">
                Link for additional information
              </td>
              <td className="c23x-Ql-tableBorders-style"></td>
              <td className="c23x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue231f2(e.target.files[0]);
                    setPathValue231f2(e.target.value);
                  }}
                  id="231-f2"
                  className="c23-fileButton-style"
                  type="file"
                />
                {pathValue231f2 === '' ? null : (
                  <div className="c23-fileButtons-container">
                    <button className="c23-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue231f2("");
                      document.getElementById("231-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                
              </td>
              <td className="c23x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>


      <div className="c23x-button-container">
        <button onClick={onClickingSave} className="c23x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria23;
