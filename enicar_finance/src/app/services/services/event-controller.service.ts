/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createEvent } from '../fn/event-controller/create-event';
import { CreateEvent$Params } from '../fn/event-controller/create-event';
import { Event } from '../models/event';
import { EventDto } from '../models/event-dto';
import { FactureDto } from '../models/facture-dto';
import { getAllEvents } from '../fn/event-controller/get-all-events';
import { GetAllEvents$Params } from '../fn/event-controller/get-all-events';
import { getAllFacturesForEvent } from '../fn/event-controller/get-all-factures-for-event';
import { GetAllFacturesForEvent$Params } from '../fn/event-controller/get-all-factures-for-event';
import { getEventById } from '../fn/event-controller/get-event-by-id';
import { GetEventById$Params } from '../fn/event-controller/get-event-by-id';

@Injectable({ providedIn: 'root' })
export class EventControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `getAllEvents()` */
  static readonly GetAllEventsPath = '/api/events';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllEvents()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllEvents$Response(params?: GetAllEvents$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<Event>>> {
    return getAllEvents(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllEvents$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllEvents(params?: GetAllEvents$Params, context?: HttpContext): Observable<Array<Event>> {
    return this.getAllEvents$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<Event>>): Array<Event> => r.body)
    );
  }

  /** Path part for operation `createEvent()` */
  static readonly CreateEventPath = '/api/events';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createEvent()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createEvent$Response(params: CreateEvent$Params, context?: HttpContext): Observable<StrictHttpResponse<EventDto>> {
    return createEvent(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createEvent$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createEvent(params: CreateEvent$Params, context?: HttpContext): Observable<EventDto> {
    return this.createEvent$Response(params, context).pipe(
      map((r: StrictHttpResponse<EventDto>): EventDto => r.body)
    );
  }

  /** Path part for operation `getEventById()` */
  static readonly GetEventByIdPath = '/api/events/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getEventById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getEventById$Response(params: GetEventById$Params, context?: HttpContext): Observable<StrictHttpResponse<Event>> {
    return getEventById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getEventById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getEventById(params: GetEventById$Params, context?: HttpContext): Observable<Event> {
    return this.getEventById$Response(params, context).pipe(
      map((r: StrictHttpResponse<Event>): Event => r.body)
    );
  }

  /** Path part for operation `getAllFacturesForEvent()` */
  static readonly GetAllFacturesForEventPath = '/api/events/{id}/factures';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllFacturesForEvent()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllFacturesForEvent$Response(params: GetAllFacturesForEvent$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<FactureDto>>> {
    return getAllFacturesForEvent(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllFacturesForEvent$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllFacturesForEvent(params: GetAllFacturesForEvent$Params, context?: HttpContext): Observable<Array<FactureDto>> {
    return this.getAllFacturesForEvent$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<FactureDto>>): Array<FactureDto> => r.body)
    );
  }

}
