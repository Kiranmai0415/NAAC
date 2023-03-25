import React from 'react';
import { Helmet } from 'react-helmet';
import brand from 'dan-api/dummy/brand';
import { PapperBlock } from 'dan-components';

function DeanDashboard() {
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
      <PapperBlock title="Dashboard" desc="Information for Dean">
        <div><h1>Authorize</h1> Dean can Authorize or Reject the details entered by faculty and approved by dean.</div>
        <div><h1>View</h1> Dean can view authorized, rejected records.</div>
      </PapperBlock>
    </div>
  );
}

export default DeanDashboard;
