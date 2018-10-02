package controller

import service.handleGetHello
import spark.kotlin.Http

class SurveyController(http: Http) {
    init {
        http.get("/hello") {
            handleGetHello(this)
        }
    }
}