# Sample-Spring-Boot-Project
This project contains how to create REST API also it contains swagger config, jdbc config

Also in industry projects are created in this way.

Download or get a Pull of this project, I have used intellij community edition as IDE
Please see the attachment Image for configurations

To run this project you need mention the file location where property files are kept.

### How to run project on linux server in nohup

<br/>Command to put:- nohup java -jar /home/MY-0.0.1-SNAPSHOT.jar --spring.config.location=file:/home/my/csvProperties/ --MYENV=STAGE >> /var/tmp/my.log &

<br/>--spring.config.location :- Here you specify property file path , if inubuilt property file then dont use this command at all.
<br/>--MYENV=STAGE :- To specify env and accordingly load specific property file.
<br/>/home/nw18/my-0.0.1-SNAPSHOT.jar :- path where your jar is located on server.
<br/>>> /var/tmp/my.log  :- This specifies where the log will be generated and log file name.

<br/>Command to check running jar:- 1) ps aux | grep java (this will find all java process running)  2) ps aux | grep my (this will find your specific jar)


