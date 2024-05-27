def publishTestResults() {
    echo 'Publishing test results to Git'

    // Using withCredentials connect again by ssh to git
    withCredentials([sshUserPrivateKey(credentialsId: "${env.GIT_CREDENTIALS_ID}", keyFileVariable: 'SSH_KEY')]) {
        bat 'git checkout gh-pages-allure'

        bat 'git pull'

        // Generate Allure report
        bat 'mvn allure:report'

        // Clean docs folder and recreate for the knew report
        bat 'if exist docs rmdir /s /q docs'
        bat 'mkdir docs'

        // Copying generated Allure report to the docs folder
        bat 'xcopy ".\\target\\site\\allure-maven-plugin\\*" "docs\\" /E /I /Y'


        bat 'git add docs'
        bat 'git config user.email "lukinskaya.alina@gmail.com"'
        bat 'git config user.name "Galina Smirnova"'

        bat "git commit -m \"Publishing Allure Test Results - Build: ${env.BUILD_NUMBER}, Started at: ${env.BUILD_START_TIME}, Duration: ${env.TEST_DURATION} seconds\""

        bat """
            set GIT_SSH_COMMAND=ssh -i %SSH_KEY%
            git push -u origin gh-pages-allure
        """
    }
}

pipeline {
    agent any

    environment {
        // ID credentials, set up in Jenkins for SSH access
        GIT_CREDENTIALS_ID = '009ad602-d253-4848-9fea-3083554a3871'

        BUILD_START_TIME = "${new java.text.SimpleDateFormat('yyyy-MM-dd HH:mm:ss').format(new Date())}"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git(credentialsId: "${env.GIT_CREDENTIALS_ID}", url: 'git@github.com:Pr1awrence/automation-test-store.git')
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    def testStartTime = System.currentTimeMillis()

                    echo 'Running tests'

                    // Run Maven tests (must configure allure plugin in pom.xml in advance)
                    // Maven marks the build as failed if the tests fail, so I mark it as unstable to allow publishing
                    bat 'mvn -Dmaven.test.failure.ignore=true clean test'

                    def testEndTime = System.currentTimeMillis()
                    env.TEST_DURATION = "${(testEndTime - testStartTime) / 1000.0}"
                    echo "Test duration: ${env.TEST_DURATION} seconds"
                }
            }

            post {
                success {
                    echo 'Tests passed, preparing to push to Git'
                    publishTestResults()
                }

                unstable {
                    echo 'Some tests failed but build successful, preparing to push to Git'
                    publishTestResults()
                }
            }
        }
    }
}