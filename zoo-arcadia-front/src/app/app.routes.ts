import { Routes } from '@angular/router';
import { ContactComponent } from './pages/contact/contact.component';
import { HabitatsComponent } from './pages/habitats/habitats.component';
import { HomeComponent } from './pages/home/home.component';
import { LegalNoticeComponent } from './pages/legal-notice/legal-notice.component';
import { LoginComponent } from './pages/login/login.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { ServicesComponent } from './pages/services/services.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },  // Route par défaut (accueil)
    { path: 'services', component: ServicesComponent },
    { path: 'habitats', component: HabitatsComponent },
    { path: 'contact', component: ContactComponent },
    { path: 'login', component: LoginComponent },
    { path: 'legal-notice', component: LegalNoticeComponent},
    { path: '**', component: PageNotFoundComponent }  // Route wildcard (404)
];
