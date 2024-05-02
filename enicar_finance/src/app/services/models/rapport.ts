/* tslint:disable */
/* eslint-disable */
import { Depense } from '../models/depense';
import { Event } from '../models/event';
import { Revenu } from '../models/revenu';
export interface Rapport {
  contenu?: string;
  depenses?: Array<Depense>;
  e?: Event;
  generationDate?: string;
  idRapport?: number;
  revenus?: Array<Revenu>;
  uuid?: string;
}
