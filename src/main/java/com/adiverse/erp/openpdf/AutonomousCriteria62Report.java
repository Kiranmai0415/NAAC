package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.Criteria6_FieldInfo;
import com.adiverse.erp.model.Criteria6_FileUpload;
import com.adiverse.erp.service.Criteria6Service;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
@Service
public class AutonomousCriteria62Report {
	
	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
	
	@Autowired
	Criteria6Service service6;
	
	
	
	
	
	@Value("${upload.files.path}")
	private String reportGeneratePath;
	
	

	List<Criteria6_FieldInfo> criteria6List = null;
	Criteria6_FieldInfo criteria6Record = null;
	List<Criteria6_FileUpload> criteria6file = null;
	

public String generateReport(Criteria6_FieldInfo criteria6Fieldinfo) throws DocumentException, IOException {
		String reportPath = "";
		Path root = Paths.get(reportGeneratePath);
		Path file = null;
		Date date = new Date();
		try {
			font1.setSize(16);
			font2.setSize(14);
			font3.setSize(12);
			font4.setSize(14);
			font5.setSize(12);

			
			criteria6List = service6.getAllCriteria6Data();
			if (CollectionUtils.isNotEmpty(criteria6List)) {
				criteria6Record = criteria6List.get(0);
				criteria6file = criteria6Record.getCriteria6FileUpload();
			} else {
				criteria6Record = new Criteria6_FieldInfo();
				criteria6file = new ArrayList<>();
			}

			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "AutonomousCriteria6Report-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
		
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
	
			
			
			
			Paragraph paragraph1criteria6 = new Paragraph("Criterion 6 - Governance, Leadership and Management\r\n\r\n", font1);
			paragraph1criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph1criteria6);

			/*
			 * com.lowagie.text.Font fontTitle0 =
			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle0.setSize(12);
			 */



			Paragraph paragraph11criteria6 = new Paragraph("6.2 Strategy Development and Deployment\r\n\r\n\r\n", font2);
			paragraph11criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph11criteria6);
	//create a table 3
			PdfPTable table3criteria6 = new PdfPTable(2);
			table3criteria6.setWidthPercentage(100);
			PdfPTable table31criteria6 = new PdfPTable(1);
			table31criteria6.setWidthPercentage(100);

			PdfPCell cell31criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font3));
			PdfPCell cell32criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
			PdfPCell cell33criteria6 = new PdfPCell(
					new Paragraph("Link for Strategic Plan and deployment documents on the website\r\n\r\n"));
			PdfPCell cell34criteria6 = new PdfPCell(new Paragraph(""));
			PdfPCell cell35criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
			PdfPCell cell36criteria6 = new PdfPCell(new Paragraph(""));
			table3criteria6.addCell(cell31criteria6);
			table3criteria6.addCell(cell32criteria6);
			table3criteria6.addCell(cell33criteria6);
			table31criteria6.addCell(cell34criteria6);

			table3criteria6.addCell(cell35criteria6);
			table3criteria6.addCell(cell36criteria6);

//			PdfPCell cell312 = new PdfPCell(
//					new Paragraph("6.2.1	The institutional Strategic / Perspective plan is effectively deployed\r\n\r\n" + ""
//							+ "" + "Response:"
//							+ (criteria6Fieldinfo != null
//									? criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse621()
//									: ""),
//							font3));
//			table31criteria6.addCell(cell312);

	//table31.addCell("6.2.1	The institutional Strategic / Perspective plan is effectively deployed\r\n\r\n"+" Response:\r\n\r\n");
			table31criteria6.addCell(
					"A progressive institution is always one that has its Perspective Strategic Plan effectively designed, and deployed. Mother Teresa has put in place a feasible Institutional Perspective Strategic Plan and out of which one academic activity -Problem/Project Based Learning (PBL) is presented below as an example:\r\n"
							+ "\r\n" + "\r\n"
							+ "Mother Teresa strongly believes in what Benjamin Franklin has said, �Tell me, I forget; teach me I may remember; involve me, I learn�. Our conviction is that perceivable learning happens only by doing, which is etched for eternity. Since personal experiences are far more interesting, enjoyable and involved, they are long-lasting and of utmost satisfaction. Mother Teresa visualized that Project-Based-Learning is a significant feature of Education 4.0, to make the students get deeply involved in their learning. This significant �learning while doing� is invaluable in providing economically-feasible solutions to imminent societal problems leading to and thereby ensuring environmentally-sustainable development.\r\n"
							+ "\r\n" + "\r\n"
							+ "Keeping this in view, Mother Teresa deputed 16 teachers from various departments to KLE Technological University, Hubli for a period of three days in November 2019 facilitating them towards PBL. Thereafter, Mother Teresa entered into an MoU with the Viswanekathan Group of Institutions, Khalapur, Maharashtra, for training faculty at Mother Teresa on �PBL�.\r\n"
							+ "\r\n" + "\r\n"
							+ "Step I: Introductory workshop on PBL was conducted during January 04-05, 2020. Fifty-five faculty drawn from different departments attended were trained to get sensitized in the identification of problems for a given course. Faculty prepared a problem canvas categorizing different aspects of the identified problem and presented their work.\r\n"
							+ "\r\n"
							+ "Step II: Course level PBL orientation Workshop, was conducted for same faculty during January 24-26, 2020. Aspects of implementation of PBL for a particular course were introduced; faculty of each department identified two courses for PBL implementation, learnt the concept of storyboard for a course. Course-level PBL canvas helped faculty to identify and create a clothes-line model for a particular problem.\r\n"
							+ "\r\n" + "\r\n"
							+ "Subsequently, resource persons interacted with students of first/second/third year, oriented them to adapt PBL into their learning and enabled them to be future ready.\r\n"
							+ "\r\n" + "");
			PdfPCell cell31x = new PdfPCell(
					new Paragraph("Step III: Course Level PBL (CLPBL) implementation" + "" + "", font5));
			table31criteria6.addCell(cell31x);
			table31criteria6.addCell(
					"In continuation to the first two PBL workshops, all departments identified the courses and the respective faculty for implementation of PBL. During March 04-05, 2020, resource persons from Vishwaniketan interacted with our faculty, CLPBL presentations were reviewed, feedbacks were received and incorporated into action plans for implementing the same. Resource persons also reviewed final year projects for business viability through bootcamp, had another interaction with students to orient them towards PBL.");

			PdfPCell cell31y = new PdfPCell(
					new Paragraph("OUTCOME: Tutorial on IEEE HYDCON on PBL and Course level PBL" + "" + "", font5));
			table31criteria6.addCell(cell31y);
			table31criteria6.addCell(
					"The IEEE Hyderabad section organized a conference �Industry 4.0��, with emphasis on PBL as the\r\n"
							+ " \r\n"
							+ "educational approach for students to be industry-ready, conducted tutorial session on PBL for the participants, and our faculty demonstrated our strategically developed CLPBL as a feasible example for implementation, and this was highly appreciated.\r\n"
							+ "\r\n"
							+ "This experience and strategic action plan have rendered Mother Teresa to successfully implement PBL, in eighteen courses across various departments culminating in the development of critical thinking and interpersonal skills in students.\r\n"
							+ "");

			table31criteria6.addCell(table3criteria6);
			table31criteria6.setSpacingAfter(20f);
			document.add(table31criteria6);

	//create table 4
			PdfPTable table4criteria6 = new PdfPTable(2);
			table4criteria6.setWidthPercentage(100);
			PdfPTable table41criteria6 = new PdfPTable(1);
			table41criteria6.setWidthPercentage(100);

			PdfPCell cell41criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
			PdfPCell cell42criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
			PdfPCell cell43criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
			PdfPCell cell44criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() : "")));
			PdfPCell cell45criteria6 = new PdfPCell(new Paragraph("Link to Organogram of the Institution webpage\r\n\r\n\r\n"));
			PdfPCell cell46criteria6 = new PdfPCell(new Paragraph(""));
			PdfPCell cell47criteria6 = new PdfPCell(new Paragraph("Link for additional information"));
			PdfPCell cell48criteria6 = new PdfPCell(new Paragraph(""));
			table4criteria6.addCell(cell41criteria6);
			table4criteria6.addCell(cell42criteria6);
			table4criteria6.addCell(cell43criteria6);
			table4criteria6.addCell(cell44criteria6);
			table4criteria6.addCell(cell45criteria6);
			table4criteria6.addCell(cell46criteria6);
			table4criteria6.addCell(cell47criteria6);
			table4criteria6.addCell(cell48criteria6);
//			PdfPCell cell41x = new PdfPCell(new Paragraph(
//					"6.2.2	The functioning of the institutional bodies is effective and efficient as visible from policies, administrative setup, appointment, service rules and procedures, etc.\r\n"
//							+ "\r\n" + "\r\n" + "Response:"
//							+ (criteria6Fieldinfo != null
//									? criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse622()
//									: ""),
//					font3));
//			table41criteria6.addCell(cell41x);
			table41criteria6.addCell("Mother Teresa�s organogram depicts its organizational structure");
			table41criteria6.addCell(
					"Governing Body, the apex statutory body, monitors the reflection of the institution�s Vision, Mission and quality policy in all activities of the HEI, gives direction to various constituents and monitors its performance.\r\n"
							+ "\r\n" + "\r\n"
							+ "The institution is organized into Academic, Examinations and Administrative units with Principal as Head of the Institution. Other statutory bodies of the college include, Academic Council (AC), Boards of Studies (BoS), and Finance committee, while, non-statutory committees, Planning & Monitoring Board, Library,\r\n"
							+ " \r\n" + "\r\n"
							+ "Examinations, Grievance Redressal, IQAC, Internal compliance committee (Women Protection Cell), Anti- Ragging, and Canteen, constituted as per the norms of the Autonomous status of the college.\r\n\r\n"
							+ "");
			table41criteria6.addCell(
					"Dean, Academic, Prepares Academic Calendar detailing various activities, monitors progress of class work, student counseling/mentoring, directing and supervising student activity programs.\r\n"
							+ "\r\n" + "\r\n"
							+ "The Registrar, along with Dean, Academic and college academic committee assists Principal in administering and leading the college within the policy framework developed by AC.\r\n"
							+ "\r\n" + "\r\n"
							+ "Controller of Examinations coordinates with external examiners, affiliating university officials and with all concerned in the college, ensures smooth conduct of all examinations evaluation and timely declaration of results.\r\n"
							+ "\r\n" + "\r\n"
							+ "Dean, RD&C formulates research and consultancy policies of the institution, processes research and patent proposals submitted by faculty, recommends internal seed money and other assistance for projects, if any, and identifies areas/institutions for collaborative purposes and rendering consultancy services.\r\n"
							+ "\r\n" + "\r\n"
							+ "Dean, Students Affairs facilitates/coordinates student council formation, maintains discipline, supervises anti-ragging committee and arranges to conduct extracurricular activities.\r\n"
							+ "\r\n" + "\r\n"
							+ "Coordinator, Industry Institute Interaction, develops industry linkage, facilitates MoUs.\r\n"
							+ "\r\n" + "\r\n"
							+ "Coordinator, computing services, oversees and facilitates IT infrastructure requirements, arranges for smooth conduct of IT activities of the institution.\r\n"
							+ "\r\n" + "\r\n"
							+ "Coordinator, IQAC, initiates and administers quality initiatives of the college. Arranges conduct of internal/external academic and administrative audit.\r\n"
							+ "\r\n"
							+ "Dean, TPCP, oversees/administers career guidance and development programs facilitating students acquire employability and career progression skills.\r\n"
							+ "\r\n" + "\r\n"
							+ "Coordinator, EDC, conducts entrepreneurial development programs., promoting entrepreneurship.\r\n"
							+ "\r\n" + "\r\n"
							+ "Coordinator, IC, nurtures seed of creativity and innovation, fostering a culture of product development through prototypes, resulting in entrepreneurship through a start-up, inviting and involving venture capitalists.\r\n"
							+ "\r\n" + "\r\n"
							+ "Dean, School of Computer Science and Informatics, oversees smooth functioning of CSE/IT/ CSE (Emerging Areas) departments ensuring optimal utilization of their resources.\r\n"
							+ "Dean, School of Electrical and Communication Engineering, oversees smooth functioning of ECE and EEE departments, ensuring development of quality initiative measures for improving employability of students in core sectors.\r\n"
							+ "\r\n" + "\r\n"
							+ "HoD, administers smooth conduct of academic and administrative activities of the department. In association with senior faculty members promotes scholarly activities of faculty and students.\r\n"
							+ "\r\n" + "\r\n"
							+ "AO, assists Registrar in all administrative activities including operations, maintenance of facilities, safety\r\n"
							+ "and security of all. Also maintains AICTE/UGC/Government correspondence.\r\n" + "\r\n"
							+ "\r\n" + "\r\n"
							+ "Accounts Officer, in association with Registrar, assists Principal in the preparation of budget and maintaining records of all accounts, and facilitating audit of the same.\r\n"
							+ "\r\n" + "\r\n"
							+ "Establishment section, maintains personal files of all employees of the college updates their leave status from time to time\r\n"
							+ "");
			table41criteria6.addCell(table4criteria6);
			table41criteria6.setSpacingAfter(20f);
			document.add(table41criteria6);
	//create table5
			PdfPTable table5criteria6 = new PdfPTable(2);
			table5criteria6.setWidthPercentage(100);
			PdfPTable table51criteria6 = new PdfPTable(1);
			table51criteria6.setWidthPercentage(100);

			PdfPCell cell51criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
			
			PdfPCell cell52criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
			
			PdfPCell cell53criteria6 = new PdfPCell(new Paragraph("Screen shots of user interfaces\r\n\r\n\r\n"));
			PdfPCell cell54criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(3).getCriteria6FilePath() : "")));
			//cell54criteria6.setBackgroundColor(Align:);
			PdfPCell cell55criteria6 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
			PdfPCell cell56criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(4).getCriteria6FilePath() : "")));
			PdfPCell cell57criteria6 = new PdfPCell(new Paragraph("ERP (Enterprise Resource Planning) Document\r\n\r\n\r\n"));
			PdfPCell cell58criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(5).getCriteria6FilePath() : "")));
			PdfPCell cell59criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
			PdfPCell cell60criteria6 = new PdfPCell(new Paragraph(""));
			table5criteria6.addCell(cell51criteria6);
			table5criteria6.addCell(cell52criteria6);
			table5criteria6.addCell(cell53criteria6);
			table5criteria6.addCell(cell54criteria6);
			table5criteria6.addCell(cell55criteria6);
			table5criteria6.addCell(cell56criteria6);
			table5criteria6.addCell(cell57criteria6);
			table5criteria6.addCell(cell58criteria6);
			table5criteria6.addCell(cell59criteria6);
			table5criteria6.addCell(cell60criteria6);
			PdfPCell cell51x = new PdfPCell(
					new Paragraph(
							"6.2.3	Implementation of e-governance in areas of operation\r\n" + "\r\n"
									+ "1.	Administration\r\n" + "2.	Finance and Accounts\r\n"
									+ "3.	Student Admission and Support\r\n" + "4.	Examination\r\n" + "\r\n" + "",
							font3));
			table51criteria6.addCell(cell51x);
			table51criteria6.addCell("Response: A. All of the above");
			table51criteria6.addCell(table5criteria6);
			document.add(table51criteria6);

	
	

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

		

}	



