/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createFacture } from '../fn/facture-controller/create-facture';
import { CreateFacture$Params } from '../fn/facture-controller/create-facture';
import { deleteFacture } from '../fn/facture-controller/delete-facture';
import { DeleteFacture$Params } from '../fn/facture-controller/delete-facture';
import { Facture } from '../models/facture';
import { getAllFactures } from '../fn/facture-controller/get-all-factures';
import { GetAllFactures$Params } from '../fn/facture-controller/get-all-factures';
import { getFactureById } from '../fn/facture-controller/get-facture-by-id';
import { GetFactureById$Params } from '../fn/facture-controller/get-facture-by-id';
import { updateFacture } from '../fn/facture-controller/update-facture';
import { UpdateFacture$Params } from '../fn/facture-controller/update-facture';

@Injectable({ providedIn: 'root' })
export class FactureControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `getFactureById()` */
  static readonly GetFactureByIdPath = '/factures/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getFactureById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getFactureById$Response(params: GetFactureById$Params, context?: HttpContext): Observable<StrictHttpResponse<Facture>> {
    return getFactureById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getFactureById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getFactureById(params: GetFactureById$Params, context?: HttpContext): Observable<Facture> {
    return this.getFactureById$Response(params, context).pipe(
      map((r: StrictHttpResponse<Facture>): Facture => r.body)
    );
  }

  /** Path part for operation `updateFacture()` */
  static readonly UpdateFacturePath = '/factures/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateFacture()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateFacture$Response(params: UpdateFacture$Params, context?: HttpContext): Observable<StrictHttpResponse<Facture>> {
    return updateFacture(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateFacture$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateFacture(params: UpdateFacture$Params, context?: HttpContext): Observable<Facture> {
    return this.updateFacture$Response(params, context).pipe(
      map((r: StrictHttpResponse<Facture>): Facture => r.body)
    );
  }

  /** Path part for operation `deleteFacture()` */
  static readonly DeleteFacturePath = '/factures/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteFacture()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteFacture$Response(params: DeleteFacture$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteFacture(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteFacture$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteFacture(params: DeleteFacture$Params, context?: HttpContext): Observable<void> {
    return this.deleteFacture$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `getAllFactures()` */
  static readonly GetAllFacturesPath = '/factures';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllFactures()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllFactures$Response(params?: GetAllFactures$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<Facture>>> {
    return getAllFactures(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllFactures$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllFactures(params?: GetAllFactures$Params, context?: HttpContext): Observable<Array<Facture>> {
    return this.getAllFactures$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<Facture>>): Array<Facture> => r.body)
    );
  }

  /** Path part for operation `createFacture()` */
  static readonly CreateFacturePath = '/factures';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createFacture()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createFacture$Response(params: CreateFacture$Params, context?: HttpContext): Observable<StrictHttpResponse<Facture>> {
    return createFacture(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createFacture$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createFacture(params: CreateFacture$Params, context?: HttpContext): Observable<Facture> {
    return this.createFacture$Response(params, context).pipe(
      map((r: StrictHttpResponse<Facture>): Facture => r.body)
    );
  }

}
