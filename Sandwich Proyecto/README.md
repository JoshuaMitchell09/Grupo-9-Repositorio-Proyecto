🃏 The Sandwich Guy — Proyecto Final SC-304 (Estructuras de Datos)
Descripción General

Este proyecto implementa el juego The Sandwich Guy, un juego de cartas para un solo jugador.
El objetivo es aplicar estructuras de datos, lógica de juego, XML y una interfaz gráfica en Java utilizando Swing.

El programa permite:

Crear partidas nuevas.

Cargar partidas existentes desde XML.

Barajar cartas.

Formar tripletas y evaluar sándwiches.

Descartar cartas al Pozo.

Robar cartas del Mazo según reglas.

Ordenar la Mano.

Verificar si la Mano contiene un sándwich válido.

Guardar el progreso de la partida.

Cumple estrictamente con los requerimientos del profesor.

👥 Integrantes del Proyecto
Nombre	Carné	GitHub	Correo
Joshua Mitchell Navarro	FH22012006	TU_USUARIO_GITHUB	TU_CORREO

Si deseas agregar más integrantes, puedo actualizarlo.

🛠️ Tecnologías Utilizadas

Java SE 21 (LTS)

Swing (javax.swing)

java.xml para manejo de archivos XML

CMD / PowerShell

VS Code / IntelliJ IDEA

📦 Estructuras de Datos Implementadas
Componente	Estructura requerida	Implementación
Carta	Clase propia	Carta.java
Caja	Lista doble	LinkedList<Carta>
Mazo	Pila	ArrayDeque<Carta>
Mano	Lista circular	Acceso modular + ArrayList<Carta>
Pozo	Cola	ArrayDeque<Carta> (FIFO)
Permutaciones	Árbol binario	ArbolTripletas.java
✔ Otros módulos importantes:

Evaluación de sándwiches → SandwichEvaluator.java

Persistencia XML → PersistenciaXML.java

Control general del juego → Juego.java

Interfaz gráfica → VentanaPrincipal.java

🎮 Reglas del Juego Implementadas
Un sándwich es válido si:

Una carta está exactamente entre otras dos (considerando el ciclo K → A).

O las tres cartas son del mismo valor.

Recompensas por tipo de sándwich:
Condición	Cartas que se pueden tomar del Mazo
Mismo palo	4
Mismo color	3
Distinto color	2
No válido	0
Fin de la partida:

GANADA:
Si el Mazo queda vacío y ya no hay cartas en Mano.

PERDIDA:
Si la Mano no contiene ningún sándwich válido posible.

🗂️ Arquitectura del Código
/src
 ├── Main.java
 ├── VentanaPrincipal.java
 ├── Juego.java
 ├── Carta.java
 ├── Valor.java
 ├── Palo.java
 ├── Caja.java
 ├── Mazo.java
 ├── Mano.java
 ├── Pozo.java
 ├── ResultadoPermutacion.java
 ├── ArbolTripletas.java
 ├── NodoTripleta.java
 ├── SandwichEvaluator.java
 ├── PersistenciaXML.java

💾 Persistencia mediante XML

El programa guarda:

Caja

Mazo

Mano

Pozo

Estado de la partida

Todo se reconstruye exactamente como estaba al cargar el archivo.

⚙️ Instructivo de Instalación, Compilación y Ejecución
✔ 1. Requisitos previos

JDK 21 instalado

Variables de entorno configuradas

Todos los archivos .java en la misma carpeta

▶️ 2. Instalación

No requiere bibliotecas externas, solo Java 21.

▶️ 3. Compilación (CMD)

Ubícate en el directorio del proyecto:

cd "C:\Users\joshu\OneDrive\Desktop\PROYECTO PROGRAMACION 2"


Elimina compilados anteriores:

del *.class


Compila todo:

javac *.java

▶️ 4. Ejecución
java Main


El programa se abrirá con la interfaz gráfica.

📖 Referencias

Java 21 Documentation
https://docs.oracle.com/en/java/javase/21/

Swing Tutorial
https://docs.oracle.com/javase/tutorial/uiswing/

DOM XML Java
https://docs.oracle.com/javase/tutorial/jaxp/dom/

Explicaciones y ejemplos obtenidos mediante ChatGPT

🤖 Prompts de IA utilizados
"Puedes hacer el programa The Sandwich Guy con todas las estructuras pedidas (lista doble, pila, lista circular, cola, árbol binario) y con interfaz gráfica?"

"Dame el código completo de VentanaPrincipal.java para ocultar y mostrar el mazo y el pozo"

"Corrige este error: reached end of file while parsing"

"Genera el README completo para entregar el proyecto del curso SC-304"

🏁 Estado Final del Proyecto

✔ Interfaz gráfica funcional
✔ Lógica del juego completa
✔ Estructuras de datos implementadas correctamente
✔ Sistema XML listo
✔ Manejo de errores
✔ README para entrega oficial
✔ Proyecto listo para evaluación
