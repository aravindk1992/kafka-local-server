import org.apache.avro.Schema
import org.apache.avro.generic.{GenericData, GenericRecord}

object Runner {

  def main(args: Array[String]): Unit = {
    val kafka = KafkaLocalServer(true)
    // Start Mock Kafka Server
    kafka.start()
    kafka.createTopic("abc")

    // Create Mock SchemaRegistry Client
    val schemaRegistryClient = new MockSchemaRegistryClient()

    val schemaStr =
      """
        {"namespace": "twitter.avro","type": "record","name": "in_tw_video_computed","fields": [{"name": "impressionID", "type": ["null","string"]},{"name": "dwhCreationDate", "type": ["null","long"]},{"name": "datetime", "type": ["null","long"]},{"name": "twAdvertiserAccountID", "type": ["null","string"]},{"name": "twCampaignID", "type": ["null","string"]},{"name": "twCreativeID", "type": ["null","string"]},{"name": "twMediaID", "type": ["null","string"]},{"name": "geoPlaceID", "type": ["null","int"]},{"name": "deviceTypeID", "type": ["null","int"]},{"name": "browserID", "type": ["null","int"]},{"name": "browserVersion", "type": ["null","int"]},{"name": "operatingSystemID", "type": ["null","int"]},{"name": "detectedDeliveryType", "type": ["null","int"]},{"name": "deviceDeliveryBlend", "type": ["null","int"]},{"name": "isGIVT", "type": ["null","long"]},{"name": "isSIVT", "type": ["null","long"]},{"name": "userAgent", "type": ["null","string"]},{"name": "isImpression", "type": ["null","int"]},{"name": "isIABVideoViewable", "type": ["null","int"]},{"name": "isAudible", "type": ["null","int"]},{"name": "is100pctVideoViewable", "type": ["null","int"]},{"name": "isTwitterVideoViewable", "type": ["null","int"]},{"name": "isVideoFullScreen", "type": ["null","int"]},{"name": "isCompleted", "type": ["null","int"]},{"name": "isQ1Completed", "type": ["null","int"]},{"name": "isQ2Completed", "type": ["null","int"]},{"name": "isQ3Completed", "type": ["null","int"]},{"name": "isAudibleViewableOnComplete", "type": ["null","int"]},{"name": "isGroupMVideoViewable", "type": ["null","int"]},{"name": "isPMXVideoViewable", "type": ["null","int"]},{"name": "isDataValid", "type": ["null","int"]},{"name": "ip", "type": ["null","string"]} ]}
      """.stripMargin

    val schema: Schema = new Schema.Parser().parse(schemaStr)
    println(schema)








  }
}
