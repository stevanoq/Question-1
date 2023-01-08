Feature: logout feature
    @logout
    Scenario: try to login and then logout
        Given open browser
        And navigate to "https://en-gb.facebook.com/reg/"
        And verify if navigated to "https://en-gb.facebook.com/reg/" by get current url
        When user click "Already have an account?" text
        Then verify if login form is appear
        When user input "082247329399" as "phone nummber"
        And user input "jpGj62HjerKfajs" as "password"
        And user click "Log in" button
        When verify if navigated to "https://www.facebook.com/?sk=welcome" by get current url
        And click "Your profile" icon
        Then click "Log Out" option
        When verify if navigated to "https://www.facebook.com/?stype=lo&jlou=AffQkgQgIwu1kNEylinWeTqCBvHF1nqNEa8SDHVTWdTcWf41bYaodhPZYt6-LVgM_7RYTia39sM-sMly-7EXrXWQPjQ8kTjly2tmeQrwU3SOjg&smuh=42368&lh=Ac9x5DcB9sRTbNM-6N4" by get current url
        Then close browser
