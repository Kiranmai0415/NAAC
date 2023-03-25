import React, { useState } from 'react';
import './c13-style.css';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import { HelpButton } from "../../../../../reusableComponents/model/Help";
import { resources } from "../../../../appConstants";

// Alert custom messages start
const successMessage = (message) => {
  toast.success(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "success1",
    className: "success"
  });
};
const errorMessage = (message) => {
  toast.error(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "error1",
    className: "error"
  });
};
// End here

// Help buttons functionality
function Help131(props) {
  return props.isHelp131Clicked ? (
    <div className="c13x-help-mainContainer">
      <div className="c13x-help-subContainer">
        <h1 className="c13x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c13x-help-para-style">
          Justify that the college satisfies the metric Describe it in maximum
          500 words.
        </p>
        <button
          className="c13x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp131Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help132(props) {
  return props.isHelp132Clicked ? (
    <div className="c13x-help-mainContainer">
      <div className="c13x-help-subContainer">
        <h1 className="c13x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c13x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>The total amount of seed
          money provided by institution to its teachers for research in the last
          five years
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>
        <button
          className="c13x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp132Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help133(props) {
  return props.isHelp133Clicked ? (
    <div className="c13x-help-mainContainer">
      <div className="c13x-help-subContainer">
        <h1 className="c13x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c13x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>Number of students
          enrolled in subject related Certificate or Add-on programs year wise
          during last five years<span style={{ fontWeight: 'bold' }}> / </span>
          Total number of Students
          <span style={{ fontWeight: 'bold' }}>) * </span>100
        </p>
        <p className="c13x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span> Average percentage
          <span style={{ fontWeight: 'bold' }}> = </span>Σpercentage per year
          <span style={{ fontWeight: 'bold' }}>) / </span>5
        </p>
        <button
          className="c13x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp133Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help134(props) {
  return props.isHelp134Clicked ? (
    <div className="c13x-help-mainContainer">
      <div className="c13x-help-subContainer">
        <h1 className="c13x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c13x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span> Number of students
          undertaking field projects / internships / student projects
          <span style={{ fontWeight: 'bold' }}> /</span> Total number of
          students
          <span style={{ fontWeight: 'bold' }}>)*</span>100
        </p>
        <button
          className="c13x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp134Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
// Promotion of Research and Facilities
function Criteria13() {

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



  // state variable
  const [value131t1, setValue131t1] = useState();
  const [pathValue131f1, setPathValue131f1] = useState('');
  const [pathValue131f2, setPathValue131f2] = useState('');

  const [value131f1, setValue131f1] = useState([]);
  const [value131f2, setValue131f2] = useState([]);

  const [value1321t1, setValue1321t1] = useState();
  const [value1321t2, setValue1321t2] = useState();
  const [value1321t3, setValue1321t3] = useState();
  const [value1321t4, setValue1321t4] = useState();
  const [value1321t5, setValue1321t5] = useState();
  const [value1321t6, setValue1321t6] = useState();
  const [value1321t7, setValue1321t7] = useState();
  const [value1321t8, setValue1321t8] = useState();
  const [value1321t9, setValue1321t9] = useState();
  const [value1321t10, setValue1321t10] = useState();

  const [pathValue1321f1, setPathValue1321f1] = useState('');
  const [pathValue1321f2, setPathValue1321f2] = useState('');
  const [pathValue1321f3, setPathValue1321f3] = useState('');

  const [value1321f1, setValue1321f1] = useState([]);
  const [value1321f2, setValue1321f2] = useState([]);
  const [value1321f3, setValue1321f3] = useState([]);

  const [value1331t1, setValue1331t1] = useState();
  const [value1331t2, setValue1331t2] = useState();
  const [value1331t3, setValue1331t3] = useState();
  const [value1331t4, setValue1331t4] = useState();
  const [value1331t5, setValue1331t5] = useState();
  const [value1331t6, setValue1331t6] = useState();
  const [value1331t7, setValue1331t7] = useState();
  const [value1331t8, setValue1331t8] = useState();
  const [value1331t9, setValue1331t9] = useState();
  const [value1331t10, setValue1331t10] = useState();
  const [value1331t11, setValue1331t11] = useState();
  const [value1331t12, setValue1331t12] = useState();
  const [value1331t13, setValue1331t13] = useState();
  const [value1331t14, setValue1331t14] = useState();
  const [value1331t15, setValue1331t15] = useState();
  const [value1331t16, setValue1331t16] = useState();
  const [value1331t17, setValue1331t17] = useState();
  const [value1331t18, setValue1331t18] = useState();
  const [value1331t19, setValue1331t19] = useState();
  const [value1331t20, setValue1331t20] = useState();

  const [pathValue1331f1, setPathValue1331f1] = useState('');
  const [pathValue1331f2, setPathValue1331f2] = useState('');

  const [value1331f1, setValue1331f1] = useState([]);
  const [value1331f2, setValue1331f2] = useState([]);
  const [value1341t1, setValue1341t1] = useState();
  const [value1341t2, setValue1341t2] = useState();
  const [pathValue1341f1, setPathValue1341f1] = useState('');
  const [pathValue1341f2, setPathValue1341f2] = useState('');

  const [value1341f1, setValue1341f1] = useState([]);
  const [value1341f2, setValue1341f2] = useState([]);
  const [value1341f3, setValue1341f3] = useState([]);

  const [responseButtonStatus132, setResponseButtonStatus132] = useState(false);
  const [responseButtonStatus133, setResponseButtonStatus133] = useState(false);
  const [responseButtonStatus134, setResponseButtonStatus134] = useState(false);
  const [responseValue131, setResponseValue131] = useState('');
  const [responseValue132, setResponseValue132] = useState('');
  const [responseValue133, setResponseValue133] = useState('');
  const [responseValue134, setResponseValue134] = useState('');
  const [help131Status, setHelp131Status] = useState(false);
  const [help132Status, setHelp132Status] = useState(false);
  const [help133Status, setHelp133Status] = useState(false);
  const [help134Status, setHelp134Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");
  const [fileremoveSrc111f2, setFileremoveSrc111f2] = useState("null");

  // response button functionality

  function onClickingViewResponse132() {
    if (
      value1321t6 === ''
      || value1321t7 === ''
      || value1321t8 === ''
      || value1321t9 === ''
      || value1321t10 === ''
      || value1321t6 === undefined
      || value1321t7 === undefined
      || value1321t8 === undefined
      || value1321t9 === undefined
      || value1321t10 === undefined
    ) {
      setResponseValue132('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value1321t6, 10)) === false
      || Number.isInteger(parseInt(value1321t7, 10)) === false
      || Number.isInteger(parseInt(value1321t8, 10)) === false
      || Number.isInteger(parseInt(value1321t9, 10)) === false
      || Number.isInteger(parseInt(value1321t10, 10)) === false
    ) {
      setResponseValue132('Input should be an Integer');
    } else if (
      value1321t6 !== ''
      && value1321t7 !== ''
      && value1321t8 !== ''
      && value1321t9 !== ''
      && value1321t10 !== ''
    ) {
      setResponseValue132(
        parseInt(value1321t6, 10)
        + parseInt(value1321t7, 10)
        + parseInt(value1321t8, 10)
        + parseInt(value1321t9, 10)
        + parseInt(value1321t10, 10)
      );
    }
  }

  function onClickingViewResponse133() {
    // if (
    //   value1331t6 === ''
    //   || value1331t7 === ''
    //   || value1331t8 === ''
    //   || value1331t9 === ''
    //   || value1331t10 === ''
    //   || value1331t16 === ''
    //   || value1331t17 === ''
    //   || value1331t18 === ''
    //   || value1331t19 === ''
    //   || value1331t20 === ''
    //   || value1331t6 === undefined
    //   || value1331t7 === undefined
    //   || value1331t8 === undefined
    //   || value1331t9 === undefined
    //   || value1331t10 === undefined
    //   || value1331t16 === undefined
    //   || value1331t17 === undefined
    //   || value1331t18 === undefined
    //   || value1331t19 === undefined
    //   || value1331t20 === undefined
    // ) {
    //   setResponseValue133('Please fill the required fields');
    // } else if (
    //   Number.isInteger(parseInt(value1331t6, 10)) === false
    //   || Number.isInteger(parseInt(value1331t7, 10)) === false
    //   || Number.isInteger(parseInt(value1331t8, 10)) === false
    //   || Number.isInteger(parseInt(value1331t9, 10)) === false
    //   || Number.isInteger(parseInt(value1331t10, 10)) === false
    //   || Number.isInteger(parseInt(value1331t16, 10)) === false
    //   || Number.isInteger(parseInt(value1331t17, 10)) === false
    //   || Number.isInteger(parseInt(value1331t18, 10)) === false
    //   || Number.isInteger(parseInt(value1331t19, 10)) === false
    //   || Number.isInteger(parseInt(value1331t20, 10)) === false
    // ) {
    //   setResponseValue133('Input should be an Integer');
    // } else if (
    //   value1331t6 !== ''
    //   && value1331t7 !== ''
    //   && value1331t8 !== ''
    //   && value1331t9 !== ''
    //   && value1331t10 !== ''
    //   && value1331t16 !== ''
    //   && value1331t17 !== ''
    //   && value1331t18 !== ''
    //   && value1331t19 !== ''
    //   && value1331t20 !== ''
    // ) {
    //   setResponseValue133(
    //     ((value1331t6 / value1331t16) * 100
    //       + (value1331t7 / value1331t17) * 100
    //       + (value1331t8 / value1331t18) * 100
    //       + (value1331t9 / value1331t19) * 100
    //       + (value1331t10 / value1331t20) * 100)
    //       / 5
    //   );
    // }
    if (value1331t1 === '' || value1331t2 === '' || value1331t1 === undefined || value1331t2 === undefined) {
      setResponseValue133('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value1331t1, 10)) === false
      || Number.isInteger(parseInt(value1331t2, 10)) === false
    ) {
      setResponseValue133('Input should be an Integer');
    } else if (value1331t1 !== '' && value1331t2 !== '') {
      setResponseValue133((parseInt(value1331t1) / parseInt(value1331t2))) * 100;
    }
  }


  // function onClickingViewResponse134() {
  //   if (setValue1341t1 === '' || value1341t1 === '') {
  //     setResponseValue134('Please fill the required fields');
  //   } else if (
  //     Number.isInteger(parseInt(value1341t1, 10)) === false
  //     || Number.isInteger(parseInt(value1341t2, 10)) === false
  //   ) {
  //     setResponseValue134('Input should be an Integer');
  //   } else if (setValue1341t2 !== '' && value1341t2 !== '') {
  //     setResponseValue134(
  //       (parseInt(value1341t1, 10) / parseInt(value1341t2, 10)) * 100
  //     );
  //   }
  // }
  // sending data to db with API

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
  const inputDataList = {

    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
    criteria13Ql: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
        input131t1: value131t1,
        response131: responseValue131,
        criteria13status: "save"
      },
    ],
    criteria13Qn: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
        input1341t1: value1341t1,
        input1341t2: value1341t2,
        response132: responseValue132,
        response133: responseValue133,
        response134: responseValue134,
        criteria13status: "save"
      },
    ],

    yearTable1321: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201, input1321y: value1321t1, input1321v: value1321t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202, input1321y: value1321t2, input1321v: value1321t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203, input1321y: value1321t3, input1321v: value1321t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204, input1321y: value1321t4, input1321v: value1321t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205, input1321y: value1321t5, input1321v: value1321t10
      },
    ],
    yearTable1331: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201, input1331y: value1331t1, input1331v: value1331t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202, input1331y: value1331t2, input1331v: value1331t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203, input1331y: value1331t3, input1331v: value1331t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204, input1331y: value1331t4, input1331v: value1331t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205, input1331y: value1331t5, input1331v: value1331t10
      },
    ],
    yearTable13312: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201, input13312y: value1331t11, input13312v: value1331t16
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202, input13312y: value1331t12, input13312v: value1331t17
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203, input13312y: value1331t13, input13312v: value1331t18
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204, input13312y: value1331t14, input13312v: value1331t19
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205, input13312y: value1331t15, input13312v: value1331t20
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form13Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form13Data.append('criteria1Fieldinfo', jsonBlob(inputDataList));
    if (pathValue131f1 !== '') {
      form13Data.append('uploadfile1', value131f1, 'f131f1-' + value131f1.name);
    }
    if (pathValue131f2 !== '') {
      form13Data.append('uploadfile1', value131f2, 'f131f2-' + value131f2.name);
    }
    if (pathValue1321f1 !== '') {
      form13Data.append(
        'uploadfile1',
        value1321f1,
        'f1321f1-' + value1321f1.name
      );
    }

    if (pathValue1321f2 !== '') {
      form13Data.append(
        'uploadfile1',
        value1321f2,
        'f1321f2-' + value1321f2.name
      );
    }
    if (pathValue1321f3 !== '') {
      form13Data.append(
        'uploadfile1',
        value1321f3,
        'f1321f3-' + value1321f3.name
      );
    }
    if (pathValue1331f1 !== '') {
      form13Data.append(
        'uploadfile1',
        value1331f1,
        'f1331f1-' + value1331f1.name
      );
    }
    if (pathValue1331f2 !== '') {
      form13Data.append(
        'uploadfile1',
        value1331f2,
        'f1331f2-' + value1331f2.name
      );
    }
    if (pathValue1341f1 !== '') {
      form13Data.append(
        'uploadfile1',
        value1341f1,
        'f1341f1-' + value1341f1.name
      );
    }
    if (pathValue1341f2 !== '') {
      form13Data.append(
        'uploadfile1',
        value1341f2,
        'f1341f2-' + value1341f2.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form13Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria1upload",
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
      fileReader.addEventListener('load', (event) => {
        setFilePreviewSrc111f1(event.target.result);
      });
    }
  }
  // rendering DOM
  return (
    <div className="c13-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c13x-colorIndicator-container">
        <p className="c13x-QlcolorIndicator-circle-style"></p>
        <span className="c13x-colorIndicator-span-style">Qualitative</span>
        <p className="c13x-QtcolorIndicator-circle-style"></p>
        <span className="c13x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c13x-weightage-heading-style">
            Key Indicator Weightage: 40
          </h1>
        </div>
      </div>

      {/* Key Indicator: 1.3.1 */}
      <div className="c13x-eachInputField-container">
        <div className="c13x-weightage-container">
          <h1 className="c13x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c13x-Ql-label-textarea-container">
            <div className="c13x-heading_Help-container">
              <h1 className="c13x-heading-style">
                <span className="c13x-span-style">1.3.1: </span>
                Institution integrates cross-cutting issues relevant to Professional Ethics, Gender, Human Values, Environment & Sustainability and other value framework enshrined in Sustainable Development goals and National Education Policy – 2020 into the Curriculum
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
            <label htmlFor="131-t1" className="c13x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue131t1(e.target.value);
                setResponseValue131(e.target.value);
              }}
              value={value131t1}
              rows={10}
              className="c13x-textarea-style"
              id="131-t1"
            ></textarea>
            {value131t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c13x-Ql-table-style">
            <tr>
              <th className="c13x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c13x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c13x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c13x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c13x-Ql-tableBorders-style">
                Upload Additional information
              </td>
              <td className="c13x-Ql-tableBorders-style"></td>
              <td className="c13x-Ql-tableBorders-style">
                {/* <input
                  onChange={(e) => {
                    setValue131f1(e.target.files[0]);
                    setPathValue131f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="131-f1"
                  type="file"
                  className="c13-fileButton-style"
                />
                {pathValue131f1 === '' ? null : (
                  <div className="c13-fileButtons-container">
                    <button className="c13-viewFileButton-style">
                      View File
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue131f1("");
                      document.getElementById("131-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )} */}
                <td>
                  <input
                    type="file"
                    id="131-f1"
                    onChange={(e) => {
                      setValue131f1(e.target.files[0]);
                      setPathValue131f1(e.target.value);
                      showFilePreview(e);
                      FileRemove(e);
                    }}
                  />
                  {pathValue131f1 === "" ? null : (
                    <div className="c11-31-fileButtons-container">
                      <button className="c11-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button className="c11-removeFileButton-style">
                        <a target="_openfile" href={fileremoveSrc111f2}>
                          {" "}
                          Remove File
                        </a>
                      </button>
                    </div>
                  )}
                </td>
              </td>
              <td className="c13x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c13x-Ql-tableBorders-style">
                Provide Link for Additional information
              </td>
              <td></td>
              <td className="c13x-Ql-tableBorders-style">
                {/* <input
                  onChange={(e) => {
                    setValue131f2(e.target.files[0]);
                    setPathValue131f2(e.target.value);
                    showFilePreview(e);

                  }}
                  id="131-f2"
                  type="file"
                  className="c13-fileButton-style"
                />
                {pathValue131f2 === '' ? null : (
                  <div className="c13-fileButtons-container">
                    <button className="c13-viewFileButton-style">
                      View File
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue131f2("");
                      document.getElementById("131-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )} */}
                <td>
                  <input
                    type="file"
                    id="131-f2"
                    onChange={(e) => {
                      setValue131f2(e.target.files[0]);
                      setPathValue131f2(e.target.value);
                      showFilePreview(e);
                      FileRemove(e);
                    }}
                  />
                  {pathValue131f2 === "" ? null : (
                    <div className="c11-31-fileButtons-container">
                      <button className="c11-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}>
                          {" "}
                          View File
                        </a>
                      </button>
                      <button className="c11-removeFileButton-style">
                        <a target="_openfile" href={fileremoveSrc111f2}>
                          {" "}
                          Remove File
                        </a>
                      </button>
                    </div>
                  )}
                </td>
              </td>
              <td className="c13x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 1.3.2 */}
      <div className="c13x-eachInputField-container">
        <div className="c13x-weightage-container">
          <h1 className="c13x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c13x-container">
            <div className="c13x-heading_Help-container">
              <h1 className="c13x-heading-style">
                <span className="c13x-span-style">1.3.2: </span>
                Number of certificate / value-added courses / Diploma Programme/ online courses of MOOCS / SWAYAM / e_Pathshala/ NPTEL etc. where the students of the institution have enrolled and successfully completed

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
                title='Upload the specific document as per description '
                ></HelpButton>
            </div>
            <div className="c13x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp132Status(true);
                }}
                className="c13x-helpButton-style"
              >
                Help
              </button>
              <Help132
                isHelp132Clicked={help132Status}
                setIsHelp132Clicked={setHelp132Status}
              />*/}
            </div> 

            </div>
            <div className="c13xx-container">
              <h1 className="c13xx-Heading-style">
                <span className="c13xx-span-style">1.3.2.1: </span>
                How many certificate/value added courses/Diploma Programme/ online courses of MOOCS/SWAYAM/e Pathshala/ NPTEL etc (without repeat count) where the students of the institution have enrolled and successfully completed.

                <input
                  onChange={(e) => setValue1321t1(e.target.value)}
                  id="1321-t1"
                  style={{ width: "25%", marginLeft: "4.6%" }}
                  type="number"
                /></h1>



              <table className="c13x-table-style">
                <tr>
                  <th className="c13x-Qt-verticalTable-heading1-style">
                    File Description
                  </th>
                  <th className="c13x-Qt-verticalTable-heading2-style">
                    File Template
                  </th>
                  <th className="c13x-Qt-verticalTable-heading3-style">
                    Documents upload
                  </th>
                  <th className="c13x-Qt-verticalTable-heading4-style">
                    File type and size
                  </th>
                </tr>
                <tr>
                  <td>List of students and the attendance sheet for the above mentioned programs </td>
                  <td></td>
                  <td>
                    {/* <input
                    onChange={(e) => {
                      setValue1321f1(e.target.files[0]);
                      setPathValue1321f1(e.target.value);
                      showFilePreview(e);

                    }}
                    id="1321-f1"
                    type="file"
                    className="c13-fileButton-style"
                  />
                  {pathValue1321f1 === '' ? null : (
                    <div className="c13-fileButtons-container">
                      <button className="c13-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue1321f1("");
                      document.getElementById("1321-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )} */}
                    <input
                      type="file"
                      id="1321-f1"
                      onChange={(e) => {
                        setValue1321f1(e.target.files[0]);
                        setPathValue1321f1(e.target.value);
                        showFilePreview(e);
                        FileRemove(e);
                      }}
                    />
                    {pathValue1321f1 === "" ? null : (
                      <div className="c11-31-fileButtons-container">
                        <button className="c11-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}>
                            {" "}
                            View File
                          </a>
                        </button>
                        <button className="c11-removeFileButton-style">
                          <a target="_openfile" href={fileremoveSrc111f2}>
                            {" "}
                            Remove File
                          </a>
                        </button>
                      </div>
                    )}

                  </td>
                  <td className="c13x-Qt-tableBorders-style">pdf</td>
                </tr>
                <tr>
                  <td>
                    Provide Link for Additional information
                  </td>
                  <td></td>
                  {/* <td>
                  <input
                    onChange={(e) => {
                      setValue1321f2(e.target.files[0]);
                      setPathValue1321f2(e.target.value);
                      showFilePreview(e);

                    }}
                    id="1321-f2"
                    type="file"
                    className="c13-fileButton-style"
                  />
                  {pathValue1321f2 === '' ? null : (
                    <div className="c13-fileButtons-container">
                      <button className="c13-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue1321f2("");
                      document.getElementById("1321-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td> */}
                  <td>
                    <input
                      type="file"
                      id="1321-f2"
                      onChange={(e) => {
                        setValue1321f2(e.target.files[0]);
                        setPathValue1321f2(e.target.value);
                        showFilePreview(e);
                        FileRemove(e);
                      }}
                    />
                    {pathValue1321f2 === "" ? null : (
                      <div className="c11-31-fileButtons-container">
                        <button className="c11-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}>
                            {" "}
                            View File
                          </a>
                        </button>
                        <button className="c11-removeFileButton-style">
                          <a target="_openfile" href={fileremoveSrc111f2}>
                            {" "}
                            Remove File
                          </a>
                        </button>
                      </div>
                    )}
                  </td>
                </tr>
                {/* <tr>
                <td>List of value added courses (Data Template)</td>
                <td>
                  <a href="http://localhost:8080/api/v1/download/criteria1.3.2-1.3.3.xlsx">
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue1321f3(e.target.files[0]);
                      setPathValue1321f3(e.target.value);
                      showFilePreview(e);

                    }}
                    id="1321-f3"
                    type="file"
                    className="c13-fileButton-style"
                  />
                  {pathValue1321f3 === '' ? null : (
                    <div className="c13-fileButtons-container">
                      <button className="c13-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue1321f3("");
                      document.getElementById("1321-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr> */}
              </table>
            </div>
        </form>
      </div>

      {/* Key Indicator: 1.3.3 */}
      <div className="c13x-eachInputField-container">
        <div className="c13x-weightage-container">
          <h1 className="c13x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c13x-container">
            <div className="c13x-heading_Help-container">
              <h1 className="c13x-heading-style">
                <span className="c13x-span-style">1.3.3: </span>
                Percentage of Programmes that have components of field projects / research projects / internships during last five years
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
                title='Formula:'
                >𝐓𝐨𝐭𝐚𝐥 𝐍𝐮𝐦𝐛𝐞𝐫 𝐨𝐟 𝐏𝐫𝐨𝐠𝐫𝐚𝐦𝐬 𝐭𝐡𝐚𝐭 𝐡𝐚𝐯𝐞 𝐜𝐨𝐦𝐩𝐨𝐧𝐞𝐧𝐭𝐬 𝐨𝐟 𝐟𝐢𝐞𝐥𝐝 𝐩𝐫𝐨𝐣𝐞𝐜𝐭𝐬 /
                𝐫𝐞𝐬𝐞𝐚𝐫𝐜𝐡 𝐩𝐫𝐨𝐣𝐞𝐜𝐭𝐬 𝐢𝐧𝐭𝐞𝐫𝐧𝐬𝐡𝐢𝐩𝐬 𝐝𝐮𝐫𝐢𝐧𝐠 𝐭𝐡𝐞 𝐥𝐚𝐬𝐭 𝐟𝐢𝐯𝐞 𝐲𝐞𝐚𝐫𝐬
                𝐓𝐨𝐭𝐚𝐥 𝐍𝐮𝐦𝐛𝐞𝐫 𝐨𝐟 𝐏𝐫𝐨𝐠𝐫𝐚𝐦𝐬 𝐨𝐟𝐟𝐞𝐫𝐞𝐝
                𝐝𝐮𝐫𝐢𝐧𝐠 𝐭𝐡𝐞 𝐥𝐚𝐬𝐭 𝐟𝐢𝐯𝐞 𝐲𝐞𝐚𝐫𝐬
                𝐗𝟏𝟎𝟎</HelpButton>
            </div>
            <div className="c13x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus133(!responseButtonStatus133);
                  onClickingViewResponse133();
                }}
                className="c13x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus133 ? (
                <p className="c13x-responseResult-style">{responseValue133}</p>
              ) : null}
            </div>
          </div>
          <div className="c13xx-container">
            <h1 className="c13xx-Heading-style">
              <span className="c13xx-span-style">1.3.3.1: </span>
              Number of programmes that have components of field projects/research projects/internships (without repeat count) during last five years
              <input
                onChange={(e) => setValue1331t1(e.target.value)}
                id="1331-t1"
                style={{ width: "25%", marginLeft: "4.6%" }}
                type="number"
              />
            </h1>
            <h1 className="c13xx-Heading-style">
              <span className="c13xx-span-style">1.3.3.2: </span>
              Number of programmes offered (without repeat count) during last five years
              <input
                onChange={(e) => setValue1331t2(e.target.value)}
                id="1331-t2"
                style={{ width: "25%", marginLeft: "4.6%" }}
                type="number"
              />
            </h1>



            <table className="c13x-table-style">
              <tr>
                <th className="c13x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c13x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c13x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c13x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Program and course contents having element of field projects / research projects / internships as approved by BOS</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue1331f1(e.target.files[0]);
                      setPathValue1331f1(e.target.value);
                      showFilePreview(e);

                    }}
                    id="1331-f1"
                    type="file"
                    className="c13-fileButton-style"
                  />
                  {pathValue1331f1 === '' ? null : (
                    <div className="c13-fileButtons-container">
                      <button className="c13-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue1331f1("");
                          document.getElementById("1331-f1").value = ""
                        }} >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Sample Internship completion letter provided by host institutions</td>
                <td>
                  
 <a href={downloadFile("un1.3.3.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue1331f2(e.target.files[0]);
                      setPathValue1331f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="1331-f2"
                    type="file"
                    className="c13-fileButton-style"
                  />
                  {pathValue1331f2 === '' ? null : (
                    <div className="c13-fileButtons-container">
                      <button className="c13-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue1331f2("");
                          document.getElementById("1331-f2").value = ""
                        }} >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Provide Links for any other relevant document to support the claim (if any) b </td>
                <td>
                {/* <a href={downloadFile("un1.3.3.xlsx")} target="_blank">
                    View Template
                  </a> */}
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue1331f2(e.target.files[0]);
                      setPathValue1331f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="1331-f2"
                    type="file"
                    className="c13-fileButton-style"
                  />
                  {pathValue1331f2 === '' ? null : (
                    <div className="c13-fileButtons-container">
                      <button className="c13-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style"
                        onClick={(e) => {
                          setPathValue1331f2("");
                          document.getElementById("1331-f2").value = ""
                        }} >
                        Reset
                      </button>
                    </div>
                  )}
                </td>
                <td className="c13x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>



      <div className="c13x-button-container">
        <button onClick={onClickingSave} className="c13x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria13;
