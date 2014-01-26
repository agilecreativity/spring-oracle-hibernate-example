#!/bin/bash
#Note: edit the path to your 'ojdbc.jar' to your environment
mvn install:install-file -Dfile=ojdbc.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar
