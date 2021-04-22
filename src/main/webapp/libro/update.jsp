<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionelibreria.model.Libro"%>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Aggiorna libro</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	<%
		Libro libroDaModificare = (Libro)request.getAttribute("modifica_libro_attr");
	%>
	<main role="main" class="container">
	
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Aggiorna libro</h5> 
		    </div>
		    <div class='card-body'>

					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ExecuteUpdateCdServlet" novalidate="novalidate">
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Titolo <span class="text-danger">*</span></label>
								<input type="text" name="titolo" id="titolo" class="form-control" placeholder="Inserire il titolo" value="<%=libroDaModificare.getTitolo()!=null ? libroDaModificare.getTitolo() :"" %>" required >
							</div>
							
							<div class="form-group col-md-6">
								<label>Genere <span class="text-danger">*</span></label>
								<input type="text" name="genere" id="genere" class="form-control" placeholder="Inserire il genere" value="<%=libroDaModificare.getGenere()!=null ? libroDaModificare.getGenere() :"" %>" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Pagine <span class="text-danger">*</span></label>
								<input type="number" class="form-control" name="pagine" id="pagine" placeholder="Inserire prezzo" value="<%=libroDaModificare.getPagine() != null ? libroDaModificare.getPagine() : ""%>" required>
							</div>
							<div class="form-group col-md-3">
								<label>Data di Pubblicazione<span class="text-danger">*</span></label>
                        		<input class="form-control" id="dataPubblicazione" type="date" value="<%=libroDaModificare.getDataPubblicazione()!=null? new SimpleDateFormat("yyyy-MM-dd").format(libroDaModificare.getDataPubblicazione()):""%>" placeholder="dd/MM/yy"
                            		title="formato : gg/mm/aaaa"  name="dataPubblicazione" required>
							</div>
							 <input type="hidden" name="id" id="idArticolo"  value="<%=libroDaModificare.getId() %>" >
							
						</div>
							
						<button type="submit" id="buttonUpdate" class="btn btn-primary">Modifica</button>
					
					</form>

			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>