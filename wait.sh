#!/bin/sh

set -e

echo "Waiting for mysql"
sleep 15
exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
