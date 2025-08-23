<%@ page contentType="text/html; charset=UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Update Pokemon</title>
        <link rel="stylesheet" href="style.css">
    </head>

    <body id="upd">
        <h2>Update Pokemon</h2>

        <% String msg=(String) session.getAttribute("msg"); if (msg !=null) { %>
            <p style="color:red;">
                <%= msg %>
            </p>
            <% session.removeAttribute("msg"); } %>

                <form method="post" action="<%= request.getContextPath() %>/pokemon/upd">
                    <label>Name: <input type="text" name="name" required></label><br><br>
                    <label>Rarity: <input type="text" name="rarity" required></label><br><br>
                    <label>Id: <input type="number" name="idString" required></label><br><br>
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