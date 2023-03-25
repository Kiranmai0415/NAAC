import React, { useContext } from "react";
import { PropTypes } from "prop-types";
import { Switch, Route } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Dashboard from "../Templates/Dashboard";
import { ThemeContext } from "./ThemeWrapper";

import {
  InternshipList,
  InternshipListAuthorize,
  InternshipListModify,
  InternshipListView,

  CMRTECHNICALCAMPUSAuthorize,
  LaptopAvailabilitySurveyAuthorize,
  STUDENTDETAILSAuthorize,
  StudentRequestFormAuthorize,

  CMRTECHNICALCAMPUSModify,
  LaptopAvailabilitySurveyModify,
  STUDENTDETAILSModify,
  StudentRequestFormModify,

  CMRTECHNICALCAMPUSView,
  LaptopAvailabilitySurveyView,
  STUDENTDETAILSView,
  StudentRequestFormView,



  AdmissionEnquiryFormAuthorize,
  AdmissionFormAuthorize,

  AdmissionEnquiryFormModify,
  AdmissionFormModify,

  AdmissionEnquiryFormView,
  AdmissionFormView,

TeachingandlearningactivitiesView,
ResearchPublicationsView,
FacultyReportView,
FacultyDailyReportView,
EventDetailsView,
DocumentSubmissionView,

  TeachingAndLearningActivitiesModify,
  ResearchPublicationsModify,
  FacultyReportModify,
  FacultyDailyReportModify,
  EventDetailsModify,
  DocumentSubmissionModify,

  Parent,
  DashboardPage,
  BlankPage,
  AutonomousExecutiveSummary,
  AutonomousIIQA,
  AutonomousIIQAModify,
  AutonomousIIQAView,
  AutonomousIIQAAuthorize,
  AutonomousProfileOfTheCollege,
  AutonomousExtendedProfile,
  AutonomousCriteria1,
  AutonomousCriteria2,
  AutonomousCriteria3,
  AutonomousCriteria4,
  AutonomousCriteria5,
  AutonomousCriteria6,
  AutonomousCriteria7,
  Mente,
  Feedback,
  AutonomousAuthorizePrincipalScreen,
  AutonomousPrincipalViewScreen,
  AutonomousQL,
  AutonomousQN,
  AutonomousQLQN,
  Error,
  NotFound,
  NIRF,
  AutonomousAssignHODScreen,
  AutonomousFacultyDashboard,
  AutonomousDeanDashboard,
  AutonomousPrincipalDashboard,
  AutonomousQualityAdvDashboard,
  AffiliatedProfileOfTheCollege,
  AffiliatedEvaluationReport,
  AffiliatedExecutiveSummary,
  AffiliatedIIQA,
  AffiliatedIIQAModify,
  AffiliatedIIQAView,
  AffiliatedIIQAAuthorize,
  AffiliatedExtendedProfile,
  AutonomousEvaluationReport,
  AutonomousExecutiveSummaryModify,
  AutonomousExtendedProfileModify,
  AutonomousEvaluationReportModify,
  AutonomousProfileOfTheCollegeModify,
  AutonomousExecutiveSummaryView,
  AutonomousProfileOfTheCollegeView,
  AutonomousExtendedProfileView,
  AutonomousEvaluationReportView,
  AutonomousExecutiveSummaryAuthorize,
  AutonomousProfileOfTheCollegeAuthorize,
  AutonomousExtendedProfileAuthorize,
  AutonomousEvaluationReportAuthorize,
  AffiliatedQL,
  AffiliatedQN,
  AffiliatedQLQN,
  AffiliatedExecutiveSummaryModify,
  AffiliatedProfileOfTheCollegeModify,
  AffiliatedExtendedProfileModify,
  AffiliatedEvaluationReportModify,
  AffiliatedExecutiveSummaryView,
  AffiliatedProfileOfTheCollegeView,
  AffiliatedExtendedProfileView,
  AffiliatedEvaluationReportView,
  AffiliatedExecutiveSummaryAuthorize,
  AffiliatedProfileOfTheCollegeAuthorize,
  AffiliatedExtendedProfileAuthorize,
  AffiliatedEvaluationReportAuthorize,
  AffiliatedAuthorizePrincipalScreen,
  AffiliatedPrincipalViewScreen,
  AffiliatedHODViewScreen,
  AffiliatedAssignHODScreen,
  AffiliatedCriterias,
  AffiliatedQIFModify,
  AffiliatedCriteria1,
  AffiliatedCriteria2,
  AffiliatedCriteria3,
  AffiliatedCriteria4,
  AffiliatedCriteria5,
  AffiliatedCriteria6,
  AffiliatedCriteria7,
  AffiliatedDeanDashboard,
  AffiliatedPrincipalDashboard,
  AffiliatedQualityAdvDashboard,
  AutonomousHistoricalDataView,
  UniversitiesProfileOfTheCollege,
  UniversitiesEvaluationReport,
  UniversitiesExecutiveSummary,
  UniversitiesEvaluationReportModify,
  UniversitiesIIQA,
  UniversitiesIIQAModify,
  UniversitiesIIQAView,
  UniversitiesDeanIIQAView,
  UniversitiesPrincipalIIQAView,
  // UniversitiesIIQAView,
  UniversitiesDeanIIQAAuthorize,
  // UniversitiesIIQAAuthorize,
  UniversitiesExtendedProfile,
  UniversitiesExecutiveSummaryModify,
  UniversitiesProfileOfTheCollegeModify,
  UniversitiesprincipalProfileOfTheCollege,
  UniversitiesExtendedProfileModify,
  UniversitiesDeanviewExecutiveSummary,
  UniversitiesDeanProfileOfTheCollege,
  UniversitiesprincipalviewExecutiveSummary,
  UniversitiesDeanAuthorizeExecutiveSummary,
  UniversitiesprincipalAuthorizeExecutiveSummary,
  // UniversitiesExecutiveSummaryView,
  UniversitiesprincipalEvaluationReport,
  UniversitiesDeanEvaluationReport,
  UniversitiesprincipalExtendedProfile,
  UniversitiesDeanExtendedProfile,
  UniversitiesProfileOfTheCollegeView,
  UniversitiesExtendedProfileView,
  UniversitiesEvaluationReportView,
  UniversitiesExecutiveSummaryAuthorize,
  UniversitiesProfileOfTheCollegeAuthorize,
  UniversitiesExtendedProfileAuthorize,
  UniversitiesEvaluationReportAuthorize,
  UniversitiesQL,
  UniversitiesQN,
  UniversitiesQLQN,
  UniversitiesAuthorizePrincipalScreen,
  UniversitiesPrincipalViewScreen,
  UniversitiesAuthorizeHODScreen,
  UniversitiesAssignHODScreen,
  UniversitiesHODViewScreen,
  UniversitiesCriterias,
  UniversitiesQIFModify,
  UniversitiesCriteria1,
  UniversitiesCriteria2,
  UniversitiesCriteria3,
  UniversitiesCriteria4,
  UniversitiesCriteria5,
  UniversitiesCriteria6,
  UniversitiesCriteria7,
  UniversitiesFacultyDashboard,
  UniversitiesDeanDashboard,
  UniversitiesPrincipalDashboard,
  UniversitiesQualityAdvDashboard,
  AutonomousQIFModify,
  AutonomousQualityProfileReport,
  AutonomousCriterias,
  Admin2,
  Admin1,
  TeachingAndLearningActivities,
  FacultyReport,
  FacultyDailyReport,
  DocumentSubmission,
  EventDetails,
  ResearchPublications,
  AffiliatedQualityProfileReport,
  UniversitiesQualityProfileReport,
  AdminFormEnquiry,
  LaptopAvailabilitySurvey,
  StudentRequestForm,
  CourseRegistrationForm,
  STUDENTPLACEMENTINTERNSHIPDETAILS,
  ReferenceDocs,
  NbaProfile,
  NbaAcadamics1,
  NbaResearchAcadamic,
  NbaCounselling,

  NbaResearchSponsored,
  AutonomousDownloadExcelReport,
  NbaCounsellingModify,
  NbaAcademicsModify,
  NbaProfileModify,
  NbaResearchModify,
  NbaSponResearchModify,
  NbaCounsellingView,
  NbaAcademicsView,
  NbaAcademicView,
  NbaSponseredView,
  NbaProfileView,
  FDAuthorize,
  FDAuthorizeProfile,
  FDAuthorizeAcademic,
  FDAuthorizeSponsered,
  FDAuthorizeCounselling,
  AutonomousDeanIIQAAuthorize,
  AutonomousDeanExecutiveSummaryAuthorize,
  AutonomousDeanProfileOfTheCollegeAuthorize,
  AutonomousDeanExtendedProfileAuthorize,
  AutonomousDeanEvaluationReportAuthorize,
  AutonomousPrincipalIIQAAuthorize,
  UniversitiesPricipalIIQAAuthorize,
  AffiliatedDeanExecutiveSummaryAuthorize,
  AffiliatedDeanExtendedProfileAuthorize,
  AffiliatedDeanEvaluationReportAuthorize,
  AffiliatedDeanProfileOfTheCollegeAuthorize,
  AutonomousPrincipalExecutiveSummaryAuthorize,
  AutonomousPrincipalExtendedProfileAuthorize,
  AutonomousPrincipalEvaluationReportAuthorize,
  AutonomousPrincipalProfileOfTheCollegeAuthorize,
  AffiliatedPrincipalIIQAAuthorize,
  AffiliatedPrincipalExtendedProfileAuthorize,
  AffiliatedPrincipalEvaluationReportAuthorize,
  AffiliatedPrincipalProfileOfTheCollegeAuthorize,
  AffiliatedPrincipalExecutiveSummaryAuthorize,
  UniversitiesDeanQIFAuthorizeScreen,
  UniversitiesPrincipalQIFAuthorizeScreen,
  AutonomousDeanAuthorizeHODScreen,
  AffiliatedDeanQIFAuthorizeScreen,
  AffiliatedDownloadExcelReport,
  UniversitiesDownloadExcelReport,
  UniversitiesExecutiveSummaryView,
} from "../pageListAsync";

import CriteriaView1 from "../Autonomous/Authorize HOD/ViewHOD/CriteriaView-1/c1";
import HODViewScreen from "../Autonomous/Authorize HOD/HODview";
import CriteriaView2 from "../Autonomous/Authorize HOD/ViewHOD/CriteriaView-2/c2";
import CriteriaView3 from "../Autonomous/Authorize HOD/ViewHOD/CriteriaView-3/c3";
import CriteriaView4 from "../Autonomous/Authorize HOD/ViewHOD/CriteriaView-4/c4";
import CriteriaView5 from "../Autonomous/Authorize HOD/ViewHOD/CriteriaView-5/c5";
import CriteriaView6 from "../Autonomous/Authorize HOD/ViewHOD/CriteriaView-6/c6";
import CriteriaView7 from "../Autonomous/Authorize HOD/ViewHOD/CriteriaView-7/c7";
import PrincipalViewScreen from "../Autonomous/Authorize Principal/principalView";

import CriteriaModify1 from "../Autonomous/QIF Modify/CriteriaModify-1/c1";
import QIFModify from "../Autonomous/QIF Modify/QifModify";
import CriteriaModify2 from "../Autonomous/QIF Modify/CriteriaModify-2/c2";
import CriteriaModify3 from "../Autonomous/QIF Modify/CriteriaModify-3/c3";
import CriteriaModify4 from "../Autonomous/QIF Modify/CriteriaModify-4/c4";
import CriteriaModify5 from "../Autonomous/QIF Modify/CriteriaModify-5/c5";
import CriteriaModify6 from "../Autonomous/QIF Modify/CriteriaModify-6/c6";
import CriteriaModify7 from "../Autonomous/QIF Modify/CriteriaModify-7/c7";

function Application(props) {
  const { history } = props;
  const changeMode = useContext(ThemeContext);
  return (
    <Dashboard history={history} changeMode={changeMode}>
      <Switch>

      <Route
          path="/app/Intern Forms/Intern Authorize/Internship List Authorize"
          component={InternshipList}
        />
        <Route
          path="/app/Intern Forms/Intern Modify/Internship List Modify"
          component={InternshipListModify}
        />
        <Route
          path="/app/Intern Forms/Intern View/Internship List View"
          component={InternshipListView}
        />
        <Route
          path="/app/Intern Forms/Internship List"
          component={InternshipListAuthorize}
        />

      {/* Student Authozize */}
      <Route
          path="/app/Student Forms/Student Authorize/CMR TECHNICAL CAMPUS Authorize"
          component={CMRTECHNICALCAMPUSAuthorize}
        />
        <Route
          path="/app/Student Forms/Student Authorize/Laptop Availability Survey Authorize"
          component={LaptopAvailabilitySurveyAuthorize}
        />
        <Route
          path="/app/Student Forms/Student Authorize/STUDENT DETAILS Authorize"
          component={STUDENTDETAILSAuthorize}
        />
        <Route
          path="/app/Student Forms/Student Authorize/Student Request Form Authorize"
          component={StudentRequestFormAuthorize}
        />
        {/*  Student View*/}
        <Route
          path="/app/Student Forms/Student View/CMR TECHNICAL CAMPUS View"
          component={CMRTECHNICALCAMPUSView}
        />
        <Route
          path="/app/Student Forms/Student View/Laptop Availability Survey View"
          component={LaptopAvailabilitySurveyView}
        />
        <Route
          path="/app/Student Forms/Student View/STUDENT DETAILS View"
          component={STUDENTDETAILSView}
        />
        <Route
          path="/app/Student Forms/Student View/Student Request Form View"
          component={StudentRequestFormView}
        />

        {/* Student Modify */}
        <Route
          path="/app/Student Forms/Student Modify/CMR TECHNICAL CAMPUS Modify"
          component={CMRTECHNICALCAMPUSModify}
        />
        <Route
          path="/app/Student Forms/Student Modify/Laptop Availability Survey Modify"
          component={LaptopAvailabilitySurveyModify}
        />
        <Route
          path="/app/Student Forms/Student Modify/STUDENT DETAILS Modify"
          component={STUDENTDETAILSModify}
        />
        <Route
          path="/app/Student Forms/Student Modify/Student Request Form Modify"
          component={StudentRequestFormModify}
        />
        
        {/* Admin-New */}
        <Route
          path="/app/Admin Forms/AdminNew/Admission Form"
          component={Admin2}
        />

        <Route
          path="/app/Admin Forms/AdminNew/AdminEnquiryForm"
          component={Admin1}
        />


        {/* Admin Form */}
        <Route
          path="/app/Admin Forms/AdminModify/Admission Form Modify"
          component={AdmissionFormModify}
        />

        <Route
          path="/app/Admin Forms/AdminModify/Admission Enquiry Form Modify"
          component={AdmissionEnquiryFormModify}
        />

        {/* Admin View */}

        <Route
          path="/app/Admin Forms/AdminView/Admission Form View"
          component={AdmissionFormView}
        />

        <Route
          path="/app/Admin Forms/AdminView/Admission Enquiry Form View"
          component={AdmissionEnquiryFormView}
        />

        {/* Admin Authorize */}

        <Route
          path="/app/Admin Forms/AdminAuthorize/Admission Form Authorize"
          component={AdmissionFormAuthorize}
        />

        <Route
          path="/app/Admin Forms/AdminAuthorize/Admission Enquiry Form Authorize"
          component={AdmissionEnquiryFormAuthorize}
        />

     {/* Faculty View */}
        <Route
          path="/app/Faculty Forms/FacultyView/Document Submission"
          component={DocumentSubmissionView}
        />
        <Route
          path="/app/Faculty Forms/FacultyView/Event Details"
          component={EventDetailsView}
        />
         <Route
          path="/app/Faculty Forms/FacultyView/Faculty Daily Report"
          component={FacultyDailyReportView}
        />
         <Route
          path="/app/Faculty Forms/FacultyView/Faculty Report"
          component={FacultyReportView}
        />
        <Route
          path="/app/Faculty Forms/FacultyView/Research Publications"
          component={ResearchPublicationsView}
        />

        <Route
          path="/app/Faculty Forms/FacultyView/Teaching and learning activities"
          component={TeachingandlearningactivitiesView}
        />


     /* FacultyForms Modify */
       <Route
          path="/app/Faculty Forms/FacultyModify/Document Submission"
          component={DocumentSubmissionModify}
        />
        <Route
          path="/app/Faculty Forms/FacultyModify/Event Details"
          component={EventDetailsModify}
        />
         <Route
          path="/app/Faculty Forms/FacultyModify/Faculty Daily Report"
          component={FacultyDailyReportModify}
        />
         <Route
          path="/app/Faculty Forms/FacultyModify/Faculty Report"
          component={FacultyReportModify}
        />
        <Route
          path="/app/Faculty Forms/FacultyModify/Research Publications"
          component={ResearchPublicationsModify}
        />

        <Route
          path="/app/Faculty Forms/FacultyModify/Teaching and learning activities"
          component={TeachingAndLearningActivitiesModify}
        />
         
//* NbaProfile*//

        <Route
          path="/app/NBA/Profile/Profile"
          component={NbaProfile}
        />
//* NbaAcadamics*//
        <Route
          path="/app/NBA/Academics/Acadamics"
          component={NbaAcadamics1}
        />

//* NbaResearch*//

//* NbaResearchSponsored*//

        <Route
          path="/app/Research/SponsoredResearch/SponsoredResearch"
          component={NbaResearchSponsored}
        />

//* NbaResearchAcadamic*//
        <Route
          path="/app/NBA/Research/AcadamicResearch/AcadamicResearch"
          component={NbaResearchAcadamic}
        />

        //* NBA Counselling*//
        <Route
          path="/app/NBA/Counselling/Counselling"
          component={NbaCounselling}
        />
        //*  NbaCounsellingModify*//
        <Route
          path="/app/FacultyDashBoardModify/Counselling/Counselling"
          component={NbaCounsellingModify}
        />
        //*  NbaAcademics*//
        <Route
          path="/app/FacultyDashBoardModify/Academics/Acadamics"
          component={NbaAcademicsModify}
        />
        //*  NbaProfile*//
        <Route
          path="/app/FacultyDashBoardModify/Profile/Profile"
          component={NbaProfileModify}
        />
        //*  NbaAcademicresearch*//
        <Route
          path="/app/FacultyDashBoardModify/Research/AcadamicResearch/AcadamicResearch"
          component={NbaResearchModify}
        />
        //*  NbaAcademicresearch*//
        <Route
          path="/app/FacultyDashBoardModify/Research/SponsoredResearch/SponsoredResearch"
          component={NbaSponResearchModify}
        />

        {/* Nba Faculty Dashboard view */}

        <Route
          path="/app/Faculty Dashboard View/Counselling/Counselling"
          component={NbaCounsellingView}
        />
        <Route
          path="/app/Faculty Dashboard View/Academics/Acadamics"
          component={NbaAcademicsView}
        />
        <Route
          path="/app/Faculty Dashboard View/Research/AcadamicResearch/AcadamicResearch"
          component={NbaAcademicView}
        />
        <Route
          path="/app/Faculty Dashboard View/Research/SponsoredResearch/SponsoredResearch"
          component={NbaSponseredView}
        />
        <Route
          path="/app/Faculty Dashboard View/Profile/Profile"
          component={NbaProfileView}
        />

        {/* Nba Faculty Dashboard Authorize */}

        <Route
          path="/app/Faculty Dashboard Authorize/Academics/Acadamics"
          component={FDAuthorize}
        />

        <Route
          path="/app/Faculty Dashboard Authorize/Profile/Profile"
          component={FDAuthorizeProfile}
        />

        <Route
          path="/app/Faculty Dashboard Authorize/Research/AcadamicResearch/AcadamicResearch"
          component={FDAuthorizeAcademic}
        />

        <Route
          path="/app/Faculty Dashboard Authorize/Research/SponsoredResearch/SponsoredResearch"
          component={FDAuthorizeSponsered}
        />
        <Route
          path="/app/Faculty Dashboard Authorize/Counselling/Counselling"
          component={FDAuthorizeCounselling}
        />

        {/* Autonomous Entitlements Registration Start Here */}
        <Route
          path="/app/Autonomous/SSR/Profile Of The College"
          component={AutonomousProfileOfTheCollege}
        />
        <Route
          path="/app/Autonomous/IIQA/IIQA"
          component={AutonomousIIQA} />
        <Route
          path="/app/Autonomous/IIQA/IIQAModify"
          component={AutonomousIIQAModify} />
        <Route
          path="/app/Autonomous/IIQA/IIQAview"
          component={AutonomousIIQAView} />
        <Route
          path="/app/Autonomous/IIQA/IIQAAuthorize"
          component={AutonomousIIQAAuthorize} />
        <Route
          path="/app/Autonomous/Dean/IIQA/IIQAAuthorize"
          component={AutonomousDeanIIQAAuthorize} />
        <Route
          path="/app/Autonomous/Principal/IIQA/IIQAAuthorize"
          component={AutonomousPrincipalIIQAAuthorize} />
        <Route
          path="/app/Autonomous/SSR/Executive Summary/ExecutiveSummary"
          component={AutonomousExecutiveSummary}
        />
        <Route
          path="/app/Autonomous/SSR/Extended Profile/ExtendedProfile"
          component={AutonomousExtendedProfile}
        />
        <Route
          path="/app/Autonomous/SSR/EvaluationReport"
          component={AutonomousEvaluationReport}
        />
        <Route
          path="/app/Autonomous/SSR/Profile Of The College"
          component={AutonomousProfileOfTheCollege}
        />
        <Route
          path="/app/Autonomous/SSRModify/Executive Summary/ExecutiveSummaryModify"
          component={AutonomousExecutiveSummaryModify}
        />
        <Route
          path="/app/Autonomous/SSRModify/Extended Profile/ExtendedProfile"
          component={AutonomousExtendedProfileModify}
        />
        <Route
          path="/app/Autonomous/SSRModify/EvaluationReport/EvaluationReportModify"
          component={AutonomousEvaluationReportModify}
        />
        <Route
          path="/app/Autonomous/SSRModify/Profile Of The College/ProfileOfTheCollegeModify"
          component={AutonomousProfileOfTheCollegeModify}
        />
        <Route
          path="/app/Autonomous/SSRView/Executive Summary/ExecutiveSummaryView"
          component={AutonomousExecutiveSummaryView}
        />
        <Route
          path="/app/Autonomous/SSRView/Extended Profile/ExtendedProfile"
          component={AutonomousExtendedProfileView}
        />
        <Route
          path="/app/Autonomous/SSRView/EvaluationReport/EvaluationReportView"
          component={AutonomousEvaluationReportView}
        />
        <Route
          path="/app/Autonomous/SSRView/Profile Of The College/ProfileOfTheCollegeView"
          component={AutonomousProfileOfTheCollegeView}
        />
        <Route
          path="/app/Autonomous/SSRAuthorize/Executive Summary/ExecutiveSummaryAuthorize"
          component={AutonomousExecutiveSummaryAuthorize}
        />
        <Route
          path="/app/Autonomous/Dean/SSRAuthorize/Executive Summary Authorize"
          component={AutonomousDeanExecutiveSummaryAuthorize}
        />
        <Route
          path="/app/Autonomous/Authorize Principal/SSRAuthorize/Executive Summary/ExecutiveSummaryAuthorize"
          component={AutonomousPrincipalExecutiveSummaryAuthorize}
        />
        <Route
          path="/app/Autonomous/SSRAuthorize/Extended Profile/ExtendedProfile"
          component={AutonomousExtendedProfileAuthorize}
        />
        <Route
          path="/app/Autonomous/Dean/SSRAuthorize/ExtendedProfile"
          component={AutonomousDeanExtendedProfileAuthorize}
        />
        <Route
          path="/app/Autonomous/Authorize Principal/SSRAuthorize/Extended Profile/ExtendedProfile"
          component={AutonomousPrincipalExtendedProfileAuthorize}
        />
        <Route
          path="/app/Autonomous/Dean/SSRAuthorize/Evaluation Report Authorize"
          component={AutonomousDeanEvaluationReportAuthorize}
        />
        <Route
          path="/app/Autonomous/Authorize Principal/SSRAuthorize/EvaluationReport/EvaluationReportAuthorize"
          component={AutonomousPrincipalEvaluationReportAuthorize}
        />
        <Route
          path="/app/Autonomous/SSRAuthorize/Profile Of The College/ProfileOfTheCollegeAuthorize"
          component={AutonomousProfileOfTheCollegeAuthorize}
        />
        <Route
          path="/app/Autonomous/Dean/SSRAuthorize/Profile Of The College Authorize"
          component={AutonomousDeanProfileOfTheCollegeAuthorize}
        />
        <Route
          path="/app/Autonomous/Authorize Principal/SSRAuthorize/Profile Of The College"
          component={AutonomousPrincipalProfileOfTheCollegeAuthorize}
        />
        <Route
          path="/app/Autonomous/Quality Advisor/Qualitative Advisor"
          component={AutonomousQL}
        />
        <Route
          path="/app/Autonomous/Quality Advisor/Quantitative Advisor"
          component={AutonomousQN}
        />
        <Route
          path="/app/Autonomous/Quality Advisor/Qualitative and Quantitative Advisor"
          component={AutonomousQLQN}
        />
        <Route
          path="/app/Autonomous/Authorize Principal/authorize Principal"
          component={AutonomousAuthorizePrincipalScreen}
        />
        <Route
          path="/app/Autonomous/Authorize Principal/principal View"
          component={AutonomousPrincipalViewScreen}
        />
        <Route
          path="/app/Autonomous/Dean/QIF Authorize Screen"
          component={AutonomousDeanAuthorizeHODScreen}
        />
        <Route
          path="/app/Autonomous/Authorize HOD/CriteriaAssign"
          component={AutonomousAssignHODScreen}
        />
        <Route
          path="/app/Autonomous/Authorize HOD/Dean view"
          component={HODViewScreen} />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-1/c1.js"
          component={CriteriaView1}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-2/c2.js"
          component={CriteriaView2}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-3/c3.js"
          component={CriteriaView3}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-4/c4.js"
          component={CriteriaView4}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-5/c5.js"
          component={CriteriaView5}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-6/c6.js"
          component={CriteriaView6}
        />
        <Route
          path="/app/Autonomous/QIF/QIF New"
          component={AutonomousCriterias}
        />
        <Route
          path="/app/Autonomous/QIF/Criteria-1"
          component={AutonomousCriteria1}
        />
        <Route
          path="/app/Autonomous/QIF/Criteria-2"
          component={AutonomousCriteria2}
        />
        <Route
          path="/app/Autonomous/QIF/Criteria-3"
          component={AutonomousCriteria3}
        />
        <Route
          path="/app/Autonomous/QIF/Criteria-4"
          component={AutonomousCriteria4}
        />
        <Route
          path="/app/Autonomous/QIF/Criteria-5"
          component={AutonomousCriteria5}
        />
        <Route
          path="/app/Autonomous/QIF/Criteria-6"
          component={AutonomousCriteria6}
        />
        <Route
          path="/app/Autonomous/QIF/Criteria-7"
          component={AutonomousCriteria7}
        />
        <Route
          path="/app/Autonomous/faculty Dashboard"
          component={AutonomousFacultyDashboard}
        />
        <Route
          path="/app/Autonomous/dean Dashboard"
          component={AutonomousDeanDashboard}
        />
        <Route
          path="/app/Autonomous/principal Dashboard"
          component={AutonomousPrincipalDashboard}
        />
        <Route
          path="/app/Autonomous/Quality Advisor Dashboard"
          component={AutonomousQualityAdvDashboard}
        />
        <Route
          path="/app/Autonomous/Historical Data View"
          component={AutonomousHistoricalDataView}
        />
        <Route
          path="/app/Autonomous/QIF Modify"
          component={AutonomousQIFModify}
        />
        <Route
          path="/app/Autonomous/QIF Modify/CriteriaModify-1/c1.js"
          component={CriteriaModify1}
        />
        <Route
          path="/app/Autonomous/QIF Modify/CriteriaModify-2/c2.js"
          component={CriteriaModify2}
        />
        <Route
          path="/app/Autonomous/QIF Modify/CriteriaModify-3/c3.js"
          component={CriteriaModify3}
        />
        <Route
          path="/app/Autonomous/QIF Modify/CriteriaModify-4/c4.js"
          component={CriteriaModify4}
        />
        <Route
          path="/app/Autonomous/QIF Modify/CriteriaModifyw-5/c5.js"
          component={CriteriaModify5}
        />
        <Route
          path="/app/Autonomous/QIF Modify/CriteriaModify-6/c6.js"
          component={CriteriaModify6}
        />
        <Route
          path="/app/Autonomous/QIF Modify/CriteriaModify-7/c7.js"
          component={CriteriaModify7}
        />
        <Route
          path="/app/Autonomous/Quality Advisor/Quality Profile Report"
          component={AutonomousQualityProfileReport}
        />
        <Route
          path="/app/Autonomous/Reference Docs"
          component={ReferenceDocs}
        />
        <Route
          path="/app/Autonomous/Download Excel Report"
          component={AutonomousDownloadExcelReport}
        />
        //* Autonomous Entitlements Registration End Here*// //* Affiliated
        Entitlements Registration Start Here *//
        <Route
          path="/app/Affiliated/Download Excel Report"
          component={AffiliatedDownloadExcelReport}
        />
        <Route
          path="/app/Affiliated/SSR/Profile Of The College"
          component={AffiliatedProfileOfTheCollege}
        />
        <Route
          path="/app/Affiliated/SSR/EvaluationReport"
          component={AffiliatedEvaluationReport}
        />
        <Route
          path="/app/Affiliated/SSR/Extended Profile/ExtendedProfile"
          component={AffiliatedExtendedProfile}
        />
        <Route
          path="/app/Affiliated/SSR/Executive Summary/Executive Summary"
          component={AffiliatedExecutiveSummary}
        />
        <Route
          path="/app/Affiliated/SSRModify/Executive Summary/ExecutiveSummary"
          component={AffiliatedExecutiveSummaryModify}
        />
        <Route
          path="/app/Affiliated/SSRModify/Extended Profile/ExtendedProfile"
          component={AffiliatedExtendedProfileModify}
        />
        <Route
          path="/app/Affiliated/SSRModify/EvaluationReport/EvaluationReport"
          component={AffiliatedEvaluationReportModify}
        />
        <Route
          path="/app/Affiliated/SSRModify/Profile Of The College/ProfileOfTheCollege"
          component={AffiliatedProfileOfTheCollegeModify}
        />
        <Route
          path="/app/Affiliated/SSRView/Executive Summary/ExecutiveSummary"
          component={AffiliatedExecutiveSummaryView}
        />
        <Route
          path="/app/Affiliated/SSRView/Extended Profile/ExtendedProfile"
          component={AffiliatedExtendedProfileView}
        />
        <Route
          path="/app/Affiliated/SSRView/EvaluationReport/EvaluationReport"
          component={AffiliatedEvaluationReportView}
        />
        <Route
          path="/app/Affiliated/SSRView/Profile Of The College/ProfileOfTheCollege"
          component={AffiliatedProfileOfTheCollegeView}
        />
        <Route
          path="/app/Affiliated/SSRAuthorize/Executive Summary/ExecutiveSummary"
          component={AffiliatedExecutiveSummaryAuthorize}
        />
        <Route
          path="/app/Affiliated/Dean/SSRAuthorize/Executive Summary"
          component={AffiliatedDeanExecutiveSummaryAuthorize}
        />
        <Route
          path="/app/Affiliated/Principal/SSRAuthorize/Executive Summary"
          component={AffiliatedPrincipalExecutiveSummaryAuthorize}
        />
        <Route
          path="/app/Affiliated/SSRAuthorize/Extended Profile/ExtendedProfile"
          component={AffiliatedExtendedProfileAuthorize}
        />
        <Route
          path="/app/Affiliated/Dean/SSRAuthorize/Extended Profile"
          component={AffiliatedDeanExtendedProfileAuthorize}
        />
        <Route
          path="/app/Affiliated/Principal/SSRAuthorize/Extended Profile"
          component={AffiliatedPrincipalExtendedProfileAuthorize}
        />
        <Route
          path="/app/Affiliated/SSRAuthorize/EvaluationReport/EvaluationReport"
          component={AffiliatedEvaluationReportAuthorize}
        />
        <Route
          path="/app/Affiliated/Dean/SSRAuthorize/Evaluation Report"
          component={AffiliatedDeanEvaluationReportAuthorize}
        />
        <Route
          path="/app/Affiliated/Principal/SSRAuthorize/Evaluation Report"
          component={AffiliatedPrincipalEvaluationReportAuthorize}
        />
        <Route
          path="/app/Affiliated/Dean/SSRAuthorize/Profile Of The College"
          component={AffiliatedDeanProfileOfTheCollegeAuthorize}
        />
        <Route
          path="/app/Affiliated/Principal/SSRAuthorize/Profile Of The College"
          component={AffiliatedPrincipalProfileOfTheCollegeAuthorize}
        />
        <Route
          path="/app/Affiliated/SSR/Extended Profile/extendedProfile"
          component={AffiliatedExtendedProfile}
        />
        <Route path="/app/Affiliated/IIQA/IIQA" component={AffiliatedIIQA} />
        <Route
          path="/app/Affiliated/IIQA/IIQAModify"
          component={AffiliatedIIQAModify}
        />
        <Route
          path="/app/Affiliated/IIQA/IIQAView"
          component={AffiliatedIIQAView}
        />
        <Route
          path="/app/Affiliated/IIQA/IIQAAuthorize"
          component={AffiliatedIIQAAuthorize}
        />
        <Route
          path="/app/Affiliated/Principal/IIQAAuthorize"
          component={AffiliatedPrincipalIIQAAuthorize}
        />
        <Route
          path="/app/Affiliated/Quality Advisor/Qualitative Advisor/QL"
          component={AffiliatedQL}
        />
        <Route
          path="/app/Affiliated/Quality Advisor/Quantitative Advisor/QN"
          component={AffiliatedQN}
        />
        <Route
          path="/app/Affiliated/Quality Advisor/Qualitative and Quantitative Advisor/QLQN"
          component={AffiliatedQLQN}
        />
        <Route
          path="/app/Affiliated/Quality Advisor/QualityProfileReport"
          component={AffiliatedQualityProfileReport}
        />
        <Route
          path="/app/Affiliated/Authorize Principal/authorize Principal"
          component={AffiliatedAuthorizePrincipalScreen}
        />
        <Route
          path="/app/Affiliated/Authorize Principal/principal View"
          component={AffiliatedPrincipalViewScreen}
        />
        <Route
          path="/app/Affiliated/Dean/QIF/Authorize Screen"
          component={AffiliatedDeanQIFAuthorizeScreen}
        />
        <Route
          path="/app/Affiliated/Authorize HOD/Dean view"
          component={AffiliatedHODViewScreen} />
        <Route
          path="/app/Affiliated/Authorize HOD/assign Dean"
          component={AffiliatedAssignHODScreen}
        />
        <Route path="/app/Authorize HOD/Dean view" component={HODViewScreen} />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-1/c1.js"
          component={CriteriaView1}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-2/c2.js"
          component={CriteriaView2}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-3/c3.js"
          component={CriteriaView3}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-4/c4.js"
          component={CriteriaView4}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-5/c5.js"
          component={CriteriaView5}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-6/c6.js"
          component={CriteriaView6}
        />
        <Route
          path="/app/Affiliated/QIF/QIF New"
          component={AffiliatedCriterias}
        />
        <Route
          path="/app/Affiliated/QIF/Criteria-1"
          component={AffiliatedCriteria1}
        />
        <Route
          path="/app/Affiliated/QIF/Criteria-2"
          component={AffiliatedCriteria2}
        />
        <Route
          path="/app/Affiliated/QIF/Criteria-3"
          component={AffiliatedCriteria3}
        />
        <Route
          path="/app/Affiliated/QIF/Criteria-4"
          component={AffiliatedCriteria4}
        />
        <Route
          path="/app/Affiliated/QIF/Criteria-5"
          component={AffiliatedCriteria5}
        />
        <Route
          path="/app/Affiliated/QIF/Criteria-6"
          component={AffiliatedCriteria6}
        />
        <Route
          path="/app/Affiliated/QIF/Criteria-7"
          component={AffiliatedCriteria7}
        />
        <Route
          path="/app/Affiliated/QIF Modify"
          component={AffiliatedQIFModify}
        />
        <Route
          path="/app/Affiliated/QIF Modify/CriteriaModify-1/c1.js"
          component={CriteriaModify1}
        />
        <Route
          path="/app/Affiliated/QIF Modify/CriteriaModify-2/c2.js"
          component={CriteriaModify2}
        />
        <Route
          path="/app/Affiliated/QIF Modify/CriteriaModify-3/c3.js"
          component={CriteriaModify3}
        />
        <Route
          path="/app/Affiliated/QIF Modify/CriteriaModify-4/c4.js"
          component={CriteriaModify4}
        />
        <Route
          path="/app/Affiliated/QIF Modify/CriteriaModifyw-5/c5.js"
          component={CriteriaModify5}
        />
        <Route
          path="/app/Affiliated/QIF Modify/CriteriaModify-6/c6.js"
          component={CriteriaModify6}
        />
        <Route
          path="/app/Autonomous/QIF Modify/CriteriaModify-7/c7.js"
          component={CriteriaModify7}
        />
        <Route
          path="/app/Affiliated/faculty Dashboard"
          component={AutonomousFacultyDashboard}
        />
        <Route
          path="/app/Affiliated/dean Dashboard"
          component={AffiliatedDeanDashboard}
        />
        <Route
          path="/app/Affiliated/principal Dashboard"
          component={AffiliatedPrincipalDashboard}
        />
        <Route
          path="/app/Affiliated/Quality Advisor Dashboard"
          component={AffiliatedQualityAdvDashboard}
        />

        //* Affiliated Entitlements Registration End Here *// //* Universities
        Entitlements Registration Start Here *//
        <Route
          path="/app/Universities/Download Excel Report"
          component={UniversitiesDownloadExcelReport}
        />
        <Route
          path="/app/Universities/SSR/Profile Of The College"
          component={UniversitiesProfileOfTheCollege}
        />
        <Route
          path="/app/Universities/SSR/EvaluationReport"
          component={UniversitiesEvaluationReport}
        />
        <Route
          path="/app/Universities/SSR/ExecutiveSummary"
          component={UniversitiesExecutiveSummary}
        />
        <Route
          path="/app/Universities/SSR/Extended Profile"
          component={UniversitiesExtendedProfile}
        />
        <Route
          path="/app/Universities/SSRModify/Executive Summary/ExecutiveSummary"
          component={UniversitiesExecutiveSummaryModify}
        />
        <Route
          path="/app/Universities/SSRModify/Extended Profile/ExtendedProfile"
          component={UniversitiesExtendedProfileModify}
        />
        <Route
          path="/app/Universities/SSRModify/EvaluationReport/EvaluationReport"
          component={UniversitiesEvaluationReportModify}
        />
        <Route
          path="/app/Universities/SSRModify/Profile Of The College/ProfileOfTheCollege"
          component={UniversitiesProfileOfTheCollegeModify}
        />
        <Route
          path="/app/Universities/Authorize HOD/SSRView/Executive Summary"
          component={UniversitiesDeanviewExecutiveSummary}
        />
        <Route
          path="/app/Universities/Authorize Principal/SSRView/Executive Summary"
          component={UniversitiesprincipalviewExecutiveSummary}
        />
        <Route
          path="/app/Universities/Authorize HOD/SSRAuthorize/Executive Summary/ExecutiveSummary"
          component={UniversitiesDeanAuthorizeExecutiveSummary}
        />

        <Route
          path="/app/Universities/Authorize Principal/SSRAuthorize/Executive Summary/ExecutiveSummary"
          component={UniversitiesprincipalAuthorizeExecutiveSummary}
        />
        <Route
          path="/app/Universities/SSRView/Extended Profile/ExtendedProfile"
          component={UniversitiesExtendedProfileView}
        />
        <Route
          path="/app/Universities/SSRView/Executive Summary/ExecutiveSummary"
          component={UniversitiesExecutiveSummaryView}
        />
        <Route
          path="/app/Universities/SSRView/EvaluationReport/EvaluationReport"
          component={UniversitiesEvaluationReportView}
        />
        <Route
          path="/app/Universities/SSRView/Profile Of The College/ProfileOfTheCollege"
          component={UniversitiesProfileOfTheCollegeView}
        />
        <Route
          path="/app/Universities/Authorize HOD/SSRAuthorize/Profile Of The College/ProfileOfTheCollege"
          component={UniversitiesDeanProfileOfTheCollege}
        />
        <Route
          path="/app/Universities/Authorize Principal/SSRAuthorize/Profile Of The College/ProfileOfTheCollege"
          component={UniversitiesprincipalProfileOfTheCollege}
        />
        <Route
          path="/app/Universities/SSRAuthorize/Executive Summary/ExecutiveSummary"
          component={UniversitiesExecutiveSummaryAuthorize}
        />
        <Route
          path="/app/Universities/SSRAuthorize/Extended Profile/ExtendedProfile"
          component={UniversitiesExtendedProfileAuthorize}
        />
        <Route
          path="/app/Universities/Authorize HOD/SSRAuthorize/Extended Profile/ExtendedProfile"
          component={UniversitiesDeanExtendedProfile}
        />
        <Route
          path="/app/Universities/Authorize Principal/SSRAuthorize/Extended Profile/ExtendedProfile"
          component={UniversitiesprincipalExtendedProfile}
        />
        <Route
          path="/app/Universities/SSRAuthorize/EvaluationReport/EvaluationReport"
          component={UniversitiesEvaluationReportAuthorize}
        />
        <Route
          path="/app/Universities/Authorize HOD/SSRAuthorize/EvaluationReport/EvaluationReport"
          component={UniversitiesDeanEvaluationReport}
        />
        <Route
          path="/app/Universities/Authorize Principal/SSRAuthorize/EvaluationReport/EvaluationReport"
          component={UniversitiesprincipalEvaluationReport}
        />
        <Route
          path="/app/Universities/SSRAuthorize/Profile Of The College/ProfileOfTheCollege"
          component={UniversitiesProfileOfTheCollegeAuthorize}
        />
        <Route
          path="/app/Universities/IIQA/IIQA"
          component={UniversitiesIIQA}
        />
        <Route
          path="/app/Universities/IIQA/IIQAModify"
          component={UniversitiesIIQAModify}
        />
        <Route
          path="/app/Universities/IIQA/IIQAview"
          component={UniversitiesIIQAView}
        />
        <Route
          path="/app/Universities/Authorize HOD/IIQAView"
          component={UniversitiesDeanIIQAView}
        />
        <Route
          path="/app/Universities/Authorize Principal/IIQAView"
          component={UniversitiesPrincipalIIQAView}
        />
        {/* <Route path="/app/Universities/IIQA/IIQAAuthorize"
          component={UniversitiesIIQAAuthorize}
        /> */}
        <Route
          path="/app/Universities/Authorize HOD/IIQAAuthorize"
          component={UniversitiesDeanIIQAAuthorize}
        />
        <Route
          path="/app/Universities/Authorize Principal/IIQAAuthorize"
          component={UniversitiesPricipalIIQAAuthorize}
        />
        <Route
          path="/app/Universities/Quality Advisor/Qualitative Advisor/QL"
          component={UniversitiesQL}
        />
        <Route
          path="/app/Universities/Quality Advisor/Quantitative Advisor/QN"
          component={UniversitiesQN}
        />
        <Route
          path="/app/Universities/Quality Advisor/Qualitative and Quantitative Advisor/QLQN"
          component={UniversitiesQLQN}
        />
        <Route
          path="/app/Universities/Quality Advisor/QualityProfileReport"
          component={UniversitiesQualityProfileReport}
        />
        <Route
          path="/app/Universities/Authorize Principal/authorize Principal"
          component={UniversitiesAuthorizePrincipalScreen}
        />
        <Route
          path="/app/Universities/Princiap/QIF Authorize"
          component={UniversitiesAuthorizePrincipalScreen}
        />
        <Route
          path="/app/Universities/Authorize Principal/principal View"
          component={UniversitiesPrincipalViewScreen}
        />
        <Route
          path="/app/Universities/Authorize HOD/authorize Dean"
          component={UniversitiesAuthorizeHODScreen}
        />
        <Route
          path="/app/Universities/Dean/QIF/Authorize Screen"
          component={UniversitiesDeanQIFAuthorizeScreen}
        />
        <Route
          path="/app/Universities/Principal/QIF/Authorize Screen"
          component={UniversitiesPrincipalQIFAuthorizeScreen}
        />
        <Route
          path="/app/Universities/Authorize HOD/Dean view"
          component={UniversitiesHODViewScreen}
        />
        <Route
          path="/app/Universities/Authorize HOD/assign Dean"
          component={UniversitiesAssignHODScreen}
        />
        <Route path="/app/Authorize HOD/Dean view" component={HODViewScreen} />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-1/c1.js"
          component={CriteriaView1}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-2/c2.js"
          component={CriteriaView2}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-3/c3.js"
          component={CriteriaView3}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-4/c4.js"
          component={CriteriaView4}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-5/c5.js"
          component={CriteriaView5}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-6/c6.js"
          component={CriteriaView6}
        />
        <Route
          path="/app/Authorize HOD/ViewHOD/CriteriaView-6/c7.js"
          component={CriteriaView7}
        />
        <Route
          path="/app/Universities/QIF/QIF New"
          component={UniversitiesCriterias}
        />
        <Route
          path="/app/Universities/QIF/Criterian-1"
          component={UniversitiesCriteria1}
        />
        <Route
          path="/app/Universities/QIF/Criterian-2"
          component={UniversitiesCriteria2}
        />
        <Route
          path="/app/Universities/QIF/Criterian-3"
          component={UniversitiesCriteria3}
        />
        <Route
          path="/app/Universities/QIF/Criterian-4"
          component={UniversitiesCriteria4}
        />
        <Route
          path="/app/Universities/QIF/Criterian-5"
          component={UniversitiesCriteria5}
        />
        <Route
          path="/app/Universities/QIF/Criterian-6"
          component={UniversitiesCriteria6}
        />
        <Route
          path="/app/Universities/QIF/Criterian-7"
          component={UniversitiesCriteria7}
        />
        <Route
          path="/app/Universities/QIF Modify"
          component={UniversitiesQIFModify}
        />
        {/* /Universities/QIF Modify/QifModify */}
        <Route
          path="/app/Universities/QIF Modify/CriteriaModify-1/c1.js"
          component={CriteriaModify1}
        />
        <Route
          path="/app/Universities/QIF Modify/CriteriaModify-2/c2.js"
          component={CriteriaModify2}
        />
        <Route
          path="/app/Universities/QIF Modify/CriteriaModify-3/c3.js"
          component={CriteriaModify3}
        />
        <Route
          path="/app/Universities/QIF Modify/CriteriaModify-4/c4.js"
          component={CriteriaModify4}
        />
        <Route
          path="/app/Universities/QIF Modify/CriteriaModifyw-5/c5.js"
          component={CriteriaModify5}
        />
        <Route
          path="/app/Universities/QIF Modify/CriteriaModify-6/c6.js"
          component={CriteriaModify6}
        />
        <Route
          path="/app/Universities/QIF Modify/CriteriaModify-7/c7.js"
          component={CriteriaModify7}
        />
        <Route
          path="/app/Universities/faculty Dashboard"
          component={UniversitiesFacultyDashboard}
        />
        <Route
          path="/app/Universities/dean Dashboard"
          component={UniversitiesDeanDashboard}
        />
        <Route
          path="/app/Universities/principal Dashboard"
          component={UniversitiesPrincipalDashboard}
        />
        <Route
          path="/app/Universities/Quality Advisor Dashboard"
          component={UniversitiesQualityAdvDashboard}
        />
        //* Affiliated Entitlements Registration End Here *//
        <Route path="/app/Feedback Forms/Feedback" component={Feedback} />
        {/* <Route
          path="/app/Admin Forms/AdminNew/Admission Form"
          component={Admin2}
        /> */}
        {/* <Route
          path="/app/Faculty Forms/Admin Forms/Admin1"
          component={AdminFormEnquiry}
        /> */}
        <Route
          path="/app/Faculty Forms/Teaching and learning activities"
          component={TeachingAndLearningActivities}
        />
        <Route
          path="/app/Faculty Forms/Faculty Report"
          component={FacultyReport}
        />
        <Route
          path="/app/Faculty Forms/Faculty Daily Report"
          component={FacultyDailyReport}
        />
        <Route
          path="/app/Faculty Forms/Document Submission"
          component={DocumentSubmission}
        />
        <Route
          path="/app/Faculty Forms/Event Details"
          component={EventDetails}
        />
        <Route
          path="/app/Faculty Forms/Research Publications"
          component={ResearchPublications}
        />
        <Route path="/app/Mentoring Form/Mente" component={Mente} />
        <Route
          path="/app/Student/Laptop Availability Survey"
          component={LaptopAvailabilitySurvey}
        />
        <Route
          path="/app/Student/Student Request Form"
          component={StudentRequestForm}
        />
        <Route
          path="/app/Student/Course Registration Form"
          component={CourseRegistrationForm}
        />
        <Route
          path="/app/Student/STUDENT PLACEMENT INTERNSHIP DETAILS"
          component={STUDENTPLACEMENTINTERNSHIPDETAILS}
        />
        <Route path="/app/pages/not-found" component={NotFound} />
        <Route path="/app/pages/error" component={Error} />
        <Route exact path="/app/pages" component={Parent} />
        <Route path="/app/NIRF" component={NIRF} />
        <Route component={NotFound} />
        <Route exact path="/app" component={BlankPage} />
        <Route exact path="/app/blank-page" component={BlankPage} />
        <Route path="/app/pages/dashboard" component={DashboardPage} />
      </Switch>
      <ToastContainer style={{ width: "500px" }} />
    </Dashboard>
  );
}

Application.propTypes = {
  history: PropTypes.object.isRequired,
};

export default Application;
