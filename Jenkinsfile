pipeline {
    agent any
     parameters {
                 string(name: 'browser', defaultValue: 'chrome', description: '')
                 string(name: 'baseUrl', defaultValue: 'https://jira-auto.codecool.metastage.net/', description: '')
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
                        withCredentials([
                        usernamePassword(credentialsId: 'a91b8324-f5cf-4629-821e-42ccbcd06214', passwordVariable: 'password', usernameVariable: 'username'),
                        usernamePassword(credentialsId: '4307809c-ede1-4acd-b73d-7d4764e62625', passwordVariable: 'gridPassword', usernameVariable: 'gridUser')
                        ]) {
                        sh "mvn -Dpassword=${password} -Dusername=${username} '-Duser=Auto Tester 11' -Dbrowser=${params.browser} -DbaseUrl = ${params.baseUrl} -DgridUser = ${gridUser} -DgridPassword = ${gridPassword} test"
                        }
                    }
                }
                stage('Firefox tests'){
                    steps {
                        echo 'Firefox tests'

                    }
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
