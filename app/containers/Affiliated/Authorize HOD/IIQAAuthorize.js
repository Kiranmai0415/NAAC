import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import "./IIQA-style.css";

import { resources } from "../../appConstants";
import AuthService from "../../Pages/Users/services/auth.service";

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

function IIQAAuthorize() {
  const [iiqaDate, setIiqaDate] = useState();
  const [iiqaAisheId, setIiqaAisheId] = useState();
  const [iiqaTrackId, setIiqaTrackId] = useState();

  const [iiqa1t1, setIiqa1t1] = useState();
  const [iiqa1t2, setIiqa1t2] = useState();
  const [iiqa1t3, setIiqa1t3] = useState();
  const [iiqa1t4, setIiqa1t4] = useState();
  const [iiqa1t5, setIiqa1t5] = useState();
  const [iiqa1t6, setIiqa1t6] = useState();

  const [iiqa2t1, setIiqa2t1] = useState();

  const [iiqa3t1, setIiqa3t1] = useState();

  const [iiqa4t1, setIiqa4t1] = useState();
  const [iiqa4t2, setIiqa4t2] = useState();

  const [iiqa5t1, setIiqa5t1] = useState();

  const [iiqa6t1, setIiqa6t1] = useState();
  const [iiqa6t2, setIiqa6t2] = useState();
  const [iiqa6t3, setIiqa6t3] = useState();
  const [iiqa6t4, setIiqa6t4] = useState("");
  const [iiqa6t5, setIiqa6t5] = useState();
  const [iiqa6t6, setIiqa6t6] = useState();
  const [iiqa6t7, setIiqa6t7] = useState();
  const [iiqa6t8, setIiqa6t8] = useState();
  const [iiqa6t9, setIiqa6t9] = useState();
  const [iiqa6t10, setIiqa6t10] = useState();

  const [iiqa7t1, setIiqa7t1] = useState();
  const [iiqa7t2, setIiqa7t2] = useState();
  const [iiqa7t3, setIiqa7t3] = useState();
  const [iiqa7t4, setIiqa7t4] = useState();
  const [iiqa7t5, setIiqa7t5] = useState();
  const [iiqa7t6, setIiqa7t6] = useState();
  const [iiqa7t7, setIiqa7t7] = useState();
  const [iiqa7t8, setIiqa7t8] = useState();
  const [iiqa7t9, setIiqa7t9] = useState();
  const [iiqa7t10, setIiqa7t10] = useState();

  const [iiqa8t1, setIiqa8t1] = useState();

  const [iiqa9t1, setIiqa9t1] = useState();

  const [iiqa10t1, setIiqa10t1] = useState();

  const [iiqa11t1, setIiqa11t1] = useState();

  const [iiqa12t1, setIiqa12t1] = useState();
  const [iiqa12t2, setIiqa12t2] = useState();
  const [iiqa12t3, setIiqa12t3] = useState();

  const [iiqa13t1, setIiqa13t1] = useState();

  const [iiqa14t1, setIiqa14t1] = useState();

  const [iiqa15t1, setIiqa15t1] = useState();

  const [iiqa16t1, setIiqa16t1] = useState();

  const [iiqa17t1, setIiqa17t1] = useState();

  const [iiqa18t1, setIiqa18t1] = useState();
  const [iiqa18t2, setIiqa18t2] = useState();
  const [iiqa18t3, setIiqa18t3] = useState();

  const [iiqa19t1, setIiqa19t1] = useState();

  const [iiqa20t1, setIiqa20t1] = useState();
  const [iiqa20t2, setIiqa20t2] = useState();
  const [iiqa20t3, setIiqa20t3] = useState();
  const [iiqa20t4, setIiqa20t4] = useState();
  const [iiqa20t5, setIiqa20t5] = useState();
  const [iiqa20t6, setIiqa20t6] = useState();
  const [iiqa20t7, setIiqa20t7] = useState();
  const [iiqa20t8, setIiqa20t8] = useState();
  const [iiqa20t9, setIiqa20t9] = useState();
  const [iiqa20t10, setIiqa20t10] = useState();
  const [iiqa20t11, setIiqa20t11] = useState();
  const [iiqa20t12, setIiqa20t12] = useState();

  const [iiqa21t1, setIiqa21t1] = useState();
  const [iiqa21t2, setIiqa21t2] = useState();
  const [iiqa21t3, setIiqa21t3] = useState();
  const [iiqa21t4, setIiqa21t4] = useState();
  const [iiqa21t5, setIiqa21t5] = useState();

  const [iiqa21t6, setIiqa21t6] = useState();
  const [iiqa21t7, setIiqa21t7] = useState();
  const [iiqa21t8, setIiqa21t8] = useState();
  const [iiqa21t9, setIiqa21t9] = useState();
  const [iiqa21t10, setIiqa21t10] = useState();

  const [iiqa21t11, setIiqa21t11] = useState();
  const [iiqa21t12, setIiqa21t12] = useState();
  const [iiqa21t13, setIiqa21t13] = useState();
  const [iiqa21t14, setIiqa21t14] = useState();
  const [iiqa21t15, setIiqa21t15] = useState();

  const [iiqa21t16, setIiqa21t16] = useState();
  const [iiqa21t17, setIiqa21t17] = useState();
  const [iiqa21t18, setIiqa21t18] = useState();
  const [iiqa21t19, setIiqa21t19] = useState();
  const [iiqa21t20, setIiqa21t20] = useState();

  const [iiqa21t21, setIiqa21t21] = useState();
  const [iiqa21t22, setIiqa21t22] = useState();
  const [iiqa21t23, setIiqa21t23] = useState();
  const [iiqa21t24, setIiqa21t24] = useState();
  const [iiqa21t25, setIiqa21t25] = useState();

  const [iiqa21t26, setIiqa21t26] = useState();
  const [iiqa21t27, setIiqa21t27] = useState();
  const [iiqa21t28, setIiqa21t28] = useState();
  const [iiqa21t29, setIiqa21t29] = useState();
  const [iiqa21t30, setIiqa21t30] = useState();

  const [iiqa21t31, setIiqa21t31] = useState();
  const [iiqa21t32, setIiqa21t32] = useState();
  const [iiqa21t33, setIiqa21t33] = useState();
  const [iiqa21t34, setIiqa21t34] = useState();
  const [iiqa21t35, setIiqa21t35] = useState();

  const [iiqa21t36, setIiqa21t36] = useState();
  const [iiqa21t37, setIiqa21t37] = useState();
  const [iiqa21t38, setIiqa21t38] = useState();
  const [iiqa21t39, setIiqa21t39] = useState();
  const [iiqa21t40, setIiqa21t40] = useState();

  const [iiqa21t51, setIiqa21t51] = useState();
  const [iiqa21t52, setIiqa21t52] = useState();
  const [iiqa21t53, setIiqa21t53] = useState();
  const [iiqa21t54, setIiqa21t54] = useState();
  const [iiqa21t55, setIiqa21t55] = useState();

  const [iiqa21t56, setIiqa21t56] = useState();
  const [iiqa21t57, setIiqa21t57] = useState();
  const [iiqa21t58, setIiqa21t58] = useState();
  const [iiqa21t59, setIiqa21t59] = useState();
  const [iiqa21t60, setIiqa21t60] = useState();

  const [iiqa21t61, setIiqa21t61] = useState();
  const [iiqa21t62, setIiqa21t62] = useState();
  const [iiqa21t63, setIiqa21t63] = useState();
  const [iiqa21t64, setIiqa21t64] = useState();
  const [iiqa21t65, setIiqa21t65] = useState();

  const [iiqa21t66, setIiqa21t66] = useState();
  const [iiqa21t67, setIiqa21t67] = useState();
  const [iiqa21t68, setIiqa21t68] = useState();
  const [iiqa21t69, setIiqa21t69] = useState();
  const [iiqa21t70, setIiqa21t70] = useState();

  const [iiqa22t1, setIiqa22t1] = useState();
  const [iiqa22t2, setIiqa22t2] = useState();
  const [iiqa22t3, setIiqa22t3] = useState();
  const [iiqa22t4, setIiqa22t4] = useState();
  const [iiqa22t5, setIiqa22t5] = useState();
  const [iiqa22t6, setIiqa22t6] = useState();
  const [iiqa22t7, setIiqa22t7] = useState();
  const [iiqa22t8, setIiqa22t8] = useState();

  const [iiqa23t1, setIiqa23t1] = useState();
  const [iiqa23t2, setIiqa23t2] = useState();
  const [iiqa23t3, setIiqa23t3] = useState();
  const [iiqa23t4, setIiqa23t4] = useState();

  const [iiqa24t1, setIiqa24t1] = useState();
  const [iiqa24t2, setIiqa24t2] = useState();
  const [iiqa24t3, setIiqa24t3] = useState();
  const [iiqa24t4, setIiqa24t4] = useState();

  const [iiqa25t1, setIiqa25t1] = useState();

  const [iiqa26t1, setIiqa26t1] = useState();
  const [iiqa26t2, setIiqa26t2] = useState();
  const [iiqa26f1, setIiqa26f1] = useState();
  const [pathValueiiqa26f1, setPathValueiiqa26f1] = useState("");

  const [iiqa27t1, setIiqa27t1] = useState();
  const [iiqa27f1, setIiqa27f1] = useState();
  const [pathValueiiqa27f1, setPathValueiiqa27f1] = useState("");

  const [iiqa28t1, setIiqa28t1] = useState();
  const [iiqa28f1, setIiqa28f1] = useState();
  const [pathValueiiqa28f1, setPathValueiiqa28f1] = useState("");

  const [iiqa29t1, setIiqa29t1] = useState();
  const [iiqa29f1, setIiqa29f1] = useState();
  const [pathValueiiqa29f1, setPathValueiiqa29f1] = useState("");

  const [iiqa30t1, setIiqa30t1] = useState();
  const [iiqa30f1, setIiqa30f1] = useState();
  const [pathValueiiqa30f1, setPathValueiiqa30f1] = useState("");

  const [iiqa31f1, setIiqa31f1] = useState();
  const [pathValueiiqa31f1, setPathValueiiqa31f1] = useState("");

  const [iiqa32t1, setIiqa32t1] = useState();
  const [principalComments, setPrincipalComments] = useState(null);
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState("");


  console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
  let instituteType = AuthService.getCurrentUser().instituteType;
  console.log("instituteType=======>" + instituteType);
  const collegeId = AuthService.getCurrentUser().collegeId;
  console.log("eamcetCode==========>" + collegeId);
  const d = new Date();
  let currYear = d.getFullYear();
  console.log("var ==>" + currYear);
  let fYear = parseInt(currYear) - 1 + "-" + currYear;
  console.log("current year==" + fYear);

  //get data
  const financialYear = "2021-2022";
  useEffect(
    () =>
      fetch(
        resources.APPLICATION_URL+'getallqiafiles?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
      ).then((response) =>
        response
          .json()
          .then((data) => {
            console.log(JSON.stringify(data));
            // console.log("data[0].qiaIndicator1[0].inputiiqa22t1 =>" + data[0].qiaIndicator1[0]);
            setIiqaDate(data[0].inputIiqaDate?data[0].inputIiqaDate:"");
            setIiqaAisheId(data[0].inputIiqaAisheId?data[0].inputIiqaAisheId:"");
            setIiqaTrackId(data[0].inputIiqaTrackId?data[0].inputIiqaTrackId:"");
           
            // qiaIndicator1
            // if (data[0].qiaIndicator1[0].inputiiqa22t1 != null) {
            //   setIiqa22t1(data[0].qiaIndicator1[0].inputiiqa22t1);
            // }
            setIiqa22t1(data[0].qiaIndicator1[0]?data[0].qiaIndicator1[0].inputiiqa22t1:"");
            setIiqa22t2(data[0].qiaIndicator1[0]?data[0].qiaIndicator1[0].inputiiqa22t2:"");
            setIiqa22t3(data[0].qiaIndicator1[0]?data[0].qiaIndicator1[0].inputiiqa22t3:"");
            setIiqa22t4(data[0].qiaIndicator1[0]?data[0].qiaIndicator1[0].inputiiqa22t4:"");
            // console.log(data[0].qiaIndicator1[0].inputiiqa22t4);
  
            setIiqa22t5(data[0].qiaIndicator1[1]?data[0].qiaIndicator1[1].inputiiqa22t1:"");
            setIiqa22t6(data[0].qiaIndicator1[1]?data[0].qiaIndicator1[1].inputiiqa22t2:"");
            setIiqa22t7(data[0].qiaIndicator1[1]?data[0].qiaIndicator1[1].inputiiqa22t3:"");
            setIiqa22t8(data[0].qiaIndicator1[1]?data[0].qiaIndicator1[1].inputiiqa22t4:"");
            // qiaIndicator2
            setIiqa1t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa1t1:"");
            setIiqa1t2(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa1t2:"");
            setIiqa2t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa2t1:"");
            setIiqa3t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa3t1:"");
            setIiqa4t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa4t2:"");
            setIiqa4t2(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa4t2:"");
            setIiqa5t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa5t1:"");
            setIiqa6t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa6t1:"");
            setIiqa6t2(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa6t2:"");
            setIiqa6t3(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa6t3:"");
            setIiqa6t4(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa6t4:"");
            setIiqa6t5(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa6t5:"");
            setIiqa6t6(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa6t6:"");
            setIiqa6t7(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa6t7:"");
            setIiqa6t8(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa6t8:"");
            setIiqa6t9(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa6t9:"");
            setIiqa6t10(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa6t10:"");
            setIiqa7t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa7t1:"");
            setIiqa7t2(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa7t2:"");
            setIiqa7t3(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa7t3:"");
            setIiqa7t4(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa7t4:"");
            setIiqa7t5(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa7t5:"");
            setIiqa7t6(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa7t6:"");
            setIiqa7t7(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa7t7:"");
            setIiqa7t8(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa7t8:"");
            setIiqa7t9(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa7t9:"");
            setIiqa7t10(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa7t10:"");
            setIiqa8t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa8t1:"");
            setIiqa9t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa9t1:"");
            setIiqa10t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa10t1:"");
            setIiqa11t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa11t1:"");
            setIiqa13t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa13t1:"");
            setIiqa14t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa14t1:"");
            setIiqa15t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa15t1:"");
            setIiqa16t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa16t1:"");
            setIiqa17t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa17t1:"");
            setIiqa18t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa18t1:"");
            setIiqa19t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa19t1:"");
            setIiqa25t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa25t1:"");
            setIiqa26t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa26t1:"");
            setIiqa27t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa27t1:"");
            setIiqa28t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa28t1:"");
            setIiqa29t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa29t1:"");
            setIiqa30t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa30t1:"");
            setIiqa32t1(data[0].qiaIndicator2[0]?data[0].qiaIndicator2[0].inputiiqa32t1:"");
  
            // qiaIndicator3
            setIiqa12t1(data[0].qiaIndicator3[0]?data[0].qiaIndicator3[0].inputiiqa12t1:"");
            setIiqa12t2(data[0].qiaIndicator3[0]?data[0].qiaIndicator3[0].inputiiqa12t2:"");
            setIiqa12t3(data[0].qiaIndicator3[0]?data[0].qiaIndicator3[0].inputiiqa12t3:"");
  
            // qiaIndicator4
            setIiqa18t2(data[0].qiaIndicator4[0]?data[0].qiaIndicator4[0].inputiiqa18t2:"");
            setIiqa18t3(data[0].qiaIndicator4[0]?data[0].qiaIndicator4[0].inputiiqa18t3:"");
  
            // qiaIndicator5
            setIiqa20t1(data[0].qiaIndicator5[0]?data[0].qiaIndicator5[0].inputiiqa20t1:"");
            setIiqa20t2(data[0].qiaIndicator5[0]?data[0].qiaIndicator5[0].inputiiqa20t2:"");
  
            setIiqa20t3(data[0].qiaIndicator5[1]?data[0].qiaIndicator5[1].inputiiqa20t1:"");
            setIiqa20t4(data[0].qiaIndicator5[1]?data[0].qiaIndicator5[1].inputiiqa20t2:"");
  
            setIiqa20t5(data[0].qiaIndicator5[2]?data[0].qiaIndicator5[2].inputiiqa20t1:"");
            setIiqa20t6(data[0].qiaIndicator5[2]?data[0].qiaIndicator5[2].inputiiqa20t2:"");
  
  
            setIiqa20t7(data[0].qiaIndicator5[3]?data[0].qiaIndicator5[3].inputiiqa20t1:"");
            setIiqa20t8(data[0].qiaIndicator5[3]?data[0].qiaIndicator5[3].inputiiqa20t2:"");
  
            setIiqa20t9(data[0].qiaIndicator5[3]?data[0].qiaIndicator5[3].inputiiqa20t1:"");
            setIiqa20t10(data[0].qiaIndicator5[3]?data[0].qiaIndicator5[3].inputiiqa20t2:"");
  
            setIiqa20t11(data[0].qiaIndicator5[5]?data[0].qiaIndicator5[5].inputiiqa20t1:"");
            setIiqa20t12(data[0].qiaIndicator5[5]?data[0].qiaIndicator5[5].inputiiqa20t2:"");
  
            // qiaIndicator6
            setIiqa21t1(data[0].qiaIndicator6[0]?data[0].qiaIndicator6[0].inputiiqa21t1:"");
            setIiqa21t2(data[0].qiaIndicator6[0]?data[0].qiaIndicator6[0].inputiiqa21t2:"");
            setIiqa21t3(data[0].qiaIndicator6[0]?data[0].qiaIndicator6[0].inputiiqa21t3:"");
            setIiqa21t4(data[0].qiaIndicator6[0]?data[0].qiaIndicator6[0].inputiiqa21t4:"");
            setIiqa21t5(data[0].qiaIndicator6[0]?data[0].qiaIndicator6[0].inputiiqa21t5:"");
  
            setIiqa21t6(data[0].qiaIndicator6[1]?data[0].qiaIndicator6[0].inputiiqa21t1:"");
            setIiqa21t7(data[0].qiaIndicator6[1]?data[0].qiaIndicator6[0].inputiiqa21t2:"");
            setIiqa21t8(data[0].qiaIndicator6[1]?data[0].qiaIndicator6[0].inputiiqa21t3:"");
            setIiqa21t9(data[0].qiaIndicator6[1]?data[0].qiaIndicator6[0].inputiiqa21t4:"");
            setIiqa21t10(data[0].qiaIndicator6[1]?data[0].qiaIndicator6[0].inputiiqa21t5:"");
  
            setIiqa21t11(data[0].qiaIndicator6[2]?data[0].qiaIndicator6[0].inputiiqa21t1:"");
            setIiqa21t12(data[0].qiaIndicator6[2]?data[0].qiaIndicator6[0].inputiiqa21t2:"");
            setIiqa21t13(data[0].qiaIndicator6[2]?data[0].qiaIndicator6[0].inputiiqa21t3:"");
            setIiqa21t14(data[0].qiaIndicator6[2]?data[0].qiaIndicator6[0].inputiiqa21t4:"");
            setIiqa21t15(data[0].qiaIndicator6[2]?data[0].qiaIndicator6[0].inputiiqa21t5:"");
  
            setIiqa21t16(data[0].qiaIndicator6[3]?data[0].qiaIndicator6[0].inputiiqa21t1:"");
            setIiqa21t17(data[0].qiaIndicator6[3]?data[0].qiaIndicator6[0].inputiiqa21t2:"");
            setIiqa21t18(data[0].qiaIndicator6[3]?data[0].qiaIndicator6[0].inputiiqa21t3:"");
            setIiqa21t19(data[0].qiaIndicator6[3]?data[0].qiaIndicator6[0].inputiiqa21t4:"");
            setIiqa21t20(data[0].qiaIndicator6[3]?data[0].qiaIndicator6[0].inputiiqa21t5:"");
  
            setIiqa21t21(data[0].qiaIndicator6[4]?data[0].qiaIndicator6[0].inputiiqa21t1:"");
            setIiqa21t22(data[0].qiaIndicator6[4]?data[0].qiaIndicator6[0].inputiiqa21t2:"");
            setIiqa21t23(data[0].qiaIndicator6[4]?data[0].qiaIndicator6[0].inputiiqa21t3:"");
            setIiqa21t24(data[0].qiaIndicator6[4]?data[0].qiaIndicator6[0].inputiiqa21t4:"");
            setIiqa21t25(data[0].qiaIndicator6[4]?data[0].qiaIndicator6[0].inputiiqa21t5:"");
  
            setIiqa21t26(data[0].qiaIndicator6[5]?data[0].qiaIndicator6[0].inputiiqa21t1:"");
            setIiqa21t27(data[0].qiaIndicator6[5]?data[0].qiaIndicator6[0].inputiiqa21t2:"");
            setIiqa21t28(data[0].qiaIndicator6[5]?data[0].qiaIndicator6[0].inputiiqa21t3:"");
            setIiqa21t29(data[0].qiaIndicator6[5]?data[0].qiaIndicator6[0].inputiiqa21t4:"");
            setIiqa21t30(data[0].qiaIndicator6[5]?data[0].qiaIndicator6[0].inputiiqa21t5:"");
  
            setIiqa21t31(data[0].qiaIndicator6[6]?data[0].qiaIndicator6[0].inputiiqa21t1:"");
            setIiqa21t32(data[0].qiaIndicator6[6]?data[0].qiaIndicator6[0].inputiiqa21t2:"");
            setIiqa21t33(data[0].qiaIndicator6[6]?data[0].qiaIndicator6[0].inputiiqa21t3:"");
            setIiqa21t34(data[0].qiaIndicator6[6]?data[0].qiaIndicator6[0].inputiiqa21t4:"");
            setIiqa21t35(data[0].qiaIndicator6[6]?data[0].qiaIndicator6[0].inputiiqa21t5:"");
  
            setIiqa21t36(data[0].qiaIndicator6[7]?data[0].qiaIndicator6[0].inputiiqa21t1:"");
            setIiqa21t37(data[0].qiaIndicator6[7]?data[0].qiaIndicator6[0].inputiiqa21t2:"");
            setIiqa21t38(data[0].qiaIndicator6[7]?data[0].qiaIndicator6[0].inputiiqa21t3:"");
            setIiqa21t39(data[0].qiaIndicator6[7]?data[0].qiaIndicator6[0].inputiiqa21t4:"");
            setIiqa21t40(data[0].qiaIndicator6[7]?data[0].qiaIndicator6[0].inputiiqa21t5:"");
  
            setIiqa21t51(data[0].qiaIndicator6[8]?data[0].qiaIndicator6[0].inputiiqa21t1:"");
            setIiqa21t52(data[0].qiaIndicator6[8]?data[0].qiaIndicator6[0].inputiiqa21t2:"");
            setIiqa21t53(data[0].qiaIndicator6[8]?data[0].qiaIndicator6[0].inputiiqa21t3:"");
            setIiqa21t54(data[0].qiaIndicator6[8]?data[0].qiaIndicator6[0].inputiiqa21t4:"");
            setIiqa21t55(data[0].qiaIndicator6[8]?data[0].qiaIndicator6[0].inputiiqa21t5:"");
  
            setIiqa21t56(data[0].qiaIndicator6[9]?data[0].qiaIndicator6[0].inputiiqa21t1:"");
            setIiqa21t57(data[0].qiaIndicator6[9]?data[0].qiaIndicator6[0].inputiiqa21t2:"");
            setIiqa21t58(data[0].qiaIndicator6[9]?data[0].qiaIndicator6[0].inputiiqa21t3:"");
            setIiqa21t59(data[0].qiaIndicator6[9]?data[0].qiaIndicator6[0].inputiiqa21t4:"");
            setIiqa21t60(data[0].qiaIndicator6[9]?data[0].qiaIndicator6[0].inputiiqa21t5:"");
  
            setIiqa21t61(data[0].qiaIndicator6[10]?data[0].qiaIndicator6[0].inputiiqa21t1:"");
            setIiqa21t62(data[0].qiaIndicator6[10]?data[0].qiaIndicator6[0].inputiiqa21t2:"");
            setIiqa21t63(data[0].qiaIndicator6[10]?data[0].qiaIndicator6[0].inputiiqa21t3:"");
            setIiqa21t64(data[0].qiaIndicator6[10]?data[0].qiaIndicator6[0].inputiiqa21t4:"");
            setIiqa21t65(data[0].qiaIndicator6[10]?data[0].qiaIndicator6[0].inputiiqa21t5:"");
  
            setIiqa21t66(data[0].qiaIndicator6[11]?data[0].qiaIndicator6[0].inputiiqa21t1:"");
            setIiqa21t67(data[0].qiaIndicator6[11]?data[0].qiaIndicator6[0].inputiiqa21t2:"");
            setIiqa21t68(data[0].qiaIndicator6[11]?data[0].qiaIndicator6[0].inputiiqa21t3:"");
            setIiqa21t69(data[0].qiaIndicator6[11]?data[0].qiaIndicator6[0].inputiiqa21t4:"");
            setIiqa21t70(data[0].qiaIndicator6[11]?data[0].qiaIndicator6[0].inputiiqa21t5:"");
  
            // qiaIndicator7
            setIiqa26t2(data[0].qiaIndicator7[0]?data[0].qiaIndicator7[0].inputiiqa26t2:"");
  
            // qiaIndicator8
            setIiqa27t1(data[0].qiaIndicator8[0]?data[0].qiaIndicator8[0].inputiiqa27t1:"");
  
            // qiaIndicator9
            setIiqa23t1(data[0].qiaIndicator9[0]?data[0].qiaIndicator9[0].inputiiqa23t1:"");
            setIiqa23t2(data[0].qiaIndicator9[0]?data[0].qiaIndicator9[0].inputiiqa23t2:"");
            setIiqa23t3(data[0].qiaIndicator9[0]?data[0].qiaIndicator9[0].inputiiqa23t3:"");
            setIiqa23t4(data[0].qiaIndicator9[0]?data[0].qiaIndicator9[0].inputiiqa23t4:"");
  
            // qiaIndicator10
            setIiqa24t1(data[0].qiaIndicator10[0]?data[0].qiaIndicator10[0].inputiiqa24t1:"");
            setIiqa24t2(data[0].qiaIndicator10[0]?data[0].qiaIndicator10[0].inputiiqa24t2:"");
            setIiqa24t3(data[0].qiaIndicator10[0]?data[0].qiaIndicator10[0].inputiiqa24t3:"");
            setIiqa24t4(data[0].qiaIndicator10[0]?data[0].qiaIndicator10[0].inputiiqa24t4:"");
  
            // qiaIndicator12
            setIiqa1t3(data[0].qiaIndicator12[0]?data[0].qiaIndicator12[0].inputiiqa1t3:"");
            setIiqa1t4(data[0].qiaIndicator12[0]?data[0].qiaIndicator12[0].inputiiqa1t4:"");
            setIiqa1t5(data[0].qiaIndicator12[0]?data[0].qiaIndicator12[0].inputiiqa1t5:"");
            setIiqa1t6(data[0].qiaIndicator12[0]?data[0].qiaIndicator12[0].inputiiqa1t6:"");
          })
          .catch((error) => {
            console.error("Error:", error);
          })
      ),
    []
  );

  let role = null;
  let email = null;
  // eslint-disable-next-line prefer-destructuring
  role = AuthService.getCurrentUser().roles[0];
  email = AuthService.getCurrentUser().email;
  const finacialyear = "2021-2022";
  const authorize = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},


    assignedTo: "depek@adiversetech.com",
    assignedBy: email,
    principalComments: "",
    role:role,
    deanStatus: "A",
    programmerId: "iiqa",
  };

  const rejectContent = {
    criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType},

    assignedTo: "anamita1996@gmail.com",
    assignedBy: email,
    role:role,
    deanComments: rejectReasonComments,
    deanStatus: "R",
    programmerId: "iiqa"
  };
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }
  function getAuthorizeIIQA() {
    console.log("Authorize IIQA");
    const authAPIMethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(authorize),
    };
    fetch(
      resources.APPLICATION_URL + 'qiadatasubmit?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
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
  function getRejectIIQA() {
    console.log("Assigned");
    const rejectAPImethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(rejectContent),
    };
    fetch(
      resources.APPLICATION_URL + 'qiaRejectRecord?collegeId='+collegeId+'&financialYear='+fYear+'&typeofInstitution='+instituteType,
    ).then((response) => {
      
      if (response.ok) {
        successMessage("Record is Rejected Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }

  // getfile data with API

  function downloadFile(fileName) {
    const filePath = resources.APPLICATION_URL+"download/" + fileName;
    return filePath;
  }

  return (
    <div className="main-container">
      <div className="container">
        <div className="heading">
          <h1>Institutional Information for Quality Assessment(IIQA)</h1>
        </div>
      </div>
      <div className="eachTable-container">
        <table style={{ width: "50%" }}>
          <tr>
            <td style={{ width: "40%" }}>Date of submission:</td>
            <td>
              <input
                readonly
                type="date"
                id="iiqaDate"
                onChange={(e) => setIiqaDate(e.target.value)}
                value={iiqaDate}
              />
            </td>
          </tr>
          <tr>
            <td style={{ width: "40%" }}>AISHE ID:</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqaAisheId"
                onChange={(e) => setIiqaAisheId(e.target.value)}
                value={iiqaAisheId}
              />
            </td>
          </tr>
          <tr style={{ width: "40%" }}>
            <td style={{ width: "40%" }}>Institution Track ID:</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqaTrackId"
                onChange={(e) => setIiqaTrackId(e.target.value)}
                value={iiqaTrackId}
              />
            </td>
          </tr>
        </table>
        <table>
          <tr>
            <td rowSpan="2" style={{ width: "8%" }}>
              1
            </td>
            <td style={{ width: "40%" }}>Application For</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa1t1"
                onChange={(e) => setIiqa1t1(e.target.value)}
                value={iiqa1t1}
              />
            </td>
          </tr>
          <tr>
            <td>Cycle of Accreditation</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa1t2"
                onChange={(e) => setIiqa1t2(e.target.value)}
                value={iiqa1t2}
              />
              <table>
                <tr>
                  <td>Cycle</td>
                  <td>Date</td>
                  <td>Grade</td>
                  <td>Score</td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa1t3"
                      onChange={(e) => setIiqa1t3(e.target.value)}
                      value={iiqa1t3}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="date"
                      id="iiqa1t4"
                      onChange={(e) => setIiqa1t4(e.target.value)}
                      value={iiqa1t4}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa1t5"
                      onChange={(e) => setIiqa1t5(e.target.value)}
                      value={iiqa1t5}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa1t6"
                      onChange={(e) => setIiqa1t6(e.target.value)}
                      value={iiqa1t6}
                    />
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>2</td>
            <td>Name of the College</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa2t1"
                onChange={(e) => setIiqa2t1(e.target.value)}
                value={iiqa2t1}
              />
            </td>
          </tr>
          <tr>
            <td>3</td>
            <td>Date of establishment of the Institution</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa3t1"
                onChange={(e) => setIiqa3t1(e.target.value)}
                value={iiqa3t1}
              />
            </td>
          </tr>
          <tr>
            <td rowSpan="2">4</td>
            <td>Name of the Head of the Institution</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa4t1"
                onChange={(e) => setIiqa4t1(e.target.value)}
                value={iiqa4t1}
              />
            </td>
          </tr>
          <tr>
            <td>Designation</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa4t2"
                onChange={(e) => setIiqa4t2(e.target.value)}
                value={iiqa4t2}
              />
            </td>
          </tr>
          <tr>
            <td>5</td>
            <td>Does the college function from Own Campus</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa5t1"
                onChange={(e) => setIiqa5t1(e.target.value)}
                value={iiqa5t1}
              />
            </td>
          </tr>
          <tr>
            <td rowSpan="10">6</td>
            <td>Address of the College</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa6t1"
                onChange={(e) => setIiqa6t1(e.target.value)}
                value={iiqa6t1}
              />
            </td>
          </tr>
          <tr>
            <td>State/UT</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa6t2"
                onChange={(e) => setIiqa6t2(e.target.value)}
                value={iiqa6t2}
              />
            </td>
          </tr>
          <tr>
            <td>District</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa6t3"
                onChange={(e) => setIiqa6t3(e.target.value)}
                value={iiqa6t3}
              />
            </td>
          </tr>
          <tr>
            <td>City</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa6t4"
                value={iiqa6t4}
                onChange={(e) => setIiqa6t4(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>Pin</td>
            <td>
              <input
                readonly
                type="number"
                id="iiqa6t5"
                onChange={(e) => setIiqa6t5(e.target.value)}
                value={iiqa6t5}
              />
            </td>
          </tr>
          <tr>
            <td>Phone No</td>
            <td>
              <input
                readonly
                type="number"
                id="iiqa6t6"
                onChange={(e) => setIiqa6t6(e.target.value)}
                value={iiqa6t6}
              />
            </td>
          </tr>
          <tr>
            <td>Fax No</td>
            <td>
              <input
                readonly
                type="number"
                id="iiqa6t7"
                onChange={(e) => setIiqa6t7(e.target.value)}
                value={iiqa6t7}
              />
            </td>
          </tr>
          <tr>
            <td>Mobile No</td>
            <td>
              <input
                readonly
                type="number"
                id="iiqa6t8"
                onChange={(e) => setIiqa6t8(e.target.value)}
                value={iiqa6t8}
              />
            </td>
          </tr>
          <tr>
            <td>Registered Email</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa6t9"
                onChange={(e) => setIiqa6t9(e.target.value)}
                value={iiqa6t9}
              />
            </td>
          </tr>
          <tr>
            <td>Alternate Email</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa6t10"
                onChange={(e) => setIiqa6t10(e.target.value)}
                value={iiqa6t10}
              />
            </td>
          </tr>
          <tr>
            <td rowSpan="10">7</td>
            <td>Alternate Faculty Contact Details</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa7t1"
                onChange={(e) => setIiqa7t1(e.target.value)}
                value={iiqa7t1}
              />
            </td>
          </tr>
          <tr>
            <td>State/UT</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa7t2"
                onChange={(e) => setIiqa7t2(e.target.value)}
                value={iiqa7t2}
              />
            </td>
          </tr>
          <tr>
            <td>District</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa7t3"
                onChange={(e) => setIiqa7t3(e.target.value)}
                value={iiqa7t3}
              />
            </td>
          </tr>
          <tr>
            <td>City</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa7t4"
                onChange={(e) => setIiqa7t4(e.target.value)}
                value={iiqa7t4}
              />
            </td>
          </tr>
          <tr>
            <td>Pin</td>
            <td>
              <input
                readonly
                type="number"
                id="iiqa7t5"
                onChange={(e) => setIiqa7t5(e.target.value)}
                value={iiqa7t5}
              />
            </td>
          </tr>
          <tr>
            <td>Phone No</td>
            <td>
              <input
                readonly
                type="number"
                id="iiqa7t6"
                onChange={(e) => setIiqa7t6(e.target.value)}
                value={iiqa7t6}
              />
            </td>
          </tr>
          <tr>
            <td>Fax No</td>
            <td>
              <input
                readonly
                type="number"
                id="iiqa7t7"
                onChange={(e) => setIiqa7t7(e.target.value)}
                value={iiqa7t7}
              />
            </td>
          </tr>
          <tr>
            <td>Mobile No</td>
            <td>
              <input
                readonly
                type="number"
                id="iiqa7t8"
                onChange={(e) => setIiqa7t8(e.target.value)}
                value={iiqa7t8}
              />
            </td>
          </tr>
          <tr>
            <td>Email</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa7t9"
                onChange={(e) => setIiqa7t9(e.target.value)}
                value={iiqa7t9}
              />
            </td>
          </tr>
          <tr>
            <td>Alternate Email</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa7t10"
                onChange={(e) => setIiqa7t10(e.target.value)}
                value={iiqa7t10}
              />
            </td>
          </tr>
          <tr>
            <td>8</td>
            <td>Website</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa8t1"
                onChange={(e) => setIiqa8t1(e.target.value)}
                value={iiqa8t1}
              />
            </td>
          </tr>
          <tr>
            <td>9</td>
            <td>
              Has the Institution completed 6 years of existence / Years of
              graduation of last two batches
            </td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa9t1"
                onChange={(e) => setIiqa9t1(e.target.value)}
                value={iiqa9t1}
              />
            </td>
          </tr>
          <tr>
            <td>10</td>
            <td>Nature of the college </td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa10t1"
                onChange={(e) => setIiqa10t1(e.target.value)}
                value={iiqa10t1}
              />
            </td>
          </tr>
          <tr>
            <td>11</td>
            <td>College Affiliation</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa11t1"
                onChange={(e) => setIiqa11t1(e.target.value)}
                value={iiqa11t1}
              />
            </td>
          </tr>
          <tr>
            <td>12</td>
            <td colspan="2">
              College AffiliationName of the affiliating University(ies) and the
              state(s) in which the University(ies) is located
              <table>
                <tr>
                  <td>State</td>
                  <td>University Name</td>
                  <td>Documents</td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa12t1"
                      onChange={(e) => setIiqa12t1(e.target.value)}
                      value={iiqa12t1}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa12t2"
                      onChange={(e) => setIiqa12t2(e.target.value)}
                      value={iiqa12t2}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa12t3"
                      onChange={(e) => setIiqa12t3(e.target.value)}
                      value={iiqa12t3}
                    />
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>13</td>
            <td>
              Is the Institution recognized under section 2(f) of the UGC Act?
            </td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa13t1"
                onChange={(e) => setIiqa13t1(e.target.value)}
                value={iiqa13t1}
              />
            </td>
          </tr>
          <tr>
            <td>14</td>
            <td>
              {" "}
              Is the Institution recognized under section 12B of th UGC Act? If
              yes, date of recognition by UGC under section 12B along with
              latest Plan General Development Grant release letter
            </td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa14t1"
                onChange={(e) => setIiqa14t1(e.target.value)}
                value={iiqa14t1}
              />
            </td>
          </tr>
          <tr>
            <td>15</td>
            <td>
              {" "}
              Is the institution recognised as an Autonomous College by the UGC?
            </td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa15t1"
                onChange={(e) => setIiqa15t1(e.target.value)}
                value={iiqa15t1}
              />
            </td>
          </tr>
          <tr>
            <td>16</td>
            <td>
              Is the institution recognised as a ‘College withPotential for
              Excellence (CPE)’ by the UGC?
            </td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa16t1"
                onChange={(e) => setIiqa16t1(e.target.value)}
                value={iiqa16t1}
              />
            </td>
          </tr>
          <tr>
            <td>17</td>
            <td>
              Is the institution recognised as a ‘College of Excellence’ by the
              UGC?
            </td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa17t1"
                onChange={(e) => setIiqa17t1(e.target.value)}
                value={iiqa17t1}
              />
            </td>
          </tr>
          <tr>
            <td rowSpan="2">18</td>
            <td>
              Is the College offering any programmes recognised by any Statutory
              Regulatory Authority (SRA)
            </td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa18t1"
                onChange={(e) => setIiqa18t1(e.target.value)}
                value={iiqa18t1}
              />
            </td>
          </tr>
          <tr>
            <td> Statutory Regulatory Authorities</td>
            <td>
              <table>
                <tr>
                  <td>SRA program</td>
                  <td>Document</td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa18t2"
                      onChange={(e) => setIiqa18t2(e.target.value)}
                      value={iiqa18t2}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa18t3"
                      onChange={(e) => setIiqa18t3(e.target.value)}
                      value={iiqa18t3}
                    />
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>19</td>
            <td>
              If the institution is not affiliated to a university and is
              offering programmes recognized by any Statutory Regulatory
              Authorities (SRA), are the programmes recognized by Association of
              Indian Universities(AIU) or other appropriate Government
              authorities as equivalent to UG / PG Programmes of a University
            </td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa19t1"
                onChange={(e) => setIiqa19t1(e.target.value)}
                value={iiqa19t1}
              />
            </td>
          </tr>
          <tr>
            <td>20</td>
            <td colspan="2">
              Number of programmes offered
              <table>
                <tr>
                  <td>Programmes</td>
                  <td>Number</td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa20t1"
                      onChange={(e) => setIiqa20t1(e.target.value)}
                      value={iiqa20t1}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa20t2"
                      onChange={(e) => setIiqa20t2(e.target.value)}
                      value={iiqa20t2}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa20t3"
                      onChange={(e) => setIiqa20t3(e.target.value)}
                      value={iiqa20t3}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa20t4"
                      onChange={(e) => setIiqa20t4(e.target.value)}
                      value={iiqa20t4}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa20t5"
                      onChange={(e) => setIiqa20t5(e.target.value)}
                      value={iiqa20t5}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa20t6"
                      onChange={(e) => setIiqa20t6(e.target.value)}
                      value={iiqa20t6}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa20t7"
                      onChange={(e) => setIiqa20t7(e.target.value)}
                      value={iiqa20t7}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa20t8"
                      onChange={(e) => setIiqa20t8(e.target.value)}
                      value={iiqa20t8}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa20t9"
                      onChange={(e) => setIiqa20t9(e.target.value)}
                      value={iiqa20t9}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa20t10"
                      onChange={(e) => setIiqa20t10(e.target.value)}
                      value={iiqa20t10}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa20t11"
                      onChange={(e) => setIiqa20t11(e.target.value)}
                      value={iiqa20t11}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa20t12"
                      onChange={(e) => setIiqa20t12(e.target.value)}
                      value={iiqa20t12}
                    />
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>21</td>
            <td colspan="2">
              Number of programmes offered
              <table>
                <tr>
                  <td>Program</td>
                  <td>Department</td>
                  <td>University Affiliation</td>
                  <td>SRA Recognition</td>
                  <td>Affiliation Status</td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t1"
                      onChange={(e) => setIiqa21t1(e.target.value)}
                      value={iiqa21t1}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t2"
                      onChange={(e) => setIiqa21t2(e.target.value)}
                      value={iiqa21t2}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t3"
                      onChange={(e) => setIiqa21t3(e.target.value)}
                      value={iiqa21t3}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t4"
                      onChange={(e) => setIiqa21t4(e.target.value)}
                      value={iiqa21t4}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t5"
                      onChange={(e) => setIiqa21t5(e.target.value)}
                      value={iiqa21t5}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t6"
                      onChange={(e) => setIiqa21t6(e.target.value)}
                      value={iiqa21t6}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t7"
                      onChange={(e) => setIiqa21t7(e.target.value)}
                      value={iiqa21t7}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t8"
                      onChange={(e) => setIiqa21t8(e.target.value)}
                      value={iiqa21t8}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t9"
                      onChange={(e) => setIiqa21t9(e.target.value)}
                      value={iiqa21t9}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t10"
                      onChange={(e) => setIiqa21t10(e.target.value)}
                      value={iiqa21t10}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t11"
                      onChange={(e) => setIiqa21t11(e.target.value)}
                      value={iiqa21t11}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t12"
                      onChange={(e) => setIiqa21t12(e.target.value)}
                      value={iiqa21t12}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t13"
                      onChange={(e) => setIiqa21t13(e.target.value)}
                      value={iiqa21t13}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t14"
                      onChange={(e) => setIiqa21t14(e.target.value)}
                      value={iiqa21t14}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t15"
                      onChange={(e) => setIiqa21t15(e.target.value)}
                      value={iiqa21t15}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t16"
                      onChange={(e) => setIiqa21t16(e.target.value)}
                      value={iiqa21t16}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t17"
                      onChange={(e) => setIiqa21t17(e.target.value)}
                      value={iiqa21t17}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t18"
                      onChange={(e) => setIiqa21t18(e.target.value)}
                      value={iiqa21t18}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t19"
                      onChange={(e) => setIiqa21t19(e.target.value)}
                      value={iiqa21t19}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t20"
                      value={iiqa21t20}
                      onChange={(e) => setIiqa21t20(e.target.value)}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t21"
                      value={iiqa21t21}
                      onChange={(e) => setIiqa21t21(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t22"
                      value={iiqa21t22}
                      onChange={(e) => setIiqa21t22(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t23"
                      value={iiqa21t23}
                      onChange={(e) => setIiqa21t23(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t24"
                      value={iiqa21t24}
                      onChange={(e) => setIiqa21t24(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t25"
                      value={iiqa21t25}
                      onChange={(e) => setIiqa21t25(e.target.value)}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t26"
                      value={iiqa21t26}
                      onChange={(e) => setIiqa21t26(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t27"
                      value={iiqa21t27}
                      onChange={(e) => setIiqa21t27(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t28"
                      value={iiqa21t28}
                      onChange={(e) => setIiqa21t28(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t29"
                      value={iiqa21t29}
                      onChange={(e) => setIiqa21t29(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t30"
                      value={iiqa21t30}
                      onChange={(e) => setIiqa21t30(e.target.value)}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t31"
                      value={iiqa21t31}
                      onChange={(e) => setIiqa21t31(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t32"
                      value={iiqa21t32}
                      onChange={(e) => setIiqa21t32(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t33"
                      value={iiqa21t33}
                      onChange={(e) => setIiqa21t33(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t34"
                      value={iiqa21t34}
                      onChange={(e) => setIiqa21t34(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t35"
                      value={iiqa21t35}
                      onChange={(e) => setIiqa21t35(e.target.value)}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t36"
                      value={iiqa21t36}
                      onChange={(e) => setIiqa21t36(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t37"
                      value={iiqa21t37}
                      onChange={(e) => setIiqa21t37(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t38"
                      value={iiqa21t38}
                      onChange={(e) => setIiqa21t38(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t39"
                      value={iiqa21t39}
                      onChange={(e) => setIiqa21t39(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t40"
                      value={iiqa21t40}
                      onChange={(e) => setIiqa21t40(e.target.value)}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t51"
                      value={iiqa21t51}
                      onChange={(e) => setIiqa21t51(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t52"
                      value={iiqa21t52}
                      onChange={(e) => setIiqa21t52(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t53"
                      value={iiqa21t53}
                      onChange={(e) => setIiqa21t53(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t54"
                      value={iiqa21t54}
                      onChange={(e) => setIiqa21t54(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t55"
                      value={iiqa21t55}
                      onChange={(e) => setIiqa21t55(e.target.value)}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t56"
                      value={iiqa21t56}
                      onChange={(e) => setIiqa21t56(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t57"
                      value={iiqa21t57}
                      onChange={(e) => setIiqa21t57(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t58"
                      value={iiqa21t58}
                      onChange={(e) => setIiqa21t58(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t59"
                      value={iiqa21t59}
                      onChange={(e) => setIiqa21t59(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t60"
                      value={iiqa21t60}
                      onChange={(e) => setIiqa21t60(e.target.value)}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t61"
                      value={iiqa21t61}
                      onChange={(e) => setIiqa21t61(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t62"
                      value={iiqa21t62}
                      onChange={(e) => setIiqa21t62(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t63"
                      value={iiqa21t63}
                      onChange={(e) => setIiqa21t63(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t64"
                      value={iiqa21t64}
                      onChange={(e) => setIiqa21t64(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t65"
                      value={iiqa21t65}
                      onChange={(e) => setIiqa21t65(e.target.value)}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t66"
                      value={iiqa21t66}
                      onChange={(e) => setIiqa21t66(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t67"
                      value={iiqa21t67}
                      onChange={(e) => setIiqa21t67(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t68"
                      value={iiqa21t68}
                      onChange={(e) => setIiqa21t68(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t69"
                      value={iiqa21t69}
                      onChange={(e) => setIiqa21t69(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="text"
                      id="iiqa21t70"
                      value={iiqa21t70}
                      onChange={(e) => setIiqa21t70(e.target.value)}
                    />
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>22</td>
            <td colspan="2">
              Number of Teaching Staff by employment status (permanent /
              temporary) and by gender
              <table>
                <tr>
                  <td>Male</td>
                  <td>Female</td>
                  <td>Transgender</td>
                  <td>Total</td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa22t1"
                      value={iiqa22t1}
                      onChange={(e) => setIiqa22t1(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa22t2"
                      value={iiqa22t2}
                      onChange={(e) => setIiqa22t2(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa22t3"
                      value={iiqa22t3}
                      onChange={(e) => setIiqa22t3(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa22t4"
                      value={iiqa22t4}
                      onChange={(e) => setIiqa22t4(e.target.value)}
                    />
                  </td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa22t5"
                      value={iiqa22t5}
                      onChange={(e) => setIiqa22t5(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa22t6"
                      value={iiqa22t6}
                      onChange={(e) => setIiqa22t6(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa22t7"
                      value={iiqa22t7}
                      onChange={(e) => setIiqa22t7(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa22t8"
                      value={iiqa22t8}
                      onChange={(e) => setIiqa22t8(e.target.value)}
                    />
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>23</td>
            <td colspan="2">
              Number of Non-Teaching Staff by employment status (permanent /
              temporary) and by gender
              <table>
                <tr>
                  <td>Male</td>
                  <td>Female</td>
                  <td>Transgender</td>
                  <td>Total</td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa23t1"
                      value={iiqa23t1}
                      onChange={(e) => setIiqa23t1(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa23t2"
                      value={iiqa23t2}
                      onChange={(e) => setIiqa23t2(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa23t3"
                      value={iiqa23t3}
                      onChange={(e) => setIiqa23t3(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa23t4"
                      value={iiqa23t4}
                      onChange={(e) => setIiqa23t4(e.target.value)}
                    />
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>24</td>
            <td colspan="2">
              Number of Students on roll by gender
              <table>
                <tr>
                  <td>Male</td>
                  <td>Female</td>
                  <td>Transgender</td>
                  <td>Total</td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa24t1"
                      value={iiqa24t1}
                      onChange={(e) => setIiqa24t1(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa24t2"
                      value={iiqa24t2}
                      onChange={(e) => setIiqa24t2(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa24t3"
                      value={iiqa24t3}
                      onChange={(e) => setIiqa24t3(e.target.value)}
                    />
                  </td>
                  <td>
                    <input
                      readonly
                      type="number"
                      id="iiqa24t4"
                      value={iiqa24t4}
                      onChange={(e) => setIiqa24t4(e.target.value)}
                    />
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>25</td>
            <td>Number of Students on roll by gender</td>
            <td>
              <input
                readonly
                type="number"
                id="iiqa25t1"
                value={iiqa25t1}
                onChange={(e) => setIiqa25t1(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td rowSpan="2">26</td>
            <td>Date of establishment of IQAC</td>
            <td>
              <input
                readonly
                type="number"
                id="iiqa26t1"
                value={iiqa26t1}
                onChange={(e) => setIiqa26t1(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>
              The minutes of IQAC meeting and Action Taken Report should be
              uploaded on the institutional website.
            </td>
            <td>
              <table>
                <tr>
                  <td>Date</td>
                  <td>View Document</td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="date"
                      id="iiqa26t2"
                      value={iiqa26t2}
                      onChange={(e) => setIiqa26t2(e.target.value)}
                    />
                  </td>
                  <td>
                    <a href={downloadFile(pathValueiiqa26f1)} target="_blank">
                      View File
                    </a>
                    {/* <input
                      type="file"
                      id="iiqa26f1"
                      value={iiqa26f1}
                      onChange={(e) => {
                        setIiqa26f1(e.target.files[0]);
                        setPathValueiiqa26f1(e.target.value);
                      }}
                    />
                    <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    <a href={downloadFile(pathValueiiqa26f1)} target="_blank">view file</a>
                  </button>
                </div>
                    {pathValueiiqa26f1 === "" ? null : (
                      <div className="c11-fileButtons-container">
                        <button className="c11-viewFileButton-style">
                          View File
                        </button>
                        <button className="c11-removeFileButton-style">
                          Remove File
                        </button>
                      </div>
                    )} */}
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>27</td>
            <td>Date of submission of AQARs of last 4 years to NAAC</td>
            <td>
              <table>
                <tr>
                  <td>Date</td>
                  <td>View Document</td>
                </tr>
                <tr>
                  <td>
                    <input
                      readonly
                      type="date"
                      id="iiqa27t1"
                      value={iiqa27t1}
                      onChange={(e) => {
                        setIiqa27t1(e.target.value);
                      }}
                    />
                  </td>
                  <td>
                    <a href={downloadFile(pathValueiiqa27f1)} target="_blank">
                      View File
                    </a>
                    {/* <input
                      type="file"
                      id="iiqa27f1"
                      value={iiqa27f1}
                      onChange={(e) => {
                        setIiqa27f1(e.target.files[0]);
                        setPathValueiiqa27f1(e.target.value);
                      }}
                    />
                      <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    <a href={downloadFile(pathValueiiqa27f1)} target="_blank">view file</a>
                  </button>
                </div>
                    {pathValueiiqa27f1 === "" ? null : (
                      <div className="c11-fileButtons-container">
                        <button className="c11-viewFileButton-style">
                          View File
                        </button>
                        <button className="c11-removeFileButton-style">
                          Remove File
                        </button>
                      </div>
                    )} */}
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>28</td>
            <td>
              Has the institution made statutory declaration on the institution
              website under Section 4 (1) (b) of the RTI Act 2005 as issued and
              amended from time to time.
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ marginBottom: "20px" }}
                id="iiqa28t1"
                value={iiqa28t1}
                onChange={(e) => {
                  setIiqa28t1(e.target.value);
                }}
              />
              <br />
              <a href={downloadFile(pathValueiiqa28f1)} target="_blank">
                View File
              </a>
              {/* <input
                type="file"
                id="iiqa28f1"
                value={iiqa28f1}
                onChange={(e) => {
                  setIiqa28f1(e.target.files[0]);
                  setPathValueiiqa28f1(e.target.value);
                }}
              />
               <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    <a href={downloadFile(pathValueiiqa28f1)} target="_blank">view file</a>
                  </button>
                </div>
              {pathValueiiqa28f1 === "" ? null : (
                <div className="c11-28-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    View File
                  </button>
                  <button className="c11-removeFileButton-style">
                    Remove File
                  </button>
                </div>
              )} */}
            </td>
          </tr>
          <tr>
            <td>29</td>
            <td>
              Does the college have an academic MoU with any foreign
              institution.
            </td>
            <td>
              <input
                readonly
                type="text"
                style={{ marginBottom: "20px" }}
                id="iiqa29t1"
                value={iiqa29t1}
                onChange={(e) => setIiqa29t1(e.target.value)}
              />
              <br />
              <a href={downloadFile(pathValueiiqa29f1)} target="_blank">
                View File
              </a>
              {/* <input
                type="file"
                id="iiqa29f1"
                value={iiqa29f1}
                onChange={(e) => {
                  setIiqa29f1(e.target.files[0]);
                  setPathValueiiqa29f1(e.target.value);
                }}
              />
                <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    <a href={downloadFile(pathValueiiqa29f1)} target="_blank">view file</a>
                  </button>
                </div>
              {pathValueiiqa29f1 === "" ? null : (
                <div className="c11-29-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    View File
                  </button>
                  <button className="c11-removeFileButton-style">
                    Remove File
                  </button>
                </div>
              )} */}
            </td>
          </tr>
          <tr>
            <td>30</td>
            <td>
              Date of uploading data on MHRD website for All India Survey on
              Higher Education (AISHE).
            </td>
            <td>
              <input
                readonly
                type="date"
                style={{ marginBottom: "20px" }}
                id="iiqa30t1"
                value={iiqa30t1}
                onChange={(e) => {
                  setIiqa30t1(e.target.value);
                }}
              />
              <br />
              <a href={downloadFile(pathValueiiqa30f1)} target="_blank">
                View File
              </a>
              {/* <input
                type="file"
                id="iiqa30f1"
                value={iiqa30f1}
                onChange={(e) => {
                  setIiqa30f1(e.target.files[0]);
                  setPathValueiiqa30f1(e.target.value);
                }}
              />
               <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    <a href={downloadFile(pathValueiiqa30f1)} target="_blank">view file</a>
                  </button>
                </div>
              {pathValueiiqa30f1 === "" ? null : (
                <div className="c11-30-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    View File
                  </button>
                  <button className="c11-removeFileButton-style">
                    Remove File
                  </button>
                </div>
              )} */}
            </td>
          </tr>
          <tr>
            <td>31</td>
            <td>
              Attach Certification by the Head of the Institution for having
              complied with Rules & Regulations of Central Government, UGC and
              other Statutory Bodies, State Government and Affiliating
              University in the prescribed format enclosed herewith.
            </td>
            <td>
              <a href={downloadFile(pathValueiiqa31f1)} target="_blank">
                View File
              </a>
              {/* <input
                type="file"
                id="iiqa31f1"
                value={iiqa31f1}
                onChange={(e) => {
                  setIiqa31f1(e.target.files[0]);
                  setPathValueiiqa31f1(e.target.value);
                }}
              />
                <div className="c11-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    <a href={downloadFile(pathValueiiqa31f1)} target="_blank">view file</a>
                  </button>
                </div>
              {pathValueiiqa31f1 === "" ? null : (
                <div className="c11-31-fileButtons-container">
                  <button className="c11-viewFileButton-style">
                    View File
                  </button>
                  <button className="c11-removeFileButton-style">
                    Remove File
                  </button>
                </div>
              )} */}
            </td>
          </tr>
          <tr>
            <td>32</td>
            <td>Registration Fee paid details.</td>
            <td>
              <input
                readonly
                type="text"
                id="iiqa32t1"
                onChange={(e) => setIiqa32t1(e.target.value)}
                value={iiqa32t1}
              />
            </td>
          </tr>
        </table>
      </div>
      <div>Principal Comments : {principalComments}</div>
      <div className="c31x-button-container">
        <button
          onClick={(e) => {
            getAuthorizeIIQA(e);
          }}
          className="c31x-button-style"
          style={{ color: "white", backgroundColor: "green" }}
        >
          Authorize
        </button>

        <button
          onClick={(e) => {
            setRejectButtonClickStatus(true);
            e.preventDefault();
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
              onClick={() => setRejectButtonClickStatus(false)}
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
                getRejectIIQA(e);
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
export default IIQAAuthorize;
