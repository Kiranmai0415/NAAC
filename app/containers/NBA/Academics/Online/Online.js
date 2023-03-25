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
import "./Online.css";
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
export default function Online() {
  const [facetoface, setFacetoface] = useState({
    year: "",
    not: "",
    department: "",
    school: "",
    duration: "",
    duration1: "",
  });
  // file upload
  const [valueep22, setValueep22] = useState();

  const [callGrid, setCallGrid] = useState();
  const [gridData, setGridData] = useState([]);

  const { year, not, department, school, duration, duration1 } = facetoface;

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

  const inputFacetoface = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    onlineorF2FFDP: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

       
        inputfdpt1: year,
        inputfdpt2: not,
        inputfdpt3: department,
        inputfdpt4: school,
        inputfdpt5: duration,
        inputfdpt6: duration1,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingFacetoface(e) {
    e.preventDefault();
    const basicData = new FormData();
    basicData.append("onlineF2FFDPobj", jsonBlob(inputFacetoface));
    basicData.append("onlineF2FFDPFiles", valueep22, "ep22-" + valueep22.name);

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
      "http://localhost:8080/api/v1/onlineF2FFDPData",
      filesFetchMethod).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Inserted Successfully");
        setCallGrid("invoke");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallOnlineF2FFDPdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log("OnlineF2FFDP data is",JSON.stringify(data));
              setGridData(data[0].onlineorF2FFDP);
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    [callGrid]
  );


  const FaceHandleChange = (e) => {
    setFacetoface({
      ...facetoface,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div className="online-main-container">
      <h1 className="online-main-heading-style">
        {" "}
        Online/ face-to-face Faculty Development Programmes (FDP)
      </h1>
      <div className="online-eachTable-container">
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
                  onChange={FaceHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Name of teacher who attended the program</th>
              <td>
                <input
                  type="text"
                  name="not"
                  value={not}
                  onChange={FaceHandleChange}
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
                  onChange={FaceHandleChange}
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
                  onChange={FaceHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Duration (from)</th>
              <td>
                <input
                  type="date"
                  name="duration"
                  value={duration}
                  onChange={FaceHandleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Duration (to) (DD-MM-YYYY)</th>
              <td>
                <input
                  type="date"
                  name="duration1"
                  value={duration1}
                  onChange={FaceHandleChange}
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
          <div className="online-button-container">
            <button
              className="online-button-style"
              onClick={onClickingFacetoface}
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
                        <TableCell sx={{ width: "10%" ,fontSize:"19px",color:"#000" ,textAlign:"center" }}>Duration (from)</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center"  }} >Duration (to)</TableCell>
                     
                      </TableRow>
                    </TableHead>

                   <TableBody>
                    {gridData.map((onlineFDPtData)=> console.log("each patent =>",JSON.stringify(onlineFDPtData)))}
                    {gridData.map((onlineFDPtData)=>
                    <TableRow key={onlineFDPtData.inputfdpt2}>
                    <TableCell>{onlineFDPtData.inputfdpt2}</TableCell>
                    <TableCell>{onlineFDPtData.inputfdpt3}</TableCell>
                    <TableCell>{onlineFDPtData.inputfdpt5}</TableCell>
                    <TableCell>{onlineFDPtData.inputfdpt6}</TableCell>
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
