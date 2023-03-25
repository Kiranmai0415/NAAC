import React, { useState, useEffect } from "react";
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
import { resources } from "../../../../appConstants";
import AuthService from "../../../../Pages/Users/services/auth.service";

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

  const [principalComments, setPrincipalComments] = useState(null);
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState("");

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

  //get call
  const financialYear = "2021-2022";
  useEffect(() =>
    fetch(
      'http://localhost:8080/api/v1/getallevaluativedata?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
    ).then((response) =>
      response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));
          setautonomousName(data[0].nameofTheAutonomousCollege?data[0].nameofTheAutonomousCollege:"");
          setDepartmentName(data[0].nameofTheDepartment?data[0].nameofTheDepartment:"");
          setDist(data[0].dist?data[0].dist:"");
          setState(data[0].state?data[0].state:"");
          setnumOfDepartments(data[0].totalNumberofDepartmentsIntheInstitution);
          setDepartment1(data[0].evaluativereportofthedepartment11[0]?data[0].evaluativereportofthedepartment11[0].english:"");
          setZoology1(data[0].evaluativereportofthedepartment11[0]?data[0].evaluativereportofthedepartment11[0].zoology:"");
          setBioTech1(data[0].evaluativereportofthedepartment11[0]?data[0].evaluativereportofthedepartment11[0].bioTechnology:"");
          setDepartment2(data[0].evaluativereportofthedepartment11[1]?data[0].evaluativereportofthedepartment11[1].english:"");
          setZoology2(data[0].evaluativereportofthedepartment11[1]?data[0].evaluativereportofthedepartment11[1].zoology:"");
          setBioTech2(data[0].evaluativereportofthedepartment11[1]?data[0].evaluativereportofthedepartment11[1].bioTechnology:"");
          setDepartment3(data[0].evaluativereportofthedepartment11[2]?data[0].evaluativereportofthedepartment11[2].english:"");
          setZoology3(data[0].evaluativereportofthedepartment11[2]?data[0].evaluativereportofthedepartment11[2].zoology:"");
          setBioTech3(data[0].evaluativereportofthedepartment11[2]?data[0].evaluativereportofthedepartment11[2].bioTechnology:"");
          setDepartment4(data[0].evaluativereportofthedepartment11[3]?data[0].evaluativereportofthedepartment11[3].english:"");
          setZoology4(data[0].evaluativereportofthedepartment11[3]?data[0].evaluativereportofthedepartment11[3].zoology:"");
          setBioTech4(data[0].evaluativereportofthedepartment11[3]?data[0].evaluativereportofthedepartment11[3].bioTechnology:"");
          setDepartment5(data[0].evaluativereportofthedepartment11[4]?data[0].evaluativereportofthedepartment11[4].english:"");
          setZoology5(data[0].evaluativereportofthedepartment11[4]?data[0].evaluativereportofthedepartment11[4].zoology:"");
          setBioTech5(data[0].evaluativereportofthedepartment11[4]?data[0].evaluativereportofthedepartment11[4].bioTechnology:"");
          setDepartment61(data[0].evaluativereportofthedepartment11[5]?data[0].evaluativereportofthedepartment11[5].english:"");
          setZoology61(data[0].evaluativereportofthedepartment11[5]?data[0].evaluativereportofthedepartment11[5].zoology:"");
          setBioTech61(data[0].evaluativereportofthedepartment11[5]?data[0].evaluativereportofthedepartment11[5].bioTechnology:"");
          setDepartment62(data[0].evaluativereportofthedepartment11[6]?data[0].evaluativereportofthedepartment11[6].english:"");
          setZoology62(data[0].evaluativereportofthedepartment11[6]?data[0].evaluativereportofthedepartment11[6].zoology:"");
          setBioTech62(data[0].evaluativereportofthedepartment11[6]?data[0].evaluativereportofthedepartment11[6].bioTechnology:"");
          setDepartment63(data[0].evaluativereportofthedepartment11[7]?data[0].evaluativereportofthedepartment11[7].english:"");
          setZoology63(data[0].evaluativereportofthedepartment11[7]?data[0].evaluativereportofthedepartment11[7].zoology:"");
          setBioTech63(data[0].evaluativereportofthedepartment11[7]?data[0].evaluativereportofthedepartment11[7].bioTechnology:"");
          setDepartment7(data[0].evaluativereportofthedepartment11[8]?data[0].evaluativereportofthedepartment11[8].english:"");
          setZoology7(data[0].evaluativereportofthedepartment11[8]?data[0].evaluativereportofthedepartment11[8].zoology:"");
          setBioTech7(data[0].evaluativereportofthedepartment11[8]?data[0].evaluativereportofthedepartment11[8].bioTechnology:"");
          setDepartment8(data[0].evaluativereportofthedepartment11[9]?data[0].evaluativereportofthedepartment11[9].english:"");
          setZoology8(data[0].evaluativereportofthedepartment11[9]?data[0].evaluativereportofthedepartment11[9].zoology:"");
          setBioTech8(data[0].evaluativereportofthedepartment11[9]?data[0].evaluativereportofthedepartment11[9].bioTechnology:"");
          setDepartment91(data[0].evaluativereportofthedepartment11[10]?data[0].evaluativereportofthedepartment11[10].english:"");
          setZoology91(data[0].evaluativereportofthedepartment11[10]?data[0].evaluativereportofthedepartment11[10].zoology:"");
          setBioTech91(data[0].evaluativereportofthedepartment11[10]?data[0].evaluativereportofthedepartment11[10].bioTechnology:"");
          setDepartment92(data[0].evaluativereportofthedepartment11[11]?data[0].evaluativereportofthedepartment11[11].english:"");
          setZoology92(data[0].evaluativereportofthedepartment11[11]?data[0].evaluativereportofthedepartment11[11].zoology:"");
          setBioTech92(data[0].evaluativereportofthedepartment11[11]?data[0].evaluativereportofthedepartment11[11].bioTechnology:"");
          setDepartment93(data[0].evaluativereportofthedepartment11[12]?data[0].evaluativereportofthedepartment11[12].english:"");
          setZoology93(data[0].evaluativereportofthedepartment11[12]?data[0].evaluativereportofthedepartment11[12].zoology:"");
          setBioTech93(data[0].evaluativereportofthedepartment11[12]?data[0].evaluativereportofthedepartment11[12].bioTechnology:"");
          setDepartment94(data[0].evaluativereportofthedepartment11[13]?data[0].evaluativereportofthedepartment11[13].english:"");
          setZoology94(data[0].evaluativereportofthedepartment11[13]?data[0].evaluativereportofthedepartment11[13].zoology:"");
          setBioTech94(data[0].evaluativereportofthedepartment11[13]?data[0].evaluativereportofthedepartment11[13].bioTechnology:"");
          setDepartment95(data[0].evaluativereportofthedepartment11[14]?data[0].evaluativereportofthedepartment11[14].english:"");
          setZoology95(data[0].evaluativereportofthedepartment11[14]?data[0].evaluativereportofthedepartment11[14].zoology:"");
          setBioTech95(data[0].evaluativereportofthedepartment11[14]?data[0].evaluativereportofthedepartment11[14].bioTechnology:"");
          setDepartment96(data[0].evaluativereportofthedepartment11[15]?data[0].evaluativereportofthedepartment11[15].english:"");
          setZoology96(data[0].evaluativereportofthedepartment11[15]?data[0].evaluativereportofthedepartment11[15].zoology:"");
          setBioTech96(data[0].evaluativereportofthedepartment11[15]?data[0].evaluativereportofthedepartment11[15].bioTechnology:"");
          setDepartment10(data[0].evaluativereportofthedepartment11[16]?data[0].evaluativereportofthedepartment11[16].english:"");
          setZoology10(data[0].evaluativereportofthedepartment11[16]?data[0].evaluativereportofthedepartment11[16].zoology:"");
          setBioTech10(data[0].evaluativereportofthedepartment11[16]?data[0].evaluativereportofthedepartment11[16].bioTechnology:"");
          setDepartment11(data[0].evaluativereportofthedepartment11[17]?data[0].evaluativereportofthedepartment11[17].english:"");
          setZoology11(data[0].evaluativereportofthedepartment11[17]?data[0].evaluativereportofthedepartment11[17].zoology:"");
          setBioTech11(data[0].evaluativereportofthedepartment11[17]?data[0].evaluativereportofthedepartment11[17].bioTechnology:"");
          setDepartment121(data[0].evaluativereportofthedepartment11[18]?data[0].evaluativereportofthedepartment11[18].english:"");
          setZoology121(data[0].evaluativereportofthedepartment11[18]?data[0].evaluativereportofthedepartment11[18].zoology:"");
          setBioTech121(data[0].evaluativereportofthedepartment11[18]?data[0].evaluativereportofthedepartment11[18].bioTechnology:"");
          setDepartment122(data[0].evaluativereportofthedepartment11[19]?data[0].evaluativereportofthedepartment11[19].english:"");
          setZoology122(data[0].evaluativereportofthedepartment11[19]?data[0].evaluativereportofthedepartment11[19].zoology:"");
          setBioTech122(data[0].evaluativereportofthedepartment11[19]?data[0].evaluativereportofthedepartment11[19].bioTechnology:"");
          setDepartment123(data[0].evaluativereportofthedepartment11[20]?data[0].evaluativereportofthedepartment11[20].english:"");
          setZoology123(data[0].evaluativereportofthedepartment11[20]?data[0].evaluativereportofthedepartment11[20].zoology:"");
          setBioTech123(data[0].evaluativereportofthedepartment11[20]?data[0].evaluativereportofthedepartment11[20].bioTechnology:"");
          setDepartment124(data[0].evaluativereportofthedepartment11[21]?data[0].evaluativereportofthedepartment11[21].english:"");
          setZoology124(data[0].evaluativereportofthedepartment11[21]?data[0].evaluativereportofthedepartment11[21].zoology:"");
          setBioTech124(data[0].evaluativereportofthedepartment11[21]?data[0].evaluativereportofthedepartment11[21].bioTechnology:"");
          setDepartment13(data[0].evaluativereportofthedepartment11[22]?data[0].evaluativereportofthedepartment11[22].english:"");
          setZoology13(data[0].evaluativereportofthedepartment11[22]?data[0].evaluativereportofthedepartment11[22].zoology:"");
          setBioTech13(data[0].evaluativereportofthedepartment11[22]?data[0].evaluativereportofthedepartment11[22].bioTechnology:"");
          setDepartment141(data[0].evaluativereportofthedepartment11[23]?data[0].evaluativereportofthedepartment11[23].english:"");
          setZoology141(data[0].evaluativereportofthedepartment11[23]?data[0].evaluativereportofthedepartment11[23].zoology:"");
          setBioTech141(data[0].evaluativereportofthedepartment11[23]?data[0].evaluativereportofthedepartment11[23].bioTechnology:"");
          setDepartment142(data[0].evaluativereportofthedepartment11[24]?data[0].evaluativereportofthedepartment11[24].english:"");
          setZoology142(data[0].evaluativereportofthedepartment11[24]?data[0].evaluativereportofthedepartment11[24].zoology:"");
          setBioTech142(data[0].evaluativereportofthedepartment11[24]?data[0].evaluativereportofthedepartment11[24].bioTechnology:"");
          setDepartment143(data[0].evaluativereportofthedepartment11[25]?data[0].evaluativereportofthedepartment11[25].english:"");
          setZoology143(data[0].evaluativereportofthedepartment11[25]?data[0].evaluativereportofthedepartment11[25].zoology:"");
          setBioTech143(data[0].evaluativereportofthedepartment11[25]?data[0].evaluativereportofthedepartment11[25].bioTechnology:"");
          setDepartment15(data[0].evaluativereportofthedepartment11[26]?data[0].evaluativereportofthedepartment11[26].english:"");
          setZoology15(data[0].evaluativereportofthedepartment11[26]?data[0].evaluativereportofthedepartment11[26].zoology:"");
          setBioTech15(data[0].evaluativereportofthedepartment11[26]?data[0].evaluativereportofthedepartment11[26].bioTechnology:"");
        })
        .catch((error) => {
          console.error("Error:", error);
        })
    )
  );
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  let role = null;
  let email = null;
  // eslint-disable-next-line prefer-destructuring
  role = AuthService.getCurrentUser().roles[0];
  email = AuthService.getCurrentUser().email;
  const finacialyear = "2021-2022";
  const authorize = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
    assignedTo: email,
    assignedBy: email,
    principalComments: "",
    role,
    deanStatus: "A",
    programmerId: "evaluationreport",
  };

  const rejectContent = {
    criteriaId: {
      collegeId: "1",
      financialYear: finacialyear,
      typeofInstitution: "university",
    },
    assignedTo: "anamita1996@gmail.com",
    assignedBy: email,
    deanComments: rejectReasonComments,
    deanStatus: "R",
    programmerId: "evaluationreport",
  };
  // eslint-disable-next-line no-redeclare
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }
  function getAuthorizeEvaluation() {
    console.log("Authorize IIQA");
    const authAPIMethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(authorize),
    };
    fetch(
      resources.APPLICATION_URL +
        'evaluativeRepotDataSubmittoPrincipal?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
      authAPIMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record Authorized Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }
  function getRejectEvaluation() {
    console.log("Assigned");
    const rejectAPImethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(rejectContent),
    };
    fetch(
      resources.APPLICATION_URL +
        'evaluativeReportDeanRejectRecord?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
      rejectAPImethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Rejected Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
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
              readonly
              type="text"
              style={{
                border: "none",
                borderBottom: "1px dotted black",
                outline: "none",
              }}
              value={autonomousName}
              onChange={(e) => setautonomousName(e.target.value)}
            />
            <br /> <br />
            <label style={{ fontSize: "15px" }}>Name of the Department</label>
            <input
              readonly
              type="text"
              style={{
                border: "none",
                borderBottom: "1px dotted black",
                outline: "none",
              }}
              value={departmentName}
              onChange={(e) => setDepartmentName(e.target.value)}
            />
            <br />
            <br />
            <label style={{ fontSize: "15px" }}>Dist</label>
            <input
              readonly
              type="text"
              style={{
                border: "none",
                borderBottom: "1px dotted black",
                outline: "none",
              }}
              value={dist}
              onChange={(e) => setDist(e.target.value)}
            />{" "}
            &nbsp; &nbsp;
            <label style={{ fontSize: "15px" }}>State</label>
            <input
              readonly
              type="text"
              style={{
                border: "none",
                borderBottom: "1px dotted black",
                outline: "none",
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
              readonly
              type="text"
              style={{
                border: "none",
                borderBottom: "1px dotted black",
                outline: "none",
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department1}
                  onChange={(e) => setDepartment1(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology1}
                  onChange={(e) => setZoology1(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department2}
                  onChange={(e) => setDepartment2(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology2}
                  onChange={(e) => setZoology2(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department3}
                  onChange={(e) => setDepartment3(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology3}
                  onChange={(e) => setZoology3(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department4}
                  onChange={(e) => setDepartment4(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology4}
                  onChange={(e) => setZoology4(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department5}
                  onChange={(e) => setDepartment5(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology5}
                  onChange={(e) => setZoology5(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department61}
                  onChange={(e) => setDepartment61(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology61}
                  onChange={(e) => setZoology61(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech61}
                  onChange={(e) => setBioTech61(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">National collaboration</TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department62}
                  onChange={(e) => setDepartment62(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology62}
                  onChange={(e) => setZoology62(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department63}
                  onChange={(e) => setDepartment63(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology63}
                  onChange={(e) => setZoology63(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department7}
                  onChange={(e) => setDepartment7(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology7}
                  onChange={(e) => setZoology7(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department8}
                  onChange={(e) => setDepartment8(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology8}
                  onChange={(e) => setZoology8(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department91}
                  onChange={(e) => setDepartment91(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology91}
                  onChange={(e) => setZoology91(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department92}
                  onChange={(e) => setDepartment92(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology92}
                  onChange={(e) => setZoology92(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech92}
                  onChange={(e) => setBioTech92(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">Number of Books with ISBN</TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department93}
                  onChange={(e) => setDepartment93(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology93}
                  onChange={(e) => setZoology93(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department94}
                  onChange={(e) => setDepartment94(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology94}
                  onChange={(e) => setZoology94(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department95}
                  onChange={(e) => setDepartment95(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology95}
                  onChange={(e) => setZoology95(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech95}
                  onChange={(e) => setBioTech95(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">Number of h-index </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department96}
                  onChange={(e) => setDepartment96(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology96}
                  onChange={(e) => setZoology96(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department10}
                  onChange={(e) => setDepartment10(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology10}
                  onChange={(e) => setZoology10(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department11}
                  onChange={(e) => setDepartment11(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology11}
                  onChange={(e) => setZoology11(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department121}
                  onChange={(e) => setDepartment121(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology121}
                  onChange={(e) => setZoology121(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department122}
                  onChange={(e) => setDepartment122(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology122}
                  onChange={(e) => setZoology122(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department123}
                  onChange={(e) => setDepartment123(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology123}
                  onChange={(e) => setZoology123(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech123}
                  onChange={(e) => setBioTech123(e.target.value)}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell align="center">Students </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department124}
                  onChange={(e) => setDepartment124(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology124}
                  onChange={(e) => setZoology124(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department13}
                  onChange={(e) => setDepartment13(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology13}
                  onChange={(e) => setZoology13(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech13}
                  onChange={(e) => setBioTech13(e.target.value)}
                />
              </TableCell>
            </TableRow>

            <TableRow>
              <TableCell rowSpan={3}>14</TableCell>
              <TableCell align="center">
                List of dotoral students and research assoiates{" "}
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department141}
                  onChange={(e) => setDepartment141(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology141}
                  onChange={(e) => setZoology141(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department142}
                  onChange={(e) => setDepartment142(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology142}
                  onChange={(e) => setZoology142(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department143}
                  onChange={(e) => setDepartment143(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology143}
                  onChange={(e) => setZoology143(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
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
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={department15}
                  onChange={(e) => setDepartment15(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={zoology15}
                  onChange={(e) => setZoology15(e.target.value)}
                />
              </TableCell>
              <TableCell align="center">
                <input
                  readonly
                  style={{ width: "70%", height: "30px" }}
                  type="text"
                  value={bioTech15}
                  onChange={(e) => setBioTech15(e.target.value)}
                />
              </TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </TableContainer>
      <div>Principal Comments : {principalComments}</div>
      <div className="c31x-button-container">
        <button
          onClick={(e) => {
            getAuthorizeEvaluation(e);
          }}
          className="c31x-button-style"
          style={{ color: "white", backgroundColor: "green" }}
        >
          Authorize
        </button>

        <button
          onClick={(e) => {
            setRejectButtonClickStatus(true);
            e.preventDefault();
          }}
          className="c31x-button-style"
          style={{ color: "white", backgroundColor: "red" }}
        >
          Reject
        </button>
      </div>
      {rejectButtonClickStatus ? (
        <div style={{ marginLeft: "13%" }}>
          <h1>Reason for Rejection</h1>
          <textarea
            cols={110}
            rows={6}
            onChange={(e) => setRejectReasonComments(e.target.value)}
          ></textarea>
          <div>
            <button
              onClick={() => setRejectButtonClickStatus(false)}
              style={{
                color: "black",
                backgroundColor: "white",
                borderRadius: "4px",
                marginRight: "3%",
                boxShadow:
                  "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
              }}
            >
              Cancel
            </button>
            <button
              onClick={(e) => {
                setRejectButtonClickStatus(false);
                getRejectEvaluation(e);
              }}
              style={{
                color: "black",
                backgroundColor: "white",
                borderRadius: "4px",
                boxShadow:
                  "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
              }}
            >
              Confirm Reject
            </button>
          </div>
        </div>
      ) : null}
    </>
  );
}
