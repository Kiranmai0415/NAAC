import React, { useState, useEffect } from "react";
import "./c26-style.css";
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
          <span style={{ fontWeight: "bold" }}>(</span>The Total number final
          year students who passed in the examination
          <span style={{ fontWeight: "bold" }}>/</span>The total number of final
          year students who appeared for the examination
          <span style={{ fontWeight: "bold" }}>) *</span> 100
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
const [isOpen3, setIsopen3] = useState(false)
const [isOpen2,setIsopen2] = useState(false)
const handleHelpOpen = (e) => {
  e.preventDefault(),
  setIsopen(true)
}
const handleHelpClose = () => {
  setIsopen(false)
}
const handleHelpOpen3 = (e) => {
  e.preventDefault(),
  setIsopen3(true)
}
const handleHelpClose3 = () => {
  setIsopen3(false)
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

  const [pathValue261f1, setPathValue261f1] = useState("");
  const [value261f1, setValue261f1] = useState([]);
  const [pathValue261f2, setPathValue261f2] = useState("");
  const [value261f2, setValue261f2] = useState([]);
  const [pathValue261f3, setPathValue261f3] = useState("");
  const [value261f3, setValue261f3] = useState([]);

  const [pathValue262f1, setPathValue262f1] = useState("");
  const [value262f1, setValue262f1] = useState([]);
  const [pathValue262f2, setPathValue262f2] = useState("");
  const [value262f2, setValue262f2] = useState([]);

  const [value2632t1, setValue2632t1] = useState();
  const [value2631t1, setValue2631t1] = useState();
  const [pathValue2632f1, setPathValue2632f1] = useState("");
  const [value2632f1, setValue2632f1] = useState([]);
  const [pathValue2632f2, setPathValue2632f2] = useState("");
  const [value2632f2, setValue2632f2] = useState([]);
  const [pathValue2632f3, setPathValue2632f3] = useState("");
  const [value2632f3, setValue2632f3] = useState([]);
  const [responseButtonStatus263, setResponseButtonStatus263] = useState(false);
  const [responseValue261, setResponseValue261] = useState("");
  const [responseValue262, setResponseValue262] = useState("");
  const [responseValue263, setResponseValue263] = useState("");
  const [help261Status, setHelp261Status] = useState(false);
  const [help262Status, setHelp262Status] = useState(false);
  const [help263Status, setHelp263Status] = useState(false);

  // response button functionality
  function onClickingViewResponse263() {
    if (value2631t1 === "" || value2632t1 === "") {
      setResponseValue263("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value2631t1, 10)) === false ||
      Number.isInteger(parseInt(value2632t1, 10)) === false
    ) {
      setResponseValue263("Input should be an Integer");
    } else if (value2631t1 !== "" && value2632t1 !== "") {
      setResponseValue263(
        (parseInt(value2631t1, 10) / parseInt(value2632t1, 10)) * 100
      );
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
  

  //get data api
  const financialYear = "2021-2022";
  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+"criteria2getallfiles?collegeId=" +
          collegeId +
          "&financialYear=" +
          fYear +
          "&typeofInstitution=" +
          instituteType
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setValue261t1(data[0].criteria26Ql[0] ? data[0].criteria26Ql[0].input261t1 : "");
            setValue262t1(data[0].criteria26Ql[0] ? data[0].criteria26Ql[0].input262t1 : "");

            setValue2631t1(data[0].criteria26Qn[0] ? data[0].criteria26Qn[0].input2631t1 : "");
            setValue2632t1(data[0].criteria26Qn[0] ? data[0].criteria26Qn[0].input2632t1 : "");
            // setResponseValue111(data[0].criteria1FieldInfoQl[1].response111);
            // setResponseValue112(data[0].criteria1FieldInfoQn[2].response112);
            // setResponseValue113(data[0].criteria1FieldInfoQn[3].response113);

            setValue2632f1(data[0].criteria2FileUpload[0] ? data[0].criteria2FileUpload[0].criteria2FileName : "");
            setValue2632f2(data[0].criteria2FileUpload[1] ? data[0].criteria2FileUpload[1].criteria2FileName : "");
            setValue262f1(data[0].criteria2FileUpload[3] ? data[0].criteria2FileUpload[3].criteria2FileName : "");
            setValue262f2(data[0].criteria2FileUpload[4] ? data[0].criteria2FileUpload[4].criteria2FileName : "");
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
    <div className="c26-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c26x-colorIndicator-container">
        <p className="c26x-QlcolorIndicator-circle-style"></p>
        <span className="c26x-colorIndicator-span-style">Qualitative</span>
        <p className="c26x-QtcolorIndicator-circle-style"></p>
        <span className="c26x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
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
                outcomes)/graduate attributes which are integrated into the
                assessment process and widely publicized through the website and
                other documents and the attainment of the same are evaluated by
                the institution
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
            <label htmlFor="263-t1" className="c26x-label-style">
              Response:
            </label>
            <textarea
              readOnly
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
            {value261t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
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
                  <a href={downloadFile(value261f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Link for Additional Information</td>
                <td></td>
                <td>
                  <a href={downloadFile(value261f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload COs for all courses (exemplars from Glossary)</td>
                <td></td>
                <td>
                  <a href={downloadFile(value261f3)} target="_blank">
                    view
                  </a>
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
                <span className="c26x-label-style">2.6.2.1: </span>
                Total number of final year students who passed the examination
                conducted by Institution
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
                >(?????????? ???????????? ???? ?????????? ???????? ???????????????? ?????? ???????????? ???? ?????? ???????????????????? ??????????????????????)/((??.??) ???????????? ???? ?????????? ????????-???????????????? ???????????????? (???????????? ?????????????????? ????????)) * 100</HelpButton>
            </div>
            <label htmlFor="262-t1" className="c26x-label-style">
              Response:
            </label>
            <textarea
              readOnly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue262t1(e.target.value);
                setResponseValue262(e.target.value);
              }}
              value={value262t1}
              rows={10}
              className="c26x-textarea-style"
              id="262-t1"
            ></textarea>
            {value262t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
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
                <td><a href={downloadFile("un2.6.2.xlsx")} target="_blank">view Template </a></td>
                <td>
                  <a href={downloadFile(value262f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Link for additional information</td>
                <td></td>
                <td>
                  <a href={downloadFile(value262f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 2.6.3 */}
      {/* <div className="c26x-eachInputField-container">
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
                onClick={handleHelpOpen}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='formula'
                ><h1>(?????????? ???????????? ???? ?????????? ???????? ???????????????? ?????? ???????????? ???? ?????? ???????????????????? ??????????????????????)/((??.??) ???????????? ???? ?????????? ????????-???????????????? ???????????????? (???????????? ?????????????????? ????????)) * 100</h1></HelpButton>
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
              readOnly
              onChange={(e) => setValue2631t1(e.target.value)}
              id="2631-t1"
              style={{ marginLeft: "4%" }}
              type="text"
            />
            <h1 className="c26xx-Heading-style">
              <span className="c26xx-span-style">2.6.3.2: </span>
              Total number of final year students who attended the examination
              conducted by Institution.
            </h1>
            <input
              readOnly
              onChange={(e) => setValue2632t1(e.target.value)}
              id="2632-t1"
              style={{ marginLeft: "4%" }}
              type="text"
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
                <a href={downloadFile("un2.6.3.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <a href={downloadFile(value2632f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <a href={downloadFile(value2632f2)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Paste link for annual report</td>
                <td></td>
                <td>
                  <a href={downloadFile(value2632f3)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c26x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div> */}
    </div>
  );
}

export default Criteria26;
