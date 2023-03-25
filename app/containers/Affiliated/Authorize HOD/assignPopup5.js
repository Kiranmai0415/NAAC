import React from 'react';
import { resources } from '../../appConstants';
import './assignPopup5-style.css';

const dataAssign5 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria5',
  expiryDate: '28/08/2022',
};
const dataAssign51 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria5.1',
  expiryDate: '28/08/2022',
};
const dataAssign52 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria5.2',
  expiryDate: '28/08/2022',
};
const dataAssign53 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria5.3',
  expiryDate: '28/08/2022',
};
const dataAssign54 = {
  emailAddress: 'namita131996@gmail.com',
  criteria: 'Criteria5.4',
  expiryDate: '28/08/2022',
};
function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: 'application/json',
  });
}

function onClickingAssign5() {
  const methodAssign5 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign5),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign5).then(
    (response) => console.log(response)
  );
}
function onClickingAssign51() {
  console.log('Assigned');
  const methodAssign51 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign51),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign51).then(
    (response) => console.log(response)
  );
}
function onClickingAssign52() {
  console.log('Assigned');
  const methodAssign52 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign52),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign52).then(
    (response) => console.log(response)
  );
}
function onClickingAssign53() {
  console.log('Assigned');
  const methodAssign53 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign53),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign53).then(
    (response) => console.log(response)
  );
}
function onClickingAssign54() {
  console.log('Assigned');
  const methodAssign54 = {
    method: 'POST',
    headers: { Accept: 'application/json' },
    authorization:
      'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
    body: jsonBlob(dataAssign54),
  };
  fetch(resources.APPLICATION_URL+'AssignC1Email', methodAssign54).then(
    (response) => console.log(response)
  );
}

function AssignPopup5(props) {
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
          <input className="input-style" type="text" />
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
          <input className="input-style" type="text" />
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
          <input className="input-style" type="text" />
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
          <input className="input-style" type="text" />
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
          <input className="input-style" type="text" />
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
