import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdzoComponent } from './edzo.component';

describe('EdzoComponent', () => {
  let component: EdzoComponent;
  let fixture: ComponentFixture<EdzoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EdzoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EdzoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
