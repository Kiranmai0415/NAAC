import React, { useState } from "react";
import { toast } from "react-toastify";
import "./assignPopup1-style.css";

// Alert custom messages start
const successMessage = (message) => {
  toast.success(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "success1",
  });
};
const errorMessage = (message) => {
  toast.error(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "error1",
  });
};
// End here

function jsonBlob(obj) {
  return new Blob([JSON.stringify(obj)], {
    type: "application/json",
  });
}

// Assign clicking functionality

function AssignPopup1(props) {
  const [email1, setEmail1] = useState("");

  const dataAssign1 = {
    emailAddress: email1,
    criteria: "Criterian1",
    expiryDate: "28/08/2022",
  };

  function onClickingAssign1() {
    const methodAssign1 = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(dataAssign1),
    };
    fetch("http://localhost:8080/api/v1/AssignC1Email", methodAssign1).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Assigned Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }
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
          <input className="input-style" type="text" value={email1} onChange={(e) => setEmail1(e.target.value)} />
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
  const [email2, setEmail2] = useState("");
  const dataAssign11 = {
    emailAddress: email2,
    criteria: "Criteria1.1",
    expiryDate: "28/08/2022",
  };
  function onClickingAssign11() {
    console.log("Assigned");
    const methodAssign11 = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(dataAssign11),
    };
    fetch("http://localhost:8080/api/v1/AssignC1Email", methodAssign11).then(
      (response) => console.log(response)
    );
  }
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
          <input className="input-style" type="text" value={email2} onChange={(e) => setEmail2(e.target.value)} />
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
  const [email3, setEmail3] = useState("");
  const dataAssign12 = {
    emailAddress: email3,
    criteria: "Criteria1.2",
    expiryDate: "28/08/2022",
  };
  function onClickingAssign12() {
    console.log("Assigned");
    const methodAssign12 = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(dataAssign12),
    };
    fetch("http://localhost:8080/api/v1/AssignC1Email", methodAssign12).then(
      (response) => console.log(response)
    );
  }
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
          <input className="input-style" type="text" value={email3} onChange={(e) => setEmail3(e.target.value)} />
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
  const [email4, setEmail4] = useState("");
  const dataAssign13 = {
    emailAddress: email4,
    criteria: "Criteria1.3",
    expiryDate: "28/08/2022",
  };
  function onClickingAssign13() {
    console.log("Assigned");
    const methodAssign13 = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(dataAssign13),
    };
    fetch("http://localhost:8080/api/v1/AssignC1Email", methodAssign13).then(
      (response) => console.log(response)
    );
  }
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
          <input className="input-style" type="text" value={email4} onChange={(e) => setEmail4(e.target.value)} />
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
  const [email5, setEmail5] = useState("");
  const dataAssign14 = {
    emailAddress: email5,
    criteria: "Criteria1.4",
    expiryDate: "28/08/2022",
  };
  function onClickingAssign14() {
    console.log("Assigned");
    const methodAssign14 = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(dataAssign14),
    };
    fetch("http://localhost:8080/api/v1/AssignC1Email", methodAssign14).then(
      (response) => console.log(response)
    );
  }
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
          <input className="input-style" type="text" value={email5} onChange={(e) => setEmail5(e.target.value)} />
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
