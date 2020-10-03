package alfianyusufabdullah.discussionservice

import alfianyusufabdullah.discussionservice.database.DatabaseConfiguration
import alfianyusufabdullah.discussionservice.repository.DatabaseRepository
import alfianyusufabdullah.discussionservice.database.DiscussionTable
import alfianyusufabdullah.discussionservice.rest.widget
import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.gson.*
import io.ktor.features.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {

    Database.connect(DatabaseConfiguration.hikariConfigDataSource())
    transaction {
        create(DiscussionTable)
    }

    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }

    install(Routing) {
        widget(DatabaseRepository())
    }
}