import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import { resources } from "../../../appConstants";
import "./A1-style.css";

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

function Admin1() {
  const [valuea1t1, setValuea1t1] = useState();
  const [valuea1t2, setValuea1t2] = useState();
  const [valuea1t3, setValuea1t3] = useState();
  const [valuea1t4, setValuea1t4] = useState();
  const [valuea1t5, setValuea1t5] = useState();
  const [valuea1t6, setValuea1t6] = useState();
  const [valuea1t7, setValuea1t7] = useState();
  const [valuea1t81, setValuea1t81] = useState();
  const [valuea1t82, setValuea1t82] = useState();
  const [valuea1t83, setValuea1t83] = useState();
  const [valuea1t11, setValuea1t11] = useState();
  const [valuea1t12, setValuea1t12] = useState();
  const [valuea1t13, setValuea1t13] = useState();
  const [valuea1t14, setValuea1t14] = useState();

 //useEffect
 useEffect(
  ()=> 
  fetch(resources.APPLICATION_URL+"getalladminfiles"
  ).then((response) => response.json()
  .then((data) => {
    console.log(JSON.stringify(data));
    setValuea1t1(data[0] ? data[0].af2t1 : "");
    setValuea1t2(data[0] ? data[0].af2t2 : "");
    setValuea1t3(data[0] ? data[0].af2t3 : "");
    setValuea1t4(data[0] ? data[0].af2t4 : "");
    setValuea1t5(data[0] ? data[0].af12t5 : "");
    setValuea1t6(data[0] ? data[0].af2t6 : "");
    setValuea1t7(data[0] ? data[0].af2t7 : "");
    setValuea1t81(data[0] ? data[0].af2t81 : "");
    setValuea1t82(data[0] ? data[0].af2t82 : "");
    setValuea1t83(data[0] ? data[0].af2t83 : "");
    setValuea1t11(data[0] ? data[0].af2t11 : "");
    setValuea1t12(data[0] ? data[0].af2t12 : "");
    setValuea1t13(data[0] ? data[0].af2t13 : "");
    setValuea1t14(data[0] ? data[0].af2t14 : "");
      
    })
  .catch(console.error('Error:',error)
  )
  ,[])
  )

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
  ]
  const  option2=[
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
  const  option3=[
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
    af2t1: valuea1t1,
    af2t2: valuea1t2,
    af2t3: valuea1t3,
    af2t4: valuea1t4,
    af2t5: valuea1t5,
    af2t6: valuea1t6,
    af2t7: valuea1t7,
    af2t8: valuea1t81,
    af2t9: valuea1t82,
    af2t10: valuea1t83,
    af2t11: valuea1t11,
    af2t12: valuea1t12,
    af2t13: valuea1t13,
    af2t14: valuea1t14,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const admin1Data = new FormData();
    console.log(inputDataList);
    admin1Data.append("admissionEnquiryForm", jsonBlob(inputDataList));

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: admin1Data,
    };
    fetch(
      resources.APPLICATION_URL+"admissionEnquiry",
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
              [AI] Admission Enquiry Form
            </h1>
            <p style={{ textAlign: "center", marginBottom: "70px" }}>
              {" "}
              Please submit this form regarding the course which you are
              interested.
            </p>
            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px",  }}>
                  Email
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="email"
                  placeholder="Your Email address"
                  onChange={(e) => {
                    setValuea1t1(e.target.value);
                  }}
                  value={valuea1t1}
                  className="a1-input-style"
                  id="a1-t1"
                
                />
                {valuea1t1 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Name
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea1t2(e.target.value);
                  }}
                  value={valuea1t2}
                  className="a1-input-style"
                  id="a1-t2"
                />
                {valuea1t2 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Mobile No
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="number"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea1t3(e.target.value);
                  }}
                  value={valuea1t3}
                  className="a1-input-style"
                  id="a1-t3"
                />
                {valuea1t3 === "" ? (
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
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea1t4(e.target.value);
                  }}
                  value={valuea1t4}
                  className="a1-input-style"
                  id="a1-t4"
                />
                {valuea1t4 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Contact Number
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
                <input
                  type="number"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea1t5(e.target.value);
                  }}
                  value={valuea1t5}
                  className="a1-input-style"
                  id="a1-t5"
                />
                {valuea1t5 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Mother Name
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea1t6(e.target.value);
                  }}
                  value={valuea1t6}
                  className="a1-input-style"
                  id="a1-t6"
                />
                {valuea1t6 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Contact Number
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
                <input
                  type="number"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea1t7(e.target.value);
                  }}
                  value={valuea1t7}
                  className="a1-input-style"
                  id="a1-t7"
                />
                {valuea1t7 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Preferred Course-I
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
              <input
                  placeholder="Select Preferred-I"
                  required="required"
                  className="profile-input-head"
                  list="option1"
                  value={valuea1t81}
                  name="Preferred Course-I"
                  onChange={(e) => {
                    setValuea1t81(e.target.value);
                  }}
                />
                <datalist id="option1">
                  {option1.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuea1t81(e.target.value);
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
                  Preferred Course-II
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              
              <div className="col-2">
               <input
                  placeholder="Select Preferred-I"
                  required="required"
                  className="profile-input-head"
                  list="option1"
                  value={valuea1t82}
                  name="Preferred Course-II"
                  onChange={(e) => {
                    setValuea1t82(e.target.value);
                  }}
                />
                <datalist id="option2">
                  {option2.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuea1t82(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                </datalist>
            </div>
                {valuea1t82 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
            
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Preferred Course-III
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
              <input
                  placeholder="Select Preferred-I"
                  required="required"
                  className="profile-input-head"
                  list="option3"
                  value={valuea1t83}
                  name="Preferred Course-III"
                  onChange={(e) => {
                    setValuea1t83(e.target.value);
                  }}
                />
                <datalist id="option3">
                  {option3.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuea1t83(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                </datalist>
                {valuea1t83 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  SSC Marks
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
                <input
                  type="number"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea1t11(e.target.value);
                  }}
                  value={valuea1t11}
                  className="a1-input-style"
                  id="a1-t11"
                />
                {valuea1t11 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Inter Marks
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
                <input
                  type="number"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea1t12(e.target.value);
                  }}
                  value={valuea1t12}
                  className="a1-input-style"
                  id="a1-t12"
                />
                {valuea1t12 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
              </div>
            </div>

            {/* TSEAMCET Rank */}
            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  TSEAMCET Rank
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
                <input
                  type="number"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea1t13(e.target.value);
                  }}
                  value={valuea1t13}
                  className="a1-input-style"
                  id="a1-t13"
                />
              </div>
            </div>
            {/* Remarks Rank */}
            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Remarks
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuea1t14(e.target.value);
                  }}
                  value={valuea1t14}
                  className="a1-input-style"
                  id="a1-t14"
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

export default Admin1;
