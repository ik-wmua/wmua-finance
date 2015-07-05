package org.intracer.finance

import java.io.{File, FileOutputStream}
import org.apache.poi.ss.usermodel.{WorkbookFactory, Workbook}
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import play.Play

object XlsTools {

  def newWorkbook: Workbook = new XSSFWorkbook()

  def save(wb: Workbook, name: String) {
    val fileOut = new FileOutputStream(name + ".xlsx")
    wb.write(fileOut)
    fileOut.close()
  }

  lazy val projectRoot = Play.application().path()

  def load(name: String): Workbook = WorkbookFactory.create(new File(projectRoot.getAbsolutePath + "/conf/resources/" + name + ".xlsx"))
  def load(file: File): Workbook = WorkbookFactory.create(file)

}
