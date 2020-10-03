package alfianyusufabdullah.discussionservice.repository

import alfianyusufabdullah.discussionservice.database.DiscussionTable
import alfianyusufabdullah.discussionservice.database.dbQuery
import alfianyusufabdullah.discussionservice.model.Discussions
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.*

class DatabaseRepository {

    suspend fun findAllDiscussionWith(parentId: Int?): MutableList<Discussions> {
        val discussions = mutableListOf<Discussions>()
        dbQuery {
            if (parentId == null){
                DiscussionTable.selectAll().forEach { row ->
                    discussions.add(
                        Discussions(
                            id = row[DiscussionTable.id],
                            parentId = row[DiscussionTable.parent_id],
                            name = row[DiscussionTable.name],
                            comment = row[DiscussionTable.comment],
                            createdAt = row[DiscussionTable.created_at],
                            reply = DiscussionTable.select { DiscussionTable.parent_id eq row[DiscussionTable.id] }.count()
                        )
                    )
                }
            } else {
                DiscussionTable.select { DiscussionTable.parent_id eq parentId }.forEach { row ->
                    discussions.add(
                        Discussions(
                            id = row[DiscussionTable.id],
                            parentId = row[DiscussionTable.parent_id],
                            comment = row[DiscussionTable.comment],
                            name = row[DiscussionTable.name],
                            createdAt = row[DiscussionTable.created_at],
                            reply = DiscussionTable.select { DiscussionTable.parent_id eq row[DiscussionTable.id] }.count()
                        )
                    )
                }
            }
        }
        return discussions
    }

    suspend fun publishNewComment(discussions: Discussions): Boolean {
        return dbQuery {
            try {
                DiscussionTable.insert {
                    it[parent_id] = discussions.parentId
                    it[comment] = discussions.comment
                    it[name] = discussions.name
                    it[created_at] = System.currentTimeMillis()
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
                DiscussionTable.insert {
                    it[parent_id] = 0
                    it[comment] = discussions.comment
                    it[name] = discussions.name
                    it[created_at] = System.currentTimeMillis()
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