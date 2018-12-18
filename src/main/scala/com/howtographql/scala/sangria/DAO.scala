package com.howtographql.scala.sangria
import DBSchema._
import slick.jdbc.H2Profile.api._

import scala.concurrent.Future

class DAO(db: Database) {
  def allLinks: Future[Seq[models.Link]] = db.run(Links.result)
}