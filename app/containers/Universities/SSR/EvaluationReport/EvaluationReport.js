import React, { useState } from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { Container } from "@mui/material";
import { toast } from "react-toastify";
import Typography from "@mui/material/Typography";
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

export default function EvaluationReport() {
  const [department1, setDepartment1] = useState("");
  const [department2, setDepartment2] = useState("");
  const [department3, setDepartment3] = useState("");
  const [department4, setDepartment4] = useState("");
  const [department5, setDepartment5] = useState("");
  const [department61, setDepartment61] = useState("");
  const [department62, setDepartment62] = useState("");
  const [department63, setDepartment63] = useState("");
  const [department7, setDepartment7] = useState("");
  const [department8, setDepartment8] = useState("");
  const [department91, setDepartment91] = useState("");
  const [department92, setDepartment92] = useState("");
  const [department93, setDepartment93] = useState("");
  const [department94, setDepartment94] = useState("");
  const [department95, setDepartment95] = useState("");
  const [department96, setDepartment96] = useState("");
  const [department10, setDepartment10] = useState("");
  const [department11, setDepartment11] = useState("");
  const [department121, setDepartment121] = useState("");
  const [department122, setDepartment122] = useState("");
  const [department123, setDepartment123] = useState("");
  const [department124, setDepartment124] = useState("");
  const [department13, setDepartment13] = useState("");
  const [department141, setDepartment141] = useState("");
  const [department142, setDepartment142] = useState("");
  const [department143, setDepartment143] = useState("");
  const [department15, setDepartment15] = useState("");
  const [zoology1, setZoology1] = useState("");
  const [zoology2, setZoology2] = useState("");
  const [zoology3, setZoology3] = useState("");
  const [zoology4, setZoology4] = useState("");
  const [zoology5, setZoology5] = useState("");
  const [zoology61, setZoology61] = useState("");
  const [zoology62, setZoology62] = useState("");
  const [zoology63, setZoology63] = useState("");
  const [zoology7, setZoology7] = useState("");
  const [zoology8, setZoology8] = useState("");
  const [zoology91, setZoology91] = useState("");
  const [zoology92, setZoology92] = useState("");
  const [zoology93, setZoology93] = useState("");
  const [zoology94, setZoology94] = useState("");
  const [zoology95, setZoology95] = useState("");
  const [zoology96, setZoology96] = useState("");
  const [zoology10, setZoology10] = useState("");
  const [zoology11, setZoology11] = useState("");
  const [zoology121, setZoology121] = useState("");
  const [zoology122, setZoology122] = useState("");
  const [zoology123, setZoology123] = useState("");
  const [zoology124, setZoology124] = useState("");
  const [zoology13, setZoology13] = useState("");
  const [zoology141, setZoology141] = useState("");
  const [zoology142, setZoology142] = useState("");
  const [zoology143, setZoology143] = useState("");
  const [zoology15, setZoology15] = useState("");
  const [bioTech1, setBioTech1] = useState("");
  const [bioTech2, setBioTech2] = useState("");
  const [bioTech3, setBioTech3] = useState("");
  const [bioTech4, setBioTech4] = useState("");
  const [bioTech5, setBioTech5] = useState("");
  const [bioTech61, setBioTech61] = useState("");
  const [bioTech62, setBioTech62] = useState("");
  const [bioTech63, setBioTech63] = useState("");
  const [bioTech7, setBioTech7] = useState("");
  const [bioTech8, setBioTech8] = useState("");
  const [bioTech91, setBioTech91] = React.useState("");
  const [bioTech92, setBioTech92] = useState("");
  const [bioTech93, setBioTech93] = useState("");
  const [bioTech94, setBioTech94] = useState("");
  const [bioTech95, setBioTech95] = useState("");
  const [bioTech96, setBioTech96] = useState("");
  const [bioTech10, setBioTech10] = useState("");
  const [bioTech11, setBioTech11] = useState("");
  const [bioTech121, setBioTech121] = useState("");
  const [bioTech122, setBioTech122] = useState("");
  const [bioTech123, setBioTech123] = useState("");
  const [bioTech124, setBioTech124] = useState("");
  const [bioTech13, setBioTech13] = useState("");
  const [bioTech141, setBioTech141] = useState("");
  const [bioTech142, setBioTech142] = useState("");
  const [bioTech143, setBioTech143] = useState("");
  const [bioTech15, setBioTech15] = useState("");
  const [autonomousName, setautonomousName] = useState("");
  const [departmentName, setDepartmentName] = useState("");
  const [dist, setDist] = useState("");
  const [state, setState] = useState("");
  const [numOfDeparments, setnumOfDepartments] = useState("");


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
  const financialYear="2021-2022";
  const inputDataList = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

   
     
        uniqueKey1: 201,
        nameofTheAutonomousCollege: autonomousName,
        nameofTheDepartment: departmentName,
        state: state,
        dist: dist,
        totalNumberofDepartmentsIntheInstitution: numOfDeparments,

  

    evaluativereportofthedepartment11: [
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 201,
        english: department1,
        zoology: zoology1,
        bioTechnology: bioTech1
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 202,
        english: department2, zoology: zoology2, bioTechnology: bioTech2
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 203,
        english: department3, zoology: zoology3, bioTechnology: bioTech3
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 204,
        english: department4, zoology: zoology4, bioTechnology: bioTech4
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 205,
        english: department5, zoology: zoology5, bioTechnology: bioTech5
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 2061,
        english: department61, zoology: zoology61, bioTechnology: bioTech61
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 2062,
        english: department62, zoology: zoology62, bioTechnology: bioTech62
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 2063,
        english: department63, zoology: zoology63, bioTechnology: bioTech63
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 207,
        english: department7, zoology: zoology7, bioTechnology: bioTech7
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 208,
        english: department8, zoology: zoology8, bioTechnology: bioTech8
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 2091,
        english: department91, zoology: zoology91, bioTechnology: bioTech91
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 2092,
        english: department92, zoology: zoology92, bioTechnology: bioTech92
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 2093, english: department93, zoology: zoology93, bioTechnology: bioTech93
      },

      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 2094,
        english: department94, zoology: zoology94, bioTechnology: bioTech94
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 2095, english: department95, zoology: zoology95, bioTechnology: bioTech95
      },

      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 2096, english: department96, zoology: zoology96, bioTechnology: bioTech96
      },

      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 2010, english: department10, zoology: zoology10, bioTechnology: bioTech10
      },

      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 2011,
        english: department11, zoology: zoology11, bioTechnology: bioTech11
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 20121,

        english: department121,
        zoology: zoology121,
        bioTechnology: bioTech121,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 20122,
        english: department122,
        zoology: zoology122,
        bioTechnology: bioTech122,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 20123,
        english: department123,
        zoology: zoology123,
        bioTechnology: bioTech123,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 20124,
        english: department124,
        zoology: zoology124,
        bioTechnology: bioTech124,
      },
      // { english: department124, zoology: zoology124, bioTechnology: bioTech124 },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 2013,
        english: department13,
        zoology: zoology13,
        bioTechnology: bioTech13,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 20141,
        english: department141,
        zoology: zoology141,
        bioTechnology: bioTech141,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 20142,
        english: department142,
        zoology: zoology142,
        bioTechnology: bioTech142,
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 20143,
        english: department143, zoology: zoology143, bioTechnology: bioTech143
      },
      {
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },

        uniqueKey1: 2015,
        english: department15, zoology: zoology15, bioTechnology: bioTech15
      },
    ],
  };


  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSubmit() {
    const basicData = new FormData();
    console.log(inputDataList);
    basicData.append(
      "evaluativereportofthedepartment",
      jsonBlob(inputDataList)
    );

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(resources.APPLICATION_URL+"evaluativedata", filesFetchMethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Saved Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
  }

  return (
    <>
      <div
        style={{
          backgroundColor: "white",
          marginTop: "5px",
          // WebkitBorderTopLeftRadius: "10px",
          // WebkitBorderTopRightRadius: "10px",
          borderRadius: "15px",
          padding: "5px",
        }}
      >
        <h2 style={{ textAlign: "center", paddingTop: "15px" }}>
          Evaluative Report of the Departments
        </h2>
        <div style={{ paddingLeft: "15px" }}>
          <h4>
            <label style={{ fontSize: "15px" }}>
              Name Of the Autonomous College
            </label>
            <input
              type="text"
              style={{
                border: "none",
                borderBottom: "1px dotted black",
                outline: "none",
                width: "95vw",
              }}
              value={autonomousName}
              onChange={(e) => setautonomousName(e.target.value)}
            />
            <br /> <br />
            <label style={{ fontSize: "15px" }}>Name of the Department</label>
            <input
              type="text"
              style={{
                border: "none",
                borderBottom: "1px dotted black",
                outline: "none",
                width: "95vw",
              }}
              value={departmentName}
              onChange={(e) => setDepartmentName(e.target.value)}
            />
            <br />
            <br />
            <label style={{ fontSize: "15px" }}>Dist</label>
            <input
              type="text"
              style={{
                border: "none",
                borderBottom: "1px dotted black",
                outline: "none",
                width: "95vw",
              }}
              value={dist}
              onChange={(e) => setDist(e.target.value)}
            />{" "}
            &nbsp; &nbsp;
            <br />
            <br />
            <label style={{ fontSize: "15px" }}>State</label>
            <input
              type="text"
              style={{
                border: "none",
                borderBottom: "1px dotted black",
                outline: "none",
                width: "95vw",
              }}
              value={state}
              onChange={(e) => setState(e.target.value)}
            />
            <br />
            <br />
            <label style={{ fontSize: "15px" }}>
              Total Number of Departments in the institution
            </label>
            <input
              type="number"
              style={{
                border: "none",
                borderBottom: "1px dotted black",
                outline: "none",
                width: "95vw",
              }}
              value={numOfDeparments}
              onChange={(e) => setnumOfDepartments(e.target.value)}
            />
          </h4>
        </div>
      </div>
      <TableContainer component={Paper} style={{ padding: "25px" }}>
        <Table sx={{ minWidth: "650" }} size="small" aria-label="a dense table">
          <TableHead>
            <TableRow>
              <TableCell>
                <Typography variant="subtitle1">SNo</Typography>
              </TableCell>

              <TableCell align="center">
                <Typography variant="subtitle1">
                  Name of the Department.
                </Typography>
              </TableCell>
              <TableCell align="center">
                <Typography variant="subtitle1">For Ex: English</Typography>
              </TableCell>
              <TableCell align="center">
                <Typography variant="subtitle1">Zooology</Typography>
              </TableCell>
              <TableCell align="center">
                <Typography variant="subtitle1">Bio-Technology</Typography>
              </TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            <TableRow>
              <TableCell>1</TableCell>
              <TableCell align="center">Year of Establishment </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department1}
                  onChange={(e) => setDepartment1(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology1}
                  onChange={(e) => setZoology1(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech1}
                  onChange={(e) => setBioTech1(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell>2</TableCell>
              <TableCell align="center">
                Is the Department part of a School/Faculty of the Autonomous
                College
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department2}
                  onChange={(e) => setDepartment2(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology2}
                  onChange={(e) => setZoology2(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech2}
                  onChange={(e) => setBioTech2(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell>3</TableCell>
              <TableCell align="center">Name of programmes offered</TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department3}
                  onChange={(e) => setDepartment3(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology3}
                  onChange={(e) => setZoology3(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech3}
                  onChange={(e) => setBioTech3(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell>4</TableCell>
              <TableCell align="center">
                Number of teaching posts Sanctioned/Filled
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department4}
                  onChange={(e) => setDepartment4(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology4}
                  onChange={(e) => setZoology4(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech4}
                  onChange={(e) => setBioTech4(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell>5</TableCell>
              <TableCell align="center">
                Number of Research Projects:Total grants received
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department5}
                  onChange={(e) => setDepartment5(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology5}
                  onChange={(e) => setZoology5(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech5}
                  onChange={(e) => setBioTech5(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell rowSpan={3}>6</TableCell>
              <TableCell align="center">
                Inter -institutional collaborative projects and Associated
                grants received
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department61}
                  onChange={(e) => setDepartment61(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology61}
                  onChange={(e) => setZoology61(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech61}
                  onChange={(e) => setBioTech61(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">National collaboration</TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department62}
                  onChange={(e) => setDepartment62(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology62}
                  onChange={(e) => setZoology62(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech62}
                  onChange={(e) => setBioTech62(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">International collaboration</TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department63}
                  onChange={(e) => setDepartment63(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology63}
                  onChange={(e) => setZoology63(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech63}
                  onChange={(e) => setBioTech63(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell>7</TableCell>
              <TableCell align="center">
                {" "}
                Departmental projects funded by
                DST_FIST,UGC-SAP?CAS,DPE,DBT,ICSSR,AICTE etc.,:Total grants
                received
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department7}
                  onChange={(e) => setDepartment7(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology7}
                  onChange={(e) => setZoology7(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech7}
                  onChange={(e) => setBioTech7(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell>8</TableCell>
              <TableCell align="center">
                Number of Research Projects:Total grants received
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department8}
                  onChange={(e) => setDepartment8(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology8}
                  onChange={(e) => setZoology8(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech8}
                  onChange={(e) => setBioTech8(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell rowSpan={6}>9</TableCell>
              <TableCell align="center">Publications:</TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department91}
                  onChange={(e) => setDepartment91(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology91}
                  onChange={(e) => setZoology91(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech91}
                  onChange={(e) => setBioTech91(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">Number of Papers published</TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department92}
                  onChange={(e) => setDepartment92(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology92}
                  onChange={(e) => setZoology92(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech92}
                  onChange={(e) => setBioTech92(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">Number of Books with ISBN</TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department93}
                  onChange={(e) => setDepartment93(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology93}
                  onChange={(e) => setZoology93(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech93}
                  onChange={(e) => setBioTech93(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">
                Number of Citation Index -range/average
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department94}
                  onChange={(e) => setDepartment94(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology94}
                  onChange={(e) => setZoology94(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech94}
                  onChange={(e) => setBioTech94(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">
                Number of Citation Factor-range/average
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department95}
                  onChange={(e) => setDepartment95(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology95}
                  onChange={(e) => setZoology95(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech95}
                  onChange={(e) => setBioTech95(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">Number of h-index </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department96}
                  onChange={(e) => setDepartment96(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology96}
                  onChange={(e) => setZoology96(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech96}
                  onChange={(e) => setBioTech96(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell>10</TableCell>
              <TableCell align="center">
                Details of parents and income generated{" "}
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department10}
                  onChange={(e) => setDepartment10(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology10}
                  onChange={(e) => setZoology10(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech10}
                  onChange={(e) => setBioTech10(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell>11</TableCell>
              <TableCell align="center">
                Details of parents and income generated
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department11}
                  onChange={(e) => setDepartment11(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology11}
                  onChange={(e) => setZoology11(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech11}
                  onChange={(e) => setBioTech11(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell rowSpan={4}>12</TableCell>

              <TableCell align="center">
                Awards/Recognitions received at National and International level
                by:
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department121}
                  onChange={(e) => setDepartment121(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology121}
                  onChange={(e) => setZoology121(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech121}
                  onChange={(e) => setBioTech121(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">Faculty </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department122}
                  onChange={(e) => setDepartment122(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology122}
                  onChange={(e) => setZoology122(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech122}
                  onChange={(e) => setBioTech122(e.target.value)}
                />
              </TableCell>
            </TableRow>

            <TableRow>
              <TableCell align="center">
                Doctoral/Post doctoral fellows
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department123}
                  onChange={(e) => setDepartment123(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology123}
                  onChange={(e) => setZoology123(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech123}
                  onChange={(e) => setBioTech123(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">Students </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department124}
                  onChange={(e) => setDepartment124(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology124}
                  onChange={(e) => setZoology124(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech124}
                  onChange={(e) => setBioTech124(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell>13</TableCell>
              <TableCell align="center">
                How many students have cleared Civil Services and Defense
                Services examinations, NET,SET (SLET), GATE and other
                competitive examinations
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department13}
                  onChange={(e) => setDepartment13(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology13}
                  onChange={(e) => setZoology13(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech13}
                  onChange={(e) => setBioTech13(e.target.value)}
                />
              </TableCell>
            </TableRow>

            <TableRow>
              <TableCell rowSpan={3}>14</TableCell>
              <TableCell align="center">
                List of doctoral students and research assoiates{" "}
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department141}
                  onChange={(e) => setDepartment141(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology141}
                  onChange={(e) => setZoology141(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech141}
                  onChange={(e) => setBioTech141(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">
                {" "}
                Fro the host institution/uniersity{" "}
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department142}
                  onChange={(e) => setDepartment142(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology142}
                  onChange={(e) => setZoology142(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech142}
                  onChange={(e) => setBioTech142(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">Year of Establishment </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department143}
                  onChange={(e) => setDepartment143(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology143}
                  onChange={(e) => setZoology143(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech143}
                  onChange={(e) => setBioTech143(e.target.value)}
                />
              </TableCell>
            </TableRow>

            <TableRow>
              <TableCell>15</TableCell>
              <TableCell align="center">
                Number of Research Scholars/ Post Graduate students getting
                financial assistance from the University/State/Central
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={department15}
                  onChange={(e) => setDepartment15(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={zoology15}
                  onChange={(e) => setZoology15(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  style={{ width: "70%", height: "30px" }}
                  type="number"
                  value={bioTech15}
                  onChange={(e) => setBioTech15(e.target.value)}
                />
              </TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </TableContainer>
      <div className="c11x-button-container" style={{ paddingBottom: "30px" }}>
        <button onClick={onClickingSubmit} className="c11x-button-style" style={{marginTop: "3%"}}>
          Submit
        </button>
      </div>
    </>
  );
}


