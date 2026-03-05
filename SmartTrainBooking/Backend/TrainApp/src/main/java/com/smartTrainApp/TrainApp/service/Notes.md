What is Service Layer in Real World?

Service layer:

Contains business logic

Controls transactions

Coordinates between multiple repositories

Enforces validation rules

Handles seat allocation, payment logic, booking constraints

Decides what should happen and in what order

👉 Controllers only handle HTTP
👉 Repositories only talk to DB
👉 Service layer is the decision maker

-------------------------------------------------
JPQL is required here because the search involves joining multiple related entities (Train → TrainStation → Station) and applying a condition on stopOrder (source must come before destination).

Spring Data’s derived query methods only work for simple field-based lookups on a single entity, but they cannot handle complex joins with conditional comparisons like ts1.stopOrder < ts2.stopOrder.