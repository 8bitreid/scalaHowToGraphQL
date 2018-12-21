package com.howtographql.scala.sangria

import sangria.execution.deferred.HasId
import akka.http.scaladsl.model.DateTime
import sangria.validation.Violation


package object models {
  trait Identifiable {
    val id: Int
  }
  object Identifiable {
    implicit def hasId[T <: Identifiable]: HasId[T, Int] = HasId(_.id)
  }
  case class Link(id: Int, url: String, description: String, createdAt: DateTime) extends Identifiable

  case object DateTimeCoerceViolation extends Violation {
    override def errorMessage: String = "Error during parsing DateTime"
  }
}