import React from 'react';
import { Helmet } from 'react-helmet';
import brand from 'dan-api/dummy/brand';
import { PapperBlock } from 'dan-components';

function ReferenceDocs() {
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
      <PapperBlock title="Reference Docs" desc="Information for Filling Forms">
        <div>Reference Documents find here.</div>
        <br></br>
        <PapperBlock title="Reference Docs" desc="Information for Filling Forms">
          <div>Reference Documents find here.</div>
          <br></br>
          <div>Download Sample SSR Report For Autonomous <a href="http://localhost:8080/api/v1/download/GEETHANJALI_SSR.pdf">GEETHANJALI_SSR</a>.</div>
          <br></br>
          <div>Download Sample SSR Report For Affiliated <a href="http://localhost:8080/api/v1/download/JYOTHI ENGINEERING COLLEGE NAAC-SSR-Feb2022.pdf">JYOTHI ENGINEERING COLLEGE NAAC-SSR-Feb2022</a>.</div>
          <br></br>
          <div>Download Sample SSR Report For University <a href="http://localhost:8080/api/v1/download/NAAC SSR after pre qualification pass status.pdf">MANIPAL ACADEMY OF HIGHER EDUCATION</a>.</div>
        </PapperBlock>
      </PapperBlock>
    </div>
  );
}

export default ReferenceDocs;
