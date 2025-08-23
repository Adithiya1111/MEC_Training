<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Pokemon</title>
  <link rel="stylesheet" href="./style.css">
</head>
<body>
  <h2>Pokemon List</h2>

  <div>
    <img src="./images/pokemon.jpg" alt="pokemon" width="400px" height="400px" style="border-radius: 10%;">
  </div>

  <div>
    <p>Pokemon, short for <b> "Pocket Monsters," </b> are fictional creatures that inhabit the Pokemon world alongside humans. Trainers capture and train these creatures, using them in battles and other activities. There are currently over 1,000 unique
    Pokemon species, each with distinct designs, abilities, and types.</p>
  </div>

  <div class="button">

<button type="button" id="btnJs">View</button>
<button type="button" id="btnJsadd">Add</button>
<button type="button" id="btnJsdel">Delete</button>
<button type="button" id="btnJsupd">Update</button>

</div>

  <script>
    document.getElementById('btnJs').addEventListener('click', function () {
      window.location.href = '<%= request.getContextPath() %>/pokemon';
    });

    document.getElementById('btnJsadd').addEventListener('click', function () {
      window.location.href = '<%= request.getContextPath() %>/addPokemon.jsp';
    });

    document.getElementById('btnJsdel').addEventListener('click', function () {
      window.location.href = '<%= request.getContextPath() %>/delPokemon.jsp';
    });

    document.getElementById('btnJsupd').addEventListener('click', function () {
        window.location.href = '<%= request.getContextPath() %>/updPokemon.jsp';
      });
  </script>
</body>
</html>
