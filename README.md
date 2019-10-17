fixT - Tools for the FIX protocol
=================================

To build this project use

    mvn install

To run this project from within Maven use

    mvn exec:java

To run this project with enabled JMX run it with the command line options

    -Dorg.apache.camel.jmx.createRmiConnector=true -Dorg.apache.camel.jmx.mbeanObjectDomainName=org.apache.camel -Dorg.apache.camel.jmx.rmiConnector.registryPort=1099 -Dorg.apache.camel.jmx.serviceUrlPath=camel

then view it via **jconsole** and connect to

    service:jmx:rmi:///jndi/rmi://localhost:1099/camel

