package com.hortonworks.orendainx.trucking.shared.models

import java.sql.Timestamp

/**
  * @author Edgar Orendain <edgar@orendainx.com>
  */
case class TrafficData(eventTime: Timestamp, routeId: Int, congestionLevel: Int) extends TruckingData {

  lazy val toCSV =
    s"${eventTime.getTime}|$routeId|$congestionLevel"
}
