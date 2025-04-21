Feature: Generate an Order in DemoBlaze.com

	Scenario: Successful order
	Given I access into DemoBlaze webpage
	When I clic in a product
	When I clic on Add to Cart button
	When I clic on Cart menu option
	When I clic on Place Order button
	When I complete the form with my personal information
	Then the order is completed