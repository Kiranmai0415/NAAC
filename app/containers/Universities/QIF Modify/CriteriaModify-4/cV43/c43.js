import React, { useState,useEffect } from 'react';
import './c43-style.css';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service'
import { resources } from '../../../../appConstants';
import { Button } from '@mui/material';
import { HelpButton } from '../../../../../reusableComponents/model/Help';

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

function Help431(props) {
  return props.isHelp431Clicked ? (
    <div className="c43x-help-mainContainer">
      <div className="c43x-help-subContainer">
        <h1 className="c43x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c43x-help-para-style"><span style={{ fontWeight: 'bold' }}>(</span>
        Number of classrooms and seminar halls with ICT facilities
          <span style={{ fontWeight: 'bold' }}> / </span>
        Total number of classrooms/seminar halls
in the institution.<span style={{ fontWeight: 'bold' }}>) *</span>100
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
        Provide the salient features of the IT Policy and describe the process
of implementation and adherence to the policy , budgetary provisions
made and utilized and the expansion plan in maximum of 500 words
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
        Number of students : Number of Computers available to students for
academic purposes
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
        Data Requirements:<br/>
     1.Available internet bandwidth
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

function Help435(props) {
  return props.isHelp435Clicked ? (
    <div className="c43x-help-mainContainer">
      <div className="c43x-help-subContainer">
        <h1 className="c43x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c43x-help-para-style">
        Data Requirements: (As per Data Template)<br/>
* Upload the names of the e-content development facilities
        </p>
        <button
          className="c43x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp435Clicked(false);
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
  const [isOpen3, setIsopen3] = useState(false)
  const [isOpen2,setIsopen2] = useState(false)
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
  const [value431t1, setValue431t1] = useState();
  const [value431t2, setValue431t2] = useState();
  const [value431f1, setValue431f1] = useState('');
  const [pathValue431f1, setPathValue431f1] = useState('');
  const [pathValue431f2, setPathValue431f2] = useState('');
  const [value431f2, setValue431f2] = useState();
  const [pathValue431f3, setPathValue431f3] = useState('');
  const [value431f3, setValue431f3] = useState();
  const [responseButtonStatus431, setResponseButtonStatus431] = useState(false);
  const [responseValue431, setResponseValue431] = useState('');
  const [help431Status, setHelp431Status] = useState(false);

  const [value432t1, setValue432t1] = useState();
  const [value432f1, setValue432f1] = useState('');
  const [pathValue432f1, setPathValue432f1] = useState('');
  const [value432f2, setValue432f2] = useState('');
  const [pathValue432f2, setPathValue432f2] = useState('');
  const [responseValue432, setResponseValue432] = useState('');
  const [help432Status, setHelp432Status] = useState(false);

  const [value433t1, setValue433t1] = useState();
  const [value433t2, setValue433t2] = useState();
  const [value433f1, setValue433f1] = useState('');
  const [pathValue433f1, setPathValue433f1] = useState('');
  const [value433f2, setValue433f2] = useState('');
  const [pathValue433f2, setPathValue433f2] = useState('');
  const [responseButtonStatus433, setResponseButtonStatus433] = useState(false);
  const [responseValue433, setResponseValue433] = useState('');
  const [help433Status, setHelp433Status] = useState(false);

  const [value434t1, setValue434t1] = useState();
  const [value434f1, setValue434f1] = useState('');
  const [pathValue434f1, setPathValue434f1] = useState('');
  const [value434f2, setValue434f2] = useState('');
  const [pathValue434f2, setPathValue434f2] = useState('');
  const [responseButtonStatus434, setResponseButtonStatus434] = useState(false);
  const [responseValue434, setResponseValue434] = useState('');
  const [help434Status, setHelp434Status] = useState(false);

  const [value435t1, setValue435t1] = useState();
  const [value435f1, setValue435f1] = useState('');
  const [pathValue435f1, setPathValue435f1] = useState('');
  const [value435f2, setValue435f2] = useState('');
  const [pathValue435f2, setPathValue435f2] = useState('');
  const [value435f3, setValue435f3] = useState('');
  const [pathValue435f3, setPathValue435f3] = useState('');
  const [responseButtonStatus435, setResponseButtonStatus435] = useState(false);
  const [responseValue435, setResponseValue435] = useState('');
  const [help435Status, setHelp435Status] = useState(false);

  const [value435t2 , setValue435t2] = useState();
  const [value435t3 , setValue435t3] = useState();
  const [value435t4 , setValue435t4] = useState();
  const [value435t5 , setValue435t5] = useState();


  
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
const financialYear="2021-2022";
  useEffect(
    () => fetch(resources.APPLICATION_URL+'criteria4getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));

          setValue431t1(data[0].criteria43Ql[0] ? data[0].criteria43Ql[0].input431t1: "");
          setValue431t2(data[0].criteria43Ql[0] ? data[0].criteria43Ql[0].input431t2: "");
          setValue432t1(data[0].criteria43Qn[0] ? data[0].criteria43Qn[0].input432t1: "");
          setValue433t1(data[0].criteria43Qn[0] ? data[0].criteria43Qn[0].input433t1: "");
          setValue433t2(data[0].criteria43Qn[0] ? data[0].criteria43Qn[0].input433t2: "");
          setValue434t1(data[0].criteria43Qn[0] ? data[0].criteria43Qn[0].input434t1: "");
          setValue435t1(data[0].criteria43Qn[0] ? data[0].criteria43Qn[0].input435t1: "");

          setValue431f1(data[0].criteria4FileUpload[0] ? data[0].criteria4FileUpload[0].criteria4FileName: "");
          setValue431f2(data[0].criteria4FileUpload[1] ? data[0].criteria4FileUpload[1].criteria4FileName: "");
          setValue432f1(data[0].criteria4FileUpload[2] ? data[0].criteria4FileUpload[2].criteria4FileName: "");
          setValue432f2(data[0].criteria4FileUpload[3] ? data[0].criteria4FileUpload[3].criteria4FileName: "");
          setValue433f1(data[0].criteria4FileUpload[4] ? data[0].criteria4FileUpload[4].criteria4FileName: "");
          setValue433f2(data[0].criteria4FileUpload[5] ? data[0].criteria4FileUpload[5].criteria4FileName: "");
          setValue434f1(data[0].criteria4FileUpload[6] ? data[0].criteria4FileUpload[6].criteria4FileName: "");
          setValue434f2(data[0].criteria4FileUpload[7] ? data[0].criteria4FileUpload[7].criteria4FileName: "");
          setValue435f1(data[0].criteria4FileUpload[8] ? data[0].criteria4FileUpload[8].criteria4FileName: "");
          setValue435f2(data[0].criteria4FileUpload[9] ? data[0].criteria4FileUpload[9].criteria4FileName: "");
          setValue435f3(data[0].criteria4FileUpload[10] ? data[0].criteria4FileUpload[10].criteria4FileName: "");
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ),
    []
  );

  // respose functionality
  function onClickingViewResponse431() {
    if (value431t1 === '' || value431t2 === '' || value431t1 === undefined || value431t2 === undefined) {
      setResponseValue431('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value431t1, 10)) === false
      || Number.isInteger(parseInt(value431t2, 10)) === false
    ) {
      setResponseValue431('Input should be an Integer');
    } else if (value431t1 !== '' && value431t2 !== '') {
      setResponseValue431((parseInt(value431t1, 10) / parseInt(value431t2, 10)) / 100);
    }
  }

  function onClickingViewResponse433() {
    if (value433t1 === '' || value433t2 === '' || value433t1 === undefined || value433t2 === undefined) {
      setResponseValue433('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value433t1, 10)) === false
      || Number.isInteger(parseInt(value433t2, 10)) === false
    ) {
      setResponseValue433('Input should be an Integer');
    } else if (value433t1 !== '' && value433t2 !== '') {
      setResponseValue433(parseInt(value433t1, 10) / parseInt(value433t2, 10));
    }
  }

  function onClickingViewResponse434(e) {
    if (value434t1 === '') {
      setResponseValue434('Please select any option');
    } else {
      setResponseValue434(e.target.value);
    }
  }
  function onClickingViewResponse435(e) {
    if (value435t1 === '') {
      setResponseValue435('Please select any option');
    } else {
      setResponseValue435(e.target.value);
    }
  }

  // sending data to db with API

 

  const inputDataList = {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    criteria43Ql: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
        input431t1: value431t1,
        input431t2: value431t2,
       
      },
    ],
    criteria43Qn: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
      input432t1: value432t1,
      input433t1: value433t1,
      input433t2: value433t2,
      input434t1: value434t1,
      input435t1: value435t1,
      input435t2: value435t2,
      input435t3: value435t3,
      input435t4: value435t4,
      input435t5: value435t5,
      response432: responseValue432,
      response433: responseValue433,
      response434: responseValue434,
    },
  ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    console.log(value434t1);
    const form43Data = new FormData();

    form43Data.append('criteria4Fieldinfo', jsonBlob(inputDataList));
    if (pathValue431f1 !== '') {
      form43Data.append('uploadfile4', value431f1, 'f431f1-' + value431f1.name);
    }
    if (pathValue431f2 !== '') {
      form43Data.append('uploadfile4', value431f2, 'f431f2-' + value431f2.name);
    }
    if (pathValue431f3 !== '') {
      form43Data.append('uploadfile4', value431f3, 'f431f3-' + value431f3.name);
    }
    if (pathValue432f1 !== '') {
      form43Data.append('uploadfile4', value432f1, 'f432f1-' + value432f1.name);
    }
    if (pathValue432f2 !== '') {
      form43Data.append('uploadfile4', value432f2, 'f432f2-' + value432f2.name);
    }
    if (pathValue433f1 !== '') {
      form43Data.append('uploadfile4', value433f1, 'f433f1-' + value433f1.name);
    }
    if (pathValue433f2 !== '') {
      form43Data.append('uploadfile4', value433f2, 'f433f2-' + value433f2.name);
    }
    if (pathValue434f1 !== '') {
      form43Data.append('uploadfile4', value434f1, 'f434f1-' + value434f1.name);
    }
    if (pathValue434f2 !== '') {
      form43Data.append('uploadfile4', value434f2, 'f434f2-' + value434f2.name);
    }
    if (pathValue435f1 !== '') {
      form43Data.append('uploadfile4', value435f1, 'f435f1-' + value435f1.name);
    }
    if (pathValue435f2 !== '') {
      form43Data.append('uploadfile4', value435f2, 'f435f2-' + value435f2.name);
    }
    if (pathValue435f3 !== '') {
      form43Data.append('uploadfile4', value435f3, 'f435f3-' + value435f3.name);
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form43Data,
    };
    fetch(
      resources.APPLICATION_URL+'criteria4upload',
      filesFetchMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Saved Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
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
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
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
          <h1 className="c43x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c43x-container">
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
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue431f3(e.target.value);
                setResponseButtonStatus431(e.target.value);
              }}
              value={value431f3}
              rows={10}
              className="c43x-textarea-style"
              id="111-t1"
            ></textarea>

            {/* <div className="c43x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus431(!responseButtonStatus431);
                  onClickingViewResponse431();
                }}
                className="c43x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus431 ? (
                <p className="c43x-responseResult-style">{responseValue431}</p>
              ) : null}
            </div> */}
          </div>
          {/* <div className="c43xx-container">
            <h1 className="c43xx-Heading-style">
             Number of classrooms and seminar halls with ICT facilities
Data Requirements:
              <input
                onChange={(e) => setValue431t1(e.target.value)}
                id="431-t1"
                style={{ marginLeft: '4%' }}
                type="number"
                value={value431t1}
              /></h1>
            <h1 className="c43xx-Heading-style">
            Total number of classrooms/ seminar halls in the institution
              <input
                onChange={(e) => setValue431t2(e.target.value)}
                id="431-t2"
                style={{ marginLeft: '20.3%' }}
                type="number"
                value={value431t2}
              /></h1>
          </div> */}

          {/* <table className="c43x-table-style">
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
                  onChange={(e) => {
                    setValue431f1(e.target.files[0]);
                    setPathValue431f1(e.target.value);
                  }}
                  id="431-f1"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue431f1 === '' ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                        View File
                    </button>
                    <button className="c43-removeFileButton-style">
                        Remove File
                    </button>
                  </div>
                )}
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>

            <tr>
              <td>Provide the link for additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue431f2(e.target.files[0]);
                    setPathValue431f2(e.target.value);
                  }}
                  id="431-f2"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue431f2 === '' ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                        View File
                    </button>
                    <button className="c43-removeFileButton-style">
                        Remove File
                    </button>
                  </div>
                )}
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>

            <tr>
              <td>Upload Number of classroo</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue431f3(e.target.files[0]);
                    setPathValue431f3(e.target.value);
                  }}
                  id="431-f3"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue431f3 === '' ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                        View File
                    </button>
                    <button className="c43-removeFileButton-style">
                        Remove File
                    </button>
                  </div>
                )}
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
                <td>Student - computer ratio</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue432f2(e.target.files[0]);
                      setPathValue432f2(e.target.value);
                    }}
                    id="432-f2"
                    type="file"
                    className="c43-fileButton-style"
                  />
                  {pathValue432f2 === '' ? null : (
                    <div className="c43-fileButtons-container">
                      <button className="c43-viewFileButton-style">
                        View File
                      </button>
                      <button className="c43-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c43x-Qt-tableBorders-style">pdf</td>
              </tr>
          </table> */}
        </form>
      </div>

      {/* Key Indicator: 4.3.2 */}
      {/* <div className="c43x-eachInputField-container">
        <div className="c43x-weightage-container">
          <h1 className="c43x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c43x-Ql-label-textarea-container">
            <div className="c43x-heading_Help-container">
              <h1 className="c43x-heading-style">
                <span className="c43x-span-style">4.3.2: </span>
                Institution has an IT policy, makes appropriate budgetary provisions
and updates its IT facilities including the Wi-Fi facility
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp432Status(true);
                }}
                className="c43x-helpButton-style"
              >
                Help
              </button>
              <Help432
                isHelp432Clicked={help432Status}
                setIsHelp432Clicked={setHelp432Status}
              />
            </div>
            <label htmlFor="432-t1" className="c43x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue432t1(e.target.value);
                setResponseValue432(e.target.value);
              }}
              value={value432t1}
              rows={10}
              className="c43x-textarea-style"
              id="432-t1"
            ></textarea>
            {value432t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
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
                  onChange={(e) => {
                    setValue432f1(e.target.files[0]);
                    setPathValue432f1(e.target.value);
                  }}
                  id="432-f1"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue432f1 === '' ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button className="c43-removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )}
              </td>
              <td className="c43x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Paste link for additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue432f2(e.target.files[0]);
                    setPathValue432f2(e.target.value);
                  }}
                  id="432-f2"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue432f2 === '' ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button className="c43-removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )}
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div> */}

      {/* Key Indicator: 4.3.3 */}
      <div className="c43x-eachInputField-container">
        <div className="c43x-weightage-container">
          <h1 className="c43x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c43x-container">
            <div className="c43x-heading_Help-container">
              <h1 className="c43x-heading-style">
                <span className="c43x-span-style">4.3.2: </span>
                Student - Computer ratio (Data to be provided only for the latest completed academic year)

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
                title='formula'
                ><h1>(Total number of computers available for student use ) / ( 1.2: Number of students on rolls (latest compleated academic year))</h1></HelpButton>
            </div>
            <div className="c43x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus433(!responseButtonStatus433);
                  onClickingViewResponse433();
                }}
                className="c43x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus433 ? (
                <p className="c43x-responseResult-style">{responseValue433}</p>
              ) : null}
            </div>
          </div>
          <div className="c43xx-container">
            {/* <h1 className="c43xx-Heading-style">
                Number of students:
              <input
                onChange={(e) => setValue433t1(e.target.value)}
                id="433-t1"
                style={{ marginLeft: '44%' }}
                type="number"
                value={value433t1}
              /></h1> */}
            <h1 className="c43xx-Heading-style">
            Number of Computers available to students for
academic purposes:
              <input
                onChange={(e) => setValue433t1(e.target.value)}
                id="433-t2"
                style={{ marginLeft: '4%' }}
                type="number"
                value={value433t1}
              /></h1>
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
                {/* <input
                  onChange={(e) => {
                    setValue433f1(e.target.files[0]);
                    setPathValue433f1(e.target.value);
                  }}
                  id="433-f1"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue433f1 === '' ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                        View File
                    </button>
                    <button className="c43-removeFileButton-style">
                        Remove File
                    </button>
                  </div>
                )} */}
                   <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="433-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue433f1(e.target.files[0]);
                    setPathValue433f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue433f1}
              {pathValue433f1 === "" ? null : (
                <div className="c43-fileButtons-container">
                  <button
                    className="c43-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc431f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c43-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue433f1("");
                      document.getElementById("433-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Student - computer ratio</td>
              <td></td>
              <td>
                {/* <input
                  onChange={(e) => {
                    setValue433f2(e.target.files[0]);
                    setPathValue433f2(e.target.value);
                  }}
                  id="433-f2"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue433f2 === '' ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                        View File
                    </button>
                    <button className="c43-removeFileButton-style">
                        Remove File
                    </button>
                  </div>
                )} */}
                   <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="433-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue433f2(e.target.files[0]);
                    setPathValue433f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue433f2}
              {pathValue433f2 === "" ? null : (
                <div className="c43-fileButtons-container">
                  <button
                    className="c43-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc433f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c43-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue433f2("");
                      document.getElementById("433-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
            {/* <tr>
                <td>Student - computer ratio</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue432f2(e.target.files[0]);
                      setPathValue432f2(e.target.value);
                    }}
                    id="432-f2"
                    type="file"
                    className="c43-fileButton-style"
                  />
                  {pathValue432f2 === '' ? null : (
                    <div className="c43-fileButtons-container">
                      <button className="c43-viewFileButton-style">
                        View File
                      </button>
                      <button className="c43-removeFileButton-style">
                        Remove File
                      </button>
                    </div>
                  )}
                </td>
                <td className="c43x-Qt-tableBorders-style">pdf</td>
              </tr> */}
          </table>
        </form>
      </div>

      {/* Key Indicator: 4.3.4 */}
      {/* <div className="c43x-eachInputField-container">
        <div className="c43x-weightage-container">
          <h1 className="c43x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c43x-container">
            <div className="c43x-heading_Help-container">
              <div>
                <h1 className="c43x-heading-style">
                  <span className="c43x-span-style">4.3.4: </span>
                  Available bandwidth of internet connection in the Institution
                </h1>

                <div className="c43x-radio-container"  style={{width:"150%"}}>
                  <div className="c43x-radio-subContainer" style={{width:"45%"}}>
                    <div className="c43x-eachRadio-container">
                      <input
                        name="434options"
                        id="434-t1"
                        type="radio"
                        onChange={(e) => {
                          setValue434t1(e.target.value);
                        }}
                        value="1 GBPS"
                      />

                      <label className="c43x-radioLabel-style" for="434-t1">
                        {'>='}= 1 GBPS
                      </label>
                    </div>

                    <div className="c43x-eachRadio-container">
                      <input
                        name="434options"
                        id="434-t1"
                        type="radio"
                        onChange={(e) => {
                          setValue434t1(e.target.value);
                        }}
                        value="500 MBPS - 1 GBPS"
                      />

                      <label className="c43x-radioLabel-style" for="434-t1">
                      500 MBPS - 1 GBPS
                      </label>
                    </div>

                    <div className="c43x-eachRadio-container">
                      <input
                        name="433options"
                        id="434-t1"
                        type="radio"
                        onChange={(e) => {
                          setValue434t1(e.target.value);
                        }}
                        value="250 MBPS - 500 MBPS"
                      />

                      <label className="c43x-radioLabel-style" for="434-t1">
                      250 MBPS - 500 MBPS
                      </label>
                    </div>
                  </div>

                  <div className="c43x-radio-subContainer">
                    <div className="c43x-eachRadio-container">
                      <input
                        name="434options"
                        id="434-t1"
                        type="radio"
                        onChange={(e) => {
                          setValue434t1(e.target.value);
                        }}
                        value="50 MBPS - 250 MBPS"
                      />

                      <label className="c43x-radioLabel-style" for="434-t1">
                      50 MBPS - 250 MBPS

                      </label>
                    </div>

                    <div className="c43x-eachRadio-container">
                      <input
                        name="434options"
                        id="434-t1"
                        type="radio"
                        onChange={(e) => {
                          setValue434t1(e.target.value);
                        }}
                        value="50 MBPS "
                      />

                      <label className="c43x-radioLabel-style" for="434-t1">
                        {'<'} 50 MBPS
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
                  onChange={(e) => {
                    setValue434f1(e.target.files[0]);
                    setPathValue434f1(e.target.value);
                  }}
                  id="434-f1"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue434f1 === '' ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button className="c43-removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )}
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
                  onChange={(e) => {
                    setValue434f2(e.target.files[0]);
                    setPathValue434f2(e.target.value);
                  }}
                  id="434-f2"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue434f2 === '' ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button className="c43-removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )}
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div> */}

      {/* Key Indicator: 4.3.5 */}
      <div className="c43x-eachInputField-container">
        <div className="c43x-weightage-container">
          <h1 className="c43x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c43x-container">
            <div className="c43x-heading_Help-container">
              <div>
                <h1 className="c43x-heading-style">
                  <span className="c43x-span-style">4.3.3: </span>
                  Institution has the following Facilities for e-content and other resource development
                </h1>
                <p className="c34x-para-style">
                1. Audio visual center, mixing equipment, editing facilities and Media Studio
                  <br />
                  2. Lecture Capturing System(LCS)
                  <br />
                  3. Central Instrumentation Centre
                  <br />
                  4. Animal House
                  <br />
                  5. Museum
                  <br />
                  6. Business Lab
                  <br />
                  7. Research/statistical database
                  <br />
                  8. Moot court
                  <br />
                  9. Theatre
                  <br />
                  10. Art Gallery
                  <br />
                  11. Any other facility to support research
                  
                </p>

                <div className="c43x-radio-container" style={{width:"150%"}} >
                  <div className="c43x-radio-subContainer" style={{width:"45%"}}>
                    <div className="c43x-eachRadio-container">
                      <input
                        onChange={(e) => {
                          setValue435t1(e.target.value);
                        }}
                        name="435options"
                        value="All the four of the above"
                        id="435-t1"
                        type="radio"
                      />

                      <label className="c43x-radioLabel-style" for="435-t1">
                        All the four of the above
                      </label>
                    </div>

                    <div className="c43x-eachRadio-container">
                      <input
                        onChange={(e) => {
                          setValue435t2(e.target.value);
                        }}
                        name="435options"
                        value="Any three of the above"
                        id="435-t2"
                        type="radio"
                      />

                      <label className="c43x-radioLabel-style" for="435-t1">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c43x-eachRadio-container">
                      <input
                        onChange={(e) => {
                          setValue435t3(e.target.value);
                        }}
                        name="435options"
                        value="Any two of the above"
                        id="435-t3"
                        type="radio"
                      />

                      <label className="c43x-radioLabel-style" for="435-t1">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c43x-radio-subContainer">
                    <div className="c43x-eachRadio-container">
                      <input
                        onChange={(e) => {
                          setValue435t4(e.target.value);
                        }}
                        name="435options"
                        value="Any one of the above"
                        id="435-t4"
                        type="radio"
                      />

                      <label className="c43x-radioLabel-style" for="435-t1">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c43x-eachRadio-container">
                      <input
                        onChange={(e) => {
                          setValue435t5(e.target.value);
                        }}
                        name="435options"
                        value="None of the above"
                        id="435-t5"
                        type="radio"
                      />

                      <label className="c43x-radioLabel-style" for="435-t1">
                        None of the above
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
            <div className="c43x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus435(!responseButtonStatus435);
                  onClickingViewResponse435();
                }}
                className="c43x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus435 ? (
                <p className="c43x-responseResult-style">{responseValue435}</p>
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
                {/* <input
                  onChange={(e) => {
                    setValue435f1(e.target.files[0]);
                    setPathValue435f1(e.target.value);
                  }}
                  id="435-f1"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue435f1 === '' ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button className="c43-removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )} */}
                   <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="435-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue435f1(e.target.files[0]);
                    setPathValue435f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue435f1}
              {pathValue435f1 === "" ? null : (
                <div className="c43-fileButtons-container">
                  <button
                    className="c43-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc435f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c43-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue435f1("");
                      document.getElementById("435-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Provide links to the photographs</td>
              <td></td>
              <td>
                {/* <input
                  onChange={(e) => {
                    setValue435f2(e.target.files[0]);
                    setPathValue435f2(e.target.value);
                  }}
                  id="435-f2"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue435f2 === '' ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button className="c43-removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )} */}
                   <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="435-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue435f2(e.target.files[0]);
                    setPathValue435f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue435f2}
              {pathValue435f2 === "" ? null : (
                <div className="c43-fileButtons-container">
                  <button
                    className="c43-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc435f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c43-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue435f2("");
                      document.getElementById("435-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Facilities for e-content development such as Media Centre,
Recording facility, LCS etc (Data Templates as in 3.4.7)</td>
              <td></td>
              <td>
                {/* <input
                  onChange={(e) => {
                    setValue435f3(e.target.files[0]);
                    setPathValue435f3(e.target.value);
                  }}
                  id="435-f3"
                  type="file"
                  className="c43-fileButton-style"
                />
                {pathValue435f3 === '' ? null : (
                  <div className="c43-fileButtons-container">
                    <button className="c43-viewFileButton-style">
                      View File
                    </button>
                    <button className="c43-removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )} */}
                   <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="435-f3"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue435f3(e.target.files[0]);
                    setPathValue435f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue435f3}
              {pathValue435f3 === "" ? null : (
                <div className="c43-fileButtons-container">
                  <button
                    className="c43-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc435f3}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c43-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue435f3("");
                      document.getElementById("435-f3").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c43x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      <div className="c43x-button-container">
        <button className="c43x-button-style" onClick={onClickingSave}>
          Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria43;
