# micro-emp
It is employee microservice.
It contains:
- Security - permitAll
- Swagger
- Log4j2
- Mongo DB connection
- Controller with /emp end points
  - GetMapping: all employees, employee with an Id {empId}
  - PostMapping
  - PutMapping: /{empId}
  - DeleteMapping: /{empId}
  - PostMapping: File upload with Multipart file /upload
- Custom error response with custom exception.
