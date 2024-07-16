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

<h1>Resolución del Profesor</h1>

Vista jsp index.jsp:
```jsp
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Tarea 5: Session HTTP</title>
    </head>
    <body>
        <h3>Tarea 5: Session HTTP</h3>
        <p>Hola <%=session.getAttribute("nombre") != null? session.getAttribute("nombre"): "anónimo"%>, bienvenido a la tarea5.</p>

        <form action="/webapp-session-tarea5/guardar-session" method="post">
            <div>
                <label for="color">Ingresa tu nombre de sesión</label>
                <div>
                    <input type="text" name="nombre">
                </div>

            </div>
            <div>
                <input type="submit" value="Enviar">
            </div>

        </form>
    </body>
</html>
```

Clase servlet GuardarNombreSessionServlet:
```java
package org.aguzman.apiservlet.webapp.session.tarea5.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/guardar-session"})
public class GuardarNombreSessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        req.getSession().setAttribute("nombre", nombre);
        resp.sendRedirect(req.getContextPath() + "/perfil-usuario");
    }
}
```

Clase servlet PerfilUsuarioServlet:
```java
package org.aguzman.apiservlet.webapp.session.tarea5.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/perfil-usuario"})
public class PerfilUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = "anónimo";
        if (req.getSession().getAttribute("nombre") != null) {
            nombre = (String) req.getSession().getAttribute("nombre");
        }
        try ( PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Perfil del usuario</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Perfil del usuario " + nombre + "!</h1>");
            out.println("        <ul>");
            out.println("            <li>Username: " + nombre + "</li>");
            out.println("        </ul>");
            out.println("<p><a href=\"" + req.getContextPath() + "/index.jsp\">volver a index</a></p>");
            out.println("    </body>");
            out.println("</html>");
        }
    }
}
```
