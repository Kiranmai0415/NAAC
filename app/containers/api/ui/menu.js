import React from "react";
import AuthService from "../../containers/Pages/Users/services/auth.service";
let role = null;
const menuArray = [{}];
if (AuthService.getCurrentUser()) {
  console.log(
    "what is the current user ==>" + AuthService.getCurrentUser().roles[0]
  );
  // eslint-disable-next-line prefer-destructuring
  role = AuthService.getCurrentUser().roles[0];
}
if (role === "ROLE_FACULTY") {
  menuArray[0] = [
    {
      key: "ReferenceDocs",
      name: "Reference",
      icon: "ion-ios-book-outline",
      linkParent: "/app/Autonomous/Reference Docs",
    },

    {

//Faculty Form 
      key: "faculty-forms",
      name: "Faculty forms",
      icon: "ion-ios-book-outline",
      child: [
        {
          key: "faculty-1",
          name: "Teaching and learning activities",
          link: "/app/Faculty Forms/Teaching and learning activities",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-2",
          name: "Faculty Report",
          link: "/app/Faculty Forms/Faculty Report",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-3",
          name: "Faculty Daily Report",
          link: "/app/Faculty Forms/Faculty Daily Report",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-4",
          name: "Document Submission",
          link: "/app/Faculty Forms/Document Submission",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-5",
          name: "Event Details",
          link: "/app/Faculty Forms/Event Details",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-6",
          name: "Research Publications",
          link: "/app/Faculty Forms/Research Publications",
          icon: "ion-ios-list-box-outline",
        },
      ],
    },
    

    {
      key: "NAACAUTONOMOUS",
      name: "NAAC Autonomous",
      multilevel: true,
      icon: "ion-ios-bookmark-outline",
      child: [
        {
          key: "IIQA",
          name: "IIQA",
          keyParent: "NAACAUTONOMOUS",
          child: [
            {
              key: "IIQA",
              name: "New",
              link: "/app/Autonomous/IIQA/IIQA",
            },
            {
              key: "Modify",
              name: "Modify",
              link: "/app/Autonomous/IIQA/IIQAModify",
            },
            {
              key: "View",
              name: "View",
              link: "/app/Autonomous/IIQA/IIQAview",
            },
            {
              key: "Authorize",
              name: "Authorize",
              link: "/app/Autonomous/IIQA/IIQAAuthorize",
            },
          ],
        },
        {
          key: "ssr",
          keyParent: "NAACAUTONOMOUS",
          name: "SSR",
          child: [
            {
              key: "SSRNew",
              name: "New",
              title: true,
            },
            {
              key: "Executive Summary",
              name: "Executive Summary",
              link: "/app/Autonomous/SSR/Executive Summary/ExecutiveSummary",
            },
            {
              key: "profile-of-the-college",
              name: "Profile of the Autonomous College",
              link: "/app/Autonomous/SSR/Profile Of The College",
            },
            {
              key: "extended-profile",
              name: "Extended Profile of the Autonomous College",
              link: "/app/Autonomous/SSR/Extended Profile/ExtendedProfile",
            },
            {
              key: "Evaluation-Report",
              name: "Evaluation-Report",
              link: "/app/Autonomous/SSR/EvaluationReport/EvaluationReport",
            },
            {
              key: "SSRNew",
              name: "Modify",
              title: true,
            },
            {
              key: "Executive Summary",
              name: "Executive Summary",
              link: "/app/Autonomous/SSRModify/Executive Summary/ExecutiveSummaryModify",
            },
            {
              key: "profile-of-the-college",
              name: "Profile of the Autonomous College",
              link: "/app/Autonomous/SSRModify/Profile Of The College/ProfileOfTheCollegeModify",
            },
            {
              key: "extended-profile",
              name: "Extended Profile of the Autonomous College",
              link: "/app/Autonomous/SSRModify/Extended Profile/ExtendedProfile",
            },
            {
              key: "Evaluation-Report",
              name: "Evaluation-Report",
              link: "/app/Autonomous/SSRModify/EvaluationReport/EvaluationReportModify",
            },
            {
              key: "SSRNew",
              name: "View",
              title: true,
            },
            {
              key: "Executive Summary",
              name: "Executive Summary",
              link: "/app/Autonomous/SSRView/Executive Summary/ExecutiveSummaryView",
            },
            {
              key: "profile-of-the-college",
              name: "Profile of the Autonomous College",
              link: "/app/Autonomous/SSRView/Profile Of The College/ProfileOfTheCollegeView",
            },
            {
              key: "extended-profile",
              name: "Extended Profile of the Autonomous College",
              link: "/app/Autonomous/SSRView/Extended Profile/ExtendedProfile",
            },
            {
              key: "Evaluation-Report",
              name: "Evaluation-Report",
              link: "/app/Autonomous/SSRView/EvaluationReport/EvaluationReportView",
            },
          ],
        },

        {
          key: "QIF",
          keyParent: "NAACAUTONOMOUS",
          name: "Quality Indicater Framework (QIF)",
          child: [
            {
              key: "qif",
              keyParent: "QIF",
              name: "New",
              link: "/app/Autonomous/QIF/QIF New",
            },
            {
              key: "QIFModify",
              name: "Modify",
              link: "/app/Autonomous/QIF Modify",
              icon: "ion-ios-list-box-outline",
            },
          ],
        },
      ],
    },
    {
      key: "NAACUNIVERSITY",
      name: "NAAC University",
      multilevel: true,
      icon: "ion-ios-bookmark-outline",
      child: [
        {
          key: "IIQA",
          name: "IIQA",
          keyParent: "NAACUNIVERSITY",
          child: [
            {
              key: "IIQA",
              name: "New",
              link: "/app/Universities/IIQA/IIQA",
            },
            {
              key: "Modify",
              name: "Modify",
              link: "/app/Universities/IIQA/IIQAModify",
            },
            {
              key: "View",
              name: "View",
              link: "/app/Universities/IIQA/IIQAview",
            },
            {
              key: "Authorize",
              name: "Authorize",
              link: "/app/Universities/IIQA/IIQAAuthorize",
            },
          ],
        },
        {
          key: "ssr",
          keyParent: "NAACUNIVERSITY",
          name: "SSR",
          child: [
            {
              key: "SSRNew",
              name: "New",
              title: true,
            },
            {
              key: "Executive Summary",
              name: "Executive Summary",
              link: "/app/Universities/SSR/ExecutiveSummary",
            },
            {
              key: "profile-of-the-college",
              name: "profile-of-the-college",
              link: "/app/Universities/SSR/Profile Of The College",
            },
            {
              key: "extended-profile",
              name: "Extended Profile",
              link: "/app/Universities/SSR/Extended Profile",
            },
            {
              key: "Evaluation-Report",
              name: "Evaluation-Report",
              link: "/app/Universities/SSR/EvaluationReport/EvaluationReport",
            },
            {
              key: "SSRNew",
              name: "Modify",
              title: true,
            },
            {
              key: "Executive Summary",
              name: "Executive Summary",
              link: "/app/Universities/SSRModify/Executive Summary/ExecutiveSummary",
            },
            {
              key: "profile-of-the-college",
              name: "Profile of the College",
              link: "/app/Universities/SSRModify/Profile Of The College/ProfileOfTheCollege",
            },
            {
              key: "extended-profile",
              name: "Extended Profile",
              link: "/app/Universities/SSRModify/Extended Profile/ExtendedProfile",
            },
            {
              key: "Evaluation-Report",
              name: "Evaluation-Report",
              link: "/app/Universities/SSRModify/EvaluationReport/EvaluationReport",
            },
            {
              key: "SSRNew",
              name: "View",
              title: true,
            },
            {
              key: "Executive Summary",
              name: "Executive Summary",
              link: "/app/Universities/SSRView/Executive Summary/ExecutiveSummary",
            },
            {
              key: "profile-of-the-college",
              name: "Profile of the College",
              link: "/app/Universities/SSRView/Profile Of The College/ProfileOfTheCollege",
            },
            {
              key: "extended-profile",
              name: "Extended Profile",
              link: "/app/Universities/SSRView/Extended Profile/ExtendedProfile",
            },
            {
              key: "Evaluation-Report",
              name: "Evaluation-Report",
              link: "/app/Universities/SSRView/EvaluationReport/EvaluationReport",
            },
          ],
        },

        {
          key: "QIF",
          keyParent: "NAACUNIVERSITY",
          name: "Quality Indicater Framework (QIF)",
          child: [
            {
              key: "qif",
              keyParent: "QIF",
              name: "New",
              link: "/app/Universities/QIF/QIF New",
            },
            {
              key: "QIFModify",
              name: "Modify",
              link: "/app/Universities/QIF Modify",
              icon: "ion-ios-list-box-outline",
            },
          ],
        },

      ],
    },
    {
      key: "NAACAFFILIATED",
      name: "NAAC Affiliated",
      multilevel: true,
      icon: "ion-ios-bookmark-outline",
      child: [
        {
          key: "IIQA",
          name: "IIQA",
          keyParent: "NAACAFFILIATED",
          child: [
            {
              key: "IIQA",
              name: "New",
              link: "/app/Affiliated/IIQA/IIQA",
            },
            {
              key: "Modify",
              name: "Modify",
              link: "/app/Affiliated/IIQA/IIQAModify",
            },
            {
              key: "View",
              name: "View",
              link: "/app/Affiliated/IIQA/IIQAview",
            },
            {
              key: "Authorize",
              name: "Authorize",
              link: "/app/Affiliated/IIQA/IIQAAuthorize",
            },
          ],
        },
        {
          key: "ssr",
          keyParent: "NAACAFFILIATED",
          name: "SSR",
          child: [
            {
              key: "SSRNew",
              name: "New",
              title: true,
            },
            {
              key: "Executive Summary",
              name: "Executive Summary",
              link: "/app/Affiliated/SSR/Executive Summary/Executive Summary",
            },
            {
              key: "profile-of-the-college",
              name: "profile-of-the-college",
              link: "/app/Affiliated/SSR/Profile Of The College",
            },
            {
              key: "extended-profile",
              name: "Extended Profile",
              link: "/app/Affiliated/SSR/Extended Profile/ExtendedProfile",
            },
            {
              key: "Evaluation-Report",
              name: "Evaluation-Report",
              link: "/app/Affiliated/SSR/EvaluationReport",
            },
            {
              key: "SSRNew",
              name: "Modify",
              title: true,
            },
            {
              key: "Executive Summary",
              name: "Executive Summary",
              link: "/app/Affiliated/SSRModify/Executive Summary/ExecutiveSummary",
            },
            {
              key: "profile-of-the-college",
              name: "Profile of the College",
              link: "/app/Affiliated/SSRModify/Profile Of The College/ProfileOfTheCollege",
            },
            {
              key: "extended-profile",
              name: "Extended Profile of the College",
              link: "/app/Affiliated/SSRModify/Extended Profile/ExtendedProfile",
            },
            {
              key: "Evaluation-Report",
              name: "Evaluation-Report",
              link: "/app/Affiliated/SSRModify/EvaluationReport/EvaluationReport",
            },
            {
              key: "SSRNew",
              name: "view",
              title: true,
            },
            {
              key: "Executive Summary",
              name: "Executive Summary",
              link: "/app/Affiliated/SSRView/Executive Summary/ExecutiveSummary",
            },
            {
              key: "profile-of-the-college",
              name: "Profile of the College",
              link: "/app/Affiliated/SSRView/Profile Of The College/ProfileOfTheCollege",
            },
            {
              key: "extended-profile",
              name: "Extended Profile of the College",
              link: "/app/Affiliated/SSRView/Extended Profile/ExtendedProfile",
            },
            {
              key: "Evaluation-Report",
              name: "Evaluation-Report",
              link: "/app/Affiliated/SSRView/EvaluationReport/EvaluationReport",
            },
          ],
        },

        {
          key: "QIF",
          keyParent: "NAACAFFILIATED",
          name: "Quality Indicater Framework (QIF)",
          child: [
            {
              key: "qif",
              keyParent: "QIF",
              name: "New",
              link: "/app/Affiliated/QIF/QIF New",
            },
            {
              key: "QIFModify",
              name: "Modify",
              link: "/app/Affiliated/QIF Modify",
              icon: "ion-ios-list-box-outline",
            },
          ],
        },

      ],
    },
    {
      key: "NBA",
      name: "NBA",
      icon: "ion-ios-bookmark-outline",
      child: [

        {
          key: "Profile",
          name: "Profile",
          title: true,
        },

        {
          key: "Profile",
          name: "Profile",
          link: "/app/NBA/Profile/Profile",
        },

        {
          key: "Acadamics",
          name: "Acadamics",
          title: true,

        },

        {
          key: "Acadamics",
          name: "Acadamics",
          link: "/app/NBA/Academics/Acadamics",
        },

        {
          key: "Research",
          name: "Research",
          title: true,

        },

        {
          key: "AcadamicResearch",
          name: "AcadamicResearch",
          link: "/app/NBA/Research/AcadamicResearch/AcadamicResearch"
        },

        {
          key: "SponsoredResearch/Project",
          name: "SponsoredResearch/Project",
          link: "/app/Research/SponsoredResearch/SponsoredResearch"
        },

        {
          key: "Counselling",
          name: "Counselling",
          link: "/app/NBA/Counselling/Counselling"
        },
        // modify counselling
        {
          key: "Counselling",
          name: "Modify",
          title: true,

        },

        {
          key: "Counselling",
          name: "Counselling",
          link: "/app/FacultyDashBoardModify/Counselling/Counselling"
        },
        {
          key: "Academics",
          name: "Academics",
          link: "/app/FacultyDashBoardModify/Academics/Acadamics"
        },
        {
          key: "Profile",
          name: "Profile",
          link: "/app/FacultyDashBoardModify/Profile/Profile"
        },
        {
          key: "Academic Research",
          name: "Academic Research",
          link: "/app/FacultyDashBoardModify/Research/AcadamicResearch/AcadamicResearch"
        },
        {
          key: "Sponsered Research",
          name: "Sponsered Research",
          link: "/app/FacultyDashBoardModify/Research/SponsoredResearch/SponsoredResearch"
        },

      ],
    },

    {
      key: "admin-forms",
      name: "Admin forms",
      icon: "ion-ios-book-outline",
      child: [
        {
          key: "admin-1",
          name: "Admin-1",
          link: "/app/AdminNew/Admin Forms/Admin1",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "admin-enquiry",
          name: "Admin-Enquiry",
          link: "/app/Admin Forms/AdminNew/AdminEnquiryForm",
          icon: "ion-ios-list-box-outline",
        },
      ],
    },
    {
      key: "feedback-forms",
      name: "Feedback forms",
      icon: "ion-ios-book-outline",
      linkParent: "/app/Feedback Forms/Feedback",
    },
    {
      key: "Register",
      name: "Register",
      icon: "ion-ios-book-outline",
      linkParent: "/register",
    }
  ];
} else if (role === "ROLE_STUDENT") {
  menuArray[0] = [
    {
      key: "student-forms",
      name: "Student forms",
      icon: "ion-ios-book-outline",
      child: [
        {
          key: "student-1",
          name: "Laptop Availability Survey",
          link: "/app/Student/Laptop Availability Survey",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "student-2",
          name: "Student Request Form",
          link: "/app/Student/Student Request Form",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "student-3",
          name: "Course Registration Form",
          link: "/app/Student/Course Registration Form",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "student-4",
          name: "Student Placement / Internship Details",
          link: "/app/Student/STUDENT PLACEMENT INTERNSHIP DETAILS",
          icon: "ion-ios-list-box-outline",
        },
      ],
    },
    {
      key: "intern-forms",
      name: "Intern forms",
      icon: "ion-ios-book-outline",
      child: [
        {
          key: "intern-1",
          name: "Intern-1",
          link: "/app/Intern Forms/Intern1",
          icon: "ion-ios-list-box-outline",
        },
      ],
    },
  ];
} else if (role === "ROLE_DEAN") {
  menuArray[0] = [
    {
      key: "NAAC",
      name: "NAAC",
      multilevel: true,
      icon: "ion-ios-menu-outline",
      child: [
        {
          key: "autonomous",
          keyParent: "NAAC",
          name: "Autonomous",
          child: [
            {
              key: "QIF",
              name: "QIF",
              title: true,
            },
            {
              key: "AUTONOMOUSDEANASSIGN",
              name: "Assign",
              link: "/app/Autonomous/Authorize HOD/CriteriaAssign",
            },
            {
              key: "AUTONOMOUSDEANVIEW",
              name: "View",
              link: "/app/Authorize HOD/Dean view",
            },
            {
              key: "AUTONOMOUSDEANVIEW",
              name: "Authorize",
              link: "/app/Autonomous/Authorize HOD/authorize Dean",
            },
            {
              key: "Authorize",
              name: "IIQA",
              title: true,
            },
            {
              key: "Authorize",
              name: "Authorize",
              link: "/app/Autonomous/IIQA/IIQAAuthorize",
            },
            {
              key: "Authorize",
              name: "SSR",
              title: true,
            },
            {
              key: "Executive Summary",
              name: "Executive Summary",
              link: "/app/Autonomous/SSRAuthorize/Executive Summary/ExecutiveSummaryAuthorize",
            },
            {
              key: "profile-of-the-college",
              name: "Profile of the Autonomous College",
              link: "/app/Autonomous/SSRAuthorize/Profile Of The College/ProfileOfTheCollegeAuthorize",
            },
            {
              key: "extended-profile",
              name: "Extended Profile",
              link: "/app/Autonomous/SSRAuthorize/Extended Profile/ExtendedProfile",
            },
            {
              key: "Evaluation-Report",
              name: "Evaluation-Report",
              link: "/app/Autonomous/SSRAuthorize/EvaluationReport/EvaluationReportAuthorize",
            },
          ],
        },
        {
          key: "affiliated",
          keyParent: "NAAC",
          name: "Affiliated",
          child: [
            {
              key: "Authorize",
              name: "QIF",
              title: true,
            },
            {
              key: "AFFILIATEDDEANASSIGN",
              name: "Assign",
              link: "/app/Affiliated/Authorize HOD/assign Dean",
            },
            {
              key: "AFFILIATEDDEANVIEW",
              name: "View",
              link: "/app/Affiliated/Authorize HOD/Dean view",
            },
            {
              key: "AFFILIATEDDEANAUTH",
              name: "Authorize",
              link: "/app/Affiliated/Authorize HOD/authorize Dean",
            },
            {
              key: "Authorize",
              name: "IIQA",
              title: true,
            },
            {
              key: "Authorize",
              name: "Authorize",
              link: "/app/Affiliated/IIQA/IIQAAuthorize",
            },

            {
              key: "Authorize",
              name: "SSR",
              title: true,
            },
            {
              key: "Executive Summary",
              name: "Executive Summary",
              link: "/app/Affiliated/SSRModify/Executive Summary/ExecutiveSummary",
            },
            {
              key: "profile-of-the-college",
              name: "Profile of the College",
              link: "/app/Affiliated/SSRModify/Profile Of The College/ProfileOfTheCollege",
            },
            {
              key: "extended-profile",
              name: "Extended Profile of the College",
              link: "/app/Affiliated/SSRModify/Extended Profile/ExtendedProfile",
            },
            {
              key: "Evaluation-Report",
              name: "Evaluation-Report",
              link: "/app/Affiliated/SSRModify/EvaluationReport/EvaluationReport",
            },
          ],
        },
        {
          key: "university",
          keyParent: "NAAC",
          name: "University",
          child: [
            {
              key: "Authorize",
              name: "QIF",
              title: true,
            },
            {
              key: "UNIVERSITYDEANASSIGN",
              name: "Assign",
              link: "/app/Universities/Authorize HOD/assign Dean",
            },
            {
              key: "UNIVERSITYDEANVIEW",
              name: "View",
              link: "/app/Universities/Authorize HOD/Dean view",
            },
            {
              key: "UNIVERSITYDEANAUTH",
              name: "Authorize",
              link: "/app/Universities/Dean/QIF/Authorize Screen",
            },
            {
              key: "Authorize",
              name: "IIQA",
              title: true,
            },
            {
              key: "Authorize",
              name: "Authorize",
              link: "/app/Universities/IIQA/IIQAAuthorize",
            },

            {
              key: "Authorize",
              name: "SSR",
              title: true,
            },
            {
              key: "Executive Summary",
              name: "Executive Summary",
              link: "/app/Universities/SSRModify/Executive Summary/ExecutiveSummary",
            },
            {
              key: "profile-of-the-college",
              name: "Profile of the College",
              link: "/app/Universities/SSRModify/Profile Of The College/ProfileOfTheCollege",
            },
            {
              key: "extended-profile",
              name: "Extended Profile of the College",
              link: "/app/Universities/SSRModify/Extended Profile/ExtendedProfile",
            },
            {
              key: "Evaluation-Report",
              name: "Evaluation-Report",
              link: "/app/Universities/SSRModify/EvaluationReport/EvaluationReport",
            },
          ],
        },
      ],
    },
    {
      key: "reports",
      keyParent: "reports",
      name: "Reports",
      icon: "ion-ios-menu-outline",
      child: [
        {
          key: "historicaldataview",
          name: "Historical Data View",
          link: "/app/Autonomous/Historical Data View",
        },
      ],
    },
  ];
} else if (role === "ROLE_PRINCIPAL") {
  menuArray[0] = [
    {
      key: "NAAC",
      name: "NAAC",
      multilevel: true,
      icon: "ion-ios-menu-outline",
      child: [
        {
          key: "autonomous",
          keyParent: "NAAC",
          name: "Autonomous",
          child: [
            {
              key: "AUTONOMOUSDEANVIEW",
              name: "View",
              link: "/app/Autonomous/Authorize Principal/principal View",
            },
            {
              key: "AUTONOMOUSDEANAUTH",
              name: "Authorize",
              link: "/app/Universities/Principal/QIF/Authorize Screen",
            },
          ],
        },
        {
          key: "affiliated",
          keyParent: "NAAC",
          name: "Affiliated",
          child: [
            {
              key: "AFFILIATEDDEANVIEW",
              name: "View",
              link: "/app/Affiliated/Authorize Principal/principal View",
            },
            {
              key: "AFFILIATEDDEANAUTH",
              name: "Authorize",
              link: "/app/Affiliated/Authorize Principal/authorize Principal",
            },
          ],
        },
        {
          key: "university",
          keyParent: "NAAC",
          name: "University",
          child: [
            {
              key: "UNIVERSITYDEANVIEW",
              name: "View",
              link: "/app/Universities/Authorize Principal/principal View",
            },
            {
              key: "UNIVERSITYDEANAUTH",
              name: "Authorize",
              link: "/app/Universities/Principal/QIF/Authorize Screen",
            },
          ],
        },
      ],
    },
  ];
} else if (role === "ROLE_QUALITYADVISOR") {
  menuArray[0] = [
    {
      key: "NAAC",
      name: "NAAC",
      multilevel: true,
      icon: "ion-ios-menu-outline",
      child: [
        {
          key: "autonomous",
          keyParent: "NAAC",
          name: "Autonomous",
          child: [
            {
              key: "QualitativeAdvisor",
              name: "Qualitative Advisor",
              link: "/app/Autonomous/Quality Advisor/Qualitative Advisor",
              icon: "ion-ios-undo-outline",
            },
            {
              key: "QuantitativeAdvisor",
              name: "Quantitative Advisor",
              link: "/app/Autonomous/Quality Advisor/Quantitative Advisor",
              icon: "ion-ios-undo-outline",
            },
            {
              key: "QualitativeQuantitativeAdvisor",
              name: "Qualitative and Quantitative Advisor",
              link: "/app/Autonomous/Quality Advisor/Qualitative and Quantitative Advisor",
              icon: "ion-ios-undo-outline",
            },
            {
              key: "QualityProfileReport",
              name: "Generate Quality Profile Report",
              link: "/app/Autonomous/Quality Advisor/Quality Profile Report",
              icon: "ion-ios-undo-outline",
            },
          ],
        },
        {
          key: "affiliated",
          keyParent: "NAAC",
          name: "Affiliated",
          child: [
            {
              key: "QualitativeAdvisor",
              name: "Qualitative Advisor",
              link: "/app/Affiliated/Quality Advisor/Qualitative Advisor/QL",
              icon: "ion-ios-undo-outline",
            },
            {
              key: "QuantitativeAdvisor",
              name: "Quantitative Advisor",
              link: "/app/Affiliated/Quality Advisor/Quantitative Advisor/QN",
              icon: "ion-ios-undo-outline",
            },
            {
              key: "QualitativeQuantitativeAdvisor",
              name: "Qualitative and Quantitative Advisor",
              link: "/app/Affiliated/Quality Advisor/Qualitative and Quantitative Advisor/QLQN",
              icon: "ion-ios-undo-outline",
            },
            {
              key: "Quality Profile Report",
              name: "Quality Profile Report",
              link: "/app/Affiliated/Quality Advisor/QualityProfileReport",
              icon: "ion-ios-undo-outline",
            },
          ],
        },
        {
          key: "university",
          keyParent: "NAAC",
          name: "University",
          child: [
            {
              key: "QualitativeAdvisor",
              name: "Qualitative Advisor",
              link: "/app/Universities/Quality Advisor/Qualitative Advisor/QL",
              icon: "ion-ios-undo-outline",
            },
            {
              key: "QuantitativeAdvisor",
              name: "Quantitative Advisor",
              link: "/app/Universities/Quality Advisor/Quantitative Advisor/QN",
              icon: "ion-ios-undo-outline",
            },
            {
              key: "QualitativeQuantitativeAdvisor",
              name: "Qualitative and Quantitative Advisor",
              link: "/app/Universities/Quality Advisor/Qualitative and Quantitative Advisor/QLQN",
              icon: "ion-ios-undo-outline",
            },
            {
              key: "Quality Profile Report",
              name: "Quality Profile Report",
              link: "/app/Universities/Quality Advisor/QualityProfileReport",
              icon: "ion-ios-undo-outline",
            },
          ],
        },
      ],
    },
  ];
} else {
  menuArray[0] = [
    {
      key: "pages",
      name: "Pages",
      icon: "ion-ios-paper-outline",
      child: [
        {
          key: "other_page",
          name: "Welcome Page",
          title: true,
        },
        {
          key: "blank",
          name: "Blank Page",
          link: "/app",
          icon: "ion-ios-document-outline",
        },
        {
          key: "main_page",
          name: "Sample Page",
          title: true,
        },
        {
          key: "dashboard",
          name: "Dashboard",
          link: "/app/pages/dashboard",
          icon: "ion-ios-home-outline",
        },
        {
          key: "form",
          name: "Form",
          link: "/app/pages/form",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "table",
          name: "Table",
          link: "/app/pages/table",
          icon: "ion-ios-grid-outline",
        },
        {
          key: "maintenance",
          name: "Maintenance",
          link: "/maintenance",
          icon: "ion-ios-build-outline",
        },
        {
          key: "coming_soon",
          name: "Coming Soon",
          link: "/coming-soon",
          icon: "ion-ios-bonfire-outline",
        },
      ],
    },
    {
      key: "ssr",
      name: "SSR",
      icon: "ion-ios-bookmark-outline",
      child: [
        {
          key: "profile-of-the-college",
          name: "Profile",
          link: "/app/SSR/Profile Of The College",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "institutional-preparedness",
          name: "Preparedness",
          link: "/app/SSR/Preparedness",
          icon: "ion-ios-grid-outline",
        },
      ],
    },
    {
      key: "qif",
      name: "QIF fields",
      icon: "ion-ios-book-outline",
      child: [
        {
          key: "criteria-1",
          name: "Criteria-1",
          link: "/app/QIF/Criteria-1",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "criteria-2",
          name: "Criteria-2",
          link: "/app/QIF/Criteria-2",
          icon: "ion-ios-grid-outline",
        },
        {
          key: "criteria-3",
          name: "Criteria-3",
          link: "/app/QIF/Criteria-3",
          icon: "",
        },
        {
          key: "criteria-4",
          name: "Criteria-4",
          link: "/app/QIF/Criteria-4",
          icon: "",
        },
        {
          key: "criteria-5",
          name: "Criteria-5",
          link: "/app/QIF/Criteria-5",
          icon: "",
        },
        {
          key: "criteria-6",
          name: "Criteria-6",
          link: "/app/QIF/Criteria-6",
          icon: "",
        },
      ],
    },
    {
      key: "auth",
      name: "Auth Page",
      icon: "ion-ios-contact-outline",
      child: [
        {
          key: "auth_page",
          name: "User Authentication",
          title: true,
        },
        {
          key: "login",
          name: "Login",
          link: "/login",
          icon: "ion-ios-person-outline",
        },
        {
          key: "register",
          name: "Register",
          link: "/register",
          icon: "ion-ios-key-outline",
        },
        {
          key: "reset",
          name: "Reset Password",
          link: "/reset-password",
          icon: "ion-ios-undo-outline",
        },
        {
          key: "erpLandingPage",
          name: "ERP Landing Page",
          link: "/erpLandingPage",
          icon: "ion-ios-undo-outline",
        },
      ],
    },
    {
      key: "errors",
      name: "Errors",
      icon: "ion-ios-paw-outline",
      child: [
        {
          key: "errors_page",
          name: "Errors Pages",
          title: true,
        },
        {
          key: "not_found_page",
          name: "Not Found Page",
          link: "/app/pages/not-found",
          icon: "ion-ios-warning-outline",
        },
        {
          key: "error_page",
          name: "Error Page",
          link: "/app/pages/error",
          icon: "ion-ios-warning-outline",
        },
      ],
    },
    {
      key: "menu_levels",
      name: "Menu Levels",
      multilevel: true,
      icon: "ion-ios-menu-outline",
      child: [
        {
          key: "level_1",
          name: "Level 1",
          link: "/#",
        },
        {
          key: "level_2",
          keyParent: "menu_levels",
          name: "Level 2",
          child: [
            {
              key: "sub_menu_1",
              name: "Sub Menu 1",
              link: "/#",
            },
            {
              key: "sub_menu_2",
              name: "Sub Menu 2",
              link: "/#",
            },
          ],
        },
      ],
    },
    {
      key: "no_child",
      name: "One Level Menu",
      icon: "ion-ios-document-outline",
      linkParent: "/app/blank-page",
    },
  ];
}
export default menuArray[0];
