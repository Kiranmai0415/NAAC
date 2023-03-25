import React from 'react';
import { Helmet } from 'react-helmet';
import brand from 'dan-api/dummy/brand';
import { PapperBlock } from 'dan-components';

function PrincipalDashboard() {
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
      <PapperBlock title="Reports Section" desc="Generate Quality Profile Report">
        <div><h1>Note</h1> Please review Qualitative Advisor & Quantitative Advisor Screens before generation of Quality Profile Report.</div>
      </PapperBlock>
      <div>
        Please click on Link to generate the report : <a href="http://localhost:8080/api/v1/pdf/generate">
                    Generate Report
        </a>
      </div>
    </div>
  );
}

export default PrincipalDashboard;
