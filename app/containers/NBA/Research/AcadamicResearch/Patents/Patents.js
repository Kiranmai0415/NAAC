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
import "./Patents.css";
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

export default function Patents() {
  const [not, setNot] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [pno, setPno] = useState("");
  const [title, setTitle] = useState("");
  const [yoaward, setYoaward] = useState("");
  const [currentYear, setCurrentYear] = useState("");
  const [earning, setEarning] = useState("");
   const [search, setSearch] = useState("");

  // file upload
  const [valueep22, setValueep22] = useState();
  const [callGrid, setCallGrid] = useState();
  const [gridData, setGridData] = useState([]);
  //const [pathValueep22, setPathValueep22] = useState("");

  
  
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
  const inputPatentsDataList = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    patents: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        inputppt1: not,
        inputppt2: department,
        inputppt3: school,
        inputppt4: pno,
        inputppt5: title,
        inputppt6: yoaward,
        inputppt7: currentYear,
        inputppt8: earning,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingPatents(e) {
    e.preventDefault();
    console.log(JSON.stringify(inputPatentsDataList));
    const patentForm = new FormData();
    patentForm.append("patents", jsonBlob(inputPatentsDataList));
    patentForm.append("patentsFiles", valueep22, "ep22-" + valueep22.name);

    const patentsDataMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: patentForm,
    };
    fetch(resources.APPLICATION_URL+"patentsData", patentsDataMethod).then(
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
  
  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallpatentsdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log("patents data is",JSON.stringify(data));
              setGridData(data[0].patents);
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    [callGrid]
  );
  return (
    <div className="patents-container">
      <h1 className="patents-heading-style">Patents</h1>
      <div className="patents-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the Teacher
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  name="not"
                  value={not}
                  onChange={(e) => setNot(e.target.value)}
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
                  name="school"
                  value={school}
                  onChange={(e) => setSchool(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Patent Number</th>
              <td>
                <input
                  type="text"
                  name="pno"
                  value={pno}
                  onChange={(e) => setPno(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Title of the patent</th>
              <td>
                <input
                  type="text"
                  name="title"
                  value={title}
                  onChange={(e) => setTitle(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Earning From patent(in lakhs)</th>
              <td>
                <input
                  type="number"
                  name="earning"
                  value={earning}
                  onChange={(e) => setEarning(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Year of Award / publish of patent</th>
              <td>
                <input
                  type="number"
                  name="yoaward"
                  value={yoaward}
                  onChange={(e) => setYoaward(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Year </th>
              <td>
                <input
                  type="number"
                  name="currentYear"
                  value={currentYear}
                  onChange={(e) => setCurrentYear(e.target.value)}
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
                    // setValueep22(e.target.value);
                    // showFilePreview(e);
                  }}
                />
                {/* {pathValueep22 === "" ? null : (
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
                )} */}
              </td>
            </tr>
          </table>

          <div className="patents-button-container">
            <button
              className="patents-button-style"
              onClick={onClickingPatents}
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
                        <TableCell sx={{ width: "10%" ,fontSize:"19px",color:"#000" ,textAlign:"center" }}>Patent Number</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center"  }} >Title of the patent</TableCell>
                     
                      </TableRow>
                    </TableHead>

                   <TableBody>
                    {gridData.map((patentData)=> console.log("each patent =>",JSON.stringify(patentData)))}
                    {gridData.map((patentData)=>
                    <TableRow key={patentData.inputppt1} sx={{textAlign:"center"}}>
                    <TableCell>{patentData.inputppt1} </TableCell>
                    <TableCell>{patentData.inputppt2}</TableCell>
                    <TableCell>{patentData.inputppt3}</TableCell>
                    <TableCell>{patentData.inputppt4}</TableCell>
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
