import React, { useState, useEffect } from "react";
import "./c61-style.css";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
// Help buttons functionality
function Help611(props) {
  return props.isHelp611Clicked ? (
    <div className="c61x-help-mainContainer">
      <div className="c61x-help-subContainer">
        <h1 className="c61x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c61x-help-para-style">
          Describe the vision and mission statement of the institution on the
          nature of governance, perspective plans and participation of the
          teachers in the decision making bodies of the institution within a
          maximum of 500 words..
        </p>
        <button
          className="c61x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp611Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help612(props) {
  return props.isHelp612Clicked ? (
    <div className="c61x-help-mainContainer">
      <div className="c61x-help-subContainer">
        <h1 className="c61x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c61x-help-para-style">
          <span style={{ fontWeight: "bold" }}></span>
          <span style={{ fontWeight: "bold" }}></span>
          Upload a case study showing practicing decentralization and
          participative management in the institution in not more than 500
          words.
        </p>
        <button
          className="c61x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp612Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria61() {
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
  const [value611t1, setValue611t1] = useState();
  const [responseValue611, setResponseValue611] = useState("");

  const [value611f1, setValue611f1] = useState();
  const [pathValue611f1, setPathValue611f1] = useState("");
  const [value611f2, setValue611f2] = useState();
  const [pathValue611f2, setPathValue611f2] = useState("");

  const [value612t1, setValue612t1] = useState();
  const [value612f1, setValue612f1] = useState();
  const [pathValue612f1, setPathValue612f1] = useState("");

  const [value612f2, setValue612f2] = useState();
  const [pathValue612f2, setPathValue612f2] = useState("");
  const [value612f3, setValue612f3] = useState();
  const [pathValue612f3, setPathValue612f3] = useState("");
  const [responseValue612, setResponseValue612] = useState("");

  const [help611Status, setHelp611Status] = useState(false);
  const [help612Status, setHelp612Status] = useState(false);

  // getfile data with API

  function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
  }
  //get data api
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
        resources.APPLICATION_URL+'criteria6getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setValue611t1(data[0].criteria61Ql[0] ? data[0].criteria61Ql[0].input611t1 : "");
            setValue612t1(data[0].criteria61Ql[0] ? data[0].criteria61Ql[0].input612t1 : "");

            setValue611f1(data[0].criteria6FileUpload[0] ? data[0].criteria6FileUpload[0].criteria6FileName : "");
            setValue611f2(data[0].criteria6FileUpload[1] ? data[0].criteria6FileUpload[1].criteria6FileName : "");
            setValue612f1(data[0].criteria6FileUpload[2] ? data[0].criteria6FileUpload[2].criteria6FileName : "");
            setValue612f2(data[0].criteria6FileUpload[3] ? data[0].criteria6FileUpload[3].criteria6FileName : "");
            setValue612f3(data[0].criteria6FileUpload[4] ? data[0].criteria6FileUpload[4].criteria6FileName : "");
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );
  // sending data to db with API

  const inputDataList = {
           criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    criteria61Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input611t1: value611t1,
        response611: responseValue611,
        input612t1: value612t1,
        response612: responseValue612,
      },
    ],
  };

  // rendering DOM
  return (
    <div className="c61-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c61x-colorIndicator-container">
        <p className="c61x-QlcolorIndicator-circle-style"></p>
        <span className="c61x-colorIndicator-span-style">Qualitative</span>
        <p className="c61x-QtcolorIndicator-circle-style"></p>
        <span className="c61x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c61x-weightage-heading-style">
            Key Indicator Weightage: 10
          </h1>
        </div>
      </div>

      {/* Key Indicator: 6.1.1 */}
      <div className="c61x-eachInputField-container">
        <div className="c61x-weightage-container">
          <h1 className="c61x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c61x-Ql-label-textarea-container">
            <div className="c61x-heading_Help-container">
              <h1 className="c61x-heading-style">
                <span className="c61x-span-style">6.1.1: </span>
                The Institutional governance and leadership are in accordance with
                   Vision and mission of the institution and it is visible in various
                institutional practices such as NEP implementation, sustained
                institutional growth, de-centralization, participation in the institutional
              governance and in their Short term/ Long term institutional perspective
                  plan.
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
            <label htmlFor="611-t1" className="c61x-label-style">
              Response:
            </label>
            <textarea
              readOnly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue611t1(e.target.value);
                setResponseValue611(e.target.value);
              }}
              value={value611t1}
              rows={10}
              className="c61x-textarea-style"
              id="611-t1"
            ></textarea>
            {value611t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c61x-Ql-table-style">
            <tr>
              <th className="c61x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c61x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c61x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c61x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c61x-Ql-tableBorders-style">
                Paste link for additional Information
              </td>
              <td className="c61x-Ql-tableBorders-style"></td>
              <td className="c61x-Ql-tableBorders-style">
                <a href={downloadFile(value611f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c61x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c61x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c61x-Ql-tableBorders-style">
                <a target="_blank" href="./Criteria-6/c61/GEETHANJALI_SSR.pdf">
                  View Template
                </a>
              </td>
              <td className="c61x-Ql-tableBorders-style">
                <a href={downloadFile(value611f2)} target="_blank">
                  view
                </a>
              </td>
              <td className="c61x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 6.1.2 */}
      {/* <div className="c61x-eachInputField-container">
        <div className="c61x-weightage-container">
          <h1 className="c61x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c61x-Ql-label-textarea-container">
            <div className="c61x-heading_Help-container">
              <h1 className="c61x-heading-style">
                <span className="c61x-span-style">6.1.2: </span>
                The effective leadership is reflected in various institutional
                practices such as decentralization and participative management.
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp612Status(true);
                }}
                className="c61x-helpButton-style"
              >
                Help
              </button>
              <Help612
                isHelp612Clicked={help612Status}
                setIsHelp612Clicked={setHelp612Status}
              />
            </div>
            <label htmlFor="612-t1" className="c61x-label-style">
              Response:
            </label>
            <textarea
              readOnly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue612t1(e.target.value);
              }}
              value={value612t1}
              rows={10}
              className="c61x-textarea-style"
              id="612-t1"
            ></textarea>
            {value612t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c61x-Ql-table-style">
            <tr>
              <th className="c61x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c61x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c61x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c61x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c61x-Ql-tableBorders-style">
                Strategic plan and deployment documents on the website
              </td>
              <td className="c61x-Ql-tableBorders-style"></td>
              <td className="c61x-Ql-tableBorders-style">
                <a href={downloadFile(value612f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c61x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c61x-Ql-tableBorders-style">
                Paste link for additional Information
              </td>
              <td className="c61x-Ql-tableBorders-style">
                <a target="_blank" href="./Criteria-6/c61/GEETHANJALI_SSR.pdf">
                  View Template
                </a>
              </td>
              <td className="c61x-Ql-tableBorders-style">
                <a href={downloadFile(value612f2)} target="_blank">
                  view
                </a>
              </td>
              <td className="c61x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c61x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c61x-Ql-tableBorders-style">
                <a target="_blank" href="./Criteria-6/c61/GEETHANJALI_SSR.pdf">
                  View Template
                </a>
              </td>
              <td className="c61x-Ql-tableBorders-style">
                <a href={downloadFile(value612f3)} target="_blank">
                  view
                </a>
              </td>
              <td className="c61x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div> */}
    </div>
  );
}

export default Criteria61;
