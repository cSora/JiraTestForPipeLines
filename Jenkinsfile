pipeline {
    agent any
     parameters {
                 string(name: 'browser', defaultValue: 'chrome', description: '')
                 string(name: 'baseUrl', defaultValue: 'https://jira-auto.codecool.metastage.net', description: '')
                 string(name: 'timeout', defaultValue: '30', description: '')
                 }

    stages {
        stage('Build') {
                    agent any
                    steps {
                        echo 'Building...'
                        sh "java -version"
                        cleanWs()
                        }
                    }
        stage('Test Stage') {
            parallel(){
                stage('Chrome tests'){
                    steps {
                        echo 'Chrome tests'
                        withCredentials([usernamePassword(credentialsId: 'a91b8324-f5cf-4629-821e-42ccbcd06214', passwordVariable: 'password', usernameVariable: 'username'), usernamePassword(credentialsId: '3a6c0e30-70a3-44be-b0f4-518fd3d15e3a', passwordVariable: 'gridPassword', usernameVariable: 'gridUser')]) {
                        sh "mvn -Dpassword=${password} -Dusername=${username} '-Duser=Auto Tester 11' -Dbrowser=${params.browser} -DbaseUrl=${params.baseUrl} -Dtimeout=${timeout} -DgridUser=${gridUser} -DgridPassword=${gridPassword} -Dtest=SmokeTest test"

                       }
                    }
                    post {
                                    success {
                                        junit 'target/surefire-reports/**/*.xml'
                                    }
                                    always {
                                        archiveArtifacts artifacts: '**/properties.txt'
                                    }
                                }
                }
                stage('Firefox tests'){
                    steps {
                        echo 'Firefox tests'
                        withCredentials([usernamePassword(credentialsId: 'a91b8324-f5cf-4629-821e-42ccbcd06214', passwordVariable: 'password', usernameVariable: 'username'), usernamePassword(credentialsId: '3a6c0e30-70a3-44be-b0f4-518fd3d15e3a', passwordVariable: 'gridPassword', usernameVariable: 'gridUser')]) {
                        sh "mvn -Dpassword=${password} -Dusername=${username} '-Duser=Auto Tester 11' -Dbrowser=${params.browser} -DbaseUrl=${params.baseUrl} -Dtimeout=${timeout} -DgridUser=${gridUser} -DgridPassword=${gridPassword} -Dtest=SmokeTest test"
                        }
                    }
                    post {
                                             success {
                                                 junit 'target/surefire-reports/**/*.xml'
                                             }
                                             always {
                                                 archiveArtifacts artifacts: '**/properties.txt'
                                             }
                                         }
                         }
        stage('Third Stage') {
            steps {
                echo 'Clean workspace after'
                cleanWs()
            }
        }
    }
}
