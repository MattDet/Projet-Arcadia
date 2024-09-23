import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Animal, AnimalResponse } from '../interfaces/animal.interface';

@Injectable({
  providedIn: 'root'
})
export class AnimalService {
  private apiUrl = 'http://localhost:8000/api/animals'; // Remplacez par l'URL de votre API

  constructor(private http: HttpClient) { }

  getAnimalsByHabitat(habitatId: number): Observable<AnimalResponse> {
    return this.http.get<AnimalResponse>(`${this.apiUrl}?habitat.id=${habitatId}`);
  }

  getAnimalById(id: number): Observable<Animal> {
    return this.http.get<Animal>(`http://localhost:8000/api/animals/${id}`);
}

}
