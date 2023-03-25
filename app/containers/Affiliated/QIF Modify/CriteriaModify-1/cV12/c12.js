import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import "./c12-style.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../reusableComponents/model/Help";
import { resources } from "../../../../appConstants";

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

// Help buttons functionality
function Help121(props) {
  return props.isHelp121Clicked ? (
    <div className="c12x-help-mainContainer">
      <div className="c12x-help-subContainer">
        <h1 className="c12x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c12x-help-para-style">
          Number of Add on /Certificate /Value added programs offered during the
          last five years.
        </p>
        <button
          className="c12x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp121Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help122(props) {
  return props.isHelp122Clicked ? (
    <div className="c12x-help-mainContainer">
      <div className="c12x-help-subContainer">
        <h1 className="c12x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c12x-help-para-style">
          Percentage
          <span style={{ fontWeight: "bold" }}>=(</span>Total number of students
          enrolled in such programs/during the last five years
          <span style={{ fontWeight: "bold" }}>/</span>
          Total number of students during the last five years
          <span style={{ fontWeight: "bold" }}>)*</span>*100
        </p>
        <button
          className="c12x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp122Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria12() {
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
    // getfile data with API
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
  // state variables;

  const [value1211t1, setValue1211t1] = useState();
  const [value1212t1, setValue1212t1] = useState();

  const [pathValue1212f1, setPathValue1212f1] = useState("");
  const [pathValue1212f2, setPathValue1212f2] = useState("");

  const [value1212f1, setValue1212f1] = useState([]);
  const [value1212f2, setValue1212f2] = useState([]);

  const [value1221t1, setValue1221t1] = useState();
  const [value1221t2, setValue1221t2] = useState();
  const [value1221t3, setValue1221t3] = useState();
  const [value1221t4, setValue1221t4] = useState();
  const [value1221t5, setValue1221t5] = useState();
  const [value1221t6, setValue1221t6] = useState();
  const [value1221t7, setValue1221t7] = useState();
  const [value1221t8, setValue1221t8] = useState();
  const [value1221t9, setValue1221t9] = useState();
  const [value1221t10, setValue1221t10] = useState();

  const [pathValue1221f1, setPathValue1221f1] = useState("");
  const [pathValue1221f2, setPathValue1221f2] = useState("");
  const [value1221f1, setValue1221f1] = useState([]);
  const [value1221f2, setValue1221f2] = useState([]);

  const [responseButtonStatus121, setResponseButtonStatus121] = useState(false);
  const [responseButtonStatus122, setResponseButtonStatus122] = useState(false);
  const [responseValue121, setResponseValue121] = useState("");
  const [responseValue122, setResponseValue122] = useState("");
  const [help121Status, setHelp121Status] = useState(false);
  const [help122Status, setHelp122Status] = useState(false);
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
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }
  
  useEffect(
    () => fetch('resources.APPLICATION_URL+criteria1getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));
          
          setValue1211t1(data[0].criteria12Qn[0]?data[0].criteria12Qn[0].input1211t1:"");
          setValue1212t1(data[0].criteria12Qn[0]?data[0].criteria12Qn[0].input1212t1:"");

          setValue1221t1(data[0].affiliatedYearTable1221[0]?data[0].affiliatedYearTable1221[0].input1221y:"");
          setValue1221t2(data[0].affiliatedYearTable1221[1]?data[0].affiliatedYearTable1221[1].input1221y:"");
          setValue1221t3(data[0].affiliatedYearTable1221[2]?data[0].affiliatedYearTable1221[2].input1221y:"");
          setValue1221t4(data[0].affiliatedYearTable1221[3]?data[0].affiliatedYearTable1221[3].input1221y:"");
          setValue1221t5(data[0].affiliatedYearTable1221[4]?data[0].affiliatedYearTable1221[4].input1221y:"");
          setValue1221t6(data[0].affiliatedYearTable1221[0]?data[0].affiliatedYearTable1221[0].input1221v:"");
          setValue1221t7(data[0].affiliatedYearTable1221[1]?data[0].affiliatedYearTable1221[1].input1221v:"");
          setValue1221t8(data[0].affiliatedYearTable1221[2]?data[0].affiliatedYearTable1221[2].input1221v:"");
          setValue1221t9(data[0].affiliatedYearTable1221[3]?data[0].affiliatedYearTable1221[3].input1221v:"");
          setValue1221t10(data[0].affiliatedYearTable1221[4]?data[0].affiliatedYearTable1221[4].input1221v:"");

          setValue1212f1(data[0].criteria1FileUpload[0]?data[0].criteria1FileUpload[0].criteria1FileName:"");
          setValue1212f2(data[0].criteria1FileUpload[1]?data[0].criteria1FileUpload[1].criteria1FileName:"");
          setValue1221f1(data[0].criteria1FileUpload[2]?data[0].criteria1FileUpload[2].criteria1FileName:"");
          setValue1221f2(data[0].criteria1FileUpload[3]?data[0].criteria1FileUpload[3].criteria1FileName:"");
          
          // setResponseValue111(daValue11ta[0].criteria1FieldInfoQl[1].response111);
         
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ),
    []
  );



 

   // sending data to db with API
  
   const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},    // criteria1FieldInfoQl: [],
    criteria12Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},
        uniqueKey1: 101,
        input1211t1: value1211t1,
        input1212t1: value1212t1,
        response121: responseValue121,
        response122: responseValue122,
        criteria12status:"save"
      },
    ],
    affiliatedYearTable1221: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},       
         uniqueKey1: 101,
         input1221y: value1221t1, input1221v: value1221t6 },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
        uniqueKey1: 102,
         input1221y: value1221t2, input1221v: value1221t7 },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
        uniqueKey1: 103,
         input1221y: value1221t3, input1221v: value1221t8 },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},        
        uniqueKey1: 104,
         input1221y: value1221t4, input1221v: value1221t9 },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},       
         uniqueKey1: 105,
         input1221y: value1221t5, input1221v: value1221t10 },

    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form12Data = new FormData();
    

    form12Data.append("criteria1Fieldinfo", jsonBlob(inputDataList));
    if (pathValue1212f1 !== "") {
      form12Data.append(
        "uploadfile1",
        value1212f1,
        "f1212f1-" + value1212f1.name
      );
    }
    if (pathValue1212f2 !== "") {
      form12Data.append(
        "uploadfile1",
        value1212f2,
        "f1212f2-" + value1212f2.name
      );
    }
    if (pathValue1221f1 !== "") {
      form12Data.append(
        "uploadfile1",
        value1221f1,
        "f1221f1-" + value1221f1.name
      );
    }
    if (pathValue1221f2 !== "") {
      form12Data.append(
        "uploadfile1",
        value1221f2,
        "f1221f2-" + value1221f2.name
      );
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form12Data,
    }
    fetch(
      resources.APPLICATION_URL+"criteria1upload",
      filesFetchMethod
      ).then((response) => 
      {
        console.log(response); 
        if (response.ok) {
          successMessage("Record is Inserted Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      })
     
    
    };

    //
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

  function onClickingViewResponse121() {
    if (value1211t1 === "" || value1212t1 === "") {
      setResponseValue121("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value1211t1, 10)) === false
      || Number.isInteger(parseInt(value1212t1, 10)) === false
    ) {
      setResponseValue121("Input should be an Integer");
    } else if (value1211t1 !== "" && value1212t1 !== "") {
      setResponseValue121(
        (parseInt(value1211t1, 10) / parseInt(value1212t1, 10)) * 100
      );
    }
  }
  
  function onClickingViewResponse122() {
    if (
      value1221t6 === ""
      || value1221t7 === ""
      || value1221t8 === ""
      || value1221t9 === ""
      || value1221t10 === ""
      || value1221t6 === undefined
      || value1221t7 === undefined
      || value1221t8 === undefined
      || value1221t9 === undefined
      || value1221t10 === undefined
    ) {
      setResponseValue122("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value1221t6, 10)) === false
      || Number.isInteger(parseInt(value1221t7, 10)) === false
      || Number.isInteger(parseInt(value1221t8, 10)) === false
      || Number.isInteger(parseInt(value1221t9, 10)) === false
      || Number.isInteger(parseInt(value1221t10, 10)) === false
    ) {
      setResponseValue122("Input should be an Integer");
    } else if (
      value1221t6 !== ""
      && value1221t7 !== ""
      && value1221t8 !== ""
      && value1221t9 !== ""
      && value1221t10 !== ""
    ) {
      setResponseValue122(
        parseInt(value1221t6, 10)
          + parseInt(value1221t7, 10)
          + parseInt(value1221t8, 10)
          + parseInt(value1221t9, 10)
          + parseInt(value1221t10, 10)
      );
    }
  }

  // rendering DOM
  return (
    <div className="c12-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c12x-colorIndicator-container">
        <p className="c12x-QlcolorIndicator-circle-style"></p>
        <span className="c12x-colorIndicator-span-style">Qualitative</span>
        <p className="c12x-QtcolorIndicator-circle-style"></p>
        <span className="c12x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c12x-weightage-heading-style">
            Key Indicator Weightage: 30
          </h1>
        </div>
      </div>

      {/* Key Indicator: 1.2.1 */}
      <div className="c12x-eachInputField-container">
        <div className="c12x-weightage-container">
          <h1 className="c12x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c12x-container">
            <div className="c12x-heading_Help-container">
              <h1 className="c12x-heading-style">
                <span className="c12x-span-style">1.2.1: </span>
                Number of Add on /Certificate/Value added programs offered during 
                 the last five years
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c12x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='file description'
                ></HelpButton>
            </div>
            <div className="c12x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus121(!responseButtonStatus121);
                  onClickingViewResponse121();
                }}
                className="c12x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus121 ? (
                <p className="c12x-responseResult-style">{responseValue121}</p>
              ) : null}
            </div>
          </div>
          <div className="c12xx-container">
            <h1 className="c12xx-Heading-style">
              <span className="c12xx-span-style">1.2.1.1: 
              1.2.1.1: Number of Add on /Certificate /Value added programs offered
           and online MOOC programs like SWAYAM, NPTEL etc. during the 
               last five years:
            {/* <input
              value={value1211t1}
              onChange={(e) => setValue1211t1(e.target.value)}
              id="1211-t1"
              style={{ width:"20%", marginLeft: "16.5%" }}
              type="number"
            /> */}
            </span>
            </h1>
            {/* <h1 className="c12xx-Heading-style">
              <span className="c12xx-span-style">1.2.1.2: 
              Number of Add on /Certificate /Value added programs offered
             during the last five years.
             <input
              value={value1212t1}
              onChange={(e) => setValue1212t1(e.target.value)}
              id="1212-t1"
              style={{ width:"20%" , marginLeft: "80%" }}
              type="number"
              />
             </span>
             </h1> */}
            <table className="c12x-table-style">
              <tr>
                <th className="c12x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c12x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c12x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c12x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Minutes of relevant Academic Council/BOS meetings</td>
                <td></td>
                <td>
                <input
                  onChange={(e) => {
                    setValue1212f1(e.target.files[0]);
                    setPathValue1212f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="1212-f1"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue1212f1 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue1212f1("");
                      document.getElementById("1212-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              {/* <a href={downloadFile(value1212f1)} target="_blank">View File</a> */}
                
                </td>
                <td className="c12x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                <input
                  onChange={(e) => {
                    setValue1212f2(e.target.files[0]);
                    setPathValue1212f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="1212-f2"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue1212f2 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue1212f2("");
                      document.getElementById("1212-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              {/* <a href={downloadFile(value1212f2)} target="_blank">View File</a> */}
                
                </td>
                <td className="c12x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 1.2.2 */}
      <div className="c12x-eachInputField-container">
        <div className="c12x-weightage-container">
          <h1 className="c12x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c12x-container">
            <div className="c12x-heading_Help-container">
              <h1 className="c12x-heading-style">
                <span className="c12x-span-style">1.2.2: </span>
                Percentage of students enrolled in Certificate/ Add-on/Value added 
           programs as against the total number of students during the last five 
years
              </h1>
              <button
                onClick={handleHelpOpen2}
                className="c12x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen2}
                handleClose={handleHelpClose2}
                title='perrcentage ='
                > 
                <h1>(Total number of students enrolled in such programs/during the last five years / Total number of students during the last five years) * 100</h1></HelpButton>
            </div>
            <div className="c12x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus122(!responseButtonStatus122);
                  onClickingViewResponse122();
                }}
                className="c12x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus122 ? (
                <p className="c12x-responseResult-style">{responseValue122}</p>
              ) : null}
            </div>
          </div>
          <div className="c12xx-container">
            <h1 className="c12xx-Heading-style">
              <span className="c12xx-span-style">1.2.2.1: </span>
              Number of students enrolled in subject related Certificate/
 Add-on/Value added programs year wise during last five years

            </h1>
            <table className="c12x-Qt-table-style">
              <tr>
                <th className="c12x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => setValue1221t1(e.target.value)}
                      id="1221-t1"
                      className="c12x-input-style"
                      type="text"
                      value={value1221t1}
                    />
                    {value1221t1 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => setValue1221t2(e.target.value)}
                      id="1221-t2"
                      className="c12x-input-style"
                      type="text"
                      value={value1221t2}
                    />
                    {value1221t2 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => setValue1221t3(e.target.value)}
                      id="1221-t3"
                      className="c12x-input-style"
                      type="text"
                      value={value1221t3}
                    />
                    {value1221t3 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => setValue1221t4(e.target.value)}
                      id="1221-t4"
                      className="c12x-input-style"
                      type="text"
                      value={value1221t4}
                    />
                    {value1221t4 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => setValue1221t5(e.target.value)}
                      id="1221-t5"
                      className="c12x-input-style"
                      type="text"
                      value={value1221t5}
                    />
                    {value1221t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c12x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue1221t6(e.target.value);
                        onClickingViewResponse122();
                      }}
                      id="1221-t6"
                      className="c12x-input-style"
                      type="text"
                      value={value1221t6}
                    />
                    {value1221t6 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue1221t7(e.target.value);
                        onClickingViewResponse122();
                      }}
                      id="1221-t7"
                      className="c12x-input-style"
                      type="text"
                      value={value1221t7}
                    />
                    {value1221t7 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue1221t8(e.target.value);
                        onClickingViewResponse122();
                      }}
                      id="1221-t8"
                      className="c12x-input-style"
                      type="text"
                      value={value1221t8}
                    />
                    {value1221t8 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue1221t9(e.target.value);
                        onClickingViewResponse122();
                      }}
                      id="1221-t9"
                      className="c12x-input-style"
                      type="text"
                      value={value1221t9}
                    />
                    {value1221t9 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue1221t10(e.target.value);
                        onClickingViewResponse122();
                      }}
                      id="1221-t10"
                      className="c12x-input-style"
                      type="text"
                      value={value1221t10}
                    />
                    {value1221t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <table className="c12x-table-style">
              <tr>
                <th className="c12x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c12x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c12x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c12x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
              <td>Institutional data in prescribed format</td>
                <td>
                <a href={downloadFile("af1.2.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                <input
                  onChange={(e) => {
                    setValue1221f1(e.target.files[0]);
                    setPathValue1221f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="1221-f1"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue1221f1 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue1221f1("");
                      document.getElementById("1221-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              {/* <a href={downloadFile(value1221f1)} target="_blank">View File</a> */}
                
                </td>
                <td className="c12x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload supported document</td>
                <td> </td>
                <td>
                <input
                  onChange={(e) => {
                    setValue1221f2(e.target.files[0]);
                    setPathValue1221f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="1221-f2"
                  type="file"
                  className="c62-fileButton-style"
                />
                {pathValue1221f2 === '' ? null : (
                  <div className="c62-fileButtons-container">
                    <button className="c62-viewFileButton-style">
                     <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue1221f2("");
                      document.getElementById("1221-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
              {/* <a href={downloadFile(value1221f2)} target="_blank">View File</a> */}
                
                </td>
                <td className="c12x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
      
      <div className="c12x-button-container">
        <button onClick={onClickingSave} className="c12x-button-style">
          Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria12;
