package com.howtographql.scala.sangria

import sangria.execution.deferred.HasId

package object models {
  trait Identifiable {
    val id: Int
  }
  object Identifiable {
    implicit def hasId[T <: Identifiable]: HasId[T, Int] = HasId(_.id)
  }
  case class Link(id: Int, url: String, description: String) extends Identifiable
}