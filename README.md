# Navigation Demo App

This is a simple Android application showcasing navigation between three screens using Jetpack Compose and Navigation Component.

## Features

- Navigation between three composable screens (First, Second, and Third)
- Data passing between screens (Name and Age)
- Modern UI built with Jetpack Compose

## Demo (gif)
<img src="/app/src/main/res/assets/demo.gif" alt="Example GIF" width="200" />

## Project Structure

- **MainActivity**: Hosts the navigation logic using `NavHost`
- **FirstScreen**: First composable screen for user input
- **SecondScreen**: Second composable screen displaying user input and providing navigation to the Third Screen
- **ThirdScreen**: Third composable screen with navigation back to the First Screen

## Technology Stack

- **Kotlin**: The programming language used
- **Jetpack Compose**: For UI creation
- **Navigation Component**: For handling navigation between screens

## Navigation Flow

1. **First Screen**:
   - User enters Name and Age
   - User clicks "Go to Second Screen"

2. **Second Screen**:
   - Displays the entered Name and Age
   - User clicks "Go to Third Screen"

3. **Third Screen**:
   - Displays a personalized message using Name and Age
   - User clicks "Go Back to First Screen"
  
## Installation

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/gubskaia/navigation-app.git
2. Open the project in Android Studio.
3. Build the project.
4. Run the app on an emulator or a physical device.
