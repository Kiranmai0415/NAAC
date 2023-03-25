import React, { useState, useEffect } from "react";
import "./c35-style.css";
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

function Help351(props) {
  return props.isHelp351Clicked ? (
    <div className="c35x-help-mainContainer">
      <div className="c35x-help-subContainer">
        <h1 className="c35x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c35x-help-para-style">
          Total amount generated from consultancy and corporate training year
          wise during last five years (INR in lakhs)
        </p>
        <button
          className="c35x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp351Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help352(props) {
  return props.isHelp352Clicked ? (
    <div className="c35x-help-mainContainer">
      <div className="c35x-help-subContainer">
        <h1 className="c35x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c35x-help-para-style">
          Total amount spent on developing facilities, training teachers and
          staff for undertaking consultancy during the last five years. Data
          Requirement for last five years: (As per Data Template)
          <br />
          • Facility developed and amount spent
          <br />
          • Training programmes for teachers for undertaking consultancy
          <br />
          • Training programmes for staff for supporting consultancy activities.
          <br />• Total expenditure on training teachers and staff for
          consultancy <br />
        </p>
        <button
          className="c35x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp352Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Criteria35() {
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
  const [value3511f1, setValue3511f1] = useState("");
  const [pathValue3511f1, setPathValue3511f1] = useState("");
  const [value3511f2, setValue3511f2] = useState("");
  const [pathValue3511f2, setPathValue3511f2] = useState("");
  const [value3511f3, setValue3511f3] = useState("");
  const [pathValue3511f3, setPathValue3511f3] = useState("");
  const [value3511f4, setValue3511f4] = useState("");
  const [pathValue3511f4, setPathValue3511f4] = useState("");
  const [responseButtonStatus351, setResponseButtonStatus351] = useState(false);
  const [responseValue351, setResponseValue351] = useState("");
  const [help351Status, setHelp351Status] = useState(false);

  const [value3521t1, setValue3521t1] = useState();
  const [value3521t2, setValue3521t2] = useState();
  const [value3521t3, setValue3521t3] = useState();
  const [value3521t4, setValue3521t4] = useState();
  const [value3521t5, setValue3521t5] = useState();
  const [value3521t6, setValue3521t6] = useState();
  const [value3521t7, setValue3521t7] = useState();
  const [value3521t8, setValue3521t8] = useState();
  const [value3521t9, setValue3521t9] = useState();
  const [value3521t10, setValue3521t10] = useState();
  const [value3521f1, setValue3521f1] = useState("");
  const [pathValue3521f1, setPathValue3521f1] = useState("");
  const [value3521f2, setValue3521f2] = useState("");
  const [pathValue3521f2, setPathValue3521f2] = useState("");
  const [value3521f3, setValue3521f3] = useState("");
  const [pathValue3521f3, setPathValue3521f3] = useState("");
  const [value3521f4, setValue3521f4] = useState("");
  const [pathValue3521f4, setPathValue3521f4] = useState("");
  const [responseButtonStatus352, setResponseButtonStatus352] = useState(false);
  const [responseValue352, setResponseValue352] = useState("");
  const [help352Status, setHelp352Status] = useState(false);

  function onClickingViewResponse352() {
    if (
      value3521t6 === "" ||
      value3521t7 === "" ||
      value3521t8 === "" ||
      value3521t9 === "" ||
      value3521t10 === "" ||
      value3521t6 === undefined ||
      value3521t7 === undefined ||
      value3521t8 === undefined ||
      value3521t9 === undefined ||
      value3521t10 === undefined
    ) {
      setResponseValue352("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value3521t6, 10)) === false ||
      Number.isInteger(parseInt(value3521t7, 10)) === false ||
      Number.isInteger(parseInt(value3521t8, 10)) === false ||
      Number.isInteger(parseInt(value3521t9, 10)) === false ||
      Number.isInteger(parseInt(value3521t10, 10)) === false
    ) {
      setResponseValue352("Input should be an Integer");
    } else if (
      value3521t6 !== "" &&
      value3521t7 !== "" &&
      value3521t8 !== "" &&
      value3521t9 !== "" &&
      value3521t10 !== ""
    ) {
      setResponseValue352(
        parseInt(value3521t6, 10) +
          parseInt(value3521t7, 10) +
          parseInt(value3521t8, 10) +
          parseInt(value3521t9, 10) +
          parseInt(value3521t10, 10)
      );
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

  //get data api
  const financialYear = "2021-2022";
  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'criteria3getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            // setResponseValue111(data[0].criteria1FieldInfoQl[1].response111);
            // setResponseValue112(data[0].criteria1FieldInfoQn[2].response112);
            // setResponseValue113(data[0].criteria1FieldInfoQn[3].response113);

            setValue3521t1(data[0].yearTable3521[0] ? data[0].yearTable3521[0].input3521y : "");
            setValue3521t2(data[0].yearTable3521[0] ? data[0].yearTable3521[0].input3521y : "");
            setValue3521t3(data[0].yearTable3521[2] ? data[0].yearTable3521[0].input3521y : "");
            setValue3521t4(data[0].yearTable3521[3] ? data[0].yearTable3521[0].input3521y : "");
            setValue3521t5(data[0].yearTable3521[4] ? data[0].yearTable3521[0].input3521y : "");
            setValue3521t6(data[0].yearTable3521[0] ? data[0].yearTable3521[0].input3521v : "");
            setValue3521t7(data[0].yearTable3521[1] ? data[0].yearTable3521[0].input3521v : "");
            setValue3521t8(data[0].yearTable3521[2] ? data[0].yearTable3521[0].input3521v : "");
            setValue3521t9(data[0].yearTable3521[3] ? data[0].yearTable3521[0].input3521v : "");
            setValue3521t10(data[0].yearTable3521[4] ? data[0].yearTable3521[0].input3521v : "");
            setValue3511f1(data[0].criteria3FileUpload[0] ? data[0].yearTable3521[0].criteria3FileName : "");
            setValue3511f2(data[0].criteria3FileUpload[1] ? data[0].yearTable3521[0].criteria3FileName : "");
            setValue3511f3(data[0].criteria3FileUpload[0] ? data[0].yearTable3521[0].criteria3FileName : "");
            setValue3511f4(data[0].criteria3FileUpload[0] ? data[0].yearTable3521[0].criteria3FileName : "");
            setValue3521f1(data[0].criteria3FileUpload[1] ? data[0].yearTable3521[0].criteria3FileName : "");
            setValue3521f2(data[0].criteria3FileUpload[0] ? data[0].yearTable3521[0].criteria3FileName : "");
            setValue3521f3(data[0].criteria3FileUpload[0] ? data[0].yearTable3521[0].criteria3FileName : "");
            setValue3521f4(data[0].criteria3FileUpload[1] ? data[0].yearTable3521[0].criteria3FileName : "");
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

    criteria35Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        // response351: responseValue351,
        response352: responseValue352,
      },
    ],
    yearTable3521: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        input3521y: value3521t1,
        input3521v: value3521t6,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        input3521y: value3521t2,
        input3521v: value3521t7,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        input3521y: value3521t3,
        input3521v: value3521t8,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        input3521y: value3521t4,
        input3521v: value3521t9,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        input3521y: value3521t5,
        input3521v: value3521t10,
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
    <div className="c35-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c35x-colorIndicator-container">
        <p className="c35x-QlcolorIndicator-circle-style"></p>
        <span className="c35x-colorIndicator-span-style">Qualitative</span>
        <p className="c35x-QtcolorIndicator-circle-style"></p>
        <span className="c35x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c35x-weightage-heading-style">
            Key Indicator Weightage: 20
          </h1>
        </div>
      </div>

      {/* Key Indicator: 3.5.1 */}
      <div className="c35x-eachInputField-container">
        <div className="c35x-weightage-container">
          <h1 className="c35x-weightage-heading-style">Weightage: 20</h1>
        </div>
        <form>
          <div className="c35x-container">
            <div className="c35x-heading_Help-container">
              <h1 className="c35x-heading-style">
                <span className="c35x-span-style">3.5.1: </span>
                Revenue generated from consultancy and corporate training during the last five years (INR in Lakhs)
              </h1>
              <h1 className="c35x-heading-style">
                <span className="c35x-span-style">3.5.1.1: </span>
                Total amount generated from consultancy and corporate training year-wise during the last five years (INR in lakhs)              </h1>
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
            
            <table className="c32x-Qt-table-style">
              <tr>
                <th className="c32x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3211t1(e.target.value)}
                      id="3211-t1"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t1}
                    />
                    {value3211t1 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3211t2(e.target.value)}
                      id="3211-t2"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t2}
                    />
                    {value3211t2 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3211t3(e.target.value)}
                      id="3211-t3"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t3}
                    />
                    {value3211t3 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3211t4(e.target.value)}
                      id="3211-t4"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t4}
                    />
                    {value3211t4 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3211t5(e.target.value)}
                      id="3211-t5"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t5}
                    />
                    {value3211t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c32x-horizontalTable-heading-style">
                  INR in lakhs
                </th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue3211t6(e.target.value);
                        onClickingViewResponse321();
                      }}
                      id="3211-t6"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t6}
                    />
                    {value3211t6 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue3211t7(e.target.value);
                        onClickingViewResponse321();
                      }}
                      id="3211-t7"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t7}
                    />
                    {value3211t7 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue3211t8(e.target.value);
                        onClickingViewResponse321();
                      }}
                      id="3211-t8"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t8}
                    />
                    {value3211t8 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue3211t9(e.target.value);
                        onClickingViewResponse321();
                      }}
                      id="3211-t9"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t9}
                    />
                    {value3211t9 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => {
                        setValue3211t10(e.target.value);
                        onClickingViewResponse321();
                      }}
                      id="3211-t10"
                      className="c32x-input-style"
                      type="text"
                      value={value3211t10}
                    />
                    {value3211t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
          </div>
          <div className="c35xx-container">
            <table className="c35x-table-style">
              <tr>
                <th className="c35x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c35x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c35x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c35x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                Institutional data in the prescribed format (data template)
                </td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3511f1(e.target.files[0]);
                      setPathValue3511f1(e.target.value);
                    }}
                    id="3511-f1"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3511f1 === "" ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c35-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Audited statements of accounts indicating the revenue generated through and corporate training/consultancy.</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3511f2(e.target.files[0]);
                      setPathValue3511f2(e.target.value);
                    }}
                    id="3511-f2"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3511f2 === "" ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c35-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Letter from the corporate where training was imparted along with the fee paid.</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3511f3(e.target.files[0]);
                      setPathValue3511f3(e.target.value);
                    }}
                    id="3511-f3"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3511f3 === "" ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c35-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>CA certified copy of statement of accounts as attested by head of the institution.</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3511f4(e.target.files[0]);
                      setPathValue3511f4(e.target.value);
                    }}
                    id="3511-f4"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3511f4 === "" ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c35-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Letter from the beneficiary of the consultancy along with details of the consultancy fee..</td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3511f4(e.target.files[0]);
                      setPathValue3511f4(e.target.value);
                    }}
                    id="3511-f4"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3511f4 === "" ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c35-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 3.5.1 */}
      <div className="c35x-eachInputField-container">
        <div className="c35x-weightage-container">
          <h1 className="c35x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c35x-container">
            <div className="c35x-heading_Help-container">
              <h1 className="c35x-heading-style">
                <span className="c35x-span-style">3.5.2: </span>
                Revenue generated from consultancy and corporate training during
                the last five years (INR in Lakhs)
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
            <div className="c35x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus352(!responseButtonStatus352);
                  onClickingViewResponse352();
                }}
                className="c35x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus352 ? (
                <p className="c35x-responseResult-style">{responseValue352}</p>
              ) : null}
            </div>
          </div>
          <div className="c35xx-container">
            <h1 className="c35xx-Heading-style">
              <span className="c35xx-span-style">3.5.2.1: </span>: Total amount
              generated from consultancy and corporate training year-wise during
              the last five years (INR in lakhs)
            </h1>

            <table className="c35x-Qt-table-style">
              <tr>
                <th className="c35x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3521t1(e.target.value)}
                      id="3521-t1"
                      className="c35x-input-style"
                      type="text"
                      value={value3521t1}
                    />
                    {value3521t1 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3521t2(e.target.value)}
                      id="3521-t2"
                      className="c35x-input-style"
                      type="text"
                      value={value3521t2}
                    />
                    {value3521t2 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3521t3(e.target.value)}
                      id="3521-t3"
                      className="c35x-input-style"
                      type="text"
                      value={value3521t3}
                    />
                    {value3521t3 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3521t4(e.target.value)}
                      id="3521-t4"
                      className="c35x-input-style"
                      type="text"
                      value={value3521t4}
                    />
                    {value3521t4 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3521t5(e.target.value)}
                      id="3521-t5"
                      className="c35x-input-style"
                      type="text"
                      value={value3521t5}
                    />
                    {value3521t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c35x-horizontalTable-heading-style">
                  INR in lakhs
                </th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3521t6(e.target.value)}
                      id="3521-t6"
                      className="c35x-input-style"
                      type="text"
                      value={value3521t6}
                    />
                    {value3521t6 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3521t7(e.target.value)}
                      id="3521-t7"
                      className="c35x-input-style"
                      type="text"
                      value={value3521t7}
                    />
                    {value3521t7 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3521t8(e.target.value)}
                      id="3521-t8"
                      className="c35x-input-style"
                      type="text"
                      value={value3521t8}
                    />
                    {value3521t8 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3521t9(e.target.value)}
                      id="3521-t9"
                      className="c35x-input-style"
                      type="text"
                      value={value3521t9}
                    />
                    {value3521t9 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      readOnly
                      onChange={(e) => setValue3521t10(e.target.value)}
                      id="3521-t10"
                      className="c35x-input-style"
                      type="text"
                      value={value3521t10}
                    />
                    {value3521t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c35x-table-style">
              <tr>
                <th className="c35x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c35x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c35x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c35x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                  Audited statement/s of accounts indicating the revenue
                  generated through consultancy
                </td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3521f1(e.target.files[0]);
                      setPathValue3521f1(e.target.value);
                    }}
                    id="3521-f1"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3521f1 === "" ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c35-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td>
                <a href={downloadFile("un3.5.1.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3521f2(e.target.files[0]);
                      setPathValue3521f2(e.target.value);
                    }}
                    id="3521-f2"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3521f2 === "" ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c35-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Provide the List of consultants and revenue generated by them
                  (Data Template)
                </td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3521f3(e.target.files[0]);
                      setPathValue3521f3(e.target.value);
                    }}
                    id="3521-f3"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3521f3 === "" ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c35-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List of facilities and staff available for undertaking
                  consultancy
                </td>
                <td></td>
                <td>
                  <input
                    readOnly
                    onChange={(e) => {
                      setValue3521f4(e.target.files[0]);
                      setPathValue3521f4(e.target.value);
                    }}
                    id="3521-f4"
                    type="file"
                    className="c35-fileButton-style"
                  />
                  {pathValue3521f4 === "" ? null : (
                    <div className="c35-fileButtons-container">
                      <button className="c35-viewFileButton-style">
                        View File
                      </button>
                      <button className="c35-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c35x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Criteria35;
