export interface Animal {
    id: number;
    name: string;
    habitat: string;
    health_status: string;
    species: string;
}

export interface AnimalResponse {
    totalItems: number;
    member: Animal[];
}