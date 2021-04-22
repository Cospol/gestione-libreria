<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionelibreria.model.Libro"%>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Conferma eliminazione</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Conferma eliminazione
		    </div>
		    <%
		    	Libro libroInPagina = (Libro)request.getAttribute("visualizza_libro_attr");
		    %>
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Titolo</dt>
				  <dd class="col-sm-9"><%=libroInPagina.getTitolo() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Genere:</dt>
				  <dd class="col-sm-9"><%=libroInPagina.getGenere() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Pagine:</dt>
				  <dd class="col-sm-9"><%=libroInPagina.getPagine() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data di Pubblicazione:</dt>
				  <dd class="col-sm-9"><%=libroInPagina.getDataPubblicazione()!=null? new SimpleDateFormat("dd/MM/yyyy").format(libroInPagina.getDataPubblicazione()):"N.D."  %></dd>
		    	</dl>
		    	
		    </div>
		    
		    <div class='card-footer'>
		        <form action="ExecuteDeleteCdServlet" method="post">
			        <a href="ListLibriServlet" class='btn btn-outline-secondary' style='width:80px'>
			            <i class='fa fa-chevron-left'></i> Back
			        </a>
		        	<input type="hidden" name="idInput"  value=<%=libroInPagina.getId() %>>
		        	<button type="submit" class="btn btn-outline-danger">Rimuovi</button>
				</form>
		    </div>
		</div>	
		
	
	
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>