### URL 
##### https://fostercaredemo-agreeya.com

### Synopsis
  This project is about building a working prototype that would enable Families to Register and Manage their profiles so that they can receive foster placements.
  Apart from Registering their Profiles, prototype functionality would allow registered users to Manage Profiles , Search through Children Residential Facilities         within their zipcode and locate Foster care agencies in their nearby neighbourhood.Registered users can view their private mailbox for communication emails 
  sent or received.The prototype utilizes the publicly exposed HHS API to retrieve information related to the Foster Care Agencies in nearby neighbourhood 
  of the user.
********************************************************************************************************************************************************************
### Technical Approach
CHHS Prototype development is carried out using the Agile Scrum methodology that provides ability to develop iteratively and incrementally. A multidisciplinary team led by the Product Owner carries out all the activities required to be done in order to successfully deliver a working software system.
The entire requirements elicitation, design and development process involved representatives from usergroups to work in collaboration with the scrum team. Joint Application Development Sessions(JAD) are conducted to understand the need/requirement, deliberate functionality workflows, design screen mockups and document Business Requirement Document (BRD).Basis this BRD,The product backlog -Feature/User stories, Tasks are created with approved backlog priority in the Redmine tool. Daily standups, Task Boarding are done to review the progress of the work items.

#####Technical Approach and General Architectural considerations

#####Service Oriented Architecture 
The prototype is based on the Service oriented architecture (SOA) with the client-tier, business-tier and data-tier layers. The solution is built using AngularJS client-tier and Java backend with Jersey RESTful Web Services framework. 

#####Loose Coupling 
All services are loosely coupled  and autonomous to provide maximum flexibility in development, deployment and usage. Each service communicates with another through a service invocation and need not to be concerned with the service's internal implementation. Also loose coupling will be implemented by layering the architecture in multiple tiers and segregating presentation, application and database layer.

#####Data communication Protocol -Data Exchange Format 
Data exchange between client-tier and business-tier (services) would happen using JSON objects. JSON is a lightweight data interchange format and its use moves the processing of data (returned) on to the browser and hence reduces load on the server. Even though usage of JSON is recommended, we can alternatively just exchange plain XML data also.

#####Audit Trail 
At the backend layer the logging  and tracing is handled at the controller level to capture the details of the entire API calls. The application log table will store these details.

##### Usability 
The user interface must have dynamic structure that does not require complete page refreshes to complete tasks. The System shall provide the ability to efficiently add data – minimizing to the greatest extent possible, the number of keystrokes required to enter all required information. AngularJs library is used for Ajax interactions at client layer and to a build highly interactive rich UI web application.

#####Maintenance and Portability 
The whole application’s business logic and data can be packaged and transferred from one platform to other like local deployment to hosted solution, hosted solution to localized deployment, from one hosted solution to the other with minimum interruption. The application is developed using standard web technologies to provide full accessibility from desktop/laptop and tablet browsers.

#####Security  
As soon the user logs into the application a sessionid is created that is applicable to the specific user and does not time out until the subscriber is inactive for configurable period of time. The handshake between client and API calls is enabled by sharing this sessionid in very subsequent API calls by that client. This secures client access in the application. Additionally, the application can be accessed over the http secure using ssl certificate for secure communication.

#####Sample Request Flow
The client request coming from web browser, Android Tablet/Smartphone will hit the Business-tier which is composed of java backend services (REST - WS). The java backend services would in turn fetch the data and response back relevant data to the presentation layer. Data exchange between client and/or business services happens using JSON objects.
The prototype development follows standards of Java code conventions and checkstyle guides as prescribed by AgreeYa Solutions Design team. This enforces greater consistency in the code that makes it easier to develop and maintain. Integrating these guidelines with IDE facilitates clean, consistent code pattern and reduces build time issues.

#####Prototype Screen Workflows

1.	User enters the URL , https://fostercaredemo-agreeya.com in the web browser or smartphone
2.	User lands on the Home page from where a new user can initiate creation of  a Family profile by clicking on the Family Registration link.
3.	Family Registration is a step by step process involving fulfillment of Eligibility Criteria upon doing so user is directed sequentially to Account Details, 		Personal Information, Family Narratives & Preferences, License & Agency Details tabs. Upon successfully entering relevant information user can Submit the 		Profile details which are saved into the database. User receives acknowledgement for completing the registration process which is under review till approved.
	During the family registration process user can partially fill the form, save and exit from the application to return later to continue filling the form by 		login to the system and subsequently clicking on the Manage Profiles.
4.	An existing user (with login credentials) can login to the application by clicking the Login link on the Home page.
5.	An existing user can click on the Manage profiles link to update their approved profiles details anytime at a later stage.
6.	An existing user can search through the Children Residential Facilities within a given zip. Upon entering a zip code the application communicates with the HHS 		API to fetch data for all the facilities (Adoption Agency, Foster Family Agency and Foster Family Sub-Agency) within the entered zipcode and displays it in a 		grid on the screen.
7.	An existing user can search through the Foster Care Agencies in their nearby neighborhood. Upon entering a radius limit of users current geo location, the 		application communicates with the HHS API to fetch data for the facilities with Facility type Foster Family Agency within the given coordinates range. The 		details of Foster Care Agencies are displayed in a grid on the screen.
8.	An existing user can view a Private mailbox.
9.	A logged in User can log out by clicking the logout link

The Prototype testing involved execution of automated Unit test cases using JUnits. Additionally, automation system test case suite is build to test the entire application. During sprint reviews the usergroup are involved to gather feedback around usability and accepted refinements are added as new backlog work items. User feedbacks are ultimate to successful release of the application.
Automated unit test cases and system test cases are integrated with the build and deployment process executed using the Jenkins Continuous integration tool. Successful builds(.war files) are deployed automatically to a target server. An automated smoke test case is executed to confirm the successful working of the application.

********************************************************************************************************************************************************************
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
   PRODUCT OWNER , Scrum Master,Business Analyst, Web Designer,S/W Backend Developer, Frontend Developer, S/W Tester , Configuration Manager
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
				b. Application Server - Tomacat Ver 7.0.69 OPEN SOURCE
				c. Spring Framework Release 4.2.6  OPEN SOURCE
				d. Web Services - Jersey RESTful Web Services framework REST JAX-RS(Jersey) Ver 1.19 OPEN SOURCE
				e. ORM Tool - Hibernate Ver 5.0.3 FINAL OPEN SOURCE
				f. Build Tool - Maven Ver.3 OPEN SOURCE
				g. JUnits Ver. 4.12 OPEN SOURCE
				h. Continous Integration - Build Automation & Deployment - Jenkins Ver 1.65 OPEN SOURCE
				i. IDE - Eclipse MARS OPEN SOURCE
#####  Platform
				a. OS - Ubuntu Ver.  OPEN SOURCE
#####  Database
				a. MYSQL Ver.  OPEN SOURCE
#####  Source Control
				a. GITHUB  https://github.com/agreeya-demorepository/demo.git

#####  BACKLOG & Defect Management Tool
				a. REDMINE Ver 3.2.2	OPEN SOURCE


### Responsive Design 
 UI is designed using the Bootstrap front end framework. UI designs are responsive in nature and hence compatible with multiple mobile devices and platforms like 
 smartphones, tablets on  Android, iOS
This demonstrates the screens to be accessible from multiple devices.


### Style Guide & Coding Conventions
As part of coding conventions and stylechecks we have used a set of standard guidelines so as to have consistency in coding approach during 
the course of development of this prototype.File stylecheck.xml provides the list of stylechecks used and PDM is used for following coding conventions and standards for development of Java backend.
This demonstrates adherence to the use of a Style Guide during the prototype development process.


### Unit & Automation Testing
Junit based units test cases are developed as part of the code . These are executed by the developer as part of the development activity . JUnits are exeucted automatically during the Build process.
There are two ways in which System Testing for the application is done. Manual test case execution and automation test case suite is created 
to run the test case automatically using a script. The results of the automation test cases are published in a file .
Pl refer the GITHUB folder 

Pl refer GITHUB folder for Automation test cases scripts 
This demonstrates the adherence to the US Digital Services playbook play AUTOMATION TESTING AND DEPLOYMENTS

### Configuration Management
 

### Continous Integration & Deployment
During the course of development of this prototype , we have followed automated build and deployment process using the Jenkins Continous Integration tool.
Developers work in their local branch(local-branch) on GITHUB and whenever they are done with their workitems, they can commit their changes to Dev branch
( Dev-branch). Jenkins CI tool monitors the changes done on the GITHUB repository and perfoms following steps in a sequence
				
		1. Validates the Checkstyle per checkstyle guide . Checktyle.xml contains some of the checkstyles we used during development of backend java code
		2. Builds and runs the Junit based Unit and Integrations test Cases
		3. On successfull build, assigns a build ID to the version of the code that is compiled
		4. A notification for successful build is sent to the team .
		5. Automatically deploys the application ( .war file) in a different server using the Deploy to Container plugin of the Jenkins tool
		6. If the Build fails due to violation of checkstyle, Unit Test failure , compilation error due to some dependencies a notification of build failure is 		   sent to the team , team needs to fix the the issue and initiate rebuild.

Pl refer GITHUB folder for Builds and their results published.
This demonstrates during the prototype development process the use of a setup  that provides continous integration framework.


  
### User Acceptance Testing (UAT)
Post the system test , a User Acceptance Test with usergroup is conducted to validate usability and system functionality. Users 
  

### Continous Monitoring

  

### INSTALL and DEPLOYMENT INSTRUCTIONS

  

 


