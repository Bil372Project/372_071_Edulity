[![Build Status](https://travis-ci.org/Bil372Project/372_071_Edulity.svg?branch=master)](https://travis-ci.org/Bil372Project/372_071_Edulity)
# EDULITY

## Setup
>mvn install & mvn compile

This install will try to get an connection from oracle repository
If you don't have correct configuration in your
>[MVN_HOME/conf/settings.xml]

You should add this into servers tag
```
<server>
     <id>maven.oracle.com</id>
     <username><username></username>
     <password><password></password>
     <configuration>
       <basicAuthScope>
         <host>ANY</host>
         <port>ANY</port>
         <realm>OAM 11g</realm>
       </basicAuthScope>
       <httpConfiguration>
         <all>
           <params>
             <property>
               <name>http.protocol.allow-circular-redirects</name>
               <value>%b,true</value>
             </property>
           </params>
         </all>
       </httpConfiguration>
     </configuration>
   </server>
```
And this profile under the profiles tag
```
<profile>
      <id>main</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <repositories>
        <repository>
          <id>maven.oracle.com</id>
          <url>https://maven.oracle.com</url>
          <layout>default</layout>
          <releases>
            <enabled>true</enabled>
          </releases>
        </repository>
      </repositories>
    </profile>
```
Username and password is your oracle account's username and password. You can encrpyt your password by following 
these instructions:

>https://maven.apache.org/guides/mini/guide-encryption.html

## Start Databse
Before starting the server, you should first start your database and create the tables by following these instructions:
>+ Start your oracle database
>+ In the project root directory, copy the content of the "database create command.txt" file then paste and run it in
 a sql console

## Start Sever

After succesfully building the code, you should download Apache-Tomcat server from the link
>https://tomcat.apache.org/download-80.cgi

If you are using some editors like IntelliJ IDEA, you can start server from your editor by adding configuration from 
your editor. For IntelliJ an example is here:
>https://www.mkyong.com/intellij/intellij-idea-run-debug-web-application-on-tomcat/

If you are not using an editor, you should follow these steps:
>+ Copy the .war file from the target directory in the project root
>+ Paste the copied war file to the directory [TOMCAT_HOME/webapps/]
>+ Start your server from command line by ```[TOMCAT_HOME/bin/startup.bat]```
>+ The server is now up. Enter the url ```http://localhost:[port_number]/edulity/index.jsp```
