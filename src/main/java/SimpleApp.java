/**
 * Name: Michael Cataldo
 * Project: Apache Spark - Word Count
 * Date: 2/8/18
 * Context: Learning how to install, run, and use apache spark w/ maven
 */

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import java.util.*;
import java.io.*;

public class SimpleApp {
  public static void main(String[] args){
    String logFile = "/usr/local/spark/spark-2.2.1-bin-hadoop2.7/README.md";
    SparkSession spark = SparkSession.builder().appName("Simple Application").getOrCreate();
    Dataset<String> logData = spark.read().textFile(logFile).cache();
    long numAs = logData.filter(s -> s.contains("a")).count();
    long numBs = logData.filter(s -> s.contains("b")).count();

    System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

    spark.stop();
  }
}
