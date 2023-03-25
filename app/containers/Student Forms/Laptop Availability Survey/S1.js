import React, { useState } from "react";
import "./S1.css";
import { toast } from "react-toastify";
import { resources } from "../../appConstants";

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
function Student1() {
  // state variables
  const [values1t1, setValues1t1] = useState();
  const [values1t2, setValues1t2] = useState();
  const [values1t3, setValues1t3] = useState();
  const [values1t4, setValues1t4] = useState();
  const [values1t5, setValues1t5] = useState();
  const [values1t6, setValues1t6] = useState();
  const [values1t7, setValues1t7] = useState();
  const [values1t8, setValues1t8] = useState();
  const [values1t9, setValues1t9] = useState();
  const [values1t10, setValues1t10] = useState();
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
    { id:"1", label:"OWN"},
    {id:"2",  label:"BORROWED"},
    {id:"3",  label:"Not Available"},
  ]
  const  option3=[
    { id:"1", label:"OWN"},
    {id:"2",  label:"BORROWED"},
    {id:"3",  label:"Not Available"},
  ]
  const  option4=[
    { id:"1", label:"Less than 2GB"},
    {id:"2",  label:"2GB"},
    {id:"3",  label:"4GB"},
    {id:"4",  label:"6GB"},
  ]
  const  option5=[
    { id:"1", label:"Donggle"},
    {id:"2",  label:"Wifi"},
    {id:"3",  label:"BroadBand"},
    {id:"4",  label:"Other"},
  ]
  const  option6=[
    { id:"1", label:"Less than 500GB"},
    {id:"2",  label:"1TB"},
    {id:"3",  label:"4TB"},
    {id:"4",  label:"More Than 4GB"},
  ]

 
  // sending data to db with API

  const inputDataList = {
    sf2t1: values1t1,
    sf2t2: values1t2,
    sf2t3: values1t3,
    sf2t4: values1t4,
    sf2t5: values1t5,
    sf2t6: values1t6,
    sf2t7: values1t7,
    sf2t8: values1t8,
    sf2t9: values1t9,
    sf2t10: values1t10,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const forms1Data = new FormData();
    forms1Data.append("laptopAvailability", jsonBlob(inputDataList));

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: forms1Data,
    };
    fetch(resources.APPLICATION_URL+"laptopdata", filesFetchMethod).then(
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
          <form>
            <h1
              style={{ color: "purple", textAlign: "center", marginTop: "0px" }}
            >
              {" "}
              Laptop Availability Survey
            </h1>
            <p style={{ textAlign: "center", marginBottom: "70px" }}>
              {" "}
              All the Staff/Students should fill this form for survey on Laptop
              facility available by an individual
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
                    setValues1t1(e.target.value);
                  }}
                  value={values1t1}
                  className="s1-input-style"
                  id="s1-t1"
                />
                {values1t1 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>
            <div className="main">
              {/* Employee ID / Student Roll No  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Employee ID / Student Roll No
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="String"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValues1t2(e.target.value);
                  }}
                  value={values1t2}
                  className="s1-input-style"
                  id="s1-t2"
                />
                {values1t2 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              {/* Name of the Staff / Student */}
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
                    setValues1t3(e.target.value);
                  }}
                  value={values1t3}
                  className="s1-input-style"
                  id="s1-t3"
                />
                {values1t3 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              {/* Department */}
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
                  value={values1t4}
                  name="Select Department"
                  onChange={(e) => {
                    setValues1t4(e.target.value);
                  }}
                />
                <datalist id="option1">
                  {option1.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues1t4(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values1t4 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Whether Laptop is available? */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Whether Laptop is available?
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
              <input
                  placeholder="Select Laptop"
                  required="required"
                  className="profile-input-head"
                  list="option2"
                  value={values1t5}
                  name="Select Laptop"
                  onChange={(e) => {
                    setValues1t5(e.target.value);
                  }}
                />
                <datalist id="option2">
                  {option2.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues1t5(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}

          {values1t5 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Model */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Model
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
              <input
                  placeholder="Select Model"
                  required="required"
                  className="profile-input-head"
                  list="option3"
                  value={values1t6}
                  name="Select Model"
                  onChange={(e) => {
                    setValues1t6(e.target.value);
                  }}
                />
                <datalist id="option3">
                  {option3.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues1t6(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values1t6 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  RAM SIZE
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
              <input
                  placeholder="Select Model"
                  required="required"
                  className="profile-input-head"
                  list="option4"
                  value={values1t7}
                  name="Select Model"
                  onChange={(e) => {
                    setValues1t7(e.target.value);
                  }}
                />
                <datalist id="option4">
                  {option4.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues1t7(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values1t7 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/*  Type of Internet  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Type of Internet
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
              <input
                  placeholder="Type of Internet"
                  required="required"
                  className="profile-input-head"
                  list="option5"
                  value={values1t8}
                  name="Type of Internet"
                  onChange={(e) => {
                    setValues1t8(e.target.value);
                  }}
                />
                <datalist id="option5">
                  {option5.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues1t8(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values1t8 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>
            <div className="main">
              {/*  Type of Internet  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  HDD CAPACITY
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
              <input
                  placeholder=" HDD CAPACITY"
                  required="required"
                  className="profile-input-head"
                  list="option6"
                  value={values1t9}
                  name=" HDD CAPACITY"
                  onChange={(e) => {
                    setValues1t9(e.target.value);
                  }}
                />
                <datalist id="option6">
                  {option6.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues1t9(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values1t9 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Remarks  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Remarks
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValues1t10(e.target.value);
                  }}
                  value={values1t10}
                  className="s1-input-style"
                  id="s1-t10"
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
export default Student1;
