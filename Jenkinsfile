pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git url: 'git@github.com:<username>/<repo>.git', credentialsId: 'github-ssh'
            }
        }
        stage('Build') {
            steps {
                sh 'echo Building...'
                # sh 'mvn clean install'  # your real build command
            }
        }
    }
}
