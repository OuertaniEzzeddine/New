/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createSponsor } from '../fn/sponsor-controller/create-sponsor';
import { CreateSponsor$Params } from '../fn/sponsor-controller/create-sponsor';
import { deleteSponsor } from '../fn/sponsor-controller/delete-sponsor';
import { DeleteSponsor$Params } from '../fn/sponsor-controller/delete-sponsor';
import { getSponsorById } from '../fn/sponsor-controller/get-sponsor-by-id';
import { GetSponsorById$Params } from '../fn/sponsor-controller/get-sponsor-by-id';
import { Sponsor } from '../models/sponsor';
import { updateSponsor } from '../fn/sponsor-controller/update-sponsor';
import { UpdateSponsor$Params } from '../fn/sponsor-controller/update-sponsor';

@Injectable({ providedIn: 'root' })
export class SponsorControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `getSponsorById()` */
  static readonly GetSponsorByIdPath = '/sponsors/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getSponsorById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getSponsorById$Response(params: GetSponsorById$Params, context?: HttpContext): Observable<StrictHttpResponse<Sponsor>> {
    return getSponsorById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getSponsorById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getSponsorById(params: GetSponsorById$Params, context?: HttpContext): Observable<Sponsor> {
    return this.getSponsorById$Response(params, context).pipe(
      map((r: StrictHttpResponse<Sponsor>): Sponsor => r.body)
    );
  }

  /** Path part for operation `updateSponsor()` */
  static readonly UpdateSponsorPath = '/sponsors/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateSponsor()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateSponsor$Response(params: UpdateSponsor$Params, context?: HttpContext): Observable<StrictHttpResponse<Sponsor>> {
    return updateSponsor(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateSponsor$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateSponsor(params: UpdateSponsor$Params, context?: HttpContext): Observable<Sponsor> {
    return this.updateSponsor$Response(params, context).pipe(
      map((r: StrictHttpResponse<Sponsor>): Sponsor => r.body)
    );
  }

  /** Path part for operation `deleteSponsor()` */
  static readonly DeleteSponsorPath = '/sponsors/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteSponsor()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteSponsor$Response(params: DeleteSponsor$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteSponsor(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteSponsor$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteSponsor(params: DeleteSponsor$Params, context?: HttpContext): Observable<void> {
    return this.deleteSponsor$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `createSponsor()` */
  static readonly CreateSponsorPath = '/sponsors';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createSponsor()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createSponsor$Response(params: CreateSponsor$Params, context?: HttpContext): Observable<StrictHttpResponse<Sponsor>> {
    return createSponsor(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createSponsor$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createSponsor(params: CreateSponsor$Params, context?: HttpContext): Observable<Sponsor> {
    return this.createSponsor$Response(params, context).pipe(
      map((r: StrictHttpResponse<Sponsor>): Sponsor => r.body)
    );
  }

}
