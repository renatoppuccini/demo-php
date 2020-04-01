pipeline{
    agent{
        node{
            label "php"
        }
    }
     environment{
        APPLICATION_NAME = 'demo-php'
        DEV_PROJECT = "mydemo-php"
        BUILDCFG_NAME = "nodejs-webapp"
    }

    stages{
        stage('Build image'){
            steps{
                script{
                    openshiftBuild(buildConfig: 'demo-php', showBuildLogs: 'true')
                }
            }
        }

        stage('Deploy to DEV'){
            script{
                openshiftDeploy(deploymentConfig: 'demo-php')
            }
        }

        stage('Promote from DEV to QA'){
           
        }

        stage('Wait for approval'){
           
        }

        stage ('Promote from QA to Production'){
            
        }
    }
    
}
