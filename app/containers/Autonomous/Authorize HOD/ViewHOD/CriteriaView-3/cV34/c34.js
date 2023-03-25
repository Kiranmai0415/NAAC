import React, { useState, useEffect } from 'react';
import './c34-style.css';

import {toast} from "react-toastify";
import AuthService from '../../../../../Pages/Users/services/auth.service';
import { HelpButton } from "../../../../../../reusableComponents/model/Help";
import { resources } from "../../../../../appConstants";

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

function Help341(props) {
  return props.isHelp341Clicked ? (
    <div className="c34x-help-mainContainer">
      <div className="c34x-help-subContainer">
        <h1 className="c34x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c34x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
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
          Ph.Ds are registered within last 5 years{' '}
          <span style={{ fontWeight: 'bold' }}> / </span>Number of teachers
          recognized as guides during the last five years Data Requirements for
          last five years
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
          Number of research papers in the Journals notified on UGC website
          during the last five years{' '}
          <span style={{ fontWeight: 'bold' }}> / </span>
          Average number of full time teachers during last five years
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
          Total number of books and chapters in edited volumes / books
          published, and papers in national/international conference-proceedings
          year wise during last five years
          <span style={{ fontWeight: 'bold' }}> / </span>
          Average number of full time teachers during last five years
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
          <span style={{ fontWeight: 'bold' }}> ( </span>
          Total number of Citations in Scopus in 5 years
        </p>
        <span style={{ fontWeight: 'bold' }}> + </span>Total number of Citations
        in Web of Science in 5 years
        <span style={{ fontWeight: 'bold' }}>) / ( </span>Total number of
        Publications in Scopus in 5 years
        <span style={{ fontWeight: 'bold' }}> + </span> Total number of
        Publications in Web of Science in 5 years
        <span style={{ fontWeight: 'bold' }}> ) </span>
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
          h-index of Scopus during the last five years
          <span style={{ fontWeight: 'bold' }}> + </span>
          h-index of Web of Science during the last five years
          <span style={{ fontWeight: 'bold' }}> / </span>2
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

function Criteria34() {
  // getfile data with API
  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL + "download/" + fileName;
    return filePath;
  }
 //help buttom
  const [isOpen, setIsopen] = useState(false)
  const [isOpen2,setIsopen2] = useState(false)
  const [isOpen3, setIsopen3] = useState(false)
  const [isOpen4,setIsopen4] = useState(false)
  const [isOpen5, setIsopen5] = useState(false)
  const [isOpen6,setIsopen6] = useState(false)
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
  const handleHelpOpen3 = (e) => {
    e.preventDefault(),
    setIsopen3(true)
  }
  const handleHelpClose3 = () => {
    setIsopen3(false)
  }
  const handleHelpOpen4 =(e)=>{
    e.preventDefault();
    setIsopen4(true)
  } 
  const handleHelpClose4 = (e)=>{
    setIsopen4(false)
  }
  const handleHelpOpen5 = (e) => {
    e.preventDefault(),
    setIsopen5(true)
  }
  const handleHelpClose5 = () => {
    setIsopen5(false)
  }
  const handleHelpOpen6 =(e)=>{
    e.preventDefault();
    setIsopen6(true)
  } 
  const handleHelpClose6 = (e)=>{
    setIsopen6(false)
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

  const [value3421t1, setValue3421t1] = useState();
  const [value3422t1, setValue3422t1] = useState();
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
  const [value3431t11, setValue3431t11] = useState();
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
  const [value3441f1, setValue3441f1] = useState('');
  const [pathValue3441f1, setPathValue3441f1] = useState('');
  const [value3441f2, setValue3441f2] = useState('');
  const [pathValue3441f2, setPathValue3441f2] = useState('');
  const [responseButtonStatus344, setResponseButtonStatus344] = useState(false);
  const [responseValue344, setResponseValue344] = useState('');
  const [help344Status, setHelp344Status] = useState(false);

  const [value3451t1, setValue3451t1] = useState();
  const [value3451t2, setValue3451t2] = useState();
  const [value3452t1, setValue3452t1] = useState();
  const [value3452t2, setValue3452t2] = useState();
  const [value345f1, setValue345f1] = useState('');
  const [pathValue345f1, setPathValue345f1] = useState('');
  const [value345f2, setValue345f2] = useState('');
  const [pathValue345f2, setPathValue345f2] = useState('');
  const [responseButtonStatus345, setResponseButtonStatus345] = useState(false);
  const [responseValue345, setResponseValue345] = useState('');
  const [help345Status, setHelp345Status] = useState(false);

  const [value3461t1, setValue3461t1] = useState();
  const [value3461t2, setValue3461t2] = useState();
  const [value346f1, setValue346f1] = useState('');
  const [pathValue346f1, setPathValue346f1] = useState('');
  const [value346f2, setValue346f2] = useState('');
  const [pathValue346f2, setPathValue346f2] = useState('');
  const [responseButtonStatus346, setResponseButtonStatus346] = useState(false);
  const [responseValue346, setResponseValue346] = useState('');
  const [help346Status, setHelp346Status] = useState(false);
 
 
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
    () => fetch('http://localhost:8080/api/v1/criteria3getallfiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));

           setValue341t1(data[0].criteria34Ql[0] ? data[0].criteria34Ql[0].input341t1 : "");

          setValue3421t1(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input3421t1 : "");
          setValue3422t1(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input3422t1 : "");
          // setValue341t1(data[0].criteria34Qn[0].input342t1);
          setValue3441t11(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input3441t11 : "");
          setValue3451t1(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input3451t1 : "");
          setValue3451t2(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input3451t2 : "");
          setValue3452t1(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input3452t1 : "");
          setValue3452t2(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input3452t2 : "");
          setValue3461t1(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input3461t1 : "");
          setValue3461t2(data[0].criteria34Qn[0] ? data[0].criteria34Qn[0].input3461t2 : "");

          // setResponseValue111(data[0].criteria1FieldInfoQl[1].response111);
          // setResponseValue112(data[0].criteria1FieldInfoQn[2].response112);
          // setResponseValue113(data[0].criteria1FieldInfoQn[3].response113);

          setValue3431t1(data[0].yearTable3431[0] ? data[0].yearTable3431[0].input3431y : "");
          setValue3431t2(data[0].yearTable3431[1] ? data[0].yearTable3431[1].input3431y : "");
          setValue3431t3(data[0].yearTable3431[2] ? data[0].yearTable3431[2].input3431y : "");
          setValue3431t4(data[0].yearTable3431[3] ? data[0].yearTable3431[3].input3431y : "");
          setValue3431t5(data[0].yearTable3431[4] ? data[0].yearTable3431[4].input3431y : "");
          setValue3431t6(data[0].yearTable3431[0] ? data[0].yearTable3431[0].input3431v : "");
          setValue3431t7(data[0].yearTable3431[1] ? data[0].yearTable3431[1].input3431v : "");
          setValue3431t8(data[0].yearTable3431[2] ? data[0].yearTable3431[2].input3431v : "");
          setValue3431t9(data[0].yearTable3431[3] ? data[0].yearTable3431[3].input3431v : "");
          setValue3431t10(data[0].yearTable3431[4] ? data[0].yearTable3431[4].input3431v : "");
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

          setValue3441f1(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
          setValue3441f2(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
          setValue345f1(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
          setValue345f2(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
          setValue346f1(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
          setValue346f2(data[0].criteria3FileUpload[0] ? data[0].criteria3FileUpload[0].criteria3FileName : "");
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
    if (
      value3421t1 === ''
      || value3422t1 === ''
      || value3421t1 === undefined
      || value3422t1 === undefined
    ) {
      setResponseValue342('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3421t1, 10)) === false
      || Number.isInteger(parseInt(value3422t1, 10)) === false
    ) {
      setResponseValue342('Input should be an Integer');
    } else if (value3421t1 !== '' && value3422t1 !== '') {
      setResponseValue342(
        parseInt(value3421t1, 10) / parseInt(value3422t1, 10)
      );
    }
  }
  function onClickingViewResponse343() {
    if (
      value3431t6 === ''
      || value3431t7 === ''
      || value3431t8 === ''
      || value3431t9 === ''
      || value3431t10 === ''
      || value3431t11 === ''
      || value3431t6 === undefined
      || value3431t7 === undefined
      || value3431t8 === undefined
      || value3431t9 === undefined
      || value3431t10 === undefined
      || value3431t11 === undefined
    ) {
      setResponseValue343('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3431t6, 10)) === false
      || Number.isInteger(parseInt(value3431t7, 10)) === false
      || Number.isInteger(parseInt(value3431t8, 10)) === false
      || Number.isInteger(parseInt(value3431t9, 10)) === false
      || Number.isInteger(parseInt(value3431t10, 10)) === false
      || Number.isInteger(parseInt(value3431t11, 10)) === false
    ) {
      setResponseValue343('Input should be an Integer');
    } else if (
      value3431t6 !== ''
      && value3431t7 !== ''
      && value3431t8 !== ''
      && value3431t9 !== ''
      && value3431t10 !== ''
      && value3431t11 !== ''
    ) {
      setResponseValue343(
        (parseInt(value3431t6, 10)
          + parseInt(value3431t7, 10)
          + parseInt(value3431t8, 10)
          + parseInt(value3431t9, 10)
          + parseInt(value3431t10, 10))
          / parseInt(value3431t11, 10)
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
      || value3441t11 === ''
      || value3441t6 === undefined
      || value3441t7 === undefined
      || value3441t8 === undefined
      || value3441t9 === undefined
      || value3441t10 === undefined
      || value3441t11 === undefined
    ) {
      setResponseValue344('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3441t6, 10)) === false
      || Number.isInteger(parseInt(value3441t7, 10)) === false
      || Number.isInteger(parseInt(value3441t8, 10)) === false
      || Number.isInteger(parseInt(value3441t9, 10)) === false
      || Number.isInteger(parseInt(value3441t10, 10)) === false
      || Number.isInteger(parseInt(value3441t11, 10)) === false
    ) {
      setResponseValue344('Input should be an Integer');
    } else if (
      value3441t6 !== ''
      && value3441t7 !== ''
      && value3441t8 !== ''
      && value3441t9 !== ''
      && value3441t10 !== ''
      && value3441t11 !== ''
    ) {
      setResponseValue344(
        (parseInt(value3441t6, 10)
          + parseInt(value3441t7, 10)
          + parseInt(value3441t8, 10)
          + parseInt(value3441t9, 10)
          + parseInt(value3441t10, 10))
          / parseInt(value3441t11, 10)
      );
    }
  }
  function onClickingViewResponse345() {
    if (
      value3451t1 === ''
      || value3451t2 === ''
      || value3452t1 === ''
      || value3452t2 === ''
      || value3451t1 === undefined
      || value3451t2 === undefined
      || value3452t1 === undefined
      || value3452t2 === undefined
    ) {
      setResponseValue345('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3451t1, 10)) === false
      || Number.isInteger(parseInt(value3451t2, 10)) === false
      || Number.isInteger(parseInt(value3452t1, 10)) === false
      || Number.isInteger(parseInt(value3452t2, 10)) === false
    ) {
      setResponseValue345('Input should be an Integer');
    } else if (
      value3451t1 !== ''
      && value3451t2 !== ''
      && value3452t1 !== ''
      && value3452t2 !== ''
    ) {
      setResponseValue345(
        (0.5 * parseInt(value3451t1, 10) + 0.5 * parseInt(value3451t2, 10))
          / (0.5 * parseInt(value3452t1, 10) + 0.5 * parseInt(value3452t2, 10))
      );
    }
  }
  function onClickingViewResponse346() {
    if (
      value3461t1 === ''
      || value3461t2 === ''
      || value3461t1 === undefined
      || value3461t2 === undefined
    ) {
      setResponseValue346('Please fill the required fields');
    } else if (
      Number.isInteger(parseInt(value3461t1, 10)) === false
      || Number.isInteger(parseInt(value3461t2, 10)) === false
    ) {
      setResponseValue346('Input should be an Integer');
    } else if (value3461t1 !== '' && value3461t2 !== '') {
      setResponseValue346(
        (parseInt(value3461t1, 10) + parseInt(value3461t2, 10)) / 2
      );
    }
  }

  
  // sending data to db with API
 
  const inputDataList = {
    criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
    criteria34Ql: [
       {
      criteriaId: {collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
      uniqueKey1: 1,
      input341t1: value341t1,
    },
    ],
    criteria34Qn: [
      {
        criteriaId: {collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
        uniqueKey1: 1,
        input3421t1: value3421t1,
        input3422t1: value3422t1,
    
        input3441t11: value3441t11,
        input3451t1: value3451t1,
        input3451t2: value3451t2,
        input3452t1: value3452t1,
        input3452t2: value3452t2,
        input3461t1: value3461t1,
        input3461t2: value3461t2,

        response341: responseValue341,
        response342: responseValue342,
        response343: responseValue343,
        response344: responseValue344,
        response345: responseValue345,
        response346: responseValue346,
      },
    ],

    yearTable3431: [
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 1, input3431y: value3431t1, input3431v: value3431t6
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 2, input3431y: value3431t2, input3431v: value3431t7
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 3, input3431y: value3431t3, input3431v: value3431t8
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 4, input3431y: value3431t4, input3431v: value3431t9
      },
      {
        criteriaId: {collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 5, input3431y: value3431t5, input3431v: value3431t10
      },
    ],
    yearTable3441: [
      {
        criteriaId: {collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 1, input3441y: value3441t1, input3441v: value3441t6
      },
      {
        criteriaId: {collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 2, input3441y: value3441t2, input3441v: value3441t7
      },
      {
        criteriaId: {collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 3, input3441y: value3441t3, input3441v: value3441t8
      },
      {
        criteriaId: {collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType },
         uniqueKey1: 4, input3441y: value3441t4, input3441v: value3441t9
      },
      {
        criteriaId: { collegeId:collegeId, financialYear: fYear, typeofInstitution: instituteType  },
         uniqueKey1: 5, input3441y: value3441t5, input3441v: value3441t10
      },
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
    if (pathValue346f1 !== '') {
      form34Data.append('uploadfile3', value346f1, 'f346f1-' + value346f1.name);
    }
    if (pathValue3441f2 !== '') {
      form34Data.append('uploadfile3', value346f2, 'f346f2-' + value346f2.name);
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
                  The Institution ensures implementation of its stated Code of Ethics for research<br/>
                  The institution has a stated Code of Ethics for research and the implementation of which is ensured through the following:
                </h1>
                <p className="c34x-para-style">
                1. Inclusion of research ethics in the research methodology course work
                  <br />
                  2. Presence of institutional Ethics committee (Animal, Chemical, Bio-ethics etc.)
                  <br />
                  3. Plagiarism check through software
                  <br />
                  4. Research Advisory Committee
                </p>
                <div className="c34x-radio-container">
                  <div className="c34x-radio-subContainer" style={{width:"45%"}}>
                    <div className="c34x-eachRadio-container">
                      <input readonly
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
                      <input readonly
                        onChange={(e) => setValue341t1(e.target.value)}
                        value="option b"
                        name="341-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="341-t2">
                        B. Any three of the above
                      </label>
                    </div>

                    <div className="c34x-eachRadio-container">
                      <input readonly
                        onChange={(e) => setValue341t1(e.target.value)}
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
                      <input readonly
                        onChange={(e) => setValue341t1(e.target.value)}
                        value="option d"
                        name="341-t1"
                        type="radio"
                      />

                      <label className="c34x-radioLabel-style" for="341-t4">
                        D. Any one of the above
                      </label>
                    </div>

                    <div className="c34x-eachRadio-container">
                      <input readonly
                        onChange={(e) => setValue341t1(e.target.value)}
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
                title='Upload the specific document as per description given'
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
              <td>Link for additional information</td>
              <td></td>
              <td>
                <input readonly
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
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue341f1("");
                      document.getElementById("341-f1").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                <a href={downloadFile(value341f1)} target="_blank">View File</a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c34x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any additional information</td>
              <td></td>
              <td>
                <input readonly
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
                    <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue341f2("");
                      document.getElementById("341-f2").value="" }} >
                       Reset                     
                     </button>
                  </div>
                )}
                 <a href={downloadFile(value341f2)} target="_blank">View File</a>
                 {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
              </td>
              <td className="c34x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 3.4.2 */}
      <div className="c34x-eachInputField-container">
        <div className="c34x-weightage-container">
          <h1 className="c34x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c34x-container">
            <div className="c34x-heading_Help-container">
              <h1 className="c34x-heading-style">
                <span className="c34x-span-style">3.4.2: </span>
                Number of candidates registered for Ph.D per teacher (as per the data given w.r.t recognized Ph.D guides/ supervisors provided at 3.2.3 metric) during the last five years
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
                ><h1>(Number of candidates registered for Ph.Dduring the last five years)/(Number of recognised guides during last five years)</h1></HelpButton>
            </div>
            <div className="c34x-response-container">
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
            </div>
          </div>
          <div className="c34xx-container">
            <div className="c34xx-label-textInput-container">
              <h1 className="c34xx-Heading-style">
                <span className="c34xx-span-style">3.4.2.1: </span>
                How many Ph.Ds are registered within last 5 years
              </h1>
              <input readonly
                onChange={(e) => setValue3421t1(e.target.value)}
                id="3421-t1"
                style={{width:"25%" , marginLeft: '18%' }}
                type="number"
                value={value3421t1}
              />
              {value3421t1 === '' ? (
                <p style={{ color: 'red' }}>Required*</p>
              ) : null}
            </div>
            <div className="c34xx-label-textInput-container">
              <h1 className="c34xx-Heading-style">
                <span className="c34xx-span-style">3.4.2.2: </span>
                Number of teachers recognized as guides during the last five
                years
              </h1>
              <input readonly
                onChange={(e) => setValue3422t1(e.target.value)}
                id="3422-t1"
                style={{width:"25%" , marginLeft: '4%' }}
                type="number"
                value={value3422t1}
              />
              {value3422t1 === '' ? <p style={{ color: 'red' }}>*</p> : null}
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
                <td>URL to the research page on HEI web site</td>
                <td></td>
                <td>
                  <input readonly
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
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue342f1("");
                      document.getElementById("342-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value342f1)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List of PhD scholars and their details like name of the guide
                  , title of thesis, year of award etc
                </td>
                <td></td>
                <td>
                  <input readonly
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
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue342f2("");
                      document.getElementById("342-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                   <a href={downloadFile(value342f2)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
                </td>
                <td className="c31x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
        {/* <div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradeScaleClickStatus342(true);
                setGradeScale342(numberMetricGradeCalculator(responseValue342));
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

            {gradeScaleClickStatus342 ? (
              <p className="c34x-responseResult-style">
                {numberMetricGradeCalculator(responseValue342)}
              </p>
            ) : null}
          </div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus342(true);
                setGradeScale342(numberMetricGradeCalculator(responseValue342));
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
            {gradePointsClickStatus342 ? (
              <p className="c34x-responseResult-style">
                {metricGradePointsCalculator(gradeScale342, 5)}
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
                ><h1>(Total number of research papers in the journals notified on UGC CARE list during the last five years)/(Number of full time teachers (without repeat count)during the last five years)</h1></HelpButton>
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
              Number of research papers in the Journals notified on UGC website
              during the last five years
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
                    <input readonly
                      onChange={(e) => setValue3431t1(e.target.value)}
                      id="3431-t1"
                      className="c34x-input-style"
                      type="text"
                      value={value3431t1}
                    />
                    {value3431t1 === '' ? (
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
                    <input readonly
                      onChange={(e) => setValue3431t2(e.target.value)}
                      id="3431-t2"
                      className="c34x-input-style"
                      type="text"
                      value={value3431t2}
                    />
                    {value3431t2 === '' ? (
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
                    <input readonly
                      onChange={(e) => setValue3431t3(e.target.value)}
                      id="3431-t3"
                      className="c34x-input-style"
                      type="text"
                      value={value3431t3}
                    />
                    {value3431t3 === '' ? (
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
                    <input readonly
                      onChange={(e) => setValue3431t4(e.target.value)}
                      id="3431-t4"
                      className="c34x-input-style"
                      type="text"
                      value={value3431t4}
                    />
                    {value3431t4 === '' ? (
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
                    <input readonly
                      onChange={(e) => setValue3431t5(e.target.value)}
                      id="3431-t5"
                      className="c34x-input-style"
                      type="text"
                      value={value3431t5}
                    />
                    {value3431t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c34x-horizontalTable-heading-style">
                  Number
                </th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input readonly
                      onChange={(e) => setValue3431t6(e.target.value)}
                      id="3431-t6"
                      className="c34x-input-style"
                      type="text"
                      value={value3431t6}
                    />
                    {value3431t6 === '' ? (
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
                    <input readonly
                      onChange={(e) => setValue3431t7(e.target.value)}
                      id="3431-t7"
                      className="c34x-input-style"
                      type="text"
                      value={value3431t7}
                    />
                    {value3431t7 === '' ? (
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
                    <input readonly
                      onChange={(e) => setValue3431t8(e.target.value)}
                      id="3431-t8"
                      className="c34x-input-style"
                      type="text"
                      value={value3431t8}
                    />
                    {value3431t8 === '' ? (
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
                    <input readonly
                      onChange={(e) => setValue3431t9(e.target.value)}
                      id="3431-t9"
                      className="c34x-input-style"
                      type="text"
                      value={value3431t9}
                    />
                    {value3431t9 === '' ? (
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
                    <input readonly
                      onChange={(e) => setValue3431t10(e.target.value)}
                      id="3431-t10"
                      className="c34x-input-style"
                      type="text"
                      value={value3431t10}
                    />
                    {value3431t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>

            <div className="c31xx-label-textInput-container">
              <label className="c31xx-Heading-style">
                Average number of full time teachers during the last five years
              </label>
              <input readonly
                onChange={(e) => setValue3431t11(e.target.value)}
                id="3431-t11"
                style={{ marginLeft: '12%' }}
                type="number"
                value={value3431t11}
              />
              {value3431t11 === '' ? <p style={{ color: 'red' }}>*</p> : null}
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
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input readonly
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
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3431f1("");
                      document.getElementById("3431-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3431f1)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List of research papers by title, author, department, name and
                  year of publication
                </td>
                <td>
                <a href={downloadFile("au3.4.2.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                  <input readonly
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
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3431f2("");
                      document.getElementById("3431-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3431f2)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
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
          <h1 className="c34x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c34x-container">
            <div className="c34x-heading_Help-container">
              <h1 className="c34x-heading-style">
                <span className="c34x-span-style">3.4.4: </span>
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
                ><h1>(Total number of books and chapters in edited volumes published during the last five years)/(Number of full time teachers (without repeat count)during the last five years)</h1></HelpButton>
            </div>
            <div className="c34x-response-container">
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
            </div>
          </div>
          <div className="c34xx-container">
            <h1 className="c34xx-Heading-style">
              <span className="c34xx-span-style">3.4.4.1: </span>
              Total number of books and chapters in edited volumes/books
              published and papers in national/ international conference
              proceedings year-wise during last five years
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
                    <input readonly
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
                    <input readonly
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
                    <input readonly
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
                    <input readonly
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
                    <input readonly
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
                <th className="c34x-horizontalTable-heading-style">
                  Number
                </th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input readonly
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
                    <input readonly
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
                    <input readonly
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
                    <input readonly
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
                    <input readonly
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

            <div className="c34xx-label-textInput-container">
              <label className="c34xx-Heading-style">
                Average number of full time teachers during the last five years
              </label>
              <input readonly
                onChange={(e) => setValue3441t11(e.target.value)}
                id="3441-t11"
                style={{ marginLeft: '8%' }}
                type="number"
                value={value3441t11}
              />
              {value3441t11 === '' ? <p style={{ color: 'red' }}>*</p> : null}
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
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input readonly
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
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3441f1("");
                      document.getElementById("3441-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3441f1)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  List books and chapters in edited volumes / books published
                </td>
                <td>
                <a href={downloadFile("au3.4.3.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                  <input readonly
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
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue3441f2("");
                      document.getElementById("3441-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value3441f2)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
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
          <h1 className="c34x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c34x-container">
            <div className="c34x-heading_Help-container">
              <h1 className="c34x-heading-style">
                <span className="c34x-span-style">3.4.5: </span>
                Bibliometrics of the publications during the last five years based on average Citation index in Scopus/ Web of Science
              </h1>
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
                ><h1>(Total number of Citation in SCOPUS in five years + Total number of Citation in Web of Science in five years )/(Total number of Publication in SCOPUS in five years +Total number of Publication in Web of Science in five years)</h1></HelpButton>
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
            <div className="c34xx-label-textInput-container">
              <h1 className="c34xx-Heading-style">
                <span className="c34xx-span-style">3.4.5.1: </span>
                Total Number of Citations in Scopus in 5 years
              </h1>
              <input readonly
                onChange={(e) => setValue3451t1(e.target.value)}
                id="3451-t1"
                style={{ marginLeft: '11.5%' }}
                type="number"
                value={value3451t1}
              />
              {value3451t1 === '' ? <p style={{ color: 'red' }}>*</p> : null}
            </div>
            <div className="c34xx-label-textInput-container">
              <h1 className="c34xx-Heading-style">
                Total Number of Citations in Web of Science in 5 years
              </h1>
              <input readonly
                onChange={(e) => setValue3451t2(e.target.value)}
                id="3451-t2"
                style={{ marginLeft: '11.4%' }}
                type="number"
                value={value3451t2}
              />
              {value3451t2 === '' ? <p style={{ color: 'red' }}>*</p> : null}
            </div>
            <div className="c34xx-label-textInput-container">
              <h1 className="c34xx-Heading-style">
                <span className="c34xx-span-style">3.4.5.2: </span>
                Total number of Publications in Scopus in 5 years
              </h1>
              <input readonly
                onChange={(e) => setValue3452t1(e.target.value)}
                id="3452-t1"
                style={{ marginLeft: '9.2%' }}
                type="number"
                value={value3452t1}
              />
              {value3452t1 === '' ? <p style={{ color: 'red' }}>*</p> : null}
            </div>
            <div className="c34xx-label-textInput-container">
              <h1 className="c34xx-Heading-style">
                Total number of Publications in Web of Science in 5 years
              </h1>
              <input readonly
                onChange={(e) => setValue3452t2(e.target.value)}
                id="3452-t2"
                style={{ marginLeft: '9%' }}
                type="number"
                value={value3452t2}
              />
              {value3452t2 === '' ? <p style={{ color: 'red' }}>*</p> : null}
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
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input readonly
                    onChange={(e) => {
                      setValue345f1(e.target.files[0]);
                      setPathValue345f1(e.target.value);
                    }}
                    id="345-f1"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue345f1 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue345f1("");
                      document.getElementById("345-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value345f1)} target="_blank">View File</a>
                  {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Bibliometrics of the publications during the last five years
                </td>
                <td>
                <a href={downloadFile("au3.4.4.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                  <input readonly
                    onChange={(e) => {
                      setValue345f2(e.target.files[0]);
                      setPathValue345f2(e.target.value);
                    }}
                    id="345-f2"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue345f2 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue345f2("");
                      document.getElementById("345-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                   <a href={downloadFile(value345f2)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
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
      </div>

      {/* Key Indicator: 3.4.6 */}
      <div className="c34x-eachInputField-container">
        <div className="c34x-weightage-container">
          <h1 className="c34x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c34x-container">
            <div className="c34x-heading_Help-container">
              <h1 className="c34x-heading-style">
                <span className="c34x-span-style">3.4.6: </span>
                Bibliometrics of the publications during the last five years based on Scopus/ Web of Science ? h-index of the Institutio
              </h1>
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
                ><h1>(h – Index (Scopus)+ h – index (Web of Science) ???????????? ??h?? last five years) / 2</h1></HelpButton>
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
          <div className="c34xx-container">
            <div className="c34xx-label-textInput-container">
              <h1 className="c34xx-Heading-style">
                <span className="c34xx-span-style">3.4.6.1: </span>
                h-index of Scopus during the last five years
              </h1>
              <input readonly
                onChange={(e) => setValue3461t1(e.target.value)}
                id="3461-t1"
                style={{ marginLeft: '10.2%' }}
                type="number"
                value={value3461t1}
              />
              {value3461t1 === '' ? <p style={{ color: 'red' }}>*</p> : null}
            </div>
            <div className="c34xx-label-textInput-container">
              <h1 className="c34xx-Heading-style">
                h-index of Web of Science during the last five years
              </h1>
              <input readonly
                onChange={(e) => setValue3461t2(e.target.value)}
                id="3461-t2"
                style={{ marginLeft: '10%' }}
                type="number"
                value={value3461t2}
              />
              {value3461t2 === '' ? <p style={{ color: 'red' }}>*</p> : null}
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
                <td>
                  Bibiliometrics of publications based on Scopus/ Web of Science
                  - h-index of the Institution
                </td>
                <td>
                <a href={downloadFile("au3.4.4.xlsx")} target="_blank">View Template</a>
                </td>
                <td>
                  <input readonly
                    onChange={(e) => {
                      setValue346f1(e.target.files[0]);
                      setPathValue346f1(e.target.value);
                    }}
                    id="346-f1"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue346f1 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue346f1("");
                      document.getElementById("346-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                   <a href={downloadFile(value346f1)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
                </td>
                <td className="c34x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input readonly
                    onChange={(e) => {
                      setValue346f2(e.target.files[0]);
                      setPathValue346f2(e.target.value);
                    }}
                    id="346-f2"
                    type="file"
                    className="c34-fileButton-style"
                  />
                  {pathValue346f2 === '' ? null : (
                    <div className="c34-fileButtons-container">
                      <button className="c34-viewFileButton-style">
                        View File
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue346f2("");
                      document.getElementById("346-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                  <a href={downloadFile(value346f2)} target="_blank">View File</a>
                   {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
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
                setGradeScaleClickStatus346(true);
                setGradeScale346(numberMetricGradeCalculator(responseValue346));
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

            {gradeScaleClickStatus346 ? (
              <p className="c34x-responseResult-style">
                {numberMetricGradeCalculator(responseValue346)}
              </p>
            ) : null}
          </div>
          <div className="c34x-response-container">
            <button
              onClick={() => {
                setGradePointsClickStatus346(true);
                setGradeScale346(numberMetricGradeCalculator(responseValue346));
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
            {gradePointsClickStatus346 ? (
              <p className="c34x-responseResult-style">
                {metricGradePointsCalculator(gradeScale346, 5)}
              </p>
            ) : null}
          </div>
        </div> */}
      </div>
    </div>
  );
}

export default Criteria34;
