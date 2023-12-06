def call() {


        def mvnHome = tool "maven3"

        def jdkHome = tool "OracleJDK17"

        // Set up environment variables

        def mvnBin = "${mvnHome}/bin"

        def jdkBin = "${jdkHome}/bin"

        env.PATH = "${mvnBin}:${jdkBin}:${env.PATH}"

}