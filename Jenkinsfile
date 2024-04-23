pipeline {
    agent any

    environment {
        // ID credentials, set up in Jenkins for SSH access
        GIT_CREDENTIALS_ID = '009ad602-d253-4848-9fea-3083554a3871'

        BUILD_START_TIME = "${new java.text.SimpleDateFormat('yyyy-MM-dd HH:mm:ss').format(new Date())}"

        TEST_DURATION = '0'
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

                    // Run Maven tests (must configure allure plugin in pom.xml in advance)
                    bat 'mvn clean test'

                    def testEndTime = System.currentTimeMillis()
                    TEST_DURATION = "${(testEndTime - testStartTime) / 1000.0}"
                    echo "Test duration: ${TEST_DURATION} seconds"
                }
            }
        }

        stage('Publish Test Results') {
            steps {
                script {
                    bat """
                        git checkout gh-pages-allure

                        // Generate Allure report
                        mvn allure:report

                        // Clean docs folder and recreate for the knew report
                        if exist docs rmdir /s /q docs
                        mkdir docs

                        // Copying generated Allure report to the docs folder
                        xcopy ".\\target\\site\\allure-maven-plugin\\*" "docs\\" /E /I /Y
                    """

                    // Using withCredentials connect again by ssh to git
                    withCredentials([sshUserPrivateKey(credentialsId: "${env.GIT_CREDENTIALS_ID}", keyFileVariable: 'SSH_KEY')]) {
                        bat """
                            git add docs
                            git config user.email "lukinskaya.alina@gmail.com"
                            git config user.name "Galina Smirnova"
                            git commit -m \"Publishing Allure Test Results - Build: ${env.BUILD_NUMBER}, Started at: ${env.BUILD_START_TIME}, Duration: ${env.TEST_DURATION} ms\"
                            set GIT_SSH_COMMAND=ssh -i %SSH_KEY%
                            git push -u origin gh-pages-allure
                        """
                    }
                }
            }
        }
    }
}