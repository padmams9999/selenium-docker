pipeline {
    agent any
    stages {
        stage('Build Jar') {
            agent {
                DOCKER1 {
                    image 'maven:3.9.4-eclipse-temurin-11-alpine'
                    args '-v D:/Selenium Complete Pack/Selenium Docker/jenkins git/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                script {
                	app = docker.build("vinsdocker/selenium-docker")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
			        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
			        	app.push("${BUILD_NUMBER}")
			            app.push("latest")
			        }
                }
            }
        }
    }
}