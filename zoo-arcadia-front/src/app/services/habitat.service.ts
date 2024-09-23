import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HabitatResponse } from '../interfaces/habitat.interface';

@Injectable({
  providedIn: 'root'
})
export class HabitatService {
  private apiUrl = 'http://localhost:8000/api/habitats';

  constructor(private http: HttpClient) { }

  getHabitats(): Observable<HabitatResponse> {
    return this.http.get<HabitatResponse>(this.apiUrl);
  }

  getHabitat(id: number): Observable<HabitatResponse> {
    return this.http.get<HabitatResponse>(`${this.apiUrl}/${id}`);
  }
}
