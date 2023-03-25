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

  
     

    
  //Admin Form 
  {
  key: "admin-forms",
  name: "Admin Forms",
  icon: "ion-ios-book-outline",
  child: [
    //Admin Form New

     {
      key: "New",
      name:"New",
      title:true,
     },

    {
      key: "admin-enquiry",
      name: "Admission Enquiry Form",
      link: "/app/Admin Forms/AdminNew/AdminEnquiryForm ",
      icon: "ion-ios-list-box-outline",
    },
    {
      key: "admin-form",
      name: "Admission Form",
      link: "/app/Admin Forms/AdminNew/Admission Form",
      icon: "ion-ios-list-box-outline",
    },


  {
   key: "Modify",
   name: "Modify",
   title: true,
  },

  {
  key: " admin forms",
  name: "Admission Enquiry Form",
  link: "/app/Admin Forms/AdminModify/Admission Enquiry Form Modify",
  icon: "ion-ios-list-box-outline",
   },

   {
    key: " admin forms2",
    name: "Admission Form ",
    link: "/app/Admin Forms/AdminModify/Admission Form Modify" ,
    icon: "ion-ios-list-box-outline",
     },

   //Admin Form View
   
   {
     key: "View",
     name: "View",
     title: true,
    },

    {
    key: " admin form",
    name: "Admission Enquiry Form ",
    link: "/app/Admin Forms/AdminView/Admission Enquiry Form View",
    icon: "ion-ios-list-box-outline",
     },

     {
      key: " admin form2",
      name: "Admission Form",
      link: "/app/Admin Forms/AdminView/Admission Form View",
      icon: "ion-ios-list-box-outline",
       },
   
     //Admin Form Authorize
  
    {
     key: "Authorize",
     name: "Authorize",
     title: true,
     },

     {
     key: " admin form",
     name: "Admission Enquiry Form",
     link: "/app/Admin Forms/AdminAuthorize/Admission Enquiry Form Authorize",
     icon: "ion-ios-list-box-outline",
     },

     {
      key: " admin form2",
      name: "Admission Form ",
      link: "/app/Admin Forms/AdminAuthorize/Admission Form Authorize",
      icon: "ion-ios-list-box-outline",
      },
   
     ],
    },
    
      /*faculty-forms */
   
    {
      key: "faculty-forms",
      name: "Faculty forms",
      icon: "ion-ios-book-outline",
      child: [
        {
          key: "New",
          name: "New",
          title: true,
        },
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

        // Faculty Modify
        {
          key: "Modify",
          name: "Modify",
          title: true,
        },
        {
          key: "faculty-4",
          name: "Document Submission",
          link: "/app/Faculty Forms/FacultyModify/Document Submission",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-5",
          name: "Event Details",
          link: "/app/Faculty Forms/FacultyModify/Event Details",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-3",
          name: "Faculty Daily Report",
          link: "/app/Faculty Forms/FacultyModify/Faculty Daily Report",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-2",
          name: "Faculty Report",
          link: "/app/Faculty Forms/FacultyModify/Faculty Report",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-6",
          name: "Research Publications",
          link: "/app/Faculty Forms/FacultyModify/Research Publications",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-1",
          name: "Teaching and learning activities",
          link: "/app/Faculty Forms/FacultyModify/Teaching and learning activities",
          icon: "ion-ios-list-box-outline",
        },


        // Faculty View
        {
          key: "View",
          name: "View",
          title: true,
        },
        {
          key: "faculty-4",
          name: "Document Submission",
          link: "/app/Faculty Forms/FacultyView/Document Submission",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-5",
          name: "Event Details",
          link: "/app/Faculty Forms/FacultyView/Event Details",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-3",
          name: "Faculty Daily Report",
          link: "/app/Faculty Forms/FacultyView/Faculty Daily Report",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-2",
          name: "Faculty Report",
          link: "/app/Faculty Forms/FacultyView/Faculty Report",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-6",
          name: "Research Publications",
          link: "/app/Faculty Forms/FacultyView/Research Publications",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "faculty-1",
          name: "Teaching and learning activities",
          link: "/app/Faculty Forms/FacultyView/Teaching and learning activities",
          icon: "ion-ios-list-box-outline",
        },

        
      ],
    },

    {
      key: "NAACAUTONOMOUS",
      name: "NAAC Autonomous",
      icon: "ion-ios-bookmark-outline",
      child: [
        {
          key: "IIQA",
          name: "IIQA",
          title: true,
        },
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
        // {
        //   key: "Authorize",
        //   name: "Authorize",
        //   link: "/app/Autonomous/IIQA/IIQAAuthorize",
        // },
        {
          key: "SSRNew",
          name: "SSR New",
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
          key: "SSRModify",
          name: "SSR Modify",
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
          key: "SSRView",
          name: "SSR View",
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
        {
          key: "QIF",
          name: "Quality Indicater Framework (QIF)",
          title: true,
        },

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
        {
          key: "ReportExcel",
          name: "Reports",
          title: true,
        },
        {
          key: "ReportsExcel",
          name: "Reports Download Excel",
          link: "/app/Autonomous/Download Excel Report",
        },
      ],
    },
    {
      key: "NAACUNIVERSITY",
      name: "NAAC University",
      icon: "ion-ios-bookmark-outline",
      child: [
        {
          key: "IIQA",
          name: "IIQA",
          title: true,
        },
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
        // {
        //   key: "Authorize",
        //   name: "Authorize",
        //   link: "/app/Universities/IIQA/IIQAAuthorize",
        // },

        {
          key: "SSRNew",
          name: "SSR New",
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
          key: "SSRModify",
          name: "SSR Modify",
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
          key: "SSRView",
          name: "SSR View",
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
        {
          key: "QIF",
          name: "Quality Indicater Framework (QIF)",
          title: true,
        },

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
        {
          key: "ReportExcel",
          name: "Reports",
          title: true,
        },
        {
          key: "ReportsExcel",
          name: "Reports Download Excel",
          link: "/app/Universities/Download Excel Report",
        },

      ],
    },

    {
      key: "NAACAFFILIATED",
      name: "NAAC Affiliated",
      icon: "ion-ios-bookmark-outline",
      child: [
        {
          key: "IIQA",
          name: "IIQA",
          title: true,
        },

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
        // {
        //   key: "Authorize",
        //   name: "Authorize",
        //   link: "/app/Affiliated/IIQA/IIQAAuthorize",
        // },

        {
          key: "SSRNew",
          name: "SSR New",
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
          key: "SSRModify",
          name: "SSR Modify",
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
          key: "SSRView",
          name: "SSR View",
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

        {
          key: "QIF",
          name: "Quality Indicater Framework (QIF)",
          title: true,
        },

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
        {
          key: "ReportExcel",
          name: "Reports",
          title: true,
        },
        {
          key: "ReportsExcel",
          name: "Reports Download Excel",
          link: "/app/Affiliated/Download Excel Report",
        },

      ],
    },
    {
      key: "NIRF",
      name: "NIRF",
      icon: "ion-ios-bookmark-outline",
      child: [
        {
          key: "NIRFPage",
          name: "NIRF Page",
          link: "/app/NIRF",
          icon: "ion-ios-list-box-outline",
        },
      ],
    },
    {
      key: "Faculty Dashboard",
      name: "Faculty Dashboard",
      icon: "ion-ios-bookmark-outline",
      child: [
        {
          key: "New",
          name: "New",
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
          link: "/app/NBA/Academics/Acadamics",
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
          key: "Profile",
          name: "Profile",
          link: "/app/FacultyDashBoardModify/Profile/Profile"
        },
        {
          key: "Academics",
          name: "Academics",
          link: "/app/FacultyDashBoardModify/Academics/Acadamics"
        },
       
        {
          key: "Academic Research",
          name: "Academic Research",
          link: "/app/FacultyDashBoardModify/Research/AcadamicResearch/AcadamicResearch"
        },
        {
          key: "Sponsered Research/Project",
          name: "Sponsered Research/Project",
          link: "/app/FacultyDashBoardModify/Research/SponsoredResearch/SponsoredResearch"
        },
        {
          key: "Counselling",
          name: "Counselling",
          link: "/app/FacultyDashBoardModify/Counselling/Counselling"
        },

        // Faculty Dashboard View
        {
          key: "Counselling",
          name: "View",
          title: true,

        },

        {
          key: "Profile",
          name: "Profile",
          link: "/app/Faculty Dashboard View/Profile/Profile"
        },
        {
          key: "Academics",
          name: "Academics",
          link: "/app/Faculty Dashboard View/Academics/Acadamics"
        },
       
        {
          key: "Academic Research",
          name: "Academic Research",
          link: "/app/Faculty Dashboard View/Research/AcadamicResearch/AcadamicResearch"
        },
        {
          key: "Sponsered Research/Project",
          name: "Sponsered Research/Project",
          link: "/app/Faculty Dashboard View/Research/SponsoredResearch/SponsoredResearch"
        },
        {
          key: "Counselling",
          name: "Counselling",
          link: "/app/Faculty Dashboard View/Counselling/Counselling"
        },

        // Faculty Dashboard Authorize
        {
          key: "Academics",
          name: "Authorize",
          title: true,

        },

        {
          key: "Profile",
          name: "Profile",
          link: "/app/Faculty Dashboard Authorize/Profile/Profile"
        },
        {
          key: "Academics",
          name: "Academics",
          link: "/app/Faculty Dashboard Authorize/Academics/Acadamics"
        },
       
        {
          key: "Academic Research",
          name: "Academic Research",
          link: "/app/Faculty Dashboard Authorize/Research/AcadamicResearch/AcadamicResearch"
        },
        {
          key: "Sponsered Research/Project",
          name: "Sponsered Research/Project",
          link: "/app/Faculty Dashboard Authorize/Research/SponsoredResearch/SponsoredResearch"
        },
        {
          key: "Counselling",
          name: " Counselling",
          link: "/app/Faculty Dashboard Authorize/Counselling/Counselling"
        },

      ],
    },


    {
      key: "feedback-forms",
      name: "Feedback forms",
      icon: "ion-ios-book-outline",
      linkParent: "/app/Feedback Forms/Feedback",
    },
  ];
} else if (role === "ROLE_STUDENT") {
  menuArray[0] = [
    {
      key: "student-forms",
      name: "Student forms",
      icon: "ion-ios-book-outline",
      child: [
        {
          key: "New",
          name: "New",
          title: true,
        },
        
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


        //Modify
        {
          key: "Modify",
          name: "Modify",
          title: true,
        },
        
        {
          key: "student-4",
          name: "CMRTECHNICALCAMPUS ",
          link: "/app/Student Forms/Student Modify/CMR TECHNICAL CAMPUS Modify",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "student-1",
          name: "LaptopAvailabilitySurvey ",
          link: "/app/Student Forms/Student Modify/Laptop Availability Survey Modify",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "student-2",
          name: "STUDENTDETAILS ",
          link: "/app/Student Forms/Student Modify/STUDENT DETAILS Modify",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "student-3",
          name: "Student Request Form",
          link: "/app/Student Forms/Student Modify/Student Request Form Modify",
          icon: "ion-ios-list-box-outline",
        },


          //View
          {
            key: "View",
            name: "View",
            title: true,
          },
          {
            key: "student-4",
            name: "CMRTECHNICALCAMPUS",
            link: "/app/Student Forms/Student View/CMR TECHNICAL CAMPUS View",
            icon: "ion-ios-list-box-outline",
          },
          {
            key: "student-1",
            name: "LaptopAvailabilitySurvey",
            link: "/app/Student Forms/Student View/Laptop Availability Survey View",
            icon: "ion-ios-list-box-outline",
          },
          {
            key: "student-2",
            name: "STUDENTDETAILS ",
            link: "/app/Student Forms/Student View/STUDENT DETAILS View",
            icon: "ion-ios-list-box-outline",
          },
          {
            key: "student-3",
            name: "Student Request Form ",
            link: "/app/Student Forms/Student View/Student Request Form View",
            icon: "ion-ios-list-box-outline",
          },
  

        // Authorize
        {
          key: "Authorize",
          name: "Authorize",
          title: true,
        },
        {
          key: "student-4",
          name: "CMRTECHNICALCAMPUS",
          link: "/app/Student Forms/Student Authorize/CMR TECHNICAL CAMPUS Authorize",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "student-1",
          name: "LaptopAvailabilitySurvey",
          link: "/app/Student Forms/Student Authorize/Laptop Availability Survey Authorize",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "student-2",
          name: "STUDENTDETAILS ",
          link: "/app/Student Forms/Student Authorize/STUDENT DETAILS Authorize",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "student-3",
          name: "Student Request Form ",
          link: "/app/Student Forms/Student Authorize/Student Request Form Authorize",
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
          key: "New",
          name: "New",
          title: true,
        },
        {
          key: "intern-1",
          name: "Internship List",
          link: "/app/Intern Forms/Internship List",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "Modify",
          name: "Modify",
          title: true,
        },
        {
          key: "intern-2",
          name: "Internship List Modify",
          link: "/app/Intern Forms/Intern Modify/Internship List Modify",
          icon: "ion-ios-list-box-outline",
        },
        {
          key: "View",
          name: "View",
          title: true,
        },
        {
          key: "intern-3",
          name: "Internship List View",
          link: "/app/Intern Forms/Intern View/Internship List View",
          icon: "ion-ios-list-box-outline",
        },

        {
          key: "Authorize",
          name: "Authorize",
          title: true,
        },
        {
          key: "intern-4",
          name: "Internship List Authorize",
          link: "/app/Intern Forms/Intern Authorize/Internship List Authorize",
          icon: "ion-ios-list-box-outline",
        },
      ],
    },
  ];
} else if (role === "ROLE_DEAN") {
  menuArray[0] = [
    {
      key: "NAACAutonomous",
      name: "Autonomous",
      keyParent: true,
      icon: "ion-ios-list-box-outline",
      child: [
        {
          key: "QIFV",
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
          key: "AutonomousAuthorizeHODScreen",
          name: "Authorize",
          link: "/app/Autonomous/Dean/QIF Authorize Screen",
        },
        {
          key: "IIQA",
          name: "IIQA",
          title: true,
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
        {
          key: "SSR",
          name: "SSRView",
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
        {
          key: "SSR",
          name: "SSR Authorize",
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
          link: "/app/Autonomous/Dean/SSRAuthorize/Evaluation Report Authorize",
        },
      ],
    },
    {
      key: "affiliated",
      keyParent: "affiliated",
      name: "Affiliated",
      icon: "ion-ios-list-box-outline",
      child: [
        {
          key: "QIFAuthorize",
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
          link: "/app/Affiliated/Dean/QIF/Authorize Screen",
        },
        {
          key: "IIQAAuthorize",
          name: "IIQA",
          title: true,
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
        {
          key: "SSRView",
          name: "SSR View",
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
        {
          key: "SSRAuthorize",
          name: "SSR Authorize",
          title: true,
        },
        {
          key: "Executive Summary",
          name: "Executive Summary",
          link: "/app/Affiliated/Dean/SSRAuthorize/Executive Summary",
        },
        {
          key: "profile-of-the-college",
          name: "Profile of the College",
          link: "/app/Affiliated/Dean/SSRAuthorize/Profile Of The College",
        },
        {
          key: "extended-profile",
          name: "Extended Profile of the College",
          link: "/app/Affiliated/Dean/SSRAuthorize/Extended Profile",
        },
        {
          key: "Evaluation-Report",
          name: "Evaluation-Report",
          link: "/app/Affiliated/Dean/SSRAuthorize/Evaluation Report",
        },
      ],
    },
    {
      key: "university",
      keyParent: "university",
      name: "University",
      icon: "ion-ios-list-box-outline",
      child: [
        {
          key: "QIFAuthorize",
          name: "QIF Authorize",
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
          link: "/app/Universities/Authorize HOD/authorize Dean",
        },
        {
          key: "IIQAAuthorize",
          name: "IIQA",
          title: true,
        },
        {
          key: "View",
          name: "View",
          link: "/app/Universities/Authorize HOD/IIQAView",
        },
        {
          key: "Authorize",
          name: "Authorize",
          link: "/app/Universities/Authorize HOD/IIQAAuthorize",
        },
        {
          key: "SSRView",
          name: "SSR View",
          title: true,
        },
        {
          key: "Executive Summary",
          name: "Executive Summary",
          link: "/app/Universities/Authorize HOD/SSRView/Executive Summary",
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
        {
          key: "SSRAuthorize",
          name: "SSR Authorize",
          title: true,
        },
        {
          key: "Executive Summary",
          name: "Executive Summary",
          link: "/app/Universities/Authorize HOD/SSRAuthorize/Executive Summary/ExecutiveSummary",
        },
        {
          key: "profile-of-the-college",
          name: "Profile of the College",
          link: "/app/Universities/Authorize HOD/SSRAuthorize/Profile Of The College/ProfileOfTheCollege",
        },
        {
          key: "extended-profile",
          name: "Extended Profile of the College",
          link: "/app/Universities/Authorize HOD/SSRAuthorize/Extended Profile/ExtendedProfile",
        },
        {
          key: "Evaluation-Report",
          name: "Evaluation-Report",
          link: "/app/Universities/Authorize HOD/SSRAuthorize/EvaluationReport/EvaluationReport",
        },
      ],
    },
    {
      key: "reports",
      keyParent: "reports",
      name: "Reports",
      icon: "ion-ios-list-box-outline",
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
      key: "NAACAutonomous",
      name: "Autonomous",
      keyParent: true,
      icon: "ion-ios-list-box-outline",
      child: [
        {
          key: "QIFV",
          name: "QIF",
          title: true,
        },
        {
          key: "AutonomousPrincipalViewScreen",
          name: "View",
          link: "/app/Autonomous/Authorize Principal/principal View",
        },
        {
          key: "AutonomousAuthorizePrincipalScreen",
          name: "Authorize",
          link: "/app/Autonomous/Authorize Principal/authorize Principal",
        },
        {
          key: "IIQA",
          name: "IIQA",
          title: true,
        },
        {
          key: "View",
          name: "View",
          link: "/app/Autonomous/IIQA/IIQAview",
        },
        {
          key: "Authorize",
          name: "Authorize",
          link: "/app/Autonomous/Principal/IIQA/IIQAAuthorize",
        },
        {
          key: "SSR",
          name: "SSRView",
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
        {
          key: "SSR",
          name: "SSR Authorize",
          title: true,
        },
        {
          key: "Executive Summary",
          name: "Executive Summary",
          link: "/app/Autonomous/Authorize Principal/SSRAuthorize/Executive Summary/ExecutiveSummaryAuthorize",
        },
        {
          key: "profile-of-the-college",
          name: "Profile of the Autonomous College",
          link: "/app/Autonomous/Authorize Principal/SSRAuthorize/Profile Of The College Authorize",
        },
        {
          key: "extended-profile",
          name: "Extended Profile",
          link: "/app/Autonomous/Authorize Principal/SSRAuthorize/Extended Profile/ExtendedProfile",
        },
        {
          key: "Evaluation-Report",
          name: "Evaluation-Report",
          link: "/app/Autonomous/Authorize Principal/SSRAuthorize/EvaluationReport/EvaluationReportAuthorize",
        },
      ],
    },
    {
      key: "affiliated",
      keyParent: "affiliated",
      name: "Affiliated",
      icon: "ion-ios-list-box-outline",
      child: [
        {
          key: "QIFAuthorize",
          name: "QIF",
          title: true,
        },
        // {
        //   key: "AFFILIATEDDEANASSIGN",
        //   name: "Assign",
        //   link: "/app/Affiliated/Authorize HOD/assign Dean",
        // },
        {
          key: "AffiliatedPrincipalViewScreen",
          name: "View",
          link: "/app/Affiliated/Authorize Principal/principal View",
        },
        {
          key: "AffiliatedAuthorizePrincipalScreen",
          name: "Authorize",
          link: "/app/Affiliated/Authorize Principal/authorize Principal",
        },
        {
          key: "IIQAAuthorize",
          name: "IIQA",
          title: true,
        },
        {
          key: "View",
          name: "View",
          link: "/app/Affiliated/IIQA/IIQAview",
        },
        {
          key: "Authorize",
          name: "Authorize",
          link: "/app/Affiliated/Principal/IIQAAuthorize",
        },
        {
          key: "SSRView",
          name: "SSR View",
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
        {
          key: "SSRAuthorize",
          name: "SSR Authorize",
          title: true,
        },
        {
          key: "Executive Summary",
          name: "Executive Summary",
          link: "/app/Affiliated/Principal/SSRAuthorize/Executive Summary",
        },
        {
          key: "profile-of-the-college",
          name: "Profile of the College",
          link: "/app/Affiliated/Principal/SSRAuthorize/Profile Of The College",
        },
        {
          key: "extended-profile",
          name: "Extended Profile of the College",
          link: "/app/Affiliated/Principal/SSRAuthorize/Extended Profile",
        },
        {
          key: "Evaluation-Report",
          name: "Evaluation-Report",
          link: "/app/Affiliated/Principal/SSRAuthorize/Evaluation Report",
        },
      ],
    },
    {
      key: "university",
      keyParent: "university",
      name: "University",
      icon: "ion-ios-list-box-outline",
      child: [
        {
          key: "QIFAuthorize",
          name: "QIF Authorize",
          title: true,
        },
        // {
        //   key: "UNIVERSITYDEANASSIGN",
        //   name: "Assign",
        //   link: "/app/Universities/Authorize HOD/assign Dean",
        // },
        {
          key: "UniversitiesPrincipalViewScreen",
          name: "View",
          link: "/app/Universities/Authorize Principal/principal View",
        },
        {
          key: "UniversitiesAuthorizePrincipalScreen",
          name: "Authorize",
          link: "/app/Universities/Authorize Principal/authorize Principal",
        },
        {
          key: "IIQAAuthorize",
          name: "IIQA",
          title: true,
        },
        {
          key: "View",
          name: "View",
          link: "/app/Universities/Authorize Principal/IIQAView",
        },
        {
          key: "Authorize",
          name: "Authorize",
          link: "/app/Universities/Authorize Principal/IIQAAuthorize",
        },
        {
          key: "SSRView",
          name: "SSR View",
          title: true,
        },
        {
          key: "Executive Summary",
          name: "Executive Summary",
          link: "/app/Universities/Authorize Principal/SSRView/Executive Summary",
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
        {
          key: "SSRAuthorize",
          name: "SSR Authorize",
          title: true,
        },
        {
          key: "Executive Summary",
          name: "Executive Summary",
          link: "/app/Universities/Authorize Principal/SSRAuthorize/Executive Summary/ExecutiveSummary",
        },
        {
          key: "profile-of-the-college",
          name: "Profile of the College",
          link: "/app/Universities/Authorize Principal/SSRAuthorize/Profile Of The College/ProfileOfTheCollege",
        },
        {
          key: "extended-profile",
          name: "Extended Profile of the College",
          link: "/app/Universities/Authorize Principal/SSRAuthorize/Extended Profile/ExtendedProfile",
        },
        {
          key: "Evaluation-Report",
          name: "Evaluation-Report",
          link: "/app/Universities/Authorize Principal/SSRAuthorize/EvaluationReport/EvaluationReport",
        },
      ],
    },
    {
      key: "reports",
      keyParent: "reports",
      name: "Reports",
      icon: "ion-ios-list-box-outline",
      child: [
        {
          key: "historicaldataview",
          name: "Historical Data View",
          link: "/app/Autonomous/Historical Data View",
        },
      ],
    },
  ];
} else if (role === "ROLE_QUALITYADVISOR") {
  menuArray[0] = [
    {
      key: "autonomous",
      name: "Autonomous",
      keyParent: "Autonomous",
      icon: "ion-ios-menu-outline",
      child: [
        {
          key: "QualitativeAdvisorEntry",
          name: "Qualitative Advisor Entry",
          title: true,
        },
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
      keyParent: true,
      name: "Affiliated",
      icon: "ion-ios-menu-outline",
      child: [
        {
          key: "QualitativeAdvisorEntry",
          name: "Qualitative Advisor Entry",
          title: true,
        },
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
          key: "QualitativeAdvisorEntry",
          name: "Qualitative Advisor Entry",
          title: true,
        },
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
