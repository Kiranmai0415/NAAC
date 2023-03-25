import React, { useState } from "react";
import './assignPopup5-style.css';

function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: 'application/json',
  });
}

function AssignPopup5(props) {
  const [email1, setEmail1] = useState("");
  const dataAssign5 = {
    emailAddress: email1,
    criteria: 'Criteria5',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign5() {
    const methodAssign5 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign5),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign5).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign5Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign5Clicked(false)}
          className="closeButton-style"
        >
          Close
        </button>
        <h1 className="heading-style">Assign to</h1>
        <div>
          <label className="label-style">User Name or Email ID:</label>
          <input className="input-style" type="text" value={email1} onChange={(e) => setEmail1(e.target.value)}/>
        </div>
        <div className="assignButton-container">
          <button
            onClick={() => {
              props.setIsAssign5Clicked(false);
              onClickingAssign5();
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

function AssignPopup51(props) {
  const [email2, setEmail2] = useState("");
  const dataAssign51 = {
    emailAddress: email2,
    criteria: 'Criteria5.1',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign51() {
    console.log('Assigned');
    const methodAssign51 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign51),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign51).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign51Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign51Clicked(false)}
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
              props.setIsAssign51Clicked(false);
              onClickingAssign51();
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

function AssignPopup52(props) {
  const [email3, setEmail3] = useState("");
  const dataAssign52 = {
    emailAddress: email3,
    criteria: 'Criteria5.2',
    expiryDate: '28/08/2022',
  };

  function onClickingAssign52() {
    console.log('Assigned');
    const methodAssign52 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign52),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign52).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign52Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign52Clicked(false)}
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
              props.setIsAssign52Clicked(false);
              onClickingAssign52();
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

function AssignPopup53(props) {
  const [email4, setEmail4] = useState("");
  const dataAssign53 = {
    emailAddress: email4,
    criteria: 'Criteria5.3',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign53() {
    console.log('Assigned');
    const methodAssign53 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign53),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign53).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign53Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign53Clicked(false)}
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
              props.setIsAssign53Clicked(false);
              onClickingAssign53();
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

function AssignPopup54(props) {
  const [email5, setEmail5] = useState("");
  const dataAssign54 = {
    emailAddress: email5,
    criteria: 'Criteria5.4',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign54() {
    console.log('Assigned');
    const methodAssign54 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign54),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign54).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign54Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign54Clicked(false)}
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
              props.setIsAssign54Clicked(false);
              onClickingAssign54();
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
  AssignPopup5,
  AssignPopup51,
  AssignPopup52,
  AssignPopup53,
  AssignPopup54,
};
