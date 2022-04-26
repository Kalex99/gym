import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FelszerelesComponent } from './felszereles.component';

describe('FelszerelesComponent', () => {
  let component: FelszerelesComponent;
  let fixture: ComponentFixture<FelszerelesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FelszerelesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FelszerelesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
