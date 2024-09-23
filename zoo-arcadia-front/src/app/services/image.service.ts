import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

interface Image {
  id: number;
  path: string;
}

interface ImageResponse {
  totalItems: number;
  member: Image[];
}

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private apiUrl = 'http://localhost:8000/api/images';

  constructor(private http: HttpClient) { }

  getImagesByService(serviceId: number): Observable<ImageResponse> {
    return this.http.get<ImageResponse>(`${this.apiUrl}?service.id=${serviceId}`);
  }

  getImagesByHabitat(habitatId: number): Observable<ImageResponse> {
    return this.http.get<ImageResponse>(`${this.apiUrl}?habitat.id=${habitatId}`);
  }

  getImagesByAnimal(animalId: number): Observable<ImageResponse> {
    return this.http.get<ImageResponse>(`http://localhost:8000/api/images?animal.id=${animalId}`);
}

  
}