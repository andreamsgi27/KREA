# PROYECTO KREA
(Kevin Rubén Estefany Andrea/Acacia)

**EQUIPO**
- KEVIN BOY: Product Owner & Developer [https://github.com/sealkboy]
- RUBEN BLANCO: Developer [https://github.com/Ruben-BV]
- ESTEFANY OCHOA: Developer [https://github.com/SergioTorrico]
- ANDREA MARTINEZ: Developer [https://github.com/andreamsgi27]
- ACACIA SÁNCHEZ: Scrum Master & Developer []


## SUPPORT APP

*Una startup nos ha solicitado la construcción de una aplicación que sea capaz de registrar las solicitudes de los empleados para que puedan pedir soporte técnico a su departamento informático en caso de necesidad.*

### REQUISITOS EXIGIDOS POR EL CLIENTE

- La solicitud contendrá los siguientes datos: nombre del solicitante, fecha de la solicitud, tema de la consulta, descripción.
- Los empleados podrán crear nuevas solicitudes de soporte técnico, visualizarlas, y actualizarlas.
- El departamento técnico debe poder solicitar todas la solicitudes en orden de creación (ASC).
- El departamento técnico debe saber si una solicitud está en curso.
- El departamento técnico debe poder marcar una solicitud como atendida, en curso o finalizada.
- El departamento técnico debe poder saber cuando de efectuó la asistencia.
- El departamento técnico debe poder editar una solicitud ya registrada.
- El departamento técnico debe poder eliminar una solicitud siempre y cuando está haya sido marcada previamente como finalizada.


### EXTRAS NO EXIGIDOS

Se hizo TODO lo posible para que el manejo y visualización de la app fuera lo más visual y cómoda posible, ya que al ser por consola sino sería bastante enfarragoso

- Menús
    - Muy visuales (pese a ser por consola), con colores
    - Con opciones para que nunca se salga de la app por errores
    - Con opciones de vuelta atrás para un fácil movimiento por los menús
- Listados de solicitudes muy visuales
   
*********************************************************
*********************************************************
*********************************************************    
# FUNCIONAMIENTO DE LA APP

Al arrancar pregunta si eres Empleado o Técnico, ya que vas a ser los dos posibles usuarios, y cada uno tendrá unas opciones distintas de uso de la app

**MENU EMPLEADO**
1. Crear solicitud
    - Aquí se rellena la solicitud al departamento técnico según las exigencias del cliente (la fecha no la pide, pues se rellena con la del día)
2. Obtener solicitud
    - Aquí muestra la solicitud indicada por el número de id que pide la app
3. Actualizar solicitud
    - Aquí se pueden actualizar los campos anteriormente ingresados en la solicitud
4. Eliminar solicitud
    - Como claramente dice, se puede eliminar una solicitud
5. Listar solicitudes
    - Imprime en pantalla un listado de todas las solicitudes, con el estado de cada una
6. Salir
    - No necesita explicación...

**MENU TECNICO**
1. Ver solicitudes
    - Imprime en pantalla un listado de todas las solicitudes, con el estado de cada una
2. Cambiar estado de Solicitud
    - Cuando se crea una solicitud queda marcada como "Pendiente", aquí el técnico puede cambiarla a 
        - Atendida
        - En Curso
        - Finalizada
3. Actualizar Solicitud
    - Aquí se pueden actualizar los campos anteriormente ingresados en la solicitud
4. Eliminar Solicitud
    - Tal y como solicita el cliente, solo se puede eliminar después de marcar la solicitud como finalizada
5. Salir
    - No necesita explicación...

*******************************************
*******************************************

### TECNOLOGIAS UTILIZADAS

- Java 21 SE
- Visual Studio Code
- GitHub
- Trello
- Slack
- Canva
- LucidChart
- Draw.io


### ENTREGADO AL CLIENTE

- Repositorio de GitHub [https://github.com/andreamsgi27/KREA]
- Presentación del proyecto:
  - Funcionamiento de la app
  - Captura de pantalla del diagrama UML o enlace pública del archivo de http://diagrams.net



