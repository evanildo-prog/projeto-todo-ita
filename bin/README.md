

### Running
Requirements: 
* docker installed
* port 27017 open 

Requirements: docker installedRun the script `start.sh` to start up a local mongodb container with 2 users.:
    * ID: 1 - normal user
    * ID: 2 - super user

--- 

### Request examples

GET
`curl http://localhost:8080/todo?userId=1` - fetches todos for that specific user id  

POST
```
curl --location --request POST 'http://localhost:8080/todo' \
--header 'Content-Type: application/json' \
--data-raw '{
    "summary": "Estudos java",
    "description": "nildao precisa estudar java",
    "userId": "1"
}
'
```

DELETE
```
curl --location --request DELETE 'http://localhost:8080/todo/853d549a-a2c9-4ae8-9943-647b7353673b' \
--header 'Cookie: JSESSIONID=E838C74D98637AB442E84680E77665E9'
```

PUT
```
curl --location --request PUT 'http://localhost:8080/todo/fa2e91eb-7c88-4a2d-96b4-c1afbabd1505' \
--header 'Content-Type: application/json' \
--data-raw '{
    "summary": "Estudos Node",
    "description": "Evanildo precisa estudar node",
    "pending": false
}'
```