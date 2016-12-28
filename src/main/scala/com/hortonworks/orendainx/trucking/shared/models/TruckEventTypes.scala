package com.hortonworks.orendainx.trucking.shared.models

/**
  * @author Edgar Orendain <edgar@orendainx.com>
  */
object TruckEventTypes {
  val Normal = "normal"
  val AllTypes = Seq(Normal, "lane-departure", "unsafe-follow-distance", "unsafe-tail-distance", "speeding")
}
