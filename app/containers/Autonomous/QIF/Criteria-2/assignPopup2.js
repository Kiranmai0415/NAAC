import React, { useState } from "react";
import './assignPopup2-style.css';

function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: 'application/json',
  });
}

function AssignPopup2(props) {
  const [email1, setEmail1] = useState("");
  const dataAssign2 = {
    emailAddress: email1,
    criteria: 'Criteria2',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign2() {
    const methodAssign2 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign2),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign2).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign2Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign2Clicked(false)}
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
              props.setIsAssign2Clicked(false);
              onClickingAssign2();
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

function AssignPopup21(props) {
  const [email2, setEmail2] = useState("");
  const dataAssign21 = {
    emailAddress: email2,
    criteria: 'Criteria2.1',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign21() {
    console.log('Assigned');
    const methodAssign21 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign21),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign21).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign21Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign21Clicked(false)}
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
              props.setIsAssign21Clicked(false);
              onClickingAssign21();
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

function AssignPopup22(props) {
  const [email3, setEmail3] = useState("");
  const dataAssign22 = {
    emailAddress: email3,
    criteria: 'Criteria2.2',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign22() {
    console.log('Assigned');
    const methodAssign22 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign22),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign22).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign22Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign22Clicked(false)}
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
              props.setIsAssign22Clicked(false);
              onClickingAssign22();
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

function AssignPopup23(props) {
  const [email4, setEmail4] = useState("");
  const dataAssign23 = {
    emailAddress: email4,
    criteria: 'Criteria2.3',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign23() {
    console.log('Assigned');
    const methodAssign23 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign23),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign23).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign23Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign23Clicked(false)}
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
              props.setIsAssign23Clicked(false);
              onClickingAssign23();
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

function AssignPopup24(props) {
  const [email5, setEmail5] = useState("");
  const dataAssign24 = {
    emailAddress: email5,
    criteria: 'Criteria2.4',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign24() {
    console.log('Assigned');
    const methodAssign24 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign24),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign24).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign24Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign24Clicked(false)}
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
              props.setIsAssign24Clicked(false);
              onClickingAssign24();
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

function AssignPopup25(props) {
  const [email6, setEmail6] = useState("");
  const dataAssign25 = {
    emailAddress: email6,
    criteria: 'Criteria2.5',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign25() {
    console.log('Assigned');
    const methodAssign25 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign25),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign25).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign25Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign25Clicked(false)}
          className="closeButton-style"
        >
          Close
        </button>
        <h1 className="heading-style">Assign to</h1>
        <div>
          <label className="label-style">User Name or Email ID:</label>
          <input className="input-style" type="text" value={email6} onChange={(e) => setEmail6(e.target.value)} />
        </div>
        <div className="assignButton-container">
          <button
            onClick={() => {
              props.setIsAssign25Clicked(false);
              onClickingAssign25();
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

function AssignPopup26(props) {
  const [email7, setEmail7] = useState("");
  const dataAssign26 = {
    emailAddress: email7,
    criteria: 'Criteria2.6',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign26() {
    console.log('Assigned');
    const methodAssign26 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign26),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign26).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign26Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign26Clicked(false)}
          className="closeButton-style"
        >
          Close
        </button>
        <h1 className="heading-style">Assign to</h1>
        <div>
          <label className="label-style">User Name or Email ID:</label>
          <input className="input-style" type="text" value={email7} onChange={(e) => setEmail7(e.target.value)} />
        </div>
        <div className="assignButton-container">
          <button
            onClick={() => {
              props.setIsAssign26Clicked(false);
              onClickingAssign26();
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

function AssignPopup27(props) {
  const [email8, setEmail8] = useState("");
  const dataAssign27 = {
    emailAddress: email8,
    criteria: 'Criteria2.7',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign27() {
    console.log('Assigned');
    const methodAssign27 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign27),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign27).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign27Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign27Clicked(false)}
          className="closeButton-style"
        >
          Close
        </button>
        <h1 className="heading-style">Assign to</h1>
        <div>
          <label className="label-style">User Name or Email ID:</label>
          <input className="input-style" type="text" value={email8} onChange={(e) => setEmail8(e.target.value)} />
        </div>
        <div className="assignButton-container">
          <button
            onClick={() => {
              props.setIsAssign27Clicked(false);
              onClickingAssign27();
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
  AssignPopup2,
  AssignPopup21,
  AssignPopup22,
  AssignPopup23,
  AssignPopup24,
  AssignPopup25,
  AssignPopup26,
  AssignPopup27,
};
