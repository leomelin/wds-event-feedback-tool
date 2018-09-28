package dto

data class OpenQuestion(override val name: String): Question(QuestionType.OPEN, name)
