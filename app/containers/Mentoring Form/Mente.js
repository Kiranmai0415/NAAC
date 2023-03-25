import React, { useState } from 'react';
import './Mente-style.css';

function Mente() {
  const [valuemf1t1, setValuemf1t1] = useState();
  const [valuemf1t2, setValuemf1t2] = useState();
  const [valuemf1t3, setValuemf1t3] = useState();
  const [valuemf1t4, setValuemf1t4] = useState();
  const [valuemf1t5, setValuemf1t5] = useState();
  const [valuemf1t6, setValuemf1t6] = useState();
  const [valuemf1t7, setValuemf1t7] = useState();
  const [valuemf1t8, setValuemf1t8] = useState();
  const [valuemf1t9, setValuemf1t9] = useState();
  const [valuemf1t10, setValuemf1t10] = useState();
  const [valuemf1t11, setValuemf1t11] = useState();
  const [valuemf1t12, setValuemf1t12] = useState();
  const [valuemf1t13, setValuemf1t13] = useState();
  const [valuemf1t14, setValuemf1t14] = useState();
  const [valuemf1t15, setValuemf1t15] = useState();
  const [valuemf1t16, setValuemf1t16] = useState();
  const [valuemf1t17, setValuemf1t17] = useState();
  const [valuemf1t18, setValuemf1t18] = useState();
  const [valuemf1t19, setValuemf1t19] = useState();
  const [valuemf1t20, setValuemf1t20] = useState();
  const [valuemf1t21, setValuemf1t21] = useState();
  const [valuemf1t22, setValuemf1t22] = useState();
  const [valuemf1t23, setValuemf1t23] = useState();
  const [valuemf1t24, setValuemf1t24] = useState();
  const [valuemf1t25, setValuemf1t25] = useState();

  // sending data to db with API

  const inputDataList = {
    inputmf1t1: valuemf1t1,
    inputmf1t2: valuemf1t2,
    inputmf1t3: valuemf1t3,
    inputmf1t4: valuemf1t4,
    inputmf1t5: valuemf1t5,
    inputmf1t6: valuemf1t6,
    inputmf1t7: valuemf1t7,
    inputmf1t8: valuemf1t8,
    inputmf1t9: valuemf1t9,
    inputmf1t10: valuemf1t10,
    inputmf1t11: valuemf1t11,
    inputmf1t12: valuemf1t12,
    inputmf1t13: valuemf1t13,
    inputmf1t14: valuemf1t14,
    inputmf1t15: valuemf1t15,
    inputmf1t16: valuemf1t16,
    inputmf1t17: valuemf1t17,
    inputmf1t18: valuemf1t18,
    inputmf1t19: valuemf1t19,
    inputmf1t20: valuemf1t20,
    inputmf1t21: valuemf1t21,
    inputmf1t22: valuemf1t22,
    inputmf1t23: valuemf1t23,
    inputmf1t24: valuemf1t24,
    inputmf1t25: valuemf1t25,

  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }

  function onClickingSave() {
    const formmf1Data = new FormData();

    formmf1Data.append('criteria1Fieldinfo', jsonBlob(inputDataList));

    const filesFetchMethod = {
      method: 'POST',
      headers: { Accept: 'application/json ,text/plain' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: formmf1Data,
    };
    fetch(
      'http://localhost:8080/api/v1/menteedata',
      filesFetchMethod
    ).then((response) => console.log(response));
  }

  return (
    <div className="App">
      <div className="mf1-main-conatiner">
        <div className="mf1-formHeading-container">
          <h1 className="mf1-formHeading-style">Mentoring Report</h1>
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t1" className="mf1-label-style">
            Roll No.<span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t1(e.target.value);
            }}
            value={valuemf1t1}
            className="mf1-input-style"
            id="mf1-t1"
          />
          {valuemf1t1 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t2" className="mf1-label-style">
            Name of Mentee <span className="mf1-span-style">*</span>{' '}
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t2(e.target.value);
            }}
            value={valuemf1t2}
            className="mf1-input-style"
            id="mf1-t2"
          />
          {valuemf1t2 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t3" className="mf1-label-style">
            Mobile No
            <span className="mf1-span-style">*</span>{' '}
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t3(e.target.value);
            }}
            value={valuemf1t3}
            className="mf1-input-style"
            id="mf1-t3"
          />
          {valuemf1t3 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t4" className="mf1-label-style">
            Perent Phone No.
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t4(e.target.value);
            }}
            value={valuemf1t4}
            className="mf1-input-style"
            id="mf1-t4"
          />
          {valuemf1t4 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t5" className="mf1-label-style">
            Email Id
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t5(e.target.value);
            }}
            value={valuemf1t5}
            className="mf1-input-style"
            id="mf1-t5"
          />
          {valuemf1t5 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t6" className="mf1-label-style">
            SSC % OR CGPA
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t6(e.target.value);
            }}
            value={valuemf1t6}
            className="mf1-input-style"
            id="mf1-t6"
          />
          {valuemf1t6 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t7" className="mf1-label-style">
           Inter % or CGPA
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t7(e.target.value);
            }}
            value={valuemf1t7}
            className="mf1-input-style"
            id="mf1-t7"
          />
          {valuemf1t7 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t8" className="mf1-label-style">
           EAMCET Rank
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t8(e.target.value);
            }}
            value={valuemf1t8}
            className="mf1-input-style"
            id="mf1-t8"
          />
          {valuemf1t8 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t9" className="mf1-label-style">
         Management/ Convener
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t9(e.target.value);
            }}
            value={valuemf1t9}
            className="mf1-input-style"
            id="mf1-t9"
          />
          {valuemf1t9 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t10" className="mf1-label-style">
          B.Tech Results of All clear, Write % or write No. of back Logs
          </label>
          <label htmlFor="mf1-t10" className="mf1-label-style">
           I-I%
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t10(e.target.value);
            }}
            value={valuemf1t10}
            className="mf1-input-style"
            id="mf1-t10"
          />
          {valuemf1t10 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t11" className="mf1-label-style">
           I-II%
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t11(e.target.value);
            }}
            value={valuemf1t11}
            className="mf1-input-style"
            id="mf1-t11"
          />
          {valuemf1t11 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t12" className="mf1-label-style">
           II-I%
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t12(e.target.value);
            }}
            value={valuemf1t12}
            className="mf1-input-style"
            id="mf1-t12"
          />
          {valuemf1t12 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t13" className="mf1-label-style">
           II-II%
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t13(e.target.value);
            }}
            value={valuemf1t13}
            className="mf1-input-style"
            id="mf1-t13"
          />
          {valuemf1t13 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t14" className="mf1-label-style">
           III-I%
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t14(e.target.value);
            }}
            value={valuemf1t14}
            className="mf1-input-style"
            id="mf1-t14"
          />
          {valuemf1t14 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t15" className="mf1-label-style">
           III-II%
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t15(e.target.value);
            }}
            value={valuemf1t15}
            className="mf1-input-style"
            id="mf1-t15"
          />
          {valuemf1t15 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t16" className="mf1-label-style">
           V-I%
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t16(e.target.value);
            }}
            value={valuemf1t16}
            className="mf1-input-style"
            id="mf1-t16"
          />
          {valuemf1t16 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t17" className="mf1-label-style">
           V-II%
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t17(e.target.value);
            }}
            value={valuemf1t17}
            className="mf1-input-style"
            id="mf1-t17"
          />
          {valuemf1t17 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t18" className="mf1-label-style">
          Fee Dues if any
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t18(e.target.value);
            }}
            value={valuemf1t18}
            className="mf1-input-style"
            id="mf1-t18"
          />
          {valuemf1t18 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t19" className="mf1-label-style">
          Member of any Club / Body, if so Mention
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t19(e.target.value);
            }}
            value={valuemf1t19}
            className="mf1-input-style"
            id="mf1-t19"
          />
          {valuemf1t19 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t20" className="mf1-label-style">
           Higher Education / Placement / Enterpreneurship
            <span className="mf1-span-style">*</span>
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t20(e.target.value);
            }}
            value={valuemf1t20}
            className="mf1-input-style"
            id="mf1-t20"
          />
          {valuemf1t20 === '' ? (<p style={{ color: 'red' }}>This is a required question</p>) : null}
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t21" className="mf1-label-style">
           Staying with Parents / Gaurdian /Hostel
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t21(e.target.value);
            }}
            value={valuemf1t21}
            className="mf1-input-style"
            id="mf1-t21"
          />
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t22" className="mf1-label-style">
           Internships if any
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t22(e.target.value);
            }}
            value={valuemf1t22}
            className="mf1-input-style"
            id="mf1-t22"
          />
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t23" className="mf1-label-style">
            Events participated
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t23(e.target.value);
            }}
            value={valuemf1t23}
            className="mf1-input-style"
            id="mf1-t23"
          />
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t24" className="mf1-label-style">
           Health issues if any
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t24(e.target.value);
            }}
            value={valuemf1t24}
            className="mf1-input-style"
            id="mf1-t24"
          />
        </div>

        <div className="mf1-card-container">
          <label htmlFor="mf1-t25" className="mf1-label-style">
           Remarks
          </label>
          <input
            placeholder="Your Answer"
            onChange={(e) => {
              setValuemf1t25(e.target.value);
            }}
            value={valuemf1t25}
            className="mf1-input-style"
            id="mf1-t25"
          />
        </div>

        <div className="mf1-button-container">
          <button className="mf1-button-style" onClick={onClickingSave}>Submit</button>
        </div>
      </div>
    </div>
  );
}

export default Mente;
