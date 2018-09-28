package dto

data class StarsQuestion(override val name: String): Question(QuestionType.STARS, name)
