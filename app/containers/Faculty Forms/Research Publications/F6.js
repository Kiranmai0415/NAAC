import React, { useState } from "react";
import { toast } from "react-toastify";
import "./F6-style.css";

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

function Faculty6() {
  const [valuef3t1, setValuef3t1] = useState();
  const [valuef3t2, setValuef3t2] = useState();
  const [valuef3t3, setValuef3t3] = useState();
  const [valuef3t4, setValuef3t4] = useState();
  const [valuef3t5, setValuef3t5] = useState();
  const [valuef3t6, setValuef3t6] = useState();
  const [valuef3t7, setValuef3t7] = useState();
  const [valuef3t8, setValuef3t8] = useState();
  const [valuef3t9, setValuef3t9] = useState();
  const [valuef3t10, setValuef3t10] = useState();
  const [valuef3t11, setValuef3t11] = useState();
  const [valuef3t12, setValuef3t12] = useState();
  const [valuef3t13, setValuef3t13] = useState();
  const [valuef3t14, setValuef3t14] = useState();
  const [valuef3t15, setValuef3t15] = useState();
  const [valuef3t16, setValuef3t16] = useState();
  const [valuef3t17, setValuef3t17] = useState();
  const [pathValuef3f1, setPathValuef3f1] = useState();
  const [valuef3f1, setValuef3f1] = useState();

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
const  rankings=[
  { id:"1", ranking:" Q1"},
  {id:"2",  ranking:"Q2"},
  {id:"3",  ranking:"Q3"},
  {id:"4" , ranking:"Q4"},
]
const  months=[
  { id:"1", Month:'January'},
  {id:"2",  Month:"February"},
  {id:"3",  Month:"March"},
  {id:"4" ,  Month:"April"},
  {id:"5",  Month:"May"},
  {id:"6" , Month:"June"},
  {id:"7" , Month:"July"},
  {id:"8" , Month:"Augest"},
  {id:"9" , Month:"September"},
  {id:"10",  Month:"October"},
  {id:"11",  Month:"November"},
  {id:"12",  Month:"December"},
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

  // sending data to db with API

  const inputDataList = {
    ff3t1: valuef3t1,
    ff3t2: valuef3t2,
    ff3t3: valuef3t3,
    ff3t4: valuef3t4,
    ff3t5: valuef3t5,
    ff3t6: valuef3t6,
    ff3t7: valuef3t7,
    ff3t8: valuef3t8,
    ff3t9: valuef3t9,
    ff3t10: valuef3t10,
    ff3t11: valuef3t11,
    ff3t12: valuef3t12,
    ff3t13: valuef3t13,
    ff3t14: valuef3t14,
    ff3t15: valuef3t15,
    ff3t16: valuef3t16,
    ff3t17: valuef3t17,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const formf6Data = new FormData();
    formf6Data.append("researchPublications", jsonBlob(inputDataList));

    if (setPathValuef3f1 !== "") {
      formf6Data.append("researchFiles", valuef3f1, "ff3f1-" + valuef3f1.name);
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: formf6Data,
    };
    fetch("http://localhost:8080/api/v1/researchupload", filesFetchMethod).then(
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
              Research Publication (F6)
            </h1>
            <p style={{ textAlign: "center", marginBottom: "70px" }}>
              {" "}
              Faculty should submit their Research Publications through this
              form.
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
                  placeholder="Your Email address"
                  onChange={(e) => {
                    setValuef3t1(e.target.value);
                  }}
                  value={valuef3t1}
                  className="f6-input-style"
                  id="f6-t1"
                />
              </div>
            </div>

            <div className="main">
              {/* Employee ID */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Employee ID <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef3t2(e.target.value);
                  }}
                  value={valuef3t2}
                  className="f6-input-style"
                  id="f6-t2"
                />
              </div>
            </div>

            <div className="main">
              {/*Name of the Faculty */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Name of the Faculty <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef3t3(e.target.value);
                  }}
                  value={valuef3t3}
                  className="f6-input-style"
                  id="f6-t3"
                />
              </div>
            </div>

            <div className="main">
              {/* department */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Department
                </label>
              </div>
              
              <div className="col-2">
               <input
                  placeholder="Select Coures"
                  required="required"
                  className="profile-input-head"
                
                  list="option"
                  value={valuef3t4}
                  name="Course"
                  onChange={(e) => {
                    setValuef3t4(e.target.value);
                  }}
                />
                <datalist id="option">
                  {option.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef3t4(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* SCOPUS ID  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  SCOPUS ID <span className="a1-span-style">*</span>{" "}
                  <p>Write full name of the Subjects</p>
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef3t5(e.target.value);
                  }}
                  value={valuef3t5}
                  className="f6-input-style"
                  id="f6-t5"
                  type="number"
                />
              </div>
            </div>

            <div className="main">
              {/* Scopus 'h-Index' of CMRGI Authors */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Scopus 'h-Index' of CMRGI Authors
                  <span className="a1-span-style">*</span>{" "}
                  <p>
                    Mention each individual <br /> author h <br /> index
                    separated by
                    <br /> Comma Ex: 6,7,2...
                  </p>
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef3t6(e.target.value);
                  }}
                  value={valuef3t6}
                  className="f6-input-style"
                  id="f6-t6"
                  type="number"
                />
              </div>
            </div>

            <div className="main">
              {/* Q Ranking */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Q Ranking
                </label>
              </div>
              <div className="col-2">
               <input
                  placeholder="Select Ranking"
                  required="required"
                  className="profile-input-head"
                
                  list="rankings"
                  value={valuef3t7}
                  name="Ranking"
                  onChange={(e) => {
                    setValuef3t7(e.target.value);
                  }}
                />
                <datalist id="rankings">
                  {rankings.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef3t7(e.target.value);
                      }}
                    >
                      {eachOptions.ranking}
                    </option>
                  ))}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Vidwan ID  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Vidwan ID
                  <span className="a1-span-style">*</span>{" "}
                  <p>Write full name of the Subjects</p>
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef3t8(e.target.value);
                  }}
                  value={valuef3t8}
                  className="f6-input-style"
                  id="f6-t8"
                  type="number"
                />
              </div>
            </div>

            <div className="main">
              {/* Title of the Publication */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Title of the Publication
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef3t9(e.target.value);
                  }}
                  value={valuef3t9}
                  className="f6-input-style"
                  id="f6-t9"
                />
              </div>
            </div>

            <div className="main">
              {/* Name of the Journal/Conference  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Name of the Journal/Conference
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef3t10(e.target.value);
                  }}
                  value={valuef3t10}
                  className="f6-input-style"
                  id="f6-t10"
                />
              </div>
            </div>

            <div className="main">
              {/* ISSN/ISBN */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  ISSN/ISBN
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef3t11(e.target.value);
                  }}
                  value={valuef3t11}
                  className="f6-input-style"
                  id="f6-t11"
                />
              </div>
            </div>

            <div className="main">
              {/* Volume No  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Volume No
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef3t12(e.target.value);
                  }}
                  value={valuef3t12}
                  className="f6-input-style"
                  id="f6-t12"
                  type="number"
                />
              </div>
            </div>

            <div className="main">
              {/*Issue No */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Issue No.
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef3t13(e.target.value);
                  }}
                  value={valuef3t13}
                  className="f6-input-style"
                  id="f6-t13"
                  type="number"
                />
              </div>
            </div>

            <div className="main">
            {/* Months Of Publication */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Month of Publication
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
               <input
                  placeholder="Select Months"
                  required="required"
                  className="profile-input-head"
                
                  list="months"
                  value={valuef3t14}
                  name="Months"
                  onChange={(e) => {
                    setValuef3t14(e.target.value);
                  }}
                />
                <datalist id="months">
                  {months.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef3t14(e.target.value);
                      }}
                    >
                      {eachOptions.Month}
                    </option>
                  ))}
                </datalist>
            </div>
            </div>

            <div className="main">
             {/* Year of Publcation  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Year of Publication
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
               <input
                  placeholder="Select Years"
                  required="required"
                  list="years"
                  value={valuef3t15}
                  name="Years"
                  onChange={(e) => {
                    setValuef3t15(e.target.value);
                  }}
                />
                <datalist id="years">
                  {years.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef3t15(e.target.value);
                      }}
                    >
                      {eachOptions.year}
                    </option>
                  ))}
                </datalist>
            </div>
            </div>
            
            <div className="main">
              {/* Digital Object Identified  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                Digital Object Identified 
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef3t16(e.target.value);
                  }}
                  value={valuef3t16}
                  className="f6-input-style"
                  id="f6-t15"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Upload Full Paper (PDF only)
                  <span className="a1-span-style">*</span>{" "}
                  <p>Maximum file size should not be more than 2MB</p>
                </label>
              </div>
              <div className="col-2">
                <input
                  onChange={(e) => {
                    setValuef3f1(e.target.files[0]);
                    setPathValuef3f1(e.target.value);
                  }}
                  id="f6-f1"
                  type="file"
                  value={pathValuef3f1}
                  style={{ borderBottom: "none" }}
                  className="f6-fileButton-style"
                />
              </div>
            </div>

            <div className="main">
              {/* Remark  */}
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
                    setValuef3t17(e.target.value);
                  }}
                  value={valuef3t17}
                  className="f6-input-style"
                  id="f6-t15"
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
export default Faculty6;
