package dto.survey

data class OkQuestion(override val name: String): Question(QuestionType.OK, name)
