# Live Currency for Swift - Kotlin

## Functionality

Calculate values ​​in different currencies.

## Structure:

The application was created using:

- [ ] 1 - ViewModel
- [ ] 2 - ViewControllers
 
The ViewModel is looking for data and connecting / exchanging data between the two ViewControllers. To use the application in offline mode, SQLite is being used, where it is possible to store the data locally on the device. For serialization, Codable is being used, and for network request URLSession is being used.
                
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
   
ResultViewController:

![alt text](https://github.com/kiviabrito/LiveCurrency-iOS/blob/master/Screenshot_ResultViewController.png) 

SelectionViewController:

![alt text](https://github.com/kiviabrito/LiveCurrency-iOS/blob/master/Screenshot_SelectionViewController.png) 

#### Note: For the offline mode to work, the user must have had at least one "SuccessResponse" from the network request.

## Run the app

The app uses [API CurrencyLayer](https://currencylayer.com/documentation) for the API, it is necessary to register for the free plan to obtain an access key and update the variable "key" in the file "ClientAPI.kt".
