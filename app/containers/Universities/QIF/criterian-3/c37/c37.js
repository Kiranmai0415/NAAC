import React, { useState } from "react";
import "./c37-style.css";
import { toast } from "react-toastify";
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
// End here

function Help371(props) {
  return props.isHelp371Clicked ? (
    <div className="c37x-help-mainContainer">
      <div className="c37x-help-subContainer">
        <h1 className="c37x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c37x-help-para-style">
          Total number of such activities during the last five years{' '}
          <span style={{ fontWeight: 'bold' }}> / </span> 5
        </p>
        <button
          className="c37x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp371Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help372(props) {
  return props.isHelp372Clicked ? (
    <div className="c37x-help-mainContainer">
      <div className="c37x-help-subContainer">
        <h1 className="c37x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c37x-help-para-style">
          Number of functional MoUs with institutions of national, international
          importance, other Institutions, industries, corporate houses etc. year
          wise during last five years. Data Requirements for last five years:
          (As per Data Template)
          <br />
          • Organisation with which MoU is signed
          <br />
          • Name of the institution/ industry/ corporate house
          <br />
          • Year of signing MoU
          <br />
          • Duration
          <br />
          • List of the actual activities under each MoU
          <br />
          • Number of students/teachers participated under MoUs
          <br />
        </p>
        <button
          className="c37x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp372Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria37() {


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
  const [value3711t1, setValue3711t1] = useState();
  const [value3711t2, setValue3711t2] = useState();
  const [value3711t3, setValue3711t3] = useState();
  const [value3711t4, setValue3711t4] = useState();
  const [value3711t5, setValue3711t5] = useState();
  const [value3711t6, setValue3711t6] = useState();
  const [value3711t7, setValue3711t7] = useState();
  const [value3711t8, setValue3711t8] = useState();
  const [value3711t9, setValue3711t9] = useState();
  const [value3711t10, setValue3711t10] = useState();
  const [value3711f1, setValue3711f1] = useState('');
  const [pathValue3711f1, setPathValue3711f1] = useState('');
  const [value3711f2, setValue3711f2] = useState('');
  const [pathValue3711f2, setPathValue3711f2] = useState('');
  const [value3711f3, setValue3711f3] = useState('');
  const [pathValue3711f3, setPathValue3711f3] = useState('');
  const [responseButtonStatus371, setResponseButtonStatus371] = useState(false);
  const [responseValue371, setResponseValue371] = useState('');
  const [help371Status, setHelp371Status] = useState(false);

  const [value3721t1, setValue3721t1] = useState();
  const [value3721t2, setValue3721t2] = useState();
  const [value3721t3, setValue3721t3] = useState();
  const [value3721t4, setValue3721t4] = useState();
  const [value3721t5, setValue3721t5] = useState();
  const [value3721t6, setValue3721t6] = useState();
  const [value3721t7, setValue3721t7] = useState();
  const [value3721t8, setValue3721t8] = useState();
  const [value3721t9, setValue3721t9] = useState();
  const [value3721t10, setValue3721t10] = useState();
  const [value3721f1, setValue3721f1] = useState('');
  const [pathValue3721f1, setPathValue3721f1] = useState('');
  const [value3721f2, setValue3721f2] = useState('');
  const [pathValue3721f2, setPathValue3721f2] = useState('');
  const [value3721f3, setValue3721f3] = useState('');
  const [pathValue3721f3, setPathValue3721f3] = useState('');
  const [responseButtonStatus372, setResponseButtonStatus372] = useState(false);
  const [responseValue372, setResponseValue372] = useState('');
  const [help372Status, setHelp372Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');

// response functionality
  function onClickingViewResponse371() {
    if (
      value3711t6 === ''
      || value3711t7 === ''
      || value3711t8 === ''
      || value3711t9 === ''
      || value3711t10 === ''
      || value3711t6 === undefined
      || value3711t7 === undefined
      || value3711t8 === undefined
      || value3711t9 === undefined
      || value3711t10 === undefined
    ) {
      setResponseValue371('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3711t6, 10)) === false
      || Number.isInteger(parseInt(value3711t7, 10)) === false
      || Number.isInteger(parseInt(value3711t8, 10)) === false
      || Number.isInteger(parseInt(value3711t9, 10)) === false
      || Number.isInteger(parseInt(value3711t10, 10)) === false
    ) {
      setResponseValue371('Input should be an Integer');
    } else if (
      value3711t6 !== ''
      && value3711t7 !== ''
      && value3711t8 !== ''
      && value3711t9 !== ''
      && value3711t10 !== ''
    ) {
      setResponseValue371(
        (parseInt(value3711t6, 10)
          + parseInt(value3711t7, 10)
          + parseInt(value3711t8, 10)
          + parseInt(value3711t9, 10)
          + parseInt(value3711t10, 10))
          / 5
      );
    }
  }
  function onClickingViewResponse372() {
    if (
      value3721t6 === ''
      || value3721t7 === ''
      || value3721t8 === ''
      || value3721t9 === ''
      || value3721t10 === ''
      || value3721t6 === undefined
      || value3721t7 === undefined
      || value3721t8 === undefined
      || value3721t9 === undefined
      || value3721t10 === undefined
    ) {
      setResponseValue372('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3721t6, 10)) === false
      || Number.isInteger(parseInt(value3721t7, 10)) === false
      || Number.isInteger(parseInt(value3721t8, 10)) === false
      || Number.isInteger(parseInt(value3721t9, 10)) === false
      || Number.isInteger(parseInt(value3721t10, 10)) === false
    ) {
      setResponseValue372('Input should be an Integer');
    } else if (
      value3721t6 !== ''
      && value3721t7 !== ''
      && value3721t8 !== ''
      && value3721t9 !== ''
      && value3721t10 !== ''
    ) {
      setResponseValue372(
        parseInt(value3721t6, 10)
          + parseInt(value3721t7, 10)
          + parseInt(value3721t8, 10)
          + parseInt(value3721t9, 10)
          + parseInt(value3721t10, 10)
      );
    }
  }

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

  const financialYear = "2021-2022";
  const inputDataList = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    criteria37Qn: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 201,
        response371: responseValue371,
        response372: responseValue372,
        criteria37status: "save",
      },
    ],

    yearTable3711: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 201,
        input3711y: value3711t1,
        input3711v: value3711t6,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 202,
        input3711y: value3711t2,
        input3711v: value3711t7,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 203,
        input3711y: value3711t3,
        input3711v: value3711t8,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 204,
        input3711y: value3711t4,
        input3711v: value3711t9,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 205,
        input3711y: value3711t5,
        input3711v: value3711t10,
      },
    ],

    yearTable3721: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 201,
        input3721y: value3721t1,
        input3721v: value3721t6,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 202,
        input3721y: value3721t2,
        input3721v: value3721t7,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 203,
        input3721y: value3721t3,
        input3721v: value3721t8,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 204,
        input3721y: value3721t4,
        input3721v: value3721t9,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 205,
        input3721y: value3721t5,
        input3721v: value3721t10,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form37Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form37Data.append("criteria3Fieldinfo", jsonBlob(inputDataList));
    if (pathValue3711f1 !== "") {
      form37Data.append(
        "uploadfile3",
        value3711f1,
        "f3711f1-" + value3711f1.name
      );
    }
    if (pathValue3711f2 !== "") {
      form37Data.append(
        "uploadfile3",
        value3711f2,
        "f3711f2-" + value3711f2.name
      );
    }
    if (pathValue3711f3 !== "") {
      form37Data.append(
        "uploadfile3",
        value3711f3,
        "f3711f3-" + value3711f3.name
      );
    }
    if (pathValue3721f1 !== "") {
      form37Data.append(
        "uploadfile3",
        value3721f1,
        "f3721f1-" + value3721f1.name
      );
    }
    if (pathValue3721f2 !== "") {
      form37Data.append(
        "uploadfile3",
        value3721f2,
        "f3721f2-" + value3721f2.name
      );
    }
    if (pathValue3721f3 !== "") {
      form37Data.append(
        "uploadfile3",
        value3721f3,
        "f3721f3-" + value3721f3.name
      );
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form37Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria3upload",
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
      fileReader.addEventListener("load", (event) => {
        setFilePreviewSrc111f1(event.target.result);
      });
    }
  }
  return (
    <div className="c33-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c33x-colorIndicator-container">
        <p className="c33x-QlcolorIndicator-circle-style"></p>
        <span className="c33x-colorIndicator-span-style">Qualitative</span>
        <p className="c33x-QtcolorIndicator-circle-style"></p>
        <span className="c33x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c36x-weightage-heading-style">
            Key Indicator Weightage: 20
          </h1>
        </div>
      </div>

      {/* Key Indicator: 3.7.1 */}
      <div className="c37x-eachInputField-container">
        <div className="c37x-weightage-container">
          <h1 className="c37x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c37x-container">
            <div className="c37x-heading_Help-container">
              <h1 className="c37x-heading-style">
                <span className="c37x-span-style">3.7.1: </span>
                Number of functional MoUs /linkage with institutions/ industries
                in India and abroad for internship, on-the-job training, project
                work, student / faculty exchange and collaborative research
                during the last five years
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
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            <div className="c37x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus371(!responseButtonStatus371);
                  onClickingViewResponse371();
                }}
                className="c37x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus371 ? (
                <p className="c37x-responseResult-style">{responseValue371}</p>
              ) : null}
            </div>
          </div>
          <div className="c37xx-container">
            <h1 className="c37xx-Heading-style">
              <span className="c37xx-span-style">3.7.1.1: </span>
              Total number of Collaborative activities with other
              institution/establishment/industry for research and academic
              development of facultyand students year-wise during the last five
              years
              <input
                onChange={(e) => setValue1212t1(e.target.value)}
                id="1212-t1"
                style={{ width: "25%", marginLeft: "68%" }}
                type="number"
              />
            </h1>

            <table className="c37x-table-style">
              <tr>
                <th className="c37x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c37x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c37x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c37x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                  List and Copies of documents indicating the functiona
                  MoUs/linkage/collaboration activity-wise and year-wise
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3711f1(e.target.files[0]);
                      setPathValue3711f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3711-f1"
                    type="file"
                    className="c37-fileButton-style"
                  />
                  {pathValue3711f1 === "" ? null : (
                    <div className="c37-fileButtons-container">
                      <button className="c37-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue3711f1("");
                          document.getElementById("3711-f1").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c37x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Summary of the functional MoUs/linkage/collaboration
                  indicating start date, end date, nature of collaboration etc.
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3711f2(e.target.files[0]);
                      setPathValue3711f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3711-f2"
                    type="file"
                    className="c37-fileButton-style"
                  />
                  {pathValue3711f2 === "" ? null : (
                    <div className="c37-fileButtons-container">
                      <button className="c37-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue3711f2("");
                          document.getElementById("3711-f2").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c37x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List of year wise activities and exchange should be provided
                </td>
                <td>
                <a href={downloadFile("un3.7.1.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue3711f3(e.target.files[0]);
                      setPathValue3711f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="3711-f3"
                    type="file"
                    className="c37-fileButton-style"
                  />
                  {pathValue3711f3 === "" ? null : (
                    <div className="c37-fileButtons-container">
                      <button className="c37-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue3711f3("");
                          document.getElementById("3711-f3").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c37x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      <div className="c37x-button-container">
        <button onClick={onClickingSave} className="c37x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria37;
