package com.hortonworks.orendainx.trucking.shared.models

import java.sql.Timestamp

/**
  * The model for a trucking event.  Until the data simulator is integrated with a scheme registry, this is the file
  * that needs to be edited whenever the data the model should output needs changing.
  *
  * @author Edgar Orendain <edgar@orendainx.com>
  */
case class TruckingEvent(eventTime: Timestamp, truckId: Int, driverId: Int, driverName: String,
                         routeId: Int, routeName: String, latitude: String, longitude: String,
                         speed: Int, eventType: String, eventKey: String = "") extends Event {

  lazy val toCSV =
    s"${eventTime.getTime}|$truckId|$driverId|$driverName|$routeId|$routeName|$latitude|$longitude|$speed|$eventType"
}
