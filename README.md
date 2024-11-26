# Finance Tracker App

## Problem Statement

Managing personal finances is a challenge for many individuals, as it requires careful tracking of expenses, budgeting, and ensuring financial discipline. Without an efficient system to log and categorize expenses, users often struggle with overspending, lack of financial visibility, and ineffective budget planning. Traditional methods such as manual record-keeping or spreadsheets can be cumbersome and error-prone, leading to incomplete or inaccurate tracking.

The **Finance Tracker** app addresses this problem by providing a streamlined, user-friendly solution for logging, viewing, and managing daily expenses. The app allows users to enter essential details such as the amount, description, and date of each expense, offering them an organized way to monitor their spending habits. By leveraging mobile technology, the app makes it convenient to track expenses anytime, anywhere, ensuring users stay informed and in control of their finances.

## Features

- **Log Expenses**: Add expenses by specifying the amount, description, and date.
- **View All Expenses**: Display a list of all expenses stored in the app.
- **Delete Expenses**: Remove any recorded expense from the list.
- **Room Database**: Utilizes a Room database for efficient local storage of expenses.
- **Simple User Interface**: Clean, intuitive design for easy navigation and data entry.

## Tech Stack

- **Kotlin**: The programming language used for developing the app.
- **Room Database**: For local data storage to manage and persist expenses.
- **Android Jetpack**: Libraries like ViewModel and LiveData for better architecture.
- **RecyclerView**: To display the list of expenses efficiently.
- **Material Design**: For UI components such as buttons, text fields, etc.

## Installation

### Prerequisites

To run this app, you need to have the following installed:
- **Android Studio** (latest stable version)
- **JDK 8 or higher**

### Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Manuella-R/finance-tracker.git
   cd finance-tracker
   ```

2. **Open in Android Studio**:
   - Open Android Studio and select **Open an existing Android Studio project**.
   - Navigate to the directory where the project was cloned and open it.

3. **Sync Gradle**:
   - Once the project is loaded, sync the project with Gradle by clicking **File > Sync Project with Gradle Files**.

4. **Build and Run**:
   - Connect a physical device or use the Android Emulator.
   - Click the green **Run** button in Android Studio to build and run the app.

### Dependencies

- **Room Database**: Used for storing and retrieving expenses.
- **Kotlin Coroutines**: For background operations (like inserting and deleting expenses).
- **AndroidX Libraries**: For modern UI components, ViewModel, LiveData, etc.

## Usage

### Adding an Expense:
- Enter the **title** of the expense, the **amount**, and the **date**.
- Tap the **Save Expense** button to save the expense in the local database.

### Viewing Expenses:
- The list of all saved expenses is displayed in a RecyclerView, showing the title, amount, and date for each entry.

### Deleting an Expense:
- Long press on any expense item to delete it from the list.

## File Structure

- **MainActivity.kt**: The main activity responsible for handling user interactions.
- **Expense.kt**: The data class representing an expense.
- **ExpenseDao.kt**: Data Access Object (DAO) interface for interacting with the Room database.
- **ExpenseRepository.kt**: Handles data operations and abstracts the DAO.
- **ExpenseViewModel.kt**: The ViewModel responsible for managing UI-related data in a lifecycle-conscious way.
- **item_expense.xml**: The layout for displaying each expense in the RecyclerView.
- **activity_main.xml**: The main layout for the app.


## Contributing

We welcome contributions! If you'd like to contribute to the development of the Finance Tracker app, please follow these steps:

1. **Fork the repository** to your GitHub account.
2. **Clone your fork** to your local machine.
3. Make the changes or improvements you want to contribute.
4. **Commit** your changes.
5. **Push** your changes to your fork.
6. **Create a pull request** to the main repository.

Please follow the existing coding conventions and ensure your code is well-documented.

---

## License

Distributed under the MIT License. See LICENSE for more information.

---
