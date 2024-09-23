import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Species {
  id: number;
  name: string;
}

@Injectable({
  providedIn: 'root'
})
export class SpeciesService {
  private apiUrl = 'http://localhost:8000/api/species'; // URL de base pour les espèces

  constructor(private http: HttpClient) {}

  // Méthode pour récupérer une espèce à partir de son URL
  getSpeciesById(speciesUrl: string): Observable<Species> {
    return this.http.get<Species>(speciesUrl);
  }
}
