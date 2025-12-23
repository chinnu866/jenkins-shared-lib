def call(String imageName, String credentialsId) {
    withCredentials([usernamePassword(
        credentialsId: credentialsId,
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {
        bat """
        docker build -t %imageName% .
        docker login -u %DOCKER_USER% -p %DOCKER_PASS%
        docker push %imageName%
        """
    }
}
