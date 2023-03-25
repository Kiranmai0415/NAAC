import React, { useState ,useEffect} from "react";
import "./c52-style.css";
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
function Help521(props) {
  return props.isHelp521Clicked ? (
    <div className="c52x-help-mainContainer">
      <div className="c52x-help-subContainer">
        <h1 className="c52x-help-heading-style">
          What to be filled in the Response ?
        </h1>
        <p className="c52x-help-para-style">
          Percentage per year
          <span style={{ fontWeight: "bold" }}>(</span>Number of Outgoing
          Students placed
          <span style={{ fontWeight: "bold" }}>) /</span>
          <span style={{ fontWeight: "bold" }}>(</span> Number of Outgoing
          students
          <span style={{ fontWeight: "bold" }}>) /</span>*100
        </p>
        <p className="c52x-help-para-style">
          Average
          <span style={{ fontWeight: "bold" }}>=(</span> ΣPercentage per year
          <span style={{ fontWeight: "bold" }}>) /</span> 5
        </p>
        <button
          className="c52x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp521Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}
function Help522(props) {
  return props.isHelp522Clicked ? (
    <div className="c52x-help-mainContainer">
      <div className="c52x-help-subContainer">
        <h1 className="c52x-help-heading-style">
          How is Response calculated ?
        </h1>
        <p className="c52x-help-para-style">
          Percentage per year<span style={{ fontWeight: "bold" }}>=</span>
          <span style={{ fontWeight: "bold" }}>((</span>Total number of Outgoing
          students progressing to higher education
          <span style={{ fontWeight: "bold" }}>) /</span>
          <span style={{ fontWeight: "bold" }}>(</span>Total Number of final
          year students
          <span style={{ fontWeight: "bold" }}>) )</span>*100
        </p>
        <button
          className="c52x-help-closeButton-style"
          onClick={(e) => {
            e.preventDefault();
            props.setIsHelp522Clicked(false);
          }}
        >
          Close
        </button>
      </div>
    </div>
  ) : null;
}


// Promotion of Research and Facilities
function Criteria52() {
   // getfile data with API
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
  // state variables
    // /this is Help button 
    const [isOpen, setIsopen] = useState(false)
    const handleHelpOpen = (e) => {
      e.preventDefault(),
      setIsopen(true)
    }
    const handleHelpClose = () => {
      setIsopen(false)
    }
  const [value5211t1, setValue5211t1] = useState();
  const [value5211t2, setValue5211t2] = useState();
  const [value5211t3, setValue5211t3] = useState();
  const [value5211t4, setValue5211t4] = useState();
  const [value5211t5, setValue5211t5] = useState();
  const [value5211t6, setValue5211t6] = useState();
  const [value5211t7, setValue5211t7] = useState();
  const [value5211t8, setValue5211t8] = useState();
  const [value5211t9, setValue5211t9] = useState();
  const [value5211t10, setValue5211t10] = useState();
  const [value5211t11, setValue5211t11] = useState();
  const [value5211t12, setValue5211t12] = useState();
  const [value5211t13, setValue5211t13] = useState();
  const [value5211t14, setValue5211t14] = useState();
  const [value5211t15, setValue5211t15] = useState();
  const [value5211t16, setValue5211t16] = useState();
  const [value5211t17, setValue5211t17] = useState();
  const [value5211t18, setValue5211t18] = useState();
  const [value5211t19, setValue5211t19] = useState();
  const [value5211t20, setValue5211t20] = useState();

  const [value5221t1, setValue5221t1] = useState();
  const [value5221t2, setValue5221t2] = useState();
  const [value5221t3, setValue5221t3] = useState();
  const [value5221t4, setValue5221t4] = useState();
  const [value5221t5, setValue5221t5] = useState();
  const [value5221t6, setValue5221t6] = useState();
  const [value5221t7, setValue5221t7] = useState();
  const [value5221t8, setValue5221t8] = useState();
  const [value5221t9, setValue5221t9] = useState();
  const [value5221t10, setValue5221t10] = useState();
  const [value5222t1, setValue5222t1] = useState();
  const [value5222t2, setValue5222t2] = useState();
  const [value5222t3, setValue5222t3] = useState();
  const [value5222t4, setValue5222t4] = useState();
  const [value5222t5, setValue5222t5] = useState();
  const [value5222t6, setValue5222t6] = useState();
  const [value5222t7, setValue5222t7] = useState();
  const [value5222t8, setValue5222t8] = useState();
  const [value5222t9, setValue5222t9] = useState();
  const [value5222t10, setValue5222t10] = useState();

  const [pathValue5211f1, setPathValue5211f1] = useState("");
  const [pathValue5211f2, setPathValue5211f2] = useState("");
  const [pathValue5211f3, setPathValue5211f3] = useState("");

  const [value5211f1, setValue5211f1] = useState([]);
  const [value5211f2, setValue5211f2] = useState([]);
  const [value5211f3, setValue5211f3] = useState([]);

  const [pathValue5221f1, setPathValue5221f1] = useState("");
  const [pathValue5221f2, setPathValue5221f2] = useState("");
  const [pathValue5221f3, setPathValue5221f3] = useState("");
  const [value5221f1, setValue5221f1] = useState([]);
  const [value5221f2, setValue5221f2] = useState([]);
  const [value5221f3, setValue5221f3] = useState([]);

  const [pathValue5222f1, setPathValue5222f1] = useState("");
  const [pathValue5222f2, setPathValue5222f2] = useState("");
  const [pathValue5222f3, setPathValue5222f3] = useState("");
  const [value5222f1, setValue5222f1] = useState([]);
  const [value5222f2, setValue5222f2] = useState([]);
  const [value5222f3, setValue5222f3] = useState([]);

  const [responseButtonStatus521, setResponseButtonStatus521] = useState(false);
  const [responseButtonStatus522, setResponseButtonStatus522] = useState(false);
  const [responseButtonStatus523, setResponseButtonStatus523] = useState(false);
 
  const [responseValue521, setResponseValue521] = useState("");
  const [responseValue522, setResponseValue522] = useState("");
  const [responseValue523, setResponseValue523] = useState("");

  const [help521Status, setHelp521Status] = useState(false);
  const [help522Status, setHelp522Status] = useState(false);
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');
  const [viewResponseValue, setViewResponseValue] = useState(0);

  // response button functionality
  function onClickingViewResponse521() {
    if (
      value5211t6 === ""
      || value5211t7 === ""
      || value5211t8 === ""
      || value5211t9 === ""
      || value5211t10 === ""
      || value5211t16 === ""
      || value5211t17 === ""
      || value5211t18 === ""
      || value5211t19 === ""
      || value5211t20 === ""
      || value5211t6 === undefined
      || value5211t7 === undefined
      || value5211t8 === undefined
      || value5211t9 === undefined
      || value5211t10 === undefined
      || value5211t16 === undefined
      || value5211t17 === undefined
      || value5211t18 === undefined
      || value5211t19 === undefined
      || value5211t20 === undefined
    ) {
      setResponseValue521("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value5211t6, 10)) === false
      || Number.isInteger(parseInt(value5211t7, 10)) === false
      || Number.isInteger(parseInt(value5211t8, 10)) === false
      || Number.isInteger(parseInt(value5211t9, 10)) === false
      || Number.isInteger(parseInt(value5211t10, 10)) === false
      || Number.isInteger(parseInt(value5211t16, 10)) === false
      || Number.isInteger(parseInt(value5211t17, 10)) === false
      || Number.isInteger(parseInt(value5211t18, 10)) === false
      || Number.isInteger(parseInt(value5211t19, 10)) === false
      || Number.isInteger(parseInt(value5211t20, 10)) === false
    ) {
      setResponseValue521("Input should be an Integer");
    } else if (
      value5211t6 !== ""
      && value5211t7 !== ""
      && value5211t8 !== ""
      && value5211t9 !== ""
      && value5211t10 !== ""
      && value5211t16 !== ""
      && value5211t17 !== ""
      && value5211t18 !== ""
      && value5211t19 !== ""
      && value5211t20 !== ""
    ) {
      setResponseValue521(
        ((value5211t6 / value5211t16) * 100
          + (value5211t7 / value5211t17) * 100
          + (value5211t8 / value5211t18) * 100
          + (value5211t9 / value5211t19) * 100
          + (value5211t10 / value5211t20) * 100)
          / 5
      );
    }
  }

  function onClickingViewResponse522() {
    if (value5221t1 === "" || value5221t2 === "") {
      setResponseValue522("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value5221t1, 10)) === false
      || Number.isInteger(parseInt(value5221t2, 10)) === false
    ) {
      setResponseValue522("Input should be an Integer");
    } else if (value5221t1 !== "" && value5221t2 !== "") {
      setResponseValue522(
        (parseInt(value5221t1, 10) / parseInt(value5221t2, 10)) * 100
      );
    }
  }
  function onClickingViewResponse522() {
    if (
      value5221t6 === ""
      || value5221t7 === ""
      || value5221t8 === ""
      || value5221t9 === ""
      || value5221t10 === ""
      // || value5222t6 === ""
      // || value5222t7 === ""
      // || value5222t8 === ""
      // || value5222t9 === ""
      // || value5222t10 === ""
      || value5221t6 === undefined
      || value5221t7 === undefined
      || value5221t8 === undefined
      || value5221t9 === undefined
      || value5221t10 === undefined
      // || value5222t6 === undefined
      // || value5222t7 === undefined
      // || value5222t8 === undefined
      // || value5222t9 === undefined
      // || value5222t10 === undefined
    ) {
      setResponseValue522("Please fill the required fields");
    } else if (
      Number.isInteger(parseInt(value5221t6, 10)) === false
      || Number.isInteger(parseInt(value5221t7, 10)) === false
      || Number.isInteger(parseInt(value5221t8, 10)) === false
      || Number.isInteger(parseInt(value5221t9, 10)) === false
      || Number.isInteger(parseInt(value5221t10, 10)) === false
      // || Number.isInteger(parseInt(value5222t6, 10)) === false
      // || Number.isInteger(parseInt(value5222t7, 10)) === false
      // || Number.isInteger(parseInt(value5222t8, 10)) === false
      // || Number.isInteger(parseInt(value5222t9, 10)) === false
      // || Number.isInteger(parseInt(value5222t10, 10)) === false
    ) {
      setResponseValue522("Input should be an Integer");
    } else if (
      value5221t6 !== ""
      && value5221t7 !== ""
      && value5221t8 !== ""
      && value5221t9 !== ""
      && value5221t10 !== ""
      // && value5222t6 !== ""
      // && value5222t7 !== ""
      // && value5222t8 !== ""
      // && value5222t9 !== ""
      // && value5222t10 !== ""
    ) {
      setResponseValue522(
        ((parseInt(value5221t6 ,10)+
        parseInt (value5221t7 ,10)+
        parseInt (value5221t8 ,10)+
        parseInt(value5221t9 ,10)+
        parseInt(value5221t10 ,10))/ viewResponseValue)*100
    
      );
    }
  }


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
  const financialYear="2021-2022";
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          

    criteria52Qn: [
      {
  criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 101,
        input522t1: value5221t1,
        input522t2: value5221t2,
        response521: responseValue521,
        response522: responseValue522,
        response523: responseValue523,
        criteria52status:"save"
      },
    ],
    yearTable5211: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 101, input5211y: value5211t1, input5211v: value5211t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 102, input5211y: value5211t2, input5211v: value5211t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 103, input5211y: value5211t3, input5211v: value5211t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 104, input5211y: value5211t4, input5211v: value5211t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 105, input5211y: value5211t5, input5211v: value5211t10
      },
    ],

    yearTable52112: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 101, input52112y: value5211t11, input52112v: value5211t16
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 102, input52112y: value5211t12, input52112v: value5211t17
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 103, input52112y: value5211t13, input52112v: value5211t18
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 104, input52112y: value5211t14, input52112v: value5211t19
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 105, input52112y: value5211t15, input52112v: value5211t20
      },
    ],
    affiliatedYearTable5221: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 101, input5221y: value5221t1, input5221v: value5221t6
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 102, input5221y: value5221t2, input5221v: value5221t7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 103, input5221y: value5221t3, input5221v: value5221t8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 104, input5232y: value5222t4, input5232v: value5222t9
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
        uniqueKey1: 105, input5221y: value5221t5, input5221v: value5221t10
      },
    ],
    // yearTable5232: [
    //   {
    //     criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
    //     uniqueKey1: 101, input5232y: value5222t1, input5232v: value5222t6
    //   },
    //   {
    //     criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
    //     uniqueKey1: 102, input5232y: value5222t2, input5232v: value5222t7
    //   },
    //   {
    //     criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
    //     uniqueKey1: 103, input5232y: value5222t3, input5232v: value5222t8
    //   },
    //   {
    //     criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
    //     uniqueKey1: 104, input5232y: value5222t4, input5232v: value5222t9
    //   },
    //   {
    //     criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},          
    //     uniqueKey1: 105, input5232y: value5222t5, input5232v: value5222t10
    //   },
    // ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const form52Data = new FormData();

    form52Data.append("criteria5Fieldinfo", jsonBlob(inputDataList));
    if (pathValue5211f1 !== "") {
      form52Data.append(
        "uploadfile5",
        value5211f1,
        "f5211f1-" + value5211f1.name
      );
    }
    if (pathValue5211f2 !== "") {
      form52Data.append(
        "uploadfile5",
        value5211f2,
        "f5211f2-" + value5211f2.name
      );
    }
    if (pathValue5211f3 !== "") {
      form52Data.append(
        "uploadfile5",
        value5211f3,
        "f5211f3-" + value5211f3.name
      );
    }

    if (pathValue5222f1 !== "") {
      form52Data.append(
        "uploadfile5",
        value5222f1,
        "f5222f1-" + value5222f1.name
      );
    }
    if (pathValue5222f2 !== "") {
      form52Data.append(
        "uploadfile5",
        value5222f2,
        "f5222f2-" + value5222f2.name
      );
    }
    if (pathValue5222f3 !== "") {
      form52Data.append(
        "uploadfile5",
        value5222f3,
        "f5222f3-" + value5222f3.name
      );
    }
console.log(JSON.stringify(inputDataList));
    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form52Data,
    };
    fetch(
      resources.APPLICATION_URL+"criteria5upload",
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



  useEffect(
    () => fetch(resources.APPLICATION_URL+'viewResponseValueAffiliated522?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          console.log("response value is from backend==>"+JSON.stringify(data));
          setViewResponseValue(data);
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ),
    []
  );



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
    <div className="c52-inputFields-mainContainer">
      {/* Color Indication */}
      <div className="c52x-colorIndicator-container">
        <p className="c52x-QlcolorIndicator-circle-style"></p>
        <span className="c52x-colorIndicator-span-style">Qualitative</span>
        <p className="c52x-QtcolorIndicator-circle-style"></p>
        <span className="c52x-colorIndicator-span-style">Quantitative</span>
        <div
          style={{
            width: "60%",
            display: "flex",
            flexDirection: "row",
            justifyContent: "flex-end",
          }}
        >
          <h1 className="c52x-weightage-heading-style">
            Key Indicator Weightage: 35
          </h1>
        </div>
      </div>

      {/* Key Indicator: 5.2.1 */}
      <div className="c52x-eachInputField-container">
        <div className="c52x-weightage-container">
          <h1 className="c52x-weightage-heading-style">Weightage: 25</h1>
        </div>
        <form>
          <div className="c52x-container">
            <div className="c52x-heading_Help-container">
              <h1 className="c52x-heading-style">
                <span className="c52x-span-style">5.2.1: </span>
                Percentage of placement of outgoing students and students progressing to higher 
                education during the last five years
              </h1>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setHelp521Status(true);
                }}
                className="c52x-helpButton-style"
              >
                Help
              </button>
              <Help521
                isHelp521Clicked={help521Status}
                setIsHelp521Clicked={setHelp521Status}
              />
            </div>
            <div className="c52x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus521(!responseButtonStatus521);
                  onClickingViewResponse521();
                }}
                className="c52x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus521 ? (
                <p className="c51x-responseResult-style">{responseValue521}</p>
              ) : null}
            </div>
          </div>
          <div className="c52xx-container">
            <h1 className="c52x-heading-style">
              <span className="c52x-span-style">5.2.1.1 </span>
              Number of outgoing students placed year - wise during the last
              five years
            </h1>
            <table className="c52x-Qt-table-style">
              <tr>
                <th className="c52x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => setValue5211t1(e.target.value)}
                      id="5211-t1"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t1}
                    />
                    {value5211t1 === "" ? (
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
                    <input
                      onChange={(e) => setValue5211t2(e.target.value)}
                      id="5211-t2"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t2}
                    />
                    {value5211t2 === "" ? (
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
                    <input
                      onChange={(e) => setValue5211t3(e.target.value)}
                      id="5211-t3"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t3}
                    />
                    {value5211t3 === "" ? (
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
                    <input
                      onChange={(e) => setValue5211t4(e.target.value)}
                      id="5211-t4"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t4}
                    />
                    {value5211t4 === "" ? (
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
                    <input
                      onChange={(e) => setValue5211t5(e.target.value)}
                      id="5211-t5"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t5}
                    />
                    {value5211t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c52x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue5211t6(e.target.value);
                        onClickingViewResponse521();
                      }}
                      id="5211-t6"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t6}
                    />
                    {value5211t6 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5211t7(e.target.value);
                        onClickingViewResponse521();
                      }}
                      id="5211-t7"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t7}
                    />
                    {value5211t7 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5211t8(e.target.value);
                        onClickingViewResponse521();
                      }}
                      id="5211-t8"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t8}
                    />
                    {value5211t8 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5211t9(e.target.value);
                        onClickingViewResponse521();
                      }}
                      id="5211-t9"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t9}
                    />
                    {value5211t9 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5211t10(e.target.value);
                        onClickingViewResponse521();
                      }}
                      id="5211-t10"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t10}
                    />
                    {value5211t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <h1 className="c52x-heading-style">
              <span className="c52x-span-style">5.2.1.2 </span>
              Number of outgoing students year wise during the last five year
            </h1>

            <table className="c52x-Qt-table-style">
              <tr>
                <th className="c52x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => setValue5211t11(e.target.value)}
                      id="5211-t11"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t11}
                    />
                    {value5211t11 === "" ? (
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
                    <input
                      onChange={(e) => setValue5211t12(e.target.value)}
                      id="5211-t12"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t12}
                    />
                    {value5211t12 === "" ? (
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
                    <input
                      onChange={(e) => setValue5211t13(e.target.value)}
                      id="5211-t13"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t13}
                    />
                    {value5211t13 === "" ? (
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
                    <input
                      onChange={(e) => setValue5211t14(e.target.value)}
                      id="5211-t14"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t14}
                    />
                    {value5211t14 === "" ? (
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
                    <input
                      onChange={(e) => setValue5211t15(e.target.value)}
                      id="5211-t15"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t15}
                    />
                    {value5211t15 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c52x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue5211t16(e.target.value);
                        onClickingViewResponse521();
                      }}
                      id="5211-t16"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t16}
                    />
                    {value5211t16 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5211t17(e.target.value);
                        onClickingViewResponse521();
                      }}
                      id="5211-t17"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t17}
                    />
                    {value5211t17 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5211t18(e.target.value);
                        onClickingViewResponse521();
                      }}
                      id="5211-t18"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t18}
                    />
                    {value5211t18 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5211t19(e.target.value);
                        onClickingViewResponse521();
                      }}
                      id="5211-t19"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t19}
                    />
                    {value5211t19 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5211t20(e.target.value);
                        onClickingViewResponse521();
                      }}
                      id="5211-t20"
                      className="c52x-input-style"
                      type="number"
                      value={value5211t20}
                    />
                    {value5211t20 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <table className="c52x-table-style">
              <tr>
                <th className="c52x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c52x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c52x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c52x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Self attested list of students placed</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5211f1(e.target.files[0]);
                      setPathValue5211f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5211-f1"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5211f1 === "" ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5211f1("");
                      document.getElementById("5211-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Upload any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5211f2(e.target.files[0]);
                      setPathValue5211f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5211-f2"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5211f2 === "" ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5211f2("");
                      document.getElementById("5211-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Details of student placement during the last five years(Data
                  Template)
                </td>
                <td>
                <a href={downloadFile("af5.2.1.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5211f3(e.target.files[0]);
                      setPathValue5211f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5211-f3"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5211f3 === "" ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5211f3("");
                      document.getElementById("5211-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 5.2.2 */}
      <div className="c52x-eachInputField-container">
        <div className="c52x-weightage-container">
          <h1 className="c52x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c52x-container">
            <div className="c52x-heading_Help-container">
              <h1 className="c52x-heading-style">
                <span className="c52x-span-style">5.2.2: </span>
                Average percentage of students qualifying in state/national/international level examinations
                 during the last five years (eg: JAM/CLAT/GATE/ GMAT/CAT/GRE/ TOEFL/ Civil Services/State government examinations)
              </h1>
              <button
                onClick={handleHelpOpen2}
                className="c52x-helpButton-style"
              >
                Help
              </button>
              <HelpButton
                isOpen={isOpen2}
                handleClose={handleHelpClose2}
                title='percentage'
                ><h1>(Total number of outgoing students placed and / or progressed to higher education during the last five yearsTotal number of outgoing students during the last five years )* 100</h1></HelpButton>
            </div>
            <div className="c52x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus522(!responseButtonStatus522);
                  onClickingViewResponse522();
                }}
                className="c52x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus522 ? (
                <p className="c52x-responseResult-style">{responseValue522}</p>
              ) : null}
            </div>
          </div>
          <div className="c52xx-container">
            <h1 className="c52xx-Heading-style">
              <span className="c52xx-span-style">5.2.2.1: 
              Number of outgoing student progressing to higher education.
  
            {/* <input
              onChange={(e) => setValue5221t1(e.target.value)}
              id="5221-t1"
              style={{ width:"20%", marginLeft: "17%" }}
              type="number"
            /> */}
            </span>
            </h1>
            <table className="c52x-Qt-table-style">
              <tr>
                <th className="c52x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => setValue5221t1(e.target.value)}
                      id="5221-t1"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t1}
                    />
                    {value5221t1 === '' ? (
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
                      onChange={(e) => setValue5221t2(e.target.value)}
                      id="5221-t2"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t2}
                    />
                    {value5221t2 === '' ? (
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
                      onChange={(e) => setValue5221t3(e.target.value)}
                      id="5221-t3"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t3}
                    />
                    {value5221t3 === '' ? (
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
                      onChange={(e) => setValue5221t4(e.target.value)}
                      id="5221-t4"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t4}
                    />
                    {value5221t4 === '' ? (
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
                      onChange={(e) => setValue5221t5(e.target.value)}
                      id="5221-t5"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t5}
                    />
                    {value5221t5 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c52x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: 'flex',
                      flexDirection: 'row',
                      borderWidth: '0',
                    }}
                  >
                    <input
                      onChange={(e) => { setValue5221t6(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t6"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t6}
                    />
                    {value5221t6 === '' ? (
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
                      onChange={(e) => { setValue5221t7(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t7"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t7}
                    />
                    {value5221t7 === '' ? (
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
                      onChange={(e) => { setValue5221t8(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t8"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t8}
                    />
                    {value5221t8 === '' ? (
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
                      onChange={(e) => { setValue5221t9(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t9"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t9}
                    />
                    {value5221t9 === '' ? (
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
                      onChange={(e) => { setValue5221t10(e.target.value); onClickingViewResponse522(); }}
                      id="5221-t10"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t10}
                    />
                    {value5221t10 === '' ? (
                      <p style={{ color: 'red' }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            
           
            <table className="c52x-table-style">
              <tr>
                <th className="c52x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c52x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c52x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c52x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Upload supporting data for student/alumni</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5221f1(e.target.files[0]);
                      setPathValue5221f1(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5221-f1"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5221f1 === "" ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5221f1("");
                      document.getElementById("5221-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5221f2(e.target.files[0]);
                      setPathValue5221f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5221-f2"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5221f2 === "" ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5221f2("");
                      document.getElementById("5221-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Details of student progression to higher education(Data
                  Template)
                </td>
                <td>
                <a href={downloadFile("af5.2.2.xlsx")} target="_blank">
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5221f3(e.target.files[0]);
                      setPathValue5221f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5221-f3"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5221f3 === "" ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5221f3("");
                      document.getElementById("5221-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div>

      {/* Key Indicator: 5.2.3
      <div className="c52x-eachInputField-container">
        <div className="c52x-weightage-container">
          <h1 className="c52x-weightage-heading-style">Weightage: 10</h1>
        </div>
        <form>
          <div className="c52x-container">
            <div className="c52x-heading_Help-container">
              <h1 className="c52x-heading-style">
                <span className="c52x-span-style">5.2.3: </span>
                Average percentage of students qualifying in state/national/
                international level examinations during the last five years (eg:
                IIT-JAM/CLAT/ NET/SLET/GATE/ GMAT/CAT/GRE/ TOEFL/ Civil
                Services/State government examinations, etc.)
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
                ><h1>(Total number of students qualified in such examinations during the last five years / Total number of outgoing students (5.2.1.2) - Total number of outgoing students placed) * 100</h1></HelpButton>
            </div>
            <div className="c52x-response-container">
              <button
                onClick={(e) => {
                  e.preventDefault();
                  setResponseButtonStatus522(!responseButtonStatus522);
                  onClickingViewResponse522();
                }}
                className="c52x-responseButton-style"
              >
                View Response
              </button>
              {responseButtonStatus522 ? (
                <p className="c51x-responseResult-style">{responseValue522}</p>
              ) : null}
            </div>
          </div>
          <div className="c52xx-container">
            <h1 className="c52x-heading-style">
              <span className="c52x-span-style">5.2.3.1 </span>
              Number of students qualifying in state/ national/ international
              level examinations (eg: IIT/JAM/ NET/ SLET/ GATE/ GMAT/CAT/GRE/
              TOEFL/ Civil Services/ State government examinations, etc.))
              year-wise during last five years
            </h1>
            <table className="c52x-Qt-table-style">
              <tr>
                <th className="c52x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => setValue5221t1(e.target.value)}
                      id="5221-t1"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t1}
                    />
                    {value5221t1 === "" ? (
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
                    <input
                      onChange={(e) => setValue5221t2(e.target.value)}
                      id="5221-t2"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t2}
                    />
                    {value5221t2 === "" ? (
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
                    <input
                      onChange={(e) => setValue5221t3(e.target.value)}
                      id="5221-t3"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t3}
                    />
                    {value5221t3 === "" ? (
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
                    <input
                      onChange={(e) => setValue5221t4(e.target.value)}
                      id="5221-t4"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t4}
                    />
                    {value5221t4 === "" ? (
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
                    <input
                      onChange={(e) => setValue5221t5(e.target.value)}
                      id="5221-t5"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t5}
                    />
                    {value5221t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c52x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue5221t6(e.target.value);
                        onClickingViewResponse522();
                      }}
                      id="5221-t6"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t6}
                    />
                    {value5221t6 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5221t7(e.target.value);
                        onClickingViewResponse522();
                      }}
                      id="5221-t7"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t7}
                    />
                    {value5221t7 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5221t8(e.target.value);
                        onClickingViewResponse522();
                      }}
                      id="5221-t8"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t8}
                    />
                    {value5221t8 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5221t9(e.target.value);
                        onClickingViewResponse522();
                      }}
                      id="5221-t9"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t9}
                    />
                    {value5221t9 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5221t10(e.target.value);
                        onClickingViewResponse522();
                      }}
                      id="5221-t10"
                      className="c52x-input-style"
                      type="number"
                      value={value5221t10}
                    />
                    {value5221t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <h1 className="c52x-heading-style">
              <span className="c52x-span-style">5.2.3.2 </span>
              Number of students appearing in state/ national/ international
              level examinations (eg: IIT/JAM/ NET / SLET/ GATE/ GMAT/CAT,GRE/
              TOEFL/ Civil Services/ State government examinations) year-wise
              during last five years
            </h1>

            <table className="c52x-Qt-table-style">
              <tr>
                <th className="c52x-horizontalTable-heading-style">Year</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => setValue5222t1(e.target.value)}
                      id="5222-t1"
                      className="c52x-input-style"
                      type="number"
                      value={value5222t1}
                    />
                    {value5222t1 === "" ? (
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
                    <input
                      onChange={(e) => setValue5222t2(e.target.value)}
                      id="5222-t2"
                      className="c52x-input-style"
                      type="number"
                      value={value5222t2}
                    />
                    {value5222t2 === "" ? (
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
                    <input
                      onChange={(e) => setValue5222t3(e.target.value)}
                      id="5222-t3"
                      className="c52x-input-style"
                      type="number"
                      value={value5222t3}
                    />
                    {value5222t3 === "" ? (
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
                    <input
                      onChange={(e) => setValue5222t4(e.target.value)}
                      id="5222-t4"
                      className="c52x-input-style"
                      type="number"
                      value={value5222t4}
                    />
                    {value5222t4 === "" ? (
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
                    <input
                      onChange={(e) => setValue5222t5(e.target.value)}
                      id="5222-t5"
                      className="c52x-input-style"
                      type="number"
                      value={value5222t5}
                    />
                    {value5222t5 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
              <tr>
                <th className="c52x-horizontalTable-heading-style">Number</th>
                <td>
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "row",
                      borderWidth: "0",
                    }}
                  >
                    <input
                      onChange={(e) => {
                        setValue5222t6(e.target.value);
                        onClickingViewResponse522();
                      }}
                      id="5222-t6"
                      className="c52x-input-style"
                      type="number"
                      value={value5222t6}
                    />
                    {value5222t6 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5222t7(e.target.value);
                        onClickingViewResponse522();
                      }}
                      id="5222-t7"
                      className="c52x-input-style"
                      type="number"
                      value={value5222t7}
                    />
                    {value5222t7 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5222t8(e.target.value);
                        onClickingViewResponse522();
                      }}
                      id="5222-t8"
                      className="c52x-input-style"
                      type="number"
                      value={value5222t8}
                    />
                    {value5222t8 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5222t9(e.target.value);
                        onClickingViewResponse522();
                      }}
                      id="5222-t9"
                      className="c52x-input-style"
                      type="number"
                      value={value5222t9}
                    />
                    {value5222t9 === "" ? (
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
                    <input
                      onChange={(e) => {
                        setValue5222t10(e.target.value);
                        onClickingViewResponse522();
                      }}
                      id="5222-t10"
                      className="c52x-input-style"
                      type="number"
                      value={value5222t10}
                    />
                    {value5222t10 === "" ? (
                      <p style={{ color: "red" }}>*</p>
                    ) : null}
                  </div>
                </td>
              </tr>
            </table>
            <table className="c52x-table-style">
              <tr>
                <th className="c52x-Qt-verticalTable-heading1-style">
                  File Description
                </th>
                <th className="c52x-Qt-verticalTable-heading2-style">
                  File Template
                </th>
                <th className="c52x-Qt-verticalTable-heading3-style">
                  Documents upload
                </th>
                <th className="c52x-Qt-verticalTable-heading4-style">
                  File type and size
                </th>
              </tr>
              <tr>
                <td>Upload supporting data for student/alumni</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5222f1(e.target.files[0]);
                      setPathValue5222f1(e.target.value);
                    }}
                    id="5222-f1"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5222f1 === "" ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5222f1("");
                      document.getElementById("5222-f1").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>Any additional information</td>
                <td></td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5222f2(e.target.files[0]);
                      setPathValue5222f2(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5222-f2"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5222f2 === "" ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5222f2("");
                      document.getElementById("5222-f2").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
              <tr>
                <td>
                  Number of students qualifying in state/ national/
                  international level examinations during the last five
                  years(Data Template)
                </td>
                <td>
                  <a href="http://localhost:8080/api/v1/download/criteria5.2.3.xlsx">
                    View Template
                  </a>
                </td>
                <td>
                  <input
                    onChange={(e) => {
                      setValue5222f3(e.target.files[0]);
                      setPathValue5222f3(e.target.value);
                      showFilePreview(e);
                    }}
                    id="5222-f3"
                    type="file"
                    className="c52-fileButton-style"
                  />
                  {pathValue5222f3 === "" ? null : (
                    <div className="c52-fileButtons-container">
                      <button className="c52-viewFileButton-style">
                       <a target="_openfile" href={filePreviewSrc111f1}> View File</a>
                      </button>
                      <button className="c11-removeFileButton-style" 
                      onClick={(e)=>{setPathValue5222f3("");
                      document.getElementById("5222-f3").value="" }} >
                       Reset                     
                     </button>
                    </div>
                  )}
                </td>
                <td className="c52x-Qt-tableBorders-style">pdf</td>
              </tr>
            </table>
          </div>
        </form>
      </div> */}

      <div className="c52x-button-container">
        <button onClick={onClickingSave} className="c52x-button-style">
          Save
        </button>
      </div>
    </div>
  );
}

export default Criteria52;
