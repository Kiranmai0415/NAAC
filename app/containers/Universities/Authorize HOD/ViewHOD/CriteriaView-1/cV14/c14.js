import React, { useState, useEffect } from 'react';
import './c14-style.css';
import AuthService from '../../../../../Pages/Users/services/auth.service';
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
import { resources } from "../../../../../appConstants";
// Help buttons functionality
function Help141(props) {
  return props.isHelp141Clicked ? (
    <div className="c14x-help-mainContainer">
      <div className="c14x-help-subContainer">
        <h1 className="c14x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c14x-help-para-style">
          Justify that the college satisfies the metric Describe it in maximum
          500 words.
        </p>
        <button
          className="c14x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp141Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Help buttons functionality
function Help142(props) {
  return props.isHelp142Clicked ? (
    <div className="c14x-help-mainContainer">
      <div className="c14x-help-subContainer">
        <h1 className="c14x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c14x-help-para-style">
          Justify that the college satisfies the metric Describe it in maximum
          500 words.
        </p>
        <button
          className="c14x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp142Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
// Promotion of Research and Facilities
function Criteria14() {
  // state variables
  const [value141f1, setValue141f1] = useState([]);
  const [value141f2, setValue141f2] = useState([]);
  const [value141f3, setValue141f3] = useState([]);
  const [value141t1, setValue141t1] = useState();
  const [value142f1, setValue142f1] = useState([]);
  const [value142f2, setValue142f2] = useState([]);
  const [value142t1, setValue142t1] = useState();
  const [value142t2, setValue142t2] = useState();
  const [pathValue141f1, setPathValue141f1] = useState('');
  const [pathValue141f2, setPathValue141f2] = useState('');
  const [pathValue141f3, setPathValue141f3] = useState('');
  const [pathValue142f1, setPathValue142f1] = useState('');
  const [pathValue142f2, setPathValue142f2] = useState('');
  const [help141Status, setHelp141Status] = useState(false);
  const [help142Status, setHelp142Status] = useState(false);

  const [responseValue141, setResponseValue141] = useState('');
  const [responseValue142, setResponseValue142] = useState('');

 //get data api
 const financialYear="2021-2022";

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
    () => fetch(resources.APPLICATION_URL+'criteria1getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then((response) =>
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));
          setValue141t1(data[0].criteria14Qn[0] ? data[0].criteria14Qn[0].input141t1 : "");
          setValue142t1(data[0].criteria14Qn[0] ? data[0].criteria14Qn[0].input142t1 : "");

          setResponseValue141(data[0].criteria14Qn[0] ? data[0].criteria14Qn[0].response141 : "");
          setResponseValue142(data[0].criteria14Qn[0] ? data[0].criteria14Qn[0].response142  : "");

          setValue141f1(data[0].criteria1FileUpload[0] ? data[0].criteria1FileUpload[0].criteria1FileName : "");
          setValue141f2(data[0].criteria1FileUpload[1] ? data[0].criteria1FileUpload[0].criteria1FileName : "");
          setValue142f1(data[0].criteria1FileUpload[2] ? data[0].criteria1FileUpload[0].criteria1FileName : "");
          setValue142f2(data[0].criteria1FileUpload[3] ? data[0].criteria1FileUpload[0].criteria1FileName : "");
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ),

    []
  );

  // getr data  with API

  function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
  }

   // sending data to db with API

   const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
    criteria14Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201, 
        input141t1: value141t1,
        input142t1: value142t1,
        response141: responseValue141,
        response142: responseValue142,
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
    <div className="c14-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c14x-colorIndicator-container">
        <p className="c14x-QlcolorIndicator-circle-style"></p>
        <span className="c14x-colorIndicator-span-style">Qualitative</span>
        <p className="c14x-QtcolorIndicator-circle-style"></p>
        <span className="c14x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c14x-weightage-heading-style">
            Key Indicator Weightage: 20
          </h1>
        </div>
      </div>
      {/* Key Indicator: 1.4.1 */}
      <div className="c14x-eachInputField-container">
        <form>
          <div className="c14x-label-textarea-container">
            <h1 className="c14x-heading-style">
              <span className="c14x-span-style">1.4.1: </span>
              Structured feedback for curriculum and its transactions is regularly obtained from stakeholders like Students, Teachers, Employers, Alumni, Academic peers etc., and Feedback processes of the institution may be classified as follows:
            </h1>
            <p className="c14x-para-style">
                  1.  Feedback collected, analysed, action taken & communicated to relevant body and feedback hosted on the institutional website
                  <br />
                  2.  Feedback collected, analysed, action has been taken and communicated to the relevant body
                  <br />
                  3. Feedback collected and analysed
                  <br />
                  4.  Feedback collected
                  <br />
                  5.  Feedback not collected
                </p>
            <h1 className="c14-radioHeading-style">Options:</h1>
            <form>
              <div className="c14-radioHeading-style">
                 <input readOnly
                  type="radio"
                  id="141-t1"
                  onChange={(e) => {
                    setValue141t1(e.target.value);
                  }}
                  name="dept"
                  value="All 4 of the above"
                />
                <label>A. All 4 of the above</label>
              </div>
              <div className="c14-radioHeading-style">
                 <input readOnly
                  type="radio"
                  id="141-t1"
                  onChange={(e) => {
                    setValue141t1(e.target.value);
                  }}
                  name="dept"
                  value="Any 3 of the above"
                />
                <label>B. Any 3 of the above</label>
              </div>
              <div className="c14-radioHeading-style">
                 <input readOnly
                  type="radio"
                  id="141-t1"
                  onChange={(e) => {
                    setValue141t1(e.target.value);
                  }}
                  name="dept"
                  value="Any 2 of the above"
                />
                <label>C. Any 2 of the above</label>
              </div>
              <div className="c14-radioHeading-style">
                 <input readOnly
                  type="radio"
                  id="141-t1"
                  onChange={(e) => {
                    setValue141t1(e.target.value);
                  }}
                  name="dept"
                  value="None of the above"
                />
                <label>D. None of the above</label>
              </div>
            </form>
          </div>
          <table className="c14x-Ql-table-style">
            <tr>
              <th className="c14x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c14x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c14x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c14x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c14x-Ql-tableBorders-style">
              Institutional data in the prescribed format (data template)              </td>
              <td><a href={downloadFile("un1.4.1.xlsx")} target="_blank">View Template</a></td>
              <td className="c14x-Ql-tableBorders-style">
                <a href={downloadFile(value141f1)} target="_blank">view</a>
              </td>
              <td className="c14x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c14x-Ql-tableBorders-style">
              At least 4 filled-in feedback form from different stake holders like Students, Teachers, Employers, Alumni etc.
              </td>
              <td>
              </td>
              <td className="c14x-Ql-tableBorders-style">
                <a href={downloadFile(value141f2)} target="_blank">view</a>
              </td>
              <td className="c14x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c14x-Ql-tableBorders-style">
              Feedback analysis report submitted to appropriate committee/bodies              </td>
              <td>
              </td>
              <td className="c14x-Ql-tableBorders-style">
                <a href={downloadFile(value141f3)} target="_blank">view</a>
              </td>
            </tr>
            <tr>
              <td className="c14x-Ql-tableBorders-style">
              Action taken report on the feedback analysis and its report to appropriate committee/bodies              </td>
              <td>
              </td>
              <td className="c14x-Ql-tableBorders-style">
                <a href={downloadFile(value141f3)} target="_blank">view</a>
              </td>
            </tr>
            <tr>
              <td className="c14x-Ql-tableBorders-style">
              Link of institution?s website where comprehensive feedback, its analytics and action taken report are hosted                </td>
              <td>
              </td>
              <td className="c14x-Ql-tableBorders-style">
                <a href={downloadFile(value141f3)} target="_blank">view</a>
              </td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 1.4.2 */}
      <div className="c14x-eachInputField-container">
        <form>
          <div className="c14x-label-textarea-container">
            <h1 className="c14x-heading-style">
              <span className="c14x-span-style">1.4.2: </span>
              Structured feedback for design and review of syllabus ( semester
              wise / year wise) is obtained from 1) Students, 2) Teachers, 3)
              Employers, 4) Alumni
            </h1>
            <h1 className="c14-radioHeading-style">Options:</h1>
            <form>
              <div className="c14-radioHeading-style">
                 <input readOnly
                  type="radio"
                  id="142-t1"
                  name="dept"
                  value="All 4 of the above"
                />
                <label>A. All 4 of the above</label>
              </div>
              <div className="c14-radioHeading-style">
                 <input readOnly
                  type="radio"
                  id="142-t1"
                  onChange={(e) => {
                    setValue142t1(e.target.value);
                  }}
                  name="dept"
                  value="Any 3 of the above"
                />
                <label>B. Any 3 of the above</label>
              </div>
              <div className="c14-radioHeading-style">
                 <input readOnly
                  type="radio"
                  id="142-t1"
                  onChange={(e) => {
                    setValue142t1(e.target.value);
                  }}
                  name="dept"
                  value="Any 2 of the above"
                />
                <label>C. Any 2 of the above</label>
              </div>
              <div className="c14-radioHeading-style">
                 <input readOnly
                  type="radio"
                  id="142-t1"
                  onChange={(e) => {
                    setValue142t1(e.target.value);
                  }}
                  name="dept"
                  value="None of the above"
                />
                <label>D. None of the above</label>
              </div>
            </form>
          </div>
          <table className="c14x-Ql-table-style">
            <tr>
              <th className="c14x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c14x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c14x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c14x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c14x-Ql-tableBorders-style">
                Any additional information
              </td>
              <td></td>
              <td className="c14x-Ql-tableBorders-style">
                <a href={downloadFile(value142f1)} target="_blank">view</a>
              </td>
              <td className="c14x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c14x-Ql-tableBorders-style">
               URL for stakeholder feedback report
              </td>
              <td><a href={downloadFile("un1.4.1.xlsx")} target="_blank">View Template</a></td>
              <td className="c14x-Ql-tableBorders-style">
                <a href={downloadFile(value142f2)} target="_blank">view</a>
              </td>
              <td className="c14x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  );
}
export default Criteria14;
