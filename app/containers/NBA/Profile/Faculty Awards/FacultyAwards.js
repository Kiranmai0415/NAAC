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
import { toast } from "react-toastify";
import "./FacultyAwards.css";
import AuthService from "../../../Pages/Users/services/auth.service";
import { resources } from "../../../appConstants";

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

export default function FacultyAwards() {
  const [facultyAwards, setFacultyAwards] = useState({
    awards: "",
    department: "",
    school: "",
    pan: "",
    designation: "",
    incentives: "",
    fellowship: "",
    link: "",
    yearQ: "",
  });

  const [callGrid, setCallGrid] = useState();
  const [gridData, setGridData] = useState([]);
  // file upload
  const [valueep22, setValueep22] = useState();

  const {
    awards,
    pan,
    department,
    school,
    designation,
    incentives,
    fellowship,
    link,
    yearQ,
  } = facultyAwards;

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

  const inputFacultyAwards = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    facultyAwards: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

       
        inputfat1: awards,
        inputfat2: department,
        inputfat3: school,
        inputfat4: pan,
        inputfat5: designation,
        inputfat6: incentives,
        inputfat7: fellowship,
        inputfat8: link,
        inputfat9: yearQ,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingFacultyAwards(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(JSON.stringify(inputFacultyAwards));
    basicData.append("facultyFiles", valueep22, "ep22-" + valueep22.name);
    basicData.append("awardsInfo", jsonBlob(inputFacultyAwards));

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(resources.APPLICATION_URL+"facultyData", filesFetchMethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Record is Inserted Successfully");
          setCallGrid("invoke");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
  }

  const FacultyHandleChange = (e) => {
    setFacultyAwards({
      ...facultyAwards,
      [e.target.name]: e.target.value,
    });
  };

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallFacultyAwardsdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log("patents data is",JSON.stringify(data));
              setGridData(data[0].facultyAwards);
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    [callGrid]
  );

  return (
    <div className="facultyawards-container">
      <h1 className="facultyawards-heading-style">Faculty Awards</h1>
      <div className="facultyawardseachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of full time teachers receiving awards from state level,
                national level, international level
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="awards"
                  value={awards}
                  onChange={FacultyHandleChange}
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
                  onChange={FacultyHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Year</th>
              <td>
                <input
                  type="number"
                  name="yearQ"
                  value={yearQ}
                  onChange={FacultyHandleChange}
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
                  onChange={FacultyHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>PAN</th>
              <td>
                <input
                  type="text"
                  name="pan"
                  value={pan}
                  onChange={FacultyHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Designation</th>
              <td>
                <input
                  type="text"
                  name="designation"
                  value={designation}
                  onChange={FacultyHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>
                Incentives/Type of the incentive given by the HEI in recognition
                of the award
              </th>
              <td>
                <input
                  type="text"
                  name="incentives"
                  value={incentives}
                  onChange={FacultyHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>
                Name of the award, fellowship, received from Government or
                Government recognized bodies
              </th>
              <td>
                <input
                  type="text"
                  name="fellowship"
                  value={fellowship}
                  onChange={FacultyHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Link to the relevant documents</th>
              <td>
                <input
                  type="text"
                  name="link"
                  value={link}
                  onChange={FacultyHandleChange}
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
          <div className="faculty-button-container">
            <button
              className="faculty-button-style"
              onClick={onClickingFacultyAwards}
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
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center" }}>
                        Name of full time teachers receiving awards from state level, national level, international level</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000" ,textAlign:"center" }} >Department</TableCell>
                        <TableCell sx={{ width: "10%" ,fontSize:"19px",color:"#000" ,textAlign:"center" }}>Designation</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center"  }} >
                        Name of the award, fellowship, received from Government or Government recognized bodies</TableCell>
                     
                      </TableRow>
                    </TableHead>

                   <TableBody>
                    {gridData.map((facultyawardsData)=> console.log("each patent =>",JSON.stringify(facultyawardsData)))}
                    {gridData.map((facultyawardsData)=>
                    <TableRow key={facultyawardsData.inputfat1}>
                    <TableCell>{facultyawardsData.inputfat1}</TableCell>
                    <TableCell>{facultyawardsData.inputfat2}</TableCell>
                    <TableCell>{facultyawardsData.inputfat5}</TableCell>
                    <TableCell>{facultyawardsData.inputfat7}</TableCell>
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
