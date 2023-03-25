import React, { useState , useEffect } from "react";
import { toast } from "react-toastify";
import "./S3.css";
import TextField from "@material-ui/core/TextField";
import InputAdornment from "@material-ui/core/InputAdornment";
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
function Student3() {
  // state variables
  const [values3t1, setValues3t1] = useState();
  const [values3t2, setValues3t2] = useState();
  const [values3t3, setValues3t3] = useState();
  const [values3t4, setValues3t4] = useState();
  const [values3t5, setValues3t5] = useState();
  const [values3t6, setValues3t6] = useState();
  const [values3t7, setValues3t7] = useState();
  const [pathValues3f1, setPathValues3f1] = useState("");
  const [values3f1, setValues3f1] = useState("");

  const [mobile, setmobile] = useState("");
  const [isError, setIsError] = useState(false);

   //useEffect
useEffect(
  ()=> 
  fetch(resources.APPLICATION_URL+"getallcourseRegistration"
  ).then((response) => response.json()
  .then((data) => {
    console.log(JSON.stringify(data));
    setValues3t1(data[0].sf4t1);
    setValues3t2(data[0].sf4t2);
    setValues3t3(data[0].sf4t3);
    setValues3t4(data[0].sf4t4);
    setValues3t5(data[0].sf4t5);
    setValues3t6(data[0].sf4t6);
    setValues3t7(data[0].sf4t7);

    setValues3f1(data[0].courseRegistreFileUpload[0].courseRegistreFileUpload);
  
  })
  .catch(console.error('Error:',error)
  ),[])
  );
  //map
  const  option1=[
    { id:"1", label:"I"},
    {id:"2",  label:"II"},
    {id:"3",  label:"III"},
    {id:"4" ,  label:"IV"},

  ]

  // sending data to db
  const inputDataList = {
    courseRegistrationform: [
      {
        sf4t1: values3t1,
        sf4t2: values3t2,
        sf4t3: values3t3,
        sf4t4: values3t4,
        sf4t5: values3t5,
        sf4t6: values3t6,
        sf4t7: values3t7,
      },
    ],
  };
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const forms3Data = new FormData();

    forms3Data.append("studentform", jsonBlob(inputDataList));
    if (setPathValues3f1 !== "") {
      forms3Data.append(
        "studentfileUpload",
        values3f1,
        "fs3f1-" + values3f1.name
      );
    }

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: forms3Data,
    };
    fetch(resources.APPLICATION_URL+"Cmr", filesFetchMethod).then(
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
          <form className="outer">
            <h1
              style={{
                color: "purple",
                textAlign: "center",
                marginTop: "20px",
              }}
            >
              CMR TECHNICAL CAMPUS
            </h1>
            <p style={{ textAlign: "center", marginBottom: "70px" }}>
              {" "}
              UGC AUTONOMOUS.
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
                    setValues3t1(e.target.value);
                  }}
                  value={values3t1}
                  className="s3-input-style"
                  id="s3-t1"
                />
              </div>
            </div>
            <div className="main">
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
                  value={values3t2}
                  name="Select Year"
                  onChange={(e) => {
                    setValues3t2(e.target.value);
                  }}
                />
                <datalist id="option1">
                  {option1.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValues3t2(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                    {values3t2 === "" ? (
                  <p style={{ color: "red" }}>This is a required question</p>
                ) : null}
                </datalist>
            </div>
            </div>
            
            <div className="main">
              {/*  Roll No.  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Roll No.
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValues3t3(e.target.value);
                  }}
                  value={values3t3}
                  className="s3-input-style"
                  id="s3-t3"
                  type="number"
                />
              </div>
            </div>
            <div className="main">
              {/* Contact Number  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Contact Number
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValues3t4(e.target.value);
                  }}
                  value={values3t4}
                  className="s3-input-style"
                  id="s3-t4"
                  type="number"
                />
              </div>
            </div>
            <div className="main">
              {/*   Amount paid  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Amount paid
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  type="number"
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValues3t5(e.target.value);
                  }}
                  value={values3t5}
                  className="s3-input-style"
                  id="s3-t5"
                />
              </div>
            </div>
            <div className="main">
              {/*  Transaction id/Receipt No: */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Transaction id/Receipt No:
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input
                  placeholder="Your answer"
                  type="number"
                  onChange={(e) => {
                    setValues3t6(e.target.value);
                  }}
                  value={values3t6}
                  className="s3-input-style"
                  id="s3-t6"
                />
              </div>
            </div>
            <div className="main">
              {/* Upload Payment Receipt (Proof of Payment): */}

              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Upload Payment Receipt <br /> (Proof of Payment):
                  <span className="a1-span-style">*</span>
                  <p>
                    Please upload Qfix Receipt <br /> / screen shot of
                    transaction details <br />
                    /Cash deposit slip.
                  </p>
                </label>
              </div>

              <div className="col-2">
                <input
                  onChange={(e) => {
                    setValues3f1(e.target.files[0]);
                    setPathValues3f1(e.target.value);
                  }}
                  id="s3-f1"
                  type="file"
                  className="s3-fileButton-style"
                  style={{ borderBottom: "none" }}
                />
              </div>
            </div>
            <div className="main">
              {/*  Declaration */}

              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Declaration
                  <span className="a1-span-style">*</span>
                </label>
              </div>

              <div className="col-2dec">
                <input type="checkbox" style={{ width: "50px" }} />
                <p>
                  I hereby declare that the above furnished information is true
                  and correct to the best of my knowledge and belief.
                </p>
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
              Save
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Student3;
