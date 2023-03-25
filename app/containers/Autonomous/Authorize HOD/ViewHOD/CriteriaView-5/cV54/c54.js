import React, { useState, useEffect } from "react";
import "./c54-style.css";

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
function Help541(props) {
  return props.isHelp541Clicked ? (
    <div className="c54x-help-mainContainer">
      <div className="c54x-help-subContainer">
        <h1 className="c54x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c54x-help-para-style">
          Describe contribution of alumni association to the institution within
          a maximum of 500 words
        </p>
        <button
          className="c54x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp541Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help542(props) {
  return props.isHelp542Clicked ? (
    <div className="c54x-help-mainContainer">
      <div className="c54x-help-subContainer">
        <h1 className="c54x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c54x-help-para-style">
          Describe contribution of alumni association to the institution within
          a maximum of 500 words
        </p>
        <button
          className="c54x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp542Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria54() {
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
  const [value541t1, setValue541t1] = useState();
  const [value542t1, setValue542t1] = useState();

  const [pathValue541f1, setPathValue541f1] = useState("");
  const [value541f1, setValue541f1] = useState([]);
  const [pathValue541f2, setPathValue541f2] = useState("");
  const [value541f2, setValue541f2] = useState([]);
  const [pathValue542f1, setPathValue542f1] = useState("");
  const [value542f1, setValue542f1] = useState([]);
  const [responseButtonStatus542, setResponseButtonStatus542] = useState(false);
  const [responseValue541, setResponseValue541] = useState("");
  const [responseValue542, setResponseValue542] = useState("");
  const [help541Status, setHelp541Status] = useState(false);
  const [help542Status, setHelp542Status] = useState(false);

  // botton functionalities

  function onClickingViewResponse542() {
    if (value542t1 === "" || value542t1 === undefined || value542t1 === null) {
      setResponseValue542("Please select any option");
    } else {
      setResponseValue542(value542t1);
    }
  }
  //get call

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
        'http://localhost:8080/api/v1/criteria5getallfiles?collegeId='+collegeId+'&financialYear='+
        fYear +
        '&typeofInstitution='+instituteType
      ).then((response) =>
        response
          .json()
          .then((data) => {
            setValue541t1(data[0].criteria54Ql[0].input541t1);
            setValue542t1(data[0].criteria54Ql[0].input542t1);

            // setValue541f1(data[0].criteria1FileUpload[0].criteria1FileName);
            // setValue541f2(data[0].criteria1FileUpload[0].criteria1FileName);
            // setValue542f1(data[0].criteria1FileUpload[0].criteria1FileName);
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
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    criteria54Ql: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input542t1: value542t1,
        response542: responseValue542,
        input541t1: value541t1,
        response541: responseValue541,
      },
    ],
    // criteria5FieldInfoQn: [
    //   {
    //     criteriaId: { collegeId: '1', financialYear: financialYear, typeofInstitution: "autonomous" },
    //     uniqueKey1: 1,
    //   input542t1: value542t1,
    //   response542: responseValue542,
    // },
    // ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form54Data = new FormData();

    form54Data.append("criteria5Fieldinfo", jsonBlob(inputDataList));
    if (pathValue541f1 !== "") {
      form54Data.append("uploadfile5", value541f1, "f541f1-" + value541f1.name);
    }
    if (pathValue541f2 !== "") {
      form54Data.append("uploadfile5", value541f2, "f541f2-" + value541f2.name);
    }
    if (pathValue542f1 !== "") {
      form54Data.append("uploadfile5", value542f1, "f542f1-" + value542f1.name);
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form54Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria5upload",
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

  // rendering dom
  return (
    <div className="c54-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c54x-colorIndicator-container">
        <p className="c54x-QlcolorIndicator-circle-style"></p>
        <span className="c54x-colorIndicator-span-style">Qualitative</span>
        <p className="c54x-QtcolorIndicator-circle-style"></p>
        <span className="c54x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c54x-weightage-heading-style">
            Key Indicator Weightage: 10
          </h1>
        </div>
      </div>

      {/* Key Indicator: 5.4.1 */}
      <div className="c54x-eachInputField-container">
        <div className="c54x-weightage-container">
          <h1 className="c54x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c54x-container">
            <div className="c54x-heading_Help-container">
              <h1 className="c54x-heading-style">
                <span className="c54x-span-style">5.4.1: </span>
                Alumni contribution during the last five years to the institution 
                 through registered Alumni association
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
            <label htmlFor="541-t1" className="c54x-label-style">
              Response:
            </label>
            <textarea
              readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue541t1(e.target.value);
                setResponseValue541(e.target.value);
              }}
              value={value541t1}
              rows={10}
              className="c54x-textarea-style"
              id="541-t1"
            ></textarea>
            {value541t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>
          <div className="c54xx-container">
            <table className="c54x-table-style">
              <tr>
                <th className="c54x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c54x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c54x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c54x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Paste link for Additional Information</td>
                <td></td>
                <td>
                  <input
                    readonly
                    onChange={(e) => {
                      setValue541f1(e.target.files[0]);
                      setPathValue541f1(e.target.value);
                    }}
                    id="541-f1"
                    type="file"
                    className="c54-fileButton-style"
                  />
                  {pathValue541f1 === "" ? null : (
                    <div className="c54-fileButtons-container">
                      <button className="c54-viewFileButton-style">
                        View File
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue541f1("");
                          document.getElementById("541-f1").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  <a href={downloadFile(value541f1)} target="_blank">
                    View File
                  </a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                </td>
                <td className="c54x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any Additional Information</td>
                <td></td>
                <td>
                  <input
                    readonly
                    onChange={(e) => {
                      setValue541f2(e.target.files[0]);
                      setPathValue541f2(e.target.value);
                    }}
                    id="541-f2"
                    type="file"
                    className="c54-fileButton-style"
                  />
                  {pathValue541f2 === "" ? null : (
                    <div className="c54-fileButtons-container">
                      <button className="c54-viewFileButton-style">
                        View File
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue541f2("");
                          document.getElementById("541-f2").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  <a href={downloadFile(value541f2)} target="_blank">
                    View File
                  </a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                </td>
                <td className="c54x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 5.4.2 */}
      <div className="c54x-eachInputField-container">
        <div className="c54x-weightage-container">
          <h1 className="c54x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c54x-container">
            <div className="c54x-heading_Help-container">
              <div>
                <h1 className="c54x-heading-style">
                  <span className="c54x-span-style">5.4.2: </span>
                  Alumni contributes and engages significantly to the development of 
                institution through academic and other support system
                </h1>
                <div className="c54x-radio-container" style={{ width: "150%" }}>
                  <div
                    className="c54x-radio-subContainer"
                    style={{ width: "45%" }}
                  >
                    <div className="c54x-eachRadio-container">
                      <input
                        readonly
                        name="542options"
                        id="542-t1"
                        type="radio"
                        onChange={(e) => {
                          setValue542t1(e.target.value);
                        }}
                        value="15 Lakhs"
                      />
                      <label className="c54x-radioLabel-style" for="542-t1">
                        A. {"≥"} 15 Lakhs
                      </label>
                    </div>

                    <div className="c54x-eachRadio-container">
                      <input
                        readonly
                        name="542options"
                        id="542-t1"
                        type="radio"
                        onChange={(e) => {
                          setValue542t1(e.target.value);
                        }}
                        value="10Lakhs - 15 Lakhs"
                      />
                      <label className="c54x-radioLabel-style" for="542-t2">
                        B. 10Lakhs - 15 Lakhs
                      </label>
                    </div>

                    <div className="c54x-eachRadio-container">
                      <input
                        readonly
                        name="542options"
                        id="542-t1"
                        type="radio"
                        onChange={(e) => {
                          setValue542t1(e.target.value);
                        }}
                        value="5 Lakhs - 10 Lakhs       "
                      />
                      <label className="c54x-radioLabel-style" for="542-t1">
                        C. 5 Lakhs - 10 Lakhs
                      </label>
                    </div>
                  </div>
                  <div className="c54x-radio-subContainer">
                    <div className="c54x-eachRadio-container">
                      <input
                        readonly
                        name="542options"
                        id="542-t1"
                        type="radio"
                        onChange={(e) => {
                          setValue542t1(e.target.value);
                        }}
                        value="2 Lakhs - 5 Lakhs"
                      />

                      <label className="c54x-radioLabel-style" for="542-t2">
                        D. 2 Lakhs - 5 Lakhs
                      </label>
                    </div>

                    <div className="c54x-eachRadio-container">
                      <input
                        readonly
                        name="542options"
                        id="542-t1"
                        type="radio"
                        onChange={(e) => {
                          setValue542t1(e.target.value);
                        }}
                        value="2 Lakhs - 5 Lakhs"
                      />
                      <label className="c54x-radioLabel-style" for="542-t2">
                        E.{"<"}2 Lakhs
                      </label>
                    </div>
                  </div>
                </div>
              </div>
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
            <div className="c54x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus542(!responseButtonStatus542);
                  onClickingViewResponse542();
                }}
                className="c54x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus542 ? (
                <p className="c54x-responseResult-style">{responseValue542}</p>
              ) : null}
            </div>
          </div>

          <table className="c54x-table-style">
            <tr>
              <th className="c54x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c54x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c54x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c54x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Upload any Additional Information</td>
              <td></td>
              <td>
                <input
                  readonly
                  onChange={(e) => {
                    setValue542f1(e.target.files[0]);
                    setPathValue542f1(e.target.value);
                  }}
                  id="542-f1"
                  type="file"
                  className="c54-fileButton-style"
                />
                {pathValue542f1 === "" ? null : (
                  <div className="c54-fileButtons-container">
                    <button className="c54-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue542f1("");
                        document.getElementById("542-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value542f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c54x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  );
}

export default Criteria54;
