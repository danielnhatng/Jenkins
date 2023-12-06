def call() {
    echo "Compile package ******************************************************************"
    mavenRun("package -Dcheckstyle.skip")
}