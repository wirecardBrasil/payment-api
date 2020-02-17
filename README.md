# payment-api
This is a sample project used only for recruitment purposes.

### Running Locally
Download the repository to your computer

Open your terminal and run the following command on the project's root folder
```
./mvnw spring-boot:run
```

You should see a success message like this
```
Started PaymentsApiApplication in 5.196 seconds (JVM running for 5.684)
```

### API Operations

* The main operations are:

#### 1: Registering a new Buyer: `POST (http://localhost:9000/buyer)` Please, notice that for insertion purposes, the id is not required, for it is
	auto-incremented in database.
	
```json
{
    "email": "teste@email.com",
    "cpf": "123123123123",
    "nome": "buyer"
}
```

#### 2: Registering a new Client: `POST (http://localhost:9000/client)`
	
```json
{
    "name": "amazon"
}
```

#### 3: Creating a new Payment with CREDIT_CARD option: `POST (http://localhost:9000/payment)`
	
```json	
{
	"amount": "10000.00",
	"paymentMethod":{
		"method": "CREDIT_CARD",
		"creditCard":{
			"brand": "Master",
			"holder":{
				"name": "Bia",
				"birthDate": "28-10-1994",
				"documentNumber": "38129391293"
			},
			"cardNumber": "1111111111111215",
			"expirationDate": "30-04-2018",
			"cvv": "235"
		}
	},
	"buyer":{
		"id": "1"
	},
	"client":{
		"id": "1"
	}
}
```

#### 4: Creating a new Payment with BOLETO option: `POST (http://localhost:9000/payment)`
```json		
{
	"amount": "10000.00",
	"paymentMethod":{
		"method": "BOLETO"
	},
	"buyer":{
		"id": "1"
	},
	"client":{
		"id": "1"
	}
}
```

#### 5: Retrieving information of a payment by its id: `GET (http://localhost:9000/payment/{id})`
	
#### 6: Retrieving information of a buyer by its id: `GET (http://localhost:9000/buyer/{id})`
