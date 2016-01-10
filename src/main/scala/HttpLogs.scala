import org.apache.hadoop.io.NullWritable

import org.apache.spark._
import org.apache.spark.SparkContext._

import org.apache.hadoop.mapred.lib.MultipleTextOutputFormat

class RDDMultipleTextOutputFormat extends MultipleTextOutputFormat[Any, Any] {
  override def generateActualKey(key: Any, value: Any): Any = 
    NullWritable.get()

  override def generateFileNameForKeyValue(key: Any, value: Any, name: String): String = 
    key.asInstanceOf[String]
}

object HttpLogs {
	def main(args: Array[String]) {
		val conf = new SparkConf().setAppName("HttpLogs")
		val sc = new SparkContext(conf)

		val input = sc.textFile("httpBalanced.txt")
		val uuidRegEx = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}".r

		input.map(l => (uuidRegEx.findFirstIn(l).get, l))
		.partitionBy(new HashPartitioner(1))
		.saveAsHadoopFile("OutputLogs", classOf[String], classOf[String],
		classOf[RDDMultipleTextOutputFormat])
	}
}
