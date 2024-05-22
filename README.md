## Requisitos

- **********************Java JDK 17:********************** Asegúrate de tener Java JDK 17 instalado en tu sistema en caso contrario puedes modificar el archivo [pom.xml](https://github.com/FaberGG/PryFarmaciaEstructuras/blob/main/pom.xml)
- ************Maven:************ Necesitarás Maven para compilar y ejecutar el proyecto.

---

## Instalación y Ejecución

1. **Clona el Proyecto**: Abre una terminal y ejecuta el siguiente comando para clonar el proyecto:
    
    ```bash
    git clone https://github.com/FaberGG/PryFarmaciaEstructuras.git
    ```
    
2. **Accede a la Carpeta del Proyecto**:
    
    ```bash
    cd PryFarmaciaEstructuras
    ```
    
3. **Ejecuta `clean install` con Maven**:
    
    Antes de ejecutar la aplicación, es recomendable realizar una limpieza del proyecto y construirlo. Utiliza el siguiente comando Maven:
    
    ```bash
    mvn clean install
    ```
    
    Este comando eliminará cualquier compilación anterior, descargar las dependencias necesarias y compilará el proyecto. Además, generará los artefactos en la carpeta `target`.
    
4. **Ejecuta la Aplicación**:
    
    Una vez completado el paso anterior, puedes ejecutar la aplicación con el siguiente comando:
    
    ```bash
    mvn exec:java
    ```
    
    Esto iniciará la aplicación.
    
    ¡Listo! Ahora has clonado, limpiado, construido y ejecutado el proyecto correctamente.
    

---

## Contribución al Proyecto

### Instrucciones para Colaborar

1. **Clonar el Repositorio**: Abre una terminal y ejecuta el siguiente comando para clonar el proyecto:
    
    ```bash
    git clone https://github.com/FaberGG/PryFarmaciaEstructuras
    ```
    
2. **Acceder a la Carpeta del Proyecto**:
    
    ```bash
    cd PryFarmaciaEstructuras
    ```
    
3. **Realizar Cambios y Verificar Estado**: Haz las modificaciones necesarias en el código. Para verificar el estado de tus cambios, utiliza el siguiente comando:
    
    ```bash
    git status
    ```
    
4. **Agregar Cambios al Staging Area**: Añade los archivos modificados al área de preparación con el siguiente comando:
    
    ```bash
    git add .
    ```
    
5. **Realizar Commit con Mensaje Descriptivo**: Realiza un commit con un mensaje claro que describa tus cambios:
    
    ```bash
    git commit -m "Descripción detallada de los cambios realizados"
    ```
    
6. **Subir Cambios al Repositorio Remoto**: Sube tus cambios al repositorio remoto en GitHub:
    
    ```bash
    git push origin nombre-de-tu-rama
    ```
    
7. **Solicitar Pull Request**: Si estás trabajando en una rama diferente, ve a GitHub y crea un Pull Request para que tus cambios se fusionen con la rama principal.

Siguiendo estos pasos, podrás colaborar de manera segura y efectiva en el proyecto. ¡Gracias por tu contribución!
