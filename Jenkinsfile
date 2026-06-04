node {
    stage('1 - Get code') { // for display purposes
        // Get some code from a GitHub repository
        git branch: 'main', url: 'https://github.com/thanhhang8798/Automation-Framework'

        ansiColor('xterm') {}
        timestamps {}
    }
    stage('2 - Compiler') {
        // Run the build. You must have Maven installed.
        bat 'mvn clean'
    }
    stage('3 - Run test') {
        catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
        bat """
        mvn test ^
         -Dbrowser=${params.BROWSER}
        """
        }
    }
    stage('4 - Public report') {
        allure commandline: 'AllureReport', includeProperties: false, jdk: '', resultPolicy: 'LEAVE_AS_IS', results: [[path: 'allure-results']]
    }
}
