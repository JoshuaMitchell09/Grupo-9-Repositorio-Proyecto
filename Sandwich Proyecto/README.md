# 🃏 Proyecto Final – The Sandwich Guy  
### Curso: Estructuras de Datos (SC-304)  
### III Cuatrimestre 2025  
### Profesor: Luis Andrés Rojas Matey

---

## 👥 Integrantes del Grupo
- **Joshua Mitchell Navarro** – Carné: FH22012006 – Email: jmitchell20098@ufide.ac.cr

> *Los integrantes listados aquí serán los únicos considerados para la calificación, según la rúbrica del curso.*

---

## 📝 Descripción General del Proyecto
**The Sandwich Guy** es un juego de naipes para un solo jugador que utiliza una baraja estándar de 52 cartas.  
El objetivo del proyecto es aplicar los conocimientos del curso SC-304 mediante la creación de una **aplicación de escritorio en Java (JDK 21)** que implemente:

- Estructuras de datos avanzadas  
- Manipulación de objetos y referencias  
- Lógica de evaluación de sándwiches  
- Persistencia de información en XML  
- Interfaz gráfica con Swing  

La aplicación permite:

- Crear una partida nueva  
- Barajar las cartas y generar el Mazo  
- Mostrar Caja, Mazo, Mano y Pozo  
- Seleccionar y evaluar tripletas  
- Ver las 6 permutaciones posibles de la tripleta  
- Clasificar el tipo de sándwich (4, 3, 2 o 0 cartas del mazo)  
- Descartar y robar cartas automáticamente  
- Validar si la Mano posee un sándwich válido  
- Guardar y cargar partidas mediante XML  
- Mostrar victoria o derrota según reglas del juego  

---

## 🧱 Estructuras de Datos Utilizadas

| Componente | Estructura de Datos | Implementación |
|-----------|----------------------|----------------|
| **Caja** | Lista doble | `LinkedList<Carta>` |
| **Mazo** | Pila (Stack) | `ArrayDeque.push()` / `pop()` |
| **Mano** | Lista circular | `ArrayList` con índices modulares |
| **Pozo** | Cola (Queue) | `ArrayDeque.addLast()` |
| **Permutaciones** | Árbol binario | `ArbolTripletas` (BST propio) |
| **Evaluación de sándwich** | Algoritmo propio | Distancia circular (K → A) |

Cada carta se **instancia una sola vez por partida**, cumpliendo el mandato del enunciado.

---

## 🖥️ Tecnologías, IDEs y Versiones
- **Lenguaje:** Java SE 21  
- **Librerías:** Swing, java.xml  
- **IDEs utilizados:**  
  - IntelliJ IDEA  
  - Visual Studio Code  
- **No se utilizan dependencias externas.**

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

yaml

> No se usan *packages* para facilitar la compilación desde consola.

---

## ⚙️ Instalación
1. Instalar Java **JDK 21** (Oracle u OpenJDK).  
2. Descargar o clonar este repositorio.  
3. Asegurar que todos los archivos `.java` estén en la misma carpeta.

---

## 🔧 Compilación

### 🔹 Desde Consola (CMD / Terminal)

Navegar al proyecto:

```bash
cd "C:\Users\TU_USUARIO\Desktop\Proyecto"
Compilar:

bash
Copy code
javac *.java
▶️ Ejecución
bash
Copy code
java Main
La interfaz gráfica de The Sandwich Guy se abrirá automáticamente.

## 💾 Guardar y Cargar Partidas (XML)

El juego permite:

- Guardar el estado actual (**Caja, Mazo, Mano, Pozo y Estado**) en un archivo `.xml`.  
- Cargar una partida previamente guardada.  
- Continuar la partida si aún no ha finalizado.  
- Mostrar si la partida cargada estaba **ganada**, **perdida** o **en progreso**.  

---

## 🧠 Lógica Principal del Juego

### ✔ Reglas de Sándwich

Una tripleta es válida si:

- La carta central está exactamente a la **misma distancia circular** entre las otras dos.  
- Se permite la vuelta circular (**K → A → 2**).  
- Las tres cartas pueden ser del **mismo valor**.  

---

### ✔ Cantidad de cartas que se pueden tomar del mazo

| Tipo de sándwich | Cartas del mazo |
|------------------|-----------------|
| Mismo palo       | 4 |
| Mismo color      | 3 |
| Diferente color  | 2 |
| No válido        | 0 |

---

## 🧪 Validación de la Mano

Al presionar **Validar Mano**, el programa revisa **todas** las combinaciones posibles de 3 cartas:

- Si existe al menos un sándwich válido → la partida continúa.  
- Si no existe ninguno → la partida se marca como **PERDIDA**.  

---

## 🏆 Condiciones de Finalización

### ✔ Victoria  
La partida se gana cuando el Mazo queda vacío y no hay más cartas que robar.

### ✔ Derrota  
La partida se pierde cuando la Mano no contiene **ningún sándwich posible**.

El estado se actualiza y se muestra en pantalla en tiempo real.

---

## 📚 Referencias

- **Documentación de Java SE 21:**  
  https://docs.oracle.com/en/java/javase/21/

- **API de Swing:**  
  https://docs.oracle.com/javase/8/docs/api/javax/swing/package-summary.html

- **Uso de ArrayDeque y Colecciones:**  
  https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html

- **Parser XML (DOM – java.xml):**  
  https://docs.oracle.com/javase/tutorial/jaxp/dom/

---

## ✔ Estado Final del Proyecto

Este proyecto cumple con:

- Todas las estructuras de datos solicitadas  
- Todas las funcionalidades del enunciado  
- Reglas del juego implementadas correctamente  
- Interfaz gráfica 100% funcional  
- Guardado y carga mediante XML  
- Código organizado, modular y documentado  
- Proyecto completamente listo para evaluación final  
