/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { Budget } from '../models/budget';
import { createBudget } from '../fn/budget-controller/create-budget';
import { CreateBudget$Params } from '../fn/budget-controller/create-budget';
import { deleteBudget } from '../fn/budget-controller/delete-budget';
import { DeleteBudget$Params } from '../fn/budget-controller/delete-budget';
import { getBudgetById } from '../fn/budget-controller/get-budget-by-id';
import { GetBudgetById$Params } from '../fn/budget-controller/get-budget-by-id';
import { updateBudget } from '../fn/budget-controller/update-budget';
import { UpdateBudget$Params } from '../fn/budget-controller/update-budget';

@Injectable({ providedIn: 'root' })
export class BudgetControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `getBudgetById()` */
  static readonly GetBudgetByIdPath = '/budgets/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getBudgetById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getBudgetById$Response(params: GetBudgetById$Params, context?: HttpContext): Observable<StrictHttpResponse<Budget>> {
    return getBudgetById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getBudgetById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getBudgetById(params: GetBudgetById$Params, context?: HttpContext): Observable<Budget> {
    return this.getBudgetById$Response(params, context).pipe(
      map((r: StrictHttpResponse<Budget>): Budget => r.body)
    );
  }

  /** Path part for operation `updateBudget()` */
  static readonly UpdateBudgetPath = '/budgets/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateBudget()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateBudget$Response(params: UpdateBudget$Params, context?: HttpContext): Observable<StrictHttpResponse<Budget>> {
    return updateBudget(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateBudget$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateBudget(params: UpdateBudget$Params, context?: HttpContext): Observable<Budget> {
    return this.updateBudget$Response(params, context).pipe(
      map((r: StrictHttpResponse<Budget>): Budget => r.body)
    );
  }

  /** Path part for operation `deleteBudget()` */
  static readonly DeleteBudgetPath = '/budgets/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteBudget()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteBudget$Response(params: DeleteBudget$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteBudget(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteBudget$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteBudget(params: DeleteBudget$Params, context?: HttpContext): Observable<void> {
    return this.deleteBudget$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `createBudget()` */
  static readonly CreateBudgetPath = '/budgets';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createBudget()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createBudget$Response(params: CreateBudget$Params, context?: HttpContext): Observable<StrictHttpResponse<Budget>> {
    return createBudget(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createBudget$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createBudget(params: CreateBudget$Params, context?: HttpContext): Observable<Budget> {
    return this.createBudget$Response(params, context).pipe(
      map((r: StrictHttpResponse<Budget>): Budget => r.body)
    );
  }

}
