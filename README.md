# NotificationService

A simple Core Java project to simulate a configurable notification delivery system for companies and employees.

> **No frameworks used** — just clean Object-Oriented Programming (OOP) principles and [Gradle](https://gradle.org/) for build.

## Overview

This project demonstrates:

- Notification delivery to employees within multiple companies.
- Configurable notification channels (e.g., Email, SMS, etc.).
- Extensible design using pure Java interfaces and classes.
- Easy build setup with Gradle.

## Features

- **Core Java only:** No Spring, Jakarta EE, or external frameworks.
- **Flexible channels:** Easily add new notification channels by implementing simple interfaces.
- **Company/Employee modeling:** Basic domain-driven design for company and employee entities.
- **Configurable delivery:** Choose channels and recipients dynamically at runtime.

## How It Works

1. **Define Companies and Employees:** Each company can have multiple employees.
2. **Create Notification Channels:** Implement `NotificationChannel` for each delivery type (e.g., Email, SMS).
3. **Send Notifications:** Use `NotificationService` to deliver messages via selected channels to recipients.

## Usage

### Requirements

- Java 8 or above
- [Gradle](https://gradle.org/) installed

### Build

```bash
gradle build
```

### Run

```bash
gradle run
```

Or run the main class directly:

```bash
java -cp build/classes/java/main com.notification.Main
```

## Extending

To add a new channel (e.g., Slack):

1. Implement the `CommunicationMethod` interface.
2. Add your method to the Employee settings configuration.


## License

MIT

## Author

[@jayamukh](https://github.com/jayamukh)
