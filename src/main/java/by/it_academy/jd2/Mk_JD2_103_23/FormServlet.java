package by.it_academy.jd2.Mk_JD2_103_23;

import by.it_academy.jd2.Mk_JD2_103_23.entity.Genre;
import by.it_academy.jd2.Mk_JD2_103_23.entity.Musician;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(urlPatterns = "/form_servlet")
public class FormServlet extends HttpServlet {
    private String GENRE_PARAMETER = "genre";

    Musician future = new Musician("Future");
    Musician theWeeknd = new Musician("The Weeknd");
    Musician vityaAk = new Musician("���� ��");
    Musician panzushot = new Musician("��������");
    Musician[] musicians = new Musician[]{future, theWeeknd, vityaAk, panzushot};

    Genre folk = new Genre("����-������");
    Genre country = new Genre("������");
    Genre latin = new Genre("������������������ ������");
    Genre blues = new Genre("����");
    Genre rhythmAndBlues = new Genre("����-�-����");
    Genre jazz = new Genre("����");
    Genre chanson = new Genre("������");
    Genre electronic = new Genre("����������� ������");
    Genre rock = new Genre("���");
    Genre hipHop = new Genre("���-���");
    List<Genre> genres = List.of(folk, country, latin, blues, rhythmAndBlues,
            jazz, chanson, electronic, rock, hipHop);
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd MMMM yyy");
    StringBuffer buffer = new StringBuffer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain; charset=utf-8");

        PrintWriter writer = resp.getWriter();
        String[] selectGenres = req.getParameterMap().get(GENRE_PARAMETER);
        if (selectGenres.length < 3) {
            writer.write("������! �������� ������� 3 ��������");
            return;
        } else {
            for (String g : selectGenres
            ) {
                switch (g) {
                    case "folk":
                        folk.setPoint(folk.getPoint() + 1);
                        break;
                    case "country":
                        country.setPoint(country.getPoint() + 1);
                        break;
                    case "latin":
                        latin.setPoint(latin.getPoint() + 1);
                        break;
                    case "blues":
                        blues.setPoint(blues.getPoint() + 1);
                        break;
                    case "rhythmAndBlues":
                        rhythmAndBlues.setPoint(rhythmAndBlues.getPoint() + 1);
                        break;
                    case "jazz":
                        jazz.setPoint(jazz.getPoint() + 1);
                        break;
                    case "chanson":
                        chanson.setPoint(chanson.getPoint() + 1);
                        break;
                    case "electronic":
                        electronic.setPoint(electronic.getPoint() + 1);
                        break;
                    case "rock":
                        rock.setPoint(rock.getPoint() + 1);
                        break;
                    case "hipHop":
                        hipHop.setPoint(hipHop.getPoint() + 1);
                        break;
                }
            }
        }

        String musician = req.getParameter("musician");

        switch (musician) {
            case "future":
                future.setPoint(future.getPoint() + 1);
                break;
            case "theWeeknd":
                theWeeknd.setPoint(theWeeknd.getPoint() + 1);
                break;
            case "vityaAk":
                vityaAk.setPoint(vityaAk.getPoint() + 1);
                break;
            case "panzu":
                panzushot.setPoint(panzushot.getPoint() + 1);
                break;
        }

        Arrays.sort(musicians);
        writer.write("������ ����������� (� ������� ������� ���������� ������):\n");
        for (Musician m : musicians
        ) {
            writer.write(m.toString() + "\n");
        }

        writer.write("\n\n������� �����\n");
        genres.stream()
                .sorted()
                .forEach(e -> writer.write(e + "\n"));

        String text = req.getParameter("text");
        String msg;
        msg = text.isBlank() ? "������ ���������" : text;

        buffer.append("\n\n" + msg + "\n" + dateFormat.format(new Date()));
        writer.write(buffer.toString());
    }
}
