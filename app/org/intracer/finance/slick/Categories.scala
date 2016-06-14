package org.intracer.finance.slick

import org.intracer.finance.CategoryF
import slick.driver.H2Driver.api._

class Categories(tag: Tag) extends Table[CategoryF](tag, "CATEGORY") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def code = column[String]("code")
  def name = column[String]("name")

  def codeIndex = index("category_code", code, unique = true)
  def nameIndex = index("category_name", name, unique = true)

  def * = (id.?, code, name) <> (CategoryF.tupled, CategoryF.unapply)
}