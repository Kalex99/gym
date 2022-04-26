import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BufeComponent } from './bufe.component';

describe('BufeComponent', () => {
  let component: BufeComponent;
  let fixture: ComponentFixture<BufeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BufeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BufeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
