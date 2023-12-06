def call(){
        echo "Run Unittest *********************************************************************"
        mavenRun("test -Dcheckstyle.skip")
}
