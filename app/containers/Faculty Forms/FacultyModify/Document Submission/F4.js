import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import "./F4-style.css";

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

function Faculty4() {
  const [valuef4t1, setValuef4t1] = useState();
  const [valuef4t2, setValuef4t2] = useState();
  const [valuef4t3, setValuef4t3] = useState();
  const [valuef4t4, setValuef4t4] = useState();
  const [valuef4t5, setValuef4t5] = useState();
  const [valuef4t6, setValuef4t6] = useState();

  const [pathValuef4f1, setPathValuef4f1] = useState();
  const [valuef4f1, setValuef4f1] = useState();
  const [filePreviewSrc111f1, setFilePreviewSrc111f1] = useState('');

       //map
       const  option=[
        { id:"1", label:"Civil"},
        {id:"2",  label:"MECH"},
        {id:"3",  label:"ECE"},
        {id:"4" ,  label:"CSE"},
        {id:"5",  label:"IT"},
        {id:"6" , label:"H & S"},
        {id:"7" , label:"MBA"},
        {id:"8" , label:"CSE [AI & ML"},
        {id:"9" , label:"CSE[DS"},
      ]
  
  const  items=[
    { id:"1", item:"students"},
    {id:"2",  item:"staff"},
  ]

  useEffect(
  ()=> 
  fetch("http://localhost:8080/api/v1/getallfacultyfiles"
  ).then((response) => response.json()
  .then((data) => {
    console.log(JSON.stringify(data));
    setValuef4t1(data[0].ff2t1);
    setValuef4t2(data[0].ff2t2);
    setValuef4t3(data[0].ff2t3);
    setValuef4t4(data[0].ff2t4);
    setValuef4t5(data[0].ff2t5);
    setValuef4t6(data[0].ff2t6);
    setValuef4f1(data[0].facultyFileupload[0].facultyFileName);
  })
  .catch(console.error('Error:',error)
  )
  ,[])
  )

  // sending data to db with API

  const inputDataList = {
    ff2t1: valuef4t1,
    ff2t2: valuef4t2,
    ff2t3: valuef4t3,
    ff2t4: valuef4t4,
    ff2t5: valuef4t5,
    ff2t6: valuef4t6,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingModify() {
    const formf4Data = new FormData();
    formf4Data.append("documentSubmission", jsonBlob(inputDataList));

    if (setPathValuef4f1 !== "") {
      formf4Data.append(
        "uploadfilefaculty",
        valuef4f1,
        "ff4f1-" + valuef4f1.name
      );
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: formf4Data,
    };
    fetch("http://localhost:8080/api/v1/facultyupload", filesFetchMethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Record is Inserted Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
  }
  function showFilePreview(e) {
    const selectedFile = e.target.files[0];
    if (selectedFile) {
      const fileReader = new FileReader();
      fileReader.readAsDataURL(selectedFile);
      fileReader.addEventListener('load', (event) => {
        setFilePreviewSrc111f1(event.target.result);
      });
    }
  }
  return (
    <div>
      <div style={{ marginTop: "200px", boxShadow: "5px 5px 5px white" }}>
        <div
          style={{
            backgroundColor: "whitesmoke",
            boxShadow: "0 0 10px black",
            padding: "20px",
            borderRadius: "20px",
            paddingTop: "60px",
          }}
        >
          <form className="outer">
            <h1
              style={{
                color: "purple",
                textAlign: "center",
                marginTop: "20px",
              }}
            >
              Document Submission (F4)
            </h1>
            <p style={{ textAlign: "center", marginBottom: "70px" }}>
              All the Staff / Students use this form for submission of any
              Certificate / Document
            </p>
            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Email
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="email"
                  placeholder="Your Email address"
                  onChange={(e) => {
                    setValuef4t1(e.target.value);
                  }}
                  value={valuef4t1}
                  className="a1-input-style"
                  id="a1-t1"
                />
                {valuef4t1 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Staff/Student
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
               <input
                  placeholder=" Select Staff/Student"
                  required="required"
                  list="items"
                  value={valuef4t2}
                  name="Staff/Student"
                  onChange={(e) => {
                    setValuef4t2(e.target.value);
                  }}
                />
                <datalist id="items">
                  {items.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef4t2(e.target.value);
                      }}
                    >
                      {eachOptions.item}
                    </option>
                  ))}
                </datalist>
            </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Staff ID / Student Roll No.
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef4t3(e.target.value);
                  }}
                  value={valuef4t3}
                  className="f4-input-style"
                  id="f4-t3"
                  type="number"
                />
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Name of the Staff / Student
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef4t4(e.target.value);
                  }}
                  value={valuef4t4}
                  className="f4-input-style"
                  id="f4-t4"
                />
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Department
                  <span className="a1-span-style">*</span>{" "}
                  <p>Select Service Branch for which subject is handling</p>
                </label>
              </div>
              
              <div className="col-2">
               <input
                  placeholder="Select Coures"
                  required="required"                
                  list="option"
                  value={valuef4t5}
                  name="Course"
                  onChange={(e) => {
                    setValuef4t5(e.target.value);
                  }}
                />
                <datalist id="option">
                  {option.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef4t5(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                </datalist>
            </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Upload each document separately (PDF/Image)
                  <span className="f4-span-style">*</span>
                </label>
                <p>Maximum file size should not be more than 1MB</p>
              </div>
              <div className="col-2">
              <Stack direction="row" alignItems="center" spacing={4}>
             <Button variant="contained" component="label">
             File Upload
               <input 
                className="input-text"
                id="f4-f1" multiple type="file" accept='pdf'
                style={{ display: 'none' }}
                onChange={(e) => {
                  setValuef4f1(e.target.files[0]);
                  setPathValuef4f1(e.target.value);
                showFilePreview(e);
            }}
            />
           </Button>{pathValuef4f1}
           {pathValuef4f1 === "" ? null : (
              <div className="c21-fileButtons-container" >
                <button className="c21-viewFileButton-style" style={{height:"37px" , width:"70px"}}  >  
                <a target="_openfile" href={filePreviewSrc111f1}> View File</a></button>
                <button className="c11-removeFileButton-style" 
                  onClick={(e)=>{setPathValuef4f1("");
                  document.getElementById("f4-f1").value="" }} style={{height:"37px" , width:"70px"}} >
                   Reset                     
                </button>
              </div>
              )}
            </Stack>
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Remarks
                  <span className="f4-span-style">*</span>
                  <p>Write full name of the labs</p>
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef4t6(e.target.value);
                  }}
                  value={valuef4t6}
                  className="f4-input-style"
                  id="f4-t6"
                />
              </div>
            </div>
          </form>

          <div style={{ float: "right", marginTop: "25px" }}>
            <button
              style={{
                backgroundColor: "blue",
                color: "white",
                borderRadius: "15px",
                marginTop: "15px",
              }}
              onClick={onClickingModify}
            >
              Modify
            </button>
          </div>
        </div>{" "}
      </div>{" "}
    </div>
  );
}

export default Faculty4;
