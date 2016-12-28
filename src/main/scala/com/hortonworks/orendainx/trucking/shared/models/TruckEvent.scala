package com.hortonworks.orendainx.trucking.shared.models

import java.sql.Timestamp

/**
  * The model for a truck event originating from a truck's onboard computer.
  *
  * @author Edgar Orendain <edgar@orendainx.com>
  */
case class TruckEvent(eventTime: Timestamp, truckId: Int, driverId: Int, driverName: String,
                      routeId: Int, routeName: String, latitude: String, longitude: String,
                      speed: Int, eventType: String, eventKey: String = "") extends TruckingData {

  lazy val toCSV =
    s"${eventTime.getTime}|$truckId|$driverId|$driverName|$routeId|$routeName|$latitude|$longitude|$speed|$eventType"
}
