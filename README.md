# Box Layout: Profile Header + Overlay Card


# 1. What the App Does

This Android application demonstrates a Tag Browser screen built using Jetpack Compose and Material 3 components. The screen features a dynamic list of genre tags displayed using a FlowRow, allowing chips to wrap automatically to the next line as needed. A second section uses a FlowColumn to display a “Selected Tags” area for your favorite genres, which updates in real time as the user taps chips. Each chip uses interactive FilterChip or AssistChip components to show selection state through changes in color and elevation.

# 2. Screenshot of the Running App



<img width="400" height="750" alt="Screenshot_20260224_105711" src="https://github.com/user-attachments/assets/b38de24d-a4df-464a-bdc1-d8da072de7c2" />

<img width="400" height="750" alt="Screenshot_20260224_105744" src="https://github.com/user-attachments/assets/db1960bd-1741-4576-a08a-0050758ec82b" />

<img width="400" height="750" alt="Screenshot_20260224_105750" src="https://github.com/user-attachments/assets/c99264e4-0373-4e8d-8f1b-20b3352c9f92" />



# 3. Device / Emulator / SDK Version

- **Emulator Device:** Medium Phone API 36.1 (Android 16.0 ("Baklava"))      
- **Minimum SDK:** 26  
- **Target SDK:** 36


# 4. AI Disclosure

For this assignment, my biggest issue was not being able to run my application. I kept getting an error about modules not found and no matter what I did, nothing worked. So I had to depend on chat to help me figure out where the issue lied and find a possible fix. I found that I ran into issues running the app because of version mismatches between Android Studio, Gradle, and the Compose/Material3 libraries. ChatGPT helped me identify which dependencies needed to be updated and guided me through changing my compileSdkVersion, targetSdkVersion, and library versions so that the project would build and run successfully. I also had trouble with preview errors not matching the runtime behavior, ChatGPT explained where the issues may lie and helped me adjust padding, alignment, and Box/Column usage. Additionally, ChatGPT helped me troubleshoot minor runtime errors and Gradle sync problems, which allowed me to finally run the app smoothly and verify that the FlowRow and FlowColumn layouts behaved as intended.


