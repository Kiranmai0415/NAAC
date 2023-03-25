import React, { useState, useEffect } from 'react';
import { resources } from '../../../appConstants';
import AuthService from '../../../Pages/Users/services/auth.service';
import './QLQN-style.css';

function QLQN() {
  // Criteria 11
  const [dataValue111, setDataValue111] = useState('');
  const [dataValueGrade111, setDataValueGrade111] = useState();

  // Criteria 12
  const [dataValue121, setDataValue121] = useState('');
  const [dataValue122, setDataValue122] = useState('');

  // Criteria 13
  const [dataValue131, setDataValue131] = useState('');
  const [dataValueGrade131, setDataValueGrade131] = useState();
  const [dataValue132, setDataValue132] = useState('');

  // Criteria 14
  const [dataValue141, setDataValue141] = useState('');

  // Criteria 21
  const [dataValue211, setDataValue211] = useState('');
  const [dataValue212, setDataValue212] = useState('');

  // Criteria 22
  const [dataValue221, setDataValue221] = useState('');

  // Criteria 23
  const [dataValue231, setDataValue231] = useState('');
  const [dataValueGrade231, setDataValueGrade231] = useState();

  // Criteria 24
  const [dataValue241, setDataValue241] = useState('');
  const [dataValue242, setDataValue242] = useState('');

  // Criteria 25
  const [dataValue251, setDataValue251] = useState('');
  const [dataValueGrade251, setDataValueGrade251] = useState();

  // Criteria 26
  const [dataValue261, setDataValue261] = useState('');
  const [dataValueGrade261, setDataValueGrade261] = useState();
  const [dataValue262, setDataValue262] = useState('');

  // Criteria 27
  const [dataValue271, setDataValue271] = useState('');

  // Criteria 31
  const [dataValue311, setDataValue311] = useState('');

  // Criteria 32
  const [dataValue321, setDataValue321] = useState('');
  const [dataValueGrade321, setDataValueGrade321] = useState();
  const [dataValue322, setDataValue322] = useState('');

  // Criteria 33
  const [dataValue331, setDataValue331] = useState('');
  const [dataValue332, setDataValue332] = useState('');

  // Criteria 34
  const [dataValue341, setDataValue341] = useState('');
  const [dataValueGrade341, setDataValueGrade341] = useState();
  const [dataValue342, setDataValue342] = useState('');
  const [dataValueGrade342, setDataValueGrade342] = useState();
  const [dataValue343, setDataValue343] = useState('');

  // Criteria 35
  const [dataValue351, setDataValue351] = useState('');

  // Criteria 41
  const [dataValue411, setDataValue411] = useState('');
  const [dataValueGrade411, setDataValueGrade411] = useState();
  const [dataValue412, setDataValue412] = useState('');

  // Criteria 42
  const [dataValue421, setDataValue421] = useState('');
  const [dataValueGrade421, setDataValueGrade421] = useState();

  // Criteria 43
  const [dataValue431, setDataValue431] = useState('');
  const [dataValueGrade431, setDataValueGrade431] = useState();
  const [dataValue432, setDataValue432] = useState('');

  // Criteria 44
  const [dataValue441, setDataValue441] = useState('');

  // Criteria 51
  const [dataValue511, setDataValue511] = useState('');
  const [dataValue512, setDataValue512] = useState('');
  const [dataValue513, setDataValue513] = useState('');
  const [dataValue514, setDataValue514] = useState('');

  // Criteria 52
  const [dataValue521, setDataValue521] = useState('');
  const [dataValue522, setDataValue522] = useState('');

  // Criteria 53
  const [dataValue531, setDataValue531] = useState('');
  const [dataValue532, setDataValue532] = useState('');

  // Criteria 54
  const [dataValue541, setDataValue541] = useState('');
  const [dataValueGrade541, setDataValueGrade541] = useState();

  // Criteria 61
  const [dataValue611, setDataValue611] = useState('');
  const [dataValueGrade611, setDataValueGrade611] = useState();

  // Criteria 62
  const [dataValue621, setDataValue621] = useState('');
  const [dataValueGrade621, setDataValueGrade621] = useState();
  const [dataValue622, setDataValue622] = useState('');

  // Criteria 63
  const [dataValue631, setDataValue631] = useState('');
  const [dataValueGrade631, setDataValueGrade631] = useState();
  const [dataValue632, setDataValue632] = useState('');
  const [dataValue633, setDataValue633] = useState('');

  // Criteria 64
  const [dataValue641, setDataValue641] = useState('');
  const [dataValueGrade641, setDataValueGrade641] = useState();

  // Criteria 65
  const [dataValue651, setDataValue651] = useState('');
  const [dataValueGrade651, setDataValueGrade651] = useState();
  const [dataValue652, setDataValue652] = useState('');

  // Criteria 71
  const [dataValue711, setDataValue711] = useState('');
  const [dataValueGrade711, setDataValueGrade711] = useState();
  const [dataValue712, setDataValue712] = useState('');
  const [dataValue713, setDataValue713] = useState('');
  const [dataValue714, setDataValue714] = useState('');
  const [dataValueGrade714, setDataValueGrade714] = useState();

  // Criteria 72
  const [dataValue721, setDataValue721] = useState('');
  const [dataValueGrade721, setDataValueGrade721] = useState();

  // Criteria 73
  const [dataValue731, setDataValue731] = useState('');
  const [dataValueGrade731, setDataValueGrade731] = useState();

  useEffect(
    () => fetch(resources.APPLICATION_URL+'getAllQualitativeAndQuantitaveData').then(
      (response) => response
        .json()
        .then((data) => {
          console.log(JSON.stringify(data));
          // setDataValue111(data[1].quantitativeDataList[0].qntt7);
          // setDataValue121(data[1].quantitativeDataList[1].qntt7);
          // setDataValue122(data[1].quantitativeDataList[2].qntt7);
          // setDataValue132(data[1].quantitativeDataList[3].qntt7);
          // setDataValue141(data[1].quantitativeDataList[4].qntt7);
          // setDataValue211(data[1].quantitativeDataList[5].qntt7);
          // setDataValue212(data[1].quantitativeDataList[6].qntt7);
          // setDataValue221(data[1].quantitativeDataList[7].qntt7);
          // setDataValue241(data[1].quantitativeDataList[8].qntt7);
          // setDataValue262(data[1].quantitativeDataList[9].qntt7);
          // setDataValue271(data[1].quantitativeDataList[10].qntt7);

          // setDataValue311(data[1].quantitativeDataList[11].qntt7);
          // setDataValue322(data[1].quantitativeDataList[12].qntt7);
          // setDataValue331(data[1].quantitativeDataList[13].qntt7);
          // setDataValue332(data[1].quantitativeDataList[14].qntt7);
          // setDataValue343(data[1].quantitativeDataList[15].qntt7);
          // setDataValue351(data[1].quantitativeDataList[16].qntt7);

          // setDataValue413(data[1].quantitativeDataList[17].qntt7);
          // setDataValue414(data[1].quantitativeDataList[40].qntt7);
          // setDataValue422(data[1].quantitativeDataList[41].qntt7);
          // setDataValue423(data[1].quantitativeDataList[42].qntt7);
          // setDataValue424(data[1].quantitativeDataList[43].qntt7);
          // setDataValue432(data[1].quantitativeDataList[44].qntt7);
          // setDataValue433(data[1].quantitativeDataList[45].qntt7);
          // setDataValue434(data[1].quantitativeDataList[46].qntt7);
          // setDataValue441(data[1].quantitativeDataList[47].qntt7);
          // setDataValue511(data[1].quantitativeDataList[48].qntt7);
          // setDataValue512(data[1].quantitativeDataList[49].qntt7);
          // setDataValue513(data[1].quantitativeDataList[50].qntt7);
          // setDataValue514(data[1].quantitativeDataList[51].qntt7);
          // setDataValue515(data[1].quantitativeDataList[52].qntt7);
          // setDataValue521(data[1].quantitativeDataList[53].qntt7);
          // setDataValue522(data[1].quantitativeDataList[54].qntt7);
          // setDataValue523(data[1].quantitativeDataList[55].qntt7);
          // setDataValue531(data[1].quantitativeDataList[56].qntt7);
          // setDataValue533(data[1].quantitativeDataList[57].qntt7);
          // setDataValue542(data[1].quantitativeDataList[58].qntt7);
          // setDataValue623(data[1].quantitativeDataList[59].qntt7);
          // setDataValue632(data[1].quantitativeDataList[60].qntt7);
          // setDataValue633(data[1].quantitativeDataList[61].qntt7);
          // setDataValue634(data[1].quantitativeDataList[62].qntt7);
          // setDataValue642(data[1].quantitativeDataList[63].qntt7);
          // setDataValue653(data[1].quantitativeDataList[64].qntt7);
          // setDataValue712(data[1].quantitativeDataList[65].qntt7);
          // setDataValue714(data[1].quantitativeDataList[66].qntt7);
          // setDataValue715(data[1].quantitativeDataList[67].qntt7);
          // setDataValue716(data[1].quantitativeDataList[68].qntt7);
          // setDataValue717(data[1].quantitativeDataList[69].qntt7);
          // setDataValue7110(data[1].quantitativeDataList[70].qntt7);

          // setDataValue111(data[0].qualitativeDataList[0].qntt7);
          // setDataValueGrade111(data[0].qualitativeDataList[0].qlit6);
          // setDataValue131(data[0].qualitativeDataList[1].qntt7);
          // setDataValueGrade131(data[0].qualitativeDataList[1].qlit6);

          // setDataValue231(data[0].qualitativeDataList[2].qntt7);
          // setDataValueGrade231(data[0].qualitativeDataList[2].qlit6);
          // setDataValue251(data[0].qualitativeDataList[3].qntt7);
          // setDataValueGrade251(data[0].qualitativeDataList[3].qlit6);
          // setDataValue261(data[0].qualitativeDataList[4].qntt7);
          // setDataValueGrade261(data[0].qualitativeDataList[4].qlit6);

          // setDataValue321(data[0].qualitativeDataList[5].qntt7);
          // setDataValueGrade321(data[0].qualitativeDataList[5].qlit6);
          // setDataValue341(data[0].qualitativeDataList[6].qntt7);
          // setDataValueGrade341(data[0].qualitativeDataList[6].qlit6);
          // setDataValue342(data[0].qualitativeDataList[7].qntt7);
          // setDataValueGrade342(data[0].qualitativeDataList[7].qlit6);

          // setDataValue411(data[0].qualitativeDataList[12].qntt7);
          // setDataValueGrade411(data[0].qualitativeDataList[12].qlit6);
          // setDataValue412(data[0].qualitativeDataList[13].qntt7);
          // setDataValueGrade412(data[0].qualitativeDataList[13].qlit6);
          // setDataValue421(data[0].qualitativeDataList[14].qntt7);
          // setDataValueGrade421(data[0].qualitativeDataList[14].qlit6);
          // setDataValue431(data[0].qualitativeDataList[15].qntt7);
          // setDataValueGrade431(data[0].qualitativeDataList[15].qlit6);
          // setDataValue442(data[0].qualitativeDataList[16].qntt7);
          // setDataValueGrade442(data[0].qualitativeDataList[16].qlit6);
          // setDataValue532(data[0].qualitativeDataList[17].qntt7);
          // setDataValueGrade532(data[0].qualitativeDataList[17].qlit6);
          // setDataValue541(data[0].qualitativeDataList[18].qntt7);
          // setDataValueGrade541(data[0].qualitativeDataList[18].qlit6);
          // setDataValue611(data[0].qualitativeDataList[19].qntt7);
          // setDataValueGrade611(data[0].qualitativeDataList[19].qlit6);
          // setDataValue612(data[0].qualitativeDataList[20].qntt7);
          // setDataValueGrade612(data[0].qualitativeDataList[20].qlit6);
          // setDataValue621(data[0].qualitativeDataList[21].qntt7);
          // setDataValueGrade621(data[0].qualitativeDataList[21].qlit6);
          // setDataValue622(data[0].qualitativeDataList[22].qntt7);
          // setDataValueGrade622(data[0].qualitativeDataList[22].qlit6);
          // setDataValue631(data[0].qualitativeDataList[23].qntt7);
          // setDataValueGrade631(data[0].qualitativeDataList[23].qlit6);
          // setDataValue641(data[0].qualitativeDataList[24].qntt7);
          // setDataValueGrade641(data[0].qualitativeDataList[24].qlit6);
          // setDataValue651(data[0].qualitativeDataList[26].qntt7);
          // setDataValueGrade651(data[0].qualitativeDataList[26].qlit6);
          // setDataValue652(data[0].qualitativeDataList[27].qntt7);
          // setDataValue711(data[0].qualitativeDataList[28].qntt7);
          // setDataValueGrade711(data[0].qualitativeDataList[28].qlit6);
          // setDataValue713(data[0].qualitativeDataList[29].qntt7);
          // setDataValue721(data[0].qualitativeDataList[33].qntt7);
          // setDataValueGrade721(data[0].qualitativeDataList[33].qlit6);
          // setDataValue731(data[0].qualitativeDataList[34].qntt7);
          // setDataValueGrade731(data[0].qualitativeDataList[34].qlit6);
        })
        .catch((error) => {
          console.error('Error:', error);
        })
    ), []
  );

  const kiWeightage11 = 20;
  const weightage111 = 20;
  const weightage121 = 15;
  const weightage122 = 15;
  const kiWeightage12 = 30;
  const weightage131 = 10;
  const weightage132 = 20;
  const kiWeightage13 = 30;
  const weightage141 = 20;
  const kiWeightage14 = 20;
  const criteria1 = 100;

  const weightage211 = 20;
  const weightage212 = 20;
  const kiWeightage21 = 40;
  const weightage221 = 40;
  const kiWeightage22 = 40;
  const weightage231 = 40;
  const kiWeightage23 = 40;
  const weightage241 = 15;
  const weightage242 = 25;
  const kiWeightage24 = 40;
  const weightage251 = 40;
  const kiWeightage25 = 40;
  const weightage261 = 45;
  const weightage262 = 45;
  const kiWeightage26 = 90;
  const weightage271 = 60;
  const kiWeightage27 = 60;
  const criteria2 = 350;

  const weightage311 = 10;
  const kiWeightage31 = 10;
  const weightage321 = 10;
  const weightage322 = 5;
  const kiWeightage32 = 15;
  const weightage331 = 10;
  const weightage332 = 15;
  const kiWeightage33 = 25;
  const weightage341 = 10;
  const weightage342 = 10;
  const weightage343 = 20;
  const kiWeightage34 = 40;
  const weightage351 = 20;
  const kiWeightage35 = 20;
  const criteria3 = 110;

  const weightage411 = 20;
  const weightage412 = 10;
  const kiWeightage41 = 30;
  const weightage421 = 20;
  const kiWeightage42 = 20;
  const weightage431 = 20;
  const weightage432 = 10;
  const kiWeightage43 = 30;
  const weightage441 = 20;
  const kiWeightage44 = 20;
  const criteria4 = 100;

  const weightage511 = 20;
  const weightage512 = 10;
  const weightage513 = 10;
  const weightage514 = 10;
  const kiWeightage51 = 50;
  const weightage521 = 20;
  const weightage522 = 10;
  const kiWeightage52 = 30;
  const weightage531 = 25;
  const weightage532 = 25;
  const kiWeightage53 = 50;
  const weightage541 = 10;
  const kiWeightage54 = 10;
  const criteria5 = 140;

  const weightage611 = 10;
  const kiWeightage61 = 10;
  const weightage621 = 6;
  const weightage622 = 4;
  const kiWeightage62 = 10;
  const weightage631 = 8;
  const weightage632 = 12;
  const weightage633 = 15;
  const kiWeightage63 = 35;
  const weightage641 = 15;
  const kiWeightage64 = 15;
  const weightage651 = 15;
  const weightage652 = 15;
  const kiWeightage65 = 30;
  const criteria6 = 100;

  const weightage711 = 10;
  const weightage712 = 20;
  const weightage713 = 10;
  const weightage714 = 10;
  const kiWeightage71 = 50;
  const weightage721 = 30;
  const kiWeightage72 = 30;
  const weightage731 = 20;
  const kiWeightage73 = 20;
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
    + weightage121 * qnmetricGradeScale(dataValue121)
    + weightage122 * qnmetricGradeScale(dataValue122)
    + weightage131 * qlmetricGradeScale(dataValueGrade131)
    + weightage132 * qnmetricGradeScale(dataValue132)
    + weightage141 * qnmetricGradeScale(dataValue141)
    );
  }
  function criteria2Value() {
    return (
      weightage211 * qnmetricGradeScale(dataValue211)
      + weightage212 * qnmetricGradeScale(dataValue212)
      + weightage221 * qnmetricGradeScale(dataValue221)
      + weightage231 * qlmetricGradeScale(dataValueGrade231)
      + weightage241 * qnmetricGradeScale(dataValue241)
      + weightage242 * qnmetricGradeScale(dataValue242)
      + weightage251 * qlmetricGradeScale(dataValueGrade251)
      + weightage261 * qlmetricGradeScale(dataValueGrade261)
      + weightage262 * qnmetricGradeScale(dataValue262)
      + weightage271 * qnmetricGradeScale(dataValue271)
    );
  }
  function criteria3Value() {
    return (
      weightage311 * qnmetricGradeScale(dataValue311)
      + weightage321 * qlmetricGradeScale(dataValueGrade321)
      + weightage322 * qnmetricGradeScale(dataValue322)
      + weightage331 * qnmetricGradeScale(dataValue331)
      + weightage332 * qnmetricGradeScale(dataValue332)
      + weightage341 * qlmetricGradeScale(dataValueGrade341)
      + weightage342 * qlmetricGradeScale(dataValueGrade342)
      + weightage343 * qnmetricGradeScale(dataValue343)
      + weightage351 * qnmetricGradeScale(dataValue351)
    );
  }
  function criteria4Value() {
    return (
      weightage411 * qlmetricGradeScale(dataValueGrade411)
      + weightage412 * qnmetricGradeScale(dataValue412)
      + weightage421 * qlmetricGradeScale(dataValueGrade421)
      + weightage431 * qlmetricGradeScale(dataValueGrade431)
      + weightage432 * qnmetricGradeScale(dataValue432)
      + weightage441 * qnmetricGradeScale(dataValue441)
    );
  }
  function criteria5Value() {
    return (
      weightage511 * qnmetricGradeScale(dataValue511)
      + weightage512 * qnmetricGradeScale(dataValue512)
      + weightage513 * qnmetricGradeScale(dataValue513)
      + weightage514 * qnmetricGradeScale(dataValue514)
      + weightage521 * qnmetricGradeScale(dataValue521)
      + weightage522 * qnmetricGradeScale(dataValue522)
      + weightage531 * qnmetricGradeScale(dataValue531)
      + weightage532 * qnmetricGradeScale(dataValue532)
      + weightage541 * qlmetricGradeScale(dataValueGrade541)
    );
  }
  function criteria6Value() {
    return (
      weightage611 * qlmetricGradeScale(dataValueGrade611)
      + weightage621 * qlmetricGradeScale(dataValueGrade621)
      + weightage622 * qlmetricGradeScale(dataValue622)
      + weightage631 * qlmetricGradeScale(dataValueGrade631)
      + weightage632 * qnmetricGradeScale(dataValue632)
      + weightage633 * qnmetricGradeScale(dataValue633)
      + weightage641 * qlmetricGradeScale(dataValueGrade641)
      + weightage651 * qlmetricGradeScale(dataValueGrade651)
      + weightage652 * qnmetricGradeScale(dataValue652)
    );
  }
  function criteria7Value() {
    return (
      weightage711 * qlmetricGradeScale(dataValueGrade711)
      + weightage712 * qnmetricGradeScale(dataValue712)
      + weightage714 * qlmetricGradeScale(dataValueGrade714)
      + weightage713 * qnmetricGradeScale(dataValue713)
      + weightage721 * qlmetricGradeScale(dataValueGrade721)
      + weightage731 * qlmetricGradeScale(dataValueGrade731)
    );
  }

  const criteria1Weightage = criteria1Value();
  const criteria1Grade = parseFloat(criteria1Weightage / criteria1).toFixed(2);
  const criteria11Value = (weightage111 * qlmetricGradeScale(dataValueGrade111));
  const criteria12Value = (weightage121 * qnmetricGradeScale(dataValue121) + weightage122 * qnmetricGradeScale(dataValue122));
  const criteria13Value = (weightage131 * qlmetricGradeScale(dataValueGrade131) + weightage132 * qnmetricGradeScale(dataValue132));
  const criteria14Value = (weightage141 * qnmetricGradeScale(dataValue141));

  const criteria2Weightage = criteria2Value();
  const criteria2Grade = parseFloat(criteria2Weightage / criteria2).toFixed(2);
  const criteria21Value = (weightage211 * qnmetricGradeScale(dataValue211) + weightage212 * qnmetricGradeScale(dataValue212));
  const criteria22Value = (weightage221 * qnmetricGradeScale(dataValue221));
  const criteria23Value = (weightage231 * qlmetricGradeScale(dataValueGrade231));
  const criteria24Value = (weightage241 * qnmetricGradeScale(dataValue241) + weightage242 * qnmetricGradeScale(dataValue242));
  const criteria25Value = (weightage251 * qlmetricGradeScale(dataValueGrade251));
  const criteria26Value = (weightage261 * qlmetricGradeScale(dataValueGrade261) + weightage262 * qnmetricGradeScale(dataValue262));
  const criteria27Value = (weightage271 * qnmetricGradeScale(dataValue271));

  const criteria3Weightage = criteria3Value();
  const criteria3Grade = parseFloat(criteria3Weightage / criteria3).toFixed(2);
  const criteria31Value = (weightage311 * qnmetricGradeScale(dataValue311));
  const criteria32Value = (weightage321 * qlmetricGradeScale(dataValueGrade321) + weightage322 * qnmetricGradeScale(dataValue322));
  const criteria33Value = (weightage331 * qnmetricGradeScale(dataValue331) + weightage332 * qnmetricGradeScale(dataValue332));
  const criteria34Value = (weightage341 * qlmetricGradeScale(dataValueGrade341) + weightage342 * qlmetricGradeScale(dataValueGrade342) + weightage343 * qnmetricGradeScale(dataValue343));
  const criteria35Value = (weightage351 * qnmetricGradeScale(dataValue351));

  const criteria4Weightage = criteria4Value();
  const criteria4Grade = parseFloat(criteria4Weightage / criteria4).toFixed(2);
  const criteria41Value = (weightage411 * qlmetricGradeScale(dataValueGrade411) + weightage412 * qnmetricGradeScale(dataValue412));
  const criteria42Value = (weightage421 * qlmetricGradeScale(dataValueGrade421));
  const criteria43Value = (weightage431 * qlmetricGradeScale(dataValueGrade431) + weightage432 * qnmetricGradeScale(dataValue432));
  const criteria44Value = (weightage441 * qnmetricGradeScale(dataValue441));

  const criteria5Weightage = criteria5Value();
  const criteria5Grade = parseFloat(criteria5Weightage / criteria5).toFixed(2);
  const criteria51Value = (weightage511 * qnmetricGradeScale(dataValue511) + weightage512 * qnmetricGradeScale(dataValue512) + weightage513 * qnmetricGradeScale(dataValue513) + weightage514 * qnmetricGradeScale(dataValue514));
  const criteria52Value = (weightage521 * qnmetricGradeScale(dataValue521) + weightage522 * qnmetricGradeScale(dataValue522));
  const criteria53Value = (weightage531 * qnmetricGradeScale(dataValue531) + weightage532 * qnmetricGradeScale(dataValue532));
  const criteria54Value = (weightage541 * qlmetricGradeScale(dataValueGrade541));

  const criteria6Weightage = criteria6Value();
  const criteria6Grade = parseFloat(criteria6Weightage / criteria6).toFixed(2);
  const criteria61Value = (weightage611 * qlmetricGradeScale(dataValueGrade611));
  const criteria62Value = (weightage621 * qlmetricGradeScale(dataValueGrade621) + weightage622 * qnmetricGradeScale(dataValue622));
  const criteria63Value = (weightage631 * qlmetricGradeScale(dataValueGrade631) + weightage632 * qnmetricGradeScale(dataValue632) + weightage633 * qnmetricGradeScale(dataValue633));
  const criteria64Value = (weightage641 * qlmetricGradeScale(dataValueGrade641));
  const criteria65Value = (weightage651 * qlmetricGradeScale(dataValueGrade651) + weightage652 * qnmetricGradeScale(dataValue652));

  const criteria7Weightage = criteria7Value();
  const criteria7Grade = parseFloat(criteria7Weightage / criteria7).toFixed(2);
  const criteria71Value = (weightage711 * qlmetricGradeScale(dataValueGrade711) + weightage712 * qnmetricGradeScale(dataValue712) + weightage713 * qnmetricGradeScale(dataValue713) + weightage714 * qnmetricGradeScale(dataValue714));
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
      typeofInstitution: instituteType,
    },
    // qulitativequantitativeComments:,
    qulitativequantitativeList: [
      {
        uniqueKey1:101,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage111 * qnmetricGradeScale(dataValue111),
        qnqlt2: parseFloat(criteria12Value / kiWeightage12).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria12Value,
      },
      {
        uniqueKey1:102,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage121 * qnmetricGradeScale(dataValue121),
        qnqlt2: parseFloat(criteria12Value / kiWeightage12).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria12Value,
      },
      {
        uniqueKey1:103,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage122 * qnmetricGradeScale(dataValue122),
        qnqlt2: parseFloat(criteria12Value / kiWeightage12).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria12Value,
      },
      {
        uniqueKey1:104,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage131 * qnmetricGradeScale(dataValue131),
        qnqlt2: parseFloat(criteria13Value / kiWeightage13).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria13Value,
      },
      {
        uniqueKey1:105,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage132 * qnmetricGradeScale(dataValue132),
        qnqlt2: parseFloat(criteria13Value / kiWeightage13).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria13Value,
      },
      {
        uniqueKey1:106,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage141 * qnmetricGradeScale(dataValue141),
        qnqlt2: parseFloat(criteria14Value / kiWeightage14).toFixed(2),
        qnqlt5: criteria1Grade,
        qnqlt4: "" + criteria1Weightage,
        qnqlt3: "" + criteria14Value,
      },
      {
        uniqueKey1:107,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage211 * qnmetricGradeScale(dataValue211),
        qnqlt2: parseFloat(criteria21Value / kiWeightage21).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria21Value,
      },
      {
        uniqueKey1:108,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage211 * qnmetricGradeScale(dataValue212),
        qnqlt2: parseFloat(criteria21Value / kiWeightage21).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria21Value,
      },
      {
        uniqueKey1:109,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage221 * qnmetricGradeScale(dataValue221),
        qnqlt2: parseFloat(criteria22Value / kiWeightage22).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria22Value,
      },
      {
        uniqueKey1:110,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage231 * qnmetricGradeScale(dataValue231),
        qnqlt2: parseFloat(criteria22Value / kiWeightage22).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria22Value,
      },
      {
        uniqueKey1:111,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage241 * qnmetricGradeScale(dataValue241),
        qnqlt2: parseFloat(criteria24Value / kiWeightage24).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria24Value,
      },
      {
        uniqueKey1:112,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage242 * qnmetricGradeScale(dataValue242),
        qnqlt2: parseFloat(criteria24Value / kiWeightage24).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria24Value,
      },
      {
        uniqueKey1:113,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage251 * qnmetricGradeScale(dataValue251),
        qnqlt2: parseFloat(criteria26Value / kiWeightage26).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria26Value,
      },
      {
        uniqueKey1:114,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage261 * qnmetricGradeScale(dataValue261),
        qnqlt2: parseFloat(criteria26Value / kiWeightage26).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria26Value,
      },
      {
        uniqueKey1:115,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage262 * qnmetricGradeScale(dataValue262),
        qnqlt2: parseFloat(criteria26Value / kiWeightage26).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria26Value,
      },
      {
        uniqueKey1:116,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage271 * qnmetricGradeScale(dataValue271),
        qnqlt2: parseFloat(criteria27Value / kiWeightage27).toFixed(2),
        qnqlt5: criteria2Grade,
        qnqlt4: "" + criteria2Weightage,
        qnqlt3: "" + criteria27Value,
      },
      {
        uniqueKey1:117,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage311 * qnmetricGradeScale(dataValue311),
        qnqlt2: parseFloat(criteria31Value / kiWeightage31).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria31Value,
      },
      {
        uniqueKey1:118,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage321 * qlmetricGradeScale(dataValueGrade321),
        qnqlt2: parseFloat(criteria32Value / kiWeightage32).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria32Value,
      },
      {
        uniqueKey1:119,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage322 * qnmetricGradeScale(dataValue322),
        qnqlt2: parseFloat(criteria32Value / kiWeightage32).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria32Value,
      },
      {
        uniqueKey1:120,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage331 * qnmetricGradeScale(dataValue331),
        qnqlt2: parseFloat(criteria33Value / kiWeightage33).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria33Value,
      },
      {
        uniqueKey1:121,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage332 * qnmetricGradeScale(dataValue332),
        qnqlt2: parseFloat(criteria33Value / kiWeightage33).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria33Value,
      },
      {
        uniqueKey1:122,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage341 * qlmetricGradeScale(dataValueGrade341),
        qnqlt2: parseFloat(criteria34Value / kiWeightage34).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria34Value,
      },
      {
        uniqueKey1:123,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage342 * qlmetricGradeScale(dataValueGrade342),
        qnqlt2: parseFloat(criteria34Value / kiWeightage34).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria34Value,
      },
      {
        uniqueKey1:124,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage343 * qnmetricGradeScale(dataValue343),
        qnqlt2: parseFloat(criteria34Value / kiWeightage34).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria34Value,
      },
      {
        uniqueKey1:125,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage351 * qnmetricGradeScale(dataValue351),
        qnqlt2: parseFloat(criteria35Value / kiWeightage35).toFixed(2),
        qnqlt5: criteria3Grade,
        qnqlt4: "" + criteria3Weightage,
        qnqlt3: "" + criteria35Value,
      },
      {
        uniqueKey1:126,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage411 * qnmetricGradeScale(dataValue411),
        qnqlt2: parseFloat(criteria42Value / kiWeightage42).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria42Value,
      },
      {
        uniqueKey1:127,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage412 * qnmetricGradeScale(dataValue412),
        qnqlt2: parseFloat(criteria42Value / kiWeightage42).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria42Value,
      },
      {
        uniqueKey1:128,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage421 * qnmetricGradeScale(dataValue421),
        qnqlt2: parseFloat(criteria42Value / kiWeightage42).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria42Value,
      },
      {
        uniqueKey1:129,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage431 * qnmetricGradeScale(dataValue431),
        qnqlt2: parseFloat(criteria42Value / kiWeightage42).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria42Value,
      },
      {
        uniqueKey1:130,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage432 * qnmetricGradeScale(dataValue432),
        qnqlt2: parseFloat(criteria43Value / kiWeightage43).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria43Value,
      },
      {
        uniqueKey1:131,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage441 * qnmetricGradeScale(dataValue441),
        qnqlt2: parseFloat(criteria44Value / kiWeightage44).toFixed(2),
        qnqlt5: criteria4Grade,
        qnqlt4: "" + criteria4Weightage,
        qnqlt3: "" + criteria44Value,
      },
      {
        uniqueKey1:132,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage511 * qnmetricGradeScale(dataValue511),
        qnqlt2: parseFloat(criteria51Value / kiWeightage51).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria51Value,
      },
      {
        uniqueKey1:133,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage512 * qnmetricGradeScale(dataValue512),
        qnqlt2: parseFloat(criteria51Value / kiWeightage51).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria51Value,
      },
      {
        uniqueKey1:134,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage513 * qnmetricGradeScale(dataValue513),
        qnqlt2: parseFloat(criteria51Value / kiWeightage51).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria51Value,
      },
      {
        uniqueKey1:135,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage514 * qnmetricGradeScale(dataValue514),
        qnqlt2: parseFloat(criteria51Value / kiWeightage51).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria51Value,
      },
      {
        uniqueKey1:136,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage521 * qnmetricGradeScale(dataValue521),
        qnqlt2: parseFloat(criteria52Value / kiWeightage52).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria52Value,
      },
      {
        uniqueKey1:137,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage522 * qnmetricGradeScale(dataValue522),
        qnqlt2: parseFloat(criteria52Value / kiWeightage52).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria52Value,
      },
      {
        uniqueKey1:138,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage531 * qnmetricGradeScale(dataValue531),
        qnqlt2: parseFloat(criteria53Value / kiWeightage53).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria53Value,
      },
      {
        uniqueKey1:139,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage532 * qnmetricGradeScale(dataValue532),
        qnqlt2: parseFloat(criteria53Value / kiWeightage53).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria53Value,
      },
      {
        uniqueKey1:140,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage541 * qnmetricGradeScale(dataValue541),
        qnqlt2: parseFloat(criteria54Value / kiWeightage54).toFixed(2),
        qnqlt5: criteria5Grade,
        qnqlt4: "" + criteria5Weightage,
        qnqlt3: "" + criteria54Value,
      },
      {
        uniqueKey1:141,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage611 * qnmetricGradeScale(dataValue611),
        qnqlt2: parseFloat(criteria62Value / kiWeightage62).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria62Value,
      },
      {
        uniqueKey1:142,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage621 * qnmetricGradeScale(dataValue621),
        qnqlt2: parseFloat(criteria62Value / kiWeightage62).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria62Value,
      },
      {
        uniqueKey1:143,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage622 * qnmetricGradeScale(dataValue622),
        qnqlt2: parseFloat(criteria62Value / kiWeightage62).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria62Value,
      },
      {
        uniqueKey1:144,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage631 * qnmetricGradeScale(dataValue631),
        qnqlt2: parseFloat(criteria63Value / kiWeightage63).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria63Value,
      },
      {
        uniqueKey1:145,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage632 * qnmetricGradeScale(dataValue632),
        qnqlt2: parseFloat(criteria63Value / kiWeightage63).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria63Value,
      },
      {
        uniqueKey1:146,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage633 * qnmetricGradeScale(dataValue633),
        qnqlt2: parseFloat(criteria63Value / kiWeightage63).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria63Value,
      },
      {
        uniqueKey1:147,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage641 * qnmetricGradeScale(dataValue641),
        qnqlt2: parseFloat(criteria64Value / kiWeightage64).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria64Value,
      },
      {
        uniqueKey1:148,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage651 * qnmetricGradeScale(dataValue651),
        qnqlt2: parseFloat(criteria65Value / kiWeightage65).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria65Value,
      },
      {
        uniqueKey1:149,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage652 * qnmetricGradeScale(dataValue652),
        qnqlt2: parseFloat(criteria65Value / kiWeightage65).toFixed(2),
        qnqlt5: criteria6Grade,
        qnqlt4: "" + criteria6Weightage,
        qnqlt3: "" + criteria65Value,
      },
      {
        uniqueKey1:150,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage711 * qnmetricGradeScale(dataValue711),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        uniqueKey1:151,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage712 * qnmetricGradeScale(dataValue712),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        uniqueKey1:152,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage713 * qnmetricGradeScale(dataValue713),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        uniqueKey1:153,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage714 * qnmetricGradeScale(dataValue714),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        uniqueKey1:154,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage721 * qnmetricGradeScale(dataValue721),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
      {
        uniqueKey1:155,
        criteriaId: { collegeId: collegeId, financialYear: fYear, typeofInstitution: instituteType },
        qnqlt1: "" + weightage731 * qnmetricGradeScale(dataValue731),
        qnqlt2: parseFloat(criteria71Value / kiWeightage71).toFixed(2),
        qnqlt5: criteria7Grade,
        qnqlt4: "" + criteria7Weightage,
        qnqlt3: "" + criteria71Value,
      },
    ],
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
    qnqlData.append("qualitativeQuantitativeInfo", jsonBlob(inputDataList));
    const filesFetchMethod = {
      method: "POST",
      headers: { Accept: "application/json ,text/plain" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: qnqlData,
    };
    fetch(
      resources.APPLICATION_URL+"saveQualitativeQuantitaveData",
      filesFetchMethod
    ).then((response) => {
      console.log(response);
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
            {/* ADVV - 2  (Adiverse data validation) Response */}
            ADVV - 2
            </th>
            <th style={{ width: '120px' }}>Metric Grade scale (0-4)</th>
            <th style={{ width: '120px' }}>
              {/* Metric wise weighted Grade points */}
              Metric weighted Grade
            </th>
            <th style={{ width: '120px' }}>KI wise Weighted Grade</th>
            <th style={{ width: '120px' }}>KI wise Grade Point Average</th>
            <th style={{ width: '100px' }}>Criteria (W)</th>
            <th style={{ width: '120px' }}>
              {/* Criteria wise Grade Point Average */}
              Criteria Grade
            </th>
          </tr>
          <tr>
            <td>1.</td>
            <td rowspan="6">Curricular Aspects</td>
            <td rowspan="1">Curriculum Planning and Implementation</td>
            <td>1.1.1</td>
            <td>QI</td>
            <td>
              The Institution ensures effective curriculum planning and delivery
              through a well-planned and documented process including Academic
              calendar and conduct of continuous internal Assessment
            </td>
            <td>{weightage111}</td>
            <td rowspan="1">{kiWeightage11}</td>
            <td rowspan="6">{criteria1}</td>
            <td>
              <input
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
            <td>
              <p>{criteria11Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria11Value / kiWeightage11).toFixed(2)}</p>
            </td>
            <td rowSpan="6">
              <p>{criteria1Weightage}</p>
            </td>
            <td rowSpan="6">
              <p>{criteria1Grade}</p>
            </td>
          </tr>
          <tr>
            <td>2.</td>
            <td rowspan="2">Academic Flexibility</td>
            <td>1.2.1</td>
            <td>QN</td>
            <td>
              Number of Add on /Certificate/Value added programs offered during
              the last five years
            </td>
            <td>{weightage121}</td>
            <td rowspan="2">{kiWeightage12}</td>
            <td>
              <input
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
            <td>3.</td>
            <td>1.2.2</td>
            <td>QN</td>
            <td>
              Percentage of students enrolled in Certificate/ Add-on/Value added
              programs as against the total number of students during the last five
              years
            </td>
            <td>{weightage122}</td>
            <td>
              <input
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
            <td>4.</td>
            <td rowspan="2">Curriculum Enrichment</td>
            <td>1.3.1</td>
            <td>QI</td>
            <td>
              Institution integrates crosscutting issues relevant to Professional
              Ethics, Gender, Human Values, Environment and Sustainability into
              the Curriculum.
            </td>
            <td>{weightage131}</td>
            <td rowspan="2">{kiWeightage13}</td>
            <td>
              <input
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
            <td rowSpan="2">
              {criteria13Value}
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria13Value / kiWeightage11).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>5.</td>
            <td>1.3.2</td>
            <td>QN</td>
            <td>
              Percentage of students undertaking project work/field work/
              internships (Data for the latest completed academic year)
            </td>
            <td>{weightage132}</td>
            <td>
              <input
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
            <td>6.</td>
            <td rowspan="1">Feedback System</td>
            <td>1.4.1</td>
            <td>QN</td>
            <td>
              Institution obtains feedback on the academic performance and
              ambience of the institution from various stakeholders, such as
              Students, Teachers, Employers, Alumni etc. and action taken report on
              the feedback is made available on institutional website (Yes or No)
            </td>
            <td>{weightage141}</td>
            <td>{kiWeightage14}</td>
            <td>
              <input
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
            <td>
              <p>{criteria14Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria14Value / kiWeightage14).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>7.</td>
            <td rowspan="10">Teaching Learning and Evaluation</td>
            <td rowspan="2">Student Enrolment and Profile</td>
            <td>2.1.1</td>
            <td>QN</td>
            <td>Enrolment percentage </td>
            <td>{weightage211}</td>
            <td rowspan="2">{kiWeightage21}</td>
            <td rowspan="10">{criteria2}</td>
            <td>
              <input
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
            <td rowSpan="10">
              <p>{criteria2Weightage}</p>
            </td>
            <td rowSpan="10">
              <p>{criteria2Grade}</p>
            </td>
          </tr>
          <tr>
            <td>8.</td>
            <td>2.1.2</td>
            <td>QN</td>
            <td>
              Percentage of seats filled against seats reserved for various categories
              (SC, ST, OBC, Divyangjan, etc. as per applicable reservation policy
              during the last five years
              (Exclusive of supernumerary seats)
            </td>
            <td>{weightage212}</td>
            <td>
              <input
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
            <td>9.</td>
            <td>Student Teacher Ratio</td>
            <td>2.2.1</td>
            <td>QN</td>
            <td>
              Student – Full time Teacher Ratio
              (Data for the latest completed academic year)
            </td>
            <td>{weightage221}</td>
            <td>{kiWeightage21}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue221}
                value={dataValue221}
                onChange={(e) => {
                  setDataValue221(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue221)}</p>
            </td>
            <td>
              <p>{weightage221 * qnmetricGradeScale(dataValue221)}</p>
            </td>
            <td>
              <p>{criteria22Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria22Value / kiWeightage21).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>10.</td>
            <td>Teaching-Learning Process</td>
            <td>2.3.1</td>
            <td>QI</td>
            <td>
              Student centric methods, such as experiential learning, participative
              learning and problem solving methodologies are used for enhancing
              learning experiences using ICT tools
            </td>
            <td>{weightage231}</td>
            <td>{kiWeightage23}</td>
            <td>
              <input
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
            <td>
              <p>{criteria23Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria23Value / kiWeightage23).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>11.</td>
            <td rowspan="2">Teacher Profile and Quality</td>
            <td>2.4.1</td>
            <td>QN</td>
            <td>
              Percentage of full-time teachers against sanctioned posts during the
              last five years
            </td>
            <td>{weightage241}</td>
            <td rowspan="2">{kiWeightage24}</td>
            <td>
              <input
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
            <td rowSpan="2">
              <p>{criteria24Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria24Value / kiWeightage24).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>12.</td>
            <td>2.4.2</td>
            <td>QN</td>
            <td>
              Percentage of full time teachers with NET/SET/SLET/ Ph. D. / D.M. /
              M.Ch. / D.N.B Superspeciality / D.Sc. / D.Litt. during the last five
              years (consider only highest degree for count)
            </td>
            <td>{weightage242}</td>
            <td>
              <input
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
            <td>13.</td>
            <td>Evaluation Process and Reforms</td>
            <td>2.5.1</td>
            <td>QL</td>
            <td>
              Mechanism of internal/ external assessment is transparent and the
              grievance redressal system is time- bound and efficient
            </td>
            <td>{weightage251}</td>
            <td>{kiWeightage25}</td>
            <td>
              <input
                rows="10"
                type="text"
                value={dataValue251}
                onChange={(e) => {
                  setDataValue251(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                type="text"
                value={dataValueGrade251}
                onChange={(e) => {
                  setDataValueGrade251(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage251 * qlmetricGradeScale(dataValueGrade251)}</p>
            </td>
            <td>
              <p>{criteria25Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria25Value / kiWeightage25).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>14.</td>
            <td rowspan="2">Student Performance and Learning Outcomes</td>
            <td>2.6.1</td>
            <td>QL</td>
            <td>
              Programme Outcomes (POs) and Course Outcomes (COs) for all
              Programmes offered by the institution are stated and displayed on
              website and attainment of POs and COs are evaluated
            </td>
            <td>{weightage261}</td>
            <td rowspan="2">{kiWeightage26}</td>
            <td>
              <input
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
            <td rowspan="2">
              <p>{criteria26Value}</p>
            </td>
            <td rowspan="2">
              <p>{parseFloat(criteria26Value / kiWeightage26).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>15.</td>
            <td>2.6.2</td>
            <td>QN</td>
            <td>
              Pass percentage of Students during last five years
            </td>
            <td>{weightage262}</td>
            <td>
              <input
                type="text"
                placeholder={dataValue262}
                value={dataValue262}
                onChange={(e) => {
                  setDataValue262(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue262)}</p>
            </td>
            <td>
              <p>{weightage262 * qnmetricGradeScale(dataValue262)}</p>
            </td>
          </tr>
          <tr>
            <td>16.</td>
            <td>Student Satisfaction Survey</td>
            <td>2.7.1</td>
            <td>QN</td>
            <td>
              Online student satisfaction survey regarding to teaching learning process.
              (Online survey to be conducted)
            </td>
            <td>{weightage271}</td>
            <td>{kiWeightage27}</td>
            <td>
              <input
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
            <td>17.</td>
            <td rowspan="9">Research, Innovations and Extension</td>
            <td>Resource Mobilization for Research</td>
            <td>3.1.1</td>
            <td>QN</td>
            <td>
              Grants received from Government and non-governmental agencies for
              research projects / endowments in the institution during the last five
              years (INR in Lakhs)
            </td>
            <td>{weightage311}</td>
            <td>{kiWeightage31}</td>
            <td rowspan="9">{criteria3}</td>
            <td>
              <input
                type="text"
                value={dataValue311}
                onChange={(e) => {
                  setDataValue311(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue311)}</p>
            </td>
            <td >
              <p>{weightage311 * qnmetricGradeScale(dataValue311)}</p>
            </td>
            <td>
              <p>{criteria31Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria31Value / kiWeightage31).toFixed(2)}</p>
            </td>
            <td rowSpan="9">
              <p>{criteria3Weightage}</p>
            </td>
            <td rowSpan="9">
              <p>{criteria3Grade}</p>
            </td>
          </tr>
          <tr>
            <td>18.</td>
            <td rowspan="2">Innovation Ecosystem</td>
            <td>3.2.1</td>
            <td>QI</td>
            <td>
              Institution has created an ecosystem for innovations and has
              initiatives for creation and transfer of knowledge
              (patents filed, published, incubation center facilities in the HEI to be
              considered)
            </td>
            <td>{weightage321}</td>
            <td rowspan="2">{kiWeightage32}</td>
            <td>
              <input
                rows="10"
                type="text"
                placeholder={dataValue321}
                value={dataValue321}
                onChange={(e) => {
                  setDataValue321(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                type="text"
                placeholder={dataValueGrade321}
                value={dataValueGrade321}
                onChange={(e) => {
                  setDataValueGrade321(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage321 * qnmetricGradeScale(dataValue321)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteria32Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria32Value / kiWeightage32).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>19.</td>
            <td>3.2.2</td>
            <td>QN</td>
            <td>
              Number of workshops/seminars/conferences including on Research
              Methodology, Intellectual Property Rights (IPR) and
              entrepreneurship conducted during the last five years
            </td>
            <td>{weightage322}</td>
            <td>
              <input
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
            <td>20.</td>
            <td rowSpan="2">Research Publication and Awards</td>
            <td>3.3.1</td>
            <td>QN</td>
            <td>nstitution has created an eco system for innovations, creation and transfer of knowledge supported by dedicated centers for research, entrepreneurship, community orientation, Incubation etc.</td>
            <td>{weightage331}</td>
            <td rowSpan="2">{kiWeightage32}</td>
            <td>
              <input
                type="text"
                value={dataValue331}
                onChange={(e) => {
                  setDataValue331(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue331)}</p>
            </td>
            <td>
              <p>{weightage331 * qnmetricGradeScale(dataValue331)}</p>
            </td>
            <td rowSpan="2">
              <p>{criteria33Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria33Value / kiWeightage33).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>21.</td>
            <td>3.3.2</td>
            <td>QN</td>
            <td>
              Number of books and chapters in edited volumes/books published
              and papers published in national/ international conference
              proceedings per teacher during last five years
            </td>
            <td>{weightage332}</td>
            <td>
              <input
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
            <td>22.</td>
            <td rowspan="3">Extension Activities</td>
            <td>3.4.1</td>
            <td>QL</td>
            <td>
              Extension activities are carried out in the neighborhood
              community, sensitizing students to social issues, for their holistic
              development, and impact thereof during the last five years.
            </td>
            <td>{weightage341}</td>
            <td rowspan="3">{kiWeightage34}</td>
            <td>
              <input
                rows="10"
                type="text"
                placeholder={dataValue341}
                value={dataValue341}
                onChange={(e) => {
                  setDataValue341(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                type="text"
                placeholder={dataValueGrade341}
                value={dataValueGrade341}
                onChange={(e) => {
                  setDataValueGrade341(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage341 * qlmetricGradeScale(dataValueGrade341)}</p>
            </td>
            <td rowSpan="3">
              <p>{criteria34Value}</p>
            </td>
            <td rowSpan="3">
              <p>{parseFloat(criteria34Value / kiWeightage34).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>23.</td>
            <td>3.4.2</td>
            <td>QL</td>
            <td>
              Awards and recognitions received for extension activities from
              government / government recognised bodies
            </td>
            <td>{weightage342}</td>
            <td>
              <input
                rows="10"
                type="text"
                placeholder={dataValue342}
                value={dataValue342}
                onChange={(e) => {
                  setDataValue342(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                type="text"
                placeholder={dataValueGrade342}
                value={dataValueGrade342}
                onChange={(e) => {
                  setDataValueGrade342(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage342 * qlmetricGradeScale(dataValueGrade342)}</p>
            </td>
          </tr>
          <tr>
            <td>24.</td>
            <td>3.4.3</td>
            <td>QN</td>
            <td>
              Number of extension and outreach programs conducted by the
              institution through NSS/NCC/Red cross/YRC etc., (including the
              programmes such as Swachh Bharat, AIDS awareness, Gender
              issues etc. and/or those organised in collaboration with industry,
              community and NGOs) during the last five years
            </td>
            <td>{weightage343}</td>
            <td>
              <input
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
            <td>25.</td>
            <td>Collaboration</td>
            <td>3.5.1</td>
            <td>QN</td>
            <td>
              The number of MoUs, collaborations/linkages for Faculty
              exchange, Student exchange, Internship, Field trip, On-the- job
              training, research and other academic activities during the last
              five years
            </td>
            <td>{weightage351}</td>
            <td>{kiWeightage35}</td>
            <td>
              <input
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
            <td>
              <p>{criteria35Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria35Value / kiWeightage35).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>26.</td>
            <td rowspan="6">Infrastructure and Learning Resources</td>
            <td rowspan="2">Physical Facilities</td>
            <td>4.1.1</td>
            <td>QI</td>
            <td>
              Availability of adequate infrastructure and physical facilities viz.,
              classrooms, laboratories, ICT facilities, cultural activities,
              gymnasium, yoga centre etc. in the institution
            </td>
            <td>{weightage411}</td>
            <td rowspan="2">{kiWeightage41}</td>
            <td rowspan="6">{criteria4}</td>
            <td>
              <input
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
            <td rowSpan="2">
              <p>{criteria41Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria41Value / kiWeightage41).toFixed(2)}</p>
            </td>
            <td rowSpan="6">
              <p>{criteria4Weightage}</p>
            </td>
            <td rowSpan="6">
              <p>{criteria4Grade}</p>
            </td>
          </tr>
          <tr>
            <td>27.</td>
            <td>4.1.2</td>
            <td>QN</td>
            <td>
              Percentage of expenditure, excluding salary for infrastructure
              augmentation during last five years (INR in Lakhs)
            </td>
            <td>{weightage412}</td>
            <td>
              <input
                type="text"
                value={dataValue412}
                onChange={(e) => {
                  setDataValue412(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue412)}</p>
            </td>
            <td>
              <p>{weightage412 * qnmetricGradeScale(dataValue412)}</p>
            </td>
          </tr>
          <tr>
            <td>28.</td>
            <td>Library as a learning Resource</td>
            <td>4.2.1</td>
            <td>QI</td>
            <td>
              Library is automated using Integrated Library Management
              System (ILMS), subscription to e-resources, amount spent on
              purchase of books, journals and per day usage of library
            </td>
            <td>{weightage421}</td>
            <td>{kiWeightage42}</td>
            <td>
              <input
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
            <td>29.</td>
            <td rowspan="2">IT Infrastructure</td>
            <td>4.3.1</td>
            <td>QI</td>
            <td>
              Institution frequently updates its IT facilities and provides
              sufficient bandwidth for internet connection
            </td>
            <td>{weightage431}</td>
            <td rowspan="2">{kiWeightage43}</td>
            <td>
              <input
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
            <td rowspan="2">
              <p>{criteria43Value}</p>
            </td>
            <td rowspan="2">
              <p>{parseFloat(criteria43Value / kiWeightage43).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>30.</td>
            <td>4.3.2</td>
            <td>QN</td>
            <td>
              Student – Computer ratio (Data for the latest completed academic year)
            </td>
            <td>{weightage432}</td>
            <td>
              <input
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
            <td>31.</td>
            <td>Maintenance of Campus Infrastructure</td>
            <td>4.4.1</td>
            <td>QN</td>
            <td>
              Percentage of expenditure incurred on maintenance of infrastructure
              (physical and academic support facilities) excluding salary component
              during the last five years (INR in Lakhs)
            </td>
            <td>{weightage441}</td>
            <td>{kiWeightage44}</td>
            <td>
              <input
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
            <td>
              <p>{criteria44Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria44Value / kiWeightage44).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>32.</td>
            <td rowspan="9">Student Support and Progression</td>
            <td rowspan="4">Student Support</td>
            <td>5.1.1</td>
            <td>QN</td>
            <td>
              Percentage of students benefited by scholarships and freeships provided
              by the Government and Non-Government agencies during last five year
            </td>
            <td>{weightage511}</td>
            <td rowspan="4">{kiWeightage51}</td>
            <td rowspan="9">{criteria5}</td>
            <td>
              <input
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
            <td rowSpan="4">
              <p>{criteria51Value}</p>
            </td>
            <td rowSpan="4">
              <p>{parseFloat(criteria51Value / kiWeightage51).toFixed(2)}</p>
            </td>
            <td rowSpan="9">
              <p>{criteria5Weightage}</p>
            </td>
            <td rowSpan="9">
              <p>{criteria5Grade}</p>
            </td>
          </tr>
          <tr>
            <td>33.</td>
            <td>5.1.2</td>
            <td>QN</td>
            <td>
              Capacity building and skills enhancement initiatives taken by the
              institution include the following
              1. Soft skills
              2. Language and communication skills
              3. Life skills (Yoga, physical fitness, health and hygiene)
              4. ICT/computing skills
            </td>
            <td>{weightage512}</td>
            <td>
              <input
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
            <td>34.</td>
            <td>5.1.3</td>
            <td>QN</td>
            <td>
              Percentage of students benefitted by guidance for competitive
              examinations and career counseling offered by the Institution during
              the last five years
            </td>
            <td>{weightage513}</td>
            <td>
              <input
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
            <td>35.</td>
            <td>5.1.4</td>
            <td>QN</td>
            <td>
              The Institution has a transparent mechanism for timely redressal of
              student grievances including sexual harassment and ragging cases
              1. Implementation of guidelines of statutory/regulatory bodies
              2. Organisation wide awareness and undertakings on policies with zero
              tolerance
              3. Mechanisms for submission of online/offline students’ grievances
              4. Timely redressal of the grievances through appropriate committees
            </td>
            <td>{weightage514}</td>
            <td>
              <input
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
            <td>36.</td>
            <td rowspan="2">Student Progression</td>
            <td>5.2.1</td>
            <td>QN</td>
            <td>
              Percentage of placement of outgoing students and students progressing to higher
              education during the last five years
            </td>
            <td>{weightage521}</td>
            <td rowspan="2">{kiWeightage52}</td>
            <td>
              <input
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
            <td rowSpan="2">
              <p>{criteria52Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria52Value / kiWeightage52).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>37.</td>
            <td>5.2.2</td>
            <td>QN</td>
            <td>
              Percentage of students qualifying in state/national/ international level
              examinations during the last five years (eg: JAM/CLAT/GATE/ GMAT/ CAT/
              GRE/ TOEFL/ Civil Services/State government examinations)
            </td>
            <td>{weightage522}</td>
            <td>
              <input
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
            <td>38.</td>
            <td rowspan="2">Student Participation and Activities</td>
            <td>5.3.1</td>
            <td>QN</td>
            <td>
              Number of awards/medals for outstanding performance in sports/
              cultural activities at University / state/ national / international level
              (award for a team event should be counted as one) during the last five
              years
            </td>
            <td>{weightage531}</td>
            <td rowspan="2">{kiWeightage53}</td>
            <td>
              <input
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
            <td rowSpan="2">
              <p>{criteria53Value}</p>
            </td>
            <td rowSpan="2">
              <p>{parseFloat(criteria53Value / kiWeightage53).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>39.</td>
            <td>5.3.2</td>
            <td>QN</td>
            <td>
              Average number of sports and cultural programs in which students of the
              Institution participated during last five years (organised by the
              institution/other institutions)
            </td>
            <td>{weightage532}</td>
            <td>
              <input
                type="text"
                value={dataValue532}
                onChange={(e) => {
                  setDataValue532(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue532)}</p>
            </td>
            <td>
              <p>{weightage532 * qnmetricGradeScale(dataValue532)}</p>
            </td>
          </tr>
          <tr>
            <td>40.</td>
            <td>Alumni Engagement</td>
            <td>5.4.1</td>
            <td>QI</td>
            <td>
              There is a registered Alumni Association that contributes significantly
              to the development of the institution through financial and/or other
              support services
            </td>
            <td>{weightage541}</td>
            <td>{kiWeightage54}</td>
            <td>
              <input
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
            <td>
              <p>{criteria54Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria54Value / kiWeightage54).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>41.</td>
            <td rowspan="9">Governance, Leadership and Management</td>
            <td>Institutional Vision and Leadership</td>
            <td>6.1.1</td>
            <td>QI</td>
            <td>
              The governance and leadership is in accordance with vision and
              mission of the institution and it is visible in various institutional
              practices such as decentralization and participation in the
              institutional governance
            </td>
            <td>{weightage611}</td>
            <td>{kiWeightage61}</td>
            <td rowspan="9">{criteria6}</td>
            <td>
              <input
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
            <td>
              <p>{criteria61Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria61Value / kiWeightage61).toFixed(2)}</p>
            </td>
            <td rowSpan="9">
              <p>{criteria6Weightage}</p>
            </td>
            <td rowSpan="9">
              <p>{criteria6Grade}</p>
            </td>
          </tr>
          <tr>
            <td>42.</td>
            <td rowspan="2">Strategy Development and Deployment</td>
            <td>6.2.1</td>
            <td>QI</td>
            <td>
              The functioning of the institutional bodies is effective and efficient
              as visible from policies, administrative setup, appointment and
              service rules, procedures, deployment of institutional Strategic/
              perspective/development plan etc
            </td>
            <td>{weightage621}</td>
            <td rowspan="2">{kiWeightage62}</td>
            <td>
              <input
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
            <td rowspan="2">
              <p>{criteria62Value}</p>
            </td>
            <td rowspan="2">
              <p>{parseFloat(criteria62Value / kiWeightage62).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>43.</td>
            <td>6.2.2</td>
            <td>QN</td>
            <td>
              Implementation of e-governance in areas of operation
              1. Administration
              2. Finance and Accounts
              3. Student Admission and Support
              4. Examination
            </td>
            <td>{weightage622}</td>
            <td>
              <input
                type="text"
                value={dataValue622}
                onChange={(e) => {
                  setDataValue622(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue622)}</p>
            </td>
            <td>
              <p>{weightage622 * qnmetricGradeScale(dataValue622)}</p>
            </td>
          </tr>
          <tr>
            <td>44.</td>
            <td rowspan="3">Faculty Empowerment Strategies</td>
            <td>6.3.1</td>
            <td>QI</td>
            <td>
              The institution has effective welfare measures and Performance
              Appraisal System for teaching and non-teaching staff
            </td>
            <td>{weightage631}</td>
            <td rowspan="3">{kiWeightage63}</td>
            <td>
              <input
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
            <td rowspan="3">
              <p>{criteria63Value}</p>
            </td>
            <td rowspan="3">
              <p>{parseFloat(criteria63Value / kiWeightage63).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>45.</td>
            <td>6.3.2</td>
            <td>QN</td>
            <td>
              Percentage of teachers provided with financial support to attend
              conferences/workshops and towards membership fee of professional
              bodies during the last five years
            </td>
            <td>{weightage632}</td>
            <td>
              <input
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
            <td>46.</td>
            <td>6.3.3</td>
            <td>QN</td>
            <td>
              Percentage of teachers provided with financial support to attend
              conferences/workshops and towards membership fee of professional
              bodies during the last five years
            </td>
            <td>{weightage633}</td>
            <td>
              <input
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
            <td>47.</td>
            <td>Financial Management and Resource Mobilization</td>
            <td>6.4.1</td>
            <td>QI</td>
            <td>
              Institution has strategies for mobilization and optimal utilization of
              resources and funds from various sources (government/ non-government organizations) and it conducts financial audits
              regularly (internal and external)
            </td>
            <td>{weightage641}</td>
            <td>{kiWeightage64}</td>
            <td>
              <input
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
            <td>
              <p>{criteria64Value}</p>
            </td>
            <td>
              <p>{parseFloat(criteria64Value / kiWeightage64).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>48.</td>
            <td rowspan="2">Internal Quality Assurance System</td>
            <td>6.5.1</td>
            <td>QI</td>
            <td>
              Internal Quality Assurance Cell (IQAC) has contributed
              significantly for institutionalizing the quality assurance strategies
              and processes. It reviews teaching learning process, structures &
              methodologies of operations and learning outcomes at periodic
              intervals and records the incremental improvement in various
              activities
            </td>
            <td>{weightage651}</td>
            <td rowspan="2">{kiWeightage65}</td>
            <td>
              <input
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
            <td rowspan="2">
              <p>{criteria65Value}</p>
            </td>
            <td rowspan="2">
              <p>{parseFloat(criteria65Value / kiWeightage65).toFixed(2)}</p>
            </td>
          </tr>
          <tr>
            <td>49.</td>
            <td>6.5.2</td>
            <td>QN</td>
            <td>
              Internal Quality Assurance Cell (IQAC) has contributed
              significantly for institutionalizing the quality assurance strategies
              and processes. It reviews teaching learning process, structures &
              methodologies of operations and learning outcomes at periodic
              intervals and records the incremental improvement in various
              activities
            </td>
            <td>{weightage652}</td>
            <td>
              <input
                type="text"
                value={dataValue652}
                onChange={(e) => {
                  setDataValue652(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue652)}</p>
            </td>
            <td>
              <p>{weightage652 * qnmetricGradeScale(dataValue652)}</p>
            </td>
          </tr>
          <tr>
            <td>50.</td>
            <td rowspan="6">Institutional Values and Best Practices</td>
            <td rowspan="4">Institutional Values and Social Responsibilities</td>
            <td>7.1.1</td>
            <td>QI</td>
            <td>
              Measures initiated by the Institution for the promotion of gender
              equity and Institutional initiatives to celebrate / organize national
              and international commemorative days, events and festivals during
              the last five years
            </td>
            <td>{weightage711}</td>
            <td rowspan="4">{kiWeightage71}</td>
            <td rowspan="6">{criteria7}</td>
            <td>
              <input
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
            <td rowspan="4">
              <p>{criteria71Value}</p>
            </td>
            <td rowspan="4">
              <p>{parseFloat(criteria71Value / kiWeightage71).toFixed(2)}</p>
            </td>
            <td rowSpan="6">
              <p>{criteria7Weightage}</p>
            </td>
            <td rowSpan="6">
              <p>{criteria7Grade}</p>
            </td>
          </tr>
          <tr>
            <td>51.</td>
            <td>7.1.2</td>
            <td>QN</td>
            <td>
              The Institution has facilities and initiatives for
              1. Alternate sources of energy and energy conservation
              measures
              2. Management of the various types of degradable and non-degradable waste
              3. Water conservation
              4. Green campus initiatives
              5. Disabled-friendly, barrier free environment
            </td>
            <td>{weightage712}</td>
            <td>
              <input
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
            <td>52.</td>
            <td>7.1.3</td>
            <td>QN</td>
            <td>
              Quality audits on environment and energy regularly undertaken by
              the Institution.
              The institutional environment and energy initiatives are confirmed
              through the following
              1. Green audit / Environment audit
              2. Energy audit
              3. Clean and green campus initiatives
              4. Beyond the campus environmental promotion activities
            </td>
            <td>{weightage713}</td>
            <td>
              <input
                type="text"
                value={dataValue713}
                onChange={(e) => {
                  setDataValue713(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{qnmetricGradeScale(dataValue713)}</p>
            </td>
            <td>
              <p>{weightage713 * qnmetricGradeScale(dataValue713)}</p>
            </td>
          </tr>
          <tr>
            <td>53.</td>
            <td>7.1.4</td>
            <td>QI</td>
            <td>
              Describe the Institutional efforts/initiatives in providing an
              inclusive environment i.e., tolerance and harmony towards
              cultural, regional, linguistic, communal socioeconomic and
              Sensitization of students and employees to the constitutional
              obligations: values, rights, duties and responsibilities of citizens
            </td>
            <td>{weightage714}</td>
            <td>
              <input
                rows="10"
                type="text"
                placeholder={dataValue714}
                value={dataValue714}
                onChange={(e) => {
                  setDataValue714(e.target.value);
                }}
              ></input>
            </td>
            <td>
              <input
                type="text"
                value={dataValueGrade714}
                onChange={(e) => {
                  setDataValueGrade714(e.target.value);
                }}
              />
            </td>
            <td>
              <p>{weightage714 * qnmetricGradeScale(dataValueGrade714)}</p>
            </td>
          </tr>
          <tr>
            <td>54.</td>
            <td>Best Practices</td>
            <td>7.2.1</td>
            <td>QI</td>
            <td>
              Describe two best practices successfully implemented by the
              Institution as per NAAC format provided in the Manual
            </td>
            <td>{weightage721}</td>
            <td>{kiWeightage72}</td>
            <td>
              <input
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
            <td>55.</td>
            <td>Institutional Distinctiveness</td>
            <td>7.3.1</td>
            <td>QI</td>
            <td>
              Portray the performance of the Institution in one area distinctive
              to its priority and thrust within 1000 words
            </td>
            <td>{weightage731}</td>
            <td>{kiWeightage73}</td>
            <td>
              <input
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
