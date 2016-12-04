package com.hortonworks.orendainx.trucking.shared.schemes

import java.nio.ByteBuffer
import java.sql.Timestamp

import org.apache.storm.tuple.{Fields, Values}

/**
  * Scheme for parsing geo events.
  *
  * @author Edgar Orendain <edgar@orendainx.com>
  */
object TruckingEventScheme extends DelimitedScheme("\\|") {

  override def deserialize(buffer: ByteBuffer): Values = {

    // TODO: What am I using this for, again?
    //implicit def int2Integer(x: Int): Object = java.lang.Integer.valueOf(x)

    val strings = deserializeString(buffer)

    // Extract data from buffer
    val eventTime = strings(0)
    val truckId = strings(1)
    val driverId = strings(2)
    val driverName = strings(3)
    val routeId = strings(4)
    val routeName = strings(5)
    val latitude = strings(6)
    val longitude = strings(7)
    val speed = strings(8)
    val eventType = strings(9)
    val eventKey = s"$driverId|$truckId|${Long.MaxValue-Timestamp.valueOf(eventTime).getTime}"

    new Values(eventTime, truckId, driverId, driverName, routeId, routeName, latitude, longitude, speed, eventType, eventKey)
  }

  override def getOutputFields: Fields =
    new Fields("eventTime", "truckId", "driverId", "driverName", "routeId", "routeName", "latitude", "longitude", "speed", "eventType", "eventKey")
}
