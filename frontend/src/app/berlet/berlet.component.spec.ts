import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BerletComponent } from './berlet.component';

describe('BerletComponent', () => {
  let component: BerletComponent;
  let fixture: ComponentFixture<BerletComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BerletComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BerletComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
