package com.howtographql.scala.sangria

import sangria.schema.{Field, ListType, ObjectType}
import models._
// #
import sangria.schema._
import sangria.macros.derive._

object GraphQLSchema {
  implicit val LinkType: ObjectType[Unit, Link] = deriveObjectType[Unit, Link]()

  // 2
  val QueryType = ObjectType(
    "Query",
    fields[MyContext, Unit](
      Field("allLinks", ListType(LinkType), resolve = c => c.ctx.dao.allLinks)
    )
  )

  // 3
  val SchemaDefinition = Schema(QueryType)
}