/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createRevenu } from '../fn/revenu-controller/create-revenu';
import { CreateRevenu$Params } from '../fn/revenu-controller/create-revenu';
import { deleteRevenu } from '../fn/revenu-controller/delete-revenu';
import { DeleteRevenu$Params } from '../fn/revenu-controller/delete-revenu';
import { getRevenuById } from '../fn/revenu-controller/get-revenu-by-id';
import { GetRevenuById$Params } from '../fn/revenu-controller/get-revenu-by-id';
import { Revenu } from '../models/revenu';
import { updateRevenu } from '../fn/revenu-controller/update-revenu';
import { UpdateRevenu$Params } from '../fn/revenu-controller/update-revenu';

@Injectable({ providedIn: 'root' })
export class RevenuControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `getRevenuById()` */
  static readonly GetRevenuByIdPath = '/revenus/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getRevenuById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getRevenuById$Response(params: GetRevenuById$Params, context?: HttpContext): Observable<StrictHttpResponse<Revenu>> {
    return getRevenuById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getRevenuById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getRevenuById(params: GetRevenuById$Params, context?: HttpContext): Observable<Revenu> {
    return this.getRevenuById$Response(params, context).pipe(
      map((r: StrictHttpResponse<Revenu>): Revenu => r.body)
    );
  }

  /** Path part for operation `updateRevenu()` */
  static readonly UpdateRevenuPath = '/revenus/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateRevenu()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateRevenu$Response(params: UpdateRevenu$Params, context?: HttpContext): Observable<StrictHttpResponse<Revenu>> {
    return updateRevenu(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateRevenu$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateRevenu(params: UpdateRevenu$Params, context?: HttpContext): Observable<Revenu> {
    return this.updateRevenu$Response(params, context).pipe(
      map((r: StrictHttpResponse<Revenu>): Revenu => r.body)
    );
  }

  /** Path part for operation `deleteRevenu()` */
  static readonly DeleteRevenuPath = '/revenus/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteRevenu()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteRevenu$Response(params: DeleteRevenu$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteRevenu(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteRevenu$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteRevenu(params: DeleteRevenu$Params, context?: HttpContext): Observable<void> {
    return this.deleteRevenu$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `createRevenu()` */
  static readonly CreateRevenuPath = '/revenus';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createRevenu()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createRevenu$Response(params: CreateRevenu$Params, context?: HttpContext): Observable<StrictHttpResponse<Revenu>> {
    return createRevenu(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createRevenu$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createRevenu(params: CreateRevenu$Params, context?: HttpContext): Observable<Revenu> {
    return this.createRevenu$Response(params, context).pipe(
      map((r: StrictHttpResponse<Revenu>): Revenu => r.body)
    );
  }

}
