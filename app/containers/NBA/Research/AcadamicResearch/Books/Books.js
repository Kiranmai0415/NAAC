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
import "./Books.css";
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

export default function Books() {
  const [books, setBooks] = useState({
    teacherName: "",
    department: "",
    school: "",
    bookTitle: "",
    paperTitle: "",
    proceedingsTitle: "",
    publicationYear: "",
    iSBN: "",
    publisherName: "",
    institutions: "",
    conferenceName: "",
    national: "",
  });

  // file upload
  const [valueep22, setValueep22] = useState();

  const [teacherName, setTeachername] = useState("");
  const [department, setDepartment] = useState("");
  const [school, setSchool] = useState("");
  const [bookTitle, setBooktitle] = useState("");
  const [paperTitle, setPapertitle] = useState("");
  const [proceedingsTitle, setProceedingsTitle] = useState("");
  const [publicationYear, setPublicationyear] = useState("");
  const [iSBN, setIsbn] = useState("");
  const [publisherName, setPublishername] = useState("");
  const [institutions, setInstitutions] = useState("");
  const [conferenceName, setConferencename] = useState("");
  const [national, setNational] = useState("");

  const [callGrid, setCallGrid] = useState();
  
  const [gridData, setGridData] = useState([]);

  // file upload

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


 

  const inputBooksDataList = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    booksandChapters: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: instituteType,
        },
       
        inputbct1: teacherName,
        inputbct2: department,
        inputbct3: school,
        inputbct4: bookTitle,
        inputbct5: paperTitle,
        inputbct6: proceedingsTitle,
        inputbct7: publicationYear,
        inputbct8: iSBN,
        inputbct9: publisherName,
        inputbct10: institutions,
        inputbct11: conferenceName,
        inputbct12: national,
      },
    ],
  };

  const handleChangeBooks = (e) => {
    setBooks({
      ...books,
      [e.target.name]: e.target.value,
    });
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingBooks(e) {
    e.preventDefault();
    const basicData = new FormData();
    console.log(JSON.stringify(inputBooksDataList));

    basicData.append("booksFiles", valueep22, "ep22-" + valueep22.name);

    basicData.append("booksInfo", jsonBlob(inputBooksDataList));

    const filesFetchMethod = {
      method: "POST",
      headers: {
        Accept: "application/json,text/plain",
      },

      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: basicData,
    };
    fetch(resources.APPLICATION_URL+"bookData", filesFetchMethod).then(
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
      fetch("http://localhost:8080/api/v1/getallbookandchapterdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log("books and chapters data is",JSON.stringify(data));
              setGridData(data[0].booksandChapters);
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    [callGrid]
  );

  return (
    <div className="books-container">
      <h1 className="books-heading-style">Books and Chapters</h1>
      <div className="books-eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">
                Name of the teacher
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  id=""
                  name="teacherName"
                  value={teacherName}
                  onChange={(e) => setTeachername(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Department
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  id=""
                  name="department"
                  value={department}
                  onChange={(e) => setDepartment(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>
                Schools Name
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"
                  id=""
                  name="school"
                  value={school}
                  onChange={(e) => setSchool(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Title of the book/chapters published</th>
              <td>
                <input
                  type="text"
                  id="bookTitle"
                  name="bookTitle"
                  value={bookTitle}
                  onChange={(e) => setBooktitle(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Title of the paper</th>
              <td>
                <input
                  type="text"
                  id="paperTitle"
                  name="paperTitle"
                  value={paperTitle}
                  onChange={(e) => setPapertitle(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Title of the proceedings of the conference</th>
              <td>
                <input
                  type="text"
                  id="proceedingsTitle"
                  name="proceedingsTitle"
                  value={proceedingsTitle}
                  onChange={(e) => setProceedingsTitle(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th>Year of publication</th>
              <td>
                <input
                  type="number"
                  id="publicationYear"
                  name="publicationYear"
                  value={publicationYear}
                  onChange={(e) => setPublicationyear(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>ISBN/ISSN number of the proceeding</th>
              <td>
                <input
                  type="text"
                  name="iSBN"
                  value={iSBN}
                  onChange={(e) => setIsbn(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>Name of the publisher</th>
              <td>
                <input
                  type="text"
                  id="publisherName"
                  name="publisherName"
                  value={publisherName}
                  onChange={(e) => setPublishername(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>
                {" "}
                Whether at the time of publication affiliating institutions was
                same (Yes/No) (U & AU)*
              </th>
              <td>
                <input
                  placeholder="Select Yes or No"
                  required="required"
                  className="nba-input-head"
                  id="naacYearH1id"
                  list="options"
                  name={institutions}
                  value={institutions}
                  onChange={(e) => setInstitutions(e.target.value)}
                />
                <datalist id="options">
                  {options.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => setInstitutions(e.target.value)}
                    >
                      {eachOptions.options}
                    </option>
                  ))}
                </datalist>
              </td>
            </tr>

            <tr>
              <th>Name of the conference</th>
              <td>
                <input
                  type="text"
                  id="conferenceName"
                  name="conferenceName"
                  value={conferenceName}
                  onChange={(e) => setConferencename(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <th>National / International</th>
              <td>
                <input
                  type="text"
                  name="national"
                  value={national}
                  onChange={(e) => setNational(e.target.value)}
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

          <div className="books-button-container">
            <button className="books-button-style" onClick={onClickingBooks}>
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
                        <TableCell sx={{ width: "10%" ,fontSize:"19px",color:"#000" ,textAlign:"center" }}>Title of the book/chapters published</TableCell>
                        <TableCell sx={{ width: "10%",fontSize:"19px",color:"#000",textAlign:"center"  }} >Year of publication</TableCell>
                     
                      </TableRow>
                    </TableHead>

                   <TableBody>
                    {gridData.map((booksChapters)=> console.log("each book =>",JSON.stringify(booksChapters)))}
                   {
                      gridData.map((booksChapters)=>{
                        <TableRow key={booksChapters.inputbct1}>
                        <TableCell>{booksChapters.inputbct1}</TableCell>
                        <TableCell>{booksChapters.inputbct2}</TableCell>
                        <TableCell>{booksChapters.inputbct4}</TableCell>
                        <TableCell>{booksChapters.inputbct7}</TableCell>
                    </TableRow>
                      })
                   }
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
