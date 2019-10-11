package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>PetSafe</title>\n");
      out.write("        \n");
      out.write("        <link href=\"vista/estilo.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body >\n");
      out.write("        \n");
      out.write("        <div id=\"header\">\n");
      out.write("            <h1 id=\"logo\">\n");
      out.write("      \n");
      out.write("            <img class=\"mediana\" src=\"imagenes/logo_transparent.png\" alt=\"\"/>\n");
      out.write("            </h1>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        \n");
      out.write("            \n");
      out.write("        <div id=\"container\">\n");
      out.write("                \n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"#\">Inicio</a></li>\n");
      out.write("                <li><a href=\"consultarMascotas.jsp\">Mascotas</a></li>\n");
      out.write("                <li><a href=\"consultarVentas.jsp\">Facturas</a></li>\n");
      out.write("                <li><a href=\"#\">Tienda</a></li>\n");
      out.write("                <li><a href=\"consultarVeterinarios.jsp\">Veterinarios</a></li>\n");
      out.write("                <li><a href=\"#\">Acerca de nosotros</a></li>\n");
      out.write("                <li><a href=\"plantilla.jsp\">plantilla</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"slider\">\n");
      out.write("\t\t<ul>\n");
      out.write("                    <li>\n");
      out.write("                        <img  src=\"imagenes/orig_37616.jpg\" alt=\"\"/>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <img src=\"imagenes/camaleones-como-mascotas-artistas-del-camuflaje.jpg\" alt=\"\"/>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <img src=\"imagenes/mascotas.jpg\" alt=\"\"/>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <img src=\"imagenes/default-image-2.jpg\" alt=\"\"/>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("        \n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("        \n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
