![image](https://github.com/user-attachments/assets/56f630b9-90fc-4918-8181-3866a2334c42)

# 📒 Agenda de Contactos en Java


Aplicación de consola para **gestionar contactos y empresas**, desarrollada íntegramente en **Java (POO)**.  
Permite almacenar personas, empresas y asignar múltiples contactos a cada empresa, con distintos buscadores y manejo robusto de excepciones.

---

## ✨ Funcionalidades

- **ABM de Personas** (alta, baja, modificación, listado)
- **ABM de Empresas** con múltiples contactos
- Buscadores:
  - Por **nombre**, **ciudad**, o **combinaciones** (ej. “Juan Pérez” en *Buenos Aires* y *Córdoba*)
- Gestión de **excepciones** para entradas inválidas
- Datos almacenados **en memoria** (listas) → sin persistencia externa
- Arquitectura **MVC** (`modelo/`, `controlador/`, `vista/`)

---

## 🗂️ Estructura del repositorio

```
Proyecto-en-Java/
├── Agenda/
│   ├── src/
│   │   ├── backend/
│   │   │   ├── modelo/            # Clases Persona, Empresa, etc.
│   │   │   ├── controlador/       # Lógica de la agenda
│   │   │   └── persistenciaMemoria/ # Listas en memoria
│   │   └── vista/                 # Interfaz por consola
│   └── .project                   # Config. Eclipse
└── LICENSE
```

---

## 🚀 Cómo ejecutar

1. **Clonar** el repo:
   ```bash
   git clone https://github.com/bobadillaFacundo/Proyecto-en-Java.git
   cd Proyecto-en-Java/Agenda
   ```

2. **Compilar** (JDK 17+):
   ```bash
   javac -d out $(find src/backend/src -name "*.java")
   ```

3. **Ejecutar** la app de consola:
   ```bash
   java -cp out vista.Main
   ```

> 💡 También puedes **importar** el proyecto en **Eclipse / IntelliJ** como proyecto Java estándar y ejecutar `vista.Main`.

---

## 📌 Requisitos

- **JDK 17** o superior  
- (Opcional) Eclipse/IntelliJ IDEA para IDE

---

## 🖼️ Diagrama Entidad‑Relación

El proyecto incluye el directorio **`backend/Der/`** con el DER en formato `.png` para entender la relación entre entidades.

---

## 📄 Licencia

Proyecto liberado bajo **MPL‑2.0**.

---

## 👨‍💻 Autor

*Facundo Bobadilla* · [GitHub](https://github.com/bobadillaFacundo)

¡Se aceptan issues y PRs! ⭐

#  Proyecto-en-Java
Es una agenda sencilla, basada en el siguiente requisito:     
 * Deberá implementar la funcionalidad básica de una agenda:
 -Se pondrá almacenar datos sobre personas como también datos sobre empresas y los contactos de esta. 
 -Al agregar un contacto a la empresa, este debe haber sido anteriormente agregado a la agenda. -Una empresa podría tener varios contactos. 
 -Debe implementar distintos tipos de buscadores de personas, por ejemplo buscar por nombre, o ciudad. 
 -Agregar un buscador que permita encontrar personas en varias ciudades, por ejemplo, todos los 'Juan Porez' de 'Buenos Aires' y 'Córdoba'. 
 - La agenda tendrá que implementar el manejo de excepciones correctamente. 
 -Deberá diseñar u Diagrama de Entidad Relación para la solución. -Deberá ejecutarse por consola y se almacenarán los datos en memoria. 
 •	© 2021 GitHub, Inc.
