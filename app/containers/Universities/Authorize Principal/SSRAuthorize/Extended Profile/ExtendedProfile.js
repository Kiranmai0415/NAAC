import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import "./ExtendedProfile-style.css";
import { resources } from "../../../../appConstants";
import AuthService from "../../../../Pages/Users/services/auth.service";

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

  
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState("");
  const [principalComments, setPrincipalComments] = useState(null);
  const [isdisabled,setdisabled] = useState(false);
  const [isreject,setreject]= useState(false)


  // get call
  const financialYear="2021-2022";
  useEffect(
    () => fetch('http://localhost:8080/api/v1/getallextendeddata?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType).then(
      (response) => response
        .json()
        .then((data) => {
          setValueep11(data[0].epYeartable11[0] ? data[0].epYeartable11[0].input11y:"");
          setValueep21(data[0].epYeartable11[0] ? data[0].epYeartable11[0].input11v:"");
          setValueep12(data[0].epYeartable11[1] ? data[0].epYeartable11[1].input11y:"");
          setValueep22(data[0].epYeartable11[1] ? data[0].epYeartable11[1].input11v:"");
          setValueep13(data[0].epYeartable11[2] ? data[0].epYeartable11[2].input11y:"");
          setValueep23(data[0].epYeartable11[2] ? data[0].epYeartable11[2].input11v:"");
          setValueep14(data[0].epYeartable11[3] ? data[0].epYeartable11[3].input11y:"");
          setValueep24(data[0].epYeartable11[3] ? data[0].epYeartable11[3].input11v:"");
          setValueep15(data[0].epYeartable11[4] ? data[0].epYeartable11[4].input11y:"");
          setValueep25(data[0].epYeartable11[4] ? data[0].epYeartable11[4].input11v:"");

          setValueep31(data[0].epYeartable21[0] ? data[0].epYeartable21[0].input21y:"");
          setValueep41(data[0].epYeartable21[0] ? data[0].epYeartable21[0].input21v:"");
          setValueep32(data[0].epYeartable21[1] ? data[0].epYeartable21[1].input21y:"");
          setValueep42(data[0].epYeartable21[1] ? data[0].epYeartable21[1].input21v:"");
          setValueep33(data[0].epYeartable21[2] ? data[0].epYeartable21[2].input21y:"");
          setValueep43(data[0].epYeartable21[2] ? data[0].epYeartable21[2].input21v:"");
          setValueep34(data[0].epYeartable21[3] ? data[0].epYeartable21[3].input21y:"");
          setValueep44(data[0].epYeartable21[3] ? data[0].epYeartable21[3].input21v:"");
          setValueep35(data[0].epYeartable21[4] ? data[0].epYeartable21[4].input21y:"");
          setValueep45(data[0].epYeartable21[4] ? data[0].epYeartable21[4].input21v:"");

          setValueep51(data[0].epYeartable22[0] ? data[0].epYeartable22[0].input22y:"");
          setValueep61(data[0].epYeartable22[0] ? data[0].epYeartable22[0].input22v:"");
          setValueep52(data[0].epYeartable22[1] ? data[0].epYeartable22[1].input22y:"");
          setValueep62(data[0].epYeartable22[1] ? data[0].epYeartable22[1].input22v:"");
          setValueep53(data[0].epYeartable22[2] ? data[0].epYeartable22[2].input22y:"");
          setValueep63(data[0].epYeartable22[2] ? data[0].epYeartable22[2].input22v:"");
          setValueep54(data[0].epYeartable22[3] ? data[0].epYeartable22[3].input22y:"");
          setValueep64(data[0].epYeartable22[3] ? data[0].epYeartable22[3].input22v:"");
          setValueep55(data[0].epYeartable22[4] ? data[0].epYeartable22[4].input22y:"");
          setValueep65(data[0].epYeartable22[4] ? data[0].epYeartable22[4].input22v:"");

          setValueep71(data[0].epYeartable23[0] ? data[0].epYeartable23[0].input23y:"");
          setValueep81(data[0].epYeartable23[0] ? data[0].epYeartable23[0].input23v:"");
          setValueep72(data[0].epYeartable23[1] ? data[0].epYeartable23[1].input23y:"");
          setValueep82(data[0].epYeartable23[1] ? data[0].epYeartable23[1].input23v:"");
          setValueep73(data[0].epYeartable23[2] ? data[0].epYeartable23[2].input23y:"");
          setValueep83(data[0].epYeartable23[2] ? data[0].epYeartable23[2].input23v:"");
          setValueep74(data[0].epYeartable23[3] ? data[0].epYeartable23[3].input23y:"");
          setValueep84(data[0].epYeartable23[3] ? data[0].epYeartable23[3].input23v:"");
          setValueep75(data[0].epYeartable23[4] ? data[0].epYeartable23[4].input23y:"");
          setValueep85(data[0].epYeartable23[4] ? data[0].epYeartable23[4].input23v:"");

          setValueep91(data[0].epYeartable24[0] ? data[0].epYeartable24[0].input24y:"");
          setValueep101(data[0].epYeartable24[0] ? data[0].epYeartable24[0].input24v:"");
          setValueep92(data[0].epYeartable24[1] ? data[0].epYeartable24[1].input24y:"");
          setValueep102(data[0].epYeartable24[1] ? data[0].epYeartable24[1].input24v:"");
          setValueep93(data[0].epYeartable24[2] ? data[0].epYeartable24[2].input24y:"");
          setValueep103(data[0].epYeartable24[2] ? data[0].epYeartable24[2].input24v:"");
          setValueep94(data[0].epYeartable24[3] ? data[0].epYeartable24[3].input24y:"");
          setValueep104(data[0].epYeartable24[3] ? data[0].epYeartable24[3].input24v:"");
          setValueep95(data[0].epYeartable24[4] ? data[0].epYeartable24[4].input24y:"");
          setValueep105(data[0].epYeartable24[4] ? data[0].epYeartable24[4].input24v:"");

          setValueep111(data[0].epYeartable31[0] ? data[0].epYeartable31[0].input31y:"");
          setValueep121(data[0].epYeartable31[0] ? data[0].epYeartable31[0].input31v:"");
          setValueep112(data[0].epYeartable31[1] ? data[0].epYeartable31[1].input31y:"");
          setValueep122(data[0].epYeartable31[1] ? data[0].epYeartable31[1].input31v:"");
          setValueep113(data[0].epYeartable31[2] ? data[0].epYeartable31[2].input31y:"");
          setValueep123(data[0].epYeartable31[2] ? data[0].epYeartable31[2].input31v:"");
          setValueep114(data[0].epYeartable31[3] ? data[0].epYeartable31[3].input31y:"");
          setValueep124(data[0].epYeartable31[3] ? data[0].epYeartable31[3].input31v:"");
          setValueep115(data[0].epYeartable31[4] ? data[0].epYeartable31[4].input31y:"");
          setValueep125(data[0].epYeartable31[4] ? data[0].epYeartable31[4].input31v:"");

          setValueep131(data[0].epYeartable32[0] ? data[0].epYeartable32[0].input32y:"");
          setValueep141(data[0].epYeartable32[0] ? data[0].epYeartable32[0].input32v:"");
          setValueep132(data[0].epYeartable32[1] ? data[0].epYeartable32[1].input32y:"");
          setValueep142(data[0].epYeartable32[1] ? data[0].epYeartable32[1].input32v:"");
          setValueep133(data[0].epYeartable32[2] ? data[0].epYeartable32[2].input32y:"");
          setValueep143(data[0].epYeartable32[2] ? data[0].epYeartable32[2].input32v:"");
          setValueep134(data[0].epYeartable32[3] ? data[0].epYeartable32[3].input32y:"");
          setValueep144(data[0].epYeartable32[3] ? data[0].epYeartable32[3].input32v:"");
          setValueep135(data[0].epYeartable32[4] ? data[0].epYeartable32[4].input32y:"");
          setValueep145(data[0].epYeartable32[4] ? data[0].epYeartable32[4].input32v:"");

          setValueep151(data[0].epYeartable33[0] ? data[0].epYeartable33[0].input33y:"");
          setValueep161(data[0].epYeartable33[0] ? data[0].epYeartable33[0].input33v:"");
          setValueep152(data[0].epYeartable33[1] ? data[0].epYeartable33[1].input33y:"");
          setValueep162(data[0].epYeartable33[1] ? data[0].epYeartable33[1].input33v:"");
          setValueep153(data[0].epYeartable33[2] ? data[0].epYeartable33[2].input33y:"");
          setValueep163(data[0].epYeartable33[2] ? data[0].epYeartable33[2].input33v:"");
          setValueep154(data[0].epYeartable33[3] ? data[0].epYeartable33[3].input33y:"");
          setValueep164(data[0].epYeartable33[3] ? data[0].epYeartable33[3].input33v:"");
          setValueep155(data[0].epYeartable33[4] ? data[0].epYeartable33[4].input33y:"");
          setValueep165(data[0].epYeartable33[4] ? data[0].epYeartable33[4].input33v:"");

          setValueep171(data[0].epYeartable41[0] ? data[0].epYeartable41[0].input41y:"");
          setValueep181(data[0].epYeartable41[0] ? data[0].epYeartable41[0].input41v:"");
          setValueep172(data[0].epYeartable41[1] ? data[0].epYeartable41[1].input41y:"");
          setValueep182(data[0].epYeartable41[1] ? data[0].epYeartable41[1].input41v:"");
          setValueep173(data[0].epYeartable41[2] ? data[0].epYeartable41[2].input41y:"");
          setValueep183(data[0].epYeartable41[2] ? data[0].epYeartable41[2].input41v:"");
          setValueep174(data[0].epYeartable41[3] ? data[0].epYeartable41[3].input41y:"");
          setValueep184(data[0].epYeartable41[3] ? data[0].epYeartable41[3].input41v:"");
          setValueep175(data[0].epYeartable41[4] ? data[0].epYeartable41[4].input41y:"");
          setValueep185(data[0].epYeartable41[4] ? data[0].epYeartable41[4].input41v:"");

          setValueep191(data[0].epYeartable42[0] ? data[0].epYeartable42[0].input42y:"");
          setValueep201(data[0].epYeartable42[0] ? data[0].epYeartable42[0].input42v:"");
          setValueep192(data[0].epYeartable42[1] ? data[0].epYeartable42[1].input42y:"");
          setValueep202(data[0].epYeartable42[1] ? data[0].epYeartable42[1].input42v:"");
          setValueep193(data[0].epYeartable42[2] ? data[0].epYeartable42[2].input42y:"");
          setValueep203(data[0].epYeartable42[2] ? data[0].epYeartable42[2].input42v:"");
          setValueep194(data[0].epYeartable42[3] ? data[0].epYeartable42[3].input42y:"");
          setValueep204(data[0].epYeartable42[3] ? data[0].epYeartable42[3].input42v:"");
          setValueep195(data[0].epYeartable42[4] ? data[0].epYeartable42[4].input42y:"");
          setValueep205(data[0].epYeartable42[4] ? data[0].epYeartable42[4].input42v:"");

          setValue43(data[0] ? data[0].eTable43v:"");
          setValue44(data[0] ? data[0].eTable44v:"");

          setValueep211(data[0].epYeartable45[0] ? data[0].epYeartable45[0].input45y:"");
          setValueep221(data[0].epYeartable45[0] ? data[0].epYeartable45[0].input45v:"");
          setValueep212(data[0].epYeartable45[1] ? data[0].epYeartable45[1].input45y:"");
          setValueep222(data[0].epYeartable45[1] ? data[0].epYeartable45[1].input45v:"");
          setValueep213(data[0].epYeartable45[2] ? data[0].epYeartable45[2].input45y:"");
          setValueep223(data[0].epYeartable45[2] ? data[0].epYeartable45[2].input45v:"");
          setValueep214(data[0].epYeartable45[3] ? data[0].epYeartable45[3].input45y:"");
          setValueep224(data[0].epYeartable45[3] ? data[0].epYeartable45[3].input45v:"");
          setValueep215(data[0].epYeartable45[4] ? data[0].epYeartable45[4].input45y:"");
          setValueep225(data[0].epYeartable45[4] ? data[0].epYeartable45[4].input45v:"");
        })
        .catch((error) => {
          console.error("Error:", error);
        })
    ),
    []
  );

  
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  let role = null;
  let email = null;
  // eslint-disable-next-line prefer-destructuring, no-undef
  role = AuthService.getCurrentUser().roles[0];
  // eslint-disable-next-line no-undef
  email = AuthService.getCurrentUser().email;
  const finacialyear = "2021-2022";
  const authorize = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
     },
    assignedTo: email,
    assignedBy: email,
    role:role,
    principalStatus: "A",
    programmerId:"ExtendedProfile"
  };

  const rejectContent = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
     },
    assignedTo: "anamita1996@gmail.com",
    assignedBy: email,
    role:role,
    principalComments: rejectReasonComments,
    principalStatus: "R",
    programmerId:"ExtendedProfile"
  };
  // eslint-disable-next-line no-redeclare
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }
  function getAuthorizeExtendedprofile() {
    console.log("Authorize IIQA");
    const authAPIMethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(authorize),
    };
    fetch(
      resources.APPLICATION_URL
        + "principalAuthorizedEmail",
      authAPIMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record Authorized Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }
  function getRejectExtendedprofile() {
    console.log("Assigned");
    const rejectAPImethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(rejectContent),
    };
    fetch(
      resources.APPLICATION_URL
        + "principalRejectEmail?institutionType=university",
      rejectAPImethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Rejected Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
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
                <input readonly
                  type="text"
                  id="ep11" value={valueep11}
                  onChange={(e) => setValueep11(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep12" value={valueep12}
                  onChange={(e) => setValueep12(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep13" value={valueep13}
                  onChange={(e) => setValueep13(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep14" value={valueep14}
                  onChange={(e) => setValueep14(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep15" value={valueep15}
                  onChange={(e) => setValueep15(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input readonly
                  type="text"
                  id="ep21" value={valueep21}
                  onChange={(e) => setValueep21(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep22" value={valueep22}
                  onChange={(e) => setValueep22(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep23" value={valueep23}
                  onChange={(e) => setValueep23(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep24" value={valueep24}
                  onChange={(e) => setValueep24(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep25" value={valueep25}
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
                <input readonly
                  type="text"
                  id="ep31" value={valueep31}
                  onChange={(e) => setValueep31(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep32" value={valueep32}
                  onChange={(e) => setValueep32(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep33" value={valueep33}
                  onChange={(e) => setValueep33(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep34" value={valueep34}
                  onChange={(e) => setValueep34(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep35" value={valueep35}
                  onChange={(e) => setValueep35(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input readonly
                  type="text"
                  id="ep41" value={valueep41}
                  onChange={(e) => setValueep41(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep42" value={valueep42}
                  onChange={(e) => setValueep42(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep43" value={valueep43}
                  onChange={(e) => setValueep43(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep44" value={valueep44}
                  onChange={(e) => setValueep44(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep45" value={valueep45}
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
              <input readonly
                type="text"
                id="ep51" value={valueep51}
                onChange={(e) => setValueep51(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep52" value={valueep52}
                onChange={(e) => setValueep52(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep53" value={valueep53}
                onChange={(e) => setValueep53(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep54" value={valueep54}
                onChange={(e) => setValueep54(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep55" value={valueep55}
                onChange={(e) => setValueep55(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th style={{ width: "12%" }}>Number</th>
            <td>
              <input readonly
                type="text"
                id="ep61" value={valueep61}
                onChange={(e) => setValueep61(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep62" value={valueep62}
                onChange={(e) => setValueep62(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep63" value={valueep63}
                onChange={(e) => setValueep63(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep64" value={valueep64}
                onChange={(e) => setValueep64(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep65" value={valueep65}
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
              <input readonly
                type="text"
                id="ep71" value={valueep71}
                onChange={(e) => setValueep71(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep72" value={valueep72}
                onChange={(e) => setValueep72(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep73" value={valueep73}
                onChange={(e) => setValueep73(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep74" value={valueep74}
                onChange={(e) => setValueep74(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep75" value={valueep75}
                onChange={(e) => setValueep75(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th style={{ width: "12%" }}>Number</th>
            <td>
              <input readonly
                type="text"
                id="ep81" value={valueep81}
                onChange={(e) => setValueep81(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep82" value={valueep82}
                onChange={(e) => setValueep82(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep83" value={valueep83}
                onChange={(e) => setValueep83(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep84" value={valueep84}
                onChange={(e) => setValueep84(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep85" value={valueep85}
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
              <input readonly
                type="text" value={valueep91}
                id="ep91"
                onChange={(e) => setValueep91(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text" value={valueep92}
                id="ep92"
                onChange={(e) => setValueep92(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep93" value={valueep93}
                onChange={(e) => setValueep93(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep94" value={valueep94}
                onChange={(e) => setValueep94(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep95" value={valueep95}
                onChange={(e) => setValueep95(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <th style={{ width: "12%" }}>Number</th>
            <td>
              <input readonly
                type="text"
                id="ep101" value={valueep101}
                onChange={(e) => setValueep101(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep102" value={valueep102}
                onChange={(e) => setValueep102(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep103" value={valueep103}
                onChange={(e) => setValueep103(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep104" value={valueep104}
                onChange={(e) => setValueep104(e.target.value)}
              />
            </td>
            <td>
              <input readonly
                type="text"
                id="ep105" value={valueep105}
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
                <input readonly
                  type="text"
                  id="ep111" value={valueep111}
                  onChange={(e) => setValueep111(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep112" value={valueep112}
                  onChange={(e) => setValueep112(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep113" value={valueep113}
                  onChange={(e) => setValueep113(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep114" value={valueep114}
                  onChange={(e) => setValueep114(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep115" value={valueep115}
                  onChange={(e) => setValueep115(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input readonly
                  type="text"
                  id="ep121" value={valueep121}
                  onChange={(e) => setValueep121(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep122" value={valueep122}
                  onChange={(e) => setValueep122(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep123" value={valueep123}
                  onChange={(e) => setValueep123(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep124" value={valueep124}
                  onChange={(e) => setValueep124(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep125" value={valueep125}
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
                <input readonly
                  type="text"
                  id="ep131" value={valueep131}
                  onChange={(e) => setValueep131(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep132" value={valueep132}
                  onChange={(e) => setValueep132(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep133" value={valueep133}
                  onChange={(e) => setValueep133(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep134" value={valueep134}
                  onChange={(e) => setValueep134(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep135" value={valueep135}
                  onChange={(e) => setValueep135(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input readonly
                  type="text"
                  id="ep141" value={valueep141}
                  onChange={(e) => setValueep141(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep142" value={valueep142}
                  onChange={(e) => setValueep142(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep143" value={valueep143}
                  onChange={(e) => setValueep143(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep144" value={valueep144}
                  onChange={(e) => setValueep144(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep145" value={valueep145}
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
                <input readonly
                  type="text"
                  id="ep151" value={valueep151}
                  onChange={(e) => setValueep151(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep152" value={valueep152}
                  onChange={(e) => setValueep152(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep153" value={valueep153}
                  onChange={(e) => setValueep153(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep154" value={valueep154}
                  onChange={(e) => setValueep154(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep155" value={valueep155}
                  onChange={(e) => setValueep155(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input readonly
                  type="text"
                  id="ep161" value={valueep161}
                  onChange={(e) => setValueep161(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep162" value={valueep162}
                  onChange={(e) => setValueep162(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep163" value={valueep163}
                  onChange={(e) => setValueep163(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep164" value={valueep164}
                  onChange={(e) => setValueep164(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep165" value={valueep165}
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
                <input readonly
                  type="text"
                  id="ep171" value={valueep171}
                  onChange={(e) => setValueep171(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep172" value={valueep172}
                  onChange={(e) => setValueep172(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep173" value={valueep173}
                  onChange={(e) => setValueep173(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep174" value={valueep174}
                  onChange={(e) => setValueep174(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep175" value={valueep175}
                  onChange={(e) => setValueep175(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input readonly
                  type="text"
                  id="ep181" value={valueep181}
                  onChange={(e) => setValueep181(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep182" value={valueep182}
                  onChange={(e) => setValueep182(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep183" value={valueep183}
                  onChange={(e) => setValueep183(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep184" value={valueep184}
                  onChange={(e) => setValueep184(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep185" value={valueep185}
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
                <input readonly
                  type="text"
                  id="ep191" value={valueep191}
                  onChange={(e) => setValueep191(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep192" value={valueep192}
                  onChange={(e) => setValueep192(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep193" value={valueep193}
                  onChange={(e) => setValueep193(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep194" value={valueep194}
                  onChange={(e) => setValueep194(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep195" value={valueep195}
                  onChange={(e) => setValueep195(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input readonly
                  type="text"
                  id="ep201" value={valueep201}
                  onChange={(e) => setValueep201(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep202" value={valueep202}
                  onChange={(e) => setValueep202(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep203" value={valueep203}
                  onChange={(e) => setValueep203(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep204" value={valueep204}
                  onChange={(e) => setValueep204(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep205" value={valueep205}
                  onChange={(e) => setValueep205(e.target.value)}
                />
              </td>
            </tr>
          </table>
          <label htmlFor="43" style={{ margin: "1%" }}>
            4.3. Total number of classrooms and seminar halls:
          </label>
          <input readonly
            type="text"
            id="43"
            onChange={(e) => setValue43(e.target.value)}
            style={{ width: "30%" }}
            className="input-43"
            value={value43}
          />
          <br />
          <label htmlFor="44" style={{ margin: "1%" }}>
            4.4. Total number of computers in the campus for academic purpose:
          </label>
          <input readonly
            type="text"
            id="44"
            onChange={(e) => setValue44(e.target.value)}
            style={{ width: "30%" }}
            className="input-43"
            value={value44}
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
                <input readonly
                  type="text"
                  id="ep211" value={valueep211}
                  onChange={(e) => setValueep211(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep212" value={valueep212}
                  onChange={(e) => setValueep212(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep213" value={valueep213}
                  onChange={(e) => setValueep213(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep214" value={valueep214}
                  onChange={(e) => setValueep214(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep215" value={valueep215}
                  onChange={(e) => setValueep215(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "12%" }}>Number</th>
              <td>
                <input readonly
                  type="text"
                  id="ep221" value={valueep221}
                  onChange={(e) => setValueep221(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep222" value={valueep222}
                  onChange={(e) => setValueep222(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep223" value={valueep223}
                  onChange={(e) => setValueep223(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep224" value={valueep224}
                  onChange={(e) => setValueep224(e.target.value)}
                />
              </td>
              <td>
                <input readonly
                  type="text"
                  id="ep225" value={valueep225}
                  onChange={(e) => setValueep225(e.target.value)}
                />
              </td>
            </tr>
          </table>
        </form>
      </div>
     
      <div>Principal Comments : {principalComments}</div>
      <div className="c31x-button-container">
        <button
        type="button"
        disabled = {isdisabled}
          onClick={(e) => {
            getAuthorizeExtendedprofile(e);
            setdisabled(true);
            setreject(true);
          }}
          className="c31x-button-style"
          style={{ color: "white", backgroundColor: "green" }}
        >
          Authorize
        </button>

        <button
        type="button"
        disabled={isreject}
          onClick={(e) => {
            setRejectButtonClickStatus(true);
            e.preventDefault();
            setdisabled(true);
            setreject(true);
          }}
          className="c31x-button-style"
          style={{ color: "white", backgroundColor: "red" }}
        >
          Reject
        </button>
      </div>
      {rejectButtonClickStatus ? (
        <div style={{ marginLeft: "13%" }}>
          <h1>Reason for Rejection</h1>
          <textarea
            cols={110}
            rows={6}
            onChange={(e) => setRejectReasonComments(e.target.value)}
          ></textarea>
          <div>
            <button
              onClick={() => {
                setRejectButtonClickStatus(false);
                setdisabled(true);
                setreject(true);}}
              style={{
                color: "black",
                backgroundColor: "white",
                borderRadius: "4px",
                marginRight: "3%",
                boxShadow:
                  "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
              }}
            >
              Cancel
            </button>
            <button
              onClick={(e) => {
                setRejectButtonClickStatus(false);
                getRejectExtendedprofile(e);
                setdisabled(true);
                setreject(true);
              }}
              style={{
                color: "black",
                backgroundColor: "white",
                borderRadius: "4px",
                boxShadow:
                  "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
              }}
            >
              Confirm Reject
            </button>
          </div>
        </div>
      ) : null}
    </div>
  );
}
export default ExtendedProfile;
<></>