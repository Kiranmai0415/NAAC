import React, { useState, useEffect } from "react";
import "./c14-style.css";
import { toast } from "react-toastify";
import AuthService from "../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../reusableComponents/model/Help";
import { resources } from "../../../../appConstants";
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
function Help141(props) {
  return props.isHelp141Clicked ? (
    <div className="c14x-help-mainContainer">
      <div className="c14x-help-subContainer">
        <h1 className="c14x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c14x-help-para-style">
        Write description in a maximum of 500 words.
        </p>
        <button
          className="c14x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp141Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
 }

// Promotion of Research and Facilities
function Criteria14() {
  //this is help button
  const [isOpen, setIsopen] = useState(false)
  const handleHelpOpen = (e) => {
    e.preventDefault(),
    setIsopen(true)
  }
  const handleHelpClose = () => {
    setIsopen(false)
  }
  // state variables
  const [value141t1, setValue141t1] = useState();
  const [pathValue141f1, setPathValue141f1] = useState('');
  const [value141f1, setValue141f1] = useState([]);
  const [responseValue141, setResponseValue141] = useState('');
 
  const [help141Status, setHelp141Status] = useState(false);
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
    uniqueKey1: 101,
        criteria14Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    uniqueKey1: 101,
         input141t1: value141t1,
        response141: responseValue141,
        criteria14status:"save" 
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    console.log(value141t1);
    const form11Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form11Data.append('criteria1Fieldinfo', jsonBlob(inputDataList));
    if (pathValue141f1 !== '') {
      form11Data.append('uploadfile1', value141f1, 'f141f1-' + value141f1.name);
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form11Data,
    };
    fetch(
      resources.APPLICATION_URL+'criteria1upload',
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

  // remove file functionality

  const ref = React.useRef();
  function removeAll(e) {
    e.preventDefault();
    e.target.value = null;
    setValue111f1([]);
    setPathValue111f1('');
    ref.current.value = '';
    console.log('working');
    //  $(".c11-fileButton-style").value=""
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
    <div className="c14-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c14x-colorIndicator-container">
        <p className="c14x-QlcolorIndicator-circle-style"></p>
        <span className="c14x-colorIndicator-span-style">Qualitative</span>
        <p className="c14x-QtcolorIndicator-circle-style"></p>
        <span className="c14x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c14x-weightage-heading-style">
            Key Indicator Weightage: 20
          </h1>
        </div>
      </div>

      {/* Key Indicator: 1.4.1 */}
      <div className="c14x-eachInputField-container">
        <div className="c14x-weightage-container">
          <h1 className="c14x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c14x-Ql-label-textarea-container">
            <div className="c14x-heading_Help-container">
              <h1 className="c14x-heading-style">
                <span className="c14x-span-style">1.4.1: </span>
                Institution obtains feedback on the academic performance and 
ambience of the institution from various stakeholders, such as 
Students, Teachers, Employers, Alumni etc. and action taken report on 
the feedback is made available on institutional website (Yes or No)
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
            <label htmlFor="141-t1" className="c14x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue141t1(e.target.value);
                setResponseValue141(e.target.value);
              }}
              value={value141t1}
              rows={10}
              className="c14x-textarea-style"
              id="141-t1"
            ></textarea>
            {value141t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c14x-Ql-table-style">
            <tr>
              <th className="c14x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c14x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c14x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c14x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c14x-Ql-tableBorders-style">
              • Upload supporting document
              </td>
              <td className="c14x-Ql-tableBorders-style"></td>
              <td className="c14x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue141f1(e.target.files[0]);
                    setPathValue141f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="141-f1"
                  type="file"
                  ref={ref}
                  className="c14-fileButton-style"
                />
                {pathValue141f1 === '' ? null : (
                  <div className="c14-fileButtons-container">
                    <button className="c14-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue141f1("");
                      document.getElementById("141-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              </td>
              <td className="c14x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      <div className="c14x-button-container">
        <button onClick={onClickingSave} className="c14x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria14;
