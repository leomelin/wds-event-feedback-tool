package dto.survey

enum class QuestionType {
    STARS,
    YES_NO,
    OPEN,
    OK
}

open class Question(val type: QuestionType, open val name: String)
