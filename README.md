<h1 align="center">Tarea: Ingresa tu nombre de sesión</h1>
<p>Ingresa tu nombre de sesión</p>
<p>Para este nuevo desafío se requiere de un formulario y session http para ingresar un nombre de usuario de sesión.</p>
<h2>Requerimientos:</h2>

- Crear un proyecto llamado webapp-session-tarea5
- Crear una vista 'index.jsp' con un title h3 con algún titulo para la tarea.
- Ademas tener un párrafo con el elemento `<p>` con un texto de bienvenida al usuario, si el atributo nombre del objeto `session` no existe, debe mostrar bienvenido anónimo, ejemplo:

`<p>Hola <%=session.getAttribute("nombre") != null? session.getAttribute("nombre"): "anónimo"%>, bienvenido a la tarea5.</p>`

- Además de un pequeño formulario con el campo nombre y un botón enviar.

- El formulario debe ser con `method="post"` y `action="/webapp-session-tarea5/guardar-session"`, ruta del servlet encargado de guardar el nombre en la session http.
- Crear un servlet llamado 'GuardarNombreSessionServlet' mapeado a la ruta `/guardar-session`, con el método `doPost()` el cual recibe el parámetro nombre del request y lo guarda como atributo del objeto session http, luego debe redirigir (con `sendRedirect`) a otro servlet llamado <b>PerfilUsuarioServlet</b> encargado de mostrar el nombre de usuario obteniéndose de la sesion http y un enlace a href para regresar a index.jsp.

<p>Una vez terminada y probada la tarea deberán publicar el código fuente de todos los archivos involucrados, además de las imágenes screenshot (imprimir pantalla).</p>

- Vista index.jsp.
- Clase servlet GuardarNombreSessionServlet.
- Clase servlet PerfilUsuarioServlet.
- Imágenes screenshot del programa funcionando en el navegador.
