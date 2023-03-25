import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import "./extendedProfile.css";
import AuthService from '../../../Pages/Users/services/auth.service';

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

function ExtendedProfile() {
  const [valueep11, setValueep11] = useState();
  const [valueep12, setValueep12] = useState();
  const [valueep13, setValueep13] = useState();
  const [valueep14, setValueep14] = useState();
  const [valueep15, setValueep15] = useState();

  const [valueep21, setValueep21] = useState();
  const [valueep22, setValueep22] = useState();
 
  const [valueep23, setValueep23] = useState();
  const [valueep24, setValueep24] = useState();
  const [valueep25, setValueep25] = useState();
   
  const [valueep31, setValueep31] = useState();
  const [pathValueep31, setPathValueep31] = useState("");
  const [valueep41, setValueep41] = useState();
  const [pathValueep41, setPathValueep41] = useState("");

  const [valueep51, setValueep51] = useState();
  const [valueep52, setValueep52] = useState();
  const [valueep53, setValueep53] = useState();
  const [valueep54, setValueep54] = useState();
  const [valueep55, setValueep55] = useState();

  const [valueep61, setValueep61] = useState();
  const [valueep62, setValueep62] = useState();
  const [valueep63, setValueep63] = useState();
  const [valueep64, setValueep64] = useState();
  const [valueep65, setValueep65] = useState();

  const [valueep71, setValueep71] = useState();
  const [valueep72, setValueep72] = useState();
  const [valueep73, setValueep73] = useState();
  const [valueep74, setValueep74] = useState();
  const [valueep75, setValueep75] = useState();

  const [valueep81, setValueep81] = useState();
  const [valueep82, setValueep82] = useState();
  const [valueep83, setValueep83] = useState();
  const [valueep84, setValueep84] = useState();
  const [valueep85, setValueep85] = useState();

  const [valueep86, setValueep86] = useState();
  const [pathValueep86, setPathValueep86] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');

  const [valueep43, setValueep43] = useState();
  // const [value44, setValue44] = useState();

    // get call
    const financialYear="2021-2022";
  useEffect(
    () => fetch('http://localhost:8080/api/v1/getallextendeddata?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,).then(
      (response) => response
        .json()
        .then((data) => {
          setValueep11(data[0].epYeartable11[0]?data[0].epYeartable11[0].input11y:"");
          setValueep21(data[0].epYeartable11[1]?data[0].epYeartable11[1].input11v:"");
          setValueep12(data[0].epYeartable11[2]?data[0].epYeartable11[2].input11y:"");
          setValueep22(data[0].epYeartable11[3]?data[0].epYeartable11[3].input11v:"");
          setValueep13(data[0].epYeartable11[4]?data[0].epYeartable11[4].input11y:"");
          setValueep23(data[0].epYeartable11[0]?data[0].epYeartable11[0].input11v:"");
          setValueep14(data[0].epYeartable11[1]?data[0].epYeartable11[1].input11y:"");
          setValueep24(data[0].epYeartable11[2]?data[0].epYeartable11[2].input11v:"");
          setValueep15(data[0].epYeartable11[3]?data[0].epYeartable11[3].input11y:"");
          setValueep25(data[0].epYeartable11[4]?data[0].epYeartable11[4].input11v:"");

          setValueep43(data[0].epYeartable21[0]?data[0].epYeartable21[0].input23v:"");

          setValueep51(data[0].epYeartable22[0]?data[0].epYeartable22[0].input22y:"");
          setValueep61(data[0].epYeartable22[1]?data[0].epYeartable22[1].input22v:"");
          setValueep52(data[0].epYeartable22[2]?data[0].epYeartable22[2].input22y:"");
          setValueep62(data[0].epYeartable22[3]?data[0].epYeartable22[3].input22v:"");
          setValueep53(data[0].epYeartable22[4]?data[0].epYeartable22[4].input22y:"");
          setValueep63(data[0].epYeartable22[0]?data[0].epYeartable22[0].input22v:"");
          setValueep54(data[0].epYeartable22[1]?data[0].epYeartable22[1].input22y:"");
          setValueep64(data[0].epYeartable22[2]?data[0].epYeartable22[2].input22v:"");
          setValueep55(data[0].epYeartable22[3]?data[0].epYeartable22[3].input22y:"");
          setValueep65(data[0].epYeartable22[4]?data[0].epYeartable22[4].input22v:"");

          setValueep71(data[0].epYeartable31[0]?data[0].epYeartable31[0].input31y:"");
          setValueep81(data[0].epYeartable31[1]?data[0].epYeartable31[1].input31v:"");
          setValueep72(data[0].epYeartable31[2]?data[0].epYeartable31[2].input31y:"");
          setValueep82(data[0].epYeartable31[3]?data[0].epYeartable31[3].input31v:"");
          setValueep73(data[0].epYeartable31[4]?data[0].epYeartable31[4].input31y:"");
          setValueep83(data[0].epYeartable31[0]?data[0].epYeartable31[0].input31v:"");
          setValueep74(data[0].epYeartable31[1]?data[0].epYeartable31[1].input31y:"");
          setValueep84(data[0].epYeartable31[2]?data[0].epYeartable31[2].input31v:"");
          setValueep75(data[0].epYeartable31[3]?data[0].epYeartable31[3].input31y:"");
          setValueep85(data[0].epYeartable31[4]?data[0].epYeartable31[4].input31v:"");




        })
        .catch((error) => {
          console.error("Error:", error);
        })
    ),
    []
  );



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
 
  const inputDataList = {
    // eTable43v: value43,
    // eTable44v: value44,
    

    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},


    //  input21v:valueep21,

    epYeartable11: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:101,
        input11y: valueep11, input11v: valueep21 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:102,
        input11y: valueep12, input11v: valueep22 },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:103,
        input11y: valueep13, input11v: valueep23 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:104,
        input11y: valueep14, input11v: valueep24 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:105,
        input11y: valueep15, input11v: valueep25 },
    ],

    epYeartable21:[
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:101,
         input23v: valueep43,

    }
  ],

    epYeartable22: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:101,
        input22y: valueep51, input22v: valueep61 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:102,
        input22y: valueep52, input22v: valueep62 },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:103,
        input22y: valueep53, input22v: valueep63 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:104,
        input22y: valueep54, input22v: valueep64 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:105,
        input22y: valueep55, input22v: valueep65 },
    ],
    epYeartable31: [
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:101,
        input31y: valueep71, input31v: valueep81 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:102,
         input31y: valueep72, input31v: valueep82 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:103,
         input31y: valueep73, input31v: valueep83 },
      { 
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:104,
         input31y: valueep74, input31v: valueep84 },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

         uniqueKey1:105,
         input31y: valueep75, input31v: valueep85 },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const extendedData = new FormData();
    console.log(JSON.stringify(inputDataList));
    extendedData.append("extendedProfile", jsonBlob(inputDataList));
    if (pathValueep31 !== "") {
      extendedData.append(
        "uploadextendedfile",
        valueep31,
        "ep31-" + valueep31.name
      );
    }
    if (pathValueep41 !== "") {
      extendedData.append("uploadextendedfile", valueep41, "ep41-" + valueep41.name);
    }
    if (pathValueep86 !== "") {
      extendedData.append("uploadextendedfile", valueep85, "ep86-" + valueep86.name);
    }
    
    


    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: extendedData,
    };
    fetch("http://localhost:8080/api/v1/extendeddata", filesFetchMethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Record is Inserted Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
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
  return (
    <div className="main-container">
      <h1 className="main-heading-style">Extended Profile of the College</h1>
      <div className="eachTable-container">
        <form>
          <label className='extended-profile'>1. Student:</label>
          <p className="para">
            1.1. Number of students year wise during the last five years
          </p>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="number"
                  id="ep11"
                  value={valueep11}
                  onChange={(e) => setValueep11(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep12"
                  value={valueep12}
                  onChange={(e) => setValueep12(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep13"
                  value={valueep13}
                  onChange={(e) => setValueep13(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep14"
                  value={valueep14}
                  onChange={(e) => setValueep14(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep15"
                  value={valueep15}
                  onChange={(e) => setValueep15(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="number"
                  id="ep21"
                  value={valueep21}
                  onChange={(e) => setValueep21(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep22"
                  value={valueep22}
                  onChange={(e) => setValueep22(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep23"
                  value={valueep23}
                  onChange={(e) => setValueep23(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep24"
                  value={valueep24}
                  onChange={(e) => setValueep24(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="number"
                  id="ep25"
                  value={valueep25}
                  onChange={(e) => setValueep25(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label className='extended-profile'>2. Teachers:
          <p className="para">
            2.1. Number of full time teachers during the last five years
            (Without repeat count):
            <input type="number" id="ep43"
             value={valueep43}
             style={{width:"20%", marginLeft:"100px"}}
             onChange={(e) => setValueep43(e.target.value)}
            />
          </p>
          </label>
          <table>
            <tr>
              <th style={{ width: "50%" }}>
                Institutional data in the prescribed format
              </th>
              <td>
                <input
                  type="file"
                  id="ep31"
                  onChange={(e) => {
                    setValueep31(e.target.files[0]);
                    setPathValueep31(e.target.value);
                  }}
                />
                {pathValueep31 === "" ? null : (
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
            <tr>
              <th style={{ width: "50%" }}>Upload supporting document</th>
              <td>
                <input
                  type="file"
                  id="ep41"
                  onChange={(e) => {
                    setValueep41(e.target.files[0]);
                    setPathValueep41(e.target.value);
                  }}
                />
                 {pathValueep41 === "" ? null : (
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
        <p className="para">
          2.2. Number of full time teachers year wise during the last five years
        </p>
        <table>
          <tr>
            <th style={{ width: "12%" }}>Year</th>
            <td>
              <input
                type="number"
                id="ep51"
                value={valueep51}
                onChange={(e) => setValueep51(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep52"
                value={valueep52}
                onChange={(e) => setValueep52(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep53"
                value={valueep53}
                onChange={(e) => setValueep53(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep54"
                value={valueep54}
                onChange={(e) => setValueep54(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep55"
                value={valueep55}
                onChange={(e) => setValueep55(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th style={{ width: "12%" }}>Number</th>
            <td>
              <input
                type="number"
                value={valueep61}
                id="ep61"
                onChange={(e) => setValueep61(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep62"
                value={valueep62}
                onChange={(e) => setValueep62(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep63"
                value={valueep63}
                onChange={(e) => setValueep63(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep64"
                value={valueep64}
                onChange={(e) => setValueep64(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep65"
                value={valueep65}
                onChange={(e) => setValueep65(e.target.value)}
              />
            </td>
          </tr>
        </table>
      </div>
      <div className="eachTable-container">
        <label className='extended-profile'>3.Expenditure</label>
        <p className="para">
          3.1 Expenditure excluding salary component year wise during the last
          five years (INR in lakhs)
        </p>
        <table>
          <tr>
            <th style={{ width: "12%" }}>Year</th>
            <td>
              <input
                type="number"
                id="ep71"
                value={valueep71}
                onChange={(e) => setValueep71(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep72"
                value={valueep72}
                onChange={(e) => setValueep72(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep73"
                value={valueep73}
                onChange={(e) => setValueep73(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep74"
                value={valueep74}
                onChange={(e) => setValueep74(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep75"
                value={valueep75}
                onChange={(e) => setValueep75(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th style={{ width: "12%" }}>INR in Lakhs</th>
            <td>
              <input
                type="number"
                id="ep81"
                value={valueep81}
                onChange={(e) => setValueep81(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep82"
                value={valueep82}
                onChange={(e) => setValueep82(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep83"
                value={valueep83}
                onChange={(e) => setValueep83(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep84"
                value={valueep84}
                onChange={(e) => setValueep84(e.target.value)}
              />
            </td>
            <td>
              <input
                type="number"
                id="ep85"
                value={valueep85}
                onChange={(e) => setValueep85(e.target.value)}
              />
            </td>
          </tr>
        </table>
        <Stack direction="row" alignItems="center" spacing={4}>
            <Button variant="contained" component="label">
             File Upload
               <input 
                className="input-text"
                id="es6" multiple type="file" accept='pdf'
                style={{ display: 'none' }}
                onChange={(e) => {
                setValueep86(e.target.files[0]);
                setPathValueep86(e.target.value);
                showFilePreview(e);
            }}
            />
           </Button>{pathValueep86}
           {pathValueep86 === "" ? null : (
              <div className="c21-fileButtons-container" >
                <button className="c21-viewFileButton-style" style={{height:"37px" , width:"70px"}}  >  
                <a target="_openfile" href={filePreviewSrc111f1}> View File</a></button>
                <button className="c11-removeFileButton-style" 
                  onClick={(e)=>{setPathValueep86("");
                  document.getElementById("es6").value="" }} style={{height:"37px" , width:"70px"}} >
                   Reset                     
                </button>
              </div>
            )}
            </Stack>
      </div>
      <div className="c11x-button-container">
        <button onClick={onClickingSave} className="c11x-button-style">
          Modify
        </button>
      </div>
    </div>
  );
}
export default ExtendedProfile;
