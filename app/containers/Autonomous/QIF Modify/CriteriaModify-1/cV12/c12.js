import React, { useState, useEffect } from 'react';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import { HelpButton } from "../../../../../reusableComponents/model/Help";
import { resources } from "../../../../appConstants";

import "./c12-style.css";
import { Button } from '@mui/material';

// Alert custom messages start
const successMessage = (message) => {
  toast.success(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "success1",
  });
};
const errorMessage = (message) => {
  toast.error(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "error1",
  });
};
// End here

// Help buttons functionality
function Help121(props) {
  return props.isHelp121Clicked ? (
    <div className="c12x-help-mainContainer">
      <div className="c12x-help-subContainer">
        <h1 className="c12x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c12x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>new courses are
          introduced within the last five years
          <span style={{ fontWeight: 'bold' }}>) /</span>
          <span style={{ fontWeight: 'bold' }}>(</span> Total Number of courses
          offered during the last five years
          <span style={{ fontWeight: 'bold' }}>) /</span>*100
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
          <span style={{ fontWeight: 'bold' }}>(</span>Number of Programmes in
          which CBCS / Elective course system implemented
          <span style={{ fontWeight: 'bold' }}>) /</span>
          <span style={{ fontWeight: 'bold' }}>(</span> Number of courses
          offered by the institution across all programmes during the last five
          years
          <span style={{ fontWeight: 'bold' }}>) /</span>*100
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
   // getfile data with API
   function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
 //help buttom
  const [isOpen, setIsopen] = useState(false)
  const [isOpen2,setIsopen2] = useState(false)
  const handleHelpOpen = (e) => {
    e.preventDefault(),
    setIsopen(true)
  }
  const handleHelpClose = () => {
    setIsopen(false)
  }
  const handleHelpOpen2 =(e)=>{
    e.preventDefault();
    setIsopen2(true)
  } 
  const handleHelpClose2 = (e)=>{
    setIsopen2(false)
  }
  // state variables;

  const [value1211t1, setValue1211t1] = useState([]);
  const [value1212t1, setValue1212t1] = useState([]);

  const [pathValue1212f1, setPathValue1212f1] = useState('');
  const [pathValue1212f2, setPathValue1212f2] = useState('');
  const [pathValue1212f3, setPathValue1212f3] = useState('');

  const [value1212f1, setValue1212f1] = useState([]);
  const [value1212f2, setValue1212f2] = useState([]);
  const [value1212f3, setValue1212f3] = useState([]);

  const [value122t1, setValue122t1] = useState("");
  const [value1221t1, setValue1221t1] = useState("");

  const [pathValue1221f1, setPathValue1221f1] = useState('');
  const [pathValue1221f2, setPathValue1221f2] = useState('');
  const [pathValue1221f3, setPathValue1221f3] = useState('');

  const [value1221f1, setValue1221f1] = useState([]);
  const [value1221f2, setValue1221f2] = useState([]);
  const [value1221f3, setValue1221f3] = useState([]);

  const [responseButtonStatus121, setResponseButtonStatus121] = useState(false);
  const [responseButtonStatus122, setResponseButtonStatus122] = useState(false);
  const [responseValue121, setResponseValue121] = useState('');
  const [responseValue122, setResponseValue122] = useState('');
  const [help121Status, setHelp121Status] = useState(false);
  const [help122Status, setHelp122Status] = useState(false);


  const financialYear = "2021-2022";
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
  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria1getallfiles?collegeId='+collegeId+'&financialYear=' +
          fYear +
          '&typeofInstitution='+instituteType
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            setValue1211t1(
              data[0].criteria12Qn[0] ? data[0].criteria12Qn[0].input1211t1 : ""
            );
            setValue1212t1(
              data[0].criteria12Qn[0] ? data[0].criteria12Qn[0].input1212t1 : ""
            );
            setValue1221t1(
              data[0].criteria12Qn[0] ? data[0].criteria12Qn[0].input1221t1 : ""
            );
            setValue1221t1(
              data[0].criteria12Qn[0] ? data[0].criteria12Qn[0].input1221t2 : ""
            );
            setResponseValue121(
              data[0].criteria12Qn[0] ? data[0].criteria12Qn[0].response121 : ""
            );
            setResponseValue122(
              data[0].criteria12Qn[0] ? data[0].criteria12Qn[0].response122 : ""
            );
            console.log("getting");
          })
          .catch((error) => {
            console.error("Error:", error);
            errorMessage("Got the Error Please try after sometime");
          })
      ),
    []
  );


  

  // response button functionality
  function onClickingViewResponse121() {
    if (value1211t1 === '' || value1212t1 === '') {
      setResponseValue121('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value1211t1, 10)) === false
      || Number.isInteger(parseInt(value1212t1, 10)) === false
    ) {
      setResponseValue121('Input should be an Integer');
    } else if (value1211t1 !== '' && value1212t1 !== '') {
      setResponseValue121(
        (parseInt(value1211t1, 10) / parseInt(value1212t1, 10)) * 100
      );
    }
  }

  function onClickingViewResponse122() {
    if (value122t1 === '' || value1221t1 === '') {
      setResponseValue122('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value122t1, 10)) === false
      || Number.isInteger(parseInt(value1221t1, 10)) === false
    ) {
      setResponseValue122('Input should be an Integer');
    } else if (value122t1 !== '' && value1221t1 !== '') {
      setResponseValue122(
        (parseInt(value122t1, 10) / parseInt(value1221t1, 10)) * 100
      );
    }
  }


  // sending data to db with API

  const inputDataList = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    // criteria1FieldInfoQl: [],

    criteria12Qn: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input1211t1: value1211t1,
        input1212t1: value1212t1,
        input1221t1: value122t1,
        input1221t2: value1221t1,
        response121: responseValue121,
        response122: responseValue122,
        criteria12status: "save",
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingModify() {
    const form12Data = new FormData();
    console.log("inputDataList 12 =>" + JSON.stringify(inputDataList));
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
    if (pathValue1212f3 !== "") {
      form12Data.append(
        "uploadfile1",
        value1212f3,
        "f1212f3-" + value1212f3.name
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
    if (pathValue1221f3 !== "") {
      form12Data.append(
        "uploadfile1",
        value1221f3,
        "f1221f3-" + value1221f3.name
      );
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form12Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria1upload",
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
  
   // getfile data with API

   function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
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
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c12x-weightage-heading-style">
            Key Indicator Weightage: 40
          </h1>
        </div>
      </div>

      {/* Key Indicator: 1.2.1 */}
      <div className="c12x-eachInputField-container">
        <div className="c12x-weightage-container">
          <h1 className="c12x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c12x-container">
            <div className="c12x-heading_Help-container">
              <h1 className="c12x-heading-style">
                <span className="c12x-span-style">1.2.1: </span>
                Percentage of new courses introduced out of the total number of
courses across all programmes offered during the last five years
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='formula'
                ><h1> (Number of new courses introduced during the last five years /  Number of courses offered during the last five years) * 100</h1></HelpButton>
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
              How many new courses are introduced within the last five years
            </span>
            </h1>
            <h1 className="c12xx-Heading-style">
              <span className="c12xx-span-style">1.2.1.2: </span>
              Number of courses offered by the institution across all programmes
              during the last five years.
            </h1>
        
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
                <td>? Institutional data in the prescribed format (data template)
</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue1212f1(e.target.files[0]);
                      setPathValue1212f1(e.target.value);
                    }}
                    id="1212-f1"
                    type="file"
                    className="c12-fileButton-style"
                  />
                  {pathValue1212f1 === '' ? null : (
                    <div className="c12-fileButtons-container">
                      <button className="c12-viewFileButton-style">
                        View File
                      </button>

                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue1212f1("");
                      document.getElementById("1212-f1").value="" }} >
                       Reset
                    </button>


                    </div>
                  )}
                  <a href={downloadFile(value1212f1)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                 <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="1212-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue1212f1(e.target.files[0]);
                    setPathValue1212f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue1212f1}
              {pathValue1212f1 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue1212f1("");
                      document.getElementById("1212-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c12x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Minutes of Board of Studies meeting clearly specifying the
syllabus approval of new courses</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue1212f2(e.target.files[0]);
                      setPathValue1212f2(e.target.value);
                    }}
                    id="1212-f2"
                    type="file"
                    className="c12-fileButton-style"
                  />
                  {pathValue1212f2 === '' ? null : (
                    <div className="c12-fileButtons-container">
                      <button className="c12-viewFileButton-style">
                        View File
                      </button>

                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue1212f2("");
                      document.getElementById("1212-f2").value="" }} >
                      Reset
                    </button>

                    </div>
                  )}
                  <a href={downloadFile(value1212f2)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                 <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue1212f2(e.target.files[0]);
                      setPathValue1212f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue1212f2}
              {pathValue1212f2 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue1212f2("");
                      document.getElementById("1212-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c12x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Subsequent Academic Council meeting extracts endorsing the
decision of BOS</td>
                <td>
                <a href={downloadFile("au1.2.1.xlsx")} target="_blank">Template</a>
                </td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue1212f3(e.target.files[0]);
                      setPathValue1212f3(e.target.value);
                    }}
                    id="1212-f3"
                    type="file"
                    className="c12-fileButton-style"
                  />
                  {pathValue1212f3 === '' ? null : (
                    <div className="c12-fileButtons-container">
                      <button className="c12-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue1212f3("");
                      document.getElementById("1212-f3").value="" }} >
                      Reset
                    </button>

                    </div>
                  )}
                  <a href={downloadFile(value1212f3)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                 <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="1212-f3"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue1212f3(e.target.files[0]);
                    setPathValue1212f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue1212f3}
              {pathValue1212f3 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPpathValue1212f3("");
                      document.getElementById("1212-f3").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c12x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      
      <div className="c12x-button-container">
        <button onClick={onClickingModify} className="c12x-button-style">
          Modify
        </button>
      </div>

    </div>
  );
}

export default Criteria12;
