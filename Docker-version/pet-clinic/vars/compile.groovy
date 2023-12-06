def call() {
        
                echo "Compile package ******************************************************************"
                sh 'chmod +x ./mvnw  && ./mvnw package  -Dcheckstyle.skip'
}