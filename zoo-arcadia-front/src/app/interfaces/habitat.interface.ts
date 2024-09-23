export interface Habitat {
    id: number;
    name: string;
    description: string;
    comments: string;
    imagePath?: string;
}

export interface HabitatResponse {
    '@context': string;
    '@id': string;
    '@type': string;
    totalItems: number;
    member: Habitat[];
}