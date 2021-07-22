# EDUKLITA

                                    ---------------INTRODUCCIÓN---------------

Este proyecto está orientado a estudiantes de quinto nivel de la carrera de Ingeniería en Ciencias de la Computación,
en el cuál nuestro sistema puede encontrar las siguientes funcionalidades. 
El proyecto cuenta con tres módulos, donde cada usuario va a tener una distinta forma de interactuar con el sistema,
el usuario invitado podrá ver información básica que contiene el sistema, dando un resumen de los indicadores y 
gráficas básicas. Este usuario a su vez podrá registrarse, o ingresar con su cuenta que se haya registrado.
El usuario asignado al módulo reportes podrá crear y publicar los reportes avanzados, mediante la base de datos.
El siguiente módulo de seguridad tendrá la potestad de administrar cada uno de los usuarios registrados, además
tendrá un apartado de auditoría donde podrá guardar el registro de actividades.


                                    ---------------DETALLE DEL PROYECTO---------------

Este proyecto está orientado ha proporcionar información detallada de la economía que dispone el sector educativo, dando a conocer los resultados estadísticos que nos brinda el INEC. La licencia que tiene el programa es: GNU General Public License v3.0. Tiene como propósito que el usuario pueda modificar, visualizar y descargar el código fuente, cada una de estas modificaciones no pueden ser privativas hacia los otros usuarios, ya que así lo especifica la licencia respectivamente utilizada.
El programa está conformado por tres módulos:
1. El primer módulo está orientado a la creación y publicación de reportes avanzados, estos reportes serán presentados en una aplicación web, en el cuál el usuario ingresará o seleccionará los criterios de búsqueda para generar el reporte.
2. El segundo módulo se refiere a acceder sin necesidad de autentificación, indicando información básica de la aplicación para visitantes. Incluye un resumen de los indicadores que maneja el sistema y gráficas básicas, en este módulo los visitantes no pueden crear un reporte.
3. El tercer módulo es el de seguridad, en el cual permite la administración de usuarios (creación de usuarios, cambio de clave, bloqueo de usuarios y consulta de usuarios), guardando el registro de cada actividad realizada en la base de datos.


                                    ---------------PRE-RREQUISITOS---------------

Tener instalado las siguientes herramientas:

1. Integrated Development Environment (IDE), el que se utlizó es Eclipse (versión 2021-03).
2. PostgreSQL (versión 12).
3. PgAdmin (versión 4).
4. Pentaho (versión 8.1.0.0-365).
5. Wildfly (versión 17).

Instalar las siguientes librerías en el IDE:

1. JBOSS 
2. PRIMEFACES


                                    ---------------INSTALACIÓN DEL PROGRAMA---------------
                                    
1. Descargar wildfly versión 17.0.0. Lo puede descargar del siguiente enlace https://www.wildfly.org/downloads/
2. Descargar postgresql versión 42.2.2 
3. Descargar la base de datos y .ear del proyecto.

Pasos para conectarse al servidor.

1. Ejecutar el wildfly, una vez realizado esto se debe ingresar un usuario y contraseña, y luego se debe habilitar.
2. Ingresar a localhost:8080 y dar clic en consola de administración.
3. Ingresar las credenciales creadas anteriormente.
4. Ingresar a deployments --> add deployments --> cargar el archivo postgresql 42.2.2
5. Specify Names dejarlo por defecto --> finalizar.
6. Regresar a home page --> configuration --> start.
7. Ingresar a subsytems --> dataSources & drivers --> datasource.
8. Añadir un nuevo datasource.
9. Escoger la base de datos con la que se va a trabajar en este caso es PostgreSQL.
10. En atributos --> name: se debe poner el nombre de la base de datos en este caso es BD_eduklita --> En JNDI name solo se debe cambiar "PostgresDS" por la base que se va a cargar, en este caso es: java:jboss/BD_eduklita
11. JDBC Driver --> Driver name: postgresql-42.2.2.jar --> lo demás se lo deja por defecto.
12. Connection --> En Connection URL solo se debe cambiar postgresdb por el nombre de la base que va a cargar, en este caso es: jdbc:postgresql://localhost:5432/BD_eduklita
13. En user name y password deben ir las credenciales que se crearon en postgres.
14. Dar clic en test connection, esto verificará si la cadena de conexión está funcionando correctamente.


                                      ---------------PRUEBAS---------------

+++++++++++++++++++++++++POR DESARROLLAR+++++++++++++++++++++++++


                                      ---------------CONSTRUIDO CON---------------

El siguiente sistema fue desarrollado a través de las herramientas de java, jsf, y con una base de datos creada en el gestor de base de datos PostgreSQL, el
modelamiento de las tablas fueron generadas en Sql Power Architect y el desarrollo de la interfaz gráfica del sistema fue construida utilizando PRIMEFACES.


                                      ---------------WIKI---------------

https://patricio23cadena.github.io/EDUKLITAv1/


                                     ---------------VERSIÓN---------------

v1.0


                                      ---------------AUTORES---------------

* Diego Bedoya
* Patricio Cadena
* Freddy Camacho
* Saskia Guerrero

                                     ---------------LICENCIA---------------

Copyright (c) ,  Todos los derechos reservados. 
Se permite la redistribución y el uso en formato fuente y binario, con o sin modificaciones, siempre que se cumplan las siguientes condiciones: 
* Las redistribuciones del código fuente deben conservar el aviso de derechos de autor anterior , esta lista de condiciones y el siguiente descargo de responsabilidad.
* Las redistribuciones en formato binario deben reproducir el aviso de derechos de autor anterior, esta lista de condiciones y el siguiente descargo de responsabilidad en la documentación y / u otros materiales proporcionados con la distribución. 
* Ni el nombre de < organización> ni los nombres de sus colaboradores pueden usarse para respaldar o promover productos derivados de este software sin un permiso previo específico por escrito. ESTE SOFTWARE ES PROPORCIONADO POR LOS TITULARES DE LOS DERECHOS DE AUTOR Y COLABORADORES "TAL CUAL" Y CUALQUIER GARANTÍA EXPRESA O IMPLÍCITA, INCLUYENDO, PERO SIN LIMITARSE A, LAS GARANTÍAS IMPLÍCITAS DE COMERCIABILIDAD Y APTITUD PARA UN PROPÓSITO EN PARTICULAR ESTÁN RENUNCIADAS. EN NINGÚN CASO EL  SERÁ RESPONSABLE DE CUALQUIER DAÑO DIRECTO, INDIRECTO, INCIDENTAL, ESPECIAL, EJEMPLAR O CONSECUENTE (INCLUYENDO, PERO NO LIMITADO A, LA ADQUISICIÓN DE BIENES O SERVICIOS SUSTITUTOS; PÉRDIDA DE USO, DATOS O BENEFICIOS; INTERRUPCIÓN COMERCIAL) SIN EMBARGO Y EN CUALQUIER TEORÍA DE RESPONSABILIDAD, YA SEA POR CONTRATO, RESPONSABILIDAD ESTRICTA O AGRAVIO (INCLUYENDO NEGLIGENCIA O DE OTRA MANERA) QUE SURJA DE CUALQUIER MANERA DEL USO DE ESTE SOFTWARE, AUNQUE SE INDIQUE LA POSIBILIDAD DE DICHO DAÑO.



                                      ---------------AGRADECIMIENTO---------------

A mis ingenieros Patsy Prieto, Gustavo Návas y Ricardo Albarracín; sus conocimientos fueron precisos y sabios en solventar cada una de las dudas generadas
a lo largo del desarrollo del proyecto integrador. Gracias por compartir sus conocimientos de manera profesional, pero sobretodo gracias por su paciencia,
tolerancia y perseverancia inigualable. Por dedicar tiempo en aclarar las dudas que se generan en el proyecto y poder avanzar para dar un buen trabajo.
Agradecemos a la Universidad Politécnica Salesiana, por indicarnos a ser honrados ciudadanos y buenos cristianos, por priorizar los valores de solidaridad,
familiaridad y honestidad.
