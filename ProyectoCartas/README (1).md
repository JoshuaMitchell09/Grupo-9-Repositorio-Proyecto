# 🃏 Proyecto de Juego de Cartas – Avance I

## 👥 Integrante
- **Nombre:** Joshua Mitchell  
- **Carné:** (FH22012006)

## 🔗 Información de Git
- **Usuario de GitHub:** (JoshuaMitchell09)
- **Correo de Git:** (Joshuanavarro897@gmail.com)

## 🧰 IDE Utilizado
- Visual Studio Code 

---

## ⚙️ Instructivo

### 🧩 Instalación
1. Verifica tener instalada la versión más reciente de **Java JDK (17 o superior)**.  
2. Abre el proyecto en tu IDE o desde la terminal.

---

### 🏗️ Compilación
En la terminal, dentro de la carpeta `src`:
```bash
javac Carta.java JuegoCartas.java
Proyecto – Juego de Cartas (Avance II)

Curso: Estructuras de Datos
Fecha de entrega: 24 de noviembre – 17:59:59

👥 Integrantes

Nombre: Joshua Mitchell

Carné: (agrega tu carné aquí)

🛠️ Editores / IDEs utilizados

Visual Studio Code

Java Extension Pack

Git / GitHub (opcional)

📦 Descripción del Proyecto

Este proyecto implementa un modelo básico de un sistema de cartas utilizando estructuras de datos en Java, siguiendo los requerimientos del Avance II.

Las clases principales del proyecto son:

Caja → Contiene las 52 cartas originales (Queue o ArrayList).

Mazo → Cartas barajadas listas para usar (Stack).

Mano → Cartas tomadas por el jugador(s) (ArrayList o LinkedList).

Pozo → Cartas jugadas o descartadas (Stack o Queue).

El proyecto incluye una interfaz gráfica simple (GUI) construida con Java Swing, la cual permite visualizar la Caja y el Mazo, además del botón para barajar, es decir, mover aleatoriamente cartas de la Caja hacia el Mazo.

🃏 Características implementadas
✔️ 1. Estructuras de datos

Caja → ArrayList

Mazo → Stack

Mano → LinkedList

Pozo → Stack

✔️ 2. Interfaz gráfica (GUI - Swing)

Incluye:

Botón Barajar

Vista de cartas en:

Caja

Mazo

Representación textual (no requiere imágenes de cartas reales)

✔️ 3. Lógica de barajado

El botón Barajar ejecuta:

Extraer cartas desde la Caja.

Insertarlas aleatoriamente en el Mazo.

Actualizar visualmente ambas listas.

📥 Instalación
Requisitos previos

Java JDK 17 o superior

Visual Studio Code

Extensiones:

Java Extension Pack

Code Runner (opcional)

▶️ Compilación

En VS Code:

Abre la carpeta del proyecto.

Asegúrate de que existan todos los archivos:

Carta.java
Caja.java
Mazo.java
Mano.java
Pozo.java
JuegoCartasGUI.java
Main.java


Compila presionando:
Ctrl + Shift + B
o el botón Run de VS Code.

También puedes compilar manualmente desde terminal:

javac *.java

🚀 Ejecución

En terminal:

java Main


O en Visual Studio Code presionando el botón Run ▶️ sobre el archivo Main.java.

📚 Notas finales

No es obligatorio usar imágenes reales de cartas en este avance.

Las cartas pueden mostrarse como texto: ejemplo → "AS de Corazones", "10 de Tréboles".

La GUI solo debe mostrar listas y permitir barajar.
