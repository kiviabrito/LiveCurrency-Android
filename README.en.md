# Live Currency for Android - Kotlin

## Functionality

Calculate values ​​in different currencies.

## Structure:
Some of the components used are:

- MVVM architecture.
- Room DataBase - for local caching.
- Coroutines - for background tasks, such as network calls and database access.
- Ktor Client - for network calls.
- KotlinSerialization - for deserialization.
- RecyclerView - to display the list of currencies.
- ConstraintLayout - for the layout design.

## Libs:

   **JUNIT JUPITER (JUnit5) - For Unit Test**
   
                def junit_jupiter_version = "5.3.2"
                testImplementation "org.junit.jupiter:junit-jupiter-api:$junit_jupiter_version"
                testRuntimeOnly "org.junit.jupiter:junit-jupiter-engine:$junit_jupiter_version"
            
   **COROUTINES-TEST - For Unit Test**
   
                testImplementation 'org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.6'
            
   **MOCKITO - For Unit Test**
   
                def mockito_version = "2.25.0"
                testImplementation "org.mockito:mockito-core:$mockito_version"
                testImplementation "com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0"
            
   **KOTLINX SERIALIZATION - For deserialization of the network call response**
   
                implementation "org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0"
            
   **KTOR CLIENT - For network call response**
   
                implementation "io.ktor:ktor-client-okhttp:1.3.2"
            
   **ROOM DATABASE - For local database cache**
   
                def room_version = "2.2.5"
                implementation "androidx.room:room-runtime:$room_version"
                kapt "androidx.room:room-compiler:$room_version"
                
## Models:
   
Three different models were evaluated in response to the Rest API.
   
> Live Request ->
- [ ] Success = true && QuoteData
- [ ] Success = false && Error
   
> List Request ->
- [ ] Success = true && CurrencyData
- [ ] Success = false && Error
   
The 3 models are being handled in the ClientAPI file to avoid errors / crash at the time of the request.
   
   
## Views:
   
The application was create using:
   
- [ ] 1 - Activity
- [ ] 1 - ViewModel
- [ ] 2 - Fragments
   
The activity was use as a host for the fragments, and the ViewModel is looking for data and connecting / exchanging data between the two fragments.
   
For a quick response and better application efficiency, the main page consists of 4 views, two Buttons, an EditText and a TextView in which they have direct interaction between them.
   
When the user selects any currency the value updates without user having to press any other button, thus having a quick response to the user's interaction.
   
As for the currency selection page, a filter was add in SearchBar format to search by the name or code of the currency, and the option to organize in ascending order by both code and name was also add.

![alt text](https://github.com/kiviabrito/LiveCurrency-Android/blob/master/Screenshot_MainActivity.png) 

#### Note: For the offline mode to work, the user must have had at least one "SuccessResponse" from the network request.

## Run the app

The app uses [API CurrencyLayer](https://currencylayer.com/documentation) for the API, it is necessary to register for the free plan to obtain an access key and update the variable "key" in the file "ClientAPI.kt".
