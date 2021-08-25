# UIFramework
This is a framework which supports Web UI Automation.<br>
## Tech Stack 
- Programming Language - Java <br>
- Testing Lib - Selenium <br>
- Testing F/W - TestNg <br>
- Reporting - Extent Report <br>
- Build Tool - Maven <br>
## Features - 
This framework is something that I am currently developing and is in progress.<br>
1. I have tried to incorporate my learning so far and tried to implement the automation best practices in a nutshell. <br>
2. I have tried to consider the <b>SOLID</b> principles.<br>
3. I have implemented Various <b>design patterns</b> like (POM, Driver Factory, Fluent, Singleton ) in this framework.<br>
4. I have considered the possibility of adding new features which would not impact the current framework.For example - Currently, the Framework supports Extent Reports, In the near future, we might need support for other reports as well like allure reports, custom reports, etc.So One just needs to add a separate class for such implementations and without impacting the entire framework we can easily provide an option to switch between reports.Similarly, I have done for supporting various browsers.<br>
5. This framework also has support to <b>run tests in parallel</b> and also run tests in <b>selenium grid using docker.</b><br>
6. I have also added a provision that after every code change, docker images will be created and pushed to the docker hub.<br>
7. Implemented static blocks to read properties.<br><br>
## Coming Next - 
1. Complete CI/CD implementation using Jenkins.<br>
2. Support for Cloud Service providers like Browser stack, Sauce Labs.<br>
3. Integrating Image comparisons using Applitools.<br>
4. Integrating ReportPortal.io for analyzing execution trends.<br>
5. Integration with API consumption so as to prepare proper testing states which will reduce Flakiness and Test cycle time will be improved.<br>
6. Integration to databases.<br>
7. Proper Java Docs.
