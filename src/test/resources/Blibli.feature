Feature: BliBli login

  Scenario: Grosir order
    Given user navigates to "https://wwwuatb.gdn-app.com/"
    And entering the username "grocerypayment@gdn-commerce.com"
    And password "admin@123"
    And loging in
    And Verifying OTP
    When moving to fresh BliBli markert
    And select category
    And add product Directly
    And add 3 products in pdp
#    And add the last recommended product
    And checkout the products
    Then Buy the products





