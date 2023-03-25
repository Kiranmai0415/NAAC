import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import "./BasicInfo-style.css";
import { resources } from "../../../../appConstants";
import AuthService from "../../../../Pages/Users/services/auth.service";

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

function BasicInfo() {
  const [valuebt1, setValuebt1] = useState("");
  const [valuebt2, setValuebt2] = useState("");
  const [valuebt3, setValuebt3] = useState("");
  const [valuebt4, setValuebt4] = useState("");
  const [valuebt5, setValuebt5] = useState("");
  const [valuebt6, setValuebt6] = useState("");

  const [valuebtc1, setValuebtc1] = useState("");
  const [valuebtc2, setValuebtc2] = useState("");
  const [valuebtc3, setValuebtc3] = useState("");
  const [valuebtc4, setValuebtc4] = useState("");
  const [valuebtc5, setValuebtc5] = useState("");
  const [valuebtc6, setValuebtc6] = useState("");

  const [valuebti1, setValuebti1] = useState("");
  const [valuebti2, setValuebti2] = useState("");
  const [valuebti3, setValuebti3] = useState("");
  const [valuebti4, setValuebti4] = useState("");
  const [valuebti5, setValuebti5] = useState("");
  const [valuebti6, setValuebti6] = useState("");

  const [valuebti11, setValuebti11] = useState("");
  const [valuebti12, setValuebti12] = useState("");
  const [valuebti13, setValuebti13] = useState("");
  const [pathValuebti13, setPathValuebti13] = useState("");

  const [valuebtr1, setValuebtr1] = useState("");
  const [valuebtr2, setValuebtr2] = useState("");
  const [valuebtr3, setValuebtr3] = useState("");
  const [valuebtr4, setValuebtr4] = useState("");
  const [valuebtr5, setValuebtr5] = useState("");
  const [valuebtr6, setValuebtr6] = useState("");
  const [valuebtr7, setValuebtr7] = useState("");

  const [valuebtp11, setValuebtp11] = useState("");
  const [valuebtp12, setValuebtp12] = useState("");
  const [valuebtp13, setValuebtp13] = useState("");
  const [valuebtp14, setValuebtp14] = useState("");
  const [valuebtp15, setValuebtp15] = useState("");
  const [valuebtp21, setValuebtp21] = useState("");
  const [valuebtp22, setValuebtp22] = useState("");
  const [valuebtp23, setValuebtp23] = useState("");
  const [valuebtp24, setValuebtp24] = useState("");
  const [valuebtp25, setValuebtp25] = useState("");
  const [valuebtp31, setValuebtp31] = useState("");
  const [valuebtp32, setValuebtp32] = useState("");
  const [valuebtp33, setValuebtp33] = useState("");
  const [valuebtp34, setValuebtp34] = useState("");
  const [valuebtp35, setValuebtp35] = useState("");
  const [valuebtp41, setValuebtp41] = useState("");
  const [valuebtp42, setValuebtp42] = useState("");
  const [valuebtp43, setValuebtp43] = useState("");
  const [valuebtp44, setValuebtp44] = useState("");
  const [valuebtp45, setValuebtp45] = useState("");
  const [valuebtp51, setValuebtp51] = useState("");
  const [valuebtp52, setValuebtp52] = useState("");
  const [valuebtp53, setValuebtp53] = useState("");
  const [valuebtp54, setValuebtp54] = useState("");
  const [valuebtp55, setValuebtp55] = useState("");

  const [valuebtpp11, setValuebtpp11] = useState("");
  const [valuebtpp12, setValuebtpp12] = useState("");
  const [valuebtpp13, setValuebtpp13] = useState("");

  const [valuebtpp21, setValuebtpp21] = useState("");
  const [valuebtpp22, setValuebtpp22] = useState("");
  const [valuebtpp23, setValuebtpp23] = useState("");
  const [valuebtpp31, setValuebtpp31] = useState("");
  const [valuebtpp32, setValuebtpp32] = useState("");
  const [valuebtpp33, setValuebtpp33] = useState("");
  // const [valuebtpp41, setValuebtpp41] = useState("");
  // const [valuebtpp42, setValuebtpp42] = useState("");
  const [valuebtpp51, setValuebtpp51] = useState("");
  const [valuebtpp52, setValuebtpp52] = useState("");
  const [valuebtpp53, setValuebtpp53] = useState("");
  const [valuebtpp61, setValuebtpp61] = useState("");
  const [valuebtpp62, setValuebtpp62] = useState("");
  const [valuebtpp63, setValuebtpp63] = useState("");
  const [valuebtpp71, setValuebtpp71] = useState("");
  const [valuebtpp72, setValuebtpp72] = useState("");
  const [valuebtpp73, setValuebtpp73] = useState("");

  const [valuebtd1, setValuebtd1] = useState("");
  const [valuebtd11, setValuebtd11] = useState("");
  const [valuebtd12, setValuebtd12] = useState("");
  const [valuebtd13, setValuebtd13] = useState("");
  const [valuebtd14, setValuebtd14] = useState("");

  const [valuebtip1, setValuebtip1] = useState("");
  const [valuebtip2, setValuebtip2] = useState("");
  const [valuebtip3, setValuebtip3] = useState("");
  const [valuebtip4, setValuebtip4] = useState("");
  const [valuebtip5, setValuebtip5] = useState("");
  const [valuebtip6, setValuebtip6] = useState("");

  const [valuebtl11, setValuebtl11] = useState("");
  const [valuebtl12, setValuebtl12] = useState("");
  const [valuebtl13, setValuebtl13] = useState("");
  const [valuebtl14, setValuebtl14] = useState("");
  const [valuebtl15, setValuebtl15] = useState("");
  const [principalComments, setPrincipalComments] = useState(null);
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState("");


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

  // get call

  useEffect(
    () =>
      fetch(
        'http://localhost:8080/api/v1/getallacademicdata?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));

            setValuebt1(data[0].basicProfile[0]?data[0].basicProfile[0].inputbt1:"")
            setValuebt2(data[0].basicProfile[0]?data[0].basicProfile[0].inputbt2:"")
            setValuebt3(data[0].basicProfile[0]?data[0].basicProfile[0].inputbt3:"")
            setValuebt4(data[0].basicProfile[0]?data[0].basicProfile[0].inputbt4:"")
            setValuebt5(data[0].basicProfile[0]?data[0].basicProfile[0].inputbt5:"")
            setValuebt6(data[0].basicProfile[0]?data[0].basicProfile[0].inputbt6:"")
  
            setValuebtc1(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc1:"")
            setValuebtc2(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc2:"")
            setValuebtc3(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc3:"")
            setValuebtc4(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc4:"")
            setValuebtc5(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc5:"")
            setValuebtc6(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc6:"")
            
            setValuebti1(data[0].natureofInstitution[0]?data[0].natureofInstitution[0].inputbti1:"")
            setValuebti2(data[0].natureofInstitution[0]?data[0].natureofInstitution[0].inputbti2:"")
            setValuebti3(data[0].natureofInstitution[0]?data[0].natureofInstitution[0].inputbti3:"")
            setValuebti4(data[0].natureofInstitution[0]?data[0].natureofInstitution[0].inputbti4:"")
            setValuebti5(data[0].natureofInstitution[0]?data[0].natureofInstitution[0].inputbti5:"")
            setValuebti6(data[0].natureofInstitution[0]?data[0].natureofInstitution[0].inputbti6:"")
  
            setValuebti11(data[0].institutionCollegeAffiliated[0]?data[0].institutionCollegeAffiliated[0].inputbti11:"")
            setValuebti12(data[0].institutionCollegeAffiliated[0]?data[0].institutionCollegeAffiliated[0].inputbti12:"")
  
            setValuebtr1(data[0].recognizedMinority[0]?data[0].recognizedMinority[0].inputbtr1:"")
            setValuebtr2(data[0].recognizedMinority[0]?data[0].recognizedMinority[0].inputbtr2:"")
            setValuebtr3(data[0].recognizedMinority[0]?data[0].recognizedMinority[0].inputbtr3:"")
            setValuebtr4(data[0].recognizedMinority[0]?data[0].recognizedMinority[0].inputbtr4:"")
            setValuebtr5(data[0].recognizedMinority[0]?data[0].recognizedMinority[0].inputbtr5:"")
  
            setValuebtr6(data[0].recognizationDetails[0]?data[0].recognizationDetails[0].inputbtr6:"")
            setValuebtr7(data[0].recognizationDetails[0]?data[0].recognizationDetails[0].inputbtr7:"")
  
            setValuebtpp11(data[0].programmesOffered[0]?data[0].programmesOffered[0].inputpot1:"")
            setValuebtpp12(data[0].programmesOffered[0]?data[0].programmesOffered[0].inputpot2:"")
            setValuebtpp13(data[0].programmesOffered[0]?data[0].programmesOffered[0].inputpot3:"")
  
            setValuebtpp21(data[0].programmesOffered[1]?data[0].programmesOffered[1].inputpot1:"")
            setValuebtpp22(data[0].programmesOffered[1]?data[0].programmesOffered[1].inputpot2:"")
            setValuebtpp23(data[0].programmesOffered[1]?data[0].programmesOffered[1].inputpot3:"")
  
            setValuebtpp31(data[0].programmesOffered[2]?data[0].programmesOffered[2].inputpot1:"")
            setValuebtpp32(data[0].programmesOffered[2]?data[0].programmesOffered[2].inputpot2:"")
            setValuebtpp33(data[0].programmesOffered[2]?data[0].programmesOffered[2].inputpot3:"")
  
           
            // setValuebtpp41(data[0].proffessionalprogrammes[0].inputpost2)
            // setValuebtpp42(data[0].proffessionalprogrammes[0].inputpost3)
  
            setValuebtpp51(data[0].proffessionalprogrammes[0]?data[0].proffessionalprogrammes[0].inputpopt1:"")
            setValuebtpp52(data[0].proffessionalprogrammes[0]?data[0].proffessionalprogrammes[0].inputpopt2:"")
            setValuebtpp53(data[0].proffessionalprogrammes[0]?data[0].proffessionalprogrammes[0].inputpopt3:"")
  
            setValuebtpp61(data[0].proffessionalprogrammes[1]?data[0].proffessionalprogrammes[1].inputpopt1:"")
            setValuebtpp62(data[0].proffessionalprogrammes[1]?data[0].proffessionalprogrammes[1].inputpopt2:"")
            setValuebtpp63(data[0].proffessionalprogrammes[1]?data[0].proffessionalprogrammes[1].inputpopt3:"")
  
            setValuebtpp71(data[0].proffessionalprogrammes[2]?data[0].proffessionalprogrammes[2].inputpopt1:"")
            setValuebtpp72(data[0].proffessionalprogrammes[2]?data[0].proffessionalprogrammes[2].inputpopt2:"")
            setValuebtpp73(data[0].proffessionalprogrammes[2]?data[0].proffessionalprogrammes[2].inputpopt3:"")
  
  
  
            setValuebtp11(data[0].programmeIntroduced[0]?data[0].programmeIntroduced[0].inputbtp11:"")
            setValuebtp12(data[0].programmeIntroduced[0]?data[0].programmeIntroduced[0].inputbtp12:"")
            setValuebtp13(data[0].programmeIntroduced[0]?data[0].programmeIntroduced[0].inputbtp13:"")
            setValuebtp14(data[0].programmeIntroduced[0]?data[0].programmeIntroduced[0].inputbtp14:"")
            setValuebtp15(data[0].programmeIntroduced[0]?data[0].programmeIntroduced[0].inputbtp15:"")
  
            setValuebtp21(data[0].programmeIntroduced[1]?data[0].programmeIntroduced[1].inputbtp11:"")
            setValuebtp22(data[0].programmeIntroduced[1]?data[0].programmeIntroduced[1].inputbtp12:"")
            setValuebtp23(data[0].programmeIntroduced[1]?data[0].programmeIntroduced[1].inputbtp13:"")
            setValuebtp24(data[0].programmeIntroduced[1]?data[0].programmeIntroduced[1].inputbtp14:"")
            setValuebtp25(data[0].programmeIntroduced[1]?data[0].programmeIntroduced[1].inputbtp15:"")
  
            setValuebtp31(data[0].programmeIntroduced[2]?data[0].programmeIntroduced[2].inputbtp11:"")
            setValuebtp32(data[0].programmeIntroduced[2]?data[0].programmeIntroduced[2].inputbtp12:"")
            setValuebtp33(data[0].programmeIntroduced[2]?data[0].programmeIntroduced[2].inputbtp13:"")
            setValuebtp34(data[0].programmeIntroduced[2]?data[0].programmeIntroduced[2].inputbtp14:"")
            setValuebtp35(data[0].programmeIntroduced[2]?data[0].programmeIntroduced[2].inputbtp15:"")
  
            setValuebtp41(data[0].programmeIntroduced[3]?data[0].programmeIntroduced[3].inputbtp11:"")
            setValuebtp42(data[0].programmeIntroduced[3]?data[0].programmeIntroduced[3].inputbtp12:"")
            setValuebtp43(data[0].programmeIntroduced[3]?data[0].programmeIntroduced[3].inputbtp13:"")
            setValuebtp44(data[0].programmeIntroduced[3]?data[0].programmeIntroduced[3].inputbtp14:"")
            setValuebtp45(data[0].programmeIntroduced[3]?data[0].programmeIntroduced[3].inputbtp15:"")
  
            setValuebtp51(data[0].programmeIntroduced[4]?data[0].programmeIntroduced[4].inputbtp11:"")
            setValuebtp52(data[0].programmeIntroduced[4]?data[0].programmeIntroduced[4].inputbtp12:"")
            setValuebtp53(data[0].programmeIntroduced[4]?data[0].programmeIntroduced[4].inputbtp13:"")
            setValuebtp54(data[0].programmeIntroduced[4]?data[0].programmeIntroduced[4].inputbtp14:"")
            setValuebtp55(data[0].programmeIntroduced[4]?data[0].programmeIntroduced[4].inputbtp15:"")
  
            //
  
  
            //
            setValuebtd1(data[0].recognition[0]?data[0].recognition[0].inputbtd11:"")
            setValuebtd11(data[0].recognition[0]?data[0].recognition[0].inputbtd12:"")
            setValuebtd12(data[0].recognition[0]?data[0].recognition[0].inputbtd13:"")
            setValuebtd13(data[0].recognition[0]?data[0].recognition[0].inputbtd14:"")
            setValuebtd14(data[0].recognition[0]?data[0].recognition[0].inputbtd15:"")
  
            //
            setValuebtip1(data[0].basicprofile2[0]?data[0].basicprofile2[0].inputbtip1:"")
            setValuebtip2(data[0].basicprofile2[0]?data[0].basicprofile2[0].inputbtip2:"")
            setValuebtip3(data[0].basicprofile2[0]?data[0].basicprofile2[0].inputbtip3:"")
            setValuebtip4(data[0].basicprofile2[0]?data[0].basicprofile2[0].inputbtip4:"")
            setValuebtip5(data[0].basicprofile2[0]?data[0].basicprofile2[0].inputbtip5:"")
            setValuebtip6(data[0].basicprofile2[0]?data[0].basicprofile2[0].inputbtip6:"")
  
            //
            setValuebtl11(data[0].campus[0]?data[0].campus[0].inputbtl11:"")
            setValuebtl12(data[0].campus[0]?data[0].campus[0].inputbtl12:"")
            setValuebtl13(data[0].campus[0]?data[0].campus[0].inputbtl13:"")
            setValuebtl14(data[0].campus[0]?data[0].campus[0].inputbtl14:"")
            setValuebtl15(data[0].campus[0]?data[0].campus[0].inputbtl15:"")
  
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );
  let role = null;
  let email = null;
  // eslint-disable-next-line prefer-destructuring, no-undef
  role = AuthService.getCurrentUser().roles[0];
  // eslint-disable-next-line no-undef
  email = AuthService.getCurrentUser().email;

  const authorize = {
    criteriaId: {
      collegeId: collegeId,
       financialYear: fYear,
       typeofInstitution:instituteType,
     },
    assignedTo: "deepak.adiversetech@gmail.com",
    assignedBy: email,
    principalComments: "",
    role:role,
    deanStatus: "A",
    programmerId: "basicinfo",
  };

  const rejectContent = {
    criteriaId: {
      collegeId: collegeId,
       financialYear: fYear,
       typeofInstitution:instituteType,
     },
    assignedTo: "deepak.adiversetech@gmail.com",
    assignedBy: email,
    role:role,
    deanStatus: "R",
    deanComments: rejectReasonComments,
    programmerId: "basicinfo",
  };
  // eslint-disable-next-line no-redeclare
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }
  function getAuthorizeBasicinfo(e) {
    e.preventDefault();
    console.log("Authorize IIQA");
    const authAPIMethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(authorize),
    };
    fetch(
      resources.APPLICATION_URL +
        'ssruploadsubmittoprincipal?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
      authAPIMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record Authorized Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }
  function getRejectBasicinfo() {
    console.log("Assigned");
    const rejectAPImethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(rejectContent),
    };
    fetch(
      resources.APPLICATION_URL +
        'ssruploadsubmittoprincipal?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Rejected Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }
  // rendering DOM
  return (
    <div className="main-container">
      <h1 className="main-heading-style">Basic Information</h1>
      <div className="eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th colSpan="2">Name and Address of the College</th>
            </tr>
            <tr>
              <th className="BI-table1-headings">Name</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="bt1"
                  value={valuebt1}
                  onChange={(e) => setValuebt1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Address</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="bt2"
                  value={valuebt2}
                  onChange={(e) => setValuebt2(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>City</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="bt3"
                  value={valuebt3}
                  onChange={(e) => setValuebt3(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>State</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="bt4"
                  value={valuebt4}
                  onChange={(e) => setValuebt4(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Pin</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="bt5"
                  value={valuebt5}
                  onChange={(e) => setValuebt5(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Website</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="bt6"
                  value={valuebt6}
                  onChange={(e) => setValuebt6(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t2">Contacts for Communication</label>
          <table id="basicInfo-t2">
            <tr>
              <th style={{ width: "20%" }}>Designation</th>
              <th style={{ width: "20%" }}>Name</th>
              <th style={{ width: "15%" }}>Telephone with STD with code</th>
              <th style={{ width: "20%" }}>Mobile</th>
              <th style={{ width: "10%" }}>Fax</th>
              <th style={{ width: "20%" }}>e-mail</th>
            </tr>
            <tr>
              <td>
                <input
                  readonly
                  id="btc1"
                  value={valuebt3}
                  onChange={(e) => setValuebtc1(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc2"
                  value={valuebtc2}
                  onChange={(e) => setValuebtc2(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc3"
                  value={valuebtc3}
                  onChange={(e) => setValuebtc3(e.target.value)}
                  type="number"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc4"
                  value={valuebtc4}
                  onChange={(e) => setValuebtc4(e.target.value)}
                  type="number"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc5"
                  value={valuebtc5}
                  onChange={(e) => setValuebtc5(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  readonly
                  id="btc6"
                  value={valuebtc6}
                  onChange={(e) => setValuebtc6(e.target.value)}
                  type="email"
                />
              </td>
            </tr>
          </table>
          <table>
            <tr>
              <th style={{ width: "30%" }}>Nature of Institution</th>
              <td style={{ width: "30%" }}>Institution Status</td>
              <td>
                <input
                  readonly
                  type="text"
                  id="bti1"
                  value={valuebti1}
                  onChange={(e) => setValuebti1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th rowSpan="2">Type of Institution</th>
              <th>By Gender</th>
              <td>
                <input
                  readonly
                  type="text"
                  id="bti2"
                  value={valuebti2}
                  onChange={(e) => setValuebti2(e.target.value)}
                />
              </td>
            </tr>
            <th>By Shift</th>
            <td>
              <input
                readonly
                type="text"
                id="bti3"
                value={valuebti3}
                onChange={(e) => setValuebti3(e.target.value)}
              />
            </td>
            <tr>
              <th rowSpan="4">Establishment Details</th>
            </tr>
            <tr colspan="3">
              <td>Date of establishment, prior to the grant of (Autonomy)</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="bti4"
                  value={valuebti4}
                  onChange={(e) => setValuebti4(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Date of grant of 'Autonomy' to the college by UGC</td>
              <td colSpan="2">
                (Autonomous, Constituent, PG Centre, any other){" "}
                <input
                  readonly
                  type="number"
                  id="bti5"
                  value={valuebti5}
                  onChange={(e) => setValuebti5(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Establishment date</td>
              <td>
                <input
                  readonly
                  type="number"
                  id="bti6"
                  value={valuebti6}
                  onChange={(e) => setValuebti6(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t3">
            Institution to which the college if affiliated
          </label>
          <table>
            <tr>
              <th>State</th>
              <th>Institution Name</th>
              <th>View Document</th>
            </tr>
            <tr>
              <td>
                Religious{" "}
                <input
                  readonly
                  type="text"
                  id="bti11"
                  value={valuebti11}
                  onChange={(e) => setValuebti11(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="bti12"
                  value={valuebti12}
                  onChange={(e) => setValuebti12(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="file"
                  id="bti13"
                  value={valuebti13}
                  onChange={(e) => {
                    setValuebti13(e.target.files[0]);
                    setPathValuebti13(e.target.value);
                  }}
                />
                {pathValuebti13 === "" ? null : (
                  <div className="c21-fileButtons-container">
                    <button className="c21-viewFileButton-style">
                      View File
                    </button>
                    <button className="c21-removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )}
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <from>
          <label htmlFor="basicInfo-t4">Recognized Minority Institution</label>
          <table>
            <tr>
              <td style={{ width: "40%" }}>
                If it is a recognized minority institution
              </td>
              <td>
                <label htmlFor="btr1">Yes</label>
                <input
                  readonly
                  type="radio"
                  id="btr1"
                  name="radio-option"
                  value={valuebtr1}
                  onChange={(e) => setValuebtr1(e.target.value)}
                />
              </td>
              <td>
                <label for="btr1">No</label>
                <input
                  readonly
                  type="radio"
                  id="btr1"
                  name="radio-option"
                  value={valuebtr1}
                  onChange={(e) => setValuebtr1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>If yes, Specify minority status</td>
              <td colspan="2">
                <input
                  readonly
                  type="text"
                  id="btr2"
                  value={valuebtr2}
                  onChange={(e) => setValuebtr2(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Religios</td>
              <td colspan="2">
                <input
                  readonly
                  type="text"
                  id="btr3"
                  value={valuebtr3}
                  onChange={(e) => setValuebtr3(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Linguistic</td>
              <td colspan="2">
                <input
                  readonly
                  type="text"
                  id="btr4"
                  value={valuebtr4}
                  onChange={(e) => setValuebtr4(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Any Other</td>
              <td colspan="2">
                <input
                  readonly
                  type="text"
                  id="btr5"
                  value={valuebtr5}
                  onChange={(e) => setValuebtr5(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </from>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t4">Recognition Details</label>
          <table>
            <tr>
              <th colspan="2">
                Date of Recognition by UGC or any Other National Agency
              </th>
            </tr>
            <tr>
              <th style={{ width: "40%" }}>Under Section</th>
              <th>Date</th>
            </tr>
            <tr>
              <th style={{ width: "40%" }}>2f of UGC</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="btr6"
                  value={valuebtr6}
                  onChange={(e) => setValuebtr6(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "40%" }}>12B of UGC</th>
              <td>
                <input
                  readonly
                  type="number"
                  id="btr7"
                  value={valuebtr7}
                  onChange={(e) => setValuebtr7(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t4">
            New Programme introduced during the last five years:
          </label>
          <table>
            <tr>
              <th rowspan="2" align="center">
                Latest Year
              </th>
              <th colspan="2">
                No of New Programmes introduced during the last five years and
                name{" "}
              </th>
              <th colspan="2">
                Programs not covered under the Autonomous status of UGC
              </th>
            </tr>
            <tr>
              <th>No.</th>
              <th>Name</th>
              <th>UG</th>
              <th>PG</th>
            </tr>
            <tr>
              <th>
                <input
                  readonly
                  type="number"
                  id="btp11"
                  value={valuebtp11}
                  onChange={(e) => setValuebtp11(e.target.value)}
                />
              </th>
              <td>
                <input
                  readonly
                  type="number"
                  id="btp12"
                  value={valuebtp12}
                  onChange={(e) => setValuebtp12(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp13"
                  value={valuebtp13}
                  onChange={(e) => setValuebtp13(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp14"
                  value={valuebtp14}
                  onChange={(e) => setValuebtp14(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp15"
                  value={valuebtp15}
                  onChange={(e) => setValuebtp15(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                <input
                  readonly
                  type="number"
                  id="btp21"
                  value={valuebtp21}
                  onChange={(e) => setValuebtp21(e.target.value)}
                />
              </th>
              <td>
                <input
                  readonly
                  type="number"
                  id="btp22"
                  value={valuebtp22}
                  onChange={(e) => setValuebtp22(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp23"
                  value={valuebtp23}
                  onChange={(e) => setValuebtp23(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp24"
                  value={valuebtp24}
                  onChange={(e) => setValuebtp24(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp25"
                  value={valuebtp25}
                  onChange={(e) => setValuebtp25(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                <input
                  readonly
                  type="number"
                  id="btp31"
                  value={valuebtp31}
                  onChange={(e) => setValuebtp31(e.target.value)}
                />
              </th>
              <td>
                <input
                  readonly
                  type="number"
                  id="btp32"
                  value={valuebtp32}
                  onChange={(e) => setValuebtp32(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp33"
                  value={valuebtp33}
                  onChange={(e) => setValuebtp33(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp34"
                  value={valuebtp34}
                  onChange={(e) => setValuebtp34(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp35"
                  value={valuebtp35}
                  onChange={(e) => setValuebtp35(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                <input
                  readonly
                  type="number"
                  id="btp41"
                  value={valuebtp41}
                  onChange={(e) => setValuebtp41(e.target.value)}
                />
              </th>
              <td>
                <input
                  readonly
                  type="number"
                  id="btp42"
                  value={valuebtp42}
                  onChange={(e) => setValuebtp42(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp43"
                  value={valuebtp43}
                  onChange={(e) => setValuebtp43(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp44"
                  value={valuebtp44}
                  onChange={(e) => setValuebtp44(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp45"
                  value={valuebtp45}
                  onChange={(e) => setValuebtp45(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                <input
                  readonly
                  type="number"
                  id="btp51"
                  value={valuebtp51}
                  onChange={(e) => setValuebtp51(e.target.value)}
                />
              </th>
              <td>
                <input
                  readonly
                  type="number"
                  id="btp52"
                  value={valuebtp52}
                  onChange={(e) => setValuebtp52(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp53"
                  value={valuebtp53}
                  onChange={(e) => setValuebtp53(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp54"
                  value={valuebtp54}
                  onChange={(e) => setValuebtp54(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btp55"
                  value={valuebtp55}
                  onChange={(e) => setValuebtp55(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <table>
            <tr>
              <th>Programmes offered</th>
              <th>Aided</th>
              <th>Self-financed</th>
            </tr>
            <tr>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp11"
                  value={valuebtpp11}
                  onChange={(e) => setValuebtpp11(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp12"
                  value={valuebtpp12}
                  onChange={(e) => setValuebtpp12(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp13"
                  value={valuebtpp13}
                  onChange={(e) => setValuebtpp13(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp21"
                  value={valuebtpp21}
                  onChange={(e) => setValuebtpp21(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp22"
                  value={valuebtpp22}
                  onChange={(e) => setValuebtpp22(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp23"
                  value={valuebtpp23}
                  onChange={(e) => setValuebtpp23(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp31"
                  value={valuebtpp31}
                  onChange={(e) => setValuebtpp31(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp32"
                  value={valuebtpp32}
                  onChange={(e) => setValuebtpp32(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp33"
                  value={valuebtpp33}
                  onChange={(e) => setValuebtpp33(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Proffessional Programmes Offered</th>
              <td>
                {/* <input readonly
                  type="text"
                  id="btpp41"
                  value={valuebtpp41}
                  onChange={(e) => setValuebtpp41(e.target.value)}
                /> */}
              </td>
              <td>
                {/* <input readonly
                  type="text"
                  id="btpp42"
                  value={valuebtpp42}
                  onChange={(e) => setValuebtpp42(e.target.value)}
                /> */}
              </td>
            </tr>
            <tr>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp51"
                  value={valuebtpp51}
                  onChange={(e) => setValuebtpp51(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp52"
                  value={valuebtpp52}
                  onChange={(e) => setValuebtpp52(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp53"
                  value={valuebtpp53}
                  onChange={(e) => setValuebtpp53(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp61"
                  value={valuebtpp61}
                  onChange={(e) => setValuebtpp61(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp62"
                  value={valuebtpp62}
                  onChange={(e) => setValuebtpp62(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp63"
                  value={valuebtpp63}
                  onChange={(e) => setValuebtpp63(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp71"
                  value={valuebtpp71}
                  onChange={(e) => setValuebtpp71(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp72"
                  value={valuebtpp72}
                  onChange={(e) => setValuebtpp72(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btpp73"
                  value={valuebtpp73}
                  onChange={(e) => setValuebtpp73(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t4">Details of Recognition</label>
          <table>
            <tr>
              <th colspan="5">
                Details of Recognition / Approval by Statutory/ Regulatory
                bodies like AICTE, NCTE, MCI, DCI, PCI, RCI, etc (other tha UGC)
              </th>
            </tr>
            <tr>
              <th style={{ width: "20%" }}>Statutory Authority Regulatory</th>
              <th style={{ width: "25%" }}>
                Recognition / Approval details Institution/ Department Programme
              </th>
              <th style={{ width: "20%" }}>Day, Month, Year (DD/MM/YYYY)</th>
              <th>Validity in months</th>
              <th>Remarks</th>
            </tr>
            <tr>
              <th>
                <select name="course" id="courses">
                  <option
                    id="btd1"
                    value="Select"
                    onChange={(e) => setValuebtd1(e.target.value)}
                  >
                    Select
                  </option>
                  <option
                    id="btd1"
                    value="NCTE"
                    onChange={(e) => setValuebtd1(e.target.value)}
                  >
                    NCTE
                  </option>
                  <option
                    id="btd1"
                    value="AICTE"
                    onChange={(e) => setValuebtd1(e.target.value)}
                  >
                    AICTE
                  </option>
                  <option
                    id="btd1"
                    value="DCI"
                    onChange={(e) => setValuebtd1(e.target.value)}
                  >
                    DCI
                  </option>
                  <option
                    id="btd1"
                    value="PCI"
                    onChange={(e) => setValuebtd1(e.target.value)}
                  >
                    PCI
                  </option>
                  <option
                    id="btd1"
                    value="ICAR"
                    onChange={(e) => setValuebtd1(e.target.value)}
                  >
                    ICAR
                  </option>
                  <option
                    id="btd1"
                    value="INC"
                    onChange={(e) => setValuebtd1(e.target.value)}
                  >
                    INC
                  </option>
                  <option
                    id="btd1"
                    value="BCI"
                    onChange={(e) => setValuebtd1(e.target.value)}
                  >
                    BCI
                  </option>
                  <option
                    id="btd1"
                    value="CCIM"
                    onChange={(e) => setValuebtd1(e.target.value)}
                  >
                    CCIM
                  </option>
                  <option
                    id="btd1"
                    value="MCI"
                    onChange={(e) => setValuebtd1(e.target.value)}
                  >
                    MCI
                  </option>
                  <option
                    id="btd1"
                    value="CCH"
                    onChange={(e) => setValuebtd1(e.target.value)}
                  >
                    CCH
                  </option>
                  <option
                    id="btd1"
                    value="COA"
                    onChange={(e) => setValuebtd1(e.target.value)}
                  >
                    COA
                  </option>
                  <option
                    id="btd1"
                    value="RCI"
                    onChange={(e) => setValuebtd1(e.target.value)}
                  >
                    RCI
                  </option>
                </select>
              </th>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd11"
                  value={valuebtd11}
                  onChange={(e) => setValuebtd11(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="date"
                  id="btd12"
                  value={valuebtd12}
                  onChange={(e) => setValuebtd12(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="number"
                  id="btd13"
                  value={valuebtd13}
                  onChange={(e) => setValuebtd13(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btd14"
                  value={valuebtd14}
                  onChange={(e) => setValuebtd14(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t4">
            Institution with Potential for Excellence
          </label>
          <table>
            <tr>
              <td style={{ width: "60%" }}>
                Is the college recognition of UGC as a College with Potential
                for Excellence
              </td>
              <td className="radio-style">
                <label for="btip1">Yes</label>
                <input
                  readonly
                  type="radio"
                  id="btip1"
                  name="radio-option1"
                  value={valuebtip1}
                  onChange={(e) => setValuebtip1(e.target.value)}
                />
              </td>
              <td className="radio-style">
                <label for="btip1">No</label>
                <input
                  readonly
                  type="radio"
                  id="btip1"
                  name="radio-option1"
                  value={valuebtip1}
                  onChange={(e) => setValuebtip1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>(CPE)?</td>
              <td colspan="2">
                <input
                  readonly
                  type="text"
                  id="btip2"
                  value={valuebtip2}
                  onChange={(e) => setValuebtip2(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>If yes, date of recognition?</td>
              <td colspan="2">
                <input
                  readonly
                  type="number"
                  id="btip3"
                  value={valuebtip3}
                  onChange={(e) => setValuebtip3(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>
                Is the college recognized for its performance by any other
                goverment agency?
              </td>
              <td>
                Yes{" "}
                <input
                  readonly
                  type="radio"
                  id="btip4"
                  name="radio-option2"
                  value={valuebtip4}
                  onChange={(e) => setValuebtip4(e.target.value)}
                />
              </td>
              <td>
                No{" "}
                <input
                  readonly
                  type="radio"
                  id="btip4"
                  name="radio-option2"
                  value={valuebtip4}
                  onChange={(e) => setValuebtip4(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>If yes name the agency</td>
              <td colspan="2">
                <input
                  readonly
                  type="text"
                  id="btip5"
                  value={valuebtip5}
                  onChange={(e) => setValuebtip5(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Date of recognition</td>
              <td colspan="2">
                <input
                  readonly
                  type="number"
                  id="btip6"
                  value={valuebtip6}
                  onChange={(e) => setValuebtip6(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t4">
            Location, Area and Activity of Campus
          </label>
          <table>
            <tr>
              <th style={{ width: "15%" }}>Campus Type</th>
              <th style={{ width: "25%" }}>Address</th>
              <th>Location</th>
              <th>Campus Area in Acres</th>
              <th>Built up Area in sq.mts.</th>
            </tr>
            <tr>
              <td>
                <input
                  readonly
                  type="text"
                  id="btl11"
                  value={valuebtl11}
                  onChange={(e) => setValuebtl11(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btl12"
                  value={valuebtl12}
                  onChange={(e) => setValuebtl12(e.target.value)}
                />
              </td>
              <td>
                Urban
                <select name="course" id="courses">
                  <option
                    id="btl13"
                    value="Select"
                    onChange={(e) => setValuebtl13(e.target.value)}
                  >
                    Select
                  </option>
                  <option
                    id="btl13"
                    value="Urban"
                    onChange={(e) => setValuebtl13(e.target.value)}
                  >
                    Urban
                  </option>
                  <option
                    id="btl13"
                    value="Semi Urban"
                    onChange={(e) => setValuebtl13(e.target.value)}
                  >
                    Semi Urban
                  </option>
                  <option
                    id="btl13"
                    value="Rural"
                    onChange={(e) => setValuebtl13(e.target.value)}
                  >
                    Rural
                  </option>
                  <option
                    id="btl13"
                    value="Tribal"
                    onChange={(e) => setValuebtl13(e.target.value)}
                  >
                    Tribal
                  </option>
                  <option
                    id="btl13"
                    value="Hill"
                    onChange={(e) => setValuebtl13(e.target.value)}
                  >
                    Hill
                  </option>
                </select>
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btl14"
                  value={valuebtl14}
                  onChange={(e) => setValuebtl14(e.target.value)}
                />
              </td>
              <td>
                <input
                  readonly
                  type="text"
                  id="btl15"
                  value={valuebtl15}
                  onChange={(e) => setValuebtl15(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <div>Principal Comments : {principalComments}</div>
          <div className="c31x-button-container">
            <button
              onClick={(e) => {
                getAuthorizeBasicinfo(e);
              }}
              className="c31x-button-style"
              style={{ color: "white", backgroundColor: "green" }}
            >
              Authorize
            </button>

            <button
              onClick={(e) => {
                setRejectButtonClickStatus(true);
                e.preventDefault();
              }}
              className="c31x-button-style"
              style={{ color: "white", backgroundColor: "red" }}
            >
              Reject
            </button>
          </div>
          {rejectButtonClickStatus ? (
            <div style={{ marginLeft: "13%" }}>
              <h1>Reason for Rejection</h1>
              <textarea
                cols={110}
                rows={6}
                onChange={(e) => setRejectReasonComments(e.target.value)}
              ></textarea>
              <div>
                <button
                  onClick={() => setRejectButtonClickStatus(false)}
                  style={{
                    color: "black",
                    backgroundColor: "white",
                    borderRadius: "4px",
                    marginRight: "3%",
                    boxShadow:
                      "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
                  }}
                >
                  Cancel
                </button>
                <button
                  onClick={(e) => {
                    setRejectButtonClickStatus(false);
                    getRejectBasicinfo(e);
                  }}
                  style={{
                    color: "black",
                    backgroundColor: "white",
                    borderRadius: "4px",
                    boxShadow:
                      "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
                  }}
                >
                  Confirm Reject
                </button>
              </div>
            </div>
          ) : null}
        </form>
      </div>
    </div>
  );
}

export default BasicInfo;
<></>;
