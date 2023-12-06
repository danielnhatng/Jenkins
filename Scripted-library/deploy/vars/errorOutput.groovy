def call(String error_message) {
    error "Error in stage '${env.error_message}'"
    env.ERROR_MESSAGE = "${env.error_message}"
}

//Unused