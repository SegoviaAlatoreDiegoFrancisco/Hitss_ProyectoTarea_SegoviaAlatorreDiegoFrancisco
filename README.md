#  Gestor de Tareas - Task Manager

Aplicación CRUD para gestionar tareas usando Spring Boot.

##  Funcionalidades Implementadas

- [x] Crear tarea (`POST /tasks`)
- [x] Listar tareas (`GET /tasks`)
- [x] Actualizar tarea (`PUT /tasks/{id}`)
- [x] Eliminar tarea (`DELETE /tasks/{id}`)
- [x] Buscar tarea por Id(`GET /task/{id}`)

- [x] Crear usuario (`POST /users/register`)
- [x] Listar usuarios (`GET /users/`)
- [x] Buscar Usuario (`GET /users/{id}`)

- [x] Documentación con Swagger

##  Evidencias Task's

Las pruebas fueron realizadas con Postman. A continuación se muestran ejemplos de cada operación:

- **Crear tarea**: ![crear](img/task/create_task.png)
- **Listar tareas**: ![listar](img/task/list_task.png)
- **Actualizar tarea**: ![actualizar](img/task/update_task.png)
- **Eliminar tarea**: ![eliminar](img/task/delete_task.png)
- **Buscar por id tarea**:![buscar](img/task/get_task_byid.png)

##  Evidencias User's
- **Crear usuario**: ![crear](img/user/create_user.png)
- **Listar usuarios**: ![listar](img/user/list_users.png)
- **Buscar usuario por Id**: ![buscar](img/user/get_user_byid.png)

##  Pendientes por implementar

- [ ] Seguridad con Spring Security y JWT
- [ ] Rol USER con permisos limitados
- [ ] Manejo de errores personalizado

