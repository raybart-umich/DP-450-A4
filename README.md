# How to use
## Initial sign in
There are two pre-existing accounts:
* Username: "admin", password: "password123"
    * Admin priveleges, such as modifying the product catalog
* Username: "customer", password: "password123"
    * No admin priveleges

Creating a new account (option 2) will create a non-admin account. Admin accounts can only be created while signed in as an admin.

## Product Catalog
* Initially, there are no products in the catalog, so they must be created by an admin user.
* There are 3 product types supported: "book", "computer", and "shirt". This can of course be expanded easily with the ProductFactory method.
* Products are uniquely identified by their name (case insensitive), so no duplicate names can be created, even of different types.
* A product must be in the catalog to be added to the cart.

## General use
* Once you're signed in and have added some products to the catalog, the system should be intuitive through the command line prompts.
* Admin accounts have all the same properties as non-admins, including managing and checking out a shopping cart.
