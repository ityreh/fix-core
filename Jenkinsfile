pipeline {
    agent { docker { image 'maven:3.6.2' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}