package alfianyusufabdullah.discussionservice.database

import org.jetbrains.exposed.sql.Table

object DiscussionTable : Table() {
    val id = varchar("id", 255).primaryKey()
    val parent_id = varchar("parent_id", 255)
    val title = varchar("title", 255).nullable()
    val name = varchar("name", 255)
    val comment = text("comment")
    val created_at = long("created_at")
}
