package com.hortonworks.orendainx.trucking.shared.models

/**
  * @author Edgar Orendain <edgar@orendainx.com>
  */
object TruckingEventTypes {
  val Normal = "normal"
  val AllTypes = Seq(Normal, "lane-departure", "unsafe-follow-distance", "unsafe-tail-distance", "speeding")
}
