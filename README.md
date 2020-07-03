# BrasilPrev Online Shop EndPoint Test (brasilprev-lojarest)

## About
This project runs a JAX-WS Web Services Endpoints, creating an REST-API.


## System Specs


* Java 1.8
* GIT (https://git-for-windows.github.io/) 
* Eclipse recent version
* MySQL 5.5
* Maven
* TomCat 8.5

## Clone project from Git

Open your gitbash and prompt this command:

```sh
	git clone https://github.com/denis-lbs18/lojarest.git
```

## Project Start-up config.

Select PopulateDataBase.java inside br.com.brasilprev.lojarest.util and run it as a Java Application:


```sh
    Run as > Java Application (Alt + Shift + X, J)
```

This will create all dataBase tables and will provide some data for testing purposes.

Also, its necessary add this project to your Tomcat Server, under "Add and Remove..." option.

## List of all Endpoint methods

### Base URL

- http://localhost:8080/lojarest/lojarest

### Product

- **listAll**: GET Method, return all Products, endpoint under:

	http://localhost:8080/lojarest/lojarest/products/listAll
	
- **list by id**: GET Method, return a single Product, endpoint under:

	http://localhost:8080/lojarest/lojarest/products/list/{id}

- **add**: POST Method, insert a Product into database, endpoint under:

	http://localhost:8080/lojarest/lojarest/products/add
	
- **delete**: DELETE Method, remove a Product, endpoint under:

	http://localhost:8080/lojarest/lojarest/products/{id}
	
### Client

- **listAll**: GET Method, return all Clients, endpoint under:

	http://localhost:8080/lojarest/lojarest/clients/listAll
	
- **list by id**: GET Method, return a single Client, endpoint under:

	http://localhost:8080/lojarest/lojarest/clients/{id}

- **add**: POST Method, insert a Client into database, endpoint under:

	http://localhost:8080/lojarest/lojarest/clients/add
	
- **delete**: DELETE Method, remove a Client, endpoint under:

	http://localhost:8080/lojarest/lojarest/clients/{id}	
	
### Cart

- **listAll**: GET Method, return all carts, endpoint under:

	http://localhost:8080/lojarest/lojarest/carts/listAll
	
- **list by id**: GET Method, return a single cart, endpoint under:

	http://localhost:8080/lojarest/lojarest/carts/{id}

- **add product inside a chart**: POST Method, insert a Product into a cart, endpoint under:

	http://localhost:8080/lojarest/lojarest/cart/{id}/products/{productId}
	
- **delete product inside a chart**: DELETE Method, Remove a product from a cart, endpoint under:

	http://localhost:8080/lojarest/lojarest/cart/{id}/products/{productId}	
	
- **list by id**: GET Method, return a single Client, endpoint under:

	http://localhost:8080/lojarest/lojarest/cart/{id}/products/{productId}
	
- **change product quantity**: PUT Method, Change a product quantity inside a cart, endpoint under:

	http://localhost:8080/lojarest/lojarest/carts/{id}/products/{productId}/quantity