package streaming.perf.util

import org.apache.spark.streaming.{Time, StreamingContext}
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.InputDStream

class CustomInputDStream[T: ClassManifest](ssc_ : StreamingContext, generatingFunction: Time => RDD[T])
  extends InputDStream[T](ssc_) {

  override def start() { }

  override def stop() { }

  override def compute(validTime: Time): Option[RDD[T]] = Some(generatingFunction(validTime))
}

