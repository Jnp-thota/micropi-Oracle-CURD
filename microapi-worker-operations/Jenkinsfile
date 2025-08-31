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
                // Uncomment when ready:
                // sh 'chmod +x mvnw'
                // sh './mvnw clean package -DskipTests'
            }
        }

        stage('Unit Tests') {
            steps {
                echo 'Running unit tests...'
                // Uncomment when ready:
                // sh './mvnw test'
            }
            post {
                always {
                    echo 'Unit tests completed'
                    // junit '**/target/surefire-reports/*.xml'  // enable when Maven tests run
                }
            }
        }

        stage('Approval') {
            steps {
                // Wait for manual approval before Deploy
                input message: "Build and tests passed. Approve to deploy?", ok: "Approve"
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy stage (manual approval done)'
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
            echo 'Pipeline failed!'
        }
        always {
            echo 'Pipeline finished.'
        }
    }
}
