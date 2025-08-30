pipeline {
    agent any

    tools {
        // Make sure these are configured in Jenkins → Global Tool Configuration
        jdk 'jdk17'          // Your Java installation name
        maven 'Maven3'       // Your Maven installation name
    }

    environment {
        // Example environment variables
        APP_ENV = 'dev'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Pulling code from GitHub...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building Spring Boot project...'
                // Ensure mvnw is executable
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Unit Tests') {
            steps {
                echo 'Running unit tests...'
                sh './mvnw test'
            }
            post {
                always {
                    // Publish JUnit test results
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Integration Tests') {
            steps {
                echo 'Running integration tests...'
                sh './mvnw verify -DskipUnitTests'
            }
            post {
                always {
                    junit '**/target/failsafe-reports/*.xml'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy stage (optional)'
                // Example deploy command:
                // sh 'scp target/myapp.jar user@server:/opt/apps/'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check console output!'
        }
        always {
            echo 'Pipeline finished.'
        }
    }
}
