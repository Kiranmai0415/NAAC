import React, { useState, useEffect } from "react";
import "./c43-style.css";

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

function Help431(props) {
  return props.isHelp431Clicked ? (
    <div className="c43x-help-mainContainer">
      <div className="c43x-help-subContainer">
        <h1 className="c43x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c43x-help-para-style">
          Describe IT facilities including Wi-Fi with date and nature of
          updation within a maximum of 500 words
        </p>
        <button
          className="c43x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp431Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help432(props) {
  return props.isHelp432Clicked ? (
    <div className="c43x-help-mainContainer">
      <div className="c43x-help-subContainer">
        <h1 className="c43x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c43x-help-para-style">
          Number of students: Number of computers
        </p>
        <button
          className="c43x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp432Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help433(props) {
  return props.isHelp433Clicked ? (
    <div className="c43x-help-mainContainer">
      <div className="c43x-help-subContainer">
        <h1 className="c43x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c43x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c43x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp433Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help434(props) {
  return props.isHelp434Clicked ? (
    <div className="c43x-help-mainContainer">
      <div className="c43x-help-subContainer">
        <h1 className="c43x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c43x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c43x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp434Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Criteria43() {
  
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
const handleHelpOpen3=(e)=>{
  e.preventDefault();
  setIsopen3(true)
} 
const handleHelpClose3= (e)=>{
  setIsopen3(false)
}
  const [value431t1, setValue431t1] = useState();
  const [value431f1, setValue431f1] = useState("");
  const [pathValue431f1, setPathValue431f1] = useState("");
  const [pathValue431f2, setPathValue431f2] = useState("");
  const [value431f2, setValue431f2] = useState();
  const [responseValue431, setResponseValue431] = useState("");
  const [help431Status, setHelp431Status] = useState(false);

  const [value432t1, setValue432t1] = useState();
  const [value432t2, setValue432t2] = useState();
  const [value432f1, setValue432f1] = useState("");
  const [pathValue432f1, setPathValue432f1] = useState("");
  const [value432f2, setValue432f2] = useState("");
  const [pathValue432f2, setPathValue432f2] = useState("");
  const [responseButtonStatus432, setResponseButtonStatus432] = useState(false);
  const [responseValue432, setResponseValue432] = useState("");
  const [help432Status, setHelp432Status] = useState(false);

  const [value433t1, setValue433t1] = useState();
  const [value433f1, setValue433f1] = useState("");
  const [pathValue433f1, setPathValue433f1] = useState("");
  const [value433f2, setValue433f2] = useState("");
  const [pathValue433f2, setPathValue433f2] = useState("");
  const [responseButtonStatus433, setResponseButtonStatus433] = useState(false);
  const [responseValue433, setResponseValue433] = useState("");
  const [help433Status, setHelp433Status] = useState(false);

  const [value434t1, setValue434t1] = useState();
  const [value434f1, setValue434f1] = useState("");
  const [pathValue434f1, setPathValue434f1] = useState("");
  const [value434f2, setValue434f2] = useState("");
  const [pathValue434f2, setPathValue434f2] = useState("");
  const [responseButtonStatus434, setResponseButtonStatus434] = useState(false);
  const [responseValue434, setResponseValue434] = useState("");
  const [help434Status, setHelp434Status] = useState(false);

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
        "http://localhost:8080/api/v1/criteria4getallfiles?collegeId=1&financialYear=" +
          financialYear +
          "&typeofInstitution=autonomous"
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            setValue431t1(data[0].criteria43Ql[0].input431t1);

            setValue432t1(data[0].criteria43Qn[0].input432t1);
            setValue432t2(data[0].criteria43Qn[0].input432t2);
            setValue433t1(data[0].criteria43Qn[0].input433t1);
            setValue434t1(data[0].criteria43Qn[0].input434t1);

            setValue431f1(data[0].criteria4FileUpload[0].criteria4FileName);
            setValue431f2(data[0].criteria4FileUpload[0].criteria4FileName);
            setValue432f1(data[0].criteria4FileUpload[0].criteria4FileName);
            setValue432f2(data[0].criteria4FileUpload[0].criteria4FileName);
            setValue433f1(data[0].criteria4FileUpload[0].criteria4FileName);
            setValue433f2(data[0].criteria4FileUpload[0].criteria4FileName);
            setValue434f1(data[0].criteria4FileUpload[0].criteria4FileName);
            setValue434f2(data[0].criteria4FileUpload[0].criteria4FileName);
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );

  function onClickingViewResponse433(e) {
    if (value433t1 === "") {
      setResponseValue433("Please select any option");
    } else {
      setResponseValue433(e.target.value);
    }
  }
  function onClickingViewResponse434(e) {
    if (value434t1 === "") {
      setResponseValue434("Please select any option");
    } else {
      setResponseValue434(e.target.value);
    }
  }
  function onClickingViewResponse432() {
    if (
      value432t1 === "" ||
      value432t2 === "" ||
      value432t1 === undefined ||
      value432t2 === undefined
    ) {
      setResponseValue432("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value432t1, 10)) === false ||
      Number.isInteger(parseInt(value432t2, 10)) === false
    ) {
      setResponseValue432("Input should be an Integer");
    } else if (value432t1 !== "" && value432t2 !== "") {
      setResponseValue432(parseInt(value432t1, 10) / parseInt(value432t2, 10));
    }
  }

  // sending data to db with API

  const inputDataList = {
    criteriaId: {
      collegeId: "1",
      financialYear: financialYear,
      typeofInstitution: "autonomous",
    },
    criteria43Ql: [
      {
        criteriaId: {
          collegeId: "1",
          financialYear: financialYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 1,
        input431t1: value431t1,
        response431: responseValue431,
      },
    ],
    criteria43Qn: [
      {
        criteriaId: {
          collegeId: "1",
          financialYear: financialYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 1,
        input432t1: value432t1,
        input432t2: value432t2,
        response432: responseValue432,
        input433t1: value433t1,
        response433: responseValue433,
        input434t1: value434t1,
        response434: responseValue434,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    console.log(value434t1);
    const form43Data = new FormData();

    form43Data.append("criteria4Fieldinfo", jsonBlob(inputDataList));
    if (pathValue431f1 !== "") {
      form43Data.append("uploadfile4", value431f1, "f431f1-" + value431f1.name);
    }
    if (pathValue431f2 !== "") {
      form43Data.append("uploadfile4", value431f2, "f431f2-" + value431f2.name);
    }
    if (pathValue432f1 !== "") {
      form43Data.append("uploadfile4", value432f1, "f432f1-" + value432f1.name);
    }
    if (pathValue432f2 !== "") {
      form43Data.append("uploadfile4", value432f2, "f432f2-" + value432f2.name);
    }
    if (pathValue433f1 !== "") {
      form43Data.append("uploadfile4", value433f1, "f433f1-" + value433f1.name);
    }
    if (pathValue433f2 !== "") {
      form43Data.append("uploadfile4", value433f2, "f433f2-" + value433f2.name);
    }
    if (pathValue434f1 !== "") {
      form43Data.append("uploadfile4", value434f1, "f434f1-" + value434f1.name);
    }
    if (pathValue434f2 !== "") {
      form43Data.append("uploadfile4", value434f2, "f434f2-" + value434f2.name);
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form43Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria4upload",
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

  // getfile data with API

  function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
  }

  return (
    <div className="c43-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c43x-colorIndicator-container">
        <p className="c43x-QlcolorIndicator-circle-style"></p>
        <span className="c43x-colorIndicator-span-style">Qualitative</span>
        <p className="c43x-QtcolorIndicator-circle-style"></p>
        <span className="c43x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c43x-weightage-heading-style">
            Key Indicator Weightage: 30
          </h1>
        </div>
      </div>

      {/* Key Indicator: 4.3.1 */}
      <div className="c43x-eachInputField-container">
        <div className="c43x-weightage-container">
          <h1 className="c43x-weightage-heading-style">Weightage: 12</h1>
        </div>
        <form>
          <div className="c43x-Ql-label-textarea-container">
            <div className="c43x-heading_Help-container">
              <h1 className="c43x-heading-style">
                <span className="c43x-span-style">4.3.1: </span>
                Institution frequently updates its IT facilities and provides sufficient bandwidth for internet connection
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
            <label htmlFor="431-t1" className="c43x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue431t1(e.target.value);
                setResponseValue431(e.target.value);
              }}
              value={value431t1}
              rows={10}
              className="c43x-textarea-style"
              id="431-t1"
            ></textarea>
            {value431t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c43x-Ql-table-style">
            <tr>
              <th className="c43x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c43x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c43x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c43x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c43x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c43x-Ql-tableBorders-style"></td>
              <td className="c43x-Ql-tableBorders-style">
                <input
                  readonly
                  onChange={(e) => {
                    setValue431f1(e.target.files[0]);
                    setPathValue431f1(e.target.value);
                  }}
                  id="431-f1"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue431f1 === "" ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue431f1("");
                        document.getElementById("431-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value431f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
              </td>
              <td className="c43x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
                <input
                  readonly
                  onChange={(e) => {
                    setValue431f2(e.target.files[0]);
                    setPathValue431f2(e.target.value);
                  }}
                  id="431-f2"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue431f2 === "" ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue431f2("");
                        document.getElementById("431-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value431f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 4.3.2 */}
      <div className="c43x-eachInputField-container">
        <div className="c43x-weightage-container">
          <h1 className="c43x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c43x-container">
            <div className="c43x-heading_Help-container">
              <h1 className="c43x-heading-style">
                <span className="c43x-span-style">4.3.2: </span>
                Student - Computer ratio (Data for the latest completed academic year)
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
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            <div className="c43x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus432(!responseButtonStatus432);
                  onClickingViewResponse432();
                }}
                className="c43x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus432 ? (
                <p className="c43x-responseResult-style">{responseValue432}</p>
              ) : null}
            </div>
          </div>
          <div className="c43xx-container">
            {/* <h1 className="c43xx-Heading-style">
              Number of students:
              <input
                readonly
                onChange={(e) => setValue432t1(e.target.value)}
                id="432-t1"
                style={{ marginLeft: "43%" }}
                type="number"
              />
            </h1> */}
            <h1 className="c43xx-Heading-style">
              Number of computers:
              <input
                readonly
                onChange={(e) => setValue432t2(e.target.value)}
                id="432-t2"
                style={{ marginLeft: "41.2%" }}
                type="number"
              />
            </h1>

            <table className="c43x-table-style">
            <tr>
              <th className="c43x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c43x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c43x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c43x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Upload any additional information</td>
              <td></td>
              <td>
                <input
                  readonly
                  onChange={(e) => {
                    setValue434f1(e.target.files[0]);
                    setPathValue434f1(e.target.value);
                  }}
                  id="434-f1"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue434f1 === "" ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue434f1("");
                        document.getElementById("434-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value434f1)} target="_blank">
                  View File
                </a>
                <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div>
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Institutional data in prescribed format</td>
              <td></td>
              <td>
                <input
                  readonly
                  onChange={(e) => {
                    setValue434f2(e.target.files[0]);
                    setPathValue434f2(e.target.value);
                  }}
                  id="434-f2"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue434f2 === "" ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue434f2("");
                        document.getElementById("434-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value434f2)} target="_blank">
                  View File
                </a>
                <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div>
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 4.3.3 */}
      <div className="c43x-eachInputField-container">
        <div className="c43x-weightage-container">
          <h1 className="c43x-weightage-heading-style">Weightage: 8</h1>
        </div>
        <form>
          <div className="c43x-container">
            <div className="c43x-heading_Help-container">
              <div>
                <h1 className="c43x-heading-style">
                  <span className="c43x-span-style">4.3.3: </span>
                  Institution has dedicated audio visual centre, mixing equipment, editing facility, media studio, lecture capturing system(LCS) and related hardware and software for e-content development
                </h1>
                <label htmlFor="431-t1" className="c43x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue431t1(e.target.value);
                setResponseValue431(e.target.value);
              }}
              value={value431t1}
              rows={10}
              className="c43x-textarea-style"
              id="431-t1"
            ></textarea>


                {/* <div className="c43x-radio-container" style={{ width: "180%" }}>
                  <div
                    className="c43x-radio-subContainer"
                    style={{ width: "45%" }}
                  >
                    <div className="c43x-eachRadio-container">
                      <input
                        readonly
                        name="433options"
                        id="433-t1"
                        type="radio"
                        onChange={(e) => {
                          setValue433t1(e.target.value);
                        }}
                        value="50MBPS"
                      />

                      <label className="c43x-radioLabel-style" for="433-t1">
                        {">"}= 50MBPS
                      </label>
                    </div>

                    <div className="c43x-eachRadio-container">
                      <input
                        readonly
                        name="433options"
                        id="433-t2"
                        type="radio"
                        onChange={(e) => {
                          setValue433t1(e.target.value);
                        }}
                        value="35 MBPS-50 MBPS"
                      />

                      <label className="c43x-radioLabel-style" for="422-t2">
                        35 MBPS - 50 MBPS
                      </label>
                    </div>

                    <div className="c43x-eachRadio-container">
                      <input
                        readonly
                        name="433options"
                        id="433-t3"
                        type="radio"
                        onChange={(e) => {
                          setValue433t1(e.target.value);
                        }}
                        value="20 MBPS-35 MBPS"
                      />

                      <label className="c43x-radioLabel-style" for="433-t3">
                        20 MBPS - 35 MBPS
                      </label>
                    </div>
                  </div>

                  <div className="c43x-radio-subContainer">
                    <div className="c43x-eachRadio-container">
                      <input
                        readonly
                        name="433options"
                        id="433-t4"
                        type="radio"
                        onChange={(e) => {
                          setValue433t1(e.target.value);
                        }}
                        value="5 MBPS-20 MBPS"
                      />

                      <label className="c43x-radioLabel-style" for="433-t4">
                        5 MBPS - 20 MBPS
                      </label>
                    </div>

                    <div className="c43x-eachRadio-container">
                      <input
                        readonly
                        name="433options"
                        id="433-t5"
                        type="radio"
                        onChange={(e) => {
                          setValue433t1(e.target.value);
                        }}
                        value="5 MBPS"
                      />

                      <label className="c43x-radioLabel-style" for="422-t5">
                        {"<"} 5 MBPS
                      </label>
                    </div>
                  </div>
                </div> */}
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
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <div className="c43x-response-container">
              {/* <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus433(!responseButtonStatus433);
                  onClickingViewResponse433();
                }}
                className="c43x-responseButton-style"
              >
                View Response
              </button> */}
              {responseButtonStatus433 ? (
                <p className="c43x-responseResult-style">{responseValue433}</p>
              ) : null}
            </div>
          </div>
          <table className="c43x-table-style">
            <tr>
              <th className="c43x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c43x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c43x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c43x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Upload any additional information</td>
              <td></td>
              <td>
                <input
                  readonly
                  onChange={(e) => {
                    setValue433f1(e.target.files[0]);
                    setPathValue433f1(e.target.value);
                  }}
                  id="433-f1"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue433f1 === "" ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue433f1("");
                        document.getElementById("433-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value433f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Details of available bandwidth of internet connection in the
                Institution
              </td>
              <td></td>
              <td>
                <input
                  readonly
                  onChange={(e) => {
                    setValue433f2(e.target.files[0]);
                    setPathValue433f2(e.target.value);
                  }}
                  id="433-f2"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue433f2 === "" ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue433f2("");
                        document.getElementById("433-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value433f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 4.3.4 */}
      {/* <div className="c43x-eachInputField-container">
        <div className="c43x-weightage-container">
          <h1 className="c43x-weightage-heading-style">Weightage: 4</h1>
        </div>
        <form>
          <div className="c43x-container">
            <div className="c43x-heading_Help-container">
              <div>
                <h1 className="c43x-heading-style">
                  <span className="c43x-span-style">4.3.4: </span>
                  Institution has the following Facilities for e-content
                  development
                </h1>
                <p className="c34x-para-style">
                  1. Media centre
                  <br />
                  2. Audio visual centre
                  <br />
                  3. Lecture Capturing System(LCS)
                  <br />
                  4. Mixing equipments and softwares for editing
                </p>

                <div className="c43x-radio-container" style={{ width: "150%" }}>
                  <div
                    className="c43x-radio-subContainer"
                    style={{ width: "45%" }}
                  >
                    <div className="c43x-eachRadio-container">
                      <input
                        readonly
                        onChange={(e) => {
                          setValue434t1(e.target.value);
                        }}
                        name="434options"
                        value="All the four of the above"
                        id="434-t1"
                        type="radio"
                      />

                      <label className="c43x-radioLabel-style" for="433-t1">
                        All the four of the above
                      </label>
                    </div>

                    <div className="c43x-eachRadio-container">
                      <input
                        readonly
                        onChange={(e) => {
                          setValue434t1(e.target.value);
                        }}
                        name="434options"
                        value="Any three of the above"
                        id="434-t2"
                        type="radio"
                      />

                      <label className="c43x-radioLabel-style" for="422-t2">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c43x-eachRadio-container">
                      <input
                        readonly
                        onChange={(e) => {
                          setValue434t1(e.target.value);
                        }}
                        name="434options"
                        value="Any two of the above"
                        id="434-t3"
                        type="radio"
                      />

                      <label className="c43x-radioLabel-style" for="433-t3">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c43x-radio-subContainer">
                    <div className="c43x-eachRadio-container">
                      <input
                        readonly
                        onChange={(e) => {
                          setValue434t1(e.target.value);
                        }}
                        name="434options"
                        value="Any one of the above"
                        id="434-t4"
                        type="radio"
                      />

                      <label className="c43x-radioLabel-style" for="433-t4">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c43x-eachRadio-container">
                      <input
                        readonly
                        onChange={(e) => {
                          setValue434t1(e.target.value);
                        }}
                        name="434options"
                        value="None of the above"
                        id="433-t5"
                        type="radio"
                      />

                      <label className="c43x-radioLabel-style" for="422-t5">
                        None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp434Status(true);
                }}
                className="c43x-helpButton-style"
              >
                Help
              </button>
              <Help434
                isHelp434Clicked={help434Status}
                setIsHelp434Clicked={setHelp434Status}
              />
            </div>
            <div className="c43x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus434(!responseButtonStatus434);
                  onClickingViewResponse434();
                }}
                className="c43x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus434 ? (
                <p className="c43x-responseResult-style">{responseValue434}</p>
              ) : null}
            </div>
          </div>
          <table className="c43x-table-style">
            <tr>
              <th className="c43x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c43x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c43x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c43x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Upload any additional information</td>
              <td></td>
              <td>
                <input
                  readonly
                  onChange={(e) => {
                    setValue434f1(e.target.files[0]);
                    setPathValue434f1(e.target.value);
                  }}
                  id="434-f1"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue434f1 === "" ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue434f1("");
                        document.getElementById("434-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value434f1)} target="_blank">
                  View File
                </a>
                <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div>
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Institutional data in prescribed format</td>
              <td></td>
              <td>
                <input
                  readonly
                  onChange={(e) => {
                    setValue434f2(e.target.files[0]);
                    setPathValue434f2(e.target.value);
                  }}
                  id="434-f2"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue434f2 === "" ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue434f2("");
                        document.getElementById("434-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value434f2)} target="_blank">
                  View File
                </a>
                <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div>
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div> */}
      
    </div>
  );
}

export default Criteria43;
