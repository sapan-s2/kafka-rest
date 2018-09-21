# kafka-rest
Rest API for Kafka producer/consumer

A samle Application for kafka with Springboot


Steps to setup kafka in local 
dowmload  kafka from -https://www.apache.org/dyn/closer.cgi?path=/kafka/2.0.0/kafka_2.11-2.0.0.tgz 
unzip into a local directory
follow below steps -

for linux bin\windows be bin/
start zookeper
bin\windows\zookeeper-server-start.bat config\zookeeper.properties

start kafka
bin\windows\kafka-server-start.bat config\server.properties


to list all the brokers -

bin\windows\kafka-console-producer.bat --broker-list localhost:9092

to read from topic test
bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topics test
