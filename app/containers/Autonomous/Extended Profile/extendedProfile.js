import React, { useState } from "react";
import { toast } from "react-toastify";
import "./extendedProfile.css";

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

function ExtendedProfile() {
  const [valueep11, setValueep11] = useState();
  const [valueep12, setValueep12] = useState();
  const [valueep13, setValueep13] = useState();
  const [valueep14, setValueep14] = useState();
  const [valueep15, setValueep15] = useState();

  const [valueep21, setValueep21] = useState();
  const [valueep22, setValueep22] = useState();
  const [valueep23, setValueep23] = useState();
  const [valueep24, setValueep24] = useState();
  const [valueep25, setValueep25] = useState();

  const [valueep31, setValueep31] = useState();
  const [valueep32, setValueep32] = useState();
  const [valueep33, setValueep33] = useState();
  const [valueep34, setValueep34] = useState();
  const [valueep35, setValueep35] = useState();

  const [valueep41, setValueep41] = useState();
  const [valueep42, setValueep42] = useState();
  const [valueep43, setValueep43] = useState();
  const [valueep44, setValueep44] = useState();
  const [valueep45, setValueep45] = useState();

  const [valueep51, setValueep51] = useState();
  const [valueep52, setValueep52] = useState();
  const [valueep53, setValueep53] = useState();
  const [valueep54, setValueep54] = useState();
  const [valueep55, setValueep55] = useState();

  const [valueep61, setValueep61] = useState();
  const [valueep62, setValueep62] = useState();
  const [valueep63, setValueep63] = useState();
  const [valueep64, setValueep64] = useState();
  const [valueep65, setValueep65] = useState();

  const [valueep71, setValueep71] = useState();
  const [valueep72, setValueep72] = useState();
  const [valueep73, setValueep73] = useState();
  const [valueep74, setValueep74] = useState();
  const [valueep75, setValueep75] = useState();

  const [valueep81, setValueep81] = useState();
  const [valueep82, setValueep82] = useState();
  const [valueep83, setValueep83] = useState();
  const [valueep84, setValueep84] = useState();
  const [valueep85, setValueep85] = useState();

  const [valueep91, setValueep91] = useState();
  const [valueep92, setValueep92] = useState();
  const [valueep93, setValueep93] = useState();
  const [valueep94, setValueep94] = useState();
  const [valueep95, setValueep95] = useState();

  const [valueep101, setValueep101] = useState();
  const [valueep102, setValueep102] = useState();
  const [valueep103, setValueep103] = useState();
  const [valueep104, setValueep104] = useState();
  const [valueep105, setValueep105] = useState();

  const [valueep111, setValueep111] = useState();
  const [valueep112, setValueep112] = useState();
  const [valueep113, setValueep113] = useState();
  const [valueep114, setValueep114] = useState();
  const [valueep115, setValueep115] = useState();

  const [valueep121, setValueep121] = useState();
  const [valueep122, setValueep122] = useState();
  const [valueep123, setValueep123] = useState();
  const [valueep124, setValueep124] = useState();
  const [valueep125, setValueep125] = useState();

  const [valueep131, setValueep131] = useState();
  const [valueep132, setValueep132] = useState();
  const [valueep133, setValueep133] = useState();
  const [valueep134, setValueep134] = useState();
  const [valueep135, setValueep135] = useState();

  const [valueep141, setValueep141] = useState();
  const [valueep142, setValueep142] = useState();
  const [valueep143, setValueep143] = useState();
  const [valueep144, setValueep144] = useState();
  const [valueep145, setValueep145] = useState();

  const [valueep151, setValueep151] = useState();
  const [valueep152, setValueep152] = useState();
  const [valueep153, setValueep153] = useState();
  const [valueep154, setValueep154] = useState();
  const [valueep155, setValueep155] = useState();

  const [valueep161, setValueep161] = useState();
  const [valueep162, setValueep162] = useState();
  const [valueep163, setValueep163] = useState();
  const [valueep164, setValueep164] = useState();
  const [valueep165, setValueep165] = useState();

  const [valueep171, setValueep171] = useState();
  const [valueep172, setValueep172] = useState();
  const [valueep173, setValueep173] = useState();
  const [valueep174, setValueep174] = useState();
  const [valueep175, setValueep175] = useState();

  const [valueep181, setValueep181] = useState();
  const [valueep182, setValueep182] = useState();
  const [valueep183, setValueep183] = useState();
  const [valueep184, setValueep184] = useState();
  const [valueep185, setValueep185] = useState();

  const [valueep191, setValueep191] = useState();
  const [valueep192, setValueep192] = useState();
  const [valueep193, setValueep193] = useState();
  const [valueep194, setValueep194] = useState();
  const [valueep195, setValueep195] = useState();

  const [valueep201, setValueep201] = useState();
  const [valueep202, setValueep202] = useState();
  const [valueep203, setValueep203] = useState();
  const [valueep204, setValueep204] = useState();
  const [valueep205, setValueep205] = useState();

  const [valueep211, setValueep211] = useState();
  const [valueep212, setValueep212] = useState();
  const [valueep213, setValueep213] = useState();
  const [valueep214, setValueep214] = useState();
  const [valueep215, setValueep215] = useState();

  const [valueep221, setValueep221] = useState();
  const [valueep222, setValueep222] = useState();
  const [valueep223, setValueep223] = useState();
  const [valueep224, setValueep224] = useState();
  const [valueep225, setValueep225] = useState();

  const [value43, setValue43] = useState();
  const [value44, setValue44] = useState();

  // sending data to db with API

  const inputDataList = {
    criteriaId: {
      collegeId: "1",
      financialYear: "2021-22",
      typeofInstitution: "autonomous",
    },
    eTable43v: value43,
    eTable44v: value44,
    eTable12v: "33",
    epYeartable11: [
      { input11y: valueep11, input11v: valueep21 },
      { input11y: valueep12, input11v: valueep22 },
      { input11y: valueep13, input11v: valueep23 },
      { input11y: valueep14, input11v: valueep24 },
      { input11y: valueep15, input11v: valueep25 },
    ],
    epYeartable21: [
      { input21y: valueep31, input21v: valueep41 },
      { input21y: valueep32, input21v: valueep42 },
      { input21y: valueep33, input21v: valueep43 },
      { input21y: valueep34, input21v: valueep44 },
      { input21y: valueep35, input21v: valueep45 },
    ],
    epYeartable22: [
      { input22y: valueep51, input22v: valueep61 },
      { input22y: valueep52, input22v: valueep62 },
      { input22y: valueep53, input22v: valueep63 },
      { input22y: valueep54, input22v: valueep64 },
      { input22y: valueep55, input22v: valueep65 },
    ],
    epYeartable23: [
      { input23y: valueep71, input23v: valueep81 },
      { input23y: valueep72, input23v: valueep82 },
      { input23y: valueep73, input23v: valueep83 },
      { input23y: valueep74, input23v: valueep84 },
      { input23y: valueep75, input23v: valueep85 },
    ],
    epYeartable24: [
      { input24y: valueep91, input24v: valueep101 },
      { input24y: valueep92, input24v: valueep102 },
      { input24y: valueep93, input24v: valueep103 },
      { input24y: valueep94, input24v: valueep104 },
      { input24y: valueep95, input24v: valueep105 },
    ],
    epYeartable31: [
      { input31y: valueep111, input31v: valueep121 },
      { input31y: valueep112, input31v: valueep122 },
      { input31y: valueep113, input31v: valueep123 },
      { input31y: valueep114, input31v: valueep124 },
      { input31y: valueep115, input31v: valueep125 },
    ],
    epYeartable32: [
      { input32y: valueep131, input32v: valueep141 },
      { input32y: valueep132, input32v: valueep142 },
      { input32y: valueep133, input32v: valueep143 },
      { input32y: valueep134, input32v: valueep144 },
      { input32y: valueep135, input32v: valueep145 },
    ],
    epYeartable33: [
      { input33y: valueep151, input33v: valueep161 },
      { input33y: valueep152, input33v: valueep162 },
      { input33y: valueep153, input33v: valueep163 },
      { input33y: valueep154, input33v: valueep164 },
      { input33y: valueep155, input33v: valueep165 },
    ],
    epYeartable41: [
      { input41y: valueep171, input41v: valueep181 },
      { input41y: valueep172, input41v: valueep182 },
      { input41y: valueep173, input41v: valueep183 },
      { input41y: valueep174, input41v: valueep184 },
      { input41y: valueep175, input41v: valueep185 },
    ],
    epYeartable42: [
      { input42y: valueep191, input42v: valueep201 },
      { input42y: valueep192, input42v: valueep202 },
      { input42y: valueep193, input42v: valueep203 },
      { input42y: valueep194, input42v: valueep204 },
      { input42y: valueep195, input42v: valueep205 },
    ],
    epYeartable45: [
      { input45y: valueep211, input45v: valueep221 },
      { input45y: valueep212, input45v: valueep222 },
      { input45y: valueep213, input45v: valueep223 },
      { input45y: valueep214, input45v: valueep224 },
      { input45y: valueep215, input45v: valueep225 },
    ],
  };
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    const extendedData = new FormData();
    console.log(JSON.stringify(inputDataList));
    extendedData.append("extendedProfile", jsonBlob(inputDataList));

    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: extendedData,
    };
    fetch("http://localhost:8080/api/v1/extendeddata", filesFetchMethod).then(
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
      <h1 className="main-heading-style">
        Extended Profile of the Autonomous College
      </h1>
      <div className="eachTable-container">
        <form>
          <label htmlFor="extended-profile">1. Programme:</label>
          <p className="para">
            1.1. Number of programmes offered year wise for last five years?{" "}
          </p>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="text"
                  id="ep11"
                  onChange={(e) => setValueep11(e.target.value)}
                />
    
              </td>
              <td>
                <input
                  type="text"
                  id="ep12"
                  onChange={(e) => setValueep12(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep13"
                  onChange={(e) => setValueep13(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep14"
                  onChange={(e) => setValueep14(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep15"
                  onChange={(e) => setValueep15(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="text"
                  id="ep21"
                  onChange={(e) => setValueep21(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep22"
                  onChange={(e) => setValueep22(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep23"
                  onChange={(e) => setValueep23(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep24"
                  onChange={(e) => setValueep24(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep25"
                  onChange={(e) => setValueep25(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="extended-profile">2. Student:</label>
          <p className="para">
            2.1. Number of students year wise during last five years
          </p>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="text"
                  id="ep31"
                  onChange={(e) => setValueep31(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep32"
                  onChange={(e) => setValueep32(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep33"
                  onChange={(e) => setValueep33(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep34"
                  onChange={(e) => setValueep34(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep35"
                  onChange={(e) => setValueep35(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="text"
                  id="ep41"
                  onChange={(e) => setValueep41(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep42"
                  onChange={(e) => setValueep42(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep43"
                  onChange={(e) => setValueep43(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep44"
                  onChange={(e) => setValueep44(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep45"
                  onChange={(e) => setValueep45(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
        <p className="para">
          2.2. Number of outgoing/ final year students year wise during last
          five years
        </p>
        <table>
          <tr>
            <th style={{ width: "12%" }}>Year</th>
            <td>
              <input
                type="text"
                id="ep51"
                onChange={(e) => setValueep51(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep52"
                onChange={(e) => setValueep52(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep53"
                onChange={(e) => setValueep53(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep54"
                onChange={(e) => setValueep54(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep55"
                onChange={(e) => setValueep55(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th style={{ width: "12%" }}>Number</th>
            <td>
              <input
                type="text"
                id="ep61"
                onChange={(e) => setValueep61(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep62"
                onChange={(e) => setValueep62(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep63"
                onChange={(e) => setValueep63(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep64"
                onChange={(e) => setValueep64(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep65"
                onChange={(e) => setValueep65(e.target.value)}
              />
            </td>
          </tr>
        </table>

        <p className="para">
          2.3. Number of students appeared in the examination conducted by the
          Institution, year wise during the last five years
        </p>
        <table>
          <tr>
            <th style={{ width: "12%" }}>Year</th>
            <td>
              <input
                type="text"
                id="ep71"
                onChange={(e) => setValueep71(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep72"
                onChange={(e) => setValueep72(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep73"
                onChange={(e) => setValueep73(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep74"
                onChange={(e) => setValueep74(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep75"
                onChange={(e) => setValueep75(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th style={{ width: "12%" }}>Number</th>
            <td>
              <input
                type="text"
                id="ep81"
                onChange={(e) => setValueep81(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep82"
                onChange={(e) => setValueep82(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep83"
                onChange={(e) => setValueep83(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep84"
                onChange={(e) => setValueep84(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep85"
                onChange={(e) => setValueep85(e.target.value)}
              />
            </td>
          </tr>
        </table>
        <p className="para">
          2.4. Number of revaluation applications year wise during last five
          years
        </p>
        <table>
          <tr>
            <th style={{ width: "12%" }}>Year</th>
            <td>
              <input
                type="text"
                id="ep91"
                onChange={(e) => setValueep91(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep92"
                onChange={(e) => setValueep92(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep93"
                onChange={(e) => setValueep93(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep94"
                onChange={(e) => setValueep94(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep95"
                onChange={(e) => setValueep95(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th style={{ width: "12%" }}>Number</th>
            <td>
              <input
                type="text"
                id="ep101"
                onChange={(e) => setValueep101(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep102"
                onChange={(e) => setValueep102(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep103"
                onChange={(e) => setValueep103(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep104"
                onChange={(e) => setValueep104(e.target.value)}
              />
            </td>
            <td>
              <input
                type="text"
                id="ep105"
                onChange={(e) => setValueep105(e.target.value)}
              />
            </td>
          </tr>
        </table>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="extended-profile">3. Academic</label>
          <p className="para">
            3.1. Number of courses in all programs year wise during last five
            years{" "}
          </p>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="text"
                  id="ep111"
                  onChange={(e) => setValueep111(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep112"
                  onChange={(e) => setValueep112(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep113"
                  onChange={(e) => setValueep113(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep114"
                  onChange={(e) => setValueep114(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep115"
                  onChange={(e) => setValueep115(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="text"
                  id="ep121"
                  onChange={(e) => setValueep121(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep122"
                  onChange={(e) => setValueep122(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep123"
                  onChange={(e) => setValueep123(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep124"
                  onChange={(e) => setValueep124(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep125"
                  onChange={(e) => setValueep125(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <p className="para">
            3.2. Number of fulltime teachers year wise during the last five
            years{" "}
          </p>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="text"
                  id="ep131"
                  onChange={(e) => setValueep131(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep132"
                  onChange={(e) => setValueep132(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep133"
                  onChange={(e) => setValueep133(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep134"
                  onChange={(e) => setValueep134(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep135" value={valueep135}
                  onChange={(e) => setValueep135(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="text"
                  id="ep141"
                  onChange={(e) => setValueep141(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep142"
                  onChange={(e) => setValueep142(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep143"
                  onChange={(e) => setValueep143(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep144"
                  onChange={(e) => setValueep144(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep145"
                  onChange={(e) => setValueep145(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <p className="para">
            3.3. Number of sanctioned posts year wise during last five years{" "}
          </p>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="text"
                  id="ep151"
                  onChange={(e) => setValueep151(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep152"
                  onChange={(e) => setValueep152(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep153"
                  onChange={(e) => setValueep153(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep154"
                  onChange={(e) => setValueep154(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep155"
                  onChange={(e) => setValueep155(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="text"
                  id="ep161"
                  onChange={(e) => setValueep161(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep162"
                  onChange={(e) => setValueep162(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep163"
                  onChange={(e) => setValueep163(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep164"
                  onChange={(e) => setValueep164(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep165"
                  onChange={(e) => setValueep165(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="eachTable-container">
        <form>
          <label htmlFor="extended-profile">4. Institution:</label>
          <p className="para">
            4.1. Number of eligible applications received for admissions to all
            the programs year wise during last five years{" "}
          </p>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="text"
                  id="ep171"
                  onChange={(e) => setValueep171(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep172"
                  onChange={(e) => setValueep172(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep173"
                  onChange={(e) => setValueep173(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep174"
                  onChange={(e) => setValueep174(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep175"
                  onChange={(e) => setValueep175(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="text"
                  id="ep181"
                  onChange={(e) => setValueep181(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep182"
                  onChange={(e) => setValueep182(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep183"
                  onChange={(e) => setValueep183(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep184"
                  onChange={(e) => setValueep184(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep185"
                  onChange={(e) => setValueep185(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <p className="para">
            4.2. Number of seats earmarked for reserved category as per
            GOI/State Govt rule year wise during last five years{" "}
          </p>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="text"
                  id="ep191"
                  onChange={(e) => setValueep191(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep192"
                  onChange={(e) => setValueep192(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep193"
                  onChange={(e) => setValueep193(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep194"
                  onChange={(e) => setValueep194(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep195"
                  onChange={(e) => setValueep195(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="text"
                  id="ep201"
                  onChange={(e) => setValueep201(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep202"
                  onChange={(e) => setValueep202(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep203"
                  onChange={(e) => setValueep203(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep204"
                  onChange={(e) => setValueep204(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep205"
                  onChange={(e) => setValueep205(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <label htmlFor="43" style={{ margin: "1%" }}>
            4.3. Total number of classrooms and seminar halls:
          </label>
          <input
            type="text"
            id="43"
            onChange={(e) => setValue43(e.target.value)}
            style={{ width: "30%" }}
            className="input-43"
          />
          <br />
          <label htmlFor="44" style={{ margin: "1%" }}>
            4.4. Total number of computers in the campus for academic purpose:
          </label>
          <input
            type="text"
            id="44"
            onChange={(e) => setValue44(e.target.value)}
            style={{ width: "30%" }}
            className="input-43"
          />
          <br />
          <label style={{ margin: "1%", paddingTop: "10px" }}>
            4.5. Total Expenditure excluding salary year wise during last five
            years (INR in Lakhs)
          </label>
          <table>
            <tr>
              <th style={{ width: "12%" }}>Year</th>
              <td>
                <input
                  type="text"
                  id="ep211"
                  onChange={(e) => setValueep211(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep212"
                  onChange={(e) => setValueep212(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep213"
                  onChange={(e) => setValueep213(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep214"
                  onChange={(e) => setValueep214(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep215"
                  onChange={(e) => setValueep215(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input
                  type="text"
                  id="ep221"
                  onChange={(e) => setValueep221(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep222"
                  onChange={(e) => setValueep222(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep223"
                  onChange={(e) => setValueep223(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep224"
                  onChange={(e) => setValueep224(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  id="ep225"
                  onChange={(e) => setValueep225(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
      <div className="c11x-button-container">
        <button onClick={onClickingSave} className="c11x-button-style">
          Save
        </button>
       
      </div>
    </div>
  );
}
export default ExtendedProfile;
