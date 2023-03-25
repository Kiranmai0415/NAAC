import React, { useState, useEffect } from "react";
import "./c64-style.css";

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
function Help641(props) {
  return props.isHelp641Clicked ? (
    <div className="c64x-help-mainContainer">
      <div className="c64x-help-subContainer">
        <h1 className="c64x-help-heading-style">
          Institution conducts internal and external financial audits regularly
        </h1>
        <p className="c64x-help-para-style">
          Enumerate the various internal and extenal financial audits carried
          out during the last five years with the mechanism for settling audit
          objections within a maximum of 500 words.
        </p>
        <button
          className="c64x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp641Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help642(props) {
  return props.isHelp642Clicked ? (
    <div className="c64x-help-mainContainer">
      <div className="c64x-help-subContainer">
        <h1 className="c64x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c64x-help-para-style">
          <span style={{ fontWeight: "bold" }}>(</span>Total Grants received
          from non-government bodies, individuals, Philanthropers year-wise
          during the last five years (INR in Lakhs)
          <span style={{ fontWeight: "bold" }}>) </span>
        </p>
        <button
          className="c64x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp642Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help643(props) {
  return props.isHelp643Clicked ? (
    <div className="c64x-help-mainContainer">
      <div className="c64x-help-subContainer">
        <h1 className="c64x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c64x-help-para-style">
          Describe the resource mobilisation policy and procedures of the
          Institution within a maximum of 500 words
        </p>
        <button
          className="c64x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp643Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria64() {
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
  const [value641t1, setValue641t1] = useState();

  const [value641f1, setValue641f1] = useState();
  const [pathValue641f1, setPathValue641f1] = useState("");
  const [value641f2, setValue641f2] = useState();
  const [pathValue641f2, setPathValue641f2] = useState("");
  const [value641f3, setValue641f3] = useState();
  const [pathValue641f3, setPathValue641f3] = useState("");

  const [responseValue641, setResponseValue641] = useState("");

  const [value6421t1, setValue6421t1] = useState();
  const [value6421t2, setValue6421t2] = useState();
  const [value6421t3, setValue6421t3] = useState();
  const [value6421t4, setValue6421t4] = useState();
  const [value6421t5, setValue6421t5] = useState();
  const [value6421t6, setValue6421t6] = useState();
  const [value6421t7, setValue6421t7] = useState();
  const [value6421t8, setValue6421t8] = useState();
  const [value6421t9, setValue6421t9] = useState();
  const [value6421t10, setValue6421t10] = useState();
  const [value6421f1, setValue6421f1] = useState("");
  const [pathValue6421f1, setPathValue6421f1] = useState("");
  const [value6421f2, setValue6421f2] = useState("");
  const [pathValue6421f2, setPathValue6421f2] = useState("");
  const [value6421f3, setValue6421f3] = useState("");
  const [pathValue6421f3, setPathValue6421f3] = useState("");
  const [responseButtonStatus642, setResponseButtonStatus642] = useState(false);
  const [responseValue642, setResponseValue642] = useState("");

  const [value643t1, setValue643t1] = useState();

  const [value643f1, setValue643f1] = useState();
  const [pathValue643f1, setPathValue643f1] = useState("");
  const [value643f2, setValue643f2] = useState();
  const [pathValue643f2, setPathValue643f2] = useState("");
  const [pathValue643f3, setPathValue643f3] = useState("");
  const [value643f3, setValue643f3] = useState();
  const [responseValue643, setResponseValue643] = useState("");

  const [help641Status, setHelp641Status] = useState(false);
  const [help642Status, setHelp642Status] = useState(false);
  const [help643Status, setHelp643Status] = useState(false);
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
            console.log(JSON.stringify(data));

            setValue641t1(data[0].criteria64Ql[0].input641t1);
            setValue643t1(data[0].criteria64Ql[0].input643t1);

            setValue6421t1(data[0].yearTable6421[0].input6421y);
            setValue6421t2(data[0].yearTable6421[1].input6421y);
            setValue6421t3(data[0].yearTable6421[2].input6421y);
            setValue6421t4(data[0].yearTable6421[3].input6421y);
            setValue6421t5(data[0].yearTable6421[4].input6421y);
            setValue6421t6(data[0].yearTable6421[0].input6421v);
            setValue6421t7(data[0].yearTable6421[1].input6421v);
            setValue6421t8(data[0].yearTable6421[2].input6421v);
            setValue6421t9(data[0].yearTable6421[3].input6421v);
            setValue6421t10(data[0].yearTable6421[4].input6421v);

            // setValue641f1(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue641f2(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue641f3(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue6421f1(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue6421f2(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue6421f3(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue643f1(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue643f2(data[0].criteria6FileUpload[0].criteria6FileName);
            // setValue643f3(data[0].criteria6FileUpload[0].criteria6FileName);
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );

  function onClickingViewResponse642() {
    if (
      value6421t6 === "" ||
      value6421t7 === "" ||
      value6421t8 === "" ||
      value6421t9 === "" ||
      value6421t10 === "" ||
      value6421t6 === undefined ||
      value6421t7 === undefined ||
      value6421t8 === undefined ||
      value6421t9 === undefined ||
      value6421t10 === undefined
    ) {
      setResponseValue642("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value6421t6, 10)) === false ||
      Number.isInteger(parseInt(value6421t7, 10)) === false ||
      Number.isInteger(parseInt(value6421t8, 10)) === false ||
      Number.isInteger(parseInt(value6421t9, 10)) === false ||
      Number.isInteger(parseInt(value6421t10, 10)) === false
    ) {
      setResponseValue642("Input should be an Integer");
    } else if (
      value6421t6 !== "" &&
      value6421t7 !== "" &&
      value6421t8 !== "" &&
      value6421t9 !== "" &&
      value6421t10 !== ""
    ) {
      setResponseValue642(
        parseInt(value6421t6, 10) +
          parseInt(value6421t7, 10) +
          parseInt(value6421t8, 10) +
          parseInt(value6421t9, 10) +
          parseInt(value6421t10, 10)
      );
    }
  }

  // sending data to db with API

  const inputDataList = {
    criteriaId: {
      collegeId: "1",
      financialYear: "2021-2022",
      typeofInstitution: "autonomous",
    },
    criteria64Ql: [
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 1,
        input641t1: value641t1,
        response641: responseValue641,
        input643t1: value643t1,
        response643: responseValue643,
      },
    ],
    criteria64Qn: [
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 1,
        response642: responseValue642,
      },
    ],
    yearTable6421: [
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 1,
        input6421y: value6421t1,
        input6421v: value6421t6,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 2,
        input6421y: value6421t2,
        input6421v: value6421t7,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 3,
        input6421y: value6421t3,
        input6421v: value6421t8,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 4,
        input6421y: value6421t4,
        input6421v: value6421t9,
      },
      {
        criteriaId: {
          collegeId: "1",
          financialYear: "2021-2022",
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 5,
        input6421y: value6421t5,
        input6421v: value6421t10,
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
    <div className="c64-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c64x-colorIndicator-container">
        <p className="c64x-QlcolorIndicator-circle-style"></p>
        <span className="c64x-colorIndicator-span-style">Qualitative</span>
        <p className="c64x-QtcolorIndicator-circle-style"></p>
        <span className="c64x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c64x-weightage-heading-style">
            Key Indicator Weightage: 15
          </h1>
        </div>
      </div>

      {/* Key Indicator: 6.4.1 */}
      <div className="c64x-eachInputField-container">
        <div className="c64x-weightage-container">
          <h1 className="c64x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c64x-Ql-label-textarea-container">
            <div className="c64x-heading_Help-container">
              <h1 className="c64x-heading-style">
                <span className="c64x-span-style">6.4.1: </span>
                Institutional strategies for mobilisation of funds other than salary 
                    and fees and the optimal utilisation of resources
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
            <label htmlFor="641-t1" className="c41x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue641t1(e.target.value);
                setResponseValue641(e.target.value);
              }}
              value={value641t1}
              rows={10}
              className="c64x-textarea-style"
              id="641-t1"
            ></textarea>
            {value641t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c64x-Ql-table-style">
            <tr>
              <th className="c64x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c64x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c64x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c64x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c64x-Ql-tableBorders-style">
                Strategic Plan and deployment documents on the website
              </td>
              <td className="c64x-Ql-tableBorders-style"></td>
              <td className="c64x-Ql-tableBorders-style">
                <input readonly
                  onChange={(e) => {
                    setValue641f1(e.target.files[0]);
                    setPathValue641f1(e.target.value);
                  }}
                  id="641-f1"
                  type="file"
                  className="c64-fileButton-style"
                />
                {pathValue641f1 === "" ? null : (
                  <div className="c64-fileButtons-container">
                    <button className="c64-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue641f1("");
                        document.getElementById("641-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value641f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c64x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c64x-Ql-tableBorders-style">
                Paste link for additional Information
              </td>
              <td className="c64x-Ql-tableBorders-style"></td>
              <td className="c64x-Ql-tableBorders-style">
                <input readonly
                  onChange={(e) => {
                    setValue641f2(e.target.files[0]);
                    setPathValue641f2(e.target.value);
                  }}
                  id="641-f2"
                  type="file"
                  className="c64-fileButton-style"
                />
                {pathValue641f2 === "" ? null : (
                  <div className="c64-fileButtons-container">
                    <button className="c64-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue641f2("");
                        document.getElementById("641-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value641f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c64x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c64x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c64x-Ql-tableBorders-style">
                {/* <a>View Template</a> */}
              </td>
              <td className="c64x-Ql-tableBorders-style">
                <input readonly
                  onChange={(e) => {
                    setValue641f3(e.target.files[0]);
                    setPathValue641f3(e.target.value);
                  }}
                  id="641-f3"
                  type="file"
                  className="c64-fileButton-style"
                />
                {pathValue641f3 === "" ? null : (
                  <div className="c64-fileButtons-container">
                    <button className="c64-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue641f3("");
                        document.getElementById("641-f3").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value641f3)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c64x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 6.4.2 */}
      <div className="c64x-eachInputField-container">
        <div className="c64x-weightage-container">
          <h1 className="c64x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c64x-container">
            <div className="c64x-heading_Help-container">
              <h1 className="c64x-heading-style">
                <span className="c64x-span-style">6.4.2: </span>
                Funds / Grants received from government bodies, non-government 
            bodies, and philanthropists during the last five years (not covered in 
                  Criterion III and V) 
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
                title='Upload the specific document as per descriptio'
                ></HelpButton>
            </div>
            <div className="c64x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus642(!responseButtonStatus642);
                  onClickingViewResponse642();
                }}
                className="c64x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus642 ? (
                <p className="c64x-responseResult-style">{responseValue642}</p>
              ) : null}
            </div>
          </div>
          <div className="c64xx-container">
            <h1 className="c64xx-Heading-style">
              <span className="c63xx-span-style">6.4.2.1: </span>
              Total Grants received from non-government bodies, individuals,
              Philanthropers year-wise during the last five years (INR in Lakhs)
            </h1>

            <table className="c64x-Qt-table-style">
              <tr>
                <th className="c64x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input readonly
                      onChange={(e) => setValue6421t1(e.target.value)}
                      id="6421-t1"
                      className="c64x-input-style"
                      type="text"
                      value={value6421t1}
                    />
                    {value6421t1 === "" ? (
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
                    <input readonly
                      onChange={(e) => setValue6421t2(e.target.value)}
                      id="6421-t2"
                      className="c64x-input-style"
                      type="text"
                      value={value6421t2}
                    />
                    {value6421t2 === "" ? (
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
                    <input readonly
                      onChange={(e) => setValue6421t3(e.target.value)}
                      id="6421-t3"
                      className="c64x-input-style"
                      type="text"
                      value={value6421t3}
                    />
                    {value6421t3 === "" ? (
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
                    <input readonly
                      onChange={(e) => setValue6421t4(e.target.value)}
                      id="6421-t4"
                      className="c64x-input-style"
                      type="text"
                      value={value6421t4}
                    />
                    {value6421t4 === "" ? (
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
                    <input readonly
                      onChange={(e) => setValue6421t5(e.target.value)}
                      id="6421-t5"
                      className="c64x-input-style"
                      type="text"
                      value={value6421t5}
                    />
                    {value6421t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c64x-horizontalTable-heading-style">
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
                    <input readonly
                      onChange={(e) => {
                        setValue6421t6(e.target.value);
                        onClickingViewResponse642();
                      }}
                      id="6421-t6"
                      className="c64x-input-style"
                      type="text"
                      value={value6421t6}
                    />
                    {value6421t6 === "" ? (
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
                    <input readonly
                      onChange={(e) => {
                        setValue6421t7(e.target.value);
                        onClickingViewResponse642();
                      }}
                      id="6421-t7"
                      className="c64x-input-style"
                      type="text"
                      value={value6421t7}
                    />
                    {value6421t7 === "" ? (
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
                    <input readonly
                      onChange={(e) => {
                        setValue6421t8(e.target.value);
                        onClickingViewResponse642();
                      }}
                      id="6421-t8"
                      className="c64x-input-style"
                      type="text"
                      value={value6421t8}
                    />
                    {value6421t8 === "" ? (
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
                    <input readonly
                      onChange={(e) => {
                        setValue6421t9(e.target.value);
                        onClickingViewResponse642();
                      }}
                      id="6421-t9"
                      className="c64x-input-style"
                      type="text"
                      value={value6421t9}
                    />
                    {value6421t9 === "" ? (
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
                    <input readonly
                      onChange={(e) => {
                        setValue6421t10(e.target.value);
                        onClickingViewResponse642();
                      }}
                      id="6421-t10"
                      className="c64x-input-style"
                      type="text"
                      value={value6421t10}
                    />
                    {value6421t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c64x-table-style">
              <tr>
                <th className="c64x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c64x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c64x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c64x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input readonly
                    onChange={(e) => {
                      setValue6421f1(e.target.files[0]);
                      setPathValue6421f1(e.target.value);
                    }}
                    id="6421-f1"
                    type="file"
                    className="c64-fileButton-style"
                  />
                  {pathValue6421f1 === "" ? null : (
                    <div className="c64-fileButtons-container">
                      <button className="c64-viewFileButton-style">
                        View File
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue6421f1("");
                          document.getElementById("6421-f1").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  <a href={downloadFile(value6421f1)} target="_blank">
                    View File
                  </a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                </td>
                <td className="c64x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Minutes of the relevant bodies of the Institution</td>
                <td></td>
                <td>
                  <input readonly
                    onChange={(e) => {
                      setValue6421f2(e.target.files[0]);
                      setPathValue6421f2(e.target.value);
                    }}
                    id="6421-f2"
                    type="file"
                    className="c64-fileButton-style"
                  />
                  {pathValue6421f2 === "" ? null : (
                    <div className="c64-fileButtons-container">
                      <button className="c64-viewFileButton-style">
                        View File
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue6421f2("");
                          document.getElementById("6421-f2").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  <a href={downloadFile(value6421f2)} target="_blank">
                    View File
                  </a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                </td>
                <td className="c64x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Budget and expenditure statements signed by the Finance
                  Officer indicating seed money provided and utilized
                </td>
                <td>
                <a href={downloadFile("au6.4.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <input readonly
                    onChange={(e) => {
                      setValue6421f3(e.target.files[0]);
                      setPathValue6421f3(e.target.value);
                    }}
                    id="6421-f3"
                    type="file"
                    className="c64-fileButton-style"
                  />
                  {pathValue6421f3 === "" ? null : (
                    <div className="c64-fileButtons-container">
                      <button className="c64-viewFileButton-style">
                        View File
                      </button>
                      <button
                        className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue6421f3("");
                          document.getElementById("6421-f3").value = "";
                        }}
                      >
                        Reset
                      </button>
                    </div>
                  )}
                  <a href={downloadFile(value6421f3)} target="_blank">
                    View File
                  </a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                </td>
                <td className="c64x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>
      {/* Key Indicator: 6.4.3 */}
      <div className="c64x-eachInputField-container">
        <div className="c64x-weightage-container">
          <h1 className="c64x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c64x-Ql-label-textarea-container">
            <div className="c64x-heading_Help-container">
              <h1 className="c64x-heading-style">
                <span className="c64x-span-style">6.4.3: </span>
                Institution conducts internal and external financial audits regularly
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
                title='file description'
                ></HelpButton>
            </div>
            <label htmlFor="643-t1" className="c43x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue643t1(e.target.value);
                setResponseValue643(e.target.value);
              }}
              value={value643t1}
              rows={10}
              className="c64x-textarea-style"
              id="643-t1"
            ></textarea>
            {value643t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c64x-Ql-table-style">
            <tr>
              <th className="c64x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c64x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c64x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c64x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c64x-Ql-tableBorders-style">
                Strategic Plan and deployment documents on the website
              </td>
              <td className="c64x-Ql-tableBorders-style"></td>
              <td className="c64x-Ql-tableBorders-style">
                <input readonly
                  onChange={(e) => {
                    setValue643f1(e.target.files[0]);
                    setPathValue643f1(e.target.value);
                  }}
                  id="643-f1"
                  type="file"
                  className="c64-fileButton-style"
                />
                {pathValue643f1 === "" ? null : (
                  <div className="c64-fileButtons-container">
                    <button className="c64-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue643f1("");
                        document.getElementById("643-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value643f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c64x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c64x-Ql-tableBorders-style">
                Paste link for additional Information
              </td>
              <td className="c64x-Ql-tableBorders-style"></td>
              <td className="c64x-Ql-tableBorders-style">
                <input readonly
                  onChange={(e) => {
                    setValue643f2(e.target.files[0]);
                    setPathValue643f2(e.target.value);
                  }}
                  id="643-f1"
                  type="file"
                  className="c64-fileButton-style"
                />
                {pathValue643f2 === "" ? null : (
                  <div className="c64-fileButtons-container">
                    <button className="c64-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue643f2("");
                        document.getElementById("643-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value643f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c64x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c64x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c64x-Ql-tableBorders-style">
                {/* <a>View Template</a> */}
              </td>
              <td className="c64x-Ql-tableBorders-style">
                <input readonly
                  onChange={(e) => {
                    setValue643f3(e.target.files[0]);
                    setPathValue643f3(e.target.value);
                  }}
                  id="643-f3"
                  type="file"
                  className="c64-fileButton-style"
                />
                {pathValue643f3 === "" ? null : (
                  <div className="c64-fileButtons-container">
                    <button className="c64-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue643f3("");
                        document.getElementById("643-f3").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value643f3)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c64x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  );
}

export default Criteria64;
