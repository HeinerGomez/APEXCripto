# Prueba APEX GLOBAL MOBILITY

Se presenta una aplicación la cual consulta el listado de las criptomonedas ordenadas por
su raking y al dar click en alguna de ellas podremos ver el detalle de la misma

## Tecnologias y Arquitecturas implementadas

- Jetpack Compose
- Clean Architecture
- Coroutines
- MutableState
- MVVM
- Retrofit
- Coil
- Dagger Hilt
- Lottie
- Project Modularization
- Gradle KTS
- API Paprika ( API de criptomonedas )

## Video Demostrativo

https://github.com/HeinerGomez/APEXCripto/assets/27563731/9f990f68-44b8-42e0-a8b2-d1bb6fa37cc6


## Instalación

- *PASO 1:* Clonar el proyecto y tenerlo de manera local
- *PASO 2:* Abrir el proyecto en android studio y dejar que se descarguen las dependencias
- *PASO 3:* Ir a Android Studio > Settings > En el apartado de Gradle, verificar que se este usando la versión de java 18.0.2 o superior
- *PASO 4:* Ir a File > Project Structure, Verificar en el apartado de project que se este usando la versión 8.4 de gradle.
- *PASO 5:* Sincronizar el proyecto y ya se podría ejecutar.

## Notas

- la aplicación conserva su estado si el telefono es cambiado de orientación
- procesos en segundo plano se manejaron con coroutines
- se realizarón ✔️ 3 test que se encuentran en el package app, en los cuales se cubrieron los casos de uso
- el proyecto quedó modularizado creando los siguientes módulos: app, shared, presentation, buildSrc(para configuración del proyecto), data, domain
- se crearon componentes reutilizables en jetpack compose
- se uso el API de paprika para crear un listado de criptomonedas con su detalle
