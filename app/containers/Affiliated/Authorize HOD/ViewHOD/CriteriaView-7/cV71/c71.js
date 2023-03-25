import React, { useState, useEffect } from "react";
import "./c71-style.css";
import { toast } from "react-toastify";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import { resources } from "../../../../../appConstants";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
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

function Help711(props) {
  return props.isHelp711Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp711Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help712(props) {
  return props.isHelp712Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp712Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help713(props) {
  return props.isHelp713Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp713Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help714(props) {
  return props.isHelp714Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp714Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// state variables
function Criteria71() {
  // /this is Help button 
  const [isOpen, setIsopen] = useState(false)
  const [isOpen2, setIsopen2] = useState(false)
  const [isOpen3, setIsopen3] = useState(false)
  const [isOpen4, setIsopen4] = useState(false)
  const handleHelpOpen = (e) => {
    e.preventDefault(),
    setIsopen(true)
  }
  const handleHelpClose = () => {
    setIsopen(false)
  }
  const handleHelpOpen2 = (e) => {
    e.preventDefault(),
    setIsopen2(true)
  }
  const handleHelpClose2 = () => {
    setIsopen2(false)
  }
  const handleHelpOpen3 = (e) => {
    e.preventDefault(),
    setIsopen3(true)
  }
  const handleHelpClose3 = () => {
    setIsopen3(false)
  }
  const handleHelpOpen4 = (e) => {
    e.preventDefault(),
    setIsopen4(true)
  }
  const handleHelpClose4 = () => {
    setIsopen4(false)
  }
  const [value711t1, setValue711t1] = useState();
  const [value711f1, setValue711f1] = useState("");
  const [pathValue711f1, setPathValue711f1] = useState("");
  const [value711f2, setValue711f2] = useState("");
  const [pathValue711f2, setPathValue711f2] = useState("");
  const [responseValue711, setResponseValue711] = useState("");
  const [help711Status, setHelp711Status] = useState(false);

  const [value712t1, setValue712t1] = useState();
  const [value712f1, setValue712f1] = useState("");
  const [pathValue712f1, setPathValue712f1] = useState("");
  const [value712f2, setValue712f2] = useState("");
  const [pathValue712f2, setPathValue712f2] = useState("");
  const [responseButtonStatus712, setResponseButtonStatus712] = useState(false);
  const [responseValue712, setResponseValue712] = useState("");
  const [help712Status, setHelp712Status] = useState(false);

  const [value713t1, setValue713t1] = useState();
  const [value713f1, setValue713f1] = useState("");
  const [pathValue713f1, setPathValue713f1] = useState("");
  const [value713f2, setValue713f2] = useState("");
  const [pathValue713f2, setPathValue713f2] = useState("");
  const [value713f3, setValue713f3] = useState("");
  const [pathValue713f3, setPathValue713f3] = useState("");
  const [value713f4, setValue713f4] = useState("");
  const [pathValue713f4, setPathValue713f4] = useState("");
  const [responseButtonStatus713, setResponseButtonStatus713] = useState(false);
  const [responseValue713, setResponseValue713] = useState("");
  const [help713Status, setHelp713Status] = useState(false);

  const [value714t1, setValue714t1] = useState();
  const [value714f1, setValue714f1] = useState("");
  const [pathValue714f1, setPathValue714f1] = useState("");
  const [value714f2, setValue714f2] = useState("");
  const [pathValue714f2, setPathValue714f2] = useState("");
  const [responseValue714, setResponseValue714] = useState("");
  const [help714Status, setHelp714Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  // response functionality
  function onClickingViewResponse712(e) {
    if (value712t1 === "") {
      setResponseValue712("Please select any option");
    } else {
      setResponseValue712(value712t1);
    }
  }

  function onClickingViewResponse713(e) {
    if (value713t1 === "") {
      setResponseValue713("Please select any option");
    } else {
      setResponseValue713(value713t1);
    }
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

  // get data  with API
  const financialYear = "2021-2022";
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }

  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria7getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setValue711t1(data[0].criteria71Ql[0]?data[0].criteria71Ql[0].input711t1:"");
            setValue712t1(data[0].criteria71Qn[0]?data[0].criteria71Qn[0].input712t1:"");
            setValue713t1(data[0].criteria71Qn[0]?data[0].criteria71Qn[0].input713t1:"");
            setValue714t1(data[0].criteria71Qn[0]?data[0].criteria71Qn[0].input714t1:"");

            setValue711f1(data[0].criteria7FileUpload[0]?data[0].criteria7FileUpload[0].criteria7FileName:"");
            setValue711f2(data[0].criteria7FileUpload[1]?data[0].criteria7FileUpload[1].criteria7FileName:"");
            setValue712f1(data[0].criteria7FileUpload[2]?data[0].criteria7FileUpload[2].criteria7FileName:"");
            setValue713f1(data[0].criteria7FileUpload[3]?data[0].criteria7FileUpload[3].criteria7FileName:"");
            setValue714f1(data[0].criteria7FileUpload[4]?data[0].criteria7FileUpload[4].criteria7FileName:"");
            setValue714f2(data[0].criteria7FileUpload[5]?data[0].criteria7FileUpload[5].criteria7FileName:"");
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );
  // sending data to db with API

  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    criteria71Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 101,
        input711t1: value711t1,
        response711: responseValue711,
      },
    ],
    criteria71Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

        uniqueKey1: 101,
        input712t1: value712t1,
        input713t1: value713t1,
        input714t1: value714t1,
        response712: responseValue712,
        response713: responseValue713,
        response714: responseValue714,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form71Data = new FormData();

    form71Data.append("criteria7Fieldinfo", jsonBlob(inputDataList));
    if (pathValue711f1 !== "") {
      form71Data.append("uploadfile7", value711f1, "f711f1-" + value711f1.name);
    }
    form71Data.append("criteria7Fieldinfo", jsonBlob(inputDataList));
    if (pathValue711f2 !== "") {
      form71Data.append("uploadfile7", value711f2, "f711f2-" + value711f2.name);
    }
    form71Data.append("criteria7Fieldinfo", jsonBlob(inputDataList));
    if (pathValue712f1 !== "") {
      form71Data.append("uploadfile7", value712f1, "f712f1-" + value712f1.name);
    }
    form71Data.append("criteria7Fieldinfo", jsonBlob(inputDataList));
    if (setPathValue712f2 !== "") {
      form71Data.append("uploadfile7", value712f2, "f712f2-" + value712f2.name);
    }
    form71Data.append("criteria7Fieldinfo", jsonBlob(inputDataList));
    if (pathValue713f1 !== "") {
      form71Data.append("uploadfile7", value713f1, "f713f1-" + value713f1.name);
    }
    form71Data.append("criteria7Fieldinfo", jsonBlob(inputDataList));
    if (setPathValue713f2 !== "") {
      form71Data.append("uploadfile7", value713f2, "f713f2-" + value713f2.name);
    }
    form71Data.append("criteria7Fieldinfo", jsonBlob(inputDataList));
    if (setPathValue713f3 !== "") {
      form71Data.append("uploadfile7", value713f3, "f713f3-" + value713f3.name);
    }
    form71Data.append("criteria7Fieldinfo", jsonBlob(inputDataList));
    if (setPathValue713f4 !== "") {
      form71Data.append("uploadfile7", value713f4, "f713f4-" + value713f4.name);
    }

    form71Data.append("criteria7Fieldinfo", jsonBlob(inputDataList));
    if (setPathValue714f1 !== "") {
      form71Data.append("uploadfile7", value714f1, "f714f1-" + value714f1.name);
    }
    form71Data.append("criteria7Fieldinfo", jsonBlob(inputDataList));
    if (setPathValue714f2 !== "") {
      form71Data.append("uploadfile7", value714f2, "f714f2-" + value714f2.name);
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form71Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria7upload",
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
  // rendering dom
  return (
    <div className="c71-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c71x-colorIndicator-container">
        <p className="c71x-QlcolorIndicator-circle-style"></p>
        <span className="c71x-colorIndicator-span-style">Qualitative</span>
        <p className="c71x-QtcolorIndicator-circle-style"></p>
        <span className="c71x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c71x-weightage-heading-style">
            Key Indicator Weightage: 50
          </h1>
        </div>
      </div>

      {/* Key Indicator: 7.1.1 */}
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c71x-Ql-label-textarea-container">
            <div className="c71x-heading_Help-container">
              <h1 className="c71x-heading-style">
                <span className="c71x-span-style">7.1.1: </span>
                Measures initiated by the Institution for the promotion of gender 
               equity and Institutional initiatives to celebrate / organize national 
                and international commemorative days, events and festivals during 
               the last five years (Within 500 words)

              </h1>
              <button
                onClick={handleHelpOpen}
                className="c71x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Write description in a maximum of 500 words'
               ></HelpButton>
            </div>
            <label htmlFor="711-t1" className="c71x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue711t1(e.target.value);
                setResponseValue711(e.target.value);
              }}
              value={value711t1}
              rows={10}
              className="c71x-textarea-style"
              id="711-t1"
            ></textarea>
            {value711t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c71x-Ql-table-style">
            <tr>
              <th className="c71x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Annual gender sensitization action plan
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  readOnly
                  onChange={(e) => {
                    setValue711f1(e.target.files[0]);
                    setPathValue711f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="711-f1"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue711f1 === "" ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue711f1("");
                        document.getElementById("711-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value711f1)} target="_blank">View File</a> */}
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Specific facilities provided for women in terms of: a.Safety and
                security b.Counselling c.Common Rooms d. Day care center for
                young children e. Any other relevant information
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  readOnly
                  onChange={(e) => {
                    setValue711f2(e.target.files[0]);
                    setPathValue711f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="711-f2"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue711f2 === "" ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue711f2("");
                        document.getElementById("711-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value711f2)} target="_blank">View File</a> */}
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 7.1.2 */}
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c71x-container">
            <div className="c71x-heading_Help-container">
              <div>
                <h1 className="c71x-heading-style">
                  <span className="c71x-span-style">7.1.2: </span>
                  The Institution has facilities and initiatives for 
                </h1>
                <p className="c71x-para-style">
                  1. Alternate sources of energy and energy conservation measures
                  <br />
                  2. Management of the various types of degradable and nondegradable waste
                  <br />
                  3. Water conservation 
                  <br />
                  4. Green campus initiatives
                  <br />
                  5. Disabled-friendly, barrier free environment
                </p>
                <div className="c71x-radio-container" style={{ width: "110%" }}>
                  <div
                    className="c71x-radio-subContainer"
                    style={{ width: "45%" }}
                  >
                    <div className="c71x-eachRadio-container">
                      <input
                        readOnly
                        name="712options"
                        id="712-t1"
                        type="radio"
                        value="All of the above"
                        onChange={(e) => setValue712t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="712-t1">
                        All of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        readOnly
                        name="712options"
                        id="712-t2"
                        type="radio"
                        value="Any three of the above"
                        onChange={(e) => setValue712t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="712-t2">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        readOnly
                        name="712options"
                        id="712-t3"
                        type="radio"
                        value="Any two of the above"
                        onChange={(e) => setValue712t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="712-t3">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c71x-radio-subContainer">
                    <div className="c71x-eachRadio-container">
                      <input
                        readOnly
                        name="712options"
                        id="712-t4"
                        type="radio"
                        value="Any one of the above"
                        onChange={(e) => setValue712t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="712-t4">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        readOnly
                        name="712options"
                        id="712-t5"
                        type="radio"
                        value="None of the above"
                        onChange={(e) => setValue712t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="712-t5">
                        None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen}
                className="c71x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='file description'
               ></HelpButton>
            </div>
            <div className="c71x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus712(!responseButtonStatus712);
                  onClickingViewResponse712();
                }}
                className="c71x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus712 ? (
                <p className="c71x-responseResult-style">{responseValue712}</p>
              ) : null}
            </div>
          </div>
          <table className="c71x-table-style">
            <tr>
              <th className="c71x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Geotagged Photographs</td>
              <td></td>
              <td>
                <input
                  readOnly
                  onChange={(e) => {
                    setValue712f1(e.target.files[0]);
                    setPathValue712f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="712-f1"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue712f1 === "" ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue712f1("");
                        document.getElementById("712-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value712f1)} target="_blank">View File</a> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any other relevant information</td>
              <td></td>
              <td>
                <input
                  readOnly
                  onChange={(e) => {
                    setValue712f2(e.target.files[0]);
                    setPathValue712f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="712-f2"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue712f2 === "" ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue712f2("");
                        document.getElementById("712-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value712f2)} target="_blank">View File</a> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 7.1.3 */}
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c71x-container">
            <div className="c71x-heading_Help-container">
              <div>
                <h1 className="c71x-heading-style">
                  <span className="c71x-span-style">7.1.3: </span>
                  Quality audits on environment and energy are regularly
                  undertaken by the Institution and any awards received for such
                  green campus initiatives:
                </h1>
                <p className="c71x-para-style">
                1. Green audit / Environment audit
                  <br />
                  2. Energy audit
                  <br />
                  3. Clean and green campus initiatives 

                  <br />
                  4. Beyond the campus environmental promotion activities
                  </p>
                <div className="c71x-radio-container">
                  <div
                    className="c71x-radio-subContainer"
                    style={{ width: "45%" }}
                  >
                    <div className="c71x-eachRadio-container">
                      <input
                        readOnly
                        name="713options"
                        id="713-t1"
                        type="radio"
                        value="All of the above"
                        onChange={(e) => setValue713t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="713-t1">
                        All of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        readOnly
                        name="713options"
                        id="713-t2"
                        type="radio"
                        value="Any three of the above"
                        onChange={(e) => setValue713t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="713-t2">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        readOnly
                        name="713options"
                        id="713-t3"
                        type="radio"
                        value="Any two of the above"
                        onChange={(e) => setValue713t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="713-t3">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c71x-radio-subContainer">
                    <div className="c71x-eachRadio-container">
                      <input
                        readOnly
                        name="713options"
                        id="713-t4"
                        type="radio"
                        value="Any one of the above"
                        onChange={(e) => setValue713t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="713-t4">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        readOnly
                        name="713options"
                        id="713-t5"
                        type="radio"
                        value="None of the above"
                        onChange={(e) => setValue713t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="713-t5">
                        None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen}
                className="c71x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='file description'
               ></HelpButton>
            </div>
            <div className="c71x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus713(!responseButtonStatus713);
                  onClickingViewResponse713();
                }}
                className="c71x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus713 ? (
                <p className="c71x-responseResult-style">{responseValue713}</p>
              ) : null}
            </div>
          </div>
          <table className="c71x-table-style">
            <tr>
              <th className="c71x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>
                Reports on environment and energy audits submitted by the
                auditing agency{" "}
              </td>
              <td></td>
              <td>
                <input
                  readOnly
                  onChange={(e) => {
                    setValue713f1(e.target.files[0]);
                    setPathValue713f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="713-f1"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue713f1 === "" ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue713f1("");
                        document.getElementById("713-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value713f1)} target="_blank">View File</a> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Certification by the auditing agency</td>
              <td></td>
              <td>
                <input
                  readOnly
                  onChange={(e) => {
                    setValue713f2(e.target.files[0]);
                    setPathValue713f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="713-f2"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue713f2 === "" ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue713f2("");
                        document.getElementById("713-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value713f2)} target="_blank">View File</a> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Certificates of the awards received</td>
              <td></td>
              <td>
                <input
                  readOnly
                  onChange={(e) => {
                    setValue713f3(e.target.files[0]);
                    setPathValue713f3(e.target.value);
                    showFilePreview(e);
                  }}
                  id="713-f3"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue713f3 === "" ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue713f3("");
                        document.getElementById("713-f3").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value713f3)} target="_blank">View File</a>
                 */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any other relevant information</td>
              <td></td>
              <td>
                <input
                  readOnly
                  onChange={(e) => {
                    setValue713f4(e.target.files[0]);
                    setPathValue713f4(e.target.value);
                    showFilePreview(e);
                  }}
                  id="713-f4"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue713f4 === "" ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue713f4("");
                        document.getElementById("713-f4").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value713f4)} target="_blank">View File</a> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 7.1.4 */}
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c71x-Ql-label-textarea-container">
            <div className="c71x-heading_Help-container">
              <h1 className="c71x-heading-style">
                <span className="c71x-span-style">7.1.4: </span>
                Describe the Institutional efforts/initiatives in providing an
                inclusive environment i.e., tolerance and harmony towards
                cultural, regional, linguistic, communal socioeconomic and other
                diversities (within 500 words).
              </h1>
              <button
                onClick={handleHelpOpen}
                className="c71x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='Write description in a maximum of 500 words'
               ></HelpButton>
            </div>
            <label htmlFor="714-t1" className="c71x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue714t1(e.target.value);
                setResponseValue714(e.target.value);
              }}
              value={value714t1}
              rows={10}
              className="c71x-textarea-style"
              id="714-t1"
            ></textarea>
            {value714t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c71x-Ql-table-style">
            <tr>
              <th className="c71x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Supporting documents on the information provided (as reflected
                in the administrative and academic activities of the
                Institution)
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  readOnly
                  onChange={(e) => {
                    setValue714f1(e.target.files[0]);
                    setPathValue714f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="714-f1"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue714f1 === "" ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue714f1("");
                        document.getElementById("714-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value714f1)} target="_blank">View File</a> */}
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Any other relevant information
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  readOnly
                  onChange={(e) => {
                    setValue714f2(e.target.files[0]);
                    setPathValue714f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="714-f2"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue714f2 === "" ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue714f2("");
                        document.getElementById("714-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                {/* <a href={downloadFile(value714f2)} target="_blank">View File</a> */}
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  );
}

export default Criteria71;
