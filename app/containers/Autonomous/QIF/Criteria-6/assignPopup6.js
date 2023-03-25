import React, { useState } from "react";
import './assignPopup6-style.css';

function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: 'application/json',
  });
}

function AssignPopup6(props) {
  const [email1, setEmail1] = useState("");
  const dataAssign6 = {
    emailAddress: email1,
    criteria: 'Criteria6',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign6() {
    const methodAssign6 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign6),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign6).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign6Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign6Clicked(false)}
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
              props.setIsAssign6Clicked(false);
              onClickingAssign6();
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

function AssignPopup61(props) {
  const [email2, setEmail2] = useState("");
  const dataAssign61 = {
    emailAddress: email2,
    criteria: 'Criteria6.1',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign61() {
    console.log('Assigned');
    const methodAssign61 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign61),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign61).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign61Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign61Clicked(false)}
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
              props.setIsAssign61Clicked(false);
              onClickingAssign61();
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

function AssignPopup62(props) {
  const [email3, setEmail3] = useState("");
  const dataAssign62 = {
    emailAddress: email3,
    criteria: 'Criteria6.2',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign62() {
    console.log('Assigned');
    const methodAssign62 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign62),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign62).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign62Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign62Clicked(false)}
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
              props.setIsAssign62Clicked(false);
              onClickingAssign62();
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

function AssignPopup63(props) {
  const [email4, setEmail4] = useState("");
  const dataAssign63 = {
    emailAddress: email4,
    criteria: 'Criteria6.3',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign63() {
    console.log('Assigned');
    const methodAssign63 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign63),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign63).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign63Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign63Clicked(false)}
          className="closeButton-style"
        >
          Close
        </button>
        <h1 className="heading-style">Assign to</h1>
        <div>
          <label className="label-style">User Name or Email ID:</label>
          <input className="input-style" type="text" value={email4} onChange={(e) => setEmail4(e.target.value)}/>
        </div>
        <div className="assignButton-container">
          <button
            onClick={() => {
              props.setIsAssign63Clicked(false);
              onClickingAssign63();
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

function AssignPopup64(props) {
  const [email4, setEmail4] = useState("");
  const dataAssign64 = {
    emailAddress: email4,
    criteria: 'Criteria6.4',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign64() {
    console.log('Assigned');
    const methodAssign64 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign64),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign64).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign64Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign64Clicked(false)}
          className="closeButton-style"
        >
          Close
        </button>
        <h1 className="heading-style">Assign to</h1>
        <div>
          <label className="label-style">User Name or Email ID:</label>
          <input className="input-style" type="text" value={email4} onChange={(e) => setEmail4(e.target.value)}/>
        </div>
        <div className="assignButton-container">
          <button
            onClick={() => {
              props.setIsAssign64Clicked(false);
              onClickingAssign64();
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

function AssignPopup65(props) {
  const [email5, setEmail5] = useState("");
  const dataAssign65 = {
    emailAddress: email5,
    criteria: 'Criteria6.5',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign65() {
    console.log('Assigned');
    const methodAssign65 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign65),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign65).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign65Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign65Clicked(false)}
          className="closeButton-style"
        >
          Close
        </button>
        <h1 className="heading-style">Assign to</h1>
        <div>
          <label className="label-style">User Name or Email ID:</label>
          <input className="input-style" type="text" value={email5} onChange={(e) => setEmail5(e.target.value)} />
        </div>
        <div className="assignButton-container">
          <button
            onClick={() => {
              props.setIsAssign65Clicked(false);
              onClickingAssign65();
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
  AssignPopup6,
  AssignPopup61,
  AssignPopup62,
  AssignPopup63,
  AssignPopup64,
  AssignPopup65,
};
