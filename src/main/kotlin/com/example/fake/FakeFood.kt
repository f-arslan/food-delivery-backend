package com.example.fake

import com.example.dto.FoodDto
import com.example.dto.FoodCategory

val fakeDessertImageUrls = listOf(
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fdessert1.jpg?alt=media&token=511a816d-b6d6-43bc-b5d1-d1953b9585cb",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fdessert2.jpg?alt=media&token=e0fb37fe-d8aa-469d-a48e-f2aa1f2017f7",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fdessert3.jpg?alt=media&token=57108d76-1dfe-42ee-9255-0c11a58ccf87",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fdessert4.jpg?alt=media&token=0b7f1f2b-6459-4632-8cb5-b114e58d8597"
)

val fakeDrinkImageUrls = listOf(
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fdrink1.jpg?alt=media&token=dc76aa66-6ccf-4f9f-8912-572e317e30a9",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fdrink2.jpg?alt=media&token=a85ece39-444c-476e-89b7-b25e509fecb7",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fdrink3.jpg?alt=media&token=b8312dfb-56ca-4fa6-944c-a897f27ee2ab",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fdrink4.jpg?alt=media&token=b20d5307-66cc-4b07-84bd-02e4d75066d5"
)

val fakeHamburgerImageUrls = listOf(
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fhamburger1.jpg?alt=media&token=a51c1403-d073-4d89-92a0-9996a004b152",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fhamburger2.jpg?alt=media&token=5ec23c25-92d2-43a2-a09a-079fb1141306",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fhamburger3.jpg?alt=media&token=df1d43a2-52d1-445d-abfd-1677b1d9e43c",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fhamburger4.jpg?alt=media&token=66275f82-bf1f-4dc4-b925-5fcd5bd1177d"
)

val fakePizzaImageUrls = listOf(
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fpizza1.jpg?alt=media&token=ae1f50b0-3b8c-4342-bfa2-e9ae47a1f057",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fpizza2.jpg?alt=media&token=b7745195-9e13-4a20-baa5-f08ddaf23b00",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fpizza3.jpg?alt=media&token=52d5118e-1b65-4cd4-a292-2e2a55ba15c8",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fpizza4.jpg?alt=media&token=30a968aa-c464-4e14-80d5-4cee648901a9"
)

val fakeSandwichImageUrls = listOf(
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fsandwich1.jpg?alt=media&token=5c6f9170-6ac9-4d3b-a9d9-5ea180f8b7fc",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fsandwich2.jpeg?alt=media&token=d3870117-845c-4095-bb28-5d01bcd6219e",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fsandwich3.jpg?alt=media&token=f82cdd88-b026-473c-8917-f7eee4d2b6e7",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fsandwich4.jpg?alt=media&token=20771b06-4560-4850-bde0-9b5e39f3a5a6"
)

val snackImageUrls = listOf(
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fsnack1.jpeg?alt=media&token=8390d36e-3d97-41f8-8362-dcdb972db483",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fsnack2.jpg?alt=media&token=e28c5dd7-ff7c-41ec-852b-eb35aee0575d",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fsnack3.jpg?alt=media&token=b182958d-4f42-4d49-b566-7870addd8260",
    "https://firebasestorage.googleapis.com/v0/b/gptmap-dev.appspot.com/o/foods%2Fsnack4.jpg?alt=media&token=65481704-42e5-470c-a72c-3f3f4693d86f"
)

fun getRandomImageUrl(type: FoodCategory): String {
    return when (type) {
        FoodCategory.Burger -> fakeHamburgerImageUrls.random()
        FoodCategory.Pizza -> fakePizzaImageUrls.random()
        FoodCategory.Sandwich -> fakeSandwichImageUrls.random()
        FoodCategory.Dessert -> fakeDessertImageUrls.random()
        FoodCategory.Snack -> snackImageUrls.random()
        FoodCategory.Drink -> fakeDrinkImageUrls.random()
    }
}

val foodDtos = listOf(
    FoodDto(
        1,
        "The Classic Deluxe",
        "Juicy beef patty, melted cheddar, lettuce, tomato, special sauce on a sesame seed bun",
        8.99,
        4.2,
        1256,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        2,
        "Veggie Delight",
        "Grilled veggie patty, hummus, roasted red peppers, spinach, on a whole-wheat bun",
        7.99,
        4.5,
        872,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        3,
        "Pepperoni Passion",
        "Classic cheese pizza with a mountain of pepperoni",
        12.99,
        4.0,
        2790,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        4,
        "The Works",
        "Mozzarella, pepperoni, sausage, mushrooms, onions, olives, and green peppers",
        14.99,
        4.3,
        1994,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        id = 5,
        name = "Grilled Chicken Club",
        description = "Grilled chicken breast, bacon, lettuce, tomato, mayo on toasted sourdough",
        price = 9.99,
        rating = 4.1,
        orderCount = 905,
        category = FoodCategory.Sandwich.name,
        imageUrl = getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        id = 6,
        name = "Fruity Blast Smoothie",
        description = "Blend of strawberries, bananas, yogurt, and a hint of honey",
        price = 5.99,
        rating = 4.6,
        orderCount = 652,
        category = FoodCategory.Drink.name,
        imageUrl = getRandomImageUrl(FoodCategory.Drink)
    ),
    FoodDto(
        id = 7,
        name = "Double Chocolate Fudge",
        description = "Decadent chocolate ice cream with chunks of rich fudge brownies",
        price = 4.99,
        rating = 4.8,
        orderCount = 1118,
        category = FoodCategory.Dessert.name,
        imageUrl = getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        id = 8,
        name = "Trail Mix Medley",
        description = "Crunchy mix of nuts, seeds, and dried fruits",
        price = 3.49,
        rating = 3.9,
        orderCount = 438,
        category = FoodCategory.Snack.name,
        imageUrl = getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        id = 9,
        name = "Spicy Chicken Wrap",
        description = "Crispy chicken tenders, lettuce, tomato, hot sauce, in a flour tortilla",
        price = 6.99,
        rating = 4.3,
        orderCount = 771,
        category = FoodCategory.Sandwich.name,
        imageUrl = getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        id = 10,
        name = "Iced Caramel Latte",
        description = "Espresso, milk, caramel syrup, and a mountain of whipped cream",
        price = 4.49,
        rating = 4.4,
        orderCount = 1430,
        category = FoodCategory.Drink.name,
        imageUrl = getRandomImageUrl(FoodCategory.Drink)
    ),
    FoodDto(
        11,
        "Buffalo Chicken Wings",
        "Crispy wings tossed in tangy buffalo sauce, served with ranch",
        8.99,
        4.2,
        987,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        12,
        "Molten Chocolate Cake",
        "Warm, gooey chocolate cake with a molten center",
        7.49,
        4.8,
        672,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        13,
        "Chicken Caesar Salad",
        "Grilled chicken, romaine lettuce, parmesan cheese, croutons, Caesar dressing",
        11.99,
        4.3,
        812,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        14,
        "The Meatlovers",
        "Pizza loaded with pepperoni, sausage, ham, and bacon",
        15.99,
        4.0,
        1308,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        15,
        "Double Stack Cheeseburger",
        "Two beef patties, double cheese, with all the fixings",
        11.99,
        4.5,
        1015,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        16,
        "Strawberry Shortcake",
        "Sweet biscuits, fresh strawberries, and whipped cream",
        6.99,
        4.6,
        473,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        17,
        "Fresh Fruit Salad",
        "Colorful mix of seasonal fruits",
        4.99,
        4.9,
        512,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        18,
        "Hot Chocolate",
        "Rich and creamy hot chocolate with marshmallows",
        4.49,
        4.5,
        854,
        FoodCategory.Drink.name,
        getRandomImageUrl(FoodCategory.Drink)
    ),
    FoodDto(
        19,
        "Fish and Chips",
        "Crispy battered fish with fries and tartar sauce",
        12.49,
        4.2,
        776,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        20,
        "Sweet and Sour Chicken",
        "Crispy chicken in a tangy sweet and sour sauce, with rice",
        10.99,
        4.4,
        923,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        21,
        "BBQ Brisket Sandwich",
        "Slow-smoked brisket with tangy BBQ sauce on a toasted bun",
        11.99,
        4.6,
        650,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        22,
        "Grilled Cheese Deluxe",
        "Melty blend of cheeses with bacon and tomato on sourdough",
        8.99,
        4.4,
        820,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        23,
        "Chocolate Milkshake",
        "Thick and creamy chocolate milkshake topped with whipped cream",
        5.49,
        4.8,
        451,
        FoodCategory.Drink.name,
        getRandomImageUrl(FoodCategory.Drink)
    ),
    FoodDto(
        24,
        "Cinnamon Roll",
        "Warm, gooey cinnamon roll with sweet icing",
        4.49,
        4.6,
        622,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        25,
        "Veggie Wrap",
        "Grilled vegetables, hummus, avocado, and sprouts in a whole-wheat wrap",
        9.49,
        4.5,
        589,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        26,
        "Greek Salad",
        "Feta cheese, olives, cucumbers, tomatoes, and red onion with a vinaigrette dressing",
        10.99,
        4.7,
        713,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        27,
        "Chicken Tacos",
        "Grilled chicken, salsa, cilantro, and lime on corn tortillas",
        9.99,
        4.3,
        844,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        28,
        "Brownie Sundae",
        "Warm brownie with vanilla ice cream, hot fudge, and whipped cream",
        7.99,
        4.9,
        426,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        29,
        "Spicy Tuna Roll",
        "Sushi roll with spicy tuna, avocado, and cucumber.",
        12.99,
        4.2,
        641,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        30,
        "The Everything Pizza",
        "Supreme-style pizza with all the toppings",
        16.99,
        4.1,
        1124,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        31,
        "Classic Hot Dog",
        "All-beef hot dog in a bun with your choice of toppings",
        5.99,
        4.1,
        1015,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        32,
        "Chicken Noodle Soup",
        "Comforting bowl of chicken, noodles, and vegetables in a savory broth",
        6.99,
        4.4,
        744,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        33,
        "Fruit Parfait",
        "Layers of yogurt, granola, and fresh berries",
        6.49,
        4.8,
        456,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        34,
        "Acai Bowl",
        "Blended acai topped with granola, fruit, and a drizzle of honey",
        8.99,
        4.6,
        687,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        35,
        "Falafel Pita",
        "Falafel patties with hummus, lettuce, tomato, and tahini sauce in a pita",
        9.99,
        4.5,
        628,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        36,
        "Chicken Burrito Bowl",
        "Grilled chicken, rice, beans, salsa, and your favorite toppings",
        11.99,
        4.4,
        890,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        37,
        "Fish Tacos",
        "Grilled or blackened fish with cabbage slaw and chipotle mayo in corn tortillas",
        10.99,
        4.3,
        762,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        38,
        "Ice Cream Sundae",
        "Your choice of ice cream flavors with all the classic toppings",
        6.99,
        4.7,
        591,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        39,
        "Banana Split",
        "Classic dessert with bananas, ice cream, whipped cream, and a cherry on top",
        7.99,
        4.6,
        422,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        40,
        "Nachos Supreme",
        "Tortilla chips piled high with cheese, beans, ground beef, salsa, and all the fixings",
        12.99,
        4.2,
        923,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        41,
        "Pad Thai",
        "Classic Thai stir-fry with rice noodles, chicken or tofu, vegetables, and peanuts",
        12.49,
        4.4,
        854,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        42,
        "Beef Taco Salad",
        "Crispy taco shell filled with seasoned ground beef, lettuce, tomato, cheese, and sour cream",
        11.99,
        4.3,
        798,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        43,
        "French Fries",
        "Crispy, golden fries with your choice of dipping sauce",
        4.99,
        4.5,
        1204,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        44,
        "Mozzarella Sticks",
        "Breaded mozzarella cheese sticks fried until golden brown",
        7.49,
        4.2,
        867,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        45,
        "Onion Rings",
        "Battered and fried onion rings, crispy and delicious",
        6.99,
        4.3,
        910,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        46,
        "Pasta Primavera",
        "Pasta with a medley of fresh vegetables in a light sauce",
        12.99,
        4.5,
        753,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        47,
        "Chicken Quesadilla",
        "Grilled chicken and melted cheese in a flour tortilla",
        10.99,
        4.4,
        829,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        48,
        "Garlic Bread",
        "Warm, buttery garlic bread",
        4.99,
        4.6,
        773,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        49,
        "Chicken Pot Pie",
        "Savory pie filled with chicken, vegetables, and a creamy sauce",
        11.99,
        4.3,
        678,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        50,
        "Tiramisu",
        "Classic Italian dessert with ladyfingers, espresso, and mascarpone cheese",
        7.99,
        4.8,
        532,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        51,
        "Steak and Fries",
        "Grilled steak with a side of crispy seasoned fries",
        18.99,
        4.5,
        510,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        52,
        "Chicken Alfredo",
        "Fettuccine pasta with grilled chicken in a creamy Alfredo sauce",
        14.99,
        4.3,
        876,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        53,
        "Shrimp Scampi",
        "Shrimp sautéed in garlic, butter, white wine, and lemon sauce, served over pasta",
        15.99,
        4.6,
        699,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        54,
        "Sushi Combo",
        "Assortment of sushi rolls and nigiri",
        16.99,
        4.4,
        731,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        55,
        "Chicken Curry",
        "Flavorful chicken curry with rice and naan bread",
        13.99,
        4.3,
        908,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        56,
        "Pho",
        "Vietnamese noodle soup with beef, vegetables, and herbs",
        12.99,
        4.5,
        613,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        57,
        "Tacos al Pastor",
        "Marinated pork tacos with pineapple, cilantro, and onion",
        10.99,
        4.4,
        821,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        58,
        "Poke Bowl",
        "Marinated raw fish with rice, vegetables, and toppings",
        13.99,
        4.7,
        780,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        59,
        "BLT",
        "Classic bacon, lettuce, and tomato sandwich",
        8.99,
        4.3,
        923,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        60,
        "Grilled Salmon",
        "Grilled salmon fillet with your choice of sides",
        16.99,
        4.5,
        620,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        61,
        "Macaroni and Cheese",
        "Classic comfort food with a creamy cheese sauce",
        9.99,
        4.2,
        1010,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        62,
        "Caesar Salad",
        "Romaine lettuce, croutons, Parmesan cheese, and Caesar dressing",
        9.99,
        4.3,
        840,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        63,
        "Fruit Salad",
        "Mix of fresh seasonal fruits",
        6.99,
        4.9,
        510,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        64,
        "Beignets",
        "Fried dough pastries dusted with powdered sugar, a New Orleans specialty",
        7.99,
        4.6,
        542,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        65,
        "Key Lime Pie",
        "Tart and sweet pie with a graham cracker crust",
        7.49,
        4.7,
        418,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        66,
        "Baklava",
        "Sweet, layered pastry with nuts and honey",
        6.99,
        4.5,
        619,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        67,
        "Lemonade",
        "Refreshing homemade lemonade",
        3.99,
        4.4,
        829,
        FoodCategory.Drink.name,
        getRandomImageUrl(FoodCategory.Drink)
    ),
    FoodDto(
        68,
        "Iced Tea",
        "Sweet or unsweetened iced tea",
        3.49,
        4.3,
        934,
        FoodCategory.Drink.name,
        getRandomImageUrl(FoodCategory.Drink)
    ),
    FoodDto(
        69,
        "Soda",
        "Your choice of fountain soda",
        3.99,
        4.0,
        1072,
        FoodCategory.Drink.name,
        getRandomImageUrl(FoodCategory.Drink)
    ),
    FoodDto(
        70,
        "Bottle of Water",
        "Still or sparkling water",
        2.99,
        4.7,
        512,
        FoodCategory.Drink.name,
        getRandomImageUrl(FoodCategory.Drink)
    ),
    FoodDto(
        71,
        "Lamb Chops",
        "Grilled lamb chops with a side of roasted vegetables",
        19.99,
        4.6,
        473,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        72,
        "Spaghetti and Meatballs",
        "Classic Italian comfort food with marinara sauce",
        13.99,
        4.4,
        955,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        73,
        "Lobster Roll",
        "Fresh lobster meat on a toasted roll with mayonnaise and a side of fries",
        17.99,
        4.5,
        530,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        74,
        "Fried Chicken",
        "Crispy, juicy fried chicken with your choice of sides",
        12.99,
        4.4,
        953,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        75,
        "Meatloaf",
        "Home-style meatloaf with gravy, mashed potatoes, and a side of vegetables",
        13.99,
        4.3,
        816,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        76,
        "Cobb Salad",
        "Grilled chicken, bacon, avocado, hard-boiled egg, blue cheese, tomatoes on a bed of greens",
        14.99,
        4.4,
        743,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        77,
        "Vegetable Stir-Fry",
        "Assortment of fresh vegetables stir-fried with tofu or your choice of protein",
        12.99,
        4.6,
        695,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        78,
        "Crab Cakes",
        "Pan-seared crab cakes with a side of remoulade sauce",
        16.99,
        4.5,
        628,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        79,
        "Tofu Scramble",
        "Seasoned tofu scramble with vegetables, a vegan breakfast option",
        9.99,
        4.5,
        732,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        80,
        "Stuffed Bell Peppers",
        "Bell peppers stuffed with a savory mixture of rice, ground beef, and vegetables",
        13.99,
        4.4,
        780,
        FoodCategory.Sandwich.name,
        getRandomImageUrl(FoodCategory.Sandwich)
    ),
    FoodDto(
        81,
        "Vegetable Samosas",
        "Crispy fried pastries filled with spiced vegetables",
        7.99,
        4.3,
        910,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        82,
        "Spring Rolls",
        "Fresh vegetables and rice noodles wrapped in rice paper",
        7.99,
        4.2,
        876,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        83,
        "Edamame",
        "Steamed soybeans, a healthy and simple appetizer",
        6.99,
        4.6,
        542,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        84,
        "Hummus and Pita",
        "Creamy hummus with warm pita bread",
        8.99,
        4.6,
        705,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        85,
        "Baba Ghanoush",
        "Roasted eggplant dip with tahini and lemon",
        8.99,
        4.5,
        721,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        86,
        "French Toast",
        "Thick slices of bread dipped in custard and pan-fried",
        9.99,
        4.4,
        829,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        87,
        "Waffles",
        "Fluffy waffles with choice of toppings like syrup, fruit, and whipped cream",
        9.99,
        4.5,
        854,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        88,
        "Crepes",
        "Thin pancakes filled with sweet or savory fillings",
        9.99,
        4.3,
        799,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        89,
        "Donuts",
        "Assorted varieties of glazed, filled, and cake donuts",
        3.99,
        4.5,
        923,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        90,
        "Cheesecake",
        "Rich and creamy cheesecake with your choice of toppings",
        7.99,
        4.7,
        591,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        91,
        "Oatmeal",
        "Warm bowl of oatmeal with your choice of toppings like fruit, nuts, and honey",
        6.99,
        4.6,
        612,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        92,
        "Breakfast Burrito",
        "Eggs, cheese, breakfast meat, and vegetables wrapped in a tortilla",
        9.99,
        4.3,
        852,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        93,
        "Bagel and Lox",
        "Bagel with cream cheese, smoked salmon, capers, and onions",
        10.99,
        4.4,
        790,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        94,
        "Guacamole and Chips",
        "Homemade guacamole served with tortilla chips",
        8.99,
        4.5,
        837,
        FoodCategory.Snack.name,
        getRandomImageUrl(FoodCategory.Snack)
    ),
    FoodDto(
        95,
        "Fruit Smoothie",
        "Blended mix of fruits, yogurt, and juice",
        6.99,
        4.7,
        620,
        FoodCategory.Drink.name,
        getRandomImageUrl(FoodCategory.Drink)
    ),
    FoodDto(
        96,
        "Milkshake",
        "Thick and creamy milkshake, variety of flavors",
        6.49,
        4.7,
        556,
        FoodCategory.Drink.name,
        getRandomImageUrl(FoodCategory.Drink)
    ),
    FoodDto(
        97,
        "Orange Juice",
        "Freshly squeezed orange juice",
        4.99,
        4.6,
        732,
        FoodCategory.Drink.name,
        getRandomImageUrl(FoodCategory.Drink)
    ),
    FoodDto(
        98,
        "Kombucha",
        "Fermented tea beverage",
        4.99,
        4.4,
        678,
        FoodCategory.Drink.name,
        getRandomImageUrl(FoodCategory.Drink)
    ),
    FoodDto(
        99,
        "Sparkling Water",
        "Variety of flavored sparkling water",
        3.99,
        4.5,
        712,
        FoodCategory.Drink.name,
        getRandomImageUrl(FoodCategory.Drink)
    ),
    FoodDto(
        100,
        "Coconut Water",
        "Refreshing and hydrating beverage",
        4.49,
        4.3,
        695,
        FoodCategory.Drink.name,
        getRandomImageUrl(FoodCategory.Drink)
    ),
    FoodDto(
        101,
        "Garden Burger",
        "Black bean patty, avocado, tomato, lettuce, chipotle mayo, on a brioche bun",
        8.49,
        4.2,
        740,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        102,
        "The Works",
        "Beef patty, cheddar cheese, bacon, onion rings, BBQ sauce, on a toasted sesame bun",
        9.99,
        4.0,
        980,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        103,
        "Mushroom Swiss Burger",
        "Beef patty, sauteed mushrooms, Swiss cheese, caramelized onions, on a pretzel bun",
        9.49,
        4.3,
        850,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        104,
        "California Classic",
        "Beef patty, lettuce, tomato, onion, special sauce, on a classic bun",
        8.99,
        4.1,
        690,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        105,
        "Spicy Fiesta",
        "Grilled chicken breast, pepper jack cheese, jalapenos, salsa, avocado, on a whole-wheat bun",
        8.99,
        3.9,
        650,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        106,
        "Portobello Burger",
        "Grilled portobello mushroom, goat cheese, arugula, balsamic glaze, on a ciabatta bun",
        8.49,
        4.6,
        520,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        107,
        "Falafel Burger",
        "Spiced falafel patty, tahini sauce, cucumber, tomato, on a pita bun",
        7.99,
        4.4,
        610,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        108,
        "Teriyaki Salmon Burger",
        "Grilled salmon patty, teriyaki sauce, pineapple, slaw, on a brioche bun",
        9.99,
        4.3,
        720,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        109,
        "Bison Burger",
        "Lean bison patty, caramelized onions, cheddar, lettuce, on a whole-wheat bun",
        10.49,
        4.0,
        780,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        110,
        "Beyond Burger",
        "Plant-based patty, lettuce, tomato, onion, vegan mayo, on a whole-wheat bun",
        9.49,
        4.5,
        620,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        111,
        "Southwestern Black Bean Burger",
        "Black bean patty, corn salsa, avocado, chipotle mayo, on a whole-wheat bun",
        8.99,
        4.4,
        710,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        112,
        "Lamb Burger",
        "Ground lamb patty, feta cheese, tzatziki sauce, cucumber, on a pita bun",
        9.99,
        4.0,
        790,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        113,
        "Breakfast Burger",
        "Beef patty, fried egg, bacon, hash brown, cheddar cheese, on an English muffin",
        10.49,
        3.8,
        1050,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        114,
        "Kimchi Burger",
        "Beef patty, kimchi, gochujang mayo, fried egg, on a sesame seed bun",
        9.49,
        4.2,
        890,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        115,
        "BBQ Pulled Pork Burger",
        "Slow-cooked pulled pork, BBQ sauce, coleslaw, on a brioche bun",
        9.49,
        3.9,
        840,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        116,
        "Turkey Burger",
        "Ground turkey patty, cranberry sauce, brie cheese, arugula, on a whole-wheat bun",
        8.99,
        4.3,
        640,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        117,
        "Stuffed Burger",
        "Beef patty stuffed with cheddar cheese, bacon, and jalapenos, on a pretzel bun",
        10.49,
        4.1,
        920,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        118,
        "Tuna Burger",
        "Grilled tuna patty, wasabi mayo, pickled ginger, slaw, on a brioche bun",
        9.99,
        4.6,
        680,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        119,
        "Shrimp Burger",
        "Ground shrimp patty, cajun remoulade, lettuce, tomato, on a toasted bun",
        9.49,
        4.0,
        630,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        120,
        "Double-Double",
        "Two beef patties, double cheese, lettuce, tomato, onion, special sauce, on a classic bun",
        10.49,
        3.5,
        950,
        FoodCategory.Burger.name,
        getRandomImageUrl(FoodCategory.Burger)
    ),
    FoodDto(
        121,
        "Chocolate Lava Cake",
        "Warm molten chocolate cake with a gooey center, served with vanilla ice cream",
        8.49,
        4.8,
        680,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        122,
        "Tiramisu",
        "Classic Italian dessert with ladyfingers dipped in coffee, layered with mascarpone cream",
        8.99,
        4.6,
        450,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        123,
        "Crème Brûlée",
        "Rich custard base with a caramelized sugar topping",
        7.99,
        4.5,
        490,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        124,
        "Apple Pie",
        "Flaky crust filled with sweet, cinnamon-spiced apples, served warm with a scoop of ice cream",
        7.49,
        4.5,
        520,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        125,
        "Carrot Cake",
        "Moist carrot cake with cream cheese frosting and walnuts",
        7.49,
        4.3,
        610,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        126,
        "Fruit Tart",
        "Sweet pastry crust filled with custard and topped with fresh seasonal fruits",
        7.99,
        4.1,
        420,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        127,
        "Ice Cream Sundae",
        "Your choice of ice cream flavors with whipped cream, chocolate sauce, sprinkles, and a cherry",
        6.99,
        4.4,
        640,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        128,
        "Brownie Delight",
        "Fudgy chocolate brownie topped with vanilla ice cream, hot fudge, and whipped cream",
        7.99,
        4.6,
        710,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        129,
        "Panna Cotta",
        "Silky-smooth Italian custard dessert with a choice of berry or chocolate sauce",
        7.49,
        4.2,
        380,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        130,
        "Waffle Extravaganza",
        "Warm Belgian waffle topped with strawberries, whipped cream, and chocolate sauce",
        8.49,
        4.0,
        730,
        FoodCategory.Dessert.name,
        getRandomImageUrl(FoodCategory.Dessert)
    ),
    FoodDto(
        131,
        "Meat Lover's",
        "Mozzarella, pepperoni, sausage, bacon, ham, and ground beef",
        15.99,
        4.1,
        2215,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        132,
        "Margherita",
        "Mozzarella, fresh basil, and tomato sauce",
        12.99,
        4.6,
        1540,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        133,
        "BBQ Chicken",
        "Mozzarella, grilled chicken, BBQ sauce, red onions, and cilantro",
        14.99,
        4.0,
        1850,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        134,
        "Hawaiian",
        "Mozzarella, ham, pineapple, and bacon",
        13.99,
        3.9,
        1720,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        135,
        "Veggie Supreme",
        "Mozzarella, mushrooms, onions, green peppers, olives, and tomatoes",
        13.99,
        4.4,
        1640,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        136,
        "Spinach & Feta",
        "Mozzarella, spinach, feta cheese, and garlic",
        13.99,
        4.5,
        1680,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        137,
        "Buffalo Chicken",
        "Mozzarella, grilled chicken, buffalo sauce, and blue cheese crumbles",
        14.99,
        4.2,
        1810,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        138,
        "White Pizza",
        "Ricotta, mozzarella, garlic, olive oil, and fresh herbs",
        13.99,
        4.4,
        1750,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        139,
        "Four Cheese",
        "Mozzarella, provolone, parmesan, and gorgonzola",
        13.99,
        4.7,
        1790,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        140,
        "Pesto Pizza",
        "Mozzarella, pesto sauce, grilled chicken, roasted red peppers, and goat cheese",
        14.99,
        4.3,
        1840,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        141,
        "Mediterranean Pizza",
        "Mozzarella, feta cheese, kalamata olives, roasted red peppers, artichoke hearts, and sun-dried tomatoes",
        14.99,
        4.4,
        1720,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        142,
        "Shrimp Scampi Pizza",
        "Mozzarella, garlic butter sauce, sauteed shrimp, fresh parsley, and lemon wedges",
        15.99,
        4.2,
        1780,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        143,
        "Breakfast Pizza",
        "Scrambled eggs, bacon, sausage, hash browns, and cheddar cheese",
        14.99,
        3.8,
        2100,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        144,
        "Taco Pizza",
        "Refried beans, seasoned ground beef, cheddar cheese, lettuce, tomatoes, and salsa ",
        14.99,
        3.9,
        1950,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        145,
        "Deep Dish",
        "Thick crust, mozzarella, pepperoni, sausage, mushrooms, and extra sauce",
        16.99,
        4.0,
        2500,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        146,
        "Prosciutto & Arugula",
        "Mozzarella, thinly sliced prosciutto, arugula, shaved parmesan, and a balsamic glaze",
        15.99,
        4.6,
        1640,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        147,
        "Fig & Goat Cheese",
        "Mozzarella, goat cheese, sliced figs, caramelized onions, and a drizzle of honey",
        14.99,
        4.5,
        1590,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        148,
        "Dessert Pizza",
        "Sweet dough, Nutella spread, strawberries, banana slices, and a dusting of powdered sugar",
        12.99,
        4.3,
        1530,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        149,
        "Calzone",
        "Folded pizza dough filled with mozzarella, ricotta, pepperoni, and sausage",
        14.99,
        4.1,
        2050,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
    FoodDto(
        150,
        "Stromboli",
        "Rolled pizza dough filled with mozzarella, pepperoni, sausage, and peppers",
        14.99,
        4.0,
        2010,
        FoodCategory.Pizza.name,
        getRandomImageUrl(FoodCategory.Pizza)
    ),
)
