# WebSocketEcho

15/02/2016 Version 1.0
--websocket echo 
--messages/keystrokes and their timestamp in JSON format
--is_typing indicator

21/02/2016
--remove the sent-message history of the input box
--automatic reconnection when the websocket is closed (disconnected)
--send every keystroke when typed (along with the is_typing indicator)
--an image is added
--simple layout, including scroll window for the output

28/02/2016
Jetty-websocket (Jetty JSR356) 
--under the directory where pom.xml (namely the main folder of jetty-websocket) is located, run:
    mvn jetty:run
  you may have to download maven (apache-maven-3.3.9-bin.zip if in Windows) first 
  (http://maven.apache.org/download.cgi)
  then set the environment variables
  (Instructions available: http://www.tutorialspoint.com/maven/maven_environment_setup.htm)
  Once this command is through, the server will be built.
--Open ClientWeb.html under \src\main\webpage
  You can try opening two clients at the same time and see the message transmission,
  as well as the is_typing indicator.
  All the sent messages/characters/indicators can be monitored on the server side
