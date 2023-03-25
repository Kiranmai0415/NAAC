import React, { useState } from "react";
import './assignPopup3-style.css';

function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: 'application/json',
  });
}

function AssignPopup3(props) {
  const [email1, setEmail1] = useState("");
  const dataAssign3 = {
    emailAddress: email1,
    criteria: 'Criteria3',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign3() {
    const methodAssign3 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign3),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign3).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign3Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign3Clicked(false)}
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
              props.setIsAssign3Clicked(false);
              onClickingAssign3();
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

function AssignPopup31(props) {
  const [email2, setEmail2] = useState("");
  const dataAssign31 = {
    emailAddress: email2,
    criteria: 'Criteria3.1',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign31() {
    console.log('Assigned');
    const methodAssign31 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign31),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign31).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign31Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign31Clicked(false)}
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
              props.setIsAssign31Clicked(false);
              onClickingAssign31();
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

function AssignPopup32(props) {
  const [email3, setEmail3] = useState("");
  const dataAssign32 = {
    emailAddress: email3,
    criteria: 'Criteria3.2',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign32() {
    console.log('Assigned');
    const methodAssign32 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign32),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign32).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign32Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign32Clicked(false)}
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
              props.setIsAssign32Clicked(false);
              onClickingAssign32();
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

function AssignPopup33(props) {
  const [email4, setEmail4] = useState("");
  const dataAssign33 = {
    emailAddress: email4,
    criteria: 'Criteria3.3',
    expiryDate: '28/08/2022',
  };

  function onClickingAssign33() {
    console.log('Assigned');
    const methodAssign33 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign33),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign33).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign33Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign33Clicked(false)}
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
              props.setIsAssign33Clicked(false);
              onClickingAssign33();
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

function AssignPopup34(props) {
  const [email5, setEmail5] = useState("");
  const dataAssign34 = {
    emailAddress: email5,
    criteria: 'Criteria3.4',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign34() {
    console.log('Assigned');
    const methodAssign34 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign34),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign34).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign34Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign34Clicked(false)}
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
              props.setIsAssign34Clicked(false);
              onClickingAssign34();
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

function AssignPopup35(props) {
  const [email6, setEmail6] = useState("");
  const dataAssign35 = {
    emailAddress: email6,
    criteria: 'Criteria3.5',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign35() {
    console.log('Assigned');
    const methodAssign35 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign35),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign35).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign35Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign35Clicked(false)}
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
              props.setIsAssign35Clicked(false);
              onClickingAssign35();
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

function AssignPopup36(props) {
  const [email7, setEmail7] = useState("");
  const dataAssign36 = {
    emailAddress: email7,
    criteria: 'Criteria3.6',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign36() {
    console.log('Assigned');
    const methodAssign36 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign36),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign36).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign36Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign36Clicked(false)}
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
              props.setIsAssign36Clicked(false);
              onClickingAssign36();
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

function AssignPopup37(props) {
  const [email8, setEmail8] = useState("");
  const dataAssign37 = {
    emailAddress: email8,
    criteria: 'Criteria3.7',
    expiryDate: '28/08/2022',
  };
  function onClickingAssign37() {
    console.log('Assigned');
    const methodAssign37 = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(dataAssign37),
    };
    fetch('http://localhost:8080/api/v1/AssignC1Email', methodAssign37).then(
      (response) => console.log(response)
    );
  }
  return props.isAssign37Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign37Clicked(false)}
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
              props.setIsAssign37Clicked(false);
              onClickingAssign37();
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
  AssignPopup3,
  AssignPopup31,
  AssignPopup32,
  AssignPopup33,
  AssignPopup34,
  AssignPopup35,
  AssignPopup36,
  AssignPopup37,
};
