import React, { useState , useEffect} from "react";
import { toast } from "react-toastify";
import "./F3-style.css";

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

function Faculty3() {
  const [valuef5t1, setValuef5t1] = useState();
  const [valuef5t2, setValuef5t2] = useState();
  const [valuef5t3, setValuef5t3] = useState();
  const [valuef5t4, setValuef5t4] = useState();
  const [valuef5t5, setValuef5t5] = useState();
  const [valuef5t6, setValuef5t6] = useState();
  const [valuef5t7, setValuef5t7] = useState();
  const [valuef5t8, setValuef5t8] = useState();
  const [valuef5t9, setValuef5t9] = useState();
  const [valuef5t10, setValuef5t10] = useState();
  const [valuef5t11, setValuef5t11] = useState();
  const [valuef5t12, setValuef5t12] = useState();
  const [valuef5t13, setValuef5t13] = useState();
  const [valuef5t14, setValuef5t14] = useState();
  const [valuef5t15, setValuef5t15] = useState();

//useEffect
  useEffect(
    ()=> 
    fetch("http://localhost:8080/api/v1/getalldailyfacultyddata"
    ).then((response) => response.json()
    .then((data) => {
      console.log(JSON.stringify(data));
      setValuef5t1(data[0].ff5t1);
      setValuef5t2(data[0].ff5t2);
      setValuef5t3(data[0].ff5t3);
      setValuef5t4(data[0].ff5t4);
      setValuef5t5(data[0].ff5t5);
      setValuef5t6(data[0].ff5t6);
      setValuef5t7(data[0].ff5t7);
      setValuef5t8(data[0].ff5t8);
      setValuef5t9(data[0].ff5t9);
      setValuef5t10(data[0].ff5t10);
      setValuef5t11(data[0].ff5t11);
      setValuef5t12(data[0].ff5t12);
      setValuef5t13(data[0].ff5t13);
      setValuef5t14(data[0].ff5t14);
      setValuef5t15(data[0].ff5t15);
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
  const  times=[
    { id:"1", time:"10:00-11:00"},
    {id:"2",  time:"11:00-12:00"},
    {id:"3",  time:"12:00-01:00"},
    {id:"4" , time:"01:00-02:00"},
    {id:"5",  time:"02:00-03:00"},
  ]


  // sending data to db with API

  const inputDataList = {
    ff5t1: valuef5t1,
    ff5t2: valuef5t2,
    ff5t3: valuef5t3,
    ff5t4: valuef5t4,
    ff5t5: valuef5t5,
    ff5t6 :valuef5t6,
    ff5t7 :valuef5t7,
    ff5t8 :valuef5t8,
    ff5t9 :valuef5t9,
    ff5t10 :valuef5t10,
    ff5t11: valuef5t11,
    ff5t12: valuef5t12,
    ff5t13: valuef5t13,
    ff5t14: valuef5t14,
    ff5t15: valuef5t15,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingModify() {
    const formf3Data = new FormData();

    formf3Data.append("facultyDailyreport", jsonBlob(inputDataList));

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: formf3Data,
    };
    fetch(
      "http://localhost:8080/api/v1/facultydailydata",
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
              Faculty Daily Report (F3)
            </h1>
            <p style={{ textAlign: "center", marginBottom: "70px" }}>
              {" "}
              Note: This form is to be submitted by Faculty on daily basis.
            </p>
            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                Faculty Email
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="email"
                  placeholder="Your Email address"
                  onChange={(e) => {
                    setValuef5t1(e.target.value);
                  }}
                  value={valuef5t1}
                  className="f3-input-style"
                  id="f3-t1"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Employee ID
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="text"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef5t2(e.target.value);
                  }}
                  value={valuef5t2}
                  className="f3-input-style"
                  id="f3-t2"
                />
              </div>
            </div>

            <div className="main">
              {/* Name of the Faculty */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Name of the Faculty
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="text"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef5t3(e.target.value);
                  }}
                  value={valuef5t3}
                  className="f3-input-style"
                  id="f3-t3"
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
               <input
                  placeholder="Select Coures"
                  required="required"
                  className="profile-input-head"
                  list="option"
                  value={valuef5t4}
                  name="Course"
                  onChange={(e) => {
                    setValuef5t4(e.target.value);
                  }}
                />
                <datalist id="option">
                  {option.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef5t4(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Session Engaged  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Session Engaged
                  <span className="a1-span-style">*</span>{" "}
                  <p>Mark only one oval.</p>
                </label>
              </div>
              <div className="col-2">
               <input
                  placeholder="Time Slot"
                  required="required"
                  list="times"
                  value={valuef5t5}
                  name="Time Slot"
                  onChange={(e) => {
                    setValuef5t5(e.target.value);
                  }}
                />
                <datalist id="times">
                  {times.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef5t5(e.target.value);
                      }}
                    >
                      {eachOptions.time}
                    </option>
                  ))}
                </datalist>
            </div>
            </div>
            <div className="main">
              {/* subject handled  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                 Subject Handled
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="text"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef5t6(e.target.value);
                  }}
                  value={valuef5t6}
                  className="f3-input-style"
                  id="f3-t2"
                />
              </div>
            </div>
            <div className="main">
              {/* topic delivered  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Topic delivered
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="text"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef5t7(e.target.value);
                  }}
                  value={valuef5t7}
                  className="f3-input-style"
                  id="f3-t2"
                />
              </div>
            </div>

            <div className="main">
              {/* year  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Year
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="number"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef5t8(e.target.value);
                  }}
                  value={valuef5t8}
                  className="f3-input-style"
                  id="f3-t2"
                />
              </div>
            </div>

            <div className="main">
              
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Branch
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="text"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef5t9(e.target.value);
                  }}
                  value={valuef5t9}
                  className="f3-input-style"
                  id="f3-t2"
                />
              </div>
            </div>
            
            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                 Section
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="text"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef5t10(e.target.value);
                  }}
                  value={valuef5t10}
                  className="f3-input-style"
                  id="f3-t2"
                />
              </div>
            </div>
         <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  No.of Students Presents
                  <span className="a1-span-style">*</span>{" "}
                  <p>Mark only one oval.</p>
                </label>
              </div>
              <div className="col-2">
                <input
                  type="number"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef5t11(e.target.value);
                  }}
                  value={valuef5t11}
                  className="f3-input-style"
                  id="f3-t11"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  No.of Students Absent
                  <span className="a1-span-style">*</span>{" "}
                  <p>Mark only one oval.</p>
                </label>
              </div>
              <div className="col-2">
                <input
                  type="number"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef5t12(e.target.value);
                  }}
                  value={valuef5t12}
                  className="f3-input-style"
                  id="f3-t12"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Meeting with Mentees
                  <span className="a1-span-style">*</span>{" "}
                  <p>
                    Mentioned Date and Time and brief the points <br />{" "}
                    discussed with Mentees
                  </p>
                </label>
              </div>
              <div className="col-2">
                <input
                  type="datetime-local"
                  name="datetime"
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef5t13(e.target.value);
                  }}
                  value={valuef5t13}
                  id="f3-t13"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  No. of Mentees Participated
                  <span className="a1-span-style">*</span>{" "}
                  <p>Write full name of the labs</p>
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef5t14(e.target.value);
                  }}
                  value={valuef5t14}
                  id="f3-t14"
                  type="number"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Remarks
                  <span className="a1-span-style">*</span>{" "}
                  <p>Write full name of the labs</p>
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef5t15(e.target.value);
                  }}
                  value={valuef5t15}
                  className="f3-input-style"
                  id="f3-t15"
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

export default Faculty3;
