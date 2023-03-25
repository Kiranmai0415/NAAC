import React, { useState, useEffect } from 'react';
import { toast } from "react-toastify";
import { resources } from '../../../appConstants';
import './QLQN-style.css';

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

function QLQN() {
  // Criteria 11
  const [dataValue111, setDataValue111] = useState('');
  const [dataValueGrade111, setDataValueGrade111] = useState();
  const [dataValue112, setDataValue112] = useState('');
  const [dataValue113, setDataValue113] = useState('');

  // Criteria 12
  const [dataValue121, setDataValue121] = useState('');
  const [dataValue122, setDataValue122] = useState('');

  // Criteria 13
  const [dataValue131, setDataValue131] = useState('');
  const [dataValueGrade131, setDataValueGrade131] = useState();
  const [dataValue132, setDataValue132] = useState('');
  const [dataValue133, setDataValue133] = useState('');
  const [dataValue134, setDataValue134] = useState('');

  // Criteria 14

  const [dataValue141, setDataValue141] = useState('');
  const [dataValue142, setDataValue142] = useState('');

  // Criteria 21
  const [dataValue211, setDataValue211] = useState('');
  const [dataValue212, setDataValue212] = useState('');

  // Criteria 22
  const [dataValue221, setDataValue221] = useState('');
  const [dataValueGrade221, setDataValueGrade221] = useState();
  const [dataValue222, setDataValue222] = useState('');

  // Criteria 23
  const [dataValue231, setDataValue231] = useState('');
  const [dataValueGrade231, setDataValueGrade231] = useState();
  const [dataValue232, setDataValue232] = useState('');
  const [dataValueGrade232, setDataValueGrade232] = useState();
  const [dataValue233, setDataValue233] = useState('');
  const [dataValue234, setDataValue234] = useState('');
  const [dataValueGrade234, setDataValueGrade234] = useState();

  // Criteria 24
  const [dataValue241, setDataValue241] = useState('');
  const [dataValue242, setDataValue242] = useState('');
  const [dataValue243, setDataValue243] = useState('');

  // Criteria 25
  const [dataValue251, setDataValue251] = useState('');
  const [dataValue252, setDataValue252] = useState('');
  const [dataValue253, setDataValue253] = useState('');
  const [dataValueGrade253, setDataValueGrade253] = useState();

  // Criteria 26
  const [dataValue261, setDataValue261] = useState('');
  const [dataValueGrade261, setDataValueGrade261] = useState();
  const [dataValue262, setDataValue262] = useState('');
  const [dataValueGrade262, setDataValueGrade262] = useState();
  const [dataValue263, setDataValue263] = useState('');

  // Criteria 27
  const [dataValue271, setDataValue271] = useState('');

  // Criteria 31
  const [dataValue311, setDataValue311] = useState('');
  const [dataValueGrade311, setDataValueGrade311] = useState();
  const [dataValue312, setDataValue312] = useState('');
  const [dataValue313, setDataValue313] = useState('');

  // Criteria 32
  const [dataValue321, setDataValue321] = useState('');
  const [dataValue322, setDataValue322] = useState('');
  const [dataValue323, setDataValue323] = useState('');
  const [dataValue324, setDataValue324] = useState('');

  // Criteria 33
  const [dataValue331, setDataValue331] = useState('');
  const [dataValueGrade331, setDataValueGrade331] = useState();
  const [dataValue332, setDataValue332] = useState('');

  // Criteria 34
  const [dataValue341, setDataValue341] = useState('');
  const [dataValue342, setDataValue342] = useState('');
  const [dataValue343, setDataValue343] = useState('');
  const [dataValue344, setDataValue344] = useState('');
  const [dataValue345, setDataValue345] = useState('');
  const [dataValue346, setDataValue346] = useState('');

  // Criteria 35
  const [dataValue351, setDataValue351] = useState('');
  const [dataValue352, setDataValue352] = useState('');

  // Criteria 36
  const [dataValue361, setDataValue361] = useState('');
  const [dataValueGrade361, setDataValueGrade361] = useState();
  const [dataValue362, setDataValue362] = useState('');
  const [dataValue363, setDataValue363] = useState('');
  const [dataValue364, setDataValue364] = useState('');

  // Criteria 37
  const [dataValue371, setDataValue371] = useState('');
  const [dataValue372, setDataValue372] = useState('');

  // Criteria 41
  const [dataValue411, setDataValue411] = useState('');
  const [dataValueGrade411, setDataValueGrade411] = useState();
  const [dataValue412, setDataValue412] = useState('');
  const [dataValueGrade412, setDataValueGrade412] = useState();
  const [dataValue413, setDataValue413] = useState('');
  const [dataValue414, setDataValue414] = useState('');

  // Criteria 42
  const [dataValue421, setDataValue421] = useState('');
  const [dataValueGrade421, setDataValueGrade421] = useState();
  const [dataValue422, setDataValue422] = useState('');
  const [dataValue423, setDataValue423] = useState('');
  const [dataValue424, setDataValue424] = useState('');

  // Criteria 43
  const [dataValue431, setDataValue431] = useState('');
  const [dataValueGrade431, setDataValueGrade431] = useState();
  const [dataValue432, setDataValue432] = useState('');
  const [dataValue433, setDataValue433] = useState('');
  const [dataValue434, setDataValue434] = useState('');

  // Criteria 44

  const [dataValue441, setDataValue441] = useState('');
  const [dataValue442, setDataValue442] = useState('');
  const [dataValueGrade442, setDataValueGrade442] = useState();

  // Criteria 51
  const [dataValue511, setDataValue511] = useState('');
  const [dataValue512, setDataValue512] = useState('');
  const [dataValue513, setDataValue513] = useState('');
  const [dataValue514, setDataValue514] = useState('');
  const [dataValue515, setDataValue515] = useState('');

  // Criteria 52
  const [dataValue521, setDataValue521] = useState('');
  const [dataValue522, setDataValue522] = useState('');
  const [dataValue523, setDataValue523] = useState('');

  // Criteria 53
  const [dataValue531, setDataValue531] = useState('');
  const [dataValue532, setDataValue532] = useState('');
  const [dataValueGrade532, setDataValueGrade532] = useState();
  const [dataValue533, setDataValue533] = useState('');

  // Criteria 54
  const [dataValue541, setDataValue541] = useState('');
  const [dataValueGrade541, setDataValueGrade541] = useState();
  const [dataValue542, setDataValue542] = useState('');

  // Criteria 61
  const [dataValue611, setDataValue611] = useState('');
  const [dataValueGrade611, setDataValueGrade611] = useState();
  const [dataValue612, setDataValue612] = useState('');
  const [dataValueGrade612, setDataValueGrade612] = useState();

  // Criteria 62
  const [dataValue621, setDataValue621] = useState('');
  const [dataValueGrade621, setDataValueGrade621] = useState();
  const [dataValue622, setDataValue622] = useState('');
  const [dataValueGrade622, setDataValueGrade622] = useState();
  const [dataValue623, setDataValue623] = useState('');

  // Criteria 63
  const [dataValue631, setDataValue631] = useState('');
  const [dataValueGrade631, setDataValueGrade631] = useState();
  const [dataValue632, setDataValue632] = useState('');
  const [dataValue633, setDataValue633] = useState('');
  const [dataValue634, setDataValue634] = useState('');

  // Criteria 64
  const [dataValue641, setDataValue641] = useState('');
  const [dataValueGrade641, setDataValueGrade641] = useState();
  const [dataValue642, setDataValue642] = useState('');
  const [dataValue643, setDataValue643] = useState('');
  const [dataValueGrade643, setDataValueGrade643] = useState();

  // Criteria 65
  const [dataValue651, setDataValue651] = useState('');
  const [dataValueGrade651, setDataValueGrade651] = useState();
  const [dataValue652, setDataValue652] = useState('');
  const [dataValueGrade652, setDataValueGrade652] = useState();
  const [dataValue653, setDataValue653] = useState('');

  // Criteria 71
  const [dataValue711, setDataValue711] = useState('');
  const [dataValueGrade711, setDataValueGrade711] = useState();
  const [dataValue712, setDataValue712] = useState('');
  const [dataValue713, setDataValue713] = useState('');
  const [dataValueGrade713, setDataValueGrade713] = useState();
  const [dataValue714, setDataValue714] = useState('');
  const [dataValue715, setDataValue715] = useState('');
  const [dataValue716, setDataValue716] = useState('');
  const [dataValue717, setDataValue717] = useState('');
  const [dataValue718, setDataValue718] = useState('');
  const [dataValueGrade718, setDataValueGrade718] = useState();
  const [dataValue719, setDataValue719] = useState('');
  const [dataValueGrade719, setDataValueGrade719] = useState();
  const [dataValue7110, setDataValue7110] = useState('');
  const [dataValue7111, setDataValue7111] = useState('');
  const [dataValueGrade7111, setDataValueGrade7111] = useState();

  // Criteria 72
  const [dataValue721, setDataValue721] = useState('');
  const [dataValueGrade721, setDataValueGrade721] = useState();

  // Criteria 73
  const [dataValue731, setDataValue731] = useState('');
  const [dataValueGrade731, setDataValueGrade731] = useState();

  useEffect(
    () => fetch(resources.APPLICATION_URL+'getallqualitativeQuantitaveData').then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));

          setDataValue112(data[0].quantitativeDataList[1].qntt7);
          setDataValue113(data[0].quantitativeDataList[2].qntt7);
          setDataValue121(data[0].quantitativeDataList[3].qntt7);
          setDataValue122(data[0].quantitativeDataList[4].qntt7);
          setDataValue132(data[0].quantitativeDataList[5].qntt7);
          setDataValue133(data[0].quantitativeDataList[6].qntt7);
          setDataValue134(data[0].quantitativeDataList[7].qntt7);
          setDataValue141(data[0].quantitativeDataList[8].qntt7);
          setDataValue142(data[0].quantitativeDataList[9].qntt7);
          setDataValue211(data[0].quantitativeDataList[10].qntt7);
          setDataValue212(data[0].quantitativeDataList[11].qntt7);
          setDataValue222(data[0].quantitativeDataList[12].qntt7);
          setDataValue233(data[0].quantitativeDataList[13].qntt7);
          setDataValue241(data[0].quantitativeDataList[14].qntt7);
          setDataValue242(data[0].quantitativeDataList[15].qntt7);
          setDataValue243(data[0].quantitativeDataList[16].qntt7);
          setDataValue251(data[0].quantitativeDataList[17].qntt7);
          setDataValue252(data[0].quantitativeDataList[18].qntt7);
          setDataValue263(data[0].quantitativeDataList[19].qntt7);
          setDataValue271(data[0].quantitativeDataList[20].qntt7);
          setDataValue312(data[0].quantitativeDataList[21].qntt7);
          setDataValue313(data[0].quantitativeDataList[22].qntt7);
          setDataValue321(data[0].quantitativeDataList[23].qntt7);
          setDataValue322(data[0].quantitativeDataList[24].qntt7);
          setDataValue323(data[0].quantitativeDataList[25].qntt7);
          setDataValue324(data[0].quantitativeDataList[26].qntt7);
          setDataValue332(data[0].quantitativeDataList[27].qntt7);
          setDataValue341(data[0].quantitativeDataList[28].qntt7);
          setDataValue342(data[0].quantitativeDataList[29].qntt7);
          setDataValue343(data[0].quantitativeDataList[30].qntt7);
          setDataValue344(data[0].quantitativeDataList[31].qntt7);
          setDataValue345(data[0].quantitativeDataList[32].qntt7);
          setDataValue346(data[0].quantitativeDataList[33].qntt7);
          setDataValue351(data[0].quantitativeDataList[34].qntt7);
          setDataValue352(data[0].quantitativeDataList[35].qntt7);
          setDataValue362(data[0].quantitativeDataList[36].qntt7);
          setDataValue363(data[0].quantitativeDataList[37].qntt7);
          setDataValue364(data[0].quantitativeDataList[38].qntt7);
          setDataValue371(data[0].quantitativeDataList[39].qntt7);
          setDataValue372(data[0].quantitativeDataList[40].qntt7);
          setDataValue413(data[0].quantitativeDataList[41].qntt7);
          setDataValue414(data[0].quantitativeDataList[42].qntt7);
          setDataValue422(data[0].quantitativeDataList[43].qntt7);
          setDataValue423(data[0].quantitativeDataList[44].qntt7);
          setDataValue424(data[0].quantitativeDataList[45].qntt7);
          setDataValue432(data[0].quantitativeDataList[46].qntt7);
          setDataValue433(data[0].quantitativeDataList[47].qntt7);
          setDataValue434(data[0].quantitativeDataList[48].qntt7);
          setDataValue441(data[0].quantitativeDataList[49].qntt7);
          setDataValue511(data[0].quantitativeDataList[50].qntt7);
          setDataValue512(data[0].quantitativeDataList[51].qntt7);
          setDataValue513(data[0].quantitativeDataList[52].qntt7);
          setDataValue514(data[0].quantitativeDataList[53].qntt7);
          setDataValue515(data[0].quantitativeDataList[54].qntt7);
          setDataValue521(data[0].quantitativeDataList[55].qntt7);
          setDataValue522(data[0].quantitativeDataList[56].qntt7);
          setDataValue523(data[0].quantitativeDataList[57].qntt7);
          setDataValue531(data[0].quantitativeDataList[58].qntt7);
          setDataValue533(data[0].quantitativeDataList[59].qntt7);
          setDataValue542(data[0].quantitativeDataList[60].qntt7);
          setDataValue623(data[0].quantitativeDataList[61].qntt7);
          setDataValue632(data[0].quantitativeDataList[62].qntt7);
          setDataValue633(data[0].quantitativeDataList[63].qntt7);
          setDataValue634(data[0].quantitativeDataList[64].qntt7);
          setDataValue642(data[0].quantitativeDataList[65].qntt7);
          setDataValue653(data[0].quantitativeDataList[66].qntt7);
          setDataValue712(data[0].quantitativeDataList[67].qntt7);
          setDataValue714(data[0].quantitativeDataList[68].qntt7);
          setDataValue715(data[0].quantitativeDataList[69].qntt7);
          setDataValue716(data[0].quantitativeDataList[70].qntt7);
          setDataValue717(data[0].quantitativeDataList[71].qntt7);
          setDataValue7110(data[0].quantitativeDataList[72].qntt7);

          setDataValue111(data[0].qualitative[1].qlit7);
          setDataValueGrade111(data[0].qualitative[1].qlit6);
          setDataValue131(data[0].qualitative[2].qlit7);
          setDataValueGrade131(data[0].qualitative[2].qlit6);
          setDataValue221(data[0].qualitative[3].qlit7);
          setDataValueGrade221(data[0].qualitative[3].qlit6);
          setDataValue231(data[0].qualitative[4].qlit7);
          setDataValueGrade231(data[0].qualitative[4].qlit6);
          setDataValue232(data[0].qualitative[5].qlit7);
          setDataValueGrade232(data[0].qualitative[5].qlit6);
          setDataValue234(data[0].qualitative[6].qlit7);
          setDataValueGrade234(data[0].qualitative[6].qlit6);
          setDataValue253(data[0].qualitative[7].qlit7);
          setDataValueGrade253(data[0].qualitative[7].qlit6);
          setDataValue261(data[0].qualitative[8].qlit7);
          setDataValueGrade261(data[0].qualitative[8].qlit6);
          setDataValue262(data[0].qualitative[9].qlit7);
          setDataValueGrade262(data[0].qualitative[9].qlit6);
          setDataValue311(data[0].qualitative[10].qlit7);
          setDataValueGrade311(data[0].qualitative[10].qlit6);
          setDataValue331(data[0].qualitative[11].qlit7);
          setDataValueGrade331(data[0].qualitative[11].qlit6);
          setDataValue361(data[0].qualitative[12].qlit7);
          setDataValueGrade361(data[0].qualitative[12].qlit6);
          setDataValue411(data[0].qualitative[13].qlit7);
          setDataValueGrade411(data[0].qualitative[13].qlit6);
          setDataValue412(data[0].qualitative[14].qlit7);
          setDataValueGrade412(data[0].qualitative[14].qlit6);
          setDataValue421(data[0].qualitative[15].qlit7);
          setDataValueGrade421(data[0].qualitative[15].qlit6);
          setDataValue431(data[0].qualitative[16].qlit7);
          setDataValueGrade431(data[0].qualitative[16].qlit6);
          setDataValue442(data[0].qualitative[17].qlit7);
          setDataValueGrade442(data[0].qualitative[17].qlit6);
          setDataValue532(data[0].qualitative[18].qlit7);
          setDataValueGrade532(data[0].qualitative[18].qlit6);
          setDataValue541(data[0].qualitative[19].qlit7);
          setDataValueGrade541(data[0].qualitative[19].qlit6);
          setDataValue611(data[0].qualitative[20].qlit7);
          setDataValueGrade611(data[0].qualitative[20].qlit6);
          setDataValue612(data[0].qualitative[21].qlit7);
          setDataValueGrade612(data[0].qualitative[21].qlit6);
          setDataValue621(data[0].qualitative[22].qlit7);
          setDataValueGrade621(data[0].qualitative[22].qlit6);
          setDataValue622(data[0].qualitative[23].qlit7);
          setDataValueGrade622(data[0].qualitative[23].qlit6);
          setDataValue631(data[0].qualitative[24].qlit7);
          setDataValueGrade631(data[0].qualitative[24].qlit6);
          setDataValue641(data[0].qualitative[25].qlit7);
          setDataValueGrade641(data[0].qualitative[25].qlit6);
          setDataValue643(data[0].qualitative[26].qlit7);
          setDataValueGrade643(data[0].qualitative[26].qlit6);
          setDataValue651(data[0].qualitative[27].qlit7);
          setDataValueGrade651(data[0].qualitative[27].qlit6);
          setDataValue652(data[0].qualitative[28].qlit7);
          setDataValueGrade652(data[0].qualitative[28].qlit6);
          setDataValue711(data[0].qualitative[29].qlit7);
          setDataValueGrade711(data[0].qualitative[29].qlit6);
          setDataValue713(data[0].qualitative[30].qlit7);
          setDataValueGrade713(data[0].qualitative[30].qlit6);
          setDataValue718(data[0].qualitative[31].qlit7);
          setDataValueGrade718(data[0].qualitative[31].qlit6);
          setDataValue719(data[0].qualitative[32].qlit7);
          setDataValueGrade719(data[0].qualitative[32].qlit6);
          setDataValue7111(data[0].qualitative[33].qlit7);
          setDataValueGrade7111(data[0].qualitative[33].qlit6);
          setDataValue721(data[0].qualitative[34].qlit7);
          setDataValueGrade721(data[0].qualitative[34].qlit6);
          setDataValue731(data[0].qualitative[35].qlit7);
          setDataValueGrade731(data[0].qualitative[35].qlit6);
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ), []
  );

  const kiWeightage11 = 30;
  const weightage111 = 20;
  const weightage112 = 20;
  const weightage113 = 10;
  const weightage121 = 20;
  const weightage122 = 20;
  const kiWeightage12 = 40;
  const weightage131 = 10;
  const weightage132 = 10;
  const weightage133 = 10;
  const weightage134 = 10;
  const kiWeightage13 = 40;
  const weightage141 = 10;
  const weightage142 = 10;
  const kiWeightage14 = 20;
  const criteria1 = 150;

  const weightage211 = 10;
  const weightage212 = 10;
  const kiWeightage21 = 20;
  const weightage221 = 15;
  const weightage222 = 15;
  const kiWeightage22 = 30;
  const weightage231 = 15;
  const weightage232 = 15;
  const weightage233 = 10;
  const weightage234 = 15;
  const kiWeightage23 = 50;
  const weightage241 = 15;
  const weightage242 = 20;
  const weightage243 = 15;
  const kiWeightage24 = 50;
  const weightage251 = 20;
  const weightage252 = 15;
  const weightage253 = 15;
  const kiWeightage25 = 50;
  const weightage261 = 20;
  const weightage262 = 10;
  const weightage263 = 20;
  const kiWeightage26 = 50;
  const weightage271 = 50;
  const kiWeightage27 = 50;
  const criteria2 = 300;

  const weightage311 = 6;
  const weightage312 = 8;
  const weightage313 = 6;
  const kiWeightage31 = 20;
  const weightage321 = 2;
  const weightage322 = 2;
  const weightage323 = 3;
  const weightage324 = 3;
  const kiWeightage32 = 10;
  const weightage331 = 5;
  const weightage332 = 5;
  const kiWeightage33 = 10;
  const weightage341 = 5;
  const weightage342 = 5;
  const weightage343 = 5;
  const weightage344 = 5;
  const weightage345 = 5;
  const weightage346 = 5;
  const kiWeightage34 = 30;
  const weightage351 = 5;
  const weightage352 = 5;
  const kiWeightage35 = 10;
  const weightage361 = 10;
  const weightage362 = 10;
  const weightage363 = 15;
  const weightage364 = 15;
  const kiWeightage36 = 50;
  const weightage371 = 10;
  const weightage372 = 10;
  const kiWeightage37 = 20;
  const criteria3 = 150;

  const weightage411 = 6;
  const weightage412 = 4;
  const kiWeightage41 = 30;
  const weightage421 = 5;
  const kiWeightage42 = 30;
  const weightage431 = 8;
  const kiWeightage43 = 28;
  const weightage442 = 10;
  const kiWeightage44 = 20;
  const weightage413 = 10;
  const weightage414 = 10;
  const weightage422 = 5;
  const weightage423 = 10;
  const weightage424 = 10;
  const weightage432 = 8;
  const weightage433 = 8;
  const weightage434 = 4;
  const weightage441 = 10;
  const criteria4 = 100;

  const weightage511 = 6;
  const weightage512 = 5;
  const weightage513 = 8;
  const weightage514 = 6;
  const weightage515 = 5;
  const kiWeightage51 = 30;
  const weightage521 = 10;
  const weightage522 = 10;
  const weightage523 = 10;
  const kiWeightage52 = 30;
  const weightage531 = 10;
  const weightage533 = 10;
  const kiWeightage53 = 30;
  const weightage542 = 5;
  const kiWeightage54 = 10;
  const weightage532 = 10;
  const weightage541 = 5;
  const criteria5 = 100;

  const weightage611 = 5;
  const weightage612 = 5;
  const kiWeightage61 = 10;
  const weightage621 = 2;
  const weightage622 = 4;
  const kiWeightage62 = 10;
  const weightage631 = 4;
  const kiWeightage63 = 30;
  const weightage641 = 4;
  const weightage643 = 6;
  const kiWeightage64 = 20;
  const weightage651 = 10;
  const weightage652 = 10;
  const kiWeightage65 = 30;
  const weightage623 = 4;
  const weightage632 = 8;
  const weightage633 = 8;
  const weightage634 = 10;
  const weightage642 = 10;
  const weightage653 = 10;
  const criteria6 = 100;

  const weightage711 = 5;
  const weightage713 = 4;
  const weightage718 = 5;
  const weightage719 = 4;
  const weightage7111 = 5;
  const kiWeightage71 = 50;
  const weightage721 = 30;
  const kiWeightage72 = 30;
  const weightage731 = 20;
  const kiWeightage73 = 20;
  const weightage712 = 5;
  const weightage714 = 4;
  const weightage715 = 4;
  const weightage716 = 5;
  const weightage717 = 4;
  const weightage7110 = 5;
  const criteria7 = 100;

  function qlmetricGradeScale(dataValue) {
    if (dataValue <= 0) {
      return 0;
    }
    if (dataValue <= 1) {
      return 1;
    }
    if (dataValue <= 2) {
      return 2;
    }
    if (dataValue <= 3) {
      return 3;
    }
    if (dataValue <= 4) {
      return 4;
    }
    return "";
  }
  function qnmetricGradeScale(dataValue) {
    if (
      (dataValue >= 0 + "%" && dataValue <= 20 + "%")
    || (dataValue >= 0 && dataValue < 20)
    || dataValue === "E. None of the above"
    || dataValue === "E"
    ) {
      return 0;
    }
    if (
      (dataValue >= 21 + "%" && dataValue <= 40 + "%")
    || dataValue === "D. Any one of the above"
    || dataValue === "D"
    || (dataValue >= 20 && dataValue < 60)
    ) {
      return 1;
    }
    if (
      (dataValue >= 41 + "%" && dataValue <= 60 + "%")
    || (dataValue >= 60 && dataValue < 80)
    || dataValue === "C. Any two of the above"
    || dataValue === "C"
    ) {
      return 2;
    }
    if (
      (dataValue >= 61 + "%" && dataValue <= 80 + "%")
    || dataValue === "B. Any three of the above"
    || dataValue === "B"
    || (dataValue >= 80 && dataValue < 100)
    ) {
      return 3;
    }
    if (
      dataValue >= 81 + "%"
    || dataValue === "A. All of the above"
    || dataValue === "A"
    || dataValue >= 100
    ) {
      return 4;
    }
    return "";
  }
  function criteria1Value() {
    return (
      weightage111 * qlmetricGradeScale(dataValueGrade111)
    + weightage112 * qnmetricGradeScale(dataValue112)
    + weightage113 * qnmetricGradeScale(dataValue113)
    + weightage121 * qnmetricGradeScale(dataValue121)
    + weightage122 * qnmetricGradeScale(dataValue122)
    + weightage131 * qlmetricGradeScale(dataValueGrade131)
    + weightage132 * qnmetricGradeScale(dataValue132)
    + weightage133 * qnmetricGradeScale(dataValue133)
    + weightage134 * qnmetricGradeScale(dataValue134)
    + weightage141 * qnmetricGradeScale(dataValue141)
    + weightage142 * qnmetricGradeScale(dataValue142)
    );
  }
  function criteria2Value() {
    return (
      weightage211 * qnmetricGradeScale(dataValue211)
      + weightage212 * qnmetricGradeScale(dataValue212)
      + weightage221 * qlmetricGradeScale(dataValueGrade221)
      + weightage222 * qnmetricGradeScale(dataValue222)
      + weightage231 * qlmetricGradeScale(dataValueGrade231)
      + weightage232 * qlmetricGradeScale(dataValueGrade232)
      + weightage233 * qnmetricGradeScale(dataValue233)
      + weightage234 * qlmetricGradeScale(dataValueGrade234)
      + weightage241 * qnmetricGradeScale(dataValue241)
      + weightage242 * qnmetricGradeScale(dataValue242)
      + weightage243 * qnmetricGradeScale(dataValue243)
      + weightage251 * qnmetricGradeScale(dataValue251)
      + weightage252 * qnmetricGradeScale(dataValue252)
      + weightage253 * qlmetricGradeScale(dataValueGrade253)
      + weightage261 * qlmetricGradeScale(dataValueGrade261)
      + weightage262 * qlmetricGradeScale(dataValueGrade262)
      + weightage263 * qnmetricGradeScale(dataValue263)
      + weightage271 * qnmetricGradeScale(dataValue271)
    );
  }
  function criteria3Value() {
    return (
      weightage311 * qlmetricGradeScale(dataValueGrade311)
      + weightage312 * qnmetricGradeScale(dataValue312)
      + weightage313 * qnmetricGradeScale(dataValue313)
      + weightage321 * qnmetricGradeScale(dataValue321)
      + weightage322 * qnmetricGradeScale(dataValue322)
      + weightage323 * qnmetricGradeScale(dataValue323)
      + weightage324 * qnmetricGradeScale(dataValue324)
      + weightage331 * qlmetricGradeScale(dataValueGrade331)
      + weightage332 * qnmetricGradeScale(dataValue332)
      + weightage341 * qnmetricGradeScale(dataValue341)
      + weightage342 * qnmetricGradeScale(dataValue342)
      + weightage343 * qnmetricGradeScale(dataValue343)
      + weightage344 * qnmetricGradeScale(dataValue344)
      + weightage345 * qnmetricGradeScale(dataValue345)
      + weightage346 * qnmetricGradeScale(dataValue346)
      + weightage351 * qnmetricGradeScale(dataValue351)
      + weightage352 * qnmetricGradeScale(dataValue352)
      + weightage361 * qlmetricGradeScale(dataValueGrade361)
      + weightage362 * qnmetricGradeScale(dataValue362)
      + weightage363 * qnmetricGradeScale(dataValue363)
      + weightage364 * qnmetricGradeScale(dataValue364)
      + weightage371 * qnmetricGradeScale(dataValue371)
      + weightage372 * qnmetricGradeScale(dataValue372)
    );
  }
  function criteria4Value() {
    return (
      weightage411 * qlmetricGradeScale(dataValueGrade411)
      + weightage412 * qlmetricGradeScale(dataValueGrade412)
      + weightage413 * qnmetricGradeScale(dataValue413)
      + weightage414 * qnmetricGradeScale(dataValue414)
      + weightage421 * qlmetricGradeScale(dataValueGrade421)
      + weightage422 * qnmetricGradeScale(dataValue422)
      + weightage423 * qnmetricGradeScale(dataValue423)
      + weightage424 * qnmetricGradeScale(dataValue424)
      + weightage431 * qlmetricGradeScale(dataValueGrade431)
      + weightage432 * qnmetricGradeScale(dataValue432)
      + weightage433 * qnmetricGradeScale(dataValue433)
      + weightage434 * qnmetricGradeScale(dataValue434)
      + weightage442 * qlmetricGradeScale(dataValueGrade442)
      + weightage441 * qnmetricGradeScale(dataValue441)
    );
  }
  function criteria5Value() {
    return (
      weightage511 * qnmetricGradeScale(dataValue511)
      + weightage512 * qnmetricGradeScale(dataValue512)
      + weightage513 * qnmetricGradeScale(dataValue513)
      + weightage514 * qnmetricGradeScale(dataValue514)
      + weightage515 * qnmetricGradeScale(dataValue515)
      + weightage521 * qnmetricGradeScale(dataValue521)
      + weightage522 * qnmetricGradeScale(dataValue522)
      + weightage523 * qnmetricGradeScale(dataValue523)
      + weightage531 * qnmetricGradeScale(dataValue531)
      + weightage532 * qlmetricGradeScale(dataValueGrade532)
      + weightage533 * qnmetricGradeScale(dataValue533)
      + weightage541 * qlmetricGradeScale(dataValueGrade541)
      + weightage542 * qnmetricGradeScale(dataValue542)
    );
  }
  function criteria6Value() {
    return (
      weightage611 * qlmetricGradeScale(dataValueGrade611)
      + weightage612 * qlmetricGradeScale(dataValueGrade612)
      + weightage621 * qlmetricGradeScale(dataValueGrade621)
      + weightage622 * qlmetricGradeScale(dataValueGrade622)
      + weightage623 * qnmetricGradeScale(dataValue623)
      + weightage631 * qlmetricGradeScale(dataValueGrade631)
      + weightage632 * qnmetricGradeScale(dataValue632)
      + weightage633 * qnmetricGradeScale(dataValue633)
      + weightage634 * qnmetricGradeScale(dataValue634)
      + weightage641 * qlmetricGradeScale(dataValueGrade641)
      + weightage643 * qlmetricGradeScale(dataValueGrade643)
      + weightage642 * qnmetricGradeScale(dataValue642)
      + weightage651 * qlmetricGradeScale(dataValueGrade651)
      + weightage652 * qlmetricGradeScale(dataValueGrade652)
      + weightage653 * qnmetricGradeScale(dataValue653)
    );
  }
  function criteria7Value() {
    return (
      weightage711 * qlmetricGradeScale(dataValueGrade711)
      + weightage712 * qnmetricGradeScale(dataValue712)
      + weightage714 * qnmetricGradeScale(dataValue714)
      + weightage715 * qnmetricGradeScale(dataValue715)
      + weightage716 * qnmetricGradeScale(dataValue716)
      + weightage717 * qnmetricGradeScale(dataValue717)
      + weightage7110 * qnmetricGradeScale(dataValue7110)
      + weightage713 * qlmetricGradeScale(dataValueGrade713)
      + weightage718 * qlmetricGradeScale(dataValueGrade718)
      + weightage719 * qlmetricGradeScale(dataValueGrade719)
      + weightage7111 * qlmetricGradeScale(dataValueGrade7111)
      + weightage721 * qlmetricGradeScale(dataValueGrade721)
      + weightage731 * qlmetricGradeScale(dataValueGrade731)
    );
  }

  const criteria1Weightage = criteria1Value();
  const criteria1Grade = parseFloat(criteria1Weightage / criteria1).toFixed(2);
  const criteria11Value = (weightage111 * qlmetricGradeScale(dataValueGrade111) + weightage112 * qnmetricGradeScale(dataValue112) + weightage113 * qnmetricGradeScale(dataValue113));
  const criteria12Value = (weightage121 * qnmetricGradeScale(dataValue121) + weightage122 * qnmetricGradeScale(dataValue122));
  const criteria13Value = (weightage131 * qlmetricGradeScale(dataValueGrade131) + weightage132 * qnmetricGradeScale(dataValue132) + weightage133 * qnmetricGradeScale(dataValue133) + weightage134 * qnmetricGradeScale(dataValue134));
  const criteria14Value = (weightage141 * qnmetricGradeScale(dataValue141) + weightage142 * qnmetricGradeScale(dataValue142));

  const criteria2Weightage = criteria2Value();
  const criteria2Grade = parseFloat(criteria2Weightage / criteria2).toFixed(2);
  const criteria21Value = (weightage211 * qnmetricGradeScale(dataValue211) + weightage212 * qnmetricGradeScale(dataValue212));
  const criteria22Value = (weightage221 * qlmetricGradeScale(dataValueGrade221) + weightage222 * qnmetricGradeScale(dataValue222));
  const criteria23Value = (weightage231 * qlmetricGradeScale(dataValueGrade231) + weightage232 * qlmetricGradeScale(dataValueGrade232) + weightage233 * qnmetricGradeScale(dataValue233) + weightage234 * qlmetricGradeScale(dataValueGrade234));
  const criteria24Value = (weightage241 * qnmetricGradeScale(dataValue241) + weightage242 * qnmetricGradeScale(dataValue242) + weightage243 * qnmetricGradeScale(dataValue243));
  const criteria25Value = (weightage251 * qnmetricGradeScale(dataValue251) + weightage252 * qnmetricGradeScale(dataValue252) + weightage253 * qlmetricGradeScale(dataValueGrade253));
  const criteria26Value = (weightage261 * qlmetricGradeScale(dataValueGrade261) + weightage262 * qlmetricGradeScale(dataValueGrade262) + weightage263 * qnmetricGradeScale(dataValue263));
  const criteria27Value = (weightage271 * qnmetricGradeScale(dataValue271));

  const criteria3Weightage = criteria3Value();
  const criteria3Grade = parseFloat(criteria3Weightage / criteria3).toFixed(2);
  const criteria31Value = (weightage311 * qlmetricGradeScale(dataValueGrade311) + weightage312 * qnmetricGradeScale(dataValue312) + weightage313 * qnmetricGradeScale(dataValue313));
  const criteria32Value = (weightage321 * qnmetricGradeScale(dataValue321) + weightage322 * qnmetricGradeScale(dataValue322) + weightage323 * qnmetricGradeScale(dataValue323) + weightage324 * qnmetricGradeScale(dataValue324));
  const criteria33Value = (weightage331 * qlmetricGradeScale(dataValueGrade331) + weightage332 * qnmetricGradeScale(dataValue332));
  const criteria34Value = (weightage341 * qnmetricGradeScale(dataValue341) + weightage342 * qnmetricGradeScale(dataValue342) + weightage343 * qnmetricGradeScale(dataValue343) + weightage344 * qnmetricGradeScale(dataValue344) + weightage345 * qnmetricGradeScale(dataValue345) + weightage346 * qnmetricGradeScale(dataValue346));
  const criteria35Value = (weightage351 * qnmetricGradeScale(dataValue351) + weightage352 * qnmetricGradeScale(dataValue352));
  const criteria36Value = (weightage361 * qlmetricGradeScale(dataValueGrade361) + weightage362 * qnmetricGradeScale(dataValue362) + weightage363 * qnmetricGradeScale(dataValue363) + weightage364 * qnmetricGradeScale(dataValue364));
  const criteria37Value = (weightage371 * qnmetricGradeScale(dataValue371) + weightage372 * qnmetricGradeScale(dataValue372));

  const criteria4Weightage = criteria4Value();
  const criteria4Grade = parseFloat(criteria4Weightage / criteria4).toFixed(2);
  const criteria41Value = (weightage411 * qlmetricGradeScale(dataValueGrade411) + weightage412 * qlmetricGradeScale(dataValueGrade412) + weightage413 * qnmetricGradeScale(dataValue413) + weightage414 * qnmetricGradeScale(dataValue414));
  const criteria42Value = (weightage421 * qlmetricGradeScale(dataValueGrade421) + weightage422 * qnmetricGradeScale(dataValue422) + weightage423 * qnmetricGradeScale(dataValue423) + weightage424 * qnmetricGradeScale(dataValue424));
  const criteria43Value = (weightage431 * qlmetricGradeScale(dataValueGrade431) + weightage432 * qnmetricGradeScale(dataValue432) + weightage433 * qnmetricGradeScale(dataValue433) + weightage434 * qnmetricGradeScale(dataValue434));
  const criteria44Value = (weightage442 * qlmetricGradeScale(dataValueGrade442) + weightage441 * qnmetricGradeScale(dataValue441));

  const criteria5Weightage = criteria5Value();
  const criteria5Grade = parseFloat(criteria5Weightage / criteria5).toFixed(2);
  const criteria51Value = (weightage511 * qnmetricGradeScale(dataValue511) + weightage512 * qnmetricGradeScale(dataValue512) + weightage513 * qnmetricGradeScale(dataValue513) + weightage514 * qnmetricGradeScale(dataValue514) + weightage515 * qnmetricGradeScale(dataValue515));
  const criteria52Value = (weightage521 * qnmetricGradeScale(dataValue521) + weightage522 * qnmetricGradeScale(dataValue522) + weightage523 * qnmetricGradeScale(dataValue523));
  const criteria53Value = (weightage531 * qnmetricGradeScale(dataValue531) + weightage532 * qlmetricGradeScale(dataValueGrade532) + weightage533 * qnmetricGradeScale(dataValue533));
  const criteria54Value = (weightage541 * qlmetricGradeScale(dataValueGrade541) + weightage542 * qnmetricGradeScale(dataValue542));

  const criteria6Weightage = criteria6Value();
  const criteria6Grade = parseFloat(criteria6Weightage / criteria6).toFixed(2);
  const criteria61Value = (weightage611 * qlmetricGradeScale(dataValueGrade611) + weightage612 * qlmetricGradeScale(dataValueGrade612));
  const criteria62Value = (weightage621 * qlmetricGradeScale(dataValueGrade621) + weightage622 * qlmetricGradeScale(dataValueGrade622) + weightage623 * qnmetricGradeScale(dataValue623));
  const criteria63Value = (weightage631 * qlmetricGradeScale(dataValueGrade631) + weightage632 * qnmetricGradeScale(dataValue632) + weightage633 * qnmetricGradeScale(dataValue633) + weightage634 * qnmetricGradeScale(dataValue634));
  const criteria64Value = (weightage641 * qlmetricGradeScale(dataValueGrade641) + weightage643 * qlmetricGradeScale(dataValueGrade643) + weightage642 * qnmetricGradeScale(dataValue642));
  const criteria65Value = (weightage651 * qlmetricGradeScale(dataValueGrade651) + weightage652 * qlmetricGradeScale(dataValueGrade652) + weightage653 * qnmetricGradeScale(dataValue653));

  const criteria7Weightage = criteria7Value();
  const criteria7Grade = parseFloat(criteria7Weightage / criteria7).toFixed(2);
  const criteria71Value = (weightage711 * qlmetricGradeScale(dataValueGrade711) + weightage712 * qnmetricGradeScale(dataValue712) + weightage714 * qnmetricGradeScale(dataValue714) + weightage715 * qnmetricGradeScale(dataValue715) + weightage716 * qnmetricGradeScale(dataValue716) + weightage717 * qnmetricGradeScale(dataValue717) + weightage7110 * qnmetricGradeScale(dataValue7110) + weightage713 * qlmetricGradeScale(dataValueGrade713) + weightage718 * qlmetricGradeScale(dataValueGrade718) + weightage719 * qlmetricGradeScale(dataValueGrade719) + weightage7111 * qlmetricGradeScale(dataValueGrade7111));
  const criteria72Value = (weightage721 * qlmetricGradeScale(dataValueGrade721));
  const criteria73Value = (weightage731 * qlmetricGradeScale(dataValueGrade731));

  console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
  let instituteType = AuthService.getCurrentUser().instituteType;
  const collegeId = AuthService.getCurrentUser().collegeId;
  const d = new Date();
  let currYear = d.getFullYear();
  let fYear = parseInt(currYear,10) - 1 + "-" + currYear;
  console.log("current year==" + fYear);

  const inputDataList = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: "autonomous",
    },
    qulitativequantitativeList: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 1,

        qnqlt1: "" + weightage111 * qlmetricGradeScale(dataValueGrade111),
        qnqlt2: parseFloat(criteria11Value / kiWeightage11).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria11Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 2,
        qnqlt1: "" + weightage112 * qnmetricGradeScale(dataValue112),
        qnqlt2: parseFloat(criteria11Value / kiWeightage11).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria11Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 3,
        qnqlt1: "" + weightage113 * qnmetricGradeScale(dataValue113),
        qnqlt2: parseFloat(criteria11Value / kiWeightage11).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria11Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 4,
        qnqlt1: "" + weightage121 * qnmetricGradeScale(dataValue121),
        qnqlt2: parseFloat(criteria12Value / kiWeightage12).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria12Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 5,
        qnqlt1: "" + weightage122 * qnmetricGradeScale(dataValue122),
        qnqlt2: parseFloat(criteria12Value / kiWeightage12).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria12Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 6,

        qnqlt1: "" + weightage131 * qlmetricGradeScale(dataValueGrade131),
        qnqlt2: parseFloat(criteria13Value / kiWeightage13).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria13Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 7,
        qnqlt1: "" + weightage132 * qnmetricGradeScale(dataValue132),
        qnqlt2: parseFloat(criteria13Value / kiWeightage13).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria13Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 8,
        qnqlt1: "" + weightage133 * qnmetricGradeScale(dataValue133),
        qnqlt2: parseFloat(criteria13Value / kiWeightage13).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria13Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 9,
        qnqlt1: "" + weightage134 * qnmetricGradeScale(dataValue134),
        qnqlt2: parseFloat(criteria13Value / kiWeightage13).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria13Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 10,
        qnqlt1: "" + weightage141 * qnmetricGradeScale(dataValue141),
        qnqlt2: parseFloat(criteria14Value / kiWeightage14).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria14Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 11,
        qnqlt1: "" + weightage142 * qnmetricGradeScale(dataValue142),
        qnqlt2: parseFloat(criteria14Value / kiWeightage14).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria14Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 12,
        qnqlt1: "" + weightage211 * qnmetricGradeScale(dataValue211),
        qnqlt2: parseFloat(criteria21Value / kiWeightage21).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria21Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 13,
        qnqlt1: "" + weightage212 * qnmetricGradeScale(dataValue212),
        qnqlt2: parseFloat(criteria21Value / kiWeightage21).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria21Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 14,

        qnqlt1: "" + weightage221 * qlmetricGradeScale(dataValueGrade221),
        qnqlt2: parseFloat(criteria22Value / kiWeightage22).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria22Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 15,
        qnqlt1: "" + weightage222 * qnmetricGradeScale(dataValue222),
        qnqlt2: parseFloat(criteria22Value / kiWeightage22).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria22Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 16,

        qnqlt1: "" + weightage231 * qlmetricGradeScale(dataValueGrade231),
        qnqlt2: parseFloat(criteria23Value / kiWeightage23).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria23Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 17,

        qnqlt1: "" + weightage232 * qlmetricGradeScale(dataValueGrade232),
        qnqlt2: parseFloat(criteria23Value / kiWeightage23).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria23Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 18,
        qnqlt1: "" + weightage233 * qnmetricGradeScale(dataValue233),
        qnqlt2: parseFloat(criteria23Value / kiWeightage23).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria23Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 19,

        qnqlt1: "" + weightage234 * qlmetricGradeScale(dataValueGrade234),
        qnqlt2: parseFloat(criteria23Value / kiWeightage23).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria23Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 20,

        qnqlt1: "" + weightage241 * qnmetricGradeScale(dataValue241),
        qnqlt2: parseFloat(criteria24Value / kiWeightage24).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria24Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 21,

        qnqlt1: "" + weightage242 * qnmetricGradeScale(dataValue242),
        qnqlt2: parseFloat(criteria24Value / kiWeightage24).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria24Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 22,

        qnqlt1: "" + weightage243 * qnmetricGradeScale(dataValue243),
        qnqlt2: parseFloat(criteria24Value / kiWeightage24).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria24Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 23,

        qnqlt1: "" + weightage251 * qnmetricGradeScale(dataValue251),
        qnqlt2: parseFloat(criteria25Value / kiWeightage25).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria25Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 24,

        qnqlt1: "" + weightage252 * qnmetricGradeScale(dataValue252),
        qnqlt2: parseFloat(criteria25Value / kiWeightage25).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria25Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 25,

        qnqlt1: "" + weightage253 * qlmetricGradeScale(dataValueGrade253),
        qnqlt2: parseFloat(criteria25Value / kiWeightage25).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria25Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 26,

        qnqlt1: "" + weightage261 * qlmetricGradeScale(dataValueGrade261),
        qnqlt2: parseFloat(criteria26Value / kiWeightage26).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria26Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 27,

        qnqlt1: "" + weightage262 * qlmetricGradeScale(dataValueGrade262),
        qnqlt2: parseFloat(criteria26Value / kiWeightage26).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria26Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 28,

        qnqlt1: "" + weightage263 * qnmetricGradeScale(dataValue263),
        qnqlt2: parseFloat(criteria26Value / kiWeightage26).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria26Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 29,

        qnqlt1: "" + weightage271 * qnmetricGradeScale(dataValue271),
        qnqlt2: parseFloat(criteria27Value / kiWeightage27).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria27Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 30,

        qnqlt1: "" + weightage311 * qlmetricGradeScale(dataValueGrade311),
        qnqlt2: parseFloat(criteria31Value / kiWeightage31).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria31Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 31,

        qnqlt1: "" + weightage312 * qnmetricGradeScale(dataValue312),
        qnqlt2: parseFloat(criteria31Value / kiWeightage31).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria31Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 32,

        qnqlt1: "" + weightage313 * qnmetricGradeScale(dataValue313),
        qnqlt2: parseFloat(criteria31Value / kiWeightage31).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria31Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 33,

        qnqlt1: "" + weightage321 * qnmetricGradeScale(dataValue321),
        qnqlt2: parseFloat(criteria32Value / kiWeightage32).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria32Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 34,

        qnqlt1: "" + weightage323 * qnmetricGradeScale(dataValue323),
        qnqlt2: parseFloat(criteria32Value / kiWeightage32).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria32Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 35,

        qnqlt1: "" + weightage324 * qnmetricGradeScale(dataValue324),
        qnqlt2: parseFloat(criteria32Value / kiWeightage32).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria32Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 36,

        qnqlt1: "" + weightage331 * qlmetricGradeScale(dataValueGrade331),
        qnqlt2: parseFloat(criteria33Value / kiWeightage33).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria33Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 37,

        qnqlt1: "" + weightage332 * qnmetricGradeScale(dataValue332),
        qnqlt2: parseFloat(criteria33Value / kiWeightage33).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria33Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 38,

        qnqlt1: "" + weightage341 * qnmetricGradeScale(dataValue341),
        qnqlt2: parseFloat(criteria34Value / kiWeightage34).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria34Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 39,

        qnqlt1: "" + weightage342 * qnmetricGradeScale(dataValue342),
        qnqlt2: parseFloat(criteria34Value / kiWeightage34).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria34Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 40,

        qnqlt1: "" + weightage343 * qnmetricGradeScale(dataValue343),
        qnqlt2: parseFloat(criteria34Value / kiWeightage34).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria34Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 41,

        qnqlt1: "" + weightage344 * qnmetricGradeScale(dataValue344),
        qnqlt2: parseFloat(criteria34Value / kiWeightage34).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria34Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 42,

        qnqlt1: "" + weightage345 * qnmetricGradeScale(dataValue345),
        qnqlt2: parseFloat(criteria34Value / kiWeightage34).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria34Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 43,

        qnqlt1: "" + weightage346 * qnmetricGradeScale(dataValue346),
        qnqlt2: parseFloat(criteria34Value / kiWeightage34).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria34Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 44,

        qnqlt1: "" + weightage351 * qnmetricGradeScale(dataValue351),
        qnqlt2: parseFloat(criteria35Value / kiWeightage35).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria35Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 45,

        qnqlt1: "" + weightage352 * qnmetricGradeScale(dataValue352),
        qnqlt2: parseFloat(criteria35Value / kiWeightage35).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria35Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 46,

        qnqlt1: "" + weightage361 * qlmetricGradeScale(dataValueGrade361),
        qnqlt2: parseFloat(criteria36Value / kiWeightage36).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria36Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 47,

        qnqlt1: "" + weightage362 * qnmetricGradeScale(dataValue362),
        qnqlt2: parseFloat(criteria36Value / kiWeightage36).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria36Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 48,

        qnqlt1: "" + weightage363 * qnmetricGradeScale(dataValue363),
        qnqlt2: parseFloat(criteria36Value / kiWeightage36).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria36Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 49,

        qnqlt1: "" + weightage364 * qnmetricGradeScale(dataValue364),
        qnqlt2: parseFloat(criteria36Value / kiWeightage36).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria36Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 50,

        qnqlt1: "" + weightage371 * qnmetricGradeScale(dataValue371),
        qnqlt2: parseFloat(criteria37Value / kiWeightage37).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria37Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 51,

        qnqlt1: "" + weightage372 * qnmetricGradeScale(dataValue372),
        qnqlt2: parseFloat(criteria37Value / kiWeightage37).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria37Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 52,

        qnqlt1: "" + weightage411 * qlmetricGradeScale(dataValueGrade411),
        qnqlt2: parseFloat(criteria41Value / kiWeightage41).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria41Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 53,

        qnqlt1: "" + weightage412 * qlmetricGradeScale(dataValueGrade412),
        qnqlt2: parseFloat(criteria41Value / kiWeightage41).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria41Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 54,

        qnqlt1: "" + weightage413 * qnmetricGradeScale(dataValue413),
        qnqlt2: parseFloat(criteria41Value / kiWeightage41).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria41Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 55,

        qnqlt1: "" + weightage414 * qnmetricGradeScale(dataValue414),
        qnqlt2: parseFloat(criteria41Value / kiWeightage41).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria41Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 56,

        qnqlt1: "" + weightage421 * qlmetricGradeScale(dataValueGrade421),
        qnqlt2: parseFloat(criteria42Value / kiWeightage42).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria42Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 57,

        qnqlt1: "" + weightage422 * qnmetricGradeScale(dataValue422),
        qnqlt2: parseFloat(criteria42Value / kiWeightage42).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria42Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 58,

        qnqlt1: "" + weightage423 * qnmetricGradeScale(dataValue423),
        qnqlt2: parseFloat(criteria42Value / kiWeightage42).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria42Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 59,

        qnqlt1: "" + weightage424 * qnmetricGradeScale(dataValue424),
        qnqlt2: parseFloat(criteria42Value / kiWeightage42).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria42Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 60,

        qnqlt1: "" + weightage431 * qlmetricGradeScale(dataValueGrade431),
        qnqlt2: parseFloat(criteria43Value / kiWeightage43).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria43Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 61,

        qnqlt1: "" + weightage432 * qnmetricGradeScale(dataValue432),
        qnqlt2: parseFloat(criteria43Value / kiWeightage43).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria43Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 62,

        qnqlt1: "" + weightage433 * qnmetricGradeScale(dataValue433),
        qnqlt2: parseFloat(criteria43Value / kiWeightage43).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria43Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 63,

        qnqlt1: "" + weightage434 * qnmetricGradeScale(dataValue434),
        qnqlt2: parseFloat(criteria43Value / kiWeightage43).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria43Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 64,

        qnqlt1: "" + weightage441 * qnmetricGradeScale(dataValue441),
        qnqlt2: parseFloat(criteria44Value / kiWeightage44).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria44Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 65,

        qnqlt1: "" + weightage442 * qlmetricGradeScale(dataValueGrade442),
        qnqlt2: parseFloat(criteria44Value / kiWeightage44).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria44Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 66,

        qnqlt1: "" + weightage511 * qnmetricGradeScale(dataValue511),
        qnqlt2: parseFloat(criteria51Value / kiWeightage51).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria51Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 67,

        qnqlt1: "" + weightage512 * qnmetricGradeScale(dataValue512),
        qnqlt2: parseFloat(criteria51Value / kiWeightage51).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria51Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 68,

        qnqlt1: "" + weightage513 * qnmetricGradeScale(dataValue513),
        qnqlt2: parseFloat(criteria51Value / kiWeightage51).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria51Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 69,

        qnqlt1: "" + weightage514 * qnmetricGradeScale(dataValue514),
        qnqlt2: parseFloat(criteria51Value / kiWeightage51).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria51Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 70,

        qnqlt1: "" + weightage515 * qnmetricGradeScale(dataValue515),
        qnqlt2: parseFloat(criteria51Value / kiWeightage51).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria51Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 71,

        qnqlt1: "" + weightage521 * qnmetricGradeScale(dataValue521),
        qnqlt2: parseFloat(criteria52Value / kiWeightage52).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria52Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 72,

        qnqlt1: "" + weightage522 * qnmetricGradeScale(dataValue522),
        qnqlt2: parseFloat(criteria52Value / kiWeightage52).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria52Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 73,

        qnqlt1: "" + weightage523 * qnmetricGradeScale(dataValue523),
        qnqlt2: parseFloat(criteria52Value / kiWeightage52).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria52Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 74,

        qnqlt1: "" + weightage531 * qnmetricGradeScale(dataValue531),
        qnqlt2: parseFloat(criteria53Value / kiWeightage53).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria53Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 75,

        qnqlt1: "" + weightage532 * qlmetricGradeScale(dataValueGrade532),
        qnqlt2: parseFloat(criteria53Value / kiWeightage53).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria53Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 76,

        qnqlt1: "" + weightage533 * qnmetricGradeScale(dataValue533),
        qnqlt2: parseFloat(criteria53Value / kiWeightage53).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria53Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 77,

        qnqlt1: "" + weightage541 * qlmetricGradeScale(dataValueGrade541),
        qnqlt2: parseFloat(criteria54Value / kiWeightage54).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria54Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 78,

        qnqlt1: "" + weightage542 * qnmetricGradeScale(dataValue542),
        qnqlt2: parseFloat(criteria54Value / kiWeightage54).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria54Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 79,

        qnqlt1: "" + weightage611 * qlmetricGradeScale(dataValueGrade611),
        qnqlt2: parseFloat(criteria61Value / kiWeightage61).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria61Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 80,

        qnqlt1: "" + weightage612 * qlmetricGradeScale(dataValueGrade612),
        qnqlt2: parseFloat(criteria61Value / kiWeightage61).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria61Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 81,

        qnqlt1: "" + weightage622 * qlmetricGradeScale(dataValueGrade622),
        qnqlt2: parseFloat(criteria62Value / kiWeightage62).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria62Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 82,

        qnqlt1: "" + weightage623 * qnmetricGradeScale(dataValue623),
        qnqlt2: parseFloat(criteria62Value / kiWeightage62).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria62Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 83,

        qnqlt1: "" + weightage631 * qlmetricGradeScale(dataValueGrade631),
        qnqlt2: parseFloat(criteria63Value / kiWeightage63).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria63Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 84,

        qnqlt1: "" + weightage632 * qnmetricGradeScale(dataValue632),
        qnqlt2: parseFloat(criteria63Value / kiWeightage63).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria63Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 85,

        qnqlt1: "" + weightage633 * qnmetricGradeScale(dataValue633),
        qnqlt2: parseFloat(criteria63Value / kiWeightage63).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria63Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 86,

        qnqlt1: "" + weightage634 * qnmetricGradeScale(dataValue634),
        qnqlt2: parseFloat(criteria63Value / kiWeightage63).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria63Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 87,

        qnqlt1: "" + weightage641 * qlmetricGradeScale(dataValueGrade641),
        qnqlt2: parseFloat(criteria64Value / kiWeightage64).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria64Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 88,

        qnqlt1: "" + weightage642 * qnmetricGradeScale(dataValue642),
        qnqlt2: parseFloat(criteria64Value / kiWeightage64).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria64Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 89,
        qnqlt1: "" + weightage643 * qlmetricGradeScale(dataValueGrade643),
        qnqlt2: parseFloat(criteria64Value / kiWeightage64).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria64Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 90,

        qnqlt1: "" + weightage651 * qlmetricGradeScale(dataValueGrade651),
        qnqlt2: parseFloat(criteria65Value / kiWeightage65).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria65Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 91,

        qnqlt1: "" + weightage652 * qlmetricGradeScale(dataValueGrade652),
        qnqlt2: parseFloat(criteria65Value / kiWeightage65).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria65Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 92,

        qnqlt1: "" + weightage653 * qnmetricGradeScale(dataValue653),
        qnqlt2: parseFloat(criteria65Value / kiWeightage65).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria65Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 93,

        qnqlt1: "" + weightage711 * qlmetricGradeScale(dataValueGrade711),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },

      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 94,

        qnqlt1: "" + weightage712 * qnmetricGradeScale(dataValue712),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 95,

        qnqlt1: "" + weightage713 * qlmetricGradeScale(dataValueGrade713),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 96,

        qnqlt1: "" + weightage714 * qnmetricGradeScale(dataValue714),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 97,

        qnqlt1: "" + weightage715 * qnmetricGradeScale(dataValue715),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 98,

        qnqlt1: "" + weightage716 * qnmetricGradeScale(dataValue716),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 99,

        qnqlt1: "" + weightage717 * qnmetricGradeScale(dataValue717),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 100,

        qnqlt1: "" + weightage718 * qlmetricGradeScale(dataValueGrade718),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 101,

        qnqlt1: "" + weightage719 * qlmetricGradeScale(dataValueGrade719),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 102,

        qnqlt1: "" + weightage7110 * qnmetricGradeScale(dataValue7110),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 103,

        qnqlt1: "" + weightage7111 * qlmetricGradeScale(dataValueGrade7111),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 104,

        qnqlt1: "" + weightage721 * qlmetricGradeScale(dataValueGrade721),
        qnqlt2: parseFloat(criteria72Value / kiWeightage72).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria72Value,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 105,

        qnqlt1: "" + weightage731 * qlmetricGradeScale(dataValueGrade731),
        qnqlt2: parseFloat(criteria73Value / kiWeightage73).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria73Value,
      },
    ],
    criteriaWise: [
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 1,
        criterionWiseWeighted: criteria1Weightage,
        criterionWiseGrade: criteria1Grade,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 2,
        criterionWiseWeighted: criteria2Weightage,
        criterionWiseGrade: criteria2Grade,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 3,
        criterionWiseWeighted: criteria3Weightage,
        criterionWiseGrade: criteria3Grade,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 4,
        criterionWiseWeighted: criteria4Weightage,
        criterionWiseGrade: criteria4Grade,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 5,
        criterionWiseWeighted: criteria5Weightage,
        criterionWiseGrade: criteria5Grade,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 6,
        criterionWiseWeighted: criteria6Weightage,
        criterionWiseGrade: criteria6Grade,
      },
      {
        criteriaId: {
          collegeId: collegeId,
          financialYear: fYear,
          typeofInstitution: "autonomous",
        },
        uniqueKey1: 7,
        criterionWiseWeighted: criteria7Weightage,
        criterionWiseGrade: criteria7Grade,
      },
    ]
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  function onClickingSave() {
    console.log("insert data is =>" + JSON.stringify(inputDataList));
    const qnqlData = new FormData();
    console.log("formdata---->", qnqlData);
    qnqlData.append("qualitativeQuantitativeInfo1", jsonBlob(inputDataList));
    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: qnqlData,
    };
    fetch(
      resources.APPLICATION_URL+"QualityReportData",
      filesFetchMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Inserted Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }
  return (
    <div className="main-container">
      <div className="eachTable-container">
        <table>
          <tr style={{ textAlign: "center" }}>
            <th style={{ width: '80px' }}>S.No</th>
            <th style={{ width: '150px' }}>Criteria</th>
            <th style={{ width: '200px' }}>Key Indicator</th>
            <th style={{ width: '90px' }}>Metric No.</th>
            <th style={{ width: '90px' }}>QI/QN</th>
            <th style={{ width: '300px' }}>Description</th>
            <th style={{ width: '70px' }}>W</th>
            <th style={{ width: '80px' }}>KI(W)</th>
            <th style={{ width: '100px' }}>Criteria(W)</th>
            <th style={{ width: '130px', overflow: "auto" }}>
            ADVV - 2  (Adiverse data validation) Response
            </th>
            <th style={{ width: '120px' }}>Metric Grade scale (0-4)</th>
            <th style={{ width: '120px' }}>
              Metric wise weighted Grade points
            </th>
            <th style={{ width: '120px' }}>KI wise Weighted Grade</th>
            <th style={{ width: '120px' }}>KI wise Grade Point Average</th>
            <th style={{ width: '100px' }}>Criteria (W)</th>
            <th style={{ width: '120px' }}>
              Criteria wise Grade Point Average
            </th>
          </tr>
          <tr>
            <td>1.</td>
            <td rowspan="11">Curricular Aspects</td>
            <td rowspan="3">Curriculum Planning and Implementation</td>
            <td>1.1.1</td>
            <td>QI</td>
            <td>
              Curricula developed and implemented have relevance to the local,
              national, regional and global developmental needs which is
              reflected in Programme outcomes (POs), Programme Specific
              Outcomes(PSOs) and Course Outcomes(COs) of the Programmes offered
              by the Institution.
            </td>
            <td>{weightage111}</td>
            <td rowspan="3">{kiWeightage11}</td>
            <td rowspan="11">{criteria1}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue111}
                onChange={(e) => {
                  setDataValue111(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade111}
                onChange={(e) => {
                  setDataValueGrade111(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage111 * qlmetricGradeScale(dataValueGrade111)}</p>
            </td>
            <td rowSpan="3">
              <p>{criteria11Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteria11Value / kiWeightage11).toFixed(2)}</p>
            </td>
            <td rowSpan="11">
              <p>{criteria1Weightage}</p>
            </td>
            <td rowSpan="11">
              <p>{criteria1Grade}</p>
            </td>
          </tr>
          <tr>
            <td>2.</td>
            <td>1.1.2</td>
            <td>QN</td>
            <td>
              Percentage of Programmes where syllabus revision was carried out
              during the last five years.
            </td>
            <td>{weightage112}</td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValue112}
                onChange={(e) => {
                  setDataValue112(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue112)}</p>
            </td>
            <td>
              <p>{weightage112 * qnmetricGradeScale(dataValue112)}</p>
            </td>
          </tr>
          <tr>
            <td>3.</td>
            <td>1.1.3</td>
            <td>QN</td>
            <td>
              Average percentage of courses having focus on employability/
              entrepreneurship/ skill development offered by the institution
              during the last five years.
            </td>
            <td>{weightage113}</td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValue113}
                onChange={(e) => {
                  setDataValue113(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue113)}</p>
            </td>
            <td>
              <p>{weightage113 * qnmetricGradeScale(dataValue113)}</p>
            </td>
          </tr>
          <tr>
            <td>4.</td>
            <td rowspan="2">Academic Flexibility</td>
            <td>1.2.1</td>
            <td>QN</td>
            <td>
              {' '}
              Percentage of new courses introduced of the total number of
              courses across all programs offered during the last five years.
            </td>
            <td>{weightage121}</td>
            <td rowspan="2">{kiWeightage12}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue121}
                value={dataValue121}
                onChange={(e) => {
                  setDataValue121(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue121)}</p>
            </td>
            <td>
              <p>{weightage121 * qnmetricGradeScale(dataValue121)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteria12Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria12Value / kiWeightage12).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>5.</td>
            <td>1.2.2</td>
            <td>QN</td>
            <td>
              Percentage of Programmes in which Choice Based Credit System
              (CBCS) / elective course system has been implemented (Data for the
              latest completed academic year).
            </td>
            <td>{weightage122}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue122}
                value={dataValue122}
                onChange={(e) => {
                  setDataValue122(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue122)}</p>
            </td>
            <td>
              <p>{weightage122 * qnmetricGradeScale(dataValue122)}</p>
            </td>
          </tr>
          <tr>
            <td>6.</td>
            <td rowspan="4">Curriculum Enrichment</td>
            <td>1.3.1</td>
            <td>QI</td>
            <td>
              Institution integrates crosscutting issues relevant to
              Professional Ethics ,Gender, Human Values ,Environment and
              Sustainability into the Curriculum.
            </td>
            <td>{weightage131}</td>
            <td rowspan="4">{kiWeightage13}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue131}
                onChange={(e) => {
                  setDataValue131(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade131}
                onChange={(e) => {
                  setDataValueGrade131(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage131 * qlmetricGradeScale(dataValueGrade131)}</p>
            </td>
            <td rowSpan="4">
              {criteria13Value}
            </td>
            <td rowSpan="4">
              <p>{parseFloat(criteria13Value / kiWeightage11).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>7.</td>
            <td>1.3.2</td>
            <td>QN</td>
            <td>
              Number of value-added courses for imparting transferable and life
              skills offered during last five years.
            </td>
            <td>{weightage132}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue132}
                value={dataValue132}
                onChange={(e) => {
                  setDataValue132(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue132)}</p>
            </td>
            <td>
              <p>{weightage132 * qnmetricGradeScale(dataValue132)}</p>
            </td>
          </tr>
          <tr>
            <td>8.</td>
            <td>1.3.3</td>
            <td>QN</td>
            <td>
              Average Percentage of students enrolled in the courses under 1.3.2
              above.
            </td>
            <td>{weightage133}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue133}
                value={dataValue133}
                onChange={(e) => {
                  setDataValue133(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue133)}</p>
            </td>
            <td>
              <p>{weightage133 * qnmetricGradeScale(dataValue133)}</p>
            </td>
          </tr>
          <tr>
            <td>9.</td>
            <td>1.3.4</td>
            <td>QN</td>
            <td>
              Percentage of students undertaking field projects/ internships /
              student projects (Data for the latest completed academic year).
            </td>
            <td>{weightage134}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue134}
                value={dataValue134}
                onChange={(e) => {
                  setDataValue134(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue134)}</p>
            </td>
            <td>
              <p>{weightage134 * qnmetricGradeScale(dataValue134)}</p>
            </td>
          </tr>
          <tr>
            <td>10.</td>
            <td rowspan="2">Feedback System</td>
            <td>1.4.1</td>
            <td>QN</td>
            <td>
              Structured feedback for design and review of syllabus ( semester
              wise / year wise) is obtained from 1-Students, 2-Teachers, 3-Employers,
              4-Alumni.
            </td>
            <td>{weightage141}</td>
            <td rowspan="2">{kiWeightage14}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue141}
                value={dataValue141}
                onChange={(e) => {
                  setDataValue141(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue141)}</p>
            </td>
            <td>
              <p>{weightage141 * qnmetricGradeScale(dataValue141)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteria14Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria14Value / kiWeightage14).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>11.</td>
            <td>1.4.2</td>
            <td>QN</td>
            <td>
              Structured feedback for design and review of syllabus ( semester
              wise / year wise) is obtained from (1) Students, (2) Teachers, (3)
              Employers, (4) Alumni Options.
            </td>
            <td>{weightage142}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue142}
                value={dataValue142}
                onChange={(e) => {
                  setDataValue142(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue142)}</p>
            </td>
            <td>
              <p>{weightage142 * qnmetricGradeScale(dataValue142)}</p>
            </td>
          </tr>
          <tr>
            <td>12.</td>
            <td rowspan="18">Teaching Learning and Evaluation</td>
            <td rowspan="2">Student Enrolment and Profile</td>
            <td>2.1.1</td>
            <td>QN</td>
            <td>Average Enrolment percentage (Average of last five years)</td>
            <td>{weightage211}</td>
            <td rowspan="2">{kiWeightage21}</td>
            <td rowspan="18">{criteria2}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue211}
                value={dataValue211}
                onChange={(e) => {
                  setDataValue211(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue211)}</p>
            </td>
            <td>
              <p>{weightage211 * qnmetricGradeScale(dataValue211)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteria21Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria21Value / kiWeightage21).toFixed(2)}</p>
            </td>
            <td rowSpan="18">
              <p>{criteria2Weightage}</p>
            </td>
            <td rowSpan="18">
              <p>{criteria2Grade}</p>
            </td>
          </tr>
          <tr>
            <td>13.</td>
            <td>2.1.2</td>
            <td>QN</td>
            <td>
              Average percentage of seats filled against reserved categories
              (SC, ST, OBC, Divyangjan, etc.as per applicable reservation policy
              ) during the last five years ( exclusive of supernumerary seats)
            </td>
            <td>{weightage212}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue212}
                value={dataValue212}
                onChange={(e) => {
                  setDataValue212(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue212)}</p>
            </td>
            <td>
              <p>{weightage212 * qnmetricGradeScale(dataValue212)}</p>
            </td>
          </tr>
          <tr>
            <td>14.</td>
            <td rowspan="2">Catering to Student Diversity</td>
            <td>2.2.1</td>
            <td>QI</td>
            <td>
              The institution assesses the learning levels of the students and
              organises special Programmes for advanced learners and slow
              learners
            </td>
            <td>{weightage221}</td>
            <td rowspan="2">{kiWeightage21}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue221}
                onChange={(e) => {
                  setDataValue221(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade221}
                onChange={(e) => {
                  setDataValueGrade221(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage221 * qlmetricGradeScale(dataValueGrade221)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteria22Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria22Value / kiWeightage22).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>15.</td>
            <td>2.2.2</td>
            <td>QN</td>
            <td>
              Student - Full time teacher ratio (Data for the latest completed
              academic year) The institution provides seed money to its teachers
              for research.
            </td>
            <td>{weightage222}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue222}
                value={dataValue222}
                onChange={(e) => {
                  setDataValue222(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue222)}</p>
            </td>
            <td>
              <p>{weightage222 * qnmetricGradeScale(dataValue222)}</p>
            </td>
          </tr>
          <tr>
            <td>16.</td>
            <td rowspan="4">Teaching-Learning Process</td>
            <td>2.3.1</td>
            <td>QI</td>
            <td>
              Student centric methods, such as experiential learning,
              participative learning and problem solving methodologies are used
              for enhancing learning experiences
            </td>
            <td>{weightage231}</td>
            <td rowspan="4">{kiWeightage23}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue231}
                onChange={(e) => {
                  setDataValue231(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade231}
                onChange={(e) => {
                  setDataValueGrade231(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage231 * qlmetricGradeScale(dataValueGrade231)}</p>
            </td>
            <td rowSpan="4">
              <p>{criteria23Value}</p>
            </td>
            <td rowSpan="4">
              <p>{parseFloat(criteria23Value / kiWeightage23).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>17.</td>
            <td>2.3.2</td>
            <td>QI</td>
            <td>
              Teachers use ICT enabled tools including online resources for
              effective teaching and learning process.
            </td>
            <td>{weightage232}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue232}
                onChange={(e) => {
                  setDataValue232(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade232}
                onChange={(e) => {
                  setDataValueGrade232(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage232 * qlmetricGradeScale(dataValueGrade232)}</p>
            </td>
          </tr>
          <tr>
            <td>18.</td>
            <td>2.3.3</td>
            <td>QN</td>
            <td>
              Ratio of students to mentor for academic and other related issues
              (Data for the latest completed academic year )
            </td>
            <td>{weightage233}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue233}
                value={dataValue233}
                onChange={(e) => {
                  setDataValue233(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue233)}</p>
            </td>
            <td>
              <p>{weightage233 * qnmetricGradeScale(dataValue233)}</p>
            </td>
          </tr>
          <tr>
            <td>19.</td>
            <td>2.3.4</td>
            <td>QL</td>
            <td>
              Average percentage of full time teachers against sanctioned posts
              during the last five years
            </td>
            <td>{weightage234}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue234}
                onChange={(e) => {
                  setDataValue234(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade234}
                onChange={(e) => {
                  setDataValueGrade234(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage234 * qlmetricGradeScale(dataValueGrade234)}</p>
            </td>
          </tr>
          <tr>
            <td>20.</td>
            <td rowspan="3">Teacher Profile and Quality</td>
            <td>2.4.1</td>
            <td>QN</td>
            <td>
              Average number of days from the date of last semester-end/ year-
              end examination till the declaration of results year-wise during
              the last five yearsdsx
            </td>
            <td>{weightage241}</td>
            <td rowspan="3">{kiWeightage24}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue241}
                value={dataValue241}
                onChange={(e) => {
                  setDataValue241(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue241)}</p>
            </td>
            <td>
              <p>{weightage241 * qnmetricGradeScale(dataValue241)}</p>
            </td>
            <td rowSpan="3">
              <p>{criteria24Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteria24Value / kiWeightage24).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>21.</td>
            <td>2.4.2</td>
            <td>QN</td>
            <td>
              {' '}
              Average percentage of full time teachers with Ph. D. / D.M. /
              M.Ch. / D.N.B Superspeciality / D.Sc. / D.Litt. during the last
              five years (consider only highest degree for count).
            </td>
            <td>{weightage242}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue242}
                value={dataValue242}
                onChange={(e) => {
                  setDataValue242(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue242)}</p>
            </td>
            <td>
              <p>{weightage242 * qnmetricGradeScale(dataValue242)}</p>
            </td>
          </tr>
          <tr>
            <td>22.</td>
            <td>2.4.3</td>
            <td>QN</td>
            <td>
              Average teaching experience of full time teachers in the same
              institution (Data for the latest completed academic year in number
              of years)
            </td>
            <td>{weightage243}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue243}
                value={dataValue243}
                onChange={(e) => {
                  setDataValue243(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue243)}</p>
            </td>
            <td>
              <p>{weightage243 * qnmetricGradeScale(dataValue243)}</p>
            </td>
          </tr>
          <tr>
            <td>23.</td>
            <td rowspan="3">Evaluation Process and Reforms</td>
            <td>2.5.1</td>
            <td>QN</td>
            <td>
              Average number of days from the date of last semester-end/ year-
              end examination till the declaration of results year-wise during
              the last five years
            </td>
            <td>{weightage251}</td>
            <td rowspan="3">{kiWeightage25}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue251}
                value={dataValue251}
                onChange={(e) => {
                  setDataValue251(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue251)}</p>
            </td>
            <td>
              <p>{weightage251 * qnmetricGradeScale(dataValue251)}</p>
            </td>
            <td rowSpan="3">
              <p>{criteria25Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteria25Value / kiWeightage25).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>24.</td>
            <td>2.5.2</td>
            <td>QN</td>
            <td>
              Average percentage of student complaints/grievances about
              evaluation against total number appeared in the examinations
              during the last five years
            </td>
            <td>{weightage252}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue252}
                value={dataValue252}
                onChange={(e) => {
                  setDataValue252(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue252)}</p>
            </td>
            <td>
              <p>{weightage252 * qnmetricGradeScale(dataValue252)}</p>
            </td>
          </tr>
          <tr>
            <td>25.</td>
            <td>2.5.3</td>
            <td>QI</td>
            <td>
              IT integration and reforms in the examination procedures and
              processes including Continuous Internal Assessment (CIA) have
              brought in considerable improvement in Examination Management
              System (EMS) of the Institution.
            </td>
            <td>{weightage253}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue253}
                onChange={(e) => {
                  setDataValue253(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade253}
                onChange={(e) => {
                  setDataValueGrade253(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage253 * qlmetricGradeScale(dataValueGrade253)}</p>
            </td>
          </tr>
          <tr>
            <td>26.</td>
            <td rowspan="3">Student Performance and Learning Outcomes</td>
            <td>2.6.1</td>
            <td>QL</td>
            <td>
              Programme and course outcomes for all Programmes offered by the
              institution are stated and displayed on website and communicated
              to teachers and students.
            </td>
            <td>{weightage261}</td>
            <td rowspan="3">{kiWeightage26}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue261}
                onChange={(e) => {
                  setDataValue261(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade261}
                onChange={(e) => {
                  setDataValueGrade261(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage261 * qlmetricGradeScale(dataValueGrade261)}</p>
            </td>
            <td rowspan="3">
              <p>{criteria26Value}</p>
            </td>
            <td rowspan="3">
              <p>{parseFloat(criteria26Value / kiWeightage26).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>27.</td>
            <td>2.6.2</td>
            <td>QL</td>
            <td>
              Attainment of programme outcomes and course outcomes are evaluated
              by the institution.
            </td>
            <td>{weightage262}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue262}
                onChange={(e) => {
                  setDataValue262(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade262}
                onChange={(e) => {
                  setDataValueGrade262(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage262 * qlmetricGradeScale(dataValueGrade262)}</p>
            </td>
          </tr>
          <tr>
            <td>28.</td>
            <td>2.6.3</td>
            <td>QN</td>
            <td>
              {' '}
              Pass Percentage of students(Data for the latest completed academic
              year).
            </td>
            <td>{weightage263}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue263}
                value={dataValue263}
                onChange={(e) => {
                  setDataValue263(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue263)}</p>
            </td>
            <td>
              <p>{weightage263 * qnmetricGradeScale(dataValue263)}</p>
            </td>
          </tr>
          <tr>
            <td>29.</td>
            <td>Student Satisfaction Survey</td>
            <td>2.7.1</td>
            <td>QN</td>
            <td>
              {' '}
              The institution provides seed money to its teachers for research.
            </td>
            <td>{weightage271}</td>
            <td>{kiWeightage27}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue271}
                value={dataValue271}
                onChange={(e) => {
                  setDataValue271(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue271)}</p>
            </td>
            <td>
              <p>{weightage271 * qnmetricGradeScale(dataValue271)}</p>
            </td>
            <td>
              <p>{criteria27Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria27Value / kiWeightage27).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>30.</td>
            <td rowspan="23">Research, Innovations and Extension</td>
            <td rowspan="3">Promotion of Research and Facilities</td>
            <td>3.1.1</td>
            <td>QI</td>
            <td>The institution's Research facilities are frequently updated and there is a well defined policy for promotion of research which is uploaded on the institutional website and implemented.</td>
            <td>{weightage311}</td>
            <td rowspan="3">{kiWeightage31}</td>
            <td rowspan="23">{criteria3}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue311}
                onChange={(e) => {
                  setDataValue311(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade311}
                onChange={(e) => {
                  setDataValueGrade311(e.target.value);
                }}
              />
            </td>
            <td >
              <p>{weightage311 * qlmetricGradeScale(dataValueGrade311)}</p>
            </td>
            <td rowSpan="3">
              <p>{criteria31Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteria31Value / kiWeightage31).toFixed(2)}</p>
            </td>
            <td rowSpan="23">
              <p>{criteria3Weightage}</p>
            </td>
            <td rowSpan="23">
              <p>{criteria3Grade}</p>
            </td>
          </tr>
          <tr>
            <td>31.</td>
            <td>3.1.2</td>
            <td>QN</td>
            <td>The institution provides seed money to its teachers for research.</td>
            <td>{weightage312}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue312}
                value={dataValue312}
                onChange={(e) => {
                  setDataValue312(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue312)}</p>
            </td>
            <td>
              <p>{weightage312 * qnmetricGradeScale(dataValue312)}</p>
            </td>
          </tr>
          <tr>
            <td>32.</td>
            <td>3.1.3</td>
            <td>QN</td>
            <td>Percentage of teachers awarded national/ international fellowship for advanced studies/ research during the last five years.</td>
            <td>{weightage313}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue313}
                value={dataValue313}
                onChange={(e) => {
                  setDataValue313(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue313)}</p>
            </td>
            <td>
              <p>{weightage313 * qnmetricGradeScale(dataValue313)}</p>
            </td>
          </tr>
          <tr>
            <td>30.</td>
            <td rowspan="4">Resource Mobilization for Research</td>
            <td>3.2.1</td>
            <td>QN</td>
            <td>Grants received from Government and non-governmental agencies for research projects, endowments, Chairs in the institution during the last five years (INR in Lakhs).</td>
            <td>{weightage321}</td>
            <td rowspan="4">{kiWeightage32}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue321}
                value={dataValue321}
                onChange={(e) => {
                  setDataValue321(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue321)}</p>
            </td>
            <td>
              <p>{weightage321 * qnmetricGradeScale(dataValue321)}</p>
            </td>
            <td rowSpan="4">
              <p>{criteria32Value}</p>
            </td>
            <td rowSpan="4">
              <p>{parseFloat(criteria32Value / kiWeightage32).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>31.</td>
            <td>3.2.2</td>
            <td>QN</td>
            <td>Percentage of teachers having research projects during the last five years.</td>
            <td>{weightage322}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue322}
                value={dataValue322}
                onChange={(e) => {
                  setDataValue322(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue322)}</p>
            </td>
            <td>
              <p>{weightage322 * qnmetricGradeScale(dataValue322)}</p>
            </td>
          </tr>
          <tr>
            <td>32.</td>
            <td>3.2.3</td>
            <td>QN</td>
            <td>Percentage of teachers recognised as research guides.</td>
            <td>{weightage323}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue323}
                value={dataValue323}
                onChange={(e) => {
                  setDataValue323(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue323)}</p>
            </td>
            <td>
              <p>{weightage323 * qnmetricGradeScale(dataValue323)}</p>
            </td>
          </tr>
          <tr>
            <td>33.</td>
            <td>3.2.4</td>
            <td>QN</td>
            <td>Average percentage of departments having Research projects funded by government and non-government agencies during the last five years.</td>
            <td>{weightage324}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue324}
                value={dataValue324}
                onChange={(e) => {
                  setDataValue324(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue324)}</p>
            </td>
            <td>
              <p>{weightage324 * qnmetricGradeScale(dataValue324)}</p>
            </td>
          </tr>
          <tr>
            <td>34.</td>
            <td rowspan="2">Innovation Ecosystem</td>
            <td>3.3.1</td>
            <td>QI</td>
            <td>nstitution has created an eco system for innovations, creation and transfer of knowledge supported by dedicated centers for research, entrepreneurship, community orientation, Incubation etc.</td>
            <td>5</td>
            <td rowspan="2">10</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue331}
                onChange={(e) => {
                  setDataValue331(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade331}
                onChange={(e) => {
                  setDataValueGrade331(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage331 * qlmetricGradeScale(dataValueGrade331)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteria33Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria33Value / kiWeightage33).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>35.</td>
            <td>3.3.2</td>
            <td>QN</td>
            <td>Number of workshops/seminars conducted on Research methodology, Intellectual Property Rights (IPR),entrepreneurship, skill development during the last five years.</td>
            <td>5</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue332}
                value={dataValue332}
                onChange={(e) => {
                  setDataValue332(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue332)}</p>
            </td>
            <td>
              <p>{weightage332 * qnmetricGradeScale(dataValue332)}</p>
            </td>
          </tr>
          <tr>
            <td>36.</td>
            <td rowspan="6">Research Publications and Awards</td>
            <td>3.4.1</td>
            <td>QN</td>
            <td>The institution ensures implementation of its stated code of Ethics for reseach through the following:</td>
            <td>{weightage341}</td>
            <td rowspan="6">{kiWeightage34}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue341}
                value={dataValue341}
                onChange={(e) => {
                  setDataValue341(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue341)}</p>
            </td>
            <td>
              <p>{weightage341 * qnmetricGradeScale(dataValue341)}</p>
            </td>
            <td rowSpan="6">
              <p>{criteria34Value}</p>
            </td>
            <td rowSpan="6">
              <p>{parseFloat(criteria34Value / kiWeightage34).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>37.</td>
            <td>3.4.2</td>
            <td>QN</td>
            <td>Number of Ph.D's registered per teacher (as per the data given w.r.t recognized Ph.D guides/ supervisors provided at 3.2.3 metric) during the last five years.</td>
            <td>{weightage342}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue342}
                value={dataValue342}
                onChange={(e) => {
                  setDataValue342(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue342)}</p>
            </td>
            <td>
              <p>{weightage342 * qnmetricGradeScale(dataValue342)}</p>
            </td>
          </tr>
          <tr>
            <td>38.</td>
            <td>3.4.3</td>
            <td>QN</td>
            <td>Number of research papers per teachers in the Journals notified on UGC website during the last five years.</td>
            <td>{weightage343}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue343}
                value={dataValue343}
                onChange={(e) => {
                  setDataValue343(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue343)}</p>
            </td>
            <td>
              <p>{weightage343 * qnmetricGradeScale(dataValue343)}</p>
            </td>
          </tr>
          <tr>
            <td>39.</td>
            <td>3.4.4</td>
            <td>QN</td>
            <td>Number of books and chapters in edited volumes / books published per teacher during the last five years.</td>
            <td>{weightage343}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue344}
                value={dataValue344}
                onChange={(e) => {
                  setDataValue344(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue344)}</p>
            </td>
            <td>
              <p>{weightage343 * qnmetricGradeScale(dataValue344)}</p>
            </td>
          </tr>
          <tr>
            <td>40.</td>
            <td>3.4.5</td>
            <td>QN</td>
            <td>Bibliometrics of the publications during the last five years based on average citation index in Scopus/ Web of Science or PubMed.</td>
            <td>{weightage345}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue345}
                value={dataValue345}
                onChange={(e) => {
                  setDataValue345(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue345)}</p>
            </td>
            <td>
              <p>{weightage345 * qnmetricGradeScale(dataValue345)}</p>
            </td>
          </tr>
          <tr>
            <td>41.</td>
            <td>3.4.6</td>
            <td>QN</td>
            <td>Bibliometrics of the publications during the last five years based on Scopus/ Web of Science - h-index of the Institution.</td>
            <td>{weightage346}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue346}
                value={dataValue346}
                onChange={(e) => {
                  setDataValue346(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue346)}</p>
            </td>
            <td>
              <p>{weightage346 * qnmetricGradeScale(dataValue346)}</p>
            </td>
          </tr>
          <tr>
            <td>42.</td>
            <td rowspan="2">Consultancy</td>
            <td>3.5.1</td>
            <td>QN</td>
            <td>Revenue generated from consultancy and corporate training during the last five years (INR in Lakhs).</td>
            <td>{weightage351}</td>
            <td rowspan="2">{kiWeightage35}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue351}
                value={dataValue351}
                onChange={(e) => {
                  setDataValue351(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue351)}</p>
            </td>
            <td>
              <p>{weightage351 * qnmetricGradeScale(dataValue351)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteria35Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria35Value / kiWeightage35).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>43.</td>
            <td>3.5.2</td>
            <td>QN</td>
            <td>Total amount spent on developing facilities, training teachers and staff for undertaking consultancy during the last five years (INR in Lakhs).</td>
            <td>{weightage352}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue352}
                value={dataValue352}
                onChange={(e) => {
                  setDataValue352(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue352)}</p>
            </td>
            <td>
              <p>{weightage352 * qnmetricGradeScale(dataValue352)}</p>
            </td>
          </tr>
          <tr>
            <td>44.</td>
            <td rowspan="4">Extension Activities</td>
            <td>3.6.1</td>
            <td>QI</td>
            <td>Extension activities are carried out in the neighbourhood community, sensitising students to social issues, for their holistic development, and impact thereof during the last five years.</td>
            <td>{weightage361}</td>
            <td rowspan="4">{kiWeightage36}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue361}
                onChange={(e) => {
                  setDataValue361(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade361}
                onChange={(e) => {
                  setDataValueGrade361(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage361 * qlmetricGradeScale(dataValueGrade361)}</p>
            </td>
            <td rowspan="4">
              <p>{criteria36Value}</p>
            </td>
            <td rowspan="4">
              <p>{parseFloat(criteria36Value / kiWeightage36).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>45.</td>
            <td>3.6.2</td>
            <td>QN</td>
            <td>Number of awards and recognition received by the Institution, its teachers and students for extension activities from Government / Government recognised bodies during last five years.</td>
            <td>{weightage362}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue362}
                value={dataValue362}
                onChange={(e) => {
                  setDataValue362(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue362)}</p>
            </td>
            <td>
              <p>{weightage362 * qnmetricGradeScale(dataValue362)}</p>
            </td>
          </tr>
          <tr>
            <td>46.</td>
            <td>3.6.3</td>
            <td>QN</td>
            <td>Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years.</td>
            <td>{weightage363}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue363}
                value={dataValue363}
                onChange={(e) => {
                  setDataValue363(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue363)}</p>
            </td>
            <td>
              <p>{weightage363 * qnmetricGradeScale(dataValue363)}</p>
            </td>
          </tr>
          <tr>
            <td>47.</td>
            <td>3.6.4</td>
            <td>QN</td>
            <td>Average percentage of students participating in extension activities listed at 3.6.3 above during the last five years.</td>
            <td>{weightage364}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue364}
                value={dataValue364}
                onChange={(e) => {
                  setDataValue364(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue364)}</p>
            </td>
            <td>
              <p>{weightage364 * qnmetricGradeScale(dataValue364)}</p>
            </td>
          </tr>
          <tr>
            <td>48.</td>
            <td rowspan="2">Collaboration</td>
            <td>3.7.1</td>
            <td>QN</td>
            <td>Number of Collaborative activities per year for research/ faculty exchange/ student exchange/ internship/ on -the-job training/ project work.</td>
            <td>{weightage371}</td>
            <td rowspan="2">{kiWeightage37}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue371}
                value={dataValue371}
                onChange={(e) => {
                  setDataValue371(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue371)}</p>
            </td>
            <td>
              <p>{weightage371 * qnmetricGradeScale(dataValue371)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteria37Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria37Value / kiWeightage37).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>49.</td>
            <td>3.7.2</td>
            <td>QN</td>
            <td>Number of functional MoUs with institutions of national, international importance, other institutions, industries, corporate houses etc. during the last five years (only functional MoUs with ongoing activities to be considered).</td>
            <td>{weightage372}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue372}
                value={dataValue372}
                onChange={(e) => {
                  setDataValue372(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue372)}</p>
            </td>
            <td>
              <p>{weightage372 * qnmetricGradeScale(dataValue372)}</p>
            </td>
          </tr>
          <tr>
            <td>50.</td>
            <td rowspan="14">Infrastructure and Learning Resources</td>
            <td rowspan="4">Physical Facilities</td>
            <td>4.1.1</td>
            <td>QI</td>
            <td>The Institution has adequate infrastructure and physical facilities for teaching- learning. viz., classrooms, laboratories, computing equipment etc.</td>
            <td>{weightage411}</td>
            <td rowspan="4">{kiWeightage41}</td>
            <td rowspan="14">{criteria4}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue411}
                onChange={(e) => {
                  setDataValue411(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade411}
                onChange={(e) => {
                  setDataValueGrade411(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage411 * qlmetricGradeScale(dataValueGrade411)}</p>
            </td>
            <td rowSpan="4">
              <p>{criteria41Value}</p>
            </td>
            <td rowSpan="4">
              <p>{parseFloat(criteria41Value / kiWeightage41).toFixed(2)}</p>
            </td>
            <td rowSpan="14">
              <p>{criteria4Weightage}</p>
            </td>
            <td rowSpan="14">
              <p>{criteria4Grade}</p>
            </td>
          </tr>
          <tr>
            <td>51.</td>
            <td>4.1.2</td>
            <td>QI</td>
            <td>The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)</td>
            <td>{weightage412}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue412}
                onChange={(e) => {
                  setDataValue412(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade412}
                onChange={(e) => {
                  setDataValueGrade412(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage412 * qlmetricGradeScale(dataValueGrade412)}</p>
            </td>
          </tr>
          <tr>
            <td>52.</td>
            <td>4.1.3</td>
            <td>QN</td>
            <td>Percentage of classrooms and seminar halls with ICT- enabled facilities such as smart class, LMS, etc. (Data for the latest completed academic year)</td>
            <td>{weightage413}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue413}
                value={dataValue413}
                onChange={(e) => {
                  setDataValue413(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue413)}</p>
            </td>
            <td>
              <p>{weightage413 * qnmetricGradeScale(dataValue413)}</p>
            </td>
          </tr>
          <tr>
            <td>53.</td>
            <td>4.1.4</td>
            <td>QN</td>
            <td>Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)</td>
            <td>{weightage414}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue414}
                value={dataValue414}
                onChange={(e) => {
                  setDataValue414(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue414)}</p>
            </td>
            <td>
              <p>{weightage414 * qnmetricGradeScale(dataValue414)}</p>
            </td>
          </tr>
          <tr>
            <td>54.</td>
            <td rowspan="4">Library as a Learning Resource</td>
            <td>4.2.1</td>
            <td>QI</td>
            <td>Library is automated using Integrated Library Management System (ILMS).</td>
            <td>{weightage421}</td>
            <td rowspan="4">{kiWeightage42}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue421}
                onChange={(e) => {
                  setDataValue421(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade421}
                onChange={(e) => {
                  setDataValueGrade421(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage421 * qlmetricGradeScale(dataValueGrade421)}</p>
            </td>
            <td>
              <p>{criteria42Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria42Value / kiWeightage42).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>55.</td>
            <td>4.2.2</td>
            <td>QN</td>
            <td>Institution has access to the following: e-journals,e-ShodhSindhu,Shodhganga Membership,e-books,Databases,Remote access to e-resources</td>
            <td>5</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue422}
                value={dataValue422}
                onChange={(e) => {
                  setDataValue422(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue422)}</p>
            </td>
            <td>
              <p>{weightage422 * qnmetricGradeScale(dataValue422)}</p>
            </td>
            <td rowSpan="3">
              <p>{criteria42Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteria42Value / kiWeightage42).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>56.</td>
            <td>4.2.3</td>
            <td>QN</td>
            <td>Average annual expenditure for purchase of books/ e-books and subscription to journals/e-journals during the last five years (INR in Lakhs)</td>
            <td>{weightage423}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue423}
                value={dataValue423}
                onChange={(e) => {
                  setDataValue423(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue423)}</p>
            </td>
            <td>
              <p>{weightage423 * qnmetricGradeScale(dataValue423)}</p>
            </td>
          </tr>
          <tr>
            <td>57.</td>
            <td>4.2.4</td>
            <td>QN</td>
            <td> Percentage per day usage of library by teachers and students ( foot falls and login data for online access) during the latest completed academic year</td>
            <td>{weightage424}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue424}
                value={dataValue424}
                onChange={(e) => {
                  setDataValue424(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue424)}</p>
            </td>
            <td>
              <p>{weightage424 * qnmetricGradeScale(dataValue424)}</p>
            </td>
          </tr>
          <tr>
            <td>58.</td>
            <td rowspan="4">IT Infrastructure</td>
            <td>4.3.1</td>
            <td>QI</td>
            <td>Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities.</td>
            <td>{weightage431}</td>
            <td rowspan="4">{kiWeightage43}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue431}
                onChange={(e) => {
                  setDataValue431(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade431}
                onChange={(e) => {
                  setDataValueGrade431(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage431 * qlmetricGradeScale(dataValueGrade431)}</p>
            </td>
            <td rowspan="4">
              <p>{criteria43Value}</p>
            </td>
            <td rowspan="4">
              <p>{parseFloat(criteria43Value / kiWeightage43).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>59.</td>
            <td>4.3.2</td>
            <td>QN</td>
            <td>Student - Computer ratio (Data for the latest completed academic year)</td>
            <td>{weightage432}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue432}
                value={dataValue432}
                onChange={(e) => {
                  setDataValue432(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue432)}</p>
            </td>
            <td>
              <p>{weightage432 * qnmetricGradeScale(dataValue432)}</p>
            </td>
          </tr>
          <tr>
            <td>60.</td>
            <td>4.3.3</td>
            <td>QN</td>
            <td>Bandwidth of internet connection in the Institution.</td>
            <td>{weightage433}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue433}
                value={dataValue433}
                onChange={(e) => {
                  setDataValue433(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue433)}</p>
            </td>
            <td>
              <p>{weightage433 * qnmetricGradeScale(dataValue433)}</p>
            </td>
          </tr>
          <tr>
            <td>61.</td>
            <td>4.3.4</td>
            <td>QN</td>
            <td>Institution has the following Facilities for e-content development</td>
            <td>{weightage434}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue434}
                value={dataValue434}
                onChange={(e) => {
                  setDataValue434(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue434)}</p>
            </td>
            <td>
              <p>{weightage434 * qnmetricGradeScale(dataValue434)}</p>
            </td>
          </tr>
          <tr>
            <td>62.</td>
            <td rowspan="2">Maintenance of Campus Infrastructure</td>
            <td>4.4.1</td>
            <td>QN</td>
            <td> Average percentage expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component during the last five years.</td>
            <td>{weightage441}</td>
            <td rowspan="2">{kiWeightage44}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue441}
                value={dataValue441}
                onChange={(e) => {
                  setDataValue441(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue441)}</p>
            </td>
            <td>
              <p>{weightage441 * qnmetricGradeScale(dataValue441)}</p>
            </td>
            <td rowspan="2">
              <p>{criteria44Value}</p>
            </td>
            <td rowspan="2">
              <p>{parseFloat(criteria44Value / kiWeightage44).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>63.</td>
            <td>4.4.2</td>
            <td>QI</td>
            <td>There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.</td>
            <td>{weightage442}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue442}
                onChange={(e) => {
                  setDataValue442(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade442}
                onChange={(e) => {
                  setDataValueGrade442(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage442 * qlmetricGradeScale(dataValueGrade442)}</p>
            </td>
          </tr>
          <tr>
            <td>64.</td>
            <td rowspan="13">Student Support and Progression</td>
            <td rowspan="5">Student Support</td>
            <td>5.1.1</td>
            <td>QN</td>
            <td>Average percentage of students benefited by scholarships and freeships provided by the Government during last five years.</td>
            <td>{weightage511}</td>
            <td rowspan="5">{kiWeightage51}</td>
            <td rowspan="13">{criteria5}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue511}
                value={dataValue511}
                onChange={(e) => {
                  setDataValue511(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue511)}</p>
            </td>
            <td>
              <p>{weightage511 * qnmetricGradeScale(dataValue511)}</p>
            </td>
            <td rowSpan="5">
              <p>{criteria51Value}</p>
            </td>
            <td rowSpan="5">
              <p>{parseFloat(criteria51Value / kiWeightage51).toFixed(2)}</p>
            </td>
            <td rowSpan="13">
              <p>{criteria5Weightage}</p>
            </td>
            <td rowSpan="13">
              <p>{criteria5Grade}</p>
            </td>
          </tr>
          <tr>
            <td>65.</td>
            <td>5.1.2</td>
            <td>QN</td>
            <td>Average percentage of students benefited by scholarships, freeships, etc. provided by the institution and non-government agencies during the last five years</td>
            <td>{weightage512}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue512}
                value={dataValue512}
                onChange={(e) => {
                  setDataValue512(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue512)}</p>
            </td>
            <td>
              <p>{weightage512 * qnmetricGradeScale(dataValue512)}</p>
            </td>
          </tr>
          <tr>
            <td>66.</td>
            <td>5.1.3</td>
            <td>QN</td>
            <td>Percentage of classrooms and seminar halls with ICT- enabled facilities such as smart class, LMS, etc. (Data for the latest completed academic year)</td>
            <td>{weightage513}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue513}
                value={dataValue513}
                onChange={(e) => {
                  setDataValue513(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue513)}</p>
            </td>
            <td>
              <p>{weightage513 * qnmetricGradeScale(dataValue513)}</p>
            </td>
          </tr>
          <tr>
            <td>67.</td>
            <td>5.1.4</td>
            <td>QN</td>
            <td>Average percentage of students benefited by career counseling and guidance for competitive examinations as offered by the Institution during the last five years.</td>
            <td>{weightage514}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue514}
                value={dataValue514}
                onChange={(e) => {
                  setDataValue514(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue514)}</p>
            </td>
            <td>
              <p>{weightage514 * qnmetricGradeScale(dataValue514)}</p>
            </td>
          </tr>
          <tr>
            <td>68.</td>
            <td>5.1.5</td>
            <td>QN</td>
            <td>Average percentage of students benefited by career counseling and guidance for competitive examinations as offered by the Institution during the last five years.</td>
            <td>{weightage515}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue515}
                value={dataValue515}
                onChange={(e) => {
                  setDataValue515(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue515)}</p>
            </td>
            <td>
              <p>{weightage515 * qnmetricGradeScale(dataValue515)}</p>
            </td>
          </tr>
          <tr>
            <td>69.</td>
            <td rowspan="3">Student Progression</td>
            <td>5.2.1</td>
            <td>QN</td>
            <td>Average percentage of placement of outgoing students during the last five years.</td>
            <td>{weightage521}</td>
            <td rowspan="3">{kiWeightage52}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue521}
                value={dataValue521}
                onChange={(e) => {
                  setDataValue521(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue521)}</p>
            </td>
            <td>
              <p>{weightage521 * qnmetricGradeScale(dataValue521)}</p>
            </td>
            <td rowSpan="3">
              <p>{criteria52Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteria52Value / kiWeightage52).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>70.</td>
            <td>5.2.2</td>
            <td>QN</td>
            <td>Percentage of student progression to higher education (previous graduating batch).</td>
            <td>{weightage522}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue522}
                value={dataValue522}
                onChange={(e) => {
                  setDataValue522(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue522)}</p>
            </td>
            <td>
              <p>{weightage522 * qnmetricGradeScale(dataValue522)}</p>
            </td>
          </tr>
          <tr>
            <td>71.</td>
            <td>5.2.3</td>
            <td>QN</td>
            <td>Average percentage of students qualifying in state/national/ international level examinations during the last five years (eg: IIT-JAM/CLAT/ NET/SLET/GATE/ GMAT/CAT/GRE/ TOEFL/ Civil Services/State government examinations, etc.)</td>
            <td>{weightage523}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue523}
                value={dataValue523}
                onChange={(e) => {
                  setDataValue523(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue523)}</p>
            </td>
            <td>
              <p>{weightage523 * qnmetricGradeScale(dataValue523)}</p>
            </td>
          </tr>
          <tr>
            <td>72.</td>
            <td rowspan="3">Student Participation and Activities</td>
            <td>5.3.1</td>
            <td>QN</td>
            <td>Number of awards/medals for outstanding performance in sports/cultural activities at inter-university / state /national / international events (award for a team event should be counted as one) during the last five years.</td>
            <td>{weightage531}</td>
            <td rowspan="3">{kiWeightage53}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue531}
                value={dataValue531}
                onChange={(e) => {
                  setDataValue531(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue531)}</p>
            </td>
            <td>
              <p>{weightage531 * qnmetricGradeScale(dataValue531)}</p>
            </td>
            <td rowSpan="3">
              <p>{criteria53Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteria53Value / kiWeightage53).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>73.</td>
            <td>5.3.2</td>
            <td>QI</td>
            <td>Presence of an active Student Council & representation of students on academic & administrative bodies/committees of the institution.</td>
            <td>{weightage532}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue532}
                onChange={(e) => {
                  setDataValue532(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade532}
                onChange={(e) => {
                  setDataValueGrade532(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage532 * qlmetricGradeScale(dataValueGrade532)}</p>
            </td>
          </tr>
          <tr>
            <td>74.</td>
            <td>5.3.3</td>
            <td>QN</td>
            <td>Average number of sports and cultural events / competitions organised by the institution per year.</td>
            <td>{weightage533}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue533}
                value={dataValue533}
                onChange={(e) => {
                  setDataValue533(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue533)}</p>
            </td>
            <td>
              <p>{weightage533 * qnmetricGradeScale(dataValue533)}</p>
            </td>
          </tr>
          <tr>
            <td>75.</td>
            <td rowspan="2">Alumni Engagement</td>
            <td>5.4.1</td>
            <td>QI</td>
            <td>The Alumni Association/Chapters (registered and functional)contributes significantly to the development of the institution through financial and other support services.</td>
            <td>{weightage541}</td>
            <td rowspan="2">{kiWeightage54}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue541}
                onChange={(e) => {
                  setDataValue541(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade541}
                onChange={(e) => {
                  setDataValueGrade541(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage541 * qlmetricGradeScale(dataValueGrade541)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteria54Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria54Value / kiWeightage54).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>76.</td>
            <td>5.4.2</td>
            <td>QN</td>
            <td>Presence of an active Student Council & representation of students on academic & administrative bodies/committees of the institution.</td>
            <td>{weightage542}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue542}
                value={dataValue542}
                onChange={(e) => {
                  setDataValue542(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue542)}</p>
            </td>
            <td>
              <p>{weightage542 * qnmetricGradeScale(dataValue542)}</p>
            </td>
          </tr>
          <tr>
            <td>77.</td>
            <td rowspan="15">Governance, Leadership and Management</td>
            <td rowspan="2">Institutional Vision and Leadership</td>
            <td>6.1.1</td>
            <td>QI</td>
            <td>The governance of the institution is reflective of an effective leadership in tune with the vision and mission of the Institution.</td>
            <td>{weightage611}</td>
            <td rowspan="2">{kiWeightage61}</td>
            <td rowspan="15">{criteria6}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue611}
                onChange={(e) => {
                  setDataValue611(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade611}
                onChange={(e) => {
                  setDataValueGrade611(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage611 * qlmetricGradeScale(dataValueGrade611)}</p>
            </td>
            <td rowspan="2">
              <p>{criteria61Value}</p>
            </td>
            <td rowspan="2">
              <p>{parseFloat(criteria61Value / kiWeightage61).toFixed(2)}</p>
            </td>
            <td rowSpan="15">
              <p>{criteria6Weightage}</p>
            </td>
            <td rowSpan="15">
              <p>{criteria6Grade}</p>
            </td>
          </tr>
          <tr>
            <td>78.</td>
            <td>6.1.2</td>
            <td>QI</td>
            <td>The effective leadership is reflected in various institutional practices such as decentralization and participative management.</td>
            <td>{weightage612}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue612}
                onChange={(e) => {
                  setDataValue612(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade612}
                onChange={(e) => {
                  setDataValueGrade612(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage612 * qlmetricGradeScale(dataValueGrade612)}</p>
            </td>
          </tr>
          <tr>
            <td>79.</td>
            <td rowspan="3">Strategy Development and Deployment</td>
            <td>6.2.1</td>
            <td>QI</td>
            <td>The institutional Strategic/ Perspective plan is effectively deployed.</td>
            <td>{weightage621}</td>
            <td rowspan="3">{kiWeightage62}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue621}
                onChange={(e) => {
                  setDataValue621(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade621}
                onChange={(e) => {
                  setDataValueGrade621(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage621 * qlmetricGradeScale(dataValueGrade621)}</p>
            </td>
            <td rowspan="3">
              <p>{criteria62Value}</p>
            </td>
            <td rowspan="3">
              <p>{parseFloat(criteria62Value / kiWeightage62).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>80.</td>
            <td>6.2.2</td>
            <td>QI</td>
            <td>The functioning of the institutional bodies is effective and efficient as visible from policies, administrative setup appointment and service rules, procedures, etc.</td>
            <td>{weightage622}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue622}
                onChange={(e) => {
                  setDataValue622(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade622}
                onChange={(e) => {
                  setDataValueGrade622(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage622 * qlmetricGradeScale(dataValueGrade622)}</p>
            </td>
          </tr>
          <tr>
            <td>81.</td>
            <td>6.2.3</td>
            <td>QN</td>
            <td>Implementation of e-governance in areas of operation.</td>
            <td>{weightage623}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue623}
                value={dataValue623}
                onChange={(e) => {
                  setDataValue623(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue623)}</p>
            </td>
            <td>
              <p>{weightage623 * qnmetricGradeScale(dataValue623)}</p>
            </td>
          </tr>
          <tr>
            <td>82.</td>
            <td rowspan="4">Faculty Empowerment Strategies</td>
            <td>6.3.1</td>
            <td>QI</td>
            <td>The institutional Strategic/ Perspective plan is effectively deployed.</td>
            <td>{weightage631}</td>
            <td rowspan="4">{kiWeightage63}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue631}
                onChange={(e) => {
                  setDataValue631(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade631}
                onChange={(e) => {
                  setDataValueGrade631(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage631 * qlmetricGradeScale(dataValueGrade631)}</p>
            </td>
            <td rowspan="4">
              <p>{criteria63Value}</p>
            </td>
            <td rowspan="4">
              <p>{parseFloat(criteria63Value / kiWeightage63).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>83.</td>
            <td>6.3.2</td>
            <td>QN</td>
            <td>Average percentage of teachers provided with financial support to attend conferences / workshops and towards membership fee of professional bodies during the last five years.</td>
            <td>{weightage632}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue632}
                value={dataValue632}
                onChange={(e) => {
                  setDataValue632(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue632)}</p>
            </td>
            <td>
              <p>{weightage632 * qnmetricGradeScale(dataValue632)}</p>
            </td>
          </tr>
          <tr>
            <td>84.</td>
            <td>6.3.3</td>
            <td>QN</td>
            <td>The institution provides seed money to its teachers for research.</td>
            <td>{weightage633}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue633}
                value={dataValue633}
                onChange={(e) => {
                  setDataValue633(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue633)}</p>
            </td>
            <td>
              <p>{weightage633 * qnmetricGradeScale(dataValue633)}</p>
            </td>
          </tr>
          <tr>
            <td>85.</td>
            <td>6.3.4</td>
            <td>QN</td>
            <td>The institution provides seed money to its teachers for research.</td>
            <td>{weightage634}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue634}
                value={dataValue634}
                onChange={(e) => {
                  setDataValue634(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue634)}</p>
            </td>
            <td>
              <p>{weightage634 * qnmetricGradeScale(dataValue634)}</p>
            </td>
          </tr>
          <tr>
            <td>86.</td>
            <td rowspan="3">Financial Management and Resource Mobilization</td>
            <td>6.4.1</td>
            <td>QI</td>
            <td>The institutional Strategic/ Perspective plan is effectively deployed.</td>
            <td>{weightage641}</td>
            <td rowspan="3">{kiWeightage64}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue641}
                onChange={(e) => {
                  setDataValue641(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade641}
                onChange={(e) => {
                  setDataValueGrade641(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage641 * qlmetricGradeScale(dataValueGrade641)}</p>
            </td>
            <td rowspan="3">
              <p>{criteria64Value}</p>
            </td>
            <td rowspan="3">
              <p>{parseFloat(criteria64Value / kiWeightage64).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>87.</td>
            <td>6.4.2</td>
            <td>QN</td>
            <td>Funds / Grants received from non-government bodies, individuals, philanthropists during the last five years (not covered in Criterion III and V) (INR in Lakhs).</td>
            <td>{weightage642}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue642}
                value={dataValue642}
                onChange={(e) => {
                  setDataValue642(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue642)}</p>
            </td>
            <td>
              <p>{weightage642 * qnmetricGradeScale(dataValue642)}</p>
            </td>
          </tr>
          <tr>
            <td>88.</td>
            <td>6.4.3</td>
            <td>QI</td>
            <td>Institutional strategies for mobilisation of funds and the optimal utilisation of resources.</td>
            <td>{weightage643}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue643}
                onChange={(e) => {
                  setDataValue643(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade643}
                onChange={(e) => {
                  setDataValueGrade643(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage643 * qlmetricGradeScale(dataValueGrade643)}</p>
            </td>
          </tr>
          <tr>
            <td>89.</td>
            <td rowspan="3">Internal Quality Assurance System (IQAS)</td>
            <td>6.5.1</td>
            <td>QI</td>
            <td>Internal Quality Assurance Cell (IQAC) has contributed significantly for institutionalizing the quality assurance strategies and processes visible in terms of – Incremental improvements made for the preceding five years with regard to quality (in case of first cycle) Incremental improvements made for the preceding five years with regard to quality and post accreditation quality initiatives (second and subsequent cycles).</td>
            <td>{weightage651}</td>
            <td rowspan="3">{kiWeightage65}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue651}
                onChange={(e) => {
                  setDataValue651(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade651}
                onChange={(e) => {
                  setDataValueGrade651(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage651 * qlmetricGradeScale(dataValueGrade651)}</p>
            </td>
            <td rowspan="3">
              <p>{criteria65Value}</p>
            </td>
            <td rowspan="3">
              <p>{parseFloat(criteria65Value / kiWeightage65).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>90.</td>
            <td>6.5.2</td>
            <td>QI</td>
            <td>The institution reviews its teaching learning process, structures & methodologies of operations and learning outcomes at periodic intervals through IQAC set up as per norms and recorded the incremental improvement in various activities ( For first cycle - Incremental improvements made for the preceding five years with regard to quality For second and subsequent cycles - Incremental improvements made for the preceding five years with regard to quality and post accreditation quality initiatives ).</td>
            <td>{weightage652}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue652}
                onChange={(e) => {
                  setDataValue652(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade652}
                onChange={(e) => {
                  setDataValueGrade652(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage652 * qlmetricGradeScale(dataValueGrade652)}</p>
            </td>
          </tr>
          <tr>
            <td>91.</td>
            <td>6.5.3</td>
            <td>QN</td>
            <td>Quality assurance initiatives of the institution include</td>
            <td>{weightage653}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue653}
                value={dataValue653}
                onChange={(e) => {
                  setDataValue653(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue653)}</p>
            </td>
            <td>
              <p>{weightage653 * qnmetricGradeScale(dataValue653)}</p>
            </td>
          </tr>
          <tr>
            <td>92.</td>
            <td rowspan="13">Institutional Values and Best Practices</td>
            <td rowspan="11">Institutional Values and Social Responsibilities</td>
            <td>7.1.1</td>
            <td>QI</td>
            <td>Measures initiated by the Institution for the promotion of gender equity during the last five years.</td>
            <td>{weightage711}</td>
            <td rowspan="11">{kiWeightage71}</td>
            <td rowspan="13">{criteria7}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue711}
                onChange={(e) => {
                  setDataValue711(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade711}
                onChange={(e) => {
                  setDataValueGrade711(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage711 * qlmetricGradeScale(dataValueGrade711)}</p>
            </td>
            <td rowspan="11">
              <p>{criteria71Value}</p>
            </td>
            <td rowspan="11">
              <p>{parseFloat(criteria71Value / kiWeightage71).toFixed(2)}</p>
            </td>
            <td rowSpan="13">
              <p>{criteria7Weightage}</p>
            </td>
            <td rowSpan="13">
              <p>{criteria7Grade}</p>
            </td>
          </tr>
          <tr>
            <td>93.</td>
            <td>7.1.2</td>
            <td>QN</td>
            <td>The Institution has facilities for alternate sources of energy and energy conservation measures.</td>
            <td>{weightage712}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue712}
                value={dataValue712}
                onChange={(e) => {
                  setDataValue712(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue712)}</p>
            </td>
            <td>
              <p>{weightage712 * qnmetricGradeScale(dataValue712)}</p>
            </td>
          </tr>
          <tr>
            <td>94.</td>
            <td>7.1.3</td>
            <td>QI</td>
            <td>Describe the facilities in the Institution for the management of the following types of degradable and non-degradable waste (within 500 words) Solid waste management Liquid waste management Biomedical waste management E-waste management Waste recycling system Hazardous chemicals and radioactive waste management.</td>
            <td>{weightage713}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue713}
                onChange={(e) => {
                  setDataValue713(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade713}
                onChange={(e) => {
                  setDataValueGrade713(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage713 * qlmetricGradeScale(dataValueGrade713)}</p>
            </td>
          </tr>
          <tr>
            <td>95.</td>
            <td>7.1.4</td>
            <td>QN</td>
            <td>Water conservation facilities available in the Institution.</td>
            <td>{weightage714}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue714}
                value={dataValue714}
                onChange={(e) => {
                  setDataValue714(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue714)}</p>
            </td>
            <td>
              <p>{weightage714 * qnmetricGradeScale(dataValue714)}</p>
            </td>
          </tr>
          <tr>
            <td>96.</td>
            <td>7.1.5</td>
            <td>QN</td>
            <td>Green campus initiatives include.</td>
            <td>{weightage715}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue715}
                value={dataValue715}
                onChange={(e) => {
                  setDataValue715(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue715)}</p>
            </td>
            <td>
              <p>{weightage715 * qnmetricGradeScale(dataValue715)}</p>
            </td>
          </tr>
          <tr>
            <td>97.</td>
            <td>7.1.6</td>
            <td>QN</td>
            <td>Quality audits on environment and energy are regularly undertaken by the Institution and any awards received for such green campus initiatives.</td>
            <td>{weightage716}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue716}
                value={dataValue716}
                onChange={(e) => {
                  setDataValue716(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue716)}</p>
            </td>
            <td>
              <p>{weightage716 * qnmetricGradeScale(dataValue716)}</p>
            </td>
          </tr>
          <tr>
            <td>98.</td>
            <td>7.1.7</td>
            <td>QN</td>
            <td>The Institution has disabled-friendly, barrier free environment.</td>
            <td>{weightage717}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue717}
                value={dataValue717}
                onChange={(e) => {
                  setDataValue717(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue717)}</p>
            </td>
            <td>
              <p>{weightage717 * qnmetricGradeScale(dataValue717)}</p>
            </td>
          </tr>
          <tr>
            <td>99.</td>
            <td>7.1.8</td>
            <td>QI</td>
            <td>Describe the Institutional efforts/initiatives in providing an inclusive environment i.e., tolerance and harmony towards cultural, regional, linguistic, communal socioeconomic and other diversities (within 500 words).</td>
            <td>{weightage718}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue718}
                onChange={(e) => {
                  setDataValue718(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade718}
                onChange={(e) => {
                  setDataValueGrade718(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage718 * qlmetricGradeScale(dataValueGrade718)}</p>
            </td>
          </tr>
          <tr>
            <td>100.</td>
            <td>7.1.9</td>
            <td>QI</td>
            <td> Sensitization of students and employees of the Institution to the constitutional obligations: values, rights, duties and responsibilities of citizens (within 500 words).</td>
            <td>{weightage719}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue719}
                onChange={(e) => {
                  setDataValue719(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade719}
                onChange={(e) => {
                  setDataValueGrade719(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage719 * qlmetricGradeScale(dataValueGrade719)}</p>
            </td>
          </tr>
          <tr>
            <td>101.</td>
            <td>7.1.10</td>
            <td>QN</td>
            <td>The Institution has a prescribed code of conduct for students, teachers, administrators and other staff and conducts periodic programmes in this regard.</td>
            <td>{weightage7110}</td>
            <td>
              <input
                readOnly
                type="text"
                placeholder={dataValue7110}
                value={dataValue7110}
                onChange={(e) => {
                  setDataValue7110(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue7110)}</p>
            </td>
            <td>
              <p>{weightage7110 * qnmetricGradeScale(dataValue7110)}</p>
            </td>
          </tr>
          <tr>
            <td>102.</td>
            <td>7.1.11</td>
            <td>QN</td>
            <td>Institution celebrates / organizes national and international commemorative days, events and festivals (within 500 words).</td>
            <td>{weightage7111}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue7111}
                onChange={(e) => {
                  setDataValue7111(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade7111}
                onChange={(e) => {
                  setDataValueGrade7111(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage7111 * qlmetricGradeScale(dataValueGrade7111)}</p>
            </td>
          </tr>
          <tr>
            <td>103.</td>
            <td>Best Practices</td>
            <td>7.2.1</td>
            <td>QI</td>
            <td>Describe two best practices successfully implemented by the Institution as per NAAC format provided in the Manual.</td>
            <td>{weightage721}</td>
            <td>{kiWeightage72}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue721}
                onChange={(e) => {
                  setDataValue721(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade721}
                onChange={(e) => {
                  setDataValueGrade721(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage721 * qlmetricGradeScale(dataValueGrade721)}</p>
            </td>
            <td>
              <p>{criteria72Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria72Value / kiWeightage72).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>104.</td>
            <td>Institutional Distinctiveness</td>
            <td>7.3.1</td>
            <td>QI</td>
            <td>Portray the performance of the Institution in one area distinctive to its priority and thrust within 1000 words.</td>
            <td>{weightage731}</td>
            <td>{kiWeightage73}</td>
            <td>
              <input
                readOnly
                rows="10"
                type="text"
                value={dataValue731}
                onChange={(e) => {
                  setDataValue731(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                readOnly
                type="text"
                value={dataValueGrade731}
                onChange={(e) => {
                  setDataValueGrade731(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage731 * qlmetricGradeScale(dataValueGrade731)}</p>
            </td>
            <td>
              <p>{criteria73Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria73Value / kiWeightage73).toFixed(2)}</p>
            </td>
          </tr>
        </table>
        <div className="qn-ql-button-container">
          <button
            className="qn-ql-button-style"
            onClick={onClickingSave}
          >
            Save
          </button>
        </div>
      </div>
    </div>
  );
}

export default QLQN;
