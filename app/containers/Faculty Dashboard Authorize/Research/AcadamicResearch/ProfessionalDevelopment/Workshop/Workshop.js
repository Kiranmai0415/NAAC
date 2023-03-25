import React from "react";
import "./Workshop.css";
export default function Workshop() {
  return (
    <div className='workshop-container'>
      <h1 className="workshop-heading-style">Number of workshops/seminars</h1>
      <div className="workshop-eachTable-container">
        <form>
          <table id="basicInfo-t1">
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
              <th>Name of the workshop/ seminar
              </th>
              <td>
                <input
                  type="text"

                />
              </td>
            </tr>
            <tr>
              <th>Number of Participants

              </th>
              <td>
                <input
                  type="text"

                />
              </td>
            </tr>
            <tr>
              <th>Date From - To

              </th>
              <td>
                <input
                  type="text"

                />
              </td>
            </tr>
            <tr>
              <th>Date From - To

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
              <td><input type="file" ></input></td>
            </tr>

          </table>
        </form></div></div>
  );
}
