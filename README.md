# Refactoring - Validador de documentos
El objetivo de este ejercicio es refactorizar este código aplicando:

- Limpieza de Code Smells
- Aplicación de Principios Solid
- Aplicación de Patrones de diseño.


Clonar el repositorio y realizar vuestra propia versión.
En un documento explicar, como resumen, el enfoque de vuestra solución y principios que habéis aplicado.

Lo que más tiempo me ha llevado ha sido la extracción de código y de mejorar la legibilidad de 
las condiciones que pedia la logica del programa. Los principios SOLID y Code Smells usados principalmente son
los siguientes:


### Principios SOLID usados:
- **Principio de responsabilidad única:** Con la creación de métodos con finalidades sencillas y únicas para hacerlo más legible y que sea un código entendible.
- **Principio de sustitución de Liskov:** Todas las clases requieren lo mismo que la clase padre.
- **Principio de Inversión de Dependencias:** Con la implementación directa hacia una abstracción, en este caso las 3 subclases (DNI, NIE y CIF) con Document

### Code Smells usados:
- **Long Method**, para extraer los métodos, que eran excesivamente grandes.
- **Long Classes:** Separación de clases, ya que una clase hacia lo que podían hacer 3 mejor distribuidas.
- **Primitive Obsession:** Creación de objetos del tipo de documento.
- **Switch Statements**, implementación de las clases DNI, NIE y CIF heredadas de una clase abstracta Documento, para evitar tener que hacer ifs entre los tipos de documentos.
- **Shotfun Surgey**, creación de variable que se usa en más de una ocasión, para evitar tener que cambiarla x veces si se cambia esa variable.
- **Comments**, corrección del código en general, para mejorar su legibilidad y eliminar los comentarios, los cuales algunos eran erróneos.
- **Duplicate code:** eliminación de código duplicado, extrayendo los métodos, o directamente eliminandolos.
- **Dead Code**, eliminación de código inservible.
- **Speculative Generality**, eliminación de condiciones comentadas.

###### Alejandro Planells Geraldo

  