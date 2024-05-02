/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createRapport } from '../fn/rapport-controller/create-rapport';
import { CreateRapport$Params } from '../fn/rapport-controller/create-rapport';
import { deleteRapport } from '../fn/rapport-controller/delete-rapport';
import { DeleteRapport$Params } from '../fn/rapport-controller/delete-rapport';
import { getRapportById } from '../fn/rapport-controller/get-rapport-by-id';
import { GetRapportById$Params } from '../fn/rapport-controller/get-rapport-by-id';
import { Rapport } from '../models/rapport';
import { updateRapport } from '../fn/rapport-controller/update-rapport';
import { UpdateRapport$Params } from '../fn/rapport-controller/update-rapport';

@Injectable({ providedIn: 'root' })
export class RapportControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `getRapportById()` */
  static readonly GetRapportByIdPath = '/rapports/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getRapportById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getRapportById$Response(params: GetRapportById$Params, context?: HttpContext): Observable<StrictHttpResponse<Rapport>> {
    return getRapportById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getRapportById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getRapportById(params: GetRapportById$Params, context?: HttpContext): Observable<Rapport> {
    return this.getRapportById$Response(params, context).pipe(
      map((r: StrictHttpResponse<Rapport>): Rapport => r.body)
    );
  }

  /** Path part for operation `updateRapport()` */
  static readonly UpdateRapportPath = '/rapports/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateRapport()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateRapport$Response(params: UpdateRapport$Params, context?: HttpContext): Observable<StrictHttpResponse<Rapport>> {
    return updateRapport(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateRapport$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateRapport(params: UpdateRapport$Params, context?: HttpContext): Observable<Rapport> {
    return this.updateRapport$Response(params, context).pipe(
      map((r: StrictHttpResponse<Rapport>): Rapport => r.body)
    );
  }

  /** Path part for operation `deleteRapport()` */
  static readonly DeleteRapportPath = '/rapports/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteRapport()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteRapport$Response(params: DeleteRapport$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteRapport(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteRapport$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteRapport(params: DeleteRapport$Params, context?: HttpContext): Observable<void> {
    return this.deleteRapport$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `createRapport()` */
  static readonly CreateRapportPath = '/rapports';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createRapport()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createRapport$Response(params: CreateRapport$Params, context?: HttpContext): Observable<StrictHttpResponse<Rapport>> {
    return createRapport(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createRapport$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createRapport(params: CreateRapport$Params, context?: HttpContext): Observable<Rapport> {
    return this.createRapport$Response(params, context).pipe(
      map((r: StrictHttpResponse<Rapport>): Rapport => r.body)
    );
  }

}
