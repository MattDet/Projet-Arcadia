import Route from "../router/route.js";

export const allRoutes = [
    new Route("/", "Accueil", "/pages/public/HomePage.html"),
    new Route("/Contact", "Contact", "/pages/public/Contact.html"),
    new Route("/Habitats", "Habitats", "/pages/public/Habitats.html"),
    new Route("/Services", "Services", "/pages/public/Services.html"),
    new Route("/Connexion", "Connexion", "/pages/public/Login.html"),
    new Route("/Admin", "Adminitrateur", "/pages/prive/admin.html"),
    new Route("/Veterinaire", "Vétérinaire", "/pages/prive/veterinaire.html"),
    new Route("/Employe", "Employé", "/pages/prive/employe.html"),

];

    export const websiteName = "Zoo Arcadia";