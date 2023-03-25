import React, { useState } from 'react';
import './Feedback-style.css';

function Feedback() {
  const [valuefb1, setValuefb1] = useState();
  const [valuefb2, setValuefb2] = useState();
  const [valuefb3, setValuefb3] = useState();
  const [valuefb4, setValuefb4] = useState();
  const [valuefb5, setValuefb5] = useState();

  // sending data to db with API

  const inputDataList = {
    ff1t1: valuefb1,
    ff1t2: valuefb2,
    ff1t3: valuefb3,
    ff1t4: valuefb4,
    ff1t5: valuefb5,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const feedbackData = new FormData();

    feedbackData.append('feedbackForm', jsonBlob(inputDataList));

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: feedbackData,
    };
    fetch('http://localhost:8080/api/v1/feedbackdata', filesFetchMethod).then(
      (response) => console.log(response)
    );
  }

  return (
    <div className="feedback">
      <div className="navbar">
        <h1 className="heading1">CMR TECHNICAL CAMPUS</h1>
        <p className="p1">(Sponsored by CMR Technical Education Society)</p>
        <p className="p2">UGC AUTONOMOUS</p>
        <p className="p3">Accredited by NBA & NAAC with ‘A’ Grade</p>
        <p className="p4">Approved by AICTE, New Delhi and JNTU, Hyderabad</p>
      </div>
      <div>
        <hr className="line" />
      </div>
      <div className="container">
        <h1 className="head2">
          FEEDBACK ACTION TAKEN REPORT A.Y. 2021-2022 (I SEM)
        </h1>
        <div className="card">
          <label htmlFor="fb1">Name of the Faculty: </label>
          <input
            id="fb1"
            onChange={(e) => {
              setValuefb1(e.target.value);
            }}
            className="text1"
          />
          {valuefb1 === '' ? (
            <p style={{ color: 'red', fontSize: '14px' }}>
              This is a required question
            </p>
          ) : null}
        </div>
        <div className="card">
          <label htmlFor="fb2">Department: </label>
          <input
            id="fb2"
            onChange={(e) => {
              setValuefb2(e.target.value);
            }}
            className="text1"
          />
          {valuefb2 === '' ? (
            <p style={{ color: 'red', fontSize: '14px' }}>
              This is a required question
            </p>
          ) : null}
        </div>
        <div className="card">
          <label htmlFor="fb3">
            Your feedback report has been examined carefully on the subject
            taught by you for the Class :{' '}
          </label>
          <input
            id="fb3"
            onChange={(e) => {
              setValuefb3(e.target.value);
            }}
            className="text1"
          />
          {valuefb3 === '' ? (
            <p style={{ color: 'red', fontSize: '14px' }}>
              This is a required question
            </p>
          ) : null}
        </div>
        <div className="card">
          <label htmlFor="fb4">Subject: </label>
          <input
            id="fb4"
            onChange={(e) => {
              setValuefb4(e.target.value);
            }}
            className="text1"
          />
          {valuefb4 === '' ? (
            <p style={{ color: 'red', fontSize: '14px' }}>
              This is a required question
            </p>
          ) : null}
        </div>
        <div className="card">
          <label htmlFor="fb5">Your Performance : </label>
          <input
            id="fb5"
            onChange={(e) => {
              setValuefb5(e.target.value);
            }}
            className="text1"
          />
          {valuefb5 === '' ? (
            <p style={{ color: 'red', fontSize: '14px' }}>
              This is a required question
            </p>
          ) : null}
        </div>
        <div className="card">
          <p className="card1">
            Your Performance is appreciate and advised to continue the same
            zeal.
          </p>
        </div>
        <div className="card card2">
          <p>HOD</p>
          <p>Director</p>
        </div>
        <div className="fb-button-container">
          <button className="fb-button-style" onClick={onClickingSave}>
            Submit
          </button>
        </div>
      </div>
    </div>
  );
}

export default Feedback;
