# Github RestAPI V3 Version 

Introduction:
This document outlines Test strategy for GitHub V3 version. This also emphasizes on what is being tested at each of the levels i.e. on a integration level, in regression testing and end to end business flows testing
Purpose:
The primary goal of this document is to establish a Test Strategy for the activities that will follow to validate GitHub V3 version for real users. These activities will focus upon identifying the following:
Features to be tested:
Scope:
The scope of testing of GitHub V3 version is as follows:
Testing developed user stories committed for GitHub V3 Version IDEA (IDEA-XXX, IDEA-XXX, IDEA-XXX)
Junits--unit testing will be covered by dev
API testing
front end functionality testing
Testing End to End business flows
Performance testing

Out of Scope:
DB Testing

References
Here are the references on the IDEA level which are planned for GitHub V3 version implementation.
https://developer.github.com/v3/
Environments Required:
Two staging environments STG1 and STG2

Documentation:
Need to write test case for API calls and front functionality testing
Need to write Requirement Traceability matrix

Tools:
API Manual Testing: Postman
API Automation: Jmeter/Soap UI/Rest assured suggestable but used Rest assured with java
Functionality testing: Selenium with java
Framework: PageObjectModel, Maven Structure
Test Reporting: TestNG
Performance Testing: Load Runner/Jmeter suggestable

Features to be tested 
API Testing:
user login/registration testing through API
Authentication testing with oath/secret key
All supported verbs(GET/POST/PUT/DELETE)
User repositories
Events/Commits
emails
followers
pull requests
public versus private users
Authorization
Notifications
Teams info
Error Codes
Functionality Testing:
Registration flows
Login flows
Forgot password
User repositories
Events/Commits
emails
followers
pull requests
public versus private users
Authorization
Notifications
Teams info
cross browser/platform testing
Performance Testing:
Check performance of application with  heavy load of user

Test Strategy    
Test Automation
Can be Automated:
All login/registration and user related info can be automated for both API and Front end
Can be write scripts for performance testing
Cannot be automated:
git  incremental commits
Raising  new  Pull requests after commits
Merge request
Check Previous and present commit code differences
Testing Types
User Story Testing 
QA perform testing as per user stories which were derived from IDEA on STG1
Regression Testing 
QA regression as per user stories which were derived from IDEA on STG2
Production Testing 
QA will perform high level sanity on the Production environment.
Business Flows Testing 
QA team will perform high level testing on STG2 

Concerns
Acceptance criteria should be defined
requirement analysis
Solution design
 band width
 
Risks and Contingencies 
Risks	Contingencies Plan
Not getting stable builds in early days of Sprints	Raise early alarm to give stable builds
Implementation schedule is not as per planned	Track the schedule regularly and give heads-up if there is any deviation.
Third party integration 	Raise an alarm
Requirements freezing	No major changes should be allowed in between testing phase


github user evens api automated use cases			
Test Scenaios
"Verify able to call events api for any user
Ex: GET https://api.github.com/users/user/events"
"Verify response header for events api for any user
Ex:GET https://api.github.com/users/user/events"
"Verify all the fields in response body
Ex:GET https://api.github.com/users/user/events"
"Verify all the fields in public field in response body
Ex:GET https://api.github.com/users/user/events"

# Registration web page automation 
Indeed Registration page use cases(https://www.indeed.co.in/)			
Test Scenaios	
1	Verify whether user able to create account without email
2	Verify whether user able to create account without retype email
3	Verify whether user able to create account without password
4	Verify whether user able to create account without data
5	Verify whether user able to create account with password less than 8 charecters
6	Verify whether user able to create account with invalid email
7	Verify whether user able to create account with email and retype email mistmatch
8	Verify whether user able to create account with valid email,retype email and password