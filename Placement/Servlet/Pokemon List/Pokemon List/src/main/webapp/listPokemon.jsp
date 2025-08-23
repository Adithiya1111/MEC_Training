<%@ page import="java.util.*,com.example.Pokemon" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Pokemon List</title>
  <link rel="stylesheet" href="style.css">
</head>
<body id="list">
  <h2>Pokemon</h2>

  <%
    List<Pokemon> pokemon = (List<Pokemon>) request.getAttribute("pokemon");
    if (pokemon == null || pokemon.isEmpty()) {
  %>
      <p>No Pokemons yet.</p>
  <%
    } else {
  %>
      <table border="1" cellpadding="6" cellspacing="0">
        <tr>
          <th>ID</th><th>Name</th><th>Rarity</th>
        </tr>
        <%
          for (Pokemon pok : pokemon) {
        %>
            <tr>
              <td><%= pok.getId() %></td>
              <td><%= pok.getName() %></td>
              <td><%= pok.getRarity() %></td>
            </tr>
        <%
          }
        %>
      </table>
  <%
    }
  %>

<br>
<br>

  <div>
  <div class="button">
    <button>
      <a href="<%= request.getContextPath() %>/addPokemon.jsp">Add Pokemon</a>
    </button>

    <button>
      <a href="<%= request.getContextPath() %>/">Home</a>
    </button>
  </div>

  </div>

</body>
</html>
