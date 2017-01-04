package com.hortonworks.orendainx.trucking.shared.models

import java.sql.Timestamp

/**
  * @author Edgar Orendain <edgar@orendainx.com>
  */
case class TrafficData(eventTime: Timestamp, routeId: Int, congestionLevel: Int) extends TruckingData {

  val name = "TrafficData"

  lazy val toCSV =
    s"${eventTime.getTime}|$routeId|$congestionLevel"
}
