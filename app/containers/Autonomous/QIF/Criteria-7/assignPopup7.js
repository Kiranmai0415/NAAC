import React, { useState } from "react";
import './assignPopup7-style.css';

function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: 'application/json',
  });
}

function AssignPopup7(props) {
  const [email1, setEmail1] = useState("");
  const dataAssign7 = {
    emailAddress: email1,
    criteria: 'Criteria6',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign7() {
    const methodAssign7 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign7),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign7).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign7Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign7Clicked(false)}
          className="closeButton-style"
        >
          Close
        </button>
        <h1 className="heading-style">Assign to</h1>
        <div>
          <label className="label-style">User Name or Email ID:</label>
          <input className="input-style" type="text" value={email1} onChange={(e) => setEmail1(e.target.value)} />
        </div>
        <div className="assignButton-container">
          <button
            onClick={() => {
              props.setIsAssign7Clicked(false);
              onClickingAssign7();
            }}
            className="assignButton-style"
          >
            Assign
          </button>
        </div>
      </div>
    </div>
  ) : null;
}

function AssignPopup71(props) {
  const [email2, setEmail2] = useState("");
  const dataAssign71 = {
    emailAddress: email2,
    criteria: 'Criteria6.1',
    expiryDate: '28/08/2022',
  };

  function onClickingAssign71() {
    console.log('Assigned');
    const methodAssign71 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign71),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign71).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign71Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign71Clicked(false)}
          className="closeButton-style"
        >
          Close
        </button>
        <h1 className="heading-style">Assign to</h1>
        <div>
          <label className="label-style">User Name or Email ID:</label>
          <input className="input-style" type="text" value={email2} onChange={(e) => setEmail2(e.target.value)} />
        </div>
        <div className="assignButton-container">
          <button
            onClick={() => {
              props.setIsAssign71Clicked(false);
              onClickingAssign71();
            }}
            className="assignButton-style"
          >
            Assign
          </button>
        </div>
      </div>
    </div>
  ) : null;
}

function AssignPopup72(props) {
  const [email3, setEmail3] = useState("");
  const dataAssign72 = {
    emailAddress: email3,
    criteria: 'Criteria6.2',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign72() {
    console.log('Assigned');
    const methodAssign72 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign72),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign72).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign72Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign72Clicked(false)}
          className="closeButton-style"
        >
          Close
        </button>
        <h1 className="heading-style">Assign to</h1>
        <div>
          <label className="label-style">User Name or Email ID:</label>
          <input className="input-style" type="text" value={email3} onChange={(e) => setEmail3(e.target.value)} />
        </div>
        <div className="assignButton-container">
          <button
            onClick={() => {
              props.setIsAssign72Clicked(false);
              onClickingAssign72();
            }}
            className="assignButton-style"
          >
            Assign
          </button>
        </div>
      </div>
    </div>
  ) : null;
}

function AssignPopup73(props) {
  const [email4, setEmail4] = useState("");
  const dataAssign73 = {
    emailAddress: email4,
    criteria: 'Criteria6.3',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign73() {
    console.log('Assigned');
    const methodAssign73 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign73),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign73).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign73Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign73Clicked(false)}
          className="closeButton-style"
        >
          Close
        </button>
        <h1 className="heading-style">Assign to</h1>
        <div>
          <label className="label-style">User Name or Email ID:</label>
          <input className="input-style" type="text" value={email4} onChange={(e) => setEmail4(e.target.value)} />
        </div>
        <div className="assignButton-container">
          <button
            onClick={() => {
              props.setIsAssign73Clicked(false);
              onClickingAssign73();
            }}
            className="assignButton-style"
          >
            Assign
          </button>
        </div>
      </div>
    </div>
  ) : null;
}

export {
  AssignPopup7, AssignPopup71, AssignPopup72, AssignPopup73
};
