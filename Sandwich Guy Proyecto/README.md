# 🃏 Proyecto Final – The Sandwich Guy  
### Curso: Estructuras de Datos (SC-304)  
### III Cuatrimestre 2025  
### Profesor: Luis Andrés Rojas Matey

---

## 👥 Integrantes del Grupo
- **Joshua Mitchell Navarro** – Carné: FH22012006 – GitHub: @usuario – Email: jmitchell20098@ufide.ac.cr 
- **Jose Alexis Guillen Sandi** 

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
Proyecto/
│ Main.java
│ VentanaPrincipal.java
│ Juego.java
│ Carta.java
│ Palo.java
│ Valor.java
│ Caja.java
│ Mazo.java
│ Mano.java
│ Pozo.java
│ SandwichEvaluator.java
│ ResultadoPermutacion.java
│ NodoTripleta.java
│ ArbolTripletas.java
│ PersistenciaXML.java
│ README.md


No se utilizan packages para facilitar la ejecución desde terminal.

---

## ⚙️ Instalación

1. Instalar **Java JDK 21** desde Oracle u OpenJDK.  
2. Clonar o descargar este repositorio.  
3. Colocar todos los archivos `.java` dentro de la misma carpeta.

---

## 🔧 Compilación

### 🔹 Desde consola (Windows / macOS / Linux)

Navegar al folder del proyecto:

```bash
cd "C:\Users\TU_USUARIO\Desktop\Proyecto Programacion"

Compilar:

javac *.java

▶️ Ejecución

Ejecutar:

java Main


La ventana gráfica de The Sandwich Guy se abrirá automáticamente.

## 💾 Guardar y Cargar Partidas (XML)

El juego permite:

Guardar el estado actual (Caja, Mazo, Mano, Pozo, Estado) en un archivo .xml

Cargar un archivo previamente guardado

Continuar la partida si no está finalizada

Mostrar si el archivo cargado pertenece a una partida ganada o perdida

Los archivos XML se crean usando las clases estándar del módulo java.xml.

🧠 Lógica Principal del Juego
✔ Reglas de Sándwich

Una tripleta es válida si:

La carta central está exactamente “a la misma distancia circular” entre las otras dos.
Ejemplo:

4 – 6 – 8   (distancia 2)
Q – A – 2   (K↔A vuelta → distancia circular correcta)
8 – 8 – 8   (distancia 0)

✔ Cartas a tomar del mazo:

4 → mismo palo

3 → mismo color

2 → distinto color

0 → NO es sándwich válido

🧪 Validación de la Mano

El botón Validar Mano revisa TODAS las combinaciones posibles de 3 cartas:

Si existe al menos un sándwich → la partida continúa

Si NO existe → la partida se marca como PERDIDA

🏆 Condiciones de finalización

Victoria: el mazo queda vacío

Derrota: no hay sándwich posible

El estado se muestra en la interfaz gráfica

📚 Referencias

Documentación oficial de Java 21
https://docs.oracle.com/en/java/javase/21/

API de Java Swing
https://docs.oracle.com/javase/8/docs/api/javax/swing/package-summary.html

Java ArrayDeque y colecciones
https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html

DocumentBuilder / DOM Parser (XML)
https://docs.oracle.com/javase/tutorial/jaxp/dom/

🤖 Prompts de IA utilizados

Generación de interfaz gráfica con Swing

Persistencia con XML y DOM


✔ Estado Final del Proyecto

Este proyecto cumple con:

Todos los componentes funcionales

Todas las estructuras de datos requeridas

Todas las funcionalidades solicitadas

Guardado y carga en XML

Interfaz gráfica completa

Reglas del juego correctamente implementadas

Presentación profesional y lista para evaluación

