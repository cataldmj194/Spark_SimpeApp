Simple Application to count the number of a's and b's in Spark's README.md file
Learning how to use spark, spark-submit and maven. 

NOTES: Learned that Spark or maven does not play well with java9 just yet.
         --would receive Reflective Access & ClassLoader errors
	 --was hard to determine that it was an error with java9 in general

       Learned that you can specify source / target to compile/run 
       with different java versions in pom.xml
         --did not resolve my issue with ReflectiveAccess & ClassLoaders

       Learned that when you use update-java-alternatives to swap between
       the different java versions you have installed on your machine it does
       not update your JAVA_HOME env variable. 
       (even though using java -version prints the change appropriately.)

       Turns out, I had to update my JAVA_HOME environment variable to point
       at java8 or java1.8 rather than java9. I guess either Spark or Maven
       uses what's listed as your JAVA_HOME?

       Resolved the issue anyway

       Learned that spark-submit takes the arguments/options:
         --name "YourAppName"
	 --class "YourClassName"
         --master Spark_URL:port#, yarn_URL:port#, local
         target/YourProject.jar

       You can specify the number of threads per machine with 
       [threadCount] after master_URL. I.E. --master local[4]

       Learned that even if you specify --master local[4] and it resolves to
       local loopback (like I wanted) spark-submit will use an external ip 
       since spark thinks this is wrong. The following message is displayed:

       18/02/15 15:41:06 WARN Utils: Your hostname, Laptop resolves to a loopback address: 127.0.1.1; using xxx.xxx.xxx.xxx instead (on interface "Interface_Name_Here")
       18/02/15 15:41:06 WARN Utils: Set SPARK_LOCAL_IP if you need to bind to another address

       I probably just don't understand why spark needs the external 
       for the time being. Will play around with SPARK_LOCAL_IP.

       Learned that you can specify spark environment variables through
       conf/spark-defaults.conf and you can also specify different
       configurations through the command line, I.E:

       ./bin/spark-submit --name "My app" --master local[4] --conf spark.eventLog.enabled=false
  --conf "spark.executor.extraJavaOptions=-XX:+PrintGCDetails -XX:+PrintGCTimeStamps" myApp.jar 


       So I could have probably resolved my issue through the spark configs
       rather than my env variable stuff. Oh well!

       Learned that I have way more spark dependencies in pom.xml than 
       I actually need, they are left over from attempts at troubleshooting
       the ReflectiveAccess and Classloader errors I received earlier.


