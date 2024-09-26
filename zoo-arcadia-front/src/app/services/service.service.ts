import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ServiceResponse } from '../interfaces/service.interface';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  // Mettre à jour l'URL pour correspondre à l'API Spring
  private apiUrl = 'http://localhost:8000/api/services';

  constructor(private http: HttpClient) { }

  getServices(): Observable<ServiceResponse> {
    return this.http.get<ServiceResponse>(this.apiUrl);
  }

  getService(id: number): Observable<ServiceResponse> {
    return this.http.get<ServiceResponse>(`${this.apiUrl}/${id}`);
  }
}
