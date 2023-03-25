import React, { useState, useEffect } from "react";
import "./c65-style.css";
import { toast } from "react-toastify";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
import { resources } from "../../../../../appConstants";
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

// Help buttons functionality
function Help651(props) {
  return props.isHelp651Clicked ? (
    <div className="c65x-help-mainContainer">
      <div className="c65x-help-subContainer">
        <h1 className="c65x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c65x-help-para-style">
          Describe two practices institutionalized as a result of IQAC
          initiatives within a maximum of 500 words
        </p>
        <button
          className="c65x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp651Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help652(props) {
  return props.isHelp652Clicked ? (
    <div className="c65x-help-mainContainer">
      <div className="c65x-help-subContainer">
        <h1 className="c65x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c65x-help-para-style">
          Describe two practices institutionalized as a result of IQAC
          initiatives within a maximum of 500 word
        </p>
        <button
          className="c65x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp652Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help653(props) {
  return props.isHelp653Clicked ? (
    <div className="c65x-help-mainContainer">
      <div className="c65x-help-subContainer">
        <h1 className="c65x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c65x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span>The total amount of seed
          money provided by institution to its teachers for research in the last
          five years
          <span style={{ fontWeight: "bold" }}>) /</span>
        </p>
        <button
          className="c65x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp653Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria65() {
  // getfile data with API
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
 //help buttom
  const [isOpen, setIsopen] = useState(false)
  const [isOpen2,setIsopen2] = useState(false)
  const [isOpen3,setIsopen3] = useState(false)
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
  const handleHelpOpen3 =(e)=>{
    e.preventDefault();
    setIsopen3(true)
  } 
  const handleHelpClose3 = (e)=>{
    setIsopen3(false)
  }
  // state variables
  const [value651t1, setValue651t1] = useState();
  const [value651t2, setValue651t2] = useState();
  const [value651f1, setValue651f1] = useState();
  const [pathValue651f1, setPathValue651f1] = useState("");
  const [value651f2, setValue651f2] = useState();
  const [pathValue651f2, setPathValue651f2] = useState("");
  const [responseValue651, setResponseValue651] = useState("");

  const [value652t1, setValue652t1] = useState();

  const [value652f1, setValue652f1] = useState();
  const [pathValue652f1, setPathValue652f1] = useState("");
  const [value652f2, setValue652f2] = useState();
  const [pathValue652f2, setPathValue652f2] = useState("");
  const [responseValue652, setResponseValue652] = useState("");

  const [value653t1, setValue653t1] = useState();
  const [value653f1, setValue653f1] = useState("");
  const [pathValue653f1, setPathValue653f1] = useState("");
  const [value653f2, setValue653f2] = useState("");
  const [pathValue653f2, setPathValue653f2] = useState("");
  const [value653f3, setValue653f3] = useState("");
  const [pathValue653f3, setPathValue653f3] = useState("");
  const [value653f4, setValue653f4] = useState("");
  const [pathValue653f4, setPathValue653f4] = useState("");
  const [responseButtonStatus653, setResponseButtonStatus653] = useState(false);
  const [responseValue653, setResponseValue653] = useState("");

  const [help651Status, setHelp651Status] = useState(false);
  const [help652Status, setHelp652Status] = useState(false);
  const [help653Status, setHelp653Status] = useState(false);

  //get data
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
        resources.APPLICATION_URL+"criteria6getallfiles?collegeId=1&financialYear=" +
          financialYear +
          "&typeofInstitution=autonomous"
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(inputDataList));

            setValue651t1(data[0].criteria65Ql[0].input651t1);
            setValue652t1(data[0].criteria65Ql[0].input652t1);
            setValue653t1(data[0].criteria65Qn[0].input653t1);

            // setValue651f1(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue651f2(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue652f1(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue652f2(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue653f1(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue653f2(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue653f3(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue653f4(data[0].criteria6FileUpload[0].criteria6FileName);
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );

  // sending data to db with API

  const inputDataList = {
    criteriaId: {
      collegeId: "1",
      financialYear: financialYear,
      typeofInstitution: "autonomous",
    },
    criteria65Ql: [
      {
        criteriaId: {
          collegeId: "1",
          financialYear: financialYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 1,
        input651t1: value651t1,
        response651: responseValue651,
        input652t1: value652t1,
        response652: responseValue652,
      },
    ],
    criteria65Qn: [
      {
        criteriaId: {
          collegeId: "1",
          financialYear: financialYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 1,
        input653t1: value653t1,
        response653: responseValue653,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  // getfile data with API

  function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
  }

  return (
    <div className="c65-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c65x-colorIndicator-container">
        <p className="c65x-QlcolorIndicator-circle-style"></p>
        <span className="c65x-colorIndicator-span-style">Qualitative</span>
        <p className="c65x-QtcolorIndicator-circle-style"></p>
        <span className="c65x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c65x-weightage-heading-style">
            Key Indicator Weightage: 35
          </h1>
        </div>
      </div>

      {/* Key Indicator: 6.5.1 */}
      <div className="c65x-eachInputField-container">
        <div className="c65x-weightage-container">
          <h1 className="c65x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c65x-Ql-label-textarea-container">
            <div className="c65x-heading_Help-container">
              <h1 className="c65x-heading-style">
                <span className="c65x-span-style">6.5.1: </span>
                Internal Quality Assurance Cell (IQAC) has contributed 
                significantly for institutionalizing the quality assurance strategies 
             and processes visible in terms of –
Incremental improvements made for the preceding five years with 
regard to quality (in case of first cycle)
Incremental improvements made for the preceding five years with 
regard to quality and post accreditation quality initiatives (second 
and subsequent cycles)
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
            <label htmlFor="651-t1" className="c51x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue651t1(e.target.value);
                setResponseValue651(e.target.value);
              }}
              value={value651t1}
              rows={10}
              className="c65x-textarea-style"
              id="651-t1"
            ></textarea>
            {value651t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c65x-Ql-table-style">
            <tr>
              <th className="c65x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c65x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c65x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c65x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c65x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c65x-Ql-tableBorders-style"></td>
              <td className="c65x-Ql-tableBorders-style">
                <input readonly
                  onChange={(e) => {
                    setValue651f1(e.target.files[0]);
                    setPathValue651f1(e.target.value);
                  }}
                  id="651-f1"
                  type="file"
                  className="c65-fileButton-style"
                />
                {pathValue651f1 === "" ? null : (
                  <div className="c65-fileButtons-container">
                    <button className="c65-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue651f1("");
                        document.getElementById("651-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value651f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">

                  </button>
                </div> */}
              </td>
              <td className="c65x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c65x-Ql-tableBorders-style">
                Paste link for additional Information
              </td>
              <td className="c65x-Ql-tableBorders-style"></td>
              <td className="c65x-Ql-tableBorders-style">
                <input readonly
                  onChange={(e) => {
                    setValue651f2(e.target.files[0]);
                    setPathValue651f2(e.target.value);
                  }}
                  id="651-f2"
                  type="file"
                  className="c65-fileButton-style"
                />
                {pathValue651f2 === "" ? null : (
                  <div className="c65-fileButtons-container">
                    <button className="c65-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue651f2("");
                        document.getElementById("651-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value651f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">

                  </button>
                </div> */}
              </td>
              <td className="c65x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 6.5.2 */}
      <div className="c65x-eachInputField-container">
        <div className="c65x-weightage-container">
          <h1 className="c65x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c65x-Ql-label-textarea-container">
            <div className="c65x-heading_Help-container">
              <h1 className="c65x-heading-style">
                <span className="c65x-span-style">6.5.2: </span>
                The institution reviews its teaching learning process, structures & 
                methodologies of operations and learning outcomes at periodic 
              intervals through IQAC set up as per norms
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
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <label htmlFor="652-t1" className="c51x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue652t1(e.target.value);
                setResponseValue652(e.target.value);
              }}
              value={value652t1}
              rows={10}
              className="c65x-textarea-style"
              id="652-t1"
            ></textarea>
            {value652t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c65x-Ql-table-style">
            <tr>
              <th className="c65x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c65x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c65x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c65x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c65x-Ql-tableBorders-style">
                Strategic Plan and deployment documents on the website
              </td>
              <td></td>
              <td className="c65x-Ql-tableBorders-style">
                <input readonly
                  onChange={(e) => {
                    setValue652f1(e.target.files[0]);
                    setPathValue652f1(e.target.value);
                  }}
                  id="652-f1"
                  type="file"
                  className="c65-fileButton-style"
                />
                {pathValue652f1 === "" ? null : (
                  <div className="c65-fileButtons-container">
                    <button className="c65-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue652f1("");
                        document.getElementById("652-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value652f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c65x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c65x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c65x-Ql-tableBorders-style">
                {/* <a href="http://localhost:8080/api/v1/download/criteria6.5.2.xlsx">
                  View Template
                </a> */}
              </td>
              <td className="c65x-Ql-tableBorders-style">
                <input readonly
                  onChange={(e) => {
                    setValue652f2(e.target.files[0]);
                    setPathValue652f2(e.target.value);
                  }}
                  id="652-f2"
                  type="file"
                  className="c65-fileButton-style"
                />
                {pathValue652f2 === "" ? null : (
                  <div className="c65-fileButtons-container">
                    <button className="c65-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue652f2("");
                        document.getElementById("652-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value652f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c65x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 6.5.3 */}
      <div className="c65x-eachInputField-container">
        <div className="c65x-weightage-container">
          <h1 className="c65x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c65x-container">
            <div className="c65x-heading_Help-container">
              <div>
                <h1 className="c65x-heading-style">
                  <span className="c65x-span-style">6.5.3: </span>
                  Quality assurance initiatives of the institution include::
                </h1>
                <p className="c65x-para-style">
                  1. Regular meeting of Internal Quality Assurance Cell (IQAC); 
quality improvement initiatives identified and implemented

                  <br />
                  2. Academic and Administrative Audit (AAA) and follow-up 
action taken
                  <br />
                  3. Collaborative quality initiatives with other institution(s)
                  <br />
                  4.  Participation in NIRF and other recognized rankings
                  <br />
                  5. Any other quality audit recognized by state, national or 
international agencies 

                </p>
                <div className="c65x-radio-container">
                  <div
                    className="c65x-radio-subContainer"
                    style={{ width: "45%" }}
                  >
                    <div className="c65x-eachRadio-container">
                      <input readonly
                        name="653options"
                        id="653-t1"
                        type="radio"
                        onChange={(e) => {
                          setValue653t1(e.target.value);
                        }}
                        value=" A. Any 4 or more of the above"
                      />

                      <label className="c65x-radioLabel-style" for="653-t1">
                      A. Any 4 or more of the above
                      </label>
                    </div>

                    <div className="c65x-eachRadio-container">
                      <input readonly
                        name="653options"
                        id="653-t2"
                        type="radio"
                        onChange={(e) => {
                          setValue653t1(e.target.value);
                        }}
                        value="  B. Any 3 of the above"
                      />

                      <label className="c65x-radioLabel-style" for="623-t2">
                      B. Any 3 of the above
                      </label>
                    </div>

                    <div className="c65x-eachRadio-container">
                      <input readonly
                        name="653options"
                        id="653-t3"
                        type="radio"
                        onChange={(e) => {
                          setValue653t1(e.target.value);
                        }}
                        value="C. Any 2 of the above "
                      />

                      <label className="c65x-radioLabel-style" for="653-t3">
                      C. Any 2 of the above 
                      </label>
                    </div>
                  </div>

                  <div className="c65x-radio-subContainer">
                    <div className="c65x-eachRadio-container">
                      <input readonly
                        name="653options"
                        id="653-t4"
                        type="radio"
                        onChange={(e) => {
                          setValue653t1(e.target.value);
                        }}
                        value=" D. Any 1 of the above"
                      />

                      <label className="c65x-radioLabel-style" for="653-t4">
                      D. Any 1 of the above
                      </label>
                    </div>

                    <div className="c65x-eachRadio-container">
                      <input readonly
                        name="653options"
                        id="653-t5"
                        type="radio"
                        onChange={(e) => {
                          setValue653t1(e.target.value);
                        }}
                        value="  E. None of the above"
                      />

                      <label className="c65x-radioLabel-style" for="623-t5">
                       E. None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen3}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen3}
                handleClose={handleHelpClose3}
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            <div className="c65x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus653(!responseButtonStatus653);
                  onClickingViewResponse653();
                }}
                className="c65x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus653 ? (
                <p className="c65x-responseResult-style">{responseValue653}</p>
              ) : null}
            </div>
          </div>
          <table className="c65x-table-style">
            <tr>
              <th className="c65x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c65x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c65x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c65x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Paste web link of Annual reports of Institution</td>
              <td></td>
              <td>
                <input readonly
                  onChange={(e) => {
                    setValue653f1(e.target.files[0]);
                    setPathValue653f1(e.target.value);
                  }}
                  id="653-f1"
                  className="c65x-input-style"
                  type="file"
                />
                {pathValue653f1 === "" ? null : (
                  <div className="c65-fileButtons-container">
                    <button className="c65-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue653f1("");
                        document.getElementById("653-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value652f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c65x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Upload e-copies of the accreditations and certifications</td>
              <td></td>
              <td>
                <input readonly
                  onChange={(e) => {
                    setValue653f2(e.target.files[0]);
                    setPathValue653f2(e.target.value);
                  }}
                  id="653-f2"
                  type="file"
                  className="c65-fileButton-style"
                />
                {pathValue653f2 === "" ? null : (
                  <div className="c65-fileButtons-container">
                    <button className="c65-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue653f2("");
                        document.getElementById("653-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value653f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c65x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any additional information</td>
              <td></td>
              <td>
                <input readonly
                  onChange={(e) => {
                    setValue653f3(e.target.files[0]);
                    setPathValue653f3(e.target.value);
                  }}
                  id="653-f3"
                  type="file"
                  className="c65-fileButton-style"
                />
                {pathValue653f3 === "" ? null : (
                  <div className="c65-fileButtons-container">
                    <button className="c65-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue653f3("");
                        document.getElementById("653-f3").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value653f3)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c65x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Upload details of quality assurance initiatives of the
                institution
              </td>
              <td></td>
              <td>
                <input readonly
                  onChange={(e) => {
                    setValue653f4(e.target.files[0]);
                    setPathValue653f4(e.target.value);
                  }}
                  id="653-f4"
                  type="file"
                  className="c65-fileButton-style"
                />
                {pathValue653f4 === "" ? null : (
                  <div className="c65-fileButtons-container">
                    <button className="c65-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue653f4("");
                        document.getElementById("653-f4").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value653f4)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">

                  </button>
                </div> */}
              </td>
              <td className="c65x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  );
}

export default Criteria65;
