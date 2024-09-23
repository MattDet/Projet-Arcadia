import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Animal } from '../../interfaces/animal.interface';
import { Habitat, HabitatResponse } from '../../interfaces/habitat.interface';
import { AnimalService } from '../../services/animal.service';
import { HabitatService } from '../../services/habitat.service';
import { ImageService } from '../../services/image.service';
import { SpeciesService } from '../../services/species.service';

@Component({
  selector: 'app-habitats',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './habitats.component.html',
  styleUrls: ['./habitats.component.css']
})
export class HabitatsComponent implements OnInit {
  habitats: Habitat[] = [];
  images: { [key: number]: string } = {};
  visibleComments: { [key: number]: boolean } = {};
  animalsByHabitat: { [key: number]: Animal[] } = {}; // Pour stocker les animaux par habitat
  selectedAnimal: Animal | null = null; // Pour stocker l'animal sélectionné
  selectedAnimalImage: string | null = null; // Image de l'animal sélectionné
  selectedAnimalSpecies: string | null = null; // Nom de l'espèce de l'animal
  selectedAnimalHabitat: string | null = null; // Nom de l'habitat de l'animal


  constructor(
    private habitatService: HabitatService,
    private imageService: ImageService,
    private animalService: AnimalService,
    private speciesService: SpeciesService // Injection du service des espèces
  ) {}

  ngOnInit(): void {
    this.habitatService.getHabitats().subscribe({
      next: (data: HabitatResponse) => {
        this.habitats = data.member;
        this.habitats.forEach(habitat => {
          this.visibleComments[habitat.id] = false; // Initialiser la visibilité des commentaires
          this.loadImages(habitat.id); // Charger les images
          this.loadAnimals(habitat.id); // Charger les animaux
        });
      },
      error: (error) => {
        console.error('Erreur lors de la récupération des habitats', error);
      },
      complete: () => {
        console.log('Récupération des habitats terminée');
      }
    });
  }

  loadImages(habitatId: number): void {
    this.imageService.getImagesByHabitat(habitatId).subscribe(imagesResponse => {
      if (imagesResponse.totalItems > 0) {
        this.images[habitatId] = `http://localhost:8000${imagesResponse.member[0].path}`;
        console.log(`Image for habitat ${habitatId}:`, this.images[habitatId]); // Log pour vérification
      }
    });
  }

  loadAnimals(habitatId: number): void {
    this.animalService.getAnimalsByHabitat(habitatId).subscribe({
        next: (animalsResponse) => {
            this.animalsByHabitat[habitatId] = animalsResponse.member; // Assurez-vous que la structure est correcte
        },
        error: (error) => {
            console.error('Erreur lors de la récupération des animaux', error);
        }
    });
  }

  openAnimalModal(animal: Animal, habitatName: string): void {
    this.selectedAnimal = animal;
    this.selectedAnimalSpecies = null; // Réinitialise avant le chargement
    this.selectedAnimalHabitat = habitatName; // Utiliser le nom de l'habitat directement

    // Charger l'image de l'animal sélectionné
    this.loadAnimalImage(animal.id);

    // Charger l'espèce de l'animal
    this.loadAnimalSpecies(animal.species);
  }

  loadAnimalImage(animalId: number): void {
    this.imageService.getImagesByAnimal(animalId).subscribe(imageResponse => {
      if (imageResponse.totalItems > 0) {
        this.selectedAnimalImage = `http://localhost:8000${imageResponse.member[0].path}`;
      } else {
        this.selectedAnimalImage = null;
      }
    });
  }

  loadAnimalSpecies(speciesUrl: string): void {
    const speciesId = this.extractIdFromUrl(speciesUrl);
    if (speciesId) {
      this.speciesService.getSpeciesById(`http://localhost:8000/api/species/${speciesId}`).subscribe(species => {
        this.selectedAnimalSpecies = species.name;
      });
    } else {
      this.selectedAnimalSpecies = 'Espèce inconnue';
    }
  }

  // Extraire l'ID à partir de l'URL
extractIdFromUrl(url: string): number | null {
  const parts = url.split('/');
  const id = parts[parts.length - 1];
  return id ? parseInt(id, 10) : null;
}

  toggleComments(habitatId: number): void {
    this.visibleComments[habitatId] = !this.visibleComments[habitatId];
  }
}
