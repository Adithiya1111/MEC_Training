package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/pokemon")
public class ListPokemonServlet extends HttpServlet {
    private final PokemonDAO dao = new PokemonDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Pokemon> pokemon = dao.listPokemon();
        req.setAttribute("pokemon", pokemon);
        req.getRequestDispatcher("/listPokemon.jsp").forward(req, resp);
    }
}
