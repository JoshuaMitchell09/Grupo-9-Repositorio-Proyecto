# 🃏 Proyecto Final – The Sandwich Guy  
### Curso: Estructuras de Datos (SC-304)  
### III Cuatrimestre 2025  
### Profesor: Luis Andrés Rojas Matey

---

## 👥 Integrantes del Grupo
- **Nombre del estudiante 1** – Carné: XXXXXXX – GitHub: @usuario – Email: correo@example.com  
- **Nombre del estudiante 2 (si aplica)** – Carné: XXXXXXX – GitHub: @usuario – Email: correo@example.com  

> *Los integrantes listados aquí serán los únicos considerados para la calificación, según la rúbrica del curso.*

---

## 📝 Descripción General del Proyecto
**The Sandwich Guy** es un juego de naipes para un jugador que utiliza una baraja estándar de 52 cartas.  
El objetivo del proyecto es aplicar los conocimientos del curso SC-304 mediante el desarrollo de una **aplicación de escritorio en Java (JDK 21)** que cumpla con:

- Manipulación de estructuras de datos avanzadas  
- Manejo de objetos, colecciones y referencias  
- Implementación de lógica no trivial (sándwiches con vuelta)  
- Persistencia de información mediante XML  
- Interfaz gráfica utilizando Swing

La aplicación permite:

- Crear una partida nueva  
- Barajar las cartas y construir el Mazo  
- Mostrar Caja, Mazo, Mano y Pozo  
- Seleccionar tripletas para evaluar sándwiches  
- Ver las 6 permutaciones posibles de la tripleta  
- Clasificar el tipo de sándwich (4, 3, 2 o 0 cartas del mazo)  
- Descartar y robar nuevas cartas automáticamente  
- Validar si existe un sándwich válido en la mano  
- Guardar una partida en un archivo XML  
- Cargar una partida previamente guardada  
- Detectar condiciones de victoria y derrota  

---

## 🧱 Estructuras de Datos Utilizadas (Requisitos del Curso)
El proyecto utiliza las estructuras solicitadas explícitamente en el enunciado:

| Componente | Estructura de Datos | Implementación |
|-----------|----------------------|----------------|
| **Caja** | Lista doble | `LinkedList<Carta>` (doblemente enlazada nativa de Java) |
| **Mazo** | Pila (Stack) | `ArrayDeque.push()/pop()` |
| **Mano** | Lista circular | `ArrayList` con recorrido circular |
| **Pozo** | Cola (Queue) | `ArrayDeque.addLast()` |
| **Permutaciones de tripletas** | Estructura de búsqueda | Árbol binario (BST) propio |
| **Evaluación de sándwich** | Algoritmo propio | Distancia circular con vuelta (K → A) |

Todas las cartas se **instancian una única vez por partida**, tal como exige el enunciado.

---

## 🖥️ Tecnologías, IDEs y Versiones
- **Lenguaje:** Java SE 21  
- **JDK utilizado:** Oracle JDK 21 / OpenJDK 21  
- **IDE recomendado para el proyecto:**  
  - IntelliJ IDEA  
  - Visual Studio Code (Extension Pack for Java)  
- **Librerías usadas:**  
  - Swing (para la interfaz gráfica)  
  - `java.xml` (para manejo de XML)

No se utilizan dependencias externas.

---

## 📂 Estructura del Proyecto

