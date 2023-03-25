import React, { useState , useEffect} from "react";
import { toast } from "react-toastify";
import "./F5-style.css";

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

function Faculty5() {
  const [valuef4t1, setValuef4t1] = useState();
  const [valuef4t2, setValuef4t2] = useState();
  const [valuef4t3, setValuef4t3] = useState();
  const [valuef4t4, setValuef4t4] = useState();
  const [valuef4t5, setValuef4t5] = useState();
  const [valuef4t6, setValuef4t6] = useState();
  const [valuef4t7, setValuef4t7] = useState();
  const [valuef4t8, setValuef4t8] = useState();
  const [valuef4t9, setValuef4t9] = useState();
  const [valuef4t10, setValuef4t10] = useState();
  const [pathValuef4f1, setPathValuef4f1] = useState();
  const [valuef4f1, setValuef4f1] = useState();
  const [pathValuef4f2, setPathValuef4f2] = useState();
  const [valuef4f2, setValuef4f2] = useState();
  const [pathValuef4f3, setPathValuef4f3] = useState();
  const [valuef4f3, setValuef4f3] = useState();
  const [pathValuef4f4, setPathValuef4f4] = useState();
  const [valuef4f4, setValuef4f4] = useState();
  const [pathValuef4f5, setPathValuef4f5] = useState();
  const [valuef4f5, setValuef4f5] = useState();
  const [pathValuef4f6, setPathValuef4f6] = useState();
  const [valuef4f6, setValuef4f6] = useState();


  useEffect(
    ()=> 
    fetch("http://localhost:8080/api/v1/getalleventfiles"
    ).then((response) => response.json()
    .then((data) => {
      console.log(JSON.stringify(data));
      setValuef4t1(data[0].ff4t1);
      setValuef4t2(data[0].ff4t2);
      setValuef4t3(data[0].ff4t3);
      setValuef4t4(data[0].ff4t4);
      setValuef4t5(data[0].ff4t5);
      setValuef4t6(data[0].ff4t6);
      setValuef4t7(data[0].ff4t7);
      setValuef4t8(data[0].ff4t8);
      setValuef4t9(data[0].ff4t9);
      setValuef4t10(data[0].ff4t10);
      setValuef4f1(data[0].eventFileupload[0].eventFileupload);
      setValuef4f2(data[0].eventFileupload[0].eventFileupload);
      setValuef4f3(data[0].eventFileupload[0].eventFileupload);
      setValuef4f4(data[0].eventFileupload[0].eventFileupload);
      setValuef4f5(data[0].eventFileupload[0].eventFileupload);
      setValuef4f6(data[0].eventFileupload[0].eventFileupload);
    })
    .catch(console.error('Error:', error)
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
  // sending data to db with API
  const inputDataList = {
    ff4t1: valuef4t1,
    ff4t2: valuef4t2,
    ff4t3: valuef4t3,
    ff4t4: valuef4t4,
    ff4t5: valuef4t5,
    ff4t6: valuef4t6,
    ff4t7: valuef4t7,
    ff4t8: valuef4t8,
    ff4t9: valuef4t9,
    ff4t10: valuef4t10,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  // function onClickingSave() {
  //   const formf5Data = new FormData();

  //   formf5Data.append("eventDetails", jsonBlob(inputDataList));

  //   if (setPathValuef4f1 !== "") {
  //     formf5Data.append("eventFiles", valuef4f1, "ff5f1-" + valuef4f1.name);
  //   }
  //   if (setPathValuef4f2 !== "") {
  //     formf5Data.append("eventFiles", valuef4f2, "ff5f2-" + valuef4f2.name);
  //   }
  //   if (setPathValuef4f3 !== "") {
  //     formf5Data.append("eventFiles", valuef4f3, "ff5f3-" + valuef4f3.name);
  //   }
  //   if (setPathValuef4f4 !== "") {
  //     formf5Data.append("eventFiles", valuef4f4, "ff5f4-" + valuef4f4.name);
  //   }
  //   if (setPathValuef4f5 !== "") {
  //     formf5Data.append("eventFiles", valuef4f5, "ff5f5-" + valuef4f5.name);
  //   }
  //   if (setPathValuef4f6 !== "") {
  //     formf5Data.append("eventFiles", valuef4f6, "ff5f6-" + valuef4f6.name);
  //   }

  //   const filesFetchMethod = {
  //     method: "POST",
  //     headers: { Accept: "application/json ,text/plain" },
  //     authorization:
  //       "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
  //     body: formf5Data,
  //   };
  //   fetch("http://localhost:8080/api/v1/eventupload", filesFetchMethod).then(
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
                marginTop: "20px",
              }}
            >
              Event Details (F5)
            </h1>
            <p style={{ textAlign: "center", marginBottom: "70px" }}>
              {" "}
              This form is to be filled by Event Coordinator/Convener.
            </p>
            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                 Employee  Email
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  type="text"
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValuef4t1(e.target.value);
                  }}
                  value={valuef4t1}
                  className="f5-input-style"
                  id="f5-t2"
                />
              </div>
            </div>
            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Employee ID
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  type="text"
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValuef4t2(e.target.value);
                  }}
                  value={valuef4t2}
                  className="f5-input-style"
                  id="f5-t2"
                />
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Name of the Coordinator/Convener
                  <span className="a1-span-style">*</span>{" "}
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  type="text"
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValuef4t3(e.target.value);
                  }}
                  value={valuef4t3}
                  className="f5-input-style"
                  id="f5-t3"
                />
              </div>
            </div>

            <div className="main">
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
                  value={valuef4t4}
                  name="Course"
                  onChange={(e) => {
                    setValuef4t4(e.target.value);
                  }}
                />
                <datalist id="option">
                  {option.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuef4t4(e.target.value);
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
                  Name of the Event<span className="f5-span-style">*</span>
                  <p>
                    Conference/FDP/Webinar/Workshop/Guest Lecture/Seminar/Any
                    other
                  </p>
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  type="text"
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValuef4t5(e.target.value);
                  }}
                  value={valuef4t5}
                  className="f5-input-style"
                  id="f5-t5"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Event Dates<span className="f5-span-style">*</span>
                  <p>From - to</p>
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  type="date"
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValuef4t6(e.target.value);
                  }}
                  value={valuef4t6}
                  className="f5-input-style"
                  id="f5-t6"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Brouchure/Poster/Banner
                  <span className="f5-span-style">*</span>
                  <p>Upload Brouchure</p>
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  onChange={(e) => {
                    setValuef4f1(e.target.files[0]);
                    setPathValuef4f1(e.target.value);
                  }}
                  id="f5-f1"
                  type="file"
                  value={pathValuef4f1}
                  style={{ borderBottom: "none" }}
                  className="f5-fileButton-style"
                />

                {/* {valuef5f1==="" ? (<p style={{color:"red"}}>This is a required question</p>):null} */}
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Program schedule<span className="f5-span-style">*</span>/{" "}
                  <p>
                    Upload program schedule showing day wise sessions along with
                    Speakers
                  </p>
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  onChange={(e) => {
                    setValuef4f2(e.target.files[0]);
                    setPathValuef4f2(e.target.value);
                  }}
                  id="f5-f2"
                  type="file"
                  value={pathValuef4f2}
                  style={{ borderBottom: "none" }}
                  className="f5-fileButton-style"
                />

                {/* {valuef5f1==="" ? (<p style={{color:"red"}}>This is a required question</p>):null} */}
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  No.of Participants<span className="f5-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  type="number"
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValuef4t7(e.target.value);
                  }}
                  value={valuef4t7}
                  className="f5-input-style"
                  id="f5-t7"
                />
                {/* {valuef5f1==="" ? (<p style={{color:"red"}}>This is a required question</p>):null} */}
              </div>
            </div>

            <div className="main">
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  List of Participants<span className="f5-span-style">*</span>
                </label>
                <p>
                  Upload the list along with Organisation, Email, Contact No
                </p>
              </div>
              <div className="col-2">
                <input readOnly
                  onChange={(e) => {
                    setValuef4f3(e.target.files[0]);
                    setPathValuef4f3(e.target.value);
                  }}
                  id="f5-f3"
                  type="file"
                  value={pathValuef4f3}
                  style={{ borderBottom: "none" }}
                  className="f5-fileButton-style"
                />

                {/* {valuef5f1==="" ? (<p style={{color:"red"}}>This is a required question</p>):null} */}
              </div>
            </div>
            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  No. of Speakers/Resource Persons
                  <span className="f5-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  type="number"
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValuef4t8(e.target.value);
                  }}
                  value={valuef4t8}
                  className="f5-input-style"
                  id="f5-t8"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Details of Speakers/Resource Persons
                  <span className="f5-span-style">*</span>
                  <p>Upload the profile of the Speakers</p>
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  onChange={(e) => {
                    setValuef4f4(e.target.files[0]);
                    setPathValuef4f4(e.target.value);
                  }}
                  id="f5-f4"
                  type="file"
                  value={pathValuef4f4}
                  style={{ borderBottom: "none" }}
                  className="f5-fileButton-style"
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Feed Back<span className="f5-span-style">*</span>
                  <p>Upload Feedback Report</p>
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  onChange={(e) => {
                    setValuef4f5(e.target.files[0]);
                    setPathValuef4f5(e.target.value);
                  }}
                  id="f5-f6"
                  type="file"
                  value={pathValuef4f5}
                  className="f5-fileButton-style"
                  style={{ borderBottom: "none" }}
                />
              </div>
            </div>

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Certificate<span className="f5-span-style">*</span>
                  <p>Upload sample Certificate</p>
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  onChange={(e) => {
                    setValuef4f6(e.target.files[0]);
                    setPathValuef4f6(e.target.value);
                  }}
                  id="f5-f7"
                  type="file"
                  className="f5-fileButton-style"
                  style={{ borderBottom: "none" }}
                />
              </div>
            </div>
            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                 Mode of Conductor of Event<span className="f5-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValuef4t9(e.target.value);
                  }}
                  value={valuef4t9}
                  className="f5-input-style"
                  id="f5-t10"
                />
              </div>
            </div>
            

            <div className="main">
              {/* Email  */}
              <div className="col-1">
                <label style={{ color: "black", fontSize: "18px" }}>
                  Remarks<span className="f5-span-style">*</span>
                </label>
              </div>
              <div className="col-2">
                <input readOnly
                  placeholder="Your answer"
                  onChange={(e) => {
                    setValuef4t10(e.target.value);
                  }}
                  value={valuef4t10}
                  className="f5-input-style"
                  id="f5-t10"
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

export default Faculty5;
