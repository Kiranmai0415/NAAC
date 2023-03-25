import React, { useState } from "react";
import "./c63-style.css";
import { toast } from "react-toastify";
import AuthService from "../../../../Pages/Users/services/auth.service";
import { HelpButton } from "../../../../../reusableComponents/model/Help";
import { resources } from "../../../../appConstants";
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

// Help buttons functionality
function Help631(props) {
  return props.isHelp631Clicked ? (
    <div className="c63x-help-mainContainer">
      <div className="c63x-help-subContainer">
        <h1 className="c63x-help-heading-style">
          The institutional Strategic/ Perspective plan is effectively deployed
        </h1>
        <p className="c63x-help-para-style">
          Describe one activity successfully implemented based on the strategic
          plan within a maximum of 500 words
        </p>
        <button
          className="c63x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp631Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help632(props) {
  return props.isHelp632Clicked ? (
    <div className="c63x-help-mainContainer">
      <div className="c63x-help-subContainer">
        <h1 className="c63x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c63x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>The total amount of seed
          money provided by institution to its teachers for research in the last
          five years
          <span style={{ fontWeight: 'bold' }}>) /</span>
        </p>
        <button
          className="c63x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp632Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help633(props) {
  return props.isHelp633Clicked ? (
    <div className="c63x-help-mainContainer">
      <div className="c63x-help-subContainer">
        <h1 className="c63x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c63x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>The total amount of seed
          money provided by institution to its teachers for research in the last
          five years
          <span style={{ fontWeight: 'bold' }}>) /</span>
        </p>
        <button
          className="c63x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp633Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help634(props) {
  return props.isHelp634Clicked ? (
    <div className="c63x-help-mainContainer">
      <div className="c63x-help-subContainer">
        <h1 className="c63x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c63x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>The total amount of seed
          money provided by institution to its teachers for research in the last
          five years
          <span style={{ fontWeight: 'bold' }}>) /</span>
        </p>
        <button
          className="c63x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp634Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria63() {
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
  const [value631t1, setValue631t1] = useState();

  const [value631f1, setValue631f1] = useState();
  const [pathValue631f1, setPathValue631f1] = useState('');
  const [value631f2, setValue631f2] = useState();
  const [pathValue631f2, setPathValue631f2] = useState('');
  const [value631f3, setValue631f3] = useState();
  const [pathValue631f3, setPathValue631f3] = useState('');
  const [responseValue631, setResponseValue631] = useState('');

  const [value6321t1, setValue6321t1] = useState();
  const [value6321t2, setValue6321t2] = useState();
  const [value6321t3, setValue6321t3] = useState();
  const [value6321t4, setValue6321t4] = useState();
  const [value6321t5, setValue6321t5] = useState();
  const [value6321t6, setValue6321t6] = useState();
  const [value6321t7, setValue6321t7] = useState();
  const [value6321t8, setValue6321t8] = useState();
  const [value6321t9, setValue6321t9] = useState();
  const [value6321t10, setValue6321t10] = useState();
  const [value6321t11, setValue6321t11] = useState();
  const [value6321t12, setValue6321t12] = useState();
  const [value6321t13, setValue6321t13] = useState();
  const [value6321t14, setValue6321t14] = useState();
  const [value6321t15, setValue6321t15] = useState();
  const [value6321t16, setValue6321t16] = useState();
  const [value6321t17, setValue6321t17] = useState();
  const [value6321t18, setValue6321t18] = useState();
  const [value6321t19, setValue6321t19] = useState();
  const [value6321t20, setValue6321t20] = useState();
  const [value6321f1, setValue6321f1] = useState('');
  const [pathValue6321f1, setPathValue6321f1] = useState('');
  const [value6321f2, setValue6321f2] = useState('');
  const [pathValue6321f2, setPathValue6321f2] = useState('');
  const [responseValue632, setResponseValue632] = useState('');
  const [responseButtonStatus632, setResponseButtonStatus632] = useState(false);

  const [value6331t1, setValue6331t1] = useState();
  const [value6331t2, setValue6331t2] = useState();
  const [value6331t3, setValue6331t3] = useState();
  const [value6331t4, setValue6331t4] = useState();
  const [value6331t5, setValue6331t5] = useState();
  const [value6331t6, setValue6331t6] = useState();
  const [value6331t7, setValue6331t7] = useState();
  const [value6331t8, setValue6331t8] = useState();
  const [value6331t9, setValue6331t9] = useState();
  const [value6331t10, setValue6331t10] = useState();
  const [value6331f1, setValue6331f1] = useState('');
  const [pathValue6331f1, setPathValue6331f1] = useState('');
  const [value6331f2, setValue6331f2] = useState('');
  const [pathValue6331f2, setPathValue6331f2] = useState('');
  const [value6331f3, setValue6331f3] = useState('');
  const [pathValue6331f3, setPathValue6331f3] = useState('');
  const [value6331f4, setValue6331f4] = useState('');
  const [pathValue6331f4, setPathValue6331f4] = useState('');
  const [responseValue633, setResponseValue633] = useState('');
  const [responseButtonStatus633, setResponseButtonStatus633] = useState(false);

  const [value6341t1, setValue6341t1] = useState();
  const [value6341t2, setValue6341t2] = useState();
  const [value6341t3, setValue6341t3] = useState();
  const [value6341t4, setValue6341t4] = useState();
  const [value6341t5, setValue6341t5] = useState();
  const [value6341t6, setValue6341t6] = useState();
  const [value6341t7, setValue6341t7] = useState();
  const [value6341t8, setValue6341t8] = useState();
  const [value6341t9, setValue6341t9] = useState();
  const [value6341t10, setValue6341t10] = useState();
  const [value6341t11, setValue6341t11] = useState();
  const [value6341t12, setValue6341t12] = useState();
  const [value6341t13, setValue6341t13] = useState();
  const [value6341t14, setValue6341t14] = useState();
  const [value6341t15, setValue6341t15] = useState();
  const [value6341t16, setValue6341t16] = useState();
  const [value6341t17, setValue6341t17] = useState();
  const [value6341t18, setValue6341t18] = useState();
  const [value6341t19, setValue6341t19] = useState();
  const [value6341t20, setValue6341t20] = useState();
  const [value6341f1, setValue6341f1] = useState('');
  const [pathValue6341f1, setPathValue6341f1] = useState('');
  const [value6341f2, setValue6341f2] = useState('');
  const [pathValue6341f2, setPathValue6341f2] = useState('');
  const [value6341f3, setValue6341f3] = useState('');
  const [pathValue6341f3, setPathValue6341f3] = useState('');
  const [value6341f4, setValue6341f4] = useState('');
  const [pathValue6341f4, setPathValue6341f4] = useState('');
  const [responseValue634, setResponseValue634] = useState('');
  const [responseButtonStatus634, setResponseButtonStatus634] = useState(false);

  const [help631Status, setHelp631Status] = useState(false);
  const [help632Status, setHelp632Status] = useState(false);
  const [help633Status, setHelp633Status] = useState(false);
  const [help634Status, setHelp634Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');

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
  // sending data to db with API
  // const financialYear="2021-2022";
  const inputDataList = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    criteria63Ql: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input631t1: value631t1,
        response631: responseValue631,
        criteria63status: "save",
      },
    ],
    criteria63Qn: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        response632: responseValue632,
        response633: responseValue633,
        response634: responseValue634,
        criteria63status: "save",
      },
    ],
    yearTable6321: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input6321y: value6321t1,
        input6321v: value6321t6,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        input6321y: value6321t2,
        input6321v: value6321t7,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        input6321y: value6321t3,
        input6321v: value6321t8,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        input6321y: value6321t4,
        input6321v: value6321t9,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 5,
        input6321y: value6321t5,
        input6321v: value6321t10,
      },
    ],
    yearTable63212: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input63212y: value6321t11,
        input63212v: value6321t16,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        input63212y: value6321t12,
        input63212v: value6321t17,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        input63212y: value6321t13,
        input63212v: value6321t18,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        input63212y: value6321t14,
        input63212v: value6321t19,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 5,
        input63212y: value6321t15,
        input63212v: value6321t20,
      },
    ],
    yearTable6331: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input6331y: value6331t1,
        input6331v: value6331t6,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        input6331y: value6331t2,
        input6331v: value6331t7,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        input6331y: value6331t3,
        input6331v: value6331t8,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        input6331y: value6331t4,
        input6331v: value6331t9,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 5,
        input6331y: value6331t5,
        input6331v: value6331t10,
      },
    ],
    yearTable6341: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input6341y: value6341t1,
        input6341v: value6341t6,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        input6341y: value6341t2,
        input6341v: value6341t7,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        input6341y: value6341t3,
        input6341v: value6341t8,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        input6341y: value6341t4,
        input6341v: value6341t9,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 5,
        input6341y: value6341t5,
        input6341v: value6341t10,
      },
    ],
    yearTable63412: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input63412y: value6341t11,
        input63412v: value6341t16,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 2,
        input63412y: value6341t12,
        input63412v: value6341t17,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 3,
        input63412y: value6341t13,
        input63412v: value6341t18,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 4,
        input63412y: value6341t14,
        input63412v: value6341t19,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 5,
        input63412y: value6341t15,
        input63412v: value6341t20,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form63Data = new FormData();
    console.log(JSON.stringify(inputDataList));

    form63Data.append('criteria6Fieldinfo', jsonBlob(inputDataList));
    if (pathValue631f1 !== '') {
      form63Data.append('uploadfile6', value631f1, 'f631f1-' + value631f1.name);
    }
    if (pathValue631f2 !== '') {
      form63Data.append('uploadfile6', value631f2, 'f631f2-' + value631f2.name);
    }
    if (pathValue631f3 !== '') {
      form63Data.append('uploadfile6', value631f3, 'f631f3-' + value631f3.name);
    }
    if (pathValue6321f1 !== '') {
      form63Data.append(
        'uploadfile6',
        value6321f1,
        'f6321f1-' + value6321f1.name
      );
    }
    if (pathValue6321f2 !== '') {
      form63Data.append(
        'uploadfile6',
        value6321f2,
        'f6321f2-' + value6321f2.name
      );
    }
    if (pathValue6331f1 !== '') {
      form63Data.append(
        'uploadfile6',
        value6331f1,
        'f6331f1-' + value6331f1.name
      );
    }
    if (pathValue6331f2 !== '') {
      form63Data.append(
        'uploadfile6',
        value6331f2,
        'f6331f2-' + value6331f2.name
      );
    }
    if (pathValue6331f3 !== '') {
      form63Data.append(
        'uploadfile6',
        value6331f3,
        'f6331f3-' + value6331f3.name
      );
    }
    if (pathValue6331f4 !== '') {
      form63Data.append(
        'uploadfile6',
        value6331f4,
        'f6331f4-' + value6331f4.name
      );
    }
    if (pathValue6341f1 !== '') {
      form63Data.append(
        'uploadfile6',
        value6341f1,
        'f6341f1-' + value6341f1.name
      );
    }
    if (pathValue6341f2 !== '') {
      form63Data.append(
        'uploadfile6',
        value6341f2,
        'f6341f2-' + value6341f2.name
      );
    }
    if (pathValue6341f3 !== '') {
      form63Data.append(
        'uploadfile6',
        value6341f3,
        'f6341f3-' + value6341f3.name
      );
    }
    if (pathValue6341f4 !== '') {
      form63Data.append(
        'uploadfile6',
        value6341f4,
        'f6341f4-' + value6341f4.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form63Data,
    };
    fetch(
      resources.APPLICATION_URL+'criteria6upload',
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

  function onClickingViewResponse632() {
    if (
      value6321t6 === ''
      || value6321t7 === ''
      || value6321t8 === ''
      || value6321t9 === ''
      || value6321t10 === ''
      || value6321t6 === undefined
      || value6321t7 === undefined
      || value6321t8 === undefined
      || value6321t9 === undefined
      || value6321t10 === undefined
    ) {
      setResponseValue632('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value6321t6, 10)) === false
      || Number.isInteger(parseInt(value6321t7, 10)) === false
      || Number.isInteger(parseInt(value6321t8, 10)) === false
      || Number.isInteger(parseInt(value6321t9, 10)) === false
      || Number.isInteger(parseInt(value6321t10, 10)) === false
    ) {
      setResponseValue632('Input should be an Integer');
    } else if (
      value6321t6 !== ''
      && value6321t7 !== ''
      && value6321t8 !== ''
      && value6321t9 !== ''
      && value6321t10 !== ''
    ) {
      setResponseValue632(
        (parseInt(value6321t6, 10)
          + parseInt(value6321t7, 10)
          + parseInt(value6321t8, 10)
          + parseInt(value6321t9, 10)
          + parseInt(value6321t10, 10))
          * 100
      );
    }
  }
  function onClickingViewResponse633() {
    if (
      value6331t6 === ''
      || value6331t7 === ''
      || value6331t8 === ''
      || value6331t9 === ''
      || value6331t10 === ''
      || value6331t6 === undefined
      || value6331t7 === undefined
      || value6331t8 === undefined
      || value6331t9 === undefined
      || value6331t10 === undefined
    ) {
      setResponseValue633('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value6331t6, 10)) === false
      || Number.isInteger(parseInt(value6331t7, 10)) === false
      || Number.isInteger(parseInt(value6331t8, 10)) === false
      || Number.isInteger(parseInt(value6331t9, 10)) === false
      || Number.isInteger(parseInt(value6331t10, 10)) === false
    ) {
      setResponseValue633('Input should be an Integer');
    } else if (
      value6331t6 !== ''
      && value6331t7 !== ''
      && value6331t8 !== ''
      && value6331t9 !== ''
      && value6331t10 !== ''
    ) {
      setResponseValue633(
        parseInt(value6331t6, 10)
          + parseInt(value6331t7, 10)
          + parseInt(value6331t8, 10)
          + parseInt(value6331t9, 10)
          + parseInt(value6331t10, 10)
      );
    }
  }
  function onClickingViewResponse634() {
    if (
      value6341t6 === ''
      || value6341t7 === ''
      || value6341t8 === ''
      || value6341t9 === ''
      || value6341t10 === ''
      || value6341t6 === undefined
      || value6341t7 === undefined
      || value6341t8 === undefined
      || value6341t9 === undefined
      || value6341t10 === undefined
    ) {
      setResponseValue634('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value6341t6, 10)) === false
      || Number.isInteger(parseInt(value6341t7, 10)) === false
      || Number.isInteger(parseInt(value6341t8, 10)) === false
      || Number.isInteger(parseInt(value6341t9, 10)) === false
      || Number.isInteger(parseInt(value6341t10, 10)) === false
    ) {
      setResponseValue634('Input should be an Integer');
    } else if (
      value6341t6 !== ''
      && value6341t7 !== ''
      && value6341t8 !== ''
      && value6341t9 !== ''
      && value6341t10 !== ''
    ) {
      setResponseValue634(
        parseInt(value6341t6, 10)
          + parseInt(value6341t7, 10)
          + parseInt(value6341t8, 10)
          + parseInt(value6341t9, 10)
          + parseInt(value6341t10, 10)
      );
    }
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
    <div className="c63-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c63x-colorIndicator-container">
        <p className="c63x-QlcolorIndicator-circle-style"></p>
        <span className="c63x-colorIndicator-span-style">Qualitative</span>
        <p className="c63x-QtcolorIndicator-circle-style"></p>
        <span className="c63x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c63x-weightage-heading-style">
            Key Indicator Weightage: 30
          </h1>
        </div>
      </div>

      {/* Key Indicator: 6.3.1 */}
      <div className="c63x-eachInputField-container">
        <div className="c63x-weightage-container">
          <h1 className="c63x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c63x-Ql-label-textarea-container">
            <div className="c63x-heading_Help-container">
              <h1 className="c63x-heading-style">
                <span className="c63x-span-style">6.3.1: </span>
                The institution has performance appraisal system, effective welfare measures for teaching and non-teaching staff and avenues for career development/progression
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
            <label htmlFor="631-t1" className="c31x-label-style">
              Response:
            </label>
            <textarea
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue631t1(e.target.value);
                setResponseValue631(e.target.value);
              }}
              value={value631t1}
              rows={10}
              className="c63x-textarea-style"
              id="631-t1"
            ></textarea>
            {value631t1 === '' ? (
              <p style={{ color: 'red' }}>Required*</p>
            ) : null}
          </div>

          <table className="c63x-Ql-table-style">
            <tr>
              <th className="c63x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c63x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c63x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c63x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c63x-Ql-tableBorders-style">
                Strategic Plan and deployment documents on the website
              </td>
              <td className="c63x-Ql-tableBorders-style"></td>
              <td className="c63x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue631f1(e.target.files[0]);
                    setPathValue631f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="631-f1"
                  type="file"
                  className="c63-fileButton-style"
                  accept='.pdf'
                />
                {pathValue631f1 === '' ? null : (
                  <div className="c63-fileButtons-container">
                    <button className="c63-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>

                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue631f1("");
                      document.getElementById("631-f1").value="" }} >
                      Reset
                     </button>

                  </div>
                )}
              </td>
              <td className="c63x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c63x-Ql-tableBorders-style">
                Paste link for additional Information
              </td>
              <td className="c63x-Ql-tableBorders-style"></td>
              <td className="c63x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue631f2(e.target.files[0]);
                    setPathValue631f2(e.target.value);
                    showFilePreview(e);

                  }}
                  id="631-f2"
                  type="file"
                  className="c63-fileButton-style"
                  accept='.pdf'
                  
                />
                {pathValue631f2 === '' ? null : (
                  <div className="c63-fileButtons-container">
                    <button className="c63-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue631f2("");
                      document.getElementById("631-f2").value="" }} >
                      Reset
                     </button>

                  </div>
                )}
              </td>
              <td className="c63x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c63x-Ql-tableBorders-style">
                Upload any additional information
              </td>
              <td className="c63x-Ql-tableBorders-style">
              </td>
              <td className="c63x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue631f3(e.target.files[0]);
                    setPathValue631f3(e.target.value);
                    showFilePreview(e);

                  }}
                  id="631-f3"
                  type="file"
                  className="c63-fileButton-style"
                  accept='.pdf'
                />
                {pathValue631f3 === '' ? null : (
                  <div className="c63-fileButtons-container">
                    <button className="c63-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>

                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue631f3("");
                      document.getElementById("631-f3").value="" }} >
                      Reset
                     </button>

                  </div>
                )}
              </td>
              <td className="c63x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 6.3.2 */}
      <div className="c63x-eachInputField-container">
        <div className="c63x-weightage-container">
          <h1 className="c63x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c63x-container">
            <div className="c63x-heading_Help-container">
              <h1 className="c63x-heading-style">
                <span className="c63x-span-style">6.3.2: </span>
                Percentage of teachers provided financial support to attend conferences/workshops and towards membership fee of professional bodies during the last five years
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
                title='percentage'
                ><h1>(Total number of teachers provided with financial support to attend conferences,workshops and towards membership fee of professional bodiesduring the last five years )/(Total number of full time teachers during the last five years) * 100</h1></HelpButton>
            </div>
            {/* <div className="c63x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus632(!responseButtonStatus632);
                  onClickingViewResponse632();
                }}
                className="c63x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus632 ? (
                <p className="c63x-responseResult-style">{responseValue632}</p>
              ) : null}
            </div> */}
          </div>
          <div className="c63xx-container">
            <h1 className="c63xx-Heading-style">
              <span className="c63xx-span-style">6.3.2.1: </span>
             Number of teachers provided with financial support to attend
conferences/workshops and towards membership fee of professional
bodies year-wise during the last five years
            </h1>

            <table className="c63x-Qt-table-style">
              <tr>
                <th className="c63x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6321t1(e.target.value)}
                      id="6321-t1"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t1}
                    />
                    {value6321t1 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6321t2(e.target.value)}
                      id="6321-t2"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t2}
                    />
                    {value6321t2 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6321t3(e.target.value)}
                      id="6321-t3"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t3}
                    />
                    {value6321t3 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6321t4(e.target.value)}
                      id="6321-t4"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t4}
                    />
                    {value6321t4 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6321t5(e.target.value)}
                      id="6321-t5"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t5}
                    />
                    {value6321t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c63x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6321t6(e.target.value);
                        onClickingViewResponse632();
                      }}
                      id="6321-t6"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t6}
                    />
                    {value6321t6 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6321t7(e.target.value);
                        onClickingViewResponse632();
                      }}
                      id="6321-t7"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t7}
                    />
                    {value6321t7 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6321t8(e.target.value);
                        onClickingViewResponse632();
                      }}
                      id="6321-t8"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t8}
                    />
                    {value6321t8 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6321t9(e.target.value);
                        onClickingViewResponse632();
                      }}
                      id="6321-t9"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t9}
                    />
                    {value6321t9 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6321t10(e.target.value);
                        onClickingViewResponse632();
                      }}
                      id="6321-t10"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t10}
                    />
                    {value6321t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            {/* <table className="c63x-Qt-table-style">
              <tr>
                <th className="c63x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6321t11(e.target.value)}
                      id="6321-t11"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t11}
                    />
                    {value6321t11 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6321t12(e.target.value)}
                      id="6321-t12"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t12}
                    />
                    {value6321t12 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6321t13(e.target.value)}
                      id="6321-t13"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t13}
                    />
                    {value6321t13 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6321t14(e.target.value)}
                      id="6321-t14"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t14}
                    />
                    {value6321t14 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6321t15(e.target.value)}
                      id="6321-t15"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t15}
                    />
                    {value6321t15 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c63x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6321t16(e.target.value);
                        onClickingViewResponse632();
                      }}
                      id="6321-t16"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t16}
                    />
                    {value6321t16 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6321t17(e.target.value);
                        onClickingViewResponse632();
                      }}
                      id="6321-t17"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t17}
                    />
                    {value6321t17 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6321t18(e.target.value);
                        onClickingViewResponse632();
                      }}
                      id="6321-t18"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t18}
                    />
                    {value6321t18 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6321t19(e.target.value);
                        onClickingViewResponse632();
                      }}
                      id="6321-t19"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t19}
                    />
                    {value6321t19 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6321t20(e.target.value);
                        onClickingViewResponse632();
                      }}
                      id="6321-t20"
                      className="c63x-input-style"
                      type="number"
                      value={value6321t20}
                    />
                    {value6321t20 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> */}

            <table className="c63x-table-style">
              <tr>
                <th className="c63x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c63x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c63x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c63x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue6321f1(e.target.files[0]);
                      setPathValue6321f1(e.target.value);
                      showFilePreview(e);

                    }}
                    id="6321-f1"
                    type="file"
                    className="c63-fileButton-style"
                    accept='.pdf'
                  />
                  {pathValue6321f1 === '' ? null : (
                    <div className="c63-fileButtons-container">
                      <button className="c63-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue6321f1("");
                      document.getElementById("6321-f1").value="" }} >
                      Reset
                     </button>

                    </div>
                  )}
                </td>
                <td className="c63x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Details of teachers provided with financial support to attend
                  conferences, workshops etc. during the last five years
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue6321f2(e.target.files[0]);
                      setPathValue6321f2(e.target.value);
                      showFilePreview(e);

                    }}
                    id="6321-f2"
                    type="file"
                    className="c63-fileButton-style"
                    accept='.pdf'
                  />
                  {pathValue6321f2 === '' ? null : (
                    <div className="c63-fileButtons-container">
                      <button className="c63-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue6321f2("");
                      document.getElementById("6321-f2").value="" }} >
                      Reset
                     </button>


                    </div>
                  )}
                </td>
                <td className="c63x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 6.3.3 */}
      <div className="c63x-eachInputField-container">
        <div className="c63x-weightage-container">
          <h1 className="c63x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c63x-container">
            <div className="c63x-heading_Help-container">
              <h1 className="c63x-heading-style">
                <span className="c63x-span-style">6.3.3: </span>
                Percentage of teachers undergoing online/ face-to-face Faculty Development Programmes (FDPs)/ Management Development Programmes (MDPs) during the last five year
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
                title='percentage'
                ><h1>(Total number of teaching staff attending such Programmes during the last five years )/(Total number of full time teachers during the last five years) * 100</h1></HelpButton>
            </div>
            {/* <div className="c63x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus633(!responseButtonStatus633);
                  onClickingViewResponse633();
                }}
                className="c63x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus633 ? (
                <p className="c63x-responseResult-style">{responseValue633}</p>
              ) : null}
            </div> */}
          </div>
          <div className="c63xx-container">
            <h1 className="c63xx-Heading-style">
              <span className="c63xx-span-style">6.3.3.1: </span>
              Total number of teachers who have undergone online/ faceto-face Faculty Development Programmes (FDP)/ Management
Development Programs (MDP) during the last five years
            </h1>

            <table className="c63x-Qt-table-style">
              <tr>
                <th className="c63x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6331t1(e.target.value)}
                      id="6331-t1"
                      className="c63x-input-style"
                      type="number"
                      value={value6331t1}
                    />
                    {value6331t1 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6331t2(e.target.value)}
                      id="6331-t2"
                      className="c63x-input-style"
                      type="number"
                      value={value6331t2}
                    />
                    {value6331t2 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6331t3(e.target.value)}
                      id="6331-t3"
                      className="c63x-input-style"
                      type="number"
                      value={value6331t3}
                    />
                    {value6331t3 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6331t4(e.target.value)}
                      id="6331-t4"
                      className="c63x-input-style"
                      type="number"
                      value={value6331t4}
                    />
                    {value6331t4 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6331t5(e.target.value)}
                      id="6331-t5"
                      className="c63x-input-style"
                      type="number"
                      value={value6331t5}
                    />
                    {value6331t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c63x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6331t6(e.target.value);
                        onClickingViewResponse633();
                      }}
                      id="6331-t6"
                      className="c63x-input-style"
                      type="number"
                      value={value6331t6}
                    />
                    {value6331t6 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6331t7(e.target.value);
                        onClickingViewResponse633();
                      }}
                      id="6331-t7"
                      className="c63x-input-style"
                      type="number"
                      value={value6331t7}
                    />
                    {value6331t7 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6331t8(e.target.value);
                        onClickingViewResponse633();
                      }}
                      id="6331-t8"
                      className="c63x-input-style"
                      type="number"
                      value={value6331t8}
                    />
                    {value6331t8 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6331t9(e.target.value);
                        onClickingViewResponse633();
                      }}
                      id="6331-t9"
                      className="c63x-input-style"
                      type="number"
                      value={value6331t9}
                    />
                    {value6331t9 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6331t10(e.target.value);
                        onClickingViewResponse633();
                      }}
                      id="6331-t10"
                      className="c63x-input-style"
                      type="number"
                      value={value6331t10}
                    />
                    {value6331t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c63x-table-style">
              <tr>
                <th className="c63x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c63x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c63x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c63x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue6331f1(e.target.files[0]);
                      setPathValue6331f1(e.target.value);
                      showFilePreview(e);

                    }}
                    id="6331-f1"
                    type="file"
                    className="c63-fileButton-style"
                    accept='.pdf'
                  />
                  {pathValue6331f1 === '' ? null : (
                    <div className="c63-fileButtons-container">
                      <button className="c63-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue6331f1("");
                      document.getElementById("6331-f1").value="" }} >
                      Reset
                     </button>


                    </div>
                  )}
                </td>
                <td className="c63x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Minutes of the relevant bodies of the Institution</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue6331f2(e.target.files[0]);
                      setPathValue6331f2(e.target.value);
                      showFilePreview(e);

                    }}
                    id="6331-f2"
                    type="file"
                    className="c63-fileButton-style"
                    accept='.pdf'
                  />
                  {pathValue6331f2 === '' ? null : (
                    <div className="c63-fileButtons-container">
                      <button className="c63-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue6331f2("");
                      document.getElementById("6331-f2").value="" }} >
                      Reset
                     </button>

                    </div>
                  )}
                </td>
                <td className="c63x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Budget and expenditure statements signed by the Finance
                  Officer indicating seed money provided and utilized
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue6331f3(e.target.files[0]);
                      setPathValue6331f3(e.target.value);
                      showFilePreview(e);

                    }}
                    id="6331-f3"
                    type="file"
                    className="c63-fileButton-style"
                    accept='.pdf'
                  />
                  {pathValue6331f3 === '' ? null : (
                    <div className="c63-fileButtons-container">
                      <button className="c63-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue6331f3("");
                      document.getElementById("6331-f3").value="" }} >
                      Reset
                     </button>

                    </div>
                  )}
                </td>
                <td className="c63x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List of teachers receiving grant and details of grant received
                  (Data Template)
                </td>
                <td>
                <a href={downloadFile("au6.3.3.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue6331f4(e.target.files[0]);
                      setPathValue6331f4(e.target.value);
                      showFilePreview(e);

                    }}
                    id="6331-f4"
                    type="file"
                    className="c63-fileButton-style"
                    accept='.pdf'
                  />
                  {pathValue6331f4 === '' ? null : (
                    <div className="c63-fileButtons-container">
                      <button className="c63-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue6331f4("");
                      document.getElementById("6331-f4").value="" }} >
                      Reset
                     </button>

                    </div>
                  )}
                </td>
                <td className="c63x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 6.3.4 */}
      {/* <div className="c63x-eachInputField-container">
        <div className="c63x-weightage-container">
          <h1 className="c63x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c63x-container">
            <div className="c63x-heading_Help-container">
              <h1 className="c63x-heading-style">
                <span className="c63x-span-style">6.3.4: </span>
               Average percentage of teachers undergoing online/face-to-face Faculty Development programmes 
               during last five years(Professional Development Programmes, Orientation/Induction Programmes,
               Refresher Course,Short Term Course)              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp634Status(true);
                }}
                className="c63x-helpButton-style"
              >
                Help
              </button>
              <Help634
                isHelp634Clicked={help634Status}
                setIsHelp634Clicked={setHelp634Status}
              />
            </div>
            <div className="c63x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus634(!responseButtonStatus634);
                  onClickingViewResponse634();
                }}
                className="c63x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus634 ? (
                <p className="c63x-responseResult-style">{responseValue634}</p>
              ) : null}
            </div>
          </div>
          <div className="c63xx-container">
            <h1 className="c63xx-Heading-style">
              <span className="c63xx-span-style">6.3.4.1: </span>
             Total number of teachers attending professional development programmes,viz.,Orientation Programme,Refresher Course,Short 
             Term Course,Faculty Development Programmes year wise during last five years
            </h1>

            <table className="c63x-Qt-table-style">
              <tr>
                <th className="c63x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6341t1(e.target.value)}
                      id="6341-t1"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t1}
                    />
                    {value6341t1 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6341t2(e.target.value)}
                      id="6341-t2"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t2}
                    />
                    {value6341t2 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6341t3(e.target.value)}
                      id="6341-t3"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t3}
                    />
                    {value6341t3 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6341t4(e.target.value)}
                      id="6341-t4"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t4}
                    />
                    {value6341t4 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6341t5(e.target.value)}
                      id="6341-t5"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t5}
                    />
                    {value6341t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c63x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6341t6(e.target.value);
                        onClickingViewResponse634();
                      }}
                      id="6341-t6"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t6}
                    />
                    {value6341t6 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6341t7(e.target.value);
                        onClickingViewResponse634();
                      }}
                      id="6341-t7"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t7}
                    />
                    {value6341t7 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6341t8(e.target.value);
                        onClickingViewResponse634();
                      }}
                      id="6341-t8"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t8}
                    />
                    {value6341t8 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6341t9(e.target.value);
                        onClickingViewResponse634();
                      }}
                      id="6341-t9"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t9}
                    />
                    {value6341t9 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6341t10(e.target.value);
                        onClickingViewResponse634();
                      }}
                      id="6341-t10"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t10}
                    />
                    {value6341t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c63x-Qt-table-style">
              <tr>
                <th className="c63x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6341t11(e.target.value)}
                      id="6341-t11"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t11}
                    />
                    {value6341t11 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6341t12(e.target.value)}
                      id="6341-t12"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t12}
                    />
                    {value6341t12 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6341t13(e.target.value)}
                      id="6341-t13"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t13}
                    />
                    {value6341t13 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6341t14(e.target.value)}
                      id="6341-t14"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t14}
                    />
                    {value6341t14 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue6341t15(e.target.value)}
                      id="6341-t15"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t15}
                    />
                    {value6341t15 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c63x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6341t16(e.target.value);
                        onClickingViewResponse634();
                      }}
                      id="6341-t16"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t16}
                    />
                    {value6341t16 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6341t17(e.target.value);
                        onClickingViewResponse634();
                      }}
                      id="6341-t17"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t17}
                    />
                    {value6341t17 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6341t18(e.target.value);
                        onClickingViewResponse634();
                      }}
                      id="6341-t18"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t18}
                    />
                    {value6341t18 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6341t19(e.target.value);
                        onClickingViewResponse634();
                      }}
                      id="6341-t19"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t19}
                    />
                    {value6341t19 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue6341t20(e.target.value);
                        onClickingViewResponse634();
                      }}
                      id="6341-t20"
                      className="c63x-input-style"
                      type="number"
                      value={value6341t20}
                    />
                    {value6341t20 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <table className="c63x-table-style">
              <tr>
                <th className="c63x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c63x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c63x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c63x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue6341f1(e.target.files[0]);
                      setPathValue6341f1(e.target.value);
                    }}
                    id="6341-f1"
                    type="file"
                    className="c63-fileButton-style"
                  />
                  {pathValue6341f1 === '' ? null : (
                    <div className="c63-fileButtons-container">
                      <button className="c63-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue6341f1("");
                      document.getElementById("6341-f1").value="" }} >
                      Reset
                     </button>

                    </div>
                  )}
                </td>
                <td className="c63x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Minutes of the relevant bodies of the Institution</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue6341f2(e.target.files[0]);
                      setPathValue6341f2(e.target.value);
                    }}
                    id="6341-f2"
                    type="file"
                    className="c63-fileButton-style"
                  />
                  {pathValue6341f2 === '' ? null : (
                    <div className="c63-fileButtons-container">
                      <button className="c63-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue6341f2("");
                      document.getElementById("6341-f2").value="" }} >
                      Reset
                     </button>

                    </div>
                  )}
                </td>
                <td className="c63x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Budget and expenditure statements signed by the Finance
                  Officer indicating seed money provided and utilized
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue6341f3(e.target.files[0]);
                      setPathValue6341f3(e.target.value);
                      showFilePreview(e);

                    }}
                    id="6331-f3"
                    type="file"
                    className="c63-fileButton-style"
                    accept='.pdf'
                  />
                  {pathValue6341f3 === '' ? null : (
                    <div className="c63-fileButtons-container">
                      <button className="c63-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue6341f3("");
                      document.getElementById("6341-f3").value="" }} >
                      Reset
                     </button>

                    </div>
                  )}
                </td>
                <td className="c63x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List of teachers receiving grant and details of grant received
                  (Data Template)
                </td>
                <td>
                  <a href="http://localhost:8080/api/v1/download/criteria6.3.4.xlsx">View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue6341f4(e.target.files[0]);
                      setPathValue6341f4(e.target.value);
                      showFilePreview(e);

                    }}
                    id="6341-f4"
                    type="file"
                    className="c63-fileButton-style"
                    accept='.pdf'
                  />
                  {pathValue6341f4 === '' ? null : (
                    <div className="c63-fileButtons-container">
                      <button className="c63-viewFileButton-style">
                          <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue6341f4("");
                      document.getElementById("6341-f4").value="" }} >
                      Reset
                     </button>

                    </div>
                  )}
                </td>
                <td className="c63x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div> */}

      <div className="c63x-button-container">
        <button className="c63x-button-style" onClick={onClickingSave}>
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria63;
