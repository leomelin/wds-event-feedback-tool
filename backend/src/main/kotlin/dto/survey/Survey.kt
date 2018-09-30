package dto.survey


data class Survey(
    val id: String,
    val name: String,
    val description: String,
    val questions: List<Question>,
    val locked: Boolean
)