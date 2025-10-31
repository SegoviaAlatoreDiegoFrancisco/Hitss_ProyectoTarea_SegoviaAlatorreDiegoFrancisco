#  Gestor de Tareas - Task Manager

Aplicación CRUD para gestionar tareas usando Spring Boot.

##  Funcionalidades Implementadas

- [x] Crear tarea (`POST /tasks`)
- [x] Listar tareas (`GET /tasks`)
- [x] Actualizar tarea (`PUT /tasks/{id}`)
- [x] Eliminar tarea (`DELETE /tasks/{id}`)
- [x] Buscar tarea por Id(`GET /task/{id}`)

##  Evidencias

Las pruebas fueron realizadas con Postman. A continuación se muestran ejemplos de cada operación:

- **Crear tarea**: ![crear](img/task/create_task.png)
- **Listar tareas**: ![listar](img/task/list_tasks.png)
- **Actualizar tarea**: ![actualizar](img/task/update_task.png)
- **Eliminar tarea**: ![eliminar](img/task/delete_task.png)
- **Buscar por id tarea**:[buscar](img/task/get_task_byid.png)

##  Pendientes por implementar

- [ ] Seguridad con Spring Security y JWT
- [ ] Rol USER con permisos limitados
- [ ] Documentación con Swagger
- [ ] Manejo de errores personalizado

