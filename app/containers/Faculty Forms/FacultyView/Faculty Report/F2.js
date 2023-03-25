import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import "./F2-style.css";

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

function Faculty2() {
  const [valuef2t1, setValuef2t1] = useState();
  const [valuef2t2, setValuef2t2] = useState();
  const [valuef2t3, setValuef2t3] = useState();
  const [valuef2t4, setValuef2t4] = useState();
  const [valuef2t5, setValuef2t5] = useState();
  const [valuef2t6, setValuef2t6] = useState();
  const [valuef2t7, setValuef2t7] = useState();
  const [valuef2t8, setValuef2t8] = useState();
  const [valuef2t9, setValuef2t9] = useState();
  const [valuef2t10, setValuef2t10] = useState();
  const [valuef2t11, setValuef2t11] = useState();
  const [valuef2t12, setValuef2t12] = useState();
  const [valuef2t13, setValuef2t13] = useState();
  const [valuef2t14, setValuef2t14] = useState();
  const [valuef2t15, setValuef2t15] = useState();
  const [valuef2t16, setValuef2t16] = useState();
  const [valuef2t17, setValuef2t17] = useState();
  const [valuef2t18, setValuef2t18] = useState();
  const [valuef2t19, setValuef2t19] = useState();

  //map
 const  options=[
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
const  units=[
  { id:"1", unit:"0.5"},
  {id:"2",  unit:"1"},
  {id:"3",  unit:"1.5"},
  {id:"4" ,  unit:"2.0"},
  {id:"5",  unit:"2.5"},

]

const  presents=[
  { id:"1", presents:"1-10"},
  {id:"2",  presents:"10-20"},
  {id:"3",  presents:"20-30"},
  {id:"4" ,  presents:"30-40"},
  {id:"5",  presents:"40-50"},
  {id:"6" , presents:"50-60"},
  {id:"7" , presents:"70-80"},
]


  //useEffect

  useEffect(
    ()=> 
    fetch("http://localhost:8080/api/v1/getallfacultydata"
    ).then((response) => response.json()
    .then((data) => {
      console.log(JSON.stringify(data));
      setValuef2t1(data[0].ff6t1);
      setValuef2t2(data[0].ff6t2);
      setValuef2t3(data[0].ff6t3);
      setValuef2t4(data[0].ff6t4);
      setValuef2t5(data[0].ff6t5);
      setValuef2t6(data[0].ff6t6);
      setValuef2t7(data[0].ff6t7);
      setValuef2t8(data[0].ff6t8);
      setValuef2t9(data[0].ff6t9);
      setValuef2t10(data[0].ff6t10);
      setValuef2t11(data[0].ff6t11);
      setValuef2t12(data[0].ff6t12);
      setValuef2t13(data[0].ff6t13);
      setValuef2t14(data[0].ff6t14);
      setValuef2t15(data[0].ff6t15);
      setValuef2t16(data[0].ff6t16);
      setValuef2t17(data[0].ff6t17);
      setValuef2t18(data[0].ff6t18);
      setValuef2t19(data[0].ff6t19);
    })
    .catch(console.error('Error:',error)
    )
    ,[])
    );


  // sending data to db with API

  const inputDataList = {
    criteriaId: {
      collegeId: "1",
      financialYear: "2020-2021",
      typeofInstitution: "faculty",
    },
    ff6t1: valuef2t1,
    ff6t2: valuef2t2,
    ff6t3: valuef2t3,
    ff6t4: valuef2t4,
    ff6t5: valuef2t5,
    ff6t6: valuef2t6,
    ff6t7: valuef2t7,
    ff6t8: valuef2t8,
    ff6t9: valuef2t9,
    ff6t10: valuef2t10,
    ff6t11: valuef2t11,
    ff6t12: valuef2t12,
    ff6t13: valuef2t13,
    ff6t14: valuef2t14,
    ff6t15: valuef2t15,
    ff6t16: valuef2t16,
    ff6t17: valuef2t17,
    ff6t18: valuef2t18,
    ff6t19: valuef2t19,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  // function onClickingSave() {
  //   console.log("enter");
  //   const facultyReportData = new FormData();
  //   console.log(JSON.stringify(inputDataList));

  //   facultyReportData.append("facultyReport", jsonBlob(inputDataList));

  //   const filesFetchMethod = {
  //     method: "POST",
  //     headers: { Accept: "application/json ,text/plain" },
  //     authorization:
  //       "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
  //     body: facultyReportData,
  //   };
  //   fetch("http://localhost:8080/api/v1/facultydata", filesFetchMethod).then(
  //     (response) => {
  //       console.log(response);
  //       if (response.ok) {
  //         successMessage("Record is Inserted Successfully");
  //       } else if (response.status >= 400) {
  //         errorMessage("Got the Error Please retry after sometime");
  //       }
  //     }
  //   );
  // }

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
              {" "}
              Faculty Report - April 2020 (F2)
            </h1>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Email
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Email address"
                  onChange={(e) => {
                    setValuef2t1(e.target.value);
                  }}
                  value={valuef2t1}
                  className="f2-input-style"
                  id="f2-t1"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Name of the faculty
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef2t2(e.target.value);
                  }}
                  value={valuef2t2}
                  className="f2-input-style"
                  id="f2-t2"
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
               <input readOnly
                  placeholder="Select Coures"
                  required="required"
                  className="profile-input-head"
                  id="naacYearH1id"
                  list="options"
                  value={valuef2t3}
                  name="Course"
                  onChange={(e) => {
                    setValuef2t3(e.target.value);
                  }}
                />
                <datalist id="options">
                  {options.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef2t3(e.target.value);
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
                  Theory Subjects Handled
                  <span className="f2-span-style">*</span>{" "}
                </label>
                <p>Write full name of the Subjects</p>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef2t4(e.target.value);
                  }}
                  value={valuef2t4}
                  className="f2-input-style"
                  id="f2-t4"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Labs Handled
                  <span className="f2-span-style">*</span>{" "}
                </label>
                <p>Write full name of the Subjects</p>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef2t5(e.target.value);
                  }}
                  value={valuef2t5}
                  className="f2-input-style"
                  id="f2-t5"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Total No.of Online Classes taken
                  <span className="f2-span-style">*</span>{" "}
                </label>
                <p>Write full name of the Subjects</p>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef2t6(e.target.value);
                  }}
                  value={valuef2t6}
                  className="f2-input-style"
                  id="f2-t6"
                  type="number"
                />
              </div>
            </div>

      
            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  No. of Units covered<span className="f2-span-style">*</span>
                  <span className="f2-span-style">*</span>{" "}
                </label>
                <p>Select Service Branch for which subject is handling</p>
              </div>
              <div className="col-2">
               <input readOnly
                  placeholder="Select Units"
                  required="required"
                  className="profile-input-head"
              
                  list="units"
                  value={valuef2t7}
                  name="units"
                  onChange={(e) => {
                    setValuef2t7(e.target.value);
                  }}
                />
                <datalist id="units">
                  {units.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef2t7(e.target.value);
                      }}
                    >
                      {eachOptions.unit}
                    </option>
                  ))}
                </datalist>
            </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Average No.of Students present
                  <span className="f2-span-style">*</span>
                  <p>Average of all the classes</p>
                </label>
              </div>
              <div className="col-2">
               <input readOnly
                  placeholder="Select Presents"
                  required="required"
                  className="profile-input-head"
                  list="presents"
                  value={valuef2t8}
                  name="presents"
                  onChange={(e) => {
                    setValuef2t8(e.target.value);
                  }}
                />
                <datalist id="presents">
                  {presents.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef2t8(e.target.value);
                      }}
                    >
                      {eachOptions.presents}
                    </option>
                  ))}
                </datalist>
            </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  webinarsAttended
                  <span className="f2-span-style">*</span>{" "}
                </label>
                <p>Title of the course</p>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                 
                  onChange={(e) => {
                    setValuef2t9(e.target.value);
                  }}
                  value={valuef2t9}
                  className="f2-input-style"
                  id="f2-t12"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  FDPs Attended
                  <span className="f2-span-style">*</span>{" "}
                </label>
                <p>Write full name of the Subjects</p>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef2t10(e.target.value);
                  }}
                  value={valuef2t10}
                  className="f2-input-style"
                  id="f2-t10"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Publications (Research Articles)
                  <span className="f2-span-style">*</span>{" "}
                </label>
                <p>Write full name of the Subjects</p>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef2t11(e.target.value);
                  }}
                  value={valuef2t11}
                  className="f2-input-style"
                  id="f2-t11"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Courses Registered & Certified
                  <span className="f2-span-style">*</span>{" "}
                </label>
                <p>Title of the course</p>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef2t12(e.target.value);
                  }}
                  value={valuef2t12}
                  className="f2-input-style"
                  id="f2-t12"
                />
              </div>
            </div>


            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Any innovation related to Covid -19
                  <span className="f2-span-style">*</span>{" "}
                </label>
                <p>Brief description</p>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef2t13(e.target.value);
                  }}
                  value={valuef2t13}
                  className="f2-input-style"
                  id="f2-t13"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Any other achievements
                  <span className="f2-span-style">*</span>{" "}
                </label>
                <p>Brief description</p>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef2t14(e.target.value);
                  }}
                  value={valuef2t14}
                  className="f2-input-style"
                  id="f2-t14"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  No. of Mentees assigned
                  <span className="f2-span-style">*</span>{" "}
                </label>
                <p>Brief description</p>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef2t15(e.target.value);
                  }}
                  value={valuef2t15}
                  className="f2-input-style"
                  id="f2-t15"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Roll No.s of the Mentees
                  <span className="f2-span-style">*</span>{" "}
                </label>
                <p>Brief description</p>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef2t16(e.target.value);
                  }}
                  value={valuef2t16}
                  className="f2-input-style"
                  id="f2-t16"
                  type="number"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  No. of Mentees in regular contact
                  <span className="f2-span-style">*</span>{" "}
                </label>
                <p>Number only</p>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef2t17(e.target.value);
                  }}
                  value={valuef2t17}
                  className="f2-input-style"
                  id="f2-t17"
                  type="number"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  No. of Mentees got Certification
                  <span className="f2-span-style">*</span>{" "}
                </label>
                <p>Number only</p>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef2t18(e.target.value);
                  }}
                  value={valuef2t18}
                  className="f2-input-style"
                  id="f2-t18"
                  type="number"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Remarks
                  <span className="f2-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your Answer"
                  onChange={(e) => {
                    setValuef2t19(e.target.value);
                  }}
                  value={valuef2t19}
                  className="f2-input-style"
                  id="f2-t19"
                />
              </div>
            </div>
          </form>
{/* 
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
          </div> */}
        </div>{" "}
      </div>{" "}
    </div>
  );
}

export default Faculty2;
