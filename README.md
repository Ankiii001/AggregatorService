# AggregatorService

## Provide a REST endpoint which aggregates the response from user and orders service to give following response

**End point:** GET /orderdetails/1

```json
{
  "orders": [
    {
      "orderId": 1,
      "orderAmount": 250,
      "orderDate": "14-Apr-2020"
    },
    {
      "orderId": 2,
      "orderAmount": 450,
      "orderDate": "15-Apr-2020"
    }
  ],
"userDetails": {
    "name": "John",
    "age": "23",
    "email": "john.doe@google.com"
  }
}
```

