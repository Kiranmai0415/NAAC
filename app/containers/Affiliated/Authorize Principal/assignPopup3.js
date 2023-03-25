import React from 'react';
import { resources } from '../../appConstants';
import './assignPopup3-style.css';

const dataAssign3 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria3',
  expiryDate: '28/08/2022',
};
const dataAssign31 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria3.1',
  expiryDate: '28/08/2022',
};
const dataAssign32 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria3.2',
  expiryDate: '28/08/2022',
};
const dataAssign33 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria3.3',
  expiryDate: '28/08/2022',
};
const dataAssign34 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria3.4',
  expiryDate: '28/08/2022',
};
const dataAssign35 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria3.5',
  expiryDate: '28/08/2022',
};
const dataAssign36 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria3.6',
  expiryDate: '28/08/2022',
};
const dataAssign37 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria3.7',
  expiryDate: '28/08/2022',
};
function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: 'application/json',
  });
}

function onClickingAssign3() {
  const methodAssign3 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign3),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign3).then(
    (response) => console.log(response)
  );
}
function onClickingAssign31() {
  console.log('Assigned');
  const methodAssign31 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign31),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign31).then(
    (response) => console.log(response)
  );
}
function onClickingAssign32() {
  console.log('Assigned');
  const methodAssign32 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign32),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign32).then(
    (response) => console.log(response)
  );
}
function onClickingAssign33() {
  console.log('Assigned');
  const methodAssign33 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign33),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign33).then(
    (response) => console.log(response)
  );
}
function onClickingAssign34() {
  console.log('Assigned');
  const methodAssign34 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign34),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign34).then(
    (response) => console.log(response)
  );
}
function onClickingAssign35() {
  console.log('Assigned');
  const methodAssign35 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign35),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign35).then(
    (response) => console.log(response)
  );
}
function onClickingAssign36() {
  console.log('Assigned');
  const methodAssign36 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign36),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign36).then(
    (response) => console.log(response)
  );
}
function onClickingAssign37() {
  console.log('Assigned');
  const methodAssign37 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign37),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign37).then(
    (response) => console.log(response)
  );
}

function AssignPopup3(props) {
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
          <input className="input-style" type="text" />
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
          <input className="input-style" type="text" />
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
          <input className="input-style" type="text" />
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
          <input className="input-style" type="text" />
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
          <input className="input-style" type="text" />
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
          <input className="input-style" type="text" />
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
          <input className="input-style" type="text" />
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
          <input className="input-style" type="text" />
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
