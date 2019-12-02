# Sample-Spring-Boot-Project
This project contains how to create REST API also it contains swagger config, jdbc config

Also in industry projects are created in this way.

Download or get a Pull of this project, I have used intellij community edition as IDE
Please see the attachment Image for configurations

To run this project you need mention the file location where property files are kept.

How to run project on linux server in nohup

1.nohup java -jar /home/nw18/techCharts-0.0.1-SNAPSHOT.jar --spring.config.location=file:/home/nw18/csvProperties/ --NW18ENV=STAGE >> /var/tmp/techCharts.log &

--spring.config.location :- Here you specify property file path , if inubuilt property file then dont use this command at all.
--NW18ENV=STAGE :- To specify env and accordingly load specific property file.
/home/nw18/techCharts-0.0.1-SNAPSHOT.jar :- path where your jar is located on server.
>> /var/tmp/techCharts.log  :- This specifies where the log will be generated and log file name.


