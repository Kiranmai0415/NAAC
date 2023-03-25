import React, { useState,useEffect } from 'react';
import './c51-style.css';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import { HelpButton } from '../../../../../reusableComponents/model/Help';
import { resources } from '../../../../appConstants';
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
function Help511(props) {
  return props.isHelp511Clicked ? (
    <div className="c51x-help-mainContainer">
      <div className="c51x-help-subContainer">
        <h1 className="c51x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c51x-help-para-style">
          Percentage per year
          <span style={{ fontWeight: 'bold' }}>(</span>Number of Students
          benifited by scholarships and freeships by government
          <span style={{ fontWeight: 'bold' }}>) /</span>
          <span style={{ fontWeight: 'bold' }}>(</span> Number of students
          <span style={{ fontWeight: 'bold' }}>) /</span>*100
        </p>
        <p className="c51x-help-para-style">
          Average
          <span style={{ fontWeight: 'bold' }}>=(</span> ΣPercentage per year
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>
        <button
          className="c51x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp511Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help512(props) {
  return props.isHelp512Clicked ? (
    <div className="c51x-help-mainContainer">
      <div className="c51x-help-subContainer">
        <h1 className="c51x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c51x-help-para-style">
          Average percentage
        </p>
        <button
          className="c51x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp512Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help513(props) {
  return props.isHelp513Clicked ? (
    <div className="c51x-help-mainContainer">
      <div className="c51x-help-subContainer">
        <h1 className="c51x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c51x-help-para-style">
          Percentage per year
          <span style={{ fontWeight: 'bold' }}>(</span>Number of Students
          benifited by guidance for competitive examinations and career
          councelling offered by the institution
          <span style={{ fontWeight: 'bold' }}>) /</span>
          <span style={{ fontWeight: 'bold' }}>(</span> Number of students
          <span style={{ fontWeight: 'bold' }}>) /</span>*100
        </p>
        <p className="c51x-help-para-style">
          Average percentage
          <span style={{ fontWeight: 'bold' }}>=(</span> ΣPercentage per year
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>
        <button
          className="c51x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp513Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help514(props) {
  return props.isHelp514Clicked ? (
    <div className="c51x-help-mainContainer">
      <div className="c51x-help-subContainer">
        <h1 className="c51x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c51x-help-para-style">Percentage per year</p>
        <button
          className="c51x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp514Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria51() {
      // /this is Help button 
      const [isOpen, setIsopen] = useState(false)
      const handleHelpOpen = (e) => {
        e.preventDefault(),
        setIsopen(true)
      }
      const handleHelpClose = () => {
        setIsopen(false)
      }
      const [isOpen3, setIsopen3] = useState(false)
      const handleHelpOpen3 = (e) => {
        e.preventDefault(),
        setIsopen3(true)
      }
      const handleHelpClose3 = () => {
        setIsopen3(false)
      }
      const [isOpen4, setIsopen4] = useState(false)
      const handleHelpOpen4 = (e) => {
        e.preventDefault(),
        setIsopen4(true)
      }
      const handleHelpClose4 = () => {
        setIsopen4(false)
      }
  // state variables
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
  const [isOpen2, setIsopen2] = useState(false)
  const handleHelpOpen2 = (e) => {
    e.preventDefault(),
    setIsopen2(true)
  }
  const handleHelpClose2 = () => {
    setIsopen2(false)
  }

  const [value5111t1, setValue5111t1] = useState();
  const [value5111t2, setValue5111t2] = useState();
  const [value5111t3, setValue5111t3] = useState();
  const [value5111t4, setValue5111t4] = useState();
  const [value5111t5, setValue5111t5] = useState();
  const [value5111t6, setValue5111t6] = useState();
  const [value5111t7, setValue5111t7] = useState();
  const [value5111t8, setValue5111t8] = useState();
  const [value5111t9, setValue5111t9] = useState();
  const [value5111t10, setValue5111t10] = useState();
  const [value5111t11, setValue5111t11] = useState();
  const [value5111t12, setValue5111t12] = useState();
  const [value5111t13, setValue5111t13] = useState();
  const [value5111t14, setValue5111t14] = useState();
  const [value5111t15, setValue5111t15] = useState();
  const [value5111t16, setValue5111t16] = useState();
  const [value5111t17, setValue5111t17] = useState();
  const [value5111t18, setValue5111t18] = useState();
  const [value5111t19, setValue5111t19] = useState();
  const [value5111t20, setValue5111t20] = useState();

  
  const [value514t1, setValue514t1] = useState();

  const [value512t1, setValue512t1] = useState();
  const [value512f1, setValue512f1] = useState([]);
  const [value512f2, setValue512f2] = useState([]);
  const [value512f3, setValue512f3] = useState([]);
  const [pathValue512f1, setPathValue512f1] = useState('');
  const [pathValue512f2, setPathValue512f2] = useState('');
  const [pathValue512f3, setPathValue512f3] = useState('');

  const [value5131t1, setValue5131t1] = useState();
  const [value5131t2, setValue5131t2] = useState();
  const [value5131t3, setValue5131t3] = useState();
  const [value5131t4, setValue5131t4] = useState();
  const [value5131t5, setValue5131t5] = useState();
  const [value5131t6, setValue5131t6] = useState();
  const [value5131t7, setValue5131t7] = useState();
  const [value5131t8, setValue5131t8] = useState();
  const [value5131t9, setValue5131t9] = useState();
  const [value5131t10, setValue5131t10] = useState();
  const [value5131t11, setValue5131t11] = useState();
  const [value5131t12, setValue5131t12] = useState();
  const [value5131t13, setValue5131t13] = useState();
  const [value5131t14, setValue5131t14] = useState();
  const [value5131t15, setValue5131t15] = useState();
  const [value5131t16, setValue5131t16] = useState();
  const [value5131t17, setValue5131t17] = useState();
  const [value5131t18, setValue5131t18] = useState();
  const [value5131t19, setValue5131t19] = useState();
  const [value5131t20, setValue5131t20] = useState();

  const [pathValue5111f1, setPathValue5111f1] = useState('');
  const [pathValue5111f2, setPathValue5111f2] = useState('');
  const [pathValue5111f3, setPathValue5111f3] = useState('');
  const [pathValue5111f4, setPathValue5111f4] = useState('');
  const [value5111f1, setValue5111f1] = useState([]);
  const [value5111f2, setValue5111f2] = useState([]);
  const [value5111f3, setValue5111f3] = useState([]);
  const [value5111f4, setValue5111f4] = useState([]);

  const [pathValue5131f1, setPathValue5131f1] = useState('');
  const [pathValue5131f2, setPathValue5131f2] = useState('');
  const [pathValue5131f3, setPathValue5131f3] = useState('');

  const [value5131f1, setValue5131f1] = useState([]);
  const [value5131f2, setValue5131f2] = useState([]);
  const [value5131f3, setValue5131f3] = useState([]);

  const [pathValue514f1, setPathValue514f1] = useState('');
  const [pathValue514f2, setPathValue514f2] = useState('');
  const [pathValue514f3, setPathValue514f3] = useState('');
  const [value514f1, setValue514f1] = useState([]);
  const [value514f2, setValue514f2] = useState([]);
  const [value514f3, setValue514f3] = useState([]);

  const [responseButtonStatus511, setResponseButtonStatus511] = useState(false);
  const [responseButtonStatus513, setResponseButtonStatus513] = useState(false);

  const [responseValue511, setResponseValue511] = useState('');
  const [responseValue512, setResponseValue512] = useState('');
  const [responseValue513, setResponseValue513] = useState('');
  const [responseValue514, setResponseValue514] = useState('');
  const [help511Status, setHelp511Status] = useState(false);
  const [help512Status, setHelp512Status] = useState(false);
  const [help513Status, setHelp513Status] = useState(false);
  const [help514Status, setHelp514Status] = useState(false);
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

  // get data  with API
  const financialYear="2021-2022";
  function downloadFile(fileName) {
    const filePath = "http://localhost:8080/api/v1/download/" + fileName;
    return filePath;
  }

  useEffect(
    () => fetch(resources.APPLICATION_URL+'criteria5getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));

          setValue512t1(data[0].criteria51Qn[0]?data[0].criteria51Qn[0].input512t1:"");
            setValue514t1(data[0].criteria51Qn[0]?data[0].criteria51Qn[0].input514t1:"");

            setValue5111t1(data[0].yearTable5111[0]?data[0].yearTable5111[0].input5111y:"");
            setValue5111t2(data[0].yearTable5111[1]?data[0].yearTable5111[1].input5111y:"");
            setValue5111t3(data[0].yearTable5111[2]?data[0].yearTable5111[2].input5111y:"");
            setValue5111t4(data[0].yearTable5111[3]?data[0].yearTable5111[3].input5111y:"");
            setValue5111t5(data[0].yearTable5111[4]?data[0].yearTable5111[4].input5111y:"");
            setValue5111t6(data[0].yearTable5111[0]?data[0].yearTable5111[0].input5111v:"");
            setValue5111t7(data[0].yearTable5111[1]?data[0].yearTable5111[1].input5111v:"");
            setValue5111t8(data[0].yearTable5111[2]?data[0].yearTable5111[2].input5111v:"");
            setValue5111t9(data[0].yearTable5111[3]?data[0].yearTable5111[3].input5111v:"");
            setValue5111t10(data[0].yearTable5111[4]?data[0].yearTable5111[4].input5111v:"");

            setValue5111t11(data[0].yearTable51112[0]?data[0].yearTable51112[0].input51112y:"");
            setValue5111t12(data[0].yearTable51112[1]?data[0].yearTable51112[1].input51112y:"");
            setValue5111t13(data[0].yearTable51112[2]?data[0].yearTable51112[2].input51112y:"");
            setValue5111t14(data[0].yearTable51112[3]?data[0].yearTable51112[3].input51112y:"");
            setValue5111t15(data[0].yearTable51112[4]?data[0].yearTable51112[4].input51112y:"");
            setValue5111t16(data[0].yearTable51112[0]?data[0].yearTable51112[0].input51112v:"");
            setValue5111t17(data[0].yearTable51112[1]?data[0].yearTable51112[1].input51112v:"");
            setValue5111t18(data[0].yearTable51112[2]?data[0].yearTable51112[2].input51112v:"");
            setValue5111t19(data[0].yearTable51112[3]?data[0].yearTable51112[3].input51112v:"");
            setValue5111t20(data[0].yearTable51112[4]?data[0].yearTable51112[4].input51112v:"");

            setValue5131t1(data[0].affiliatedYearTable5131[0]?data[0].affiliatedYearTable5131[0].input5131y:"");
            setValue5131t2(data[0].affiliatedYearTable5131[1]?data[0].affiliatedYearTable5131[1].input5131y:"");
            setValue5131t3(data[0].affiliatedYearTable5131[2]?data[0].affiliatedYearTable5131[2].input5131y:"");
            setValue5131t4(data[0].affiliatedYearTable5131[3]?data[0].affiliatedYearTable5131[3].input5131y:"");
            setValue5131t5(data[0].affiliatedYearTable5131[4]?data[0].affiliatedYearTable5131[4].input5131y:"");
            setValue5131t6(data[0].affiliatedYearTable5131[0]?data[0].affiliatedYearTable5131[0].input5131v:"");
            setValue5131t7(data[0].affiliatedYearTable5131[1]?data[0].affiliatedYearTable5131[1].input5131v:"");
            setValue5131t8(data[0].affiliatedYearTable5131[2]?data[0].affiliatedYearTable5131[2].input5131v:"");
            setValue5131t9(data[0].affiliatedYearTable5131[3]?data[0].affiliatedYearTable5131[3].input5131v:"");
            setValue5131t10(data[0].affiliatedYearTable5131[4]?data[0].affiliatedYearTable5131[4].input5131v:"");

            setValue5131t11(data[0].yearTable51312[0]?data[0].yearTable51312[0].input51312y:"");
            setValue5131t12(data[0].yearTable51312[1]?data[0].yearTable51312[1].input51312y:"");
            setValue5131t13(data[0].yearTable51312[2]?data[0].yearTable51312[2].input51312y:"");
            setValue5131t14(data[0].yearTable51312[3]?data[0].yearTable51312[3].input51312y:"");
            setValue5131t15(data[0].yearTable51312[4]?data[0].yearTable51312[4].input51312y:"");
            setValue5131t16(data[0].yearTable51312[0]?data[0].yearTable51312[0].input51312v:"");
            setValue5131t17(data[0].yearTable51312[1]?data[0].yearTable51312[1].input51312v:"");
            setValue5131t18(data[0].yearTable51312[2]?data[0].yearTable51312[2].input51312v:"");
            setValue5131t19(data[0].yearTable51312[3]?data[0].yearTable51312[3].input51312v:"");
            setValue5131t20(data[0].yearTable51312[4]?data[0].yearTable51312[4].input51312v:"");

            setValue5111f1(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");
            setValue5111f2(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");
            setValue5111f3(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");
            setValue5111f4(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");

            setValue512f1(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");
            setValue512f2(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");
            setValue512f3(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");
            setValue5131f1(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");
            setValue5131f2(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");
            setValue5131f3(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");

            setValue514f1(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");
            setValue514f2(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");
            setValue514f3(data[0].criteria5FileUpload[0]?data[0].criteria5FileUpload[0].criteria5FileName:"");
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ), []
  );
  // response button functionality
  function onClickingViewResponse511() {
    if (
      value5111t6 === ''
      || value5111t7 === ''
      || value5111t8 === ''
      || value5111t9 === ''
      || value5111t10 === ''
      || value5111t16 === ''
      || value5111t17 === ''
      || value5111t18 === ''
      || value5111t19 === ''
      || value5111t20 === ''
      || value5111t6 === undefined
      || value5111t7 === undefined
      || value5111t8 === undefined
      || value5111t9 === undefined
      || value5111t10 === undefined
      || value5111t16 === undefined
      || value5111t17 === undefined
      || value5111t18 === undefined
      || value5111t19 === undefined
      || value5111t20 === undefined
    ) {
      setResponseValue511('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value5111t6, 10)) === false
      || Number.isInteger(parseInt(value5111t7, 10)) === false
      || Number.isInteger(parseInt(value5111t8, 10)) === false
      || Number.isInteger(parseInt(value5111t9, 10)) === false
      || Number.isInteger(parseInt(value5111t10, 10)) === false
      || Number.isInteger(parseInt(value5111t16, 10)) === false
      || Number.isInteger(parseInt(value5111t17, 10)) === false
      || Number.isInteger(parseInt(value5111t18, 10)) === false
      || Number.isInteger(parseInt(value5111t19, 10)) === false
      || Number.isInteger(parseInt(value5111t20, 10)) === false
    ) {
      setResponseValue511('Input should be an Integer');
    } else if (
      value5111t6 !== ''
      && value5111t7 !== ''
      && value5111t8 !== ''
      && value5111t9 !== ''
      && value5111t10 !== ''
      && value5111t16 !== ''
      && value5111t17 !== ''
      && value5111t18 !== ''
      && value5111t19 !== ''
      && value5111t20 !== ''
    ) {
      setResponseValue511(
        ((value5111t6 / value5111t16) * 100
          + (value5111t7 / value5111t17) * 100
          + (value5111t8 / value5111t18) * 100
          + (value5111t9 / value5111t19) * 100
          + (value5111t10 / value5111t20) * 100)
          / 5
      );
    }
  }

  function onClickingViewResponse513() {
    if (
      value5131t6 === ''
      || value5131t7 === ''
      || value5131t8 === ''
      || value5131t9 === ''
      || value5131t10 === ''
      || value5131t16 === ''
      || value5131t17 === ''
      || value5131t18 === ''
      || value5131t19 === ''
      || value5131t20 === ''
      || value5131t6 === undefined
      || value5131t7 === undefined
      || value5131t8 === undefined
      || value5131t9 === undefined
      || value5131t10 === undefined
      || value5131t16 === undefined
      || value5131t17 === undefined
      || value5131t18 === undefined
      || value5131t19 === undefined
      || value5131t20 === undefined
    ) {
      setResponseValue513('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value5131t6, 10)) === false
      || Number.isInteger(parseInt(value5131t7, 10)) === false
      || Number.isInteger(parseInt(value5131t8, 10)) === false
      || Number.isInteger(parseInt(value5131t9, 10)) === false
      || Number.isInteger(parseInt(value5131t10, 10)) === false
      || Number.isInteger(parseInt(value5131t16, 10)) === false
      || Number.isInteger(parseInt(value5131t17, 10)) === false
      || Number.isInteger(parseInt(value5131t18, 10)) === false
      || Number.isInteger(parseInt(value5131t19, 10)) === false
      || Number.isInteger(parseInt(value5131t20, 10)) === false
    ) {
      setResponseValue513('Input should be an Integer');
    } else if (
      value5131t6 !== ''
      && value5131t7 !== ''
      && value5131t8 !== ''
      && value5131t9 !== ''
      && value5131t10 !== ''
      && value5131t16 !== ''
      && value5131t17 !== ''
      && value5131t18 !== ''
      && value5131t19 !== ''
      && value5131t20 !== ''
    ) {
      setResponseValue513(
        ((value5131t6 / value5131t16) * 100
          + (value5131t7 / value5131t17) * 100
          + (value5131t8 / value5131t18) * 100
          + (value5131t9 / value5131t19) * 100
          + (value5131t10 / value5131t20) * 100)
          / 5
      );
    }
  }

 
// sending data to db with API

const inputDataList = {
  criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
 

  criteria51Qn: [
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
      uniqueKey1: 101,
    input512t1: value512t1,
    input514t1: value514t1,
    response511: responseValue511,
    response512: responseValue512,
    response513: responseValue513,
    // response514: responseValue514,
    // response515: responseValue515,
    criteria51status:"save"
  },
  ],
  // criteria5FieldInfoQn: [
  //   {
  //     criteriaId: { collegeId: '1', financialYear: financialYear, typeofInstitution: "affiliated" },
  //     uniqueKey1: 1,
  //   input512t1: value512t1,
  //   response511: responseValue511,
  //   response512: responseValue512,
  //   response513: responseValue513,
  //   response514: responseValue514,
  // },
  // ],
  yearTable5111: [
    { 
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
    uniqueKey1: 101,input5111y: value5111t1, input5111v: value5111t6 
    },
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
     uniqueKey1: 102,input5111y: value5111t2, input5111v: value5111t7 
    },
    { 
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
     uniqueKey1: 103, input5111y: value5111t3, input5111v: value5111t8 
    },
    { 
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
     uniqueKey1: 104,input5111y: value5111t4, input5111v: value5111t9 
    },
    { 
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
    uniqueKey1: 105,input5111y: value5111t5, input5111v: value5111t10 
    },
  ],

  yearTable51112: [
    { 
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
     uniqueKey1: 101,input51112y: value5111t11, input51112v: value5111t16 
    },
    { 
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
    uniqueKey1: 102, input51112y: value5111t12, input51112v: value5111t17
    },
    { 
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
     uniqueKey1: 103, input51112y: value5111t13, input51112v: value5111t18
    },
    { 
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
     uniqueKey1: 104,input51112y: value5111t14, input51112v: value5111t19 
    },
    { 
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
    uniqueKey1: 105,input51112y: value5111t15, input51112v: value5111t20 
  },
  ],
  
  affiliatedYearTable5131: [
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
       uniqueKey1: 101, input5131y: value5131t1, input5131v: value5131t6
    },
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
       uniqueKey1: 102, input5131y: value5131t2, input5131v: value5131t7
    },
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
       uniqueKey1: 103, input5131y: value5131t3, input5131v: value5131t8
    },
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
       uniqueKey1: 104, input5131y: value5131t4, input5131v: value5131t9
    },
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
       uniqueKey1: 105, input5131y: value5131t5, input5131v: value5131t10
    },
  ],

  yearTable51312: [
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
       uniqueKey1: 101, input51312y: value5131t11, input51312v: value5131t16
    },
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
       uniqueKey1: 102, input51312y: value5131t12, input51312v: value5131t17
    },
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
       uniqueKey1: 103, input51312y: value5131t13, input51312v: value5131t18
    },
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
       uniqueKey1: 104, input51312y: value5131t14, input51312v: value5131t19
    },
    {
      criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
       uniqueKey1: 105, input51312y: value5131t15, input51312v: value5131t20
    },
  ],

};

function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: 'application/json',
  });
}

function onClickingSave() {
  const form51Data = new FormData();

  form51Data.append('criteria5Fieldinfo', jsonBlob(inputDataList));

  if (pathValue512f1 !== '') {
    form51Data.append('uploadfile5', value512f1, 'f513f1-' + value512f1.name);
  }
  if (pathValue512f2 !== '') {
    form51Data.append('uploadfile5', value512f2, 'f513f2-' + value512f2.name);
  }
  if (pathValue512f3 !== '') {
    form51Data.append('uploadfile5', value512f3, 'f512f3-' + value512f3.name);
  }

  if (pathValue514f1 !== '') {
    form51Data.append('uploadfile5', value514f1, 'f514f1-' + value514f1.name);
  }
  if (pathValue514f2 !== '') {
    form51Data.append('uploadfile5', value514f2, 'f514f2-' + value514f2.name);
  }
  if (pathValue514f3 !== '') {
    form51Data.append('uploadfile5', value514f3, 'f514f3-' + value514f3.name);
  }
  if (pathValue5111f1 !== '') {
    form51Data.append(
      'uploadfile5',
      value5111f1,
      'f5111f1-' + value5111f1.name
    );
  }
  if (pathValue5111f2 !== '') {
    form51Data.append(
      'uploadfile5',
      value5111f2,
      'f5111f2-' + value5111f2.name
    );
  }
  if (pathValue5111f3 !== '') {
    form51Data.append(
      'uploadfile5',
      value5111f3,
      'f5111f3-' + value5111f3.name
    );
  }
  if (pathValue5111f4 !== '') {
    form51Data.append(
      'uploadfile5',
      value5111f4,
      'f5111f4-' + value5111f4.name
    );
  }
  if (pathValue5131f1 !== '') {
    form51Data.append(
      'uploadfile5',
      value5131f1,
      'f5131f1-' + value5131f1.name
    );
  }
  if (pathValue5131f2 !== '') {
    form51Data.append(
      'uploadfile5',
      value5131f2,
      'f5131f2-' + value5131f2.name
    );
  }
  if (pathValue5131f3 !== '') {
    form51Data.append(
      'uploadfile5',
      value5131f3,
      'f5131f3-' + value5131f3.name
    );
  }

  const filesFetchMethod = {
    method: 'POST',
    headers: { Accept: 'application/json ,text/plain' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: form51Data,
  };
  fetch(
    resources.APPLICATION_URL+'criteria5upload',
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
  // rendering dom
  return (
    <div className="c51-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c51x-colorIndicator-container">
        <p className="c51x-QlcolorIndicator-circle-style"></p>
        <span className="c51x-colorIndicator-span-style">Qualitative</span>
        <p className="c51x-QtcolorIndicator-circle-style"></p>
        <span className="c51x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c51x-weightage-heading-style">
            Key Indicator Weightage:50
          </h1>
        </div>
      </div>

      {/* Key Indicator: 5.1.1 */}
      <div className="c51x-eachInputField-container">
        <div className="c51x-weightage-container">
          <h1 className="c51x-weightage-heading-style">Weightage:20</h1>
        </div>
        <form>
          <div className="c51x-container">
            <div className="c51x-heading_Help-container">
              <h1 className="c51x-heading-style">
                <span className="c51x-span-style">5.1.1: </span>
              percentage of students benefited by scholarships and
                freeships provided by the Government during last five years
              </h1>
              <button
                onClick={handleHelpOpen}
              className="c51x-helpButton-style"
                >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose}
                title='percentage'
                ><h1>((Total number of students benefited by scholarships and freeships provided by Government and  Non-Government agencies and philanthropists / Total number of students during the last five years))</h1></HelpButton>
            </div>
            <div className="c51x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus511(!responseButtonStatus511);
                  onClickingViewResponse511();
                }}
                className="c51x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus511 ? (
                <p className="c51x-responseResult-style">{responseValue511}</p>
              ) : null}
            </div>
          </div>
          <div className="c51xx-container">
            <h1 className="c51x-heading-style">
              <span className="c51x-span-style">5.1.1.1 </span>
              umber of students benefited by scholarships and free ships
              provided by the institution, Government and non-government bodies,
              industries, individuals, philanthropists during the last five
              years (other than students receiving scholarships under the
              government schemes for reserved categories)
            </h1>
            <table className="c51x-Qt-table-style">
              <tr>
                <th className="c51x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue5111t1(e.target.value)}
                      id="5111-t1"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t1}
                    />
                    {value5111t1 === '' ? (
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
                      onChange={(e) => setValue5111t2(e.target.value)}
                      id="5111-t2"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t2}
                    />
                    {value5111t2 === '' ? (
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
                      onChange={(e) => setValue5111t3(e.target.value)}
                      id="5111-t3"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t3}
                    />
                    {value5111t3 === '' ? (
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
                      onChange={(e) => setValue5111t4(e.target.value)}
                      id="5111-t4"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t4}
                    />
                    {value5111t4 === '' ? (
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
                      onChange={(e) => setValue5111t5(e.target.value)}
                      id="5111-t5"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t5}
                    />
                    {value5111t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c51x-horizontalTable-heading-style">Number</th>
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
                        setValue5111t6(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t6"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t6}
                    />
                    {value5111t6 === '' ? (
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
                        setValue5111t7(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t7"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t7}
                    />
                    {value5111t7 === '' ? (
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
                        setValue5111t8(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t8"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t8}
                    />
                    {value5111t8 === '' ? (
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
                        setValue5111t9(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t9"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t9}
                    />
                    {value5111t9 === '' ? (
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
                        setValue5111t10(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t10"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t10}
                    />
                    {value5111t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            {/* <table className="c51x-Qt-table-style">
              <tr>
                <th className="c51x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue5111t11(e.target.value)}
                      id="5111-t11"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t11}
                    />
                    {value5111t11 === '' ? (
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
                      onChange={(e) => setValue5111t12(e.target.value)}
                      id="5111-t12"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t12}
                    />
                    {value5111t12 === '' ? (
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
                      onChange={(e) => setValue5111t13(e.target.value)}
                      id="5111-t13"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t13}
                    />
                    {value5111t13 === '' ? (
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
                      onChange={(e) => setValue5111t14(e.target.value)}
                      id="5111-t14"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t14}
                    />
                    {value5111t14 === '' ? (
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
                      onChange={(e) => setValue5111t15(e.target.value)}
                      id="5111-t15"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t15}
                    />
                    {value5111t15 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c51x-horizontalTable-heading-style">Number</th>
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
                        setValue5111t16(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t16"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t16}
                    />
                    {value5111t16 === '' ? (
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
                        setValue5111t17(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t17"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t17}
                    />
                    {value5111t17 === '' ? (
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
                        setValue5111t18(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t18"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t18}
                    />
                    {value5111t18 === '' ? (
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
                        setValue5111t19(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t19"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t19}
                    />
                    {value5111t19 === '' ? (
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
                        setValue5111t20(e.target.value);
                        onClickingViewResponse511();
                      }}
                      id="5111-t20"
                      className="c51x-input-style"
                      type="text"
                      value={value5111t20}
                    />
                    {value5111t20 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> */}
            <table className="c51x-table-style">
              <tr>
                <th className="c51x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c51x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c51x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c51x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                  upload self attested letter with the list of students
                  sanctioned scholarships
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5111f1(e.target.files[0]);
                      setPathValue5111f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5111-f1"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5111f1 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5111f1("");
                      document.getElementById("5111-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value5111f1)} target="_blank">View File</a> */}
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5111f2(e.target.files[0]);
                      setPathValue5111f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5111-f2"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5111f2 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5111f2("");
                      document.getElementById("5111-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value5111f2)} target="_blank">View File</a> */}
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td> Average percentage of students benefited by scholarships and
                  freeships provided by the Government during the last five
                  years</td>
                <td>
                <a href={downloadFile("af5.1.1.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5111f3(e.target.files[0]);
                      setPathValue5111f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5111-f3"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5111f3 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5111f3("");
                      document.getElementById("5111-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value5111f3)} target="_blank">View File</a> */}
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 5.1.2 */}
      <div className="c51x-eachInputField-container">
        <div className="c51x-weightage-container">
          <h1 className="c51x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c51x-container">
            <div className="c51x-heading_Help-container">
              <div>
                <h1 className="c51x-heading-style">
                  <span className="c51x-span-style">5.1.2: </span>
                  Following Capacity development and skills enhancement
                  activities are organised for improving students capability
                </h1>
                <p className="c51x-para-style">
                  1.Soft skills
                  <br />
                  2.Language and communication skills
                  <br />
                  3.Life skills (Yoga, physical fitness, health and hygiene)
                  <br />
                  4.Awareness of trends in technology
                </p>
                <div className="c51x-radio-container">
                  <div className="c51x-radio-subContainer" style={{width:"45%"}}>
                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue512t1(e.target.value)}
                        value="option a"
                        name="512-t1"
                        type="radio"
                      />
                      <label className="c51x-radioLabel-style" for="512-t1">
                        A. All of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue512t1(e.target.value)}
                        value="option b"
                        name="512-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="512-t1">
                        B. Any three of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue512t1(e.target.value)}
                        value="option c"
                        name="512-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="512-t1">
                        C. Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c51x-radio-subContainer">
                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue512t1(e.target.value)}
                        value="option d"
                        name="512-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="512-t1">
                        D. Any one of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue512t1(e.target.value)}
                        value="option e"
                        name="512-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="512-t1">
                        E. None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen2}
              className="c44x-helpButton-style"
                >
                Help
              </button>
              <HelpButton
                isOpen={isOpen2}
                handleClose={handleHelpClose2}
                title='File Description'
                ></HelpButton>
            </div>
          </div>
          <table className="c51x-table-style">
            <tr>
              <th className="c51x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c51x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c51x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c51x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Link to Institutional website</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue512f1(e.target.files[0]);
                    setPathValue512f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="512-f1"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue512f1 === '' ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue512f1("");
                      document.getElementById("512-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                {/* <a href={downloadFile(value512f1)} target="_blank">View File</a> */}
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue512f2(e.target.files[0]);
                    setPathValue512f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="512-f2"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue512f2 === '' ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue512f2("");
                      document.getElementById("512-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                {/* <a href={downloadFile(value512f2)} target="_blank">View File</a> */}
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Details of capability development and schemes</td>
              <td>
              <a href={downloadFile("af5.1.2.xlsx")} target="_blank">View Template</a>
              </td>
              <td>
                <input
                  onChange={(e) => {
                    setValue512f3(e.target.files[0]);
                    setPathValue512f3(e.target.value);
                    showFilePreview(e);
                  }}
                  id="512-f3"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue512f3 === '' ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue512f3("");
                      document.getElementById("512-f3").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                {/* <a href={downloadFile(value512f3)} target="_blank">View File</a> */}
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 5.1.3 */}
      <div className="c51x-eachInputField-container">
        <div className="c51x-weightage-container">
          <h1 className="c51x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c51x-container">
            <div className="c51x-heading_Help-container">
              <h1 className="c51x-heading-style">
                <span className="c51x-span-style">5.1.3: </span>
                Percentage of students benefitted by guidance for competitive examinations and career counseling offered 
                by the Institution during the last five years
              </h1>
              <button
                onClick={handleHelpOpen3}
              className="c51x-helpButton-style"
                >
                Help
              </button>
              <HelpButton
                isOpen={isOpen3}
                handleClose={handleHelpClose3}
                title='percentage'
                > <h1>((Total number of students benefited by guidance for competitive examinations and career counselingduring the last five years)/Total number of students benefited by guidance for competitive examinations and career counselingduring the last five years) * 100</h1></HelpButton>
            </div>
            <div className="c51x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus513(!responseButtonStatus513);
                  onClickingViewResponse513();
                }}
                className="c51x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus513 ? (
                <p className="c51x-responseResult-style">{responseValue513}</p>
              ) : null}
            </div>
          </div>
          <div className="c51xx-container">
            <h1 className="c51x-heading-style">
              <span className="c51x-span-style">5.1.3.1 </span>
              Number of students benefitted by guidance for competitive
              examinations and career counselling offered by the institution
              year wise during last five years
            </h1>
            <table className="c51x-Qt-table-style">
              <tr>
                <th className="c51x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue5131t1(e.target.value)}
                      id="5131-t1"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t1}
                    />
                    {value5131t1 === '' ? (
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
                      onChange={(e) => setValue5131t2(e.target.value)}
                      id="5131-t2"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t2}
                    />
                    {value5131t2 === '' ? (
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
                      onChange={(e) => setValue5131t3(e.target.value)}
                      id="5131-t3"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t3}
                    />
                    {value5131t3 === '' ? (
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
                      onChange={(e) => setValue5131t4(e.target.value)}
                      id="5131-t4"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t4}
                    />
                    {value5131t4 === '' ? (
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
                      onChange={(e) => setValue5131t5(e.target.value)}
                      id="5131-t5"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t5}
                    />
                    {value5131t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c51x-horizontalTable-heading-style">Number</th>
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
                        setValue5131t6(e.target.value);
                        onClickingViewResponse513();
                      }}
                      id="5131-t6"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t6}
                    />
                    {value5131t6 === '' ? (
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
                        setValue5131t7(e.target.value);
                        onClickingViewResponse513();
                      }}
                      id="5131-t7"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t7}
                    />
                    {value5131t7 === '' ? (
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
                        setValue5131t8(e.target.value);
                        onClickingViewResponse513();
                      }}
                      id="5131-t8"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t8}
                    />
                    {value5131t8 === '' ? (
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
                        setValue5131t9(e.target.value);
                        onClickingViewResponse513();
                      }}
                      id="5131-t9"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t9}
                    />
                    {value5131t9 === '' ? (
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
                        setValue5131t10(e.target.value);
                        onClickingViewResponse513();
                      }}
                      id="5131-t10"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t10}
                    />
                    {value5131t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            {/* <table className="c51x-Qt-table-style">
              <tr>
                <th className="c51x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue5131t11(e.target.value)}
                      id="5131-t11"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t11}
                    />
                    {value5131t11 === '' ? (
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
                      onChange={(e) => setValue5131t12(e.target.value)}
                      id="5131-t12"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t12}
                    />
                    {value5131t12 === '' ? (
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
                      onChange={(e) => setValue5131t13(e.target.value)}
                      id="5131-t13"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t13}
                    />
                    {value5131t13 === '' ? (
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
                      onChange={(e) => setValue5131t14(e.target.value)}
                      id="5131-t14"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t14}
                    />
                    {value5131t14 === '' ? (
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
                      onChange={(e) => setValue5131t15(e.target.value)}
                      id="5131-t15"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t15}
                    />
                    {value5131t15 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c51x-horizontalTable-heading-style">Number</th>
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
                        setValue5131t16(e.target.value);
                        onClickingViewResponse513();
                      }}
                      id="5131-t16"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t16}
                    />
                    {value5131t16 === '' ? (
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
                        setValue5131t17(e.target.value);
                        onClickingViewResponse513();
                      }}
                      id="5131-t17"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t17}
                    />
                    {value5131t17 === '' ? (
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
                        setValue5131t18(e.target.value);
                        onClickingViewResponse513();
                      }}
                      id="5131-t18"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t18}
                    />
                    {value5131t18 === '' ? (
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
                        setValue5131t19(e.target.value);
                        onClickingViewResponse513();
                      }}
                      id="5131-t19"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t19}
                    />
                    {value5131t19 === '' ? (
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
                        setValue5131t20(e.target.value);
                        onClickingViewResponse513();
                      }}
                      id="5131-t20"
                      className="c51x-input-style"
                      type="text"
                      value={value5131t20}
                    />
                    {value5131t20 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> */}
            <table className="c51x-table-style">
              <tr>
                <th className="c51x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c51x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c51x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c51x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                Any additional information
                </td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5131f1(e.target.files[0]);
                      setPathValue5131f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5131-f1"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5131f1 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5131f1("");
                      document.getElementById("5131-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value5131f1)} target="_blank">View File</a> */}
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Number of students benefited by guidance for competitive
                   examinations and career counselling during the last five years(Data Template)</td>
                <td> <a href={downloadFile("af5.1.3.xlsx")} target="_blank">View Template</a></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5131f2(e.target.files[0]);
                      setPathValue5131f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5131-f2"
                    type="file"
                    className="c51-fileButton-style"
                  />
                  {pathValue5131f2 === '' ? null : (
                    <div className="c51-fileButtons-container">
                      <button className="c51-viewFileButton-style">
                        <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5131f2("");
                      document.getElementById("5131-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  {/* <a href={downloadFile(value5131f2)} target="_blank">View File</a> */}
                </td>
                <td className="c51x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 5.1.4 */}
      <div className="c51x-eachInputField-container">
        <div className="c51x-weightage-container">
          <h1 className="c51x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c51x-container">
            <div className="c51x-heading_Help-container">
              <div>
                <h1 className="c51x-heading-style">
                  <span className="c51x-span-style">5.1.4: </span>
                  The institution adopts the following for redressal of student
                  grievances including sexual harassment and ragging cases
                </h1>
                <p className="c51x-para-style">
                  1. Implementation of guidelines of statutory/regulatory bodies
                  <br />
                  2. Organisation wide awareness and undertakings on policies
                  with zero tolerance
                  <br />
                  3. Mechanisms for submission of online/offline students’
                  grievances
                  <br />
                  4. Timely redressal of the grievances through appropriate
                  committees
                </p>
                <div className="c51x-radio-container">
                  <div className="c51x-radio-subContainer" style={{width:"45%"}}>
                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="514-t1">
                        A. All of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="514-t1">
                        B. Any three of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="514-t1">
                        C. Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c51x-radio-subContainer">
                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="514-t1">
                        D. Any one of the above
                      </label>
                    </div>

                    <div className="c51x-eachRadio-container">
                      <input
                        onChange={(e) => setValue514t1(e.target.value)}
                        value="option a"
                        name="514-t1"
                        type="radio"
                      />

                      <label className="c51x-radioLabel-style" for="514-t1">
                        E. None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen4}
              className="c44x-helpButton-style"
                >
                Help
              </button>
              <HelpButton
                isOpen={isOpen4}
                handleClose={handleHelpClose4}
                title='file description'
                ></HelpButton>
            </div>
          </div>
          <table className="c51x-table-style">
            <tr>
              <th className="c51x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c51x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c51x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c51x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>
                Minutes of the meetings of student redressal committee,
                prevention of sexual harassment committee and Anti Ragging
                committee
              </td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue514f1(e.target.files[0]);
                    setPathValue514f1(e.target.value);
                    showFilePreview(e);
                  }}
                  id="514-f1"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue514f1 === '' ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue514f1("");
                      document.getElementById("514-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                {/* <a href={downloadFile(value514f1)} target="_blank">View File</a> */}
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Upload any additional information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue514f2(e.target.files[0]);
                    setPathValue514f2(e.target.value);
                    showFilePreview(e);
                  }}
                  id="514-f2"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue514f2 === '' ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue514f2("");
                      document.getElementById("514-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                {/* <a href={downloadFile(value514f2)} target="_blank">View File</a> */}
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Details of student grievances including sexual harassment and
                ragging cases
              </td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue514f3(e.target.files[0]);
                    setPathValue514f3(e.target.value);
                    showFilePreview(e);
                  }}
                  id="514-f3"
                  type="file"
                  className="c51-fileButton-style"
                />
                {pathValue514f3 === '' ? null : (
                  <div className="c51-fileButtons-container">
                    <button className="c51-viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                    </button>
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue514f3("");
                      document.getElementById("514-f3").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                {/* <a href={downloadFile(value514f3)} target="_blank">View File</a> */}
              </td>
              <td className="c51x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>
      <div className="c51x-button-container">
        <button onClick={onClickingSave} className="c51x-button-style">
          Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria51;
