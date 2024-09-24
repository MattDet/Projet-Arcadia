// service.interface.ts
export interface Service {
    id: number;
    name: string;
    description: string;
    // Le champ "comment" correspond au champ dans l'API Spring
    comments: string;
    imagePath?: string;
}

export interface ServiceResponse {
    '@context': string;
    '@id': string;
    '@type': string;
    totalItems: number;
    member: Service[];
}
