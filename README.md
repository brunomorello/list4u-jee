# list4u-jee
JEE boilerplate

## Archetype jee7

> mvn archetype:generate -DarchetypeGroupId="org.codehaus.mojo.archetypes" -DarchetypeArtifactId="webapp-javaee7" -DarchetypeVersion="1.1" -DgroupId="pt.bmo.list4uee" -DartifactId="list4u-ee" -Dpackage="pt.bmo.list4uee" -DinteractiveMode="false"

PS. check jakarta project for new version

## Maven Build Lifecycle

    1 - validate
    2 - compile
    3 - test
    4 - package
    5 - verify (integration tests)
    6 - install 
    (mvn clean install)

## Deploy Wildfly (jboss)

1 - cd /wildfly-path/bin/
2 - ./standalone.sh 
3 - cp app.war /wildfly-path/standalone\deployments
