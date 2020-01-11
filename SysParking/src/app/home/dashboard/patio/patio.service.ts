import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Patio } from './patio';
import { Registration } from '../registration/registration';
import { TokenService } from 'src/app/core/token/token.service';

const API = 'http://localhost:8080';

@Injectable({ providedIn: 'root' })
export class ResearchService {

  constructor(
    private http: HttpClient,
    private tokenService: TokenService) { }

  listReservationsByPatio(patioId: number) {
    return this.http
    .get<Registration[]>(API + '/patios/' + patioId, {headers: {Authoritazion: 'Bearer ' + this.tokenService.getToken()}});
  }

  listPatios() {
    return this.http
    .get<Patio[]>(API + '/patios/', {headers: {Authoritazion: 'Bearer ' + this.tokenService.getToken()}});
  }
}
