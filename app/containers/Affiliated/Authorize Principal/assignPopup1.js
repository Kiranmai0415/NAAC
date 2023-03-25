import React from 'react';
import { resources } from '../../appConstants';
import './assignPopup1-style.css';
const dataAssign1 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria1',
  expiryDate: '28/08/2022',
};
const dataAssign11 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria1.1',
  expiryDate: '28/08/2022',
};
const dataAssign12 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria1.2',
  expiryDate: '28/08/2022',
};
const dataAssign13 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria1.3',
  expiryDate: '28/08/2022',
};
const dataAssign14 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria1.4',
  expiryDate: '28/08/2022',
};
function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: 'application/json',
  });
}

// Assign clicking functionality
function onClickingAssign1() {
  const methodAssign1 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign1),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign1).then(
    (response) => console.log(response)
  );
}
function onClickingAssign11() {
  console.log('Assigned');
  const methodAssign11 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign11),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign11).then(
    (response) => console.log(response)
  );
}
function onClickingAssign12() {
  console.log('Assigned');
  const methodAssign12 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign12),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign12).then(
    (response) => console.log(response)
  );
}
function onClickingAssign13() {
  console.log('Assigned');
  const methodAssign13 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign13),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign13).then(
    (response) => console.log(response)
  );
}
function onClickingAssign14() {
  console.log('Assigned');
  const methodAssign14 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign14),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign14).then(
    (response) => console.log(response)
  );
}

function AssignPopup1(props) {
  return props.isAssign1Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign1Clicked(false)}
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
              props.setIsAssign1Clicked(false);
              onClickingAssign1();
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

function AssignPopup11(props) {
  return props.isAssign11Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign11Clicked(false)}
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
          <button onClick={onClickingAssign11} className="assignButton-style">
            Assign
          </button>
        </div>
      </div>
    </div>
  ) : null;
}

function AssignPopup12(props) {
  return props.isAssign12Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign12Clicked(false)}
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
          <button onClick={onClickingAssign12} className="assignButton-style">
            Assign
          </button>
        </div>
      </div>
    </div>
  ) : null;
}

function AssignPopup13(props) {
  return props.isAssign13Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign13Clicked(false)}
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
          <button onClick={onClickingAssign13} className="assignButton-style">
            Assign
          </button>
        </div>
      </div>
    </div>
  ) : null;
}

function AssignPopup14(props) {
  return props.isAssign14Clicked ? (
    <div className="popup-mainContainer">
      <div className="popup-subContainer">
        <button
          onClick={() => props.setIsAssign14Clicked(false)}
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
          <button onClick={onClickingAssign14} className="assignButton-style">
            Assign
          </button>
        </div>
      </div>
    </div>
  ) : null;
}

export {
  AssignPopup1,
  AssignPopup11,
  AssignPopup12,
  AssignPopup13,
  AssignPopup14,
};
