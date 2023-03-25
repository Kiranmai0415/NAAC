import React from 'react';
import { resources } from '../../../../appConstants';
import './assignPopup4-style.css';

const dataAssign4 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria4',
  expiryDate: '28/08/2022',
};
const dataAssign41 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria4.1',
  expiryDate: '28/08/2022',
};
const dataAssign42 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria4.2',
  expiryDate: '28/08/2022',
};
const dataAssign43 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria4.3',
  expiryDate: '28/08/2022',
};
const dataAssign44 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria4.4',
  expiryDate: '28/08/2022',
};
function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: 'application/json',
  });
}

function onClickingAssign4() {
  const methodAssign4 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign4),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign4).then(
    (response) => console.log(response)
  );
}
function onClickingAssign41() {
  console.log('Assigned');
  const methodAssign41 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign41),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign41).then(
    (response) => console.log(response)
  );
}
function onClickingAssign42() {
  console.log('Assigned');
  const methodAssign42 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign42),
  };
  fetch(resources+'AssignC1Email', methodAssign42).then(
    (response) => console.log(response)
  );
}
function onClickingAssign43() {
  console.log('Assigned');
  const methodAssign43 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign43),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign43).then(
    (response) => console.log(response)
  );
}
function onClickingAssign44() {
  console.log('Assigned');
  const methodAssign44 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign44),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign44).then(
    (response) => console.log(response)
  );
}

function AssignPopup4(props) {
  return props.isAssign4Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign4Clicked(false)}
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
              props.setIsAssign4Clicked(false);
              onClickingAssign4();
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

function AssignPopup41(props) {
  return props.isAssign41Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign41Clicked(false)}
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
              props.setIsAssign41Clicked(false);
              onClickingAssign41();
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

function AssignPopup42(props) {
  return props.isAssign42Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign42Clicked(false)}
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
              props.setIsAssign42Clicked(false);
              onClickingAssign42();
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

function AssignPopup43(props) {
  return props.isAssign43Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign43Clicked(false)}
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
              props.setIsAssign43Clicked(false);
              onClickingAssign43();
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

function AssignPopup44(props) {
  return props.isAssign44Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign44Clicked(false)}
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
              props.setIsAssign44Clicked(false);
              onClickingAssign44();
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
  AssignPopup4,
  AssignPopup41,
  AssignPopup42,
  AssignPopup43,
  AssignPopup44,
};
