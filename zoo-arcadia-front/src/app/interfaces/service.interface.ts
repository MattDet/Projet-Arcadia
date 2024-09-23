// service.interface.ts
export interface Service {
    id: number;
    name: string;
    description: string;
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