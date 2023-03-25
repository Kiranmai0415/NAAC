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
import "./GeneralInformation.css";
import AuthService from "../../../Pages/Users/services/auth.service";
import { resources } from "../../../appConstants";

const options = [
  { id: "OPT1", options: "Male" },
  { id: "OPT2", options: "Female" },
  { id: "OPT2", options: "Others" },
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

export default function GeneralInformation() {
  // const [profile, setProfile] = useState({
  //   empId: "",
  //   prof: "",
  //   surName: "",
  //   empName: "",
  //   fatherName: "",
  //   motherName: "",
  //   sposeNAME: "",
  //   motherTongue: "",
  //   dateOfBirth: "",
  //   gender: "",
  //   nationality: "",
  //   religion: "",
  //   caste: "",
  //   reservation: "",
  //   aadharNo: "",
  //   panNum: "",
  //   bankAccount: "",
  //   passPort: "",
  //   driving: "",
  //   designation: "",
  //   department: "",
  //   school: "",
  //   highQualification: "",
  //   doctorDegree: "",
  //   doctorDegreeYear: "",
  //   pgDegree: "",
  //   pgDegreeYear: "",
  //   ugDegree: "",
  //   ugDegreeYear: "",
  //   otherQualification: "",
  //   dateOfJoining: "",
  //   universityRating: "",
  //   program: "",
  //   course: "",
  //   teachingExp: "",
  //   reserchExp: "",
  //   industryExp: "",
  //   areaOfSpec: "",
  //   hindex: "",
  //   hindex1: "",
  //   Citation: "",
  //   Citation1: "",
  //   aicte: "",
  //   orcid: "",
  //   scopus: "",
  //   vidwan: "",
  //   landline: "",
  //   fax: "",
  //   office: "",
  //   phone1: "",
  //   mail: "",
  //   address: "",
  //   city: "",
  //   state: "",
  //   pincode: "",
  //   country: "",
  //   home: "",
  //   phone2: "",
  //   email: "",
  //   address2: "",
  //   qualification1: "",
  //   city1: "",
  //   state1: "",
  //   pincode1: "",
  //   country1: "",
  // });

  // file upload

  const [empId, setEmpId] = useState("");
  const [prof, setProf] = useState("");
  const [surName, setSurName] = useState("");
  const [empName, setEmpName] = useState("");
  const [fatherName, setFatherName] = useState("");
  const [motherName, setMotherName] = useState("");
  const [sposeNAME, setSposeName] = useState("");
  const [motherTongue, setMotherTongue] = useState("");
  const [dateOfBirth, setDateOfBirth] = useState("");
  const [gender, setGender] = useState("");
  const [nationality, setNationality] = useState("");
  const [religion, setReligion] = useState("");
  const [caste, setCaste] = useState("");
  const [reservation, setReservation] = useState("");
  const [aadharNo, setAadharNo] = useState("");
  const [panNum, setPanNum] = useState("");
  const [bankAccount, setBankAccount] = useState("");
  const [passPort, setPassPort] = useState("");
  const [driving, setDriving] = useState("");
  const [designation, setDesignation] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [highQualification, setHighQualition] = useState("");
  const [doctorDegree, setdoctorDegree] = useState("");
  const [doctorDegreeYear, setdoctorDegreeYear] = useState("");
  const [pgDegree, setpgDegree] = useState("");
  const [pgDegreeYear, setpgDegreeYear] = useState("");
  const [ugDegree, setugDegree] = useState("");
  const [ugDegreeYear, setugDegreeYear] = useState("");
  const [otherQualification, setotherQualification] = useState("");
  const [dateOfJoining, setdateOfJoining] = useState("");
  const [universityRating, setuniversityRating] = useState("");
  const [program, setprogram] = useState("");
  const [course, setcourse] = useState("");
  const [teachingExp, setteachingExp] = useState("");
  const [reserchExp, setreserchExp] = useState("");
  const [industryExp, setindustryExp] = useState("");
  const [areaOfSpec, setareaOfSpec] = useState("");
  const [hindex, sethindex] = useState("");
  const [hindex1, sethindex1] = useState("");
  const [Citation, setCitation] = useState("");
  const [Citation1, setCitation1] = useState("");
  const [aicte, setaicte] = useState("");
  const [orcid, setorcid] = useState("");
  const [scopus, setscopus] = useState("");
  const [vidwan, setvidwan] = useState("");
  const [landline, setlandline] = useState("");
  const [fax, setfax] = useState("");
  const [office, setoffice] = useState("");
  const [phone1, setphone1] = useState("");
  const [mail, setmail] = useState("");
  const [address, setaddress] = useState("");
  const [city, setcity] = useState("");
  const [state, setstate] = useState("");
  const [pincode, setpincode] = useState("");
  const [country, setcountry] = useState("");
  const [home, sethome] = useState("");
  const [phone2, setphone2] = useState("");
  const [email, setemail] = useState("");
  const [address2, setaddress2] = useState("");
  const [qualification1, setqualification1] = useState("");
  const [city1, setcity1] = useState("");
  const [state1, setstate1] = useState("");
  const [pincode1, setpincode1] = useState("");
  const [country1, setcountry1] = useState("");

  const [callGrid, setCallGrid] = useState();
  const [gridData, setGridData] = useState([]);


  // file upload
  const [valueep22, setValueep22] = useState();
  const [valueep23, setValueep23] = useState();
  const [valueep24, setValueep24] = useState();
  const [valueep25, setValueep25] = useState();

  // const {
  //   empId,
  //   prof,
  //   motherName,
  //   surName,
  //   empName,
  //   fatherName,
  //   motherTongue,
  //   sposeNAME,
  //   dateOfBirth,
  //   gender,
  //   nationality,
  //   religion,
  //   caste,
  //   aadharNo,
  //   reservation,
  //   panNum,
  //   bankAccount,
  //   passPort,
  //   driving,
  //   designation,
  //   department,
  //   school,
  //   highQualification,
  //   doctorDegree,
  //   doctorDegreeYear,
  //   pgDegree,
  //   pgDegreeYear,
  //   ugDegree,
  //   ugDegreeYear,
  //   otherQualification,
  //   dateOfJoining,
  //   universityRating,
  //   program,
  //   course,
  //   teachingExp,
  //   reserchExp,
  //   hindex,
  //   industryExp,
  //   areaOfSpec,
  //   hindex1,
  //   Citation,
  //   Citation1,
  //   aicte,
  //   orcid,
  //   scopus,
  //   vidwan,
  //   landline,
  //   fax,
  //   office,
  //   phone1,
  //   mail,
  //   address,
  //   city,
  //   state,
  //   pincode,
  //   country,
  //   home,
  //   email,
  //   phone2,
  //   address2,
  //   qualification1,
  //   city1,
  //   state1,
  //   pincode1,
  //   country1,
  // } = profile;

  // console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
  // let instituteType = AuthService.getCurrentUser().instituteType;
  // console.log("instituteType=======>" + instituteType);
  // const d = new Date();
  // let currYear = d.getFullYear();
  // console.log("var ==>" + currYear);
  // let fYear = parseInt(currYear) - 1 + "-" + currYear;
  // console.log("current year==" + fYear);

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

  const inputGeneralInformation = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    profile: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        uniqueKey1:1,
        inputpt1: empId,
        inputpt2: prof,
        inputpt3: surName,
        inputpt4: empName,
        inputpt5: fatherName,
        inputpt6: motherName,
        inputpt7: sposeNAME,
        inputpt8: motherTongue,
        inputpt9: dateOfBirth,
        inputpt10: gender,
        inputpt11: nationality,
        inputpt12: religion,
        inputpt13: caste,
        inputpt14: reservation,
        inputpt15: aadharNo,
        inputpt16: panNum,
        inputpt17: bankAccount,
        inputpt18: passPort,
        inputpt19: driving,
        inputpt20: designation,
        inputpt21: department,
        inputpt22: school,
        inputpt23: highQualification,
        inputpt24: doctorDegree,
        inputpt25: doctorDegreeYear,
        inputpt26: pgDegree,
        inputpt27: pgDegreeYear,
        inputpt28: ugDegree,
        inputpt29: ugDegreeYear,
        inputpt30: otherQualification,
        inputpt31: dateOfJoining,
        inputpt32: universityRating,
        inputpt33: program,
        inputpt34: course,
        inputpt35: teachingExp,
        inputpt36: reserchExp,
        inputpt37: industryExp,
        inputpt38: areaOfSpec,
        inputpt39: hindex,
        inputpt40: hindex1,
        inputpt41: Citation,
        inputpt42: Citation1,
        inputpt43: aicte,
        inputpt44: orcid,
        inputpt45: scopus,
        inputpt46: vidwan,
        inputpt47: landline,
        inputpt48: fax,
        inputpt49: office,
        inputpt50: phone1,
        inputpt51: mail,
        inputpt52: address,
        inputpt53: city,
        inputpt54: state,
        inputpt55: pincode,
        inputpt56: country,
        inputpt57: home,
        inputpt58: phone2,
        inputpt59: email,
        inputpt60: address2,
        inputpt61: qualification1,
        inputpt62: city1,
        inputpt63: state1,
        inputpt64: pincode1,
        inputpt65: country1,
      },
    ],
  };
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingGeneralInfo(e) {
    e.preventDefault();
    const basicData = new FormData();

    console.log(JSON.stringify(inputGeneralInformation));

    basicData.append("profileobj", jsonBlob(inputGeneralInformation));

    basicData.append("profileFiles", valueep22, "ep22-" + valueep22.name);

    basicData.append("profileFiles", valueep23, "ep23-" + valueep23.name);

    basicData.append("profileFiles", valueep24, "ep24-" + valueep24.name);

    basicData.append("profileFiles", valueep25, "ep25" + valueep25.name);

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(resources.APPLICATION_URL+"profileData", filesFetchMethod).then(
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

  // const handleChange = (e) => {
  //   setProfile({
  //     ...profile,
  //     [e.target.name]: e.target.value,
  //   });
  // };

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallprofiledata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log("profile data is",JSON.stringify(data));
              setGridData(data[0].profile);
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    [callGrid]
  );





  return (
    <div className="generalInformation-container">
      <h1 className="generalInformation-heading-style">Profile</h1>
      <div className="generalInformation-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                EMPLOYEE ID
                {/* <span style={{ color: "red" }}>*</span> */}
              </th>
              <td>
                <input
                  type="text"
                  name="empId"
                  value={empId}
                  onChange={(e) => setEmpId(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Prof/ Dr/ Mr/ Mrs</th>
              <td>
                <input
                  type="text"
                  name="prof"
                  value={prof}
                  onChange={(e) => setProf(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>SURNAME</th>
              <td>
                <input
                  type="text"
                  name="surName"
                  value={surName}
                  onChange={(e) => setSurName(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>NAME OF THE EMPLOYEE</th>
              <td>
                <input
                  type="text"
                  name="empName"
                  value={empName}
                  onChange={(e) => setEmpName(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>FATHER NAME</th>
              <td>
                <input
                  type="text"
                  name="fatherName"
                  value={fatherName}
                  onChange={(e) => setFatherName(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>MOTHER NAME</th>
              <td>
                <input
                  type="text"
                  name="motherName"
                  value={motherName}
                  onChange={(e) => setMotherName(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>SPOUSE NAME</th>
              <td>
                <input
                  type="text"
                  name="sposeNAME"
                  value={sposeNAME}
                  onChange={(e) => setSposeName(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>MOTHER TONGUE</th>
              <td>
                <input
                  type="text"
                  name="motherTongue"
                  value={motherTongue}
                  onChange={(e) => setMotherTongue(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>DATE OF BIRTH</th>
              <td>
                <input
                  type="date"
                  name="dateOfBirth"
                  value={dateOfBirth}
                  onChange={(e) => setDateOfBirth(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>GENDER</th>
              <td>
                <input
                  placeholder="Select Gender"
                  required="required"
                  id="naacYearH1id"
                  list="options"
                  value={gender}
                  name="gender"
                  onChange={(e) => setGender(e.target.value)}
                />
                <datalist id="options">
                  {options.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => setGender(e.target.value)}
                    >
                      {eachOptions.options}
                    </option>
                  ))}
                </datalist>
              </td>
              {/* <td>
                <input
                  type="radio"
                  value={male}
                  name="gender"
                  onChange={(e) => setGender(e.target.value)}
                />{" "}
                Male
                <input
                  type="radio"
                  value="female"
                  name="gender"
                  onChange={(e) => setGender(e.target.value)}
                />{" "}
                Female
                <input
                  type="radio"
                  value="others"
                  name="gender"
                  onChange={(e) => setGender(e.target.value)}
                />{" "}
                Others
              </td> */}
            </tr>
            <tr>
              <th>NATIONALITY</th>
              <td>
                <input
                  type="text"
                  name="nationality"
                  value={nationality}
                  onChange={(e) => setNationality(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>RELIGION</th>
              <td>
                <input
                  type="text"
                  name="religion"
                  value={religion}
                  onChange={(e) => setReligion(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>CASTE</th>
              <td>
                <input
                  type="text"
                  name="caste"
                  value={caste}
                  onChange={(e) => setCaste(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>RESERVATION</th>
              <td>
                <input
                  type="text"
                  name="reservation"
                  value={reservation}
                  onChange={(e) => setReservation(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>AADHAR NO</th>
              <td>
                <input
                  type="number"
                  name="aadharNo"
                  value={aadharNo}
                  onChange={(e) => setAadharNo(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "50%" }}>UPLOAD AADHAR</th>
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
            <tr>
              <th>PANCARD NO</th>
              <td>
                <input
                  type="text"
                  name="panNum"
                  value={panNum}
                  onChange={(e) => setPanNum(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "50%" }}>UPLOAD PANCARD</th>
              <td>
                <input
                  type="file"
                  id="ep23"
                  onChange={(e) => {
                    setValueep23(e.target.files[0]);
                  }}
                />
              </td>
            </tr>
            <tr>
              <th>BANK ACCOUNT</th>
              <td>
                <input
                  type="number"
                  name="bankAccount"
                  value={bankAccount}
                  onChange={(e) => setBankAccount(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>UPLOAD THE BANK PASSBOOK COVER PAGE (SCREENSHOT)</th>
              <td>
                <input
                  type="file"
                  id="ep24"
                  onChange={(e) => {
                    setValueep24(e.target.files[0]);
                  }}
                />
              </td>
            </tr>
            <tr>
              <th>PASS PORT NUMBER</th>
              <td>
                <input
                  type="text"
                  name="passPort"
                  value={passPort}
                  onChange={(e) => setPassPort(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>DRIVING LICENCE</th>
              <td>
                <input
                  type="text"
                  name="driving"
                  value={driving}
                  onChange={(e) => setDriving(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>DESIGNATION</th>
              <td>
                <input
                  type="text"
                  name="designation"
                  value={designation}
                  onChange={(e) => setDesignation(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>DEPARTMENT</th>
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
              <th>SCHOOLS NAME</th>
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
              <th style={{ width: "50%" }}>UPLOAD THE ORDERED COPY</th>
              <td>
                <input
                  type="file"
                  id="ep25"
                  onChange={(e) => {
                    setValueep25(e.target.files[0]);
                  }}
                />
              </td>
            </tr>
            <tr>
              <th>HIGHEST QUALIFICATION</th>
              <td>
                <input
                  type="text"
                  name="highQualification"
                  value={highQualification}
                  onChange={(e) => setHighQualition(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>DOCTOR DEGREE (UNIVERSITY)</th>
              <td>
                <input
                  type="text"
                  name="doctorDegree"
                  value={doctorDegree}
                  onChange={(e) => setdoctorDegree(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>DOCTOR DEGREE (UNIVERSITY) OBTAINED YEAR</th>
              <td>
                <input
                  type="number"
                  name="doctorDegreeYear"
                  value={doctorDegreeYear}
                  onChange={(e) => setdoctorDegreeYear(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG DEGREE (UNIVERSITY)</th>
              <td>
                <input
                  type="text"
                  name="pgDegree"
                  value={pgDegree}
                  onChange={(e) => setpgDegree(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PG DEGREE (UNIVERSITY) OBTAINED YEAR</th>
              <td>
                <input
                  type="number"
                  name="pgDegreeYear"
                  value={pgDegreeYear}
                  onChange={(e) => setpgDegreeYear(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>UG DEGREE (UNIVERSITY)</th>
              <td>
                <input
                  type="text"
                  name="ugDegree"
                  value={ugDegree}
                  onChange={(e) => setugDegree(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>UG DEGREE (UNIVERSITY) OBTAINED YEAR</th>
              <td>
                <input
                  type="number"
                  name="ugDegreeYear"
                  value={ugDegreeYear}
                  onChange={(e) => setugDegreeYear(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>OTHER QUALIFICATION</th>
              <td>
                <input
                  type="text"
                  name="otherQualification"
                  value={otherQualification}
                  onChange={(e) => setotherQualification(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>DATE OF JOINING</th>
              <td>
                <input
                  type="date"
                  name="dateOfJoining"
                  value={dateOfJoining}
                  onChange={(e) => setdateOfJoining(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>UNIVERSITY RATIFIED</th>
              <td>
                <input
                  type="text"
                  name="universityRating"
                  value={universityRating}
                  onChange={(e) => setuniversityRating(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PROGRAMME</th>
              <td>
                <input
                  type="text"
                  name="program"
                  value={program}
                  onChange={(e) => setprogram(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>COURSE</th>
              <td>
                <input
                  type="text"
                  name="course"
                  value={course}
                  onChange={(e) => setcourse(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>TEACHING EXP IN YRS</th>
              <td>
                <input
                  type="number"
                  name="teachingExp"
                  value={teachingExp}
                  onChange={(e) => setteachingExp(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>RESEARCH EXP IN YRS</th>
              <td>
                <input
                  type="number"
                  name="reserchExp"
                  value={reserchExp}
                  onChange={(e) => setreserchExp(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>INDUSTRY EXP IN YRS</th>
              <td>
                <input
                  type="number"
                  name="industryExp"
                  value={industryExp}
                  onChange={(e) => setindustryExp(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>AREA OF SPECIALIZATION</th>
              <td>
                <input
                  type="text"
                  name="areaOfSpec"
                  value={areaOfSpec}
                  onChange={(e) => setareaOfSpec(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>CURRENT H-INDEX (GOOGLE)</th>
              <td>
                <input
                  type="text"
                  name="hindex"
                  value={hindex}
                  onChange={(e) => sethindex(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>CURRENT H-INDEX (SCOPUS)</th>
              <td>
                <input
                  type="text"
                  name="hindex1"
                  value={hindex1}
                  onChange={(e) => sethindex1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>CITATION (GOOGLE)</th>
              <td>
                <input
                  type="text"
                  name="Citation"
                  value={Citation}
                  onChange={(e) => setCitation(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>CITATION (SCOPUS)</th>
              <td>
                <input
                  type="text"
                  name="Citation1"
                  value={Citation1}
                  onChange={(e) => setCitation1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>AICTE ID</th>
              <td>
                <input
                  type="text"
                  name="aicte"
                  value={aicte}
                  onChange={(e) => setaicte(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>ORCID ID</th>
              <td>
                <input
                  type="text"
                  name="orcid"
                  value={orcid}
                  onChange={(e) => setorcid(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>SCOPUS ID</th>
              <td>
                <input
                  type="text"
                  name="scopus"
                  value={scopus}
                  onChange={(e) => setscopus(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>VIDWAN ID</th>
              <td>
                <input
                  type="text"
                  name="vidwan"
                  value={vidwan}
                  onChange={(e) => setvidwan(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>LAND LINE NO</th>
              <td>
                <input
                  type="number"
                  name="landline"
                  value={landline}
                  onChange={(e) => setlandline(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>FAX NO</th>
              <td>
                <input
                  type="number"
                  name="fax"
                  value={fax}
                  onChange={(e) => setfax(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Office ADDRESS</th>
              <td>
                <input
                  type="text"
                  name="office"
                  value={office}
                  onChange={(e) => setoffice(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PHONE NO</th>
              <td>
                <input
                  type="number"
                  name="phone1"
                  value={phone1}
                  onChange={(e) => setphone1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>EMAIL-ID</th>
              <td>
                <input
                  type="text"
                  name="mail"
                  value={mail}
                  onChange={(e) => setmail(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>ADDRESS</th>
              <td>
                <input
                  type="text"
                  name="address"
                  value={address}
                  onChange={(e) => setaddress(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>CITY</th>
              <td>
                <input
                  type="text"
                  name="city"
                  value={city}
                  onChange={(e) => setcity(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>STATE</th>
              <td>
                <input
                  type="text"
                  name="state"
                  value={state}
                  onChange={(e) => setstate(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PINCODE</th>
              <td>
                <input
                  type="number"
                  name="pincode"
                  value={pincode}
                  onChange={(e) => setpincode(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>COUNTRY</th>
              <td>
                <input
                  type="text"
                  name="country"
                  value={country}
                  onChange={(e) => setcountry(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>HOME ADDRESS</th>
              <td>
                <input
                  type="text"
                  name="home"
                  value={home}
                  onChange={(e) => sethome(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PHONE NO</th>
              <td>
                <input
                  type="number"
                  name="phone2"
                  value={phone2}
                  onChange={(e) => setphone2(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>EMAIL-ID</th>
              <td>
                <input
                  type="text"
                  name="email"
                  value={email}
                  onChange={(e) => setemail(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>ADDRESS </th>
              <td>
                <input
                  type="text"
                  name="address2"
                  value={address2}
                  onChange={(e) => setaddress2(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>HIGHEST QUALIFICATION</th>
              <td>
                <input
                  type="text"
                  name="qualification1"
                  value={qualification1}
                  onChange={(e) => setqualification1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>CITY</th>
              <td>
                <input
                  type="text"
                  name="city1"
                  value={city1}
                  onChange={(e) => setcity1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>STATE</th>
              <td>
                <input
                  type="text"
                  name="state1"
                  value={state1}
                  onChange={(e) => setstate1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>PINCODE</th>
              <td>
                <input
                  type="number"
                  name="pincode1"
                  value={pincode1}
                  onChange={(e) => setpincode1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>COUNTRY</th>
              <td>
                <input
                  type="text"
                  name="country1"
                  value={country1}
                  onChange={(e) => setcountry1(e.target.value)}
                />
              </td>
            </tr>
          </table>

          <div className="generalInformation-button-container">
            <button
              className="generalInformation-button-style"
              onClick={onClickingGeneralInfo}
              // onClick={onClickingPercentageoffulltime}
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
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center" }}>Name Of The Employee</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000" ,textAlign:"center" }} >Employee ID</TableCell>
                        <TableCell sx={{ width: "10%" ,fontSize:"19px",color:"#000" ,textAlign:"center" }}>Department</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center"  }} >Designation</TableCell>
                     
                      </TableRow>
                    </TableHead>

                   <TableBody>
                    {gridData.map((facultyProfileData)=> console.log("each profile is =>",JSON.stringify(facultyProfileData)))}
                    {gridData.map((facultyProfileData)=>
                    <TableRow key={facultyProfileData.inputpt1}>
                    <TableCell>{facultyProfileData.inputpt4}</TableCell>
                    <TableCell>{facultyProfileData.inputpt1}</TableCell>
                    <TableCell>{facultyProfileData.inputpt21}</TableCell>
                    <TableCell>{facultyProfileData.inputpt20}</TableCell>
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
