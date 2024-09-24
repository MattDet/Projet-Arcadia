import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ImageResponse } from '../interfaces/image.interface';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private apiUrl = 'http://localhost:8080/v1/images';

  constructor(private http: HttpClient) {}

  // Récupération des images par service
  getImagesByService(serviceId: number): Observable<ImageResponse> {
    return this.http.get<ImageResponse>(`${this.apiUrl}/service/${serviceId}`);
  }

  // Récupération des images par habitat
  getImagesByHabitat(habitatId: number): Observable<ImageResponse> {
    return this.http.get<ImageResponse>(`${this.apiUrl}/habitat/${habitatId}`);
  }

  // Récupération des images par animal
  getImagesByAnimal(animalId: number): Observable<ImageResponse> {
    return this.http.get<ImageResponse>(`${this.apiUrl}/animal/${animalId}`);
  }
}
