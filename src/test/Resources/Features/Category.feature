
Feature: Categories
  @category
  Scenario Outline:  User can navigate to current category page
  So that user can use all products features from categories
    Given user is on homepage
    When use click on "<category>" link from the top manu
    Then user should able to navegate to "<related category page>" successfull
    Examples:
      | category | related category page |
      | Computers | https://demo.nopcommerce.com/computers|
      |Electronics|https://demo.nopcommerce.com/electronics|
      | Apparel |https://demo.nopcommerce.com/apparel|
      | Digital downloads | https://demo.nopcommerce.com/digital-downloads|