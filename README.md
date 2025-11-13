# 🧾 Student Management System (Java)

A console-based **Student Management System** built using **Java**, demonstrating core **OOP principles** such as abstraction, inheritance, interfaces, and encapsulation.  
The system allows adding, updating, deleting, searching, and viewing student records with an interactive menu-driven interface.

---

## 🚀 Features

- Add a new student with name, email, course, and marks  
- Update course or marks for existing students  
- Delete student records by roll number  
- Search for students by roll number  
- View all student details  
- Auto-grade calculation based on marks:
  - A+ → 90 and above  
  - A → 75–89  
  - B → 60–74  
  - C → 50–59  
  - F → Below 50

---

## 🧩 Project Structure

```
StudentManagementSystem.java
```

### Classes and Interfaces

- **Person (Abstract Class)** → Defines common fields (`name`, `email`) and abstract method `displayInfo()`  
- **Student (Subclass of Person)** → Adds `rollNo`, `course`, `marks`, and `grade`; overrides and overloads `displayInfo()`  
- **RecordActions (Interface)** → Declares core operations like add, delete, update, search, and view  
- **StudentManager (Implements RecordActions)** → Manages all student records using a `HashMap`  
- **StudentManagementSystem (Main Class)** → Provides user interaction through menu options  

---

## ⚙️ How to Run

1. **Clone this repository:**
   ```bash
   git clone https://github.com/SaiVigneshYadav04/Lab-Assignment-02.git
   cd Lab-Assignment-02
   ```

2. **Compile the program:**
   ```bash
   javac StudentManagementSystem.java
   ```

3. **Run the program:**
   ```bash
   java StudentManagementSystem
   ```

---

## 💻 Sample Output

```
Welcome to the Student Management System!
1. Add a new student
2. Update student record
3. Delete a student
4. Search for a student
5. View all students
6. Exit
Enter your option: 1

Enter Roll Number: 101
Enter Full Name: Aryan Mehta
Enter Email Address: aryan@example.com
Enter Course Name: Data Structures
Enter Marks Obtained: 92

Student added successfully with Roll Number: 101

Welcome to the Student Management System!
Enter your option: 5

=== Student Profile ===
Roll Number: 101
Full Name: Aryan Mehta
Email Address: aryan@example.com
Enrolled Course: Data Structures
Obtained Marks: 92.0
Current Grade: A+
=======================
```

---

## 🧠 Concepts Covered

- Abstraction (via abstract class `Person`)  
- Inheritance (`Student` extends `Person`)  
- Interface Implementation (`RecordActions`)  
- Encapsulation (private fields with setters/getters)  
- Method Overriding and Overloading  
- Polymorphism and Dynamic Binding  
- Use of Java Collections (`HashMap`)  
- Clean, modular class-based design  

---
