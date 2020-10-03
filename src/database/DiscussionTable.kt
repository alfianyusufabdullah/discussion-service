package alfianyusufabdullah.discussionservice.database

import org.jetbrains.exposed.sql.Table

object DiscussionTable : Table() {
    val id = integer("id").primaryKey().autoIncrement()
    val parent_id = integer("parent_id")
    val name = varchar("name", 255)
    val comment = varchar("comment", 255)
    val created_at = long("created_at")
}
