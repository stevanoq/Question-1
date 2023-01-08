Feature: login feature
    @login
    Scenario: login with existing account
        Given open browser
        And navigate to "https://en-gb.facebook.com/reg/"
        And verify if navigated to "https://en-gb.facebook.com/reg/" by get current url
        When user click "Already have an account?" text
        Then verify if login form is appear
        When user input "082247329399" as "phone nummber"
        And user input "jpGj62HjerKfajs" as "password"
        And user click "Log in" button
        When verify if navigated to "https://www.facebook.com/?sk=welcome" by get current url
        Then close browser