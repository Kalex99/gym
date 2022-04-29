import { TestBed } from '@angular/core/testing';

import { EdzokService } from './edzok.service';

describe('EdzokService', () => {
  let service: EdzokService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EdzokService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
