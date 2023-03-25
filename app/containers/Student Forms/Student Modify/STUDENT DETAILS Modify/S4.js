import React, { useState , useEffect } from "react";
import "./S4.css";
import { toast } from "react-toastify";
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
// End here

// promotion of research and facilities
function Student4() {
  // state variables
  const [values4t1, setValues4t1] = useState();
  const [values4t2, setValues4t2] = useState();
  const [values4t3, setValues4t3] = useState();
  const [values4t4, setValues4t4] = useState();
  const [values4t5, setValues4t5] = useState();
  const [values4t6, setValues4t6] = useState();
  const [values4t7, setValues4t7] = useState();
  const [values4t8, setValues4t8] = useState();
  const [values4t9, setValues4t9] = useState();
  const [pathValues4f1, setPathValues4f1] = useState("");
  const [values4f1, setValues4f1] = useState("");

//useEffect
useEffect(
  ()=> 
  fetch(resources.APPLICATION_URL+"getallStudent"
  ).then((response) => response.json()
  .then((data) => {
    console.log(JSON.stringify(data));
    setValues4t1(data[0].sf3t1);
    setValues4t2(data[0].sf3t2);
    setValues4t3(data[0].sf3t3);
    setValues4t4(data[0].sf3t4);
    setValues4t5(data[0].sf3t5);
    setValues4t6(data[0].sf3t6);
    setValues4t7(data[0].sf3t7);
    setValues4t8(data[0].sf3t8);
    setValues4t9(data[0].sf3t9);
    setValues4f1(data[0].studentIntershipFileUpload[0].studentIntershipFileUpload)
    
  
  })
  .catch(console.error('Error:',error)
  ),[])
  );


 // map
   const  option1=[
    { id:"1", label:"CSE"},
    {id:"2",  label:"MECH"},
    {id:"3",  label:"ECE"},
    {id:"4" ,  label:"CSE(Cyber Security)"},
    {id:"5",  label:"IT"},
    {id:"6" , label:"CSE (Data Science)"},
    {id:"7" , label:"CSE (Artificial Intelligence & Machine Learning)"},
    {id:"8" , label:"CIVIL"},
    {id:"9" , label:"CSE (Artificial Intelligence)"},
    {id:"10" , label:"MBA"},
  ]
  const  option2=[ 
    { id:"1", label:"Placement"},
    {id:"2",  label:"Intership"},
]
const  option3=[
  { id:"1", label:"January"},
  {id:"2",  label:"February"},
  {id:"3",  label:"March"},
  {id:"4" ,  label:"April"},
  {id:"5",  label:"May"},
  {id:"6" , label:"June"},
  {id:"7" , label:"July"},
  {id:"8" , label:"August"},
  {id:"9" , label:"September"},
  {id:"10" , label:"October"},
  {id:"11" , label:"November"},
  {id:"12" , label:"December"},
]
const  option4=[
  { id:"1", label:"2022"},
  {id:"2",  label:"2021"},
  {id:"3",  label:"2020"},
  {id:"4" ,  label:"2019"},
  {id:"5",  label:"2018"},
  {id:"6" , label:"2017"},
  {id:"7" , label:"2016"},
  {id:"8" , label:"2015"},
  {id:"9" , label:"2014"},
]

  // sending data to db with API

  const inputDataList = {
    sf3t1: values4t1,
    sf3t2: values4t2,
    sf3t3: values4t3,
    sf3t4: values4t4,
    sf3t5: values4t5,
    sf3t6: values4t6,
    sf3t7: values4t7,
    sf3t8: values4t8,
    sf3t9: values4t9,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const forms4Data = new FormData();

    if (setPathValues4f1 !== "") {
      forms4Data.append(
        "studentIntershipFileUpload",
        values4f1,
        "fs4f1-" + values4f1.name
      );
    }
    forms4Data.append("studentIntershipFileUpload", jsonBlob(inputDataList));

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: forms4Data,
    };
    fetch(
      resources.APPLICATION_URL+"internshipupload",

      filesFetchMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Inserted Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }

  // rendering DOM
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
              {" "}
              STUDENT PLACEMENT / INTERNSHIP DETAILS
            </h1>
            <p style={{ textAlign: "center", marginBottom: "70px" }}>
              {" "}
              The form STUDENT PLACEMENT / INTERNSHIP DETAILS is no longer
              accepting responses. Try contacting the owner of the form if you
              think this is a mistake
            </p>
            <div className="main">
              {/* Email  */}
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
                    setValues4t1(e.target.value);
                  }}
                  value={values4t1}
                  className="s4-input-style"
                  id="s4-t1"
                />
                {values4t1 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              {/* Employee ID / Student Roll No */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Employee ID / Student Roll No
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="string"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValues4t2(e.target.value);
                  }}
                  value={values4t2}
                  className="s4-input-style"
                  id="s4-t2"
                />
                {values4t2 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              {/* Employee ID / Student Roll No */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Department
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
              <input
                  placeholder="Select Department"
                  required="required"
                  className="profile-input-head"
                  list="option1"
                  value={values4t3}
                  name="Select Department"
                  onChange={(e) => {
                    setValues4t3(e.target.value);
                  }}
                />
                <datalist id="option1">
                  {option1.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues4t3(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values4t3 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Employee ID / Student Roll No */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Placement/Internship
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
              <input
                  placeholder="Select Department"
                  required="required"
                  className="profile-input-head"
                  list="option2"
                  value={values4t4}
                  name="Select Department"
                  onChange={(e) => {
                    setValues4t4(e.target.value);
                  }}
                />
                <datalist id="option2">
                  {option2.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues4t4(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values4t4 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Employee ID / Student Roll No */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Organisation (with full address)
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValues4t5(e.target.value);
                  }}
                  value={values4t5}
                  className="s4-input-style"
                  id="s4-t5"
                />
                {values4t5 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              {/* Employee ID / Student Roll No */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Package/Stipend
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValues4t6(e.target.value);
                  }}
                  value={values4t6}
                  className="s4-input-style"
                  id="s4-t6"
                />
                {values4t6 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              {/* MONTH */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  MONTH
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
              <input
                  placeholder="Select Month"
                  required="required"
                  className="profile-input-head"
                  list="option3"
                  value={values4t7}
                  name="Select Month"
                  onChange={(e) => {
                    setValues4t7(e.target.value);
                  }}
                />
                <datalist id="option3">
                  {option3.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues4t7(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values4t7 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* MONTH */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Year
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
              <input
                  placeholder="Select Year"
                  required="required"
                  className="profile-input-head"
                  list="option4"
                  value={values4t8}
                  name="Select Year"
                  onChange={(e) => {
                    setValues4t8(e.target.value);
                  }}
                />
                <datalist id="option4">
                  {option4.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues4t8(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values4t8 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* MONTH */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Offer Letter/Internship <br /> Certificate(Upload In PDF)
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  onChange={(e) => {
                    setValues4f1(e.target.files[0]);
                    setPathValues4f1(e.target.value);
                  }}
                  id="s4-f9"
                  type="file"
                  value={pathValues4f1}
                  style={{ borderBottom: "none" }}
                  className="s4-fileButton-style"
                />
                {/* {values4f1==="" ? (<p style={{color:"red"}}>This is a required question</p>):null} */}
              </div>
            </div>
            <div className="main">
              {/* MONTH */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Remarks
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValues4t9(e.target.value);
                  }}
                  value={values4t9}
                  className="s4-input-style"
                  id="s4-t9"
                />
                {/* {values4t9==="" ? (<p style={{color:"red"}}>This is a required question</p>):null} */}
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
              onClick={onClickingSave}
            >
              Submit
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Student4;
