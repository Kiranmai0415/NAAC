import React, { useState } from 'react';
import './I1-style.css';
import { toast } from "react-toastify";
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

function Intern1() {
  const [valuei1t1, setValuesi1t1] = useState();
  const [valuei1t2, setValuesi1t2] = useState();
  const [valuei1t3, setValuesi1t3] = useState();
  const [valuei1t4, setValuesi1t4] = useState();
  const [valuei1t5, setValuesi1t5] = useState();
  const [valuei1t6, setValuesi1t6] = useState();
  const [valuei1t7, setValuesi1t7] = useState();
  const [valuei1t8, setValuesi1t8] = useState();
  const [valuei1t9, setValuesi1t9] = useState();
  const [valuei1t10, setValuesi1t10] = useState();
  const [valuei1t11, setValuesi1t11] = useState();
 const [valuei1t111, setValuesi1t111] = useState();
  const [pathValuei1t111, setPathValuesi1t111] = useState('');
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
    { id:"1", label:"I"},
    {id:"2",  label:"II"},
    {id:"3",  label:"III"},
    {id:"4" ,  label:"IV"},
  ]
  const  option3=[
    { id:"1", label:"A"},
    {id:"2",  label:"B"},
    {id:"3",  label:"C"},
    {id:"4" ,  label:"D"},
  ]
  const  option4=[
    { id:"1", label:"Yes"},
    {id:"2",  label:"No"},
  ]

  // sending data to db with API

  const inputDataList = {
    if1t1: valuei1t1,
    if1t2: valuei1t2,
    if1t3: valuei1t3,
    if1t4: valuei1t4,
    if1t5: valuei1t5,
    if1t6: valuei1t6,
    if1t7: valuei1t7,
    if1t8: valuei1t8,
    if1t9: valuei1t9,
    if1t10: valuei1t10,
    if1t11: valuei1t11,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const internData = new FormData();

    internData.append('internshipForm', jsonBlob(inputDataList));
    if (pathValuei1t111 !== '') {
      internData.append(
        'internshipfiles',
        valuei1t111,
        'i1t111-' + valuei1t111.name
      );
    }

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: internData,
    };
    fetch(
      'http://localhost:8080/api/v1/internshipupload',
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
    <div className="App">
      <div className="i1-main-conatiner">
        <div className="i1-formHeading-container">
          <h1 className="i1-formHeading-style">Internship List</h1>
          <p className="i1-formDescription-style">
            The name and photo associated with your Google account will be
            recorded when you upload files and submit this form. Your email is
            not part of your response.
          </p>
          <p style={{ color: 'red' }}>*Required</p>
        </div>

        <div className="i1-card-container">
          <label htmlFor="i1-t1" className="i1-label-style">
            Full Name<span className="i1-span-style">*</span>
          </label>
          <input
            placeholder="Your Full Name"
            onChange={(e) => {
              setValuesi1t1(e.target.value);
            }}
            value={valuei1t1}
            className="i1-input-style"
            id="i1-t1"
          />
          {valuei1t1 === '' ? (
            <p style={{ color: 'red' }}>This is a required question</p>
          ) : null}
        </div>

        <div className="i1-card-container">
          <label htmlFor="i1-t2" className="i1-label-style">
            Full Roll Number<span className="i1-span-style">*</span>{' '}
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuesi1t2(e.target.value);
            }}
            value={valuei1t2}
            className="i1-input-style"
            id="i1-t2"
          />
          {valuei1t2 === '' ? (
            <p style={{ color: 'red' }}>This is a required question</p>
          ) : null}
        </div>
 
        <div className="i1-card-container">
          <h1 className="i1-radioHeading-style">
            Branch<span className="i1-span-style">*</span>
          </h1>
          <form>
            <div className="i1-eachRadio-container">
            <input
                  placeholder="Select Department"
                  required="required"
                  className="profile-input-head"
                  list="option1"
                  value={valuei1t3}
                  name="Select Department"
                  onChange={(e) => {
                    setValuesi1t3(e.target.value);
                  }}
                />
                <datalist id="option1">
                  {option1.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuesi1t3(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                  </datalist>
            </div>
            {valuei1t3 === '' ? (
              <p style={{ color: 'red' }}>This is a required question</p>
            ) : null}
          </form>
        </div>

        <div className="i1-card-container">
          <h1 className="i1-radioHeading-style">
            Year<span className="i1-span-style">*</span>
          </h1>
          <form>
            <div className="i1-eachRadio-container">
            <input
                  placeholder="Select Year"
                  required="required"
                  className="profile-input-head"
                  list="option2"
                  value={valuei1t4}
                  name="Select Year"
                  onChange={(e) => {
                    setValuesi1t4(e.target.value);
                  }}
                />
                <datalist id="option2">
                  {option2.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuesi1t4(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                  </datalist>
            </div>
            {valuei1t4 === '' ? (
              <p style={{ color: 'red' }}>This is a required question</p>
            ) : null}
          </form>
        </div>

        <div className="i1-card-container">
          <h1 className="i1-radioHeading-style">
            Section<span className="i1-span-style">*</span>
          </h1>
          <form>
            <div className="i1-eachRadio-container">
            <input
                  placeholder="Section"
                  required="required"
                  className="profile-input-head"
                  list="option3"
                  value={valuei1t5}
                  name="Section"
                  onChange={(e) => {
                    setValuesi1t5(e.target.value);
                  }}
                />
                <datalist id="option3">
                  {option3.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuesi1t5(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                  </datalist>

            </div>
            {valuei1t5 === '' ? (
              <p style={{ color: 'red' }}>This is a required question</p>
            ) : null}
          </form>
        </div>

        <div className="i1-card-container">
          <label htmlFor="i1-t6" className="i1-label-style">
            Mobile Number
            <span className="i1-span-style">*</span>{' '}
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuesi1t6(e.target.value);
            }}
            value={valuei1t6}
            className="i1-input-style"
            id="i1-t6"
          />
          {valuei1t6 === '' ? (
            <p style={{ color: 'red' }}>This is a required question</p>
          ) : null}
        </div>

        <div className="i1-card-container">
          <label htmlFor="i1-t7" className="i1-label-style">
            Email ID
            <span className="i1-span-style">*</span>
          </label>
          <input
            placeholder="Your Email"
            onChange={(e) => {
              setValuesi1t7(e.target.value);
            }}
            value={valuei1t7}
            className="i1-input-style"
            id="i1-t7"
          />
          {valuei1t7 === '' ? (
            <p style={{ color: 'red' }}>This is a required question</p>
          ) : null}
        </div>

        <div className="i1-card-container">
          <label htmlFor="i1-t8" className="i1-label-style">
            Name of the Company
            <span className="i1-span-style">*</span>
          </label>
          <input
            placeholder="Name of the Company"
            onChange={(e) => {
              setValuesi1t8(e.target.value);
            }}
            value={valuei1t8}
            className="i1-input-style"
            id="i1-t8"
          />
          {valuei1t8 === '' ? (
            <p style={{ color: 'red' }}>This is a required question</p>
          ) : null}
        </div>

        <div className="i1-card-container">
          <h1 className="i1-radioHeading-style">
            Salary Given
            <span className="i1-span-style">*</span>
          </h1>
          <form>
            <div className="i1-eachRadio-container">
            <input
                  placeholder="Salary Given"
                  required="required"
                  className="profile-input-head"
                  list="option4"
                  value={valuei1t9}
                  name="Salary Given"
                  onChange={(e) => {
                    setValuesi1t9(e.target.value);
                  }}
                />
                <datalist id="option4">
                  {option4.map((eachOptions) => (
                    <option
                      key={eachOptions.id}
                      onChange={(e) => {
                        setValuesi1t9(e.target.value);
                      }}
                    >
                      {eachOptions.label}
                    </option>
                  ))}
                  </datalist>
            </div>
            {valuei1t9 === '' ? (
              <p style={{ color: 'red' }}>This is a required question</p>
            ) : null} <br/>

            <p htmlFor="i1-t10" className="i1-label-style">
            If Yes, Mention the amount
          </p>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuesi1t10(e.target.value);
            }}
            value={valuei1t10}
            className="i1-input-style"
            id="i1-t10"
          />
          {valuei1t10 === '' ? (
            <p style={{ color: 'red' }}>This is a required question</p>
          ) : null}
          </form>
        </div>

        <div className="i1-card-container">
          <label htmlFor="i1-t11" className="i1-label-style">
            Upload your offer letter of internship(PDF Only - Max file size 1
            MB)
            <span className="i1-span-style">*</span>
          </label>
          <input
            type="file"
            placeholder="Your Answer"
            onChange={(e) => {
              setValuesi1t111(e.target.files[0]);
              setPathValuesi1t111(e.target.value);
            }}
            className="i1-input-style"
            id="i1-t11"
          />
          {valuei1t11 === '' ? (
            <p style={{ color: 'red' }}>This is a required question</p>
          ) : null}
        </div>

        <div className="i1-card-container">
          <label htmlFor="i1-t12" className="i1-label-style">
            Any other Information?
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuesi1t11(e.target.value);
            }}
            value={valuei1t11}
            className="i1-input-style"
            id="i1-t12"
          />
          {valuei1t11 === '' ? (
            <p style={{ color: 'red' }}>This is a required question</p>
          ) : null}
        </div>

        <div className="i1-button-container">
          <button className="i1-button-style" onClick={onClickingSave}>
            Submit
          </button>
        </div>
      </div>
    </div>
  );
}

export default Intern1;
