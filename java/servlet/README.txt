PROVARE LE SERVLET

1) scaricare tomcat (il pacchetto tar.gz per Linux) dal sito http://tomcat.apache.org/ e scompattarlo nella cartella di lavoro.

2) test: lanciarlo con gli script startup.sh e fermarlo con stop.sh che si trovano in <tomcat>/bin
3) portare dalla cartella <tomcat>/lib servlet-api.jar nella cartella dei sorgenti delle servlet
4) compilare il sorgente con 

javac -cp '.:servlet-api.jar' HelloWorld.java

5) portare il file .class in <tomcat>/webapps/ROOT/WEB-INF creare classes (in caso precedentemente si sarà creata la cartella classes)
6) modificare <tomcat>/webapps/ROOT/WEB-INF/web.xml aggiungendo (prima della chiusura di web-app)

<!-- my first servlet -->
  <servlet>
     <servlet-name>HelloWorld</servlet-name>
     <servlet-class>HelloWorld</servlet-class>
  </servlet>

  <servlet-mapping>
     <servlet-name>HelloWorld</servlet-name>
     <url-pattern>/HelloWorld</url-pattern>
  </servlet-mapping>

</web-app>

7) lanciare tomcat (vedi 2))

