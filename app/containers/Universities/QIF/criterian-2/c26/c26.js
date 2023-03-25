import React, { useEffect, useState } from 'react';
import './c26-style.css';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import { HelpButton } from "../../../../../reusableComponents/model/Help";
import { resources } from "../../../../appConstants";

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
function Help261(props) {
  return props.isHelp261Clicked ? (
    <div className="c26x-help-mainContainer">
      <div className="c26x-help-subContainer">
        <h1 className="c26x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c26x-help-para-style">
          Describe Course Outcomes(COs) for all courses and mechanism of
          communication within a maximum of 500 words.
        </p>
        <button
          className="c23x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp261Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help262(props) {
  return props.isHelp262Clicked ? (
    <div className="c26x-help-mainContainer">
      <div className="c26x-help-subContainer">
        <h1 className="c26x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c26x-help-para-style">
          Describe the method pf measuring attainment of POs , PSOs and COs in
          not more than 500 words and the level of attainment of POs, PSOs and
          COs in not more than 500 words and the level of attainment of POs,
          PSOs and COs.
        </p>
        <button
          className="c26x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp262Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help263(props) {
  return props.isHelp263Clicked ? (
    <div className="c26x-help-mainContainer">
      <div className="c26x-help-subContainer">
        <h1 className="c26x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c26x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>The Total number final
          year students who passed in the examination
          <span style={{ fontWeight: 'bold' }}>/</span>The total number of final
          year students who appeared for the examination
          <span style={{ fontWeight: 'bold' }}>) *</span> 100
        </p>
        <button
          className="c26x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp263Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria26() {

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

  const [value261t1, setValue261t1] = useState();
  const [value262t1, setValue262t1] = useState();

  const [pathValue261f1, setPathValue261f1] = useState('');
  const [value261f1, setValue261f1] = useState([]);
  const [pathValue261f2, setPathValue261f2] = useState('');
  const [value261f2, setValue261f2] = useState([]);
  const [pathValue261f3, setPathValue261f3] = useState('');
  const [value261f3, setValue261f3] = useState([]);

  const [pathValue262f1, setPathValue262f1] = useState('');
  const [value262f1, setValue262f1] = useState([]);
  const [pathValue262f2, setPathValue262f2] = useState('');
  const [value262f2, setValue262f2] = useState([]);
  const [value2621t1, setValue2621t1] = useState();

  const [responseButtonStatus121, setResponseButtonStatus121] = useState(false);
  const [responseButtonStatus262, setResponseButtonStatus262] = useState(false);

  const [value2632t1, setValue2632t1] = useState();
  const [value2631t1, setValue2631t1] = useState();
  const [pathValue2632f1, setPathValue2632f1] = useState('');
  const [value2632f1, setValue2632f1] = useState([]);
  const [pathValue2632f2, setPathValue2632f2] = useState('');
  const [value2632f2, setValue2632f2] = useState([]);
  const [pathValue2632f3, setPathValue2632f3] = useState('');
  const [value2632f3, setValue2632f3] = useState([]);
  const [responseButtonStatus263, setResponseButtonStatus263] = useState(false);
  const [responseValue261, setResponseValue261] = useState('');
  const [responseValue262, setResponseValue262] = useState('');
  const [responseValue263, setResponseValue263] = useState('');
  const [help261Status, setHelp261Status] = useState(false);
  const [help262Status, setHelp262Status] = useState(false);
  const [help263Status, setHelp263Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');


  // response button functionality
  function onClickingViewResponse263() {
    console.log("responseValue263")
    if (value2631t1 === "" || value2632t1 === "") {
      setResponseValue263("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value2631t1, 10)) === false ||
      Number.isInteger(parseInt(value2632t1, 10)) === false
    ) {
      setResponseValue263("Input should be an Integer");
    } else if (value2631t1 !== "" && value2632t1 !== "") {
      setResponseValue263(
        (parseInt(value2631t1) / parseInt(value2632t1)) * 100
      );
    }
  }

  // function onClickingViewResponse262() {
  //   console.log("responseValue262")
  //   if (value2621t1 === "" || responseButtonStatus121 === "") {
  //     setResponseValue262("Please fill the required fields");
  //   } else if (
  //     Number.isInteger(parseInt(value2621t1, 10)) === false ||
  //     Number.isInteger(parseInt(responseButtonStatus121, 10)) === false
  //   ) {
  //     setResponseValue262("Input should be an Integer");}
  //     else if (value2621t1 !== "" && responseButtonStatus121 !== "") {
  //       setResponseValue262(parseInt(value2621t1, 10)/(parseInt(responseButtonStatus121, 10))*100);
  //   console.log(parseInt(value2621t1, 10)/(parseInt(responseButtonStatus121, 10))*100)
  //   }
  // }
  function onClickingViewResponse262() {
    console.log(parseInt(value2621t1, 10)/(parseInt(responseButtonStatus121, 10))*100);
    let resp = (parseInt(value2621t1, 10)/(parseInt(responseButtonStatus121, 10))*100);
    console.log("response is ==>",resp);
      setResponseValue262(resp);
  }
  

    useEffect(
      () => fetch('https://localhost:8080/api/v1/viewResponseValue262?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType)
      .then(
        (response) => response
          .json()
          .then((data) => {
      console.log("response value is from backend==>" +JSON.stringify(data));
      setViewResponseValue262(data);

    })
    .catch((error)=>{
      console.error('Error:',error);
    })
  ),
  []

  )
  // function onClickingViewResponse262() {
  //   console.log(parseInt(value2621t1, 10)/(parseInt(viewResponseValue, 10))*100);
  //   let resp = (parseInt(value2621t1, 10)/(parseInt(responseButtonStatus121, 10))*100);
  //   console.log("response is ==>",resp);
  //     setResponseValue262(resp);
  // }


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



  // const financialYear="2021-2022";
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
    criteria26Ql: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
      input261t1: value261t1,
      input262t1: value262t1,
      response261: responseValue261,
      response262: responseValue262,
    },
  ],
  criteria26Qn: [
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      uniqueKey1: 201,
      input2631t1: value2631t1,
      input2632t1: value2632t1,

      response263: responseValue263,
      criteria26status:"save"
    },
  ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }


  function onClickingSave() {
    const form26Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form26Data.append('criteria2Fieldinfo', jsonBlob(inputDataList));
    if (pathValue261f1 !== '') {
      form26Data.append('uploadfile2', value261f1, 'f261f1-' + value261f1.name);
    }
    if (pathValue261f2 !== '') {
      form26Data.append('uploadfile2', value261f2, 'f261f2-' + value261f2.name);
    }
    if (pathValue261f3 !== '') {
      form26Data.append('uploadfile2', value261f3, 'f261f3-' + value261f3.name);
    }
    if (pathValue262f1 !== '') {
      form26Data.append('uploadfile2', value262f1, 'f262f1-' + value262f1.name);
    }
    if (pathValue262f2 !== '') {
      form26Data.append('uploadfile2', value262f2, 'f262f2-' + value262f2.name);
    }
    if (pathValue2632f1 !== '') {
      form26Data.append(
        'uploadfile2',
        value2632f1,
        'f2632f1-' + value2632f1.name
      );
    }
    if (pathValue2632f2 !== '') {
      form26Data.append(
        'uploadfile2',
        value2632f2,
        'f2632f2-' + value2632f2.name
      );
    }
    if (pathValue2632f3 !== '') {
      form26Data.append(
        'uploadfile3',
        value2632f3,
        'f2632f3-' + value2632f3.name
      );
    }
    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form26Data,
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
    <div className="c26-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c26x-colorIndicator-container">
        <p className="c26x-QlcolorIndicator-circle-style"></p>
        <span className="c26x-colorIndicator-span-style">Qualitative</span>
        <p className="c26x-QtcolorIndicator-circle-style"></p>
        <span className="c26x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c26x-weightage-heading-style">
            Key Indicator Weightage: 50
          </h1>
        </div>
      </div>
      {/* Key Indicator: 2.6.1 */}
      <div className="c26x-eachInputField-container">
        <div className="c26x-weightage-container">
          <h1 className="c26x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c26x-container">
            <div className="c26x-heading_Help-container">
              <h1 className="c26x-heading-style">
                <span className="c26x-span-style">2.6.1: </span>
                The institution has stated learning outcomes (Program and Course 
                outcomes)/graduate attributes which are integrated into the assessment 
                process and widely publicized through the website and other documents
                and the attainment of the same are evaluated by the institution              </h1>
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
            <label htmlFor="263-t1" className="c26x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue261t1(e.target.value);
                setResponseValue261(e.target.value);
              }}
              value={value261t1}
              rows={10}
              className="c26x-textarea-style"
              id="261-t1"
            ></textarea>
            {value261t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>
          <div className="c26xx-container">
            <table className="c26x-table-style">
              <tr>
                <th className="c26x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c26x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c26x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c26x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue261f1(e.target.files[0]);
                      setPathValue261f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="261-f1"
                    className="c26-fileButton-style"
                    type="file"
                  />
                  {pathValue261f1 === "" ? null : (
                    <div className="c26-fileButtons-container">
                      <button className="c26-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue261f1("");
                          document.getElementById("261-f1").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Link for Additional Information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue261f2(e.target.files[0]);
                      setPathValue261f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="261-f2"
                    className="c26-fileButton-style"
                    type="file"
                  />
                  {pathValue261f2 === "" ? null : (
                    <div className="c26-fileButtons-container">
                      <button className="c26-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue261f2("");
                          document.getElementById("261-f2").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload COs for all courses (exemplars from Glossary)</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue261f3(e.target.files[0]);
                      setPathValue261f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="261-f3"
                    className="c26-fileButton-style"
                    type="file"
                  />
                  {pathValue261f3 === "" ? null : (
                    <div className="c26-fileButtons-container">
                      <button className="c26-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue261f3("");
                          document.getElementById("261-f3").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 2.6.2 */}
      <div className="c26x-eachInputField-container">
        <div className="c26x-weightage-container">
          <h1 className="c26x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c26x-container">
            <div className="c26x-heading_Help-container">
              <h1 className="c26x-heading-style">
                <span className="c26x-span-style">2.6.2: </span>
                Pass percentage of students (excluding backlog students) (Data
                to be provided only for the latest completed academic year)
                <br />
                <br />
                <span className="c26x-label-style">2.6.2.1: </span>
                Total number of final year students who passed the examination
                conducted by Institution
                <input
                  onChange={(e) => setResponseButtonStatus262(e.target.value)}
                  id="2621-t1"
                  style={{ width: "25%", marginLeft: "4.6%" }}
                  type="number"
                />
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
                title='Formula:'
                ><h1>(?????????? ???????????? ???? ?????????? ???????? ???????????????? ?????? ???????????? ???? ?????? ???????????????????? ??????????????????????)/((??.??) ???????????? ???? ?????????? ????????-???????????????? ???????????????? (???????????? ?????????????????? ????????)) * 100</h1></HelpButton>
              </div>
            <div className="c25x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus262(!responseButtonStatus262);
                  onClickingViewResponse262();
                }}
                className="c25x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus262 ? (
                <p className="c25x-responseResult-style">{viewResponseValue262}</p>
              ) : null}
            </div>
            <div className="c26xx-container">
              <table className="c26x-table-style">
                <tr>
                  <th className="c26x-Qt-verticalTable-heading1-style">
                    File Description
                  </th>
                  <th className="c26x-Qt-verticalTable-heading2-style">
                    File Template
                  </th>
                  <th className="c26x-Qt-verticalTable-heading3-style">
                    Documents upload
                  </th>
                  <th className="c26x-Qt-verticalTable-heading4-style">
                    File type and size
                  </th>
                </tr>
                <tr>
                  <td>Any additional information</td>
                  <td></td>
                  <td>
                    <input
                      onChange={(e) => {
                        setValue262f1(e.target.files[0]);
                        setPathValue262f1(e.target.value);
                        showFilePreview(e);
                      }}
                      id="262-f1"
                      className="c26-fileButton-style"
                      type="file"
                    />
                    {pathValue262f1 === "" ? null : (
                      <div className="c26-fileButtons-container">
                        <button className="c26-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}>
                            {" "}
                            View File
                          </a>
                        </button>
                        <button
                          className="c11-removeFileButton-style"
                          onClick={(e) => {
                            setPathValue262f1("");
                            document.getElementById("262-f1").value = "";
                          }}
                        >
                          Reset
                        </button>
                      </div>
                    )}
                  </td>
                  <td className="c26x-Qt-tableBorders-style">pdf</td>
                </tr>
                <tr>
                  <td>Link for additional information</td>
                  <td></td>
                  <td>
                    <input
                      onChange={(e) => {
                        setValue262f2(e.target.files[0]);
                        setPathValue262f2(e.target.value);
                        showFilePreview(e);
                      }}
                      id="262-f2"
                      className="c26-fileButton-style"
                      type="file"
                    />
                    {pathValue262f2 === "" ? null : (
                      <div className="c26-fileButtons-container">
                        <button className="c26-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}>
                            {" "}
                            View File
                          </a>
                        </button>
                        <button
                          className="c11-removeFileButton-style"
                          onClick={(e) => {
                            setPathValue262f2("");
                            document.getElementById("262-f2").value = "";
                          }}
                        >
                          Reset
                        </button>
                      </div>
                    )}
                  </td>
                  <td className="c26x-Qt-tableBorders-style">pdf</td>
                </tr>
              </table>
            </div>
          </div>
        </form>
      </div>

      {/* Key Indicator: 2.6.3 */}
      <div className="c26x-eachInputField-container">
        <div className="c26x-weightage-container">
          <h1 className="c26x-weightage-heading-style">Weightage: 8</h1>
        </div>
        <form>
          <div className="c26x-container">
            <div className="c26x-heading_Help-container">
              <h1 className="c26x-heading-style">
                <span className="c26x-span-style">2.6.3: </span>
                Pass Percentage of students(Data for the latest completed
                academic year)
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp263Status(true);
                }}
                className="c26x-helpButton-style"
              >
                Help
              </button>
              <Help263
                isHelp263Clicked={help263Status}
                setIsHelp263Clicked={setHelp263Status}
              />
            </div>
            <div className="c26x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus263(!responseButtonStatus263);
                  onClickingViewResponse263();
                }}
                className="c26x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus263 ? (
                <p className="c26x-responseResult-style">{responseValue263}</p>
              ) : null}
            </div>
          </div>
          <div className="c26xx-container">
            <h1 className="c26xx-Heading-style">
              <span className="c26xx-span-style">2.6.3.1: </span>
              Total number of final year students who passed the examination
              conducted by Institution.
            </h1>
            <input
              onChange={(e) => setValue2631t1(e.target.value)}
              id="2631-t1"
              style={{ marginLeft: '70%' }}
              type="number"
            />
            <h1 className="c26xx-Heading-style">
              <span className="c26xx-span-style">2.6.3.2: </span>
              Total number of final year students who attended the examination
              conducted by Institution.
            </h1>
            <input
              onChange={(e) => setValue2632t1(e.target.value)}
              id="2632-t1"
              style={{ marginLeft: '70%' }}
              type="number"
            />
            <table className="c26x-table-style">
              <tr>
                <th className="c26x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c26x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c26x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c26x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                  Upload List of Programmes and number of students passed and
                  appeared in the final year examination(Data Template)
                </td>
                <td>
                  <a href="http://localhost:8080/api/v1/download/criteria2.6.3.xlsx">
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2632f1(e.target.files[0]);
                      setPathValue2632f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2632-f1"
                    className="c26-fileButton-style"
                    type="file"
                  />
                  {pathValue2632f1 === "" ? null : (
                    <div className="c26-fileButtons-container">
                      <button className="c26-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue2632f1("");
                          document.getElementById("2632-f1").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2632f2(e.target.files[0]);
                      setPathValue2632f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2632-f2"
                    className="c26-fileButton-style"
                    type="file"
                  />
                  {pathValue2632f2 === "" ? null : (
                    <div className="c26-fileButtons-container">
                      <button className="c26-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue2632f2("");
                          document.getElementById("2632-f2").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Paste link for annual report</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue2632f3(e.target.files[0]);
                      setPathValue2632f3(e.target.value);

                      showFilePreview(e);
                    }}
                    id="2632-f3"
                    className="c26-fileButton-style"
                    type="file"
                  />
                  {pathValue2632f3 === "" ? null : (
                    <div className="c26-fileButtons-container">
                      <button className="c26-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue2632f3("");
                          document.getElementById("2632-f3").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
      <div className="c26x-button-container">
        <button onClick={onClickingSave} className="c26x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria26;
