# Gym Management App

**Gym Management App** is designed to help gym owners efficiently manage their gym operations. The app allows the gym owner to manage memberships, review expired memberships, and track customer reviews and complaints, all from a single platform.

## Features
- **Manage Memberships**: Add, edit, and delete gym memberships. View active, expired, or soon-to-expire memberships.
- **Review Expired Memberships**: Easily identify and follow up on memberships that have expired.
- **Track Reviews and Complaints**: Receive and manage customer reviews and complaints to ensure quality service.
- **Firebase Integration**: All membership data, reviews, and complaints are stored securely in Firebase Firestore.

## Tech Stack
### Frontend
- **Android (XML Layouts)**: The UI is designed using traditional XML layouts, ensuring compatibility with a wide range of Android devices.
  
### Backend
- **Firebase Firestore**: Used to securely store and manage membership information, customer reviews, and complaints.
- **Firebase Authentication**: Provides secure login for the gym owner.

## Installation & Setup

### Frontend (Android with XML)
1. Clone the repository:
    ```bash
    git clone https://github.com/your-repo/gym-management-app.git
    ```
2. Open the project in **Android Studio**.
3. Sync the project to download all required dependencies.
4. Configure Firebase by adding your `google-services.json` file to the `app` directory.
5. Build and run the app on your preferred device or emulator.

## Firebase Services
- **Firebase Firestore**: Stores all membership records, reviews, and complaints.
- **Firebase Authentication**: Secures login for gym owners.

## Contribution
Contributions are welcome! Please follow the steps below:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-xyz`).
3. Make your changes and commit them (`git commit -m 'Add feature xyz'`).
4. Push to the branch (`git push origin feature-xyz`).
5. Open a Pull Request.

