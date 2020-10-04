package alfianyusufabdullah.discussionservice

import alfianyusufabdullah.discussionservice.data.Dummy
import alfianyusufabdullah.discussionservice.database.DatabaseConfiguration
import alfianyusufabdullah.discussionservice.repository.DatabaseRepository
import alfianyusufabdullah.discussionservice.database.DiscussionTable
import alfianyusufabdullah.discussionservice.database.dbQuery
import alfianyusufabdullah.discussionservice.model.Discussions
import alfianyusufabdullah.discussionservice.rest.widget
import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.gson.*
import io.ktor.features.*
import kotlinx.coroutines.launch
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {

    Database.connect(DatabaseConfiguration.hikariConfigDataSource())
    transaction {
        create(DiscussionTable)

        launch {
            val databaseRepository = DatabaseRepository()
            val discussions = Dummy.discussions
            discussions.forEachIndexed { index, value ->
                println("Insert new ${value}, data size ${discussions.size}")

                when (value.keys.elementAt(0)) {
                    "discussion" -> {
                        databaseRepository.publishNewDiscussion(value.values.elementAt(0))
                    }
                    "comment" -> {
                        databaseRepository.publishNewComment(value.values.elementAt(0))
                    }
                }
            }

            discussions.forEach {

            }
        }
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