#!/usr/bin/bash

if [ -z "$1" ] || [ -z "$2" ]
then
      echo "Execution with empty args"
      java -jar build/libs/TeladocJavaTest-0.0.1-SNAPSHOT.jar
else
      echo "Execution with no empty args"
      java -jar build/libs/TeladocJavaTest-0.0.1-SNAPSHOT.jar "$1" "$2"
fi