pipeline {
    agent any

    stages {
        stage('pull code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: '3793f208-86ab-4b59-894b-34dba0d21053', url: 'git@github.com:wwg2008123/web-demo01.git']]])
            }
        }
        stage('build project') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('publish project') {
            steps {
               sshPublisher(publishers: [sshPublisherDesc(configName: '132_pwd', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/web-demo01/', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'target/*.jar')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }
    }
    post {
      always {
        emailext {
            body: '${FILE,path="email.html"}',
            subject: '构建通知: $PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!',
            to: 'wwg2008123@163.com'
        }
      }
    }
}
