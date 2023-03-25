import React, { useState, useEffect } from 'react';
import './c14-style.css';
import AuthService from '../../../../Pages/Users/services/auth.service';
import { toast } from 'react-toastify';
import { Button } from '@mui/material';
import { resources } from '../../../../appConstants';
import { HelpButton } from '../../../../../reusableComponents/model/Help';


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

// Help buttons functionality
function Help141(props) {
  return props.isHelp141Clicked ? (
    <div className="c14x-help-mainContainer">
      <div className="c14x-help-subContainer">
        <h1 className="c14x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c14x-help-para-style">
          Justify that the college satisfies the metric Describe it in maximum
          500 words.
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

// Help buttons functionality
function Help142(props) {
  return props.isHelp142Clicked ? (
    <div className="c14x-help-mainContainer">
      <div className="c14x-help-subContainer">
        <h1 className="c14x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c14x-help-para-style">
          Justify that the college satisfies the metric Describe it in maximum
          500 words.
        </p>
        <button
          className="c14x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp142Clicked(false);
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
  const [value141f1, setValue141f1] = useState([]);
  const [value141f2, setValue141f2] = useState([]);
  const [value141f3, setValue141f3] = useState([]);
  const [value141t1, setValue141t1] = useState();
  const [value142f1, setValue142f1] = useState([]);
  const [value142f2, setValue142f2] = useState([]);
  const [value142t1, setValue142t1] = useState();
  const [value142t2, setValue142t2] = useState();
  const [pathValue141f1, setPathValue141f1] = useState('');
  const [pathValue141f2, setPathValue141f2] = useState('');
  const [pathValue141f3, setPathValue141f3] = useState('');
  const [pathValue141f4, setPathValue141f4] = useState('');
  const [pathValue142f1, setPathValue142f1] = useState('');
  const [pathValue142f2, setPathValue142f2] = useState('');
  const [help141Status, setHelp141Status] = useState(false);
  const [help142Status, setHelp142Status] = useState(false);
  const [responseButtonStatus141, setResponseButtonStatus141] = useState(false);
  const [responseButtonStatus142, setResponseButtonStatus142] = useState(false);
  const [responseValue141, setResponseValue141] = useState('');
  const [responseValue142, setResponseValue142] = useState('');

 //get data api
//  const financialYear="2021-2022";

    // sending data to db with API
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
    () => fetch(resources.APPLICATION_URL+'criteria1getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));
          setValue141t1(data[0].criteria14Qn[0] ? data[0].criteria14Qn[0].input141t1 : "");
          setValue142t1(data[0].criteria14Qn[0] ? data[0].criteria14Qn[0].input142t1 : "");

          setResponseValue141(data[0].criteria14Qn[0] ? data[0].criteria14Qn[0].response141 : "");
          setResponseValue142(data[0].criteria14Qn[0] ? data[0].criteria14Qn[0].response142 : "");

          setValue141f1(data[0].criteria1FileUpload[0] ? data[0].criteria14Qn[0].criteria1FileName : "");
          setValue141f2(data[0].criteria1FileUpload[1] ? data[0].criteria14Qn[1].criteria1FileName : "");
          setValue142f1(data[0].criteria1FileUpload[2] ? data[0].criteria14Qn[2].criteria1FileName : "");
          setValue142f2(data[0].criteria1FileUpload[3] ? data[0].criteria14Qn[3].criteria1FileName : "");

        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ),

    []
  );

  // getr data  with API

  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }



   const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
    criteria14Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201, 
        input141t1: value141t1,
        input142t1: value142t1,
        response141: responseValue141,
        response142: responseValue142,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form14Data = new FormData();

    form14Data.append("criteria1Fieldinfo", jsonBlob(inputDataList));
    if (pathValue141f1 !== "") {
      form14Data.append("uploadfile1", value141f1, "f141f1-" + value141f1.name);
    }
    if (pathValue141f2 !== "") {
      form14Data.append("uploadfile1", value141f2, "f141f2-" + value141f2.name);
    }
    if (pathValue141f3 !== "") {
      form14Data.append("uploadfile1", value141f3, "f141f3-" + value141f3.name);
    }
    if (pathValue142f1 !== "") {
      form14Data.append("uploadfile1", value142f1, "f142f1-" + value142f1.name);
    }
    if (pathValue142f2 !== "") {
      form14Data.append("uploadfile1", value142f2, "f142f2-" + value142f2.name);
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form14Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria1upload",
      filesFetchMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Saved Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
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
        <form>
        <div className="c14x-container">
            <div className="c14x-heading_Help-container">
              <div>
                <h1 className="c14x-heading-style">
                  <span className="c14x-span-style">1.4.1: </span>
                  Structured feedback for curriculum and its transactions is regularly obtained from stakeholders like Students, Teachers, Employers, Alumni, Academic peers etc., and Feedback processes of the institution may be classified as follows:
                </h1>
                <p className="c14x-para-style">
                  1. Feedback collected, analysed, action taken & communicated to relevant body and feedback hosted on the institutional website
                  <br />
                  2. Feedback collected, analysed, action taken & communicated to relevant body and feedback hosted on the institutional website
                  <br />
                  3. Feedback collected and analysed
                  <br />
                  4. Feedback collected
                  <br/>
                  5. Feedback not collected
                </p>
                <div className="c14x-radio-container">
                  <div className="c14x-radio-subContainer">
                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue141t1(e.target.value)}
                        value="option a"
                        name="141-t1"
                        type="radio"
                      />

                      <label className="c14x-radioLabel-style" for="141-t1">
                        A. All of the above
                      </label>
                    </div>

                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue141t2(e.target.value)}
                        value="option b"
                        name="141-t1"
                        type="radio"
                      />

                      <label className="c14x-radioLabel-style" for="141-t1">
                        B. Any three of the above
                      </label>
                    </div>

                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue141t3(e.target.value)}
                        value="option c"
                        name="141-t1"
                        type="radio"
                      />

                      <label className="c14x-radioLabel-style" for="141-t1">
                        C. Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c14x-radio-subContainer">
                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue141t4(e.target.value)}
                        value="option d"
                        name="141-t1"
                        type="radio"
                      />

                      <label className="c14x-radioLabel-style" for="141-t1">
                        D. Any one of the above
                      </label>
                    </div>

                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue141t5(e.target.value)}
                        value="option e"
                        name="141-t1"
                        type="radio"
                      />

                      <label className="c14x-radioLabel-style" for="141-t1">
                        E. None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='file description'
                ></HelpButton>
            </div>
            <div className="c14x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus141(!responseButtonStatus141);
                  onClickingViewResponse141();
                }}
                className="c14x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus141 ? (
                <p className="c14x-responseResult-style">{responseValue141}</p>
              ) : null}
            </div>
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
              At least 4 filled-in feedback form from different stake holders like Students, Teachers, Employers, Alumni etc.
              </td>
              <td><a href={downloadFile("un1.4.1.xlsx")} target="_blank">View Template</a></td>
              <td className="c14x-Ql-tableBorders-style">
                {/* <a href={downloadFile(value141f1)} target="_blank">view</a> */}
                <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="141-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue141f1(e.target.files[0]);
                    setPathValue141f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue141f1}
              {pathValue141f1 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc141f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue141f1("");
                      document.getElementById("141-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c14x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c14x-Ql-tableBorders-style">
              Feedback analysis report submitted to appropriate committee/bodies
              </td>
              <td>
              </td>
              <td className="c14x-Ql-tableBorders-style">
                {/* <a href={downloadFile(value141f2)} target="_blank">view</a> */}
                <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="141-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue141f2(e.target.files[0]);
                    setPathValue141f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue141f2}
              {pathValue141f2 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc141f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue141f2("");
                      document.getElementById("141-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c14x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c14x-Ql-tableBorders-style">
              Action taken report on the feedback analysis and its report to appropriate committee/bodies
              </td>
              <td>
              </td>
              <td className="c14x-Ql-tableBorders-style">
                {/* <a href={downloadFile(value141f2)} target="_blank">view</a> */}
                <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="141-f3"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue141f3(e.target.files[0]);
                    setPathValue141f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue141f3}
              {pathValue141f3 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc141f3}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue141f3("");
                      document.getElementById("141-f3").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c14x-Ql-tableBorders-style">pdf</td>
            </tr>

            <tr>
              <td className="c14x-Ql-tableBorders-style">
              Link of institution?s website where comprehensive feedback, its analytics and action taken report are hosted
              </td>
              <td>
              </td>
              <td className="c14x-Ql-tableBorders-style">
                {/* <a href={downloadFile(value141f3)} target="_blank">view</a> */}
                <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="141-f4"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue141f4(e.target.files[0]);
                    setPathValue141f4(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue141f4}
              {pathValue141f4 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc141f4}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue141f4("");
                      document.getElementById("141-f4").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 1.4.2 */}
      {/* <div className="c14x-eachInputField-container">
        <form>
        <div className="c14x-container">
            <div className="c14x-heading_Help-container">
              <div>
                <h1 className="c14x-heading-style">
                  <span className="c14x-span-style">1.4.2: </span>
                  The feedback system of the Institution comprises of the
                  following :
                </h1>
                <div className="c14x-radio-container">
                  <div className="c14x-radio-subContainer">
                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue142t1(e.target.value)}
                        value="option a"
                        name="142-t1"
                        type="radio"
                      />

                      <label className="c14x-radioLabel-style" for="142-t1">
                        A.Feedback collected, analysed and action taken and
                        report made available on website
                      </label>
                    </div>

                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue142t1(e.target.value)}
                        value="option b"
                        name="142-t1"
                        type="radio"
                      />

                      <label className="c14x-radioLabel-style" for="142-t1">
                        B. Feedback collected, analysed and action taken
                      </label>
                    </div>

                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue142t1(e.target.value)}
                        value="option c"
                        name="142-t1"
                        type="radio"
                      />

                      <label className="c14x-radioLabel-style" for="142-t1">
                        C. Feedback collected and analysed
                      </label>
                    </div>
                  </div>

                  <div className="c14x-radio-subContainer">
                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue142t1(e.target.value)}
                        value="option d"
                        name="142-t1"
                        type="radio"
                      />

                      <label className="c14x-radioLabel-style" for="142-t1">
                        D. Feedback collected
                      </label>
                    </div>

                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue142t1(e.target.value)}
                        value="option e"
                        name="142-t1"
                        type="radio"
                      />
                      <label className="c14x-radioLabel-style" for="142-t1">
                        E. Feedback not obtained
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp142Status(true);
                }}
                className="c14x-helpButton-style"
              >
                Help
              </button>
              <Help142
                isHelp142Clicked={help142Status}
                setIsHelp142Clicked={setHelp142Status}
              />
            </div>
            <div className="c14x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus142(!responseButtonStatus142);
                  onClickingViewResponse142();
                }}
                className="c14x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus142 ? (
                <p className="c14x-responseResult-style">{responseValue142}</p>
              ) : null}
            </div>
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
                Any additional information
              </td>
              <td></td>
              <td className="c14x-Ql-tableBorders-style">
                <a href={downloadFile(value142f1)} target="_blank">view</a>
              </td>
              <td className="c14x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c14x-Ql-tableBorders-style">
               URL for stakeholder feedback report
              </td>
              <td><a href=resources.APPLICATION_URL+"download/criteria1.4.1&1.4.2.xslx">View Template</a></td>
              <td className="c14x-Ql-tableBorders-style">
                <a href={downloadFile(value142f2)} target="_blank">view</a>
              </td>
              <td className="c14x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div> */}
      <div className="c14x-button-container">
        <button onClick={onClickingSave} className="c14x-button-style">
         Save
        </button>
      </div>
    </div>
  );
}
export default Criteria14;
