import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username = '';
  password = '';

  constructor(private http: HttpClient, private router: Router) {}

  onSubmit(): void {
    this.http.post('http://localhost:8000/login', {
      username: this.username,
      password: this.password
    }).subscribe({
      next: () => {
        // Rediriger l'utilisateur vers la page de profil après connexion
        this.router.navigate(['/profile']);
      },
      error: (error) => {
        console.error('Login failed', error);
      }
    });
  }
  }