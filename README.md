# News App with Jetpack Compose and Multi-Module Architecture

This Android News App is built using Jetpack Compose and follows the MVVM MultiModule Clean Architecture. The app utilizes modern Android libraries such as Retrofit for networking, Coroutines and Flow for asynchronous programming, Hilt for dependency injection, and Jetpack Compose for the UI.

## Features

```python
1. Viewing Top Headlines 
The app displays a list of top headlines fetched from a remote server using Retrofit.
There is a refresh option provided to load new headlines.
Jetpack Compose is used to create a dynamic and responsive UI.
2. News Details
Users can click on a headline to view the detailed information of that news.
The news details screen provides additional information such as the article content, author, publication date.
```

## Architecture
The app follows the MVVM Clean Architecture, which is divided into several modules:

App Module:
```
Contains the main application code.
Sets up the dependency injection using Hilt.
Initializes the Compose theme and navigation.
```
For each Feature we have:

Data Module:
```
Manages data-related operations such as fetching news from a remote source.
Utilizes Retrofit for network requests.
Employs Coroutines and Flow for handling asynchronous operations.
```
Domain Module:
```
Defines the business logic and use cases.
Contains the models representing news entities.
```
Presentation Module:
```
Implements the MVVM architecture.
Uses Jetpack Compose for building UI components.
Consumes data from the domain layer and provides it to the UI.
```

## Installation

Clone the repository:

```bash
https://github.com/Apoorv1180/CodeUtilityProject.git
```
Build and run the app on an emulator or physical device.

## Usage

```python
Open the app and navigate to the home screen.
Browse through the list of top headlines.
Click on a headline to view the detailed news.
```
