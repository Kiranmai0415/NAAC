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




import React, {useEffect, useState } from "react";
import "./FinancialSupport.css";
import { toast } from "react-toastify";
import AuthService from "../../../Pages/Users/services/auth.service";

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
export default function FinancialSupport() {
  const [financialSupport, setFinancialSupport] = useState({
    year: "",
    not: "",
    department: "",
    school: "",
    conference: "",
    professional: "",
    support: "",
  });

  const { year, not, department, school, conference, professional, support } =
    financialSupport;


    const [callGrid, setCallGrid] = useState();
  const [gridData, setGridData] = useState([]);
  // file upload
  const [valueep22, setValueep22] = useState();

  console.log("object====>" + JSON.stringify(AuthService.getCurrentUser()));
  let instituteType = AuthService.getCurrentUser().instituteType;
  console.log("instituteType====>" + instituteType);
  const d = new Date();
  let currYear = d.getFullYear();
  console.log("var====>" + currYear);
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

  const inputFinancialSupport = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    financialSupportToTeachers: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        
        inputfst1: year,
        inputfst2: not,
        inputfst3: department,
        inputfst4: school,
        inputfst5: conference,
        inputfst6: professional,
        inputfst7: support,
      },
    ],
  };
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingFinancialSupport(e) {
    e.preventDefault();
    const basicData = new FormData();
    basicData.append("financeSupportTeach", jsonBlob(inputFinancialSupport));
    basicData.append(
      "financeSuppTeachFiles",
      valueep22,
      "ep22-" + valueep22.name
    );

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(
      "http://localhost:8080/api/v1/financeSuppTeachData",
      filesFetchMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Inserted Successfully");
        setCallGrid("invoke");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }

  const FinancialHandleChange = (e) => {
    setFinancialSupport({
      ...financialSupport,
      [e.target.name]: e.target.value,
    });
  };

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallfinanceSuppTeachdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log("finance support data is",JSON.stringify(data));
              setGridData(data[0].financialSupportToTeachers);
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    [callGrid]
  );



  return (
    <div className="financialSupport-container">
      <h1 className="financialSupport-heading-style">
        {" "}
        Financial support to Teachers
      </h1>
      <div className="financialSupport-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Year
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="number"
                  name="year"
                  value={year}
                  onChange={FinancialHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Name of the teacher</th>
              <td>
                <input
                  type="text"
                  name="not"
                  value={not}
                  onChange={FinancialHandleChange}
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
                  onChange={FinancialHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Schools Name</th>
              <td>
                <input
                  type="text"
                  name="school"
                  value={school}
                  onChange={FinancialHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>
                Name of conference/ workshop attended for which financial
                support provided
              </th>
              <td>
                <input
                  type="text"
                  name="conference"
                  value={conference}
                  onChange={FinancialHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>
                Name of the professional body for which membership fee provided
              </th>
              <td>
                <input
                  type="text"
                  name="professional"
                  value={professional}
                  onChange={FinancialHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Amount of support (in INR)Comments</th>
              <td>
                <input
                  type="text"
                  name="support"
                  value={support}
                  onChange={FinancialHandleChange}
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
                  }}
                />
              </td>
            </tr>
          </table>
          <div className="financialSupport-button-container">
            <button
              className="financialSupport-button-style"
              onClick={onClickingFinancialSupport}
            >
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
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center" }}>Name of the Teacher</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000" ,textAlign:"center" }} >Department</TableCell>
                        <TableCell sx={{ width: "10%" ,fontSize:"19px",color:"#000" ,textAlign:"center" }}>Name of conference/ workshop attended for which financial support provided</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center"  }} >Name of the professional body for which membership fee provided</TableCell>
                     
                      </TableRow>
                    </TableHead>

                   <TableBody>
                    {gridData.map((financeData)=> console.log("each patent =>",JSON.stringify(financeData)))}
                    {gridData.map((financeData)=>
                    <TableRow key={financeData.inputfst1}>
                    <TableCell>{financeData.inputfst2}</TableCell>
                    <TableCell>{financeData.inputfst3}</TableCell>
                    <TableCell>{financeData.inputfst5}</TableCell>
                    <TableCell>{financeData.inputfst6}</TableCell>
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
