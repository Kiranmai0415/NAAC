import React, { useState, useEffect } from "react";
import "./c54-style.css";
import AuthService from "../../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
import { resources } from "../../../../../appConstants";

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

  const [responseValue541, setResponseValue541] = useState("");
  const [responseValue542, setResponseValue542] = useState("");
  const [help541Status, setHelp541Status] = useState(false);
  const [help542Status, setHelp542Status] = useState(false);

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
        resources.APPLICATION_URL+'criteria5getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            setValue541t1(data[0].criteria54Ql[0] ? data[0].criteria54Ql[0].input541t1 : "");
            setValue542t1(data[0].criteria54Ql[0] ? data[0].criteria54Ql[0].input542t1 : "");
            setValue541f1(data[0].criteria5FileUpload[0] ? data[0].criteria5FileUpload[0].criteria5FileName : "");
            setValue541f2(data[0].criteria5FileUpload[1] ? data[0].criteria5FileUpload[1].criteria5FileName : "");
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

    criteria54Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input541t1: value541t1,
        input542t1: value542t1,
        response542: responseValue542,
        response541: responseValue541,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
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
                Alumni contribution during the last five years (INR in lakhs)to the 
                University through registered Alumni Association
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
              readOnly
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
                  <a href={downloadFile(value541f1)} target="_blank">
                    view
                  </a>
                </td>
                <td className="c54x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any Additional Information</td>
                <td></td>
                <td>
                  <a href={downloadFile(value541f2)} target="_blank">
                    view
                  </a>
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
              <h1 className="c54x-heading-style">
                <span className="c54x-span-style">5.4.2: </span>
                Alumni contributes and engages significantly to the development of 
                     University through academic and other support system
              </h1>

              <div className="c54x-radio-container">
                <div className="c54x-radio-subContainer">
                  <div className="c54x-eachRadio-container">
                    <input
                      readOnly
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
                      readOnly
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
                      readOnly
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
                  <div className="c54x-radio-subContainer">
                    <div className="c54x-eachRadio-container">
                      <input
                        readOnly
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
                        readOnly
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
                <a href={downloadFile(value542f1)} target="_blank">
                  view
                </a>
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
