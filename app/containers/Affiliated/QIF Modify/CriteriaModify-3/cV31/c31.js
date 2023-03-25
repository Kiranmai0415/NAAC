import React, { useState,useEffect } from 'react';
import './c31-style.css';
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
function Help311(props) {
  return props.isHelp311Clicked ? (
    <div className="c32x-help-mainContainer">
      <div className="c32x-help-subContainer">
        <h1 className="c32x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c32x-help-para-style">
          Total Grants from Government and non-governmental agencies for
          research projects , endowments, Chairs in the institution during the
          last five years (INR in Lakhs) Data Requirement for last five years:
          (As per Data Template)
          <br />
          • Name of the Project/ Endowments, Chairs
          <br />
          • Name of the Principal Investigator
          <br />
          • Department of Principal Investigator
          <br />
          • Year of Award
          <br />
          • Funds provided <br />
          • Duration of the project
          <br />• Name of the Project/ Endowments, Chairs.
        </p>
        <button
          className="c32x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp311Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}


// Promotion of Research and Facilities
function Criteria31() {
     // /this is Help button 
     const [isOpen, setIsopen] = useState(false)
     const handleHelpOpen = (e) => {
       e.preventDefault(),
       setIsopen(true)
     }
     const handleHelpClose = () => {
       setIsopen(false)
     }
      // getfile data with API
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
  // state variables
  const [value3111t1, setValue3111t1] = useState();
  const [value3111t2, setValue3111t2] = useState();
  const [value3111t3, setValue3111t3] = useState();
  const [value3111t4, setValue3111t4] = useState();
  const [value3111t5, setValue3111t5] = useState();
  const [value3111t6, setValue3111t6] = useState();
  const [value3111t7, setValue3111t7] = useState();
  const [value3111t8, setValue3111t8] = useState();
  const [value3111t9, setValue3111t9] = useState();
  const [value3111t10, setValue3111t10] = useState();
  const [value3221t11, setValue3221t11] = useState();
  const [value3111f1, setValue3111f1] = useState('');
  const [pathValue3111f1, setPathValue3111f1] = useState('');
  const [value3111f2, setValue3111f2] = useState();
  const [pathValue3111f2, setPathValue3111f2] = useState('');
  const [responseButtonStatus311, setResponseButtonStatus311] = useState(false);
  const [responseValue311, setResponseValue311] = useState('');
  const [help311Status, setHelp311Status] = useState(false);
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
  // const financialYear="2021-2022";
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }

  useEffect(
    () => fetch(resources.APPLICATION_URL+'criteria3getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));

          // setResponseValue111(data[0].criteria1FieldInfoQl[1].response111);
          // setResponseValue112(data[0].criteria1FieldInfoQn[2].response112);
          // setResponseValue113(data[0].criteria1FieldInfoQn[3].response113);

          setValue3111t1(data[0].affiliatedYearTable3111[0]?data[0].affiliatedYearTable3111[0].input3111y:"");
          setValue3111t2(data[0].affiliatedYearTable3111[1]?data[0].affiliatedYearTable3111[1].input3111y:"");
          setValue3111t3(data[0].affiliatedYearTable3111[2]?data[0].affiliatedYearTable3111[2].input3111y:"");
          setValue3111t4(data[0].affiliatedYearTable3111[3]?data[0].affiliatedYearTable3111[3].input3111y:"");
          setValue3111t5(data[0].affiliatedYearTable3111[4]?data[0].affiliatedYearTable3111[4].input3111y:"");
          setValue3111t6(data[0].affiliatedYearTable3111[0]?data[0].affiliatedYearTable3111[0].input3111v:"");
          setValue3111t7(data[0].affiliatedYearTable3111[1]?data[0].affiliatedYearTable3111[1].input3111v:"");
          setValue3111t8(data[0].affiliatedYearTable3111[2]?data[0].affiliatedYearTable3111[2].input3111v:"");
          setValue3111t9(data[0].affiliatedYearTable3111[3]?data[0].affiliatedYearTable3111[3].input3111v:"");
          setValue3111t10(data[0].affiliatedYearTable3111[4]?data[0].affiliatedYearTable3111[4].input3111v:"");

          setValue3111f1(data[0].criteria3FileUpload[0]?data[0].criteria3FileUpload[0].criteria3FileName:"");
          setValue3111f2(data[0].criteria3FileUpload[0]?data[0].criteria3FileUpload[0].criteria3FileName:"");
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ),
    []
  );
  // response button functionality
  function onClickingViewResponse311() {
    if (
      value3111t6 === ''
      || value3111t7 === ''
      || value3111t8 === ''
      || value3111t9 === ''
      || value3111t10 === ''
      || value3111t6 === undefined
      || value3111t7 === undefined
      || value3111t8 === undefined
      || value3111t9 === undefined
      || value3111t10 === undefined
    ) {
      setResponseValue311('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3111t6, 10)) === false
      || Number.isInteger(parseInt(value3111t7, 10)) === false
      || Number.isInteger(parseInt(value3111t8, 10)) === false
      || Number.isInteger(parseInt(value3111t9, 10)) === false
      || Number.isInteger(parseInt(value3111t10, 10)) === false
    ) {
      setResponseValue311('Input should be an Integer');
    } else if (
      value3111t6 !== ''
      && value3111t7 !== ''
      && value3111t8 !== ''
      && value3111t9 !== ''
      && value3111t10 !== ''
    ) {
      setResponseValue311(
        parseInt(value3111t6, 10)
          + parseInt(value3111t7, 10)
          + parseInt(value3111t8, 10)
          + parseInt(value3111t9, 10)
          + parseInt(value3111t10, 10)
      );
    }
  }

  // sending data to db with API

  // sending data to db with API
  
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},   
    criteria31Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},   
      uniqueKey1: 101,
        response311: responseValue311,
     
      },
    ],
    affiliatedYearTable3111: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},   
         uniqueKey1: 101, input3111y: value3111t1, input3111v: value3111t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
          uniqueKey1: 102, input3111y: value3111t2, input3111v: value3111t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
          uniqueKey1: 103, input3111y: value3111t3, input3111v: value3111t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},           
         uniqueKey1: 104, input3111y: value3111t4, input3111v: value3111t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
          uniqueKey1: 105, input3111y: value3111t5, input3111v: value3111t10
      },
    ],
   
  };

 
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingModify() {
    const form31Data = new FormData();

    // form31Data.append('criteria3FieldinfoQn', jsonBlob(inputDataListQn));
    console.log("data is ==>" + JSON.stringify(inputDataList));
    form31Data.append('criteria3Fieldinfo', jsonBlob(inputDataList));
    if (pathValue3111f1 !== '') {
      form31Data.append('uploadfile3', value3111f1, 'f311f1-' + value3111f1.name);
    }
    if (pathValue3111f2 !== '') {
      form31Data.append('uploadfile3', value3111f2, 'f311f2-' + value3111f2.name);
    }

    // if (pathValue3121f1 !== '') {
    //   form31Data.append(
    //     'uploadfile3',
    //     value3121f1,
    //     'f3121f1-' + value3121f1.name
    //   );
    // }
    // if (pathValue3121f2 !== '') {
    //   form31Data.append(
    //     'uploadfile3',
    //     value3121f2,
    //     'f3121f2-' + value3121f2.name
    //   );
    // }
    // if (pathValue3121f3 !== '') {
    //   form31Data.append(
    //     'uploadfile3',
    //     value3121f3,
    //     'f3121f3-' + value3121f3.name
    //   );
    // }
    // if (pathValue3121f4 !== '') {
    //   form31Data.append(
    //     'uploadfile3',
    //     value3121f4,
    //     'f3121f4-' + value3121f4.name
    //   );
    // }

    // if (pathValue3131f1 !== '') {
    //   form31Data.append(
    //     'uploadfile3',
    //     value3131f1,
    //     'f3131f1-' + value3131f1.name
    //   );
    // }
    // if (pathValue3131f2 !== '') {
    //   form31Data.append(
    //     'uploadfile3',
    //     value3131f2,
    //     'f3131f2-' + value3131f2.name
    //   );
    // }
    // if (pathValue3131f3 !== '') {
    //   form31Data.append(
    //     'uploadfile3',
    //     value3131f3,
    //     'f3131f3-' + value3131f3.name
    //   );
    // }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form31Data,
    };
    fetch(
      resources.APPLICATION_URL+'criteria3upload',
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
    <div className="c31-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c31x-colorIndicator-container">
        <p className="c31x-QlcolorIndicator-circle-style"></p>
        <span className="c31x-colorIndicator-span-style">Qualitative</span>
        <p className="c31x-QtcolorIndicator-circle-style"></p>
        <span className="c31x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c31x-weightage-heading-style">
            Key Indicator Weightage:10
          </h1>
        </div>
      </div>
      {/* Key Indicator: 3.1.1 */}
      <div className="c32x-eachInputField-container">
        <div className="c32x-weightage-container">
          <h1 className="c32x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c32x-container">
            <div className="c32x-heading_Help-container">
              <h1 className="c32x-heading-style">
                <span className="c32x-span-style">3.1.1: </span>
                Grants received from Government and non-governmental agencies
                for research projects, endowments, Chairs in the institution
                during the last five years (INR in Lakhs).
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c31x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='file description'
                ></HelpButton>
            </div>
            <div className="c32x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus311(!responseButtonStatus311);
                  onClickingViewResponse311();
                }}
                className="c32x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus311 ? (
                <p className="c32x-responseResult-style">{responseValue311}</p>
              ) : null}
            </div>
          </div>
          <div className="c32xx-container">
            <h1 className="c32xx-Heading-style">
              <span className="c32xx-span-style">3.1.1.1: </span>
              Total Grants from Government and non-governmental agencies for
              research projects , endowments, Chairs in the institution during
              the last five years (INR in Lakhs)
            </h1>

            <table className="c32x-Qt-table-style">
              <tr>
                <th className="c32x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3111t1(e.target.value)}
                      id="3111-t1"
                      className="c32x-input-style"
                      type="text"
                      value={value3111t1}
                    />
                    {value3111t1 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3111t2(e.target.value)}
                      id="3111-t2"
                      className="c32x-input-style"
                      type="text"
                      value={value3111t2}
                    />
                    {value3111t2 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3111t3(e.target.value)}
                      id="3111-t3"
                      className="c32x-input-style"
                      type="text"
                      value={value3111t3}
                    />
                    {value3111t3 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3111t4(e.target.value)}
                      id="3111-t4"
                      className="c32x-input-style"
                      type="text"
                      value={value3111t4}
                    />
                    {value3111t4 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3111t5(e.target.value)}
                      id="3111-t5"
                      className="c32x-input-style"
                      type="text"
                      value={value3111t5}
                    />
                    {value3111t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c32x-horizontalTable-heading-style">
                  INR in lakhs
                </th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue3111t6(e.target.value);
                        onClickingViewResponse311();
                      }}
                      id="3111-t6"
                      className="c32x-input-style"
                      type="text"
                      value={value3111t6}
                    />
                    {value3111t6 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue3111t7(e.target.value);
                        onClickingViewResponse311();
                      }}
                      id="3111-t7"
                      className="c32x-input-style"
                      type="text"
                      value={value3111t7}
                    />
                    {value3111t7 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue3111t8(e.target.value);
                        onClickingViewResponse311();
                      }}
                      id="3111-t8"
                      className="c32x-input-style"
                      type="text"
                      value={value3111t8}
                    />
                    {value3111t8 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue3111t9(e.target.value);
                        onClickingViewResponse311();
                      }}
                      id="3111-t9"
                      className="c32x-input-style"
                      type="text"
                      value={value3111t9}
                    />
                    {value3111t9 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue3111t10(e.target.value);
                        onClickingViewResponse311();
                      }}
                      id="3111-t10"
                      className="c32x-input-style"
                      type="text"
                      value={value3111t10}
                    />
                    {value3111t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c32x-Qt-table-style">
              <tr>
                <th className="c32x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c32x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c32x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c32x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td className="c32x-Qt-tableBorders-style">
                  Any additional information
                </td>
                <td className="c32x-Qt-tableBorders-style"></td>
                <td className="c32x-Qt-tableBorders-style">
                <input
                    onChange={(e) => {
                      setValue3111f1(e.target.files[0]);
                      setPathValue3111f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3111-f1"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue3111f1 === '' ? null : (
                    <div className="c27-fileButtons-container">
                      <button className="c27-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3111f1("");
                      document.getElementById("3111-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value3111f1)} target="_blank">View File</a>
                 */}
                </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td className="c32x-Qt-tableBorders-style">
                  e-copies of the grant award letters for research projects
                  sponsored by non-government
                </td>
                <td>
                <a href={downloadFile("af3.1.1.xlsx")} target="_blank">View Template</a>
                </td>
                <td className="c32x-Qt-tableBorders-style">
                <input
                    onChange={(e) => {
                      setValue3111f2(e.target.files[0]);
                      setPathValue3111f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3111-f2"
                    className="c27-fileButton-style"
                    type="file"
                  />
                  {pathValue3111f2 === '' ? null : (
                    <div className="c27-fileButtons-container">
                      <button className="c27-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3111f2("");
                      document.getElementById("3111-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value3111f2)} target="_blank">View File</a> */}
                
                </td>
                <td className="c32x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
        <div className="c31x-button-container">
          <button
            onClick={() => {
              onClickingModify();
            }}
            className="c31x-button-style"
          >
            Modify
          </button>
        </div>
      </div>
  );
}

export default Criteria31;
