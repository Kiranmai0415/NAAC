import React from 'react';
import { Helmet } from 'react-helmet';
import brand from 'dan-api/dummy/brand';
import { PapperBlock } from 'dan-components';

function FacultyDashboard() {
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
      <PapperBlock title="Dashboard" desc="Information for Faculty">
        <div><h1>Authorize</h1> Principal can Authorize or Reject the details entered by faculty and approved by dean.</div>
        <div><h1>View</h1> Principal can view authorized, rejected records.</div>
      </PapperBlock>
    </div>
  );
}

export default FacultyDashboard;
