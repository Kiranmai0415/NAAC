import { FormControl, FormControlLabel,RadioGroup,Radio } from "@material-ui/core";
import React, { useState } from "react";
import { toast } from "react-toastify";
import "./BasicInfo-style.css"; 
import AuthService from "../../../../Pages/Users/services/auth.service";
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

  const [valuebtr6, setValuebtr6] = useState("");
  const [valuebtr7, setValuebtr7] = useState("");

  const [valuebtip1, setValuebtip1] = useState("");

  const [valuebtl11, setValuebtl11] = useState("");
  const [valuebtl12, setValuebtl12] = useState("");
  const [valuebtl13, setValuebtl13] = useState("");
  const [valuebtl14, setValuebtl14] = useState("");
  const [valuebtl15, setValuebtl15] = useState("");
  const [valuebtl16, setValuebtl16] = useState("");
  const [valuebtl17, setValuebtl17] = useState("");
  const [valuebtl18, setValuebtl18] = useState("");

  
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


  const financialYear="2021-2022";
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },


    basicProfile: [
      {
      
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputbt1: valuebt1,
        inputbt2: valuebt2,
        inputbt3: valuebt3,
        inputbt4: valuebt4,
        inputbt5: valuebt5,
        inputbt6: valuebt6,
      },
    ],

    natureofInstitution:[
      {
        
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputbti1: valuebti1,
        inputbti2: valuebti2,
        inputbti3: valuebti3,
        inputbti4: valuebti4,
        inputbti5: valuebti5,
        
      },
    ],

    
    contactsforCommunication:[
      {
       
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputbtc1: valuebtc1,
        inputbtc2: valuebtc2,
        inputbtc3: valuebtc3,
        inputbtc4: valuebtc4,
        inputbtc5: valuebtc5,
        inputbtc6: valuebtc6,

      },
    ],

    recognizationDetails: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputbtr6: valuebtr6,
        inputbtr7: valuebtr7,

      },
    ],

    basicprofile2: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputbtip1: valuebtip1,
       
      },
    ],

    campus: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1:201,
        inputbtl11: valuebtl11,
        inputbtl12: valuebtl12,
        inputbtl13: valuebtl13,
        inputbtl14: valuebtl14,
        inputbtl15: valuebtl15,
        inputbtl16: valuebtl16,
        inputbtl17: valuebtl17,
        inputbtl18: valuebtl18,
      },
    ],


  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave(e) {
    e.preventDefault();
    const basicData = new FormData();
     console.log(JSON.stringify(inputDataList));

    basicData.append("ssrData", jsonBlob(inputDataList));
    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(resources.APPLICATION_URL+"academicdata", filesFetchMethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Saved Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
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
                  type="text"
                  id="bt1"
             
                  onChange={(e) => setValuebt1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Address</th>
              <td>
                <input
                  type="text"
                  id="bt2"
                  onChange={(e) => setValuebt2(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>City</th>
              <td>
                <input
                  type="text"
                  id="bt3"
                  onChange={(e) => setValuebt3(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>State</th>
              <td>
                <input
                  type="text"
                  id="bt4"
                  onChange={(e) => setValuebt4(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Pin</th>
              <td>
                <input
                  type="number"
                  id="bt5"
                  onChange={(e) => setValuebt5(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Website</th>
              <td>
                <input
                  type="text"
                  id="bt6"
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
                  id="btc1"
                  onChange={(e) => setValuebtc1(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  id="btc2"
                  onChange={(e) => setValuebtc2(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input
                  id="btc3"
                  onChange={(e) => setValuebtc3(e.target.value)}
                  type="number"
                />
              </td>
              <td>
                <input
                  id="btc4"
                  onChange={(e) => setValuebtc4(e.target.value)}
                  type="number"
                />
              </td>
              <td>
                <input
                  id="btc5"
                  onChange={(e) => setValuebtc5(e.target.value)}
                  type="number"
                />
              </td>
              <td>
                <input
                  id="btc6"
                  onChange={(e) => setValuebtc6(e.target.value)}
                  type="text"
                />
              </td>
            </tr>
          </table>
          <table>
            <tr>
              <th style={{ width: "30%" }}>Nature of University</th>
              <td style={{ width: "30%" }}>Institution Status</td>
              <td>
                <input
                  type="text"
                  id="bti1"
                  onChange={(e) => setValuebti1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Type of University</th>
              <th>Type of University</th>
              <td>
                <input
                  type="text"
                  id="bti2"
                  onChange={(e) => setValuebti2(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th rowSpan="4">Establishment Details</th>
            </tr>
            <tr colspan="3">
              <td>Date of establishment of the University</td>
              <td>
                <input
                  type="date"
                  id="bti3"
                  onChange={(e) => setValuebti3(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Status Prior to Establishment (if applicable)</td>
              <td colSpan="2">
                (Autonomous, Constituent, PG Centre, any other){" "}
                <input
                  type="text"
                  id="bti4"
                  onChange={(e) => setValuebti4(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Establishment date of the above status</td>
              <td>
                <input
                  type="date"
                  id="bti5"
                  onChange={(e) => setValuebti5(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
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
                  type="date"
                  id="btr6"
                  onChange={(e) => setValuebtr6(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "40%" }}>12B of UGC</th>
              <td>
                <input
                  type="date"
                  id="btr7"
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
            University with Potential for Excellence
          </label>
          <table>
            <tr>
              <td style={{ width: "60%" }}>
                Is the University Recognised as a 'University with Potential for
                Excellence (UPE)'' by the UGC?
              </td>
              <td className="radio-style">
              <FormControl>
                 <RadioGroup name="radio-buttons-group" >
                   <FormControlLabel value="Yes"
                     onChange={(e) => setValuebtip1(e.target.value)} 
                      control={<Radio />} label="Yes" />
                   <FormControlLabel value="No" 
                     onChange={(e) => setValuebtip1(e.target.value)} 
                      control={<Radio />} label="No" />
                  </RadioGroup>
             </FormControl>
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="basicInfo-t4">
            Location,Campus Area and Programmes offered
          </label>
          <table>
            <tr>
              <th style={{ width: "15%" }}>Campus Type</th>
              <th style={{ width: "15%" }}>Address</th>
              <th>Location</th>
              <th>Campus Area in Acres</th>
              <th>Built up Area in sq.mts.</th>
              <th>Programmes Offered</th>
              <th>Date of Establishment</th>
              <th>Date of Recognition by UGC/MHRD</th>
            </tr>
            <tr>
              <td>
                <input
                  type="text"
                  id="btl11"
                  onChange={(e) => setValuebtl11(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="btl12"
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
                  type="text"
                  id="btl14"
                  onChange={(e) => setValuebtl14(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="btl15"
                  onChange={(e) => setValuebtl15(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="btl16"
                  onChange={(e) => setValuebtl16(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="date"
                  id="btl17"
                  onChange={(e) => setValuebtl17(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="date"
                  id="btl18"
                  onChange={(e) => setValuebtl18(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <div className="t2-button-container">
            <button className="t2-button-style" onClick={onClickingSave}>
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
/* <table>
            <tr>
              <th>College Type</th>
              <th>Number of colleges with permanent affiliation</th>
              <th>Number of colleges with temporary affiliation</th>
            </tr>
            <tr>
              <td>
                <input
                  type="text"
                  style={{ height: "100%" }}
                  id="ac1"
                  onChange={(e) => setValueac1(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  style={{ height: "100%" }}
                  id="ac2"
                  onChange={(e) => setValueac2(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  style={{ height: "100%" }}
                  id="ac3"
                  onChange={(e) => setValueac3(e.target.value)}
                />
              </td>
            </tr>
          </table> */

export default BasicInfo;
