<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>

<h1 align="center">Liste des recettes</h1><br/>
<div class="row">
	<div class="container">
	
	<c:choose>
		<c:when test="${user != null}">
			<p style="color:red">Vous êtes identifié en tant que ${user.nom} ${user.prenom} (${user.pseudo})</p>
		</c:when>
		<c:when test="${erreur}">
			<p style="color:red">Login ou mot de passe incorrect.</p>
		</c:when>
		<c:otherwise>
			<p style="color:red">Attention, vous n'êtes pas identifié. Pour vous identifiez, indiquer votre <b>login</b> et <b>mot de passe</b> dans l'URL ou dans le formulaire de connexion.</p>
		</c:otherwise>
	</c:choose>
	
		<form id="form_supp" method="POST" action="./ListerRecettes">
		<table class="table">
			<thead>
				<tr>
					<th>N° ligne</th>
					<th>Titre</th>
					<th>Temps de préparation</th>
					<th>Temps de cuisson</th>
					<th>Difficulté</th>
					<th>Auteur</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach var="recette" items="${recettes}" varStatus="status">
				<tr>
					<td class="${status.index % 2 == 0 ? 'active' : '' }">${status.index}</td>
					<td class="${status.index % 2 == 0 ? 'active' : '' }">${recette.titre}</td>
					<td class="${status.index % 2 == 0 ? 'active' : '' }">${recette.temps_preparation} min </td>
					<td class="${status.index % 2 == 0 ? 'active' : '' }">${recette.temps_cuisson} min</td>
					<td class="${status.index % 2 == 0 ? 'active' : '' }">${recette.difficulte}/5</td>
					<td class="${status.index % 2 == 0 ? 'active' : '' }">${recette.auteur.nom} ${recette.auteur.prenom}</td>
					<td>
						<c:if test="${user.pseudo== recette.auteur.pseudo}">
								<input type="checkbox" value="${recette.id}" name="suppRecette"/>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		
	<p style="text-align:center"><input type="submit" class="btn btn-primary" value="Supprimer le(s) recette(s)"></p>
	<p style="text-align:center"><a href="./Deconnexion" class="btn btn-danger">Déconnexion</a></p>
	</form><br/>
	</div>
</div>
<%@ include file="footer.jsp" %>