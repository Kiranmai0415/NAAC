import React, { useState,useEffect } from "react";
import "./c22-style.css";
import { toast } from "react-toastify";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
import { resources } from "../../../../../appConstants";
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
  const [pathValue221f1, setPathValue221f1] = useState("");
  const [value221f1, setValue221f1] = useState([]);
  const [pathValue221f2, setPathValue221f2] = useState("");
  const [value221f2, setValue221f2] = useState([]);
  const [value222t1, setValue222t1] = useState();
  const [value222t2, setValue222t2] = useState();
  const [pathValue222f1, setPathValue222f1] = useState("");
  const [value222f1, setValue222f1] = useState([]);
  const [responseValue221, setResponseValue221] = useState("");
  const [responseValue222, setResponseValue222] = useState("");
  const [help221Status, setHelp221Status] = useState(false);
  const [help222Status, setHelp222Status] = useState(false);
  const [responseButtonStatus222, setResponseButtonStatus222] = useState(false);

  // response button functionality

  function onClickingViewResponse222() {
    if (
      value222t1 === "" ||
      value222t2 === "" ||
      value222t1 === undefined ||
      value222t2 === undefined
    ) {
      setResponseValue222("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value222t1, 10)) === false ||
      Number.isInteger(parseInt(value222t2, 10)) === false
    ) {
      setResponseValue222("Input should be an Integer");
    } else if (value222t1 !== "" && value222t2 !== "") {
      setResponseValue222(parseInt(value222t1, 10) / parseInt(value222t2, 10));
    }
  }
  // getfile data with API

  function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
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
  

  
  const financialYear = "2021-2022";
  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria2getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then((response) =>(response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            setValue221t1(data[0].criteria22Qn[0] ? data[0].criteria22Qn[0].input221t1 : "");
            setValue222t1(data[0].criteria22Qn[0] ? data[0].criteria22Qn[0].input222t1 : "");
            setValue222t2(data[0].criteria22Qn[0] ? data[0].criteria22Qn[0].input222t2 : "");
            // setResponseValue111(data[0].criteria1FieldInfoQl[1].response111);
            // setResponseValue112(data[0].criteria1FieldInfoQn[2].response112);
            // setResponseValue113(data[0].criteria1FieldInfoQn[3].response113);
            setValue221f1(data[0].criteria2FileUpload[0] ? data[0].criteria22Qn[0].criteria2FileName : "");
            setValue221f2(data[0].criteria2FileUpload[1] ? data[0].criteria22Qn[0].criteria2FileName : "");
            setValue222f1(data[0].criteria2FileUpload[2] ? data[0].criteria22Qn[0].criteria2FileName : "");
          })
          .catch((error) => {
            console.error("Error:", error);
            errorMessage("Got the Error Please try after sometime");
          })
      ),
    []
  );

  // sending data to db with API

  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    // // criteria22Qn: [
    // //   {
    // //     criteriaId: { collegeId: "1", financialYear: financialYear, typeofInstitution: "universities" },
    // //     uniqueKey1: 2,
    // //     input221t1: value221t1, response221: responseValue221,
    // //   },
    // ],
    criteria22Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input221t1: value221t1,
        response221: responseValue221,
        input222t1: value222t1,
        input222t2: value222t2,
        response222: responseValue222,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
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
            Key Indicator Weightage: 30
          </h1>
        </div>
      </div>

      {/* Key Indicator: 2.2.1 */}
      <div className="c22x-eachInputField-container">
        <div className="c22x-weightage-container">
          <h1 className="c22x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c22x-Ql-label-textarea-container">
            <div className="c22x-heading_Help-container">
              <h1 className="c22x-heading-style">
                <span className="c22x-span-style">2.2.1: </span>
                The institution assesses the learning levels of the students and 
organises special Programmes to cater to differential learning needs 
of the student
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
              readOnly
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
            {value221t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
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
                <a href={downloadFile(value221f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c22x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c22x-Ql-tableBorders-style">
                Upload any Additional Information
              </td>
              <td className="c22x-Ql-tableBorders-style"></td>
              <td className="c22x-Ql-tableBorders-style">
                <a href={downloadFile(value221f2)} target="_blank">
                  view
                </a>
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
                ><h1>(Formula: (1.1) Students : (2.1)Teachers)</h1></HelpButton>
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
                readOnly
                onChange={(e) => setValue222t1(e.target.value)}
                id="222-t1"
                style={{ marginLeft: "4%" }}
                type="text"
              />
            </h1>
            <h1 className="c22xx-Heading-style">
              <span className="c22xx-span-style">B.</span>
              Total number of full time teachers in the institution.
              <input
                readOnly
                onChange={(e) => setValue222t2(e.target.value)}
                id="222-t2"
                style={{ marginLeft: "4%" }}
                type="text"
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
                  <a href={downloadFile(value222f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c22x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Criteria22;
