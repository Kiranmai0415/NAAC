import React from 'react';
import "./Scholar.css";

export default function Scholar() {
  return (
    <div className='main-container'>
      <h1 className="main-heading-style">SEED MONEY</h1>
      <div className="eachTable-container">
        <form>
          <table id="basicInfo-t1">
            <tr>
              <th className="BI-table1-headings">Name of the teacher provided with seed money

                <span style={{ color: "red" }}>*</span>
              </th>
              <td>
                <input   readOnly
                  type="text"

                />
              </td>
            </tr>
            <tr>
              <th>The amount of seed money (INR in Lakhs)
              </th>
              <td>
                <input   readOnly
                  type="text"

                />
              </td>
            </tr>
            <tr>
              <th>Year of receiving?
              </th>
              <td>
                <input   readOnly
                  type="text"

                />
              </td>
            </tr>
            <tr>
              <th>Link to the policy document for Sanction of seed money / grants for research from the institution?
              </th>
              <td>
                <input   readOnly
                  type="text"

                />
              </td>
            </tr>
            <tr>
              <th>Upload the Document
              </th>
              <td>
                <input   readOnly
                  type="File"

                />
              </td>
            </tr>

          </table>
        </form></div></div>
  );
}
