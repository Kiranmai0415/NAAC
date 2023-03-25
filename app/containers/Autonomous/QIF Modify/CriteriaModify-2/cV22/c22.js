import React, { useState, useEffect } from 'react';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import './c22-style.css';
  
import { HelpButton } from "../../../../../reusableComponents/model/Help";
import { resources } from "../../../../appConstants";

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
function Help221(props) {
  return props.isHelp221Clicked ? (
    <div className="c22x-help-mainContainer">
      <div className="c22x-help-subContainer">
        <h1 className="c22x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c22x-help-para-style">
          The institution assesses the learning levels of the students and
          organises special Programmes for advanced learners and slow learners
          Describe it in maximum 500 words.
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
function Help222(props) {
  return props.isHelp222Clicked ? (
    <div className="c22x-help-mainContainer">
      <div className="c22x-help-subContainer">
        <h1 className="c22x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c22x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span> Total number of students
          enrolled in the institution
          <span style={{ fontWeight: 'bold' }}> : </span> Total number of full
          time teachers in the institution
          <span style={{ fontWeight: 'bold' }}>)</span>
        </p>
        <button
          className="c22x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp222Clicked(false);
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
  // state variables
  const [value221t1, setValue221t1] = useState();
  const [pathValue221f1, setPathValue221f1] = useState('');
  const [value221f1, setValue221f1] = useState([]);
  const [pathValue221f2, setPathValue221f2] = useState('');
  const [value221f2, setValue221f2] = useState([]);
  const [value222t1, setValue222t1] = useState();
  const [value222t2, setValue222t2] = useState();
  const [pathValue222f1, setPathValue222f1] = useState('');
  const [value222f1, setValue222f1] = useState([]);
  const [responseValue221, setResponseValue221] = useState('');
  const [responseValue222, setResponseValue222] = useState('');
  const [help221Status, setHelp221Status] = useState(false);
  const [help222Status, setHelp222Status] = useState(false);
  const [responseButtonStatus222, setResponseButtonStatus222] = useState(false);

   // GET DATA
   const financialYear="2021-2022";

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
     () => fetch(resources.APPLICATION_URL+'criteria2getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
       (response) => response
         .json()
         .then((data) => {
           console.log("21 data is =>" + JSON.stringify(data));
           setValue221t1(data[0].criteria22Qn[0] ? data[0].criteria22Qn[0].input221t1 : "");

           setValue222t1(data[0].criteria22Qn[0] ? data[0].criteria22Qn[0].input222t1 : "");
           setValue222t2(data[0].criteria22Qn[0] ? data[0].criteria22Qn[0].input222t2 : "");
 
           setPathValue221f1(
             data[0].criteria2FileUpload[0] ? data[0].criteria2FileUpload[0].criteria2FileName : ""
           );
           setPathValue221f2(
             data[0].criteria2FileUpload[1] ? data[0].criteria2FileUpload[1].criteria2FileName : ""
           );
         })
         .catch((error) => {
           console.error("Error:", error);
         })
     ),
     []
     );
     // getfile data with API
    
     function downloadFile(fileName) {
      const filePath = "http://localhost:8080/api/v1/download/" + fileName;
      return filePath;
    }

  // response button functionality

  function onClickingViewResponse222() {
    if (value222t1 === '' || value222t2 === '' || value222t1 === undefined || value222t2 === undefined) {
      setResponseValue222('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value222t1, 10)) === false
      || Number.isInteger(parseInt(value222t2, 10)) === false
    ) {
      setResponseValue222('Input should be an Integer');
    } else if (value222t1 !== '' && value222t2 !== '') {
      setResponseValue222(parseInt(value222t1, 10) / parseInt(value222t2, 10));
    }
  }

  // sending data to db with API
  
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
    // criteria2FieldInfoQl: [
    //   {
    //     criteriaId: { collegeId: '1', financialYear: financialYear, typeofInstitution: "autonomous" },
    //     uniqueKey1: 1,
    //     input221t1: value221t1,
    //     response221: responseValue221,
    //   }
    // ],
    criteria22Qn: [
      {
        criteriaId: {collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType  },
        uniqueKey1: 1,
        input221t1: value221t1,
        response221: responseValue221,
        input222t1: value222t1,
        input222t2: value222t2,
        response222: responseValue222,
        criteria22status:"save"
      }
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingModify() {
    const form22Data = new FormData();

    form22Data.append('criteria2Fieldinfo', jsonBlob(inputDataList));
    if (pathValue221f1 !== '') {
      form22Data.append('uploadfile2', value221f1, 'f221f1-' + value221f1.name);
    }
    if (pathValue221f2 !== '') {
      form22Data.append('uploadfile2', value221f2, 'f221f2-' + value221f2.name);
    }
    if (pathValue222f1 !== '') {
      form22Data.append(
        'uploadfile2',
        value222f1,
        'f2221f1-' + value222f1.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form22Data,
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


  // // GET DATA
  // const financialYear="2021-2022";
  // useEffect(
  //   () => fetch("http://localhost:8080/api/v1/criteria2getallfiles").then(
  //     (response) => response
  //       .json()
  //       .then((data) => {
  //         console.log("21 data is =>" + JSON.stringify(data));
  //         setValue221t1(data[0].criteria2FieldInfoQl[0].input221t1);
  //         setValue222t1(data[0].criteria22Qn[0].input222t1);
  //         setValue222t2(data[0].criteria22Qn[0].input222t2);

  //         setPathValue221f1(
  //           data[0].criteria2FileUpload[0].criteria2FileName
  //         );
  //         setPathValue221f2(
  //           data[0].criteria2FileUpload[1].criteria2FileName
  //         );
  //       })
  //       .catch((error) => {
  //         console.error("Error:", error);
  //       })
  //   ),
  //   []
 // );
 // getfile data with API

 function downloadFile(fileName) {
  const filePath = "http://localhost:8080/api/v1/download/" + fileName;
  return filePath;
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
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c22x-weightage-heading-style">
            Key Indicator Weightage: 30
          </h1>
        </div>
      </div>

      {/* Key Indicator: 2.2.1 */}
      <div className="c22x-eachInputField-container">
        <div className="c22x-weightage-container">
          <h1 className="c22x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c22x-Ql-label-textarea-container">
            <div className="c22x-heading_Help-container">
              <h1 className="c22x-heading-style">
                <span className="c22x-span-style">2.2.1: </span>
                The institution assesses the learning levels of the students and 
organises special Programmes to cater to differential learning 
needs of the student
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
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <label htmlFor="221-t1" className="c22x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue221t1(e.target.value);
                setResponseValue221(e.target.value);
              }}
              value={value221t1}
              rows={10}
              className="c22x-textarea-style"
              id="221-t1"
            ></textarea>
            {value221t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c22x-Ql-table-style">
            <tr>
              <th className="c22x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c22x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c22x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c22x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c22x-Ql-tableBorders-style">
               Paste link for additional Information
              </td>
              <td className="c22x-Ql-tableBorders-style"></td>
              <td className="c22x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue221f1(e.target.files[0]);
                    setPathValue221f1(e.target.value);
                  }}
                  id="221-f1"
                  className="c22-fileButton-style"
                  type="file"
                />
                {pathValue221f1 === '' ? null : (
                  <div className="c22-fileButtons-container">
                    <button className="c22-viewFileButton-style">
                        View File
                    </button>

                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue221f1("");
                      document.getElementById("221-f1").value="" }} >
                       Reset                     
                    </button>

                  </div>
                )}
                <a href={downloadFile(value221f1)} target="_blank">View File</a>
                 {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c22x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c22x-Ql-tableBorders-style">
                Upload any Additional Information
              </td>
              <td className="c22x-Ql-tableBorders-style"></td>
              <td className="c22x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue221f2(e.target.files[0]);
                    setPathValue221f2(e.target.value);
                  }}
                  id="221-f2"
                  className="c22-fileButton-style"
                  type="file"
                />
                {pathValue221f2 === '' ? null : (
                  <div className="c22-fileButtons-container">
                    <button className="c22-viewFileButton-style">
                        View File
                    </button>

                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue221f2("");
                      document.getElementById("221-f2").value="" }} >
                       Reset                     
                    </button>

                  </div>
                )}
                <a href={downloadFile(value221f2)} target="_blank">View File</a>
                 {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c22x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 2.2.2 */}
      <div className="c22x-eachInputField-container">
        <div className="c22x-weightage-container">
          <h1 className="c22x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c22x-container">
            <div className="c22x-heading_Help-container">
              <h1 className="c22x-heading-style">
                <span className="c22x-span-style">2.2.2: </span>
                Student - Full time teacher ratio (Data for the latest completed
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
                title='formula'
                ><h1>Students (Latest completed academic year) : Teachers (Latest completed academic year)</h1></HelpButton>
            </div>
            <div className="c22x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus222(!responseButtonStatus222);
                  onClickingViewResponse222();
                }}
                className="c22x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus222 ? (
                <p className="c22x-responseResult-style">{responseValue222}</p>
              ) : null}
            </div>
          </div>
          <div className="c22xx-container">
            <h1 className="c22xx-Heading-style">
              <span className="c22xx-span-style">A.</span>
              Total Number of students enrolled in the institution.
              <input
                onChange={(e) => setValue222t1(e.target.value)}
                id="222-t1"
                style={{ marginLeft: '4%' }}
                type="text"
                value={value222t1}
              />
            </h1>
            <h1 className="c22xx-Heading-style">
              <span className="c22xx-span-style">B.</span>
              Total number of full time teachers in the institution.
              <input
                onChange={(e) => setValue222t2(e.target.value)}
                id="222-t2"
                style={{ marginLeft: '4.5%' }}
                type="text"
                value={value222t2}
              />
            </h1>
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
                      setValue222f1(e.target.files[0]);
                      setPathValue222f1(e.target.value);
                    }}
                    id="222-f1"
                    className="c22-fileButton-style"
                    type="file"
                  />
                  {pathValue222f1 === '' ? null : (
                    <div className="c22-fileButtons-container">
                      <button className="c22-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue222f1("");
                      document.getElementById("222-f1").value="" }} >
                       Reset                     
                    </button>

                    </div>
                  )}
                   <a href={downloadFile(value222f1)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
                </td>
                <td className="c22x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
      <div className="c22x-button-container">
        <button onClick={onClickingModify} className="c22x-button-style">
          Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria22;
