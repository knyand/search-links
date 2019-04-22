FROM jboss/wildfly

MAINTAINER z-ank
 
ADD build/libs/search-links-1.0.war /opt/jboss/wildfly/standalone/deployments/
