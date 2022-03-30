# IPAU Servicio de seguridad

Este repositorio contiene un servicio backend de seguridad que utiliza el framework de **Autenticación** y **Autorización OAuth2**.

## Descripción

Este servicio contiene los siguientes módulos:
- `clients`: Contiene un cliente **Feign** para la comunicación con el microservicio de usuarios
- `security`: contiene las siguientes clases:
    - `AuthorizationServerConfig`: encargado de la autenticación de los usuarios, y retorna **JWT** en el caso de éxito. Ese **JWT**, luego el usuario podrá usarlo para acceder a los demás recursos.
    - `SpringSecurityConfig`: clase de configuración, nos va a ayudar a la codificación de passwords.
    - `InfoAdicionalToken`: clase de utilidad que nos permite agregar más información al token.
