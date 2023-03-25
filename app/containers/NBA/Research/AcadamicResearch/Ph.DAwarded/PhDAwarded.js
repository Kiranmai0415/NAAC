
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
import ".//PhDAwarded.css";
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

export default function PhDAwarded() {
  const [phDAwards, setPhDAwards] = useState({
    scholor: "",
    department: "",
    school: "",
    guide: "",
    thesis: "",
    yor: "",
    phd: "",
    recognize: "",
    guide1: "",
    currentYear: "",
  });
  const {
    scholor,
    department,
    school,
    guide,
    thesis,
    yor,
    phd,
    recognize,
    guide1,
    currentYear,
  } = phDAwards;

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

  // file upload
  const [valueep22, setValueep22] = useState();
  const [callGrid, setCallGrid] = useState();
  const [gridData, setGridData] = useState([]);


  useEffect(
    ()=>{
      console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
      instituteType = AuthService.getCurrentUser().instituteType;
      console.log("instituteType=======>" + instituteType);
    }
  )


  const inputPhDAwards = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    phdAwardedorRegistered: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

       
        inputphdt1: scholor,
        inputphdt2: department,
        inputphdt3: school,
        inputphdt4: guide,
        inputphdt5: thesis,
        inputphdt6: yor,
        inputphdt7: phd,
        inputphdt8: recognize,
        inputphdt9: guide1,
        inputphdt10: currentYear,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingPhDAwards(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(JSON.stringify(inputPhDAwards));
    basicData.append("phdInfo", jsonBlob(inputPhDAwards));
    basicData.append("phdFiles", valueep22, "ep22-" + valueep22.name);

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(resources.APPLICATION_URL+"phdData", filesFetchMethod).then(
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

  const handleChange = (e) => {
    setPhDAwards({
      ...phDAwards,
      [e.target.name]: e.target.value,
    });
  };


  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallphdAwardsdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log("phd Awards data is",JSON.stringify(data));
              setGridData(data[0].phdAwardedorRegistered);
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    [callGrid]
  );

  return (
    <div className="phDAwarded-container">
      <h1 className="phDAwarded-heading-style">Ph. D awarded/Registered</h1>
      <div className="phDAwarded-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the PhD scholar
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="scholor"
                  value={scholor}
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Name of the Department</th>
              <td>
                <input
                  type="text"
                  name="department"
                  value={department}
                  onChange={handleChange}
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
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Year</th>
              <td>
                <input
                  type="number"
                  name="currentYear"
                  value={currentYear}
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Name of the guide/s</th>
              <td>
                <input
                  type="text"
                  name="guide"
                  value={guide}
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Title of the thesis</th>
              <td>
                <input
                  type="text"
                  name="thesis"
                  value={thesis}
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <th>Year of registration of the scholar</th>
              <td>
                <input
                  type="number"
                  name="yor"
                  value={yor}
                  onChange={handleChange}
                />
              </td>
            </tr>

            <tr>
              <th>Year of PhD awarded</th>
              <td>
                <input
                  type="number"
                  name="phd"
                  value={phd}
                  onChange={handleChange}
                />
              </td>
            </tr>

            <tr>
              <th>
                Whether recognised as a Research Guide for Ph.D./D.M/M.Ch./D.N.B
                Super speciality/D.Sc./D’Lit (YES/NO)
              </th>
              <td>
                <input
                  type="text"
                  name="recognize"
                  value={recognize}
                  onChange={handleChange}
                />
              </td>
            </tr>

            <tr>
              <th>Year of Recognition as a research Guide</th>
              <td>
                <input
                  type="number"
                  name="guide1"
                  value={guide1}
                  onChange={handleChange}
                />
              </td>
            </tr>

            <tr>
              <th>Upload the Document</th>
              <td>
                <input
                  type="file"
                  onChange={(e) => {
                    setValueep22(e.target.files[0]);
                    // setPathValueep22(e.target.value);
                  }}
                />
              </td>
            </tr>
          </table>
          <div className="phd-button-container">
            <button className="phd-button-style" onClick={onClickingPhDAwards}>
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
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center" }}>Name of the PhD scholar</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000" ,textAlign:"center" }} >Department</TableCell>
                        <TableCell sx={{ width: "10%" ,fontSize:"19px",color:"#000" ,textAlign:"center" }}>Name of the guide/s</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center"  }} >Year of PhD awarded</TableCell>
                     
                      </TableRow>
                    </TableHead>

                   <TableBody>
                    {gridData.map((phdAwardsData)=> console.log("phd award data is =>",JSON.stringify(phdAwardsData)))}
                    {gridData.map((phdAwardsData)=>
                    <TableRow key={phdAwardsData.inputphdt1}>
                    <TableCell>{phdAwardsData.inputphdt1}</TableCell>
                    <TableCell>{phdAwardsData.inputphdt2}</TableCell>
                    <TableCell>{phdAwardsData.inputphdt5}</TableCell>
                    <TableCell>{phdAwardsData.inputphdt8}</TableCell>
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
