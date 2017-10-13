#!/bin/sh

set -e
host="$1"
shift
user="$1"
shift
password="$1"


echo "Waiting for mysql"
until mysql -h"$host" -u"$user" -p"$password" mydb < mydb.sql &> /dev/null
do
        sleep 1
        echo "Waiting for mysql"
done

echo "MySQL is up - executing command"

exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
