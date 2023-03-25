import React from 'react';
import { Helmet } from 'react-helmet';
import brand from 'dan-api/dummy/brand';
import { PapperBlock } from 'dan-components';

function DownloadExcelReport() {
  const title = brand.name + ' - Blank Page';
  const description = brand.desc;
  return (
    <div>
      


      <Helmet>
        <title>{title}</title>
        <meta name="description" content={description} />
        <meta property="og:title" content={title} />
        <meta property="og:description" content={description} />
        <meta property="twitter:title" content={title} />
        <meta property="twitter:description" content={description} />
      </Helmet>
      <PapperBlock title="Excel Sheet Format" desc="Find data in the form of Excel Sheet">
        <div>Download the data in excel format.</div>
        <br></br>
        <div>IIQA <a href="http://localhost:8080/api/v1/export/excel/Affiliated/IIQA">IIQA</a>.</div>

        <div>criteria1 <a href="http://localhost:8080/api/v1/export/excel/Affiliated/criteria1">criteria1</a>.</div>
        <div>criteria2 <a href="http://localhost:8080/api/v1/export/excel/Affiliated/criteria2">criteria2</a>.</div>
        <div>criteria3 <a href="http://localhost:8080/api/v1/export/excel/Affiliated/criteria3">criteria3</a>.</div>
        <div>criteria4 <a href="http://localhost:8080/api/v1/export/excel/Affiliated/criteria4">criteria4</a>.</div>
        <div>criteria5 <a href="http://localhost:8080/api/v1/export/excel/Affiliated/criteria5">criteria5</a>.</div>
        <div>criteria6 <a href="http://localhost:8080/api/v1/export/excel/Affiliated/criteria6">criteria6</a>.</div>
        <div>criteria7 <a href="http://localhost:8080/api/v1/export/excel/Affiliated/criteria7">criteria7</a>.</div>
        <div>Executive summary <a href="http://localhost:8080/api/v1/export/excel/Affiliated/executive">Executive summary</a>.</div>
        <div>Evaluative Report Main <a href="http://localhost:8080/api/v1/export/excel/Affiliated/evaluativeReportMain">evaluativeReportMain </a>.</div>
        <div>SSR All Records <a href="http://localhost:8080/api/v1/export/excel/Affiliated/Ssr">SSR All Records </a>.</div>


      </PapperBlock>


      

    </div>



     
   
  );
}

export default DownloadExcelReport;
