import {
  Box,
  Grid,
  input,
  Radio,
  FormControlLabel,
  RadioGroup,
  FormControl,
  FormLabel,
  InputLabel,
  select,
  option,
  Checkbox,
  Button,
  TableContainer,
  TableRow,
  TableCell,
  Typography,
  Table,
  TableHead,
  TableBody,
  TextField,
} from "@mui/material";




import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import { resources } from "../../../../appConstants";
import AuthService from "../../../../Pages/Users/services/auth.service";

import "./Grants.css";

const options = [
  { id: "OPT1", options: "Government" },
  { id: "OPT2", options: "Non-Government" },
];

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

export default function Grants() {
  const [nameofscheme, setNameofscheme] = useState("");
  const [principal, setPrincipal] = useState("");
  const [department, setDepartment] = useState("");
  const [schoolname, setSchoolname] = useState("");
  const [fundingagency, setFundingagency] = useState("");
  const [govt, setGovt] = useState("");
  const [department1, setDepartment1] = useState("");
  const [yearofaward, setYearofaward] = useState("");
  const [funds, setFunds] = useState("");
  const [duration, setDuration] = useState("");

  const [callGrid, setCallGrid] = useState();
  const [gridData, setGridData] = useState([]);

  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setpathValueep22] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
  let instituteType = AuthService.getCurrentUser().instituteType;
  console.log("instituteType=======>" + instituteType);
  const d = new Date();
  let currYear = d.getFullYear();
  console.log("var ==>" + currYear);
  let fYear = parseInt(currYear) - 1 + "-" + currYear;
  console.log("current year==" + fYear);
  const collegeId = AuthService.getCurrentUser().collegeId;
  console.log("collegeId==========>" + collegeId);



  useEffect(
    ()=>{
      console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
      instituteType = AuthService.getCurrentUser().instituteType;
      console.log("instituteType=======>" + instituteType);
    }
  )


  const inputgrants = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    grantsResearchProjects: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

       
        inputgrt1: nameofscheme,
        inputgrt2: principal,
        inputgrt3: department,
        inputgrt4: schoolname,
        inputgrt5: fundingagency,
        inputgrt6: govt,
        inputgrt7: department1,
        inputgrt8: yearofaward,
        inputgrt9: funds,
        inputgrt10: duration,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingGrants(e) {
    e.preventDefault();
    const basicData = new FormData();
    basicData.append("grantInfo", jsonBlob(inputgrants));
    if (pathValueep22 !== '') {
      basicData.append("grantFiles", valueep22, "ep22-" + valueep22.name);
    }

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(resources.APPLICATION_URL+"grantsData", filesFetchMethod).then(
      (response) => {
     
        if (response.ok) {
          successMessage("Record is Inserted Successfully");
          setCallGrid("invoke");
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
      fileReader.addEventListener("load", (event) => {
        setFilePreviewSrc111f1(event.target.result);
      });
    }
  }

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallreasearchdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log("grants data is",JSON.stringify(data));
              setGridData(data[0].grantsResearchProjects);
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    [callGrid]
  );

  return (
    <div className="Grants-container">
      <h1 className="Grants-heading-style">Grants - Research Projects</h1>
      <div className="Grants-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the Scheme/Project/ Endowments/ Chairs (U)*
                {/* <span style={{ color: "red" }}>*</span> */}
              </th>
              <td>
                <input
                  type="text"
                  name="nameofscheme"
                  value={nameofscheme}
                  onChange={(e) => setNameofscheme(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Name of the Principal Investigator/ Co Investigator (if
                applicable)
              </th>
              <td>
                <input
                  type="text"
                  name="principal"
                  value={principal}
                  onChange={(e) => setPrincipal(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Department</th>
              <td>
                <input
                  type="text"
                  name="department"
                  value={department}
                  onChange={(e) => setDepartment(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Schools Name</th>
              <td>
                <input
                  type="text"
                  name="schoolname"
                  value={schoolname}
                  onChange={(e) => setSchoolname(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Name of the Funding agency</th>
              <td>
                <input
                  type="text"
                  name="fundingagency"
                  value={fundingagency}
                  onChange={(e) => setFundingagency(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Type (Government/Non-Government)</th>
              <td>
                <input
                  placeholder="Select Government or Non-Government"
                  required="required"
                  className="nba-input-head"
                  id="governement"
                  list="options"
                  name={govt}
                  value={govt}
                  onChange={(e) => setGovt(e.target.value)}
                />
                <datalist id="options">
                  {options.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => setGovt(e.target.value)}
                    >
                      {eachOptions.options}
                    </option>
                  ))}
                </datalist>
              </td>
            </tr>
            <tr>
              <th>Department of Principal Investigator/ Co Investigator</th>
              <td>
                <input
                  type="text"
                  name="department1"
                  value={department1}
                  onChange={(e) => setDepartment1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th tyle={{ width: "50%" }}>Year of Award</th>
              <td>
                <input
                  type="number"
                  name="yearofaward"
                  value={yearofaward}
                  onChange={(e) => setYearofaward(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th tyle={{ width: "50%" }}>Funds provided (INR in lakhs)</th>
              <td>
                <input
                  type="number"
                  name="funds"
                  value={funds}
                  onChange={(e) => setFunds(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th tyle={{ width: "50%" }}>Duration of the project</th>
              <td>
                <input
                  type="text"
                  name="duration"
                  value={duration}
                  onChange={(e) => setDuration(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "50%" }}>Upload the Document</th>
              <td>
                <input
                  type="file"
                  id="ep22"
                  onChange={(e) => {
                    setValueep22(e.target.files[0]);
                    setpathValueep22(e.target.value);
                    showFilePreview(e);
                  }}
                />
                {pathValueep22 === "" ? null : (
                  <div className="fileButtons-container">
                    <button className="viewFileButton-style">
                      <a target="_openfile" href={filePreviewSrc111f1}>
                        {" "}
                        View File
                      </a>
                    </button>
                    <button className="removeFileButton-style">
                      Remove File
                    </button>
                  </div>
                )}
              </td>
            </tr>
          </table>
          <div className="grants-button-container">
            <button className="grants-button-style" onClick={onClickingGrants}>
              Submit
            </button>
          </div>
        </form>


        <Box
          sx={{
            clear: "both",
            flexGrow: 1,
            m: 3,
            border: 1,
            p: 3,
            borderColor: "#02334d",
            borderRadius: "8px",
          }}
        >
          <div className="table-container">
            <Grid
              item
              md={12}
              className="button-excel-container"
              sx={{ marginBottom: "2%" }}
            >
              <input
                className="faculty-inputs"
                type="search"
                placeholder="Search"
              //  value={search}
                onChange={(e) => {
                  setSearch(e.target.value);
                }}
              />
              <Button className="button-excel" variant="contained">
                Excel
              </Button>
            </Grid>

            {/* <div
              style={{
                overflowX: "scroll",
                width: "100%",
                borderRadius: "10px",
                border: "2px solid black",
              }}
            >
              <div
                style={{
                  width: "200%",
                  padding: "5px",
                  marginRight: "10px",
                  border: "none",
                }}
              > */}
                <TableContainer >
                  <Table aria-label="simple table">
                    <TableHead>
                      
                      <TableRow  sx={{textAlign:"center"}}>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center" }}>Name of the Project</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000" ,textAlign:"center" }} >Department</TableCell>
                        <TableCell sx={{ width: "10%" ,fontSize:"19px",color:"#000" ,textAlign:"center" }}>Name of the Principal Investigator/ Co Investigator </TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center"  }} >Duration of the project</TableCell>
                     
                      </TableRow>
                    </TableHead>

                   <TableBody>
                    {gridData.map((grantData)=> console.log("each grants =>",JSON.stringify(grantData)))}
                    {gridData.map((grantData)=>
                    <TableRow key={grantData.inputgrt1}>
                    <TableCell>{grantData.inputgrt1}</TableCell>
                    <TableCell>{grantData.inputgrt1}</TableCell>
                    <TableCell>{grantData.inputgrt1}</TableCell>
                    <TableCell>{grantData.inputgrt1}</TableCell>
                    </TableRow>
                 
                    )}
                    </TableBody>
                  </Table>
                </TableContainer>
              {/* </div>
             </div> */}
          </div> 
        </Box>
      </div>
    </div>
  );
}
