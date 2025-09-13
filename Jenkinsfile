pipeline {
    agent any
    environment {
        ECR_REPO = "061039759557.dkr.ecr.us-east-1.amazonaws.com/microservice-operations"
        IMAGE_TAG = "v1"
        AWS_REGION = "us-east-1"
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Jnp-thota/micropi-Oracle-CURD.git', credentialsId: 'github-https-token'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Docker Build & Push') {
            steps {
                withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-credentials']]) {
                sh """
                   docker build -t $ECR_REPO:$IMAGE_TAG .
                   aws ecr get-login-password --region $AWS_REGION | docker login --username AWS --password-stdin $ECR_REPO
                   docker push $ECR_REPO:$IMAGE_TAG
                """
            }
        }
        }
        stage('Deploy to EKS') {
            steps {
                sh """
                   kubectl apply -f k8s-manifests/deployment.yaml
                   kubectl apply -f k8s-manifests/service.yaml
                   kubectl apply -f k8s-manifests/hpa.yaml
                """
            }
        }
    }
}
