### URL 
##### https://fostercaredemo-agreeya.com

### Synopsis
  This project is about building a working prototype that would enable Families to Register and Manage their profiles so that they can receive foster placements.
  Apart from Registering their Profiles, prototype functionality would allow registered users to Manage Profiles , Search through Children Residential Facilities         within their zipcode and locate Foster care agencies in their nearby neighbourhood.Registered users can view their private mailbox for communication emails 
  sent or received.The prototype utilizes the publicly exposed HHS API to retrieve information related to the Foster Care Agencies in nearby neighbourhood 
  of the user.

### Technical Approach
+



+
+
### Branches

#####  Master Branch : 
      This branch contains the Final version of the source code , UI designs/HTML, Style Checker guide , Code Conventions reference , 
      project management artifacts. Using the instructions in the INSTALL and DEPLOYMENT SECTION this version of code base can be re-deployed to another machine

#####  Dev Branch : 
      This is the main development branch which includes codebase used to build and deploy to QA server or any other server for testing or demo purposes. 
      Commits to this branch will result in execution of automated build and deployment process. This branch should be reviewed to establish time to time code merges         made by the front end and back end developers.

#####  Local Branch FrontEnd Development : 

#####  Local Branch BackEnd Development : 

### Development Methodology 

##### Agile-SCRUM Model :
   The development of this prototype is carried out using the Agile SCRUM model. Multi disciplinary team comprising 
   PRODUCT OWNER , Scrum Master,Business Analyst, Web Designer,S/W Backend Developer, Fontend Developer, S/W Tester , Configuration Manager
   The whole process is carried out using Agile software development capabilities with iterartive and incremental development through sprints.Product Backlog - User       Stories and Tasks are managed through the REDMINE Project Management and Bug Tracking tool.
   Two dev sprints of 4 days each in duration are executed to cover the development of work items. Prior to the first Sprint a Design phase is executed to 
   cover activitites related to UI Design, Technical Architecture Design, DB Design, Product Backlog Planning , Sprint Scheduling , Test Planning. 
   During this phase, Joint Application Development(JAD) sessions are executed with the usergroup to participate in the design process. Usergroups are involved to         understand their need for this application so as to establish the underlying requirements of this prototype. Discussions during the requirement elicitation             exercise are documented in a Business Requirement Docuement (BRD) with relevant use cases to depict the activity flow for the application users.
   Review sessions are conducted with usergroup to review the accuracy of BRD and freeze the requirements with usergroup and Product Owner approvals.
   As part of these sessions UI designs are reviewed and confirmed for implementation. Daily Standup meetings with entire team to check progress and 
   bottlenecks is conducted , MoM's for each of these standups is captured and shared with all attendees.
   To Demonstrate that usergroups are involved in the design and development process , please check following references from the GITHUB REPOSITORY 

				a. JAD sessions conducted with usergroup to know what is needed , goals of project and create a prioritized list of 
                                   requirements ( Field Backlog Priority) in the Redmine tool. Pl refer files JAD-Session0526 Usergroup.jpg and 
				   and JAD-Session0526 in GITHUB > demo > project-mgmt > docs. Refer CHHS Prototype Development - Story PBI with Priority.pdf 
				   for Prioritization of user stories based in the GITHUB > demo > project-mgmt > docs > Bocklog.
				   The above information is demonstration of adherence to US Digital Services Play book play WHAT PEOPLE NEED.
					
				b. BRD Review - Usergroup suggested to mandatorily add Requirement for Partialling Filling the Family Registration Form with SAVE AND 				   	   EXIT functionality is added to the BRD.
                                   Refer Sec 3.1 for addition of this requirement in GITHUB > demo > project-mgmt > docs > BRD BRD_CHHS-Prototype V1.0.doc 
				   This also demonstrates adherence to US Digital Services Play book play SIMPLE & INTUITIVE where user can save details during Family 				   	   Registration partially and exit to return later to complete the registration process.Also the UI design shows breadcrumbs on every 					   screen informing users of where they are in the website . Registration Process shows to the user
                                   how many steps of total steps are done thus making UI design simple and intuitive for the users.
                                   
				
				c. Sprint 1 Review - UI Refinements suggested by usegroup.A new Story created and added to Backlog in the RedMine tool.
				   Refer Sprint Review document  at GITHUB > demo > project-mgmt > docs > SprintReviews mentioning usergroup feedback for UI 						   Design refinements.
                                   Pl refer GITHUB > demo > project-mgmt > docs > Bocklog >CHHS Prototype Development - Story PBI with Priority.pdf                     		                   for REDMINE Backlog ScreenShot with Story # 167 "UI Design- Refinements" added in the backlog . 
				   This demonstrates that approach followed taking feedback from usergroup during Sprint Reviews leading to subsequent work 
				   item in the backlog

				d. The website also has a mechanism for allowing users to Report any Technical issues they encounter during their interaction on the 					   website. This demonstrates adherence to US Digital Services Play book play DEFAULT TO OPEN . Pl refer footer on the website on each 					  page with a link "REPORT TECHNICAL ISSUES"

				e. Use of Agile scrum model for development process in sprints demonstrates adherence to Agile and iterative development process.
				   Collaboratively working with usergroup to gather feedback , Task boarding , review artifacts , code reviews , sprint reviews , MoM's 				   mockups demonstrates adherence to US Digital Services Play book play USE OF AGILE & ITERATIVE PROCESS.Refer artifacts in the 
				   GITHUB > demo > project-mgmt > docs folder.

				f. Setup a multidisciplinary team with a identified leader as PRODUCT OWNER and single point of authority for the team for approvals 					   and decision, direction for the team . Refer the team members and roles of the scrum team at 
				   GITHUB > demo > project-mgmt > docs > Bocklog >Backlog Details.jpg
                                 
### Development Technology Stack 

#####  Front End Technologies
				a. Responsive UI Designs - Bootstrap/HTML5 Ver 3.3.6  OPEN SOURCE 
				b. UI Development - AngularJS Ver 1.5	OPEN SOURCE
#####  BackEnd Technologies & Tools
				a. Java JDK ver 1.8 OPEN SOURCE
				b. Application Server - Tomacat Ver OPEN SOURCE
				c. Spring Framework 4.2.6  OPEN SOURCE
				d. Web Services - Jersey RESTful Web Services framework REST JAX-RS(Jersey) Ver 2.2.1 OPEN SOURCE
				e. ORM Tool - Hibernate Ver 5 OPEN SOURCE
				f. Build Tool - Maven Ver. OPEN SOURCE
				g. JUnits Ver. OPEN SOURCE
				h. Continous Integration - Build Automation & Deployment - Jenkins Ver  OPEN SOURCE
				i. IDE - Eclipse Ver  OPEN SOURCE
#####  Platform
				a. OS - Ubuntu Ver.  OPEN SOURCE
#####  Database
				a. MYSQL Ver.  OPEN SOURCE
#####  Source Control
				a. GITHUB  https://github.com/agreeya-demorepository/demo.git

#####  BACKLOG & Defect Management Tool
				a. REDMINE Ver 3.2.2	OPEN SOURCE


### Responsive Deisgn 
 UI is designed using the Bootstrap front end framework. UI designs are responsive in nature and hence compatible with multiple mobile devices and platforms like 
 smartphones, tablets on  Android, iOS


### Style Guide & Coding Conventions



### Unit & Automation Testing



### Configuration Management
 

### Continous Integration

  
### User Acceptance Testing (UAT)

  

### Monitoring

  

### INSTALL and DEPLOYMENT INSTRUCTIONS

  

 


