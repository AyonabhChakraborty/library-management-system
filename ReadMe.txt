# Library Management System

## Overview

This project is a console-based Library Management System developed in Java using Object-Oriented Design principles and Design Patterns.

The system allows:

* Adding books to the inventory
* Removing books from the inventory
* Searching books by:

  * Title
  * Author
  * ISBN
* Registering patrons
* Borrowing books
* Returning books
* Tracking borrowed books using a mapper
* Notifying observers when books are borrowed or returned

---

## Design Patterns Used

### 1. Singleton Pattern

Used in:

* InventoryManager

Purpose:

Ensures that only one inventory management instance exists throughout the application.

---

### 2. Strategy Pattern

Used in:

* SearchInterface
* SearchByTitle
* SearchByAuthor
* SearchByISBN

Purpose:

Allows searching books using interchangeable search algorithms without modifying existing code.

---

### 3. Observer Pattern

Used in:

* Observer
* InventoryObserver
* PatronObserver

Purpose:

Allows the system to notify interested parties whenever important events occur.

Example Events:

* BOOK_BORROWED
* BOOK_RETURNED

---

## Project Structure

books/

* Book
* BookManager

users/

* User
* PatronManager
* BookToUserMapper

inventory/

* InventoryManager

inventory/searchpackage/

* SearchInterface
* SearchByTitle
* SearchByAuthor
* SearchByISBN

observer/

* Observer
* Event
* InventoryObserver
* PatronObserver

library/

* Library

Main.java

---

## Class Responsibilities

### Book

Represents a book in the library.

Attributes:

* bookId
* title
* author
* isbn
* publicationYear
* genre
* availability

---

### User

Represents a library patron.

Attributes:

* userId
* name
* email

---

### BookManager

Maintains the inventory of books.

Responsibilities:

* Add books
* Remove books
* Search books

---

### PatronManager

Maintains library users.

Responsibilities:

* Add users
* Remove users

---

### BookToUserMapper

Maintains borrowing relationships.

Data Structure:

Map<UserId, List<BookId>>

Example:

User 101

Borrowed Books:

* Book 1
* Book 5
* Book 8

---

### InventoryManager

Handles lending operations.

Responsibilities:

* Borrow books
* Return books
* Update availability status

---

### Search Strategies

SearchByTitle

Searches books using title.

SearchByAuthor

Searches books using author.

SearchByISBN

Searches books using ISBN.

---

### Observer System

Observer

Common observer interface.

InventoryObserver

Receives inventory-related notifications.

PatronObserver

Receives patron-related notifications.

Event

Transfers event information across observers.

---

### Library

Acts as the central coordinator.

Responsibilities:

* Manage observers
* Coordinate book borrowing
* Coordinate book returning
* Notify observers

---

## Class Diagram

```text
                    +----------------+
                    |    Library     |
                    +----------------+
                     |      |      |
                     |      |      |
                     v      v      v

            +-------------+   +------------------+
            | BookManager |   | PatronManager    |
            +-------------+   +------------------+
                   |                    |
                   |                    |
                   v                    v

             +---------+         +-----------+
             |  Book   |         |   User    |
             +---------+         +-----------+

                    ^
                    |
                    |
          +-------------------+
          | InventoryManager  |
          +-------------------+
                    |
                    |
                    v

          +-------------------+
          | BookToUserMapper  |
          +-------------------+

Library
   |
   | notifies
   v

+----------------+
|   Observer     |
+----------------+
        ^
        |
  -------------------
  |                 |
  v                 v

+----------------+   +----------------+
|InventoryObserver|  |PatronObserver |
+----------------+   +----------------+

BookManager
      |
      | uses
      v

+----------------+
|SearchInterface |
+----------------+
        ^
        |
------------------------------
|             |              |
v             v              v

SearchByTitle SearchByAuthor SearchByISBN
```

---

## Sample Flow

Borrow Book

1. User selects a book.
2. Library delegates request to InventoryManager.
3. InventoryManager marks book unavailable.
4. BookToUserMapper stores borrowing information.
5. Library creates a BOOK_BORROWED event.
6. Registered observers receive updates.

Return Book

1. User returns a book.
2. InventoryManager updates mapper.
3. InventoryManager marks book available.
4. Library creates a BOOK_RETURNED event.
5. Observers receive updates.

---

## Future Improvements

* Waiting list support
* Fine calculation
* Reservation system
* Persistent database storage
* Authentication and authorization
* GUI implementation
* REST API implementation
* Email notifications
