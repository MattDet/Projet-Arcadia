export interface Image {
  id: number;
  path: string;
  altText?: string;
}

export interface ImageResponse {
  totalItems: number;
  member: Image[];
}
