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
import "./Publications.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import { resources } from "../../../../appConstants";

const options = [
  { id: "OPT1", options: "Yes" },
  { id: "OPT2", options: "No" },
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

export default function Publications() {
  const [title, setTitle] = useState("");
  const [author, setAuthor] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [department1, setDocument1] = useState("");
  const [journal, setJournal] = useState("");
  const [year, setYear] = useState("");
  const [issn, setIssn] = useState("");
  const [link, setLink] = useState("");
  const [article, setArticle] = useState("");
  const [ucg, setUcg] = useState("");
  const [currentYear, setcurrentYear] = useState("");

  const [callGrid, setCallGrid] = useState();
  const [gridData, setGridData] = useState([]);

  // const [publications, setPublications] = useState(
  //   {
  //     title: "",
  //     author: "",
  //     department: "",
  //     school: "",
  //     department1: "",
  //     journal: "",
  //     year: "",
  //     issn: "",
  //     link: "",
  //     article: "",
  //     ucg: ""

  //   });

  // file upload
  const [valueep22, setValueep22] = useState();

  // const {
  //   title, author, department, school, department1, journal, year, issn, link, article, ucg, document
  // } = publications;

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

  const inputPublications = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },

    researchPapersPublished: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },

        
        inputrp1: title,
        inputrp2: author,
        inputrp3: department,
        inputrp4: school,
        inputrp5: department1,
        inputrp6: journal,
        inputrp7: year,
        inputrp8: issn,
        inputrp9: link,
        inputrp10: article,
        inputrp11: ucg,
        inputrp12: currentYear,
      },
    ],
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingpublications(e) {
    e.preventDefault();
    const basicData = new FormData();
    basicData.append("researchInfo", jsonBlob(inputPublications));
    basicData.append("researchFiles", valueep22, "ep22-" + valueep22.name);

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(resources.APPLICATION_URL+"researchData", filesFetchMethod).then(
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
  //   setPublications({
  //     ...Publications,
  //     [e.target.name]: e.target.value
  //   });
  // };

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallResearchPaperdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log("patents data is",JSON.stringify(data));
              setGridData(data[0].researchPapersPublished);
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    [callGrid]
  );

  return (
    <div className="publications-container">
      <h1 className="publications-heading-style">Research Papers Published</h1>
      <div className="publications-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Title of paper
                <span style={{ color: "red" }}>*</span>
              </th>
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
              <th>Name of the author/s</th>
              <td>
                <input
                  type="text"
                  name="author"
                  value={author}
                  onChange={(e) => setAuthor(e.target.value)}
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
              <th>Year</th>
              <td>
                <input
                  type="number"
                  name="currentYear"
                  value={currentYear}
                  onChange={(e) => setcurrentYear(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Department of the teacher</th>
              <td>
                <input
                  type="text"
                  name="department1"
                  value={department1}
                  onChange={(e) => setDocument1(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Name of journal</th>
              <td>
                <input
                  type="text"
                  name="journal"
                  value={journal}
                  onChange={(e) => setJournal(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Year of publication</th>
              <td>
                <input
                  type="number"
                  name="year"
                  value={year}
                  onChange={(e) => setYear(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>ISSN number</th>
              <td>
                <input
                  type="text"
                  name="issn"
                  value={issn}
                  onChange={(e) => setIssn(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Link to website of the Journal</th>
              <td>
                <input
                  type="text"
                  name="link"
                  value={link}
                  onChange={(e) => setLink(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Link to article / paper / abstract of the article</th>
              <td>
                <input
                  type="text"
                  name="article"
                  value={article}
                  onChange={(e) => setArticle(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Is it listed in UGC Care list </th>
              <td>
                <input
                  placeholder="Select Yes or No"
                  required="required"
                  className="nba-input-head"
                  id="naacYearH1id"
                  list="options"
                  name={ucg}
                  value={ucg}
                  onChange={(e) => setUcg(e.target.value)}
                />
                <datalist id="options">
                  {options.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => setUcg(e.target.value)}
                    >
                      {eachOptions.options}
                    </option>
                  ))}
                </datalist>
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

          <div className="patents-button-container">
            <button
              className="patents-button-style"
              onClick={onClickingpublications}
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
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center" }}>Title of paper</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000" ,textAlign:"center" }} >Department</TableCell>
                        <TableCell sx={{ width: "10%" ,fontSize:"19px",color:"#000" ,textAlign:"center" }}>Name of the author/s</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center"  }} >Name of journal</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center"  }} >Year of publication</TableCell>

                     
                      </TableRow>
                    </TableHead>

                   <TableBody>
                    {gridData.map((researchPapersData)=> console.log("each research papers =>",JSON.stringify(researchPapersData)))}
                    {gridData.map((researchPapersData)=>
                    <TableRow key={researchPapersData.inputrp1}>
                    <TableCell>{researchPapersData.inputrp1}</TableCell>
                    <TableCell>{researchPapersData.inputrp3}</TableCell>
                    <TableCell>{researchPapersData.inputrp2}</TableCell>
                    <TableCell>{researchPapersData.inputrp8}</TableCell>
                    <TableCell>{researchPapersData.inputrp7}</TableCell>
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
