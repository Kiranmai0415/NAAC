import React, { useState , useEffect } from "react";
import "./S2.css";
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
function Student2() {
  // state variables
  const [values2t1, setValues2t1] = useState();
  const [values2t2, setValues2t2] = useState();
  const [values2t3, setValues2t3] = useState();
  const [values2t4, setValues2t4] = useState();
  const [values2t5, setValues2t5] = useState();
  const [values2t6, setValues2t6] = useState();
  const [values2t7, setValues2t7] = useState();
  const [values2t8, setValues2t8] = useState();
  const [values2t9, setValues2t9] = useState();
  const [values2t10, setValues2t10] = useState();
  const [values2t11, setValues2t11] = useState();
  const [pathValues2f1, setPathValues2f1] = useState("");
  const [values2f1, setValues2f1] = useState("");

  const [mobile, setmobile] = useState("");
  const [isError, setIsError] = useState(false);


//useEffect
useEffect(
  ()=> 
  fetch(resources.APPLICATION_URL+"getallstudentfiles"
  ).then((response) => response.json()
  .then((data) => {
    console.log(JSON.stringify(data));
    setValues2t1(data[0].sf1t1);
    setValues2t2(data[0].sf1t2);
    setValues2t3(data[0].sf1t3);
    setValues2t4(data[0].sf1t4);
    setValues2t5(data[0].sf1t5);
    setValues2t6(data[0].sf1t6);
    setValues2t7(data[0].sf1t7);
    setValues2t8(data[0].sf1t8);
    setValues2t9(data[0].sf1t9);
    setValues2f1(data[0].studentfileUpload[0].studentfileUpload)
    
  
  })
  .catch(console.error('Error:',error)
  ),[])
  );


  //MAP
  const  option=[
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
  const  option0=[
    { id:"1", label:"B.Tech"},
    {id:"2",  label:"MBA"},
    {id:"3",  label:"ECE"},
    {id:"4" ,  label:"CSE(Cyber Security)"},
  ]
  const  option1=[
    { id:"1", label:"I"},
    {id:"2",  label:"II"},
    {id:"3",  label:"III"},
    {id:"4" ,  label:"IV"},
    {id:"5" ,  label:"Passout Out"},
  ]
  const  option2=[
    { id:"1", label:"A"},
    {id:"2",  label:"B"},
    {id:"3",  label:"C"},
    {id:"4" ,  label:"D"},
  ]
  const  option3=[
    { id:"1", label:"Bonafide Certificate"},
    {id:"2",  label:"Custodian Certificate "},
    {id:"3",  label:"Transfer Certificate"},
    {id:"4" ,  label:"Course Completion"},
    {id:"5",  label:"Medium of Instruction"},
    {id:"6" , label:"Internship Letter"},
    {id:"7" , label:"Project Premission Letter"},
    {id:"8" , label:"Letter of Recommendation Letter"},
    {id:"9" , label:"Name Correction on Memo's PC'S"},
    {id:"10" , label:"OTHER"},
  ]

  // sending data to db  with API
  const inputDataList = {
    sf1t1: values2t1,
    sf1t2: values2t2,
    sf1t3: values2t3,
    sf1t4: values2t4,
    sf1t5: values2t5,
    sf1t6: values2t6,
    sf1t7: values2t7,
    sf1t8: values2t8,
    sf1t9: values2t9,
    sf1t10: values2t10,
    sf1t11: values2t11,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const forms2Data = new FormData();
    forms2Data.append("studentform", jsonBlob(inputDataList));

    if (setPathValues2f1 !== "") {
      forms2Data.append(
        "studentfileUpload",
        values2f1,
        "fs2f1-" + values2f1.name
      );
    }
    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: forms2Data,
    };
    fetch(
      resources.APPLICATION_URL+"studentupload",

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
              Student Request Form
            </h1>
            <p style={{ textAlign: "center", marginBottom: "70px" }}>
              {" "}
              Students should submit this form along with handwritten request
              letter to be uploaded for any service from ADMIN Office.
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
                    setValues2t1(e.target.value);
                  }}
                  value={values2t1}
                  className="s2-input-style"
                  id="s2-t1"
                />
                {values2t1 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Student Roll No.
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="string"
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValues2t2(e.target.value);
                  }}
                  value={values2t2}
                  className="s2-input-style"
                  id="s2-t2"
                />
                {values2t2 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Name of the Student
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="text"
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValues2t3(e.target.value);
                  }}
                  value={values2t3}
                  className="s2-input-style"
                  id="s2-t3"
                />
                {values2t3 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Contact Number
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="number"
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValues2t4(e.target.value);
                  }}
                  value={values2t4}
                  className="s2-input-style"
                  id="s2-t4"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Programme
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
              <input
                  placeholder="Select Programmes"
                  required="required"
                  className="profile-input-head"
                  list="option0"
                  value={values2t5}
                  name="Select Programmes"
                  onChange={(e) => {
                    setValues2t5(e.target.value);
                  }}
                />
                <datalist id="option0">
                  {option0.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues2t5(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values2t5 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Email  */}
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
                  list="option"
                  value={values2t6}
                  name="Select Department"
                  onChange={(e) => {
                    setValues2t6(e.target.value);
                  }}
                />
                <datalist id="option">
                  {option.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues2t6(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values2t6 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Email  */}
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
                  list="option1"
                  value={values2t7}
                  name="Select Year"
                  onChange={(e) => {
                    setValues2t7(e.target.value);
                  }}
                />
                <datalist id="option1">
                  {option1.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues2t7(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values2t7 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Section
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
              <input
                  placeholder="Section"
                  required="required"
                  className="profile-input-head"
                  list="option2"
                  value={values2t8}
                  name="Section"
                  onChange={(e) => {
                    setValues2t8(e.target.value);
                  }}
                />
                <datalist id="option2">
                  {option2.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues2t8(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values2t8 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Requested Certificate(s)/Document(s)
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
              <input
                  placeholder="Requested Certificate"
                  required="required"
                  className="profile-input-head"
                  list="option3"
                  value={values2t9}
                  name="Requested Certificate"
                  onChange={(e) => {
                    setValues2t9(e.target.value);
                  }}
                />
                <datalist id="option3">
                  {option3.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues2t9(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values2t9 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Address
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="text"
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValues2t10(e.target.value);
                  }}
                  value={values2t10}
                  className="s2-input-style"
                  id="s2-t10"
                />
                {/* {values2t10==="" ? (<p style={{color:"red"}}>This is a required question</p>):null} */}
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Handwritten Request Letter
                  <span className="s2-span-style">*</span>
                </label>
                <p>
                  Upload the scan/photo copy of handwritten request
                  <br />
                  letter duly signed by applicant, max <br /> size 1 MB only.
                </p>
              </div>

              <div className="col-2">
                <input
                  onChange={(e) => {
                    setValues2f1(e.target.files[0]);
                    setPathValues2f1(e.target.value);
                  }}
                  id="s2-f1"
                  type="file"
                  value={pathValues2f1}
                  style={{ borderBottom: "none" }}
                  className="s2-fileButton-style"
                />
                {/* {values2f1==="" ? (<p style={{color:"red"}}>This is a required question</p>):null} */}
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Remarks<span className="s2-span-style">*</span>
                </label>
              </div>

              <div className="col-2">
                <input
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValues2t11(e.target.value);
                  }}
                  value={values2t11}
                  className="s2-input-style"
                  id="s2-t11"
                />
                {/* {values2f1==="" ? (<p style={{color:"red"}}>This is a required question</p>):null} */}
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
export default Student2;
