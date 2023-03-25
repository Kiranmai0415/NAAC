import React, { useState,useEffect } from 'react';
import './c34-style.css';
import { toast } from "react-toastify";
import AuthService from '../../../../Pages/Users/services/auth.service';
import { Button } from '@mui/material';
import { resources } from '../../../../appConstants';
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

function Help341(props) {
  return props.isHelp341Clicked ? (
    <div className="c34x-help-mainContainer">
      <div className="c34x-help-subContainer">
        <h1 className="c34x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c34x-help-para-style">
        (Opt any one)
        </p>
        <button
          className="c34x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp341Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help342(props) {
  return props.isHelp342Clicked ? (
    <div className="c34x-help-mainContainer">
      <div className="c34x-help-subContainer">
        <h1 className="c34x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c34x-help-para-style">
        Data Requirements: (As per Data Template of 2.4.4 )<br/>
1.Name of the Awardee with contact details<br/>
2.Name of the Awarding Agency<br/>
3.Year of Award<br/>
4.Details of the Incentive
        </p>
        <button
          className="c34x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp342Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help343(props) {
  return props.isHelp343Clicked ? (
    <div className="c34x-help-mainContainer">
      <div className="c34x-help-subContainer">
        <h1 className="c34x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c34x-help-para-style">
        Data Requirements for the last five years: (As per Data Template)<br/>
1.Name of the Patent published/awarded<br/>
2.Patent Number<br/>
3.Year of the Award<br/>
        </p>
        <button
          className="c34x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp343Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help344(props) {
  return props.isHelp344Clicked ? (
    <div className="c34x-help-mainContainer">
      <div className="c34x-help-subContainer">
        <h1 className="c34x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c34x-help-para-style">
        Number of Ph.Ds awarded per teacher during the last five years
          <span style={{ fontWeight: 'bold' }}> / </span>
          Number of teachers recognized as guides during the last five years
        </p>
        <button
          className="c34x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp344Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help345(props) {
  return props.isHelp345Clicked ? (
    <div className="c34x-help-mainContainer">
      <div className="c34x-help-subContainer">
        <h1 className="c34x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c34x-help-para-style">
          ToNumber of publications in UGC notified journals during last five years
          <span style={{ fontWeight: 'bold' }}> / </span>
          Average number of fulltime teachers during last five years
        </p>
        <button
          className="c34x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp345Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help346(props) {
  return props.isHelp346Clicked ? (
    <div className="c34x-help-mainContainer">
      <div className="c34x-help-subContainer">
        <h1 className="c34x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c34x-help-para-style">
          <span style={{ fontWeight: 'bold' }}> ( </span>
          Total number of books and chapters in edited volumes / books
published, and papers in national/international conference-proceedings
year- wise during the last five years
          <span style={{ fontWeight: 'bold' }}> / </span>
          Average number of fulltime teachers during last five years
          <span style={{ fontWeight: 'bold' }}> ) </span>
        </p>
        <button
          className="c34x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp346Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help347(props) {
  return props.isHelp347Clicked ? (
    <div className="c34x-help-mainContainer">
      <div className="c34x-help-subContainer">
        <h1 className="c34x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c34x-help-para-style">
        Data Requirements: (As per Data Template)<br/>
1. Name of the teacher<br/>
2.Name of the module<br/>
3.Platform on which the module is developed<br/>
4.Date of launching the e-content<br/>
5.Number of platforms on which e-content has been developed by
teachers
        </p>
        <button
          className="c34x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp347Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help348(props) {
  return props.isHelp348Clicked ? (
    <div className="c34x-help-mainContainer">
      <div className="c34x-help-subContainer">
        <h1 className="c34x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c34x-help-para-style">
          <span style={{ fontWeight: 'bold' }}> (0.5 *</span>
          Total number of Citations in Scopus in 5 years
          <span style={{ fontWeight: 'bold' }}>) + (0.5*</span> Total number of Citations
        in Web of Science in 5 years
          <span style={{ fontWeight: 'bold' }}>) / (0.5 *</span>Total number of
        Publications in Scopus in 5 years
          <span style={{ fontWeight: 'bold' }}>) + (0.5 *</span> Total number of
        Publications in Web of Science in 5 years
          <span style={{ fontWeight: 'bold' }}> ) </span>
        </p>
        <button
          className="c34x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp348Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Help349(props) {
  return props.isHelp349Clicked ? (
    <div className="c34x-help-mainContainer">
      <div className="c34x-help-subContainer">
        <h1 className="c34x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c34x-help-para-style">
          <span style={{ fontWeight: 'bold' }}> ( </span>
          h-index of Scopus during the last five years
          <span style={{ fontWeight: 'bold' }}> + </span>
          h-index of Web of Science during the last five years
          <span style={{ fontWeight: 'bold' }}> / </span>2
        </p>
        <button
          className="c34x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp349Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Criteria34() {
  // getfile data with API
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
 //help buttom
  const [isOpen, setIsopen] = useState(false)
  const [isOpen6, setIsopen6] = useState(false)
  const [isOpen3, setIsopen3] = useState(false)
  const [isOpen4, setIsopen4] = useState(false)
  const [isOpen5, setIsopen5] = useState(false)
  const [isOpen2,setIsopen2] = useState(false)
  const handleHelpOpen = (e) => {
    e.preventDefault(),
    setIsopen(true)
  }
  const handleHelpClose = () => {
    setIsopen(false)
  }
  const handleHelpOpen9 = (e) => {
    e.preventDefault(),
    setIsopen9(true)
  }
  const handleHelpClose9 = () => {
    setIsopen9(false)
  }
  const handleHelpOpen6 = (e) => {
    e.preventDefault(),
    setIsopen6(true)
  }
  const handleHelpClose6 = () => {
    setIsopen6(false)
  }
  const handleHelpOpen3 = (e) => {
    e.preventDefault(),
    setIsopen(true)
  }
  const handleHelpClose3 = () => {
    setIsopen3(false)
  }
  const handleHelpOpen5 = (e) => {
    e.preventDefault(),
    setIsopen3(true)
  }
  const handleHelpClose4 = () => {
    setIsopen4(false)
  }
  const handleHelpOpen4 = (e) => {
    e.preventDefault(),
    setIsopen4(true)
  }
  const handleHelpClose5 = () => {
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
  const [value341t1, setValue341t1] = useState();

  const [value341f1, setValue341f1] = useState('');
  const [value341f2, setValue341f2] = useState('');
  const [pathValue341f2, setPathValue341f2] = useState('');
  const [pathValue341f1, setPathValue341f1] = useState('');
  const [responseButtonStatus341, setResponseButtonStatus341] = useState(false);
  const [responseValue341, setResponseValue341] = useState('');
  const [help341Status, setHelp341Status] = useState(false);

  const [value342t1, setValue342t1] = useState();
  const [value342f1, setValue342f1] = useState('');
  const [pathValue342f1, setPathValue342f1] = useState('');
  const [value342f2, setValue342f2] = useState('');
  const [pathValue342f2, setPathValue342f2] = useState('');
  const [responseButtonStatus342, setResponseButtonStatus342] = useState(false);
  const [responseValue342, setResponseValue342] = useState('');
  const [help342Status, setHelp342Status] = useState(false);

  const [value3431t1, setValue3431t1] = useState();
  const [value3431t2, setValue3431t2] = useState();
  const [value3431t3, setValue3431t3] = useState();
  const [value3431t4, setValue3431t4] = useState();
  const [value3431t5, setValue3431t5] = useState();
  const [value3431t6, setValue3431t6] = useState();
  const [value3431t7, setValue3431t7] = useState();
  const [value3431t8, setValue3431t8] = useState();
  const [value3431t9, setValue3431t9] = useState();
  const [value3431t10, setValue3431t10] = useState();
  const [value3431f1, setValue3431f1] = useState('');
  const [pathValue3431f1, setPathValue3431f1] = useState('');
  const [value3431f2, setValue3431f2] = useState('');
  const [pathValue3431f2, setPathValue3431f2] = useState('');
  const [responseButtonStatus343, setResponseButtonStatus343] = useState(false);
  const [responseValue343, setResponseValue343] = useState('');
  const [help343Status, setHelp343Status] = useState(false);

  const [value3441t1, setValue3441t1] = useState();
  const [value3441t2, setValue3441t2] = useState();
  const [value3441t3, setValue3441t3] = useState();
  const [value3441t4, setValue3441t4] = useState();
  const [value3441t5, setValue3441t5] = useState();
  const [value3441t6, setValue3441t6] = useState();
  const [value3441t7, setValue3441t7] = useState();
  const [value3441t8, setValue3441t8] = useState();
  const [value3441t9, setValue3441t9] = useState();
  const [value3441t10, setValue3441t10] = useState();
  const [value3441t11, setValue3441t11] = useState();
  const [value3441t12, setValue3441t12] = useState();
  const [value3441t13, setValue3441t13] = useState();
  const [value3441t14, setValue3441t14] = useState();
  const [value3441t15, setValue3441t15] = useState();
  const [value3441t16, setValue3441t16] = useState();
  const [value3441t17, setValue3441t17] = useState();
  const [value3441t18, setValue3441t18] = useState();
  const [value3441t19, setValue3441t19] = useState();
  const [value3441t20, setValue3441t20] = useState();
  const [value3441f1, setValue3441f1] = useState('');
  const [pathValue3441f1, setPathValue3441f1] = useState('');
  const [value3441f2, setValue3441f2] = useState('');
  const [pathValue3441f2, setPathValue3441f2] = useState('');
  const [value3441f3, setValue3441f3] = useState('');
  const [pathValue3441f3, setPathValue3441f3] = useState('');
  const [responseButtonStatus344, setResponseButtonStatus344] = useState(false);
  const [responseValue344, setResponseValue344] = useState('');
  const [help344Status, setHelp344Status] = useState(false);

  const [value3451t1, setValue3451t1] = useState();
  const [value3451t2, setValue3451t2] = useState();
  const [value3451t3, setValue3451t3] = useState();
  const [value3451t4, setValue3451t4] = useState();
  const [value3451t5, setValue3451t5] = useState();
  const [value3451t6, setValue3451t6] = useState();
  const [value3451t7, setValue3451t7] = useState();
  const [value3451t8, setValue3451t8] = useState();
  const [value3451t9, setValue3451t9] = useState();
  const [value3451t10, setValue3451t10] = useState();
  const [value3451t11, setValue3451t11] = useState();
  const [value3451t12, setValue3451t12] = useState();
  const [value3451t13, setValue3451t13] = useState('');
  const [value3451t14, setValue3451t14] = useState('');
  const [value3451t15, setValue3451t15] = useState();
  const [value3451t16, setValue3451t16] = useState();
  const [value3451t17, setValue3451t17] = useState();
  const [value3451t18, setValue3451t18] = useState();
  const [value3451t19, setValue3451t19] = useState();
  const [value3451t20, setValue3451t20] = useState();

  const [value3451f1, setValue3451f1] = useState('');
  const [pathValue3451f1, setPathValue3451f1] = useState('');
  const [value3451f2, setValue3451f2] = useState('');
  const [pathValue3451f2, setPathValue3451f2] = useState('');
  const [responseButtonStatus345, setResponseButtonStatus345] = useState(false);
  const [responseValue345, setResponseValue345] = useState('');
  const [help345Status, setHelp345Status] = useState(false);

  const [value3461t1, setValue3461t1] = useState();
  const [value3461t2, setValue3461t2] = useState();
  const [value3461t3, setValue3461t3] = useState();
  const [value3461t4, setValue3461t4] = useState();
  const [value3461t5, setValue3461t5] = useState();
  const [value3461t6, setValue3461t6] = useState();
  const [value3461t7, setValue3461t7] = useState();
  const [value3461t8, setValue3461t8] = useState();
  const [value3461t9, setValue3461t9] = useState();
  const [value3461t10, setValue3461t10] = useState();
  const [value3461t11, setValue3461t11] = useState();
  const [value3461t12, setValue3461t12] = useState();
  const [value3461t13, setValue3461t13] = useState();
  const [value3461t14, setValue3461t14] = useState();
  const [value3461t15, setValue3461t15] = useState();
  const [value3461t16, setValue3461t16] = useState();
  const [value3461t17, setValue3461t17] = useState();
  const [value3461t18, setValue3461t18] = useState();
  const [value3461t19, setValue3461t19] = useState();
  const [value3461t20, setValue3461t20] = useState();
  const [value3461f1, setValue3461f1] = useState('');
  const [pathValue3461f1, setPathValue3461f1] = useState('');
  const [value3461f2, setValue3461f2] = useState('');
  const [pathValue3461f2, setPathValue3461f2] = useState('');
  const [responseButtonStatus346, setResponseButtonStatus346] = useState(false);
  const [responseValue346, setResponseValue346] = useState('');
  const [help346Status, setHelp346Status] = useState(false);

  const [value347t1, setValue347t1] = useState();
  const [value347f1, setValue347f1] = useState('');
  const [pathValue347f1, setPathValue347f1] = useState('');
  const [value347f2, setValue347f2] = useState('');
  const [pathValue347f2, setPathValue347f2] = useState('');
  const [responseButtonStatus347, setResponseButtonStatus347] = useState(false);
  const [responseValue347, setResponseValue347] = useState('');
  const [help347Status, setHelp347Status] = useState(false);

  const [value3481t1, setValue3481t1] = useState();
  const [value3481t2, setValue3481t2] = useState();
  const [value3482t1, setValue3482t1] = useState();
  const [value3482t2, setValue3482t2] = useState();
  const [value3482f1, setValue3482f1] = useState('');
  const [pathValue3482f1, setPathValue3482f1] = useState('');
  const [value3482f2, setValue3482f2] = useState('');
  const [pathValue3482f2, setPathValue3482f2] = useState('');
  const [responseButtonStatus348, setResponseButtonStatus348] = useState(false);
  const [responseValue348, setResponseValue348] = useState('');
  const [help348Status, setHelp348Status] = useState(false);

  const [value3491t1, setValue3491t1] = useState();
  const [value3491t2, setValue3491t2] = useState();
  const [value3491f1, setValue3491f1] = useState('');
  const [pathValue3491f1, setPathValue3491f1] = useState('');
  const [value3491f2, setValue3491f2] = useState('');
  const [pathValue3491f2, setPathValue3491f2] = useState('');
  const [responseButtonStatus349, setResponseButtonStatus349] = useState(false);
  const [responseValue349, setResponseValue349] = useState('');
  const [help349Status, setHelp349Status] = useState(false);

  const [pathValue341f3, setPathValue341f3] = useState();
  const [pathValue341f4, setPathValue341f4] = useState();
  const [pathValue3431f3, setPathValue3431f3] = useState();
  const [filePreviewSrc341f1, setFilePreviewSrc341f1] = useState();
  const [filePreviewSrc341f2, setFilePreviewSrc341f2] = useState();
  const [filePreviewSrc341f3, setFilePreviewSrc341f3] = useState();
  const [filePreviewSrc341f4, setFilePreviewSrc341f4] = useState();
  const [filePreviewSrc344f4, setFilePreviewSrc344f4] = useState();
  const [filePreviewSrc345f3, setFilePreviewSrc345f3] = useState();
  const [pathValue3441f4, setPathValue3441f4] = useState();
  const [pathValue3451f3, setPathValue3451f3] = useState();





  
  
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
    () => fetch(resources.APPLICATION_URL+'criteria3getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));
          setValue341t1(data[0].criteria34Ql[0] ? data[0].criteria34Ql[0].input341t1 : "");
          setValue3491t1(data[0].criteria34Ql[0] ? data[0].criteria34Ql[0].input3491t1 : "");
          setValue3491t2(data[0].criteria34Ql[0] ? data[0].criteria34Ql[0].input3491t2 : "");

          setValue342t1(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input342t1 : "");
          setValue347t1(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input347t1 : "");
          setValue3481t1(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input3481t1 : "");
          setValue3481t2(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input3481t2 : "");
          setValue3482t1(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input3482t1 : "");
          setValue3482t2(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input3482t2 : "");
          

          // setResponseValue111(data[0].criteria1FieldInfoQl[1].response111);
          // setResponseValue112(data[0].criteria1FieldInfoQn[2].response112);
          // setResponseValue113(data[0].criteria1FieldInfoQn[3].response113);

          setValue3431t1(data[0].universityYearTable3431[0] ? data[0].universityYearTable3431[0].input3431y : "");
          setValue3431t2(data[0].universityYearTable3431[1] ? data[0].universityYearTable3431[1].input3431y : "");
          setValue3431t3(data[0].universityYearTable3431[2] ? data[0].universityYearTable3431[2].input3431y : "");
          setValue3431t4(data[0].universityYearTable3431[3] ? data[0].universityYearTable3431[3].input3431y : "");
          setValue3431t5(data[0].universityYearTable3431[4] ? data[0].universityYearTable3431[4].input3431y : "");
          setValue3431t6(data[0].universityYearTable3431[0] ? data[0].universityYearTable3431[0].input3431v : "");
          setValue3431t7(data[0].universityYearTable3431[1] ? data[0].universityYearTable3431[1].input3431v : "");
          setValue3431t8(data[0].universityYearTable3431[2] ? data[0].universityYearTable3431[2].input3431v :"");
          setValue3431t9(data[0].universityYearTable3431[3] ? data[0].universityYearTable3431[3].input3431v : "");
          setValue3431t10(data[0].universityYearTable3431[4] ? data[0].universityYearTable3431[4].input3431v : "");

          setValue3441t1(data[0].yearTable3441[0] ? data[0].yearTable3441[0].input3441y : "");
          setValue3441t2(data[0].yearTable3441[1] ? data[0].yearTable3441[1].input3441y : "");
          setValue3441t3(data[0].yearTable3441[2] ? data[0].yearTable3441[2].input3441y : "");
          setValue3441t4(data[0].yearTable3441[3] ? data[0].yearTable3441[3].input3441y : "");
          setValue3441t5(data[0].yearTable3441[4] ? data[0].yearTable3441[4].input3441y : "");
          setValue3441t6(data[0].yearTable3441[0] ? data[0].yearTable3441[0].input3441v : "");
          setValue3441t7(data[0].yearTable3441[1] ? data[0].yearTable3441[1].input3441v : "");
          setValue3441t8(data[0].yearTable3441[2] ? data[0].yearTable3441[2].input3441v : "");
          setValue3441t9(data[0].yearTable3441[3] ? data[0].yearTable3441[3].input3441v : "");
          setValue3441t10(data[0].yearTable3441[4] ? data[0].yearTable3441[4].input3441v : "");

          //3442
          setValue3441t11(data[0].universityYearTable3442[0] ? data[0].universityYearTable3442[0].input3442y : "");
          setValue3441t12(data[0].universityYearTable3442[1] ? data[0].universityYearTable3442[1].input3442y : "");
          setValue3441t13(data[0].universityYearTable3442[2] ? data[0].universityYearTable3442[2].input3442y : "");
          setValue3441t14(data[0].universityYearTable3442[3] ? data[0].universityYearTable3442[3].input3442y : "");
          setValue3441t15(data[0].universityYearTable3442[4] ? data[0].universityYearTable3442[4] .input3442y : "");
          setValue3441t16(data[0].universityYearTable3442[0] ? data[0].universityYearTable3442[0].input3442v : "");
          setValue3441t17(data[0].universityYearTable3442[1] ? data[0].universityYearTable3442[1].input3442v : "");
          setValue3441t18(data[0].universityYearTable3442[2] ? data[0].universityYearTable3442[2].input3442v : "");
          setValue3441t19(data[0].universityYearTable3442[3] ? data[0].universityYearTable3442[3].input3442v : "");
          setValue3441t20(data[0].universityYearTable3442[4] ? data[0].universityYearTable3442[4].input3442v :"");

          //3451
          setValue3451t1(data[0].universityYearTable3451[0] ? data[0].universityYearTable3451[0].input3451y : "");
          setValue3451t2(data[0].universityYearTable3451[1] ? data[0].universityYearTable3451[1].input3451y : "");
          setValue3451t3(data[0].universityYearTable3451[2] ? data[0].universityYearTable3451[2].input3451y : "");
          setValue3451t4(data[0].universityYearTable3451[3] ? data[0].universityYearTable3451[3].input3451y : "");
          setValue3451t5(data[0].universityYearTable3451[4] ? data[0].universityYearTable3451[4].input3451y : "");
          setValue3451t6(data[0].universityYearTable3451[0] ? data[0].universityYearTable3451[0].input3451v : "");
          setValue3451t7(data[0].universityYearTable3451[1] ? data[0].universityYearTable3451[1].input3451v : "");
          setValue3451t8(data[0].universityYearTable3451[2] ? data[0].universityYearTable3451[2].input3451v : "");
          setValue3451t9(data[0].universityYearTable3451[3] ? data[0].universityYearTable3451[3].input3451v : "");
          setValue3451t10(data[0].universityYearTable3451[4] ? data[0].universityYearTable3451[4].input3451v : "");

          //34512
          setValue3451t11(data[0].universityYearTable34512[0] ? data[0].universityYearTable34512[0].input34512y : "");
          setValue3451t12(data[0].universityYearTable34512[1] ? data[0].universityYearTable34512[1].input34512y : "");
          setValue3451t13(data[0].universityYearTable34512[2] ? data[0].universityYearTable34512[2].input34512y : "");
          setValue3451t14(data[0].universityYearTable34512[3] ? data[0].universityYearTable34512[3].input34512y : "");
          setValue3451t15(data[0].universityYearTable34512[4] ? data[0].universityYearTable34512[4].input34512y : "");
          setValue3451t16(data[0].universityYearTable34512[0] ? data[0].universityYearTable34512[0].input34512v : "");
          setValue3451t17(data[0].universityYearTable34512[1] ? data[0].universityYearTable34512[1].input34512v : "");
          setValue3451t18(data[0].universityYearTable34512[2] ? data[0].universityYearTable34512[2].input34512v : "");
          setValue3451t19(data[0].universityYearTable34512[3] ? data[0].universityYearTable34512[3].input34512v : "");
          setValue3451t20(data[0].universityYearTable34512[4] ? data[0].universityYearTable34512[4].input34512v : "");

         
          //3461
          setValue3461t1(data[0].universityYearTable3461[0] ? data[0].universityYearTable3461[0].input3461y : "");
          setValue3461t2(data[0].universityYearTable3461[1] ? data[0].universityYearTable3461[1].input3461y : "");
          setValue3461t3(data[0].universityYearTable3461[2] ? data[0].universityYearTable3461[2].input3461y : "");
          setValue3461t4(data[0].universityYearTable3461[3] ? data[0].universityYearTable3461[3].input3461y : "");
          setValue3461t5(data[0].universityYearTable3461[4] ? data[0].universityYearTable3461[4].input3461y : "");
          setValue3461t6(data[0].universityYearTable3461[0] ? data[0].universityYearTable3461[0].input3461v : "");
          setValue3461t7(data[0].universityYearTable3461[1] ? data[0].universityYearTable3461[1].input3461v : "");
          setValue3461t8(data[0].universityYearTable3461[2] ? data[0].universityYearTable3461[2].input3461v : "");
          setValue3461t9(data[0].universityYearTable3461[3] ? data[0].universityYearTable3461[3].input3461v : "");
          setValue3461t10(data[0].universityYearTable3461[4] ? data[0].universityYearTable3461[4].input3461v : "");

          

          //3462
          setValue3461t11(data[0].universityYearTable34612[0] ? data[0].universityYearTable34612[0].input34612y : "");
          setValue3461t12(data[0].universityYearTable34612[1] ? data[0].universityYearTable34612[1].input34612y : "");
          setValue3461t13(data[0].universityYearTable34612[2] ? data[0].universityYearTable34612[2].input34612y : "");
          setValue3461t14(data[0].universityYearTable34612[3] ? data[0].universityYearTable34612[3].input34612y : "");
          setValue3461t15(data[0].universityYearTable34612[4] ? data[0].universityYearTable34612[4].input34612y : "");
          setValue3461t16(data[0].universityYearTable34612[0] ? data[0].universityYearTable34612[0].input34612v : "");
          setValue3461t17(data[0].universityYearTable34612[1] ? data[0].universityYearTable34612[1].input34612v : "");
          setValue3461t18(data[0].universityYearTable34612[2] ? data[0].universityYearTable34612[2].input34612v : "");
          setValue3461t19(data[0].universityYearTable34612[3] ? data[0].universityYearTable34612[3].input34612v : "");
          setValue3461t20(data[0].universityYearTable34612[4] ? data[0].universityYearTable34612[4].input34612v : "");


          setValue341f1(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
          setValue341f2(data[0].criteria3FileUpload[1] ? data[0].criteria3FileUpload[1].criteria3FileName : "");
          setValue342f1(data[0].criteria3FileUpload[2] ? data[0].criteria3FileUpload[2].criteria3FileName : "");
          setValue342f2(data[0].criteria3FileUpload[3] ? data[0].criteria3FileUpload[3].criteria3FileName : "");
          setValue3431f1(data[0].criteria3FileUpload[4] ? data[0].criteria3FileUpload[4].criteria3FileName : "");
          setValue3431f2(data[0].criteria3FileUpload[5] ? data[0].criteria3FileUpload[5].criteria3FileName : "");
          setValue3441f1(data[0].criteria3FileUpload[6] ? data[0].criteria3FileUpload[6].criteria3FileName : "");
          setValue3441f2(data[0].criteria3FileUpload[7] ? data[0].criteria3FileUpload[7].criteria3FileName : "");
          setValue3441f3(data[0].criteria3FileUpload[8] ? data[0].criteria3FileUpload[8].criteria3FileName : "");
          setValue3451f1(data[0].criteria3FileUpload[9] ? data[0].criteria3FileUpload[9].criteria3FileName : "");
          setValue3451f2(data[0].criteria3FileUpload[10] ? data[0].criteria3FileUpload[10].criteria3FileName : "");
          setValue3461f1(data[0].criteria3FileUpload[11] ? data[0].criteria3FileUpload[11].criteria3FileName : "");
          setValue3461f2(data[0].criteria3FileUpload[12] ? data[0].criteria3FileUpload[12].criteria3FileName : "");
          setValue347f1(data[0].criteria3FileUpload[13] ? data[0].criteria3FileUpload[13].criteria3FileName : "");
          setValue347f2(data[0].criteria3FileUpload[14] ?data[0].criteria3FileUpload[14].criteria3FileName : "");
          setValue3482f1(data[0].criteria3FileUpload[15] ? data[0].criteria3FileUpload[15].criteria3FileName : "");
          setValue3482f2(data[0].criteria3FileUpload[16] ? data[0].criteria3FileUpload[16].criteria3FileName : "");
          setValue3491f1(data[0].criteria3FileUpload[17] ? data[0].criteria3FileUpload[17].criteria3FileName : "");
          setValue3491f2(data[0].criteria3FileUpload[18] ? data[0].criteria3FileUpload[18].criteria3FileName : "");
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ),
    []
  );
  
  function onClickingViewResponse341() {
    if (value341t1 === '' || value341t1 === undefined || value341t1 === null) {
      setResponseValue341('Please select any option');
    } else {
      setResponseValue341(value341t1);
    }
  }
  function onClickingViewResponse342() {
    if (value342t1 === '' || value342t1 === undefined || value342t1 === null) {
      setResponseValue342('Please select any option');
    } else {
      setResponseValue342(value342t1);
    }
  }
  function onClickingViewResponse343() {
    if (
      value3431t6 === ''
      || value3431t7 === ''
      || value3431t8 === ''
      || value3431t9 === ''
      || value3431t10 === ''
      || value3431t6 === undefined
      || value3431t7 === undefined
      || value3431t8 === undefined
      || value3431t9 === undefined
      || value3431t10 === undefined
    ) {
      setResponseValue343('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3431t6, 10)) === false
      || Number.isInteger(parseInt(value3431t7, 10)) === false
      || Number.isInteger(parseInt(value3431t8, 10)) === false
      || Number.isInteger(parseInt(value3431t9, 10)) === false
      || Number.isInteger(parseInt(value3431t10, 10)) === false
    ) {
      setResponseValue343('Input should be an Integer');
    } else if (
      value3431t6 !== ''
      && value3431t7 !== ''
      && value3431t8 !== ''
      && value3431t9 !== ''
      && value3431t10 !== ''
    ) {
      setResponseValue343(
        (parseInt(value3431t6, 10)
          + parseInt(value3431t7, 10)
          + parseInt(value3431t8, 10)
          + parseInt(value3431t9, 10)
          + parseInt(value3431t10, 10))
      );
    }
  }
  function onClickingViewResponse344() {
    if (
      value3441t6 === ''
      || value3441t7 === ''
      || value3441t8 === ''
      || value3441t9 === ''
      || value3441t10 === ''
      || value3441t16 === ''
      || value3441t17 === ''
      || value3441t18 === ''
      || value3441t19 === ''
      || value3441t20 === ''
      || value3441t6 === undefined
      || value3441t7 === undefined
      || value3441t8 === undefined
      || value3441t9 === undefined
      || value3441t10 === undefined
      || value3441t16 === undefined
      || value3441t17 === undefined
      || value3441t18 === undefined
      || value3441t19 === undefined
      || value3441t20 === undefined
    ) {
      setResponseValue344('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3441t6, 10)) === false
      || Number.isInteger(parseInt(value3441t7, 10)) === false
      || Number.isInteger(parseInt(value3441t8, 10)) === false
      || Number.isInteger(parseInt(value3441t9, 10)) === false
      || Number.isInteger(parseInt(value3441t10, 10)) === false
      || Number.isInteger(parseInt(value3441t16, 10)) === false
      || Number.isInteger(parseInt(value3441t17, 10)) === false
      || Number.isInteger(parseInt(value3441t18, 10)) === false
      || Number.isInteger(parseInt(value3441t19, 10)) === false
      || Number.isInteger(parseInt(value3441t20, 10)) === false
    ) {
      setResponseValue344('Input should be an Integer');
    } else if (
      value3441t6 !== ''
      && value3441t7 !== ''
      && value3441t8 !== ''
      && value3441t9 !== ''
      && value3441t10 !== ''
      && value3441t16 !== ''
      && value3441t17 !== ''
      && value3441t18 !== ''
      && value3441t19 !== ''
      && value3441t20 !== ''
    ) {
      setResponseValue344(
        (parseInt(value3441t6, 10)
          + parseInt(value3441t7, 10)
          + parseInt(value3441t8, 10)
          + parseInt(value3441t9, 10)
          + parseInt(value3441t10, 10))
          / (parseInt(value3441t16, 10)
          + parseInt(value3441t17, 10)
          + parseInt(value3441t18, 10)
          + parseInt(value3441t19, 10)
          + parseInt(value3441t20, 10))
      );
    }
  }
  function onClickingViewResponse345() {
    if (
      value3451t6 === ''
      || value3451t7 === ''
      || value3451t8 === ''
      || value3451t9 === ''
      || value3451t10 === ''
      || value3451t16 === ''
      || value3451t17 === ''
      || value3451t18 === ''
      || value3451t19 === ''
      || value3451t20 === ''
      || value3451t6 === undefined
      || value3451t7 === undefined
      || value3451t8 === undefined
      || value3451t9 === undefined
      || value3451t10 === undefined
      || value3451t16 === undefined
      || value3451t17 === undefined
      || value3451t18 === undefined
      || value3451t19 === undefined
      || value3451t20 === undefined
    ) {
      setResponseValue345('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3451t6, 10)) === false
      || Number.isInteger(parseInt(value3451t7, 10)) === false
      || Number.isInteger(parseInt(value3451t8, 10)) === false
      || Number.isInteger(parseInt(value3451t9, 10)) === false
      || Number.isInteger(parseInt(value3451t10, 10)) === false
      || Number.isInteger(parseInt(value3451t16, 10)) === false
      || Number.isInteger(parseInt(value3451t17, 10)) === false
      || Number.isInteger(parseInt(value3451t18, 10)) === false
      || Number.isInteger(parseInt(value3451t19, 10)) === false
      || Number.isInteger(parseInt(value3451t20, 10)) === false
    ) {
      setResponseValue345('Input should be an Integer');
    } else if (
      value3451t6 !== ''
      && value3451t7 !== ''
      && value3451t8 !== ''
      && value3451t9 !== ''
      && value3451t10 !== ''
      && value3451t16 !== ''
      && value3451t17 !== ''
      && value3451t18 !== ''
      && value3451t19 !== ''
      && value3451t20 !== ''
    ) {
      setResponseValue345(
        (parseInt(value3451t6, 10)
          + parseInt(value3451t7, 10)
          + parseInt(value3451t8, 10)
          + parseInt(value3451t9, 10)
          + parseInt(value3451t10, 10))
          / (parseInt(value3451t16, 10)
          + parseInt(value3451t17, 10)
          + parseInt(value3451t18, 10)
          + parseInt(value3451t19, 10)
          + parseInt(value3451t20, 10))
      );
    }
  }
  function onClickingViewResponse346() {
    if (
      value3461t6 === ''
      || value3461t7 === ''
      || value3461t8 === ''
      || value3461t9 === ''
      || value3461t10 === ''
      || value3461t16 === ''
      || value3461t17 === ''
      || value3461t18 === ''
      || value3461t19 === ''
      || value3461t20 === ''
      || value3461t6 === undefined
      || value3461t7 === undefined
      || value3461t8 === undefined
      || value3461t9 === undefined
      || value3461t10 === undefined
      || value3461t16 === undefined
      || value3461t17 === undefined
      || value3461t18 === undefined
      || value3461t19 === undefined
      || value3461t20 === undefined
    ) {
      setResponseValue346('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3461t6, 10)) === false
      || Number.isInteger(parseInt(value3461t7, 10)) === false
      || Number.isInteger(parseInt(value3461t8, 10)) === false
      || Number.isInteger(parseInt(value3461t9, 10)) === false
      || Number.isInteger(parseInt(value3461t10, 10)) === false
      || Number.isInteger(parseInt(value3461t16, 10)) === false
      || Number.isInteger(parseInt(value3461t17, 10)) === false
      || Number.isInteger(parseInt(value3461t18, 10)) === false
      || Number.isInteger(parseInt(value3461t19, 10)) === false
      || Number.isInteger(parseInt(value3461t20, 10)) === false
    ) {
      setResponseValue346('Input should be an Integer');
    } else if (
      value3461t6 !== ''
      && value3461t7 !== ''
      && value3461t8 !== ''
      && value3461t9 !== ''
      && value3461t10 !== ''
      && value3461t16 !== ''
      && value3461t17 !== ''
      && value3461t18 !== ''
      && value3461t19 !== ''
      && value3461t20 !== ''
    ) {
      setResponseValue346(
        ((value3461t6)
          + (value3461t7)
          + (value3461t8)
          + (value3461t9)
          + (value3461t10))
          / ((value3461t16)
          + (value3461t17)
          + (value3461t18)
          + (value3461t19)
          + (value3461t20))
      );
    }
  }

  function onClickingViewResponse347() {
    if (value347t1 === '' || value347t1 === undefined || value347t1 === null) {
      setResponseValue347('Please select any option');
    } else {
      setResponseValue347(value347t1);
    }
  }

  function onClickingViewResponse348() {
    if (
      value3481t1 === ''
      || value3481t2 === ''
      || value3482t1 === ''
      || value3482t2 === ''
      || value3481t1 === undefined
      || value3481t2 === undefined
      || value3482t1 === undefined
      || value3482t2 === undefined
    ) {
      setResponseValue348('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3481t1, 10)) === false
      || Number.isInteger(parseInt(value3481t2, 10)) === false
      || Number.isInteger(parseInt(value3482t1, 10)) === false
      || Number.isInteger(parseInt(value3482t2, 10)) === false
    ) {
      setResponseValue348('Input should be an Integer');
    } else if (
      value3481t1 !== ''
      && value3481t2 !== ''
      && value3482t1 !== ''
      && value3482t2 !== ''
    ) {
      setResponseValue348(
        (0.5 * parseInt(value3481t1, 10) + 0.5 * parseInt(value3481t2, 10))
          / (0.5 * parseInt(value3482t1, 10) + 0.5 * parseInt(value3482t2, 10))
      );
    }
  }

  function onClickingViewResponse349() {
    if (
      value3491t1 === ''
      || value3491t2 === ''
      || value3491t1 === undefined
      || value3491t2 === undefined
    ) {
      setResponseValue349('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3491t1, 10)) === false
      || Number.isInteger(parseInt(value3491t2, 10)) === false
    ) {
      setResponseValue349('Input should be an Integer');
    } else if (value3491t1 !== '' && value3491t2 !== '') {
      setResponseValue349(
        (parseInt(value3491t1, 10) + parseInt(value3491t2, 10)) / 2
      );
    }
  }

  

  // sending data to db with API
   
  const inputDataList = {
          criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
     criteria34Qn: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
      input342t1: value342t1,
      input347t1: value347t1,
      input3481t1: value3481t1,
      input3481t2: value3481t2,
      input3482t1: value3482t1,
      input3482t2: value3482t2,
     
      response342: responseValue342,
      response343: responseValue343,
      response344: responseValue344,
      response345: responseValue345,
      response346: responseValue346,
      },
    ],
    criteria34Ql: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,
      input341t1: value341t1,
      input3491t1: value3491t1,
      input3491t2: value3491t2,

      response341: responseValue341,
      },
    ],
 
    universityYearTable3431: [
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
      uniqueKey1: 201,input3431y: value3431t1, input3431v: value3431t6 },
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202,input3431y: value3431t2, input3431v: value3431t7 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203, input3431y: value3431t3, input3431v: value3431t8 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204, input3431y: value3431t4, input3431v: value3431t9 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205, input3431y: value3431t5, input3431v: value3431t10 },
    ],
    yearTable3441: [
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201,input3441y: value3441t1, input3441v: value3441t6 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202, input3441y: value3441t2, input3441v: value3441t7 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203,input3441y: value3441t3, input3441v: value3441t8 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204, input3441y: value3441t4, input3441v: value3441t9 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205,input3441y: value3441t5, input3441v: value3441t10 },
    ],
    universityYearTable3442: [
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201, input3442y: value3441t11, input3442v: value3441t16 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202,input3442y: value3441t12, input3442v: value3441t17 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203,input3442y: value3441t13, input3442v: value3441t18 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204,input3442y: value3441t14, input3442v: value3441t19 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205,input3442y: value3441t15, input3442v: value3441t20 },
    ],
    universityYearTable3451: [
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201, input3451y: value3451t11, input3451v: value3451t16 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202, input3451y: value3451t12, input3451v: value3451t17 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203, input3451y: value3451t13, input3451v: value3451t18 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204, input3451y: value3451t14, input3451v: value3451t19 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205, input3451y: value3451t15, input3451v: value3451t20 },
    ],
    universityYearTable34512: [
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201, input34512y: value3451t1, input34512v: value3451t6 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202, input34512y: value3451t2, input34512v: value3451t7 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203, input34512y: value3451t3, input34512v: value3451t8 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204, input34512y: value3451t4, input34512v: value3451t9 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205, input34512y: value3451t5, input34512v: value3451t10 },
    ],
    universityYearTable3461: [
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201, input3461y: value3431t1, input3461v: value3431t6 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202, input3461y: value3431t2, input3461v: value3431t7 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203, input3461y: value3431t3, input3461v: value3431t8 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204, input3461y: value3431t4, input3461v: value3431t9 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205, input3461y: value3431t5, input3461v: value3431t10 },
    ],
    universityYearTable34612: [
      {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 201, input34612y: value3461t11, input34612v: value3461t16 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 202, input34612y: value3461t12, input34612v: value3461t17 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 203, input34612y: value3461t13, input34612v: value3461t18 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 204, input34612y: value3461t14, input34612v: value3461t19 },
        {criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        uniqueKey1: 205, input34612y: value3461t15, input34612v: value3461t20 },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const form34Data = new FormData();

    form34Data.append('criteria3Fieldinfo', jsonBlob(inputDataList));
    if (pathValue341f1 !== '') {
      form34Data.append('uploadfile3', value341f1, 'f341f1-' + value341f1.name);
    }
    if (pathValue341f2 !== '') {
      form34Data.append('uploadfile3', value341f2, 'f341f2-' + value341f2.name);
    }
    if (pathValue342f1 !== '') {
      form34Data.append('uploadfile3', value342f1, 'f342f1-' + value342f1.name);
    }
    if (pathValue342f2 !== '') {
      form34Data.append('uploadfile3', value342f2, 'f342f2-' + value342f2.name);
    }
    if (pathValue3431f1 !== '') {
      form34Data.append(
        'uploadfile3',
        value3431f1,
        'f3431f1-' + value3431f1.name
      );
    }
    if (pathValue3431f2 !== '') {
      form34Data.append(
        'uploadfile3',
        value3431f2,
        'f3431f2-' + value3431f2.name
      );
    }
    if (pathValue3441f1 !== '') {
      form34Data.append(
        'uploadfile3',
        value3441f1,
        'f3441f1-' + value3441f1.name
      );
    }
    if (pathValue3441f2 !== '') {
      form34Data.append(
        'uploadfile3',
        value3441f2,
        'f3441f2-' + value3441f2.name
      );
    }
    if (pathValue3441f3 !== '') {
      form34Data.append(
        'uploadfile3',
        value3441f3,
        'f3441f3-' + value3441f3.name
      );
    }
    if (pathValue3451f1 !== '') {
      form34Data.append(
        'uploadfile3',
        value3451f1,
        'f3451f1-' + value3451f1.name
      );
    }
    if (pathValue3451f2 !== '') {
      form34Data.append(
        'uploadfile3',
        value3451f2,
        'f3451f2-' + value3451f2.name
      );
    }
    if (pathValue3461f1 !== '') {
      form34Data.append('uploadfile3', value3461f1, 'f3461f1-' + value3461f1.name);
    }
    if (pathValue3461f2 !== '') {
      form34Data.append('uploadfile3', value3461f2, 'f3461f2-' + value3461f2.name);
    }
    if (pathValue347f1 !== '') {
      form34Data.append('uploadfile3', value347f1, 'f347f1-' + value347f1.name);
    }
    if (pathValue347f2 !== '') {
      form34Data.append('uploadfile3', value347f2, 'f347f2-' + value347f2.name);
    }
    if (pathValue3482f1 !== '') {
      form34Data.append('uploadfile3', value3482f1, 'f3482f1-' + value3482f1.name);
    }
    if (pathValue3482f2 !== '') {
      form34Data.append('uploadfile3', value3482f2, 'f3482f2-' + value3482f2.name);
    }
    if (pathValue3491f1 !== '') {
      form34Data.append('uploadfile3', value3491f1, 'f3491f1-' + value3491f1.name);
    }
    if (pathValue3491f2 !== '') {
      form34Data.append('uploadfile3', value3491f2, 'f3491f2-' + value3491f2.name);
    }
    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: form34Data,
    };
    fetch(
      resources.APPLICATION_URL+'criteria3upload',
      filesFetchMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("SAVED Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }

  return (
    <div className="c34-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c34x-colorIndicator-container">
        <p className="c34x-QlcolorIndicator-circle-style"></p>
        <span className="c34x-colorIndicator-span-style">Qualitative</span>
        <p className="c34x-QtcolorIndicator-circle-style"></p>
        <span className="c34x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: '60%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-end',
          }}
        >
          <h1 className="c34x-weightage-heading-style">
            Key Indicator Weightage: 30
          </h1>
        </div>
      </div>

      {/* Key Indicator: 3.4.1 */}
      <div className="c34x-eachInputField-container">
        <div className="c34x-weightage-container">
          <h1 className="c34x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c34x-container">
            <div className="c34x-heading_Help-container">
              <div>
                <h1 className="c34x-heading-style">
                  <span className="c34x-span-style">3.4.1: </span>
                  The institution ensures implementation of its stated Code of Ethics for research
                </h1>
                <h1 className="c34x-heading-style">
                  <span className="c34x-span-style">3.4.1.1: </span>
                  3.4.1.1The institution has a stated Code of Ethics for research and the implementation of which is ensured through the following:
                </h1>
                <p className="c34x-para-style">
                  1. Inclusion of research ethics in the research methodology course work
                  <br />
                  2. Presence of institutional Ethics committees (Animal, chemical,bio-ethics etc.,)
                  <br />
                  3. Plagiarism check
                  <br />
                  4. Research advisory committee
                </p>
                <div className="c34x-radio-container">
                  <div className="c34x-radio-subContainer" style={{width:"45%"}} >
                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue341t1(e.target.value)}
                        value="option a"
                        name="341-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="341-t1">
                        A. All of the above
                      </label>
                    </div>

                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue341t2(e.target.value)}
                        value="option b"
                        name="341-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="341-t2">
                        B. Any three of the above
                      </label>
                    </div>

                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue341t3(e.target.value)}
                        value="option c"
                        name="341-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="341-t3">
                        C. Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c34x-radio-subContainer">
                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue341t4(e.target.value)}
                        value="option d"
                        name="341-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="341-t4">
                        D. Any one of the above
                      </label>
                    </div>

                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue341t5(e.target.value)}
                        value="option e"
                        name="341-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="341-t5">
                        E. None of the above
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
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            <div className="c34x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus341(!responseButtonStatus341);
                  onClickingViewResponse341();
                }}
                className="c34x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus341 ? (
                <p className="c34x-responseResult-style">{responseValue341}</p>
              ) : null}
            </div>
          </div>
          <table className="c34x-table-style">
            <tr>
              <th className="c34x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c34x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c34x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c34x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Copy of the syllabus of the research methodology course work to indicate if research ethics is included.</td>
              <td></td>
              <td>
                {/* <input
                  onChange={(e) => {
                    setValue341f1(e.target.files[0]);
                    setPathValue341f1(e.target.value);
                  }}
                  id="341-f1"
                  type="file"
                  className="c34-fileButton-style"
                />
                {pathValue341f1 === '' ? null : (
                  <div className="c34-fileButtons-container">
                    <button className="c34-viewFileButton-style">
                      View File
                    </button>
                    <button className="c34-removeFileButton-style">
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
                id="341-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue341f1(e.target.files[0]);
                    setPathValue341f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue341f1}
              {pathValue341f1 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc341f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue341f1("");
                      document.getElementById("341-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c34x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Constitution of the ethics committee and its proceedings as approved by the appropriate body.</td>
              <td></td>
              <td>
                {/* <input
                  onChange={(e) => {
                    setValue341f2(e.target.files[0]);
                    setPathValue341f2(e.target.value);
                  }}
                  id="341-f2"
                  type="file"
                  className="c34-fileButton-style"
                />
                {pathValue341f2 === '' ? null : (
                  <div className="c34-fileButtons-container">
                    <button className="c34-viewFileButton-style">
                      View File
                    </button>
                    <button className="c34-removeFileButton-style">
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
                id="341-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue341f2(e.target.files[0]);
                    setPathValue341f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue341f2}
              {pathValue341f2 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc341f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue341f2("");
                      document.getElementById("341-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c34x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Constitution of research advisory committee and its proceedings as approved by the appropriate body..</td>
              <td></td>
              <td>
                {/* <input
                  onChange={(e) => {
                    setValue341f2(e.target.files[0]);
                    setPathValue341f2(e.target.value);
                  }}
                  id="341-f2"
                  type="file"
                  className="c34-fileButton-style"
                />
                {pathValue341f2 === '' ? null : (
                  <div className="c34-fileButtons-container">
                    <button className="c34-viewFileButton-style">
                      View File
                    </button>
                    <button className="c34-removeFileButton-style">
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
                id="341-f3"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue341f3(e.target.files[0]);
                    setPathValue341f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue341f3}
              {pathValue341f3 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc341f3}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue341f3("");
                      document.getElementById("341-f3").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c34x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Bills of purchase of licensed plagiarism check software in the name of the HEI.</td>
              <td></td>
               <td>
              {/*  <input
                  onChange={(e) => {
                    setValue341f2(e.target.files[0]);
                    setPathValue341f2(e.target.value);
                  }}
                  id="341-f2"
                  type="file"
                  className="c34-fileButton-style"
                />
                {pathValue341f2 === '' ? null : (
                  <div className="c34-fileButtons-container">
                    <button className="c34-viewFileButton-style">
                      View File
                    </button>
                    <button className="c34-removeFileButton-style">
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
                id="341-f4"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue341f4(e.target.files[0]);
                    setPathValue341f4(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue341f4}
              {pathValue341f4 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc341f4}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue341f4("");
                      document.getElementById("341-f4").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c34x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>

        {/* <div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus341(true);
                setGradeScale341(radioMetricGradeCalculator(responseValue341));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Grade Scale
            </button>

            {gradeScaleClickStatus341 ? (
              <p className="c34x-responseResult-style">
                {radioMetricGradeCalculator(responseValue341)}
              </p>
            ) : null}
          </div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus341(true);
                setGradeScale341(radioMetricGradeCalculator(responseValue341));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Weighted Grade Points
            </button>
            {gradePointsClickStatus341 ? (
              <p className="c34x-responseResult-style">
                {metricGradePointsCalculator(gradeScale341, 5)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>

      {/* Key Indicator: 3.4.2 */}
      <div className="c34x-eachInputField-container">
        <div className="c34x-weightage-container">
          <h1 className="c34x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c34x-container">
            <div className="c34x-heading_Help-container">
              <div>
                <h1 className="c34x-heading-style">
                  <span className="c34x-span-style">3.4.2: </span>
                  Number of Patents awarded during the last five years
                </h1>
                <h1 className="c34x-heading-style">
                  <span className="c34x-span-style">3.4.2.1: </span>
                  Total number of Patents awarded year-wise during the last five years
                <input></input>
                </h1>
                {/* <p className="c34x-para-style">
                 1.Commendation and monetary incentive at a University function
                  <br />
                  2.Commendation and medal at a University function
                  <br />
                  3. Certificate of honor
                  <br />
                  4.Announcement in the Newsletter / website
                </p>
                <div className="c34x-radio-container">
                  <div className="c34x-radio-subContainer" style={{width:"45%"}}>
                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue342t1(e.target.value)}
                        value="option a"
                        name="342-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="341-t1">
                        A. All of the above
                      </label>
                    </div>

                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue342t1(e.target.value)}
                        value="option b"
                        name="342-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="342-t2">
                        B. Any three of the above
                      </label>
                    </div>

                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue342t1(e.target.value)}
                        value="option c"
                        name="342-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="342-t3">
                        C. Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c34x-radio-subContainer">
                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue342t1(e.target.value)}
                        value="option d"
                        name="342-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="342-t4">
                        D. Any one of the above
                      </label>
                    </div>

                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue342t1(e.target.value)}
                        value="option e"
                        name="342-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="342-t5">
                        E. None of the above
                      </label>
                    </div>
                  </div>
                </div> */}
              </div>
              <button
                onClick={handleHelpOpen9}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen}
                handleClose={handleHelpClose9}
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            {/* <div className="c34x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus342(!responseButtonStatus342);
                  onClickingViewResponse342();
                }}
                className="c34x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus342 ? (
                <p className="c34x-responseResult-style">{responseValue342}</p>
              ) : null}
            </div> */}
          </div>
          <table className="c34x-table-style">
            <tr>
              <th className="c34x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c34x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c34x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c34x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Institutional data in the prescribed format (data template)</td>
              <td></td>
              <td>
                {/* <input
                  onChange={(e) => {
                    setValue342f1(e.target.files[0]);
                    setPathValue342f1(e.target.value);
                  }}
                  id="342-f1"
                  type="file"
                  className="c34-fileButton-style"
                />
                {pathValue342f1 === '' ? null : (
                  <div className="c34-fileButtons-container">
                    <button className="c34-viewFileButton-style">
                      View File
                    </button>
                    <button className="c34-removeFileButton-style">
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
                id="342-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue342f1(e.target.files[0]);
                    setPathValue342f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue342f1}
              {pathValue342f1 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc341f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue342f1("");
                      document.getElementById("342-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c34x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>e-copies of the letters of granted patents, and the current status. Patents granted / published in the name of the faculty with the institutional affiliation to the university working during the assessment period</td>
              <td></td>
              <td>
                {/* <input
                  onChange={(e) => {
                    setValue342f2(e.target.files[0]);
                    setPathValue342f2(e.target.value);
                  }}
                  id="342-f2"
                  type="file"
                  className="c34-fileButton-style"
                />
                {pathValue342f2 === '' ? null : (
                  <div className="c34-fileButtons-container">
                    <button className="c34-viewFileButton-style">
                      View File
                    </button>
                    <button className="c34-removeFileButton-style">
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
                id="342-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue342f2(e.target.files[0]);
                    setPathValue342f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue342f2}
              {pathValue342f2 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc342f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue342f2("");
                      document.getElementById("342-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c34x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>

        {/* <div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus341(true);
                setGradeScale341(radioMetricGradeCalculator(responseValue341));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Grade Scale
            </button>

            {gradeScaleClickStatus341 ? (
              <p className="c34x-responseResult-style">
                {radioMetricGradeCalculator(responseValue341)}
              </p>
            ) : null}
          </div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus341(true);
                setGradeScale341(radioMetricGradeCalculator(responseValue341));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Weighted Grade Points
            </button>
            {gradePointsClickStatus341 ? (
              <p className="c34x-responseResult-style">
                {metricGradePointsCalculator(gradeScale341, 5)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>

      {/* Key Indicator: 3.4.3 */}
      <div className="c34x-eachInputField-container">
        <div className="c34x-weightage-container">
          <h1 className="c34x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c34x-container">
            <div className="c34x-heading_Help-container">
              <h1 className="c34x-heading-style">
                <span className="c34x-span-style">3.4.3: </span>
                Number of Ph.Ds awarded per recognized guide during the last five years
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
                ><h1>(Number of Ph.D degrees awardedduring the last five years) /(Number of Teachers recognised as guides during the last five years)</h1></HelpButton>
            </div>
            <div className="c34x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus343(!responseButtonStatus343);
                  onClickingViewResponse343();
                }}
                className="c34x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus343 ? (
                <p className="c34x-responseResult-style">{responseValue343}</p>
              ) : null}
            </div>
          </div>
          <div className="c34xx-container">
            <h1 className="c34xx-Heading-style">
              <span className="c34xx-span-style">3.4.3.1: </span>
              How many Ph.D s were awarded during last 5 years
            </h1>
            <h1 className="c34xx-Heading-style">
              <span className="c34xx-span-style">3.4.3.2: </span>
              Number of teachers recognized as guides during the last five years
            </h1>

           

            <table className="c34x-table-style">
              <tr>
                <th className="c34x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c34x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c34x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c34x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Institutional data in the prescribed format (data template)</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3431f1(e.target.files[0]);
                      setPathValue3431f1(e.target.value);
                    }}
                    id="3431-f1"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3431f1 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c34-removeFileButton-style">
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
                id="3431-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3431f1(e.target.files[0]);
                    setPathValue3431f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3431f1}
              {pathValue3431f1 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc343f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3431f1("");
                      document.getElementById("3431-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                PhD Award letters to PhD students.
                </td>
                <td>
                <a href={downloadFile("un3.4.5.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3431f2(e.target.files[0]);
                      setPathValue3431f2(e.target.value);
                    }}
                    id="3431-f2"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3431f2 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c34-removeFileButton-style">
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
                id="3431-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3431f2(e.target.files[0]);
                    setPathValue3431f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3431f2}
              {pathValue3431f2 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc341f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3431f2("");
                      document.getElementById("3431-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                Letter from the university indicating name of the PhD student with title of the doctoral study and the name of the guide.
                </td>
                <td>
                <a href={downloadFile("un3.4.1.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3431f2(e.target.files[0]);
                      setPathValue3431f2(e.target.value);
                    }}
                    id="3431-f2"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3431f2 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c34-removeFileButton-style">
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
                id="3431-f3"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3431f3(e.target.files[0]);
                    setPathValue3431f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3431f3}
              {pathValue3431f3 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc341f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3431f3("");
                      document.getElementById("3431-f3").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus343(true);
                setGradeScale343(numberMetricGradeCalculator(responseValue343));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Grade Scale
            </button>

            {gradeScaleClickStatus343 ? (
              <p className="c34x-responseResult-style">
                {numberMetricGradeCalculator(responseValue343)}
              </p>
            ) : null}
          </div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus343(true);
                setGradeScale343(numberMetricGradeCalculator(responseValue343));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Weighted Grade Points
            </button>
            {gradePointsClickStatus343 ? (
              <p className="c34x-responseResult-style">
                {metricGradePointsCalculator(gradeScale343, 5)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>

      {/* Key Indicator: 3.4.4 */}
      <div className="c34x-eachInputField-container">
        <div className="c34x-weightage-container">
          <h1 className="c34x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c34x-container">
            <div className="c34x-heading_Help-container">
              <h1 className="c34x-heading-style">
                <span className="c34x-span-style">3.4.4: </span>
                Number of research papers published per teacher in the Journals as notified on UGC CARE list during the last five years
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
                ><h1>(Total Number of publications inUGC CARE list of journals during the last five years)/( (2.2 Number of full time teachers (without repeat count)during the last five years))</h1></HelpButton>
            </div>
            {/* <div className="c34x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus344(!responseButtonStatus344);
                  onClickingViewResponse344();
                }}
                className="c34x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus344 ? (
                <p className="c34x-responseResult-style">{responseValue344}</p>
              ) : null}
            </div> */}
          </div>
          <div className="c34xx-container">
            <h1 className="c34xx-Heading-style">
              <span className="c34xx-span-style">3.4.4.1: </span>
              Number of research papers published in the Journals as notified on UGC CARE list during the last five years
            </h1>

            <table className="c34x-Qt-table-style">
              <tr>
                <th className="c34x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3441t1(e.target.value)}
                      id="3441-t1"
                      className="c34x-input-style"
                      type="text"
                      value={value3441t1}
                    />
                    {value3441t1 === '' ? (
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
                      onChange={(e) => setValue3441t2(e.target.value)}
                      id="3441-t2"
                      className="c34x-input-style"
                      type="text"
                      value={value3441t2}
                    />
                    {value3441t2 === '' ? (
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
                      onChange={(e) => setValue3441t3(e.target.value)}
                      id="3441-t3"
                      className="c34x-input-style"
                      type="text"
                      value={value3441t3}
                    />
                    {value3441t3 === '' ? (
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
                      onChange={(e) => setValue3441t4(e.target.value)}
                      id="3441-t4"
                      className="c34x-input-style"
                      type="text"
                      value={value3441t4}
                    />
                    {value3441t4 === '' ? (
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
                      onChange={(e) => setValue3441t5(e.target.value)}
                      id="3441-t5"
                      className="c34x-input-style"
                      type="text"
                      value={value3441t5}
                    />
                    {value3441t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c34x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3441t6(e.target.value)}
                      id="3441-t6"
                      className="c34x-input-style"
                      type="text"
                      value={value3441t6}
                    />
                    {value3441t6 === '' ? (
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
                      onChange={(e) => setValue3441t7(e.target.value)}
                      id="3441-t7"
                      className="c34x-input-style"
                      type="text"
                      value={value3441t7}
                    />
                    {value3441t7 === '' ? (
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
                      onChange={(e) => setValue3441t8(e.target.value)}
                      id="3441-t8"
                      className="c34x-input-style"
                      type="text"
                      value={value3441t8}
                    />
                    {value3441t8 === '' ? (
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
                      onChange={(e) => setValue3441t9(e.target.value)}
                      id="3441-t9"
                      className="c34x-input-style"
                      type="text"
                      value={value3441t9}
                    />
                    {value3441t9 === '' ? (
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
                      onChange={(e) => setValue3441t10(e.target.value)}
                      id="3441-t10"
                      className="c34x-input-style"
                      type="text"
                      value={value3441t10}
                    />
                    {value3441t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            

         
            <table className="c34x-table-style">
              <tr>
                <th className="c34x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c34x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c34x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c34x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Institutional data in the prescribed format (data template)</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3441f1(e.target.files[0]);
                      setPathValue3441f1(e.target.value);
                    }}
                    id="3441-f1"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3441f1 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c34-removeFileButton-style">
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
                id="3441-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3441f1(e.target.files[0]);
                    setPathValue3441f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3441f1}
              {pathValue3441f1 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc344f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3441f1("");
                      document.getElementById("3441-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                List and links of the papers published in journals listed in UGC CARE list
                </td>
                <td>
                <a href={downloadFile("un3.4.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3441f2(e.target.files[0]);
                      setPathValue3441f2(e.target.value);
                    }}
                    id="3441-f2"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3441f2 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c34-removeFileButton-style">
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
                id="3441-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3441f2(e.target.files[0]);
                    setPathValue3441f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3441f2}
              {pathValue3441f2 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc344f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3441f2("");
                      document.getElementById("3441-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                Link to the institutional website where the first page/full paper (with author and affiliation details) is published
                </td>
                <td>
                <a href={downloadFile("un3.4.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3441f3(e.target.files[0]);
                      setPathValue3441f3(e.target.value);
                    }}
                    id="3441-f3"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3441f3 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c34-removeFileButton-style">
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
                id="3441-f3"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3441f3(e.target.files[0]);
                    setPathValue3441f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3441f3}
              {pathValue3441f3 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc344f3}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3441f3("");
                      document.getElementById("3441-f3").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                Link re-directing to journal source-cite website in case of digital journals  </td>
                <td>
                <a href={downloadFile("un3.4.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3441f3(e.target.files[0]);
                      setPathValue3441f3(e.target.value);
                    }}
                    id="3441-f3"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3441f3 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c34-removeFileButton-style">
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
                id="3441-f4"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3441f4(e.target.files[0]);
                    setPathValue3441f4(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3441f4}
              {pathValue3441f4 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc344f4}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3441f4("");
                      document.getElementById("3441-f4").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus343(true);
                setGradeScale343(numberMetricGradeCalculator(responseValue343));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Grade Scale
            </button>

            {gradeScaleClickStatus343 ? (
              <p className="c34x-responseResult-style">
                {numberMetricGradeCalculator(responseValue343)}
              </p>
            ) : null}
          </div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus343(true);
                setGradeScale343(numberMetricGradeCalculator(responseValue343));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Weighted Grade Points
            </button>
            {gradePointsClickStatus343 ? (
              <p className="c34x-responseResult-style">
                {metricGradePointsCalculator(gradeScale343, 5)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>

      {/* Key Indicator: 3.4.5 */}
      <div className="c34x-eachInputField-container">
        <div className="c34x-weightage-container">
          <h1 className="c34x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c34x-container">
            <div className="c34x-heading_Help-container">
              <h1 className="c34x-heading-style">
                <span className="c34x-span-style">3.4.5: </span>
                Number of books and chapters in edited volumes published per teacher during the last five years
              </h1>
              <button
                onClick={handleHelpOpen4}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen4}
                handleClose={handleHelpClose4}
                title='formula'
                ><h1>(Total number of books and chapters in edited volumes ,books published during last five years) /((2.2 Number of full time teachers(without repeat count)during the last five years))</h1></HelpButton>
            </div>
            <div className="c34x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus345(!responseButtonStatus345);
                  onClickingViewResponse345();
                }}
                className="c34x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus345 ? (
                <p className="c34x-responseResult-style">{responseValue345}</p>
              ) : null}
            </div>
          </div>
          <div className="c34xx-container">
            <h1 className="c34xx-Heading-style">
              <span className="c34xx-span-style">3.4.5.1: </span>
              Total number of books and chapters in edited volumes / books published year- wise during the last five years
            </h1>

            <table className="c34x-Qt-table-style">
              <tr>
                <th className="c34x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3451t1(e.target.value)}
                      id="3451-t1"
                      className="c34x-input-style"
                      type="number"
                      value={value3451t1}
                    />
                    {value3451t1 === '' ? (
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
                      onChange={(e) => setValue3451t2(e.target.value)}
                      id="3451-t2"
                      className="c34x-input-style"
                      type="text"
                      value={value3451t2}
                    />
                    {value3451t2 === '' ? (
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
                      onChange={(e) => setValue3451t3(e.target.value)}
                      id="3451-t3"
                      className="c34x-input-style"
                      type="text"
                      value={value3451t3}
                    />
                    {value3451t3 === '' ? (
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
                      onChange={(e) => setValue3451t4(e.target.value)}
                      id="3451-t4"
                      className="c34x-input-style"
                      type="text"
                      value={value3451t4}
                    />
                    {value3451t4 === '' ? (
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
                      onChange={(e) => setValue3451t5(e.target.value)}
                      id="3451-t5"
                      className="c34x-input-style"
                      type="text"
                      value={value3451t5}
                    />
                    {value3451t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c34x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue3451t6(e.target.value)}
                      id="3451-t6"
                      className="c34x-input-style"
                      type="text"
                      value={value3451t6}
                    />
                    {value3451t6 === '' ? (
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
                      onChange={(e) => setValue3451t7(e.target.value)}
                      id="3451-t7"
                      className="c34x-input-style"
                      type="text"
                      value={value3451t7}
                    />
                    {value3451t7 === '' ? (
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
                      onChange={(e) => setValue3451t8(e.target.value)}
                      id="3451-t8"
                      className="c34x-input-style"
                      type="text"
                      value={value3451t8}
                    />
                    {value3451t8 === '' ? (
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
                      onChange={(e) => setValue3451t9(e.target.value)}
                      id="3451-t9"
                      className="c34x-input-style"
                      type="text"
                      value={value3451t9}
                    />
                    {value3451t9 === '' ? (
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
                      onChange={(e) => setValue3451t10(e.target.value)}
                      id="3451-t10"
                      className="c34x-input-style"
                      type="text"
                      value={value3451t10}
                    />
                    {value3451t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

          

            

            <table className="c34x-table-style">
              <tr>
                <th className="c34x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c34x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c34x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c34x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Institutional data in the prescribed format (data template)</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3451f1(e.target.files[0]);
                      setPathValue3451f1(e.target.value);
                    }}
                    id="3451-f1"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3451f1 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c34-removeFileButton-style">
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
                id="3451-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3451f1(e.target.files[0]);
                    setPathValue3451f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3451f1}
              {pathValue3451f1 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc345f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3451f1("");
                      document.getElementById("3451-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                E-copy of the Cover page, content page and first page of the publication indicating ISBN number and year of publication for books/chapters
                </td>
                <td>
                <a href={downloadFile("un3.4.3.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3451f2(e.target.files[0]);
                      setPathValue3451f2(e.target.value);
                    }}
                    id="3451-f2"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3451f2 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c34-removeFileButton-style">
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
                id="3451-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3451f2(e.target.files[0]);
                    setPathValue3451f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3451f2}
              {pathValue3451f2 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc345f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3451f2("");
                      document.getElementById("3451-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                List of chapter/book with the links redirecting to the source website </td>
                <td>
                <a href={downloadFile("un3.4.3.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3451f2(e.target.files[0]);
                      setPathValue3451f2(e.target.value);
                    }}
                    id="3451-f2"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3451f2 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c34-removeFileButton-style">
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
                id="3451-f3"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3451f3(e.target.files[0]);
                    setPathValue3451f3(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3451f3}
              {pathValue3451f3 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc345f3}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3451f3("");
                      document.getElementById("3451-f3").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus343(true);
                setGradeScale343(numberMetricGradeCalculator(responseValue343));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Grade Scale
            </button>

            {gradeScaleClickStatus343 ? (
              <p className="c34x-responseResult-style">
                {numberMetricGradeCalculator(responseValue343)}
              </p>
            ) : null}
          </div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus343(true);
                setGradeScale343(numberMetricGradeCalculator(responseValue343));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Weighted Grade Points
            </button>
            {gradePointsClickStatus343 ? (
              <p className="c34x-responseResult-style">
                {metricGradePointsCalculator(gradeScale343, 5)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>

      {/* Key Indicator: 3.4.6 */}
      <div className="c34x-eachInputField-container">
        <div className="c34x-weightage-container">
          <h1 className="c34x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c34x-container">
            <div className="c34x-heading_Help-container">
              <h1 className="c34x-heading-style">
                <span className="c34x-span-style">3.4.6: </span>
                E-content is developed by teachers :
              </h1>
              <p className="c14x-para-style">
                  1.For e-PG-Pathshala
                  <br />
                  2.  For CEC (Undergraduate)
                  <br />
                  3. For SWAYAM
                  <br />
                  4.  For other MOOCs platforms
                  <br />
                  5.  Any other Government Initiatives
                  <br/>
                  6. For Institutional LMS
                </p>
                <div className="c14x-radio-container">
                  <div className="c14x-radio-subContainer">
                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue341t1(e.target.value)}
                        value="option a"
                        name="141-t1"
                        type="radio"
                      />

                      <label className="c14x-radioLabel-style" for="141-t1">
                        A. All of the above
                      </label>
                    </div>

                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue341t2(e.target.value)}
                        value="option b"
                        name="141-t1"
                        type="radio"
                      />

                      <label className="c14x-radioLabel-style" for="141-t1">
                        B. Any three of the above
                      </label>
                    </div>

                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue341t3(e.target.value)}
                        value="option c"
                        name="141-t1"
                        type="radio"
                      />

                      <label className="c14x-radioLabel-style" for="141-t1">
                        C. Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c14x-radio-subContainer">
                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue341t4(e.target.value)}
                        value="option d"
                        name="141-t1"
                        type="radio"
                      />

                      <label className="c14x-radioLabel-style" for="141-t1">
                        D. Any one of the above
                      </label>
                    </div>

                    <div className="c14x-eachRadio-container">
                      <input
                        onChange={(e) => setValue341t5(e.target.value)}
                        value="option e"
                        name="141-t1"
                        type="radio"
                      />

                      <label className="c14x-radioLabel-style" for="141-t1">
                        E. None of the above
                      </label>
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
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            <div className="c34x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus346(!responseButtonStatus346);
                  onClickingViewResponse346();
                }}
                className="c34x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus346 ? (
                <p className="c34x-responseResult-style">{responseValue346}</p>
              ) : null}
            </div>
          </div>
        </form>
      </div>

      {/* Key Indicator: 3.4.7 */}
      <div className="c34x-eachInputField-container">
        <div className="c34x-weightage-container">
          <h1 className="c34x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c34x-container">
            <div className="c34x-heading_Help-container">
              <div>
                <h1 className="c34x-heading-style">
                  <span className="c34x-span-style">3.4.7: </span>
                  Bibliometrics of the publications during the last five years based on average Citation Index in Scopus/ Web of Science/PubMed
                </h1>
                <h1 className="c34x-heading-style">
                  <span className="c34x-span-style">3.4.7: </span>
                  Data to be provided for the last five years:                </h1>
                <p className="c34x-para-style">
                1. Title of the paper
                  <br />
                  2. Name of the author
                  <br />
                  3. Title of the journal
                  <br />
                  4.Year of publication
                  <br/>
                  5. Citation Index
                  
                </p>
                <div className="c34x-radio-container" style={{width:"200%"}}>
                  <div className="c34x-radio-subContainer" style={{width:"45%"}}>
                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue347t1(e.target.value)}
                        value="option a"
                        name="347-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="347-t1">
                     A. Any 5 or all of the above
                      </label>
                    </div>

                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue347t2(e.target.value)}
                        value="option b"
                        name="347-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="347-t1">
                      B. Any 4 of the above
                      </label>
                    </div>

                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue342t3(e.target.value)}
                        value="option c"
                        name="347-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="347-t1">
                      C. Any 3 of the above
                      </label>
                    </div>
                  </div>

                  <div className="c34x-radio-subContainer">
                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue342t4(e.target.value)}
                        value="option d"
                        name="347-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="347-t1">
                      D. Any 2 of the above
                      </label>
                    </div>

                    <div className="c34x-eachRadio-container">
                      <input
                        onChange={(e) => setValue347t5(e.target.value)}
                        value="option e"
                        name="347-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="347-t1">
                      E. None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen5}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen5}
                handleClose={handleHelpClose5}
                title='formula'
                ><h1>(Total number of Citation in SCOPUS in five years +Total number of Citation in Web of Science in five years)/(Total number of Publication in SCOPUS in five years +Total number of Publication in Web of Science in five years)</h1></HelpButton>
            </div>
            <div className="c34x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus347(!responseButtonStatus347);
                  onClickingViewResponse347();
                }}
                className="c34x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus347 ? (
                <p className="c34x-responseResult-style">{responseValue347}</p>
              ) : null}
            </div>
          </div>
          <table className="c34x-table-style">
            <tr>
              <th className="c34x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c34x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c34x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c34x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Any additional Information</td>
              <td></td>
              <td>
                {/* <input
                  onChange={(e) => {
                    setValue347f1(e.target.files[0]);
                    setPathValue347f1(e.target.value);
                  }}
                  id="347-f1"
                  type="file"
                  className="c34-fileButton-style"
                />
                {pathValue347f1 === '' ? null : (
                  <div className="c34-fileButtons-container">
                    <button className="c34-viewFileButton-style">
                      View File
                    </button>
                    <button className="c34-removeFileButton-style">
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
                id="347-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue347f1(e.target.files[0]);
                    setPathValue347f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue347f1}
              {pathValue347f1 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc347f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue347f1("");
                      document.getElementById("347-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c34x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Bibliometrics of the publications during the last five years</td>
              <td></td>
              <td>
                {/* <input
                  onChange={(e) => {
                    setValue347f2(e.target.files[0]);
                    setPathValue347f2(e.target.value);
                  }}
                  id="347-f2"
                  type="file"
                  className="c34-fileButton-style"
                />
                {pathValue347f2 === '' ? null : (
                  <div className="c34-fileButtons-container">
                    <button className="c34-viewFileButton-style">
                      View File
                    </button>
                    <button className="c34-removeFileButton-style">
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
                id="347-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue347f2(e.target.files[0]);
                    setPathValue347f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue347f2}
              {pathValue347f2 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc347f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue347f2("");
                      document.getElementById("347-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
              </td>
              <td className="c34x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>

        {/* <div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus341(true);
                setGradeScale341(radioMetricGradeCalculator(responseValue341));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Grade Scale
            </button>

            {gradeScaleClickStatus341 ? (
              <p className="c34x-responseResult-style">
                {radioMetricGradeCalculator(responseValue341)}
              </p>
            ) : null}
          </div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus341(true);
                setGradeScale341(radioMetricGradeCalculator(responseValue341));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Weighted Grade Points
            </button>
            {gradePointsClickStatus341 ? (
              <p className="c34x-responseResult-style">
                {metricGradePointsCalculator(gradeScale341, 5)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>

      {/* Key Indicator: 3.4.8 */}
      <div className="c34x-eachInputField-container">
        <div className="c34x-weightage-container">
          <h1 className="c34x-weightage-heading-style">Weightage: 15</h1>
        </div>
        <form>
          <div className="c34x-container">
            <div className="c34x-heading_Help-container">
              <h1 className="c34x-heading-style">
                <span className="c34x-span-style">3.4.8: </span>
                Bibliometrics of the publications during the last five years based on Scopus/ Web of Science – h-Index of the University
              </h1>
              <h1 className="c34x-heading-style">
                <span className="c34x-span-style">3.4.8: </span>
                Data to be provided for the last five years:            
                  </h1>
                  <p className="c34x-para-style">
                1. Title of the paper
                  <br />
                  2.Name of the author
                  <br />
                  3. Title of the journal
                  <br />
                  4.Year of publication
                  <br/>
                  5. H Index
                 
                </p>
                <div className="c34x-radio-container" style={{width:"200%"}}>
                  <div className="c34x-radio-subContainer" style={{width:"45%"}}>
                    <div className="c34x-eachRadio-container">
                    <input
                        onChange={(e) => setValue348t1(e.target.value)}
                        value="option a"
                        name="347-t1"
                        type="radio"
                      />

                     

                      <label className="c34x-radioLabel-style" for="347-t1">
                     A. Any 5 or all of the above
                      </label>
                    </div>

                    <div className="c34x-eachRadio-container">

                    <input
                        onChange={(e) => setValue348t2(e.target.value)}
                        value="option b"
                        name="347-t1"
                        type="radio"
                      />
                     

                      <label className="c34x-radioLabel-style" for="347-t2">
                      B. Any 4 of the above
                      </label>
                    </div>

                    <div className="c34x-eachRadio-container">
                    <input
                        onChange={(e) => setValue348t3(e.target.value)}
                        value="option c"
                        name="347-t1"
                        type="radio"
                      />
                     

                      <label className="c34x-radioLabel-style" for="347-t3">
                      C. Any 3 of the above
                      </label>
                    </div>
                  </div>

                  <div className="c34x-radio-subContainer">
                    <div className="c34x-eachRadio-container">
                    <input
                        onChange={(e) => setValue348t4(e.target.value)}
                        value="option d"
                        name="347-t1"
                        type="radio"
                      />
                     

                      <label className="c34x-radioLabel-style" for="347-t4">
                      D. Any 2 of the above
                      </label>
                    </div>

                    <div className="c34x-eachRadio-container">
                    <input
                        onChange={(e) => setValue348t5(e.target.value)}
                        value="option e"
                        name="347-t1"
                        type="radio"
                      />
                      

                      <label className="c34x-radioLabel-style" for="347-t5">
                      E. None of the above
                      </label>
                    </div>
                  </div>
                </div>
                <button
                onClick={handleHelpOpen6}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen6}
                handleClose={handleHelpClose6}
                title='formula'
                ><h1>(h – Index of Scopus + h – index of Web of Science in last five years)/2</h1></HelpButton>
            </div>
            <div className="c34x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus348(!responseButtonStatus348);
                  onClickingViewResponse348();
                }}
                className="c34x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus348 ? (
                <p className="c34x-responseResult-style">{responseValue348}</p>
              ) : null}
            </div>
          </div>
          <div className="c34xx-container">
            {/* <div className="c34xx-label-textInput-container">
              <h1 className="c34xx-Heading-style">
                <span className="c34xx-span-style">3.4.8.1: </span>
                Total Number of Citations in Scopus in 5 years
              </h1>
              <input
                onChange={(e) => setValue3481t1(e.target.value)}
                id="3481-t1"
                style={{ marginLeft: '12%' }}
                type="number"
                value={value3481t1}
              />
              {value3481t1 === '' ? <p style={{ color: 'red' }}>*</p> : null}
            </div>
            <div className="c34xx-label-textInput-container">
              <h1 className="c34xx-Heading-style">
                Total Number of Citations in Web of Science in 5 years
              </h1>
              <input
                onChange={(e) => setValue3481t2(e.target.value)}
                id="3481-t2"
                style={{ marginLeft: '12%' }}
                type="number"
                value={value3481t2}
              />
              {value3481t2 === '' ? <p style={{ color: 'red' }}>*</p> : null}
            </div>
            <div className="c34xx-label-textInput-container">
              <h1 className="c34xx-Heading-style">
                <span className="c34xx-span-style">3.4.8.2: </span>
                Total number of Publications in Scopus in 5 years
              </h1>
              <input
                onChange={(e) => setValue3482t1(e.target.value)}
                id="3482-t1"
                style={{ marginLeft: '9.5%' }}
                type="number"
                value={value3482t1}
              />
              {value3482t1 === '' ? <p style={{ color: 'red' }}>*</p> : null}
            </div>
            <div className="c34xx-label-textInput-container">
              <h1 className="c34xx-Heading-style">
                Total number of Publications in Web of Science in 5 years
              </h1>
              <input
                onChange={(e) => setValue3482t2(e.target.value)}
                id="3482-t2"
                style={{ marginLeft: '9.4%' }}
                type="number"
                value={value3482t2}
              />
              {value3482t2 === '' ? <p style={{ color: 'red' }}>*</p> : null}
            </div> */}

            <table className="c34x-table-style">
              <tr>
                <th className="c34x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c34x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c34x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c34x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Bibiliometrics of publications based on Scopus/ Web of Science - h-index of the Institution</td>
                <td></td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3482f1(e.target.files[0]);
                      setPathValue3482f1(e.target.value);
                    }}
                    id="3482-f1"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3482f1 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c34-removeFileButton-style">
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
                id="3482-f1"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3482f1(e.target.files[0]);
                    setPathValue3482f1(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3482f1}
              {pathValue3482f1 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc348f1}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3482f1("");
                      document.getElementById("3482-f1").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                Any additional information                </td>
                <td>
                <a href={downloadFile("un3.4.4.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  {/* <input
                    onChange={(e) => {
                      setValue3482f2(e.target.files[0]);
                      setPathValue3482f2(e.target.value);
                    }}
                    id="3482-f2"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue3482f2 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c34-removeFileButton-style">
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
                id="3482-f2"
                  accept="pdf"
                  style={{ display: "none" }}
                  onChange={(e) => {
                    setValue3482f2(e.target.files[0]);
                    setPathValue3482f2(e.target.value);
                    showFilePreview(e);
                  }}
                />
              </Button>
              {pathValue3482f2}
              {pathValue3482f2 === "" ? null : (
                <div className="c34-fileButtons-container">
                  <button
                    className="c34-viewFileButton-style"
                    style={{ height: "37px", width: "70px" }}
                  >
                    <a target="_openfile" href={filePreviewSrc348f2}>
                      {" "}
                      View File
                    </a>
                  </button>
                  <button
                    className="c34-removeFileButton-style"
                    onClick={(e) => {
                      setPathValue3482f2("");
                      document.getElementById("3482-f2").value = "";
                    }}
                    style={{ height: "37px", width: "70px" }}
                  >
                    Reset
                  </button>
                </div>
              )}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus345(true);
                setGradeScale345(numberMetricGradeCalculator(responseValue345));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Grade Scale
            </button>

            {gradeScaleClickStatus345 ? (
              <p className="c34x-responseResult-style">
                {numberMetricGradeCalculator(responseValue345)}
              </p>
            ) : null}
          </div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus345(true);
                setGradeScale343(numberMetricGradeCalculator(responseValue345));
              }}
              style={{
                backgroundColor: 'white',
                borderWidth: '1px',
                borderStyle: 'solid',
                borderColor: '#02334d',
                marginRight: '2%',
              }}
            >
              Weighted Grade Points
            </button>
            {gradePointsClickStatus345 ? (
              <p className="c34x-responseResult-style">
                {metricGradePointsCalculator(gradeScale345, 5)}
              </p>
            ) : null}
          </div>
        </div> */}
        {/* <p>  * The Data obtained from inflibnet will be used for the purposes of calculation
of scores.</p> */}
      </div>

      
      <div className="c34x-button-container">
        <button onClick={onClickingSave} className="c34x-button-style">
         Modify
        </button>
      </div>
    </div>
  );
}

export default Criteria34;
