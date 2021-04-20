Feature: Create Short Url

  @unique_urls
  Scenario: Check unique short url

    When I make POST request for the endpoint 'urls'
    Then I see status code 200
    And I see unique short url

  @expirationDate_in_past
  Scenario: Сheck the error using a date in the past for the endpoint 'urls'

    When I make POST request for the endpoint 'urls' with date in the past
    Then I see http status code 400

  @validation_url
  Scenario: Сheck the error using the url without pattern http or https for the endpoint 'urls'

    When I make POST request for the endpoint 'urls' with url without pattern http or https
    Then I see http Bad Request  status code 400
