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


import React, { useEffect,useState } from "react";
import { toast } from "react-toastify";

import "./Consultancy.css";
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

function Consultancy() {
  const [consultancy, setConsultency] = useState({
    nameTeacher: "",
    nameConsultancy: "",
    department: "",
    school: "",
    contactDetails: "",
    year: "",
    revenue: "",
  });

  // file upload
  const [valueep22, setValueep22] = useState();
  const [callGrid, setCallGrid] = useState();
  const [gridData, setGridData] = useState([]);

  const {
    nameTeacher,
    nameConsultancy,
    department,
    school,
    contactDetails,
    year,
    revenue,
  } = consultancy;

  console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
  let instituteType = AuthService.getCurrentUser().instituteType;
  console.log("instituteType=======>" + instituteType);
  const collegeId = AuthService.getCurrentUser().collegeId;
  console.log("collegeId==========>" + collegeId);
  const d = new Date();
  let currYear = d.getFullYear();
  console.log("var ==>" + currYear);
  let fYear = parseInt(currYear) - 1 + "-" + currYear;
  console.log("current year==" + fYear);

  useEffect(
    ()=>{
      console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
      instituteType = AuthService.getCurrentUser().instituteType;
      console.log("instituteType=======>" + instituteType);
    }
  )


  const inputConsultencyDataList = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    revenueConsultancy: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

       
        inputrct1: nameTeacher,
        inputrct2: nameConsultancy,
        inputrct3: department,
        inputrct4: school,
        inputrct5: contactDetails,
        inputrct6: year,
        inputrct7: revenue,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingConsultancy(e) {
    e.preventDefault();
    console.log(JSON.stringify(inputConsultencyDataList));
    const basicData = new FormData();
    basicData.append(
      "revenueConsultFiles",
      valueep22,
      "ep22-" + valueep22.name
    );

    basicData.append("revenueConsultobj", jsonBlob(inputConsultencyDataList));
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
      resources.APPLICATION_URL+"revenueConsultData",
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

  const handleChangeConsultency = (e) => {
    setConsultency({
      ...consultancy,
      [e.target.name]: e.target.value,
    });
  };


  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getAllRevenueConsultData").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log("patents data is",JSON.stringify(data));
              setGridData(data[0].revenueConsultancy);
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    [callGrid]
  );

  return (
    <div className="consultancy-container">
      <h1 className="consultancy-heading-style">Consultancy</h1>
      <div className="consultancy-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the teacher consultant
                {/* <span style={{ color: "red" }}>*</span> */}
              </th>
              <td>
                <input
                  type="text"
                  name="nameTeacher"
                  value={nameTeacher}
                  onChange={handleChangeConsultency}
                />
              </td>
            </tr>
            <tr>
              <th>Name of consultancy project</th>
              <td>
                <input
                  type="text"
                  name="nameConsultancy"
                  value={nameConsultancy}
                  onChange={handleChangeConsultency}
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
                  onChange={handleChangeConsultency}
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
                  onChange={handleChangeConsultency}
                />
              </td>
            </tr>

            <tr>
              <th>Consulting/Sponsoring agency with contact details</th>
              <td>
                <input
                  type="text"
                  name="contactDetails"
                  value={contactDetails}
                  onChange={handleChangeConsultency}
                />
              </td>
            </tr>
            <tr>
              <th>Year</th>
              <td>
                <input
                  type="number"
                  name="year"
                  value={year}
                  onChange={handleChangeConsultency}
                />
              </td>
            </tr>

            <tr>
              <th>Revenue generated (INR in Lakhs)</th>
              <td>
                <input
                  type="number"
                  name="revenue"
                  value={revenue}
                  onChange={handleChangeConsultency}
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

          <div className="consultency-button-container">
            <button
              className="consultency-button-style"
              onClick={onClickingConsultancy}
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
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center" }}>Name of the teacher consultant</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000" ,textAlign:"center" }} >Department</TableCell>
                        <TableCell sx={{ width: "10%" ,fontSize:"19px",color:"#000" ,textAlign:"center" }}>Name of consultancy project</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center"  }} >Consulting/Sponsoring agency with contact details</TableCell>
                     
                      </TableRow>
                    </TableHead>

                   <TableBody>
                    {gridData.map((consultancyData)=> console.log("each Consultancy is =>",JSON.stringify(consultancyData)))}
                    {gridData.map((consultancyData)=>
                    <TableRow key={consultancyData.inputrct1}>
                    <TableCell>{consultancyData.inputrct1}</TableCell>
                    <TableCell>{consultancyData.inputrct3}</TableCell>
                    <TableCell>{consultancyData.inputrct2}</TableCell>
                    <TableCell>{consultancyData.inputrct5}</TableCell>
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

export default Consultancy;
