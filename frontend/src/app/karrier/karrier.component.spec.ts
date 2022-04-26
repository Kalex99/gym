import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KarrierComponent } from './karrier.component';

describe('KarrierComponent', () => {
  let component: KarrierComponent;
  let fixture: ComponentFixture<KarrierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KarrierComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KarrierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
