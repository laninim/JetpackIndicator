package com.laninim.jetpack_indicator.exception

import java.lang.Exception


class MissingTextStyle(override val message : String) : Exception(message) {
}