Feature: Detailed Weather.
  As a user,
  I want to quick look for weather
  so I won't get cold.

  Scenario: Temperature tonight.
    Given opened browser at page yandex.ru
    When I click Погода
    And then click подробно
    Then I see temperature for time "Ночью"

