package com.hortonworks.orendainx.trucking.shared.models

import java.sql.Timestamp

import org.apache.storm.tuple.Tuple

/**
  * The model for a trucking event.  Until the data simulator is integrated with a scheme registry, this is the file
  * that needs to be edited whenever the data the model should output needs changing.
  *
  * @author Edgar Orendain <edgar@orendainx.com>
  */
case class TruckingEvent(eventTime: Timestamp, truckId: Int, driverId: Int, driverName: String,
                         routeId: Int, routeName: String, latitude: String, longitude: String,
                         speed: Int, eventType: String, eventKey: String = "") extends Event {

  lazy val toText =
    s"${eventTime.getTime}|$truckId|$driverId|$driverName|$routeId|$routeName|$latitude|$longitude|$speed|$eventType"

  /*
   * Definition and implicit of type 'Values' that acts as a bridge between Scala and Storm's Java Values
   */
  class Values(val args: Any*)
  implicit def scalaValues2StormValues(v: Values): org.apache.storm.tuple.Values = {
    new org.apache.storm.tuple.Values(v.args.map(_.toString))
  }

  lazy val toStormValues: org.apache.storm.tuple.Values =
    new Values(eventTime, truckId, driverId, driverName, routeId, routeName, latitude, longitude, speed, eventType, eventKey)
}

object TruckingEvent {
  def apply(tuple: Tuple): TruckingEvent =
    TruckingEvent(
      tuple.getValueByField("eventTime").asInstanceOf[Timestamp],
      tuple.getIntegerByField("truckId"),
      tuple.getIntegerByField("driverId"),
      tuple.getStringByField("driverName"),
      tuple.getIntegerByField("routeId"),
      tuple.getStringByField("routeName"),
      tuple.getStringByField("latitude"),
      tuple.getStringByField("longitude"),
      tuple.getIntegerByField("speed"),
      tuple.getStringByField("eventType"),
      tuple.getStringByField("eventKey"))
}