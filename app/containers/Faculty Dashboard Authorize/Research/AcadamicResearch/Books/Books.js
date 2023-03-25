import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./Books.css";
import AuthService from "../../../../Pages/Users/services/auth.service";
import BooksAuthorize from "./BooksAuthorize";
import { resources } from "../../../../appConstants";
// Alert custom messages start

const options = [
  { id: "OPT1", options: "Yes" },
  { id: "OPT2", options: "No" },
];



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
  // file upload
  const [valueep22, setValueep22] = useState();
  const [pathValueep22, setPathValueep22] = useState("");
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState("");

  useEffect(
    () =>
      fetch("http://localhost:8080/api/v1/getallbookandchapterdata").then(
        (response) =>
          response
            .json()
            .then((data) => {
              console.log(JSON.stringify(data));
              setTeachername(data[0].booksandChapters[0].inputbct1);
              setDepartment(data[0].booksandChapters[0].inputbct2);
              setSchool(data[0].booksandChapters[0].inputbct3);
              setBooktitle(data[0].booksandChapters[0].inputbct4);
              setPapertitle(data[0].booksandChapters[0].inputbct5);
              setProceedingsTitle(data[0].booksandChapters[0].inputbct6);
              setPublicationyear(data[0].booksandChapters[0].inputbct7);
              setIsbn(data[0].booksandChapters[0].inputbct8);
              setPublishername(data[0].booksandChapters[0].inputbct9);
              setInstitutions(data[0].booksandChapters[0].inputbct10);
              setConferencename(data[0].booksandChapters[0].inputbct11);
              setNational(data[0].booksandChapters[0].inputbct12);
              setValueep22(
                data[0].booksandChaptersFileUpload[0].booksandchaptersFilePath
              );
              setPathValueep22(
                data[0].booksandChaptersFileUpload[0].booksandchaptersFileName
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
        uniqueKey1: 1,
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
                  type="text"
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
              <th>Name of the publisherName</th>
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
              <a href={downloadFile(pathValueep22)}>View File</a>
              </td>
            </tr>
          </table>
        </form>
        <BooksAuthorize />
      </div>
    </div>
  );
}
