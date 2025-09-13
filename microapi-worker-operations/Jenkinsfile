pipeline {
    agent any

    environment {
        GITHUB_TOKEN = credentials('github-https-token') // Your GitHub PAT
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
                // Mark build pending
                sh """
                curl -H "Authorization: token ${GITHUB_TOKEN}" \
                     -X POST \
                     -d '{"state":"pending","context":"Build"}' \
                     https://api.github.com/repos/Jnp-thota/micropi-Oracle-CURD/statuses/${GIT_COMMIT}
                """
                echo 'Building project...'
                // Example build commands
                // sh 'chmod +x mvnw'
                // sh './mvnw clean package -DskipTests'
                // Mark build success
                sh """
                curl -H "Authorization: token ${GITHUB_TOKEN}" \
                     -X POST \
                     -d '{"state":"success","context":"Build"}' \
                     https://api.github.com/repos/Jnp-thota/micropi-Oracle-CURD/statuses/${GIT_COMMIT}
                """
            }
        }

        stage('Unit Tests') {
            steps {
                // Mark tests pending
                sh """
                curl -H "Authorization: token ${GITHUB_TOKEN}" \
                     -X POST \
                     -d '{"state":"pending","context":"Tests"}' \
                     https://api.github.com/repos/Jnp-thota/micropi-Oracle-CURD/statuses/${GIT_COMMIT}
                """
                echo 'Running unit tests...'
                // sh './mvnw test'
                // Mark tests success
                sh """
                curl -H "Authorization: token ${GITHUB_TOKEN}" \
                     -X POST \
                     -d '{"state":"success","context":"Tests"}' \
                     https://api.github.com/repos/Jnp-thota/micropi-Oracle-CURD/statuses/${GIT_COMMIT}
                """
            }
            post {
                always {
                    echo 'Unit tests completed'
                    // junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Approval') {
            steps {
                input message: "Build and tests passed. Approve to deploy?", ok: "Approve"
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy stage (manual approval done)'
                // sh 'scp target/myapp.jar user@server:/opt/apps/'
            }
        }
    }

    post {
        success {
            sh """
            curl -H "Authorization: token ${GITHUB_TOKEN}" \
                 -X POST \
                 -d '{"state":"success","context":"CI Pipeline"}' \
                 https://api.github.com/repos/Jnp-thota/micropi-Oracle-CURD/statuses/${GIT_COMMIT}
            """
        }
        failure {
            sh """
            curl -H "Authorization: token ${GITHUB_TOKEN}" \
                 -X POST \
                 -d '{"state":"failure","context":"CI Pipeline"}' \
                 https://api.github.com/repos/Jnp-thota/micropi-Oracle-CURD/statuses/${GIT_COMMIT}
            """
        }
    }
}
