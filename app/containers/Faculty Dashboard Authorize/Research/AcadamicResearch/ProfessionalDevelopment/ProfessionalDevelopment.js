import React, { useState } from 'react';
import { toast } from "react-toastify";
import "./ProfessionalDevelopment.css";

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

export default function ProfessionalDevelopment() {
  return (
    <div className='noofprofessionaldevelopment-container'>
      <h1 className="noofprofessionaldevelopment-heading-style">Number of professional development / administrative training Programmes
      </h1>
      <div className="noofprofessionaldevelopmenteachTable-container">
        <form>
          <table>
            <tr>
              <th className="BI-table1-headings">Year
                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input
                  type="text"

                />
              </td>
            </tr>
            <tr>
              <th>Dates (from-to) (DD-MM-YYYY)
              </th>
              <td>
                <input
                  type="text"

                />
              </td>
            </tr>
            <tr>
              <th>Title of the professional/ administrative development program organized for the teaching staff/ non-teaching staff</th>
              <td>
                <input
                  type="text"

                />
              </td>
            </tr>
            <tr>
              <th>No. of participants
              </th>
              <td>
                <input
                  type="text"

                />
              </td>
            </tr>

            <tr>
              <th>Upload the Document
              </th>
              <td><input type="file"

              /></td>
            </tr>
          </table>
         
        </form>

      </div>
    </div>
  );
}
