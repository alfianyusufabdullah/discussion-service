package alfianyusufabdullah.discussionservice.repository

import alfianyusufabdullah.discussionservice.database.DiscussionTable
import alfianyusufabdullah.discussionservice.database.dbQuery
import alfianyusufabdullah.discussionservice.model.Discussions
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.*

class DatabaseRepository {

    suspend fun findAllDiscussionWith(parentId: String?): MutableList<Discussions> {
        val discussions = mutableListOf<Discussions>()
        dbQuery {
            DiscussionTable.select { DiscussionTable.parent_id eq (parentId ?: "-") }.forEach { row ->
                discussions.add(
                    Discussions(
                        id = row[DiscussionTable.id],
                        parentId = row[DiscussionTable.parent_id],
                        title = row[DiscussionTable.title],
                        name = row[DiscussionTable.name],
                        comment = row[DiscussionTable.comment],
                        createdAt = row[DiscussionTable.created_at],
                        reply = DiscussionTable.select { DiscussionTable.parent_id eq row[DiscussionTable.id] }
                            .count()
                    )
                )
            }
        }
        return discussions
    }

    suspend fun publishNewComment(discussions: Discussions): Boolean {
        return dbQuery {
            try {
                val createdAt = discussions.createdAt
                DiscussionTable.insert {
                    it[id] = "${discussions.name.replace(" ", "").toLowerCase()}-${createdAt}"
                    it[parent_id] = discussions.parentId
                    it[comment] = discussions.comment
                    it[name] = discussions.name
                    it[created_at] = createdAt
                }
                true
            } catch (e: JdbcSQLIntegrityConstraintViolationException) {
                println(e.localizedMessage)
                false
            } catch (e: ExposedSQLException) {
                println(e.localizedMessage)
                false
            }
        }
    }

    suspend fun publishNewDiscussion(discussions: Discussions): Boolean {
        return dbQuery {
            try {
                val createdAt = discussions.createdAt
                DiscussionTable.insert {
                    it[id] = "${discussions.name.replace(" ", "").toLowerCase()}-${createdAt}"
                    it[parent_id] = "-"
                    it[comment] = discussions.comment
                    it[name] = discussions.name
                    it[title] = discussions.title
                    it[created_at] = createdAt
                }
                true
            } catch (e: JdbcSQLIntegrityConstraintViolationException) {
                println(e.localizedMessage)
                false
            } catch (e: ExposedSQLException) {
                println(e.localizedMessage)
                false
            }
        }
    }
}