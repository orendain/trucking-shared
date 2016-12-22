package com.hortonworks.orendainx.trucking.shared.models

/**
  * The supertype for all data models.
  * Extending this type ensures that a data model meets the appropriate requirements and has
  * the necessary apply/unapply/serialize/deserialize/etc. methods that components
  * may need to call to transform and act on the data.
  *
  * @author Edgar Orendain <edgar@orendainx.com>
  */
trait Event extends Serializable {

  /**
    * @return A text representation of the data, in CSV format.
    */
  def toCSV: String
}
