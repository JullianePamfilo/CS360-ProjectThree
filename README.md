# Pamfilo_Module3Assignment

Android app for Module 3 demonstrating **user interaction**, **activity navigation**, **dynamic layouts**, and **runtime permissions** using **Java** and **Android Studio**.

---

## ✨ Features

- **MainActivity (Home)**
  - Name input with a **TextWatcher** to enable/disable the **“Say Hello”** button.
  - Taps show a greeting (e.g., `Hello JP!`).
  - Buttons navigate to **GridActivity** and **SmsActivity**.

- **GridActivity (Data Entry)**
  - Inputs for **Item Name** and **Item Detail**.
  - **Add Item** button (future enhancement: display items in a `RecyclerView`/`GridView`).
  - Demonstrates dynamic UI layout and input handling.

- **SmsActivity (Runtime Permission)**
  - Displays current **SMS permission** status.
  - Button to **request SMS permission** at runtime.
  - Shows runtime-permission flow best practices.

---

## 🧱 Tech Stack

- **Language:** Java  
- **UI:** XML Layouts, View Binding  
- **Android APIs:** Intents, TextWatcher, Runtime Permissions  
- **IDE:** Android Studio (AndroidX)

---

## 📂 Project Structure (high-level)

```
app/
 ├─ java/.../
 │   ├─ MainActivity.java
 │   ├─ GridActivity.java
 │   └─ SmsActivity.java
 └─ res/
     ├─ layout/ (activity_main.xml, activity_grid.xml, activity_sms.xml)
     └─ values/ (strings.xml, colors.xml, themes.xml)
```

---

## ▶️ Build & Run

1. Open the project in **Android Studio**.
2. **Sync Gradle** if prompted.
3. Select an **emulator** or **physical device**.
4. Click **Run** (▶). The app launches to **MainActivity**.

---

## 🔐 Permissions (Notes)

- SMS-related permissions (e.g., `SEND_SMS`, `READ_SMS`, `RECEIVE_SMS`) are **dangerous** and require **runtime consent**.
- Some SMS permissions are restricted by **Google Play policies**. For coursework on an emulator/device (not Play Store), the runtime-permission demo is appropriate.

_Example manifest entries (adjust to what you actually use):_
```xml
<!-- AndroidManifest.xml -->
<uses-permission android:name="android.permission.SEND_SMS" />
<uses-permission android:name="android.permission.READ_SMS" />
```

_Request at runtime in `SmsActivity` using `ActivityCompat.requestPermissions(...)` and handle in `onRequestPermissionsResult(...)` (or the newer Activity Result APIs)._

---

## 🧪 Testing

Manual test plan highlights:
- **MainActivity**
  - Empty name keeps “Say Hello” disabled.
  - Entering a name enables the button and shows a greeting.
  - Navigation buttons open the correct screens.
- **GridActivity**
  - Entering values then tapping **Add Item** logs/adds data (future: verify list render).
  - Handles empty input gracefully (no crash).
- **SmsActivity**
  - Shows correct permission status.
  - Request flow updates UI after grant/deny.
  - No crash on deny + retry.

---

## 🚀 Future Improvements

- Render entered items in a **RecyclerView/GridView** with add/remove/edit.
- Persist items using **Room** or **SharedPreferences**.
- Add **toasts/snackbars** and simple **transitions** for smoother UX.
- Migrate runtime permissions to the **Activity Result API**.
- Add **instrumented UI tests** (Espresso) and **unit tests** for utilities.

---

## 📌 Why this project matters

This app practices:
- Clean, user-focused UI design.
- Navigation between multiple activities.
- Dynamic interaction with **TextWatcher** and **View Binding**.
- Real-world **runtime permissions** handling.

---
