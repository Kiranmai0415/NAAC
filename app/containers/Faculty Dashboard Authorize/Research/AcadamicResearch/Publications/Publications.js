import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./Publications.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import PublicationsAuthorize from "./PublicationsAuthorize";
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
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallResearchPaperdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setTitle(data[0].researchPapersPublished[0].inputrp1);
              setAuthor(data[0].researchPapersPublished[0].inputrp2);
              setDepartment(data[0].researchPapersPublished[0].inputrp3);
              setSchool(data[0].researchPapersPublished[0].inputrp4);
              setDocument1(data[0].researchPapersPublished[0].inputrp5);
              setJournal(data[0].researchPapersPublished[0].inputrp6);
              setYear(data[0].researchPapersPublished[0].inputrp7);
              setIssn(data[0].researchPapersPublished[0].inputrp8);
              setLink(data[0].researchPapersPublished[0].inputrp9);
              setArticle(data[0].researchPapersPublished[0].inputrp10);
              setUcg(data[0].researchPapersPublished[0].inputrp11);
              setcurrentYear(data[0].researchPapersPublished[0].inputrp12);

              setValueep22(
                data[0].researchPapersPublishedFileUpload[0]
                  .researchPapersFilePath
              );
              setPathValueep22(
                data[0].researchPapersPublishedFileUpload[0]
                  .researchPapersFileName
              );
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    []
  );

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

        uniqueKey1: 1,
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

  function showFilePreview(e) {
    const selectedFile = e.target.files[0];
    if (selectedFile) {
      const fileReader = new FileReader();
      fileReader.readAsDataURL(selectedFile);
      fileReader.addEventListener("load", (event) => {
        setFilePreviewSrc111f1(event.target.result);
      });
    }
  }

  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }

  // const handleChange = (e) => {
  //   setPublications({
  //     ...Publications,
  //     [e.target.name]: e.target.value
  //   });
  // };

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
                  type="text"
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
                  type="text"
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
              <a href={downloadFile(pathValueep22)}>View File</a>
              </td>
            </tr>
          </table>
        </form>
        <PublicationsAuthorize />
      </div>
    </div>
  );
}
