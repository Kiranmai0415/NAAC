import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import "./c23-style.css";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
import { resources } from "../../../../../appConstants";

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
function Help231(props) {
  return props.isHelp231Clicked ? (
    <div className="c23x-help-mainContainer">
      <div className="c23x-help-subContainer">
        <h1 className="c23x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c23x-help-para-style">
          Student centric methods, such as experiential learning, participative
          learning and problem solving methodologies are used for enhancing
          learning experiences Describe it in maximum 500 words.
        </p>
        <button
          className="c23x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp231Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help232(props) {
  return props.isHelp232Clicked ? (
    <div className="c23x-help-mainContainer">
      <div className="c23x-help-subContainer">
        <h1 className="c23x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c23x-help-para-style">
          Teachers use ICT enabled tools including online resources for
          effective teaching and learning process Describe it in maximum 500
          words.
        </p>
        <button
          className="c23x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp231Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help233(props) {
  return props.isHelp233Clicked ? (
    <div className="c23x-help-mainContainer">
      <div className="c23x-help-subContainer">
        <h1 className="c23x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c23x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span>Number of mentors{" "}
          <span style={{ fontWeight: "bold" }}>:</span>
          Number of students assigned to each mentor{" "}
          <span style={{ fontWeight: "bold" }}>)</span>
        </p>
        <button
          className="c23x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp233Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help234(props) {
  return props.isHelp234Clicked ? (
    <div className="c23x-help-mainContainer">
      <div className="c23x-help-subContainer">
        <h1 className="c23x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c23x-help-para-style">
          Preparation and adherence of Academic Calendar and Teaching plans by
          the institution Describe it in maximum 500 words.
        </p>
        <button
          className="c23x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp234Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// response button functionality

// Promotion of Research and Facilities
function Criteria23() {
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
  const [value231t1, setValue231t1] = useState();
  const [pathValue231f1, setPathValue231f1] = useState("");
  const [value231f1, setValue231f1] = useState([]);
  const [pathValue231f2, setPathValue231f2] = useState("");
  const [value231f2, setValue231f2] = useState([]);

  const [value232t1, setValue232t1] = useState();
  const [pathValue232f1, setPathValue232f1] = useState("");
  const [value232f1, setValue232f1] = useState([]);
  const [pathValue232f2, setPathValue232f2] = useState("");
  const [value232f2, setValue232f2] = useState([]);

  const [value234t1, setValue234t1] = useState();
  const [pathValue234f1, setPathValue234f1] = useState("");
  const [value234f1, setValue234f1] = useState([]);
  const [pathValue2331f1, setPathValue2331f1] = useState("");
  const [value2331f1, setValue2331f1] = useState([]);
  const [pathValue2331f2, setPathValue2331f2] = useState("");
  const [value2331f2, setValue2331f2] = useState([]);
  const [pathValue2331f3, setPathValue2331f3] = useState("");
  const [value2331f3, setValue2331f3] = useState([]);
  const [value2331t1, setValue2331t1] = useState();
  const [value2331t2, setValue2331t2] = useState();

  const [responseButtonStatus233, setResponseButtonStatus233] = useState(false);

  const [responseValue231, setResponseValue231] = useState("");
  const [responseValue232, setResponseValue232] = useState("");
  const [responseValue233, setResponseValue233] = useState("");
  const [responseValue234, setResponseValue234] = useState("");
  const [help231Status, setHelp231Status] = useState(false);
  const [help232Status, setHelp232Status] = useState(false);
  const [help233Status, setHelp233Status] = useState(false);
  const [help234Status, setHelp234Status] = useState(false);

  //get data
  // const financialYear = "2021-2022";
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
        "http://localhost:8080/api/v1/criteria2getallfiles?collegeId=" +
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
            setValue231t1(
              data[0].criteria23Ql[0] ? data[0].criteria23Ql[0].input231t1 : ""
            );
            setValue232t1(
              data[0].criteria23Ql[0] ? data[0].criteria23Ql[0].input232t1 : ""
            );
            setValue234t1(
              data[0].criteria23Ql[0] ? data[0].criteria23Ql[0].input234t1 : ""
            );
            setResponseValue231(
              data[0].criteria23Ql[0] ? data[0].criteria23Ql[0].response231 : ""
            );
            setResponseValue232(
              data[0].criteria23Ql[0] ? data[0].criteria23Ql[0].response234 : ""
            );
            setResponseValue234(
              data[0].criteria23Ql[0] ? data[0].criteria23Ql[0].response231 : ""
            );

            setValue2331t1(
              data[0].criteria23Qn[0] ? data[0].criteria23Qn[0].input2331t1 : ""
            );
            setValue2331t2(
              data[0].criteria23Qn[0] ? data[0].criteria23Qn[0].input2331t2 : ""
            );
            setResponseValue233(
              data[0].criteria23Qn[0] ? data[0].criteria23Qn[0].response233 : ""
            );

            // setValue2331t2(data[0].criteria23Ql[0].input2331t2);

            // setValue231f1(data[0].criteria1FileUpload[0].criteria1FileName);
            // setValue231f2(data[0].criteria1FileUpload[1].criteria1FileName);
            // setValue232f1(data[0].criteria2FileUpload[2].criteria2FileName);
            // setValue232f2(data[0].criteria2FileUpload[3].criteria2FileName);
            // setValue2331f1(data[0].criteria2FileUpload[4].criteria2FileName);
            // setValue2331f2(data[0].criteria2FileUpload[5].criteria2FileName);
            // setValue234f1(data[0].criteria2FileUpload[6].criteria2FileName);
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

    function onClickingViewResponse233(e) {
      !responseButtonStatus233;
      if (
        value2331t1 === "" ||
        value2331t2 === "" ||
        value2331t1 === undefined ||
        value2331t2 === undefined
      ) {
        setResponseValue233("Please fill the required fields");
      } else if (
        Number.isInteger(parseInt(value2331t1, 10)) === false ||
        Number.isInteger(parseInt(value2331t2, 10)) === false
      ) {
        setResponseValue233("Input should be an Integer");
      } else if (value2331t1 !== "" && value2331t2 !== "") {
        setResponseValue233(
          parseInt(value2331t1, 10) / parseInt(value2331t2, 10)
        );
      }
    }
  }


  // sending data to db with API

  const inputDataList = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    criteria23Ql: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input231t1: value231t1,
        input232t1: value232t1,
        input234t1: value234t1,
        response231: responseValue231,
        response232: responseValue232,
        response234: responseValue234,
      },
    ],
    criteria23Qn: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input2331t1: value2331t1,
        input2331t2: value2331t2,
        response233: responseValue233,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingModify() {
    const form23Data = new FormData();

    form23Data.append("criteria2Fieldinfo", jsonBlob(inputDataList));
    if (pathValue231f1 !== "") {
      form23Data.append("uploadfile2", value231f1, "f231f1-" + value231f1.name);
    }
    if (pathValue231f2 !== "") {
      form23Data.append("uploadfile2", value231f2, "f231f2-" + value231f2.name);
    }
    if (pathValue232f1 !== "") {
      form23Data.append("uploadfile2", value232f1, "f232f1-" + value232f1.name);
    }
    if (pathValue232f2 !== "") {
      form23Data.append("uploadfile2", value232f2, "f232f2-" + value232f2.name);
    }
    if (pathValue2331f1 !== "") {
      form23Data.append(
        "uploadfile2",
        value2331f1,
        "f2331f1-" + value2331f1.name
      );
    }
    if (pathValue2331f2 !== "") {
      form23Data.append(
        "uploadfile2",
        value2331f2,
        "f2331f2-" + value2331f2.name
      );
    }
    if (pathValue2331f3 !== "") {
      form23Data.append(
        "uploadfile2",
        value2331f3,
        "f2331f3-" + value2331f3.name
      );
    }
    if (pathValue234f1 !== "") {
      form23Data.append("uploadfile2", value234f1, "f234f1-" + value234f1.name);
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form23Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria2upload",
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
  // rendering DOM
  return (
    <div className="c23-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c23x-colorIndicator-container">
        <p className="c23x-QlcolorIndicator-circle-style"></p>
        <span className="c23x-colorIndicator-span-style">Qualitative</span>
        <p className="c23x-QtcolorIndicator-circle-style"></p>
        <span className="c23x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c23x-weightage-heading-style">
            Key Indicator Weightage: 50
          </h1>
        </div>
      </div>

      {/* Key Indicator: 2.3.1 */}
      <div className="c23x-eachInputField-container">
        <div className="c23x-weightage-container">
          <h1 className="c23x-weightage-heading-style">Weightage: 30</h1>
        </div>
        <form>
          <div className="c23x-Ql-label-textarea-container">
            <div className="c23x-heading_Help-container">
              <h1 className="c23x-heading-style">
                <span className="c23x-span-style">2.3.1: </span>
                Student centric methods, such as experiential learning, 
participative learning and problem solving methodologies are used 
for enhancing learning experience and teachers use ICT- enabled 
tools including online resources for effective teaching and learning process
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
            <label htmlFor="231-t1" className="c23x-label-style">
              Response:
            </label>
            <textarea
              readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue231t1(e.target.value);
                setResponseValue231(e.target.value);
              }}
              value={value231t1}
              rows={10}
              className="c23x-textarea-style"
              id="231-t1"
            ></textarea>
            {value231t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c23x-Ql-table-style">
            <tr>
              <th className="c23x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c23x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c23x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c23x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c23x-Ql-tableBorders-style">
                Any additional information
              </td>
              <td className="c23x-Ql-tableBorders-style"></td>
              <td className="c23x-Ql-tableBorders-style">
                <input
                  readonly
                  onChange={(e) => {
                    setValue231f1(e.target.files[0]);
                    setPathValue231f1(e.target.value);
                  }}
                  id="231-f1"
                  className="c23-fileButton-style"
                  type="file"
                />
                {pathValue231f1 === "" ? null : (
                  <div className="c23-fileButtons-container">
                    <button className="c23-viewFileButton-style">
                      View File
                    </button>

                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue231f1("");
                        document.getElementById("231-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value231f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c23x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c23x-Ql-tableBorders-style">
                Link for additional information
              </td>
              <td className="c23x-Ql-tableBorders-style"></td>
              <td className="c23x-Ql-tableBorders-style">
                <input
                  readonly
                  onChange={(e) => {
                    setValue231f2(e.target.files[0]);
                    setPathValue231f2(e.target.value);
                  }}
                  id="231-f2"
                  className="c23-fileButton-style"
                  type="file"
                />
                {pathValue231f2 === "" ? null : (
                  <div className="c23-fileButtons-container">
                    <button className="c23-viewFileButton-style">
                      View File
                    </button>

                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue231f2("");
                        document.getElementById("231-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value231f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c23x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 2.3.2 */}
      <div className="c23x-eachInputField-container">
        <div className="c23x-weightage-container">
          <h1 className="c23x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c23x-Ql-label-textarea-container">
            <div className="c23x-heading_Help-container">
              <h1 className="c23x-heading-style">
                <span className="c23x-span-style">2.3.2: </span>
                The institution adopts effective Mentor-Mentee Schemes to address 
academics and student-psychological issues
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
            <label htmlFor="232-t1" className="c23x-label-style">
              Response:
            </label>
            <textarea
              readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue232t1(e.target.value);
                setResponseValue232(e.target.value);
              }}
              value={value232t1}
              rows={10}
              className="c23x-textarea-style"
              id="232-t1"
            ></textarea>
            {value232t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c23x-Ql-table-style">
            <tr>
              <th className="c23x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c23x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c23x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c23x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c23x-Ql-tableBorders-style">
                Link for Additional Information
              </td>
              <td className="c23x-Ql-tableBorders-style"></td>
              <td className="c23x-Ql-tableBorders-style">
                <input
                  readonly
                  onChange={(e) => {
                    setValue232f1(e.target.files[0]);
                    setPathValue232f1(e.target.value);
                  }}
                  id="232-f1"
                  className="c23-fileButton-style"
                  type="file"
                />
                {pathValue232f1 === "" ? null : (
                  <div className="c23-fileButtons-container">
                    <button className="c23-viewFileButton-style">
                      View File
                    </button>

                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue232f1("");
                        document.getElementById("232-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value232f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
              </td>
              <td className="c23x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c23x-Ql-tableBorders-style">
                provide link for webpage describing ICT enabled tools including
                online resources for effective teaching and learning process
              </td>
              <td className="c23x-Ql-tableBorders-style"></td>
              <td className="c23x-Ql-tableBorders-style">
                <input
                  readonly
                  onChange={(e) => {
                    setValue232f2(e.target.files[0]);
                    setPathValue232f2(e.target.value);
                  }}
                  id="232-f2"
                  className="c23-fileButton-style"
                  type="file"
                />
                {pathValue232f2 === "" ? null : (
                  <div className="c23-fileButtons-container">
                    <button className="c23-viewFileButton-style">
                      View File
                    </button>

                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue232f2("");
                        document.getElementById("232-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value232f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c23x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 2.3.3 */}
      <div className="c23x-eachInputField-container">
        <div className="c23x-weightage-container">
          <h1 className="c23x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c23x-container">
            <div className="c23x-heading_Help-container">
              <h1 className="c23x-heading-style">
                <span className="c23x-span-style">2.3.3: </span>
                Preparation and adherence of Academic Calendar and Teaching 
plans by the institution
              </h1>
              <button
                onClick={handleHelpOpen3}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen3}
                handleClose={handleHelpClose3}
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <div className="c23x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus233(!responseButtonStatus233);
                  onClickingViewResponse233();
                }}
                className="c23x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus233 ? (
                <p className="c23x-responseResult-style">{responseValue233}</p>
              ) : null}
            </div>
          </div>
          <div className="c23xx-container">
            <h1 className="c23xx-Heading-style">
              <span className="c23xx-span-style">2.3.3.1</span>
              Number of mentors
              <input
                readonly
                onChange={(e) => setValue2331t1(e.target.value)}
                id="2331-t1"
                style={{ marginLeft: "46.5%" }}
                type="number"
                value={value2331t1}
              />
            </h1>
            <h1 className="c23xx-Heading-style">
              <span className="c22xx-span-style">2.3.3.1</span>
              Number of students assigned to each Mentor
              <input
                readonly
                onChange={(e) => setValue2331t2(e.target.value)}
                id="2331-t2"
                style={{ marginLeft: "25%" }}
                type="number"
                value={value2331t2}
              />
            </h1>
            <table className="c23x-table-style">
              <tr>
                <th className="c23x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c23x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c23x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c23x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                  Upload year wise, number of students enrolled and full time
                  teachers on roll.
                </td>
                <td></td>
                <td>
                  <input
                    readonly
                    onChange={(e) => {
                      setValue2331f1(e.target.files[0]);
                      setPathValue2331f1(e.target.value);
                    }}
                    id="2331-f1"
                    className="c23-fileButton-style"
                    type="file"
                  />
                  {pathValue2331f1 === "" ? null : (
                    <div className="c23-fileButtons-container">
                      <button className="c23-viewFileButton-style">
                        View File
                      </button>

                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue2331f1("");
                          document.getElementById("2331-f1").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  <a href={downloadFile(value2331f1)} target="_blank">
                    View File
                  </a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                </td>
                <td className="c23x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Circulars pertaining to assigning mentors to mentees </td>
                <td></td>
                <td>
                  <input
                    readonly
                    onChange={(e) => {
                      setValue2331f2(e.target.files[0]);
                      setPathValue2331f2(e.target.value);
                    }}
                    id="2331-f2"
                    className="c23-fileButton-style"
                    type="file"
                  />
                  {pathValue2331f2 === "" ? null : (
                    <div className="c23-fileButtons-container">
                      <button className="c23-viewFileButton-style">
                        View File
                      </button>

                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue2331f2("");
                          document.getElementById("2331-f2").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  <a href={downloadFile(value2331f2)} target="_blank">
                    View File
                  </a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                </td>
                <td className="c23x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>mentor/mentee ratio </td>
                <td></td>
                <td>
                  <input
                    readonly
                    onChange={(e) => {
                      setValue2331f3(e.target.files[0]);
                      setPathValue2331f3(e.target.value);
                    }}
                    id="2331-f3"
                    className="c23-fileButton-style"
                    type="file"
                  />
                  {pathValue2331f3 === "" ? null : (
                    <div className="c23-fileButtons-container">
                      <button className="c23-viewFileButton-style">
                        View File
                      </button>

                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue2331f3("");
                          document.getElementById("2331-f3").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  <a href={downloadFile(value2331f3)} target="_blank">
                    View File
                  </a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                </td>
                <td className="c23x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 2.3.4 */}
      <div className="c23x-eachInputField-container">
        <div className="c23x-weightage-container">
          <h1 className="c23x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c23x-Ql-label-textarea-container">
            <div className="c23x-heading_Help-container">
              <h1 className="c23x-heading-style">
                <span className="c23x-span-style">2.3.4: </span>
                Preparation and adherence of Academic Calendar and Teaching
                plans by the institution
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
            <label htmlFor="234-t1" className="c23x-label-style">
              Response:
            </label>
            <textarea
              readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue234t1(e.target.value);
                setResponseValue234(e.target.value);
              }}
              value={value234t1}
              rows={10}
              className="c23x-textarea-style"
              id="234-t1"
            ></textarea>
            {value234t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c23x-Ql-table-style">
            <tr>
              <th className="c23x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c23x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c23x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c23x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c23x-Ql-tableBorders-style">
                Upload Academic Calendar and Teaching plans for five years
              </td>
              <td className="c23x-Ql-tableBorders-style"></td>
              <td className="c23x-Ql-tableBorders-style">
                <input
                  readonly
                  onChange={(e) => {
                    setValue234f1(e.target.files[0]);
                    setPathValue234f1(e.target.value);
                  }}
                  id="234-f1"
                  className="c23-fileButton-style"
                  type="file"
                />
                {pathValue234f1 === "" ? null : (
                  <div className="c23-fileButtons-container">
                    <button className="c23-viewFileButton-style">
                      View File
                    </button>

                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue234f1("");
                        document.getElementById("234-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value234f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                  </button>
                </div> */}
              </td>
              <td className="c23x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  );
}

export default Criteria23;
