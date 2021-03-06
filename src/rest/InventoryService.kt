package alfianyusufabdullah.discussionservice.rest

import alfianyusufabdullah.discussionservice.repository.DatabaseRepository
import alfianyusufabdullah.discussionservice.model.Discussions
import alfianyusufabdullah.discussionservice.model.Response
import io.ktor.application.call
import io.ktor.request.*
import io.ktor.response.respond
import io.ktor.routing.*

fun Route.widget(databaseRepository: DatabaseRepository) {
    route("/discussion") {

        get {
            val parentId = call.request.queryParameters["parentId"]

            val result = databaseRepository.findAllDiscussionWith(parentId)
            if (result.isEmpty()) {
                call.respond(Response("success", "Diskusi kosong"))
            } else {
                call.respond(Response("success", "Discussion count ${result.size}", result))
            }
        }

        post("/publish") {
            val params = call.receiveParameters()
            val type = params["type"] ?: "undefined"
            val comment = params["comment"] ?: "undefined"
            val parentId = params["parentId"] ?: "-"
            val name = params["name"] ?: "Alien"
            val title = params["title"] ?: "QnA"

            val result = when (type) {
                "discussion" -> {
                    val discussions = Discussions(
                        comment = comment,
                        name = name,
                        title = title,
                        createdAt = System.currentTimeMillis()
                    )
                    databaseRepository.publishNewDiscussion(discussions)
                }
                "comment" -> {
                    val discussions = Discussions(
                        comment = comment,
                        parentId = parentId,
                        name = name,
                        createdAt = System.currentTimeMillis()
                    )
                    databaseRepository.publishNewComment(discussions)
                }
                else -> false
            }

            if (result) {
                call.respond(Response("success", "Diskusi baru berhasil ditambahkan"))
            } else {
                call.respond(Response("failed", "Diskusi tidak dapat ditambahkan"))
            }
        }
    }
}