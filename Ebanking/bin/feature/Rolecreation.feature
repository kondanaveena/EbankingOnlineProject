Feature: Role Creation Functionality
Scenario Outline: Role Creation with Multiple sets of Data

Given Tester Should on Ranford Home Page

When Tester enters "Admin" and "mq@system$" click on Login
Then Tester Click on Role button

When Tester click on New Role and enter "<RoleName>" and "<RoleType>"
When Tester Close the Application

Examples:
          | RoleName | RoleType |
          |Clerkausbrnch|E|
          |managersyd|E|
          |Tellerausbrnch|E|