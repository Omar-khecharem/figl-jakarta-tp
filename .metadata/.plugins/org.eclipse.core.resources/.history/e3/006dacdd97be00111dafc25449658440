package tn.isimg.salles.web;

import java.io.IOException;
import java.util.Collections;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = "/info",
    initParams = {
        @WebInitParam(
            name = "application",
            value = "Réservation de salles"
        ),
        @WebInitParam(
            name = "auteur",
            value = "Omar Khecharem"
        )
    }
)
public class InfoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private String application;
    private String auteur;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        auteur = config.getInitParameter("auteur");
        application = config.getInitParameter("application");

        if (auteur == null || auteur.isBlank()) {
            auteur = "Auteur inconnu";
        }

        if (application == null || application.isBlank()) {
            application = "Application inconnue";
        }

        log("InfoServlet initialisée");
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        var langues = Collections.list(request.getLocales());
        var entetes = Collections.list(request.getHeaderNames());

        var lignesLangues = new StringBuilder();

        for (var langue : langues) {
            lignesLangues.append("""
                <li>%s</li>
                """.formatted(
                    Html.escape(langue.toLanguageTag())
                ));
        }

        var lignesEntetes = new StringBuilder();

        for (var nom : entetes) {
            var valeur = request.getHeader(nom);

            lignesEntetes.append("""
                <tr>
                    <td>%s</td>
                    <td>%s</td>
                </tr>
                """.formatted(
                    Html.escape(nom),
                    Html.escape(valeur)
                ));
        }

        var html = """
            <!DOCTYPE html>
            <html lang="fr">

            <head>
                <meta charset="UTF-8">
                <title>%s</title>
            </head>

            <body>

                <h1>Bienvenue dans %s</h1>

                <h2>Application</h2>

                <p>
                    <strong>Application :</strong> %s
                </p>

                <p>
                    <strong>Auteur :</strong> %s
                </p>

                <h2>Requête HTTP</h2>

                <p>
                    <strong>URL :</strong> %s
                </p>

                <p>
                    <strong>Méthode :</strong> %s
                </p>

                <p>
                    <strong>Adresse IP :</strong> %s
                </p>

                <p>
                    <strong>Protocole :</strong> %s
                </p>

                <h2>Langues acceptées</h2>

                <ul>
                    %s
                </ul>

                <h2>Entêtes HTTP</h2>

                <table border="1">
                    <tr>
                        <th>Nom</th>
                        <th>Valeur</th>
                    </tr>

                    %s

                </table>

            </body>
            </html>
            """.formatted(
                Html.escape(application),
                Html.escape(application),
                Html.escape(application),
                Html.escape(auteur),
                Html.escape(request.getRequestURL().toString()),
                Html.escape(request.getMethod()),
                Html.escape(request.getRemoteAddr()),
                Html.escape(request.getProtocol()),
                lignesLangues,
                lignesEntetes
            );

        response.getWriter().print(html);
    }
}