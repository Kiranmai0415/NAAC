import React, { useState } from "react";
import { FormControl, FormControlLabel,RadioGroup,Radio, FormLabel } from "@material-ui/core";
import "./A2-style.css";
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

function Admin2() {
  const [valuea2t1, setValuea2t1] = useState();
  const [valuea2t2, setValuea2t2] = useState();
  const [valuea2t3, setValuea2t3] = useState();
  const [valuea2t4, setValuea2t4] = useState();
  const [valuea2t5, setValuea2t5] = useState();
  const [valuea2t6, setValuea2t6] = useState();
  const [valuea2t7, setValuea2t7] = useState();
  const [valuea2t8, setValuea2t8] = useState();
  const [valuea2t9, setValuea2t9] = useState();
  const [valuea2t10, setValuea2t10] = useState();
  const [valuea2t11, setValuea2t11] = useState();
  const [valuea2t12, setValuea2t12] = useState();
  const [valuea2t13, setValuea2t13] = useState();
  const [valuea2t14, setValuea2t14] = useState();
  const [valuea2t15, setValuea2t15] = useState([]);
  const [pathValuea2t15, setPathValuea2t15] = useState("");

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
  ]

  // sending data to db with API

  const inputDataList = {
    af1t1: valuea2t1,
    af1t2: valuea2t2,
    af1t3: valuea2t3,
    af1t4: valuea2t4,
    af1t5: valuea2t5,
    af1t6: valuea2t6,
    af1t7: valuea2t7,
    af1t8: valuea2t8,
    af1t9: valuea2t9,
    af1t10: valuea2t10,
    af1t11: valuea2t11,
    af1t12: valuea2t12,
    af1t13: valuea2t13,
    af1t14: valuea2t14,
    af1t15: valuea2t15,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const admin2Data = new FormData();
    console.log(inputDataList);

    admin2Data.append("admissionForm", jsonBlob(inputDataList));
    if (pathValuea2t15 !== "") {
      admin2Data.append(
        "uploadfileadmin",
        valuea2t15,
        "a2t15-" + valuea2t15.name
      );
    }
    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: admin2Data,
    };
    fetch(resources.APPLICATION_URL+"adminupload", filesFetchMethod).then(
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
              Admission Form A.Y 2022-23
            </h1>
            <p style={{ textAlign: "center", marginBottom: "70px" }}>
              {" "}
              Note: This form is to be filled by I B. Tech Students only
            </p>
            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Student Name(as per SSC)
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2" style={{marginLeft:"8%"}}>
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea2t1(e.target.value);
                  }}
                  value={valuea2t1}
                  className="a2-input-style"
                  id="a2-t1"
                />
                {valuea2t1 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Father Name
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2" style={{marginLeft:"8%"}}>
                <input
                  type="text"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea2t2(e.target.value);
                  }}
                  value={valuea2t2}
                  className="a2-input-style"
                  id="a2-t2"
                />
                {valuea2t2 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Mother Name
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2" style={{marginLeft:"8%"}}>
                <input
                  type="text"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea2t3(e.target.value);
                  }}
                  value={valuea2t3}
                  className="a2-input-style"
                  id="a2-t3"
                />
                {valuea2t3 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>
           {/* student Aadhar Number */}
            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Student Aadhaar Number
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2" style={{marginLeft:"8%"}}>
                <input
                  type="number"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea2t4(e.target.value);
                  }}
                  value={valuea2t4}
                  className="a2-input-style"
                  id="a2-t4"
                />
                {valuea2t4 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>
                  {/* course */}
            <div className="main">
              <div className="col-1" >
                <label style={{ color: "black", fontSize: "18px" , }}>
                  Course
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2" style={{marginLeft:"8%"}}>
              <input
                  placeholder="Select Course"
                  required="required"
              
                  list="option"
                  className="course"
                  value={valuea2t5}
                  name="Select Course"
                  onChange={(e) => {
                    setValuea2t5(e.target.value);
                  }}
                />
                <datalist id="option">
                  {option.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuea2t5(e.target.value);
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
                It is a recognized minority institution?
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              <div className="col-2" style={{marginLeft:"8%"}}>
             <FormControl>
              <RadioGroup name="radio-buttons-group">
              <FormControlLabel value="Yes"  
              onChange={(e) => setValuea2t6(e.target.value)} 
              control={<Radio />} label="Yes" />

               <FormControlLabel value="No"  
               onChange={(e) => setValuea2t6(e.target.value)} 
               control={<Radio />} label="No" />
             </RadioGroup>
               </FormControl>  
              </div>
              {valuea2t6 === "" ? (
                <p style={{ color: "red" }}>This is a required question</p>
              ) : null}
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Category
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              <div className="col-2" style={{marginLeft:"8%"}}>
                <div
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t8"
                    type="radio"
                    name="dept"
                    className="check"
                    value="BC-A"
                    onChange={(e) => {
                      setValuea2t8(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t8">BC-A</label>
                </div>
                <div
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t8"
                    type="radio"
                    name="dept"
                    className="check"
                    value="BC-B"
                    onChange={(e) => {
                      setValuea2t8(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t8">BC-B</label>
                </div>
                <div
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t8"
                    type="radio"
                    name="dept"
                    className="check"
                    value="BC-C"
                    onChange={(e) => {
                      setValuea2t8(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t8">BC-C</label>
                </div>
                <div
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t8"
                    type="radio"
                    name="dept"
                    className="check"
                    value="BC-D"
                    onChange={(e) => {
                      setValuea2t8(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t8">BC-D</label>
                </div>
                <div
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t8"
                    type="radio"
                    name="dept"
                    className="check"
                    value="BC-E"
                    onChange={(e) => {
                      setValuea2t8(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t8">BC-E</label>
                </div>
                <div
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t8"
                    type="radio"
                    name="dept"
                    className="check"
                    value="SC"
                    onChange={(e) => {
                      setValuea2t8(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t8">SC</label>
                </div>
                <div
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t8"
                    type="radio"
                    name="dept"
                    className="check"
                    value="ST"
                    onChange={(e) => {
                      setValuea2t8(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t8">ST</label>
                </div>
                <div
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t8"
                    type="radio"
                    name="dept"
                    className="check"
                    value="OC"
                    onChange={(e) => {
                      setValuea2t8(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t8">OC</label>
                </div>
                <div
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t8"
                    type="radio"
                    name="dept"
                    className="check"
                    value="OTHERS"
                    onChange={(e) => {
                      setValuea2t8(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t8">OTHERS</label>
                </div>
                {valuea2t8 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Student Mobile No
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2" style={{marginLeft:"8%"}}>
                <input
                  type="number"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea2t9(e.target.value);
                  }}
                  value={valuea2t9}
                  className="a2-input-style"
                  id="a2-t9"
                />
                {valuea2t9 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Father Mobile No
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2" style={{marginLeft:"8%"}}>
                <input
                  type="number"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea2t10(e.target.value);
                  }}
                  value={valuea2t10}
                  className="a2-input-style"
                  id="a2-t10"
                />
                {valuea2t10 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Email
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2" style={{marginLeft:"8%"}}>
                <input
                  type="email"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea2t11(e.target.value);
                  }}
                  value={valuea2t11}
                  className="a2-input-style"
                  id="a2-t11"
                />
                {valuea2t11 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Address (D. No, Street, Area, City, State, Pin Code)
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2" style={{marginLeft:"8%"}}>
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea2t12(e.target.value);
                  }}
                  value={valuea2t12}
                  className="a2-input-style"
                  id="a2-t12"
                />
                {valuea2t12 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Blood Group
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2" style={{marginLeft:"8%"}}>
                <div
                  className="a2-eachRadio-container"
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t13"
                    type="radio"
                    name="dept"
                    className="check"
                    value="O+"
                    onChange={(e) => {
                      setValuea2t13(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t13">O+</label>
                </div>
                <div
                  className="a2-eachRadio-container"
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-13"
                    type="radio"
                    name="dept"
                    className="check"
                    value="O-"
                    onChange={(e) => {
                      setValuea2t13(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t13">O-</label>
                </div>
                <div
                  className="a2-eachRadio-container"
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t13"
                    type="radio"
                    name="dept"
                    className="check"
                    value="B+"
                    onChange={(e) => {
                      setValuea2t13(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t13">B+</label>
                </div>
                <div
                  className="a2-eachRadio-container"
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t13"
                    type="radio"
                    name="dept"
                    className="check"
                    value="B-"
                    onChange={(e) => {
                      setValuea2t13(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t13">B-</label>
                </div>
                <div
                  className="a2-eachRadio-container"
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t13"
                    type="radio"
                    name="dept"
                    className="check"
                    value="AB+"
                    onChange={(e) => {
                      setValuea2t13(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t13">AB+</label>
                </div>
                <div
                  className="a2-eachRadio-container"
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t13"
                    type="radio"
                    name="dept"
                    className="check"
                    value="AB-"
                    onChange={(e) => {
                      setValuea2t13(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t13">SC</label>
                </div>
                <div
                  className="a2-eachRadio-container"
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t13"
                    type="radio"
                    name="dept"
                    className="check"
                    value="A+"
                    onChange={(e) => {
                      setValuea2t13(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t13">A+</label>
                </div>
                <div
                  className="a2-eachRadio-container"
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <input
                    id="a2-t13"
                    type="radio"
                    name="dept"
                    className="check"
                    value="A-"
                    onChange={(e) => {
                      setValuea2t13(e.target.value);
                    }}
                  />
                  <label htmlFor="a2-t13">A-</label>
                </div>
                {valuea2t13 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Date of Birth
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2" style={{marginLeft:"8%"}}>
                <input
                  type="date"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea2t14(e.target.value);
                  }}
                  value={valuea2t14}
                  className="a2-input-style"
                  id="a2-t14"
                />
                {valuea2t14 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                <p className="date">Example: January 7, 2019</p>
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Recent Passport Size Photo
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2" style={{marginLeft:"8%"}}>
                <input
                  placeholder="Your Answer"
                  type="file"
                  style={{ borderBottom: "none" }}
                  onChange={(e) => {
                    setValuea2t15(e.target.files[0]);
                    setPathValuea2t15(e.target.value);
                  }}
                  className="input-button"
                  id="a2-t15"
                />
                {valuea2t15 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
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

export default Admin2;
