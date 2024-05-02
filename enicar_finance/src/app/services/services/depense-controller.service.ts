/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createDepense } from '../fn/depense-controller/create-depense';
import { CreateDepense$Params } from '../fn/depense-controller/create-depense';
import { deleteDepense } from '../fn/depense-controller/delete-depense';
import { DeleteDepense$Params } from '../fn/depense-controller/delete-depense';
import { Depense } from '../models/depense';
import { getDepenseById } from '../fn/depense-controller/get-depense-by-id';
import { GetDepenseById$Params } from '../fn/depense-controller/get-depense-by-id';
import { updateDepense } from '../fn/depense-controller/update-depense';
import { UpdateDepense$Params } from '../fn/depense-controller/update-depense';

@Injectable({ providedIn: 'root' })
export class DepenseControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `getDepenseById()` */
  static readonly GetDepenseByIdPath = '/depenses/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getDepenseById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getDepenseById$Response(params: GetDepenseById$Params, context?: HttpContext): Observable<StrictHttpResponse<Depense>> {
    return getDepenseById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getDepenseById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getDepenseById(params: GetDepenseById$Params, context?: HttpContext): Observable<Depense> {
    return this.getDepenseById$Response(params, context).pipe(
      map((r: StrictHttpResponse<Depense>): Depense => r.body)
    );
  }

  /** Path part for operation `updateDepense()` */
  static readonly UpdateDepensePath = '/depenses/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateDepense()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateDepense$Response(params: UpdateDepense$Params, context?: HttpContext): Observable<StrictHttpResponse<Depense>> {
    return updateDepense(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateDepense$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateDepense(params: UpdateDepense$Params, context?: HttpContext): Observable<Depense> {
    return this.updateDepense$Response(params, context).pipe(
      map((r: StrictHttpResponse<Depense>): Depense => r.body)
    );
  }

  /** Path part for operation `deleteDepense()` */
  static readonly DeleteDepensePath = '/depenses/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteDepense()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteDepense$Response(params: DeleteDepense$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteDepense(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteDepense$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteDepense(params: DeleteDepense$Params, context?: HttpContext): Observable<void> {
    return this.deleteDepense$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `createDepense()` */
  static readonly CreateDepensePath = '/depenses';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createDepense()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createDepense$Response(params: CreateDepense$Params, context?: HttpContext): Observable<StrictHttpResponse<Depense>> {
    return createDepense(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createDepense$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createDepense(params: CreateDepense$Params, context?: HttpContext): Observable<Depense> {
    return this.createDepense$Response(params, context).pipe(
      map((r: StrictHttpResponse<Depense>): Depense => r.body)
    );
  }

}
