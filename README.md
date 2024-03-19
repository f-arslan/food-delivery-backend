# Food Delivery Backend

## Base URL

[https://espresso-food-delivery-backend-cc3e106e2d34.herokuapp.com/](https://espresso-food-delivery-backend-cc3e106e2d34.herokuapp.com/)

## DTOs

For information on the Data Transfer Objects (DTOs) used in the requests and responses, [check out the DTOs here](/src/main/kotlin/com/example/dto).

## User API Endpoints

### Register User
- **POST** `/register`
  - Description: Registers a new user with the provided details.
  - Request Body: `UserRegisterDto` (Object) - Data Transfer Object containing user registration details.
  - Responses:
    - `201 Created` if registration is successful.
    - `400 Bad Request` with error message if registration fails.

### User Login
- **POST** `/login`
  - Description: Authenticates a user and returns a user identifier upon successful login.
  - Request Body: `UserLoginDto` (Object) - Data Transfer Object containing user login credentials.
  - Responses:
    - `200 OK` with user identifier if login is successful.
    - `401 Unauthorized` with error message if login fails.

### Get User Profile
- **GET** `/profile/{userId}`
  - Description: Retrieves the profile details of a specific user.
  - Path Parameters: `userId` (UUID) - The unique identifier of the user.
  - Responses:
    - `200 OK` with user profile details if found.
    - `404 Not Found` with error message if user profile is not found.

### Get User Profile Flow
- **GET** `/profile/{userId}/flow`
  - Description: Retrieves a flow of profile details for a specific user. This is typically used for real-time updates.
  - Path Parameters: `userId` (UUID) - The unique identifier of the user.
  - Responses:
    - `200 OK` with a flow of user profile details if found.
    - `404 Not Found` with error message if user profile is not found.

### Update User Location
- **POST** `/profile/{userId}/location`
  - Description: Updates the location details for a specific user's profile.
  - Path Parameters: `userId` (UUID) - The unique identifier of the user.
  - Request Body: `UserUpdateLocationDto` (Object) - Data Transfer Object containing new location details.
  - Responses:
    - `200 OK` if the location is successfully updated.
    - `404 Not Found` with error message if the user profile is not found or update fails.

## Order API Endpoints

### Add Item to Order
- **POST** `/orders/{userId}/items`
    - Adds a food item to the user's order.
    - **Path**: `userId` (UUID as string)
    - **Body**: `FoodDto` (JSON)
    - **Response**: `200 OK` with order ID, `500 Internal Server Error` with error message.

### Update Order Item Quantity
- **POST** `/orders/items/{itemId}`
    - Updates the quantity of an item in the order.
    - **Path**: `itemId` (Integer)
    - **Body**: Quantity (Integer)
    - **Response**: `200 OK` with item details, `500 Internal Server Error` with error message.

### Get Active Order
- **GET** `/orders/{userId}`
    - Retrieves the user's active order.
    - **Path**: `userId` (UUID as string)
    - **Response**: `200 OK` with order details, `404 Not Found` with error message.

### Complete Order
- **GET** `/orders/{userId}/complete`
    - Completes the user's current order.
    - **Path**: `userId` (UUID as string)
    - **Response**: `200 OK` with completion status, `500 Internal Server Error` with error message.

### Delete Current Order
- **DELETE** `/orders/{userId}/current`
    - Deletes the user's current order.
    - **Path**: `userId` (UUID as string)
    - **Response**: `200 OK` with deletion status, `500 Internal Server Error` with error message.

### Delete Specific Order
- **DELETE** `/orders/{userId}/{orderId}`
    - Deletes a specific order for the user.
    - **Path**: `userId` (UUID as string), `orderId` (Integer)
    - **Response**: `200 OK` with deletion status, `500 Internal Server Error` with error message.

## Food API Endpoints

### Get Food Details
- **GET** `/foods/{foodId}`
    - Retrieves details for a specific food item.
    - **Path**: `foodId` (Integer)
    - **Response**: `200 OK` with food details, `404 Not Found` with error message.

### List All Foods or Search
- **GET** `/foods`
    - Lists all foods or returns search results based on query.
    - **Query**: `search` (String, optional) - Search term for food items.
    - **Response**: `200 OK` with list of foods or search results, `404 Not Found` with error message.

### Get Foods by Category
- **GET** `/foods/categories`
    - Retrieves foods filtered by category.
    - **Query**: `type` (String, optional) - Category type, defaults to "all".
    - **Response**: `200 OK` with foods by category, `404 Not Found` with error message.
