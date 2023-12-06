def call(){
  
                echo "Run Unittest *********************************************************************"
                sh './mvnw test -Dcheckstyle.skip'
}
