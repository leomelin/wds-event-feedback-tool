package dto

data class YesNoQuestion(
    override val name: String,
    val ifYesQuestions: List<Question> = emptyList(),
    val ifNoQuestions: List<Question> = emptyList()
) : Question(QuestionType.YES_NO, name)
