import React, { useState } from 'react';
import './c54-style.css';
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
function Help541(props) {
  return props.isHelp541Clicked ? (
    <div className="c54x-help-mainContainer">
      <div className="c54x-help-subContainer">
        <h1 className="c54x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c54x-help-para-style">
          Describe contribution of alumni association to the institution within
          a maximum of 500 words
        </p>
        <button
          className="c54x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp541Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria54() {
      // /this is Help button 
      const [isOpen, setIsopen] = useState(false)
      const handleHelpOpen = (e) => {
        e.preventDefault(),
        setIsopen(true)
      }
      const handleHelpClose = () => {
        setIsopen(false)
      }
  // state variables
  const [value541t1, setValue541t1] = useState();
  const [value542t1, setValue542t1] = useState();

  const [pathValue541f1, setPathValue541f1] = useState('');
  const [value541f1, setValue541f1] = useState([]);
  const [pathValue541f2, setPathValue541f2] = useState('');
  const [value541f2, setValue541f2] = useState([]);
  const [pathValue542f1, setPathValue542f1] = useState('');
  const [value542f1, setValue542f1] = useState([]);
  const [responseButtonStatus542, setResponseButtonStatus542] = useState(false);
  const [responseValue541, setResponseValue541] = useState('');
  const [responseValue542, setResponseValue542] = useState('');
  const [help541Status, setHelp541Status] = useState(false);
  const [help542Status, setHelp542Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');

  // botton functionalities

  function onClickingViewResponse542() {
    if (value542t1 === "" || value542t1 === undefined || value542t1 === null) {
      setResponseValue542("Please select any option");
    } else {
      setResponseValue542(value542t1);
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
    criteria54Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 101,
      input541t1: value541t1,
      response541: responseValue541,
      criteria54status:"save"
    },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form54Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form54Data.append('criteria5Fieldinfo', jsonBlob(inputDataList));
    if (pathValue541f1 !== '') {
      form54Data.append('uploadfile5', value541f1, 'f541f1-' + value541f1.name);
    }
    if (pathValue541f2 !== '') {
      form54Data.append('uploadfile5', value541f2, 'f541f2-' + value541f2.name);
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form54Data,
    };
    fetch(
      resources.APPLICATION_URL+'criteria5upload',
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
    <div className="c54-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c54x-colorIndicator-container">
        <p className="c54x-QlcolorIndicator-circle-style"></p>
        <span className="c54x-colorIndicator-span-style">Qualitative</span>
        <p className="c54x-QtcolorIndicator-circle-style"></p>
        <span className="c54x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c54x-weightage-heading-style">
            Key Indicator Weightage: 10
          </h1>
        </div>
      </div>

      {/* Key Indicator: 5.4.1 */}
      <div className="c54x-eachInputField-container">
        <div className="c54x-weightage-container">
          <h1 className="c54x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c54x-container">
            <div className="c54x-heading_Help-container">
              <h1 className="c54x-heading-style">
                <span className="c54x-span-style">5.4.1: </span>
                There is a registered Alumni Association that contributes significantly to the development of the institution through 
                financial and/or other support services
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c54x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <label htmlFor="541-t1" className="c54x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue541t1(e.target.value);
                setResponseValue541(e.target.value);
              }}
              value={value541t1}
              rows={10}
              className="c54x-textarea-style"
              id="541-t1"
            ></textarea>
            {value541t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>
          <div className="c54xx-container">
            <table className="c54x-table-style">
              <tr>
                <th className="c54x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c54x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c54x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c54x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Paste link for Additional Information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue541f1(e.target.files[0]);
                      setPathValue541f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="541-f1"
                    type="file"
                    className="c54-fileButton-style"
                  />
                  {pathValue541f1 === '' ? null : (
                    <div className="c54-fileButtons-container">
                      <button className="c54-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue541f1("");
                      document.getElementById("541-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c54x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any Additional Information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue541f2(e.target.files[0]);
                      setPathValue541f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="541-f2"
                    type="file"
                    className="c54-fileButton-style"
                  />
                  {pathValue541f2 === '' ? null : (
                    <div className="c54-fileButtons-container">
                      <button className="c54-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue541f2("");
                      document.getElementById("541-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c54x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      <div className="c54x-button-container">
        <button onClick={onClickingSave} className="c54x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria54;
