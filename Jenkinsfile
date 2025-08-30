pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Pulling code from GitHub...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
                // Make mvnw executable if not already
                //sh 'chmod +x mvnw'
                // Build the project
                //sh './mvnw clean package -DskipTests'
            }
        }

        stage('Unit Tests') {
            steps {
                echo 'Running unit tests...'
                //sh './mvnw test'
            }
            post {
                always {
                    // Publish test results
                    //junit '**/target/surefire-reports/*.xml'
                    echo "test completed"
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy stage (optional)'
                // Example deploy command, replace with your own
                // sh 'scp target/myapp.jar user@server:/opt/apps/'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
        always {
            echo 'Pipeline finished.'
        }
    }
}
