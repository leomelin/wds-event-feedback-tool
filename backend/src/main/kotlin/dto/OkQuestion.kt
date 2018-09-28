package dto

data class OkQuestion(override val name: String): Question(QuestionType.OK, name)
