<%@ page contentType="text/html; charset=UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Delete Pokemon</title>
        <link rel="stylesheet" href="style.css">
    </head>

    <body id="del">
        <h2>Delete Pokemon</h2>

        <% String msg=(String) session.getAttribute("msg"); if (msg !=null) { %>
            <p style="color:red;">
                <%= msg %>
            </p>
            <% session.removeAttribute("msg"); } %>

                <form method="post" action="<%= request.getContextPath() %>/pokemon/del">
                    <label>Name: <input type="text" name="name" required></label><br><br>
                    <center>
                        <button type="submit">Save</button>
                    </center>
                </form>

                <br>
               
                <div>

                <button>
                    <a href="<%= request.getContextPath() %>/">Home</a>
                </button>

                </div>
    </body>

    </html>