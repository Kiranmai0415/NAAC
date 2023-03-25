import React, { useState,useEffect } from "react";
import { toast } from "react-toastify";
import "./c22-style.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../reusableComponents/model/Help";
import { resources } from "../../../../appConstants";
// Help buttons functionality
function Help221(props) {
  return props.isHelp221Clicked ? (
    <div className="c22x-help-mainContainer">
      <div className="c22x-help-subContainer">
        <h1 className="c22x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c22x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span> Total number of students
          enrolled in the institution
          <span style={{ fontWeight: "bold" }}> : </span> Total number of full
          time teachers in the institution
          <span style={{ fontWeight: "bold" }}>)</span>
        </p>
        <button
          className="c22x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp221Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria22() {
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
  const [value221t1, setValue221t1] = useState('');
  const [value221t2, setValue221t2] = useState('');
  const [pathValue221f1, setPathValue221f1] = useState("");
  const [value221f1, setValue221f1] = useState([]);
  const [responseButtonStatus221, setResponseButtonStatus221] = useState(false);
  const [responseValue221, setResponseValue221] = useState("");
  const [help221Status, setHelp221Status] = useState(false);
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
            setValue221t1(data[0].criteria22Qn[0]?data[0].criteria22Qn[0].input221t1:"");
            setValue221t2(data[0].criteria22Qn[0]?data[0].criteria22Qn[0].input221t2:"");
            setValue221f1(data[0].criteria2FileUpload[0]?data[0].criteria2FileUpload[0].criteria2FileName:"");
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
  criteria22Qn: [
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
      uniqueKey1: 101,
    input221t1: value221t1,
    input221t2: value221t2,
    response221: responseValue221,
    criteria22status:"save"
  },
],
};

function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: "application/json",
  });
}

function onClickingSave() {
  const form22Data = new FormData();

  form22Data.append("criteria2Fieldinfo", jsonBlob(inputDataList));
  if (pathValue221f1 !== "") {
    form22Data.append("uploadfile2", value221f1, "f221f1-" + value221f1.name);
  }

  const filesFetchMethod = {
    method: "POST",
    headers: { Accept: "application/json ,text/plain" },
    authorization:
      "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
    body: form22Data,
  };
  fetch(
    resources.APPLICATION_URL+"criteria2upload",
    filesFetchMethod
  ).then((response) => console.log(response));
}

  // response button functionality

  function onClickingViewResponse221() {
    if (
      value221t1 === "" ||
      value221t2 === "" ||
      value221t1 === undefined ||
      value221t2 === undefined
    ) {
      setResponseValue221("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value221t1, 10)) === false ||
      Number.isInteger(parseInt(value221t2, 10)) === false
    ) {
      setResponseValue222("Input should be an Integer");
    } else if (value221t1 !== "" && value221t2 !== "") {
      setResponseValue221(parseInt(value221t1, 10) / parseInt(value221t2, 10));
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
    <div className="c22-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c22x-colorIndicator-container">
        <p className="c22x-QlcolorIndicator-circle-style"></p>
        <span className="c22x-colorIndicator-span-style">Qualitative</span>
        <p className="c22x-QtcolorIndicator-circle-style"></p>
        <span className="c22x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c22x-weightage-heading-style">
            Key Indicator Weightage: 40
          </h1>
        </div>
      </div>

      {/* Key Indicator: 2.2.1 */}
      <div className="c22x-eachInputField-container">
        <div className="c22x-weightage-container">
          <h1 className="c22x-weightage-heading-style">Weightage:40</h1>
        </div>
        <form>
          <div className="c22x-container">
            <div className="c22x-heading_Help-container">
              <h1 className="c22x-heading-style">
                <span className="c22x-span-style">2.2.1: </span>
                Student - Full time teacher ratio (Data for the latest completed
                academic year)
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c22x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Techer Ratio'
              >
              </HelpButton>
            </div>
            <div className="c22x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus221(!responseButtonStatus221);
                  onClickingViewResponse221();
                }}
                className="c22x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus221 ? (
                <p className="c22x-responseResult-style">{responseValue221}</p>
              ) : null}
            </div>
          </div>
          <div className="c22xx-container">
            {/* <h1 className="c22xx-Heading-style">
              <span className="c22xx-span-style">A.
              Total Number of students enrolled in the institution.
              <input
                onChange={(e) => setValue221t1(e.target.value)}
                id="221-t1"
                style={{ width:"20%", marginLeft: "10%" }}
                type="number"
                value={value221t1}
              />
              </span>
            </h1> */}
            {/* <h1 className="c22xx-Heading-style">
              <span className="c22xx-span-style">B.
              Total number of full time teachers in the institution.
              <input
                onChange={(e) => setValue221t2(e.target.value)}
                id="221-t2"
                style={{  width:"20%", marginLeft: "10.2%" }}
                type="number"
                value={value221t2}
              />
              </span>
            </h1> */}
            <table className="c22x-table-style">
              <tr>
                <th className="c22x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c22x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c22x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c22x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Uplaod any additional information</td>
                <td></td>
                <td>
                <input
                  onChange={(e) => {
                    setValue221f1(e.target.files[0]);
                    setPathValue221f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="221-f1"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue221f1 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue221f1("");
                      document.getElementById("221-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              {/* <a href={downloadFile(value221f1)} target="_blank">View File</a> */}
                
                </td>
                <td className="c22x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
      <div className="c22x-button-container">
        <button onClick={onClickingSave} className="c22x-button-style">
          Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria22;
