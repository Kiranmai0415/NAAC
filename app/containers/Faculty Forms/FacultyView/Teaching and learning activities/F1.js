import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import "./F1-style.css";

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

function Faculty1() {
  const [valuef1t1, setValuef1t1] = useState();
  const [valuef1t2, setValuef1t2] = useState();
  const [valuef1t3, setValuef1t3] = useState();
  const [valuef1t4, setValuef1t4] = useState();
  const [valuef1t5, setValuef1t5] = useState();
  const [valuef1t6, setValuef1t6] = useState();
  const [valuef1t7, setValuef1t7] = useState();
  const [valuef1t8, setValuef1t8] = useState();
  const [valuef1t9, setValuef1t9] = useState();
  const [valuef1t10, setValuef1t10] = useState();
  const [valuef1t11, setValuef1t11] = useState();
  const [valuef1t12, setValuef1t12] = useState();

//useEffect
  useEffect(
    ()=> 
    fetch("http://localhost:8080/api/v1/getallteachingActivities"
    ).then((response) => response.json()
    .then((data) => {
      console.log(JSON.stringify(data));
      setValuef1t1(data[0].ff1t1);
      setValuef1t2(data[0].ff1t2);
      setValuef1t3(data[0].ff1t3);
      setValuef1t4(data[0].ff1t4);
      setValuef1t5(data[0].ff1t5);
      setValuef1t6(data[0].ff1t6);
      setValuef1t7(data[0].ff1t7);
      setValuef1t8(data[0].ff1t8);
      setValuef1t9(data[0].ff1t9);
      setValuef1t10(data[0].ff1t10);
      setValuef1t11(data[0].ff1t11);
      setValuef1t12(data[0].ff1t12);
    })
    .catch(console.error('Error:',error)
    )
    ,[])
    )

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
  const years=[
    { id:"1", year:"2022"},
    {id:"2",  year:"2021"},
    {id:"3",  year:"2020"},
    {id:"4" , year:"2019"},
    {id:"5",  year:"2018"},
    {id:"6" , year:"2017"},
    {id:"7" , year:"2016"},
    {id:"8" , year:"2015"},
    {id:"9" , year:"2014"},
  ]
  const  sections=[
    { id:"1", section:"A"},
    {id:"2",  section:"B"},
    {id:"3",  section:"C"},
    {id:"4" , section:"D"},
    {id:"5",  section:"E"},
  ]
  const  times=[
    { id:"1", time:"10:00-11:00"},
    {id:"2",  time:"11:00-12:00"},
    {id:"3",  time:"12:00-01:00"},
    {id:"4" , time:"01:00-02:00"},
    {id:"5",  time:"02:00-03:00"},
  ]
  const  modes=[
    { id:"1", mode:"ZOOM"},
    {id:"2",  mode:"SKYPE"},
    {id:"3",  mode:"MOOCS"},
    {id:"4" , mode:"MICRO TEAM"},
    {id:"5",  mode:"OTHER"}
  ]

  // sending data to db with API

  const inputDataList = {
    ff1t1: valuef1t1,
    ff1t2: valuef1t2,
    ff1t3: valuef1t3,
    ff1t4: valuef1t4,
    ff1t5: valuef1t5,
    ff1t6: valuef1t6,
    ff1t7: valuef1t7,
    ff1t8: valuef1t8,
    ff1t9: valuef1t9,
    ff1t10: valuef1t10,
    ff1t11: valuef1t11,
    ff1t12: valuef1t12,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  // function onClickingSave() {
  //   const formf1Data = new FormData();
  //   console.log(JSON.stringify(inputDataList));

  //   formf1Data.append("teachingActivities", jsonBlob(inputDataList));

  //   const saveTeachingLearningMethod = {
  //     method: "POST",
  //     headers: { Accept: "application/json ,text/plain" },
  //     authorization:
  //       "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
  //     body: formf1Data,
  //   };
  //   fetch(
  //     "http://localhost:8080/api/v1/teachingActivities",
  //     saveTeachingLearningMethod
  //   ).then((response) => {
  //     console.log(response);
  //     if (response.ok) {
  //       successMessage("Record is Inserted Successfully");
  //     } else if (response.status >= 400) {
  //       errorMessage("Got the Error Please retry after sometime");
  //     }
  //   });
  // }

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
                marginBottom: "60px",
              }}
            >
              COVID-19 Teaching&Learning Activities(F1)
            </h1>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Faculty Email
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  type="email"
                  placeholder="Your Email address"
                  onChange={(e) => {
                    setValuef1t1(e.target.value);
                  }}
                  value={valuef1t1}
                  className="f1-input-style"
                  id="f1-t1"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Name of the Faculty
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Enter your name"
                  onChange={(e) => {
                    setValuef1t2(e.target.value);
                  }}
                  value={valuef1t2}
                  className="f1-input-style"
                  id="f1-t2"
                />
              </div>
            </div>

            <div className="main">
              {/* Department  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Department
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
               <input readOnly
                  placeholder="Select Coures"
                  required="required"
                  className="profile-input-head"
                  list="option"
                  value={valuef1t3}
                  name="Course"
                  onChange={(e) => {
                    setValuef1t3(e.target.value);
                  }}
                />
                <datalist id="option">
                  {option.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef1t3(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
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
               <input readOnly
                  placeholder="Select Years"
                  required="required"
                  list="years"
                  value={valuef1t4}
                  name="Years"
                  onChange={(e) => {
                    setValuef1t4(e.target.value);
                  }}
                />
                <datalist id="years">
                  {years.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef1t4(e.target.value);
                      }}
                    >
                      {eachOptions.year}
                    </option>
                  ))}
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
               <input readOnly
                  placeholder="Select Sections"
                  required="required"
                  list="sections"
                  value={valuef1t5}
                  name="Section"
                  onChange={(e) => {
                    setValuef1t5(e.target.value);
                  }}
                />
                <datalist id="sections">
                  {sections.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef1t5(e.target.value);
                      }}
                    >
                      {eachOptions.section}
                    </option>
                  ))}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Subject Handled
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef1t6(e.target.value);
                  }}
                  value={valuef1t6}
                  className="f1-input-style"
                  id="f1-t6"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Topic Delivered
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef1t7(e.target.value);
                  }}
                  value={valuef1t7}
                  className="f1-input-style"
                  id="f1-t7"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Date
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef1t8(e.target.value);
                  }}
                  value={valuef1t8}
                  className="f1-input-style"
                  id="f1-t8"
                  type="date"
                />
              </div>
            </div>

            <div className="main">
              {/*Time Slot  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Time Slot
                  <span className="a1-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
               <input readOnly
                  placeholder="Time Slot"
                  required="required"
                  list="times"
                  value={valuef1t9}
                  name="Time Slot"
                  onChange={(e) => {
                    setValuef1t9(e.target.value);
                  }}
                />
                <datalist id="times">
                  {times.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef1t9(e.target.value);
                      }}
                    >
                      {eachOptions.time}
                    </option>
                  ))}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  No.of Students Participated
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef1t10(e.target.value);
                  }}
                  value={valuef1t10}
                  className="f1-input-style"
                  id="f1-t10"
                  type="number"
                />
              </div>
            </div>

            <div className="main">
              {/* Mode Of Teaching  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Mode of Teaching
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
               <input readOnly
                  placeholder="Mode of Teaching"
                  required="required"
                  list="modes"
                  value={valuef1t11}
                  name="Mode of Teaching"
                  onChange={(e) => {
                    setValuef1t11(e.target.value);
                  }}
                />
                <datalist id="modes">
                  {modes.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef1t11(e.target.value);
                      }}
                    >
                      {eachOptions.mode}
                    </option>
                  ))}
                </datalist>
            </div>
            </div>
            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Remarks
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef1t12(e.target.value);
                  }}
                  value={valuef1t12}
                  className="f1-input-style"
                  id="f1-t12"
                  type="text"
                />
              </div>
            </div>
          </form>

          {/* <div style={{ float: "right", marginTop: "25px" }}>
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
          </div> */}
        </div>{" "}
      </div>{" "}
    </div>
  );
}

export default Faculty1;
