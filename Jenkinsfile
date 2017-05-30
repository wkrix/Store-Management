#!groovy​

pipeline {
 agent none

 environment {
  DOCKER_HUB_ACCESS = credentials('DOCKER_HUB_ACCESS')
 }

 stages {

  stage('Initialize') {
   agent {
    docker {
     image 'maven:3.5.0-jdk-8-alpine'
    }
   }
   steps {
    sh 'mvn clean'
   }
  }

  stage('Build') {
   agent {
    docker {
     image 'maven:3.5.0-jdk-8-alpine'
    }
   }
   steps {
    sh 'mvn package -DskipTests=true -Dmaven.javadoc.skip=true -B -V'
   }
  }

  stage('Test') {
   agent {
    docker {
     image 'maven:3.5.0-jdk-8-alpine'
    }
   }
   steps {
    parallel(JUnit: {
      echo "It's a JUnit test!"
      sh 'mvn test -Dmaven.test.failure.ignore=true'
     },
     Jasmine: {
      echo "It's a Jasmine test!"
     })
   }
  }

  stage('Browser Tests') {
   steps {
    parallel(Firefox: {
      echo "It's a Firefox test!"
     },
     Chrome: {
      echo "It's a Chrome test!"
     },
     Edge: {
      echo "It's an Edge test!"
     },
     Safari: {
      echo "It's a Safari test!"
     }
    )
   }
  }

  stage('Dev deploy') {
   agent any
   steps {
    sh "echo Dev"
   }
  }

  stage('Production deploy') {
   agent any
   steps {
    sh "echo Prod"
    sh "bash docker-deploy.sh -du=${DOCKER_HUB_ACCESS_USR} -dp=${DOCKER_HUB_ACCESS_PSW} -bn=${env.BUILD_NUMBER}"

   }
  }

 }

}

​
