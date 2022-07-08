# **Variables de entorno**
```
cloudproject.home=[[RUTA_PROYECTO]]/cloud-project/properties/application
cloudproject.ssl.home=[[RUTA_PROYECTO]]/ssl
cloudproperties.home=[[RUTA_PROYECTO]]/cloud-project/properties/cloud
```
***Ejemplo:*** *cloudproject.home=/media/elvis/Data/Synopsis/evaluacion/synopsis-eval-v4/cloud-project/properties/application*
<br/><br/>

# **Documentación**
[Azure API Management access restriction policiesReference for the access restriction policies available for use in Azure API Management. Provides policy usage, settings, and examples.docs.microsoft.com](https://docs.microsoft.com/en-us/azure/api-management/api-management-access-restriction-policies#ValidateJWT)\
[Enable authentication in your own web API by using Azure AD B2C](https://docs.microsoft.com/en-us/azure/active-directory-b2c/enable-authentication-web-api?tabs=csharpclient)\
[API - Validate JWT](https://docs.microsoft.com/en-us/azure/api-management/api-management-access-restriction-policies#ValidateJWT)
<br/>
[Protect serverless APIs with Azure API Management and Azure AD B2C for consumption from a SPA](https://docs.microsoft.com/en-us/azure/api-management/howto-protect-backend-frontend-azure-ad-b2c)
<br/><br/>

# **Compilacion**
```
path_project="$(pwd)"
cd "${path_project}/compile"
sh compile.sh
```
<br/>

# **Lanzar Servicios**
```
path_project="$(pwd)"
cd "${path_project}/compile/artifacts/cloud-config"
sh start.sh
cd "${path_project}/compile/artifacts/api-clients"
sh start.sh
```
<br/>

# **Detener Servicios**
```
path_project="$(pwd)"
cd "${path_project}/compile/artifacts/api-clients"
sh stop.sh
cd "${path_project}/compile/artifacts/cloud-config"
sh stop.sh
```
<br/>

# **Construir imagenes en docker**
```
path_project="$(pwd)"
cd "${path_project}/docker"
sh docker_compile.sh
```
<br/>

# **Lanzar imagenes de Docker con instancia unica**
```
docker network create tdpsynaks-net
docker run -d -p 8888:8888 --net tdpsynaks-net --name tdpsynaks.server.config boot-cloud-config
docker run -d -e SERVER_CONFIG_URI=http://tdpsynaks.server.config:8888 -p 8080:8080 --net tdpsynaks-net --name tdpsynaks.api.clients boot-api-clients
```
<br/>

# **Detener imagenes de Docker con instancia unica**
```
docker stop tdpsynaks.server.config
docker rm tdpsynaks.server.config
docker stop tdpsynaks.api.clients
docker rm tdpsynaks.api.clients
docker network rm tdpsynaks-net
```