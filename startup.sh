#!/bin/sh

set -e
host="$1"
shift
user="$1"
shift
password="$1"

mvn package

echo "Waiting for mysql"
until mysql -h"$host" -u"$user" -p"$password" mydb < src/sql/alter.sql &> /dev/null
do
        sleep 1
        echo "Waiting for mysql"
done

echo "MySQL is up - executing command"

exec java $JAVA_OPTS -Xmx2048m -XX:PermSize=128m -XX:MaxPermSize=128m -XX:NewRatio=2 -XX:SurvivorRatio=8 -Djava.security.egd=file:/dev/./urandom -jar /usr/src/app/target/teamlab-spring-boot-docker-0.1.0.war