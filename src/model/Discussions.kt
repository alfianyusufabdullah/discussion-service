package alfianyusufabdullah.discussionservice.model

data class Discussions(
    val id: String = "-",
    val parentId: String = "-",
    val title: String? = null,
    val name: String = "",
    val comment: String = "",
    val createdAt: Long = 0,
    val reply: Int = 0
)