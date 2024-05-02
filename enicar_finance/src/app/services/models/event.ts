/* tslint:disable */
/* eslint-disable */
import { Budget } from '../models/budget';
import { Depense } from '../models/depense';
import { Facture } from '../models/facture';
import { Rapport } from '../models/rapport';
import { Revenu } from '../models/revenu';
import { Sponsor } from '../models/sponsor';
export interface Event {
  budgets?: Array<Budget>;
  date?: string;
  depenses?: Array<Depense>;
  factures?: Array<Facture>;
  idEvent?: number;
  lieu?: string;
  nom?: string;
  nombrePersonne?: number;
  rapp?: Rapport;
  revenus?: Array<Revenu>;
  sponsors?: Array<Sponsor>;
  theme?: string;
  uuid?: string;
}
