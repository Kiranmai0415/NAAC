import React, { useState, useEffect } from "react";
import "./c62-style.css";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
import { resources } from "../../../../../appConstants";

// Help buttons functionality
function Help621(props) {
  return props.isHelp621Clicked ? (
    <div className="c62x-help-mainContainer">
      <div className="c62x-help-subContainer">
        <h1 className="c62x-help-heading-style">
          The institutional Strategic/ Perspective plan is effectively deployed
        </h1>
        <p className="c62x-help-para-style">
          Describe one activity successfully implemented based on the strategic
          plan within a maximum of 500 words
        </p>
        <button
          className="c62x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp621Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help622(props) {
  return props.isHelp622Clicked ? (
    <div className="c62x-help-mainContainer">
      <div className="c62x-help-subContainer">
        <h1 className="c62x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c62x-help-para-style">
          <span style={{ fontWeight: "bold" }}></span>
          <span style={{ fontWeight: "bold" }}></span>
          Describe the Organogram of the Institution within a maximum of 500
          words.
        </p>
        <button
          className="c62x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp622Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help623(props) {
  return props.isHelp623Clicked ? (
    <div className="c62x-help-mainContainer">
      <div className="c62x-help-subContainer">
        <h1 className="c62x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c62x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span>The total amount of seed
          money provided by institution to its teachers for research in the last
          five years
          <span style={{ fontWeight: "bold" }}>) /</span>
        </p>
        <button
          className="c62x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp623Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria62() {
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
  const [value621t1, setValue621t1] = useState();
  const [value621f1, setValue621f1] = useState();
  const [pathValue621f1, setPathValue621f1] = useState("");

  const [value621f2, setValue621f2] = useState();
  const [pathValue621f2, setPathValue621f2] = useState("");
  const [value621f3, setValue621f3] = useState();
  const [pathValue621f3, setPathValue621f3] = useState("");
  const [responseValue621, setResponseValue621] = useState("");

  const [value622t1, setValue622t1] = useState();
  const [value622t2, setValue622t2] = useState();
  const [value622t3, setValue622t3] = useState();
  const [value622f1, setValue622f1] = useState("");
  const [pathValue622f1, setPathValue622f1] = useState("");
  const [value622f2, setValue622f2] = useState("");
  const [pathValue622f2, setPathValue622f2] = useState("");
  const [value622f3, setValue622f3] = useState("");
  const [pathValue622f3, setPathValue622f3] = useState("");
  const [responseValue622, setResponseValue622] = useState("");

  const [value623t1, setValue623t1] = useState();
  const [value623f1, setValue623f1] = useState("");
  const [pathValue623f1, setPathValue623f1] = useState("");
  const [value623f2, setValue623f2] = useState("");
  const [pathValue623f2, setPathValue623f2] = useState("");
  const [value623f3, setValue623f3] = useState("");
  const [pathValue623f3, setPathValue623f3] = useState("");
  const [value623f4, setValue623f4] = useState("");
  const [pathValue623f4, setPathValue623f4] = useState("");
  const [responseButtonStatus623, setResponseButtonStatus623] = useState(false);
  const [responseValue623, setResponseValue623] = useState("");

  const [help621Status, setHelp621Status] = useState(false);
  const [help622Status, setHelp622Status] = useState(false);
  const [help623Status, setHelp623Status] = useState(false);

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
            setValue621t1(data[0].criteria62Ql[0] ? data[0].criteria62Ql[0].input621t1 : "");
            setValue622t1(data[0].criteria62Ql[0] ? data[0].criteria62Ql[0].input622t1 : "");
            setValue623t1(data[0].criteria62Qn[0] ? data[0].criteria62Qn[0].input623t1 : "");

            setValue621f1(data[0].criteria6FileUpload[0] ? data[0].criteria6FileUpload[0].criteria6FileName : "");
            setValue621f2(data[0].criteria6FileUpload[1] ? data[0].criteria6FileUpload[1].criteria6FileName : "");
            setValue621f3(data[0].criteria6FileUpload[2] ? data[0].criteria6FileUpload[2].criteria6FileName : "");
            setValue622f1(data[0].criteria6FileUpload[3] ? data[0].criteria6FileUpload[3].criteria6FileName : "");
            setValue622f2(data[0].criteria6FileUpload[4] ? data[0].criteria6FileUpload[4].criteria6FileName : "");
            setValue622f3(data[0].criteria6FileUpload[5] ? data[0].criteria6FileUpload[5].criteria6FileName : "");
            setValue623f1(data[0].criteria6FileUpload[6] ? data[0].criteria6FileUpload[6].criteria6FileName : "");
            setValue623f2(data[0].criteria6FileUpload[7] ? data[0].criteria6FileUpload[7].criteria6FileName : "");
            setValue623f3(data[0].criteria6FileUpload[8] ? data[0].criteria6FileUpload[8].criteria6FileName : "");
            setValue623f4(data[0].criteria6FileUpload[9] ? data[0].criteria6FileUpload[9].criteria6FileName : "");
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

    criteria62Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input621t1: value621t1,
        response621: responseValue621,
        input622t1: value622t1,
        response622: responseValue622,
      },
    ],
    criteria62Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input623t1: value623t1,
        response623: responseValue623,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  // response functionality
  function onClickingViewResponse623(e) {
    e.preventDefault();
    setResponseButtonStatus623(!responseButtonStatus623);
    if (value623t1 === "") {
      setResponseValue623("Please select any option");
    } else {
      setResponseValue623(e.target.value);
    }
  }

  // rendering DOM
  return (
    <div className="c62-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c62x-colorIndicator-container">
        <p className="c62x-QlcolorIndicator-circle-style"></p>
        <span className="c62x-colorIndicator-span-style">Qualitative</span>
        <p className="c62x-QtcolorIndicator-circle-style"></p>
        <span className="c62x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c62x-weightage-heading-style">
            Key Indicator Weightage: 10
          </h1>
        </div>
      </div>

      {/* Key Indicator: 6.2.1 */}
      <div className="c62x-eachInputField-container">
        <div className="c62x-weightage-container">
          <h1 className="c62x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c62x-Ql-label-textarea-container">
            <div className="c62x-heading_Help-container">
              <h1 className="c62x-heading-style">
                <span className="c62x-span-style">6.2.1: </span>
                The institutional perspective plan is effectively deployed and function of
the Institutional bodies are effective and efficient as visible from policies,
administrative set-up, appointment, service rules, procedures etc.
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
            <label htmlFor="621-t1" className="c61x-label-style">
              Response:
            </label>
            <textarea
              readOnly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue621t1(e.target.value);
                setResponseValue621(e.target.value);
              }}
              value={value621t1}
              rows={10}
              className="c62x-textarea-style"
              id="621-t1"
            ></textarea>
            {value621t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c62x-Ql-table-style">
            <tr>
              <th className="c62x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c62x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c62x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c62x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Strategic Plan and deployment documents on the website
              </td>
              <td className="c62x-Ql-tableBorders-style"></td>
              <td className="c62x-Ql-tableBorders-style">
                <a href={downloadFile(value621f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Paste link for additional Information
              </td>
              <td className="c62x-Ql-tableBorders-style"></td>
              <td className="c62x-Ql-tableBorders-style">
                <a href={downloadFile(value621f2)} target="_blank">
                  view
                </a>
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c62x-Ql-tableBorders-style">
               
              </td>
              <td className="c62x-Ql-tableBorders-style">
                <a href={downloadFile(value621f3)} target="_blank">
                  view
                </a>
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 6.2.2 */}
      <div className="c62x-eachInputField-container">
        <div className="c62x-weightage-container">
          <h1 className="c62x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c62x-Ql-label-textarea-container">
            <div className="c62x-heading_Help-container">
              <h1 className="c62x-heading-style">
                <span className="c62x-span-style">6.2.2: </span>
                Institution Implements e-governance in its operations
              </h1>
              <p className="c65x-para-style">
              1. Administration including complaint management
                  <br />
                  2. Finance and Accounts
                  <br />
                  3. Student Admission and Support
                  <br />

                  4. Examinations
                  
                </p>
                <div className="c65x-radio-container" style={{width:"100%"}}>
                  <div className="c65x-radio-subContainer" style={{width:"45%"}}>
                    <div className="c65x-eachRadio-container">
                    <input name="653options" id="653-t3" type="radio" 
                      onChange={(e) => { setValue653t1(e.target.value); }} 
                       value="Any 5 or All of the above"/>

                      <label className="c65x-radioLabel-style" for="653-t1">
                      Any 5 or All of the above
                      </label>
                    </div>

                    <div className="c65x-eachRadio-container">
                    <input name="653options" id="653-t3" type="radio" 
                      onChange={(e) => { setValue653t1(e.target.value); }} 
                      value="Any 4 or All of the above"/>

                      <label className="c65x-radioLabel-style" for="653-t1">
                      Any 4 or All of the above
                      </label>
                    </div>

                    <div className="c65x-eachRadio-container">
                    <input name="653options" id="653-t3" type="radio" 
                      onChange={(e) => { setValue653t1(e.target.value); }}
                       value="Any 3 or All of the above"/>

                      <label className="c65x-radioLabel-style" for="653-t1">
                      Any 3 or All of the above
                      </label>
                    </div>
                  </div>

                  <div className="c65x-radio-subContainer">
                    <div className="c65x-eachRadio-container">
                    <input name="653options" id="653-t3" type="radio" 
                      onChange={(e) => { setValue653t1(e.target.value); }} 
                      value="Any 2 or All of the above"/>

                      <label className="c65x-radioLabel-style" for="653-t1">
                      Any 2 or All of the above
                      </label>
                    </div>

                    <div className="c65x-eachRadio-container">
                      <input name="653options" id="653-t3" type="radio" 
                      onChange={(e) => { setValue653t1(e.target.value); }}
                       value="Any 1 or All of the above"/>
                      <label className="c65x-radioLabel-style" for="653-t3">
                      Any 1 or All of the above
                      </label>
                    </div>
                  </div>
                </div>
                <button
                onClick={handleHelpOpen2}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen2}
                handleClose={handleHelpClose2}
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            <div className="c62x-response-container">
              <button
                onClick={onClickingViewResponse623}
                className="c62x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus623 ? (
                <p className="c62x-responseResult-style">{responseValue623}</p>
              ) : null}
            </div>
          </div>

          <table className="c62x-Ql-table-style">
            <tr>
              <th className="c62x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c62x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c62x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c62x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Paste link for additional Information
              </td>
              <td className="c62x-Ql-tableBorders-style"></td>
              <td className="c62x-Ql-tableBorders-style">
                <a href={downloadFile(value622f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Link to Organogram of the Institution webpage
              </td>
              <td className="c62x-Ql-tableBorders-style">
              <a href={downloadFile("un6.2.2.xlsx")} target="_blank">
              View Template</a>
              </td>
              <td className="c62x-Ql-tableBorders-style">
                <a href={downloadFile(value622f2)} target="_blank">
                  view
                </a>
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c62x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c62x-Ql-tableBorders-style">
             
              </td>
              <td className="c62x-Ql-tableBorders-style">
                <a href={downloadFile(value622f3)} target="_blank">
                  view
                </a>
              </td>
              <td className="c62x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 6.2.3 */}
      {/* <div className="c62x-eachInputField-container">
        <div className="c62x-weightage-container">
          <h1 className="c62x-weightage-heading-style">Weightage: 4</h1>
        </div>
        <form>
          <div className="c62x-container">
            <div className="c62x-heading_Help-container">
              <div>
                <h1 className="c62x-heading-style">
                  <span className="c34x-span-style">6.2.3: </span>
                  Institution Implementation of e-governance in areas of
                  operations
                </h1>
                <p className="c62x-para-style">
                  1. Administration
                  <br />
                  2. Finance and Accounts
                  <br />
                  3. Student Admission and Support
                  <br />
                  4. Examination
                </p>
                <div className="c62x-radio-container">
                  <div className="c62x-radio-subContainer">
                    <div className="c62x-eachRadio-container">
                      <input
                        readOnly
                        name="623options"
                        id="623-t1"
                        type="radio"
                        onChange={(e) => {
                          setValue623t1(e.target.value);
                        }}
                        value="All of the above"
                      />

                      <label className="c62x-radioLabel-style" for="623-t1">
                        All of the above
                      </label>
                    </div>

                    <div className="c62x-eachRadio-container">
                      <input
                        readOnly
                        name="623options"
                        id="623-t2"
                        type="radio"
                        onChange={(e) => {
                          setValue623t1(e.target.value);
                        }}
                        value="Any three of the above"
                      />

                      <label className="c62x-radioLabel-style" for="623-t2">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c62x-eachRadio-container">
                      <input
                        readOnly
                        name="623options"
                        id="623-t3"
                        type="radio"
                        onChange={(e) => {
                          setValue623t1(e.target.value);
                        }}
                        value="Any two of the above"
                      />

                      <label className="c62x-radioLabel-style" for="623-t3">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c62x-radio-subContainer">
                    <div className="c62x-eachRadio-container">
                      <input
                        readOnly
                        name="623options"
                        id="623-t4"
                        type="radio"
                        onChange={(e) => {
                          setValue623t1(e.target.value);
                        }}
                        value="Any one of the above"
                      />

                      <label className="c62x-radioLabel-style" for="623-t4">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c62x-eachRadio-container">
                      <input
                        readOnly
                        name="623options"
                        id="623-t5"
                        type="radio"
                        onChange={(e) => {
                          setValue623t1(e.target.value);
                        }}
                        value="None of the above"
                      />

                      <label className="c62x-radioLabel-style" for="623-t5">
                        None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp623Status(true);
                }}
                className="c62x-helpButton-style"
              >
                Help
              </button>
              <Help623
                isHelp623Clicked={help623Status}
                setIsHelp623Clicked={setHelp623Status}
              />
            </div>
            <div className="c62x-response-container">
              <button
                onClick={onClickingViewResponse623}
                className="c62x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus623 ? (
                <p className="c62x-responseResult-style">{responseValue623}</p>
              ) : null}
            </div>
          </div>
          <table className="c62x-table-style">
            <tr>
              <th className="c62x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c62x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c62x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c62x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>ERP (Enterprise Resource Planning) Document</td>
              <td></td>
              <td>
                <a href={downloadFile(value623f1)} target="_blank">
                  view
                </a>
              </td>
              <td className="c62x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Screen shots of user interfaces</td>
              <td></td>
              <td>
                <a href={downloadFile(value623f2)} target="_blank">
                  view
                </a>
              </td>
              <td className="c62x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any additional information</td>
              <td></td>
              <td>
                <a href={downloadFile(value623f3)} target="_blank">
                  view
                </a>
              </td>
              <td className="c62x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Details of implementation of e-governance in area of operation
              </td>
              <td>
                <a href="http://localhost:8080/api/v1/download/criteria6.2.3.xlsx">
                  View Template
                </a>
              </td>
              <td>
                <a href={downloadFile(value623f4)} target="_blank">
                  view
                </a>
              </td>
              <td className="c62x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div> */}
    </div>
  );
}

export default Criteria62;
