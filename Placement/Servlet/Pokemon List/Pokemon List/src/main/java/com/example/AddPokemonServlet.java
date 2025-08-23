package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/pokemon/add")
public class AddPokemonServlet extends HttpServlet {
    private final PokemonDAO dao = new PokemonDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String rarityStr = req.getParameter("rarity");

        if (name == null || name.isBlank() || rarityStr == null || rarityStr.isBlank()) {
            req.getSession().setAttribute("msg", "Name and Rarity are required.");
            resp.sendRedirect(req.getContextPath() + "/addPokemon.jsp");
            return;
        }

        try {

            dao.addPokemon(name.trim(), rarityStr);
            // redirect to list after insert (PRG pattern)
            resp.sendRedirect(req.getContextPath() + "/pokemon");
        } catch (NumberFormatException nfe) {
            req.getSession().setAttribute("msg", "Rarity must be a String.");
            resp.sendRedirect(req.getContextPath() + "/addPokemon.jsp");
        }
    }
}
