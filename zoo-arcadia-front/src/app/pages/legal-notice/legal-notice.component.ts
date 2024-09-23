import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-legal-notice',
  standalone: true,
  imports: [],
  templateUrl: './legal-notice.component.html',
  styleUrl: './legal-notice.component.css'
})
export class LegalNoticeComponent {
  constructor(
    private router: Router
  ) {}
  
  // Ajoutez la méthode
  goBack(): void {
    this.router.navigate(['/']); // Redirige vers la page d'accueil
  }
}
