pipeline {
    agent any 
    tools {
    	maven 'Maven 3.3.9' 
        jdk 'jdk11' 	
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
	stage ('Build') {
	        steps {
        	    sh 'mvn -Dmaven.test.skip=true clean package spring-boot:repackage' 
            	}
	}
    }
}