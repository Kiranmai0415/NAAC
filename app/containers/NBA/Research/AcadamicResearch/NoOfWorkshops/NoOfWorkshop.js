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
import "./NoOfWorkshop.css";
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

export default function NoOfWorkshop() {
  const [workshopsandSeminars, setWorkshopsandSeminars] = useState({
    year: "",
    department: "",
    school: "",
    workshop: "",
    participants: "",
    dateFrom: "",
    dateTo: "",
  });
  // file upload
  const [valueep22, setValueep22] = useState();
  const [callGrid, setCallGrid] = useState();
  const [gridData, setGridData] = useState([]);
  const { year, workshop, participants, dateFrom, dateTo, department, school } =
    workshopsandSeminars;

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

  const inputWorkshopsandSeminars = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    numberofWorkshopsorSeminars: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
       
        inputwt1: year,
        inputwt2: department,
        inputwt3: school,
        inputwt4: workshop,
        inputwt5: participants,
        inputwt6: dateFrom,
        inputwt7: dateTo,
      },
    ],
  };
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onWorkshopsandSeminars(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(JSON.stringify(inputWorkshopsandSeminars));
    basicData.append("noofWorkshopsFiles", valueep22, "ep22-" + valueep22.name);
    basicData.append("noofWorkshopsobj", jsonBlob(inputWorkshopsandSeminars));
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
      resources.APPLICATION_URL+"noofWorkshopsData",
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

  const WorkshopHandleChange = (e) => {
    setWorkshopsandSeminars({
      ...workshopsandSeminars,
      [e.target.name]: e.target.value,
    });
  };

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallWorkshopsdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log("workshops data is",JSON.stringify(data));
              setGridData(data[0].numberofWorkshopsorSeminars);
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    [callGrid]
  );

  return (
    <div className="noofworkshop-main-container">
      <h1 className="noofworkshop-main-heading-style">
        Number of workshops/seminars
      </h1>
      <div className="noofworkshop-eachTable-container">
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
                  onChange={WorkshopHandleChange}
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
                  onChange={WorkshopHandleChange}
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
                  onChange={WorkshopHandleChange}
                />
              </td>
            </tr>

            <tr>
              <th>Name of the workshop/ seminar</th>
              <td>
                <input
                  type="text"
                  name="workshop"
                  value={workshop}
                  onChange={WorkshopHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Number of Participants</th>
              <td>
                <input
                  type="number"
                  name="participants"
                  value={participants}
                  onChange={WorkshopHandleChange}
                />
              </td>
            </tr>

            <tr>
              <th>Date From</th>
              <td>
                <input
                  type="date"
                  name="dateFrom"
                  value={dateFrom}
                  onChange={WorkshopHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Date To</th>
              <td>
                <input
                  type="date"
                  name="dateTo"
                  value={dateTo}
                  onChange={WorkshopHandleChange}
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
          <div className="noofworkshop-button-container">
            <button
              className="noofworkshop-button-style"
              onClick={onWorkshopsandSeminars}
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
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center" }}>Name of the Workshop</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000" ,textAlign:"center" }} >Department</TableCell>
                        <TableCell sx={{ width: "10%" ,fontSize:"19px",color:"#000" ,textAlign:"center" }}>Number of Participants</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center"  }} >Date From</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center"  }} >Date To</TableCell>
                     
                      </TableRow>
                    </TableHead>

                   <TableBody>
                    {gridData.map((workshopsData)=> console.log("no.of workshops =>",JSON.stringify(workshopsData)))}
                    {gridData.map((workshopsData)=>
                    <TableRow key={workshopsData.inputwt1}>
                    <TableCell>{workshopsData.inputwt4}</TableCell>
                    <TableCell>{workshopsData.inputwt2}</TableCell>
                    <TableCell>{workshopsData.inputwt5}</TableCell>
                    <TableCell>{workshopsData.inputwt6}</TableCell>
                    <TableCell>{workshopsData.inputwt7}</TableCell>
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
