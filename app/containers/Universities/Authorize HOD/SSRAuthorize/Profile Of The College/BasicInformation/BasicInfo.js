import React, { useState ,useEffect } from "react";
import { toast } from "react-toastify";
import "./BasicInfo-style.css";
import { resources } from "../../../../../appConstants";
import AuthService from "../../../../../Pages/Users/services/auth.service";

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



   //get call
   const financialYear="2021-2022";
   useEffect(
    () => fetch('http://localhost:8080/api/v1/getallacademicdata?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));

          //
          setValuebt1(data[0].basicProfile[0]?data[0].basicProfile[0].inputbt1:"");
          setValuebt2(data[0].basicProfile[0]?data[0].basicProfile[0].inputbt2:"");
          setValuebt3(data[0].basicProfile[0]?data[0].basicProfile[0].inputbt3:"");
          setValuebt4(data[0].basicProfile[0]?data[0].basicProfile[0].inputbt4:"");
          setValuebt5(data[0].basicProfile[0]?data[0].basicProfile[0].inputbt5:"");
          setValuebt6(data[0].basicProfile[0]?data[0].basicProfile[0].inputbt6:"");

          setValuebtc1(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc1:"");
          setValuebtc2(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc2:"");
          setValuebtc3(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc3:"");
          setValuebtc4(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc4:"");
          setValuebtc5(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc5:"");
          setValuebtc6(data[0].contactsforCommunication[0]?data[0].contactsforCommunication[0].inputbtc6:"");

          setValuebti1(data[0].natureofInstitution[0]?data[0].natureofInstitution[0].inputbti1:"");
          setValuebti2(data[0].natureofInstitution[0]?data[0].natureofInstitution[0].inputbti2:"");
          setValuebti3(data[0].natureofInstitution[0]?data[0].natureofInstitution[0].inputbti3:"");
          setValuebti4(data[0].natureofInstitution[0]?data[0].natureofInstitution[0].inputbti4:"");
          setValuebti5(data[0].natureofInstitution[0]?data[0].natureofInstitution[0].inputbti5:"");

          setValuebtr6(data[0].recognizationDetails[0]?data[0].recognizationDetails[0].inputbtr6:"");
          setValuebtr7(data[0].recognizationDetails[0]?data[0].recognizationDetails[0].inputbtr7:"");

          //
          setValuebtip1(data[0].basicprofile2[0]?data[0].basicprofile2[0].inputbtip11:"");

          //
          setValuebtl11(data[0].campus[0]?data[0].campus[0].inputbtl11:"");
          setValuebtl12(data[0].campus[0]?data[0].campus[0].inputbtl12:"");
          setValuebtl13(data[0].campus[0]?data[0].campus[0].inputbtl13:"");
          setValuebtl14(data[0].campus[0]?data[0].campus[0].inputbtl14:"");
          setValuebtl15(data[0].campus[0]?data[0].campus[0].inputbtl15:"");
          setValuebtl16(data[0].campus[0]?data[0].campus[0].inputbtl16:"");
          setValuebtl17(data[0].campus[0]?data[0].campus[0].inputbtl17:"");
          setValuebtl18(data[0].campus[0]?data[0].campus[0].inputbtl18:"");


       
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ), []
  );
 
  let role = null;
  let email = null;
  // eslint-disable-next-line prefer-destructuring, no-undef
  role = AuthService.getCurrentUser().roles[0];
  // eslint-disable-next-line no-undef
  email = AuthService.getCurrentUser().email;
  const finacialyear = "2021-2022";
  const authorize = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    assignedTo: "deepak.adiversetech@gmail.com",
    assignedBy: email,
    principalComments: "A",
    
    role:role,
    principalStatus: "A",
    programmerId: "basicinfo",
  };

  const rejectContent = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

    assignedTo:  "deepak.adiversetech@gmail.com",
    assignedBy: email,
    role:role,
    principalStatus: "R",
    principalComments: rejectReasonComments,
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
    }
    fetch(
      resources.APPLICATION_URL
        + 'academicdatasubmittoprincipal?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
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
    }
    fetch(
      resources.APPLICATION_URL
        + 'academicdatasubmittoprincipal?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
      rejectAPImethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Rejected Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
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
                <input readonly
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
                <input readonly
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
                <input readonly
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
                <input readonly
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
                <input readonly
                  type="text"
                  id="bt5"
                  value={valuebt5}
                  onChange={(e) => setValuebt5(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Website</th>
              <td>
                <input readonly
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
                <input readonly
                  id="btc1"
                  value={valuebtc1}
                  onChange={(e) => setValuebtc1(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input readonly
                  id="btc2"
                  value={valuebtc2}
                  onChange={(e) => setValuebtc2(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input readonly
                  id="btc3"
                  value={valuebtc3}
                  onChange={(e) => setValuebtc3(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input readonly
                  id="btc4"
                  value={valuebtc4}
                  onChange={(e) => setValuebtc4(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input readonly
                  id="btc5"
                  value={valuebtc5}
                  onChange={(e) => setValuebtc5(e.target.value)}
                  type="text"
                />
              </td>
              <td>
                <input readonly
                  id="btc6"
                  value={valuebtc6}
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
                <input readonly
                  type="text"
                  id="bti1"
                  value={valuebti1}
                  onChange={(e) => setValuebti1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Type of University</th>
              <th>Type of University</th>
              <td>
                <input readonly
                  type="text"
                  id="bti2"
                  value={valuebti2}
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
                <input readonly
                  type="text"
                  id="bti3"
                  value={valuebti3}
                  onChange={(e) => setValuebti3(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Status Prior to Establishment (if applicable)</td>
              <td colSpan="2">
                (Autonomous, Constituent, PG Centre, any other){" "}
                <input readonly
                  type="text"
                  id="bti4"
                  value={valuebti4}
                  onChange={(e) => setValuebti4(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Establishment date of the above status</td>
              <td>
                <input readonly
                  type="text"
                  id="bti5"
                  value={valuebti5}
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
                <input readonly
                  type="text"
                  id="btr6"
                  value={valuebtr6}
                  onChange={(e) => setValuebtr6(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "40%" }}>12B of UGC</th>
              <td>
                <input readonly
                  type="text"
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
            University with Potential for Excellence
          </label>
          <table>
            <tr>
              <td style={{ width: "60%" }}>
                Is the University Recognised as a 'University with Potential for
                Excellence (UPE)'' by the UGC?
              </td>
              <td className="radio-style">
                <label for="btip1">Yes</label>
                <input readonly
                  type="radio"
                  id="btip1"
                  name="opion11"
                  value="Yes"
                  onChange={(e) => setValuebtip1(e.target.value)}
                />
              </td>
              <td className="radio-style">
                <label for="btip1">No</label>
                <input readonly
                  type="radio"
                  id="btip1"
                  name="opion11"
                  value="No"
                  onChange={(e) => setValuebtip1(e.target.value)}
                />
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
                <input readonly
                  type="text"
                  id="btl11"
                  value={valuebtl11}
                  onChange={(e) => setValuebtl11(e.target.value)}
                />
              </td>
              <td>
                <input readonly
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
                <input readonly
                  type="text"
                  id="btl14"
                  value={valuebtl14}
                  onChange={(e) => setValuebtl14(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="btl15"
                  value={valuebtl15}
                  onChange={(e) => setValuebtl15(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="btl16"
                  value={valuebtl16}
                  onChange={(e) => setValuebtl16(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="btl17"
                  value={valuebtl17}
                  onChange={(e) => setValuebtl17(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="btl18"
                  value={valuebtl18}
                  onChange={(e) => setValuebtl18(e.target.value)}
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

        
