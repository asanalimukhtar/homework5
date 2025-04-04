# Design Patterns Homework: Proxy & Flyweight Patterns

This repository contains code implementations for two real-world cases using design patterns:

1. **Proxy Pattern** for a real estate image management system.
2. **Flyweight Pattern** for a map application rendering thousands of location markers.

Both implementations include code along with brief explanations of the problems solved and how each pattern improves usability, performance, and maintainability.

---

## 1. Proxy Pattern – Real Estate Image Management

### Problem Solved
In a real estate image management system, agents upload high-resolution images that can be very heavy. Loading these images immediately slows down the website. The Proxy Pattern solves this by displaying low-resolution thumbnails immediately and loading the full-resolution image only when requested (e.g., when a user clicks to zoom). Additionally, a protection proxy ensures that only authorized agents can upload or replace images.

### How the Pattern Simplifies the Design
- **Lazy Loading:** The proxy delays the loading of heavy images until needed, reducing initial load times and saving resources.
- **Separation of Concerns:** The protection proxy encapsulates security checks separately from image handling, making the system more modular and easier to maintain.
- **SOLID Principles:** The design adheres to principles like SRP and DIP by keeping responsibilities focused and depending on abstractions rather than concrete implementations.

### Code Structure
- **Interface (`Img`):** Defines common methods for image handling
- **Real Image Class (`RealImg`):** Loads and displays high-resolution images
- **Lazy Loading Proxy (`ImgProxy`):** Shows a low-res thumbnail immediately and loads the full image on demand
- **Protection Proxy (`AuthProxy`):** Restricts image upload and replacement to authorized users

      @startuml
      interface Img {
      +showThumb()
      +zoom()
      +up(file)
      +change(file)
      }

      class RealImg {
      -name: String
      +RealImg(name: String)
      +showThumb()
      +zoom()
      +up(file)
      +change(file)
      }

      class ImgProxy {
      -name: String
      -real: RealImg
      +ImgProxy(name: String)
      +showThumb()
      +zoom()
      +up(file)
      +change(file)
      }

      class AuthProxy {
      -img: Img
      -isLoggedIn: boolean
      +AuthProxy(img: Img, isLoggedIn: boolean)
      +showThumb()
      +zoom()
      +up(file)
      +change(file)
      }

      Img <|.. RealImg
      Img <|.. ImgProxy
      Img <|.. AuthProxy
      @enduml

---

## 2. Flyweight Pattern – Map Marker Optimization

### Problem Solved
A map application that displays thousands of location markers (e.g., gas stations, restaurants, hospitals) would consume too much memory if each marker stored its own style data. The Flyweight Pattern solves this by sharing common style properties (icon, color, label style) among all markers, thus reducing memory usage.

### How the Pattern Simplifies the Design
   - **Memory Optimization:** Shared marker style objects mean that thousands of markers only reuse a few unique style objects.
   - **Improved Performance:** Less memory usage and object duplication result in faster rendering of maps.
   - **Modularity:** The design separates intrinsic state (shared style data) from extrinsic state (position data), aligning with SOLID principles by decoupling concerns.

### Code Structure
   - **Interface (Marker):** Declares a method to draw the marker
   - **Concrete Flyweight (MapMarker):** Implements shared style properties (icon, color, label style) and the draw method
   - **Flyweight Factory (MarkerFactory):** Manages creation and reuse of marker style objects
   - **Client (MapApp):** Demonstrates drawing thousands of markers and logs unique style counts versus total markers
   
    @startuml
    interface Marker {
    +draw(x, y)
   

    class MapMarker {
    -type: String
    -icon: String
    -color: String
    -labelStyle: String
    +MapMarker(type, icon, color, labelStyle)
    +draw(x, y)
    }

    class MarkerFactory {
    -markers: Map<String, Marker>
    +getMarker(key)
    +getUniqueMarkerCount()
    }

    MapMarker ..|> Marker
    MarkerFactory --> Marker
    @enduml

