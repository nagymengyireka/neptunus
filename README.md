<a id="readme-top"></a>

# Neptunus: Education System Platform

 [![Contributors](https://img.shields.io/badge/contributors-3-green)](https://github.com/nagymengyireka/neptunus/graphs/contributors)
 [![Forks](https://img.shields.io/badge/forks-0-blue)](https://github.com/nagymengyireka/neptunus/forks)
 [![Stargazers](https://img.shields.io/badge/stargazers-0-blue)](https://github.com/nagymengyireka/neptunus/stargazers)
 [![Issues](https://img.shields.io/badge/issues-0-blue)](https://github.com/nagymengyireka/neptunus/issues)

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#the-project">The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li><a href="#team-members">Team Members</a></li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#development-methodologies">Development Methodologies</a></li>
    <li><a href="#contributing">Contributing</a></li>
  </ol>
</details>

## The Project

<br>

<img width="1439" alt="image" src="https://github.com/user-attachments/assets/08bd1395-adee-4a99-ad6b-d7358426dcb7">

<br>
<br>

This project is primarily responsible for managing administrative tasks within universities and colleges. It facilitates functions such as course registration. Essentially, Neptunus serves as a platform for students to oversee and engage in various aspects of their academic journey, including accessing essential documents and information pertinent to their studies.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Built With
<br>

* [![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-security)
* [![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
* [![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-data-jpa)
* [![PostgreSQL](https://img.shields.io/badge/PostgreSQL-336791?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
* [![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
* [![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)](https://react.dev/)
* [![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)](https://getbootstrap.com/)
* [![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-06B6D4?style=for-the-badge&logo=tailwind-css&logoColor=white)](https://tailwindcss.com/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Team Members

* [![Nagymengyi Réka](https://img.shields.io/badge/Nagymengyi%20Réka-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/nagymengyireka)
* [![Horváth Melani](https://img.shields.io/badge/Horváth%20Melani-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/melanihorvath)
* [![Konkoly Gergő](https://img.shields.io/badge/Konkoly%20Gergő-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/whowful)

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

---

### Prerequisites

Before setting up and running the Neptunus Education System Platform locally, ensure that you have the following tools and dependencies installed on your system:

1. **Java Development Kit (JDK) 17 or higher**
   - **Required**: To run the Spring Boot backend.
   - **Installation**:
     - **Windows/macOS/Linux**: Download and install from the official [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or use [OpenJDK](https://openjdk.java.net/install/).

   ```sh
   java -version
   ```

2. **Apache Maven 3.8.1 or higher**
   - **Required**: To manage dependencies and build the Spring Boot project.
   - **Installation**:
     - **Windows/macOS/Linux**: Follow the official [Maven installation guide](https://maven.apache.org/install.html).

   ```sh
   mvn -version
   ```

3. **Node.js and npm**
   - **Required**: To run and manage the frontend (React with Vite).
   - **Installation**:
     - **Windows/macOS/Linux**: Download from the official [Node.js website](https://nodejs.org/).
     - Installing Node.js will also install `npm`.

   ```sh
   node -v
   npm -v
   ```

4. **Docker (Optional but Recommended)**
   - **Required**: For containerization, making it easier to deploy the application with consistent environments.
   - **Installation**:
     - **Windows/macOS/Linux**: Install Docker from the official [Docker website](https://www.docker.com/get-started).

   ```sh
   docker --version
   ```

5. **PostgreSQL Database**
   - **Required**: For storing and managing the application’s data.
   - **Installation**:
     - **Windows/macOS/Linux**: Download and install from the official [PostgreSQL website](https://www.postgresql.org/download/).
     - Make sure you have a PostgreSQL server running locally or accessible remotely.

   ```sh
   psql --version
   ```

6. **News API Key**
   - **Required**: To fetch scientific news for the landing page.
   - **Get a Free API Key**: Register at [News API](https://newsapi.org) and generate your API key.


### Optional Development Tools

- **IDE (Integrated Development Environment)**
  - Recommended IDEs include **IntelliJ IDEA** for Java/Spring Boot development and **Visual Studio Code** for frontend/React development.

- **Git**
  - **Required**: For cloning the repository and version control.
  - **Installation**:
    - **Windows/macOS/Linux**: Install from the official [Git website](https://git-scm.com/downloads).

   ```sh
   git --version
   ```
---

### Installation

1. Get a free API Key at [News API](https://newsapi.org).

2. Clone the repo
   ```sh
   git clone https://github.com/nagymengyireka/neptunus.git
   ```

3. Set up the backend (Spring Boot and Maven)
   ```sh
   cd neptunus/backend
   mvn install
   mvn spring-boot:run
   ```

4. Install NPM packages for the frontend
   ```sh
   cd frontend
   npm install
   ```

5. Enter your API key in `/frontend/src/Pages/MainPage.jsx`
   ```js
   const API_KEY = 'ENTER YOUR API';
   ```

6. Change git remote URL to avoid accidental pushes to base project
   ```sh
   git remote set-url origin git@github.com:github_username/repo_name.git
   git remote -v # confirm the changes
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Usage

Here's a guide on how to navigate and use the Neptunus Education System Platform effectively.

### 1. Login/Registration Page

**Description**: When you first access the website, you'll be greeted by the login/registration page. This is where you can either log into your existing account or create a new one.

**Instructions**:
- **Login**: Enter your email and password, then click "Login."
- **Registration**: To create a new account, fill out the registration form with your details and click "Register."

**Screenshot**:
![Login/Registration Page](https://github.com/user-attachments/assets/4ea1c4f5-4be9-40be-b4f2-477fac38dca5)


---

### 2. Landing Page

**Description**: After logging in, you'll be redirected to the landing page. This page features scientific news and a calendar, and it is designed to be responsive across all devices.

**Features**:
- **Scientific News**: View the latest updates in scientific research and developments.
- **Calendar**: Check important dates and upcoming events.

**Screenshot**:
![Landing Page](https://github.com/user-attachments/assets/ed23a808-668f-4577-a305-88c57557610e)

---

### 3. Check Personal Data

**Description**: You can view and manage your personal information from the profile section. Here, you can review and update your profile details as needed.

**Instructions**:
- Navigate to the user profile section.
- Check your personal details and make any necessary updates.

**Screenshot**:
![Personal Data](https://github.com/user-attachments/assets/1d297b58-fa37-410a-a67d-f49c27b3b763)

---

### 4. Check and Submit User Courses

**Description**: The "My Courses" section allows you to view the courses you're enrolled in and manage your submissions.

**Instructions**:
- **View Courses**: Access the list of courses you are enrolled in.
- **Submit Assignments**: Complete and submit your assignments directly from this section.

**Screenshot**:
![User Courses](https://github.com/user-attachments/assets/84614749-fbd2-41a6-9407-f6ad36a6fb38)

---

### 5. Check and Apply to Courses

**Description**: Browse and apply for available courses from the "Course Application" section.

**Instructions**:
- **Browse Courses**: Explore the list of courses you can apply for.
- **Apply**: Select a course and follow the application process.

**Screenshot**:
![Available Courses](https://github.com/user-attachments/assets/d0d283e7-4bec-4e32-8a6a-82109512e96f)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Roadmap

- [ ] User Authentication
- [ ] Data Management
- [ ] Containerization
- [ ] Course Management
- [ ] Scientific News Integration
- [ ] Responsive Design

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Development Methodologies

- **Agile and Scrum**: The project was developed using Agile methodologies and Scrum practices to ensure iterative progress and continuous improvement.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>

