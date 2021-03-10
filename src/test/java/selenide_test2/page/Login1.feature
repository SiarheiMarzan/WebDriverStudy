Feature: LoginFeature
  This feature deals with the login functionality of the application

  Rule:All checks from the main page
    Background:
      Given I am on the login page

    @First
    Scenario: Enter invalid email
#    Given I am on the login page
      When I navigate to login email page
      * I enter the following for Login "testing.testing2003@"
#    And I enter the following for Login "testing.testing2003@"
#    And I click next button
      * I click next button
      Then I should see the next text
        | Введите адрес электронной почты или номер телефона. |

    @Second
    Scenario: Enter non existen Db email
#    Given I am on the login page
      When I navigate to login email page
      And I enter the following for Login "testing.testingnon-existent2003@gmail.com"
      And I click next button
      Then I should see the next text
        | Не удалось найти аккаунт Google |

    @First @Second
    Scenario: Enter validate email
#    Given I am on the login page
      When I navigate to login email page
      And I enter the following for Login "testing.testing2003@gmail.com"
      And I click next button
      Then I should see the text
        | Не удалось войти в аккаунт |


    Scenario: When forgot email
#    Given I am on the login page
      When I navigate to login email page
      And I click forgot email button
      Then I should see text
        | Укажите номер телефона или резервный адрес электронной почты |

    Scenario: Checking logo page
#    Given I am on the login page
      When I click im feeling lucky button
      Then I should see archive link doodles
        | Архив дудлов |

    Scenario: Verify visible element
#    Given I am on the login page
      When I click image button
      Then I should see on google image page text
        | Картинки |
      Then I should see on google image page element search image
      Then I should see on google image page element search voice
      When I click search image button
      Then I should see tab past image url
        | Указать ссылку |
      Then I should see tab upload an image
        | Загрузить файл |

    Scenario: Checking button voice
#    Given I am on the login page
      When I click search voice button
      Then I should see microphone button

    Scenario Outline: email
#    Given I am on the login page
      When I navigate to login email page
      And I enter the following for Login email "<email>"
      And I click next button
      Then I should see the next text email "<controlText>"

      Examples:
        | email                                     | controlText                                         |
        | testing.testing2003@                      | Введите адрес электронной почты или номер телефона. |
        | testing.testingnon-existent2003@gmail.com | Не удалось найти аккаунт Google                     |

