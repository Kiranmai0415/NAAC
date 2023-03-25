/* eslint-disable */

import React from "react";
import Loading from "dan-components/Loading";
import loadable from "../utils/loadable";

export const NIRF = loadable(() => import("./NIRF/NIRF"), {
  fallback: <Loading />,
});  

export const InternshipListAuthorize  = loadable(() => import("./Intern Forms/Intern Authorize/Internship List Authorize/I1"), {
  fallback: <Loading />,
});

export const InternshipListModify   = loadable(() => import("./Intern Forms/Intern Modify/Internship List Modify/I1"), {
  fallback: <Loading />,
});

export const InternshipListView   = loadable(() => import("./Intern Forms/Intern View/Internship List View/I1"), {
  fallback: <Loading />,
});

export const InternshipList   = loadable(() => import("./Intern Forms/Internship List/I1"), {
  fallback: <Loading />,
});

/* Student Form Authorize*/
export const    CMRTECHNICALCAMPUSAuthorize= loadable(() => import("./Student Forms/Student Authorize/CMR TECHNICAL CAMPUS Authorize/S3"), {
  fallback: <Loading />,
});
export const    LaptopAvailabilitySurveyAuthorize= loadable(() => import("./Student Forms/Student Authorize/Laptop Availability Survey Authorize/S1"), {
  fallback: <Loading />,
});
export const    STUDENTDETAILSAuthorize= loadable(() => import("./Student Forms/Student Authorize/STUDENT DETAILS Authorize/S4"), {
  fallback: <Loading />,
});
export const    StudentRequestFormAuthorize= loadable(() => import("./Student Forms/Student Authorize/Student Request Form Authorize/S2"), {
  fallback: <Loading />,
});

/* Student Form Modify*/
export const    CMRTECHNICALCAMPUSModify= loadable(() => import("./Student Forms/Student Modify/CMR TECHNICAL CAMPUS Modify/S3"), {
  fallback: <Loading />,
});
export const    LaptopAvailabilitySurveyModify= loadable(() => import("./Student Forms/Student Modify/Laptop Availability Survey Modify/S1"), {
  fallback: <Loading />,
});
export const    STUDENTDETAILSModify= loadable(() => import("./Student Forms/Student Modify/STUDENT DETAILS Modify/S4"), {
  fallback: <Loading />,
});
export const    StudentRequestFormModify= loadable(() => import("./Student Forms/Student Modify/Student Request Form Modify/S2"), {
  fallback: <Loading />,
});

/* Student Form View*/
export const    CMRTECHNICALCAMPUSView= loadable(() => import("./Student Forms/Student View/CMR TECHNICAL CAMPUS View/S3"), {
  fallback: <Loading />,
});
export const    LaptopAvailabilitySurveyView= loadable(() => import("./Student Forms/Student View/Laptop Availability Survey View/S1"), {
  fallback: <Loading />,
});
export const    STUDENTDETAILSView= loadable(() => import("./Student Forms/Student View/STUDENT DETAILS View/S4"), {
  fallback: <Loading />,
});
export const    StudentRequestFormView= loadable(() => import("./Student Forms/Student View/Student Request Form View/S2"), {
  fallback: <Loading />,
});
/*  Adim form Authorize*/

export const AdmissionEnquiryFormAuthorize= loadable(() => import("./Admin Forms/AdminAuthorize/Admission Form  Authorize/A2"), {
  fallback: <Loading />,
});

export const AdmissionFormAuthorize = loadable(() => import("./Admin Forms/AdminAuthorize/AdmissionEnquiryFormAuthorize/A1"), {
  fallback: <Loading />,
});

/* Admin Form Modify*/

export const AdmissionEnquiryFormModify = loadable(() => import("./Admin Forms/AdminModify/Admission Form Modify/A2"), {
  fallback: <Loading />,
});

export const AdmissionFormModify = loadable(() => import("./Admin Forms/AdminModify/AdmissionEnquiryFormModify/A1"), {
  fallback: <Loading />,
});

/* Admin Form View*/

export const AdmissionEnquiryFormView = loadable(() => import("./Admin Forms/AdminView/Admission Form View/A2"), {
  fallback: <Loading />,
});

export const AdmissionFormView = loadable(() => import("./Admin Forms/AdminView/AdmissionEnquiryFormView/A1"), {
  fallback: <Loading />,
});

/* Admin Form New */
export const Admin1 = loadable(
  () => import("./Admin Forms/AdminNew/AdmissionEnquiryForm/A1"),
  {
    fallback: <Loading />,
  }
);

export const Admin2 = loadable(
  () => import("./Admin Forms/AdminNew/Admission Form/A2"),
  {
    fallback: <Loading />,
  }
);

/* Faculty View */
export const DocumentSubmissionView = loadable(() => import("./Faculty Forms/FacultyView/Document Submission/F4"), {
  fallback: <Loading />,
});

export const EventDetailsView = loadable(() => import("./Faculty Forms/FacultyView/Event Details/F5"), {
  fallback: <Loading />,
});

export const FacultyDailyReportView = loadable(() => import("./Faculty Forms/FacultyView/Faculty Daily Report/F3"), {
  fallback: <Loading />,
});

export const FacultyReportView = loadable(() => import("./Faculty Forms/FacultyView/Faculty Report/F2"), {
  fallback: <Loading />,
});

export const ResearchPublicationsView = loadable(() => import("./Faculty Forms/FacultyView/Research Publications/F6"), {
  fallback: <Loading />,
});

export const TeachingandlearningactivitiesView = loadable(() => import("./Faculty Forms/FacultyView/Teaching and learning activities/F1"), {
  fallback: <Loading />,
});



/* Faculty Modify*/
export const DocumentSubmissionModify = loadable(() => import("./Faculty Forms/FacultyModify/Document Submission/F4"), {
  fallback: <Loading />,
});

export const EventDetailsModify = loadable(() => import("./Faculty Forms/FacultyModify/Event Details/F5"), {
  fallback: <Loading />,
});

export const FacultyDailyReportModify = loadable(() => import("./Faculty Forms/FacultyModify/Faculty Daily Report/F3"), {
  fallback: <Loading />,
});

export const FacultyReportModify = loadable(() => import("./Faculty Forms/FacultyModify/Faculty Report/F2"), {
  fallback: <Loading />,
});

export const ResearchPublicationsModify = loadable(() => import("./Faculty Forms/FacultyModify/Research Publications/F6"), {
  fallback: <Loading />,
});

export const TeachingAndLearningActivitiesModify = loadable(() => import("./Faculty Forms/FacultyModify/Teaching and learning activities/F1"), {
  fallback: <Loading />,
});

/* Autonomous Colleges Registration start here*/
export const AutonomousIIQA = loadable(() => import("./Autonomous/IIQA/IIQA"), {
  fallback: <Loading />,
});
export const AutonomousIIQAModify = loadable(() => import("./Autonomous/IIQA/IIQAModify"), {
  fallback: <Loading />,
});
export const AutonomousIIQAView = loadable(() => import("./Autonomous/IIQA/IIQAview"), {
  fallback: <Loading />,
});
export const AutonomousIIQAAuthorize = loadable(() => import("./Autonomous/IIQA/IIQAAuthorize"), {
  fallback: <Loading />,
});
export const AutonomousDeanIIQAAuthorize = loadable(() => import("./Autonomous/Authorize HOD/IIQAAuthorize"), {
  fallback: <Loading />,
});
export const AutonomousPrincipalIIQAAuthorize = loadable(() => import("./Autonomous/Authorize Principal/IIQAAuthorize"), {
  fallback: <Loading />,
});
export const AutonomousPreparedness = loadable(
  () => import("./Autonomous/Preparedness/Preparedness"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousExecutiveSummary = loadable(
  () => import("./Autonomous/SSR/Executive Summary/ExecutiveSummary"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousDeanExecutiveSummary = loadable(
  () => import("./Autonomous/Authorize HOD/SSRAuthorize/Executive Summary/ExecutiveSummaryAuthorize"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousPrincipalExecutiveSummary = loadable(
  () => import("./Autonomous/Authorize Principal/SSRAuthorize/Executive Summary/ExecutiveSummaryAuthorize"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousProfileOfTheCollege = loadable(
  () => import("./Autonomous/SSR/Profile Of The College/ProfileOfTheCollege"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousDeanProfileOfTheCollege = loadable(
  () => import("./Autonomous/Authorize HOD/SSRAuthorize/Profile Of The CollegeAuthorize/ProfileOfTheCollegeAuthorize"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousExtendedProfile = loadable(
  () => import("./Autonomous/SSR/Extended Profile/ExtendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousDeanExtendedProfile = loadable(
  () => import("./Autonomous/Authorize HOD/SSRAuthorize/Extended Profile/ExtendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousEvaluationReport = loadable(
  () => import("./Autonomous/SSR/EvaluationReport/EvaluationReport"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousExecutiveSummaryModify = loadable(
  () => import("./Autonomous/SSRModify/Executive Summary/ExecutiveSummaryModify"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousProfileOfTheCollegeModify = loadable(
  () => import("./Autonomous/SSRModify/Profile Of The CollegeModify/ProfileOfTheCollegeModify"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousExtendedProfileModify = loadable(
  () => import("./Autonomous/SSRModify/Extended Profile/ExtendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousEvaluationReportModify = loadable(
  () => import("./Autonomous/SSRModify/EvaluationReport/EvaluationReportModify"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousExecutiveSummaryView = loadable(
  () => import("./Autonomous/SSRView/Executive Summary/ExecutiveSummaryView"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousProfileOfTheCollegeView = loadable(
  () => import("./Autonomous/SSRView/Profile Of The CollegeView/ProfileOfTheCollegeView"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousExtendedProfileView = loadable(
  () => import("./Autonomous/SSRView/Extended Profile/ExtendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousEvaluationReportView = loadable(
  () => import("./Autonomous/SSRView/EvaluationReport/EvaluationReportView"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousExecutiveSummaryAuthorize = loadable(
  () => import("./Autonomous/SSRAuthorize/Executive Summary/ExecutiveSummaryAuthorize"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousDeanExecutiveSummaryAuthorize = loadable(
  () => import("./Autonomous/Authorize HOD/SSRAuthorize/Executive Summary/ExecutiveSummaryAuthorize"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousPrincipalExecutiveSummaryAuthorize = loadable(
  () => import("./Autonomous/Authorize Principal/SSRAuthorize/Executive Summary/ExecutiveSummaryAuthorize"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousDeanProfileOfTheCollegeAuthorize = loadable(
  () => import("./Autonomous/Authorize HOD/SSRAuthorize/Profile Of The CollegeAuthorize/ProfileOfTheCollegeAuthorize"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousPrincipalProfileOfTheCollegeAuthorize = loadable(
  () => import("./Autonomous/Authorize Principal/SSRAuthorize/Profile Of The CollegeAuthorize/ProfileOfTheCollegeAuthorize"),
  {
    fallback: <Loading />,
  }
  
);
export const AutonomousDeanExtendedProfileAuthorize = loadable(
  () => import("./Autonomous/Authorize HOD/SSRAuthorize/Extended Profile/ExtendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousPrincipalExtendedProfileAuthorize = loadable(
  () => import("./Autonomous/Authorize Principal/SSRAuthorize/Extended Profile/ExtendedProfile"),
 
  {
    fallback: <Loading />,
  }
);
export const AutonomousProfileOfTheCollegeAuthorize = loadable(
  () => import("./Autonomous/SSRAuthorize/Profile Of The CollegeAuthorize/ProfileOfTheCollegeAuthorize"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousExtendedProfileAuthorize = loadable(
  () => import("./Autonomous/SSRAuthorize/Extended Profile/ExtendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousEvaluationReportAuthorize = loadable(
  () => import("./Autonomous/SSRAuthorize/EvaluationReport/EvaluationReportAuthorize"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousDeanEvaluationReportAuthorize = loadable(
  () => import("./Autonomous/Authorize HOD/SSRAuthorize/EvaluationReport/EvaluationReportAuthorize"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousPrincipalEvaluationReportAuthorize = loadable(
  () => import("./Autonomous/Authorize Principal/SSRAuthorize/EvaluationReport/EvaluationReportAuthorize"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousDeanAuthorizeHODScreen = loadable(
  () => import("./Autonomous/Authorize HOD/authorizeHOD"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousAssignHODScreen = loadable(
  () => import("./Autonomous/Authorize HOD/CriteriaAssign"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousHODViewScreen = loadable(
  () => import("./Autonomous/Authorize HOD/HODview"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousAuthorizePrincipalScreen = loadable(
  () => import("./Autonomous/Authorize Principal/authorizePrincipal"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousPrincipalViewScreen = loadable(
  () => import("./Autonomous/Authorize Principal/principalView"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteriaView1 = loadable(
  () => import("./Autonomous/Authorize HOD/ViewHOD/CriteriaView-1/c1"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteriaView2 = loadable(
  () => import("./Autonomous/Authorize HOD/ViewHOD/CriteriaView-2/c2"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteriaView3 = loadable(
  () => import("./Autonomous/Authorize HOD/ViewHOD/CriteriaView-3/c3"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteriaView4 = loadable(
  () => import("./Autonomous/Authorize HOD/ViewHOD/CriteriaView-4/c4"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteriaView5 = loadable(
  () => import("./Autonomous/Authorize HOD/ViewHOD/CriteriaView-5/c5"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteriaView6 = loadable(
  () => import("./Autonomous/Authorize HOD/ViewHOD/CriteriaView-6/c6"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteria1 = loadable(
  () => import("./Autonomous/QIF/Criteria-1/c1"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteria2 = loadable(
  () => import("./Autonomous/QIF/Criteria-2/c2"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteria3 = loadable(
  () => import("./Autonomous/QIF/Criteria-3/c3"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteria4 = loadable(
  () => import("./Autonomous/QIF/Criteria-4/c4"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteria5 = loadable(
  () => import("./Autonomous/QIF/Criteria-5/c5"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteria6 = loadable(
  () => import("./Autonomous/QIF/Criteria-6/c6"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteria7 = loadable(
  () => import("./Autonomous/QIF/Criteria-7/c7"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriterias = loadable(
  () => import("./Autonomous/QIF/AutonomousCriterias"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousQL = loadable(
  () => import("./Autonomous/Quality Advisor/Qualitative Advisor/QL"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousQN = loadable(
  () => import("./Autonomous/Quality Advisor/Quantitative Advisor/QN"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousQLQN = loadable(
  () =>
    import(
      "./Autonomous/Quality Advisor/Qualitative and Quantitative Advisor/QLQN"
    ),
  {
    fallback: <Loading />,
  }
);
export const AutonomousFacultyDashboard = loadable(
  () => import("./Pages/Users/FacultyDashboard"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousDeanDashboard = loadable(
  () => import("./Pages/Users/DeanDashboard"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousPrincipalDashboard = loadable(
  () => import("./Pages/Users/PrincipalDashboard"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousQualityAdvDashboard = loadable(
  () => import("./Pages/Users/QualityAdvisorDashboard"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousHistoricalDataView = loadable(
  () => import("./Autonomous/Authorize HOD/HistoricalDataView"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousQIFModify = loadable(
  () => import("./Autonomous/QIF Modify/QifModify"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteriaModify1 = loadable(
  () => import("./Autonomous/QIF Modify/CriteriaModify-1/c1"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteriaModify2 = loadable(
  () => import("./Autonomous/QIF Modify/CriteriaModify-2/c2"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteriaModify3 = loadable(
  () => import("./Autonomous/QIF Modify/CriteriaModify-3/c3"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteriaModify4 = loadable(
  () => import("./Autonomous/QIF Modify/CriteriaModify-4/c4"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteriaModify5 = loadable(
  () => import("./Autonomous/QIF Modify/CriteriaModify-5/c5"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteriaModify6 = loadable(
  () => import("./Autonomous/QIF Modify/CriteriaModify-6/c6"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousCriteriaModify7 = loadable(
  () => import("./Autonomous/QIF Modify/CriteriaModify-7/c7"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousQualityProfileReport = loadable(
  () => import("./Autonomous/Quality Advisor/QualityProfileReport"),
  {
    fallback: <Loading />,
  }
);
export const ReferenceDocs = loadable(
  () => import("./Pages/Users/ReferenceDocs"),
  {
    fallback: <Loading />,
  }
);
export const AutonomousDownloadExcelReport = loadable(
  () => import("./Autonomous/Reports/DownloadExcelReport"),
  {
    fallback: <Loading />,
  }
);
// Autonomous Registration of components ends here //
/* Affiliated Colleges Registration start here*/
export const AffiliatedDownloadExcelReport = loadable(
  () => import("./Affiliated/Reports/DownloadExcelReportforaffiliated"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedIIQA = loadable(() => import("./Affiliated/IIQA/IIQA"), {
  fallback: <Loading />,
});
export const AffiliatedIIQAModify = loadable(() => import("./Affiliated/IIQA/IIQAModify"), {
  fallback: <Loading />,
});
export const AffiliatedIIQAView = loadable(() => import("./Affiliated/IIQA/IIQAView"), {
  fallback: <Loading />,
});
export const AffiliatedIIQAAuthorize = loadable(() => import("./Affiliated/IIQA/IIQAAuthorize"), {
  fallback: <Loading />,
});
export const AffiliatedPrincipalIIQAAuthorize = loadable(() => import("./Affiliated/Authorize Principal/IIQAAuthorize"), {
  fallback: <Loading />,
});
export const AffiliatedProfileOfTheCollege = loadable(
  () => import("./Affiliated/SSR/Profile Of The College/ProfileOfTheCollege"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedEvaluationReport = loadable(
  () => import("./Affiliated/SSR/EvaluationReport/EvaluationReport"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedExtendedProfile = loadable(
  () => import("./Affiliated/SSR/Extended Profile/extendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedExecutiveSummary = loadable(
  () => import("./Affiliated/SSR/Executive Summary/Executive Summary"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedExecutiveSummaryModify = loadable(
  () => import("./Affiliated/SSRModify/Executive Summary/ExecutiveSummary"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedProfileOfTheCollegeModify = loadable(
  () => import("./Affiliated/SSRModify/Profile Of The College/ProfileOfTheCollege"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedExtendedProfileModify = loadable(
  () => import("./Affiliated/SSRModify/Extended Profile/extendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedEvaluationReportModify = loadable(
  () => import("./Affiliated/SSRModify/EvaluationReport/EvaluationReport"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedExecutiveSummaryView = loadable(
  () => import("./Affiliated/SSRView/Executive Summary/ExecutiveSummary"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedProfileOfTheCollegeView = loadable(
  () => import("./Affiliated/SSRView/Profile Of The College/ProfileOfTheCollege"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedExtendedProfileView = loadable(
  () => import("./Affiliated/SSRView/Extended Profile/extendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedEvaluationReportView = loadable(
  () => import("./Affiliated/SSRView/EvaluationReport/EvaluationReport"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedExecutiveSummaryAuthorize = loadable(
  () => import("./Affiliated/SSRAuthorize/Executive Summary/ExecutiveSummary"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedDeanExecutiveSummaryAuthorize = loadable(
  () => import("./Affiliated/Authorize HOD/SSRAuthorize/Executive Summary/ExecutiveSummary"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedPrincipalExecutiveSummaryAuthorize = loadable(
  () => import("./Affiliated/Authorize Principal/SSRAuthorize/Executive Summary/ExecutiveSummary"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedProfileOfTheCollegeAuthorize = loadable(
  () => import("./Affiliated/SSRAuthorize/Profile Of The College/ProfileOfTheCollege"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedDeanProfileOfTheCollegeAuthorize = loadable(
  () => import("./Affiliated/Authorize HOD/SSRAuthorize/Profile Of The College/ProfileOfTheCollege"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedPrincipalProfileOfTheCollegeAuthorize = loadable(
  () => import("./Affiliated/Authorize Principal/SSRAuthorize/Profile Of The College/ProfileOfTheCollege"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedExtendedProfileAuthorize = loadable(
  () => import("./Affiliated/SSRAuthorize/Extended Profile/extendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedDeanExtendedProfileAuthorize = loadable(
  () => import("./Affiliated/Authorize HOD/SSRAuthorize/Extended Profile/extendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedPrincipalExtendedProfileAuthorize = loadable(
  () => import("./Affiliated/Authorize Principal/SSRAuthorize/Extended Profile/extendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedEvaluationReportAuthorize = loadable(
  () => import("./Affiliated/SSRAuthorize/EvaluationReport/EvaluationReport"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedDeanEvaluationReportAuthorize = loadable(
  () => import("./Affiliated/Authorize HOD/SSRAuthorize/EvaluationReport/EvaluationReport"),
  {
    fallback: <Loading />,
  }
);
export const  AffiliatedPrincipalEvaluationReportAuthorize = loadable(
  () => import("./Affiliated/Authorize Principal/SSRAuthorize/EvaluationReport/EvaluationReport"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedDeanQIFAuthorizeScreen = loadable(
  () => import("./Affiliated/Authorize HOD/authorizeHOD"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedAssignHODScreen = loadable(
  () => import("./Affiliated/Authorize HOD/CriteriaAssign"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedHODViewScreen = loadable(
  () => import("./Affiliated/Authorize HOD/HODview"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedAuthorizePrincipalScreen = loadable(
  () => import("./Affiliated/Authorize Principal/authorizePrincipal"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedPrincipalViewScreen = loadable(
  () => import("./Affiliated/Authorize Principal/principalView"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteriaView1 = loadable(
  () => import("./Affiliated/Authorize HOD/ViewHOD/CriteriaView-1/c1"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteriaView2 = loadable(
  () => import("./Affiliated/Authorize HOD/ViewHOD/CriteriaView-2/c2"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteriaView3 = loadable(
  () => import("./Affiliated/Authorize HOD/ViewHOD/CriteriaView-3/c3"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteriaView4 = loadable(
  () => import("./Affiliated/Authorize HOD/ViewHOD/CriteriaView-4/c4"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteriaView5 = loadable(
  () => import("./Affiliated/Authorize HOD/ViewHOD/CriteriaView-5/c5"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteriaView6 = loadable(
  () => import("./Affiliated/Authorize HOD/ViewHOD/CriteriaView-6/c6"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteria1 = loadable(
  () => import("./Affiliated/QIF/Criterian-1/c1"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteria2 = loadable(
  () => import("./Affiliated/QIF/Criterian-2/c2"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteria3 = loadable(
  () => import("./Affiliated/QIF/Criterian-3/c3"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteria4 = loadable(
  () => import("./Affiliated/QIF/Criterian-4/c4"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteria5 = loadable(
  () => import("./Affiliated/QIF/Criterian-5/c5"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteria6 = loadable(
  () => import("./Affiliated/QIF/Criterian-6/c6"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteria7 = loadable(
  () => import("./Affiliated/QIF/Criterian-7/c7"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriterias = loadable(
  () => import("./Affiliated/QIF/AffiliatedCriterias"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedQIFModify = loadable(
  () => import("./Affiliated/QIF Modify/QifModify"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteriaModify1 = loadable(
  () => import("./Affiliated/QIF Modify/CriteriaModify-1/c1"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteriaModify2 = loadable(
  () => import("./Affiliated/QIF Modify/CriteriaModify-2/c2"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteriaModify3 = loadable(
  () => import("./Affiliated/QIF Modify/CriteriaModify-3/c3"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteriaModify4 = loadable(
  () => import("./Affiliated/QIF Modify/CriteriaModify-4/c4"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteriaModify5 = loadable(
  () => import("./Affiliated/QIF Modify/CriteriaModify-5/c5"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteriaModify6 = loadable(
  () => import("./Affiliated/QIF Modify/CriteriaModify-6/c6"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedCriteriaModify7 = loadable(
  () => import("./Affiliated/QIF Modify/CriteriaModify-7/c7"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedQL = loadable(
  () => import("./Affiliated/Quality Advisor/Qualitative Advisor/QL"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedQN = loadable(
  () => import("./Affiliated/Quality Advisor/Quantitative Advisor/QN"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedQLQN = loadable(
  () =>
    import(
      "./Affiliated/Quality Advisor/Qualitative and Quantitative Advisor/QLQN"
    ),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedQualityProfileReport = loadable(
  () => import("./Affiliated/Quality Advisor/QualityProfileReport"),
  {
    fallback: <Loading />,
  }
);

export const AffiliatedFacultyDashboard = loadable(
  () => import("./Pages/Users/FacultyDashboard"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedDeanDashboard = loadable(
  () => import("./Pages/Users/DeanDashboard"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedPrincipalDashboard = loadable(
  () => import("./Pages/Users/PrincipalDashboard"),
  {
    fallback: <Loading />,
  }
);
export const AffiliatedQualityAdvDashboard = loadable(
  () => import("./Pages/Users/QualityAdvisorDashboard"),
  {
    fallback: <Loading />,
  }
);

// Autonomous Registration of components ends here //
/* Universities Colleges Registration start here*/
export const UniversitiesDownloadExcelReport = loadable(
  () => import("./Universities/Reports/DownloadExcelReport"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesIIQA = loadable(
  () => import("./Universities/IIQA/IIQA"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesIIQAModify = loadable(
  () => import("./Universities/IIQA/IIQAModify"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesIIQAView = loadable(
  () => import("./Universities/IIQA/IIQAView"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesDeanIIQAView = loadable(
  () => import("./Universities/IIQA/IIQAView"),
  {
    fallback: <Loading />,
  }
);
// export const UniversitiesPrincipalIIQAView = loadable(
//   () => import("./Universities/Authorize Principal/IIQAView"),
//   {
//     fallback: <Loading />,
//   }
// );
// export const UniversitiesIIQAAuthorize = loadable(
//   () => import("./Universities/IIQA/IIQAAuthorize"),
//   {
//     fallback: <Loading />,
//   }
// );
export const UniversitiesDeanIIQAAuthorize = loadable(
  () => import("./Universities/Authorize HOD/IIQAAuthorize"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesPricipalIIQAAuthorize = loadable(
  () => import("./Universities/Authorize Principal/IIQAAuthorize"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesExecutiveSummary = loadable(
  () => import("./Universities/SSR/Executive Summary/Executive Summary"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesDeanviewExecutiveSummary = loadable(
  () => import("./Universities/SSRView/Executive Summary/ExecutiveSummary"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesDeanAuthorizeExecutiveSummary = loadable(
  () => import("./Universities/Authorize HOD/SSRAuthorize/Executive Summary/ExecutiveSummary"),
  {
    fallback: <Loading />,
  }
);
// export const UniversitiesprincipalviewExecutiveSummary = loadable(
//   () => import("./Universities/Authorize Principal/SSRView/Executive Summary/ExecutiveSummary"),
//   {
//     fallback: <Loading />,
//   }
// );
export const UniversitiesprincipalAuthorizeExecutiveSummary = loadable(
  () => import("./Universities/Authorize Principal/SSRAuthorize/Executive Summary/ExecutiveSummary"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesProfileOfTheCollege = loadable(
  () => import("./Universities/SSR/Profile Of The College/ProfileOfTheCollege"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesDeanProfileOfTheCollege = loadable(
  () => import("./Universities/Authorize HOD/SSRAuthorize/Profile Of The College/ProfileOfTheCollege"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesprincipalProfileOfTheCollege = loadable(
  () => import("./Universities/Authorize Principal/SSRAuthorize/Profile Of The College/ProfileOfTheCollege"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesExtendedProfile = loadable(
  () => import("./Universities/SSR/Extended Profile/ExtendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesDeanExtendedProfile = loadable(
  () => import("./Universities/Authorize HOD/SSRAuthorize/Extended Profile/ExtendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesprincipalExtendedProfile = loadable(
  () => import("./Universities/Authorize Principal/SSRAuthorize/Extended Profile/ExtendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesEvaluationReport = loadable(
  () => import("./Universities/SSR/EvaluationReport/EvaluationReport"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesDeanEvaluationReport = loadable(
  () => import("./Universities/Authorize HOD/SSRAuthorize/EvaluationReport/EvaluationReport"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesprincipalEvaluationReport = loadable(
  () => import("./Universities/Authorize Principal/SSRAuthorize/EvaluationReport/EvaluationReport"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesAuthorizeHODScreen = loadable(
  () => import("./Universities/Authorize HOD/authorizeHOD"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesDeanQIFAuthorizeScreen = loadable(
  () => import("./Universities/Authorize HOD/authorizeHOD"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesPrincipalQIFAuthorizeScreen = loadable(
  () => import("./Universities/Authorize Principal/authorizePrincipalQIF"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesExecutiveSummaryModify = loadable(
  () => import("./Universities/SSRModify/Executive Summary/ExecutiveSummary"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesProfileOfTheCollegeModify = loadable(
  () => import("./Universities/SSRModify/Profile Of The College/ProfileOfTheCollege"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesExtendedProfileModify = loadable(
  () => import("./Universities/SSRModify/Extended Profile/ExtendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesEvaluationReportModify = loadable(
  () => import("./Universities/SSRModify/EvaluationReport/EvaluationReport"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesExecutiveSummaryView = loadable(
  () => import("./Universities/SSRView/Executive Summary/ExecutiveSummary"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesProfileOfTheCollegeView = loadable(
  () => import("./Universities/SSRView/Profile Of The College/ProfileOfTheCollege"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesExtendedProfileView = loadable(
  () => import("./Universities/SSRView/Extended Profile/ExtendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesEvaluationReportView = loadable(
  () => import("./Universities/SSRView/EvaluationReport/EvaluationReport"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesExecutiveSummaryAuthorize = loadable(
  () => import("./Universities/SSRAuthorize/Executive Summary/ExecutiveSummary"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesProfileOfTheCollegeAuthorize = loadable(
  () => import("./Universities/SSRAuthorize/Profile Of The College/ProfileOfTheCollege"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesExtendedProfileAuthorize = loadable(
  () => import("./Universities/SSRAuthorize/Extended Profile/ExtendedProfile"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesEvaluationReportAuthorize = loadable(
  () => import("./Universities/SSRAuthorize/EvaluationReport/EvaluationReport"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesAssignHODScreen = loadable(
  () => import("./Universities/Authorize HOD/CriteriaAssign"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesHODViewScreen = loadable(
  () => import("./Universities/Authorize HOD/HODview"),
  {
    fallback: <Loading />,
  }
);

export const UniversitiesAuthorizePrincipalScreen = loadable(
  () => import("./Universities/Authorize Principal/authorizePrincipalQIF"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesPrincipalAuthorizeQIF = loadable(
  () => import("./Universities/Authorize Principal/authorizePrincipalQIF"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesPrincipalViewScreen = loadable(
  () => import("./Universities/Authorize Principal/authorizePrincipalQIF"),
  {
    fallback: <Loading />,
  }
);

// NBA
// Profile
export const NbaProfile = loadable(
  () => import("./NBA/Profile/Profile"),
  {
    fallback: <Loading />,
  }
);
//Acadamics

export const NbaAcadamics1 = loadable(
  () => import("./NBA/Academics/Acadamics"),
  {
    fallback: <Loading />,
  }   
);


//ResearchAcadamic
export const NbaResearchAcadamic= loadable(
  () => import("./NBA/Research/AcadamicResearch/AcadamicResearch"),
  {
    fallback: <Loading />,
  }   
);


//ResearchSponsoredResearch
export const NbaResearchSponsored = loadable(
  () => import("./NBA/Research/SponsoredResearch/SponsoredResearch"),
  {
    fallback: <Loading />,
  }   
);


//Counselling

export const NbaCounselling = loadable(
  () => import("./NBA/Counselling/Counselling"),
  {
    fallback: <Loading />,
  }   
);

//Faculty Dashboard Modify

//CounsellingModify

export const NbaCounsellingModify = loadable(
  () => import("./FacultyDashBoardModify/Counselling/Counselling"),
  {
    fallback: <Loading />,
  }   
);

//Academics Modify

export const NbaAcademicsModify = loadable(
  () => import("./FacultyDashBoardModify/Academics/Acadamics"),
  {
    fallback: <Loading />,
  }   
);

//Profile Modify

export const NbaProfileModify = loadable(
  () => import("./FacultyDashBoardModify/Profile/Profile"),
  {
    fallback: <Loading />,
  }   
);
//Academic Research Modify

export const NbaResearchModify = loadable(
  () => import("./FacultyDashBoardModify/Research/AcadamicResearch/AcadamicResearch"),
  {
    fallback: <Loading />,
  }   
);
//Sponsered Research Modify

export const NbaSponResearchModify = loadable(
  () => import("./FacultyDashBoardModify/Research/SponsoredResearch/SponsoredResearch"),
  {
    fallback: <Loading />,
  }   
);


//Faculty Dashboard View

export const NbaCounsellingView = loadable(
  () => import("./Faculty Dashboard View/Counselling/Counselling"),
  {
    fallback: <Loading />,
  }   
);
export const NbaProfileView = loadable(
  () => import("./Faculty Dashboard View/Profile/Profile"),
  {
    fallback: <Loading />,
  }   
);
export const NbaAcademicsView = loadable(
  () => import("./Faculty Dashboard View/Academics/Acadamics"),
  {
    fallback: <Loading />,
  }   
);
export const NbaAcademicView = loadable(
  () => import("./Faculty Dashboard View/Research/AcadamicResearch/AcadamicResearch"),
  {
    fallback: <Loading />,
  }   
);
export const NbaSponseredView = loadable(
  () => import("./Faculty Dashboard View/Research/SponsoredResearch/SponsoredResearch"),
  {
    fallback: <Loading />,
  }   
);

//Faculty Dashboard Authorize

export const FDAuthorize = loadable(
  () => import("./Faculty Dashboard Authorize/Academics/Acadamics"),
  {
    fallback: <Loading />,
  }   
);
export const FDAuthorizeCounselling = loadable(
  () => import("./Faculty Dashboard Authorize/Counselling/Counselling"),
  {
    fallback: <Loading />,
  }   
);
export const FDAuthorizeProfile= loadable(
  () => import("./Faculty Dashboard Authorize/Profile/Profile"),
  {
    fallback: <Loading />,
  }   
);
export const FDAuthorizeAcademic= loadable(
  () => import("./Faculty Dashboard Authorize/Research/AcadamicResearch/AcadamicResearch"),
  {
    fallback: <Loading />,
  }   
);
export const FDAuthorizeSponsered= loadable(
  () => import("./Faculty Dashboard Authorize/Research/SponsoredResearch/SponsoredResearch"),
  {
    fallback: <Loading />,
  }   
);







// export const UniversitiesAuthorizeHODScreen = loadable(
//   () => import("./Universities/Authorize HOD/authorizeHOD"),
//   {
//     fallback: <Loading />,
//   }
// );
// export const UniversitiesAssignHODScreen = loadable(
//   () => import("./Universities/Authorize HOD/assignHOD"),
//   {
//     fallback: <Loading />,
//   }
// );
// export const UniversitiesHODViewScreen = loadable(
//   () => import("./Universities/Authorize HOD/HODview"),
//   {
//     fallback: <Loading />,
//   }
// );
// export const UniversitiesAuthorizePrincipalScreen = loadable(
//   () => import("./Universities/Authorize Principal/authorizePrincipal"),
//   {
//     fallback: <Loading />,
//   }
// );
// export const UniversitiesPrincipalViewScreen = loadable(
//   () => import("./Universities/Authorize Principal/principalView"),
//   {
//     fallback: <Loading />,
//   }
// );
export const UniversitiesCriteriaView1 = loadable(
  () => import("./Universities/Authorize HOD/ViewHOD/CriteriaView-1/c1"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteriaView2 = loadable(
  () => import("./Universities/Authorize HOD/ViewHOD/CriteriaView-2/c2"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteriaView3 = loadable(
  () => import("./Universities/Authorize HOD/ViewHOD/CriteriaView-3/c3"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteriaView4 = loadable(
  () => import("./Universities/Authorize HOD/ViewHOD/CriteriaView-4/c4"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteriaView5 = loadable(
  () => import("./Universities/Authorize HOD/ViewHOD/CriteriaView-5/c5"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteriaView6 = loadable(
  () => import("./Universities/Authorize HOD/ViewHOD/CriteriaView-6/c6"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteriaView7 = loadable(
  () => import("./Universities/Authorize HOD/ViewHOD/CriteriaView-7/c7"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteria1 = loadable(
  () => import("./Universities/QIF/Criterian-1/c1"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteria2 = loadable(
  () => import("./Universities/QIF/Criterian-2/c2"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteria3 = loadable(
  () => import("./Universities/QIF/Criterian-3/c3"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteria4 = loadable(
  () => import("./Universities/QIF/Criterian-4/c4"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteria5 = loadable(
  () => import("./Universities/QIF/Criterian-5/c5"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteria6 = loadable(
  () => import("./Universities/QIF/Criterian-6/c6"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteria7 = loadable(
  () => import("./Universities/QIF/Criterian-7/c7"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriterias = loadable(
  () => import("./Universities/QIF/UniversitiesCriterias"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesQIFModify = loadable(
  () => import("./Universities/QIF Modify/QifModify"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteriaModify1 = loadable(
  () => import("./Universities/QIF Modify/CriteriaModify-1/c1"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteriaModify2 = loadable(
  () => import("./Universities/QIF Modify/CriteriaModify-2/c2"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteriaModify3 = loadable(
  () => import("./Universities/QIF Modify/CriteriaModify-3/c3"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteriaModify4 = loadable(
  () => import("./Universities/QIF Modify/CriteriaModify-4/c4"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteriaModify5 = loadable(
  () => import("./Universities/QIF Modify/CriteriaModify-5/c5"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteriaModify6 = loadable(
  () => import("./Universities/QIF Modify/CriteriaModify-6/c6"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesCriteriaModify7 = loadable(
  () => import("./Universities/QIF Modify/CriteriaModify-7/c7"),
  {
    fallback: <Loading />,
  }
);

export const UniversitiesQL = loadable(
  () => import("./Universities/Quality Advisor/Qualitative Advisor/QL"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesQN = loadable(
  () => import("./Universities/Quality Advisor/Quantitative Advisor/QN"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesQLQN = loadable(
  () =>
    import(
      "./Universities/Quality Advisor/Qualitative and Quantitative Advisor/QLQN"
    ),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesQualityProfileReport = loadable(
  () => import("./Universities/Quality Advisor/QualityProfileReport"),
  {
    fallback: <Loading />,
  }
);

export const UniversitiesFacultyDashboard = loadable(
  () => import("./Pages/Users/FacultyDashboard"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesDeanDashboard = loadable(
  () => import("./Pages/Users/DeanDashboard"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesPrincipalDashboard = loadable(
  () => import("./Pages/Users/PrincipalDashboard"),
  {
    fallback: <Loading />,
  }
);
export const UniversitiesQualityAdvDashboard = loadable(
  () => import("./Pages/Users/QualityAdvisorDashboard"),
  {
    fallback: <Loading />,
  }
);

// Universities Registration of components ends here //
export const Mente = loadable(() => import("./Mentoring Form/Mente"), {
  fallback: <Loading />,
});
export const Feedback = loadable(() => import("./Feedback Form/Feedback"), {
  fallback: <Loading />,
});



//FacultyForm
export const TeachingAndLearningActivities = loadable(
  () => import("./Faculty Forms/Teaching and learning activities/F1"),
  {
    fallback: <Loading />,
  }
);
export const FacultyReport = loadable(
  () => import("./Faculty Forms/Faculty Report/F2"),
  {
    fallback: <Loading />,
  }
);
export const FacultyDailyReport = loadable(
  () => import("./Faculty Forms/Faculty Daily Report/F3"),
  {
    fallback: <Loading />,
  }
);
export const DocumentSubmission = loadable(
  () => import("./Faculty Forms/Document Submission/F4"),
  {
    fallback: <Loading />,
  }
);
export const EventDetails = loadable(
  () => import("./Faculty Forms/Event Details/F5"),
  {
    fallback: <Loading />,
  }
);
export const ResearchPublications = loadable(
  () => import("./Faculty Forms/Research Publications/F6"),
  {
    fallback: <Loading />,
  }
);
export const LaptopAvailabilitySurvey = loadable(
  () => import("./Student Forms/Laptop Availability Survey/S1"),
  {
    fallback: <Loading />,
  }
);
export const StudentRequestForm = loadable(
  () => import("./Student Forms/Student Request Form/S2"),
  {
    fallback: <Loading />,
  }
);
export const CourseRegistrationForm = loadable(
  () => import("./Student Forms/CMR TECHNICAL CAMPUS/S3"),
  {
    fallback: <Loading />,
  }
);
export const STUDENTPLACEMENTINTERNSHIPDETAILS = loadable(
  () => import("./Student Forms/STUDENT DETAILS/S4"),
  {
    fallback: <Loading />,
  }
);



export const LandingPage = loadable(() => import("./Pages/Users/LandingPage"), {
  fallback: <Loading />,
});
export const LoginDedicated = loadable(
  () => import("./Pages/Standalone/LoginDedicated"),
  {
    fallback: <Loading />,
  }
);
export const Login = loadable(() => import("./Pages/Users/Login"), {
  fallback: <Loading />,
});
export const Register = loadable(() => import("./Pages/Users/Register"), {
  fallback: <Loading />,
});
export const ResetPassword = loadable(
  () => import("./Pages/Users/ResetPassword"),
  {
    fallback: <Loading />,
  }
);
export const NotFound = loadable(() => import("./NotFound/NotFound"), {
  fallback: <Loading />,
});
export const NotFoundDedicated = loadable(
  () => import("./Pages/Standalone/NotFoundDedicated"),
  {
    fallback: <Loading />,
  }
);
export const Error = loadable(() => import("./Pages/Error"), {
  fallback: <Loading />,
});
export const Maintenance = loadable(() => import("./Pages/Maintenance"), {
  fallback: <Loading />,
});
export const ComingSoon = loadable(() => import("./Pages/ComingSoon"), {
  fallback: <Loading />,
});
export const Parent = loadable(() => import("./Parent"), {
  fallback: <Loading />,
});
export const BlankPage = loadable(() => import("./Pages/BlankPage"), {
  fallback: <Loading />,
});
export const DashboardPage = loadable(() => import("./Pages/Dashboard"), {
  fallback: <Loading />,
});
