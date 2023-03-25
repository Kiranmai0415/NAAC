import React, { useState, useEffect } from 'react';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import './c24-style.css';
import { HelpButton } from "../../../../../reusableComponents/model/Help";
import { resources } from "../../../../appConstants";
import { Button } from '@mui/material';
// Alert custom messages start
const successMessage = (message) => {
  toast.success(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "success1",
  });
};
const errorMessage = (message) => {
  toast.error(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "error1",
  });
};
// End here

// Help buttons functionality
function Help241(props) {
  return props.isHelp241Clicked ? (
    <div className="c24x-help-mainContainer">
      <div className="c24x-help-subContainer">
        <h1 className="c24x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c24x-help-para-style">
          <span style={{ fontWeight: 'bold' }}>(</span>Number of full time
          teachers
          <span style={{ fontWeight: 'bold' }}>) /</span>
          <span style={{ fontWeight: 'bold' }}>(</span> Number of Sanctioned
          posts
          <span style={{ fontWeight: 'bold' }}>) /</span>*100
        </p>
        <p className="c24x-help-para-style">
          Average Percentage
          <span style={{ fontWeight: 'bold' }}>=(</span> ΣPercentage per year
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>
        <button
          className="c24x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp241Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help242(props) {
  return props.isHelp242Clicked ? (
    <div className="c24x-help-mainContainer">
      <div className="c24x-help-subContainer">
        <h1 className="c24x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c24x-help-para-style">
          Percentage per year<span style={{ fontWeight: 'bold' }}>=</span>
          <span style={{ fontWeight: 'bold' }}>(</span>Number of full time
          teachers with Ph.D./D.M/M.Ch./D.N.B Superspeciality/D.Sc./D’Lit. year
          wise during the last five years
          <span style={{ fontWeight: 'bold' }}>) /</span>
          <span style={{ fontWeight: 'bold' }}>(</span> Number of full time
          teachers
          <span style={{ fontWeight: 'bold' }}>) *</span>100
        </p>
        <p className="c24x-help-para-style">
          Average percentage<span style={{ fontWeight: 'bold' }}>=</span>
          <span style={{ fontWeight: 'bold' }}>(</span> ΣPercentage per year
          <span style={{ fontWeight: 'bold' }}>) /</span> 5
        </p>
        <button
          className="c24x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp242Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help243(props) {
  return props.isHelp243Clicked ? (
    <div className="c24x-help-mainContainer">
      <div className="c24x-help-subContainer">
        <h1 className="c24x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c24x-help-para-style">
          Sum of total teaching experience of full time teachers in the same
          institution
          <span style={{ fontWeight: 'bold' }}> /</span> Number of full time
          teachers
        </p>
        <button
          className="c24x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp243Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

// Promotion of Research and Facilities
function Criteria24() {
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

  const [value241t1, setValue241t1] = useState();
  const [value241t2, setValue241t2] = useState();
  const [value241t3, setValue241t3] = useState();
  const [value241t4, setValue241t4] = useState();
  const [value241t5, setValue241t5] = useState();
  const [value241t6, setValue241t6] = useState();
  const [value241t7, setValue241t7] = useState();
  const [value241t8, setValue241t8] = useState();
  const [value241t9, setValue241t9] = useState();
  const [value241t10, setValue241t10] = useState();

  const [value241t11, setValue241t11] = useState();
  const [value241t12, setValue241t12] = useState();
  const [value241t13, setValue241t13] = useState();
  const [value241t14, setValue241t14] = useState();
  const [value241t15, setValue241t15] = useState();
  const [value241t16, setValue241t16] = useState();
  const [value241t17, setValue241t17] = useState();
  const [value241t18, setValue241t18] = useState();
  const [value241t19, setValue241t19] = useState();
  const [value241t20, setValue241t20] = useState();
  const [value241t21, setValue241t21] = useState();
  const [pathValue241f1, setPathValue241f1] = useState('');
  const [pathValue241f2, setPathValue241f2] = useState('');
  const [pathValue241f3, setPathValue241f3] = useState('');

  const [value241f1, setValue241f1] = useState([]);
  const [value241f2, setValue241f2] = useState([]);
  const [value241f3, setValue241f3] = useState([]);

  const [value2421t1, setValue2421t1] = useState();
  const [value2421t2, setValue2421t2] = useState();
  const [value2421t3, setValue2421t3] = useState();
  const [value2421t4, setValue2421t4] = useState();
  const [value2421t5, setValue2421t5] = useState();
  const [value2421t6, setValue2421t6] = useState();
  const [value2421t7, setValue2421t7] = useState();
  const [value2421t8, setValue2421t8] = useState();
  const [value2421t9, setValue2421t9] = useState();
  const [value2421t10, setValue2421t10] = useState();

  const [value2421t11, setValue2421t11] = useState();
  const [value2421t12, setValue2421t12] = useState();
  const [value2421t13, setValue2421t13] = useState();
  const [value2421t14, setValue2421t14] = useState();
  const [value2421t15, setValue2421t15] = useState();
  const [value2421t16, setValue2421t16] = useState();
  const [value2421t17, setValue2421t17] = useState();
  const [value2421t18, setValue2421t18] = useState();
  const [value2421t19, setValue2421t19] = useState();
  const [value2421t20, setValue2421t20] = useState();
  const [value2421t21, setValue2421t21] = useState();
  const [pathValue2421f1, setPathValue2421f1] = useState('');
  const [pathValue2421f2, setPathValue2421f2] = useState('');
  const [value2421f1, setValue2421f1] = useState([]);
  const [value2421f2, setValue2421f2] = useState([]);

  const [value2431t1, setValue2431t1] = useState();
  const [value2431t2, setValue2431t2] = useState();

  const [pathValue2431f1, setPathValue2431f1] = useState('');
  const [pathValue2431f2, setPathValue2431f2] = useState('');

  const [value2431f1, setValue2431f1] = useState([]);
  const [value2431f2, setValue2431f2] = useState([]);

  const [responseButtonStatus241, setResponseButtonStatus241] = useState(false);
  const [responseButtonStatus242, setResponseButtonStatus242] = useState(false);
  const [responseButtonStatus243, setResponseButtonStatus243] = useState(false);
  const [responseValue241, setResponseValue241] = useState('');
  const [responseValue242, setResponseValue242] = useState('');
  const [responseValue243, setResponseValue243] = useState('');
  const [help241Status, setHelp241Status] = useState(false);
  const [help242Status, setHelp242Status] = useState(false);
  const [help243Status, setHelp243Status] = useState(false);
//get data
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
  () => fetch(resources.APPLICATION_URL+'criteria2getallfiles?collegeId='+collegeId+'&financialYear='+financialYear+'&typeofInstitution='+instituteType).then(
    (response) => response
      .json()
      .then((data) => {
        console.log(JSON.stringify(data));

        setValue2431t1(data[0].criteria24Qn[0] ? data[0].criteria24Qn[0].input2431t1 : "");
        setValue2431t2(data[0].criteria24Qn[0] ? data[0].criteria24Qn[0].input2431t3 : "");
        // setValue2421t21(data[0].criteria24Qn[0].input241t21);
        // setValue2431t1(data[0].criteria24Qn[0].input2431t1);
        setResponseValue241(data[0].criteria24Qn[0] ? data[0].criteria24Qn[0].response241 : "");
        setResponseValue242(data[0].criteria24Qn[0] ? data[0].criteria24Qn[0].response242 : "");
        setResponseValue243(data[0].criteria24Qn[0] ? data[0].criteria24Qn[0].response243 : "");


        setValue241t1(data[0].yearTable2411[0] ? data[0].yearTable2411[0].input2411y : "");
        setValue241t2(data[0].yearTable2411[1] ? data[0].yearTable2411[1].input2411y : "");
        setValue241t3(data[0].yearTable2411[2] ? data[0].yearTable2411[2].input2411y : "");
        setValue241t4(data[0].yearTable2411[3] ? data[0].yearTable2411[3].input2411y : "");
        setValue241t5(data[0].yearTable2411[4] ? data[0].yearTable2411[4].input2411y : "");
        setValue241t6(data[0].yearTable2411[0] ? data[0].yearTable2411[0].input2411v : "");
        setValue241t7(data[0].yearTable2411[1] ? data[0].yearTable2411[1].input2411v : "");
        setValue241t8(data[0].yearTable2411[2] ? data[0].yearTable2411[2].input2411v : "");
        setValue241t9(data[0].yearTable2411[3] ? data[0].yearTable2411[3].input2411v : "");
        setValue241t10(data[0].yearTable2411[4] ? data[0].yearTable2411[4].input2411v : "");

        setValue241t11(data[0].yearTable24112[0] ? data[0].yearTable24112[0].input24112y : "");
        setValue241t12(data[0].yearTable24112[1] ? data[0].yearTable24112[1].input24112y : "");
        setValue241t13(data[0].yearTable24112[2] ? data[0].yearTable24112[2].input24112y : "");
        setValue241t14(data[0].yearTable24112[3] ? data[0].yearTable24112[3].input24112y : "");
        setValue241t15(data[0].yearTable24112[4] ? data[0].yearTable24112[4].input24112y : "");
        setValue241t16(data[0].yearTable24112[0] ? data[0].yearTable24112[0].input24112v : "");
        setValue241t17(data[0].yearTable24112[1] ? data[0].yearTable24112[1].input24112v : "");
        setValue241t18(data[0].yearTable24112[2] ? data[0].yearTable24112[2].input24112v : "");
        setValue241t19(data[0].yearTable24112[3] ? data[0].yearTable24112[3].input24112v : "");
        setValue241t20(data[0].yearTable24112[4] ? data[0].yearTable24112[4].input24112v : "");

        setValue2421t1(data[0].yearTable2421[0] ? data[0].yearTable2421[0].input2421y : "");
        setValue2421t2(data[0].yearTable2421[1] ? data[0].yearTable2421[1].input2421y : "");
        setValue2421t3(data[0].yearTable2421[2] ? data[0].yearTable2421[2].input2421y : "");
        setValue2421t4(data[0].yearTable2421[3] ? data[0].yearTable2421[3].input2421y : "");
        setValue2421t5(data[0].yearTable2421[4] ? data[0].yearTable2421[4].input2421y : "");
        setValue2421t6(data[0].yearTable2421[0] ? data[0].yearTable2421[0].input2421v : "");
        setValue2421t7(data[0].yearTable2421[1] ? data[0].yearTable2421[1].input2421v : "");
        setValue2421t8(data[0].yearTable2421[2] ? data[0].yearTable2421[2].input2421v : "");
        setValue2421t9(data[0].yearTable2421[3] ? data[0].yearTable2421[3].input2421v : "");
        setValue2421t10(data[0].yearTable2421[4] ? data[0].yearTable2421[4].input2421v : "");

        setValue2421t11(data[0].yearTable24212[0] ? data[0].yearTable24212[0].input24212y : "");
        setValue2421t12(data[0].yearTable24212[1] ? data[0].yearTable24212[1].input24212y : "");
        setValue2421t13(data[0].yearTable24212[2] ? data[0].yearTable24212[2].input24212y : "");
        setValue2421t14(data[0].yearTable24212[3] ? data[0].yearTable24212[3].input24212y : "");
        setValue2421t15(data[0].yearTable24212[4] ? data[0].yearTable24212[4].input24212y : "");
        setValue2421t16(data[0].yearTable24212[0] ? data[0].yearTable24212[0].input24212v : "");
        setValue2421t17(data[0].yearTable24212[1] ? data[0].yearTable24212[1].input24212v : "");
        setValue2421t18(data[0].yearTable24212[2] ? data[0].yearTable24212[2].input24212v : "");
        setValue2421t19(data[0].yearTable24212[3] ? data[0].yearTable24212[3].input24212v : "");
        setValue2421t20(data[0].yearTable24212[4] ? data[0].yearTable24212[4].input24212v : "");

        // setValue241f1(data[0].criteria2FileUpload[0].criteria2FileName);
        // setValue241f2(data[0].criteria2FileUpload[1].criteria2FileName);
        // setValue241f3(data[0].criteria2FileUpload[2].criteria2FileName);
        // setValue2421f1(data[0].criteria2FileUpload[3].criteria2FileName);
        // setValue2421f2(data[0].criteria2FileUpload[4].criteria2FileName);
        // setValue2431f1(data[0].criteria2FileUpload[5].criteria2FileName);
        // setValue2431f2(data[0].criteria2FileUpload[6].criteria2FileName);
      })
      .catch((error) => {
        console.error("Error:", error);
      })
  ),
  []
);
  // response button functionality
  function onClickingViewResponse241() {
    if (
      value241t6 === ''
      || value241t7 === ''
      || value241t8 === ''
      || value241t9 === ''
      || value241t10 === ''
      || value241t16 === ''
      || value241t17 === ''
      || value241t18 === ''
      || value241t19 === ''
      || value241t20 === ''
      || value241t6 === undefined
      || value241t7 === undefined
      || value241t8 === undefined
      || value241t9 === undefined
      || value241t10 === undefined
      || value241t16 === undefined
      || value241t17 === undefined
      || value241t18 === undefined
      || value241t19 === undefined
      || value241t20 === undefined
    ) {
      setResponseValue241('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value241t6, 10)) === false
      || Number.isInteger(parseInt(value241t7, 10)) === false
      || Number.isInteger(parseInt(value241t8, 10)) === false
      || Number.isInteger(parseInt(value241t9, 10)) === false
      || Number.isInteger(parseInt(value241t10, 10)) === false
      || Number.isInteger(parseInt(value241t16, 10)) === false
      || Number.isInteger(parseInt(value241t17, 10)) === false
      || Number.isInteger(parseInt(value241t18, 10)) === false
      || Number.isInteger(parseInt(value241t19, 10)) === false
      || Number.isInteger(parseInt(value241t20, 10)) === false
    ) {
      setResponseValue241('Input should be an Integer');
    } else if (
      value241t6 !== ''
      && value241t7 !== ''
      && value241t8 !== ''
      && value241t9 !== ''
      && value241t10 !== ''
      && value241t16 !== ''
      && value241t17 !== ''
      && value241t18 !== ''
      && value241t19 !== ''
      && value241t20 !== ''
    ) {
      setResponseValue241(
        ((value241t6 / value241t16) * 100
          + (value241t7 / value241t17) * 100
          + (value241t8 / value241t18) * 100
          + (value241t9 / value241t19) * 100
          + (value241t10 / value241t20) * 100)
          / 5
      );
    }
  }

  function onClickingViewResponse242() {
    if (
      value2421t6 === ''
      || value2421t7 === ''
      || value2421t8 === ''
      || value2421t9 === ''
      || value2421t10 === ''
      || value2421t16 === ''
      || value2421t17 === ''
      || value2421t18 === ''
      || value2421t19 === ''
      || value2421t20 === ''
      || value2421t6 === undefined
      || value2421t7 === undefined
      || value2421t8 === undefined
      || value2421t9 === undefined
      || value2421t10 === undefined
      || value2421t16 === undefined
      || value2421t17 === undefined
      || value2421t18 === undefined
      || value2421t19 === undefined
      || value2421t20 === undefined
    ) {
      setResponseValue242('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value2421t6, 10)) === false
      || Number.isInteger(parseInt(value2421t7, 10)) === false
      || Number.isInteger(parseInt(value2421t8, 10)) === false
      || Number.isInteger(parseInt(value2421t9, 10)) === false
      || Number.isInteger(parseInt(value2421t10, 10)) === false
      || Number.isInteger(parseInt(value2421t16, 10)) === false
      || Number.isInteger(parseInt(value2421t17, 10)) === false
      || Number.isInteger(parseInt(value2421t18, 10)) === false
      || Number.isInteger(parseInt(value2421t19, 10)) === false
      || Number.isInteger(parseInt(value2421t20, 10)) === false
    ) {
      setResponseValue242('Input should be an Integer');
    } else if (
      value2421t6 !== ''
      && value2421t7 !== ''
      && value2421t8 !== ''
      && value2421t9 !== ''
      && value2421t10 !== ''
      && value2421t16 !== ''
      && value2421t17 !== ''
      && value2421t18 !== ''
      && value2421t19 !== ''
      && value2421t20 !== ''
    ) {
      setResponseValue242(
        ((value2421t6 / value2421t16) * 100
            + (value2421t7 / value2421t17) * 100
            + (value2421t8 / value2421t18) * 100
            + (value2421t9 / value2421t19) * 100
            + (value2421t10 / value2421t20) * 100)
            / 5
      );
    }
  }

  function onClickingViewResponse243() {
    if (value2431t1 === '' || value2431t2 === '') {
      setResponseValue243('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value2431t1, 10)) === false
      || Number.isInteger(parseInt(value2431t2, 10)) === false
    ) {
      setResponseValue243('Input should be an Integer');
    } else if (value2431t1 !== '' && value2431t2 !== '') {
      setResponseValue243(
        parseInt(value2431t1, 10) / parseInt(value2431t2, 10)
      );
    }
  }

 
  // sending data to db with API
 
  const inputDataList = {
    criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
    criteria24Qn: [
      {
      criteriaId: {  collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
      uniqueKey1: 1,
      input2431t1: value2431t1,
      input2431t3: value2431t2,
      // input2421t21: value2421t21,
      response241: responseValue241,
      response242: responseValue242,
      response243: responseValue243,
      criteria24status:"save"
    },
    ],
    yearTable2411: [
      {
        criteriaId: {  collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 1, input2411y: value241t1, input2411v: value241t6
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
        
        
        uniqueKey1: 2, input2411y: value241t2, input2411v: value241t7
      },
      {
        criteriaId: {  collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  }, uniqueKey1: 3, input2411y: value241t3, input2411v: value241t8
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
        
        uniqueKey1: 4, input2411y: value241t4, input2411v: value241t9
      },
      {
        criteriaId: {  collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
        
        uniqueKey1: 5, input2411y: value241t5, input2411v: value241t10
      },
    ],
    yearTable24112: [
      {
        criteriaId: {  collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 1, input24112y: value241t11, input24112v: value241t16
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 2, input24112y: value241t12, input24112v: value241t17
      },
      {
        criteriaId: {  collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 3, input24112y: value241t13, input24112v: value241t18
      },
      {
        criteriaId: {  collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         
        uniqueKey1: 4, input24112y: value241t14, input24112v: value241t19
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 5, input24112y: value241t15, input24112v: value241t20
      },
    ],
    yearTable2421: [
      {
        criteriaId: {  collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 1, input2421y: value2421t1, input2421v: value2421t6
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
        
        uniqueKey1: 2, input2421y: value2421t2, input2421v: value2421t7
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
        
        uniqueKey1: 3, input2421y: value2421t3, input2421v: value2421t8
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
        
        uniqueKey1: 4, input2421y: value2421t4, input2421v: value2421t9
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
        
        uniqueKey1: 5, input2421y: value2421t5, input2421v: value2421t10
      },
    ],
    yearTable24212: [
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
        
        uniqueKey1: 1, input24212y: value2421t1, input24212v: value2421t6
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
        
        uniqueKey1: 2, input24212y: value2421t2, input24212v: value2421t7
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
        
        uniqueKey1: 3, input24212y: value2421t3, input24212v: value2421t8
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
        
        uniqueKey1: 4, input24212y: value2421t4, input24212v: value2421t9
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
        
        uniqueKey1: 5, input24212y: value2421t5, input24212v: value2421t10
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form24Data = new FormData();

    form24Data.append('criteria2Fieldinfo', jsonBlob(inputDataList));
    if (pathValue241f1 !== '') {
      form24Data.append('uploadfile2', value241f1, 'f241f1-' + value241f1.name);
    }
    if (pathValue241f2 !== '') {
      form24Data.append('uploadfile2', value241f2, 'f241f2-' + value241f2.name);
    }
    if (pathValue241f3 !== '') {
      form24Data.append('uploadfile2', value241f3, 'f241f3-' + value241f3.name);
    }

    if (pathValue2421f1 !== '') {
      form24Data.append(
        'uploadfile2',
        value2421f1,
        'f2421f1-' + value2421f1.name
      );
    }
    if (pathValue2421f2 !== '') {
      form24Data.append(
        'uploadfile2',
        value2421f2,
        'f2421f2-' + value2421f2.name
      );
    }

    if (pathValue2431f1 !== '') {
      form24Data.append(
        'uploadfile2',
        value2431f1,
        'f2431f1-' + value2431f1.name
      );
    }
    if (pathValue2431f2 !== '') {
      form24Data.append(
        'uploadfile2',
        value2431f2,
        'f2431f2-' + value2431f2.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form24Data,
    };
    fetch(
      resources.APPLICATION_URL+'criteria2upload',
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

  return (
    <div className="c24-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c24x-colorIndicator-container">
        <p className="c24x-QlcolorIndicator-circle-style"></p>
        <span className="c24x-colorIndicator-span-style">Qualitative</span>
        <p className="c24x-QtcolorIndicator-circle-style"></p>
        <span className="c24x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c24x-weightage-heading-style">
            Key Indicator Weightage: 50
          </h1>
        </div>
      </div>

      {/* Key Indicator: 2.4.1 */}
      <div className="c24x-eachInputField-container">
        <div className="c24x-weightage-container">
          <h1 className="c24x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c24x-container">
            <div className="c24x-heading_Help-container">
              <h1 className="c24x-heading-style">
                <span className="c24x-span-style">2.4.1: </span>
                Percentage of full time teachers against sanctioned posts during the last five years
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
                title='formula'
                ><h1>(Total number of full time teachers with Ph.D./D.Sc./ D.Litt./L.L.D during the last five years)/(Total Number of full time teachers during the last five year) *100</h1></HelpButton>
            </div>
            <div className="c24x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus241(!responseButtonStatus241);
                  onClickingViewResponse241();
                }}
                className="c24x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus241 ? (
                <p className="c24x-responseResult-style">{responseValue241}</p>
              ) : null}
            </div>
          </div>
          <div className="c24xx-container">
            <h1 className="c24x-heading-style">
              <span className="c24x-span-style">2.4.1.1 </span>
              Number of sanctioned posts year wise during the last five years

            </h1>
            <table className="c24x-Qt-table-style">
              <tr>
                <th className="c24x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue241t1(e.target.value)}
                      id="241-t1"
                      className="c24x-input-style"
                      type="text"
                      value={value241t1}
                    />
                    {value241t1 === '' ? (
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
                      onChange={(e) => setValue241t2(e.target.value)}
                      id="241-t2"
                      className="c24x-input-style"
                      type="text"
                      value={value241t2}
                    />
                    {value241t2 === '' ? (
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
                      onChange={(e) => setValue241t3(e.target.value)}
                      id="241-t3"
                      className="c24x-input-style"
                      type="text"
                      value={value241t3}
                    />
                    {value241t3 === '' ? (
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
                      onChange={(e) => setValue241t4(e.target.value)}
                      id="241-t4"
                      className="c24x-input-style"
                      type="text"
                      value={value241t4}
                    />
                    {value241t4 === '' ? (
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
                        setValue241t5(e.target.value);
                        onClickingViewResponse241();
                      }}
                      id="241-t5"
                      className="c24x-input-style"
                      type="text"
                      value={value241t5}
                    />
                    {value241t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c24x-horizontalTable-heading-style">Number</th>
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
                        setValue241t6(e.target.value);
                        onClickingViewResponse241();
                      }}
                      id="241-t6"
                      className="c24x-input-style"
                      type="text"
                      value={value241t6}
                    />
                    {value241t6 === '' ? (
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
                        setValue241t7(e.target.value);
                        onClickingViewResponse241();
                      }}
                      id="241-t7"
                      className="c24x-input-style"
                      type="text"
                      value={value241t7}
                    />
                    {value241t7 === '' ? (
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
                        setValue241t8(e.target.value);
                        onClickingViewResponse241();
                      }}
                      id="241-t8"
                      className="c24x-input-style"
                      type="text"
                      value={value241t8}
                    />
                    {value241t8 === '' ? (
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
                        setValue241t9(e.target.value);
                        onClickingViewResponse241();
                      }}
                      id="241-t9"
                      className="c24x-input-style"
                      type="text"
                      value={value241t9}
                    />
                    {value241t9 === '' ? (
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
                        setValue241t10(e.target.value);
                        onClickingViewResponse241();
                      }}
                      id="241-t10"
                      className="c24x-input-style"
                      type="text"
                      value={value241t10}
                    />
                    {value241t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            {/* <h1 className="c24x-heading-style">
              <span className="c24x-span-style">B. </span>
              Number of Sanctioned Posts
            </h1> */}
            {/* <table className="c24x-Qt-table-style">
              <tr>
                <th className="c24x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue241t11(e.target.value)}
                      id="241-t11"
                      className="c24x-input-style"
                      type="text"
                      value={value241t11}
                    />
                    {value241t11 === '' ? (
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
                      onChange={(e) => setValue241t12(e.target.value)}
                      id="241-t12"
                      className="c24x-input-style"
                      type="text"
                      value={value241t12}
                    />
                    {value241t12 === '' ? (
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
                      onChange={(e) => setValue241t13(e.target.value)}
                      id="241-t13"
                      className="c24x-input-style"
                      type="text"
                      value={value241t13}
                    />
                    {value241t13 === '' ? (
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
                      onChange={(e) => setValue241t14(e.target.value)}
                      id="241-t14"
                      className="c24x-input-style"
                      type="text"
                      value={value241t14}
                    />
                    {value241t14 === '' ? (
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
                      onChange={(e) => setValue241t15(e.target.value)}
                      id="241-t15"
                      className="c24x-input-style"
                      type="text"
                      value={value241t15}
                    />
                    {value241t15 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c24x-horizontalTable-heading-style">Number</th>
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
                        setValue241t16(e.target.value);
                        onClickingViewResponse241();
                      }}
                      id="241-t16"
                      className="c24x-input-style"
                      type="text"
                      value={value241t16}
                    />
                    {value241t16 === '' ? (
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
                        setValue241t17(e.target.value);
                        onClickingViewResponse241();
                      }}
                      id="241-t17"
                      className="c24x-input-style"
                      type="text"
                      value={value241t17}
                    />
                    {value241t17 === '' ? (
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
                        setValue241t18(e.target.value);
                        onClickingViewResponse241();
                      }}
                      id="241-t18"
                      className="c24x-input-style"
                      type="text"
                      value={value241t18}
                    />
                    {value241t18 === '' ? (
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
                        setValue241t19(e.target.value);
                        onClickingViewResponse241();
                      }}
                      id="241-t19"
                      className="c24x-input-style"
                      type="text"
                      value={value241t19}
                    />
                    {value241t19 === '' ? (
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
                        setValue241t20(e.target.value);
                        onClickingViewResponse241();
                      }}
                      id="241-t20"
                      className="c24x-input-style"
                      type="text"
                      value={value241t20}
                    />
                    {value241t20 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> */}
            <table className="c24x-table-style">
              <tr>
                <th className="c24x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c24x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c24x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c24x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>
                  Year wise full time teachers and sanctioned posts for 5
                  years(Data Template)
                </td>
                <td> <a href={downloadFile("au2.4.1.xlsx")} target="_blank">View Template</a></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue241f1(e.target.files[0]);
                      setPathValue241f1(e.target.value);
                    }}
                    id="241-f1"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue241f1 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue241f1("");
                      document.getElementById("241-f1").value="" }} >
                       Reset                     
                    </button>

                    </div>
                  )}
                  <a href={downloadFile(value241f1)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                 <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue241f1(e.target.files[0]);
                    setPathValue241f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue241f1}
              {pathValue241f1 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue241f1("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td><a href={downloadFile("au2.4.1.xlsx")} target="_blank"> view Template</a></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue241f2(e.target.files[0]);
                      setPathValue241f2(e.target.value);
                    }}
                    id="241-f2"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue241f2 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue241f2("");
                      document.getElementById("241-f2").value="" }} >
                       Reset                     
                    </button>

                    </div>
                  )}
                  <a href={downloadFile(value241f2)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                 <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue241f2(e.target.files[0]);
                    setPathValue241f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue241f2}
              {pathValue241f2 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue241f2("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List of the faculty members authenticated by the Head of HEI{' '}
                </td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue241f3(e.target.files[0]);
                      setPathValue241f3(e.target.value);
                    }}
                    id="241-f3"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue241f3 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue241f3("");
                      document.getElementById("241-f3").value="" }} >
                       Reset                     
                    </button>

                    </div>
                  )}
                   <a href={downloadFile(value241f3)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> 
                </td> */}
                 <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue241f3(e.target.files[0]);
                      setPathValue241f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue241f3}
              {pathValue241f3 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue241f3("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 2.4.2 */}
      <div className="c24x-eachInputField-container">
        <div className="c24x-weightage-container">
          <h1 className="c24x-weightage-heading-style">Weightage: 25</h1>
        </div>
        <form>
          <div className="c24x-container">
            <div className="c24x-heading_Help-container">
              <h1 className="c24x-heading-style">
                <span className="c24x-span-style">2.4.2: </span>
                Average percentage of full time teachers with Ph. D. / D.M. /
                M.Ch. / D.N.B Superspeciality / D.Sc. / D.Litt. during the last
                five years (consider only highest degree for count).
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
                title='percentage'
                ><h1>(Total number of full time teachers with Ph.D./D.Sc./ D.Litt./L.L.D during the last five years)*(Total Number of full time teachers during the last five years) * 100</h1></HelpButton>
            </div>
            <div className="c24x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus242(!responseButtonStatus242);
                  onClickingViewResponse242();
                }}
                className="c24x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus242 ? (
                <p className="c24x-responseResult-style">{responseValue242}</p>
              ) : null}
            </div>
          </div>
          <div className="c24xx-container">
            <h1 className="c24xx-Heading-style">
              <span className="c24xx-span-style">2.4.2.1: </span>
               Number of full time teachers with Ph.D./D.Sc. / D.Litt./ 
L.L.D year wise during last five years

            </h1>
            {/* <h1 className="c24xx-Heading-style">
              <span className="c24xx-span-style">A: </span>
              Number of full time teachers with Ph.D./D.M/M.Ch./D.N.B
              Superspeciality/D.Sc./D.Lit.
            </h1> */}
            <table className="c24x-Qt-table-style">
              <tr>
                <th className="c24x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue2421t1(e.target.value)}
                      id="2421-t1"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t1}
                    />
                    {value2421t1 === '' ? (
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
                      onChange={(e) => setValue2421t2(e.target.value)}
                      id="2421-t2"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t2}
                    />
                    {value2421t2 === '' ? (
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
                      onChange={(e) => setValue2421t3(e.target.value)}
                      id="2421-t3"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t3}
                    />
                    {value2421t3 === '' ? (
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
                      onChange={(e) => setValue2421t4(e.target.value)}
                      id="2421-t4"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t4}
                    />
                    {value2421t4 === '' ? (
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
                      onChange={(e) => setValue2421t5(e.target.value)}
                      id="2421-t5"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t5}
                    />
                    {value2421t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c24x-horizontalTable-heading-style">Number</th>
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
                        setValue2421t6(e.target.value);
                        onClickingViewResponse242();
                      }}
                      id="2421-t6"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t6}
                    />
                    {value2421t6 === '' ? (
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
                        setValue2421t7(e.target.value);
                        onClickingViewResponse242();
                      }}
                      id="2421-t7"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t7}
                    />
                    {value2421t7 === '' ? (
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
                        setValue2421t8(e.target.value);
                        onClickingViewResponse242();
                      }}
                      id="2421-t8"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t8}
                    />
                    {value2421t8 === '' ? (
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
                        setValue2421t9(e.target.value);
                        onClickingViewResponse242();
                      }}
                      id="2421-t9"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t9}
                    />
                    {value2421t9 === '' ? (
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
                        setValue2421t10(e.target.value);
                        onClickingViewResponse242();
                      }}
                      id="2421-t10"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t10}
                    />
                    {value2421t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            {/* <h1 className="c24xx-Heading-style">
              <span className="c24xx-span-style">B: </span>
              Number of full time teachers
            </h1>
            <table className="c24x-Qt-table-style">
              <tr>
                <th className="c24x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue2421t11(e.target.value)}
                      id="2421-t11"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t11}
                    />
                    {value2421t11 === '' ? (
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
                      onChange={(e) => setValue2421t12(e.target.value)}
                      id="2421-t12"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t12}
                    />
                    {value2421t12 === '' ? (
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
                      onChange={(e) => setValue2421t13(e.target.value)}
                      id="2421-t13"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t13}
                    />
                    {value2421t13 === '' ? (
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
                      onChange={(e) => setValue2421t14(e.target.value)}
                      id="2421-t14"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t14}
                    />
                    {value2421t14 === '' ? (
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
                      onChange={(e) => setValue2421t15(e.target.value)}
                      id="2421-t15"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t15}
                    />
                    {value2421t15 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c24x-horizontalTable-heading-style">Number</th>
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
                        setValue2421t16(e.target.value);
                        onClickingViewResponse242();
                      }}
                      id="2421-t16"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t16}
                    />
                    {value2421t16 === '' ? (
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
                        setValue2421t17(e.target.value);
                        onClickingViewResponse242();
                      }}
                      id="2421-t17"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t17}
                    />
                    {value2421t17 === '' ? (
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
                        setValue2421t18(e.target.value);
                        onClickingViewResponse242();
                      }}
                      id="2421-t18"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t18}
                    />
                    {value2421t18 === '' ? (
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
                        setValue2421t19(e.target.value);
                        onClickingViewResponse242();
                      }}
                      id="2421-t19"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t19}
                    />
                    {value2421t19 === '' ? (
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
                        setValue2421t20(e.target.value);
                        onClickingViewResponse242();
                      }}
                      id="2421-t20"
                      className="c24x-input-style"
                      type="text"
                      value={value2421t20}
                    />
                    {value2421t20 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table> */}
            <h1 className="c24xx-Heading-style">
              <p>
                Data Requirement for last five years: (As per Data Template)
                <br />
                • Number of full time teachers with PhD./ D.M. / M.Ch. / D.N.B
                Superspeciality / D.Sc. / D.Litt.
                <br />• Total number of full time teachers
              </p>
            </h1>
            <table className="c24x-table-style">
              <tr>
                <th className="c24x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c24x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c24x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c24x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any Additional Information</td>
                <td></td>
                <td>
                 {/* <input
                    onChange={(e) => {
                      setValue2421f1(e.target.files[0]);
                      setPathValue2421f1(e.target.value);
                    }}
                    id="2421-f1"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue2421f1 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2421f1("");
                      document.getElementById("2421-f1").value="" }} >
                       Reset                     
                    </button>

                    </div>
                  )}
                  <a href={downloadFile(value2421f1)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                 <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue2421f1(e.target.files[0]);
                    setPathValue2421f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue2421f1}
              {pathValue2421f1 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue2421f1("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>List of number of full time teachers with  PhD./ D.M. / M.Ch. / D.N.B Super specialty / D.Sc. / D.Litt. and number of full time teachers for 5 years (Data Template)</td>
                <td> <a href={downloadFile("au2.4.2.xlsx")} target="_blank"> view Template</a></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue2421f2(e.target.files[0]);
                      setPathValue2421f2(e.target.value);
                    }}
                    id="2421-f2"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue2421f2 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2421f2("");
                      document.getElementById("2421-f2").value="" }} >
                       Reset                     
                    </button>

                    </div>
                  )}
                  <a href={downloadFile(value2421f2)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                </td> */}
                 <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue2421f2(e.target.files[0]);
                  setPathValue2421f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue2421f2}
              {pathValue2421f2 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue2421f2("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 2.4.3 */}
      <div className="c24x-eachInputField-container">
        <div className="c24x-weightage-container">
          <h1 className="c24x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c24x-container">
            <div className="c24x-heading_Help-container">
              <h1 className="c24x-heading-style">
                <span className="c24x-span-style">2.4.3: </span>
                Average teaching experience of full time teachers (Data to be 
provided only for the latest completed academic year, in number of 
years)

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
                ><h1>(Sum of total teaching experience of full time teachers )/
                  (Number of full time teachers during the latest completed academic year)</h1></HelpButton>
            </div>
            <div className="c24x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus243(!responseButtonStatus243);
                  onClickingViewResponse243();
                }}
                className="c24x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus243 ? (
                <p className="c24x-responseResult-style">{responseValue243}</p>
              ) : null}
            </div>
          </div>
          <div className="c24xx-container">
            <h1 className="c24xx-Heading-style">
              <span className="c24xx-span-style">2.4.3.1: </span>
              Total teaching experience of full-time teachers as of latest completed academic year
            </h1>
            <h1 className="c24xx-Heading-style">
              <span className="c24xx-span-style">A: 
              Sum of total experience of full time teachers
           
            <input
              onChange={(e) => setValue2431t1(e.target.value)}
              id="2431-t1"
              style={{width:"25%",  marginLeft: '15%' }}
              type="number"
              value={value2431t1}
            />
            </span>
            </h1>
            <h1 className="c24xx-Heading-style">
              <span className="c24xx-span-style">B:
              Number of full time teachers
            <input
              onChange={(e) => setValue2431t2(e.target.value)}
              id="2431-t2"
              style={{width:"25%", marginLeft: '28.8%' }}
              type="number"
              value={value2431t2}
            />
            </span>
            </h1>
            <table className="c24x-table-style">
              <tr>
                <th className="c24x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c24x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c24x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c24x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information </td>
                <td><a href={downloadFile("au2.4.3.xlsx")} target="_blank"> view Template</a></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue2431f1(e.target.files[0]);
                      setPathValue2431f1(e.target.value);
                    }}
                    id="2431-f1"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue2431f1 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2431f1("");
                      document.getElementById("2431-f1").value="" }} >
                       Reset                     
                    </button>

                    </div>
                  )}
                  <a href={downloadFile(value2431f1)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
                  </td>*/}
                   <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue2431f1(e.target.files[0]);
                    setPathValue2431f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue2431f1}
              {pathValue2431f1 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue2431f1("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>List of Teachers including their PAN, designation, dept and experience details(Data Template as of 2.4.1)</td>
                <a  href={downloadFile("au2.4.3.xlsx")} target="_blank">View Template</a>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue2431f2(e.target.files[0]);
                      setPathValue2431f2(e.target.value);
                    }}
                    id="2431-f2"
                    className="c24-fileButton-style"
                    type="file"
                  />
                  {pathValue2431f2 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                        View File
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2431f2("");
                      document.getElementById("2431-f2").value="" }} >
                       Reset                     
                    </button>

                    </div>
                  )}
                   <a href={downloadFile(value2431f2)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> 
                </td> */}
                 <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue2431f2(e.target.files[0]);
                      setPathValue2431f2(e.target.value)
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue2431f2}
              {pathValue2431f2 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue2431f2("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
          {/* 2.4.4 */}
          <div className="c24x-eachInputField-container">
        <div className="c24x-weightage-container">
          <h1 className="c24x-weightage-heading-style">Weightage: 5</h1>
          <form>
          <div className="c24xx-container">
            <h1 className="c24xx-Heading-style">
              <span className="c24xx-span-style">2.4.4: </span>
              Average teaching experience of full time teachers in the same 
institution (Data to be provided only for the latest completed 
academic year, in number of years)
            </h1>
            <h1 className="c24xx-Heading-style">
              <span className="c24xx-span-style">2.4.4.1: </span>
              Total teaching experience of full time teachers in the same 
institution:
               <input
                onChange={(e) => {
                  setValue3231t1(e.target.value);
                  onClickingViewResponse323();
                }}/>

            </h1>
            <table className="c24x-table-style">
              <tr>
                <th className="c24x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c24x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c24x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c24x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Any additional information </td>
                <td><a href={downloadFile("au2.4.4.xlsx")} target="_blank"> view Template</a></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue2431f1(e.target.files[0]);
                      setPathValue2431f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2431-f1"
                    className="c24-fileButton-style"
                    type="file"
                    accept='.pdf'
                  />
                  {pathValue2431f1 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2431f1("");
                      document.getElementById("2431-f1").value="" }} >
                      Reset
                    </button>

                    </div>
                  )}
                </td> */}
                 <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue2431f1(e.target.files[0]);
                      setPathValue2431f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue2431f1}
              {pathValue2431f1 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue2431f1("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>List of Teachers including their PAN, designation, dept and experience details(Data Template as of 2.4.1)</td>
                <a href={downloadFile("au2.4.4.xlsx")} target="_blank">View Template</a>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue2431f2(e.target.files[0]);
                      setPathValue2431f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="2431-f2"
                    className="c24-fileButton-style"
                    type="file"
                    accept='.pdf'
                  />
                  {pathValue2431f2 === '' ? null : (
                    <div className="c24-fileButtons-container">
                      <button className="c24-viewFileButton-style">
                         <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>

                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue2431f2("");
                      document.getElementById("2431-f2").value="" }} >
                      Reset
                    </button>

                    </div>
                  )}
                </td> */}
                 <Button variant="contained" component="label">
                File Upload
                <input
                  className="input-text"
                
                  multiple
                  type="file"
                id="iiqa31f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue2431f2(e.target.files[0]);
                    setPathValue2431f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue2431f2}
              {pathValue2431f2 === "" ? null : (
                <div className="c21-fileButtons-container">
                  <button
                    className="c21-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc111f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c11-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue2431f2("");
                      document.getElementById("iiqa31f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
                <td className="c24x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
            </div>
        </form>
      </div>
      <div className="c24x-button-container">
        <button onClick={onClickingSave} className="c24x-button-style">
          Save
        </button>
      </div>
    </div>
        </form>
      </div>
      <div className="c24x-button-container">
        <button onClick={onClickingSave} className="c24x-button-style">
          Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria24;
