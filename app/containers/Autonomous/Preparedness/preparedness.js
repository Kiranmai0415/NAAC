import React, { useState } from "react";
import { toast } from "react-toastify";
import "./preparedness.css";

// Alert custom messages start
const successMessage = (message) => {
  toast.success(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "success1",
    className: "success",
  });
};
const errorMessage = (message) => {
  toast.error(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "error1",
    className: "error",
  });
};
// End here

function Preparedness() {
  const [valuep1, setValuep1] = useState("");
  const [valuep2, setValuep2] = useState("");
  const [valuep3, setValuep3] = useState("");
  const [valuep4, setValuep4] = useState("");
  const [valuep5, setValuep5] = useState("");
  const [valuep6, setValuep6] = useState("");

  // sending data to db with API

  const inputDataList = {
    inputp1: valuep1,
    inputp2: valuep2,
    inputp3: valuep3,
    inputp4: valuep4,
    inputp5: valuep5,
    inputp6: valuep6,
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave(e) {
    e.preventDefault();
    console.log(inputDataList);
    const form1Data = new FormData();
    form1Data.append("multi", jsonBlob(inputDataList));

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: form1Data,
    };
    fetch("http://localhost:8080/api/v1/multidata", filesFetchMethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Record is Inserted Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
  }
  return (
    <div className="main-container">
      <h1 className="main-heading-style">Institutional preparedness for NEP</h1>
      <div className="eachTable-container">
        <form>
          <p htmlFor="p1">1. Multidisciplinary/ interdisciplinary :</p>
          <textarea
            id="p1"
            rows="6"
            cols="95"
            onChange={(e) => setValuep1(e.target.value)}
            value={valuep1}
            placeholder="Describe in maximum 500 words"
          ></textarea>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <p htmlFor="p2">2. Academic banck of credits (ABC):</p>
          <textarea
            id="p2"
            rows="6"
            cols="95"
            onChange={(e) => setValuep2(e.target.value)}
            value={valuep2}
            placeholder="Describe in maximum 500 words"
          ></textarea>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <p htmlFor="p3">3. Skill development :</p>
          <textarea
            id="p3"
            rows="6"
            cols="95"
            onChange={(e) => setValuep3(e.target.value)}
            value={valuep3}
            placeholder="Describe in maximum 500 words"
          ></textarea>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <p htmlFor="p4">
            4. Appropriate integration of Indian Knowledge system (teaching in
            Indian Language, culture using online course):
          </p>
          <textarea
            id="p4"
            rows="6"
            cols="95"
            onChange={(e) => setValuep4(e.target.value)}
            value={valuep4}
            placeholder="Describe in maximum 500 words"
          ></textarea>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <p htmlFor="p5">5. Focus on Outcome based education (OBE):</p>
          <textarea
            id="p5"
            rows="6"
            cols="95"
            onChange={(e) => setValuep5(e.target.value)}
            value={valuep5}
            placeholder="Describe in maximum 500 words"
          ></textarea>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <p htmlFor="p6">6. Distance education/ online education: </p>
          <textarea
            id="p6"
            rows="6"
            cols="95"
            onChange={(e) => setValuep6(e.target.value)}
            value={valuep6}
            placeholder="Describe in maximum 500 words"
          ></textarea>
        </form>
      </div>
      <form>
        <div className="a2-button-container">
          <button className="a2-button-style" onClick={onClickingSave}>
            Submit
          </button>
        </div>
      </form>
    </div>
  );
}

export default Preparedness;
