pipeline {
    agent any

    environment {
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-21"   // adjust path to your JDK
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'resara', url: 'https://github.com/Resara/cicdproject'
            }
        }

        stage('Build & Test') {
            steps {
                dir('myservice') {
                   bat '../mvnw.cmd clean test'
                }
            }
            post {
              always {
                 junit 'myservice/target/surefire-reports/*.xml'
              }
            }
        }

        stage('Package') {
            steps {
                dir('myservice') {
                    bat '../mvnw.cmd package -DskipTests'
                }
            }
        }

        stage('Unit Tests') {
            steps {
                dir('myservice') {
                    bat '../mvnw.cmd test'
                }
            }
            post {
                always {
                    junit 'myservice/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Docker Build') {
                    steps {
                        dir('myservice') {
                            bat "docker build -t ${env.DOCKER_HUB_USER}/myservice:latest ."
                        }
                    }
                }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    bat "echo %PASS% | docker login -u %USER% --password-stdin"
                    bat "docker push %USER%/myservice:latest"
                }
            }
        }


    }


    post {
        success {
            echo '✅ Build completed successfully!'
        }
        failure {
            echo '❌ Build failed!'
        }
    }
}

// Webhook trigger test
