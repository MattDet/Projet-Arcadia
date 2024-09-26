import { provideHttpClient } from '@angular/common/http';
import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter } from '@angular/router';
import { AppComponent } from './app/app.component';
import { routes } from './app/app.routes'; // Importez vos routes

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(routes),    // Fournissez vos routes
    provideHttpClient()       // Fournissez le HttpClient pour les requêtes HTTP
  ]
});