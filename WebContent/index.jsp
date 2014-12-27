<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Recette" %>
<div class="row">
	<div class="col-md-1">
	</div>
	<div class="col-md-2">
			<h2 align="center">Connexion </h2>
			<c:if test="${erreur != null}">
				<p style="color:red">${erreur}</p>
			</c:if>
			
			<form role="form" method="POST" action="./Index">
				<div class="form-group">
			    <label for="pseudo">Pseudo :</label>
			    <input type="text" class="form-control" name="login" placeholder="Votre login">
			    </div>
			    <div class="form-group">
			    <label for="exampleInputEmail1">Mot de passe :</label>
			    <input type="password" class="form-control" name="password" placeholder="Votre mot de passe">
			    </div>
			     <button type="submit" class="btn btn-default">Valider</button>
			</form>
	</div>
	<div class="col-md-1">
	</div>
	<div class="col-md-6">
		<h2 align="center">Nos 3 dernières recette</h2>
		<ul>
			<c:forEach var="recette" items="${lesrecettes}">
				<li>${recette.titre}</li>
			</c:forEach>
		</ul>
	</div>
</div>
<%@ include file="footer.jsp" %>