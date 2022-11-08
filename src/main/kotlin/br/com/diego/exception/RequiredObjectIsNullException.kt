package br.com.diego.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.Exception

@ResponseStatus(HttpStatus.BAD_REQUEST)
class RequiredObjectIsNullException : RuntimeException {
    constructor() : super("It is not allowed to persist a null object")
    constructor(exception:  String?) : super(exception)
}