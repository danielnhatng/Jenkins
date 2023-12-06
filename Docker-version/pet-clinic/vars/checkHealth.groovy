def call() {
    def response = httpRequest 'http://178.128.94.24:8080'

                    def statusCode = response.status

                    if (statusCode >= 200 && statusCode <= 299) {
                        echo 'Web app is healthy'
                    }
                    else {
                        error "Web app is unhealthy. Status code: $statusCode"
                    }
}