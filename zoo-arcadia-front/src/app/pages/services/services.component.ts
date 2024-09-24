import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Service, ServiceResponse } from '../../interfaces/service.interface';
import { ImageService } from '../../services/image.service';
import { ServiceService } from '../../services/service.service';

@Component({
  selector: 'app-services',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})

export class ServicesComponent implements OnInit {
  services: Service[] = [];
  images: { [key: number]: string } = {}; // Pour stocker les chemins d'images
  visibleComments: { [key: number]: boolean } = {}; // Pour suivre quels commentaires sont visibles

  constructor(
    private serviceService: ServiceService,
    private imageService: ImageService
  ) {}

  ngOnInit(): void {
    this.serviceService.getServices().subscribe({
      next: (data: ServiceResponse) => {
        this.services = data.member; // Accéder à 'member' pour obtenir les services
        this.services.forEach(service => this.visibleComments[service.id] = false);

        // Charger les images pour chaque service
        this.services.forEach(service => {
          this.imageService.getImagesByService(service.id).subscribe(imagesResponse => {
            if (imagesResponse.totalItems > 0) {
              this.images[service.id] = `http://localhost:8080${imagesResponse.member[0].path}`;
              console.log(`Image for service ${service.id}:`, this.images[service.id]); // Log pour vérification
            }
          });
        });
      },
      error: (error) => {
        console.error('Erreur lors de la récupération des services', error);
      },
      complete: () => {
        console.log('Récupération des services terminée');
      }
    });
  }

  toggleComments(serviceId: number): void {
    this.visibleComments[serviceId] = !this.visibleComments[serviceId];
  }
}