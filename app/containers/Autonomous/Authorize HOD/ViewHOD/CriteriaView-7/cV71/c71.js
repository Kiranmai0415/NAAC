import React, { useState, useEffect } from "react";
import "./c71-style.css";

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

function Help711(props) {
  return props.isHelp711Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp711Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help712(props) {
  return props.isHelp712Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp712Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help713(props) {
  return props.isHelp713Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp713Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help714(props) {
  return props.isHelp714Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp714Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help715(props) {
  return props.isHelp715Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp715Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help716(props) {
  return props.isHelp716Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp716Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help717(props) {
  return props.isHelp717Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp717Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help718(props) {
  return props.isHelp718Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp718Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help719(props) {
  return props.isHelp719Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp719Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help7110(props) {
  return props.isHelp7110Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp7110Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help7111(props) {
  return props.isHelp7111Clicked ? (
    <div className="c71x-help-mainContainer">
      <div className="c71x-help-subContainer">
        <h1 className="c71x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c71x-help-para-style">
          Justify that the college satisfies the metric. Describe it in maximum
          500 words.
        </p>
        <button
          className="c71x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp7111Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}

function Criteria71() {
  //help buttom
  const [isOpen, setIsopen] = useState(false)
  const [isOpen2,setIsopen2] = useState(false)
  const [isOpen3, setIsopen3] = useState(false)
  const [isOpen4,setIsopen4] = useState(false)
  const [isOpen5, setIsopen5] = useState(false)
  const [isOpen6,setIsopen6] = useState(false)
  const [isOpen7, setIsopen7] = useState(false)
  const [isOpen8,setIsopen8] = useState(false)
  const [isOpen9, setIsopen9] = useState(false)
  const [isOpen10,setIsopen10] = useState(false)
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
  const handleHelpOpen7 = (e) => {
    e.preventDefault(),
    setIsopen7(true)
  }
  const handleHelpClose7 = () => {
    setIsopen7(false)
  }
  const handleHelpOpen8 =(e)=>{
    e.preventDefault();
    setIsopen8(true)
  } 
  const handleHelpClose8 = (e)=>{
    setIsopen8(false)
  }
  const handleHelpOpen9= (e) => {
    e.preventDefault(),
    setIsopen9(true)
  }
  const handleHelpClose9 = () => {
    setIsopen9(false)
  }
  const handleHelpOpen10 =(e)=>{
    e.preventDefault();
    setIsopen10(true)
  } 
  const handleHelpClose10 = (e)=>{
    setIsopen10(false)
  }
  const [value711t1, setValue711t1] = useState();
  const [value711f1, setValue711f1] = useState("");
  const [pathValue711f1, setPathValue711f1] = useState("");
  const [value711f2, setValue711f2] = useState("");
  const [pathValue711f2, setPathValue711f2] = useState("");
  const [responseValue711, setResponseValue711] = useState("");
  const [help711Status, setHelp711Status] = useState(false);

  const [value712t1, setValue712t1] = useState();
  const [value712f1, setValue712f1] = useState("");
  const [pathValue712f1, setPathValue712f1] = useState("");
  const [value712f2, setValue712f2] = useState("");
  const [pathValue712f2, setPathValue712f2] = useState("");
  const [responseButtonStatus712, setResponseButtonStatus712] = useState(false);
  const [responseValue712, setResponseValue712] = useState("");
  const [help712Status, setHelp712Status] = useState(false);

  const [value713t1, setValue713t1] = useState();
  const [value713f1, setValue713f1] = useState("");
  const [pathValue713f1, setPathValue713f1] = useState("");
  const [value713f2, setValue713f2] = useState("");
  const [pathValue713f2, setPathValue713f2] = useState("");
  const [value713f3, setValue713f3] = useState("");
  const [pathValue713f3, setPathValue713f3] = useState("");
  const [responseValue713, setResponseValue713] = useState("");
  const [help713Status, setHelp713Status] = useState(false);

  const [value714t1, setValue714t1] = useState();
  const [value714f1, setValue714f1] = useState("");
  const [pathValue714f1, setPathValue714f1] = useState("");
  const [value714f2, setValue714f2] = useState("");
  const [pathValue714f2, setPathValue714f2] = useState("");
  const [responseButtonStatus714, setResponseButtonStatus714] = useState(false);
  const [responseValue714, setResponseValue714] = useState("");
  const [help714Status, setHelp714Status] = useState(false);

  const [value715t1, setValue715t1] = useState();
  const [value715f1, setValue715f1] = useState("");
  const [pathValue715f1, setPathValue715f1] = useState("");
  const [value715f2, setValue715f2] = useState("");
  const [pathValue715f2, setPathValue715f2] = useState("");
  const [value715f3, setValue715f3] = useState("");
  const [pathValue715f3, setPathValue715f3] = useState("");
  const [responseButtonStatus715, setResponseButtonStatus715] = useState(false);
  const [responseValue715, setResponseValue715] = useState("");
  const [help715Status, setHelp715Status] = useState(false);

  const [value716t1, setValue716t1] = useState();
  const [value716f1, setValue716f1] = useState("");
  const [pathValue716f1, setPathValue716f1] = useState("");
  const [value716f2, setValue716f2] = useState("");
  const [pathValue716f2, setPathValue716f2] = useState("");
  const [value716f3, setValue716f3] = useState("");
  const [pathValue716f3, setPathValue716f3] = useState("");
  const [value716f4, setValue716f4] = useState("");
  const [pathValue716f4, setPathValue716f4] = useState("");
  const [responseButtonStatus716, setResponseButtonStatus716] = useState(false);
  const [responseValue716, setResponseValue716] = useState("");
  const [help716Status, setHelp716Status] = useState(false);

  const [value717t1, setValue717t1] = useState();
  const [value717f1, setValue717f1] = useState("");
  const [pathValue717f1, setPathValue717f1] = useState("");
  const [value717f2, setValue717f2] = useState("");
  const [pathValue717f2, setPathValue717f2] = useState("");
  const [value717f3, setValue717f3] = useState("");
  const [pathValue717f3, setPathValue717f3] = useState("");
  const [value717f4, setValue717f4] = useState("");
  const [pathValue717f4, setPathValue717f4] = useState("");
  const [responseButtonStatus717, setResponseButtonStatus717] = useState(false);
  const [responseValue717, setResponseValue717] = useState("");
  const [help717Status, setHelp717Status] = useState(false);

  const [value718t1, setValue718t1] = useState();
  const [value718f1, setValue718f1] = useState("");
  const [pathValue718f1, setPathValue718f1] = useState("");
  const [value718f2, setValue718f2] = useState("");
  const [pathValue718f2, setPathValue718f2] = useState("");
  const [responseValue718, setResponseValue718] = useState("");
  const [help718Status, setHelp718Status] = useState(false);

  const [value719t1, setValue719t1] = useState();
  const [value719f1, setValue719f1] = useState("");
  const [pathValue719f1, setPathValue719f1] = useState("");
  const [value719f2, setValue719f2] = useState("");
  const [pathValue719f2, setPathValue719f2] = useState("");
  const [responseValue719, setResponseValue719] = useState("");
  const [help719Status, setHelp719Status] = useState(false);

  const [value7110t1, setValue7110t1] = useState();
  const [value7110f1, setValue7110f1] = useState("");
  const [pathValue7110f1, setPathValue7110f1] = useState("");
  const [value7110f2, setValue7110f2] = useState("");
  const [pathValue7110f2, setPathValue7110f2] = useState("");
  const [value7110f3, setValue7110f3] = useState("");
  const [pathValue7110f3, setPathValue7110f3] = useState("");
  const [responseButtonStatus7110, setResponseButtonStatus7110] =
    useState(false);
  const [responseValue7110, setResponseValue7110] = useState("");
  const [help7110Status, setHelp7110Status] = useState(false);

  const [value7111t1, setValue7111t1] = useState();
  const [value7111f1, setValue7111f1] = useState("");
  const [pathValue7111f1, setPathValue7111f1] = useState("");
  const [value7111f2, setValue7111f2] = useState("");
  const [pathValue7111f2, setPathValue7111f2] = useState("");
  const [value7111f3, setValue7111f3] = useState("");
  const [pathValue7111f3, setPathValue7111f3] = useState("");
  const [responseValue7111, setResponseValue7111] = useState("");
  const [help7111Status, setHelp7111Status] = useState(false);

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
        resources.APPLICATION_URL+"criteria7getallfiles?collegeId=1&financialYear=" +
          financialYear +
          "&typeofInstitution=autonomous"
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            setValue711t1(data[0].criteria71Ql[0] ? data[0].criteria71Ql[0].input711t1 : "");
            setValue712t1(data[0].criteria71Qn[0] ? data[0].criteria71Qn[0].input712t1 : "");
            setValue713t1(data[0].criteria71Ql[0] ? data[0].criteria71Ql[0].input713t1 : "");
            setValue714t1(data[0].criteria71Qn[0] ? data[0].criteria71Qn[0].input714t1 : "");
            setValue715t1(data[0].criteria71Qn[0] ? data[0].criteria71Qn[0].input715t1 : "");
            setValue716t1(data[0].criteria71Qn[0] ? data[0].criteria71Qn[0].input716t1 : "");
            setValue717t1(data[0].criteria71Qn[0] ? data[0].criteria71Qn[0].input717t1 : "");
            setValue718t1(data[0].criteria71Ql[0] ? data[0].criteria71Ql[0].input718t1 : "");
            setValue719t1(data[0].criteria71Ql[0] ? data[0].criteria71Ql[0].input719t1 : "");
            setValue7110t1(data[0].criteria71Qn[0] ? data[0].criteria71Qn[0].input7110t1 : "");
            setValue7111t1(data[0].criteria71Ql[0] ? data[0].criteria71Ql[0].input7111t1 : "");

            // setValue711f1(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue711f2(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue712f1(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue712f2(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue713f1(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue713f2(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue713f3(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue714f1(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue714f2(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue715f1(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue715f2(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue715f3(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue716f1(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue716f2(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue716f3(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue716f4(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue717f1(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue717f2(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue717f3(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue717f4(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue718f1(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue718f2(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue719f1(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue719f2(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue7110f1(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue7110f2(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue7110f3(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue7111f1(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue7111f2(data[0].criteria7FileUpload[0].criteria7FileName);
            // setValue7111f3(data[0].criteria7FileUpload[0].criteria7FileName);
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );
  // function onClickingViewResponse712(e) {
  //   if (value712t1 === '' || value712t1 === undefined || value712t1 === null ) {
  //     setResponseValue712('Please select any option');
  //   } else {
  //     setResponseValue712(e.target.value);
  //   }
  // }
  // function onClickingViewResponse714(e) {
  //   if (value712t1 === '' || value712t1 === undefined || value712t1 === null ) {
  //     setResponseValue714('Please select any option');
  //   } else {
  //     setResponseValue714(e.target.value);
  //   }
  // }
  // function onClickingViewResponse715(e) {
  //   if (value715t1 === '' || value715t1 === undefined || value715t1 === null ) {
  //     setResponseValue715('Please select any option');
  //   } else {
  //     setResponseValue715(e.target.value);
  //   }
  // }
  // function onClickingViewResponse716(e) {
  //   if (value716t1 === '' || value716t1 === undefined || value716t1 === null ) {
  //     setResponseValue716('Please select any option');
  //   } else {
  //     setResponseValue716(e.target.value);
  //   }
  // }
  // function onClickingViewResponse717(e) {
  //   if (value717t1 === '' || value717t1 === undefined || value717t1 === null ) {
  //     setResponseValue717('Please select any option');
  //   } else {
  //     setResponseValue717(e.target.value);
  //   }
  // }
  // function onClickingViewResponse7110(e) {
  //   if (value7110t1 === '' || value7110t1 === undefined || value7110t1 === null ) {
  //     setResponseValue7110('Please select any option');
  //   } else {
  //     setResponseValue7110(e.target.value);
  //   }
  // }
  function onClickingViewResponse712(e) {
    if (value712t1 === "" || value712t1 === undefined || value712t1 === null) {
      setResponseValue712("Please select any option");
    } else {
      setResponseValue712(value712t1);
    }
  }
  function onClickingViewResponse714(e) {
    if (value714t1 === "" || value714t1 === undefined || value714t1 === null) {
      setResponseValue714("Please select any option");
    } else {
      setResponseValue714(value714t1);
    }
  }
  function onClickingViewResponse715(e) {
    if (value715t1 === "" || value715t1 === undefined || value715t1 === null) {
      setResponseValue715("Please select any option");
    } else {
      setResponseValue715(value715t1);
    }
  }
  function onClickingViewResponse716(e) {
    if (value716t1 === "" || value716t1 === undefined || value716t1 === null) {
      setResponseValue716("Please select any option");
    } else {
      setResponseValue716(value716t1);
    }
  }
  function onClickingViewResponse717(e) {
    if (value717t1 === "" || value717t1 === undefined || value717t1 === null) {
      setResponseValue717("Please select any option");
    } else {
      setResponseValue717(value717t1);
    }
  }
  function onClickingViewResponse7110(e) {
    if (
      value7110t1 === "" ||
      value7110t1 === undefined ||
      value7110t1 === null
    ) {
      setResponseValue7110("Please select any option");
    } else {
      setResponseValue7110(value7110t1);
    }
  }

  // sending data to db with API

  const inputDataList = {
    criteriaId: {
      collegeId:collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    criteria71Ql: [
      {
        criteriaId: {
          collegeId:collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input711t1: value711t1,
        input713t1: value713t1,
        input718t1: value718t1,
        input719t1: value719t1,
        input7111t1: value7111t1,
        response711: responseValue711,
        response713: responseValue713,
        response718: responseValue718,
        response719: responseValue719,
        response7111: responseValue7111,
      },
    ],
    criteria71Qn: [
      {
        criteriaId: {
          collegeId:collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
        uniqueKey1: 1,
        input712t1: value712t1,
        input714t1: value714t1,
        input715t1: value715t1,
        input716t1: value716t1,
        input717t1: value717t1,
        input7110t1: value7110t1,
        response712: responseValue712,
        response714: responseValue714,
        response715: responseValue715,
        response716: responseValue716,
        response717: responseValue717,
        response7110: responseValue7110,
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
    <div className="c71-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c71x-colorIndicator-container">
        <p className="c71x-QlcolorIndicator-circle-style"></p>
        <span className="c71x-colorIndicator-span-style">Qualitative</span>
        <p className="c71x-QtcolorIndicator-circle-style"></p>
        <span className="c71x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c71x-weightage-heading-style">
            Key Indicator Weightage: 50
          </h1>
        </div>
      </div>

      {/* Key Indicator: 7.1.1 */}
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c71x-Ql-label-textarea-container">
            <div className="c71x-heading_Help-container">
              <h1 className="c71x-heading-style">
                <span className="c71x-span-style">7.1.1: </span>
                Institution has initiated the Gender Audit and measures for the 
                   promotion of gender equity during the last five years.

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
            <label htmlFor="711-t1" className="c71x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue711t1(e.target.value);
                setResponseValue711(e.target.value);
              }}
              value={value711t1}
              rows={10}
              className="c71x-textarea-style"
              id="711-t1"
            ></textarea>
            {value711t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c71x-Ql-table-style">
            <tr>
              <th className="c71x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Annual gender sensitization action plan
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue711f1(e.target.files[0]);
                    setPathValue711f1(e.target.value);
                  }}
                  id="711-f1"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue711f1 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue711f1("");
                        document.getElementById("711-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value711f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">

                  </button>
                </div> */}
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Specific facilities provided for women in terms of: a.Safety and
                security b.Counselling c.Common Rooms d. Day care center for
                young children e. Any other relevant information
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue711f2(e.target.files[0]);
                    setPathValue711f2(e.target.value);
                  }}
                  id="711-f2"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue711f2 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue711f2("");
                        document.getElementById("711-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value711f2)} target="_blank">
                  View File
                </a>

                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                  </button>
                </div> */}
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 7.1.2 */}
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 6</h1>
        </div>
        <form>
          <div className="c71x-container">
            <div className="c71x-heading_Help-container">
              <div>
                <h1 className="c71x-heading-style">
                  <span className="c71x-span-style">7.1.2: </span>
                  Institution has initiated the Gender Audit and measures for the 
                 promotion of gender equity during the last five years.

                </h1>
                <p className="c71x-para-style">
                  1. Solar energy
                  <br />
                  2. Biogas plant
                  <br />
                  3. Wheeling to the Grid
                  <br />
                  4. Sensor-based energy conservation
                  <br />
                  5. Use of LED bulbs/ power efficient equipment
                </p>
                <div className="c71x-radio-container" style={{ width: "105%" }}>
                  <div
                    className="c71x-radio-subContainer"
                    style={{ width: "45%" }}
                  >
                    <div className="c71x-eachRadio-container">
                      <input
                        name="712options"
                        id="712-t1"
                        type="radio"
                        onChange={(e) => setValue712t1(e.target.value)}
                        value="All of the above"
                      />

                      <label className="c71x-radioLabel-style" for="712-t1">
                        All of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="712options"
                        id="712-t2"
                        type="radio"
                        value="Any three of the above"
                        onChange={(e) => setValue712t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="712-t2">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="712options"
                        id="712-t3"
                        type="radio"
                        value="Any two of the above"
                        onChange={(e) => setValue712t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="712-t3">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c71x-radio-subContainer">
                    <div className="c71x-eachRadio-container">
                      <input
                        name="712options"
                        id="712-t4"
                        type="radio"
                        value="Any one of the above"
                        onChange={(e) => setValue712t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="712-t4">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="712options"
                        id="712-t5"
                        type="radio"
                        value="None of the above"
                        onChange={(e) => setValue712t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="712-t5">
                        None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
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
            <div className="c71x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus712(!responseButtonStatus712);
                  onClickingViewResponse712();
                }}
                className="c71x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus712 ? (
                <p className="c71x-responseResult-style">{responseValue712}</p>
              ) : null}
            </div>
          </div>
          <table className="c71x-table-style">
            <tr>
              <th className="c71x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Geotagged Photographs</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue712f1(e.target.files[0]);
                    setPathValue712f1(e.target.value);
                  }}
                  id="712-f1"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue712f1 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue712f1("");
                        document.getElementById("712-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value712f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any other relevant information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue712f2(e.target.files[0]);
                    setPathValue712f2(e.target.value);
                  }}
                  id="712-f2"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue712f2 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue712f2("");
                        document.getElementById("712-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value712f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 7.1.3 */}
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 6</h1>
        </div>
        <form>
          <div className="c71x-Ql-label-textarea-container">
            <div className="c71x-heading_Help-container">
              <h1 className="c71x-heading-style">
                <span className="c71x-span-style">7.1.3: </span>
                Describe the facilities in the Institution for the management of the 
                   following types of degradable and non-degradable waste (within 500 
                  words)
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
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <label htmlFor="713-t1" className="c71x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue713t1(e.target.value);
                setResponseValue713(e.target.value);
              }}
              value={value713t1}
              rows={10}
              className="c71x-textarea-style"
              id="713-t1"
            ></textarea>
            {value713t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c71x-Ql-table-style">
            <tr>
              <th className="c71x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Relevant documents like agreements/MoUs with Government and
                other approved agencies
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue713f1(e.target.files[0]);
                    setPathValue713f1(e.target.value);
                  }}
                  id="713-f1"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue713f1 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue713f1("");
                        document.getElementById("713-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value713f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Geotagged photographs of the facilities
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue713f2(e.target.files[0]);
                    setPathValue713f2(e.target.value);
                  }}
                  id="713-f2"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue713f2 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue713f2("");
                        document.getElementById("713-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value713f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Any other relevant information
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue713f3(e.target.files[0]);
                    setPathValue713f3(e.target.value);
                  }}
                  id="713-f3"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue713f3 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue713f3("");
                        document.getElementById("713-f3").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value713f3)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 7.1.4 */}
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 4</h1>
        </div>
        <form>
          <div className="c71x-container">
            <div className="c71x-heading_Help-container">
              <div>
                <h1 className="c71x-heading-style">
                  <span className="c71x-span-style">7.1.4: </span>
                  Water conservation facilities available in the Institution:
                </h1>
                <p className="c71x-para-style">
                  1. Rain water harvesting
                  <br />
                  2. Borewell /Open well recharge
                  <br />
                  3. Construction of tanks and bunds
                  <br />
                  4. Waste water recycling
                  <br />
                  5. Maintenance of water bodies and distribution system in the
                  campus
                </p>
                <div className="c71x-radio-container" style={{ width: "160%" }}>
                  <div
                    className="c71x-radio-subContainer"
                    style={{ width: "45%" }}
                  >
                    <div className="c71x-eachRadio-container">
                      <input
                        name="714options"
                        id="714-t1"
                        type="radio"
                        value="All of the above"
                        onChange={(e) => setValue714t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="714-t1">
                        All of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="714options"
                        id="714-t2"
                        type="radio"
                        value="Any three of the above"
                        onChange={(e) => setValue714t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="714-t2">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="714options"
                        id="714-t3"
                        type="radio"
                        value="Any two of the above"
                        onChange={(e) => setValue714t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="714-t3">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c71x-radio-subContainer">
                    <div className="c71x-eachRadio-container">
                      <input
                        name="712options"
                        id="714-t4"
                        type="radio"
                        value="Any one of the above"
                        onChange={(e) => setValue714t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="714-t4">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="714options"
                        id="714-t5"
                        type="radio"
                        value="None of the above"
                        onChange={(e) => setValue714t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="714-t5">
                        None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen4}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen4}
                handleClose={handleHelpClose4}
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            <div className="c71x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus714(!responseButtonStatus714);
                  onClickingViewResponse714();
                }}
                className="c71x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus714 ? (
                <p className="c71x-responseResult-style">{responseValue714}</p>
              ) : null}
            </div>
          </div>
          <table className="c71x-table-style">
            <tr>
              <th className="c71x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Geotagged photographs / videos of the facilities</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue714f1(e.target.files[0]);
                    setPathValue714f1(e.target.value);
                  }}
                  id="714-f1"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue714f1 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue714f1("");
                        document.getElementById("714-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value714f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any other relevant information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue714f2(e.target.files[0]);
                    setPathValue714f2(e.target.value);
                  }}
                  id="714-f2"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue714f2 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue714f2("");
                        document.getElementById("714-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value714f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 7.1.5 */}
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 4</h1>
        </div>
        <form>
          <div className="c71x-container">
            <div className="c71x-heading_Help-container">
              <div>
                <h1 className="c71x-heading-style">
                  <span className="c71x-span-style">7.1.5: </span>
                  Green campus initiatives includ
                </h1>
                <p className="c71x-para-style">
                  1. Restricted entry of automobiles
                  <br />
                  2. Use of Bicycles/ Battery powered vehicles
                  <br />
                  3. Pedestrian Friendly pathways
                  <br />
                  4. Ban on use of Plastic
                  <br />
                  5. landscaping with trees and plants
                </p>
                <div className="c71x-radio-container" style={{ width: "220%" }}>
                  <div
                    className="c71x-radio-subContainer"
                    style={{ width: "45%" }}
                  >
                    <div className="c71x-eachRadio-container">
                      <input
                        name="715options"
                        id="715-t1"
                        type="radio"
                        value="All of the above"
                        onChange={(e) => setValue715t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="715-t1">
                        All of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="715options"
                        id="715-t2"
                        type="radio"
                        value="Any three of the above"
                        onChange={(e) => setValue715t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="715-t2">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="715options"
                        id="715-t3"
                        type="radio"
                        value="Any two of the above"
                        onChange={(e) => setValue715t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="715-t3">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c71x-radio-subContainer">
                    <div className="c71x-eachRadio-container">
                      <input
                        name="715options"
                        id="715-t4"
                        type="radio"
                        value="Any one of the above"
                        onChange={(e) => setValue715t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="715-t4">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="715options"
                        id="715-t5"
                        type="radio"
                        value="None of the above"
                        onChange={(e) => setValue715t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="715-t5">
                        None of the above
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
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            <div className="c71x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus715(!responseButtonStatus715);
                  onClickingViewResponse715();
                }}
                className="c71x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus715 ? (
                <p className="c71x-responseResult-style">{responseValue715}</p>
              ) : null}
            </div>
          </div>
          <table className="c71x-table-style">
            <tr>
              <th className="c71x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Geotagged photos / videos of the facilities </td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue715f1(e.target.files[0]);
                    setPathValue715f1(e.target.value);
                  }}
                  id="715-f1"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue715f1 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue715f1("");
                        document.getElementById("715-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value715f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Various policy documents / decisions circulated for
                implementation
              </td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue715f2(e.target.files[0]);
                    setPathValue715f2(e.target.value);
                  }}
                  id="715-f2"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue715f2 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue715f2("");
                        document.getElementById("715-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value715f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any other relevant documents</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue715f3(e.target.files[0]);
                    setPathValue715f3(e.target.value);
                  }}
                  id="715-f3"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue715f3 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue715f3("");
                        document.getElementById("715-f3").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value715f3)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 7.1.6 */}
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c71x-container">
            <div className="c71x-heading_Help-container">
              <div>
                <h1 className="c71x-heading-style">
                  <span className="c71x-span-style">7.1.6: </span>
                  Quality audits on environment and energy are regularly undertaken 
                  by the institution
                </h1>
                <p className="c71x-para-style">
                  1. Green audit
                  <br />
                  2. Energy audit
                  <br />
                  3. Environment audit
                  <br />
                  4. Clean and green campus recognitions / awards
                  <br />
                  5. Beyond the campus environmental promotion activities
                </p>
                <div className="c71x-radio-container">
                  <div
                    className="c71x-radio-subContainer"
                    style={{ width: "45%" }}
                  >
                    <div className="c71x-eachRadio-container">
                      <input
                        name="716options"
                        id="716-t1"
                        type="radio"
                        value="All of the above"
                        onChange={(e) => setValue716t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="716-t1">
                        All of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="716options"
                        id="716-t2"
                        type="radio"
                        value="Any three of the above"
                        onChange={(e) => setValue716t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="716-t2">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="716options"
                        id="716-t3"
                        type="radio"
                        value="Any two of the above"
                        onChange={(e) => setValue716t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="716-t3">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c71x-radio-subContainer">
                    <div className="c71x-eachRadio-container">
                      <input
                        name="716options"
                        id="716-t4"
                        type="radio"
                        value="Any one of the above"
                        onChange={(e) => setValue716t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="716-t4">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="716options"
                        id="716-t5"
                        type="radio"
                        value="None of the above"
                        onChange={(e) => setValue716t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="716-t5">
                        None of the above
                      </label>
                    </div>
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
                title='Upload the specific document as per description'
                ></HelpButton>
            <div className="c71x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus716(!responseButtonStatus716);
                  onClickingViewResponse716();
                }}
                className="c71x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus716 ? (
                <p className="c71x-responseResult-style">{responseValue716}</p>
              ) : null}
            </div>
          </div>
          <table className="c71x-table-style">
            <tr>
              <th className="c71x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>
                Reports on environment and energy audits submitted by the
                auditing agency{" "}
              </td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue716f1(e.target.files[0]);
                    setPathValue716f1(e.target.value);
                  }}
                  id="716-f1"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue716f1 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue716f1("");
                        document.getElementById("716-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value716f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Certification by the auditing agency</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue716f2(e.target.files[0]);
                    setPathValue716f2(e.target.value);
                  }}
                  id="716-f2"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue716f2 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue716f2("");
                        document.getElementById("716-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value716f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Certificates of the awards received</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue716f3(e.target.files[0]);
                    setPathValue716f3(e.target.value);
                  }}
                  id="716-f3"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue716f3 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue716f3("");
                        document.getElementById("716-f3").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value716f3)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any other relevant information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue716f4(e.target.files[0]);
                    setPathValue716f4(e.target.value);
                  }}
                  id="716-f4"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue716f4 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue716f4("");
                        document.getElementById("716-f4").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value716f4)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 7.1.7 */}
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c71x-container">
            <div className="c71x-heading_Help-container">
              <div>
                <h1 className="c71x-heading-style">
                  <span className="c71x-span-style">7.1.7: </span>
                  The Institution has Differently-abled (Divyangjan) friendly, barrier 
free environment
                </h1>
                <p className="c71x-para-style">
                  1. Built environment with ramps/lifts for easy access to
                  classrooms
                  <br />
                  2. Divyangjan friendly washrooms
                  <br />
                  3. Signage including tactile path, lights, display boards and
                  signposts
                  <br />
                  4. Assistive technology and facilities for Divyangjan
                  accessible website, screen-reading software, mechanized
                  equipment
                  <br />
                  5. Provision for enquiry and information : Human assistance,
                  reader, scribe, soft copies of reading material, screen
                  reading
                </p>
                <div className="c71x-radio-container">
                  <div
                    className="c71x-radio-subContainer"
                    style={{ width: "45%" }}
                  >
                    <div className="c71x-eachRadio-container">
                      <input
                        name="717options"
                        id="717-t1"
                        type="radio"
                        value="All of the above"
                        onChange={(e) => setValue717t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="717-t1">
                        All of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="717options"
                        id="717-t2"
                        type="radio"
                        value="Any three of the above"
                        onChange={(e) => setValue717t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="717-t2">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="717options"
                        id="717-t3"
                        type="radio"
                        value="Any two of the above"
                        onChange={(e) => setValue717t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="717-t3">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c71x-radio-subContainer">
                    <div className="c71x-eachRadio-container">
                      <input
                        name="717options"
                        id="717-t4"
                        type="radio"
                        value="Any one of the above"
                        onChange={(e) => setValue717t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="717-t4">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="717options"
                        id="717-t5"
                        type="radio"
                        value="None of the above"
                        onChange={(e) => setValue717t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="717-t5">
                        None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen7}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen7}
                handleClose={handleHelpClose7}
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            <div className="c71x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus717(!responseButtonStatus717);
                  onClickingViewResponse717();
                }}
                className="c71x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus717 ? (
                <p className="c71x-responseResult-style">{responseValue717}</p>
              ) : null}
            </div>
          </div>
          <table className="c71x-table-style">
            <tr>
              <th className="c71x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Geotagged photographs / videos of the facilities</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue717f1(e.target.files[0]);
                    setPathValue717f1(e.target.value);
                  }}
                  id="717-f1"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue717f1 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue717f1("");
                        document.getElementById("717-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value717f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Policy documents and information brochures on the support to be
                provided
              </td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue717f2(e.target.files[0]);
                    setPathValue717f2(e.target.value);
                  }}
                  id="717-f2"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue717f2 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue717f2("");
                        document.getElementById("717-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value717f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Details of the Software procured for providing the assistance
              </td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue717f3(e.target.files[0]);
                    setPathValue717f3(e.target.value);
                  }}
                  id="717-f3"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue717f3 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue717f3("");
                        document.getElementById("717-f3").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value717f3)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any other relevant information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue717f4(e.target.files[0]);
                    setPathValue717f4(e.target.value);
                  }}
                  id="717-f4"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue717f4 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue717f4("");
                        document.getElementById("717-f4").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value717f4)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 7.1.8 */}
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c71x-Ql-label-textarea-container">
            <div className="c71x-heading_Help-container">
              <h1 className="c71x-heading-style">
                <span className="c71x-span-style">7.1.8: </span>
                Describe the Institutional efforts/initiatives in providing an inclusive 
                 environment i.e., tolerance and harmony towards cultural, regional, 
                         linguistic, communal socioeconomic and such other diversities 
                       (within 500 words).
              </h1>
              <button
                onClick={handleHelpOpen8}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen8}
                handleClose={handleHelpClose8}
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <label htmlFor="718-t1" className="c71x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue718t1(e.target.value);
                setResponseValue718(e.target.value);
              }}
              value={value718t1}
              rows={10}
              className="c71x-textarea-style"
              id="718-t1"
            ></textarea>
            {value718t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c71x-Ql-table-style">
            <tr>
              <th className="c71x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Supporting documents on the information provided (as reflected
                in the administrative and academic activities of the
                Institution)
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue718f1(e.target.files[0]);
                    setPathValue718f1(e.target.value);
                  }}
                  id="718-f1"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue718f1 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue718f1("");
                        document.getElementById("718-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value718f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Any other relevant information
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue718f2(e.target.files[0]);
                    setPathValue718f2(e.target.value);
                  }}
                  id="718-f2"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue718f2 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue718f2("");
                        document.getElementById("718-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value718f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 7.1.9 */}
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 4</h1>
        </div>
        <form>
          <div className="c71x-Ql-label-textarea-container">
            <div className="c71x-heading_Help-container">
              <h1 className="c71x-heading-style">
                <span className="c71x-span-style">7.1.9: </span>
                Sensitization of students and employees of the Institution to the 
                  constitutional obligations: values, rights, duties and responsibilities 
                  of citizens
              </h1>
              <button
                onClick={handleHelpOpen9}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen9}
                handleClose={handleHelpClose9}
                title='Write description in a maximum of 500 words'
                ></HelpButton>
            </div>
            <label htmlFor="719-t1" className="c71x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue719t1(e.target.value);
                setResponseValue719(e.target.value);
              }}
              value={value719t1}
              rows={10}
              className="c71x-textarea-style"
              id="719-t1"
            ></textarea>
            {value719t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c71x-Ql-table-style">
            <tr>
              <th className="c71x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Details of activities that inculcate values; necessary to render
                students in to responsible citizens
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue719f1(e.target.files[0]);
                    setPathValue719f1(e.target.value);
                  }}
                  id="719-f1"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue719f1 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue719f1("");
                        document.getElementById("719-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value719f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Any other relevant information
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue719f2(e.target.files[0]);
                    setPathValue719f2(e.target.value);
                  }}
                  id="719-f2"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue719f2 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue719f2("");
                        document.getElementById("719-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value719f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 7.1.10 */}
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c71x-container">
            <div className="c71x-heading_Help-container">
              <div>
                <h1 className="c71x-heading-style">
                  <span className="c71x-span-style">7.1.10: </span>
                  The Institution has a prescribed code of conduct for students, 
                  teachers, administrators and other staff and conducts periodic 
                programmes in this regard. 
                </h1>
                <p className="c71x-para-style">
                  1. The Code of Conduct is displayed on the website
                  <br />
                  2. There is a committee to monitor adherence to the Code of
                  Conduct
                  <br />
                  3. Institution organizes professional ethics programmes for
                  students, teachers, administrators and other staff
                  <br />
                  4. Annual awareness programmes on Code of Conduct are
                  organized
                </p>
                <div className="c71x-radio-container">
                  <div
                    className="c71x-radio-subContainer"
                    style={{ width: "45%" }}
                  >
                    <div className="c71x-eachRadio-container">
                      <input
                        name="7110options"
                        id="7110-t1"
                        type="radio"
                        value="All of the above"
                        onChange={(e) => setValue7110t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="7110-t1">
                        All of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="7110options"
                        id="7110-t2"
                        type="radio"
                        value="Any three of the above"
                        onChange={(e) => setValue7110t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="7110-t2">
                        Any three of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="7110options"
                        id="7110-t3"
                        type="radio"
                        value="Any two of the above"
                        onChange={(e) => setValue7110t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="7110-t3">
                        Any two of the above
                      </label>
                    </div>
                  </div>

                  <div className="c71x-radio-subContainer">
                    <div className="c71x-eachRadio-container">
                      <input
                        name="7110options"
                        id="7110-t4"
                        type="radio"
                        value="Any one of the above"
                        onChange={(e) => setValue7110t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="7110-t4">
                        Any one of the above
                      </label>
                    </div>

                    <div className="c71x-eachRadio-container">
                      <input
                        name="7110options"
                        id="7110-t5"
                        type="radio"
                        value="None of the above"
                        onChange={(e) => setValue7110t1(e.target.value)}
                      />

                      <label className="c71x-radioLabel-style" for="7110-t5">
                        None of the above
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <button
                onClick={handleHelpOpen10}
                className="c11x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen10}
                handleClose={handleHelpClose10}
                title='Upload the specific document as per description'
                ></HelpButton>
            </div>
            <div className="c71x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus7110(!responseButtonStatus7110);
                  onClickingViewResponse7110();
                }}
                className="c71x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus7110 ? (
                <p className="c71x-responseResult-style">{responseValue7110}</p>
              ) : null}
            </div>
          </div>
          <table className="c71x-table-style">
            <tr>
              <th className="c71x-Qt-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Qt-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Qt-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Qt-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td>Code of ethics policy document</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue7110f1(e.target.files[0]);
                    setPathValue7110f1(e.target.value);
                  }}
                  id="7110-f1"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue7110f1 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue7110f1("");
                        document.getElementById("7110-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value7110f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>
                Details of the monitoring committee composition and minutes of
                the committee meeting, number of programmes organized, reports
                on the various programs etc., in support of the claims
              </td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue7110f2(e.target.files[0]);
                    setPathValue7110f2(e.target.value);
                  }}
                  id="7110-f2"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue7110f2 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue7110f2("");
                        document.getElementById("7110-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value7110f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td>Any other relevant information</td>
              <td></td>
              <td>
                <input
                  onChange={(e) => {
                    setValue7110f3(e.target.files[0]);
                    setPathValue7110f3(e.target.value);
                  }}
                  id="7110-f3"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue7110f3 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue7110f3("");
                        document.getElementById("7110-f3").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value7110f3)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                   
                  </button>
                </div> */}
              </td>
              <td className="c71x-Qt-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div>

      {/* Key Indicator: 7.1.11
      <div className="c71x-eachInputField-container">
        <div className="c71x-weightage-container">
          <h1 className="c71x-weightage-heading-style">Weightage: 5</h1>
        </div>
        <form>
          <div className="c71x-Ql-label-textarea-container">
            <div className="c71x-heading_Help-container">
              <h1 className="c71x-heading-style">
                <span className="c71x-span-style">7.1.11: </span>
                Institution celebrates / organizes national and international
                commemorative days, events and festivals (within 500 words).
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp7111Status(true);
                }}
                className="c71x-helpButton-style"
              >
                Help
              </button>
              <Help7111
                isHelp7111Clicked={help7111Status}
                setIsHelp7111Clicked={setHelp7111Status}
              />
            </div>
            <label htmlFor="7111-t1" className="c71x-label-style">
              Response:
            </label>
            <textarea readonly
              placeholder="Write description in maximum of 500 words"
              onChange={(e) => {
                setValue7111t1(e.target.value);
                setResponseValue7111(e.target.value);
              }}
              value={value7111t1}
              rows={10}
              className="c71x-textarea-style"
              id="719-t1"
            ></textarea>
            {value7111t1 === "" ? (
              <p style={{ color: "red" }}>Required*</p>
            ) : null}
          </div>

          <table className="c71x-Ql-table-style">
            <tr>
              <th className="c71x-Ql-verticalTable-heading1-style">
                File Description
              </th>
              <th className="c71x-Ql-verticalTable-heading2-style">
                File Template
              </th>
              <th className="c71x-Ql-verticalTable-heading3-style">
                Documents upload
              </th>
              <th className="c71x-Ql-verticalTable-heading4-style">
                File type and size
              </th>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Annual report of the celebrations and commemorative events for
                the last five years
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue7111f1(e.target.files[0]);
                    setPathValue7111f1(e.target.value);
                  }}
                  id="7111-f1"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue7111f1 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue7111f1("");
                        document.getElementById("7111-f1").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value7111f1)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div> 
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Geotagged photographs of some of the events
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue7111f2(e.target.files[0]);
                    setPathValue7111f2(e.target.value);
                  }}
                  id="7111-f2"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue7111f2 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue7111f2("");
                        document.getElementById("7111-f2").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value7111f2)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    
                  </button>
                </div>
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
            <tr>
              <td className="c71x-Ql-tableBorders-style">
                Any other relevant information
              </td>
              <td className="c71x-Ql-tableBorders-style"></td>
              <td className="c71x-Ql-tableBorders-style">
                <input
                  onChange={(e) => {
                    setValue7111f3(e.target.files[0]);
                    setPathValue7111f3(e.target.value);
                  }}
                  id="7111-f3"
                  type="file"
                  className="c71-fileButton-style"
                />
                {pathValue7111f3 === "" ? null : (
                  <div className="c71-fileButtons-container">
                    <button className="c71-viewFileButton-style">
                      View File
                    </button>
                    <button
                      className="c11-removeFileButton-style"
                      onClick={(e) => {
                        setPathValue7111f3("");
                        document.getElementById("7111-f3").value = "";
                      }}
                    >
                      Reset
                    </button>
                  </div>
                )}
                <a href={downloadFile(value7111f3)} target="_blank">
                  View File
                </a>
                {/* <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">

                  </button>
                </div>
              </td>
              <td className="c71x-Ql-tableBorders-style">pdf</td>
            </tr>
          </table>
        </form>
      </div> */}
    </div>
  );
}

export default Criteria71;
